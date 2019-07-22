package pnj.ac.bajuapi;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pnj.ac.bajuapi.Model.ErrorMessage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    private static final String TAG = "FormActivity";
    private ApiInterface apiInterface;
    EditText etNama, etHarga, etMerek,etJenis, etJumlah;
    Button btnSubmit,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNama = findViewById(R.id.etFormNama);
        etMerek = findViewById(R.id.etFormMerek);
        etJenis = findViewById(R.id.etFormJenis);
        etHarga = findViewById(R.id.etFormHarga);
        etJumlah = findViewById(R.id.etFormJumlah);
        btnSubmit = findViewById(R.id.btnFormSubmit);
        btnDelete = findViewById(R.id.btnFormDelete);
        btnDelete.setVisibility(View.INVISIBLE);

        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnSubmit.setOnClickListener(view -> addData(etNama.getText().toString(),
                (etMerek.getText().toString()),(etJenis.getText().toString()),
                Integer.parseInt(etHarga.getText().toString()),Integer.parseInt(etJumlah.getText().toString())));
    }
    public void addData(String nama, String merek, String jenis_baju, Integer harga, Integer jumlah_beli){
        Call<ErrorMessage> dataCall = apiInterface.tambahBaju(nama,merek,jenis_baju,harga,jumlah_beli);
       dataCall.enqueue(new Callback<ErrorMessage>() {
           @Override
           public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {

           }

           @Override
           public void onFailure(Call<ErrorMessage> call, Throwable t) {

           }
       });
    }
}
