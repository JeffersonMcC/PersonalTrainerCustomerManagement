package com.bignerdranch2nded.android.personaltrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;

/**
 * Created by Jeffrow on 9/7/2016.
 */
public class ClientDetailSessionsFragment extends Fragment {
    public static final String TAG = "ClientDetailSessionsFragment";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Client mClient;

    private Button mAddSessionButton;

    public static ClientDetailSessionsFragment newInstance(){
        return new ClientDetailSessionsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_sessions, container, false);

        mAddSessionButton = (Button)v.findViewById(R.id.add_session_button);
//        updateDate();
        mAddSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mClient.getSessionDate());
                dialog.setTargetFragment(ClientDetailSessionsFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK){
            return;
        }

        if(requestCode == REQUEST_DATE){
            Date date = (Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mClient.setSessionDate(date);
            updateDate();
        }
    }

    private void updateDate(){
        Log.d(TAG, "getSessionDate about to be started");
        //mAddSessionButton.setText(mClient.getSessionDate().toString());
    }
}
