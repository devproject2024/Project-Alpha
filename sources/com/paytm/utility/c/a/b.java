package com.paytm.utility.c.a;

import android.content.Context;
import androidx.core.app.a;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43777a = new b();

    private b() {
    }

    public static boolean a(Context context, String[] strArr) {
        k.c(strArr, "permissions");
        if (context == null) {
            return true;
        }
        for (String a2 : strArr) {
            if (a.a(context, a2) != 0) {
                return false;
            }
        }
        return true;
    }

    public static String[] a(String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        Collection arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            int i4 = i3 + 1;
            if (iArr[i3] == -1) {
                arrayList.add(str);
            }
            i2++;
            i3 = i4;
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static String[] a(Fragment fragment, String[] strArr, int[] iArr) {
        k.c(fragment, "fragment");
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        Collection arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            int i4 = i3 + 1;
            if (iArr[i3] == -1 && !fragment.shouldShowRequestPermissionRationale(str)) {
                arrayList.add(str);
            }
            i2++;
            i3 = i4;
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
