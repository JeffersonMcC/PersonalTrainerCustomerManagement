package com.bignerdranch2nded.android.personaltrainer;

import android.support.v4.app.Fragment;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailThirdFragmentManager extends Fragment {

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

}
