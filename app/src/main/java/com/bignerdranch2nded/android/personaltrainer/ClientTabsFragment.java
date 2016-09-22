package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientTabsFragment extends Fragment {
    private static final String TAG = "ClientTabsFragment";

    private ImageView mSessionsImageView;
    private ImageView mPaymentImageView;
    private ImageView mContactImageView;

    private Fragment mFragment;

    public static ClientTabsFragment newInstance(){
        return new ClientTabsFragment();
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
                ((ClientActivity)getActivity()).replaceThirdFragment(0);
            }
        });

        mPaymentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClientActivity)getActivity()).replaceThirdFragment(1);
            }
        });

        mContactImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClientActivity)getActivity()).replaceThirdFragment(2);
            }
        });

        return v;
    }

}
