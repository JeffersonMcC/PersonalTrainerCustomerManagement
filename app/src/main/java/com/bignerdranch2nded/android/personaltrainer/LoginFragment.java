package com.bignerdranch2nded.android.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";

    private ImageView mLoginButton;
    private EditText mUsername;
    private EditText mPassword;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginButton = (ImageView)v.findViewById(R.id.login_button);
        mUsername = (EditText)v.findViewById(R.id.username_EditText);
        mPassword = (EditText)v.findViewById(R.id.password_EditText);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            int messageResId;
            @Override
            public void onClick(View view) {
                if( mUsername.getText().toString().equals(getString(R.string.username)) &&
                        mPassword.getText().toString().equals(getString(R.string.password))){
                    Intent intent = ClientListActivity.newIntent(getActivity(), UUID.randomUUID());
                    messageResId = R.string.successful_login;
                    Toast.makeText(getContext(), messageResId, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    messageResId = R.string.unsuccessful_login;
                    Toast.makeText(getContext(), messageResId, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
