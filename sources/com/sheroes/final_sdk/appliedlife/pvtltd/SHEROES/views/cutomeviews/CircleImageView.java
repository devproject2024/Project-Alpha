package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.sheroes.final_sdk.R;
import com.squareup.picasso.af;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public class CircleImageView extends AppCompatImageView {
    private int errorPlaceHolderDrawableId;
    private ImageLoadListener imageLoadListener;
    /* access modifiers changed from: private */
    public ImageView imageView = this;
    private boolean isCircularImage = false;
    boolean isImageLoadede;
    int measuredHeight;
    int measuredWidth;
    int numberOfTimesImageLoaded;
    int numberOfTimesOnMeasureCalled;
    /* access modifiers changed from: private */
    public int placeHolderDrawableId;
    private boolean scaleTypeDefault = true;

    public interface ImageLoadListener {
        void onImageLoadFailed();

        void onImageLoaded();
    }

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.numberOfTimesOnMeasureCalled++;
        this.numberOfTimesImageLoaded++;
        if (this.measuredWidth == 0 && this.measuredHeight == 0) {
            int measuredHeight2 = getMeasuredHeight();
            int measuredWidth2 = getMeasuredWidth();
            this.measuredHeight = View.MeasureSpec.getSize(measuredHeight2);
            this.measuredWidth = View.MeasureSpec.getSize(measuredWidth2);
            this.numberOfTimesImageLoaded++;
            this.isImageLoadede = false;
        }
    }

    public void bindImage(String str) {
        if (this.scaleTypeDefault) {
            setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            setScaleType(getScaleType());
        }
        if (!this.isCircularImage) {
            if (str == null || str.isEmpty()) {
                if (this.errorPlaceHolderDrawableId == 0) {
                    this.errorPlaceHolderDrawableId = R.drawable.vector_sheroes_default_img;
                }
                w.a().a(this.errorPlaceHolderDrawableId).a((ImageView) this, (e) null);
                return;
            }
            if (this.errorPlaceHolderDrawableId == 0) {
                this.errorPlaceHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            if (this.placeHolderDrawableId == 0) {
                this.placeHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            w.a().a(str).a((ImageView) this, (e) null);
        } else if (str == null || str.isEmpty()) {
            if (this.placeHolderDrawableId == 0) {
                this.placeHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            if (this.errorPlaceHolderDrawableId == 0) {
                this.errorPlaceHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            w.a().a(this.placeHolderDrawableId).a((ImageView) this, (e) null);
        } else {
            if (this.errorPlaceHolderDrawableId == 0) {
                this.errorPlaceHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            if (this.placeHolderDrawableId == 0) {
                this.placeHolderDrawableId = R.drawable.vector_sheroes_default_img;
            }
            AnonymousClass1 r0 = new af() {
                public void onBitmapFailed(Exception exc, Drawable drawable) {
                }

                public void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    b a2 = d.a(CircleImageView.this.getContext().getResources(), bitmap);
                    a2.b();
                    CircleImageView.this.imageView.setImageDrawable(a2);
                }

                public void onPrepareLoad(Drawable drawable) {
                    CircleImageView.this.imageView.setImageResource(CircleImageView.this.placeHolderDrawableId);
                }
            };
            this.imageView.setTag(r0);
            w.a().a(str).a((af) r0);
        }
    }

    public int getCustomMeasuredHeight() {
        return this.measuredHeight;
    }

    public int getCustomMeasuredWidth() {
        return this.measuredWidth;
    }

    public void setErrorPlaceHolderId(int i2) {
        this.errorPlaceHolderDrawableId = i2;
    }

    public void setPlaceHolderId(int i2) {
        this.placeHolderDrawableId = i2;
    }

    public void setScaleTypeDefault(boolean z) {
        this.scaleTypeDefault = z;
    }

    public void setCircularImage(boolean z) {
        this.isCircularImage = z;
    }

    public ImageLoadListener getImageLoadListener() {
        return this.imageLoadListener;
    }

    public void setImageLoadListener(ImageLoadListener imageLoadListener2) {
        this.imageLoadListener = imageLoadListener2;
    }
}
