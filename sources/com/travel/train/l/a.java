package com.travel.train.l;

import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.google.gsonhtcfix.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.travel.train.model.c;
import com.travel.train.model.trainticket.CJRTrainPNRStatus;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;

public final class a extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRTrainPNRStatus> f27675a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f27676b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<NetworkCustomError> f27677c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<NetworkCustomError> f27678d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public c f27679e = new c();

    /* renamed from: f  reason: collision with root package name */
    public com.travel.train.a.a f27680f;

    public a(com.travel.train.a.a aVar) {
        k.c(aVar, "mRepo");
        this.f27680f = aVar;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27676b.postValue(Boolean.FALSE);
        if (iJRPaytmDataModel instanceof CJRTrainPNRStatus) {
            this.f27675a.postValue(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27676b.postValue(Boolean.FALSE);
        com.travel.train.model.a aVar = new com.travel.train.model.a();
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…NewErrorFormat.javaClass)");
                    aVar = (com.travel.train.model.a) a2;
                } catch (Exception unused) {
                }
            }
        }
        if (i2 == 503) {
            this.f27677c.postValue(networkCustomError);
            return;
        }
        if (networkCustomError == null) {
            k.a();
        }
        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !p.a(networkCustomError.getMessage(), "parsing_error", true)) {
            if (!(aVar == null || aVar.getStatus() == null)) {
                com.travel.train.model.b status = aVar.getStatus();
                k.a((Object) status, "cjrNewErrorFormat.status");
                if (status.getMessage() != null) {
                    com.travel.train.model.b status2 = aVar.getStatus();
                    k.a((Object) status2, "cjrNewErrorFormat.status");
                    c message = status2.getMessage();
                    k.a((Object) message, "cjrNewErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message.a())) {
                        com.travel.train.model.b status3 = aVar.getStatus();
                        k.a((Object) status3, "cjrNewErrorFormat.status");
                        c message2 = status3.getMessage();
                        k.a((Object) message2, "cjrNewErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message2.b())) {
                            c cVar = this.f27679e;
                            com.travel.train.model.b status4 = aVar.getStatus();
                            k.a((Object) status4, "cjrNewErrorFormat.status");
                            c message3 = status4.getMessage();
                            k.a((Object) message3, "cjrNewErrorFormat.status.message");
                            String a3 = message3.a();
                            com.travel.train.model.b status5 = aVar.getStatus();
                            k.a((Object) status5, "cjrNewErrorFormat.status");
                            c message4 = status5.getMessage();
                            k.a((Object) message4, "cjrNewErrorFormat.status.message");
                            cVar.a(a3, message4.b());
                            return;
                        }
                    }
                }
            }
            if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                this.f27679e.a("", "");
            } else {
                this.f27679e.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        } else {
            this.f27678d.postValue(networkCustomError);
        }
    }
}
