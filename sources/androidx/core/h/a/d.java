package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3056a;

    public c a(int i2) {
        return null;
    }

    public boolean a(int i2, int i3, Bundle bundle) {
        return false;
    }

    public c b(int i2) {
        return null;
    }

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final d f3057a;

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            return null;
        }

        a(d dVar) {
            this.f3057a = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            c a2 = this.f3057a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.f3041a;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f3057a.a(i2, i3, bundle);
        }
    }

    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        public final AccessibilityNodeInfo findFocus(int i2) {
            c b2 = this.f3057a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.f3041a;
        }
    }

    public d() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3056a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f3056a = new a(this);
        } else {
            this.f3056a = null;
        }
    }

    public d(Object obj) {
        this.f3056a = obj;
    }
}
