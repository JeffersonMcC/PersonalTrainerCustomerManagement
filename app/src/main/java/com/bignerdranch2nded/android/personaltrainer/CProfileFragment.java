package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class CProfileFragment extends Fragment {
    private static final String TAG = "CProfileFragment";
    private static final String ARG_CLIENT_ID = "client-id";

    private Client mClient;

    private EditText mNameField;

    public static CProfileFragment newInstance(UUID clientId){
        Log.d(TAG, "newInstance() started");
        Bundle args = new Bundle();

        args.putSerializable(ARG_CLIENT_ID, clientId);

        CProfileFragment fragment = new CProfileFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID clientId = (UUID)getArguments().getSerializable(ARG_CLIENT_ID);

        mClient = ClientLab.get(getActivity()).getClient(clientId);
    }

    @Override
    public void onPause(){
        super.onPause();
        ClientLab.get(getActivity()).updateClient(mClient);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_profile, container, false);

        mNameField = (EditText)v.findViewById(R.id.client_name);
        mNameField.setText(mClient.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mClient.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return v;
    }
}
