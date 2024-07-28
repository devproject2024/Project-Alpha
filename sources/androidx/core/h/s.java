package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    Object f3119a;

    private s(Object obj) {
        this.f3119a = obj;
    }

    public static s a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new s(PointerIcon.getSystemIcon(context, 1002));
        }
        return new s((Object) null);
    }
}
