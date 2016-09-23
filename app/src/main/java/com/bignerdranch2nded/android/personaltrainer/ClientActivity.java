package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientActivity extends DoubleFragmentActivity{

    private static final String TAG = "ClientActivity";

    private static final String EXTRA_CLIENT_ID = "com.bignerdranch2nded.android.personaltrainer.client_id";
    private static final String EXTRA_FRAGMENT_ID = "com.bignerdranch2nded.android.personaltrainer.fragment_id";

    private List<Client> mClients;
    private static final int[] sThirdFragPages = {0, 1, 2, 3 ,4};
    private int thirdFragPos = 0;

    public static Intent newIntent(Context packageContext, UUID clientId){
        Intent intent = new Intent(packageContext, ClientActivity.class);


        intent.putExtra(EXTRA_CLIENT_ID, clientId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        UUID clientId = (UUID)getIntent().getSerializableExtra(EXTRA_CLIENT_ID);

    }

    @Override
    protected Fragment createFirstFragment(){
        return CProfileFragment.newInstance(getClientId());
    }

    @Override
    protected Fragment createSecondFragment(){
        return CTabsFragment.newInstance();
    }

    @Override
    protected Fragment createThirdFragment(){
        return getThirdFragment(0);
    }

    public UUID getClientId(){
        return (UUID)getIntent().getSerializableExtra(EXTRA_CLIENT_ID);
    }

    public static Fragment getThirdFragment(int fragId){
        Fragment thirdFragment = null;
        switch (fragId){
            case 0:    //sessions
                thirdFragment = CSessionsListFragment.newInstance();
                break;
            case 1: //payment
                thirdFragment = CPaymentFragment.newInstance();
                break;
            case 2: //contact
                thirdFragment = ClientContact.newInstance();
                break;
            case 3: //add sessions
                thirdFragment = CSessionsListFragment.newInstance();
                break;
            case 4: //receipt
                thirdFragment = CPaymentToReceiptFragment.newInstance();
        }
        return thirdFragment;
    }

    public void replaceThirdFragment(int fragmentId){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = getThirdFragment(fragmentId);

        transaction.replace(R.id.fragment_container_three, fragment).commit();

    }

}