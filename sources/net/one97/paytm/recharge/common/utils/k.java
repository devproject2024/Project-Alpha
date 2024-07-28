package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.PGMetaData;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.aa;
import net.one97.paytm.recharge.common.a.ad;
import net.one97.paytm.recharge.common.a.ah;

public final class k extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f61656b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public CJRRechargeCart f61657a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f61658c;

    public final View a(int i2) {
        if (this.f61658c == null) {
            this.f61658c = new HashMap();
        }
        View view = (View) this.f61658c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61658c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.google.android.material.bottomsheet.b a(CJRRechargeCart cJRRechargeCart) {
            kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
            k kVar = new k();
            Bundle bundle = new Bundle();
            bundle.putSerializable("cart_product", cJRRechargeCart);
            kVar.setArguments(bundle);
            return kVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("cart_product") : null;
        if (serializable != null) {
            this.f61657a = (CJRRechargeCart) serializable;
            setStyle(0, R.style.CustomBottomSheetDialogTheme);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.recharge_conv_detail_sheet, viewGroup, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v57, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v45, types: [android.view.View] */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02ed, code lost:
        if (r14.getVisibility() == 0) goto L_0x02ef;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r13, r0)
            super.onViewCreated(r13, r14)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r13 = r13.getApplicationContext()
            net.one97.paytm.recharge.di.helper.c r14 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashMap r14 = net.one97.paytm.recharge.di.helper.c.bm()
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashMap r0 = net.one97.paytm.recharge.di.helper.c.bn()
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashMap r1 = net.one97.paytm.recharge.di.helper.c.bo()
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r12.f61657a
            java.lang.String r3 = "rechargeCart"
            if (r2 != 0) goto L_0x0029
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0029:
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
            java.lang.String r4 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.util.ArrayList r2 = r2.getCartItems()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r8 = r2.hasNext()
            r9 = 1
            if (r8 == 0) goto L_0x00e6
            java.lang.Object r8 = r2.next()
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8
            java.lang.String r10 = "item"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r10 = r8.getVerticalId()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x008d
            if (r14 == 0) goto L_0x008d
            java.lang.String r10 = r8.getVerticalId()
            boolean r10 = r14.containsKey(r10)
            if (r10 != r9) goto L_0x008d
            java.lang.String r10 = r8.getVerticalId()
            java.lang.Object r10 = r14.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r10, (android.content.Context) r13)
            if (r10 == 0) goto L_0x008d
            r6.add(r8)
            goto L_0x004f
        L_0x008d:
            java.lang.String r10 = r8.getVerticalId()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00b9
            if (r0 == 0) goto L_0x00b9
            java.lang.String r10 = r8.getVerticalId()
            boolean r10 = r0.containsKey(r10)
            if (r10 != r9) goto L_0x00b9
            java.lang.String r10 = r8.getVerticalId()
            java.lang.Object r10 = r0.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r10, (android.content.Context) r13)
            if (r10 == 0) goto L_0x00b9
            r7.add(r8)
            goto L_0x004f
        L_0x00b9:
            java.lang.String r10 = r8.getVerticalId()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00e1
            if (r1 == 0) goto L_0x00e1
            java.lang.String r10 = r8.getVerticalId()
            boolean r10 = r1.containsKey(r10)
            if (r10 != r9) goto L_0x00e1
            java.lang.String r9 = r8.getVerticalId()
            java.lang.Object r9 = r1.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r9, (android.content.Context) r13)
            if (r9 != 0) goto L_0x004f
        L_0x00e1:
            r5.add(r8)
            goto L_0x004f
        L_0x00e6:
            int r13 = net.one97.paytm.recharge.R.id.payment_details_view
            android.view.View r13 = r12.a((int) r13)
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            java.lang.String r14 = "payment_details_view"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r12.getContext()
            r0.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r13.setLayoutManager(r0)
            int r13 = r5.size()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0 = r13
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r1 = 0
            if (r0 <= 0) goto L_0x0115
            r0 = 1
            goto L_0x0116
        L_0x0115:
            r0 = 0
        L_0x0116:
            r2 = 0
            if (r0 == 0) goto L_0x011a
            goto L_0x011b
        L_0x011a:
            r13 = r2
        L_0x011b:
            if (r13 == 0) goto L_0x0144
            java.lang.Number r13 = (java.lang.Number) r13
            r13.intValue()
            android.content.Context r13 = r12.getContext()
            if (r13 == 0) goto L_0x0144
            int r0 = net.one97.paytm.recharge.R.id.payment_details_view
            android.view.View r0 = r12.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)
            net.one97.paytm.recharge.common.a.ad r14 = new net.one97.paytm.recharge.common.a.ad
            java.lang.String r8 = "it"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            net.one97.paytm.recharge.common.a.ah r8 = net.one97.paytm.recharge.common.a.ah.RECHARGE_ITEMS
            r14.<init>(r5, r13, r8)
            androidx.recyclerview.widget.RecyclerView$a r14 = (androidx.recyclerview.widget.RecyclerView.a) r14
            r0.setAdapter(r14)
        L_0x0144:
            r12.b(r6)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r13 = kotlin.a.k.e(r7)
            r12.a((java.util.List<? extends net.one97.paytm.common.entity.shopping.CJRCartProduct>) r13)
            net.one97.paytm.common.entity.CJRRechargeCart r13 = r12.f61657a
            if (r13 != 0) goto L_0x0157
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0157:
            net.one97.paytm.common.entity.shopping.CJRCart r13 = r13.getCart()
            if (r13 == 0) goto L_0x01e6
            java.util.ArrayList r13 = r13.getCartItems()
            if (r13 == 0) goto L_0x01e6
            java.lang.Object r13 = r13.get(r1)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r13 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r13
            if (r13 == 0) goto L_0x01e6
            java.util.List r13 = r13.getmPGMetaData()
            if (r13 == 0) goto L_0x01e6
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x0179
            r14 = 1
            goto L_0x017a
        L_0x0179:
            r14 = 0
        L_0x017a:
            if (r14 == 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r13 = r2
        L_0x017e:
            if (r13 == 0) goto L_0x01e6
            int r14 = net.one97.paytm.recharge.R.id.group_conv_fee_detail
            android.view.View r14 = r12.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            java.lang.String r0 = "group_conv_fee_detail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.view.View r14 = (android.view.View) r14
            net.one97.paytm.recharge.common.utils.ai.a(r14)
            int r14 = net.one97.paytm.recharge.R.id.what_is_conv_fees
            android.view.View r14 = r12.a((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            java.lang.String r0 = "what_is_conv_fees"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.view.View r14 = (android.view.View) r14
            net.one97.paytm.recharge.common.utils.ai.a(r14)
            int r14 = net.one97.paytm.recharge.R.id.what_is_conv_fees
            android.view.View r14 = r12.a((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            net.one97.paytm.recharge.common.utils.k$c r0 = new net.one97.paytm.recharge.common.utils.k$c
            r0.<init>(r12)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
            int r14 = net.one97.paytm.recharge.R.id.conv_fee_types
            android.view.View r14 = r12.a((int) r14)
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            java.lang.String r0 = "conv_fee_types"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r7 = r12.getContext()
            r6.<init>(r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r6
            r14.setLayoutManager(r6)
            int r14 = net.one97.paytm.recharge.R.id.conv_fee_types
            android.view.View r14 = r12.a((int) r14)
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            net.one97.paytm.recharge.common.utils.k$d r0 = new net.one97.paytm.recharge.common.utils.k$d
            r0.<init>(r13, r12)
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r14.setAdapter(r0)
        L_0x01e6:
            net.one97.paytm.common.entity.CJRRechargeCart r13 = r12.f61657a
            if (r13 != 0) goto L_0x01ed
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01ed:
            net.one97.paytm.common.entity.shopping.CJRCart r13 = r13.getCart()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            java.util.ArrayList r13 = r13.getCartItems()
            java.lang.Object r13 = r13.get(r1)
            java.lang.String r14 = "rechargeCart.cart.cartItems[0]"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r13 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r13
            java.lang.String r13 = r13.getPromoCode()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 == 0) goto L_0x0214
            boolean r0 = kotlin.m.p.a(r13)
            if (r0 == 0) goto L_0x0212
            goto L_0x0214
        L_0x0212:
            r0 = 0
            goto L_0x0215
        L_0x0214:
            r0 = 1
        L_0x0215:
            if (r0 != 0) goto L_0x026a
            int r0 = net.one97.paytm.recharge.R.id.group_promocode
            android.view.View r0 = r12.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            java.lang.String r6 = "group_promocode"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            int r0 = net.one97.paytm.recharge.R.id.promo_title
            android.view.View r0 = r12.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r6 = "promo_title"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setText(r13)
            int r13 = net.one97.paytm.recharge.R.id.promo_details
            android.view.View r13 = r12.a((int) r13)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            java.lang.String r0 = "promo_details"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r12.f61657a
            if (r0 != 0) goto L_0x024d
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x024d:
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.util.ArrayList r0 = r0.getCartItems()
            java.lang.Object r0 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.lang.String r0 = r0.getPromoText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
        L_0x026a:
            net.one97.paytm.recharge.widgets.c.d r13 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.Iterator r13 = r5.iterator()
        L_0x0274:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x028f
            java.lang.Object r0 = r13.next()
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.lang.String r0 = r0.getPrice()
            java.lang.String r5 = "it.price"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            double r10 = java.lang.Double.parseDouble(r0)
            double r6 = r6 + r10
            goto L_0x0274
        L_0x028f:
            java.lang.String r13 = java.lang.String.valueOf(r6)
            java.lang.String r13 = net.one97.paytm.recharge.widgets.c.d.e(r13)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r12.f61657a
            if (r5 != 0) goto L_0x02a2
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02a2:
            net.one97.paytm.common.entity.shopping.CJRCart r5 = r5.getCart()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            java.util.ArrayList r4 = r5.getCartItems()
            java.lang.Object r4 = r4.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r14)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r4 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r4
            java.lang.String r14 = r4.getImageUrl()
            com.squareup.picasso.aa r14 = r0.a((java.lang.String) r14)
            int r0 = net.one97.paytm.recharge.R.id.operator_image
            android.view.View r0 = r12.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r14.a((android.widget.ImageView) r0)
            int r14 = net.one97.paytm.recharge.R.id.group_insurance
            android.view.View r14 = r12.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            java.lang.String r0 = "group_insurance"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            int r14 = r14.getVisibility()
            if (r14 == 0) goto L_0x02ef
            int r14 = net.one97.paytm.recharge.R.id.group_coupons_count
            android.view.View r14 = r12.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            java.lang.String r0 = "group_coupons_count"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            int r14 = r14.getVisibility()
            if (r14 != 0) goto L_0x0301
        L_0x02ef:
            int r14 = net.one97.paytm.recharge.R.id.group_other_items
            android.view.View r14 = r12.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            java.lang.String r0 = "group_other_items"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.view.View r14 = (android.view.View) r14
            net.one97.paytm.recharge.common.utils.ai.a(r14)
        L_0x0301:
            net.one97.paytm.common.entity.CJRRechargeCart r14 = r12.f61657a
            if (r14 != 0) goto L_0x0308
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0308:
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()
            if (r14 == 0) goto L_0x0313
            java.util.ArrayList r14 = r14.getCartItems()
            goto L_0x0314
        L_0x0313:
            r14 = r2
        L_0x0314:
            if (r14 != 0) goto L_0x0319
            kotlin.g.b.k.a()
        L_0x0319:
            java.lang.Object r14 = r14.get(r1)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r14 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r14
            if (r14 == 0) goto L_0x032c
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r0 = r14.getmProductAttrubutes()
            if (r0 == 0) goto L_0x032c
            java.lang.String r0 = r0.getPaytTypeDisplayLabel()
            goto L_0x032d
        L_0x032c:
            r0 = r2
        L_0x032d:
            if (r14 == 0) goto L_0x033a
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r4 = r14.getmProductAttrubutes()
            if (r4 == 0) goto L_0x033a
            java.lang.String r4 = r4.getOperatorDisplayLabel()
            goto L_0x033b
        L_0x033a:
            r4 = r2
        L_0x033b:
            if (r14 == 0) goto L_0x0342
            java.lang.String r14 = r14.getBrand()
            goto L_0x0343
        L_0x0342:
            r14 = r2
        L_0x0343:
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0351
            boolean r5 = kotlin.m.p.a(r5)
            if (r5 == 0) goto L_0x034f
            goto L_0x0351
        L_0x034f:
            r5 = 0
            goto L_0x0352
        L_0x0351:
            r5 = 1
        L_0x0352:
            java.lang.String r6 = "title"
            if (r5 != 0) goto L_0x038b
            int r5 = net.one97.paytm.recharge.R.id.title
            android.view.View r5 = r12.a((int) r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.content.Context r6 = r12.getContext()
            if (r6 == 0) goto L_0x0387
            int r7 = net.one97.paytm.recharge.R.string.payment_of
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r0
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x037c
            int r0 = r0.length()
            if (r0 != 0) goto L_0x037a
            goto L_0x037c
        L_0x037a:
            r0 = 0
            goto L_0x037d
        L_0x037c:
            r0 = 1
        L_0x037d:
            if (r0 != 0) goto L_0x0380
            r14 = r4
        L_0x0380:
            r8[r9] = r14
            java.lang.String r14 = r6.getString(r7, r8)
            goto L_0x0388
        L_0x0387:
            r14 = r2
        L_0x0388:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            goto L_0x03ac
        L_0x038b:
            int r0 = net.one97.paytm.recharge.R.id.title
            android.view.View r0 = r12.a((int) r0)
            r5 = r0
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x03a5
            int r4 = r0.length()
            if (r4 != 0) goto L_0x03a3
            goto L_0x03a5
        L_0x03a3:
            r4 = 0
            goto L_0x03a6
        L_0x03a5:
            r4 = 1
        L_0x03a6:
            if (r4 != 0) goto L_0x03aa
            r14 = r0
            goto L_0x03ac
        L_0x03aa:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
        L_0x03ac:
            r5.setText(r14)
            int r14 = net.one97.paytm.recharge.R.id.subTitle
            android.view.View r14 = r12.a((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            java.lang.String r0 = "subTitle"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r12.f61657a
            if (r0 != 0) goto L_0x03c3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x03c3:
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x03e6
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x03e6
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x03e6
            java.util.Map r0 = r0.getConfigurationList()
            if (r0 == 0) goto L_0x03e6
            java.lang.String r4 = "recharge_number"
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x03e7
        L_0x03e6:
            r0 = r2
        L_0x03e7:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
            int r14 = net.one97.paytm.recharge.R.id.total_payment
            android.view.View r14 = r12.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "total_payment"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.content.Context r0 = r12.getContext()
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0436
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0436
            int r5 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r6 = new java.lang.Object[r9]
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.common.entity.CJRRechargeCart r7 = r12.f61657a
            if (r7 != 0) goto L_0x0414
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0414:
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r7.getCart()
            if (r7 == 0) goto L_0x042a
            java.lang.String r7 = r7.getFinalPrice()
            if (r7 == 0) goto L_0x042a
            double r7 = java.lang.Double.parseDouble(r7)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            if (r7 != 0) goto L_0x042b
        L_0x042a:
            r7 = r4
        L_0x042b:
            java.lang.String r7 = net.one97.paytm.recharge.widgets.c.d.e(r7)
            r6[r1] = r7
            java.lang.String r0 = r0.getString(r5, r6)
            goto L_0x0437
        L_0x0436:
            r0 = r2
        L_0x0437:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
            int r14 = net.one97.paytm.recharge.R.id.subTotalAmount
            android.view.View r14 = r12.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "subTotalAmount"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.content.Context r0 = r12.getContext()
            if (r0 == 0) goto L_0x046b
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x046b
            int r5 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r6 = new java.lang.Object[r9]
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            if (r13 != 0) goto L_0x045f
            r7 = r4
            goto L_0x0460
        L_0x045f:
            r7 = r13
        L_0x0460:
            java.lang.String r7 = net.one97.paytm.recharge.widgets.c.d.e(r7)
            r6[r1] = r7
            java.lang.String r0 = r0.getString(r5, r6)
            goto L_0x046c
        L_0x046b:
            r0 = r2
        L_0x046c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
            net.one97.paytm.common.entity.CJRRechargeCart r14 = r12.f61657a
            if (r14 != 0) goto L_0x0478
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0478:
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()
            r0 = 33
            if (r14 == 0) goto L_0x0564
            boolean r14 = r14.isConvFeeFlow()
            if (r14 != r9) goto L_0x0564
            net.one97.paytm.common.entity.CJRRechargeCart r14 = r12.f61657a
            if (r14 != 0) goto L_0x048d
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x048d:
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()
            if (r14 == 0) goto L_0x0498
            java.lang.String r14 = r14.getAggregatePGConvFee()
            goto L_0x0499
        L_0x0498:
            r14 = r2
        L_0x0499:
            r5 = r14
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x04a7
            boolean r5 = kotlin.m.p.a(r5)
            if (r5 == 0) goto L_0x04a5
            goto L_0x04a7
        L_0x04a5:
            r5 = 0
            goto L_0x04a8
        L_0x04a7:
            r5 = 1
        L_0x04a8:
            if (r5 != 0) goto L_0x0564
            java.lang.String r5 = "0"
            boolean r14 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r14, (boolean) r9)
            if (r14 != 0) goto L_0x0564
            net.one97.paytm.recharge.widgets.c.d r14 = net.one97.paytm.recharge.widgets.c.d.f64967a
            if (r13 != 0) goto L_0x04b7
            r13 = r4
        L_0x04b7:
            java.lang.String r13 = net.one97.paytm.recharge.widgets.c.d.e(r13)
            android.text.SpannableString r14 = new android.text.SpannableString
            android.content.Context r5 = r12.getContext()
            if (r5 == 0) goto L_0x04d4
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x04d4
            int r6 = net.one97.paytm.recharge.R.string.conv_fees_sub_total
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r1] = r13
            java.lang.String r5 = r5.getString(r6, r7)
            goto L_0x04d5
        L_0x04d4:
            r5 = r2
        L_0x04d5:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.<init>(r5)
            android.text.style.RelativeSizeSpan r5 = new android.text.style.RelativeSizeSpan
            r6 = 1061997773(0x3f4ccccd, float:0.8)
            r5.<init>(r6)
            int r6 = r14.length()
            int r13 = r13.length()
            int r13 = r13 + 3
            int r6 = r6 - r13
            int r13 = r14.length()
            r14.setSpan(r5, r6, r13, r0)
            int r13 = net.one97.paytm.recharge.R.id.conv_fee_desc
            android.view.View r13 = r12.a((int) r13)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            java.lang.String r5 = "conv_fee_desc"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r5)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
            int r13 = net.one97.paytm.recharge.R.id.conv_fees
            android.view.View r13 = r12.a((int) r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r14 = "conv_fees"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            android.content.Context r14 = r12.getContext()
            if (r14 == 0) goto L_0x054d
            android.content.res.Resources r14 = r14.getResources()
            if (r14 == 0) goto L_0x054d
            int r2 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r5 = new java.lang.Object[r9]
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.common.entity.CJRRechargeCart r6 = r12.f61657a
            if (r6 != 0) goto L_0x052c
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x052c:
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r6.getCart()
            if (r3 == 0) goto L_0x0542
            java.lang.String r3 = r3.getAggregatePGConvFee()
            if (r3 == 0) goto L_0x0542
            double r6 = java.lang.Double.parseDouble(r3)
            java.lang.String r3 = java.lang.String.valueOf(r6)
            if (r3 != 0) goto L_0x0543
        L_0x0542:
            r3 = r4
        L_0x0543:
            java.lang.String r3 = net.one97.paytm.recharge.widgets.c.d.e(r3)
            r5[r1] = r3
            java.lang.String r2 = r14.getString(r2, r5)
        L_0x054d:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r13.setText(r2)
            int r13 = net.one97.paytm.recharge.R.id.group_conv_fee_sub_total
            android.view.View r13 = r12.a((int) r13)
            androidx.constraintlayout.widget.Group r13 = (androidx.constraintlayout.widget.Group) r13
            java.lang.String r14 = "group_conv_fee_sub_total"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            android.view.View r13 = (android.view.View) r13
            net.one97.paytm.recharge.common.utils.ai.a(r13)
        L_0x0564:
            android.content.Context r13 = r12.getContext()
            if (r13 == 0) goto L_0x05d3
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            int r14 = net.one97.paytm.recharge.R.id.conv_fee_disclaimer
            android.view.View r14 = r12.a((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            java.lang.String r2 = "conv_fee_disclaimer"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.CharSequence r14 = r14.getText()
            r13.<init>(r14)
            android.content.Context r14 = r12.getContext()
            if (r14 == 0) goto L_0x0594
            android.content.res.Resources r14 = r14.getResources()
            if (r14 == 0) goto L_0x0594
            int r3 = net.one97.paytm.recharge.R.string.important_string
            java.lang.String r14 = r14.getString(r3)
            if (r14 != 0) goto L_0x0595
        L_0x0594:
            r14 = r4
        L_0x0595:
            java.lang.String r3 = "context?.resources?.getS…g.important_string) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r3 = r13
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 6
            int r1 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String) r14, (int) r1, (boolean) r1, (int) r4)
            if (r1 < 0) goto L_0x05c5
            int r4 = r14.length()
            if (r1 >= r4) goto L_0x05c5
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            android.content.Context r5 = r12.getContext()
            if (r5 != 0) goto L_0x05b5
            kotlin.g.b.k.a()
        L_0x05b5:
            int r6 = net.one97.paytm.recharge.R.color.color_ffa400
            int r5 = androidx.core.content.b.c(r5, r6)
            r4.<init>(r5)
            int r14 = r14.length()
            r13.setSpan(r4, r1, r14, r0)
        L_0x05c5:
            int r13 = net.one97.paytm.recharge.R.id.conv_fee_disclaimer
            android.view.View r13 = r12.a((int) r13)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            r13.setText(r3)
        L_0x05d3:
            int r13 = net.one97.paytm.recharge.R.id.cross
            android.view.View r13 = r12.a((int) r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            net.one97.paytm.recharge.common.utils.k$b r14 = new net.one97.paytm.recharge.common.utils.k$b
            r14.<init>(r12)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r13.setOnClickListener(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.k.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f61659a;

        b(k kVar) {
            this.f61659a = kVar;
        }

        public final void onClick(View view) {
            this.f61659a.dismiss();
        }
    }

    private final void a(List<? extends CJRCartProduct> list) {
        Resources resources;
        String str = null;
        if ((list.size() > 0 ? list : null) != null) {
            Group group = (Group) a(R.id.group_insurance);
            kotlin.g.b.k.a((Object) group, "group_insurance");
            ai.a(group);
            double d2 = 0.0d;
            for (CJRCartProduct price : list) {
                String price2 = price.getPrice();
                kotlin.g.b.k.a((Object) price2, "it.price");
                d2 += Double.parseDouble(price2);
            }
            TextView textView = (TextView) a(R.id.total_insurance_price);
            kotlin.g.b.k.a((Object) textView, "total_insurance_price");
            Context context = getContext();
            if (!(context == null || (resources = context.getResources()) == null)) {
                int i2 = R.string.price_container_re;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                str = resources.getString(i2, new Object[]{net.one97.paytm.recharge.widgets.c.d.e(String.valueOf(d2))});
            }
            textView.setText(str);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f61660a;

        c(k kVar) {
            this.f61660a = kVar;
        }

        public final void onClick(View view) {
            NestedScrollView nestedScrollView = (NestedScrollView) this.f61660a.a(R.id.nestedScrollView);
            if (nestedScrollView != null) {
                nestedScrollView.a(130);
            }
        }
    }

    public static final class d extends RecyclerView.a<aa> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f61661a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f61662b;

        d(List list, k kVar) {
            this.f61661a = list;
            this.f61662b = kVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            String str;
            Resources resources;
            aa aaVar = (aa) vVar;
            kotlin.g.b.k.c(aaVar, "holder");
            PGMetaData pGMetaData = (PGMetaData) this.f61661a.get(i2);
            TextView textView = aaVar.f60432a;
            kotlin.g.b.k.a((Object) textView, "holder.title");
            kotlin.g.b.k.a((Object) pGMetaData, "cartItem");
            textView.setText(pGMetaData.getDisplayValue());
            if (p.a(pGMetaData.getType(), "percentage", true)) {
                String value = pGMetaData.getValue();
                TextView textView2 = aaVar.f60433b;
                kotlin.g.b.k.a((Object) textView2, "holder.price");
                textView2.setText(value + "%");
            } else if (p.a(pGMetaData.getType(), "amount", true)) {
                TextView textView3 = aaVar.f60433b;
                kotlin.g.b.k.a((Object) textView3, "holder.price");
                Context context = this.f61662b.getContext();
                if (context == null || (resources = context.getResources()) == null) {
                    str = null;
                } else {
                    str = resources.getString(R.string.price_container_re, new Object[]{pGMetaData.getValue()});
                }
                textView3.setText(str);
            } else {
                TextView textView4 = aaVar.f60433b;
                kotlin.g.b.k.a((Object) textView4, "holder.price");
                textView4.setText(pGMetaData.getValue());
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            kotlin.g.b.k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f61662b.getContext()).inflate(R.layout.payment_detail_view, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate, "LayoutInflater.from(cont…tail_view, parent, false)");
            Context context = this.f61662b.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            return new aa(inflate, context);
        }

        public final int getItemCount() {
            return this.f61661a.size();
        }
    }

    private final void b(List<? extends CJRCartProduct> list) {
        RecyclerView recyclerView = (RecyclerView) a(R.id.coupons_items);
        kotlin.g.b.k.a((Object) recyclerView, "coupons_items");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Integer valueOf = Integer.valueOf(list.size());
        x xVar = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            RoboTextView roboTextView = (RoboTextView) a(R.id.total_coupons);
            kotlin.g.b.k.a((Object) roboTextView, "total_coupons");
            roboTextView.setText(getResources().getString(R.string.deals_selected, new Object[]{String.valueOf(intValue)}));
            Resources resources = getResources();
            int i2 = R.string.price_container_re;
            Object[] objArr = new Object[1];
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            double d2 = 0.0d;
            for (CJRCartProduct price : list) {
                String price2 = price.getPrice();
                kotlin.g.b.k.a((Object) price2, "it.price");
                d2 += Double.parseDouble(price2);
            }
            objArr[0] = net.one97.paytm.recharge.widgets.c.d.e(String.valueOf(d2));
            String string = resources.getString(i2, objArr);
            kotlin.g.b.k.a((Object) string, "resources.getString(R.st…toDouble() }.toString()))");
            if (kotlin.g.b.k.a((Object) string, (Object) "0")) {
                TextView textView = (TextView) a(R.id.total_coupons_price);
                kotlin.g.b.k.a((Object) textView, "total_coupons_price");
                textView.setText(getResources().getString(R.string.free));
            } else {
                TextView textView2 = (TextView) a(R.id.total_coupons_price);
                kotlin.g.b.k.a((Object) textView2, "total_coupons_price");
                textView2.setText(string);
            }
            Group group = (Group) a(R.id.group_coupons_count);
            kotlin.g.b.k.a((Object) group, "group_coupons_count");
            ai.a(group);
            ((RoboTextView) a(R.id.total_coupons)).setOnClickListener(new e(this, list));
            Context context = getContext();
            if (context != null) {
                RecyclerView recyclerView2 = (RecyclerView) a(R.id.coupons_items);
                kotlin.g.b.k.a((Object) recyclerView2, "coupons_items");
                kotlin.g.b.k.a((Object) context, "it");
                recyclerView2.setAdapter(new ad(list, context, ah.COUPONS));
                xVar = x.f47997a;
            }
            if (xVar != null) {
                return;
            }
        }
        Group group2 = (Group) a(R.id.group_coupons_count);
        kotlin.g.b.k.a((Object) group2, "group_coupons_count");
        ai.b(group2);
        x xVar2 = x.f47997a;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f61663a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f61664b;

        e(k kVar, List list) {
            this.f61663a = kVar;
            this.f61664b = list;
        }

        public final void onClick(View view) {
            if (this.f61663a.getContext() != null) {
                RecyclerView recyclerView = (RecyclerView) this.f61663a.a(R.id.coupons_items);
                kotlin.g.b.k.a((Object) recyclerView, "coupons_items");
                if (recyclerView.getVisibility() == 0) {
                    RecyclerView recyclerView2 = (RecyclerView) this.f61663a.a(R.id.coupons_items);
                    kotlin.g.b.k.a((Object) recyclerView2, "coupons_items");
                    ai.b(recyclerView2);
                    RoboTextView roboTextView = (RoboTextView) this.f61663a.a(R.id.total_coupons);
                    Context context = this.f61663a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    roboTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, R.drawable.chevron_down_dark), (Drawable) null);
                    return;
                }
                RecyclerView recyclerView3 = (RecyclerView) this.f61663a.a(R.id.coupons_items);
                kotlin.g.b.k.a((Object) recyclerView3, "coupons_items");
                ai.a(recyclerView3);
                RoboTextView roboTextView2 = (RoboTextView) this.f61663a.a(R.id.total_coupons);
                Context context2 = this.f61663a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context2, R.drawable.chevron_up_dark), (Drawable) null);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61658c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
