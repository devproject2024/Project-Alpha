package net.one97.paytm.recharge.coupons.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeBaseActivityV8;
import net.one97.paytm.recharge.common.c.c;
import net.one97.paytm.recharge.common.utils.aw;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.coupons.widget.CJRDealSelectWidgetV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJRCouponGrid;
import net.one97.paytm.recharge.model.CJRCouponHeader;
import net.one97.paytm.recharge.model.CJRCouponHeaderItem;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.CJRPromoCode;
import net.one97.paytm.recharge.model.CJRPromoCodeTerms;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class AJRCouponsActivityV8 extends AJRRechargeBaseActivityV8 implements TabLayout.b<TabLayout.f>, c.b, net.one97.paytm.recharge.common.e.s, net.one97.paytm.recharge.common.e.u, net.one97.paytm.recharge.coupons.c.a {
    /* access modifiers changed from: private */
    public static final String au;

    /* renamed from: e  reason: collision with root package name */
    public static final b f62183e = new b((byte) 0);
    private CJRRechargeCart A = new CJRRechargeCart();
    private CJRAddress B;
    private CJRCartProduct C;
    private JSONObject D = new JSONObject();
    private CJRSelectedRecharge E = new CJRSelectedRecharge();
    /* access modifiers changed from: private */
    public CJRPersonalInsurance F;
    private String G = "";
    private String H = "";
    /* access modifiers changed from: private */
    public String I = "";
    private String J = "";
    private String K = "";
    private String L = "";
    private String M = "";
    private String N = "";
    private String O = "";
    private String P = "";
    /* access modifiers changed from: private */
    public String Q = "";
    private String R = "";
    private String S = "";
    private String T;
    /* access modifiers changed from: private */
    public String U = "";
    /* access modifiers changed from: private */
    public String V = "";
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public CJRGridProduct f62184a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    /* access modifiers changed from: private */
    public boolean ad;
    private boolean ae;
    private boolean af;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.c.c ag;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.c.d ah;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.c.d ai;
    /* access modifiers changed from: private */
    public boolean aj;
    /* access modifiers changed from: private */
    public CJROfferCode ak;
    /* access modifiers changed from: private */
    public String al = "";
    /* access modifiers changed from: private */
    public String am = "";
    private boolean an;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.utils.o ao;
    private String ap;
    private String aq;
    /* access modifiers changed from: private */
    public Handler ar;
    /* access modifiers changed from: private */
    public Runnable as;
    private final ab at = new ab(this);
    private HashMap av;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.recharge.coupons.e.a f62185b;

    /* renamed from: c  reason: collision with root package name */
    CJRRechargeCart f62186c = new CJRRechargeCart();

    /* renamed from: d  reason: collision with root package name */
    androidx.lifecycle.z<CJRRechargeCart> f62187d;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c f62188f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f62189g = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<CJRSelectedRecharge> f62190h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CJRCartProduct> f62191i = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<String> j = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Boolean> k = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> l = new ArrayList<>();
    /* access modifiers changed from: private */
    public final HashMap<Integer, CJRCouponGrid> m = new HashMap<>();
    /* access modifiers changed from: private */
    public ArrayList<Boolean> n = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Boolean> o = new ArrayList<>();
    /* access modifiers changed from: private */
    public androidx.lifecycle.y<CJROffers> p;
    private c.d q = new c.d();
    private net.one97.paytm.recharge.coupons.e.b r;
    private CJRRechargePayment s;
    private CJRDetailProduct t;
    /* access modifiers changed from: private */
    public boolean u;
    private GestureDetector v;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private final String y = "sku_promo_info";
    /* access modifiers changed from: private */
    public CJRCouponHeader z = new CJRCouponHeader();

    public final View a(int i2) {
        if (this.av == null) {
            this.av = new HashMap();
        }
        View view = (View) this.av.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.av.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "error");
    }

    public final void d() {
    }

    public void onTabReselected(TabLayout.f fVar) {
    }

    public void onTabUnselected(TabLayout.f fVar) {
    }

    static final class aa<T> implements androidx.lifecycle.z<CJRGridProduct> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62200a;

        aa(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62200a = aJRCouponsActivityV8;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(17:10|(1:12)|13|(1:15)|16|17|(2:19|20)(1:21)|22|(1:24)|25|(1:28)|(2:31|32)|33|34|(1:38)|39|(1:57)(2:45|(1:59)(2:49|54))) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00bb */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0 A[Catch:{ Exception -> 0x0128 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:? A[Catch:{ Exception -> 0x0128 }, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r11) {
            /*
                r10 = this;
                net.one97.paytm.common.entity.shopping.CJRGridProduct r11 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r11
                if (r11 == 0) goto L_0x0008
                r0 = 0
                r11.setIsAdded(r0)     // Catch:{ Exception -> 0x0128 }
            L_0x0008:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.ArrayList r0 = r0.j     // Catch:{ Exception -> 0x0128 }
                java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x0128 }
                r1 = 0
                if (r11 == 0) goto L_0x0018
                java.lang.String r2 = r11.getProductID()     // Catch:{ Exception -> 0x0128 }
                goto L_0x0019
            L_0x0018:
                r2 = r1
            L_0x0019:
                if (r0 == 0) goto L_0x0120
                java.util.Collection r0 = kotlin.g.b.ab.b(r0)     // Catch:{ Exception -> 0x0128 }
                r0.remove(r2)     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.common.utils.o r0 = r0.ao     // Catch:{ Exception -> 0x0128 }
                if (r0 == 0) goto L_0x0033
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r2 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.ArrayList r2 = r2.j     // Catch:{ Exception -> 0x0128 }
                r0.b((java.util.ArrayList<java.lang.String>) r2)     // Catch:{ Exception -> 0x0128 }
            L_0x0033:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                int r2 = net.one97.paytm.recharge.R.id.widgetSelectDeal     // Catch:{ Exception -> 0x0128 }
                android.view.View r0 = r0.a((int) r2)     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.widget.CJRDealSelectWidgetV8 r0 = (net.one97.paytm.recharge.coupons.widget.CJRDealSelectWidgetV8) r0     // Catch:{ Exception -> 0x0128 }
                int r0 = r0.getItemSize()     // Catch:{ Exception -> 0x0128 }
                if (r0 != 0) goto L_0x0048
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.M(r0)     // Catch:{ Exception -> 0x0128 }
            L_0x0048:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$c r0 = r0.f62188f     // Catch:{ Exception -> 0x0128 }
                java.lang.String r2 = "dealViewPager"
                if (r0 == 0) goto L_0x0068
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r3 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                int r4 = net.one97.paytm.recharge.R.id.dealViewPager     // Catch:{ Exception -> 0x0128 }
                android.view.View r3 = r3.a((int) r4)     // Catch:{ Exception -> 0x0128 }
                androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3     // Catch:{ Exception -> 0x0128 }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x0128 }
                int r3 = r3.getCurrentItem()     // Catch:{ Exception -> 0x0128 }
                androidx.fragment.app.Fragment r0 = r0.a(r3)     // Catch:{ Exception -> 0x0128 }
                goto L_0x0069
            L_0x0068:
                r0 = r1
            L_0x0069:
                boolean r3 = r0 instanceof net.one97.paytm.recharge.coupons.b.a     // Catch:{ Exception -> 0x0128 }
                if (r3 != 0) goto L_0x006e
                r0 = r1
            L_0x006e:
                net.one97.paytm.recharge.coupons.b.a r0 = (net.one97.paytm.recharge.coupons.b.a) r0     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r1 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.HashMap r1 = r1.m     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r3 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                int r4 = net.one97.paytm.recharge.R.id.dealViewPager     // Catch:{ Exception -> 0x0128 }
                android.view.View r3 = r3.a((int) r4)     // Catch:{ Exception -> 0x0128 }
                androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3     // Catch:{ Exception -> 0x0128 }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x0128 }
                int r2 = r3.getCurrentItem()     // Catch:{ Exception -> 0x0128 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0128 }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.model.CJRCouponGrid r1 = (net.one97.paytm.recharge.model.CJRCouponGrid) r1     // Catch:{ Exception -> 0x0128 }
                if (r1 == 0) goto L_0x00aa
                if (r0 == 0) goto L_0x00aa
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r2 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.ArrayList r2 = r2.j     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r3 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.ArrayList r3 = r3.f62190h     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r4 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.util.HashMap r4 = r4.f62189g     // Catch:{ Exception -> 0x0128 }
                r0.a((net.one97.paytm.recharge.model.CJRCouponGrid) r1, (java.util.ArrayList<java.lang.String>) r2, (java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRSelectedRecharge>) r3, (java.util.HashMap<java.lang.String, java.lang.String>) r4, (java.lang.Integer) -1)     // Catch:{ Exception -> 0x0128 }
            L_0x00aa:
                if (r11 == 0) goto L_0x00bb
                if (r0 == 0) goto L_0x00bb
                net.one97.paytm.recharge.di.helper.b r1 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x00bb }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r1 = r10.f62200a     // Catch:{ all -> 0x00bb }
                android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x00bb }
                java.lang.String r2 = r0.f62268c     // Catch:{ all -> 0x00bb }
                java.lang.String r0 = r0.f62269d     // Catch:{ all -> 0x00bb }
                net.one97.paytm.recharge.di.helper.b.a((net.one97.paytm.common.entity.shopping.CJRGridProduct) r11, (android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x00bb }
            L_0x00bb:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.e.a r0 = r0.f62185b     // Catch:{ Exception -> 0x0128 }
                if (r0 == 0) goto L_0x00d9
                net.one97.paytm.recharge.ordersummary.h.d r1 = r0.p     // Catch:{ Exception -> 0x0128 }
                if (r1 == 0) goto L_0x00d9
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                java.lang.String r2 = r0.V     // Catch:{ Exception -> 0x0128 }
                java.lang.String r3 = "coupon_declined"
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 124(0x7c, float:1.74E-43)
                net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0128 }
            L_0x00d9:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                r0.i()     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.common.entity.CJRRechargeCart r0 = r0.f62186c     // Catch:{ Exception -> 0x0128 }
                if (r0 == 0) goto L_0x011f
                net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()     // Catch:{ Exception -> 0x0128 }
                if (r0 == 0) goto L_0x011f
                java.lang.String r0 = r0.getGrandTotalExcludingConvFee()     // Catch:{ Exception -> 0x0128 }
                if (r0 == 0) goto L_0x011f
                java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0128 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0128 }
                double r0 = r1.doubleValue()     // Catch:{ Exception -> 0x0128 }
                java.lang.String r2 = "it"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r11 = r11.getDiscountedPrice()     // Catch:{ Exception -> 0x0128 }
                java.lang.String r2 = "it.discountedPrice"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x0128 }
                double r2 = java.lang.Double.parseDouble(r11)     // Catch:{ Exception -> 0x0128 }
                double r0 = r0 - r2
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r11 = r10.f62200a     // Catch:{ Exception -> 0x0128 }
                net.one97.paytm.common.entity.CJRRechargeCart r11 = r11.f62186c     // Catch:{ Exception -> 0x0128 }
                if (r11 == 0) goto L_0x011f
                net.one97.paytm.common.entity.shopping.CJRCart r11 = r11.getCart()     // Catch:{ Exception -> 0x0128 }
                if (r11 == 0) goto L_0x011f
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0128 }
                r11.setGrandTotalExcludingConvFee(r0)     // Catch:{ Exception -> 0x0128 }
            L_0x011f:
                return
            L_0x0120:
                kotlin.u r11 = new kotlin.u     // Catch:{ Exception -> 0x0128 }
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>"
                r11.<init>(r0)     // Catch:{ Exception -> 0x0128 }
                throw r11     // Catch:{ Exception -> 0x0128 }
            L_0x0128:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.aa.onChanged(java.lang.Object):void");
        }
    }

    static final class ad extends kotlin.g.b.l implements kotlin.g.a.b<CJRPromoCodeTerms, kotlin.x> {
        final /* synthetic */ AJRCouponsActivityV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(1);
            this.this$0 = aJRCouponsActivityV8;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRPromoCodeTerms) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRPromoCodeTerms cJRPromoCodeTerms) {
            if (cJRPromoCodeTerms != null && !TextUtils.isEmpty(cJRPromoCodeTerms.getTerms())) {
                AJRCouponsActivityV8 aJRCouponsActivityV8 = this.this$0;
                String promoCode = cJRPromoCodeTerms.getPromoCode();
                if (promoCode == null) {
                    promoCode = "";
                }
                aJRCouponsActivityV8.a(promoCode, cJRPromoCodeTerms.getTerms(), true);
            }
        }
    }

    static final class ag<T> implements androidx.lifecycle.z<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f62206b;

        ag(AJRCouponsActivityV8 aJRCouponsActivityV8, x.e eVar) {
            this.f62205a = aJRCouponsActivityV8;
            this.f62206b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) obj;
            if ((cJRRechargeCart != null ? cJRRechargeCart.getCart() : null) != null) {
                AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62205a;
                CJROfferCode P = aJRCouponsActivityV8.ak;
                if (P == null) {
                    kotlin.g.b.k.a();
                }
                AJRCouponsActivityV8.a(aJRCouponsActivityV8, cJRRechargeCart, P);
                androidx.lifecycle.y yVar = (androidx.lifecycle.y) this.f62206b.element;
                if (yVar != null) {
                    androidx.lifecycle.z<CJRRechargeCart> zVar = this.f62205a.f62187d;
                    if (zVar == null) {
                        kotlin.g.b.k.a();
                    }
                    yVar.removeObserver(zVar);
                }
                net.one97.paytm.recharge.common.c.c Q = this.f62205a.ag;
                if (Q != null) {
                    Q.a(8);
                }
            }
        }
    }

    public static final class f<T> implements androidx.lifecycle.z<CJRDetailProduct> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f62225b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRGridProduct f62226c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f62227d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f62228e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f62229f;

        public f(AJRCouponsActivityV8 aJRCouponsActivityV8, x.a aVar, CJRGridProduct cJRGridProduct, int i2, String str, String str2) {
            this.f62224a = aJRCouponsActivityV8;
            this.f62225b = aVar;
            this.f62226c = cJRGridProduct;
            this.f62227d = i2;
            this.f62228e = str;
            this.f62229f = str2;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRDetailProduct cJRDetailProduct = (CJRDetailProduct) obj;
            if (this.f62225b.element && cJRDetailProduct != null) {
                CharSequence brand = cJRDetailProduct.getBrand();
                if (!(brand == null || brand.length() == 0)) {
                    cJRDetailProduct.setmSource(this.f62226c.getSource());
                    Intent intent = new Intent(this.f62224a, DealDetail.class);
                    intent.putExtra("product_detail", cJRDetailProduct);
                    intent.putExtra("coupon_id", this.f62224a.j);
                    intent.setFlags(67108864);
                    intent.putExtra("selected_position", this.f62227d);
                    this.f62224a.startActivityForResult(intent, 549);
                    try {
                        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                        net.one97.paytm.recharge.di.helper.b.a((Context) this.f62224a, this.f62226c, this.f62227d, this.f62228e, this.f62229f);
                    } catch (Throwable unused) {
                    }
                    this.f62225b.element = false;
                }
            }
        }
    }

    static final /* synthetic */ class s extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, kotlin.x> {
        s(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(3, aJRCouponsActivityV8);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return kotlin.g.b.y.b(AJRCouponsActivityV8.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return kotlin.x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCouponsActivityV8) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class t extends kotlin.g.b.l implements kotlin.g.a.b<CJRPersonalInsurance, kotlin.x> {
        final /* synthetic */ AJRCouponsActivityV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(1);
            this.this$0 = aJRCouponsActivityV8;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRPersonalInsurance) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRPersonalInsurance cJRPersonalInsurance) {
            net.one97.paytm.recharge.common.utils.o a2;
            String str = null;
            if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null)) {
                if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getProductID() : null)) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.this$0.a(R.id.insuranceLayout);
                    kotlin.g.b.k.a((Object) relativeLayout, "insuranceLayout");
                    relativeLayout.setVisibility(0);
                    TextView textView = (TextView) this.this$0.a(R.id.tvInsuranceText);
                    kotlin.g.b.k.a((Object) textView, "tvInsuranceText");
                    textView.setText(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null);
                    this.this$0.F = cJRPersonalInsurance;
                    if (!(this.this$0.F == null || (a2 = this.this$0.ao) == null)) {
                        CJRPersonalInsurance i2 = this.this$0.F;
                        if (i2 == null) {
                            kotlin.g.b.k.a();
                        }
                        a2.a(i2);
                    }
                    if (this.this$0.ah == null) {
                        this.this$0.ah = new net.one97.paytm.recharge.common.c.d();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("tnc_title", this.this$0.getString(R.string.terms_and_conditions_title));
                    bundle.putString("tnc_text", cJRPersonalInsurance != null ? cJRPersonalInsurance.getTermsAndConditions() : null);
                    net.one97.paytm.recharge.common.c.d j = this.this$0.ah;
                    if (j == null) {
                        kotlin.g.b.k.a();
                    }
                    j.setArguments(bundle);
                    TextView textView2 = (TextView) this.this$0.a(R.id.tvInsuranceText);
                    kotlin.g.b.k.a((Object) textView2, "tvInsuranceText");
                    AJRCouponsActivityV8 aJRCouponsActivityV8 = this.this$0;
                    if (cJRPersonalInsurance != null) {
                        str = cJRPersonalInsurance.getTitleForPersonalInsurance();
                    }
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    textView2.setText(AJRCouponsActivityV8.b(aJRCouponsActivityV8, str));
                    TextView textView3 = (TextView) this.this$0.a(R.id.tvInsuranceText);
                    kotlin.g.b.k.a((Object) textView3, "tvInsuranceText");
                    textView3.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) this.this$0.a(R.id.tvInsuranceText)).clearFocus();
                    if (cJRPersonalInsurance.getPreSelected()) {
                        CheckBox checkBox = (CheckBox) this.this$0.a(R.id.insuranceCheckbox);
                        kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
                        checkBox.setChecked(true);
                        AJRCouponsActivityV8.f(this.this$0);
                        this.this$0.i();
                    }
                }
            }
        }
    }

    static final class u extends kotlin.g.b.l implements kotlin.g.a.b<CJRCouponHeader, kotlin.x> {
        final /* synthetic */ AJRCouponsActivityV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(1);
            this.this$0 = aJRCouponsActivityV8;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCouponHeader) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRCouponHeader cJRCouponHeader) {
            AJRCouponsActivityV8 aJRCouponsActivityV8 = this.this$0;
            if (cJRCouponHeader == null) {
                kotlin.g.b.k.a();
            }
            aJRCouponsActivityV8.z = cJRCouponHeader;
            int size = this.this$0.z.getCouponHeaderItemList().size();
            for (int i2 = 0; i2 < size; i2++) {
                this.this$0.l.add(1);
                this.this$0.n.add(Boolean.FALSE);
                this.this$0.o.add(Boolean.FALSE);
                this.this$0.k.add(Boolean.TRUE);
            }
            AJRCouponsActivityV8.b(this.this$0, cJRCouponHeader);
        }
    }

    static final class v extends kotlin.g.b.l implements kotlin.g.a.b<CJRCouponGrid, kotlin.x> {
        final /* synthetic */ AJRCouponsActivityV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(1);
            this.this$0 = aJRCouponsActivityV8;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCouponGrid) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRCouponGrid cJRCouponGrid) {
            b bVar = AJRCouponsActivityV8.f62183e;
            String unused = AJRCouponsActivityV8.au;
            new StringBuilder("getCouponListResponse before").append(this.this$0.x);
            com.paytm.utility.b.j();
            int size = this.this$0.k.size();
            ViewPager viewPager = (ViewPager) this.this$0.a(R.id.dealViewPager);
            kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
            if (size > viewPager.getCurrentItem()) {
                if (cJRCouponGrid != null) {
                    if (cJRCouponGrid.getGridLayout() == null || cJRCouponGrid.getGridLayout().size() == 0) {
                        ArrayList p = this.this$0.k;
                        ViewPager viewPager2 = (ViewPager) this.this$0.a(R.id.dealViewPager);
                        kotlin.g.b.k.a((Object) viewPager2, "dealViewPager");
                        p.set(viewPager2.getCurrentItem(), Boolean.FALSE);
                    }
                    int i2 = 0;
                    int size2 = cJRCouponGrid.getGridLayout().size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            CJRGridProduct cJRGridProduct = cJRCouponGrid.getGridLayout().get(i2);
                            kotlin.g.b.k.a((Object) cJRGridProduct, "it.gridLayout[i]");
                            ViewPager viewPager3 = (ViewPager) this.this$0.a(R.id.dealViewPager);
                            kotlin.g.b.k.a((Object) viewPager3, "dealViewPager");
                            cJRGridProduct.setListPosition(viewPager3.getCurrentItem());
                            if (i2 == size2) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
                ArrayList p2 = this.this$0.k;
                ViewPager viewPager4 = (ViewPager) this.this$0.a(R.id.dealViewPager);
                kotlin.g.b.k.a((Object) viewPager4, "dealViewPager");
                int currentItem = viewPager4.getCurrentItem();
                Boolean valueOf = cJRCouponGrid != null ? Boolean.valueOf(cJRCouponGrid.hasMore()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                p2.add(currentItem, valueOf);
                if (this.this$0.x) {
                    this.this$0.x = false;
                    AJRCouponsActivityV8.a(this.this$0, cJRCouponGrid);
                    return;
                }
                AJRCouponsActivityV8.b(this.this$0, cJRCouponGrid);
            }
        }
    }

    static final class w extends kotlin.g.b.l implements kotlin.g.a.b<CJRInstruct, kotlin.x> {
        final /* synthetic */ AJRCouponsActivityV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            super(1);
            this.this$0 = aJRCouponsActivityV8;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            this.this$0.a(cJRInstruct);
        }
    }

    static final class y<T> implements androidx.lifecycle.z<net.one97.paytm.recharge.coupons.e.c<CJRGridProduct>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62251a;

        y(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62251a = aJRCouponsActivityV8;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final CJRGridProduct cJRGridProduct;
            final Integer num;
            String str;
            net.one97.paytm.recharge.coupons.e.c cVar = (net.one97.paytm.recharge.coupons.e.c) obj;
            try {
                this.f62251a.ad = true;
                String str2 = null;
                if (cVar != null) {
                    cJRGridProduct = cVar.f62293a;
                } else {
                    cJRGridProduct = null;
                }
                if (cVar != null) {
                    num = cVar.f62294b;
                } else {
                    num = null;
                }
                if (this.f62251a.j != null) {
                    ArrayList y = this.f62251a.j;
                    String productID = cJRGridProduct != null ? cJRGridProduct.getProductID() : null;
                    if (productID == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!y.contains(productID)) {
                        ArrayList y2 = this.f62251a.j;
                        String productID2 = cJRGridProduct != null ? cJRGridProduct.getProductID() : null;
                        if (productID2 == null) {
                            kotlin.g.b.k.a();
                        }
                        y2.add(productID2);
                        net.one97.paytm.recharge.common.utils.o a2 = this.f62251a.ao;
                        if (a2 != null) {
                            a2.b((ArrayList<String>) this.f62251a.j);
                        }
                    }
                }
                final x.a aVar = new x.a();
                aVar.element = true;
                ViewPager viewPager = (ViewPager) this.f62251a.a(R.id.dealViewPager);
                kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
                int currentItem = viewPager.getCurrentItem();
                if (cJRGridProduct != null && currentItem == cJRGridProduct.getListPosition()) {
                    cJRGridProduct.setAddToCartShow(false);
                    c D = this.f62251a.f62188f;
                    androidx.savedstate.c a3 = D != null ? D.a(cJRGridProduct.getListPosition()) : null;
                    if (!(a3 instanceof net.one97.paytm.recharge.coupons.b.a)) {
                        a3 = null;
                    }
                    net.one97.paytm.recharge.coupons.b.a aVar2 = (net.one97.paytm.recharge.coupons.b.a) a3;
                    CJRCouponGrid cJRCouponGrid = (CJRCouponGrid) this.f62251a.m.get(Integer.valueOf(cJRGridProduct.getListPosition()));
                    if (!(cJRCouponGrid == null || aVar2 == null)) {
                        aVar2.a(cJRCouponGrid, (ArrayList<String>) this.f62251a.j, (ArrayList<CJRSelectedRecharge>) this.f62251a.f62190h, (HashMap<String, String>) this.f62251a.f62189g, num);
                    }
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                ay ayVar = ay.f61523a;
                ay.a(ERROR_TYPE.INLINE_ERROR, ACTION_TYPE.DEAL_VERIFY, a4);
                if (cJRGridProduct != null) {
                    str2 = cJRGridProduct.getProductID();
                }
                a4.setProductId(str2);
                net.one97.paytm.recharge.coupons.e.a b2 = this.f62251a.f62185b;
                if (b2 != null) {
                    AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62251a;
                    String z = this.f62251a.U;
                    if (cJRGridProduct == null || (str = cJRGridProduct.getDiscountedPrice()) == null) {
                        str = "";
                    }
                    b2.a("deal_verify", AJRCouponsActivityV8.a(aJRCouponsActivityV8, z, str, false, true, 16), new net.one97.paytm.recharge.common.e.ai(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ y f62252a;

                        {
                            this.f62252a = r1;
                        }

                        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                            net.one97.paytm.recharge.ordersummary.h.d dVar;
                            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
                            if (iJRPaytmDataModel2 instanceof CJRRechargeCart) {
                                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel2;
                                if (cJRRechargeCart.getCart() != null) {
                                    this.f62252a.f62251a.n();
                                    if (aVar.element) {
                                        ay ayVar = ay.f61523a;
                                        String a2 = ay.a(cJRRechargeCart, this.f62252a.f62251a);
                                        CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                                        boolean z = true;
                                        if (kotlin.m.p.a(cartStatus != null ? cartStatus.getResult() : null, "SUCCESS", true)) {
                                            if (a2.length() == 0) {
                                                CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = (CJRDealSelectWidgetV8) this.f62252a.f62251a.a(R.id.widgetSelectDeal);
                                                CJRGridProduct cJRGridProduct = cJRGridProduct;
                                                if (cJRGridProduct == null) {
                                                    kotlin.g.b.k.a();
                                                }
                                                kotlin.g.b.k.c(cJRGridProduct, "dealsModel");
                                                try {
                                                    cJRDealSelectWidgetV8.f62295a++;
                                                    cJRGridProduct.setDeleted(false);
                                                    cJRDealSelectWidgetV8.f62297c.add(cJRGridProduct);
                                                    int i2 = cJRDealSelectWidgetV8.f62302h;
                                                    String discountedPrice = cJRGridProduct.getDiscountedPrice();
                                                    kotlin.g.b.k.a((Object) discountedPrice, "dealsModel.discountedPrice");
                                                    cJRDealSelectWidgetV8.f62302h = i2 + Integer.parseInt(discountedPrice);
                                                    String discountedPrice2 = cJRGridProduct.getDiscountedPrice();
                                                    kotlin.g.b.k.a((Object) discountedPrice2, "dealsModel.discountedPrice");
                                                    if (((float) Integer.parseInt(discountedPrice2)) > 0.0f) {
                                                        cJRDealSelectWidgetV8.j++;
                                                    } else {
                                                        cJRDealSelectWidgetV8.f62303i++;
                                                    }
                                                    if (!cJRDealSelectWidgetV8.f62300f) {
                                                        cJRDealSelectWidgetV8.f62296b.clear();
                                                        cJRDealSelectWidgetV8.f62301g = true;
                                                    }
                                                    cJRDealSelectWidgetV8.f62296b.add(cJRGridProduct);
                                                    cJRDealSelectWidgetV8.f62298d.notifyDataSetChanged();
                                                } catch (Throwable th) {
                                                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                                                }
                                                this.f62252a.f62251a.f62186c = cJRRechargeCart;
                                                AJRCouponsActivityV8.I(this.f62252a.f62251a);
                                                AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62252a.f62251a;
                                                AJRCouponsActivityV8 aJRCouponsActivityV82 = this.f62252a.f62251a;
                                                CJRRechargeCart cJRRechargeCart2 = this.f62252a.f62251a.f62186c;
                                                aJRCouponsActivityV8.I = aJRCouponsActivityV82.a(cJRRechargeCart2 != null ? cJRRechargeCart2.getCart() : null);
                                                this.f62252a.f62251a.k();
                                                ViewPager viewPager = (ViewPager) this.f62252a.f62251a.a(R.id.dealViewPager);
                                                kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
                                                if (viewPager.getCurrentItem() == cJRGridProduct.getListPosition()) {
                                                    cJRGridProduct.setAddToCartShow(true);
                                                    c D = this.f62252a.f62251a.f62188f;
                                                    androidx.savedstate.c a3 = D != null ? D.a(cJRGridProduct.getListPosition()) : null;
                                                    if (!(a3 instanceof net.one97.paytm.recharge.coupons.b.a)) {
                                                        a3 = null;
                                                    }
                                                    net.one97.paytm.recharge.coupons.b.a aVar = (net.one97.paytm.recharge.coupons.b.a) a3;
                                                    CJRCouponGrid cJRCouponGrid = (CJRCouponGrid) this.f62252a.f62251a.m.get(Integer.valueOf(cJRGridProduct.getListPosition()));
                                                    if (!(cJRCouponGrid == null || aVar == null)) {
                                                        kotlin.g.b.k.a((Object) cJRCouponGrid, "it");
                                                        aVar.a(cJRCouponGrid, (ArrayList<String>) this.f62252a.f62251a.j, (ArrayList<CJRSelectedRecharge>) this.f62252a.f62251a.f62190h, (HashMap<String, String>) this.f62252a.f62251a.f62189g, num);
                                                    }
                                                } else {
                                                    cJRGridProduct.setAddToCartShow(true);
                                                    this.f62252a.f62251a.o.set(cJRGridProduct.getListPosition(), Boolean.TRUE);
                                                }
                                                AJRCouponsActivityV8.b(this.f62252a.f62251a, cJRRechargeCart);
                                                aVar.element = false;
                                                this.f62252a.f62251a.ad = false;
                                            }
                                        }
                                        CJRCartStatus cartStatus2 = cJRRechargeCart.getCartStatus();
                                        if (kotlin.m.p.a(cartStatus2 != null ? cartStatus2.getResult() : null, "SUCCESS", true)) {
                                            if (a2.length() != 0) {
                                                z = false;
                                            }
                                            if (!z) {
                                                ViewPager viewPager2 = (ViewPager) this.f62252a.f62251a.a(R.id.dealViewPager);
                                                kotlin.g.b.k.a((Object) viewPager2, "dealViewPager");
                                                int currentItem = viewPager2.getCurrentItem();
                                                CJRGridProduct cJRGridProduct2 = cJRGridProduct;
                                                if (cJRGridProduct2 != null && currentItem == cJRGridProduct2.getListPosition()) {
                                                    cJRGridProduct.setDealError(a2);
                                                    c D2 = this.f62252a.f62251a.f62188f;
                                                    androidx.savedstate.c a4 = D2 != null ? D2.a(cJRGridProduct.getListPosition()) : null;
                                                    if (!(a4 instanceof net.one97.paytm.recharge.coupons.b.a)) {
                                                        a4 = null;
                                                    }
                                                    net.one97.paytm.recharge.coupons.b.a aVar2 = (net.one97.paytm.recharge.coupons.b.a) a4;
                                                    CJRCouponGrid cJRCouponGrid2 = (CJRCouponGrid) this.f62252a.f62251a.m.get(Integer.valueOf(cJRGridProduct.getListPosition()));
                                                    if (!(cJRCouponGrid2 == null || aVar2 == null)) {
                                                        kotlin.g.b.k.a((Object) cJRCouponGrid2, "it");
                                                        aVar2.a(cJRCouponGrid2, (ArrayList<String>) this.f62252a.f62251a.j, (ArrayList<CJRSelectedRecharge>) this.f62252a.f62251a.f62190h, (HashMap<String, String>) this.f62252a.f62251a.f62189g, num);
                                                    }
                                                    ArrayList y = this.f62252a.f62251a.j;
                                                    String productID = cJRGridProduct.getProductID();
                                                    if (productID == null) {
                                                        kotlin.g.b.k.a();
                                                    }
                                                    y.remove(productID);
                                                    net.one97.paytm.recharge.common.utils.o a5 = this.f62252a.f62251a.ao;
                                                    if (a5 != null) {
                                                        a5.b((ArrayList<String>) this.f62252a.f62251a.j);
                                                    }
                                                }
                                                net.one97.paytm.recharge.coupons.e.a b2 = this.f62252a.f62251a.f62185b;
                                                if (!(b2 == null || (dVar = b2.p) == null)) {
                                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.f62252a.f62251a.V, "coupon_declined", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                                                }
                                            }
                                        }
                                        aVar.element = false;
                                        this.f62252a.f62251a.ad = false;
                                    }
                                }
                            }
                        }

                        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                            View a2;
                            if (str != null && str.hashCode() == -70453332 && str.equals("deal_verify") && (a2 = this.f62252a.f62251a.a(R.id.overlay_view)) != null) {
                                net.one97.paytm.recharge.common.utils.ai.b(a2);
                            }
                            this.f62252a.f62251a.a(str, networkCustomError, obj);
                        }
                    }, (Object) a4);
                }
                if (this.f62251a.ar == null) {
                    this.f62251a.ar = new Handler();
                    this.f62251a.as = new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ y f62256a;

                        {
                            this.f62256a = r1;
                        }

                        public final void run() {
                            View a2 = this.f62256a.f62251a.a(R.id.overlay_view);
                            if (a2 != null) {
                                net.one97.paytm.recharge.common.utils.ai.b(a2);
                            }
                        }
                    };
                }
                Handler J = this.f62251a.ar;
                if (J != null) {
                    J.postDelayed(this.f62251a.as, 10000);
                }
                AJRCouponsActivityV8.L(this.f62251a);
            } catch (Exception unused) {
                this.f62251a.n();
            }
        }
    }

    static final class z<T> implements androidx.lifecycle.z<CJRGridProduct> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62257a;

        z(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62257a = aJRCouponsActivityV8;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRCart cart;
            String grandTotalExcludingConvFee;
            CJRCart cart2;
            CJRGridProduct cJRGridProduct = (CJRGridProduct) obj;
            CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = (CJRDealSelectWidgetV8) this.f62257a.a(R.id.widgetSelectDeal);
            if (cJRGridProduct == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(cJRGridProduct, "element");
            Collection arrayList = new ArrayList();
            for (Object next : cJRDealSelectWidgetV8.f62297c) {
                if (kotlin.m.p.a(((CJRGridProduct) next).getProductID(), cJRGridProduct.getProductID(), true)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                try {
                    cJRDealSelectWidgetV8.f62295a--;
                    cJRDealSelectWidgetV8.f62297c.remove(list.get(0));
                    cJRDealSelectWidgetV8.f62296b.remove(list.get(0));
                    int i2 = cJRDealSelectWidgetV8.f62302h;
                    String discountedPrice = ((CJRGridProduct) list.get(0)).getDiscountedPrice();
                    kotlin.g.b.k.a((Object) discountedPrice, "listItem[0].discountedPrice");
                    cJRDealSelectWidgetV8.f62302h = i2 - Integer.parseInt(discountedPrice);
                    String discountedPrice2 = ((CJRGridProduct) list.get(0)).getDiscountedPrice();
                    kotlin.g.b.k.a((Object) discountedPrice2, "listItem[0].discountedPrice");
                    if (((float) Integer.parseInt(discountedPrice2)) > 0.0f) {
                        cJRDealSelectWidgetV8.j--;
                    } else {
                        cJRDealSelectWidgetV8.f62303i--;
                    }
                    if (!cJRDealSelectWidgetV8.f62300f) {
                        cJRDealSelectWidgetV8.f62296b.clear();
                        if (cJRDealSelectWidgetV8.f62297c.size() > 0) {
                            cJRDealSelectWidgetV8.f62296b.add(new CJRGridProduct());
                        }
                    }
                    cJRDealSelectWidgetV8.f62298d.notifyDataSetChanged();
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
            }
            this.f62257a.j.remove(cJRGridProduct.getProductID());
            net.one97.paytm.recharge.common.utils.o a2 = this.f62257a.ao;
            if (a2 != null) {
                a2.b((ArrayList<String>) this.f62257a.j);
            }
            if (((CJRDealSelectWidgetV8) this.f62257a.a(R.id.widgetSelectDeal)).getItemSize() == 0) {
                AJRCouponsActivityV8.M(this.f62257a);
            }
            this.f62257a.i();
            CJRRechargeCart cJRRechargeCart = this.f62257a.f62186c;
            if (cJRRechargeCart != null && (cart = cJRRechargeCart.getCart()) != null && (grandTotalExcludingConvFee = cart.getGrandTotalExcludingConvFee()) != null) {
                double doubleValue = new BigDecimal(grandTotalExcludingConvFee).doubleValue();
                String discountedPrice3 = cJRGridProduct.getDiscountedPrice();
                kotlin.g.b.k.a((Object) discountedPrice3, "it.discountedPrice");
                double parseDouble = doubleValue - Double.parseDouble(discountedPrice3);
                CJRRechargeCart cJRRechargeCart2 = this.f62257a.f62186c;
                if (cJRRechargeCart2 != null && (cart2 = cJRRechargeCart2.getCart()) != null) {
                    cart2.setGrandTotalExcludingConvFee(String.valueOf(parseDouble));
                }
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        String simpleName = AJRCouponsActivityV8.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "AJRCouponsActivityV8::class.java.simpleName");
        au = simpleName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x029b, code lost:
        r0 = r0.getCart();
     */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0518 A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0530 A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x054e A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0551 A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0589 A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x058e A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0591 A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x05aa A[Catch:{ Exception -> 0x05f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x06bd  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x06c0  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x06d1  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x06d4  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x06e5  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x06e8  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x06f9  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x06fc  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x070d A[Catch:{ Exception -> 0x079e }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x07a9  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x07bf  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x07ce  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x07db  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x07fd  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x080f  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0822  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x082b  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x082e  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x083b  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x083e  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0844  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0853  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x0858  */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0860  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0892  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x089b  */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x08d5  */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x08da  */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x08dd  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x08f1  */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x08fd A[Catch:{ all -> 0x0912 }] */
    /* JADX WARNING: Removed duplicated region for block: B:497:0x0951  */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x09b1  */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x09c0  */
    /* JADX WARNING: Removed duplicated region for block: B:512:0x09cd  */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x09e2  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x09ed A[Catch:{ Exception -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0aae  */
    /* JADX WARNING: Removed duplicated region for block: B:552:0x0ab3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r35) {
        /*
            r34 = this;
            r7 = r34
            java.lang.String r1 = "tag"
            java.lang.String r2 = "tvRechargeNumber"
            super.onCreate(r35)
            int r0 = net.one97.paytm.recharge.R.layout.activity_ajr_coupons_v8
            r7.setContentView((int) r0)
            int r0 = net.one97.paytm.recharge.R.id.dealsToolbar
            android.view.View r0 = r7.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r7.a((androidx.appcompat.widget.Toolbar) r0)
            android.content.Intent r3 = r34.getIntent()
            java.lang.String r0 = "intent"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            android.os.Bundle r0 = r3.getExtras()
            java.lang.String r8 = "/coupon"
            java.lang.String r9 = "/"
            if (r0 != 0) goto L_0x0034
            r34.finish()
            r33 = r8
        L_0x0031:
            r8 = 0
            goto L_0x0a65
        L_0x0034:
            java.lang.String r0 = "operator"
            boolean r4 = r3.hasExtra(r0)
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0052
            android.os.Bundle r4 = r3.getExtras()
            if (r4 != 0) goto L_0x0047
            kotlin.g.b.k.a()
        L_0x0047:
            java.lang.String r0 = r4.getString(r0, r5)
            java.lang.String r4 = "intent.extras!!.getStrin…ants.INTENT_OPERATOR, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r7.G = r0
        L_0x0052:
            java.lang.String r0 = "intent_master_no"
            boolean r4 = r3.hasExtra(r0)
            if (r4 == 0) goto L_0x006e
            android.os.Bundle r4 = r3.getExtras()
            if (r4 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            java.lang.String r0 = r4.getString(r0, r5)
            java.lang.String r4 = "intent.extras!!.getStrin…INTENT_MASTER_NUMBER, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r7.H = r0
        L_0x006e:
            java.lang.String r0 = "intent_master_price"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x008c
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            java.lang.String r4 = "intent_master_price"
            java.lang.String r0 = r0.getString(r4, r5)
            java.lang.String r4 = "intent.extras!!.getStrin…s.INTENT_MASTER_PRICE,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r7.I = r0
        L_0x008c:
            java.lang.String r0 = "operator_type"
            boolean r0 = r3.hasExtra(r0)
            r4 = 1
            if (r0 == 0) goto L_0x00c1
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            java.lang.String r6 = "operator_type"
            java.lang.String r0 = r0.getString(r6, r5)
            java.lang.String r6 = "intent.extras!!.getStrin….INTENT_OPERATOR_TYPE,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r7.J = r0
            java.lang.String r0 = r7.J
            java.lang.String r6 = "mobile_prepaid"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r6)
            if (r0 != 0) goto L_0x00bf
            java.lang.String r0 = r7.J
            java.lang.String r6 = "mobile-prepaid"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x00c1
        L_0x00bf:
            r7.Z = r4
        L_0x00c1:
            java.lang.String r0 = "is_applink_transaction"
            boolean r0 = r3.hasExtra(r0)
            r6 = 0
            if (r0 == 0) goto L_0x00db
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x00d3
            kotlin.g.b.k.a()
        L_0x00d3:
            java.lang.String r11 = "is_applink_transaction"
            boolean r0 = r0.getBoolean(r11, r6)
            r7.an = r0
        L_0x00db:
            java.lang.String r0 = "vertical_name"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x00f4
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x00ec
            kotlin.g.b.k.a()
        L_0x00ec:
            java.lang.String r11 = "vertical_name"
            java.lang.String r0 = r0.getString(r11, r5)
            r7.aq = r0
        L_0x00f4:
            java.lang.String r0 = "mid"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x010d
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x0105
            kotlin.g.b.k.a()
        L_0x0105:
            java.lang.String r11 = "mid"
            java.lang.String r0 = r0.getString(r11, r5)
            r7.ap = r0
        L_0x010d:
            java.lang.String r0 = "product_data"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = "product_data"
            java.io.Serializable r0 = r3.getSerializableExtra(r0)
            if (r0 == 0) goto L_0x0122
            net.one97.paytm.common.entity.shopping.CJRDetailProduct r0 = (net.one97.paytm.common.entity.shopping.CJRDetailProduct) r0
            r7.t = r0
            goto L_0x012a
        L_0x0122:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRDetailProduct"
            r0.<init>(r1)
            throw r0
        L_0x012a:
            java.lang.String r0 = "insurance_url"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x0148
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x013b
            kotlin.g.b.k.a()
        L_0x013b:
            java.lang.String r11 = "insurance_url"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…nts.KEY_INSURANCE_URL,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.K = r0
        L_0x0148:
            java.lang.String r0 = "key_show_insurance"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x0158
            java.lang.String r0 = "key_show_insurance"
            boolean r0 = r3.getBooleanExtra(r0, r6)
            r7.W = r0
        L_0x0158:
            java.lang.String r0 = "intent_master_product_id"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x0176
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x0169
            kotlin.g.b.k.a()
        L_0x0169:
            java.lang.String r11 = "intent_master_product_id"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…ENT_MASTER_PRODUCT_ID,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.L = r0
        L_0x0176:
            java.lang.String r0 = "cirlce"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x0194
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x0187
            kotlin.g.b.k.a()
        L_0x0187:
            java.lang.String r11 = "cirlce"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…stants.INTENT_CIRCLE, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.M = r0
        L_0x0194:
            java.lang.String r0 = "category_name"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x01b2
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x01a5
            kotlin.g.b.k.a()
        L_0x01a5:
            java.lang.String r11 = "category_name"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…_EXTRA_CATEGORY_NAME, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.Q = r0
        L_0x01b2:
            java.lang.String r0 = "vertical_id"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x01d0
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x01c3
            kotlin.g.b.k.a()
        L_0x01c3:
            java.lang.String r11 = "vertical_id"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…_CONTACT_VERTICAL_ID, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.R = r0
        L_0x01d0:
            java.lang.String r0 = "post_order_view_type"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x01ee
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x01e1
            kotlin.g.b.k.a()
        L_0x01e1:
            java.lang.String r11 = "post_order_view_type"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…POST_ORDER_VIEW_TYPE, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.S = r0
        L_0x01ee:
            java.lang.String r0 = "payment_method"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x01fe
            java.lang.String r0 = "payment_method"
            java.lang.String r0 = r3.getStringExtra(r0)
            r7.T = r0
        L_0x01fe:
            java.lang.String r0 = "IS_FROM_NEW_SCREEN"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x020e
            java.lang.String r0 = "IS_FROM_NEW_SCREEN"
            boolean r0 = r3.getBooleanExtra(r0, r6)
            r7.ae = r0
        L_0x020e:
            java.lang.String r0 = "dealsFastForward"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x021e
            java.lang.String r0 = "dealsFastForward"
            boolean r0 = r3.getBooleanExtra(r0, r6)
            r7.af = r0
        L_0x021e:
            java.lang.String r0 = "recharge_utilities_service_type"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x023c
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x022f
            kotlin.g.b.k.a()
        L_0x022f:
            java.lang.String r11 = "recharge_utilities_service_type"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…UTILITY_SERVICE_TYPE, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.V = r0
        L_0x023c:
            java.lang.String r0 = "Add_to_paytm_cash"
            boolean r0 = r3.getBooleanExtra(r0, r6)
            r7.X = r0
            java.lang.String r0 = "operator_name"
            boolean r11 = r3.hasExtra(r0)
            if (r11 == 0) goto L_0x0260
            android.os.Bundle r11 = r3.getExtras()
            if (r11 != 0) goto L_0x0255
            kotlin.g.b.k.a()
        L_0x0255:
            java.lang.String r11 = r11.getString(r0, r5)
            java.lang.String r12 = "intent.extras!!.getStrin…nstant.OPERATOR_NAME, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            r7.al = r11
        L_0x0260:
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x027c
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x026f
            kotlin.g.b.k.a()
        L_0x026f:
            java.lang.String r11 = "product_variant"
            java.lang.String r0 = r0.getString(r11, r5)
            java.lang.String r11 = "intent.extras!!.getStrin…tant.PRODUCT_VARIANT, \"\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r7.am = r0
        L_0x027c:
            java.lang.String r0 = "recharge cart"
            boolean r0 = r3.hasExtra(r0)
            java.lang.String r11 = "mInitialCart?.cart?.cartItems!![0]"
            if (r0 == 0) goto L_0x0382
            java.lang.String r0 = "recharge cart"
            java.io.Serializable r0 = r3.getSerializableExtra(r0)
            boolean r12 = r0 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r12 != 0) goto L_0x0291
            r0 = 0
        L_0x0291:
            net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
            r7.A = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            r7.f62186c = r0
            if (r0 == 0) goto L_0x02a6
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x02a6
            net.one97.paytm.common.entity.shopping.CJRAddress r0 = r0.getAddress()
            goto L_0x02a7
        L_0x02a6:
            r0 = 0
        L_0x02a7:
            r7.B = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x02b8
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x02b8
            java.util.ArrayList r0 = r0.getCartItems()
            goto L_0x02b9
        L_0x02b8:
            r0 = 0
        L_0x02b9:
            if (r0 == 0) goto L_0x02ff
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x02ff
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x02ff
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x02ff
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x02ff
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x02fc
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x02fc
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x02fc
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x02fc
            java.util.Map r0 = r0.getConfigurationList()
            if (r0 == 0) goto L_0x02fc
            java.lang.String r12 = "recharge_number"
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x02fd
        L_0x02fc:
            r0 = r5
        L_0x02fd:
            r7.N = r0
        L_0x02ff:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r7.f62189g
            r0.clear()
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x037f
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x037f
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x037f
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x037f
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r7.f62189g     // Catch:{ all -> 0x0379 }
            net.one97.paytm.common.entity.CJRRechargeCart r12 = r7.A     // Catch:{ all -> 0x0379 }
            if (r12 == 0) goto L_0x032e
            net.one97.paytm.common.entity.shopping.CJRCart r12 = r12.getCart()     // Catch:{ all -> 0x0379 }
            if (r12 == 0) goto L_0x032e
            java.util.ArrayList r12 = r12.getCartItems()     // Catch:{ all -> 0x0379 }
            goto L_0x032f
        L_0x032e:
            r12 = 0
        L_0x032f:
            if (r12 != 0) goto L_0x0334
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0379 }
        L_0x0334:
            java.lang.Object r12 = r12.get(r6)     // Catch:{ all -> 0x0379 }
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)     // Catch:{ all -> 0x0379 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r12 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r12     // Catch:{ all -> 0x0379 }
            java.util.Map r12 = r12.getConfigurationList()     // Catch:{ all -> 0x0379 }
            r0.putAll(r12)     // Catch:{ all -> 0x0379 }
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A     // Catch:{ all -> 0x0379 }
            if (r0 == 0) goto L_0x0353
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()     // Catch:{ all -> 0x0379 }
            if (r0 == 0) goto L_0x0353
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ all -> 0x0379 }
            goto L_0x0354
        L_0x0353:
            r0 = 0
        L_0x0354:
            if (r0 != 0) goto L_0x0359
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0379 }
        L_0x0359:
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0379 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)     // Catch:{ all -> 0x0379 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ all -> 0x0379 }
            java.lang.Object r0 = r0.getMetaDataResponse()     // Catch:{ all -> 0x0379 }
            com.google.gson.f r12 = new com.google.gson.f     // Catch:{ all -> 0x0379 }
            r12.<init>()     // Catch:{ all -> 0x0379 }
            java.lang.String r0 = r12.b(r0)     // Catch:{ all -> 0x0379 }
            if (r0 == 0) goto L_0x037f
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x0379 }
            r12.<init>(r0)     // Catch:{ all -> 0x0379 }
            r7.D = r12     // Catch:{ all -> 0x0379 }
            goto L_0x037f
        L_0x0379:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r12.debugLogExceptions(r0)
        L_0x037f:
            r34.m()
        L_0x0382:
            java.lang.String r0 = com.paytm.utility.e.C
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x03b7
            java.lang.String r0 = com.paytm.utility.e.C
            boolean r0 = r3.getBooleanExtra(r0, r6)
            r7.aa = r0
            java.lang.String r0 = "meta_data"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x03b7
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x03a3
            kotlin.g.b.k.a()
        L_0x03a3:
            java.lang.String r12 = "meta_data"
            java.lang.String r0 = r0.getString(r12, r5)
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x03b1 }
            r12.<init>(r0)     // Catch:{ all -> 0x03b1 }
            r7.D = r12     // Catch:{ all -> 0x03b1 }
            goto L_0x03b7
        L_0x03b1:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r12.debugLogExceptions(r0)
        L_0x03b7:
            net.one97.paytm.recharge.di.helper.b r0 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x03d1 }
            r0 = r7
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x03d1 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d1 }
            r12.<init>(r9)     // Catch:{ all -> 0x03d1 }
            java.lang.String r13 = r7.V     // Catch:{ all -> 0x03d1 }
            r12.append(r13)     // Catch:{ all -> 0x03d1 }
            r12.append(r8)     // Catch:{ all -> 0x03d1 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x03d1 }
            net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r0, (java.lang.String) r12)     // Catch:{ all -> 0x03d1 }
            goto L_0x03d2
        L_0x03d1:
        L_0x03d2:
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x03e3
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x03e3
            java.lang.String r12 = r7.L
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = r0.getCartProduct(r12)
            goto L_0x03e4
        L_0x03e3:
            r0 = 0
        L_0x03e4:
            r7.C = r0
            java.lang.String r0 = r7.G
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x03f2
            r0 = 1
            goto L_0x03f3
        L_0x03f2:
            r0 = 0
        L_0x03f3:
            if (r0 == 0) goto L_0x0455
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x0455
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0455
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x0455
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x0455
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x0432
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0432
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x0432
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x0432
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r0 = r0.getmProductAttrubutes()
            if (r0 == 0) goto L_0x0432
            java.lang.String r0 = r0.getOperatorDisplayLabel()
            if (r0 != 0) goto L_0x0450
        L_0x0432:
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x044f
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x044f
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x044f
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x044f
            java.lang.String r0 = r0.getBrand()
            goto L_0x0450
        L_0x044f:
            r0 = 0
        L_0x0450:
            if (r0 != 0) goto L_0x0453
            r0 = r5
        L_0x0453:
            r7.G = r0
        L_0x0455:
            java.lang.String r0 = r7.I
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0461
            r0 = 1
            goto L_0x0462
        L_0x0461:
            r0 = 0
        L_0x0462:
            if (r0 == 0) goto L_0x0477
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x0474
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0474
            java.lang.String r0 = r0.getFinalPrice()
            if (r0 != 0) goto L_0x0475
        L_0x0474:
            r0 = r5
        L_0x0475:
            r7.I = r0
        L_0x0477:
            java.lang.String r0 = r7.H
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0483
            r0 = 1
            goto L_0x0484
        L_0x0483:
            r0 = 0
        L_0x0484:
            if (r0 == 0) goto L_0x048a
            java.lang.String r0 = r7.N
            r7.H = r0
        L_0x048a:
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r0 = net.one97.paytm.recharge.di.helper.c.U()
            r7.Y = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r13 = "(this as java.lang.String).toUpperCase()"
            if (r0 == 0) goto L_0x05cf
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x05cf
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x05cf
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x05f1 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x05f1 }
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x05cf
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x04be
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x04be
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ Exception -> 0x05f1 }
            goto L_0x04bf
        L_0x04be:
            r0 = 0
        L_0x04bf:
            if (r0 != 0) goto L_0x04c4
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x05f1 }
        L_0x04c4:
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x05f1 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r0 = r0.getCategoryIdForGTM()     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x052d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x05f1 }
            java.lang.String[] r14 = new java.lang.String[]{r9}     // Catch:{ Exception -> 0x05f1 }
            java.util.List r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.String[]) r14)     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x052d
            boolean r14 = r0.isEmpty()     // Catch:{ Exception -> 0x05f1 }
            if (r14 != 0) goto L_0x0512
            int r14 = r0.size()     // Catch:{ Exception -> 0x05f1 }
            java.util.ListIterator r14 = r0.listIterator(r14)     // Catch:{ Exception -> 0x05f1 }
        L_0x04ed:
            boolean r15 = r14.hasPrevious()     // Catch:{ Exception -> 0x05f1 }
            if (r15 == 0) goto L_0x0512
            java.lang.Object r15 = r14.previous()     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x05f1 }
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x05f1 }
            int r15 = r15.length()     // Catch:{ Exception -> 0x05f1 }
            if (r15 != 0) goto L_0x0503
            r15 = 1
            goto L_0x0504
        L_0x0503:
            r15 = 0
        L_0x0504:
            if (r15 != 0) goto L_0x04ed
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x05f1 }
            int r14 = r14.nextIndex()     // Catch:{ Exception -> 0x05f1 }
            int r14 = r14 + r4
            java.util.List r0 = kotlin.a.k.b(r0, (int) r14)     // Catch:{ Exception -> 0x05f1 }
            goto L_0x0516
        L_0x0512:
            kotlin.a.w r0 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x05f1 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x05f1 }
        L_0x0516:
            if (r0 == 0) goto L_0x052d
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x05f1 }
            java.lang.String[] r14 = new java.lang.String[r6]     // Catch:{ Exception -> 0x05f1 }
            java.lang.Object[] r0 = r0.toArray(r14)     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x0525
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ Exception -> 0x05f1 }
            goto L_0x052e
        L_0x0525:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r12)     // Catch:{ Exception -> 0x05f1 }
            throw r0     // Catch:{ Exception -> 0x05f1 }
        L_0x052d:
            r0 = 0
        L_0x052e:
            if (r0 == 0) goto L_0x054e
            int r14 = r0.length     // Catch:{ Exception -> 0x05f1 }
            r15 = 0
        L_0x0532:
            if (r15 >= r14) goto L_0x0547
            r16 = r0[r15]     // Catch:{ Exception -> 0x05f1 }
            r10 = r16
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r4 = "99932"
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x05f1 }
            if (r4 == 0) goto L_0x0543
            goto L_0x0549
        L_0x0543:
            int r15 = r15 + 1
            r4 = 1
            goto L_0x0532
        L_0x0547:
            r16 = 0
        L_0x0549:
            r10 = r16
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x05f1 }
            goto L_0x054f
        L_0x054e:
            r10 = 0
        L_0x054f:
            if (r10 != 0) goto L_0x057f
            java.lang.String r0 = r7.H     // Catch:{ Exception -> 0x05f1 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x05f1 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x055c
            goto L_0x057f
        L_0x055c:
            int r0 = net.one97.paytm.recharge.R.id.tvRechargeNumber     // Catch:{ Exception -> 0x05f1 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x05f1 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r4 = r7.H     // Catch:{ Exception -> 0x05f1 }
            if (r4 == 0) goto L_0x0579
            java.lang.String r4 = r4.toUpperCase()     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r13)     // Catch:{ Exception -> 0x05f1 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05f1 }
            r0.setText(r4)     // Catch:{ Exception -> 0x05f1 }
            goto L_0x0603
        L_0x0579:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x05f1 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x05f1 }
            throw r0     // Catch:{ Exception -> 0x05f1 }
        L_0x057f:
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x058e
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x058e
            java.util.ArrayList r10 = r0.getCartItems()     // Catch:{ Exception -> 0x05f1 }
            goto L_0x058f
        L_0x058e:
            r10 = 0
        L_0x058f:
            if (r10 != 0) goto L_0x0594
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x05f1 }
        L_0x0594:
            java.lang.Object r0 = r10.get(r6)     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x05f1 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r0 = r0.getTitle()     // Catch:{ Exception -> 0x05f1 }
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05f1 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05f1 }
            if (r4 != 0) goto L_0x0603
            java.lang.String r4 = "title"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x05f1 }
            if (r0 == 0) goto L_0x05c9
            java.lang.String r0 = r0.toUpperCase()     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)     // Catch:{ Exception -> 0x05f1 }
            int r4 = net.one97.paytm.recharge.R.id.tvRechargeNumber     // Catch:{ Exception -> 0x05f1 }
            android.view.View r4 = r7.a((int) r4)     // Catch:{ Exception -> 0x05f1 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)     // Catch:{ Exception -> 0x05f1 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x05f1 }
            r4.setText(r0)     // Catch:{ Exception -> 0x05f1 }
            goto L_0x0603
        L_0x05c9:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x05f1 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x05f1 }
            throw r0     // Catch:{ Exception -> 0x05f1 }
        L_0x05cf:
            int r0 = net.one97.paytm.recharge.R.id.tvRechargeNumber     // Catch:{ Exception -> 0x05f1 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x05f1 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x05f1 }
            java.lang.String r4 = r7.H     // Catch:{ Exception -> 0x05f1 }
            if (r4 == 0) goto L_0x05eb
            java.lang.String r4 = r4.toUpperCase()     // Catch:{ Exception -> 0x05f1 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r13)     // Catch:{ Exception -> 0x05f1 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05f1 }
            r0.setText(r4)     // Catch:{ Exception -> 0x05f1 }
            goto L_0x0603
        L_0x05eb:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x05f1 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x05f1 }
            throw r0     // Catch:{ Exception -> 0x05f1 }
        L_0x05f1:
            int r0 = net.one97.paytm.recharge.R.id.tvRechargeNumber
            android.view.View r0 = r7.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r2 = r7.H
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0603:
            int r0 = net.one97.paytm.recharge.R.id.tvRechargeDetails
            android.view.View r0 = r7.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tvRechargeDetails"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r2 = r7.G
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            int r0 = net.one97.paytm.recharge.R.id.tvRechargeAmount
            android.view.View r0 = r7.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tvRechargeAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "₹"
            r2.<init>(r4)
            java.lang.String r4 = r7.I
            r10 = 1
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r4, (boolean) r10)
            r2.append(r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            r34.i()
            net.one97.paytm.recharge.common.h.d r0 = new net.one97.paytm.recharge.common.h.d
            net.one97.paytm.recharge.common.h.d$a r2 = new net.one97.paytm.recharge.common.h.d$a
            net.one97.paytm.recharge.common.h.d$b r4 = net.one97.paytm.recharge.common.h.d.b.COUPONS
            r2.<init>(r4)
            android.content.Context r4 = r34.getApplicationContext()
            java.lang.String r10 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            net.one97.paytm.recharge.coupons.b r4 = net.one97.paytm.recharge.common.b.d.e(r4)
            net.one97.paytm.recharge.common.b.c r4 = (net.one97.paytm.recharge.common.b.c) r4
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.common.b.c) r4)
            java.lang.String r4 = r7.H
            java.lang.String r10 = "_productMasterNumber"
            kotlin.g.b.k.c(r4, r10)
            r2.f61433f = r4
            java.lang.String r4 = r7.I
            java.lang.String r10 = "_rechargeMasterPrice"
            kotlin.g.b.k.c(r4, r10)
            r2.f61434g = r4
            net.one97.paytm.common.entity.shopping.CJRCartProduct r4 = r7.C
            r2.f61435h = r4
            java.lang.String r4 = r7.L
            java.lang.String r10 = "_productMasterId"
            kotlin.g.b.k.c(r4, r10)
            r2.f61436i = r4
            r4 = r7
            android.content.Context r4 = (android.content.Context) r4
            net.one97.paytm.recharge.common.utils.w r10 = net.one97.paytm.recharge.common.b.d.d(r4)
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.common.utils.w) r10)
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$s r10 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$s
            r12 = r7
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r12 = (net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8) r12
            r10.<init>(r12)
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((kotlin.k.e<kotlin.x>) r10)
            net.one97.paytm.recharge.ordersummary.h.d r10 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r12 = r34.getApplicationContext()
            java.lang.String r13 = "this.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r10.<init>(r12)
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.ordersummary.h.d) r10)
            r0.<init>(r2)
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.recharge.coupons.e.a> r2 = net.one97.paytm.recharge.coupons.e.a.class
            androidx.lifecycle.ai r0 = r0.a(r2)
            java.lang.String r2 = "ViewModelProviders.of(th…elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.recharge.coupons.e.a r0 = (net.one97.paytm.recharge.coupons.e.a) r0
            r7.f62185b = r0
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x06c0
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPersonalInsurance> r10 = r0.f62280a
            goto L_0x06c1
        L_0x06c0:
            r10 = 0
        L_0x06c1:
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$t r0 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$t
            r0.<init>(r7)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r7, r10, r0)
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x06d4
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRCouponHeader> r10 = r0.f62281b
            goto L_0x06d5
        L_0x06d4:
            r10 = 0
        L_0x06d5:
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$u r0 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$u
            r0.<init>(r7)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r7, r10, r0)
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x06e8
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRCouponGrid> r10 = r0.f62282c
            goto L_0x06e9
        L_0x06e8:
            r10 = 0
        L_0x06e9:
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$v r0 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$v
            r0.<init>(r7)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r7, r10, r0)
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x06fc
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r10 = r0.f62286g
            goto L_0x06fd
        L_0x06fc:
            r10 = 0
        L_0x06fd:
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$w r0 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$w
            r0.<init>(r7)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r7, r10, r0)
            boolean r0 = r7.W     // Catch:{ Exception -> 0x079e }
            if (r0 == 0) goto L_0x079b
            java.lang.String r0 = r7.K     // Catch:{ Exception -> 0x079e }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x079e }
            int r0 = r0.length()     // Catch:{ Exception -> 0x079e }
            if (r0 <= 0) goto L_0x0719
            r0 = 1
            goto L_0x071a
        L_0x0719:
            r0 = 0
        L_0x071a:
            if (r0 == 0) goto L_0x079b
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x079e }
            r2 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)     // Catch:{ Exception -> 0x079e }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x079e }
            r0.setErrorType(r2)     // Catch:{ Exception -> 0x079e }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()     // Catch:{ Exception -> 0x079e }
            if (r2 == 0) goto L_0x0737
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r10 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x079e }
            java.lang.String r10 = r10.name()     // Catch:{ Exception -> 0x079e }
            r2.setErrorType(r10)     // Catch:{ Exception -> 0x079e }
        L_0x0737:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()     // Catch:{ Exception -> 0x079e }
            if (r2 == 0) goto L_0x0746
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r10 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_INSURANCE_POLICY_AUTO     // Catch:{ Exception -> 0x079e }
            java.lang.String r10 = r10.name()     // Catch:{ Exception -> 0x079e }
            r2.setActionType(r10)     // Catch:{ Exception -> 0x079e }
        L_0x0746:
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r7.A     // Catch:{ Exception -> 0x079e }
            if (r2 == 0) goto L_0x0793
            net.one97.paytm.recharge.coupons.e.a r2 = r7.f62185b     // Catch:{ Exception -> 0x079e }
            if (r2 == 0) goto L_0x079b
            java.lang.String r10 = "fetch_insurance_data"
            java.lang.String r12 = r7.K     // Catch:{ Exception -> 0x079e }
            net.one97.paytm.common.entity.CJRRechargeCart r13 = r7.A     // Catch:{ Exception -> 0x079e }
            if (r13 != 0) goto L_0x0759
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x079e }
        L_0x0759:
            kotlin.g.b.k.c(r10, r1)     // Catch:{ Exception -> 0x079e }
            java.lang.String r14 = "url"
            kotlin.g.b.k.c(r12, r14)     // Catch:{ Exception -> 0x079e }
            java.lang.String r14 = "initialCart"
            kotlin.g.b.k.c(r13, r14)     // Catch:{ Exception -> 0x079e }
            net.one97.paytm.recharge.coupons.b r14 = r2.f62287h     // Catch:{ Exception -> 0x079e }
            r20 = r2
            net.one97.paytm.recharge.common.e.ai r20 = (net.one97.paytm.recharge.common.e.ai) r20     // Catch:{ Exception -> 0x079e }
            java.lang.String r15 = r2.j     // Catch:{ Exception -> 0x079e }
            java.lang.String r6 = r2.m     // Catch:{ Exception -> 0x079e }
            r33 = r8
            java.lang.String r8 = r2.k     // Catch:{ Exception -> 0x0799 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = r2.l     // Catch:{ Exception -> 0x0799 }
            if (r2 != 0) goto L_0x077b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0799 }
        L_0x077b:
            r18 = r14
            r19 = r10
            r21 = r12
            r22 = r15
            r23 = r13
            r24 = r6
            r25 = r8
            r26 = r2
            r27 = r0
            r18.a(r19, r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x0799 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0799 }
            goto L_0x07ad
        L_0x0793:
            r33 = r8
            r34.finish()     // Catch:{ Exception -> 0x0799 }
            goto L_0x07ad
        L_0x0799:
            r0 = move-exception
            goto L_0x07a1
        L_0x079b:
            r33 = r8
            goto L_0x07ad
        L_0x079e:
            r0 = move-exception
            r33 = r8
        L_0x07a1:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x07aa
            r0 = r5
        L_0x07aa:
            r2.debugLog(r0)
        L_0x07ad:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r2 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r0.setErrorType(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x07c8
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r2.setErrorType(r6)
        L_0x07c8:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x07d7
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_DEAL_HEADER
            java.lang.String r6 = r6.name()
            r2.setActionType(r6)
        L_0x07d7:
            net.one97.paytm.recharge.coupons.e.a r2 = r7.f62185b
            if (r2 == 0) goto L_0x07f9
            java.lang.String r6 = "fetch_coupon_header"
            kotlin.g.b.k.c(r6, r1)
            net.one97.paytm.recharge.coupons.b r8 = r2.f62287h
            r20 = r2
            net.one97.paytm.recharge.common.e.ai r20 = (net.one97.paytm.recharge.common.e.ai) r20
            java.lang.String r10 = r2.n
            java.lang.String r2 = r2.o
            r18 = r8
            r19 = r6
            r21 = r10
            r22 = r2
            r23 = r0
            r18.a(r19, r20, r21, r22, r23)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x07f9:
            net.one97.paytm.recharge.common.c.c$d r0 = r7.q
            if (r0 == 0) goto L_0x080b
            int r2 = net.one97.paytm.recharge.R.string.apply_promo_code
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r6 = "getString(R.string.apply_promo_code)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r0.a((java.lang.String) r2)
        L_0x080b:
            net.one97.paytm.recharge.common.c.c$d r0 = r7.q
            if (r0 == 0) goto L_0x0815
            r2 = r7
            net.one97.paytm.recharge.common.c.c$b r2 = (net.one97.paytm.recharge.common.c.c.b) r2
            r0.a((net.one97.paytm.recharge.common.c.c.b) r2)
        L_0x0815:
            net.one97.paytm.recharge.common.c.c r0 = new net.one97.paytm.recharge.common.c.c
            net.one97.paytm.recharge.common.c.c$d r2 = r7.q
            r0.<init>(r2)
            r7.ag = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.f62186c
            if (r0 != 0) goto L_0x0825
            r34.finish()
        L_0x0825:
            java.lang.String r0 = r7.ap
            java.lang.String r2 = r7.aq
            if (r2 != 0) goto L_0x082e
            r21 = r5
            goto L_0x0830
        L_0x082e:
            r21 = r2
        L_0x0830:
            net.one97.paytm.recharge.coupons.e.a r2 = r7.f62185b
            if (r2 == 0) goto L_0x083e
            java.lang.String r2 = net.one97.paytm.recharge.coupons.e.a.a()
            if (r2 != 0) goto L_0x083b
            goto L_0x083e
        L_0x083b:
            r22 = r2
            goto L_0x0840
        L_0x083e:
            r22 = r5
        L_0x0840:
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r7.f62186c
            if (r2 != 0) goto L_0x0847
            kotlin.g.b.k.a()
        L_0x0847:
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
            if (r2 == 0) goto L_0x0858
            java.lang.String r2 = r2.getFinalPrice()
            if (r2 == 0) goto L_0x0858
            double r12 = java.lang.Double.parseDouble(r2)
            goto L_0x085a
        L_0x0858:
            r12 = 0
        L_0x085a:
            r23 = r12
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r7.f62186c
            if (r2 != 0) goto L_0x0863
            kotlin.g.b.k.a()
        L_0x0863:
            java.lang.String r6 = r7.S
            net.one97.paytm.common.entity.shopping.CJRDetailProduct r8 = r7.t
            boolean r10 = r7.an
            java.lang.String r12 = r7.T
            java.lang.String r13 = r7.K
            r31 = r7
            net.one97.paytm.recharge.common.e.u r31 = (net.one97.paytm.recharge.common.e.u) r31
            java.lang.String r14 = r7.V
            net.one97.paytm.recharge.common.utils.o r15 = new net.one97.paytm.recharge.common.utils.o
            r18 = r15
            r19 = r4
            r20 = r0
            r25 = r2
            r26 = r6
            r27 = r8
            r28 = r10
            r29 = r12
            r30 = r13
            r32 = r14
            r18.<init>(r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)
            r7.ao = r15
            net.one97.paytm.recharge.common.utils.o r0 = r7.ao
            if (r0 == 0) goto L_0x0897
            net.one97.paytm.common.entity.recharge.CJRSelectedRecharge r2 = r7.E
            r0.a((net.one97.paytm.common.entity.recharge.CJRSelectedRecharge) r2)
        L_0x0897:
            net.one97.paytm.recharge.common.utils.o r0 = r7.ao
            if (r0 == 0) goto L_0x08a0
            java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRSelectedRecharge> r2 = r7.f62190h
            r0.a((java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRSelectedRecharge>) r2)
        L_0x08a0:
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.o r0 = r7.ao
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.common.utils.o) r0)
            net.one97.paytm.recharge.common.utils.o r0 = r7.ao
            if (r0 == 0) goto L_0x09e5
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x09e5
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x08f3
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x08f3
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x08f3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x08f3
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r7.A
            if (r0 == 0) goto L_0x08da
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x08da
            java.util.ArrayList r10 = r0.getCartItems()
            goto L_0x08db
        L_0x08da:
            r10 = 0
        L_0x08db:
            if (r10 != 0) goto L_0x08e0
            kotlin.g.b.k.a()
        L_0x08e0:
            r2 = 0
            java.lang.Object r0 = r10.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.lang.String r0 = r0.getOffersUrl()
            if (r0 != 0) goto L_0x08f1
            goto L_0x08f3
        L_0x08f1:
            r2 = r0
            goto L_0x08f4
        L_0x08f3:
            r2 = r5
        L_0x08f4:
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0912 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0912 }
            if (r0 != 0) goto L_0x0918
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ all -> 0x0912 }
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.V()     // Catch:{ all -> 0x0912 }
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0912 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0912 }
            if (r6 != 0) goto L_0x0918
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x0912 }
            r2 = r0
            goto L_0x0918
        L_0x0912:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r6 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r6.debugLogExceptions(r0)
        L_0x0918:
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x094b
            java.lang.String r0 = r7.R
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x094b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.v()
            r0.append(r2)
            java.lang.String r2 = r7.R
            r0.append(r2)
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.w()
            r0.append(r2)
            java.lang.String r2 = r0.toString()
        L_0x094b:
            boolean r0 = android.webkit.URLUtil.isValidUrl(r2)
            if (r0 == 0) goto L_0x099f
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r6 = "?"
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r8, false)
            if (r0 == 0) goto L_0x098b
            r8 = 0
            java.lang.String r0 = com.paytm.utility.c.a((android.content.Context) r4, (boolean) r8)
            java.lang.String r4 = "defaultParam"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r10 = r6
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r10, false)
            if (r4 == 0) goto L_0x097b
            java.lang.String r4 = "&"
            java.lang.String r0 = kotlin.m.p.a(r0, r6, r4, r8)
        L_0x097b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r0)
            java.lang.String r2 = r4.toString()
            goto L_0x099f
        L_0x098b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r2 = 0
            java.lang.String r2 = com.paytm.utility.c.a((android.content.Context) r4, (boolean) r2)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
        L_0x099f:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r4 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r4)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r0.setErrorType(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r0.getFlowName()
            if (r4 == 0) goto L_0x09ba
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r4.setErrorType(r6)
        L_0x09ba:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r0.getFlowName()
            if (r4 == 0) goto L_0x09c9
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_PROMOS
            java.lang.String r6 = r6.name()
            r4.setActionType(r6)
        L_0x09c9:
            net.one97.paytm.recharge.coupons.e.a r4 = r7.f62185b
            if (r4 == 0) goto L_0x09e2
            java.lang.String r6 = "fetch_promo"
            kotlin.g.b.k.c(r6, r1)
            java.lang.String r1 = "url"
            kotlin.g.b.k.c(r2, r1)
            net.one97.paytm.recharge.coupons.b r1 = r4.f62287h
            r8 = r4
            net.one97.paytm.recharge.common.e.ai r8 = (net.one97.paytm.recharge.common.e.ai) r8
            r1.a((java.lang.String) r6, (net.one97.paytm.recharge.common.e.ai) r8, (java.lang.String) r2, (java.lang.Object) r0)
            androidx.lifecycle.y<net.one97.paytm.common.entity.shopping.CJROffers> r10 = r4.f62283d
            goto L_0x09e3
        L_0x09e2:
            r10 = 0
        L_0x09e3:
            r7.p = r10
        L_0x09e5:
            java.lang.String r0 = "intent_promo_code "
            boolean r0 = r3.hasExtra(r0)     // Catch:{ Exception -> 0x0a5c }
            if (r0 == 0) goto L_0x0031
            android.os.Bundle r0 = r3.getExtras()     // Catch:{ Exception -> 0x0a5c }
            if (r0 != 0) goto L_0x09f6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0a5c }
        L_0x09f6:
            java.lang.String r1 = "intent_promo_code "
            java.lang.String r0 = r0.getString(r1, r5)     // Catch:{ Exception -> 0x0a5c }
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0a5c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0a5c }
            if (r1 != 0) goto L_0x0031
            r1 = 1
            r7.ac = r1     // Catch:{ Exception -> 0x0a5c }
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x0a5c }
            r8 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)     // Catch:{ Exception -> 0x0a5a }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()     // Catch:{ Exception -> 0x0a5a }
            if (r1 == 0) goto L_0x0a1e
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x0a5a }
            java.lang.String r2 = r2.name()     // Catch:{ Exception -> 0x0a5a }
            r1.setErrorType(r2)     // Catch:{ Exception -> 0x0a5a }
        L_0x0a1e:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()     // Catch:{ Exception -> 0x0a5a }
            if (r1 == 0) goto L_0x0a2d
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROMO_VERIFY     // Catch:{ Exception -> 0x0a5a }
            java.lang.String r2 = r2.name()     // Catch:{ Exception -> 0x0a5a }
            r1.setActionType(r2)     // Catch:{ Exception -> 0x0a5a }
        L_0x0a2d:
            net.one97.paytm.recharge.coupons.e.a r11 = r7.f62185b     // Catch:{ Exception -> 0x0a5a }
            if (r11 == 0) goto L_0x0a49
            java.lang.String r12 = "fetch_promo_verify"
            java.lang.String r1 = "promo"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0a5a }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 30
            r1 = r34
            r2 = r0
            org.json.JSONObject r1 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0a5a }
            androidx.lifecycle.y r10 = r11.a((java.lang.String) r12, (org.json.JSONObject) r1, (net.one97.paytm.recharge.common.e.ai) null, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0a5a }
            goto L_0x0a4a
        L_0x0a49:
            r10 = r8
        L_0x0a4a:
            if (r10 == 0) goto L_0x0a65
            r1 = r7
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1     // Catch:{ Exception -> 0x0a5a }
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ah r2 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ah     // Catch:{ Exception -> 0x0a5a }
            r2.<init>(r7, r10, r0)     // Catch:{ Exception -> 0x0a5a }
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2     // Catch:{ Exception -> 0x0a5a }
            r10.observe(r1, r2)     // Catch:{ Exception -> 0x0a5a }
            goto L_0x0a65
        L_0x0a5a:
            r0 = move-exception
            goto L_0x0a5e
        L_0x0a5c:
            r0 = move-exception
            r8 = 0
        L_0x0a5e:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x0a65:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.b()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            java.lang.String r2 = r7.V
            r1.append(r2)
            r2 = r33
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setScreenName(r1)
            int r0 = net.one97.paytm.recharge.R.id.dealsToolbar
            android.view.View r0 = r7.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ac r1 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ac
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setNavigationOnClickListener(r1)
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x0aaa
            net.one97.paytm.recharge.ordersummary.h.d r9 = r0.p
            if (r9 == 0) goto L_0x0aaa
            java.lang.String r10 = r7.V
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 124(0x7c, float:1.74E-43)
            java.lang.String r11 = "coupon_screen_loaded"
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x0aaa:
            net.one97.paytm.recharge.coupons.e.a r0 = r7.f62185b
            if (r0 == 0) goto L_0x0ab1
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPromoCodeTerms> r10 = r0.f62285f
            r8 = r10
        L_0x0ab1:
            if (r8 != 0) goto L_0x0ab6
            kotlin.g.b.k.a()
        L_0x0ab6:
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ad r0 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ad
            r0.<init>(r7)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.ai.a(r7, r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.onCreate(android.os.Bundle):void");
    }

    static final class ac implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62202a;

        ac(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62202a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            this.f62202a.onBackPressed();
        }
    }

    public final void a(CJRInstruct cJRInstruct) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        String str = null;
        if (cJRInstruct instanceof CJRInstruct.showAlertDialog) {
            CJRInstruct.showAlertDialog showalertdialog = (CJRInstruct.showAlertDialog) cJRInstruct;
            String title = showalertdialog.getTitle();
            String message = showalertdialog.getMessage();
            Object hawkEyeEvent = showalertdialog.getHawkEyeEvent();
            if (kotlin.g.b.k.a((Object) getString(R.string.unable_to_proceed), (Object) title) && !TextUtils.isEmpty(message)) {
                title = "utility_hide_title";
            }
            String str2 = title;
            if (!isFinishing()) {
                if (hawkEyeEvent instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) hawkEyeEvent;
                    ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                    CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                    if (flowName != null) {
                        str = flowName.getActionType();
                    }
                    cJRRechargeErrorModel = cJRRechargeErrorModel2;
                    action_type = companion.getActionType(str, ACTION_TYPE.DEAL_PROCEED);
                } else {
                    action_type = null;
                    cJRRechargeErrorModel = null;
                }
                az azVar = az.f61525a;
                Context context = this;
                if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                    error_type = ERROR_TYPE.UNDEFINED;
                }
                az.a(context, error_type, action_type, str2, message, false, cJRRechargeErrorModel, false, 1504);
            }
            h();
        } else if (cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity) {
            CJRInstruct.openRechargePaymentActivity openrechargepaymentactivity = (CJRInstruct.openRechargePaymentActivity) cJRInstruct;
            CJRRechargeCart rechargeCart = openrechargepaymentactivity.getRechargeCart();
            if (rechargeCart == null) {
                rechargeCart = new CJRRechargeCart();
            }
            this.f62186c = rechargeCart;
            net.one97.paytm.recharge.common.utils.o oVar = this.ao;
            if (oVar == null || !oVar.e()) {
                try {
                    net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                    Activity activity = this;
                    String str3 = this.aq;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = str3;
                    CJRRechargeCart rechargeCart2 = ((CJRInstruct.openRechargePaymentActivity) cJRInstruct).getRechargeCart();
                    CJRRechargePayment rechargePayment = ((CJRInstruct.openRechargePaymentActivity) cJRInstruct).getRechargePayment();
                    CJRRechargeCart rechargeCart3 = ((CJRInstruct.openRechargePaymentActivity) cJRInstruct).getRechargeCart();
                    if (rechargeCart3 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.c(rechargeCart3, "rechargeCart");
                    net.one97.paytm.recharge.common.utils.a.a(activity, str4, rechargeCart2, rechargePayment, (Map<String, ? extends Object>) null, (Class<?>) null, ((CJRInstruct.openRechargePaymentActivity) cJRInstruct).getHawkEyeEvent(), false);
                    new Handler().postDelayed(new af(this), 1500);
                } catch (Exception e2) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a2.setErrorMsg("Unable to open PG page");
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setErrorType(ERROR_TYPE.UI_DISTORT.name());
                    }
                    CRUFlowModel flowName3 = a2.getFlowName();
                    if (flowName3 != null) {
                        flowName3.setActionType(ACTION_TYPE.DEAL_PROCEED.name());
                    }
                    az azVar2 = az.f61525a;
                    az.a(a2, (Throwable) e2);
                }
            } else {
                net.one97.paytm.recharge.common.utils.o oVar2 = this.ao;
                if (oVar2 != null) {
                    CJRRechargeCart cJRRechargeCart = this.f62186c;
                    if (cJRRechargeCart == null) {
                        kotlin.g.b.k.a();
                    }
                    oVar2.a(cJRRechargeCart, openrechargepaymentactivity.getRechargePayment());
                }
                CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) a(R.id.proceed);
                if (cJRProceedWidgetWithConvFeeV8 != null) {
                    cJRProceedWidgetWithConvFeeV8.postDelayed(new ae(this), 200);
                }
            }
        } else if (cJRInstruct instanceof CJRInstruct.openPostOrderSummaryActivity) {
            net.one97.paytm.recharge.common.utils.a aVar2 = net.one97.paytm.recharge.common.utils.a.f61493a;
            Activity activity2 = this;
            CJRRechargePayment cJRRechargePayment = this.s;
            CJRRechargeCart cJRRechargeCart2 = this.f62186c;
            if (cJRRechargeCart2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(cJRRechargeCart2, "rechargeCart");
            net.one97.paytm.recharge.common.utils.a.a(activity2, cJRRechargePayment, cJRRechargeCart2, (Map<String, ? extends Object>) null, ((CJRInstruct.openPostOrderSummaryActivity) cJRInstruct).getHawkEyeEvent());
            finish();
            h();
        } else if (cJRInstruct instanceof CJRInstruct.saveRechargeCart) {
            CJRRechargeCart rechargeCart4 = ((CJRInstruct.saveRechargeCart) cJRInstruct).getRechargeCart();
            if (rechargeCart4 == null) {
                rechargeCart4 = new CJRRechargeCart();
            }
            this.f62186c = rechargeCart4;
        } else if (cJRInstruct instanceof CJRInstruct.saveRechargePayment) {
            this.s = ((CJRInstruct.saveRechargePayment) cJRInstruct).getRechargePayment();
        } else if (cJRInstruct instanceof CJRInstruct.onContainsError) {
            c();
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_insurance);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.b();
                }
            } catch (Exception unused) {
            }
            net.one97.paytm.recharge.common.c.c cVar = this.ag;
            if (cVar != null) {
                if (cVar.f60961a) {
                    cVar.b();
                }
                cVar.a(8);
            }
            CheckBox checkBox = (CheckBox) a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
            checkBox.setEnabled(true);
            CheckBox checkBox2 = (CheckBox) a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
            checkBox2.setClickable(true);
        }
    }

    static final class ae implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62203a;

        ae(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62203a = aJRCouponsActivityV8;
        }

        public final void run() {
            this.f62203a.h();
            CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62203a.a(R.id.proceed);
            kotlin.g.b.k.a((Object) cJRProceedWidgetWithConvFeeV8, "proceed");
            cJRProceedWidgetWithConvFeeV8.setEnabled(true);
        }
    }

    static final class af implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62204a;

        af(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62204a = aJRCouponsActivityV8;
        }

        public final void run() {
            CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62204a.a(R.id.proceed);
            kotlin.g.b.k.a((Object) cJRProceedWidgetWithConvFeeV8, "proceed");
            cJRProceedWidgetWithConvFeeV8.setEnabled(true);
            this.f62204a.h();
        }
    }

    public static final class ak extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62212a;

        ak(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62212a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "textView");
            if (this.f62212a.ah != null) {
                net.one97.paytm.recharge.common.c.d j = this.f62212a.ah;
                if (j == null) {
                    kotlin.g.b.k.a();
                }
                if (j.getFragmentManager() == null) {
                    net.one97.paytm.recharge.common.c.d j2 = this.f62212a.ah;
                    if (j2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!j2.isAdded()) {
                        CheckBox checkBox = (CheckBox) this.f62212a.a(R.id.insuranceCheckbox);
                        kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
                        if (checkBox.isEnabled()) {
                            net.one97.paytm.recharge.common.c.d j3 = this.f62212a.ah;
                            if (j3 == null) {
                                kotlin.g.b.k.a();
                            }
                            androidx.fragment.app.j supportFragmentManager = this.f62212a.getSupportFragmentManager();
                            b bVar = AJRCouponsActivityV8.f62183e;
                            j3.show(supportFragmentManager, AJRCouponsActivityV8.au);
                        }
                    }
                }
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f62212a.getResources().getColor(R.color.paytm_blue));
        }
    }

    public static final class aj extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62211a;

        aj(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62211a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "textView");
            CheckBox checkBox = (CheckBox) this.f62211a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
            CheckBox checkBox2 = (CheckBox) this.f62211a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
            checkBox.setChecked(!checkBox2.isChecked());
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f62211a.getResources().getColor(R.color.color_999999));
        }
    }

    public final void a(Toolbar toolbar) {
        super.a(toolbar);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            kotlin.g.b.k.a((Object) window, "window");
            window.setStatusBarColor(androidx.core.content.b.c(this, R.color.color_f3f7f8));
        }
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) a(R.id.dealsCollapsingToolbar);
        kotlin.g.b.k.a((Object) collapsingToolbarLayout, "dealsCollapsingToolbar");
        collapsingToolbarLayout.setTitle("  ");
        this.v = new GestureDetector(this, this.at);
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                kotlin.g.b.k.a();
            }
            supportActionBar.b(true);
        }
        l();
        ((ImageView) a(R.id.expandMenu)).setOnClickListener(new k(this));
        ((TextView) a(R.id.havePromoText)).setOnClickListener(new l(this));
        ((RelativeLayout) a(R.id.insuranceLayout)).setOnClickListener(new m(this));
        ((CheckBox) a(R.id.insuranceCheckbox)).setOnCheckedChangeListener(new n(this));
        ((ImageView) a(R.id.removePromo)).setOnClickListener(new o(this));
        ((TextView) a(R.id.tvInsuranceSelectedText)).setOnClickListener(new p(this));
        ((TextView) a(R.id.tvInsuranceSelectedTermsText)).setOnClickListener(new q(this));
        ((CJRProceedWidgetWithConvFeeV8) a(R.id.proceed)).setOnClickListener(new r(this));
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62241a;

        k(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62241a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            if (this.f62241a.u) {
                this.f62241a.u = false;
                CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = (CJRDealSelectWidgetV8) this.f62241a.a(R.id.widgetSelectDeal);
                if (cJRDealSelectWidgetV8.f62300f && cJRDealSelectWidgetV8.f62297c.size() > 0) {
                    cJRDealSelectWidgetV8.f62296b.clear();
                    cJRDealSelectWidgetV8.f62296b.add(new CJRGridProduct());
                    cJRDealSelectWidgetV8.a();
                    cJRDealSelectWidgetV8.b();
                    ((RelativeLayout) cJRDealSelectWidgetV8.a(R.id.expandedLL)).removeAllViews();
                    int size = cJRDealSelectWidgetV8.f62297c.size() - 1;
                    if (size >= 0) {
                        for (int i2 = 0; i2 < cJRDealSelectWidgetV8.f62299e; i2++) {
                            CJRGridProduct cJRGridProduct = cJRDealSelectWidgetV8.f62297c.get(i2);
                            kotlin.g.b.k.a((Object) cJRGridProduct, "masterDataListDealsModel.get(i)");
                            String imageUrl = cJRGridProduct.getImageUrl();
                            kotlin.g.b.k.a((Object) imageUrl, "masterDataListDealsModel.get(i).imageUrl");
                            ((RelativeLayout) cJRDealSelectWidgetV8.a(R.id.expandedLL)).addView(cJRDealSelectWidgetV8.a(imageUrl, i2));
                            if (i2 == size) {
                                break;
                            }
                        }
                    }
                    cJRDealSelectWidgetV8.f62298d.notifyDataSetChanged();
                    cJRDealSelectWidgetV8.b();
                    cJRDealSelectWidgetV8.f62300f = false;
                }
                AJRCouponsActivityV8.v(this.f62241a);
                return;
            }
            this.f62241a.u = true;
            CJRDealSelectWidgetV8 cJRDealSelectWidgetV82 = (CJRDealSelectWidgetV8) this.f62241a.a(R.id.widgetSelectDeal);
            if (!cJRDealSelectWidgetV82.f62300f && cJRDealSelectWidgetV82.f62297c.size() > 0) {
                cJRDealSelectWidgetV82.f62296b.clear();
                cJRDealSelectWidgetV82.f62296b.addAll(cJRDealSelectWidgetV82.f62297c);
                cJRDealSelectWidgetV82.a();
                cJRDealSelectWidgetV82.b();
                ((RelativeLayout) cJRDealSelectWidgetV82.a(R.id.expandedLL)).removeAllViews();
                int size2 = cJRDealSelectWidgetV82.f62297c.size() - 1;
                if (size2 >= 0) {
                    for (int i3 = 0; i3 < cJRDealSelectWidgetV82.f62299e; i3++) {
                        CJRGridProduct cJRGridProduct2 = cJRDealSelectWidgetV82.f62297c.get(i3);
                        kotlin.g.b.k.a((Object) cJRGridProduct2, "masterDataListDealsModel.get(i)");
                        String imageUrl2 = cJRGridProduct2.getImageUrl();
                        kotlin.g.b.k.a((Object) imageUrl2, "masterDataListDealsModel.get(i).imageUrl");
                        ((RelativeLayout) cJRDealSelectWidgetV82.a(R.id.expandedLL)).addView(cJRDealSelectWidgetV82.a(imageUrl2, i3));
                        if (i3 == size2) {
                            break;
                        }
                    }
                }
                cJRDealSelectWidgetV82.f62298d.notifyDataSetChanged();
                cJRDealSelectWidgetV82.b();
                cJRDealSelectWidgetV82.f62300f = true;
            }
            AJRCouponsActivityV8.w(this.f62241a);
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62242a;

        l(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62242a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.coupons.e.a b2 = this.f62242a.f62185b;
            if (!(b2 == null || (dVar = b2.p) == null)) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.f62242a.V, "promocode_field_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view)) {
                AJRCouponsActivityV8.x(this.f62242a);
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62243a;

        m(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62243a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            CheckBox checkBox = (CheckBox) this.f62243a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
            CheckBox checkBox2 = (CheckBox) this.f62243a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
            checkBox.setChecked(!checkBox2.isChecked());
        }
    }

    static final class n implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62244a;

        n(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62244a = aJRCouponsActivityV8;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (com.paytm.utility.b.c((Context) this.f62244a)) {
                androidx.lifecycle.y yVar = null;
                if (z) {
                    if (this.f62244a.F != null) {
                        ArrayList y = this.f62244a.j;
                        CJRPersonalInsurance i2 = this.f62244a.F;
                        String productID = i2 != null ? i2.getProductID() : null;
                        if (productID == null) {
                            kotlin.g.b.k.a();
                        }
                        y.add(productID);
                        net.one97.paytm.recharge.common.utils.o a2 = this.f62244a.ao;
                        if (a2 != null) {
                            a2.b((ArrayList<String>) this.f62244a.j);
                        }
                    }
                    try {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f62244a.a(R.id.shimmer_insurance);
                        if (shimmerFrameLayout != null) {
                            shimmerFrameLayout.a();
                        }
                    } catch (Exception unused) {
                    }
                    CheckBox checkBox = (CheckBox) this.f62244a.a(R.id.insuranceCheckbox);
                    kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
                    checkBox.setClickable(false);
                    CheckBox checkBox2 = (CheckBox) this.f62244a.a(R.id.insuranceCheckbox);
                    kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
                    checkBox2.setEnabled(false);
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    ay ayVar = ay.f61523a;
                    ay.a(ERROR_TYPE.INLINE_ERROR, ACTION_TYPE.INSURANCE_VERIFY, a3);
                    CJRPersonalInsurance i3 = this.f62244a.F;
                    a3.setProductId(i3 != null ? i3.getProductID() : null);
                    net.one97.paytm.recharge.coupons.e.a b2 = this.f62244a.f62185b;
                    if (b2 != null) {
                        AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62244a;
                        yVar = b2.a("insurance_verify", AJRCouponsActivityV8.a(aJRCouponsActivityV8, aJRCouponsActivityV8.U, "", true, false, 16), (net.one97.paytm.recharge.common.e.ai) null, (Object) a3);
                    }
                    if (yVar != null) {
                        AJRCouponsActivityV8 aJRCouponsActivityV82 = this.f62244a;
                        yVar.observe(aJRCouponsActivityV82, new d(aJRCouponsActivityV82, yVar, z));
                        return;
                    }
                    return;
                }
                ArrayList y2 = this.f62244a.j;
                CJRPersonalInsurance i4 = this.f62244a.F;
                String productID2 = i4 != null ? i4.getProductID() : null;
                if (productID2 == null) {
                    kotlin.g.b.k.a();
                }
                y2.remove(productID2);
                net.one97.paytm.recharge.common.utils.o a4 = this.f62244a.ao;
                if (a4 != null) {
                    a4.b((ArrayList<String>) this.f62244a.j);
                }
                try {
                    ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.f62244a.a(R.id.shimmer_insurance);
                    if (shimmerFrameLayout2 != null) {
                        shimmerFrameLayout2.a();
                    }
                } catch (Exception unused2) {
                }
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a5 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                ay ayVar2 = ay.f61523a;
                ay.a(ERROR_TYPE.INLINE_ERROR, ACTION_TYPE.INSURANCE_REMOVE, a5);
                CJRPersonalInsurance i5 = this.f62244a.F;
                a5.setProductId(i5 != null ? i5.getProductID() : null);
                CheckBox checkBox3 = (CheckBox) this.f62244a.a(R.id.insuranceCheckbox);
                kotlin.g.b.k.a((Object) checkBox3, "insuranceCheckbox");
                checkBox3.setClickable(false);
                CheckBox checkBox4 = (CheckBox) this.f62244a.a(R.id.insuranceCheckbox);
                kotlin.g.b.k.a((Object) checkBox4, "insuranceCheckbox");
                checkBox4.setEnabled(false);
                net.one97.paytm.recharge.coupons.e.a b3 = this.f62244a.f62185b;
                if (b3 != null) {
                    AJRCouponsActivityV8 aJRCouponsActivityV83 = this.f62244a;
                    yVar = b3.a("insurance_remove", aJRCouponsActivityV83.a(aJRCouponsActivityV83.U, "", false, false, true), (net.one97.paytm.recharge.common.e.ai) null, (Object) a5);
                }
                if (yVar != null) {
                    AJRCouponsActivityV8 aJRCouponsActivityV84 = this.f62244a;
                    yVar.observe(aJRCouponsActivityV84, new d(aJRCouponsActivityV84, yVar, z));
                }
            }
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62245a;

        o(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62245a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.REMOVE_PROMO.name());
            }
            a aVar = new a(this.f62245a, Boolean.TRUE);
            net.one97.paytm.recharge.coupons.e.a b2 = this.f62245a.f62185b;
            if (b2 != null) {
                b2.a("remove_promo_verify", AJRCouponsActivityV8.a(this.f62245a, "", (String) null, false, false, 30), (net.one97.paytm.recharge.common.e.ai) aVar, (Object) a2);
            }
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62246a;

        p(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62246a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            CheckBox checkBox = (CheckBox) this.f62246a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
            CheckBox checkBox2 = (CheckBox) this.f62246a.a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
            checkBox.setChecked(!checkBox2.isChecked());
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62247a;

        q(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62247a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            if (this.f62247a.ah != null) {
                net.one97.paytm.recharge.common.c.d j = this.f62247a.ah;
                if (j == null) {
                    kotlin.g.b.k.a();
                }
                if (!j.isAdded()) {
                    net.one97.paytm.recharge.common.c.d j2 = this.f62247a.ah;
                    if (j2 == null) {
                        kotlin.g.b.k.a();
                    }
                    androidx.fragment.app.j supportFragmentManager = this.f62247a.getSupportFragmentManager();
                    b bVar = AJRCouponsActivityV8.f62183e;
                    j2.show(supportFragmentManager, AJRCouponsActivityV8.au);
                }
            }
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62248a;

        r(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62248a = aJRCouponsActivityV8;
        }

        public final void onClick(View view) {
            AJRCouponsActivityV8.A(this.f62248a);
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ r f62249a;

                {
                    this.f62249a = r1;
                }

                public final void run() {
                    String str;
                    CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62249a.f62248a.a(R.id.proceed);
                    kotlin.g.b.k.a((Object) cJRProceedWidgetWithConvFeeV8, "proceed");
                    cJRProceedWidgetWithConvFeeV8.setEnabled(false);
                    AJRCouponsActivityV8.B(this.f62249a.f62248a);
                    if (!this.f62249a.f62248a.j.isEmpty()) {
                        if (!TextUtils.isEmpty(this.f62249a.f62248a.U)) {
                            d.a aVar = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                            str = net.one97.paytm.recharge.ordersummary.h.d.n;
                        } else {
                            d.a aVar2 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                            str = net.one97.paytm.recharge.ordersummary.h.d.l;
                        }
                    } else if (!TextUtils.isEmpty(this.f62249a.f62248a.U)) {
                        d.a aVar3 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                        str = net.one97.paytm.recharge.ordersummary.h.d.m;
                    } else {
                        str = "";
                    }
                    this.f62249a.f62248a.a(this.f62249a.f62248a.al, "proceed_to_pay_clicked", str);
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) a(R.id.proceed);
        if (cJRProceedWidgetWithConvFeeV8 != null) {
            cJRProceedWidgetWithConvFeeV8.a();
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.transparent_view_1);
        if (frameLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.b(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) a(R.id.transparent_view_2);
        if (frameLayout2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(frameLayout2);
        }
    }

    /* access modifiers changed from: private */
    public final void i() {
        CJRPersonalInsurance cJRPersonalInsurance;
        int amountTotal = ((CJRDealSelectWidgetV8) a(R.id.widgetSelectDeal)).getAmountTotal();
        CheckBox checkBox = (CheckBox) a(R.id.insuranceCheckbox);
        kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
        if (checkBox.isChecked() && (cJRPersonalInsurance = this.F) != null) {
            String priceForPersonalInsurance = cJRPersonalInsurance != null ? cJRPersonalInsurance.getPriceForPersonalInsurance() : null;
            if (priceForPersonalInsurance == null) {
                kotlin.g.b.k.a();
            }
            amountTotal += Integer.parseInt(priceForPersonalInsurance);
        }
        if (this.I.length() > 0) {
            try {
                amountTotal += Integer.parseInt(this.I);
                kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
                String string = getString(R.string.hotels_review_booking_to_book_args);
                kotlin.g.b.k.a((Object) string, "getString(R.string.hotel…iew_booking_to_book_args)");
                String format = String.format(string, Arrays.copyOf(new Object[]{ba.a(String.valueOf(amountTotal), true)}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                ((CJRProceedWidgetWithConvFeeV8) a(R.id.proceed)).setProceedBtnText(format);
            } catch (Exception unused) {
                float parseFloat = Float.parseFloat(this.I) + ((float) amountTotal);
                kotlin.g.b.aa aaVar2 = kotlin.g.b.aa.f47921a;
                String string2 = getString(R.string.hotels_review_booking_to_book_args);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.hotel…iew_booking_to_book_args)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{ba.a(String.valueOf(parseFloat), true)}, 1));
                kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                ((CJRProceedWidgetWithConvFeeV8) a(R.id.proceed)).setProceedBtnText(format2);
            }
        }
        j();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r0 = r0.getCart();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void j() {
        /*
            r6 = this;
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r6.f62186c
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0094
            boolean r0 = r0.isConvFeeFlow()
            r2 = 1
            if (r0 != r2) goto L_0x0094
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r6.f62186c
            r3 = 0
            if (r0 == 0) goto L_0x0023
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r0.getAggregatePGConvFee()
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0094
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r6.f62186c
            if (r0 == 0) goto L_0x003b
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.getAggregatePGConvFee()
            goto L_0x003c
        L_0x003b:
            r0 = r3
        L_0x003c:
            java.lang.String r4 = "0"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r2)
            if (r0 != 0) goto L_0x0094
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r6.f62186c
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0052
            java.lang.String r3 = r0.getAggregatePGConvFee()
        L_0x0052:
            boolean r0 = net.one97.paytm.recharge.common.utils.ba.g(r3)
            if (r0 == 0) goto L_0x0094
            int r0 = net.one97.paytm.recharge.R.id.proceed
            android.view.View r0 = r6.a((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8) r0
            if (r0 == 0) goto L_0x0093
            int r3 = net.one97.paytm.recharge.R.string.txt_conv_fee_charges
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r6.f62186c
            if (r5 == 0) goto L_0x0081
            net.one97.paytm.common.entity.shopping.CJRCart r5 = r5.getCart()
            if (r5 == 0) goto L_0x0081
            java.lang.String r5 = r5.getAggregatePGConvFee()
            if (r5 == 0) goto L_0x0081
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r1 = r5
        L_0x0081:
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.e(r1)
            r2[r4] = r1
            java.lang.String r1 = r6.getString(r3, r2)
            java.lang.String r2 = "getString(\n             …      )\n                )"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.setConvFeeText(r1)
        L_0x0093:
            return
        L_0x0094:
            int r0 = net.one97.paytm.recharge.R.id.proceed
            android.view.View r0 = r6.a((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8) r0
            if (r0 == 0) goto L_0x00a1
            r0.setConvFeeText(r1)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.j():void");
    }

    /* access modifiers changed from: private */
    public final void k() {
        String str;
        CJRCart cart;
        String finalPrice;
        CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) a(R.id.proceed);
        if (cJRProceedWidgetWithConvFeeV8 != null) {
            kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
            String string = getString(R.string.hotels_review_booking_to_book_args);
            kotlin.g.b.k.a((Object) string, "getString(R.string.hotel…iew_booking_to_book_args)");
            Object[] objArr = new Object[1];
            CJRRechargeCart cJRRechargeCart = this.f62186c;
            if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (finalPrice = cart.getFinalPrice()) == null || (str = finalPrice.toString()) == null) {
                str = "";
            }
            objArr[0] = ba.a(str, true);
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            cJRProceedWidgetWithConvFeeV8.setProceedBtnText(format);
        }
        j();
    }

    public static final class x implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62250a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        x(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62250a = aJRCouponsActivityV8;
        }

        public final void onPageSelected(int i2) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.coupons.e.a b2 = this.f62250a.f62185b;
            if (b2 != null && (dVar = b2.p) != null) {
                String e2 = this.f62250a.V;
                CJRCouponHeaderItem cJRCouponHeaderItem = this.f62250a.z.getCouponHeaderItemList().get(i2);
                kotlin.g.b.k.a((Object) cJRCouponHeaderItem, "mCouponHeader.couponHeaderItemList[p0]");
                String name = cJRCouponHeaderItem.getName();
                kotlin.g.b.k.a((Object) name, "mCouponHeader.couponHeaderItemList[p0].name");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "coupon_category_clicked", (Object) null, name, (Object) null, (Object) null, (Object) null, 116);
            }
        }
    }

    public final class a implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62192a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f62193b;

        /* renamed from: c  reason: collision with root package name */
        private final Boolean f62194c;

        /* renamed from: d  reason: collision with root package name */
        private final Boolean f62195d;

        /* renamed from: e  reason: collision with root package name */
        private final Boolean f62196e;

        /* renamed from: f  reason: collision with root package name */
        private final Boolean f62197f;

        /* renamed from: g  reason: collision with root package name */
        private final CJRGridProduct f62198g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f62199h;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, java.lang.Boolean] */
        /* JADX WARNING: type inference failed for: r5v0, types: [net.one97.paytm.common.entity.shopping.CJRGridProduct, java.lang.Boolean] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private a(java.lang.Boolean r1, java.lang.Boolean r2, java.lang.Boolean r3, java.lang.Boolean r4, net.one97.paytm.common.entity.shopping.CJRGridProduct r5) {
            /*
                r0 = this;
                r0.f62192a = r1
                r0.<init>()
                r0.f62194c = r2
                r0.f62195d = r3
                r0.f62196e = r4
                r0.f62197f = r5
                r2 = 0
                r0.f62198g = r2
                r0.f62199h = r2
                int r2 = net.one97.paytm.recharge.R.id.proceed
                android.view.View r1 = r1.a((int) r2)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetWithConvFeeV8) r1
                if (r1 == 0) goto L_0x0020
                r2 = 0
                r1.setEnabled(r2)
            L_0x0020:
                r1 = 1
                r0.f62193b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.a.<init>(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean):void");
        }

        public /* synthetic */ a(AJRCouponsActivityV8 aJRCouponsActivityV8, Boolean bool) {
            this(aJRCouponsActivityV8, Boolean.FALSE, bool, Boolean.FALSE, Boolean.FALSE);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            Object obj2 = obj;
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel2 instanceof CJRRechargeCart) {
                try {
                    az azVar = az.f61525a;
                    Bundle a2 = az.a((Context) this.f62192a, (CJRRechargeCart) iJRPaytmDataModel2, false, kotlin.g.b.k.a((Object) this.f62195d, (Object) Boolean.TRUE));
                    boolean z = a2.getBoolean("extra.has.error");
                    CJRCartStatus cartStatus = ((CJRRechargeCart) iJRPaytmDataModel2).getCartStatus();
                    CJRRechargeErrorModel cJRRechargeErrorModel = null;
                    if (!kotlin.m.p.a("SUCCESS", cartStatus != null ? cartStatus.getResult() : null, true) || z) {
                        if (obj2 instanceof CJRRechargeErrorModel) {
                            cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                        }
                        String string = a2.getString("extra.error.title");
                        String string2 = a2.getString("extra.error.msg");
                        az azVar2 = az.f61525a;
                        az.a(this.f62192a, ERROR_TYPE.UNDEFINED, ACTION_TYPE.REMOVE_PROMO, string, string2, false, cJRRechargeErrorModel, false, 1504);
                    } else {
                        this.f62193b = false;
                        this.f62192a.f62186c = (CJRRechargeCart) iJRPaytmDataModel2;
                        net.one97.paytm.recharge.common.utils.o a3 = this.f62192a.ao;
                        if (a3 != null) {
                            a3.f61684a = false;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!this.f62193b) {
                AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62192a;
                if (iJRPaytmDataModel2 != null) {
                    aJRCouponsActivityV8.b((CJRRechargeCart) iJRPaytmDataModel2);
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
                }
            }
            CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62192a.a(R.id.proceed);
            if (cJRProceedWidgetWithConvFeeV8 != null) {
                cJRProceedWidgetWithConvFeeV8.setEnabled(true);
            }
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            net.one97.paytm.recharge.coupons.e.a b2 = this.f62192a.f62185b;
            if (b2 != null) {
                b2.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
            CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62192a.a(R.id.proceed);
            if (cJRProceedWidgetWithConvFeeV8 != null) {
                cJRProceedWidgetWithConvFeeV8.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(CJRRechargeCart cJRRechargeCart) {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.promoApplied);
        kotlin.g.b.k.a((Object) relativeLayout, "promoApplied");
        relativeLayout.setVisibility(8);
        TextView textView = (TextView) a(R.id.offerDetailText);
        kotlin.g.b.k.a((Object) textView, "offerDetailText");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.havePromoText);
        kotlin.g.b.k.a((Object) textView2, "havePromoText");
        textView2.setVisibility(0);
        this.U = "";
        this.I = a(cJRRechargeCart != null ? cJRRechargeCart.getCart() : null);
        i();
        net.one97.paytm.recharge.common.utils.o oVar = this.ao;
        if (oVar != null) {
            oVar.f61685b = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r13.getFinalPrice();
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(net.one97.paytm.common.entity.shopping.CJRCart r13) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0014
            java.lang.String r2 = r13.getFinalPrice()
            if (r2 == 0) goto L_0x0014
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r3.<init>(r2)
            double r2 = r3.doubleValue()
            goto L_0x0015
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r13 == 0) goto L_0x00a3
            java.util.ArrayList r13 = r13.getCartItems()
            if (r13 == 0) goto L_0x00a3
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r4 = 0
            r5 = 0
        L_0x0025:
            boolean r6 = r13.hasNext()
            if (r6 == 0) goto L_0x00a3
            java.lang.Object r6 = r13.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x0036
            kotlin.a.k.a()
        L_0x0036:
            net.one97.paytm.common.entity.shopping.CJRCartProduct r6 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r6
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRCartProduct> r5 = r12.f62191i
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r8 = r5 instanceof java.util.Collection
            java.lang.String r9 = "item"
            r10 = 1
            if (r8 == 0) goto L_0x004c
            r8 = r5
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0072
        L_0x004c:
            java.util.Iterator r5 = r5.iterator()
        L_0x0050:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0072
            java.lang.Object r8 = r5.next()
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8
            java.lang.String r8 = r8.getProductId()
            if (r8 == 0) goto L_0x006e
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r11 = r6.getProductId()
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r11, (boolean) r10)
            goto L_0x006f
        L_0x006e:
            r8 = 0
        L_0x006f:
            if (r8 == 0) goto L_0x0050
            goto L_0x0073
        L_0x0072:
            r10 = 0
        L_0x0073:
            java.lang.Object r5 = r6.mMetaDataResponse
            boolean r8 = r5 instanceof com.google.gsonhtcfix.b.g
            if (r8 != 0) goto L_0x007a
            r5 = 0
        L_0x007a:
            com.google.gsonhtcfix.b.g r5 = (com.google.gsonhtcfix.b.g) r5
            if (r5 == 0) goto L_0x0087
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r8 = r12.y
            boolean r5 = r5.containsKey(r8)
            goto L_0x0088
        L_0x0087:
            r5 = 0
        L_0x0088:
            if (r10 != 0) goto L_0x00a1
            if (r5 != 0) goto L_0x00a1
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r5 = r6.getPrice()
            if (r5 == 0) goto L_0x009f
            java.math.BigDecimal r6 = new java.math.BigDecimal
            r6.<init>(r5)
            double r5 = r6.doubleValue()
            goto L_0x00a0
        L_0x009f:
            r5 = r0
        L_0x00a0:
            double r2 = r2 - r5
        L_0x00a1:
            r5 = r7
            goto L_0x0025
        L_0x00a3:
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 < 0) goto L_0x00ac
            java.lang.String r13 = java.lang.String.valueOf(r2)
            return r13
        L_0x00ac:
            java.lang.String r13 = r12.I
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.a(net.one97.paytm.common.entity.shopping.CJRCart):java.lang.String");
    }

    private final CJRCartProduct c(String str) {
        CJRRechargeCart cJRRechargeCart;
        if (this.f62186c == null) {
            finish();
        }
        if (TextUtils.isEmpty(str) || (cJRRechargeCart = this.f62186c) == null) {
            return null;
        }
        if (cJRRechargeCart == null) {
            kotlin.g.b.k.a();
        }
        if (cJRRechargeCart.getCart() == null) {
            return null;
        }
        CJRRechargeCart cJRRechargeCart2 = this.f62186c;
        if (cJRRechargeCart2 == null) {
            kotlin.g.b.k.a();
        }
        CJRCart cart = cJRRechargeCart2.getCart();
        kotlin.g.b.k.a((Object) cart, "mRechargeCart!!.cart");
        if (cart.getCartItems() == null) {
            return null;
        }
        CJRRechargeCart cJRRechargeCart3 = this.f62186c;
        if (cJRRechargeCart3 == null) {
            kotlin.g.b.k.a();
        }
        CJRCart cart2 = cJRRechargeCart3.getCart();
        kotlin.g.b.k.a((Object) cart2, "mRechargeCart!!.cart");
        Iterator<CJRCartProduct> it2 = cart2.getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next != null && kotlin.m.p.a(str, next.getProductId(), true)) {
                return next;
            }
        }
        return null;
    }

    static /* synthetic */ JSONObject a(AJRCouponsActivityV8 aJRCouponsActivityV8, String str, String str2, boolean z2, boolean z3, int i2) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return aJRCouponsActivityV8.a(str, str2, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, false);
    }

    /* access modifiers changed from: private */
    public final JSONObject a(String str, String str2, boolean z2, boolean z3, boolean z4) {
        String priceForPersonalInsurance;
        CJRCart cart;
        String grandTotalExcludingConvFee;
        CJRCart cart2;
        String grandTotalExcludingConvFee2;
        CJRCart cart3;
        String grandTotalExcludingConvFee3;
        CJRCart cart4;
        String grandTotalExcludingConvFee4;
        String priceForPersonalInsurance2;
        CJRCart cart5;
        String grandTotalExcludingConvFee5;
        CJRCart cart6;
        String grandTotalExcludingConvFee6;
        String str3 = str;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            int i2 = 1;
            if (this.f62190h.size() > 0) {
                int size = this.f62190h.size();
                int i3 = 0;
                while (i3 < size) {
                    JSONObject jSONObject2 = new JSONObject();
                    CJRSelectedRecharge cJRSelectedRecharge = this.f62190h.get(i3);
                    kotlin.g.b.k.a((Object) cJRSelectedRecharge, "mSelectedRechargeList[index]");
                    jSONObject2.put(CLPConstants.PRODUCT_ID, cJRSelectedRecharge.getProductId());
                    jSONObject2.put("qty", i2);
                    JSONObject jSONObject3 = new JSONObject();
                    CJRSelectedRecharge cJRSelectedRecharge2 = this.f62190h.get(i3);
                    kotlin.g.b.k.a((Object) cJRSelectedRecharge2, "mSelectedRechargeList[index]");
                    Map<String, String> configList = cJRSelectedRecharge2.getConfigList();
                    for (String next : configList.keySet()) {
                        jSONObject3.put(next, configList.get(next));
                    }
                    if (!kotlin.g.b.k.a((Object) this.E, (Object) this.f62190h.get(i3))) {
                        jSONObject3.put("upsell", 1);
                    }
                    jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
                    CJRSelectedRecharge cJRSelectedRecharge3 = this.f62190h.get(i3);
                    kotlin.g.b.k.a((Object) cJRSelectedRecharge3, "mSelectedRechargeList[index]");
                    String productId = cJRSelectedRecharge3.getProductId();
                    kotlin.g.b.k.a((Object) productId, "mSelectedRechargeList[index].productId");
                    CJRCartProduct c2 = c(productId);
                    Object metaDataResponse = c2 != null ? c2.getMetaDataResponse() : null;
                    if (metaDataResponse != null) {
                        String b2 = new com.google.gson.f().b(metaDataResponse);
                        if (!TextUtils.isEmpty(b2)) {
                            JSONObject jSONObject4 = new JSONObject(b2);
                            if (!TextUtils.isEmpty(this.S)) {
                                jSONObject4.put("post_order_view_type", this.S);
                            }
                            a(jSONObject4);
                            if (this.an && net.one97.paytm.recharge.common.utils.g.c(str)) {
                                jSONObject4.put(Utility.EVENT_CATEGORY_PROMOCODE, str3);
                            }
                            jSONObject2.put("meta_data", jSONObject4);
                        }
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        if (!TextUtils.isEmpty(this.S)) {
                            jSONObject5.put("post_order_view_type", this.S);
                        }
                        a(jSONObject5);
                        jSONObject2.put("meta_data", jSONObject5);
                    }
                    jSONArray.put(jSONObject2);
                    i3++;
                    i2 = 1;
                }
            }
            if (this.j.size() > 0) {
                int size2 = this.j.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(CLPConstants.PRODUCT_ID, this.j.get(i4));
                    jSONObject6.put("qty", 1);
                    String str4 = this.j.get(i4);
                    CJRPersonalInsurance cJRPersonalInsurance = this.F;
                    if (kotlin.m.p.a(str4, cJRPersonalInsurance != null ? cJRPersonalInsurance.getProductID() : null, true)) {
                        com.google.gson.f fVar = new com.google.gson.f();
                        CJRPersonalInsurance cJRPersonalInsurance2 = this.F;
                        String b3 = fVar.b(cJRPersonalInsurance2 != null ? cJRPersonalInsurance2.getMetaDataInsurance() : null);
                        if (!TextUtils.isEmpty(b3)) {
                            JSONObject jSONObject7 = new JSONObject(b3);
                            jSONObject7.put("insurance_url", this.K);
                            jSONObject6.put("meta_data", jSONObject7);
                        }
                    }
                    jSONArray.put(jSONObject6);
                }
            }
            if (jSONArray.length() == 0) {
                return jSONObject;
            }
            if (this.ao != null && !TextUtils.isEmpty(str3)) {
                net.one97.paytm.recharge.common.utils.o oVar = this.ao;
                if (!TextUtils.isEmpty(oVar != null ? oVar.d() : null)) {
                    Type type = new ai().getType();
                    com.google.gson.f fVar2 = new com.google.gson.f();
                    net.one97.paytm.recharge.common.utils.o oVar2 = this.ao;
                    ArrayList arrayList = (ArrayList) fVar2.a(oVar2 != null ? oVar2.d() : null, type);
                    if (arrayList != null && (!arrayList.isEmpty())) {
                        CJRRechargeCart cJRRechargeCart = this.f62186c;
                        if (((cJRRechargeCart == null || (cart6 = cJRRechargeCart.getCart()) == null || (grandTotalExcludingConvFee6 = cart6.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee6))) != null) {
                            if (z2) {
                                Object obj = arrayList.get(0);
                                kotlin.g.b.k.a(obj, "paymentIntentArray.get(0)");
                                PaymentIntent paymentIntent = (PaymentIntent) obj;
                                CJRRechargeCart cJRRechargeCart2 = this.f62186c;
                                Double valueOf = (cJRRechargeCart2 == null || (cart5 = cJRRechargeCart2.getCart()) == null || (grandTotalExcludingConvFee5 = cart5.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee5));
                                if (valueOf == null) {
                                    kotlin.g.b.k.a();
                                }
                                double doubleValue = valueOf.doubleValue();
                                CJRPersonalInsurance cJRPersonalInsurance3 = this.F;
                                Double valueOf2 = (cJRPersonalInsurance3 == null || (priceForPersonalInsurance2 = cJRPersonalInsurance3.getPriceForPersonalInsurance()) == null) ? null : Double.valueOf(Double.parseDouble(priceForPersonalInsurance2));
                                if (valueOf2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                paymentIntent.setTxnAmount(doubleValue + valueOf2.doubleValue());
                            } else if (z3 && !TextUtils.isEmpty(str2)) {
                                Object obj2 = arrayList.get(0);
                                kotlin.g.b.k.a(obj2, "paymentIntentArray.get(0)");
                                PaymentIntent paymentIntent2 = (PaymentIntent) obj2;
                                CJRRechargeCart cJRRechargeCart3 = this.f62186c;
                                Double valueOf3 = (cJRRechargeCart3 == null || (cart4 = cJRRechargeCart3.getCart()) == null || (grandTotalExcludingConvFee4 = cart4.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee4));
                                if (valueOf3 == null) {
                                    kotlin.g.b.k.a();
                                }
                                paymentIntent2.setTxnAmount(valueOf3.doubleValue() + Double.parseDouble(str2));
                            } else if (!z3 || ((CJRDealSelectWidgetV8) a(R.id.widgetSelectDeal)).getAmountTotal() <= 0) {
                                CJRRechargeCart cJRRechargeCart4 = this.f62186c;
                                Double valueOf4 = (cJRRechargeCart4 == null || (cart2 = cJRRechargeCart4.getCart()) == null || (grandTotalExcludingConvFee2 = cart2.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee2));
                                if (valueOf4 == null) {
                                    kotlin.g.b.k.a();
                                }
                                double doubleValue2 = valueOf4.doubleValue();
                                if (z4) {
                                    Object obj3 = arrayList.get(0);
                                    kotlin.g.b.k.a(obj3, "paymentIntentArray.get(0)");
                                    PaymentIntent paymentIntent3 = (PaymentIntent) obj3;
                                    CJRRechargeCart cJRRechargeCart5 = this.f62186c;
                                    Double valueOf5 = (cJRRechargeCart5 == null || (cart = cJRRechargeCart5.getCart()) == null || (grandTotalExcludingConvFee = cart.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee));
                                    if (valueOf5 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    double doubleValue3 = valueOf5.doubleValue();
                                    CJRPersonalInsurance cJRPersonalInsurance4 = this.F;
                                    Double valueOf6 = (cJRPersonalInsurance4 == null || (priceForPersonalInsurance = cJRPersonalInsurance4.getPriceForPersonalInsurance()) == null) ? null : Double.valueOf(Double.parseDouble(priceForPersonalInsurance));
                                    if (valueOf6 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    paymentIntent3.setTxnAmount(doubleValue3 - valueOf6.doubleValue());
                                } else {
                                    Object obj4 = arrayList.get(0);
                                    kotlin.g.b.k.a(obj4, "paymentIntentArray.get(0)");
                                    ((PaymentIntent) obj4).setTxnAmount(doubleValue2);
                                }
                            } else {
                                Object obj5 = arrayList.get(0);
                                kotlin.g.b.k.a(obj5, "paymentIntentArray.get(0)");
                                PaymentIntent paymentIntent4 = (PaymentIntent) obj5;
                                CJRRechargeCart cJRRechargeCart6 = this.f62186c;
                                Double valueOf7 = (cJRRechargeCart6 == null || (cart3 = cJRRechargeCart6.getCart()) == null || (grandTotalExcludingConvFee3 = cart3.getGrandTotalExcludingConvFee()) == null) ? null : Double.valueOf(Double.parseDouble(grandTotalExcludingConvFee3));
                                if (valueOf7 == null) {
                                    kotlin.g.b.k.a();
                                }
                                paymentIntent4.setTxnAmount(valueOf7.doubleValue() + ((double) ((CJRDealSelectWidgetV8) a(R.id.widgetSelectDeal)).getAmountTotal()));
                            }
                            jSONObject.put("payment_intent", new com.google.gson.f().b(arrayList));
                        }
                    }
                }
            }
            jSONObject.put("cart_items", jSONArray);
            jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, str3);
            if (!TextUtils.isEmpty(this.T)) {
                jSONObject.put("payment_method", this.T);
            }
            if (this.B != null) {
                aw awVar = aw.f61520a;
                JSONObject a2 = aw.a(this.B);
                if (a2 != null) {
                    jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, a2);
                }
            }
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            net.one97.paytm.recharge.common.utils.y.a(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public static final class ai extends com.google.gson.b.a<ArrayList<PaymentIntent>> {
        ai() {
        }
    }

    private void a(JSONObject jSONObject) {
        kotlin.g.b.k.c(jSONObject, "metaDataJsonObject");
        CJRDetailProduct cJRDetailProduct = this.t;
        if (cJRDetailProduct != null) {
            Map<String, String> attributes = cJRDetailProduct != null ? cJRDetailProduct.getAttributes() : null;
            if (attributes != null) {
                for (String next : attributes.keySet()) {
                    if (kotlin.m.p.a("tag_price", next, true) || kotlin.m.p.a("security", next, true) || kotlin.m.p.a("threshold", next, true)) {
                        jSONObject.put(next, String.valueOf(attributes.get(next)));
                    }
                }
            }
        }
    }

    public final androidx.lifecycle.y<CJROffers> e() {
        return this.p;
    }

    /* access modifiers changed from: private */
    public final void a(CJROfferCode cJROfferCode, CJRCart cJRCart) {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.promoApplied);
        kotlin.g.b.k.a((Object) relativeLayout, "promoApplied");
        int i2 = 0;
        relativeLayout.setVisibility(0);
        TextView textView = (TextView) a(R.id.havePromoText);
        kotlin.g.b.k.a((Object) textView, "havePromoText");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.promoText);
        kotlin.g.b.k.a((Object) textView2, "promoText");
        kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
        String string = getString(R.string.offer_applied_txt);
        kotlin.g.b.k.a((Object) string, "getString(R.string.offer_applied_txt)");
        String format = String.format(string, Arrays.copyOf(new Object[]{cJROfferCode.getCode()}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        textView2.setText(format);
        String code = cJROfferCode.getCode();
        kotlin.g.b.k.a((Object) code, "promoCode.code");
        this.U = code;
        x.a aVar = new x.a();
        aVar.element = false;
        x.e eVar = new x.e();
        eVar.element = "";
        kotlin.o<Boolean, String> a2 = a(cJRCart, aVar.element, (String) eVar.element);
        aVar.element = a2.getFirst().booleanValue();
        eVar.element = (String) a2.getSecond();
        TextView textView3 = (TextView) a(R.id.promoOfferDetail);
        kotlin.g.b.k.a((Object) textView3, "promoOfferDetail");
        if (TextUtils.isEmpty(cJROfferCode.getTerms())) {
            i2 = 8;
        }
        textView3.setVisibility(i2);
        ((TextView) a(R.id.promoOfferDetail)).setOnClickListener(new h(this, aVar, eVar, cJROfferCode));
        this.I = a(cJRCart);
        i();
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62234a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f62235b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f62236c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJROfferCode f62237d;

        h(AJRCouponsActivityV8 aJRCouponsActivityV8, x.a aVar, x.e eVar, CJROfferCode cJROfferCode) {
            this.f62234a = aJRCouponsActivityV8;
            this.f62235b = aVar;
            this.f62236c = eVar;
            this.f62237d = cJROfferCode;
        }

        public final void onClick(View view) {
            if (this.f62235b.element) {
                if (this.f62234a.ai == null) {
                    this.f62234a.ai = new net.one97.paytm.recharge.common.c.d();
                }
                Bundle bundle = new Bundle();
                bundle.putString("tnc_title", (String) this.f62236c.element);
                bundle.putString("tnc_text", this.f62237d.getTerms());
                net.one97.paytm.recharge.common.c.d N = this.f62234a.ai;
                if (N == null) {
                    kotlin.g.b.k.a();
                }
                N.setArguments(bundle);
            }
            AJRCouponsActivityV8.O(this.f62234a);
        }
    }

    private final kotlin.o<Boolean, String> a(CJRCart cJRCart, boolean z2, String str) {
        if (cJRCart.getCartItems().size() > 0) {
            ArrayList<CJRCartProduct> cartItems = cJRCart.getCartItems();
            kotlin.g.b.k.a((Object) cartItems, "cart.cartItems");
            int size = cartItems.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (kotlin.m.p.a(cJRCart.getCartItems().get(i2).getmPromoStatus(), "SUCCESS", true)) {
                    CJRCartProduct cJRCartProduct = cJRCart.getCartItems().get(i2);
                    kotlin.g.b.k.a((Object) cJRCartProduct, "cart.cartItems[i]");
                    String promoCode = cJRCartProduct.getPromoCode();
                    kotlin.g.b.k.a((Object) promoCode, "cart.cartItems[i].promoCode");
                    TextView textView = (TextView) a(R.id.offerDetailText);
                    kotlin.g.b.k.a((Object) textView, "offerDetailText");
                    textView.setVisibility(0);
                    TextView textView2 = (TextView) a(R.id.offerDetailText);
                    kotlin.g.b.k.a((Object) textView2, "offerDetailText");
                    CJRCartProduct cJRCartProduct2 = cJRCart.getCartItems().get(i2);
                    kotlin.g.b.k.a((Object) cJRCartProduct2, "cart.cartItems[i]");
                    textView2.setText(cJRCartProduct2.getPromoText());
                    str = promoCode;
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return new kotlin.o<>(Boolean.valueOf(z2), str);
    }

    public final androidx.lifecycle.y<CJRRechargeCart> b(CJROfferCode cJROfferCode, Object obj) {
        T t2;
        kotlin.g.b.k.c(cJROfferCode, "promoCode");
        this.ak = cJROfferCode;
        x.e eVar = new x.e();
        net.one97.paytm.recharge.coupons.e.a aVar = this.f62185b;
        if (aVar != null) {
            String code = cJROfferCode.getCode();
            kotlin.g.b.k.a((Object) code, "promoCode.code");
            t2 = aVar.a("fetch_promo_verify", a(this, code, (String) null, false, false, 30), (net.one97.paytm.recharge.common.e.ai) null, obj);
        } else {
            t2 = null;
        }
        eVar.element = t2;
        this.f62187d = new ag(this, eVar);
        androidx.lifecycle.y yVar = (androidx.lifecycle.y) eVar.element;
        if (yVar != null) {
            androidx.lifecycle.z<CJRRechargeCart> zVar = this.f62187d;
            if (zVar == null) {
                kotlin.g.b.k.a();
            }
            yVar.observeForever(zVar);
        }
        return (androidx.lifecycle.y) eVar.element;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment fragment;
        net.one97.paytm.recharge.coupons.a.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 549) {
            if (i3 == -1) {
                c cVar = this.f62188f;
                Integer num = null;
                if (cVar != null) {
                    ViewPager viewPager = (ViewPager) a(R.id.dealViewPager);
                    kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
                    fragment = cVar.a(viewPager.getCurrentItem());
                } else {
                    fragment = null;
                }
                if (!(fragment instanceof net.one97.paytm.recharge.coupons.b.a)) {
                    fragment = null;
                }
                net.one97.paytm.recharge.coupons.b.a aVar2 = (net.one97.paytm.recharge.coupons.b.a) fragment;
                if (aVar2 != null) {
                    CJRGridProduct cJRGridProduct = this.f62184a;
                    if (cJRGridProduct == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.c(cJRGridProduct, "coupon");
                    if (!(aVar2.f62266a == null || (aVar = aVar2.f62266a) == null)) {
                        kotlin.g.b.k.c(cJRGridProduct, "coupon");
                        try {
                            int indexOf = aVar.f62160a.indexOf(cJRGridProduct.getProductID());
                            int size = aVar.f62164e.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size) {
                                    i4 = -1;
                                    break;
                                }
                                CJRGridProduct cJRGridProduct2 = aVar.f62164e.get(i4);
                                kotlin.g.b.k.a((Object) cJRGridProduct2, "mCouponList[i]");
                                if (kotlin.m.p.a(cJRGridProduct2.getProductID(), cJRGridProduct.getProductID(), true)) {
                                    break;
                                }
                                i4++;
                            }
                            if (indexOf != -1 || i4 == -1) {
                                aVar.f62160a.remove(indexOf);
                                CJRGridProduct cJRGridProduct3 = aVar.f62164e.get(i4);
                                kotlin.g.b.k.a((Object) cJRGridProduct3, "mCouponList[position]");
                                cJRGridProduct3.setIsAdded(false);
                            } else {
                                ArrayList<String> arrayList = aVar.f62160a;
                                CJRGridProduct cJRGridProduct4 = aVar.f62164e.get(i4);
                                kotlin.g.b.k.a((Object) cJRGridProduct4, "mCouponList[position]");
                                arrayList.add(cJRGridProduct4.getProductID());
                                CJRGridProduct cJRGridProduct5 = aVar.f62164e.get(i4);
                                kotlin.g.b.k.a((Object) cJRGridProduct5, "mCouponList[position]");
                                cJRGridProduct5.setIsAdded(true);
                            }
                            aVar.notifyItemChanged(i4);
                        } catch (Throwable th) {
                            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                        }
                    }
                    ArrayList<CJRGridProduct> masterDataListDealsModel = ((CJRDealSelectWidgetV8) a(R.id.widgetSelectDeal)).getMasterDataListDealsModel();
                    CJRGridProduct cJRGridProduct6 = this.f62184a;
                    if (cJRGridProduct6 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (masterDataListDealsModel.contains(cJRGridProduct6)) {
                        net.one97.paytm.recharge.coupons.e.b bVar = this.r;
                        if (bVar != null) {
                            CJRGridProduct cJRGridProduct7 = this.f62184a;
                            if (cJRGridProduct7 == null) {
                                kotlin.g.b.k.a();
                            }
                            bVar.a(cJRGridProduct7);
                        }
                        try {
                            net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                            CJRGridProduct cJRGridProduct8 = this.f62184a;
                            if (cJRGridProduct8 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.di.helper.b.a(cJRGridProduct8, (Context) this, aVar2.f62268c, aVar2.f62269d);
                        } catch (Throwable unused) {
                        }
                    } else {
                        net.one97.paytm.recharge.coupons.e.b bVar3 = this.r;
                        if (bVar3 != null) {
                            CJRGridProduct cJRGridProduct9 = this.f62184a;
                            if (cJRGridProduct9 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (intent != null) {
                                num = Integer.valueOf(intent.getIntExtra("selected_position", -1));
                            }
                            bVar3.a((net.one97.paytm.recharge.coupons.e.c<CJRGridProduct>) new net.one97.paytm.recharge.coupons.e.c(cJRGridProduct9, num));
                        }
                        try {
                            net.one97.paytm.recharge.di.helper.b bVar4 = net.one97.paytm.recharge.di.helper.b.f62652a;
                            CJRGridProduct cJRGridProduct10 = this.f62184a;
                            if (cJRGridProduct10 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.di.helper.b.b(cJRGridProduct10, (Context) this, aVar2.f62268c, aVar2.f62269d);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } else if (i2 == 3 && i3 != -1) {
            ay ayVar = ay.f61523a;
            ay.a(i2);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        kotlin.g.b.k.c(motionEvent, "ev");
        super.dispatchTouchEvent(motionEvent);
        GestureDetector gestureDetector = this.v;
        if (gestureDetector == null) {
            kotlin.g.b.k.a();
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public static final class ab extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62201a;

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        ab(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62201a = aJRCouponsActivityV8;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent == null || motionEvent2 == null) {
                this.f62201a.aj = false;
                return false;
            }
            if (motionEvent.getY() > motionEvent2.getY() && !this.f62201a.aj) {
                LinearLayout linearLayout = (LinearLayout) this.f62201a.a(R.id.promoLayout);
                kotlin.g.b.k.a((Object) linearLayout, "promoLayout");
                if (linearLayout.getVisibility() == 0) {
                    AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62201a;
                    LinearLayout linearLayout2 = (LinearLayout) aJRCouponsActivityV8.a(R.id.promoLayout);
                    kotlin.g.b.k.a((Object) linearLayout2, "promoLayout");
                    AJRCouponsActivityV8.a(aJRCouponsActivityV8, (View) linearLayout2);
                }
            }
            this.f62201a.aj = false;
            return true;
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62223a;

        e(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62223a = aJRCouponsActivityV8;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f62223a.a(R.id.promoLayout);
            kotlin.g.b.k.a((Object) linearLayout, "promoLayout");
            linearLayout.setVisibility(8);
            ((LinearLayout) this.f62223a.a(R.id.proceedLayout)).setBackgroundResource(R.drawable.v8_bg_coupons_expand);
            if (this.f62223a.w) {
                new Handler().postDelayed(new al(this.f62223a), 250);
            }
        }
    }

    static final class ah<T> implements androidx.lifecycle.z<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.y f62208b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62209c;

        ah(AJRCouponsActivityV8 aJRCouponsActivityV8, androidx.lifecycle.y yVar, String str) {
            this.f62207a = aJRCouponsActivityV8;
            this.f62208b = yVar;
            this.f62209c = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
            r6 = (r6 = (r6 = r6.getCart()).getCartItems()).get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r6 = r5.f62207a
                androidx.lifecycle.y r0 = r5.f62208b
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
                java.lang.String r1 = r5.f62209c
                java.lang.String r2 = "promo"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r3 = r5.f62207a
                java.lang.String r4 = r5.f62209c
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
                net.one97.paytm.common.entity.shopping.CJROfferCode r2 = net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.c(r3, r4)
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.a(r6, r0, r1, r2)
                androidx.lifecycle.y r6 = r5.f62208b
                java.lang.Object r6 = r6.getValue()
                net.one97.paytm.common.entity.CJRRechargeCart r6 = (net.one97.paytm.common.entity.CJRRechargeCart) r6
                r0 = 0
                if (r6 == 0) goto L_0x0044
                net.one97.paytm.common.entity.shopping.CJRCart r6 = r6.getCart()
                if (r6 == 0) goto L_0x0044
                java.util.ArrayList r6 = r6.getCartItems()
                if (r6 == 0) goto L_0x0044
                r1 = 0
                java.lang.Object r6 = r6.get(r1)
                net.one97.paytm.common.entity.shopping.CJRCartProduct r6 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r6
                if (r6 == 0) goto L_0x0044
                java.lang.String r6 = r6.getPromoCode()
                goto L_0x0045
            L_0x0044:
                r6 = r0
            L_0x0045:
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r1 = r5.f62207a
                androidx.lifecycle.y r1 = r1.p
                if (r1 == 0) goto L_0x0054
                java.lang.Object r1 = r1.getValue()
                net.one97.paytm.common.entity.shopping.CJROffers r1 = (net.one97.paytm.common.entity.shopping.CJROffers) r1
                goto L_0x0055
            L_0x0054:
                r1 = r0
            L_0x0055:
                if (r1 != 0) goto L_0x0092
                androidx.lifecycle.y r1 = r5.f62208b
                java.lang.Object r1 = r1.getValue()
                net.one97.paytm.common.entity.CJRRechargeCart r1 = (net.one97.paytm.common.entity.CJRRechargeCart) r1
                if (r1 == 0) goto L_0x006b
                net.one97.paytm.common.entity.shopping.CJRCart r1 = r1.getCart()
                if (r1 == 0) goto L_0x006b
                java.lang.String r0 = r1.getPromoStatus()
            L_0x006b:
                r1 = 1
                java.lang.String r2 = "Success"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
                if (r0 == 0) goto L_0x0092
                java.lang.String r0 = r5.f62209c
                boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r0, (boolean) r1)
                if (r6 == 0) goto L_0x0092
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r6 = r5.f62207a
                androidx.lifecycle.y r6 = r6.p
                if (r6 == 0) goto L_0x0092
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r0 = r5.f62207a
                androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
                net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ah$a r1 = new net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$ah$a
                r1.<init>(r5)
                androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
                r6.observe(r0, r1)
            L_0x0092:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.ah.onChanged(java.lang.Object):void");
        }

        static final class a<T> implements androidx.lifecycle.z<CJROffers> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ah f62210a;

            a(ah ahVar) {
                this.f62210a = ahVar;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62210a.f62207a;
                String str = this.f62210a.f62209c;
                kotlin.g.b.k.a((Object) str, "promo");
                CJROfferCode c2 = AJRCouponsActivityV8.c(aJRCouponsActivityV8, str);
                if (c2 != null && this.f62210a.f62208b.getValue() != null) {
                    AJRCouponsActivityV8 aJRCouponsActivityV82 = this.f62210a.f62207a;
                    Object value = this.f62210a.f62208b.getValue();
                    if (value == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a(value, "rechargeCart.value!!");
                    CJRCart cart = ((CJRRechargeCart) value).getCart();
                    kotlin.g.b.k.a((Object) cart, "rechargeCart.value!!.cart");
                    aJRCouponsActivityV82.a(c2, cart);
                }
            }
        }
    }

    private final void l() {
        CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) a(R.id.proceed);
        if (cJRProceedWidgetWithConvFeeV8 != null) {
            cJRProceedWidgetWithConvFeeV8.setEnabled(false);
        }
        Context context = this;
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.v8_slide_up_proceed);
        kotlin.g.b.k.a((Object) loadAnimation, "AnimationUtils.loadAnima…anim.v8_slide_up_proceed)");
        ((LinearLayout) a(R.id.proceedLayout)).startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.v8_slideup_toolbar);
        kotlin.g.b.k.a((Object) loadAnimation2, "AnimationUtils.loadAnima….anim.v8_slideup_toolbar)");
        ((RelativeLayout) a(R.id.rechargeDetail)).startAnimation(loadAnimation2);
        kotlin.g.b.k.a((Object) AnimationUtils.loadAnimation(context, R.anim.v8_slideup_content), "AnimationUtils.loadAnima….anim.v8_slideup_content)");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RelativeLayout) a(R.id.dealContainer), View.ALPHA, new float[]{1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new i(this, ofFloat));
        animatorSet.setDuration(150);
        animatorSet.play(ofFloat);
        animatorSet.start();
        new Handler().postDelayed(new j(this), 1000);
    }

    public static final class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f62239b;

        public final void onAnimationStart(Animator animator) {
        }

        i(AJRCouponsActivityV8 aJRCouponsActivityV8, ObjectAnimator objectAnimator) {
            this.f62238a = aJRCouponsActivityV8;
            this.f62239b = objectAnimator;
        }

        public final void onAnimationEnd(Animator animator) {
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f62238a.a(R.id.dealsCollapsingToolbar);
            kotlin.g.b.k.a((Object) collapsingToolbarLayout, "dealsCollapsingToolbar");
            collapsingToolbarLayout.setTitle(this.f62238a.getResources().getString(R.string.special_deals));
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62240a;

        j(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62240a = aJRCouponsActivityV8;
        }

        public final void run() {
            CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) this.f62240a.a(R.id.proceed);
            if (cJRProceedWidgetWithConvFeeV8 != null) {
                cJRProceedWidgetWithConvFeeV8.setEnabled(true);
            }
        }
    }

    private final void m() {
        ArrayList<CJRCartProduct> cartItems;
        if (this.f62186c == null) {
            finish();
        }
        Float valueOf = Float.valueOf(0.0f);
        this.f62190h.clear();
        this.f62191i.clear();
        if (this.X) {
            CJRRechargeCart cJRRechargeCart = this.f62186c;
            if (cJRRechargeCart == null) {
                kotlin.g.b.k.a();
            }
            CJRCart cart = cJRRechargeCart.getCart();
            kotlin.g.b.k.a((Object) cart, "mRechargeCart!!.cart");
            CJRCartProduct cJRCartProduct = cart.getCartItems().get(0);
            kotlin.g.b.k.a((Object) cJRCartProduct, "cartProduct");
            String productId = cJRCartProduct.getProductId();
            kotlin.g.b.k.a((Object) productId, "cartProduct.productId");
            this.L = productId;
            this.C = cJRCartProduct;
            String productId2 = cJRCartProduct.getProductId();
            kotlin.g.b.k.a((Object) productId2, "cartProduct.productId");
            this.O = productId2;
            CJRSelectedRecharge cJRSelectedRecharge = new CJRSelectedRecharge();
            cJRSelectedRecharge.setProductId(cJRCartProduct.getProductId());
            Map hashMap = new HashMap();
            hashMap.put("recharge_number", this.N);
            String discountedPrice = cJRCartProduct.getDiscountedPrice();
            kotlin.g.b.k.a((Object) discountedPrice, "cartProduct.discountedPrice");
            hashMap.put("price", discountedPrice);
            cJRSelectedRecharge.setConfigList(cJRCartProduct.getConfigurationList());
            this.f62190h.add(cJRSelectedRecharge);
            this.f62191i.add(cJRCartProduct);
            try {
                valueOf = Float.valueOf(Float.parseFloat(cJRCartProduct.getDiscountedPrice()));
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        } else {
            CJRRechargeCart cJRRechargeCart2 = this.f62186c;
            if (cJRRechargeCart2 != null) {
                if (cJRRechargeCart2 == null) {
                    kotlin.g.b.k.a();
                }
                CJRCart cart2 = cJRRechargeCart2.getCart();
                if ((cart2 != null ? cart2.getCartItems() : null) != null) {
                    CJRRechargeCart cJRRechargeCart3 = this.f62186c;
                    if (cJRRechargeCart3 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRCart cart3 = cJRRechargeCart3.getCart();
                    if (!(cart3 == null || (cartItems = cart3.getCartItems()) == null || !(!cartItems.isEmpty()))) {
                        CJRRechargeCart cJRRechargeCart4 = this.f62186c;
                        if (cJRRechargeCart4 == null) {
                            kotlin.g.b.k.a();
                        }
                        CJRCart cart4 = cJRRechargeCart4.getCart();
                        kotlin.g.b.k.a((Object) cart4, "mRechargeCart!!.cart");
                        Iterator<CJRCartProduct> it2 = cart4.getCartItems().iterator();
                        while (it2.hasNext()) {
                            CJRCartProduct next = it2.next();
                            kotlin.g.b.k.a((Object) next, "cartProduct");
                            if (!kotlin.m.p.a(next.getVerticalLabel(), "recharge", true) && !ba.f(next.getVerticalLabel()) && !this.aa) {
                                String productId3 = next.getProductId();
                                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                                if (!kotlin.m.p.a(productId3, net.one97.paytm.recharge.di.helper.c.L(), true)) {
                                }
                            }
                            CJRSelectedRecharge cJRSelectedRecharge2 = new CJRSelectedRecharge();
                            String productId4 = next.getProductId();
                            kotlin.g.b.k.a((Object) productId4, "cartProduct.productId");
                            this.L = productId4;
                            String productId5 = next.getProductId();
                            kotlin.g.b.k.a((Object) productId5, "cartProduct.productId");
                            this.O = productId5;
                            cJRSelectedRecharge2.setProductId(next.getProductId());
                            cJRSelectedRecharge2.setProductPrice(next.getDiscountedPrice());
                            this.E = cJRSelectedRecharge2;
                            cJRSelectedRecharge2.setConfigList(next.getConfigurationList());
                            this.f62190h.add(cJRSelectedRecharge2);
                            this.f62191i.add(next);
                            try {
                                String str = cJRSelectedRecharge2.getConfigList().get("price");
                                if (str == null) {
                                    kotlin.g.b.k.a();
                                }
                                valueOf = Float.valueOf(Float.parseFloat(str) + valueOf.floatValue());
                            } catch (Throwable th2) {
                                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th2);
                            }
                        }
                    }
                }
            }
        }
        this.P = String.valueOf(valueOf);
    }

    public final class c extends androidx.fragment.app.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62214a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<Integer, String> f62215b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private int f62216c;

        /* renamed from: d  reason: collision with root package name */
        private final androidx.fragment.app.j f62217d;

        /* renamed from: e  reason: collision with root package name */
        private CJRCouponHeader f62218e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0019, code lost:
            r2 = r2.getCouponHeaderItemList();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r2, androidx.fragment.app.j r3, net.one97.paytm.recharge.model.CJRCouponHeader r4) {
            /*
                r1 = this;
                java.lang.String r0 = "mFragmentManager"
                kotlin.g.b.k.c(r3, r0)
                r1.f62214a = r2
                r1.<init>(r3)
                r1.f62217d = r3
                r1.f62218e = r4
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                r1.f62215b = r2
                net.one97.paytm.recharge.model.CJRCouponHeader r2 = r1.f62218e
                if (r2 == 0) goto L_0x0028
                java.util.ArrayList r2 = r2.getCouponHeaderItemList()
                if (r2 == 0) goto L_0x0028
                int r2 = r2.size()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0029
            L_0x0028:
                r2 = 0
            L_0x0029:
                if (r2 != 0) goto L_0x002e
                kotlin.g.b.k.a()
            L_0x002e:
                int r2 = r2.intValue()
                if (r2 <= 0) goto L_0x0045
                net.one97.paytm.recharge.model.CJRCouponHeader r2 = r1.f62218e
                if (r2 != 0) goto L_0x003b
                kotlin.g.b.k.a()
            L_0x003b:
                java.util.ArrayList r2 = r2.getCouponHeaderItemList()
                int r2 = r2.size()
                r1.f62216c = r2
            L_0x0045:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.c.<init>(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, androidx.fragment.app.j, net.one97.paytm.recharge.model.CJRCouponHeader):void");
        }

        public final CharSequence getPageTitle(int i2) {
            CJRCouponHeader cJRCouponHeader = this.f62218e;
            if (cJRCouponHeader == null) {
                kotlin.g.b.k.a();
            }
            CJRCouponHeaderItem cJRCouponHeaderItem = cJRCouponHeader.getCouponHeaderItemList().get(i2);
            kotlin.g.b.k.a((Object) cJRCouponHeaderItem, "couponHeader!!.couponHeaderItemList[position]");
            String name = cJRCouponHeaderItem.getName();
            kotlin.g.b.k.a((Object) name, "couponHeader!!.couponHeaderItemList[position].name");
            return name;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            kotlin.g.b.k.c(viewGroup, "container");
            Object instantiateItem = super.instantiateItem(viewGroup, i2);
            kotlin.g.b.k.a(instantiateItem, "super.instantiateItem(container, position)");
            if (instantiateItem instanceof Fragment) {
                String tag = ((Fragment) instantiateItem).getTag();
                HashMap<Integer, String> hashMap = this.f62215b;
                Integer valueOf = Integer.valueOf(i2);
                if (tag == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.put(valueOf, tag);
            }
            return instantiateItem;
        }

        public final Fragment getItem(int i2) {
            Fragment instantiate = Fragment.instantiate(this.f62214a, net.one97.paytm.recharge.coupons.b.a.class.getName(), (Bundle) null);
            if (instantiate != null) {
                net.one97.paytm.recharge.coupons.b.a aVar = (net.one97.paytm.recharge.coupons.b.a) instantiate;
                String c2 = this.f62214a.Q;
                kotlin.g.b.k.c(c2, "category");
                net.one97.paytm.recharge.coupons.a.a aVar2 = aVar.f62266a;
                if (aVar2 != null) {
                    kotlin.g.b.k.c(c2, "<set-?>");
                    aVar2.f62166g = c2;
                }
                aVar.f62269d = c2;
                String d2 = this.f62214a.am;
                kotlin.g.b.k.c(d2, "variant");
                aVar.f62270e = d2;
                String e2 = this.f62214a.V;
                kotlin.g.b.k.c(e2, "<set-?>");
                aVar.f62271f = e2;
                StringBuilder sb = new StringBuilder("/coupon/");
                sb.append(this.f62214a.Q);
                sb.append("/");
                CJRCouponHeader cJRCouponHeader = this.f62218e;
                if (cJRCouponHeader == null) {
                    kotlin.g.b.k.a();
                }
                CJRCouponHeaderItem cJRCouponHeaderItem = cJRCouponHeader.getCouponHeaderItemList().get(i2);
                kotlin.g.b.k.a((Object) cJRCouponHeaderItem, "couponHeader!!.couponHeaderItemList[arg0]");
                sb.append(cJRCouponHeaderItem.getName());
                String sb2 = sb.toString();
                kotlin.g.b.k.c(sb2, SDKConstants.EVENT_KEY_SCREEN_NAME);
                net.one97.paytm.recharge.coupons.a.a aVar3 = aVar.f62266a;
                if (aVar3 != null) {
                    kotlin.g.b.k.c(sb2, "<set-?>");
                    aVar3.f62165f = sb2;
                }
                aVar.f62268c = sb2;
                return aVar;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.coupons.fragment.FJRDealCouponFragment");
        }

        public final int getCount() {
            CJRCouponHeader cJRCouponHeader = this.f62218e;
            if (cJRCouponHeader == null) {
                return 0;
            }
            ArrayList<CJRCouponHeaderItem> couponHeaderItemList = cJRCouponHeader != null ? cJRCouponHeader.getCouponHeaderItemList() : null;
            if (couponHeaderItemList == null) {
                kotlin.g.b.k.a();
            }
            return couponHeaderItemList.size();
        }

        public final Fragment a(int i2) {
            String str = this.f62215b.get(Integer.valueOf(i2));
            if (str == null) {
                ViewPager viewPager = (ViewPager) this.f62214a.a(R.id.dealViewPager);
                kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
                Object instantiateItem = instantiateItem(viewPager, i2);
                if (instantiateItem != null) {
                    return (Fragment) instantiateItem;
                }
                throw new kotlin.u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
            }
            kotlin.g.b.k.a((Object) str, "mFragmentTags[position]\n…er, position) as Fragment");
            return this.f62217d.c(str);
        }
    }

    public void onTabSelected(TabLayout.f fVar) {
        CJRCouponHeaderItem cJRCouponHeaderItem;
        if (!isFinishing()) {
            this.aj = true;
            f();
            String str = null;
            Integer valueOf = fVar != null ? Integer.valueOf(fVar.b()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            int intValue = valueOf.intValue();
            if (kotlin.m.p.a((CharSequence) this.al, (CharSequence) "metro", true)) {
                a(this.am, "coupon_category_clicked", String.valueOf(fVar.c()));
            }
            if (!this.m.containsKey(Integer.valueOf(intValue))) {
                ArrayList<CJRCouponHeaderItem> couponHeaderItemList = this.z.getCouponHeaderItemList();
                if (!(couponHeaderItemList == null || (cJRCouponHeaderItem = couponHeaderItemList.get(intValue)) == null)) {
                    str = cJRCouponHeaderItem.getUrl();
                }
                net.one97.paytm.recharge.coupons.e.a aVar = this.f62185b;
                if (aVar != null) {
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    Integer num = this.l.get(intValue);
                    kotlin.g.b.k.a((Object) num, "mPageIndexList[position]");
                    aVar.a(str, num.intValue(), this.N, this.f62190h);
                    return;
                }
                return;
            }
            c cVar = this.f62188f;
            Fragment a2 = cVar != null ? cVar.a(intValue) : null;
            if (!(a2 instanceof net.one97.paytm.recharge.coupons.b.a)) {
                a2 = null;
            }
            net.one97.paytm.recharge.coupons.b.a aVar2 = (net.one97.paytm.recharge.coupons.b.a) a2;
            CJRCouponGrid cJRCouponGrid = this.m.get(Integer.valueOf(intValue));
            if (cJRCouponGrid != null && aVar2 != null) {
                aVar2.a(cJRCouponGrid, this.j, this.f62190h, this.f62189g, (Integer) -1);
            }
        }
    }

    public final void b() {
        if (!this.x) {
            ViewPager viewPager = (ViewPager) a(R.id.dealViewPager);
            kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
            int currentItem = viewPager.getCurrentItem();
            if (this.k.get(currentItem).booleanValue()) {
                CJRCouponHeaderItem cJRCouponHeaderItem = this.z.getCouponHeaderItemList().get(currentItem);
                kotlin.g.b.k.a((Object) cJRCouponHeaderItem, "mCouponHeader.couponHeaderItemList[position]");
                String url = cJRCouponHeaderItem.getUrl();
                if (URLUtil.isValidUrl(url)) {
                    this.x = true;
                    Integer num = this.l.get(currentItem);
                    kotlin.g.b.k.a((Object) num, "mPageIndexList[position]");
                    this.l.add(currentItem, Integer.valueOf(num.intValue() + 1));
                    net.one97.paytm.recharge.coupons.e.a aVar = this.f62185b;
                    if (aVar != null) {
                        if (url == null) {
                            kotlin.g.b.k.a();
                        }
                        Integer num2 = this.l.get(currentItem);
                        kotlin.g.b.k.a((Object) num2, "mPageIndexList[position]");
                        aVar.a(url, num2.intValue(), this.N, this.f62190h);
                    }
                }
            }
        }
    }

    public final void f() {
        if (this.w) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.promoLayout);
            kotlin.g.b.k.a((Object) linearLayout, "promoLayout");
            if (linearLayout.getVisibility() != 8) {
                return;
            }
        }
        ((LinearLayout) a(R.id.proceedLayout)).setBackgroundResource(0);
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.promoLayout);
        kotlin.g.b.k.a((Object) linearLayout2, "promoLayout");
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = (LinearLayout) a(R.id.promoLayout);
        kotlin.g.b.k.a((Object) linearLayout3, "promoLayout");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) linearLayout3.getHeight(), 0.0f);
        translateAnimation.setDuration(300);
        this.w = true;
        ((LinearLayout) a(R.id.promoLayout)).startAnimation(translateAnimation);
    }

    public final void a(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        kotlin.g.b.k.c(str, "promoCode");
        net.one97.paytm.recharge.coupons.e.a aVar = this.f62185b;
        if (aVar != null && (dVar = aVar.p) != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.V, Utility.ACTION_PROMOCODE_ENTERED, (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public final void c() {
        CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) a(R.id.proceed);
        if (cJRProceedWidgetWithConvFeeV8 != null) {
            cJRProceedWidgetWithConvFeeV8.setEnabled(true);
        }
        h();
    }

    static final class al implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62213a;

        al(AJRCouponsActivityV8 aJRCouponsActivityV8) {
            this.f62213a = aJRCouponsActivityV8;
        }

        public final void run() {
            this.f62213a.f();
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        StringBuilder journeyStackTrace;
        View a2;
        if (str != null && str.hashCode() == -70453332 && str.equals("deal_verify") && (a2 = a(R.id.overlay_view)) != null) {
            net.one97.paytm.recharge.common.utils.ai.b(a2);
        }
        if (networkCustomError instanceof NetworkCustomError) {
            c();
            com.paytm.utility.q.d(networkCustomError.getMessage());
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                ay.a(true);
                if (obj instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.AUTH);
                    CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.AUTH.name());
                    }
                    CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setAlertType("");
                    }
                    CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
                    if (!(flowName3 == null || (journeyStackTrace = flowName3.getJourneyStackTrace()) == null)) {
                        kotlin.m.p.a(journeyStackTrace);
                    }
                    az azVar = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                }
                Intent intent = getIntent();
                kotlin.g.b.k.a((Object) intent, "intent");
                CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert((Activity) this, (String) null, intent.getExtras(), networkCustomError, false, true, 3);
            } else {
                super.a(str, networkCustomError, obj);
            }
        } else {
            super.a(str, networkCustomError, obj);
            if (networkCustomError != null) {
                String str2 = this.am;
                String message = networkCustomError.getMessage();
                if (message == null) {
                    kotlin.g.b.k.a();
                }
                a(str2, "apply_promocode_failed", message);
            }
        }
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_insurance);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.recharge.common.c.c cVar = this.ag;
        if (cVar != null) {
            if (cVar.f60961a) {
                cVar.b();
            }
            cVar.a(8);
        }
        if (kotlin.m.p.a("insurance_remove", str, true)) {
            CheckBox checkBox = (CheckBox) a(R.id.insuranceCheckbox);
            kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
            if (!checkBox.isChecked()) {
                CheckBox checkBox2 = (CheckBox) a(R.id.insuranceCheckbox);
                kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
                checkBox2.setChecked(true);
            }
        }
        CheckBox checkBox3 = (CheckBox) a(R.id.insuranceCheckbox);
        kotlin.g.b.k.a((Object) checkBox3, "insuranceCheckbox");
        checkBox3.setEnabled(true);
        CheckBox checkBox4 = (CheckBox) a(R.id.insuranceCheckbox);
        kotlin.g.b.k.a((Object) checkBox4, "insuranceCheckbox");
        checkBox4.setClickable(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        bundle.putSerializable("insurance_details", this.F);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        net.one97.paytm.recharge.common.utils.o oVar;
        this.F = (CJRPersonalInsurance) (bundle != null ? bundle.getSerializable("insurance_details") : null);
        CJRPersonalInsurance cJRPersonalInsurance = this.F;
        if (!(cJRPersonalInsurance == null || (oVar = this.ao) == null)) {
            if (cJRPersonalInsurance == null) {
                kotlin.g.b.k.a();
            }
            oVar.a(cJRPersonalInsurance);
        }
        super.onRestoreInstanceState(bundle);
    }

    public final void a(String str, String str2, String str3) {
        kotlin.g.b.k.c(str, "event_category");
        kotlin.g.b.k.c(str2, "action");
        kotlin.g.b.k.c(str3, "event_label");
        try {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            String i2 = c.a.i(str);
            if (TextUtils.isEmpty(i2)) {
                i2 = !TextUtils.isEmpty(this.V) ? this.V : "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", i2);
            hashMap.put("event_action", str2);
            Map map = hashMap;
            String str4 = "/coupon";
            if (!TextUtils.isEmpty(i2)) {
                str4 = "/" + i2 + str4;
            }
            map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str4);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("event_label", str3);
            }
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, (Context) this);
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        c.d dVar = this.q;
        if (dVar != null) {
            dVar.f60969b = null;
        }
        this.q = null;
        this.ag = null;
        this.ah = null;
        this.ai = null;
        az azVar = az.f61525a;
        net.one97.paytm.recharge.common.utils.o a2 = az.a();
        if (a2 != null) {
            a2.f61687d = null;
        }
        az azVar2 = az.f61525a;
        az.a((net.one97.paytm.recharge.common.utils.o) null);
        if (!(this.ar == null || this.as == null)) {
            n();
            this.ar = null;
            this.as = null;
        }
        super.onDestroy();
    }

    public final void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart) {
        net.one97.paytm.recharge.coupons.e.a aVar;
        kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
        this.f62186c = cJRRechargeCart;
        if (this.f62186c == null) {
            finish();
        }
        CJRRechargeCart cJRRechargeCart2 = this.f62186c;
        if (cJRRechargeCart2 == null) {
            kotlin.g.b.k.a();
        }
        if (cJRPromoCode != null) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.promoApplied);
            kotlin.g.b.k.a((Object) relativeLayout, "promoApplied");
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) a(R.id.havePromoText);
            kotlin.g.b.k.a((Object) textView, "havePromoText");
            textView.setVisibility(8);
            TextView textView2 = (TextView) a(R.id.promoText);
            kotlin.g.b.k.a((Object) textView2, "promoText");
            kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
            String string = getString(R.string.offer_applied_txt);
            kotlin.g.b.k.a((Object) string, "getString(R.string.offer_applied_txt)");
            String format = String.format(string, Arrays.copyOf(new Object[]{cJRPromoCode.getCode()}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
            String code = cJRPromoCode.getCode();
            if (code == null) {
                code = "";
            }
            this.U = code;
            CJRCart cart = cJRRechargeCart2.getCart();
            kotlin.g.b.k.a((Object) cart, "rechargeCart.cart");
            kotlin.o<Boolean, String> a2 = a(cart, false, "");
            a(a2.getSecond(), cJRPromoCode.getTerms(), a2.getFirst().booleanValue());
            this.I = a(cJRRechargeCart2.getCart());
            k();
            if (TextUtils.isEmpty(cJRPromoCode.getTerms()) && (aVar = this.f62185b) != null) {
                String str = this.U;
                kotlin.g.b.k.c(str, "promoCode");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar.f62287h.a("fetch_promo_term_condition", str, aVar, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.PROMO_TNC, ERROR_TYPE.UNDEFINED));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, boolean z2) {
        TextView textView = (TextView) a(R.id.promoOfferDetail);
        kotlin.g.b.k.a((Object) textView, "promoOfferDetail");
        textView.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
        ((TextView) a(R.id.promoOfferDetail)).setOnClickListener(new g(this, z2, str, str2));
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62230a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f62231b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62232c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f62233d;

        g(AJRCouponsActivityV8 aJRCouponsActivityV8, boolean z, String str, String str2) {
            this.f62230a = aJRCouponsActivityV8;
            this.f62231b = z;
            this.f62232c = str;
            this.f62233d = str2;
        }

        public final void onClick(View view) {
            if (this.f62231b) {
                if (this.f62230a.ai == null) {
                    this.f62230a.ai = new net.one97.paytm.recharge.common.c.d();
                }
                Bundle bundle = new Bundle();
                bundle.putString("tnc_title", this.f62232c);
                bundle.putString("tnc_text", this.f62233d);
                net.one97.paytm.recharge.common.c.d N = this.f62230a.ai;
                if (N == null) {
                    kotlin.g.b.k.a();
                }
                N.setArguments(bundle);
            }
            AJRCouponsActivityV8.O(this.f62230a);
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "cjrRechargeCart");
        this.f62186c = cJRRechargeCart;
        b(cJRRechargeCart);
    }

    public final void a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, (String) null, this, (Fragment) null, networkCustomError, false, 3, (Object) null, 20, (Object) null);
    }

    public final void a(Integer num, String str, String str2) {
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.UNDEFINED, ACTION_TYPE.DEAL_PROCEED, str, str2);
    }

    public final class d<T> implements androidx.lifecycle.z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCouponsActivityV8 f62219a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.lifecycle.y<T> f62220b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f62221c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f62222d = true;

        /* JADX WARNING: type inference failed for: r1v0, types: [androidx.lifecycle.y<T>, net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8] */
        /* JADX WARNING: type inference failed for: r2v0, types: [androidx.lifecycle.y<T>, boolean] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(androidx.lifecycle.y<T> r1, boolean r2, boolean r3) {
            /*
                r0 = this;
                r0.f62219a = r1
                r0.<init>()
                r0.f62220b = r2
                r0.f62221c = r3
                r1 = 1
                r0.f62222d = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.d.<init>(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, androidx.lifecycle.y, boolean):void");
        }

        public final void onChanged(T t) {
            if (t instanceof CJRRechargeCart) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) t;
                if (cJRRechargeCart.getCart() != null && this.f62222d) {
                    androidx.lifecycle.y<T> yVar = this.f62220b;
                    if (yVar != null) {
                        yVar.removeObserver(this);
                    }
                    this.f62222d = false;
                    try {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f62219a.a(R.id.shimmer_insurance);
                        if (shimmerFrameLayout != null) {
                            shimmerFrameLayout.b();
                        }
                    } catch (Exception unused) {
                    }
                    CheckBox checkBox = (CheckBox) this.f62219a.a(R.id.insuranceCheckbox);
                    kotlin.g.b.k.a((Object) checkBox, "insuranceCheckbox");
                    checkBox.setClickable(true);
                    CheckBox checkBox2 = (CheckBox) this.f62219a.a(R.id.insuranceCheckbox);
                    kotlin.g.b.k.a((Object) checkBox2, "insuranceCheckbox");
                    checkBox2.setEnabled(true);
                    CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                    CJRCart cJRCart = null;
                    if (kotlin.m.p.a(cartStatus != null ? cartStatus.getResult() : null, "SUCCESS", true)) {
                        az azVar = az.f61525a;
                        if (!az.a((Context) this.f62219a, cJRRechargeCart, ACTION_TYPE.INSURANCE_VERIFY)) {
                            AJRCouponsActivityV8 aJRCouponsActivityV8 = this.f62219a;
                            aJRCouponsActivityV8.f62186c = cJRRechargeCart;
                            if (this.f62221c) {
                                CheckBox checkBox3 = (CheckBox) aJRCouponsActivityV8.a(R.id.insuranceCheckbox);
                                kotlin.g.b.k.a((Object) checkBox3, "insuranceCheckbox");
                                if (!checkBox3.isChecked()) {
                                    CheckBox checkBox4 = (CheckBox) this.f62219a.a(R.id.insuranceCheckbox);
                                    kotlin.g.b.k.a((Object) checkBox4, "insuranceCheckbox");
                                    checkBox4.setChecked(true);
                                }
                                AJRCouponsActivityV8.f(this.f62219a);
                            } else {
                                AJRCouponsActivityV8.g(aJRCouponsActivityV8);
                            }
                            AJRCouponsActivityV8.b(this.f62219a, cJRRechargeCart);
                            AJRCouponsActivityV8 aJRCouponsActivityV82 = this.f62219a;
                            CJRRechargeCart cJRRechargeCart2 = aJRCouponsActivityV82.f62186c;
                            if (cJRRechargeCart2 != null) {
                                cJRCart = cJRRechargeCart2.getCart();
                            }
                            aJRCouponsActivityV82.I = aJRCouponsActivityV82.a(cJRCart);
                            this.f62219a.k();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void n() {
        View a2 = a(R.id.overlay_view);
        if (a2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(a2);
        }
        Handler handler = this.ar;
        if (handler != null) {
            handler.removeCallbacks(this.as);
        }
    }

    public static final /* synthetic */ void f(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        TextView textView = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceText);
        kotlin.g.b.k.a((Object) textView, "tvInsuranceText");
        textView.setVisibility(8);
        TextView textView2 = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceSelectedText);
        kotlin.g.b.k.a((Object) textView2, "tvInsuranceSelectedText");
        textView2.setVisibility(0);
        TextView textView3 = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceSelectedTermsText);
        kotlin.g.b.k.a((Object) textView3, "tvInsuranceSelectedTermsText");
        textView3.setVisibility(0);
        CJRAmountView cJRAmountView = (CJRAmountView) aJRCouponsActivityV8.a(R.id.tvInsuranceAmountText);
        kotlin.g.b.k.a((Object) cJRAmountView, "tvInsuranceAmountText");
        cJRAmountView.setVisibility(0);
        TextView textView4 = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceSelectedText);
        kotlin.g.b.k.a((Object) textView4, "tvInsuranceSelectedText");
        CJRPersonalInsurance cJRPersonalInsurance = aJRCouponsActivityV8.F;
        String str = null;
        textView4.setText(cJRPersonalInsurance != null ? cJRPersonalInsurance.name : null);
        ((CJRAmountView) aJRCouponsActivityV8.a(R.id.tvInsuranceAmountText)).a(true);
        CJRAmountView cJRAmountView2 = (CJRAmountView) aJRCouponsActivityV8.a(R.id.tvInsuranceAmountText);
        CJRPersonalInsurance cJRPersonalInsurance2 = aJRCouponsActivityV8.F;
        if (cJRPersonalInsurance2 != null) {
            str = cJRPersonalInsurance2.getPriceForPersonalInsurance();
        }
        cJRAmountView2.setText(str);
    }

    public static final /* synthetic */ void g(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        TextView textView = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceText);
        kotlin.g.b.k.a((Object) textView, "tvInsuranceText");
        textView.setVisibility(0);
        TextView textView2 = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceSelectedText);
        kotlin.g.b.k.a((Object) textView2, "tvInsuranceSelectedText");
        textView2.setVisibility(8);
        TextView textView3 = (TextView) aJRCouponsActivityV8.a(R.id.tvInsuranceSelectedTermsText);
        kotlin.g.b.k.a((Object) textView3, "tvInsuranceSelectedTermsText");
        textView3.setVisibility(8);
        CJRAmountView cJRAmountView = (CJRAmountView) aJRCouponsActivityV8.a(R.id.tvInsuranceAmountText);
        kotlin.g.b.k.a((Object) cJRAmountView, "tvInsuranceAmountText");
        cJRAmountView.setVisibility(8);
    }

    public static final /* synthetic */ void b(AJRCouponsActivityV8 aJRCouponsActivityV8, CJRRechargeCart cJRRechargeCart) {
        CJRCart cart = cJRRechargeCart.getCart();
        kotlin.g.b.k.a((Object) cart, "it.cart");
        if (!TextUtils.isEmpty(cart.getPromoStatus())) {
            CJRCart cart2 = cJRRechargeCart.getCart();
            kotlin.g.b.k.a((Object) cart2, "it.cart");
            if (kotlin.m.p.a(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, cart2.getPromoStatus(), true) && !TextUtils.isEmpty(aJRCouponsActivityV8.U)) {
                ((ImageView) aJRCouponsActivityV8.a(R.id.removePromo)).performClick();
            }
        }
    }

    public static final /* synthetic */ SpannableString b(AJRCouponsActivityV8 aJRCouponsActivityV8, String str) {
        String str2 = " " + aJRCouponsActivityV8.getString(R.string.t_c_apply);
        SpannableString spannableString = new SpannableString(str + str2 + " ");
        ak akVar = new ak(aJRCouponsActivityV8);
        spannableString.setSpan(new aj(aJRCouponsActivityV8), 0, str.length(), 33);
        spannableString.setSpan(akVar, str.length() + 1, str.length() + str2.length(), 33);
        return spannableString;
    }

    public static final /* synthetic */ void b(AJRCouponsActivityV8 aJRCouponsActivityV8, CJRCouponHeader cJRCouponHeader) {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        androidx.fragment.app.j supportFragmentManager = aJRCouponsActivityV8.getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        aJRCouponsActivityV8.f62188f = new c(aJRCouponsActivityV8, supportFragmentManager, cJRCouponHeader);
        ViewPager viewPager = (ViewPager) aJRCouponsActivityV8.a(R.id.dealViewPager);
        kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
        viewPager.setAdapter(aJRCouponsActivityV8.f62188f);
        ((TabLayout) aJRCouponsActivityV8.a(R.id.dealTabs)).setupWithViewPager((ViewPager) aJRCouponsActivityV8.a(R.id.dealViewPager));
        ViewPager viewPager2 = (ViewPager) aJRCouponsActivityV8.a(R.id.dealViewPager);
        kotlin.g.b.k.a((Object) viewPager2, "dealViewPager");
        viewPager2.setOffscreenPageLimit(3);
        ((TabLayout) aJRCouponsActivityV8.a(R.id.dealTabs)).a((TabLayout.b) aJRCouponsActivityV8);
        aJRCouponsActivityV8.onTabSelected(((TabLayout) aJRCouponsActivityV8.a(R.id.dealTabs)).a(0));
        ((ViewPager) aJRCouponsActivityV8.a(R.id.dealViewPager)).addOnPageChangeListener(new x(aJRCouponsActivityV8));
        if (aJRCouponsActivityV8 == null) {
            kotlin.g.b.k.a();
        }
        aJRCouponsActivityV8.r = (net.one97.paytm.recharge.coupons.e.b) am.a((FragmentActivity) aJRCouponsActivityV8).a(net.one97.paytm.recharge.coupons.e.b.class);
        net.one97.paytm.recharge.coupons.e.b bVar = aJRCouponsActivityV8.r;
        if (!(bVar == null || (liveData3 = bVar.f62289a) == null)) {
            liveData3.observe(aJRCouponsActivityV8, new y(aJRCouponsActivityV8));
        }
        net.one97.paytm.recharge.coupons.e.b bVar2 = aJRCouponsActivityV8.r;
        if (!(bVar2 == null || (liveData2 = bVar2.f62290b) == null)) {
            liveData2.observe(aJRCouponsActivityV8, new z(aJRCouponsActivityV8));
        }
        net.one97.paytm.recharge.coupons.e.b bVar3 = aJRCouponsActivityV8.r;
        if (bVar3 != null && (liveData = bVar3.f62291c) != null) {
            liveData.observe(aJRCouponsActivityV8, new aa(aJRCouponsActivityV8));
        }
    }

    public static final /* synthetic */ void a(AJRCouponsActivityV8 aJRCouponsActivityV8, CJRCouponGrid cJRCouponGrid) {
        Fragment fragment;
        net.one97.paytm.recharge.coupons.a.a aVar;
        com.paytm.utility.b.j();
        if (cJRCouponGrid != null) {
            c cVar = aJRCouponsActivityV8.f62188f;
            if (cVar != null) {
                ViewPager viewPager = (ViewPager) aJRCouponsActivityV8.a(R.id.dealViewPager);
                kotlin.g.b.k.a((Object) viewPager, "dealViewPager");
                fragment = cVar.a(viewPager.getCurrentItem());
            } else {
                fragment = null;
            }
            if (!(fragment instanceof net.one97.paytm.recharge.coupons.b.a)) {
                fragment = null;
            }
            net.one97.paytm.recharge.coupons.b.a aVar2 = (net.one97.paytm.recharge.coupons.b.a) fragment;
            if (aVar2 != null) {
                IJRDataModel iJRDataModel = cJRCouponGrid;
                ArrayList<String> arrayList = aJRCouponsActivityV8.j;
                ArrayList<CJRSelectedRecharge> arrayList2 = aJRCouponsActivityV8.f62190h;
                kotlin.g.b.k.c(iJRDataModel, "dataModel");
                kotlin.g.b.k.c(arrayList, "selectedCouponList");
                kotlin.g.b.k.c(arrayList2, "selectedRechargeIdList");
                aVar2.f62267b = (CJRCouponGrid) iJRDataModel;
                if (!(aVar2.f62266a == null || aVar2.f62267b.getGridLayout() == null || (aVar = aVar2.f62266a) == null)) {
                    ArrayList<CJRGridProduct> gridLayout = aVar2.f62267b.getGridLayout();
                    kotlin.g.b.k.a((Object) gridLayout, "mCouponGrid.gridLayout");
                    kotlin.g.b.k.c(gridLayout, "couponList");
                    kotlin.g.b.k.c(arrayList, "selectedCouponList");
                    kotlin.g.b.k.c(arrayList2, "selectedRechargeIdList");
                    Iterator<CJRGridProduct> it2 = gridLayout.iterator();
                    while (it2.hasNext()) {
                        aVar.f62164e.add(it2.next());
                    }
                    aVar.f62160a = arrayList;
                    aVar.f62161b = arrayList2;
                    aVar.notifyDataSetChanged();
                }
                aVar2.b();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        if (r1 != null) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r9, net.one97.paytm.recharge.model.CJRCouponGrid r10) {
        /*
            com.paytm.utility.b.j()
            if (r10 == 0) goto L_0x00bc
            java.util.HashMap<java.lang.Integer, net.one97.paytm.recharge.model.CJRCouponGrid> r0 = r9.m
            int r1 = net.one97.paytm.recharge.R.id.dealViewPager
            android.view.View r1 = r9.a((int) r1)
            androidx.viewpager.widget.ViewPager r1 = (androidx.viewpager.widget.ViewPager) r1
            java.lang.String r2 = "dealViewPager"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r1 = r1.getCurrentItem()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.put(r1, r10)
            net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8$c r0 = r9.f62188f
            r1 = 0
            if (r0 == 0) goto L_0x0038
            int r3 = net.one97.paytm.recharge.R.id.dealViewPager
            android.view.View r3 = r9.a((int) r3)
            androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            int r3 = r3.getCurrentItem()
            androidx.fragment.app.Fragment r0 = r0.a(r3)
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            boolean r3 = r0 instanceof net.one97.paytm.recharge.coupons.b.a
            if (r3 != 0) goto L_0x003e
            r0 = r1
        L_0x003e:
            net.one97.paytm.recharge.coupons.b.a r0 = (net.one97.paytm.recharge.coupons.b.a) r0
            net.one97.paytm.recharge.model.CJRCouponHeader r1 = r9.z
            if (r1 == 0) goto L_0x0067
            java.util.ArrayList r1 = r1.getCouponHeaderItemList()
            if (r1 == 0) goto L_0x0067
            int r3 = net.one97.paytm.recharge.R.id.dealViewPager
            android.view.View r3 = r9.a((int) r3)
            androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            int r2 = r3.getCurrentItem()
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.recharge.model.CJRCouponHeaderItem r1 = (net.one97.paytm.recharge.model.CJRCouponHeaderItem) r1
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x0069
        L_0x0067:
            java.lang.String r1 = ""
        L_0x0069:
            r7 = r1
            if (r0 == 0) goto L_0x00bc
            net.one97.paytm.common.entity.IJRDataModel r10 = (net.one97.paytm.common.entity.IJRDataModel) r10
            java.util.ArrayList<java.lang.String> r4 = r9.j
            java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRSelectedRecharge> r5 = r9.f62190h
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r9.f62189g
            if (r7 != 0) goto L_0x0079
            kotlin.g.b.k.a()
        L_0x0079:
            java.lang.String r9 = "dataModel"
            kotlin.g.b.k.c(r10, r9)
            java.lang.String r9 = "selectedCouponList"
            kotlin.g.b.k.c(r4, r9)
            java.lang.String r9 = "selectedRechargeIdList"
            kotlin.g.b.k.c(r5, r9)
            java.lang.String r9 = "rechargeConfig"
            kotlin.g.b.k.c(r6, r9)
            java.lang.String r9 = "gtmCategory"
            kotlin.g.b.k.c(r7, r9)
            net.one97.paytm.recharge.model.CJRCouponGrid r10 = (net.one97.paytm.recharge.model.CJRCouponGrid) r10
            r0.f62267b = r10
            net.one97.paytm.recharge.coupons.a.a r9 = r0.f62266a
            if (r9 == 0) goto L_0x00b9
            net.one97.paytm.recharge.model.CJRCouponGrid r9 = r0.f62267b
            java.util.ArrayList r9 = r9.getGridLayout()
            if (r9 == 0) goto L_0x00b9
            net.one97.paytm.recharge.coupons.a.a r2 = r0.f62266a
            if (r2 == 0) goto L_0x00b9
            net.one97.paytm.recharge.model.CJRCouponGrid r9 = r0.f62267b
            java.util.ArrayList r3 = r9.getGridLayout()
            java.lang.String r9 = "mCouponGrid.gridLayout"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r9)
            r9 = -1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            r2.a(r3, r4, r5, r6, r7, r8)
        L_0x00b9:
            r0.b()
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.b(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, net.one97.paytm.recharge.model.CJRCouponGrid):void");
    }

    public static final /* synthetic */ void a(AJRCouponsActivityV8 aJRCouponsActivityV8, CJRRechargeCart cJRRechargeCart, String str, CJROfferCode cJROfferCode) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        ArrayList<CJRCartProduct> cartItems;
        CJRCartProduct cJRCartProduct;
        AJRCouponsActivityV8 aJRCouponsActivityV82 = aJRCouponsActivityV8;
        CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        String str2 = str;
        CJROfferCode cJROfferCode2 = cJROfferCode;
        String str3 = null;
        if ((cJRRechargeCart2 != null ? cJRRechargeCart.getCart() : null) != null) {
            CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
            if (kotlin.m.p.a(cartStatus != null ? cartStatus.getResult() : null, "SUCCESS", true)) {
                az azVar = az.f61525a;
                if (!az.a((Context) aJRCouponsActivityV82, cJRRechargeCart2, ACTION_TYPE.PROMO_VERIFY)) {
                    CJRCart cart = cJRRechargeCart.getCart();
                    if (!(cart == null || (cartItems = cart.getCartItems()) == null || (cJRCartProduct = cartItems.get(0)) == null)) {
                        str3 = cJRCartProduct.getPromoCode();
                    }
                    if (cart != null && !aJRCouponsActivityV82.ab && !aJRCouponsActivityV82.ad && aJRCouponsActivityV82.ac) {
                        aJRCouponsActivityV82.ac = false;
                        if (str3 == null && kotlin.m.p.a(cart.getPromoStatus(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true)) {
                            try {
                                net.one97.paytm.recharge.coupons.e.a aVar = aJRCouponsActivityV82.f62185b;
                                if (!(aVar == null || (dVar2 = aVar.p) == null)) {
                                    String str4 = aJRCouponsActivityV82.V;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str2);
                                    sb.append("/");
                                    CJRCart cart2 = cJRRechargeCart.getCart();
                                    kotlin.g.b.k.a((Object) cart2, "rechargeCart.cart");
                                    sb.append(cart2.getPromoFailureText());
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, str4, "apply_promocode_failed", (Object) null, sb.toString(), (Object) null, (Object) null, (Object) null, 116);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (str3 != null && kotlin.m.p.a(cart.getPromoStatus(), "Success", true) && kotlin.m.p.a(str3, str2, true)) {
                            if (cJROfferCode2 == null) {
                                net.one97.paytm.recharge.coupons.e.a aVar2 = aJRCouponsActivityV82.f62185b;
                                if (!(aVar2 == null || (dVar = aVar2.p) == null)) {
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, aJRCouponsActivityV82.V, "apply_promocode_success", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
                                }
                                RelativeLayout relativeLayout = (RelativeLayout) aJRCouponsActivityV82.a(R.id.promoApplied);
                                kotlin.g.b.k.a((Object) relativeLayout, "promoApplied");
                                relativeLayout.setVisibility(0);
                                TextView textView = (TextView) aJRCouponsActivityV82.a(R.id.havePromoText);
                                kotlin.g.b.k.a((Object) textView, "havePromoText");
                                textView.setVisibility(8);
                                TextView textView2 = (TextView) aJRCouponsActivityV82.a(R.id.promoOfferDetail);
                                kotlin.g.b.k.a((Object) textView2, "promoOfferDetail");
                                textView2.setVisibility(8);
                                TextView textView3 = (TextView) aJRCouponsActivityV82.a(R.id.promoText);
                                kotlin.g.b.k.a((Object) textView3, "promoText");
                                kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
                                String string = aJRCouponsActivityV82.getString(R.string.offer_applied_txt);
                                kotlin.g.b.k.a((Object) string, "getString(R.string.offer_applied_txt)");
                                String format = String.format(string, Arrays.copyOf(new Object[]{str2}, 1));
                                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                                textView3.setText(format);
                                aJRCouponsActivityV82.U = str2;
                                aJRCouponsActivityV82.a(cart, false, "");
                                return;
                            }
                            aJRCouponsActivityV82.a(cJROfferCode2, cart);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.common.entity.shopping.CJROfferCode c(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r6, java.lang.String r7) {
        /*
            androidx.lifecycle.y<net.one97.paytm.common.entity.shopping.CJROffers> r6 = r6.p
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x0045
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.common.entity.shopping.CJROffers r6 = (net.one97.paytm.common.entity.shopping.CJROffers) r6
            if (r6 == 0) goto L_0x0045
            java.util.ArrayList r6 = r6.getOfferCodes()
            if (r6 == 0) goto L_0x0045
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r6 = r6.iterator()
        L_0x0021:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r6.next()
            r4 = r3
            net.one97.paytm.common.entity.shopping.CJROfferCode r4 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r4
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getCode()
            boolean r4 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r0)
            if (r4 == 0) goto L_0x0021
            r2.add(r3)
            goto L_0x0021
        L_0x0041:
            r6 = r2
            java.util.List r6 = (java.util.List) r6
            goto L_0x0046
        L_0x0045:
            r6 = r1
        L_0x0046:
            if (r6 == 0) goto L_0x005a
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r0
            if (r7 == 0) goto L_0x005a
            r7 = 0
            java.lang.Object r6 = r6.get(r7)
            r1 = r6
            net.one97.paytm.common.entity.shopping.CJROfferCode r1 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r1
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.c(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, java.lang.String):net.one97.paytm.common.entity.shopping.CJROfferCode");
    }

    public static final /* synthetic */ void v(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) aJRCouponsActivityV8.a(R.id.expandMenu), "rotation", new float[]{-180.0f, 0.0f});
        kotlin.g.b.k.a((Object) ofFloat, "imageViewObjectAnimator");
        ofFloat.setDuration(500);
        ofFloat.start();
    }

    public static final /* synthetic */ void w(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) aJRCouponsActivityV8.a(R.id.expandMenu), "rotation", new float[]{0.0f, -180.0f});
        kotlin.g.b.k.a((Object) ofFloat, "imageViewObjectAnimator");
        ofFloat.setDuration(500);
        ofFloat.start();
    }

    public static final /* synthetic */ void x(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        net.one97.paytm.recharge.common.c.c cVar;
        try {
            net.one97.paytm.recharge.common.utils.o oVar = aJRCouponsActivityV8.ao;
            if (oVar == null || !oVar.e()) {
                net.one97.paytm.recharge.common.c.c cVar2 = aJRCouponsActivityV8.ag;
                if ((cVar2 != null ? cVar2.getFragmentManager() : null) == null && (cVar = aJRCouponsActivityV8.ag) != null && !cVar.isAdded()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("operator_name", aJRCouponsActivityV8.al);
                    net.one97.paytm.recharge.common.c.c cVar3 = aJRCouponsActivityV8.ag;
                    if (cVar3 != null) {
                        cVar3.setArguments(bundle);
                    }
                    net.one97.paytm.recharge.common.c.c cVar4 = aJRCouponsActivityV8.ag;
                    if (cVar4 != null) {
                        androidx.fragment.app.j supportFragmentManager = aJRCouponsActivityV8.getSupportFragmentManager();
                        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
                        cVar4.show(supportFragmentManager, au);
                        return;
                    }
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.common.utils.o oVar2 = aJRCouponsActivityV8.ao;
            if (oVar2 != null) {
                oVar2.c();
            }
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void A(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8 = (CJRProceedWidgetWithConvFeeV8) aJRCouponsActivityV8.a(R.id.proceed);
        if (cJRProceedWidgetWithConvFeeV8 != null) {
            RelativeLayout relativeLayout = (RelativeLayout) cJRProceedWidgetWithConvFeeV8.a(net.one97.paytm.recharge.widgets.R.id.lyt_proceed_btn);
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(net.one97.paytm.recharge.widgets.R.drawable.proceed_animation_bg);
            }
            TextView textView = (TextView) cJRProceedWidgetWithConvFeeV8.a(net.one97.paytm.recharge.widgets.R.id.txt_amount);
            if (textView != null) {
                textView.setVisibility(4);
            }
            TextView textView2 = (TextView) cJRProceedWidgetWithConvFeeV8.a(net.one97.paytm.recharge.widgets.R.id.txt_conv_fee);
            if (TextUtils.isEmpty(textView2 != null ? textView2.getText() : null)) {
                TextView textView3 = (TextView) cJRProceedWidgetWithConvFeeV8.a(net.one97.paytm.recharge.widgets.R.id.txt_conv_fee);
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            } else {
                TextView textView4 = (TextView) cJRProceedWidgetWithConvFeeV8.a(net.one97.paytm.recharge.widgets.R.id.txt_conv_fee);
                if (textView4 != null) {
                    textView4.setVisibility(4);
                }
            }
            CJRProceedWidgetWithConvFeeV8.a((LottieAnimationView) cJRProceedWidgetWithConvFeeV8.f64981a);
        }
        FrameLayout frameLayout = (FrameLayout) aJRCouponsActivityV8.a(R.id.transparent_view_1);
        if (frameLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.a(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) aJRCouponsActivityV8.a(R.id.transparent_view_2);
        if (frameLayout2 != null) {
            net.one97.paytm.recharge.common.utils.ai.a(frameLayout2);
        }
    }

    public static final /* synthetic */ void B(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        StringBuilder journeyStackTrace;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        ay ayVar = ay.f61523a;
        ay.a(ERROR_TYPE.UNDEFINED, ACTION_TYPE.DEAL_PROCEED, a2);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (!(flowName2 == null || (journeyStackTrace = flowName2.getJourneyStackTrace()) == null)) {
            journeyStackTrace.append("- dealProceedFlow");
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEAL_PROCEED);
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEAL_PROCEED);
        net.one97.paytm.recharge.coupons.e.a aVar = aJRCouponsActivityV8.f62185b;
        if (aVar != null) {
            boolean z2 = aJRCouponsActivityV8.af;
            JSONObject a3 = a(aJRCouponsActivityV8, aJRCouponsActivityV8.U, (String) null, false, false, 30);
            kotlin.g.b.k.c("deal_proceed_verify", "tag");
            kotlin.g.b.k.c(a3, "jsonCart");
            net.one97.paytm.recharge.common.utils.w wVar = aVar.f62288i;
            if (wVar != null) {
                kotlin.g.b.k.c("deal_proceed_verify", "tag");
                kotlin.g.b.k.c(a3, "jsonCart");
                kotlin.g.b.k.c("coupon", SDKConstants.EVENT_KEY_SCREEN_NAME);
                if (!wVar.k) {
                    wVar.l = false;
                    wVar.f61783c = true;
                    wVar.f61784d = true;
                    wVar.f61785e = false;
                    wVar.f61786f = z2;
                    wVar.m = true;
                    if (a3.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS) instanceof JSONObject) {
                        Object obj = a3.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                        if (obj != null) {
                            wVar.f61782b = (JSONObject) obj;
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    }
                    az azVar = az.f61525a;
                    wVar.n = az.a(a3);
                    if (a2 instanceof CJRRechargeErrorModel) {
                        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        String a4 = net.one97.paytm.recharge.widgets.c.d.a(a3);
                        CRUFlowModel flowName3 = a2.getFlowName();
                        if (flowName3 != null) {
                            flowName3.setRequestBody(a4);
                        }
                    }
                    net.one97.paytm.recharge.common.b.c cVar = wVar.f61789i;
                    if (cVar != null) {
                        cVar.a("deal_proceed_verify", wVar, a3, "coupon", a.b.USER_FACING, a2, 0, true);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void I(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        RelativeLayout relativeLayout = (RelativeLayout) aJRCouponsActivityV8.a(R.id.expandWidget);
        kotlin.g.b.k.a((Object) relativeLayout, "expandWidget");
        relativeLayout.setVisibility(0);
        CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = (CJRDealSelectWidgetV8) aJRCouponsActivityV8.a(R.id.widgetSelectDeal);
        kotlin.g.b.k.a((Object) cJRDealSelectWidgetV8, "widgetSelectDeal");
        cJRDealSelectWidgetV8.setVisibility(0);
    }

    public static final /* synthetic */ void L(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        View a2;
        net.one97.paytm.recharge.common.utils.o oVar = aJRCouponsActivityV8.ao;
        if (oVar != null && oVar != null && oVar.f61684a && (a2 = aJRCouponsActivityV8.a(R.id.overlay_view)) != null) {
            net.one97.paytm.recharge.common.utils.ai.a(a2);
        }
    }

    public static final /* synthetic */ void M(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        RelativeLayout relativeLayout = (RelativeLayout) aJRCouponsActivityV8.a(R.id.expandWidget);
        kotlin.g.b.k.a((Object) relativeLayout, "expandWidget");
        relativeLayout.setVisibility(8);
        CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = (CJRDealSelectWidgetV8) aJRCouponsActivityV8.a(R.id.widgetSelectDeal);
        kotlin.g.b.k.a((Object) cJRDealSelectWidgetV8, "widgetSelectDeal");
        cJRDealSelectWidgetV8.setVisibility(8);
    }

    public static final /* synthetic */ void O(AJRCouponsActivityV8 aJRCouponsActivityV8) {
        net.one97.paytm.recharge.common.c.d dVar;
        net.one97.paytm.recharge.common.c.d dVar2 = aJRCouponsActivityV8.ai;
        if (dVar2 != null && dVar2 != null && !dVar2.isAdded()) {
            net.one97.paytm.recharge.common.c.d dVar3 = aJRCouponsActivityV8.ai;
            if ((dVar3 != null ? dVar3.getFragmentManager() : null) == null && (dVar = aJRCouponsActivityV8.ai) != null) {
                dVar.show(aJRCouponsActivityV8.getSupportFragmentManager(), au);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = r14.getCartStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8 r13, net.one97.paytm.common.entity.CJRRechargeCart r14, net.one97.paytm.common.entity.shopping.CJROfferCode r15) {
        /*
            r0 = 0
            if (r14 == 0) goto L_0x0008
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r14.getCart()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r1 == 0) goto L_0x00d2
            if (r14 == 0) goto L_0x0018
            net.one97.paytm.common.entity.shopping.CJRCartStatus r1 = r14.getCartStatus()     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r1.getResult()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.String r2 = "SUCCESS"
            r3 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x00d2
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x00d2 }
            r1 = r13
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x00d2 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROMO_VERIFY     // Catch:{ Exception -> 0x00d2 }
            boolean r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r1, (net.one97.paytm.common.entity.CJRRechargeCart) r14, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2)     // Catch:{ Exception -> 0x00d2 }
            if (r1 != 0) goto L_0x00d2
            if (r14 == 0) goto L_0x0036
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r14.getCart()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0037
        L_0x0036:
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x004c
            java.util.ArrayList r2 = r1.getCartItems()     // Catch:{ Exception -> 0x00d2 }
            if (r2 == 0) goto L_0x004c
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x00d2 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2     // Catch:{ Exception -> 0x00d2 }
            if (r2 == 0) goto L_0x004c
            java.lang.String r0 = r2.getPromoCode()     // Catch:{ Exception -> 0x00d2 }
        L_0x004c:
            if (r1 == 0) goto L_0x00d2
            boolean r2 = r13.ab     // Catch:{ Exception -> 0x00d2 }
            if (r2 != 0) goto L_0x00d2
            boolean r2 = r13.ad     // Catch:{ Exception -> 0x00d2 }
            if (r2 != 0) goto L_0x00d2
            boolean r2 = r13.ac     // Catch:{ Exception -> 0x00d2 }
            if (r2 != 0) goto L_0x00d2
            if (r0 != 0) goto L_0x00a4
            java.lang.String r2 = r1.getPromoStatus()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r4 = "failure"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x00d2 }
            if (r2 == 0) goto L_0x00a4
            net.one97.paytm.recharge.coupons.e.a r2 = r13.f62185b     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x00a4
            net.one97.paytm.recharge.ordersummary.h.d r4 = r2.p     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x00a4
            java.lang.String r5 = r13.V     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "apply_promocode_failed"
            r7 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r2.<init>()     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = r15.getCode()     // Catch:{ all -> 0x00a3 }
            r2.append(r8)     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ all -> 0x00a3 }
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)     // Catch:{ all -> 0x00a3 }
            java.lang.String r14 = r14.getPromoFailureText()     // Catch:{ all -> 0x00a3 }
            r2.append(r14)     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x00a3 }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 116(0x74, float:1.63E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00a3 }
            goto L_0x00a4
        L_0x00a3:
        L_0x00a4:
            if (r0 == 0) goto L_0x00d2
            java.lang.String r14 = r1.getPromoStatus()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r2 = "Success"
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x00d2 }
            if (r14 == 0) goto L_0x00d2
            java.lang.String r14 = r15.getCode()     // Catch:{ Exception -> 0x00d2 }
            boolean r14 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r14, (boolean) r3)     // Catch:{ Exception -> 0x00d2 }
            if (r14 == 0) goto L_0x00d2
            java.lang.String r14 = r13.al     // Catch:{ Exception -> 0x00d2 }
            if (r14 != 0) goto L_0x00c3
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00d2 }
        L_0x00c3:
            java.lang.String r2 = "apply_promocode_success"
            r13.a((java.lang.String) r14, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d2 }
            net.one97.paytm.recharge.common.c.c r14 = r13.ag     // Catch:{ Exception -> 0x00d2 }
            if (r14 == 0) goto L_0x00cf
            r14.dismissAllowingStateLoss()     // Catch:{ Exception -> 0x00d2 }
        L_0x00cf:
            r13.a((net.one97.paytm.common.entity.shopping.CJROfferCode) r15, (net.one97.paytm.common.entity.shopping.CJRCart) r1)     // Catch:{ Exception -> 0x00d2 }
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.a(net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8, net.one97.paytm.common.entity.CJRRechargeCart, net.one97.paytm.common.entity.shopping.CJROfferCode):void");
    }

    public static final /* synthetic */ void a(AJRCouponsActivityV8 aJRCouponsActivityV8, View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getHeight());
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
        aJRCouponsActivityV8.w = false;
        new Handler().postDelayed(new e(aJRCouponsActivityV8), 350);
    }
}
