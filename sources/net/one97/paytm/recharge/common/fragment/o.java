package net.one97.paytm.recharge.common.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.y;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRPaymentOptions;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.widgets.CJRAutomaticCLPStripView;
import net.one97.paytm.recharge.automatic.widgets.CJRRBIComplianceView;
import net.one97.paytm.recharge.common.activity.AJRAmountSelectionActivity;
import net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.c.b;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.fragment.a;
import net.one97.paytm.recharge.common.fragment.e;
import net.one97.paytm.recharge.common.h.d;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ak;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.utils.l;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout;
import net.one97.paytm.recharge.common.widget.CustomInputLinearLayout;
import net.one97.paytm.recharge.common.widget.CustomRadioGroup;
import net.one97.paytm.recharge.common.widget.CustomSwitch;
import net.one97.paytm.recharge.common.widget.GroupItemCustomRadioGroup;
import net.one97.paytm.recharge.common.widget.PreventScrollTextView;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.model.CJRBrowsePlansHeader;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccounts;
import net.one97.paytm.recharge.model.CJRRechargeData;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRMyBillData;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.model.v4.ErrorAction;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;
import net.one97.paytm.upi.util.Events;
import org.json.JSONObject;

public class o extends FJRRechargeUtilBaseFragment implements View.OnClickListener, androidx.lifecycle.q, net.one97.paytm.recharge.automatic.f.b, b.C1180b, ag, net.one97.paytm.recharge.common.e.w, a.C1182a, e.a, ak.c, e.a, l.b, ConvenienceFeeInputLayout.b, CustomInputLinearLayout.a, CustomInputLinearLayout.b, CustomRadioGroup.a, GroupItemCustomRadioGroup.b {
    /* access modifiers changed from: private */
    public boolean A;
    private String B;
    /* access modifiers changed from: private */
    public long C;
    private View D;
    private boolean E;
    private boolean F;
    private CustomRadioGroup<CJRRelatedCategory> G;
    private HashMap<Object, Object> H = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean I;
    private String J;
    private boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public ViewGroup M;
    private CustomSwitch N;
    private CJRBrowsePlansDescAttributes O;
    private String P = "";
    private boolean Q;
    private boolean R = true;
    private net.one97.paytm.recharge.common.utils.e S;
    private boolean T;
    private boolean U;
    private boolean V;
    /* access modifiers changed from: private */
    public boolean W;
    private boolean X;
    private boolean Y = true;
    /* access modifiers changed from: private */
    public boolean Z;
    private final View.OnClickListener aa = t.f61364a;
    private View.OnClickListener ab = new e(this);
    private final RadioGroup.OnCheckedChangeListener ac = new b(this);
    private final View.OnClickListener ad = new h(this);
    private HashMap ae;

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.recharge.common.h.g f61339f;

    /* renamed from: g  reason: collision with root package name */
    public CJRItem f61340g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f61341h;

    /* renamed from: i  reason: collision with root package name */
    FJRRechargeUtilityBaseV2.b f61342i;
    protected String j;
    protected Map<String, String> k = new LinkedHashMap();
    public String l = "";
    protected boolean m;
    protected boolean n = true;
    public CJRRechargeCart o;
    protected List<CJRProductsItem> p;
    protected boolean q;
    public CustomInputLinearLayout r;
    public boolean s;
    private net.one97.paytm.recharge.legacy.catalog.fragment.d t;
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public List<? extends Object> v;
    private JSONObject w = new JSONObject();
    private CJRRechargePayment x;
    /* access modifiers changed from: private */
    public CJRCategoryData y;
    /* access modifiers changed from: private */
    public String z = "";

    static final class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final t f61364a = new t();

        t() {
        }

        public final void onClick(View view) {
        }
    }

    public final void a(List<CJRAutomaticSubscriptionItemModel> list) {
    }

    public final void a(CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
    }

    public void a(ErrorAction errorAction) {
        kotlin.g.b.k.c(errorAction, "action");
    }

    public final void ap_() {
    }

    public View b(int i2) {
        if (this.ae == null) {
            this.ae = new HashMap();
        }
        View view = (View) this.ae.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.ae.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void c() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public void u() {
        HashMap hashMap = this.ae;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void w() {
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, kotlin.x> {
        d(o oVar) {
            super(3, oVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return kotlin.x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((o) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class i extends kotlin.g.b.i implements kotlin.g.a.b<Data<? extends CJRCategoryData>, kotlin.x> {
        i(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "updateCategoryData";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "updateCategoryData(Lnet/one97/paytm/recharge/model/v4/Data;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRCategoryData>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRCategoryData> data) {
            ((o) this.receiver).b(data);
        }
    }

    static final /* synthetic */ class j extends kotlin.g.b.i implements kotlin.g.a.b<Data<? extends CJRProductList>, kotlin.x> {
        j(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "updateProductData";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "updateProductData(Lnet/one97/paytm/recharge/model/v4/Data;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRProductList>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRProductList> data) {
            ((o) this.receiver).a(data);
        }
    }

    static final /* synthetic */ class k extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, kotlin.x> {
        k(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((o) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class l extends kotlin.g.b.i implements kotlin.g.a.b<Boolean, kotlin.x> {
        l(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "performLoading";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "performLoading(Ljava/lang/Boolean;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Boolean bool) {
            ((o) this.receiver).a(bool);
        }
    }

    static final /* synthetic */ class m extends kotlin.g.b.i implements kotlin.g.a.b<CJRNextGroupData, kotlin.x> {
        m(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "createUIComponents";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "createUIComponents(Lnet/one97/paytm/recharge/model/v4/CJRNextGroupData;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRNextGroupData) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRNextGroupData cJRNextGroupData) {
            ((o) this.receiver).a(cJRNextGroupData);
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRSetUserConsentApiResponse>, kotlin.x> {
        final /* synthetic */ o this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(o oVar) {
            super(1);
            this.this$0 = oVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRSetUserConsentApiResponse>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRSetUserConsentApiResponse> data) {
            Integer status;
            if (data != null) {
                DataState dataState = data.getDataState();
                if (dataState != null) {
                    int[] iArr = p.f61371a;
                    dataState.ordinal();
                }
                CJRSetUserConsentApiResponse data2 = data.getData();
                if (data2 != null && (status = data2.getStatus()) != null && status.intValue() == 200) {
                    this.this$0.L = true;
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.fragment.o$o  reason: collision with other inner class name */
    static final class C1188o extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRGetUserConsentApiResponse>, kotlin.x> {
        final /* synthetic */ o this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1188o(o oVar) {
            super(1);
            this.this$0 = oVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRGetUserConsentApiResponse>) (Data) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(Data<CJRGetUserConsentApiResponse> data) {
            CJRGetUserConsentApiResponse data2;
            if (data != null && (data2 = data.getData()) != null) {
                o oVar = this.this$0;
                Integer status = data2.getStatus();
                oVar.A = status != null && status.intValue() == 204;
                this.this$0.I = false;
                if (!this.this$0.A && this.this$0.M != null) {
                    ViewGroup d2 = this.this$0.M;
                    if (d2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (d2.getParent() != null) {
                        ViewGroup d3 = this.this$0.M;
                        if (d3 == null) {
                            kotlin.g.b.k.a();
                        }
                        ViewParent parent = d3.getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(this.this$0.M);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    }
                    CustomInputLinearLayout customInputLinearLayout = this.this$0.r;
                    if (customInputLinearLayout != null) {
                        customInputLinearLayout.removeView(this.this$0.M);
                    }
                } else if (this.this$0.A && this.this$0.M != null) {
                    ViewGroup d4 = this.this$0.M;
                    if (d4 == null) {
                        kotlin.g.b.k.a();
                    }
                    d4.getVisibility();
                }
            }
        }
    }

    static final /* synthetic */ class s extends kotlin.g.b.i implements kotlin.g.a.b<Boolean, kotlin.x> {
        s(o oVar) {
            super(1, oVar);
        }

        public final String getName() {
            return "proceedButtonState";
        }

        public final kotlin.k.d getOwner() {
            return y.b(o.class);
        }

        public final String getSignature() {
            return "proceedButtonState(Z)V";
        }

        public final /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return kotlin.x.f47997a;
        }

        public final void invoke(boolean z) {
            ((o) this.receiver).c(z);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("recharge_item") : null;
            if (serializable != null) {
                this.f61340g = (CJRItem) serializable;
                Bundle arguments2 = getArguments();
                boolean z2 = false;
                this.F = arguments2 != null ? arguments2.getBoolean("open_activity_in_automatic_mode") : false;
                Bundle arguments3 = getArguments();
                this.U = arguments3 != null ? arguments3.getBoolean("is_recharge_tabs_flow", false) : false;
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    z2 = arguments4.getBoolean("is_selected_in_tabs", false);
                }
                this.s = z2;
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                this.K = net.one97.paytm.recharge.di.helper.c.T();
                CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
                if (this.f61340g != null) {
                    CJRItem cJRItem = this.f61340g;
                    if (cJRItem == null) {
                        kotlin.g.b.k.a();
                    }
                    if (a(cJRItem) == null) {
                        return;
                    }
                }
                CJRItem cJRItem2 = this.f61340g;
                if (cJRItem2 != null) {
                    net.one97.paytm.recharge.common.h.g a2 = a(cJRItem2);
                    if (a2 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.f61339f = a2;
                    net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                    if (gVar != null) {
                        a((net.one97.paytm.recharge.common.h.b) gVar);
                        this.F = this.F;
                        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
                        if (gVar2 != null) {
                            gVar2.f61411d = this.F;
                        }
                        ai.a(this, gVar.x, new i(this));
                        ai.a(this, gVar.w, new j(this));
                        ai.a(this, gVar.f61408a, new k(this));
                        ai.a(this, gVar.z, new l(this));
                        if (this.f61339f != null) {
                            net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
                            if (gVar3 == null) {
                                kotlin.g.b.k.a();
                            }
                            ai.a(this, gVar3.y, new m(this));
                        }
                        gVar.B = frequentOrderList;
                        net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
                        if (gVar4 != null) {
                            gVar4.N = this.U;
                        }
                    }
                    Bundle arguments5 = getArguments();
                    if (arguments5 != null) {
                        arguments5.getBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST);
                    }
                    k();
                    ay ayVar = ay.f61523a;
                    ay.a(this.f61340g, VERTICAL.UTILITIES);
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel b2 = net.one97.paytm.recharge.widgets.c.d.b();
                    net.one97.paytm.recharge.common.h.g gVar5 = this.f61339f;
                    b2.setScreenName(gVar5 != null ? gVar5.a() : null);
                }
                if (this.f61339f != null) {
                    net.one97.paytm.recharge.common.h.g gVar6 = this.f61339f;
                    if (gVar6 == null) {
                        kotlin.g.b.k.a();
                    }
                    ai.a(this, gVar6.f61415h, new n(this));
                }
                if (this.f61339f != null) {
                    net.one97.paytm.recharge.common.h.g gVar7 = this.f61339f;
                    if (gVar7 == null) {
                        kotlin.g.b.k.a();
                    }
                    ai.a(this, gVar7.f61416i, new C1188o(this));
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
        } catch (NullPointerException e2) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a3.setErrorType(ERROR_TYPE.UI_DISTORT);
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            a3.setErrorMsg(getString(R.string.hawkeye_category_open_issue));
            CRUFlowModel flowName2 = a3.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.CAT_DIGI_CAT.name());
            }
            az azVar = az.f61525a;
            az.a(a3);
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            cJRRechargeUtilities.debugLog(message);
        }
    }

    public void h() {
        String str;
        CJRCategoryData cJRCategoryData;
        try {
            new LinkedHashMap().put("recharge_utilities_service_type", this.l);
            if (!kotlin.m.p.a(this.f61111c, "dth", true)) {
                if (this.F) {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    Context context = getContext();
                    net.one97.paytm.recharge.di.helper.b.a(context, "/" + ai());
                } else if (this.f61339f != null) {
                    net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                    Context context2 = getContext();
                    net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                    if (gVar == null) {
                        kotlin.g.b.k.a();
                    }
                    Data value = gVar.x.getValue();
                    if (value == null || (cJRCategoryData = (CJRCategoryData) value.getData()) == null || (str = cJRCategoryData.getGAEventScreenName()) == null) {
                        str = "";
                    }
                    net.one97.paytm.recharge.di.helper.b.a(context2, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public net.one97.paytm.recharge.common.h.g a(CJRItem cJRItem) {
        kotlin.g.b.k.c(cJRItem, "pRechargeItem");
        if (getActivity() == null) {
            return null;
        }
        Fragment fragment = this;
        d.a a2 = new d.a(d.b.UTILITY).a(cJRItem);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        d.a a3 = a2.a(net.one97.paytm.recharge.common.b.d.b(applicationContext));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        d.a a4 = a3.a(net.one97.paytm.recharge.common.b.d.d(activity)).a((kotlin.k.e<kotlin.x>) new d(this));
        Context context2 = getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context2, "context!!");
        Context applicationContext2 = context2.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext2, "context!!.applicationContext");
        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext2);
        dVar.f64343a = cJRItem;
        androidx.lifecycle.ai a5 = am.a(fragment, (al.b) new net.one97.paytm.recharge.common.h.d(a4.a(dVar))).a(net.one97.paytm.recharge.common.h.g.class);
        kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(th…elFactory)[T::class.java]");
        net.one97.paytm.recharge.common.h.g gVar = (net.one97.paytm.recharge.common.h.g) a5;
        this.f61339f = gVar;
        return gVar;
    }

    public void v() {
        V();
        new Handler().postDelayed(new f(this), 300);
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61349a;

        f(o oVar) {
            this.f61349a = oVar;
        }

        public final void run() {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.CAT_DIGI_CAT.name());
            }
            net.one97.paytm.recharge.common.h.g gVar = this.f61349a.f61339f;
            if (gVar != null) {
                gVar.b("getCategory", a2);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recharge_utility_digital_catalog_layout, (ViewGroup) null, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        v();
        w();
        if (this.F) {
            TextView textView = (TextView) b(R.id.automatic_add_new_bill_title);
            kotlin.g.b.k.a((Object) textView, "automatic_add_new_bill_title");
            textView.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward);
            kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward");
            relativeLayout.setVisibility(8);
            ((CJRAutomaticCLPStripView) b(R.id.automatic_banner_parent)).setVisibility(8);
        }
        ((Button) b(R.id.btn_proceed)).setOnClickListener(this);
        ((RelativeLayout) b(R.id.lyt_fast_forward)).setOnClickListener(this.ab);
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
        kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
        checkBox.setClickable(false);
        LinearLayout linearLayout = (LinearLayout) b(R.id.electricity_layout);
        kotlin.g.b.k.a((Object) linearLayout, "electricity_layout");
        linearLayout.getLayoutTransition().enableTransitionType(4);
        LinearLayout linearLayout2 = (LinearLayout) b(R.id.electricity_layout);
        kotlin.g.b.k.a((Object) linearLayout2, "electricity_layout");
        linearLayout2.getLayoutTransition().setStartDelay(1, 0);
        x();
        ((LinearLayout) b(R.id.electricity_layout)).addView(this.r, ((LinearLayout) b(R.id.electricity_layout)).indexOfChild((TextView) b(R.id.success_rate_alert_message_text_view)) + 1);
    }

    public void x() {
        Context context = getContext();
        if (context != null) {
            kotlin.g.b.k.a((Object) context, "it");
            this.r = new CustomInputLinearLayout(context);
        }
    }

    public void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof FJRRechargeUtilityBaseV2.b) {
            this.f61342i = (FJRRechargeUtilityBaseV2.b) context;
        }
    }

    private void i(String str) {
        FragmentActivity activity;
        kotlin.g.b.k.c(str, "title");
        if ((getActivity() instanceof AJRRechargeUtilityActivity) && (activity = getActivity()) != null) {
            activity.setTitle(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: net.one97.paytm.recharge.model.v4.CJRAggsItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v21, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r3v20, types: [net.one97.paytm.recharge.model.v4.CJRAggsItem] */
    /* JADX WARNING: type inference failed for: r3v22, types: [net.one97.paytm.recharge.model.v4.CJRAggsItem] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            int r13 = net.one97.paytm.recharge.R.id.fake_view
            android.view.View r13 = r11.b((int) r13)
            android.widget.EditText r13 = (android.widget.EditText) r13
            r13.requestFocus()
            kotlin.g.b.x$a r13 = new kotlin.g.b.x$a
            r13.<init>()
            r0 = 0
            r1 = 1
            if (r14 == 0) goto L_0x02cd
            r2 = 602(0x25a, float:8.44E-43)
            r3 = 0
            if (r12 != r2) goto L_0x00aa
            java.lang.String r2 = "intent_extra_item_index"
            boolean r4 = r14.hasExtra(r2)
            if (r4 == 0) goto L_0x00a6
            int r8 = r14.getIntExtra(r2, r0)
            r2 = -1
            if (r8 == r2) goto L_0x00a2
            java.lang.String r4 = "intent_extra_child_index"
            r14.getIntExtra(r4, r2)
            java.lang.String r2 = "operator_variant"
            boolean r4 = r14.hasExtra(r2)
            if (r4 == 0) goto L_0x0047
            java.io.Serializable r14 = r14.getSerializableExtra(r2)
            if (r14 == 0) goto L_0x003f
            r3 = r14
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            goto L_0x0056
        L_0x003f:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRAggsItem"
            r12.<init>(r13)
            throw r12
        L_0x0047:
            net.one97.paytm.recharge.common.utils.y r14 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r14 = net.one97.paytm.recharge.common.utils.y.c()
            if (r14 == 0) goto L_0x0056
            java.lang.Object r14 = r14.get(r8)
            r3 = r14
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
        L_0x0056:
            r9 = r3
            java.util.List<? extends java.lang.Object> r14 = r11.v
            if (r14 == 0) goto L_0x00a2
            java.lang.Object r2 = r14.get(r0)
            boolean r2 = r2 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r14.get(r1)
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r14.get(r0)
            if (r2 == 0) goto L_0x009a
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r6 = r2.intValue()
            java.lang.Object r14 = r14.get(r1)
            if (r14 == 0) goto L_0x0092
            r7 = r14
            java.lang.String r7 = (java.lang.String) r7
            net.one97.paytm.recharge.common.h.g r14 = r11.f61339f
            if (r14 == 0) goto L_0x0086
            r14.I = r0
        L_0x0086:
            net.one97.paytm.recharge.common.h.g r5 = r11.f61339f
            if (r5 == 0) goto L_0x00a2
            java.lang.String r10 = r11.ag()
            r5.a((int) r6, (java.lang.String) r7, (int) r8, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r9, (java.lang.String) r10)
            goto L_0x00a2
        L_0x0092:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.String"
            r12.<init>(r13)
            throw r12
        L_0x009a:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.Int"
            r12.<init>(r13)
            throw r12
        L_0x00a2:
            r13.element = r1
            goto L_0x02cd
        L_0x00a6:
            r13.element = r0
            goto L_0x02cd
        L_0x00aa:
            r2 = 607(0x25f, float:8.5E-43)
            if (r12 != r2) goto L_0x012f
            java.lang.String r2 = "extra_config_key"
            java.lang.String r2 = r14.getStringExtra(r2)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x00bd
            android.view.View r2 = r4.a((java.lang.String) r2)
            goto L_0x00be
        L_0x00bd:
            r2 = r3
        L_0x00be:
            boolean r4 = r2 instanceof android.widget.TextView
            if (r4 != 0) goto L_0x00c3
            r2 = r3
        L_0x00c3:
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r4 = "extra_agg_item"
            boolean r5 = r14.hasExtra(r4)
            if (r5 == 0) goto L_0x0126
            java.io.Serializable r14 = r14.getSerializableExtra(r4)
            boolean r4 = r14 instanceof net.one97.paytm.recharge.model.v4.CJRAggsItem
            if (r4 != 0) goto L_0x00d6
            r14 = r3
        L_0x00d6:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r14 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r14
            if (r14 == 0) goto L_0x00df
            java.lang.String r4 = r14.getTempDisplayValue()
            goto L_0x00e0
        L_0x00df:
            r4 = r3
        L_0x00e0:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00ed
            boolean r4 = kotlin.m.p.a(r4)
            if (r4 == 0) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r4 = 0
            goto L_0x00ee
        L_0x00ed:
            r4 = 1
        L_0x00ee:
            if (r4 != 0) goto L_0x0113
            if (r2 == 0) goto L_0x00ff
            if (r14 == 0) goto L_0x00f9
            java.lang.String r4 = r14.getTempDisplayValue()
            goto L_0x00fa
        L_0x00f9:
            r4 = r3
        L_0x00fa:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x00ff:
            if (r2 == 0) goto L_0x0120
            r4 = r2
            android.view.View r4 = (android.view.View) r4
            if (r14 == 0) goto L_0x010a
            java.lang.String r3 = r14.getTempFileterValue()
        L_0x010a:
            if (r3 != 0) goto L_0x010f
            kotlin.g.b.k.a()
        L_0x010f:
            net.one97.paytm.recharge.common.utils.ai.a((android.view.View) r4, (java.lang.String) r3)
            goto L_0x0120
        L_0x0113:
            if (r2 == 0) goto L_0x0120
            if (r14 == 0) goto L_0x011b
            java.lang.String r3 = r14.getDisplayValue()
        L_0x011b:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0120:
            if (r2 == 0) goto L_0x012b
            r2.setEnabled(r1)
            goto L_0x012b
        L_0x0126:
            if (r2 == 0) goto L_0x012b
            r2.setEnabled(r1)
        L_0x012b:
            r13.element = r1
            goto L_0x02cd
        L_0x012f:
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$a r2 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.f61976h
            int r2 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.k
            if (r12 != r2) goto L_0x014d
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r11.r
            if (r2 == 0) goto L_0x0146
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r2 = r2.getConvenienceFeeLayout()
            if (r2 == 0) goto L_0x0146
            if (r14 == 0) goto L_0x0146
            r2.setDataOnPaymentModeSelection(r14)
        L_0x0146:
            r11.t()
            r13.element = r1
            goto L_0x02cd
        L_0x014d:
            r2 = 605(0x25d, float:8.48E-43)
            if (r12 != r2) goto L_0x01f0
            java.lang.String r2 = "intent_extra_selected_amount"
            java.io.Serializable r14 = r14.getSerializableExtra(r2)
            if (r14 == 0) goto L_0x01e8
            net.one97.paytm.common.entity.shopping.CJRPaymentOptions r14 = (net.one97.paytm.common.entity.shopping.CJRPaymentOptions) r14
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r11.r
            if (r2 == 0) goto L_0x01e1
            if (r14 == 0) goto L_0x01e1
            android.view.View r4 = r2.f62015g
            if (r4 == 0) goto L_0x01e1
            r2.f62016h = r14
            int r5 = net.one97.paytm.recharge.R.id.multiple_months_amount_lyt
            android.view.View r4 = r4.findViewById(r5)
            if (r4 == 0) goto L_0x01d9
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            int r5 = net.one97.paytm.recharge.R.id.months_label
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "null cannot be cast to non-null type android.widget.TextView"
            if (r5 == 0) goto L_0x01d3
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r7 = net.one97.paytm.recharge.R.id.months_value_text
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L_0x01cd
            android.widget.TextView r7 = (android.widget.TextView) r7
            android.content.Context r6 = r2.getContext()
            int r8 = net.one97.paytm.recharge.R.string.months
            java.lang.String r6 = r6.getString(r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r2.f62011c
            if (r6 == 0) goto L_0x019e
            java.lang.String r3 = r6.getCategoryId()
        L_0x019e:
            java.lang.String r6 = "123988"
            boolean r3 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r1)
            if (r3 == 0) goto L_0x01aa
            r3 = 4
            r5.setVisibility(r3)
        L_0x01aa:
            java.lang.String r3 = r14.getLabel()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r7.setText(r3)
            r4.setVisibility(r0)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4.setTag(r3)
            android.widget.EditText r2 = r2.f62012d
            if (r2 == 0) goto L_0x01e1
            java.lang.String r14 = r14.getAmount()
            java.lang.String r14 = net.one97.paytm.recharge.common.utils.z.c(r14)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r2.setText(r14)
            goto L_0x01e1
        L_0x01cd:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r6)
            throw r12
        L_0x01d3:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r6)
            throw r12
        L_0x01d9:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type android.widget.LinearLayout"
            r12.<init>(r13)
            throw r12
        L_0x01e1:
            r11.t()
            r13.element = r1
            goto L_0x02cd
        L_0x01e8:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRPaymentOptions"
            r12.<init>(r13)
            throw r12
        L_0x01f0:
            r2 = 2
            if (r12 != r2) goto L_0x02cb
            java.lang.String r2 = "amount"
            java.lang.String r2 = r14.getStringExtra(r2)
            java.lang.String r4 = "operator"
            r14.getStringExtra(r4)
            java.lang.String r4 = "circle"
            r14.getStringExtra(r4)
            java.lang.String r4 = "title"
            r14.getStringExtra(r4)
            java.lang.String r4 = "plan_desc"
            boolean r5 = r14.hasExtra(r4)
            if (r5 == 0) goto L_0x021e
            java.io.Serializable r4 = r14.getSerializableExtra(r4)
            boolean r5 = r4 instanceof net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes
            if (r5 != 0) goto L_0x0219
            goto L_0x021a
        L_0x0219:
            r3 = r4
        L_0x021a:
            net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes r3 = (net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes) r3
            r11.O = r3
        L_0x021e:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r11.r
            if (r3 == 0) goto L_0x026e
            java.lang.String r4 = "is_otc"
            boolean r4 = r14.getBooleanExtra(r4, r0)
            r3.setOtc(r4)
            java.lang.String r4 = "plan_guid"
            java.lang.String r4 = r14.getStringExtra(r4)
            r3.setPlanGuiId(r4)
            java.lang.String r4 = "plan_name"
            java.lang.String r4 = r14.getStringExtra(r4)
            r3.setCurrentPlanName(r4)
            java.lang.String r4 = r3.getPreviousPlanName()
            if (r4 == 0) goto L_0x025f
            java.lang.String r4 = r3.getCurrentPlanName()
            if (r4 == 0) goto L_0x025f
            java.lang.String r4 = r3.getPreviousPlanName()
            java.lang.String r5 = r3.getCurrentPlanName()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r1)
            if (r4 == 0) goto L_0x025b
            r3.setPlanChangeFlag(r0)
            goto L_0x0262
        L_0x025b:
            r3.setPlanChangeFlag(r1)
            goto L_0x0262
        L_0x025f:
            r3.setPlanChangeFlag(r1)
        L_0x0262:
            java.lang.String r4 = r3.getCurrentPlanName()
            r3.setPreviousPlanName(r4)
            boolean r4 = r3.f62017i
            r3.setOtcBit(r4)
        L_0x026e:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r11.r
            if (r3 == 0) goto L_0x02cd
            if (r2 == 0) goto L_0x02cd
            android.widget.EditText r4 = r3.getMBillAmountEdt()
            if (r4 == 0) goto L_0x02cd
            java.lang.Boolean r4 = com.paytm.utility.b.K((java.lang.String) r2)
            if (r4 != 0) goto L_0x0283
            kotlin.g.b.k.a()
        L_0x0283:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x029e
            if (r2 != 0) goto L_0x028e
            kotlin.g.b.k.a()
        L_0x028e:
            double r4 = java.lang.Double.parseDouble(r2)
            double r4 = com.paytm.utility.b.b((double) r4)
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r3.setAmountFromBrowsePlan(r2)
            goto L_0x02a1
        L_0x029e:
            r3.setAmountFromBrowsePlan(r2)
        L_0x02a1:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r11.r
            if (r2 == 0) goto L_0x02a8
            r2.setBrowsePlanSelected(r1)
        L_0x02a8:
            boolean r2 = r3.j
            if (r2 == 0) goto L_0x02cd
            java.lang.String r2 = "meta_description"
            java.io.Serializable r14 = r14.getSerializableExtra(r2)     // Catch:{ Exception -> 0x02c2 }
            if (r14 == 0) goto L_0x02ba
            java.util.HashMap r14 = (java.util.HashMap) r14     // Catch:{ Exception -> 0x02c2 }
            r3.setHashMapDynamicOperatorData(r14)     // Catch:{ Exception -> 0x02c2 }
            goto L_0x02cd
        L_0x02ba:
            kotlin.u r14 = new kotlin.u     // Catch:{ Exception -> 0x02c2 }
            java.lang.String r2 = "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>"
            r14.<init>(r2)     // Catch:{ Exception -> 0x02c2 }
            throw r14     // Catch:{ Exception -> 0x02c2 }
        L_0x02c2:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.paytm.utility.q.d(r14)
            goto L_0x02cd
        L_0x02cb:
            r13.element = r0
        L_0x02cd:
            r14 = 3
            if (r12 == r14) goto L_0x02d4
            r14 = 7
            if (r12 == r14) goto L_0x02d4
            goto L_0x02f8
        L_0x02d4:
            r11.t()
            androidx.fragment.app.FragmentActivity r14 = r11.getActivity()
            android.content.Context r14 = (android.content.Context) r14
            boolean r14 = net.one97.paytm.recharge.common.utils.z.a((android.content.Context) r14)
            if (r14 == 0) goto L_0x02f3
            int r12 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r12 = r11.b((int) r12)
            android.widget.Button r12 = (android.widget.Button) r12
            if (r12 == 0) goto L_0x02f0
            r12.performClick()
        L_0x02f0:
            r13.element = r1
            goto L_0x02fa
        L_0x02f3:
            net.one97.paytm.recharge.common.utils.ay r14 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((int) r12)
        L_0x02f8:
            r13.element = r0
        L_0x02fa:
            boolean r12 = r13.element
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(int, int, android.content.Intent):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v9, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.recharge.model.v4.CJRInstruct r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.checkAndHandlePreFillForm
            if (r2 != 0) goto L_0x0556
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.setIsBillConsentSetSuccessfully
            if (r2 == 0) goto L_0x0015
            net.one97.paytm.recharge.model.v4.CJRInstruct$setIsBillConsentSetSuccessfully r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.setIsBillConsentSetSuccessfully) r1
            boolean r1 = r1.isBillConsentSetSuccessfully()
            r0.L = r1
            return
        L_0x0015:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.startLocationActivity
            r3 = 602(0x25a, float:8.44E-43)
            r4 = 603979776(0x24000000, float:2.7755576E-17)
            java.lang.String r5 = "categories"
            java.lang.String r6 = "category_name"
            java.lang.String r7 = "list_type"
            java.lang.String r8 = ""
            if (r2 == 0) goto L_0x009d
            net.one97.paytm.recharge.model.v4.CJRInstruct$startLocationActivity r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.startLocationActivity) r1
            java.lang.String r2 = r1.getTitle()
            java.lang.String r9 = r1.getListType()
            java.lang.String r10 = r1.getSearchHintView()
            java.lang.String r1 = r1.getGroupName()
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r11 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "startLocationActivity: [title-"
            r12.<init>(r13)
            if (r2 != 0) goto L_0x0044
            r13 = r8
            goto L_0x0045
        L_0x0044:
            r13 = r2
        L_0x0045:
            r12.append(r13)
            java.lang.String r13 = "] [listType-"
            r12.append(r13)
            if (r9 != 0) goto L_0x0051
            r13 = r8
            goto L_0x0052
        L_0x0051:
            r13 = r9
        L_0x0052:
            r12.append(r13)
            java.lang.String r13 = "] [searchHintView-"
            r12.append(r13)
            if (r10 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r8 = r10
        L_0x005e:
            r12.append(r8)
            r8 = 93
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            r11.debugLog(r8)
            android.content.Intent r8 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r11 = r19.getActivity()
            android.content.Context r11 = (android.content.Context) r11
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRUtilitySearchActivityV4> r12 = net.one97.paytm.recharge.common.activity.AJRUtilitySearchActivityV4.class
            r8.<init>(r11, r12)
            java.lang.String r11 = "location_title"
            r8.putExtra(r11, r2)
            java.lang.String r2 = "location_search_hint"
            r8.putExtra(r2, r10)
            r8.putExtra(r7, r9)
            java.lang.String r2 = "group_fields"
            r8.putExtra(r2, r1)
            java.lang.String r1 = r0.f61111c
            r8.putExtra(r6, r1)
            java.lang.String r1 = r0.z
            r8.putExtra(r5, r1)
            r8.setFlags(r4)
            r0.startActivityForResult(r8, r3)
            return
        L_0x009d:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.startOperatorListActivity
            r9 = 0
            if (r2 == 0) goto L_0x00f5
            net.one97.paytm.recharge.model.v4.CJRInstruct$startOperatorListActivity r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.startOperatorListActivity) r1
            java.lang.String r2 = r1.getTitle()
            java.lang.String r1 = r1.getListType()
            net.one97.paytm.recharge.common.h.g r8 = r0.f61339f
            if (r8 == 0) goto L_0x00b2
            java.lang.String r9 = r8.A
        L_0x00b2:
            android.content.Intent r8 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r10 = r19.getActivity()
            android.content.Context r10 = (android.content.Context) r10
            boolean r11 = r0.F
            java.lang.Class r11 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r1, (boolean) r11, (java.lang.String) r9)
            r8.<init>(r10, r11)
            java.lang.String r10 = "title"
            r8.putExtra(r10, r2)
            r8.putExtra(r7, r1)
            boolean r1 = r0.F
            java.lang.String r2 = "open_activity_in_automatic_mode"
            r8.putExtra(r2, r1)
            java.lang.String r1 = r0.f61111c
            r8.putExtra(r6, r1)
            java.lang.String r1 = r0.z
            r8.putExtra(r5, r1)
            java.lang.String r1 = "category id"
            r8.putExtra(r1, r9)
            net.one97.paytm.recharge.automatic.b.a.a$a r1 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.a.f60240b
            java.lang.String r2 = r19.ai()
            r8.putExtra(r1, r2)
            r8.setFlags(r4)
            r0.startActivityForResult(r8, r3)
            return
        L_0x00f5:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.removeBbpsLogo
            if (r2 == 0) goto L_0x00fd
            r0.a((java.lang.String) r9)
            return
        L_0x00fd:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.addBBPSLogo
            if (r2 == 0) goto L_0x010b
            net.one97.paytm.recharge.model.v4.CJRInstruct$addBBPSLogo r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.addBBPSLogo) r1
            java.lang.String r1 = r1.getBbpsLogoUrl()
            r0.a((java.lang.String) r1)
            return
        L_0x010b:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.getLocalLocation
            r3 = 1
            if (r2 == 0) goto L_0x0189
            net.one97.paytm.recharge.model.v4.CJRInstruct$getLocalLocation r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.getLocalLocation) r1
            int r2 = r1.getGroupLevel()
            java.lang.String r1 = r1.getGroupName()
            android.content.Context r4 = r19.getContext()
            java.lang.String r4 = com.paytm.utility.b.s((android.content.Context) r4)
            android.content.Context r5 = r19.getContext()
            java.lang.String r5 = com.paytm.utility.b.t((android.content.Context) r5)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0172
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0172
            net.one97.paytm.recharge.common.utils.l r6 = new net.one97.paytm.recharge.common.utils.l
            android.content.Context r7 = r19.getContext()
            androidx.fragment.app.FragmentActivity r8 = r19.getActivity()
            android.app.Activity r8 = (android.app.Activity) r8
            r10 = r0
            net.one97.paytm.recharge.common.utils.l$b r10 = (net.one97.paytm.recharge.common.utils.l.b) r10
            r6.<init>(r7, r8, r9, r10)
            double r7 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x015a }
            double r4 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x015a }
            r6.a((double) r7, (double) r4)     // Catch:{ Exception -> 0x015a }
            return
        L_0x015a:
            net.one97.paytm.recharge.common.h.g r4 = r0.f61339f
            if (r4 == 0) goto L_0x0171
            boolean r4 = r4.a(r2, r1)
            if (r4 != r3) goto L_0x0171
            r0.a((int) r2, (java.lang.String) r1)
            net.one97.paytm.recharge.common.h.g r3 = r0.f61339f
            if (r3 == 0) goto L_0x0171
            java.lang.String r4 = r0.l
            r3.a((int) r2, (java.lang.String) r1, (java.lang.String) r4)
        L_0x0171:
            return
        L_0x0172:
            net.one97.paytm.recharge.common.h.g r4 = r0.f61339f
            if (r4 == 0) goto L_0x0188
            boolean r4 = r4.a(r2, r1)
            if (r4 != r3) goto L_0x0188
            r0.a((int) r2, (java.lang.String) r1)
            net.one97.paytm.recharge.common.h.g r3 = r0.f61339f
            if (r3 == 0) goto L_0x0188
            java.lang.String r4 = r0.l
            r3.a((int) r2, (java.lang.String) r1, (java.lang.String) r4)
        L_0x0188:
            return
        L_0x0189:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.setText
            r4 = 0
            if (r2 == 0) goto L_0x01c6
            net.one97.paytm.recharge.model.v4.CJRInstruct$setText r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.setText) r1
            int r2 = r1.getGroupLevel()
            java.lang.String r5 = r1.getGroupName()
            java.lang.String r1 = r1.getText()
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6[r4] = r2
            r6[r3] = r5
            java.util.List r2 = kotlin.a.k.c(r6)
            android.view.View r2 = r0.b((java.util.List<? extends java.lang.Object>) r2)
            boolean r3 = r2 instanceof net.one97.paytm.recharge.common.widget.CustomDropDownLayout
            if (r3 == 0) goto L_0x01be
            int r3 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r2 = r2.findViewById(r3)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
        L_0x01be:
            if (r9 == 0) goto L_0x01c5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r9.setText(r1)
        L_0x01c5:
            return
        L_0x01c6:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.removeExtraFilteredGroup
            if (r2 == 0) goto L_0x01d8
            net.one97.paytm.recharge.model.v4.CJRInstruct$removeExtraFilteredGroup r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.removeExtraFilteredGroup) r1
            java.lang.String r2 = r1.getGroupName()
            int r1 = r1.getGroupLevel()
            r0.a((java.lang.String) r2, (int) r1)
            return
        L_0x01d8:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.removeAllInputFields
            if (r2 == 0) goto L_0x01e0
            r19.Y()
            return
        L_0x01e0:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.clearProduct
            if (r2 == 0) goto L_0x01e8
            r19.aa()
            return
        L_0x01e8:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.resetUI
            if (r2 == 0) goto L_0x01f0
            r19.X()
            return
        L_0x01f0:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateSelectedItem
            if (r2 == 0) goto L_0x0202
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateSelectedItem r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.updateSelectedItem) r1
            int r2 = r1.getGroupLevel()
            java.lang.String r1 = r1.getGroupName()
            r0.a((int) r2, (java.lang.String) r1)
            return
        L_0x0202:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields
            if (r2 == 0) goto L_0x035c
            r19.t()
            r19.j()
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x028e
            int r2 = r2.getOtcBit()
            if (r2 != r3) goto L_0x028e
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x028e
            boolean r2 = r2.f62017i
            if (r2 != r3) goto L_0x028e
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r1 = net.one97.paytm.recharge.di.helper.c.bz()
            r5 = 0
            if (r1 == 0) goto L_0x0256
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x034f
            boolean r1 = r1.getPlanChangeFlag()
            if (r1 != r3) goto L_0x034f
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r0.o
            double r1 = a((net.one97.paytm.common.entity.CJRRechargeCart) r1)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x034f
            java.lang.String r3 = r19.U()
            double r5 = java.lang.Double.parseDouble(r3)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r0.r
            if (r3 == 0) goto L_0x024b
            r3.setOtcBit(r4)
        L_0x024b:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r0.r
            if (r3 == 0) goto L_0x0252
            r3.setPlanChangeFlag(r4)
        L_0x0252:
            r0.a((double) r1, (double) r5)
            return
        L_0x0256:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x025d
            r1.setOtcBit(r4)
        L_0x025d:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x0289
            boolean r1 = r1.getPlanChangeFlag()
            if (r1 != r3) goto L_0x0289
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x026e
            r1.setPlanChangeFlag(r4)
        L_0x026e:
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r0.o
            double r1 = a((net.one97.paytm.common.entity.CJRRechargeCart) r1)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0284
            java.lang.String r3 = r19.U()
            double r3 = java.lang.Double.parseDouble(r3)
            r0.a((double) r1, (double) r3)
            return
        L_0x0284:
            r19.ao_()
            goto L_0x034f
        L_0x0289:
            r19.ao_()
            goto L_0x034f
        L_0x028e:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x0338
            boolean r2 = r2.i()
            if (r2 != 0) goto L_0x0338
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x02ad
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields) r1
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r1.getCjrRechargeCart()
            net.one97.paytm.recharge.common.fragment.o$s r3 = new net.one97.paytm.recharge.common.fragment.o$s
            r5 = r0
            net.one97.paytm.recharge.common.fragment.o r5 = (net.one97.paytm.recharge.common.fragment.o) r5
            r3.<init>(r5)
            r2.a((net.one97.paytm.common.entity.CJRRechargeCart) r1, (kotlin.k.e<kotlin.x>) r3)
        L_0x02ad:
            boolean r1 = r0.A
            if (r1 == 0) goto L_0x0334
            android.content.Context r1 = r19.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = net.one97.paytm.recharge.R.layout.layout_bill_consent_toggle_view
            android.view.View r1 = r1.inflate(r2, r9, r4)
            if (r1 == 0) goto L_0x032c
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r0.M = r1
            android.view.ViewGroup r1 = r0.M
            if (r1 == 0) goto L_0x02e9
            int r2 = net.one97.paytm.recharge.R.id.bill_reminder_switcher
            android.view.View r2 = r1.findViewById(r2)
            net.one97.paytm.recharge.common.widget.CustomSwitch r2 = (net.one97.paytm.recharge.common.widget.CustomSwitch) r2
            r0.N = r2
            int r2 = net.one97.paytm.recharge.R.id.txt_bill_reminder
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            net.one97.paytm.recharge.common.widget.CustomSwitch r2 = r0.N
            if (r2 == 0) goto L_0x02e9
            net.one97.paytm.recharge.common.fragment.o$c r3 = new net.one97.paytm.recharge.common.fragment.o$c
            r3.<init>(r1, r0)
            android.widget.CompoundButton$OnCheckedChangeListener r3 = (android.widget.CompoundButton.OnCheckedChangeListener) r3
            r2.setOnCheckedChangeListener(r3)
        L_0x02e9:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x02f4
            android.view.ViewGroup r2 = r0.M
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
        L_0x02f4:
            android.view.ViewGroup r1 = r0.M
            if (r1 == 0) goto L_0x02fc
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
        L_0x02fc:
            if (r9 == 0) goto L_0x0324
            android.widget.LinearLayout$LayoutParams r9 = (android.widget.LinearLayout.LayoutParams) r9
            r1 = 23
            int r1 = com.paytm.utility.b.c((int) r1)
            r2 = 10
            int r2 = com.paytm.utility.b.c((int) r2)
            r3 = 5
            int r3 = com.paytm.utility.b.c((int) r3)
            r5 = 20
            int r5 = com.paytm.utility.b.c((int) r5)
            r9.setMargins(r1, r2, r3, r5)
            android.view.ViewGroup r1 = r0.M
            if (r1 == 0) goto L_0x0334
            android.view.ViewGroup$LayoutParams r9 = (android.view.ViewGroup.LayoutParams) r9
            r1.setLayoutParams(r9)
            goto L_0x0334
        L_0x0324:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            r1.<init>(r2)
            throw r1
        L_0x032c:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.view.ViewGroup"
            r1.<init>(r2)
            throw r1
        L_0x0334:
            r19.F()
            goto L_0x034f
        L_0x0338:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x034c
            boolean r2 = r2.f62013e
            if (r2 != r3) goto L_0x034c
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields) r1
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r1.getCjrRechargeCart()
            boolean r1 = r0.b((net.one97.paytm.common.entity.CJRRechargeCart) r1)
            if (r1 != 0) goto L_0x034f
        L_0x034c:
            r0.e((boolean) r3)
        L_0x034f:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0355
            r1.D = r4
        L_0x0355:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x035b
            r1.E = r4
        L_0x035b:
            return
        L_0x035c:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openAutomaticAddNewBill
            if (r2 == 0) goto L_0x03b3
            net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openAutomaticAddNewBill) r1
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r1.getCjrRechargeCart()
            r19.t()
            r19.j()
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x038a
            net.one97.paytm.recharge.ordersummary.h.d r10 = r1.v
            if (r10 == 0) goto L_0x038a
            java.lang.String r11 = r19.ai()
            net.one97.paytm.recharge.automatic.b.a.a$a r1 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r12 = net.one97.paytm.recharge.automatic.b.a.a.m
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 124(0x7c, float:1.74E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x038a:
            android.content.Context r3 = r19.getContext()
            androidx.fragment.app.j r4 = r19.getChildFragmentManager()
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x039c
            java.lang.String r1 = r1.getRechargeNumberFromKeyList()
            r5 = r1
            goto L_0x039d
        L_0x039c:
            r5 = r9
        L_0x039d:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x03a5
            java.lang.String r9 = r1.getRechargeNumberKey()
        L_0x03a5:
            r6 = r9
            net.one97.paytm.recharge.common.fragment.o$r r1 = new net.one97.paytm.recharge.common.fragment.o$r
            r1.<init>(r0, r2)
            r7 = r1
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r8 = 0
            net.one97.paytm.recharge.common.utils.z.a(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x03b3:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart
            if (r2 == 0) goto L_0x03c0
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart) r1
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r1.getRechargeCart()
            r0.o = r1
            return
        L_0x03c0:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargePayment
            if (r2 == 0) goto L_0x03cd
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargePayment r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargePayment) r1
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r1.getRechargePayment()
            r0.x = r1
            return
        L_0x03cd:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.onRecentClickCheckRcChange
            if (r2 == 0) goto L_0x04e1
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r1.setErrorType(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x03eb
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r5 = r5.name()
            r2.setErrorType(r5)
        L_0x03eb:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x03fa
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.RECENT_CLICK
            java.lang.String r5 = r5.name()
            r2.setActionType(r5)
        L_0x03fa:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r0.y
            if (r2 == 0) goto L_0x0403
            java.util.List r2 = r2.getRelatedCategories()
            goto L_0x0404
        L_0x0403:
            r2 = r9
        L_0x0404:
            java.lang.String r5 = "getCategory"
            if (r2 == 0) goto L_0x04d9
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r0.y
            if (r2 == 0) goto L_0x041a
            java.util.List r2 = r2.getRelatedCategories()
            if (r2 == 0) goto L_0x041a
            boolean r2 = r2.isEmpty()
            if (r2 != r3) goto L_0x041a
            goto L_0x04d9
        L_0x041a:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r0.y
            if (r2 == 0) goto L_0x0431
            java.util.List r2 = r2.getRelatedCategories()
            if (r2 == 0) goto L_0x0431
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r2 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r2
            if (r2 == 0) goto L_0x0431
            java.lang.String r2 = r2.getType()
            goto L_0x0432
        L_0x0431:
            r2 = r9
        L_0x0432:
            java.lang.String r6 = "DROP_DOWN"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r4)
            if (r2 == 0) goto L_0x0442
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 == 0) goto L_0x0441
            r2.b(r5, r1)
        L_0x0441:
            return
        L_0x0442:
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 == 0) goto L_0x0556
            java.lang.String r2 = r0.z
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0483
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 != 0) goto L_0x0457
            kotlin.g.b.k.a()
        L_0x0457:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r2.m
            java.lang.String r4 = "service"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0483
            java.lang.String r2 = r0.z
            net.one97.paytm.recharge.common.h.g r6 = r0.f61339f
            if (r6 != 0) goto L_0x046a
            kotlin.g.b.k.a()
        L_0x046a:
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r6.m
            java.lang.Object r4 = r6.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 == 0) goto L_0x0483
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 != 0) goto L_0x047f
            kotlin.g.b.k.a()
        L_0x047f:
            r2.b(r5, r1)
            return
        L_0x0483:
            net.one97.paytm.recharge.common.widget.CustomRadioGroup<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r2 = r0.G
            if (r2 == 0) goto L_0x0496
            net.one97.paytm.recharge.common.h.g r4 = r0.f61339f
            if (r4 != 0) goto L_0x048e
            kotlin.g.b.k.a()
        L_0x048e:
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r9 = r2.b(r4)
        L_0x0496:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04bd
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 != 0) goto L_0x04a6
            kotlin.g.b.k.a()
        L_0x04a6:
            if (r9 != 0) goto L_0x04ab
            kotlin.g.b.k.a()
        L_0x04ab:
            java.lang.String r3 = "<set-?>"
            kotlin.g.b.k.c(r9, r3)
            r2.A = r9
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 != 0) goto L_0x04b9
            kotlin.g.b.k.a()
        L_0x04b9:
            r2.b(r5, r1)
            return
        L_0x04bd:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 != 0) goto L_0x04c4
            kotlin.g.b.k.a()
        L_0x04c4:
            r1.H = r3
            net.one97.paytm.recharge.common.widget.CustomRadioGroup<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r1 = r0.G
            if (r1 == 0) goto L_0x04d8
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 != 0) goto L_0x04d1
            kotlin.g.b.k.a()
        L_0x04d1:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r2.m
            java.util.Map r2 = (java.util.Map) r2
            r1.a(r2)
        L_0x04d8:
            return
        L_0x04d9:
            net.one97.paytm.recharge.common.h.g r2 = r0.f61339f
            if (r2 == 0) goto L_0x04e0
            r2.b(r5, r1)
        L_0x04e0:
            return
        L_0x04e1:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.resetRadioButton
            if (r2 == 0) goto L_0x04f5
            int r1 = net.one97.paytm.recharge.R.id.select_opertor_layout
            android.view.View r1 = r0.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            net.one97.paytm.recharge.common.widget.CustomRadioGroup<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r2 = r0.G
            android.view.View r2 = (android.view.View) r2
            r1.removeView(r2)
            return
        L_0x04f5:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog
            if (r2 == 0) goto L_0x0509
            boolean r2 = r0.U
            if (r2 == 0) goto L_0x0505
            boolean r2 = r0.s
            if (r2 != 0) goto L_0x0505
            r19.t()
            return
        L_0x0505:
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r20)
            return
        L_0x0509:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showMyBill
            if (r2 == 0) goto L_0x051b
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x051a
            net.one97.paytm.recharge.model.v4.CJRInstruct$showMyBill r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showMyBill) r1
            net.one97.paytm.recharge.model.v4.CJRMyBillData r1 = r1.getMyBillData()
            r2.a((net.one97.paytm.recharge.model.v4.CJRMyBillData) r1)
        L_0x051a:
            return
        L_0x051b:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError
            if (r2 == 0) goto L_0x0553
            androidx.fragment.app.FragmentActivity r2 = r19.getActivity()
            if (r2 == 0) goto L_0x0552
            boolean r2 = r19.isAdded()
            if (r2 != 0) goto L_0x052c
            goto L_0x0552
        L_0x052c:
            r19.l()
            net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError) r1
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L_0x0538
            r1 = r8
        L_0x0538:
            r0.c((java.lang.String) r1)
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0541
            r1.D = r4
        L_0x0541:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0547
            r1.E = r4
        L_0x0547:
            boolean r1 = r0.U
            if (r1 == 0) goto L_0x0556
            boolean r1 = r0.s
            if (r1 != 0) goto L_0x0556
            r19.t()
        L_0x0552:
            return
        L_0x0553:
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r20)
        L_0x0556:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    private final void a(double d2, double d3) {
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout != null) {
            customInputLinearLayout.setAmountOnAmountField(String.valueOf(d2));
        }
        a.a(d2, d3).show(getChildFragmentManager(), "fragment_edit_name");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r1 = (r1 = (r1 = r4.getCart()).getCartItems()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double a(net.one97.paytm.common.entity.CJRRechargeCart r4) {
        /*
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x006f }
            r0 = 0
            if (r4 == 0) goto L_0x001e
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r4.getCart()     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x001e
            java.util.ArrayList r1 = r1.getCartItems()     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r1 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r1     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x001e
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r1 = r1.getServiceOptions()     // Catch:{ Exception -> 0x006f }
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            net.one97.paytm.common.entity.shopping.CJRServiceActions r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.common.entity.shopping.CJRServiceOptions) r1)     // Catch:{ Exception -> 0x006f }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r1.getBillAmount()     // Catch:{ Exception -> 0x006f }
            if (r1 != 0) goto L_0x002e
        L_0x002d:
            r1 = r2
        L_0x002e:
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x006f }
            boolean r3 = net.one97.paytm.recharge.di.helper.c.bz()     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x006a
            if (r4 == 0) goto L_0x0069
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            java.util.ArrayList r4 = r4.getCartItems()     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r4 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r4     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r4 = r4.getServiceOptions()     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            java.util.ArrayList r4 = r4.getActions()     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.common.entity.shopping.CJRServiceActions r4 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r4     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0069
            java.lang.String r4 = r4.getBillAmount()     // Catch:{ Exception -> 0x006f }
            if (r4 != 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r1 = r4
            goto L_0x006a
        L_0x0069:
            r1 = r2
        L_0x006a:
            double r0 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.common.entity.CJRRechargeCart):double");
    }

    public void c(boolean z2) {
        if (getActivity() != null && isAdded()) {
            Button button = (Button) b(R.id.btn_proceed);
            kotlin.g.b.k.a((Object) button, "btn_proceed");
            button.setEnabled(z2);
            Button button2 = (Button) b(R.id.btn_proceed);
            kotlin.g.b.k.a((Object) button2, "btn_proceed");
            button2.setClickable(z2);
        }
    }

    public void a(Boolean bool) {
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE)) {
            l();
        } else {
            D();
        }
    }

    public void onClick(View view) {
        net.one97.paytm.recharge.common.h.g gVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        Button button = (Button) b(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) button, "btn_proceed");
        int id = button.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            y();
            return;
        }
        CJRAutomaticCLPStripView cJRAutomaticCLPStripView = (CJRAutomaticCLPStripView) b(R.id.automatic_banner_parent);
        kotlin.g.b.k.a((Object) cJRAutomaticCLPStripView, "automatic_banner_parent");
        int id2 = cJRAutomaticCLPStripView.getId();
        if (valueOf != null && valueOf.intValue() == id2 && (gVar = this.f61339f) != null) {
            String str = this.l;
            kotlin.g.b.k.c(str, "serviceType");
            net.one97.paytm.recharge.ordersummary.h.d dVar = gVar.v;
            kotlin.g.b.k.c(str, "serviceType");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("recharge_utilities_service_type", str);
                hashMap.put("user_id", com.paytm.utility.b.n(dVar.f64344b));
                hashMap.put("service_type", str);
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.a("automatic_bill_payment_top_strip_clicked", (HashMap<String, Object>) hashMap, dVar.f64344b);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        r0 = r0.A;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y() {
        /*
            r8 = this;
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 != 0) goto L_0x0010
            r8.J()
            return
        L_0x0010:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r8.b((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r0.requestFocus()
            r1 = 0
            r0.setFocusableInTouchMode(r1)
            r8.j()
            boolean r0 = r8.B()
            if (r0 == 0) goto L_0x0070
            boolean r0 = r8.F
            if (r0 == 0) goto L_0x006c
            r8.D()
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 != 0) goto L_0x0038
            kotlin.g.b.k.a()
        L_0x0038:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            java.lang.String r4 = r8.T()
            androidx.fragment.app.j r5 = r8.getChildFragmentManager()
            java.lang.String r0 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            net.one97.paytm.recharge.common.h.g r0 = r8.f61339f
            if (r0 == 0) goto L_0x005e
            java.lang.String r0 = r0.A
            if (r0 == 0) goto L_0x005e
            long r0 = java.lang.Long.parseLong(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            r6 = r0
            r7 = r8
            net.one97.paytm.recharge.common.utils.e$a r7 = (net.one97.paytm.recharge.common.utils.e.a) r7
            net.one97.paytm.recharge.common.utils.e r0 = new net.one97.paytm.recharge.common.utils.e
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r8.S = r0
            return
        L_0x006c:
            r8.R()
            return
        L_0x0070:
            net.one97.paytm.recharge.common.h.g r0 = r8.f61339f
            if (r0 == 0) goto L_0x0076
            r0.D = r1
        L_0x0076:
            net.one97.paytm.recharge.common.h.g r0 = r8.f61339f
            if (r0 == 0) goto L_0x007c
            r0.E = r1
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.y():void");
    }

    private final void R() {
        CustomInputLinearLayout customInputLinearLayout = this.r;
        boolean j2 = customInputLinearLayout != null ? customInputLinearLayout.j() : false;
        EditText editText = (EditText) b(R.id.fake_view);
        if (editText != null) {
            editText.requestFocus();
        }
        if (j2 || !this.Q) {
            S();
            return;
        }
        Button button = (Button) b(R.id.btn_proceed);
        if (button != null) {
            ai.b(button);
        }
        b.a aVar = net.one97.paytm.recharge.common.c.b.f60954a;
        b.a.a(ah()).show(getChildFragmentManager(), "");
    }

    private final void S() {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        String str;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        CJRProductList productList;
        CustomInputLinearLayout customInputLinearLayout = this.r;
        boolean j2 = customInputLinearLayout != null ? customInputLinearLayout.j() : false;
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        List<CJRProductsItem> list = null;
        CJRUtilityAlertV2 alertObject = customInputLinearLayout2 != null ? customInputLinearLayout2.getAlertObject() : null;
        if (!j2 || alertObject == null) {
            e(j2);
        } else {
            a(alertObject, j2);
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (gVar != null) {
                gVar.D = false;
            }
            net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
            if (gVar2 != null) {
                gVar2.E = false;
            }
        }
        long j3 = 0;
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (!(customInputLinearLayout3 == null || (productList = customInputLinearLayout3.getProductList()) == null)) {
            list = productList.getProducts();
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            CustomInputLinearLayout customInputLinearLayout4 = this.r;
            if (customInputLinearLayout4 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductList productList2 = customInputLinearLayout4.getProductList();
            if (productList2 == null) {
                kotlin.g.b.k.a();
            }
            List<CJRProductsItem> products = productList2.getProducts();
            if (products == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = products.get(0);
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            if (cJRProductsItem.getProductId() != null) {
                CustomInputLinearLayout customInputLinearLayout5 = this.r;
                if (customInputLinearLayout5 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductList productList3 = customInputLinearLayout5.getProductList();
                if (productList3 == null) {
                    kotlin.g.b.k.a();
                }
                List<CJRProductsItem> products2 = productList3.getProducts();
                if (products2 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductsItem cJRProductsItem2 = products2.get(0);
                if (cJRProductsItem2 == null) {
                    kotlin.g.b.k.a();
                }
                Long productId = cJRProductsItem2.getProductId();
                if (productId == null) {
                    kotlin.g.b.k.a();
                }
                j3 = productId.longValue();
            }
        }
        if (j2) {
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward);
            kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward");
            if (relativeLayout.getVisibility() != 0) {
                str = "";
            } else if (this.W) {
                CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
                kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
                str = checkBox.isChecked() ? "ff_checked_manual" : "ff_unchecked_manual";
            } else {
                CheckBox checkBox2 = (CheckBox) b(R.id.radio_fast_forward);
                kotlin.g.b.k.a((Object) checkBox2, "radio_fast_forward");
                str = checkBox2.isChecked() ? "ff_checked_default" : "ff_unchecked_default";
            }
            String str2 = str;
            net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
            if (gVar3 != null && (dVar2 = gVar3.v) != null) {
                String ai = ai();
                String str3 = ab.f61496a;
                kotlin.g.b.k.a((Object) str3, "CJRRechargeUtilityConstant.UTILITY");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, ai, Events.Action.PROCEED_CLICKED, (Object) null, str2, str3, String.valueOf(j3), (Object) null, 68);
                return;
            }
            return;
        }
        net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
        if (gVar4 != null && (dVar = gVar4.v) != null) {
            String ai2 = ai();
            String str4 = ab.f61496a;
            kotlin.g.b.k.a((Object) str4, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai2, "proceed_to_fetch_clicked", (Object) null, (Object) null, str4, (Object) null, (Object) null, 108);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        r1 = r1.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "alert"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.recharge.common.utils.ax$a r0 = net.one97.paytm.recharge.common.utils.ax.f61521a     // Catch:{ Exception -> 0x0073 }
            android.content.Context r0 = r5.getContext()     // Catch:{ Exception -> 0x0073 }
            if (r0 != 0) goto L_0x0010
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0073 }
        L_0x0010:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0073 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = "context!!.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0073 }
            com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0)     // Catch:{ Exception -> 0x0073 }
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r5.p     // Catch:{ Exception -> 0x0073 }
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0073 }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1     // Catch:{ Exception -> 0x0073 }
            if (r1 == 0) goto L_0x0035
            java.lang.Long r1 = r1.getProductId()     // Catch:{ Exception -> 0x0073 }
            goto L_0x0036
        L_0x0035:
            r1 = r2
        L_0x0036:
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0073 }
            r4 = 1
            boolean r0 = r0.b((java.lang.String) r1, (boolean) r3, (boolean) r4)     // Catch:{ Exception -> 0x0073 }
            if (r0 != 0) goto L_0x006f
            java.lang.String r0 = r6.getHeading()     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x006f
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x006f
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r5.p     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0073 }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x005d
            java.lang.Long r2 = r0.getProductId()     // Catch:{ Exception -> 0x0073 }
        L_0x005d:
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0073 }
            net.one97.paytm.recharge.common.fragment.e r6 = net.one97.paytm.recharge.common.fragment.e.a(r7, r6, r0)     // Catch:{ Exception -> 0x0073 }
            androidx.fragment.app.j r0 = r5.getChildFragmentManager()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = net.one97.paytm.recharge.common.fragment.e.f61160a     // Catch:{ Exception -> 0x0073 }
            r6.show(r0, r1)     // Catch:{ Exception -> 0x0073 }
            return
        L_0x006f:
            r5.e((boolean) r7)     // Catch:{ Exception -> 0x0073 }
            return
        L_0x0073:
            r6 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r0.debugLogExceptions(r6)
            r5.e((boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2, boolean):void");
    }

    public final void b(boolean z2) {
        e(z2);
    }

    private void e(boolean z2) {
        boolean z3;
        Map<String, String> map;
        String inputFieldValues;
        String b2;
        StringBuilder journeyStackTrace;
        JSONObject jSONObject;
        String str;
        String str2;
        String str3;
        HashMap<String, String> hashMapDynamicOperatorData;
        CustomInputLinearLayout customInputLinearLayout;
        CustomInputLinearLayout customInputLinearLayout2;
        Long productId;
        String categoryId;
        String str4 = "";
        int i2 = 1;
        String str5 = null;
        if (!z2 || (customInputLinearLayout2 = this.r) == null || customInputLinearLayout2.m()) {
            List<CJRProductsItem> list = this.p;
            if (!(list instanceof List)) {
                list = null;
            }
            Collection collection = list;
            if (collection == null || !(!collection.isEmpty())) {
                z3 = false;
            } else {
                CJRProductsItem cJRProductsItem = (CJRProductsItem) ((List) collection).get(0);
                this.w.put("post_order_view_type", cJRProductsItem.getPostOrderViewType());
                z3 = cJRProductsItem.isPrefetch();
                if (z2 && cJRProductsItem.isPrefetch()) {
                    Map map2 = this.H;
                    CustomInputLinearLayout customInputLinearLayout3 = this.r;
                    map2.put("amount", customInputLinearLayout3 != null ? customInputLinearLayout3.b(false) : null);
                    String l2 = com.paytm.utility.b.l((Context) getActivity());
                    if (l2 != null) {
                        this.H.put("customerMobile", l2);
                        kotlin.x xVar = kotlin.x.f47997a;
                    }
                    String m2 = com.paytm.utility.b.m((Context) getActivity());
                    if (m2 != null) {
                        this.H.put("customerEmail", m2);
                        kotlin.x xVar2 = kotlin.x.f47997a;
                    }
                    ae();
                }
                if (this.K && this.I && !z2 && cJRProductsItem.isPrefetch()) {
                    this.J = T();
                    this.H.put("rechargeNumber", this.J);
                    ad();
                }
                kotlin.x xVar3 = kotlin.x.f47997a;
            }
            if (this.q) {
                net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                if (gVar != null) {
                    gVar.D = false;
                }
                net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
                if (gVar2 != null) {
                    gVar2.E = false;
                    return;
                }
                return;
            }
            CustomInputLinearLayout customInputLinearLayout4 = this.r;
            if (!(customInputLinearLayout4 == null || (hashMapDynamicOperatorData = customInputLinearLayout4.getHashMapDynamicOperatorData()) == null)) {
                if (hashMapDynamicOperatorData.size() > 0) {
                    try {
                        for (Map.Entry next : hashMapDynamicOperatorData.entrySet()) {
                            this.w.put((String) next.getKey(), next.getValue());
                        }
                        CustomInputLinearLayout customInputLinearLayout5 = this.r;
                        if (customInputLinearLayout5 != null) {
                            if (customInputLinearLayout5.f62017i && (customInputLinearLayout = this.r) != null && customInputLinearLayout.getOtcBit() == 0) {
                                this.w.put("otcReceived", true);
                                JSONObject jSONObject2 = this.w;
                                CustomInputLinearLayout customInputLinearLayout6 = this.r;
                                jSONObject2.put("PlanGuiId", customInputLinearLayout6 != null ? customInputLinearLayout6.getPlanGuiId() : null);
                            }
                        }
                        CustomInputLinearLayout customInputLinearLayout7 = this.r;
                        if (customInputLinearLayout7 != null && customInputLinearLayout7.getOtcBit() == 1) {
                            JSONObject jSONObject3 = this.w;
                            CustomInputLinearLayout customInputLinearLayout8 = this.r;
                            jSONObject3.put("isOTC", customInputLinearLayout8 != null ? Boolean.valueOf(customInputLinearLayout8.f62017i) : null);
                            JSONObject jSONObject4 = this.w;
                            CustomInputLinearLayout customInputLinearLayout9 = this.r;
                            jSONObject4.put("PlanGuiId", customInputLinearLayout9 != null ? customInputLinearLayout9.getPlanGuiId() : null);
                        }
                    } catch (Exception e2) {
                        com.paytm.utility.q.d(e2.getMessage());
                    }
                }
                kotlin.x xVar4 = kotlin.x.f47997a;
            }
            this.q = true;
            boolean z4 = z();
            if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && z2) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity).j();
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
            D();
            CustomInputLinearLayout customInputLinearLayout10 = this.r;
            if (customInputLinearLayout10 != null) {
                if (customInputLinearLayout10.a(customInputLinearLayout10 != null ? customInputLinearLayout10.j() : false, false).isEmpty()) {
                    net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
                    if (gVar3 != null) {
                        gVar3.I = false;
                        kotlin.x xVar5 = kotlin.x.f47997a;
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
                    net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
                    if (gVar4 != null) {
                        gVar4.a((Object) a2);
                        kotlin.x xVar6 = kotlin.x.f47997a;
                        return;
                    }
                    return;
                }
            }
            if (this.Q) {
                this.w.put("user_consent", true);
            } else if (this.w.has("user_consent")) {
                this.w.remove("user_consent");
            }
            CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes = this.O;
            if (!(cJRBrowsePlansDescAttributes == null || (jSONObject = this.w) == null)) {
                if (cJRBrowsePlansDescAttributes == null || (str = cJRBrowsePlansDescAttributes.getValidity()) == null) {
                    str = str4;
                }
                jSONObject.put("validity", str);
                JSONObject jSONObject5 = this.w;
                CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes2 = this.O;
                if (cJRBrowsePlansDescAttributes2 == null || (str2 = cJRBrowsePlansDescAttributes2.getTalktime()) == null) {
                    str2 = str4;
                }
                jSONObject5.put("talktime", str2);
                JSONObject jSONObject6 = this.w;
                CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes3 = this.O;
                if (cJRBrowsePlansDescAttributes3 == null || (str3 = cJRBrowsePlansDescAttributes3.getPlanDescription()) == null) {
                    str3 = str4;
                }
                jSONObject6.put("couponDescription", str3);
            }
            if (this.f61113e) {
                this.w.put("doNotBlockOnValidate", 1);
            }
            if (!z2) {
                this.w.put("vending_charge_excluded", true);
            }
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName3 = a3.getFlowName();
            if (flowName3 != null) {
                flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            if (z2) {
                CRUFlowModel flowName4 = a3.getFlowName();
                if (flowName4 != null) {
                    CustomInputLinearLayout customInputLinearLayout11 = this.r;
                    flowName4.setAmountEditable((customInputLinearLayout11 == null || !customInputLinearLayout11.l()) ? 0 : 1);
                }
                CRUFlowModel flowName5 = a3.getFlowName();
                if (flowName5 != null) {
                    if (!z3) {
                        i2 = 0;
                    }
                    flowName5.setPrefetch(i2);
                }
                CRUFlowModel flowName6 = a3.getFlowName();
                if (flowName6 != null) {
                    flowName6.setActionType(ACTION_TYPE.CLP_PROCEED.name());
                }
                CRUFlowModel flowName7 = a3.getFlowName();
                if (flowName7 != null) {
                    flowName7.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
                }
                CRUFlowModel flowName8 = a3.getFlowName();
                if (!(flowName8 == null || (journeyStackTrace = flowName8.getJourneyStackTrace()) == null)) {
                    journeyStackTrace.append("- clpProceedFlow");
                }
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.b(a3, ACTION_TYPE.CLP_PROCEED);
                net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a(a3, ACTION_TYPE.CLP_PROCEED);
            } else {
                CRUFlowModel flowName9 = a3.getFlowName();
                if (flowName9 != null) {
                    flowName9.setActionType(ACTION_TYPE.VERIFY_CALL.name());
                }
            }
            net.one97.paytm.recharge.common.h.g gVar5 = this.f61339f;
            if (gVar5 != null) {
                JSONObject jSONObject7 = this.w;
                CustomInputLinearLayout customInputLinearLayout12 = this.r;
                if (customInputLinearLayout12 != null) {
                    map = customInputLinearLayout12.a(customInputLinearLayout12 != null ? customInputLinearLayout12.j() : false, false);
                } else {
                    map = null;
                }
                if (map == null) {
                    kotlin.g.b.k.a();
                }
                Map<String, String> map3 = this.k;
                CustomInputLinearLayout customInputLinearLayout13 = this.r;
                String str6 = (customInputLinearLayout13 == null || (b2 = customInputLinearLayout13.b(false)) == null) ? str4 : b2;
                CustomInputLinearLayout customInputLinearLayout14 = this.r;
                String convFeePaymentMethod = customInputLinearLayout14 != null ? customInputLinearLayout14.getConvFeePaymentMethod() : null;
                boolean z5 = this.F;
                CustomInputLinearLayout customInputLinearLayout15 = this.r;
                List<CJRUtilityCheckboxItem> multipleCheckedItemList = customInputLinearLayout15 != null ? customInputLinearLayout15.getMultipleCheckedItemList() : null;
                CustomInputLinearLayout customInputLinearLayout16 = this.r;
                gVar5.a("proceed_ckick", jSONObject7, map, map3, str6, convFeePaymentMethod, z2, z4, z5, multipleCheckedItemList, (customInputLinearLayout16 == null || (inputFieldValues = customInputLinearLayout16.getInputFieldValues()) == null) ? str4 : inputFieldValues, this.l, a3);
                kotlin.x xVar7 = kotlin.x.f47997a;
                return;
            }
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CJRItem cJRItem = this.f61340g;
        if (!(cJRItem == null || (categoryId = cJRItem.getCategoryId()) == null)) {
            str4 = categoryId;
        }
        a4.setCategoryId(str4);
        List<CJRProductsItem> list2 = this.p;
        if (list2 != null && (!list2.isEmpty())) {
            List<CJRProductsItem> list3 = this.p;
            if (list3 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem2 = list3.get(0);
            if (!(cJRProductsItem2 == null || (productId = cJRProductsItem2.getProductId()) == null)) {
                str5 = String.valueOf(productId.longValue());
            }
            a4.setProductId(str5);
        }
        CRUFlowModel flowName10 = a4.getFlowName();
        if (flowName10 == null) {
            flowName10 = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
        }
        a4.setFlowName(flowName10);
        CRUFlowModel flowName11 = a4.getFlowName();
        if (flowName11 != null) {
            flowName11.setAlertType(ALERT_TYPE.PRE_VERIFY_PROCEED.name());
        }
        CRUFlowModel flowName12 = a4.getFlowName();
        if (flowName12 != null) {
            flowName12.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName13 = a4.getFlowName();
        if (flowName13 != null) {
            flowName13.setActionType(ACTION_TYPE.CLP_PROCEED.name());
        }
        a4.setErrorMsg(getString(R.string.final_verify_proceed_amount_empty_check, o.class.getSimpleName(), "proceedRechargeClick"));
        az azVar = az.f61525a;
        az.a(a4);
    }

    private final String T() {
        JSONObject jSONObject;
        CustomInputLinearLayout customInputLinearLayout = this.r;
        String rechargeNumberKey = customInputLinearLayout != null ? customInputLinearLayout.getRechargeNumberKey() : null;
        if (TextUtils.isEmpty(rechargeNumberKey) || (jSONObject = this.w) == null || !jSONObject.has(rechargeNumberKey)) {
            return "";
        }
        String string = jSONObject.getString(rechargeNumberKey);
        kotlin.g.b.k.a((Object) string, "it.getString(rechargeNumberKey)");
        return string;
    }

    public boolean z() {
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
        kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
        return checkBox.isChecked();
    }

    public final String m() {
        String str = this.B;
        return str == null ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String U() {
        /*
            r1 = this;
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r1.r
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getAmount()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.U():java.lang.String");
    }

    public String n() {
        String str = this.j;
        return str == null ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getConvFeePaymentMethod();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String p() {
        /*
            r1 = this;
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r1.r
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getConvFeePaymentMethod()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.p():java.lang.String");
    }

    public final Map<String, Object> q() {
        String str;
        net.one97.paytm.recharge.common.h.b i2 = i();
        CustomInputLinearLayout customInputLinearLayout = this.r;
        String str2 = null;
        String inputFieldValues = customInputLinearLayout != null ? customInputLinearLayout.getInputFieldValues() : null;
        if (inputFieldValues == null) {
            kotlin.g.b.k.a();
        }
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        if (customInputLinearLayout2 != null) {
            str2 = customInputLinearLayout2.getGroupFieldInputValue();
        }
        if (str2 == null) {
            kotlin.g.b.k.a();
        }
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (customInputLinearLayout3 == null || (str = customInputLinearLayout3.getAmount()) == null) {
            str = "";
        }
        String str3 = this.l;
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
        kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
        return i2.a(inputFieldValues, str2, str, str3, checkBox.isChecked());
    }

    public void l() {
        t();
        A();
    }

    /* access modifiers changed from: private */
    public final void V() {
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.parent_scroll);
        if (nestedScrollView != null) {
            ai.b(nestedScrollView);
        }
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.progress_view);
        if (relativeLayout != null) {
            ai.a(relativeLayout);
        }
        ba.a((LottieAnimationView) (CJRRechargeLottieAnimationView) b(R.id.loading_threedots));
    }

    public final void A() {
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.progress_view);
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            new Handler().postDelayed(new g(this), 200);
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61350a;

        g(o oVar) {
            this.f61350a = oVar;
        }

        public final void run() {
            NestedScrollView nestedScrollView = (NestedScrollView) this.f61350a.b(R.id.parent_scroll);
            if (nestedScrollView != null) {
                ai.a(nestedScrollView);
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.f61350a.b(R.id.progress_view);
            if (relativeLayout != null) {
                ai.b(relativeLayout);
            }
            ba.b((LottieAnimationView) (CJRRechargeLottieAnimationView) this.f61350a.b(R.id.loading_threedots));
        }
    }

    public boolean B() {
        JSONObject jSONObject;
        String str;
        Map<String, String> keyValueMap;
        GroupAttributesItem groupAttributesItem;
        String str2;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        LinearLayout linearLayout = (LinearLayout) b(R.id.dropdown_layout);
        kotlin.g.b.k.a((Object) linearLayout, "dropdown_layout");
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i2) instanceof LinearLayout) {
                View childAt = ((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i2);
                if (childAt != null) {
                    LinearLayout linearLayout2 = (LinearLayout) childAt;
                    TextInputLayout textInputLayout = (TextInputLayout) linearLayout2.findViewById(R.id.text_input_layout_utility);
                    EditText editText = (EditText) linearLayout2.findViewById(R.id.group_field_textview);
                    if (editText != null) {
                        String str3 = null;
                        if ((textInputLayout != null ? textInputLayout.getHint() : null) == null) {
                            continue;
                        } else if (TextUtils.isEmpty(editText.getText())) {
                            View childAt2 = ((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i2);
                            kotlin.g.b.k.a((Object) childAt2, "dropdown_layout.\n       …        getChildAt(index)");
                            Object tag = childAt2.getTag();
                            if (tag != null) {
                                List list = (List) tag;
                                net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                                if (gVar == null || (cJRCategoryDataHelper = gVar.f61409b) == null) {
                                    groupAttributesItem = null;
                                } else {
                                    Object obj = list.get(0);
                                    if (obj != null) {
                                        int intValue = ((Integer) obj).intValue();
                                        Object obj2 = list.get(1);
                                        if (obj2 != null) {
                                            groupAttributesItem = cJRCategoryDataHelper.getGroupAttributes(intValue, (String) obj2);
                                        } else {
                                            throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else {
                                        throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
                                    }
                                }
                                if (groupAttributesItem == null || (str2 = groupAttributesItem.getError()) == null) {
                                    Resources resources = getResources();
                                    int i3 = R.string.empty_group_error;
                                    Object[] objArr = new Object[1];
                                    CharSequence hint = textInputLayout.getHint();
                                    if (hint != null) {
                                        str3 = hint.toString();
                                    }
                                    objArr[0] = str3;
                                    str2 = resources.getString(i3, objArr);
                                    kotlin.g.b.k.a((Object) str2, "resources\n              …tLayout.hint?.toString())");
                                }
                                if (getActivity() != null) {
                                    az azVar = az.f61525a;
                                    FragmentActivity activity = getActivity();
                                    if (activity == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    az.a(activity, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, (String) null, str2, 8);
                                }
                                this.P = str2;
                                c(str2);
                                return false;
                            }
                            throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                        } else {
                            try {
                                CharSequence valueOf = String.valueOf(textInputLayout.getHint());
                                int length = valueOf.length() - 1;
                                int i4 = 0;
                                boolean z2 = false;
                                while (i4 <= length) {
                                    boolean z3 = valueOf.charAt(!z2 ? i4 : length) <= ' ';
                                    if (z2) {
                                        if (!z3) {
                                            break;
                                        }
                                        length--;
                                    } else if (!z3) {
                                        z2 = true;
                                    } else {
                                        i4++;
                                    }
                                }
                                b(valueOf.subSequence(i4, length + 1).toString(), editText.getText().toString());
                            } catch (Exception e2) {
                                com.paytm.utility.q.d(e2.getMessage());
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.LinearLayout");
                }
            }
        }
        if (this.u) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") == 0) {
                String A2 = com.paytm.utility.b.A(getContext());
                kotlin.g.b.k.a((Object) A2, "CJRAppCommonUtility.getDeviceID(context)");
                b("imei", A2);
            }
        }
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout == null || !customInputLinearLayout.h()) {
            return false;
        }
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        if (customInputLinearLayout2 == null || (jSONObject = customInputLinearLayout2.getMetaData()) == null) {
            jSONObject = new JSONObject();
        }
        this.w = jSONObject;
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (!(customInputLinearLayout3 == null || (keyValueMap = customInputLinearLayout3.getKeyValueMap()) == null)) {
            this.k = keyValueMap;
        }
        Map<String, String> map = this.k;
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 == null || (str = gVar2.A) == null) {
            str = "";
        }
        map.put("category_id", str);
        return true;
    }

    private final void b(String str, String str2) {
        try {
            this.w.put(str, str2);
        } catch (Exception e2) {
            com.paytm.utility.q.d(e2.getMessage());
        }
    }

    private final void a(int i2, String str) {
        this.v = kotlin.a.k.c(Integer.valueOf(i2), str);
    }

    private boolean b(CJRRechargeCart cJRRechargeCart) {
        ConvenienceFeeInputLayout convenienceFeeLayout;
        if (cJRRechargeCart != null) {
            ConvenienceFeeInputLayout.a aVar = ConvenienceFeeInputLayout.f61976h;
            if (ConvenienceFeeInputLayout.a.a(cJRRechargeCart)) {
                CustomInputLinearLayout customInputLinearLayout = this.r;
                if (TextUtils.isEmpty(customInputLinearLayout != null ? customInputLinearLayout.b(false) : null)) {
                    return false;
                }
                CustomInputLinearLayout customInputLinearLayout2 = this.r;
                if (customInputLinearLayout2 == null || (convenienceFeeLayout = customInputLinearLayout2.getConvenienceFeeLayout()) == null) {
                    return true;
                }
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                convenienceFeeLayout.a(activity, cJRRechargeCart);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList> r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x0008
            net.one97.paytm.recharge.model.v4.DataState r1 = r14.getDataState()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r2 = 1
            if (r1 != 0) goto L_0x000d
            goto L_0x0029
        L_0x000d:
            int[] r3 = net.one97.paytm.recharge.common.fragment.p.f61372b
            int r1 = r1.ordinal()
            r1 = r3[r1]
            if (r1 == r2) goto L_0x0026
            r3 = 2
            if (r1 == r3) goto L_0x0022
            r3 = 3
            if (r1 == r3) goto L_0x001e
            goto L_0x0029
        L_0x001e:
            r13.l()
            goto L_0x0029
        L_0x0022:
            r13.l()
            goto L_0x0029
        L_0x0026:
            r13.D()
        L_0x0029:
            r1 = 0
            if (r14 == 0) goto L_0x0298
            java.lang.Object r14 = r14.getData()
            net.one97.paytm.recharge.model.v4.CJRProductList r14 = (net.one97.paytm.recharge.model.v4.CJRProductList) r14
            if (r14 == 0) goto L_0x0298
            java.util.List r3 = r14.getProducts()
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = kotlin.a.k.e(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            goto L_0x0042
        L_0x0041:
            r3 = r0
        L_0x0042:
            if (r3 == 0) goto L_0x004d
            java.lang.String r4 = r3.getBbpsLogoUrl()
            if (r4 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = r4
            goto L_0x0055
        L_0x004d:
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = r3.getBbps_logo_url()
            goto L_0x0055
        L_0x0054:
            r3 = r0
        L_0x0055:
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = ""
        L_0x0059:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0066
            r13.a((java.lang.String) r3)
            goto L_0x0069
        L_0x0066:
            r13.a((java.lang.String) r0)
        L_0x0069:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r13.r
            if (r3 == 0) goto L_0x0072
            boolean r4 = r13.U
            r3.setInTabs(r4)
        L_0x0072:
            net.one97.paytm.recharge.common.h.g r3 = r13.f61339f
            if (r3 == 0) goto L_0x009c
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r13.r
            if (r4 == 0) goto L_0x009c
            net.one97.paytm.common.entity.CJRItem r5 = r13.f61340g
            android.view.View$OnClickListener r6 = r13.aa
            if (r3 != 0) goto L_0x0083
            kotlin.g.b.k.a()
        L_0x0083:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r7 = r3.f61409b
            net.one97.paytm.recharge.common.h.g r3 = r13.f61339f
            if (r3 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r3.m
            r9 = r13
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$b r9 = (net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.b) r9
            r10 = r13
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r10 = (net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a) r10
            r11 = r13
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$b r11 = (net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.b) r11
            r3 = r4
            r4 = r14
            r3.a(r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x009c:
            java.util.List r3 = r14.getProducts()
            r13.p = r3
            r13.G()
            java.util.List r3 = r14.getProducts()
            if (r3 == 0) goto L_0x01e1
            java.util.List r3 = r14.getProducts()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x01e1
            java.util.List r3 = r14.getProducts()
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x00cd
            java.lang.String r5 = r5.getOperator()
            goto L_0x00ce
        L_0x00cd:
            r5 = r0
        L_0x00ce:
            java.lang.String r6 = "operator"
            r4.put(r6, r5)
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.Object r6 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            if (r6 == 0) goto L_0x00e9
            java.lang.Long r6 = r6.getProductId()
            goto L_0x00ea
        L_0x00e9:
            r6 = r0
        L_0x00ea:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "productId"
            r4.put(r6, r5)
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            androidx.fragment.app.FragmentActivity r5 = r13.getActivity()
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r5)
            java.lang.String r6 = "customerId"
            r4.put(r6, r5)
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x011a
            java.lang.String r5 = r5.getPaytype()
            goto L_0x011b
        L_0x011a:
            r5 = r0
        L_0x011b:
            java.lang.String r6 = "paytype"
            r4.put(r6, r5)
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x0131
            java.lang.String r5 = r5.getService()
            goto L_0x0132
        L_0x0131:
            r5 = r0
        L_0x0132:
            java.lang.String r6 = "service"
            r4.put(r6, r5)
            java.util.HashMap<java.lang.Object, java.lang.Object> r4 = r13.H
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r5 = "notificationStatus"
            java.lang.String r6 = "0"
            r4.put(r5, r6)
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x014f
            java.lang.String r4 = r4.getRemindable()
            goto L_0x0150
        L_0x014f:
            r4 = r0
        L_0x0150:
            if (r4 != 0) goto L_0x0156
            r13.T = r1
            r13.I = r1
        L_0x0156:
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x0175
            java.lang.String r4 = r4.getRemindable()
            if (r4 == 0) goto L_0x0175
            java.lang.String r5 = "2"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r2)
            if (r4 == 0) goto L_0x0171
            r13.T = r2
            r13.I = r2
            goto L_0x0175
        L_0x0171:
            r13.T = r1
            r13.I = r1
        L_0x0175:
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x0182
            java.lang.String r4 = r4.getUserConsent()
            goto L_0x0183
        L_0x0182:
            r4 = r0
        L_0x0183:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01a3
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x0198
            java.lang.String r4 = r4.getUserConsent()
            goto L_0x0199
        L_0x0198:
            r4 = r0
        L_0x0199:
            java.lang.String r5 = "true"
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r4, (boolean) r2)
            if (r4 == 0) goto L_0x01a3
            r4 = 1
            goto L_0x01a4
        L_0x01a3:
            r4 = 0
        L_0x01a4:
            r13.Q = r4
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x01b6
            boolean r4 = r4.shouldHideFastForward()
            if (r4 != r2) goto L_0x01b6
            r13.f61341h = r1
        L_0x01b6:
            java.lang.Object r4 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x01c3
            boolean r4 = r4.isBankMandateEnable()
            goto L_0x01c4
        L_0x01c3:
            r4 = 0
        L_0x01c4:
            r13.Z = r4
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.b()
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x01d9
            java.lang.Long r3 = r3.getProductId()
            goto L_0x01da
        L_0x01d9:
            r3 = r0
        L_0x01da:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4.setProductId(r3)
        L_0x01e1:
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r13.p
            if (r3 == 0) goto L_0x0247
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0247
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r13.p
            if (r3 == 0) goto L_0x0247
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x0247
            net.one97.paytm.recharge.common.utils.aa r4 = new net.one97.paytm.recharge.common.utils.aa
            androidx.fragment.app.FragmentActivity r5 = r13.getActivity()
            android.content.Context r5 = (android.content.Context) r5
            r6 = r13
            net.one97.paytm.recharge.common.e.w r6 = (net.one97.paytm.recharge.common.e.w) r6
            r4.<init>(r5, r6)
            java.lang.Long r5 = r3.getProductId()
            if (r5 == 0) goto L_0x0247
            java.lang.Number r5 = (java.lang.Number) r5
            long r7 = r5.longValue()
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r12 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r12.getFlowName()
            if (r5 == 0) goto L_0x0226
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r5.setErrorType(r6)
        L_0x0226:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r12.getFlowName()
            if (r5 == 0) goto L_0x0235
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.SUCCESS_RATE_ALERT
            java.lang.String r6 = r6.name()
            r5.setActionType(r6)
        L_0x0235:
            java.lang.String r6 = r3.getOperator()
            java.lang.String r9 = r3.getService()
            java.lang.String r10 = r3.getPaytype()
            r11 = 0
            java.lang.String r5 = "success_rate_alert_message"
            r4.a(r5, r6, r7, r9, r10, r11, r12)
        L_0x0247:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r13.r
            if (r3 == 0) goto L_0x025b
            boolean r3 = r3.f62014f
            if (r3 != r2) goto L_0x025b
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r13.b((int) r2)
            android.widget.Button r2 = (android.widget.Button) r2
            r2.performClick()
            goto L_0x0267
        L_0x025b:
            net.one97.paytm.recharge.common.h.g r2 = r13.f61339f
            if (r2 == 0) goto L_0x0261
            r2.D = r1
        L_0x0261:
            net.one97.paytm.recharge.common.h.g r2 = r13.f61339f
            if (r2 == 0) goto L_0x0267
            r2.E = r1
        L_0x0267:
            r13.F()
            java.util.List r2 = r14.getProducts()
            if (r2 == 0) goto L_0x0287
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0287
            java.util.List r14 = r14.getProducts()
            java.lang.Object r14 = r14.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r14 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r14
            if (r14 == 0) goto L_0x0287
            java.lang.String r14 = r14.getDisclaimer()
            goto L_0x0288
        L_0x0287:
            r14 = r0
        L_0x0288:
            if (r14 != 0) goto L_0x0293
            net.one97.paytm.recharge.model.v4.CJRCategoryData r14 = r13.y
            if (r14 == 0) goto L_0x0294
            java.lang.String r0 = r14.getDisclaimer()
            goto L_0x0294
        L_0x0293:
            r0 = r14
        L_0x0294:
            r13.f((java.lang.String) r0)
            return
        L_0x0298:
            r14 = r13
            net.one97.paytm.recharge.common.fragment.o r14 = (net.one97.paytm.recharge.common.fragment.o) r14
            net.one97.paytm.recharge.common.h.g r0 = r14.f61339f
            if (r0 == 0) goto L_0x02a1
            r0.D = r1
        L_0x02a1:
            net.one97.paytm.recharge.common.h.g r14 = r14.f61339f
            if (r14 == 0) goto L_0x02a7
            r14.E = r1
        L_0x02a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.recharge.model.v4.Data):void");
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        String str2;
        CJRRechargeErrorModel cJRRechargeErrorModel;
        androidx.lifecycle.y<Data<CJRSetUserConsentApiResponse>> yVar;
        androidx.lifecycle.y<Data<CJRGetUserConsentApiResponse>> yVar2;
        CRUFlowModel flowName;
        NetworkCustomError.ErrorType errorType;
        Long productId;
        CRUFlowModel flowName2;
        NetworkCustomError networkCustomError2 = networkCustomError;
        Object obj2 = obj;
        if (networkCustomError2 == null || (str2 = networkCustomError.getMessage()) == null) {
            str2 = "";
        }
        c(str2);
        if (obj2 instanceof CJRRechargeErrorModel) {
            cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
        } else {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.UNDEFINED, ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
            if (flowName3 == null) {
                flowName3 = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
            }
            cJRRechargeErrorModel.setFlowName(flowName3);
            if (URLUtil.isValidUrl(networkCustomError2 != null ? networkCustomError.getUrl() : null)) {
                cJRRechargeErrorModel.setUrl(networkCustomError2 != null ? networkCustomError.getUrl() : null);
            } else {
                if (!((networkCustomError2 != null ? networkCustomError.getUrl() : null) == null || (flowName2 = cJRRechargeErrorModel.getFlowName()) == null)) {
                    flowName2.setOtherDetails("Invalid Url");
                }
            }
        }
        CJRItem cJRItem = this.f61340g;
        cJRRechargeErrorModel.setCategoryId(cJRItem != null ? cJRItem.getCategoryId() : null);
        List<CJRProductsItem> list = this.p;
        if (list != null && (!list.isEmpty())) {
            List<CJRProductsItem> list2 = this.p;
            if (list2 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = list2.get(0);
            cJRRechargeErrorModel.setProductId((cJRProductsItem == null || (productId = cJRProductsItem.getProductId()) == null) ? null : String.valueOf(productId.longValue()));
        }
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            gVar.D = false;
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            gVar2.E = false;
        }
        this.f61112d = this.y != null;
        if (!this.U || this.s) {
            if (this.y == null) {
                if (kotlin.m.p.a((networkCustomError2 == null || (errorType = networkCustomError.getErrorType()) == null) ? null : errorType.name(), "TimeOutError", true)) {
                    CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
                    if (flowName4 != null) {
                        flowName4.setErrorType(ERROR_TYPE.TIME_OUT_ERROR.name());
                    }
                    az azVar = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                    ac();
                    return;
                }
            }
            if (networkCustomError2 != null) {
                if (networkCustomError2 instanceof net.one97.paytm.recharge.common.utils.d) {
                    String fullUrl = ((net.one97.paytm.recharge.common.utils.d) networkCustomError2).getFullUrl();
                    if (TextUtils.isEmpty(cJRRechargeErrorModel.getUrl())) {
                        if (URLUtil.isValidUrl(networkCustomError.getUrl())) {
                            cJRRechargeErrorModel.setUrl(networkCustomError.getUrl());
                        } else if (!(networkCustomError.getUrl() == null || (flowName = cJRRechargeErrorModel.getFlowName()) == null)) {
                            flowName.setOtherDetails("Invalid Url");
                        }
                    }
                    az azVar2 = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                    if (fullUrl != null) {
                        CharSequence charSequence = fullUrl;
                        if (kotlin.m.p.a(charSequence, (CharSequence) "getBill", false)) {
                            net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
                            if (gVar3 != null && (yVar2 = gVar3.f61416i) != null) {
                                yVar2.postValue(new Data(DataState.ERROR, null, (String) null));
                                return;
                            }
                            return;
                        } else if (kotlin.m.p.a(charSequence, (CharSequence) "createBill", false)) {
                            net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
                            if (gVar4 != null && (yVar = gVar4.f61415h) != null) {
                                yVar.postValue(new Data(DataState.ERROR, null, (String) null));
                                return;
                            }
                            return;
                        }
                    }
                } else if (networkCustomError2 instanceof as) {
                    J();
                    return;
                }
                super.a(str, networkCustomError, obj);
                return;
            }
            return;
        }
        if (!this.f61112d) {
            ac();
        } else {
            az azVar3 = az.f61525a;
            az.a(cJRRechargeErrorModel);
        }
        t();
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61348a;

        e(o oVar) {
            this.f61348a = oVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            ((CheckBox) this.f61348a.b(R.id.radio_fast_forward)).toggle();
            this.f61348a.W = true;
            net.one97.paytm.recharge.common.h.g gVar = this.f61348a.f61339f;
            if (!(gVar == null || (dVar = gVar.v) == null)) {
                String e2 = this.f61348a.ai();
                CheckBox checkBox = (CheckBox) this.f61348a.b(R.id.radio_fast_forward);
                kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
                String str = checkBox.isChecked() ? "fast_forward_checked" : "fast_forward_unchecked";
                String str2 = ab.f61496a;
                kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, str, (Object) null, (Object) null, str2, (Object) null, (Object) null, 108);
            }
            this.f61348a.G();
        }
    }

    /* access modifiers changed from: protected */
    public void b(Data<CJRCategoryData> data) {
        CJRCategoryData data2;
        CJRExtensionAttributes extnAttrs;
        CJRExtensionAttributes extnAttrs2;
        FragmentActivity activity;
        CJRMerchantLoanAccounts cJRMerchantLoanAccounts;
        boolean z2;
        String str;
        String str2;
        CJRMerchantLoanAccounts cJRMerchantLoanAccounts2;
        String verticalId;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        CJRCategoryData categoryData;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        String str3 = null;
        DataState dataState = data != null ? data.getDataState() : null;
        boolean z3 = true;
        if (dataState != null) {
            int i2 = p.f61373c[dataState.ordinal()];
            if (i2 == 1) {
                V();
            } else if (i2 == 2) {
                D();
            } else if (i2 == 3) {
                l();
            }
        }
        if (data != null && (data2 = data.getData()) != null) {
            if (!(getActivity() == null || (activity = getActivity()) == null || !(!activity.isFinishing()))) {
                this.y = data2;
                if (!this.X) {
                    h();
                    this.X = true;
                }
                ((CJRAutomaticCLPStripView) b(R.id.automatic_banner_parent)).setOnClickListener(this);
                this.f61341h = data2.showFastForward();
                List<CJRRelatedCategory> relatedCategories = data2.getRelatedCategories();
                if (relatedCategories != null && (!relatedCategories.isEmpty())) {
                    CJRRelatedCategory cJRRelatedCategory = data2.getRelatedCategories().get(0);
                    if (!kotlin.m.p.a(cJRRelatedCategory != null ? cJRRelatedCategory.getType() : null, "DROP_DOWN", true)) {
                        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                        if (gVar != null) {
                            if (gVar == null) {
                                kotlin.g.b.k.a();
                            }
                            if (!gVar.C) {
                                net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
                                if (gVar2 != null) {
                                    gVar2.C = true;
                                }
                                List<CJRRelatedCategory> relatedCategories2 = data2.getRelatedCategories();
                                if (!this.F) {
                                    if (relatedCategories2 != null && (!relatedCategories2.isEmpty())) {
                                        this.G = new CustomRadioGroup<>(getContext(), relatedCategories2, this.ac, this);
                                        ((LinearLayout) b(R.id.select_opertor_layout)).addView(this.G);
                                    }
                                    if (!TextUtils.isEmpty(ag())) {
                                        CJRItem cJRItem = this.f61340g;
                                        kotlin.m.p.a(cJRItem != null ? cJRItem.getCategoryId() : null, "78640", true);
                                    }
                                }
                            }
                        }
                        if (data.getDataState() != DataState.AFTER_PRODUCT_DETAIL_LOADED) {
                            if (!this.Y) {
                                CustomRadioGroup<CJRRelatedCategory> customRadioGroup = this.G;
                                CJRRelatedCategory relatedCategoryOfSelectedRadioButton = customRadioGroup != null ? customRadioGroup.getRelatedCategoryOfSelectedRadioButton() : null;
                                net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
                                if (!(gVar3 == null || (dVar = gVar3.v) == null)) {
                                    String ai = ai();
                                    String a2 = kotlin.g.b.k.a(relatedCategoryOfSelectedRadioButton != null ? relatedCategoryOfSelectedRadioButton.getLabel() : null, (Object) "_selected");
                                    String str4 = ab.f61496a;
                                    kotlin.g.b.k.a((Object) str4, "CJRRechargeUtilityConstant.UTILITY");
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, a2, "", "", str4, (Object) null, (Object) null, 96);
                                }
                            } else {
                                this.Y = false;
                            }
                        }
                    }
                }
                net.one97.paytm.recharge.legacy.catalog.fragment.d dVar2 = this.t;
                if (dVar2 == null) {
                    if (!this.F) {
                        String a3 = ba.a(data2);
                        CharSequence displayName = data2 != null ? data2.getDisplayName() : null;
                        if (!(displayName == null || kotlin.m.p.a(displayName))) {
                            String valueOf = String.valueOf(data2 != null ? data2.getDisplayName() : null);
                            Integer showHelp = data2 != null ? data2.getShowHelp() : null;
                            str = valueOf;
                            z2 = showHelp != null && showHelp.intValue() == 1;
                        } else {
                            CJRItem cJRItem2 = this.f61340g;
                            CharSequence name = cJRItem2 != null ? cJRItem2.getName() : null;
                            if (!(name == null || name.length() == 0)) {
                                CJRItem cJRItem3 = this.f61340g;
                                str = String.valueOf(cJRItem3 != null ? cJRItem3.getName() : null);
                            } else {
                                str = "";
                            }
                            z2 = false;
                        }
                        if (this.t == null) {
                            CJRItem cJRItem4 = this.f61340g;
                            CJRCategoryData cJRCategoryData = this.y;
                            TopLevelCategoryHeader topLevelCategoryHeader = cJRCategoryData != null ? cJRCategoryData.getTopLevelCategoryHeader() : null;
                            net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
                            String gAEventCategory = (gVar4 == null || (cJRCategoryDataHelper = gVar4.f61409b) == null || (categoryData = cJRCategoryDataHelper.getCategoryData()) == null) ? null : categoryData.getGAEventCategory();
                            if (data2 == null || (verticalId = data2.getVerticalId()) == null) {
                                str2 = "";
                            } else {
                                str2 = verticalId;
                            }
                            this.t = net.one97.paytm.recharge.legacy.catalog.fragment.d.a(str, str, a3, cJRItem4, z2, topLevelCategoryHeader, gAEventCategory, str2);
                            net.one97.paytm.recharge.legacy.catalog.fragment.d dVar3 = this.t;
                            if (dVar3 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.common.h.g gVar5 = this.f61339f;
                            if (gVar5 != null) {
                                cJRMerchantLoanAccounts2 = gVar5.M;
                            } else {
                                cJRMerchantLoanAccounts2 = null;
                            }
                            dVar3.a(cJRMerchantLoanAccounts2);
                            getChildFragmentManager();
                            androidx.fragment.app.q a4 = getChildFragmentManager().a();
                            LinearLayout linearLayout = (LinearLayout) b(R.id.main_content_layout);
                            kotlin.g.b.k.a((Object) linearLayout, "main_content_layout");
                            int id = linearLayout.getId();
                            net.one97.paytm.recharge.legacy.catalog.fragment.d dVar4 = this.t;
                            if (dVar4 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.common.utils.am.a(a4.a(id, dVar4, ""));
                        }
                    }
                } else if (dVar2 != null && !dVar2.d()) {
                    net.one97.paytm.recharge.legacy.catalog.fragment.d dVar5 = this.t;
                    if (dVar5 == null) {
                        kotlin.g.b.k.a();
                    }
                    net.one97.paytm.recharge.common.h.g gVar6 = this.f61339f;
                    if (gVar6 != null) {
                        cJRMerchantLoanAccounts = gVar6.M;
                    } else {
                        cJRMerchantLoanAccounts = null;
                    }
                    dVar5.a(cJRMerchantLoanAccounts);
                    net.one97.paytm.recharge.legacy.catalog.fragment.d dVar6 = this.t;
                    if (dVar6 != null) {
                        dVar6.a(ba.a(data2));
                    }
                }
                net.one97.paytm.recharge.common.h.g gVar7 = this.f61339f;
                if (gVar7 != null) {
                    CustomRadioGroup<CJRRelatedCategory> customRadioGroup2 = this.G;
                    if (customRadioGroup2 != null) {
                        if (gVar7 == null) {
                            kotlin.g.b.k.a();
                        }
                        customRadioGroup2.a(gVar7.m);
                    } else {
                        o oVar = this;
                        net.one97.paytm.recharge.common.h.g gVar8 = oVar.f61339f;
                        if (gVar8 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!gVar8.p) {
                            net.one97.paytm.recharge.common.h.g gVar9 = oVar.f61339f;
                            if (gVar9 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (!gVar9.D && !oVar.E && oVar.R) {
                                CJRFrequentOrder ab2 = oVar.ab();
                                if (ab2 != null) {
                                    oVar.R = false;
                                    oVar.E = true;
                                    oVar.a(ab2);
                                } else {
                                    oVar.l();
                                    oVar.R = false;
                                    net.one97.paytm.recharge.common.h.g gVar10 = oVar.f61339f;
                                    if (gVar10 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    if (!gVar10.E) {
                                        oVar.W();
                                        net.one97.paytm.recharge.widgets.c.d dVar7 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                        CJRRechargeErrorModel a5 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                        a5.setErrorType(ERROR_TYPE.UNDEFINED);
                                        CRUFlowModel flowName = a5.getFlowName();
                                        if (flowName != null) {
                                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                        }
                                        CRUFlowModel flowName2 = a5.getFlowName();
                                        if (flowName2 != null) {
                                            flowName2.setActionType(ACTION_TYPE.RECENT.name());
                                        }
                                        net.one97.paytm.recharge.common.h.g gVar11 = oVar.f61339f;
                                        if (gVar11 != null) {
                                            gVar11.a((Object) a5);
                                        }
                                    }
                                }
                            }
                        }
                        oVar.l();
                        oVar.R = false;
                        net.one97.paytm.recharge.common.h.g gVar12 = oVar.f61339f;
                        if (gVar12 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!gVar12.E) {
                            oVar.W();
                            net.one97.paytm.recharge.widgets.c.d dVar8 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            CJRRechargeErrorModel a6 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                            a6.setErrorType(ERROR_TYPE.UNDEFINED);
                            CRUFlowModel flowName3 = a6.getFlowName();
                            if (flowName3 != null) {
                                flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                            }
                            CRUFlowModel flowName4 = a6.getFlowName();
                            if (flowName4 != null) {
                                flowName4.setActionType(ACTION_TYPE.DEEPLINK.name());
                            }
                            net.one97.paytm.recharge.common.h.g gVar13 = oVar.f61339f;
                            if (gVar13 != null) {
                                gVar13.a((Object) a6);
                            }
                        }
                    }
                }
                if (!this.F) {
                    CharSequence categoryHeader = data2.getCategoryHeader();
                    if (!(categoryHeader == null || kotlin.m.p.a(categoryHeader))) {
                        String categoryHeader2 = data2.getCategoryHeader();
                        if (categoryHeader2 != null) {
                            i(categoryHeader2);
                        }
                    } else {
                        CJRItem cJRItem5 = this.f61340g;
                        CharSequence name2 = cJRItem5 != null ? cJRItem5.getName() : null;
                        if (!(name2 == null || kotlin.m.p.a(name2))) {
                            CJRItem cJRItem6 = this.f61340g;
                            if (cJRItem6 == null) {
                                kotlin.g.b.k.a();
                            }
                            String name3 = cJRItem6.getName();
                            kotlin.g.b.k.a((Object) name3, "rechargeItem!!.name");
                            i(name3);
                        }
                    }
                }
            }
            f(data2.getDisclaimer());
            CJRCategoryData cJRCategoryData2 = this.y;
            CharSequence errorImage = (cJRCategoryData2 == null || (extnAttrs2 = cJRCategoryData2.getExtnAttrs()) == null) ? null : extnAttrs2.getErrorImage();
            if (errorImage != null && !kotlin.m.p.a(errorImage)) {
                z3 = false;
            }
            if (!z3) {
                com.squareup.picasso.w a7 = com.squareup.picasso.w.a();
                CJRCategoryData cJRCategoryData3 = this.y;
                if (!(cJRCategoryData3 == null || (extnAttrs = cJRCategoryData3.getExtnAttrs()) == null)) {
                    str3 = extnAttrs.getErrorImage();
                }
                a7.a(str3).f();
            }
            Z();
        }
    }

    private final void W() {
        net.one97.paytm.recharge.common.h.g gVar;
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            if (gVar2 == null) {
                kotlin.g.b.k.a();
            }
            if (gVar2.D && (gVar = this.f61339f) != null) {
                gVar.E = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r3 = r3.f61409b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x037e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.recharge.model.v4.CJRNextGroupData r14) {
        /*
            r13 = this;
            r0 = 0
            r13.R = r0
            r1 = 0
            if (r14 == 0) goto L_0x002c
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r2 = r14.getGroupAttributesItem()
            if (r2 == 0) goto L_0x002c
            net.one97.paytm.recharge.model.v4.CJRDeviceType r2 = r2.getType()
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r2.getAndroidType()
            if (r2 == 0) goto L_0x002c
            if (r2 == 0) goto L_0x0024
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            goto L_0x002d
        L_0x0024:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r14.<init>(r0)
            throw r14
        L_0x002c:
            r2 = r1
        L_0x002d:
            if (r2 != 0) goto L_0x0030
            return
        L_0x0030:
            int r3 = r2.hashCode()
            switch(r3) {
                case -1245847267: goto L_0x00a3;
                case -432061423: goto L_0x009a;
                case 3181382: goto L_0x0091;
                case 3322014: goto L_0x0088;
                case 108270587: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x0404
        L_0x0039:
            java.lang.String r0 = "radio"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0404
            java.util.List r0 = r14.getAggs()
            if (r0 == 0) goto L_0x0404
            java.lang.String r0 = r14.getGroupName()
            if (r0 == 0) goto L_0x0404
            net.one97.paytm.recharge.common.h.g r0 = r13.f61339f
            if (r0 == 0) goto L_0x0060
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0060
            int r1 = r14.getGroupLevel()
            java.lang.String r2 = r14.getGroupName()
            r0.getAggItem(r1, r2)
        L_0x0060:
            net.one97.paytm.recharge.common.widget.GroupItemCustomRadioGroup r0 = new net.one97.paytm.recharge.common.widget.GroupItemCustomRadioGroup
            android.content.Context r4 = r13.getContext()
            java.lang.String r5 = r14.getGroupName()
            int r6 = r14.getGroupLevel()
            java.util.List r7 = r14.getAggs()
            r8 = r13
            net.one97.paytm.recharge.common.widget.GroupItemCustomRadioGroup$b r8 = (net.one97.paytm.recharge.common.widget.GroupItemCustomRadioGroup.b) r8
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            int r14 = net.one97.paytm.recharge.R.id.dropdown_layout
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.view.View r0 = (android.view.View) r0
            r14.addView(r0)
            goto L_0x0404
        L_0x0088:
            java.lang.String r3 = "list"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0404
            goto L_0x00ab
        L_0x0091:
            java.lang.String r3 = "grid"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0404
            goto L_0x00ab
        L_0x009a:
            java.lang.String r3 = "dropdown"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0404
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r3 = "option_tickets"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0404
        L_0x00ab:
            int r2 = net.one97.paytm.recharge.R.id.electricity_layout
            android.view.View r2 = r13.b((int) r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            java.lang.String r3 = "electricity_layout"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.a(r2)
            java.lang.String r2 = r14.getGroupName()
            if (r2 == 0) goto L_0x0404
            net.one97.paytm.recharge.common.h.g r3 = r13.f61339f
            if (r3 == 0) goto L_0x00d5
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r3.f61409b
            if (r3 == 0) goto L_0x00d5
            int r4 = r14.getGroupLevel()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = r3.getAggItem(r4, r2)
            r6 = r3
            goto L_0x00d6
        L_0x00d5:
            r6 = r1
        L_0x00d6:
            net.one97.paytm.recharge.common.widget.CustomDropDownLayout r10 = new net.one97.paytm.recharge.common.widget.CustomDropDownLayout
            android.content.Context r4 = r13.getContext()
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r5 = r14.getGroupAttributesItem()
            int r8 = r14.getGroupLevel()
            android.view.View$OnClickListener r9 = r13.ad
            r3 = r10
            r7 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = net.one97.paytm.recharge.R.id.dropdown_layout
            android.view.View r3 = r13.b((int) r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            android.view.View r10 = (android.view.View) r10
            r3.addView(r10)
            r13.D = r10
            net.one97.paytm.recharge.common.h.g r9 = r13.f61339f
            if (r9 == 0) goto L_0x0404
            int r7 = r14.getGroupLevel()
            java.lang.String r14 = r13.ag()
            java.lang.String r3 = "groupName"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "eventCategory"
            kotlin.g.b.k.c(r14, r3)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r14 = r9.f61409b
            java.util.List r14 = r14.getGroupItemList(r7, r2)
            r3 = 1
            if (r14 == 0) goto L_0x013e
            int r4 = r14.size()
            if (r4 != r3) goto L_0x013e
            boolean r4 = r9.f61411d
            if (r4 == 0) goto L_0x012f
            java.lang.Object r4 = r14.get(r0)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r4
            boolean r4 = r4.isSchedulable()
            if (r4 == 0) goto L_0x013e
        L_0x012f:
            r5 = 0
            java.lang.Object r14 = r14.get(r0)
            r6 = r14
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            r8 = 1
            r3 = r9
            r4 = r2
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            return
        L_0x013e:
            java.lang.String r4 = r9.n
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "accordion"
            if (r4 != 0) goto L_0x01a6
            if (r14 == 0) goto L_0x01a6
            java.lang.String r4 = r9.n
            int r6 = net.one97.paytm.recharge.common.utils.ba.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r14, (java.lang.String) r4)
            r9.n = r1
            if (r6 < 0) goto L_0x01a4
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r4 = r4.getGroupAttributes(r7, r2)
            if (r4 == 0) goto L_0x0169
            net.one97.paytm.recharge.model.v4.CJRDeviceType r4 = r4.getType()
            if (r4 == 0) goto L_0x0169
            java.lang.String r4 = r4.getAndroidType()
            goto L_0x016a
        L_0x0169:
            r4 = r1
        L_0x016a:
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r3)
            if (r4 == 0) goto L_0x0191
            java.lang.String r4 = r9.o
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x017e
            boolean r4 = kotlin.m.p.a(r4)
            if (r4 == 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r3 = 0
        L_0x017e:
            if (r3 != 0) goto L_0x0191
            java.lang.Object r3 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            java.util.List r3 = r3.getAggs()
            java.lang.String r4 = r9.o
            net.one97.paytm.recharge.common.utils.ba.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r3, (java.lang.String) r4)
            r9.o = r1
        L_0x0191:
            java.lang.Object r14 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r14 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r14
            r8 = 1
            r3 = r9
            r4 = r2
            r5 = r6
            r6 = r14
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            r9.D = r0
            r9.E = r0
            return
        L_0x01a4:
            r9.o = r1
        L_0x01a6:
            java.lang.String r4 = r9.n
            if (r4 != 0) goto L_0x01ed
            java.lang.String r4 = r9.o
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01ed
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r4 = r4.getGroupAttributes(r7, r2)
            if (r4 == 0) goto L_0x01c9
            net.one97.paytm.recharge.model.v4.CJRDeviceType r4 = r4.getType()
            if (r4 == 0) goto L_0x01c9
            java.lang.String r4 = r4.getAndroidType()
            goto L_0x01ca
        L_0x01c9:
            r4 = r1
        L_0x01ca:
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r3)
            if (r4 != 0) goto L_0x01ed
            java.lang.String r4 = r9.o
            int r6 = net.one97.paytm.recharge.common.utils.ba.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r14, (java.lang.String) r4)
            if (r6 < 0) goto L_0x01eb
            java.lang.Object r14 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r14 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r14
            r8 = 1
            r3 = r9
            r4 = r2
            r5 = r6
            r6 = r14
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            r9.D = r0
            r9.E = r0
            return
        L_0x01eb:
            r9.o = r1
        L_0x01ed:
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r9.m
            java.util.Map r4 = (java.util.Map) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x02b6
            if (r14 == 0) goto L_0x02b6
            r4 = r14
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x02b6
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r9.m
            java.util.Map r4 = (java.util.Map) r4
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r6 = r6.getGroupAttributes(r7, r2)
            if (r6 == 0) goto L_0x0215
            java.lang.String r6 = r6.getName()
            goto L_0x0216
        L_0x0215:
            r6 = r1
        L_0x0216:
            if (r4 == 0) goto L_0x02ae
            boolean r4 = r4.containsKey(r6)
            if (r4 == 0) goto L_0x02a8
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r9.m
            java.util.Map r4 = (java.util.Map) r4
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r6 = r6.getGroupAttributes(r7, r2)
            if (r6 == 0) goto L_0x022f
            java.lang.String r6 = r6.getName()
            goto L_0x0230
        L_0x022f:
            r6 = r1
        L_0x0230:
            java.lang.Object r4 = r4.get(r6)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x02b6
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r9.f61409b
            int r6 = r6.getIndexFromList(r14, r4)
            if (r6 < 0) goto L_0x02a2
            int r4 = r14.size()
            if (r6 >= r4) goto L_0x02a2
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r0 = r0.getGroupAttributes(r7, r2)
            if (r0 == 0) goto L_0x0293
            net.one97.paytm.recharge.model.v4.CJRDeviceType r0 = r0.getType()
            if (r0 == 0) goto L_0x0293
            java.lang.String r0 = r0.getAndroidType()
            if (r0 == 0) goto L_0x0293
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r3)
            if (r0 != r3) goto L_0x0293
            java.lang.Object r0 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            java.lang.String r0 = r0.getAggKey()
            if (r0 == 0) goto L_0x0293
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.m
            java.util.Map r3 = (java.util.Map) r3
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r9.f61409b
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r0 = r4.getGroupAttributes(r7, r0)
            if (r0 == 0) goto L_0x027c
            java.lang.String r1 = r0.getName()
        L_0x027c:
            java.lang.Object r0 = r3.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0293
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r9.f61409b
            java.lang.Object r3 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            java.util.List r3 = r3.getAggs()
            r1.getIndexFromList(r3, r0)
        L_0x0293:
            java.lang.Object r14 = r14.get(r6)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r14 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r14
            r8 = 1
            r3 = r9
            r4 = r2
            r5 = r6
            r6 = r14
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            return
        L_0x02a2:
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r9.m
            r4.clear()
            goto L_0x02b6
        L_0x02a8:
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r9.m
            r4.clear()
            goto L_0x02b6
        L_0x02ae:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r14.<init>(r0)
            throw r14
        L_0x02b6:
            r9.D = r0
            r9.E = r0
            java.lang.String r4 = "state"
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r4 != 0) goto L_0x02ca
            java.lang.String r4 = "city"
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r4 == 0) goto L_0x03a7
        L_0x02ca:
            net.one97.paytm.recharge.common.b.c r4 = r9.s
            java.lang.String r5 = r9.A
            java.lang.String r4 = r4.a((java.lang.String) r5)
            if (r4 == 0) goto L_0x03fa
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = ","
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r8, (boolean) r0)
            if (r8 == 0) goto L_0x038d
            kotlin.m.l r4 = new kotlin.m.l
            r4.<init>((java.lang.String) r6)
            java.util.List r4 = r4.split(r5, r0)
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x031e
            int r5 = r4.size()
            java.util.ListIterator r5 = r4.listIterator(r5)
        L_0x02f9:
            boolean r6 = r5.hasPrevious()
            if (r6 == 0) goto L_0x031e
            java.lang.Object r6 = r5.previous()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 != 0) goto L_0x030f
            r6 = 1
            goto L_0x0310
        L_0x030f:
            r6 = 0
        L_0x0310:
            if (r6 != 0) goto L_0x02f9
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            int r5 = r5.nextIndex()
            int r5 = r5 + r3
            java.util.List r4 = kotlin.a.k.b(r4, (int) r5)
            goto L_0x0322
        L_0x031e:
            kotlin.a.w r4 = kotlin.a.w.INSTANCE
            java.util.List r4 = (java.util.List) r4
        L_0x0322:
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.Object[] r4 = r4.toArray(r5)
            if (r4 == 0) goto L_0x0385
            java.lang.String[] r4 = (java.lang.String[]) r4
            r5 = r4[r3]
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r6 = r5.length()
            int r6 = r6 - r3
            r8 = r6
            r6 = 0
            r10 = 0
        L_0x033a:
            if (r6 > r8) goto L_0x035a
            if (r10 != 0) goto L_0x0340
            r11 = r6
            goto L_0x0341
        L_0x0340:
            r11 = r8
        L_0x0341:
            char r11 = r5.charAt(r11)
            r12 = 32
            if (r11 > r12) goto L_0x034b
            r11 = 1
            goto L_0x034c
        L_0x034b:
            r11 = 0
        L_0x034c:
            if (r10 != 0) goto L_0x0355
            if (r11 != 0) goto L_0x0352
            r10 = 1
            goto L_0x033a
        L_0x0352:
            int r6 = r6 + 1
            goto L_0x033a
        L_0x0355:
            if (r11 == 0) goto L_0x035a
            int r8 = r8 + -1
            goto L_0x033a
        L_0x035a:
            int r8 = r8 + r3
            java.lang.CharSequence r5 = r5.subSequence(r6, r8)
            java.lang.String r5 = r5.toString()
            r4[r3] = r5
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r9.f61409b
            r6 = r4[r3]
            int r5 = r5.getIndexFromList(r14, r6)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r9.f61409b
            if (r14 == 0) goto L_0x037e
            java.lang.Object r8 = r14.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            if (r8 == 0) goto L_0x037e
            java.util.List r8 = r8.getAggs()
            goto L_0x037f
        L_0x037e:
            r8 = r1
        L_0x037f:
            r4 = r4[r0]
            r6.getIndexFromList(r8, r4)
            goto L_0x0394
        L_0x0385:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r14.<init>(r0)
            throw r14
        L_0x038d:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r9.f61409b
            int r4 = r5.getIndexFromList(r14, r4)
            r5 = r4
        L_0x0394:
            if (r5 < 0) goto L_0x03a7
            if (r14 == 0) goto L_0x039f
            java.lang.Object r14 = r14.get(r5)
            r1 = r14
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r1
        L_0x039f:
            r6 = r1
            r8 = 1
            r3 = r9
            r4 = r2
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            return
        L_0x03a7:
            if (r14 == 0) goto L_0x03d3
            int r1 = r14.size()
            int r1 = r1 - r3
            r3 = -1
            if (r1 == r3) goto L_0x03d3
            if (r1 < 0) goto L_0x03d3
            r5 = 0
        L_0x03b4:
            java.lang.Object r0 = r14.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            boolean r0 = r0.isItemShouldBeSelectedByDefault()
            if (r0 == 0) goto L_0x03ce
            java.lang.Object r14 = r14.get(r5)
            r6 = r14
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            r8 = 1
            r3 = r9
            r4 = r2
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
            return
        L_0x03ce:
            if (r5 == r1) goto L_0x03d3
            int r5 = r5 + 1
            goto L_0x03b4
        L_0x03d3:
            boolean r14 = r9.a(r7, r2)
            if (r14 == 0) goto L_0x03f2
            net.one97.paytm.common.entity.CJRItem r14 = r9.r
            if (r14 == 0) goto L_0x03e3
            java.lang.String r14 = r14.getName()
            if (r14 != 0) goto L_0x03e5
        L_0x03e3:
            java.lang.String r14 = ""
        L_0x03e5:
            r9.a((int) r7, (java.lang.String) r2, (java.lang.String) r14)
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r14 = r9.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateSelectedItem r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$updateSelectedItem
            r0.<init>(r7, r2)
            r14.setValue(r0)
        L_0x03f2:
            androidx.lifecycle.y<java.lang.Boolean> r14 = r9.z
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.setValue(r0)
            return
        L_0x03fa:
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r14 = r9.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$getLocalLocation r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$getLocalLocation
            r0.<init>(r7, r2)
            r14.setValue(r0)
        L_0x0404:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.recharge.model.v4.CJRNextGroupData):void");
    }

    public final void a(int i2, String str, int i3) {
        kotlin.g.b.k.c(str, "groupName");
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            gVar.a(i2, str, i3, (CJRAggsItem) null, "");
        }
    }

    static final class b implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61345a;

        b(o oVar) {
            this.f61345a = oVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            String str;
            Map<String, CJRSelectedGroupItem> selectedGroupItemHashMap;
            View findViewById = radioGroup.findViewById(i2);
            if (findViewById != null) {
                RadioButton radioButton = (RadioButton) findViewById;
                CJRAggsItem cJRAggsItem = null;
                if (radioButton.getTag() instanceof CJRRelatedCategory) {
                    Object tag = radioButton.getTag();
                    if (tag != null) {
                        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                        String url = cJRRelatedCategory.getUrl();
                        if (url != null) {
                            ViewGroup d2 = this.f61345a.M;
                            if (d2 != null) {
                                ai.b(d2);
                            }
                            this.f61345a.V();
                            this.f61345a.X();
                            net.one97.paytm.recharge.common.h.g gVar = this.f61345a.f61339f;
                            if (gVar != null) {
                                gVar.C = true;
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
                                flowName2.setActionType(ACTION_TYPE.RC_CHANGED.name());
                            }
                            net.one97.paytm.recharge.common.h.g gVar2 = this.f61345a.f61339f;
                            if (gVar2 != null) {
                                kotlin.g.b.k.c("getCategory", "tag");
                                kotlin.g.b.k.c(url, "url");
                                gVar2.f61409b.setCategoryData((CJRCategoryData) null);
                                gVar2.A = kotlin.m.p.c(url, "category/", "");
                                gVar2.A = kotlin.m.p.b(gVar2.A, "/", gVar2.A);
                                if (gVar2.f61409b.getRelatedCategoryData(gVar2.A) != null) {
                                    CJRCategoryData relatedCategoryData = gVar2.f61409b.getRelatedCategoryData(gVar2.A);
                                    if (relatedCategoryData != null) {
                                        relatedCategoryData.setNextLevelGroupingData((CJRCategoryData) null);
                                    }
                                    if (!(relatedCategoryData == null || (selectedGroupItemHashMap = relatedCategoryData.getSelectedGroupItemHashMap()) == null)) {
                                        selectedGroupItemHashMap.clear();
                                    }
                                    gVar2.f61409b.setCategoryData(relatedCategoryData);
                                    gVar2.x.postValue(new Data(DataState.SUCCESS, relatedCategoryData, (String) null));
                                } else {
                                    gVar2.a("getCategory", true, (Object) a2);
                                }
                            }
                            String label = cJRRelatedCategory.getLabel();
                            if (label != null) {
                                o oVar = this.f61345a;
                                kotlin.g.b.k.c(label, "<set-?>");
                                oVar.l = label;
                            }
                            String value = cJRRelatedCategory.getValue();
                            if (value != null) {
                                this.f61345a.z = value;
                            }
                            com.paytm.utility.q.d(this.f61345a.l);
                            return;
                        }
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                } else if (radioButton.getTag() instanceof Integer) {
                    kotlin.g.b.k.a((Object) radioGroup, "group");
                    Object tag2 = radioGroup.getTag();
                    if (tag2 != null) {
                        List list = (List) tag2;
                        if ((list.get(0) instanceof Integer) && (list.get(1) instanceof String)) {
                            Object obj = list.get(0);
                            if (obj != null) {
                                int intValue = ((Integer) obj).intValue();
                                Object obj2 = list.get(1);
                                if (obj2 != null) {
                                    String str2 = (String) obj2;
                                    Object tag3 = radioButton.getTag();
                                    if (tag3 != null) {
                                        int intValue2 = ((Integer) tag3).intValue();
                                        net.one97.paytm.recharge.common.h.g gVar3 = this.f61345a.f61339f;
                                        if (gVar3 != null) {
                                            kotlin.g.b.k.c(str2, "groupName");
                                            cJRAggsItem = gVar3.f61409b.getGroupItem(intValue, str2, intValue2);
                                        }
                                        net.one97.paytm.recharge.common.h.g gVar4 = this.f61345a.f61339f;
                                        if (gVar4 != null) {
                                            gVar4.a(intValue, str2, intValue2, (CJRAggsItem) null, "");
                                        }
                                        net.one97.paytm.recharge.common.h.g gVar5 = this.f61345a.f61339f;
                                        if (gVar5 != null) {
                                            if (cJRAggsItem == null || (str = cJRAggsItem.getValue()) == null) {
                                                str = "";
                                            }
                                            kotlin.g.b.k.c(str, "serviceType");
                                            net.one97.paytm.recharge.ordersummary.h.d dVar2 = gVar5.v;
                                            kotlin.g.b.k.c(str, "serviceType");
                                            try {
                                                Map linkedHashMap = new LinkedHashMap();
                                                linkedHashMap.put("recharge_utilities_service_type", str);
                                                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                                                net.one97.paytm.recharge.di.helper.b.a(dVar2.f64343a, (Map<String, Object>) linkedHashMap, "recharge_utilities_servicetype_selected", dVar2.f64344b);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    } else {
                                        throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
                                    }
                                } else {
                                    throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
                                }
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
                            }
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    }
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type android.widget.RadioButton");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void X() {
        ((LinearLayout) b(R.id.dropdown_layout)).removeAllViews();
        Y();
        CustomSwitch customSwitch = this.N;
        if (customSwitch != null) {
            customSwitch.setChecked(false);
        }
        this.A = false;
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            ai.b(viewGroup);
        }
        this.L = false;
    }

    public void C() {
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward);
        kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward");
        relativeLayout.setVisibility(8);
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
        kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
        checkBox.setChecked(false);
        this.n = true;
        this.W = false;
        G();
        c(true);
    }

    public void D() {
        Button button = (Button) b(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) button, "btn_proceed");
        ai.b(button);
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.loading_threedots_view);
        kotlin.g.b.k.a((Object) relativeLayout, "loading_threedots_view");
        ai.a(relativeLayout);
        ba.a((LottieAnimationView) (CJRRechargeLottieAnimationView) b(R.id.loading_threedots_lav));
        FrameLayout frameLayout = (FrameLayout) b(R.id.transparent_view);
        kotlin.g.b.k.a((Object) frameLayout, "transparent_view");
        ai.a(frameLayout);
    }

    public void t() {
        Button button = (Button) b(R.id.btn_proceed);
        if (button != null) {
            ai.a(button);
        }
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.loading_threedots_view);
        if (relativeLayout != null) {
            ai.b(relativeLayout);
        }
        ba.a((LottieAnimationView) (CJRRechargeLottieAnimationView) b(R.id.loading_threedots_lav));
        this.q = false;
        FrameLayout frameLayout = (FrameLayout) b(R.id.transparent_view);
        if (frameLayout != null) {
            ai.b(frameLayout);
        }
        if (getActivity() instanceof net.one97.paytm.recharge.common.e.y) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).k();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    static final class x implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61370a;

        x(o oVar) {
            this.f61370a = oVar;
        }

        public final void run() {
            this.f61370a.t();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61351a;

        h(o oVar) {
            this.f61351a = oVar;
        }

        public final void onClick(View view) {
            Object tag = view != null ? view.getTag() : null;
            if (tag instanceof List) {
                Collection arrayList = new ArrayList();
                for (Object next : (Iterable) tag) {
                    if (next instanceof Object) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                if ((list.get(0) instanceof Integer) && (list.get(1) instanceof String)) {
                    this.f61351a.v = list;
                }
                Object obj = list.get(0);
                if (obj != null) {
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(1);
                    if (obj2 != null) {
                        String str = (String) obj2;
                        net.one97.paytm.recharge.common.h.g gVar = this.f61351a.f61339f;
                        if (gVar != null) {
                            gVar.a(intValue, str, this.f61351a.l);
                            return;
                        }
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
                }
                throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    private final View b(List<? extends Object> list) {
        try {
            LinearLayout linearLayout = (LinearLayout) b(R.id.dropdown_layout);
            kotlin.g.b.k.a((Object) linearLayout, "dropdown_layout");
            int childCount = linearLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = ((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i2);
                kotlin.g.b.k.a((Object) childAt, "dropdown_layout.getChildAt(i)");
                Object tag = childAt.getTag();
                if (tag != null) {
                    List list2 = (List) tag;
                    if (kotlin.g.b.k.a(list2.get(0), (Object) list.get(0)) && kotlin.g.b.k.a(list2.get(1), (Object) list.get(1))) {
                        return ((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i2);
                    }
                    i2++;
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        if (!this.F) {
            new Handler().postDelayed(new a(this, str), 500);
            this.B = str;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61343a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61344b;

        a(o oVar, String str) {
            this.f61343a = oVar;
            this.f61344b = str;
        }

        public final void run() {
            if (this.f61343a.s) {
                FJRRechargeUtilityBaseV2.b bVar = this.f61343a.f61342i;
                if (bVar != null) {
                    bVar.a(this.f61344b);
                }
                o oVar = this.f61343a;
                CharSequence charSequence = this.f61344b;
                oVar.u = !(charSequence == null || kotlin.m.p.a(charSequence));
            }
        }
    }

    public final boolean E() {
        a(this.B);
        return !TextUtils.isEmpty(this.B);
    }

    public final void am_() {
        throw new kotlin.n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void d() {
        throw new kotlin.n("An operation is not implemented: ".concat("not implemented"));
    }

    public final boolean a(ConvenienceFeeInputLayout convenienceFeeInputLayout) {
        kotlin.g.b.k.c(convenienceFeeInputLayout, "field");
        CJRRechargeUtilities.INSTANCE.debugLog("onClickedConvenienceFeeInputField");
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            String inputFieldHint = convenienceFeeInputLayout.getInputFieldHint();
            String str = this.l;
            kotlin.g.b.k.c(inputFieldHint, "groupLabel");
            kotlin.g.b.k.c(str, "serviceType");
            net.one97.paytm.recharge.ordersummary.h.d dVar = gVar.v;
            kotlin.g.b.k.c(inputFieldHint, "groupLable");
            kotlin.g.b.k.c(str, "serviceType");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("recharge_utilities_group_field", inputFieldHint);
                hashMap.put("recharge_utilities_service_type", str);
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.a(dVar.f64343a, (Map<String, Object>) hashMap, "recharge_utilities_group_field_clicked", dVar.f64344b);
            } catch (Throwable unused) {
            }
        }
        if (!(convenienceFeeInputLayout.f61980d != null) || !b(this.o)) {
            ((Button) b(R.id.btn_proceed)).performClick();
        }
        return true;
    }

    public final void a(Intent intent) {
        kotlin.g.b.k.c(intent, "intent");
        startActivityForResult(intent, 604);
    }

    public final void a(String str, String str2) {
        CJRRechargeUtilities.INSTANCE.debugLog("onPaymentModeSelected: ".concat(String.valueOf(str)));
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            String string = getString(R.string.select_payment_mode);
            kotlin.g.b.k.a((Object) string, "getString(R.string.select_payment_mode)");
            if (str == null) {
                str = "";
            }
            kotlin.g.b.k.c(string, "label");
            kotlin.g.b.k.c(str, "groupFieldValue");
            net.one97.paytm.recharge.ordersummary.h.d dVar = gVar.v;
            kotlin.g.b.k.c(string, "label");
            kotlin.g.b.k.c(str, "groupFieldValue");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("recharge_utilities_group_field", string);
                hashMap.put("recharge_utilities_group_field_value", str);
                hashMap.put("recharge_utilities_selection_method", "manual");
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.a(dVar.a(), (Map<String, Object>) hashMap, "recharge_utilities_group_field_selected", dVar.f64344b);
            } catch (Throwable unused) {
            }
        }
        if (str2 == null) {
            try {
                kotlin.g.b.k.a();
            } catch (Exception e2) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                Button button = (Button) b(R.id.btn_proceed);
                kotlin.g.b.k.a((Object) button, "btn_proceed");
                button.setText(getString(R.string.utility_proceed));
                return;
            }
        }
        double parseDouble = Double.parseDouble(str2);
        CustomInputLinearLayout customInputLinearLayout = this.r;
        String b2 = customInputLinearLayout != null ? customInputLinearLayout.b(false) : null;
        if (b2 == null) {
            kotlin.g.b.k.a();
        }
        double parseDouble2 = parseDouble + Double.parseDouble(b2);
        Button button2 = (Button) b(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) button2, "btn_proceed");
        button2.setText(getString(R.string.proceed_btn_ff_selected, String.valueOf(parseDouble2)));
    }

    private final void a(String str, int i2) {
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            LinearLayout linearLayout = (LinearLayout) b(R.id.dropdown_layout);
            kotlin.g.b.k.a((Object) linearLayout, "dropdown_layout");
            if (i3 < linearLayout.getChildCount()) {
                View childAt = ((LinearLayout) b(R.id.dropdown_layout)).getChildAt(i3);
                kotlin.g.b.k.a((Object) childAt, "dropdown_layout.getChildAt(i)");
                Object tag = childAt.getTag();
                if (tag != null) {
                    List list = (List) tag;
                    if ((list.get(0) instanceof Integer) && (list.get(1) instanceof String)) {
                        if (!z2) {
                            Object obj = list.get(0);
                            if (obj == null) {
                                throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
                            } else if (i2 == ((Integer) obj).intValue()) {
                                Object obj2 = list.get(1);
                                if (obj2 == null) {
                                    throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
                                } else if (kotlin.m.p.a(str, (String) obj2, true)) {
                                    z2 = true;
                                }
                            }
                        }
                        if (z2) {
                            ((LinearLayout) b(R.id.dropdown_layout)).removeViewAt(i3);
                            i3--;
                        }
                    }
                    i3++;
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                }
            } else {
                return;
            }
        }
    }

    private final void Y() {
        this.o = null;
        this.p = null;
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout != null) {
            customInputLinearLayout.removeAllViews();
        }
        aa();
        C();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getExtnAttrs();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void Z() {
        /*
            r4 = this;
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r4.y
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r0 = r0.getExtnAttrs()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getBbpsLogoUrl()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r4.y
            if (r2 == 0) goto L_0x0035
            net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r2 = r2.getExtnAttrs()
            if (r2 == 0) goto L_0x0035
            boolean r2 = r2.isBBPSCategoryLogoEnabled()
            r3 = 1
            if (r2 != r3) goto L_0x0035
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0035
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)
            if (r2 == 0) goto L_0x0035
            r4.a((java.lang.String) r0)
            return
        L_0x0035:
            r4.a((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.Z():void");
    }

    private final void aa() {
        CustomSwitch customSwitch = this.N;
        if (customSwitch != null) {
            customSwitch.setChecked(false);
        }
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            ai.b(viewGroup);
        }
        this.L = false;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) b(R.id.edit_no);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setVisibility(8);
        }
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout != null) {
            customInputLinearLayout.k();
        }
        Z();
    }

    public final void a(String str, CJRRechargeCart cJRRechargeCart, String str2, Boolean bool, String str3, String str4) {
        super.a(str, cJRRechargeCart, str2, bool, str3, str4);
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            gVar.D = false;
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            gVar2.E = false;
        }
        new Handler().postDelayed(new x(this), 300);
    }

    public void F() {
        CustomInputLinearLayout customInputLinearLayout;
        String str;
        if (getActivity() != null) {
            az azVar = az.f61525a;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            Context context = activity;
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (gVar != null) {
                str = gVar.A;
            } else {
                str = null;
            }
            if (az.e(context, str)) {
                RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward);
                if (relativeLayout != null) {
                    ai.b(relativeLayout);
                    return;
                }
                return;
            }
        }
        if (this.f61341h && (customInputLinearLayout = this.r) != null && customInputLinearLayout.j()) {
            RelativeLayout relativeLayout2 = (RelativeLayout) b(R.id.lyt_fast_forward);
            kotlin.g.b.k.a((Object) relativeLayout2, "lyt_fast_forward");
            ai.a(relativeLayout2);
            if (this.m) {
                CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
                kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
                checkBox.setChecked(true);
                G();
                this.m = false;
                return;
            }
            CheckBox checkBox2 = (CheckBox) b(R.id.radio_fast_forward);
            kotlin.g.b.k.a((Object) checkBox2, "radio_fast_forward");
            checkBox2.setChecked(false);
            G();
        }
    }

    public void G() {
        String amount;
        if (isAdded()) {
            if (this.F) {
                Button button = (Button) b(R.id.btn_proceed);
                kotlin.g.b.k.a((Object) button, "btn_proceed");
                button.setText(getResources().getString(R.string.utility_proceed));
            } else if (this.n) {
                CJRUtilityPrefetchV2 H2 = H();
                CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward);
                kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward");
                String str = null;
                if (checkBox.isChecked()) {
                    CustomInputLinearLayout customInputLinearLayout = this.r;
                    if (customInputLinearLayout == null || (amount = customInputLinearLayout.getAmount()) == null || !kotlin.m.p.a(amount)) {
                        CustomInputLinearLayout customInputLinearLayout2 = this.r;
                        if (ba.g(customInputLinearLayout2 != null ? customInputLinearLayout2.getAmount() : null)) {
                            Button button2 = (Button) b(R.id.btn_proceed);
                            kotlin.g.b.k.a((Object) button2, "btn_proceed");
                            Resources resources = getResources();
                            int i2 = R.string.proceed_btn_ff_selected;
                            Object[] objArr = new Object[1];
                            CustomInputLinearLayout customInputLinearLayout3 = this.r;
                            if (customInputLinearLayout3 != null) {
                                str = customInputLinearLayout3.getAmount();
                            }
                            objArr[0] = ba.a(str, true);
                            button2.setText(resources.getString(i2, objArr));
                            return;
                        }
                    }
                    if (H2 == null) {
                        Button button3 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button3, "btn_proceed");
                        button3.setText(getResources().getString(R.string.utility_proceed));
                    } else if (this.o != null) {
                        Button button4 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button4, "btn_proceed");
                        button4.setText(H2.getPost());
                    } else {
                        Button button5 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button5, "btn_proceed");
                        button5.setText(H2.getPre());
                    }
                } else {
                    CustomInputLinearLayout customInputLinearLayout4 = this.r;
                    if (customInputLinearLayout4 != null) {
                        if (ba.g(customInputLinearLayout4 != null ? customInputLinearLayout4.getAmount() : null)) {
                            CustomInputLinearLayout customInputLinearLayout5 = this.r;
                            if (customInputLinearLayout5 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (customInputLinearLayout5.getVendingCharges() > 0) {
                                Button button6 = (Button) b(R.id.btn_proceed);
                                kotlin.g.b.k.a((Object) button6, "btn_proceed");
                                Resources resources2 = getResources();
                                int i3 = R.string.proceed_btn_ff_selected;
                                Object[] objArr2 = new Object[1];
                                CustomInputLinearLayout customInputLinearLayout6 = this.r;
                                if (customInputLinearLayout6 != null) {
                                    str = customInputLinearLayout6.getAmount();
                                }
                                objArr2[0] = ba.a(str, true);
                                button6.setText(resources2.getString(i3, objArr2));
                                return;
                            }
                        }
                    }
                    if (H2 == null) {
                        Button button7 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button7, "btn_proceed");
                        button7.setText(getResources().getString(R.string.utility_proceed));
                    } else if (this.o != null) {
                        Button button8 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button8, "btn_proceed");
                        button8.setText(H2.getPost());
                    } else {
                        Button button9 = (Button) b(R.id.btn_proceed);
                        kotlin.g.b.k.a((Object) button9, "btn_proceed");
                        button9.setText(H2.getPre());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0 = r0.get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2 H() {
        /*
            r5 = this;
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            if (r0 == 0) goto L_0x0115
            r2 = 1
            if (r0 == 0) goto L_0x0099
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0099
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r5.p
            if (r0 == 0) goto L_0x0099
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0099
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r5.p
            r3 = 0
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getPrefetch()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.y
            if (r0 == 0) goto L_0x0045
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r0 = r0.getButtonObject()
            if (r0 == 0) goto L_0x0045
            java.util.Map r0 = r0.getPrefetchMap()
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.y
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r0 = r0.getButtonObject()
            if (r0 == 0) goto L_0x0099
            java.util.Map r0 = r0.getPrefetchMap()
            if (r0 == 0) goto L_0x0099
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r5.p
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x0069
            java.lang.String r4 = r4.getPrefetch()
            goto L_0x006a
        L_0x0069:
            r4 = r1
        L_0x006a:
            boolean r0 = r0.containsKey(r4)
            if (r0 != r2) goto L_0x0099
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.y
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r0 = r0.getButtonObject()
            if (r0 == 0) goto L_0x0099
            java.util.Map r0 = r0.getPrefetchMap()
            if (r0 == 0) goto L_0x0099
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r5.p
            if (r4 == 0) goto L_0x0091
            java.lang.Object r3 = r4.get(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x0091
            java.lang.String r3 = r3.getPrefetch()
            goto L_0x0092
        L_0x0091:
            r3 = r1
        L_0x0092:
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2) r0
            goto L_0x009a
        L_0x0099:
            r0 = r1
        L_0x009a:
            if (r0 != 0) goto L_0x0114
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r5.y
            if (r3 == 0) goto L_0x00ab
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r3 = r3.getButtonObject()
            if (r3 == 0) goto L_0x00ab
            java.util.Map r3 = r3.getPrefetchMap()
            goto L_0x00ac
        L_0x00ab:
            r3 = r1
        L_0x00ac:
            if (r3 == 0) goto L_0x0114
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r5.y
            if (r3 == 0) goto L_0x00e1
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r3 = r3.getButtonObject()
            if (r3 == 0) goto L_0x00e1
            java.util.Map r3 = r3.getPrefetchMap()
            if (r3 == 0) goto L_0x00e1
            java.lang.String r4 = "0"
            boolean r3 = r3.containsKey(r4)
            if (r3 != r2) goto L_0x00e1
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.y
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r0 = r0.getButtonObject()
            if (r0 == 0) goto L_0x00d4
            java.util.Map r1 = r0.getPrefetchMap()
        L_0x00d4:
            if (r1 != 0) goto L_0x00d9
            kotlin.g.b.k.a()
        L_0x00d9:
            java.lang.Object r0 = r1.get(r4)
            r1 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2) r1
            goto L_0x0115
        L_0x00e1:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r5.y
            if (r3 == 0) goto L_0x0114
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r3 = r3.getButtonObject()
            if (r3 == 0) goto L_0x0114
            java.util.Map r3 = r3.getPrefetchMap()
            if (r3 == 0) goto L_0x0114
            java.lang.String r4 = "1"
            boolean r3 = r3.containsKey(r4)
            if (r3 != r2) goto L_0x0114
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.y
            if (r0 == 0) goto L_0x0107
            net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r0 = r0.getButtonObject()
            if (r0 == 0) goto L_0x0107
            java.util.Map r1 = r0.getPrefetchMap()
        L_0x0107:
            if (r1 != 0) goto L_0x010c
            kotlin.g.b.k.a()
        L_0x010c:
            java.lang.Object r0 = r1.get(r4)
            r1 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2) r1
            goto L_0x0115
        L_0x0114:
            r1 = r0
        L_0x0115:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.H():net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2");
    }

    public final void a(String str, CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment, Object obj) {
        super.a(str, cJRRechargeCart, cJRRechargePayment, obj);
        t();
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61362a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRechargeCart f61363b;

        r(o oVar, CJRRechargeCart cJRRechargeCart) {
            this.f61362a = oVar;
            this.f61363b = cJRRechargeCart;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            kotlin.g.b.k.a((Object) view, "v");
            if (view.getId() == R.id.action_button) {
                net.one97.paytm.recharge.common.h.g gVar = this.f61362a.f61339f;
                if (!(gVar == null || (dVar = gVar.v) == null)) {
                    String e2 = this.f61362a.ai();
                    a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, net.one97.paytm.recharge.automatic.b.a.a.o, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                }
                z.a(this.f61363b, this.f61362a.getContext(), this.f61362a.Z);
                return;
            }
            int i2 = R.id.close;
        }
    }

    public final void a(CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, Object obj) {
        t();
        super.a(cJRRechargePayment, cJRRechargeCart, obj);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        if (!com.paytm.utility.b.c(getContext())) {
            J();
            return;
        }
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            if (gVar == null) {
                kotlin.g.b.k.a();
            }
            if (gVar.D) {
                return;
            }
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            gVar2.D = true;
        }
        this.m = true;
        X();
        net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
        if (!(gVar3 == null || (dVar = gVar3.v) == null)) {
            String ai = ai();
            String str = ab.f61496a;
            kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, "recents_selected", (Object) null, (Object) null, str, (Object) null, (Object) null, 108);
        }
        Map<String, String> map = null;
        this.H.put(StringSet.operator, cJRFrequentOrder != null ? cJRFrequentOrder.getOperator() : null);
        this.H.put("productId", cJRFrequentOrder != null ? cJRFrequentOrder.getProductID() : null);
        this.H.put("rechargeNumber", cJRFrequentOrder != null ? cJRFrequentOrder.getRechargeNumber() : null);
        if (cJRFrequentOrder != null) {
            map = cJRFrequentOrder.getProductAttributes();
        }
        if (map != null && kotlin.m.p.a("merchant_loan_account", cJRFrequentOrder.getProductAttributes().get("merchant_loan_account"), true)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            this.H.put("productId", net.one97.paytm.recharge.di.helper.c.bs());
        }
        net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
        if (gVar4 != null) {
            gVar4.a(cJRFrequentOrder);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.parent_scroll);
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.f61409b).getCategoryData();
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final net.one97.paytm.common.entity.recharge.CJRFrequentOrder ab() {
        /*
            r9 = this;
            net.one97.paytm.recharge.common.h.g r0 = r9.f61339f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0018
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isPreFillFirstRecentEnabled()
            if (r0 != r2) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            net.one97.paytm.recharge.common.h.g r3 = r9.f61339f
            r4 = 0
            if (r3 == 0) goto L_0x002f
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r3.f61409b
            if (r3 == 0) goto L_0x002f
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.getCategoryData()
            if (r3 == 0) goto L_0x002f
            java.lang.String r3 = r3.getDisplayName()
            if (r3 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = r4
        L_0x0030:
            net.one97.paytm.recharge.common.h.g r5 = r9.f61339f
            if (r5 == 0) goto L_0x0091
            if (r5 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.m
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0091
            net.one97.paytm.recharge.common.h.g r5 = r9.f61339f
            if (r5 != 0) goto L_0x0048
            kotlin.g.b.k.a()
        L_0x0048:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.m
            java.util.Map r5 = (java.util.Map) r5
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
            r6 = 0
        L_0x0055:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x007e
            java.lang.Object r7 = r5.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            net.one97.paytm.recharge.common.h.g r8 = r9.f61339f
            if (r8 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r8.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r8.getCategoryData()
            if (r8 == 0) goto L_0x0055
            java.lang.Object r7 = r7.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r8.isGroupPresentInCategory(r7)
            if (r7 != r2) goto L_0x0055
            r6 = 1
            goto L_0x0055
        L_0x007e:
            net.one97.paytm.recharge.common.h.g r5 = r9.f61339f
            if (r5 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.m
            java.lang.String r7 = "productId"
            boolean r5 = r5.containsKey(r7)
            if (r5 == 0) goto L_0x0092
            r6 = 1
            goto L_0x0092
        L_0x0091:
            r6 = 0
        L_0x0092:
            if (r0 == 0) goto L_0x00b7
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x009f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00a0
        L_0x009f:
            r1 = 1
        L_0x00a0:
            if (r1 != 0) goto L_0x00b7
            boolean r0 = r9.E
            if (r0 != 0) goto L_0x00b7
            if (r6 != 0) goto L_0x00b7
            net.one97.paytm.recharge.legacy.catalog.fragment.d r0 = r9.t
            if (r0 == 0) goto L_0x00b7
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = net.one97.paytm.recharge.legacy.catalog.fragment.d.a((android.app.Activity) r0, (java.lang.String) r3)
            return r0
        L_0x00b7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.ab():net.one97.paytm.common.entity.recharge.CJRFrequentOrder");
    }

    public final void a(boolean z2) {
        CJRCategoryData cJRCategoryData = this.y;
        TopLevelCategoryHeader topLevelCategoryHeader = cJRCategoryData != null ? cJRCategoryData.getTopLevelCategoryHeader() : null;
        if (z2 && topLevelCategoryHeader != null && !TextUtils.isEmpty(topLevelCategoryHeader.title) && !TextUtils.isEmpty(topLevelCategoryHeader.description)) {
            CJRAutomaticCLPStripView cJRAutomaticCLPStripView = (CJRAutomaticCLPStripView) b(R.id.automatic_banner_parent);
            String str = topLevelCategoryHeader.title;
            kotlin.g.b.k.a((Object) str, "categoryHeader.title");
            String str2 = topLevelCategoryHeader.description;
            kotlin.g.b.k.a((Object) str2, "categoryHeader.description");
            kotlin.g.b.k.c(str, "title");
            kotlin.g.b.k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            cJRAutomaticCLPStripView.setVisibility(0);
            TextView textView = (TextView) cJRAutomaticCLPStripView.a(R.id.image_automatic_heading);
            kotlin.g.b.k.a((Object) textView, "image_automatic_heading");
            textView.setText(str);
            TextView textView2 = (TextView) cJRAutomaticCLPStripView.a(R.id.image_automatic_subheading);
            kotlin.g.b.k.a((Object) textView2, "image_automatic_subheading");
            textView2.setText(str2);
        }
    }

    public final void e() {
        ((LinearLayout) b(R.id.main_content_layout)).addView(new CJRRBIComplianceView(getContext(), true, true, (byte) 0), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r13, net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r14, java.lang.String r15) {
        /*
            r12 = this;
            java.lang.String r0 = "inputView"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "inputField"
            kotlin.g.b.k.c(r14, r0)
            net.one97.paytm.recharge.common.h.g r0 = r12.f61339f
            r1 = 0
            if (r0 == 0) goto L_0x0030
            java.lang.String r2 = r14.getConfigKey()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0021
            int r3 = r3.length()
            if (r3 != 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = 0
            goto L_0x0022
        L_0x0021:
            r3 = 1
        L_0x0022:
            if (r3 == 0) goto L_0x0025
            goto L_0x0030
        L_0x0025:
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper> r0 = r0.G
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = (net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper) r0
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            if (r0 != 0) goto L_0x008c
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r8 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r8.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r8.getFlowName()
            if (r1 == 0) goto L_0x004d
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x004d:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r8.getFlowName()
            if (r1 == 0) goto L_0x005c
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.INP_GRP_CAT
            java.lang.String r2 = r2.name()
            r1.setActionType(r2)
        L_0x005c:
            net.one97.paytm.recharge.common.h.g r1 = r12.f61339f
            if (r1 == 0) goto L_0x008b
            java.lang.String r9 = r14.getGroupingCategoryId()
            if (r9 != 0) goto L_0x0069
            kotlin.g.b.k.a()
        L_0x0069:
            net.one97.paytm.recharge.common.fragment.o$p r10 = new net.one97.paytm.recharge.common.fragment.o$p
            r2 = r10
            r3 = r12
            r4 = r13
            r5 = r0
            r6 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            net.one97.paytm.recharge.common.e.ai r10 = (net.one97.paytm.recharge.common.e.ai) r10
            net.one97.paytm.recharge.common.fragment.o$q r11 = new net.one97.paytm.recharge.common.fragment.o$q
            r2 = r11
            r4 = r0
            r5 = r14
            r6 = r15
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r7 = r11
            net.one97.paytm.recharge.common.b.a.a r7 = (net.one97.paytm.recharge.common.b.a.a) r7
            java.lang.String r4 = "getCategory"
            r3 = r1
            r5 = r9
            r6 = r10
            r3.a((java.lang.String) r4, (java.lang.String) r5, (net.one97.paytm.recharge.common.e.ai) r6, (net.one97.paytm.recharge.common.b.a.a) r7, (java.lang.Object) r8)
        L_0x008b:
            return
        L_0x008c:
            java.lang.String r13 = r14.getConfigKey()
            r12.a((java.lang.String) r13, (net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper) r0, (java.lang.String) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(android.view.View, net.one97.paytm.recharge.model.v4.CJRInputFieldsItem, java.lang.String):void");
    }

    public static final class p implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61352a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f61353b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRCategoryDataHelper f61354c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f61355d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f61356e;

        p(o oVar, View view, CJRCategoryDataHelper cJRCategoryDataHelper, CJRInputFieldsItem cJRInputFieldsItem, String str) {
            this.f61352a = oVar;
            this.f61353b = view;
            this.f61354c = cJRCategoryDataHelper;
            this.f61355d = cJRInputFieldsItem;
            this.f61356e = str;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f61353b.setEnabled(true);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            o.a(this.f61352a, iJRPaytmDataModel, this.f61355d.getGroupingCategoryId(), this.f61355d, this.f61356e, this.f61353b);
        }
    }

    public static final class q implements net.one97.paytm.recharge.common.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61357a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRCategoryDataHelper f61358b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f61359c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f61360d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f61361e;

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        }

        q(o oVar, CJRCategoryDataHelper cJRCategoryDataHelper, CJRInputFieldsItem cJRInputFieldsItem, String str, View view) {
            this.f61357a = oVar;
            this.f61358b = cJRCategoryDataHelper;
            this.f61359c = cJRInputFieldsItem;
            this.f61360d = str;
            this.f61361e = view;
        }

        public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
            o.a(this.f61357a, iJRPaytmDataModel, this.f61359c.getGroupingCategoryId(), this.f61359c, this.f61360d, this.f61361e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r16, net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r17, java.lang.String r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            java.lang.String r2 = "dataHelper"
            kotlin.g.b.k.c(r1, r2)
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r17.getCategoryData()
            r3 = -1
            if (r2 == 0) goto L_0x0014
            int r2 = r2.getGroupLevel()
            goto L_0x0015
        L_0x0014:
            r2 = -1
        L_0x0015:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r17.getCategoryData()
            r11 = 0
            if (r4 == 0) goto L_0x0028
            net.one97.paytm.recharge.model.v4.CJRGroupings r4 = r4.getGroupings()
            if (r4 == 0) goto L_0x0028
            java.lang.String r4 = r4.getAggKey()
            r12 = r4
            goto L_0x0029
        L_0x0028:
            r12 = r11
        L_0x0029:
            if (r2 == r3) goto L_0x01b8
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x003b
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r3 = 0
            goto L_0x003c
        L_0x003b:
            r3 = 1
        L_0x003c:
            if (r3 != 0) goto L_0x01b8
            boolean r3 = r15.isAdded()
            if (r3 == 0) goto L_0x01b8
            androidx.fragment.app.FragmentActivity r3 = r15.getActivity()
            if (r3 == 0) goto L_0x01b8
            if (r12 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.util.List r3 = r1.getGroupItemList(r2, r12)
            java.lang.String r6 = "operator"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r12, (boolean) r5)
            if (r6 == 0) goto L_0x0126
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r6 = r0.p
            if (r6 == 0) goto L_0x0126
            if (r6 != 0) goto L_0x0064
            kotlin.g.b.k.a()
        L_0x0064:
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r5
            if (r6 == 0) goto L_0x0126
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r6 = r0.p
            if (r6 != 0) goto L_0x0074
            kotlin.g.b.k.a()
        L_0x0074:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            if (r6 == 0) goto L_0x0081
            java.lang.String r6 = r6.getOperator()
            goto L_0x0082
        L_0x0081:
            r6 = r11
        L_0x0082:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0126
            if (r3 == 0) goto L_0x0126
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r5
            if (r7 == 0) goto L_0x0126
            r7 = r3
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00a5:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00c0
            java.lang.Object r9 = r7.next()
            r10 = r9
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r10
            java.lang.String r10 = r10.getValue()
            boolean r10 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r10, (boolean) r5)
            if (r10 == 0) goto L_0x00a5
            r8.add(r9)
            goto L_0x00a5
        L_0x00c0:
            java.util.List r8 = (java.util.List) r8
            r6 = r8
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x0126
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r13 = new net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem
            java.lang.Object r5 = r8.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r5
            java.lang.String r7 = r5.getDisplayValue()
            java.lang.Object r5 = r8.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r5
            java.lang.String r9 = r5.getValue()
            java.lang.Object r4 = r8.get(r4)
            r10 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r10
            java.lang.String r6 = "inputGrouping"
            r4 = r13
            r5 = r12
            r8 = r9
            r9 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r1.addSelectedGroupItem(r2, r13)
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r17.getCategoryData()
            if (r4 == 0) goto L_0x0100
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r4 = r4.getNextGroupItemData()
            goto L_0x0101
        L_0x0100:
            r4 = r11
        L_0x0101:
            if (r4 == 0) goto L_0x0126
            int r3 = r4.getGroupLevel()
            java.lang.String r5 = r4.getGroupName()
            if (r5 != 0) goto L_0x0110
            kotlin.g.b.k.a()
        L_0x0110:
            java.lang.String r3 = r1.getGroupingTitle((int) r3, (java.lang.String) r5)
            int r5 = r4.getGroupLevel()
            java.lang.String r4 = r4.getGroupName()
            if (r4 != 0) goto L_0x0121
            kotlin.g.b.k.a()
        L_0x0121:
            java.util.List r4 = r1.getGroupItemList(r5, r4)
            goto L_0x012b
        L_0x0126:
            java.lang.String r4 = ""
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x012b:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0138
            java.lang.String r3 = r1.getGroupingTitle((int) r2, (java.lang.String) r12)
        L_0x0138:
            net.one97.paytm.recharge.common.utils.y r5 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r4)
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper) r17)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "fieldSelected: [groupLevel-"
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = "] [groupName-"
            r4.append(r2)
            r4.append(r12)
            r2 = 93
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r1.debugLog(r2)
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0169
            java.lang.String r1 = r1.A
            goto L_0x016a
        L_0x0169:
            r1 = r11
        L_0x016a:
            android.content.Intent r2 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r4 = r15.getActivity()
            android.content.Context r4 = (android.content.Context) r4
            boolean r5 = r0.F
            java.lang.String r6 = "inputGrouping"
            java.lang.Class r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r6, (boolean) r5, (java.lang.String) r1)
            r2.<init>(r4, r5)
            java.lang.String r4 = "title"
            r2.putExtra(r4, r3)
            java.lang.String r3 = "list_type"
            r2.putExtra(r3, r6)
            boolean r3 = r0.F
            java.lang.String r4 = "open_activity_in_automatic_mode"
            r2.putExtra(r4, r3)
            java.lang.String r3 = r0.f61111c
            java.lang.String r4 = "category_name"
            r2.putExtra(r4, r3)
            java.lang.String r3 = "extra_config_key"
            r4 = r16
            r2.putExtra(r3, r4)
            net.one97.paytm.recharge.common.h.g r3 = r0.f61339f
            if (r3 == 0) goto L_0x01a2
            java.lang.String r11 = r3.F
        L_0x01a2:
            java.lang.String r3 = "extra_tracking_id"
            r2.putExtra(r3, r11)
            java.lang.String r3 = "category id"
            r2.putExtra(r3, r1)
            java.lang.String r1 = "image url"
            r3 = r18
            r2.putExtra(r1, r3)
            r1 = 607(0x25f, float:8.5E-43)
            r15.startActivityForResult(r2, r1)
        L_0x01b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(java.lang.String, net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper, java.lang.String):void");
    }

    public final void a(List<? extends CJRPaymentOptions> list, CJRPaymentOptions cJRPaymentOptions) {
        String str;
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append(o.class.getName());
        sb.append(" openPaymentOptionsSelectionActivity ");
        if (cJRPaymentOptions == null || (str = cJRPaymentOptions.getLabel()) == null) {
            str = "";
        }
        sb.append(str);
        cJRRechargeUtilities.debugLog(sb.toString());
        Intent intent = new Intent(getActivity(), AJRAmountSelectionActivity.class);
        if (list != null) {
            intent.putExtra("intent_extra_payment_options", (Serializable) list);
            intent.putExtra("intent_extra_selected_amount", cJRPaymentOptions);
            startActivityForResult(intent, 605);
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type java.io.Serializable");
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        Button button = (Button) b(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) button, "btn_proceed");
        button.setText(str);
    }

    public final void d(boolean z2) {
        this.n = z2;
    }

    public final void c(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        kotlin.g.b.k.c(str, "message");
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout == null || !customInputLinearLayout.i()) {
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (gVar != null && (dVar = gVar.v) != null) {
                String ai = ai();
                String str2 = ab.f61496a;
                kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, "proceed_to_fetch_error", (Object) null, str, str2, (Object) null, (Object) null, 100);
                return;
            }
            return;
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null && (dVar2 = gVar2.v) != null) {
            String ai2 = ai();
            String str3 = ab.f61496a;
            kotlin.g.b.k.a((Object) str3, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, ai2, "proceed_error", (Object) null, str, str3, (Object) null, (Object) null, 100);
        }
    }

    public final void d(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null && (dVar = gVar.v) != null) {
            String ai = ai();
            String a2 = kotlin.g.b.k.a(str, (Object) "_field_clicked");
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, a2, (Object) null, (Object) null, str2, (Object) null, (Object) null, 108);
        }
    }

    public final void e(String str) {
        kotlin.g.b.k.c(str, "error");
        this.P = str;
    }

    public final void a(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage) {
        if (cJRSuccessRateAlertMessage != null && !TextUtils.isEmpty(cJRSuccessRateAlertMessage.getMessage())) {
            TextView textView = (TextView) b(R.id.success_rate_alert_message_text_view);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) b(R.id.success_rate_alert_message_text_view);
            if (textView2 != null) {
                textView2.setText(cJRSuccessRateAlertMessage.getMessage());
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.INLINE_ERROR.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
            }
            az azVar = az.f61525a;
            az.a(a2);
        }
    }

    public final void a(CJRRelatedCategory cJRRelatedCategory) {
        kotlin.g.b.k.c(cJRRelatedCategory, "rc");
        String value = cJRRelatedCategory.getValue();
        if (value == null) {
            value = "";
        }
        this.l = value;
    }

    public final void I() {
        String str;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        CJRCategoryData categoryData;
        net.one97.paytm.recharge.legacy.catalog.fragment.d dVar = this.t;
        if (dVar != null) {
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (gVar != null) {
                str = gVar.A;
            } else {
                str = null;
            }
            net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
            String a2 = gVar2 != null ? gVar2.a() : null;
            net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
            dVar.a(str, a2, (gVar3 == null || (cJRCategoryDataHelper = gVar3.f61409b) == null || (categoryData = cJRCategoryDataHelper.getCategoryData()) == null) ? null : categoryData.getVerticalId());
        }
        net.one97.paytm.recharge.common.h.g gVar4 = this.f61339f;
        if (gVar4 != null) {
            if (gVar4 == null) {
                kotlin.g.b.k.a();
            }
            if (!gVar4.p) {
                net.one97.paytm.recharge.common.h.g gVar5 = this.f61339f;
                if (gVar5 == null) {
                    kotlin.g.b.k.a();
                }
                if (!gVar5.D && !this.E && this.R) {
                    CJRFrequentOrder ab2 = ab();
                    if (ab2 != null) {
                        this.R = false;
                        this.E = true;
                        a(ab2);
                        return;
                    }
                    o oVar = this;
                    oVar.l();
                    oVar.R = false;
                    net.one97.paytm.recharge.common.h.g gVar6 = oVar.f61339f;
                    if (gVar6 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!gVar6.E) {
                        oVar.W();
                        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        a3.setErrorType(ERROR_TYPE.UNDEFINED);
                        CRUFlowModel flowName = a3.getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                        CRUFlowModel flowName2 = a3.getFlowName();
                        if (flowName2 != null) {
                            flowName2.setActionType(ACTION_TYPE.RECENT.name());
                        }
                        net.one97.paytm.recharge.common.h.g gVar7 = oVar.f61339f;
                        if (gVar7 == null) {
                            kotlin.g.b.k.a();
                        }
                        gVar7.a((Object) a3);
                        return;
                    }
                    return;
                }
            }
            l();
            this.R = false;
            net.one97.paytm.recharge.common.h.g gVar8 = this.f61339f;
            if (gVar8 == null) {
                kotlin.g.b.k.a();
            }
            if (!gVar8.E) {
                W();
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a4.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName3 = a4.getFlowName();
                if (flowName3 != null) {
                    flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName4 = a4.getFlowName();
                if (flowName4 != null) {
                    flowName4.setActionType(ACTION_TYPE.RECENT.name());
                }
                net.one97.paytm.recharge.common.h.g gVar9 = this.f61339f;
                if (gVar9 == null) {
                    kotlin.g.b.k.a();
                }
                gVar9.a((Object) a4);
            }
        }
    }

    static final class v implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61367a;

        v(o oVar) {
            this.f61367a = oVar;
        }

        public final void onOkClick() {
            FragmentActivity activity;
            if (this.f61367a.y == null && (activity = this.f61367a.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void J() {
        Resources resources;
        Resources resources2;
        com.paytm.utility.g.a((g.a) new v(this));
        boolean z2 = this.y != null;
        if (this.y != null || !this.U) {
            az azVar = az.f61525a;
            Context context = getContext();
            ERROR_TYPE error_type = ERROR_TYPE.NO_CONNECTION;
            Context context2 = getContext();
            String str = null;
            String string = (context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getString(R.string.no_connection);
            Context context3 = getContext();
            if (!(context3 == null || (resources = context3.getResources()) == null)) {
                str = resources.getString(R.string.no_internet);
            }
            az.a(context, error_type, (ACTION_TYPE) null, string, str, z2, (String) null, (String) null, 960);
            return;
        }
        ac();
    }

    private final void ac() {
        net.one97.paytm.recharge.metro.c.p pVar = new net.one97.paytm.recharge.metro.c.p();
        pVar.a(new w(this, pVar));
        if (isAdded() && !isDetached()) {
            getChildFragmentManager();
            net.one97.paytm.recharge.common.utils.am.a(getChildFragmentManager().a().a(R.id.no_network_container, pVar, ""));
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.no_network_container);
            if (relativeLayout != null) {
                ai.a(relativeLayout);
            }
        }
    }

    static final class w implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61368a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.metro.c.p f61369b;

        w(o oVar, net.one97.paytm.recharge.metro.c.p pVar) {
            this.f61368a = oVar;
            this.f61369b = pVar;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f61368a.C >= 2000) {
                this.f61368a.C = SystemClock.elapsedRealtime();
                if (com.paytm.utility.b.c((Context) this.f61368a.getActivity())) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a2.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName = a2.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.RETRY_CLICKED.name());
                    }
                    net.one97.paytm.recharge.common.h.g gVar = this.f61368a.f61339f;
                    if (gVar != null) {
                        gVar.b("getCategory", a2);
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) this.f61368a.b(R.id.no_network_container);
                    if (relativeLayout != null) {
                        ai.b(relativeLayout);
                    }
                    this.f61368a.getChildFragmentManager().a().a((Fragment) this.f61369b).b();
                }
            }
        }
    }

    private final void ad() {
        if (!z.a(getContext()) || !com.paytm.utility.b.c(getContext()) || TextUtils.isEmpty(com.paytm.utility.b.n((Context) getActivity()))) {
            ViewGroup viewGroup = this.M;
            if (viewGroup != null) {
                ai.b(viewGroup);
                return;
            }
            return;
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
            flowName2.setActionType(ACTION_TYPE.BILL_CONSENT.name());
        }
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            gVar.b("fetch_get_user_consent", this.H, a2);
        }
    }

    public final void a(androidx.fragment.app.b bVar) {
        net.one97.paytm.recharge.common.h.g gVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        kotlin.g.b.k.c(bVar, "fragment");
        j();
        if (!(TextUtils.isEmpty(ag()) || (gVar = this.f61339f) == null || (dVar = gVar.v) == null)) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ag(), "i_clicked", (Object) null, (Object) null, "cylinder_booking", (Object) null, (Object) null, 108);
        }
        new Handler().postDelayed(new u(this, bVar), 100);
    }

    static final class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61365a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.b f61366b;

        u(o oVar, androidx.fragment.app.b bVar) {
            this.f61365a = oVar;
            this.f61366b = bVar;
        }

        public final void run() {
            this.f61366b.show(this.f61365a.getChildFragmentManager(), "Alert");
        }
    }

    public final String r() {
        CJRExtensionAttributes extnAttrs;
        CJRCategoryData cJRCategoryData = this.y;
        if (cJRCategoryData == null || (extnAttrs = cJRCategoryData.getExtnAttrs()) == null) {
            return null;
        }
        return extnAttrs.getErrorImage();
    }

    public final String s() {
        CJRExtensionAttributes extnAttrs;
        CJRCategoryData cJRCategoryData = this.y;
        if (cJRCategoryData == null || (extnAttrs = cJRCategoryData.getExtnAttrs()) == null) {
            return null;
        }
        return extnAttrs.getErrorType();
    }

    public final void a(CJRRechargeData cJRRechargeData, String str, boolean z2, String str2) {
        String str3;
        CJRProductList productList;
        CJRProductList productList2;
        kotlin.g.b.k.c(cJRRechargeData, "data");
        kotlin.g.b.k.c(str, "type");
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), AJRBrowsePlanActivity.class);
            intent.putExtra(StringSet.operator, cJRRechargeData.getOperator());
            intent.putExtra("operator_display", cJRRechargeData.getOperatorDisplay());
            intent.putExtra("circle", cJRRechargeData.getCircle());
            String productId = cJRRechargeData.getProductId();
            String str4 = null;
            intent.putExtra(CLPConstants.PRODUCT_ID, productId != null ? Long.valueOf(Long.parseLong(productId)) : null);
            intent.putExtra(SDKConstants.EVENT_KEY_SCREEN_NAME, ai());
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (gVar != null) {
                str3 = gVar.A;
            } else {
                str3 = null;
            }
            intent.putExtra("category_id", str3);
            if (z2 && str2 != null) {
                boolean z3 = true;
                intent.putExtra("made_for_you_flag", true);
                intent.putExtra("recharge_number", str2);
                CustomInputLinearLayout customInputLinearLayout = this.r;
                Collection products = (customInputLinearLayout == null || (productList2 = customInputLinearLayout.getProductList()) == null) ? null : productList2.getProducts();
                if (products != null && !products.isEmpty()) {
                    z3 = false;
                }
                if (!z3) {
                    CustomInputLinearLayout customInputLinearLayout2 = this.r;
                    List<CJRProductsItem> products2 = (customInputLinearLayout2 == null || (productList = customInputLinearLayout2.getProductList()) == null) ? null : productList.getProducts();
                    if (products2 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem = products2.get(0);
                    intent.putExtra("one2one_tab_title", cJRProductsItem != null ? cJRProductsItem.getDynamicPlanCategoryLabel() : null);
                    CustomInputLinearLayout customInputLinearLayout3 = this.r;
                    CJRProductList productList3 = customInputLinearLayout3 != null ? customInputLinearLayout3.getProductList() : null;
                    if (productList3 == null) {
                        kotlin.g.b.k.a();
                    }
                    List<CJRProductsItem> products3 = productList3.getProducts();
                    if (products3 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem2 = products3.get(0);
                    if (cJRProductsItem2 != null) {
                        str4 = cJRProductsItem2.getOffersForYouDisclaimer();
                    }
                    intent.putExtra("one2one_disclaimer", str4);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(AppManagerUtil.EXTEND_TYPE, str);
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            new net.one97.paytm.recharge.common.utils.t(activity).a();
            startActivityForResult(intent, 2);
        }
    }

    public final void a(String str, long j2, String str2) {
        String str3;
        HashMap<Integer, CJRBrowsePlanDescriptions> hashMap;
        kotlin.g.b.k.c(str, "rechargeNumber");
        kotlin.g.b.k.c(str2, StringSet.operator);
        if (isAdded()) {
            Intent intent = new Intent(getActivity(), AJRBrowsePlanActivity.class);
            intent.putExtra(AJRBrowsePlanActivity.f60738a, true);
            intent.putExtra("recharge_number", str);
            intent.putExtra(CLPConstants.PRODUCT_ID, j2);
            intent.putExtra(SDKConstants.EVENT_KEY_SCREEN_NAME, ai());
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            CJRBrowsePlansHeader cJRBrowsePlansHeader = null;
            if (gVar != null) {
                str3 = gVar.A;
            } else {
                str3 = null;
            }
            intent.putExtra("category_id", str3);
            CJRItem cJRItem = this.f61340g;
            intent.putExtra(AppManagerUtil.EXTEND_TYPE, cJRItem != null ? cJRItem.getURLType() : null);
            intent.putExtra(StringSet.operator, str2);
            net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
            if (gVar2 != null) {
                hashMap = gVar2.J;
            } else {
                hashMap = null;
            }
            intent.putExtra("ContentMap", hashMap);
            net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
            if (gVar3 != null) {
                cJRBrowsePlansHeader = gVar3.K;
            }
            intent.putExtra("browsePlanHeader", cJRBrowsePlansHeader);
            startActivityForResult(intent, 2);
        }
    }

    public final void a(String str, long j2) {
        HashMap<Integer, CJRBrowsePlanDescriptions> hashMap;
        CJRBrowsePlansHeader cJRBrowsePlansHeader;
        kotlin.g.b.k.c(str, "rechargeNumber");
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            hashMap = gVar.J;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
            if (gVar2 != null) {
                cJRBrowsePlansHeader = gVar2.K;
            } else {
                cJRBrowsePlansHeader = null;
            }
            if (cJRBrowsePlansHeader == null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.BROWSE_PLAN.name());
                }
                net.one97.paytm.recharge.common.h.g gVar3 = this.f61339f;
                if (gVar3 != null) {
                    net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                    String G2 = net.one97.paytm.recharge.di.helper.c.G();
                    kotlin.g.b.k.c("fetch_dynamic_plan", "tag");
                    kotlin.g.b.k.c(str, "rechargeNumber");
                    gVar3.s.a("fetch_dynamic_plan", (net.one97.paytm.recharge.common.e.ai) gVar3, G2, str, j2, (Object) a2);
                }
            }
        }
    }

    public final void K() {
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            gVar.J = null;
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            gVar2.K = null;
        }
    }

    private final void ae() {
        CustomSwitch customSwitch;
        if (!TextUtils.isEmpty(com.paytm.utility.b.n((Context) getActivity()))) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.BILL_CONSENT.name());
            }
            CustomSwitch customSwitch2 = this.N;
            if (customSwitch2 != null && customSwitch2.isChecked() && z.a(getContext()) && com.paytm.utility.b.c(getContext()) && !this.L) {
                net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                if (gVar != null) {
                    gVar.a("fetch_set_user_consent", this.H, (Object) a2);
                }
            } else if (this.A && (customSwitch = this.N) != null && !customSwitch.isChecked() && this.L) {
                af();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        r5 = r5.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void af() {
        /*
            r8 = this;
            android.content.Context r0 = r8.getContext()
            if (r0 == 0) goto L_0x00f2
            android.content.Context r0 = r8.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x00f2
            android.content.Context r0 = r8.getContext()
            boolean r0 = com.paytm.utility.d.c(r0)
            if (r0 == 0) goto L_0x00f2
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r1.put(r2, r3)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r3 = r8.getContext()
            if (r3 != 0) goto L_0x0034
            kotlin.g.b.k.a()
        L_0x0034:
            java.lang.String r4 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r2 = r2.getSSOToken(r3)
            java.lang.String r3 = "sso_token"
            r1.put(r3, r2)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 0
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r5 = r8.p     // Catch:{ JSONException -> 0x00af }
            r6 = 0
            if (r5 == 0) goto L_0x005a
            java.lang.Object r5 = r5.get(r6)     // Catch:{ JSONException -> 0x00af }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5     // Catch:{ JSONException -> 0x00af }
            if (r5 == 0) goto L_0x005a
            java.lang.String r5 = r5.getOperator()     // Catch:{ JSONException -> 0x00af }
            goto L_0x005b
        L_0x005a:
            r5 = r2
        L_0x005b:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x00af }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x00af }
            if (r5 != 0) goto L_0x007a
            java.lang.String r5 = "operator"
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r7 = r8.p     // Catch:{ JSONException -> 0x00af }
            if (r7 == 0) goto L_0x0076
            java.lang.Object r7 = r7.get(r6)     // Catch:{ JSONException -> 0x00af }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r7 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r7     // Catch:{ JSONException -> 0x00af }
            if (r7 == 0) goto L_0x0076
            java.lang.String r7 = r7.getOperator()     // Catch:{ JSONException -> 0x00af }
            goto L_0x0077
        L_0x0076:
            r7 = r2
        L_0x0077:
            r1.put(r5, r7)     // Catch:{ JSONException -> 0x00af }
        L_0x007a:
            java.lang.String r5 = "rechargeNumber"
            java.lang.String r7 = r8.J     // Catch:{ JSONException -> 0x00af }
            r1.put(r5, r7)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r5 = "notificationStatus"
            r1.put(r5, r6)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r5 = "stopBillFetch"
            r6 = 1
            r1.put(r5, r6)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r5 = "customerId"
            android.content.Context r6 = r8.getContext()     // Catch:{ JSONException -> 0x00af }
            java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r6)     // Catch:{ JSONException -> 0x00af }
            r1.put(r5, r6)     // Catch:{ JSONException -> 0x00af }
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r5 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ JSONException -> 0x00af }
            android.content.Context r6 = r8.getContext()     // Catch:{ JSONException -> 0x00af }
            if (r6 != 0) goto L_0x00a4
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x00af }
        L_0x00a4:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r4 = r5.getSSOToken(r6)     // Catch:{ JSONException -> 0x00af }
            r1.put(r3, r4)     // Catch:{ JSONException -> 0x00af }
            goto L_0x00b7
        L_0x00af:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.d(r3)
        L_0x00b7:
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r2.setErrorType(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x00d1
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x00d1:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x00e0
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.BILL_CONSENT
            java.lang.String r4 = r4.name()
            r3.setActionType(r4)
        L_0x00e0:
            net.one97.paytm.recharge.common.h.g r3 = r8.f61339f
            if (r3 == 0) goto L_0x00f2
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "body.toString()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = "fetch_revoke_user_consent"
            r3.a((java.lang.String) r4, (java.lang.String) r1, (java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.Object) r2)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.af():void");
    }

    static final class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f61346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f61347b;

        c(TextView textView, o oVar) {
            this.f61346a = textView;
            this.f61347b = oVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                TextView textView = this.f61346a;
                if (textView != null) {
                    textView.setText(this.f61347b.getString(R.string.bill_reminder_set));
                    return;
                }
                return;
            }
            TextView textView2 = this.f61346a;
            if (textView2 != null) {
                textView2.setText(this.f61347b.getString(R.string.set_bill_reminder));
            }
        }
    }

    private final String ag() {
        CJRCategoryData cJRCategoryData = this.y;
        String valueOf = String.valueOf(cJRCategoryData != null ? cJRCategoryData.getCategoryId() : null);
        if (!kotlin.m.p.a("78640", valueOf, true) && !kotlin.m.p.a("166690", valueOf, true)) {
            return "";
        }
        if (kotlin.m.p.a("gas", this.z, true)) {
        }
        return "gas_pipeline";
    }

    public final boolean L() {
        net.one97.paytm.recharge.common.h.g gVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        if (TextUtils.isEmpty(ag()) || (gVar = this.f61339f) == null || (dVar = gVar.v) == null) {
            return true;
        }
        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ag(), "back_button_clicked", (Object) null, "home_screen", "cylinder_booking", (Object) null, (Object) null, 100);
        return true;
    }

    public void f(String str) {
        TextView textView = (TextView) b(R.id.disclaimer_text_readmore);
        kotlin.g.b.k.a((Object) textView, "disclaimer_text_readmore");
        PreventScrollTextView preventScrollTextView = (PreventScrollTextView) b(R.id.meta_data_desc);
        kotlin.g.b.k.a((Object) preventScrollTextView, "meta_data_desc");
        a(str, textView, (TextView) preventScrollTextView);
    }

    public final void f() {
        S();
    }

    private final Bundle ah() {
        String str;
        String str2;
        String str3;
        Bundle bundle = new Bundle();
        List<CJRProductsItem> list = this.p;
        if (list != null) {
            if (list == null) {
                kotlin.g.b.k.a();
            }
            if (!list.isEmpty()) {
                List<CJRProductsItem> list2 = this.p;
                if (list2 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductsItem cJRProductsItem = list2.get(0);
                String str4 = null;
                if (TextUtils.isEmpty(cJRProductsItem != null ? cJRProductsItem.getDeclarationCaption() : null)) {
                    str = getString(R.string.utility_bottom_sheet_heading);
                } else {
                    List<CJRProductsItem> list3 = this.p;
                    if (list3 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem2 = list3.get(0);
                    str = cJRProductsItem2 != null ? cJRProductsItem2.getDeclarationCaption() : null;
                }
                bundle.putString("declaration_caption", str);
                List<CJRProductsItem> list4 = this.p;
                if (list4 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductsItem cJRProductsItem3 = list4.get(0);
                if (TextUtils.isEmpty(cJRProductsItem3 != null ? cJRProductsItem3.getDeclarationText1() : null)) {
                    str2 = getString(R.string.declaration_text_1);
                } else {
                    List<CJRProductsItem> list5 = this.p;
                    if (list5 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem4 = list5.get(0);
                    str2 = cJRProductsItem4 != null ? cJRProductsItem4.getDeclarationText1() : null;
                }
                bundle.putString("declaration_text_1", str2);
                List<CJRProductsItem> list6 = this.p;
                if (list6 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductsItem cJRProductsItem5 = list6.get(0);
                if (TextUtils.isEmpty(cJRProductsItem5 != null ? cJRProductsItem5.getDeclarationText2() : null)) {
                    str3 = getString(R.string.declaration_text_2);
                } else {
                    List<CJRProductsItem> list7 = this.p;
                    if (list7 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem6 = list7.get(0);
                    str3 = cJRProductsItem6 != null ? cJRProductsItem6.getDeclarationText2() : null;
                }
                bundle.putString("declaration_text_2", str3);
                List<CJRProductsItem> list8 = this.p;
                if (list8 == null) {
                    kotlin.g.b.k.a();
                }
                CJRProductsItem cJRProductsItem7 = list8.get(0);
                if (TextUtils.isEmpty(cJRProductsItem7 != null ? cJRProductsItem7.getDeclarationCta() : null)) {
                    str4 = getString(R.string.bottom_sheet_proceed_btn_txt);
                } else {
                    List<CJRProductsItem> list9 = this.p;
                    if (list9 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem cJRProductsItem8 = list9.get(0);
                    if (cJRProductsItem8 != null) {
                        str4 = cJRProductsItem8.getDeclarationCta();
                    }
                }
                bundle.putString("proceed_btn_text", str4);
            }
        }
        return bundle;
    }

    public final void an_() {
        if (getActivity() == null || !az.c(getActivity())) {
            startActivity(new Intent(getContext(), AJRAutomaticSubscriptionListActivity.class));
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        az.f(activity, "");
    }

    public final void aq_() {
        R();
    }

    public final void ar_() {
        t();
    }

    public final void g() {
        Button button = (Button) b(R.id.btn_proceed);
        if (button != null) {
            ai.a(button);
        }
    }

    public final void ao_() {
        Button button = (Button) b(R.id.btn_proceed);
        if (button != null) {
            button.performClick();
        }
    }

    public final void M() {
        this.I = this.T;
    }

    public final void a(JSONObject jSONObject) {
        kotlin.g.b.k.c(jSONObject, "requestBody");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.VIEW_MY_BILL.name());
        }
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null) {
            kotlin.g.b.k.c("view_my_bill", "tag");
            kotlin.g.b.k.c(jSONObject, "jsonObject");
            gVar.z.setValue(Boolean.TRUE);
            net.one97.paytm.recharge.common.utils.w wVar = gVar.t;
            if (wVar != null) {
                wVar.a("view_my_bill", (net.one97.paytm.recharge.common.e.ai) gVar, jSONObject, (Object) a2);
            }
        }
    }

    public final void a(ak akVar) {
        kotlin.g.b.k.c(akVar, "bottomSheet");
        akVar.show(getChildFragmentManager(), "");
    }

    public final void a(CJRMyBillData cJRMyBillData) {
        kotlin.g.b.k.c(cJRMyBillData, "myBillData");
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout != null) {
            customInputLinearLayout.a(cJRMyBillData);
        }
    }

    public final boolean g(String str) {
        kotlin.g.b.k.c(str, "url");
        if (!(getActivity() == null || getContext() == null)) {
            if (!com.paytm.utility.s.a() || com.paytm.utility.s.c((Activity) getActivity())) {
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                if (az.a(str, context)) {
                    return true;
                }
                CustomInputLinearLayout customInputLinearLayout = this.r;
                if (customInputLinearLayout != null) {
                    customInputLinearLayout.n();
                }
            } else {
                this.V = true;
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 56);
                return false;
            }
        }
        return false;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 != 56) {
            return;
        }
        if (!com.paytm.utility.s.a(iArr)) {
            this.V = false;
            CustomInputLinearLayout customInputLinearLayout = this.r;
            if (customInputLinearLayout != null) {
                customInputLinearLayout.n();
            }
        } else if (this.V && getContext() != null) {
            this.V = false;
            CustomInputLinearLayout customInputLinearLayout2 = this.r;
            if (customInputLinearLayout2 != null && customInputLinearLayout2.k != null) {
                CJRMyBillData cJRMyBillData = customInputLinearLayout2.k;
                if (cJRMyBillData == null) {
                    kotlin.g.b.k.a();
                }
                customInputLinearLayout2.a(cJRMyBillData);
            }
        }
    }

    public final void N() {
        this.o = null;
    }

    public final void O() {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null && (dVar = gVar.v) != null) {
            String ai = ai();
            String str = ab.f61496a;
            kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, "view_sample_bill_clicked", (Object) null, (Object) null, str, (Object) null, (Object) null, 108);
        }
    }

    public final void P() {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar != null && (dVar = gVar.v) != null) {
            String ai = ai();
            String str = ab.f61496a;
            kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, ai, "view_sample_bill_loaded", (Object) null, (Object) null, str, (Object) null, (Object) null, 108);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        r1 = (r1 = r1.f61409b).getCategoryData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ai() {
        /*
            r2 = this;
            boolean r0 = r2.F
            if (r0 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.automatic.b.a.a$a r1 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.a.f60240b
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            net.one97.paytm.recharge.common.h.g r1 = r2.f61339f
            if (r1 == 0) goto L_0x002a
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x002a
            net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r1.getCategoryData()
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = r1.getGAEventCategory()
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0033:
            net.one97.paytm.recharge.common.h.g r0 = r2.f61339f
            if (r0 == 0) goto L_0x0047
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0047
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r0.getGAEventCategory()
            if (r0 != 0) goto L_0x0049
        L_0x0047:
            java.lang.String r0 = ""
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.ai():java.lang.String");
    }

    public final void h(String str) {
        String str2;
        kotlin.g.b.k.c(str, "label");
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar == null || (str2 = gVar.a()) == null) {
            str2 = "";
        }
        String str3 = ab.f61496a;
        kotlin.g.b.k.a((Object) str3, "CJRRechargeUtilityConstant.UTILITY");
        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str2, "bill_fetched_successfully", "", str, str3, (Object) null, (Object) null, 96);
    }

    public final void Q() {
        String str;
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
        net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
        if (gVar == null || (str = gVar.a()) == null) {
            str = "";
        }
        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str, "plan_removed", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        r8 = r6.get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0114
            android.view.View r0 = r10.D
            if (r0 == 0) goto L_0x0114
            java.lang.Object r0 = r0.getTag()
            if (r0 == 0) goto L_0x010c
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            boolean r2 = r2 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x010b
            r2 = 1
            java.lang.Object r3 = r0.get(r2)
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x010b
            java.lang.Object r1 = r0.get(r1)
            if (r1 == 0) goto L_0x0103
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r7 = r1.intValue()
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x00fb
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            net.one97.paytm.recharge.common.h.g r3 = r10.f61339f
            if (r3 == 0) goto L_0x010b
            java.lang.String r0 = r11.getState()
            java.lang.String r1 = "cjrUtilityLocationModel.state"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r11 = r11.getCity()
            java.lang.String r1 = "cjrUtilityLocationModel.city"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            java.lang.String r1 = "groupName"
            kotlin.g.b.k.c(r4, r1)
            java.lang.String r1 = "state"
            kotlin.g.b.k.c(r0, r1)
            java.lang.String r5 = "city"
            kotlin.g.b.k.c(r11, r5)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r6 = r3.f61409b
            java.util.List r6 = r6.getGroupItemList(r7, r4)
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)
            if (r1 != 0) goto L_0x006c
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r2)
            if (r1 == 0) goto L_0x00fa
        L_0x006c:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r3.f61409b
            int r5 = r1.getIndexFromList(r6, r0)
            r0 = -1
            if (r5 == r0) goto L_0x00fa
            r1 = 0
            if (r6 == 0) goto L_0x0085
            java.lang.Object r8 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            if (r8 == 0) goto L_0x0085
            java.lang.String r8 = r8.getDisplayValue()
            goto L_0x0086
        L_0x0085:
            r8 = r1
        L_0x0086:
            if (r6 == 0) goto L_0x00df
            java.lang.Object r9 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r9 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r9
            if (r9 == 0) goto L_0x00df
            java.util.List r9 = r9.getAggs()
            if (r9 == 0) goto L_0x00df
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r2
            if (r9 != r2) goto L_0x00df
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r3.f61409b
            java.lang.Object r9 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r9 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r9
            java.util.List r9 = r9.getAggs()
            int r11 = r2.getIndexFromList(r9, r11)
            if (r11 == r0) goto L_0x00fa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Object r2 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            java.util.List r2 = r2.getAggs()
            if (r2 == 0) goto L_0x00cf
            java.lang.Object r11 = r2.get(r11)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            if (r11 == 0) goto L_0x00cf
            java.lang.String r11 = r11.getDisplayValue()
            goto L_0x00d0
        L_0x00cf:
            r11 = r1
        L_0x00d0:
            r0.append(r11)
            java.lang.String r11 = ", "
            r0.append(r11)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x00df:
            if (r8 == 0) goto L_0x00fa
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r11 = r3.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$setText r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$setText
            r0.<init>(r7, r4, r8)
            r11.setValue(r0)
            if (r6 == 0) goto L_0x00f5
            java.lang.Object r11 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            r6 = r11
            goto L_0x00f6
        L_0x00f5:
            r6 = r1
        L_0x00f6:
            r8 = 0
            r3.a((java.lang.String) r4, (int) r5, (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6, (int) r7, (boolean) r8)
        L_0x00fa:
            return
        L_0x00fb:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r11.<init>(r0)
            throw r11
        L_0x0103:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Int"
            r11.<init>(r0)
            throw r11
        L_0x010b:
            return
        L_0x010c:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>"
            r11.<init>(r0)
            throw r11
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.o.a(net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel):void");
    }

    public static final /* synthetic */ void a(o oVar, IJRPaytmDataModel iJRPaytmDataModel, String str, CJRInputFieldsItem cJRInputFieldsItem, String str2, View view) {
        boolean z2 = true;
        if (iJRPaytmDataModel instanceof CJRCategoryData) {
            CJRCategoryDataHelper cJRCategoryDataHelper = new CJRCategoryDataHelper();
            cJRCategoryDataHelper.setCategoryData(str, (CJRCategoryData) iJRPaytmDataModel);
            net.one97.paytm.recharge.common.h.g gVar = oVar.f61339f;
            if (gVar != null) {
                String configKey = cJRInputFieldsItem.getConfigKey();
                CharSequence charSequence = configKey;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    z2 = false;
                }
                if (!z2) {
                    if (gVar.G == null) {
                        gVar.G = new HashMap<>();
                    }
                    HashMap<String, CJRCategoryDataHelper> hashMap = gVar.G;
                    if (hashMap == null) {
                        kotlin.g.b.k.a();
                    }
                    Map map = hashMap;
                    if (configKey == null) {
                        kotlin.g.b.k.a();
                    }
                    map.put(configKey, cJRCategoryDataHelper);
                }
            }
            oVar.a(cJRInputFieldsItem.getConfigKey(), cJRCategoryDataHelper, str2);
            return;
        }
        view.setEnabled(true);
    }
}
