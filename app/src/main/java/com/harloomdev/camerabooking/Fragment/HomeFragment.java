package com.harloomdev.camerabooking.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Chart.CekAcivity;
import com.harloomdev.camerabooking.Activity.Product.ProductActivity;
import com.harloomdev.camerabooking.Fragment.Account.IProfileView;
import com.harloomdev.camerabooking.Fragment.Account.ProfilePresenter;
import com.harloomdev.camerabooking.Http.conf.API.Model.Profile.Profile;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements IProfileView {

    private TextView main_nametxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.f_home,container,false
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        main_nametxt = view.findViewById(R.id.main_name);


        view.findViewById(R.id.btn_menuProduct).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , ProductActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btn_chart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , CekAcivity.class);
                startActivity(intent);
            }
        });


        //presenter
        ProfilePresenter presenter = new ProfilePresenter(view.getContext(), this);
        Preferences preferences  = new Preferences(view.getContext());
        String s  = preferences.getIDKTP();
        presenter.getAPIData(s);

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
        main_nametxt.setText(data.getNama());

    }

    @Override
    public void onGetResourceError(String massage) {
        Toast.makeText(getContext(), massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        Toast.makeText(getContext(), error.getStatusCode() + " : "+ error.getMassage(), Toast.LENGTH_SHORT).show();

    }
}
