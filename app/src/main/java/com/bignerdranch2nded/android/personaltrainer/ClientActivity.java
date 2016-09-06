package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientActivity extends SingleFragmentActivity{

    private static final String EXTRA_CRIME_ID = "com.bignerdranch2nded.android.criminalintent.client_id";

    public static Intent newIntent(Context packageContext, UUID clientId){
        Intent intent = new Intent(packageContext, ClientActivity.class);

        intent.putExtra(EXTRA_CRIME_ID, clientId);

        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID clientId = (UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        return ClientFragment.newInstance(clientId);
    }
}
