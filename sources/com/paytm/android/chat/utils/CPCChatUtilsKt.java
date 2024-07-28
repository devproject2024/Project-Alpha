package com.paytm.android.chat.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.w;
import com.paytm.android.chat.f;
import io.reactivex.rxjava3.a.y;
import kotlin.g.b.k;

public final class CPCChatUtilsKt {
    public static final y<w> registerPushToken() {
        FirebaseInstanceId a2 = FirebaseInstanceId.a();
        k.a((Object) a2, "FirebaseInstanceId.getInstance()");
        Task<w> f2 = a2.f();
        k.a((Object) f2, "FirebaseInstanceId.getInstance().instanceId");
        return f.a(f2);
    }

    public static final float dpToPx(Context context, float f2) {
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        return TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }
}
