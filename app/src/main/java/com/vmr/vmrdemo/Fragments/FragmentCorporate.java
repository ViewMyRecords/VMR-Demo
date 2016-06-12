package com.vmr.vmrdemo.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.vmr.vmrdemo.R;


public class FragmentCorporate extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_corporate, container, false);
        Button buttonSignIn = (Button) rootView.findViewById(R.id.buttonCorpSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Sign In clicked.", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }


}
