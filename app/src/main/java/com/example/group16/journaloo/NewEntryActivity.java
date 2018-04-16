package com.example.group16.journaloo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;

public class NewEntryActivity extends AppCompatActivity {

    public String entryDescription;
    public String entryLocation;
    private APIWrapper wrapper = APIWrapper.getWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        Bitmap bmp = null;
        String filename = getIntent().getStringExtra("image");
        try {
            FileInputStream is = this.openFileInput(filename);
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView entryImageView = (ImageView) findViewById(R.id.entryImageView);
        entryImageView.setImageBitmap(bmp);

        //String path = "sdcard/camera_app/cam_image.jpg";
        //entryView.setImageDrawable(Drawable.createFromPath(path));

    }

    public void saveEntry(View view) {
        EditText descriptionEntry = (EditText) findViewById(R.id.descriptionEditEntryEditText);
        EditText locationEntry = (EditText) findViewById(R.id.locationEntryEditText);
        if (locationEntry.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Please give the entry a location", Toast.LENGTH_SHORT).show();
        } else if (descriptionEntry.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Please give the entry a description", Toast.LENGTH_SHORT).show();
        } else {
            entryLocation = locationEntry.getText().toString();
            entryDescription = descriptionEntry.getText().toString();
            Entry entryToBeCraeted = new Entry(entryLocation, entryDescription);
            wrapper.createEntry(entryToBeCraeted);
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        }
    }
}