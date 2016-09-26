package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/21/2016.
 */
public class CSessionFragment extends Fragment {
    private static final String ARG_CLIENT_ID = "client-id";
    private static final String ARG_SESSION_ID = "session-id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;

    private Session mSession;

    private Button mDateButton;
    private EditText mTitleField;
    private EditText mDescriptionField;
    private CheckBox mCompletedCheckBox;

    private static final String TAG = "CSessionFragment";
    public static CSessionFragment newInstance(UUID sessionId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_SESSION_ID, sessionId);

        CSessionFragment fragment = new CSessionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        /*UUID clientId = (UUID)getArguments().getSerializable(ARG_CLIENT_ID);*/
        UUID sessionId = (UUID)getArguments().getSerializable(ARG_SESSION_ID);

        mSession = ClientLab.get(getActivity()).getSession(sessionId);
    }

    @Override
    public void onPause(){
        super.onPause();
        ClientLab.get(getActivity()).updateSession(mSession);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_session, container, false);

        mDateButton = (Button)v.findViewById(R.id.session_date_button);
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(new Date());
                dialog.setTargetFragment(CSessionFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mTitleField = (EditText)v.findViewById(R.id.session_title_edit_text);
        mTitleField.setText(mSession.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mSession.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mDescriptionField = (EditText)v.findViewById(R.id.session_description_edit_text);
        mDescriptionField.setText(mSession.getDescription());
        mDescriptionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mSession.setDescription(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCompletedCheckBox = (CheckBox)v.findViewById(R.id.session_completed_check_box);
        mCompletedCheckBox.setChecked(mSession.isCompleted());
        mCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mSession.setCompleted(isChecked);
            }
        });
        return v;
    }

}
