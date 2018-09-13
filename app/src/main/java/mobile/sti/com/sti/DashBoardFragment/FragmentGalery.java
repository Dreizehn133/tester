package mobile.sti.com.sti.DashBoardFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.adapter.GalleryAdapter;
import mobile.sti.com.sti.model.MainModel;


public class FragmentGalery extends Fragment {

    @BindView(R.id.rvGaleri)
    RecyclerView recyclerView;
    GalleryAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_galery, container, false);
        ButterKnife.bind(this, v);
        initRecycler();
        return v;
    }

    void initRecycler() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initData();
        adapter = new GalleryAdapter(getContext(), models);
        recyclerView.setAdapter(adapter);
//        GalleryDecoration decor = new GalleryDecoration(20);
//        recyclerView.addItemDecoration(decor);
        adapter.notifyDataSetChanged();
    }

    List<MainModel> models;

    void initData() {
        models = new ArrayList<>();
        models.add(new MainModel("Gambar 1", "1", "https://4.bp.blogspot.com/-NbYiGIzPs68/VBKZvHRStGI/AAAAAAAA14M/SHuX6PTv2Qc/s1600/bread-village-carl-warner.jpg"));
        models.add(new MainModel("Gambar 2", "2", "https://3.bp.blogspot.com/-9_us2EyhbVY/VBKZwH4-ppI/AAAAAAAA14g/O47_0kk0UGY/s1600/celery-island-carl-warner.jpg"));
        models.add(new MainModel("Gambar 3", "3", "https://www.fullblownpanicattack.com/wp-content/uploads/photo-gallery/d6fc8d87a2ce2c41baf42bbd92aa8133-resident-evil-levy_orig.jpg"));
        models.add(new MainModel("Gambar 4", "4", "https://www.fullblownpanicattack.com/wp-content/uploads/photo-gallery/critters-3-movie-poster-france-2-dvdbash-wordpress_orig.jpg"));
        models.add(new MainModel("Gambar 5", "5", "https://www.fullblownpanicattack.com/wp-content/uploads/photo-gallery/radu-subspecies-001.jpg"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
