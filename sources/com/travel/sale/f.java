package com.travel.sale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.paytm.utility.b.b;
import com.travel.R;
import com.travel.sale.CalendarView;
import com.travel.sale.LiveSaleView;
import com.travel.sale.ShareView;
import com.travel.sale.b;
import com.travel.sale.c;
import com.travel.sale.d;
import com.travel.sale.data.model.CampaignDetailsResponse;
import com.travel.sale.data.model.CampaignSubscriptionResponse;
import java.util.HashMap;
import kotlin.x;

public final class f extends e implements CalendarView.a, LiveSaleView.a, ShareView.a, b.C0480b {
    /* access modifiers changed from: private */
    public static final String ag = ag;
    public static final a n = new a((byte) 0);
    /* access modifiers changed from: private */
    public ImageView A;
    private ImageView B;
    private TextView C;
    private ImageView D;
    private TextView E;
    private ImageView F;
    private TextView G;
    private TextView H;
    private ViewGroup I;
    private ViewGroup J;
    private TextView K;
    private TextView L;
    private Button M;
    private ViewGroup N;
    private RelativeLayout O;
    private ImageView P;
    private TextView Q;
    /* access modifiers changed from: private */
    public NestedScrollView R;
    /* access modifiers changed from: private */
    public CalendarView S;
    private ShareView T;
    private LiveSaleView U;
    private RelativeLayout V;
    private RelativeLayout W;
    private RelativeLayout X;
    private TextView Y;
    private long Z = -1;
    /* access modifiers changed from: private */
    public boolean aa;
    /* access modifiers changed from: private */
    public boolean ab = true;
    /* access modifiers changed from: private */
    public CampaignSubscriptionResponse ac;
    /* access modifiers changed from: private */
    public boolean ad;
    private boolean ae;
    /* access modifiers changed from: private */
    public Fragment af;
    private HashMap ah;

    /* renamed from: g  reason: collision with root package name */
    String f25759g = "TravelSalesFragment";

    /* renamed from: h  reason: collision with root package name */
    TextView f25760h;

    /* renamed from: i  reason: collision with root package name */
    ViewGroup f25761i;
    ImageView j;
    TextView k;
    TextView l;
    com.travel.e m;
    private String o;
    private View p;
    private RelativeLayout q;
    private ImageView r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private FrameLayout x;
    private ContentLoadingProgressBar y;
    private ImageView z;

    /* renamed from: com.travel.sale.f$f  reason: collision with other inner class name */
    static final class C0483f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25764a;

        C0483f(f fVar) {
            this.f25764a = fVar;
        }

        public final void onClick(View view) {
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f25766a = new h();

        h() {
        }

        public final void onClick(View view) {
        }
    }

    public final void f() {
        HashMap hashMap = this.ah;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    static final class j<T> implements z<CampaignDetailsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25768a;

        j(f fVar) {
            this.f25768a = fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:121:0x01c3  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0124  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0171  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r7) {
            /*
                r6 = this;
                com.travel.sale.data.model.CampaignDetailsResponse r7 = (com.travel.sale.data.model.CampaignDetailsResponse) r7
                if (r7 == 0) goto L_0x01ce
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r7.getBody()
                r1 = 0
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.getStatus()
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                r2 = 1
                if (r0 == 0) goto L_0x0046
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r7.getBody()
                if (r0 == 0) goto L_0x002b
                java.lang.String r0 = r0.getStatus()
                if (r0 == 0) goto L_0x002b
                java.lang.String r3 = "failure"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x002c
            L_0x002b:
                r0 = r1
            L_0x002c:
                if (r0 != 0) goto L_0x0031
                kotlin.g.b.k.a()
            L_0x0031:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0046
                com.travel.sale.f r0 = r6.f25768a
                com.paytm.network.model.IJRPaytmDataModel r7 = (com.paytm.network.model.IJRPaytmDataModel) r7
                kotlin.o r7 = r0.a(-1, r7, (com.paytm.network.model.NetworkCustomError) null)
                com.travel.sale.f r0 = r6.f25768a
                r0.a((kotlin.o<java.lang.String, java.lang.String>) r7)
                goto L_0x01ce
            L_0x0046:
                com.travel.sale.f r0 = r6.f25768a
                r0.f25754c = r7
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r7.getBody()
                if (r0 == 0) goto L_0x0059
                boolean r0 = r0.isActive()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x005a
            L_0x0059:
                r0 = r1
            L_0x005a:
                if (r0 != 0) goto L_0x005f
                kotlin.g.b.k.a()
            L_0x005f:
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L_0x01c9
                com.travel.sale.f r0 = r6.f25768a
                java.lang.String r3 = "campaignDetails"
                kotlin.g.b.k.c(r7, r3)
                android.view.ViewGroup r3 = r0.f25761i
                r4 = 0
                if (r3 == 0) goto L_0x0074
                r3.setVisibility(r4)
            L_0x0074:
                android.widget.TextView r3 = r0.f25760h
                if (r3 == 0) goto L_0x0089
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r7.getBody()
                if (r5 == 0) goto L_0x0083
                java.lang.String r5 = r5.getCampaignName()
                goto L_0x0084
            L_0x0083:
                r5 = r1
            L_0x0084:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x0089:
                android.view.ViewGroup r3 = r0.f25761i
                if (r3 == 0) goto L_0x0090
                r3.setVisibility(r4)
            L_0x0090:
                com.travel.e r3 = r0.m
                if (r3 == 0) goto L_0x00a5
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r7.getBody()
                if (r4 == 0) goto L_0x00a0
                java.lang.String r4 = r4.getCampaignName()
                if (r4 != 0) goto L_0x00a2
            L_0x00a0:
                java.lang.String r4 = ""
            L_0x00a2:
                r3.a(r4)
            L_0x00a5:
                com.paytm.utility.b.b$a r3 = com.paytm.utility.b.b.f43744a
                android.content.Context r3 = r0.getContext()
                if (r3 != 0) goto L_0x00b0
                kotlin.g.b.k.a()
            L_0x00b0:
                java.lang.String r4 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                com.paytm.utility.b.b$a$a r3 = com.paytm.utility.b.b.a.a(r3)
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r7.getBody()
                if (r4 == 0) goto L_0x00c8
                boolean r4 = r4.isInterested()
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                goto L_0x00c9
            L_0x00c8:
                r4 = r1
            L_0x00c9:
                if (r4 == 0) goto L_0x00f1
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r7.getBody()
                if (r4 == 0) goto L_0x00da
                boolean r4 = r4.isInterested()
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                goto L_0x00db
            L_0x00da:
                r4 = r1
            L_0x00db:
                if (r4 != 0) goto L_0x00e0
                kotlin.g.b.k.a()
            L_0x00e0:
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x00f1
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r7.getBody()
                if (r4 == 0) goto L_0x00fc
                java.lang.String r4 = r4.getSuccessfullySubscribedIconUrl()
                goto L_0x00fd
            L_0x00f1:
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r7.getBody()
                if (r4 == 0) goto L_0x00fc
                java.lang.String r4 = r4.getDisabledCampaignIconUrl()
                goto L_0x00fd
            L_0x00fc:
                r4 = r1
            L_0x00fd:
                r3.f43753a = r4
                int r4 = com.travel.R.drawable.sales_placeholder_default
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                com.paytm.utility.b.b$a$a r3 = r3.a((java.lang.Object) r4)
                int r4 = com.travel.R.drawable.sales_placeholder_default
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                com.paytm.utility.b.b$a$a r3 = r3.b(r4)
                r3.m = r2
                android.widget.ImageView r2 = r0.j
                if (r2 != 0) goto L_0x011c
                kotlin.g.b.k.a()
            L_0x011c:
                r4 = 2
                com.paytm.utility.b.b.a.C0750a.a(r3, r2, r1, r4)
                android.widget.TextView r2 = r0.k
                if (r2 == 0) goto L_0x016d
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0133
                boolean r3 = r3.isInterested()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x0134
            L_0x0133:
                r3 = r1
            L_0x0134:
                if (r3 == 0) goto L_0x015c
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0145
                boolean r3 = r3.isInterested()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x0146
            L_0x0145:
                r3 = r1
            L_0x0146:
                if (r3 != 0) goto L_0x014b
                kotlin.g.b.k.a()
            L_0x014b:
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L_0x015c
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0167
                java.lang.String r3 = r3.getSuccessfullySubscribedHeading()
                goto L_0x0168
            L_0x015c:
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0167
                java.lang.String r3 = r3.getDisabledCampaignHeading()
                goto L_0x0168
            L_0x0167:
                r3 = r1
            L_0x0168:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
            L_0x016d:
                android.widget.TextView r2 = r0.l
                if (r2 == 0) goto L_0x01b8
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0180
                boolean r3 = r3.isInterested()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x0181
            L_0x0180:
                r3 = r1
            L_0x0181:
                if (r3 == 0) goto L_0x01a9
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x0192
                boolean r3 = r3.isInterested()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x0193
            L_0x0192:
                r3 = r1
            L_0x0193:
                if (r3 != 0) goto L_0x0198
                kotlin.g.b.k.a()
            L_0x0198:
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L_0x01a9
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x01b3
                java.lang.String r1 = r3.getSuccessfullySubscribedText()
                goto L_0x01b3
            L_0x01a9:
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r7.getBody()
                if (r3 == 0) goto L_0x01b3
                java.lang.String r1 = r3.getDisabledCampaignText()
            L_0x01b3:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2.setText(r1)
            L_0x01b8:
                r0.a((com.travel.sale.data.model.CampaignDetailsResponse) r7)
                com.travel.sale.f r7 = r6.f25768a
                android.widget.ImageView r7 = r7.A
                if (r7 == 0) goto L_0x01ce
                r0 = 8
                r7.setVisibility(r0)
                goto L_0x01ce
            L_0x01c9:
                com.travel.sale.f r7 = r6.f25768a
                com.travel.sale.f.g(r7)
            L_0x01ce:
                com.travel.sale.f r7 = r6.f25768a
                r7.g()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.j.onChanged(java.lang.Object):void");
        }
    }

    static final class k<T> implements z<com.travel.sale.data.model.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25769a;

        k(f fVar) {
            this.f25769a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.sale.data.model.a aVar = (com.travel.sale.data.model.a) obj;
            if (aVar != null) {
                this.f25769a.a(this.f25769a.a(Integer.valueOf(aVar.f25749a), aVar.f25750b, aVar.f25751c));
            }
            this.f25769a.g();
        }
    }

    static final class l<T> implements z<CampaignSubscriptionResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25770a;

        l(f fVar) {
            this.f25770a = fVar;
        }

        /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.String] */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r1 = r14.getBody();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x014b, code lost:
            if (r14 == null) goto L_0x015c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x015a, code lost:
            if (r14 == null) goto L_0x015c;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r14) {
            /*
                r13 = this;
                com.travel.sale.data.model.CampaignSubscriptionResponse r14 = (com.travel.sale.data.model.CampaignSubscriptionResponse) r14
                r0 = 0
                if (r14 == 0) goto L_0x0010
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r1 = r14.getBody()
                if (r1 == 0) goto L_0x0010
                java.lang.String r1 = r1.getStatus()
                goto L_0x0011
            L_0x0010:
                r1 = r0
            L_0x0011:
                r2 = 1
                if (r1 == 0) goto L_0x006a
                if (r14 == 0) goto L_0x002d
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r1 = r14.getBody()
                if (r1 == 0) goto L_0x002d
                java.lang.String r1 = r1.getStatus()
                if (r1 == 0) goto L_0x002d
                java.lang.String r3 = "failure"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x002e
            L_0x002d:
                r1 = r0
            L_0x002e:
                if (r1 != 0) goto L_0x0033
                kotlin.g.b.k.a()
            L_0x0033:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x006a
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.data.model.CampaignDetailsResponse r1 = r14.f25754c
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
                kotlin.o r14 = r14.a(-1, r1, (com.paytm.network.model.NetworkCustomError) null)
                com.travel.sale.f r1 = r13.f25770a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                android.content.Context r1 = (android.content.Context) r1
                if (r14 == 0) goto L_0x0054
                java.lang.Object r14 = r14.getFirst()
                r0 = r14
                java.lang.String r0 = (java.lang.String) r0
            L_0x0054:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                android.widget.Toast r14 = android.widget.Toast.makeText(r1, r0, r2)
                r14.show()
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.CalendarView r14 = r14.S
                if (r14 == 0) goto L_0x0236
                r14.f()
                goto L_0x0236
            L_0x006a:
                if (r14 == 0) goto L_0x0236
                com.travel.sale.f r1 = r13.f25770a
                r1.ac = r14
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.data.model.CampaignDetailsResponse r14 = r14.f25754c
                if (r14 == 0) goto L_0x0080
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r14.getBody()
                if (r14 == 0) goto L_0x0080
                r14.setInterested(r2)
            L_0x0080:
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.data.model.CampaignSubscriptionResponse r14 = r14.ac
                if (r14 == 0) goto L_0x0097
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r14 = r14.getBody()
                if (r14 == 0) goto L_0x0097
                long r3 = r14.getInterestedCustomerCount()
                java.lang.Long r14 = java.lang.Long.valueOf(r3)
                goto L_0x0098
            L_0x0097:
                r14 = r0
            L_0x0098:
                if (r14 == 0) goto L_0x00ca
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.data.model.CampaignDetailsResponse r14 = r14.f25754c
                if (r14 == 0) goto L_0x00ca
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r14.getBody()
                if (r14 == 0) goto L_0x00ca
                com.travel.sale.f r1 = r13.f25770a
                com.travel.sale.data.model.CampaignSubscriptionResponse r1 = r1.ac
                if (r1 == 0) goto L_0x00bd
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r1 = r1.getBody()
                if (r1 == 0) goto L_0x00bd
                long r3 = r1.getInterestedCustomerCount()
                java.lang.Long r1 = java.lang.Long.valueOf(r3)
                goto L_0x00be
            L_0x00bd:
                r1 = r0
            L_0x00be:
                if (r1 != 0) goto L_0x00c3
                kotlin.g.b.k.a()
            L_0x00c3:
                long r3 = r1.longValue()
                r14.setInterestedCustomerCount(r3)
            L_0x00ca:
                com.travel.sale.f r14 = r13.f25770a
                r14.j()
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.CalendarView r14 = r14.S
                r1 = 0
                if (r14 == 0) goto L_0x01d6
                boolean r3 = r14.c()
                if (r3 == 0) goto L_0x01d6
                com.travel.sale.data.model.CampaignDetailsResponse r3 = r14.f25670a
                com.travel.sale.d$a r4 = com.travel.sale.d.f25743a
                android.content.Context r4 = r14.getContext()
                if (r4 != 0) goto L_0x00eb
                kotlin.g.b.k.a()
            L_0x00eb:
                boolean r4 = com.travel.sale.d.a.a(r4)
                if (r4 == 0) goto L_0x01d6
                com.travel.sale.a r5 = new com.travel.sale.a
                r5.<init>()
                if (r3 == 0) goto L_0x01d6
                android.content.Context r4 = r14.getContext()
                if (r4 == 0) goto L_0x01d6
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r3.getBody()
                if (r4 == 0) goto L_0x0109
                java.lang.Long r4 = r4.getStartEpoch()
                goto L_0x010a
            L_0x0109:
                r4 = r0
            L_0x010a:
                if (r4 == 0) goto L_0x01d6
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r3.getBody()
                if (r4 == 0) goto L_0x0117
                java.lang.Long r4 = r4.getEndEpoch()
                goto L_0x0118
            L_0x0117:
                r4 = r0
            L_0x0118:
                if (r4 == 0) goto L_0x01d6
                android.content.Context r6 = r14.getContext()
                if (r6 != 0) goto L_0x0123
                kotlin.g.b.k.a()
            L_0x0123:
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x012e
                java.lang.String r14 = r14.getCalendarTitle()
                goto L_0x012f
            L_0x012e:
                r14 = r0
            L_0x012f:
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                if (r14 == 0) goto L_0x013c
                int r14 = r14.length()
                if (r14 != 0) goto L_0x013a
                goto L_0x013c
            L_0x013a:
                r14 = 0
                goto L_0x013d
            L_0x013c:
                r14 = 1
            L_0x013d:
                if (r14 != 0) goto L_0x014e
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x014a
                java.lang.String r14 = r14.getCalendarTitle()
                goto L_0x014b
            L_0x014a:
                r14 = r0
            L_0x014b:
                if (r14 != 0) goto L_0x015f
                goto L_0x015c
            L_0x014e:
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x0159
                java.lang.String r14 = r14.getCampaignName()
                goto L_0x015a
            L_0x0159:
                r14 = r0
            L_0x015a:
                if (r14 != 0) goto L_0x015f
            L_0x015c:
                kotlin.g.b.k.a()
            L_0x015f:
                r7 = r14
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x016b
                java.lang.String r14 = r14.getCalendarDescription()
                goto L_0x016c
            L_0x016b:
                r14 = r0
            L_0x016c:
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                if (r14 == 0) goto L_0x0179
                int r14 = r14.length()
                if (r14 != 0) goto L_0x0177
                goto L_0x0179
            L_0x0177:
                r14 = 0
                goto L_0x017a
            L_0x0179:
                r14 = 1
            L_0x017a:
                if (r14 != 0) goto L_0x018e
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x0187
                java.lang.String r14 = r14.getCalendarDescription()
                goto L_0x0188
            L_0x0187:
                r14 = r0
            L_0x0188:
                if (r14 != 0) goto L_0x01a8
                kotlin.g.b.k.a()
                goto L_0x01a8
            L_0x018e:
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                java.lang.String r4 = "paytmmp://travelcampaign?campaignId="
                r14.<init>(r4)
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r4 = r3.getBody()
                if (r4 == 0) goto L_0x01a0
                java.lang.String r4 = r4.getSalesCampaignId()
                goto L_0x01a1
            L_0x01a0:
                r4 = r0
            L_0x01a1:
                r14.append(r4)
                java.lang.String r14 = r14.toString()
            L_0x01a8:
                r8 = r14
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x01b4
                java.lang.Long r14 = r14.getStartEpoch()
                goto L_0x01b5
            L_0x01b4:
                r14 = r0
            L_0x01b5:
                if (r14 != 0) goto L_0x01ba
                kotlin.g.b.k.a()
            L_0x01ba:
                long r9 = r14.longValue()
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r14 = r3.getBody()
                if (r14 == 0) goto L_0x01c9
                java.lang.Long r14 = r14.getEndEpoch()
                goto L_0x01ca
            L_0x01c9:
                r14 = r0
            L_0x01ca:
                if (r14 != 0) goto L_0x01cf
                kotlin.g.b.k.a()
            L_0x01cf:
                long r11 = r14.longValue()
                r5.a(r6, r7, r8, r9, r11)
            L_0x01d6:
                com.travel.sale.f r14 = r13.f25770a
                boolean r14 = r14.ab
                if (r14 == 0) goto L_0x01e9
                com.travel.sale.f r14 = r13.f25770a
                r14.aa = r1
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.f.n(r14)
                goto L_0x01ee
            L_0x01e9:
                com.travel.sale.f r14 = r13.f25770a
                r14.aa = r2
            L_0x01ee:
                com.travel.sale.f r14 = r13.f25770a
                boolean r14 = r14.ad
                if (r14 == 0) goto L_0x0236
                com.travel.sale.f r14 = r13.f25770a
                com.travel.sale.CalendarView r14 = r14.S
                if (r14 == 0) goto L_0x0236
                boolean r1 = r14.o
                if (r1 == 0) goto L_0x0236
                com.travel.sale.data.model.CampaignDetailsResponse r1 = r14.f25670a
                if (r1 == 0) goto L_0x0214
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
                if (r1 == 0) goto L_0x0214
                boolean r0 = r1.isAddedToCalendar()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x0214:
                if (r0 != 0) goto L_0x0219
                kotlin.g.b.k.a()
            L_0x0219:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0236
                android.content.Context r0 = r14.getContext()
                android.content.Context r14 = r14.getContext()
                int r1 = com.travel.R.string.sale_event_added
                java.lang.String r14 = r14.getString(r1)
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                android.widget.Toast r14 = android.widget.Toast.makeText(r0, r14, r2)
                r14.show()
            L_0x0236:
                com.travel.sale.f r14 = r13.f25770a
                r14.g()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.l.onChanged(java.lang.Object):void");
        }
    }

    static final class m<T> implements z<com.travel.sale.data.model.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25771a;

        m(f fVar) {
            this.f25771a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.sale.data.model.a aVar = (com.travel.sale.data.model.a) obj;
            if (aVar != null) {
                Toast.makeText(this.f25771a.getActivity(), this.f25771a.a(Integer.valueOf(aVar.f25749a), aVar.f25750b, aVar.f25751c).getFirst(), 1).show();
            }
            CalendarView h2 = this.f25771a.S;
            if (h2 != null) {
                h2.f();
            }
            this.f25771a.g();
        }
    }

    static final class n<T> implements z<CampaignSubscriptionResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25772a;

        n(f fVar) {
            this.f25772a = fVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r1 = r6.getBody();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                com.travel.sale.data.model.CampaignSubscriptionResponse r6 = (com.travel.sale.data.model.CampaignSubscriptionResponse) r6
                r0 = 0
                if (r6 == 0) goto L_0x0010
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r1 = r6.getBody()
                if (r1 == 0) goto L_0x0010
                java.lang.String r1 = r1.getStatus()
                goto L_0x0011
            L_0x0010:
                r1 = r0
            L_0x0011:
                r2 = 1
                if (r1 == 0) goto L_0x005f
                if (r6 == 0) goto L_0x002d
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r1 = r6.getBody()
                if (r1 == 0) goto L_0x002d
                java.lang.String r1 = r1.getStatus()
                if (r1 == 0) goto L_0x002d
                java.lang.String r3 = "failure"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x002e
            L_0x002d:
                r1 = r0
            L_0x002e:
                if (r1 != 0) goto L_0x0033
                kotlin.g.b.k.a()
            L_0x0033:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x005f
                com.travel.sale.f r6 = r5.f25772a
                com.travel.sale.data.model.CampaignDetailsResponse r1 = r6.f25754c
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
                kotlin.o r6 = r6.a(-1, r1, (com.paytm.network.model.NetworkCustomError) null)
                com.travel.sale.f r1 = r5.f25772a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                android.content.Context r1 = (android.content.Context) r1
                if (r6 == 0) goto L_0x0054
                java.lang.Object r6 = r6.getFirst()
                r0 = r6
                java.lang.String r0 = (java.lang.String) r0
            L_0x0054:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                android.widget.Toast r6 = android.widget.Toast.makeText(r1, r0, r2)
                r6.show()
                goto L_0x00f7
            L_0x005f:
                if (r6 == 0) goto L_0x00f7
                com.travel.sale.f r1 = r5.f25772a
                com.travel.sale.data.model.CampaignDetailsResponse r1 = r1.f25754c
                if (r1 == 0) goto L_0x0070
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
                if (r1 == 0) goto L_0x0070
                r1.setInterested(r2)
            L_0x0070:
                com.travel.sale.f r1 = r5.f25772a
                java.lang.String r3 = "subscriptionResponse"
                kotlin.g.b.k.c(r6, r3)
                android.view.ViewGroup r3 = r1.f25761i
                if (r3 == 0) goto L_0x0080
                r4 = 0
                r3.setVisibility(r4)
            L_0x0080:
                com.paytm.utility.b.b$a r3 = com.paytm.utility.b.b.f43744a
                android.content.Context r3 = r1.getContext()
                if (r3 != 0) goto L_0x008b
                kotlin.g.b.k.a()
            L_0x008b:
                java.lang.String r4 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                com.paytm.utility.b.b$a$a r3 = com.paytm.utility.b.b.a.a(r3)
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r4 = r6.getBody()
                if (r4 == 0) goto L_0x009f
                java.lang.String r4 = r4.getSuccessfullySubscribedIconUrl()
                goto L_0x00a0
            L_0x009f:
                r4 = r0
            L_0x00a0:
                r3.f43753a = r4
                int r4 = com.travel.R.drawable.sales_placeholder_default
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                com.paytm.utility.b.b$a$a r3 = r3.a((java.lang.Object) r4)
                int r4 = com.travel.R.drawable.sales_placeholder_default
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                com.paytm.utility.b.b$a$a r3 = r3.b(r4)
                r3.m = r2
                android.widget.ImageView r2 = r1.j
                if (r2 != 0) goto L_0x00bf
                kotlin.g.b.k.a()
            L_0x00bf:
                r4 = 2
                com.paytm.utility.b.b.a.C0750a.a(r3, r2, r0, r4)
                android.widget.TextView r2 = r1.k
                if (r2 == 0) goto L_0x00d8
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r3 = r6.getBody()
                if (r3 == 0) goto L_0x00d2
                java.lang.String r3 = r3.getSuccessfullySubscribedHeading()
                goto L_0x00d3
            L_0x00d2:
                r3 = r0
            L_0x00d3:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
            L_0x00d8:
                android.widget.TextView r2 = r1.l
                if (r2 == 0) goto L_0x00eb
                com.travel.sale.data.model.CampaignSubscriptionResponse$CampaignSubscriptionData r6 = r6.getBody()
                if (r6 == 0) goto L_0x00e6
                java.lang.String r0 = r6.getSuccessfullySubscribedText()
            L_0x00e6:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r2.setText(r0)
            L_0x00eb:
                com.travel.sale.data.model.CampaignDetailsResponse r6 = r1.f25754c
                r1.a((com.travel.sale.data.model.CampaignDetailsResponse) r6)
                com.travel.sale.f r6 = r5.f25772a
                com.travel.sale.data.model.CampaignDetailsResponse r0 = r6.f25754c
                r6.a((com.travel.sale.data.model.CampaignDetailsResponse) r0)
            L_0x00f7:
                com.travel.sale.f r6 = r5.f25772a
                r6.g()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.n.onChanged(java.lang.Object):void");
        }
    }

    static final class o<T> implements z<com.travel.sale.data.model.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25773a;

        o(f fVar) {
            this.f25773a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.sale.data.model.a aVar = (com.travel.sale.data.model.a) obj;
            if (aVar != null) {
                Toast.makeText(this.f25773a.getActivity(), this.f25773a.a(Integer.valueOf(aVar.f25749a), aVar.f25750b, aVar.f25751c).getFirst(), 1).show();
            }
            this.f25773a.g();
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
        return layoutInflater.inflate(R.layout.travel_sales_fragment_view, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r0v107, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            r6.p = r7
            r0 = r6
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.String r1 = "context"
            kotlin.g.b.k.c(r0, r1)
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0)
            java.lang.Class<com.travel.sale.c> r1 = com.travel.sale.c.class
            androidx.lifecycle.ai r0 = r0.a(r1)
            com.travel.sale.c r0 = (com.travel.sale.c) r0
            r6.f25752a = r0
            android.os.Bundle r0 = r6.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x00bc
            android.os.Bundle r0 = r6.getArguments()
            if (r0 != 0) goto L_0x002e
            kotlin.g.b.k.a()
        L_0x002e:
            java.lang.String r2 = "campaignId"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0046
            android.os.Bundle r0 = r6.getArguments()
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0042
        L_0x0041:
            r0 = r1
        L_0x0042:
            r6.o = r0
            goto L_0x00bc
        L_0x0046:
            android.os.Bundle r0 = r6.getArguments()
            if (r0 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.lang.String r3 = "deeplink"
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x00bc
            android.os.Bundle r0 = r6.getArguments()
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r0.getString(r3)
            goto L_0x0063
        L_0x0062:
            r0 = r1
        L_0x0063:
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            android.net.Uri r0 = r0.build()
            java.lang.String r3 = r0.getQueryParameter(r2)
            r6.o = r3
            java.lang.String r3 = r6.o
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0086
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r3 = 0
            goto L_0x0087
        L_0x0086:
            r3 = 1
        L_0x0087:
            if (r3 == 0) goto L_0x00b0
            java.lang.String r3 = "url"
            java.lang.String r0 = r0.getQueryParameter(r3)
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x009b
            int r3 = r3.length()
            if (r3 != 0) goto L_0x009c
        L_0x009b:
            r4 = 1
        L_0x009c:
            if (r4 != 0) goto L_0x00b0
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            android.net.Uri r0 = r0.build()
            java.lang.String r0 = r0.getQueryParameter(r2)
            r6.o = r0
        L_0x00b0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sales fragment : campaignId :: "
            r0.<init>(r2)
            java.lang.String r2 = r6.o
            r0.append(r2)
        L_0x00bc:
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x00c9
            int r2 = com.travel.R.id.empty_view
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x00ca
        L_0x00c9:
            r0 = r1
        L_0x00ca:
            r6.I = r0
            android.view.ViewGroup r0 = r6.I
            if (r0 == 0) goto L_0x00d9
            int r2 = com.travel.R.id.empty_view
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x00da
        L_0x00d9:
            r0 = r1
        L_0x00da:
            r6.J = r0
            android.view.ViewGroup r0 = r6.I
            if (r0 == 0) goto L_0x00e9
            int r2 = com.travel.R.id.empty_screen_title
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x00ea
        L_0x00e9:
            r0 = r1
        L_0x00ea:
            r6.K = r0
            android.view.ViewGroup r0 = r6.I
            if (r0 == 0) goto L_0x00f9
            int r2 = com.travel.R.id.empty_screen_message
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x00fa
        L_0x00f9:
            r0 = r1
        L_0x00fa:
            r6.L = r0
            android.view.ViewGroup r0 = r6.I
            if (r0 == 0) goto L_0x0109
            int r2 = com.travel.R.id.empty_action_button
            android.view.View r0 = r0.findViewById(r2)
            android.widget.Button r0 = (android.widget.Button) r0
            goto L_0x010a
        L_0x0109:
            r0 = r1
        L_0x010a:
            r6.M = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0119
            int r2 = com.travel.R.id.empty_image_view
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x011a
        L_0x0119:
            r0 = r1
        L_0x011a:
            r6.N = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0129
            int r2 = com.travel.R.id.empty_image_view
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x012a
        L_0x0129:
            r0 = r1
        L_0x012a:
            r6.f25761i = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0139
            int r2 = com.travel.R.id.empty_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x013a
        L_0x0139:
            r0 = r1
        L_0x013a:
            r6.j = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0149
            int r2 = com.travel.R.id.empty_header
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x014a
        L_0x0149:
            r0 = r1
        L_0x014a:
            r6.k = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0159
            int r2 = com.travel.R.id.empty_subtitle
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x015a
        L_0x0159:
            r0 = r1
        L_0x015a:
            r6.l = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0169
            int r2 = com.travel.R.id.notify_btn
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x016a
        L_0x0169:
            r0 = r1
        L_0x016a:
            r6.O = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0179
            int r2 = com.travel.R.id.notify_icon
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x017a
        L_0x0179:
            r0 = r1
        L_0x017a:
            r6.P = r0
            android.view.ViewGroup r0 = r6.N
            if (r0 == 0) goto L_0x0189
            int r2 = com.travel.R.id.notify_btn_text
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x018a
        L_0x0189:
            r0 = r1
        L_0x018a:
            r6.Q = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0199
            int r2 = com.travel.R.id.info_scrollview
            android.view.View r0 = r0.findViewById(r2)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            goto L_0x019a
        L_0x0199:
            r0 = r1
        L_0x019a:
            r6.R = r0
            androidx.core.widget.NestedScrollView r0 = r6.R
            if (r0 == 0) goto L_0x01b0
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            if (r0 == 0) goto L_0x01b0
            com.travel.sale.f$d r2 = new com.travel.sale.f$d
            r2.<init>(r6)
            android.view.ViewTreeObserver$OnScrollChangedListener r2 = (android.view.ViewTreeObserver.OnScrollChangedListener) r2
            r0.addOnScrollChangedListener(r2)
        L_0x01b0:
            long r2 = java.lang.System.currentTimeMillis()
            r6.Z = r2
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x01c3
            int r2 = com.travel.R.id.camp_content_view
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x01c4
        L_0x01c3:
            r0 = r1
        L_0x01c4:
            r6.q = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x01d3
            int r2 = com.travel.R.id.camp_img
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x01d4
        L_0x01d3:
            r0 = r1
        L_0x01d4:
            r6.r = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x01e3
            int r2 = com.travel.R.id.play_img
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x01e4
        L_0x01e3:
            r0 = r1
        L_0x01e4:
            r6.s = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x01f3
            int r2 = com.travel.R.id.user_count_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x01f4
        L_0x01f3:
            r0 = r1
        L_0x01f4:
            r6.t = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0203
            int r2 = com.travel.R.id.start_date_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0204
        L_0x0203:
            r0 = r1
        L_0x0204:
            r6.u = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0213
            int r2 = com.travel.R.id.end_date_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0214
        L_0x0213:
            r0 = r1
        L_0x0214:
            r6.v = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0223
            int r2 = com.travel.R.id.register_btn
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x0224
        L_0x0223:
            r0 = r1
        L_0x0224:
            r6.w = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0233
            int r2 = com.travel.R.id.frag_container
            android.view.View r0 = r0.findViewById(r2)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0234
        L_0x0233:
            r0 = r1
        L_0x0234:
            r6.x = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0243
            int r2 = com.travel.R.id.progressbar
            android.view.View r0 = r0.findViewById(r2)
            androidx.core.widget.ContentLoadingProgressBar r0 = (androidx.core.widget.ContentLoadingProgressBar) r0
            goto L_0x0244
        L_0x0243:
            r0 = r1
        L_0x0244:
            r6.y = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0253
            int r2 = com.travel.R.id.registered_icon
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0254
        L_0x0253:
            r0 = r1
        L_0x0254:
            r6.B = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0263
            int r2 = com.travel.R.id.register_btn_text
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0264
        L_0x0263:
            r0 = r1
        L_0x0264:
            r6.C = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0273
            int r2 = com.travel.R.id.share_icon
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0274
        L_0x0273:
            r0 = r1
        L_0x0274:
            r6.A = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0283
            int r2 = com.travel.R.id.back_arrow
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0284
        L_0x0283:
            r0 = r1
        L_0x0284:
            r6.z = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0293
            int r2 = com.travel.R.id.header_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0294
        L_0x0293:
            r0 = r1
        L_0x0294:
            r6.f25760h = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02a3
            int r2 = com.travel.R.id.calender_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x02a4
        L_0x02a3:
            r0 = r1
        L_0x02a4:
            r6.F = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02b3
            int r2 = com.travel.R.id.start_title_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x02b4
        L_0x02b3:
            r0 = r1
        L_0x02b4:
            r6.G = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02c3
            int r2 = com.travel.R.id.end_title_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x02c4
        L_0x02c3:
            r0 = r1
        L_0x02c4:
            r6.H = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02d3
            int r2 = com.travel.R.id.user_count_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x02d4
        L_0x02d3:
            r0 = r1
        L_0x02d4:
            r6.D = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02e3
            int r2 = com.travel.R.id.title_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x02e4
        L_0x02e3:
            r0 = r1
        L_0x02e4:
            r6.E = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x02f3
            int r2 = com.travel.R.id.user_count_container
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x02f4
        L_0x02f3:
            r0 = r1
        L_0x02f4:
            r6.W = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0303
            int r2 = com.travel.R.id.camp_date_info
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x0304
        L_0x0303:
            r0 = r1
        L_0x0304:
            r6.X = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x0313
            int r2 = com.travel.R.id.registered_status
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0314
        L_0x0313:
            r0 = r1
        L_0x0314:
            r6.Y = r0
            android.widget.ImageView r0 = r6.z
            if (r0 == 0) goto L_0x0324
            com.travel.sale.f$e r2 = new com.travel.sale.f$e
            r2.<init>(r6)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
        L_0x0324:
            android.widget.ImageView r0 = r6.A
            if (r0 == 0) goto L_0x0332
            com.travel.sale.f$f r2 = new com.travel.sale.f$f
            r2.<init>(r6)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
        L_0x0332:
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x033f
            int r2 = com.travel.R.id.custom_calendar_view
            android.view.View r0 = r0.findViewById(r2)
            com.travel.sale.CalendarView r0 = (com.travel.sale.CalendarView) r0
            goto L_0x0340
        L_0x033f:
            r0 = r1
        L_0x0340:
            r6.S = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x034f
            int r2 = com.travel.R.id.share_button
            android.view.View r0 = r0.findViewById(r2)
            com.travel.sale.ShareView r0 = (com.travel.sale.ShareView) r0
            goto L_0x0350
        L_0x034f:
            r0 = r1
        L_0x0350:
            r6.T = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x035f
            int r2 = com.travel.R.id.live_sale_view
            android.view.View r0 = r0.findViewById(r2)
            com.travel.sale.LiveSaleView r0 = (com.travel.sale.LiveSaleView) r0
            goto L_0x0360
        L_0x035f:
            r0 = r1
        L_0x0360:
            r6.U = r0
            android.view.View r0 = r6.p
            if (r0 == 0) goto L_0x036f
            int r1 = com.travel.R.id.campaign_detail_container
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
        L_0x036f:
            r6.V = r1
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x0388
            androidx.lifecycle.y<com.travel.sale.data.model.CampaignDetailsResponse> r0 = r0.f25733a
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0388
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$j r2 = new com.travel.sale.f$j
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x0388:
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x039f
            androidx.lifecycle.y<com.travel.sale.data.model.a> r0 = r0.f25734b
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x039f
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$k r2 = new com.travel.sale.f$k
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x039f:
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x03b6
            androidx.lifecycle.y<com.travel.sale.data.model.CampaignSubscriptionResponse> r0 = r0.f25735c
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x03b6
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$l r2 = new com.travel.sale.f$l
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x03b6:
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x03cd
            androidx.lifecycle.y<com.travel.sale.data.model.a> r0 = r0.f25736d
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x03cd
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$m r2 = new com.travel.sale.f$m
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x03cd:
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x03e4
            androidx.lifecycle.y<com.travel.sale.data.model.CampaignSubscriptionResponse> r0 = r0.f25737e
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x03e4
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$n r2 = new com.travel.sale.f$n
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x03e4:
            com.travel.sale.c r0 = r6.f25752a
            if (r0 == 0) goto L_0x03fb
            androidx.lifecycle.y<com.travel.sale.data.model.a> r0 = r0.f25738f
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x03fb
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            com.travel.sale.f$o r2 = new com.travel.sale.f$o
            r2.<init>(r6)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x03fb:
            r6.k()
            super.onViewCreated(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (!(context instanceof com.travel.e)) {
            context = null;
        }
        this.m = (com.travel.e) context;
    }

    public static final class d implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25762a;

        d(f fVar) {
            this.f25762a = fVar;
        }

        public final void onScrollChanged() {
            View view;
            NestedScrollView a2 = this.f25762a.R;
            Integer num = null;
            if (a2 != null) {
                NestedScrollView a3 = this.f25762a.R;
                Integer valueOf = a3 != null ? Integer.valueOf(a3.getChildCount()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                view = a2.getChildAt(valueOf.intValue() - 1);
            } else {
                view = null;
            }
            if (view != null) {
                int bottom = view.getBottom();
                NestedScrollView a4 = this.f25762a.R;
                if (a4 == null) {
                    kotlin.g.b.k.a();
                }
                int height = a4.getHeight();
                NestedScrollView a5 = this.f25762a.R;
                if (a5 != null) {
                    num = Integer.valueOf(a5.getScrollY());
                }
                if (num == null) {
                    kotlin.g.b.k.a();
                }
                if (bottom - (height + num.intValue()) == 0 && this.f25762a.af != null && f.c(this.f25762a)) {
                    kotlin.g.b.k.a((Object) com.travel.d.a(), "TravelController.getInstance()");
                    com.travel.d.b().a(this.f25762a.af);
                }
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25763a;

        e(f fVar) {
            this.f25763a = fVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f25763a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25775a;

        q(f fVar) {
            this.f25775a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0 = r0.getBody();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
                r6 = this;
                com.travel.sale.f r7 = r6.f25775a
                com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
                r1 = 0
                if (r0 == 0) goto L_0x0012
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
                if (r0 == 0) goto L_0x0012
                java.lang.String r0 = r0.getVideoUrl()
                goto L_0x0013
            L_0x0012:
                r0 = r1
            L_0x0013:
                android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x005d }
                androidx.fragment.app.FragmentActivity r3 = r7.getActivity()     // Catch:{ Exception -> 0x005d }
                android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x005d }
                com.travel.d r4 = com.travel.d.a()     // Catch:{ Exception -> 0x005d }
                java.lang.String r5 = "TravelController.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x005d }
                com.travel.common.b r4 = com.travel.d.b()     // Catch:{ Exception -> 0x005d }
                java.lang.String r5 = "TravelController.getInstance().travelListener"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x005d }
                java.lang.Class r4 = r4.d()     // Catch:{ Exception -> 0x005d }
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x005d }
                if (r0 == 0) goto L_0x0049
                r3 = r0
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x005d }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x005d }
                if (r3 != 0) goto L_0x0049
                java.lang.String r1 = com.paytm.utility.b.e((java.lang.String) r0)     // Catch:{ Exception -> 0x005d }
                if (r1 != 0) goto L_0x0049
                java.lang.String r1 = com.paytm.utility.b.f((java.lang.String) r0)     // Catch:{ Exception -> 0x005d }
            L_0x0049:
                if (r1 == 0) goto L_0x0065
                r0 = r1
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x005d }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x005d }
                if (r0 != 0) goto L_0x0065
                java.lang.String r0 = com.paytm.utility.e.aA     // Catch:{ Exception -> 0x005d }
                r2.putExtra(r0, r1)     // Catch:{ Exception -> 0x005d }
                r7.startActivity(r2)     // Catch:{ Exception -> 0x005d }
                return
            L_0x005d:
                r7 = move-exception
                java.lang.String r7 = r7.getMessage()
                com.paytm.utility.q.c(r7)
            L_0x0065:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.q.onClick(android.view.View):void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r3 = this;
            android.widget.TextView r0 = r3.t
            if (r0 == 0) goto L_0x001d
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25754c
            if (r1 == 0) goto L_0x0017
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0017
            long r1 = r1.getInterestedCustomerCount()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.i():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.sale.data.model.CampaignDetailsResponse r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0012
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r5.getBody()
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.isActive()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            r2 = 0
            r3 = 8
            if (r1 == 0) goto L_0x00bf
            if (r5 == 0) goto L_0x0029
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r5.getBody()
            if (r1 == 0) goto L_0x0029
            boolean r1 = r1.isActive()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x002a
        L_0x0029:
            r1 = r0
        L_0x002a:
            if (r1 != 0) goto L_0x002f
            kotlin.g.b.k.a()
        L_0x002f:
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00bf
            if (r5 == 0) goto L_0x0046
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r5.getBody()
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.isInterested()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0047
        L_0x0046:
            r1 = r0
        L_0x0047:
            if (r1 == 0) goto L_0x006e
            if (r5 == 0) goto L_0x005a
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x005a
            boolean r5 = r5.isInterested()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x005b
        L_0x005a:
            r5 = r0
        L_0x005b:
            if (r5 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x006e
            android.widget.RelativeLayout r5 = r4.w
            if (r5 == 0) goto L_0x006d
            r5.setVisibility(r3)
        L_0x006d:
            return
        L_0x006e:
            android.widget.RelativeLayout r5 = r4.w
            if (r5 == 0) goto L_0x0075
            r5.setVisibility(r2)
        L_0x0075:
            android.widget.ImageView r5 = r4.B
            if (r5 == 0) goto L_0x007c
            r5.setVisibility(r3)
        L_0x007c:
            android.widget.TextView r5 = r4.C
            if (r5 == 0) goto L_0x008d
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.color.white
            int r1 = r1.getColor(r2)
            r5.setTextColor(r1)
        L_0x008d:
            android.widget.TextView r5 = r4.C
            if (r5 == 0) goto L_0x00a0
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.string.sales_register
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
        L_0x00a0:
            android.widget.RelativeLayout r5 = r4.w
            if (r5 == 0) goto L_0x00a9
            int r1 = com.travel.R.drawable.travel_button_rounded_corner
            r5.setBackgroundResource(r1)
        L_0x00a9:
            android.widget.RelativeLayout r5 = r4.w
            if (r5 == 0) goto L_0x00b0
            r5.setOnClickListener(r0)
        L_0x00b0:
            android.widget.RelativeLayout r5 = r4.w
            if (r5 == 0) goto L_0x00be
            com.travel.sale.f$p r0 = new com.travel.sale.f$p
            r0.<init>(r4)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
        L_0x00be:
            return
        L_0x00bf:
            if (r5 == 0) goto L_0x00d0
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r5.getBody()
            if (r1 == 0) goto L_0x00d0
            boolean r1 = r1.isInterested()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x00d1
        L_0x00d0:
            r1 = r0
        L_0x00d1:
            if (r1 == 0) goto L_0x0137
            if (r5 == 0) goto L_0x00e4
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x00e4
            boolean r5 = r5.isInterested()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x00e5
        L_0x00e4:
            r5 = r0
        L_0x00e5:
            if (r5 != 0) goto L_0x00ea
            kotlin.g.b.k.a()
        L_0x00ea:
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0137
            android.widget.ImageView r5 = r4.P
            if (r5 == 0) goto L_0x00f7
            r5.setVisibility(r2)
        L_0x00f7:
            android.widget.TextView r5 = r4.Q
            if (r5 == 0) goto L_0x0108
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.color.color_222222
            int r1 = r1.getColor(r2)
            r5.setTextColor(r1)
        L_0x0108:
            android.widget.TextView r5 = r4.Q
            if (r5 == 0) goto L_0x011b
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.string.sales_subscribed
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
        L_0x011b:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x0124
            int r1 = com.travel.R.drawable.sales_empty_rounded_corner
            r5.setBackgroundResource(r1)
        L_0x0124:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x012b
            r5.setOnClickListener(r0)
        L_0x012b:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x0136
            com.travel.sale.f$h r0 = com.travel.sale.f.h.f25766a
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
        L_0x0136:
            return
        L_0x0137:
            android.widget.ImageView r5 = r4.P
            if (r5 == 0) goto L_0x013e
            r5.setVisibility(r3)
        L_0x013e:
            android.widget.TextView r5 = r4.Q
            if (r5 == 0) goto L_0x014f
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.color.white
            int r1 = r1.getColor(r2)
            r5.setTextColor(r1)
        L_0x014f:
            android.widget.TextView r5 = r4.Q
            if (r5 == 0) goto L_0x0162
            android.content.res.Resources r1 = r4.getResources()
            int r2 = com.travel.R.string.sales_notify_me
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
        L_0x0162:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x016b
            int r1 = com.travel.R.drawable.travel_button_rounded_corner
            r5.setBackgroundResource(r1)
        L_0x016b:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x0172
            r5.setOnClickListener(r0)
        L_0x0172:
            android.widget.RelativeLayout r5 = r4.O
            if (r5 == 0) goto L_0x0180
            com.travel.sale.f$i r0 = new com.travel.sale.f$i
            r0.<init>(r4)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.a(com.travel.sale.data.model.CampaignDetailsResponse):void");
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25774a;

        p(f fVar) {
            this.f25774a = fVar;
        }

        public final void onClick(View view) {
            this.f25774a.l();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25767a;

        i(f fVar) {
            this.f25767a = fVar;
        }

        public final void onClick(View view) {
            this.f25767a.n();
        }
    }

    private final void a(ImageView imageView, String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0) && imageView != null) {
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = str;
            b.a.C0750a b2 = a2.a((Object) Integer.valueOf(R.drawable.sales_placeholder_default)).b(Integer.valueOf(R.drawable.sales_placeholder_default));
            b2.m = true;
            b.a.C0750a.a(b2, imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    /* access modifiers changed from: private */
    public final void k() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            s();
            q();
            o();
            return;
        }
        r();
    }

    /* access modifiers changed from: private */
    public final void l() {
        CampaignDetailsResponse.CampaignDetails body;
        CalendarView calendarView = this.S;
        Boolean bool = null;
        if (calendarView != null) {
            CampaignDetailsResponse campaignDetailsResponse = calendarView.f25670a;
            if (!(campaignDetailsResponse == null || (body = campaignDetailsResponse.getBody()) == null)) {
                bool = Boolean.valueOf(body.isDisplayAddToCalendar());
            }
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            bool = Boolean.valueOf(bool.booleanValue() && calendarView.c());
        }
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue()) {
            d.a aVar = d.f25743a;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            if (!d.a.a(context)) {
                Context context2 = getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context2, "context!!");
                a(context2);
                return;
            }
        }
        m();
    }

    private void a(Context context) {
        kotlin.g.b.k.c(context, "context");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        d.a aVar = d.f25743a;
        String[] a2 = d.f25744b;
        d.a aVar2 = d.f25743a;
        androidx.core.app.a.a(activity, a2, d.f25745c);
    }

    private final void m() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            s();
            q();
            p();
            return;
        }
        r();
    }

    /* access modifiers changed from: private */
    public final void n() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            s();
            q();
            if (com.travel.utils.e.a(getContext())) {
                c cVar = this.f25752a;
                if (cVar != null) {
                    Context context = getContext();
                    String valueOf = String.valueOf(this.o);
                    kotlin.g.b.k.c(valueOf, ag);
                    if (context != null && cVar.f25739g != null) {
                        com.travel.sale.data.a.a(context, (com.paytm.network.listener.b) new c.b(cVar), valueOf, false);
                        return;
                    }
                    return;
                }
                return;
            }
            g();
            a(this.f25757f);
            return;
        }
        r();
    }

    private final void p() {
        boolean z2;
        if (com.travel.utils.e.a(getContext())) {
            c cVar = this.f25752a;
            if (cVar != null) {
                Context context = getContext();
                String valueOf = String.valueOf(this.o);
                CalendarView calendarView = this.S;
                if (calendarView != null) {
                    if (calendarView == null) {
                        kotlin.g.b.k.a();
                    }
                    if (calendarView.c()) {
                        z2 = true;
                        cVar.a(context, valueOf, z2);
                        return;
                    }
                }
                z2 = false;
                cVar.a(context, valueOf, z2);
                return;
            }
            return;
        }
        g();
        a(this.f25755d);
    }

    private void q() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.y;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.setVisibility(0);
        }
    }

    public final void g() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.y;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    private void r() {
        String string = getString(R.string.cant_connect);
        kotlin.g.b.k.a((Object) string, "getString(R.string.cant_connect)");
        String string2 = getString(R.string.check_your_network);
        kotlin.g.b.k.a((Object) string2, "getString(R.string.check_your_network)");
        a(string, string2);
    }

    public final void a(kotlin.o<String, String> oVar) {
        kotlin.g.b.k.c(oVar, "errorDetails");
        a(oVar.getFirst(), oVar.getSecond());
    }

    private void a(String str, String str2) {
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(str2, "message");
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        Button button = this.M;
        if (button != null) {
            button.setOnClickListener(new g(this));
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f25765a;

        g(f fVar) {
            this.f25765a = fVar;
        }

        public final void onClick(View view) {
            this.f25765a.k();
        }
    }

    private void s() {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == this.f25755d) {
            l();
        } else if (i2 == this.f25757f) {
            n();
        } else if (i2 != this.f25756e && i2 == this.f25753b) {
            k();
        }
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(0);
            this.this$0 = fVar;
        }

        public final void invoke() {
            CalendarView h2 = this.this$0.S;
            if (h2 != null) {
                h2.g();
            }
            this.this$0.ab = true;
            if (this.this$0.aa) {
                this.this$0.aa = false;
                f.n(this.this$0);
            }
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.this$0 = fVar;
        }

        public final void invoke() {
            CalendarView h2 = this.this$0.S;
            if (h2 != null) {
                h2.g();
            }
            this.this$0.ab = true;
            if (this.this$0.aa) {
                this.this$0.aa = false;
                f.n(this.this$0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009d, code lost:
        r5 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRequestPermissionsResult(int r5, java.lang.String[] r6, int[] r7) {
        /*
            r4 = this;
            java.lang.String r0 = "permissions"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "grantResults"
            kotlin.g.b.k.c(r7, r0)
            super.onRequestPermissionsResult(r5, r6, r7)
            com.travel.sale.d$a r0 = com.travel.sale.d.f25743a
            int r0 = com.travel.sale.d.f25745c
            if (r5 != r0) goto L_0x0098
            com.travel.sale.d$a r5 = com.travel.sale.d.f25743a
            boolean r5 = com.travel.sale.d.a.a((java.lang.String[]) r6, (int[]) r7)
            if (r5 != 0) goto L_0x0098
            boolean r5 = r4.b()
            if (r5 == 0) goto L_0x0089
            com.travel.sale.CalendarView r5 = r4.S
            if (r5 == 0) goto L_0x002a
            r5.g()
        L_0x002a:
            com.travel.sale.d$a r5 = com.travel.sale.d.f25743a
            android.content.Context r5 = r4.getContext()
            if (r5 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            java.lang.String r6 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            com.travel.sale.f$b r6 = new com.travel.sale.f$b
            r6.<init>(r4)
            kotlin.g.a.a r6 = (kotlin.g.a.a) r6
            com.travel.sale.f$c r7 = new com.travel.sale.f$c
            r7.<init>(r4)
            kotlin.g.a.a r7 = (kotlin.g.a.a) r7
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "positiveFun"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "negativeFun"
            kotlin.g.b.k.c(r7, r0)
            androidx.appcompat.app.c$a r0 = new androidx.appcompat.app.c$a
            r0.<init>(r5)
            java.lang.String r1 = "Go to settings and allow access to calendar & we will add this event to your calendar."
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.b((java.lang.CharSequence) r1)
            r1 = 0
            r0.a((boolean) r1)
            java.lang.String r2 = "Allow"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.travel.sale.d$a$a r3 = new com.travel.sale.d$a$a
            r3.<init>(r6, r5)
            android.content.DialogInterface$OnClickListener r3 = (android.content.DialogInterface.OnClickListener) r3
            r0.a((java.lang.CharSequence) r2, (android.content.DialogInterface.OnClickListener) r3)
            java.lang.String r5 = "Cancel"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.travel.sale.d$a$b r6 = new com.travel.sale.d$a$b
            r6.<init>(r7)
            android.content.DialogInterface$OnClickListener r6 = (android.content.DialogInterface.OnClickListener) r6
            r0.b((java.lang.CharSequence) r5, (android.content.DialogInterface.OnClickListener) r6)
            r0.b()
            r4.ab = r1
            goto L_0x0098
        L_0x0089:
            com.travel.sale.d$a r5 = com.travel.sale.d.f25743a
            boolean r5 = com.travel.sale.d.a.a((java.lang.String[]) r6, (int[]) r7)
            if (r5 != 0) goto L_0x0098
            com.travel.sale.CalendarView r5 = r4.S
            if (r5 == 0) goto L_0x0098
            r5.g()
        L_0x0098:
            com.travel.sale.data.model.CampaignDetailsResponse r5 = r4.f25754c
            r6 = 0
            if (r5 == 0) goto L_0x00ac
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x00ac
            boolean r5 = r5.isInterested()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x00ad
        L_0x00ac:
            r5 = r6
        L_0x00ad:
            if (r5 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00cf
            com.travel.sale.CalendarView r5 = r4.S
            if (r5 == 0) goto L_0x00c4
            boolean r5 = r5.c()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
        L_0x00c4:
            if (r6 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L_0x00d2
        L_0x00cf:
            r4.m()
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public final void a() {
        this.ad = true;
        this.ab = false;
        this.ae = true;
        l();
    }

    public final boolean b() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        d.a aVar = d.f25743a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        return d.a.a((Activity) activity, "android.permission.WRITE_CALENDAR");
    }

    public final void d() {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        a(context);
    }

    public final boolean c() {
        d.a aVar = d.f25743a;
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        return d.a.a(context);
    }

    public final void e() {
        k();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r10 = this;
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r10.f25754c
            r10.a((com.travel.sale.data.model.CampaignDetailsResponse) r0)
            r10.i()
            com.travel.sale.CalendarView r0 = r10.S
            r1 = 0
            if (r0 == 0) goto L_0x0048
            int r2 = r0.l
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.setCalendarViewType(r2)
            r0.setTypeDepedentVibility()
            r0.a()
            boolean r2 = r0.c()
            if (r2 == 0) goto L_0x0045
            r0.d()
            int r2 = r0.m
            int r3 = r0.k
            if (r2 != r3) goto L_0x0038
            android.widget.LinearLayout r0 = r0.f25678i
            if (r0 != 0) goto L_0x0034
            java.lang.String r2 = "addCalenderContainer"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0034:
            r0.setOnClickListener(r1)
            goto L_0x0048
        L_0x0038:
            android.widget.RelativeLayout r0 = r0.f25672c
            if (r0 != 0) goto L_0x0041
            java.lang.String r2 = "customCheckbox"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0041:
            r0.setOnClickListener(r1)
            goto L_0x0048
        L_0x0045:
            r0.e()
        L_0x0048:
            com.travel.sale.ShareView r0 = r10.T
            if (r0 == 0) goto L_0x0058
            int r2 = r0.f25703a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.setShareViewType(r2)
            r0.a()
        L_0x0058:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r10.f25754c
            if (r0 == 0) goto L_0x006b
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x006b
            boolean r0 = r0.isInterested()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x006c
        L_0x006b:
            r0 = r1
        L_0x006c:
            if (r0 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L_0x02e5
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r10.f25754c
            if (r0 == 0) goto L_0x008b
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x008b
            boolean r0 = r0.isAddedToCalendar()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x008c
        L_0x008b:
            r0 = r1
        L_0x008c:
            if (r0 != 0) goto L_0x0091
            kotlin.g.b.k.a()
        L_0x0091:
            boolean r0 = r0.booleanValue()
            r3 = 3
            if (r0 == 0) goto L_0x0225
            boolean r0 = r10.ae
            if (r0 == 0) goto L_0x015f
            com.travel.sale.ShareView r0 = r10.T
            r3 = 1
            float[] r4 = new float[r3]
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            com.travel.sale.CalendarView r6 = r10.S
            if (r6 == 0) goto L_0x00b1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x00b2
        L_0x00b1:
            r6 = r1
        L_0x00b2:
            if (r6 != 0) goto L_0x00b7
            kotlin.g.b.k.a()
        L_0x00b7:
            float r6 = r6.floatValue()
            android.content.res.Resources r7 = r10.getResources()
            int r8 = com.travel.R.dimen.dimen_8dp
            float r7 = r7.getDimension(r8)
            float r6 = r6 + r7
            float r5 = r5 * r6
            r4[r2] = r5
            java.lang.String r5 = "translationY"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r5, r4)
            r6 = 800(0x320, double:3.953E-321)
            r0.setDuration(r6)
            r0.start()
            com.travel.sale.CalendarView r0 = r10.S
            float[] r3 = new float[r3]
            com.travel.sale.ShareView r4 = r10.T
            if (r4 == 0) goto L_0x00ea
            int r4 = r4.getHeight()
            float r4 = (float) r4
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            goto L_0x00eb
        L_0x00ea:
            r4 = r1
        L_0x00eb:
            if (r4 != 0) goto L_0x00f0
            kotlin.g.b.k.a()
        L_0x00f0:
            float r4 = r4.floatValue()
            android.content.res.Resources r8 = r10.getResources()
            int r9 = com.travel.R.dimen.dimen_5dp
            float r8 = r8.getDimension(r9)
            float r4 = r4 + r8
            r3[r2] = r4
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r5, r3)
            r0.setDuration(r6)
            r0.start()
            com.travel.sale.ShareView r0 = r10.T
            if (r0 == 0) goto L_0x0114
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0115
        L_0x0114:
            r0 = r1
        L_0x0115:
            boolean r3 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r3 != 0) goto L_0x011a
            r0 = r1
        L_0x011a:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            com.travel.sale.ShareView r3 = r10.T
            if (r3 == 0) goto L_0x0125
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r3.setLayoutParams(r0)
        L_0x0125:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x012e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x012f
        L_0x012e:
            r0 = r1
        L_0x012f:
            boolean r3 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r3 != 0) goto L_0x0134
            r0 = r1
        L_0x0134:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x0145
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.travel.R.dimen.dimen_5dp
            float r1 = r1.getDimension(r3)
            int r1 = (int) r1
            r0.topMargin = r1
        L_0x0145:
            if (r0 == 0) goto L_0x0154
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.travel.R.dimen.dimen_10dp
            float r1 = r1.getDimension(r3)
            int r1 = (int) r1
            r0.bottomMargin = r1
        L_0x0154:
            com.travel.sale.CalendarView r1 = r10.S
            if (r1 == 0) goto L_0x02e5
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r1.setLayoutParams(r0)
            goto L_0x02e5
        L_0x015f:
            com.travel.sale.ShareView r0 = r10.T
            if (r0 == 0) goto L_0x0168
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0169
        L_0x0168:
            r0 = r1
        L_0x0169:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x016e
            r0 = r1
        L_0x016e:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x0180
            android.widget.TextView r4 = r10.Y
            if (r4 != 0) goto L_0x0179
            kotlin.g.b.k.a()
        L_0x0179:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x0180:
            if (r0 == 0) goto L_0x0184
            r0.topMargin = r2
        L_0x0184:
            com.travel.sale.ShareView r4 = r10.T
            if (r4 == 0) goto L_0x018d
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x018d:
            android.widget.RelativeLayout r0 = r10.w
            if (r0 == 0) goto L_0x0196
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0197
        L_0x0196:
            r0 = r1
        L_0x0197:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x019c
            r0 = r1
        L_0x019c:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x01ae
            android.widget.RelativeLayout r4 = r10.X
            if (r4 != 0) goto L_0x01a7
            kotlin.g.b.k.a()
        L_0x01a7:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x01ae:
            android.widget.RelativeLayout r4 = r10.w
            if (r4 == 0) goto L_0x01b7
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x01b7:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x01c0
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x01c1
        L_0x01c0:
            r0 = r1
        L_0x01c1:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x01c6
            r0 = r1
        L_0x01c6:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x01d8
            com.travel.sale.ShareView r4 = r10.T
            if (r4 != 0) goto L_0x01d1
            kotlin.g.b.k.a()
        L_0x01d1:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x01d8:
            com.travel.sale.CalendarView r4 = r10.S
            if (r4 == 0) goto L_0x01e1
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x01e1:
            android.widget.RelativeLayout r0 = r10.W
            if (r0 == 0) goto L_0x01ea
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x01eb
        L_0x01ea:
            r0 = r1
        L_0x01eb:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x01f0
            r0 = r1
        L_0x01f0:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x0202
            com.travel.sale.CalendarView r4 = r10.S
            if (r4 != 0) goto L_0x01fb
            kotlin.g.b.k.a()
        L_0x01fb:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x0202:
            android.widget.RelativeLayout r3 = r10.W
            if (r3 == 0) goto L_0x020b
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r3.setLayoutParams(r0)
        L_0x020b:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x021c
            if (r0 == 0) goto L_0x0219
            int r1 = r0.getCALENDAR_VIEW_TYPE_CUSTOM()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0219:
            r0.setCalendarViewType(r1)
        L_0x021c:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x02e5
            r0.setTypeDepedentVibility()
            goto L_0x02e5
        L_0x0225:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x022e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x022f
        L_0x022e:
            r0 = r1
        L_0x022f:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x0234
            r0 = r1
        L_0x0234:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x0246
            android.widget.TextView r4 = r10.Y
            if (r4 != 0) goto L_0x023f
            kotlin.g.b.k.a()
        L_0x023f:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x0246:
            com.travel.sale.CalendarView r4 = r10.S
            if (r4 == 0) goto L_0x024f
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x024f:
            com.travel.sale.ShareView r0 = r10.T
            if (r0 == 0) goto L_0x0258
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0259
        L_0x0258:
            r0 = r1
        L_0x0259:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x025e
            r0 = r1
        L_0x025e:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x0270
            com.travel.sale.CalendarView r4 = r10.S
            if (r4 != 0) goto L_0x0269
            kotlin.g.b.k.a()
        L_0x0269:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x0270:
            com.travel.sale.ShareView r4 = r10.T
            if (r4 == 0) goto L_0x0279
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x0279:
            android.widget.RelativeLayout r0 = r10.w
            if (r0 == 0) goto L_0x0282
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0283
        L_0x0282:
            r0 = r1
        L_0x0283:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x0288
            r0 = r1
        L_0x0288:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x029a
            android.widget.RelativeLayout r4 = r10.X
            if (r4 != 0) goto L_0x0293
            kotlin.g.b.k.a()
        L_0x0293:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x029a:
            android.widget.RelativeLayout r4 = r10.w
            if (r4 == 0) goto L_0x02a3
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r4.setLayoutParams(r0)
        L_0x02a3:
            android.widget.RelativeLayout r0 = r10.W
            if (r0 == 0) goto L_0x02ac
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x02ad
        L_0x02ac:
            r0 = r1
        L_0x02ad:
            boolean r4 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 != 0) goto L_0x02b2
            r0 = r1
        L_0x02b2:
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            if (r0 == 0) goto L_0x02c4
            com.travel.sale.ShareView r4 = r10.T
            if (r4 != 0) goto L_0x02bd
            kotlin.g.b.k.a()
        L_0x02bd:
            int r4 = r4.getId()
            r0.addRule(r3, r4)
        L_0x02c4:
            android.widget.RelativeLayout r3 = r10.W
            if (r3 == 0) goto L_0x02cd
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r3.setLayoutParams(r0)
        L_0x02cd:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x02de
            if (r0 == 0) goto L_0x02db
            int r1 = r0.getCALENDAR_VIEW_TYPE_CUSTOM()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x02db:
            r0.setCalendarViewType(r1)
        L_0x02de:
            com.travel.sale.CalendarView r0 = r10.S
            if (r0 == 0) goto L_0x02e5
            r0.setTypeDepedentVibility()
        L_0x02e5:
            android.widget.TextView r0 = r10.Y
            if (r0 == 0) goto L_0x02ec
            r0.setVisibility(r2)
        L_0x02ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.j():void");
    }

    private final void o() {
        c cVar = this.f25752a;
        if (cVar != null) {
            cVar.a(getContext(), String.valueOf(this.o));
        }
    }

    public static final /* synthetic */ boolean c(f fVar) {
        if (System.currentTimeMillis() - fVar.Z <= 1000) {
            return false;
        }
        fVar.Z = System.currentTimeMillis();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r5 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void g(com.travel.sale.f r7) {
        /*
            androidx.core.widget.NestedScrollView r0 = r7.R
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r0.setVisibility(r1)
        L_0x0008:
            r7.i()
            android.widget.TextView r0 = r7.u
            java.lang.String r2 = "line.separator"
            r3 = 0
            if (r0 == 0) goto L_0x004d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.travel.sale.data.model.CampaignDetailsResponse r5 = r7.f25754c
            if (r5 == 0) goto L_0x0026
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x0026
            java.lang.String r5 = r5.getStartDateOn()
            goto L_0x0027
        L_0x0026:
            r5 = r3
        L_0x0027:
            r4.append(r5)
            java.lang.String r5 = java.lang.System.getProperty(r2)
            r4.append(r5)
            com.travel.sale.data.model.CampaignDetailsResponse r5 = r7.f25754c
            if (r5 == 0) goto L_0x0040
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x0040
            java.lang.String r5 = r5.getStartTimeOn()
            goto L_0x0041
        L_0x0040:
            r5 = r3
        L_0x0041:
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x004d:
            android.widget.TextView r0 = r7.v
            if (r0 == 0) goto L_0x008c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.travel.sale.data.model.CampaignDetailsResponse r5 = r7.f25754c
            if (r5 == 0) goto L_0x0065
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r5 = r5.getBody()
            if (r5 == 0) goto L_0x0065
            java.lang.String r5 = r5.getEndDateOn()
            goto L_0x0066
        L_0x0065:
            r5 = r3
        L_0x0066:
            r4.append(r5)
            java.lang.String r2 = java.lang.System.getProperty(r2)
            r4.append(r2)
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x007f
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x007f
            java.lang.String r2 = r2.getEndTimeOn()
            goto L_0x0080
        L_0x007f:
            r2 = r3
        L_0x0080:
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x008c:
            android.widget.TextView r0 = r7.f25760h
            if (r0 == 0) goto L_0x00a5
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x009f
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x009f
            java.lang.String r2 = r2.getCampaignName()
            goto L_0x00a0
        L_0x009f:
            r2 = r3
        L_0x00a0:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x00a5:
            com.travel.e r0 = r7.m
            if (r0 == 0) goto L_0x00be
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x00b9
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = r2.getCampaignName()
            if (r2 != 0) goto L_0x00bb
        L_0x00b9:
            java.lang.String r2 = ""
        L_0x00bb:
            r0.a(r2)
        L_0x00be:
            android.view.View r0 = r7.p
            if (r0 == 0) goto L_0x00cb
            int r2 = com.travel.R.id.calender_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x00cc
        L_0x00cb:
            r0 = r3
        L_0x00cc:
            r7.F = r0
            android.widget.TextView r0 = r7.G
            if (r0 == 0) goto L_0x00e7
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x00e1
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x00e1
            java.lang.String r2 = r2.getStartsOnText()
            goto L_0x00e2
        L_0x00e1:
            r2 = r3
        L_0x00e2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x00e7:
            android.widget.TextView r0 = r7.H
            if (r0 == 0) goto L_0x0100
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x00fa
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x00fa
            java.lang.String r2 = r2.getEndsOnText()
            goto L_0x00fb
        L_0x00fa:
            r2 = r3
        L_0x00fb:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0100:
            android.widget.ImageView r0 = r7.r
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x0111
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0111
            java.lang.String r2 = r2.getMainImageOrVideoUrl()
            goto L_0x0112
        L_0x0111:
            r2 = r3
        L_0x0112:
            r7.a((android.widget.ImageView) r0, (java.lang.String) r2)
            android.widget.ImageView r0 = r7.D
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x0126
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0126
            java.lang.String r2 = r2.getRegisteredUsersIconUrl()
            goto L_0x0127
        L_0x0126:
            r2 = r3
        L_0x0127:
            r7.a((android.widget.ImageView) r0, (java.lang.String) r2)
            android.widget.ImageView r0 = r7.F
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            if (r2 == 0) goto L_0x013b
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x013b
            java.lang.String r2 = r2.getCalendarIconUrl()
            goto L_0x013c
        L_0x013b:
            r2 = r3
        L_0x013c:
            r7.a((android.widget.ImageView) r0, (java.lang.String) r2)
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
            if (r0 == 0) goto L_0x014e
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x014e
            java.lang.String r0 = r0.getStorefrontUrl()
            goto L_0x014f
        L_0x014e:
            r0 = r3
        L_0x014f:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 1
            if (r2 == 0) goto L_0x015e
            int r2 = r2.length()
            if (r2 != 0) goto L_0x015c
            goto L_0x015e
        L_0x015c:
            r2 = 0
            goto L_0x015f
        L_0x015e:
            r2 = 1
        L_0x015f:
            if (r2 != 0) goto L_0x01ca
            java.lang.String r2 = "url"
            kotlin.g.b.k.c(r0, r2)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.travel.d.a()
            com.travel.common.b r5 = com.travel.d.b()
            androidx.fragment.app.Fragment r5 = r5.b()
            r7.af = r5
            androidx.fragment.app.Fragment r5 = r7.af
            if (r5 == 0) goto L_0x01ca
            java.lang.String r5 = "bundle_extra_clp_parallax_animation_required"
            r2.putBoolean(r5, r1)
            java.lang.String r5 = "bundle_extra_secondary_home_user_visible"
            r2.putBoolean(r5, r1)
            java.lang.String r5 = "first_tab_home"
            r2.putBoolean(r5, r4)
            java.lang.String r5 = "travelpass"
            java.lang.String r6 = "origin"
            r2.putString(r6, r5)
            java.lang.String r6 = "EXTRA_STORE_FRONT_ALTERNATE_URL"
            r2.putString(r6, r0)
            java.lang.String r0 = "store_front_url_key"
            r2.putString(r0, r5)
            androidx.fragment.app.Fragment r0 = r7.af
            if (r0 != 0) goto L_0x01a4
            kotlin.g.b.k.a()
        L_0x01a4:
            r0.setArguments(r2)
            androidx.fragment.app.j r0 = r7.getChildFragmentManager()
            java.lang.String r2 = "getChildFragmentManager()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            androidx.fragment.app.j r0 = r7.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            int r2 = com.travel.R.id.frag_container
            androidx.fragment.app.Fragment r5 = r7.af
            if (r5 != 0) goto L_0x01c1
            kotlin.g.b.k.a()
        L_0x01c1:
            java.lang.String r6 = "endLessScroll"
            androidx.fragment.app.q r0 = r0.a(r2, r5, r6)
            r0.b()
        L_0x01ca:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
            r7.a((com.travel.sale.data.model.CampaignDetailsResponse) r0)
            com.travel.sale.ShareView r0 = r7.T
            if (r0 == 0) goto L_0x01db
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            r5 = r7
            com.travel.sale.ShareView$a r5 = (com.travel.sale.ShareView.a) r5
            r0.a((com.travel.sale.data.model.CampaignDetailsResponse) r2, (com.travel.sale.ShareView.a) r5, java.lang.Integer.valueOf(r0.f25705c))
        L_0x01db:
            com.travel.sale.CalendarView r0 = r7.S
            if (r0 == 0) goto L_0x0218
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            r5 = r7
            com.travel.sale.CalendarView$a r5 = (com.travel.sale.CalendarView.a) r5
            r0.f25670a = r2
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r0.f25670a
            if (r2 == 0) goto L_0x01f9
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x01f9
            boolean r2 = r2.isInterested()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x01fa
        L_0x01f9:
            r2 = r3
        L_0x01fa:
            if (r2 != 0) goto L_0x01ff
            kotlin.g.b.k.a()
        L_0x01ff:
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x020a
            r0.a(r4)
            r0.o = r4
        L_0x020a:
            r0.n = r5
            r0.setupCalendarVisibilityState()
            r0.setCalendarType()
            r0.setTypeDepedentVibility()
            r0.a()
        L_0x0218:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
            if (r0 == 0) goto L_0x0227
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0227
            java.lang.String r0 = r0.getMainImageOrVideoType()
            goto L_0x0228
        L_0x0227:
            r0 = r3
        L_0x0228:
            java.lang.String r2 = "video"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r4)
            if (r0 == 0) goto L_0x0246
            android.widget.ImageView r0 = r7.s
            if (r0 == 0) goto L_0x0238
            r0.setVisibility(r1)
        L_0x0238:
            android.widget.ImageView r0 = r7.s
            if (r0 == 0) goto L_0x0246
            com.travel.sale.f$q r2 = new com.travel.sale.f$q
            r2.<init>(r7)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
        L_0x0246:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
            if (r0 == 0) goto L_0x0259
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0259
            boolean r0 = r0.isSaleLive()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x025a
        L_0x0259:
            r0 = r3
        L_0x025a:
            if (r0 != 0) goto L_0x025f
            kotlin.g.b.k.a()
        L_0x025f:
            boolean r0 = r0.booleanValue()
            r2 = 8
            if (r0 == 0) goto L_0x0285
            android.widget.RelativeLayout r0 = r7.V
            if (r0 == 0) goto L_0x026e
            r0.setVisibility(r2)
        L_0x026e:
            com.travel.sale.LiveSaleView r0 = r7.U
            if (r0 == 0) goto L_0x0275
            r0.setVisibility(r1)
        L_0x0275:
            com.travel.sale.LiveSaleView r0 = r7.U
            if (r0 == 0) goto L_0x0293
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r7.f25754c
            r4 = r7
            com.travel.sale.LiveSaleView$a r4 = (com.travel.sale.LiveSaleView.a) r4
            r5 = r7
            com.travel.sale.ShareView$a r5 = (com.travel.sale.ShareView.a) r5
            r0.a(r2, r4, r5)
            goto L_0x0293
        L_0x0285:
            android.widget.RelativeLayout r0 = r7.V
            if (r0 == 0) goto L_0x028c
            r0.setVisibility(r1)
        L_0x028c:
            com.travel.sale.LiveSaleView r0 = r7.U
            if (r0 == 0) goto L_0x0293
            r0.setVisibility(r2)
        L_0x0293:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r7.f25754c
            if (r0 == 0) goto L_0x02a1
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x02a1
            boolean r1 = r0.isInterested()
        L_0x02a1:
            if (r1 == 0) goto L_0x02a6
            r7.j()
        L_0x02a6:
            android.widget.TextView r0 = r7.Y
            if (r0 == 0) goto L_0x02bd
            com.travel.sale.data.model.CampaignDetailsResponse r7 = r7.f25754c
            if (r7 == 0) goto L_0x02b8
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r7 = r7.getBody()
            if (r7 == 0) goto L_0x02b8
            java.lang.String r3 = r7.getRegisteredText()
        L_0x02b8:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.g(com.travel.sale.f):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void n(com.travel.sale.f r5) {
        /*
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0012
            androidx.fragment.app.q r0 = r0.a()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            java.lang.String r3 = "registered_dialog"
            if (r2 == 0) goto L_0x0026
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            if (r2 == 0) goto L_0x0026
            androidx.fragment.app.Fragment r2 = r2.c((java.lang.String) r3)
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x002e
            if (r0 == 0) goto L_0x002e
            r0.a((androidx.fragment.app.Fragment) r2)
        L_0x002e:
            if (r0 == 0) goto L_0x0033
            r0.a((java.lang.String) r1)
        L_0x0033:
            com.travel.sale.b$a r1 = com.travel.sale.b.f25722b
            com.travel.sale.data.model.CampaignSubscriptionResponse r1 = r5.ac
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            java.lang.String r2 = "subscriptionResponse"
            kotlin.g.b.k.c(r1, r2)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r4 = com.travel.sale.b.j
            java.io.Serializable r1 = (java.io.Serializable) r1
            r2.putSerializable(r4, r1)
            com.travel.sale.b r1 = new com.travel.sale.b
            r1.<init>()
            r1.setArguments(r2)
            com.travel.sale.b$b r5 = (com.travel.sale.b.C0480b) r5
            java.lang.String r2 = "registeredDialogListener"
            kotlin.g.b.k.c(r5, r2)
            r1.f25723a = r5
            if (r0 != 0) goto L_0x0065
            kotlin.g.b.k.a()
        L_0x0065:
            r1.show((androidx.fragment.app.q) r0, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.f.n(com.travel.sale.f):void");
    }
}
