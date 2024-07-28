package com.travel.train.k;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.travel.train.a.a;
import com.travel.train.j.o;
import com.travel.train.l.c;
import com.travel.train.model.searchResult.Body;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.searchResult.CalendarData;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.d;

public final class b extends ai implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRSearchByTrainNumberModel> f27621a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<CJRSearchByTrainNumberModel> f27622b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<CJRSearchByTrainNumberModel> f27623c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f27624d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<String> f27625e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public c f27626f = new c();

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f27627g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<String> f27628h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<Boolean> f27629i = new y<>();
    public a j;
    private boolean k;

    public b(a aVar) {
        k.c(aVar, "mRepo");
        this.j = aVar;
    }

    public final void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, boolean z) {
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f27624d.postValue(Boolean.TRUE);
        this.k = z;
        a aVar = this.j;
        if (aVar != null) {
            com.paytm.network.listener.b bVar = this;
            aVar.c(bVar, bVar, hashMap, hashMap2);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27624d.postValue(Boolean.FALSE);
        if (!this.k && (iJRPaytmDataModel instanceof CJRSearchByTrainNumberModel)) {
            Body body = ((CJRSearchByTrainNumberModel) iJRPaytmDataModel).getBody();
            List<CalendarData> calendar = body != null ? body.getCalendar() : null;
            if (calendar == null) {
                k.a();
            }
            if (calendar.isEmpty()) {
                this.f27621a.postValue(iJRPaytmDataModel);
            } else {
                this.f27623c.postValue(iJRPaytmDataModel);
            }
        } else if (iJRPaytmDataModel instanceof CJRSearchByTrainNumberModel) {
            this.f27622b.postValue(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27624d.postValue(Boolean.FALSE);
        com.travel.train.model.a aVar = new com.travel.train.model.a();
        String str = null;
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            k.a((Object) networkResponse, "networkCustomError.networkResponse");
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…NewErrorFormat.javaClass)");
                    aVar = (com.travel.train.model.a) a2;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if (aVar == null || aVar.getStatus() == null || aVar.getStatus().getMessage() == null || o.a((CharSequence) aVar.getStatus().getMessage().a()) || o.a((CharSequence) aVar.getStatus().getMessage().b())) {
            if (networkCustomError != null) {
                str = networkCustomError.getAlertTitle();
            }
            if (str == null || networkCustomError.getAlertMessage() == null) {
                this.f27627g.postValue(Boolean.TRUE);
            } else {
                this.f27626f.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        } else {
            this.f27626f.a(aVar.getStatus().getMessage().a(), aVar.getStatus().getMessage().b());
        }
    }

    public final void a(String str) {
        this.f27628h.postValue(str);
    }

    public final void a(boolean z) {
        this.f27629i.postValue(Boolean.valueOf(z));
    }
}
