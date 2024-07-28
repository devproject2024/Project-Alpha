package com.travel.flight.flightSRPV2.view.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.paytm.utility.n;
import com.travel.flight.R;
import com.travel.flight.b.cm;
import com.travel.flight.flightSRPV2.a.l;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.utils.j;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;

public final class FlightSRPV2Activity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private SRPSharedViewModel f24217a;

    /* renamed from: b  reason: collision with root package name */
    private SRPModifyViewModel f24218b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.flight.b.c f24219c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f24220d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f24221e;

    public final View a(int i2) {
        if (this.f24221e == null) {
            this.f24221e = new HashMap();
        }
        View view = (View) this.f24221e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f24221e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<com.travel.flight.flightSRPV2.b.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24222a;

        a(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24222a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.flight.flightSRPV2.b.d dVar = (com.travel.flight.flightSRPV2.b.d) obj;
            k.a((Object) dVar, "it");
            com.travel.flight.flightSRPV2.b.f.f24150a.a(this.f24222a, dVar);
        }
    }

    static final class b<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24223a;

        b(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24223a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null && num.intValue() == 2) {
                com.travel.flight.flightSRPV2.b.f.f24150a.a(this.f24223a, new com.travel.flight.flightSRPV2.b.c("PAGE_SRP_SHIMMER", (com.travel.flight.flightSRPV2.b.e) null, R.id.container_child_shimmer, true, "PAGE_SRP_SHIMMER"));
            } else if (num != null && num.intValue() == 1) {
                com.travel.flight.flightSRPV2.b.f.f24150a.a(this.f24223a, new com.travel.flight.flightSRPV2.b.c("PAGE_SRP_LOADING", new com.travel.flight.flightSRPV2.b.e(R.anim.enter_anim_slide_from_bottom_to_top_slow, R.anim.exit_anim_slide_from_bottom_to_top_slow), R.id.container_full_overlay, true, "PAGE_SRP_LOADING"));
            } else if (num != null && num.intValue() == 0) {
                com.travel.flight.flightSRPV2.b.f.f24150a.a(this.f24223a);
            }
        }
    }

    static final class c<T> implements z<com.travel.flight.flightSRPV2.b.b<Object, Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24224a;

        c(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24224a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.flight.flightSRPV2.b.b bVar = (com.travel.flight.flightSRPV2.b.b) obj;
            AnonymousClass1 r0 = new kotlin.g.a.b<Object, String>(this) {
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final String invoke(Object obj) {
                    k.c(obj, "obj");
                    if (!(obj instanceof Integer)) {
                        return obj instanceof String ? (String) obj : "";
                    }
                    String string = this.this$0.f24224a.getResources().getString(((Number) obj).intValue());
                    k.a((Object) string, "resources.getString(obj)");
                    return string;
                }
            };
            com.paytm.utility.b.b((Context) this.f24224a, r0.invoke((Object) bVar.f24140a), r0.invoke((Object) bVar.f24141b));
        }
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24225a;

        d(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24225a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.paytm.utility.b.g(this.f24225a, (String) obj);
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24227a;

        f(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24227a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Toast.makeText(this.f24227a, (String) obj, 0).show();
        }
    }

    static final class i<T> implements z<SRPSharedViewModel.OpenCalendar> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24231a;

        i(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24231a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Intent intent;
            SRPSharedViewModel.OpenCalendar openCalendar = (SRPSharedViewModel.OpenCalendar) obj;
            if (openCalendar != null) {
                k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                com.travel.flight.c b2 = com.travel.flight.b.b();
                k.a((Object) b2, "FlightController.getInstance().flightEventListener");
                String s = com.paytm.utility.b.s(this.f24231a, b2.g());
                if (openCalendar instanceof SRPSharedViewModel.OpenCalendar.OpenOneWayCalendar) {
                    CJRFlightSearchInput value = FlightSRPV2Activity.b(this.f24231a).getSearchInput().getValue();
                    if ((value != null ? value.getBookingSegment() : null) == com.travel.flight.flightticket.d.b.Modify) {
                        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                        com.travel.flight.c b3 = com.travel.flight.b.b();
                        Activity activity = this.f24231a;
                        Locale locale = new Locale(n.a());
                        SRPSharedViewModel.OpenCalendar.OpenOneWayCalendar openOneWayCalendar = (SRPSharedViewModel.OpenCalendar.OpenOneWayCalendar) openCalendar;
                        String selectedDate = openOneWayCalendar.getSelectedDate();
                        long previouslySelectedDate = openOneWayCalendar.getPreviouslySelectedDate();
                        String fareDisclaimer = openCalendar.getFareDisclaimer();
                        CJRFlightSearchInput value2 = FlightSRPV2Activity.b(this.f24231a).getSearchInput().getValue();
                        String modifyStartDateRange = value2 != null ? value2.getModifyStartDateRange() : null;
                        CJRFlightSearchInput value3 = FlightSRPV2Activity.b(this.f24231a).getSearchInput().getValue();
                        intent = b3.a(activity, locale, selectedDate, previouslySelectedDate, s, fareDisclaimer, modifyStartDateRange, value3 != null ? value3.getModifyEndDateRange() : null);
                    } else {
                        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                        SRPSharedViewModel.OpenCalendar.OpenOneWayCalendar openOneWayCalendar2 = (SRPSharedViewModel.OpenCalendar.OpenOneWayCalendar) openCalendar;
                        intent = com.travel.flight.b.b().a((Activity) this.f24231a, new Locale(n.a()), openOneWayCalendar2.getSelectedDate(), openOneWayCalendar2.getPreviouslySelectedDate(), s, openCalendar.getFareDisclaimer());
                    }
                } else if (openCalendar instanceof SRPSharedViewModel.OpenCalendar.OpenTwoWayCalendar) {
                    k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                    SRPSharedViewModel.OpenCalendar.OpenTwoWayCalendar openTwoWayCalendar = (SRPSharedViewModel.OpenCalendar.OpenTwoWayCalendar) openCalendar;
                    intent = com.travel.flight.b.b().a((Activity) this.f24231a, openTwoWayCalendar.getTabTypeToOpenInitially(), new Locale(n.a()), openTwoWayCalendar.getDepartDateWIthYear(), openTwoWayCalendar.getPreviouslySelectedDate(), openTwoWayCalendar.getReturnDateWithYear(), s, openCalendar.getFareDisclaimer());
                } else {
                    throw new m();
                }
                this.f24231a.startActivityForResult(intent, openCalendar.getRequestCode());
            }
        }
    }

    public static final /* synthetic */ SRPSharedViewModel b(FlightSRPV2Activity flightSRPV2Activity) {
        SRPSharedViewModel sRPSharedViewModel = flightSRPV2Activity.f24217a;
        if (sRPSharedViewModel == null) {
            k.a("viewModel");
        }
        return sRPSharedViewModel;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.activity_flight_srp_v2);
        k.a((Object) a2, "DataBindingUtil.setConte…t.activity_flight_srp_v2)");
        this.f24219c = (com.travel.flight.b.c) a2;
        FragmentActivity fragmentActivity = this;
        ai a3 = am.a(fragmentActivity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(th…redViewModel::class.java)");
        this.f24217a = (SRPSharedViewModel) a3;
        SRPSharedViewModel sRPSharedViewModel = this.f24217a;
        if (sRPSharedViewModel == null) {
            k.a("viewModel");
        }
        ai a4 = am.a(fragmentActivity, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (kotlin.g.b.g) null)).a(SRPModifyViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…ifyViewModel::class.java)");
        this.f24218b = (SRPModifyViewModel) a4;
        com.travel.flight.b.c cVar = this.f24219c;
        if (cVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel2 = this.f24217a;
        if (sRPSharedViewModel2 == null) {
            k.a("viewModel");
        }
        cVar.a(sRPSharedViewModel2);
        com.travel.flight.b.c cVar2 = this.f24219c;
        if (cVar2 == null) {
            k.a("dataBinding");
        }
        q qVar = this;
        cVar2.setLifecycleOwner(qVar);
        SRPSharedViewModel sRPSharedViewModel3 = this.f24217a;
        if (sRPSharedViewModel3 == null) {
            k.a("viewModel");
        }
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        sRPSharedViewModel3.initData(intent);
        SRPSharedViewModel sRPSharedViewModel4 = this.f24217a;
        if (sRPSharedViewModel4 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel4.getNavigator().observe(qVar, new a(this));
        SRPSharedViewModel sRPSharedViewModel5 = this.f24217a;
        if (sRPSharedViewModel5 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel5.getProgressState().observe(qVar, new b(this));
        SRPSharedViewModel sRPSharedViewModel6 = this.f24217a;
        if (sRPSharedViewModel6 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel6.getDialogEvent().observe(qVar, new c(this));
        SRPSharedViewModel sRPSharedViewModel7 = this.f24217a;
        if (sRPSharedViewModel7 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel7.getDataDisplayErrorEvent().observe(qVar, new d(this));
        SRPSharedViewModel sRPSharedViewModel8 = this.f24217a;
        if (sRPSharedViewModel8 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel8.getOnBackPressedEvent().observe(qVar, new e(this));
        SRPSharedViewModel sRPSharedViewModel9 = this.f24217a;
        if (sRPSharedViewModel9 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel9.getToastMessageEvent().observe(qVar, new f(this));
        SRPSharedViewModel sRPSharedViewModel10 = this.f24217a;
        if (sRPSharedViewModel10 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel10.getSetResultListener().observe(qVar, new g(this));
        SRPSharedViewModel sRPSharedViewModel11 = this.f24217a;
        if (sRPSharedViewModel11 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel11.getFareAlertEvent().observe(qVar, new h(this));
        SRPSharedViewModel sRPSharedViewModel12 = this.f24217a;
        if (sRPSharedViewModel12 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel12.getOpenCalendarEvent().observe(qVar, new i(this));
        SRPSharedViewModel sRPSharedViewModel13 = this.f24217a;
        if (sRPSharedViewModel13 == null) {
            k.a("viewModel");
        }
        sRPSharedViewModel13.refresh(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.f24220d;
        if (popupWindow != null) {
            if (popupWindow == null) {
                k.a();
            }
            if (popupWindow.isShowing()) {
                PopupWindow popupWindow2 = this.f24220d;
                if (popupWindow2 == null) {
                    k.a();
                }
                popupWindow2.dismiss();
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        FlightSRPV2Activity.class.getSimpleName();
        if (i3 == -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 201) {
                                if (i2 != 202) {
                                    if (i2 == 205 && intent != null) {
                                        SRPModifyViewModel sRPModifyViewModel = this.f24218b;
                                        if (sRPModifyViewModel == null) {
                                            k.a("srpModifyViewModel");
                                        }
                                        sRPModifyViewModel.setUpdatedTravellerInfo(intent, this);
                                    }
                                } else if (intent != null) {
                                    SRPModifyViewModel sRPModifyViewModel2 = this.f24218b;
                                    if (sRPModifyViewModel2 == null) {
                                        k.a("srpModifyViewModel");
                                    }
                                    sRPModifyViewModel2.setFromAndTo(intent, 202);
                                }
                            } else if (intent != null) {
                                SRPModifyViewModel sRPModifyViewModel3 = this.f24218b;
                                if (sRPModifyViewModel3 == null) {
                                    k.a("srpModifyViewModel");
                                }
                                sRPModifyViewModel3.setFromAndTo(intent, 201);
                            }
                        } else if (intent != null) {
                            SRPModifyViewModel sRPModifyViewModel4 = this.f24218b;
                            if (sRPModifyViewModel4 == null) {
                                k.a("srpModifyViewModel");
                            }
                            sRPModifyViewModel4.setDateAndRefresh(intent, this);
                        }
                    } else if (intent != null) {
                        SRPModifyViewModel sRPModifyViewModel5 = this.f24218b;
                        if (sRPModifyViewModel5 == null) {
                            k.a("srpModifyViewModel");
                        }
                        sRPModifyViewModel5.setDateAndRefresh(intent, this);
                    }
                } else if (intent != null) {
                    SRPModifyViewModel sRPModifyViewModel6 = this.f24218b;
                    if (sRPModifyViewModel6 == null) {
                        k.a("srpModifyViewModel");
                    }
                    sRPModifyViewModel6.setDate(intent, this);
                }
            } else if (intent != null) {
                SRPModifyViewModel sRPModifyViewModel7 = this.f24218b;
                if (sRPModifyViewModel7 == null) {
                    k.a("srpModifyViewModel");
                }
                sRPModifyViewModel7.setDate(intent, this);
            }
        }
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            j.a aVar = j.f25593a;
            j.a.a("srp_back_arrow_button_clicked", (HashMap<String, Object>) null);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (r0.intValue() != 1) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBackPressed() {
        /*
            r5 = this;
            androidx.fragment.app.j r0 = r5.getSupportFragmentManager()
            java.lang.String r1 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.f()
            r1 = 1
            if (r0 <= 0) goto L_0x003b
            androidx.fragment.app.j r2 = r5.getSupportFragmentManager()
            int r3 = r0 + -1
            androidx.fragment.app.j$a r2 = r2.b((int) r3)
            java.lang.String r3 = "supportFragmentManager.g…ntryAt(backStackSize - 1)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r2.g()
            java.lang.String r4 = "PAGE_NO_FLIGHTS_FOUND"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0039
            java.lang.String r2 = r2.g()
            java.lang.String r3 = "PAGE_NO_INTERNET"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x003b
        L_0x0039:
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x005b
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r5.f24217a
            if (r0 != 0) goto L_0x0048
            java.lang.String r3 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0048:
            androidx.lifecycle.LiveData r0 = r0.getProgressState()
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x005c
        L_0x005b:
            r2 = 1
        L_0x005c:
            if (r2 == 0) goto L_0x0078
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r2 = "NETWORK_TAG_FLIGHT_SRP_V2"
            com.paytm.network.a.a((android.content.Context) r0, (java.lang.Object) r2)
            com.travel.flight.utils.h$b r0 = new com.travel.flight.utils.h$b
            r0.<init>()
            r0.f25590d = r1
            d.a.a.c r1 = d.a.a.c.a()
            r1.c(r0)
            r5.finish()
            return
        L_0x0078:
            com.travel.flight.flightSRPV2.b.f r0 = com.travel.flight.flightSRPV2.b.f.f24150a
            r1 = r5
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity.onBackPressed():void");
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

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.hasExtra(net.one97.paytmflight.common.b.b.f30018h)) {
            SRPSharedViewModel sRPSharedViewModel = this.f24217a;
            if (sRPSharedViewModel == null) {
                k.a("viewModel");
            }
            sRPSharedViewModel.refresh(this);
        }
    }

    static final class e<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24226a;

        e(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24226a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24226a.onBackPressed();
        }
    }

    static final class g<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24228a;

        g(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24228a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24228a.setResult(-1, new Intent().putExtra("deeplink_filter_airlines_clear", true));
        }
    }

    static final class h<T> implements z<l> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlightSRPV2Activity f24229a;

        h(FlightSRPV2Activity flightSRPV2Activity) {
            this.f24229a = flightSRPV2Activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ImageView imageView = (ImageView) this.f24229a.a(R.id.img_fare_alert);
            k.a((Object) imageView, "img_fare_alert");
            imageView.setClickable(false);
            if (this.f24229a.f24220d != null) {
                PopupWindow a2 = this.f24229a.f24220d;
                if (a2 == null) {
                    k.a();
                }
                if (a2.isShowing()) {
                    PopupWindow a3 = this.f24229a.f24220d;
                    if (a3 == null) {
                        k.a();
                    }
                    a3.dismiss();
                }
            }
            Resources resources = this.f24229a.getResources();
            k.a((Object) resources, "resources");
            int a4 = kotlin.h.a.a(TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
            Resources resources2 = this.f24229a.getResources();
            k.a((Object) resources2, "resources");
            int a5 = kotlin.h.a.a(TypedValue.applyDimension(1, 83.0f, resources2.getDisplayMetrics()));
            Object systemService = this.f24229a.getSystemService("layout_inflater");
            if (systemService != null) {
                cm a6 = cm.a((LayoutInflater) systemService, (FrameLayout) this.f24229a.a(R.id.container_child));
                k.a((Object) a6, "PreFFlightFareAlertMessa…, container_child, false)");
                a6.a(FlightSRPV2Activity.b(this.f24229a));
                FlightSRPV2Activity flightSRPV2Activity = this.f24229a;
                PopupWindow popupWindow = new PopupWindow(flightSRPV2Activity);
                popupWindow.setContentView(a6.getRoot());
                popupWindow.setHeight(-2);
                popupWindow.setWidth(-1);
                popupWindow.setFocusable(false);
                flightSRPV2Activity.f24220d = popupWindow;
                PopupWindow a7 = this.f24229a.f24220d;
                if (a7 == null) {
                    k.a();
                }
                a7.setBackgroundDrawable(androidx.core.content.b.a((Context) this.f24229a, R.color.white));
                PopupWindow a8 = this.f24229a.f24220d;
                if (a8 == null) {
                    k.a();
                }
                a8.showAtLocation((FrameLayout) this.f24229a.a(R.id.container_child), 0, a4, a5);
                new Handler().postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ h f24230a;

                    {
                        this.f24230a = r1;
                    }

                    public final void run() {
                        if (this.f24230a.f24229a.f24220d != null) {
                            PopupWindow a2 = this.f24230a.f24229a.f24220d;
                            if (a2 == null) {
                                k.a();
                            }
                            if (a2.isShowing()) {
                                PopupWindow a3 = this.f24230a.f24229a.f24220d;
                                if (a3 == null) {
                                    k.a();
                                }
                                a3.dismiss();
                                ImageView imageView = (ImageView) this.f24230a.f24229a.a(R.id.img_fare_alert);
                                k.a((Object) imageView, "img_fare_alert");
                                imageView.setClickable(true);
                            }
                        }
                    }
                }, 2000);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }
}
