package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    private static final TimeInterpolator o = new DecelerateInterpolator();
    private static final TimeInterpolator p = new AccelerateInterpolator();
    private int[] q = new int[2];

    public Explode() {
        a((w) new c());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a((w) new c());
    }

    private void d(y yVar) {
        View view = yVar.f4851b;
        view.getLocationOnScreen(this.q);
        int[] iArr = this.q;
        int i2 = iArr[0];
        int i3 = iArr[1];
        yVar.f4850a.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    public final void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    public final void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        Rect rect = (Rect) yVar2.f4850a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.q);
        int[] iArr = this.q;
        return aa.a(view, yVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, o, this);
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar) {
        float f2;
        float f3;
        if (yVar == null) {
            return null;
        }
        Rect rect = (Rect) yVar.f4850a.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) yVar.f4851b.getTag(R.id.transition_position);
        if (iArr != null) {
            f3 = ((float) (iArr[0] - rect.left)) + translationX;
            f2 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f3 = translationX;
            f2 = translationY;
        }
        a((View) viewGroup, rect, this.q);
        int[] iArr2 = this.q;
        return aa.a(view, yVar, i2, i3, translationX, translationY, f3 + ((float) iArr2[0]), f2 + ((float) iArr2[1]), p, this);
    }

    private void a(View view, Rect rect, int[] iArr) {
        int i2;
        int i3;
        View view2 = view;
        view2.getLocationOnScreen(this.q);
        int[] iArr2 = this.q;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        Rect f2 = f();
        if (f2 == null) {
            i3 = (view.getWidth() / 2) + i4 + Math.round(view.getTranslationX());
            i2 = (view.getHeight() / 2) + i5 + Math.round(view.getTranslationY());
        } else {
            int centerX = f2.centerX();
            i2 = f2.centerY();
            i3 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i3);
        float centerY = (float) (rect.centerY() - i2);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a(centerX2, centerY);
        float a3 = a(view2, i3 - i4, i2 - i5);
        iArr[0] = Math.round((centerX2 / a2) * a3);
        iArr[1] = Math.round(a3 * (centerY / a2));
    }

    private static float a(View view, int i2, int i3) {
        return a((float) Math.max(i2, view.getWidth() - i2), (float) Math.max(i3, view.getHeight() - i3));
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }
}
