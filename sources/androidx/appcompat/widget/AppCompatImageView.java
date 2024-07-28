package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.h.t;
import androidx.core.widget.l;

public class AppCompatImageView extends ImageView implements t, l {
    private final d mBackgroundTintHelper;
    private final h mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.mBackgroundTintHelper = new d(this);
        this.mBackgroundTintHelper.a(attributeSet, i2);
        this.mImageHelper = new h(this);
        this.mImageHelper.a(attributeSet, i2);
    }

    public void setImageResource(int i2) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(i2);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.d();
        }
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.a() && super.hasOverlappingRendering();
    }
}
