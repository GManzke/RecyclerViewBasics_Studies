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
        mImageUrls.add("https://i.imgur.com/QJ2XxDe.jpg");
        mNames.add("Pedro Lucas");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/HXQOv9Q.jpg");
        mNames.add("Pedro Lucas 2");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/4Hr2s5C.jpg");
        mNames.add("Pedro Lucas 3");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/lvxTpZo.jpg");
        mNames.add("Pedro Lucas 4");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/41vgGOa.jpg");
        mNames.add("Pedro Lucas 5");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/QJ2XxDe.jpg");
        mNames.add("Pedro Lucas 6");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/HXQOv9Q.jpg");
        mNames.add("Pedro Lucas 7");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/4Hr2s5C.jpg");
        mNames.add("Pedro Lucas 8");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/lvxTpZo.jpg");
        mNames.add("Pedro Lucas 9");
        mMessage.add("Me nota pf");
        mImageUrls.add("https://i.imgur.com/41vgGOa.jpg");
        mNames.add("Pedro Lucas 10");
        mMessage.add("Me nota pf");

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
        startActivity(intent);
        Toast.makeText(this, "FUNCIONOU: " + mNames.get(position), Toast.LENGTH_SHORT).show();
    }
}