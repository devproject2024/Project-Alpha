package com.travel.train.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.activity.AJRLSSearchTrains;
import com.travel.train.activity.AJRSearchByTrainResultActivity;
import com.travel.train.fragment.ag;
import com.travel.train.j.m;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.u;
import net.one97.paytm.common.widgets.RoboButton;

public final class g extends am implements com.travel.train.hintsbuilder.c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26961a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private com.travel.train.k.b f26962b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.train.k.a f26963c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainHolidayList f26964d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<com.travel.train.model.trainticket.g> f26965e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private String f26966f;

    /* renamed from: g  reason: collision with root package name */
    private long f26967g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f26968h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26969i;
    /* access modifiers changed from: private */
    public CJRTrainSearchInput j;
    /* access modifiers changed from: private */
    public CJRSearchByTrainNumberModel k;
    /* access modifiers changed from: private */
    public CJRTrainLSSearchResult.Train l;
    /* access modifiers changed from: private */
    public CJRTrainLSSearchResult.Schedule m;
    /* access modifiers changed from: private */
    public CJRTrainRecentsItemModel n;
    private final String o = "TAG_SEARCH_TRAINS";
    /* access modifiers changed from: private */
    public Fragment p;
    private boolean q;
    private long r;
    /* access modifiers changed from: private */
    public boolean s;
    private com.paytm.b.a.a t;
    private final int u = 100;
    private HashMap v;

    public final View a(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class i<T> implements z<CJRSearchByTrainNumberModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26977a;

        i(g gVar) {
            this.f26977a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26977a.k = (CJRSearchByTrainNumberModel) obj;
            g.b(this.f26977a);
            m.a aVar = com.travel.train.j.m.f27577a;
            m.a.a(this.f26977a.k, this.f26977a.f26968h, this.f26977a.m, this.f26977a.j, this.f26977a.getContext());
            g.f(this.f26977a);
        }
    }

    static final class j<T> implements z<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26978a;

        j(g gVar) {
            this.f26978a = gVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                android.util.Pair r4 = (android.util.Pair) r4
                com.travel.train.fragment.g r0 = r3.f26978a
                r1 = 0
                if (r4 == 0) goto L_0x000c
                java.lang.Object r2 = r4.first
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x000d
            L_0x000c:
                r2 = r1
            L_0x000d:
                if (r4 == 0) goto L_0x0014
                java.lang.Object r4 = r4.second
                r1 = r4
                java.lang.String r1 = (java.lang.String) r1
            L_0x0014:
                r0.showErrorDialog(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.j.onChanged(java.lang.Object):void");
        }
    }

    static final class l<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26980a;

        l(g gVar) {
            this.f26980a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f26980a.a(R.id.lottie_in_search));
            } else {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f26980a.a(R.id.lottie_in_search));
            }
        }
    }

    static final class m<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26981a;

        m(g gVar) {
            this.f26981a = gVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00e3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Integer r5 = (java.lang.Integer) r5
                com.travel.train.fragment.g r0 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.m
                if (r0 == 0) goto L_0x0016
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                int r5 = r5.intValue()
                r0.setSourceSelectedPosition(r5)
            L_0x0016:
                com.travel.train.fragment.g r5 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r5.l
                r1 = 0
                if (r0 == 0) goto L_0x004d
                java.util.List r0 = r0.getSchedule()
                if (r0 == 0) goto L_0x004d
                com.travel.train.fragment.g r2 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r2.m
                if (r2 == 0) goto L_0x0036
                int r2 = r2.getSourceSelectedPosition()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                if (r2 != 0) goto L_0x003c
                kotlin.g.b.k.a()
            L_0x003c:
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
                if (r0 == 0) goto L_0x004d
                java.lang.String r0 = r0.getStationCode()
                goto L_0x004e
            L_0x004d:
                r0 = r1
            L_0x004e:
                com.travel.train.fragment.g r2 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r2 = r2.l
                if (r2 == 0) goto L_0x0084
                java.util.List r2 = r2.getSchedule()
                if (r2 == 0) goto L_0x0084
                com.travel.train.fragment.g r3 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r3.m
                if (r3 == 0) goto L_0x006d
                int r3 = r3.getSourceSelectedPosition()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                goto L_0x006e
            L_0x006d:
                r3 = r1
            L_0x006e:
                if (r3 != 0) goto L_0x0073
                kotlin.g.b.k.a()
            L_0x0073:
                int r3 = r3.intValue()
                java.lang.Object r2 = r2.get(r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r2
                if (r2 == 0) goto L_0x0084
                java.lang.String r2 = r2.getStationName()
                goto L_0x0085
            L_0x0084:
                r2 = r1
            L_0x0085:
                r5.b(r0, r2)
                com.travel.train.fragment.g r5 = r4.f26981a
                r5.b()
                com.travel.train.fragment.g r5 = r4.f26981a
                java.util.ArrayList r0 = r5.f26965e
                r2 = 0
                java.lang.Object r0 = r0.get(r2)
                com.travel.train.model.trainticket.g r0 = (com.travel.train.model.trainticket.g) r0
                java.util.Date r0 = r0.c()
                java.lang.String r2 = "trainHomeDateList.get(0).getSelectedDate()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r5.a((java.util.Date) r0)
                com.travel.train.fragment.g r5 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r5.m
                if (r5 == 0) goto L_0x00b7
                int r5 = r5.getDestSelectedPosition()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                goto L_0x00b8
            L_0x00b7:
                r5 = r1
            L_0x00b8:
                if (r5 != 0) goto L_0x00bd
                kotlin.g.b.k.a()
            L_0x00bd:
                int r5 = r5.intValue()
                com.travel.train.fragment.g r0 = r4.f26981a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.m
                if (r0 == 0) goto L_0x00d1
                int r0 = r0.getSourceSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            L_0x00d1:
                if (r1 != 0) goto L_0x00d6
                kotlin.g.b.k.a()
            L_0x00d6:
                int r0 = r1.intValue()
                if (r5 > r0) goto L_0x00e3
                com.travel.train.fragment.g r5 = r4.f26981a
                r0 = 1
                com.travel.train.fragment.g.a((com.travel.train.fragment.g) r5, (boolean) r0)
                return
            L_0x00e3:
                com.travel.train.fragment.g r5 = r4.f26981a
                android.content.Context r5 = r5.getContext()
                java.lang.String r0 = "train_homepage"
                java.lang.String r1 = "Train number"
                java.lang.String r2 = "station_changed"
                java.lang.String r3 = "/trains"
                com.travel.train.j.o.a(r0, r1, r2, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.m.onChanged(java.lang.Object):void");
        }
    }

    static final class n<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26982a;

        n(g gVar) {
            this.f26982a = gVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Integer r5 = (java.lang.Integer) r5
                com.travel.train.fragment.g r0 = r4.f26982a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.m
                if (r0 == 0) goto L_0x0016
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                int r5 = r5.intValue()
                r0.setDestSelectedPosition(r5)
            L_0x0016:
                com.travel.train.fragment.g r5 = r4.f26982a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r5.l
                r1 = 0
                if (r0 == 0) goto L_0x004d
                java.util.List r0 = r0.getSchedule()
                if (r0 == 0) goto L_0x004d
                com.travel.train.fragment.g r2 = r4.f26982a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r2.m
                if (r2 == 0) goto L_0x0036
                int r2 = r2.getDestSelectedPosition()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                if (r2 != 0) goto L_0x003c
                kotlin.g.b.k.a()
            L_0x003c:
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
                if (r0 == 0) goto L_0x004d
                java.lang.String r0 = r0.getStationCode()
                goto L_0x004e
            L_0x004d:
                r0 = r1
            L_0x004e:
                com.travel.train.fragment.g r2 = r4.f26982a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r2 = r2.l
                if (r2 == 0) goto L_0x0083
                java.util.List r2 = r2.getSchedule()
                if (r2 == 0) goto L_0x0083
                com.travel.train.fragment.g r3 = r4.f26982a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r3.m
                if (r3 == 0) goto L_0x006d
                int r3 = r3.getDestSelectedPosition()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                goto L_0x006e
            L_0x006d:
                r3 = r1
            L_0x006e:
                if (r3 != 0) goto L_0x0073
                kotlin.g.b.k.a()
            L_0x0073:
                int r3 = r3.intValue()
                java.lang.Object r2 = r2.get(r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r2
                if (r2 == 0) goto L_0x0083
                java.lang.String r1 = r2.getStationName()
            L_0x0083:
                r5.c(r0, r1)
                com.travel.train.fragment.g r5 = r4.f26982a
                android.content.Context r5 = r5.getContext()
                java.lang.String r0 = "train_homepage"
                java.lang.String r1 = "Train number"
                java.lang.String r2 = "station_changed"
                java.lang.String r3 = "/trains"
                com.travel.train.j.o.a(r0, r1, r2, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.n.onChanged(java.lang.Object):void");
        }
    }

    static final class o<T> implements z<CJRTrainLSSearchResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26983a;

        o(g gVar) {
            this.f26983a = gVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            r4 = (r4 = (r4 = r4.getBody()).get(0)).getTrains();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                com.travel.train.model.trainticket.CJRTrainLSSearchResult r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult) r4
                com.travel.train.fragment.g r0 = r3.f26983a
                r1 = 0
                r2 = 0
                if (r4 == 0) goto L_0x0023
                java.util.List r4 = r4.getBody()
                if (r4 == 0) goto L_0x0023
                java.lang.Object r4 = r4.get(r1)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Body r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Body) r4
                if (r4 == 0) goto L_0x0023
                java.util.ArrayList r4 = r4.getTrains()
                if (r4 == 0) goto L_0x0023
                java.lang.Object r4 = r4.get(r1)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r4
                goto L_0x0024
            L_0x0023:
                r4 = r2
            L_0x0024:
                r0.l = r4
                com.travel.train.fragment.g r4 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.fragment.g r0 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r0.l     // Catch:{ Exception -> 0x008f }
                if (r0 == 0) goto L_0x003e
                java.util.List r0 = r0.getSchedule()     // Catch:{ Exception -> 0x008f }
                if (r0 == 0) goto L_0x003e
                java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0     // Catch:{ Exception -> 0x008f }
                goto L_0x003f
            L_0x003e:
                r0 = r2
            L_0x003f:
                r4.m = r0     // Catch:{ Exception -> 0x008f }
                com.travel.train.fragment.g r4 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = r4.m     // Catch:{ Exception -> 0x008f }
                if (r4 == 0) goto L_0x0068
                com.travel.train.fragment.g r0 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r0 = r0.n     // Catch:{ Exception -> 0x008f }
                if (r0 == 0) goto L_0x005b
                int r0 = r0.getSourceSelectedPosition()     // Catch:{ Exception -> 0x008f }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x008f }
                goto L_0x005c
            L_0x005b:
                r0 = r2
            L_0x005c:
                if (r0 != 0) goto L_0x0061
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x008f }
            L_0x0061:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x008f }
                r4.setSourceSelectedPosition(r0)     // Catch:{ Exception -> 0x008f }
            L_0x0068:
                com.travel.train.fragment.g r4 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = r4.m     // Catch:{ Exception -> 0x008f }
                if (r4 == 0) goto L_0x0090
                com.travel.train.fragment.g r0 = r3.f26983a     // Catch:{ Exception -> 0x008f }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r0 = r0.n     // Catch:{ Exception -> 0x008f }
                if (r0 == 0) goto L_0x0081
                int r0 = r0.getDestSelectedPosition()     // Catch:{ Exception -> 0x008f }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x008f }
                goto L_0x0082
            L_0x0081:
                r0 = r2
            L_0x0082:
                if (r0 != 0) goto L_0x0087
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x008f }
            L_0x0087:
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x008f }
                r4.setDestSelectedPosition(r0)     // Catch:{ Exception -> 0x008f }
                goto L_0x0090
            L_0x008f:
            L_0x0090:
                com.travel.train.fragment.g r4 = r3.f26983a
                r4.d()
                com.travel.train.fragment.g r4 = r3.f26983a
                r4.b()
                com.travel.train.fragment.g r4 = r3.f26983a
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r4 = r4.n
                if (r4 == 0) goto L_0x00a7
                java.lang.String r4 = r4.getDateOfTravel()
                goto L_0x00a8
            L_0x00a7:
                r4 = r2
            L_0x00a8:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x00c0
                com.travel.train.fragment.g r4 = r3.f26983a
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r0 = r4.n
                if (r0 == 0) goto L_0x00bc
                java.lang.String r2 = r0.getDateOfTravel()
            L_0x00bc:
                r4.b((java.lang.String) r2)
                return
            L_0x00c0:
                com.travel.train.fragment.g r4 = r3.f26983a
                java.util.ArrayList r0 = r4.f26965e
                java.lang.Object r0 = r0.get(r1)
                com.travel.train.model.trainticket.g r0 = (com.travel.train.model.trainticket.g) r0
                java.util.Date r0 = r0.c()
                java.lang.String r1 = "trainHomeDateList.get(0).getSelectedDate()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r4.a((java.util.Date) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.o.onChanged(java.lang.Object):void");
        }
    }

    static final class p<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26984a;

        p(g gVar) {
            this.f26984a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f26984a.a(R.id.lottie_in_search));
                return;
            }
            RoboButton roboButton = (RoboButton) this.f26984a.a(R.id.proceed_btn);
            if (roboButton != null) {
                roboButton.setEnabled(true);
            }
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f26984a.a(R.id.lottie_in_search));
        }
    }

    static final class q<T> implements z<com.travel.train.model.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26985a;

        q(g gVar) {
            this.f26985a = gVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
            r2 = r4.b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                com.travel.train.model.e r4 = (com.travel.train.model.e) r4
                if (r4 == 0) goto L_0x0011
                int r0 = r4.a()
                r1 = -1
                if (r0 != r1) goto L_0x0011
                com.travel.train.fragment.g r4 = r3.f26985a
                r4.showNoNetworkDialog()
                return
            L_0x0011:
                com.travel.train.fragment.g r0 = r3.f26985a
                r1 = 0
                if (r4 == 0) goto L_0x0021
                com.paytm.network.model.NetworkCustomError r2 = r4.b()
                if (r2 == 0) goto L_0x0021
                java.lang.String r2 = r2.getAlertTitle()
                goto L_0x0022
            L_0x0021:
                r2 = r1
            L_0x0022:
                if (r4 == 0) goto L_0x002e
                com.paytm.network.model.NetworkCustomError r4 = r4.b()
                if (r4 == 0) goto L_0x002e
                java.lang.String r1 = r4.getAlertMessage()
            L_0x002e:
                r0.showErrorDialog(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.q.onChanged(java.lang.Object):void");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_booking_fragment_viewpager_item, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d7, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r13, r0)
            super.onViewCreated(r13, r14)
            android.os.Bundle r13 = r12.getArguments()
            if (r13 == 0) goto L_0x0031
            android.os.Bundle r13 = r12.getArguments()
            if (r13 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            java.lang.String r14 = "extra_intent_holiday_list"
            boolean r13 = r13.containsKey(r14)
            if (r13 == 0) goto L_0x0031
            android.os.Bundle r13 = r12.getArguments()
            if (r13 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            java.lang.Object r13 = r13.get(r14)
            com.travel.train.model.trainticket.CJRTrainHolidayList r13 = (com.travel.train.model.trainticket.CJRTrainHolidayList) r13
            r12.f26964d = r13
        L_0x0031:
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            if (r13 == 0) goto L_0x00af
            com.travel.train.k.g r14 = new com.travel.train.k.g
            com.travel.train.k.g$a r0 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r1 = com.travel.train.k.g.b.SEARCHBYTRAIN
            r0.<init>(r1)
            com.travel.train.a.a$a r1 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r2 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
            if (r3 != 0) goto L_0x004d
            kotlin.g.b.k.a()
        L_0x004d:
            java.lang.String r4 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            com.travel.train.a.a.b r2 = (com.travel.train.a.a.b) r2
            com.travel.train.a.a r1 = r1.a(r2)
            com.travel.train.k.g$a r0 = r0.a(r1)
            r14.<init>(r0)
            androidx.lifecycle.al$b r14 = (androidx.lifecycle.al.b) r14
            androidx.lifecycle.al r14 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r13, (androidx.lifecycle.al.b) r14)
            java.lang.Class<com.travel.train.k.b> r0 = com.travel.train.k.b.class
            androidx.lifecycle.ai r14 = r14.a(r0)
            com.travel.train.k.b r14 = (com.travel.train.k.b) r14
            r12.f26962b = r14
            com.travel.train.k.g r14 = new com.travel.train.k.g
            com.travel.train.k.g$a r0 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r1 = com.travel.train.k.g.b.LS
            r0.<init>(r1)
            com.travel.train.a.a$a r1 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r2 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
            if (r3 != 0) goto L_0x008a
            kotlin.g.b.k.a()
        L_0x008a:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            com.travel.train.a.a.b r2 = (com.travel.train.a.a.b) r2
            com.travel.train.a.a r1 = r1.a(r2)
            com.travel.train.k.g$a r0 = r0.a(r1)
            r14.<init>(r0)
            androidx.lifecycle.al$b r14 = (androidx.lifecycle.al.b) r14
            androidx.lifecycle.al r13 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r13, (androidx.lifecycle.al.b) r14)
            java.lang.Class<com.travel.train.k.a> r14 = com.travel.train.k.a.class
            androidx.lifecycle.ai r13 = r13.a(r14)
            com.travel.train.k.a r13 = (com.travel.train.k.a) r13
            r12.f26963c = r13
        L_0x00af:
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            r14 = 0
            if (r13 == 0) goto L_0x00c3
            android.content.Context r13 = r13.getApplicationContext()
            if (r13 == 0) goto L_0x00c3
            com.travel.train.j.w$a r0 = com.travel.train.j.w.f27609a
            com.paytm.b.a.a r13 = com.travel.train.j.w.a.a(r13)
            goto L_0x00c4
        L_0x00c3:
            r13 = r14
        L_0x00c4:
            r12.t = r13
            com.travel.train.k.b r13 = r12.f26962b
            if (r13 == 0) goto L_0x00dd
            androidx.lifecycle.y<com.travel.train.model.searchResult.CJRSearchByTrainNumberModel> r13 = r13.f27621a
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x00dd
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$i r1 = new com.travel.train.fragment.g$i
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x00dd:
            com.travel.train.k.b r13 = r12.f26962b
            if (r13 == 0) goto L_0x00f2
            com.travel.train.l.c r13 = r13.f27626f
            if (r13 == 0) goto L_0x00f2
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$j r1 = new com.travel.train.fragment.g$j
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x00f2:
            com.travel.train.k.b r13 = r12.f26962b
            if (r13 == 0) goto L_0x0109
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.f27627g
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0109
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$k r1 = new com.travel.train.fragment.g$k
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x0109:
            com.travel.train.k.b r13 = r12.f26962b
            if (r13 == 0) goto L_0x0120
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.f27624d
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0120
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$l r1 = new com.travel.train.fragment.g$l
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x0120:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x0137
            androidx.lifecycle.y<java.lang.Integer> r13 = r13.j
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0137
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$m r1 = new com.travel.train.fragment.g$m
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x0137:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x014e
            androidx.lifecycle.y<java.lang.Integer> r13 = r13.k
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x014e
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$n r1 = new com.travel.train.fragment.g$n
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x014e:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x0165
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult> r13 = r13.f27612a
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0165
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$o r1 = new com.travel.train.fragment.g$o
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x0165:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x017c
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.f27614c
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x017c
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$p r1 = new com.travel.train.fragment.g$p
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x017c:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x0193
            androidx.lifecycle.y<com.travel.train.model.e> r13 = r13.n
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0193
            r0 = r12
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.g$q r1 = new com.travel.train.fragment.g$q
            r1.<init>(r12)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r0, r1)
        L_0x0193:
            int r13 = com.travel.train.R.id.search_by_station
            android.view.View r13 = r12.a((int) r13)
            r0 = 8
            if (r13 == 0) goto L_0x01a0
            r13.setVisibility(r0)
        L_0x01a0:
            int r13 = com.travel.train.R.id.search_by_train
            android.view.View r13 = r12.a((int) r13)
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r1 = 0
            if (r13 == 0) goto L_0x01ae
            r13.setVisibility(r1)
        L_0x01ae:
            int r13 = com.travel.train.R.id.trainTypeFilter
            android.view.View r13 = r12.a((int) r13)
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x01bb
            r13.setVisibility(r0)
        L_0x01bb:
            int r13 = com.travel.train.R.id.search_by_train
            android.view.View r13 = r12.a((int) r13)
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x01ea
            android.view.View r13 = (android.view.View) r13
            int r0 = com.travel.train.R.id.input_unselected
            android.view.View r13 = r13.findViewById(r0)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            if (r13 == 0) goto L_0x01ea
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            if (r0 == 0) goto L_0x01e4
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x01e4
            int r2 = com.travel.train.R.string.train_search_train_or_number
            java.lang.String r0 = r0.getString(r2)
            goto L_0x01e5
        L_0x01e4:
            r0 = r14
        L_0x01e5:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setHint(r0)
        L_0x01ea:
            int r13 = com.travel.train.R.id.proceed_btn
            android.view.View r13 = r12.a((int) r13)
            net.one97.paytm.common.widgets.RoboButton r13 = (net.one97.paytm.common.widgets.RoboButton) r13
            if (r13 == 0) goto L_0x020d
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            if (r0 == 0) goto L_0x0207
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0207
            int r2 = com.travel.train.R.string.search_by_train_proceed_text
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0208
        L_0x0207:
            r0 = r14
        L_0x0208:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
        L_0x020d:
            int r13 = com.travel.train.R.id.search_by_station
            android.view.View r13 = r12.a((int) r13)
            if (r13 == 0) goto L_0x021a
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            goto L_0x021b
        L_0x021a:
            r13 = r14
        L_0x021b:
            if (r13 == 0) goto L_0x0474
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r13 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r13
            r0 = 1098907648(0x41800000, float:16.0)
            android.content.Context r2 = r12.getContext()
            int r0 = com.paytm.utility.b.a((float) r0, (android.content.Context) r2)
            r13.topMargin = r0
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r12.a((int) r0)
            if (r0 == 0) goto L_0x0238
            android.view.ViewGroup$LayoutParams r13 = (android.view.ViewGroup.LayoutParams) r13
            r0.setLayoutParams(r13)
        L_0x0238:
            int r13 = com.travel.train.R.id.search_by_train
            android.view.View r13 = r12.a((int) r13)
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x024c
            com.travel.train.fragment.g$c r0 = new com.travel.train.fragment.g$c
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x024c:
            int r13 = com.travel.train.R.id.proceed_btn
            android.view.View r13 = r12.a((int) r13)
            net.one97.paytm.common.widgets.RoboButton r13 = (net.one97.paytm.common.widgets.RoboButton) r13
            if (r13 == 0) goto L_0x0260
            com.travel.train.fragment.g$d r0 = new com.travel.train.fragment.g$d
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x0260:
            int r13 = com.travel.train.R.id.choosed_departure_date
            android.view.View r13 = r12.a((int) r13)
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x0274
            com.travel.train.fragment.g$e r0 = new com.travel.train.fragment.g$e
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x0274:
            int r13 = com.travel.train.R.id.iv_calender_icon
            android.view.View r13 = r12.a((int) r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0288
            com.travel.train.fragment.g$f r0 = new com.travel.train.fragment.g$f
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x0288:
            int r13 = com.travel.train.R.id.search_by_station
            android.view.View r13 = r12.a((int) r13)
            if (r13 == 0) goto L_0x02a2
            int r0 = com.travel.train.R.id.source_lyt
            android.view.View r13 = r13.findViewById(r0)
            if (r13 == 0) goto L_0x02a2
            com.travel.train.fragment.g$g r0 = new com.travel.train.fragment.g$g
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x02a2:
            int r13 = com.travel.train.R.id.search_by_station
            android.view.View r13 = r12.a((int) r13)
            if (r13 == 0) goto L_0x02bc
            int r0 = com.travel.train.R.id.destination_lyt
            android.view.View r13 = r13.findViewById(r0)
            if (r13 == 0) goto L_0x02bc
            com.travel.train.fragment.g$h r0 = new com.travel.train.fragment.g$h
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
        L_0x02bc:
            com.travel.train.j.m$a r13 = com.travel.train.j.m.f27577a
            android.content.Context r13 = r12.getContext()
            java.lang.String r0 = "search_train_most_visited"
            java.util.List r13 = com.travel.train.j.m.a.a(r13, r0)
            r0 = 1
            if (r13 == 0) goto L_0x02e4
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x02e4
            int r2 = r13.size()
            if (r2 <= 0) goto L_0x02e4
            int r2 = r13.size()
            int r2 = r2 - r0
            java.lang.Object r13 = r13.get(r2)
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r13
            r12.n = r13
        L_0x02e4:
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x0370
            if (r13 == 0) goto L_0x02ef
            java.lang.String r13 = r13.getTrainNumber()
            goto L_0x02f0
        L_0x02ef:
            r13 = r14
        L_0x02f0:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0370
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x0301
            java.lang.String r13 = r13.getTrainNumber()
            goto L_0x0302
        L_0x0301:
            r13 = r14
        L_0x0302:
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r2 = r12.n
            if (r2 == 0) goto L_0x030b
            java.lang.String r2 = r2.getTrainName()
            goto L_0x030c
        L_0x030b:
            r2 = r14
        L_0x030c:
            r12.a((java.lang.String) r13, (java.lang.String) r2)
            r12.a()
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x031b
            java.lang.String r13 = r13.getSourceCityCode()
            goto L_0x031c
        L_0x031b:
            r13 = r14
        L_0x031c:
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r2 = r12.n
            if (r2 == 0) goto L_0x0325
            java.lang.String r2 = r2.getSourceCityName()
            goto L_0x0326
        L_0x0325:
            r2 = r14
        L_0x0326:
            r12.b(r13, r2)
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x0332
            java.lang.String r13 = r13.getDestinationCityCode()
            goto L_0x0333
        L_0x0332:
            r13 = r14
        L_0x0333:
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r2 = r12.n
            if (r2 == 0) goto L_0x033c
            java.lang.String r2 = r2.getDestinationCityName()
            goto L_0x033d
        L_0x033c:
            r2 = r14
        L_0x033d:
            r12.c(r13, r2)
            int r13 = com.travel.train.R.id.proceed_btn
            android.view.View r13 = r12.a((int) r13)
            net.one97.paytm.common.widgets.RoboButton r13 = (net.one97.paytm.common.widgets.RoboButton) r13
            if (r13 == 0) goto L_0x034d
            r13.setEnabled(r1)
        L_0x034d:
            com.travel.train.k.a r13 = r12.f26963c
            if (r13 == 0) goto L_0x0370
            android.content.Context r2 = r12.getContext()
            java.util.HashMap r2 = com.travel.train.j.n.b((android.content.Context) r2)
            java.lang.String r3 = "CJRTrainSearchResultsUtil.getHeaderParams(context)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r3 = r12.n
            if (r3 == 0) goto L_0x0367
            java.lang.String r3 = r3.getTrainNumber()
            goto L_0x0368
        L_0x0367:
            r3 = r14
        L_0x0368:
            if (r3 != 0) goto L_0x036d
            kotlin.g.b.k.a()
        L_0x036d:
            r13.a(r2, r3)
        L_0x0370:
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x0379
            java.lang.String r13 = r13.getDateOfTravel()
            goto L_0x037a
        L_0x0379:
            r13 = r14
        L_0x037a:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x038e
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r13 = r12.n
            if (r13 == 0) goto L_0x038a
            java.lang.String r14 = r13.getDateOfTravel()
        L_0x038a:
            r12.b((java.lang.String) r14)
            goto L_0x03ac
        L_0x038e:
            r12.b()
            java.util.ArrayList<com.travel.train.model.trainticket.g> r13 = r12.f26965e
            java.lang.Object r13 = r13.get(r1)
            java.lang.String r14 = "trainHomeDateList.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            com.travel.train.model.trainticket.g r13 = (com.travel.train.model.trainticket.g) r13
            java.util.Date r13 = r13.c()
            java.lang.String r14 = "trainHomeDateList.get(0).selectedDate"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            r12.a((java.util.Date) r13)
        L_0x03ac:
            boolean r13 = r12.isAdded()
            if (r13 == 0) goto L_0x0435
            androidx.fragment.app.j r13 = r12.getChildFragmentManager()
            java.lang.String r14 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            r13.b()
            java.lang.String r14 = r12.o
            androidx.fragment.app.Fragment r13 = r13.c((java.lang.String) r14)
            r12.p = r13
            androidx.fragment.app.Fragment r13 = r12.p
            if (r13 == 0) goto L_0x03d2
            if (r13 == 0) goto L_0x0435
            boolean r13 = r13.isAdded()
            if (r13 != 0) goto L_0x0435
        L_0x03d2:
            com.travel.train.b.a()
            com.travel.common.a r13 = com.travel.train.b.b()
            java.lang.ref.WeakReference r14 = new java.lang.ref.WeakReference
            int r2 = com.travel.train.R.id.nested_scroll_view
            android.view.View r2 = r12.a((int) r2)
            androidx.core.widget.NestedScrollView r2 = (androidx.core.widget.NestedScrollView) r2
            r14.<init>(r2)
            androidx.fragment.app.Fragment r13 = r13.a((java.lang.ref.WeakReference<android.view.View>) r14)
            r12.p = r13
            r13 = r12
            com.travel.train.fragment.g r13 = (com.travel.train.fragment.g) r13
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>()
            java.lang.String r2 = "bundle_extra_clp_parallax_animation_required"
            r14.putBoolean(r2, r1)
            java.lang.String r2 = "bundle_extra_secondary_home_user_visible"
            r14.putBoolean(r2, r1)
            java.lang.String r1 = "first_tab_home"
            r14.putBoolean(r1, r0)
            java.lang.String r1 = "origin"
            java.lang.String r2 = "train"
            r14.putString(r1, r2)
            java.lang.String r1 = "store_front_url_key"
            java.lang.String r2 = "trainStoreFrontNewURL"
            r14.putString(r1, r2)
            androidx.fragment.app.Fragment r13 = r13.p
            if (r13 == 0) goto L_0x041b
            r13.setArguments(r14)
        L_0x041b:
            androidx.fragment.app.j r13 = r12.getChildFragmentManager()
            androidx.fragment.app.q r13 = r13.a()
            int r14 = com.travel.train.R.id.framelayout_storefront_train_home
            androidx.fragment.app.Fragment r1 = r12.p
            if (r1 != 0) goto L_0x042c
            kotlin.g.b.k.a()
        L_0x042c:
            java.lang.String r2 = r12.o
            androidx.fragment.app.q r13 = r13.b(r14, r1, r2)
            r13.b()
        L_0x0435:
            boolean r13 = r12.q
            if (r13 != 0) goto L_0x0453
            r12.q = r0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            r10 = r13
            android.content.Context r10 = (android.content.Context) r10
            r11 = 0
            java.lang.String r1 = "train_homepage"
            java.lang.String r8 = "book_tickets_clicked"
            java.lang.String r9 = "/trains"
            com.travel.train.j.o.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0453:
            int r13 = com.travel.train.R.id.nested_scroll_view
            android.view.View r13 = r12.a((int) r13)
            androidx.core.widget.NestedScrollView r13 = (androidx.core.widget.NestedScrollView) r13
            if (r13 == 0) goto L_0x046d
            android.view.ViewTreeObserver r13 = r13.getViewTreeObserver()
            if (r13 == 0) goto L_0x046d
            com.travel.train.fragment.g$b r14 = new com.travel.train.fragment.g$b
            r14.<init>(r12)
            android.view.ViewTreeObserver$OnScrollChangedListener r14 = (android.view.ViewTreeObserver.OnScrollChangedListener) r14
            r13.addOnScrollChangedListener(r14)
        L_0x046d:
            long r13 = java.lang.System.currentTimeMillis()
            r12.r = r13
            return
        L_0x0474:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26971a;

        c(g gVar) {
            this.f26971a = gVar;
        }

        public final void onClick(View view) {
            g.l(this.f26971a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26972a;

        d(g gVar) {
            this.f26972a = gVar;
        }

        public final void onClick(View view) {
            g.m(this.f26972a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26973a;

        e(g gVar) {
            this.f26973a = gVar;
        }

        public final void onClick(View view) {
            g.n(this.f26973a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26974a;

        f(g gVar) {
            this.f26974a = gVar;
        }

        public final void onClick(View view) {
            g.n(this.f26974a);
        }
    }

    /* renamed from: com.travel.train.fragment.g$g  reason: collision with other inner class name */
    static final class C0489g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26975a;

        C0489g(g gVar) {
            this.f26975a = gVar;
        }

        public final void onClick(View view) {
            g.a(this.f26975a, false);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26976a;

        h(g gVar) {
            this.f26976a = gVar;
        }

        public final void onClick(View view) {
            g.a(this.f26976a, true);
        }
    }

    private final void a(String str, String str2) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        RoboTextView roboTextView;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.search_by_train);
        if (!(constraintLayout == null || (roboTextView = (RoboTextView) constraintLayout.findViewById(R.id.input_unselected)) == null)) {
            roboTextView.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.search_by_train);
        if (!(constraintLayout2 == null || (textView3 = (TextView) constraintLayout2.findViewById(R.id.input_city_code)) == null)) {
            textView3.setVisibility(0);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.search_by_train);
        if (!(constraintLayout3 == null || (textView2 = (TextView) constraintLayout3.findViewById(R.id.input_city_code)) == null)) {
            textView2.setText(str);
        }
        ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.search_by_train);
        if (constraintLayout4 != null && (textView = (TextView) constraintLayout4.findViewById(R.id.input_full_name)) != null) {
            textView.setText(str2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.widget.TextView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r4 = this;
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            r0.setVisibility(r1)
        L_0x000c:
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x0022
            int r2 = com.travel.train.R.id.sep_route
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0022
            r2 = 4
            r0.setVisibility(r2)
        L_0x0022:
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            r2 = 8
            if (r0 == 0) goto L_0x0041
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x0041
            int r3 = com.travel.train.R.id.input_unselected
            android.view.View r0 = r0.findViewById(r3)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x0041
            r0.setVisibility(r2)
        L_0x0041:
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x005e
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x005e
            int r3 = com.travel.train.R.id.input_unselected
            android.view.View r0 = r0.findViewById(r3)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x005e
            r0.setVisibility(r2)
        L_0x005e:
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x007b
            int r2 = com.travel.train.R.id.source_lyt
            android.view.View r0 = r0.findViewById(r2)
            if (r0 == 0) goto L_0x007b
            int r2 = com.travel.train.R.id.input_city_code
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x007b
            r0.setVisibility(r1)
        L_0x007b:
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x0098
            int r2 = com.travel.train.R.id.destination_lyt
            android.view.View r0 = r0.findViewById(r2)
            if (r0 == 0) goto L_0x0098
            int r2 = com.travel.train.R.id.input_city_code
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0098
            r0.setVisibility(r1)
        L_0x0098:
            com.paytm.b.a.a r0 = r4.t
            java.lang.String r2 = "train_show_tip_view_for_search_page"
            r3 = 0
            if (r0 == 0) goto L_0x00a9
            boolean r0 = r0.b((java.lang.String) r2, (boolean) r1, (boolean) r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x00aa
        L_0x00a9:
            r0 = r3
        L_0x00aa:
            if (r0 != 0) goto L_0x00af
            kotlin.g.b.k.a()
        L_0x00af:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00d3
            int r0 = com.travel.train.R.id.search_by_station
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x00c6
            int r3 = com.travel.train.R.id.src_tip_lyt
            android.view.View r0 = r0.findViewById(r3)
            r3 = r0
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x00c6:
            android.view.View r3 = (android.view.View) r3
            r4.a((android.view.View) r3)
            com.paytm.b.a.a r0 = r4.t
            if (r0 == 0) goto L_0x00d3
            r3 = 1
            r0.a((java.lang.String) r2, (boolean) r3, (boolean) r1)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.a():void");
    }

    /* access modifiers changed from: private */
    public final void b(String str, String str2) {
        View findViewById;
        TextView textView;
        View findViewById2;
        TextView textView2;
        View a2 = a(R.id.search_by_station);
        if (!(a2 == null || (findViewById2 = a2.findViewById(R.id.source_lyt)) == null || (textView2 = (TextView) findViewById2.findViewById(R.id.input_city_code)) == null)) {
            textView2.setText(str);
        }
        View a3 = a(R.id.search_by_station);
        if (a3 != null && (findViewById = a3.findViewById(R.id.source_lyt)) != null && (textView = (TextView) findViewById.findViewById(R.id.input_full_name)) != null) {
            textView.setText(str2);
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str, String str2) {
        View findViewById;
        TextView textView;
        View findViewById2;
        TextView textView2;
        View a2 = a(R.id.search_by_station);
        if (!(a2 == null || (findViewById2 = a2.findViewById(R.id.destination_lyt)) == null || (textView2 = (TextView) findViewById2.findViewById(R.id.input_city_code)) == null)) {
            textView2.setText(str);
        }
        View a3 = a(R.id.search_by_station);
        if (a3 != null && (findViewById = a3.findViewById(R.id.destination_lyt)) != null && (textView = (TextView) findViewById.findViewById(R.id.input_full_name)) != null) {
            textView.setText(str2);
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        c();
        ArrayList<com.travel.train.model.trainticket.g> arrayList = this.f26965e;
        if (arrayList != null) {
            Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() > 0) {
                LinearLayout linearLayout = (LinearLayout) a(R.id.future_dates);
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                }
                int i2 = 0;
                ArrayList<com.travel.train.model.trainticket.g> arrayList2 = this.f26965e;
                Integer valueOf2 = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
                if (valueOf2 == null) {
                    kotlin.g.b.k.a();
                }
                int intValue = valueOf2.intValue();
                while (i2 < intValue) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity, "activity!!");
                    View inflate = activity.getLayoutInflater().inflate(R.layout.pre_t_train_home_date_item, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.date);
                    if (findViewById != null) {
                        TextView textView = (TextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.day);
                        if (findViewById2 != null) {
                            TextView textView2 = (TextView) findViewById2;
                            com.travel.train.model.trainticket.g gVar = this.f26965e.get(i2);
                            kotlin.g.b.k.a((Object) gVar, "trainHomeDateList.get(i)");
                            com.travel.train.model.trainticket.g gVar2 = gVar;
                            if (!TextUtils.isEmpty(gVar2.a())) {
                                textView.setText(gVar2.a());
                            }
                            if (!TextUtils.isEmpty(gVar2.b())) {
                                textView2.setText(gVar2.b());
                            }
                            inflate.setOnClickListener(new r(this, i2));
                            LinearLayout linearLayout2 = (LinearLayout) a(R.id.future_dates);
                            if (linearLayout2 != null) {
                                linearLayout2.addView(inflate);
                            }
                            i2++;
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                }
            }
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f26987b;

        r(g gVar, int i2) {
            this.f26986a = gVar;
            this.f26987b = i2;
        }

        public final void onClick(View view) {
            if (this.f26986a.f26965e.get(this.f26987b) != null) {
                Date c2 = ((com.travel.train.model.trainticket.g) this.f26986a.f26965e.get(this.f26987b)).c();
                kotlin.g.b.k.a((Object) c2, "trainHomeDateList.get(i).getSelectedDate()");
                this.f26986a.a(c2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r17 = this;
            r0 = r17
            java.util.ArrayList<com.travel.train.model.trainticket.g> r1 = r0.f26965e
            r1.clear()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.f26965e = r1
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r0.m
            if (r1 == 0) goto L_0x001b
            int r1 = r1.getSourceSelectedPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            if (r1 == 0) goto L_0x0083
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r0.l
            if (r1 == 0) goto L_0x004c
            java.util.List r1 = r1.getSchedule()
            if (r1 == 0) goto L_0x004c
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r0.m
            if (r3 == 0) goto L_0x0035
            int r3 = r3.getSourceSelectedPosition()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            if (r3 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            int r3 = r3.intValue()
            java.lang.Object r1 = r1.get(r3)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = r1.getRunningOnForSource()
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0083
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r0.l
            if (r1 == 0) goto L_0x008c
            java.util.List r1 = r1.getSchedule()
            if (r1 == 0) goto L_0x008c
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r0.m
            if (r3 == 0) goto L_0x006c
            int r3 = r3.getSourceSelectedPosition()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x006d
        L_0x006c:
            r3 = 0
        L_0x006d:
            if (r3 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            int r3 = r3.intValue()
            java.lang.Object r1 = r1.get(r3)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = r1.getRunningOnForSource()
            goto L_0x008d
        L_0x0083:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r0.l
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = r1.getRunningOn()
            goto L_0x008d
        L_0x008c:
            r1 = 0
        L_0x008d:
            java.lang.String r3 = "dayaftertomorrow"
            java.lang.String r4 = "tomorrow"
            java.lang.String r5 = "today"
            java.lang.String r6 = "date"
            r7 = 5
            java.lang.String r8 = "EEE"
            java.lang.String r10 = "dd MMM"
            r12 = 1
            java.lang.String r13 = "E MMM dd HH:mm:ss Z yyyy"
            if (r1 == 0) goto L_0x017d
            r14 = r1
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r15 = "N"
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r14 = kotlin.m.p.a((java.lang.CharSequence) r14, (java.lang.CharSequence) r15, false)
            if (r14 != r12) goto L_0x017d
            char[] r1 = r1.toCharArray()
            java.lang.String r14 = "(this as java.lang.String).toCharArray()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r14 = 0
            r15 = 0
        L_0x00b9:
            r2 = 6
            r11 = 89
            if (r14 > r2) goto L_0x00df
            if (r1 == 0) goto L_0x00c7
            char r2 = r1[r14]
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            goto L_0x00c8
        L_0x00c7:
            r2 = 0
        L_0x00c8:
            char r2 = r2.charValue()
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            java.lang.Character r11 = java.lang.Character.valueOf(r11)
            boolean r2 = r2.equals(r11)
            if (r2 != r12) goto L_0x00dc
            int r15 = r15 + 1
        L_0x00dc:
            int r14 = r14 + 1
            goto L_0x00b9
        L_0x00df:
            r2 = 21
            int r14 = r2 / r15
            int r2 = r2 % r15
            int r14 = r14 + r2
            if (r14 < 0) goto L_0x017c
            r2 = 0
        L_0x00e8:
            com.travel.train.model.trainticket.g r15 = new com.travel.train.model.trainticket.g
            r15.<init>()
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            r9.add(r7, r2)
            java.util.Date r7 = new java.util.Date
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            r16 = r13
            long r12 = r9.getTimeInMillis()
            r7.<init>(r12)
            if (r1 == 0) goto L_0x0171
            int r9 = r7.getDay()
            char r9 = r1[r9]
            if (r9 != r11) goto L_0x0171
            androidx.fragment.app.FragmentActivity r9 = r17.getActivity()
            android.app.Activity r9 = (android.app.Activity) r9
            r12 = r16
            java.lang.String r9 = com.travel.train.j.i.a((android.app.Activity) r9, (java.lang.String) r12, (java.lang.String) r10, (java.util.Date) r7)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x012d
            androidx.fragment.app.FragmentActivity r9 = r17.getActivity()
            android.app.Activity r9 = (android.app.Activity) r9
            java.lang.String r9 = com.travel.train.j.i.a((android.app.Activity) r9, (java.lang.String) r12, (java.lang.String) r10, (java.util.Date) r7)
            r15.a((java.lang.String) r9)
        L_0x012d:
            androidx.fragment.app.FragmentActivity r9 = r17.getActivity()
            android.app.Activity r9 = (android.app.Activity) r9
            java.lang.String r9 = com.travel.train.j.i.a((android.app.Activity) r9, (java.lang.String) r12, (java.lang.String) r8, (java.util.Date) r7)
            r15.b(r9)
            r15.a((java.util.Date) r7)
            java.util.ArrayList<com.travel.train.model.trainticket.g> r7 = r0.f26965e
            int r7 = r7.size()
            if (r7 != 0) goto L_0x0149
            r15.c(r5)
            goto L_0x0162
        L_0x0149:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r7 = r0.f26965e
            int r7 = r7.size()
            r9 = 1
            if (r7 != r9) goto L_0x0156
            r15.c(r4)
            goto L_0x0162
        L_0x0156:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r7 = r0.f26965e
            int r7 = r7.size()
            r9 = 2
            if (r7 != r9) goto L_0x0162
            r15.c(r3)
        L_0x0162:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r7 = r0.f26965e
            r7.add(r15)
            java.util.ArrayList<com.travel.train.model.trainticket.g> r7 = r0.f26965e
            int r7 = r7.size()
            r9 = 3
            if (r7 == r9) goto L_0x017c
            goto L_0x0173
        L_0x0171:
            r12 = r16
        L_0x0173:
            if (r2 == r14) goto L_0x017c
            int r2 = r2 + 1
            r13 = r12
            r7 = 5
            r12 = 1
            goto L_0x00e8
        L_0x017c:
            return
        L_0x017d:
            r12 = r13
            r1 = 0
        L_0x017f:
            r2 = 2
            if (r1 > r2) goto L_0x01fd
            com.travel.train.model.trainticket.g r2 = new com.travel.train.model.trainticket.g
            r2.<init>()
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            r9 = 5
            r7.add(r9, r1)
            java.util.Date r11 = new java.util.Date
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            long r13 = r7.getTimeInMillis()
            r11.<init>(r13)
            r2.a((java.util.Date) r11)
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.String r7 = com.travel.train.j.i.a((android.app.Activity) r7, (java.lang.String) r12, (java.lang.String) r10, (java.util.Date) r11)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01bd
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.String r7 = com.travel.train.j.i.a((android.app.Activity) r7, (java.lang.String) r12, (java.lang.String) r10, (java.util.Date) r11)
            r2.a((java.lang.String) r7)
        L_0x01bd:
            if (r1 != 0) goto L_0x01c8
            java.lang.String r7 = "Today"
            r2.b(r7)
            r2.c(r5)
            goto L_0x01e7
        L_0x01c8:
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.String r7 = com.travel.train.j.i.a((android.app.Activity) r7, (java.lang.String) r12, (java.lang.String) r8, (java.util.Date) r11)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01e7
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.String r7 = com.travel.train.j.i.a((android.app.Activity) r7, (java.lang.String) r12, (java.lang.String) r8, (java.util.Date) r11)
            r2.b(r7)
        L_0x01e7:
            r7 = 1
            if (r1 != r7) goto L_0x01ef
            r2.c(r4)
            r11 = 2
            goto L_0x01f5
        L_0x01ef:
            r11 = 2
            if (r1 != r11) goto L_0x01f5
            r2.c(r3)
        L_0x01f5:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r13 = r0.f26965e
            r13.add(r2)
            int r1 = r1 + 1
            goto L_0x017f
        L_0x01fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.c():void");
    }

    /* access modifiers changed from: private */
    public final void a(Date date) {
        String a2 = com.travel.train.j.i.a((Activity) getActivity(), "E MMM dd HH:mm:ss Z yyyy", "dd MMM yy", date);
        this.f26967g = date.getTime();
        if (!TextUtils.isEmpty(a2)) {
            a(a2);
        }
    }

    private final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                c(str);
                b(str);
                this.f26966f = str;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        String str2;
        RoboTextView roboTextView;
        boolean c2 = com.paytm.utility.b.c(str, "dd MMM yy");
        getActivity();
        String d2 = com.paytm.utility.b.d(str, "dd MMM yy", "EEE");
        kotlin.g.b.k.a((Object) d2, "CJRAppCommonUtility.form…ts.TRAIN_EEE_DATE_FORMAT)");
        getActivity();
        String d3 = com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM EEEE");
        kotlin.g.b.k.a((Object) d3, "CJRAppCommonUtility.form…DD_MMMM_EEEE_DATE_FORMAT)");
        if (c2) {
            str2 = v.a(str, AppConstants.COMMA, " ", d2);
        } else {
            str2 = str;
        }
        this.f26968h = str2;
        CharSequence charSequence = d3;
        if (!TextUtils.isEmpty(charSequence)) {
            Object[] array = kotlin.m.p.a(charSequence, new String[]{" "}).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length == 3) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.choosed_departure_date);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    RoboTextView roboTextView2 = (RoboTextView) a(R.id.unselected_date_lyt);
                    if (roboTextView2 != null) {
                        roboTextView2.setVisibility(8);
                    }
                    RoboTextView roboTextView3 = (RoboTextView) a(R.id.source_month);
                    if (roboTextView3 != null) {
                        roboTextView3.setVisibility(0);
                    }
                    RoboTextView roboTextView4 = (RoboTextView) a(R.id.source_day);
                    if (roboTextView4 != null) {
                        roboTextView4.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(strArr[0]) && (roboTextView = (RoboTextView) a(R.id.source_date)) != null) {
                        getActivity();
                        roboTextView.setText(com.paytm.utility.b.c(strArr[0], "dd", "dd"));
                    }
                    RoboTextView roboTextView5 = (RoboTextView) a(R.id.source_month);
                    if (roboTextView5 != null) {
                        roboTextView5.setText(strArr[1]);
                    }
                    RoboTextView roboTextView6 = (RoboTextView) a(R.id.source_day);
                    if (roboTextView6 != null) {
                        roboTextView6.setText(strArr[2]);
                    }
                    RoboTextView roboTextView7 = (RoboTextView) a(R.id.label_depart_on);
                    if (roboTextView7 != null) {
                        roboTextView7.setVisibility(0);
                    }
                }
                d(str);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private final void c(String str) {
        Date date;
        try {
            Calendar.getInstance().set(11, 0);
            Calendar instance = Calendar.getInstance();
            if (str == null || !kotlin.m.p.a((CharSequence) str, (CharSequence) AppConstants.COMMA, false)) {
                date = new SimpleDateFormat("dd MMM yy").parse(str);
            } else {
                date = new SimpleDateFormat("dd MMM yy, EEE").parse(str);
            }
            kotlin.g.b.k.a((Object) instance, "mSelectedCal");
            instance.setTime(date);
            instance.add(10, 1);
            d(str);
        } catch (Exception unused) {
        }
    }

    private final void d(String str) {
        ArrayList<com.travel.train.model.trainticket.g> arrayList = this.f26965e;
        int intValue = (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
        for (int i2 = 0; i2 < intValue; i2++) {
            String format = new SimpleDateFormat("dd MMM yy").format(this.f26965e.get(i2).c());
            if (str != null) {
                kotlin.g.b.k.a((Object) format, "futureDates");
                if (kotlin.m.p.a((CharSequence) str, (CharSequence) format, false)) {
                    b(i2);
                    return;
                }
            }
        }
    }

    private final void b(int i2) {
        LinearLayout linearLayout = (LinearLayout) a(R.id.future_dates);
        Integer valueOf = linearLayout != null ? Integer.valueOf(linearLayout.getChildCount()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        if (valueOf.intValue() > 0) {
            int i3 = 0;
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.future_dates);
            Integer valueOf2 = linearLayout2 != null ? Integer.valueOf(linearLayout2.getChildCount()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            int intValue = valueOf2.intValue();
            while (i3 < intValue) {
                LinearLayout linearLayout3 = (LinearLayout) a(R.id.future_dates);
                View childAt = linearLayout3 != null ? linearLayout3.getChildAt(i3) : null;
                if (childAt == null) {
                    kotlin.g.b.k.a();
                }
                View findViewById = childAt.findViewById(R.id.date);
                if (findViewById != null) {
                    TextView textView = (TextView) findViewById;
                    View findViewById2 = childAt.findViewById(R.id.day);
                    if (findViewById2 != null) {
                        TextView textView2 = (TextView) findViewById2;
                        View findViewById3 = childAt.findViewById(R.id.parent_lyt);
                        if (findViewById3 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) findViewById3;
                            if (i3 == i2) {
                                relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_alternate_class_bg_selected);
                                textView.setTextColor(getResources().getColor(R.color.color_222222));
                                textView2.setTextColor(getResources().getColor(R.color.color_222222));
                            } else {
                                relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_date_bg_unselect);
                                textView.setTextColor(getResources().getColor(R.color.tab_grey));
                                textView2.setTextColor(getResources().getColor(R.color.tab_grey));
                            }
                            i3++;
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Long} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            super.onActivityResult(r4, r5, r6)
            r5 = 1
            r0 = 0
            r1 = 0
            if (r4 == r5) goto L_0x0085
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L_0x0033
            r5 = 191(0xbf, float:2.68E-43)
            if (r4 == r5) goto L_0x0012
            goto L_0x00b2
        L_0x0012:
            if (r6 == 0) goto L_0x00b2
            r3.a((android.content.Intent) r6)
            r3.d()
            r3.b()
            java.util.ArrayList<com.travel.train.model.trainticket.g> r4 = r3.f26965e
            java.lang.Object r4 = r4.get(r1)
            com.travel.train.model.trainticket.g r4 = (com.travel.train.model.trainticket.g) r4
            java.util.Date r4 = r4.c()
            java.lang.String r5 = "trainHomeDateList.get(0).getSelectedDate()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r3.a((java.util.Date) r4)
            return
        L_0x0033:
            if (r6 == 0) goto L_0x00b2
            r3.a((android.content.Intent) r6)
            java.lang.String r4 = "departureDate"
            java.lang.String r5 = r6.getStringExtra(r4)
            if (r5 == 0) goto L_0x00b2
            java.lang.String r4 = r6.getStringExtra(r4)
            java.lang.String r5 = "yyyyMMdd"
            java.lang.String r6 = "dd MMM yy"
            java.lang.String r4 = com.travel.train.j.i.b((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00b2
            r3.b()
            r3.b((java.lang.String) r4)
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            android.app.Activity r5 = (android.app.Activity) r5
            java.util.Locale r6 = new java.util.Locale
            java.lang.String r1 = com.paytm.utility.n.a()
            r6.<init>(r1)
            java.util.Date r4 = com.travel.train.j.i.a((android.app.Activity) r5, (java.lang.String) r4, (java.util.Locale) r6)
            if (r4 == 0) goto L_0x0079
            long r4 = r4.getTime()
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
        L_0x0079:
            if (r0 != 0) goto L_0x007e
            kotlin.g.b.k.a()
        L_0x007e:
            long r4 = r0.longValue()
            r3.f26967g = r4
            return
        L_0x0085:
            r3.removeProgressDialog()
            r3.f26969i = r1
            if (r6 != 0) goto L_0x008d
            return
        L_0x008d:
            java.lang.String r4 = "intent_extra_selected_depart_date"
            boolean r5 = r6.hasExtra(r4)
            if (r5 == 0) goto L_0x0099
            java.lang.String r0 = r6.getStringExtra(r4)
        L_0x0099:
            java.lang.String r4 = "intent_extra_selected_date_time"
            boolean r5 = r6.hasExtra(r4)
            if (r5 == 0) goto L_0x00a9
            r1 = 0
            long r4 = r6.getLongExtra(r4, r1)
            r3.f26967g = r4
        L_0x00a9:
            if (r0 == 0) goto L_0x00b2
            r4 = 3
            r3.b((int) r4)
            r3.a((java.lang.String) r0)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r9 = this;
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r9.m
            if (r0 == 0) goto L_0x013a
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r9.l
            r1 = 0
            if (r0 == 0) goto L_0x0033
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x0033
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r9.m
            if (r2 == 0) goto L_0x001c
            int r2 = r2.getSourceSelectedPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r2 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.get(r2)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getDayCount()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            r2 = 0
            java.lang.String r3 = "1"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r0 != 0) goto L_0x013a
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r9.l
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = r0.getRunningOn()
            goto L_0x0047
        L_0x0046:
            r0 = r1
        L_0x0047:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r9.l
            if (r4 == 0) goto L_0x0074
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x0074
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r9.m
            if (r5 == 0) goto L_0x0063
            int r5 = r5.getSourceSelectedPosition()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0064
        L_0x0063:
            r5 = r1
        L_0x0064:
            if (r5 != 0) goto L_0x0069
            kotlin.g.b.k.a()
        L_0x0069:
            int r5 = r5.intValue()
            java.lang.Object r4 = r4.get(r5)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            goto L_0x0075
        L_0x0074:
            r4 = r1
        L_0x0075:
            if (r4 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r4 = r4.getDayCount()
            java.lang.String r5 = "mSelectedTrain?.schedule…tedPosition!!)!!.dayCount"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            int r4 = java.lang.Integer.parseInt(r4)
            int r4 = 7 - r4
        L_0x0089:
            int r4 = r4 + 1
            r6 = 6
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            if (r4 > r6) goto L_0x00b5
            if (r0 == 0) goto L_0x00ac
            if (r0 == 0) goto L_0x00a6
            char[] r6 = r0.toCharArray()
            java.lang.String r7 = "(this as java.lang.String).toCharArray()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            if (r6 == 0) goto L_0x00ac
            char r6 = r6[r4]
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            goto L_0x00ad
        L_0x00a6:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x00ac:
            r6 = r1
        L_0x00ad:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r3.append(r6)
            goto L_0x0089
        L_0x00b5:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r9.l
            if (r4 == 0) goto L_0x00dd
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x00dd
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = r9.m
            if (r6 == 0) goto L_0x00cc
            int r6 = r6.getSourceSelectedPosition()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x00cd
        L_0x00cc:
            r6 = r1
        L_0x00cd:
            if (r6 != 0) goto L_0x00d2
            kotlin.g.b.k.a()
        L_0x00d2:
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.get(r6)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            goto L_0x00de
        L_0x00dd:
            r4 = r1
        L_0x00de:
            if (r4 != 0) goto L_0x00e3
            kotlin.g.b.k.a()
        L_0x00e3:
            if (r0 == 0) goto L_0x0130
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r6 = r9.l
            if (r6 == 0) goto L_0x010a
            java.util.List r6 = r6.getSchedule()
            if (r6 == 0) goto L_0x010a
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r8 = r9.m
            if (r8 == 0) goto L_0x00fb
            int r1 = r8.getSourceSelectedPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00fb:
            if (r1 != 0) goto L_0x0100
            kotlin.g.b.k.a()
        L_0x0100:
            int r1 = r1.intValue()
            java.lang.Object r1 = r6.get(r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
        L_0x010a:
            if (r1 != 0) goto L_0x010f
            kotlin.g.b.k.a()
        L_0x010f:
            java.lang.String r1 = r1.getDayCount()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            int r1 = java.lang.Integer.parseInt(r1)
            int r1 = 7 - r1
            int r1 = r1 + 1
            if (r0 == 0) goto L_0x012a
            java.lang.String r1 = r0.substring(r2, r1)
            java.lang.String r0 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            goto L_0x0130
        L_0x012a:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x0130:
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r4.setRunningOnForSource(r0)
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.d():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "intent_extra_train_selected"
            java.io.Serializable r1 = r4.getSerializableExtra(r0)
            if (r1 == 0) goto L_0x001b
            java.io.Serializable r0 = r4.getSerializableExtra(r0)
            if (r0 == 0) goto L_0x0013
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r0
            r3.l = r0
            goto L_0x001b
        L_0x0013:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train"
            r4.<init>(r0)
            throw r4
        L_0x001b:
            java.lang.String r0 = "intent_extra_schedule_selected"
            java.io.Serializable r1 = r4.getSerializableExtra(r0)
            if (r1 == 0) goto L_0x0036
            java.io.Serializable r4 = r4.getSerializableExtra(r0)
            if (r4 == 0) goto L_0x002e
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            r3.m = r4
            goto L_0x0036
        L_0x002e:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule"
            r4.<init>(r0)
            throw r4
        L_0x0036:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r3.l
            r0 = 0
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = r4.getTrainNumber()
            goto L_0x0041
        L_0x0040:
            r4 = r0
        L_0x0041:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r3.l
            if (r1 == 0) goto L_0x004a
            java.lang.String r1 = r1.getTrainName()
            goto L_0x004b
        L_0x004a:
            r1 = r0
        L_0x004b:
            r3.a((java.lang.String) r4, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r3.l
            if (r4 == 0) goto L_0x007c
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x007c
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r3.m
            if (r1 == 0) goto L_0x0065
            int r1 = r1.getSourceSelectedPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0066
        L_0x0065:
            r1 = r0
        L_0x0066:
            if (r1 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            int r1 = r1.intValue()
            java.lang.Object r4 = r4.get(r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = r4.getStationCode()
            goto L_0x007d
        L_0x007c:
            r4 = r0
        L_0x007d:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r3.l
            if (r1 == 0) goto L_0x00ab
            java.util.List r1 = r1.getSchedule()
            if (r1 == 0) goto L_0x00ab
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r3.m
            if (r2 == 0) goto L_0x0094
            int r2 = r2.getSourceSelectedPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0095
        L_0x0094:
            r2 = r0
        L_0x0095:
            if (r2 != 0) goto L_0x009a
            kotlin.g.b.k.a()
        L_0x009a:
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.get(r2)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            if (r1 == 0) goto L_0x00ab
            java.lang.String r1 = r1.getStationName()
            goto L_0x00ac
        L_0x00ab:
            r1 = r0
        L_0x00ac:
            r3.b(r4, r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r3.l
            if (r4 == 0) goto L_0x00dd
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x00dd
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r3.m
            if (r1 == 0) goto L_0x00c6
            int r1 = r1.getDestSelectedPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x00c7
        L_0x00c6:
            r1 = r0
        L_0x00c7:
            if (r1 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            int r1 = r1.intValue()
            java.lang.Object r4 = r4.get(r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            if (r4 == 0) goto L_0x00dd
            java.lang.String r4 = r4.getStationCode()
            goto L_0x00de
        L_0x00dd:
            r4 = r0
        L_0x00de:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r3.l
            if (r1 == 0) goto L_0x010b
            java.util.List r1 = r1.getSchedule()
            if (r1 == 0) goto L_0x010b
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r3.m
            if (r2 == 0) goto L_0x00f5
            int r2 = r2.getDestSelectedPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x00f6
        L_0x00f5:
            r2 = r0
        L_0x00f6:
            if (r2 != 0) goto L_0x00fb
            kotlin.g.b.k.a()
        L_0x00fb:
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.get(r2)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            if (r1 == 0) goto L_0x010b
            java.lang.String r0 = r1.getStationName()
        L_0x010b:
            r3.c(r4, r0)
            r3.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.a(android.content.Intent):void");
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            this.s = true;
        }
    }

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26970a;

        b(g gVar) {
            this.f26970a = gVar;
        }

        public final void onScrollChanged() {
            View view;
            View view2;
            if (this.f26970a.s) {
                NestedScrollView nestedScrollView = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                if (nestedScrollView != null) {
                    nestedScrollView.scrollTo(0, 0);
                }
                this.f26970a.s = false;
            } else if (((NestedScrollView) this.f26970a.a(R.id.nested_scroll_view)) != null) {
                NestedScrollView nestedScrollView2 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                Integer num = null;
                Integer valueOf = nestedScrollView2 != null ? Integer.valueOf(nestedScrollView2.getChildCount()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.intValue() > 0) {
                    NestedScrollView nestedScrollView3 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                    if (nestedScrollView3 != null) {
                        NestedScrollView nestedScrollView4 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                        Integer valueOf2 = nestedScrollView4 != null ? Integer.valueOf(nestedScrollView4.getChildCount()) : null;
                        if (valueOf2 == null) {
                            kotlin.g.b.k.a();
                        }
                        view = nestedScrollView3.getChildAt(valueOf2.intValue() - 1);
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        NestedScrollView nestedScrollView5 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                        if (nestedScrollView5 != null) {
                            NestedScrollView nestedScrollView6 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                            Integer valueOf3 = nestedScrollView6 != null ? Integer.valueOf(nestedScrollView6.getChildCount()) : null;
                            if (valueOf3 == null) {
                                kotlin.g.b.k.a();
                            }
                            view2 = nestedScrollView5.getChildAt(valueOf3.intValue() - 1);
                        } else {
                            view2 = null;
                        }
                        if (view2 != null) {
                            int bottom = view2.getBottom();
                            NestedScrollView nestedScrollView7 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                            Integer valueOf4 = nestedScrollView7 != null ? Integer.valueOf(nestedScrollView7.getHeight()) : null;
                            if (valueOf4 == null) {
                                kotlin.g.b.k.a();
                            }
                            int intValue = valueOf4.intValue();
                            NestedScrollView nestedScrollView8 = (NestedScrollView) this.f26970a.a(R.id.nested_scroll_view);
                            if (nestedScrollView8 != null) {
                                num = Integer.valueOf(nestedScrollView8.getScrollY());
                            }
                            if (num == null) {
                                kotlin.g.b.k.a();
                            }
                            if (bottom - (intValue + num.intValue()) == 0) {
                                if (this.f26970a.p != null && g.r(this.f26970a)) {
                                    kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                                    com.travel.train.b.b().a(this.f26970a.p);
                                }
                            } else if (this.f26970a.p != null) {
                                com.travel.train.b.a();
                                com.travel.train.b.b().b(this.f26970a.p);
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.view.View");
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(android.view.View r4) {
        /*
            r3 = this;
            com.travel.train.hintsbuilder.a r0 = new com.travel.train.hintsbuilder.a
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            android.app.Activity r1 = (android.app.Activity) r1
            r0.<init>(r1)
            com.travel.train.hintsbuilder.a r4 = r0.a((android.view.View) r4)
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0023
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0023
            int r2 = com.travel.train.R.string.train_show_tip_title_1_of_2
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            com.travel.train.hintsbuilder.a r4 = r4.a((java.lang.String) r0)
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L_0x003b
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x003b
            int r2 = com.travel.train.R.string.train_show_tip_view_chng_src_desc
            java.lang.String r0 = r0.getString(r2)
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            com.travel.train.hintsbuilder.a r4 = r4.b((java.lang.String) r0)
            int r0 = r3.u
            com.travel.train.hintsbuilder.a r4 = r4.a((int) r0)
            com.travel.train.hintsbuilder.a r4 = r4.b()
            com.travel.train.hintsbuilder.a r4 = r4.c()
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L_0x0061
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0061
            int r2 = com.travel.train.R.string.train_show_tip_view_positive_button1
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0062
        L_0x0061:
            r0 = r1
        L_0x0062:
            com.travel.train.hintsbuilder.a r4 = r4.c(r0)
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L_0x0078
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0078
            int r1 = com.travel.train.R.string.train_show_tip_view_negative_button1
            java.lang.String r1 = r0.getString(r1)
        L_0x0078:
            com.travel.train.hintsbuilder.a r4 = r4.d(r1)
            r0 = r3
            com.travel.train.hintsbuilder.c r0 = (com.travel.train.hintsbuilder.c) r0
            com.travel.train.hintsbuilder.a r4 = r4.a((com.travel.train.hintsbuilder.c) r0)
            int r0 = com.travel.train.R.layout.pre_t_train_show_square_tip_view
            com.travel.train.hintsbuilder.a r4 = r4.b((int) r0)
            com.travel.train.hintsbuilder.CJRTrainShowSquareTipsView r4 = r4.a()
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r4.a((android.app.Activity) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.a(android.view.View):void");
    }

    public final void a(View view, boolean z) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        if (z) {
            View a2 = a(R.id.search_by_station);
            String str = null;
            if (kotlin.g.b.k.a((Object) view, (Object) a2 != null ? (TextView) a2.findViewById(R.id.src_tip_lyt) : null)) {
                View a3 = a(R.id.search_by_station);
                com.travel.train.hintsbuilder.a a4 = new com.travel.train.hintsbuilder.a(getActivity()).a((View) a3 != null ? (TextView) a3.findViewById(R.id.dst_tip_lyt) : null);
                FragmentActivity activity = getActivity();
                com.travel.train.hintsbuilder.a a5 = a4.a((activity == null || (resources3 = activity.getResources()) == null) ? null : resources3.getString(R.string.train_show_tip_title_2_of_2));
                FragmentActivity activity2 = getActivity();
                com.travel.train.hintsbuilder.a c2 = a5.b((activity2 == null || (resources2 = activity2.getResources()) == null) ? null : resources2.getString(R.string.train_show_tip_view_chng_dest_desc)).a(this.u).b().c();
                FragmentActivity activity3 = getActivity();
                if (!(activity3 == null || (resources = activity3.getResources()) == null)) {
                    str = resources.getString(R.string.train_show_tip_view_positive_button2);
                }
                c2.c(str).a((com.travel.train.hintsbuilder.c) this).b(R.layout.pre_t_train_show_square_tip_view).a().a((Activity) getActivity());
            }
        }
    }

    static final class k<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26979a;

        k(g gVar) {
            this.f26979a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26979a.showNoNetworkDialog();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r1 = (r1 = (android.widget.TextView) (r1 = r1.findViewById(com.travel.train.R.id.source_lyt)).findViewById(com.travel.train.R.id.input_city_code)).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(com.travel.train.fragment.g r4) {
        /*
            com.travel.train.model.CJRTrainSearchInput r0 = new com.travel.train.model.CJRTrainSearchInput
            r0.<init>()
            r4.j = r0
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            r2 = 0
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r1.getStationCode()
            if (r1 != 0) goto L_0x0051
        L_0x002b:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0050
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0050
            int r3 = com.travel.train.R.id.input_city_code
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0050
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r1.toString()
            goto L_0x0051
        L_0x0050:
            r1 = r2
        L_0x0051:
            r0.setmSourceCityCode(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x005b
            kotlin.g.b.k.a()
        L_0x005b:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x0077
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x009d
        L_0x0077:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x009c
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x009c
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x009c
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x009c
            java.lang.String r1 = r1.toString()
            goto L_0x009d
        L_0x009c:
            r1 = r2
        L_0x009d:
            r0.setmSourceCityName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x00e9
        L_0x00c3:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x00e8
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x00e8
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00e8
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x00e8
            java.lang.String r1 = r1.toString()
            goto L_0x00e9
        L_0x00e8:
            r1 = r2
        L_0x00e9:
            r0.setSourceAirPortName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x00f3
            kotlin.g.b.k.a()
        L_0x00f3:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x010f
            java.lang.String r1 = r1.getStationCode()
            if (r1 != 0) goto L_0x0135
        L_0x010f:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0134
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0134
            int r3 = com.travel.train.R.id.input_city_code
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0134
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0134
            java.lang.String r1 = r1.toString()
            goto L_0x0135
        L_0x0134:
            r1 = r2
        L_0x0135:
            r0.setmDestCityCode(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x013f
            kotlin.g.b.k.a()
        L_0x013f:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x015b
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x0181
        L_0x015b:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0180
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0180
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0180
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0180
            java.lang.String r1 = r1.toString()
            goto L_0x0181
        L_0x0180:
            r1 = r2
        L_0x0181:
            r0.setmDestCityName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x018b
            kotlin.g.b.k.a()
        L_0x018b:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.k
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x01aa
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r2 = r1
            goto L_0x01ce
        L_0x01aa:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x01ce
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x01ce
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x01ce
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x01ce
            java.lang.String r2 = r1.toString()
        L_0x01ce:
            r0.setDestAirportName(r2)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.j
            if (r0 != 0) goto L_0x01d8
            kotlin.g.b.k.a()
        L_0x01d8:
            java.lang.String r4 = r4.f26968h
            r0.setmDate(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.b(com.travel.train.fragment.g):void");
    }

    public static final /* synthetic */ void f(g gVar) {
        Intent intent = new Intent(gVar.getActivity(), AJRSearchByTrainResultActivity.class);
        intent.putExtra("search_by_train_result", gVar.k);
        intent.putExtra("intent_extra_train_search_input", gVar.j);
        intent.putExtra("intent_extra_train_selected", gVar.l);
        intent.putExtra("intent_extra_schedule_selected", gVar.m);
        intent.putExtra("extra_intent_holiday_list", gVar.f26964d);
        gVar.startActivityForResult(intent, 123);
    }

    public static final /* synthetic */ void a(g gVar, boolean z) {
        String str;
        List<CJRTrainLSSearchResult.Schedule> schedule;
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_train_selected", gVar.l);
        bundle.putSerializable("intent_extra_schedule_selected", gVar.m);
        bundle.putBoolean("intent_extra_search_by_train", z);
        bundle.putString("departureDate", gVar.f26968h);
        Integer num = null;
        if (gVar.m != null) {
            CJRTrainLSSearchResult.Train train = gVar.l;
            if (!(train == null || (schedule = train.getSchedule()) == null)) {
                CJRTrainLSSearchResult.Schedule schedule2 = gVar.m;
                Integer valueOf = schedule2 != null ? Integer.valueOf(schedule2.getSourceSelectedPosition()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                CJRTrainLSSearchResult.Schedule schedule3 = schedule.get(valueOf.intValue());
                if (schedule3 != null) {
                    str = schedule3.getDayCount();
                    bundle.putString("selected_day_count", str);
                }
            }
            str = null;
            bundle.putString("selected_day_count", str);
        }
        if (z) {
            CJRTrainLSSearchResult.Schedule schedule4 = gVar.m;
            Integer valueOf2 = schedule4 != null ? Integer.valueOf(schedule4.getDestSelectedPosition()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            int intValue = valueOf2.intValue();
            CJRTrainLSSearchResult.Schedule schedule5 = gVar.m;
            if (schedule5 != null) {
                num = Integer.valueOf(schedule5.getSourceSelectedPosition());
            }
            if (num == null) {
                kotlin.g.b.k.a();
            }
            bundle.putBoolean("intent_extra_search_by_train_flag", intValue >= num.intValue());
        }
        ag.a aVar = ag.f26836a;
        ag a2 = ag.a.a(bundle);
        androidx.fragment.app.j childFragmentManager = gVar.getChildFragmentManager();
        if (childFragmentManager == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager!!");
        a2.show(childFragmentManager, ag.class.getName());
        com.travel.train.j.o.a("train_homepage", "Train number", "station_change_selected", "/trains", gVar.getContext());
    }

    public static final /* synthetic */ void l(g gVar) {
        com.travel.train.j.o.a("train_homepage", (String) null, "search_trains_clicked", "/trains", gVar.getContext());
        Intent intent = new Intent(gVar.getActivity(), AJRLSSearchTrains.class);
        intent.putExtra("intent_extra_from_search_by_train", true);
        gVar.startActivityForResult(intent, 191);
    }

    public static final /* synthetic */ void m(g gVar) {
        View findViewById;
        TextView textView;
        CharSequence text;
        View findViewById2;
        TextView textView2;
        CharSequence text2;
        TextView textView3;
        CharSequence text3;
        com.travel.train.k.a aVar;
        com.travel.train.j.o.a("train_homepage", (String) null, "search_train_search_clicked", "/trains", gVar.getContext());
        if (!(gVar.m != null || gVar.n == null || (aVar = gVar.f26963c) == null)) {
            HashMap<String, String> b2 = com.travel.train.j.n.b(gVar.getContext());
            kotlin.g.b.k.a((Object) b2, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
            CJRTrainRecentsItemModel cJRTrainRecentsItemModel = gVar.n;
            String trainNumber = cJRTrainRecentsItemModel != null ? cJRTrainRecentsItemModel.getTrainNumber() : null;
            if (trainNumber == null) {
                kotlin.g.b.k.a();
            }
            aVar.a(b2, trainNumber);
        }
        com.travel.train.k.b bVar = gVar.f26962b;
        if (bVar != null) {
            HashMap<String, String> b3 = com.travel.train.j.n.b(gVar.getContext());
            kotlin.g.b.k.a((Object) b3, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
            ConstraintLayout constraintLayout = (ConstraintLayout) gVar.a(R.id.search_by_train);
            String obj = (constraintLayout == null || (textView3 = (TextView) constraintLayout.findViewById(R.id.input_city_code)) == null || (text3 = textView3.getText()) == null) ? null : text3.toString();
            View a2 = gVar.a(R.id.search_by_station);
            String obj2 = (a2 == null || (findViewById2 = a2.findViewById(R.id.source_lyt)) == null || (textView2 = (TextView) findViewById2.findViewById(R.id.input_city_code)) == null || (text2 = textView2.getText()) == null) ? null : text2.toString();
            View a3 = gVar.a(R.id.search_by_station);
            HashMap<String, String> a4 = com.travel.train.j.n.a(obj, obj2, (a3 == null || (findViewById = a3.findViewById(R.id.destination_lyt)) == null || (textView = (TextView) findViewById.findViewById(R.id.input_city_code)) == null || (text = textView.getText()) == null) ? null : text.toString(), gVar.f26968h, (String) null);
            kotlin.g.b.k.a((Object) a4, "CJRTrainSearchResultsUti…    mDepartureDate, null)");
            bVar.a(b3, a4, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00eb A[SYNTHETIC, Splitter:B:61:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void n(com.travel.train.fragment.g r12) {
        /*
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r0 = com.paytm.utility.n.a()
            r2.<init>(r0)
            r0 = 0
            r12.f26969i = r0
            boolean r1 = r12.getUserVisibleHint()
            r10 = 1
            if (r1 == 0) goto L_0x0018
            boolean r1 = r12.f26969i
            if (r1 != 0) goto L_0x0018
            r0 = 1
        L_0x0018:
            if (r0 == 0) goto L_0x0149
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r1 = com.travel.train.R.string.please_wait_progress_msg
            java.lang.String r1 = r12.getString(r1)
            r12.showProgressDialog(r0, r1)
            int r0 = com.travel.train.R.id.unselected_date_lyt
            android.view.View r0 = r12.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "dd MMM yy"
            if (r0 == 0) goto L_0x0054
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0054
            int r0 = com.travel.train.R.id.choosed_departure_date
            android.view.View r0 = r12.a((int) r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L_0x0054
            int r0 = r0.getVisibility()
            r3 = 8
            if (r0 != r3) goto L_0x0054
            java.lang.String r0 = com.travel.train.j.i.h(r1)
            r12.f26966f = r0
            goto L_0x0064
        L_0x0054:
            java.lang.String r0 = r12.f26968h
            if (r0 == 0) goto L_0x0064
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = r12.f26968h
            r12.f26966f = r0
        L_0x0064:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r12.m
            r3 = 0
            if (r0 == 0) goto L_0x0072
            int r0 = r0.getSourceSelectedPosition()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0073
        L_0x0072:
            r0 = r3
        L_0x0073:
            if (r0 == 0) goto L_0x00da
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r12.l
            if (r0 == 0) goto L_0x00a3
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x00a3
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = r12.m
            if (r4 == 0) goto L_0x008c
            int r4 = r4.getSourceSelectedPosition()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x008d
        L_0x008c:
            r4 = r3
        L_0x008d:
            if (r4 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            int r4 = r4.intValue()
            java.lang.Object r0 = r0.get(r4)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
            if (r0 == 0) goto L_0x00a3
            java.lang.String r0 = r0.getRunningOnForSource()
            goto L_0x00a4
        L_0x00a3:
            r0 = r3
        L_0x00a4:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00da
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r12.l
            if (r0 == 0) goto L_0x00e4
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x00e4
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = r12.m
            if (r4 == 0) goto L_0x00c3
            int r4 = r4.getSourceSelectedPosition()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00c4
        L_0x00c3:
            r4 = r3
        L_0x00c4:
            if (r4 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            int r4 = r4.intValue()
            java.lang.Object r0 = r0.get(r4)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getRunningOnForSource()
            goto L_0x00e2
        L_0x00da:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r12.l
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getRunningOn()
        L_0x00e2:
            r9 = r0
            goto L_0x00e5
        L_0x00e4:
            r9 = r3
        L_0x00e5:
            boolean r0 = r12.isDetached()
            if (r0 != 0) goto L_0x0149
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x00f7 }
            r0.<init>(r1, r2)     // Catch:{ ParseException -> 0x00f7 }
            java.lang.String r1 = r12.f26966f     // Catch:{ ParseException -> 0x00f7 }
            java.util.Date r0 = r0.parse(r1)     // Catch:{ ParseException -> 0x00f7 }
            goto L_0x0104
        L_0x00f7:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            java.lang.String r1 = "Calendar.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.Date r0 = r0.getTime()
        L_0x0104:
            r3 = r0
            com.travel.train.b r0 = com.travel.train.b.a()
            java.lang.String r1 = "TrainController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.common.a r0 = com.travel.train.b.b()
            androidx.fragment.app.FragmentActivity r4 = r12.getActivity()
            android.app.Activity r4 = (android.app.Activity) r4
            long r5 = r12.f26967g
            com.travel.train.j.x r7 = com.travel.train.j.x.f27611a
            int r7 = com.travel.train.j.x.a()
            com.travel.train.b r8 = com.travel.train.b.a()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            com.travel.common.a r1 = com.travel.train.b.b()
            java.lang.String r8 = "TrainHolidayList"
            java.lang.String r8 = r1.a((java.lang.String) r8)
            android.content.res.Resources r1 = r12.getResources()
            int r11 = com.travel.train.R.string.train_calender_activity_name
            java.lang.String r11 = r1.getString(r11)
            r1 = r4
            r4 = r5
            r6 = r7
            r7 = r8
            r8 = r11
            android.content.Intent r0 = r0.a((android.app.Activity) r1, (java.util.Locale) r2, (java.util.Date) r3, (long) r4, (int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            r12.startActivityForResult(r0, r10)
            r12.f26969i = r10
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.g.n(com.travel.train.fragment.g):void");
    }

    public static final /* synthetic */ boolean r(g gVar) {
        if (System.currentTimeMillis() - gVar.r <= 1000) {
            return false;
        }
        gVar.r = System.currentTimeMillis();
        return true;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
