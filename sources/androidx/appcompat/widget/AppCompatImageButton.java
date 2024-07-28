package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.core.h.t;
import androidx.core.widget.l;

public class AppCompatImageButton extends ImageButton implements t, l {

    /* renamed from: a  reason: collision with root package name */
    private final d f1477a;

    /* renamed from: b  reason: collision with root package name */
    private final h f1478b;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.f1477a = new d(this);
        this.f1477a.a(attributeSet, i2);
        this.f1478b = new h(this);
        this.f1478b.a(attributeSet, i2);
    }

    public void setImageResource(int i2) {
        this.f1478b.a(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1477a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1477a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1477a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1477a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1477a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1477a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        h hVar = this.f1478b;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.f1478b;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1477a;
        if (dVar != null) {
            dVar.d();
        }
        h hVar = this.f1478b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f1478b.a() && super.hasOverlappingRendering();
    }
}
