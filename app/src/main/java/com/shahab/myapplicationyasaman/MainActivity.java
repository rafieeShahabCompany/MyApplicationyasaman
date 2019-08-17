package com.shahab.myapplicationyasaman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtText = findViewById(R.id.edtText);
        Button btnSearch = findViewById(R.id.btnSearch);
        RecyclerView recycler = findViewById(R.id.recycler);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movie = edtText.getText().toString();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                String address = "http://www.omdbapi.com/swagger.json";
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(address,new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        System.out.println(response.toString());
                        Gson gson = new Gson();
                        Example ex = gson.fromJson(response.toString(),Example.class);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });
            }
        }).start();

        List<String> list = new ArrayList<>();
        list.add("");
        Adapter adapter = new Adapter(list);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));



    }
}