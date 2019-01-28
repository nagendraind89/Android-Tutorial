package test.example.com.demoapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    TextView tv_uname,tv_age;
ImageView userProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent=getIntent();
userProfile=findViewById(R.id.iv_userProfile);
        tv_uname=findViewById(R.id.tv_userName);
        tv_age=findViewById(R.id.tv_age);

        if (intent!=null){

            String userName=intent.getStringExtra("UName");
            String url=intent.getStringExtra("UserImageUrl");
            Picasso.get().load(url).into(userProfile);
              int age=intent.getIntExtra("Age",0);
             tv_uname.setText("Hi Mr."+userName);
             tv_age.setText("You are "+age+" Years Old.");
        }
    }
}
