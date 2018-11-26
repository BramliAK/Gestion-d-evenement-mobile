package com.example.ahmed.andoidapp.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.andoidapp.R;

/**
 * Created by ahmed on 24/11/2018.
 */

public class FragementResume extends Fragment {

    View view;
     TextView textView;
    public FragementResume(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle b=getArguments();
        Log.i("test",b.getString("edttext"));
        String strtext = getArguments().getString("edttext");


        view=inflater.inflate(R.layout.resumer_fragment,container,false);
        TextView textView = (TextView)view.findViewById(R.id.fragres);
        textView.setText(strtext);
        return view;
    }
}
