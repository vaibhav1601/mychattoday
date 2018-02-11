package com.application.chat.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.chat.myapplication.R;
import com.application.chat.myapplication.model.User;

import java.util.ArrayList;
/**
 * Created by vaibhav on 11/2/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>
{
    private ArrayList<User> users;

    public DataAdapter(ArrayList<User> users)
    {
        this.users = users;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(users.get(i).getA());
        viewHolder.tv_version.setText(users.get(i).getL());
        viewHolder.tv_api_level.setText(users.get(i).getM());
    }

    @Override
    public int getItemCount() {
         return users.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }

}
