package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Field f3189a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3190b;

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof j) {
            ((j) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static ColorStateList a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof j) {
            return ((j) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof j) {
            ((j) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f3190b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f3189a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3190b = true;
        }
        Field field = f3189a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                f3189a = null;
            }
        }
        return null;
    }
}
