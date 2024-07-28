package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.flight.R;
import com.travel.flight.flightticket.e.i;
import com.travel.flight.pojo.flightticket.CJRStatus;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;

public final class AJRFlightModifyTicket extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private com.travel.flight.flightticket.k.b f24774a;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.flight.b.a f24775b;

    /* renamed from: c  reason: collision with root package name */
    private int f24776c = 100;

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24779a;

        c(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24779a = aJRFlightModifyTicket;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                AJRFlightModifyTicket.b(this.f24779a);
            }
        }
    }

    static final class d<T> implements z<CJRFlightMBChargesRoot> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24780a;

        d(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24780a = aJRFlightModifyTicket;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRFlightMBChargesRoot cJRFlightMBChargesRoot = (CJRFlightMBChargesRoot) obj;
            com.travel.flight.b.a c2 = AJRFlightModifyTicket.c(this.f24780a);
            if (cJRFlightMBChargesRoot != null) {
                c2.a(cJRFlightMBChargesRoot);
                AJRFlightModifyTicket.c(this.f24780a).a(AJRFlightModifyTicket.d(this.f24780a).f25266a);
                return;
            }
            throw new u("null cannot be cast to non-null type com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot");
        }
    }

    static final class e<T> implements z<com.travel.flight.pojo.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24781a;

        e(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24781a = aJRFlightModifyTicket;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            NetworkCustomError networkCustomError;
            NetworkCustomError networkCustomError2;
            com.travel.flight.pojo.a aVar = (com.travel.flight.pojo.a) obj;
            if (aVar == null || aVar.f25410a != 401) {
                Context context = this.f24781a;
                String str2 = null;
                if (aVar == null || (networkCustomError2 = aVar.f25411b) == null) {
                    str = null;
                } else {
                    str = networkCustomError2.getAlertTitle();
                }
                if (!(aVar == null || (networkCustomError = aVar.f25411b) == null)) {
                    str2 = networkCustomError.getAlertMessage();
                }
                com.paytm.utility.b.b(context, str, str2);
                return;
            }
            try {
                k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                com.travel.flight.b.b().a((Activity) this.f24781a, (String) null, (Bundle) null, (Exception) null, false, false);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public static final /* synthetic */ com.travel.flight.b.a c(AJRFlightModifyTicket aJRFlightModifyTicket) {
        com.travel.flight.b.a aVar = aJRFlightModifyTicket.f24775b;
        if (aVar == null) {
            k.a("dataBinding");
        }
        return aVar;
    }

    public static final /* synthetic */ com.travel.flight.flightticket.k.b d(AJRFlightModifyTicket aJRFlightModifyTicket) {
        com.travel.flight.flightticket.k.b bVar = aJRFlightModifyTicket.f24774a;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public final void attachBaseContext(Context context) {
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        com.travel.utils.q.a(this);
    }

    public final void onResume() {
        super.onResume();
        com.travel.utils.q.a(this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.activity_flight_mb_charges);
        k.a((Object) a2, "DataBindingUtil.setConte…tivity_flight_mb_charges)");
        this.f24775b = (com.travel.flight.b.a) a2;
        ai a3 = am.a((FragmentActivity) this).a(com.travel.flight.flightticket.k.b.class);
        k.a((Object) a3, "ViewModelProviders.of(th…gesViewModel::class.java)");
        this.f24774a = (com.travel.flight.flightticket.k.b) a3;
        com.travel.flight.b.a aVar = this.f24775b;
        if (aVar == null) {
            k.a("dataBinding");
        }
        aVar.setLifecycleOwner(this);
        com.travel.flight.b.a aVar2 = this.f24775b;
        if (aVar2 == null) {
            k.a("dataBinding");
        }
        com.travel.flight.flightticket.k.b bVar = this.f24774a;
        if (bVar == null) {
            k.a("viewModel");
        }
        aVar2.a(bVar);
        com.travel.flight.flightticket.k.b bVar2 = this.f24774a;
        if (bVar2 == null) {
            k.a("viewModel");
        }
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        k.c(intent, "intent");
        String stringExtra = intent.getStringExtra("orderId");
        k.a((Object) stringExtra, "intent.getStringExtra(\"orderId\")");
        bVar2.f25270e = stringExtra;
        String stringExtra2 = intent.getStringExtra("requestId");
        k.a((Object) stringExtra2, "intent.getStringExtra(\"requestId\")");
        bVar2.f25271f = stringExtra2;
        bVar2.f().setValue(Boolean.TRUE);
        i.b bVar3 = i.f24904a;
        Application application = bVar2.getApplication();
        k.a((Object) application, "getApplication()");
        Context context = application;
        String str = bVar2.f25270e;
        String str2 = bVar2.f25271f;
        i.c cVar = bVar2;
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(str2, "requestId");
        k.c(cVar, "listener");
        if (com.paytm.utility.b.c(context)) {
            String str3 = i.f24905b + "?order_id=" + str + "&request_id=" + str2;
            HashMap hashMap = new HashMap();
            String a4 = com.paytm.utility.d.a(context.getApplicationContext());
            CharSequence charSequence = a4;
            if (!(charSequence == null || charSequence.length() == 0)) {
                hashMap.put(AppConstants.SSO_TOKEN, a4);
            }
            new com.paytm.network.b().a(context.getApplicationContext()).a(a.b.SILENT).c(context.getClass().getSimpleName()).a(a.c.FLIGHT).a(a.C0715a.GET).a(str3).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new CJRFlightMBChargesRoot((CJRStatus) null, (CJRFlightMBChargesBody) null, (String) null, 7, (g) null)).a((com.paytm.network.listener.b) new i.a(cVar)).a(com.travel.flight.utils.c.k("ModifyBookingScreen")).l().a();
        } else {
            cVar.a();
        }
        com.travel.flight.flightticket.k.b bVar4 = this.f24774a;
        if (bVar4 == null) {
            k.a("viewModel");
        }
        LiveData g2 = bVar4.g();
        com.travel.flight.b.a aVar3 = this.f24775b;
        if (aVar3 == null) {
            k.a("dataBinding");
        }
        androidx.lifecycle.q lifecycleOwner = aVar3.getLifecycleOwner();
        if (lifecycleOwner == null) {
            k.a();
        }
        g2.observe(lifecycleOwner, new a(this));
        com.travel.flight.flightticket.k.b bVar5 = this.f24774a;
        if (bVar5 == null) {
            k.a("viewModel");
        }
        y<x> e2 = bVar5.e();
        if (e2 != null) {
            LiveData liveData = e2;
            com.travel.flight.b.a aVar4 = this.f24775b;
            if (aVar4 == null) {
                k.a("dataBinding");
            }
            androidx.lifecycle.q lifecycleOwner2 = aVar4.getLifecycleOwner();
            if (lifecycleOwner2 == null) {
                k.a();
            }
            liveData.observe(lifecycleOwner2, new b(this));
            com.travel.flight.flightticket.k.b bVar6 = this.f24774a;
            if (bVar6 == null) {
                k.a("viewModel");
            }
            LiveData c2 = bVar6.c();
            com.travel.flight.b.a aVar5 = this.f24775b;
            if (aVar5 == null) {
                k.a("dataBinding");
            }
            androidx.lifecycle.q lifecycleOwner3 = aVar5.getLifecycleOwner();
            if (lifecycleOwner3 == null) {
                k.a();
            }
            c2.observe(lifecycleOwner3, new c(this));
            com.travel.flight.flightticket.k.b bVar7 = this.f24774a;
            if (bVar7 == null) {
                k.a("viewModel");
            }
            LiveData d2 = bVar7.d();
            com.travel.flight.b.a aVar6 = this.f24775b;
            if (aVar6 == null) {
                k.a("dataBinding");
            }
            androidx.lifecycle.q lifecycleOwner4 = aVar6.getLifecycleOwner();
            if (lifecycleOwner4 == null) {
                k.a();
            }
            d2.observe(lifecycleOwner4, new d(this));
            com.travel.flight.flightticket.k.b bVar8 = this.f24774a;
            if (bVar8 == null) {
                k.a("viewModel");
            }
            LiveData b2 = bVar8.b();
            com.travel.flight.b.a aVar7 = this.f24775b;
            if (aVar7 == null) {
                k.a("dataBinding");
            }
            androidx.lifecycle.q lifecycleOwner5 = aVar7.getLifecycleOwner();
            if (lifecycleOwner5 == null) {
                k.a();
            }
            b2.observe(lifecycleOwner5, new e(this));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Unit>");
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24782a;

        f(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24782a = aJRFlightModifyTicket;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            AJRFlightModifyTicket.d(this.f24782a).c().setValue(Boolean.FALSE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r8 = (r8 = r8.getBody()).getSearch_date_range();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            r0 = r7
            android.content.Context r0 = (android.content.Context) r0
            com.travel.utils.q.a(r0)
            super.onActivityResult(r8, r9, r10)
            r1 = -1
            if (r9 == r1) goto L_0x000d
            return
        L_0x000d:
            int r9 = r7.f24776c
            if (r8 != r9) goto L_0x022c
            if (r10 == 0) goto L_0x022c
            com.travel.flight.b.a r8 = r7.f24775b
            java.lang.String r9 = "dataBinding"
            if (r8 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x001c:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            r1 = 0
            if (r8 == 0) goto L_0x0034
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x0034
            com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r8 = r8.getSearch_date_range()
            if (r8 == 0) goto L_0x0034
            java.lang.String r8 = r8.getStart()
            goto L_0x0035
        L_0x0034:
            r8 = r1
        L_0x0035:
            java.lang.String r2 = "start_date"
            r10.putExtra(r2, r8)
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x0042
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0042:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x0059
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x0059
            com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r8 = r8.getSearch_date_range()
            if (r8 == 0) goto L_0x0059
            java.lang.String r8 = r8.getEnd()
            goto L_0x005a
        L_0x0059:
            r8 = r1
        L_0x005a:
            java.lang.String r2 = "end_date"
            r10.putExtra(r2, r8)
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x0066
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0066:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x0075
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x0075
            r8.getReturnItem()
        L_0x0075:
            java.lang.Class<com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity> r8 = com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity.class
            r10.setClass(r0, r8)
            java.lang.String r8 = "intent_extra_selected_depart_date"
            java.lang.String r8 = r10.getStringExtra(r8)
            java.lang.String r2 = "dd MMM yy"
            java.lang.String r3 = "yyyy-MM-dd"
            java.lang.String r8 = com.paytm.utility.b.d((java.lang.String) r8, (java.lang.String) r2, (java.lang.String) r3)
            com.travel.flight.flightticket.k.b r2 = r7.f24774a
            java.lang.String r3 = "viewModel"
            if (r2 != 0) goto L_0x0093
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0093:
            java.lang.String r2 = r2.f25271f
            java.lang.String r4 = "MODIFY_BOOKING_REQUEST_ID"
            r10.putExtra(r4, r2)
            com.travel.flight.flightticket.k.b r2 = r7.f24774a
            if (r2 != 0) goto L_0x00a1
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00a1:
            java.lang.String r2 = r2.f25270e
            java.lang.String r4 = "MODIFY_BOOKING_ORDER_ID"
            r10.putExtra(r4, r2)
            r2 = 0
            java.lang.String r4 = "booking_segment"
            r10.putExtra(r4, r2)
            com.travel.flight.b.a r2 = r7.f24775b
            if (r2 != 0) goto L_0x00b5
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x00b5:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r2 = r2.a()
            if (r2 == 0) goto L_0x00d2
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r2 = r2.getBody()
            if (r2 == 0) goto L_0x00d2
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r2 = r2.getOnwardItem()
            if (r2 == 0) goto L_0x00d2
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem r2 = r2.getFlight()
            if (r2 == 0) goto L_0x00d2
            java.lang.String r2 = r2.getOrigin_iata()
            goto L_0x00d3
        L_0x00d2:
            r2 = r1
        L_0x00d3:
            java.lang.String r4 = "source_iata_code"
            r10.putExtra(r4, r2)
            com.travel.flight.b.a r2 = r7.f24775b
            if (r2 != 0) goto L_0x00e0
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x00e0:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r2 = r2.a()
            if (r2 == 0) goto L_0x00fd
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r2 = r2.getBody()
            if (r2 == 0) goto L_0x00fd
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r2 = r2.getOnwardItem()
            if (r2 == 0) goto L_0x00fd
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem r2 = r2.getFlight()
            if (r2 == 0) goto L_0x00fd
            java.lang.String r2 = r2.getDestination_iata()
            goto L_0x00fe
        L_0x00fd:
            r2 = r1
        L_0x00fe:
            java.lang.String r4 = "dest_iata_code"
            r10.putExtra(r4, r2)
            com.travel.flight.pojo.flightticket.b r2 = new com.travel.flight.pojo.flightticket.b
            r2.<init>()
            com.travel.flight.pojo.flightticket.b r4 = new com.travel.flight.pojo.flightticket.b
            r4.<init>()
            com.travel.flight.b.a r5 = r7.f24775b
            if (r5 != 0) goto L_0x0114
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0114:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r5 = r5.a()
            if (r5 == 0) goto L_0x0156
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x0156
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r5 = r5.getOnwardItem()
            if (r5 == 0) goto L_0x0156
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem r5 = r5.getFlight()
            if (r5 == 0) goto L_0x0156
            java.lang.String r6 = r5.getOrigin_airport()
            r2.setAirPortName(r6)
            java.lang.String r6 = r5.getOrigin_iata()
            r2.setShortCityName(r6)
            java.lang.String r6 = r5.getOrigin()
            r2.setCityName(r6)
            java.lang.String r6 = r5.getDestination_airport()
            r4.setAirPortName(r6)
            java.lang.String r6 = r5.getDestination_iata()
            r4.setShortCityName(r6)
            java.lang.String r5 = r5.getDestination()
            r4.setCityName(r5)
        L_0x0156:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r5 = "intent_extra_flight_search_from"
            r10.putExtra(r5, r2)
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r2 = "intent_extra_flight_search_to"
            r10.putExtra(r2, r4)
            java.lang.String r2 = "intent_extra_flight_search_date"
            r10.putExtra(r2, r8)
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x0170
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0170:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x018d
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x018d
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r8 = r8.getOnwardItem()
            if (r8 == 0) goto L_0x018d
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem r8 = r8.getFlight()
            if (r8 == 0) goto L_0x018d
            java.lang.String r8 = r8.getOrigin_iata()
            goto L_0x018e
        L_0x018d:
            r8 = r1
        L_0x018e:
            java.lang.String r2 = "intent_extra_flight_source_city_code"
            r10.putExtra(r2, r8)
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x019a
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x019a:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x01b7
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x01b7
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r8 = r8.getOnwardItem()
            if (r8 == 0) goto L_0x01b7
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem r8 = r8.getFlight()
            if (r8 == 0) goto L_0x01b7
            java.lang.String r8 = r8.getDestination_iata()
            goto L_0x01b8
        L_0x01b7:
            r8 = r1
        L_0x01b8:
            java.lang.String r2 = "intent_extra_flight_destination_city_code"
            r10.putExtra(r2, r8)
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x01c4
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x01c4:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x01d5
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x01d5
            java.lang.String r8 = r8.getBookingClass()
            goto L_0x01d6
        L_0x01d5:
            r8 = r1
        L_0x01d6:
            if (r8 == 0) goto L_0x01ff
            com.travel.flight.utils.j$a r8 = com.travel.flight.utils.j.f25593a
            com.travel.flight.b.a r8 = r7.f24775b
            if (r8 != 0) goto L_0x01e1
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x01e1:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r8 = r8.a()
            if (r8 == 0) goto L_0x01f1
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r8 = r8.getBody()
            if (r8 == 0) goto L_0x01f1
            java.lang.String r1 = r8.getBookingClass()
        L_0x01f1:
            if (r1 != 0) goto L_0x01f6
            kotlin.g.b.k.a()
        L_0x01f6:
            java.lang.String r8 = com.travel.flight.utils.j.a.b(r1, r0)
            java.lang.String r9 = "intent_extra_flight_class_type"
            r10.putExtra(r9, r8)
        L_0x01ff:
            com.travel.flight.flightticket.k.b r8 = r7.f24774a
            if (r8 != 0) goto L_0x0206
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0206:
            int r8 = r8.f25267b
            java.lang.String r9 = "intent_extra_flight_search_no_of_adult_passengers"
            r10.putExtra(r9, r8)
            com.travel.flight.flightticket.k.b r8 = r7.f24774a
            if (r8 != 0) goto L_0x0214
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0214:
            int r8 = r8.f25268c
            java.lang.String r9 = "intent_extra_flight_search_no_of_child_passengers"
            r10.putExtra(r9, r8)
            com.travel.flight.flightticket.k.b r8 = r7.f24774a
            if (r8 != 0) goto L_0x0222
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0222:
            int r8 = r8.f25269d
            java.lang.String r9 = "intent_extra_flight_search_no_of_infants_passengers"
            r10.putExtra(r9, r8)
            r7.startActivity(r10)
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightModifyTicket.onActivityResult(int, int, android.content.Intent):void");
    }

    static final class a<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24777a;

        a(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24777a = aJRFlightModifyTicket;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AJRFlightModifyTicket.a(this.f24777a);
        }
    }

    static final class b<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRFlightModifyTicket f24778a;

        b(AJRFlightModifyTicket aJRFlightModifyTicket) {
            this.f24778a = aJRFlightModifyTicket;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24778a.finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r0 = (r0 = r0.getBody()).getSearch_date_range();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.travel.flight.flightticket.activity.AJRFlightModifyTicket r15) {
        /*
            com.travel.flight.b.a r0 = r15.f24775b
            java.lang.String r1 = "dataBinding"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r0 = r0.a()
            r2 = 0
            if (r0 == 0) goto L_0x0021
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x0021
            com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r0 = r0.getSearch_date_range()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r0.getStart()
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            java.lang.String r3 = "E, dd MMM yy"
            java.lang.String r4 = "yyyy-MM-dd"
            java.lang.String r0 = com.paytm.utility.b.h(r0, r4, r3)
            java.lang.String r4 = "dd MMMM yy"
            java.lang.String r8 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r4)
            r6 = r15
            android.app.Activity r6 = (android.app.Activity) r6
            java.lang.String r11 = com.travel.flight.flightorder.i.c.a(r6)
            r0 = r15
            android.content.Context r0 = (android.content.Context) r0
            com.travel.flight.flightticket.k.b r3 = r15.f24774a
            java.lang.String r4 = "viewModel"
            if (r3 != 0) goto L_0x0045
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0045:
            com.travel.flight.flightticket.k.b r3 = r15.f24774a
            if (r3 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x004c:
            com.travel.flight.flightticket.k.b r3 = r15.f24774a
            if (r3 != 0) goto L_0x0053
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0053:
            java.lang.String r12 = com.travel.flight.utils.c.a((android.content.Context) r0)
            com.travel.flight.b r0 = com.travel.flight.b.a()
            java.lang.String r3 = "FlightController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.travel.flight.c r5 = com.travel.flight.b.b()
            java.util.Locale r7 = new java.util.Locale
            java.lang.String r0 = com.paytm.utility.n.a()
            r7.<init>(r0)
            r9 = 0
            com.travel.flight.b.a r0 = r15.f24775b
            if (r0 != 0) goto L_0x0076
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0076:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r0 = r0.a()
            if (r0 == 0) goto L_0x008e
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x008e
            com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r0 = r0.getSearch_date_range()
            if (r0 == 0) goto L_0x008e
            java.lang.String r0 = r0.getStart()
            r13 = r0
            goto L_0x008f
        L_0x008e:
            r13 = r2
        L_0x008f:
            com.travel.flight.b.a r0 = r15.f24775b
            if (r0 != 0) goto L_0x0096
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0096:
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r0 = r0.a()
            if (r0 == 0) goto L_0x00ac
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x00ac
            com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r0 = r0.getSearch_date_range()
            if (r0 == 0) goto L_0x00ac
            java.lang.String r2 = r0.getEnd()
        L_0x00ac:
            r14 = r2
            android.content.Intent r0 = r5.a((android.app.Activity) r6, (java.util.Locale) r7, (java.lang.String) r8, (long) r9, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)
            int r1 = r15.f24776c
            r15.startActivityForResult(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightModifyTicket.a(com.travel.flight.flightticket.activity.AJRFlightModifyTicket):void");
    }

    public static final /* synthetic */ void b(AJRFlightModifyTicket aJRFlightModifyTicket) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aJRFlightModifyTicket);
        builder.setTitle(aJRFlightModifyTicket.getResources().getString(R.string.no_connection));
        builder.setMessage(aJRFlightModifyTicket.getResources().getString(R.string.no_internet));
        builder.setNegativeButton(aJRFlightModifyTicket.getResources().getString(R.string.ok), new f(aJRFlightModifyTicket));
        builder.show();
    }
}
