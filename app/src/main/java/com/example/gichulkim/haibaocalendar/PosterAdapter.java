package com.example.gichulkim.haibaocalendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PosterAdapter extends BaseAdapter {
    //context= activity의 this

    Context context;
    ArrayList<Poster> data;

    PosterAdapter(Context context,ArrayList<Poster> data){
        this.context=context;
        this.data=data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView =View.inflate(context,R.layout.title,null);
        }
        TextView e1=(TextView)convertView.findViewById(R.id.textView);

        Poster one=data.get(position);

        e1.setText(one.getTheme());


        return convertView;
    }
}

