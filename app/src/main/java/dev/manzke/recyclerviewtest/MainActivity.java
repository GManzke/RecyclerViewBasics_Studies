package dev.manzke.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mMessage = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");
        mImageUrls.add("https://i.redd.it/xob7iy25rez01.jpg");
        mNames.add("Teste");
        mMessage.add("Teste 2");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mMessage, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("image_url", mImageUrls.get(position));
        intent.putExtra("image_name", mNames.get(position));
        intent.putExtra("image_message", mMessage.get(position));

        startActivity(intent);
        Toast.makeText(this, "FUNCIONOU: " + mNames.get(position), Toast.LENGTH_SHORT).show();
    }
}