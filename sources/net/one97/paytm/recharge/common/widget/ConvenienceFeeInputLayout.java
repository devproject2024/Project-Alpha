package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.g.d;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;

public final class ConvenienceFeeInputLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public static final a f61976h = new a((byte) 0);
    private static final String j;
    /* access modifiers changed from: private */
    public static final int k = k;
    /* access modifiers changed from: private */
    public static CJRProductsItem l;

    /* renamed from: a  reason: collision with root package name */
    b f61977a;

    /* renamed from: b  reason: collision with root package name */
    AutoCompleteTextView f61978b;

    /* renamed from: c  reason: collision with root package name */
    String f61979c;

    /* renamed from: d  reason: collision with root package name */
    public String f61980d;

    /* renamed from: e  reason: collision with root package name */
    String f61981e;

    /* renamed from: f  reason: collision with root package name */
    View f61982f = findViewById(R.id.convenience_fee_lyt);

    /* renamed from: g  reason: collision with root package name */
    TextView f61983g = ((TextView) findViewById(R.id.convenience_fee_text));

    /* renamed from: i  reason: collision with root package name */
    private final CJRInputFieldsItem f61984i;

    public interface b {
        void a(Intent intent);

        void a(String str, String str2);

        boolean a(ConvenienceFeeInputLayout convenienceFeeInputLayout);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConvenienceFeeInputLayout(Context context, CJRInputFieldsItem cJRInputFieldsItem) {
        super(context);
        k.c(context, "context");
        k.c(cJRInputFieldsItem, "inputField");
        this.f61984i = cJRInputFieldsItem;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setTag(Boolean.TRUE);
        LayoutInflater.from(context).inflate(R.layout.recharge_utility_group_filed_drop_down, this, true);
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout_utility);
        k.a((Object) textInputLayout, "mtextInputLayoutAmount");
        textInputLayout.setHint(this.f61984i.getTitle());
        this.f61978b = (AutoCompleteTextView) findViewById(R.id.group_field_textview);
        AutoCompleteTextView autoCompleteTextView = this.f61978b;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnClickListener(this);
        }
    }

    public final CJRInputFieldsItem getInputField() {
        return this.f61984i;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            r1 = (r1 = (r1 = (r1 = r1.getCart()).getCartItems()).get(0)).getConvenienceFeeMap();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(net.one97.paytm.common.entity.CJRRechargeCart r1) {
            /*
                r0 = 0
                if (r1 == 0) goto L_0x0022
                net.one97.paytm.common.entity.shopping.CJRCart r1 = r1.getCart()
                if (r1 == 0) goto L_0x0022
                java.util.ArrayList r1 = r1.getCartItems()
                if (r1 == 0) goto L_0x0022
                java.lang.Object r1 = r1.get(r0)
                net.one97.paytm.common.entity.shopping.CJRCartProduct r1 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r1
                if (r1 == 0) goto L_0x0022
                java.util.HashMap r1 = r1.getConvenienceFeeMap()
                if (r1 == 0) goto L_0x0022
                int r1 = r1.size()
                goto L_0x0023
            L_0x0022:
                r1 = 0
            L_0x0023:
                if (r1 <= 0) goto L_0x0027
                r1 = 1
                return r1
            L_0x0027:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.a.a(net.one97.paytm.common.entity.CJRRechargeCart):boolean");
        }

        public static HashMap<String, String> b(CJRRechargeCart cJRRechargeCart) {
            k.c(cJRRechargeCart, "rechargeCart");
            CJRCart cart = cJRRechargeCart.getCart();
            k.a((Object) cart, "rechargeCart.cart");
            CJRCartProduct cJRCartProduct = cart.getCartItems().get(0);
            k.a((Object) cJRCartProduct, "rechargeCart.cart.cartItems[0]");
            HashMap<String, String> hashMap = new HashMap<>(cJRCartProduct.getConvenienceFeeMap());
            CJRCart cart2 = cJRRechargeCart.getCart();
            k.a((Object) cart2, "rechargeCart.cart");
            int size = cart2.getCartItems().size();
            for (int i2 = 1; i2 < size; i2++) {
                CJRCart cart3 = cJRRechargeCart.getCart();
                k.a((Object) cart3, "rechargeCart.cart");
                if (cart3.getCartItems().get(i2) != null) {
                    CJRCart cart4 = cJRRechargeCart.getCart();
                    k.a((Object) cart4, "rechargeCart.cart");
                    CJRCartProduct cJRCartProduct2 = cart4.getCartItems().get(i2);
                    k.a((Object) cJRCartProduct2, "rechargeCart.cart.cartItems[i]");
                    if (cJRCartProduct2.getConvenienceFeeMap() != null) {
                        CJRCart cart5 = cJRRechargeCart.getCart();
                        k.a((Object) cart5, "rechargeCart.cart");
                        CJRCartProduct cJRCartProduct3 = cart5.getCartItems().get(i2);
                        k.a((Object) cJRCartProduct3, "rechargeCart.cart\n      …            .cartItems[i]");
                        ArrayList arrayList = new ArrayList(cJRCartProduct3.getConvenienceFeeMap().keySet());
                        CJRCart cart6 = cJRRechargeCart.getCart();
                        k.a((Object) cart6, "rechargeCart.cart");
                        CJRCartProduct cJRCartProduct4 = cart6.getCartItems().get(i2);
                        k.a((Object) cJRCartProduct4, "rechargeCart.cart\n      …            .cartItems[i]");
                        ArrayList arrayList2 = new ArrayList(cJRCartProduct4.getConvenienceFeeMap().values());
                        int size2 = arrayList.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            if (!TextUtils.isEmpty((CharSequence) arrayList.get(i3)) && hashMap.containsKey(arrayList.get(i3))) {
                                try {
                                    String str = hashMap.get(arrayList.get(i3));
                                    if (str != null) {
                                        double parseDouble = Double.parseDouble(str) + Double.parseDouble((String) arrayList2.get(i3));
                                        hashMap.remove(arrayList.get(i3));
                                        hashMap.put(arrayList.get(i3), String.valueOf(parseDouble));
                                    }
                                } catch (Exception e2) {
                                    q.d(e2.getMessage());
                                }
                            }
                        }
                        if (hashMap.size() > arrayList.size()) {
                            ArrayList arrayList3 = new ArrayList(hashMap.keySet());
                            int size3 = arrayList3.size();
                            for (int i4 = 0; i4 < size3; i4++) {
                                if (!arrayList.contains(arrayList3.get(i4))) {
                                    hashMap.remove(arrayList3.get(i4));
                                }
                            }
                        }
                    }
                }
            }
            return hashMap;
        }
    }

    static {
        String name = ConvenienceFeeInputLayout.class.getName();
        k.a((Object) name, "ConvenienceFeeInputLayout::class.java.name");
        j = name;
    }

    public final String getInputFieldHint() {
        String title = this.f61984i.getTitle();
        return title == null ? "" : title;
    }

    public final String getSelectedPaymentMethod() {
        return this.f61980d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005b, code lost:
        r3 = (r3 = r3.getPayTypeSupported()).keySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r7, net.one97.paytm.common.entity.CJRRechargeCart r8) {
        /*
            r6 = this;
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "rechargeCart"
            kotlin.g.b.k.c(r8, r0)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r8.getCart()
            java.lang.String r1 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.ArrayList r0 = r0.getCartItems()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r2 = "rechargeCart.cart.cartItems[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.util.HashMap r0 = r0.getConvenienceFeeMap()
            java.lang.String r2 = "rechargeCart.cart.cartItems[0].convenienceFeeMap"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            java.util.ArrayList r1 = r2.getCartItems()
            int r1 = r1.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0042
            java.util.HashMap r0 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.a.b(r8)
        L_0x0042:
            android.content.Intent r8 = new android.content.Intent
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity> r3 = net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity.class
            r8.<init>(r1, r3)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = l
            if (r3 == 0) goto L_0x0066
            java.util.HashMap r3 = r3.getPayTypeSupported()
            if (r3 == 0) goto L_0x0066
            java.util.Set r3 = r3.keySet()
            if (r3 == 0) goto L_0x0066
            java.util.Iterator r3 = r3.iterator()
            goto L_0x0067
        L_0x0066:
            r3 = 0
        L_0x0067:
            if (r3 == 0) goto L_0x00b5
            boolean r4 = r3.hasNext()
            if (r4 != r2) goto L_0x00b5
            java.lang.Object r4 = r3.next()
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = (java.lang.String) r4
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = l
            if (r5 != 0) goto L_0x007e
            kotlin.g.b.k.a()
        L_0x007e:
            java.util.HashMap r5 = r5.getPayTypeSupported()
            if (r5 != 0) goto L_0x0087
            kotlin.g.b.k.a()
        L_0x0087:
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x0090
            goto L_0x0067
        L_0x0090:
            int r5 = r5.intValue()
            if (r5 != r2) goto L_0x0067
            if (r4 == 0) goto L_0x00a5
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r1.add(r4)
            goto L_0x0067
        L_0x00a5:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r8)
            throw r7
        L_0x00ad:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.String"
            r7.<init>(r8)
            throw r7
        L_0x00b5:
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "payment_mode_list"
            r8.putExtra(r2, r1)
            int r1 = net.one97.paytm.recharge.R.string.select_payment_mode
            java.lang.String r7 = r7.getString(r1)
            java.lang.String r1 = "title"
            r8.putExtra(r1, r7)
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r7 = "convenience_fee_map"
            r8.putExtra(r7, r0)
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$b r7 = r6.f61977a
            if (r7 == 0) goto L_0x00d5
            r7.a((android.content.Intent) r8)
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.a(android.app.Activity, net.one97.paytm.common.entity.CJRRechargeCart):void");
    }

    public final void setDataOnPaymentModeSelection(Intent intent) {
        String str;
        k.c(intent, "data");
        String stringExtra = intent.getStringExtra("payment_mode_selected");
        this.f61981e = intent.getStringExtra("convenience_fee_selected");
        k.a((Object) stringExtra, "paymentModeSelectedKey");
        if (stringExtra != null) {
            String upperCase = stringExtra.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            this.f61980d = upperCase;
            d<String, String> a2 = ba.a(stringExtra, getContext());
            k.a((Object) a2, "RechargeUtils.getPayment…tModeSelectedKey,context)");
            this.f61979c = (String) a2.f2964a;
            TextView textView = this.f61983g;
            if (textView != null) {
                Context context = getContext();
                if (context != null) {
                    str = context.getString(R.string.rs_str, new Object[]{String.valueOf(this.f61981e)});
                } else {
                    str = null;
                }
                textView.setText(str);
            }
            AutoCompleteTextView autoCompleteTextView = this.f61978b;
            if (autoCompleteTextView != null) {
                String str2 = (String) a2.f2965b;
                if (str2 == null) {
                    str2 = "";
                }
                autoCompleteTextView.setText(str2);
            }
            View view = this.f61982f;
            if (view != null) {
                view.setVisibility(0);
            }
            b bVar = this.f61977a;
            if (bVar != null) {
                bVar.a(this.f61979c, this.f61981e);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final void onClick(View view) {
        b bVar = this.f61977a;
        if (bVar != null) {
            bVar.a(this);
        }
    }
}
