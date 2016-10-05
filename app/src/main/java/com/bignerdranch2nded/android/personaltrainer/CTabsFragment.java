package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class CTabsFragment extends Fragment {
    private static final String TAG = "CTabsFragment";

    private RelativeLayout mSessionsImageView;
    private RelativeLayout mPaymentImageView;
    private RelativeLayout mContactImageView;

    private Fragment mFragment;

    public static CTabsFragment newInstance(){
        return new CTabsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_tabs, container, false);

        mSessionsImageView = (RelativeLayout) v.findViewById(R.id.session_tab_button);
        mPaymentImageView = (RelativeLayout) v.findViewById(R.id.payment_tab_button);
        mContactImageView = (RelativeLayout) v.findViewById(R.id.contact_tab_button);

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
