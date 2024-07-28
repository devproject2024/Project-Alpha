package androidx.core.h.a;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityRecord f3058a;

    @Deprecated
    public e(Object obj) {
        this.f3058a = (AccessibilityRecord) obj;
    }

    public static void a(AccessibilityRecord accessibilityRecord, View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i2);
        }
    }

    @Deprecated
    public final int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f3058a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        AccessibilityRecord accessibilityRecord = this.f3058a;
        if (accessibilityRecord == null) {
            if (eVar.f3058a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(eVar.f3058a)) {
            return false;
        }
        return true;
    }
}
