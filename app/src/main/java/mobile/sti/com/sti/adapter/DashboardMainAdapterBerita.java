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
import mobile.sti.com.sti.model.Berita.DataItem;
import mobile.sti.com.sti.model.MainModel;

public class DashboardMainAdapterBerita extends RecyclerView.Adapter<DashboardMainAdapterBerita.RecyclerHolder> {

    Context context;
    List<DataItem> value;
    List<MainModel> values;
    int pos = 1;

    public DashboardMainAdapterBerita(Context context, List<DataItem> value) {
        this.context = context;
        this.value = value;
    }

    public DashboardMainAdapterBerita(Context context, List<MainModel> value, int pos) {
        this.context = context;
        this.values = value;
        this.pos = pos;
    }

    @NonNull
    @Override
    public DashboardMainAdapterBerita.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_berita, parent, false);
        RecyclerHolder holder;
        if (pos == 1)
            holder = new RecyclerHolder(v, context, value);
        else
            holder = new RecyclerHolder(v, context, values, pos);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardMainAdapterBerita.RecyclerHolder holder, int position) {
        if (pos == 1) {
            DataItem model = value.get(position);
            holder.textCardNama.setText(model.getJudul());
            String[] splited = model.getCreatedAt().split("\\s+");

            holder.textCardTgl.setText(splited[0]);
            holder.textCardBhs.setText(model.getBahasa());
//        Glide.with(context).load(model.getGambar1()).into(holder.imageView);
            Glide.with(context).load("https://2.bp.blogspot.com/-1c4XnTpylbk/VtgmXz6D0XI/AAAAAAAAAto/fnLrr1ao4qU/s1600/Acara+Semarang.jpg").into(holder.imageView);
            holder.itemView.setOnClickListener(v -> {
                Intent in = new Intent(context, DetailActivity.class);
//            in.putExtra(Strings.details, model);
//            context.startActivity(in);
            });
        } else {
            MainModel model = values.get(position);
            holder.textCardNama.setText(model.getNama());
            String[] splited = model.getRating().split("\\s+");

            holder.textCardTgl.setText(splited[0]);
            holder.textCardBhs.setText("");
//        Glide.with(context).load(model.getGambar1()).into(holder.imageView);
            Glide.with(context).load(model.getGambar()).into(holder.imageView);
            holder.itemView.setOnClickListener(v -> {
                Intent in = new Intent(context, DetailActivity.class);
//            in.putExtra(Strings.details, model);
//            context.startActivity(in);
            });
        }
    }

    @Override
    public int getItemCount() {
        if (pos == 1) {
            if (value.size() > 5) {
                return 5;
            } else {
                return value.size();
            }
        } else {
            if (values.size() > 5) {
                return 5;
            } else {
                return values.size();
            }
        }
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<DataItem> isi;
        List<MainModel> isis;


        @BindView(R.id.beritaJudul)
        TextView textCardNama;
        @BindView(R.id.beritaBhs)
        TextView textCardBhs;
        @BindView(R.id.beritaTgl)
        TextView textCardTgl;
        @BindView(R.id.beritaImg)
        ImageView imageView;
        int pos;

        public RecyclerHolder(View itemView, Context c, List<DataItem> isi) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;

        }

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi, int pos) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isis = isi;
            this.pos = pos;
        }
    }
}
