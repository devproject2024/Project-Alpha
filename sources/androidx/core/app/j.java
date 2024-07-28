package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import com.alipay.mobile.h5container.api.H5Param;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2750a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f2751b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2752c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2753d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f2750a) {
            if (f2752c) {
                return null;
            }
            try {
                if (f2751b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        f2752c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2751b = declaredField;
                }
                Bundle bundle = (Bundle) f2751b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2751b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                f2752c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, h.a aVar) {
        int i2;
        IconCompat a2 = aVar.a();
        if (a2 != null) {
            i2 = a2.b();
        } else {
            i2 = 0;
        }
        builder.addAction(i2, aVar.f2707i, aVar.j);
        Bundle bundle = new Bundle(aVar.f2699a);
        if (aVar.f2700b != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f2700b));
        }
        if (aVar.f2701c != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.f2701c));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f2702d);
        return bundle;
    }

    static Bundle a(h.a aVar) {
        int i2;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat a2 = aVar.a();
        if (a2 != null) {
            i2 = a2.b();
        } else {
            i2 = 0;
        }
        bundle2.putInt(H5Param.MENU_ICON, i2);
        bundle2.putCharSequence("title", aVar.f2707i);
        bundle2.putParcelable("actionIntent", aVar.j);
        if (aVar.f2699a != null) {
            bundle = new Bundle(aVar.f2699a);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f2702d);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f2700b));
        bundle2.putBoolean("showsUserInterface", aVar.f2703e);
        bundle2.putInt("semanticAction", aVar.f2704f);
        return bundle2;
    }

    private static Bundle[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            m mVar = mVarArr[i2];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", mVar.f2793a);
            bundle.putCharSequence("label", mVar.f2794b);
            bundle.putCharSequenceArray("choices", mVar.f2795c);
            bundle.putBoolean("allowFreeFormInput", mVar.f2796d);
            bundle.putBundle("extras", mVar.f2797e);
            Set<String> set = mVar.f2798f;
            if (set != null && !set.isEmpty()) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i2] = bundle;
        }
        return bundleArr;
    }
}
