package mobile.sti.com.sti.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.DetailActivity;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Strings;

public class DashboardMainAdapterPerusahaan extends RecyclerView.Adapter<DashboardMainAdapterPerusahaan.RecyclerHolder> {

    Context context;
    List<MainModel> value;

    public DashboardMainAdapterPerusahaan(Context context, List<MainModel> value) {
        this.context = context;
        this.value = value;
    }

    @NonNull
    @Override
    public DashboardMainAdapterPerusahaan.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_perusahaan, parent, false);
        RecyclerHolder holder = new RecyclerHolder(v, context, value);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardMainAdapterPerusahaan.RecyclerHolder holder, int position) {
        MainModel model = value.get(position);
        Glide.with(context).load(model.getGambar()).into(holder.imageCard);
        Glide.with(context).load(model.getRating()).apply(RequestOptions.circleCropTransform()).into(holder.imageUser);
        holder.textCardNama.setText(model.getNama());

        holder.imageCard.setOnClickListener(v -> {
            Intent in = new Intent(context, DetailActivity.class);
            in.putExtra(Strings.details, model);
            context.startActivity(in);
        });
        setAnimation(holder.itemView);
    }

    private void setAnimation(View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_top);
        v.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        if (value.size() > 5)
            return 5;
        else
            return value.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<MainModel> isi;

        @BindView(R.id.perusahaanImg)
        ImageView imageCard;
        @BindView(R.id.perusahaanJudul)
        TextView textCardNama;
        @BindView(R.id.perusahaanImgUser)
        ImageView imageUser;

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;

        }
    }
}
