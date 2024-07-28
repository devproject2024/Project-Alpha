package com.travel.train.k;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.google.gsonhtcfix.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.l.c;
import com.travel.train.model.metro.CJRMetroListModesApiModel;
import com.travel.train.model.trainticket.CJRTrainBookingInformation;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainMsgResponse;
import com.travel.train.model.trainticket.CJRTrainQuickBookFavourites;
import com.travel.train.model.trainticket.CJRTrainRecentBooking;
import java.util.HashMap;
import kotlin.g.b.k;

public final class d extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f27639a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27640b = 3;

    /* renamed from: c  reason: collision with root package name */
    public final long f27641c = 1000;

    /* renamed from: d  reason: collision with root package name */
    public y<CJRTrainMsgResponse> f27642d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f27643e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<Boolean> f27644f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<CJRTrainBookingInformation> f27645g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<CJRTrainHolidayList> f27646h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<CJRTrainQuickBookFavourites> f27647i = new y<>();
    public y<CJRTrainRecentBooking> j = new y<>();
    public y<CJRMetroListModesApiModel> k = new y<>();
    public c l = new c();
    public com.travel.train.a.a m;

    public d(com.travel.train.a.a aVar) {
        k.c(aVar, "mRepo");
        this.m = aVar;
    }

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f27648a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HashMap f27649b;

        public a(d dVar, HashMap hashMap) {
            this.f27648a = dVar;
            this.f27649b = hashMap;
        }

        public final void run() {
            com.travel.train.a.a a2 = this.f27648a.m;
            d dVar = this.f27648a;
            a2.a(dVar, dVar, this.f27649b);
        }
    }

    public final void a(CJRTrainRecentBooking cJRTrainRecentBooking) {
        k.c(cJRTrainRecentBooking, "recentBooking");
        this.j.postValue(cJRTrainRecentBooking);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRTrainMsgResponse) {
            this.f27642d.setValue(iJRPaytmDataModel);
            CJRTrainMsgResponse cJRTrainMsgResponse = (CJRTrainMsgResponse) iJRPaytmDataModel;
            if (cJRTrainMsgResponse.getBody() != null && cJRTrainMsgResponse.getBody().getConfig() != null) {
                g.f27551a = cJRTrainMsgResponse.getBody().getConfig();
            }
        } else if (iJRPaytmDataModel instanceof CJRTrainBookingInformation) {
            this.f27645g.postValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRTrainHolidayList) {
            this.f27646h.postValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRTrainRecentBooking) {
            this.j.postValue(iJRPaytmDataModel);
            CJRTrainRecentBooking cJRTrainRecentBooking = (CJRTrainRecentBooking) iJRPaytmDataModel;
            if (cJRTrainRecentBooking != null && cJRTrainRecentBooking.getRecentBookingBody().getmUserIdList() != null) {
                g.f27552b = cJRTrainRecentBooking.getRecentBookingBody().getmUserIdList();
            }
        } else if (iJRPaytmDataModel instanceof CJRTrainQuickBookFavourites) {
            this.f27647i.postValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRMetroListModesApiModel) {
            this.k.postValue(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof CJRTrainMsgResponse) {
            this.f27643e.postValue(Boolean.TRUE);
            com.travel.train.model.a aVar = new com.travel.train.model.a();
            if (networkCustomError == null) {
                k.a();
            }
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                k.a((Object) networkResponse, "networkCustomError.networkResponse");
                if (networkResponse.data != null) {
                    try {
                        byte[] bArr = networkResponse.data;
                        k.a((Object) bArr, "response.data");
                        Object a2 = new f().a(new String(bArr, kotlin.m.d.f47971a), aVar.getClass());
                        k.a((Object) a2, "Gson().fromJson(jsonStri…NewErrorFormat.javaClass)");
                        aVar = (com.travel.train.model.a) a2;
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (i2 == 451) {
                this.f27644f.postValue(Boolean.TRUE);
            } else {
                this.f27644f.postValue(Boolean.FALSE);
            }
            if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !o.a((CharSequence) aVar.getStatus().getMessage().a()) && !o.a((CharSequence) aVar.getStatus().getMessage().b())) {
                this.l.a(aVar.getStatus().getMessage().a(), aVar.getStatus().getMessage().b());
            } else if (networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) {
                this.l.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        }
    }
}
