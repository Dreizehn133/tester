package mobile.sti.com.sti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mobile.sti.com.sti.model.MainModel;

public class DetailActivity extends AppCompatActivity {
    //    @BindView(R.id.detailNama)TextView nama;
//    @BindView(R.id.detailRating)TextView rating;
    MainModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        ButterKnife.bind(this);
//        MainModel model=getIntent().getParcelableExtra("detail");
//        nama.setText(model.getNama());
//        rating.setText(model.getRating());
//        FragmentDetail fragmentDetail = FragmentDetail.newInstance(getIntent().getIntExtra("69",0),model);
        FragmentDetail fragmentDetail = new FragmentDetail();
        getSupportFragmentManager().beginTransaction().add(R.id.conDetail, fragmentDetail).commit();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
