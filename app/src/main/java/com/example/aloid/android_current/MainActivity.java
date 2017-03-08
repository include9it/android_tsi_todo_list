package com.example.aloid.android_current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    ListView listView;
    ListAdapter listAdapter;
    Button button, buttondel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);
        button = (Button)findViewById(R.id.main_badd);
        buttondel = (Button)findViewById(R.id.main_bdel);
        editText = (EditText)findViewById(R.id.main_itext);

        listAdapter = new ListAdapter(this,DataManager.getInstance().getNames());
        listView.setAdapter(listAdapter);

        button.setOnClickListener(this);
        buttondel.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.main_badd:
                DataManager.getInstance().setName(editText.getText().toString());
                editText.setText("");
                refreshList();
                break;
            case R.id.main_bdel:
                refreshList();
                buttondel.setText("OK");
                break;
        }
    }


    public void refreshList(){
        listAdapter.notifyDataSetChanged();
        listView.refreshDrawableState();
    }

}
