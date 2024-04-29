package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";

    ArrayList<mountain> mountains = new ArrayList<>();

    Gson gson = new Gson();

    String json = gson.toJson(mountains);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {

        Log.d("MainActivity", json);

        Type type = new TypeToken<ArrayList<mountain>>() {}.getType();
        ArrayList<mountain> mountains = gson.fromJson(json, type);

        RecyclerView recycler_view = findViewById(R.id.recycler_view);

        mountain_RecyclerViewAdapter adapter = new mountain_RecyclerViewAdapter(this, mountains);
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

}
