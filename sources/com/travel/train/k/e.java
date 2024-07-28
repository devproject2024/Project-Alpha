package com.travel.train.k;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.train.a.a;
import com.travel.train.j.i;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainLsDateModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.u;

public final class e extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public String f27650a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f27651b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f27652c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f27653d = "";

    /* renamed from: e  reason: collision with root package name */
    public CJRTrainLSSearchResult.Train f27654e;

    /* renamed from: f  reason: collision with root package name */
    public String f27655f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f27656g = "";

    /* renamed from: h  reason: collision with root package name */
    public y<Boolean> f27657h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<CJRTrainLSSearchResult.Train> f27658i = new y<>();
    public y<CJRTrainLSSearchResult.Schedule> j = new y<>();
    public y<ArrayList<CJRTrainLsDateModel>> k = new y<>();
    public y<Boolean> l = new y<>();
    public y<Boolean> m = new y<>();
    public a n;
    private ArrayList<CJRTrainLsDateModel> o;
    private final String p = "CJRTrainLiveStatusViewModel";

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public e(a aVar) {
        k.c(aVar, "mRepo");
        this.n = aVar;
        this.f27657h.setValue(Boolean.FALSE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r0 = r5.getMeta();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00d9
            boolean r0 = r5 instanceof com.travel.train.model.trainticket.CJRTrainLSSearchResult
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r5 = r1
        L_0x0008:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult) r5
            if (r5 == 0) goto L_0x0017
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Meta r0 = r5.getMeta()
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.getServer_timestamp_ist()
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 != 0) goto L_0x001d
            kotlin.g.b.k.a()
        L_0x001d:
            r4.f27656g = r0
            java.util.List r0 = r5.getBody()
            if (r0 == 0) goto L_0x00e0
            java.util.List r5 = r5.getBody()
            if (r5 == 0) goto L_0x00e0
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x00e0
            r0 = 0
            java.lang.Object r2 = r5.get(r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Body r2 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Body) r2
            if (r2 == 0) goto L_0x0049
            java.util.ArrayList r2 = r2.getTrains()
            if (r2 == 0) goto L_0x0049
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x004a
        L_0x0049:
            r2 = r1
        L_0x004a:
            if (r2 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x00e0
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r2 = r4.f27658i
            java.lang.Object r5 = r5.get(r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Body r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Body) r5
            if (r5 == 0) goto L_0x006c
            java.util.ArrayList r5 = r5.getTrains()
            if (r5 == 0) goto L_0x006c
            java.lang.Object r5 = r5.get(r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r5
            goto L_0x006d
        L_0x006c:
            r5 = r1
        L_0x006d:
            r2.setValue(r5)
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r5 = r4.f27658i
            java.lang.Object r5 = r5.getValue()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r5
            r4.f27654e = r5
            java.lang.String r5 = r4.f27655f
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r4.f27654e
            if (r0 == 0) goto L_0x008f
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x008f
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0090
        L_0x008f:
            r0 = r1
        L_0x0090:
            if (r0 != 0) goto L_0x0095
            kotlin.g.b.k.a()
        L_0x0095:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00ce
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r4.f27654e
            if (r0 == 0) goto L_0x00a3
            java.util.List r1 = r0.getSchedule()
        L_0x00a3:
            if (r1 != 0) goto L_0x00a8
            kotlin.g.b.k.a()
        L_0x00a8:
            java.util.Iterator r0 = r1.iterator()
        L_0x00ac:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00ce
            java.lang.Object r1 = r0.next()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            java.lang.String r2 = "schedule"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r2 = r1.getStationCode()
            r3 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x00ac
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r2 = r4.j
            r2.setValue(r1)
            goto L_0x00ac
        L_0x00ce:
            androidx.lifecycle.y<java.lang.Boolean> r5 = r4.f27657h
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r5.setValue(r0)
            r4.a()
            return
        L_0x00d9:
            androidx.lifecycle.y<java.lang.Boolean> r5 = r4.f27657h
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r5.setValue(r0)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.k.e.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a() {
        String runningOn;
        CJRTrainLSSearchResult.Train train = this.f27654e;
        char[] cArr = null;
        if ((train != null ? train.getRunningOn() : null) != null) {
            try {
                Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(this.f27656g);
                k.a((Object) parse, "dateFormat.parse(mServerDateIST)");
                Calendar instance = Calendar.getInstance(Locale.ENGLISH);
                k.a((Object) instance, "Calendar.getInstance(Locale.ENGLISH)");
                instance.setTime(parse);
                CJRTrainLSSearchResult.Train train2 = this.f27654e;
                if (!(train2 == null || (runningOn = train2.getRunningOn()) == null)) {
                    if (runningOn != null) {
                        cArr = runningOn.toCharArray();
                        k.a((Object) cArr, "(this as java.lang.String).toCharArray()");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                this.o = new ArrayList<>();
                ArrayList<CJRTrainLsDateModel> arrayList = this.o;
                if (arrayList != null) {
                    arrayList.addAll(i.a(cArr, this.j.getValue(), this.f27656g));
                }
                ArrayList<CJRTrainLsDateModel> arrayList2 = this.o;
                if (arrayList2 != null) {
                    arrayList2.addAll(i.b(cArr, this.j.getValue(), this.f27656g));
                }
                this.k.setValue(this.o);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public final int a(ArrayList<CJRTrainLsDateModel> arrayList) {
        Date date;
        k.c(arrayList, "mLSDates");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(this.f27656g);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            date = null;
        }
        if (date == null) {
            return 0;
        }
        int size = arrayList.size();
        long j2 = 1000000000;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            CJRTrainLsDateModel cJRTrainLsDateModel = arrayList.get(i3);
            k.a((Object) cJRTrainLsDateModel, "mLSDates[index]");
            Date date2 = cJRTrainLsDateModel.getDate();
            k.a((Object) date2, "itemDate");
            long abs = Math.abs(date2.getTime() - date.getTime());
            if (abs < j2) {
                i2 = i3;
                j2 = abs;
            }
        }
        return i2;
    }
}
