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

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.sti.com.sti.GalleryPreviewActivity;
import mobile.sti.com.sti.R;
import mobile.sti.com.sti.model.MainModel;
import mobile.sti.com.sti.utils.Strings;

//import com.ceylonlabs.imageviewpopup.ImagePopup;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.RecyclerHolder> {

    Context context;
    List<MainModel> value;

    public GalleryAdapter(Context context, List<MainModel> value) {
        this.context = context;
        this.value = value;

    }

    @NonNull
    @Override
    public GalleryAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_gallery, parent, false);
        RecyclerHolder holder = new RecyclerHolder(v, context, value);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.RecyclerHolder holder, int position) {
        MainModel model = value.get(position);
        Glide.with(context).load(model.getGambar()).into(holder.imageCard);
//        holder.textCardNama.setText(model.getNama());

        holder.imageCard.setOnClickListener(v -> {
//            final ImagePopup imagePopup = new ImagePopup(context);
////            imagePopup.setWindowHeight(900);
////            imagePopup.setWindowHeight(700);
//            imagePopup.setBackgroundColor(Color.BLACK);
//            imagePopup.setFullScreen(true);
//
//        imagePopup.initiatePopup(holder.imageCard.getDrawable());
//            imagePopup.viewPopup();
            Intent in = new Intent(context, GalleryPreviewActivity.class);
            in.putExtra(Strings.detail, model);
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
        return value.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        Context con;
        List<MainModel> isi;

        @BindView(R.id.cardImgGallery)
        ImageView imageCard;
//        @BindView(R.id.cardNamaGallery)
//        TextView textCardNama;

        public RecyclerHolder(View itemView, Context c, List<MainModel> isi) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.con = c;
            this.isi = isi;
        }
    }
}
