package com.harloomdev.camerabooking;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.SignUp;

public class Register extends AppCompatActivity {
    //var UI
    private EditText mIdKtp;
    private EditText mName;
    private EditText mAddress;
    private EditText mCity;
    private EditText mDate;
    private EditText mNoHp;
    private EditText mWork;
    private EditText mPassowrd;
    private EditText mcConfirmPass;
    private Button mBtnSignup;
    private View mProgressView;
    private View mRegFormView;

    private SignUp signUp  =  new SignUp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
        backLoginbtn();
    }

    private void initUI() {
        getSpinerGender();
        mIdKtp = findViewById(R.id.id_ktp);
        mName = findViewById(R.id.rgs_nama);
        mAddress = findViewById(R.id.rgs_alamat);
        mCity = findViewById(R.id.rgs_tempatlahir);
        mDate = findViewById(R.id.rgs_tglLahir);
        mNoHp = findViewById(R.id.rgs_nohp);
        mWork = findViewById(R.id.rgs_job);
        mPassowrd = findViewById(R.id.rgs_password);
        mcConfirmPass = findViewById(R.id.rgs_confirm_password);
        mBtnSignup = findViewById(R.id.btnRegister);
        mProgressView = findViewById(R.id.register_progress);
        mRegFormView = findViewById(R.id.container_card);


    }
    private void getDataUI(){

    }


    private void attempRegistrasi(SignUp signUp) {
        TaskServiceAPI taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
        Call<ResponseBody> call = taskServiceAPI.postSignUp(signUp.getIdktp(), signUp.getNama(), signUp.getAlamat(),
                signUp.getNoHandphone(), signUp.getPekerjaan(), signUp.getJenis_kelamin(), signUp.getTanggal_lahir(),
                signUp.getTempat_lahir(), signUp.getPassword());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getSpinerGender() {
        Spinner spinnerGender = findViewById(R.id.rgs_spinGender);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Register.this, "" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void backLoginbtn() {
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
