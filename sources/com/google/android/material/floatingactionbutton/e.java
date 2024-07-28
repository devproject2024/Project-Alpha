package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.g.f;
import com.google.android.material.R;
import com.google.android.material.j.b;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import java.util.ArrayList;

final class e extends d {
    /* access modifiers changed from: package-private */
    public final void d() {
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void n() {
    }

    e(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        this.f36333c = k();
        this.f36333c.setTintList(colorStateList);
        if (mode != null) {
            this.f36333c.setTintMode(mode);
        }
        this.f36333c.a(this.z.getContext());
        if (i2 > 0) {
            Context context = this.z.getContext();
            c cVar = new c((m) f.a(this.f36332b));
            int c2 = androidx.core.content.b.c(context, R.color.design_fab_stroke_top_outer_color);
            int c3 = androidx.core.content.b.c(context, R.color.design_fab_stroke_top_inner_color);
            int c4 = androidx.core.content.b.c(context, R.color.design_fab_stroke_end_inner_color);
            int c5 = androidx.core.content.b.c(context, R.color.design_fab_stroke_end_outer_color);
            cVar.f36323c = c2;
            cVar.f36324d = c3;
            cVar.f36325e = c4;
            cVar.f36326f = c5;
            float f2 = (float) i2;
            if (cVar.f36322b != f2) {
                cVar.f36322b = f2;
                cVar.f36321a.setStrokeWidth(f2 * 1.3333f);
                cVar.f36327g = true;
                cVar.invalidateSelf();
            }
            cVar.a(colorStateList);
            this.f36335e = cVar;
            drawable = new LayerDrawable(new Drawable[]{(Drawable) f.a(this.f36335e), (Drawable) f.a(this.f36333c)});
        } else {
            this.f36335e = null;
            drawable = this.f36333c;
        }
        this.f36334d = new RippleDrawable(com.google.android.material.i.b.b(colorStateList2), drawable, (Drawable) null);
        this.f36336f = this.f36334d;
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (this.f36334d instanceof RippleDrawable) {
            ((RippleDrawable) this.f36334d).setColor(com.google.android.material.i.b.b(colorStateList));
        } else {
            super.a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.z.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(t, a(f2, f4));
            stateListAnimator.addState(u, a(f2, f3));
            stateListAnimator.addState(v, a(f2, f3));
            stateListAnimator.addState(w, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.z, "elevation", new float[]{f2}).setDuration(0));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[]{this.z.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f36331a);
            stateListAnimator.addState(x, animatorSet);
            stateListAnimator.addState(y, a(0.0f, 0.0f));
            this.z.setStateListAnimator(stateListAnimator);
        }
        if (i()) {
            h();
        }
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.z, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(f36331a);
        return animatorSet;
    }

    public final float a() {
        return this.z.getElevation();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        h();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.A.a() || !c();
    }

    /* access modifiers changed from: package-private */
    public final void a(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.z.isEnabled()) {
            this.z.setElevation(this.f36339i);
            if (this.z.isPressed()) {
                this.z.setTranslationZ(this.k);
            } else if (this.z.isFocused() || this.z.isHovered()) {
                this.z.setTranslationZ(this.j);
            } else {
                this.z.setTranslationZ(0.0f);
            }
        } else {
            this.z.setElevation(0.0f);
            this.z.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final h k() {
        return new a((m) f.a(this.f36332b));
    }

    /* access modifiers changed from: package-private */
    public final void a(Rect rect) {
        if (this.A.a()) {
            super.a(rect);
        } else if (!c()) {
            int sizeDimension = (this.l - this.z.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    static class a extends h {
        public final boolean isStateful() {
            return true;
        }

        a(m mVar) {
            super(mVar);
        }
    }
}
