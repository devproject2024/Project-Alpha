package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.PhotoViewHolder;
import java.util.List;

public class AlbumCarouselAdapter extends RecyclerView.a<PhotoViewHolder> {
    private final Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mSelectedPos = 0;
    private List<Photo> photos;

    public AlbumCarouselAdapter(Context context, List<Photo> list, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.photos = list;
        this.mOnClickListener = onClickListener;
    }

    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new PhotoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_sheroes_carosel_item, viewGroup, false), this.mContext, this.mOnClickListener);
    }

    public void onBindViewHolder(PhotoViewHolder photoViewHolder, int i2) {
        Photo photo = this.photos.get(i2);
        photoViewHolder.itemView.setSelected(this.mSelectedPos == i2);
        if (photo != null) {
            photoViewHolder.bindData(photo);
        }
    }

    public int getItemCount() {
        List<Photo> list = this.photos;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectedPosition(int i2) {
        int i3 = this.mSelectedPos;
        if (i3 != i2) {
            this.mSelectedPos = i2;
            notifyItemChanged(i3);
            notifyItemChanged(i2);
        }
    }
}
