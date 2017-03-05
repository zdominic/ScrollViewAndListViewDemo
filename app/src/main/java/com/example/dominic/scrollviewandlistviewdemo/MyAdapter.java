package com.example.dominic.scrollviewandlistviewdemo;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dominic on 2017/3/5.
 */

public class MyAdapter extends BaseAdapter{


    private final Context mApplicationContext;
    private final List<String> mStringList;

    public MyAdapter(Context applicationContext, List<String> stringList) {

        mApplicationContext = applicationContext;
        mStringList = stringList;
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            TextView textView = new TextView(mApplicationContext);
            textView.setText(mStringList.get(position));
            textView.setTextColor(Color.BLUE);
            convertView = textView;
        }

        return convertView;


    }
}
