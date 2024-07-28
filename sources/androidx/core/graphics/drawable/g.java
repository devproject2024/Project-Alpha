package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class g extends Drawable implements Drawable.Callback, e, f {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f3005a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    i f3006b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f3007c;

    /* renamed from: d  reason: collision with root package name */
    private int f3008d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f3009e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3010f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3011g;

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    g(i iVar, Resources resources) {
        this.f3006b = iVar;
        i iVar2 = this.f3006b;
        if (iVar2 != null && iVar2.f3014b != null) {
            a(this.f3006b.f3014b.newDrawable(resources));
        }
    }

    g(Drawable drawable) {
        this.f3006b = c();
        a(drawable);
    }

    public void jumpToCurrentState() {
        this.f3007c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f3007c.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3007c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i2) {
        this.f3007c.setChangingConfigurations(i2);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i iVar = this.f3006b;
        return changingConfigurations | (iVar != null ? iVar.getChangingConfigurations() : 0) | this.f3007c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f3007c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f3007c.setFilterBitmap(z);
    }

    public void setAlpha(int i2) {
        this.f3007c.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3007c.setColorFilter(colorFilter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f3006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.b()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.i r0 = r1.f3006b
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f3015c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f3007c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            return r0
        L_0x0020:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.g.isStateful():boolean");
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || this.f3007c.setState(iArr);
    }

    public int[] getState() {
        return this.f3007c.getState();
    }

    public Drawable getCurrent() {
        return this.f3007c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f3007c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f3007c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f3007c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f3007c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f3007c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f3007c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f3007c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f3007c.getPadding(rect);
    }

    public void setAutoMirrored(boolean z) {
        this.f3007c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.f3007c.isAutoMirrored();
    }

    public Drawable.ConstantState getConstantState() {
        i iVar = this.f3006b;
        if (iVar == null) {
            return null;
        }
        if (!(iVar.f3014b != null)) {
            return null;
        }
        this.f3006b.f3013a = getChangingConfigurations();
        return this.f3006b;
    }

    public Drawable mutate() {
        if (!this.f3011g && super.mutate() == this) {
            this.f3006b = c();
            Drawable drawable = this.f3007c;
            if (drawable != null) {
                drawable.mutate();
            }
            i iVar = this.f3006b;
            if (iVar != null) {
                Drawable drawable2 = this.f3007c;
                iVar.f3014b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f3011g = true;
        }
        return this;
    }

    private i c() {
        return new i(this.f3006b);
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
        return this.f3007c.setLevel(i2);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f3006b.f3015c = colorStateList;
        a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f3006b.f3016d = mode;
        a(getState());
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        ColorStateList colorStateList = this.f3006b.f3015c;
        PorterDuff.Mode mode = this.f3006b.f3016d;
        if (colorStateList == null || mode == null) {
            this.f3010f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f3010f && colorForState == this.f3008d && mode == this.f3009e)) {
                setColorFilter(colorForState, mode);
                this.f3008d = colorForState;
                this.f3009e = mode;
                this.f3010f = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable a() {
        return this.f3007c;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f3007c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f3007c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i iVar = this.f3006b;
            if (iVar != null) {
                iVar.f3014b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
