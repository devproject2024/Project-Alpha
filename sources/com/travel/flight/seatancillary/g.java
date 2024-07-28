package com.travel.flight.seatancillary;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvailability;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatAncillaryCombinedModel;
import com.travel.flight.seatancillary.b.a;
import java.util.HashMap;

public final class g implements a.b.C0477a, a.c {

    /* renamed from: a  reason: collision with root package name */
    private a.b f25492a;

    /* renamed from: b  reason: collision with root package name */
    private a.d f25493b;

    /* renamed from: c  reason: collision with root package name */
    private int f25494c;

    /* renamed from: d  reason: collision with root package name */
    private int f25495d = 0;

    public g(a.d dVar) {
        this.f25493b = dVar;
        this.f25492a = new f(this, (Context) dVar);
    }

    public final void a() {
        this.f25492a.a();
        this.f25492a = null;
        this.f25493b = null;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f25493b.g();
        b(hashMap);
        c(hashMap);
    }

    private void b(HashMap<String, String> hashMap) {
        this.f25493b.g();
        if (this.f25492a.a(hashMap)) {
            this.f25495d++;
        }
    }

    private void c(HashMap<String, String> hashMap) {
        this.f25493b.g();
        if (this.f25492a.b(hashMap)) {
            this.f25495d++;
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f25494c++;
        if (this.f25494c >= this.f25495d) {
            this.f25493b.h();
            this.f25494c = 0;
            this.f25495d = 0;
        }
        if (iJRPaytmDataModel instanceof CJRSeatAvailability) {
            this.f25493b.a((CJRSeatAvailability) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRSeatAncillaryCombinedModel) {
            this.f25493b.a((CJRSeatAncillaryCombinedModel) iJRPaytmDataModel);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f25493b.h();
        this.f25494c = 0;
        this.f25495d = 0;
        if (iJRPaytmDataModel instanceof CJRSeatAvailability) {
            this.f25493b.a(networkCustomError);
        } else if (iJRPaytmDataModel instanceof CJRSeatAncillaryCombinedModel) {
            this.f25493b.b(networkCustomError);
        }
    }
}
