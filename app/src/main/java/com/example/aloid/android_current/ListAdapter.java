package com.example.aloid.android_current;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aloid on 3/7/2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arrayList;

    public ListAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_fill, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.tmain_list_fill);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cbmain_list_fill);


        textView.setText(arrayList.get(position));

        return convertView;
    }
}
