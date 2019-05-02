package com.harloomdev.camerabooking.Activity.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {
    //var UI
    private EditText mIdKtp;
    private EditText mName;
    private EditText mAddress;
    private EditText mCity;
    private EditText mDate;
    private EditText mNoHp;
    private EditText mWork;
    private EditText mPassowrd;
    private EditText mConfirmPass;
    private Button mBtnSignup;
    private View mProgressView;
    private View mRegFormView;

    //calender
    private Calendar mCalendar;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    //Presenter
    RegisterPresenter registerPresenter ;


    //varibaleDataUI;
    String jk = "";


//    private SignUp signUp  =  new SignUp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //init
        registerPresenter  = new RegisterPresenter(this);
        initUI();
        backLoginbtn();
    }

    private void initUI() {
        getSpinerGender();
        getCalendar();
        mIdKtp = findViewById(R.id.id_ktp);
        mName = findViewById(R.id.rgs_nama);
        mAddress = findViewById(R.id.rgs_alamat);
        mCity = findViewById(R.id.rgs_tempatlahir);
        mDate = findViewById(R.id.rgs_tglLahir);
        mNoHp = findViewById(R.id.rgs_nohp);
        mWork = findViewById(R.id.rgs_job);
        mPassowrd = findViewById(R.id.rgs_password);
        mConfirmPass = findViewById(R.id.rgs_confirm_password);
        mBtnSignup = findViewById(R.id.btnRegister);
        mProgressView = findViewById(R.id.register_progress);
        mRegFormView = findViewById(R.id.container_card);


        //function
        mBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress(true);
                SignUp signUp = new SignUp();
                signUp.setIdktp(mIdKtp.getText().toString());
                signUp.setNama(mName.getText().toString());
                signUp.setAlamat(mAddress.getText().toString());
                signUp.setKota(mCity.getText().toString());
                signUp.setJenis_kelamin(jk);
                signUp.setTanggal_lahir(mDate.getText().toString());
                signUp.setPekerjaan(mWork.getText().toString());
                signUp.setNoHandphone(mNoHp.getText().toString());
                signUp.setPassword(mPassowrd.getText().toString());
                signUp.setConfimPassword(mConfirmPass.getText().toString());
                registerPresenter.attempRegistrasi(signUp);

            }
        });


    }



    private void getSpinerGender() {

        Spinner spinnerGender = findViewById(R.id.rgs_spinGender);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegisterActivity.this, "" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                jk = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void getCalendar(){
        mDate.setOnClickListener(onDatePickerView);

        mCalendar = Calendar.getInstance();
        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mCalendar.set(Calendar.YEAR,year);
                mCalendar.set(Calendar.MONTH,month);
                mCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateCalender();
            }
        };

    }

    private void updateCalender(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        mDate.setText(sdf.format(mCalendar.getTime()));

    }
    private View.OnClickListener onDatePickerView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DatePickerDialog(v.getContext(),mOnDateSetListener,mCalendar.get(Calendar.YEAR),mCalendar.get(Calendar.MONTH),
                    mCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    } ;

    private void backLoginbtn() {
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




    @Override
    public void onRegisterSuccess(ResponOther respon) {
        Toast.makeText(this, respon.getMassage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        Toast.makeText(this,error.getMassage(),Toast.LENGTH_SHORT).show();
        showProgress(false);
    }

    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mRegFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mRegFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mRegFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mRegFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}
