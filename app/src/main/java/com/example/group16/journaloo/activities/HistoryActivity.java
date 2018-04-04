package com.example.group16.journaloo.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.group16.journaloo.R;
import com.example.group16.journaloo.fragments.JourneyRecyclerViewFragment;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        int userId = getIntent().getIntExtra("userId", -1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        JourneyRecyclerViewFragment frag = JourneyRecyclerViewFragment.newInstance(userId);
        fragmentTransaction.replace(R.id.fragment_container, frag);
        fragmentTransaction.commit();
    }
}
