package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientActivity extends DoubleFragmentActivity{

    private static final String TAG = "ClientActivity";

    private static final String EXTRA_CLIENT_ID = "com.bignerdranch2nded.android.personaltrainer.client_id";
    private static final String EXTRA_FRAGMENT_ID = "com.bignerdranch2nded.android.personaltrainer.fragment_id";
    private static String uniqueFragment;

    public static Intent newIntent(Context packageContext, UUID clientId, String fragmentId){
        Intent intent = new Intent(packageContext, ClientActivity.class);
        uniqueFragment = fragmentId;

        intent.putExtra(EXTRA_CLIENT_ID, clientId);
        intent.putExtra(EXTRA_FRAGMENT_ID, uniqueFragment);

        return intent;
    }

    @Override
    protected Fragment createFirstFragment(){
        return ClientDetailProfileFragment.newInstance(getClientId());
    }

    @Override
    protected Fragment createSecondFragment(){
        return ClientDetailTabsFragment.newInstance();
    }

    @Override
    protected Fragment createThirdFragment(){
        return getThirdFragment(uniqueFragment);
    }

    public UUID getClientId(){
        Log.d(TAG, "serializable will be returned to createFirstfragment()");
        return (UUID)getIntent().getSerializableExtra(EXTRA_CLIENT_ID);
    }

    public static Fragment getThirdFragment(String fragmentId){
        Fragment thirdFragment = null;
        switch (fragmentId){
            case "sessions":
                thirdFragment = ClientDetailSessionsFragment.newInstance();
                break;
            case "add session":
                thirdFragment = ClientDetailSessionsToAddSessionsFragment.newInstance();
                break;
            case "payment":
                thirdFragment = ClientDetailPaymentFragment.newInstance();
                break;
            case "receipt":
                thirdFragment = ClientDetailPaymentToReceiptFragment.newInstance();
                break;
            case "contact":
                thirdFragment = ClientDetailContact.newInstance();
        }
        return thirdFragment;
    }

    public void replaceThirdFragment(String fragmentId){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = getThirdFragment(fragmentId);

        transaction.replace(R.id.fragment_container_three, fragment).commit();

    }

}
