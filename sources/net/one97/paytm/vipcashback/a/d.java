package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;
import net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal;
import net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel;
import net.one97.paytm.common.entity.vipcashback.MerchantGameItem;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f20588a = 3;

    /* renamed from: b  reason: collision with root package name */
    public a f20589b;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.vipcashback.e.b f20590h;

    /* renamed from: i  reason: collision with root package name */
    boolean f20591i;
    public boolean j;
    public boolean k;
    public boolean l;
    final Context m;
    public c n;
    public final ArrayList<MerchantGameItem> o;
    final String p;
    private net.one97.paytm.vipcashback.e.a q = new net.one97.paytm.vipcashback.e.a(this.m);
    private net.one97.paytm.vipcashback.d.a r;
    private boolean s;
    private boolean t;
    private boolean u;
    private final boolean v;
    private final boolean w;

    public interface c {
        void a();

        void a(int i2);

        void a(int i2, MerchantGameItem merchantGameItem);

        void a(View view, int i2);

        void a(NetworkCustomError networkCustomError);

        void a(MerchantGameItem merchantGameItem, String str, View view, String str2);

        void a(boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, c cVar, RecyclerView recyclerView, ArrayList<MerchantGameItem> arrayList, boolean z, String str, boolean z2) {
        super(recyclerView);
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        kotlin.g.b.k.c(arrayList, "myOffersArrayList");
        this.m = context;
        this.n = cVar;
        this.o = arrayList;
        this.v = z;
        this.p = str;
        this.w = z2;
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final a f20613a = new a((byte) 0);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final int f20614b = 11;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final int f20615c = 12;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final int f20616d = 13;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final int f20617e = 14;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final int f20618f = 15;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        kotlin.g.b.k.c(viewGroup, "viewGroup");
        g.a aVar = g.f20613a;
        if (i2 == g.f20614b) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_heading, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate, "LayoutInflater.from(view…eading, viewGroup, false)");
            return new b(this, inflate);
        }
        g.a aVar2 = g.f20613a;
        if (i2 == g.f20615c) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_new_offers, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate2, "LayoutInflater.from(view…offers, viewGroup, false)");
            return new e(this, inflate2);
        }
        g.a aVar3 = g.f20613a;
        if (i2 == g.f20617e) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_no_offer, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate3, "LayoutInflater.from(view…_offer, viewGroup, false)");
            return new f(this, inflate3);
        }
        g.a aVar4 = g.f20613a;
        if (i2 == g.f20616d) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_cashback_my_offers_list_item, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate4, "LayoutInflater.from(view…t_item, viewGroup, false)");
            return new C0377d(this, inflate4);
        }
        g.a aVar5 = g.f20613a;
        if (i2 == g.f20618f) {
            View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_expired, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate5, "LayoutInflater.from(view…xpired, viewGroup, false)");
            return new a(this, inflate5);
        }
        View inflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_no_offer, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate6, "LayoutInflater.from(view…_offer, viewGroup, false)");
        return new f(this, inflate6);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v41, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r13, r0)
            boolean r0 = r13 instanceof net.one97.paytm.vipcashback.a.d.b
            if (r0 == 0) goto L_0x0049
            boolean r0 = r12.f20591i
            if (r0 == 0) goto L_0x001f
            net.one97.paytm.vipcashback.a.d$b r13 = (net.one97.paytm.vipcashback.a.d.b) r13
            android.widget.TextView r13 = r13.f20594a
            android.content.Context r14 = r12.m
            int r0 = net.one97.paytm.vipcashback.R.string.cashback_active_heading
            java.lang.String r14 = r14.getString(r0)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
            return
        L_0x001f:
            if (r14 == 0) goto L_0x0037
            r0 = 2
            if (r14 == r0) goto L_0x0025
            goto L_0x0036
        L_0x0025:
            net.one97.paytm.vipcashback.a.d$b r13 = (net.one97.paytm.vipcashback.a.d.b) r13
            android.widget.TextView r13 = r13.f20594a
            android.content.Context r14 = r12.m
            int r0 = net.one97.paytm.vipcashback.R.string.cashback_active_heading
            java.lang.String r14 = r14.getString(r0)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
        L_0x0036:
            return
        L_0x0037:
            net.one97.paytm.vipcashback.a.d$b r13 = (net.one97.paytm.vipcashback.a.d.b) r13
            android.widget.TextView r13 = r13.f20594a
            android.content.Context r14 = r12.m
            int r0 = net.one97.paytm.vipcashback.R.string.cashback_new_heading
            java.lang.String r14 = r14.getString(r0)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
            return
        L_0x0049:
            boolean r0 = r13 instanceof net.one97.paytm.vipcashback.a.d.e
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00d5
            boolean r14 = r12.s
            if (r14 == 0) goto L_0x0054
            return
        L_0x0054:
            r12.s = r1
            r14 = r13
            net.one97.paytm.vipcashback.a.d$e r14 = (net.one97.paytm.vipcashback.a.d.e) r14
            androidx.recyclerview.widget.RecyclerView r0 = r14.f20605a
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r12.m
            r3.<init>(r4, r2, r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r0.setLayoutManager(r3)
            net.one97.paytm.vipcashback.widget.b r0 = new net.one97.paytm.vipcashback.widget.b
            android.content.Context r2 = r12.m
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.common.assets.R.dimen.dimen_10dp
            float r2 = r2.getDimension(r3)
            int r2 = (int) r2
            r0.<init>(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r14.f20605a
            androidx.recyclerview.widget.RecyclerView$h r0 = (androidx.recyclerview.widget.RecyclerView.h) r0
            r2.addItemDecoration(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r14.f20605a
            androidx.recyclerview.widget.g r2 = new androidx.recyclerview.widget.g
            r2.<init>()
            androidx.recyclerview.widget.RecyclerView$f r2 = (androidx.recyclerview.widget.RecyclerView.f) r2
            r0.setItemAnimator(r2)
            net.one97.paytm.vipcashback.d.a r0 = new net.one97.paytm.vipcashback.d.a
            r0.<init>(r1)
            r12.r = r0
            net.one97.paytm.vipcashback.e.b r0 = new net.one97.paytm.vipcashback.e.b
            net.one97.paytm.vipcashback.d.a r2 = r12.r
            if (r2 != 0) goto L_0x009e
            java.lang.String r3 = "newOfferVIPCashbackDataModel"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x009e:
            net.one97.paytm.vipcashback.a.d$h r3 = new net.one97.paytm.vipcashback.a.d$h
            r3.<init>(r12, r13)
            net.one97.paytm.vipcashback.view.a r3 = (net.one97.paytm.vipcashback.view.a) r3
            java.lang.String r13 = "MerchantCashbackFragment"
            r0.<init>(r2, r3, r13)
            r12.f20590h = r0
            net.one97.paytm.vipcashback.a.a r13 = new net.one97.paytm.vipcashback.a.a
            android.content.Context r0 = r12.m
            net.one97.paytm.vipcashback.e.b r2 = r12.f20590h
            if (r2 != 0) goto L_0x00b7
            kotlin.g.b.k.a()
        L_0x00b7:
            androidx.recyclerview.widget.RecyclerView r3 = r14.f20605a
            r13.<init>(r0, r2, r3)
            r12.f20589b = r13
            net.one97.paytm.vipcashback.a.a r13 = r12.f20589b
            if (r13 == 0) goto L_0x00c4
            r13.f20550c = r1
        L_0x00c4:
            androidx.recyclerview.widget.RecyclerView r13 = r14.f20605a
            net.one97.paytm.vipcashback.a.a r14 = r12.f20589b
            androidx.recyclerview.widget.RecyclerView$a r14 = (androidx.recyclerview.widget.RecyclerView.a) r14
            r13.setAdapter(r14)
            boolean r13 = r12.w
            if (r13 == 0) goto L_0x04ba
            r12.a((boolean) r1)
            return
        L_0x00d5:
            boolean r0 = r13 instanceof net.one97.paytm.vipcashback.a.d.C0377d
            if (r0 == 0) goto L_0x0453
            int r0 = r12.f20588a
            int r0 = r14 - r0
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.MerchantGameItem> r3 = r12.o
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r4 = "myOffersArrayList[pos]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.common.entity.vipcashback.MerchantGameItem r3 = (net.one97.paytm.common.entity.vipcashback.MerchantGameItem) r3
            net.one97.paytm.cashback.posttxn.Campaign r4 = r3.getCampaign()
            r5 = 8
            if (r4 == 0) goto L_0x0222
            net.one97.paytm.vipcashback.e.a r4 = r12.q
            r6 = r13
            net.one97.paytm.vipcashback.a.d$d r6 = (net.one97.paytm.vipcashback.a.d.C0377d) r6
            net.one97.paytm.common.widgets.CircularImageView r7 = r6.f20597b
            net.one97.paytm.common.widgets.CircularImageView r6 = r6.f20596a
            net.one97.paytm.cashback.posttxn.Campaign r8 = r3.getCampaign()
            java.lang.String r9 = "merchantGameItem.campaign"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = "ivBg"
            kotlin.g.b.k.c(r7, r9)
            java.lang.String r9 = "ivIcon"
            kotlin.g.b.k.c(r6, r9)
            java.lang.String r9 = "campaign"
            kotlin.g.b.k.c(r8, r9)
            java.lang.Boolean r9 = r8.getOffusTransaction()
            boolean r9 = net.one97.paytm.vipcashback.e.a.a(r9)
            if (r9 == 0) goto L_0x0141
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            android.content.Context r10 = r4.f20835a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = net.one97.paytm.common.assets.R.dimen.dimen_48dp
            int r10 = r10.getDimensionPixelSize(r11)
            r9.width = r10
            android.content.Context r10 = r4.f20835a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = net.one97.paytm.common.assets.R.dimen.dimen_48dp
            int r10 = r10.getDimensionPixelSize(r11)
            r9.height = r10
            r6.setLayoutParams(r9)
            goto L_0x0164
        L_0x0141:
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            android.content.Context r10 = r4.f20835a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = net.one97.paytm.common.assets.R.dimen.dimen_60dp
            int r10 = r10.getDimensionPixelSize(r11)
            r9.width = r10
            android.content.Context r10 = r4.f20835a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = net.one97.paytm.common.assets.R.dimen.dimen_60dp
            int r10 = r10.getDimensionPixelSize(r11)
            r9.height = r10
            r6.setLayoutParams(r9)
        L_0x0164:
            java.lang.Boolean r9 = r8.getOffusTransaction()
            boolean r9 = net.one97.paytm.vipcashback.e.a.a(r9)
            if (r9 == 0) goto L_0x01a6
            java.lang.String r9 = r8.getBackgroundImageUrl()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x01a6
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            java.lang.String r10 = r8.getBackgroundImageUrl()
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r10)
            int r10 = net.one97.paytm.vipcashback.R.drawable.cashback_bg_place_holder
            com.squareup.picasso.aa r9 = r9.a((int) r10)
            android.view.ViewGroup$LayoutParams r10 = r7.getLayoutParams()
            int r10 = r10.width
            android.view.ViewGroup$LayoutParams r11 = r7.getLayoutParams()
            int r11 = r11.height
            com.squareup.picasso.aa r9 = r9.a((int) r10, (int) r11)
            r10 = r7
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.a((android.widget.ImageView) r10)
            r7.setVisibility(r2)
            goto L_0x01a9
        L_0x01a6:
            r7.setVisibility(r5)
        L_0x01a9:
            java.lang.String r7 = r8.getNewOffersImageUrl()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01dd
            com.squareup.picasso.w r4 = com.squareup.picasso.w.a()
            java.lang.String r7 = r8.getNewOffersImageUrl()
            com.squareup.picasso.aa r4 = r4.a((java.lang.String) r7)
            int r7 = net.one97.paytm.vipcashback.R.drawable.cashback_icon_holder
            com.squareup.picasso.aa r4 = r4.a((int) r7)
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            int r7 = r7.width
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            int r8 = r8.height
            com.squareup.picasso.aa r4 = r4.a((int) r7, (int) r8)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.a((android.widget.ImageView) r6)
            goto L_0x0222
        L_0x01dd:
            net.one97.paytm.vipcashback.f.d$a r7 = net.one97.paytm.vipcashback.f.d.f20859a
            android.content.Context r4 = r4.f20835a
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r7 = "context.resources"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            int r7 = net.one97.paytm.vipcashback.R.drawable.cashback_icon_holder
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            int r8 = r8.width
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            int r9 = r9.height
            java.lang.String r10 = "res"
            kotlin.g.b.k.c(r4, r10)
            android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options
            r10.<init>()
            r10.inJustDecodeBounds = r1
            android.graphics.BitmapFactory.decodeResource(r4, r7, r10)
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            int r8 = net.one97.paytm.vipcashback.f.d.a.a((android.graphics.BitmapFactory.Options) r10, (int) r8, (int) r9)
            r10.inSampleSize = r8
            r10.inJustDecodeBounds = r2
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeResource(r4, r7, r10)
            java.lang.String r7 = "BitmapFactory.decodeResource(res, resId, this)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            java.lang.String r7 = "BitmapFactory.Options().…esId, this)\n            }"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            r6.setImageBitmap(r4)
        L_0x0222:
            r4 = r13
            net.one97.paytm.vipcashback.a.d$d r4 = (net.one97.paytm.vipcashback.a.d.C0377d) r4
            android.view.View r6 = r4.f20604i
            java.lang.String r7 = "holder.rlActivate"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r6.setVisibility(r5)
            android.widget.TextView r6 = r4.f20599d
            net.one97.paytm.cashback.posttxn.Campaign r8 = r3.getCampaign()
            if (r8 == 0) goto L_0x023e
            java.lang.String r8 = r8.getOfferTextOverride()
            if (r8 == 0) goto L_0x023e
            goto L_0x0240
        L_0x023e:
            java.lang.String r8 = ""
        L_0x0240:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r6.setText(r8)
            net.one97.paytm.vipcashback.d.a$i$a r6 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.i.f20809b
            java.lang.String r8 = r3.getGameStatus()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0289
            android.widget.TextView r14 = r4.f20600e
            java.lang.String r1 = r3.getOfferProgressConstruct()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r14 = r4.f20601f
            r14.setVisibility(r2)
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r14 = r4.f20601f
            int r1 = r3.getSuccessTxnCount()
            int r6 = r3.getTotalTxnCount()
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView.a(r14, r1, r6)
            android.widget.LinearLayout r14 = r4.f20602g
            r14.setVisibility(r2)
            android.widget.TextView r14 = r4.f20603h
            java.lang.String r1 = r3.getSuccessTxnText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            android.widget.TextView r14 = r4.f20598c
            r14.setVisibility(r5)
            goto L_0x0436
        L_0x0289:
            net.one97.paytm.vipcashback.d.a$i$a r6 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.i.f20811d
            java.lang.String r8 = r3.getGameStatus()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x02cd
            android.widget.TextView r14 = r4.f20600e
            java.lang.String r1 = r3.getInitializedOfferText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r14 = r4.f20601f
            r14.setVisibility(r5)
            android.widget.LinearLayout r14 = r4.f20602g
            r14.setVisibility(r5)
            android.widget.TextView r14 = r4.f20598c
            r14.setVisibility(r5)
            android.view.View r14 = r4.f20604i
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r14.setVisibility(r2)
            android.widget.TextView r14 = r4.j
            r1 = 4
            r14.setVisibility(r1)
            com.airbnb.lottie.LottieAnimationView r14 = r4.k
            r14.setVisibility(r2)
            com.airbnb.lottie.LottieAnimationView r14 = r4.k
            net.one97.paytm.common.widgets.a.a(r14)
            goto L_0x0436
        L_0x02cd:
            net.one97.paytm.vipcashback.d.a$i$a r6 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.i.f20810c
            java.lang.String r8 = r3.getGameStatus()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0320
            android.widget.TextView r6 = r4.f20600e
            java.lang.String r8 = r3.getInitializedOfferText()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r6.setText(r8)
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r6 = r4.f20601f
            r6.setVisibility(r2)
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r6 = r4.f20601f
            int r8 = r3.getTotalTxnCount()
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView.a(r6, r1, r8)
            android.widget.LinearLayout r1 = r4.f20602g
            r1.setVisibility(r5)
            android.widget.TextView r1 = r4.f20598c
            r1.setVisibility(r5)
            android.view.View r1 = r4.f20604i
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            r1.setVisibility(r2)
            android.widget.TextView r1 = r4.j
            r1.setVisibility(r2)
            com.airbnb.lottie.LottieAnimationView r1 = r4.k
            r1.setVisibility(r5)
            android.widget.TextView r1 = r4.j
            net.one97.paytm.vipcashback.a.d$i r2 = new net.one97.paytm.vipcashback.a.d$i
            r2.<init>(r12, r14, r3)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            goto L_0x0436
        L_0x0320:
            net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView r14 = r4.f20601f
            r14.setVisibility(r5)
            android.widget.LinearLayout r14 = r4.f20602g
            r14.setVisibility(r5)
            android.widget.TextView r14 = r4.f20598c
            r14.setVisibility(r2)
            net.one97.paytm.vipcashback.d.a$i$a r14 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r14 = net.one97.paytm.vipcashback.d.a.i.f20815h
            java.lang.String r5 = r3.getGameStatus()
            boolean r14 = r14.equals(r5)
            if (r14 == 0) goto L_0x03eb
            android.widget.TextView r14 = r4.f20600e
            java.lang.String r1 = r3.getGameGratificationMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            r14 = 0
            if (r3 == 0) goto L_0x03a9
            java.util.ArrayList r1 = r3.getMerchantStages()
            if (r1 == 0) goto L_0x03a9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x0360:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x03a6
            java.lang.Object r6 = r1.next()
            r7 = r6
            net.one97.paytm.common.entity.vipcashback.MerchantStage r7 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r7
            java.lang.String r8 = "it"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.util.ArrayList r8 = r7.getTasks()
            if (r8 == 0) goto L_0x037d
            int r8 = r8.size()
            goto L_0x037e
        L_0x037d:
            r8 = 0
        L_0x037e:
            if (r8 <= 0) goto L_0x039f
            net.one97.paytm.vipcashback.d.a$g$a r8 = net.one97.paytm.vipcashback.d.a.g.f20797a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.g.f20800d
            java.util.ArrayList r7 = r7.getTasks()
            if (r7 == 0) goto L_0x0399
            java.lang.Object r7 = r7.get(r2)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r7 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r7
            if (r7 == 0) goto L_0x0399
            java.lang.String r7 = r7.getRedemptionStatus()
            goto L_0x039a
        L_0x0399:
            r7 = r14
        L_0x039a:
            boolean r7 = r8.equals(r7)
            goto L_0x03a0
        L_0x039f:
            r7 = 0
        L_0x03a0:
            if (r7 == 0) goto L_0x0360
            r5.add(r6)
            goto L_0x0360
        L_0x03a6:
            r14 = r5
            java.util.List r14 = (java.util.List) r14
        L_0x03a9:
            if (r14 == 0) goto L_0x03af
            int r2 = r14.size()
        L_0x03af:
            if (r2 <= 0) goto L_0x03c1
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.vipcashback.R.string.lbl_cashback_earned_text
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            goto L_0x03d0
        L_0x03c1:
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.vipcashback.R.string.lbl_cashback_pending_text
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
        L_0x03d0:
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.common.assets.R.color.color_09ac63
            int r1 = androidx.core.content.b.c(r1, r2)
            r14.setTextColor(r1)
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.vipcashback.R.drawable.shape_background_green
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r14.setBackground(r1)
            goto L_0x0436
        L_0x03eb:
            android.widget.TextView r14 = r4.f20600e
            android.content.Context r5 = r12.m
            int r6 = net.one97.paytm.vipcashback.R.string.cashback_offer_expired_on
            java.lang.Object[] r1 = new java.lang.Object[r1]
            net.one97.paytm.vipcashback.f.d$a r7 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r7 = r3.getGameExpiry()
            java.lang.String r8 = "merchantGameItem.gameExpiry"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r7 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r7)
            r1[r2] = r7
            java.lang.String r1 = r5.getString(r6, r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.vipcashback.R.string.lbl_offer_expired
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.common.assets.R.color.color_b8c2cb
            int r1 = androidx.core.content.b.c(r1, r2)
            r14.setTextColor(r1)
            android.widget.TextView r14 = r4.f20598c
            android.content.Context r1 = r12.m
            int r2 = net.one97.paytm.vipcashback.R.drawable.shape_background_grey
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r14.setBackground(r1)
        L_0x0436:
            net.one97.paytm.vipcashback.d.a$i$a r14 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r14 = net.one97.paytm.vipcashback.d.a.i.f20811d
            java.lang.String r1 = r3.getGameStatus()
            boolean r14 = r14.equals(r1)
            if (r14 != 0) goto L_0x04ba
            android.view.View r14 = r13.itemView
            net.one97.paytm.vipcashback.a.d$j r1 = new net.one97.paytm.vipcashback.a.d$j
            r1.<init>(r12, r13, r0)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r14.setOnClickListener(r1)
            return
        L_0x0453:
            boolean r14 = r13 instanceof net.one97.paytm.vipcashback.a.d.f
            if (r14 == 0) goto L_0x04a8
            java.lang.String r14 = r12.p
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            java.lang.String r0 = "context.getString(R.stri…_no_my_offer_but_expired)"
            if (r14 != 0) goto L_0x0481
            boolean r14 = r12.k
            if (r14 == 0) goto L_0x0473
            android.content.Context r14 = r12.m
            int r1 = net.one97.paytm.vipcashback.R.string.cashback_offer_tag_no_my_offer_but_expired
            java.lang.String r14 = r14.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            goto L_0x049e
        L_0x0473:
            android.content.Context r14 = r12.m
            int r0 = net.one97.paytm.vipcashback.R.string.cashback_offer_tag_no_my_offer
            java.lang.String r14 = r14.getString(r0)
            java.lang.String r0 = "context.getString(R.stri…ck_offer_tag_no_my_offer)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            goto L_0x049e
        L_0x0481:
            boolean r14 = r12.k
            if (r14 == 0) goto L_0x0491
            android.content.Context r14 = r12.m
            int r1 = net.one97.paytm.vipcashback.R.string.vip_cashback_no_my_offer_but_expired
            java.lang.String r14 = r14.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            goto L_0x049e
        L_0x0491:
            android.content.Context r14 = r12.m
            int r0 = net.one97.paytm.vipcashback.R.string.vip_cashback_no_my_offer
            java.lang.String r14 = r14.getString(r0)
            java.lang.String r0 = "context.getString(R.stri…vip_cashback_no_my_offer)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
        L_0x049e:
            net.one97.paytm.vipcashback.a.d$f r13 = (net.one97.paytm.vipcashback.a.d.f) r13
            android.widget.TextView r13 = r13.f20610a
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
            return
        L_0x04a8:
            boolean r14 = r13 instanceof net.one97.paytm.vipcashback.a.d.a
            if (r14 == 0) goto L_0x04ba
            net.one97.paytm.vipcashback.a.d$a r13 = (net.one97.paytm.vipcashback.a.d.a) r13
            androidx.cardview.widget.CardView r13 = r13.f20592a
            net.one97.paytm.vipcashback.a.d$k r14 = new net.one97.paytm.vipcashback.a.d$k
            r14.<init>(r12)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r13.setOnClickListener(r14)
        L_0x04ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.a.d.a(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public static final class h implements net.one97.paytm.vipcashback.view.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20619a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f20620b;

        h(d dVar, RecyclerView.v vVar) {
            this.f20619a = dVar;
            this.f20620b = vVar;
        }

        public final void a() {
            a aVar = this.f20619a.f20589b;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.f20553f) {
                a aVar2 = this.f20619a.f20589b;
                if (aVar2 == null) {
                    kotlin.g.b.k.a();
                }
                aVar2.b();
                return;
            }
            ((e) this.f20620b).f20606b.setVisibility(8);
            ((e) this.f20620b).f20605a.setVisibility(8);
        }

        public final void b() {
            a aVar = this.f20619a.f20589b;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.f20553f) {
                a aVar2 = this.f20619a.f20589b;
                if (aVar2 == null) {
                    kotlin.g.b.k.a();
                }
                b.a((b) aVar2);
                return;
            }
            net.one97.paytm.common.widgets.a.b(((e) this.f20620b).f20607c);
        }

        public final void c() {
            a aVar = this.f20619a.f20589b;
            if (aVar != null) {
                aVar.a((kotlin.g.a.a<x>) null);
            }
        }

        static final class a extends l implements kotlin.g.a.a<x> {
            final /* synthetic */ h this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar) {
                super(0);
                this.this$0 = hVar;
            }

            public final void invoke() {
                net.one97.paytm.vipcashback.e.b bVar = this.this$0.f20619a.f20590h;
                if (bVar != null) {
                    bVar.a(this.this$0.f20619a.p, true);
                }
            }
        }

        public final void d() {
            a aVar = this.f20619a.f20589b;
            if (aVar != null) {
                aVar.a((kotlin.g.a.a<x>) new a(this));
            }
        }

        public final void e() {
            this.f20619a.f20591i = false;
            ((e) this.f20620b).f20606b.setVisibility(8);
            ((e) this.f20620b).f20607c.setVisibility(8);
            ((e) this.f20620b).f20605a.setVisibility(0);
        }

        public final void a(CashBackBaseModal cashBackBaseModal, View view) {
            kotlin.g.b.k.c(cashBackBaseModal, Payload.RESPONSE);
            kotlin.g.b.k.c(view, "transitionView");
            if (this.f20619a.n != null && (cashBackBaseModal instanceof MerchantCashBackMyOfferModel)) {
                net.one97.paytm.vipcashback.e.b bVar = this.f20619a.f20590h;
                if (bVar != null) {
                    bVar.a();
                }
                this.f20619a.g();
                d dVar = this.f20619a;
                MerchantGameItem data = ((MerchantCashBackMyOfferModel) cashBackBaseModal).getData();
                kotlin.g.b.k.a((Object) data, "response.data");
                kotlin.g.b.k.c(data, "newData");
                dVar.o.add(0, data);
                dVar.notifyItemInserted(dVar.f20588a + 0);
                dVar.c();
                c cVar = this.f20619a.n;
                if (cVar != null) {
                    cVar.a(this.f20619a.f20588a);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
            r2 = r2.f20836a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal r13, android.view.View r14) {
            /*
                r12 = this;
                java.lang.String r0 = "offer"
                kotlin.g.b.k.c(r13, r0)
                java.lang.String r0 = "transitionView"
                kotlin.g.b.k.c(r14, r0)
                net.one97.paytm.vipcashback.a.d r0 = r12.f20619a
                net.one97.paytm.vipcashback.a.d$c r0 = r0.n
                if (r0 != 0) goto L_0x0011
                return
            L_0x0011:
                com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
                r0.<init>()
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r1 = new net.one97.paytm.common.entity.vipcashback.MerchantGameItem
                r1.<init>()
                java.lang.String r2 = r0.a((java.lang.Object) r13)
                java.lang.Class<net.one97.paytm.cashback.posttxn.Campaign> r3 = net.one97.paytm.cashback.posttxn.Campaign.class
                java.lang.Object r0 = r0.a((java.lang.String) r2, r3)
                net.one97.paytm.cashback.posttxn.Campaign r0 = (net.one97.paytm.cashback.posttxn.Campaign) r0
                java.lang.String r2 = "campaign"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                net.one97.paytm.vipcashback.a.d r2 = r12.f20619a
                net.one97.paytm.vipcashback.e.b r2 = r2.f20590h
                if (r2 == 0) goto L_0x003b
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal> r2 = r2.f20836a
                if (r2 == 0) goto L_0x003b
                int r13 = r2.indexOf(r13)
                goto L_0x003c
            L_0x003b:
                r13 = 0
            L_0x003c:
                r0.setNewOffersListPosition(r13)
                r1.setCampaign(r0)
                net.one97.paytm.vipcashback.a.d r13 = r12.f20619a
                net.one97.paytm.vipcashback.a.d$c r13 = r13.n
                if (r13 == 0) goto L_0x0060
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity$a r0 = net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity.f20667a
                java.lang.String r0 = net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity.I
                net.one97.paytm.vipcashback.a.d r2 = r12.f20619a
                android.content.Context r2 = r2.m
                int r3 = net.one97.paytm.vipcashback.R.string.transition_cashback_card
                java.lang.String r2 = r2.getString(r3)
                java.lang.String r3 = "context.getString(R.stri…transition_cashback_card)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r13.a(r1, r0, r14, r2)
            L_0x0060:
                net.one97.paytm.vipcashback.c.b r4 = net.one97.paytm.vipcashback.c.a.b()
                net.one97.paytm.vipcashback.a.d r13 = r12.f20619a
                android.content.Context r5 = r13.m
                r8 = 0
                r9 = 0
                java.lang.String r6 = "cashback_offers_merchant"
                java.lang.String r7 = "cashback_offer_card_clicked"
                java.lang.String r10 = "/cashback-offers/merchant"
                java.lang.String r11 = "cashback"
                r4.sendNewCustomGTMEventsWithMultipleLabel(r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.a.d.h.a(net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal, android.view.View):void");
        }

        public final void a(int i2, int i3) {
            c cVar = this.f20619a.n;
            if (cVar != null) {
                cVar.a(true);
            }
            a aVar = this.f20619a.f20589b;
            if (aVar != null) {
                aVar.notifyItemRangeInserted(i2, i3);
            }
        }

        public final void a(int i2) {
            a aVar = this.f20619a.f20589b;
            if (aVar != null) {
                aVar.notifyItemRemoved(i2);
            }
        }

        public final void f() {
            c cVar = this.f20619a.n;
            if (cVar != null) {
                cVar.a(true);
            }
            a aVar = this.f20619a.f20589b;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }

        public final void g() {
            d dVar = this.f20619a;
            dVar.f20591i = true;
            dVar.f();
            this.f20619a.notifyDataSetChanged();
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            c cVar = this.f20619a.n;
            if (cVar != null) {
                cVar.a(networkCustomError);
            }
        }

        public final void a(com.paytm.network.a aVar) {
            kotlin.g.b.k.c(aVar, "networkCall");
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a(this.f20619a.m, aVar, false);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20621a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20622b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MerchantGameItem f20623c;

        i(d dVar, int i2, MerchantGameItem merchantGameItem) {
            this.f20621a = dVar;
            this.f20622b = i2;
            this.f20623c = merchantGameItem;
        }

        public final void onClick(View view) {
            c cVar = this.f20621a.n;
            if (cVar != null) {
                cVar.a(this.f20622b, this.f20623c);
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f20625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f20626c;

        j(d dVar, RecyclerView.v vVar, int i2) {
            this.f20624a = dVar;
            this.f20625b = vVar;
            this.f20626c = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f20624a.n;
            if (cVar != null) {
                cVar.a((View) ((C0377d) this.f20625b).f20596a, this.f20626c);
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20624a.m, "cashback_offers_merchant", "in_progress_offer_clicked", (ArrayList<String>) null, (String) null, "/cashback-offers/merchant", "cashback");
            View view2 = this.f20625b.itemView;
            kotlin.g.b.k.a((Object) view2, "holder.itemView");
            view2.setEnabled(false);
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ j f20627a;

                {
                    this.f20627a = r1;
                }

                public final void run() {
                    View view = this.f20627a.f20625b.itemView;
                    kotlin.g.b.k.a((Object) view, "holder.itemView");
                    view.setEnabled(true);
                }
            }, 400);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20628a;

        k(d dVar) {
            this.f20628a = dVar;
        }

        public final void onClick(View view) {
            c cVar = this.f20628a.n;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final void a(boolean z) {
        ArrayList<CashBackNewOfferModal> arrayList;
        if (this.s) {
            this.f20591i = false;
            net.one97.paytm.vipcashback.e.b bVar = this.f20590h;
            if (bVar != null) {
                bVar.f20837b = 0;
            }
            net.one97.paytm.vipcashback.e.b bVar2 = this.f20590h;
            if (bVar2 != null) {
                bVar2.f20838c = 1;
            }
            net.one97.paytm.vipcashback.d.a aVar = this.r;
            if (aVar == null) {
                kotlin.g.b.k.a("newOfferVIPCashbackDataModel");
            }
            aVar.j = 1;
            net.one97.paytm.vipcashback.e.b bVar3 = this.f20590h;
            if (!(bVar3 == null || (arrayList = bVar3.f20836a) == null)) {
                arrayList.clear();
            }
            a aVar2 = this.f20589b;
            if (aVar2 != null) {
                aVar2.notifyDataSetChanged();
            }
            net.one97.paytm.vipcashback.e.b bVar4 = this.f20590h;
            if (bVar4 != null) {
                bVar4.a(this.p, z);
            }
        }
    }

    public final void c() {
        this.t = this.o.size() == 0;
        notifyItemChanged(3);
    }

    public final void d() {
        this.u = true;
        f();
    }

    public final void e() {
        this.o.clear();
        this.t = false;
        notifyDataSetChanged();
    }

    public final void f() {
        c cVar;
        if (this.t && this.f20591i && this.u && (cVar = this.n) != null) {
            cVar.a(false);
        }
    }

    public final int a() {
        int i2;
        if (this.l) {
            return 0;
        }
        g();
        if (!this.t || !this.o.isEmpty()) {
            i2 = this.o.size();
        } else {
            i2 = 1;
        }
        if (this.k && !this.j) {
            i2++;
        }
        return this.f20588a + i2;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (this.f20591i) {
            this.f20588a = 1;
        } else {
            this.f20588a = 3;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        if (this.k && !this.j && i2 == getItemCount() - 1) {
            g.a aVar = g.f20613a;
            return g.f20618f;
        } else if (!this.f20591i) {
            if (i2 != 0) {
                if (i2 == 1) {
                    g.a aVar2 = g.f20613a;
                    return g.f20615c;
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        g.a aVar3 = g.f20613a;
                        return g.f20616d;
                    } else if (this.o.size() > 0) {
                        g.a aVar4 = g.f20613a;
                        return g.f20616d;
                    } else {
                        g.a aVar5 = g.f20613a;
                        return g.f20617e;
                    }
                }
            }
            g.a aVar6 = g.f20613a;
            return g.f20614b;
        } else if (i2 == 0) {
            g.a aVar7 = g.f20613a;
            return g.f20614b;
        } else if (i2 != 1) {
            g.a aVar8 = g.f20613a;
            return g.f20616d;
        } else if (this.o.size() > 0) {
            g.a aVar9 = g.f20613a;
            return g.f20616d;
        } else {
            g.a aVar10 = g.f20613a;
            return g.f20617e;
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f20594a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f20595b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f20595b = dVar;
            View findViewById = view.findViewById(R.id.tv_heading);
            if (findViewById != null) {
                this.f20594a = (TextView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f20605a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f20606b;

        /* renamed from: c  reason: collision with root package name */
        LottieAnimationView f20607c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f20608d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f20609e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f20608d = dVar;
            View findViewById = view.findViewById(R.id.OffersRv);
            if (findViewById != null) {
                this.f20605a = (RecyclerView) findViewById;
                View findViewById2 = view.findViewById(R.id.ll_no_offer);
                if (findViewById2 != null) {
                    this.f20606b = (LinearLayout) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_no_offer);
                    if (findViewById3 != null) {
                        this.f20609e = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.loader);
                        if (findViewById4 != null) {
                            this.f20607c = (LottieAnimationView) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.a.d$d  reason: collision with other inner class name */
    public final class C0377d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CircularImageView f20596a;

        /* renamed from: b  reason: collision with root package name */
        CircularImageView f20597b;

        /* renamed from: c  reason: collision with root package name */
        TextView f20598c;

        /* renamed from: d  reason: collision with root package name */
        TextView f20599d;

        /* renamed from: e  reason: collision with root package name */
        TextView f20600e;

        /* renamed from: f  reason: collision with root package name */
        NewHorizontalProgressTimelineView f20601f;

        /* renamed from: g  reason: collision with root package name */
        LinearLayout f20602g;

        /* renamed from: h  reason: collision with root package name */
        TextView f20603h;

        /* renamed from: i  reason: collision with root package name */
        View f20604i;
        TextView j;
        LottieAnimationView k;
        final /* synthetic */ d l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0377d(d dVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.l = dVar;
            View findViewById = view.findViewById(R.id.iv_icon);
            if (findViewById != null) {
                this.f20596a = (CircularImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.iv_bg);
                if (findViewById2 != null) {
                    this.f20597b = (CircularImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_offer_complete);
                    if (findViewById3 != null) {
                        this.f20598c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.tv_title);
                        if (findViewById4 != null) {
                            this.f20599d = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.tv_sub_title);
                            if (findViewById5 != null) {
                                this.f20600e = (TextView) findViewById5;
                                View findViewById6 = view.findViewById(R.id.ll_timeline_progress);
                                if (findViewById6 != null) {
                                    this.f20601f = (NewHorizontalProgressTimelineView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.ll_success_txn);
                                    if (findViewById7 != null) {
                                        this.f20602g = (LinearLayout) findViewById7;
                                        View findViewById8 = view.findViewById(R.id.tv_success_txn);
                                        if (findViewById8 != null) {
                                            this.f20603h = (TextView) findViewById8;
                                            this.f20604i = view.findViewById(R.id.rl_activate);
                                            View findViewById9 = view.findViewById(R.id.activate_offer);
                                            if (findViewById9 != null) {
                                                this.j = (TextView) findViewById9;
                                                View findViewById10 = view.findViewById(R.id.activate_loader);
                                                if (findViewById10 != null) {
                                                    this.k = (LottieAnimationView) findViewById10;
                                                    return;
                                                }
                                                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                                            }
                                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                                        }
                                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.vipcashback.widget.NewHorizontalProgressTimelineView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.widgets.CircularImageView");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.widgets.CircularImageView");
        }
    }

    public final class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f20610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f20611b;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f20612c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f20611b = dVar;
            View findViewById = view.findViewById(R.id.ll_no_offer);
            if (findViewById != null) {
                this.f20612c = (LinearLayout) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_no_offer);
                if (findViewById2 != null) {
                    this.f20610a = (TextView) findViewById2;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CardView f20592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f20593b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f20593b = dVar;
            View findViewById = view.findViewById(R.id.expired_btn);
            if (findViewById != null) {
                this.f20592a = (CardView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.cardview.widget.CardView");
        }
    }
}
