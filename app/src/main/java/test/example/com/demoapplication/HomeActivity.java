package test.example.com.demoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView tv_uname,tv_age;
ImageView userProfile;
RecyclerView recyclerView;
List<String> emailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        emailList=new ArrayList<>();
        emailList.add("HDFC Mail");
        emailList.add("ICICI Mail");
        emailList.add("MSD Mail");
        emailList.add("ASD Mail");

        Intent intent=getIntent();
        MyRAdapter myRAdapter =new MyRAdapter(getApplicationContext(),emailList);
        userProfile=findViewById(R.id.iv_userProfile);
        tv_uname=findViewById(R.id.tv_userName);
        tv_age=findViewById(R.id.tv_age);

        recyclerView=findViewById(R.id.rv_emailList);
        recyclerView.setAdapter(myRAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

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
