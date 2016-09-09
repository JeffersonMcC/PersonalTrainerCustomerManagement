package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientActivity extends DoubleFragmentActivity{

    private static final String TAG = "ClientActivity";

    private static final String EXTRA_CLIENT_ID = "com.bignerdranch2nded.android.personaltrainer.client_id";
    private static final String EXTRA_FRAGMENT_ID = "com.bignerdranch2nded.android.personaltrainer.fragment_id";
    private static int uniqueFragment;

    public static Intent newIntent(Context packageContext, UUID clientId, int fragmentId){
        Intent intent = new Intent(packageContext, ClientActivity.class);
        uniqueFragment = fragmentId;

        intent.putExtra(EXTRA_CLIENT_ID, clientId);
        intent.putExtra(EXTRA_FRAGMENT_ID, uniqueFragment);

        return intent;
    }

    @Override
    protected Fragment createFirstFragment(){
        Log.d(TAG, "createFirstFragment started");
        return ClientDetailUpperHalfFragment.newInstance(getClientId());
    }

    @Override
    protected Fragment createSecondFragment(){
        Log.d(TAG, "createSecondFragment() started");
        Fragment secondFragment = null;
        switch (uniqueFragment){
            case 0:
                secondFragment = ClientDetailSessionsFragment.newInstance(getClientId());
                break;
            case 1:
                secondFragment = ClientDetailSessionsToAddSessionsFragment.newInstance(getClientId());
                break;
            case 2:
                secondFragment = ClientDetailPaymentFragment.newInstance(getClientId());
                break;
            case 3:
                secondFragment = ClientDetailPaymentToReceipt.newInstance(getClientId());
                break;
            case 4:
                secondFragment = ClientDetailContact.newInstance(getClientId());
        }

        return secondFragment;
    }

    protected UUID getClientId(){
        UUID clientId = (UUID)getIntent().getSerializableExtra(EXTRA_CLIENT_ID);
        return clientId;
    }
}
