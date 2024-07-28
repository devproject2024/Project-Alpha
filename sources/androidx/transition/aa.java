package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

final class aa {
    static Animator a(View view, y yVar, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Transition transition) {
        float f6;
        float f7;
        View view2 = view;
        y yVar2 = yVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) yVar2.f4851b.getTag(R.id.transition_position);
        if (iArr != null) {
            f6 = ((float) (iArr[0] - i2)) + translationX;
            f7 = ((float) (iArr[1] - i3)) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = i2 + Math.round(f6 - translationX);
        int round2 = i3 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f6, f4}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f7, f5})});
        a aVar = new a(view, yVar2.f4851b, round, round2, translationX, translationY);
        transition.a((Transition.d) aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    static class a extends AnimatorListenerAdapter implements Transition.d {

        /* renamed from: a  reason: collision with root package name */
        private final View f4728a;

        /* renamed from: b  reason: collision with root package name */
        private final View f4729b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4730c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4731d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f4732e = ((int[]) this.f4728a.getTag(R.id.transition_position));

        /* renamed from: f  reason: collision with root package name */
        private float f4733f;

        /* renamed from: g  reason: collision with root package name */
        private float f4734g;

        /* renamed from: h  reason: collision with root package name */
        private final float f4735h;

        /* renamed from: i  reason: collision with root package name */
        private final float f4736i;

        public final void a() {
        }

        public final void b() {
        }

        public final void b(Transition transition) {
        }

        public final void c() {
        }

        a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f4729b = view;
            this.f4728a = view2;
            this.f4730c = i2 - Math.round(this.f4729b.getTranslationX());
            this.f4731d = i3 - Math.round(this.f4729b.getTranslationY());
            this.f4735h = f2;
            this.f4736i = f3;
            if (this.f4732e != null) {
                this.f4728a.setTag(R.id.transition_position, (Object) null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.f4732e == null) {
                this.f4732e = new int[2];
            }
            this.f4732e[0] = Math.round(((float) this.f4730c) + this.f4729b.getTranslationX());
            this.f4732e[1] = Math.round(((float) this.f4731d) + this.f4729b.getTranslationY());
            this.f4728a.setTag(R.id.transition_position, this.f4732e);
        }

        public final void onAnimationPause(Animator animator) {
            this.f4733f = this.f4729b.getTranslationX();
            this.f4734g = this.f4729b.getTranslationY();
            this.f4729b.setTranslationX(this.f4735h);
            this.f4729b.setTranslationY(this.f4736i);
        }

        public final void onAnimationResume(Animator animator) {
            this.f4729b.setTranslationX(this.f4733f);
            this.f4729b.setTranslationY(this.f4734g);
        }

        public final void a(Transition transition) {
            this.f4729b.setTranslationX(this.f4735h);
            this.f4729b.setTranslationY(this.f4736i);
            transition.b((Transition.d) this);
        }
    }
}
