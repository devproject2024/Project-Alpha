package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.service.c;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15046a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15047b;

    public h(c cVar) {
        this.f15047b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 4;
    }

    public final void a(a aVar) {
        com.alipay.mobile.rome.syncsdk.e.h.b(f15046a, "processPacket: [ PacketListenerImplNotification ] ");
        String f2 = aVar.f();
        if (f2.length() == 0) {
            com.alipay.mobile.rome.syncsdk.e.h.c(f15046a, "processPacket: [ jsonString=null ]");
        }
        try {
            JSONObject jSONObject = new JSONObject(f2);
            com.alipay.mobile.rome.syncsdk.c.a aVar2 = new com.alipay.mobile.rome.syncsdk.c.a();
            aVar2.setUserId(jSONObject.optString("linkToken"));
            aVar2.setMsgData(jSONObject.optString("msgData"));
            aVar2.setMsgKey(jSONObject.optString("msgKey"));
            aVar2.setTimestamp(jSONObject.optString("msgCreateTime"));
            aVar2.setPerMsgId(aVar2.getTimestamp() + aVar2.getMsgKey());
            String str = f15046a;
            com.alipay.mobile.rome.syncsdk.e.h.a(str, "handlePushMsg:[ msgkey=" + aVar2.getMsgKey() + " ][ timestamp=" + aVar2.getTimestamp() + " ][ userId=" + aVar2.getUserId() + " ][ msgData=" + aVar2.getMsgData() + " ]");
            com.alipay.mobile.rome.syncsdk.e.h.b(f15046a, "dispatchMsgData: ");
            com.alipay.mobile.rome.syncsdk.c.c cVar = new com.alipay.mobile.rome.syncsdk.c.c(this.f15047b.f15131a);
            cVar.a(aVar2.getUserId());
            if (cVar.a(aVar2)) {
                com.alipay.mobile.rome.syncsdk.e.h.c(f15046a, "dispatchMsgData: Duplicated Packet ");
            } else {
                cVar.b(aVar2);
                com.alipay.mobile.rome.syncsdk.e.h.a(f15046a, "dispatchMsgData: saved msg ");
                if (this.f15047b.l() == null) {
                    com.alipay.mobile.rome.syncsdk.e.h.d(f15046a, "dispatchMsgData: [ packetNotifier=null ] ");
                } else {
                    this.f15047b.l().a(aVar2.getMsgData());
                }
            }
            com.alipay.mobile.rome.syncsdk.e.h.b(f15046a, "handlePacketResponse: ");
            if (aVar.b() != 1) {
                a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15047b.m());
                a2.a(4);
                a2.b(1);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("linkToken", com.alipay.mobile.rome.syncsdk.a.a.a().f14988a);
                    jSONObject2.put("msgKey", aVar2.getMsgKey());
                    a2.a(jSONObject2.toString());
                    this.f15047b.k().a(a2);
                } catch (Exception e2) {
                    String str2 = f15046a;
                    com.alipay.mobile.rome.syncsdk.e.h.d(str2, "handlePacketResponse: [ Exception=" + e2 + " ]");
                }
            }
        } catch (JSONException e3) {
            String str3 = f15046a;
            com.alipay.mobile.rome.syncsdk.e.h.d(str3, "processPacket: [ Exception=" + e3 + " ]");
        }
    }
}
