package net.one97.paytm.recharge.creditcard.v4.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeBaseActivityV8;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.u;
import net.one97.paytm.recharge.common.fragment.e;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bc;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.creditcard.c.a;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.b.b;
import net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.mobile_v3.a.a;
import net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.CJRPromoCode;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class AJRCreditCardEnterAmountActivityV4 extends AJRRechargeBaseActivityV8 implements TextWatcher, View.OnClickListener, View.OnTouchListener, ai, u, e.a, b.C1208b, a.b, net.one97.paytm.recharge.widgets.b.c<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f62527a = new b((byte) 0);
    private String A = "";
    private final String B = "get_credit_card_token_silent";
    private net.one97.paytm.recharge.mobile_v3.a.a C;
    private a D;
    private final Typeface E = Typeface.create("sans-serif-medium", 1);
    private final Typeface F = Typeface.create("sans-serif-medium", 0);
    private boolean G;
    private boolean H;
    private CJRRechargeCart I;
    private CJRPromoCode J;
    private HashMap K;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.creditcard.c.a f62528b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRCreditCardTokenizationModel f62529c;

    /* renamed from: d  reason: collision with root package name */
    private CJRCreditCardModelV8 f62530d;

    /* renamed from: e  reason: collision with root package name */
    private CJRItem f62531e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f62532f;

    /* renamed from: g  reason: collision with root package name */
    private String f62533g = "";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CustomAmountTextInputEditTextV8 f62534h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRProductsItem f62535i;
    private boolean j;
    private CJRRechargeCart k;
    private boolean l;
    private boolean m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    private net.one97.paytm.recharge.ordersummary.h.d p;
    private final String q = "credit_card";
    private CJRInputFieldsItem r;
    private CJRCategoryData s;
    private boolean t;
    private net.one97.paytm.recharge.common.utils.o u;
    private String v = "";
    private boolean w;
    private boolean x;
    private final String y = "tag.personal.insurance";
    private CJRPersonalInsurance z;

    public enum a {
        TOTAL_DUE,
        MIN_DUE,
        ANY_AMOUNT
    }

    public final View a(int i2) {
        if (this.K == null) {
            this.K = new HashMap();
        }
        View view = (View) this.K.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.K.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        c(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            super(3, aJRCreditCardEnterAmountActivityV4);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivityV4.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivityV4) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class j extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        j(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            super(3, aJRCreditCardEnterAmountActivityV4);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivityV4.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivityV4) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class k extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        k(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            super(1, aJRCreditCardEnterAmountActivityV4);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivityV4.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((AJRCreditCardEnterAmountActivityV4) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class l extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        l(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            super(3, aJRCreditCardEnterAmountActivityV4);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivityV4.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivityV4) this.receiver).a(str, networkCustomError, obj);
        }
    }

    public final int a() {
        return R.style.CreditCardAmountTheme;
    }

    public final void a(Toolbar toolbar) {
        super.a(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.a((CharSequence) "");
        }
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.back_arrow);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:259:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0573  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0578  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0586  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0706  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0782  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0787  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0793  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0798  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x07a1  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x08e4  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x090a  */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x095a  */
    /* JADX WARNING: Removed duplicated region for block: B:478:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            com.paytm.utility.b.e((android.app.Activity) r1)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "CCAmount Screen: isRecreated "
            r3.<init>(r4)
            r4 = 0
            r5 = 1
            if (r20 == 0) goto L_0x0017
            r6 = 1
            goto L_0x0018
        L_0x0017:
            r6 = 0
        L_0x0018:
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.debugLog(r3)
            r0.setRequestedOrientation(r5)
            android.content.Intent r2 = r19.getIntent()
            if (r2 == 0) goto L_0x093d
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r3 = "intent"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L_0x093d
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r3 = "recharge_item"
            boolean r2 = r2.hasExtra(r3)
            if (r2 == 0) goto L_0x093d
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r6 = "selected_item"
            boolean r2 = r2.hasExtra(r6)
            if (r2 != 0) goto L_0x0055
            goto L_0x093d
        L_0x0055:
            android.content.Intent r2 = r19.getIntent()
            java.io.Serializable r2 = r2.getSerializableExtra(r3)
            if (r2 == 0) goto L_0x0935
            net.one97.paytm.common.entity.CJRItem r2 = (net.one97.paytm.common.entity.CJRItem) r2
            r0.f62531e = r2
            android.content.Intent r2 = r19.getIntent()
            java.io.Serializable r2 = r2.getSerializableExtra(r6)
            if (r2 == 0) goto L_0x092d
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r2
            r0.f62530d = r2
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r3 = "intent_extra_cst_order_item"
            java.io.Serializable r2 = r2.getSerializableExtra(r3)
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r2
            r0.s = r2
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r3 = "From"
            java.lang.String r2 = r2.getStringExtra(r3)
            java.lang.String r3 = "saved_card"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r5)
            r0.f62532f = r2
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            r3 = 0
            if (r2 == 0) goto L_0x009b
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getSelectedDCVariant()
            goto L_0x009c
        L_0x009b:
            r2 = r3
        L_0x009c:
            if (r2 == 0) goto L_0x00b9
            java.util.List r6 = r2.getProductList()
            if (r6 == 0) goto L_0x00b9
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r5
            if (r6 != r5) goto L_0x00b9
            java.util.List r2 = r2.getProductList()
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            r0.f62535i = r2
        L_0x00b9:
            net.one97.paytm.common.entity.CJRItem r2 = r0.f62531e
            java.lang.String r6 = "this.applicationContext"
            java.lang.String r7 = ""
            if (r2 == 0) goto L_0x01bd
            if (r2 != 0) goto L_0x00c7
            kotlin.g.b.k.a()
        L_0x00c7:
            net.one97.paytm.recharge.ordersummary.h.d r8 = r0.p
            if (r8 != 0) goto L_0x00d7
            net.one97.paytm.recharge.ordersummary.h.d r8 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r9 = r19.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            r8.<init>(r9)
        L_0x00d7:
            r0.p = r8
            net.one97.paytm.recharge.common.h.d r8 = new net.one97.paytm.recharge.common.h.d
            net.one97.paytm.recharge.common.h.d$a r9 = new net.one97.paytm.recharge.common.h.d$a
            net.one97.paytm.recharge.common.h.d$b r10 = net.one97.paytm.recharge.common.h.d.b.CREDIT_CARD
            r9.<init>(r10)
            net.one97.paytm.recharge.common.h.d$a r9 = r9.a((net.one97.paytm.common.entity.CJRItem) r2)
            r12 = r0
            android.content.Context r12 = (android.content.Context) r12
            net.one97.paytm.recharge.common.b.c r10 = net.one97.paytm.recharge.common.b.d.b(r12)
            net.one97.paytm.recharge.common.h.d$a r9 = r9.a((net.one97.paytm.recharge.common.b.c) r10)
            net.one97.paytm.recharge.common.utils.w r10 = net.one97.paytm.recharge.common.b.d.d(r12)
            net.one97.paytm.recharge.common.h.d$a r9 = r9.a((net.one97.paytm.recharge.common.utils.w) r10)
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$c r10 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$c
            r11 = r0
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4 r11 = (net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4) r11
            r10.<init>(r11)
            net.one97.paytm.recharge.common.h.d$a r9 = r9.a((kotlin.k.e<kotlin.x>) r10)
            net.one97.paytm.recharge.ordersummary.h.d r10 = r0.p
            if (r10 != 0) goto L_0x010c
            kotlin.g.b.k.a()
        L_0x010c:
            r10.f64343a = r2
            net.one97.paytm.recharge.common.h.d$a r2 = r9.a((net.one97.paytm.recharge.ordersummary.h.d) r10)
            r8.<init>(r2)
            androidx.lifecycle.al$b r8 = (androidx.lifecycle.al.b) r8
            androidx.lifecycle.al r2 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r8)
            java.lang.Class<net.one97.paytm.recharge.creditcard.c.a> r8 = net.one97.paytm.recharge.creditcard.c.a.class
            androidx.lifecycle.ai r2 = r2.a(r8)
            java.lang.String r8 = "ViewModelProviders.of(th…elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r10 = r2
            net.one97.paytm.recharge.creditcard.c.a r10 = (net.one97.paytm.recharge.creditcard.c.a) r10
            java.lang.String r2 = "CC"
            r10.c(r2)
            r0.f62528b = r10
            net.one97.paytm.recharge.creditcard.c.a r2 = r0.f62528b
            if (r2 == 0) goto L_0x013d
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
            if (r2 == 0) goto L_0x013d
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r0.s
            r2.setCategoryData(r8)
        L_0x013d:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$j r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$j
            r2.<init>(r11)
            r10.a((kotlin.k.e<kotlin.x>) r2)
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r2 = r10.f61408a
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$k r8 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$k
            r8.<init>(r11)
            kotlin.g.a.b r8 = (kotlin.g.a.b) r8
            net.one97.paytm.recharge.common.utils.ai.a(r0, r2, r8)
            net.one97.paytm.recharge.common.utils.w r2 = r10.t
            if (r2 == 0) goto L_0x015e
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$l r8 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$l
            r8.<init>(r11)
            r2.f61788h = r8
        L_0x015e:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x0167
            java.lang.String r2 = r2.getDisplayCardNumber()
            goto L_0x0168
        L_0x0167:
            r2 = r3
        L_0x0168:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01bd
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r8 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r2.setErrorType(r8)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r2.getFlowName()
            if (r8 == 0) goto L_0x018a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r9 = r9.name()
            r8.setErrorType(r9)
        L_0x018a:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r2.getFlowName()
            if (r8 == 0) goto L_0x0199
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r9 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_TOKEN
            java.lang.String r9 = r9.name()
            r8.setActionType(r9)
        L_0x0199:
            r0.t = r5
            java.lang.String r11 = r0.B
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 != 0) goto L_0x01a4
            kotlin.g.b.k.a()
        L_0x01a4:
            java.lang.String r8 = r8.getDisplayCardNumber()
            if (r8 != 0) goto L_0x01ad
            kotlin.g.b.k.a()
        L_0x01ad:
            java.lang.String r9 = " "
            java.lang.String r13 = kotlin.m.p.a(r8, r9, r7, r4)
            r14 = r0
            net.one97.paytm.recharge.common.e.ai r14 = (net.one97.paytm.recharge.common.e.ai) r14
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r15 = r0.f62530d
            r16 = r2
            r10.a(r11, r12, r13, r14, r15, r16)
        L_0x01bd:
            net.one97.paytm.recharge.ordersummary.h.d r2 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r8 = r19.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            r2.<init>(r8)
            r0.p = r2
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x01de
            java.lang.Double r2 = r2.getTotalDue()
            if (r2 == 0) goto L_0x01de
            double r8 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r8)
            goto L_0x01df
        L_0x01de:
            r2 = r3
        L_0x01df:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r6 = "(this as java.lang.String).toLowerCase(locale)"
            java.lang.String r8 = "Locale.getDefault()"
            if (r2 != 0) goto L_0x0208
            net.one97.paytm.recharge.ordersummary.h.d r2 = r0.p     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x0223
            r9 = r0
            android.content.Context r9 = (android.content.Context) r9     // Catch:{ all -> 0x0206 }
            java.lang.String r10 = "/onus_credit_card/choose_amount"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0206 }
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r8)     // Catch:{ all -> 0x0206 }
            java.lang.String r8 = r10.toLowerCase(r11)     // Catch:{ all -> 0x0206 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ all -> 0x0206 }
            r2.a((android.content.Context) r9, (java.lang.String) r8)     // Catch:{ all -> 0x0206 }
            goto L_0x0223
        L_0x0206:
            goto L_0x0223
        L_0x0208:
            net.one97.paytm.recharge.ordersummary.h.d r2 = r0.p
            if (r2 == 0) goto L_0x0223
            android.content.Context r9 = r19.getApplicationContext()
            java.util.Locale r10 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
            java.lang.String r8 = "/credit_card/amount"
            java.lang.String r8 = r8.toLowerCase(r10)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            r2.a((android.content.Context) r9, (java.lang.String) r8)
        L_0x0223:
            super.onCreate(r20)
            int r2 = net.one97.paytm.recharge.R.layout.v4_activity_credit_card_enter_amount
            r0.setContentView((int) r2)
            int r2 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r2 = r0.findViewById(r2)
            androidx.appcompat.widget.Toolbar r2 = (androidx.appcompat.widget.Toolbar) r2
            r0.a((androidx.appcompat.widget.Toolbar) r2)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x0245
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getSelectedDCVariant()
            if (r2 == 0) goto L_0x0245
            java.util.List r2 = r2.getProductList()
            goto L_0x0246
        L_0x0245:
            r2 = r3
        L_0x0246:
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r2)
            if (r2 == 0) goto L_0x0271
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x026b
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getSelectedDCVariant()
            if (r2 == 0) goto L_0x026b
            java.util.List r2 = r2.getProductList()
            if (r2 == 0) goto L_0x026b
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x026b
            java.lang.String r2 = r2.getServiceDisplayLabel()
            goto L_0x026c
        L_0x026b:
            r2 = r3
        L_0x026c:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x0272
        L_0x0271:
            r2 = r7
        L_0x0272:
            r0.A = r2
            int r2 = net.one97.paytm.recharge.R.id.cardNameTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x02a8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 == 0) goto L_0x028c
            java.lang.String r8 = r8.getOperaterName()
            goto L_0x028d
        L_0x028c:
            r8 = r3
        L_0x028d:
            r6.append(r8)
            r8 = 32
            r6.append(r8)
            java.lang.String r8 = r0.A
            r6.append(r8)
            r8 = 32
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x02a8:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x02b1
            java.lang.String r2 = r2.getDisplayCardNumber()
            goto L_0x02b2
        L_0x02b1:
            r2 = r3
        L_0x02b2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r6 = 3
            if (r2 != 0) goto L_0x02f3
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x02ce
            java.lang.String r2 = r2.getDisplayCardNumber()
            if (r2 == 0) goto L_0x02ce
            int r2 = r2.length()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x02cf
        L_0x02ce:
            r2 = r3
        L_0x02cf:
            if (r2 != 0) goto L_0x02d4
            kotlin.g.b.k.a()
        L_0x02d4:
            int r2 = r2.intValue()
            if (r2 <= r6) goto L_0x02f3
            int r2 = net.one97.paytm.recharge.R.id.cardNumberTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x02f3
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 == 0) goto L_0x02ed
            java.lang.String r8 = r8.getDisplayCardNumber()
            goto L_0x02ee
        L_0x02ed:
            r8 = r3
        L_0x02ee:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
        L_0x02f3:
            android.content.Intent r2 = r19.getIntent()
            java.lang.String r8 = "Recharge browse plan disclaimer"
            java.lang.String r2 = r2.getStringExtra(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r0.f62535i
            if (r8 == 0) goto L_0x0306
            java.lang.String r8 = r8.getDisclaimer()
            goto L_0x0307
        L_0x0306:
            r8 = r3
        L_0x0307:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0319
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r0.f62535i
            if (r2 == 0) goto L_0x0318
            java.lang.String r2 = r2.getDisclaimer()
            goto L_0x0319
        L_0x0318:
            r2 = r3
        L_0x0319:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 != 0) goto L_0x0335
            int r8 = net.one97.paytm.recharge.R.id.tv_subdisclaimer
            android.view.View r8 = r0.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "tvSubDisclaimer"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r8.setText(r2)
            r8.setVisibility(r4)
        L_0x0335:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountET
            android.view.View r2 = r0.findViewById(r2)
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = (net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8) r2
            r0.f62534h = r2
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x0346
            r2.setVisibility(r4)
        L_0x0346:
            r19.d()
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 == 0) goto L_0x0356
            java.lang.String r8 = r8.getOperaterImage()
            goto L_0x0357
        L_0x0356:
            r8 = r3
        L_0x0357:
            int r9 = net.one97.paytm.recharge.R.id.cardLogoIV
            android.view.View r9 = r0.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0378
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0378
            com.squareup.picasso.aa r10 = r2.a((java.lang.String) r8)
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$f r11 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$f
            r11.<init>(r9, r0, r8, r2)
            com.squareup.picasso.e r11 = (com.squareup.picasso.e) r11
            r10.a((android.widget.ImageView) r9, (com.squareup.picasso.e) r11)
        L_0x0378:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 == 0) goto L_0x0381
            java.lang.String r8 = r8.getOperaterCardTypeImage()
            goto L_0x0382
        L_0x0381:
            r8 = r3
        L_0x0382:
            int r9 = net.one97.paytm.recharge.R.id.cardTypeIV
            android.view.View r9 = r0.a((int) r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x03a3
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x03a3
            com.squareup.picasso.aa r10 = r2.a((java.lang.String) r8)
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$g r11 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$g
            r11.<init>(r9, r0, r8, r2)
            com.squareup.picasso.e r11 = (com.squareup.picasso.e) r11
            r10.a((android.widget.ImageView) r9, (com.squareup.picasso.e) r11)
        L_0x03a3:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r0.f62535i
            if (r2 == 0) goto L_0x03bf
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.b()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r0.f62535i
            if (r8 != 0) goto L_0x03b4
            kotlin.g.b.k.a()
        L_0x03b4:
            java.lang.Long r8 = r8.getProductId()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2.setProductId(r8)
        L_0x03bf:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x03c9
            r8 = r0
            android.view.View$OnTouchListener r8 = (android.view.View.OnTouchListener) r8
            r2.setOnTouchListener(r8)
        L_0x03c9:
            int r2 = net.one97.paytm.recharge.R.id.totalDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x03d9
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x03d9:
            int r2 = net.one97.paytm.recharge.R.id.minDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x03e9
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x03e9:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x03f9
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x03f9:
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            if (r2 == 0) goto L_0x0409
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x0409:
            int r2 = net.one97.paytm.recharge.R.id.insurance_checkbox_container
            android.view.View r2 = r0.a((int) r2)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            if (r2 == 0) goto L_0x0419
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x0419:
            int r2 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r2 = r0.a((int) r2)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            if (r2 == 0) goto L_0x0429
            r8 = r0
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
        L_0x0429:
            net.one97.paytm.recharge.creditcard.c.a r2 = r0.f62528b
            if (r2 == 0) goto L_0x0443
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPersonalInsurance> r2 = r2.Y
            if (r2 == 0) goto L_0x0443
            r8 = r0
            androidx.lifecycle.q r8 = (androidx.lifecycle.q) r8
            net.one97.paytm.recharge.widgets.a.c r9 = new net.one97.paytm.recharge.widgets.a.c
            java.lang.String r10 = r0.y
            r11 = r0
            net.one97.paytm.recharge.widgets.b.c r11 = (net.one97.paytm.recharge.widgets.b.c) r11
            r9.<init>(r10, r11)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r2.observe(r8, r9)
        L_0x0443:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x044c
            java.lang.String r2 = r2.getCardNumber()
            goto L_0x044d
        L_0x044c:
            r2 = r3
        L_0x044d:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r2 = net.one97.paytm.recharge.common.utils.g.c(r2)
            if (r2 == 0) goto L_0x04bd
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r0.f62535i
            if (r2 == 0) goto L_0x0460
            java.lang.Long r2 = r2.getProductId()
            goto L_0x0461
        L_0x0460:
            r2 = r3
        L_0x0461:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r2 = net.one97.paytm.recharge.common.utils.g.c(r2)
            if (r2 == 0) goto L_0x04bd
            net.one97.paytm.recharge.creditcard.c.a r2 = r0.f62528b
            if (r2 == 0) goto L_0x04bd
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r8 = r0.f62530d
            if (r8 == 0) goto L_0x0478
            java.lang.String r8 = r8.getCardNumber()
            goto L_0x0479
        L_0x0478:
            r8 = r3
        L_0x0479:
            java.lang.String r13 = java.lang.String.valueOf(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r0.f62535i
            if (r8 == 0) goto L_0x0486
            java.lang.Long r8 = r8.getProductId()
            goto L_0x0487
        L_0x0486:
            r8 = r3
        L_0x0487:
            java.lang.String r15 = java.lang.String.valueOf(r8)
            java.lang.String r8 = "cardNumber"
            kotlin.g.b.k.c(r13, r8)
            java.lang.String r8 = "productId"
            kotlin.g.b.k.c(r15, r8)
            net.one97.paytm.recharge.common.b.c r8 = r2.s
            boolean r8 = r8.a()
            if (r8 == 0) goto L_0x04bd
            net.one97.paytm.recharge.common.b.c r9 = r2.s
            r11 = r2
            net.one97.paytm.recharge.common.e.ai r11 = (net.one97.paytm.recharge.common.e.ai) r11
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
            java.lang.String r2 = r2.getProtectionURL()
            if (r2 != 0) goto L_0x04ac
            r12 = r7
            goto L_0x04ad
        L_0x04ac:
            r12 = r2
        L_0x04ad:
            r14 = 0
            r17 = 0
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r18 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            java.lang.String r10 = "fetch_insurance_data"
            java.lang.String r16 = ""
            r9.a(r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x04bd:
            net.one97.paytm.recharge.common.utils.o r2 = new net.one97.paytm.recharge.common.utils.o
            r8 = r0
            android.content.Context r8 = (android.content.Context) r8
            net.one97.paytm.recharge.creditcard.c.a r9 = r0.f62528b
            if (r9 == 0) goto L_0x04cb
            java.lang.String r9 = r9.a()
            goto L_0x04cc
        L_0x04cb:
            r9 = r3
        L_0x04cc:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            net.one97.paytm.recharge.model.v4.CJRCategoryData r10 = r0.s
            if (r10 == 0) goto L_0x04e4
            java.lang.Long r10 = r10.getCategoryId()
            if (r10 == 0) goto L_0x04e4
            long r10 = r10.longValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            if (r10 != 0) goto L_0x04e5
        L_0x04e4:
            r10 = r7
        L_0x04e5:
            r11 = r0
            net.one97.paytm.recharge.common.e.u r11 = (net.one97.paytm.recharge.common.e.u) r11
            r2.<init>(r8, r9, r10, r11)
            r0.u = r2
            net.one97.paytm.recharge.creditcard.c.a r2 = r0.f62528b
            if (r2 == 0) goto L_0x04f5
            java.lang.String r2 = r2.A
            if (r2 != 0) goto L_0x04f6
        L_0x04f5:
            r2 = r7
        L_0x04f6:
            com.google.gson.f r7 = new com.google.gson.f     // Catch:{ Exception -> 0x053c }
            r7.<init>()     // Catch:{ Exception -> 0x053c }
            net.one97.paytm.recharge.di.helper.c r8 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x053c }
            java.lang.String r8 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x053c }
            java.lang.Class<java.util.HashMap> r9 = java.util.HashMap.class
            java.lang.Object r7 = r7.a((java.lang.String) r8, r9)     // Catch:{ Exception -> 0x053c }
            boolean r8 = r7 instanceof java.util.HashMap     // Catch:{ Exception -> 0x053c }
            if (r8 != 0) goto L_0x050c
            r7 = r3
        L_0x050c:
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ Exception -> 0x053c }
            r8 = r2
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x053c }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x053c }
            if (r8 != 0) goto L_0x053c
            if (r7 == 0) goto L_0x053c
            r8 = r7
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x053c }
            if (r8 == 0) goto L_0x0534
            boolean r8 = r8.containsKey(r2)     // Catch:{ Exception -> 0x053c }
            if (r8 != r5) goto L_0x053c
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x053c }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x053c }
            boolean r2 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r2, (android.content.Context) r0)     // Catch:{ Exception -> 0x053c }
            if (r2 == 0) goto L_0x053c
            r2 = 1
            goto L_0x053d
        L_0x0534:
            kotlin.u r2 = new kotlin.u     // Catch:{ Exception -> 0x053c }
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r2.<init>(r7)     // Catch:{ Exception -> 0x053c }
            throw r2     // Catch:{ Exception -> 0x053c }
        L_0x053c:
            r2 = 0
        L_0x053d:
            if (r2 != 0) goto L_0x056b
            int r2 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r2 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r2
            if (r2 == 0) goto L_0x054e
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.a(r2)
        L_0x054e:
            int r2 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r2 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r2
            if (r2 == 0) goto L_0x055e
            r7 = r0
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r2.setEnabled(r5, r7)
        L_0x055e:
            int r2 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r2 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r2
            if (r2 == 0) goto L_0x056b
            r2.setEnabled(r4)
        L_0x056b:
            int r2 = r19.o()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r7 = r0.f62530d
            if (r7 == 0) goto L_0x0578
            java.lang.String r7 = r7.getDeeplinkAmount()
            goto L_0x0579
        L_0x0578:
            r7 = r3
        L_0x0579:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r7 = r7 ^ r5
            java.lang.String r8 = "normalSansSerifMediumFont"
            java.lang.String r9 = "boldSansSerifMediumFont"
            if (r2 == r5) goto L_0x0706
            r1 = 2
            r10 = 8
            if (r2 == r1) goto L_0x06b8
            if (r2 == r6) goto L_0x058f
            goto L_0x077e
        L_0x058f:
            r0.x = r5
            boolean r2 = r0.f62532f
            if (r2 != 0) goto L_0x059c
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x059c
            r2.requestFocus()
        L_0x059c:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x05a9
            r2.performClick()
        L_0x05a9:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountIV
            android.view.View r2 = r0.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x05b6
            r2.setVisibility(r10)
        L_0x05b6:
            int r2 = net.one97.paytm.recharge.R.id.totalDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x05c3
            r2.setVisibility(r10)
        L_0x05c3:
            int r2 = net.one97.paytm.recharge.R.id.minDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x05d0
            r2.setVisibility(r10)
        L_0x05d0:
            int r2 = net.one97.paytm.recharge.R.id.dueAmountTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x05dd
            r2.setVisibility(r10)
        L_0x05dd:
            int r2 = net.one97.paytm.recharge.R.id.selectAmountTitleTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x05ea
            r2.setVisibility(r10)
        L_0x05ea:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountTitleTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x05f7
            r2.setVisibility(r10)
        L_0x05f7:
            int r2 = net.one97.paytm.recharge.R.id.emptySpaceView
            android.view.View r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x0602
            r2.setVisibility(r4)
        L_0x0602:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
            r7 = -1
            r8 = -2
            r2.<init>((int) r7, (int) r8)
            r7 = 20
            int r7 = com.paytm.utility.b.c((int) r7)
            r9 = 20
            int r9 = com.paytm.utility.b.c((int) r9)
            r11 = 36
            int r11 = com.paytm.utility.b.c((int) r11)
            r2.setMargins(r7, r4, r9, r11)
            int r7 = net.one97.paytm.recharge.R.id.emptySpaceView
            android.view.View r7 = r0.a((int) r7)
            java.lang.String r9 = "emptySpaceView"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            int r7 = r7.getId()
            r2.f2491i = r7
            int r7 = net.one97.paytm.recharge.R.id.anyAmountRL
            android.view.View r7 = r0.a((int) r7)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x063e
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r7.setLayoutParams(r2)
        L_0x063e:
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r8, r8)
            r7 = 5
            int r7 = com.paytm.utility.b.c((int) r7)
            r2.setMargins(r4, r4, r7, r4)
            int r7 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r7 = r0.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x065a
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r7.setLayoutParams(r2)
        L_0x065a:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0669
            r7 = 1105199104(0x41e00000, float:28.0)
            r2.setTextSize(r1, r7)
        L_0x0669:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0678
            android.graphics.Typeface r7 = r0.F
            r2.setTypeface(r7)
        L_0x0678:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x0681
            android.graphics.Typeface r7 = r0.F
            r2.setTypeface(r7)
        L_0x0681:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x068a
            r7 = 1105199104(0x41e00000, float:28.0)
            r2.setTextSize(r1, r7)
        L_0x068a:
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r2 = -1
            int r7 = com.paytm.utility.b.c((int) r5)
            r1.<init>(r2, r7)
            int r2 = com.paytm.utility.b.c((int) r10)
            r1.setMargins(r4, r2, r4, r4)
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x06a6
            int r2 = r2.getId()
            r1.addRule(r6, r2)
        L_0x06a6:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountHeighlightedDivider
            android.view.View r2 = r0.a((int) r2)
            java.lang.String r6 = "anyAmountHeighlightedDivider"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r2.setLayoutParams(r1)
            goto L_0x077e
        L_0x06b8:
            r0.d((boolean) r4)
            if (r7 != 0) goto L_0x06ca
            int r1 = net.one97.paytm.recharge.R.id.totalDueRL
            android.view.View r1 = r0.a((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x06ca
            r1.performClick()
        L_0x06ca:
            int r1 = net.one97.paytm.recharge.R.id.minDueRL
            android.view.View r1 = r0.a((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x06d7
            r1.setVisibility(r10)
        L_0x06d7:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x077e
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x06ec
            java.lang.Double r2 = r2.getTotalDue()
            goto L_0x06ed
        L_0x06ec:
            r2 = r3
        L_0x06ed:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            android.graphics.Typeface r6 = r0.E
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            android.graphics.Typeface r7 = r0.F
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            android.text.SpannableString r2 = net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r2, (boolean) r5, (android.graphics.Typeface) r6, (android.graphics.Typeface) r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            goto L_0x077e
        L_0x0706:
            r0.d((boolean) r4)
            if (r7 != 0) goto L_0x0718
            int r2 = net.one97.paytm.recharge.R.id.totalDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x0718
            r2.performClick()
        L_0x0718:
            int r2 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0745
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x072d
            java.lang.Double r6 = r6.getTotalDue()
            goto L_0x072e
        L_0x072d:
            r6 = r3
        L_0x072e:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.graphics.Typeface r7 = r0.E
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.graphics.Typeface r10 = r0.F
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
            android.text.SpannableString r6 = net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r6, (boolean) r5, (android.graphics.Typeface) r7, (android.graphics.Typeface) r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x0745:
            int r2 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0772
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x075a
            java.lang.Double r6 = r6.getMinDue()
            goto L_0x075b
        L_0x075a:
            r6 = r3
        L_0x075b:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.graphics.Typeface r7 = r0.E
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.graphics.Typeface r9 = r0.F
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
            android.text.SpannableString r6 = net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r6, (boolean) r5, (android.graphics.Typeface) r7, (android.graphics.Typeface) r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x0772:
            boolean r2 = r0.f62532f
            if (r2 != 0) goto L_0x077e
            net.one97.paytm.recharge.common.utils.t r2 = new net.one97.paytm.recharge.common.utils.t
            r2.<init>(r1)
            r2.a()
        L_0x077e:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r0.f62530d
            if (r1 == 0) goto L_0x0787
            java.lang.String r1 = r1.getDeeplinkAmount()
            goto L_0x0788
        L_0x0787:
            r1 = r3
        L_0x0788:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ r5
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x0798
            java.lang.String r2 = r2.getDeeplinkAmount()
            goto L_0x0799
        L_0x0798:
            r2 = r3
        L_0x0799:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x08ad
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x07b4
            java.lang.Double r2 = r2.getTotalDue()
            if (r2 == 0) goto L_0x07b4
            double r6 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            goto L_0x07b5
        L_0x07b4:
            r2 = r3
        L_0x07b5:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x07fa
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x07d2
            java.lang.Double r2 = r2.getTotalDue()
            if (r2 == 0) goto L_0x07d2
            double r6 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            goto L_0x07d3
        L_0x07d2:
            r2 = r3
        L_0x07d3:
            double r6 = net.one97.paytm.recharge.widgets.c.d.c(r2)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x07e2
            java.lang.String r2 = r2.getDeeplinkAmount()
            goto L_0x07e3
        L_0x07e2:
            r2 = r3
        L_0x07e3:
            double r8 = net.one97.paytm.recharge.widgets.c.d.c(r2)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x07fa
            int r2 = net.one97.paytm.recharge.R.id.totalDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x0899
            r2.performClick()
            goto L_0x0899
        L_0x07fa:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x080d
            java.lang.Double r2 = r2.getMinDue()
            if (r2 == 0) goto L_0x080d
            double r6 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            goto L_0x080e
        L_0x080d:
            r2 = r3
        L_0x080e:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0852
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x082b
            java.lang.Double r2 = r2.getMinDue()
            if (r2 == 0) goto L_0x082b
            double r6 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            goto L_0x082c
        L_0x082b:
            r2 = r3
        L_0x082c:
            double r6 = net.one97.paytm.recharge.widgets.c.d.c(r2)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x083b
            java.lang.String r2 = r2.getDeeplinkAmount()
            goto L_0x083c
        L_0x083b:
            r2 = r3
        L_0x083c:
            double r8 = net.one97.paytm.recharge.widgets.c.d.c(r2)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0852
            int r2 = net.one97.paytm.recharge.R.id.minDueRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x0899
            r2.performClick()
            goto L_0x0899
        L_0x0852:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x086b
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x0861
            java.lang.String r6 = r6.getDeeplinkAmount()
            goto L_0x0862
        L_0x0861:
            r6 = r3
        L_0x0862:
            java.lang.String r6 = net.one97.paytm.recharge.widgets.c.d.d(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x086b:
            boolean r2 = r0.x
            if (r2 != 0) goto L_0x0880
            int r2 = net.one97.paytm.recharge.R.id.anyAmountRL
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x087c
            r2.performClick()
        L_0x087c:
            r0.d((boolean) r5)
            goto L_0x0899
        L_0x0880:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r2 = r0.f62534h
            if (r2 == 0) goto L_0x0899
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x088e
            java.lang.String r3 = r6.getDeeplinkAmount()
        L_0x088e:
            java.lang.String r3 = net.one97.paytm.recharge.widgets.c.d.d(r3)
            int r3 = r3.length()
            r2.setSelection(r3)
        L_0x0899:
            r0.c((boolean) r5)
            int r2 = net.one97.paytm.recharge.R.id.insuranceIN
            android.view.View r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x08ad
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x08ad
            r0.a((boolean) r5)
        L_0x08ad:
            boolean r2 = r0.x
            if (r2 != 0) goto L_0x0904
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r0.f62530d
            if (r2 == 0) goto L_0x0904
            java.lang.String r3 = r2.getDueDate()
            boolean r3 = net.one97.paytm.recharge.common.utils.g.c(r3)
            if (r3 == 0) goto L_0x0904
            int r3 = net.one97.paytm.recharge.R.id.dueAmountTV
            android.view.View r3 = r0.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r6 = "dueAmountTV"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.ai.a(r3)
            int r3 = net.one97.paytm.recharge.R.id.dueAmountTV
            android.view.View r3 = r0.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r6 = "dueAmountTV"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.String r2 = r2.getDueDate()
            if (r2 != 0) goto L_0x08e7
            kotlin.g.b.k.a()
        L_0x08e7:
            int r6 = net.one97.paytm.recharge.R.string.txt_payment_due_by
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = "dd MMM yy"
            java.lang.String r9 = "yyyy-MM-dd"
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ab.a(r2, r9, r8)
            r7[r4] = r2
            java.lang.String r2 = r0.getString(r6, r7)
            java.lang.String r4 = "getString(R.string.txt_p…, outputFormat\n        ))"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x0904:
            android.view.Window r2 = r19.getWindow()
            if (r2 == 0) goto L_0x0915
            boolean r3 = r0.x
            if (r3 != 0) goto L_0x090f
            goto L_0x0910
        L_0x090f:
            r5 = 5
        L_0x0910:
            r3 = r5 | 16
            r2.setSoftInputMode(r3)
        L_0x0915:
            boolean r2 = r0.f62532f
            if (r2 == 0) goto L_0x0950
            boolean r2 = r0.x
            if (r2 != 0) goto L_0x0950
            if (r1 != 0) goto L_0x0950
            int r1 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r1 = r0.a((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0950
            r1.requestFocus()
            goto L_0x0950
        L_0x092d:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8"
            r1.<init>(r2)
            throw r1
        L_0x0935:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem"
            r1.<init>(r2)
            throw r1
        L_0x093d:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "CCAmount Screen: WITHOUT ANY INTENT DATA"
            r2.debugLog(r3)
            a((android.os.Bundle) r20)
            super.onCreate(r20)
            r0.setResult(r4)
            androidx.core.app.a.b(r1)
        L_0x0950:
            int r1 = net.one97.paytm.recharge.R.id.bottmFocusEt
            android.view.View r1 = r0.a((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x095f
            r2 = 8194(0x2002, float:1.1482E-41)
            r1.setInputType(r2)
        L_0x095f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.onCreate(android.os.Bundle):void");
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void a(String str, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        if (kotlin.g.b.k.a((Object) this.y, (Object) str)) {
            String str2 = null;
            if (!(obj instanceof CJRPersonalInsurance)) {
                obj = null;
            }
            CJRPersonalInsurance cJRPersonalInsurance = (CJRPersonalInsurance) obj;
            if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null)) {
                if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getProductID() : null)) {
                    if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null)) {
                        TextView textView = (TextView) a(R.id.insurance_title);
                        if (textView != null) {
                            textView.setText(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null);
                        }
                        TextView textView2 = (TextView) a(R.id.insurance_title);
                        if (textView2 != null) {
                            net.one97.paytm.recharge.common.utils.ai.a(textView2);
                        }
                    } else {
                        TextView textView3 = (TextView) a(R.id.insurance_title);
                        if (textView3 != null) {
                            net.one97.paytm.recharge.common.utils.ai.b(textView3);
                        }
                    }
                    if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getSubTitleForPersonalInsurance() : null)) {
                        TextView textView4 = (TextView) a(R.id.insurance_subtitle);
                        if (textView4 != null) {
                            if (cJRPersonalInsurance != null) {
                                str2 = cJRPersonalInsurance.getSubTitleForPersonalInsurance();
                            }
                            textView4.setText(str2);
                        }
                        TextView textView5 = (TextView) a(R.id.insurance_subtitle);
                        if (textView5 != null) {
                            net.one97.paytm.recharge.common.utils.ai.a(textView5);
                        }
                    } else {
                        TextView textView6 = (TextView) a(R.id.insurance_subtitle);
                        if (textView6 != null) {
                            net.one97.paytm.recharge.common.utils.ai.b(textView6);
                        }
                    }
                    View a2 = a(R.id.insuranceIN);
                    if (a2 != null) {
                        a2.setVisibility(0);
                    }
                    this.z = cJRPersonalInsurance;
                    if (this.x) {
                        a(!TextUtils.isEmpty(m()));
                    } else {
                        a(true);
                    }
                }
            }
        }
    }

    private final void a(boolean z2) {
        if (z2) {
            View a2 = a(R.id.insuranceIN);
            if (a2 != null) {
                a2.setOnClickListener(this);
            }
            View a3 = a(R.id.insuranceIN);
            if (a3 != null) {
                a3.setEnabled(true);
            }
            TextView textView = (TextView) a(R.id.insurance_title);
            if (textView != null) {
                textView.setEnabled(true);
            }
            TextView textView2 = (TextView) a(R.id.insurance_subtitle);
            if (textView2 != null) {
                textView2.setEnabled(true);
            }
            CheckBox checkBox = (CheckBox) a(R.id.insurance_checkbox);
            if (checkBox != null) {
                checkBox.setEnabled(true);
                return;
            }
            return;
        }
        View a4 = a(R.id.insuranceIN);
        if (a4 != null) {
            a4.setOnClickListener((View.OnClickListener) null);
        }
        View a5 = a(R.id.insuranceIN);
        if (a5 != null) {
            a5.setEnabled(false);
        }
        TextView textView3 = (TextView) a(R.id.insurance_title);
        if (textView3 != null) {
            textView3.setEnabled(false);
        }
        TextView textView4 = (TextView) a(R.id.insurance_subtitle);
        if (textView4 != null) {
            textView4.setEnabled(false);
        }
        CheckBox checkBox2 = (CheckBox) a(R.id.insurance_checkbox);
        if (checkBox2 != null) {
            checkBox2.setEnabled(false);
        }
    }

    private final void c(boolean z2) {
        CJRPromoWidgetV3 cJRPromoWidgetV3;
        String str;
        boolean z3 = false;
        if (z2) {
            net.one97.paytm.recharge.creditcard.c.a aVar = this.f62528b;
            if (aVar == null || (str = aVar.A) == null) {
                str = "";
            }
            try {
                com.google.gson.f fVar = new com.google.gson.f();
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bR(), HashMap.class);
                if (!(a2 instanceof HashMap)) {
                    a2 = null;
                }
                HashMap hashMap = (HashMap) a2;
                if (!TextUtils.isEmpty(str) && hashMap != null) {
                    Map map = hashMap;
                    if (map == null) {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                    } else if (map.containsKey(str) && ba.c((String) hashMap.get(str), (Context) this)) {
                        z3 = true;
                    }
                }
            } catch (Exception unused) {
            }
            if (z3) {
                CJRPromoWidgetV3 cJRPromoWidgetV32 = (CJRPromoWidgetV3) a(R.id.bank_offers_promocode_text_layout);
                if (cJRPromoWidgetV32 != null) {
                    net.one97.paytm.recharge.common.utils.ai.b(cJRPromoWidgetV32);
                    return;
                }
                return;
            }
            CJRPromoWidgetV3 cJRPromoWidgetV33 = (CJRPromoWidgetV3) a(R.id.bank_offers_promocode_text_layout);
            if (cJRPromoWidgetV33 != null) {
                net.one97.paytm.recharge.common.utils.ai.a(cJRPromoWidgetV33);
            }
            CJRPromoWidgetV3 cJRPromoWidgetV34 = (CJRPromoWidgetV3) a(R.id.bank_offers_promocode_text_layout);
            if (cJRPromoWidgetV34 != null) {
                cJRPromoWidgetV34.setEnabled(true, this);
            }
        } else if (!z2 && (cJRPromoWidgetV3 = (CJRPromoWidgetV3) a(R.id.bank_offers_promocode_text_layout)) != null) {
            cJRPromoWidgetV3.setEnabled(false, this);
        }
    }

    public final void startPostponedEnterTransition() {
        if (this.n + this.o > 1) {
            CJRRechargeUtilities.INSTANCE.debugLog("All images loaded successfully");
            this.n = -1;
            this.o = -1;
            super.startPostponedEnterTransition();
            return;
        }
        CJRRechargeUtilities.INSTANCE.debugLog("Waiting or partially loaded other images to load");
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        RelativeLayout relativeLayout;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            num = Integer.valueOf(customAmountTextInputEditTextV8.getId());
        }
        if (kotlin.g.b.k.a((Object) valueOf, (Object) num) && (relativeLayout = (RelativeLayout) a(R.id.anyAmountRL)) != null) {
            relativeLayout.performClick();
        }
        return false;
    }

    private final void d(boolean z2) {
        if (this.x) {
            return;
        }
        if (!z2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.paytm.utility.b.c(18), 0, 0, 0);
            ImageView imageView = (ImageView) a(R.id.anyAmountIV);
            kotlin.g.b.k.a((Object) imageView, "anyAmountIV");
            layoutParams.addRule(17, imageView.getId());
            TextView textView = (TextView) a(R.id.anyAmountTitleTV);
            kotlin.g.b.k.a((Object) textView, "anyAmountTitleTV");
            layoutParams.addRule(3, textView.getId());
            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
            if (customAmountTextInputEditTextV8 != null) {
                customAmountTextInputEditTextV8.setLayoutParams(layoutParams);
            }
            TextView textView2 = (TextView) a(R.id.anyAmountPrefixTV);
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = (TextView) a(R.id.anyAmountPrefixTV);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, 0);
        TextView textView4 = (TextView) a(R.id.anyAmountPrefixTV);
        kotlin.g.b.k.a((Object) textView4, "anyAmountPrefixTV");
        layoutParams2.addRule(17, textView4.getId());
        TextView textView5 = (TextView) a(R.id.anyAmountTitleTV);
        kotlin.g.b.k.a((Object) textView5, "anyAmountTitleTV");
        layoutParams2.addRule(3, textView5.getId());
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.f62534h;
        if (customAmountTextInputEditTextV82 != null) {
            customAmountTextInputEditTextV82.setLayoutParams(layoutParams2);
        }
    }

    public static final class f implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f62539a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62540b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62541c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ w f62542d;

        f(ImageView imageView, AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4, String str, w wVar) {
            this.f62539a = imageView;
            this.f62540b = aJRCreditCardEnterAmountActivityV4;
            this.f62541c = str;
            this.f62542d = wVar;
        }

        public final void onSuccess() {
            this.f62540b.n = 1;
            this.f62540b.a(this.f62539a);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.c(exc, "e");
            this.f62540b.n = 3;
        }
    }

    public static final class g implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f62543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62544b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62545c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ w f62546d;

        g(ImageView imageView, AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4, String str, w wVar) {
            this.f62543a = imageView;
            this.f62544b = aJRCreditCardEnterAmountActivityV4;
            this.f62545c = str;
            this.f62546d = wVar;
        }

        public final void onSuccess() {
            this.f62544b.o = 1;
            this.f62544b.a(this.f62543a);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.c(exc, "e");
            this.f62544b.o = 3;
            AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4 = this.f62544b;
            ImageView imageView = this.f62543a;
            kotlin.g.b.k.c(imageView, "view");
            imageView.setVisibility(4);
            aJRCreditCardEnterAmountActivityV4.startPostponedEnterTransition();
        }
    }

    public final void a(ImageView imageView) {
        kotlin.g.b.k.c(imageView, "view");
        imageView.setVisibility(0);
        startPostponedEnterTransition();
    }

    private final void d() {
        CJRProductsItem cJRProductsItem = this.f62535i;
        if (cJRProductsItem != null) {
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            List<CJRInputFieldsItem> inputFields = cJRProductsItem.getInputFields();
            if (inputFields != null) {
                for (CJRInputFieldsItem cJRInputFieldsItem : inputFields) {
                    if (cJRInputFieldsItem != null && kotlin.m.p.a("price", cJRInputFieldsItem.getConfigKey(), true)) {
                        String regex = cJRInputFieldsItem.getRegex();
                        if (!TextUtils.isEmpty(regex)) {
                            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
                            if (!(customAmountTextInputEditTextV8 instanceof CustomAmountTextInputEditTextV8)) {
                                continue;
                            } else if (customAmountTextInputEditTextV8 != null) {
                                customAmountTextInputEditTextV8.setRegex(regex);
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8");
                            }
                        } else {
                            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.f62534h;
                            if (!(customAmountTextInputEditTextV82 instanceof CustomAmountTextInputEditTextV8)) {
                                continue;
                            } else if (customAmountTextInputEditTextV82 != null) {
                                customAmountTextInputEditTextV82.setRegex("");
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8");
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r0 = r9.D
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.ANY_AMOUNT
            if (r0 == r1) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = r9.m()
            int r12 = r12 - r13
            r13 = 1
            r1 = 0
            if (r12 == 0) goto L_0x0012
            r12 = 1
            goto L_0x0013
        L_0x0012:
            r12 = 0
        L_0x0013:
            java.lang.String r2 = ""
            r3 = 0
            if (r12 == 0) goto L_0x001d
            r9.v = r2
            r9.c((net.one97.paytm.common.entity.CJRRechargeCart) r3)
        L_0x001d:
            if (r0 == 0) goto L_0x0092
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 != r13) goto L_0x0092
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x003a
            r10.setEnabled(r1)
        L_0x003a:
            r9.v = r2
            r9.a((boolean) r1)
            r9.c((boolean) r1)
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x0053
            java.lang.String r11 = r9.a((java.lang.String) r3)
            r10.setProceedBtnText(r11)
        L_0x0053:
            boolean r10 = r9.x
            if (r10 == 0) goto L_0x007c
            int r10 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0066
            android.graphics.Typeface r11 = r9.F
            r10.setTypeface(r11)
        L_0x0066:
            int r10 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x007c
            r11 = r9
            android.content.Context r11 = (android.content.Context) r11
            int r12 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r11 = androidx.core.content.b.c(r11, r12)
            r10.setTextColor(r11)
        L_0x007c:
            r9.d((boolean) r1)
            boolean r10 = r9.x
            if (r10 == 0) goto L_0x0255
            int r10 = net.one97.paytm.recharge.R.id.anyAmountWordTV
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0091
            r11 = 4
            r10.setVisibility(r11)
        L_0x0091:
            return
        L_0x0092:
            boolean r4 = r9.x
            if (r4 == 0) goto L_0x00cf
            int r4 = net.one97.paytm.recharge.R.id.anyAmountWordTV
            android.view.View r4 = r9.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00a5
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.recharge.common.utils.ai.a(r4)
        L_0x00a5:
            int r4 = net.one97.paytm.recharge.R.id.anyAmountWordTV
            android.view.View r4 = r9.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00cf
            java.lang.String r5 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00bc
            goto L_0x00ca
        L_0x00bc:
            int r2 = net.one97.paytm.recharge.R.string.add_post_fix_only_after_amount
            java.lang.Object[] r5 = new java.lang.Object[r13]
            java.lang.String r6 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r0)
            r5[r1] = r6
            java.lang.String r2 = r9.getString(r2, r5)
        L_0x00ca:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
        L_0x00cf:
            r9.a((boolean) r13)
            if (r12 == 0) goto L_0x00d7
            r9.c((boolean) r13)
        L_0x00d7:
            if (r0 == 0) goto L_0x022e
            double r4 = java.lang.Double.parseDouble(r0)
            r6 = 0
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x020c
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = r9.f62535i
            if (r12 == 0) goto L_0x00ec
            java.util.List r12 = r12.getInputFields()
            goto L_0x00ed
        L_0x00ec:
            r12 = r3
        L_0x00ed:
            if (r12 == 0) goto L_0x0160
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r13
            if (r2 == 0) goto L_0x0160
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r2 = r9.r
            if (r2 != 0) goto L_0x0140
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r12 = r12.iterator()
        L_0x010a:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto L_0x012c
            java.lang.Object r4 = r12.next()
            r5 = r4
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r5 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r5
            if (r5 != 0) goto L_0x011c
            kotlin.g.b.k.a()
        L_0x011c:
            java.lang.String r5 = r5.getType()
            java.lang.String r8 = "amount"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r13)
            if (r5 == 0) goto L_0x010a
            r2.add(r4)
            goto L_0x010a
        L_0x012c:
            java.util.List r2 = (java.util.List) r2
            r12 = r2
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r13
            if (r12 == 0) goto L_0x0140
            java.lang.Object r12 = r2.get(r1)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r12 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r12
            r9.r = r12
        L_0x0140:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r12 = r9.r
            if (r12 == 0) goto L_0x0149
            java.lang.Double r12 = r12.getMax()
            goto L_0x014a
        L_0x0149:
            r12 = r3
        L_0x014a:
            if (r12 == 0) goto L_0x0160
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r12 = r9.r
            if (r12 == 0) goto L_0x0155
            java.lang.Double r12 = r12.getMax()
            goto L_0x0156
        L_0x0155:
            r12 = r3
        L_0x0156:
            if (r12 != 0) goto L_0x015b
            kotlin.g.b.k.a()
        L_0x015b:
            double r4 = r12.doubleValue()
            goto L_0x0161
        L_0x0160:
            r4 = r6
        L_0x0161:
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x01b9
            net.one97.paytm.recharge.di.helper.c r12 = net.one97.paytm.recharge.di.helper.c.f62654a
            double r4 = net.one97.paytm.recharge.di.helper.c.bB()
            double r6 = java.lang.Double.parseDouble(r0)
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x01b9
            r12 = r0
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String r2 = "."
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r12 = kotlin.m.p.a((java.lang.CharSequence) r12, (java.lang.CharSequence) r2, false)
            if (r12 == 0) goto L_0x01b9
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r12 = r9.f62534h
            if (r12 == 0) goto L_0x018a
            r2 = r9
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r12.removeTextChangedListener(r2)
        L_0x018a:
            if (r10 == 0) goto L_0x0195
            java.lang.CharSequence r10 = r10.subSequence(r1, r11)
            java.lang.String r10 = r10.toString()
            goto L_0x0196
        L_0x0195:
            r10 = r3
        L_0x0196:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r11 = r9.f62534h
            if (r11 == 0) goto L_0x01a0
            r12 = r10
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
        L_0x01a0:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r11 = r9.f62534h
            if (r11 == 0) goto L_0x01af
            if (r10 == 0) goto L_0x01ab
            int r10 = r10.length()
            goto L_0x01ac
        L_0x01ab:
            r10 = 0
        L_0x01ac:
            r11.setSelection(r10)
        L_0x01af:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r10 = r9.f62534h
            if (r10 == 0) goto L_0x01b9
            r11 = r9
            android.text.TextWatcher r11 = (android.text.TextWatcher) r11
            r10.addTextChangedListener(r11)
        L_0x01b9:
            r9.d((boolean) r13)
            int r10 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x01d2
            r11 = r9
            android.content.Context r11 = (android.content.Context) r11
            int r12 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r11 = androidx.core.content.b.c(r11, r12)
            r10.setTextColor(r11)
        L_0x01d2:
            boolean r10 = r9.x
            if (r10 == 0) goto L_0x01e5
            int r10 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x01e5
            android.graphics.Typeface r11 = r9.F
            r10.setTypeface(r11)
        L_0x01e5:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x01f2
            r10.setEnabled(r13)
        L_0x01f2:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x022c
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r11 = net.one97.paytm.recharge.widgets.c.d.d(r0)
            java.lang.String r11 = r9.a((java.lang.String) r11)
            r10.setProceedBtnText(r11)
            kotlin.x r3 = kotlin.x.f47997a
            goto L_0x022c
        L_0x020c:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x0219
            r10.setEnabled(r1)
        L_0x0219:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x022c
            java.lang.String r11 = r9.a((java.lang.String) r3)
            r10.setProceedBtnText(r11)
            kotlin.x r3 = kotlin.x.f47997a
        L_0x022c:
            if (r3 != 0) goto L_0x0255
        L_0x022e:
            r10 = r9
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4 r10 = (net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4) r10
            int r11 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r11 = r10.a((int) r11)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r11 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r11
            if (r11 == 0) goto L_0x023e
            r11.setEnabled(r1)
        L_0x023e:
            int r11 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0255
            android.content.Context r10 = (android.content.Context) r10
            int r12 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r10 = androidx.core.content.b.c(r10, r12)
            r11.setTextColor(r10)
            kotlin.x r10 = kotlin.x.f47997a
        L_0x0255:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.common.utils.w wVar;
        if (i2 != 3 && i2 != 7) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("CCAmount Screen: onActivityResult not handled : requestCode " + i2 + " : resultCode " + i3);
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Login Success");
            if (!this.l) {
                this.l = false;
            } else if (!this.m || this.k == null) {
                g();
            } else {
                CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Re-requested handle-Verify-Call");
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.a();
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.CLP_PROCEED.name());
                }
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62528b;
                if (aVar != null && (wVar = aVar.t) != null) {
                    CJRRechargeCart cJRRechargeCart = this.k;
                    if (cJRRechargeCart == null) {
                        kotlin.g.b.k.a();
                    }
                    wVar.a("verify", cJRRechargeCart, (Object) a2);
                }
            }
        } else {
            ay ayVar = ay.f61523a;
            ay.a(i2);
            CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Login Failed");
            this.l = false;
        }
    }

    public final void onPause() {
        Activity activity = this;
        new t(activity).a();
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            new t(activity);
            t.a(customAmountTextInputEditTextV8);
        }
        super.onPause();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRInstruct r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart
            if (r2 == 0) goto L_0x001b
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "CCAmount Screen: saved successful verify call response"
            r2.debugLog(r3)
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart) r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r0.getRechargeCart()
            r1.k = r0
            r0 = 1
            r1.m = r0
            return
        L_0x001b:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.String r5 = ""
            r6 = 0
            if (r2 == 0) goto L_0x00b6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r1.f62530d     // Catch:{ Exception -> 0x00a0 }
            if (r2 == 0) goto L_0x002d
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getSelectedDCVariant()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x002e
        L_0x002d:
            r2 = r6
        L_0x002e:
            net.one97.paytm.recharge.common.utils.a r7 = net.one97.paytm.recharge.common.utils.a.f61493a     // Catch:{ Exception -> 0x00a0 }
            r8 = r1
            android.app.Activity r8 = (android.app.Activity) r8     // Catch:{ Exception -> 0x00a0 }
            r7 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r7 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r7     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r9 = r7.getCategoryName()     // Catch:{ Exception -> 0x00a0 }
            r7 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r7 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r7     // Catch:{ Exception -> 0x00a0 }
            net.one97.paytm.common.entity.CJRRechargeCart r10 = r7.getRechargeCart()     // Catch:{ Exception -> 0x00a0 }
            r11 = 0
            r7 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r7 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r7     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r13 = r7.getProtectionUrl()     // Catch:{ Exception -> 0x00a0 }
            net.one97.paytm.recharge.creditcard.c.a r7 = r1.f62528b     // Catch:{ Exception -> 0x00a0 }
            if (r7 == 0) goto L_0x0051
            java.lang.String r7 = r7.q     // Catch:{ Exception -> 0x00a0 }
            r14 = r7
            goto L_0x0052
        L_0x0051:
            r14 = r6
        L_0x0052:
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r0     // Catch:{ Exception -> 0x00a0 }
            java.lang.Boolean r12 = r0.getDealsFastForward()     // Catch:{ Exception -> 0x00a0 }
            net.one97.paytm.recharge.creditcard.c.a r0 = r1.f62528b     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x006a
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x006a
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x006a
            java.lang.String r6 = r0.getGAEventScreenName()     // Catch:{ Exception -> 0x00a0 }
        L_0x006a:
            r15 = r6
            java.lang.String r16 = ""
            if (r2 == 0) goto L_0x0079
            java.lang.String r0 = r2.getBbpsLogoUrl()     // Catch:{ Exception -> 0x00a0 }
            if (r0 != 0) goto L_0x0076
            goto L_0x0079
        L_0x0076:
            r17 = r0
            goto L_0x007b
        L_0x0079:
            r17 = r5
        L_0x007b:
            java.lang.String r0 = r1.v     // Catch:{ Exception -> 0x00a0 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 61512(0xf048, float:8.6197E-41)
            r18 = r0
            net.one97.paytm.recharge.common.utils.a.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x00a0 }
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed     // Catch:{ Exception -> 0x00a0 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x00a0 }
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x009f
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$m r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$m     // Catch:{ Exception -> 0x00a0 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00a0 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ Exception -> 0x00a0 }
            r0.postDelayed(r2, r3)     // Catch:{ Exception -> 0x00a0 }
        L_0x009f:
            return
        L_0x00a0:
            r0 = move-exception
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r1.a((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            if (r2 == 0) goto L_0x00ae
            r2.b()
        L_0x00ae:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.Throwable) r0)
            return
        L_0x00b6:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity
            if (r2 == 0) goto L_0x0138
            net.one97.paytm.recharge.common.utils.a r2 = net.one97.paytm.recharge.common.utils.a.f61493a     // Catch:{ Exception -> 0x00f4 }
            r7 = r1
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x00f4 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r8 = r2.getCategoryName()     // Catch:{ Exception -> 0x00f4 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.common.entity.CJRRechargeCart r9 = r2.getRechargeCart()     // Catch:{ Exception -> 0x00f4 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r2.getRechargePayment()     // Catch:{ Exception -> 0x00f4 }
            r11 = 0
            r12 = 0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r0     // Catch:{ Exception -> 0x00f4 }
            java.lang.Object r13 = r0.getHawkEyeEvent()     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.recharge.common.utils.a.a(r7, r8, r9, r10, r11, r12, r13, false)     // Catch:{ Exception -> 0x00f4 }
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed     // Catch:{ Exception -> 0x00f4 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0     // Catch:{ Exception -> 0x00f4 }
            if (r0 == 0) goto L_0x00f3
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$n r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$n     // Catch:{ Exception -> 0x00f4 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ Exception -> 0x00f4 }
            r0.postDelayed(r2, r3)     // Catch:{ Exception -> 0x00f4 }
        L_0x00f3:
            return
        L_0x00f4:
            r0 = move-exception
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r1.a((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            if (r2 == 0) goto L_0x0102
            r2.b()
        L_0x0102:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.Throwable) r0)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r6, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r6)
            java.lang.String r3 = "Unable to open PG page"
            r2.setErrorMsg(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x0123
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x0123:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x0132
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r4 = r4.name()
            r3.setActionType(r4)
        L_0x0132:
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2, (java.lang.Throwable) r0)
            return
        L_0x0138:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog
            if (r2 == 0) goto L_0x0183
            net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog) r0
            java.lang.Object r2 = r0.getHawkEyeEvent()
            boolean r2 = r2 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r2 == 0) goto L_0x0161
            java.lang.Object r2 = r0.getHawkEyeEvent()
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r2.getFlowName()
            if (r4 == 0) goto L_0x0158
            java.lang.String r6 = r4.getActionType()
        L_0x0158:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = r3.getActionType(r6, r4)
            r13 = r2
            r9 = r6
            goto L_0x0163
        L_0x0161:
            r9 = r6
            r13 = r9
        L_0x0163:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            if (r13 == 0) goto L_0x0170
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = r13.getErrorType()
            if (r2 != 0) goto L_0x0172
        L_0x0170:
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
        L_0x0172:
            r8 = r2
            java.lang.String r10 = r0.getTitle()
            java.lang.String r11 = r0.getMessage()
            r12 = 0
            r14 = 0
            r15 = 1504(0x5e0, float:2.108E-42)
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (java.lang.String) r10, (java.lang.String) r11, (boolean) r12, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13, (boolean) r14, (int) r15)
            return
        L_0x0183:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError
            if (r2 == 0) goto L_0x018e
            r23.c()
            r0 = 0
            r1.l = r0
            return
        L_0x018e:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "CCAmount Screen: performInstruction not handled "
            r3.<init>(r4)
            if (r0 == 0) goto L_0x01a5
            java.lang.Class r4 = r24.getClass()
            if (r4 == 0) goto L_0x01a5
            java.lang.String r4 = r4.getName()
            if (r4 != 0) goto L_0x01a6
        L_0x01a5:
            r4 = r5
        L_0x01a6:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.debugLog(r3)
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62549a;

        m(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62549a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62549a.a(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62550a;

        n(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62550a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62550a.a(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        Class<?> cls;
        String message;
        Class<?> cls2;
        String message2;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        String str2 = "";
        String str3 = null;
        if ((networkCustomError instanceof net.one97.paytm.recharge.common.utils.c) || (networkCustomError instanceof bc) || CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("CCAmount Screen: AuthError handled ");
            if (networkCustomError != null && (message = networkCustomError.getMessage()) != null) {
                str3 = message;
            } else if (!(networkCustomError == null || (cls = networkCustomError.getClass()) == null)) {
                str3 = cls.getName();
            }
            if (str3 != null) {
                str2 = str3;
            }
            sb.append(str2);
            cJRRechargeUtilities.debugLog(sb.toString());
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            return;
        }
        this.l = false;
        CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb2 = new StringBuilder("CCAmount Screen: onErrorResponse default handled ");
        if (networkCustomError != null && (message2 = networkCustomError.getMessage()) != null) {
            str3 = message2;
        } else if (!(networkCustomError == null || (cls2 = networkCustomError.getClass()) == null)) {
            str3 = cls2.getName();
        }
        if (str3 != null) {
            str2 = str3;
        }
        sb2.append(str2);
        cJRRechargeUtilities2.debugLog(sb2.toString());
        super.a(str, networkCustomError, obj);
    }

    public final void c() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
    }

    private final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return getString(R.string.proceed_re);
        }
        return getString(R.string.v3_proceed_btn_ff_selected, new Object[]{str});
    }

    public final void onResume() {
        super.onResume();
        if (this.G) {
            this.G = false;
            new Handler().postDelayed(new h(this), 100);
            f();
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62547a;

        h(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62547a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            CustomAmountTextInputEditTextV8 a2 = this.f62547a.f62534h;
            if (a2 != null) {
                new t(this.f62547a);
                t.a(a2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01bd, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r0.x
            if (r2 == 0) goto L_0x0015
            android.view.Window r2 = r18.getWindow()
            if (r2 == 0) goto L_0x0015
            r3 = 17
            r2.setSoftInputMode(r3)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x0015:
            if (r1 == 0) goto L_0x091e
            net.one97.paytm.recharge.widgets.c.e r2 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            net.one97.paytm.recharge.widgets.c.e r3 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            int r3 = r3.getDELAY_1000_MILLI()
            boolean r2 = r2.validateIsAlreadyClicked(r1, r3)
            if (r2 == 0) goto L_0x0027
            goto L_0x091e
        L_0x0027:
            int r1 = r19.getId()
            int r2 = net.one97.paytm.recharge.R.id.insurance_checkbox
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x00db
            java.lang.String r1 = r18.m()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x003e
            return
        L_0x003e:
            int r1 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r1 = r0.a((int) r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            if (r1 == 0) goto L_0x0085
            boolean r1 = r1.isChecked()
            if (r1 != r3) goto L_0x0085
            int r1 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r1 = r0.a((int) r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            if (r1 == 0) goto L_0x005b
            r1.setChecked(r4)
        L_0x005b:
            int r1 = net.one97.paytm.recharge.R.id.insurance_title
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0068
            r1.setSelected(r4)
        L_0x0068:
            int r1 = net.one97.paytm.recharge.R.id.insurance_subtitle
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0075
            r1.setSelected(r4)
        L_0x0075:
            int r1 = net.one97.paytm.recharge.R.id.insuranceIN
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x00b3
            boolean r1 = r1.performClick()
            java.lang.Boolean.valueOf(r1)
            goto L_0x00b3
        L_0x0085:
            net.one97.paytm.recharge.ordersummary.h.d r5 = r0.p     // Catch:{ all -> 0x009b }
            if (r5 == 0) goto L_0x009c
            java.lang.String r6 = "onus_credit_card"
            java.lang.String r7 = "insurance_checkbox_deselected"
            java.lang.String r8 = ""
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 120(0x78, float:1.68E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x009b }
            kotlin.x r1 = kotlin.x.f47997a     // Catch:{ all -> 0x009b }
            goto L_0x009c
        L_0x009b:
        L_0x009c:
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x00ab
            r1.a()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x00ab:
            r1 = r0
            net.one97.paytm.recharge.common.e.ai r1 = (net.one97.paytm.recharge.common.e.ai) r1
            java.lang.String r2 = "remove_insurance_verify"
            r0.a((java.lang.String) r2, (net.one97.paytm.recharge.common.e.ai) r1, (boolean) r4)
        L_0x00b3:
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x00da
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r0.I
            if (r2 == 0) goto L_0x00cd
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
            if (r2 == 0) goto L_0x00cd
            java.lang.String r2 = r2.getFinalPrice()
            if (r2 != 0) goto L_0x00d1
        L_0x00cd:
            java.lang.String r2 = r18.n()
        L_0x00d1:
            java.lang.String r2 = r0.a((java.lang.String) r2)
            r1.setProceedBtnText(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x00da:
            return
        L_0x00db:
            int r2 = net.one97.paytm.recharge.R.id.insurance_checkbox_container
            if (r1 != r2) goto L_0x00fd
            java.lang.String r1 = r18.m()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x091e
            int r1 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r1 = r0.a((int) r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.performClick()
            java.lang.Boolean.valueOf(r1)
        L_0x00fc:
            return
        L_0x00fd:
            int r2 = net.one97.paytm.recharge.R.id.insuranceIN
            java.lang.String r5 = "tnc_text"
            java.lang.String r6 = "tnc_title"
            if (r1 != r2) goto L_0x01a3
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x0110
            r1.clearFocus()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0110:
            int r1 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r1 = r0.a((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0121
            boolean r1 = r1.requestFocus()
            java.lang.Boolean.valueOf(r1)
        L_0x0121:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x0134
            net.one97.paytm.recharge.common.utils.t r2 = new net.one97.paytm.recharge.common.utils.t
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            r2.<init>(r3)
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.t.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0134:
            net.one97.paytm.recharge.model.CJRPersonalInsurance r1 = r0.z
            if (r1 == 0) goto L_0x01a2
            net.one97.paytm.recharge.mobile_v3.a.a r2 = r0.C
            if (r2 != 0) goto L_0x0143
            net.one97.paytm.recharge.mobile_v3.a.a r2 = new net.one97.paytm.recharge.mobile_v3.a.a
            r2.<init>()
            r0.C = r2
        L_0x0143:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            int r3 = net.one97.paytm.recharge.R.string.insurance_tnc_detail_dialog_title
            java.lang.String r3 = r0.getString(r3)
            r2.putString(r6, r3)
            int r3 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r3 = r0.a((int) r3)
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3
            java.lang.String r4 = "insurance_checkbox"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            boolean r3 = r3.isChecked()
            java.lang.String r4 = "intent_is_insurance_checked"
            r2.putBoolean(r4, r3)
            java.lang.String r1 = r1.getTermsAndConditions()
            r2.putString(r5, r1)
            net.one97.paytm.recharge.mobile_v3.a.a r1 = r0.C
            if (r1 != 0) goto L_0x0175
            kotlin.g.b.k.a()
        L_0x0175:
            r1.setArguments(r2)
            net.one97.paytm.recharge.mobile_v3.a.a r1 = r0.C
            if (r1 == 0) goto L_0x01a0
            if (r1 != 0) goto L_0x0181
            kotlin.g.b.k.a()
        L_0x0181:
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x01a0
            net.one97.paytm.recharge.mobile_v3.a.a r1 = r0.C
            if (r1 == 0) goto L_0x01a0
            androidx.fragment.app.j r2 = r18.getSupportFragmentManager()
            java.lang.String r3 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.recharge.mobile_v3.b.d$a r3 = net.one97.paytm.recharge.mobile_v3.b.d.s
            java.lang.String r3 = net.one97.paytm.recharge.mobile_v3.b.d.aI
            r1.show(r2, r3)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x01a0:
            kotlin.x r1 = kotlin.x.f47997a
        L_0x01a2:
            return
        L_0x01a3:
            int r2 = net.one97.paytm.recharge.R.id.txt_card_number
            if (r1 != r2) goto L_0x01b2
            r1 = -1
            r0.setResult(r1)
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            androidx.core.app.a.b(r1)
            return
        L_0x01b2:
            int r2 = net.one97.paytm.recharge.R.id.txt_promo_enabled
            java.lang.String r7 = ""
            r8 = 0
            if (r1 != r2) goto L_0x0234
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r1 = r0.f62529c
            if (r1 == 0) goto L_0x01c8
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r1 = r1.getBody()
            if (r1 == 0) goto L_0x01c8
            java.lang.String r1 = r1.getCardToken()
            goto L_0x01c9
        L_0x01c8:
            r1 = r8
        L_0x01c9:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0230
            r11 = r0
            android.content.Context r11 = (android.content.Context) r11
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r11)
            if (r1 != 0) goto L_0x01de
            r18.p()
            return
        L_0x01de:
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r15.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r15.getFlowName()
            if (r1 == 0) goto L_0x01f8
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x01f8:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r15.getFlowName()
            if (r1 == 0) goto L_0x0207
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_PROMO_CLICK
            java.lang.String r2 = r2.name()
            r1.setActionType(r2)
        L_0x0207:
            r0.w = r3
            net.one97.paytm.recharge.creditcard.c.a r9 = r0.f62528b
            if (r9 == 0) goto L_0x022f
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r0.f62530d
            if (r1 != 0) goto L_0x0214
            kotlin.g.b.k.a()
        L_0x0214:
            java.lang.String r1 = r1.getDisplayCardNumber()
            if (r1 != 0) goto L_0x021d
            kotlin.g.b.k.a()
        L_0x021d:
            java.lang.String r2 = " "
            java.lang.String r12 = kotlin.m.p.a(r1, r2, r7, r4)
            r13 = r0
            net.one97.paytm.recharge.common.e.ai r13 = (net.one97.paytm.recharge.common.e.ai) r13
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r14 = r0.f62530d
            java.lang.String r10 = "get_credit_card_token"
            r9.a(r10, r11, r12, r13, r14, r15)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x022f:
            return
        L_0x0230:
            r18.e()
            return
        L_0x0234:
            int r2 = net.one97.paytm.recharge.R.id.txt_promo_applied
            if (r1 != r2) goto L_0x0292
            net.one97.paytm.recharge.model.CJRPromoCode r1 = r0.J
            if (r1 == 0) goto L_0x091e
            if (r1 == 0) goto L_0x0243
            java.lang.String r1 = r1.getTerms()
            goto L_0x0244
        L_0x0243:
            r1 = r8
        L_0x0244:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x091e
            net.one97.paytm.recharge.mobile_v3.a.d r1 = new net.one97.paytm.recharge.mobile_v3.a.d
            r1.<init>()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            int r3 = net.one97.paytm.recharge.R.string.mobile_offer_detail_dialog_title
            java.lang.String r3 = r0.getString(r3)
            r2.putString(r6, r3)
            net.one97.paytm.recharge.model.CJRPromoCode r3 = r0.J
            if (r3 == 0) goto L_0x0268
            java.lang.String r3 = r3.getCode()
            goto L_0x0269
        L_0x0268:
            r3 = r8
        L_0x0269:
            java.lang.String r4 = "coupon_code_extra"
            r2.putString(r4, r3)
            net.one97.paytm.recharge.model.CJRPromoCode r3 = r0.J
            if (r3 == 0) goto L_0x0276
            java.lang.String r8 = r3.getTerms()
        L_0x0276:
            r2.putString(r5, r8)
            r1.setArguments(r2)
            boolean r2 = r1.isAdded()
            if (r2 != 0) goto L_0x091e
            androidx.fragment.app.j r2 = r18.getSupportFragmentManager()
            java.lang.Class r3 = r18.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            r1.show((androidx.fragment.app.j) r2, (java.lang.String) r3)
            return
        L_0x0292:
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            if (r1 != r2) goto L_0x029a
            r18.g()
            return
        L_0x029a:
            int r2 = net.one97.paytm.recharge.R.id.totalDueRL
            r5 = 8
            if (r1 != r2) goto L_0x0469
            net.one97.paytm.recharge.ordersummary.h.d r9 = r0.p     // Catch:{ all -> 0x02c4 }
            if (r9 == 0) goto L_0x02c5
            java.lang.String r10 = "onus_credit_card"
            java.lang.String r11 = "cc_amount_selected"
            java.lang.String r12 = ""
            int r1 = r18.o()     // Catch:{ all -> 0x02c4 }
            r2 = 2
            if (r1 != r2) goto L_0x02b4
            java.lang.String r1 = "partial"
            goto L_0x02b7
        L_0x02b4:
            java.lang.String r1 = "total"
        L_0x02b7:
            r13 = r1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 112(0x70, float:1.57E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x02c4 }
            kotlin.x r1 = kotlin.x.f47997a     // Catch:{ all -> 0x02c4 }
            goto L_0x02c5
        L_0x02c4:
        L_0x02c5:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = r0.D
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r2 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.TOTAL_DUE
            if (r1 == r2) goto L_0x02cd
            r0.k = r8
        L_0x02cd:
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x02da
            r1.setEnabled(r3)
        L_0x02da:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x02e6
            r2 = r0
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r1.removeTextChangedListener(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x02e6:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x02ef
            r1.setOnEditTextImeBackListener(r8)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x02ef:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.TOTAL_DUE
            r0.D = r1
            r0.c((boolean) r3)
            r0.a((boolean) r3)
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x0310
            java.lang.String r2 = r18.n()
            java.lang.String r2 = r0.a((java.lang.String) r2)
            r1.setProceedBtnText(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0310:
            int r1 = net.one97.paytm.recharge.R.id.totalDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0321
            int r2 = net.one97.paytm.recharge.R.drawable.v3_ic_selected_radio_btn
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0321:
            int r1 = net.one97.paytm.recharge.R.id.minDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0332
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0332:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0343
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0343:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x035b
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x035b:
            int r1 = net.one97.paytm.recharge.R.id.totalDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0373
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0373:
            int r1 = net.one97.paytm.recharge.R.id.minDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x038b
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x038b:
            int r1 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x03a3
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x03a3:
            int r1 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x03b2
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x03b2:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x03ca
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x03ca:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x03e2
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x03e2:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x03f4
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x03f4:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x03fd
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x03fd:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x0408
            r1.setVisibility(r4)
        L_0x0408:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountHeighlightedDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x0413
            r1.setVisibility(r5)
        L_0x0413:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x041c
            r1.clearFocus()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x041c:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x042f
            net.one97.paytm.recharge.common.utils.t r2 = new net.one97.paytm.recharge.common.utils.t
            r5 = r0
            android.app.Activity r5 = (android.app.Activity) r5
            r2.<init>(r5)
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.t.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x042f:
            int r1 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r1 = r0.a((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0440
            boolean r1 = r1.requestFocus()
            java.lang.Boolean.valueOf(r1)
        L_0x0440:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x0449
            java.lang.String r1 = r1.getCleanString()
            goto L_0x044a
        L_0x0449:
            r1 = r8
        L_0x044a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0456
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x0455
            goto L_0x0456
        L_0x0455:
            r3 = 0
        L_0x0456:
            if (r3 == 0) goto L_0x045b
            r0.d((boolean) r4)
        L_0x045b:
            java.lang.String r1 = r0.v
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x091e
            r0.c((net.one97.paytm.common.entity.CJRRechargeCart) r8)
            return
        L_0x0469:
            int r2 = net.one97.paytm.recharge.R.id.minDueRL
            if (r1 != r2) goto L_0x062a
            net.one97.paytm.recharge.ordersummary.h.d r9 = r0.p     // Catch:{ all -> 0x0485 }
            if (r9 == 0) goto L_0x0486
            java.lang.String r10 = "onus_credit_card"
            java.lang.String r11 = "cc_amount_selected"
            java.lang.String r12 = ""
            java.lang.String r13 = "min_due"
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 112(0x70, float:1.57E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0485 }
            kotlin.x r1 = kotlin.x.f47997a     // Catch:{ all -> 0x0485 }
            goto L_0x0486
        L_0x0485:
        L_0x0486:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = r0.D
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r2 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.MIN_DUE
            if (r1 == r2) goto L_0x048e
            r0.k = r8
        L_0x048e:
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x049b
            r1.setEnabled(r3)
        L_0x049b:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x04a7
            r2 = r0
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r1.removeTextChangedListener(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04a7:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x04b0
            r1.setOnEditTextImeBackListener(r8)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04b0:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.MIN_DUE
            r0.D = r1
            r0.c((boolean) r3)
            r0.a((boolean) r3)
            int r1 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x04d1
            java.lang.String r2 = r18.n()
            java.lang.String r2 = r0.a((java.lang.String) r2)
            r1.setProceedBtnText(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04d1:
            int r1 = net.one97.paytm.recharge.R.id.totalDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x04e2
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04e2:
            int r1 = net.one97.paytm.recharge.R.id.minDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x04f3
            int r2 = net.one97.paytm.recharge.R.drawable.v3_ic_selected_radio_btn
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04f3:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0504
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0504:
            int r1 = net.one97.paytm.recharge.R.id.minDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x051c
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x051c:
            int r1 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0534
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0534:
            int r1 = net.one97.paytm.recharge.R.id.totalDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x054c
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x054c:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0564
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0564:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0573
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x0573:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x058b
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x058b:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x05a3
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x05a3:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x05b5
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x05b5:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x05be
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x05be:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x05c9
            r1.setVisibility(r4)
        L_0x05c9:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountHeighlightedDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x05d4
            r1.setVisibility(r5)
        L_0x05d4:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x05dd
            r1.clearFocus()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x05dd:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x05f0
            net.one97.paytm.recharge.common.utils.t r2 = new net.one97.paytm.recharge.common.utils.t
            r5 = r0
            android.app.Activity r5 = (android.app.Activity) r5
            r2.<init>(r5)
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.t.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x05f0:
            int r1 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r1 = r0.a((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0601
            boolean r1 = r1.requestFocus()
            java.lang.Boolean.valueOf(r1)
        L_0x0601:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x060a
            java.lang.String r1 = r1.getCleanString()
            goto L_0x060b
        L_0x060a:
            r1 = r8
        L_0x060b:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0617
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x0616
            goto L_0x0617
        L_0x0616:
            r3 = 0
        L_0x0617:
            if (r3 == 0) goto L_0x061c
            r0.d((boolean) r4)
        L_0x061c:
            java.lang.String r1 = r0.v
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x091e
            r0.c((net.one97.paytm.common.entity.CJRRechargeCart) r8)
            return
        L_0x062a:
            int r2 = net.one97.paytm.recharge.R.id.anyAmountRL
            if (r1 != r2) goto L_0x08dd
            net.one97.paytm.recharge.ordersummary.h.d r9 = r0.p     // Catch:{ all -> 0x0646 }
            if (r9 == 0) goto L_0x0647
            java.lang.String r10 = "onus_credit_card"
            java.lang.String r11 = "cc_amount_selected"
            java.lang.String r12 = ""
            java.lang.String r13 = "custom"
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 112(0x70, float:1.57E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0646 }
            kotlin.x r1 = kotlin.x.f47997a     // Catch:{ all -> 0x0646 }
            goto L_0x0647
        L_0x0646:
        L_0x0647:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = r0.D
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r2 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.ANY_AMOUNT
            if (r1 == r2) goto L_0x066e
            r0.k = r8
            java.lang.String r1 = r0.v
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x066e
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x0662
            java.lang.String r1 = r1.getCleanString()
            goto L_0x0663
        L_0x0662:
            r1 = r8
        L_0x0663:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x066e
            r0.c((boolean) r3)
        L_0x066e:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = r0.D
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r2 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.ANY_AMOUNT
            if (r1 != r2) goto L_0x0678
            boolean r1 = r0.H
            if (r1 == 0) goto L_0x076c
        L_0x0678:
            r0.H = r4
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r0.f62530d
            if (r1 == 0) goto L_0x0683
            java.lang.String r1 = r1.getDeeplinkAmount()
            goto L_0x0684
        L_0x0683:
            r1 = r8
        L_0x0684:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 14
            if (r1 != 0) goto L_0x072e
            boolean r1 = r0.x
            if (r1 == 0) goto L_0x06e6
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.ANY_AMOUNT
            r0.D = r1
            int r1 = net.one97.paytm.recharge.R.id.anyAmountWordTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x06a5
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
        L_0x06a5:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountWordTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x06e6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x06b8
            java.lang.String r6 = r6.getDeeplinkAmount()
            goto L_0x06b9
        L_0x06b8:
            r6 = r8
        L_0x06b9:
            java.lang.String r6 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x06c9
            r6 = r7
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            goto L_0x06e3
        L_0x06c9:
            int r6 = net.one97.paytm.recharge.R.string.add_post_fix_only_after_amount
            java.lang.Object[] r9 = new java.lang.Object[r3]
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r10 = r0.f62530d
            if (r10 == 0) goto L_0x06d6
            java.lang.String r10 = r10.getDeeplinkAmount()
            goto L_0x06d7
        L_0x06d6:
            r10 = r8
        L_0x06d7:
            java.lang.String r10 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r10)
            r9[r4] = r10
            java.lang.String r6 = r0.getString(r6, r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
        L_0x06e3:
            r1.setText(r6)
        L_0x06e6:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x06fd
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.f62530d
            if (r6 == 0) goto L_0x06f4
            java.lang.String r8 = r6.getDeeplinkAmount()
        L_0x06f4:
            java.lang.String r6 = net.one97.paytm.recharge.widgets.c.d.d(r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
        L_0x06fd:
            r0.a((boolean) r3)
            r0.c((boolean) r3)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r0.f62530d
            if (r1 == 0) goto L_0x070a
            r1.setDeeplinkAmount(r7)
        L_0x070a:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x0711
            r1.requestFocus()
        L_0x0711:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x076c
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r6 = r0.f62534h
            if (r6 == 0) goto L_0x0721
            java.lang.String r6 = r6.getCleanString()
            if (r6 != 0) goto L_0x0722
        L_0x0721:
            r6 = r7
        L_0x0722:
            java.lang.String r2 = net.one97.paytm.recharge.widgets.c.d.a(r6, r4, r4, r4, r2)
            int r2 = r2.length()
            r1.setSelection(r2)
            goto L_0x076c
        L_0x072e:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x074a
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r6 = r0.f62534h
            if (r6 == 0) goto L_0x073e
            java.lang.String r6 = r6.getCleanString()
            if (r6 != 0) goto L_0x073f
        L_0x073e:
            r6 = r7
        L_0x073f:
            java.lang.String r2 = net.one97.paytm.recharge.widgets.c.d.a(r6, r4, r4, r4, r2)
            int r2 = r2.length()
            r1.setSelection(r2)
        L_0x074a:
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$o r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$o
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r6 = 100
            r1.postDelayed(r2, r6)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$p r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$p
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r6 = 500(0x1f4, double:2.47E-321)
            r1.postDelayed(r2, r6)
        L_0x076c:
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a.ANY_AMOUNT
            r0.D = r1
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x077c
            r2 = r0
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r1.addTextChangedListener(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x077c:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x078c
            net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$i r2 = new net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4$i
            r2.<init>(r0)
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8$b r2 = (net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8.b) r2
            r1.setOnEditTextImeBackListener(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x078c:
            int r1 = net.one97.paytm.recharge.R.id.totalDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x079d
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x079d:
            int r1 = net.one97.paytm.recharge.R.id.minDueIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x07ae
            int r2 = net.one97.paytm.recharge.R.drawable.ic_re_radio_button_unselected
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x07ae:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountIV
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x07bf
            int r2 = net.one97.paytm.recharge.R.drawable.v3_ic_selected_radio_btn
            r1.setImageResource(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x07bf:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x07d7
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x07d7:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x07e9
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x07e9:
            boolean r1 = r0.x
            if (r1 != 0) goto L_0x07f6
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x07f6
            android.graphics.Typeface r2 = r0.E
            r1.setTypeface(r2)
        L_0x07f6:
            int r1 = net.one97.paytm.recharge.R.id.totalDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x080e
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x080e:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0826
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0826:
            int r1 = net.one97.paytm.recharge.R.id.totaldDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0835
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x0835:
            int r1 = net.one97.paytm.recharge.R.id.minDueTitleTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x084d
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_title_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x084d:
            int r1 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0865
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r6 = net.one97.paytm.recharge.R.color.v4_amount_view_disabled_color
            int r2 = androidx.core.content.b.c(r2, r6)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0865:
            int r1 = net.one97.paytm.recharge.R.id.minDueAmountTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0874
            android.graphics.Typeface r2 = r0.F
            r1.setTypeface(r2)
        L_0x0874:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x087f
            r1.setVisibility(r5)
        L_0x087f:
            int r1 = net.one97.paytm.recharge.R.id.anyAmountHeighlightedDivider
            android.view.View r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x088a
            r1.setVisibility(r4)
        L_0x088a:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.f62534h
            if (r1 == 0) goto L_0x08dc
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            if (r2 == 0) goto L_0x08a5
            java.lang.String r5 = r18.n()
            java.lang.String r5 = r0.a((java.lang.String) r5)
            r2.setProceedBtnText(r5)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x08a5:
            net.one97.paytm.recharge.common.utils.t r2 = new net.one97.paytm.recharge.common.utils.t
            r5 = r0
            android.app.Activity r5 = (android.app.Activity) r5
            r2.<init>(r5)
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.t.b(r2)
            java.lang.String r1 = r1.getCleanString()
            if (r1 == 0) goto L_0x08bd
            int r4 = r1.length()
        L_0x08bd:
            if (r4 <= 0) goto L_0x08da
            int r1 = net.one97.paytm.recharge.R.id.anyAmountPrefixTV
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x08d7
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r4 = net.one97.paytm.recharge.R.color.v4_amount_title_and_view_enabled_color
            int r2 = androidx.core.content.b.c(r2, r4)
            r1.setTextColor(r2)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x08d7:
            r0.a((boolean) r3)
        L_0x08da:
            kotlin.x r1 = kotlin.x.f47997a
        L_0x08dc:
            return
        L_0x08dd:
            int r2 = net.one97.paytm.recharge.R.id.lyt_remove_promo
            if (r1 != r2) goto L_0x091e
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r2 != 0) goto L_0x08ee
            r18.p()
            return
        L_0x08ee:
            org.json.JSONObject r2 = r18.l()
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)
            int r5 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r5 = r0.a((int) r5)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r5 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r5
            if (r5 == 0) goto L_0x0905
            r5.setEnabled(r4)
        L_0x0905:
            int r4 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r4 = r0.a((int) r4)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r4 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r4
            if (r4 == 0) goto L_0x0912
            r4.a()
        L_0x0912:
            net.one97.paytm.recharge.creditcard.c.a r4 = r0.f62528b
            if (r4 == 0) goto L_0x091e
            r4 = r0
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4
            java.lang.String r5 = "remove_promo_verify"
            net.one97.paytm.recharge.creditcard.c.a.a((android.content.Context) r1, (java.lang.String) r5, (org.json.JSONObject) r2, (net.one97.paytm.recharge.common.e.ai) r4, (java.lang.Object) r3)
        L_0x091e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.onClick(android.view.View):void");
    }

    public static final class i implements CustomAmountTextInputEditTextV8.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62548a;

        i(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62548a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void a() {
            this.f62548a.f();
        }

        public final void b() {
            this.f62548a.f();
        }
    }

    private final void e() {
        try {
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
            if (dVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "bank_offers_promotions_clicked", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
            }
        } catch (Throwable unused) {
        }
        this.G = true;
        JSONObject l2 = l();
        net.one97.paytm.recharge.common.utils.o oVar = this.u;
        if (oVar != null) {
            oVar.f61686c = l2;
        }
        net.one97.paytm.recharge.common.utils.o oVar2 = this.u;
        if (oVar2 != null) {
            oVar2.c();
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        this.H = true;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            customAmountTextInputEditTextV8.clearFocus();
        }
        EditText editText = (EditText) a(R.id.emptyFocusET);
        if (editText != null) {
            editText.requestFocus();
        }
        View a2 = a(R.id.anyAmountDivider);
        if (a2 != null) {
            a2.setVisibility(0);
        }
        View a3 = a(R.id.anyAmountHeighlightedDivider);
        if (a3 != null) {
            a3.setVisibility(8);
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62551a;

        o(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62551a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            EditText editText = (EditText) this.f62551a.a(R.id.bottmFocusEt);
            if (editText != null) {
                editText.requestFocus();
            }
            ((NestedScrollView) this.f62551a.a(R.id.contentNSV)).a(130);
        }
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62552a;

        p(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62552a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            String str;
            CustomAmountTextInputEditTextV8 a2 = this.f62552a.f62534h;
            if (a2 != null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CustomAmountTextInputEditTextV8 a3 = this.f62552a.f62534h;
                if (a3 == null || (str = a3.getCleanString()) == null) {
                    str = "";
                }
                a2.requestFocus(net.one97.paytm.recharge.widgets.c.d.a(str, false, 0, false, 14).length());
            }
        }
    }

    public final void finishAfterTransition() {
        finish();
    }

    public final void onBackPressed() {
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
        if (dVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.q, "back_button_clicked", "", "amount", (Object) null, (Object) null, (Object) null, 112);
        }
        this.j = true;
        if (this.f62532f) {
            new t(this).a();
        }
        net.one97.paytm.recharge.common.f.d.a();
        net.one97.paytm.recharge.common.f.d.a(this, ba.f61539a);
        super.onBackPressed();
    }

    private final void g() {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        new t(this).a();
        this.m = false;
        this.j = false;
        if (!k() || this.f62532f) {
            h();
        } else {
            j();
        }
        try {
            if (!this.x && this.D == a.ANY_AMOUNT && (dVar = this.p) != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "custom_amount_entered", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
            }
        } catch (Throwable unused) {
        }
    }

    private final void h() {
        String str = TextUtils.isEmpty(this.v) ? "without_promo" : "with_promo";
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
        if (dVar != null) {
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "proceed_to_pay_amount_clicked", "", str, str2, this.v, (Object) null, 64);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.postDelayed(new d(this), 0);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62536a;

        d(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4) {
            this.f62536a = aJRCreditCardEnterAmountActivityV4;
        }

        public final void run() {
            CJRUtilityAlertV2 alert;
            if (this.f62536a.k()) {
                ax.a aVar = ax.f61521a;
                Context applicationContext = this.f62536a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                CJRProductsItem d2 = this.f62536a.f62535i;
                Long l = null;
                boolean a3 = a2.b(String.valueOf(d2 != null ? d2.getProductId() : null), false, false);
                CJRProductsItem d3 = this.f62536a.f62535i;
                if (((d3 == null || (alert = d3.getAlert()) == null) ? null : alert.getHeading()) == null || a3) {
                    this.f62536a.i();
                    return;
                }
                CJRProductsItem d4 = this.f62536a.f62535i;
                CJRUtilityAlertV2 alert2 = d4 != null ? d4.getAlert() : null;
                CJRProductsItem d5 = this.f62536a.f62535i;
                if (d5 != null) {
                    l = d5.getProductId();
                }
                net.one97.paytm.recharge.common.fragment.e.a(true, alert2, String.valueOf(l)).show(this.f62536a.getSupportFragmentManager(), net.one97.paytm.recharge.common.fragment.e.f61160a);
            }
        }
    }

    public final void b(boolean z2) {
        i();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r11 = this;
            net.one97.paytm.recharge.common.utils.t r0 = new net.one97.paytm.recharge.common.utils.t
            r1 = r11
            android.app.Activity r1 = (android.app.Activity) r1
            r0.<init>(r1)
            r0.a()
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r11.a((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x0018
            r0.a()
        L_0x0018:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r0 = r11.f62529c
            r1 = 0
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = r0.getBody()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.getCardToken()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x010f
            r0 = 0
            r11.l = r0
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r11.f62530d
            if (r2 == 0) goto L_0x003d
            java.lang.String r2 = r2.getDisplayCardNumber()
            goto L_0x003e
        L_0x003d:
            r2 = r1
        L_0x003e:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0099
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r10.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()
            if (r1 == 0) goto L_0x0062
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x0062:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()
            if (r1 == 0) goto L_0x0071
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r2 = r2.name()
            r1.setActionType(r2)
        L_0x0071:
            net.one97.paytm.recharge.creditcard.c.a r4 = r11.f62528b
            if (r4 == 0) goto L_0x0098
            r6 = r11
            android.content.Context r6 = (android.content.Context) r6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r11.f62530d
            if (r1 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            java.lang.String r1 = r1.getDisplayCardNumber()
            if (r1 != 0) goto L_0x0088
            kotlin.g.b.k.a()
        L_0x0088:
            java.lang.String r2 = " "
            java.lang.String r7 = kotlin.m.p.a(r1, r2, r3, r0)
            r8 = r11
            net.one97.paytm.recharge.common.e.ai r8 = (net.one97.paytm.recharge.common.e.ai) r8
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r9 = r11.f62530d
            java.lang.String r5 = "get_credit_card_token"
            r4.a(r5, r6, r7, r8, r9, r10)
        L_0x0098:
            return
        L_0x0099:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.common.entity.CJRItem r4 = r11.f62531e
            if (r4 == 0) goto L_0x00ab
            java.lang.String r4 = r4.getCategoryId()
            if (r4 != 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r3 = r4
        L_0x00ab:
            r2.setCategoryId(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r11.f62535i
            if (r3 == 0) goto L_0x00c0
            java.lang.Long r3 = r3.getProductId()
            if (r3 == 0) goto L_0x00c0
            long r3 = r3.longValue()
            java.lang.String r1 = java.lang.String.valueOf(r3)
        L_0x00c0:
            r2.setProductId(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r2.getFlowName()
            if (r1 == 0) goto L_0x00d2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_ARG
            java.lang.String r3 = r3.name()
            r1.setErrorType(r3)
        L_0x00d2:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r2.getFlowName()
            if (r1 == 0) goto L_0x00e1
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r3 = r3.name()
            r1.setActionType(r3)
        L_0x00e1:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r2.getFlowName()
            if (r1 == 0) goto L_0x00f0
            net.one97.paytm.recharge.widgets.model.ALERT_TYPE r3 = net.one97.paytm.recharge.widgets.model.ALERT_TYPE.PROCEED_TO_PG
            java.lang.String r3 = r3.name()
            r1.setAlertType(r3)
        L_0x00f0:
            int r1 = net.one97.paytm.recharge.R.string.credit_card_final_verify_proceed
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Class<net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4> r4 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.class
            java.lang.String r4 = r4.getSimpleName()
            r3[r0] = r4
            r0 = 1
            java.lang.String r4 = "proceedToVerifyCall"
            r3[r0] = r4
            java.lang.String r0 = r11.getString(r1, r3)
            r2.setErrorMsg(r0)
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2)
            return
        L_0x010f:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r0 = r11.f62529c
            r11.a((net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.i():void");
    }

    private final void a(CJRCreditCardTokenizationModel cJRCreditCardTokenizationModel) {
        String str;
        String str2;
        String str3;
        String str4;
        CJRCreditCardBodyModel body;
        String maskedCardNumber;
        CJRCreditCardBodyModel body2;
        String maskedCardNumber2;
        CJRCreditCardBodyModel body3;
        String cardToken;
        Long productId;
        String valueOf;
        String str5;
        CJRCart cart;
        StringBuilder journeyStackTrace;
        StringBuilder journeyStackTrace2;
        CJRCreditCardBodyModel body4;
        String maskedCardNumber3;
        if (!(cJRCreditCardTokenizationModel == null || (body4 = cJRCreditCardTokenizationModel.getBody()) == null || (maskedCardNumber3 = body4.getMaskedCardNumber()) == null)) {
            if (maskedCardNumber3.length() == 0) {
                az azVar = az.f61525a;
                az.a(this, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, (String) null, getString(R.string.something_went_wrong), 8);
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.b();
                    return;
                }
                return;
            }
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.CLP_PROCEED.name());
        }
        CRUFlowModel flowName3 = a2.getFlowName();
        if (!(flowName3 == null || (journeyStackTrace2 = flowName3.getJourneyStackTrace()) == null)) {
            kotlin.m.p.a(journeyStackTrace2);
        }
        CRUFlowModel flowName4 = a2.getFlowName();
        if (!(flowName4 == null || (journeyStackTrace = flowName4.getJourneyStackTrace()) == null)) {
            journeyStackTrace.append("-clpProceedClick");
        }
        CRUFlowModel flowName5 = a2.getFlowName();
        if (flowName5 != null) {
            flowName5.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        Context context = this;
        if (!com.paytm.utility.b.c(context)) {
            a("verify", new as(false, 1, (kotlin.g.b.g) null), (Object) a2);
        } else if (com.paytm.utility.d.c(context)) {
            this.l = true;
            net.one97.paytm.recharge.creditcard.c.a aVar = this.f62528b;
            if (aVar != null) {
                CJRRechargeCart cJRRechargeCart = this.k;
                String str6 = (cJRRechargeCart == null ? (str5 = m()) != null : !(cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str5 = cart.getFinalPrice()) == null)) ? str5 : "";
                CJRProductsItem cJRProductsItem = this.f62535i;
                if (cJRProductsItem == null || (productId = cJRProductsItem.getProductId()) == null || (valueOf = String.valueOf(productId.longValue())) == null) {
                    str = "";
                } else {
                    str = valueOf;
                }
                if (cJRCreditCardTokenizationModel == null || (body3 = cJRCreditCardTokenizationModel.getBody()) == null || (cardToken = body3.getCardToken()) == null) {
                    str2 = "";
                } else {
                    str2 = cardToken;
                }
                if (cJRCreditCardTokenizationModel == null || (body2 = cJRCreditCardTokenizationModel.getBody()) == null || (maskedCardNumber2 = body2.getMaskedCardNumber()) == null) {
                    str3 = "";
                } else {
                    str3 = maskedCardNumber2;
                }
                if (cJRCreditCardTokenizationModel == null || (body = cJRCreditCardTokenizationModel.getBody()) == null || (maskedCardNumber = body.getMaskedCardNumber()) == null) {
                    str4 = "";
                } else {
                    str4 = maskedCardNumber;
                }
                String str7 = this.f62533g;
                CJRProductsItem cJRProductsItem2 = this.f62535i;
                boolean z2 = cJRProductsItem2 != null && cJRProductsItem2.isVisaDirectEnabled();
                CJRProductsItem cJRProductsItem3 = this.f62535i;
                boolean z3 = cJRProductsItem3 != null && cJRProductsItem3.isBillPaymentEnabled();
                String str8 = this.v;
                CJRProductsItem cJRProductsItem4 = this.f62535i;
                aVar.a("verify", context, str6, str, str2, str3, str4, str7, z2, z3, str8, cJRProductsItem4 != null && cJRProductsItem4.isProceedToPGEnabled(), this.z, (Object) a2);
            }
        } else {
            a("verify", new net.one97.paytm.recharge.common.utils.c(), (Object) a2);
        }
    }

    private final void j() {
        b.a aVar = net.one97.paytm.recharge.creditcard.v4.b.b.f62567a;
        StringBuilder sb = new StringBuilder();
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62530d;
        String str = null;
        sb.append(cJRCreditCardModelV8 != null ? cJRCreditCardModelV8.getBankName() : null);
        sb.append(' ');
        sb.append(this.A);
        String sb2 = sb.toString();
        CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62530d;
        String cardNumber = cJRCreditCardModelV82 != null ? cJRCreditCardModelV82.getCardNumber() : null;
        CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62530d;
        String operaterImage = cJRCreditCardModelV83 != null ? cJRCreditCardModelV83.getOperaterImage() : null;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            str = customAmountTextInputEditTextV8.getCleanString();
        }
        net.one97.paytm.recharge.creditcard.v4.b.b a2 = b.a.a(sb2, cardNumber, operaterImage, str);
        a2.a((b.C1208b) this);
        a2.show(getSupportFragmentManager(), net.one97.paytm.recharge.creditcard.v4.b.b.class.getSimpleName());
    }

    public final void b() {
        try {
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
            if (dVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "confirm_and_proceed_new_card_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        } catch (Throwable unused) {
        }
        h();
    }

    /* access modifiers changed from: private */
    public final boolean k() {
        if (this.f62535i == null || TextUtils.isEmpty(m())) {
            String string = getResources().getString(R.string.electricity_empty_value_msg, new Object[]{"Amount"});
            kotlin.g.b.k.a((Object) string, "resources\n              …                \"Amount\")");
            az azVar = az.f61525a;
            az.a(this, ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, (String) null, string, 12);
            return false;
        }
        CJRProductsItem cJRProductsItem = this.f62535i;
        List<CJRInputFieldsItem> inputFields = cJRProductsItem != null ? cJRProductsItem.getInputFields() : null;
        if (inputFields == null) {
            return false;
        }
        for (CJRInputFieldsItem a2 : inputFields) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }

    private final boolean a(CJRInputFieldsItem cJRInputFieldsItem) {
        Double max;
        CJRInputFieldsItem cJRInputFieldsItem2 = cJRInputFieldsItem;
        if (kotlin.g.b.k.a((Object) cJRInputFieldsItem2 != null ? cJRInputFieldsItem.getType() : null, (Object) "amount")) {
            cJRInputFieldsItem2.setRegex("");
            String string = getString(R.string.invalid_amount);
            kotlin.g.b.k.a((Object) string, "getString(R.string.invalid_amount)");
            String m2 = m();
            double d2 = 0.0d;
            double parseDouble = m2 != null ? Double.parseDouble(m2) : 0.0d;
            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
            if (customAmountTextInputEditTextV8 != null && customAmountTextInputEditTextV8.getVisibility() == 0) {
                CharSequence charSequence = m2;
                if (TextUtils.isEmpty(charSequence)) {
                    String string2 = getString(R.string.electricity_empty_value_msg, new Object[]{cJRInputFieldsItem.getTitle()});
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.elect…ue_msg, inputField.title)");
                    az azVar = az.f61525a;
                    az.a(this, ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, (String) null, string2, 12);
                    return false;
                }
                double d3 = 1.0d;
                double doubleValue = (cJRInputFieldsItem.getMax() == null || (max = cJRInputFieldsItem.getMax()) == null) ? 0.0d : max.doubleValue();
                if (cJRInputFieldsItem.getMin() != null) {
                    Double min = cJRInputFieldsItem.getMin();
                    if (min != null) {
                        d2 = min.doubleValue();
                    }
                    d3 = d2;
                }
                if (parseDouble < d3) {
                    try {
                        Resources resources = getResources();
                        int i2 = R.string.electricity_bill_amount_more_than;
                        String string3 = resources.getString(i2, new Object[]{String.valueOf(d3)});
                        kotlin.g.b.k.a((Object) string3, "resources.getString(\n   …  minAmt.toString() + \"\")");
                        if (doubleValue >= d3) {
                            Resources resources2 = getResources();
                            int i3 = R.string.electricity_bill_amount_not_in_range;
                            string3 = resources2.getString(i3, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                            kotlin.g.b.k.a((Object) string3, "resources.getString(\n   …, maxAmt.toString() + \"\")");
                        }
                        az azVar2 = az.f61525a;
                        az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string3);
                        return false;
                    } catch (Exception e2) {
                        Resources resources3 = getResources();
                        int i4 = R.string.electricity_bill_amount_more_than;
                        String string4 = resources3.getString(i4, new Object[]{String.valueOf(d3)});
                        kotlin.g.b.k.a((Object) string4, "resources.getString(\n   …, minAmt.toString() + \"\")");
                        if (doubleValue >= d3) {
                            Resources resources4 = getResources();
                            int i5 = R.string.electricity_bill_amount_not_in_range;
                            string4 = resources4.getString(i5, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                            kotlin.g.b.k.a((Object) string4, "resources.getString(\n   …  maxAmt.toString() + \"\")");
                        }
                        az azVar3 = az.f61525a;
                        az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string4);
                        e2.printStackTrace();
                        return false;
                    }
                } else if (doubleValue >= d3 && parseDouble > doubleValue) {
                    Resources resources5 = getResources();
                    int i6 = R.string.electricity_bill_amount_not_in_range;
                    String string5 = resources5.getString(i6, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                    kotlin.g.b.k.a((Object) string5, "resources.getString(\n   …, maxAmt.toString() + \"\")");
                    az azVar4 = az.f61525a;
                    az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string5);
                    return false;
                } else if (!TextUtils.isEmpty(cJRInputFieldsItem.getRegex())) {
                    if (m2 == null) {
                        kotlin.g.b.k.a();
                    }
                    String regex = cJRInputFieldsItem.getRegex();
                    if (regex == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!new kotlin.m.l(regex).matches(charSequence)) {
                        String string6 = getString(R.string.electricity_empty_value_msg, new Object[]{cJRInputFieldsItem.getTitle()});
                        kotlin.g.b.k.a((Object) string6, "getString(R.string.elect…ue_msg, inputField.title)");
                        az azVar5 = az.f61525a;
                        az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, getString(R.string.error), string6);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final JSONObject l() {
        String str;
        CJRCreditCardBodyModel body;
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62530d;
        if (cJRCreditCardModelV8 == null || (str = cJRCreditCardModelV8.getCardNumber()) == null) {
            str = "";
        }
        JSONObject jSONObject = new JSONObject();
        CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62530d;
        String str2 = null;
        CJRAggsItem selectedDCVariant = cJRCreditCardModelV82 != null ? cJRCreditCardModelV82.getSelectedDCVariant() : null;
        String a2 = this.f62528b != null ? net.one97.paytm.recharge.creditcard.c.a.a(str) : null;
        String b2 = this.f62528b != null ? net.one97.paytm.recharge.creditcard.c.a.b(str) : null;
        List<CJRProductsItem> productList = selectedDCVariant != null ? selectedDCVariant.getProductList() : null;
        if (productList == null) {
            kotlin.g.b.k.a();
        }
        String valueOf = String.valueOf(productList.get(0).getProductId());
        boolean isBillPaymentEnabled = selectedDCVariant.getProductList().get(0).isBillPaymentEnabled();
        boolean isVisaDirectEnabled = selectedDCVariant.getProductList().get(0).isVisaDirectEnabled();
        String str3 = this.f62533g;
        JSONObject jSONObject2 = new JSONObject();
        CJRItem cJRItem = this.f62531e;
        if (cJRItem == null) {
            kotlin.g.b.k.a();
        }
        jSONObject2.put("category_id", cJRItem.getCategoryId());
        String m2 = m();
        if (m2 == null) {
            m2 = "";
        }
        jSONObject2.put("price", m2);
        jSONObject2.put("recharge_number", b2);
        CJRCreditCardTokenizationModel cJRCreditCardTokenizationModel = this.f62529c;
        if (!(cJRCreditCardTokenizationModel == null || (body = cJRCreditCardTokenizationModel.getBody()) == null)) {
            str2 = body.getCardToken();
        }
        jSONObject2.put("recharge_number_2", str2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("bin_number", a2);
        CharSequence charSequence = str3;
        if (!TextUtils.isEmpty(charSequence)) {
            jSONObject3.put("payment_request_type", str3);
        }
        if (isBillPaymentEnabled) {
            jSONObject3.put("enable_bill_payment", "1");
            if (isVisaDirectEnabled) {
                jSONObject3.put("enable_visa_direct", "1");
            } else {
                jSONObject3.put("enable_visa_direct", "0");
            }
        }
        Context context = this;
        jSONObject3.put("id", com.paytm.utility.b.n(context));
        jSONObject3.put("customer_mobile", com.paytm.utility.b.l(context));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(CLPConstants.PRODUCT_ID, valueOf);
        jSONObject4.put("qty", 1);
        jSONObject4.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
        jSONObject4.put("meta_data", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject4);
        jSONObject.put("cart_items", jSONArray);
        if (!TextUtils.isEmpty(charSequence)) {
            jSONObject.put("payment_request_type", str3);
        }
        jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, "");
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: net.one97.paytm.recharge.model.v4.CJRAggsItem} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r6, com.paytm.network.model.IJRPaytmDataModel r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r6, r0)
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r5.a((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x0013
            r0.b()
        L_0x0013:
            java.lang.String r0 = "remove_insurance_verify"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0071
            boolean r6 = r7 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r6 == 0) goto L_0x01b4
            int r6 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r6 = r5.a((int) r6)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            if (r6 == 0) goto L_0x002d
            r6.setChecked(r1)
        L_0x002d:
            int r6 = net.one97.paytm.recharge.R.id.insurance_title
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003a
            r6.setSelected(r1)
        L_0x003a:
            int r6 = net.one97.paytm.recharge.R.id.insurance_subtitle
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0047
            r6.setSelected(r1)
        L_0x0047:
            net.one97.paytm.common.entity.CJRRechargeCart r7 = (net.one97.paytm.common.entity.CJRRechargeCart) r7
            r5.I = r7
            int r6 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r6 = r5.a((int) r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r6 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r6
            if (r6 == 0) goto L_0x0070
            net.one97.paytm.common.entity.CJRRechargeCart r7 = r5.I
            if (r7 == 0) goto L_0x0065
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r7.getCart()
            if (r7 == 0) goto L_0x0065
            java.lang.String r7 = r7.getFinalPrice()
            if (r7 != 0) goto L_0x0069
        L_0x0065:
            java.lang.String r7 = r5.m()
        L_0x0069:
            java.lang.String r7 = r5.a((java.lang.String) r7)
            r6.setProceedBtnText(r7)
        L_0x0070:
            return
        L_0x0071:
            java.lang.String r0 = "remove_promo_verify"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            r2 = 1
            if (r0 == 0) goto L_0x00a4
            int r6 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r6 = r5.a((int) r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r6 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r6
            if (r6 == 0) goto L_0x0087
            r6.setEnabled(r2)
        L_0x0087:
            int r6 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r6 = r5.a((int) r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r6 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r6
            if (r6 == 0) goto L_0x0094
            r6.b()
        L_0x0094:
            if (r7 == 0) goto L_0x009c
            net.one97.paytm.common.entity.CJRRechargeCart r7 = (net.one97.paytm.common.entity.CJRRechargeCart) r7
            r5.c((net.one97.paytm.common.entity.CJRRechargeCart) r7)
            return
        L_0x009c:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart"
            r6.<init>(r7)
            throw r6
        L_0x00a4:
            boolean r0 = r7 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel
            r3 = 0
            if (r0 == 0) goto L_0x0198
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r7 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel) r7
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r6 = r7.getBody()
            if (r6 == 0) goto L_0x00b6
            java.lang.String r6 = r6.getCardToken()
            goto L_0x00b7
        L_0x00b6:
            r6 = r3
        L_0x00b7:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r0 = ""
            if (r6 != 0) goto L_0x011c
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r6 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r4 = "CCAmount Screen: onResponse : cc-token : SUCCESS : on-proceed-click "
            r8.<init>(r4)
            boolean r4 = r5.l
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r6.debugLog(r8)
            r5.f62529c = r7
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r5.f62530d
            if (r6 == 0) goto L_0x00e0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = r6.getSelectedDCVariant()
        L_0x00e0:
            if (r3 == 0) goto L_0x0104
            java.util.List r6 = r3.getProductList()
            if (r6 == 0) goto L_0x0104
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0104
            java.util.List r6 = r3.getProductList()
            java.lang.Object r6 = r6.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getRequestType()
            if (r6 != 0) goto L_0x0102
            r6 = r0
        L_0x0102:
            r5.f62533g = r6
        L_0x0104:
            boolean r6 = r5.w
            if (r6 == 0) goto L_0x010e
            r5.w = r1
            r5.e()
            return
        L_0x010e:
            boolean r6 = r5.l
            if (r6 != 0) goto L_0x0119
            boolean r6 = r5.t
            if (r6 != 0) goto L_0x0119
            r5.i()
        L_0x0119:
            r5.t = r1
            return
        L_0x011c:
            boolean r6 = r5.l
            if (r6 == 0) goto L_0x0137
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r6 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r7 = "CCAmount Screen: onResponse : cc-token : Still NOT SUCCESS : on-proceed-click"
            r6.debugLog(r7)
            int r6 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r6 = r5.a((int) r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r6 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r6
            if (r6 == 0) goto L_0x0134
            r6.b()
        L_0x0134:
            r5.t = r1
            return
        L_0x0137:
            boolean r6 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r6 == 0) goto L_0x0197
            boolean r6 = r5.t
            if (r6 != 0) goto L_0x0151
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            int r7 = net.one97.paytm.recharge.R.string.error_title_inconvenience
            java.lang.String r7 = r5.getString(r7)
            int r3 = net.one97.paytm.recharge.R.string.oops_something_went_wrong
            java.lang.String r3 = r5.getString(r3)
            com.paytm.utility.b.b(r6, r7, r3, r2)
        L_0x0151:
            int r6 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r6 = r5.a((int) r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r6 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r6
            if (r6 == 0) goto L_0x015e
            r6.b()
        L_0x015e:
            r5.t = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r8 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r8.getFlowName()
            if (r6 == 0) goto L_0x016b
            r6.setAlertType(r0)
        L_0x016b:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r8.getFlowName()
            if (r6 == 0) goto L_0x017a
            java.lang.StringBuilder r6 = r6.getJourneyStackTrace()
            if (r6 == 0) goto L_0x017a
            kotlin.m.p.a(r6)
        L_0x017a:
            int r6 = net.one97.paytm.recharge.R.string.credit_card_fetch_card_token
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Class<net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4> r0 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.class
            java.lang.String r0 = r0.getSimpleName()
            r7[r1] = r0
            java.lang.String r0 = "onApiSuccess"
            r7[r2] = r0
            java.lang.String r6 = r5.getString(r6, r7)
            r8.setErrorMsg(r6)
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8)
        L_0x0197:
            return
        L_0x0198:
            java.lang.String r8 = "fetch_promo_term_condition"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x01b4
            boolean r6 = r7 instanceof net.one97.paytm.recharge.model.CJRPromoCodeTerms
            if (r6 != 0) goto L_0x01a5
            r7 = r3
        L_0x01a5:
            net.one97.paytm.recharge.model.CJRPromoCodeTerms r7 = (net.one97.paytm.recharge.model.CJRPromoCodeTerms) r7
            net.one97.paytm.recharge.model.CJRPromoCode r6 = r5.J
            if (r6 == 0) goto L_0x01b4
            if (r7 == 0) goto L_0x01b1
            java.lang.String r3 = r7.getTerms()
        L_0x01b1:
            r6.setTerms(r3)
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        if (kotlin.g.b.k.a((Object) str, (Object) this.B)) {
            this.t = false;
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        } else if (kotlin.g.b.k.a((Object) str, (Object) "get_credit_card_token")) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
            this.w = false;
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        } else if (kotlin.g.b.k.a((Object) str, (Object) "remove_promo_verify")) {
            CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
            if (cJRProceedWidgetV82 != null) {
                cJRProceedWidgetV82.setEnabled(true);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV83 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
            if (cJRProceedWidgetV83 != null) {
                cJRProceedWidgetV83.b();
            }
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        } else if (obj instanceof CJRRechargeErrorModel) {
            az azVar2 = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    public final void onDestroy() {
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            customAmountTextInputEditTextV8.removeTextChangedListener(this);
        }
        super.onDestroy();
    }

    public final void a(ai aiVar) {
        kotlin.g.b.k.c(aiVar, "onSuccess");
        a("insurance_verify", aiVar, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r19, net.one97.paytm.recharge.common.e.ai r20, boolean r21) {
        /*
            r18 = this;
            r0 = r18
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r1 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r15.setErrorType(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r15.getFlowName()
            if (r2 == 0) goto L_0x001d
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x001d:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r15.getFlowName()
            if (r2 == 0) goto L_0x002c
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x002c:
            if (r21 != 0) goto L_0x0045
            int r2 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r2 = r0.a((int) r2)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            java.lang.String r3 = "insurance_checkbox"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r17 = r1
            goto L_0x0049
        L_0x0045:
            net.one97.paytm.recharge.model.CJRPersonalInsurance r2 = r0.z
            r17 = r2
        L_0x0049:
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r4)
            java.lang.String r3 = "insurance_verify"
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x00fe
            boolean r1 = com.paytm.utility.d.c(r4)
            if (r1 == 0) goto L_0x00f3
            r0.l = r6
            net.one97.paytm.recharge.creditcard.c.a r2 = r0.f62528b
            if (r2 == 0) goto L_0x00f2
            java.lang.String r1 = r18.m()
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x006b
            r1 = r3
        L_0x006b:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r7 = r0.f62535i
            if (r7 == 0) goto L_0x007f
            java.lang.Long r7 = r7.getProductId()
            if (r7 == 0) goto L_0x007f
            long r7 = r7.longValue()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            if (r7 != 0) goto L_0x0080
        L_0x007f:
            r7 = r3
        L_0x0080:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r8 = r0.f62529c
            if (r8 == 0) goto L_0x0090
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r8 = r8.getBody()
            if (r8 == 0) goto L_0x0090
            java.lang.String r8 = r8.getCardToken()
            if (r8 != 0) goto L_0x0091
        L_0x0090:
            r8 = r3
        L_0x0091:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r9 = r0.f62529c
            if (r9 == 0) goto L_0x00a1
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r9 = r9.getBody()
            if (r9 == 0) goto L_0x00a1
            java.lang.String r9 = r9.getMaskedCardNumber()
            if (r9 != 0) goto L_0x00a2
        L_0x00a1:
            r9 = r3
        L_0x00a2:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r10 = r0.f62529c
            if (r10 == 0) goto L_0x00b2
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r10 = r10.getBody()
            if (r10 == 0) goto L_0x00b2
            java.lang.String r10 = r10.getMaskedCardNumber()
            if (r10 != 0) goto L_0x00b3
        L_0x00b2:
            r10 = r3
        L_0x00b3:
            java.lang.String r11 = r0.f62533g
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r0.f62535i
            if (r3 == 0) goto L_0x00c1
            boolean r3 = r3.isVisaDirectEnabled()
            if (r3 != r6) goto L_0x00c1
            r12 = 1
            goto L_0x00c2
        L_0x00c1:
            r12 = 0
        L_0x00c2:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r0.f62535i
            if (r3 == 0) goto L_0x00ce
            boolean r3 = r3.isBillPaymentEnabled()
            if (r3 != r6) goto L_0x00ce
            r13 = 1
            goto L_0x00cf
        L_0x00ce:
            r13 = 0
        L_0x00cf:
            java.lang.String r14 = r0.v
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r0.f62535i
            if (r3 == 0) goto L_0x00de
            boolean r3 = r3.isProceedToPGEnabled()
            if (r3 != r6) goto L_0x00de
            r16 = 1
            goto L_0x00e0
        L_0x00de:
            r16 = 0
        L_0x00e0:
            r3 = r19
            r5 = r1
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r16
            r16 = r20
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x00f2:
            return
        L_0x00f3:
            net.one97.paytm.recharge.common.utils.c r1 = new net.one97.paytm.recharge.common.utils.c
            r1.<init>()
            com.paytm.network.model.NetworkCustomError r1 = (com.paytm.network.model.NetworkCustomError) r1
            r0.a((java.lang.String) r3, (com.paytm.network.model.NetworkCustomError) r1, (java.lang.Object) r15)
            return
        L_0x00fe:
            net.one97.paytm.recharge.common.utils.as r2 = new net.one97.paytm.recharge.common.utils.as
            r2.<init>(r5, r6, r1)
            com.paytm.network.model.NetworkCustomError r2 = (com.paytm.network.model.NetworkCustomError) r2
            r0.a((java.lang.String) r3, (com.paytm.network.model.NetworkCustomError) r2, (java.lang.Object) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, boolean):void");
    }

    public final void b(CJRRechargeCart cJRRechargeCart) {
        String str;
        CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        kotlin.g.b.k.c(cJRRechargeCart2, "rechargeCart");
        az azVar = az.f61525a;
        Bundle a2 = az.a((Context) null, cJRRechargeCart2, false, 5);
        boolean z2 = a2.getBoolean("extra.has.error");
        String string = a2.getString("extra.error.msg");
        if (z2) {
            az azVar2 = az.f61525a;
            az.a(this, ERROR_TYPE.UNDEFINED, (ACTION_TYPE) null, (String) null, string, 12);
            return;
        }
        try {
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
            if (dVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "insurance_checkbox_selected", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
            }
        } catch (Throwable unused) {
        }
        this.I = cJRRechargeCart2;
        CheckBox checkBox = (CheckBox) a(R.id.insurance_checkbox);
        if (checkBox != null) {
            checkBox.setChecked(true);
        }
        TextView textView = (TextView) a(R.id.insurance_title);
        if (textView != null) {
            textView.setSelected(true);
        }
        TextView textView2 = (TextView) a(R.id.insurance_subtitle);
        if (textView2 != null) {
            textView2.setSelected(true);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRCart cart = cJRRechargeCart.getCart();
            if (cart == null || (str = cart.getFinalPrice()) == null) {
                str = m();
            }
            cJRProceedWidgetV8.setProceedBtnText(a(net.one97.paytm.recharge.widgets.c.d.d(str)));
        }
    }

    public final void b(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62528b;
        if (aVar != null) {
            if (str == null) {
                str = "";
            }
            aVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }
    }

    private final String m() {
        a aVar = this.D;
        Double d2 = null;
        if (aVar != null) {
            int i2 = a.f62557a[aVar.ordinal()];
            if (i2 == 1) {
                CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62530d;
                if (cJRCreditCardModelV8 != null) {
                    d2 = cJRCreditCardModelV8.getTotalDue();
                }
                return String.valueOf(d2);
            } else if (i2 == 2) {
                CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62530d;
                if (cJRCreditCardModelV82 != null) {
                    d2 = cJRCreditCardModelV82.getMinDue();
                }
                return String.valueOf(d2);
            }
        }
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.f62534h;
        if (customAmountTextInputEditTextV8 != null) {
            return customAmountTextInputEditTextV8.getCleanString();
        }
        return null;
    }

    private final String n() {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        return net.one97.paytm.recharge.widgets.c.d.d(m());
    }

    private final int o() {
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62530d;
        if (cJRCreditCardModelV8 != null) {
            String valueOf = String.valueOf(cJRCreditCardModelV8.getTotalDue());
            String valueOf2 = String.valueOf(cJRCreditCardModelV8.getMinDue());
            CharSequence charSequence = valueOf;
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(valueOf2)) {
                Double b2 = kotlin.m.p.b(valueOf);
                if ((b2 != null ? b2.doubleValue() : 0.0d) != 0.0d) {
                    Double b3 = kotlin.m.p.b(valueOf2);
                    if ((b3 != null ? b3.doubleValue() : 0.0d) != 0.0d) {
                        return 1;
                    }
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                Double b4 = kotlin.m.p.b(valueOf);
                if ((b4 != null ? b4.doubleValue() : 0.0d) != 0.0d) {
                    if (TextUtils.isEmpty(valueOf2)) {
                        return 2;
                    }
                    Double b5 = kotlin.m.p.b(valueOf2);
                    if ((b5 != null ? b5.doubleValue() : 0.0d) == 0.0d) {
                        return 2;
                    }
                }
            }
        }
        return 3;
    }

    public final void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart) {
        net.one97.paytm.recharge.creditcard.c.a aVar;
        kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
        this.k = cJRRechargeCart;
        if (cJRPromoCode != null && !TextUtils.isEmpty(cJRPromoCode.getCode())) {
            this.J = cJRPromoCode;
            String code = cJRPromoCode.getCode();
            if (code == null) {
                code = "";
            }
            this.v = code;
            if (TextUtils.isEmpty(cJRPromoCode.getTerms()) && !TextUtils.isEmpty(this.v) && (aVar = this.f62528b) != null) {
                String str = this.v;
                ai aiVar = this;
                kotlin.g.b.k.c(str, "promoCode");
                kotlin.g.b.k.c(aiVar, "onSuccess");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar.s.a("fetch_promo_term_condition", str, (ai) new a.g(aiVar), (Object) net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.PROMO_TNC, ERROR_TYPE.UNDEFINED));
            }
            CJRPromoWidgetV3 cJRPromoWidgetV3 = (CJRPromoWidgetV3) a(R.id.bank_offers_promocode_text_layout);
            if (cJRPromoWidgetV3 != null) {
                String code2 = cJRPromoCode.getCode();
                if (code2 == null) {
                    kotlin.g.b.k.a();
                }
                View.OnClickListener onClickListener = this;
                cJRPromoWidgetV3.a(code2, onClickListener, onClickListener);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRCart cart = cJRRechargeCart.getCart();
                cJRProceedWidgetV8.setProceedBtnText(a(net.one97.paytm.recharge.widgets.c.d.d(cart != null ? cart.getFinalPrice() : null)));
            }
        }
    }

    private final void p() {
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.UNDEFINED, getString(R.string.no_connection), getString(R.string.no_internet));
    }

    private final void c(CJRRechargeCart cJRRechargeCart) {
        String str;
        this.k = cJRRechargeCart;
        this.v = "";
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            if (cJRRechargeCart == null) {
                str = m();
            } else {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRCart cart = cJRRechargeCart.getCart();
                str = net.one97.paytm.recharge.widgets.c.d.d(cart != null ? cart.getFinalPrice() : null);
            }
            cJRProceedWidgetV8.setProceedBtnText(a(str));
        }
        c(true);
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "cjrRechargeCart");
        c(cJRRechargeCart);
    }

    public final void a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        if ((networkCustomError instanceof net.one97.paytm.recharge.common.utils.c) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
            new Handler().postDelayed(new e(this, networkCustomError), 500);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivityV4 f62537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NetworkCustomError f62538b;

        e(AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4, NetworkCustomError networkCustomError) {
            this.f62537a = aJRCreditCardEnterAmountActivityV4;
            this.f62538b = networkCustomError;
        }

        public final void run() {
            CJRCreditCardBodyModel body;
            CJRCreditCardTokenizationModel f2 = this.f62537a.f62529c;
            if (!(f2 == null || (body = f2.getBody()) == null)) {
                body.setCardToken((String) null);
            }
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            AJRCreditCardEnterAmountActivityV4 aJRCreditCardEnterAmountActivityV4 = this.f62537a;
            Intent intent = aJRCreditCardEnterAmountActivityV4.getIntent();
            kotlin.g.b.k.a((Object) intent, "intent");
            cJRRechargeUtilities.showSessionTimeoutAlert(aJRCreditCardEnterAmountActivityV4, (String) null, intent.getExtras(), this.f62538b, false, true);
        }
    }

    public final void a(Integer num, String str, String str2) {
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, str, str2);
    }
}
