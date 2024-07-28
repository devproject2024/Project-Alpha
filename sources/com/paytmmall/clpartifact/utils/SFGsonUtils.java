package com.paytmmall.clpartifact.utils;

import com.google.gson.f;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class SFGsonUtils {
    static final /* synthetic */ i[] $$delegatedProperties = {y.a((v) new w(y.b(SFGsonUtils.class), "mGson", "getMGson()Lcom/google/gson/Gson;"))};
    public static final SFGsonUtils INSTANCE = new SFGsonUtils();
    private static final g mGson$delegate = h.a(SFGsonUtils$mGson$2.INSTANCE);

    public final f getMGson() {
        return (f) mGson$delegate.getValue();
    }

    private SFGsonUtils() {
    }

    public static final <T> Object getClientPojo(Object obj, Class<T> cls, d<? super T> dVar) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new SFGsonUtils$getClientPojo$2(obj, cls, (d) null), dVar);
    }

    public static /* synthetic */ Object getPojo$default(SFGsonUtils sFGsonUtils, String str, Class cls, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return sFGsonUtils.getPojo(str, cls, z);
    }

    public final <T> T getPojo(String str, Class<T> cls, boolean z) {
        k.c(cls, "targetClass");
        if (!z) {
            return getMGson().a(str, cls);
        }
        try {
            return new com.google.gsonhtcfix.f().a(str, cls);
        } catch (Exception e2) {
            HomeUtils.d$default("exception in gson parsing " + e2.getLocalizedMessage(), false, 2, (Object) null);
            LogUtils.printStackTrace(e2);
            return null;
        } catch (IncompatibleClassChangeError unused) {
            return null;
        }
    }

    public static /* synthetic */ Object getPojoFromJson$default(SFGsonUtils sFGsonUtils, String str, Class cls, boolean z, d dVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return sFGsonUtils.getPojoFromJson(str, cls, z, dVar);
    }

    public final <T> Object getPojoFromJson(String str, Class<T> cls, boolean z, d<? super T> dVar) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new SFGsonUtils$getPojoFromJson$2(str, cls, (d) null), dVar);
    }

    public final <T> Object getSFPojo(Object obj, Class<T> cls, d<? super T> dVar) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new SFGsonUtils$getSFPojo$2(obj, cls, (d) null), dVar);
    }

    public static /* synthetic */ Object getPojoFromJsonWithoutCoroutine$default(SFGsonUtils sFGsonUtils, String str, Class cls, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return sFGsonUtils.getPojoFromJsonWithoutCoroutine(str, cls, z);
    }

    public final <T> T getPojoFromJsonWithoutCoroutine(String str, Class<T> cls, boolean z) {
        k.c(cls, "targetClass");
        Utils.assertBackgroundThread();
        return getPojo(str, cls, z);
    }

    public final <T> T getSFPojoWithoutCoroutine(Object obj, Class<T> cls) {
        k.c(cls, "targetClass");
        Utils.assertBackgroundThread();
        try {
            return getPojo$default(this, new com.google.gsonhtcfix.f().a(obj), cls, false, 4, (Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> T fromJson(InputStreamReader inputStreamReader, Class<T> cls) {
        k.c(cls, "classType");
        try {
            return getMGson().a((Reader) inputStreamReader, cls);
        } catch (Exception unused) {
            return null;
        }
    }
}
