package net.one97.paytm.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import net.one97.paytm.photoview.a.f;
import net.one97.paytm.photoview.b;

public class PhotoView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final b f59661a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f59662b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f59661a = new b(this);
        ImageView.ScaleType scaleType = this.f59662b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f59662b = null;
        }
    }

    public void setPhotoViewRotation(float f2) {
        b bVar = this.f59661a;
        float f3 = f2 % 360.0f;
        bVar.f59679f.postRotate(bVar.m - f3);
        bVar.m = f3;
        bVar.g();
    }

    public RectF getDisplayRect() {
        return this.f59661a.b();
    }

    public Matrix getDisplayMatrix() {
        return this.f59661a.f();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f59661a.f59675b;
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.f59661a.f59676c;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f59661a.f59677d;
    }

    public float getScale() {
        return this.f59661a.d();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f59661a.l;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f59661a.f59678e = z;
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        b bVar = this.f59661a;
        b.a(f2, bVar.f59676c, bVar.f59677d);
        bVar.f59675b = f2;
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    public void setMediumScale(float f2) {
        b bVar = this.f59661a;
        b.a(bVar.f59675b, f2, bVar.f59677d);
        bVar.f59676c = f2;
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        b bVar = this.f59661a;
        b.a(bVar.f59675b, bVar.f59676c, f2);
        bVar.f59677d = f2;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        b bVar = this.f59661a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        b bVar = this.f59661a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b bVar = this.f59661a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setOnMatrixChangeListener(b.c cVar) {
        this.f59661a.f59680g = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f59661a.j = onLongClickListener;
    }

    public void setOnPhotoTapListener(b.d dVar) {
        this.f59661a.f59681h = dVar;
    }

    public void setOnViewTapListener(b.e eVar) {
        this.f59661a.f59682i = eVar;
    }

    public void setScale(float f2) {
        this.f59661a.a(f2, false);
    }

    public void setScale(float f2, boolean z) {
        this.f59661a.a(f2, z);
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f59661a.a(f2, f3, f4, z);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.f59661a;
        if (bVar == null) {
            this.f59662b = scaleType;
        } else if (b.a(scaleType) && scaleType != bVar.l) {
            bVar.l = scaleType;
            bVar.e();
        }
    }

    public void setZoomable(boolean z) {
        this.f59661a.a(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f59661a.a();
        super.onDetachedFromWindow();
    }

    public void setOnScaleChangeListener(f fVar) {
        this.f59661a.k = fVar;
    }
}
