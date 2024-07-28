package com.travel.flight.flightticket.k;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.R;
import com.travel.flight.flightticket.activity.AJRSelectAirportActivity;
import com.travel.flight.pojo.f;
import com.travel.flight.pojo.flightticket.CJRAirportCity;
import com.travel.flight.pojo.flightticket.CJRAirportCityLinguisticItem;
import com.travel.flight.utils.d;
import java.util.ArrayList;
import java.util.HashMap;

public class c extends androidx.lifecycle.a implements b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f25275a;

    /* renamed from: b  reason: collision with root package name */
    public d f25276b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25277c;

    /* renamed from: d  reason: collision with root package name */
    public String f25278d;

    /* renamed from: e  reason: collision with root package name */
    public String f25279e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<f> f25280f;

    /* renamed from: g  reason: collision with root package name */
    public y<com.paytm.network.a> f25281g;

    /* renamed from: h  reason: collision with root package name */
    public y<CJRAirportCity> f25282h;

    /* renamed from: i  reason: collision with root package name */
    public y<Boolean> f25283i;
    public y<CJRAirportCity> j;
    public y<Boolean> k;
    public y l;
    public y m;
    public d n;
    public d o;
    public a p;
    private final String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;

    public static String b() {
        return "&international=true";
    }

    private c(Application application, String str, String str2, String str3, String str4, String str5, ArrayList<f> arrayList) {
        super(application);
        this.q = "international=true";
        this.f25275a = false;
        this.f25277c = application.getApplicationContext();
        this.f25276b = new d();
        this.r = str;
        this.s = str2;
        this.t = str3;
        this.u = str4;
        this.v = str5;
        this.f25280f = arrayList;
        this.f25281g = new y<>();
        this.f25282h = new y<>();
        this.f25283i = new y<>();
        this.j = new y<>();
        this.k = new y<>();
        this.l = new y();
        this.m = new y();
        this.o = new d();
        this.n = new d();
        this.p = new a();
        a();
    }

    public final void a() {
        this.f25275a = true;
        com.travel.flight.b.a();
        String y = com.travel.flight.b.b().y();
        if (URLUtil.isValidUrl(y)) {
            String s2 = com.paytm.utility.b.s(this.f25277c, y);
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f25277c));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f25277c;
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.n = a.b.SILENT;
            bVar.o = AJRSelectAirportActivity.class.getSimpleName();
            bVar.f42880d = s2 + "&international=true";
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJRAirportCity();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            if (com.paytm.utility.b.c(this.f25277c)) {
                l2.f42860d = true;
                l2.a((Object) "mostVisitedCitiesApiTag");
                l2.a();
                return;
            }
            this.f25281g.setValue(l2);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!this.f25275a) {
            if (!(this.f25279e.length() == 0) && (iJRPaytmDataModel instanceof CJRAirportCity)) {
                this.f25283i.setValue(Boolean.FALSE);
                CJRAirportCity cJRAirportCity = (CJRAirportCity) iJRPaytmDataModel;
                if (cJRAirportCity == null || cJRAirportCity.getCjrAirportCityItemBody() == null) {
                    this.l.setValue(null);
                } else if (cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems() != null && cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().size() > 0) {
                    com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
                    bVar.setCityName("");
                    bVar.setItemType(0);
                    cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().add(0, bVar);
                    for (int i2 = 0; i2 < cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().size(); i2++) {
                        com.travel.flight.pojo.flightticket.b bVar2 = cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i2);
                        if (!(bVar2 == null || bVar2.getmNearbyAirportData() == null || bVar2.getmNearbyAirportData().size() <= 0)) {
                            bVar2.setItemType(4);
                        }
                    }
                    this.j.setValue(cJRAirportCity);
                    this.k.setValue(Boolean.FALSE);
                } else if (cJRAirportCity.getCjrAirportCityItemBody().getmAirportRouteItems() == null || cJRAirportCity.getCjrAirportCityItemBody().getmAirportRouteItems().size() <= 0) {
                    this.l.setValue(null);
                } else {
                    CJRAirportCityLinguisticItem cJRAirportCityLinguisticItem = new CJRAirportCityLinguisticItem();
                    cJRAirportCityLinguisticItem.setCityName("");
                    cJRAirportCityLinguisticItem.setItemType(0);
                    cJRAirportCity.getCjrAirportCityItemBody().getmAirportRouteItems().add(0, cJRAirportCityLinguisticItem);
                    this.j.setValue(cJRAirportCity);
                    this.k.setValue(Boolean.FALSE);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRAirportCity) {
            this.f25282h.setValue((CJRAirportCity) iJRPaytmDataModel);
            this.f25283i.setValue(Boolean.FALSE);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.f25283i.setValue(Boolean.FALSE);
            if (networkCustomError != null) {
                networkCustomError.getMessage();
                if (i2 == 503) {
                    this.m.setValue(null);
                } else if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.ParsingError) {
                    this.n.a(networkCustomError.getUrl(), String.valueOf(i2));
                } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                    this.f25277c.getResources().getString(R.string.flight_network_error_message);
                    this.o.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                } else {
                    this.o.a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean a(com.travel.flight.pojo.flightticket.b bVar, boolean z) {
        this.p.a(Boolean.FALSE, "");
        if (bVar != null) {
            if (z && this.v.equals("source") && !TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase(bVar.getShortCityName())) {
                this.p.a(Boolean.TRUE, this.f25277c.getResources().getString(R.string.flight_selected_origin_is_same_as_destination));
                return true;
            } else if (z && this.v.equals("destination") && !TextUtils.isEmpty(this.r) && this.r.equalsIgnoreCase(bVar.getShortCityName())) {
                this.p.a(Boolean.TRUE, this.f25277c.getResources().getString(R.string.flight_selected_destination_is_same_as_origin));
                return true;
            } else if (this.v.equals("source") && !TextUtils.isEmpty(this.u) && this.u.equals(bVar.getCityName())) {
                this.p.a(Boolean.TRUE, this.f25277c.getResources().getString(R.string.flight_selected_origin_is_same_as_destination));
                return true;
            } else if (this.v.equals("destination") && !TextUtils.isEmpty(this.t) && this.t.equals(bVar.getCityName())) {
                this.p.a(Boolean.TRUE, this.f25277c.getResources().getString(R.string.flight_selected_destination_is_same_as_origin));
                return true;
            }
        }
        return false;
    }

    public static class a implements al.b {

        /* renamed from: a  reason: collision with root package name */
        private Application f25284a;

        /* renamed from: b  reason: collision with root package name */
        private String f25285b;

        /* renamed from: c  reason: collision with root package name */
        private String f25286c;

        /* renamed from: d  reason: collision with root package name */
        private String f25287d;

        /* renamed from: e  reason: collision with root package name */
        private String f25288e;

        /* renamed from: f  reason: collision with root package name */
        private String f25289f;

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<f> f25290g;

        public a(Application application, String str, String str2, String str3, String str4, String str5, ArrayList<f> arrayList) {
            this.f25284a = application;
            this.f25285b = str;
            this.f25286c = str2;
            this.f25287d = str3;
            this.f25288e = str4;
            this.f25289f = str5;
            this.f25290g = arrayList;
        }

        public final <T extends ai> T create(Class<T> cls) {
            return new c(this.f25284a, this.f25285b, this.f25286c, this.f25287d, this.f25288e, this.f25289f, this.f25290g);
        }
    }
}
