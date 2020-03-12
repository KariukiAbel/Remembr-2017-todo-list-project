package com.myapp.user.smyl.remembr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nabesh-riska on 5/4/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

private List<dataModel> objectlist;
private LayoutInflater inflater;
    public MyAdapter(Context context,List<dataModel> objectlist){
        inflater=LayoutInflater.from(context);
        this.objectlist=objectlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
dataModel current =objectlist.get(position);
      holder.setData(current,position);
    }


    @Override
    public int getItemCount() {
        return objectlist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,app,date,time;
        private int position;
        private ImageView img_del,img_edit;
        private dataModel currentObject;

        public MyViewHolder(View itemView) {

            super(itemView);

            title=(TextView) itemView.findViewById(R.id.tvTitle);
            app=(TextView) itemView.findViewById(R.id.tvApp);
            date=(TextView) itemView.findViewById(R.id.tvDate);
            time=(TextView) itemView.findViewById(R.id.tvTime);

        }

        public void setData(dataModel currentObject, int position) {
            this.title.setText(currentObject.getTitle());
            this.app.setText(currentObject.getApp());
            this.date.setText((int) currentObject.getDate());
            this.time.setText(currentObject.getTime());
//            this.img_del.setImageResource(currentObject.getImageID());
            this.position=position;
            this.currentObject=currentObject;
        }
    }
}
