package pnj.ac.bajuapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pnj.ac.bajuapi.Model.Baju;
import pnj.ac.bajuapi.Model.DataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;
    private List<Baju> dataList = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter();
    FloatingActionButton btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleViewAdapter);
        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnFloat = findViewById(R.id.btnMainFloating);

        btnFloat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,FormActivity.class)));

        getItem();

        recycleViewAdapter.setOnClickListener(position -> {
            Baju data = dataList.get(position);
            Intent intent = new Intent(MainActivity.this, FormUpdate.class);
            intent.putExtra("nama", data.getNama());
            intent.putExtra("merek",String.valueOf(data.getMerek()));
            intent.putExtra("jenis_baju",String.valueOf(data.getJenis_baju()));
            intent.putExtra("harga", String.valueOf(data.getHarga()));
            intent.putExtra("jumlah", String.valueOf(data.getJumlah_beli()));
            intent.putExtra("id", data.getId());
            Log.d(TAG, "onCreate: " + data.getId());
            startActivity(intent);
        });
    }

    public void getItem(){
        Call<DataResponse> dataCall = apiInterface.getData();
        dataCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                List<Baju> items = response.body().getData();
                recycleViewAdapter.setDataList(items);
                dataList.addAll(items);
                Log.d(TAG, "onResponse: gg " + dataList);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycleViewAdapter.clearDataList(dataList);
        getItem();
    }
}
