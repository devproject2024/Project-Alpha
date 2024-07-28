package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public class PhotoViewHolder extends RecyclerView.v {
    private Context mContext;
    private ImageView mImage;

    public PhotoViewHolder(View view, Context context, View.OnClickListener onClickListener) {
        super(view);
        this.mContext = context;
        this.mImage = (ImageView) view.findViewById(R.id.sheroes_image);
        ((RelativeLayout) view.findViewById(R.id.sheroes_image_container)).setOnClickListener(onClickListener);
    }

    public void bindData(Photo photo) {
        if (CommonUtil.isNotEmpty(photo.url)) {
            w.a().a(CommonUtil.getThumborUri(photo.url, CommonUtil.convertDpToPixel(68.0f, this.mContext), CommonUtil.convertDpToPixel(68.0f, this.mContext))).a(this.mImage, (e) null);
        }
    }
}
