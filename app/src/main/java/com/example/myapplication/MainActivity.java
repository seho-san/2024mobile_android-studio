package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface api;
    Button btn;
    TextView txt;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            api = RetrofitClient.getRetrofit().create(ApiInterface.class);
            editText = (EditText) findViewById(R.id.editTextText);
            btn = (Button) findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Data data = new Data();
                    data.setText(editText.getText().toString());
                    api.postData(data).enqueue(new Callback<Data>() {
                        //서버에 데이터 보내는 코드
                        //큐잉의 형태
                        //실제로 날라가는 코드는 비동기식
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            if(response.isSuccessful()){
                                txt.setText(response.body().getResult());
                            }
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {

                        }
                    });
                }
            });
        }
    }
