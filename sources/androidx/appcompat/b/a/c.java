package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f1196a;

    public c(Drawable drawable) {
        Drawable drawable2 = this.f1196a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1196a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f1196a.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f1196a.setBounds(rect);
    }

    public void setChangingConfigurations(int i2) {
        this.f1196a.setChangingConfigurations(i2);
    }

    public int getChangingConfigurations() {
        return this.f1196a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1196a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1196a.setFilterBitmap(z);
    }

    public void setAlpha(int i2) {
        this.f1196a.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1196a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1196a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1196a.setState(iArr);
    }

    public int[] getState() {
        return this.f1196a.getState();
    }

    public void jumpToCurrentState() {
        this.f1196a.jumpToCurrentState();
    }

    public Drawable getCurrent() {
        return this.f1196a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1196a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1196a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1196a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1196a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1196a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1196a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1196a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1196a.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f1196a.setLevel(i2);
    }

    public void setAutoMirrored(boolean z) {
        a.a(this.f1196a, z);
    }

    public boolean isAutoMirrored() {
        return a.a(this.f1196a);
    }

    public void setTint(int i2) {
        a.a(this.f1196a, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.f1196a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a(this.f1196a, mode);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.f1196a, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        a.a(this.f1196a, i2, i3, i4, i5);
    }
}
