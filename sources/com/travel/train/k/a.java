package com.travel.train.k;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.model.e;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class a extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRTrainLSSearchResult> f27612a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<List<CJRBookings>> f27613b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f27614c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<String> f27615d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<CJRTrainLSSearchResult.Train> f27616e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<CJRTrainLSSearchResult.Schedule> f27617f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f27618g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<Boolean> f27619h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<String> f27620i = new y<>();
    public y<Integer> j = new y<>();
    public y<Integer> k = new y<>();
    public y<com.paytm.network.a> l = new y<>();
    public y<Boolean> m = new y<>();
    public y<e> n = new y<>();
    private com.travel.train.a.a o;

    public a(com.travel.train.a.a aVar) {
        k.c(aVar, "mRepo");
        this.o = aVar;
    }

    public final void a(HashMap<String, String> hashMap, String str) {
        k.c(hashMap, "headers");
        k.c(str, "trainNumber");
        this.f27614c.postValue(Boolean.TRUE);
        b bVar = this;
        this.o.a(bVar, bVar, hashMap, str);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27614c.postValue(Boolean.FALSE);
        if (iJRPaytmDataModel instanceof CJRTrainLSSearchResult) {
            this.f27612a.postValue(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27614c.postValue(Boolean.FALSE);
        NetworkCustomError.ErrorType errorType = null;
        this.f27612a.postValue(null);
        e eVar = new e();
        eVar.a(i2);
        eVar.a(iJRPaytmDataModel);
        eVar.a(networkCustomError);
        this.n.postValue(eVar);
        if (networkCustomError != null) {
            errorType = networkCustomError.getErrorType();
        }
        if (errorType == NetworkCustomError.ErrorType.NetworkError) {
            this.l.postValue(this.o.a());
        }
    }

    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public final void a() {
        this.f27619h.postValue(Boolean.TRUE);
    }

    public final void a(CJRTrainLSSearchResult.Train train) {
        this.f27616e.postValue(train);
    }

    public final void a(String str) {
        this.f27620i.postValue(str);
    }

    public final void a(int i2) {
        this.j.postValue(Integer.valueOf(i2));
    }

    public final void b(int i2) {
        this.k.postValue(Integer.valueOf(i2));
    }

    public final void a(boolean z) {
        this.m.postValue(Boolean.valueOf(z));
    }
}
