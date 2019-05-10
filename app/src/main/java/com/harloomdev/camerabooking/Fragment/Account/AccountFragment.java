package com.harloomdev.camerabooking.Fragment.Account;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Product.IProductView;
import com.harloomdev.camerabooking.Http.conf.API.Model.Profile.Profile;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment implements IProfileView {
    private Context context = null;

    private TextView mNameProfile;
    private TextView mTextMessage;
    private ProfilePresenter mpPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.f_account,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextMessage = (TextView) view.findViewById(R.id.message);
        mTextMessage.setText(R.string.title_profile);
        mNameProfile = (TextView) view.findViewById(R.id.profile_nama) ;
        context = view.getContext();


        //presenter
        mpPresenter = new ProfilePresenter(view.getContext(),this);
        Preferences preferences = new Preferences(view.getContext());
        String s  = preferences.getIDKTP();
        mpPresenter.getAPIData(s);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onGetResourceSuccess(Profile data) {
        if(context!=null){
            mNameProfile.setText(data.getNama());
        }

    }

    @Override
    public void onGetResourceError(String massage) {
        if(context!=null){
            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAPIError(ResponOther error) {
        if(context!=null){
            Toast.makeText(context,error.getStatusCode() + " : " + error.getMassage(), Toast.LENGTH_SHORT).show();
        }

    }
}
