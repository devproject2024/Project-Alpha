package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.PostPhotoViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PostPhotoAdapter extends RecyclerView.a<PostPhotoViewHolder> {
    private final Context mContext;
    private final View.OnClickListener mOnCloseClickListener;
    private List<Photo> mPhotoList = new ArrayList();
    private int mSelectedPos = 0;

    public PostPhotoAdapter(Context context, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.mOnCloseClickListener = onClickListener;
    }

    public PostPhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new PostPhotoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_sheroes_image_item, viewGroup, false), this.mContext, this.mOnCloseClickListener);
    }

    public void onBindViewHolder(PostPhotoViewHolder postPhotoViewHolder, int i2) {
        Photo photo = this.mPhotoList.get(i2);
        postPhotoViewHolder.itemView.setSelected(this.mSelectedPos == i2);
        if (photo != null) {
            postPhotoViewHolder.bindData(photo);
        }
    }

    public int getItemCount() {
        List<Photo> list = this.mPhotoList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<Photo> list) {
        this.mPhotoList = list;
        notifyDataSetChanged();
    }

    public void addPhoto(Photo photo) {
        int size = this.mPhotoList.size();
        this.mPhotoList.add(photo);
        notifyItemInserted(size + 1);
    }

    public void removePhoto(int i2) {
        this.mPhotoList.remove(i2);
        notifyItemRemoved(i2);
    }
}
