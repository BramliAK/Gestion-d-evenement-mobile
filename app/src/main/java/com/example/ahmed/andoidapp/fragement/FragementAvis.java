package com.example.ahmed.andoidapp.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.andoidapp.R;

/**
 * Created by ahmed on 24/11/2018.
 */

public class FragementAvis extends Fragment {

    View view;

    public FragementAvis(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.avis_fragement,container,false);
        return view;
    }
}
