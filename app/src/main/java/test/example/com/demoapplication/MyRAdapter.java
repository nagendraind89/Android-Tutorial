package test.example.com.demoapplication;


import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRAdapter extends RecyclerView.Adapter<MyRAdapter.MyHolder> {

    private final Context ctx;
    List<String> mnames,mimages;
    public MyRAdapter(@NonNull Context context, List<String> mnames, List<String> mimages) {
        this.ctx=context;
        this.mnames=mnames;
        this.mimages=mimages;
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
    public void onBindViewHolder(@NonNull MyHolder holder, final int postion) {
        //it will iterate mylist and set the list data into tv_email for each row
        holder.tv_email.setText(mnames.get(postion));
        Picasso.get().load(mimages.get(postion)).into(holder.imageView);

        holder.btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Clicked button Of Position ::"+postion+""+mnames.get(postion));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mnames.size(); //4
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_email;
        Button btn_show;
        ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //step 4:- getting the inner Views like TextView and creating View Resource Object
         tv_email= itemView.findViewById(R.id.tv_email);
         imageView= itemView.findViewById(R.id.img);
         btn_show=itemView.findViewById(R.id.btn_show);
        }
    }
}
