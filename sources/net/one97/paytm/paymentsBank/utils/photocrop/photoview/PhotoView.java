package net.one97.paytm.paymentsBank.utils.photocrop.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.paymentsBank.utils.photocrop.photoview.d;

public class PhotoView extends AppCompatImageView implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f19543a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f19544b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f19543a = new d(this);
        ImageView.ScaleType scaleType = this.f19544b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f19544b = null;
        }
    }

    public void setPhotoViewRotation(float f2) {
        this.f19543a.a(f2);
    }

    public void setRotationTo(float f2) {
        this.f19543a.a(f2);
    }

    public void setRotationBy(float f2) {
        d dVar = this.f19543a;
        dVar.f19561b.postRotate(f2 % 360.0f);
        dVar.h();
    }

    public RectF getDisplayRect() {
        return this.f19543a.b();
    }

    public Matrix getDisplayMatrix() {
        return this.f19543a.g();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public float getMinimumScale() {
        return this.f19543a.f19564e;
    }

    public void setMinimumScale(float f2) {
        this.f19543a.f19564e = f2;
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    public float getMediumScale() {
        return this.f19543a.f19565f;
    }

    public void setMediumScale(float f2) {
        this.f19543a.f19565f = f2;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public float getMaximumScale() {
        return this.f19543a.f19566g;
    }

    public void setMaximumScale(float f2) {
        this.f19543a.f19566g = f2;
    }

    public float getScale() {
        return this.f19543a.d();
    }

    public void setScale(float f2) {
        this.f19543a.a(f2, false);
    }

    public ImageView.ScaleType getScaleType() {
        return this.f19543a.n;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f19543a;
        if (dVar == null) {
            this.f19544b = scaleType;
        } else if (d.a(scaleType) && scaleType != dVar.n) {
            dVar.n = scaleType;
            dVar.f();
        }
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f19543a.f19567h = z;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f19543a;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        d dVar = this.f19543a;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f19543a;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setOnMatrixChangeListener(d.C0348d dVar) {
        this.f19543a.j = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f19543a.m = onLongClickListener;
    }

    public d.e getOnPhotoTapListener() {
        return this.f19543a.k;
    }

    public void setOnPhotoTapListener(d.e eVar) {
        this.f19543a.k = eVar;
    }

    public d.f getOnViewTapListener() {
        return this.f19543a.l;
    }

    public void setOnViewTapListener(d.f fVar) {
        this.f19543a.l = fVar;
    }

    public void setScale(float f2, boolean z) {
        this.f19543a.a(f2, z);
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f19543a.a(f2, f3, f4, z);
    }

    public void setZoomable(boolean z) {
        this.f19543a.a(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView c2 = this.f19543a.c();
        if (c2 == null) {
            return null;
        }
        return c2.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i2) {
        d dVar = this.f19543a;
        if (i2 < 0) {
            i2 = 200;
        }
        dVar.f19562c = i2;
    }

    public c getIPhotoViewImplementation() {
        return this.f19543a;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        d dVar = this.f19543a;
        if (onDoubleTapListener != null) {
            dVar.f19568i.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            dVar.f19568i.setOnDoubleTapListener(new b(dVar));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f19543a.a();
        super.onDetachedFromWindow();
    }
}
