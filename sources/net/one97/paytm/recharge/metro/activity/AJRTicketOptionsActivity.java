package net.one97.paytm.recharge.metro.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.a.ae;
import kotlin.g.a.q;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.f;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.c.e;
import net.one97.paytm.recharge.metro.d.d;
import net.one97.paytm.recharge.metro.d.m;
import net.one97.paytm.recharge.metro.e.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class AJRTicketOptionsActivity extends PaytmActivity implements ag, ai, e.a, d.a, net.one97.paytm.recharge.ordersummary.f.n {
    /* access modifiers changed from: private */
    public static final String C = C;
    /* access modifiers changed from: private */
    public static final String D = D;
    /* access modifiers changed from: private */
    public static boolean E;

    /* renamed from: a  reason: collision with root package name */
    public static final a f63243a = new a((byte) 0);
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.ordersummary.h.d A;
    private String B = "";
    private HashMap F;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.common.utils.f f63244b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f63245c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRMetroQRFrequentOrder> f63246d = new ArrayList<>(2);

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRMetroQRFrequentOrder> f63247e = new ArrayList<>(5);

    /* renamed from: f  reason: collision with root package name */
    private CJRItem f63248f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f63249g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRUtilityVariantV2 f63250h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public List<? extends CJRUtilityVariantV2> f63251i;
    /* access modifiers changed from: private */
    public CJRActiveMetroTicketModel j;
    private RecyclerView.LayoutManager k;
    /* access modifiers changed from: private */
    public RecyclerView.a<net.one97.paytm.recharge.metro.d.d> l;
    /* access modifiers changed from: private */
    public Map<Long, ? extends List<? extends CJRActiveMetroTicketModel>> m;
    /* access modifiers changed from: private */
    public boolean n;
    private List<? extends CJRUtilityVariantV2> o;
    /* access modifiers changed from: private */
    public boolean p;
    private RecyclerView q;
    private ProgressBar r;
    private CJRMetroQRFrequentOrderList s;
    private boolean t;
    private CJRItem u;
    private boolean v;
    private boolean w;
    private boolean x;
    private final int y = 107;
    private boolean z;

    public final View b(int i2) {
        if (this.F == null) {
            this.F = new HashMap();
        }
        View view = (View) this.F.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.F.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends kotlin.g.b.l implements q<CJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel>, Boolean, x> {
        final /* synthetic */ boolean $hasPenaltyTicket$inlined;
        final /* synthetic */ net.one97.paytm.recharge.metro.c.a $this_apply;
        final /* synthetic */ List $tickets$inlined;
        final /* synthetic */ CJRUtilityVariantV2 $variant$inlined;
        final /* synthetic */ AJRTicketOptionsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(net.one97.paytm.recharge.metro.c.a aVar, AJRTicketOptionsActivity aJRTicketOptionsActivity, boolean z, CJRUtilityVariantV2 cJRUtilityVariantV2, List list) {
            super(3);
            this.$this_apply = aVar;
            this.this$0 = aJRTicketOptionsActivity;
            this.$hasPenaltyTicket$inlined = z;
            this.$variant$inlined = cJRUtilityVariantV2;
            this.$tickets$inlined = list;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((CJRUtilityVariantV2) obj, (List<? extends CJRActiveMetroTicketModel>) (List) obj2, ((Boolean) obj3).booleanValue());
            return x.f47997a;
        }

        public final void invoke(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z) {
            kotlin.g.b.k.c(cJRUtilityVariantV2, "variant");
            kotlin.g.b.k.c(list, "tickets");
            if (z) {
                this.this$0.a(cJRUtilityVariantV2, list);
                this.this$0.a(cJRUtilityVariantV2, list, false, this.$hasPenaltyTicket$inlined);
            }
            this.$this_apply.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class f<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63254a;

        public f(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63254a = aJRTicketOptionsActivity;
        }

        public final int compare(T t, T t2) {
            Comparable comparable;
            Comparable comparable2;
            int i2;
            CJRUtilityVariantV2 cJRUtilityVariantV2 = (CJRUtilityVariantV2) t;
            CJRUtilityProductV2 product = cJRUtilityVariantV2.getProduct();
            Long l = null;
            int i3 = 0;
            if (product == null || product.getId() != -1) {
                Map e2 = this.f63254a.m;
                if (e2 != null) {
                    CJRUtilityProductV2 product2 = cJRUtilityVariantV2.getProduct();
                    List list = (List) e2.get(product2 != null ? Long.valueOf(product2.getId()) : null);
                    if (list != null) {
                        i2 = list.size();
                        comparable = Integer.valueOf(i2 * -1);
                    }
                }
                i2 = 0;
                comparable = Integer.valueOf(i2 * -1);
            } else {
                comparable = (Comparable) -100;
            }
            CJRUtilityVariantV2 cJRUtilityVariantV22 = (CJRUtilityVariantV2) t2;
            CJRUtilityProductV2 product3 = cJRUtilityVariantV22.getProduct();
            if (product3 == null || product3.getId() != -1) {
                Map e3 = this.f63254a.m;
                if (e3 != null) {
                    CJRUtilityProductV2 product4 = cJRUtilityVariantV22.getProduct();
                    if (product4 != null) {
                        l = Long.valueOf(product4.getId());
                    }
                    List list2 = (List) e3.get(l);
                    if (list2 != null) {
                        i3 = list2.size();
                    }
                }
                comparable2 = Integer.valueOf(i3 * -1);
            } else {
                comparable2 = (Comparable) -100;
            }
            return kotlin.b.a.a(comparable, comparable2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d6, code lost:
        r0 = r0.getVariants();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            r0 = r7
            android.app.Activity r0 = (android.app.Activity) r0
            com.paytm.utility.b.e((android.app.Activity) r0)
            super.onCreate(r8)
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "intent"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.os.Bundle r8 = r8.getExtras()
            if (r8 != 0) goto L_0x001c
            r7.finish()
            return
        L_0x001c:
            androidx.appcompat.app.ActionBar r0 = r7.getSupportActionBar()
            if (r0 == 0) goto L_0x0025
            r0.f()
        L_0x0025:
            int r0 = net.one97.paytm.recharge.R.layout.ticket_options_layout_2
            r7.setContentView((int) r0)
            int r0 = net.one97.paytm.recharge.R.id.progress_bar
            android.view.View r0 = r7.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r7.r = r0
            int r0 = net.one97.paytm.recharge.R.id.metro_selection_main_lyt
            android.view.View r0 = r7.b((int) r0)
            int r1 = net.one97.paytm.recharge.R.id.recycler_view_ticket_options
            android.view.View r0 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r7.q = r0
            java.lang.String r0 = D
            boolean r0 = r8.getBoolean(r0)
            r7.p = r0
            java.lang.String r0 = "fast_forward"
            boolean r0 = r8.getBoolean(r0)
            r7.t = r0
            java.lang.String r0 = "extra_home_data"
            java.io.Serializable r1 = r8.getSerializable(r0)
            boolean r2 = r1 instanceof net.one97.paytm.common.entity.CJRItem
            r3 = 0
            if (r2 != 0) goto L_0x0060
            r1 = r3
        L_0x0060:
            net.one97.paytm.common.entity.CJRItem r1 = (net.one97.paytm.common.entity.CJRItem) r1
            r7.u = r1
            r1 = 0
            java.lang.String r2 = "is_help_section_enabled"
            boolean r2 = r8.getBoolean(r2, r1)
            r7.v = r2
            android.widget.ProgressBar r2 = r7.r
            if (r2 == 0) goto L_0x0074
            r2.setVisibility(r1)
        L_0x0074:
            androidx.recyclerview.widget.RecyclerView r2 = r7.q
            r4 = 8
            if (r2 == 0) goto L_0x007d
            r2.setVisibility(r4)
        L_0x007d:
            java.lang.String r2 = C
            boolean r2 = r8.getBoolean(r2)
            r7.f63249g = r2
            java.io.Serializable r0 = r8.getSerializable(r0)
            if (r0 == 0) goto L_0x02e3
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0
            r7.f63248f = r0
            java.lang.String r0 = "metroTicketVariant"
            java.io.Serializable r0 = r8.getSerializable(r0)
            if (r0 == 0) goto L_0x02db
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            r7.f63250h = r0
            java.lang.String r0 = "vertical_name"
            java.lang.String r2 = ""
            java.lang.String r8 = r8.getString(r0, r2)
            java.lang.String r0 = "extras.getString(CJRRech…_EXTRA_VERTICAL_NAME, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r7.B = r8
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            boolean r0 = r7.p
            if (r0 != 0) goto L_0x00d2
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = new net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2
            r0.<init>()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r2 = new net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2
            r2.<init>()
            r0.setProduct(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r2 = r0.getProduct()
            java.lang.String r5 = "obj.product"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r5 = -1
            r2.setId(r5)
            r8.add(r1, r0)
        L_0x00d2:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = r7.f63250h
            if (r0 == 0) goto L_0x00e3
            java.util.List r0 = r0.getVariants()
            if (r0 == 0) goto L_0x00e3
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.j.d r0 = kotlin.a.k.a((java.util.Collection<?>) r0)
            goto L_0x00e4
        L_0x00e3:
            r0 = r3
        L_0x00e4:
            if (r0 != 0) goto L_0x00e9
            kotlin.g.b.k.a()
        L_0x00e9:
            int r2 = r0.f47939a
            int r0 = r0.f47940b
            if (r2 > r0) goto L_0x011d
        L_0x00ef:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = r7.f63250h
            if (r5 == 0) goto L_0x0100
            java.util.List r5 = r5.getVariants()
            if (r5 == 0) goto L_0x0100
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            goto L_0x0101
        L_0x0100:
            r5 = r3
        L_0x0101:
            if (r5 == 0) goto L_0x0118
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = r5.getProduct()
            if (r6 == 0) goto L_0x0118
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r6 = r6.getAttributes()
            if (r6 == 0) goto L_0x0118
            boolean r6 = r6.isProductDisabled()
            if (r6 != 0) goto L_0x0118
            r8.add(r5)
        L_0x0118:
            if (r2 == r0) goto L_0x011d
            int r2 = r2 + 1
            goto L_0x00ef
        L_0x011d:
            java.util.List r8 = (java.util.List) r8
            r7.f63251i = r8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r8 = r7.f63250h
            if (r8 == 0) goto L_0x012a
            java.lang.String r8 = r8.getFilterName()
            goto L_0x012b
        L_0x012a:
            r8 = r3
        L_0x012b:
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            if (r8 == 0) goto L_0x0141
            if (r8 == 0) goto L_0x0139
            java.lang.String r8 = r8.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            goto L_0x0142
        L_0x0139:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r0)
            throw r8
        L_0x0141:
            r8 = r3
        L_0x0142:
            java.lang.String r2 = "Delhi Metro"
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0158
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r8 = net.one97.paytm.recharge.metro.f.c.j
            goto L_0x0174
        L_0x0158:
            java.lang.String r2 = "Hyderabad Metro"
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r2)
            if (r8 == 0) goto L_0x016e
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r8 = net.one97.paytm.recharge.metro.f.c.k
            goto L_0x0174
        L_0x016e:
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r8 = net.one97.paytm.recharge.metro.f.c.f63584i
        L_0x0174:
            java.util.Map r8 = r7.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r8)
            r7.m = r8
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r8 = r7.f63251i
            if (r8 == 0) goto L_0x018c
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$f r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$f
            r0.<init>(r7)
            java.util.Comparator r0 = (java.util.Comparator) r0
            java.util.List r8 = kotlin.a.k.a(r8, r0)
            goto L_0x018d
        L_0x018c:
            r8 = r3
        L_0x018d:
            r7.f63251i = r8
            int r8 = net.one97.paytm.recharge.R.id.metro_heading
            android.view.View r8 = r7.b((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x01a8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = r7.f63250h
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = r0.getDisplayName()
            goto L_0x01a3
        L_0x01a2:
            r0 = r3
        L_0x01a3:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x01a8:
            androidx.recyclerview.widget.LinearLayoutManager r8 = new androidx.recyclerview.widget.LinearLayoutManager
            r0 = r7
            android.content.Context r0 = (android.content.Context) r0
            r8.<init>(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r8 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r8
            r7.k = r8
            androidx.recyclerview.widget.RecyclerView r8 = r7.q
            if (r8 == 0) goto L_0x01bd
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r7.k
            r8.setLayoutManager(r2)
        L_0x01bd:
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$g r8 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$g
            r8.<init>(r7)
            androidx.recyclerview.widget.RecyclerView$a r8 = (androidx.recyclerview.widget.RecyclerView.a) r8
            r7.l = r8
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r8 = r7.s
            if (r8 == 0) goto L_0x01d3
            if (r8 != 0) goto L_0x01cf
            kotlin.g.b.k.a()
        L_0x01cf:
            r7.a((net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList) r8)
            goto L_0x01eb
        L_0x01d3:
            boolean r8 = com.paytm.utility.d.c(r0)
            if (r8 == 0) goto L_0x01dd
            boolean r8 = r7.p
            if (r8 == 0) goto L_0x01eb
        L_0x01dd:
            android.widget.ProgressBar r8 = r7.r
            if (r8 == 0) goto L_0x01e4
            r8.setVisibility(r4)
        L_0x01e4:
            androidx.recyclerview.widget.RecyclerView r8 = r7.q
            if (r8 == 0) goto L_0x01eb
            r8.setVisibility(r1)
        L_0x01eb:
            androidx.recyclerview.widget.RecyclerView r8 = r7.q
            if (r8 == 0) goto L_0x0204
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$b r1 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$b
            android.content.res.Resources r2 = r7.getResources()
            int r4 = net.one97.paytm.recharge.R.dimen.dimen_5dp
            float r2 = r2.getDimension(r4)
            int r2 = (int) r2
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$h r1 = (androidx.recyclerview.widget.RecyclerView.h) r1
            r8.addItemDecoration(r1)
        L_0x0204:
            androidx.recyclerview.widget.RecyclerView r8 = r7.q
            if (r8 == 0) goto L_0x020d
            androidx.recyclerview.widget.RecyclerView$a<net.one97.paytm.recharge.metro.d.d> r1 = r7.l
            r8.setAdapter(r1)
        L_0x020d:
            boolean r8 = r7.p
            if (r8 != 0) goto L_0x0218
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r8 = r7.s
            if (r8 != 0) goto L_0x0218
            r7.h()
        L_0x0218:
            net.one97.paytm.recharge.common.utils.f$a r8 = net.one97.paytm.recharge.common.utils.f.f61626a
            net.one97.paytm.recharge.common.utils.f r8 = net.one97.paytm.recharge.common.utils.f.a.a()
            r7.f63244b = r8
            net.one97.paytm.recharge.ordersummary.h.d r8 = new net.one97.paytm.recharge.ordersummary.h.d
            r8.<init>(r0)
            r7.A = r8
            net.one97.paytm.recharge.ordersummary.h.d r8 = r7.A
            if (r8 == 0) goto L_0x024c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "/"
            r1.<init>(r2)
            net.one97.paytm.recharge.metro.f.c$a r2 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = r7.f63250h
            if (r2 == 0) goto L_0x023d
            java.lang.String r2 = r2.getFilterName()
            goto L_0x023e
        L_0x023d:
            r2 = r3
        L_0x023e:
            java.lang.String r2 = net.one97.paytm.recharge.metro.f.c.a.a((java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r8.a((android.content.Context) r0, (java.lang.String) r1)
        L_0x024c:
            net.one97.paytm.recharge.widgets.c.d r8 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r8 = net.one97.paytm.recharge.widgets.c.d.b()
            net.one97.paytm.recharge.metro.f.c$a r0 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = r7.f63250h
            if (r0 == 0) goto L_0x025c
            java.lang.String r3 = r0.getFilterName()
        L_0x025c:
            java.lang.String r0 = net.one97.paytm.recharge.metro.f.c.a.a((java.lang.String) r3)
            r8.setScreenName(r0)
            int r8 = net.one97.paytm.recharge.R.id.back_button
            android.view.View r8 = r7.b((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$l r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$l
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            int r8 = net.one97.paytm.recharge.R.id.drop_down_clickable_lyt
            android.view.View r8 = r7.b((int) r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$m r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$m
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            int r8 = net.one97.paytm.recharge.R.id.grey_view
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$n r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$n
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            r7.e()
            int r8 = net.one97.paytm.recharge.R.id.delhi_metro_click_view
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$h r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$h
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            int r8 = net.one97.paytm.recharge.R.id.hyd_metro_click_view
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$i r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$i
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            int r8 = net.one97.paytm.recharge.R.id.bng_metro_click_view
            android.view.View r8 = r7.b((int) r8)
            if (r8 == 0) goto L_0x02cc
            net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$j r0 = new net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity$j
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
        L_0x02cc:
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            android.content.Context r8 = r7.getApplicationContext()
            java.lang.String r0 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            net.one97.paytm.recharge.metro.f.c.a.b((android.content.Context) r8)
            return
        L_0x02db:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2"
            r8.<init>(r0)
            throw r8
        L_0x02e3:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.onCreate(android.os.Bundle):void");
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63256a;

        h(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63256a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            AJRTicketOptionsActivity aJRTicketOptionsActivity = this.f63256a;
            View b2 = aJRTicketOptionsActivity.b(R.id.delhi_metro_click_view);
            kotlin.g.b.k.a((Object) b2, "delhi_metro_click_view");
            AJRTicketOptionsActivity.a(aJRTicketOptionsActivity, b2);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63257a;

        i(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63257a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            AJRTicketOptionsActivity aJRTicketOptionsActivity = this.f63257a;
            View b2 = aJRTicketOptionsActivity.b(R.id.hyd_metro_click_view);
            kotlin.g.b.k.a((Object) b2, "hyd_metro_click_view");
            AJRTicketOptionsActivity.a(aJRTicketOptionsActivity, b2);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63258a;

        j(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63258a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            AJRTicketOptionsActivity aJRTicketOptionsActivity = this.f63258a;
            View b2 = aJRTicketOptionsActivity.b(R.id.bng_metro_click_view);
            kotlin.g.b.k.a((Object) b2, "bng_metro_click_view");
            AJRTicketOptionsActivity.a(aJRTicketOptionsActivity, b2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c8, code lost:
        r4 = r4.getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e() {
        /*
            r9 = this;
            net.one97.paytm.recharge.legacy.catalog.b.a r0 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            java.lang.String r1 = "variantSingleton"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r0 = r0.b()
            r9.o = r0
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r0 = r9.o
            if (r0 == 0) goto L_0x0141
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0021
            goto L_0x0141
        L_0x0021:
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r0 = r9.o
            if (r0 == 0) goto L_0x0141
            int r1 = r0.size()
            r2 = 1
            int r1 = r1 - r2
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2[] r3 = new net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2[r1]
            r4 = 0
            r5 = 0
        L_0x002f:
            if (r5 >= r1) goto L_0x003b
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = new net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2
            r6.<init>()
            r3[r5] = r6
            int r5 = r5 + 1
            goto L_0x002f
        L_0x003b:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r5 = 0
        L_0x0043:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0072
            java.lang.Object r6 = r0.next()
            int r7 = r1 + 1
            if (r1 >= 0) goto L_0x0054
            kotlin.a.k.a()
        L_0x0054:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r6
            if (r6 == 0) goto L_0x0070
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r9.f63250h
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = r1.getFilterName()
            if (r1 == 0) goto L_0x0070
            java.lang.String r8 = r6.getFilterName()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r4)
            if (r1 != 0) goto L_0x0070
            r3[r5] = r6
            int r5 = r5 + 1
        L_0x0070:
            r1 = r7
            goto L_0x0043
        L_0x0072:
            int r0 = net.one97.paytm.recharge.R.id.first_operator_tv
            android.view.View r0 = r9.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0087
            r1 = r3[r4]
            java.lang.String r1 = r1.getDisplayName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0087:
            int r0 = net.one97.paytm.recharge.R.id.second_operator_tv
            android.view.View r0 = r9.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x009c
            r1 = r3[r2]
            java.lang.String r1 = r1.getDisplayName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x009c:
            int r0 = net.one97.paytm.recharge.R.id.third_operator_tv
            android.view.View r0 = r9.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2
            if (r0 == 0) goto L_0x00b2
            r5 = r3[r1]
            java.lang.String r5 = r5.getDisplayName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x00b2:
            int r0 = net.one97.paytm.recharge.R.id.delhi_metro_click_view
            android.view.View r0 = r9.b((int) r0)
            if (r0 == 0) goto L_0x00bf
            r5 = r3[r4]
            r0.setTag(r5)
        L_0x00bf:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            r4 = r3[r4]
            r5 = 0
            if (r4 == 0) goto L_0x00d3
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r4 = r4.getAttributes()
            if (r4 == 0) goto L_0x00d3
            java.lang.String r4 = r4.getImage_url()
            goto L_0x00d4
        L_0x00d3:
            r4 = r5
        L_0x00d4:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r4)
            int r4 = net.one97.paytm.recharge.R.id.delhi_metro_iv
            android.view.View r4 = r9.b((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0.a((android.widget.ImageView) r4)
            int r0 = net.one97.paytm.recharge.R.id.hyd_metro_click_view
            android.view.View r0 = r9.b((int) r0)
            if (r0 == 0) goto L_0x00f0
            r4 = r3[r2]
            r0.setTag(r4)
        L_0x00f0:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            r2 = r3[r2]
            if (r2 == 0) goto L_0x0103
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x0103
            java.lang.String r2 = r2.getImage_url()
            goto L_0x0104
        L_0x0103:
            r2 = r5
        L_0x0104:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r2)
            int r2 = net.one97.paytm.recharge.R.id.hyd_metro_iv
            android.view.View r2 = r9.b((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.a((android.widget.ImageView) r2)
            int r0 = net.one97.paytm.recharge.R.id.bng_metro_click_view
            android.view.View r0 = r9.b((int) r0)
            if (r0 == 0) goto L_0x0120
            r2 = r3[r1]
            r0.setTag(r2)
        L_0x0120:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            r1 = r3[r1]
            if (r1 == 0) goto L_0x0132
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0132
            java.lang.String r5 = r1.getImage_url()
        L_0x0132:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            int r1 = net.one97.paytm.recharge.R.id.bng_metro_iv
            android.view.View r1 = r9.b((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.e():void");
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63260a;

        l(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63260a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            this.f63260a.onBackPressed();
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63261a;

        m(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63261a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            AJRTicketOptionsActivity.a(this.f63261a);
            net.one97.paytm.recharge.ordersummary.h.d b2 = this.f63261a.A;
            if (b2 != null) {
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                CJRUtilityVariantV2 c2 = this.f63261a.f63250h;
                String a2 = c.a.a(c2 != null ? c2.getFilterName() : null);
                String str = ab.f61496a;
                kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
                net.one97.paytm.recharge.ordersummary.h.d.a(b2, a2, "state_dropdown_clicked", "", "", str, (Object) null, (Object) null, 96);
            }
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63262a;

        n(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63262a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            View b2 = this.f63262a.b(R.id.metro_selection_drop_down_lyt);
            kotlin.g.b.k.a((Object) b2, "metro_selection_drop_down_lyt");
            b2.setVisibility(8);
            this.f63262a.n = false;
            ((ImageView) this.f63262a.b(R.id.down_arrow_in_toolbar_iv)).setImageResource(R.drawable.down_arrow_hide);
        }
    }

    /* access modifiers changed from: private */
    public final Map<Long, List<CJRActiveMetroTicketModel>> a(List<? extends CJRActiveMetroTicketModel> list) {
        Collection collection;
        List<? extends CJRUtilityVariantV2> list2 = this.f63251i;
        if (list2 == null) {
            return null;
        }
        Iterable<CJRUtilityVariantV2> iterable = list2;
        Map<Long, List<CJRActiveMetroTicketModel>> linkedHashMap = new LinkedHashMap<>(kotlin.j.e.b(ae.a(kotlin.a.k.a(iterable)), 16));
        for (CJRUtilityVariantV2 cJRUtilityVariantV2 : iterable) {
            CJRUtilityProductV2 product = cJRUtilityVariantV2.getProduct();
            kotlin.g.b.k.a((Object) product, "variant.product");
            Long valueOf = Long.valueOf(product.getId());
            if (list != null) {
                collection = new ArrayList();
                for (Object next : list) {
                    long productId = ((CJRActiveMetroTicketModel) next).getProductId();
                    CJRUtilityProductV2 product2 = cJRUtilityVariantV2.getProduct();
                    kotlin.g.b.k.a((Object) product2, "variant.product");
                    if (productId == product2.getId()) {
                        collection.add(next);
                    }
                }
            } else {
                collection = new ArrayList();
            }
            o oVar = new o(valueOf, (List) collection);
            linkedHashMap.put(oVar.getFirst(), oVar.getSecond());
        }
        return linkedHashMap;
    }

    public final void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z2) {
        kotlin.g.b.k.c(cJRUtilityVariantV2, "variant");
        kotlin.g.b.k.c(list, "tickets");
        net.one97.paytm.recharge.metro.c.a aVar = new net.one97.paytm.recharge.metro.c.a();
        q<? super CJRUtilityVariantV2, ? super List<? extends CJRActiveMetroTicketModel>, ? super Boolean, x> cVar = new c(aVar, this, z2, cJRUtilityVariantV2, list);
        kotlin.g.b.k.c(cVar, "listner");
        aVar.f63275c = cVar;
        kotlin.g.b.k.c(cJRUtilityVariantV2, "variant");
        kotlin.g.b.k.c(list, "tickets");
        aVar.f63274b = list;
        aVar.f63273a = cJRUtilityVariantV2;
        aVar.f63276d = z2;
        aVar.show(getSupportFragmentManager(), "");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(2:3|(4:5|(2:7|(1:9)(1:10))|(2:12|27)(1:26)|24)(1:25))|13|(1:15)|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0098 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r7, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "variant"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r7 = "tickets"
            kotlin.g.b.k.c(r8, r7)
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x00a7 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a7 }
            r7.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x00a7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x00a7 }
        L_0x0019:
            boolean r0 = r8.hasNext()     // Catch:{ Exception -> 0x00a7 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0050
            java.lang.Object r0 = r8.next()     // Catch:{ Exception -> 0x00a7 }
            r3 = r0
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3     // Catch:{ Exception -> 0x00a7 }
            net.one97.paytm.recharge.metro.f.c$e r4 = net.one97.paytm.recharge.metro.f.c.e.RETURN     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = r4.getValue()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r5 = r3.getType()     // Catch:{ Exception -> 0x00a7 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00a7 }
            if (r4 != 0) goto L_0x004a
            net.one97.paytm.recharge.metro.f.c$e r4 = net.one97.paytm.recharge.metro.f.c.e.RETURN     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = r4.getValue()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r3.getSubType()     // Catch:{ Exception -> 0x00a7 }
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            if (r1 == 0) goto L_0x0019
            r7.add(r0)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x0019
        L_0x0050:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r8 = r7.get(r2)     // Catch:{ Exception -> 0x00a7 }
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r8 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r8     // Catch:{ Exception -> 0x00a7 }
            r8.setEnable(r1)     // Catch:{ Exception -> 0x00a7 }
            androidx.recyclerview.widget.RecyclerView$a<net.one97.paytm.recharge.metro.d.d> r8 = r6.l     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x0062
            r8.notifyDataSetChanged()     // Catch:{ Exception -> 0x00a7 }
        L_0x0062:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0098 }
            r8.<init>()     // Catch:{ all -> 0x0098 }
            r0 = r8
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "event_category"
            java.lang.String r3 = "mumbai_metro_qr_ticket"
            r0.put(r1, r3)     // Catch:{ all -> 0x0098 }
            r0 = r8
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "screenName"
            java.lang.String r3 = "/mumbai-metro-qr-ticket"
            r0.put(r1, r3)     // Catch:{ all -> 0x0098 }
            r0 = r8
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "event_action"
            java.lang.String r3 = "activate_return_ticket"
            r0.put(r1, r3)     // Catch:{ all -> 0x0098 }
            r0 = r8
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "vertical_name"
            java.lang.String r3 = "recharges_utilities"
            r0.put(r1, r3)     // Catch:{ all -> 0x0098 }
            net.one97.paytm.recharge.di.helper.b r0 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0098 }
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x0098 }
            net.one97.paytm.recharge.di.helper.b.a((java.util.HashMap<java.lang.String, java.lang.Object>) r8, (android.content.Context) r0)     // Catch:{ all -> 0x0098 }
        L_0x0098:
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a     // Catch:{ Exception -> 0x00a7 }
            r8 = r6
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x00a7 }
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7     // Catch:{ Exception -> 0x00a7 }
            net.one97.paytm.recharge.metro.f.c.a.a((android.content.Context) r8, (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7)     // Catch:{ Exception -> 0x00a7 }
            return
        L_0x00a7:
            r7 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r8 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r8.debugLogExceptions(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, java.util.List):void");
    }

    public static final class g extends RecyclerView.a<net.one97.paytm.recharge.metro.d.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63255a;

        g(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63255a = aJRTicketOptionsActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.List} */
        /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.Long] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r4, int r5) {
            /*
                r3 = this;
                net.one97.paytm.recharge.metro.d.d r4 = (net.one97.paytm.recharge.metro.d.d) r4
                java.lang.String r0 = "holder"
                kotlin.g.b.k.c(r4, r0)
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r0 = r3.f63255a
                java.util.List r0 = r0.f63251i
                if (r0 != 0) goto L_0x0012
                kotlin.g.b.k.a()
            L_0x0012:
                java.lang.Object r5 = r0.get(r5)
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r0 = r3.f63255a
                java.util.Map r0 = r0.m
                r1 = 0
                if (r0 == 0) goto L_0x0036
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r2 = r5.getProduct()
                if (r2 == 0) goto L_0x002f
                long r1 = r2.getId()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
            L_0x002f:
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.util.List r1 = (java.util.List) r1
            L_0x0036:
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r0 = r3.f63255a
                android.content.Context r0 = (android.content.Context) r0
                r4.a(r5, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.g.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            net.one97.paytm.recharge.metro.d.d dVar;
            kotlin.g.b.k.c(viewGroup, "parent");
            m.a aVar = net.one97.paytm.recharge.metro.d.m.f63517a;
            LayoutInflater layoutInflater = this.f63255a.getLayoutInflater();
            kotlin.g.b.k.a((Object) layoutInflater, "layoutInflater");
            d.a aVar2 = this.f63255a;
            kotlin.g.b.k.c(layoutInflater, "inflater");
            c.d.a aVar3 = c.d.Companion;
            switch (net.one97.paytm.recharge.metro.d.n.f63518a[c.d.a.a(i2).ordinal()]) {
                case 1:
                    View inflate = layoutInflater.inflate(R.layout.recent_journey_optional_layout_new, (ViewGroup) null, false);
                    RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
                    kotlin.g.b.k.a((Object) inflate, "itemView");
                    inflate.setLayoutParams(layoutParams);
                    dVar = new net.one97.paytm.recharge.metro.d.h(inflate, aVar2, layoutInflater);
                    break;
                case 2:
                    View inflate2 = layoutInflater.inflate(R.layout.active_metro_ticket_item_2, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate2, "itemView");
                    dVar = new net.one97.paytm.recharge.metro.d.a(inflate2, aVar2);
                    break;
                case 3:
                    View inflate3 = layoutInflater.inflate(R.layout.metro_pass_trips_left_lyt, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate3, "itemView");
                    dVar = new net.one97.paytm.recharge.metro.d.c(inflate3, aVar2);
                    break;
                case 4:
                    View inflate4 = layoutInflater.inflate(R.layout.metro_pass_validity_layout, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate4, "itemView");
                    dVar = new net.one97.paytm.recharge.metro.d.b(inflate4, aVar2);
                    break;
                case 5:
                    View inflate5 = layoutInflater.inflate(R.layout.metro_list_heading, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate5, "itemView");
                    TextView textView = (TextView) inflate5.findViewById(R.id.headingText);
                    kotlin.g.b.k.a((Object) textView, "itemView.headingText");
                    textView.setVisibility(0);
                    dVar = new net.one97.paytm.recharge.metro.d.o(inflate5, aVar2);
                    break;
                case 6:
                    View inflate6 = layoutInflater.inflate(R.layout.metro_item_with_sub_heading, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate6, "itemView");
                    dVar = new net.one97.paytm.recharge.metro.d.o(inflate6, aVar2);
                    break;
                default:
                    View inflate7 = layoutInflater.inflate(R.layout.metro_ticket_option_item_v2, (ViewGroup) null, false);
                    kotlin.g.b.k.a((Object) inflate7, "itemView");
                    dVar = new net.one97.paytm.recharge.metro.d.o(inflate7, aVar2);
                    break;
            }
            return dVar;
        }

        public final int getItemCount() {
            List f2 = this.f63255a.f63251i;
            if (f2 != null) {
                return f2.size();
            }
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.List} */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
            r2 = (r2 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r2.get(r7)).getProduct();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int getItemViewType(int r7) {
            /*
                r6 = this;
                r0 = 0
                if (r7 < 0) goto L_0x011d
                if (r7 != 0) goto L_0x002c
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r1 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                java.util.List r1 = r1.f63251i     // Catch:{ Exception -> 0x0115 }
                if (r1 == 0) goto L_0x002c
                java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r1     // Catch:{ Exception -> 0x0115 }
                if (r1 == 0) goto L_0x002c
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r1 = r1.getProduct()     // Catch:{ Exception -> 0x0115 }
                if (r1 == 0) goto L_0x002c
                long r1 = r1.getId()     // Catch:{ Exception -> 0x0115 }
                r3 = -1
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 != 0) goto L_0x002c
                net.one97.paytm.recharge.metro.f.c$d r7 = net.one97.paytm.recharge.metro.f.c.d.METRO_RECENTS_VIEW_TYPE     // Catch:{ Exception -> 0x0115 }
                int r7 = r7.getValue()     // Catch:{ Exception -> 0x0115 }
                return r7
            L_0x002c:
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r1 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                java.util.Map r1 = r1.m     // Catch:{ Exception -> 0x0115 }
                if (r1 == 0) goto L_0x005b
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r2 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                java.util.List r2 = r2.f63251i     // Catch:{ Exception -> 0x0115 }
                if (r2 == 0) goto L_0x0053
                java.lang.Object r2 = r2.get(r7)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r2     // Catch:{ Exception -> 0x0115 }
                if (r2 == 0) goto L_0x0053
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r2 = r2.getProduct()     // Catch:{ Exception -> 0x0115 }
                if (r2 == 0) goto L_0x0053
                long r2 = r2.getId()     // Catch:{ Exception -> 0x0115 }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0115 }
                goto L_0x0054
            L_0x0053:
                r2 = r0
            L_0x0054:
                java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0115 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0115 }
                goto L_0x005c
            L_0x005b:
                r1 = r0
            L_0x005c:
                if (r1 == 0) goto L_0x0087
                r2 = r1
                java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0115 }
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0115 }
                r3.<init>()     // Catch:{ Exception -> 0x0115 }
                java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x0115 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0115 }
            L_0x006c:
                boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0115 }
                if (r4 == 0) goto L_0x0083
                java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0115 }
                r5 = r4
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5     // Catch:{ Exception -> 0x0115 }
                boolean r5 = r5.isPass()     // Catch:{ Exception -> 0x0115 }
                if (r5 == 0) goto L_0x006c
                r3.add(r4)     // Catch:{ Exception -> 0x0115 }
                goto L_0x006c
            L_0x0083:
                r2 = r3
                java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x0115 }
                goto L_0x0088
            L_0x0087:
                r2 = r0
            L_0x0088:
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x00a1
                r5 = r2
                java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x0115 }
                boolean r5 = r5.isEmpty()     // Catch:{ Exception -> 0x0115 }
                r5 = r5 ^ r4
                if (r5 != r4) goto L_0x00a1
                java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r2 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r2     // Catch:{ Exception -> 0x0115 }
                java.lang.String r0 = r2.getProductType()     // Catch:{ Exception -> 0x0115 }
                goto L_0x00b7
            L_0x00a1:
                if (r1 == 0) goto L_0x00b7
                r2 = r1
                java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x0115 }
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0115 }
                r2 = r2 ^ r4
                if (r2 != r4) goto L_0x00b7
                java.lang.Object r2 = r1.get(r3)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r2 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r2     // Catch:{ Exception -> 0x0115 }
                java.lang.String r0 = r2.getProductType()     // Catch:{ Exception -> 0x0115 }
            L_0x00b7:
                if (r1 == 0) goto L_0x011d
                boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0115 }
                if (r1 != r4) goto L_0x011d
                if (r7 == 0) goto L_0x00c3
                if (r7 != r4) goto L_0x00e1
            L_0x00c3:
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r1 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                boolean r1 = r1.p     // Catch:{ Exception -> 0x0115 }
                if (r1 != 0) goto L_0x00e1
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r7 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                boolean r7 = r7.f63245c     // Catch:{ Exception -> 0x0115 }
                if (r7 == 0) goto L_0x00da
                net.one97.paytm.recharge.metro.f.c$d r7 = net.one97.paytm.recharge.metro.f.c.d.SUB_METRO_HEADING     // Catch:{ Exception -> 0x0115 }
                int r7 = r7.getValue()     // Catch:{ Exception -> 0x0115 }
                return r7
            L_0x00da:
                net.one97.paytm.recharge.metro.f.c$d r7 = net.one97.paytm.recharge.metro.f.c.d.METRO_HEADING     // Catch:{ Exception -> 0x0115 }
                int r7 = r7.getValue()     // Catch:{ Exception -> 0x0115 }
                return r7
            L_0x00e1:
                net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity r1 = r6.f63255a     // Catch:{ Exception -> 0x0115 }
                boolean r1 = r1.p     // Catch:{ Exception -> 0x0115 }
                if (r1 == 0) goto L_0x011d
                int r7 = r7 - r4
                int r1 = r6.getItemViewType(r7)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.recharge.metro.f.c$d r2 = net.one97.paytm.recharge.metro.f.c.d.SUB_METRO_HEADING     // Catch:{ Exception -> 0x0115 }
                int r2 = r2.getValue()     // Catch:{ Exception -> 0x0115 }
                if (r1 == r2) goto L_0x011d
                int r1 = r6.getItemViewType(r7)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.recharge.metro.f.c$d r2 = net.one97.paytm.recharge.metro.f.c.d.NONE     // Catch:{ Exception -> 0x0115 }
                int r2 = r2.getValue()     // Catch:{ Exception -> 0x0115 }
                if (r1 == r2) goto L_0x011d
                int r7 = r6.getItemViewType(r7)     // Catch:{ Exception -> 0x0115 }
                net.one97.paytm.recharge.metro.f.c$d r1 = net.one97.paytm.recharge.metro.f.c.d.METRO_HEADING     // Catch:{ Exception -> 0x0115 }
                int r1 = r1.getValue()     // Catch:{ Exception -> 0x0115 }
                if (r7 == r1) goto L_0x011d
                net.one97.paytm.recharge.metro.f.c$d r7 = net.one97.paytm.recharge.metro.f.c.d.SUB_METRO_HEADING     // Catch:{ Exception -> 0x0115 }
                int r7 = r7.getValue()     // Catch:{ Exception -> 0x0115 }
                return r7
            L_0x0115:
                r7 = move-exception
                java.lang.String r7 = r7.getMessage()
                com.paytm.utility.q.d(r7)
            L_0x011d:
                net.one97.paytm.recharge.metro.f.c$d$a r7 = net.one97.paytm.recharge.metro.f.c.d.Companion
                int r7 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r0)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.g.getItemViewType(int):int");
        }
    }

    public final void onBackPressed() {
        this.x = true;
        if (this.f63249g) {
            setResult(283);
        } else {
            setResult(203);
            finish();
        }
        super.onBackPressed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r11 = r0.getProductID();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (r3.isEmpty() == true) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        if (net.one97.paytm.recharge.metro.f.c.e.SVP.getValue().equals(r0.getProductType()) != false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        setResult(1, new android.content.Intent().putExtra("intent_extra_item_index", r6).putExtra("operator_variant", r5).putExtra("metro_qr_frequent_object", r15));
        finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder
            java.lang.String r1 = "operator_variant"
            java.lang.String r2 = "intent_extra_item_index"
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x00d3
            r0 = r15
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r0 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r0
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r6 = r14.f63251i
            if (r6 != 0) goto L_0x0015
            kotlin.g.b.k.a()
        L_0x0015:
            java.util.Iterator r6 = r6.iterator()
            r7 = 0
        L_0x001a:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x005c
            java.lang.Object r8 = r6.next()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r8 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r9 = r8.getProduct()
            java.lang.String r10 = "variant.product"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            long r9 = r9.getId()
            if (r0 == 0) goto L_0x0045
            java.lang.String r11 = r0.getProductID()
            if (r11 == 0) goto L_0x0045
            long r11 = java.lang.Long.parseLong(r11)
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            goto L_0x0049
        L_0x0045:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
        L_0x0049:
            boolean r12 = r11 instanceof java.lang.Long
            if (r12 != 0) goto L_0x004e
            goto L_0x0059
        L_0x004e:
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            int r7 = r7 + 1
            goto L_0x001a
        L_0x005c:
            r8 = r3
        L_0x005d:
            kotlin.o r5 = new kotlin.o
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.<init>(r6, r8)
            java.lang.Object r6 = r5.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            java.lang.Object r5 = r5.component2()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            if (r5 == 0) goto L_0x00c6
            java.util.Map<java.lang.Long, ? extends java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>> r7 = r14.m
            if (r7 == 0) goto L_0x0098
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r8 = r5.getProduct()
            if (r8 == 0) goto L_0x008a
            long r8 = r8.getId()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
        L_0x008a:
            java.lang.Object r3 = r7.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0098
            boolean r3 = r3.isEmpty()
            if (r3 == r4) goto L_0x00a8
        L_0x0098:
            net.one97.paytm.recharge.metro.f.c$e r3 = net.one97.paytm.recharge.metro.f.c.e.SVP
            java.lang.String r3 = r3.getValue()
            java.lang.String r0 = r0.getProductType()
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00c6
        L_0x00a8:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.content.Intent r0 = r0.putExtra(r2, r6)
            java.io.Serializable r5 = (java.io.Serializable) r5
            android.content.Intent r0 = r0.putExtra(r1, r5)
            java.io.Serializable r15 = (java.io.Serializable) r15
            java.lang.String r1 = "metro_qr_frequent_object"
            android.content.Intent r15 = r0.putExtra(r1, r15)
            r14.setResult(r4, r15)
            r14.finish()
            return
        L_0x00c6:
            r15 = r14
            android.content.Context r15 = (android.content.Context) r15
            int r0 = net.one97.paytm.recharge.R.string.you_cannot_purchase_a_new_ticket_until_the_active_tickets_are_used
            android.widget.Toast r15 = android.widget.Toast.makeText(r15, r0, r4)
            r15.show()
            return
        L_0x00d3:
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r0 = r14.f63251i
            if (r0 == 0) goto L_0x00dc
            int r0 = r0.size()
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            if (r0 <= 0) goto L_0x0107
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.content.Intent r0 = r0.putExtra(r2, r5)
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r2 = r14.f63251i
            if (r2 == 0) goto L_0x00f3
            java.lang.Object r2 = r2.get(r5)
            r3 = r2
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
        L_0x00f3:
            java.io.Serializable r3 = (java.io.Serializable) r3
            android.content.Intent r0 = r0.putExtra(r1, r3)
            java.io.Serializable r15 = (java.io.Serializable) r15
            java.lang.String r1 = "frequent_object"
            android.content.Intent r15 = r0.putExtra(r1, r15)
            r14.setResult(r4, r15)
            r14.finish()
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder):void");
    }

    /* access modifiers changed from: private */
    public final View a(long j2) {
        RecyclerView.LayoutManager layoutManager;
        List<? extends CJRUtilityVariantV2> list = this.f63251i;
        if (list != null && (!list.isEmpty())) {
            List<? extends CJRUtilityVariantV2> list2 = this.f63251i;
            if (list2 == null) {
                kotlin.g.b.k.a();
            }
            List<? extends CJRUtilityVariantV2> list3 = this.f63251i;
            if (list3 == null) {
                kotlin.g.b.k.a();
            }
            Collection arrayList = new ArrayList();
            Iterator it2 = list3.iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                CJRUtilityProductV2 product = ((CJRUtilityVariantV2) next).getProduct();
                kotlin.g.b.k.a((Object) product, "it.product");
                if (product.getId() == j2) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            int indexOf = list2.indexOf(((List) arrayList).get(0));
            List<? extends CJRUtilityVariantV2> list4 = this.f63251i;
            if (list4 == null) {
                kotlin.g.b.k.a();
            }
            int size = list4.size();
            if (indexOf >= 0 && size >= indexOf && (layoutManager = this.k) != null) {
                return layoutManager.getChildAt(indexOf);
            }
        }
        return null;
    }

    private static void a(View view) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.loading_threedots_lav);
            if (findViewById != null) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
                View findViewById2 = view.findViewById(R.id.layout_progress_view);
                kotlin.g.b.k.a((Object) findViewById2, "view.findViewById<View>(R.id.layout_progress_view)");
                findViewById2.setVisibility(0);
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1005) {
            if (i3 == 1006) {
                Object obj = null;
                Object serializableExtra = intent != null ? intent.getSerializableExtra("activeMetroTickets") : null;
                if (serializableExtra instanceof CJRActiveMetroTicketModel) {
                    obj = serializableExtra;
                }
                this.j = (CJRActiveMetroTicketModel) obj;
                g();
            }
        } else if (i2 == 602) {
            this.z = false;
        } else if (i2 != this.y) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 != 0) {
            h();
        } else {
            finish();
        }
    }

    public final void a() {
        CJRUtilityVariantV2 cJRUtilityVariantV2;
        if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
            ArrayList arrayList = new ArrayList(5);
            CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList = new CJRMetroQRFrequentOrderList();
            arrayList.addAll(this.f63247e);
            arrayList.addAll(this.f63246d);
            cJRMetroQRFrequentOrderList.setmOrderList(arrayList);
            if (cJRMetroQRFrequentOrderList.getmOrderList().size() > 0) {
                this.f63245c = true;
            }
            E = false;
            List<? extends CJRUtilityVariantV2> list = this.f63251i;
            if (!(list == null || (cJRUtilityVariantV2 = (CJRUtilityVariantV2) list.get(0)) == null)) {
                cJRUtilityVariantV2.setRecentsOrder(cJRMetroQRFrequentOrderList);
            }
            RecyclerView.a<net.one97.paytm.recharge.metro.d.d> aVar = this.l;
            if (aVar != null) {
                aVar.notifyItemChanged(0);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x028f A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0293 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02c9 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x030e A[Catch:{ all -> 0x0329 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "it.destination"
            java.lang.String r3 = "it.source"
            java.lang.String r4 = "frequentOrder"
            kotlin.g.b.k.c(r1, r4)
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r4 != 0) goto L_0x001a
            r18.f()
            return
        L_0x001a:
            net.one97.paytm.recharge.metro.f.d r4 = net.one97.paytm.recharge.metro.f.d.INSTANCE
            boolean r4 = r4.validateIsAlreadyClicked(r0)
            if (r4 == 0) goto L_0x0023
            return
        L_0x0023:
            java.lang.String r4 = r19.getProductSubType()
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            r6 = 0
            if (r5 != 0) goto L_0x0132
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0132
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0132
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.SJT
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0132
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.RJT
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0066
            goto L_0x0132
        L_0x0066:
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.SJT
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x012b
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.OUTWARD
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x012b
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.PENALTY
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x008c
            goto L_0x012b
        L_0x008c:
            net.one97.paytm.recharge.metro.f.c$c r5 = net.one97.paytm.recharge.metro.f.c.C1231c.RJT
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0124
            net.one97.paytm.recharge.metro.f.c$c r5 = net.one97.paytm.recharge.metro.f.c.C1231c.SJT
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0124
            net.one97.paytm.recharge.metro.f.c$c r5 = net.one97.paytm.recharge.metro.f.c.C1231c.QR
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x00b2
            goto L_0x0124
        L_0x00b2:
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.SVP
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x011d
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.STORE_VALUE
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x00cb
            goto L_0x011d
        L_0x00cb:
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.TP
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0116
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.TRIPPASS_10
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0116
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.TRIPPASS_30
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0116
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.TRIPPASS_45
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0116
            net.one97.paytm.recharge.metro.f.c$b r5 = net.one97.paytm.recharge.metro.f.c.b.TRIPPASS
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0116
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.TRIP_PASS
            java.lang.String r5 = r5.getValue()
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0114
            goto L_0x0116
        L_0x0114:
            r4 = r6
            goto L_0x0138
        L_0x0116:
            net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r4 = net.one97.paytm.recharge.metro.f.c.f63578c
            goto L_0x0138
        L_0x011d:
            net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r4 = net.one97.paytm.recharge.metro.f.c.f63580e
            goto L_0x0138
        L_0x0124:
            net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r4 = net.one97.paytm.recharge.metro.f.c.f63579d
            goto L_0x0138
        L_0x012b:
            net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r4 = net.one97.paytm.recharge.metro.f.c.f63579d
            goto L_0x0138
        L_0x0132:
            net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r4 = net.one97.paytm.recharge.metro.f.c.f63579d
        L_0x0138:
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r5 = r0.f63251i
            r7 = 0
            if (r5 == 0) goto L_0x019a
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x014a:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x0196
            java.lang.Object r9 = r5.next()
            r10 = r9
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r10 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r10
            if (r4 == 0) goto L_0x018f
            java.lang.String r11 = r10.getFilterName()
            if (r11 == 0) goto L_0x018f
            java.lang.String r10 = r10.getFilterName()
            java.lang.String r11 = "it.filterName"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            if (r10 == 0) goto L_0x0189
            java.lang.String r10 = r10.toLowerCase()
            java.lang.String r12 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r12)
            if (r4 == 0) goto L_0x0183
            java.lang.String r11 = r4.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r11)
            goto L_0x0190
        L_0x0183:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x0189:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x018f:
            r10 = 0
        L_0x0190:
            if (r10 == 0) goto L_0x014a
            r8.add(r9)
            goto L_0x014a
        L_0x0196:
            r4 = r8
            java.util.List r4 = (java.util.List) r4
            goto L_0x019b
        L_0x019a:
            r4 = r6
        L_0x019b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r8 = r19.getProductType()
            java.lang.String r9 = "frequentOrder.productType"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            int r8 = net.one97.paytm.recharge.metro.f.c.a.b((java.lang.String) r8)
            java.lang.String r8 = net.one97.paytm.recharge.metro.f.c.a.a((int) r8)
            r5.append(r8)
            java.lang.String r8 = "_landing"
            r5.append(r8)
            java.lang.String r13 = r5.toString()
            net.one97.paytm.recharge.ordersummary.h.d r9 = r0.A
            if (r9 == 0) goto L_0x01e6
            net.one97.paytm.recharge.metro.f.c$a r5 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = r0.f63250h
            if (r5 == 0) goto L_0x01ce
            java.lang.String r5 = r5.getFilterName()
            goto L_0x01cf
        L_0x01ce:
            r5 = r6
        L_0x01cf:
            java.lang.String r10 = net.one97.paytm.recharge.metro.f.c.a.a((java.lang.String) r5)
            java.lang.String r14 = net.one97.paytm.recharge.common.utils.ab.f61496a
            java.lang.String r5 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r15 = 0
            r16 = 0
            r17 = 96
            java.lang.String r11 = "recent_item_selected"
            java.lang.String r12 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x01e6:
            if (r4 == 0) goto L_0x032c
            int r5 = r4.size()
            if (r5 <= 0) goto L_0x032c
            java.lang.Object r4 = r4.get(r7)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r4 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r4
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r5 = r0.f63251i
            if (r5 == 0) goto L_0x0201
            int r5 = r5.indexOf(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0202
        L_0x0201:
            r5 = r6
        L_0x0202:
            net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r8 = "Mumbai_Metro_All_recents"
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r8 = net.one97.paytm.recharge.metro.f.c.a.d((java.lang.String) r8)
            if (r8 == 0) goto L_0x021d
            if (r5 == 0) goto L_0x021d
            int r8 = r5.intValue()
            if (r8 == 0) goto L_0x021d
            int r5 = r5.intValue()
            int r5 = r5 + -1
            java.lang.Integer.valueOf(r5)
        L_0x021d:
            net.one97.paytm.recharge.common.utils.y r5 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = r0.f63250h
            if (r5 == 0) goto L_0x0228
            java.util.List r5 = r5.getVariants()
            goto L_0x0229
        L_0x0228:
            r5 = r6
        L_0x0229:
            net.one97.paytm.recharge.common.utils.y.b(r5)
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0329 }
            r5.<init>()     // Catch:{ all -> 0x0329 }
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r8 = r19.getSource()     // Catch:{ all -> 0x0329 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0329 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x0329 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0329 }
            if (r8 != 0) goto L_0x0282
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r8 = r19.getDestination()     // Catch:{ all -> 0x0329 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0329 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x0329 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0329 }
            if (r8 != 0) goto L_0x0282
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0329 }
            r8.<init>()     // Catch:{ all -> 0x0329 }
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r9 = r19.getSource()     // Catch:{ all -> 0x0329 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = r9.getName()     // Catch:{ all -> 0x0329 }
            r8.append(r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "_to_"
            r8.append(r3)     // Catch:{ all -> 0x0329 }
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = r19.getDestination()     // Catch:{ all -> 0x0329 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0329 }
            java.lang.String r2 = r3.getName()     // Catch:{ all -> 0x0329 }
            r8.append(r2)     // Catch:{ all -> 0x0329 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0329 }
            goto L_0x0283
        L_0x0282:
            r2 = r6
        L_0x0283:
            java.lang.String r3 = r19.getProductSubType()     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = "MUMBAI_METRO_SJT"
            boolean r8 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r8, (boolean) r7)     // Catch:{ all -> 0x0329 }
            if (r8 == 0) goto L_0x0293
            java.lang.String r6 = "single_journey"
            goto L_0x029d
        L_0x0293:
            java.lang.String r8 = "MUMBAI_METRO_RJT"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r8, (boolean) r7)     // Catch:{ all -> 0x0329 }
            if (r3 == 0) goto L_0x029d
            java.lang.String r6 = "return_journey"
        L_0x029d:
            java.lang.String r3 = r19.getProductType()     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = "MUMBAI_METRO_QR"
            boolean r8 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r8, (boolean) r7)     // Catch:{ all -> 0x0329 }
            java.lang.String r9 = "stations_name"
            java.lang.String r10 = "screenName"
            java.lang.String r11 = "event_category"
            if (r8 == 0) goto L_0x02c9
            if (r2 == 0) goto L_0x02b8
            r3 = r5
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0329 }
            r3.put(r9, r2)     // Catch:{ all -> 0x0329 }
        L_0x02b8:
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "mumbai_metro_qr_ticket"
            r2.put(r11, r3)     // Catch:{ all -> 0x0329 }
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "/mumbai-metro-qr-ticket"
            r2.put(r10, r3)     // Catch:{ all -> 0x0329 }
            goto L_0x0302
        L_0x02c9:
            java.lang.String r8 = "MUMBAI_METRO_TP"
            boolean r8 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r8, (boolean) r7)     // Catch:{ all -> 0x0329 }
            if (r8 == 0) goto L_0x02ea
            if (r2 == 0) goto L_0x02d9
            r3 = r5
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0329 }
            r3.put(r9, r2)     // Catch:{ all -> 0x0329 }
        L_0x02d9:
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "mumbai_metro_trip_pass"
            r2.put(r11, r3)     // Catch:{ all -> 0x0329 }
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "/mumbai-metro-trip-pass"
            r2.put(r10, r3)     // Catch:{ all -> 0x0329 }
            goto L_0x0302
        L_0x02ea:
            java.lang.String r2 = "MUMBAI_METRO_SVP"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r7)     // Catch:{ all -> 0x0329 }
            if (r2 == 0) goto L_0x0302
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "mumbai_metro_store_value_pass"
            r2.put(r11, r3)     // Catch:{ all -> 0x0329 }
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "/mumbai-metro-store-value-pass"
            r2.put(r10, r3)     // Catch:{ all -> 0x0329 }
        L_0x0302:
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "event_action"
            java.lang.String r7 = "recents_selected_inline"
            r2.put(r3, r7)     // Catch:{ all -> 0x0329 }
            if (r6 == 0) goto L_0x0316
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "journey_type"
            r2.put(r3, r6)     // Catch:{ all -> 0x0329 }
        L_0x0316:
            r2 = r5
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "vertical_name"
            java.lang.String r6 = "recharges_utilities"
            r2.put(r3, r6)     // Catch:{ all -> 0x0329 }
            net.one97.paytm.recharge.di.helper.b r2 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0329 }
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x0329 }
            net.one97.paytm.recharge.di.helper.b.a((java.util.HashMap<java.lang.String, java.lang.Object>) r5, (android.content.Context) r2)     // Catch:{ all -> 0x0329 }
        L_0x0329:
            r0.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r4, (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r1)
        L_0x032c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.a(net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r15) {
        /*
            r14 = this;
            boolean r0 = r14.x
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r0 = r14.f63251i
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.get(r15)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            net.one97.paytm.recharge.common.utils.y r2 = net.one97.paytm.recharge.common.utils.y.f61814b
            boolean r2 = r14.p
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001d
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r2 = r14.f63251i
            goto L_0x005e
        L_0x001d:
            boolean r2 = r14.f63245c
            if (r2 == 0) goto L_0x0054
            java.util.List<? extends net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r2 = r14.f63251i
            if (r2 == 0) goto L_0x005d
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
            r6 = 0
        L_0x0033:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r2.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x0044
            kotlin.a.k.a()
        L_0x0044:
            if (r6 == 0) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x004e
            r5.add(r7)
        L_0x004e:
            r6 = r8
            goto L_0x0033
        L_0x0050:
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            goto L_0x005e
        L_0x0054:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = r14.f63250h
            if (r2 == 0) goto L_0x005d
            java.util.List r2 = r2.getVariants()
            goto L_0x005e
        L_0x005d:
            r2 = r1
        L_0x005e:
            net.one97.paytm.recharge.common.utils.y.b(r2)
            r2 = r14
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 != 0) goto L_0x006e
            r14.f()
            return
        L_0x006e:
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            if (r0 == 0) goto L_0x008a
            java.lang.String r6 = r0.getFilterName()
            if (r6 == 0) goto L_0x008a
            if (r6 == 0) goto L_0x0084
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            goto L_0x008b
        L_0x0084:
            kotlin.u r15 = new kotlin.u
            r15.<init>(r2)
            throw r15
        L_0x008a:
            r6 = r1
        L_0x008b:
            net.one97.paytm.recharge.metro.f.c$a r7 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r7 = net.one97.paytm.recharge.metro.f.c.f63579d
            if (r7 == 0) goto L_0x014e
            java.lang.String r7 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00a4
            java.lang.String r2 = "metro_qr_ticket_clicked"
        L_0x00a2:
            r7 = r2
            goto L_0x00da
        L_0x00a4:
            net.one97.paytm.recharge.metro.f.c$a r7 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r7 = net.one97.paytm.recharge.metro.f.c.f63578c
            if (r7 == 0) goto L_0x0148
            java.lang.String r7 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00bd
            java.lang.String r2 = "trip_pass_clicked"
            goto L_0x00a2
        L_0x00bd:
            net.one97.paytm.recharge.metro.f.c$a r7 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r7 = net.one97.paytm.recharge.metro.f.c.f63580e
            if (r7 == 0) goto L_0x0142
            java.lang.String r2 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = "store_value_pass_clicked"
            goto L_0x00a2
        L_0x00d6:
            java.lang.String r2 = "smart_card_recharge_clicked"
            goto L_0x00a2
        L_0x00da:
            net.one97.paytm.recharge.ordersummary.h.d r5 = r14.A
            if (r5 == 0) goto L_0x0100
            net.one97.paytm.recharge.metro.f.c$a r2 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = r14.f63250h
            if (r2 == 0) goto L_0x00e9
            java.lang.String r2 = r2.getFilterName()
            goto L_0x00ea
        L_0x00e9:
            r2 = r1
        L_0x00ea:
            java.lang.String r6 = net.one97.paytm.recharge.metro.f.c.a.a((java.lang.String) r2)
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ab.f61496a
            java.lang.String r2 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            r11 = 0
            r12 = 0
            r13 = 96
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0100:
            boolean r2 = r14.p
            if (r2 != 0) goto L_0x0106
            int r15 = r15 + -1
        L_0x0106:
            if (r0 == 0) goto L_0x010d
            java.lang.String r2 = r0.getFilterName()
            goto L_0x010e
        L_0x010d:
            r2 = r1
        L_0x010e:
            java.lang.String r5 = "Smart Card Recharge"
            boolean r2 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0122
            boolean r2 = r14.w
            if (r2 != 0) goto L_0x0122
            if (r0 == 0) goto L_0x0121
            r14.z = r4
            r14.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0, (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r1)
        L_0x0121:
            return
        L_0x0122:
            boolean r1 = r14.z
            if (r1 != 0) goto L_0x0141
            r14.w = r4
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "intent_extra_item_index"
            android.content.Intent r15 = r1.putExtra(r2, r15)
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r1 = "operator_variant"
            android.content.Intent r15 = r15.putExtra(r1, r0)
            r14.setResult(r4, r15)
            r14.finish()
        L_0x0141:
            return
        L_0x0142:
            kotlin.u r15 = new kotlin.u
            r15.<init>(r2)
            throw r15
        L_0x0148:
            kotlin.u r15 = new kotlin.u
            r15.<init>(r2)
            throw r15
        L_0x014e:
            kotlin.u r15 = new kotlin.u
            r15.<init>(r2)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.a(int):void");
    }

    private final void f() {
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.METRO_TICKET, getString(R.string.no_connection), getString(R.string.no_internet));
    }

    public final void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z2, boolean z3) {
        String str;
        CJRUtilityAttributesV2 attributes;
        CJRUtilityFilterAttributesV2 attributes2;
        kotlin.g.b.k.c(cJRUtilityVariantV2, "variant");
        kotlin.g.b.k.c(list, "tickets");
        CJRUtilityFilterAttributesV2 attributes3 = cJRUtilityVariantV2.getAttributes();
        if (attributes3 == null || (str = attributes3.getConfig_ticket_type()) == null) {
            str = cJRUtilityVariantV2.getDisplayName();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("activeMetroTickets", (ArrayList) list);
        bundle.putString(StringSet.operator, str);
        bundle.putBoolean("show_single_tickets", z2);
        bundle.putBoolean("has_Penalty_tickets", z3);
        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63250h;
        String str2 = null;
        bundle.putString("metroTicketVariant", cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getFilterName() : null);
        CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63250h;
        if (!(cJRUtilityVariantV23 == null || (attributes2 = cJRUtilityVariantV23.getAttributes()) == null)) {
            str2 = attributes2.getProductRequestType();
        }
        bundle.putString("metro_request_type", str2);
        CJRUtilityProductV2 product = cJRUtilityVariantV2.getProduct();
        bundle.putBoolean("is_cancellable", (product == null || (attributes = product.getAttributes()) == null) ? false : attributes.isCancellable());
        if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
            kotlin.g.b.k.a((Object) str, "operatorName");
            try {
                HashMap hashMap = new HashMap();
                if (p.a(str, "Metro QR Ticket", false)) {
                    hashMap.put("event_category", "mumbai_metro_qr_ticket");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-qr-ticket");
                } else if (p.a(str, "Trip Pass", false)) {
                    hashMap.put("event_category", "mumbai_metro_trip_pass");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-trip-pass");
                } else if (p.a(str, "Store Value Pass", false)) {
                    hashMap.put("event_category", "mumbai_metro_store_value_pass");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-store-value-pass");
                }
                hashMap.put("event_action", "tap_to_view_clicked");
                hashMap.put("vertical_name", "recharges_utilities");
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, (Context) this);
            } catch (Throwable unused) {
            }
            bundle.putString("vertical_name", this.B);
            net.one97.paytm.recharge.metro.c.g gVar = new net.one97.paytm.recharge.metro.c.g();
            gVar.setCancelable(true);
            gVar.setArguments(bundle);
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            gVar.show(supportFragmentManager, AJRTicketOptionsActivity.class.getName());
        }
    }

    public final void a(String str, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        kotlin.g.b.k.c(cJRActiveMetroTicketModel, "ticket");
        Intent putExtra = new Intent().putExtra(StringSet.operator, str).putExtra("activeMetroTickets", cJRActiveMetroTicketModel).putExtra("vertical_name", this.B);
        kotlin.g.b.k.a((Object) putExtra, "Intent()\n               …E, mCategoryVerticalName)");
        startActivity(new Intent(this, AJRActiveMetroTicketListActivity.class).putExtras(putExtra));
        this.j = cJRActiveMetroTicketModel;
        g();
    }

    private final void g() {
        Context context = this;
        if (com.paytm.utility.d.c(context)) {
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel = this.j;
            a(a(cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductId() : 0));
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
            }
            a2.setFlowName(flowName);
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setActionType(ACTION_TYPE.GET_ACTIVE_TICKET_AND_PASSES.name());
            }
            net.one97.paytm.recharge.metro.f.a.a("fetch_active_active_tickets", context, (b.a<List<CJRActiveMetroTicketModel>>) new d(this), (ai) new e(), (Object) a2);
        }
    }

    public static final class d implements b.a<List<CJRActiveMetroTicketModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63253a;

        d(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63253a = aJRTicketOptionsActivity;
        }

        public final /* synthetic */ void a(Object obj, boolean z) {
            List list;
            List list2 = (List) obj;
            long j = 0;
            if (list2 instanceof List) {
                AJRTicketOptionsActivity aJRTicketOptionsActivity = this.f63253a;
                CJRActiveMetroTicketModel i2 = aJRTicketOptionsActivity.j;
                if (i2 != null) {
                    j = i2.getProductId();
                }
                AJRTicketOptionsActivity.access$hideProgressBarOnChildView$334bf84d(aJRTicketOptionsActivity.a(j));
                AJRTicketOptionsActivity aJRTicketOptionsActivity2 = this.f63253a;
                aJRTicketOptionsActivity2.m = aJRTicketOptionsActivity2.a((List<? extends CJRActiveMetroTicketModel>) list2);
                RecyclerView.a k = this.f63253a.l;
                if (k != null) {
                    k.notifyDataSetChanged();
                }
            } else if (this.f63253a.j != null) {
                AJRTicketOptionsActivity aJRTicketOptionsActivity3 = this.f63253a;
                CJRActiveMetroTicketModel i3 = aJRTicketOptionsActivity3.j;
                if (i3 != null) {
                    j = i3.getProductId();
                }
                AJRTicketOptionsActivity.access$hideProgressBarOnChildView$334bf84d(aJRTicketOptionsActivity3.a(j));
                Map e2 = this.f63253a.m;
                if (e2 != null) {
                    CJRActiveMetroTicketModel i4 = this.f63253a.j;
                    list = (List) e2.get(i4 != null ? Long.valueOf(i4.getProductId()) : null);
                } else {
                    list = null;
                }
                if (!(list instanceof ArrayList)) {
                    list = null;
                }
                ArrayList arrayList = (ArrayList) list;
                if (arrayList != null) {
                    CJRActiveMetroTicketModel i5 = this.f63253a.j;
                    if (i5 == null) {
                        kotlin.g.b.k.a();
                    }
                    arrayList.add(i5);
                }
                RecyclerView.a k2 = this.f63253a.l;
                if (k2 != null) {
                    k2.notifyDataSetChanged();
                }
            }
            this.f63253a.j = null;
        }
    }

    public static final class e implements ai {
        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
        }

        e() {
        }
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_operator_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        kotlin.g.b.k.c(menu, "menu");
        MenuItem findItem = menu.findItem(R.id.change_operator);
        kotlin.g.b.k.a((Object) findItem, "item");
        findItem.getActionView().setOnClickListener(new k(this));
        return super.onPrepareOptionsMenu(menu);
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTicketOptionsActivity f63259a;

        k(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
            this.f63259a = aJRTicketOptionsActivity;
        }

        public final void onClick(View view) {
            this.f63259a.setResult(1009);
            this.f63259a.finish();
        }
    }

    public final View a(View.OnClickListener onClickListener) {
        kotlin.g.b.k.c(onClickListener, "clickListener");
        throw new kotlin.n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, View view) {
        net.one97.paytm.recharge.common.utils.f fVar = this.f63244b;
        if (fVar != null) {
            fVar.a(this, str, view);
        }
    }

    public final void a(String str, String str2, String str3) {
        net.one97.paytm.recharge.common.utils.f fVar = this.f63244b;
        if (fVar != null) {
            fVar.a((Activity) this, str, str2, str3);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.recharge.common.utils.f fVar;
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        f.a aVar = net.one97.paytm.recharge.common.utils.f.f61626a;
        if (i2 != net.one97.paytm.recharge.common.utils.f.f61627f || (fVar = this.f63244b) == null || !fVar.a((Activity) this, i2, strArr, iArr)) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public static final class b extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        private final int f63252a;

        public b(int i2) {
            this.f63252a = i2;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            kotlin.g.b.k.c(rect, "outRect");
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(recyclerView, "parent");
            kotlin.g.b.k.c(sVar, "state");
            rect.bottom = this.f63252a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        r3 = r3.getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h() {
        /*
            r33 = this;
            r0 = r33
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r1 = r33.i()
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r1 = net.one97.paytm.recharge.metro.f.c.a.d((java.lang.String) r1)
            r0.s = r1
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r1 = r0.s
            if (r1 == 0) goto L_0x002e
            if (r1 == 0) goto L_0x0022
            java.util.List r1 = r1.getmOrderList()
            if (r1 == 0) goto L_0x0022
            boolean r1 = r1.isEmpty()
            r2 = 1
            if (r1 != r2) goto L_0x0022
            goto L_0x002e
        L_0x0022:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r1 = r0.s
            if (r1 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            r0.a((net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList) r1)
            goto L_0x0121
        L_0x002e:
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r1 = net.one97.paytm.recharge.di.helper.c.aq()
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0121
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r8 = r2
            java.util.Map r8 = (java.util.Map) r8
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = com.paytm.utility.d.a(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.String r3 = ""
        L_0x0050:
            java.lang.String r4 = "sso_token"
            r8.put(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "?customer_id="
            r3.<init>(r4)
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "&reqtype="
            r2.<init>(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = r0.f63250h
            r4 = 0
            if (r3 == 0) goto L_0x0083
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r3 = r3.getAttributes()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = r3.getProductRequestType()
            goto L_0x0084
        L_0x0083:
            r3 = r4
        L_0x0084:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r2)
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r9 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r9.getFlowName()
            if (r1 != 0) goto L_0x00c9
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r10 = r1
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 1048575(0xfffff, float:1.469367E-39)
            r32 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
        L_0x00c9:
            r9.setFlowName(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r9.getFlowName()
            if (r1 == 0) goto L_0x00db
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x00db:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r9.getFlowName()
            if (r1 == 0) goto L_0x00ea
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_LANDING_RECENT
            java.lang.String r2 = r2.name()
            r1.setActionType(r2)
        L_0x00ea:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r9.getFlowName()
            if (r1 == 0) goto L_0x00fb
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = r0.f63250h
            if (r2 == 0) goto L_0x00f8
            java.lang.String r4 = r2.getFilterName()
        L_0x00f8:
            r1.setVariantType(r4)
        L_0x00fb:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r9.getFlowName()
            if (r1 == 0) goto L_0x0106
            java.lang.String r2 = "metro_recents"
            r1.setTag(r2)
        L_0x0106:
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.b r1 = new net.one97.paytm.recharge.common.f.b
            r6 = r0
            net.one97.paytm.recharge.common.e.ai r6 = (net.one97.paytm.recharge.common.e.ai) r6
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2 r2 = new net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2
            r2.<init>()
            r7 = r2
            com.paytm.network.model.IJRPaytmDataModel r7 = (com.paytm.network.model.IJRPaytmDataModel) r7
            java.lang.String r4 = "metro_recents"
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            net.one97.paytm.recharge.common.f.a r1 = (net.one97.paytm.recharge.common.f.a) r1
            net.one97.paytm.recharge.common.f.d.b(r1)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity.h():void");
    }

    private final String i() {
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63250h;
        String filterName = cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null;
        if (filterName != null) {
            int hashCode = filterName.hashCode();
            if (hashCode != -1685566971) {
                if (hashCode != 485876509) {
                    return (hashCode == 1815361374 && !filterName.equals("Mumbai Metro")) ? "Mumbai_Metro_All_recents" : "Mumbai_Metro_All_recents";
                }
                if (filterName.equals("Hyderabad Metro")) {
                    return "Hyderabad_Metro_All_recents";
                }
            } else if (filterName.equals("Delhi Metro")) {
                return "Delhi_Metro_All_recents";
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList;
        kotlin.g.b.k.c(str, "tag");
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63250h;
        String str2 = null;
        if (!p.a("Mumbai Metro", cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null, true)) {
            CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63250h;
            if (cJRUtilityVariantV22 != null) {
                str2 = cJRUtilityVariantV22.getFilterName();
            }
            if (p.a("Delhi Metro", str2, true)) {
                if (iJRPaytmDataModel != null) {
                    cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMDelhiOrders();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
                }
            } else if (iJRPaytmDataModel != null) {
                cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMHyderabadOrders();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
            }
        } else if (iJRPaytmDataModel != null) {
            cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMMumbaiOrders();
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
        }
        this.s = cJRMetroQRFrequentOrderList;
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        String i2 = i();
        CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList2 = this.s;
        if (cJRMetroQRFrequentOrderList2 == null) {
            kotlin.g.b.k.a();
        }
        c.a.a(i2, cJRMetroQRFrequentOrderList2);
        CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList3 = this.s;
        if (cJRMetroQRFrequentOrderList3 == null) {
            kotlin.g.b.k.a();
        }
        a(cJRMetroQRFrequentOrderList3);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        ProgressBar progressBar = this.r;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        RecyclerView recyclerView = this.q;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        if (networkCustomError == null) {
            return;
        }
        if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, this.y, obj, 20, (Object) null);
        } else if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    private final void a(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
        CJRUtilityVariantV2 cJRUtilityVariantV2;
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        List<CJRMetroQRFrequentOrder> list = cJRMetroQRFrequentOrderList.getmOrderList();
        kotlin.g.b.k.a((Object) list, "metroQRFrequentOrderList.getmOrderList()");
        List<CJRMetroQRFrequentOrder> e2 = c.a.e(list);
        int size = e2.size() - 1;
        E = size > 2;
        int i2 = 0;
        while (i2 <= size && i2 < 3) {
            this.f63247e.add(e2.get(i2));
            i2++;
        }
        while (i2 <= size && i2 < 5) {
            this.f63246d.add(e2.get(i2));
            i2++;
        }
        CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList2 = new CJRMetroQRFrequentOrderList();
        cJRMetroQRFrequentOrderList2.setmOrderList(this.f63247e);
        if (cJRMetroQRFrequentOrderList2.getmOrderList().size() > 0) {
            this.f63245c = true;
        }
        List<? extends CJRUtilityVariantV2> list2 = this.f63251i;
        if (!(list2 == null || (cJRUtilityVariantV2 = (CJRUtilityVariantV2) list2.get(0)) == null)) {
            cJRUtilityVariantV2.setRecentsOrder(cJRMetroQRFrequentOrderList2);
        }
        RecyclerView.a<net.one97.paytm.recharge.metro.d.d> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.notifyItemChanged(0);
        }
        ProgressBar progressBar = this.r;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        RecyclerView recyclerView = this.q;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private final void a(CJRUtilityVariantV2 cJRUtilityVariantV2, CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
        Intent putExtra = new Intent(this, AJRMetroTicketPurchaseActivity.class).putExtra("fast_forward", this.t).putExtra("source", "").putExtra("input_fields", "");
        if (cJRUtilityVariantV2 == null) {
            kotlin.g.b.k.a();
        }
        Intent putExtra2 = putExtra.putExtra("group_field", a(cJRUtilityVariantV2)).putExtra("extra_home_data", this.u).putExtra("productVariant", cJRUtilityVariantV2).putExtra("is_help_section_enabled", this.v).putExtra("vertical_name", this.B).putExtra("metroTicketVariant", this.f63250h);
        kotlin.g.b.k.a((Object) putExtra2, "Intent(this@AJRTicketOpt…TICKET_VARIANT, mProduct)");
        if (cJRMetroQRFrequentOrder != null) {
            putExtra2.putExtra("metro_qr_frequent_object", cJRMetroQRFrequentOrder);
        }
        putExtra2.setFlags(603979776);
        startActivityForResult(putExtra2, 602);
    }

    private final String a(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        StringBuilder sb = new StringBuilder();
        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63250h;
        sb.append(cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getDisplayName() : null);
        sb.append("/");
        sb.append(cJRUtilityVariantV2.getDisplayName());
        return sb.toString();
    }

    public final void onDestroy() {
        this.w = false;
        this.x = false;
        super.onDestroy();
    }

    public static final /* synthetic */ void a(AJRTicketOptionsActivity aJRTicketOptionsActivity, View view) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        List<? extends CJRUtilityVariantV2> list = aJRTicketOptionsActivity.o;
        if (list != null) {
            if (list == null) {
                kotlin.g.b.k.a();
            }
            if (list.size() != 0) {
                Object tag = view != null ? view.getTag() : null;
                if (!(tag instanceof CJRUtilityVariantV2)) {
                    tag = null;
                }
                CJRUtilityVariantV2 cJRUtilityVariantV2 = (CJRUtilityVariantV2) tag;
                List<? extends CJRUtilityVariantV2> list2 = aJRTicketOptionsActivity.o;
                if (list2 == null) {
                    kotlin.g.b.k.a();
                }
                int size = list2.size();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    List<? extends CJRUtilityVariantV2> list3 = aJRTicketOptionsActivity.o;
                    if (list3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (kotlin.g.b.k.a((Object) (CJRUtilityVariantV2) list3.get(i3), (Object) cJRUtilityVariantV2)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (!(cJRUtilityVariantV2 == null || TextUtils.isEmpty(cJRUtilityVariantV2.getFilterName()) || (dVar = aJRTicketOptionsActivity.A) == null)) {
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    CJRUtilityVariantV2 cJRUtilityVariantV22 = aJRTicketOptionsActivity.f63250h;
                    String a2 = c.a.a(cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getFilterName() : null);
                    c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                    String a3 = c.a.a(cJRUtilityVariantV2.getFilterName());
                    String str = ab.f61496a;
                    kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, "state_dropdown_selected", "", a3, str, (Object) null, (Object) null, 96);
                }
                com.paytm.utility.q.d(String.valueOf(i2));
                com.paytm.utility.q.d(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getDisplayName() : null);
                net.one97.paytm.recharge.legacy.catalog.b.a a4 = net.one97.paytm.recharge.legacy.catalog.b.a.a();
                if (a4 != null) {
                    a4.a(aJRTicketOptionsActivity.o);
                }
                y yVar = y.f61814b;
                y.b((List<? extends CJRUtilityVariantV2>) null);
                Intent intent = new Intent();
                intent.putExtra("intent_extra_item_index", i2);
                intent.putExtra("from_ticket_option", true);
                aJRTicketOptionsActivity.setResult(1, intent);
                aJRTicketOptionsActivity.finish();
            }
        }
    }

    public static final /* synthetic */ void a(AJRTicketOptionsActivity aJRTicketOptionsActivity) {
        if (!aJRTicketOptionsActivity.n) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 0.0f, 0.0f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(700);
            View b2 = aJRTicketOptionsActivity.b(R.id.metro_selection_drop_down_lyt);
            kotlin.g.b.k.a((Object) b2, "metro_selection_drop_down_lyt");
            b2.setVisibility(0);
            aJRTicketOptionsActivity.n = true;
            ((ImageView) aJRTicketOptionsActivity.b(R.id.down_arrow_in_toolbar_iv)).setImageResource(R.drawable.up_arrow_show);
            return;
        }
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 180.0f, 0.0f, 0.0f);
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        rotateAnimation2.setDuration(700);
        View b3 = aJRTicketOptionsActivity.b(R.id.metro_selection_drop_down_lyt);
        kotlin.g.b.k.a((Object) b3, "metro_selection_drop_down_lyt");
        b3.setVisibility(8);
        aJRTicketOptionsActivity.n = false;
        ((ImageView) aJRTicketOptionsActivity.b(R.id.down_arrow_in_toolbar_iv)).setImageResource(R.drawable.down_arrow_hide);
    }

    public static final /* synthetic */ void access$hideProgressBarOnChildView$334bf84d(View view) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.layout_progress_view);
            kotlin.g.b.k.a((Object) findViewById, "view.findViewById<View>(R.id.layout_progress_view)");
            findViewById.setVisibility(8);
            View findViewById2 = view.findViewById(R.id.loading_threedots_lav);
            if (findViewById2 != null) {
                ((LottieAnimationView) findViewById2).cancelAnimation();
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }
}
