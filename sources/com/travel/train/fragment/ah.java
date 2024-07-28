package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainPassengerDetailActivity;
import com.travel.train.b.o;
import com.travel.train.j.b;
import com.travel.train.j.i;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.searchResult.SearchedDateClass;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsMeta;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;

public final class ah extends net.one97.paytm.i.f implements b.C0491b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f26851f = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    CJRTrainLSSearchResult.Train f26852a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainLSSearchResult.Schedule f26853b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public CJRSearchByTrainNumberModel f26854c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public CJRTrainSearchResults f26855d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public SearchedDateClass f26856e;

    /* renamed from: g  reason: collision with root package name */
    private com.travel.train.k.b f26857g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public com.travel.train.k.c f26858h;

    /* renamed from: i  reason: collision with root package name */
    private String f26859i;
    private com.travel.train.j.b j;
    private CJRTrainSearchInput k;
    /* access modifiers changed from: private */
    public CJRTrainSearchResultsTrain l;
    private boolean m;
    /* access modifiers changed from: private */
    public CJRTrainDetailsBody n;
    private String o;
    private final String p = "FJRTrainSelectedDateRefreshFragment";
    private HashMap q;

    static final class e<T> implements z<com.travel.train.model.e> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f26865a = new e();

        e() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    private View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void c() {
    }

    static final class c<T> implements z<CJRSearchByTrainNumberModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ah f26863a;

        c(ah ahVar) {
            this.f26863a = ahVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0027, code lost:
            r0 = (r0 = r0.getBody()).getTrains();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r3) {
            /*
                r2 = this;
                com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r3 = (com.travel.train.model.searchResult.CJRSearchByTrainNumberModel) r3
                com.travel.train.fragment.ah r0 = r2.f26863a
                r0.f26854c = r3
                com.travel.train.fragment.ah r3 = r2.f26863a
                r3.getActivity()
                com.travel.train.fragment.ah r0 = r2.f26863a
                com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r0 = r0.f26854c
                com.travel.train.model.trainticket.CJRTrainSearchResults r0 = com.travel.train.helper.b.a(r0)
                r3.f26855d = r0
                com.travel.train.fragment.ah r3 = r2.f26863a
                com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r3.f26855d
                if (r0 == 0) goto L_0x0035
                com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r0.getBody()
                if (r0 == 0) goto L_0x0035
                java.util.List r0 = r0.getTrains()
                if (r0 == 0) goto L_0x0035
                r1 = 0
                java.lang.Object r0 = r0.get(r1)
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r0 = (com.travel.train.model.trainticket.CJRTrainSearchResultsTrain) r0
                goto L_0x0036
            L_0x0035:
                r0 = 0
            L_0x0036:
                r3.l = r0
                com.travel.train.fragment.ah r3 = r2.f26863a
                com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r0 = r3.f26854c
                com.travel.train.fragment.ah.b(r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ah.c.onChanged(java.lang.Object):void");
        }
    }

    static final class d<T> implements z<CJRTrainDetails> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ah f26864a;

        d(ah ahVar) {
            this.f26864a = ahVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r4 = r4.getmTrainAvailability();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                com.travel.train.model.trainticket.CJRTrainDetails r4 = (com.travel.train.model.trainticket.CJRTrainDetails) r4
                com.travel.train.fragment.ah r0 = r3.f26864a
                com.travel.train.model.trainticket.CJRTrainDetailsBody r4 = r4.getmTrainDetailsBody()
                r0.n = r4
                com.travel.train.fragment.ah r4 = r3.f26864a
                com.travel.train.model.trainticket.CJRTrainDetailsBody r4 = r4.n
                r0 = 0
                if (r4 == 0) goto L_0x0022
                java.util.ArrayList r4 = r4.getmTrainAvailability()
                if (r4 == 0) goto L_0x0022
                r1 = 0
                java.lang.Object r4 = r4.get(r1)
                com.travel.train.model.trainticket.CJRTrainAvailability r4 = (com.travel.train.model.trainticket.CJRTrainAvailability) r4
                goto L_0x0023
            L_0x0022:
                r4 = r0
            L_0x0023:
                if (r4 != 0) goto L_0x0028
                kotlin.g.b.k.a()
            L_0x0028:
                java.lang.String r1 = "mTrainDetailData?.getmTr…nAvailability()?.get(0)!!"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                boolean r4 = r4.isBookingAllowed()
                if (r4 == 0) goto L_0x0039
                com.travel.train.fragment.ah r4 = r3.f26864a
                com.travel.train.fragment.ah.d(r4)
                return
            L_0x0039:
                com.travel.train.fragment.ah r4 = r3.f26864a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.content.Context r4 = (android.content.Context) r4
                com.travel.train.fragment.ah r1 = r3.f26864a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                if (r1 == 0) goto L_0x0050
                int r2 = com.travel.train.R.string.train_title_booking_not_allowed
                java.lang.String r1 = r1.getString(r2)
                goto L_0x0051
            L_0x0050:
                r1 = r0
            L_0x0051:
                com.travel.train.fragment.ah r2 = r3.f26864a
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                if (r2 == 0) goto L_0x005f
                int r0 = com.travel.train.R.string.booking_not_accepted_text
                java.lang.String r0 = r2.getString(r0)
            L_0x005f:
                com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r1, (java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ah.d.onChanged(java.lang.Object):void");
        }
    }

    static final class f<T> implements z<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ah f26866a;

        f(ah ahVar) {
            this.f26866a = ahVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Pair pair = (Pair) obj;
            ah ahVar = this.f26866a;
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            if (ahVar.getActivity() != null) {
                FragmentActivity activity = ahVar.getActivity();
                if (activity == null) {
                    k.a();
                }
                if (!activity.isFinishing()) {
                    x.e eVar = new x.e();
                    eVar.element = new com.paytm.utility.h(ahVar.getActivity());
                    ((com.paytm.utility.h) eVar.element).setTitle(str);
                    ((com.paytm.utility.h) eVar.element).setCancelable(false);
                    ((com.paytm.utility.h) eVar.element).a(str2);
                    ((com.paytm.utility.h) eVar.element).a(-3, ahVar.getString(R.string.ok), new g(eVar));
                    ((com.paytm.utility.h) eVar.element).setOnKeyListener(new h());
                    ((com.paytm.utility.h) eVar.element).show();
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = ((com.paytm.utility.h) eVar.element).getWindow();
                    layoutParams.copyFrom(window != null ? window.getAttributes() : null);
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    if (window != null) {
                        window.setAttributes(layoutParams);
                    }
                }
            }
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
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_availability_bottomsheet_dialog, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r8, r0)
            super.onViewCreated(r8, r9)
            android.os.Bundle r8 = r7.getArguments()
            r9 = 0
            if (r8 == 0) goto L_0x0017
            java.lang.String r0 = "intent_extra_train_selected"
            java.io.Serializable r8 = r8.getSerializable(r0)
            goto L_0x0018
        L_0x0017:
            r8 = r9
        L_0x0018:
            if (r8 == 0) goto L_0x01f5
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r8 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r8
            r7.f26852a = r8
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x002b
            java.lang.String r0 = "intent_extra_schedule_selected"
            java.io.Serializable r8 = r8.getSerializable(r0)
            goto L_0x002c
        L_0x002b:
            r8 = r9
        L_0x002c:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r8 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r8
            r7.f26853b = r8
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x003d
            java.lang.String r0 = "intent_extra_train_search_input"
            java.io.Serializable r8 = r8.getSerializable(r0)
            goto L_0x003e
        L_0x003d:
            r8 = r9
        L_0x003e:
            if (r8 == 0) goto L_0x01ed
            com.travel.train.model.CJRTrainSearchInput r8 = (com.travel.train.model.CJRTrainSearchInput) r8
            r7.k = r8
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x0051
            java.lang.String r0 = "intent_extra_date"
            java.lang.String r8 = r8.getString(r0)
            goto L_0x0052
        L_0x0051:
            r8 = r9
        L_0x0052:
            r7.f26859i = r8
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x0061
            java.lang.String r0 = "calendar_class"
            java.lang.String r8 = r8.getString(r0)
            goto L_0x0062
        L_0x0061:
            r8 = r9
        L_0x0062:
            r7.o = r8
            com.travel.train.k.g r8 = new com.travel.train.k.g
            com.travel.train.k.g$a r0 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r1 = com.travel.train.k.g.b.SEARCHBYTRAIN
            r0.<init>(r1)
            com.travel.train.a.a$a r1 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r2 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r3 = r7.getActivity()
            if (r3 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r4 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            com.travel.train.a.a.b r2 = (com.travel.train.a.a.b) r2
            com.travel.train.a.a r1 = r1.a(r2)
            com.travel.train.k.g$a r0 = r0.a(r1)
            r8.<init>(r0)
            r0 = r7
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            androidx.lifecycle.al$b r8 = (androidx.lifecycle.al.b) r8
            androidx.lifecycle.al r8 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0, (androidx.lifecycle.al.b) r8)
            java.lang.Class<com.travel.train.k.b> r1 = com.travel.train.k.b.class
            androidx.lifecycle.ai r8 = r8.a(r1)
            com.travel.train.k.b r8 = (com.travel.train.k.b) r8
            r7.f26857g = r8
            com.travel.train.k.g r8 = new com.travel.train.k.g
            com.travel.train.k.g$a r1 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r2 = com.travel.train.k.g.b.BOOKING
            r1.<init>(r2)
            com.travel.train.a.a$a r2 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r3 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r5 = r7.getActivity()
            if (r5 != 0) goto L_0x00ba
            kotlin.g.b.k.a()
        L_0x00ba:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            android.content.Context r5 = (android.content.Context) r5
            r3.<init>(r5)
            com.travel.train.a.a.b r3 = (com.travel.train.a.a.b) r3
            com.travel.train.a.a r2 = r2.a(r3)
            com.travel.train.k.g$a r1 = r1.a(r2)
            r2 = 1
            r1.f27667b = r2
            r8.<init>(r1)
            androidx.lifecycle.al$b r8 = (androidx.lifecycle.al.b) r8
            androidx.lifecycle.al r8 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0, (androidx.lifecycle.al.b) r8)
            java.lang.Class<com.travel.train.k.c> r0 = com.travel.train.k.c.class
            androidx.lifecycle.ai r8 = r8.a(r0)
            com.travel.train.k.c r8 = (com.travel.train.k.c) r8
            r7.f26858h = r8
            com.travel.train.k.b r8 = r7.f26857g
            if (r8 == 0) goto L_0x00f9
            androidx.lifecycle.y<com.travel.train.model.searchResult.CJRSearchByTrainNumberModel> r8 = r8.f27622b
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            if (r8 == 0) goto L_0x00f9
            r0 = r7
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.ah$c r1 = new com.travel.train.fragment.ah$c
            r1.<init>(r7)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x00f9:
            com.travel.train.k.c r8 = r7.f26858h
            if (r8 == 0) goto L_0x0110
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainDetails> r8 = r8.k
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            if (r8 == 0) goto L_0x0110
            r0 = r7
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.ah$d r1 = new com.travel.train.fragment.ah$d
            r1.<init>(r7)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x0110:
            com.travel.train.k.c r8 = r7.f26858h
            if (r8 == 0) goto L_0x0124
            androidx.lifecycle.y<com.travel.train.model.e> r8 = r8.n
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            if (r8 == 0) goto L_0x0124
            r0 = r7
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.ah$e r1 = com.travel.train.fragment.ah.e.f26865a
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x0124:
            com.travel.train.k.c r8 = r7.f26858h
            if (r8 == 0) goto L_0x0139
            com.travel.train.l.c r8 = r8.f27636g
            if (r8 == 0) goto L_0x0139
            r0 = r7
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.ah$f r1 = new com.travel.train.fragment.ah$f
            r1.<init>(r7)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r8.observe(r0, r1)
        L_0x0139:
            int r8 = com.travel.train.R.id.selected_date_tv
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x014a
            java.lang.String r0 = r7.f26859i
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x014a:
            int r8 = com.travel.train.R.id.selected_date_tv
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0158
            r0 = 0
            r8.setVisibility(r0)
        L_0x0158:
            int r8 = com.travel.train.R.id.shimmer_layout
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.common.views.ShimmerFrameLayout r8 = (net.one97.paytm.common.views.ShimmerFrameLayout) r8
            if (r8 == 0) goto L_0x0165
            r8.a()
        L_0x0165:
            java.lang.String r8 = r7.f26859i
            com.travel.train.k.b r0 = r7.f26857g
            if (r0 == 0) goto L_0x01ec
            android.content.Context r1 = r7.getContext()
            java.util.HashMap r1 = com.travel.train.j.n.b((android.content.Context) r1)
            java.lang.String r3 = "CJRTrainSearchResultsUtil.getHeaderParams(context)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r3 = r7.f26852a
            if (r3 == 0) goto L_0x0181
            java.lang.String r3 = r3.getTrainNumber()
            goto L_0x0182
        L_0x0181:
            r3 = r9
        L_0x0182:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r7.f26852a
            if (r4 == 0) goto L_0x01b0
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x01b0
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r7.f26853b
            if (r5 == 0) goto L_0x0199
            int r5 = r5.getSourceSelectedPosition()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x019a
        L_0x0199:
            r5 = r9
        L_0x019a:
            if (r5 != 0) goto L_0x019f
            kotlin.g.b.k.a()
        L_0x019f:
            int r5 = r5.intValue()
            java.lang.Object r4 = r4.get(r5)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            if (r4 == 0) goto L_0x01b0
            java.lang.String r4 = r4.getStationCode()
            goto L_0x01b1
        L_0x01b0:
            r4 = r9
        L_0x01b1:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = r7.f26852a
            if (r5 == 0) goto L_0x01df
            java.util.List r5 = r5.getSchedule()
            if (r5 == 0) goto L_0x01df
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = r7.f26853b
            if (r6 == 0) goto L_0x01c8
            int r6 = r6.getDestSelectedPosition()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x01c9
        L_0x01c8:
            r6 = r9
        L_0x01c9:
            if (r6 != 0) goto L_0x01ce
            kotlin.g.b.k.a()
        L_0x01ce:
            int r6 = r6.intValue()
            java.lang.Object r5 = r5.get(r6)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r5
            if (r5 == 0) goto L_0x01df
            java.lang.String r5 = r5.getStationCode()
            goto L_0x01e0
        L_0x01df:
            r5 = r9
        L_0x01e0:
            java.util.HashMap r8 = com.travel.train.j.n.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r8, (java.lang.String) r9)
            java.lang.String r9 = "CJRTrainSearchResultsUti…tionCode, mDepDate, null)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r0.a(r1, r8, r2)
        L_0x01ec:
            return
        L_0x01ed:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type com.travel.train.model.CJRTrainSearchInput"
            r8.<init>(r9)
            throw r8
        L_0x01f5:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ah.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public static final class b extends o {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f26860c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ah f26861d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRSearchByTrainNumberModel f26862e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RecyclerView recyclerView, RecyclerView recyclerView2, Context context, CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel, String str, ah ahVar, CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel2) {
            super(recyclerView2, context, cJRSearchByTrainNumberModel, str);
            this.f26860c = recyclerView;
            this.f26861d = ahVar;
            this.f26862e = cJRSearchByTrainNumberModel2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r7 = r7.findViewById(com.travel.train.R.id.book_button);
         */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0122  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0128  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
                r6 = this;
                com.travel.train.fragment.ah r0 = r6.f26861d
                r1 = 0
                if (r7 == 0) goto L_0x0012
                int r2 = com.travel.train.R.id.book_button
                android.view.View r7 = r7.findViewById(r2)
                if (r7 == 0) goto L_0x0012
                java.lang.Object r7 = r7.getTag()
                goto L_0x0013
            L_0x0012:
                r7 = r1
            L_0x0013:
                if (r7 == 0) goto L_0x013c
                com.travel.train.model.searchResult.SearchedDateClass r7 = (com.travel.train.model.searchResult.SearchedDateClass) r7
                r0.f26856e = r7
                com.travel.train.fragment.ah r7 = r6.f26861d
                com.travel.train.k.c r7 = r7.f26858h
                if (r7 == 0) goto L_0x013b
                androidx.recyclerview.widget.RecyclerView r0 = r6.f26860c
                android.content.Context r0 = r0.getContext()
                java.util.HashMap r0 = com.travel.train.j.n.b((android.content.Context) r0)
                java.lang.String r2 = "CJRTrainSearchResultsUtil.getHeaderParams(context)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                com.travel.train.fragment.ah r2 = r6.f26861d
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                com.travel.train.model.trainticket.CJRTrainSearchResults r4 = r2.f26855d
                if (r4 == 0) goto L_0x0047
                com.travel.train.model.trainticket.CJRTrainSearchResultsMeta r4 = r4.getMeta()
                if (r4 == 0) goto L_0x0047
                java.lang.String r4 = r4.getRequestid()
                goto L_0x0048
            L_0x0047:
                r4 = r1
            L_0x0048:
                if (r4 != 0) goto L_0x004d
                kotlin.g.b.k.a()
            L_0x004d:
                java.lang.String r5 = "requestid"
                r3.put(r5, r4)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r2.f26852a
                if (r4 == 0) goto L_0x005b
                java.lang.String r4 = r4.getTrainNumber()
                goto L_0x005c
            L_0x005b:
                r4 = r1
            L_0x005c:
                if (r4 != 0) goto L_0x0061
                kotlin.g.b.k.a()
            L_0x0061:
                java.lang.String r5 = "trainNumber"
                r3.put(r5, r4)
                com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r4 = r2.f26854c
                if (r4 == 0) goto L_0x0082
                com.travel.train.model.searchResult.Body r4 = r4.getBody()
                if (r4 == 0) goto L_0x0082
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r4 = r4.getTrainDetails()
                if (r4 == 0) goto L_0x0082
                com.travel.train.model.searchResult.FromStation r4 = r4.getFromStation()
                if (r4 == 0) goto L_0x0082
                java.lang.String r4 = r4.getDepartureDate()
                goto L_0x0083
            L_0x0082:
                r4 = r1
            L_0x0083:
                java.lang.String r5 = "departureDate"
                r3.put(r5, r4)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r2.f26852a
                if (r4 == 0) goto L_0x00b6
                java.util.List r4 = r4.getSchedule()
                if (r4 == 0) goto L_0x00b6
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r2.f26853b
                if (r5 == 0) goto L_0x009f
                int r5 = r5.getSourceSelectedPosition()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                goto L_0x00a0
            L_0x009f:
                r5 = r1
            L_0x00a0:
                if (r5 != 0) goto L_0x00a5
                kotlin.g.b.k.a()
            L_0x00a5:
                int r5 = r5.intValue()
                java.lang.Object r4 = r4.get(r5)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
                if (r4 == 0) goto L_0x00b6
                java.lang.String r4 = r4.getStationCode()
                goto L_0x00b7
            L_0x00b6:
                r4 = r1
            L_0x00b7:
                if (r4 != 0) goto L_0x00bc
                kotlin.g.b.k.a()
            L_0x00bc:
                java.lang.String r5 = "source"
                r3.put(r5, r4)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r2.f26852a
                if (r4 == 0) goto L_0x00f0
                java.util.List r4 = r4.getSchedule()
                if (r4 == 0) goto L_0x00f0
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r2.f26853b
                if (r5 == 0) goto L_0x00d9
                int r5 = r5.getDestSelectedPosition()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                goto L_0x00da
            L_0x00d9:
                r5 = r1
            L_0x00da:
                if (r5 != 0) goto L_0x00df
                kotlin.g.b.k.a()
            L_0x00df:
                int r5 = r5.intValue()
                java.lang.Object r4 = r4.get(r5)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
                if (r4 == 0) goto L_0x00f0
                java.lang.String r4 = r4.getStationCode()
                goto L_0x00f1
            L_0x00f0:
                r4 = r1
            L_0x00f1:
                if (r4 != 0) goto L_0x00f6
                kotlin.g.b.k.a()
            L_0x00f6:
                java.lang.String r5 = "destination"
                r3.put(r5, r4)
                com.travel.train.model.trainticket.CJRTrainMessagingConfig r4 = com.travel.train.j.g.f27551a
                if (r4 == 0) goto L_0x0117
                com.travel.train.model.trainticket.CJRTrainMessagingConfig r4 = com.travel.train.j.g.f27551a
                java.lang.Object r4 = r4.getTestId()
                if (r4 == 0) goto L_0x0117
                com.travel.train.model.trainticket.CJRTrainMessagingConfig r4 = com.travel.train.j.g.f27551a
                java.lang.Object r4 = r4.getTestId()
                java.lang.String r4 = r4.toString()
                java.lang.String r5 = "test_id"
                r3.put(r5, r4)
            L_0x0117:
                java.lang.String r4 = "quota"
                java.lang.String r5 = "GN"
                r3.put(r4, r5)
                com.travel.train.model.searchResult.SearchedDateClass r2 = r2.f26856e
                if (r2 == 0) goto L_0x0126
                java.lang.String r1 = r2.getClassType()
            L_0x0126:
                if (r1 != 0) goto L_0x012b
                kotlin.g.b.k.a()
            L_0x012b:
                java.lang.String r2 = "class"
                r3.put(r2, r1)
                java.lang.String r1 = "alternate_stations"
                java.lang.String r2 = "true"
                r3.put(r1, r2)
                r7.b(r0, r3)
            L_0x013b:
                return
            L_0x013c:
                kotlin.u r7 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type com.travel.train.model.searchResult.SearchedDateClass"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ah.b.onClick(android.view.View):void");
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void b() {
        ArrayList<CJRTrainAvailability> arrayList;
        CJRTrainAvailability cJRTrainAvailability;
        ArrayList<CJRTrainAvailability> arrayList2;
        CJRTrainAvailability cJRTrainAvailability2;
        CJRTrainSearchResultsMeta meta;
        this.m = false;
        getContext();
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.l;
        Boolean bool = null;
        String d2 = com.paytm.utility.b.d(cJRTrainSearchResultsTrain != null ? cJRTrainSearchResultsTrain.getDeparture() : null, "yyyy-MM-dd", "EEE, dd MMM");
        if (this.k != null) {
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2 = this.l;
            if (cJRTrainSearchResultsTrain2 != null) {
                cJRTrainSearchResultsTrain2.setMirctcuserid(com.paytm.utility.b.W((Context) getActivity()));
            }
            Intent intent = new Intent(getActivity(), AJRTrainPassengerDetailActivity.class);
            SearchedDateClass searchedDateClass = this.f26856e;
            intent.putExtra("train_class_code", searchedDateClass != null ? searchedDateClass.getClassType() : null);
            SearchedDateClass searchedDateClass2 = this.f26856e;
            intent.putExtra("train_class_details", searchedDateClass2 != null ? searchedDateClass2.getClassName() : null);
            intent.putExtra("quota", "GN");
            intent.putExtra("quota_name", "GENERAL");
            intent.putExtra("waiting_list", false);
            intent.putExtra("train_detail_body", this.n);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain3 = this.l;
            if (cJRTrainSearchResultsTrain3 != null) {
                String departure = cJRTrainSearchResultsTrain3 != null ? cJRTrainSearchResultsTrain3.getDeparture() : null;
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain4 = this.l;
                cJRTrainSearchResultsTrain3.setMSearchedTrainDepartureTime(i.d(departure, cJRTrainSearchResultsTrain4 != null ? cJRTrainSearchResultsTrain4.getDepartureTime() : null));
            }
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain5 = this.l;
            if (cJRTrainSearchResultsTrain5 != null) {
                String arrival = cJRTrainSearchResultsTrain5 != null ? cJRTrainSearchResultsTrain5.getArrival() : null;
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain6 = this.l;
                cJRTrainSearchResultsTrain5.setMSearchedTrainArrivalTime(i.d(arrival, cJRTrainSearchResultsTrain6 != null ? cJRTrainSearchResultsTrain6.getArrivalTime() : null));
            }
            intent.putExtra("train_detail", this.l);
            intent.putExtra("intent_extra_train_search_input", this.k);
            intent.putExtra("chosenDate", d2);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain7 = this.l;
            if (cJRTrainSearchResultsTrain7 != null) {
                intent.putExtra("source", cJRTrainSearchResultsTrain7 != null ? cJRTrainSearchResultsTrain7.getSource() : null);
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain8 = this.l;
                intent.putExtra("destination", cJRTrainSearchResultsTrain8 != null ? cJRTrainSearchResultsTrain8.getDestination() : null);
            }
            CJRTrainSearchResults cJRTrainSearchResults = this.f26855d;
            intent.putExtra("request_id", (cJRTrainSearchResults == null || (meta = cJRTrainSearchResults.getMeta()) == null) ? null : meta.getRequestid());
            CJRTrainDetailsBody cJRTrainDetailsBody = this.n;
            intent.putExtra("minsuranceAlwaysTrue", (cJRTrainDetailsBody == null || (arrayList2 = cJRTrainDetailsBody.getmTrainAvailability()) == null || (cJRTrainAvailability2 = arrayList2.get(0)) == null) ? null : Boolean.valueOf(cJRTrainAvailability2.isMinsuranceAlwaysTrue()));
            CJRTrainDetailsBody cJRTrainDetailsBody2 = this.n;
            if (!(cJRTrainDetailsBody2 == null || (arrayList = cJRTrainDetailsBody2.getmTrainAvailability()) == null || (cJRTrainAvailability = arrayList.get(0)) == null)) {
                bool = Boolean.valueOf(cJRTrainAvailability.isMinsuranceOption());
            }
            intent.putExtra("minsuranceOption", bool);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 989);
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26867a;

        g(x.e eVar) {
            this.f26867a = eVar;
        }

        public final void onClick(View view) {
            ((com.paytm.utility.h) this.f26867a.element).cancel();
        }
    }

    public static final class h implements DialogInterface.OnKeyListener {
        h() {
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || dialogInterface == null) {
                return true;
            }
            dialogInterface.cancel();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r2 = r11.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(com.travel.train.fragment.ah r10, com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r11) {
        /*
            int r0 = com.travel.train.R.id.shimmer_layout
            android.view.View r0 = r10.a((int) r0)
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = (net.one97.paytm.common.views.ShimmerFrameLayout) r0
            if (r0 == 0) goto L_0x000d
            r0.b()
        L_0x000d:
            int r0 = com.travel.train.R.id.shimmer_layout
            android.view.View r0 = r10.a((int) r0)
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = (net.one97.paytm.common.views.ShimmerFrameLayout) r0
            if (r0 == 0) goto L_0x001c
            r1 = 8
            r0.setVisibility(r1)
        L_0x001c:
            int r0 = com.travel.train.R.id.class_list
            android.view.View r0 = r10.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r1 = 0
            if (r0 == 0) goto L_0x002a
            r0.setVisibility(r1)
        L_0x002a:
            int r0 = com.travel.train.R.id.class_list
            android.view.View r0 = r10.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L_0x00b7
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            android.content.Context r3 = (android.content.Context) r3
            r4 = 1
            r2.<init>(r3, r4, r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r0.setLayoutManager(r2)
            java.lang.String r1 = r10.o
            if (r1 != 0) goto L_0x0087
            r1 = 0
            if (r11 == 0) goto L_0x0057
            com.travel.train.model.searchResult.Body r2 = r11.getBody()
            if (r2 == 0) goto L_0x0057
            java.util.List r2 = r2.getSearchedDateClasses()
            goto L_0x0058
        L_0x0057:
            r2 = r1
        L_0x0058:
            if (r2 != 0) goto L_0x005d
            kotlin.g.b.k.a()
        L_0x005d:
            java.util.Iterator r2 = r2.iterator()
        L_0x0061:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0087
            java.lang.Object r3 = r2.next()
            com.travel.train.model.searchResult.SearchedDateClass r3 = (com.travel.train.model.searchResult.SearchedDateClass) r3
            if (r3 == 0) goto L_0x0074
            java.lang.String r3 = r3.getClassType()
            goto L_0x0075
        L_0x0074:
            r3 = r1
        L_0x0075:
            if (r3 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r4 = com.travel.train.j.g.al
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = com.travel.train.j.g.al
            r10.o = r3
            goto L_0x0061
        L_0x0087:
            com.travel.train.fragment.ah$b r1 = new com.travel.train.fragment.ah$b
            int r2 = com.travel.train.R.id.class_list
            android.view.View r2 = r10.a((int) r2)
            r4 = r2
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            if (r4 != 0) goto L_0x0097
            kotlin.g.b.k.a()
        L_0x0097:
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            if (r2 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            java.lang.String r3 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r5 = r2
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r7 = r10.o
            r2 = r1
            r3 = r0
            r6 = r11
            r8 = r10
            r9 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
        L_0x00b7:
            int r11 = com.travel.train.R.id.class_list
            android.view.View r10 = r10.a((int) r11)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x00c6
            r11 = 20
            r10.setItemViewCacheSize(r11)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ah.b(com.travel.train.fragment.ah, com.travel.train.model.searchResult.CJRSearchByTrainNumberModel):void");
    }

    public static final /* synthetic */ void d(ah ahVar) {
        ah ahVar2 = ahVar;
        if (com.paytm.utility.b.r((Context) ahVar.getActivity())) {
            String W = com.paytm.utility.b.W(ahVar.getContext());
            if (W == null || TextUtils.isEmpty(W)) {
                ahVar2.j = new com.travel.train.j.b(ahVar.getActivity(), ahVar2, false, (String) null, (String) null, ahVar2.k, ahVar.getChildFragmentManager(), ahVar2.m, 0, false, true);
                com.travel.train.j.b bVar = ahVar2.j;
                if (bVar == null) {
                    k.a();
                }
                bVar.a();
                ahVar2.m = false;
                return;
            }
            ahVar2.j = new com.travel.train.j.b(ahVar.getActivity(), ahVar2, false, (String) null, W, ahVar2.k, ahVar.getChildFragmentManager(), ahVar2.m, 0, false, true);
            com.travel.train.j.b bVar2 = ahVar2.j;
            if (bVar2 == null) {
                k.a();
            }
            bVar2.a(W);
            ahVar2.m = false;
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
        com.travel.train.b.b().a((Context) ahVar.getActivity(), intent, 4);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
