package mobile.sti.com.sti;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.adapter.AllContentAdapter;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Strings;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rvAllContent)
    RecyclerView recyclerView;
    AllContentAdapter allContentAdapter;
//    List<MainModel> values;

    @BindView(R.id.drawerParent)
    DrawerLayout parentDrawer;
    @BindView(R.id.nav)
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    boolean landscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board2);
        ButterKnife.bind(this);
        myToolbar.setTitle(R.string.Dashboard);
        setSupportActionBar(myToolbar);
        Arrays.values = new ArrayList<MainModel>();
        if (findViewById(R.id.detailLanscape) != null) {
            landscape = true;
        }
        initial(Strings.posisi);
        initDrawer();


    }

    void initial(int x) {
        switch (x) {
            case 0:
                Arrays.values = Arrays.perusahaan;
                myToolbar.setTitle("Daftar Perusahaan");
                break;
            case 1:
                myToolbar.setTitle("Daftar Produk");
                Arrays.values = Arrays.produk;
                break;
            case 2:
                myToolbar.setTitle("Daftar Agenda");
                Arrays.values = Arrays.agenda;
                break;
            case 3:
                myToolbar.setTitle("Daftar Berita");
                Arrays.values = Arrays.berita;
                break;
            case 4:
                myToolbar.setTitle("Daftar Pengumuman");
                Arrays.values = Arrays.pengumuman;
                break;
        }
        initRecycler();
    }

    void initRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        allContentAdapter = new AllContentAdapter(this, Arrays.values, landscape);
        recyclerView.setAdapter(allContentAdapter);
        allContentAdapter.notifyDataSetChanged();
    }

    void initDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, parentDrawer, R.string.open, R.string.close);
        parentDrawer.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    MenuItem cari;
    SearchView searchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        cari = menu.findItem(R.id.toolSearch);
        searchView = (SearchView) cari.getActionView();
        searchView.setQueryHint("Cari");
        ImageView searchClose = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_close_btn);

        searchClose.setColorFilter(Color.WHITE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<MainModel> cariBar = new ArrayList<>();
                for (MainModel m : Arrays.values) {
                    if (m.getNama().toLowerCase().contains(newText.toLowerCase())) {
                        cariBar.add(m);
                    }
                }
                allContentAdapter = new AllContentAdapter(DashBoard.this, cariBar, landscape);
                recyclerView.setAdapter(allContentAdapter);
                return true;
            }
        });
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
            case R.id.dashb:
                startActivity(new Intent(this, DashBoardActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.berita: {
                initial(3);
                Strings.posisi = 3;
                parentDrawer.closeDrawers();
                break;
            }
            case R.id.agenda: {
                initial(2);
                Strings.posisi = 2;
                parentDrawer.closeDrawers();
                break;
            }
            case R.id.produk: {
                initial(1);
                Strings.posisi = 1;
                parentDrawer.closeDrawers();
                break;
            }
            case R.id.perusahaan: {
                initial(0);
                Strings.posisi = 0;
                parentDrawer.closeDrawers();
                break;
            }
            case R.id.pengumuman: {
                initial(4);
                Strings.posisi = 4;
                parentDrawer.closeDrawers();
                break;
            }
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.removeAllViewsInLayout();
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
