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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.DetailActivity;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Strings;

public class DashboardMainAdapter extends RecyclerView.Adapter<DashboardMainAdapter.RecyclerHolder> {

    Context context;
    List<MainModel> value;

    public DashboardMainAdapter(Context context, List<MainModel> value) {
        this.context = context;
        this.value = value;
    }

    @NonNull
    @Override
    public DashboardMainAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dashboard, parent, false);
        RecyclerHolder holder = new RecyclerHolder(v, context, value);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardMainAdapter.RecyclerHolder holder, int position) {
        MainModel model = value.get(position);
        Glide.with(context).load("https://exploredieng.files.wordpress.com/2014/02/explore-dieng1.jpg").into(holder.imageCard);
        holder.textCardNama.setText(model.getNama());
        holder.textCardRating.setText(model.getRating());
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
        return 5;
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<MainModel> isi;

        @BindView(R.id.cardImg)
        ImageView imageCard;
        @BindView(R.id.cardNama)
        TextView textCardNama;
        @BindView(R.id.cardRating)
        TextView textCardRating;

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;

        }
    }
}
