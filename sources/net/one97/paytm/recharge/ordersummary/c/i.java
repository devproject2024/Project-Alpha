package net.one97.paytm.recharge.ordersummary.c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.cst.CSTAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.i.f;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.d.r;

public final class i extends f implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f64074d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    Boolean f64075a = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public CJROrderedCart f64076b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64077c = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJROrderSummary f64078e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends CSTAttributes> f64079f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public List<? extends Object> f64080g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView.a<?> f64081h;

    /* renamed from: i  reason: collision with root package name */
    private View f64082i;
    private m j;
    private HashMap k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recharge_need_help_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        this.f64082i = view.findViewById(R.id.container_progress_bar);
        View view2 = this.f64082i;
        if (view2 != null) {
            view2.setVisibility(this.f64080g.size() == 0 ? 0 : 8);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        this.f64081h = new c(this);
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f64081h);
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        Drawable a2 = androidx.core.content.b.a(context, R.drawable.divider);
        if (a2 != null) {
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            a2.setColorFilter(androidx.core.content.b.c(context2, R.color.color_f3f7f8), PorterDuff.Mode.SRC_IN);
        }
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new g(a2, true));
        }
    }

    public static final class c extends RecyclerView.a<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f64087a;

        c(i iVar) {
            this.f64087a = iVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            k.c(bVar, "holder");
            bVar.f64083a.setText(this.f64087a.f64080g.get(i2).toString());
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            i iVar = this.f64087a;
            View inflate = LayoutInflater.from(iVar.getContext()).inflate(R.layout.content_recharge_help_options_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…ions_item, parent, false)");
            return new b(iVar, inflate);
        }

        public final int getItemCount() {
            return this.f64087a.f64080g.size();
        }
    }

    public final void a(Context context, j jVar, String str, m mVar) {
        ArrayList<CJROrderedCart> orderedCartList;
        k.c(mVar, "progressBarHandler");
        this.f64075a = Boolean.TRUE;
        this.j = mVar;
        if (context != null) {
            int i2 = 0;
            if (this.f64077c) {
                CJROrderSummary cJROrderSummary = this.f64078e;
                if (cJROrderSummary == null) {
                    k.a("mOrderSummary");
                }
                ArrayList<CJROrderedCart> orderedCartList2 = cJROrderSummary.getOrderedCartList();
                if ((orderedCartList2 != null ? orderedCartList2.size() : 0) != 1) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/order history page");
                        hashMap.put("contact_us_current_screen_type", "order_hostory");
                        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                        net.one97.paytm.recharge.di.helper.b.a("contact_us_clicked", (HashMap<String, Object>) hashMap, context);
                    } catch (Throwable unused) {
                    }
                    List<? extends Object> list = this.f64080g;
                    if (list != null) {
                        ArrayList arrayList = (ArrayList) list;
                        arrayList.clear();
                        CJROrderSummary cJROrderSummary2 = this.f64078e;
                        if (cJROrderSummary2 == null) {
                            k.a("mOrderSummary");
                        }
                        if (!(cJROrderSummary2 == null || (orderedCartList = cJROrderSummary2.getOrderedCartList()) == null)) {
                            for (CJROrderedCart cJROrderedCart : orderedCartList) {
                                k.a((Object) cJROrderedCart, "it");
                                arrayList.add(cJROrderedCart.getName());
                            }
                        }
                        RecyclerView.a<?> aVar = this.f64081h;
                        if (aVar != null) {
                            aVar.notifyDataSetChanged();
                        }
                        if (!isAdded() && !isVisible() && jVar != null) {
                            if (str == null) {
                                str = i.class.getSimpleName();
                            }
                            super.show(jVar, str);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>");
                }
            }
            CJROrderSummary cJROrderSummary3 = this.f64078e;
            if (cJROrderSummary3 == null) {
                k.a("mOrderSummary");
            }
            ArrayList<CJROrderedCart> orderedCartList3 = cJROrderSummary3.getOrderedCartList();
            if (orderedCartList3 != null) {
                int i3 = 0;
                for (Object next : orderedCartList3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.a.k.a();
                    }
                    CJROrderedCart cJROrderedCart2 = (CJROrderedCart) next;
                    k.a((Object) cJROrderedCart2, "item");
                    long id = cJROrderedCart2.getId();
                    CJROrderedCart cJROrderedCart3 = this.f64076b;
                    if (cJROrderedCart3 == null) {
                        k.a("mOrderedCart");
                    }
                    if (id == cJROrderedCart3.getId()) {
                        i2 = i3;
                    }
                    i3 = i4;
                }
            }
            a(context, i2);
        }
    }

    private final void a(Context context, String str) {
        String string = context.getString(R.string.recharge_need_help);
        k.a((Object) string, "context.getString(R.string.recharge_need_help)");
        String string2 = context.getString(R.string.ok);
        k.a((Object) string2, "context.getString(R.string.ok)");
        List a2 = kotlin.a.k.a(str);
        r.a aVar = r.f64226d;
        r.a.a(string, string2, (String) null, a2, (DialogInterface.OnClickListener) null).show(getChildFragmentManager(), r.class.getName());
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r2 = r5.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r5, int r6) {
        /*
            r4 = this;
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r5)
            if (r0 != 0) goto L_0x0038
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_HELP
            r1 = 0
            if (r5 == 0) goto L_0x001c
            android.content.res.Resources r2 = r5.getResources()
            if (r2 == 0) goto L_0x001c
            int r3 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r2 = r2.getString(r3)
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r5 == 0) goto L_0x002b
            android.content.res.Resources r3 = r5.getResources()
            if (r3 == 0) goto L_0x002b
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r3.getString(r1)
        L_0x002b:
            net.one97.paytm.recharge.common.utils.az.a(r5, r6, r0, r2, r1)
            android.app.Dialog r5 = r4.getDialog()
            if (r5 == 0) goto L_0x0037
            r5.dismiss()
        L_0x0037:
            return
        L_0x0038:
            android.os.Bundle r6 = r4.a((int) r6)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            if (r5 == 0) goto L_0x0051
            android.app.Activity r5 = (android.app.Activity) r5
            net.one97.paytm.m r1 = r4.j
            r0.getUpdatedCstOrderIssueIntent(r5, r6, r1)
            android.app.Dialog r5 = r4.getDialog()
            if (r5 == 0) goto L_0x0050
            r5.dismiss()
        L_0x0050:
            return
        L_0x0051:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type android.app.Activity"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.i.a(android.content.Context, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r1 = r1.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle a(int r5) {
        /*
            r4 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f64078e
            java.lang.String r2 = "mOrderSummary"
            if (r1 != 0) goto L_0x000e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x000e:
            r3 = 0
            if (r1 == 0) goto L_0x001e
            java.util.ArrayList r1 = r1.getOrderedCartList()
            if (r1 == 0) goto L_0x001e
            java.lang.Object r5 = r1.get(r5)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            goto L_0x001f
        L_0x001e:
            r5 = r3
        L_0x001f:
            if (r5 == 0) goto L_0x0033
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f64078e
            if (r1 != 0) goto L_0x0028
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0028:
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r1.getId()
            goto L_0x0030
        L_0x002f:
            r1 = r3
        L_0x0030:
            r5.setOrderId(r1)
        L_0x0033:
            if (r5 == 0) goto L_0x0045
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f64078e
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x003c:
            if (r1 == 0) goto L_0x0042
            java.lang.String r3 = r1.getCreatedAt()
        L_0x0042:
            r5.setCreatedAt(r3)
        L_0x0045:
            java.io.Serializable r5 = (java.io.Serializable) r5
            java.lang.String r1 = "intent_extra_cst_order_item"
            r0.putSerializable(r1, r5)
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r5 = new net.one97.paytm.common.entity.replacement.CJRReplacementReason
            r5.<init>()
            r1 = 1000001(0xf4241, float:1.4013E-39)
            r5.setParentIssueId(r1)
            java.io.Serializable r5 = (java.io.Serializable) r5
            java.lang.String r1 = "intent_extra_cst_order_reasons"
            r0.putSerializable(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.i.a(int):android.os.Bundle");
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f64083a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f64084b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f64085c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(i iVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f64084b = iVar;
            View findViewById = view.findViewById(R.id.icon);
            if (findViewById != null) {
                this.f64085c = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.option);
                if (findViewById2 != null) {
                    this.f64083a = (TextView) findViewById2;
                    this.f64085c.setVisibility(8);
                    view.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f64086a;

                        {
                            this.f64086a = r1;
                        }

                        public final void onClick(View view) {
                            Boolean bool = this.f64086a.f64084b.f64075a;
                            if (bool == null) {
                                k.a();
                            }
                            if (bool.booleanValue()) {
                                this.f64086a.f64084b.a(this.f64086a.f64084b.getContext(), this.f64086a.getAdapterPosition());
                            } else {
                                i.b(this.f64086a.f64084b, this.f64086a.f64084b.getContext(), this.f64086a.getAdapterPosition());
                            }
                        }
                    });
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r5 = r5.getOrderedCartList();
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.recharge.ordersummary.c.i r23, android.content.Context r24, int r25) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            if (r1 == 0) goto L_0x0363
            java.util.List<? extends java.lang.Object> r3 = r0.f64080g
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0012
            goto L_0x0363
        L_0x0012:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r4 = 1
            java.lang.String r5 = "from_deep_link"
            r3.putBoolean(r5, r4)
            boolean r5 = r0.f64077c
            java.lang.String r6 = "intent_extra_cst_order_item"
            java.lang.String r8 = "mOrderSummary"
            if (r5 == 0) goto L_0x029e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r0.f64078e
            if (r5 != 0) goto L_0x002c
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x002c:
            if (r5 == 0) goto L_0x0039
            java.util.ArrayList r5 = r5.getOrderedCartList()
            if (r5 == 0) goto L_0x0039
            int r5 = r5.size()
            goto L_0x003a
        L_0x0039:
            r5 = 1
        L_0x003a:
            if (r5 != r4) goto L_0x003e
            goto L_0x029e
        L_0x003e:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r0.f64078e
            if (r5 != 0) goto L_0x0045
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0045:
            if (r5 == 0) goto L_0x0054
            java.util.ArrayList r5 = r5.getOrderedCartList()
            if (r5 == 0) goto L_0x0054
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            if (r5 == 0) goto L_0x005c
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r10 = r5.getProductDetail()
            goto L_0x005d
        L_0x005c:
            r10 = 0
        L_0x005d:
            if (r5 == 0) goto L_0x0071
            net.one97.paytm.common.entity.shopping.CJROrderSummary r11 = r0.f64078e
            if (r11 != 0) goto L_0x0066
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0066:
            if (r11 == 0) goto L_0x006d
            java.lang.String r11 = r11.getId()
            goto L_0x006e
        L_0x006d:
            r11 = 0
        L_0x006e:
            r5.setOrderId(r11)
        L_0x0071:
            if (r5 == 0) goto L_0x0078
            java.lang.String r11 = r5.getItemStatus()
            goto L_0x0079
        L_0x0078:
            r11 = 0
        L_0x0079:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r12 = "22"
            java.lang.String r13 = "2"
            java.lang.String r14 = "15"
            if (r11 != 0) goto L_0x00d3
            if (r5 == 0) goto L_0x008e
            java.lang.String r11 = r5.getItemStatus()
            goto L_0x008f
        L_0x008e:
            r11 = 0
        L_0x008f:
            if (r11 != 0) goto L_0x0092
            goto L_0x00d3
        L_0x0092:
            int r15 = r11.hashCode()
            r9 = 49
            if (r15 == r9) goto L_0x00c9
            r9 = 50
            if (r15 == r9) goto L_0x00c2
            r9 = 1570(0x622, float:2.2E-42)
            if (r15 == r9) goto L_0x00b9
            r9 = 1572(0x624, float:2.203E-42)
            if (r15 == r9) goto L_0x00b2
            r9 = 1600(0x640, float:2.242E-42)
            if (r15 == r9) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            boolean r9 = r11.equals(r12)
            if (r9 == 0) goto L_0x00d3
            goto L_0x00d1
        L_0x00b2:
            boolean r9 = r11.equals(r14)
            if (r9 == 0) goto L_0x00d3
            goto L_0x00d1
        L_0x00b9:
            java.lang.String r9 = "13"
            boolean r9 = r11.equals(r9)
            if (r9 == 0) goto L_0x00d3
            goto L_0x00d1
        L_0x00c2:
            boolean r9 = r11.equals(r13)
            if (r9 == 0) goto L_0x00d3
            goto L_0x00d1
        L_0x00c9:
            java.lang.String r9 = "1"
            boolean r9 = r11.equals(r9)
            if (r9 == 0) goto L_0x00d3
        L_0x00d1:
            r9 = 1
            goto L_0x00d4
        L_0x00d3:
            r9 = 0
        L_0x00d4:
            java.lang.String r11 = "extra_intent_item_position"
            java.lang.String r15 = "cst-order-id"
            java.lang.String r7 = ""
            java.lang.String r4 = "From"
            if (r10 == 0) goto L_0x01d7
            long r18 = r10.getVerticalId()
            r20 = 4
            int r22 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r22 != 0) goto L_0x01d7
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r9 = net.one97.paytm.recharge.di.helper.c.ax()
            if (r9 == 0) goto L_0x012d
            java.lang.String r9 = r5.getItemStatus()
            r10 = 1
            boolean r9 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r9, (boolean) r10)
            if (r9 == 0) goto L_0x012d
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.ay()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0110
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x010d
            goto L_0x0110
        L_0x010d:
            r16 = 0
            goto L_0x0112
        L_0x0110:
            r16 = 1
        L_0x0112:
            if (r16 != 0) goto L_0x0119
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x0119:
            android.content.res.Resources r2 = r23.getResources()
            int r3 = net.one97.paytm.recharge.R.string.order_state_15_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "resources.getString(R.st…g.order_state_15_message)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x012d:
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r9 = net.one97.paytm.recharge.di.helper.c.aD()
            if (r9 == 0) goto L_0x0172
            java.lang.String r9 = r5.getItemStatus()
            r10 = 1
            boolean r9 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r9, (boolean) r10)
            if (r9 == 0) goto L_0x0172
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.aA()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0155
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x0152
            goto L_0x0155
        L_0x0152:
            r16 = 0
            goto L_0x0157
        L_0x0155:
            r16 = 1
        L_0x0157:
            if (r16 != 0) goto L_0x015e
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x015e:
            android.content.res.Resources r2 = r23.getResources()
            int r3 = net.one97.paytm.recharge.R.string.order_state_2_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "resources.getString(R.st…ng.order_state_2_message)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x0172:
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r9 = net.one97.paytm.recharge.di.helper.c.aC()
            if (r9 == 0) goto L_0x01b3
            java.lang.String r9 = r5.getItemStatus()
            r13 = 1
            boolean r9 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r9, (boolean) r13)
            if (r9 == 0) goto L_0x01b3
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.az()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0198
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x0197
            goto L_0x0198
        L_0x0197:
            r13 = 0
        L_0x0198:
            if (r13 != 0) goto L_0x019f
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x019f:
            android.content.res.Resources r2 = r23.getResources()
            int r3 = net.one97.paytm.recharge.R.string.order_state_22_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "resources.getString(R.st…g.order_state_22_message)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x01b3:
            r3.putString(r4, r7)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r0.f64078e
            if (r4 != 0) goto L_0x01bd
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01bd:
            if (r4 == 0) goto L_0x01c4
            java.lang.String r9 = r4.getId()
            goto L_0x01c5
        L_0x01c4:
            r9 = 0
        L_0x01c5:
            r3.putString(r15, r9)
            r3.putInt(r11, r2)
            java.io.Serializable r5 = (java.io.Serializable) r5
            r3.putSerializable(r6, r5)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r2.getCstOrderIssueIntent(r1, r3)
            goto L_0x035a
        L_0x01d7:
            r13 = 1
            net.one97.paytm.recharge.di.helper.c r12 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r12 = net.one97.paytm.recharge.di.helper.c.aE()
            if (r12 == 0) goto L_0x027a
            if (r10 == 0) goto L_0x027a
            long r17 = r10.getVerticalId()
            r19 = 16
            int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r10 != 0) goto L_0x027a
            if (r9 == 0) goto L_0x027a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r9 = r0.f64078e
            if (r9 != 0) goto L_0x01f5
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01f5:
            if (r9 == 0) goto L_0x01fc
            java.lang.String r9 = r9.getCreatedAt()
            goto L_0x01fd
        L_0x01fc:
            r9 = 0
        L_0x01fd:
            java.util.Date r9 = net.one97.paytm.recharge.common.utils.ab.a((java.lang.String) r9)
            if (r9 == 0) goto L_0x0208
            long r9 = r9.getTime()
            goto L_0x020a
        L_0x0208:
            r9 = 0
        L_0x020a:
            java.util.Date r12 = new java.util.Date
            r17 = 900000(0xdbba0, double:4.44659E-318)
            long r9 = r9 + r17
            r12.<init>(r9)
            java.util.Date r9 = new java.util.Date
            long r13 = java.lang.System.currentTimeMillis()
            r9.<init>(r13)
            int r9 = r12.compareTo(r9)
            r10 = -1
            if (r9 != r10) goto L_0x0248
            r3.putString(r4, r7)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r0.f64078e
            if (r4 != 0) goto L_0x022e
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x022e:
            if (r4 == 0) goto L_0x0235
            java.lang.String r9 = r4.getId()
            goto L_0x0236
        L_0x0235:
            r9 = 0
        L_0x0236:
            r3.putString(r15, r9)
            r3.putInt(r11, r2)
            java.io.Serializable r5 = (java.io.Serializable) r5
            r3.putSerializable(r6, r5)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r2.getCstOrderIssueIntent(r1, r3)
            goto L_0x035a
        L_0x0248:
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.aB()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x025d
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x025a
            goto L_0x025d
        L_0x025a:
            r16 = 0
            goto L_0x025f
        L_0x025d:
            r16 = 1
        L_0x025f:
            if (r16 != 0) goto L_0x0266
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x0266:
            android.content.res.Resources r2 = r23.getResources()
            int r3 = net.one97.paytm.recharge.R.string.vertical_16_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "resources.getString(R.string.vertical_16_message)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            goto L_0x035a
        L_0x027a:
            r3.putString(r4, r7)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r0.f64078e
            if (r4 != 0) goto L_0x0284
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0284:
            if (r4 == 0) goto L_0x028b
            java.lang.String r9 = r4.getId()
            goto L_0x028c
        L_0x028b:
            r9 = 0
        L_0x028c:
            r3.putString(r15, r9)
            r3.putInt(r11, r2)
            java.io.Serializable r5 = (java.io.Serializable) r5
            r3.putSerializable(r6, r5)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r2.getCstOrderIssueIntent(r1, r3)
            goto L_0x035a
        L_0x029e:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r0.f64076b
            if (r4 != 0) goto L_0x02a7
            java.lang.String r5 = "mOrderedCart"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x02a7:
            if (r4 == 0) goto L_0x02bb
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r0.f64078e
            if (r5 != 0) goto L_0x02b0
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x02b0:
            if (r5 == 0) goto L_0x02b7
            java.lang.String r9 = r5.getId()
            goto L_0x02b8
        L_0x02b7:
            r9 = 0
        L_0x02b8:
            r4.setOrderId(r9)
        L_0x02bb:
            java.io.Serializable r4 = (java.io.Serializable) r4
            r3.putSerializable(r6, r4)
            java.util.List<? extends java.lang.Object> r4 = r0.f64080g
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            boolean r4 = r4 instanceof net.one97.paytm.common.entity.replacement.CJRReplacementReason
            r5 = 3
            java.lang.String r6 = "intent_extra_level_number"
            java.lang.String r7 = "intent_extra_cst_order_reasons"
            if (r4 == 0) goto L_0x02eb
            java.util.List<? extends java.lang.Object> r4 = r0.f64080g
            java.lang.Object r2 = r4.get(r2)
            if (r2 == 0) goto L_0x02e3
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r2 = (net.one97.paytm.common.entity.replacement.CJRReplacementReason) r2
            java.io.Serializable r2 = (java.io.Serializable) r2
            r3.putSerializable(r7, r2)
            r3.putInt(r6, r5)
            goto L_0x0355
        L_0x02e3:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.common.entity.replacement.CJRReplacementReason"
            r0.<init>(r1)
            throw r0
        L_0x02eb:
            java.util.List<? extends java.lang.Object> r4 = r0.f64080g
            r8 = 0
            java.lang.Object r4 = r4.get(r8)
            boolean r4 = r4 instanceof net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue
            if (r4 == 0) goto L_0x0355
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r4 = new net.one97.paytm.common.entity.replacement.CJRReplacementReason
            r4.<init>()
            java.lang.String r8 = "Orders"
            r4.setIssueText(r8)
            r8 = 1000001(0xf4241, float:1.4013E-39)
            r4.setId(r8)
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r8 = new net.one97.paytm.common.entity.replacement.CJRReplacementReason
            r8.<init>()
            java.util.List<? extends java.lang.Object> r9 = r0.f64080g
            java.lang.Object r9 = r9.get(r2)
            java.lang.String r9 = r9.toString()
            r8.setIssueText(r9)
            java.io.Serializable r8 = (java.io.Serializable) r8
            java.lang.String r9 = "intent_extra_cst_order_reasons_l2"
            r3.putSerializable(r9, r8)
            r3.putInt(r6, r5)
            java.io.Serializable r4 = (java.io.Serializable) r4
            r3.putSerializable(r7, r4)
            java.util.List<? extends net.one97.paytm.common.entity.cst.CSTAttributes> r4 = r0.f64079f
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r5 = "cst_attributes"
            r3.putSerializable(r5, r4)
            java.util.List<? extends java.lang.Object> r4 = r0.f64080g
            java.lang.Object r2 = r4.get(r2)
            if (r2 == 0) goto L_0x034d
            net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue r2 = (net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue) r2
            net.one97.paytm.common.entity.cst.CJRCSTRaiseIssueNode r2 = r2.getNode()
            java.lang.String r4 = "(mHelpTopics.get(positio…as CJRCSTRaiseIssue).node"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r2 = r2.getId()
            java.lang.String r4 = "intent_extra_node_number"
            r3.putInt(r4, r2)
            goto L_0x0355
        L_0x034d:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue"
            r0.<init>(r1)
            throw r0
        L_0x0355:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r2.getCstOrderIssueIntent(r1, r3)
        L_0x035a:
            android.app.Dialog r0 = r23.getDialog()
            if (r0 == 0) goto L_0x0363
            r0.dismiss()
        L_0x0363:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.i.b(net.one97.paytm.recharge.ordersummary.c.i, android.content.Context, int):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
