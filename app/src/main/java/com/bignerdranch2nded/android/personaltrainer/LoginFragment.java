package com.bignerdranch2nded.android.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class LoginFragment extends Fragment {

    private ImageView mLoginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginButton = (ImageView)v.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CListActivity.newIntent(getActivity(), UUID.randomUUID());
                startActivity(intent);
            }
        });
        return v;
    }

}
