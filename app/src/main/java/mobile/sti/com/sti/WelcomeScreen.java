package mobile.sti.com.sti;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.adapter.WelcomeScreenAdapter;
import mobile.sti.com.sti.utils.Preference;

public class WelcomeScreen extends AppCompatActivity {
    WelcomeScreenAdapter pagerAdapter;

    @BindView(R.id.dotLayout)
    LinearLayout linearLayout;

    @BindView(R.id.slider)
    ViewPager pager;

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnNext)
    Button btnNext;
    int posisi;

    Preference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen_activity);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.e("AAA", getResources().obtainTypedArray(R.array.gmbr) + "");
        pagerAdapter = new WelcomeScreenAdapter(this,
                getResources().getStringArray(R.array.isi),
                getResources().getStringArray(R.array.judul),
                getResources().obtainTypedArray(R.array.gmbr));
        pager.setAdapter(pagerAdapter);
        addDots(0);
        pager.addOnPageChangeListener(listener);
        pref = new Preference(this);

        btnNext.setOnClickListener(v -> {
            if (posisi == dots.length - 1) {
                startActivity(new Intent(getApplication(), DashBoardActivity.class));
                finish();
                pref.setWelcome(false);
            } else {
                pager.setCurrentItem(posisi + 1);
            }
        });
        btnBack.setOnClickListener(v -> {
            pager.setCurrentItem(posisi - 1);
        });
    }

    TextView[] dots;

    void addDots(int pos) {
        dots = new TextView[5];
        linearLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.transpW));

            linearLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[pos].setTextColor(ContextCompat.getColor(this, R.color.putih));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            posisi = position;
            if (posisi == 0) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(false);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText("Next");
                btnBack.setText("");
            } else if (posisi == dots.length - 1) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("Finish");
                btnBack.setText("Back");
            } else {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("Next");
                btnBack.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
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
