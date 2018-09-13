package mobile.sti.com.sti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Arrays;
import mobile.sti.com.sti.utils.Strings;


public class FragmentDetail extends Fragment {
    @BindView(R.id.detailNama)
    TextView nama;
    @BindView(R.id.detailRating)
    TextView rating;
    MainModel val = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.e("create","ONCREATE");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment_detail, container, false);
        ButterKnife.bind(this, v);
        if (Arrays.values != null && val == null) {
            val = Arrays.values.get(0);

        }
        if ((val = getActivity().getIntent().getParcelableExtra(Strings.details)) != null) {
        } else if (getArguments().containsKey(Strings.detail)) {
            val = getArguments().getParcelable(Strings.detail);
        }
        if (val != null) {
            nama.setText(val.getNama());
            rating.setText(val.getRating());
        }

        return v;
    }

    public static FragmentDetail newInstance(MainModel model) {
        FragmentDetail fragmentDetail = new FragmentDetail();
        Bundle arg = new Bundle();
//        arg.putInt(Strings.detail,select);
        arg.putParcelable(Strings.detail, model);
        fragmentDetail.setArguments(arg);
        return fragmentDetail;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
