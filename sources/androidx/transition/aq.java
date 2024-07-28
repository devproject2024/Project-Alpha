package androidx.transition;

import android.view.View;

public abstract class aq extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4768a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public final void a(y yVar) {
        View view = yVar.f4851b;
        Integer num = (Integer) yVar.f4850a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        yVar.f4850a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        yVar.f4850a.put("android:visibilityPropagation:center", iArr);
    }

    public final String[] a() {
        return f4768a;
    }

    public static int b(y yVar) {
        Integer num;
        if (yVar == null || (num = (Integer) yVar.f4850a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    static int a(y yVar, int i2) {
        int[] iArr;
        if (yVar == null || (iArr = (int[]) yVar.f4850a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i2];
    }
}
