package net.one97.paytm.recharge.mobile.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.sendbird.android.constant.StringSet;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.c.g;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.aa;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.common.widget.CustomSwitch;
import net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.model.v4.ErrorAction;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends d implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, ai, net.one97.paytm.recharge.common.e.i, net.one97.paytm.recharge.common.e.w, UtilityThinBannersLayout.b {
    /* access modifiers changed from: private */
    public static final String ag;
    public static final a y = new a((byte) 0);
    private boolean A = true;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private StringBuilder H;
    private net.one97.paytm.recharge.common.h.f I;
    private boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    private boolean M;
    private boolean N;
    private io.reactivex.rxjava3.b.c O;
    private final io.reactivex.rxjava3.j.b<String> P;
    private boolean Q;
    private boolean R;
    private boolean S;
    /* access modifiers changed from: private */
    public long T;
    /* access modifiers changed from: private */
    public boolean U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;
    /* access modifiers changed from: private */
    public boolean X;
    /* access modifiers changed from: private */
    public NestedScrollView Y;
    private boolean Z;
    private net.one97.paytm.recharge.common.c.g aa;
    private final View.OnClickListener ab;
    /* access modifiers changed from: private */
    public boolean ac;
    private final View.OnClickListener ad;
    private final g.a ae;
    private final HashMap<Object, Object> af;
    private HashMap ah;

    /* renamed from: f  reason: collision with root package name */
    private androidx.lifecycle.z<CJRBrowsePlanProductList> f63606f;
    /* access modifiers changed from: package-private */
    public CJRProductsItem n;
    /* access modifiers changed from: package-private */
    public CJRAmountInputFieldWidgetV8 o;
    List<CJRAggsItem> p;
    CJRMobileRadioGroupV8<?> q;
    /* access modifiers changed from: package-private */
    public StaticLayout r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    CJRSuccessRateAlertMessage w;
    aa x;
    private CJRInputFieldsItem z;

    public View b(int i2) {
        if (this.ah == null) {
            this.ah = new HashMap();
        }
        View view = (View) this.ah.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.ah.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onFocusChange(View view, boolean z2) {
    }

    public void u() {
        HashMap hashMap = this.ah;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRSetUserConsentApiResponse>, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRSetUserConsentApiResponse>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRSetUserConsentApiResponse> data) {
            CJRSetUserConsentApiResponse data2;
            Integer status;
            if (data != null && (data2 = data.getData()) != null && (status = data2.getStatus()) != null && status.intValue() == 200) {
                this.this$0.K = true;
            }
        }
    }

    static final class m extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRGetUserConsentApiResponse>, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRGetUserConsentApiResponse>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRGetUserConsentApiResponse> data) {
            DataState dataState;
            if (data != null) {
                if (!(data == null || (dataState = data.getDataState()) == null || g.f63646a[dataState.ordinal()] != 1)) {
                    this.this$0.d();
                }
                CJRGetUserConsentApiResponse data2 = data.getData();
                if (data2 != null) {
                    Integer status = data2.getStatus();
                    if (status != null && status.intValue() == 204) {
                        this.this$0.L = true;
                        f.c(this.this$0);
                        return;
                    }
                    this.this$0.d();
                }
            }
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends UnsubscribeApiResponse>, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<UnsubscribeApiResponse>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<UnsubscribeApiResponse> data) {
            DataState dataState;
            if (data != null && (dataState = data.getDataState()) != null && g.f63647b[dataState.ordinal()] == 1) {
                this.this$0.K = false;
            }
        }
    }

    static final class p<T> implements androidx.lifecycle.z<CJRBrowsePlanProductList> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63638a;

        p(f fVar) {
            this.f63638a = fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:111:0x0109 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0152  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0157  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r24
                net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
                r1 = r23
                if (r0 == 0) goto L_0x01d8
                net.one97.paytm.recharge.mobile.a.f r2 = r1.f63638a
                java.lang.String r3 = "selectedPlan"
                kotlin.g.b.k.c(r0, r3)
                r3 = 0
                r2.s = r3
                java.lang.Double r4 = r0.getPrice()
                r5 = 0
                if (r4 == 0) goto L_0x0022
                double r6 = r4.doubleValue()
                java.lang.String r4 = java.lang.String.valueOf(r6)
                goto L_0x0023
            L_0x0022:
                r4 = r5
            L_0x0023:
                r2.j((java.lang.String) r4)
                boolean r4 = r2.t
                if (r4 == 0) goto L_0x002d
                java.lang.String r4 = "amount field"
                goto L_0x0036
            L_0x002d:
                boolean r4 = r2.u
                if (r4 == 0) goto L_0x0034
                java.lang.String r4 = "prefilled"
                goto L_0x0036
            L_0x0034:
                java.lang.String r4 = "browse plan"
            L_0x0036:
                r13 = r4
                net.one97.paytm.recharge.mobile.d.a r4 = r2.f63600h
                if (r4 == 0) goto L_0x0048
                androidx.lifecycle.y<java.lang.String> r4 = r4.z
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x0048
                java.lang.Object r4 = r4.getValue()
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x0049
            L_0x0048:
                r4 = r5
            L_0x0049:
                java.lang.Double r6 = r0.getPrice()
                java.lang.String r7 = "selectedPlan.price"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                double r8 = r6.doubleValue()
                net.one97.paytm.recharge.mobile.d.a r6 = r2.f63600h
                if (r6 == 0) goto L_0x0067
                androidx.lifecycle.y<java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>> r6 = r6.f61414g
                androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
                if (r6 == 0) goto L_0x0067
                java.lang.Object r6 = r6.getValue()
                java.util.List r6 = (java.util.List) r6
                goto L_0x0068
            L_0x0067:
                r6 = r5
            L_0x0068:
                boolean r4 = net.one97.paytm.recharge.common.utils.az.a((java.lang.String) r4, (double) r8, (java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r6)
                java.lang.String r6 = ""
                if (r4 == 0) goto L_0x00af
                boolean r4 = r2.u
                if (r4 != 0) goto L_0x00af
                boolean r4 = r2.t
                if (r4 == 0) goto L_0x007d
                java.lang.String r4 = "amount entered"
                r21 = r4
                goto L_0x007f
            L_0x007d:
                r21 = r13
            L_0x007f:
                net.one97.paytm.recharge.ordersummary.h.d r14 = new net.one97.paytm.recharge.ordersummary.h.d
                android.content.Context r4 = r2.getContext()
                if (r4 != 0) goto L_0x008a
                kotlin.g.b.k.a()
            L_0x008a:
                java.lang.String r8 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
                r14.<init>(r4)
                net.one97.paytm.recharge.mobile.d.a r4 = r2.f63600h
                if (r4 == 0) goto L_0x009f
                java.lang.Object r4 = r4.e()
                if (r4 != 0) goto L_0x009d
                goto L_0x009f
            L_0x009d:
                r15 = r4
                goto L_0x00a0
            L_0x009f:
                r15 = r6
            L_0x00a0:
                r18 = 0
                r19 = 0
                r20 = 0
                r22 = 56
                java.lang.String r16 = "Last_recharge_amount_selected"
                java.lang.String r17 = ""
                net.one97.paytm.recharge.ordersummary.h.d.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            L_0x00af:
                android.content.Context r4 = r2.getContext()
                android.text.SpannableStringBuilder r15 = net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r4, (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0)
                r4 = r15
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x00ed
                net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r14 = r2.o
                if (r14 == 0) goto L_0x00e1
                java.lang.String r4 = "formattedPlanDesc"
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r4)
                int r4 = net.one97.paytm.recharge.R.string.action_view_all
                java.lang.String r4 = r2.getString(r4)
                java.lang.String r8 = "getString(R.string.action_view_all)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
                int r17 = net.one97.paytm.recharge.R.color.color_00b9f5
                r18 = 2
                android.text.StaticLayout r8 = r2.r
                r16 = r4
                r19 = r8
                r14.a(r15, r16, r17, r18, r19)
            L_0x00e1:
                net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r4 = r2.o
                if (r4 == 0) goto L_0x00ea
                android.text.StaticLayout r4 = r4.getCurrentInlineMessageStaticLayout()
                goto L_0x00eb
            L_0x00ea:
                r4 = r5
            L_0x00eb:
                r2.r = r4
            L_0x00ed:
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r4 = r2.q
                if (r4 == 0) goto L_0x00f4
                boolean r4 = r4.f62091a
                goto L_0x00f5
            L_0x00f4:
                r4 = 0
            L_0x00f5:
                r8 = 1
                if (r4 != 0) goto L_0x018a
                java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r4 = r2.p
                if (r4 == 0) goto L_0x015d
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Collection r5 = (java.util.Collection) r5
                java.util.Iterator r4 = r4.iterator()
            L_0x0109:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x015b
                java.lang.Object r9 = r4.next()
                r10 = r9
                net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r10
                java.util.List r10 = r10.getProductList()
                if (r10 == 0) goto L_0x0154
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                boolean r11 = r10 instanceof java.util.Collection
                if (r11 == 0) goto L_0x012b
                r11 = r10
                java.util.Collection r11 = (java.util.Collection) r11
                boolean r11 = r11.isEmpty()
                if (r11 != 0) goto L_0x014f
            L_0x012b:
                java.util.Iterator r10 = r10.iterator()
            L_0x012f:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x014f
                java.lang.Object r11 = r10.next()
                net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r11
                java.lang.String r11 = r11.getProductType()
                if (r11 == 0) goto L_0x014a
                java.lang.String r12 = r0.getProductType()
                boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r12, (boolean) r8)
                goto L_0x014b
            L_0x014a:
                r11 = 0
            L_0x014b:
                if (r11 == 0) goto L_0x012f
                r10 = 0
                goto L_0x0150
            L_0x014f:
                r10 = 1
            L_0x0150:
                if (r10 != 0) goto L_0x0154
                r10 = 1
                goto L_0x0155
            L_0x0154:
                r10 = 0
            L_0x0155:
                if (r10 == 0) goto L_0x0109
                r5.add(r9)
                goto L_0x0109
            L_0x015b:
                java.util.List r5 = (java.util.List) r5
            L_0x015d:
                java.util.Collection r5 = (java.util.Collection) r5
                if (r5 == 0) goto L_0x018a
                boolean r4 = r5.isEmpty()
                r4 = r4 ^ r8
                if (r4 == 0) goto L_0x018a
                java.util.List r5 = (java.util.List) r5
                java.lang.Object r4 = r5.get(r3)
                net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r4
                java.util.List r4 = r4.getProductList()
                java.util.Collection r4 = (java.util.Collection) r4
                if (r4 == 0) goto L_0x018a
                boolean r5 = r4.isEmpty()
                r5 = r5 ^ r8
                if (r5 == 0) goto L_0x018a
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r4 = r4.get(r3)
                net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
                r2.b((net.one97.paytm.recharge.model.v4.CJRProductsItem) r4)
            L_0x018a:
                r2.s = r8
                net.one97.paytm.recharge.mobile.d.a r4 = r2.f63600h     // Catch:{ all -> 0x01ce }
                if (r4 == 0) goto L_0x01d4
                net.one97.paytm.recharge.mobile.d.a r4 = r2.f63600h     // Catch:{ all -> 0x01ce }
                if (r4 == 0) goto L_0x01d4
                net.one97.paytm.recharge.ordersummary.h.d r5 = r4.v     // Catch:{ all -> 0x01ce }
                java.lang.Object r8 = r4.e()     // Catch:{ all -> 0x01ce }
                java.lang.String r9 = "plan_selected"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
                java.lang.String r11 = "/"
                r10.<init>(r11)     // Catch:{ all -> 0x01ce }
                java.lang.Object r4 = r4.e()     // Catch:{ all -> 0x01ce }
                r10.append(r4)     // Catch:{ all -> 0x01ce }
                java.lang.String r4 = "/browse_plans"
                r10.append(r4)     // Catch:{ all -> 0x01ce }
                java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x01ce }
                java.lang.Double r10 = r0.getPrice()     // Catch:{ all -> 0x01ce }
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)     // Catch:{ all -> 0x01ce }
                r11 = 0
                java.lang.String r0 = r0.getPlanCategoryDisplayName()     // Catch:{ all -> 0x01ce }
                if (r0 != 0) goto L_0x01c3
                r12 = r6
                goto L_0x01c4
            L_0x01c3:
                r12 = r0
            L_0x01c4:
                r14 = 16
                r6 = r5
                r7 = r8
                r8 = r9
                r9 = r4
                net.one97.paytm.recharge.ordersummary.h.d.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x01ce }
                goto L_0x01d4
            L_0x01ce:
                r0 = move-exception
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r4 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                r4.debugLogExceptions(r0)
            L_0x01d4:
                r2.t = r3
                r2.u = r3
            L_0x01d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.p.onChanged(java.lang.Object):void");
        }
    }

    static final class r extends kotlin.g.b.l implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(String str) {
            if (net.one97.paytm.recharge.common.utils.g.c(str)) {
                TextView textView = (TextView) this.this$0.b(R.id.txt_mobile_no);
                kotlin.g.b.k.a((Object) textView, "txt_mobile_no");
                textView.setText(str);
            }
        }
    }

    static final class s extends kotlin.g.b.l implements kotlin.g.a.b<LinkedList<CJRSelectedGroupItem>, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LinkedList<CJRSelectedGroupItem>) (LinkedList) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(LinkedList<CJRSelectedGroupItem> linkedList) {
            if (linkedList != null && !linkedList.isEmpty()) {
                f.a(this.this$0, (LinkedList) linkedList);
                f.b(this.this$0, (LinkedList) linkedList);
            }
        }
    }

    static final class t extends kotlin.g.b.l implements kotlin.g.a.b<CJRProductsItem, kotlin.x> {
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(f fVar) {
            super(1);
            this.this$0 = fVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRProductsItem) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRProductsItem cJRProductsItem) {
            net.one97.paytm.recharge.mobile.d.a aVar;
            net.one97.paytm.recharge.mobile.d.a aVar2;
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            if (cJRProductsItem != null) {
                this.this$0.d();
                this.this$0.n = cJRProductsItem;
                f fVar = this.this$0;
                Object obj = null;
                fVar.w = null;
                fVar.v = false;
                CJRProductsItem cJRProductsItem2 = fVar.n;
                if (cJRProductsItem2 != null) {
                    Long productId = cJRProductsItem2.getProductId();
                    if ((productId != null ? productId.longValue() : 0) > 0) {
                        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        CRUFlowModel flowName = a2.getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                        CRUFlowModel flowName2 = a2.getFlowName();
                        if (flowName2 != null) {
                            flowName2.setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
                        }
                        aa aaVar = fVar.x;
                        if (aaVar != null) {
                            String operator = cJRProductsItem2.getOperator();
                            Long productId2 = cJRProductsItem2.getProductId();
                            if (productId2 == null) {
                                kotlin.g.b.k.a();
                            }
                            aaVar.a("success_rate_alert_message", operator, productId2.longValue(), cJRProductsItem2.getService(), cJRProductsItem2.getPaytype(), cJRProductsItem2.getCircle(), a2);
                        }
                    }
                }
                this.this$0.a(cJRProductsItem);
                f.b(this.this$0, cJRProductsItem);
                this.this$0.a();
                CJRProductsItem d2 = this.this$0.n;
                if (!((d2 != null ? d2.getOperator() : null) == null || (aVar = this.this$0.f63600h) == null || aVar.P || (aVar2 = this.this$0.f63600h) == null || (dVar = aVar2.v) == null)) {
                    net.one97.paytm.recharge.mobile.d.a aVar3 = this.this$0.f63600h;
                    if (aVar3 != null) {
                        obj = aVar3.e();
                    }
                    Object obj2 = obj;
                    if (obj2 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem d3 = this.this$0.n;
                    if (d3 == null) {
                        kotlin.g.b.k.a();
                    }
                    String operator2 = d3.getOperator();
                    if (operator2 == null) {
                        kotlin.g.b.k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "Operator_dropdown_item_selected", (Object) null, operator2, (Object) null, "auto", (Object) null, 84);
                }
                net.one97.paytm.recharge.mobile.d.a aVar4 = this.this$0.f63600h;
                if (aVar4 != null) {
                    aVar4.P = false;
                }
            }
        }
    }

    static final class x<T> implements io.reactivex.rxjava3.d.q<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final x f63643a = new x();

        x() {
        }

        public final /* synthetic */ boolean test(Object obj) {
            String str = (String) obj;
            kotlin.g.b.k.a((Object) str, "it");
            return !kotlin.m.p.a(str);
        }
    }

    public f() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        kotlin.g.b.k.a((Object) a2, "PublishSubject.create()");
        this.P = a2;
        this.ab = new g(this);
        this.ad = new C1237f(this);
        this.ae = new w(this);
        this.af = new HashMap<>();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = f.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJREnterMobileRechargeAm…V8::class.java.simpleName");
        ag = simpleName;
    }

    public void onCreate(Bundle bundle) {
        CJRItem cJRItem;
        androidx.lifecycle.y<Data<CJRSetUserConsentApiResponse>> yVar;
        androidx.lifecycle.y<Data<CJRGetUserConsentApiResponse>> yVar2;
        CJRItem cJRItem2;
        net.one97.paytm.recharge.mobile.d.a aVar;
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        String str;
        HashMap<String, String> hashMap3;
        HashMap<String, String> hashMap4;
        String str2;
        HashMap<String, String> hashMap5;
        HashMap<String, String> hashMap6;
        String str3;
        HashMap<String, String> hashMap7;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.e();
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.a((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar3 = this.f63599g;
        if (dVar3 != null) {
            dVar3.f();
        }
        net.one97.paytm.recharge.mobile.d dVar4 = this.f63599g;
        if (dVar4 != null) {
            dVar4.a((net.one97.paytm.recharge.common.e.n) this);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "activity!!.applicationContext");
        net.one97.paytm.recharge.common.b.c b2 = net.one97.paytm.recharge.common.b.d.b(applicationContext);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity2, "activity!!");
        Context applicationContext2 = activity2.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext2, "activity!!.applicationContext");
        net.one97.paytm.recharge.common.h.a aVar3 = new net.one97.paytm.recharge.common.h.a(b2, net.one97.paytm.recharge.common.b.d.d(applicationContext2));
        FragmentActivity activity3 = getActivity();
        if (activity3 == null) {
            kotlin.g.b.k.a();
        }
        this.I = (net.one97.paytm.recharge.common.h.f) am.a(activity3, (al.b) aVar3).a(net.one97.paytm.recharge.common.h.f.class);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        this.J = net.one97.paytm.recharge.di.helper.c.T();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.U = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        androidx.lifecycle.y<Data<UnsubscribeApiResponse>> yVar3 = null;
        if (aVar4 != null) {
            cJRItem = aVar4.r;
        } else {
            cJRItem = null;
        }
        if (cJRItem instanceof CJRHomePageItem) {
            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
            if (aVar5 != null) {
                cJRItem2 = aVar5.r;
            } else {
                cJRItem2 = null;
            }
            if (cJRItem2 != null) {
                this.W = ((CJRHomePageItem) cJRItem2).isAppLink();
                net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                if (aVar6 != null) {
                    aVar6.N = this.W;
                }
                if (this.W && (aVar = this.f63600h) != null && (hashMap = aVar.m) != null && (!hashMap.isEmpty())) {
                    net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                    if (aVar7 == null || (hashMap6 = aVar7.m) == null || !hashMap6.containsKey("recharge_number")) {
                        net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
                        if (aVar8 == null || (hashMap4 = aVar8.m) == null || !hashMap4.containsKey("number")) {
                            net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
                            if (!(aVar9 == null || (hashMap2 = aVar9.m) == null || !hashMap2.containsKey(ContactColumn.PHONE_NUMBER) || (aVar2 = this.f63600h) == null)) {
                                net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
                                if (aVar10 == null || (hashMap3 = aVar10.m) == null) {
                                    str = null;
                                } else {
                                    str = hashMap3.get(ContactColumn.PHONE_NUMBER);
                                }
                                aVar2.M = str;
                            }
                        } else {
                            net.one97.paytm.recharge.mobile.d.a aVar11 = this.f63600h;
                            if (aVar11 != null) {
                                net.one97.paytm.recharge.mobile.d.a aVar12 = this.f63600h;
                                if (aVar12 == null || (hashMap5 = aVar12.m) == null) {
                                    str2 = null;
                                } else {
                                    str2 = hashMap5.get("number");
                                }
                                aVar11.M = str2;
                            }
                        }
                    } else {
                        net.one97.paytm.recharge.mobile.d.a aVar13 = this.f63600h;
                        if (aVar13 != null) {
                            net.one97.paytm.recharge.mobile.d.a aVar14 = this.f63600h;
                            if (aVar14 == null || (hashMap7 = aVar14.m) == null) {
                                str3 = null;
                            } else {
                                str3 = hashMap7.get("recharge_number");
                            }
                            aVar13.M = str3;
                        }
                    }
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageItem");
            }
        }
        net.one97.paytm.recharge.common.h.f fVar = this.I;
        if (fVar != null) {
            yVar = fVar.f61438a;
        } else {
            yVar = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, yVar, new l(this));
        net.one97.paytm.recharge.common.h.f fVar2 = this.I;
        if (fVar2 != null) {
            yVar2 = fVar2.f61439b;
        } else {
            yVar2 = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, yVar2, new m(this));
        net.one97.paytm.recharge.common.h.f fVar3 = this.I;
        if (fVar3 != null) {
            yVar3 = fVar3.f61440c;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, yVar3, new n(this));
    }

    public void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.recharge.mobile.d) {
            this.x = ((net.one97.paytm.recharge.mobile.d) context).b();
            aa aaVar = this.x;
            if (aaVar == null) {
                this.x = new aa(context, this);
            } else if (aaVar != null) {
                aaVar.a((net.one97.paytm.recharge.common.e.w) this);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_enter_mobile_recharge_amount, viewGroup, false);
    }

    static final class q implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63639a;

        q(f fVar) {
            this.f63639a = fVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                TextView textView = (TextView) this.f63639a.b(R.id.txt_bill_reminder);
                kotlin.g.b.k.a((Object) textView, "txt_bill_reminder");
                textView.setText(this.f63639a.getString(R.string.bill_reminder_set));
                return;
            }
            TextView textView2 = (TextView) this.f63639a.b(R.id.txt_bill_reminder);
            kotlin.g.b.k.a((Object) textView2, "txt_bill_reminder");
            textView2.setText(this.f63639a.getString(R.string.set_bill_reminder));
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        kotlin.g.b.k.c(menu, "menu");
        kotlin.g.b.k.c(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        a();
    }

    /* access modifiers changed from: private */
    public final void a() {
        FJRRechargeUtilityBaseV2.b bVar;
        CJRProductsItem cJRProductsItem = this.n;
        if (cJRProductsItem != null) {
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            String bbpsLogoUrl = cJRProductsItem.getBbpsLogoUrl();
            if (bbpsLogoUrl == null) {
                CJRProductsItem cJRProductsItem2 = this.n;
                if (cJRProductsItem2 == null) {
                    kotlin.g.b.k.a();
                }
                bbpsLogoUrl = cJRProductsItem2.getBbps_logo_url();
            }
            if (bbpsLogoUrl == null) {
                bbpsLogoUrl = "";
            }
            if (!TextUtils.isEmpty(bbpsLogoUrl) && (bVar = this.j) != null) {
                bVar.a(bbpsLogoUrl);
            }
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63635a;

        o(f fVar) {
            this.f63635a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r0.z;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                net.one97.paytm.recharge.mobile.a.f r0 = r3.f63635a
                net.one97.paytm.recharge.mobile.d.a r0 = r0.f63600h
                if (r0 == 0) goto L_0x0013
                androidx.lifecycle.y<java.lang.String> r0 = r0.z
                androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
                if (r0 == 0) goto L_0x0013
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0014
            L_0x0013:
                r0 = 0
            L_0x0014:
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0045
                net.one97.paytm.recharge.common.utils.n r1 = net.one97.paytm.recharge.common.utils.n.f61679a
                if (r0 != 0) goto L_0x0024
                kotlin.g.b.k.a()
            L_0x0024:
                net.one97.paytm.recharge.model.ContactItemModel r0 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r0)
                if (r0 == 0) goto L_0x0030
                java.lang.String r0 = r0.getName()
                if (r0 != 0) goto L_0x0032
            L_0x0030:
                java.lang.String r0 = ""
            L_0x0032:
                android.os.Handler r1 = new android.os.Handler
                android.os.Looper r2 = android.os.Looper.getMainLooper()
                r1.<init>(r2)
                net.one97.paytm.recharge.mobile.a.f$o$1 r2 = new net.one97.paytm.recharge.mobile.a.f$o$1
                r2.<init>(r3, r0)
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                r1.post(r2)
            L_0x0045:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.o.run():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: net.one97.paytm.recharge.common.b.a$b} */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRProductsItem r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            java.lang.String r0 = "selectedProduct"
            kotlin.g.b.k.c(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Group: "
            r0.<init>(r1)
            int r1 = net.one97.paytm.recharge.R.id.txt_operator
            android.view.View r1 = r6.b((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "txt_operator"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = r1.getText()
            r0.append(r1)
            java.lang.String r1 = ": PID: "
            r0.append(r1)
            java.lang.Long r1 = r18.getProductId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.d(r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.b()
            java.lang.Long r1 = r18.getProductId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setProductId(r1)
            net.one97.paytm.recharge.common.b.a r0 = r6.f63601i
            if (r0 == 0) goto L_0x004e
            r0.f60870a = r7
        L_0x004e:
            net.one97.paytm.recharge.common.b.a r0 = r6.f63601i
            r1 = 0
            r8 = 2
            r9 = 0
            r10 = 1
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r0.b()
            if (r0 != r10) goto L_0x00f4
            net.one97.paytm.recharge.common.b.a r0 = r6.f63601i
            if (r0 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            android.content.Context r2 = r17.getContext()
            if (r2 != 0) goto L_0x006c
            kotlin.g.b.k.a()
        L_0x006c:
            java.lang.String r3 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r0 = r0.a((android.content.Context) r2)
            if (r0 == 0) goto L_0x007c
            java.lang.Object r2 = r0.getTag()
            goto L_0x007d
        L_0x007c:
            r2 = r1
        L_0x007d:
            boolean r3 = r2 instanceof net.one97.paytm.recharge.common.b.a.C1172a
            if (r3 != 0) goto L_0x0082
            r2 = r1
        L_0x0082:
            net.one97.paytm.recharge.common.b.a$a r2 = (net.one97.paytm.recharge.common.b.a.C1172a) r2
            if (r2 == 0) goto L_0x0088
            net.one97.paytm.recharge.common.b.a$b r1 = r2.f60875a
        L_0x0088:
            if (r1 != 0) goto L_0x008b
            goto L_0x004e
        L_0x008b:
            int[] r2 = net.one97.paytm.recharge.mobile.a.g.f63648c
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r10) goto L_0x00e9
            if (r1 == r8) goto L_0x0098
            goto L_0x004e
        L_0x0098:
            if (r0 == 0) goto L_0x00e1
            r1 = r0
            net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8 r1 = (net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8) r1
            r6.q = r1
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r6.n
            if (r2 == 0) goto L_0x00a6
            r6.b((net.one97.paytm.recharge.model.v4.CJRProductsItem) r2)
        L_0x00a6:
            net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r2 = r6.q
            if (r2 == 0) goto L_0x00b4
            net.one97.paytm.recharge.mobile.a.f$c r3 = new net.one97.paytm.recharge.mobile.a.f$c
            r3.<init>(r6, r0)
            android.widget.RadioGroup$OnCheckedChangeListener r3 = (android.widget.RadioGroup.OnCheckedChangeListener) r3
            r2.setCheckedChangedListener(r3)
        L_0x00b4:
            int r2 = net.one97.paytm.recharge.R.id.container_product_type
            android.view.View r2 = r6.b((int) r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x00c1
            r2.addView(r0)
        L_0x00c1:
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            if (r0 == 0) goto L_0x00d9
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r1 = 5
            int r1 = com.paytm.utility.b.c((int) r1)
            r2 = 20
            int r2 = com.paytm.utility.b.c((int) r2)
            r0.setMargins(r9, r1, r2, r9)
            goto L_0x004e
        L_0x00d9:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x00e1:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<*>"
            r0.<init>(r1)
            throw r0
        L_0x00e9:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r0 = (net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8) r0
            r6.a((net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8) r0)
            goto L_0x004e
        L_0x00f4:
            boolean r0 = r6.Q
            if (r0 != 0) goto L_0x01b8
            r6.Q = r10
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0198
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0198
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x0198
            boolean r0 = r0.showFastForward()
            if (r0 != r10) goto L_0x0198
            r17.e()
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x0125
            net.one97.paytm.recharge.mobile.a.f$e r2 = new net.one97.paytm.recharge.mobile.a.f$e
            r2.<init>(r6)
            net.one97.paytm.recharge.common.e.m r2 = (net.one97.paytm.recharge.common.e.m) r2
            r0.setOnCheckChangedListener(r2)
        L_0x0125:
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x013d
            net.one97.paytm.recharge.mobile.d.a r2 = r6.f63600h
            if (r2 != 0) goto L_0x0136
            kotlin.g.b.k.a()
        L_0x0136:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r2.m
            java.util.Map r2 = (java.util.Map) r2
            r0.a((java.util.Map<java.lang.String, java.lang.String>) r2)
        L_0x013d:
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x0198
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0198
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x015e
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r0.j()
            goto L_0x015f
        L_0x015e:
            r0 = r1
        L_0x015f:
            if (r0 == 0) goto L_0x0198
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            if (r0 == 0) goto L_0x0198
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            if (r0 != 0) goto L_0x0172
            kotlin.g.b.k.a()
        L_0x0172:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.mobile.d.a r2 = r6.f63600h
            if (r2 == 0) goto L_0x0185
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
            if (r2 == 0) goto L_0x0185
            java.lang.String r1 = r2.getCategoryId()
        L_0x0185:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.e(r0, r1)
            if (r0 != 0) goto L_0x0198
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x0198
            r0.setFastForwardChecked(r10)
        L_0x0198:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x01a5
            r0.setVisibility(r9)
        L_0x01a5:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x01b5
            r1 = r6
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x01b5:
            r17.g()
        L_0x01b8:
            boolean r0 = r6.M
            if (r0 != 0) goto L_0x02cf
            r6.M = r10
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r1 = r6.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x01d0
            r1.getGlobalVisibleRect(r0)
        L_0x01d0:
            int r0 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r0 = r6.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1 = 8
            if (r0 == 0) goto L_0x01df
            r0.setVisibility(r1)
        L_0x01df:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            if (r2 == 0) goto L_0x01f9
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x01f9
            android.view.Display r2 = r2.getDefaultDisplay()
            if (r2 == 0) goto L_0x01f9
            r2.getMetrics(r0)
        L_0x01f9:
            int r0 = r0.heightPixels
            double r2 = (double) r0
            r4 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            double r4 = r4 * r2
            float r0 = (float) r4
            r4 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r4 = r4 * r2
            double r2 = r2 - r4
            float r2 = (float) r2
            int r3 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r3 = r6.b((int) r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            android.util.Property r4 = android.view.View.TRANSLATION_Y
            float[] r5 = new float[r8]
            r5[r9] = r0
            r0 = 0
            r5[r10] = r0
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r3, r4, r5)
            java.lang.String r3 = "animContainerMainContentTranslate"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            r3 = 100
            r11.setStartDelay(r3)
            int r5 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r5 = r6.b((int) r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            android.util.Property r12 = android.view.View.ALPHA
            float[] r13 = new float[r8]
            r13 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r5, r12, r13)
            java.lang.String r5 = "animContainerMainContentAlpha"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            r12.setStartDelay(r3)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            int r4 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r4 = r6.b((int) r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x0259
            r4.getGlobalVisibleRect(r3)
        L_0x0259:
            int r3 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r3 = r6.b((int) r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            if (r3 == 0) goto L_0x0266
            r3.setVisibility(r1)
        L_0x0266:
            int r1 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r1 = r6.b((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.util.Property r3 = android.view.View.TRANSLATION_Y
            float[] r4 = new float[r8]
            r4[r9] = r2
            r4[r10] = r0
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r1, r3, r4)
            int r0 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r0 = r6.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            android.util.Property r1 = android.view.View.ALPHA
            float[] r2 = new float[r8]
            r2 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r14 = android.animation.ObjectAnimator.ofFloat(r0, r1, r2)
            android.animation.AnimatorSet r15 = new android.animation.AnimatorSet
            r15.<init>()
            net.one97.paytm.recharge.mobile.a.f$d r16 = new net.one97.paytm.recharge.mobile.a.f$d
            r0 = r16
            r1 = r17
            r2 = r13
            r3 = r14
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.animation.Animator$AnimatorListener r0 = (android.animation.Animator.AnimatorListener) r0
            r15.addListener(r0)
            r0 = 500(0x1f4, double:2.47E-321)
            r15.setDuration(r0)
            android.view.animation.AccelerateDecelerateInterpolator r0 = new android.view.animation.AccelerateDecelerateInterpolator
            r0.<init>()
            android.animation.TimeInterpolator r0 = (android.animation.TimeInterpolator) r0
            r15.setInterpolator(r0)
            r0 = 4
            android.animation.Animator[] r0 = new android.animation.Animator[r0]
            android.animation.Animator r13 = (android.animation.Animator) r13
            r0[r9] = r13
            android.animation.Animator r14 = (android.animation.Animator) r14
            r0[r10] = r14
            android.animation.Animator r11 = (android.animation.Animator) r11
            r0[r8] = r11
            r1 = 3
            android.animation.Animator r12 = (android.animation.Animator) r12
            r0[r1] = r12
            r15.playTogether(r0)
            r15.start()
        L_0x02cf:
            net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout r0 = new net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout
            android.content.Context r1 = r17.getContext()
            java.lang.String r2 = r18.getThinBannerURL()
            r3 = r6
            net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout$b r3 = (net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout.b) r3
            r0.<init>(r1, r2, r3)
            int r1 = net.one97.paytm.recharge.R.id.container_product_input_fields
            android.view.View r1 = r6.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x02ee
            android.view.View r0 = (android.view.View) r0
            r1.addView(r0)
        L_0x02ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.a(net.one97.paytm.recharge.model.v4.CJRProductsItem):void");
    }

    public static final class e implements net.one97.paytm.recharge.common.e.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63615a;

        e(f fVar) {
            this.f63615a = fVar;
        }

        public final void a(boolean z, boolean z2) {
            this.f63615a.X = z2;
            f fVar = this.f63615a;
            net.one97.paytm.recharge.mobile.d.a aVar = fVar.f63600h;
            if (aVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), z ? "fast_forward_checked" : "fast_forward_unchecked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) fVar.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = fVar.o;
                cJRProceedWidgetV8.setProceedBtnText(fVar.a(cJRAmountInputFieldWidgetV8 != null ? cJRAmountInputFieldWidgetV8.getFormattedString() : null));
            }
        }
    }

    public final void a(CJRHomePageItem cJRHomePageItem) {
        String str;
        kotlin.g.b.k.c(cJRHomePageItem, "item");
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 == null || (str = cJRAmountInputFieldWidgetV8.getInputText()) == null) {
            str = "";
        }
        j(cJRHomePageItem.getSubtitle());
        if (!kotlin.m.p.a(str, cJRHomePageItem.getSubtitle(), true)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.PLAN_BANNER_CLICK.name());
            }
            a("search_browse_plan", (Object) a2);
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
            cJRProceedWidgetV8.setProceedBtnText(a(cJRAmountInputFieldWidgetV8 != null ? cJRAmountInputFieldWidgetV8.getFormattedString() : null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = r1.f61409b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x003c
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.mobile.d.a r1 = r2.f63600h
            if (r1 == 0) goto L_0x0025
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.getCategoryId()
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.e(r0, r1)
            if (r0 == 0) goto L_0x003c
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r2.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x003b
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x003b:
            return
        L_0x003c:
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r2.b((int) r0)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r0
            if (r0 == 0) goto L_0x004a
            r1 = 0
            r0.setVisibility(r1)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.e():void");
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63611b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63612c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63613d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63614e;

        d(f fVar, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2, ObjectAnimator objectAnimator3, ObjectAnimator objectAnimator4) {
            this.f63610a = fVar;
            this.f63611b = objectAnimator;
            this.f63612c = objectAnimator2;
            this.f63613d = objectAnimator3;
            this.f63614e = objectAnimator4;
        }

        public final void onAnimationStart(Animator animator) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f63610a.b(R.id.container_main_header);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) this.f63610a.b(R.id.container_main_content);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f63610a.U && (this.f63610a.getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
                FragmentActivity activity = this.f63610a.getActivity();
                if (activity != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity).e();
                    FragmentActivity activity2 = this.f63610a.getActivity();
                    if (activity2 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity2).i();
                        Toolbar toolbar = (Toolbar) this.f63610a.b(R.id.toolbar);
                        kotlin.g.b.k.a((Object) toolbar, "toolbar");
                        toolbar.setVisibility(0);
                        this.f63610a.V = true;
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = (CJRMobileFastForwardWidgetV8) b(R.id.lyt_fast_forward);
        if (cJRMobileFastForwardWidgetV8 == null || !cJRMobileFastForwardWidgetV8.a()) {
            if (this.S) {
                String string = getString(R.string.proceed_btn_postpaid);
                kotlin.g.b.k.a((Object) string, "getString(R.string.proceed_btn_postpaid)");
                return string;
            }
            String string2 = getString(R.string.proceed_btn_prepaid);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.proceed_btn_prepaid)");
            return string2;
        } else if (TextUtils.isEmpty(str)) {
            String string3 = getString(R.string.proceed_re);
            kotlin.g.b.k.a((Object) string3, "getString(R.string.proceed_re)");
            return string3;
        } else {
            String string4 = getString(R.string.proceed_btn_ff_selected, str);
            kotlin.g.b.k.a((Object) string4, "getString(R.string.proce…_btn_ff_selected, amount)");
            return string4;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|(3:20|(1:22)|23)|24|25|(3:27|(1:29)|30)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0073 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[Catch:{ Exception -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r11) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r0 = r10.o
            r1 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getInputText()
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            r10.o = r11
            r11.b()
            r2 = r10
            android.view.View$OnFocusChangeListener r2 = (android.view.View.OnFocusChangeListener) r2
            r11.setInputFocusChangeListener(r2)
            r2 = r10
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r11.setInputFieldTextChangeListener(r2)
            r11.setLargeAmount()
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r2 = r10.o
            if (r2 != 0) goto L_0x002b
            kotlin.g.b.k.a()
        L_0x002b:
            net.one97.paytm.recharge.mobile.a.f$b r3 = new net.one97.paytm.recharge.mobile.a.f$b
            r3.<init>(r10)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setInputFieldClickListener(r3)
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x003a
            r0 = r2
        L_0x003a:
            r11.setInputText(r0)
            java.lang.Object r0 = r11.getTag()
            boolean r0 = r0 instanceof net.one97.paytm.recharge.common.b.a.C1172a
            if (r0 == 0) goto L_0x0098
            java.lang.Object r0 = r11.getTag()
            if (r0 == 0) goto L_0x0090
            net.one97.paytm.recharge.common.b.a$a r0 = (net.one97.paytm.recharge.common.b.a.C1172a) r0
            java.lang.Object r3 = r0.f60877c
            boolean r3 = r3 instanceof net.one97.paytm.recharge.model.v4.CJRInputFieldsItem
            if (r3 == 0) goto L_0x0098
            java.lang.Object r0 = r0.f60877c
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r0
            r10.z = r0
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = r10.z     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x0073
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r10.n     // Catch:{ Exception -> 0x0073 }
            if (r3 != 0) goto L_0x0064
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0073 }
        L_0x0064:
            java.lang.String r3 = r3.getMinAmount()     // Catch:{ Exception -> 0x0073 }
            double r3 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ Exception -> 0x0073 }
            r0.setMin(r3)     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = r10.z     // Catch:{ Exception -> 0x008e }
            if (r0 == 0) goto L_0x0098
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r10.n     // Catch:{ Exception -> 0x008e }
            if (r3 != 0) goto L_0x007e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x008e }
        L_0x007e:
            java.lang.String r3 = r3.getMaxAmount()     // Catch:{ Exception -> 0x008e }
            double r3 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x008e }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ Exception -> 0x008e }
            r0.setMax(r3)     // Catch:{ Exception -> 0x008e }
            goto L_0x0098
        L_0x008e:
            goto L_0x0098
        L_0x0090:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry"
            r11.<init>(r0)
            throw r11
        L_0x0098:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r0 < r3) goto L_0x00a7
            int r0 = net.one97.paytm.recharge.R.string.transition_name_input_field_with_action
            java.lang.String r0 = r10.getString(r0)
            r11.setTransitionName(r0)
        L_0x00a7:
            int r0 = net.one97.paytm.recharge.R.id.container_product_input_fields
            android.view.View r0 = r10.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x00b7
            r4 = r11
            android.view.View r4 = (android.view.View) r4
            r0.addView(r4)
        L_0x00b7:
            android.view.ViewGroup$LayoutParams r0 = r11.getLayoutParams()
            if (r0 == 0) goto L_0x0392
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r4 = com.paytm.utility.b.c((int) r3)
            int r3 = com.paytm.utility.b.c((int) r3)
            r5 = 0
            r0.setMargins(r4, r5, r3, r5)
            boolean r0 = r10.R
            r3 = 1
            if (r0 != 0) goto L_0x0102
            r10.R = r3
            boolean r0 = r10.U
            if (r0 != 0) goto L_0x00fe
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L_0x00e3
            java.lang.String r4 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L_0x00e4
        L_0x00e3:
            r0 = r1
        L_0x00e4:
            boolean r4 = r0 instanceof android.view.inputmethod.InputMethodManager
            if (r4 != 0) goto L_0x00e9
            r0 = r1
        L_0x00e9:
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            if (r0 == 0) goto L_0x00f4
            android.os.IBinder r4 = r11.getWindowToken()
            r0.hideSoftInputFromWindow(r4, r5)
        L_0x00f4:
            r11.d()
            if (r0 == 0) goto L_0x010f
            r11 = 2
            r0.toggleSoftInput(r11, r5)
            goto L_0x010f
        L_0x00fe:
            r11.d()
            goto L_0x010f
        L_0x0102:
            int r11 = net.one97.paytm.recharge.R.id.dummy_focusable_view
            android.view.View r11 = r10.b((int) r11)
            android.widget.EditText r11 = (android.widget.EditText) r11
            if (r11 == 0) goto L_0x010f
            r11.requestFocus()
        L_0x010f:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0126
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r11 = r11.y
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            if (r11 == 0) goto L_0x0126
            java.lang.Object r11 = r11.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r11 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r11
            if (r11 == 0) goto L_0x0126
            java.lang.String r11 = r11.getValue()
            goto L_0x0127
        L_0x0126:
            r11 = r1
        L_0x0127:
            java.lang.String r0 = "postpaid"
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r3)
            java.lang.String r6 = "prepaid"
            if (r4 == 0) goto L_0x0195
            r10.S = r3
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0139
            r11.O = r3
        L_0x0139:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02c4
            boolean r11 = r11.f61411d
            if (r11 != 0) goto L_0x02c4
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x014b
            boolean r11 = r11.isPrefetch()
            if (r11 == r3) goto L_0x017f
        L_0x014b:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x0155
            boolean r11 = r11.isFetchAmount()
            if (r11 == r3) goto L_0x017f
        L_0x0155:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x02c4
            boolean r11 = r11.isVodaFetchBill()
            if (r11 != r3) goto L_0x02c4
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02c4
            androidx.lifecycle.y<java.lang.String> r11 = r11.z
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            if (r11 == 0) goto L_0x02c4
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x02c4
            android.content.Context r2 = r10.getContext()
            java.lang.String r2 = com.paytm.utility.b.l((android.content.Context) r2)
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r2, (boolean) r3)
            if (r11 != r3) goto L_0x02c4
        L_0x017f:
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r11 = r10.o
            if (r11 == 0) goto L_0x018a
            int r2 = net.one97.paytm.recharge.R.string.fetch_bill
            android.view.View$OnClickListener r4 = r10.ab
            r11.a((int) r2, (android.view.View.OnClickListener) r4)
        L_0x018a:
            r10.C = r3
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r11 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_BILL
            java.lang.String r2 = "fetch_mobile_bill_in_bg"
            r10.a((java.lang.String) r2, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r11)
            goto L_0x02c4
        L_0x0195:
            boolean r11 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r11, (boolean) r3)
            if (r11 == 0) goto L_0x02c4
            r10.S = r5
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x01a3
            r11.O = r5
        L_0x01a3:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x01f2
            boolean r11 = r11.getShowBrowsePlan()
            if (r11 != r3) goto L_0x01f2
            r10.N = r3
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r11 = r10.o
            if (r11 == 0) goto L_0x01c5
            int r4 = net.one97.paytm.recharge.R.string.browse_plans_txt
            java.lang.String r4 = r10.getString(r4)
            java.lang.String r7 = "getString(R.string.browse_plans_txt)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            int r7 = net.one97.paytm.recharge.R.color.color_00b9f5
            android.view.View$OnClickListener r8 = r10.ad
            r11.a(r4, r7, r8)
        L_0x01c5:
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r11 = r10.o
            if (r11 == 0) goto L_0x01ce
            android.view.View$OnClickListener r4 = r10.ad
            r11.setActionLayoutClickListener(r4)
        L_0x01ce:
            androidx.lifecycle.z<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r11 = r10.f63606f
            if (r11 != 0) goto L_0x01db
            net.one97.paytm.recharge.mobile.a.f$p r11 = new net.one97.paytm.recharge.mobile.a.f$p
            r11.<init>(r10)
            androidx.lifecycle.z r11 = (androidx.lifecycle.z) r11
            r10.f63606f = r11
        L_0x01db:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x01f2
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r11 = r11.J
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            if (r11 == 0) goto L_0x01f2
            r4 = r10
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            androidx.lifecycle.z<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r7 = r10.f63606f
            if (r7 != 0) goto L_0x01ef
            kotlin.g.b.k.a()
        L_0x01ef:
            r11.observe(r4, r7)
        L_0x01f2:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x02be
            boolean r11 = r11.getShowOne2OneOffer()
            if (r11 != r3) goto L_0x02be
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x02be
            boolean r11 = r11.getShowDynamicPlan()
            if (r11 != r3) goto L_0x02be
            net.one97.paytm.recharge.di.helper.c r11 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r11 = net.one97.paytm.recharge.di.helper.c.W()
            if (r11 == 0) goto L_0x02be
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x0218
            boolean r11 = r11.getShowOne2OneUserOffer()
            if (r11 == r3) goto L_0x02b7
        L_0x0218:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = r10.n
            if (r11 == 0) goto L_0x0221
            java.lang.String r11 = r11.getOne2OneOfferText()
            goto L_0x0222
        L_0x0221:
            r11 = r1
        L_0x0222:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x02b7
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0230
            r11.I = r3
        L_0x0230:
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r11 = r10.o
            if (r11 == 0) goto L_0x02c4
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = r10.n
            if (r4 == 0) goto L_0x023d
            java.lang.String r4 = r4.getOne2OneOfferText()
            goto L_0x023e
        L_0x023d:
            r4 = r1
        L_0x023e:
            if (r4 != 0) goto L_0x0243
            kotlin.g.b.k.a()
        L_0x0243:
            android.view.View$OnClickListener r7 = r10.ad
            java.lang.String r8 = "secondaryText"
            kotlin.g.b.k.c(r4, r8)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r8 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r9 = "action_secondary_text"
            if (r8 != 0) goto L_0x0294
            int r2 = net.one97.paytm.recharge.R.id.action_progress
            android.view.View r2 = r11.a((int) r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            java.lang.String r8 = "action_progress"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x026a
            r11.f61891b = r5
            goto L_0x027a
        L_0x026a:
            int r2 = net.one97.paytm.recharge.R.id.action_secondary_text
            android.view.View r2 = r11.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            r2.setVisibility(r5)
            r11.f61891b = r5
        L_0x027a:
            int r2 = net.one97.paytm.recharge.R.id.action_secondary_text
            android.view.View r2 = r11.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            r2.setText(r4)
            int r2 = net.one97.paytm.recharge.R.id.action_secondary_text
            android.view.View r11 = r11.a((int) r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r11.setOnClickListener(r7)
            goto L_0x02c4
        L_0x0294:
            int r4 = net.one97.paytm.recharge.R.id.action_secondary_text
            android.view.View r4 = r11.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
            int r2 = net.one97.paytm.recharge.R.id.action_secondary_text
            android.view.View r2 = r11.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            r4 = 8
            r2.setVisibility(r4)
            r11.f61891b = r4
            goto L_0x02c4
        L_0x02b7:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02c4
            r11.I = r3
            goto L_0x02c4
        L_0x02be:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02c4
            r11.I = r5
        L_0x02c4:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02cd
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11 = r11.j()
            goto L_0x02ce
        L_0x02cd:
            r11 = r1
        L_0x02ce:
            if (r11 == 0) goto L_0x02fd
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = r11.getCjrBillDetails()
            if (r2 == 0) goto L_0x02fd
            java.lang.String r4 = r11.getPayType()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r3)
            if (r0 != 0) goto L_0x02ea
            java.lang.String r11 = r11.getPayType()
            boolean r11 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r11, (boolean) r3)
            if (r11 == 0) goto L_0x02fd
        L_0x02ea:
            java.lang.Double r11 = r2.getAmount()
            if (r11 == 0) goto L_0x02f9
            double r2 = r11.doubleValue()
            java.lang.String r11 = java.lang.String.valueOf(r2)
            goto L_0x02fa
        L_0x02f9:
            r11 = r1
        L_0x02fa:
            r10.j((java.lang.String) r11)
        L_0x02fd:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 != 0) goto L_0x0304
            kotlin.g.b.k.a()
        L_0x0304:
            java.util.HashMap<java.lang.String, java.lang.String> r11 = r11.m
            java.lang.String r0 = "price"
            boolean r2 = r11.containsKey(r0)
            java.lang.String r3 = "search_browse_plan_prefill"
            if (r2 == 0) goto L_0x034d
            java.lang.Object r2 = r11.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            r11.remove(r0)
            r10.j((java.lang.String) r2)
            boolean r11 = r10.S
            if (r11 != 0) goto L_0x0391
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r11 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r11.setErrorType(r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x033a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x033a:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x0349
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AUTO_FILL_AMOUNT_DEEPLINK
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x0349:
            r10.a((java.lang.String) r3, (java.lang.Object) r11)
            return
        L_0x034d:
            java.lang.String r0 = "amount"
            boolean r2 = r11.containsKey(r0)
            if (r2 == 0) goto L_0x0391
            java.lang.Object r2 = r11.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            r11.remove(r0)
            r10.j((java.lang.String) r2)
            boolean r11 = r10.S
            if (r11 != 0) goto L_0x0391
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r11 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r11.setErrorType(r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x037f
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x037f:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x038e
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AUTO_FILL_AMOUNT_DEEPLINK
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x038e:
            r10.a((java.lang.String) r3, (java.lang.Object) r11)
        L_0x0391:
            return
        L_0x0392:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.a(net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63607a;

        b(f fVar) {
            this.f63607a = fVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63607a.f63600h;
            if (aVar != null && (dVar = aVar.v) != null) {
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63607a.f63600h;
                Object e2 = aVar2 != null ? aVar2.e() : null;
                if (e2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "amount_clicked_non_prefetch", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(net.one97.paytm.recharge.common.b.a.a(r0, r1, r4)) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String k(java.lang.String r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0004
            java.lang.String r4 = ""
        L_0x0004:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = r3.z
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.recharge.common.b.a r0 = r3.f63601i
            if (r0 == 0) goto L_0x003a
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.recharge.common.b.a r0 = r3.f63601i
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            android.content.Context r0 = r3.getContext()
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r3.z
            if (r1 != 0) goto L_0x002e
            kotlin.g.b.k.a()
        L_0x002e:
            java.lang.String r0 = net.one97.paytm.recharge.common.b.a.a((android.content.Context) r0, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1, (java.lang.String) r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0059
        L_0x003a:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x0050 }
            double r0 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x0050 }
            double r0 = java.lang.Math.ceil(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0050 }
            r1 = 14
            r2 = 0
            java.lang.String r4 = net.one97.paytm.recharge.widgets.c.d.a(r0, r2, r2, r2, r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            java.lang.String r4 = net.one97.paytm.recharge.common.widget.CJRAmountView.a((java.lang.String) r4)
            java.lang.String r0 = "CJRAmountView.getInteger(dueAmount)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
        L_0x0059:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r4 = net.one97.paytm.recharge.widgets.c.d.d(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.k(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final void j(String str) {
        this.F = true;
        if (this.G) {
            this.G = false;
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
            if (cJRAmountInputFieldWidgetV8 != null) {
                cJRAmountInputFieldWidgetV8.c();
            }
        }
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV82 = this.o;
        if (cJRAmountInputFieldWidgetV82 != null) {
            cJRAmountInputFieldWidgetV82.setInputText("");
        }
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV83 = this.o;
        if (cJRAmountInputFieldWidgetV83 != null) {
            cJRAmountInputFieldWidgetV83.a(k(str));
        }
        this.F = false;
    }

    /* access modifiers changed from: package-private */
    public final void b(CJRProductsItem cJRProductsItem) {
        CJRMobileRadioGroupV8<?> cJRMobileRadioGroupV8;
        List<CJRAggsItem> list = this.p;
        if (list != null) {
            int i2 = 0;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                Collection productList = ((CJRAggsItem) next).getProductList();
                if (productList != null && (!productList.isEmpty()) && kotlin.g.b.k.a((Object) ((CJRProductsItem) ((List) productList).get(0)).getProductId(), (Object) cJRProductsItem.getProductId()) && (cJRMobileRadioGroupV8 = this.q) != null) {
                    cJRMobileRadioGroupV8.setSelectedAtIndex(i2);
                }
                i2 = i3;
            }
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63608a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63609b;

        c(f fVar, View view) {
            this.f63608a = fVar;
            this.f63609b = view;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            CJRAggsItem cJRAggsItem;
            List<CJRProductsItem> productList;
            net.one97.paytm.recharge.common.b.a aVar;
            StaticLayout staticLayout = null;
            RadioButton radioButton = radioGroup != null ? (RadioButton) radioGroup.findViewById(i2) : null;
            Object tag = radioButton != null ? radioButton.getTag() : null;
            if (tag instanceof Integer) {
                T t = ((CJRMobileRadioGroupV8) this.f63609b).f62093c.get(((Number) tag).intValue());
                if ((t instanceof CJRAggsItem) && (productList = cJRAggsItem.getProductList()) != null && !productList.isEmpty()) {
                    Long productId = (cJRAggsItem = (CJRAggsItem) t).getProductList().get(0).getProductId();
                    CJRProductsItem d2 = this.f63608a.n;
                    if (!kotlin.g.b.k.a((Object) productId, (Object) d2 != null ? d2.getProductId() : null)) {
                        f fVar = this.f63608a;
                        CJRAmountInputFieldWidgetV8 h2 = fVar.o;
                        if (h2 != null) {
                            staticLayout = h2.getCurrentInlineMessageStaticLayout();
                        }
                        fVar.r = staticLayout;
                        LinearLayout linearLayout = (LinearLayout) this.f63608a.b(R.id.container_product_input_fields);
                        if (linearLayout != null) {
                            linearLayout.removeAllViews();
                        }
                        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63608a.f63600h;
                        if (!(aVar2 == null || (aVar = aVar2.x) == null)) {
                            aVar.d();
                        }
                        this.f63608a.b();
                        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63608a.f63600h;
                        if (aVar3 != null) {
                            aVar3.a(cJRAggsItem.getProductList().get(0));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        net.one97.paytm.recharge.mobile.d.a aVar;
        LiveData liveData;
        androidx.lifecycle.z<CJRBrowsePlanProductList> zVar = this.f63606f;
        if (zVar != null && (aVar = this.f63600h) != null && (liveData = aVar.J) != null) {
            liveData.removeObserver(zVar);
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        LiveData liveData;
        String str;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        if (i2 != 607) {
            return super.a(i2, i3, intent);
        }
        if (!(super.a(i2, i3, intent) || (aVar = this.f63600h) == null || (liveData = aVar.z) == null || (str = (String) liveData.getValue()) == null || (aVar2 = this.f63600h) == null)) {
            kotlin.g.b.k.a((Object) str, "it");
            aVar2.a(str, false);
        }
        if (!this.U) {
            return true;
        }
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.toggleSoftInput(2, 0);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void c(int i2) {
        if (this.D) {
            this.D = false;
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
            if (cJRAmountInputFieldWidgetV8 != null) {
                cJRAmountInputFieldWidgetV8.c(true);
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FETCH_BILL.name());
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                net.one97.paytm.recharge.common.e.i iVar = this;
                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV82 = this.o;
                if (cJRAmountInputFieldWidgetV82 != null) {
                    str = cJRAmountInputFieldWidgetV82.getInputText();
                }
                aVar.a("fetch_mobile_bill", iVar, str, (Object) a2);
            }
        } else if (i2 == 800) {
            onClick((CJRProceedWidgetV8) b(R.id.btn_proceed));
        }
    }

    /* access modifiers changed from: protected */
    public final void d(int i2) {
        this.D = false;
        ay ayVar = ay.f61523a;
        ay.a(i2);
    }

    public void onDestroyView() {
        com.paytm.utility.g.a((g.a) null);
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.b((net.one97.paytm.recharge.common.e.n) this);
        }
        super.onDestroyView();
        u();
    }

    public final boolean ax_() {
        com.paytm.network.f.b(getContext()).cancelAll((Object) ba.f61539a);
        super.ax_();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "back_button_amount_screen", (Object) null, "back_button", (Object) null, (Object) null, (Object) null, 116);
        }
        net.one97.paytm.recharge.common.b.a aVar2 = this.f63601i;
        if (aVar2 == null) {
            return false;
        }
        aVar2.c();
        return false;
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63618a;

        g(f fVar) {
            this.f63618a = fVar;
        }

        public final void onClick(View view) {
            this.f63618a.a("fetch_mobile_bill", ACTION_TYPE.FETCH_BILL);
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.f$f  reason: collision with other inner class name */
    static final class C1237f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63616a;

        C1237f(f fVar) {
            this.f63616a = fVar;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f63616a.T >= 1000) {
                this.f63616a.T = SystemClock.elapsedRealtime();
                if (!this.f63616a.ac) {
                    this.f63616a.ac = true;
                    this.f63616a.v();
                    view.postDelayed(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ C1237f f63617a;

                        {
                            this.f63617a = r1;
                        }

                        public final void run() {
                            this.f63617a.f63616a.ac = false;
                        }
                    }, 1500);
                }
            }
        }
    }

    public final void a(String str, ACTION_TYPE action_type) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(action_type, "actionType");
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cJRAmountInputFieldWidgetV8.getActionPrimaryText(), View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new h(cJRAmountInputFieldWidgetV8, ofFloat, this, action_type, str));
            animatorSet.setDuration(200);
            animatorSet.play(ofFloat);
            animatorSet.start();
            if (cJRAmountInputFieldWidgetV8.hasFocus()) {
                this.A = false;
                cJRAmountInputFieldWidgetV8.e();
            }
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRAmountInputFieldWidgetV8 f63619a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63620b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f63621c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ACTION_TYPE f63622d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f63623e;

        h(CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8, ObjectAnimator objectAnimator, f fVar, ACTION_TYPE action_type, String str) {
            this.f63619a = cJRAmountInputFieldWidgetV8;
            this.f63620b = objectAnimator;
            this.f63621c = fVar;
            this.f63622d = action_type;
            this.f63623e = str;
        }

        public final void onAnimationEnd(Animator animator) {
            this.f63621c.B = true;
            this.f63619a.c(true);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(this.f63622d.name());
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63621c.f63600h;
            if (aVar != null) {
                String str2 = this.f63623e;
                f fVar = this.f63621c;
                net.one97.paytm.recharge.common.e.i iVar = fVar;
                CJRAmountInputFieldWidgetV8 h2 = fVar.o;
                if (h2 != null) {
                    str = h2.getInputText();
                }
                aVar.a(str2, iVar, str, (Object) a2);
            }
        }
    }

    public final void v() {
        String str;
        j();
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 != null) {
            cJRAmountInputFieldWidgetV8.clearFocus();
        }
        EditText editText = (EditText) b(R.id.dummy_focusable_view);
        if (editText != null) {
            editText.clearFocus();
        }
        CJRMobileRadioGroupV8<?> cJRMobileRadioGroupV8 = this.q;
        if (cJRMobileRadioGroupV8 != null) {
            cJRMobileRadioGroupV8.setViewSelectedByUser(false);
        }
        HashMap hashMap = new HashMap(1);
        Bundle bundle = new Bundle();
        StringBuilder sb = this.H;
        if (sb == null || (str = sb.toString()) == null) {
            str = "";
        }
        bundle.putString("title", str);
        int i2 = Build.VERSION.SDK_INT;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "Browse Plans_dropdown_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.a(hashMap, bundle);
        }
    }

    public final void a(String str, Object obj) {
        String str2;
        kotlin.g.b.k.c(str, "tag");
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 == null || (str2 = cJRAmountInputFieldWidgetV8.getInputText()) == null) {
            str2 = "";
        }
        String str3 = str2;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.b(str, this, str3, new String[]{"price"}, obj);
        }
    }

    public void afterTextChanged(Editable editable) {
        if (!this.F) {
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
            if (cJRAmountInputFieldWidgetV8 != null) {
                cJRAmountInputFieldWidgetV8.d("");
            }
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV82 = this.o;
            if (cJRAmountInputFieldWidgetV82 != null) {
                cJRAmountInputFieldWidgetV82.c("");
            }
            if (!this.s && !this.S) {
                this.P.onNext(String.valueOf(editable));
            }
            if (this.G) {
                this.G = false;
                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV83 = this.o;
                if (cJRAmountInputFieldWidgetV83 != null) {
                    cJRAmountInputFieldWidgetV83.c();
                }
                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV84 = this.o;
                if (cJRAmountInputFieldWidgetV84 != null) {
                    cJRAmountInputFieldWidgetV84.setDividerColor(R.color.color_00b9f5);
                }
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        c();
    }

    private final void c() {
        if (this.B) {
            this.B = false;
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
            if (cJRAmountInputFieldWidgetV8 != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cJRAmountInputFieldWidgetV8.getActionPrimaryText(), View.ALPHA, new float[]{0.0f, 1.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200);
                animatorSet.play(ofFloat);
                animatorSet.start();
            }
        }
    }

    public final void c(CJRServiceActions cJRServiceActions) {
        CJRInputFieldsItem cJRInputFieldsItem;
        CJRInputFieldsItem cJRInputFieldsItem2;
        kotlin.g.b.k.c(cJRServiceActions, "serviceAction");
        if (!TextUtils.isEmpty(cJRServiceActions.getBillAmountMax()) && (cJRInputFieldsItem2 = this.z) != null) {
            String billAmountMax = cJRServiceActions.getBillAmountMax();
            kotlin.g.b.k.a((Object) billAmountMax, "serviceAction.billAmountMax");
            cJRInputFieldsItem2.setMax(Double.valueOf(new BigDecimal(billAmountMax).doubleValue()));
        }
        if (!TextUtils.isEmpty(cJRServiceActions.getBillAmountMin()) && (cJRInputFieldsItem = this.z) != null) {
            String billAmountMin = cJRServiceActions.getBillAmountMin();
            kotlin.g.b.k.a((Object) billAmountMin, "serviceAction.billAmountMin");
            cJRInputFieldsItem.setMin(Double.valueOf(new BigDecimal(billAmountMin).doubleValue()));
        }
    }

    public final void a(CJRServiceActions cJRServiceActions, String str) {
        Object obj;
        kotlin.g.b.k.c(str, "amount");
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (obj = aVar.e()) == null) {
            obj = "";
        }
        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "bill_fetched_successfully", "", "bill due", (Object) null, (Object) null, (Object) null, 112);
        this.C = false;
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 != null) {
            cJRAmountInputFieldWidgetV8.c(false);
            if (cJRServiceActions != null) {
                c(cJRServiceActions);
            }
            String string = cJRAmountInputFieldWidgetV8.getContext().getString(R.string.fetch_bill_success);
            kotlin.g.b.k.a((Object) string, "context.getString(headerTextId)");
            cJRAmountInputFieldWidgetV8.d(string);
            j(str);
        }
    }

    public final void b(CJRServiceActions cJRServiceActions) {
        this.C = false;
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 != null) {
            cJRAmountInputFieldWidgetV8.c(false);
            View a2 = cJRAmountInputFieldWidgetV8.a(R.string.fetch_bill_failed, R.color.color_444444);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2, View.ALPHA, new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new i(cJRAmountInputFieldWidgetV8, a2, ofFloat, this, cJRServiceActions));
            animatorSet.setDuration(200);
            animatorSet.play(ofFloat);
            animatorSet.start();
        }
    }

    public static final class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRAmountInputFieldWidgetV8 f63624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63626c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f63627d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRServiceActions f63628e;

        i(CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8, View view, ObjectAnimator objectAnimator, f fVar, CJRServiceActions cJRServiceActions) {
            this.f63624a = cJRAmountInputFieldWidgetV8;
            this.f63625b = view;
            this.f63626c = objectAnimator;
            this.f63627d = fVar;
            this.f63628e = cJRServiceActions;
        }

        public final void onAnimationEnd(Animator animator) {
            this.f63624a.postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ i f63629a;

                {
                    this.f63629a = r1;
                }

                public final void run() {
                    final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f63629a.f63625b, View.TRANSLATION_X, new float[]{(float) this.f63629a.f63625b.getWidth()});
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.addListener(new AnimatorListenerAdapter(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f63630a;

                        {
                            this.f63630a = r1;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (this.f63630a.f63629a.f63628e != null) {
                                this.f63630a.f63629a.f63627d.c(this.f63630a.f63629a.f63628e);
                            }
                            this.f63630a.f63629a.f63624a.a(R.string.try_again, (View.OnClickListener) new View.OnClickListener(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AnonymousClass1 f63632a;

                                {
                                    this.f63632a = r1;
                                }

                                public final void onClick(View view) {
                                    this.f63632a.f63630a.f63629a.f63627d.a("fetch_mobile_bill", ACTION_TYPE.FETCH_BILL_TRY_AGAIN);
                                }
                            });
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f63630a.f63629a.f63625b, View.TRANSLATION_X, new float[]{0.0f});
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.setDuration(200);
                            animatorSet.play(ofFloat);
                            animatorSet.setStartDelay(100);
                            animatorSet.start();
                        }
                    });
                    animatorSet.setDuration(200);
                    animatorSet.play(ofFloat);
                    animatorSet.start();
                }
            }, 1000);
        }
    }

    public final void a(CJRServiceActions cJRServiceActions) {
        Object obj;
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (obj = aVar.e()) == null) {
            obj = "";
        }
        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "bill_fetched_successfully", "", "no outstanding", (Object) null, (Object) null, (Object) null, 112);
        this.C = false;
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 != null) {
            cJRAmountInputFieldWidgetV8.c(false);
            if (cJRServiceActions != null) {
                c(cJRServiceActions);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cJRAmountInputFieldWidgetV8.a(R.string.fetch_bill_no_outstanding, R.color.color_21c17a), View.ALPHA, new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200);
            animatorSet.play(ofFloat);
            animatorSet.start();
        }
    }

    public final Map<String, Object> q() {
        String str;
        String str2;
        String str3;
        String str4;
        LiveData liveData;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        LiveData liveData2;
        net.one97.paytm.recharge.common.h.b i2 = i();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData2 = aVar.z) == null || (str = (String) liveData2.getValue()) == null) {
            str = "";
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null || (str2 = cJRCategoryDataHelper.getGroupFieldValuesForGA()) == null) {
            str2 = "";
        }
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
        if (cJRAmountInputFieldWidgetV8 == null || (str3 = cJRAmountInputFieldWidgetV8.getInputText()) == null) {
            str3 = "";
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 == null || (liveData = aVar3.f61413f) == null || (str4 = (String) liveData.getValue()) == null) {
            str4 = "";
        }
        CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = (CJRMobileFastForwardWidgetV8) b(R.id.lyt_fast_forward);
        boolean z2 = true;
        if (cJRMobileFastForwardWidgetV8 == null || !cJRMobileFastForwardWidgetV8.a()) {
            z2 = false;
        }
        return i2.a(str, str2, str3, str4, z2);
    }

    static final class y<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63644a;

        y(f fVar) {
            this.f63644a = fVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.PLAN_AMOUNT_SEARCH.name());
            }
            this.f63644a.a("search_browse_plan", (Object) a2);
        }
    }

    public void a(CJRInstruct cJRInstruct) {
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8;
        super.a(cJRInstruct);
        if (cJRInstruct instanceof CJRInstruct.openCouponsActivity) {
            CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV82 = this.o;
            if (cJRAmountInputFieldWidgetV82 != null) {
                cJRAmountInputFieldWidgetV82.postDelayed(new u(this), 1000);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                aVar.L = null;
            }
        } else if (((cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity) || (cJRInstruct instanceof CJRInstruct.openPostOrderSummaryActivity)) && (cJRAmountInputFieldWidgetV8 = this.o) != null) {
            cJRAmountInputFieldWidgetV8.postDelayed(new v(this), 1000);
        }
    }

    static final class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63640a;

        u(f fVar) {
            this.f63640a = fVar;
        }

        public final void run() {
            this.f63640a.l();
        }
    }

    static final class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63641a;

        v(f fVar) {
            this.f63641a = fVar;
        }

        public final void run() {
            this.f63641a.l();
        }
    }

    static final class w implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63642a;

        w(f fVar) {
            this.f63642a = fVar;
        }

        public final void onOkClick() {
            com.paytm.utility.g.a((g.a) null);
            net.one97.paytm.recharge.mobile.d dVar = this.f63642a.f63599g;
            if (dVar != null) {
                dVar.d();
            }
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        Object obj2;
        String str2;
        String alertMessage;
        Object obj3;
        String str3;
        CRUFlowModel flowName;
        String alertMessage2;
        Object e2;
        String str4 = str;
        NetworkCustomError networkCustomError2 = networkCustomError;
        Object obj4 = obj;
        if (getActivity() != null && isAdded()) {
            if (str4 != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1673135277) {
                    if (hashCode == -1539539073 ? str4.equals("fetch_mobile_bill") : !(hashCode != -1527767841 || !str4.equals("fetch_mobile_bill_in_bg"))) {
                        if (networkCustomError2 instanceof net.one97.paytm.recharge.common.utils.al) {
                            Context context = getContext();
                            if (context == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) context, "context!!");
                            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                            if (aVar == null || (e2 = aVar.e()) == null) {
                                obj3 = "";
                            } else {
                                obj3 = e2;
                            }
                            net.one97.paytm.recharge.common.utils.al alVar = (net.one97.paytm.recharge.common.utils.al) networkCustomError2;
                            NetworkCustomError error = alVar.getError();
                            if (error == null || (alertMessage2 = error.getAlertMessage()) == null) {
                                str3 = "";
                            } else {
                                str3 = alertMessage2;
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj3, "Bill_fetch_error", "", str3, (Object) null, (Object) null, (Object) null, 112);
                            if (this.C) {
                                this.C = false;
                                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8 = this.o;
                                if (cJRAmountInputFieldWidgetV8 != null) {
                                    cJRAmountInputFieldWidgetV8.c(false);
                                }
                                c();
                                if (obj4 instanceof CJRRechargeErrorModel) {
                                    if ((alVar.getError() instanceof net.one97.paytm.recharge.common.utils.c) && (flowName = ((CJRRechargeErrorModel) obj4).getFlowName()) != null) {
                                        flowName.setErrorType(ERROR_TYPE.AUTH.name());
                                    }
                                    az azVar = az.f61525a;
                                    az.a((CJRRechargeErrorModel) obj4);
                                    return;
                                }
                                return;
                            }
                            b((CJRServiceActions) null);
                            if (alVar.getError() instanceof net.one97.paytm.recharge.common.utils.c) {
                                this.D = true;
                            } else {
                                this.D = false;
                            }
                            if (!kotlin.m.p.a("fetch_mobile_bill_in_bg", str4, true)) {
                                super.a(str4, alVar.getError(), obj4);
                                return;
                            } else if (obj4 instanceof CJRRechargeErrorModel) {
                                az azVar2 = az.f61525a;
                                az.a((CJRRechargeErrorModel) obj4);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            Context context2 = getContext();
                            if (context2 == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) context2, "context!!");
                            net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(context2);
                            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                            if (aVar2 == null || (obj2 = aVar2.e()) == null) {
                                obj2 = "";
                            }
                            if (networkCustomError2 == null || (alertMessage = networkCustomError.getAlertMessage()) == null) {
                                str2 = "";
                            } else {
                                str2 = alertMessage;
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, obj2, "Bill_fetch_error", "", str2, (Object) null, (Object) null, (Object) null, 112);
                            return;
                        }
                    }
                } else if (str4.equals("fetch_product_list")) {
                    this.D = false;
                    if (!this.E) {
                        this.E = true;
                        com.paytm.utility.g.a(this.ae);
                        super.a(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
            }
            this.D = false;
            super.a(str, networkCustomError, obj);
        }
    }

    public final void a(ErrorAction errorAction) {
        kotlin.g.b.k.c(errorAction, "action");
        int i2 = g.f63649d[errorAction.ordinal()];
        if (i2 == 1) {
            v();
        } else if (i2 == 2) {
            e("");
        }
    }

    public void onClick(View view) {
        String str;
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8;
        String str2;
        String str3;
        String str4;
        net.one97.paytm.recharge.mobile.d.a aVar;
        StringBuilder journeyStackTrace;
        HashMap<String, String> hashMap;
        String str5;
        HashMap<String, String> hashMap2;
        HashMap<String, String> hashMap3;
        HashMap<String, String> hashMap4;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        HashMap<String, String> hashMap5;
        CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage;
        Long l2 = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        TextView textView = (TextView) b(R.id.txt_mobile_no);
        if (kotlin.g.b.k.a((Object) valueOf, (Object) textView != null ? Integer.valueOf(textView.getId()) : null)) {
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (aVar3 != null) {
                net.one97.paytm.recharge.ordersummary.h.d dVar = aVar3.v;
                Object e2 = aVar3.e();
                String lowerCase = "NUMBER".toLowerCase();
                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "back_button_amount_screen", (Object) null, lowerCase, (Object) null, (Object) null, (Object) null, 116);
            }
            net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
            if (dVar2 != null) {
                dVar2.d();
                return;
            }
            return;
        }
        CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.ic_operator);
        if (!kotlin.g.b.k.a((Object) valueOf, (Object) cJRCircleImageViewV8 != null ? Integer.valueOf(cJRCircleImageViewV8.getId()) : null)) {
            TextView textView2 = (TextView) b(R.id.txt_update_operator);
            if (!kotlin.g.b.k.a((Object) valueOf, (Object) textView2 != null ? Integer.valueOf(textView2.getId()) : null)) {
                int i2 = R.id.btn_proceed;
                if (valueOf != null && valueOf.intValue() == i2 && (cJRAmountInputFieldWidgetV8 = this.o) != null) {
                    CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                    boolean z2 = false;
                    if (cJRProceedWidgetV8 != null) {
                        cJRProceedWidgetV8.setEnabled(false);
                    }
                    if (!this.v && (cJRSuccessRateAlertMessage = this.w) != null) {
                        if (!TextUtils.isEmpty(cJRSuccessRateAlertMessage != null ? cJRSuccessRateAlertMessage.getMessage() : null)) {
                            net.one97.paytm.recharge.common.c.g gVar = this.aa;
                            if (gVar == null) {
                                CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage2 = this.w;
                                if (cJRSuccessRateAlertMessage2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV82 = this.o;
                                this.aa = new net.one97.paytm.recharge.common.c.g(cJRSuccessRateAlertMessage2, a(cJRAmountInputFieldWidgetV82 != null ? cJRAmountInputFieldWidgetV82.getFormattedString() : null), new z(this));
                            } else if (gVar != null) {
                                CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage3 = this.w;
                                if (cJRSuccessRateAlertMessage3 == null) {
                                    kotlin.g.b.k.a();
                                }
                                gVar.a(cJRSuccessRateAlertMessage3);
                            }
                            net.one97.paytm.recharge.common.c.g gVar2 = this.aa;
                            if (gVar2 != null) {
                                if (gVar2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                if (!gVar2.isAdded()) {
                                    net.one97.paytm.recharge.common.c.g gVar3 = this.aa;
                                    if (gVar3 != null) {
                                        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                                        g.a aVar4 = net.one97.paytm.recharge.common.c.g.f60996a;
                                        gVar3.show(childFragmentManager, net.one97.paytm.recharge.common.c.g.f60997e);
                                    }
                                    net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                    CRUFlowModel flowName = a2.getFlowName();
                                    if (flowName != null) {
                                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                    }
                                    CRUFlowModel flowName2 = a2.getFlowName();
                                    if (flowName2 != null) {
                                        flowName2.setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
                                    }
                                    az azVar = az.f61525a;
                                    az.a(a2);
                                }
                            }
                        }
                    } else if (this.f63601i == null || !net.one97.paytm.recharge.common.b.a.a((View) cJRAmountInputFieldWidgetV8, cJRAmountInputFieldWidgetV8.getInputText(), false)) {
                        this.G = true;
                        l();
                        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV83 = this.o;
                        if (cJRAmountInputFieldWidgetV83 != null) {
                            if (cJRAmountInputFieldWidgetV83 == null) {
                                kotlin.g.b.k.a();
                            }
                            cJRAmountInputFieldWidgetV83.d();
                            NestedScrollView nestedScrollView = this.Y;
                            if (nestedScrollView != null) {
                                nestedScrollView.post(new j(this));
                            }
                        }
                    } else {
                        j();
                        ((CJRProceedWidgetV8) b(R.id.btn_proceed)).a();
                        View b2 = b(R.id.dummy_view);
                        if (b2 != null) {
                            net.one97.paytm.recharge.common.utils.ai.a(b2);
                        }
                        f();
                        net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                        if (aVar5 == null || (hashMap = aVar5.m) == null || !(!hashMap.isEmpty())) {
                            str4 = null;
                            str3 = null;
                        } else {
                            net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                            if (aVar6 == null || (hashMap4 = aVar6.m) == null || !hashMap4.containsKey("ref_id") || (aVar2 = this.f63600h) == null || (hashMap5 = aVar2.m) == null) {
                                str5 = null;
                            } else {
                                str5 = hashMap5.get("ref_id");
                            }
                            net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                            if (aVar7 == null || (hashMap2 = aVar7.m) == null || !hashMap2.containsKey("subregion_id")) {
                                str3 = null;
                                str4 = str5;
                            } else {
                                net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
                                str4 = str5;
                                str3 = (aVar8 == null || (hashMap3 = aVar8.m) == null) ? null : hashMap3.get("subregion_id");
                            }
                        }
                        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.CLP_PROCEED, ERROR_TYPE.UNDEFINED);
                        CRUFlowModel flowName3 = a3.getFlowName();
                        if (flowName3 != null) {
                            flowName3.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
                        }
                        CRUFlowModel flowName4 = a3.getFlowName();
                        if (!(flowName4 == null || (journeyStackTrace = flowName4.getJourneyStackTrace()) == null)) {
                            journeyStackTrace.append("-clpProceedFlow");
                        }
                        net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        net.one97.paytm.recharge.widgets.c.d.b(a3, ACTION_TYPE.CLP_PROCEED);
                        net.one97.paytm.recharge.widgets.c.d dVar6 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        net.one97.paytm.recharge.widgets.c.d.a(a3, ACTION_TYPE.CLP_PROCEED);
                        FragmentActivity activity = getActivity();
                        if (!(activity == null || (aVar = this.f63600h) == null)) {
                            kotlin.g.b.k.a((Object) activity, "it");
                            z2 = aVar.a(activity, "verify", cJRAmountInputFieldWidgetV8.getInputText(), ((CJRMobileFastForwardWidgetV8) b(R.id.lyt_fast_forward)).a(), this.f61113e, str4, str3, a3, (CJRPersonalInsurance) null, (String) null, (net.one97.paytm.recharge.common.utils.o) null);
                        }
                        if (!z2) {
                            az azVar2 = az.f61525a;
                            az.a(a3);
                        }
                    }
                    net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
                    if (aVar9 != null) {
                        net.one97.paytm.recharge.ordersummary.h.d.a(aVar9.v, aVar9.e(), "amount_entered_non_prefetch", (Object) null, cJRAmountInputFieldWidgetV8.getInputText(), (Object) null, (Object) null, (Object) null, 116);
                        if (((CJRMobileFastForwardWidgetV8) b(R.id.lyt_fast_forward)).a()) {
                            if (this.X) {
                                d.a aVar10 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                str2 = net.one97.paytm.recharge.ordersummary.h.d.j;
                            } else {
                                d.a aVar11 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                str2 = net.one97.paytm.recharge.ordersummary.h.d.f64341h;
                            }
                        } else if (this.X) {
                            d.a aVar12 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                            str2 = net.one97.paytm.recharge.ordersummary.h.d.k;
                        } else {
                            d.a aVar13 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                            str2 = net.one97.paytm.recharge.ordersummary.h.d.f64342i;
                        }
                        String str6 = str2;
                        net.one97.paytm.recharge.ordersummary.h.d dVar7 = aVar9.v;
                        Object e3 = aVar9.e();
                        String str7 = net.one97.paytm.common.utility.d.ez;
                        kotlin.g.b.k.a((Object) str7, "CJRGTMConstants.GTM_EVENT_PROCEED_CLICKED");
                        CJRProductsItem cJRProductsItem = this.n;
                        if (cJRProductsItem != null) {
                            l2 = cJRProductsItem.getProductId();
                        }
                        net.one97.paytm.recharge.ordersummary.h.d.a(dVar7, e3, str7, (Object) null, str6, (Object) null, String.valueOf(l2), (Object) null, 84);
                    }
                    new Handler().postDelayed(new k(this), 1000);
                    return;
                }
                return;
            }
        }
        if (SystemClock.elapsedRealtime() - this.T >= 1000) {
            this.T = SystemClock.elapsedRealtime();
            if (view != null) {
                int id = view.getId();
                CJRCircleImageViewV8 cJRCircleImageViewV82 = (CJRCircleImageViewV8) b(R.id.ic_operator);
                kotlin.g.b.k.a((Object) cJRCircleImageViewV82, "ic_operator");
                if (id == cJRCircleImageViewV82.getId()) {
                    str = H5Param.MENU_ICON;
                    e(str);
                }
            }
            str = "link";
            e(str);
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63633a;

        j(f fVar) {
            this.f63633a = fVar;
        }

        public final void run() {
            NestedScrollView k = this.f63633a.Y;
            if (k != null) {
                CJRAmountInputFieldWidgetV8 h2 = this.f63633a.o;
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                k.scrollTo(0, h2.getErrorView().getBottom());
            }
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63634a;

        k(f fVar) {
            this.f63634a = fVar;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f63634a.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r8, com.paytm.network.model.IJRPaytmDataModel r9, java.lang.Object r10) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            int r10 = r8.hashCode()
            r0 = -2042516569(0xffffffff8641aba7, float:-3.6425376E-35)
            java.lang.String r1 = "search_browse_plan"
            if (r10 == r0) goto L_0x001e
            r0 = -1650697714(0xffffffff9d9c5a0e, float:-4.138597E-21)
            if (r10 == r0) goto L_0x0015
            goto L_0x0086
        L_0x0015:
            java.lang.String r10 = "search_browse_plan_prefill"
            boolean r10 = r8.equals(r10)
            if (r10 == 0) goto L_0x0086
            goto L_0x0024
        L_0x001e:
            boolean r10 = r8.equals(r1)
            if (r10 == 0) goto L_0x0086
        L_0x0024:
            boolean r10 = r9 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8
            if (r10 == 0) goto L_0x0086
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r10 = r7.o
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0034
            java.lang.String r10 = r10.getInputText()
            if (r10 != 0) goto L_0x0035
        L_0x0034:
            r10 = r0
        L_0x0035:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r9 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r9
            java.util.List r9 = r9.getProductList()
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L_0x0072
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0045:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0070
            java.lang.Object r4 = r9.next()
            r5 = r4
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r5 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r5
            java.lang.String r6 = "it"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.Double r5 = r5.getPrice()
            if (r5 == 0) goto L_0x0068
            double r5 = r5.doubleValue()
            int r5 = (int) r5
            java.lang.String r5 = java.lang.String.valueOf(r5)
            if (r5 != 0) goto L_0x0069
        L_0x0068:
            r5 = r0
        L_0x0069:
            boolean r5 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r5, (boolean) r3)
            if (r5 == 0) goto L_0x0045
            r2 = r4
        L_0x0070:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r2 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r2
        L_0x0072:
            if (r2 == 0) goto L_0x0086
            boolean r8 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r3)
            if (r8 == 0) goto L_0x007d
            r7.t = r3
            goto L_0x007f
        L_0x007d:
            r7.u = r3
        L_0x007f:
            net.one97.paytm.recharge.mobile.d.a r8 = r7.f63600h
            if (r8 == 0) goto L_0x0086
            r8.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r2)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2042516569) {
                if (hashCode != -1650697714 || !str.equals("search_browse_plan_prefill")) {
                    return;
                }
            } else if (!str.equals("search_browse_plan")) {
                return;
            }
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63645a;

        z(f fVar) {
            this.f63645a = fVar;
        }

        public final void onClick(View view) {
            f fVar = this.f63645a;
            kotlin.g.b.k.a((Object) view, "v");
            f.a(fVar, view);
        }
    }

    public final void a(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage) {
        this.w = cJRSuccessRateAlertMessage;
    }

    /* access modifiers changed from: private */
    public final void d() {
        View b2 = b(R.id.bill_reminder_view);
        if (b2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(b2);
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8;
        if (((CustomSwitch) b(R.id.bill_reminder_switcher)) != null) {
            CustomSwitch customSwitch = (CustomSwitch) b(R.id.bill_reminder_switcher);
            if (customSwitch == null || !customSwitch.isChecked()) {
                if (this.K && net.one97.paytm.recharge.common.utils.z.a((Context) getActivity()) && com.paytm.utility.b.c((Context) getActivity())) {
                    HashMap hashMap = new HashMap();
                    Map map = hashMap;
                    map.put("Content-Type", "application/json");
                    Context context = getContext();
                    if (context != null) {
                        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                        kotlin.g.b.k.a((Object) context, "it");
                        map.put(AppConstants.SSO_TOKEN, cJRRechargeUtilities.getSSOToken(context));
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(StringSet.operator, this.af.get(StringSet.operator));
                        jSONObject.put("rechargeNumber", this.af.get("rechargeNumber"));
                        jSONObject.put("notificationStatus", 0);
                        jSONObject.put("stopBillFetch", true);
                        jSONObject.put("customerId", com.paytm.utility.b.n(getContext()));
                        Context context2 = getContext();
                        if (context2 != null) {
                            CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
                            kotlin.g.b.k.a((Object) context2, "it");
                            jSONObject.put(AppConstants.SSO_TOKEN, cJRRechargeUtilities2.getSSOToken(context2));
                        }
                    } catch (JSONException e2) {
                        com.paytm.utility.q.d(e2.getMessage());
                    }
                    net.one97.paytm.recharge.common.h.f fVar = this.I;
                    if (fVar != null) {
                        String jSONObject2 = jSONObject.toString();
                        kotlin.g.b.k.a((Object) jSONObject2, "body.toString()");
                        kotlin.g.b.k.c(hashMap, H5Logger.HEADER);
                        kotlin.g.b.k.c(jSONObject2, "body");
                        net.one97.paytm.recharge.common.utils.w wVar = fVar.f61443f;
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.BILL_CONSENT, ERROR_TYPE.UNDEFINED);
                        kotlin.g.b.k.c("consent_unsubscribe", "tag");
                        kotlin.g.b.k.c(hashMap, H5Logger.HEADER);
                        kotlin.g.b.k.c(jSONObject2, "body");
                        net.one97.paytm.recharge.common.b.c cVar = wVar.f61789i;
                        if (cVar != null) {
                            cVar.a("consent_unsubscribe", wVar, jSONObject2, hashMap, a2);
                        }
                    }
                }
            } else if (net.one97.paytm.recharge.common.utils.z.a((Context) getActivity()) && com.paytm.utility.b.c((Context) getActivity()) && (cJRAmountInputFieldWidgetV8 = this.o) != null) {
                this.af.put("amount", cJRAmountInputFieldWidgetV8.getInputText());
                if (!TextUtils.isEmpty(com.paytm.utility.b.l((Context) getActivity()))) {
                    this.af.put("customerMobile", com.paytm.utility.b.l((Context) getActivity()));
                }
                if (!TextUtils.isEmpty(com.paytm.utility.b.m((Context) getActivity()))) {
                    this.af.put("customerEmail", com.paytm.utility.b.m((Context) getActivity()));
                }
                net.one97.paytm.recharge.common.h.f fVar2 = this.I;
                if (fVar2 != null) {
                    fVar2.b(this.af);
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.b.c cVar = this.O;
        if (cVar != null) {
            cVar.dispose();
        }
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && this.U) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).az_();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    net.one97.paytm.recharge.common.e.y yVar = (net.one97.paytm.recharge.common.e.y) activity2;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        yVar.b(activity3.getResources().getString(R.string.recharge_tabs_toolbar_title));
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.content.Context");
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void onResume() {
        super.onResume();
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && this.U && this.V) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity2).i();
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        kotlin.g.b.k.c(view, "view");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        LiveData liveData3 = null;
        if (!(aVar == null || (dVar = aVar.v) == null)) {
            Context context = getContext();
            StringBuilder sb = new StringBuilder("/");
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            sb.append(aVar2 != null ? aVar2.e() : null);
            sb.append("/amount");
            dVar.a(context, sb.toString());
        }
        a((Toolbar) b(R.id.toolbar));
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        kotlin.g.b.k.a((Object) toolbar, "toolbar");
        toolbar.setTitle((CharSequence) "");
        CustomSwitch customSwitch = (CustomSwitch) b(R.id.bill_reminder_switcher);
        if (customSwitch != null) {
            customSwitch.setOnCheckedChangeListener(new q(this));
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            liveData = aVar3.z;
        } else {
            liveData = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new r(this));
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        if (aVar4 != null) {
            liveData2 = aVar4.F;
        } else {
            liveData2 = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData2, new s(this));
        this.O = this.P.debounce(600, TimeUnit.MILLISECONDS).filter(x.f63643a).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new y(this));
        net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
        if (aVar5 != null) {
            liveData3 = aVar5.G;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData3, new t(this));
        this.Y = (NestedScrollView) view.findViewById(R.id.upper_section);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r0 = r0.getPrice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            net.one97.paytm.recharge.mobile.d.a r13 = r11.f63600h
            r14 = 1
            r15 = 0
            if (r13 == 0) goto L_0x0097
            boolean r0 = r11.s
            r1 = 0
            if (r0 == 0) goto L_0x0056
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r13.J
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
            if (r0 == 0) goto L_0x0026
            java.lang.Double r0 = r0.getPrice()
            if (r0 == 0) goto L_0x0026
            double r2 = r0.doubleValue()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            goto L_0x0027
        L_0x0026:
            r0 = r15
        L_0x0027:
            java.lang.String r0 = r11.k((java.lang.String) r0)
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r2 = r11.o
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = r2.getInputText()
            goto L_0x0035
        L_0x0034:
            r2 = r15
        L_0x0035:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r14)
            if (r0 != 0) goto L_0x0056
            r11.s = r1
            net.one97.paytm.recharge.mobile.d.a r0 = r11.f63600h
            if (r0 == 0) goto L_0x004e
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r0.J
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x004e
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
            goto L_0x004f
        L_0x004e:
            r0 = r15
        L_0x004f:
            if (r0 == 0) goto L_0x0053
            r11.Z = r14
        L_0x0053:
            r13.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r15)
        L_0x0056:
            boolean r13 = r11.Z
            if (r13 == 0) goto L_0x0097
            if (r12 == 0) goto L_0x0065
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r12 = 0
            goto L_0x0066
        L_0x0065:
            r12 = 1
        L_0x0066:
            if (r12 == 0) goto L_0x0097
            net.one97.paytm.recharge.ordersummary.h.d r2 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x0073
            kotlin.g.b.k.a()
        L_0x0073:
            java.lang.String r13 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r2.<init>(r12)
            net.one97.paytm.recharge.mobile.d.a r12 = r11.f63600h
            if (r12 == 0) goto L_0x0085
            java.lang.Object r12 = r12.e()
            if (r12 != 0) goto L_0x0087
        L_0x0085:
            java.lang.String r12 = ""
        L_0x0087:
            r3 = r12
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 120(0x78, float:1.68E-43)
            java.lang.String r4 = "plan_removed"
            java.lang.String r5 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.Z = r1
        L_0x0097:
            int r12 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r12 = r11.b((int) r12)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r12 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r12
            if (r12 == 0) goto L_0x00c0
            boolean r12 = r12.a()
            if (r12 != r14) goto L_0x00c0
            int r12 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r12 = r11.b((int) r12)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r12 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r12
            if (r12 == 0) goto L_0x00c0
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r13 = r11.o
            if (r13 == 0) goto L_0x00b9
            java.lang.String r15 = r13.getFormattedString()
        L_0x00b9:
            java.lang.String r13 = r11.a((java.lang.String) r15)
            r12.setProceedBtnText(r13)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String n() {
        /*
            r1 = this;
            net.one97.paytm.recharge.mobile.d.a r0 = r1.f63600h
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = r0.L
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r0 = ""
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.n():java.lang.String");
    }

    public final boolean o() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        return aVar != null && aVar.o();
    }

    public final void l() {
        net.one97.paytm.recharge.common.c.g gVar;
        try {
            net.one97.paytm.recharge.common.c.g gVar2 = this.aa;
            if (!(gVar2 == null || !gVar2.isVisible() || (gVar = this.aa) == null)) {
                gVar.dismiss();
            }
        } catch (Exception unused) {
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        View b2 = b(R.id.dummy_view);
        if (b2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(b2);
        }
    }

    public static final /* synthetic */ void c(f fVar) {
        View b2 = fVar.b(R.id.bill_reminder_view);
        if (b2 != null) {
            net.one97.paytm.recharge.common.utils.ai.a(b2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) (r0 = r0.y).getValue();
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.mobile.a.f r8, java.util.LinkedList r9) {
        /*
            net.one97.paytm.recharge.mobile.d.a r0 = r8.f63600h
            r1 = 0
            if (r0 == 0) goto L_0x0018
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r0 = r0.y
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0018
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r0 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r0
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getLabel()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r8.H = r3
            boolean r3 = net.one97.paytm.recharge.common.utils.g.c(r0)
            if (r3 == 0) goto L_0x0033
            r2.append(r0)
            java.lang.String r0 = ","
            r2.append(r0)
        L_0x0033:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r0 = r1
        L_0x003a:
            boolean r3 = r9.hasNext()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00a7
            java.lang.Object r3 = r9.next()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r3 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = " "
            r5.<init>(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r7 = r3.getItem()
            if (r7 == 0) goto L_0x005b
            java.lang.String r7 = r7.getDisplayValue()
            if (r7 != 0) goto L_0x005c
        L_0x005b:
            r7 = r4
        L_0x005c:
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.StringBuilder r5 = r8.H
            if (r5 == 0) goto L_0x0087
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r3.getItem()
            if (r6 == 0) goto L_0x007d
            java.lang.String r6 = r6.getDisplayValue()
            if (r6 != 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r4 = r6
        L_0x007d:
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r5.append(r4)
        L_0x0087:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = r3.getItem()
            if (r4 == 0) goto L_0x0092
            java.lang.String r4 = r4.getImageUrl()
            goto L_0x0093
        L_0x0092:
            r4 = r1
        L_0x0093:
            boolean r4 = net.one97.paytm.recharge.common.utils.g.c(r4)
            if (r4 == 0) goto L_0x003a
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r3.getItem()
            if (r0 != 0) goto L_0x00a2
            kotlin.g.b.k.a()
        L_0x00a2:
            java.lang.String r0 = r0.getImageUrl()
            goto L_0x003a
        L_0x00a7:
            int r9 = net.one97.paytm.recharge.R.id.txt_operator
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r3 = "txt_operator"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r9.setText(r2)
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            r2 = 0
            if (r9 != 0) goto L_0x00db
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r0)
            int r0 = net.one97.paytm.recharge.R.id.ic_operator
            android.view.View r0 = r8.b((int) r0)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r0 = (net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8) r0
            r9.a((android.widget.ImageView) r0)
            goto L_0x00e6
        L_0x00db:
            int r9 = net.one97.paytm.recharge.R.id.ic_operator
            android.view.View r9 = r8.b((int) r9)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r9 = (net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8) r9
            r9.setImageResource(r2)
        L_0x00e6:
            net.one97.paytm.recharge.mobile.d.a r9 = r8.f63600h
            if (r9 == 0) goto L_0x0104
            net.one97.paytm.recharge.model.ContactItemModel r9 = r9.C
            if (r9 == 0) goto L_0x0104
            java.lang.String r0 = r9.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0127
            java.lang.String r9 = r9.getName()
            java.lang.String r0 = "it.name"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            goto L_0x0128
        L_0x0104:
            r9 = r8
            net.one97.paytm.recharge.mobile.a.f r9 = (net.one97.paytm.recharge.mobile.a.f) r9
            net.one97.paytm.recharge.mobile.d.a r9 = r9.f63600h
            if (r9 == 0) goto L_0x0127
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r9 = r9.j()
            if (r9 == 0) goto L_0x0127
            java.lang.String r0 = r9.getContactName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0127
            java.lang.String r9 = r9.getContactName()
            java.lang.String r0 = "it.contactName"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            goto L_0x0128
        L_0x0127:
            r9 = r4
        L_0x0128:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x014b
            int r0 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x013d
            r0.setText(r9)
        L_0x013d:
            int r9 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0175
            r9.setVisibility(r2)
            goto L_0x0175
        L_0x014b:
            int r9 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x015a
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r9.setText(r4)
        L_0x015a:
            int r9 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0169
            r0 = 8
            r9.setVisibility(r0)
        L_0x0169:
            java.util.concurrent.Executor r9 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            net.one97.paytm.recharge.mobile.a.f$o r0 = new net.one97.paytm.recharge.mobile.a.f$o
            r0.<init>(r8)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r9.execute(r0)
        L_0x0175:
            int r9 = net.one97.paytm.recharge.R.id.txt_update_operator
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = r8
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            int r9 = net.one97.paytm.recharge.R.id.txt_mobile_no
            android.view.View r9 = r8.b((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r9.setOnClickListener(r0)
            int r9 = net.one97.paytm.recharge.R.id.ic_operator
            android.view.View r9 = r8.b((int) r9)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r9 = (net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8) r9
            r9.setOnClickListener(r0)
            int r9 = net.one97.paytm.recharge.R.id.container_product_type
            android.view.View r9 = r8.b((int) r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r9.removeAllViews()
            int r9 = net.one97.paytm.recharge.R.id.container_product_input_fields
            android.view.View r9 = r8.b((int) r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r9.removeAllViews()
            net.one97.paytm.recharge.mobile.d.a r9 = r8.f63600h
            if (r9 == 0) goto L_0x01ba
            net.one97.paytm.recharge.common.b.a r9 = r9.x
            if (r9 == 0) goto L_0x01ba
            r9.c()
        L_0x01ba:
            net.one97.paytm.recharge.mobile.d.a r9 = r8.f63600h
            if (r9 == 0) goto L_0x01c1
            r9.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1)
        L_0x01c1:
            r8.Z = r2
            r8.R = r2
            r8.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.a(net.one97.paytm.recharge.mobile.a.f, java.util.LinkedList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0063 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.recharge.mobile.a.f r9, java.util.LinkedList r10) {
        /*
            net.one97.paytm.recharge.mobile.d.a r0 = r9.f63600h
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00fe
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x00fe
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x00fe
            boolean r0 = r0.isProductListInLastGrouping()
            if (r0 != r2) goto L_0x00fe
            java.lang.Object r10 = r10.getLast()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r10 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r10
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r10.getItem()
            if (r0 == 0) goto L_0x00cd
            java.util.List r0 = r0.getAggs()
            if (r0 == 0) goto L_0x00cd
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00cd
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = r10.getItem()
            if (r10 == 0) goto L_0x00cb
            java.util.List r10 = r10.getAggs()
            if (r10 == 0) goto L_0x00cb
            r9.p = r10
            net.one97.paytm.recharge.mobile.d.a r0 = r9.f63600h
            if (r0 == 0) goto L_0x0054
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0054
            java.lang.Long r0 = r0.getProductId()
            goto L_0x0055
        L_0x0054:
            r0 = r1
        L_0x0055:
            r4 = r10
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0063:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00ad
            java.lang.Object r6 = r4.next()
            r7 = r6
            net.one97.paytm.recharge.model.v4.CJRAggsItem r7 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r7
            java.util.List r7 = r7.getProductList()
            if (r7 == 0) goto L_0x00a6
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L_0x0085
            r8 = r7
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00a1
        L_0x0085:
            java.util.Iterator r7 = r7.iterator()
        L_0x0089:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00a1
            java.lang.Object r8 = r7.next()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r8
            java.lang.Long r8 = r8.getProductId()
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 == 0) goto L_0x0089
            r7 = 0
            goto L_0x00a2
        L_0x00a1:
            r7 = 1
        L_0x00a2:
            if (r7 != 0) goto L_0x00a6
            r7 = 1
            goto L_0x00a7
        L_0x00a6:
            r7 = 0
        L_0x00a7:
            if (r7 == 0) goto L_0x0063
            r5.add(r6)
            goto L_0x0063
        L_0x00ad:
            java.util.List r5 = (java.util.List) r5
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x00c0
            java.lang.Object r10 = r5.get(r3)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r10
            java.util.List r10 = r10.getProductList()
            goto L_0x00d7
        L_0x00c0:
            java.lang.Object r10 = r10.get(r3)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r10
            java.util.List r10 = r10.getProductList()
            goto L_0x00d7
        L_0x00cb:
            r10 = r1
            goto L_0x00d7
        L_0x00cd:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = r10.getItem()
            if (r10 == 0) goto L_0x00cb
            java.util.List r10 = r10.getProductList()
        L_0x00d7:
            if (r10 == 0) goto L_0x00f6
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x00f6
            net.one97.paytm.recharge.mobile.d.a r9 = r9.f63600h
            if (r9 == 0) goto L_0x00f5
            if (r10 != 0) goto L_0x00ec
            kotlin.g.b.k.a()
        L_0x00ec:
            java.lang.Object r10 = r10.get(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r10 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r10
            r9.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r10)
        L_0x00f5:
            return
        L_0x00f6:
            net.one97.paytm.recharge.mobile.d.a r9 = r9.f63600h
            if (r9 == 0) goto L_0x00fd
            r9.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r1)
        L_0x00fd:
            return
        L_0x00fe:
            net.one97.paytm.recharge.mobile.d.a r10 = r9.f63600h
            if (r10 != 0) goto L_0x0104
            r10 = 1
            goto L_0x0105
        L_0x0104:
            r10 = 0
        L_0x0105:
            net.one97.paytm.recharge.mobile.d.a r0 = r9.f63600h
            if (r0 == 0) goto L_0x010c
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            goto L_0x010d
        L_0x010c:
            r0 = r1
        L_0x010d:
            if (r0 != 0) goto L_0x0111
            r0 = 1
            goto L_0x0112
        L_0x0111:
            r0 = 0
        L_0x0112:
            net.one97.paytm.recharge.mobile.d.a r4 = r9.f63600h
            if (r4 == 0) goto L_0x011f
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r4.f61409b
            if (r4 == 0) goto L_0x011f
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            goto L_0x0120
        L_0x011f:
            r4 = r1
        L_0x0120:
            if (r4 != 0) goto L_0x0124
            r4 = 1
            goto L_0x0125
        L_0x0124:
            r4 = 0
        L_0x0125:
            net.one97.paytm.recharge.mobile.d.a r5 = r9.f63600h
            if (r5 == 0) goto L_0x013a
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
            if (r5 == 0) goto L_0x013a
            net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = r5.getCategoryData()
            if (r5 == 0) goto L_0x013a
            boolean r5 = r5.isProductListInLastGrouping()
            if (r5 != r2) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r2 = 0
        L_0x013b:
            net.one97.paytm.recharge.mobile.d.a r5 = r9.f63600h
            if (r5 == 0) goto L_0x014b
            java.lang.Object r5 = r5.e()
            if (r5 == 0) goto L_0x014b
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x014d
        L_0x014b:
            java.lang.String r5 = "Mobile"
        L_0x014d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r8 = " requesting getProductList()"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r7 = " isViewModelNull: "
            java.lang.String r10 = r7.concat(r10)
            r6.append(r10)
            java.lang.String r10 = java.lang.String.valueOf(r0)
            java.lang.String r0 = " isCategoryDataHelperNull: "
            java.lang.String r10 = r0.concat(r10)
            r6.append(r10)
            java.lang.String r10 = java.lang.String.valueOf(r4)
            java.lang.String r0 = " isCategoryDataNull: "
            java.lang.String r10 = r0.concat(r10)
            r6.append(r10)
            java.lang.String r10 = java.lang.String.valueOf(r2)
            java.lang.String r0 = " isProductListInLastGrouping: "
            java.lang.String r10 = r0.concat(r10)
            r6.append(r10)
            net.one97.paytm.recharge.widgets.c.d r10 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            java.lang.String r0 = "1721"
            r10.setErrorCode(r0)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r10.setErrorType(r0)
            java.lang.String r0 = r6.toString()
            r10.setErrorMsg(r0)
            r10.setScreenName(r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r10.getFlowName()
            if (r0 == 0) goto L_0x01c0
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x01c0:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r10.getFlowName()
            if (r0 == 0) goto L_0x01cf
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.MISSING_PRODUCT_IN_LAST_GROUPING
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x01cf:
            r9.E = r3
            net.one97.paytm.recharge.mobile.d.a r9 = r9.f63600h
            if (r9 == 0) goto L_0x01da
            java.lang.String r0 = "fetch_product_list"
            r9.b(r0, r10)
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.f.b(net.one97.paytm.recharge.mobile.a.f, java.util.LinkedList):void");
    }

    public static final /* synthetic */ void b(f fVar, CJRProductsItem cJRProductsItem) {
        if (!fVar.J || !net.one97.paytm.recharge.common.utils.z.a((Context) fVar.getActivity()) || !com.paytm.utility.b.c((Context) fVar.getActivity()) || !cJRProductsItem.isRemindable() || !cJRProductsItem.isPostPaid()) {
            fVar.d();
            return;
        }
        fVar.af.put("paytype", cJRProductsItem.getPaytype());
        fVar.af.put("service", cJRProductsItem.getService());
        fVar.af.put("circle", cJRProductsItem.getCircle());
        fVar.af.put(StringSet.operator, cJRProductsItem.getOperator());
        TextView textView = (TextView) fVar.b(R.id.txt_mobile_no);
        kotlin.g.b.k.a((Object) textView, "txt_mobile_no");
        fVar.af.put("rechargeNumber", textView.getText().toString());
        fVar.af.put("productId", String.valueOf(cJRProductsItem.getProductId()));
        fVar.af.put("customerId", com.paytm.utility.b.n((Context) fVar.getActivity()));
        net.one97.paytm.recharge.common.h.f fVar2 = fVar.I;
        if (fVar2 != null) {
            fVar2.c(fVar.af);
        }
    }

    public static final /* synthetic */ void a(f fVar, View view) {
        fVar.v = true;
        if (view instanceof CJRProceedWidgetV8) {
            ((CJRProceedWidgetV8) view).a();
        }
        fVar.onClick((CJRProceedWidgetV8) fVar.b(R.id.btn_proceed));
    }
}
