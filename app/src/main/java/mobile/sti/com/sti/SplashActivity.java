package mobile.sti.com.sti;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.model.SliderDashBoard;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Preference;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.imgLogoss)
    ImageView logo;
    @BindView(R.id.tvKet)
    TextView tvKet;
    Preference pref;
    private boolean next;
    Thread t;

    int Orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        pref = new Preference(this);
        if (pref.getWelcome() != true && pref.getWelcome() != false) {
            pref.setWelcome(true);
        }
        next = true;
        logo.startAnimation(anim);
        tvKet.startAnimation(anim1);
        Orientation = getResources().getConfiguration().orientation;
        Arrays.sliderValue = new ArrayList<>();
        Arrays.sliderValue.add(new SliderDashBoard("https://lollytaokta00123.files.wordpress.com/2013/01/gambar-pemandangan-di-bali-gambar-lukisan-pemandangan-alam-di-bali-yang-indah1.jpg", "Namanya", "Categori 1"));
        Arrays.sliderValue.add(new SliderDashBoard("http://media-bhayangkara.com/wp-content/uploads/2017/12/Pemandangan-Alam.jpg", "Namanya2", "Categori 2"));
        Arrays.sliderValue.add(new SliderDashBoard("https://www.gambar.co.id/wp-content/uploads/2017/11/gambar-pemandangan-alam-11.jpg", "Namanya3", "Categori 3"));
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
//                    if(getResources().getConfiguration().orientation!=Orientation){
//                        next=false;
//                        Log.e(Strings.Error,"berputar");
//                        Orientation=getResources().getConfiguration().orientation;
//                       // t.start();
//                        throw new Exception();
//                    }else {
//                        Log.e(Strings.Error,"normal");
//
//                    }

                } catch (Exception e) {

                } finally {
                    if (next) {
                        if (pref.getWelcome()) {
                            startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
                            finish();
                        } else {
                            startActivity(new Intent(getApplicationContext(), DashBoardActivity.class));
                            finish();
                        }
                    }
                }
            }
        });
        t.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        next = false;

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        next = false;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik 2x Kembali untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
