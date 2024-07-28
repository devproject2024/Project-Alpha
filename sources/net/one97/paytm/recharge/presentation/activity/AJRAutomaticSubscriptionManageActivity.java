package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.AutomaticProductInfo;
import net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel;
import net.one97.paytm.recharge.presentation.b.a;
import net.one97.paytm.recharge.presentation.b.d;
import net.one97.paytm.recharge.presentation.b.e;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class AJRAutomaticSubscriptionManageActivity extends PaytmActivity implements a.C1275a, d.b, e.c {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.g.a f64679a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRAutomaticSubscriptionItemModel f64680b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AutomaticSubscriptionSavedCard f64681c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f64682d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f64683e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f64684f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f64685g;

    /* renamed from: h  reason: collision with root package name */
    private String f64686h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.b.d f64687i;
    private String j;
    private String k;
    private Bundle l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public final int n = 101;
    /* access modifiers changed from: private */
    public final int o = 102;
    private final int p = 103;
    private final int q = 104;
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionItemModel>, x> {
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            super(1);
            this.this$0 = aJRAutomaticSubscriptionManageActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionItemModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionItemModel> bVar) {
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel;
            if (bVar != null && (cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) bVar.f64954b) != null) {
                int status = cJRAutomaticSubscriptionItemModel.getStatus();
                CJRAutomaticSubscriptionItemModel a2 = this.this$0.f64680b;
                if (a2 == null || status != a2.getStatus()) {
                    this.this$0.f64680b = cJRAutomaticSubscriptionItemModel;
                    AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity = this.this$0;
                    CJRAutomaticSubscriptionItemModel a3 = aJRAutomaticSubscriptionManageActivity.f64680b;
                    if (a3 == null) {
                        k.a();
                    }
                    aJRAutomaticSubscriptionManageActivity.d(a3);
                }
            }
        }
    }

    static final class b extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel>, x> {
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            super(1);
            this.this$0 = aJRAutomaticSubscriptionManageActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel> bVar) {
            net.one97.paytm.recharge.presentation.g.c cVar;
            CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel;
            if (bVar != null) {
                cVar = bVar.f64955c;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int[] iArr = e.f64715a;
                cVar.ordinal();
            }
            if (bVar != null && (cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) bVar.f64954b) != null) {
                AJRAutomaticSubscriptionManageActivity.a(this.this$0, cJRAutomaticSubscriptionListModel);
            }
        }
    }

    static final class c extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel>, x> {
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            super(1);
            this.this$0 = aJRAutomaticSubscriptionManageActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel> bVar) {
            net.one97.paytm.recharge.presentation.g.c cVar;
            NetworkCustomError networkCustomError;
            CJRAutomaticSubscriptionSavedCardsModel cJRAutomaticSubscriptionSavedCardsModel;
            int i2;
            if (bVar != null) {
                cVar = bVar.f64955c;
            } else {
                cVar = null;
            }
            if (!(cVar == null || (i2 = e.f64716b[cVar.ordinal()]) == 1 || i2 != 2)) {
                AJRAutomaticSubscriptionManageActivity.b(this.this$0);
            }
            if (!(bVar == null || (cJRAutomaticSubscriptionSavedCardsModel = (CJRAutomaticSubscriptionSavedCardsModel) bVar.f64954b) == null)) {
                new StringBuilder("response ").append(cJRAutomaticSubscriptionSavedCardsModel);
                AJRAutomaticSubscriptionManageActivity.a(this.this$0, (ArrayList) cJRAutomaticSubscriptionSavedCardsModel.getData());
            }
            if (bVar != null && (networkCustomError = bVar.f64953a) != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.this$0, networkCustomError, 1014);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0180, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.AI_KEY_PPBL, r8 != null ? r8.getPaymentBank() : null, true) == false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a4, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.TYPE_BANK_MANDATE, r8 != null ? r8.getPaymentMode() : null, true) != false) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a6, code lost:
        a((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            int r8 = net.one97.paytm.recharge.automatic.R.layout.activity_manage_automatic
            r7.setContentView((int) r8)
            androidx.appcompat.app.ActionBar r8 = r7.getSupportActionBar()
            r0 = 1
            if (r8 == 0) goto L_0x0012
            r8.b((boolean) r0)
        L_0x0012:
            androidx.appcompat.app.ActionBar r8 = r7.getSupportActionBar()
            if (r8 == 0) goto L_0x001f
            java.lang.String r1 = ""
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.a((java.lang.CharSequence) r1)
        L_0x001f:
            android.view.Window r8 = r7.getWindow()
            r1 = 0
            if (r8 == 0) goto L_0x002b
            android.view.View r8 = r8.getDecorView()
            goto L_0x002c
        L_0x002b:
            r8 = r1
        L_0x002c:
            boolean r2 = r8 instanceof android.view.ViewGroup
            if (r2 != 0) goto L_0x0031
            r8 = r1
        L_0x0031:
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r3 = 24
            int r3 = com.paytm.utility.b.c((int) r3)
            r4 = 0
            r2.setMargins(r4, r3, r4, r4)
            r3 = r7
            android.content.Context r3 = (android.content.Context) r3
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r3)
            int r6 = net.one97.paytm.recharge.automatic.R.layout.lyt_manage_automatic_status_view
            android.view.View r4 = r5.inflate(r6, r1, r4)
            r7.f64684f = r4
            if (r8 == 0) goto L_0x005c
            android.view.View r4 = r7.f64684f
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r8.addView(r4, r2)
        L_0x005c:
            android.content.Intent r8 = r7.getIntent()
            if (r8 == 0) goto L_0x0067
            android.os.Bundle r8 = r8.getExtras()
            goto L_0x0068
        L_0x0067:
            r8 = r1
        L_0x0068:
            r7.l = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r2 = "selected_automatic_subscribed_item"
            java.io.Serializable r8 = r8.getSerializableExtra(r2)
            boolean r2 = r8 instanceof net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel
            if (r2 != 0) goto L_0x007a
            r8 = r1
        L_0x007a:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r8
            r7.f64680b = r8
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x0087
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel r8 = r8.getProduct()
            goto L_0x0088
        L_0x0087:
            r8 = r1
        L_0x0088:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            if (r8 == 0) goto L_0x00a9
            java.lang.String r6 = r8.getService()
            if (r6 == 0) goto L_0x00a9
            if (r6 == 0) goto L_0x00a3
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            goto L_0x00aa
        L_0x00a3:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x00a9:
            r6 = r1
        L_0x00aa:
            r2.append(r6)
            java.lang.String r6 = "_"
            r2.append(r6)
            if (r8 == 0) goto L_0x00ca
            java.lang.String r8 = r8.getPaytype()
            if (r8 == 0) goto L_0x00ca
            if (r8 == 0) goto L_0x00c4
            java.lang.String r8 = r8.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            goto L_0x00cb
        L_0x00c4:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x00ca:
            r8 = r1
        L_0x00cb:
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r7.m = r8
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x00e3
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r8 = r8.getPaymentInfo()
            if (r8 == 0) goto L_0x00e3
            java.lang.String r8 = r8.getSavedCardId()
            goto L_0x00e4
        L_0x00e3:
            r8 = r1
        L_0x00e4:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r2 = r7.f64680b
            if (r2 == 0) goto L_0x00f3
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r2 = r2.getPaymentInfo()
            if (r2 == 0) goto L_0x00f3
            java.lang.String r2 = r2.getCardNumber()
            goto L_0x00f4
        L_0x00f3:
            r2 = r1
        L_0x00f4:
            r7.k = r2
            r7.j = r8
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x00ff
            r7.b((net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r8)
        L_0x00ff:
            net.one97.paytm.recharge.automatic.c.a.a r8 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            net.one97.paytm.recharge.automatic.b.a.a$a r8 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r8 = net.one97.paytm.recharge.automatic.b.a.a.W
            net.one97.paytm.recharge.automatic.c.a.a.a((android.content.Context) r3, (java.lang.String) r8)
            r8 = r7
            androidx.fragment.app.FragmentActivity r8 = (androidx.fragment.app.FragmentActivity) r8
            net.one97.paytm.recharge.presentation.e.a r2 = new net.one97.paytm.recharge.presentation.e.a
            r2.<init>()
            androidx.lifecycle.al$b r2 = (androidx.lifecycle.al.b) r2
            androidx.lifecycle.al r8 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r8, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.recharge.presentation.g.a> r2 = net.one97.paytm.recharge.presentation.g.a.class
            androidx.lifecycle.ai r8 = r8.a(r2)
            net.one97.paytm.recharge.presentation.g.a r8 = (net.one97.paytm.recharge.presentation.g.a) r8
            r7.f64679a = r8
            net.one97.paytm.recharge.presentation.g.a r8 = r7.f64679a
            if (r8 == 0) goto L_0x0129
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel>> r8 = r8.f64932i
            goto L_0x012a
        L_0x0129:
            r8 = r1
        L_0x012a:
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$a r2 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$a
            r2.<init>(r7)
            kotlin.g.a.b r2 = (kotlin.g.a.b) r2
            net.one97.paytm.recharge.automatic.b.a.d.a(r7, r8, r2)
            net.one97.paytm.recharge.presentation.g.a r8 = r7.f64679a
            if (r8 == 0) goto L_0x013d
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel>> r8 = r8.f64924a
            goto L_0x013e
        L_0x013d:
            r8 = r1
        L_0x013e:
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$b r2 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$b
            r2.<init>(r7)
            kotlin.g.a.b r2 = (kotlin.g.a.b) r2
            net.one97.paytm.recharge.automatic.b.a.d.a(r7, r8, r2)
            net.one97.paytm.recharge.presentation.g.a r8 = r7.f64679a
            if (r8 == 0) goto L_0x0151
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel>> r8 = r8.k
            goto L_0x0152
        L_0x0151:
            r8 = r1
        L_0x0152:
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$c r2 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$c
            r2.<init>(r7)
            kotlin.g.a.b r2 = (kotlin.g.a.b) r2
            net.one97.paytm.recharge.automatic.b.a.d.a(r7, r8, r2)
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x0167
            java.lang.String r8 = r8.getPaymentBank()
            goto L_0x0168
        L_0x0167:
            r8 = r1
        L_0x0168:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0182
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x0179
            java.lang.String r8 = r8.getPaymentBank()
            goto L_0x017a
        L_0x0179:
            r8 = r1
        L_0x017a:
            java.lang.String r2 = "PPBL"
            boolean r8 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r0)
            if (r8 != 0) goto L_0x01a6
        L_0x0182:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x018b
            java.lang.String r8 = r8.getPaymentMode()
            goto L_0x018c
        L_0x018b:
            r8 = r1
        L_0x018c:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01aa
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64680b
            if (r8 == 0) goto L_0x019d
            java.lang.String r8 = r8.getPaymentMode()
            goto L_0x019e
        L_0x019d:
            r8 = r1
        L_0x019e:
            java.lang.String r2 = "BANK_MANDATE"
            boolean r8 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r0)
            if (r8 == 0) goto L_0x01aa
        L_0x01a6:
            r7.a((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r1)
            return
        L_0x01aa:
            java.lang.String r8 = r7.j
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x01be
            java.lang.String r8 = r7.k
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01c1
        L_0x01be:
            r7.a()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity.onCreate(android.os.Bundle):void");
    }

    private final void a() {
        net.one97.paytm.recharge.presentation.g.a aVar;
        Context context = this;
        if (com.paytm.utility.d.c(context) && (aVar = this.f64679a) != null) {
            aVar.b(context);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.AI_KEY_PPBL, r4 != null ? r4.getPaymentBank() : null, true) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cc, code lost:
        if (r1 == null) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r9) {
        /*
            r8 = this;
            java.lang.String r0 = "BANK_MANDATE"
            java.lang.String r1 = "PPBL"
            r2 = 1
            r3 = 0
            if (r9 != 0) goto L_0x0061
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r8.f64680b
            if (r4 == 0) goto L_0x0011
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x0012
        L_0x0011:
            r4 = r3
        L_0x0012:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x002a
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r8.f64680b
            if (r4 == 0) goto L_0x0023
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x0024
        L_0x0023:
            r4 = r3
        L_0x0024:
            boolean r4 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r2)
            if (r4 != 0) goto L_0x0061
        L_0x002a:
            java.lang.String r4 = r8.j
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = r8.k
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0061
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r8.f64680b
            if (r4 == 0) goto L_0x0047
            java.lang.String r4 = r4.getPaymentMode()
            goto L_0x0048
        L_0x0047:
            r4 = r3
        L_0x0048:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0060
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r8.f64680b
            if (r4 == 0) goto L_0x0059
            java.lang.String r4 = r4.getPaymentMode()
            goto L_0x005a
        L_0x0059:
            r4 = r3
        L_0x005a:
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r2)
            if (r4 != 0) goto L_0x0061
        L_0x0060:
            return
        L_0x0061:
            r8.f64681c = r9
            java.lang.String r4 = ""
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r6 = 0
            if (r9 == 0) goto L_0x0164
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r8.f64680b
            if (r0 == 0) goto L_0x009b
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x009b
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x008e
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r2 = r8.f64681c
            if (r2 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            java.lang.String r0 = r0.getMaskedCardNumber((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x008e:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x009b
            r0.setVisibility(r6)
        L_0x009b:
            java.lang.String r0 = r9.getIssuerDisplayName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0128
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.util.HashMap r0 = net.one97.paytm.recharge.widgets.c.d.a()
            java.lang.String r1 = r9.getCardType()
            if (r1 == 0) goto L_0x00dd
            if (r1 == 0) goto L_0x00d5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.m.p.b(r1)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x00dd
            if (r1 == 0) goto L_0x00cf
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            if (r1 != 0) goto L_0x00de
            goto L_0x00dd
        L_0x00cf:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r5)
            throw r9
        L_0x00d5:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r9.<init>(r0)
            throw r9
        L_0x00dd:
            r1 = r4
        L_0x00de:
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0115
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0128
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.getIssuerDisplayName()
            r2.append(r3)
            java.lang.String r3 = " - "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x0128
        L_0x0115:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0128
            java.lang.String r1 = r9.getIssuerDisplayName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0128:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0155
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.recharge.automatic.b.a.h$a r2 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r9 = r9.getCardScheme()
            if (r9 != 0) goto L_0x0140
            kotlin.g.b.k.a()
        L_0x0140:
            java.lang.Integer r9 = net.one97.paytm.recharge.automatic.b.a.h.a.g(r9)
            if (r9 == 0) goto L_0x014b
            int r9 = r9.intValue()
            goto L_0x014e
        L_0x014b:
            r9 = 17170445(0x106000d, float:2.461195E-38)
        L_0x014e:
            android.graphics.drawable.Drawable r9 = androidx.core.content.b.a((android.content.Context) r1, (int) r9)
            r0.setImageDrawable(r9)
        L_0x0155:
            int r9 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x043c
            r9.setVisibility(r6)
            goto L_0x043c
        L_0x0164:
            java.lang.String r9 = r8.j
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            r7 = 8
            if (r9 == 0) goto L_0x03d5
            java.lang.String r9 = r8.k
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x017c
            goto L_0x03d5
        L_0x017c:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x0185
            java.lang.String r9 = r9.getPaymentBank()
            goto L_0x0186
        L_0x0185:
            r9 = r3
        L_0x0186:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            if (r9 != 0) goto L_0x0251
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x0199
            java.lang.String r9 = r9.getPaymentBank()
            goto L_0x019a
        L_0x0199:
            r9 = r3
        L_0x019a:
            boolean r9 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r9, (boolean) r2)
            if (r9 == 0) goto L_0x0251
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x01b5
            int r0 = net.one97.paytm.recharge.automatic.R.string.paytm_payment_bank
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x01b5:
            r9 = r8
            android.content.Context r9 = (android.content.Context) r9
            java.lang.String r0 = com.paytm.utility.b.l((android.content.Context) r9)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0222
            java.lang.String r1 = "userMobileNumber"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = r0.length()
            int r1 = r1 + -4
            int r2 = r0.length()
            if (r0 == 0) goto L_0x021c
            java.lang.String r0 = r0.substring(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x020e
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0200
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "XX "
            java.lang.String r0 = r2.concat(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x0200:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x022f
            r0.setVisibility(r6)
            goto L_0x022f
        L_0x020e:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x022f
            r0.setVisibility(r7)
            goto L_0x022f
        L_0x021c:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r5)
            throw r9
        L_0x0222:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x022f
            r0.setVisibility(r7)
        L_0x022f:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0242
            int r1 = net.one97.paytm.recharge.automatic.R.drawable.ic_recharge_paytm_logo
            android.graphics.drawable.Drawable r9 = androidx.core.content.b.a((android.content.Context) r9, (int) r1)
            r0.setImageDrawable(r9)
        L_0x0242:
            int r9 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x043c
            r9.setVisibility(r6)
            goto L_0x043c
        L_0x0251:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x025a
            java.lang.String r9 = r9.getPaymentMode()
            goto L_0x025b
        L_0x025a:
            r9 = r3
        L_0x025b:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x043c
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = r9.getPaymentMode()
            goto L_0x026d
        L_0x026c:
            r9 = r3
        L_0x026d:
            boolean r9 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r9, (boolean) r2)
            if (r9 == 0) goto L_0x043c
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x027c
            java.lang.String r9 = r9.getPaymentBank()
            goto L_0x027d
        L_0x027c:
            r9 = r3
        L_0x027d:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x03d1
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x0294
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r9 = r9.getPaymentInfo()
            if (r9 == 0) goto L_0x0294
            java.lang.String r9 = r9.getMaskedAccountNumber()
            goto L_0x0295
        L_0x0294:
            r9 = r3
        L_0x0295:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x029f
            goto L_0x03d1
        L_0x029f:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x02a8
            java.lang.String r9 = r9.getPaymentBank()
            goto L_0x02a9
        L_0x02a8:
            r9 = r3
        L_0x02a9:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x02e5
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x02fa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r1 = r8.f64680b
            if (r1 == 0) goto L_0x02c9
            java.lang.String r1 = r1.getPaymentBank()
            goto L_0x02ca
        L_0x02c9:
            r1 = r3
        L_0x02ca:
            r0.append(r1)
            r1 = 32
            r0.append(r1)
            int r1 = net.one97.paytm.recharge.automatic.R.string.paytm_bank_emandate
            java.lang.String r1 = r8.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            goto L_0x02fa
        L_0x02e5:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x02fa
            int r0 = net.one97.paytm.recharge.automatic.R.string.paytm_bank_emandate
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x02fa:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x0309
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r9 = r9.getPaymentInfo()
            if (r9 == 0) goto L_0x0309
            java.lang.String r9 = r9.getMaskedAccountNumber()
            goto L_0x030a
        L_0x0309:
            r9 = r3
        L_0x030a:
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x036e
            if (r9 == 0) goto L_0x032f
            int r0 = r9.length()
            int r0 = r0 + -4
            int r1 = r9.length()
            if (r9 == 0) goto L_0x0329
            java.lang.String r9 = r9.substring(r0, r1)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            goto L_0x0330
        L_0x0329:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r5)
            throw r9
        L_0x032f:
            r9 = r3
        L_0x0330:
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0360
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0352
            int r1 = net.one97.paytm.recharge.automatic.R.string.label_account_number
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r6] = r9
            java.lang.String r9 = r8.getString(r1, r2)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x0352:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x037b
            r9.setVisibility(r6)
            goto L_0x037b
        L_0x0360:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x037b
            r9.setVisibility(r7)
            goto L_0x037b
        L_0x036e:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x037b
            r9.setVisibility(r7)
        L_0x037b:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            if (r9 == 0) goto L_0x038a
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r9 = r9.getPaymentInfo()
            if (r9 == 0) goto L_0x038a
            java.lang.String r9 = r9.getBankLogo()
            goto L_0x038b
        L_0x038a:
            r9 = r3
        L_0x038b:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x03c3
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r8.f64680b
            if (r0 == 0) goto L_0x03a5
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x03a5
            java.lang.String r3 = r0.getBankLogo()
        L_0x03a5:
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r3)
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r9.a((android.widget.ImageView) r0)
            int r9 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x043c
            r9.setVisibility(r6)
            goto L_0x043c
        L_0x03c3:
            int r9 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x043c
            r9.setVisibility(r7)
            goto L_0x043c
        L_0x03d1:
            r8.c()
            return
        L_0x03d5:
            android.text.SpannableString r9 = new android.text.SpannableString
            int r0 = net.one97.paytm.recharge.automatic.R.string.pa_error_payment_mode_deleted
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.<init>(r0)
            java.lang.String r0 = "sans-serif"
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r6)
            com.paytm.utility.CustomTypefaceSpan r1 = new com.paytm.utility.CustomTypefaceSpan
            r1.<init>(r4, r0)
            int r0 = r9.length()
            r2 = 33
            r9.setSpan(r1, r6, r0, r2)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0.<init>(r1)
            int r1 = r9.length()
            r9.setSpan(r0, r6, r1, r2)
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            r1 = 1063675494(0x3f666666, float:0.9)
            r0.<init>(r1)
            int r1 = r9.length()
            r9.setSpan(r0, r6, r1, r2)
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0422
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x0422:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x042f
            r9.setVisibility(r7)
        L_0x042f:
            int r9 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r8.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x043c
            r9.setVisibility(r7)
        L_0x043c:
            int r9 = net.one97.paytm.recharge.automatic.R.id.bank_lyt
            android.view.View r9 = r8.a((int) r9)
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0449
            r9.setVisibility(r6)
        L_0x0449:
            int r9 = net.one97.paytm.recharge.automatic.R.id.bank_lyt
            android.view.View r9 = r8.a((int) r9)
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x045d
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$h r0 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity$h
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x045d:
            r8.d()
            r8.b()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r9 = r8.f64680b
            r8.a((net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity.a(net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard):void");
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity f64693a;

        h(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            this.f64693a = aJRAutomaticSubscriptionManageActivity;
        }

        public final void onClick(View view) {
            CJRAutomaticSubscriptionProductModel product;
            CJRAutomaticSubscriptionProductModel product2;
            CJRAutomaticSubscriptionProductModel product3;
            CJRAutomaticSubscriptionProductModel product4;
            String str;
            AutomaticProductInfo paymentInfo;
            AutomaticProductInfo paymentInfo2;
            AutomaticProductInfo paymentInfo3;
            AutomaticProductInfo paymentInfo4;
            CJRAutomaticSubscriptionProductModel product5;
            AutomaticProductInfo paymentInfo5;
            CJRAutomaticSubscriptionProductModel product6;
            CJRFrequentOrder cJRFrequentOrder = new CJRFrequentOrder();
            CJRAutomaticSubscriptionItemModel a2 = this.f64693a.f64680b;
            String str2 = null;
            cJRFrequentOrder.setRechargeNumber(a2 != null ? a2.getRechargeNumber() : null);
            CJRAutomaticSubscriptionItemModel a3 = this.f64693a.f64680b;
            cJRFrequentOrder.setName(a3 != null ? a3.getNickname() : null);
            CJRAutomaticSubscriptionItemModel a4 = this.f64693a.f64680b;
            cJRFrequentOrder.setOperatorLogoURL((a4 == null || (product6 = a4.getProduct()) == null) ? null : product6.getThumbnail());
            Intent intent = new Intent(this.f64693a, AJRAutomaticSetupActivity.class);
            intent.putExtra("selected_recent", cJRFrequentOrder);
            CJRAutomaticSubscriptionItemModel a5 = this.f64693a.f64680b;
            intent.putExtra(CLPConstants.PRODUCT_ID, a5 != null ? String.valueOf(a5.getProductId()) : null);
            intent.putExtra("from", "manage_screen");
            CJRAutomaticSubscriptionItemModel a6 = this.f64693a.f64680b;
            intent.putExtra(UpiConstants.EXTRA_SUBSCRIPTION_ID, a6 != null ? String.valueOf(a6.getSubscriptionId()) : null);
            intent.putExtra("key_action", this.f64693a.o);
            CJRAutomaticSubscriptionItemModel a7 = this.f64693a.f64680b;
            intent.putExtra("card_id", (a7 == null || (paymentInfo5 = a7.getPaymentInfo()) == null) ? null : paymentInfo5.getSavedCardId());
            CJRAutomaticSubscriptionItemModel a8 = this.f64693a.f64680b;
            intent.putExtra("key_payment_bank", a8 != null ? a8.getPaymentBank() : null);
            CJRAutomaticSubscriptionItemModel a9 = this.f64693a.f64680b;
            intent.putExtra("key_bank_mandate", a9 != null ? a9.getPaymentMode() : null);
            CJRAutomaticSubscriptionItemModel a10 = this.f64693a.f64680b;
            intent.putExtra("operator_name", (a10 == null || (product5 = a10.getProduct()) == null) ? null : product5.getOperator());
            CJRAutomaticSubscriptionItemModel a11 = this.f64693a.f64680b;
            intent.putExtra("operator_logo", (a11 == null || (paymentInfo4 = a11.getPaymentInfo()) == null) ? null : paymentInfo4.getBankLogo());
            CJRAutomaticSubscriptionItemModel a12 = this.f64693a.f64680b;
            intent.putExtra("first_four_digits", (a12 == null || (paymentInfo3 = a12.getPaymentInfo()) == null) ? null : paymentInfo3.getFirstFourDigits());
            CJRAutomaticSubscriptionItemModel a13 = this.f64693a.f64680b;
            intent.putExtra("last_four_digits", (a13 == null || (paymentInfo2 = a13.getPaymentInfo()) == null) ? null : paymentInfo2.getLastFourDigits());
            CJRAutomaticSubscriptionItemModel a14 = this.f64693a.f64680b;
            String maskedAccountNumber = (a14 == null || (paymentInfo = a14.getPaymentInfo()) == null) ? null : paymentInfo.getMaskedAccountNumber();
            if (!TextUtils.isEmpty(maskedAccountNumber)) {
                if (maskedAccountNumber != null) {
                    int length = maskedAccountNumber.length() - 4;
                    int length2 = maskedAccountNumber.length();
                    if (maskedAccountNumber != null) {
                        str = maskedAccountNumber.substring(length, length2);
                        k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    str = null;
                }
                intent.putExtra("key_account", "XXXX ".concat(String.valueOf(str)));
            }
            StringBuilder sb = new StringBuilder();
            CJRAutomaticSubscriptionItemModel a15 = this.f64693a.f64680b;
            sb.append((a15 == null || (product4 = a15.getProduct()) == null) ? null : product4.getService());
            sb.append("_");
            CJRAutomaticSubscriptionItemModel a16 = this.f64693a.f64680b;
            sb.append((a16 == null || (product3 = a16.getProduct()) == null) ? null : product3.getPaytype());
            intent.putExtra("service_paytype", sb.toString());
            boolean z = false;
            CJRAutomaticSubscriptionItemModel a17 = this.f64693a.f64680b;
            if (((a17 == null || (product2 = a17.getProduct()) == null) ? null : product2.getAttributes()) instanceof String) {
                CJRAutomaticSubscriptionItemModel a18 = this.f64693a.f64680b;
                if (!(a18 == null || (product = a18.getProduct()) == null)) {
                    str2 = product.getAttributes();
                }
                if (str2 == null) {
                    k.a();
                }
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("is_bank_mandate_enabled")) {
                    z = p.a("1", jSONObject.get("is_bank_mandate_enabled").toString(), true);
                }
            }
            intent.putExtra("is_bank_mandate_enabled", z);
            AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity = this.f64693a;
            aJRAutomaticSubscriptionManageActivity.startActivityForResult(intent, aJRAutomaticSubscriptionManageActivity.n);
            AJRAutomaticSubscriptionManageActivity.e(this.f64693a);
        }
    }

    private final void b() {
        if (this.f64685g) {
            this.f64685g = false;
            String str = this.f64686h;
            if (str == null) {
                k.a();
            }
            b(str);
        }
    }

    private final void c() {
        SpannableString spannableString = new SpannableString(getString(R.string.emandate_confirmation_awaited));
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, spannableString.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.9f), 0, spannableString.length(), 33);
        TextView textView = (TextView) a(R.id.txt_bank_name);
        if (textView != null) {
            textView.setText(spannableString);
        }
        TextView textView2 = (TextView) a(R.id.txt_bank_name);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) a(R.id.txt_card_number);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        ImageView imageView = (ImageView) a(R.id.ic_bank_logo);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.bank_lyt);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        d();
        b();
    }

    private final void d() {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.bank_shimmer_lyt);
        if (shimmerFrameLayout != null && shimmerFrameLayout.c()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.bank_lyt);
            if (constraintLayout != null) {
                constraintLayout.setEnabled(true);
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.bank_shimmer_lyt);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.b();
            }
        }
    }

    private final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        if (cJRAutomaticSubscriptionItemModel != null && cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.DISABLED.getStatus()) {
            ImageView imageView = (ImageView) a(R.id.ic_forward_arrow_2);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.bank_lyt);
            if (constraintLayout != null) {
                constraintLayout.setEnabled(false);
            }
            TextView textView = (TextView) a(R.id.tv_activation_manage_activity);
            if (textView != null) {
                ExtensionsKt.gone(textView);
            }
        } else if (cJRAutomaticSubscriptionItemModel != null && cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.ENABLED.getStatus()) {
            ImageView imageView2 = (ImageView) a(R.id.ic_forward_arrow_2);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.bank_lyt);
            if (constraintLayout2 != null) {
                constraintLayout2.setEnabled(true);
            }
            TextView textView2 = (TextView) a(R.id.tv_activation_manage_activity);
            if (textView2 != null) {
                ExtensionsKt.gone(textView2);
            }
        } else if (cJRAutomaticSubscriptionItemModel != null && cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.PROCESSING.getStatus()) {
            ImageView imageView3 = (ImageView) a(R.id.ic_forward_arrow_2);
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.bank_lyt);
            if (constraintLayout3 != null) {
                constraintLayout3.setEnabled(false);
            }
            TextView textView3 = (TextView) a(R.id.tv_activation_manage_activity);
            if (textView3 != null) {
                ExtensionsKt.visible(textView3);
            }
        }
    }

    private final void b(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        String payType = cJRAutomaticSubscriptionItemModel.getPayType();
        if (payType != null) {
            if (payType != null) {
                String lowerCase = payType.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (k.a((Object) "prepaid", (Object) lowerCase)) {
                    Group group = (Group) a(R.id.prepaid_group);
                    if (group != null) {
                        group.setVisibility(0);
                    }
                } else {
                    Group group2 = (Group) a(R.id.prepaid_group);
                    if (group2 != null) {
                        group2.setVisibility(8);
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        TextView textView = (TextView) a(R.id.txt_name);
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname()) ? cJRAutomaticSubscriptionItemModel.getRechargeNumber() : cJRAutomaticSubscriptionItemModel.getNickname());
        }
        c(cJRAutomaticSubscriptionItemModel);
        if (TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname())) {
            TextView textView2 = (TextView) a(R.id.txt_operator_number);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = (TextView) a(R.id.txt_operator_number);
            if (textView3 != null) {
                textView3.setText(cJRAutomaticSubscriptionItemModel.getRechargeNumber());
            }
            TextView textView4 = (TextView) a(R.id.txt_operator_number);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        TextView textView5 = (TextView) a(R.id.txt_name_with_operator_number);
        if (textView5 != null) {
            textView5.setText(cJRAutomaticSubscriptionItemModel.getOperatorNameWithCircle());
        }
        TextView textView6 = (TextView) a(R.id.txt_last_bill_paid_msg);
        if (textView6 != null) {
            textView6.setText(cJRAutomaticSubscriptionItemModel.getAutomaticPaymentStatusMessage(this));
        }
        w a2 = w.a();
        CJRAutomaticSubscriptionProductModel product = cJRAutomaticSubscriptionItemModel.getProduct();
        a2.a(product != null ? product.getThumbnail() : null).a((ImageView) a(R.id.ic_operator_icon));
        TextView textView7 = (TextView) a(R.id.txt_edit_name_link);
        if (textView7 != null) {
            textView7.setOnClickListener(new d(this, cJRAutomaticSubscriptionItemModel));
        }
        ImageView imageView = (ImageView) a(R.id.ic_forward_arrow_1);
        if (imageView != null) {
            imageView.setOnClickListener(new e(this));
        }
        ((TextView) a(R.id.tv_activate)).setOnClickListener(new f(this));
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 = this.f64680b;
        if (cJRAutomaticSubscriptionItemModel2 == null) {
            k.a();
        }
        d(cJRAutomaticSubscriptionItemModel2);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity f64688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRAutomaticSubscriptionItemModel f64689b;

        d(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            this.f64688a = aJRAutomaticSubscriptionManageActivity;
            this.f64689b = cJRAutomaticSubscriptionItemModel;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.presentation.b.d g2;
            AJRAutomaticSubscriptionManageActivity.f(this.f64688a);
            AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity = this.f64688a;
            d.a aVar = net.one97.paytm.recharge.presentation.b.d.f64748a;
            String nickname = this.f64689b.getNickname();
            CJRAutomaticSubscriptionItemModel a2 = this.f64688a.f64680b;
            aJRAutomaticSubscriptionManageActivity.f64687i = d.a.a(nickname, a2 != null ? Long.valueOf(a2.getSubscriptionId()) : null, this.f64688a.m, this.f64688a, d.c.FROM_AUTOMATIC_SUBSCRIPTION.ordinal());
            net.one97.paytm.recharge.presentation.b.d g3 = this.f64688a.f64687i;
            if (g3 != null && !g3.isVisible() && (g2 = this.f64688a.f64687i) != null) {
                g2.show(this.f64688a.getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.d.class.getSimpleName());
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity f64690a;

        e(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            this.f64690a = aJRAutomaticSubscriptionManageActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r0 = r0.getProduct();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                android.content.Intent r4 = new android.content.Intent
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                android.content.Context r0 = (android.content.Context) r0
                java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRPrepaidAutomaticSetupSettingsActivity> r1 = net.one97.paytm.recharge.presentation.activity.AJRPrepaidAutomaticSetupSettingsActivity.class
                r4.<init>(r0, r1)
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r0.f64680b
                r1 = 0
                if (r0 == 0) goto L_0x001f
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel r0 = r0.getProduct()
                if (r0 == 0) goto L_0x001f
                java.lang.String r0 = r0.getOperator()
                goto L_0x0020
            L_0x001f:
                r0 = r1
            L_0x0020:
                java.lang.String r2 = "operator_name"
                r4.putExtra(r2, r0)
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r0.f64680b
                if (r0 == 0) goto L_0x0032
                java.lang.String r0 = r0.getRechargeNumber()
                goto L_0x0033
            L_0x0032:
                r0 = r1
            L_0x0033:
                java.lang.String r2 = "recharge_number"
                r4.putExtra(r2, r0)
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r0.f64680b
                if (r0 == 0) goto L_0x004b
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel r0 = r0.getProduct()
                if (r0 == 0) goto L_0x004b
                java.lang.String r0 = r0.getThumbnail()
                goto L_0x004c
            L_0x004b:
                r0 = r1
            L_0x004c:
                java.lang.String r2 = "operator_logo"
                r4.putExtra(r2, r0)
                java.lang.String r0 = ""
                java.lang.String r2 = "amount_field_regex"
                r4.putExtra(r2, r0)
                java.lang.String r2 = "min_amount"
                r4.putExtra(r2, r0)
                java.lang.String r2 = "max_amount"
                r4.putExtra(r2, r0)
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r0.f64680b
                if (r0 == 0) goto L_0x0072
                long r0 = r0.getProductId()
                java.lang.Long r1 = java.lang.Long.valueOf(r0)
            L_0x0072:
                java.io.Serializable r1 = (java.io.Serializable) r1
                java.lang.String r0 = "product_id"
                r4.putExtra(r0, r1)
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r0 = r3.f64690a
                r0.startActivity(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity.e.onClick(android.view.View):void");
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity f64691a;

        f(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            this.f64691a = aJRAutomaticSubscriptionManageActivity;
        }

        public final void onClick(View view) {
            a.b bVar = net.one97.paytm.recharge.presentation.b.a.f64720a;
            CJRAutomaticSubscriptionItemModel a2 = this.f64691a.f64680b;
            CJRAutomaticSubscriptionItemModel a3 = this.f64691a.f64680b;
            Integer valueOf = a3 != null ? Integer.valueOf(a3.getStatus()) : null;
            if (valueOf == null) {
                k.a();
            }
            a.b.a(a2, valueOf.intValue(), this.f64691a.f64681c, -1, this.f64691a.m, this.f64691a).show(this.f64691a.getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.a.class.getSimpleName());
        }
    }

    private final void c(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        TextView textView;
        if (cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.ENABLED.getStatus()) {
            TextView textView2 = (TextView) a(R.id.txt_edit_name_link);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel != null ? cJRAutomaticSubscriptionItemModel.getNickname() : null)) {
                TextView textView3 = (TextView) a(R.id.txt_edit_name_link);
                if (textView3 != null) {
                    textView3.setText(getString(R.string.label_add_name));
                }
            } else {
                TextView textView4 = (TextView) a(R.id.txt_edit_name_link);
                if (textView4 != null) {
                    textView4.setText(getString(R.string.label_edit_name));
                }
            }
            TextView textView5 = (TextView) a(R.id.txt_manage_settings_header);
            if (textView5 != null) {
                textView5.setText(getString(R.string.label_manage_settings));
                return;
            }
            return;
        }
        if (cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.DISABLED.getStatus() && (textView = (TextView) a(R.id.txt_manage_settings_header)) != null) {
            textView.setText(getString(R.string.label_automatic_paused));
        }
        TextView textView6 = (TextView) a(R.id.txt_edit_name_link);
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
    }

    private final void b(int i2) {
        a.b bVar = net.one97.paytm.recharge.presentation.b.a.f64720a;
        a.b.a(this.f64680b, i2, this.f64681c, -1, this.m, this).show(getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.a.class.getSimpleName());
    }

    /* access modifiers changed from: private */
    public final void d(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        c(cJRAutomaticSubscriptionItemModel);
        a(cJRAutomaticSubscriptionItemModel);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64680b;
        if (cJRAutomaticSubscriptionItemModel != null && cJRAutomaticSubscriptionItemModel.getStatus() == 6) {
            return true;
        }
        getMenuInflater().inflate(R.menu.manage_automatic_menu, menu);
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer num = null;
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.overflow;
        if (valueOf != null && valueOf.intValue() == i2) {
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64680b;
            if (cJRAutomaticSubscriptionItemModel != null) {
                if (cJRAutomaticSubscriptionItemModel == null) {
                    k.a();
                }
                if (cJRAutomaticSubscriptionItemModel.getStatus() == 6) {
                    return true;
                }
            }
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String s = net.one97.paytm.recharge.automatic.b.a.a.v;
                String str = this.m;
                if (str == null) {
                    str = "";
                }
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, s, "", str, (Object) null, (Object) null, 96);
            } catch (Throwable unused) {
            }
            e.a aVar4 = net.one97.paytm.recharge.presentation.b.e.f64758a;
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 = this.f64680b;
            if (cJRAutomaticSubscriptionItemModel2 != null) {
                num = Integer.valueOf(cJRAutomaticSubscriptionItemModel2.getStatus());
            }
            if (num == null) {
                k.a();
            }
            int intValue = num.intValue();
            String str2 = this.m;
            e.c cVar = this;
            k.c(cVar, "editAutomaticActionListener");
            net.one97.paytm.recharge.presentation.b.e.f64759e = cVar;
            net.one97.paytm.recharge.presentation.b.e eVar = new net.one97.paytm.recharge.presentation.b.e();
            Bundle bundle = new Bundle();
            bundle.putSerializable("selected_automatic_subscribed_item", cJRAutomaticSubscriptionItemModel2);
            bundle.putInt("key_current_status", intValue);
            bundle.putString("service_paytype", str2);
            eVar.setArguments(bundle);
            eVar.show(getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.e.class.getSimpleName());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void onBackPressed() {
        Intent intent = new Intent();
        Bundle bundle = this.l;
        if (bundle != null) {
            if (bundle == null) {
                k.a();
            }
            intent.putExtras(bundle);
        }
        intent.putExtra("selected_automatic_subscribed_item", this.f64680b);
        intent.putExtra("is_refresh_needed", this.f64682d);
        boolean z = this.f64683e;
        if (z) {
            intent.putExtra("key_is_delete_automatic", z);
        }
        setResult(-1, intent);
        finish();
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void a(String str) {
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel;
        k.c(str, "billName");
        if (!TextUtils.isEmpty(str) && (cJRAutomaticSubscriptionItemModel = this.f64680b) != null) {
            cJRAutomaticSubscriptionItemModel.setNickname(str);
            this.f64682d = true;
            b(cJRAutomaticSubscriptionItemModel);
            b(d(this.p));
        }
    }

    private final void b(String str) {
        TextView textView = (TextView) a(R.id.txt_bill_name_change_msg);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) a(R.id.txt_bill_name_change_msg);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) a(R.id.txt_name);
        if (textView3 != null) {
            textView3.postDelayed(new g(this), 3000);
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionManageActivity f64692a;

        g(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
            this.f64692a = aJRAutomaticSubscriptionManageActivity;
        }

        public final void run() {
            TextView textView;
            if (this.f64692a.f64684f != null && (textView = (TextView) this.f64692a.a(R.id.txt_bill_name_change_msg)) != null) {
                textView.setVisibility(8);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.n && i3 == -1 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("isSubscribed", false);
            int intExtra = intent.getIntExtra("key_action", 0);
            if (intExtra == this.o && booleanExtra) {
                this.f64682d = true;
                c(intExtra);
            }
        } else if (i2 == 1014 && i3 != 0) {
            a();
        }
    }

    private final void c(int i2) {
        try {
            this.f64685g = true;
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.bank_lyt);
            if (constraintLayout != null) {
                constraintLayout.setEnabled(false);
            }
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.bank_shimmer_lyt);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
        } catch (Exception unused) {
        }
        c(d(i2));
    }

    public final void onNewIntent(Intent intent) {
        Bundle extras;
        super.onNewIntent(intent);
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("is_from_edit_emandate") && extras.getBoolean("is_from_edit_emandate") && extras.containsKey("isPending") && extras.getBoolean("isPending")) {
            this.f64682d = true;
            c(this.q);
        }
    }

    private final void c(String str) {
        net.one97.paytm.recharge.presentation.g.a aVar = this.f64679a;
        if (aVar != null) {
            aVar.a((Context) this);
        }
        this.f64686h = str;
    }

    private final String d(int i2) {
        String str;
        if (i2 == this.o || i2 == this.q) {
            str = getString(R.string.payment_option_changed);
        } else if (i2 == this.p) {
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64680b;
            str = getString(TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel != null ? cJRAutomaticSubscriptionItemModel.getNickname() : null) ? R.string.bill_name_added : R.string.bill_name_saved);
        } else {
            str = "";
        }
        k.a((Object) str, "when(action) {\n        A…\n        else -> \"\"\n    }");
        return str;
    }

    public final void a(int i2, e.b bVar) {
        k.c(bVar, "action");
        int i3 = e.f64717c[bVar.ordinal()];
        if (i3 == 1) {
            b(i2);
        } else if (i3 == 2) {
            b(i2);
        } else if (i3 == 3) {
            b(i2);
        }
    }

    public final void a(int i2, int i3) {
        if (i2 == -1) {
            this.f64682d = true;
            this.f64683e = true;
            onBackPressed();
            return;
        }
        this.f64682d = true;
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64680b;
        if (cJRAutomaticSubscriptionItemModel != null) {
            cJRAutomaticSubscriptionItemModel.setStatus(i2);
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 = this.f64680b;
        if (cJRAutomaticSubscriptionItemModel2 == null) {
            k.a();
        }
        d(cJRAutomaticSubscriptionItemModel2);
    }

    public final void onDestroy() {
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup = (ViewGroup) decorView;
        if (viewGroup != null) {
            viewGroup.removeView(this.f64684f);
        }
        super.onDestroy();
    }

    public static final /* synthetic */ void a(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity, CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel;
        AutomaticProductInfo paymentInfo;
        AutomaticProductInfo paymentInfo2;
        if (cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList() != null && (!cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().isEmpty())) {
            Collection arrayList = new ArrayList();
            Iterator it2 = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().iterator();
            while (true) {
                boolean z = false;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 = (CJRAutomaticSubscriptionItemModel) next;
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel3 = aJRAutomaticSubscriptionManageActivity.f64680b;
                if (cJRAutomaticSubscriptionItemModel3 != null && cJRAutomaticSubscriptionItemModel3.getSubscriptionId() == cJRAutomaticSubscriptionItemModel2.getSubscriptionId()) {
                    z = true;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                AutomaticProductInfo paymentInfo3 = ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentInfo();
                String str = null;
                if (TextUtils.isEmpty(paymentInfo3 != null ? paymentInfo3.getSavedCardId() : null)) {
                    AutomaticProductInfo paymentInfo4 = ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentInfo();
                    if (TextUtils.isEmpty(paymentInfo4 != null ? paymentInfo4.getCardNumber() : null) && ((TextUtils.isEmpty(((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentBank()) || !p.a(SDKConstants.AI_KEY_PPBL, ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentBank(), true)) && (TextUtils.isEmpty(((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentMode()) || !p.a(SDKConstants.TYPE_BANK_MANDATE, ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentMode(), true)))) {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        StringBuilder sb = new StringBuilder("PaymentAutomatic handleSubscriptionListResponse NO savedCardId : ");
                        AutomaticProductInfo paymentInfo5 = ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentInfo();
                        if (paymentInfo5 != null) {
                            str = paymentInfo5.getSavedCardId();
                        }
                        sb.append(str);
                        sb.append(" && Bank : ");
                        sb.append(((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentBank());
                        net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
                        try {
                            ConstraintLayout constraintLayout = (ConstraintLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_lyt);
                            if (constraintLayout != null) {
                                constraintLayout.setEnabled(true);
                            }
                            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_shimmer_lyt);
                            if (shimmerFrameLayout != null) {
                                shimmerFrameLayout.b();
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                StringBuilder sb2 = new StringBuilder("PaymentAutomatic handleSubscriptionListResponse With savedCardId : ");
                AutomaticProductInfo paymentInfo6 = ((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentInfo();
                sb2.append(paymentInfo6 != null ? paymentInfo6.getSavedCardId() : null);
                sb2.append(" && Bank : ");
                sb2.append(((CJRAutomaticSubscriptionItemModel) list.get(0)).getPaymentBank());
                net.one97.paytm.recharge.widgets.c.d.a(sb2.toString());
                aJRAutomaticSubscriptionManageActivity.f64680b = (CJRAutomaticSubscriptionItemModel) list.get(0);
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel4 = aJRAutomaticSubscriptionManageActivity.f64680b;
                aJRAutomaticSubscriptionManageActivity.j = (cJRAutomaticSubscriptionItemModel4 == null || (paymentInfo2 = cJRAutomaticSubscriptionItemModel4.getPaymentInfo()) == null) ? null : paymentInfo2.getSavedCardId();
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel5 = aJRAutomaticSubscriptionManageActivity.f64680b;
                if (!(cJRAutomaticSubscriptionItemModel5 == null || (paymentInfo = cJRAutomaticSubscriptionItemModel5.getPaymentInfo()) == null)) {
                    str = paymentInfo.getCardNumber();
                }
                aJRAutomaticSubscriptionManageActivity.k = str;
                aJRAutomaticSubscriptionManageActivity.a();
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel6 = aJRAutomaticSubscriptionManageActivity.f64680b;
                if (cJRAutomaticSubscriptionItemModel6 != null && cJRAutomaticSubscriptionItemModel6.getStatus() == 6 && (cJRAutomaticSubscriptionItemModel = aJRAutomaticSubscriptionManageActivity.f64680b) != null) {
                    if (cJRAutomaticSubscriptionItemModel == null) {
                        k.a();
                    }
                    aJRAutomaticSubscriptionManageActivity.d(cJRAutomaticSubscriptionItemModel);
                    aJRAutomaticSubscriptionManageActivity.invalidateOptionsMenu();
                }
            }
        } else if (!TextUtils.isEmpty(aJRAutomaticSubscriptionManageActivity.f64686h)) {
            try {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_lyt);
                if (constraintLayout2 != null) {
                    constraintLayout2.setEnabled(true);
                }
                ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_shimmer_lyt);
                if (shimmerFrameLayout2 != null) {
                    shimmerFrameLayout2.b();
                }
            } catch (Exception unused2) {
            }
            String str2 = aJRAutomaticSubscriptionManageActivity.f64686h;
            if (str2 == null) {
                k.a();
            }
            aJRAutomaticSubscriptionManageActivity.b(str2);
        }
    }

    public static final /* synthetic */ void b(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
        if (aJRAutomaticSubscriptionManageActivity.f64685g) {
            ConstraintLayout constraintLayout = (ConstraintLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_lyt);
            if (constraintLayout != null) {
                constraintLayout.setEnabled(true);
            }
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aJRAutomaticSubscriptionManageActivity.a(R.id.bank_shimmer_lyt);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            String str = aJRAutomaticSubscriptionManageActivity.f64686h;
            if (str != null) {
                aJRAutomaticSubscriptionManageActivity.b(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014e, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0179, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.AI_KEY_PPBL, r12 != null ? r12.getPaymentBank() : null, true) == false) goto L_0x017b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity r11, java.util.ArrayList r12) {
        /*
            if (r12 == 0) goto L_0x019f
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L_0x000a
            goto L_0x019f
        L_0x000a:
            java.lang.String r0 = r11.j
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x005c
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r12 = r12.iterator()
        L_0x0024:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto L_0x0048
            java.lang.Object r4 = r12.next()
            r5 = r4
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r5 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r5
            java.lang.String r5 = r5.getSavedCardId()
            if (r5 == 0) goto L_0x0041
            java.lang.String r6 = r11.j
            boolean r5 = r5.equals(r6)
            if (r5 != r2) goto L_0x0041
            r5 = 1
            goto L_0x0042
        L_0x0041:
            r5 = 0
        L_0x0042:
            if (r5 == 0) goto L_0x0024
            r0.add(r4)
            goto L_0x0024
        L_0x0048:
            java.util.List r0 = (java.util.List) r0
            r12 = r0
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r2
            if (r12 == 0) goto L_0x0150
            java.lang.Object r12 = r0.get(r1)
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r12 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r12
            goto L_0x0151
        L_0x005c:
            java.util.Iterator r12 = r12.iterator()
        L_0x0060:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0150
            java.lang.Object r0 = r12.next()
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r0 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r0
            java.lang.String r4 = r11.j
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0140
            java.lang.String r4 = r11.k
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0140
            java.lang.String r4 = r0.getCardFirstSixDigits()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            r6 = 3
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            r8 = 4
            java.lang.String r9 = ""
            if (r4 != 0) goto L_0x00bc
            java.lang.String r4 = r0.getCardFirstSixDigits()
            if (r4 != 0) goto L_0x009d
            kotlin.g.b.k.a()
        L_0x009d:
            int r4 = r4.length()
            if (r4 <= r6) goto L_0x00bc
            java.lang.String r4 = r0.getCardFirstSixDigits()
            if (r4 != 0) goto L_0x00ac
            kotlin.g.b.k.a()
        L_0x00ac:
            if (r4 == 0) goto L_0x00b6
            java.lang.String r4 = r4.substring(r1, r8)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x00bd
        L_0x00b6:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r7)
            throw r11
        L_0x00bc:
            r4 = r9
        L_0x00bd:
            java.lang.String r10 = r11.k
            if (r10 != 0) goto L_0x00c4
            kotlin.g.b.k.a()
        L_0x00c4:
            int r10 = r10.length()
            if (r10 <= r6) goto L_0x0105
            java.lang.String r6 = r11.k
            if (r6 != 0) goto L_0x00d1
            kotlin.g.b.k.a()
        L_0x00d1:
            if (r6 == 0) goto L_0x00ff
            java.lang.String r9 = r6.substring(r1, r8)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r5)
            java.lang.String r5 = r11.k
            if (r5 != 0) goto L_0x00e1
            kotlin.g.b.k.a()
        L_0x00e1:
            java.lang.String r6 = r11.k
            if (r6 != 0) goto L_0x00e8
            kotlin.g.b.k.a()
        L_0x00e8:
            int r6 = r6.length()
            int r6 = r6 - r8
            if (r5 == 0) goto L_0x00f9
            java.lang.String r5 = r5.substring(r6)
            java.lang.String r6 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            goto L_0x0106
        L_0x00f9:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r7)
            throw r11
        L_0x00ff:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r7)
            throw r11
        L_0x0105:
            r5 = r9
        L_0x0106:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0060
            java.lang.String r6 = r0.getLastFourDigits()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0060
            r6 = r9
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0060
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x012f
            goto L_0x0060
        L_0x012f:
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x0060
            java.lang.String r4 = r0.getLastFourDigits()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r1)
            if (r4 == 0) goto L_0x0060
            goto L_0x014e
        L_0x0140:
            java.lang.String r4 = r11.j
            if (r4 == 0) goto L_0x0060
            java.lang.String r5 = r0.getSavedCardId()
            boolean r4 = r4.equals(r5)
            if (r4 != r2) goto L_0x0060
        L_0x014e:
            r12 = r0
            goto L_0x0151
        L_0x0150:
            r12 = r3
        L_0x0151:
            if (r12 == 0) goto L_0x0157
            r11.a((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r12)
            return
        L_0x0157:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r12 = r11.f64680b
            if (r12 == 0) goto L_0x0160
            java.lang.String r12 = r12.getPaymentBank()
            goto L_0x0161
        L_0x0160:
            r12 = r3
        L_0x0161:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x017b
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r12 = r11.f64680b
            if (r12 == 0) goto L_0x0172
            java.lang.String r12 = r12.getPaymentBank()
            goto L_0x0173
        L_0x0172:
            r12 = r3
        L_0x0173:
            java.lang.String r0 = "PPBL"
            boolean r12 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r2)
            if (r12 != 0) goto L_0x019c
        L_0x017b:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r12 = r11.f64680b
            if (r12 == 0) goto L_0x0184
            java.lang.String r12 = r12.getPaymentMode()
            goto L_0x0185
        L_0x0184:
            r12 = r3
        L_0x0185:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x019c
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r12 = r11.f64680b
            if (r12 == 0) goto L_0x0196
            java.lang.String r12 = r12.getPaymentMode()
            goto L_0x0197
        L_0x0196:
            r12 = r3
        L_0x0197:
            java.lang.String r0 = "BANK_MANDATE"
            kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r2)
        L_0x019c:
            r11.a((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r3)
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity.a(net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity, java.util.ArrayList):void");
    }

    public static final /* synthetic */ void e(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = aJRAutomaticSubscriptionManageActivity;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String x = net.one97.paytm.recharge.automatic.b.a.a.A;
            String str = aJRAutomaticSubscriptionManageActivity.m;
            if (str == null) {
                str = "";
            }
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, x, "", str, (Object) null, (Object) null, 96);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void f(AJRAutomaticSubscriptionManageActivity aJRAutomaticSubscriptionManageActivity) {
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = aJRAutomaticSubscriptionManageActivity;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String q2 = net.one97.paytm.recharge.automatic.b.a.a.t;
            String str = aJRAutomaticSubscriptionManageActivity.m;
            if (str == null) {
                str = "";
            }
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, q2, "", str, (Object) null, (Object) null, 96);
        } catch (Throwable unused) {
        }
    }
}
