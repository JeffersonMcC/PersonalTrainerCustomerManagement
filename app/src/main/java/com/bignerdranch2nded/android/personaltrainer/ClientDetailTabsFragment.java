package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailTabsFragment extends Fragment {
    private static final String TAG = "ClientDetailTabsFragment";

    private ImageView mSessionsImageView;
    private ImageView mPaymentImageView;
    private ImageView mContactImageView;

    public static ClientDetailTabsFragment newInstance(){
        return new ClientDetailTabsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_tabs, container, false);

        mSessionsImageView = (ImageView)v.findViewById(R.id.sessions_icon_image_view);
        mPaymentImageView = (ImageView)v.findViewById(R.id.payment_icon_image_view);
        mContactImageView = (ImageView)v.findViewById(R.id.contact_icon_image_view);

        mSessionsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Sessions button was pressed");
                ClientDetailThirdFragmentManager.getThirdFragment("sessions");
            }
        });

        mPaymentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Payment button was pressed");
                ClientDetailThirdFragmentManager.getThirdFragment("payment");
            }
        });

        mContactImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Contact button was pressed");
                ClientDetailThirdFragmentManager.getThirdFragment("contact");
            }
        });

        return v;
    }
}
