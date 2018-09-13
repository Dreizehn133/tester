package mobile.sti.com.sti;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Strings;

public class GalleryPreviewActivity extends AppCompatActivity {
    @BindView(R.id.galleryName)
    TextView nama;
    @BindView(R.id.galleryDesc)
    TextView desc;
    @BindView(R.id.mBigImage)
    BigImageView img;
    @BindView(R.id.galleryPrev)
    LinearLayout linearLayout;
    @BindView(R.id.galleryClose1)
    ImageView close1;
    @BindView(R.id.galleryClose2)
    ImageView close2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BigImageViewer.initialize(GlideImageLoader.with(this));
        setContentView(R.layout.activity_gallery_preview);
        ButterKnife.bind(this);
        MainModel model = getIntent().getParcelableExtra(Strings.detail);
        nama.setText(model.getNama());
        desc.setText(model.getRating());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        img.showImage(Uri.parse(model.getGambar()));
        img.setProgressIndicator(new ProgressPieIndicator());
        close1.setOnClickListener(v -> {
            Log.e(Strings.Error, "finishh");
            finish();
        });
        close2.setOnClickListener(v -> {
            linearLayout.setVisibility(View.GONE);
            close2.setVisibility(View.GONE);
        });
    }
}
