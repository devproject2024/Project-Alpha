package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static d f3271a = new DataBinderMapperImpl();

    /* renamed from: b  reason: collision with root package name */
    private static e f3272b = null;

    public static e a() {
        return f3272b;
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z) {
        return a(layoutInflater, i2, viewGroup, z, f3272b);
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, e eVar) {
        int i3 = 0;
        boolean z2 = viewGroup != null && z;
        if (z2) {
            i3 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i2, viewGroup, z);
        if (z2) {
            return a(eVar, viewGroup, i3, i2);
        }
        return a(eVar, inflate, i2);
    }

    public static <T extends ViewDataBinding> T a(View view) {
        e eVar = f3272b;
        T binding = ViewDataBinding.getBinding(view);
        if (binding != null) {
            return binding;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int layoutId = f3271a.getLayoutId((String) tag);
            if (layoutId != 0) {
                return f3271a.getDataBinder(eVar, view, layoutId);
            }
            throw new IllegalArgumentException("View is not a binding layout. Tag: ".concat(String.valueOf(tag)));
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    static <T extends ViewDataBinding> T a(e eVar, View[] viewArr, int i2) {
        return f3271a.getDataBinder(eVar, viewArr, i2);
    }

    static <T extends ViewDataBinding> T a(e eVar, View view, int i2) {
        return f3271a.getDataBinder(eVar, view, i2);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int i2) {
        e eVar = f3272b;
        activity.setContentView(i2);
        return a(eVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i2);
    }

    private static <T extends ViewDataBinding> T a(e eVar, ViewGroup viewGroup, int i2, int i3) {
        int childCount = viewGroup.getChildCount();
        int i4 = childCount - i2;
        if (i4 == 1) {
            return a(eVar, viewGroup.getChildAt(childCount - 1), i3);
        }
        View[] viewArr = new View[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            viewArr[i5] = viewGroup.getChildAt(i5 + i2);
        }
        return a(eVar, viewArr, i3);
    }
}
