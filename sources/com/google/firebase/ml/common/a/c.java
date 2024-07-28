package com.google.firebase.ml.common.a;

import com.google.android.gms.common.internal.q;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<a, String> f39063c = new EnumMap(a.class);

    /* renamed from: d  reason: collision with root package name */
    private static final Map<a, String> f39064d;

    /* renamed from: a  reason: collision with root package name */
    private final String f39065a;

    /* renamed from: b  reason: collision with root package name */
    private final a f39066b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q.a(this.f39065a, cVar.f39065a) && q.a(this.f39066b, cVar.f39066b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39065a, this.f39066b});
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        f39064d = enumMap;
        enumMap.put(a.FACE_DETECTION, "face_detector_model_m41");
        f39064d.put(a.SMART_REPLY, "smart_reply_model_m41");
        f39064d.put(a.TRANSLATE, "translate_model_m41");
        f39063c.put(a.FACE_DETECTION, "modelHash");
        f39063c.put(a.SMART_REPLY, "smart_reply_model_hash");
        f39063c.put(a.TRANSLATE, "modelHash");
    }
}
