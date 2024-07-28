package com.travel.train.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainFilterActivity;
import com.travel.train.activity.AJRTrainQuickBookActivity;
import com.travel.train.activity.AJRTrainTicketStatusGuide;
import com.travel.train.fragment.ac;
import com.travel.train.fragment.ad;
import com.travel.train.fragment.m;
import com.travel.train.i.u;
import com.travel.train.j.m;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRNearByStation;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import com.travel.train.model.trainticket.CJRTrainUserFavourite;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.x;
import kotlin.s;
import kotlin.x;

public final class ae extends am implements View.OnClickListener, ac.a, m.a, u {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26798a = new a((byte) 0);
    private static final int p = 0;
    private static final int q = 1;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchInput f26799b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSearchInput f26800c;

    /* renamed from: d  reason: collision with root package name */
    private com.travel.train.helper.c f26801d;

    /* renamed from: e  reason: collision with root package name */
    private ac f26802e;

    /* renamed from: f  reason: collision with root package name */
    private final long f26803f = 300;

    /* renamed from: g  reason: collision with root package name */
    private Dialog f26804g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRTrainSearchResults f26805h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainSearchResults f26806i;
    /* access modifiers changed from: private */
    public String j = "";
    private boolean k;
    /* access modifiers changed from: private */
    public int l;
    private o m;
    private com.travel.train.k.c n;
    private com.paytm.b.a.a o;
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<s<? extends CJRTrainSearchResults, ? extends CJRTrainSearchInput, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26809a;

        c(ae aeVar) {
            this.f26809a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            this.f26809a.f26805h = (CJRTrainSearchResults) sVar.getFirst();
            this.f26809a.f26799b = (CJRTrainSearchInput) sVar.getSecond();
            if (sVar.getThird() != null) {
                ae aeVar = this.f26809a;
                Object third = sVar.getThird();
                if (third == null) {
                    kotlin.g.b.k.a();
                }
                aeVar.l = ((Number) third).intValue();
            }
            ae aeVar2 = this.f26809a;
            CJRTrainSearchInput a2 = aeVar2.f26799b;
            this.f26809a.getActivity();
            String c2 = com.travel.train.j.n.c(a2);
            kotlin.g.b.k.a((Object) c2, "CJRTrainSearchResultsUti…ainSearchInput, activity)");
            aeVar2.j = c2;
            ae.b(this.f26809a);
        }
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26810a;

        d(ae aeVar) {
            this.f26810a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            TextView textView = (TextView) this.f26810a.a(R.id.action_bar_error_txt);
            if (textView != null) {
                textView.setText(str);
            }
            FrameLayout frameLayout = (FrameLayout) this.f26810a.a(R.id.error_layout);
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f26811a;

                {
                    this.f26811a = r1;
                }

                public final void run() {
                    FrameLayout frameLayout = (FrameLayout) this.f26811a.f26810a.a(R.id.error_layout);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                }
            }, 4000);
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26812a;

        e(ae aeVar) {
            this.f26812a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                ae.c(this.f26812a);
                ProgressBar progressBar = (ProgressBar) this.f26812a.a(R.id.progressBar_trainlist);
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                ae.d(this.f26812a);
                return;
            }
            ProgressBar progressBar2 = (ProgressBar) this.f26812a.a(R.id.progressBar_trainlist);
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            ae.e(this.f26812a);
        }
    }

    static final class f<T> implements z<ArrayList<CJRTrainUserFavourite>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26813a;

        f(ae aeVar) {
            this.f26813a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ae.a(this.f26813a, (ArrayList) obj);
        }
    }

    static final class g<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26814a;

        g(ae aeVar) {
            this.f26814a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ae.a(this.f26814a, (NetworkCustomError) obj);
        }
    }

    static final class h<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26815a;

        h(ae aeVar) {
            this.f26815a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ae.b(this.f26815a, (NetworkCustomError) obj);
        }
    }

    static final class i<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26816a;

        i(ae aeVar) {
            this.f26816a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ae.c(this.f26816a, (NetworkCustomError) obj);
        }
    }

    static final class j<T> implements z<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26817a;

        j(ae aeVar) {
            this.f26817a = aeVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ae.a(this.f26817a, (Pair) obj);
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
        return layoutInflater.inflate(R.layout.pre_t_activity_train_search, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r2v17, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r19, android.os.Bundle r20) {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = "view"
            r2 = r19
            kotlin.g.b.k.c(r2, r1)
            super.onViewCreated(r19, r20)
            androidx.fragment.app.FragmentActivity r1 = r18.getActivity()
            r2 = 1
            if (r1 == 0) goto L_0x0053
            com.travel.train.k.g r3 = new com.travel.train.k.g
            com.travel.train.k.g$a r4 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r5 = com.travel.train.k.g.b.BOOKING
            r4.<init>(r5)
            com.travel.train.a.a$a r5 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r6 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r7 = r18.getActivity()
            if (r7 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            java.lang.String r8 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            android.content.Context r7 = (android.content.Context) r7
            r6.<init>(r7)
            com.travel.train.a.a.b r6 = (com.travel.train.a.a.b) r6
            com.travel.train.a.a r5 = r5.a(r6)
            com.travel.train.k.g$a r4 = r4.a(r5)
            r4.f27667b = r2
            r3.<init>(r4)
            androidx.lifecycle.al$b r3 = (androidx.lifecycle.al.b) r3
            androidx.lifecycle.al r1 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r1, (androidx.lifecycle.al.b) r3)
            java.lang.Class<com.travel.train.k.c> r3 = com.travel.train.k.c.class
            androidx.lifecycle.ai r1 = r1.a(r3)
            com.travel.train.k.c r1 = (com.travel.train.k.c) r1
            r0.n = r1
        L_0x0053:
            int r1 = com.travel.train.R.id.back_arrow
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0063
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0063:
            int r1 = com.travel.train.R.id.action_bar_title
            android.view.View r1 = r0.a((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x0073
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0073:
            int r1 = com.travel.train.R.id.toolbar_ticket_status_close_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0082
            int r3 = com.travel.common.R.drawable.travel_res_common_close
            r1.setImageResource(r3)
        L_0x0082:
            int r1 = com.travel.train.R.id.toolbar_ticket_status_close_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0092
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0092:
            int r1 = com.travel.train.R.id.toolbar_ticket_status_info_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            com.travel.utils.n$a r3 = com.travel.utils.n.a.V1
            r4 = 0
            java.lang.String r5 = "info_icon.png"
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r1, r5, r4, r2, r3)
            int r1 = com.travel.train.R.id.back_arrow
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r3 = com.travel.common.R.drawable.travel_res_common_back_button
            r1.setImageResource(r3)
            int r1 = com.travel.train.R.id.back_arrow
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r3 = "back_arrow"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r3 = 1127481344(0x43340000, float:180.0)
            r1.setRotation(r3)
            r18.i()
            int r1 = com.travel.train.R.id.error_close_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r3 = com.travel.common.R.drawable.travel_res_common_close
            r1.setImageResource(r3)
            int r1 = com.travel.train.R.id.error_close_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x00e1
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x00e1:
            int r1 = com.travel.train.R.id.clickable_layout
            android.view.View r1 = r0.a((int) r1)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            if (r1 == 0) goto L_0x00f1
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x00f1:
            int r1 = com.travel.train.R.id.train_filter_popup_txt
            android.view.View r1 = r0.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            if (r1 == 0) goto L_0x0101
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0101:
            int r1 = com.travel.train.R.id.bulb_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0111
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0111:
            int r1 = com.travel.train.R.id.close_ac_trains_hidden_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x0121
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0121:
            int r1 = com.travel.train.R.id.close_color_layout
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0131
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0131:
            int r1 = com.travel.train.R.id.toolbar_ticket_status_info_icon
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0141
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x0141:
            com.travel.train.helper.c r1 = new com.travel.train.helper.c
            androidx.fragment.app.FragmentActivity r3 = r18.getActivity()
            int r5 = com.travel.train.R.id.lyt_bottom_tab
            android.view.View r5 = r0.a((int) r5)
            r1.<init>(r3, r5)
            r0.f26801d = r1
            com.travel.train.helper.c r1 = r0.f26801d
            if (r1 != 0) goto L_0x0159
            kotlin.g.b.k.a()
        L_0x0159:
            r3 = r0
            com.travel.train.i.u r3 = (com.travel.train.i.u) r3
            r1.a((com.travel.train.i.u) r3)
            com.travel.train.helper.c r1 = r0.f26801d
            if (r1 != 0) goto L_0x0166
            kotlin.g.b.k.a()
        L_0x0166:
            int r3 = com.travel.train.R.id.ac_trains_hidden_lyt
            android.view.View r3 = r0.a((int) r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r1.a((android.view.View) r3)
            android.os.Bundle r1 = r18.getArguments()
            if (r1 == 0) goto L_0x019b
            java.lang.String r3 = "train_home_bundle"
            boolean r5 = r1.containsKey(r3)
            if (r5 == 0) goto L_0x019b
            android.os.Parcelable r1 = r1.getParcelable(r3)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r1 == 0) goto L_0x019b
            java.lang.String r3 = "alreadyFilterApplied"
            boolean r5 = r1.containsKey(r3)
            if (r5 == 0) goto L_0x019b
            com.travel.train.helper.c r5 = r0.f26801d
            if (r5 == 0) goto L_0x019b
            java.lang.String r1 = r1.getString(r3)
            r5.a((java.lang.String) r1)
        L_0x019b:
            com.travel.train.k.c r1 = r0.n
            r3 = 0
            if (r1 == 0) goto L_0x02d6
            if (r1 != 0) goto L_0x01a5
            kotlin.g.b.k.a()
        L_0x01a5:
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainSearchResults> r1 = r1.f27633d
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            com.travel.train.k.c r5 = r0.n
            if (r5 != 0) goto L_0x01b0
            kotlin.g.b.k.a()
        L_0x01b0:
            androidx.lifecycle.y<com.travel.train.model.CJRTrainSearchInput> r5 = r5.f27631b
            androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
            com.travel.train.k.c r6 = r0.n
            if (r6 != 0) goto L_0x01bb
            kotlin.g.b.k.a()
        L_0x01bb:
            androidx.lifecycle.y<java.lang.Integer> r6 = r6.f27632c
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            java.lang.String r7 = "a"
            kotlin.g.b.k.c(r1, r7)
            java.lang.String r7 = "b"
            kotlin.g.b.k.c(r5, r7)
            java.lang.String r7 = "c"
            kotlin.g.b.k.c(r6, r7)
            androidx.lifecycle.w r7 = new androidx.lifecycle.w
            r7.<init>()
            kotlin.g.b.x$e r15 = new kotlin.g.b.x$e
            r15.<init>()
            r15.element = r3
            kotlin.g.b.x$e r14 = new kotlin.g.b.x$e
            r14.<init>()
            r14.element = r3
            kotlin.g.b.x$e r13 = new kotlin.g.b.x$e
            r13.<init>()
            r13.element = r3
            kotlin.g.b.x$a r12 = new kotlin.g.b.x$a
            r12.<init>()
            r12.element = r4
            kotlin.g.b.x$a r11 = new kotlin.g.b.x$a
            r11.<init>()
            r11.element = r4
            kotlin.g.b.x$a r10 = new kotlin.g.b.x$a
            r10.<init>()
            r10.element = r4
            com.travel.train.fragment.ae$n r9 = new com.travel.train.fragment.ae$n
            r8 = r9
            r3 = r9
            r9 = r7
            r20 = r10
            r10 = r15
            r16 = r11
            r11 = r14
            r17 = r12
            r12 = r13
            r4 = r13
            r13 = r17
            r2 = r14
            r14 = r16
            r0 = r15
            r15 = r20
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            com.travel.train.fragment.ae$o r8 = new com.travel.train.fragment.ae$o
            r9 = r17
            r8.<init>(r0, r9, r3)
            androidx.lifecycle.z r8 = (androidx.lifecycle.z) r8
            r7.addSource(r1, r8)
            com.travel.train.fragment.ae$p r0 = new com.travel.train.fragment.ae$p
            r1 = r16
            r0.<init>(r2, r1, r3)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r7.addSource(r5, r0)
            com.travel.train.fragment.ae$q r0 = new com.travel.train.fragment.ae$q
            r1 = r20
            r0.<init>(r4, r1, r3)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r7.addSource(r6, r0)
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            r0 = r18
            r1 = r0
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.train.fragment.ae$c r2 = new com.travel.train.fragment.ae$c
            r2.<init>(r0)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r7.observe(r1, r2)
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x0260
            androidx.lifecycle.y<java.lang.String> r2 = r2.f27630a
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x0260
            com.travel.train.fragment.ae$d r3 = new com.travel.train.fragment.ae$d
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x0260:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x0274
            androidx.lifecycle.y<java.lang.Boolean> r2 = r2.f27638i
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x0274
            com.travel.train.fragment.ae$e r3 = new com.travel.train.fragment.ae$e
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x0274:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x0288
            androidx.lifecycle.y<java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainUserFavourite>> r2 = r2.p
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x0288
            com.travel.train.fragment.ae$f r3 = new com.travel.train.fragment.ae$f
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x0288:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x029c
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r2 = r2.f27634e
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x029c
            com.travel.train.fragment.ae$g r3 = new com.travel.train.fragment.ae$g
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x029c:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x02b0
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r2 = r2.f27635f
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x02b0
            com.travel.train.fragment.ae$h r3 = new com.travel.train.fragment.ae$h
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x02b0:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x02c4
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r2 = r2.f27637h
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x02c4
            com.travel.train.fragment.ae$i r3 = new com.travel.train.fragment.ae$i
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x02c4:
            com.travel.train.k.c r2 = r0.n
            if (r2 == 0) goto L_0x02d6
            com.travel.train.l.c r2 = r2.f27636g
            if (r2 == 0) goto L_0x02d6
            com.travel.train.fragment.ae$j r3 = new com.travel.train.fragment.ae$j
            r3.<init>(r0)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r2.observe(r1, r3)
        L_0x02d6:
            com.travel.train.b r1 = com.travel.train.b.a()
            java.lang.String r2 = "TrainController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.travel.common.a r1 = com.travel.train.b.b()
            android.content.Context r2 = r18.getContext()
            java.lang.String r3 = "/trains/search-results"
            java.lang.String r4 = "Trains"
            r1.a((java.lang.String) r3, (java.lang.String) r4, (android.content.Context) r2)
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f26799b
            if (r1 == 0) goto L_0x02f8
            java.lang.String r3 = r1.getmSourceCityName()
            r5 = r3
            goto L_0x02f9
        L_0x02f8:
            r5 = 0
        L_0x02f9:
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f26799b
            if (r1 == 0) goto L_0x0303
            java.lang.String r3 = r1.getmDestCityName()
            r6 = r3
            goto L_0x0304
        L_0x0303:
            r6 = 0
        L_0x0304:
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f26799b
            if (r1 == 0) goto L_0x030e
            java.lang.String r3 = r1.getmDate()
            r7 = r3
            goto L_0x030f
        L_0x030e:
            r7 = 0
        L_0x030f:
            r8 = 0
            r9 = 0
            r10 = 0
            android.content.Context r13 = r18.getContext()
            r14 = 0
            java.lang.String r4 = "train_search_results"
            java.lang.String r11 = "screen_loaded"
            java.lang.String r12 = "/trains/search-results"
            com.travel.train.j.o.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r0.f26805h
            if (r1 == 0) goto L_0x0336
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r1.getBody()
            if (r1 == 0) goto L_0x0336
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            if (r1 == 0) goto L_0x0336
            java.util.ArrayList r3 = r1.getPromoMessages()
            goto L_0x0337
        L_0x0336:
            r3 = 0
        L_0x0337:
            if (r3 == 0) goto L_0x0404
            com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r0.f26805h
            if (r1 == 0) goto L_0x0358
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r1.getBody()
            if (r1 == 0) goto L_0x0358
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            if (r1 == 0) goto L_0x0358
            java.util.ArrayList r1 = r1.getPromoMessages()
            if (r1 == 0) goto L_0x0358
            int r1 = r1.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            goto L_0x0359
        L_0x0358:
            r3 = 0
        L_0x0359:
            if (r3 != 0) goto L_0x035e
            kotlin.g.b.k.a()
        L_0x035e:
            int r1 = r3.intValue()
            if (r1 <= 0) goto L_0x0404
            com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r0.f26805h
            if (r1 == 0) goto L_0x0379
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r1.getBody()
            if (r1 == 0) goto L_0x0379
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            if (r1 == 0) goto L_0x0379
            java.util.ArrayList r3 = r1.getPromoMessages()
            goto L_0x037a
        L_0x0379:
            r3 = 0
        L_0x037a:
            if (r3 == 0) goto L_0x0384
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            kotlin.j.d r1 = kotlin.a.k.a((java.util.Collection<?>) r1)
            goto L_0x0385
        L_0x0384:
            r1 = 0
        L_0x0385:
            if (r1 != 0) goto L_0x038a
            kotlin.g.b.k.a()
        L_0x038a:
            int r2 = r1.f47939a
            int r1 = r1.f47940b
            if (r2 > r1) goto L_0x03b8
        L_0x0390:
            java.lang.Object r4 = r3.get(r2)
            com.travel.train.model.trainticket.CJRTrainPromoMessage r4 = (com.travel.train.model.trainticket.CJRTrainPromoMessage) r4
            java.lang.String r5 = "promoMessage"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = r4.getType()
            java.lang.String r6 = "text"
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r7)
            if (r5 == 0) goto L_0x03b3
            java.lang.String r1 = r4.getMessage()
            java.lang.String r2 = "promoMessage.message"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            goto L_0x03bb
        L_0x03b3:
            if (r2 == r1) goto L_0x03b9
            int r2 = r2 + 1
            goto L_0x0390
        L_0x03b8:
            r7 = 1
        L_0x03b9:
            java.lang.String r1 = ""
        L_0x03bb:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0404
            int r2 = com.travel.train.R.id.promo_container
            android.view.View r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x03cf
            r3 = 0
            r2.setVisibility(r3)
        L_0x03cf:
            int r2 = com.travel.train.R.id.promo_container
            android.view.View r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x03e1
            int r3 = com.travel.train.R.id.tv_promo_text
            android.view.View r2 = r2.findViewById(r3)
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x03e2
        L_0x03e1:
            r3 = 0
        L_0x03e2:
            int r2 = com.travel.train.R.id.promo_container
            android.view.View r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x03f3
            int r4 = com.travel.train.R.id.image_view_promo_icon
            android.view.View r2 = r2.findViewById(r4)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x03f4
        L_0x03f3:
            r2 = 0
        L_0x03f4:
            com.travel.utils.n$a r4 = com.travel.utils.n.a.V1
            java.lang.String r5 = "speaker_icon.png"
            r6 = 0
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r2, r5, r6, r6, r4)
            if (r3 == 0) goto L_0x0405
            r3.setText(r1)
            r6 = 1
            goto L_0x0405
        L_0x0404:
            r6 = 0
        L_0x0405:
            if (r6 != 0) goto L_0x0414
            int r1 = com.travel.train.R.id.promo_container
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x0414
            r2 = 8
            r1.setVisibility(r2)
        L_0x0414:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ x.a $isARecieved;
        final /* synthetic */ x.a $isBRecieved;
        final /* synthetic */ x.a $isCRecieved;
        final /* synthetic */ x.e $lastA;
        final /* synthetic */ x.e $lastB;
        final /* synthetic */ x.e $lastC;
        final /* synthetic */ w $this_apply;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(w wVar, x.e eVar, x.e eVar2, x.e eVar3, x.a aVar, x.a aVar2, x.a aVar3) {
            super(0);
            this.$this_apply = wVar;
            this.$lastA = eVar;
            this.$lastB = eVar2;
            this.$lastC = eVar3;
            this.$isARecieved = aVar;
            this.$isBRecieved = aVar2;
            this.$isCRecieved = aVar3;
        }

        public final void invoke() {
            T t = this.$lastA.element;
            T t2 = this.$lastB.element;
            T t3 = this.$lastC.element;
            if (this.$isARecieved.element && this.$isBRecieved.element && this.$isCRecieved.element) {
                this.$isARecieved.element = false;
                this.$isBRecieved.element = false;
                this.$isCRecieved.element = false;
                this.$this_apply.setValue(new s(t, t2, t3));
            }
        }
    }

    static final class o<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26822b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f26823c;

        o(x.e eVar, x.a aVar, n nVar) {
            this.f26821a = eVar;
            this.f26822b = aVar;
            this.f26823c = nVar;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [A, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(A r2) {
            /*
                r1 = this;
                kotlin.g.b.x$e r0 = r1.f26821a
                r0.element = r2
                kotlin.g.b.x$a r2 = r1.f26822b
                r0 = 1
                r2.element = r0
                com.travel.train.fragment.ae$n r2 = r1.f26823c
                r2.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.o.onChanged(java.lang.Object):void");
        }
    }

    static final class p<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26825b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f26826c;

        p(x.e eVar, x.a aVar, n nVar) {
            this.f26824a = eVar;
            this.f26825b = aVar;
            this.f26826c = nVar;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [B, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(B r2) {
            /*
                r1 = this;
                kotlin.g.b.x$e r0 = r1.f26824a
                r0.element = r2
                kotlin.g.b.x$a r2 = r1.f26825b
                r0 = 1
                r2.element = r0
                com.travel.train.fragment.ae$n r2 = r1.f26826c
                r2.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.p.onChanged(java.lang.Object):void");
        }
    }

    static final class q<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26828b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f26829c;

        q(x.e eVar, x.a aVar, n nVar) {
            this.f26827a = eVar;
            this.f26828b = aVar;
            this.f26829c = nVar;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [C, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(C r2) {
            /*
                r1 = this;
                kotlin.g.b.x$e r0 = r1.f26827a
                r0.element = r2
                kotlin.g.b.x$a r2 = r1.f26828b
                r0 = 1
                r2.element = r0
                com.travel.train.fragment.ae$n r2 = r1.f26829c
                r2.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.q.onChanged(java.lang.Object):void");
        }
    }

    private final void b(int i2) {
        CJRTrainSearchResultsBody body;
        CJRTrainSearchResultsBody body2;
        if (i2 == p) {
            ImageView imageView = (ImageView) a(R.id.back_arrow);
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            c(8);
            ImageView imageView2 = (ImageView) a(R.id.arrow_up_down);
            if (imageView2 != null) {
                imageView2.setRotation(360.0f);
            }
            FrameLayout frameLayout = (FrameLayout) a(R.id.booking_layout);
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.clickable_layout);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) a(R.id.toolbar_ticket_status_close_icon);
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            o oVar = this.m;
            if (oVar != null) {
                if (oVar == null) {
                    kotlin.g.b.k.a();
                }
                oVar.a();
                o oVar2 = this.m;
                if (oVar2 == null) {
                    kotlin.g.b.k.a();
                }
                oVar2.b();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("train_booking_from_srp", true);
            this.m = new o();
            o oVar3 = this.m;
            if (oVar3 == null) {
                kotlin.g.b.k.a();
            }
            oVar3.setArguments(bundle);
            androidx.fragment.app.j fragmentManager = getFragmentManager();
            androidx.fragment.app.q a2 = fragmentManager != null ? fragmentManager.a() : null;
            if (a2 != null) {
                int i3 = R.id.booking_layout;
                o oVar4 = this.m;
                if (oVar4 == null) {
                    kotlin.g.b.k.a();
                }
                a2.b(i3, oVar4, o.class.getSimpleName()).a((String) null).c();
            }
        } else if (i2 == q) {
            FrameLayout frameLayout3 = (FrameLayout) a(R.id.booking_layout);
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FrameLayout frameLayout4 = (FrameLayout) a(R.id.clickable_layout);
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
            ImageView imageView4 = (ImageView) a(R.id.toolbar_ticket_status_close_icon);
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            ImageView imageView5 = (ImageView) a(R.id.arrow_up_down);
            if (imageView5 != null) {
                imageView5.setRotation(180.0f);
            }
            ImageView imageView6 = (ImageView) a(R.id.back_arrow);
            if (imageView6 != null) {
                imageView6.setVisibility(0);
            }
            CJRTrainSearchResults cJRTrainSearchResults = this.f26805h;
            if (cJRTrainSearchResults != null && (body2 = cJRTrainSearchResults.getBody()) != null && body2.isTipEnabled()) {
                c(0);
            }
        } else {
            FrameLayout frameLayout5 = (FrameLayout) a(R.id.booking_layout);
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(8);
            }
            FrameLayout frameLayout6 = (FrameLayout) a(R.id.clickable_layout);
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
            }
            ImageView imageView7 = (ImageView) a(R.id.toolbar_ticket_status_close_icon);
            if (imageView7 != null) {
                imageView7.setVisibility(8);
            }
            ImageView imageView8 = (ImageView) a(R.id.arrow_up_down);
            if (imageView8 != null) {
                imageView8.setRotation(180.0f);
            }
            ImageView imageView9 = (ImageView) a(R.id.back_arrow);
            if (imageView9 != null) {
                imageView9.setVisibility(0);
            }
            CJRTrainSearchResults cJRTrainSearchResults2 = this.f26805h;
            if (cJRTrainSearchResults2 != null && (body = cJRTrainSearchResults2.getBody()) != null && body.isTipEnabled()) {
                c(0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r5 = this;
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 == 0) goto L_0x00e7
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a()
        L_0x0009:
            java.lang.String r0 = r0.getmDestCityName()
            if (r0 == 0) goto L_0x00e7
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x0016
            kotlin.g.b.k.a()
        L_0x0016:
            java.lang.String r0 = r0.getmSourceCityName()
            if (r0 == 0) goto L_0x00e7
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            java.lang.String r0 = r0.getmSourceCityName()
            java.lang.String r1 = "mTrainSearchInput!!.getmSourceCityName()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r2 = com.travel.train.R.string.trains_all_station_string
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r3 = "getString(R.string.trains_all_station_string)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 0
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r2, (boolean) r4)
            if (r0 == 0) goto L_0x0066
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x0049
            kotlin.g.b.k.a()
        L_0x0049:
            java.lang.String r0 = r0.getSourceAirPortName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0066
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            java.lang.String r0 = r0.getSourceAirPortName()
            java.lang.String r1 = "mTrainSearchInput!!.sourceAirPortName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x0074
        L_0x0066:
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x006d
            kotlin.g.b.k.a()
        L_0x006d:
            java.lang.String r0 = r0.getmSourceCityName()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x0074:
            int r1 = com.travel.train.R.id.source_name
            android.view.View r1 = r5.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            if (r1 == 0) goto L_0x0083
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x0083:
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x008a
            kotlin.g.b.k.a()
        L_0x008a:
            java.lang.String r0 = r0.getmDestCityName()
            java.lang.String r1 = "mTrainSearchInput!!.getmDestCityName()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r2 = com.travel.train.R.string.trains_all_station_string
            java.lang.String r2 = r5.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r2, (boolean) r4)
            if (r0 == 0) goto L_0x00ca
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x00ad
            kotlin.g.b.k.a()
        L_0x00ad:
            java.lang.String r0 = r0.getDestAirportName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ca
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x00c0
            kotlin.g.b.k.a()
        L_0x00c0:
            java.lang.String r0 = r0.getDestAirportName()
            java.lang.String r1 = "mTrainSearchInput!!.destAirportName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x00d8
        L_0x00ca:
            com.travel.train.model.CJRTrainSearchInput r0 = r5.f26799b
            if (r0 != 0) goto L_0x00d1
            kotlin.g.b.k.a()
        L_0x00d1:
            java.lang.String r0 = r0.getmDestCityName()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x00d8:
            int r1 = com.travel.train.R.id.destination_name
            android.view.View r1 = r5.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            if (r1 == 0) goto L_0x00e7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.i():void");
    }

    private final void j() {
        ad.a aVar = ad.f26774b;
        Bundle bundle = new Bundle();
        kotlin.g.b.k.c(bundle, "args");
        ad adVar = new ad();
        adVar.setArguments(bundle);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
        a2.b(R.id.view_frame_train_search, adVar);
        a2.c();
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26807a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f26808b = true;

        b(ae aeVar) {
            this.f26807a = aeVar;
        }

        public final void run() {
            if (this.f26807a.getActivity() != null) {
                FragmentActivity activity = this.f26807a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                if (!activity.isFinishing()) {
                    ae.a(this.f26807a, this.f26808b);
                }
            }
        }
    }

    public final void b() {
        new Handler().postDelayed(new b(this), this.f26803f);
    }

    public static final class k implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26818a;

        k(ae aeVar) {
            this.f26818a = aeVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            FragmentActivity activity;
            kotlin.g.b.k.c(dialogInterface, "dialog");
            kotlin.g.b.k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (i2 != 4 || (activity = this.f26818a.getActivity()) == null) {
                return true;
            }
            activity.finish();
            return true;
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26819a;

        l(ae aeVar) {
            this.f26819a = aeVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f26819a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void c(int i2) {
        ImageView imageView = (ImageView) a(R.id.toolbar_ticket_status_info_icon);
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
    }

    private Bundle b(CJRTrainSearchResults cJRTrainSearchResults) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("intent_extra_TRAIN_search_load_data", true);
        CJRTrainSearchInput cJRTrainSearchInput = new CJRTrainSearchInput(this.f26799b);
        com.travel.train.helper.c cVar = this.f26801d;
        if (cVar == null) {
            kotlin.g.b.k.a();
        }
        com.travel.train.model.trainticket.i f2 = cVar.f();
        if (f2 != null) {
            cJRTrainSearchInput.setmSortBy(f2.getSortByTrain());
            cJRTrainSearchInput.setmOrderBy(f2.getOrderBy());
            bundle.putSerializable("intent_default_sort", f2);
        }
        bundle.putSerializable("intent_extra_train_search_input", cJRTrainSearchInput);
        bundle.putSerializable("intent_extra_train_list", cJRTrainSearchResults);
        com.travel.train.helper.c cVar2 = this.f26801d;
        if (cVar2 == null) {
            kotlin.g.b.k.a();
        }
        bundle.putString("alreadyFilterApplied", cVar2.a());
        com.travel.train.helper.c cVar3 = this.f26801d;
        if (cVar3 == null) {
            kotlin.g.b.k.a();
        }
        bundle.putSerializable("intent_filter_result", cVar3.c());
        return bundle;
    }

    private void c(CJRTrainSearchResults cJRTrainSearchResults) {
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isFinishing()) {
            com.travel.train.helper.c cVar = this.f26801d;
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            cVar.c(cJRTrainSearchResults);
            c(0);
            ac acVar = this.f26802e;
            if (acVar != null) {
                if (acVar == null) {
                    kotlin.g.b.k.a();
                }
                if (acVar.isAdded()) {
                    Bundle b2 = b(cJRTrainSearchResults);
                    ac acVar2 = this.f26802e;
                    if (acVar2 == null) {
                        kotlin.g.b.k.a();
                    }
                    acVar2.b(b2);
                    return;
                }
            }
            this.f26802e = ac.a(b(cJRTrainSearchResults));
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
            int i2 = R.id.view_frame_train_search;
            ac acVar3 = this.f26802e;
            if (acVar3 == null) {
                kotlin.g.b.k.a();
            }
            a2.b(i2, acVar3);
            a2.c();
        }
    }

    static final class m implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f26820a;

        m(ae aeVar) {
            this.f26820a = aeVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            ae.f(this.f26820a);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        ac acVar;
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            return;
        }
        if (i2 == com.paytm.utility.e.aJ) {
            if (this.f26802e != null) {
                intent.getBooleanExtra("login_success", false);
                ac acVar2 = this.f26802e;
                if (acVar2 == null) {
                    kotlin.g.b.k.a();
                }
                acVar2.g();
            }
        } else if (i2 == 989) {
            ac acVar3 = this.f26802e;
            if (acVar3 != null) {
                if (acVar3 == null) {
                    kotlin.g.b.k.a();
                }
                acVar3.a(intent);
            }
        } else if (i2 == 123) {
            Serializable serializableExtra = intent.getSerializableExtra("intent_search_result");
            if (serializableExtra != null) {
                this.f26805h = (CJRTrainSearchResults) serializableExtra;
                Serializable serializableExtra2 = intent.getSerializableExtra("intent_filter_result");
                if (serializableExtra2 != null) {
                    CJRTrainFilterModel cJRTrainFilterModel = (CJRTrainFilterModel) serializableExtra2;
                    Serializable serializableExtra3 = intent.getSerializableExtra("train_filter_ac_and_non_ac_list");
                    if (serializableExtra3 != null) {
                        ArrayList arrayList = (ArrayList) serializableExtra3;
                        boolean booleanExtra = intent.getBooleanExtra("train_filter_check", false);
                        com.travel.train.helper.c cVar = this.f26801d;
                        if (cVar == null) {
                            kotlin.g.b.k.a();
                        }
                        cVar.a(this.f26805h, cJRTrainFilterModel, arrayList, booleanExtra);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainFilterItem>");
                }
                throw new kotlin.u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainFilterModel");
            }
            throw new kotlin.u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSearchResults");
        } else if (i2 != 550) {
            Fragment fragment = null;
            if (i2 == 201 || i2 == 202 || i2 == 1) {
                androidx.fragment.app.j fragmentManager = getFragmentManager();
                if (fragmentManager != null) {
                    fragment = fragmentManager.c(o.class.getSimpleName());
                }
                if (fragment != null) {
                    fragment.onActivityResult(i2, i3, intent);
                }
            } else if (i2 == 4) {
                if (com.paytm.utility.b.r((Context) getActivity()) && (acVar = this.f26802e) != null) {
                    if (acVar == null) {
                        kotlin.g.b.k.a();
                    }
                    acVar.g();
                }
            } else if (i2 == com.paytm.utility.e.aJ) {
                ac acVar4 = this.f26802e;
                if (acVar4 != null) {
                    if (acVar4 == null) {
                        kotlin.g.b.k.a();
                    }
                    acVar4.g();
                }
            } else if (i2 == 1) {
                androidx.fragment.app.j fragmentManager2 = getFragmentManager();
                if (fragmentManager2 != null) {
                    fragment = fragmentManager2.c(o.class.getSimpleName());
                }
                if (fragment != null) {
                    fragment.onActivityResult(i2, i3, intent);
                }
            }
        } else if (i3 == 155) {
            new m(this).a();
        }
    }

    public final void onClick(View view) {
        kotlin.g.b.k.c(view, "v");
        int id = view.getId();
        if (id == R.id.back_arrow) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            com.travel.train.j.n.a("train_search_results_prev_next_date_selected", "previous", this.f26799b, getActivity());
        } else if (id == R.id.error_close_icon) {
            FrameLayout frameLayout = (FrameLayout) a(R.id.error_layout);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else if (id == R.id.action_bar_title) {
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.booking_layout);
            if (frameLayout2 == null || frameLayout2.getVisibility() != 0) {
                b(p);
            } else {
                b(q);
            }
        } else if (id == R.id.toolbar_ticket_status_close_icon || id == R.id.clickable_layout) {
            b(q);
        } else if (id == R.id.toolbar_ticket_status_info_icon) {
            com.travel.train.j.n.a(net.one97.paytm.common.utility.d.cO, (Context) getActivity());
            c(0);
            startActivity(new Intent(getContext(), AJRTrainTicketStatusGuide.class));
        } else if (id == R.id.close_color_layout) {
            View a2 = a(R.id.color_code_info);
            if (a2 != null) {
                a2.setVisibility(8);
            }
            com.paytm.b.a.a aVar = this.o;
            if (aVar != null) {
                aVar.a("train_color_info", true, false);
            }
        }
    }

    public final void c() {
        CJRTrainSearchInput cJRTrainSearchInput = this.f26799b;
        if (cJRTrainSearchInput == null) {
            kotlin.g.b.k.a();
        }
        String str = cJRTrainSearchInput.getmSourceCityName();
        CJRTrainSearchInput cJRTrainSearchInput2 = this.f26799b;
        if (cJRTrainSearchInput2 == null) {
            kotlin.g.b.k.a();
        }
        String str2 = cJRTrainSearchInput2.getmDestCityName();
        CJRTrainSearchInput cJRTrainSearchInput3 = this.f26799b;
        if (cJRTrainSearchInput3 == null) {
            kotlin.g.b.k.a();
        }
        com.travel.train.j.o.a("train_search_results", str, str2, cJRTrainSearchInput3.getmDate(), (String) null, (String) null, (String) null, "filter_trains", "/trains/search-results", getActivity(), (Map<String, Object>) null);
        CJRTrainSearchInput cJRTrainSearchInput4 = this.f26799b;
        if (cJRTrainSearchInput4 == null) {
            kotlin.g.b.k.a();
        }
        String str3 = cJRTrainSearchInput4.getmSourceCityName();
        CJRTrainSearchInput cJRTrainSearchInput5 = this.f26799b;
        if (cJRTrainSearchInput5 == null) {
            kotlin.g.b.k.a();
        }
        String str4 = cJRTrainSearchInput5.getmDestCityName();
        CJRTrainSearchInput cJRTrainSearchInput6 = this.f26799b;
        if (cJRTrainSearchInput6 == null) {
            kotlin.g.b.k.a();
        }
        com.travel.train.j.o.a("train_search_results", str3, str4, cJRTrainSearchInput6.getmDate(), (String) null, (String) null, (String) null, "filter_icon_clicked", "/trains/search-results", getActivity(), (Map<String, Object>) null);
        Intent intent = new Intent(getContext(), AJRTrainFilterActivity.class);
        intent.putExtra("intent_search_result", this.f26806i);
        com.travel.train.helper.c cVar = this.f26801d;
        if (cVar == null) {
            kotlin.g.b.k.a();
        }
        intent.putExtra("intent_filter_result", cVar.c());
        CJRTrainSearchInput cJRTrainSearchInput7 = this.f26799b;
        if (cJRTrainSearchInput7 == null) {
            kotlin.g.b.k.a();
        }
        intent.putExtra("source_station_name", cJRTrainSearchInput7.getmSourceCityName());
        CJRTrainSearchInput cJRTrainSearchInput8 = this.f26799b;
        if (cJRTrainSearchInput8 == null) {
            kotlin.g.b.k.a();
        }
        intent.putExtra("destination_station_name", cJRTrainSearchInput8.getmDestCityName());
        com.travel.train.helper.c cVar2 = this.f26801d;
        if (cVar2 == null) {
            kotlin.g.b.k.a();
        }
        intent.putExtra("train_filter_ac_and_non_ac_list", cVar2.b());
        com.travel.train.helper.c cVar3 = this.f26801d;
        if (cVar3 == null) {
            kotlin.g.b.k.a();
        }
        intent.putExtra("alreadyFilterApplied", cVar3.a());
        startActivityForResult(intent, 123);
    }

    public final CJRTrainSearchResults d() {
        return this.f26805h;
    }

    public final CJRTrainSearchResults e() {
        return this.f26806i;
    }

    public final void a(com.travel.train.model.trainticket.i iVar) {
        if (!(this.f26799b == null || iVar == null)) {
            if (kotlin.m.p.a(iVar.getOrderByTrain(), StringSet.reverse, true)) {
                CJRTrainSearchInput cJRTrainSearchInput = this.f26799b;
                if (cJRTrainSearchInput == null) {
                    kotlin.g.b.k.a();
                }
                String str = cJRTrainSearchInput.getmSourceCityName();
                CJRTrainSearchInput cJRTrainSearchInput2 = this.f26799b;
                if (cJRTrainSearchInput2 == null) {
                    kotlin.g.b.k.a();
                }
                String str2 = cJRTrainSearchInput2.getmDestCityName();
                CJRTrainSearchInput cJRTrainSearchInput3 = this.f26799b;
                if (cJRTrainSearchInput3 == null) {
                    kotlin.g.b.k.a();
                }
                com.travel.train.j.o.a("train_search_results", str, str2, cJRTrainSearchInput3.getmDate(), iVar.getSortByTrain(), "desc", (String) null, "trains_sorted", "/trains/search-results", getContext(), (Map<String, Object>) null);
            } else {
                CJRTrainSearchInput cJRTrainSearchInput4 = this.f26799b;
                if (cJRTrainSearchInput4 == null) {
                    kotlin.g.b.k.a();
                }
                String str3 = cJRTrainSearchInput4.getmSourceCityName();
                CJRTrainSearchInput cJRTrainSearchInput5 = this.f26799b;
                if (cJRTrainSearchInput5 == null) {
                    kotlin.g.b.k.a();
                }
                String str4 = cJRTrainSearchInput5.getmDestCityName();
                CJRTrainSearchInput cJRTrainSearchInput6 = this.f26799b;
                if (cJRTrainSearchInput6 == null) {
                    kotlin.g.b.k.a();
                }
                com.travel.train.j.o.a("train_search_results", str3, str4, cJRTrainSearchInput6.getmDate(), iVar.getSortByTrain(), "asc", (String) null, "trains_sorted", "/trains/search-results", getContext(), (Map<String, Object>) null);
            }
        }
        ac acVar = this.f26802e;
        if (acVar != null) {
            if (acVar == null) {
                kotlin.g.b.k.a();
            }
            if (acVar.isAdded()) {
                ac acVar2 = this.f26802e;
                if (acVar2 == null) {
                    kotlin.g.b.k.a();
                }
                acVar2.a(iVar);
            }
        }
        CJRTrainSearchInput cJRTrainSearchInput7 = this.f26799b;
        if (cJRTrainSearchInput7 == null) {
            kotlin.g.b.k.a();
        }
        String str5 = cJRTrainSearchInput7.getmSourceCityName();
        CJRTrainSearchInput cJRTrainSearchInput8 = this.f26799b;
        if (cJRTrainSearchInput8 == null) {
            kotlin.g.b.k.a();
        }
        String str6 = cJRTrainSearchInput8.getmDestCityName();
        CJRTrainSearchInput cJRTrainSearchInput9 = this.f26799b;
        if (cJRTrainSearchInput9 == null) {
            kotlin.g.b.k.a();
        }
        com.travel.train.j.o.a("train_search_results", str5, str6, cJRTrainSearchInput9.getmDate(), (String) null, (String) null, (String) null, "sort_trains_clicked", "/trains/search-results", getActivity(), (Map<String, Object>) null);
    }

    public final void f() {
        com.travel.train.k.c cVar = this.n;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void a() {
        removeProgressDialog();
    }

    public final void a(CJRNearByStation cJRNearByStation) {
        if (cJRNearByStation != null) {
            k();
            CJRTrainSearchInput cJRTrainSearchInput = this.f26799b;
            this.f26800c = cJRTrainSearchInput != null ? cJRTrainSearchInput.clone() : null;
            CJRTrainSearchInput cJRTrainSearchInput2 = this.f26799b;
            if (cJRTrainSearchInput2 != null) {
                cJRTrainSearchInput2.setmSourceCityCode(cJRNearByStation.getSrcCode());
            }
            CJRTrainSearchInput cJRTrainSearchInput3 = this.f26799b;
            if (cJRTrainSearchInput3 != null) {
                cJRTrainSearchInput3.setmSourceCityName(cJRNearByStation.getSrcCity());
            }
            CJRTrainSearchInput cJRTrainSearchInput4 = this.f26799b;
            if (cJRTrainSearchInput4 != null) {
                cJRTrainSearchInput4.setmDestCityCode(cJRNearByStation.getDestCode());
            }
            CJRTrainSearchInput cJRTrainSearchInput5 = this.f26799b;
            if (cJRTrainSearchInput5 != null) {
                cJRTrainSearchInput5.setmDestCityName(cJRNearByStation.getDestCity());
            }
            com.travel.train.k.c cVar = this.n;
            if (cVar != null) {
                CJRTrainSearchInput cJRTrainSearchInput6 = this.f26799b;
                if (cJRTrainSearchInput6 == null) {
                    kotlin.g.b.k.a();
                }
                cVar.a(cJRTrainSearchInput6);
            }
            com.travel.train.k.c cVar2 = this.n;
            if (cVar2 != null) {
                HashMap<String, String> d2 = com.travel.train.j.n.d(getContext());
                kotlin.g.b.k.a((Object) d2, "CJRTrainSearchResultsUti…aderParams(context, true)");
                HashMap<String, String> a2 = com.travel.train.j.n.a(this.f26799b);
                kotlin.g.b.k.a((Object) a2, "CJRTrainSearchResultsUti…inList(mTrainSearchInput)");
                cVar2.a(d2, a2);
            }
            com.travel.train.k.c cVar3 = this.n;
            if (cVar3 != null) {
                cVar3.c();
            }
            if (cJRNearByStation != null) {
                CJRTrainRecentsItemModel cJRTrainRecentsItemModel = new CJRTrainRecentsItemModel(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 4095, (kotlin.g.b.g) null);
                cJRTrainRecentsItemModel.setSourceCityCode(cJRNearByStation.getSrcCode());
                cJRTrainRecentsItemModel.setSourceCityName(cJRNearByStation.getSrcName());
                cJRTrainRecentsItemModel.setSourceAirportName("");
                cJRTrainRecentsItemModel.setDestinationCityCode(cJRNearByStation.getDestCode());
                cJRTrainRecentsItemModel.setDestinationCityName(cJRNearByStation.getDestName());
                cJRTrainRecentsItemModel.setDestinationAirportName("");
                CJRTrainSearchInput cJRTrainSearchInput7 = this.f26799b;
                if (cJRTrainSearchInput7 == null) {
                    kotlin.g.b.k.a();
                }
                cJRTrainRecentsItemModel.setDateOfTravel(cJRTrainSearchInput7.getmDate());
                m.a aVar = com.travel.train.j.m.f27577a;
                m.a.a(cJRTrainRecentsItemModel, "train_most_visited", 5, getContext());
            }
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "dateSelected");
        k();
        CJRTrainSearchInput cJRTrainSearchInput = this.f26799b;
        if (cJRTrainSearchInput != null) {
            if (cJRTrainSearchInput == null) {
                kotlin.g.b.k.a();
            }
            cJRTrainSearchInput.setmDate(str);
            com.travel.train.k.c cVar = this.n;
            if (cVar != null) {
                CJRTrainSearchInput cJRTrainSearchInput2 = this.f26799b;
                if (cJRTrainSearchInput2 == null) {
                    kotlin.g.b.k.a();
                }
                cVar.a(cJRTrainSearchInput2);
            }
            com.travel.train.k.c cVar2 = this.n;
            if (cVar2 != null) {
                HashMap<String, String> d2 = com.travel.train.j.n.d(getContext());
                kotlin.g.b.k.a((Object) d2, "CJRTrainSearchResultsUti…aderParams(context, true)");
                HashMap<String, String> a2 = com.travel.train.j.n.a(this.f26799b);
                kotlin.g.b.k.a((Object) a2, "CJRTrainSearchResultsUti…inList(mTrainSearchInput)");
                cVar2.a(d2, a2);
            }
        }
        this.k = true;
        com.travel.train.k.c cVar3 = this.n;
        if (cVar3 != null) {
            cVar3.c();
        }
    }

    public final void a(CJRTrainUserFavourite cJRTrainUserFavourite) {
        kotlin.g.b.k.c(cJRTrainUserFavourite, "userFavourite");
        Intent intent = new Intent(getContext(), AJRTrainQuickBookActivity.class);
        intent.putExtra("train_favourite_quick_book", cJRTrainUserFavourite);
        startActivityForResult(intent, 133);
        com.travel.train.j.o.a("train_search_results", cJRTrainUserFavourite.getTrainNumber(), "quick_book_clicked", "/trains/search-results", getContext());
    }

    public final void g() {
        k();
        b(p);
    }

    public final void h() {
        k();
        com.travel.train.helper.c cVar = this.f26801d;
        if (cVar != null) {
            cVar.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r3.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.train.model.trainticket.CJRTrainSearchResults r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000e
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r3.getBody()
            if (r1 == 0) goto L_0x000e
            java.util.List r1 = r1.getTrains()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 == 0) goto L_0x002c
            if (r3 == 0) goto L_0x001d
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r3.getBody()
            if (r1 == 0) goto L_0x001d
            java.util.List r0 = r1.getTrains()
        L_0x001d:
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x002c
            r2.c((com.travel.train.model.trainticket.CJRTrainSearchResults) r3)
            return
        L_0x002c:
            int r3 = com.travel.train.R.id.progressBar_trainlist
            android.view.View r3 = r2.a((int) r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            r0 = 8
            if (r3 == 0) goto L_0x003b
            r3.setVisibility(r0)
        L_0x003b:
            int r3 = com.travel.train.R.id.color_code_info
            android.view.View r3 = r2.a((int) r3)
            if (r3 == 0) goto L_0x0046
            r3.setVisibility(r0)
        L_0x0046:
            int r3 = com.travel.train.R.id.ac_trains_hidden_lyt
            android.view.View r3 = r2.a((int) r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            if (r3 == 0) goto L_0x0053
            r3.setVisibility(r0)
        L_0x0053:
            r2.c((int) r0)
            com.travel.train.fragment.s$a r3 = com.travel.train.fragment.s.f27151a
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            com.travel.train.fragment.s r3 = com.travel.train.fragment.s.a.a(r3)
            androidx.fragment.app.j r0 = r2.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            java.lang.String r1 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = com.travel.train.R.id.view_frame_train_search
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r0.b(r1, r3)
            r0.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.a(com.travel.train.model.trainticket.CJRTrainSearchResults):void");
    }

    private final void k() {
        Fragment c2 = getChildFragmentManager().c(R.id.view_frame_train_search);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
        if (c2 != null) {
            a2.a(c2);
            a2.c();
        }
    }

    public final void a(boolean z) {
        Resources resources;
        Resources resources2;
        ImageView imageView = (ImageView) a(R.id.toolbar_ticket_status_info_icon);
        if (imageView != null) {
            com.travel.train.hintsbuilder.b a2 = new com.travel.train.hintsbuilder.b(getActivity()).a((View) imageView).a(!z ? "2/2" : "3/3");
            FragmentActivity activity = getActivity();
            String str = null;
            com.travel.train.hintsbuilder.b a3 = a2.b((activity == null || (resources2 = activity.getResources()) == null) ? null : resources2.getString(R.string.train_show_tip_view_desc3)).b().c().a(true);
            FragmentActivity activity2 = getActivity();
            if (!(activity2 == null || (resources = activity2.getResources()) == null)) {
                str = resources.getString(R.string.train_show_tip_view_positive_button2);
            }
            a3.c(str).a(R.layout.pre_t_train_intro_srp_show_tip_layout).a().a((Activity) getActivity());
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.g.b.k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        com.travel.train.j.n.a("train_search_results_back_button_clicked", (String) null, this.f26799b, getActivity());
        onBackPressed();
        return true;
    }

    public final boolean onBackPressed() {
        boolean z;
        CJRTrainSearchInput cJRTrainSearchInput;
        FrameLayout frameLayout = (FrameLayout) a(R.id.booking_layout);
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            z = false;
        } else {
            b(q);
            z = true;
        }
        Fragment c2 = getChildFragmentManager().c(R.id.view_frame_train_search);
        if (!z && c2 != null) {
            if (c2 instanceof ac) {
                ac acVar = this.f26802e;
                if (acVar == null) {
                    kotlin.g.b.k.a();
                }
                if (!acVar.f()) {
                    com.travel.train.k.c cVar = this.n;
                    Boolean valueOf = cVar != null ? Boolean.valueOf(cVar.b()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.booleanValue() && (cJRTrainSearchInput = this.f26800c) != null) {
                        com.travel.train.k.c cVar2 = this.n;
                        if (cVar2 != null) {
                            if (cJRTrainSearchInput == null) {
                                kotlin.g.b.k.a();
                            }
                            cVar2.a(cJRTrainSearchInput);
                        }
                        com.travel.train.k.c cVar3 = this.n;
                        if (cVar3 != null) {
                            cVar3.a(250);
                        }
                        com.travel.train.k.c cVar4 = this.n;
                        if (cVar4 != null) {
                            cVar4.a((CJRTrainSearchResults) null);
                        }
                    }
                }
            } else if (c2 instanceof ad) {
                com.travel.train.k.c cVar5 = this.n;
                Boolean valueOf2 = cVar5 != null ? Boolean.valueOf(cVar5.b()) : null;
                if (valueOf2 == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf2.booleanValue() && this.f26800c != null && !((ad) c2).f26775a) {
                    com.travel.train.k.c cVar6 = this.n;
                    if (cVar6 != null) {
                        CJRTrainSearchInput cJRTrainSearchInput2 = this.f26800c;
                        if (cJRTrainSearchInput2 == null) {
                            kotlin.g.b.k.a();
                        }
                        cVar6.a(cJRTrainSearchInput2);
                    }
                    com.travel.train.k.c cVar7 = this.n;
                    if (cVar7 != null) {
                        cVar7.a(250);
                    }
                    com.travel.train.k.c cVar8 = this.n;
                    if (cVar8 != null) {
                        cVar8.a((CJRTrainSearchResults) null);
                    }
                }
            }
            z = true;
        }
        if (!z) {
            com.travel.train.k.c cVar9 = this.n;
            if (cVar9 != null) {
                if (cVar9 == null) {
                    kotlin.g.b.k.a();
                }
                if (cVar9.q) {
                    Intent intent = new Intent();
                    intent.putExtra("intent_extra_train_search_input", this.f26799b);
                    com.travel.train.helper.c cVar10 = this.f26801d;
                    if (cVar10 == null) {
                        kotlin.g.b.k.a();
                    }
                    intent.putExtra("alreadyFilterApplied", cVar10.a());
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.setResult(-1, intent);
                    }
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
        return true;
    }

    public final void onPause() {
        super.onPause();
        Dialog dialog = this.f26804g;
        if (dialog != null) {
            if (dialog == null) {
                kotlin.g.b.k.a();
            }
            if (dialog.isShowing()) {
                Dialog dialog2 = this.f26804g;
                if (dialog2 == null) {
                    kotlin.g.b.k.a();
                }
                dialog2.dismiss();
            }
        }
        this.f26804g = null;
    }

    public final void onResume() {
        super.onResume();
        removeProgressDialog();
    }

    public final void onStop() {
        super.onStop();
        removeProgressDialog();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f26802e = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00de, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(com.travel.train.fragment.ae r8) {
        /*
            r8.i()
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getLanguage()
            java.lang.String r1 = "hi"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0059
            int r0 = com.travel.train.R.id.from_date
            android.view.View r0 = r8.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x008b
            boolean r3 = r8.k
            if (r3 == 0) goto L_0x0047
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r8.j
            r3.append(r4)
            java.lang.String r4 = " "
            r3.append(r4)
            int r4 = com.travel.train.R.string.label_from
            java.lang.String r4 = r8.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0055
        L_0x0047:
            int r3 = com.travel.train.R.string.train_label_from
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = r8.j
            r4[r2] = r5
            java.lang.String r3 = r8.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x0055:
            r0.setText(r3)
            goto L_0x008b
        L_0x0059:
            int r0 = com.travel.train.R.id.from_date
            android.view.View r0 = r8.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x008b
            boolean r3 = r8.k
            if (r3 == 0) goto L_0x007a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "From "
            r3.<init>(r4)
            java.lang.String r4 = r8.j
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0088
        L_0x007a:
            int r3 = com.travel.train.R.string.train_label_from
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = r8.j
            r4[r2] = r5
            java.lang.String r3 = r8.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x0088:
            r0.setText(r3)
        L_0x008b:
            int r0 = q
            r8.b((int) r0)
            int r0 = r8.l
            if (r0 != 0) goto L_0x00c2
            com.travel.train.k.c r0 = r8.n
            if (r0 == 0) goto L_0x00a2
            com.travel.train.model.CJRTrainSearchInput r1 = r8.f26799b
            if (r1 != 0) goto L_0x009f
            kotlin.g.b.k.a()
        L_0x009f:
            r0.a((com.travel.train.model.CJRTrainSearchInput) r1)
        L_0x00a2:
            com.travel.train.k.c r0 = r8.n
            if (r0 == 0) goto L_0x00c1
            android.content.Context r1 = r8.getContext()
            java.util.HashMap r1 = com.travel.train.j.n.d((android.content.Context) r1)
            java.lang.String r2 = "CJRTrainSearchResultsUti…aderParams(context, true)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.travel.train.model.CJRTrainSearchInput r8 = r8.f26799b
            java.util.HashMap r8 = com.travel.train.j.n.a((com.travel.train.model.CJRTrainSearchInput) r8)
            java.lang.String r2 = "CJRTrainSearchResultsUti…inList(mTrainSearchInput)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            r0.a((java.util.HashMap<java.lang.String, java.lang.String>) r1, (java.util.HashMap<java.lang.String, java.lang.String>) r8)
        L_0x00c1:
            return
        L_0x00c2:
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 8
            if (r0 != r3) goto L_0x020a
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            if (r0 == 0) goto L_0x020a
            int r0 = com.travel.train.R.id.progressBar_trainlist
            android.view.View r0 = r8.a((int) r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            if (r0 == 0) goto L_0x00d9
            r0.setVisibility(r4)
        L_0x00d9:
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            r3 = 0
            if (r0 == 0) goto L_0x00e9
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x00e9
            java.util.List r0 = r0.getTrains()
            goto L_0x00ea
        L_0x00e9:
            r0 = r3
        L_0x00ea:
            if (r0 == 0) goto L_0x013a
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            if (r0 == 0) goto L_0x0105
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x0105
            java.util.List r0 = r0.getTrains()
            if (r0 == 0) goto L_0x0105
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0106
        L_0x0105:
            r0 = r3
        L_0x0106:
            if (r0 != 0) goto L_0x010b
            kotlin.g.b.k.a()
        L_0x010b:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x013a
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            if (r0 != 0) goto L_0x0118
            kotlin.g.b.k.a()
        L_0x0118:
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.Object r0 = com.travel.train.j.n.a((java.io.Serializable) r0)
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = (com.travel.train.model.trainticket.CJRTrainSearchResults) r0
            r8.f26806i = r0
            com.travel.train.helper.c r0 = r8.f26801d
            if (r0 != 0) goto L_0x0129
            kotlin.g.b.k.a()
        L_0x0129:
            com.travel.train.model.trainticket.CJRTrainSearchResults r5 = r8.f26805h
            r0.a((com.travel.train.model.trainticket.CJRTrainSearchResults) r5)
            com.travel.train.helper.c r0 = r8.f26801d
            if (r0 != 0) goto L_0x0135
            kotlin.g.b.k.a()
        L_0x0135:
            com.travel.train.model.trainticket.CJRTrainSearchResults r5 = r8.f26805h
            r0.b((com.travel.train.model.trainticket.CJRTrainSearchResults) r5)
        L_0x013a:
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            if (r0 == 0) goto L_0x01d1
            if (r0 != 0) goto L_0x0143
            kotlin.g.b.k.a()
        L_0x0143:
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x01d1
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 == 0) goto L_0x01d1
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            if (r0 == 0) goto L_0x015e
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x015e
            java.util.List r0 = r0.getTrains()
            goto L_0x015f
        L_0x015e:
            r0 = r3
        L_0x015f:
            if (r0 == 0) goto L_0x017a
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x017a
            com.travel.train.model.CJRTrainSearchInput r5 = r8.f26799b
            if (r5 == 0) goto L_0x01d1
            androidx.fragment.app.FragmentActivity r5 = r8.getActivity()
            android.content.Context r5 = (android.content.Context) r5
            com.travel.train.model.CJRTrainSearchInput r6 = r8.f26799b
            int r7 = r0.size()
            com.travel.train.j.n.a((android.content.Context) r5, (com.travel.train.model.CJRTrainSearchInput) r6, (int) r7)
        L_0x017a:
            com.travel.train.model.trainticket.CJRTrainSearchResults r5 = r8.f26805h
            if (r5 == 0) goto L_0x018d
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x018d
            boolean r5 = r5.isTipEnabled()
            if (r5 != r1) goto L_0x018d
            r8.c((int) r2)
        L_0x018d:
            com.travel.train.model.trainticket.CJRTrainSearchResults r5 = r8.f26805h
            if (r5 != 0) goto L_0x0194
            kotlin.g.b.k.a()
        L_0x0194:
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x01b3
            if (r0 == 0) goto L_0x01b3
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x01b3
            int r0 = com.travel.train.R.id.lyt_bottom_tab
            android.view.View r0 = r8.a((int) r0)
            if (r0 == 0) goto L_0x01ad
            r0.setVisibility(r2)
        L_0x01ad:
            com.travel.train.model.trainticket.CJRTrainSearchResults r0 = r8.f26805h
            r8.c((com.travel.train.model.trainticket.CJRTrainSearchResults) r0)
            goto L_0x01d1
        L_0x01b3:
            int r0 = com.travel.train.R.id.lyt_bottom_tab
            android.view.View r0 = r8.a((int) r0)
            if (r0 == 0) goto L_0x01be
            r0.setVisibility(r4)
        L_0x01be:
            int r0 = com.travel.train.R.id.ac_trains_hidden_lyt
            android.view.View r0 = r8.a((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x01cb
            r0.setVisibility(r4)
        L_0x01cb:
            r8.c((int) r4)
            r8.j()
        L_0x01d1:
            android.content.Context r0 = r8.getContext()
            if (r0 == 0) goto L_0x01e3
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x01e3
            com.travel.train.j.w$a r3 = com.travel.train.j.w.f27609a
            com.paytm.b.a.a r3 = com.travel.train.j.w.a.a(r0)
        L_0x01e3:
            r8.o = r3
            com.paytm.b.a.a r0 = r8.o
            if (r0 == 0) goto L_0x01fe
            java.lang.String r3 = "train_color_info"
            boolean r0 = r0.b((java.lang.String) r3, (boolean) r2, (boolean) r2)
            if (r0 != r1) goto L_0x01fe
            int r0 = com.travel.train.R.id.color_code_info
            android.view.View r8 = r8.a((int) r0)
            if (r8 == 0) goto L_0x01fd
            r8.setVisibility(r4)
        L_0x01fd:
            return
        L_0x01fe:
            int r0 = com.travel.train.R.id.color_code_info
            android.view.View r8 = r8.a((int) r0)
            if (r8 == 0) goto L_0x0209
            r8.setVisibility(r2)
        L_0x0209:
            return
        L_0x020a:
            int r0 = com.travel.train.R.id.progressBar_trainlist
            android.view.View r0 = r8.a((int) r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            if (r0 == 0) goto L_0x0217
            r0.setVisibility(r4)
        L_0x0217:
            int r0 = com.travel.train.R.id.color_code_info
            android.view.View r0 = r8.a((int) r0)
            if (r0 == 0) goto L_0x0222
            r0.setVisibility(r4)
        L_0x0222:
            int r0 = com.travel.train.R.id.lyt_bottom_tab
            android.view.View r0 = r8.a((int) r0)
            if (r0 == 0) goto L_0x022d
            r0.setVisibility(r4)
        L_0x022d:
            int r0 = com.travel.train.R.id.ac_trains_hidden_lyt
            android.view.View r0 = r8.a((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x023a
            r0.setVisibility(r4)
        L_0x023a:
            r8.c((int) r4)
            r8.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ae.b(com.travel.train.fragment.ae):void");
    }

    public static final /* synthetic */ void c(ae aeVar) {
        Fragment c2 = aeVar.getChildFragmentManager().c(R.id.view_frame_train_search);
        if (c2 instanceof ad) {
            androidx.fragment.app.q a2 = aeVar.getChildFragmentManager().a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
            a2.a(c2);
            a2.c();
        }
    }

    public static final /* synthetic */ void d(ae aeVar) {
        aeVar.f26804g = new Dialog(aeVar.requireActivity(), 16973837);
        Dialog dialog = aeVar.f26804g;
        if (dialog == null) {
            kotlin.g.b.k.a();
        }
        dialog.requestWindowFeature(1);
        Dialog dialog2 = aeVar.f26804g;
        if (dialog2 == null) {
            kotlin.g.b.k.a();
        }
        dialog2.setContentView(R.layout.pre_t_train_animation_progress);
        Dialog dialog3 = aeVar.f26804g;
        if (dialog3 == null) {
            kotlin.g.b.k.a();
        }
        View findViewById = dialog3.findViewById(R.id.train_animation_container);
        if (findViewById != null) {
            new com.travel.train.widget.e(aeVar.getActivity(), (RelativeLayout) findViewById).a();
            Dialog dialog4 = aeVar.f26804g;
            if (dialog4 == null) {
                kotlin.g.b.k.a();
            }
            dialog4.show();
            Dialog dialog5 = aeVar.f26804g;
            if (dialog5 == null) {
                kotlin.g.b.k.a();
            }
            dialog5.setOnKeyListener(new k(aeVar));
            Dialog dialog6 = aeVar.f26804g;
            if (dialog6 == null) {
                kotlin.g.b.k.a();
            }
            View findViewById2 = dialog6.findViewById(R.id.cancel_action);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setOnClickListener(new l(aeVar));
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new kotlin.u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public static final /* synthetic */ void e(ae aeVar) {
        Dialog dialog = aeVar.f26804g;
        if (dialog != null) {
            if (dialog == null) {
                kotlin.g.b.k.a();
            }
            dialog.dismiss();
        }
    }

    public static final /* synthetic */ void a(ae aeVar, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            RecyclerView recyclerView = (RecyclerView) aeVar.a(R.id.quick_book_list);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) aeVar.a(R.id.quick_book_list);
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(aeVar.getActivity(), 0, false);
        RecyclerView recyclerView3 = (RecyclerView) aeVar.a(R.id.quick_book_list);
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(linearLayoutManager);
        }
        com.travel.train.b.l lVar = new com.travel.train.b.l(aeVar.getActivity(), arrayList, aeVar);
        RecyclerView recyclerView4 = (RecyclerView) aeVar.a(R.id.quick_book_list);
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(lVar);
        }
    }

    public static final /* synthetic */ void a(ae aeVar, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && aeVar.getActivity() != null) {
            FragmentActivity activity = aeVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                String string = aeVar.getResources().getString(R.string.train_maintenance_error_title);
                kotlin.g.b.k.a((Object) string, "resources.getString(R.st…_maintenance_error_title)");
                String string2 = aeVar.getResources().getString(R.string.train_maintenance_error_description);
                kotlin.g.b.k.a((Object) string2, "resources.getString(R.st…enance_error_description)");
                AlertDialog.Builder builder = new AlertDialog.Builder(aeVar.getActivity());
                builder.setTitle(string).setMessage(string2).setCancelable(false);
                builder.setPositiveButton(17039370, new m(aeVar));
                builder.show();
            }
        }
    }

    public static final /* synthetic */ void b(ae aeVar, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            com.paytm.utility.b.f((Context) aeVar.getActivity(), networkCustomError.getUrl());
        }
    }

    public static final /* synthetic */ void c(ae aeVar, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            String alertTitle = networkCustomError.getAlertTitle();
            String alertMessage = networkCustomError.getAlertMessage();
            if (!TextUtils.isEmpty(alertTitle)) {
                alertTitle = aeVar.getResources().getString(R.string.network_error_heading);
            }
            if (!TextUtils.isEmpty(alertMessage)) {
                alertMessage = aeVar.getResources().getString(R.string.network_error_message_train);
            }
            aeVar.showErrorDialog(alertTitle, alertMessage);
        }
    }

    public static final /* synthetic */ void a(ae aeVar, Pair pair) {
        String str;
        if (pair != null) {
            aeVar.showErrorDialog((String) pair.first, (String) pair.second);
            CJRTrainSearchInput cJRTrainSearchInput = aeVar.f26799b;
            String str2 = "";
            if (cJRTrainSearchInput != null) {
                if (cJRTrainSearchInput == null) {
                    kotlin.g.b.k.a();
                }
                str = cJRTrainSearchInput.getmSourceCityName();
            } else {
                str = str2;
            }
            CJRTrainSearchInput cJRTrainSearchInput2 = aeVar.f26799b;
            if (cJRTrainSearchInput2 != null) {
                if (cJRTrainSearchInput2 == null) {
                    kotlin.g.b.k.a();
                }
                str2 = cJRTrainSearchInput2.getmDestCityName();
            }
            com.travel.train.j.n.a("train_home_warning_no_direct_trains", str, str2, com.paytm.utility.b.n((Context) aeVar.getActivity()), (Context) aeVar.getActivity());
        }
    }

    public static final /* synthetic */ void a(ae aeVar, boolean z) {
        if (((RecyclerView) aeVar.a(R.id.quick_book_list)) != null) {
            RecyclerView recyclerView = (RecyclerView) aeVar.a(R.id.quick_book_list);
            kotlin.g.b.k.a((Object) recyclerView, "quick_book_list");
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = (RecyclerView) aeVar.a(R.id.quick_book_list);
                kotlin.g.b.k.a((Object) recyclerView2, "quick_book_list");
                if (recyclerView2.getAdapter() instanceof com.travel.train.b.l) {
                    boolean z2 = false;
                    ac acVar = aeVar.f26802e;
                    if (acVar != null) {
                        Boolean valueOf = acVar != null ? Boolean.valueOf(acVar.d()) : null;
                        if (valueOf == null) {
                            kotlin.g.b.k.a();
                        }
                        z2 = valueOf.booleanValue();
                    }
                    RecyclerView recyclerView3 = (RecyclerView) aeVar.a(R.id.quick_book_list);
                    kotlin.g.b.k.a((Object) recyclerView3, "quick_book_list");
                    RecyclerView.a adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        com.travel.train.b.l lVar = (com.travel.train.b.l) adapter;
                        if (lVar.a() != z2 && z) {
                            lVar.a(z2);
                            return;
                        }
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type com.travel.train.adapter.CJRQuickBookAdapter");
                }
            }
        }
    }

    public static final /* synthetic */ void f(ae aeVar) {
        if (aeVar.getActivity() != null) {
            FragmentActivity activity = aeVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (activity.isTaskRoot()) {
                kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                com.travel.train.b.b().a((Context) aeVar.getActivity(), "paytmmp://trainticketv2", new Bundle());
                return;
            }
        }
        aeVar.onBackPressed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final ae a(Bundle bundle) {
        ae aeVar = new ae();
        aeVar.setArguments(bundle);
        return aeVar;
    }
}
