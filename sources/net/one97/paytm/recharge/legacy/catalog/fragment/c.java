package net.one97.paytm.recharge.legacy.catalog.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.g.a;
import net.one97.paytm.recharge.automatic.widgets.CJRRBIComplianceView;
import net.one97.paytm.recharge.common.a.u;
import net.one97.paytm.recharge.common.activity.AJRAmountSelectionActivity;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.b.d;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.l;
import net.one97.paytm.recharge.common.fragment.a;
import net.one97.paytm.recharge.common.h.f;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CustomSwitch;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRichMessage;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.recharge.presentation.c.a;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import net.one97.paytm.upi.util.Events;

public class c extends FJRRechargeUtilityBaseV2 implements View.OnClickListener, net.one97.paytm.recharge.automatic.g.c, ag, a.C1182a, ba.a {
    protected boolean bA = true;
    private RadioGroup bB;
    private RadioButton bC;
    private RadioButton bD;
    private String bE;
    private boolean bF = false;
    private boolean bG;
    private boolean bH = false;
    private l bI;
    private ArrayList<CJRFrequentOrder> bJ = new ArrayList<>();
    private TextView bK;
    private boolean bL;
    private boolean bM;
    private LottieAnimationView bN;
    private View bO;
    private CustomSwitch bP;
    private boolean bQ = false;
    private f bR;
    private boolean bS = false;
    private boolean bT = false;
    protected RelativeLayout br;
    protected TextView bs;
    protected TextView bt;
    protected TextView bu;
    protected TextView bv;
    protected TabLayout bw;
    protected LinearLayout bx;
    protected d by;
    protected boolean bz;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    public final void a(List<CJRAutomaticSubscriptionItemModel> list) {
    }

    public final void d() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bR = (f) am.a(getActivity(), (al.b) new net.one97.paytm.recharge.common.h.a(d.b(getActivity().getApplicationContext()), d.d(getActivity()))).a(f.class);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        this.bS = net.one97.paytm.recharge.di.helper.c.T();
        this.bR.f61438a.observe(this, new z() {
            public final void onChanged(Object obj) {
                c.this.b((Data) obj);
            }
        });
        this.bR.f61439b.observe(this, new z() {
            public final void onChanged(Object obj) {
                c.this.a((Data) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Data data) {
        if (data != null && data.getDataState() != null && data.getDataState() == DataState.ERROR) {
            this.bQ = false;
        } else if (data != null && data.getData() != null && ((CJRSetUserConsentApiResponse) data.getData()).getStatus().intValue() == 200) {
            this.bQ = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Data data) {
        if (data != null && data.getDataState() == DataState.ERROR) {
            this.bP.setChecked(false);
            this.bO.setVisibility(8);
            this.bz = false;
        } else if (data != null && data.getData() != null) {
            if (((CJRGetUserConsentApiResponse) data.getData()).getStatus().intValue() == 204) {
                this.bz = true;
                this.bO.setVisibility(0);
                return;
            }
            this.bz = false;
            this.bP.setChecked(false);
            this.bO.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f62819b = getString(R.string.invalid_amount);
        this.f62819b = this.f62819b.substring(0, this.f62819b.length() - 1);
        this.k = layoutInflater.inflate(R.layout.catalog_fragment_recharge_utility_layout, (ViewGroup) null);
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.at = arguments.getBoolean("open_activity_in_automatic_mode", false);
                this.U = (CJRItem) arguments.getSerializable("recharge_item");
                try {
                    ay ayVar = ay.f61523a;
                    ay.a(this.U, VERTICAL.RECHARGES);
                } catch (Exception unused) {
                }
                this.f62825h = arguments.getBoolean("is_recharge_tabs_flow", false);
                this.bb = arguments.getBoolean("is_selected_in_tabs", false);
                if (arguments.containsKey("is_from_home")) {
                    this.aG = arguments.getBoolean("is_from_home");
                }
                if (this.U != null) {
                    this.bE = this.U.getLabel();
                    if (this.bE != null) {
                        String[] split = this.bE.split(" ");
                        String str = "";
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (i2 == split.length - 1) {
                                str = str + split[i2];
                            } else {
                                str = str + split[i2] + "_";
                            }
                        }
                        this.T = str.toLowerCase();
                    }
                    this.M = this.U.getName();
                    this.am = this.U.getName();
                    this.P = "/" + this.M;
                    this.J = this.U.getRelatedCategories();
                }
                q.b("mRechargeUtilityName : " + this.M);
                this.F = (RelativeLayout) this.k.findViewById(R.id.lyt_progress_overlay);
                this.r = b.f((Context) getActivity());
                this.s = (RelativeLayout) this.k.findViewById(R.id.lyt_fast_forward);
                this.I = (LinearLayout) this.k.findViewById(R.id.select_opertor_layout);
                this.L = (LinearLayout) this.k.findViewById(R.id.group_inputfield_layout);
                this.W = (TextView) this.k.findViewById(R.id.message_text);
                this.p = (RelativeLayout) this.k.findViewById(R.id.loading_progressbar);
                this.u = (LinearLayout) this.k.findViewById(R.id.dropdown_layout);
                this.w = (LinearLayout) this.k.findViewById(R.id.electricity_layout);
                this.A = (LinearLayout) this.k.findViewById(R.id.input_layout);
                this.n = (Button) this.k.findViewById(R.id.btn_proceed);
                this.l = (TextView) this.k.findViewById(R.id.meta_data_desc);
                this.m = (TextView) this.k.findViewById(R.id.disclaimer_text_readmore);
                this.l.setMovementMethod(LinkMovementMethod.getInstance());
                this.m.setOnClickListener(this);
                this.n.setOnClickListener(this);
                this.f62826i = (CheckBox) this.k.findViewById(R.id.radio_fast_forward);
                this.bv = (TextView) this.k.findViewById(R.id.fast_forward_text);
                this.bx = (LinearLayout) this.k.findViewById(R.id.main_content_layout);
                this.aX = (RelativeLayout) this.k.findViewById(R.id.loading_threedots_view);
                this.aY = (LottieAnimationView) this.k.findViewById(R.id.loading_threedots_lav);
                this.aZ = (RelativeLayout) this.k.findViewById(R.id.progress_view);
                this.bN = (LottieAnimationView) this.k.findViewById(R.id.loading_threedots);
                this.f62820c = (NestedScrollView) this.k.findViewById(R.id.parent_scroll);
                this.bK = (TextView) this.k.findViewById(R.id.automatic_add_new_bill_title);
                this.ba = (FrameLayout) this.k.findViewById(R.id.transparent_view);
                this.v = (TextView) this.k.findViewById(R.id.success_rate_alert_message_text_view);
                this.bO = this.k.findViewById(R.id.bill_consent_widget);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bO.getLayoutParams();
                layoutParams.setMargins(b.c(23), b.c(10), 0, 0);
                this.bO.setLayoutParams(layoutParams);
                this.bP = (CustomSwitch) this.k.findViewById(R.id.bill_reminder_switcher);
                this.bP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener((TextView) this.k.findViewById(R.id.txt_bill_reminder)) {
                    private final /* synthetic */ TextView f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        c.a(this.f$0, compoundButton, z);
                    }
                });
                this.s.setOnClickListener(this.aQ);
                this.f62826i.setOnClickListener(this.aQ);
                this.bB = (RadioGroup) this.k.findViewById(R.id.radioGroup_recharge_type);
                this.bC = (RadioButton) this.k.findViewById(R.id.fee_payment);
                this.bD = (RadioButton) this.k.findViewById(R.id.new_registration);
                this.bB.setPadding(0, b.f((Context) getActivity()), 0, 0);
                this.j = (RelativeLayout) this.k.findViewById(R.id.bottom_layout_view);
                this.br = (RelativeLayout) this.k.findViewById(R.id.delete_options_view);
                this.bs = (TextView) this.k.findViewById(R.id.clear_option);
                this.bt = (TextView) this.k.findViewById(R.id.do_not_show_option);
                this.bu = (TextView) this.k.findViewById(R.id.cancel_option);
                View view = this.k;
                this.aq = (TextView) view.findViewById(R.id.image_automatic_heading);
                this.ar = (TextView) view.findViewById(R.id.image_automatic_subheading);
                this.as = (RelativeLayout) view.findViewById(R.id.automatic_banner_parent);
                this.as.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.p();
                    }
                });
                if (this.at) {
                    I();
                }
                if (getArguments().containsKey(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST)) {
                    this.bF = getArguments().getBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST);
                }
                if (this.bF) {
                    this.bG = true;
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                        public final Object invoke() {
                            return c.this.O();
                        }
                    });
                }
                if (this.U != null) {
                    String name = this.U.getName();
                    if (name != null && name.equalsIgnoreCase("dth")) {
                        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                            public final Object invoke() {
                                return c.this.N();
                            }
                        });
                    }
                    this.q = this.U.getURL();
                    if (!TextUtils.isEmpty(this.q) && this.q.contains("paytmmp://")) {
                        Uri parse = Uri.parse(this.q);
                        if (parse.getQueryParameterNames().contains("url")) {
                            this.q = parse.getQueryParameter("url");
                            this.U.setUrl(this.q);
                        }
                    }
                    if (this.q != null) {
                        this.q = this.q.replace(" ", "%20");
                        F();
                    }
                    try {
                        if (this.U instanceof CJRHomePageItem) {
                            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) this.U;
                            this.Q = cJRHomePageItem.getPushRechargePromo();
                            if (TextUtils.isEmpty(this.Q) && this.O.get("promo") != null) {
                                this.Q = (String) this.O.get("promo");
                            }
                            if (this.O != null) {
                                if (TextUtils.isEmpty(cJRHomePageItem.getName()) && this.O.get("title") != null) {
                                    cJRHomePageItem.setName((String) this.O.get("title"));
                                }
                                if (cJRHomePageItem.getRelatedCategories().size() == 0 && this.O.get("related_category") != null) {
                                    String str2 = (String) this.O.get("label");
                                    if (str2 != null) {
                                        cJRHomePageItem.setLabel(str2);
                                    }
                                    if (this.O.get("related_category") != null) {
                                        String str3 = (String) this.O.get("related_category");
                                        if (ba.k(str3) != null) {
                                            cJRHomePageItem.setRelatedCategories(ba.k(str3));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        q.d(e2.getMessage());
                    }
                }
            }
        } catch (Exception e3) {
            q.d(e3.getMessage());
        }
        if (this.at) {
            this.bK.setVisibility(0);
        }
        if (!(this.U == null || this.U.getName() == null)) {
            this.am = this.U.getName();
            if (this.U.getName().contains("Landline")) {
                this.M = "utilities_" + "Landline".toLowerCase();
                this.P = "/" + "Landline".toLowerCase();
            } else {
                this.M = "utilities_" + this.U.getName().toLowerCase();
                this.P = "/" + this.U.getName().toLowerCase();
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.b().setScreenName(this.P);
        }
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return c.this.P();
            }
        });
        return this.k;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x P() {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_service_type", this.ai);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_home_screen_loaded", getActivity());
        return null;
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x O() {
        if (this.U == null || this.U.getName() == null) {
            return null;
        }
        String str = "/" + this.U.getName().toLowerCase();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(getActivity(), str);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x N() {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(getContext(), "/dth");
        return null;
    }

    private void F() {
        if (!isDetached()) {
            if (URLUtil.isValidUrl(this.q)) {
                com.paytm.utility.c.a(this.q, (Context) getActivity());
                if (this.V != null) {
                    this.V.a();
                }
                this.V = w();
                if (this.U != null) {
                    this.U.getName();
                }
                if (this.U != null) {
                    this.bL = ((CJRHomePageItem) this.U).isDeepLinking();
                }
                Uri parse = Uri.parse(this.q);
                for (String next : parse.getQueryParameterNames()) {
                    this.O.put(next.trim(), parse.getQueryParameter(next));
                }
                if (this.O.containsKey("app_link_level_1")) {
                    this.f62822e = (String) this.O.get("app_link_level_1");
                    this.aN = true;
                }
                if (this.O.containsKey("app_link_level_2")) {
                    this.f62823f = (String) this.O.get("app_link_level_2");
                    this.aN = true;
                }
                if (this.U != null && (this.U instanceof CJRHomePageItem) && "deeplinking".equalsIgnoreCase(((CJRHomePageItem) this.U).getOrigin())) {
                    this.aO = true;
                }
                if (this.O.containsKey(CLPConstants.PRODUCT_ID)) {
                    f((String) this.O.get(CLPConstants.PRODUCT_ID));
                } else {
                    a((String) null, true, true);
                }
            } else {
                az azVar = az.f61525a;
                az.a(getActivity(), ERROR_TYPE.INVALID_URL, ACTION_TYPE.UNDEFINED, getString(R.string.error), getString(R.string.msg_invalid_url));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void x() {
        this.aP = null;
        d dVar = this.by;
        if (dVar != null) {
            dVar.f62907f = null;
        }
    }

    public final void a(CJRUtilityProductListV2 cJRUtilityProductListV2) {
        final List<CJRFrequentOrder> list;
        boolean z;
        boolean z2;
        String str;
        String str2;
        final CJRUtilityProductListV2 cJRUtilityProductListV22 = cJRUtilityProductListV2;
        CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
        String str3 = null;
        if (cJRUtilityProductListV22 == null || TextUtils.isEmpty(cJRUtilityProductListV2.getName()) || frequentOrderList == null || frequentOrderList.getOrderList().size() <= 0) {
            list = null;
        } else {
            net.one97.paytm.recharge.common.utils.q qVar = net.one97.paytm.recharge.common.utils.q.f61722a;
            list = net.one97.paytm.recharge.common.utils.q.a(frequentOrderList, cJRUtilityProductListV2.getName(), (String) null);
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        boolean z3 = false;
        if (cJRUtilityProductListV2.getId() != 37217 || !this.bA || getActivity() == null || getActivity().isFinishing()) {
            z = false;
        } else {
            net.one97.paytm.recharge.common.b.c b2 = d.b(getActivity());
            if (a2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = a2;
                if (cJRRechargeErrorModel.getFlowName() == null) {
                    cJRRechargeErrorModel.setFlowName(new CRUFlowModel());
                }
                cJRRechargeErrorModel.getFlowName().setTag("merchant_loan_account_list");
                cJRRechargeErrorModel.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
                cJRRechargeErrorModel.getFlowName().setActionType(ACTION_TYPE.MERCHANT_LOAN_ACCOUNT.name());
            }
            b2.d("merchant_loan_account_list", new ai() {
                /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a_(java.lang.String r7, com.paytm.network.model.IJRPaytmDataModel r8, java.lang.Object r9) {
                    /*
                        r6 = this;
                        java.util.ArrayList r7 = new java.util.ArrayList
                        r7.<init>()
                        boolean r9 = r8 instanceof net.one97.paytm.recharge.model.CJRMerchantLoanAccounts
                        r0 = 0
                        if (r9 == 0) goto L_0x005a
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r9 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r8 = (net.one97.paytm.recharge.model.CJRMerchantLoanAccounts) r8
                        r9.aP = r8
                        java.util.List r8 = r2
                        if (r8 == 0) goto L_0x005a
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r8 = r9.aP
                        java.util.List r8 = r8.getAccounts()
                        if (r8 == 0) goto L_0x005a
                        java.util.List r8 = r2
                        java.util.Iterator r8 = r8.iterator()
                        r9 = 0
                    L_0x0023:
                        boolean r1 = r8.hasNext()
                        if (r1 == 0) goto L_0x005b
                        java.lang.Object r1 = r8.next()
                        net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r1
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r2 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r2 = r2.aP
                        java.util.List r2 = r2.getAccounts()
                        java.util.Iterator r2 = r2.iterator()
                    L_0x003b:
                        boolean r3 = r2.hasNext()
                        if (r3 == 0) goto L_0x0023
                        java.lang.Object r3 = r2.next()
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem r3 = (net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem) r3
                        java.lang.String r4 = r1.getRechargeNumber()
                        java.lang.String r5 = r3.getAccountNumber()
                        boolean r4 = r4.equalsIgnoreCase(r5)
                        if (r4 == 0) goto L_0x003b
                        r9 = 1
                        r7.add(r3)
                        goto L_0x003b
                    L_0x005a:
                        r9 = 0
                    L_0x005b:
                        if (r9 == 0) goto L_0x007d
                        int r8 = r7.size()
                        if (r8 == 0) goto L_0x007d
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r8 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r8 = r8.aP
                        java.util.List r8 = r8.getAccounts()
                        r8.removeAll(r7)
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r7 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r7 = r7.aP
                        java.util.List r7 = r7.getAccounts()
                        int r7 = r7.size()
                        if (r7 <= 0) goto L_0x007d
                        r9 = 0
                    L_0x007d:
                        if (r9 == 0) goto L_0x008c
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r7 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        r8 = 0
                        r7.aP = r8
                        net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                        java.lang.String r8 = "MerchantLoanAccounts: Has Account in both recents & account"
                        r7.debugLog(r8)
                        goto L_0x0093
                    L_0x008c:
                        net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                        java.lang.String r8 = "MerchantLoanAccounts: Has no account detail in recents"
                        r7.debugLog(r8)
                    L_0x0093:
                        net.one97.paytm.recharge.legacy.catalog.fragment.c r7 = net.one97.paytm.recharge.legacy.catalog.fragment.c.this
                        r7.bA = r0
                        net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r8 = r1
                        r7.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.c.AnonymousClass1.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    CJRRechargeUtilities.INSTANCE.debugLog("MerchantLoanAccounts: Error in fetching: ".concat(String.valueOf(net.one97.paytm.recharge.common.utils.z.a(networkCustomError.networkResponse))));
                    c cVar = c.this;
                    cVar.bA = false;
                    cVar.a(cJRUtilityProductListV22);
                }
            }, a2);
            CJRRechargeUtilities.INSTANCE.debugLog("MerchantLoanAccounts: waiting for api response");
            z = true;
        }
        if (!z && getActivity() != null && !getActivity().isFinishing()) {
            this.ao = cJRUtilityProductListV2.getTopLevelCategoryHeader();
            d dVar2 = this.by;
            if (dVar2 == null) {
                if (this.at) {
                    I();
                } else {
                    if (cJRUtilityProductListV22 == null || TextUtils.isEmpty(cJRUtilityProductListV2.getName())) {
                        if (this.U == null || TextUtils.isEmpty(this.U.getName())) {
                            str = "";
                        } else {
                            str = this.U.getName();
                        }
                        z2 = false;
                    } else {
                        str = cJRUtilityProductListV2.getName();
                        z2 = cJRUtilityProductListV2.isShowHelp();
                    }
                    if (cJRUtilityProductListV2.getRc() != null && cJRUtilityProductListV2.getRc().size() > 1) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= cJRUtilityProductListV2.getRc().size()) {
                                break;
                            } else if (!cJRUtilityProductListV2.getRc().get(i2).isSelected()) {
                                str2 = cJRUtilityProductListV2.getRc().get(i2).getLabel();
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    str2 = null;
                    if (this.by == null) {
                        this.by = d.a(str, str, str2, this.U, z2, this.ao, cJRUtilityProductListV2.getGaKey());
                        this.by.f62907f = this.aP;
                        if (getActivity() != null && !getActivity().isFinishing()) {
                            net.one97.paytm.recharge.common.utils.am.a(getChildFragmentManager().a().a(this.bx.getId(), this.by, ""));
                        }
                    }
                }
            } else if (!dVar2.d()) {
                this.by.f62907f = this.aP;
                this.by.a((String) null);
            }
            if (list != null && list.size() > 0) {
                if (list.size() > 1 && !this.al) {
                    this.ak = true;
                }
                this.aj = true;
            }
            this.bv.setText(cJRUtilityProductListV2.getFfText());
            if (this.bL && this.U != null && e.z.equals(this.U.getCategoryId())) {
                this.aj = false;
            }
            super.a(cJRUtilityProductListV2);
            if (!this.aN && !this.bL && !this.bf && !this.ak) {
                if (cJRUtilityProductListV22 != null) {
                    z3 = cJRUtilityProductListV2.isRecentsPrefill();
                    str3 = cJRUtilityProductListV2.getName();
                }
                if (z3 && !this.aA && this.O.size() == 0 && this.by != null && d.a((Activity) getActivity(), str3) != null) {
                    this.aA = true;
                    b(d.a((Activity) getActivity(), str3));
                }
            }
        }
    }

    public final void a(CJRDetailProduct cJRDetailProduct) {
        this.O.putAll(cJRDetailProduct.getAttributes());
        h();
        this.aK = true;
        a((String) null, true, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(TextView textView, CompoundButton compoundButton, boolean z) {
        if (z) {
            textView.setText(R.string.bill_reminder_set);
        } else {
            textView.setText(R.string.set_bill_reminder);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AJRRechargeUtilityActivity) {
            this.bI = (l) getActivity();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && !this.bH) {
            RadioButton radioButton = this.bC;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            RadioButton radioButton2 = this.bD;
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        String str = "";
        if (id == R.id.action_button) {
            if (getActivity() == null || !az.c(getActivity())) {
                startActivity(new Intent(getContext(), AJRAutomaticSubscriptionListActivity.class));
                return;
            }
            az azVar = az.f61525a;
            az.f(getActivity(), str);
        } else if (id == R.id.btn_proceed) {
            if (!this.n.getText().toString().contains(getString(R.string.fetching_bill))) {
                if (this.n.getText().toString().equalsIgnoreCase(getString(R.string.get_card_balance))) {
                    if (e.z.equals(this.U.getCategoryId())) {
                        net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(getContext());
                        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                        if (this.bi != null) {
                            str = this.bi.getFilterName();
                        }
                        dVar.a(c.a.a(str), "get_card_balance_clicked", "", "", ab.f61496a, "", "");
                    }
                } else if (this.n.getText().toString().contains(getString(R.string.proceed))) {
                    if (e.z.equals(this.U.getCategoryId())) {
                        net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(getContext());
                        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                        if (this.bi != null) {
                            str = this.bi.getFilterName();
                        }
                        dVar2.a(c.a.a(str), "smart_card_recharge_proceed_clicked", "", "", ab.f61496a, "", "");
                    } else {
                        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(Events.Action.PROCEED_CLICKED) {
                            private final /* synthetic */ String f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final Object invoke() {
                                return c.this.g(this.f$1);
                            }
                        });
                    }
                }
                e.z.equals(this.U.getCategoryId());
                this.n.setFocusableInTouchMode(true);
                if (this.U != null && !e.z.equals(this.U.getCategoryId())) {
                    this.n.requestFocus();
                }
                this.n.setFocusableInTouchMode(false);
                s();
                if (u()) {
                    String B = B();
                    if (!this.at || TextUtils.isEmpty(B)) {
                        ba baVar = new ba(this);
                        String str2 = null;
                        if (this.aC != null && !TextUtils.isEmpty(this.aC.getText().toString())) {
                            str2 = ba.a((List<CJRFrequentOrder>) this.S, this.aC.getText().toString(), 36);
                        }
                        if (str2 == null || this.bM || this.at || this.Y == null || this.Y.size() <= 0 || this.Y.get(0) == null || ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() == null || ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().isDisableAutoCorrect()) {
                            CustomSwitch customSwitch = this.bP;
                            if (customSwitch != null && customSwitch.isChecked() && net.one97.paytm.recharge.common.utils.z.a((Context) getActivity()) && b.c((Context) getActivity()) && this.o != null && !this.bQ) {
                                this.f62824g.put("amount", D());
                                this.bR.b(this.f62824g);
                            }
                            H();
                            this.bM = false;
                            return;
                        }
                        baVar.a(str2, getContext(), this.ai, this.U.getName());
                        this.bM = true;
                        return;
                    }
                    g();
                    a.C1163a aVar3 = net.one97.paytm.recharge.automatic.g.a.f60288a;
                    net.one97.paytm.recharge.automatic.g.a a2 = a.C1163a.a(getContext(), this);
                    net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    a2.a("check_subscription", B, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.CLP_PROCEED, ERROR_TYPE.UNDEFINED));
                }
            }
        } else if (id == R.id.disclaimer_text_readmore) {
            if (this.l != null) {
                this.l.setMaxLines(Integer.MAX_VALUE);
            }
            if (this.m != null) {
                this.m.setVisibility(8);
            }
        } else if (id == R.id.edit_no && this.o != null && !TextUtils.isEmpty(this.o.getHint()) && this.o.getHint().toString().equalsIgnoreCase(this.aD) && this.aE != null && this.aE.size() > 0) {
            Intent intent = new Intent(getActivity(), AJRAmountSelectionActivity.class);
            intent.putExtra("intent_extra_payment_options", (Serializable) this.aE);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x M() {
        if (this.ai == null) {
            return null;
        }
        String str = this.f62826i.isChecked() ? "checked" : "unchecked";
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_service_type", this.ai);
        hashMap.put("recharge_utilities_ff_state", str);
        if (this.o != null) {
            hashMap.put("recharge_utilities_amount", D());
        }
        hashMap.put("recharge_utilities_group_field_values", z());
        hashMap.put("recharge_utilities_input_field_values", A());
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_proceed_clicked", getActivity());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x g(String str) {
        HashMap hashMap = new HashMap();
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        String str2 = "";
        hashMap.put("event_category", c.a.h(this.bi != null ? this.bi.getFilterName() : str2));
        hashMap.put("event_action", str);
        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
        if (this.bi != null) {
            str2 = this.bi.getFilterName();
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, c.a.g(str2));
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, getContext());
        return null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(i2, i3, intent);
    }

    public final void c(CJRFrequentOrder cJRFrequentOrder) {
        if (cJRFrequentOrder != null) {
            RelativeLayout relativeLayout = this.br;
            if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
                this.br.setVisibility(0);
            }
            TabLayout tabLayout = this.bw;
            if (tabLayout != null && tabLayout.getVisibility() == 0) {
                this.bw.setVisibility(8);
            }
        }
        this.bI.a(true);
        this.bT = true;
        ArrayList<CJRFrequentOrder> arrayList = this.bJ;
        if (arrayList == null || (arrayList != null && !arrayList.contains(cJRFrequentOrder))) {
            this.bJ.add(cJRFrequentOrder);
        } else {
            this.bJ.remove(cJRFrequentOrder);
        }
        ArrayList<CJRFrequentOrder> arrayList2 = this.bJ;
        if (arrayList2 != null && arrayList2.size() == 0) {
            E();
        }
    }

    public final boolean E() {
        if (!this.bT) {
            return true;
        }
        this.bT = false;
        d dVar = this.by;
        if (dVar != null) {
            dVar.a();
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.V != null) {
            this.V.a();
        }
    }

    public final void e() {
        this.bx.addView(new CJRRBIComplianceView(getContext(), true, true, (byte) 0), 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x L() {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_service_type", this.ai);
        hashMap.put("recharge_utilities_group_field_values", z());
        hashMap.put("recharge_utilities_input_field_values", A());
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_proceed_fetch_clicked", getActivity());
        return null;
    }

    private void G() {
        if (net.one97.paytm.recharge.common.utils.z.a((Context) getActivity())) {
            if (this.Y != null && this.Y.get(0) != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getAlert() != null) {
                a(((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getAlert());
            } else if (this.Y != null && this.Y.get(0) != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetHeading() != null) {
                a(new CJRUtilityAlertV2((String) null, ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetHeading(), ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetMessage(), ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetOkText(), ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetCancelText(), ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getSheetCheckBokText(), (List<CJRRichMessage>) null));
            } else if (this.az != null && this.an == null) {
                this.az.performClick();
            } else if (this.Y == null || this.Y.get(0) == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields() == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(0) == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(0).getConfigKey() == null || !((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(0).getConfigKey().equals("recharge_number") || !((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(0).getTitle().equalsIgnoreCase("Credit Card Number")) {
                a(v(), true);
            } else {
                a(v(), true, this.an);
            }
            if (this.U != null) {
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                    public final Object invoke() {
                        return c.this.M();
                    }
                });
                return;
            }
            return;
        }
        net.one97.paytm.recharge.common.utils.z.a((Activity) getActivity());
    }

    private void H() {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel b2 = net.one97.paytm.recharge.widgets.c.d.b();
        if (!(this.Y == null || this.Y.size() <= 0 || ((CJRUtilityProductV2) this.Y.get(0)).getId() == 0)) {
            b2.setProductId(String.valueOf(((CJRUtilityProductV2) this.Y.get(0)).getId()));
        }
        ay ayVar = ay.f61523a;
        ay.a(ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, b2);
        if (this.Y != null && this.Y.size() > 0 && this.Y.get(0) != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() != null && this.bk == 1) {
            a(v(), false);
        } else if (this.Y != null && this.Y.size() > 0 && this.Y.get(0) != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() != null && "0".equalsIgnoreCase(((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getPrefetch()) && this.bk == 0) {
            G();
        } else if (this.Y != null && this.Y.size() > 0 && this.Y.get(0) != null && ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() != null && "1".equalsIgnoreCase(((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getPrefetch()) && this.bk == 0) {
            if (this.o == null || this.o.getVisibility() != 0) {
                if (this.bS) {
                    this.f62824g.put("rechargeNumber", B());
                    if (this.Y == null || this.Y.isEmpty() || ((CJRUtilityProductV2) this.Y.get(0)).getAttributes() == null || !net.one97.paytm.recharge.common.utils.z.a((Context) getActivity()) || !b.c((Context) getActivity()) || TextUtils.isEmpty(((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getRemindable()) || !"2".equalsIgnoreCase(((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getRemindable())) {
                        this.bP.setChecked(false);
                        this.bO.setVisibility(8);
                    } else {
                        this.f62824g.put(StringSet.operator, ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getOperator());
                        String B = B();
                        if (!TextUtils.isEmpty(B)) {
                            this.f62824g.put("rechargeNumber", B);
                        }
                        HashMap hashMap = this.f62824g;
                        StringBuilder sb = new StringBuilder();
                        sb.append(((CJRUtilityProductV2) this.Y.get(0)).getId());
                        hashMap.put("productId", sb.toString());
                        this.f62824g.put("customerId", b.n((Context) getActivity()));
                        if (!TextUtils.isEmpty(b.l((Context) getActivity()))) {
                            this.f62824g.put("customerMobile", b.l((Context) getActivity()));
                        }
                        if (!TextUtils.isEmpty(b.m((Context) getActivity()))) {
                            this.f62824g.put("customerEmail", b.m((Context) getActivity()));
                        }
                        this.f62824g.put("paytype", ((CJRUtilityProductV2) this.Y.get(0)).getAttributes().getPaytype());
                        this.bR.a((HashMap<Object, Object>) this.f62824g);
                        this.bR.c(this.f62824g);
                    }
                }
                if (this.U != null) {
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                        public final Object invoke() {
                            return c.this.L();
                        }
                    });
                }
                this.D.add("price");
                double d2 = 10.0d;
                if (!(this.Y == null || this.Y.size() <= 0 || this.Y.get(0) == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields() == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields().size() <= 0)) {
                    double d3 = 10.0d;
                    for (int i2 = 0; i2 < ((CJRUtilityProductV2) this.Y.get(0)).getInputFields().size(); i2++) {
                        if (!(((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(i2) == null || ((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(i2).getMin() == null || !"price".equalsIgnoreCase(((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(i2).getConfigKey()))) {
                            d3 = Double.parseDouble(((CJRUtilityProductV2) this.Y.get(0)).getInputFields().get(i2).getMin());
                            if (d3 < 10.0d) {
                                d3 = 10.0d;
                            }
                        }
                    }
                    d2 = d3;
                }
                this.E.add(String.valueOf(d2));
                a(String.valueOf(d2), false);
                return;
            }
            G();
        }
    }

    public final void b_(String str) {
        this.aC.setText(str);
        this.bM = true;
    }

    public final void as_() {
        H();
        this.bM = false;
    }

    /* access modifiers changed from: protected */
    public final String q() {
        return this.ap;
    }

    /* access modifiers changed from: protected */
    public final void p() {
        super.p();
        startActivity(new Intent(getActivity(), AJRAutomaticAddNewBillActivity.class));
    }

    private void I() {
        this.as.setVisibility(8);
        this.n.setText(getString(R.string.proceed_re));
        this.s.setVisibility(8);
    }

    public final void a(boolean z, Integer num) {
        if (z) {
            h();
            int intValue = num.intValue();
            a.C1163a aVar = net.one97.paytm.recharge.automatic.g.a.f60288a;
            if (intValue == net.one97.paytm.recharge.automatic.g.a.f60289g) {
                a.C1278a aVar2 = net.one97.paytm.recharge.presentation.c.a.f64795a;
                a.C1278a.a(getContext(), getString(R.string.automatic_already_set), getString(R.string.available_subscribed_by_someone_else), getString(R.string.ok_re), $$Lambda$c$Uuma1lxiIMcZoYw2F1EskChM7c.INSTANCE, this.bq).show(getChildFragmentManager(), net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
                return;
            }
            a.C1278a aVar3 = net.one97.paytm.recharge.presentation.c.a.f64795a;
            a.C1278a.a(getContext(), getString(R.string.automatic_already_set), getString(R.string.available_subscribed_by_user), getString(R.string.manage_settings), this, this.bq).show(getChildFragmentManager(), net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
            return;
        }
        H();
    }

    public final void a() {
        H();
        h();
    }

    public final void j() {
        ba.a(8, (View) this.f62820c);
        ba.a(this.bN);
        ba.a(0, (View) this.aZ);
    }

    public final void a(int i2) {
        if (this.aZ != null && this.aZ.getVisibility() == 0) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    c.this.K();
                }
            }, (long) i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K() {
        ba.a(0, (View) this.f62820c);
        ba.a(8, (View) this.aZ);
        ba.b(this.bN);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        J();
        super.a(cJRFrequentOrder);
    }

    public final void y() {
        J();
        super.y();
    }

    private void J() {
        if (this.bO != null) {
            this.bP.setChecked(false);
            this.bO.setVisibility(8);
        }
        this.bz = false;
        this.bQ = false;
    }

    public final void ao_() {
        if (this.n != null) {
            this.n.performClick();
        }
    }

    /* access modifiers changed from: protected */
    public final void e(String str) {
        super.e(str);
        d dVar = this.by;
        if (dVar != null) {
            dVar.f62906e = str;
            if (dVar.f62905d != null) {
                u uVar = dVar.f62905d;
                uVar.j = str;
                if (uVar.f60694g != null) {
                    net.one97.paytm.recharge.common.a.ab abVar = uVar.f60694g;
                    abVar.f60436b = str;
                    if (abVar.f60437c != null) {
                        abVar.f60437c.f60450f = str;
                    }
                }
                if (uVar.f60695h != null) {
                    uVar.f60695h.f61305c = str;
                }
            }
        }
    }
}
