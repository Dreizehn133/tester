package mobile.sti.com.sti.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mobile.sti.com.sti.R;

public class WelcomeScreenAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public WelcomeScreenAdapter(Context context, String[] isi, String[] judul, TypedArray gambar) {
        this.context = context;
        this.isi = isi;
        this.juduls = judul;
        this.gambar = gambar;

    }

    TypedArray gambar;
    String[] juduls;
    String[] isi;

    @Override
    public int getCount() {
        return juduls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.welcome_screen_slide, container, false);
        ImageView img = v.findViewById(R.id.mainLogo);
        TextView judul = v.findViewById(R.id.mainText);
        TextView content = v.findViewById(R.id.mainContent);
        img.setImageResource(gambar.getResourceId(position, -1));
        judul.setText(juduls[position]);
        content.setText(isi[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}

