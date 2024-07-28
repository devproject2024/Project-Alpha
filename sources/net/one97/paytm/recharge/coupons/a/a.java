package net.one97.paytm.recharge.coupons.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.l;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class a extends RecyclerView.a<C1194a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f62160a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRSelectedRecharge> f62161b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Context f62162c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.recharge.coupons.e.b f62163d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJRGridProduct> f62164e;

    /* renamed from: f  reason: collision with root package name */
    public String f62165f;

    /* renamed from: g  reason: collision with root package name */
    public String f62166g;

    /* renamed from: h  reason: collision with root package name */
    b f62167h;

    /* renamed from: i  reason: collision with root package name */
    String f62168i;
    final String j;
    private HashMap<String, String> k = new HashMap<>();
    private String l = "";
    private boolean m;
    private int n;
    private int o;

    public interface b {
        void a();
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        C1194a aVar = (C1194a) vVar;
        k.c(aVar, "holder");
        w a2 = w.a();
        CJRGridProduct cJRGridProduct = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct, "mCouponList.get(position)");
        a2.a(cJRGridProduct.getImageUrl()).a(R.color.color_909090).a((ImageView) aVar.f62169a);
        TextView textView = aVar.f62170b;
        CJRGridProduct cJRGridProduct2 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct2, "mCouponList.get(position)");
        String name = cJRGridProduct2.getName();
        textView.setText(name != null ? name : "");
        TextView textView2 = aVar.f62172d;
        CJRGridProduct cJRGridProduct3 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct3, "mCouponList.get(position)");
        String brand = cJRGridProduct3.getBrand();
        if (brand != null) {
            charSequence = brand;
        } else {
            charSequence = "";
        }
        textView2.setText(charSequence);
        try {
            CJRGridProduct cJRGridProduct4 = this.f62164e.get(i2);
            k.a((Object) cJRGridProduct4, "mCouponList[position]");
            String discountedPrice = cJRGridProduct4.getDiscountedPrice();
            k.a((Object) discountedPrice, "mCouponList[position].discountedPrice");
            int parseInt = Integer.parseInt(discountedPrice);
            if (parseInt != 0) {
                TextView textView3 = aVar.f62171c;
                StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
                sb.append(parseInt);
                textView3.setText(sb);
            } else {
                aVar.f62171c.setText(this.f62162c.getResources().getString(R.string.grid_free));
            }
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
        TextView textView4 = aVar.f62171c;
        CJRGridProduct cJRGridProduct5 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct5, "mCouponList[position]");
        textView4.setSelected(cJRGridProduct5.getIsAdded());
        ArrayList<String> arrayList = this.f62160a;
        CJRGridProduct cJRGridProduct6 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct6, "mCouponList[position]");
        if (arrayList.contains(cJRGridProduct6.getProductID())) {
            aVar.f62171c.setSelected(true);
            CJRGridProduct cJRGridProduct7 = this.f62164e.get(i2);
            k.a((Object) cJRGridProduct7, "mCouponList[position]");
            cJRGridProduct7.setIsAdded(true);
        } else {
            aVar.f62171c.setSelected(false);
            CJRGridProduct cJRGridProduct8 = this.f62164e.get(i2);
            k.a((Object) cJRGridProduct8, "mCouponList[position]");
            cJRGridProduct8.setIsAdded(false);
        }
        aVar.f62171c.setOnClickListener(new c(this, aVar, i2));
        CJRGridProduct cJRGridProduct9 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct9, "mCouponList[position]");
        String dealError = cJRGridProduct9.getDealError();
        k.a((Object) dealError, "mCouponList[position].dealError");
        if (dealError.length() == 0) {
            aVar.f62175g.setVisibility(8);
            aVar.f62175g.setText("");
            aVar.f62171c.setEnabled(true);
            aVar.f62173e.setAlpha(1.0f);
        } else {
            TextView textView5 = aVar.f62175g;
            CJRGridProduct cJRGridProduct10 = this.f62164e.get(i2);
            k.a((Object) cJRGridProduct10, "mCouponList[position]");
            textView5.setText(cJRGridProduct10.getDealError());
            aVar.f62171c.setEnabled(false);
            aVar.f62171c.setSelected(false);
            CJRGridProduct cJRGridProduct11 = this.f62164e.get(i2);
            k.a((Object) cJRGridProduct11, "mCouponList[position]");
            cJRGridProduct11.setAddToCartShow(true);
            aVar.f62172d.setAlpha(0.5f);
            aVar.f62175g.setAlpha(0.5f);
            aVar.f62171c.setAlpha(0.5f);
            aVar.f62170b.setAlpha(0.5f);
            aVar.f62169a.setAlpha(0.5f);
            aVar.f62175g.setVisibility(0);
        }
        if (aVar.f62171c.isSelected()) {
            TextView textView6 = aVar.f62171c;
            Context context = this.f62162c;
            if (context == null) {
                k.a();
            }
            textView6.setTextColor(androidx.core.content.b.c(context, 17170443));
        } else {
            TextView textView7 = aVar.f62171c;
            Context context2 = this.f62162c;
            if (context2 == null) {
                k.a();
            }
            textView7.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
        }
        CJRGridProduct cJRGridProduct12 = this.f62164e.get(i2);
        k.a((Object) cJRGridProduct12, "mCouponList[position]");
        if (cJRGridProduct12.isAddToCartShow()) {
            aVar.f62171c.setVisibility(0);
            aVar.f62174f.setVisibility(8);
        } else {
            aVar.f62171c.setVisibility(8);
            aVar.f62174f.setVisibility(0);
        }
        aVar.f62173e.setOnClickListener(new d(this, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f62162c).inflate(R.layout.item_coupons_v8, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…ons_v8, viewGroup, false)");
        return new C1194a(inflate);
    }

    public a(Context context, net.one97.paytm.recharge.coupons.e.b bVar, ArrayList<CJRGridProduct> arrayList, String str, String str2, b bVar2, String str3, String str4) {
        k.c(context, "context");
        k.c(arrayList, "mCouponList");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "categoryName");
        k.c(bVar2, "mOnAmountClickListener");
        k.c(str3, "variant");
        k.c(str4, "serviceType");
        this.f62162c = context;
        this.f62163d = bVar;
        this.f62164e = arrayList;
        this.f62165f = str;
        this.f62166g = str2;
        this.f62167h = bVar2;
        this.f62168i = str3;
        this.j = str4;
    }

    public final int getItemCount() {
        return this.f62164e.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62176a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1194a f62177b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f62178c;

        c(a aVar, C1194a aVar2, int i2) {
            this.f62176a = aVar;
            this.f62177b = aVar2;
            this.f62178c = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
            r3 = r3.getResources();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                net.one97.paytm.recharge.widgets.c.e r0 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
                net.one97.paytm.recharge.widgets.c.e r1 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
                int r1 = r1.getDELAY_500_MILLI()
                boolean r9 = r0.validateIsAlreadyClicked(r9, r1)
                if (r9 == 0) goto L_0x0014
                return
            L_0x0014:
                net.one97.paytm.recharge.coupons.a.a$a r9 = r8.f62177b
                android.widget.TextView r9 = r9.f62171c
                android.content.Context r9 = r9.getContext()
                boolean r9 = com.paytm.utility.b.c((android.content.Context) r9)
                if (r9 != 0) goto L_0x0053
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
                android.content.Context r0 = r9.f62162c
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DEAL_VERIFY
                android.content.Context r3 = r9.f62162c
                r4 = 0
                if (r3 == 0) goto L_0x003e
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x003e
                int r5 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r3 = r3.getString(r5)
                goto L_0x003f
            L_0x003e:
                r3 = r4
            L_0x003f:
                android.content.Context r9 = r9.f62162c
                if (r9 == 0) goto L_0x004f
                android.content.res.Resources r9 = r9.getResources()
                if (r9 == 0) goto L_0x004f
                int r4 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r4 = r9.getString(r4)
            L_0x004f:
                net.one97.paytm.recharge.common.utils.az.a(r0, r1, r2, r3, r4)
                return
            L_0x0053:
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                java.lang.String r0 = r9.f62168i
                java.lang.String r1 = "coupon_selected"
                java.lang.String r2 = "coupon_screen"
                java.lang.String r3 = "event_category"
                kotlin.g.b.k.c(r0, r3)
                java.lang.String r4 = "action"
                kotlin.g.b.k.c(r1, r4)
                java.lang.String r4 = "event_label"
                kotlin.g.b.k.c(r2, r4)
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x00b3 }
                r5.<init>()     // Catch:{ all -> 0x00b3 }
                net.one97.paytm.recharge.metro.f.c$a r6 = net.one97.paytm.recharge.metro.f.c.f63576a     // Catch:{ all -> 0x00b3 }
                java.lang.String r6 = net.one97.paytm.recharge.metro.f.c.a.i(r0)     // Catch:{ all -> 0x00b3 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00b3 }
                boolean r6 = kotlin.m.p.a(r6)     // Catch:{ all -> 0x00b3 }
                if (r6 != 0) goto L_0x00b4
                r6 = r5
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00b3 }
                net.one97.paytm.recharge.metro.f.c$a r7 = net.one97.paytm.recharge.metro.f.c.f63576a     // Catch:{ all -> 0x00b3 }
                java.lang.String r0 = net.one97.paytm.recharge.metro.f.c.a.i(r0)     // Catch:{ all -> 0x00b3 }
                r6.put(r3, r0)     // Catch:{ all -> 0x00b3 }
                r0 = r5
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00b3 }
                java.lang.String r3 = "event_action"
                r0.put(r3, r1)     // Catch:{ all -> 0x00b3 }
                r0 = r5
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00b3 }
                java.lang.String r1 = "screenName"
                java.lang.String r3 = "/metro/coupon"
                r0.put(r1, r3)     // Catch:{ all -> 0x00b3 }
                r0 = r5
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00b3 }
                r0.put(r4, r2)     // Catch:{ all -> 0x00b3 }
                r0 = r5
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00b3 }
                java.lang.String r1 = "vertical_name"
                java.lang.String r2 = "recharges_utilities"
                r0.put(r1, r2)     // Catch:{ all -> 0x00b3 }
                net.one97.paytm.recharge.di.helper.b r0 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x00b3 }
                android.content.Context r9 = r9.f62162c     // Catch:{ all -> 0x00b3 }
                net.one97.paytm.recharge.di.helper.b.a((java.util.HashMap<java.lang.String, java.lang.Object>) r5, (android.content.Context) r9)     // Catch:{ all -> 0x00b3 }
                goto L_0x00b4
            L_0x00b3:
            L_0x00b4:
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                net.one97.paytm.recharge.coupons.a.a$b r9 = r9.f62167h
                if (r9 == 0) goto L_0x00bd
                r9.a()
            L_0x00bd:
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r9 = r9.f62164e
                int r0 = r8.f62178c
                java.lang.Object r9 = r9.get(r0)
                java.lang.String r0 = "mCouponList[position]"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r9 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r9
                boolean r9 = r9.getIsAdded()
                if (r9 == 0) goto L_0x015e
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                net.one97.paytm.recharge.coupons.e.b r9 = r9.f62163d
                if (r9 == 0) goto L_0x015d
                boolean r9 = r9.f62292d
                if (r9 != 0) goto L_0x01e8
                net.one97.paytm.recharge.coupons.a.a$a r9 = r8.f62177b
                android.widget.TextView r9 = r9.f62171c
                net.one97.paytm.recharge.coupons.a.a r1 = r8.f62176a
                android.content.Context r1 = r1.f62162c
                if (r1 != 0) goto L_0x00eb
                kotlin.g.b.k.a()
            L_0x00eb:
                int r2 = net.one97.paytm.recharge.R.color.color_00b9f5
                int r1 = androidx.core.content.b.c(r1, r2)
                r9.setTextColor(r1)
                net.one97.paytm.recharge.coupons.a.a$a r9 = r8.f62177b
                android.widget.TextView r9 = r9.f62171c
                r1 = 0
                r9.setSelected(r1)
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                net.one97.paytm.recharge.coupons.e.b r9 = r9.f62163d
                if (r9 == 0) goto L_0x0114
                net.one97.paytm.recharge.coupons.a.a r2 = r8.f62176a
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r2 = r2.f62164e
                int r3 = r8.f62178c
                java.lang.Object r2 = r2.get(r3)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r2 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r2
                r9.a((net.one97.paytm.common.entity.shopping.CJRGridProduct) r2)
            L_0x0114:
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r9 = r9.f62164e
                int r2 = r8.f62178c
                java.lang.Object r9 = r9.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r9 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r9
                r9.setIsAdded(r1)
                net.one97.paytm.recharge.di.helper.b r9 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x015d }
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r9 = r9.f62164e     // Catch:{ all -> 0x015d }
                int r1 = r8.f62178c     // Catch:{ all -> 0x015d }
                java.lang.Object r9 = r9.get(r1)     // Catch:{ all -> 0x015d }
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)     // Catch:{ all -> 0x015d }
                net.one97.paytm.common.entity.shopping.CJRGridProduct r9 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r9     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r0 = r8.f62176a     // Catch:{ all -> 0x015d }
                android.content.Context r0 = r0.f62162c     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r1 = r8.f62176a     // Catch:{ all -> 0x015d }
                java.lang.String r1 = r1.f62165f     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r2 = r8.f62176a     // Catch:{ all -> 0x015d }
                java.lang.String r2 = r2.f62166g     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.di.helper.b.a((net.one97.paytm.common.entity.shopping.CJRGridProduct) r9, (android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.di.helper.b r9 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x015d }
                android.content.Context r0 = r9.f62162c     // Catch:{ all -> 0x015d }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x015d }
                java.lang.String r1 = r9.j     // Catch:{ all -> 0x015d }
                java.lang.String r2 = "coupon_declined"
                java.lang.String r3 = ""
                java.lang.String r4 = ""
                java.lang.String r5 = ""
                java.lang.String r6 = "recharges_utilities"
                net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x015d }
            L_0x015d:
                return
            L_0x015e:
                net.one97.paytm.recharge.coupons.a.a$a r9 = r8.f62177b
                android.widget.TextView r9 = r9.f62171c
                net.one97.paytm.recharge.coupons.a.a r1 = r8.f62176a
                android.content.Context r1 = r1.f62162c
                if (r1 != 0) goto L_0x016b
                kotlin.g.b.k.a()
            L_0x016b:
                r2 = 17170443(0x106000b, float:2.4611944E-38)
                int r1 = androidx.core.content.b.c(r1, r2)
                r9.setTextColor(r1)
                net.one97.paytm.recharge.coupons.a.a$a r9 = r8.f62177b
                android.widget.TextView r9 = r9.f62171c
                r1 = 1
                r9.setSelected(r1)
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                net.one97.paytm.recharge.coupons.e.b r9 = r9.f62163d
                if (r9 == 0) goto L_0x019f
                net.one97.paytm.recharge.coupons.e.c r2 = new net.one97.paytm.recharge.coupons.e.c
                net.one97.paytm.recharge.coupons.a.a r3 = r8.f62176a
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r3 = r3.f62164e
                int r4 = r8.f62178c
                java.lang.Object r3 = r3.get(r4)
                net.one97.paytm.recharge.coupons.a.a$a r4 = r8.f62177b
                int r4 = r4.getAdapterPosition()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r2.<init>(r3, r4)
                r9.a((net.one97.paytm.recharge.coupons.e.c<net.one97.paytm.common.entity.shopping.CJRGridProduct>) r2)
            L_0x019f:
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r9 = r9.f62164e
                int r2 = r8.f62178c
                java.lang.Object r9 = r9.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r9 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r9
                r9.setIsAdded(r1)
                net.one97.paytm.recharge.di.helper.b r9 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRGridProduct> r9 = r9.f62164e     // Catch:{ all -> 0x01e8 }
                int r1 = r8.f62178c     // Catch:{ all -> 0x01e8 }
                java.lang.Object r9 = r9.get(r1)     // Catch:{ all -> 0x01e8 }
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.common.entity.shopping.CJRGridProduct r9 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r9     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r0 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                android.content.Context r0 = r0.f62162c     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r1 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                java.lang.String r1 = r1.f62165f     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r2 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                java.lang.String r2 = r2.f62166g     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.di.helper.b.b((net.one97.paytm.common.entity.shopping.CJRGridProduct) r9, (android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.di.helper.b r9 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                android.content.Context r0 = r9.f62162c     // Catch:{ all -> 0x01e8 }
                net.one97.paytm.recharge.coupons.a.a r9 = r8.f62176a     // Catch:{ all -> 0x01e8 }
                java.lang.String r1 = r9.j     // Catch:{ all -> 0x01e8 }
                java.lang.String r2 = "coupon_selected"
                java.lang.String r3 = ""
                java.lang.String r4 = ""
                java.lang.String r5 = ""
                java.lang.String r6 = "recharges_utilities"
                net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x01e8 }
            L_0x01e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.a.a.c.onClick(android.view.View):void");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62179a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f62180b;

        d(a aVar, int i2) {
            this.f62179a = aVar;
            this.f62180b = i2;
        }

        public final void onClick(View view) {
            CJRGridProduct cJRGridProduct = this.f62179a.f62164e.get(this.f62180b);
            k.a((Object) cJRGridProduct, "mCouponList[position]");
            String dealError = cJRGridProduct.getDealError();
            k.a((Object) dealError, "mCouponList[position].dealError");
            if (dealError.length() == 0) {
                Context context = this.f62179a.f62162c;
                if (context != null) {
                    AJRCouponsActivityV8 aJRCouponsActivityV8 = (AJRCouponsActivityV8) context;
                    CJRGridProduct cJRGridProduct2 = this.f62179a.f62164e.get(this.f62180b);
                    k.a((Object) cJRGridProduct2, "mCouponList[position]");
                    CJRGridProduct cJRGridProduct3 = cJRGridProduct2;
                    String str = this.f62179a.f62165f;
                    String str2 = this.f62179a.f62166g;
                    int i2 = this.f62180b;
                    k.c(cJRGridProduct3, "gridProduct");
                    k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
                    k.c(str2, "categoryName");
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a2.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName = a2.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.DEAL_CLICK.name());
                    }
                    x.a aVar = new x.a();
                    aVar.element = true;
                    aJRCouponsActivityV8.f62184a = cJRGridProduct3;
                    net.one97.paytm.recharge.coupons.e.a aVar2 = aJRCouponsActivityV8.f62185b;
                    if (aVar2 != null) {
                        String url = cJRGridProduct3.getUrl();
                        k.a((Object) url, "gridProduct.getUrl()");
                        k.c("fetch_deal_detail", "tag");
                        k.c(url, "url");
                        aVar2.f62284e.setValue(null);
                        aVar2.f62284e.setValue(new CJRDetailProduct());
                        aVar2.f62287h.e("fetch_deal_detail", aVar2, url, a2);
                        y<CJRDetailProduct> yVar = aVar2.f62284e;
                        if (yVar != null) {
                            yVar.observe(aJRCouponsActivityV8, new AJRCouponsActivityV8.f(aJRCouponsActivityV8, aVar, cJRGridProduct3, i2, str2, str));
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8");
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.coupons.a.a$a  reason: collision with other inner class name */
    public static final class C1194a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CJRCircleImageViewV8 f62169a;

        /* renamed from: b  reason: collision with root package name */
        TextView f62170b;

        /* renamed from: c  reason: collision with root package name */
        TextView f62171c;

        /* renamed from: d  reason: collision with root package name */
        TextView f62172d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f62173e;

        /* renamed from: f  reason: collision with root package name */
        LinearLayout f62174f;

        /* renamed from: g  reason: collision with root package name */
        TextView f62175g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1194a(View view) {
            super(view);
            k.c(view, "view");
            CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) view.findViewById(R.id.operator);
            if (cJRCircleImageViewV8 != null) {
                this.f62169a = cJRCircleImageViewV8;
                TextView textView = (TextView) view.findViewById(R.id.dealsTitleText);
                if (textView != null) {
                    this.f62170b = textView;
                    TextView textView2 = (TextView) view.findViewById(R.id.dealAmount);
                    if (textView2 != null) {
                        this.f62171c = textView2;
                        TextView textView3 = (TextView) view.findViewById(R.id.dealsText);
                        if (textView3 != null) {
                            this.f62172d = textView3;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layoutDeal);
                            if (linearLayout != null) {
                                this.f62173e = linearLayout;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.dealSelectProgress);
                                if (linearLayout2 != null) {
                                    this.f62174f = linearLayout2;
                                    TextView textView4 = (TextView) view.findViewById(R.id.dealError);
                                    if (textView4 != null) {
                                        this.f62175g = textView4;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8");
        }
    }

    public final void a(ArrayList<CJRGridProduct> arrayList, ArrayList<String> arrayList2, ArrayList<CJRSelectedRecharge> arrayList3, HashMap<String, String> hashMap, String str, Integer num) {
        k.c(arrayList, "couponList");
        k.c(arrayList2, "selectedCouponList");
        k.c(arrayList3, "selectedRechargeIdList");
        k.c(hashMap, "rechargeConfig");
        k.c(str, "gtmCategoryName");
        this.m = false;
        this.f62164e = arrayList;
        this.f62160a = arrayList2;
        this.f62161b = arrayList3;
        this.k = hashMap;
        this.l = str;
        if (num == null || num.intValue() == -1) {
            notifyDataSetChanged();
        } else {
            notifyItemChanged(num.intValue());
        }
    }

    public final void a() {
        List list;
        try {
            if (this.o > this.n && this.n >= 0) {
                if (this.o <= this.f62164e.size()) {
                    List<CJRGridProduct> subList = this.f62164e.subList(this.n, this.o);
                    k.a((Object) subList, "mCouponList.subList(prev…unt, impressionListCount)");
                    String string = this.f62162c.getString(R.string.deal_near_you, new Object[]{this.l});
                    k.a((Object) string, "context.getString(R.stri…ear_you,mGTMCategoryName)");
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    Context context = this.f62162c;
                    if (subList == null) {
                        list = null;
                    } else {
                        ArrayList arrayList = new ArrayList(subList);
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            CJRGridProduct cJRGridProduct = (CJRGridProduct) it2.next();
                            k.a((Object) cJRGridProduct, "product");
                            cJRGridProduct.setSource(new l("/").replaceFirst(this.f62165f, ""));
                        }
                        list = arrayList;
                    }
                    net.one97.paytm.recharge.di.helper.b.a(context, list, "", string, this.f62165f, this.n, "", "");
                    this.n = this.o;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
