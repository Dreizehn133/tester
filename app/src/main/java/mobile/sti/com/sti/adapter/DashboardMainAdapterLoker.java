package mobile.sti.com.sti.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.DetailActivity;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.model.MainModel;

public class DashboardMainAdapterLoker extends RecyclerView.Adapter<DashboardMainAdapterLoker.RecyclerHolder> {

    Context context;
    List<MainModel> value;

    public DashboardMainAdapterLoker(Context context, List<MainModel> value) {
        this.context = context;
        this.value = value;
    }

    @NonNull
    @Override
    public DashboardMainAdapterLoker.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_loker, parent, false);
        RecyclerHolder holder = new RecyclerHolder(v, context, value);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardMainAdapterLoker.RecyclerHolder holder, int position) {
        MainModel model = value.get(position);
        holder.textCardNama.setText(model.getNama());
        holder.textCardJob.setText(model.getRating());
//        Glide.with(context).load(model.getGambar1()).into(holder.imageView);
        Glide.with(context).load(model.getGambar()).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            Intent in = new Intent(context, DetailActivity.class);
//            in.putExtra(Strings.details, model);
//            context.startActivity(in);
        });
    }

    @Override
    public int getItemCount() {
        if (value.size() > 5) {
            return 5;
        } else {
            return value.size();
        }
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<MainModel> isi;


        @BindView(R.id.lokerJudul)
        TextView textCardNama;
        @BindView(R.id.lokerJob)
        TextView textCardJob;
        @BindView(R.id.lokerImg)
        ImageView imageView;

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;

        }
    }
}
