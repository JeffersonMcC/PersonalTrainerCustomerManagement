package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailProfileFragment extends Fragment {
    private static final String ARG_CLIENT_ID = "client-id";
    private Client mClient;

    public static ClientDetailProfileFragment newInstance(UUID clientId){
        Bundle args = new Bundle();

        args.putSerializable(ARG_CLIENT_ID, clientId);

        ClientDetailProfileFragment fragment = new ClientDetailProfileFragment();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_profile, container, false);

        return v;
    }
}
