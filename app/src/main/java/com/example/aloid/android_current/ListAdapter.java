package com.example.aloid.android_current;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aloid on 3/7/2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Penguins> penguinList;

    public ListAdapter(Context context, ArrayList<Penguins> penguinList) {
        this.context = context;
        this.penguinList = penguinList;
    }

    @Override
    public int getCount() {
        return penguinList.size();
    }

    @Override
    public Object getItem(int position) {
        return penguinList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_fill, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.tmain_list_fill);
        final CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.cbmain_list_fill);

        textView.setText(penguinList.get(position).getName());
        checkBox.setChecked(penguinList.get(position).isCheck());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()==true){
                    DataManager.getInstance().setCheckPenguin(position,true);
                }else if(checkBox.isChecked()==false){
                    DataManager.getInstance().setCheckPenguin(position,false);
                }
            }
        });

        return convertView;
    }
}
