package com.example.group16.journaloo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.group16.journaloo.R;
import com.example.group16.journaloo.api.APIWrapper;

public class ExploreActivity extends AppCompatActivity {

    private APIWrapper wrapper = APIWrapper.getWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
    }
}



