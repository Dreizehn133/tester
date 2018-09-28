package mobile.sti.com.sti;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.DashBoardFragment.FragmentAbout;
import mobile.sti.com.sti.DashBoardFragment.FragmentDashboard;
import mobile.sti.com.sti.DashBoardFragment.FragmentGalery;
import mobile.sti.com.sti.model.SliderDashBoard;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Preference;
import mobile.sti.com.sti.utils.Strings;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ObservableScrollViewCallbacks {
    @BindView(R.id.drawerParent)
    DrawerLayout parentDrawer;
    @BindView(R.id.nav)
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @BindView(R.id.navigationBottom)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
//    @BindView(R.id.sliderFlipper)
//    ViewFlipper flipper;

    Fragment frag1 = new FragmentDashboard();
    Fragment frag2 = new FragmentGalery();
    Fragment frag3 = new FragmentAbout();
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment aktif = frag1;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        myToolbar.setTitle("Dashboard");
        setSupportActionBar(myToolbar);
        pref = new Preference(this);
//        myToolbar.setNestedScrollingEnabled(false);
        Arrays.sliderValue = new ArrayList<>();
        Arrays.sliderValue.add(new SliderDashBoard("https://images.pexels.com/photos/269077/pexels-photo-269077.jpeg", "PT. Ayam Bangkit", "Perusahaan"));
        Arrays.sliderValue.add(new SliderDashBoard("https://images.pexels.com/photos/414936/pexels-photo-414936.jpeg", "Pertamina X", "Perusahaan"));
        Arrays.sliderValue.add(new SliderDashBoard("https://images.pexels.com/photos/6224/hands-people-woman-working.jpg", "Design Thinking", "Agenda"));

        fragmentManager.beginTransaction().add(R.id.layoutFrame, frag3, "3").hide(frag3).commit();
        fragmentManager.beginTransaction().add(R.id.layoutFrame, frag2, "2").hide(frag2).commit();
        fragmentManager.beginTransaction().add(R.id.layoutFrame, frag1, "1").commit();
        initDrawer();

//        for (SliderDashBoard slide : Arrays.sliderValue) {
//            flipperImage(slide);
//        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navButtonHome: {
                        fragmentManager.beginTransaction().hide(aktif).show(frag1).commit();
                        aktif = frag1;
                        myToolbar.setTitle("Dashboard");
//                        flipper.setVisibility(View.VISIBLE);
//                        flipper.setAutoStart(true);
                        getSupportActionBar().show();
                        return true;

                    }
                    case R.id.navButtonGallery: {
                        fragmentManager.beginTransaction().hide(aktif).show(frag2).commit();
                        aktif = frag2;
                        myToolbar.setTitle(R.string.galery);
//                        getSupportActionBar().hide();
//                        flipper.setVisibility(View.INVISIBLE);
                        return true;
                    }
                    case R.id.navButtonAbout: {
                        fragmentManager.beginTransaction().hide(aktif).show(frag3).commit();
                        aktif = frag3;
                        myToolbar.setTitle(R.string.about);
//                        getSupportActionBar().hide();
//                        flipper.setVisibility(View.INVISIBLE);

                        return true;
                    }
                }
                return false;
            }
        });
        intent = new Intent(this, DashBoard.class);
    }

    //    void flipperImage(SliderDashBoard slide){
////        ImageView image = new ImageView(this);
//        View v = LayoutInflater.from(this).inflate(R.layout.flipper_content,null,false);
//        ImageView image = v.findViewById(R.id.flipperimage);
//        TextView textSlider = v.findViewById(R.id.slideTitle);
//        TextView textCat = v.findViewById(R.id.slideCat);
//
//        flipper.addView(v);
//        Glide.with(this).load(slide.getGambar()).into(image);
//        textSlider.setText(slide.getNama());
//        textCat.setText(slide.getCategory());
//        flipper.setFlipInterval(3000);
//        flipper.setAutoStart(true);
//
//        flipper.setInAnimation(this,android.R.anim.slide_in_left);
//        flipper.setOutAnimation(this,android.R.anim.slide_out_right);
//    }
    void initDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, parentDrawer, R.string.open, R.string.close);
        parentDrawer.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.login:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.setting:
                pref.setWelcome(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    Preference pref;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent in = new Intent(this, DashBoard.class);
        switch (item.getItemId()) {
            case R.id.berita: {
                Strings.posisi = Strings.berita;
//                in.putExtra(Strings.content,3);
                startActivity(in);
                finish();
                break;
            }
            case R.id.agenda: {
                Strings.posisi = Strings.agenda;
//                in.putExtra(Strings.content,2);
                startActivity(in);
                finish();
                break;
            }
            case R.id.produk: {
//                in.putExtra(Strings.content,1);
                Strings.posisi = Strings.produk;
                startActivity(in);
                finish();
                break;
            }
            case R.id.perusahaan: {
                Strings.posisi = Strings.perusahaan;
//                in.putExtra(Strings.content,0);
                startActivity(in);
                finish();
                break;
            }
            case R.id.pengumuman: {
                Strings.posisi = Strings.pengumuman;
//                in.putExtra(Strings.content,4);
                startActivity(in);
                finish();
                break;
            }
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (scrollState == ScrollState.UP) {
            Log.e(Strings.Error, "UP");
        } else if (scrollState == ScrollState.DOWN) {
            Log.e(Strings.Error, "DOWN");

        }
    }
}
