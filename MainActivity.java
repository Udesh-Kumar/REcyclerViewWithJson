package com.example.cc.recyclerviewwithjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
MainActivity extends AppCompatActivity {
    List<ModalClass> modalClassList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        ApiService apiService=ApiClient.getRetrofit().create(ApiService.class);

        Call<List<ModalClass>> call=apiService.getMovies();

        call.enqueue(new Callback<List<ModalClass>>() {
            @Override
            public void onResponse(Call<List<ModalClass>> call, Response<List<ModalClass>> response)
            {

                if (response.isSuccessful())
                {
                    modalClassList=response.body();

                 ModalClass modalClass=new ModalClass();

                 modalClass.setTitle("Hii");
                 modalClass.setImageUrl(String.valueOf(R.drawable.ic_launcher_background));

                 modalClassList.add(modalClass);

                    recyclerAdapter=new RecyclerViewAdapter(getApplicationContext(),modalClassList);

                    recyclerView.setAdapter(recyclerAdapter);


                }



            }

            @Override
            public void onFailure(Call<List<ModalClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t+"Error", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
