package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.b;
import androidx.core.h.ab;
import androidx.core.h.q;
import androidx.core.h.u;
import com.google.android.material.R;

public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f36425a;

    /* renamed from: b  reason: collision with root package name */
    Rect f36426b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f36427c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36428d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f36429e;

    /* access modifiers changed from: protected */
    public void a(ab abVar) {
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36427c = new Rect();
        this.f36428d = true;
        this.f36429e = true;
        TypedArray a2 = k.a(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i2, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f36425a = a2.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        a2.recycle();
        setWillNotDraw(true);
        u.a((View) this, (q) new q() {
            public final ab a(View view, ab abVar) {
                if (ScrimInsetsFrameLayout.this.f36426b == null) {
                    ScrimInsetsFrameLayout.this.f36426b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f36426b.set(abVar.a(), abVar.b(), abVar.c(), abVar.d());
                ScrimInsetsFrameLayout.this.a(abVar);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                boolean z = true;
                if ((!abVar.f3061b.g().equals(b.f2972a)) && ScrimInsetsFrameLayout.this.f36425a != null) {
                    z = false;
                }
                scrimInsetsFrameLayout.setWillNotDraw(z);
                u.g(ScrimInsetsFrameLayout.this);
                return abVar.f3061b.c();
            }
        });
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f36425a = drawable;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f36428d = z;
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f36429e = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f36426b != null && this.f36425a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (this.f36428d) {
                this.f36427c.set(0, 0, width, this.f36426b.top);
                this.f36425a.setBounds(this.f36427c);
                this.f36425a.draw(canvas);
            }
            if (this.f36429e) {
                this.f36427c.set(0, height - this.f36426b.bottom, width, height);
                this.f36425a.setBounds(this.f36427c);
                this.f36425a.draw(canvas);
            }
            this.f36427c.set(0, this.f36426b.top, this.f36426b.left, height - this.f36426b.bottom);
            this.f36425a.setBounds(this.f36427c);
            this.f36425a.draw(canvas);
            this.f36427c.set(width - this.f36426b.right, this.f36426b.top, width, height - this.f36426b.bottom);
            this.f36425a.setBounds(this.f36427c);
            this.f36425a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f36425a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f36425a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }
}
