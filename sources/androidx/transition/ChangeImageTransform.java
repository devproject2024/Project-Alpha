package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.x;
import java.util.Map;

public class ChangeImageTransform extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4656a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> o = new TypeEvaluator<Matrix>() {
        public final /* bridge */ /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> p = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            j.a((ImageView) obj, (Matrix) obj2);
        }
    };

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void d(y yVar) {
        Matrix matrix;
        View view = yVar.f4851b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = yVar.f4850a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                Drawable drawable = imageView.getDrawable();
                if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                    int i2 = AnonymousClass3.f4657a[imageView.getScaleType().ordinal()];
                    if (i2 == 1) {
                        Drawable drawable2 = imageView.getDrawable();
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable2.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable2.getIntrinsicHeight()));
                        matrix = matrix2;
                    } else if (i2 == 2) {
                        Drawable drawable3 = imageView.getDrawable();
                        int intrinsicWidth = drawable3.getIntrinsicWidth();
                        float width = (float) imageView.getWidth();
                        float f2 = (float) intrinsicWidth;
                        int intrinsicHeight = drawable3.getIntrinsicHeight();
                        float height = (float) imageView.getHeight();
                        float f3 = (float) intrinsicHeight;
                        float max = Math.max(width / f2, height / f3);
                        int round = Math.round((width - (f2 * max)) / 2.0f);
                        int round2 = Math.round((height - (f3 * max)) / 2.0f);
                        Matrix matrix3 = new Matrix();
                        matrix3.postScale(max, max);
                        matrix3.postTranslate((float) round, (float) round2);
                        matrix = matrix3;
                    }
                    map.put("android:changeImageTransform:matrix", matrix);
                }
                matrix = new Matrix(imageView.getImageMatrix());
                map.put("android:changeImageTransform:matrix", matrix);
            }
        }
    }

    public final void a(y yVar) {
        d(yVar);
    }

    public final void b(y yVar) {
        d(yVar);
    }

    public final String[] a() {
        return f4656a;
    }

    public final Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null) {
            return null;
        }
        Rect rect = (Rect) yVar.f4850a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) yVar2.f4850a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) yVar.f4850a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) yVar2.f4850a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) yVar2.f4851b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return ObjectAnimator.ofObject(imageView, p, o, new Matrix[]{k.f4809a, k.f4809a});
        }
        if (matrix == null) {
            matrix = k.f4809a;
        }
        if (matrix2 == null) {
            matrix2 = k.f4809a;
        }
        p.set(imageView, matrix);
        return ObjectAnimator.ofObject(imageView, p, new x.a(), new Matrix[]{matrix, matrix2});
    }

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4657a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4657a = r0
                int[] r0 = f4657a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4657a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.AnonymousClass3.<clinit>():void");
        }
    }
}
