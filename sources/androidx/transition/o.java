package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

final class o implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f4816a;

    public final /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i2 = rect.left + ((int) (((float) (rect2.left - rect.left)) * f2));
        int i3 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f2));
        int i4 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f2));
        int i5 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f2));
        Rect rect3 = this.f4816a;
        if (rect3 == null) {
            return new Rect(i2, i3, i4, i5);
        }
        rect3.set(i2, i3, i4, i5);
        return this.f4816a;
    }

    o() {
    }

    o(Rect rect) {
        this.f4816a = rect;
    }
}
