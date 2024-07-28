package com.business.merchant_payments.settlement.image_target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class MpP4bBankImageTarget implements af {
    public final WeakReference<ImageView> mImageRef;

    public final void onBitmapFailed(Exception exc, Drawable drawable) {
    }

    public final void onPrepareLoad(Drawable drawable) {
    }

    public MpP4bBankImageTarget(WeakReference<ImageView> weakReference) {
        k.d(weakReference, "mImageRef");
        this.mImageRef = weakReference;
    }

    public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
        ImageView imageView;
        if (bitmap != null && (imageView = (ImageView) this.mImageRef.get()) != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            double width = ((double) bitmap.getWidth()) / (((double) bitmap.getHeight()) * 1.0d);
            int valueInDp = AppUtility.getValueInDp(imageView.getContext(), 16);
            layoutParams.width = (int) (((double) valueInDp) * width);
            layoutParams.height = valueInDp;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(bitmap);
        }
    }
}
