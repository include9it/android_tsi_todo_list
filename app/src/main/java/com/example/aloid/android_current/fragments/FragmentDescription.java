package com.example.aloid.android_current.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aloid.android_current.R;
import com.example.aloid.android_current.managers.DataManager;

/**
 * Created by aloid on 3/15/2017.
 */

public class FragmentDescription extends Fragment {

    int position;

    EditText editText;
    Button bDelete, bShare;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.description_fragment,container,false);

        position = getArguments().getInt("Position");

        editText = (EditText)view.findViewById(R.id.fragment_description_text);
        bDelete = (Button)view.findViewById(R.id.fragment_description_delete);
        bShare = (Button)view.findViewById(R.id.fragment_description_share);

        editText.setText(DataManager.getInstance().getPenguins().get(position).getDescription());

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.fragment_description_delete){
                    editText.setText(null);
                    DataManager.getInstance().delDescription(position);
                }
            }
        });

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.fragment_description_share){
                    Toast.makeText(getActivity(), "Note: " + position + "Coming Soon!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                DataManager.getInstance().changeDescription(position,editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                DataManager.getInstance().changeDescription(position,editText.getText().toString());
            }
        });

        return view;
    }

}

