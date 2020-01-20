package dev.manzke.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = ".DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url") &&
                getIntent().hasExtra("image_name") &&
                getIntent().hasExtra("image_message")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageMessage = getIntent().getStringExtra("image_message");

            setImage(imageUrl, imageName, imageMessage);
        }
    }
    
    private void setImage(String imageUrl, String imageName, String imageMessage){

        Log.d(TAG, "setImage: setting the image and name to widgets.");

        TextView name = findViewById(R.id.image_name);
        name.setText(imageName);
        TextView message = findViewById(R.id.image_message);
        name.setText(imageMessage);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
