package com.harloomdev.camerabooking;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.harloomdev.camerabooking.Activity.Login.IloginView;
import com.harloomdev.camerabooking.Activity.Login.LoginPresenter;
import com.harloomdev.camerabooking.Activity.Login.Mlogin;
import com.harloomdev.camerabooking.Activity.Register.RegisterActivity;
import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.KeyAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  implements IloginView {
    private SharedPreferences mSharedPreferences ;

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private Boolean mAuthTask = null;

    // UI references.
    private EditText mId;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private Mlogin mlogin = new Mlogin();
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        loginPresenter = new LoginPresenter(this,this);
        // Set up the login form.
        mId = (EditText) findViewById(R.id.id_ktp);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLoginView();
                    return true;
                }
                return false;
            }
        });

        FloatingActionButton mSignInButton = (FloatingActionButton) findViewById(R.id.btnLogin);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLoginView();
            }
        });


        findViewById(R.id.labelLogin).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnRegister).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =new Intent(getBaseContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        mLoginFormView = findViewById(R.id.container_login);
        mProgressView = findViewById(R.id.login_progress);
    }


    private void attemptLoginView() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mId.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String id = mId.getText().toString();
        String password = mPasswordView.getText().toString();
        boolean cancel = false;
        View focusView = null;
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !mlogin.isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(id)) {
            mId.setError(getString(R.string.error_field_required));
            focusView = mId;
            cancel = true;
        } else if (!mlogin.isIdValid(id)) {
            mId.setError(getString(R.string.error_invalid_email));
            focusView = mId;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mlogin.setId_ktp(id);
            mlogin.setPassword(password);
            loginPresenter.sendAPI(mlogin);

        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
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
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onLoginSuccess(KeyAPI respon) {
        Toast.makeText(this, respon.getKeyAPI()
                , Toast.LENGTH_SHORT).show();
        showProgress(false);
    }

    @Override
    public void onRLoginError(String massage) {
                Toast.makeText(LoginActivity.this, massage, Toast.LENGTH_SHORT).show();
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
        showProgress(false);

    }

    @Override
    public void onAPIError(ResponOther error) {
        Toast.makeText(this, error.getStatusCode() +":" +error.getMassage(), Toast.LENGTH_SHORT).show();
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
        showProgress(false);
    }
}

