package com.bignerdranch2nded.android.personaltrainer;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailThirdFragmentManager extends Fragment {

    public static Fragment getThirdFragment(int fragmentId){
        Fragment thirdFragment = null;
        switch (fragmentId){
            case 0:
                thirdFragment = ClientDetailSessionsFragment.newInstance();
                break;
            case 1:
                thirdFragment = ClientDetailSessionsToAddSessionsFragment.newInstance();
                break;
            case 2:
                thirdFragment = ClientDetailPaymentFragment.newInstance();
                break;
            case 3:
                thirdFragment = ClientDetailPaymentToReceiptFragment.newInstance();
                break;
            case 4:
                thirdFragment = ClientDetailContact.newInstance();
        }
        return thirdFragment;
    }

}
