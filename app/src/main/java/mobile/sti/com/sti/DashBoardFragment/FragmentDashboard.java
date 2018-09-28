package mobile.sti.com.sti.DashBoardFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mobile.sti.com.sti.Apis.ApiHandler;
import mobile.sti.com.sti.Apis.ApiHelper;
import mobile.sti.com.sti.DashBoard;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.adapter.DashboardMainAdapterAgenda;
import mobile.sti.com.sti.adapter.DashboardMainAdapterBerita;
import mobile.sti.com.sti.adapter.DashboardMainAdapterLoker;
import mobile.sti.com.sti.adapter.DashboardMainAdapterPengumuman;
import mobile.sti.com.sti.adapter.DashboardMainAdapterPerusahaan;
import mobile.sti.com.sti.model.Berita.Berita;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.model.SliderDashBoard;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Strings;


public class FragmentDashboard extends Fragment {

    @BindView(R.id.rvPerusahaan)
    RecyclerView rvPerusahaan;

//    @BindView(R.id.rvProduk)
//    RecyclerView rvProduk;

    @BindView(R.id.rvBerita)
    RecyclerView rvBerita;

    @BindView(R.id.rvAgenda)
    RecyclerView rvAgenda;

    @BindView(R.id.rvPengumuman)
    RecyclerView rvPengumuman;
    @BindView(R.id.rvLoker)
    RecyclerView rvLoker;
    @BindView(R.id.rvProyek)
    RecyclerView rvProyek;
    @BindView(R.id.rvBeasiswa)
    RecyclerView rvBeasiswa;
    @BindView(R.id.sliderFlipper)

    ViewFlipper flipper;

    @OnClick(R.id.btnPerusahaan)
    void Perusahaan() {
//        intent.putExtra(Strings.content,0);
        Strings.posisi = 0;
        startActivity(intent);
        getActivity().finish();
    }

//    @OnClick(R.id.btnProduk)
//    void Produk() {
////        intent.putExtra(Strings.content,1);
//        Strings.posisi = 1;
//        startActivity(intent);
//        getActivity().finish();
//    }

    @OnClick(R.id.btnBerita)
    void Berita() {
//        intent.putExtra(Strings.content,3);
        Strings.posisi = 3;
        startActivity(intent);
        getActivity().finish();
    }

    @OnClick(R.id.btnAgenda)
    void Agenda() {
//        intent.putExtra(Strings.content,2);
        Strings.posisi = 2;
        startActivity(intent);
        getActivity().finish();
    }

    @OnClick(R.id.btnPengum)
    void Pengm() {
//        intent.putExtra(Strings.content,4);
        Strings.posisi = 4;
        startActivity(intent);
        getActivity().finish();
    }

    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @BindView(R.id.nestedscrollview)
    NestedScrollView nestedScrollView;

    @OnClick(R.id.icon1)
    void icon1() {
        nestedScrollView.setScrollY(R.id.contentPengumuman);
    }

    @OnClick(R.id.icon2)
    void icon2() {
//            nestedScrollView.scrollTo(R.id.contentAgenda,R.id.contentAgenda);
        nestedScrollView.setScrollY(R.id.contentAgenda);
    }

    @OnClick(R.id.icon3)
    void icon3() {
        nestedScrollView.setScrollY(R.id.contentBerita);
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_dashboard, container, false);
        ButterKnife.bind(this, v);
        setRecycler();
        intent = new Intent(getContext(), DashBoard.class);
        for (SliderDashBoard slide : Arrays.sliderValue) {
            flipperImage(slide);
        }
        getBerita();
        return v;
    }


    void setRecycler() {

        tesData();
    }

    void tesData() {
        Arrays.perusahaan = new ArrayList<>();
        Arrays.produk = new ArrayList<>();
        Arrays.agenda = new ArrayList<>();
        Arrays.pengumuman = new ArrayList<>();
        Arrays.loker = new ArrayList<>();
        Arrays.proyek = new ArrayList<>();
        Arrays.beasiswa = new ArrayList<>();

        Arrays.pengumuman.add(new MainModel("Penerimaan Pegawai", "PT. Hidup Makmur menerima pegawai sana sini dengan kriteria sembarang asal bisa komputer", "https://www.signaturestaff.com.au/wp-content/uploads/2016/07/iStock_000005150916XSmall.jpg"));
        Arrays.pengumuman.add(new MainModel("Design Thinking", "PT. Ini itu lg nongkrong buat mikirin masa depan", "https://images.pexels.com/photos/6224/hands-people-woman-working.jpg"));
        Arrays.pengumuman.add(new MainModel("Penemuan Mayat", "PT. Hidup Makmur menerima pegawai sana sini dengan kriteria sembarang asal bisa komputer", "https://i0.wp.com/beritautama.net/wp-content/uploads/2018/06/Kepala-Basarnas-M-Syaugi-696x394.jpg?fit=696,394"));
        Arrays.pengumuman.add(new MainModel("Hidup itu Indah", "Lorem Ipsum Bla Bla Bla", "https://images.pexels.com/photos/6224/hands-people-woman-working.jpg"));
        Arrays.pengumuman.add(new MainModel("Penerimaan Calon Istri", "PT. Hidup Makmur menerima pegawai sana sini dengan kriteria sembarang asal bisa komputer", "https://www.signaturestaff.com.au/wp-content/uploads/2016/07/iStock_000005150916XSmall.jpg"));

        Arrays.agenda.add(new MainModel("Poltek Siap Kerja", "", "http://cdn2.tstatic.net/makassar/foto/bank/images/saleh-husin-1_20150728_204224.jpg"));
        Arrays.agenda.add(new MainModel("Seminar Wirausaha", "", "https://www.nusabali.com/article_images/25371/seminar-nasional-wirausaha-muda-udayana-2018-800-2018-02-12-121657_0.jpg"));
        Arrays.agenda.add(new MainModel("Seminar Nasional", "", "https://infoeventbali.files.wordpress.com/2014/01/enaknya-jadi-pengusaha.jpg"));
        Arrays.agenda.add(new MainModel("Workshop Cari Mertua", "", "http://www.franchiseglobal.com/images/posts/2016/02/09/Seminar-Franchise-Business-Matching-2016.jpg"));
        Arrays.agenda.add(new MainModel("Hidup di Kos-kosan", "", "http://cdn2.tstatic.net/makassar/foto/bank/images/saleh-husin-1_20150728_204224.jpg"));

        Arrays.perusahaan.add(new MainModel("PT. Enak sanasini", "https://3.bp.blogspot.com/-ol2b2BkCwPU/WrH6XzPk_2I/AAAAAAAAOKg/d8VwwITaFwoPlwCDKhwG5oW8eiCnxPCLgCLcBGAs/s640/Foto%2BCewek%2BPaling%2BCantik%2BIdaman%2BLelaki%2BSejati.jpg", "http://cdn2.tstatic.net/makassar/foto/bank/images/saleh-husin-1_20150728_204224.jpg"));
        Arrays.perusahaan.add(new MainModel("PT. Asal Jadi", "https://3.bp.blogspot.com/-8aWa1ZH1vVc/WaQ8DgmOOUI/AAAAAAAAH8A/1b1oBBSadU8UgRwQUjfuBjl-OCOw_g3xwCEwYBhgL/s400/Cewek%2BCantik%2BBiodatalengkap%2B2%2B%25282%2529.jpg", "https://cdn-kisikisi.jobs.id/assets/images/company/53312d02582635886f8b4579/samsung_electronics_indonesia_pt_main_samsungelectronicsindonesia.jpg"));
        Arrays.perusahaan.add(new MainModel("PT. Asal Masuk", "https://2.bp.blogspot.com/-Se1xc5SfnJI/WaQ8EnalrMI/AAAAAAAAH8Q/PxPVCgN8I4UK2MONknqF6ruQWEox3dWwACEwYBhgL/s400/Cewek%2BCantik%2BBiodatalengkap%2B2%2B%25285%2529.jpg", "https://izinmudah.com/wp-content/uploads/2017/11/22-Berapa-biaya-bikin-PT.jpg"));

        Arrays.loker.add(new MainModel("PT. Ini itu", "Sekretaris Pribadi", "https://3.bp.blogspot.com/-vp4HXUtFA4s/V_tE4gvM_AI/AAAAAAAANTk/M9YqXGXfOy42OPwMCEiUMQOD0XJSV0VowCLcB/s1600/Lowongan%2BKerja%2BDinas%2BKesehatan%2BKabupaten%2BBanyumas.jpg"));
        Arrays.loker.add(new MainModel("PT. Aneka Jaya", "Jual Sendal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDN5TTZSvnp7eW2X2cr8uE3yZunPmnZ8p0PDScuzE7sqVCQeNA"));
        Arrays.loker.add(new MainModel("PT. Jaringan", "Network Enginer", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6BAq6CS-QpxOKE-KcMhxx_Zh6dNTz7FrfzXngg884V3d7_d8Fyw"));
        Arrays.loker.add(new MainModel("PT. Apa Aja", "Babu Rumah tangga", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdqwxJ5addHx5XERmWDXgUYXcM1aab9-f6O0OiuVJR_ztSwqXb"));
        Arrays.loker.add(new MainModel("PT. Happy Famz", "Badut", "http://www.umm.ac.id/files/image/lowongan_pekerjaan/Untitled-1.jpg"));

        Arrays.proyek.add(new MainModel("Design Thinking", "PT. Ini itu lg nongkrong buat mikirin masa depan", "https://images.pexels.com/photos/6224/hands-people-woman-working.jpg"));
        Arrays.proyek.add(new MainModel("PT. Aneka Jaya", "Jual Sendal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDN5TTZSvnp7eW2X2cr8uE3yZunPmnZ8p0PDScuzE7sqVCQeNA"));
        Arrays.proyek.add(new MainModel("PT. Apa Aja", "Babu Rumah tangga", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdqwxJ5addHx5XERmWDXgUYXcM1aab9-f6O0OiuVJR_ztSwqXb"));

        Arrays.beasiswa.add(new MainModel("Beasiswa 1k", "20/10/2099 aa", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6BAq6CS-QpxOKE-KcMhxx_Zh6dNTz7FrfzXngg884V3d7_d8Fyw"));
        Arrays.beasiswa.add(new MainModel("Beasiswa Hidup Makmur", "20/10/2099 aa", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDN5TTZSvnp7eW2X2cr8uE3yZunPmnZ8p0PDScuzE7sqVCQeNA"));
        Arrays.beasiswa.add(new MainModel("Beasiswa 1 hati 2 cinta", "20/10/2099 aa", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdqwxJ5addHx5XERmWDXgUYXcM1aab9-f6O0OiuVJR_ztSwqXb"));


        rvPengumuman.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvPengumuman.setItemAnimator(new DefaultItemAnimator());

        rvAgenda.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvAgenda.setItemAnimator(new DefaultItemAnimator());

        rvProyek.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvProyek.setItemAnimator(new DefaultItemAnimator());

        rvPerusahaan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvPerusahaan.setItemAnimator(new DefaultItemAnimator());

        rvLoker.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvLoker.setItemAnimator(new DefaultItemAnimator());

        rvPengumuman.setAdapter(new DashboardMainAdapterPengumuman(getContext(), Arrays.pengumuman));
        rvAgenda.setAdapter(new DashboardMainAdapterAgenda(getContext(), Arrays.agenda));
        rvProyek.setAdapter(new DashboardMainAdapterAgenda(getContext(), Arrays.proyek));
        rvPerusahaan.setAdapter(new DashboardMainAdapterPerusahaan(getContext(), Arrays.perusahaan));
        rvLoker.setAdapter(new DashboardMainAdapterLoker(getContext(), Arrays.loker));
//        rvProduk.setAdapter(new DashboardMainAdapterProduk(getContext(), Arrays.produk));
//        SnapHelper snapHelper=new PagerSnapHelper();
        rvBeasiswa.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvBeasiswa.setItemAnimator(new DefaultItemAnimator());
        rvBeasiswa.setAdapter(new DashboardMainAdapterBerita(getContext(), Arrays.beasiswa, 2));
//        new PagerSnapHelper().attachToRecyclerView(rvProduk);
        new PagerSnapHelper().attachToRecyclerView(rvPengumuman);
        new PagerSnapHelper().attachToRecyclerView(rvAgenda);
        new PagerSnapHelper().attachToRecyclerView(rvProyek);
        new PagerSnapHelper().attachToRecyclerView(rvPerusahaan);
    }

    void flipperImage(SliderDashBoard slide) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.flipper_content, null, false);

        ImageView image = view.findViewById(R.id.flipperimage);
        TextView textSlider = view.findViewById(R.id.slideTitle);
        TextView textCat = view.findViewById(R.id.slideCat);

        flipper.addView(view);
        Glide.with(this).load(slide.getGambar()).into(image);
        textSlider.setText(slide.getNama());
        textCat.setText(slide.getCategory());
        flipper.setFlipInterval(5000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), R.anim.slide_in_kanan);
        flipper.setOutAnimation(getContext(), R.anim.slide_out_kiri);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    private void getBerita() {
        Observable<Berita> api = ApiHelper.getClient(getContext()).create(ApiHandler.class)
                .getBerita();
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Berita>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Berita berita) {
                        if (berita.getResponse() == 200) {
                            Arrays.berita = new ArrayList<>();
                            Arrays.berita = berita.getData();
                            rvBerita.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                            rvBerita.setItemAnimator(new DefaultItemAnimator());
                            rvBerita.setAdapter(new DashboardMainAdapterBerita(getContext(), Arrays.berita));

                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
