package com.example.hex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;



public class ProfileActivity extends AppCompatActivity {

    TextView textVClic;

    // firebase auth
    FirebaseAuth firebaseAuth;

    //viwes
   // TextView mProfileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textVClic = findViewById(R.id.clickable_text_view);

        //init
        firebaseAuth = FirebaseAuth.getInstance();

        textVClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TextViewClicked();
            }
        });

        //init views
       // mProfileTv = findViewById(R.id.profileTv);


    }

    public void TextViewClicked() {
        ViewSwitcher switcher = (ViewSwitcher) findViewById(R.id.my_switcher);
        switcher.showNext(); //or switcher.showPrevious();
        TextView myTV = (TextView) switcher.findViewById(R.id.clickable_text_view);
        myTV.setText("value");
    }

    private void checkUserStatus(){
        // get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            // user is signed in stay here
            // set email of logged in user
       //     mProfileTv.setText(user.getEmail());
        }
        else{
            //user not signed in, go to main activity
            startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        // check on start of app
        checkUserStatus();
        super.onStart();
    }
}
