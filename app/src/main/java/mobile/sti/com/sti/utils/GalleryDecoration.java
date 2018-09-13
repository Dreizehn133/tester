package mobile.sti.com.sti.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GalleryDecoration extends RecyclerView.ItemDecoration {
    private int item;

    public GalleryDecoration(int item) {
        this.item = item;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = item;
        outRect.right = item;
        outRect.bottom = item;
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = item;
    }
}
