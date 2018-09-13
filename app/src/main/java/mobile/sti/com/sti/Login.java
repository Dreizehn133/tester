package mobile.sti.com.sti;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {
    //    @BindView(R.id.rel1)RelativeLayout rel1;
//    @BindView(R.id.rel2)RelativeLayout rel2;
//    @BindView(R.id.imgLogos)
//    ImageView logo;
    @BindView(R.id.etEmail)
    EditText email;
    @BindView(R.id.etPass)
    EditText pass;

    @OnClick(R.id.btnSignUp)
    void SignUP() {
        v = inflater.from(Login.this).inflate(R.layout.signup_layout, null);
        Button btnDaftar = v.findViewById(R.id.btnSignUpDaftar);
        Button btnCancel = v.findViewById(R.id.btnSignUpCancel);
        signUp = new AlertDialog.Builder(Login.this, R.style.PauseDialog).create();
        signUp.requestWindowFeature(Window.FEATURE_NO_TITLE);
        signUp.setView(v);
        signUp.setCanceledOnTouchOutside(false);
        signUp.show();
        btnCancel.setOnClickListener(v1 -> {
            signUp.dismiss();
        });
        btnDaftar.setOnClickListener(v1 -> {

        });
    }

    @OnClick(R.id.btnForget)
    void ForgetPass() {

    }

    @OnClick(R.id.btnLogin)
    void Login() {

    }

    @OnClick(R.id.btnKembali)
    void Back() {
        finish();
    }

    //    Handler handler = new Handler();
//    Runnable run = new Runnable() {
//        @Override
//        public void run() {
//            ket.setVisibility(View.GONE);
//            rel1.setVisibility(View.VISIBLE);
//            rel2.setVisibility(View.VISIBLE);
//        }
//    };
    View v;
    LayoutInflater inflater;
    AlertDialog signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
//        handler.postDelayed(run,4000);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
}
