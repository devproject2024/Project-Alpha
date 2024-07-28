package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import uk.co.senab.photoview.a.f;
import uk.co.senab.photoview.b;

public class PhotoView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final b f21284a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f21285b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f21284a = new b(this);
        ImageView.ScaleType scaleType = this.f21285b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f21285b = null;
        }
    }

    public void setPhotoViewRotation(float f2) {
        b bVar = this.f21284a;
        float f3 = f2 % 360.0f;
        bVar.f21302f.postRotate(bVar.m - f3);
        bVar.m = f3;
        bVar.g();
    }

    public RectF getDisplayRect() {
        return this.f21284a.b();
    }

    public Matrix getDisplayMatrix() {
        return this.f21284a.f();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f21284a.f21298b;
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.f21284a.f21299c;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f21284a.f21300d;
    }

    public float getScale() {
        return this.f21284a.d();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f21284a.l;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f21284a.f21301e = z;
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        b bVar = this.f21284a;
        b.a(f2, bVar.f21299c, bVar.f21300d);
        bVar.f21298b = f2;
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    public void setMediumScale(float f2) {
        b bVar = this.f21284a;
        b.a(bVar.f21298b, f2, bVar.f21300d);
        bVar.f21299c = f2;
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        b bVar = this.f21284a;
        b.a(bVar.f21298b, bVar.f21299c, f2);
        bVar.f21300d = f2;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        b bVar = this.f21284a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        b bVar = this.f21284a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b bVar = this.f21284a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setOnMatrixChangeListener(b.c cVar) {
        this.f21284a.f21303g = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f21284a.j = onLongClickListener;
    }

    public void setOnPhotoTapListener(b.d dVar) {
        this.f21284a.f21304h = dVar;
    }

    public void setOnViewTapListener(b.e eVar) {
        this.f21284a.f21305i = eVar;
    }

    public void setScale(float f2) {
        this.f21284a.a(f2, false);
    }

    public void setScale(float f2, boolean z) {
        this.f21284a.a(f2, z);
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f21284a.a(f2, f3, f4, z);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.f21284a;
        if (bVar == null) {
            this.f21285b = scaleType;
        } else if (b.a(scaleType) && scaleType != bVar.l) {
            bVar.l = scaleType;
            bVar.e();
        }
    }

    public void setZoomable(boolean z) {
        this.f21284a.a(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f21284a.a();
        super.onDetachedFromWindow();
    }

    public void setOnScaleChangeListener(f fVar) {
        this.f21284a.k = fVar;
    }
}
