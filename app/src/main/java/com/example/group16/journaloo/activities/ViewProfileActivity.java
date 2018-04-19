package com.example.group16.journaloo.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.group16.journaloo.R;
import com.example.group16.journaloo.api.APIWrapper;
import com.example.group16.journaloo.fragments.DeleteAccountConfirmationDialogFragment;
import com.example.group16.journaloo.models.User;

public class ViewProfileActivity extends AppCompatActivity {
    private APIWrapper wrapper = APIWrapper.getWrapper();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_view_profile);

        User user = wrapper.getLoggedInUser();

        TextView usernameDisplay = findViewById(R.id.username_textview);
        TextView emailDisplay = findViewById(R.id.email_textview);

        usernameDisplay.setText(user.username);
        emailDisplay.setText(user.email);

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrapper.logout(context);

                Intent intent = new Intent(ViewProfileActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        Button deleteUserButton = findViewById(R.id.delete_user_button);
        deleteUserButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DeleteAccountConfirmationDialogFragment alert =
                        new DeleteAccountConfirmationDialogFragment();
                FragmentManager fm = getFragmentManager();
                alert.show(fm, "");
            }
        });
    }

    public void editPassword(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
}
