package com.example.aloid.android_current.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aloid.android_current.fragments.MainFragment;
import com.example.aloid.android_current.managers.DataManager;
import com.example.aloid.android_current.adapters.ListAdapter;
import com.example.aloid.android_current.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    EditText editText;
    ListView listView;
    ListAdapter listAdapter;
    Button button, buttondel;


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);
        button = (Button)findViewById(R.id.main_badd);
        buttondel = (Button)findViewById(R.id.main_bdel);
        editText = (EditText)findViewById(R.id.main_itext);

        listAdapter = new ListAdapter(this, DataManager.getInstance().getPenguins());
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);

        button.setOnClickListener(this);
        buttondel.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.main_badd:
                DataManager.getInstance().setPenguin(editText.getText().toString());

                editText.setText(null);

                refreshList();
                break;
            case R.id.main_bdel:
                DataManager.getInstance().delPenguin();
                refreshList();
                break;
        }
    }

    public void refreshList(){
        listAdapter.notifyDataSetChanged();
        listView.refreshDrawableState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MainFragment.class);
                intent.putExtra("Position",position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
    }

}
