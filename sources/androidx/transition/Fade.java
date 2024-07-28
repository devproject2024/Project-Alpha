package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b.g;
import androidx.core.h.u;
import androidx.transition.Transition;
import org.xmlpull.v1.XmlPullParser;

public class Fade extends Visibility {
    public Fade(int i2) {
        b(i2);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4830f);
        b(g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "fadingMode", 0, this.f4711a));
        obtainStyledAttributes.recycle();
    }

    public final void a(y yVar) {
        super.a(yVar);
        yVar.f4850a.put("android:fade:transitionAlpha", Float.valueOf(aj.c(yVar.f4851b)));
    }

    private Animator a(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        aj.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, aj.f4754a, new float[]{f3});
        ofFloat.addListener(new a(view));
        a((Transition.d) new u() {
            public final void a(Transition transition) {
                aj.a(view, 1.0f);
                aj.e(view);
                transition.b((Transition.d) this);
            }
        });
        return ofFloat;
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        float f2 = 0.0f;
        float a2 = a(yVar, 0.0f);
        if (a2 != 1.0f) {
            f2 = a2;
        }
        return a(view, f2, 1.0f);
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar) {
        aj.d(view);
        return a(view, a(yVar, 1.0f), 0.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f4850a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float a(androidx.transition.y r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f4850a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.a(androidx.transition.y, float):float");
    }

    static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f4685a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4686b = false;

        a(View view) {
            this.f4685a = view;
        }

        public final void onAnimationStart(Animator animator) {
            if (u.C(this.f4685a) && this.f4685a.getLayerType() == 0) {
                this.f4686b = true;
                this.f4685a.setLayerType(2, (Paint) null);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            aj.a(this.f4685a, 1.0f);
            if (this.f4686b) {
                this.f4685a.setLayerType(0, (Paint) null);
            }
        }
    }
}
