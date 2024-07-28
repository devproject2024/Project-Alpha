package net.one97.paytm.v2.features.cashbacklanding.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.j;

public final class e extends b {

    /* renamed from: b  reason: collision with root package name */
    boolean f20175b;

    /* renamed from: c  reason: collision with root package name */
    String f20176c = "";

    /* renamed from: d  reason: collision with root package name */
    String f20177d;

    /* renamed from: e  reason: collision with root package name */
    String f20178e = "Money Transfer and Bank Offers";

    /* renamed from: f  reason: collision with root package name */
    String f20179f = "Recharge and Bill payment Offers";

    /* renamed from: g  reason: collision with root package name */
    final a f20180g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20181h = new ArrayList<>();

    public e(a aVar) {
        k.c(aVar, "adapterHelper");
        this.f20180g = aVar;
    }

    public final void a(ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList) {
        k.c(arrayList, "data");
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList2 = this.f20181h;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.f20181h.addAll(arrayList);
        if (this.f20175b) {
            ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList3 = this.f20181h;
            a.C0382a.C0383a aVar = a.C0382a.f20768a;
            arrayList3.add(new net.one97.paytm.v2.features.cashbacklanding.model.a((String) null, (String) null, (String) null, (String) null, a.C0382a.f20774g, 32));
        }
        notifyDataSetChanged();
    }

    public final void a(String str) {
        k.c(str, "offerType");
        this.f20177d = str;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        a.C0382a.C0383a aVar = a.C0382a.f20768a;
        if (i2 == a.C0382a.f20770c) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.scratch_card_list_item, viewGroup, false);
            if (inflate == null) {
                k.a();
            }
            return new a(this, inflate);
        }
        a.C0382a.C0383a aVar2 = a.C0382a.f20768a;
        if (i2 == a.C0382a.f20771d) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_offers_list_item, viewGroup, false);
            if (inflate2 == null) {
                k.a();
            }
            return new b(this, inflate2);
        }
        a.C0382a.C0383a aVar3 = a.C0382a.f20768a;
        if (i2 != a.C0382a.f20775h) {
            a.C0382a.C0383a aVar4 = a.C0382a.f20768a;
            if (i2 != a.C0382a.k) {
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cashback_list_viewall_item, viewGroup, false);
                if (inflate3 == null) {
                    k.a();
                }
                return new c(this, inflate3);
            }
        }
        View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_offers_list_item, viewGroup, false);
        if (inflate4 == null) {
            k.a();
        }
        return new d(this, inflate4);
    }

    public final int getItemCount() {
        return this.f20181h.size();
    }

    /* JADX WARNING: type inference failed for: r2v90, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v137, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0626  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r20, int r21) {
        /*
            r19 = this;
            r0 = r20
            r5 = r21
            java.lang.String r1 = "holder"
            kotlin.g.b.k.c(r0, r1)
            r6 = r19
            java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r1 = r6.f20181h
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r2 = "viewList[position]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r4 = r1
            net.one97.paytm.v2.features.cashbacklanding.model.a r4 = (net.one97.paytm.v2.features.cashbacklanding.model.a) r4
            boolean r1 = r0 instanceof net.one97.paytm.v2.features.cashbacklanding.c.e.a
            r2 = 0
            java.lang.String r3 = "offer"
            r7 = 1
            java.lang.String r8 = "itemView"
            r9 = 0
            if (r1 == 0) goto L_0x03c0
            r10 = r0
            net.one97.paytm.v2.features.cashbacklanding.c.e$a r10 = (net.one97.paytm.v2.features.cashbacklanding.c.e.a) r10
            kotlin.g.b.k.c(r4, r3)
            android.view.View r11 = r10.itemView
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r0 = r4.f20293f
            net.one97.paytm.vipcashback.d.a$a$a r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20770c
            java.lang.String r12 = "luckyCardUpTo"
            r13 = 4
            java.lang.String r14 = "luckyCardAmountView"
            r15 = 8
            if (r0 != r1) goto L_0x0184
            java.lang.String r0 = "UNSCRATCH CARD"
            r3.add(r0)
            boolean r0 = r4.j
            if (r0 == 0) goto L_0x007a
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.j.LUCKY_DRAW_THEME
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r1.setVisibility(r9)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardUpTo
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r9)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            java.lang.String r7 = r4.k
            net.one97.paytm.v2.b.a.a(r1, r7)
            goto L_0x009e
        L_0x007a:
            net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r0 = r4.f20294g
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r0, (boolean) r7)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r1.setVisibility(r13)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardUpTo
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r13)
        L_0x009e:
            boolean r1 = r4.f20296i
            if (r1 == 0) goto L_0x0148
            int r1 = net.one97.paytm.vipcashback.R.id.scratchCardParent
            android.view.View r1 = r11.findViewById(r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            if (r1 == 0) goto L_0x00cc
            int r7 = net.one97.paytm.vipcashback.R.id.scratchCardParent
            android.view.View r7 = r11.findViewById(r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 != 0) goto L_0x00b9
            kotlin.g.b.k.a()
        L_0x00b9:
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            android.content.res.Resources r12 = r11.getResources()
            int r13 = net.one97.paytm.vipcashback.R.dimen.dimen_153dp
            int r12 = r12.getDimensionPixelOffset(r13)
            r7.width = r12
            r1.setLayoutParams(r7)
        L_0x00cc:
            android.content.res.Resources r1 = r11.getResources()
            int r7 = net.one97.paytm.common.assets.R.dimen.dimen_9dp
            int r1 = r1.getDimensionPixelOffset(r7)
            android.content.res.Resources r7 = r11.getResources()
            int r12 = net.one97.paytm.common.assets.R.dimen.dimen_10dp
            int r7 = r7.getDimensionPixelOffset(r12)
            android.view.View r12 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r8)
            int r13 = net.one97.paytm.vipcashback.R.id.backGround
            android.view.View r12 = r12.findViewById(r13)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.lang.String r13 = "itemView.backGround"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            if (r12 == 0) goto L_0x0140
            android.view.ViewGroup$MarginLayoutParams r12 = (android.view.ViewGroup.MarginLayoutParams) r12
            if (r12 == 0) goto L_0x00ff
            r12.setMargins(r9, r7, r1, r9)
        L_0x00ff:
            android.view.View r1 = r10.itemView
            if (r1 == 0) goto L_0x010c
            int r2 = net.one97.paytm.vipcashback.R.id.backGround
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            android.widget.ImageView r2 = (android.widget.ImageView) r2
        L_0x010c:
            java.lang.String r1 = "itemView?.backGround"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r2.setLayoutParams(r12)
            int r1 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0123
            r1.setVisibility(r15)
        L_0x0123:
            int r1 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0130
            r1.setVisibility(r9)
        L_0x0130:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0171
            java.lang.String r2 = r4.l
            net.one97.paytm.v2.b.a.a(r1, r2)
            goto L_0x0171
        L_0x0140:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x0148:
            int r1 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0155
            r1.setVisibility(r15)
        L_0x0155:
            int r1 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0162
            r1.setVisibility(r15)
        L_0x0162:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0171
            int r2 = net.one97.paytm.vipcashback.R.string.cb_scratch_now
            r1.setText(r2)
        L_0x0171:
            r10.a(r0)
            net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r10.f20182a
            net.one97.paytm.v2.features.cashbacklanding.c.a r0 = r0.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r0 = r0.f20148a
            android.view.View r1 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r0.invoke(r1)
            goto L_0x03af
        L_0x0184:
            net.one97.paytm.vipcashback.d.a$a$a r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20772e
            if (r0 != r1) goto L_0x0224
            java.lang.String r0 = "LOCKED CARD"
            r3.add(r0)
            int r0 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r0 = r11.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x019e
            r0.setVisibility(r9)
        L_0x019e:
            int r0 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r0 = r11.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x01ab
            r0.setVisibility(r15)
        L_0x01ab:
            int r0 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01ba
            java.lang.String r1 = r4.f20290c
            net.one97.paytm.v2.b.a.a(r0, r1)
        L_0x01ba:
            boolean r0 = r4.j
            if (r0 == 0) goto L_0x01ed
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.j.LUCKY_DRAW_THEME
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r1.setVisibility(r9)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardUpTo
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r9)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            java.lang.String r2 = r4.k
            net.one97.paytm.v2.b.a.a(r1, r2)
            goto L_0x0211
        L_0x01ed:
            net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r0 = r4.f20294g
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r0, (boolean) r7)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardAmountView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r1.setVisibility(r13)
            int r1 = net.one97.paytm.vipcashback.R.id.luckyCardUpTo
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r13)
        L_0x0211:
            r10.a(r0)
            net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r10.f20182a
            net.one97.paytm.v2.features.cashbacklanding.c.a r0 = r0.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r0 = r0.f20148a
            android.view.View r1 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r0.invoke(r1)
            goto L_0x03af
        L_0x0224:
            net.one97.paytm.vipcashback.d.a$a$a r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20773f
            r2 = 2
            if (r0 != r1) goto L_0x02c2
            java.lang.String r0 = "SUPER NEW OFFER"
            r3.add(r0)
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.j.GAME_CAMPAIGN_THEME
            int r1 = net.one97.paytm.vipcashback.R.id.imgIcon
            android.view.View r1 = r11.findViewById(r1)
            net.one97.paytm.common.widgets.CircularImageView r1 = (net.one97.paytm.common.widgets.CircularImageView) r1
            if (r1 == 0) goto L_0x0241
            r1.setVisibility(r9)
        L_0x0241:
            java.lang.String r1 = r4.f20288a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x024f
            int r1 = r1.length()
            if (r1 != 0) goto L_0x024e
            goto L_0x024f
        L_0x024e:
            r7 = 0
        L_0x024f:
            if (r7 != 0) goto L_0x026c
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r7 = r4.f20288a
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r7)
            int r7 = net.one97.paytm.vipcashback.R.drawable.cashback_placeholder
            com.squareup.picasso.aa r1 = r1.a((int) r7)
            int r7 = net.one97.paytm.vipcashback.R.id.imgIcon
            android.view.View r7 = r11.findViewById(r7)
            net.one97.paytm.common.widgets.CircularImageView r7 = (net.one97.paytm.common.widgets.CircularImageView) r7
            r1.a((android.widget.ImageView) r7)
        L_0x026c:
            int r1 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0279
            r1.setVisibility(r15)
        L_0x0279:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0286
            r1.setMinLines(r2)
        L_0x0286:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0295
            java.lang.String r2 = r4.f20290c
            net.one97.paytm.v2.b.a.a(r1, r2)
        L_0x0295:
            int r1 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x02a2
            r1.setVisibility(r9)
        L_0x02a2:
            int r1 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x02af
            r1.setVisibility(r15)
        L_0x02af:
            r10.a(r0)
            net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r10.f20182a
            net.one97.paytm.v2.features.cashbacklanding.c.a r0 = r0.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r0 = r0.f20148a
            android.view.View r1 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r0.invoke(r1)
            goto L_0x03af
        L_0x02c2:
            net.one97.paytm.vipcashback.d.a$a$a r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20769b
            if (r0 != r1) goto L_0x035e
            java.lang.String r0 = "MY OFFER"
            r3.add(r0)
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.j.GAME_CAMPAIGN_THEME
            int r1 = net.one97.paytm.vipcashback.R.id.imgIcon
            android.view.View r1 = r11.findViewById(r1)
            net.one97.paytm.common.widgets.CircularImageView r1 = (net.one97.paytm.common.widgets.CircularImageView) r1
            if (r1 == 0) goto L_0x02de
            r1.setVisibility(r9)
        L_0x02de:
            java.lang.String r1 = r4.f20288a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x02ec
            int r1 = r1.length()
            if (r1 != 0) goto L_0x02eb
            goto L_0x02ec
        L_0x02eb:
            r7 = 0
        L_0x02ec:
            if (r7 != 0) goto L_0x0309
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r7 = r4.f20288a
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r7)
            int r7 = net.one97.paytm.vipcashback.R.drawable.cashback_placeholder
            com.squareup.picasso.aa r1 = r1.a((int) r7)
            int r7 = net.one97.paytm.vipcashback.R.id.imgIcon
            android.view.View r7 = r11.findViewById(r7)
            net.one97.paytm.common.widgets.CircularImageView r7 = (net.one97.paytm.common.widgets.CircularImageView) r7
            r1.a((android.widget.ImageView) r7)
        L_0x0309:
            int r1 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0316
            r1.setVisibility(r15)
        L_0x0316:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0323
            r1.setMinLines(r2)
        L_0x0323:
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0332
            java.lang.String r2 = r4.f20290c
            net.one97.paytm.v2.b.a.a(r1, r2)
        L_0x0332:
            int r1 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x033f
            r1.setVisibility(r9)
        L_0x033f:
            int r1 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x034c
            r1.setVisibility(r15)
        L_0x034c:
            r10.a(r0)
            net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r10.f20182a
            net.one97.paytm.v2.features.cashbacklanding.c.a r0 = r0.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r0 = r0.f20148a
            android.view.View r1 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r0.invoke(r1)
            goto L_0x03af
        L_0x035e:
            net.one97.paytm.vipcashback.d.a$a$a r1 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r1 = net.one97.paytm.vipcashback.d.a.C0382a.l
            if (r0 != r1) goto L_0x03af
            java.lang.String r0 = "UNSUPPORTED"
            r3.add(r0)
            net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r0 = r4.f20294g
            net.one97.paytm.vipcashback.f.j r0 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r0, (boolean) r7)
            int r1 = net.one97.paytm.vipcashback.R.id.textView
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0384
            java.lang.String r2 = r4.f20291d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0384:
            int r1 = net.one97.paytm.vipcashback.R.id.cardLock
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0391
            r1.setVisibility(r15)
        L_0x0391:
            int r1 = net.one97.paytm.vipcashback.R.id.cardRedDot
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x039e
            r1.setVisibility(r15)
        L_0x039e:
            r10.a(r0)
            net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r10.f20182a
            net.one97.paytm.v2.features.cashbacklanding.c.a r0 = r0.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r0 = r0.f20148a
            android.view.View r1 = r10.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r0.invoke(r1)
        L_0x03af:
            net.one97.paytm.v2.features.cashbacklanding.c.e$a$a r7 = new net.one97.paytm.v2.features.cashbacklanding.c.e$a$a
            r0 = r7
            r1 = r11
            r2 = r3
            r3 = r10
            r5 = r21
            r0.<init>(r1, r2, r3, r4, r5)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r11.setOnClickListener(r7)
            return
        L_0x03c0:
            boolean r1 = r0 instanceof net.one97.paytm.v2.features.cashbacklanding.c.e.b
            java.lang.String r10 = "overlayView"
            java.lang.String r11 = ""
            if (r1 == 0) goto L_0x0534
            net.one97.paytm.v2.features.cashbacklanding.c.e$b r0 = (net.one97.paytm.v2.features.cashbacklanding.c.e.b) r0
            kotlin.g.b.k.c(r4, r3)
            android.view.View r1 = r0.itemView
            int r3 = r4.f20293f
            net.one97.paytm.vipcashback.d.a$a$a r7 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r7 = net.one97.paytm.vipcashback.d.a.C0382a.f20771d
            if (r3 != r7) goto L_0x0529
            net.one97.paytm.v2.features.cashbacklanding.c.e r3 = r0.f20188a
            net.one97.paytm.v2.features.cashbacklanding.c.a r3 = r3.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r3 = r3.f20148a
            java.lang.String r7 = "this"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            r3.invoke(r1)
            int r3 = net.one97.paytm.vipcashback.R.id.offerTitle
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0406
            java.lang.String r7 = r4.f20290c
            if (r7 == 0) goto L_0x0401
            java.lang.String r12 = "%s"
            java.lang.String r7 = kotlin.m.p.a(r7, r12, r11, r9)
            if (r7 == 0) goto L_0x0401
            java.lang.String r2 = kotlin.m.p.f(r7)
        L_0x0401:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x0406:
            int r2 = net.one97.paytm.vipcashback.R.id.offerSubTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0417
            java.lang.String r3 = r4.f20291d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0417:
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            java.lang.String r3 = r4.f20288a
            com.squareup.picasso.aa r2 = r2.a((java.lang.String) r3)
            int r3 = net.one97.paytm.vipcashback.R.id.offerLogo
            android.view.View r3 = r1.findViewById(r3)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r3 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r3
            r2.a((android.widget.ImageView) r3)
            net.one97.paytm.v2.features.cashbacklanding.c.e r2 = r0.f20188a
            java.lang.String r2 = r2.f20177d
            net.one97.paytm.v2.features.cashbacklanding.c.e r3 = r0.f20188a
            java.lang.String r3 = r3.f20178e
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x04c2
            int r2 = net.one97.paytm.vipcashback.R.id.offerbg
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.coins.customview.RoundedImageView r2 = (net.one97.paytm.coins.customview.RoundedImageView) r2
            if (r2 == 0) goto L_0x0451
            android.content.res.Resources r3 = r1.getResources()
            int r7 = net.one97.paytm.vipcashback.R.drawable.bg_money_trasfer_card
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r7)
            r2.setBackground(r3)
        L_0x0451:
            int r2 = net.one97.paytm.vipcashback.R.id.offerLogo
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r2 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r2
            java.lang.String r3 = "offerLogo"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.content.res.Resources r3 = r1.getResources()
            int r7 = net.one97.paytm.common.assets.R.dimen.dimen_60dp
            int r3 = r3.getDimensionPixelOffset(r7)
            r2.width = r3
            android.content.res.Resources r3 = r1.getResources()
            int r7 = net.one97.paytm.common.assets.R.dimen.dimen_60dp
            int r3 = r3.getDimensionPixelOffset(r7)
            r2.height = r3
            int r2 = net.one97.paytm.vipcashback.R.id.border
            android.view.View r2 = r1.findViewById(r2)
            androidx.constraintlayout.widget.Guideline r2 = (androidx.constraintlayout.widget.Guideline) r2
            if (r2 == 0) goto L_0x048a
            r3 = 1055286886(0x3ee66666, float:0.45)
            r2.setGuidelinePercent(r3)
        L_0x048a:
            int r2 = net.one97.paytm.vipcashback.R.id.offerTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x049d
            java.lang.String r3 = "sans-serif-medium"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r9)
            r2.setTypeface(r3)
        L_0x049d:
            int r2 = net.one97.paytm.vipcashback.R.id.offerTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "#1D2F54"
            if (r2 == 0) goto L_0x04b0
            int r7 = android.graphics.Color.parseColor(r3)
            r2.setTextColor(r7)
        L_0x04b0:
            int r2 = net.one97.paytm.vipcashback.R.id.offerSubTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0529
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setTextColor(r3)
            goto L_0x0529
        L_0x04c2:
            net.one97.paytm.v2.features.cashbacklanding.c.e r3 = r0.f20188a
            java.lang.String r3 = r3.f20179f
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x04e4
            int r2 = net.one97.paytm.vipcashback.R.id.offerbg
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.coins.customview.RoundedImageView r2 = (net.one97.paytm.coins.customview.RoundedImageView) r2
            if (r2 == 0) goto L_0x0529
            android.content.res.Resources r3 = r1.getResources()
            int r7 = net.one97.paytm.vipcashback.R.drawable.deal_list_item_bg
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r7)
            r2.setBackground(r3)
            goto L_0x0529
        L_0x04e4:
            int r2 = net.one97.paytm.vipcashback.R.id.offerbg
            android.view.View r2 = r1.findViewById(r2)
            r11 = r2
            net.one97.paytm.coins.customview.RoundedImageView r11 = (net.one97.paytm.coins.customview.RoundedImageView) r11
            if (r11 == 0) goto L_0x0529
            java.lang.String r12 = r4.f20289b
            int r2 = net.one97.paytm.vipcashback.R.drawable.cashback_campaign_default_bg
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
            int r2 = net.one97.paytm.vipcashback.R.drawable.cashback_campaign_default_bg
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            android.widget.ImageView$ScaleType r15 = android.widget.ImageView.ScaleType.CENTER_CROP
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.common.assets.R.dimen.dimen_10dp
            int r2 = r2.getDimensionPixelOffset(r3)
            float r2 = (float) r2
            java.lang.Float r16 = java.lang.Float.valueOf(r2)
            int r2 = net.one97.paytm.vipcashback.R.id.overlayView
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.coins.customview.RoundedImageView r2 = (net.one97.paytm.coins.customview.RoundedImageView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r10)
            r17 = r2
            android.view.View r17 = (android.view.View) r17
            boolean r2 = r4.f20295h
            r18 = r2
            r11.a(r12, r13, r14, r15, r16, r17, r18)
        L_0x0529:
            net.one97.paytm.v2.features.cashbacklanding.c.e$b$a r2 = new net.one97.paytm.v2.features.cashbacklanding.c.e$b$a
            r2.<init>(r0, r4, r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            return
        L_0x0534:
            boolean r1 = r0 instanceof net.one97.paytm.v2.features.cashbacklanding.c.e.c
            if (r1 == 0) goto L_0x054a
            net.one97.paytm.v2.features.cashbacklanding.c.e$c r0 = (net.one97.paytm.v2.features.cashbacklanding.c.e.c) r0
            kotlin.g.b.k.c(r4, r3)
            android.view.View r1 = r0.itemView
            net.one97.paytm.v2.features.cashbacklanding.c.e$c$a r2 = new net.one97.paytm.v2.features.cashbacklanding.c.e$c$a
            r2.<init>(r0, r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            return
        L_0x054a:
            boolean r1 = r0 instanceof net.one97.paytm.v2.features.cashbacklanding.c.e.d
            if (r1 == 0) goto L_0x0693
            net.one97.paytm.v2.features.cashbacklanding.c.e$d r0 = (net.one97.paytm.v2.features.cashbacklanding.c.e.d) r0
            kotlin.g.b.k.c(r4, r3)
            android.view.View r1 = r0.itemView
            if (r1 == 0) goto L_0x0693
            net.one97.paytm.v2.features.cashbacklanding.c.e$d$a r2 = new net.one97.paytm.v2.features.cashbacklanding.c.e$d$a
            r2.<init>(r0, r5, r4)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            net.one97.paytm.v2.features.cashbacklanding.c.e r2 = r0.f20195a
            net.one97.paytm.v2.features.cashbacklanding.c.a r2 = r2.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r2 = r2.f20148a
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            r2.invoke(r3)
            int r2 = net.one97.paytm.vipcashback.R.id.offerTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "offerTitle"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r4.f20290c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            int r2 = r0.getItemViewType()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            net.one97.paytm.vipcashback.d.a$a$a r3 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
            int r3 = net.one97.paytm.vipcashback.d.a.C0382a.f20775h
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r2 = r2.equals(r3)
            java.lang.String r3 = "offerSubTitle"
            if (r2 == 0) goto L_0x05f7
            int r2 = net.one97.paytm.vipcashback.R.id.offerSubTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r4.f20291d
            net.one97.paytm.v2.b.a.a(r2, r3)
            java.lang.String r2 = r4.p
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x05bb
            int r2 = r2.length()
            if (r2 != 0) goto L_0x05ba
            goto L_0x05bb
        L_0x05ba:
            r7 = 0
        L_0x05bb:
            if (r7 != 0) goto L_0x0633
            int r2 = net.one97.paytm.vipcashback.R.id.offerbg
            android.view.View r2 = r1.findViewById(r2)
            r11 = r2
            net.one97.paytm.coins.customview.RoundedImageView r11 = (net.one97.paytm.coins.customview.RoundedImageView) r11
            if (r11 == 0) goto L_0x0633
            java.lang.String r12 = r4.p
            r13 = 0
            int r2 = net.one97.paytm.vipcashback.R.drawable.cashback_campaign_default_bg
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            android.widget.ImageView$ScaleType r15 = android.widget.ImageView.ScaleType.CENTER_CROP
            android.content.res.Resources r2 = r1.getResources()
            int r3 = net.one97.paytm.common.assets.R.dimen.dimen_10dp
            int r2 = r2.getDimensionPixelOffset(r3)
            float r2 = (float) r2
            java.lang.Float r16 = java.lang.Float.valueOf(r2)
            int r2 = net.one97.paytm.vipcashback.R.id.overlayView
            android.view.View r1 = r1.findViewById(r2)
            net.one97.paytm.coins.customview.RoundedImageView r1 = (net.one97.paytm.coins.customview.RoundedImageView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r10)
            r17 = r1
            android.view.View r17 = (android.view.View) r17
            r18 = 1
            r11.a(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0633
        L_0x05f7:
            int r2 = net.one97.paytm.vipcashback.R.id.offerSubTitle
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r4.f20291d
            if (r3 == 0) goto L_0x0616
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x060f
            r9 = 1
        L_0x060f:
            if (r9 != r7) goto L_0x0616
            java.lang.String r3 = r4.f20291d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0619
        L_0x0616:
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x0619:
            r2.setText(r3)
            int r2 = net.one97.paytm.vipcashback.R.id.offerbg
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.coins.customview.RoundedImageView r2 = (net.one97.paytm.coins.customview.RoundedImageView) r2
            if (r2 == 0) goto L_0x0633
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.vipcashback.R.drawable.deal_list_item_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r2.setBackground(r1)
        L_0x0633:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r2 = r4.f20289b
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
            int r2 = net.one97.paytm.vipcashback.R.drawable.voucher_deal_placeholder
            com.squareup.picasso.aa r1 = r1.a((int) r2)
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r3 = net.one97.paytm.vipcashback.R.id.offerLogo
            android.view.View r2 = r2.findViewById(r3)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r2 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r2
            java.lang.String r3 = "itemView.offerLogo"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            int r2 = r2.width
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            int r5 = net.one97.paytm.vipcashback.R.id.offerLogo
            android.view.View r4 = r4.findViewById(r5)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            int r3 = r3.height
            com.squareup.picasso.aa r1 = r1.a((int) r2, (int) r3)
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r3 = net.one97.paytm.vipcashback.R.id.offerLogo
            android.view.View r2 = r2.findViewById(r3)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r2 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r2
            r1.a((android.widget.ImageView) r2)
            net.one97.paytm.v2.features.cashbacklanding.c.e r1 = r0.f20195a
            net.one97.paytm.v2.features.cashbacklanding.c.a r1 = r1.f20180g
            kotlin.g.a.b<android.view.View, kotlin.x> r1 = r1.f20148a
            android.view.View r0 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r1.invoke(r0)
        L_0x0693:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.c.e.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        int i3 = this.f20181h.get(i2).f20293f;
        a.C0382a.C0383a aVar = a.C0382a.f20768a;
        if (i3 != a.C0382a.f20770c) {
            a.C0382a.C0383a aVar2 = a.C0382a.f20768a;
            if (i3 != a.C0382a.f20772e) {
                a.C0382a.C0383a aVar3 = a.C0382a.f20768a;
                if (i3 != a.C0382a.f20773f) {
                    a.C0382a.C0383a aVar4 = a.C0382a.f20768a;
                    if (i3 != a.C0382a.f20769b) {
                        a.C0382a.C0383a aVar5 = a.C0382a.f20768a;
                        if (i3 != a.C0382a.l) {
                            a.C0382a.C0383a aVar6 = a.C0382a.f20768a;
                            if (i3 != a.C0382a.f20771d) {
                                return i3;
                            }
                            a.C0382a.C0383a aVar7 = a.C0382a.f20768a;
                            return a.C0382a.f20771d;
                        }
                    }
                }
            }
        }
        a.C0382a.C0383a aVar8 = a.C0382a.f20768a;
        return a.C0382a.f20770c;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20182a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20182a = eVar;
        }

        /* renamed from: net.one97.paytm.v2.features.cashbacklanding.c.e$a$a  reason: collision with other inner class name */
        static final class C0362a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f20183a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f20184b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f20185c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.v2.features.cashbacklanding.model.a f20186d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f20187e;

            C0362a(View view, ArrayList arrayList, a aVar, net.one97.paytm.v2.features.cashbacklanding.model.a aVar2, int i2) {
                this.f20183a = view;
                this.f20184b = arrayList;
                this.f20185c = aVar;
                this.f20186d = aVar2;
                this.f20187e = i2;
            }

            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                int i2 = this.f20186d.f20293f;
                a.C0382a.C0383a aVar = a.C0382a.f20768a;
                if (i2 == a.C0382a.f20772e) {
                    arrayList.add("locked");
                } else {
                    a.C0382a.C0383a aVar2 = a.C0382a.f20768a;
                    if (i2 == a.C0382a.f20769b) {
                        String str = this.f20186d.f20294g;
                        if (str != null) {
                            arrayList.add(str);
                        }
                    } else {
                        a.C0382a.C0383a aVar3 = a.C0382a.f20768a;
                        if (i2 == a.C0382a.f20773f) {
                            String str2 = this.f20186d.f20294g;
                            if (str2 != null) {
                                arrayList.add(str2);
                            }
                        } else {
                            a.C0382a.C0383a aVar4 = a.C0382a.f20768a;
                            int unused = a.C0382a.f20770c;
                        }
                    }
                }
                net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
                k.a((Object) view, "it");
                b2.sendNewCustomGTMEventsWithMultipleLabel(view.getContext(), "cashback_offers", "locked_cards_clicked", this.f20184b, (String) null, "/cashback-landing", "cashback");
                Integer valueOf = Integer.valueOf(this.f20186d.f20293f);
                a.C0382a.C0383a aVar5 = a.C0382a.f20768a;
                if (valueOf.equals(Integer.valueOf(a.C0382a.l))) {
                    d.a aVar6 = net.one97.paytm.vipcashback.f.d.f20859a;
                    Context context = this.f20183a.getContext();
                    k.a((Object) context, "context");
                    k.c(context, "context");
                    String packageName = context.getPackageName();
                    try {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(packageName)))));
                    } catch (ActivityNotFoundException unused2) {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=".concat(String.valueOf(packageName)))));
                    }
                } else {
                    d.a aVar7 = net.one97.paytm.vipcashback.f.d.f20859a;
                    View view2 = this.f20185c.itemView;
                    k.a((Object) view2, "itemView");
                    d.a.a(view2);
                    m<? super Integer, ? super String, x> mVar = this.f20185c.f20182a.f20149a;
                    if (mVar != null) {
                        mVar.invoke(Integer.valueOf(this.f20187e), this.f20185c.f20182a.f20176c);
                    }
                }
            }
        }

        public final void a(j jVar) {
            k.c(jVar, "theme");
            View view = this.itemView;
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            if (imageView != null) {
                imageView.setImageResource(jVar.getIcon());
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.backGround);
            Drawable drawable = null;
            Drawable background = imageView2 != null ? imageView2.getBackground() : null;
            if (background != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(Color.parseColor(jVar.getBgColor()));
                }
                TextView textView = (TextView) view.findViewById(R.id.textView);
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(jVar.getTextColor()));
                }
                TextView textView2 = (TextView) view.findViewById(R.id.textView);
                if (textView2 != null) {
                    drawable = textView2.getBackground();
                }
                if (drawable != null) {
                    GradientDrawable gradientDrawable2 = (GradientDrawable) drawable;
                    if (gradientDrawable2 != null) {
                        gradientDrawable2.setColor(Color.parseColor(jVar.getTextBgColor()));
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20188a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20188a = eVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f20189a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.v2.features.cashbacklanding.model.a f20190b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f20191c;

            a(b bVar, net.one97.paytm.v2.features.cashbacklanding.model.a aVar, int i2) {
                this.f20189a = bVar;
                this.f20190b = aVar;
                this.f20191c = i2;
            }

            public final void onClick(View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                View view2 = this.f20189a.itemView;
                k.a((Object) view2, "itemView");
                d.a.a(view2);
                m<? super Integer, ? super String, x> mVar = this.f20189a.f20188a.f20149a;
                if (mVar != null) {
                    mVar.invoke(Integer.valueOf(this.f20191c), this.f20189a.f20188a.f20176c);
                }
            }
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20195a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20195a = eVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f20196a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f20197b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.v2.features.cashbacklanding.model.a f20198c;

            a(d dVar, int i2, net.one97.paytm.v2.features.cashbacklanding.model.a aVar) {
                this.f20196a = dVar;
                this.f20197b = i2;
                this.f20198c = aVar;
            }

            public final void onClick(View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                View view2 = this.f20196a.itemView;
                k.a((Object) view2, "itemView");
                d.a.a(view2);
                m<? super Integer, ? super String, x> mVar = this.f20196a.f20195a.f20149a;
                if (mVar != null) {
                    mVar.invoke(Integer.valueOf(this.f20197b), this.f20196a.f20195a.f20176c);
                }
            }
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20192a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20192a = eVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f20193a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f20194b;

            a(c cVar, int i2) {
                this.f20193a = cVar;
                this.f20194b = i2;
            }

            public final void onClick(View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                View view2 = this.f20193a.itemView;
                k.a((Object) view2, "itemView");
                d.a.a(view2);
                m<? super Integer, ? super String, x> mVar = this.f20193a.f20192a.f20149a;
                if (mVar != null) {
                    mVar.invoke(Integer.valueOf(this.f20194b), this.f20193a.f20192a.f20176c);
                }
            }
        }
    }

    public final void b(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            str = "";
        }
        this.f20176c = str;
    }
}
