package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostPhotoViewHolder extends RecyclerView.v {
    private ImageView mCloseView = ((ImageView) this.itemView.findViewById(R.id.sheroes_image_close));
    private Context mContext;
    private ImageView mImage = ((ImageView) this.itemView.findViewById(R.id.sheroes_image));
    private View.OnClickListener mOnCloseClickListener;

    public PostPhotoViewHolder(View view, Context context, View.OnClickListener onClickListener) {
        super(view);
        this.mContext = context;
        this.mOnCloseClickListener = onClickListener;
    }

    public void bindData(Photo photo) {
        if (photo != null) {
            if (photo.file != null) {
                this.mImage.setImageBitmap(decodeFile(photo.file));
            } else if (CommonUtil.isNotEmpty(photo.url)) {
                w.a().a(photo.url).a(this.mImage, (e) null);
            }
        }
        this.mCloseView.setOnClickListener(this.mOnCloseClickListener);
    }

    private Bitmap decodeFile(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            while (i3 / 2 >= 512 && i4 / 2 >= 512) {
                i3 /= 2;
                i4 /= 2;
                i2 *= 2;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            return BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options2);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }
}
