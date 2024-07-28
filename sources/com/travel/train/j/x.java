package com.travel.train.j;

import android.text.TextUtils;
import com.travel.common.a;
import com.travel.train.b;
import kotlin.g.b.k;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f27611a = new x();

    private x() {
    }

    public static int a() {
        k.a((Object) b.a(), "TrainController.getInstance()");
        a b2 = b.b();
        k.a((Object) b2, "TrainController.getInstance().trainEventListener");
        String f2 = b2.f();
        if (TextUtils.isEmpty(f2)) {
            return 124;
        }
        k.a((Object) f2, "mxabd");
        return Integer.parseInt(f2);
    }
}
