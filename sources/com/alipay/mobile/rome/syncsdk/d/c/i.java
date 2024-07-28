package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.a.b;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15048a = i.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15049b;

    public i(c cVar) {
        this.f15049b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 2;
    }

    public final void a(a aVar) {
        try {
            int optInt = new JSONObject(aVar.f()).optInt("reconnectTime");
            String str = f15048a;
            h.a(str, "processPacket: [ reconnectInterval=" + optInt + " ]");
            b.b(optInt);
        } catch (JSONException e2) {
            String str2 = f15048a;
            h.d(str2, "processPacket: [ Exception=" + e2 + " ]");
        }
        this.f15049b.f();
    }
}
