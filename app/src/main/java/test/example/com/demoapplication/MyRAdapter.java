package test.example.com.demoapplication;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRAdapter extends RecyclerView.Adapter<MyRAdapter.MyHolder> {

    private final Context ctx;
    List<String> mylist;
    public MyRAdapter(@NonNull Context context, List<String> mylist) {
        this.ctx=context;
        this.mylist=mylist;
    }
    //step 1:- we need to create single row xml  view  then we have to add it to Holder
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //step 2:- Creating View from Single row xml
        View view=LayoutInflater.from(ctx).inflate(R.layout.single_row,viewGroup,false);
        //step 3:- adding Created View to Holder so we can update ui
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i1) {
        //it will iterate mylist and set the list data into tv_email for each row
        myHolder.tv_email.setText(mylist.get(i1));
    }

    @Override
    public int getItemCount() {
        return mylist.size(); //4
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_email;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //step 4:- getting the inner Views like TextView and creating View Resource Object
         tv_email= itemView.findViewById(R.id.tv_email);
        }
    }
}
