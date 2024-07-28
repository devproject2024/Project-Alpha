package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ap {

    /* renamed from: a  reason: collision with root package name */
    private static Method f4763a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4764b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f4765c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4766d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f4767e;

    ap() {
    }

    public void a(View view, float f2) {
        Float f3 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public float a(View view) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            return view.getAlpha() / f2.floatValue();
        }
        return view.getAlpha();
    }

    public void b(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, (Object) null);
        }
    }

    public void a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    public void c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f4767e;
        if (fArr == null) {
            fArr = new float[9];
            this.f4767e = fArr;
        }
        matrix.getValues(fArr);
        float f2 = fArr[3];
        float sqrt = ((float) Math.sqrt((double) (1.0f - (f2 * f2)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
        float degrees = (float) Math.toDegrees(Math.atan2((double) f2, (double) sqrt));
        float f3 = fArr[0] / sqrt;
        float f4 = fArr[4] / sqrt;
        float f5 = fArr[2];
        float f6 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        view.setRotation(degrees);
        view.setScaleX(f3);
        view.setScaleY(f4);
    }

    public void a(View view, int i2) {
        if (!f4766d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f4765c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4766d = true;
        }
        Field field = f4765c;
        if (field != null) {
            try {
                f4765c.setInt(view, i2 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        if (!f4764b) {
            Class<View> cls = View.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f4763a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4764b = true;
        }
        Method method = f4763a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
