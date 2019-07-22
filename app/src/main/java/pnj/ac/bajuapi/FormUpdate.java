package pnj.ac.bajuapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pnj.ac.bajuapi.Model.Baju;
import pnj.ac.bajuapi.Model.ErrorMessage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormUpdate extends AppCompatActivity {
    private static final String TAG = "FormUpdate";
    private ApiInterface apiInterface;
    EditText etNama,etMerek,etJenis, etHarga,  etJumlah;
    Button btnSubmit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        etNama = findViewById(R.id.etFormNama);
        etMerek = findViewById(R.id.etFormMerek);
        etJenis = findViewById(R.id.etFormJenis);
        etHarga = findViewById(R.id.etFormHarga);
        etJumlah = findViewById(R.id.etFormJumlah);
        btnSubmit = findViewById(R.id.btnFormSubmit);
        btnDelete = findViewById(R.id.btnFormDelete);
        String nama = intent.getStringExtra("nama");
        String merek = intent.getStringExtra("merek");
        String jenis = intent.getStringExtra("jenis_baju");
        String harga = intent.getStringExtra("harga");
        String jumlah = intent.getStringExtra("jumlah");
        int id = intent.getIntExtra("id", 0);
        Log.d(TAG, "onCreate: gg " + intent.getStringExtra("nama"));
        Log.d(TAG, "onCreate: " + id);
        etNama.setText(nama);
        etMerek.setText(merek);
        etJenis.setText(jenis);
        etHarga.setText(harga);
        etJumlah.setText(jumlah);
        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnSubmit.setOnClickListener(view -> updateData(id, etNama.getText().toString(),(etMerek.getText().toString()),(etJenis.getText().toString()),Integer.parseInt(etHarga.getText().toString()),Integer.parseInt(etJumlah.getText().toString())));
        btnDelete.setOnClickListener(view -> deleteData(id));
    }

    private void deleteData(int id) {
        Call<ErrorMessage> data = apiInterface.hapusBaju(id);
        data.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(FormUpdate.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: jj " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(FormUpdate.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }

    private void updateData(Integer id, String nama,String merek, String jenis_baju, int harga, int jumlah_beli) {
        Call<ErrorMessage> dataCall = apiInterface.ubahBaju(id, nama, merek, jenis_baju, harga, jumlah_beli);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(FormUpdate.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(FormUpdate.this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
