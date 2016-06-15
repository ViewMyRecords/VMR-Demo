package com.vmr.vmrdemo.LoginFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.vmr.vmrdemo.HomeActivity;
import com.vmr.vmrdemo.R;


public class FragmentFamily extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_family, container, false);

        final EditText etEmail = (EditText) rootView.findViewById(R.id.etFamilyEmail);
        final EditText etPassword = (EditText) rootView.findViewById(R.id.etFamilyPassword);
        final EditText etFamilyId = (EditText) rootView.findViewById(R.id.etFamilyID);
        CheckBox cbRememberMe = (CheckBox) rootView.findViewById(R.id.cbFamilyRememberPassword);
        Button buttonSignIn = (Button) rootView.findViewById(R.id.btnFamilySignIn);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.getText().toString().equals("abhijit@vmr.com")
                        && etPassword.getText().toString().equals("password")
                        && etFamilyId.getText().toString().equals("12345")) {
                    Intent homeIntent = new Intent(getContext(), HomeActivity.class);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(getActivity(), "Invalid Username or Password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }


}
