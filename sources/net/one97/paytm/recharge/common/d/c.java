package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.v;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class c extends v.a {

    /* renamed from: a  reason: collision with root package name */
    final TextView f61016a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f61017b;

    /* renamed from: c  reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f61018c;

    /* renamed from: d  reason: collision with root package name */
    final List<CJRBrowsePlanProductList> f61019d;

    /* renamed from: e  reason: collision with root package name */
    final Object f61020e;

    /* renamed from: f  reason: collision with root package name */
    private View f61021f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f61022g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f61023h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f61024i;
    private final TextView j;
    private final ImageView k;
    private final TextView l;
    private final LinearLayout m;
    private final LinearLayout n;
    private final RelativeLayout o;
    private final TextView p;
    private final TextView q;
    private final String r = "#00aced";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(final View view, final w.b bVar, List<? extends CJRBrowsePlanProductList> list, Object obj) {
        super(view);
        k.c(view, "view");
        k.c(bVar, "mItemClickListner");
        k.c(list, "productList");
        this.f61019d = list;
        this.f61020e = obj;
        this.f61021f = view.findViewById(R.id.divider);
        this.f61022g = (TextView) view.findViewById(R.id.price_Text);
        this.f61016a = (TextView) view.findViewById(R.id.description);
        this.f61023h = (TextView) view.findViewById(R.id.validityTv);
        this.f61024i = (LinearLayout) view.findViewById(R.id.validityLL);
        this.j = (TextView) view.findViewById(R.id.dataTv);
        this.k = (ImageView) view.findViewById(R.id.expandIv);
        this.l = (TextView) view.findViewById(R.id.planCategoryTv);
        this.m = (LinearLayout) view.findViewById(R.id.dataLL);
        this.n = (LinearLayout) view.findViewById(R.id.mobileDataLL);
        this.o = (RelativeLayout) view.findViewById(R.id.planCategoryRl);
        this.p = (TextView) view.findViewById(R.id.selectText);
        this.q = (TextView) view.findViewById(R.id.talktimeTv);
        this.f61017b = (TextView) view.findViewById(R.id.readMoreTv);
        view.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f61025a;

            {
                this.f61025a = r1;
            }

            public final void onClick(View view) {
                if (this.f61025a.getAdapterPosition() >= 0) {
                    CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f61025a.f61019d.get(this.f61025a.getAdapterPosition());
                    cJRBrowsePlanProductList.setPlanCategoryDisplayName(c.b(cJRBrowsePlanProductList));
                    bVar.b(cJRBrowsePlanProductList);
                }
            }
        });
        TextView textView = this.p;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f61027a;

                {
                    this.f61027a = r1;
                }

                public final void onClick(View view) {
                    if (this.f61027a.getAdapterPosition() >= 0) {
                        CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f61027a.f61019d.get(this.f61027a.getAdapterPosition());
                        bVar.b(cJRBrowsePlanProductList);
                        try {
                            Context context = view.getContext();
                            k.a((Object) context, "view.context");
                            d dVar = new d(context);
                            String paytype = cJRBrowsePlanProductList.getPaytype();
                            k.a((Object) paytype, "item.paytype");
                            String displayName = cJRBrowsePlanProductList.getDisplayName();
                            if (displayName == null) {
                                displayName = "";
                            }
                            d.a(dVar, paytype, "plan_selected", displayName, (Object) null, (Object) null, (Object) null, (Object) null, 120);
                        } catch (Throwable th) {
                            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                        }
                    }
                }
            });
        }
        this.f61017b.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f61030a;

            {
                this.f61030a = r1;
            }

            public final void onClick(View view) {
                TextView textView = this.f61030a.f61016a;
                k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView.setMaxLines(Integer.MAX_VALUE);
                TextView textView2 = this.f61030a.f61017b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(8);
                View view2 = this.f61030a.itemView;
                k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                k.a((Object) context, "itemView.context");
                d dVar = new d(context);
                Object obj = this.f61030a.f61020e;
                if (obj == null) {
                    obj = "";
                }
                d.a(dVar, obj, "plan_details_expanded", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        });
    }

    static String b(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        HashMap<String, String> subCategoryMap = cJRBrowsePlanProductList.getSubCategoryMap();
        if (subCategoryMap == null || !(!subCategoryMap.isEmpty())) {
            return "";
        }
        Set<String> keySet = subCategoryMap.keySet();
        k.a((Object) keySet, "subCategoryMap.keys");
        Object[] array = keySet.toArray(new String[0]);
        if (array != null) {
            Object obj = array[0];
            k.a(obj, "subCategoryMap.keys.toTypedArray().get(0)");
            return (String) obj;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r12) {
        /*
            r11 = this;
            java.lang.String r0 = "product"
            kotlin.g.b.k.c(r12, r0)
            android.widget.TextView r0 = r11.f61022g
            java.lang.String r1 = "itemView.context"
            java.lang.String r2 = "itemView"
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0038
            android.view.View r5 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            android.content.Context r5 = r5.getContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            android.content.res.Resources r5 = r5.getResources()
            int r6 = net.one97.paytm.recharge.R.string.v3_recharge_rs
            java.lang.Object[] r7 = new java.lang.Object[r3]
            net.one97.paytm.recharge.widgets.c.d r8 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Double r8 = r12.getPrice()
            java.lang.String r8 = net.one97.paytm.recharge.widgets.c.d.a((java.lang.Double) r8)
            r7[r4] = r8
            java.lang.String r5 = r5.getString(r6, r7)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x0038:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x0042
            r5 = 2147483647(0x7fffffff, float:NaN)
            r0.setMaxLines(r5)
        L_0x0042:
            java.util.HashMap r0 = r12.getSubCategoryMap()
            java.lang.String r5 = r11.r
            if (r0 == 0) goto L_0x007d
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r3
            if (r6 != r3) goto L_0x007d
            java.lang.String r5 = b(r12)
            java.util.Collection r0 = r0.values()
            java.lang.String r6 = "subCategoryMap.values"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String[] r6 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r6)
            if (r0 == 0) goto L_0x0075
            r0 = r0[r4]
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0071
            java.lang.String r0 = r11.r
        L_0x0071:
            r10 = r5
            r5 = r0
            r0 = r10
            goto L_0x007f
        L_0x0075:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r12.<init>(r0)
            throw r12
        L_0x007d:
            java.lang.String r0 = ""
        L_0x007f:
            r6 = 8
            if (r0 == 0) goto L_0x00e4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x00e4
            android.widget.RelativeLayout r7 = r11.o
            if (r7 == 0) goto L_0x0092
            r7.setVisibility(r4)
        L_0x0092:
            android.widget.TextView r7 = r11.l
            if (r7 == 0) goto L_0x0099
            r7.setText(r0)
        L_0x0099:
            if (r5 == 0) goto L_0x00ee
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ee
            android.widget.TextView r0 = r11.l
            if (r0 == 0) goto L_0x00af
            int r7 = android.graphics.Color.parseColor(r5)
            r0.setTextColor(r7)
        L_0x00af:
            r0 = 9
            int r0 = com.paytm.utility.b.c((int) r0)
            android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
            r7.<init>()
            java.lang.String r8 = r11.r
            int r5 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r5, (java.lang.String) r8)
            r7.setColor(r5)
            float r0 = (float) r0
            r7.setCornerRadius(r0)
            android.widget.TextView r0 = r11.l
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setBackground(r7)
            android.widget.TextView r0 = r11.l
            java.lang.String r5 = "planCatgoryTv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            java.lang.String r5 = "planCatgoryTv.background"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r5 = 20
            r0.setAlpha(r5)
            goto L_0x00ee
        L_0x00e4:
            android.widget.RelativeLayout r0 = r11.o
            java.lang.String r5 = "planCategoryRl"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r6)
        L_0x00ee:
            java.lang.String r0 = r12.getData()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r7 = "(this as java.lang.String).toUpperCase()"
            java.lang.String r8 = "NA"
            if (r0 != 0) goto L_0x01ca
            java.lang.String r0 = r12.getData()
            java.lang.String r9 = "product.data"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            if (r0 == 0) goto L_0x01c4
            java.lang.String r0 = r0.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x011a
            goto L_0x01ca
        L_0x011a:
            android.widget.TextView r0 = r11.q
            if (r0 == 0) goto L_0x0121
            r0.setVisibility(r6)
        L_0x0121:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x0128
            r0.setVisibility(r4)
        L_0x0128:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x0135
            java.lang.String r1 = r12.getDescription()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0135:
            java.lang.String r0 = r12.getData()
            if (r0 == 0) goto L_0x016d
            java.lang.String r0 = r12.getData()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x016d
            java.lang.String r0 = r12.getData()
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r0 != 0) goto L_0x016d
            android.widget.TextView r0 = r11.j
            if (r0 == 0) goto L_0x0158
            r0.setVisibility(r4)
        L_0x0158:
            android.widget.LinearLayout r0 = r11.n
            if (r0 == 0) goto L_0x015f
            r0.setVisibility(r4)
        L_0x015f:
            android.widget.TextView r0 = r11.j
            if (r0 == 0) goto L_0x017b
            java.lang.String r1 = r12.getData()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x017b
        L_0x016d:
            android.widget.LinearLayout r0 = r11.n
            if (r0 == 0) goto L_0x0174
            r0.setVisibility(r6)
        L_0x0174:
            android.widget.TextView r0 = r11.j
            if (r0 == 0) goto L_0x017b
            r0.setVisibility(r6)
        L_0x017b:
            java.lang.String r0 = r12.getValidity()
            if (r0 == 0) goto L_0x01b4
            java.lang.String r0 = r12.getValidity()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b4
            java.lang.String r0 = r12.getValidity()
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r0 != 0) goto L_0x01b4
            android.widget.TextView r0 = r11.f61023h
            if (r0 == 0) goto L_0x019e
            r0.setVisibility(r4)
        L_0x019e:
            android.widget.LinearLayout r0 = r11.f61024i
            if (r0 == 0) goto L_0x01a5
            r0.setVisibility(r4)
        L_0x01a5:
            android.widget.TextView r0 = r11.f61023h
            if (r0 == 0) goto L_0x02c0
            java.lang.String r1 = r12.getValidity()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x02c0
        L_0x01b4:
            android.widget.TextView r0 = r11.f61023h
            if (r0 == 0) goto L_0x01bb
            r0.setVisibility(r6)
        L_0x01bb:
            android.widget.LinearLayout r0 = r11.f61024i
            if (r0 == 0) goto L_0x02c0
            r0.setVisibility(r6)
            goto L_0x02c0
        L_0x01c4:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r5)
            throw r12
        L_0x01ca:
            android.widget.TextView r0 = r11.f61023h
            if (r0 == 0) goto L_0x01d1
            r0.setVisibility(r6)
        L_0x01d1:
            android.widget.LinearLayout r0 = r11.f61024i
            if (r0 == 0) goto L_0x01d8
            r0.setVisibility(r6)
        L_0x01d8:
            java.lang.String r0 = r12.getTalktime()
            if (r0 == 0) goto L_0x0281
            java.lang.String r0 = r12.getTalktime()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0281
            java.lang.String r0 = r12.getTalktime()
            java.lang.String r9 = "product.talktime"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            if (r0 == 0) goto L_0x027b
            java.lang.String r0 = r0.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0281
            android.view.View r0 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.content.Context r0 = r0.getContext()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.res.Resources r0 = r0.getResources()
            int r5 = net.one97.paytm.recharge.R.string.zero_text
            java.lang.String r0 = r0.getString(r5)
            java.lang.String r5 = r12.getTalktime()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r4)
            if (r0 != 0) goto L_0x0281
            android.widget.LinearLayout r0 = r11.m
            if (r0 == 0) goto L_0x0229
            r0.setVisibility(r4)
        L_0x0229:
            android.widget.TextView r0 = r11.q
            if (r0 == 0) goto L_0x0230
            r0.setVisibility(r4)
        L_0x0230:
            android.widget.TextView r0 = r11.j
            if (r0 == 0) goto L_0x0237
            r0.setVisibility(r6)
        L_0x0237:
            android.widget.LinearLayout r0 = r11.n
            if (r0 == 0) goto L_0x023e
            r0.setVisibility(r6)
        L_0x023e:
            android.widget.TextView r0 = r11.f61023h
            if (r0 == 0) goto L_0x0245
            r0.setVisibility(r6)
        L_0x0245:
            android.widget.LinearLayout r0 = r11.f61024i
            if (r0 == 0) goto L_0x024c
            r0.setVisibility(r6)
        L_0x024c:
            android.widget.TextView r0 = r11.q
            if (r0 == 0) goto L_0x0273
            android.view.View r5 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            android.content.Context r2 = r5.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            android.content.res.Resources r1 = r2.getResources()
            int r2 = net.one97.paytm.recharge.R.string.browse_plan_talktime_text
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r5 = r12.getTalktime()
            r3[r4] = r5
            java.lang.String r1 = r1.getString(r2, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0273:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x02c0
            r0.setVisibility(r6)
            goto L_0x02c0
        L_0x027b:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r5)
            throw r12
        L_0x0281:
            android.widget.TextView r0 = r11.q
            if (r0 == 0) goto L_0x0288
            r0.setVisibility(r6)
        L_0x0288:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x028f
            r0.setVisibility(r4)
        L_0x028f:
            android.widget.LinearLayout r0 = r11.m
            if (r0 == 0) goto L_0x0296
            r0.setVisibility(r6)
        L_0x0296:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x02a3
            java.lang.String r3 = r12.getDescription()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x02a3:
            android.widget.TextView r0 = r11.f61016a
            if (r0 == 0) goto L_0x02c0
            android.view.View r3 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            android.content.Context r2 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            android.content.res.Resources r1 = r2.getResources()
            int r2 = net.one97.paytm.recharge.R.color.color_1d252d
            int r1 = r1.getColor(r2)
            r0.setTextColor(r1)
        L_0x02c0:
            android.view.ViewTreeObserver$OnPreDrawListener r0 = r11.f61018c
            java.lang.String r1 = "description"
            if (r0 == 0) goto L_0x02d4
            android.widget.TextView r0 = r11.f61016a
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            android.view.ViewTreeObserver$OnPreDrawListener r2 = r11.f61018c
            r0.removeOnPreDrawListener(r2)
        L_0x02d4:
            java.lang.String r0 = r12.getDescription()
            if (r0 == 0) goto L_0x02fd
            java.lang.String r12 = r12.getDescription()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x02fd
            net.one97.paytm.recharge.common.d.c$a r12 = new net.one97.paytm.recharge.common.d.c$a
            r12.<init>(r11)
            android.view.ViewTreeObserver$OnPreDrawListener r12 = (android.view.ViewTreeObserver.OnPreDrawListener) r12
            r11.f61018c = r12
            android.widget.TextView r12 = r11.f61016a
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            android.view.ViewTreeObserver r12 = r12.getViewTreeObserver()
            android.view.ViewTreeObserver$OnPreDrawListener r0 = r11.f61018c
            r12.addOnPreDrawListener(r0)
        L_0x02fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.d.c.a(net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList):void");
    }

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f61031a;

        a(c cVar) {
            this.f61031a = cVar;
        }

        public final boolean onPreDraw() {
            TextView textView = this.f61031a.f61016a;
            k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            if (textView.getLineCount() > 3) {
                TextView textView2 = this.f61031a.f61017b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f61031a.f61017b;
                k.a((Object) textView3, "readMoreTv");
                textView3.setVisibility(8);
            }
            TextView textView4 = this.f61031a.f61016a;
            k.a((Object) textView4, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView4.setMaxLines(3);
            if (this.f61031a.f61018c != null) {
                TextView textView5 = this.f61031a.f61016a;
                k.a((Object) textView5, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView5.getViewTreeObserver().removeOnPreDrawListener(this.f61031a.f61018c);
            }
            return false;
        }
    }
}
