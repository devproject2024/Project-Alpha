package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;

public abstract class ActionBar {

    @Deprecated
    public static abstract class a {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract CharSequence d();
    }

    public b a(b.a aVar) {
        return null;
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Configuration configuration) {
    }

    public abstract void a(Drawable drawable);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b();

    public abstract void b(int i2);

    public void b(Drawable drawable) {
    }

    public void b(CharSequence charSequence) {
    }

    public abstract void b(boolean z);

    public abstract int c();

    public abstract void c(int i2);

    public abstract void c(boolean z);

    public abstract int d();

    public abstract void d(int i2);

    public void d(boolean z) {
    }

    public abstract void e();

    public void e(int i2) {
    }

    public void e(boolean z) {
    }

    public abstract void f();

    public void f(int i2) {
    }

    public void f(boolean z) {
    }

    public Context g() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void m() {
    }

    public void h() {
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void a(float f2) {
        if (f2 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f991a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f991a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f991a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f991a = 0;
            this.f991a = 8388627;
        }

        public LayoutParams() {
            super(-1, -2);
            this.f991a = 0;
            this.f991a = 8388611;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f991a = 0;
            this.f991a = layoutParams.f991a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f991a = 0;
        }
    }
}
