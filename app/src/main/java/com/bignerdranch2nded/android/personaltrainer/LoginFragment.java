package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
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

    private View v;

    private EditText mUsername;
    private EditText mPassword;
    private ImageView mLoginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_login, container, false);

        mUsername = (EditText)v.findViewById(R.id.username_EditText);
        mPassword = (EditText)v.findViewById(R.id.password_EditText);
        mLoginButton = (ImageView)v.findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {

            int messageResId;
            @Override
            public void onClick(View view) {
                Intent intent = ClientListActivity.newIntent(getActivity(), UUID.randomUUID());
                startActivity(intent);
                /*
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
                */
            }
        });


        return v;
    }

    @Override
    public void onStop(){
        super.onStop();

        mUsername.getText().clear();
        mPassword.getText().clear();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);


    }
}
