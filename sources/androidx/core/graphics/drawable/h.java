package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

final class h extends g {

    /* renamed from: d  reason: collision with root package name */
    private static Method f3012d;

    h(Drawable drawable) {
        super(drawable);
        c();
    }

    h(i iVar, Resources resources) {
        super(iVar, resources);
        c();
    }

    public final void setHotspot(float f2, float f3) {
        this.f3007c.setHotspot(f2, f3);
    }

    public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f3007c.setHotspotBounds(i2, i3, i4, i5);
    }

    public final void getOutline(Outline outline) {
        this.f3007c.getOutline(outline);
    }

    public final Rect getDirtyBounds() {
        return this.f3007c.getDirtyBounds();
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f3007c.setTintList(colorStateList);
        }
    }

    public final void setTint(int i2) {
        if (b()) {
            super.setTint(i2);
        } else {
            this.f3007c.setTint(i2);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f3007c.setTintMode(mode);
        }
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f3007c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public final boolean isProjected() {
        Method method;
        if (!(this.f3007c == null || (method = f3012d) == null)) {
            try {
                return ((Boolean) method.invoke(this.f3007c, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static void c() {
        if (f3012d == null) {
            try {
                f3012d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }
}
