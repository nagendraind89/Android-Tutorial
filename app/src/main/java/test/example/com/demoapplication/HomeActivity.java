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
List<String> mnames,mimages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mnames=new ArrayList<>();
        mnames.add("ABC");
        mnames.add("ICICI");
        mnames.add("MSD ");
        mnames.add("ASD ");


        mimages=new ArrayList<>();
        mimages.add("https://www.gannett-cdn.com/-mm-/2f302bb40a0c97111c68dad3332b97624a4a8f7d/c=0-216-2592-3672/local/-/media/2016/03/15/USATODAY/USATODAY/635936466460684852-E01-INDY-BILLBOARD-A-23-20418839.JPG?width=534&height=712&fit=crop");
        mimages.add("https://www.gannett-cdn.com/-mm-/2f302bb40a0c97111c68dad3332b97624a4a8f7d/c=0-216-2592-3672/local/-/media/2016/03/15/USATODAY/USATODAY/635936466460684852-E01-INDY-BILLBOARD-A-23-20418839.JPG?width=534&height=712&fit=crop");
        mimages.add("https://www.gannett-cdn.com/-mm-/2f302bb40a0c97111c68dad3332b97624a4a8f7d/c=0-216-2592-3672/local/-/media/2016/03/15/USATODAY/USATODAY/635936466460684852-E01-INDY-BILLBOARD-A-23-20418839.JPG?width=534&height=712&fit=crop ");
        mimages.add("https://www.gannett-cdn.com/-mm-/2f302bb40a0c97111c68dad3332b97624a4a8f7d/c=0-216-2592-3672/local/-/media/2016/03/15/USATODAY/USATODAY/635936466460684852-E01-INDY-BILLBOARD-A-23-20418839.JPG?width=534&height=712&fit=crop ");
        Intent intent=getIntent();
        MyRAdapter myRAdapter =new MyRAdapter(HomeActivity.this,mnames,mimages);
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
