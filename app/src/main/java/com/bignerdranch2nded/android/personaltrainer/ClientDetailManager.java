package com.bignerdranch2nded.android.personaltrainer;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailManager extends Fragment {

    public static Fragment getThirdFragment(int fragmentId, UUID clientId){
        Fragment thirdFragment = null;
        switch (fragmentId){
            case 0:
                thirdFragment = ClientDetailSessionsFragment.newInstance(clientId);
                break;
            case 1:
                thirdFragment = ClientDetailSessionsToAddSessionsFragment.newInstance(clientId);
                break;
            case 2:
                thirdFragment = ClientDetailPaymentFragment.newInstance(clientId);
                break;
            case 3:
                thirdFragment = ClientDetailPaymentToReceiptFragment.newInstance(clientId);
                break;
            case 4:
                thirdFragment = ClientDetailContact.newInstance(clientId);
        }
        return thirdFragment;
    }

}
