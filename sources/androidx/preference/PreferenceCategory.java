package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.core.content.b.g;

public class PreferenceCategory extends PreferenceGroup {
    public final boolean i() {
        return false;
    }

    private PreferenceCategory(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public final boolean c() {
        return !super.i();
    }

    public final void a(k kVar) {
        TextView textView;
        super.a(kVar);
        if (Build.VERSION.SDK_INT >= 28) {
            kVar.itemView.setAccessibilityHeading(true);
        } else if (Build.VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            if (this.j.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true) && (textView = (TextView) kVar.a(16908310)) != null && textView.getCurrentTextColor() == b.c(this.j, R.color.preference_fallback_accent_color)) {
                textView.setTextColor(typedValue.data);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r11.f3041a.getCollectionItemInfo();
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.core.h.a.c r11) {
        /*
            r10 = this;
            super.a((androidx.core.h.a.c) r11)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0077
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x001d
            android.view.accessibility.AccessibilityNodeInfo r0 = r11.f3041a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = r0.getCollectionItemInfo()
            if (r0 == 0) goto L_0x001d
            androidx.core.h.a.c$c r2 = new androidx.core.h.a.c$c
            r2.<init>(r0)
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r2 != 0) goto L_0x0021
            return
        L_0x0021:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 0
            if (r0 < r1) goto L_0x0030
            java.lang.Object r0 = r2.f3054a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            int r0 = r0.getRowIndex()
            r4 = r0
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x003f
            java.lang.Object r0 = r2.f3054a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            int r0 = r0.getRowSpan()
            r5 = r0
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x004e
            java.lang.Object r0 = r2.f3054a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            int r0 = r0.getColumnIndex()
            r6 = r0
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x005d
            java.lang.Object r0 = r2.f3054a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            int r0 = r0.getColumnSpan()
            r7 = r0
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            r8 = 1
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x006f
            java.lang.Object r0 = r2.f3054a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            boolean r3 = r0.isSelected()
            r9 = r3
            goto L_0x0070
        L_0x006f:
            r9 = 0
        L_0x0070:
            androidx.core.h.a.c$c r0 = androidx.core.h.a.c.C0046c.a(r4, r5, r6, r7, r8, r9)
            r11.b((java.lang.Object) r0)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.PreferenceCategory.a(androidx.core.h.a.c):void");
    }
}
