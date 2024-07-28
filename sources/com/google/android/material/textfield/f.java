package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.h.u;
import androidx.core.widget.i;
import com.google.android.material.R;
import com.google.android.material.a.a;
import com.google.android.material.a.b;
import java.util.ArrayList;
import java.util.List;

final class f {

    /* renamed from: a  reason: collision with root package name */
    final Context f36836a;

    /* renamed from: b  reason: collision with root package name */
    final TextInputLayout f36837b;

    /* renamed from: c  reason: collision with root package name */
    Animator f36838c;

    /* renamed from: d  reason: collision with root package name */
    int f36839d;

    /* renamed from: e  reason: collision with root package name */
    int f36840e;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f36841f;

    /* renamed from: g  reason: collision with root package name */
    boolean f36842g;

    /* renamed from: h  reason: collision with root package name */
    TextView f36843h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f36844i;
    int j;
    ColorStateList k;
    CharSequence l;
    boolean m;
    TextView n;
    int o;
    ColorStateList p;
    Typeface q;
    private LinearLayout r;
    private int s;
    private FrameLayout t;
    private int u;
    private final float v = ((float) this.f36836a.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y));

    private static boolean c(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public f(TextInputLayout textInputLayout) {
        this.f36836a = textInputLayout.getContext();
        this.f36837b = textInputLayout;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f36841f = null;
        b();
        if (this.f36839d == 1) {
            if (!this.m || TextUtils.isEmpty(this.l)) {
                this.f36840e = 0;
            } else {
                this.f36840e = 2;
            }
        }
        a(this.f36839d, this.f36840e, a(this.f36843h, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(TextView textView, CharSequence charSequence) {
        if (!u.J(this.f36837b) || !this.f36837b.isEnabled()) {
            return false;
        }
        return this.f36840e != this.f36839d || textView == null || !TextUtils.equals(textView.getText(), charSequence);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, boolean z) {
        boolean z2 = z;
        if (i2 != i3) {
            if (z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f36838c = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i4 = i2;
                int i5 = i3;
                a(arrayList2, this.m, this.n, 2, i4, i5);
                a(arrayList2, this.f36842g, this.f36843h, 1, i4, i5);
                b.a(animatorSet, arrayList);
                final TextView d2 = d(i2);
                final TextView d3 = d(i3);
                final int i6 = i3;
                final int i7 = i2;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        f fVar = f.this;
                        fVar.f36839d = i6;
                        fVar.f36838c = null;
                        TextView textView = d2;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i7 == 1 && f.this.f36843h != null) {
                                f.this.f36843h.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = d3;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            d3.setAlpha(1.0f);
                        }
                    }

                    public final void onAnimationStart(Animator animator) {
                        TextView textView = d3;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    }
                });
                animatorSet.start();
            } else {
                a(i2, i3);
            }
            this.f36837b.a();
            this.f36837b.a(z2, false);
            this.f36837b.c();
        }
    }

    private void a(int i2, int i3) {
        TextView d2;
        TextView d3;
        if (i2 != i3) {
            if (!(i3 == 0 || (d3 = d(i3)) == null)) {
                d3.setVisibility(0);
                d3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (d2 = d(i2)) == null)) {
                d2.setVisibility(4);
                if (i2 == 1) {
                    d2.setText((CharSequence) null);
                }
            }
            this.f36839d = i3;
        }
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                list.add(a(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(a(textView));
                }
            }
        }
    }

    private static ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : 0.0f});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(a.f35800a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.v, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(a.f35803d);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Animator animator = this.f36838c;
        if (animator != null) {
            animator.cancel();
        }
    }

    private TextView d(int i2) {
        if (i2 == 1) {
            return this.f36843h;
        }
        if (i2 != 2) {
            return null;
        }
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final void a(TextView textView, int i2) {
        if (this.r == null && this.t == null) {
            this.r = new LinearLayout(this.f36836a);
            this.r.setOrientation(0);
            this.f36837b.addView(this.r, -1, -2);
            this.t = new FrameLayout(this.f36836a);
            this.r.addView(this.t, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f36837b.getEditText() != null) {
                c();
            }
        }
        if (c(i2)) {
            this.t.setVisibility(0);
            this.t.addView(textView);
            this.u++;
        } else {
            this.r.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.r.setVisibility(0);
        this.s++;
    }

    /* access modifiers changed from: package-private */
    public final void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.r != null) {
            if (!c(i2) || (frameLayout = this.t) == null) {
                this.r.removeView(textView);
            } else {
                this.u--;
                a((ViewGroup) frameLayout, this.u);
                this.t.removeView(textView);
            }
            this.s--;
            a((ViewGroup) this.r, this.s);
        }
    }

    private static void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        if (this.f36840e != 1 || this.f36843h == null || TextUtils.isEmpty(this.f36841f)) {
            return false;
        }
        return true;
    }

    static void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        TextView textView = this.f36843h;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList f() {
        TextView textView = this.f36843h;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        TextView textView = this.f36843h;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.j = i2;
        TextView textView = this.f36843h;
        if (textView != null) {
            this.f36837b.a(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CharSequence charSequence) {
        this.f36844i = charSequence;
        TextView textView = this.f36843h;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(ColorStateList colorStateList) {
        this.p = colorStateList;
        TextView textView = this.n;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        this.o = i2;
        TextView textView = this.n;
        if (textView != null) {
            i.a(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if ((this.r == null || this.f36837b.getEditText() == null) ? false : true) {
            u.b(this.r, u.m(this.f36837b.getEditText()), 0, u.n(this.f36837b.getEditText()), 0);
        }
    }
}
