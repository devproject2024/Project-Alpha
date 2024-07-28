package com.travel.train.f;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.c.b;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import java.util.List;
import kotlin.g.b.k;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public int f26658a = 3;

    /* renamed from: b  reason: collision with root package name */
    public String f26659b;

    /* renamed from: c  reason: collision with root package name */
    public String f26660c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a f26661d;

    public static final class a extends com.google.gson.b.a<List<? extends CJRParcelableMetroStationModel>> {
    }

    public b(b.a aVar) {
        k.c(aVar, "view");
        this.f26661d = aVar;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            this.f26661d.a(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00a0
            boolean r0 = r5 instanceof com.travel.train.model.metro.CJRMetroRouteSearchResponseModel
            if (r0 == 0) goto L_0x00a0
            com.travel.train.model.metro.CJRMetroRouteSearchResponseModel r5 = (com.travel.train.model.metro.CJRMetroRouteSearchResponseModel) r5
            com.travel.train.c.b$a r0 = r4.f26661d
            r1 = 0
            r0.a((boolean) r1)
            if (r5 == 0) goto L_0x0019
            com.travel.train.model.metro.CJRMetroSearchRouteBodyModel r0 = r5.getBody()
            if (r0 == 0) goto L_0x0019
            java.util.List<com.travel.train.model.metro.CJRMetroRouteModel> r0 = r0.routes
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            if (r1 == 0) goto L_0x002d
            com.travel.train.c.b$a r0 = r4.f26661d
            r0.a()
            goto L_0x0042
        L_0x002d:
            com.travel.train.c.b$a r0 = r4.f26661d
            if (r5 != 0) goto L_0x0034
            kotlin.g.b.k.a()
        L_0x0034:
            com.travel.train.model.metro.CJRMetroSearchRouteBodyModel r1 = r5.getBody()
            java.util.List<com.travel.train.model.metro.CJRMetroRouteModel> r1 = r1.routes
            java.lang.String r2 = "dataModel!!.body.routes"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.a((java.util.List<? extends com.travel.train.model.metro.CJRMetroRouteModel>) r1)
        L_0x0042:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.f26659b
            if (r1 != 0) goto L_0x0050
            java.lang.String r2 = "mSource"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0050:
            r0.append(r1)
            java.lang.String r1 = "_to_"
            r0.append(r1)
            java.lang.String r1 = r4.f26660c
            if (r1 != 0) goto L_0x0061
            java.lang.String r2 = "mDest"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0061:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            if (r5 == 0) goto L_0x00a0
            com.travel.train.model.metro.CJRMetroSearchRouteBodyModel r1 = r5.getBody()
            java.lang.String r2 = "/trains/metro"
            java.lang.String r3 = "metro_home"
            if (r1 == 0) goto L_0x0095
            com.travel.train.model.metro.CJRMetroSearchRouteBodyModel r1 = r5.getBody()
            java.util.List<com.travel.train.model.metro.CJRMetroRouteModel> r1 = r1.routes
            if (r1 == 0) goto L_0x0095
            com.travel.train.model.metro.CJRMetroSearchRouteBodyModel r5 = r5.getBody()
            java.util.List<com.travel.train.model.metro.CJRMetroRouteModel> r5 = r5.routes
            int r5 = r5.size()
            if (r5 != 0) goto L_0x0089
            goto L_0x0095
        L_0x0089:
            com.travel.train.c.b$a r5 = r4.f26661d
            android.content.Context r5 = r5.b()
            java.lang.String r1 = "screen_load"
            com.travel.train.j.o.a(r3, r0, r1, r2, r5)
            goto L_0x00a0
        L_0x0095:
            com.travel.train.c.b$a r5 = r4.f26661d
            android.content.Context r5 = r5.b()
            java.lang.String r1 = "no_route_found"
            com.travel.train.j.o.a(r3, r0, r1, r2, r5)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.f.b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }
}
