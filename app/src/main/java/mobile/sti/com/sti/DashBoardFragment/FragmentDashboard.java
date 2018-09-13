package mobile.sti.com.sti.DashBoardFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.sti.com.sti.DashBoard;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.adapter.DashboardMainAdapter;
import mobile.sti.com.sti.adapter.DashboardMainAdapterBerita;
import mobile.sti.com.sti.adapter.DashboardMainAdapterProduk;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.model.SliderDashBoard;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Strings;


public class FragmentDashboard extends Fragment {

    @BindView(R.id.rvPerusahaan)
    RecyclerView rvPerusahaan;

    @BindView(R.id.rvProduk)
    RecyclerView rvProduk;

    @BindView(R.id.rvBerita)
    RecyclerView rvBerita;

    @BindView(R.id.rvAgenda)
    RecyclerView rvAgenda;

    @BindView(R.id.rvPengumuman)
    RecyclerView rvPengumuman;
    @BindView(R.id.sliderFlipper)
    ViewFlipper flipper;
    DashboardMainAdapter adapter1;

    @OnClick(R.id.btnPerusahaan)
    void Perusahaan() {
//        intent.putExtra(Strings.content,0);
        Strings.posisi = 0;
        startActivity(intent);
        getActivity().finish();
    }

    @OnClick(R.id.btnProduk)
    void Produk() {
//        intent.putExtra(Strings.content,1);
        Strings.posisi = 1;
        startActivity(intent);
        getActivity().finish();
    }

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
        return v;
    }

    List<RecyclerView> obj1;
    List<RecyclerView.LayoutManager> layouts;

    void setRecycler() {

        layouts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            layouts.add(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        }
        obj1 = new ArrayList<RecyclerView>();
        obj1.add(rvPerusahaan);
        obj1.add(rvProduk);
        obj1.add(rvBerita);
        obj1.add(rvAgenda);
        obj1.add(rvPengumuman);
        for (int i = 0; i < obj1.size(); i++) {
            RecyclerView r = obj1.get(i);
            Log.e("RV", r + "");
            r.setLayoutManager(layouts.get(i));
            r.setItemAnimator(new DefaultItemAnimator());
        }


        tesData();
    }

    //    public static List<MainModel> perusahaan;
//    public static List<MainModel> produk;
//    public static List<MainModel> berita;
//    public static List<MainModel> agenda;
//    public static List<MainModel> pengumuman;
    void tesData() {
        Arrays.perusahaan = new ArrayList<>();
        Arrays.produk = new ArrayList<>();
        Arrays.berita = new ArrayList<>();
        Arrays.agenda = new ArrayList<>();
        Arrays.pengumuman = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            Arrays.perusahaan.add(new MainModel("Perusahaan" + i, "" + i, ""));
            Arrays.produk.add(new MainModel("Produk" + i, "" + i, ""));
            Arrays.berita.add(new MainModel("Berita" + i, "" + i, ""));
            Arrays.agenda.add(new MainModel("Agenda" + i, "" + i, ""));
            Arrays.pengumuman.add(new MainModel("Pengumuman" + i, "" + i, ""));
        }
        List<List<MainModel>> obj = new ArrayList<List<MainModel>>();

        obj.add(Arrays.perusahaan);
        obj.add(Arrays.produk);
        obj.add(Arrays.berita);
        obj.add(Arrays.agenda);
        obj.add(Arrays.pengumuman);
        List<DashboardMainAdapter> adapters = new ArrayList<>();
        for (int i = 0; i < obj.size(); i++) {
            adapters.add(new DashboardMainAdapter(getContext(), obj.get(i)));

        }
        for (int i = 0; i < obj1.size(); i++) {
            obj1.get(i).setAdapter(adapters.get(i));
            adapters.get(i).notifyDataSetChanged();
        }
        rvBerita.setAdapter(new DashboardMainAdapterBerita(getContext(), Arrays.berita));
        rvProduk.setAdapter(new DashboardMainAdapterProduk(getContext(), Arrays.produk));
    }

    void flipperImage(SliderDashBoard slide) {
//        ImageView image = new ImageView(this);
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


}
