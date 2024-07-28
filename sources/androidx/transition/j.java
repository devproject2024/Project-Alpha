package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4806a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Field f4807b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4808c;

    static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                if (!f4808c) {
                    try {
                        Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                        f4807b = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused) {
                    }
                    f4808c = true;
                }
                Field field = f4807b;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                f4807b.set(imageView, matrix2);
                            } catch (IllegalAccessException unused2) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused3) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
                imageView.invalidate();
            }
        } else if (f4806a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused4) {
                f4806a = false;
            }
        }
    }
}
