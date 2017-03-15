package com.example.aloid.android_current.fragments;

import android.os.Bundle;

import com.example.aloid.android_current.R;

/**
 * Created by aloid on 3/15/2017.
 */

public class MainFragment extends android.support.v4.app.FragmentActivity {

    FragmentDescription fragmentDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            fragmentDescription = new FragmentDescription();

            fragmentDescription.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragmentDescription).commit();
        }
    }

}
