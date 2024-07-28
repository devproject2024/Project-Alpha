package com.travel.train.l;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.travel.train.i.ac;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainCity;
import com.travel.train.model.trainticket.CJRTrainCitySearchCategory;
import com.travel.train.model.trainticket.CJRTrainStation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public class b extends a implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public y<com.paytm.network.a> f27681a;

    /* renamed from: b  reason: collision with root package name */
    public y<IJRDataModel> f27682b;

    /* renamed from: c  reason: collision with root package name */
    public y<ac> f27683c;

    /* renamed from: d  reason: collision with root package name */
    public y<ArrayList> f27684d;

    /* renamed from: e  reason: collision with root package name */
    public y<ArrayList> f27685e;

    /* renamed from: f  reason: collision with root package name */
    public y<String> f27686f;

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f27687g;

    /* renamed from: h  reason: collision with root package name */
    public y<String> f27688h;

    /* renamed from: i  reason: collision with root package name */
    public y<Boolean> f27689i;
    public y<Boolean> j;
    public y<NetworkCustomError> k;
    public y<Boolean> l;
    public y<Boolean> m;
    public y<Boolean> n;
    public y<Boolean> o;
    public y<Boolean> p;
    public c q;
    private String r;
    private String s;
    private Application t;
    private ArrayList<IJRDataModel> u = new ArrayList<>();
    private CJRTrainCity v;
    private String w;
    private String x = "CJRTrainSelectCityViewModel";
    private com.travel.train.a.a y;

    public b(com.travel.train.a.a aVar, Application application, String str, String str2, CJRTrainCity cJRTrainCity, String str3) {
        super(application);
        this.y = aVar;
        this.t = application;
        this.r = str;
        this.s = str2;
        this.v = cJRTrainCity;
        this.w = str3;
        this.l = new y<>();
        this.f27681a = new y<>();
        this.f27687g = new y<>();
        this.f27688h = new y<>();
        this.f27689i = new y<>();
        this.j = new y<>();
        this.k = new y<>();
        this.q = new c();
        this.f27682b = new y<>();
        this.f27683c = new y<>();
        this.f27684d = new y<>();
        this.f27685e = new y<>();
        this.m = new y<>();
        this.n = new y<>();
        this.o = new y<>();
        this.p = new y<>();
        this.f27686f = new y<>();
        a(ac.MOST_POPULAR, "");
        ArrayList<IJRDataModel> arrayList = this.u;
        CJRTrainCity cJRTrainCity2 = this.v;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (cJRTrainCity2.getmTrainSearchedCityDetails() != null) {
            CJRTrainCitySearchCategory cJRTrainCitySearchCategory = new CJRTrainCitySearchCategory();
            cJRTrainCitySearchCategory.setmCategoryTitle("Recently Searched");
            StringBuilder sb = new StringBuilder();
            sb.append(cJRTrainCity2.getmTrainSearchedCityDetails().size());
            this.f27686f.setValue(sb.toString());
            arrayList.add(cJRTrainCitySearchCategory);
            Collections.reverse(cJRTrainCity2.getmTrainSearchedCityDetails());
            arrayList.addAll(cJRTrainCity2.getmTrainSearchedCityDetails());
        }
        this.u = arrayList;
        ArrayList<IJRDataModel> arrayList2 = this.u;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f27685e.setValue(this.u);
        }
    }

    public final void a(ac acVar, String str) {
        this.f27683c.setValue(acVar);
        com.travel.train.b.a();
        String a2 = a(acVar, str, com.travel.train.b.b().L(), this.r, this.s);
        if (o.f(a2)) {
            this.y.a(a2, (com.paytm.network.listener.b) this, (com.paytm.network.listener.b) this, n.b(this.t.getApplicationContext()));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRTrainCity) {
            CJRTrainCity cJRTrainCity = (CJRTrainCity) iJRPaytmDataModel;
            if (g.f27551a == null || !g.f27551a.isNearByStationEnable()) {
                this.l.setValue(Boolean.FALSE);
            } else {
                this.l.setValue(Boolean.TRUE);
            }
            int i2 = AnonymousClass1.f27690a[this.f27683c.getValue().ordinal()];
            if (i2 == 1) {
                String str = this.w;
                ArrayList arrayList = new ArrayList();
                if (!(cJRTrainCity == null || cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null || cJRTrainCity.getTrainStationsList().getStations().size() <= 0)) {
                    CJRTrainCitySearchCategory cJRTrainCitySearchCategory = new CJRTrainCitySearchCategory();
                    cJRTrainCitySearchCategory.setmCategoryTitle(str);
                    arrayList.add(cJRTrainCitySearchCategory);
                    if (!(cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null || cJRTrainCity.getTrainStationsList().getStations().size() <= 0)) {
                        arrayList.addAll(cJRTrainCity.getTrainStationsList().getStations());
                    }
                }
                this.f27685e.setValue(arrayList);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (cJRTrainCity == null || (cJRTrainCity.getTrainStationsList() == null && cJRTrainCity.getTrainRouteList() == null)) {
                        this.j.setValue(Boolean.TRUE);
                        return;
                    }
                    this.o.setValue(Boolean.FALSE);
                    this.p.setValue(Boolean.TRUE);
                    this.f27684d.setValue(b(cJRTrainCity));
                }
            } else if (cJRTrainCity == null || cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null || cJRTrainCity.getTrainStationsList().getStations().size() <= 0) {
                this.f27689i.setValue(Boolean.TRUE);
            } else {
                this.m.setValue(Boolean.TRUE);
                this.n.setValue(Boolean.FALSE);
                this.o.setValue(Boolean.FALSE);
                this.p.setValue(Boolean.TRUE);
                this.l.setValue(Boolean.FALSE);
                this.f27684d.setValue(a(cJRTrainCity));
            }
        }
    }

    /* renamed from: com.travel.train.l.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27690a = new int[ac.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.travel.train.i.ac[] r0 = com.travel.train.i.ac.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27690a = r0
                int[] r0 = f27690a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.i.ac r1 = com.travel.train.i.ac.MOST_POPULAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f27690a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.i.ac r1 = com.travel.train.i.ac.NEAR_BY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f27690a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.i.ac r1 = com.travel.train.i.ac.SEARCH_STATION     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.l.b.AnonymousClass1.<clinit>():void");
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            com.travel.train.model.a aVar = new com.travel.train.model.a();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        aVar = (com.travel.train.model.a) new f().a(new String(networkResponse.data), aVar.getClass());
                    } catch (Exception unused) {
                    }
                }
            }
            if (i2 == 503) {
                this.f27687g.setValue(Boolean.TRUE);
            } else if (!o.a((CharSequence) networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                this.f27688h.setValue(networkCustomError.getUrl());
            } else if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !o.a((CharSequence) aVar.getStatus().getMessage().f27692a) && !o.a((CharSequence) aVar.getStatus().getMessage().f27693b)) {
                this.q.a(aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
            } else if (networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) {
                this.q.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            } else if (networkCustomError.mErrorType == null || networkCustomError.mErrorType != NetworkCustomError.ErrorType.NetworkError) {
                this.k.setValue(networkCustomError);
            } else {
                this.f27681a.setValue(this.y.a());
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    private void a(CJRTrainCitySearchCategory cJRTrainCitySearchCategory) {
        this.f27682b.setValue(cJRTrainCitySearchCategory);
    }

    private String a(ac acVar, String str, String str2, String str3, String str4) {
        int i2 = AnonymousClass1.f27690a[acVar.ordinal()];
        if (i2 == 1) {
            str2 = str2 + acVar.getName();
        } else if (i2 == 2) {
            str2 = str2 + acVar.getName() + "?" + str;
        } else if (i2 == 3) {
            str2 = str2 + str.trim().replace(" ", "%20") + "?";
        }
        String b2 = o.b(this.t.getApplicationContext(), com.paytm.utility.b.s(this.t.getApplicationContext(), str2));
        if (str3 == null || str3.equalsIgnoreCase("source") || str4 == null || o.a((CharSequence) str4)) {
            return b2;
        }
        return b2 + "&source=" + str4.toUpperCase();
    }

    private ArrayList a(CJRTrainCity cJRTrainCity) {
        ArrayList arrayList = new ArrayList();
        if (!(cJRTrainCity == null || cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null)) {
            if (!o.a((CharSequence) cJRTrainCity.getTrainStationsList().getTitle())) {
                CJRTrainCitySearchCategory cJRTrainCitySearchCategory = new CJRTrainCitySearchCategory();
                cJRTrainCitySearchCategory.setmCategoryTitle(cJRTrainCity.getTrainStationsList().getTitle());
                a(cJRTrainCitySearchCategory);
            }
            Iterator<CJRTrainStation> it2 = cJRTrainCity.getTrainStationsList().getStations().iterator();
            while (it2.hasNext()) {
                CJRTrainStation next = it2.next();
                next.setNearByStation(true);
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private ArrayList b(CJRTrainCity cJRTrainCity) {
        ArrayList arrayList = new ArrayList();
        if (!(cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null || cJRTrainCity.getTrainStationsList().getStations().size() <= 0)) {
            if (!o.a((CharSequence) cJRTrainCity.getTrainStationsList().getTitle())) {
                CJRTrainCitySearchCategory cJRTrainCitySearchCategory = new CJRTrainCitySearchCategory();
                cJRTrainCitySearchCategory.setmCategoryTitle(cJRTrainCity.getTrainStationsList().getTitle());
                if (cJRTrainCity.getTrainRouteList() == null || cJRTrainCity.getTrainRouteList().getRoutes() == null || cJRTrainCity.getTrainRouteList().getRoutes().size() <= 0) {
                    a(cJRTrainCitySearchCategory);
                } else {
                    arrayList.add(cJRTrainCitySearchCategory);
                }
            }
            for (int i2 = 0; i2 < cJRTrainCity.getTrainStationsList().getStations().size(); i2++) {
                arrayList.add(cJRTrainCity.getTrainStationsList().getStations().get(i2));
            }
        }
        if (!(cJRTrainCity.getTrainRouteList() == null || cJRTrainCity.getTrainRouteList().getRoutes() == null || cJRTrainCity.getTrainRouteList().getRoutes().size() <= 0)) {
            if (!o.a((CharSequence) cJRTrainCity.getTrainRouteList().getTitle())) {
                CJRTrainCitySearchCategory cJRTrainCitySearchCategory2 = new CJRTrainCitySearchCategory();
                cJRTrainCitySearchCategory2.setmCategoryTitle(cJRTrainCity.getTrainRouteList().getTitle());
                if (cJRTrainCity.getTrainStationsList() == null || cJRTrainCity.getTrainStationsList().getStations() == null || cJRTrainCity.getTrainStationsList().getStations().size() <= 0) {
                    a(cJRTrainCitySearchCategory2);
                } else {
                    arrayList.add(cJRTrainCitySearchCategory2);
                }
            }
            for (int i3 = 0; i3 < cJRTrainCity.getTrainRouteList().getRoutes().size(); i3++) {
                arrayList.add(cJRTrainCity.getTrainRouteList().getRoutes().get(i3));
            }
        }
        return arrayList;
    }
}
