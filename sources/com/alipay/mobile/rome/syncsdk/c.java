package com.alipay.mobile.rome.syncsdk;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.g;
import org.json.JSONException;
import org.json.JSONObject;

final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f15008a;

    c(b bVar) {
        this.f15008a = bVar;
    }

    public final void a(String str) {
        String c2 = b.f15001a;
        h.b(c2, "onReceivedPacket[ packet=" + str + " ]");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId");
            String optString2 = jSONObject.optString("payload");
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    if (this.f15008a.f15004d == null) {
                        h.d(b.f15001a, "onReceivedPacket: [ packetHanlder=null ]");
                        return;
                    } else {
                        a unused = this.f15008a.f15004d;
                        return;
                    }
                }
            }
            h.d(b.f15001a, "onReceivedPacket: [ appId or appData =null or empty ]");
        } catch (JSONException e2) {
            String c3 = b.f15001a;
            h.d(c3, "onReceivedPacket: [ Exception=" + e2 + " ]");
        }
    }

    public final void a() {
        h.b(b.f15001a, "onReceivedPacketSync");
        if (this.f15008a.f15004d == null) {
            h.d(b.f15001a, "onReceivedPacketSync: [ packetHanlder=null ]");
        } else {
            a unused = this.f15008a.f15004d;
        }
    }

    public final void b() {
        h.b(b.f15001a, "onLongLinkRegistered ");
        if (this.f15008a.f15004d == null) {
            h.d(b.f15001a, "onLongLinkRegistered: [ packetHanlder=null ]");
        } else {
            a unused = this.f15008a.f15004d;
        }
    }

    public final void c() {
        h.b(b.f15001a, "onLongLinkDeviceBinded： ");
        if (this.f15008a.f15004d == null) {
            h.d(b.f15001a, "onLongLinkDeviceBinded: [ packetHanlder=null ]");
        } else {
            a unused = this.f15008a.f15004d;
        }
    }

    public final void d() {
        h.b(b.f15001a, "onLongLinkUserBinded： ");
        if (this.f15008a.f15004d == null) {
            h.d(b.f15001a, "onLongLinkUserBinded: [ packetHanlder=null ]");
        } else {
            a unused = this.f15008a.f15004d;
        }
    }
}
