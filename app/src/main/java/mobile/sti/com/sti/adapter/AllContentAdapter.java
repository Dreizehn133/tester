package mobile.sti.com.sti.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
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
import mobile.sti.com.sti.FragmentDetail;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Strings;

public class AllContentAdapter extends RecyclerView.Adapter<AllContentAdapter.RecyclerHolder> {

    Context context;
    List<MainModel> value;
    int lastPos = -1;
    boolean lanscape = false;
    boolean first = true;

    public AllContentAdapter(Context context, List<MainModel> value, boolean lanscape) {
        this.context = context;
        this.value = value;
        this.lanscape = lanscape;

    }

    private void setAnimation(View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_kiri);
        v.startAnimation(anim);
    }

    private void actionOnLandscape(AllContentAdapter.RecyclerHolder holder, MainModel model) {
        FragmentDetail fragmentDetail = null;
        fragmentDetail = FragmentDetail.newInstance(model);
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(holder.frameLayout, fragmentDetail)
                .commit();
    }

    @NonNull
    @Override
    public AllContentAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_all_content, parent, false);
        RecyclerHolder holder = new RecyclerHolder(v, context, value);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllContentAdapter.RecyclerHolder holder, int position) {
        MainModel model = value.get(position);
        Glide.with(context).load(R.drawable.h).into(holder.imageCard);
        holder.textCardNama.setText(model.getNama());
        holder.textCardRating.setText(model.getRating());
        if (first && lanscape) {
            actionOnLandscape(holder, model);
            first = false;
        }
        holder.view.setOnClickListener(v -> {
//            int select=holder.getAdapterPosition();
            if (lanscape) {
                actionOnLandscape(holder, model);
            } else {
                Intent in = new Intent(context, DetailActivity.class);
                in.putExtra(Strings.details, model);
                context.startActivity(in);
            }
        });
        setAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<MainModel> isi;
        View view;
        @BindView(R.id.cardImg2)
        ImageView imageCard;
        @BindView(R.id.cardNama2)
        TextView textCardNama;
        @BindView(R.id.cardRating2)
        TextView textCardRating;
        int frameLayout = R.id.detailLanscape;

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;
        }
    }
}
