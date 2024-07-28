package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class b {
    @Deprecated
    public static e a(AccessibilityEvent accessibilityEvent) {
        return new e(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
