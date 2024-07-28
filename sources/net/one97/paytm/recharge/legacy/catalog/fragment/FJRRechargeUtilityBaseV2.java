package net.one97.paytm.recharge.legacy.catalog.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargeConfigurationV2;
import net.one97.paytm.common.entity.recharge.CJRRechargeDetailProductList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRDthPlanInfo;
import net.one97.paytm.common.entity.shopping.CJRPaymentOptions;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;
import net.one97.paytm.common.entity.shopping.CJRService;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.common.entity.shopping.CJRUpdatedValue;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.a;
import net.one97.paytm.recharge.common.a.j;
import net.one97.paytm.recharge.common.a.k;
import net.one97.paytm.recharge.common.activity.AJRAmountSelectionActivity;
import net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.activity.AJRUtilitySearchActivityV4;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.common.e.af;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.ak;
import net.one97.paytm.recharge.common.e.w;
import net.one97.paytm.recharge.common.fragment.e;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.am;
import net.one97.paytm.recharge.common.utils.ar;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.l;
import net.one97.paytm.recharge.common.utils.m;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.legacy.catalog.a;
import net.one97.paytm.recharge.legacy.catalog.activity.AJROtpRechargeActivity;
import net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRGWDataModel;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRechargeProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityRcV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.legacy.catalog.widget.CustomRadioGroupBaseV2;
import net.one97.paytm.recharge.metro.activity.AJRActiveMetroTicketListActivity;
import net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity;
import net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity;
import net.one97.paytm.recharge.metro.c.p;
import net.one97.paytm.recharge.metro.e.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.BannerData;
import net.one97.paytm.recharge.model.CJRBrowsePlansHeader;
import net.one97.paytm.recharge.model.CJRDynamicBrowsePlans;
import net.one97.paytm.recharge.model.CJRGroupField;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccounts;
import net.one97.paytm.recharge.model.CJRRechargeData;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.ordersummary.f.h;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public abstract class FJRRechargeUtilityBaseV2 extends a implements g.a, net.one97.paytm.common.widgets.a.d, FetchPayOptionsListener, net.one97.paytm.recharge.automatic.f.b, a.C1168a, k.a, aa, af, ag, w, e.a, l.b, a.C0940a, a.b, net.one97.paytm.recharge.legacy.catalog.hathway.c.a, h {
    private static boolean br;
    protected LinearLayout A;
    protected boolean B = false;
    protected LinearLayout C;
    protected ArrayList<String> D = new ArrayList<>();
    protected ArrayList<String> E = new ArrayList<>();
    protected RelativeLayout F;
    protected boolean G;
    protected String H;
    protected LinearLayout I;
    protected ArrayList<CJRRelatedCategory> J;
    protected boolean K = false;
    protected LinearLayout L;
    protected String M;
    protected ArrayList<CJRRechargeProductListV2> N = new ArrayList<>();
    protected HashMap<String, String> O = new HashMap<>();
    protected String P;
    protected String Q;
    protected Context R;
    protected List<CJRFrequentOrder> S;
    protected String T;
    protected CJRItem U;
    protected net.one97.paytm.recharge.legacy.catalog.a V;
    protected TextView W;
    protected RecyclerView X;
    protected List<CJRUtilityProductV2> Y = new ArrayList();
    protected CJRUtilityProductListV2 Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62818a;
    protected boolean aA;
    protected LinearLayout aB;
    protected AutoCompleteTextView aC;
    protected String aD;
    protected List<CJRPaymentOptions> aE;
    boolean aF = false;
    boolean aG = false;
    View.OnClickListener aH = new View.OnClickListener() {
        public final void onClick(View view) {
            FJRRechargeUtilityBaseV2.this.C();
        }
    };
    public b aI;
    protected net.one97.paytm.recharge.legacy.catalog.a aJ;
    protected boolean aK;
    public String aL;
    List<String> aM = new ArrayList();
    protected boolean aN = false;
    protected boolean aO = false;
    protected CJRMerchantLoanAccounts aP = null;
    protected View.OnClickListener aQ = new View.OnClickListener() {
        public final void onClick(View view) {
            String str;
            if (!(view instanceof CheckBox)) {
                FJRRechargeUtilityBaseV2.this.f62826i.toggle();
            }
            if (FJRRechargeUtilityBaseV2.this.f62826i != null) {
                if (FJRRechargeUtilityBaseV2.this.f62826i.isChecked()) {
                    FJRRechargeUtilityBaseV2.this.g(true);
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a("checked") {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return FJRRechargeUtilityBaseV2.this.o(this.f$1);
                        }
                    });
                    str = "fast_forward_checked";
                } else {
                    FJRRechargeUtilityBaseV2.this.g(false);
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a("unchecked") {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return FJRRechargeUtilityBaseV2.this.o(this.f$1);
                        }
                    });
                    str = "fast_forward_unchecked";
                }
                String str2 = str;
                if (com.paytm.utility.e.z.equals(FJRRechargeUtilityBaseV2.this.U.getCategoryId()) && FJRRechargeUtilityBaseV2.this.bi != null) {
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(FJRRechargeUtilityBaseV2.this.getContext());
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    dVar.a(c.a.a(FJRRechargeUtilityBaseV2.this.bi.getFilterName()), str2, "", "smart_card_recharge", ab.f61496a, "", "");
                }
            }
            FJRRechargeUtilityBaseV2.a(FJRRechargeUtilityBaseV2.this);
        }
    };
    protected boolean aR;
    protected String aS;
    protected String aT;
    protected String aU;
    protected String aV;
    protected String aW = "";
    protected RelativeLayout aX;
    protected LottieAnimationView aY;
    protected RelativeLayout aZ;
    protected JSONObject aa = new JSONObject();
    protected String ab;
    protected String ac;
    protected String ad;
    protected String ae;
    protected String af;
    protected ArrayList<String> ag;
    protected boolean ah = false;
    protected String ai = "";
    protected boolean aj = false;
    protected boolean ak = false;
    protected boolean al = false;
    protected String am;
    protected String an;
    protected TopLevelCategoryHeader ao;
    protected String ap;
    protected TextView aq;
    protected TextView ar;
    protected RelativeLayout as;
    protected boolean at = false;
    protected CJRAutomaticSubscriptionListModel au;
    protected HashMap<Integer, CJRBrowsePlanDescriptions> av;
    protected CJRBrowsePlansHeader aw;
    protected boolean ax;
    protected HashMap<String, String> ay;
    protected TextView az;

    /* renamed from: b  reason: collision with root package name */
    protected String f62819b;
    private final int bA = 102;
    private final View.OnClickListener bB = new View.OnClickListener() {
        public final void onClick(View view) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            if (autoCompleteTextView.hasFocus() && !TextUtils.isEmpty(autoCompleteTextView.getText().toString()) && autoCompleteTextView.getAdapter() != null && autoCompleteTextView.getAdapter().getCount() > 0) {
                autoCompleteTextView.showDropDown();
            }
        }
    };
    private final String bC = "N/A";
    private final String bD = FJRRechargeUtilityBaseV2.class.getSimpleName();
    private af bE;
    private List<CJRUtilityCheckboxItem> bF = new ArrayList();
    /* access modifiers changed from: private */
    public AutoCompleteTextView bG;
    private ArrayList<CJRDisplayValues> bH;
    private ArrayList<CJRGroupField> bI;
    private TextView bJ;
    private CJRRechargeCart bK;
    /* access modifiers changed from: private */
    public CJRRechargeCart bL;
    private CJRRechargePayment bM;
    private String bN = null;
    private boolean bO = true;
    private boolean bP = false;
    private Integer bQ = 0;
    private String bR;
    private boolean bS = false;
    private net.one97.paytm.recharge.legacy.catalog.hathway.a.b bT;
    private TextView bU;
    private TextView bV;
    private LinearLayout bW;
    private String bX;
    private boolean bY;
    /* access modifiers changed from: private */
    public long bZ = 0;
    protected FrameLayout ba;
    protected boolean bb = false;
    protected RadioGroup.OnCheckedChangeListener bc = new RadioGroup.OnCheckedChangeListener() {
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            List list = (List) radioGroup.getTag();
            int intValue = ((Integer) list.get(0)).intValue();
            int intValue2 = ((Integer) list.get(1)).intValue();
            CJRUtilityProductListV2 a2 = FJRRechargeUtilityBaseV2.this.c(intValue);
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(i2);
            int intValue3 = ((Integer) radioButton.getTag()).intValue();
            List a3 = FJRRechargeUtilityBaseV2.d(intValue2, a2);
            if (a3 != null && intValue3 < a3.size()) {
                CJRUtilityVariantV2 cJRUtilityVariantV2 = (CJRUtilityVariantV2) a3.get(intValue3);
                FJRRechargeUtilityBaseV2.a(FJRRechargeUtilityBaseV2.this, intValue2, intValue3, radioButton, cJRUtilityVariantV2, a2, intValue);
                FJRRechargeUtilityBaseV2.this.ai = cJRUtilityVariantV2.getFilterName();
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                    public final Object invoke() {
                        return FJRRechargeUtilityBaseV2.AnonymousClass29.this.a();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ x a() {
            HashMap hashMap = new HashMap();
            hashMap.put("recharge_utilities_service_type", FJRRechargeUtilityBaseV2.this.ai);
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_servicetype_selected", FJRRechargeUtilityBaseV2.this.getActivity());
            return null;
        }
    };
    public TextWatcher bd = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String D = FJRRechargeUtilityBaseV2.this.D();
            if (D.trim().length() > 0) {
                try {
                    double parseDouble = Double.parseDouble(D);
                    if (parseDouble > 0.0d) {
                        FJRRechargeUtilityBaseV2.this.c(true);
                        FJRRechargeUtilityBaseV2.this.c("amount_entered", String.valueOf(parseDouble));
                    } else {
                        FJRRechargeUtilityBaseV2.this.c(false);
                    }
                    if (FJRRechargeUtilityBaseV2.this.Y != null && FJRRechargeUtilityBaseV2.this.Y.size() > 0 && FJRRechargeUtilityBaseV2.this.Y.get(0).isConvenienceFee() && !FJRRechargeUtilityBaseV2.this.ca) {
                        FJRRechargeUtilityBaseV2.d(FJRRechargeUtilityBaseV2.this);
                    }
                } catch (NumberFormatException e2) {
                    q.d(e2.getMessage());
                }
            } else {
                FJRRechargeUtilityBaseV2.this.c(false);
            }
            FJRRechargeUtilityBaseV2.a(FJRRechargeUtilityBaseV2.this);
        }

        public final void afterTextChanged(Editable editable) {
            String a2 = ba.a(editable.toString(), false);
            FJRRechargeUtilityBaseV2.this.o.removeTextChangedListener(this);
            editable.replace(0, editable.length(), a2);
            FJRRechargeUtilityBaseV2.this.o.addTextChangedListener(this);
        }
    };
    protected TextWatcher be = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            int i2 = 0;
            while (i2 < editable.length()) {
                int i3 = i2 + 1;
                if (i3 % 5 == 0) {
                    if (editable.charAt(i2) != ' ') {
                        editable.insert(i2, " ");
                    }
                } else if (editable.charAt(i2) == ' ') {
                    editable.replace(i2, i3, "");
                    i2--;
                }
                i2++;
            }
        }
    };
    protected boolean bf;
    protected RadioGroup.OnCheckedChangeListener bg = new RadioGroup.OnCheckedChangeListener() {
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(i2);
            radioButton.setChecked(true);
            CJRUtilityRcV2 cJRUtilityRcV2 = (CJRUtilityRcV2) radioButton.getTag();
            FJRRechargeUtilityBaseV2.this.u.removeAllViews();
            FJRRechargeUtilityBaseV2.this.A.removeAllViews();
            FJRRechargeUtilityBaseV2.this.I.removeAllViews();
            FJRRechargeUtilityBaseV2.this.a(cJRUtilityRcV2.getUrl(), true, true);
            FJRRechargeUtilityBaseV2.this.ai = cJRUtilityRcV2.getLabel();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("service_type: " + FJRRechargeUtilityBaseV2.this.ai);
            net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                public final Object invoke() {
                    return FJRRechargeUtilityBaseV2.AnonymousClass3.this.a();
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ x a() {
            HashMap hashMap = new HashMap();
            hashMap.put("recharge_utilities_service_type", FJRRechargeUtilityBaseV2.this.ai);
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_servicetype_selected", FJRRechargeUtilityBaseV2.this.getActivity());
            return null;
        }
    };
    protected final AdapterView.OnItemClickListener bh = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            try {
                FJRRechargeUtilityBaseV2.this.aK = true;
                FJRRechargeUtilityBaseV2.this.al = true;
                FJRRechargeUtilityBaseV2.this.b(((j) adapterView.getAdapter()).getItem(i2));
                FJRRechargeUtilityBaseV2.this.ad();
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    };
    protected CJRUtilityVariantV2 bi;
    public boolean bj;
    public int bk;
    public String bl;
    public String bm;
    public String bn;
    public boolean bo;
    public boolean bp;
    protected BottomSheetBehavior.a bq = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            FJRRechargeUtilityBaseV2.this.b(i2);
        }
    };
    /* access modifiers changed from: private */
    public boolean bs;
    private boolean bt = false;
    private View.OnClickListener bu;
    /* access modifiers changed from: private */
    public boolean bv = false;
    private boolean bw = false;
    private boolean bx = false;
    private String by = null;
    private String bz = "";

    /* renamed from: c  reason: collision with root package name */
    protected NestedScrollView f62820c;
    private TextWatcher cA = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            FJRRechargeUtilityBaseV2.this.I();
        }
    };
    private View.OnClickListener cB = new View.OnClickListener() {
        public final void onClick(View view) {
            if (FJRRechargeUtilityBaseV2.this.ct != null && FJRRechargeUtilityBaseV2.this.aE != null && FJRRechargeUtilityBaseV2.this.aE.size() > 0) {
                if (FJRRechargeUtilityBaseV2.this.cv == null) {
                    FJRRechargeUtilityBaseV2.this.o.setText("");
                }
                Intent intent = new Intent(FJRRechargeUtilityBaseV2.this.getActivity(), AJRAmountSelectionActivity.class);
                intent.putExtra("intent_extra_payment_options", (Serializable) FJRRechargeUtilityBaseV2.this.aE);
                intent.putExtra("intent_extra_selected_amount", FJRRechargeUtilityBaseV2.this.cv);
                FJRRechargeUtilityBaseV2.this.getActivity().startActivityForResult(intent, 605);
                boolean unused = FJRRechargeUtilityBaseV2.this.co = false;
                FJRRechargeUtilityBaseV2.this.o.setFocusable(false);
                FJRRechargeUtilityBaseV2.this.o.setLongClickable(false);
            }
        }
    };
    private View.OnClickListener cC = new View.OnClickListener() {
        public final void onClick(View view) {
            if (FJRRechargeUtilityBaseV2.this.u()) {
                if (!(FJRRechargeUtilityBaseV2.this.cp == null || FJRRechargeUtilityBaseV2.this.cp.getHint() == null)) {
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(FJRRechargeUtilityBaseV2.this.cp.getHint().toString()) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return FJRRechargeUtilityBaseV2.this.q(this.f$1);
                        }
                    });
                }
                if (FJRRechargeUtilityBaseV2.this.o != null && FJRRechargeUtilityBaseV2.this.D() != null) {
                    FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2 = FJRRechargeUtilityBaseV2.this;
                    if (fJRRechargeUtilityBaseV2.f(fJRRechargeUtilityBaseV2.bL)) {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        if (a2.getFlowName() != null) {
                            a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
                            a2.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
                        }
                        FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV22 = FJRRechargeUtilityBaseV2.this;
                        fJRRechargeUtilityBaseV22.a(fJRRechargeUtilityBaseV22.bL, (Object) a2);
                    } else {
                        FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV23 = FJRRechargeUtilityBaseV2.this;
                        fJRRechargeUtilityBaseV23.a(fJRRechargeUtilityBaseV23.D(), false);
                    }
                    FJRRechargeUtilityBaseV2.this.y = (TextView) view;
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public List<CJRActiveMetroTicketModel> cD;
    private Boolean cE;
    private View.OnClickListener cF = new View.OnClickListener() {
        public final void onClick(View view) {
            CJRUtilitySelectedGroupItemV2 cJRUtilitySelectedGroupItemV2;
            View view2 = view;
            List list = (List) view.getTag();
            int intValue = ((Integer) list.get(0)).intValue();
            int intValue2 = ((Integer) list.get(1)).intValue();
            CJRUtilityProductListV2 a2 = FJRRechargeUtilityBaseV2.this.c(intValue);
            if (com.paytm.utility.e.z.equals(FJRRechargeUtilityBaseV2.this.U.getCategoryId())) {
                if (intValue2 == 0 && FJRRechargeUtilityBaseV2.this.bi != null) {
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(FJRRechargeUtilityBaseV2.this.getContext());
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    dVar.a(c.a.a(FJRRechargeUtilityBaseV2.this.bi.getFilterName()), "change_city_clicked", "", "", ab.f61496a, "", "");
                }
                if (!"ticket_type".equalsIgnoreCase(a2.getGroupFieldV2(intValue2).getKey()) || (cJRUtilitySelectedGroupItemV2 = a2.getSelectedGroupItemHashMap().get(Integer.valueOf(intValue2))) == null || !"ticket_type".equalsIgnoreCase(cJRUtilitySelectedGroupItemV2.getGroupKey()) || !"smart card recharge".equalsIgnoreCase(cJRUtilitySelectedGroupItemV2.getItemFilterName())) {
                    view2.setEnabled(false);
                    FJRRechargeUtilityBaseV2.this.cd.postDelayed(new Runnable(view2) {
                        private final /* synthetic */ View f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            this.f$0.setEnabled(true);
                        }
                    }, 1200);
                } else {
                    return;
                }
            } else if (SystemClock.elapsedRealtime() - FJRRechargeUtilityBaseV2.this.bZ >= 1000) {
                long unused = FJRRechargeUtilityBaseV2.this.bZ = SystemClock.elapsedRealtime();
            } else {
                return;
            }
            if (!(FJRRechargeUtilityBaseV2.this.cp == null || FJRRechargeUtilityBaseV2.this.cp.getHint() == null)) {
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(FJRRechargeUtilityBaseV2.this.cp.getHint().toString()) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object invoke() {
                        return FJRRechargeUtilityBaseV2.this.q(this.f$1);
                    }
                });
                if (FJRRechargeUtilityBaseV2.this.bi != null && FJRRechargeUtilityBaseV2.this.bi.getFilterName().equalsIgnoreCase("Mumbai Metro")) {
                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a("ticket_type_field_clicked") {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return FJRRechargeUtilityBaseV2.this.n(this.f$1);
                        }
                    });
                }
            }
            if (a2 != null && a2.getGroupFieldV2(intValue2) != null) {
                String placeHolder = a2.getGroupFieldV2(intValue2).getPlaceHolder();
                String label = a2.getGroupFieldV2(intValue2).getLabel();
                if (a2.getSelectedGroupItemHashMap() != null && intValue2 > 0 && a2.getSelectedGroupItemHashMap().size() >= intValue2) {
                    int i2 = intValue2 - 1;
                    if (!(a2.getSelectedGroupItemHashMap().get(Integer.valueOf(i2)) == null || a2.getSelectedGroupItemHashMap().get(Integer.valueOf(i2)).getAttributes() == null || a2.getSelectedGroupItemHashMap().get(Integer.valueOf(i2)).getAttributes().getLabel() == null)) {
                        label = a2.getSelectedGroupItemHashMap().get(Integer.valueOf(i2)).getAttributes().getLabel();
                    }
                }
                if (intValue2 > 0 && FJRRechargeUtilityBaseV2.this.bi != null && ("Delhi Metro".equals(FJRRechargeUtilityBaseV2.this.bi.getFilterName()) || "Mumbai Metro".equals(FJRRechargeUtilityBaseV2.this.bi.getFilterName()) || "Hyderabad Metro".equals(FJRRechargeUtilityBaseV2.this.bi.getFilterName()))) {
                    net.one97.paytm.recharge.legacy.catalog.b.a.a().f62800a = FJRRechargeUtilityBaseV2.d(intValue2, a2);
                    FJRRechargeUtilityBaseV2.this.a(false, 602, a2, intValue);
                    view2.setClickable(false);
                } else if (a2.getCurrentGroupList() != null && a2.getCurrentGroupList().size() > intValue2 && (a2.getCurrentGroupList().get(intValue2).equalsIgnoreCase("state") || a2.getCurrentGroupList().get(intValue2).equalsIgnoreCase("city"))) {
                    FJRRechargeUtilityBaseV2.a(FJRRechargeUtilityBaseV2.this, a2, label, placeHolder, a2.getGroupFieldV2(intValue2).getType());
                } else if (!com.paytm.utility.e.z.equals(FJRRechargeUtilityBaseV2.this.U.getCategoryId()) || !"ticket_type".equalsIgnoreCase(a2.getGroupFieldV2(intValue2).getKey())) {
                    FJRRechargeUtilityBaseV2.this.a(label, (List<CJRUtilityVariantV2>) FJRRechargeUtilityBaseV2.d(intValue2, a2), a2.getGroupFieldV2(intValue2).getType());
                } else {
                    view2.setEnabled(true);
                    view2.setClickable(false);
                    return;
                }
                FJRRechargeUtilityBaseV2.this.y = (TextView) view2;
            }
        }
    };
    private String cG;
    /* access modifiers changed from: private */
    public boolean ca = false;
    private boolean cb = false;
    private CJRUtilityVariantV2 cc;
    /* access modifiers changed from: private */
    public Handler cd = new Handler();
    private ArrayList<CJRSelectedRecharge> ce;
    private CJRSelectedRecharge cf;
    private String cg = "Recharge/Electricity";
    private int ch = 0;
    private boolean ci;
    private CJRCashWallet cj;
    private Intent ck;
    private Boolean cl = Boolean.FALSE;
    private String cm;
    private String cn;
    /* access modifiers changed from: private */
    public boolean co = true;
    /* access modifiers changed from: private */
    public TextInputLayout cp;
    private boolean cq = true;
    private Map<String, Boolean> cr = new HashMap();
    private View cs = null;
    /* access modifiers changed from: private */
    public TextInputLayout ct;
    private RelativeLayout cu;
    /* access modifiers changed from: private */
    public CJRPaymentOptions cv;
    private boolean cw = false;
    private a.C0940a cx;
    private boolean cy = false;
    private CJRFrequentOrder cz;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f62821d;

    /* renamed from: e  reason: collision with root package name */
    protected String f62822e;

    /* renamed from: f  reason: collision with root package name */
    protected String f62823f;

    /* renamed from: g  reason: collision with root package name */
    protected HashMap<Object, Object> f62824g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    protected boolean f62825h = false;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f62826i;
    protected RelativeLayout j;
    protected View k;
    protected TextView l;
    protected TextView m;
    protected Button n;
    protected AutoCompleteTextView o;
    protected RelativeLayout p;
    protected String q;
    protected int r;
    protected RelativeLayout s;
    protected int t = 0;
    protected LinearLayout u;
    protected TextView v;
    protected LinearLayout w;
    protected CJRRechargeDetailProductList x;
    protected TextView y;
    protected TextView z;

    public interface b {
        void a(String str);
    }

    public void a(CJRDetailProduct cJRDetailProduct) {
    }

    public final void am_() {
    }

    public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
    }

    public void onVpaReceived(VpaFetch vpaFetch) {
    }

    /* access modifiers changed from: protected */
    public void x() {
    }

    public final void d(boolean z2) {
        br = z2;
        this.n.setEnabled(!z2);
        this.n.setClickable(!z2);
    }

    public final void e(boolean z2) {
        this.bb = z2;
    }

    private InputFilter[] a() {
        return new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                StringBuilder sb = new StringBuilder(charSequence);
                while (i2 < i3) {
                    char charAt = charSequence.charAt(i2);
                    if (Character.isDigit(charAt) || charAt == ' ') {
                        i2++;
                    } else {
                        sb = sb.replace(i2, i2 + 1, "");
                        i3--;
                    }
                }
                return sb;
            }
        }};
    }

    /* access modifiers changed from: protected */
    public final void a(String str, List<CJRUtilityVariantV2> list, String str2) {
        net.one97.paytm.recharge.legacy.catalog.a aVar = this.V;
        if (aVar != null) {
            aVar.a();
        }
        String categoryId = this.U.getCategoryId();
        Intent intent = new Intent(getActivity(), ba.a(str2, this.at, categoryId));
        intent.putExtra("title", str);
        intent.putExtra("list_type", str2);
        intent.putExtra("open_activity_in_automatic_mode", this.at);
        intent.putExtra("category id", categoryId);
        if (list != null && list.size() > 0) {
            List<CJRAggsItem> a2 = new m().a((List<? extends CJRUtilityVariantV2>) list);
            y yVar = y.f61814b;
            y.a(a2);
            y yVar2 = y.f61814b;
            y.b(list);
        }
        getActivity().startActivityForResult(intent, 602);
    }

    public final void c(boolean z2) {
        Button button = this.n;
        if (button != null) {
            button.setEnabled(z2);
            this.n.setClickable(z2);
        }
    }

    private static AutoCompleteTextView a(LinearLayout linearLayout) {
        return (AutoCompleteTextView) linearLayout.findViewById(R.id.group_field_textview);
    }

    private static TextInputLayout b(LinearLayout linearLayout) {
        return (TextInputLayout) linearLayout.findViewById(R.id.text_input_layout_utility);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            r8 = this;
            super.onActivityResult(r9, r10, r11)
            r0 = 602(0x25a, float:8.44E-43)
            r1 = 1
            r2 = 0
            if (r9 != r0) goto L_0x00f2
            r9 = 203(0xcb, float:2.84E-43)
            if (r10 != r9) goto L_0x0052
            java.lang.String r9 = com.paytm.utility.e.z
            net.one97.paytm.common.entity.CJRItem r10 = r8.U
            java.lang.String r10 = r10.getCategoryId()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0027
            boolean r9 = r8.bf
            if (r9 == 0) goto L_0x0027
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
            return
        L_0x0027:
            android.widget.LinearLayout r9 = r8.u
            if (r9 == 0) goto L_0x0051
            android.view.View r9 = r9.getChildAt(r2)
            if (r9 == 0) goto L_0x0051
            android.widget.LinearLayout r9 = r8.u
            android.view.View r9 = r9.getChildAt(r2)
            int r10 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r9 = r9.findViewById(r10)
            if (r9 == 0) goto L_0x0051
            r8.E()
            android.widget.LinearLayout r9 = r8.u
            android.view.View r9 = r9.getChildAt(r2)
            int r10 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r9 = r9.findViewById(r10)
            r9.performClick()
        L_0x0051:
            return
        L_0x0052:
            r9 = 1009(0x3f1, float:1.414E-42)
            if (r10 != r9) goto L_0x0069
            r8.E()
            android.widget.LinearLayout r9 = r8.u
            android.view.View r9 = r9.getChildAt(r2)
            int r10 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r9 = r9.findViewById(r10)
            r9.performClick()
            return
        L_0x0069:
            r9 = 1003(0x3eb, float:1.406E-42)
            if (r10 != r9) goto L_0x008e
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r9 = r8.Z
            if (r9 == 0) goto L_0x008e
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r9 = net.one97.paytm.recharge.metro.f.c.f63584i
            if (r9 == 0) goto L_0x007a
            r2 = 1
        L_0x007a:
            r8.bf = r2
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r9 = net.one97.paytm.recharge.metro.f.c.f63584i
            r8.cD = r9
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r9 = r8.Z
            int r10 = r9.getGroupLevel()
            r8.a((boolean) r1, (int) r0, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r9, (int) r10)
            return
        L_0x008e:
            r9 = 1008(0x3f0, float:1.413E-42)
            if (r10 != r9) goto L_0x00ac
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r9 = r8.Z
            if (r9 == 0) goto L_0x00ac
            boolean r10 = r8.bt
            if (r10 == 0) goto L_0x00a4
            r8.bt = r2
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
            return
        L_0x00a4:
            int r10 = r9.getGroupLevel()
            r8.a((boolean) r1, (int) r0, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r9, (int) r10)
            return
        L_0x00ac:
            net.one97.paytm.common.entity.CJRItem r9 = r8.U
            r11 = 1010(0x3f2, float:1.415E-42)
            if (r9 == 0) goto L_0x00cc
            java.lang.String r9 = com.paytm.utility.e.z
            net.one97.paytm.common.entity.CJRItem r0 = r8.U
            java.lang.String r0 = r0.getCategoryId()
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x00cc
            if (r10 == r11) goto L_0x00c4
            if (r10 != 0) goto L_0x00cc
        L_0x00c4:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
            return
        L_0x00cc:
            boolean r9 = r8.f62825h
            if (r9 != 0) goto L_0x0238
            net.one97.paytm.common.entity.CJRItem r9 = r8.U
            if (r9 == 0) goto L_0x0238
            java.lang.String r9 = com.paytm.utility.e.bc
            net.one97.paytm.common.entity.CJRItem r0 = r8.U
            java.lang.String r0 = r0.getCategoryId()
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0238
            if (r10 == r11) goto L_0x00ea
            r9 = 283(0x11b, float:3.97E-43)
            if (r10 == r9) goto L_0x00ea
            if (r10 != 0) goto L_0x0238
        L_0x00ea:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
            return
        L_0x00f2:
            r0 = 547(0x223, float:7.67E-43)
            r3 = -1
            if (r9 != r0) goto L_0x0111
            if (r10 != r3) goto L_0x0110
            net.one97.paytm.common.entity.CJRRechargeCart r9 = r8.bK
            r8.d((net.one97.paytm.common.entity.CJRRechargeCart) r9)
            java.util.List<net.one97.paytm.common.entity.shopping.CJRPaymentOptions> r9 = r8.aE
            if (r9 == 0) goto L_0x010d
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x010d
            android.widget.AutoCompleteTextView r9 = r8.o
            r9.performClick()
        L_0x010d:
            r8.d((boolean) r2)
        L_0x0110:
            return
        L_0x0111:
            r0 = 92
            if (r9 != r0) goto L_0x01f1
            if (r10 != r3) goto L_0x0238
            java.lang.String r9 = "key_plain_expiry_list"
            java.io.Serializable r9 = r11.getSerializableExtra(r9)
            net.one97.paytm.common.entity.shopping.CJRService r9 = (net.one97.paytm.common.entity.shopping.CJRService) r9
            java.lang.String r10 = "list_position"
            int r10 = r11.getIntExtra(r10, r2)
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b r11 = r8.bT
            net.one97.paytm.common.entity.shopping.CJRDthPlanInfo r11 = r11.f62931b
            java.util.List r11 = r11.getServices()
            java.lang.Object r11 = r11.get(r10)
            net.one97.paytm.common.entity.shopping.CJRService r11 = (net.one97.paytm.common.entity.shopping.CJRService) r11
            r0 = 0
            r3 = 0
        L_0x0135:
            java.util.List r4 = r11.getPlanExpiryDetails()
            int r4 = r4.size()
            if (r2 >= r4) goto L_0x017b
            java.util.List r4 = r11.getPlanExpiryDetails()
            java.lang.Object r4 = r4.get(r2)
            net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r4 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r4
            java.util.List r5 = r9.getPlanExpiryDetails()
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r5 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r5
            boolean r6 = r4.isChecked()
            boolean r7 = r5.isChecked()
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0178
            boolean r3 = r4.isChecked()
            if (r3 == 0) goto L_0x016e
            java.lang.String r3 = r5.getAmount()
            int r3 = java.lang.Integer.parseInt(r3)
            int r0 = r0 - r3
            goto L_0x0177
        L_0x016e:
            java.lang.String r3 = r5.getAmount()
            int r3 = java.lang.Integer.parseInt(r3)
            int r0 = r0 + r3
        L_0x0177:
            r3 = 1
        L_0x0178:
            int r2 = r2 + 1
            goto L_0x0135
        L_0x017b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r8.a((java.lang.Integer) r2, (boolean) r1)
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b r2 = r8.bT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.a(r0, r1, r10)
            java.util.List r0 = r11.getPlanExpiryDetails()
            r0.clear()
            java.util.List r11 = r11.getPlanExpiryDetails()
            java.util.List r9 = r9.getPlanExpiryDetails()
            r11.addAll(r9)
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b r9 = r8.bT
            r9.notifyDataSetChanged()
            androidx.recyclerview.widget.RecyclerView r11 = r9.f62930a
            androidx.recyclerview.widget.RecyclerView$v r11 = r11.findViewHolderForLayoutPosition(r10)
            if (r11 == 0) goto L_0x01f0
            boolean r0 = r11 instanceof net.one97.paytm.recharge.legacy.catalog.hathway.a.b.a
            if (r0 == 0) goto L_0x01f0
            if (r3 == 0) goto L_0x01c7
            r0 = r11
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b$a r0 = (net.one97.paytm.recharge.legacy.catalog.hathway.a.b.a) r0
            android.widget.CheckBox r2 = r0.f62938c
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x01c7
            android.widget.CheckBox r2 = r0.f62938c
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r2.setTag(r3)
            android.widget.CheckBox r0 = r0.f62938c
            r0.setChecked(r1)
        L_0x01c7:
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b$a r11 = (net.one97.paytm.recharge.legacy.catalog.hathway.a.b.a) r11
            androidx.recyclerview.widget.RecyclerView r0 = r11.f62941f
            if (r0 == 0) goto L_0x01f0
            androidx.recyclerview.widget.RecyclerView r0 = r11.f62941f
            androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x01f0
            androidx.recyclerview.widget.RecyclerView r11 = r11.f62941f
            androidx.recyclerview.widget.RecyclerView$a r11 = r11.getAdapter()
            net.one97.paytm.recharge.legacy.catalog.hathway.a.c r11 = (net.one97.paytm.recharge.legacy.catalog.hathway.a.c) r11
            net.one97.paytm.common.entity.shopping.CJRDthPlanInfo r9 = r9.f62931b
            java.util.List r9 = r9.getServices()
            java.lang.Object r9 = r9.get(r10)
            net.one97.paytm.common.entity.shopping.CJRService r9 = (net.one97.paytm.common.entity.shopping.CJRService) r9
            java.util.List r9 = r9.getPlanExpiryDetails()
            r11.a(r9, r1)
        L_0x01f0:
            return
        L_0x01f1:
            r11 = 1000(0x3e8, float:1.401E-42)
            if (r9 != r11) goto L_0x0216
            r9 = 1002(0x3ea, float:1.404E-42)
            if (r10 != r9) goto L_0x020a
            r8.bf = r2
            r9 = 0
            r8.cD = r9
            r8.bv = r2
            net.one97.paytm.common.entity.CJRItem r9 = r8.U
            java.lang.String r9 = r9.getURL()
            r8.a((java.lang.String) r9, (boolean) r1, (boolean) r2)
            return
        L_0x020a:
            r9 = 1004(0x3ec, float:1.407E-42)
            if (r10 != r9) goto L_0x0215
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
        L_0x0215:
            return
        L_0x0216:
            r11 = 102(0x66, float:1.43E-43)
            if (r9 != r11) goto L_0x0238
            if (r10 == 0) goto L_0x0226
            boolean r9 = r8.bw
            boolean r10 = r8.bx
            java.lang.String r11 = r8.by
            r8.a((boolean) r9, (boolean) r10, (java.lang.String) r11)
            return
        L_0x0226:
            net.one97.paytm.recharge.common.utils.ay r9 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((int) r11)
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x0238
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.finish()
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.onActivityResult(int, int, android.content.Intent):void");
    }

    private void E() {
        this.bk = 0;
        this.bp = false;
        this.bo = false;
        this.bm = null;
        this.bn = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x am() {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        Context context = getContext();
        StringBuilder sb = new StringBuilder("/");
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        sb.append(c.a.a(this.bi.getFilterName()));
        sb.append("_smart_card_recharge");
        net.one97.paytm.recharge.di.helper.b.a(context, sb.toString());
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v8, types: [net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x032b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r23, int r24, android.content.Intent r25) {
        /*
            r22 = this;
            r10 = r22
            r11 = r23
            r0 = r25
            java.lang.String r1 = "data1"
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x03f8
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r11 == r3) goto L_0x032f
            r3 = 100
            if (r11 == r3) goto L_0x026a
            r1 = 602(0x25a, float:8.44E-43)
            if (r11 == r1) goto L_0x00aa
            r1 = 604(0x25c, float:8.46E-43)
            if (r11 == r1) goto L_0x0073
            r1 = 605(0x25d, float:8.48E-43)
            if (r11 == r1) goto L_0x0024
            goto L_0x03f8
        L_0x0024:
            java.lang.String r1 = "intent_extra_selected_amount"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            net.one97.paytm.common.entity.shopping.CJRPaymentOptions r0 = (net.one97.paytm.common.entity.shopping.CJRPaymentOptions) r0
            if (r0 == 0) goto L_0x03f8
            android.widget.RelativeLayout r1 = r10.cu
            if (r1 == 0) goto L_0x03f8
            r10.cv = r0
            int r2 = net.one97.paytm.recharge.R.id.multiple_months_amount_lyt
            android.view.View r1 = r1.findViewById(r2)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r2 = net.one97.paytm.recharge.R.id.months_label
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.recharge.R.id.months_value_text
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.recharge.R.string.months
            java.lang.String r4 = r10.getString(r4)
            r2.setText(r4)
            r4 = 4
            r2.setVisibility(r4)
            java.lang.String r2 = r0.getLabel()
            r3.setText(r2)
            r1.setVisibility(r5)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.setTag(r2)
            android.widget.AutoCompleteTextView r1 = r10.o
            java.lang.String r0 = r0.getAmount()
            r1.setText(r0)
            goto L_0x03f8
        L_0x0073:
            androidx.fragment.app.FragmentActivity r1 = r22.getActivity()
            if (r1 == 0) goto L_0x03f8
            android.widget.TextView r1 = r10.y
            if (r1 == 0) goto L_0x03f8
            if (r0 == 0) goto L_0x03f8
            java.lang.String r1 = "payment_mode_selected"
            java.lang.String r1 = r0.getStringExtra(r1)
            r10.ck = r0
            java.lang.String r2 = "ppi"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00a5
            android.content.Context r0 = r22.getContext()
            android.content.res.Resources r1 = r22.getResources()
            int r2 = net.one97.paytm.recharge.R.string.please_wait_progress_msg_re
            java.lang.String r1 = r1.getString(r2)
            r10.a((android.content.Context) r0, (java.lang.String) r1)
            r10.f((boolean) r4)
            goto L_0x03f8
        L_0x00a5:
            r10.a((android.content.Intent) r0)
            goto L_0x03f8
        L_0x00aa:
            java.lang.String r1 = "metro_utility_varient"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x00e6
            java.lang.String r1 = r0.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00e6
            net.one97.paytm.recharge.common.utils.y r2 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r2 = net.one97.paytm.recharge.common.utils.y.d()
            if (r2 == 0) goto L_0x00e6
            net.one97.paytm.recharge.common.utils.y r2 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r2 = net.one97.paytm.recharge.common.utils.y.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x00ce:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e6
            java.lang.Object r3 = r2.next()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
            java.lang.String r7 = r3.getFilterName()
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00ce
            r10.cc = r3
        L_0x00e6:
            java.lang.String r1 = "intent_extra_item_index"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x03f8
            android.widget.TextView r2 = r10.y
            if (r2 == 0) goto L_0x03f8
            int r12 = r0.getIntExtra(r1, r5)
            android.os.Bundle r1 = r25.getExtras()
            r2 = -1
            java.lang.String r3 = "intent_extra_child_index"
            int r13 = r1.getInt(r3, r2)
            android.os.Bundle r1 = r25.getExtras()
            java.lang.String r2 = "from_ticket_option"
            boolean r1 = r1.getBoolean(r2)
            if (r1 != r4) goto L_0x011d
            android.widget.LinearLayout r1 = r10.u
            android.view.View r1 = r1.getChildAt(r5)
            int r2 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r10.y = r1
        L_0x011d:
            android.widget.TextView r1 = r10.y
            java.lang.Object r1 = r1.getTag()
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r1.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r14 = r2.intValue()
            java.lang.Object r1 = r1.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r15 = r1.intValue()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r9 = r10.c((int) r14)
            java.util.List r8 = d((int) r15, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r9)
            java.lang.String r1 = "frequent_object"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0155
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r1
            if (r1 == 0) goto L_0x0155
            r10.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r1)
            return
        L_0x0155:
            java.lang.String r1 = "metro_qr_frequent_object"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0165
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r1 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r1
            r10.cz = r1
        L_0x0165:
            if (r8 == 0) goto L_0x021b
            if (r12 < 0) goto L_0x021b
            net.one97.paytm.recharge.legacy.catalog.b.a r1 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            if (r1 == 0) goto L_0x01b6
            net.one97.paytm.recharge.legacy.catalog.b.a r1 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r1 = r1.f62800a
            if (r1 == 0) goto L_0x01b6
            net.one97.paytm.recharge.legacy.catalog.b.a r1 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r1 = r1.f62800a
            int r1 = r1.size()
            if (r1 <= r12) goto L_0x01b6
            java.lang.String r1 = "operator_variant"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0192
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            goto L_0x019e
        L_0x0192:
            net.one97.paytm.recharge.legacy.catalog.b.a r0 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r0 = r0.f62800a
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
        L_0x019e:
            java.lang.String r1 = com.paytm.utility.e.z
            net.one97.paytm.common.entity.CJRItem r2 = r10.U
            java.lang.String r2 = r2.getCategoryId()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01b2
            net.one97.paytm.recharge.legacy.catalog.b.a r1 = net.one97.paytm.recharge.legacy.catalog.b.a.a()
            r1.f62800a = r6
        L_0x01b2:
            r1 = r0
            r0 = r24
            goto L_0x01b9
        L_0x01b6:
            r0 = r24
            r1 = r6
        L_0x01b9:
            if (r0 != r4) goto L_0x01e2
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r0 = net.one97.paytm.recharge.common.utils.y.d()
            if (r0 == 0) goto L_0x01e2
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r0 = net.one97.paytm.recharge.common.utils.y.d()
            int r0 = r0.size()
            if (r0 <= r12) goto L_0x01e2
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.List r0 = net.one97.paytm.recharge.common.utils.y.d()
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            net.one97.paytm.recharge.common.utils.y r1 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.b(r6)
            r6 = r0
            goto L_0x01e3
        L_0x01e2:
            r6 = r1
        L_0x01e3:
            if (r6 == 0) goto L_0x021b
            java.lang.String r0 = r6.getFilterName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x021b
            java.lang.String r0 = r6.getFilterName()
            java.lang.String r1 = "Delhi Metro"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x021b
            java.lang.String r0 = r6.getFilterName()
            java.lang.String r1 = "Hyderabad Metro"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x021b
            java.lang.String r0 = r6.getFilterName()
            java.lang.String r1 = "Smart Card Recharge"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x021b
            net.one97.paytm.recharge.legacy.catalog.fragment.-$$Lambda$FJRRechargeUtilityBaseV2$X6_VlEopM9dPu5mM0xsEC6St6ak r0 = new net.one97.paytm.recharge.legacy.catalog.fragment.-$$Lambda$FJRRechargeUtilityBaseV2$X6_VlEopM9dPu5mM0xsEC6St6ak
            r0.<init>()
            net.one97.paytm.recharge.widgets.c.b.a(r0)
        L_0x021b:
            r0 = r6
            if (r0 == 0) goto L_0x03f8
            r7 = 0
        L_0x021f:
            int r1 = r8.size()
            if (r7 >= r1) goto L_0x03f8
            java.lang.String r1 = r0.getFilterName()
            if (r1 == 0) goto L_0x025d
            java.lang.String r1 = r0.getFilterName()
            java.lang.Object r2 = r8.get(r7)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r2 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r2
            java.lang.String r2 = r2.getFilterName()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x025d
            android.widget.TextView r5 = r10.y
            java.lang.Object r1 = r8.get(r7)
            r6 = r1
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r6
            r16 = 0
            r1 = r22
            r2 = r15
            r3 = r12
            r4 = r13
            r17 = r7
            r7 = r16
            r16 = r8
            r8 = r9
            r18 = r9
            r9 = r14
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0263
        L_0x025d:
            r17 = r7
            r16 = r8
            r18 = r9
        L_0x0263:
            int r7 = r17 + 1
            r8 = r16
            r9 = r18
            goto L_0x021f
        L_0x026a:
            androidx.fragment.app.FragmentActivity r3 = r22.getActivity()
            if (r3 == 0) goto L_0x03f8
            if (r0 == 0) goto L_0x03f8
            android.net.Uri r13 = r25.getData()
            if (r13 == 0) goto L_0x03f8
            androidx.fragment.app.FragmentActivity r0 = r22.getActivity()     // Catch:{ all -> 0x0327 }
            android.content.ContentResolver r12 = r0.getContentResolver()     // Catch:{ all -> 0x0327 }
            java.lang.String[] r14 = new java.lang.String[]{r1}     // Catch:{ all -> 0x0327 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r3 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0327 }
            if (r3 == 0) goto L_0x02fa
            boolean r0 = r3.moveToFirst()     // Catch:{ all -> 0x0325 }
            if (r0 == 0) goto L_0x02fa
            int r0 = r3.getColumnIndex(r1)     // Catch:{ all -> 0x0325 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0325 }
            androidx.fragment.app.FragmentActivity r1 = r22.getActivity()     // Catch:{ all -> 0x0325 }
            if (r1 == 0) goto L_0x031e
            java.lang.String r1 = "-"
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = " "
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = "("
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = ")"
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x0325 }
            if (r0 == 0) goto L_0x02cd
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0325 }
            if (r1 != 0) goto L_0x02cd
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = "\\p{C}"
            java.lang.String r6 = r0.replaceAll(r1, r2)     // Catch:{ all -> 0x0325 }
        L_0x02cd:
            if (r6 == 0) goto L_0x02d5
            android.widget.AutoCompleteTextView r0 = r10.bG     // Catch:{ all -> 0x0325 }
            r0.setText(r6)     // Catch:{ all -> 0x0325 }
            goto L_0x031e
        L_0x02d5:
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ all -> 0x0325 }
            androidx.fragment.app.FragmentActivity r12 = r22.getActivity()     // Catch:{ all -> 0x0325 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r13 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0325 }
            r14 = 0
            java.lang.String r15 = "utility_hide_title"
            int r0 = net.one97.paytm.recharge.R.string.invalid_no_msg     // Catch:{ all -> 0x0325 }
            java.lang.String r16 = r10.getString(r0)     // Catch:{ all -> 0x0325 }
            r17 = 0
            java.lang.String r18 = r22.l()     // Catch:{ all -> 0x0325 }
            java.lang.String r0 = r10.P     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = r10.af     // Catch:{ all -> 0x0325 }
            r21 = 0
            r19 = r0
            r20 = r1
            net.one97.paytm.recharge.common.utils.az.a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0325 }
            goto L_0x031e
        L_0x02fa:
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ all -> 0x0325 }
            androidx.fragment.app.FragmentActivity r12 = r22.getActivity()     // Catch:{ all -> 0x0325 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r13 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0325 }
            r14 = 0
            java.lang.String r15 = "utility_hide_title"
            int r0 = net.one97.paytm.recharge.R.string.invalid_no_msg     // Catch:{ all -> 0x0325 }
            java.lang.String r16 = r10.getString(r0)     // Catch:{ all -> 0x0325 }
            r17 = 0
            java.lang.String r18 = r22.l()     // Catch:{ all -> 0x0325 }
            java.lang.String r0 = r10.P     // Catch:{ all -> 0x0325 }
            java.lang.String r1 = r10.af     // Catch:{ all -> 0x0325 }
            r21 = 0
            r19 = r0
            r20 = r1
            net.one97.paytm.recharge.common.utils.az.a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0325 }
        L_0x031e:
            if (r3 == 0) goto L_0x03f8
            r3.close()
            goto L_0x03f8
        L_0x0325:
            r0 = move-exception
            goto L_0x0329
        L_0x0327:
            r0 = move-exception
            r3 = r6
        L_0x0329:
            if (r3 == 0) goto L_0x032e
            r3.close()
        L_0x032e:
            throw r0
        L_0x032f:
            if (r0 == 0) goto L_0x0389
            java.lang.String r1 = "amount"
            java.lang.String r6 = r0.getStringExtra(r1)
            java.lang.String r1 = "operator"
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = "circle"
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r3 = "title"
            java.lang.String r3 = r0.getStringExtra(r3)
            java.lang.String r7 = "package_name"
            r0.getStringExtra(r7)
            java.lang.String r7 = "is_otc"
            boolean r7 = r0.getBooleanExtra(r7, r5)
            r10.bj = r7
            java.lang.String r7 = "plan_guid"
            java.lang.String r7 = r0.getStringExtra(r7)
            r10.bl = r7
            java.lang.String r7 = "plan_name"
            java.lang.String r7 = r0.getStringExtra(r7)
            r10.bm = r7
            java.lang.String r7 = r10.bn
            if (r7 == 0) goto L_0x037c
            java.lang.String r8 = r10.bm
            if (r8 == 0) goto L_0x037c
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0377
            r10.bo = r5
            goto L_0x0380
        L_0x0377:
            r10.bp = r5
            r10.bo = r4
            goto L_0x0380
        L_0x037c:
            r10.bp = r5
            r10.bo = r4
        L_0x0380:
            java.lang.String r4 = r10.bm
            r10.bn = r4
            boolean r4 = r10.bj
            r10.bk = r4
            goto L_0x038c
        L_0x0389:
            r1 = r6
            r2 = r1
            r3 = r2
        L_0x038c:
            if (r1 == 0) goto L_0x03ba
            if (r2 == 0) goto L_0x03ba
            if (r3 == 0) goto L_0x03ba
            if (r6 == 0) goto L_0x03ba
            android.widget.AutoCompleteTextView r1 = r10.o
            if (r1 == 0) goto L_0x03ba
            java.lang.Boolean r0 = com.paytm.utility.b.K((java.lang.String) r6)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x03b4
            double r0 = java.lang.Double.parseDouble(r6)
            double r0 = com.paytm.utility.b.b((double) r0)
            android.widget.AutoCompleteTextView r2 = r10.o
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.setText(r0)
            goto L_0x03f8
        L_0x03b4:
            android.widget.AutoCompleteTextView r0 = r10.o
            r0.setText(r6)
            goto L_0x03f8
        L_0x03ba:
            boolean r1 = r10.ax
            if (r1 == 0) goto L_0x03f8
            if (r6 == 0) goto L_0x03f8
            android.widget.AutoCompleteTextView r1 = r10.o
            if (r1 == 0) goto L_0x03f8
            java.lang.Boolean r1 = com.paytm.utility.b.K((java.lang.String) r6)
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x03e0
            double r1 = java.lang.Double.parseDouble(r6)
            double r1 = com.paytm.utility.b.b((double) r1)
            android.widget.AutoCompleteTextView r3 = r10.o
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.z.a((double) r1)
            r3.setText(r1)
            goto L_0x03e5
        L_0x03e0:
            android.widget.AutoCompleteTextView r1 = r10.o
            r1.setText(r6)
        L_0x03e5:
            java.lang.String r1 = "meta_description"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)     // Catch:{ Exception -> 0x03f0 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x03f0 }
            r10.ay = r0     // Catch:{ Exception -> 0x03f0 }
            goto L_0x03f8
        L_0x03f0:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x03f8:
            r0 = 3
            if (r11 == r0) goto L_0x03fe
            r0 = 7
            if (r11 != r0) goto L_0x0411
        L_0x03fe:
            androidx.fragment.app.FragmentActivity r0 = r22.getActivity()
            boolean r0 = net.one97.paytm.recharge.common.utils.z.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x040c
            r22.F()
            return
        L_0x040c:
            net.one97.paytm.recharge.common.utils.ay r0 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((int) r23)
        L_0x0411:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.a(int, int, android.content.Intent):void");
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("payment_mode_selected");
        this.bR = intent.getStringExtra("convenience_fee_selected");
        this.an = stringExtra.toUpperCase();
        androidx.core.g.d<String, String> a2 = ba.a(stringExtra, getContext());
        if (a2 != null) {
            a((String) a2.f2965b, this.y, getString(R.string.select_payment_mode), false, (String) a2.f2964a);
        }
        LinearLayout linearLayout = this.aB;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            ((TextView) this.aB.findViewById(R.id.convenience_fee_text)).setText(getResources().getString(R.string.rs) + this.bR);
        }
        this.n.setText(getResources().getString(R.string.proceed_btn_ff_selected, new Object[]{String.valueOf(((double) Math.round((Double.parseDouble(m(this.bR)) + Double.parseDouble(D())) * 100.0d)) / 100.0d)}));
    }

    private void a(String str, String str2, boolean z2) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str, str2, z2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return FJRRechargeUtilityBaseV2.this.b(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b(String str, String str2, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_group_field", str);
        hashMap.put("recharge_utilities_group_field_value", str2);
        if (z2) {
            hashMap.put("recharge_utilities_selection_method", "automatic");
        } else {
            hashMap.put("recharge_utilities_selection_method", "manual");
        }
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_group_field_selected", getActivity());
        return null;
    }

    private void F() {
        Button button = this.n;
        if (button != null) {
            button.performClick();
        }
        if (this.al) {
            this.al = false;
        }
    }

    public final void g() {
        if (getActivity() != null) {
            a((Context) getActivity(), getResources().getString(R.string.please_wait_progress_msg_re));
        }
    }

    public final void d(String str) {
        a((Context) getActivity(), str);
    }

    public final void i() {
        CJRUtilityPrefetchV2 X2 = X();
        if (X2 == null || this.A.getChildCount() != 0) {
            a((Context) getActivity(), getResources().getString(R.string.please_wait_progress_msg_re));
        } else {
            a((Context) getActivity(), X2.getProcessing());
        }
    }

    public final void h() {
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.p;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        c(true);
        r();
        ah();
    }

    /* access modifiers changed from: protected */
    public final void b(int i2) {
        if (i2 == 4) {
            ah();
        }
    }

    public final void c() {
        this.bo = false;
        this.bp = true;
        this.bk = 0;
    }

    public final void a(CJRRechargeCart cJRRechargeCart, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        List<CJRUtilityProductV2> list;
        String str;
        boolean z2;
        AutoCompleteTextView autoCompleteTextView;
        CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        Object obj2 = obj;
        if (getActivity() != null) {
            if (this.at) {
                h();
                z.a(cJRRechargeCart, getContext(), getChildFragmentManager(), B(), ag(), new View.OnClickListener(cJRRechargeCart2) {
                    private final /* synthetic */ CJRRechargeCart f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        FJRRechargeUtilityBaseV2.this.a(this.f$1, view);
                    }
                }, this.bq);
            } else if (cJRRechargeCart2 != null) {
                this.bK = cJRRechargeCart2;
                boolean z3 = true;
                if (this.bk == 1 && this.bj && this.bo) {
                    double c2 = c(cJRRechargeCart);
                    if (c2 >= 0.0d) {
                        double parseDouble = Double.parseDouble(v());
                        this.o.setText(String.valueOf(c2));
                        net.one97.paytm.recharge.common.fragment.a.a(c2, parseDouble).show(getChildFragmentManager(), "fragment_edit_name");
                        d(false);
                        return;
                    }
                }
                AutoCompleteTextView autoCompleteTextView2 = this.o;
                if (autoCompleteTextView2 == null || autoCompleteTextView2.getVisibility() != 0) {
                    String categoryId = this.U.getCategoryId();
                    if (TextUtils.isEmpty(categoryId) || !categoryId.equals("46007") || cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0 || cJRRechargeCart.getCart().getCartItems().get(0) == null || cJRRechargeCart.getCart().getCartItems().get(0).getmProductAttrubutes() == null || !cJRRechargeCart.getCart().getCartItems().get(0).getmProductAttrubutes().getOtp_flow() || cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions() == null || cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions() == null || cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions().get(0) == null || cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions().get(0).getAdditionalUserInfo() == null) {
                        this.ca = az.c(getContext(), this.U.getCategoryId(), cJRRechargeCart2);
                        this.cb = az.a(getContext(), this.U.getCategoryId(), cJRRechargeCart2);
                        d(cJRRechargeCart);
                        List<CJRPaymentOptions> list2 = this.aE;
                        if (!(list2 == null || list2.size() <= 0 || (autoCompleteTextView = this.o) == null)) {
                            autoCompleteTextView.performClick();
                        }
                        d(false);
                        return;
                    }
                    String mobileNumber = cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions().get(0).getAdditionalUserInfo().getMobileNumber();
                    Intent intent = new Intent(getActivity(), AJROtpRechargeActivity.class);
                    intent.putExtra("user_mobile", mobileNumber);
                    intent.putExtra("action_type", "Register");
                    startActivityForResult(intent, 547);
                }
                this.ca = az.c(getContext(), this.U.getCategoryId(), cJRRechargeCart2);
                this.cb = az.a(getContext(), this.U.getCategoryId(), cJRRechargeCart2);
                az azVar = az.f61525a;
                Bundle a2 = az.a(getContext(), cJRRechargeCart2, false, false);
                boolean z4 = a2.getBoolean("extra.has.error");
                if (cJRRechargeCart.getCartStatus() == null || !"SUCCESS".equalsIgnoreCase(cJRRechargeCart.getCartStatus().getResult()) || z4) {
                    G();
                    h();
                    d(false);
                    String string = a2.getString("extra.error.title");
                    String string2 = a2.getString("extra.error.msg");
                    if (TextUtils.isEmpty(string2)) {
                        string2 = getResources().getString(R.string.network_error_message_re);
                    }
                    String str2 = string2;
                    if (TextUtils.isEmpty(string)) {
                        string = getString(R.string.network_error_heading_re);
                    }
                    String str3 = string;
                    ACTION_TYPE action_type = ACTION_TYPE.UNDEFINED;
                    if (obj2 instanceof CJRRechargeErrorModel) {
                        cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                        cJRRechargeErrorModel.setErrorMsg(str2);
                        if (cJRRechargeErrorModel.getFlowName() != null) {
                            action_type = ACTION_TYPE.Companion.getActionType(cJRRechargeErrorModel.getFlowName().getActionType(), ACTION_TYPE.UNDEFINED);
                        }
                    } else {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    }
                    CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
                    az azVar2 = az.f61525a;
                    az.a(getActivity(), ERROR_TYPE.UNDEFINED, action_type, str3, str2, false, cJRRechargeErrorModel2.getCategoryId(), cJRRechargeErrorModel2.getScreenName(), cJRRechargeErrorModel2.getProductId(), cJRRechargeErrorModel2, false);
                } else if (f(cJRRechargeCart)) {
                    d(false);
                    g(cJRRechargeCart);
                } else {
                    List<CJRUtilityProductV2> list3 = this.Y;
                    if (list3 == null || list3.size() <= 0 || this.Y.get(0) == null || (!this.ca && this.Y.get(0).isConvenienceFee() && (TextUtils.isEmpty(cJRRechargeCart.getCart().getPaymentMethod()) || cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0 || cJRRechargeCart.getCart().getCartItems().get(0).getConvenienceFeeMap().size() <= 0))) {
                        z3 = false;
                    }
                    if (z3 && L()) {
                        if (!P() && ((list = this.Y) == null || list.size() <= 0 || this.Y.get(0) == null || this.Y.get(0).getAttributes() == null || !this.Y.get(0).getAttributes().isProceedDirectlyToPG())) {
                            r();
                            d(false);
                            if (this.Z.getLastUtilityProductList() != null) {
                                z2 = this.Z.getLastUtilityProductList().isDealsFastforward();
                                str = this.Z.getLastUtilityProductList().getProtectionUrl();
                            } else {
                                str = null;
                                z2 = false;
                            }
                            List<CJRUtilityProductV2> list4 = this.Y;
                            if (list4 != null && list4.size() > 0 && this.Y.get(0).getAttributes() != null && !TextUtils.isEmpty(this.Y.get(0).getAttributes().getDealsMessage())) {
                                this.Y.get(0).getAttributes().getDealsMessage();
                            }
                            if (D().length() > 0) {
                                b(D(), this.ai);
                            }
                            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                            FragmentActivity activity = getActivity();
                            String str4 = this.bz;
                            Class<AJRCouponsActivityV8> a3 = a(ba.b.COUPONS, cJRRechargeCart2);
                            if (a3 == null) {
                                a3 = AJRCouponsActivityV8.class;
                            }
                            net.one97.paytm.recharge.common.utils.a.a(activity, str4, cJRRechargeCart, a3, Boolean.valueOf(z2), str, af(), this.am, this.Z.getGaKey(), this.an, this.aL, this.Q, this.aa, (String) null, (Boolean) null, Boolean.FALSE);
                        } else if (!this.cb) {
                            f(false);
                        } else {
                            az azVar3 = az.f61525a;
                            az.a(cJRRechargeCart);
                            a((CJRRechargePayment) null);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRRechargeCart cJRRechargeCart, View view) {
        int id = view.getId();
        if (id == R.id.action_button) {
            z.a(cJRRechargeCart, getContext(), this.Y.get(0).getAttributes().isBankMandateEnable());
        } else if (id == R.id.close) {
            d(false);
        }
    }

    private boolean a(CJRRechargeCart cJRRechargeCart, ACTION_TYPE action_type) {
        az azVar = az.f61525a;
        boolean a2 = az.a(getContext(), cJRRechargeCart, action_type);
        if (a2) {
            G();
            h();
        }
        return a2;
    }

    private void G() {
        CJRUtilityVariantV2 cJRUtilityVariantV2;
        List<CJRUtilityProductV2> list;
        AutoCompleteTextView autoCompleteTextView;
        if (this.U != null && com.paytm.utility.e.z.equalsIgnoreCase(this.U.getCategoryId()) && getContext() != null && (list = this.Y) != null && list.size() > 0 && this.Y.get(0).getAttributes() != null && "1".equalsIgnoreCase(this.Y.get(0).getAttributes().getPrefetch()) && (autoCompleteTextView = this.o) != null && autoCompleteTextView.getVisibility() != 0) {
            CJRUtilityVariantV2 cJRUtilityVariantV22 = this.bi;
            if (cJRUtilityVariantV22 != null && !TextUtils.isEmpty(cJRUtilityVariantV22.getFilterName())) {
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                new net.one97.paytm.recharge.ordersummary.h.d(getContext()).a(c.a.a(this.bi.getFilterName()), "get_card_balance_error", "", "smart_card_recharge", ab.f61496a, "", "");
            }
        } else if (this.U != null && com.paytm.utility.e.z.equalsIgnoreCase(this.U.getCategoryId()) && getContext() != null && (cJRUtilityVariantV2 = this.bi) != null && !TextUtils.isEmpty(cJRUtilityVariantV2.getFilterName())) {
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            new net.one97.paytm.recharge.ordersummary.h.d(getContext()).a(c.a.a(this.bi.getFilterName()), "proceed_error", "", "smart_card_recharge", ab.f61496a, "", "");
        }
    }

    private static double c(CJRRechargeCart cJRRechargeCart) {
        try {
            return Double.parseDouble(cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions().get(0).getBillAmount());
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    private void g(String str) {
        if (URLUtil.isValidUrl(str)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.aC.getText() != null) {
                    jSONObject.put("recharge_number", this.aC.getText().toString());
                }
                jSONObject.put(CLPConstants.PRODUCT_ID, this.Y.get(0).getId());
            } catch (JSONException unused) {
            }
            AnonymousClass7 r4 = new ai() {
                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    if (iJRPaytmDataModel instanceof CJRDynamicBrowsePlans) {
                        try {
                            CJRDynamicBrowsePlans cJRDynamicBrowsePlans = (CJRDynamicBrowsePlans) iJRPaytmDataModel;
                            FJRRechargeUtilityBaseV2.this.av = ar.a(cJRDynamicBrowsePlans);
                            FJRRechargeUtilityBaseV2.this.aw = ar.b(cJRDynamicBrowsePlans);
                        } catch (Exception e2) {
                            q.d(e2.getMessage());
                        }
                        FJRRechargeUtilityBaseV2.this.h();
                    }
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    FJRRechargeUtilityBaseV2.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                }
            };
            CJRDynamicBrowsePlans cJRDynamicBrowsePlans = new CJRDynamicBrowsePlans();
            String jSONObject2 = jSONObject.toString();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c("fetch_dynamic_plan", str, (ai) r4, (IJRPaytmDataModel) cJRDynamicBrowsePlans, (Map<String, String>) hashMap2, (Map<String, String>) hashMap, jSONObject2, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
            if (com.paytm.utility.b.c(getContext())) {
                g();
                getContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
            }
        }
    }

    public final void a(CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
        this.au = cJRAutomaticSubscriptionListModel;
    }

    public void a(CJRUtilityProductListV2 cJRUtilityProductListV2) {
        CJRItem cJRItem;
        CJRUtilityProductListV2 cJRUtilityProductListV22 = this.Z;
        if (cJRUtilityProductListV22 == null) {
            if (!com.paytm.utility.e.z.equalsIgnoreCase(this.U.getCategoryId())) {
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(cJRUtilityProductListV2) {
                    private final /* synthetic */ CJRUtilityProductListV2 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object invoke() {
                        return FJRRechargeUtilityBaseV2.this.d(this.f$1);
                    }
                });
            }
            if (cJRUtilityProductListV2 != null && !cJRUtilityProductListV2.isRecentsPrefill()) {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                if (net.one97.paytm.recharge.di.helper.c.ar() && com.paytm.utility.e.z.equalsIgnoreCase(String.valueOf(cJRUtilityProductListV2.getId()))) {
                    cJRUtilityProductListV2.setRecentsPrefill(true);
                }
            }
            this.Z = cJRUtilityProductListV2;
            this.bz = this.Z.getName();
            if (cJRUtilityProductListV2.getBottomTabDataList() != null && cJRUtilityProductListV2.getBottomTabDataList().size() > 1 && (getActivity() instanceof ak)) {
                getActivity();
                cJRUtilityProductListV2.getBottomTabDataList();
            }
            this.Z.setGroupLevel(1);
            this.G = this.Z.getShowFastforward().booleanValue();
            this.H = this.Z.getProtectionUrl();
            if (this.Z.getRc() != null && this.Z.getRc().size() > 0 && !this.at) {
                List<CJRUtilityRcV2> rc = this.Z.getRc();
                if (getActivity() != null) {
                    this.I.removeAllViews();
                    LinearLayout linearLayout = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.radio_group_custom_view, (ViewGroup) null);
                    CustomRadioGroupBaseV2 customRadioGroupBaseV2 = (CustomRadioGroupBaseV2) linearLayout.findViewById(R.id.custom_type_radio_group);
                    linearLayout.findViewById(R.id.payment_underline).setVisibility(8);
                    int f2 = com.paytm.utility.b.f((Context) getActivity());
                    customRadioGroupBaseV2.removeAllViews();
                    for (int i2 = 0; i2 < rc.size(); i2++) {
                        RadioButton radioButton = new RadioButton(getActivity());
                        radioButton.setTextAppearance(getActivity(), R.style.radioButtonStyle);
                        radioButton.setPadding(f2 / 2, 0, f2, 0);
                        radioButton.setText(rc.get(i2).getLabel());
                        radioButton.setButtonDrawable(R.drawable.btn_radio_holo_light);
                        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
                        radioButton.setTag(rc.get(i2));
                        if (rc.get(i2).isSelected()) {
                            radioButton.setTextColor(androidx.core.content.b.c(getContext(), R.color.radiobutton_selected_color));
                        } else {
                            radioButton.setTextColor(androidx.core.content.b.c(getContext(), R.color.radiobutton_unselected_color));
                        }
                        layoutParams.weight = 0.5f;
                        CJRUtilityRcV2 cJRUtilityRcV2 = rc.get(i2);
                        HashMap<String, String> hashMap = this.O;
                        if (hashMap != null && hashMap.containsKey("service") && !TextUtils.isEmpty(cJRUtilityRcV2.getLabel()) && cJRUtilityRcV2.getLabel().contains(this.O.get("service"))) {
                            radioButton.setChecked(true);
                            if (!cJRUtilityRcV2.isSelected()) {
                                this.u.removeAllViews();
                                this.A.removeAllViews();
                                this.I.removeAllViews();
                                a(cJRUtilityRcV2.getUrl(), true, false);
                                this.ai = cJRUtilityRcV2.getLabel();
                            }
                        } else if (cJRUtilityRcV2.isSelected()) {
                            radioButton.setChecked(true);
                        }
                        customRadioGroupBaseV2.addView(radioButton, layoutParams);
                        radioButton.setOnTouchListener(new View.OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                FJRRechargeUtilityBaseV2.this.O.clear();
                                return false;
                            }
                        });
                    }
                    customRadioGroupBaseV2.setOnCheckedChangeListener(this.bg);
                    int i3 = f2 / 2;
                    customRadioGroupBaseV2.setPadding(0, i3, 0, i3);
                    if (customRadioGroupBaseV2.getChildCount() > 1) {
                        this.I.addView(linearLayout);
                    }
                }
            }
            a(this.Z.getVariantList(), 0, (CJRUtilityVariantV2) null, this.Z);
            String heading = this.Z.getHeading();
            if (TextUtils.isEmpty(heading) && (cJRItem = this.U) != null && !TextUtils.isEmpty(cJRItem.getName())) {
                heading = this.U.getName();
            }
            if ((getActivity() instanceof AJRRechargeUtilityActivity) && !this.at) {
                getActivity().setTitle(heading);
            }
            CJRUtilityProductListV2 cJRUtilityProductListV23 = this.Z;
            if (cJRUtilityProductListV23 != null && !this.at) {
                c(cJRUtilityProductListV23);
                return;
            }
            return;
        }
        cJRUtilityProductListV22.getLastUtilityProductList().setNextLevelProductList(cJRUtilityProductListV2);
        a(this.Z.getLastUtilityProductList().getVariantList(), 0, (CJRUtilityVariantV2) null, this.Z.getLastUtilityProductList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x d(CJRUtilityProductListV2 cJRUtilityProductListV2) {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(getContext(), cJRUtilityProductListV2.getGAEventScreenName());
        return null;
    }

    private void d(CJRRechargeCart cJRRechargeCart) {
        this.B = true;
        int i2 = 0;
        while (i2 < cJRRechargeCart.getCart().getCartItems().size()) {
            if (cJRRechargeCart.getCart().getCartItems().get(i2).getServiceOptions() == null) {
                cJRRechargeCart.getCart().getCartItems().remove(i2);
                i2--;
            }
            i2++;
        }
        if (cJRRechargeCart.getCart().getCartItems().size() == 0) {
            if (cJRRechargeCart.getCart().getError() != null) {
                i(cJRRechargeCart.getCart().getError());
            }
            a(cJRRechargeCart, ACTION_TYPE.VERIFY_CALL);
            return;
        }
        final List<CJRUtilityInputFieldsV2> inputFields = this.Y.get(0).getInputFields();
        for (final int i3 = 0; i3 < inputFields.size(); i3++) {
            if (!inputFields.get(i3).getMandatory()) {
                if (inputFields.get(i3).getType().equalsIgnoreCase("amount")) {
                    if (getActivity() != null) {
                        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.custom_auto_complete_text_view_cantainer, (ViewGroup) null);
                        inflate.setTag(Boolean.TRUE);
                        this.cu = (RelativeLayout) inflate;
                        AutoCompleteTextView autoCompleteTextView = this.o;
                        if (autoCompleteTextView != null) {
                            autoCompleteTextView.setVisibility(8);
                        }
                        this.o = (AutoCompleteTextView) inflate.findViewById(R.id.edit_no);
                        this.o.setOnClickListener(this.cB);
                        this.ct = (TextInputLayout) inflate.findViewById(R.id.text_input_layout_utility_amount);
                        this.ct.setHint(getString(R.string.utility_amount_hint_text, inputFields.get(i3).getTitle()));
                        if (inputFields.get(i3).getRight_button_url() != null) {
                            TextView textView = (TextView) this.cu.findViewById(R.id.sample_bill);
                            textView.setVisibility(0);
                            textView.setText(inputFields.get(i3).getRight_button_label());
                            textView.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                                        public final Object invoke() {
                                            return FJRRechargeUtilityBaseV2.AnonymousClass8.this.a();
                                        }
                                    });
                                    FragmentActivity activity = FJRRechargeUtilityBaseV2.this.getActivity();
                                    net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                                    Intent intent = new Intent(activity, net.one97.paytm.recharge.di.helper.a.c());
                                    intent.putExtra("url", ((CJRUtilityInputFieldsV2) inputFields.get(i3)).getRight_button_url());
                                    intent.putExtra("title", ((CJRUtilityInputFieldsV2) inputFields.get(i3)).getRight_button_label());
                                    intent.putExtra(UpiConstants.FROM, "electricity");
                                    FJRRechargeUtilityBaseV2.this.startActivity(intent);
                                }

                                /* access modifiers changed from: private */
                                public /* synthetic */ x a() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("recharge_utilities_service_type", FJRRechargeUtilityBaseV2.this.ai);
                                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                                    net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_view_sample_bill_clicked", FJRRechargeUtilityBaseV2.this.getActivity());
                                    return null;
                                }
                            });
                        }
                        this.aD = inputFields.get(i3).getTitle();
                        inflate.setPadding(0, 15, 0, 0);
                        this.o.setTag("InputField_".concat(String.valueOf(i3)));
                        this.o.setInputType(8194);
                        int i4 = 6;
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        String Z2 = net.one97.paytm.recharge.di.helper.c.Z();
                        if (!TextUtils.isEmpty(Z2)) {
                            try {
                                i4 = Integer.parseInt(Z2);
                            } catch (Exception e2) {
                                if (com.paytm.utility.b.v) {
                                    q.d(e2.getMessage());
                                }
                            }
                        }
                        List<CJRUtilityProductV2> list = this.Y;
                        if (list == null || list.size() <= 0 || this.Y.get(0) == null || this.Y.get(0).getAttributes() == null || !this.Y.get(0).getAttributes().isShowBrowsePlan() || !this.Y.get(0).getAttributes().isDynamicPlan()) {
                            List<CJRUtilityProductV2> list2 = this.Y;
                            if (list2 != null && list2.size() > 0 && this.Y.get(0) != null && this.Y.get(0).getAttributes() != null && this.Y.get(0).getAttributes().isShowBrowsePlan() && !this.Y.get(0).getAttributes().isDynamicPlan()) {
                                TextView textView2 = (TextView) inflate.findViewById(R.id.browse_plan);
                                TextView textView3 = (TextView) inflate.findViewById(R.id.for_operator_text);
                                textView2.setVisibility(0);
                                textView2.setText(getString(R.string.browse_plans_txt));
                                textView3.setVisibility(0);
                                textView3.setText("of " + this.Y.get(0).getDisplayName());
                                textView2.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        FJRRechargeUtilityBaseV2.m(FJRRechargeUtilityBaseV2.this);
                                    }
                                });
                            }
                        } else {
                            this.ax = true;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.extra_link_textview);
                            textView4.setVisibility(0);
                            textView4.setText(getString(R.string.browse_plans_txt));
                            textView4.setOnClickListener(this.aH);
                            if (this.aw == null && this.av == null) {
                                net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                                g(net.one97.paytm.recharge.di.helper.c.G());
                            }
                        }
                        net.one97.paytm.recharge.common.widget.e eVar = new net.one97.paytm.recharge.common.widget.e(i4);
                        eVar.f62154a = true;
                        this.o.setFilters(new InputFilter[]{eVar});
                        if (this.U != null && com.paytm.utility.e.z.equals(this.U.getCategoryId())) {
                            this.o.setKeyListener(DigitsKeyListener.getInstance("0123456789,"));
                        }
                        this.o.addTextChangedListener(this.bd);
                        this.o.setOnTouchListener(new View.OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                if (FJRRechargeUtilityBaseV2.this.aG) {
                                    motionEvent.getAction();
                                }
                                if (motionEvent.getAction() != 0) {
                                    return false;
                                }
                                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                                    public final Object invoke() {
                                        return FJRRechargeUtilityBaseV2.AnonymousClass10.this.a();
                                    }
                                });
                                return false;
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ x a() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("recharge_utilities_group_field_values", FJRRechargeUtilityBaseV2.this.z());
                                hashMap.put("recharge_utilities_input_field_values", FJRRechargeUtilityBaseV2.this.A());
                                hashMap.put("recharge_utilities_amount_type", FJRRechargeUtilityBaseV2.this.t());
                                hashMap.put("recharge_utilities_service_type", FJRRechargeUtilityBaseV2.this.ai);
                                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                                net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_amount_clicked", FJRRechargeUtilityBaseV2.this.getActivity());
                                return null;
                            }
                        });
                        this.o.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            public final void onFocusChange(View view, boolean z) {
                                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(z) {
                                    private final /* synthetic */ boolean f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final Object invoke() {
                                        return FJRRechargeUtilityBaseV2.AnonymousClass11.this.a(this.f$1);
                                    }
                                });
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ x a(boolean z) {
                                if (z || FJRRechargeUtilityBaseV2.this.D().length() <= 0) {
                                    return null;
                                }
                                HashMap hashMap = new HashMap();
                                if (FJRRechargeUtilityBaseV2.this.o != null) {
                                    hashMap.put("recharge_utilities_amount", FJRRechargeUtilityBaseV2.this.D());
                                }
                                hashMap.put("recharge_utilities_amount_type", FJRRechargeUtilityBaseV2.this.t());
                                hashMap.put("recharge_utilities_group_field_values", FJRRechargeUtilityBaseV2.this.z());
                                hashMap.put("recharge_utilities_input_field_values", FJRRechargeUtilityBaseV2.this.A());
                                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                                net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_amount_entered", FJRRechargeUtilityBaseV2.this.getActivity());
                                return null;
                            }
                        });
                        this.A.addView(inflate);
                        if (this.bN != null) {
                            V();
                        }
                        if (inputFields.get(i3).ismReadOnly()) {
                            this.co = false;
                            this.o.setLongClickable(false);
                            this.o.setFocusable(false);
                        } else {
                            this.co = true;
                        }
                        Z();
                        a((RoboTextView) inflate.findViewById(R.id.message_input_field), inputFields.get(i3).getMessage());
                    }
                } else if (inputFields.get(i3).getType().equalsIgnoreCase(RequestConfirmationDialogFragment.KEY_DESCRIPTION)) {
                    this.C = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.linear_description_layout, (ViewGroup) null);
                    this.C.setVisibility(8);
                    TextView textView5 = (TextView) this.C.findViewById(R.id.description_title);
                    textView5.setTextAppearance(getContext(), R.style.descripTitleStyle);
                    textView5.setText(inputFields.get(i3).getTitle());
                    int i5 = this.r;
                    textView5.setPadding(i5 / 2, 0, 0, i5 / 4);
                    LinearLayout linearLayout = this.C;
                    int i6 = this.r;
                    linearLayout.setPadding(i6 / 2, (int) (((double) i6) * 0.8d), 0, (int) (((double) i6) * 0.8d));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    int a2 = com.paytm.utility.b.a(15, getContext());
                    layoutParams.setMargins(a2, a2, a2, 0);
                    this.C.setLayoutParams(layoutParams);
                    this.C.setTag(Boolean.TRUE);
                    this.A.addView(this.C);
                }
            }
        }
        e(cJRRechargeCart);
        if (this.co) {
            AutoCompleteTextView autoCompleteTextView2 = this.o;
            if (autoCompleteTextView2 != null) {
                autoCompleteTextView2.requestFocus();
                return;
            }
            Button button = this.n;
            if (button != null) {
                button.setFocusableInTouchMode(true);
                this.n.requestFocus();
                this.n.setFocusableInTouchMode(false);
                return;
            }
            return;
        }
        Button button2 = this.n;
        if (button2 != null) {
            button2.setFocusableInTouchMode(true);
            this.n.requestFocus();
            this.n.setFocusableInTouchMode(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final String t() {
        CJRUtilityAttributesV2 attributes = this.Y.get(0).getAttributes();
        String name = d.a.non_prefetch.name();
        if (!(attributes != null ? attributes.getPrefetch() : "").equals("1")) {
            return name;
        }
        if (this.co) {
            return d.a.prefetch_editable.name();
        }
        return d.a.prefetch_non_editable.name();
    }

    private static boolean h(String str) {
        return !TextUtils.isEmpty(str) && str.matches("-\\d+(\\.\\d+)?");
    }

    private void e(CJRRechargeCart cJRRechargeCart) {
        CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        this.B = true;
        try {
            if (!(cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0)) {
                if (cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions() != null) {
                    ArrayList<CJRServiceActions> actions = cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions().getActions();
                    int displayArrayIndex = cJRRechargeCart.getCart().getCartItems().get(0).getDisplayArrayIndex();
                    if (actions == null || actions.size() <= 0) {
                        az azVar = az.f61525a;
                        az.a((Context) getActivity(), ERROR_TYPE.UNDEFINED, (ACTION_TYPE) null, cJRRechargeCart2);
                        I();
                    } else {
                        this.cm = actions.get(displayArrayIndex).getBillAmountMax();
                        this.cn = actions.get(displayArrayIndex).getBillAmountMin();
                        ArrayList<CJRDisplayValues> displayValues = actions.get(displayArrayIndex).getDisplayValues();
                        this.bH = displayValues;
                        if (displayValues != null && displayValues.size() > 0) {
                            this.C.setVisibility(0);
                            String billAmount = actions.get(displayArrayIndex).getBillAmount();
                            if (h(billAmount)) {
                                double abs = Math.abs(Double.parseDouble(billAmount));
                                CJRDisplayValues cJRDisplayValues = new CJRDisplayValues();
                                cJRDisplayValues.setmLabel(getResources().getString(R.string.advance_amount));
                                cJRDisplayValues.setmValue(String.valueOf(abs));
                                displayValues.add(cJRDisplayValues);
                            }
                            for (int i2 = 0; i2 < displayValues.size(); i2++) {
                                if (getActivity() != null) {
                                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.recharge_util_description_layout, (ViewGroup) null);
                                    TextView textView = (TextView) linearLayout.findViewById(R.id.firsttext);
                                    TextView textView2 = (TextView) linearLayout.findViewById(R.id.secondtext);
                                    if (!TextUtils.isEmpty(displayValues.get(i2).getLabel()) && !TextUtils.isEmpty(displayValues.get(i2).getValue())) {
                                        textView.setVisibility(0);
                                        textView.setText(displayValues.get(i2).getLabel().trim());
                                        textView.setPadding(0, 0, 0, 10);
                                        textView2.setVisibility(0);
                                        textView2.setText(displayValues.get(i2).getValue().trim());
                                        textView2.setPadding(0, 0, this.r, 10);
                                        getContext();
                                        com.paytm.utility.b.a(textView);
                                        getContext();
                                        com.paytm.utility.b.a(textView2);
                                        this.C.addView(linearLayout);
                                    }
                                }
                            }
                        }
                        LinearLayout linearLayout2 = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.education_checkbox_layout, (ViewGroup) null);
                        TextView textView3 = (TextView) linearLayout2.findViewById(R.id.check_box_label);
                        List<CJRUtilityCheckboxItem> a2 = a(cJRRechargeCart.getCart().getCartItems());
                        if (a2.size() > 0 && U() >= 0) {
                            textView3.setText(this.Z.getLastUtilityProductList().getGroupFieldV2(U()).getLabel());
                            textView3.setVisibility(0);
                            RecyclerView recyclerView = (RecyclerView) linearLayout2.findViewById(R.id.education_checkbox_view);
                            recyclerView.setHasFixedSize(true);
                            if (!(this.Y == null || this.Y.size() <= 0 || this.Y.get(0) == null || this.Y.get(0).getAttributes() == null)) {
                                if ("list".equalsIgnoreCase(this.Y.get(0).getAttributes().getCheckboxDisplayType())) {
                                    recyclerView.setLayoutManager(new LinearLayoutManager(this.R));
                                } else {
                                    recyclerView.setLayoutManager(new GridLayoutManager(this.R, 2));
                                }
                                k kVar = r1;
                                k kVar2 = new k(getActivity(), a2, this, this.Y.get(0).getAttributes().getCheckboxDisplayType(), this.Y.get(0).getAttributes().isPayFeeBeforeEnabled());
                                recyclerView.setAdapter(kVar);
                                this.C.setVisibility(0);
                                this.C.addView(linearLayout2);
                            }
                        }
                        CJRServiceActions cJRServiceActions = actions.get(displayArrayIndex);
                        this.bO = true;
                        String billAmount2 = cJRServiceActions.getBillAmount();
                        if (TextUtils.isEmpty(billAmount2)) {
                            if (!(this.O == null || !this.O.containsKey("price") || this.o == null)) {
                                this.o.setText(this.O.get("price"));
                            }
                            if (this.o != null) {
                                this.co = true;
                                this.o.setEnabled(true);
                                c(false);
                                if (!cJRServiceActions.isBillAmountEditable()) {
                                    this.co = false;
                                    this.o.setLongClickable(false);
                                    this.o.setEnabled(false);
                                    this.n.setText(getActivity().getResources().getString(R.string.proceed_re));
                                    this.bO = false;
                                }
                            }
                        } else if (this.o != null) {
                            if (!cJRServiceActions.isBillAmountEditable()) {
                                this.o.setFilters(new InputFilter[0]);
                                this.o.setEnabled(true);
                                this.o.setFocusable(false);
                                this.co = false;
                                this.o.setLongClickable(false);
                                if (billAmount2.equals("0")) {
                                    c(false);
                                    this.n.setText(R.string.no_outstanding);
                                    this.bO = false;
                                }
                            } else {
                                this.co = true;
                                this.o.setEnabled(true);
                            }
                            if (!h(billAmount2)) {
                                this.o.setText(billAmount2);
                            }
                        }
                        CJRDthPlanInfo dthPlanInfo = actions.get(displayArrayIndex).getDthPlanInfo();
                        AutoCompleteTextView autoCompleteTextView = this.o;
                        if (dthPlanInfo != null) {
                            this.n.setText(getActivity().getResources().getString(R.string.proceed_re));
                            autoCompleteTextView.setEnabled(true);
                            c(true);
                            autoCompleteTextView.setInputType(0);
                            LinearLayout linearLayout3 = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.education_checkbox_layout, (ViewGroup) null);
                            TextView textView4 = (TextView) linearLayout3.findViewById(R.id.check_box_label);
                            textView4.setTypeface(textView4.getTypeface(), 1);
                            textView4.setTextSize(16.0f);
                            textView4.setText(getActivity().getResources().getString(R.string.your_subscription));
                            textView4.setVisibility(0);
                            RecyclerView recyclerView2 = (RecyclerView) linearLayout3.findViewById(R.id.education_checkbox_view);
                            recyclerView2.setHasFixedSize(true);
                            recyclerView2.setLayoutManager(new LinearLayoutManager(this.R));
                            this.bT = new net.one97.paytm.recharge.legacy.catalog.hathway.a.b(getActivity(), recyclerView2, dthPlanInfo, this);
                            recyclerView2.setAdapter(this.bT);
                            this.bQ = 0;
                            for (CJRService amount : dthPlanInfo.getServices()) {
                                this.bQ = Integer.valueOf(this.bQ.intValue() + amount.getAmount());
                            }
                            if (this.bQ.intValue() > 0) {
                                autoCompleteTextView.setText(String.valueOf(this.bQ));
                            }
                            this.C.addView(linearLayout3);
                        }
                        List<CJRUtilityCheckboxItem> a3 = a(cJRRechargeCart.getCart().getCartItems());
                        if (a3.size() > 0 && U() >= 0) {
                            this.o.setEnabled(false);
                            if (cJRRechargeCart.getCart().getCartItems().size() > 1) {
                                f(a3);
                                e(a3);
                            }
                        }
                        this.aE = actions.get(displayArrayIndex).getPaymentOptions();
                        if (this.Y != null && this.Y.size() > 0 && this.Y.get(0).isConvenienceFee() && this.o.getVisibility() == 0 && !this.ca) {
                            ac();
                        }
                        if (this.o != null) {
                            if (TextUtils.isEmpty(D().trim()) || Double.parseDouble(D()) == 0.0d) {
                                c(false);
                            } else {
                                c(true);
                            }
                        }
                    }
                } else if (cJRRechargeCart.getCart().getError() == null) {
                    az azVar2 = az.f61525a;
                    az.a((Context) getActivity(), ERROR_TYPE.UNDEFINED, (ACTION_TYPE) null, cJRRechargeCart2);
                    this.o.setVisibility(8);
                    this.o = null;
                }
            }
            s();
            H();
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    private void H() {
        if (this.G) {
            this.s.setVisibility(0);
            if (this.aK) {
                CheckBox checkBox = this.f62826i;
                if (checkBox != null) {
                    checkBox.setChecked(true);
                }
                g(true);
                this.aK = false;
                return;
            }
            CheckBox checkBox2 = this.f62826i;
            if (checkBox2 != null) {
                checkBox2.setChecked(false);
            }
            g(false);
        }
    }

    private void e(List<CJRUtilityCheckboxItem> list) {
        this.bO = true;
        double d2 = 0.0d;
        for (CJRUtilityCheckboxItem next : list) {
            if (next.isChecked() && !TextUtils.isEmpty(next.getPrice())) {
                try {
                    d2 += Double.parseDouble(next.getPrice());
                } catch (NumberFormatException e2) {
                    q.d(e2.getMessage());
                }
            }
        }
        if (d2 == 0.0d) {
            c(false);
        } else {
            c(true);
        }
        AutoCompleteTextView autoCompleteTextView = this.o;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setFocusable(false);
            this.o.setEnabled(false);
            double b2 = com.paytm.utility.b.b(d2);
            if (b2 > 0.0d) {
                this.o.setText(String.valueOf(b2));
            } else {
                this.o.setText("0");
            }
            this.o.setFocusable(true);
        }
    }

    private void f(boolean z2) {
        Map hashMap = new HashMap();
        if (this.o != null && D().length() > 0) {
            hashMap = b(D(), this.ai);
        }
        Map map = hashMap;
        this.aJ = S();
        net.one97.paytm.recharge.legacy.catalog.a aVar = this.aJ;
        boolean z3 = this.cb;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        aVar.a("wallet_token", (Map<String, Object>) map, z2, z3, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0163, code lost:
        if (net.one97.paytm.recharge.automatic.g.d.a(d(r19, r20).get(0)) != false) goto L_0x0165;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r19, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r20) {
        /*
            r18 = this;
            r9 = r18
            r10 = r19
            r11 = r20
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            if (r0 == 0) goto L_0x04aa
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            if (r0 == 0) goto L_0x04aa
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            android.view.LayoutInflater r0 = r0.getLayoutInflater()
            int r1 = net.one97.paytm.recharge.R.layout.recharge_utility_group_filed_drop_down
            r12 = 0
            android.view.View r0 = r0.inflate(r1, r12)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r9.bW = r0
            android.widget.LinearLayout r0 = r9.bW
            int r1 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.bU = r0
            android.widget.LinearLayout r0 = r9.bW
            int r1 = net.one97.paytm.recharge.R.id.text_input_layout_utility
            android.view.View r0 = r0.findViewById(r1)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r9.cp = r0
            android.widget.LinearLayout r0 = r9.bW
            int r1 = net.one97.paytm.recharge.R.id.change_operator
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.bV = r0
            java.util.Map r0 = r20.getSelectedGroupItemHashMap()
            if (r0 == 0) goto L_0x00b3
            if (r10 <= 0) goto L_0x00b3
            java.util.Map r0 = r20.getSelectedGroupItemHashMap()
            int r0 = r0.size()
            if (r0 < r10) goto L_0x00b3
            java.util.Map r0 = r20.getSelectedGroupItemHashMap()
            int r1 = r10 + -1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x00b3
            java.util.Map r0 = r20.getSelectedGroupItemHashMap()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2) r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x00b3
            java.util.Map r0 = r20.getSelectedGroupItemHashMap()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2) r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r0 = r0.getAttributes()
            java.lang.String r0 = r0.getLabel()
            if (r0 == 0) goto L_0x00b3
            com.google.android.material.textfield.TextInputLayout r0 = r9.cp
            java.util.Map r2 = r20.getSelectedGroupItemHashMap()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r2.get(r1)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2) r1
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r1 = r1.getAttributes()
            java.lang.String r1 = r1.getLabel()
            r0.setHint(r1)
            goto L_0x00cc
        L_0x00b3:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r0 = r0.getLabel()
            if (r0 == 0) goto L_0x00cc
            com.google.android.material.textfield.TextInputLayout r0 = r9.cp
            if (r0 == 0) goto L_0x00cc
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r11.getGroupFieldV2(r10)
            java.lang.String r1 = r1.getLabel()
            r0.setHint(r1)
        L_0x00cc:
            android.widget.TextView r0 = r9.bU
            android.view.View$OnClickListener r1 = r9.cF
            r0.setOnClickListener(r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r20.getGroupLevel()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            r0.add(r1)
            android.widget.TextView r1 = r9.bU
            r1.setTag(r0)
            android.widget.LinearLayout r1 = r9.bW
            r1.setTag(r0)
            android.widget.LinearLayout r0 = r9.u
            android.widget.LinearLayout r1 = r9.bW
            r0.addView(r1)
            int r0 = r20.getGroupLevel()
            r9.a((int) r10, (int) r0)
            android.widget.TextView r13 = r9.bU
            int r14 = r20.getGroupLevel()
            java.util.List r15 = d((int) r19, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r20)
            android.widget.TextView r0 = r9.z
            java.lang.String r1 = "city"
            java.lang.String r2 = "state"
            r8 = 0
            r7 = 1
            if (r0 == 0) goto L_0x0141
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r0 = r0.getKey()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x0132
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r0 = r0.getKey()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0141
        L_0x0132:
            java.lang.String r0 = r18.W()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0141
            r13.setText(r0)
            r0 = 0
            goto L_0x0142
        L_0x0141:
            r0 = 1
        L_0x0142:
            r9.z = r13
            int r3 = r15.size()
            if (r3 != r7) goto L_0x017b
            boolean r3 = r9.at
            if (r3 == 0) goto L_0x0165
            net.one97.paytm.recharge.automatic.g.d$a r3 = net.one97.paytm.recharge.automatic.g.d.f60295a
            net.one97.paytm.recharge.automatic.g.d r3 = new net.one97.paytm.recharge.automatic.g.d
            r3.<init>()
            java.util.List r3 = d((int) r19, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r20)
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
            boolean r3 = net.one97.paytm.recharge.automatic.g.d.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3)
            if (r3 == 0) goto L_0x017b
        L_0x0165:
            r2 = 0
            r3 = -1
            java.lang.Object r0 = r15.get(r8)
            r5 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            r6 = 1
            r0 = r18
            r1 = r19
            r4 = r13
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x017b:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            java.lang.String r4 = "accordion"
            r6 = -1
            if (r3 == 0) goto L_0x021d
            net.one97.paytm.recharge.metro.f.c$a r3 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            boolean r3 = net.one97.paytm.recharge.metro.f.c.a.a((java.util.HashMap<java.lang.String, java.lang.String>) r3)
            if (r3 == 0) goto L_0x021d
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            java.lang.String r5 = "is_for_order_history"
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r5 = "TRUE"
            boolean r3 = r5.equals(r3)
            r9.bt = r3
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r5 = r11.getGroupFieldV2(r10)
            java.lang.String r5 = r5.getKey()
            boolean r3 = r3.containsKey(r5)
            if (r3 == 0) goto L_0x0218
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r5 = r11.getGroupFieldV2(r10)
            java.lang.String r5 = r5.getKey()
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r15, (java.lang.String) r3)
            if (r3 < 0) goto L_0x0212
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r0 = r0.getType()
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x01fb
            java.util.Map r0 = r20.getGroupFieldMap()
            int r0 = r0.size()
            int r1 = r10 + 1
            if (r0 <= r1) goto L_0x01fb
            java.lang.Object r0 = r15.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            java.util.List r0 = r0.getVariants()
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r9.O
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r11.getGroupFieldV2(r1)
            java.lang.String r1 = r1.getKey()
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r0 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r0, (java.lang.String) r1)
            r6 = r0
        L_0x01fb:
            java.lang.Object r0 = r15.get(r3)
            r5 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            r7 = 1
            r0 = r18
            r1 = r19
            r2 = r3
            r3 = r6
            r4 = r13
            r6 = r7
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x0212:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            r3.clear()
            goto L_0x021d
        L_0x0218:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.O
            r3.clear()
        L_0x021d:
            java.lang.String r3 = r9.f62822e
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0271
            java.lang.String r3 = r9.f62822e
            int r3 = b((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r15, (java.lang.String) r3)
            r9.f62822e = r12
            if (r3 < 0) goto L_0x026f
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r0 = r0.getType()
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0258
            java.lang.String r0 = r9.f62823f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0258
            r9.f62823f = r12
            java.lang.Object r0 = r15.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            java.util.List r0 = r0.getVariants()
            java.lang.String r1 = r9.f62823f
            int r0 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r0, (java.lang.String) r1)
            r6 = r0
        L_0x0258:
            java.lang.Object r0 = r15.get(r3)
            r5 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            r7 = 1
            r0 = r18
            r1 = r19
            r2 = r3
            r3 = r6
            r4 = r13
            r6 = r7
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x026f:
            r9.f62823f = r12
        L_0x0271:
            java.lang.String r3 = r9.f62823f
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x02a8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r3 = r11.getGroupFieldV2(r10)
            java.lang.String r3 = r3.getType()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 != 0) goto L_0x02a8
            java.lang.String r3 = r9.f62823f
            int r3 = b((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r15, (java.lang.String) r3)
            if (r3 < 0) goto L_0x02a6
            r4 = -1
            java.lang.Object r0 = r15.get(r3)
            r5 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            r6 = 1
            r0 = r18
            r1 = r19
            r2 = r3
            r3 = r4
            r4 = r13
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x02a6:
            r9.f62823f = r12
        L_0x02a8:
            r18.aa()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r3 = r11.getGroupFieldV2(r10)
            java.lang.String r3 = r3.getKey()
            boolean r2 = r3.equalsIgnoreCase(r2)
            r5 = 200(0xc8, float:2.8E-43)
            if (r2 != 0) goto L_0x02ce
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r2 = r11.getGroupFieldV2(r10)
            java.lang.String r2 = r2.getKey()
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02ca
            goto L_0x02ce
        L_0x02ca:
            r1 = 200(0xc8, float:2.8E-43)
            goto L_0x036a
        L_0x02ce:
            java.lang.String r1 = r18.W()
            if (r1 == 0) goto L_0x032a
            java.lang.String r2 = ","
            boolean r3 = r1.contains(r2)
            if (r3 == 0) goto L_0x0304
            java.lang.String[] r1 = r1.split(r2)
            r2 = r1[r7]
            java.lang.String r2 = r2.trim()
            r1[r7] = r2
            r2 = r1[r7]
            int r2 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r15, (java.lang.String) r2)
            if (r2 < 0) goto L_0x0301
            java.lang.Object r3 = r15.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
            java.util.List r3 = r3.getVariants()
            r1 = r1[r8]
            int r1 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r3, (java.lang.String) r1)
            goto L_0x0302
        L_0x0301:
            r1 = -1
        L_0x0302:
            r3 = r1
            goto L_0x030a
        L_0x0304:
            int r1 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r15, (java.lang.String) r1)
            r2 = r1
            r3 = -1
        L_0x030a:
            if (r2 < 0) goto L_0x0326
            java.lang.Object r0 = r15.get(r2)
            r16 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r16 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r16
            r17 = 1
            r0 = r18
            r1 = r19
            r4 = r13
            r5 = r16
            r6 = r17
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
        L_0x0326:
            r1 = 200(0xc8, float:2.8E-43)
            r7 = 0
            goto L_0x036a
        L_0x032a:
            android.content.Context r1 = r18.getContext()
            java.lang.String r1 = com.paytm.utility.b.s((android.content.Context) r1)
            android.content.Context r2 = r18.getContext()
            java.lang.String r2 = com.paytm.utility.b.t((android.content.Context) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0367
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0367
            net.one97.paytm.recharge.common.utils.l r0 = new net.one97.paytm.recharge.common.utils.l
            android.content.Context r3 = r18.getContext()
            androidx.fragment.app.FragmentActivity r4 = r18.getActivity()
            r0.<init>(r3, r4, r12, r9)
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x035e }
            double r1 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x035e }
            r0.a((double) r3, (double) r1)     // Catch:{ Exception -> 0x035e }
        L_0x035e:
            r18.g()
            r1 = 200(0xc8, float:2.8E-43)
            r9.a((int) r1)
            return
        L_0x0367:
            r1 = 200(0xc8, float:2.8E-43)
            r7 = 1
        L_0x036a:
            if (r0 == 0) goto L_0x036f
            r9.a((int) r1)
        L_0x036f:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r0 = r11.getGroupFieldV2(r10)
            java.lang.String r2 = com.paytm.utility.e.z
            net.one97.paytm.common.entity.CJRItem r3 = r9.U
            java.lang.String r3 = r3.getCategoryId()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0470
            net.one97.paytm.recharge.metro.f.c$a r2 = net.one97.paytm.recharge.metro.f.c.f63576a
            boolean r2 = net.one97.paytm.recharge.metro.f.c.a.a()
            r3 = 183(0xb7, float:2.56E-43)
            if (r2 != 0) goto L_0x041c
            boolean r2 = r9.bf
            if (r2 != 0) goto L_0x041c
            boolean r2 = r9.ak
            if (r2 == 0) goto L_0x041c
            r2 = 1
            if (r14 != r2) goto L_0x041d
            if (r10 != 0) goto L_0x041d
            r4 = 0
            r9.ak = r4
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r5 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderList r5 = r5.getFrequentOrderList()
            net.one97.paytm.recharge.common.utils.q r6 = net.one97.paytm.recharge.common.utils.q.f61722a
            java.lang.String r6 = r20.getName()
            java.util.List r6 = net.one97.paytm.recharge.common.utils.q.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrderList) r5, (java.lang.String) r6, (java.lang.String) r12)
            if (r5 == 0) goto L_0x03c6
            java.util.List r5 = r5.getOrderList()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x03c6
            if (r6 == 0) goto L_0x03c6
            int r5 = r6.size()
            if (r5 <= 0) goto L_0x03c6
            java.lang.Object r4 = r6.get(r4)
            r12 = r4
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r12
        L_0x03c6:
            if (r12 == 0) goto L_0x041d
            java.util.List r4 = r20.getVariantList()
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r5 = r12.getFrequentOrderProduct()
            java.lang.String r5 = r5.getFrequentOrderBrand()
            int r4 = a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r4, (java.lang.String) r5)
            r5 = -1
            if (r4 == r5) goto L_0x041d
            java.lang.Object r0 = r15.get(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r5 = r0.getProduct()
            if (r5 == 0) goto L_0x0406
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r5 = r0.getProduct()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x0406
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = r0.getProduct()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()
            boolean r0 = r0.isMetroTicketFlow()
            if (r0 == 0) goto L_0x0406
            r9.a((int) r1)
            r9.a((boolean) r2, (int) r3, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r11, (int) r14)
            return
        L_0x0406:
            r3 = -1
            java.lang.Object r0 = r15.get(r4)
            r5 = r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            r6 = 0
            r0 = r18
            r1 = r19
            r2 = r4
            r4 = r13
            r7 = r20
            r8 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x041c:
            r2 = 1
        L_0x041d:
            boolean r1 = r9.aA
            if (r1 != 0) goto L_0x044f
            if (r7 == 0) goto L_0x044f
            boolean r1 = r9.aj
            if (r1 == 0) goto L_0x042f
            if (r0 == 0) goto L_0x044f
            boolean r0 = r0.isPerformViewClick()
            if (r0 == 0) goto L_0x044f
        L_0x042f:
            java.util.List r0 = r20.getRc()
            if (r0 == 0) goto L_0x043f
            java.util.List r0 = r20.getRc()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x044f
        L_0x043f:
            if (r10 > 0) goto L_0x0445
            boolean r0 = r9.bf
            if (r0 != 0) goto L_0x044f
        L_0x0445:
            int r0 = r20.getGroupLevel()
            if (r0 != r2) goto L_0x044f
            r13.performClick()
            return
        L_0x044f:
            boolean r0 = r9.bf
            if (r0 == 0) goto L_0x0457
            r9.a((boolean) r2, (int) r3, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r11, (int) r14)
            return
        L_0x0457:
            boolean r0 = r9.aA
            if (r0 != 0) goto L_0x046c
            boolean r0 = r9.aj
            if (r0 != 0) goto L_0x0460
            goto L_0x046c
        L_0x0460:
            net.one97.paytm.recharge.metro.f.c$a r0 = net.one97.paytm.recharge.metro.f.c.f63576a
            boolean r0 = net.one97.paytm.recharge.metro.f.c.a.a()
            if (r0 == 0) goto L_0x04aa
            r13.performClick()
            return
        L_0x046c:
            r13.performClick()
            return
        L_0x0470:
            r2 = 1
            boolean r1 = r9.aA
            if (r1 != 0) goto L_0x04aa
            if (r7 == 0) goto L_0x04aa
            boolean r1 = r9.aj
            if (r1 == 0) goto L_0x048d
            if (r0 == 0) goto L_0x04aa
            boolean r0 = r0.isPerformViewClick()
            if (r0 == 0) goto L_0x04aa
            boolean r0 = r20.isRecentsPrefill()
            if (r0 == 0) goto L_0x048d
            boolean r0 = r9.aj
            if (r0 != 0) goto L_0x04aa
        L_0x048d:
            java.util.List r0 = r20.getRc()
            if (r0 == 0) goto L_0x049d
            java.util.List r0 = r20.getRc()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x04aa
        L_0x049d:
            int r0 = r20.getGroupLevel()
            if (r0 != r2) goto L_0x04aa
            boolean r0 = r9.f62825h
            if (r0 != 0) goto L_0x04aa
            r13.performClick()
        L_0x04aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.b(int, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r8, boolean r9, android.view.View r10, com.paytm.utility.RoboTextView r11, java.lang.String r12) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getRegex()
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r2 = r8.getTitle()
            if (r11 == 0) goto L_0x00f7
            if (r10 == 0) goto L_0x00f7
            if (r9 != 0) goto L_0x00d6
            java.lang.String r9 = r12.trim()
            int r9 = r9.length()
            java.lang.String r3 = ""
            r4 = 1
            r5 = 0
            if (r9 != 0) goto L_0x0035
            boolean r9 = r8.isOptional()
            if (r9 != 0) goto L_0x0035
            int r9 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r5] = r2
            java.lang.String r9 = r1.getString(r9, r6)
            goto L_0x0043
        L_0x0035:
            boolean r9 = r7.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r8, (java.lang.String) r12)
            if (r9 != 0) goto L_0x0042
            int r9 = net.one97.paytm.recharge.R.string.recharge_error_values_do_not_match
            java.lang.String r9 = r1.getString(r9)
            goto L_0x0043
        L_0x0042:
            r9 = r3
        L_0x0043:
            java.lang.String r8 = r8.getConfigKey()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "recharge_number"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x00a3 }
            if (r8 == 0) goto L_0x0090
            java.lang.String r8 = " "
            java.lang.String r8 = r12.replaceAll(r8, r3)     // Catch:{ Exception -> 0x00a3 }
            boolean r8 = com.paytm.utility.b.J((java.lang.String) r8)     // Catch:{ Exception -> 0x00a3 }
            if (r8 != 0) goto L_0x0090
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r8 = r7.Z     // Catch:{ Exception -> 0x00a3 }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r8 = r8.getLastUtilityProductList()     // Catch:{ Exception -> 0x00a3 }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r8 = r8.getGroupFieldV2(r5)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = r8.getCartVerifyType()     // Catch:{ Exception -> 0x00a3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00a3 }
            if (r8 != 0) goto L_0x0090
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r8 = r7.Z     // Catch:{ Exception -> 0x00a3 }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r8 = r8.getLastUtilityProductList()     // Catch:{ Exception -> 0x00a3 }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r8 = r8.getGroupFieldV2(r5)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = r8.getCartVerifyType()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "CC_BILL_PAYMENT"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x00a3 }
            if (r8 == 0) goto L_0x0090
            int r8 = net.one97.paytm.recharge.R.string.please_enter_valid     // Catch:{ Exception -> 0x00a3 }
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a3 }
            r12[r5] = r2     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = r7.getString(r8, r12)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a4
        L_0x0090:
            if (r0 == 0) goto L_0x00a4
            boolean r8 = r12.matches(r0)     // Catch:{ Exception -> 0x00a3 }
            if (r8 != 0) goto L_0x00a4
            int r8 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg     // Catch:{ Exception -> 0x00a3 }
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a3 }
            r12[r5] = r2     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = r7.getString(r8, r12)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a4
        L_0x00a3:
        L_0x00a4:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x00c5
            android.content.Context r8 = r7.getContext()
            int r12 = net.one97.paytm.recharge.R.color.error_color
            int r8 = androidx.core.content.b.c(r8, r12)
            r10.setBackgroundColor(r8)
            android.content.Context r8 = r7.getContext()
            int r10 = net.one97.paytm.recharge.R.color.error_color
            int r8 = androidx.core.content.b.c(r8, r10)
            r11.setTextColor(r8)
            goto L_0x00d2
        L_0x00c5:
            android.content.Context r8 = r7.getContext()
            int r12 = net.one97.paytm.recharge.R.color.bg_grid_grey
            int r8 = androidx.core.content.b.c(r8, r12)
            r10.setBackgroundColor(r8)
        L_0x00d2:
            r7.a((com.paytm.utility.RoboTextView) r11, (java.lang.String) r9)
            return
        L_0x00d6:
            android.content.Context r9 = r7.getContext()
            int r12 = net.one97.paytm.recharge.R.color.paytm_blue
            int r9 = androidx.core.content.b.c(r9, r12)
            r10.setBackgroundColor(r9)
            android.content.Context r9 = r7.getContext()
            int r10 = net.one97.paytm.recharge.R.color.gray
            int r9 = androidx.core.content.b.c(r9, r10)
            r11.setTextColor(r9)
            java.lang.String r8 = r8.getMessage()
            r7.a((com.paytm.utility.RoboTextView) r11, (java.lang.String) r8)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2, boolean, android.view.View, com.paytm.utility.RoboTextView, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, String str) {
        if (isAdded() && !ba.a((View) this.aX) && !ba.a((View) this.aZ)) {
            super.a(context, str);
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        if (this.B) {
            E();
            this.an = null;
            this.bR = null;
            int i2 = 0;
            this.ca = false;
            this.cb = false;
            this.bO = true;
            this.bK = null;
            this.s.setVisibility(8);
            g(false);
            CheckBox checkBox = this.f62826i;
            if (checkBox != null) {
                checkBox.setChecked(false);
            }
            if (this.A != null) {
                while (i2 < this.A.getChildCount()) {
                    if (this.A.getChildAt(i2).getTag() == null || ((Boolean) this.A.getChildAt(i2).getTag()).booleanValue()) {
                        this.A.getChildAt(i2).setVisibility(8);
                        this.A.removeViewAt(i2);
                        i2--;
                    }
                    i2++;
                }
            }
            this.o = null;
            this.C = null;
            this.cv = null;
            this.bF.clear();
            c(true);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        LinearLayout linearLayout;
        AutoCompleteTextView a2;
        TextInputLayout b2;
        LinearLayout linearLayout2;
        AutoCompleteTextView a3;
        TextInputLayout b3;
        String str;
        if (getActivity() == null) {
            return false;
        }
        Resources resources = getActivity().getResources();
        this.aa = new JSONObject();
        if (this.bP && androidx.core.app.a.a(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
            a("imei", com.paytm.utility.b.A(getContext()));
        }
        if (this.I != null) {
            for (int i2 = 0; i2 < this.I.getChildCount(); i2++) {
                if (!(!(this.I.getChildAt(i2) instanceof LinearLayout) || (a3 = a((linearLayout2 = (LinearLayout) this.I.getChildAt(i2)))) == null || (b3 = b(linearLayout2)) == null || b3.getHint() == null)) {
                    if (TextUtils.isEmpty(a3.getText())) {
                        if (b3.getHint().toString().equals("Institute")) {
                            str = "Select Institute";
                        } else {
                            str = b3.getHint().toString();
                        }
                        String string = getString(R.string.utility_empty_group_field_msg, str);
                        az azVar = az.f61525a;
                        az.a(getActivity(), ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, TextUtils.isEmpty(string) ? "utility_hide_title" : getString(R.string.error_heading), string, false, l(), this.P, this.af, false);
                        i(string);
                        return false;
                    }
                    try {
                        a(b3.getHint().toString().trim(), a3.getText().toString());
                    } catch (Exception e2) {
                        q.d(e2.getMessage());
                    }
                }
            }
        }
        if (this.u != null) {
            for (int i3 = 0; i3 < this.u.getChildCount(); i3++) {
                if (!(!(this.u.getChildAt(i3) instanceof LinearLayout) || (linearLayout = (LinearLayout) this.u.getChildAt(i3)) == null || (a2 = a(linearLayout)) == null || (b2 = b(linearLayout)) == null || b2.getHint() == null)) {
                    if (TextUtils.isEmpty(a2.getText())) {
                        String string2 = resources.getString(R.string.empty_group_error, new Object[]{b2.getHint().toString()});
                        List list = (List) a2.getTag();
                        CJRUtilityGroupFieldV2 groupFieldV2 = c(((Integer) list.get(0)).intValue()).getGroupFieldV2(((Integer) list.get(1)).intValue());
                        if (groupFieldV2 != null && !TextUtils.isEmpty(groupFieldV2.getError())) {
                            string2 = groupFieldV2.getError();
                        }
                        az azVar2 = az.f61525a;
                        az.a(getActivity(), ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, "utility_hide_title", string2, false, l(), this.P, this.af, false);
                        i(string2);
                        return false;
                    } else if (b2 != null) {
                        try {
                            a(b2.getHint().toString().trim(), a2.getText().toString());
                        } catch (Exception e3) {
                            q.d(e3.getMessage());
                        }
                    }
                }
            }
        }
        this.D.clear();
        this.E.clear();
        this.D.add("category_id");
        this.E.add(this.U.getCategoryId());
        ArrayList<CJRGroupField> arrayList = this.bI;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i4 = 0; i4 < this.bI.size(); i4++) {
                if (!J()) {
                    return false;
                }
            }
        }
        List<CJRUtilityProductV2> list2 = this.Y;
        if (!(list2 == null || list2.size() <= 0 || this.Y.get(0) == null)) {
            List<CJRUtilityInputFieldsV2> inputFields = this.Y.get(0).getInputFields();
            int i5 = 0;
            while (i5 < inputFields.size()) {
                if (!a(inputFields.get(i5), this.A, i5) && !inputFields.get(i5).isHideInputField()) {
                    return false;
                }
                if (inputFields.get(i5).isHideInputField() || z.a((Context) getActivity())) {
                    i5++;
                } else {
                    this.f62821d = true;
                    z.a((Activity) getActivity());
                    return false;
                }
            }
        }
        ae();
        if (this.aa == null) {
            this.aa = new JSONObject();
        }
        CJRPaymentOptions cJRPaymentOptions = this.cv;
        if (cJRPaymentOptions != null) {
            try {
                this.aa.put("invoiceNumber", cJRPaymentOptions.getInvoiceNumber());
                this.aa.put("stbNumber", this.cv.getStbNumber());
                this.aa.put("amount", this.cv.getAmount());
            } catch (JSONException e4) {
                q.d(e4.getMessage());
            }
        }
        try {
            if (this.C != null && this.C.getVisibility() == 0 && this.bH != null && this.bH.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i6 = 0; i6 < this.bH.size(); i6++) {
                    if (!TextUtils.isEmpty(this.bH.get(i6).getLabel()) && !TextUtils.isEmpty(this.bH.get(i6).getValue())) {
                        jSONObject.put(this.bH.get(i6).getLabel(), this.bH.get(i6).getValue());
                    }
                }
                if (jSONObject.length() > 0) {
                    this.aa.put("displayValues", jSONObject);
                }
            }
        } catch (Exception e5) {
            q.d(e5.getMessage());
        }
        List<CJRUtilityCheckboxItem> list3 = this.bF;
        if (list3 != null) {
            for (CJRUtilityCheckboxItem next : list3) {
                if (next != null && TextUtils.isEmpty(next.getPrice())) {
                    String string3 = resources.getString(R.string.electricity_empty_value_msg, new Object[]{next.getName()});
                    az azVar3 = az.f61525a;
                    az.a(getActivity(), ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, "utility_hide_title", string3, false, l(), this.P, this.af, false);
                    i(string3);
                    return false;
                }
            }
        }
        return true;
    }

    private void a(String str, String str2) {
        try {
            this.aa.put(str, str2);
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:176:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0573 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0574  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r25, android.widget.LinearLayout r26, int r27) {
        /*
            r24 = this;
            r8 = r24
            r9 = r25
            r0 = r26
            androidx.fragment.app.FragmentActivity r1 = r24.getActivity()
            android.content.res.Resources r10 = r1.getResources()
            r11 = 1
            if (r9 == 0) goto L_0x062f
            java.lang.String r1 = r25.getType()
            java.lang.String r2 = "description"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x062f
            java.lang.String r1 = r25.getType()
            java.lang.String r2 = "amount"
            boolean r1 = r1.equals(r2)
            java.lang.String r12 = ""
            r13 = 0
            if (r1 == 0) goto L_0x0214
            android.widget.AutoCompleteTextView r0 = r8.o
            if (r0 == 0) goto L_0x062f
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x062f
            java.lang.String r0 = r24.v()
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0077
            int r0 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = r25.getTitle()
            r1[r13] = r2
            java.lang.String r0 = r10.getString(r0, r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r14 = r24.getActivity()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            r16 = 0
            r19 = 0
            java.lang.String r20 = r24.l()
            java.lang.String r1 = r8.P
            java.lang.String r2 = r8.af
            r23 = 0
            java.lang.String r17 = "utility_hide_title"
            r18 = r0
            r21 = r1
            r22 = r2
            net.one97.paytm.recharge.common.utils.az.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r8.i((java.lang.String) r0)
            return r13
        L_0x0077:
            r1 = 0
            if (r9 == 0) goto L_0x062f
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r0 = r8.cm     // Catch:{ Exception -> 0x00a0 }
            if (r0 != 0) goto L_0x008b
            java.lang.String r0 = r25.getMax()     // Catch:{ Exception -> 0x00a0 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x00a0 }
        L_0x0089:
            r1 = r0
            goto L_0x00a8
        L_0x008b:
            java.lang.String r0 = r8.cm     // Catch:{ Exception -> 0x00a0 }
            double r1 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x00a0 }
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x009e
            java.lang.String r0 = r25.getMax()     // Catch:{ Exception -> 0x00a0 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x0089
        L_0x009e:
            r0 = r1
            goto L_0x0089
        L_0x00a0:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x00a8:
            java.lang.String r0 = r8.cn
            if (r0 == 0) goto L_0x00b1
            double r3 = java.lang.Double.parseDouble(r0)
            goto L_0x00bf
        L_0x00b1:
            java.lang.String r0 = r25.getMin()
            if (r0 == 0) goto L_0x00bf
            java.lang.String r0 = r25.getMin()
            double r3 = java.lang.Double.parseDouble(r0)
        L_0x00bf:
            boolean r0 = r8.co
            if (r0 == 0) goto L_0x0199
            r5 = 2
            java.lang.String r0 = r24.v()     // Catch:{ Exception -> 0x0150 }
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0150 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0111
            int r0 = net.one97.paytm.recharge.R.string.electricity_bill_amount_more_than     // Catch:{ Exception -> 0x0150 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0150 }
            r6[r13] = r7     // Catch:{ Exception -> 0x0150 }
            java.lang.String r0 = r10.getString(r0, r6)     // Catch:{ Exception -> 0x0150 }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x00fe
            int r0 = net.one97.paytm.recharge.R.string.electricity_bill_amount_not_in_range     // Catch:{ Exception -> 0x0150 }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r11)     // Catch:{ Exception -> 0x0150 }
            r6[r13] = r7     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r11)     // Catch:{ Exception -> 0x0150 }
            r6[r11] = r7     // Catch:{ Exception -> 0x0150 }
            java.lang.String r0 = r10.getString(r0, r6)     // Catch:{ Exception -> 0x0150 }
        L_0x00fe:
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x0150 }
            androidx.fragment.app.FragmentActivity r6 = r24.getActivity()     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r9 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED     // Catch:{ Exception -> 0x0150 }
            java.lang.String r12 = r8.f62819b     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.common.utils.az.a(r6, r7, r9, r12, r0)     // Catch:{ Exception -> 0x0150 }
            r8.i((java.lang.String) r0)     // Catch:{ Exception -> 0x0150 }
            return r13
        L_0x0111:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0199
            java.lang.String r0 = r24.v()     // Catch:{ Exception -> 0x0150 }
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0150 }
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0199
            int r0 = net.one97.paytm.recharge.R.string.electricity_bill_amount_not_in_range     // Catch:{ Exception -> 0x0150 }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r11)     // Catch:{ Exception -> 0x0150 }
            r6[r13] = r7     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r11)     // Catch:{ Exception -> 0x0150 }
            r6[r11] = r7     // Catch:{ Exception -> 0x0150 }
            java.lang.String r0 = r10.getString(r0, r6)     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x0150 }
            androidx.fragment.app.FragmentActivity r6 = r24.getActivity()     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r9 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED     // Catch:{ Exception -> 0x0150 }
            java.lang.String r12 = r8.f62819b     // Catch:{ Exception -> 0x0150 }
            net.one97.paytm.recharge.common.utils.az.a(r6, r7, r9, r12, r0)     // Catch:{ Exception -> 0x0150 }
            r8.i((java.lang.String) r0)     // Catch:{ Exception -> 0x0150 }
            return r13
        L_0x0150:
            r0 = move-exception
            int r6 = net.one97.paytm.recharge.R.string.electricity_bill_amount_more_than
            java.lang.Object[] r7 = new java.lang.Object[r11]
            java.lang.String r9 = java.lang.String.valueOf(r3)
            r7[r13] = r9
            java.lang.String r6 = r10.getString(r6, r7)
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x017f
            int r6 = net.one97.paytm.recharge.R.string.electricity_bill_amount_not_in_range
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r3, (boolean) r11)
            r5[r13] = r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r1, (boolean) r11)
            r5[r11] = r1
            java.lang.String r6 = r10.getString(r6, r5)
        L_0x017f:
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r1 = r24.getActivity()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            java.lang.String r4 = r8.f62819b
            net.one97.paytm.recharge.common.utils.az.a(r1, r2, r3, r4, r6)
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            r8.i((java.lang.String) r6)
            return r13
        L_0x0199:
            java.lang.String r0 = r25.getRegex()
            if (r0 == 0) goto L_0x01e6
            java.lang.String r0 = r25.getRegex()
            boolean r0 = r0.equalsIgnoreCase(r12)
            if (r0 != 0) goto L_0x01e6
            android.widget.AutoCompleteTextView r0 = r8.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = m((java.lang.String) r0)
            java.lang.String r1 = r25.getRegex()
            boolean r0 = r0.matches(r1)
            if (r0 != 0) goto L_0x01e6
            int r0 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = r25.getTitle()
            r1[r13] = r2
            java.lang.String r0 = r8.getString(r0, r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r1 = r24.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            int r4 = net.one97.paytm.recharge.R.string.error
            java.lang.String r4 = r8.getString(r4)
            net.one97.paytm.recharge.common.utils.az.a(r1, r2, r3, r4, r0)
            r8.i((java.lang.String) r0)
            return r13
        L_0x01e6:
            java.util.ArrayList<java.lang.String> r0 = r8.D
            java.lang.String r1 = r25.getConfigKey()
            r0.add(r1)
            java.util.ArrayList<java.lang.String> r0 = r8.E
            java.lang.String r1 = r24.v()
            r0.add(r1)
            java.lang.String r0 = r25.getTitle()     // Catch:{ Exception -> 0x0208 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0208 }
            java.lang.String r1 = r24.v()     // Catch:{ Exception -> 0x0208 }
            r8.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0208 }
            goto L_0x0210
        L_0x0208:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x0210:
            r8.K = r11
            goto L_0x062f
        L_0x0214:
            java.lang.String r1 = r25.getType()
            java.lang.String r2 = "date"
            boolean r1 = r1.equals(r2)
            java.lang.String r2 = "InputField_"
            if (r1 == 0) goto L_0x030d
            java.lang.String r1 = java.lang.String.valueOf(r27)
            java.lang.String r1 = r2.concat(r1)
            android.view.View r0 = r0.findViewWithTag(r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 != 0) goto L_0x0263
            int r0 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = "Journey number"
            r1[r13] = r2
            java.lang.String r0 = r8.getString(r0, r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r14 = r24.getActivity()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            r16 = 0
            r19 = 0
            java.lang.String r20 = r24.l()
            java.lang.String r1 = r8.P
            java.lang.String r2 = r8.af
            r23 = 0
            java.lang.String r17 = "utility_hide_title"
            r18 = r0
            r21 = r1
            r22 = r2
            net.one97.paytm.recharge.common.utils.az.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r8.i((java.lang.String) r0)
            return r13
        L_0x0263:
            android.view.View r0 = r0.getChildAt(r13)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r1 = r0.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x02ae
            int r0 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = r25.getTitle()
            r1[r13] = r2
            java.lang.String r0 = r10.getString(r0, r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r14 = r24.getActivity()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            r16 = 0
            r19 = 0
            java.lang.String r20 = r24.l()
            java.lang.String r1 = r8.P
            java.lang.String r2 = r8.af
            r23 = 0
            java.lang.String r17 = "utility_hide_title"
            r18 = r0
            r21 = r1
            r22 = r2
            net.one97.paytm.recharge.common.utils.az.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r8.i((java.lang.String) r0)
            return r13
        L_0x02ae:
            java.lang.String r1 = r25.getRegex()
            if (r1 == 0) goto L_0x02d8
            java.lang.CharSequence r1 = r0.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r25.getRegex()
            boolean r1 = r1.matches(r2)
            if (r1 != 0) goto L_0x02d8
            int r0 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = r25.getTitle()
            r1[r13] = r2
            java.lang.String r0 = r8.getString(r0, r1)
            r8.i((java.lang.String) r0)
            return r13
        L_0x02d8:
            java.util.ArrayList<java.lang.String> r1 = r8.D
            java.lang.String r2 = r25.getConfigKey()
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r8.E
            java.lang.CharSequence r2 = r0.getText()
            java.lang.String r2 = r2.toString()
            r1.add(r2)
            java.lang.String r1 = r25.getTitle()     // Catch:{ Exception -> 0x0303 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0303 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x0303 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0303 }
            r8.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0303 }
            goto L_0x062f
        L_0x0303:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            goto L_0x062f
        L_0x030d:
            java.lang.String r1 = r25.getConfigKey()
            java.lang.String r3 = "recharge_number"
            boolean r1 = r3.equals(r1)
            java.lang.String r4 = "recharge_number_2"
            if (r1 != 0) goto L_0x0325
            java.lang.String r1 = r25.getConfigKey()
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x04e0
        L_0x0325:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            if (r1 == 0) goto L_0x04e0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            if (r1 == 0) goto L_0x04e0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04e0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            java.lang.String r5 = "CC_BILL_PAYMENT"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x04e0
            java.lang.String r1 = java.lang.String.valueOf(r27)
            java.lang.String r1 = r2.concat(r1)
            android.view.View r0 = r0.findViewWithTag(r1)
            android.widget.AutoCompleteTextView r0 = (android.widget.AutoCompleteTextView) r0
            if (r0 != 0) goto L_0x0374
            return r11
        L_0x0374:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r25.getConfigKey()
            boolean r1 = r1.equals(r3)
            java.lang.String r2 = " "
            if (r1 == 0) goto L_0x03bf
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03bf
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x03bf
            java.lang.String r1 = r0.replace(r2, r12)
            r8.aS = r1
            java.lang.String r1 = r8.aS
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03bf
            return r13
        L_0x03bf:
            java.lang.String r1 = r25.getConfigKey()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0400
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0400
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0400
            java.lang.String r1 = r0.replace(r2, r12)
            r8.aT = r1
            java.lang.String r1 = r8.aT
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0400
            return r13
        L_0x0400:
            java.lang.String r1 = r8.aS
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x046c
            java.lang.String r1 = r8.aT
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x046c
            java.lang.String r1 = r8.aS
            java.lang.String r2 = r8.aT
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x046c
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x046c
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x046c
            int r0 = net.one97.paytm.recharge.R.string.card_numbr_not_match
            java.lang.String r18 = r8.getString(r0)
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r14 = r24.getActivity()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            r16 = 0
            r19 = 0
            java.lang.String r20 = r24.l()
            java.lang.String r0 = r8.P
            java.lang.String r1 = r8.af
            r23 = 0
            java.lang.String r17 = "utility_hide_title"
            r21 = r0
            r22 = r1
            net.one97.paytm.recharge.common.utils.az.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r8.aS = r12
            r8.aT = r12
            return r13
        L_0x046c:
            java.lang.String r1 = r8.aS
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04bb
            java.lang.String r1 = r8.aT
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04bb
            java.lang.String r1 = r8.aS
            boolean r1 = com.paytm.utility.b.J((java.lang.String) r1)
            if (r1 != 0) goto L_0x04bb
            java.lang.String r1 = r8.aS
            java.lang.String r2 = r8.aT
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x04bb
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04bb
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r8.Z
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r13)
            java.lang.String r1 = r1.getCartVerifyType()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x04bb
            r8.aS = r12
            r8.aT = r12
            return r13
        L_0x04bb:
            java.util.ArrayList<java.lang.String> r1 = r8.D
            java.lang.String r2 = r25.getConfigKey()
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r8.E
            r1.add(r0)
            java.lang.String r1 = r25.getTitle()     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x04d6 }
            r8.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x04d6 }
            goto L_0x062f
        L_0x04d6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            goto L_0x062f
        L_0x04e0:
            java.lang.String r1 = java.lang.String.valueOf(r27)
            java.lang.String r1 = r2.concat(r1)
            android.view.View r14 = r0.findViewWithTag(r1)
            net.one97.paytm.common.entity.CJRItem r1 = r8.U
            java.lang.String r15 = r1.getCategoryId()
            boolean r1 = r14 instanceof android.widget.AutoCompleteTextView
            if (r1 == 0) goto L_0x0504
            r1 = r14
            android.widget.AutoCompleteTextView r1 = (android.widget.AutoCompleteTextView) r1
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
        L_0x0501:
            r16 = r1
            goto L_0x0516
        L_0x0504:
            boolean r1 = r14 instanceof net.one97.paytm.common.widgets.CustomEditText
            if (r1 == 0) goto L_0x0514
            r1 = r14
            net.one97.paytm.common.widgets.CustomEditText r1 = (net.one97.paytm.common.widgets.CustomEditText) r1
            java.lang.String r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            goto L_0x0501
        L_0x0514:
            r16 = r12
        L_0x0516:
            java.lang.String r1 = com.paytm.utility.e.z
            boolean r1 = r1.equalsIgnoreCase(r15)
            if (r1 == 0) goto L_0x053b
            android.view.View$OnClickListener r1 = r8.bu
            if (r1 != 0) goto L_0x053b
            net.one97.paytm.recharge.legacy.catalog.fragment.-$$Lambda$FJRRechargeUtilityBaseV2$QDj0W_Nc4NdHji_s6pJDlaPxxaw r7 = new net.one97.paytm.recharge.legacy.catalog.fragment.-$$Lambda$FJRRechargeUtilityBaseV2$QDj0W_Nc4NdHji_s6pJDlaPxxaw
            r1 = r7
            r2 = r24
            r3 = r15
            r4 = r26
            r5 = r27
            r6 = r25
            r13 = r7
            r7 = r16
            r1.<init>(r3, r4, r5, r6, r7)
            r8.bu = r13
            android.view.View$OnClickListener r1 = r8.bu
            r14.setOnClickListener(r1)
        L_0x053b:
            if (r15 == 0) goto L_0x0565
            java.lang.String r1 = "99932"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x054d
            java.lang.String r1 = "93643"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x0565
        L_0x054d:
            boolean r1 = r25.isHideInputField()
            if (r1 == 0) goto L_0x0565
            android.content.Context r1 = r8.R
            android.content.Context r1 = r1.getApplicationContext()
            com.paytm.b.a.a r1 = net.one97.paytm.recharge.common.utils.ax.a(r1)
            java.lang.String r2 = com.paytm.utility.e.aQ
            java.lang.String r1 = r1.b((java.lang.String) r2, (java.lang.String) r12, (boolean) r11)
            r6 = r1
            goto L_0x0567
        L_0x0565:
            r6 = r16
        L_0x0567:
            boolean r1 = r25.isOptional()
            if (r1 == 0) goto L_0x0574
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x0574
            return r11
        L_0x0574:
            java.lang.String r1 = "InputField_Separator_"
            java.lang.String r2 = "InputField_Message_"
            if (r6 == 0) goto L_0x05c1
            java.lang.String r3 = r6.trim()
            int r3 = r3.length()
            if (r3 != 0) goto L_0x05c1
            boolean r3 = r25.isOptional()
            if (r3 != 0) goto L_0x05c1
            int r3 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.String r5 = r25.getTitle()
            r7 = 0
            r4[r7] = r5
            java.lang.String r3 = r10.getString(r3, r4)
            r8.i((java.lang.String) r3)
            java.lang.String r3 = java.lang.String.valueOf(r27)
            java.lang.String r2 = r2.concat(r3)
            android.view.View r2 = r0.findViewWithTag(r2)
            r5 = r2
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            java.lang.String r2 = java.lang.String.valueOf(r27)
            java.lang.String r1 = r1.concat(r2)
            android.view.View r4 = r0.findViewWithTag(r1)
            r3 = 0
            r1 = r24
            r2 = r25
            r1.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r2, (boolean) r3, (android.view.View) r4, (com.paytm.utility.RoboTextView) r5, (java.lang.String) r6)
        L_0x05bf:
            r1 = 0
            return r1
        L_0x05c1:
            java.lang.String r3 = r25.getRegex()
            if (r3 == 0) goto L_0x05d1
            java.lang.String r3 = r25.getRegex()
            boolean r3 = r6.matches(r3)
            if (r3 == 0) goto L_0x05d7
        L_0x05d1:
            boolean r3 = r8.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r9, (java.lang.String) r6)
            if (r3 != 0) goto L_0x060d
        L_0x05d7:
            int r3 = net.one97.paytm.recharge.R.string.electricity_empty_value_msg
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.String r5 = r25.getTitle()
            r7 = 0
            r4[r7] = r5
            java.lang.String r3 = r8.getString(r3, r4)
            r8.i((java.lang.String) r3)
            java.lang.String r3 = java.lang.String.valueOf(r27)
            java.lang.String r2 = r2.concat(r3)
            android.view.View r2 = r0.findViewWithTag(r2)
            r5 = r2
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            java.lang.String r2 = java.lang.String.valueOf(r27)
            java.lang.String r1 = r1.concat(r2)
            android.view.View r4 = r0.findViewWithTag(r1)
            r3 = 0
            r1 = r24
            r2 = r25
            r1.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r2, (boolean) r3, (android.view.View) r4, (com.paytm.utility.RoboTextView) r5, (java.lang.String) r6)
            goto L_0x05bf
        L_0x060d:
            java.util.ArrayList<java.lang.String> r0 = r8.D
            java.lang.String r1 = r25.getConfigKey()
            r0.add(r1)
            java.util.ArrayList<java.lang.String> r0 = r8.E
            r0.add(r6)
            java.lang.String r0 = r25.getTitle()     // Catch:{ Exception -> 0x0627 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0627 }
            r8.a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0627 }
            goto L_0x062f
        L_0x0627:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x062f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2, android.widget.LinearLayout, int):boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, LinearLayout linearLayout, int i2, CJRUtilityInputFieldsV2 cJRUtilityInputFieldsV2, String str2, View view) {
        if (com.paytm.utility.e.z.equalsIgnoreCase(str)) {
            CJRUtilityInputFieldsV2 cJRUtilityInputFieldsV22 = cJRUtilityInputFieldsV2;
            a(cJRUtilityInputFieldsV22, true, linearLayout.findViewWithTag("InputField_Separator_".concat(String.valueOf(i2))), (RoboTextView) linearLayout.findViewWithTag("InputField_Message_".concat(String.valueOf(i2))), str2);
        }
    }

    private boolean a(CJRUtilityInputFieldsV2 cJRUtilityInputFieldsV2, String str) {
        if (!TextUtils.isEmpty(cJRUtilityInputFieldsV2.getMatchWithKey()) && this.D.contains(cJRUtilityInputFieldsV2.getMatchWithKey())) {
            return str.matches(this.E.get(this.D.indexOf(cJRUtilityInputFieldsV2.getMatchWithKey())));
        }
        return true;
    }

    private boolean J() {
        List<CJRUtilityInputFieldsV2> inputFields = this.Y.get(0).getInputFields();
        boolean z2 = true;
        for (int i2 = 0; i2 < inputFields.size(); i2++) {
            z2 = a(inputFields.get(i2), this.L, i2);
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public final String v() {
        if (this.o != null) {
            return D();
        }
        return null;
    }

    private boolean K() {
        AutoCompleteTextView autoCompleteTextView = this.o;
        if (autoCompleteTextView == null || autoCompleteTextView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean L() {
        return K() && !TextUtils.isEmpty(v());
    }

    /* access modifiers changed from: protected */
    public final void a(String str, boolean z2) {
        CJRDthPlanInfo cJRDthPlanInfo;
        if (!br) {
            this.bX = str;
            this.bY = z2;
            c(false);
            this.cG = af();
            if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && z2) {
                ((net.one97.paytm.recharge.common.e.y) getActivity()).j();
            }
            ai();
            HashMap<String, String> hashMap = this.ay;
            if (hashMap != null && hashMap.size() > 0) {
                try {
                    for (Map.Entry next : this.ay.entrySet()) {
                        this.aa.put((String) next.getKey(), next.getValue());
                    }
                    if (this.bp) {
                        this.bk = 0;
                        this.aa.put("otcReceived", true);
                        this.aa.put("PlanGuiId", this.bl);
                    }
                    if (this.bk == 1) {
                        this.aa.put("isOTC", this.bj);
                        this.aa.put("PlanGuiId", this.bl);
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
            }
            if (!TextUtils.isEmpty(this.cG)) {
                try {
                    this.aa.put("post_order_view_type", this.cG);
                } catch (JSONException e3) {
                    q.d(e3.getMessage());
                }
            }
            net.one97.paytm.recharge.legacy.catalog.hathway.a.b bVar = this.bT;
            if (!(bVar == null || (cJRDthPlanInfo = bVar.f62931b) == null || cJRDthPlanInfo.getServices() == null || cJRDthPlanInfo.getServices().size() <= 0)) {
                JSONArray jSONArray = new JSONArray();
                for (CJRService next2 : cJRDthPlanInfo.getServices()) {
                    for (CJRPlanExpiryDetails next3 : next2.getPlanExpiryDetails()) {
                        if (next3.isChecked()) {
                            jSONArray.put(next3.getPlanpoid() + next2.getConnectiontype());
                        }
                    }
                }
                try {
                    this.aa.put("planpoid", jSONArray);
                } catch (Exception unused) {
                }
            }
            X();
            if (this.at) {
                this.n.setText(getString(R.string.automatic_verifying_your_bill_text));
            }
            if (this.Y.size() > 0) {
                M();
                if (N() && O()) {
                    d(true);
                    if (this.Y.get(0).getAttributes().isLengthyForm()) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.R));
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        String aN2 = net.one97.paytm.recharge.di.helper.c.aN();
                        if (URLUtil.isValidUrl(aN2)) {
                            String s2 = com.paytm.utility.b.s(this.R, aN2);
                            CJRGWDataModel cJRGWDataModel = new CJRGWDataModel();
                            String jSONObject = a(this.D, this.E).toString();
                            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c("save_lengthy_form", s2, (ai) this, (IJRPaytmDataModel) cJRGWDataModel, (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                            if (com.paytm.network.b.b.a(this.R)) {
                                net.one97.paytm.recharge.common.f.d.a();
                                net.one97.paytm.recharge.common.f.d.b(cVar2);
                                return;
                            }
                            ba.a((net.one97.paytm.recharge.common.f.a) cVar2, this.R);
                            return;
                        }
                        return;
                    }
                    Map<String, String> b2 = b(str, z2);
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    a("post_token_verify", b2, str, (String) null, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                }
            }
        }
    }

    private void a(String str, Map<String, String> map, String str2, String str3, Object obj) {
        String str4 = str3;
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
        String name = cJRUtilityProductListV2 != null ? cJRUtilityProductListV2.getName() : "";
        if (!this.bY || L()) {
            net.one97.paytm.recharge.legacy.catalog.a S2 = S();
            if (str4 != null) {
                try {
                    this.aa.put("gwDataId", str4);
                } catch (JSONException e2) {
                    q.d(e2.getMessage());
                }
            }
            S2.a(str, map, this.D, this.E, this.an, P(), this.aa, this.bF, this.at, this.Y, str2, name, obj);
        }
    }

    private JSONObject a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            try {
                if (!arrayList.get(i2).equalsIgnoreCase("recharge_number") && !arrayList.get(i2).equalsIgnoreCase("recharge_number_2")) {
                    jSONObject2.put(arrayList.get(i2), arrayList2.get(i2));
                }
                i2++;
            } catch (JSONException e2) {
                q.d(e2.getMessage());
            }
        }
        jSONObject.put("data", jSONObject2);
        jSONObject.put(CLPConstants.PRODUCT_ID, this.af);
        jSONObject.put("reqtype", "validation");
        return jSONObject;
    }

    public void onResume() {
        super.onResume();
        if (this.f62821d) {
            this.f62821d = false;
            return;
        }
        d(false);
        if (!com.paytm.utility.e.z.equals(this.U.getCategoryId())) {
            ah();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, boolean z2, String str2) {
        this.aU = str;
        this.cl = Boolean.valueOf(z2);
        this.aV = str2;
        ai();
        CJRUtilityPrefetchV2 X2 = X();
        if (X2 != null) {
            this.n.setText(X2.getProcessing());
        }
        Map<String, String> b2 = b(str, z2);
        if (b2.size() > 0) {
            String obj = b2.keySet().toArray()[0].toString();
            net.one97.paytm.recharge.legacy.catalog.a S2 = S();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            S2.b("get_credit_mid", obj, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        }
    }

    public final void b(String str) {
        i();
        net.one97.paytm.recharge.legacy.catalog.a S2 = S();
        String str2 = this.aS;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        S2.a("get_credit_card_token", str, str2, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    public final void c(String str) {
        i();
        if (!TextUtils.isEmpty(this.Z.getLastUtilityProductList().getGroupFieldV2(0).getCartVerifyType())) {
            this.aW = this.Z.getLastUtilityProductList().getGroupFieldV2(0).getCartVerifyType();
        }
        if (this.Y.size() > 0) {
            Map<String, String> b2 = b(this.aU, this.cl.booleanValue());
            M();
            if (N() && O()) {
                net.one97.paytm.recharge.legacy.catalog.a S2 = S();
                ArrayList<String> arrayList = this.D;
                ArrayList<String> arrayList2 = this.E;
                boolean P2 = P();
                String str2 = this.aS;
                String str3 = this.aT;
                String str4 = this.aW;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                S2.a("post_token_verify", b2, arrayList, arrayList2, P2, str, str2, str3, str4, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
            }
        }
    }

    private Map<String, String> b(String str, boolean z2) {
        HashMap hashMap = new HashMap();
        int size = this.Y.size();
        for (int i2 = 0; i2 < size; i2++) {
            List<CJRUtilityCheckboxItem> list = this.bF;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.bF.size(); i3++) {
                    if (this.bF.get(i3).getId() == this.Y.get(i2).getId()) {
                        hashMap.put(String.valueOf(this.bF.get(i3).getId()), this.bF.get(i3).getPrice());
                    }
                }
            } else if (!z2 && this.Y.get(i2).getAttributes() != null && ("1".equalsIgnoreCase(this.Y.get(i2).getAttributes().getFeeTypeFlow()) || "1".equalsIgnoreCase(this.Y.get(i2).getAttributes().getCheckboxFlowType()))) {
                hashMap.clear();
                hashMap.put(String.valueOf(this.Y.get(i2).getId()), str);
                return hashMap;
            } else if (z2) {
                hashMap.clear();
                hashMap.put(String.valueOf(this.Y.get(i2).getId()), str);
                return hashMap;
            } else {
                hashMap.put(String.valueOf(this.Y.get(i2).getId()), str);
            }
        }
        return hashMap;
    }

    private ArrayList<String> M() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.Y.size();
        for (int i2 = 0; i2 < size; i2++) {
            List<CJRUtilityCheckboxItem> list = this.bF;
            if (list == null || list.size() <= 0) {
                arrayList.add(String.valueOf(this.Y.get(i2).getId()));
            } else {
                for (int i3 = 0; i3 < this.bF.size(); i3++) {
                    if (this.bF.get(i3).getId() == this.Y.get(i2).getId()) {
                        arrayList.add(String.valueOf(this.bF.get(i3).getId()));
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean N() {
        CJRRechargeConfigurationV2 configuration;
        CJRRechargeDetailProductList cJRRechargeDetailProductList = this.x;
        if (cJRRechargeDetailProductList == null || (configuration = cJRRechargeDetailProductList.getConfiguration()) == null || !configuration.getStatus().equalsIgnoreCase("INACTIVE")) {
            return true;
        }
        a(configuration.getError());
        h();
        return false;
    }

    public final void o() {
        h();
        d(false);
        G();
    }

    public final void a(String str, Map<String, String> map, String str2) {
        if (getActivity() != null) {
            d(false);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            if (a2.getFlowName() != null) {
                a2.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
                a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
                a2.getFlowName().setRequestBody(str2);
            }
            ba.a((net.one97.paytm.recharge.common.f.a) new net.one97.paytm.recharge.common.f.c("checkout", str, (ai) this, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, map, str2, (Object) a2), getContext());
        }
    }

    public final boolean b() {
        return ba.a((View) this.aX);
    }

    public final void a(net.one97.paytm.recharge.common.f.a aVar, Context context, boolean z2) {
        if (getActivity() != null) {
            d(false);
            ba.a(aVar, context, (DialogInterface.OnCancelListener) null, (aa) z2 ? this : null);
        }
    }

    public final void f() {
        ai();
    }

    public final void a(CJRPGTokenList cJRPGTokenList) {
        net.one97.paytm.recharge.legacy.catalog.a aVar = this.aJ;
        if (aVar != null) {
            CJRRechargeCart cJRRechargeCart = this.bK;
            aVar.a(cJRPGTokenList, cJRRechargeCart, a(cJRRechargeCart, this.aa), this.bF, P());
        }
    }

    private JSONObject a(CJRRechargeCart cJRRechargeCart, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.aW) && this.aW.equalsIgnoreCase("CC_BILL_PAYMENT")) {
            try {
                return new JSONObject(new f().b(cJRRechargeCart.getCart().getCartItems().get(0).getMetaDataResponse()));
            } catch (IndexOutOfBoundsException | NullPointerException | JSONException unused) {
            }
        }
        return jSONObject;
    }

    private boolean O() {
        CJRRechargeConfigurationV2 configuration;
        CJRRechargeDetailProductList cJRRechargeDetailProductList = this.x;
        if (cJRRechargeDetailProductList == null || (configuration = cJRRechargeDetailProductList.getConfiguration()) == null || !configuration.getStatus().equalsIgnoreCase("SOFTBLOCK")) {
            return true;
        }
        configuration.getError();
        h();
        return false;
    }

    private boolean P() {
        CheckBox checkBox = this.f62826i;
        if (checkBox == null || checkBox.getVisibility() != 0) {
            return false;
        }
        return this.f62826i.isChecked();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.aI = (b) context;
        }
        if (context instanceof af) {
            this.bE = (af) context;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        g(false);
    }

    /* access modifiers changed from: private */
    public void g(boolean z2) {
        if (isAdded() && this.n != null && this.bO) {
            CJRUtilityPrefetchV2 X2 = X();
            if (z2) {
                if (this.o != null) {
                    if (!TextUtils.isEmpty(D()) && ba.g(D())) {
                        this.n.setText(getResources().getString(R.string.proceed_btn_ff_selected, new Object[]{D()}));
                    } else if (X2 == null) {
                        this.n.setText(getResources().getString(R.string.utility_proceed));
                    } else if (this.bK != null) {
                        this.n.setText(X2.getPost());
                    } else {
                        this.n.setText(X2.getPre());
                    }
                }
            } else if (X2 == null) {
                this.n.setText(getResources().getString(R.string.utility_proceed));
            } else if (this.bK != null) {
                this.n.setText(X2.getPost());
            } else {
                this.n.setText(X2.getPre());
            }
            if (!TextUtils.isEmpty(this.bR) && this.o != null) {
                double parseDouble = Double.parseDouble(D()) + Double.parseDouble(m(this.bR));
                this.n.setText(getResources().getString(R.string.proceed_btn_ff_selected, new Object[]{String.valueOf(parseDouble)}));
            }
        }
    }

    public void setSelectedDate(String str) {
        this.bJ.setText(str);
    }

    private void a(CJRError cJRError) {
        String str;
        String str2;
        if (getActivity() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            String str3 = null;
            if (cJRError != null) {
                str3 = cJRError.getTitle();
                str2 = cJRError.getMessage();
                str = cJRError.getOkButtonText();
            } else {
                str = null;
                str2 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = getResources().getString(R.string.error);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = getResources().getString(R.string.alert_msg_temporarily_unavailable);
            }
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.ok);
            }
            builder.setTitle(str3).setMessage(str2);
            builder.setPositiveButton(str, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    private void Q() {
        try {
            this.t = 0;
            if (this.w != null) {
                this.w.setVisibility(8);
            }
            if (this.A != null) {
                this.A.removeAllViews();
            }
            if (this.u != null) {
                this.u.removeAllViews();
            }
            if (this.L != null) {
                this.L.removeAllViews();
            }
            if (this.o != null) {
                this.o.setVisibility(8);
            }
            this.C = null;
            this.o = null;
            this.x = null;
            if (this.s != null) {
                this.s.setVisibility(8);
            }
            if (this.f62826i != null) {
                this.f62826i.setChecked(false);
            }
            g(false);
            y();
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    private void i(String str) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke() {
                return FJRRechargeUtilityBaseV2.this.r(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x r(String str) {
        String str2 = this.f62826i.isChecked() ? "checked" : "unchecked";
        HashMap hashMap = new HashMap();
        AutoCompleteTextView autoCompleteTextView = this.o;
        if (autoCompleteTextView == null || autoCompleteTextView.getVisibility() != 0) {
            hashMap.put("recharge_utilities_service_type", this.ai);
            hashMap.put("recharge_utilities_proceed_fetch_error_message", str);
            hashMap.put("recharge_utilities_group_field_values", z());
            hashMap.put("recharge_utilities_input_field_values", A());
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_proceed_fetch_error", getActivity());
            return null;
        }
        hashMap.put("recharge_utilities_service_type", this.ai);
        hashMap.put("recharge_utilities_proceed_error_message", str);
        hashMap.put("recharge_utilities_ff_state", str2);
        if (this.o != null) {
            hashMap.put("recharge_utilities_amount", D());
        }
        hashMap.put("recharge_utilities_group_field_values", Y());
        hashMap.put("recharge_utilities_input_field_values", A());
        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_proceed_error", getActivity());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x q(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_group_field", str);
        hashMap.put("recharge_utilities_service_type", this.ai);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_group_field_clicked", getActivity());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x p(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_input_field", str);
        hashMap.put("recharge_utilities_service_type", this.ai);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_input_field_clicked", getActivity());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x o(String str) {
        HashMap hashMap = new HashMap();
        if (this.o != null) {
            hashMap.put("recharge_utilities_amount", D());
        }
        hashMap.put("recharge_utilities_service_type", this.ai);
        hashMap.put("recharge_utilities_ff_state", str);
        hashMap.put("recharge_utilities_group_field_values", z());
        hashMap.put("recharge_utilities_input_field_values", Y());
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_fast_forward_clicked", getActivity());
        return null;
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        TextView textView;
        int a2;
        int i2;
        h();
        if (cJRUtilityLocationModel != null && (textView = this.z) != null) {
            List list = (List) textView.getTag();
            int intValue = ((Integer) list.get(0)).intValue();
            int intValue2 = ((Integer) list.get(1)).intValue();
            CJRUtilityProductListV2 c2 = c(intValue);
            if (c2.getGroupFieldV2(intValue2) == null) {
                return;
            }
            if ((c2.getGroupFieldV2(intValue2).getKey().equalsIgnoreCase("state") || c2.getGroupFieldV2(intValue2).getKey().equalsIgnoreCase("city")) && (a2 = a(c2.getVariantList(), cJRUtilityLocationModel.getState())) != -1) {
                String displayName = c2.getVariantList().get(a2).getDisplayName();
                if (c2.getVariantList().get(a2).getVariants().size() > 0) {
                    int a3 = a(c2.getVariantList().get(a2).getVariants(), cJRUtilityLocationModel.getCity());
                    if (a3 != -1) {
                        displayName = c2.getVariantList().get(a2).getVariants().get(a3).getDisplayName() + ", " + displayName;
                        i2 = a3;
                    } else {
                        return;
                    }
                } else {
                    i2 = -1;
                }
                this.z.setText(displayName);
                a(intValue2, a2, i2, this.y, c2.getVariantList().get(a2), true, c2, intValue);
            }
        }
    }

    /* access modifiers changed from: private */
    public CJRUtilityProductListV2 c(int i2) {
        for (CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z; cJRUtilityProductListV2 != null; cJRUtilityProductListV2 = cJRUtilityProductListV2.getNextLevelProductList()) {
            if (cJRUtilityProductListV2.getGroupLevel() == i2) {
                return cJRUtilityProductListV2;
            }
        }
        return null;
    }

    private static int a(List<CJRUtilityVariantV2> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getFilterName().equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    private static int b(List<CJRUtilityVariantV2> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String a2 = z.a(str);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a2.contains(z.a(list.get(i2).getFilterName()))) {
                return i2;
            }
        }
        return -1;
    }

    public final void b(List<CJRUtilityCheckboxItem> list) {
        f(list);
        e(list);
    }

    public final void c(List<CJRUtilityCheckboxItem> list) {
        f(list);
        e(list);
    }

    private void f(List<CJRUtilityCheckboxItem> list) {
        List<CJRUtilityCheckboxItem> list2 = this.bF;
        if (list2 != null) {
            list2.clear();
        } else {
            this.bF = new ArrayList();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).isChecked()) {
                this.bF.add(list.get(i2));
            }
        }
    }

    public void onOkClick() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private static void c(int i2, CJRUtilityProductListV2 cJRUtilityProductListV2) {
        if (!(cJRUtilityProductListV2 == null || cJRUtilityProductListV2.getSelectedGroupItemHashMap() == null)) {
            while (cJRUtilityProductListV2.getSelectedGroupItemHashMap().containsKey(Integer.valueOf(i2))) {
                cJRUtilityProductListV2.getSelectedGroupItemHashMap().remove(Integer.valueOf(i2));
                i2++;
            }
        }
        cJRUtilityProductListV2.setNextLevelProductList((CJRUtilityProductListV2) null);
    }

    private void a(int i2, int i3) {
        if (this.u != null) {
            int i4 = 0;
            while (i4 < this.u.getChildCount()) {
                List list = (List) this.u.getChildAt(i4).getTag();
                if (i3 < ((Integer) list.get(0)).intValue() && i2 <= ((Integer) list.get(1)).intValue()) {
                    this.u.removeViewAt(i4);
                }
                if (i3 != ((Integer) list.get(0)).intValue() || i2 >= ((Integer) list.get(1)).intValue()) {
                    i4++;
                } else {
                    this.u.removeViewAt(i4);
                }
            }
        }
    }

    private void R() {
        LinearLayout linearLayout = this.L;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        LinearLayout linearLayout2 = this.A;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
    }

    private void a(String str, TextView textView, String str2, boolean z2, String str3) {
        if (str != null && textView != null) {
            ViewParent parent = textView.getParent();
            boolean z3 = parent instanceof TextInputLayout;
            if (z3) {
                ((TextInputLayout) parent).setHintAnimationEnabled(false);
            }
            textView.setText(str);
            if ((!com.paytm.utility.e.z.equals(this.U.getCategoryId()) || TextUtils.isEmpty(textView.getText()) || !"Mumbai Metro".equalsIgnoreCase(textView.getText().toString())) && !"Delhi Metro".equalsIgnoreCase(textView.getText().toString()) && !"Hyderabad Metro".equalsIgnoreCase(textView.getText().toString()) && !getString(R.string.delhi_metro_operator).equalsIgnoreCase(textView.getText().toString()) && !getString(R.string.hyderabad_metro_operator).equalsIgnoreCase(textView.getText().toString()) && !getString(R.string.mumbai_metro_operator).equalsIgnoreCase(textView.getText().toString())) {
                this.bV.setVisibility(8);
            } else {
                this.bV.setVisibility(0);
            }
            if (!str3.isEmpty()) {
                str = str3;
            }
            a(str2, str, z2);
            if (z3) {
                ((TextInputLayout) parent).setHintAnimationEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2, CJRUtilityProductListV2 cJRUtilityProductListV2, int i3) {
        CJRUtilityVariantV2 cJRUtilityVariantV2;
        if (this.cE == null) {
            this.cE = Boolean.valueOf(z2);
        }
        List<CJRUtilityVariantV2> list = null;
        if (this.bi != null || this.cD == null) {
            cJRUtilityVariantV2 = null;
        } else {
            if (this.cc == null) {
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                this.cc = c.a.d((List<? extends CJRUtilityVariantV2>) cJRUtilityProductListV2.getVariantList());
            }
            Iterator<CJRUtilityVariantV2> it2 = cJRUtilityProductListV2.getVariantList().iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    cJRUtilityVariantV2 = null;
                    break;
                }
                CJRUtilityVariantV2 next = it2.next();
                CJRUtilityVariantV2 cJRUtilityVariantV22 = this.cc;
                if (cJRUtilityVariantV22 != null && cJRUtilityVariantV22.getFilterName().equalsIgnoreCase(next.getFilterName())) {
                    cJRUtilityVariantV2 = next;
                    break;
                }
                i4++;
            }
            if (z2 && cJRUtilityVariantV2 != null) {
                a(0, i4, -1, (TextView) this.u.getChildAt(0).findViewById(R.id.group_field_textview), cJRUtilityVariantV2, false, cJRUtilityProductListV2, i3);
                return;
            }
        }
        if (cJRUtilityProductListV2 != null) {
            list = cJRUtilityProductListV2.getVariantList();
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                CJRUtilityVariantV2 cJRUtilityVariantV23 = new CJRUtilityVariantV2();
                if (!com.paytm.utility.e.z.equals(this.U.getCategoryId()) || TextUtils.isEmpty(list.get(i5).getAttributes().getConfig_metro())) {
                    cJRUtilityVariantV23.setDisplayName(list.get(i5).getDisplayName());
                } else {
                    cJRUtilityVariantV23.setDisplayName(list.get(i5).getAttributes().getConfig_metro());
                }
                cJRUtilityVariantV23.setFilterName(list.get(i5).getFilterName());
                cJRUtilityVariantV23.setAttributes(list.get(i5).getAttributes());
                arrayList.add(cJRUtilityVariantV23);
            }
            net.one97.paytm.recharge.legacy.catalog.b.a.a().f62802c = arrayList;
        }
        Intent intent = new Intent(getActivity(), AJRTicketOptionsActivity.class);
        intent.putExtra("extra_home_data", this.U);
        if (cJRUtilityVariantV2 == null) {
            cJRUtilityVariantV2 = this.bi;
        }
        AJRTicketOptionsActivity.a aVar2 = AJRTicketOptionsActivity.f63243a;
        intent.putExtra(AJRTicketOptionsActivity.C, this.cE);
        this.cE = Boolean.FALSE;
        if (cJRUtilityVariantV2 != null) {
            c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
            this.bf = c.a.f(cJRUtilityVariantV2.getFilterName());
        }
        AJRTicketOptionsActivity.a aVar4 = AJRTicketOptionsActivity.f63243a;
        intent.putExtra(AJRTicketOptionsActivity.D, this.bf);
        intent.putExtra("metroTicketVariant", cJRUtilityVariantV2);
        intent.putExtra("is_help_section_enabled", cJRUtilityProductListV2.isShowHelp());
        intent.putExtra("fast_forward", this.Z.getShowFastforward());
        intent.putExtra("extra_home_data", this.U);
        intent.putExtra("vertical_name", this.bz);
        getActivity().startActivityForResult(intent, i2);
    }

    private String h(boolean z2) {
        String str;
        if (this.Z == null || z2) {
            return this.U.getURL();
        }
        StringBuilder sb = new StringBuilder("");
        CJRUtilityProductListV2 lastUtilityProductList = this.Z.getLastUtilityProductList();
        if (lastUtilityProductList.getNextGroupingList() != null) {
            for (int i2 = 0; i2 < lastUtilityProductList.getNextGroupingList().size(); i2++) {
                sb.append(lastUtilityProductList.getNextGroupingList().get(i2));
                if (i2 < lastUtilityProductList.getNextGroupingList().size() - 1) {
                    sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("");
        for (CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z; cJRUtilityProductListV2 != null; cJRUtilityProductListV2 = cJRUtilityProductListV2.getNextLevelProductList()) {
            Map<Integer, CJRUtilitySelectedGroupItemV2> selectedGroupItemHashMap = cJRUtilityProductListV2.getSelectedGroupItemHashMap();
            ArrayList arrayList = new ArrayList(selectedGroupItemHashMap.keySet());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb2.append("&filter_");
                sb2.append(selectedGroupItemHashMap.get(arrayList.get(i3)).getGroupKey());
                sb2.append("=");
                String itemFilterName = selectedGroupItemHashMap.get(arrayList.get(i3)).getItemFilterName();
                try {
                    itemFilterName = URLEncoder.encode(itemFilterName, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8).replace("+", "%20");
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
                sb2.append(itemFilterName);
            }
        }
        if (lastUtilityProductList == null || lastUtilityProductList.getRc() == null || lastUtilityProductList.getRc().size() <= 0) {
            if (this.U.getURL().contains("?")) {
                str = this.U.getURL() + "&groupV2=" + sb + sb2;
            } else {
                str = this.U.getURL() + "?groupV2=" + sb + sb2;
            }
        } else if (lastUtilityProductList.getUrl().contains("?")) {
            str = lastUtilityProductList.getUrl() + "&groupV2=" + sb + sb2;
        } else {
            str = lastUtilityProductList.getUrl() + "?groupV2=" + sb + sb2;
        }
        return str.replace(" ", "%20");
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.legacy.catalog.a w() {
        return new net.one97.paytm.recharge.legacy.catalog.a((Context) getActivity(), this.bz, (af) this, (g.a) this, (h) this, (aa) this);
    }

    private net.one97.paytm.recharge.legacy.catalog.a S() {
        FragmentActivity activity = getActivity();
        FragmentActivity activity2 = getActivity();
        String str = this.bz;
        return new net.one97.paytm.recharge.legacy.catalog.a(activity, activity2, str, this, this, "Recharge/" + this.M, this, this);
    }

    public final void a(String str, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            str = h(z2);
        }
        if (z2) {
            this.Z = null;
            Q();
            x();
        }
        if (com.paytm.utility.e.z.equals(this.U.getCategoryId())) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            net.one97.paytm.recharge.metro.f.c.m.clear();
            if (!this.bv) {
                this.bw = z2;
                this.by = str;
                this.bx = z3;
                if (!z.a((Context) getActivity())) {
                    z.a((Activity) getActivity(), (Fragment) this, 102);
                    return;
                } else {
                    a(this.bw, this.bx, this.by);
                    return;
                }
            }
        } else {
            this.bf = false;
        }
        if (getActivity() != null) {
            this.V = w();
            if (com.paytm.utility.e.z.equals(this.U.getCategoryId())) {
                net.one97.paytm.recharge.legacy.catalog.a aVar2 = this.V;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar2.a("getCategory", str, false, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                return;
            }
            net.one97.paytm.recharge.legacy.catalog.a aVar3 = this.V;
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar3.a("getCategory", str, z3, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        }
    }

    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    private void a(boolean z2, boolean z3, String str) {
        j();
        final a aVar = new a(str, z2, z3);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
        a2.getFlowName().setActionType(ACTION_TYPE.GET_ACTIVE_TICKET_AND_PASSES.name());
        net.one97.paytm.recharge.metro.f.a.a("fetch_active_active_tickets", getContext(), (b.a<List<CJRActiveMetroTicketModel>>) aVar, (ai) new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                FJRRechargeUtilityBaseV2.this.a(100);
                if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                    CJRRechargeUtilities.INSTANCE.handleError(str, FJRRechargeUtilityBaseV2.this.getActivity(), FJRRechargeUtilityBaseV2.this, networkCustomError, true, 102, obj);
                    return;
                }
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
                aVar.a((List<CJRActiveMetroTicketModel>) null, false);
            }
        }, (Object) a2);
    }

    public final void b(boolean z2) {
        i(z2);
    }

    class a implements b.a<List<CJRActiveMetroTicketModel>> {

        /* renamed from: b  reason: collision with root package name */
        private String f62885b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62886c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f62887d;

        a(String str, boolean z, boolean z2) {
            this.f62885b = str;
            this.f62886c = z;
            this.f62887d = z2;
        }

        public final void a(List<CJRActiveMetroTicketModel> list, boolean z) {
            FJRRechargeUtilityBaseV2.this.bf = FJRRechargeUtilityBaseV2.d((List) list);
            boolean unused = FJRRechargeUtilityBaseV2.this.bv = true;
            List unused2 = FJRRechargeUtilityBaseV2.this.cD = list;
            if (z) {
                FJRRechargeUtilityBaseV2.this.a(100);
                Intent intent = new Intent(FJRRechargeUtilityBaseV2.this.getContext(), AJRActiveMetroTicketListActivity.class);
                intent.putExtra("metro_offline", true);
                intent.putExtra("activeMetroTickets", (Serializable) FJRRechargeUtilityBaseV2.this.cD);
                FJRRechargeUtilityBaseV2.this.startActivityForResult(intent, 1000);
                return;
            }
            FJRRechargeUtilityBaseV2.this.a(this.f62885b, this.f62886c, this.f62887d);
        }
    }

    /* access modifiers changed from: protected */
    public void e(String str) {
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
        if (cJRUtilityProductListV2 != null) {
            cJRUtilityProductListV2.setGaKey(str);
        }
    }

    private void a(int i2, int i3, int i4, TextView textView, CJRUtilityVariantV2 cJRUtilityVariantV2, boolean z2, CJRUtilityProductListV2 cJRUtilityProductListV2, int i5) {
        AutoCompleteTextView autoCompleteTextView;
        String str;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        CJRUtilityVariantV2 cJRUtilityVariantV22 = cJRUtilityVariantV2;
        CJRUtilityProductListV2 cJRUtilityProductListV22 = cJRUtilityProductListV2;
        int i9 = i5;
        if (i7 != -1) {
            if (i6 == 0) {
                this.bi = cJRUtilityVariantV22;
                if (com.paytm.utility.e.z.equals(this.U.getCategoryId())) {
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    e(c.a.a(this.bi.getFilterName()));
                }
            }
            if (cJRUtilityProductListV22 == null || !cJRUtilityProductListV2.isShowUpgrade() || cJRUtilityVariantV22 == null || cJRUtilityVariantV2.getAttributes() == null || TextUtils.isEmpty(cJRUtilityVariantV2.getAttributes().getMinAndroidVersion()) || !ba.b(cJRUtilityVariantV2.getAttributes().getMinAndroidVersion(), getContext())) {
                this.ah = false;
                c(i6, cJRUtilityProductListV22);
                R();
                a(i6, i9);
                a(i6, i7, cJRUtilityVariantV22, cJRUtilityProductListV22);
                y();
                this.aL = null;
                if (d(i6, cJRUtilityProductListV22) == null || d(i6, cJRUtilityProductListV22).size() <= i7 || d(i6, cJRUtilityProductListV22).get(i7) == null || d(i6, cJRUtilityProductListV22).get(i7).getAttributes() == null || d(i6, cJRUtilityProductListV22).get(i7).getAttributes().getBbpsLogoURL() == null) {
                    aa();
                } else {
                    this.aL = d(i6, cJRUtilityProductListV22).get(i7).getAttributes().getBbpsLogoURL();
                    k(this.aL);
                }
                if (cJRUtilityVariantV2.getProduct() == null || cJRUtilityVariantV2.getProduct().getAttributes() == null || !cJRUtilityVariantV2.getProduct().getAttributes().isMetroTicketFlow()) {
                    TextView textView2 = textView;
                    String displayName = cJRUtilityVariantV2.getDisplayName();
                    if (com.paytm.utility.e.z.equals(this.U.getCategoryId()) && !TextUtils.isEmpty(cJRUtilityVariantV2.getAttributes().getConfig_metro())) {
                        displayName = cJRUtilityVariantV2.getAttributes().getConfig_metro();
                    }
                    String filterName = cJRUtilityVariantV2.getFilterName();
                    if (i8 >= 0) {
                        a(i6 + 1, i8, cJRUtilityProductListV2.getVariantList().get(i7).getVariants().get(i8), cJRUtilityProductListV22);
                        str = cJRUtilityProductListV2.getVariantList().get(i7).getVariants().get(i8).getDisplayName() + ", " + str;
                        if (com.paytm.utility.e.z.equals(this.U.getCategoryId()) && !TextUtils.isEmpty(cJRUtilityProductListV2.getVariantList().get(i7).getVariants().get(i8).getAttributes().getConfig_ticket_type())) {
                            str = cJRUtilityProductListV2.getVariantList().get(i7).getVariants().get(i8).getAttributes().getConfig_ticket_type() + ", " + str;
                        }
                        filterName = cJRUtilityProductListV2.getVariantList().get(i7).getVariants().get(i8).getFilterName() + ", " + filterName;
                    }
                    String str2 = str;
                    if (i9 == 1 && i6 == 0) {
                        j(filterName);
                    }
                    a(str2, textView, cJRUtilityProductListV22.getGroupFieldV2(i6).getLabel(), z2, "");
                    a(cJRUtilityVariantV2.getVariants(), i6 + 1, cJRUtilityVariantV22, cJRUtilityProductListV22);
                } else {
                    textView.setText("");
                    a(200);
                    c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                    if (c.a.a(cJRUtilityVariantV2.getProduct().getId())) {
                        a(cJRUtilityVariantV22);
                    } else {
                        a(true, 183, cJRUtilityProductListV22, i9);
                    }
                }
                if (!this.aK && ((autoCompleteTextView = this.o) == null || autoCompleteTextView.getVisibility() == 8)) {
                    g(false);
                    this.s.setVisibility(8);
                }
                c(true);
                return;
            }
            Context context = getContext();
            net.one97.paytm.recharge.di.helper.a aVar3 = net.one97.paytm.recharge.di.helper.a.f62650a;
            Intent intent = new Intent(context, net.one97.paytm.recharge.di.helper.a.d());
            intent.putExtra("url_type", this.U.getURLType());
            getContext().startActivity(intent);
        }
    }

    private void T() {
        List<CJRUtilityProductV2> list = this.Y;
        if (list != null && list.size() > 0 && this.Y.get(0).getAttributes() != null && this.Y.get(0).getAttributes().isOperatorAlert() && !TextUtils.isEmpty(this.Y.get(0).getAttributes().getOperator())) {
            net.one97.paytm.recharge.common.utils.aa aaVar = new net.one97.paytm.recharge.common.utils.aa(getActivity(), this);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
            a2.getFlowName().setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
            CJRUtilityAttributesV2 attributes = this.Y.get(0).getAttributes();
            aaVar.a("success_rate_alert_message", attributes.getOperator(), this.Y.get(0).getId(), attributes.getService(), attributes.getPaytype(), (String) null, a2);
        }
    }

    private void a(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        CJRUtilityVariantV2 cJRUtilityVariantV22 = null;
        for (CJRUtilityVariantV2 next : this.Z.getLastUtilityProductList().getVariantList()) {
            Iterator<CJRUtilityVariantV2> it2 = next.getVariants().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CJRUtilityVariantV2 next2 = it2.next();
                CJRUtilityVariantV2 cJRUtilityVariantV23 = this.bi;
                if (cJRUtilityVariantV23 != null && !TextUtils.isEmpty(cJRUtilityVariantV23.getFilterName()) && this.bi.getFilterName().equalsIgnoreCase(next.getFilterName()) && next2.equals(cJRUtilityVariantV2)) {
                    cJRUtilityVariantV22 = next;
                    continue;
                    break;
                }
            }
            if (cJRUtilityVariantV22 != null) {
                break;
            }
        }
        Intent putExtra = new Intent(getContext(), AJRMetroTicketPurchaseActivity.class).putExtra("fast_forward", this.Z.getShowFastforward()).putExtra("source", (!this.O.containsKey("station_id") || TextUtils.isEmpty(this.O.get("station_id"))) ? "" : this.O.get("station_id")).putExtra("meta_data", this.aa.toString()).putExtra("input_fields", A()).putExtra("group_field", z()).putExtra("extra_home_data", this.U).putExtra("productVariant", cJRUtilityVariantV2).putExtra("is_help_section_enabled", this.Z.isShowHelp()).putExtra("metroTicketVariant", cJRUtilityVariantV22);
        CJRFrequentOrder cJRFrequentOrder = this.cz;
        if (cJRFrequentOrder != null && (cJRFrequentOrder instanceof CJRMetroQRFrequentOrder)) {
            putExtra.putExtra("metro_qr_frequent_object", cJRFrequentOrder);
            this.cz = null;
        }
        getActivity().startActivityForResult(putExtra, 602);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00da, code lost:
        if (r8 != 5) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014d, code lost:
        if (r3 != false) goto L_0x014f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> r18, int r19, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r20, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = r21
            int r3 = r18.size()
            r4 = 0
            r5 = 200(0xc8, float:2.8E-43)
            r6 = 0
            if (r3 <= 0) goto L_0x031c
            if (r2 == 0) goto L_0x031c
            java.util.List r3 = r21.getCurrentGroupList()
            if (r3 == 0) goto L_0x031c
            r3 = r18
            java.lang.Object r3 = r3.get(r6)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
            r7 = r1
            r1 = r19
        L_0x0023:
            java.util.List r8 = r21.getCurrentGroupList()
            int r8 = r8.size()
            if (r1 >= r8) goto L_0x0308
            if (r3 == 0) goto L_0x02d4
            java.lang.String r8 = r3.getFilterName()
            java.lang.String r9 = "N/A"
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 != 0) goto L_0x0288
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r8 = r2.getGroupFieldV2(r1)
            if (r8 == 0) goto L_0x0288
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r8 = r2.getGroupFieldV2(r1)
            java.lang.Boolean r8 = r8.getShowfield()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0288
            if (r2 == 0) goto L_0x0308
            boolean r3 = r0.at
            if (r3 != 0) goto L_0x0058
            r0.c((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
        L_0x0058:
            java.util.List r3 = r21.getCurrentGroupList()
            java.util.Map r7 = r21.getGroupFieldMap()
            if (r7 == 0) goto L_0x0308
            java.util.Map r7 = r21.getGroupFieldMap()
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x0308
            android.widget.LinearLayout r7 = r0.u
            r7.setVisibility(r6)
            if (r3 == 0) goto L_0x0308
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0308
            if (r2 == 0) goto L_0x0308
            java.util.List r3 = d((int) r1, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r7 = r2.getGroupFieldV2(r1)
            java.lang.String r7 = r7.getType()
            r8 = -1
            int r9 = r7.hashCode()
            r10 = 5
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            switch(r9) {
                case -1830107832: goto L_0x00c7;
                case -1245847267: goto L_0x00bd;
                case -432061423: goto L_0x00b3;
                case 3181382: goto L_0x00a9;
                case 3322014: goto L_0x009f;
                case 108270587: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00d0
        L_0x0095:
            java.lang.String r9 = "radio"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 0
            goto L_0x00d0
        L_0x009f:
            java.lang.String r9 = "list"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 1
            goto L_0x00d0
        L_0x00a9:
            java.lang.String r9 = "grid"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 3
            goto L_0x00d0
        L_0x00b3:
            java.lang.String r9 = "dropdown"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 2
            goto L_0x00d0
        L_0x00bd:
            java.lang.String r9 = "option_tickets"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 5
            goto L_0x00d0
        L_0x00c7:
            java.lang.String r9 = "accordion"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x00d0
            r8 = 4
        L_0x00d0:
            if (r8 == 0) goto L_0x0159
            if (r8 == r14) goto L_0x00ff
            if (r8 == r13) goto L_0x00ff
            if (r8 == r12) goto L_0x00ff
            if (r8 == r11) goto L_0x00de
            if (r8 == r10) goto L_0x014f
            goto L_0x0283
        L_0x00de:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r3 = r2.getGroupFieldV2(r1)
            java.lang.String r3 = r3.getChild()
            if (r3 == 0) goto L_0x00f5
            java.util.List<java.lang.String> r3 = r0.aM
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r5 = r2.getGroupFieldV2(r1)
            java.lang.String r5 = r5.getChild()
            r3.add(r5)
        L_0x00f5:
            android.widget.LinearLayout r3 = r0.w
            r3.setVisibility(r6)
            r0.b((int) r1, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
            goto L_0x0283
        L_0x00ff:
            java.util.List<java.lang.String> r5 = r0.aM
            java.util.Iterator r5 = r5.iterator()
        L_0x0105:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x014c
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r8 = r2.getGroupFieldV2(r1)
            java.lang.String r8 = r8.getKey()
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0105
            java.util.Map r5 = r21.getSelectedGroupItemHashMap()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            boolean r5 = r5.containsKey(r7)
            if (r5 == 0) goto L_0x014a
            java.util.Map r5 = r21.getSelectedGroupItemHashMap()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            java.lang.Object r5 = r5.get(r7)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2) r5
            int r5 = r5.getItemIndex()
            java.lang.Object r5 = r3.get(r5)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            int r7 = r1 + 1
            r0.a((java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2>) r3, (int) r7, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
        L_0x014a:
            r3 = 0
            goto L_0x014d
        L_0x014c:
            r3 = 1
        L_0x014d:
            if (r3 == 0) goto L_0x0283
        L_0x014f:
            android.widget.LinearLayout r3 = r0.w
            r3.setVisibility(r6)
            r0.b((int) r1, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
            goto L_0x0283
        L_0x0159:
            android.widget.LinearLayout r3 = r0.w
            r3.setVisibility(r6)
            java.util.List r3 = d((int) r1, (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2) r2)
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            if (r7 == 0) goto L_0x0280
            if (r3 == 0) goto L_0x0280
            int r7 = r3.size()
            if (r7 <= 0) goto L_0x0280
            androidx.fragment.app.FragmentActivity r7 = r17.getActivity()
            android.view.LayoutInflater r7 = r7.getLayoutInflater()
            int r8 = net.one97.paytm.recharge.R.layout.radio_group_custom_view
            android.view.View r7 = r7.inflate(r8, r4)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            int r8 = net.one97.paytm.recharge.R.id.custom_type_radio_group
            android.view.View r8 = r7.findViewById(r8)
            net.one97.paytm.recharge.legacy.catalog.widget.CustomRadioGroupBaseV2 r8 = (net.one97.paytm.recharge.legacy.catalog.widget.CustomRadioGroupBaseV2) r8
            int r9 = net.one97.paytm.recharge.R.id.payment_underline
            android.view.View r9 = r7.findViewById(r9)
            r10 = 8
            r9.setVisibility(r10)
            androidx.fragment.app.FragmentActivity r9 = r17.getActivity()
            int r9 = com.paytm.utility.b.f((android.content.Context) r9)
            android.widget.RadioGroup$OnCheckedChangeListener r10 = r0.bc
            r8.setOnCheckedChangeListener(r10)
            r8.removeAllViews()
            r10 = 0
        L_0x01a4:
            int r11 = r3.size()
            if (r10 >= r11) goto L_0x01f8
            android.widget.RadioButton r11 = new android.widget.RadioButton
            androidx.fragment.app.FragmentActivity r12 = r17.getActivity()
            r11.<init>(r12)
            java.lang.Object r12 = r3.get(r10)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r12 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r12
            java.lang.String r12 = r12.getDisplayName()
            r11.setText(r12)
            r11.setId(r10)
            android.content.Context r12 = r17.getContext()
            int r15 = net.one97.paytm.recharge.R.color.financial_key_value
            int r12 = androidx.core.content.b.c(r12, r15)
            r11.setTextColor(r12)
            r12 = 1094713344(0x41400000, float:12.0)
            r11.setTextSize(r12)
            int r12 = r9 / 2
            int r15 = r9 * 2
            r11.setPadding(r12, r6, r15, r6)
            int r12 = net.one97.paytm.recharge.R.drawable.btn_radio_holo_light
            r11.setButtonDrawable(r12)
            android.widget.RadioGroup$LayoutParams r12 = new android.widget.RadioGroup$LayoutParams
            r15 = -2
            r12.<init>(r15, r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)
            r11.setTag(r15)
            r15 = 1056964608(0x3f000000, float:0.5)
            r12.weight = r15
            r8.addView(r11, r12)
            int r10 = r10 + 1
            goto L_0x01a4
        L_0x01f8:
            int r9 = r9 / r13
            r8.setPadding(r6, r9, r6, r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            int r10 = r21.getGroupLevel()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.add(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r9.add(r10)
            r7.setTag(r9)
            r8.setTag(r9)
            int r9 = r8.getChildCount()
            if (r9 <= r14) goto L_0x0224
            android.widget.LinearLayout r9 = r0.u
            r9.addView(r7)
        L_0x0224:
            java.util.HashMap<java.lang.String, java.lang.String> r7 = r0.O
            if (r7 == 0) goto L_0x0275
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r9 = r2.getGroupFieldV2(r1)
            java.lang.String r9 = r9.getKey()
            boolean r7 = r7.containsKey(r9)
            if (r7 == 0) goto L_0x0275
            r7 = 0
        L_0x0237:
            int r9 = r3.size()
            if (r7 >= r9) goto L_0x0273
            java.lang.Object r9 = r3.get(r7)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r9
            java.lang.String r9 = r9.getFilterName()
            if (r9 == 0) goto L_0x0270
            java.lang.Object r9 = r3.get(r7)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r9
            java.lang.String r9 = r9.getFilterName()
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r0.O
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r11 = r2.getGroupFieldV2(r1)
            java.lang.String r11 = r11.getKey()
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x0270
            android.view.View r3 = r8.getChildAt(r7)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            goto L_0x027b
        L_0x0270:
            int r7 = r7 + 1
            goto L_0x0237
        L_0x0273:
            r3 = r4
            goto L_0x027b
        L_0x0275:
            android.view.View r3 = r8.getChildAt(r6)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
        L_0x027b:
            if (r3 == 0) goto L_0x0280
            r3.setChecked(r14)
        L_0x0280:
            r0.a((int) r5)
        L_0x0283:
            r0.c((boolean) r14)
            goto L_0x0308
        L_0x0288:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r8 = r3.getProduct()
            if (r8 == 0) goto L_0x02a0
            boolean r8 = d((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3)
            if (r8 == 0) goto L_0x02a0
            boolean r8 = d((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r7)
            if (r8 == 0) goto L_0x02a0
            r0.c((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3)
            r0.a((int) r5)
        L_0x02a0:
            boolean r8 = d((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3)
            if (r8 != 0) goto L_0x02ba
            java.util.List r8 = r3.getVariants()
            if (r8 == 0) goto L_0x02ba
            java.util.List r8 = r3.getVariants()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x02ba
            r0.b((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3)
            goto L_0x0308
        L_0x02ba:
            boolean r8 = d((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r7)
            if (r8 != 0) goto L_0x02e3
            java.util.List r8 = r7.getVariants()
            if (r8 == 0) goto L_0x02e3
            java.util.List r8 = r7.getVariants()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x02e3
            r0.b((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r7)
            goto L_0x0308
        L_0x02d4:
            if (r7 == 0) goto L_0x02e3
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r8 = r7.getProduct()
            if (r8 == 0) goto L_0x02e3
            r0.c((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r7)
            r0.a((int) r5)
            goto L_0x0308
        L_0x02e3:
            if (r3 == 0) goto L_0x0308
            java.util.List r7 = r3.getVariants()
            if (r7 == 0) goto L_0x0308
            java.util.List r7 = r3.getVariants()
            int r7 = r7.size()
            if (r7 == 0) goto L_0x0308
            java.util.List r7 = r3.getVariants()
            java.lang.Object r7 = r7.get(r6)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r7 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r7
            int r1 = r1 + 1
            r16 = r7
            r7 = r3
            r3 = r16
            goto L_0x0023
        L_0x0308:
            java.util.List r3 = r21.getCurrentGroupList()
            if (r3 == 0) goto L_0x031b
            java.util.List r2 = r21.getCurrentGroupList()
            int r2 = r2.size()
            if (r1 != r2) goto L_0x031b
            r0.a((java.lang.String) r4, (boolean) r6, (boolean) r6)
        L_0x031b:
            return
        L_0x031c:
            if (r1 == 0) goto L_0x032b
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r3 = r20.getProduct()
            if (r3 == 0) goto L_0x032b
            r0.c((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r1)
            r0.a((int) r5)
            return
        L_0x032b:
            java.util.List r1 = r21.getCurrentGroupList()
            if (r1 == 0) goto L_0x0340
            java.util.List r1 = r21.getCurrentGroupList()
            int r1 = r1.size()
            r2 = r19
            if (r2 != r1) goto L_0x0340
            r0.a((java.lang.String) r4, (boolean) r6, (boolean) r6)
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.a(java.util.List, int, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r10.getAttributes().getGroupConfigKeyList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(final net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r10) {
        /*
            r9 = this;
            boolean r0 = d((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r10)
            if (r0 != 0) goto L_0x0189
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r0 = r10.getAttributes()
            java.lang.String[] r0 = r0.getGroupConfigKeyList()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0189
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r2 = r9.Y
            r2.clear()
            r2 = 0
            r3 = 0
        L_0x0018:
            java.util.List r4 = r10.getVariants()
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x00b2
            java.util.List r4 = r10.getVariants()
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r4 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r4
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r4 = r4.getProduct()
            if (r4 == 0) goto L_0x00ae
            java.lang.String r5 = com.paytm.utility.e.z
            net.one97.paytm.common.entity.CJRItem r6 = r9.U
            java.lang.String r6 = r6.getCategoryId()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x006e
            java.util.List r5 = r10.getVariants()
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r5 = r5.getAttributes()
            java.lang.String r5 = r5.getConfig_ticket_type()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x006e
            java.util.List r5 = r10.getVariants()
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r5 = r5.getAttributes()
            java.lang.String r5 = r5.getConfig_ticket_type()
            r4.setDisplayName(r5)
            goto L_0x007f
        L_0x006e:
            java.util.List r5 = r10.getVariants()
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            java.lang.String r5 = r5.getDisplayName()
            r4.setDisplayName(r5)
        L_0x007f:
            java.util.List r5 = r10.getVariants()
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            java.lang.String r5 = r5.getFilterName()
            r4.setFilterName(r5)
            java.util.List r5 = r10.getVariants()
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r5
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r5 = r5.getProduct()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r5 = r5.getAttributes()
            java.lang.String r5 = r5.getFeeTypeKey()
            r4.setFeeTypeKey(r5)
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r5 = r9.Y
            r5.add(r4)
        L_0x00ae:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x00b2:
            boolean r3 = r9.at
            if (r3 != 0) goto L_0x00c5
            android.os.Handler r3 = new android.os.Handler
            r3.<init>()
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$17 r4 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$17
            r4.<init>(r10)
            r5 = 500(0x1f4, double:2.47E-321)
            r3.postDelayed(r4, r5)
        L_0x00c5:
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r10 = r9.Y
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x0189
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r10 = r9.Y
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r10 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r10
            java.util.List r10 = r10.getInputFields()
            r3 = 0
            r4 = 0
        L_0x00db:
            if (r3 >= r1) goto L_0x0139
            r5 = 0
        L_0x00de:
            int r6 = r10.size()
            if (r5 >= r6) goto L_0x0131
            java.util.Map<java.lang.String, java.lang.Boolean> r6 = r9.cr
            java.lang.Object r7 = r10.get(r5)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r7 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r7
            java.lang.String r7 = r7.getConfigKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x0107
            java.util.Map<java.lang.String, java.lang.Boolean> r6 = r9.cr
            java.lang.Object r7 = r10.get(r5)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r7 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r7
            java.lang.String r7 = r7.getConfigKey()
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r6.put(r7, r8)
        L_0x0107:
            r6 = r0[r3]
            java.lang.Object r7 = r10.get(r5)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r7 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r7
            java.lang.String r7 = r7.getConfigKey()
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x012e
            if (r4 != 0) goto L_0x0120
            android.widget.LinearLayout r6 = r9.A
            r6.removeAllViews()
        L_0x0120:
            int r4 = r4 + 1
            java.lang.Object r6 = r10.get(r5)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r6 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r6
            android.widget.LinearLayout r7 = r9.A
            r9.b((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r6, (android.widget.LinearLayout) r7, (int) r5)
            goto L_0x0131
        L_0x012e:
            int r5 = r5 + 1
            goto L_0x00de
        L_0x0131:
            r5 = 200(0xc8, float:2.8E-43)
            r9.a((int) r5)
            int r3 = r3 + 1
            goto L_0x00db
        L_0x0139:
            if (r10 == 0) goto L_0x0189
            int r0 = r10.size()
            if (r0 <= 0) goto L_0x0189
            java.lang.Object r0 = r10.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r0
            java.lang.String r0 = r0.getConfigKey()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0189
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r9.O
            if (r0 == 0) goto L_0x0189
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r10 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r10
            java.lang.String r10 = r10.getConfigKey()
            boolean r10 = r0.containsKey(r10)
            if (r10 == 0) goto L_0x0189
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r9.O
            r10.clear()
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r10 = r9.Y
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r10 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r10
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r10 = r10.getAttributes()
            java.lang.String r10 = r10.getPrefetch()
            java.lang.String r0 = "1"
            boolean r10 = r10.equalsIgnoreCase(r0)
            if (r10 == 0) goto L_0x0189
            boolean r10 = r9.aA
            if (r10 != 0) goto L_0x0189
            r9.F()
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.b(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2):void");
    }

    private void c(final CJRUtilityVariantV2 cJRUtilityVariantV2) {
        HashMap<String, String> hashMap;
        if (this.Y.size() == 0) {
            this.Y.add(cJRUtilityVariantV2.getProduct());
            this.Y.get(0).setFilterName(cJRUtilityVariantV2.getFilterName());
            if (!com.paytm.utility.e.z.equals(this.U.getCategoryId()) || TextUtils.isEmpty(cJRUtilityVariantV2.getAttributes().getConfig_metro())) {
                this.Y.get(0).setDisplayName(cJRUtilityVariantV2.getDisplayName());
            } else {
                this.Y.get(0).setDisplayName(cJRUtilityVariantV2.getAttributes().getConfig_metro());
            }
        }
        if (this.Y.get(0).getAttributes() != null) {
            CJRUtilityAttributesV2 attributes = this.Y.get(0).getAttributes();
            if (attributes.getAmountButtonList() != null) {
                this.bN = attributes.getAmountButtonList();
            }
            if (attributes.getAlert() != null) {
                if (attributes.getAlert().getHeading() != null) {
                    this.ab = attributes.getAlert().getHeading();
                }
                if (attributes.getAlert().getMessage() != null) {
                    this.ac = attributes.getAlert().getMessage();
                }
                if (attributes.getAlert().getPositive_btn_txt() != null) {
                    this.ad = attributes.getAlert().getPositive_btn_txt();
                }
                if (attributes.getAlert().getNegative_btn_txt() != null) {
                    this.ae = attributes.getAlert().getNegative_btn_txt();
                }
            }
            if (!TextUtils.isEmpty(attributes.getBbpsLogoURL())) {
                this.aL = attributes.getBbpsLogoURL();
                k(this.aL);
            }
        }
        try {
            this.af = String.valueOf(this.Y.get(0).getId());
        } catch (NullPointerException unused) {
        }
        a(cJRUtilityVariantV2.getProduct().getInputFields(), this.A);
        List<CJRUtilityInputFieldsV2> inputFields = this.Y.get(0).getInputFields();
        if (inputFields != null && inputFields.size() > 0 && !TextUtils.isEmpty(inputFields.get(0).getConfigKey()) && (hashMap = this.O) != null && hashMap.containsKey(inputFields.get(0).getConfigKey())) {
            this.O.clear();
            if (this.Y.get(0).getAttributes().getPrefetch().equalsIgnoreCase("1") && !this.aA) {
                F();
            }
        }
        T();
        if (!this.at) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    FJRRechargeUtilityBaseV2.a(FJRRechargeUtilityBaseV2.this, cJRUtilityVariantV2);
                }
            }, 500);
        }
    }

    private void a(int i2, int i3, CJRUtilityVariantV2 cJRUtilityVariantV2, CJRUtilityProductListV2 cJRUtilityProductListV2) {
        CJRUtilitySelectedGroupItemV2 cJRUtilitySelectedGroupItemV2 = new CJRUtilitySelectedGroupItemV2();
        if (cJRUtilityProductListV2.getGroupFieldV2(i2) != null) {
            cJRUtilitySelectedGroupItemV2.setGroupName(cJRUtilityProductListV2.getGroupFieldV2(i2).getLabel());
            cJRUtilitySelectedGroupItemV2.setGroupKey(cJRUtilityProductListV2.getGroupFieldV2(i2).getKey());
            cJRUtilitySelectedGroupItemV2.setGroupType(cJRUtilityProductListV2.getGroupFieldV2(i2).getType());
        }
        if (cJRUtilityVariantV2 != null) {
            String displayName = cJRUtilityVariantV2.getDisplayName();
            if (com.paytm.utility.e.z.equals(this.U.getCategoryId()) && !TextUtils.isEmpty(cJRUtilityVariantV2.getAttributes().getConfig_metro()) && !TextUtils.isEmpty(cJRUtilityVariantV2.getAttributes().getConfig_ticket_type())) {
                if (i2 == 0) {
                    displayName = cJRUtilityVariantV2.getAttributes().getConfig_metro();
                } else if (i2 == 1) {
                    displayName = cJRUtilityVariantV2.getAttributes().getConfig_ticket_type();
                }
            }
            cJRUtilitySelectedGroupItemV2.setItemDisplayName(displayName);
            cJRUtilitySelectedGroupItemV2.setItemFilterName(cJRUtilityVariantV2.getFilterName());
            cJRUtilitySelectedGroupItemV2.setAttributes(cJRUtilityVariantV2.getAttributes());
            if (cJRUtilityVariantV2.getVariants() != null && cJRUtilityVariantV2.getVariants().size() > 0) {
                while (cJRUtilityVariantV2.getVariants().size() > 0 && cJRUtilityVariantV2.getVariants().get(0).getFilterName().equalsIgnoreCase("N/A")) {
                    cJRUtilityVariantV2 = cJRUtilityVariantV2.getVariants().get(0);
                }
                cJRUtilitySelectedGroupItemV2.setItemVarientList(cJRUtilityVariantV2.getVariants());
            }
        }
        cJRUtilitySelectedGroupItemV2.setItemIndex(i3);
        cJRUtilitySelectedGroupItemV2.setGroupIndex(i2);
        cJRUtilityProductListV2.addItemToSelectedHashMap(i2, cJRUtilitySelectedGroupItemV2);
    }

    /* access modifiers changed from: private */
    public static List<CJRUtilityVariantV2> d(int i2, CJRUtilityProductListV2 cJRUtilityProductListV2) {
        if (e(i2, cJRUtilityProductListV2)) {
            return b(cJRUtilityProductListV2);
        }
        return cJRUtilityProductListV2.getVariantListForGroupIndexForSelectedItems(i2);
    }

    private static boolean e(int i2, CJRUtilityProductListV2 cJRUtilityProductListV2) {
        if (!(cJRUtilityProductListV2.getSelectedGroupItemHashMap() == null || cJRUtilityProductListV2.getSelectedGroupItemHashMap().size() == 0 || i2 == 0 || cJRUtilityProductListV2 == null)) {
            List<CJRUtilityVariantV2> variantList = cJRUtilityProductListV2.getVariantList();
            int i3 = 0;
            while (variantList != null && variantList.size() > 0 && variantList.get(0) != null && "N/A".equalsIgnoreCase(variantList.get(0).getFilterName())) {
                variantList = variantList.get(0).getVariants();
                i3++;
            }
            if (i3 < i2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> b(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r3) {
        /*
            if (r3 == 0) goto L_0x0031
            java.util.List r3 = r3.getVariantList()
        L_0x0006:
            r0 = 0
            java.lang.Object r1 = r3.get(r0)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r1
            java.lang.String r1 = r1.getFilterName()
            java.lang.String r2 = "N/A"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0030
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r3 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r3
            java.util.List r3 = r3.getVariants()
            if (r3 == 0) goto L_0x002b
            int r0 = r3.size()
            if (r0 != 0) goto L_0x0006
        L_0x002b:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0030:
            return r3
        L_0x0031:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.b(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x0562 A[Catch:{ Exception -> 0x05bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x056a A[Catch:{ Exception -> 0x05bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05b9 A[Catch:{ Exception -> 0x05bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r18, android.widget.LinearLayout r19, int r20) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "amount"
            java.lang.String r1 = "input_read_only"
            java.lang.String r11 = "date"
            android.content.Context r2 = r7.R
            if (r2 != 0) goto L_0x0018
            android.content.Context r2 = r17.getContext()
            r7.R = r2
        L_0x0018:
            r12 = 0
            r7.B = r12
            boolean r2 = r17.P()
            r7.g((boolean) r2)
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x05bc
            boolean r2 = r18.isHideInputField()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x002f
            return
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.cr     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.containsKey(r3)     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.cr     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x05bd }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x004e
            return
        L_0x004e:
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.cr     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x05bd }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x05bd }
            goto L_0x0065
        L_0x005a:
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.cr     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x05bd }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x05bd }
        L_0x0065:
            java.lang.String r2 = r18.getType()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x05bd }
            r13 = 0
            if (r2 == 0) goto L_0x00c0
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()     // Catch:{ Exception -> 0x05bd }
            android.view.LayoutInflater r0 = r0.getLayoutInflater()     // Catch:{ Exception -> 0x05bd }
            int r1 = net.one97.paytm.recharge.R.layout.recharge_utility_group_filed_drop_down     // Catch:{ Exception -> 0x05bd }
            android.view.View r0 = r0.inflate(r1, r13)     // Catch:{ Exception -> 0x05bd }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x05bd }
            int r1 = net.one97.paytm.recharge.R.id.group_field_textview     // Catch:{ Exception -> 0x05bd }
            android.view.View r1 = r0.findViewById(r1)     // Catch:{ Exception -> 0x05bd }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.text_input_layout_utility     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2     // Catch:{ Exception -> 0x05bd }
            r7.cp = r2     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.group_field_separator     // Catch:{ Exception -> 0x05bd }
            r0.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            com.google.android.material.textfield.TextInputLayout r0 = r7.cp     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r18.getTitle()     // Catch:{ Exception -> 0x05bd }
            r0.setHint(r2)     // Catch:{ Exception -> 0x05bd }
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r7.O     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x00bf
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.containsKey(r2)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x00bf
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x05bd }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x05bd }
            r1.setText(r0)     // Catch:{ Exception -> 0x05bd }
        L_0x00bf:
            return
        L_0x00c0:
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()     // Catch:{ Exception -> 0x05bd }
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)     // Catch:{ Exception -> 0x05bd }
            int r3 = net.one97.paytm.recharge.R.layout.custom_auto_complete_text_view_cantainer     // Catch:{ Exception -> 0x05bd }
            android.view.View r14 = r2.inflate(r3, r9, r12)     // Catch:{ Exception -> 0x05bd }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x05bd }
            r14.setTag(r2)     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r7.f62825h     // Catch:{ Exception -> 0x05bd }
            r15 = 1
            if (r2 == 0) goto L_0x00de
            r14.setFocusable(r12)     // Catch:{ Exception -> 0x05bd }
            r14.setFocusableInTouchMode(r15)     // Catch:{ Exception -> 0x05bd }
        L_0x00de:
            int r2 = net.one97.paytm.recharge.R.id.extra_link_textview     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.edit_no     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            r5 = r2
            android.widget.AutoCompleteTextView r5 = (android.widget.AutoCompleteTextView) r5     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.text_input_layout_utility_amount     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            r4 = r2
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.message_input_field     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            r3 = r2
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = "InputField_Message_"
            java.lang.String r13 = java.lang.String.valueOf(r20)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r2.concat(r13)     // Catch:{ Exception -> 0x05bd }
            r3.setTag(r2)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.common.entity.CJRItem r2 = r7.U     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r2.getCategoryId()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x017e
            java.lang.String r13 = "99932"
            boolean r2 = r2.equals(r13)     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x017e
            java.lang.String r2 = r18.getMin()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05bd }
            if (r2 != 0) goto L_0x0185
            java.lang.String r2 = r18.getMax()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05bd }
            if (r2 != 0) goto L_0x0185
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05bd }
            r2.<init>()     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r18.getTitle()     // Catch:{ Exception -> 0x05bd }
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = " ("
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            int r13 = net.one97.paytm.recharge.R.string.rupee_symbol     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r7.getString(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r13.trim()     // Catch:{ Exception -> 0x05bd }
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r18.getMin()     // Catch:{ Exception -> 0x05bd }
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = " - "
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            int r13 = net.one97.paytm.recharge.R.string.rupee_symbol     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r7.getString(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r13.trim()     // Catch:{ Exception -> 0x05bd }
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r18.getMax()     // Catch:{ Exception -> 0x05bd }
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = ")"
            r2.append(r13)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05bd }
            r4.setHint(r2)     // Catch:{ Exception -> 0x05bd }
            goto L_0x0185
        L_0x017e:
            java.lang.String r2 = r18.getTitle()     // Catch:{ Exception -> 0x05bd }
            r4.setHint(r2)     // Catch:{ Exception -> 0x05bd }
        L_0x0185:
            java.lang.String r2 = r18.getSample_bill_url()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x019e
            int r2 = net.one97.paytm.recharge.R.id.sample_bill     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x05bd }
            r2.setVisibility(r12)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$19 r13 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$19     // Catch:{ Exception -> 0x05bd }
            r13.<init>(r8)     // Catch:{ Exception -> 0x05bd }
            r2.setOnClickListener(r13)     // Catch:{ Exception -> 0x05bd }
        L_0x019e:
            java.lang.String r2 = r18.getRight_button_url()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x01be
            int r2 = net.one97.paytm.recharge.R.id.sample_bill     // Catch:{ Exception -> 0x05bd }
            android.view.View r2 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x05bd }
            r2.setVisibility(r12)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = r18.getRight_button_label()     // Catch:{ Exception -> 0x05bd }
            r2.setText(r13)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$20 r13 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$20     // Catch:{ Exception -> 0x05bd }
            r13.<init>(r8)     // Catch:{ Exception -> 0x05bd }
            r2.setOnClickListener(r13)     // Catch:{ Exception -> 0x05bd }
        L_0x01be:
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()     // Catch:{ Exception -> 0x05bd }
            android.view.WindowManager r2 = r2.getWindowManager()     // Catch:{ Exception -> 0x05bd }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ Exception -> 0x05bd }
            android.graphics.Point r13 = new android.graphics.Point     // Catch:{ Exception -> 0x05bd }
            r13.<init>()     // Catch:{ Exception -> 0x05bd }
            r2.getSize(r13)     // Catch:{ Exception -> 0x05bd }
            int r2 = r13.x     // Catch:{ Exception -> 0x05bd }
            int r13 = r13.y     // Catch:{ Exception -> 0x05bd }
            r5.setDropDownWidth(r2)     // Catch:{ Exception -> 0x05bd }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r13 = "1"
            if (r2 == 0) goto L_0x0217
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r15 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.containsKey(r15)     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x0217
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r15 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r2 = r2.get(r15)     // Catch:{ Exception -> 0x05bd }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05bd }
            r5.setText(r2)     // Catch:{ Exception -> 0x05bd }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r7.O     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.containsKey(r1)     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x0217
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x0217
            r5.setEnabled(r12)     // Catch:{ Exception -> 0x05bd }
        L_0x0217:
            int r1 = net.one97.paytm.recharge.R.id.contact_picker     // Catch:{ Exception -> 0x05bd }
            android.view.View r1 = r14.findViewById(r1)     // Catch:{ Exception -> 0x05bd }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.fee_structure     // Catch:{ Exception -> 0x05bd }
            r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            int r2 = net.one97.paytm.recharge.R.id.number_sep_1     // Catch:{ Exception -> 0x05bd }
            android.view.View r15 = r14.findViewById(r2)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = "InputField_Separator_"
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r2.concat(r12)     // Catch:{ Exception -> 0x05bd }
            r15.setTag(r2)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r2 = r18.getShowPhoneBook()     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x0253
            java.lang.String r2 = r18.getShowPhoneBook()     // Catch:{ Exception -> 0x05bd }
            boolean r2 = r2.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x05bd }
            if (r2 == 0) goto L_0x0253
            r2 = 0
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$c r2 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$c     // Catch:{ Exception -> 0x05bd }
            r2.<init>()     // Catch:{ Exception -> 0x05bd }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x05bd }
        L_0x0253:
            android.view.View$OnClickListener r1 = r7.bB     // Catch:{ Exception -> 0x05bd }
            r5.setOnClickListener(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$21 r12 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$21     // Catch:{ Exception -> 0x05bd }
            r1 = r12
            r2 = r17
            r10 = r4
            r4 = r18
            r16 = r5
            r9 = r6
            r6 = r15
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x05bd }
            r2 = r16
            r2.setOnFocusChangeListener(r12)     // Catch:{ Exception -> 0x05bd }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r7.O     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x0283
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r7.O     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = r1.containsKey(r3)     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x0283
            boolean r1 = r7.aA     // Catch:{ Exception -> 0x05bd }
            if (r1 != 0) goto L_0x0283
            r2.requestFocus()     // Catch:{ Exception -> 0x05bd }
        L_0x0283:
            java.lang.String r1 = "InputField_"
            java.lang.String r3 = java.lang.String.valueOf(r20)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ Exception -> 0x05bd }
            r2.setTag(r1)     // Catch:{ Exception -> 0x05bd }
            r1 = 1
            r2.setFocusable(r1)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r18.getType()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x05bd }
            if (r1 != 0) goto L_0x02ab
            android.text.TextWatcher r1 = r7.cA     // Catch:{ Exception -> 0x05bd }
            r2.addTextChangedListener(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$23 r1 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$23     // Catch:{ Exception -> 0x05bd }
            r1.<init>(r8)     // Catch:{ Exception -> 0x05bd }
            r2.setOnTouchListener(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x02ab:
            java.lang.String r1 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = "recharge_number_2"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x05bd }
            r3 = 3
            java.lang.String r4 = "numeric"
            java.lang.String r5 = "CC_BILL_PAYMENT"
            if (r1 == 0) goto L_0x0305
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r7.Z     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()     // Catch:{ Exception -> 0x05bd }
            r6 = 0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.getCartVerifyType()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x05bd }
            if (r1 != 0) goto L_0x0305
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r7.Z     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.getCartVerifyType()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x0305
            r2.setLongClickable(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = r18.getKeyboardType()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x02f3
            goto L_0x02f4
        L_0x02f3:
            r3 = 1
        L_0x02f4:
            r2.setInputType(r3)     // Catch:{ Exception -> 0x05bd }
            android.text.TextWatcher r0 = r7.be     // Catch:{ Exception -> 0x05bd }
            r2.addTextChangedListener(r0)     // Catch:{ Exception -> 0x05bd }
            android.text.InputFilter[] r0 = r17.a()     // Catch:{ Exception -> 0x05bd }
            r2.setFilters(r0)     // Catch:{ Exception -> 0x05bd }
            goto L_0x053e
        L_0x0305:
            java.lang.String r1 = r18.getConfigKey()     // Catch:{ Exception -> 0x05bd }
            java.lang.String r6 = "recharge_number"
            boolean r1 = r1.equals(r6)     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x035a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r7.Z     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()     // Catch:{ Exception -> 0x05bd }
            r6 = 0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.getCartVerifyType()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x05bd }
            if (r1 != 0) goto L_0x035a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r7.Z     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2 r1 = r1.getLastUtilityProductList()     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityGroupFieldV2 r1 = r1.getGroupFieldV2(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.getCartVerifyType()     // Catch:{ Exception -> 0x05bd }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x05bd }
            if (r1 == 0) goto L_0x035a
            r2.setLongClickable(r6)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = r18.getKeyboardType()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0348
            goto L_0x0349
        L_0x0348:
            r3 = 1
        L_0x0349:
            r2.setInputType(r3)     // Catch:{ Exception -> 0x05bd }
            android.text.TextWatcher r0 = r7.be     // Catch:{ Exception -> 0x05bd }
            r2.addTextChangedListener(r0)     // Catch:{ Exception -> 0x05bd }
            android.text.InputFilter[] r0 = r17.a()     // Catch:{ Exception -> 0x05bd }
            r2.setFilters(r0)     // Catch:{ Exception -> 0x05bd }
            goto L_0x053e
        L_0x035a:
            java.lang.String r1 = r18.getType()     // Catch:{ Exception -> 0x05bd }
            java.lang.String r3 = "text"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x05bd }
            r3 = 2
            if (r1 == 0) goto L_0x0378
            boolean r0 = r18.getAlphanumeric()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0373
            r1 = 1
            r2.setInputType(r1)     // Catch:{ Exception -> 0x05bd }
            goto L_0x053e
        L_0x0373:
            r2.setInputType(r3)     // Catch:{ Exception -> 0x05bd }
            goto L_0x053e
        L_0x0378:
            java.lang.String r1 = r18.getType()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x053e
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x03c6
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            int r0 = r0.size()     // Catch:{ Exception -> 0x05bd }
            if (r0 <= 0) goto L_0x03c6
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x03c6
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x03c6
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = r0.getShowBrowsePlan()     // Catch:{ Exception -> 0x05bd }
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r4 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r4 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r4     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r1 = r4.getAttributes()     // Catch:{ Exception -> 0x05bd }
            boolean r12 = r1.isDynamicPlan()     // Catch:{ Exception -> 0x05bd }
            goto L_0x03c8
        L_0x03c6:
            r0 = 0
            r12 = 0
        L_0x03c8:
            if (r10 == 0) goto L_0x03dd
            int r1 = net.one97.paytm.recharge.R.string.utility_amount_hint_text     // Catch:{ Exception -> 0x05bd }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x05bd }
            java.lang.String r4 = r18.getTitle()     // Catch:{ Exception -> 0x05bd }
            r6 = 0
            r5[r6] = r4     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r7.getString(r1, r5)     // Catch:{ Exception -> 0x05bd }
            r10.setHint(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x03dd:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05bd }
            if (r1 != 0) goto L_0x0430
            boolean r0 = r13.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0430
            if (r12 != 0) goto L_0x0430
            int r0 = net.one97.paytm.recharge.R.id.browse_plan     // Catch:{ Exception -> 0x05bd }
            android.view.View r0 = r14.findViewById(r0)     // Catch:{ Exception -> 0x05bd }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x05bd }
            int r1 = net.one97.paytm.recharge.R.id.for_operator_text     // Catch:{ Exception -> 0x05bd }
            android.view.View r1 = r14.findViewById(r1)     // Catch:{ Exception -> 0x05bd }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x05bd }
            r4 = 0
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x05bd }
            int r5 = net.one97.paytm.recharge.R.string.browse_plans_txt     // Catch:{ Exception -> 0x05bd }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x05bd }
            r0.setText(r5)     // Catch:{ Exception -> 0x05bd }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x05bd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05bd }
            java.lang.String r6 = "of "
            r5.<init>(r6)     // Catch:{ Exception -> 0x05bd }
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r6 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r6     // Catch:{ Exception -> 0x05bd }
            java.lang.String r4 = r6.getDisplayName()     // Catch:{ Exception -> 0x05bd }
            r5.append(r4)     // Catch:{ Exception -> 0x05bd }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x05bd }
            r1.setText(r4)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$24 r1 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$24     // Catch:{ Exception -> 0x05bd }
            r1.<init>()     // Catch:{ Exception -> 0x05bd }
            r0.setOnClickListener(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x0430:
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.Z()     // Catch:{ Exception -> 0x05bd }
            r1 = 6
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05bd }
            if (r4 != 0) goto L_0x044b
            int r1 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0442 }
            goto L_0x044b
        L_0x0442:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = r4.getMessage()     // Catch:{ Exception -> 0x05bd }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x05bd }
        L_0x044b:
            net.one97.paytm.recharge.common.widget.e r0 = new net.one97.paytm.recharge.common.widget.e     // Catch:{ Exception -> 0x05bd }
            r0.<init>(r1)     // Catch:{ Exception -> 0x05bd }
            r1 = 1
            r0.f62154a = r1     // Catch:{ Exception -> 0x05bd }
            android.text.InputFilter[] r4 = new android.text.InputFilter[r1]     // Catch:{ Exception -> 0x05bd }
            r1 = 0
            r4[r1] = r0     // Catch:{ Exception -> 0x05bd }
            r2.setFilters(r4)     // Catch:{ Exception -> 0x05bd }
            android.text.TextWatcher r0 = r7.bd     // Catch:{ Exception -> 0x05bd }
            r2.addTextChangedListener(r0)     // Catch:{ Exception -> 0x05bd }
            r2.setInputType(r3)     // Catch:{ Exception -> 0x05bd }
            int r0 = net.one97.paytm.recharge.R.id.message_input_field     // Catch:{ Exception -> 0x05bd }
            android.view.View r0 = r14.findViewById(r0)     // Catch:{ Exception -> 0x05bd }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r18.getMessage()     // Catch:{ Exception -> 0x05bd }
            r7.a((com.paytm.utility.RoboTextView) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x05bd }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x05bd }
            r14.setTag(r0)     // Catch:{ Exception -> 0x05bd }
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0482
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            r1 = 8
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x0482:
            r7.o = r2     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.common.entity.CJRItem r0 = r7.U     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x04a1
            java.lang.String r0 = com.paytm.utility.e.z     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.common.entity.CJRItem r1 = r7.U     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r1.getCategoryId()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x04a1
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = "0123456789,"
            android.text.method.DigitsKeyListener r1 = android.text.method.DigitsKeyListener.getInstance(r1)     // Catch:{ Exception -> 0x05bd }
            r0.setKeyListener(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x04a1:
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x050d
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            int r0 = r0.size()     // Catch:{ Exception -> 0x05bd }
            if (r0 <= 0) goto L_0x050d
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x050d
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x050d
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.isShowBrowsePlan()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x050d
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.isDynamicPlan()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x050d
            r3 = 1
            r7.ax = r3     // Catch:{ Exception -> 0x05bd }
            r9.setVisibility(r1)     // Catch:{ Exception -> 0x05bd }
            int r0 = net.one97.paytm.recharge.R.string.browse_plans_txt     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ Exception -> 0x05bd }
            r9.setText(r0)     // Catch:{ Exception -> 0x05bd }
            android.view.View$OnClickListener r0 = r7.aH     // Catch:{ Exception -> 0x05bd }
            r9.setOnClickListener(r0)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r0 = r7.aw     // Catch:{ Exception -> 0x05bd }
            if (r0 != 0) goto L_0x050d
            java.util.HashMap<java.lang.Integer, net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions> r0 = r7.av     // Catch:{ Exception -> 0x05bd }
            if (r0 != 0) goto L_0x050d
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.G()     // Catch:{ Exception -> 0x05bd }
            r7.g((java.lang.String) r0)     // Catch:{ Exception -> 0x05bd }
        L_0x050d:
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$25 r1 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$25     // Catch:{ Exception -> 0x05bd }
            r1.<init>()     // Catch:{ Exception -> 0x05bd }
            r0.setOnTouchListener(r1)     // Catch:{ Exception -> 0x05bd }
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$26 r1 = new net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$26     // Catch:{ Exception -> 0x05bd }
            r1.<init>(r15)     // Catch:{ Exception -> 0x05bd }
            r0.setOnFocusChangeListener(r1)     // Catch:{ Exception -> 0x05bd }
            r17.H()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r18.ismReadOnly()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0538
            r1 = 0
            r7.co = r1     // Catch:{ Exception -> 0x05bd }
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            r0.setFocusable(r1)     // Catch:{ Exception -> 0x05bd }
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            r0.setLongClickable(r1)     // Catch:{ Exception -> 0x05bd }
            goto L_0x053b
        L_0x0538:
            r1 = 1
            r7.co = r1     // Catch:{ Exception -> 0x05bd }
        L_0x053b:
            r17.Z()     // Catch:{ Exception -> 0x05bd }
        L_0x053e:
            java.lang.String r0 = r18.getMatchWithKey()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05bd }
            if (r0 != 0) goto L_0x0558
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r7.cr     // Catch:{ Exception -> 0x05bd }
            java.lang.String r1 = r18.getMatchWithKey()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.containsKey(r1)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0558
            r1 = 0
            r2.setLongClickable(r1)     // Catch:{ Exception -> 0x05bd }
        L_0x0558:
            java.lang.String r0 = r18.getType()     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x056a
            r1 = r19
            r2 = 0
            r1.addView(r2)     // Catch:{ Exception -> 0x05bd }
            r2 = 0
            goto L_0x058a
        L_0x056a:
            r1 = r19
            int r0 = r19.getChildCount()     // Catch:{ Exception -> 0x05bd }
            r2 = r20
            if (r0 < r2) goto L_0x0578
            r1.addView(r14, r2)     // Catch:{ Exception -> 0x05bd }
            goto L_0x057b
        L_0x0578:
            r1.addView(r14)     // Catch:{ Exception -> 0x05bd }
        L_0x057b:
            boolean r0 = r7.ah     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x0586
            r17.V()     // Catch:{ Exception -> 0x05bd }
            r2 = 0
            r7.ah = r2     // Catch:{ Exception -> 0x05bd }
            goto L_0x058a
        L_0x0586:
            r2 = 0
            r3 = 1
            r7.ah = r3     // Catch:{ Exception -> 0x05bd }
        L_0x058a:
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x05bd }
            android.widget.LinearLayout r0 = r7.w     // Catch:{ Exception -> 0x05bd }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x05bd }
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x05bc
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            int r0 = r0.size()     // Catch:{ Exception -> 0x05bd }
            if (r0 <= 0) goto L_0x05bc
            java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2> r0 = r7.Y     // Catch:{ Exception -> 0x05bd }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x05bd }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2) r0     // Catch:{ Exception -> 0x05bd }
            boolean r0 = r0.isConvenienceFee()     // Catch:{ Exception -> 0x05bd }
            if (r0 == 0) goto L_0x05bc
            android.widget.AutoCompleteTextView r0 = r7.o     // Catch:{ Exception -> 0x05bd }
            int r0 = r0.getVisibility()     // Catch:{ Exception -> 0x05bd }
            if (r0 != 0) goto L_0x05bc
            boolean r0 = r7.ca     // Catch:{ Exception -> 0x05bd }
            if (r0 != 0) goto L_0x05bc
            r17.ac()     // Catch:{ Exception -> 0x05bd }
        L_0x05bc:
            return
        L_0x05bd:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2.b(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2, android.widget.LinearLayout, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(RoboTextView roboTextView, String str) {
        if (roboTextView != null) {
            if (str == null || TextUtils.isEmpty(str)) {
                roboTextView.setVisibility(8);
                return;
            }
            roboTextView.setText(str);
            roboTextView.setVisibility(0);
            net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                public final Object invoke() {
                    return FJRRechargeUtilityBaseV2.this.al();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x al() {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_service_type", this.ai);
        hashMap.put("recharge_utilities_message_type", "general");
        hashMap.put("recharge_utilities_display_type", "non_popup");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_message_displayed", getActivity());
        return null;
    }

    private void a(List<CJRUtilityInputFieldsV2> list, LinearLayout linearLayout) {
        List<CJRUtilityProductV2> list2;
        linearLayout.setVisibility(0);
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (!(getActivity() == null || (list2 = this.Y) == null || list2.size() <= 0 || this.Y.get(0).getAttributes() == null)) {
                    if ("0".equalsIgnoreCase(this.Y.get(0).getAttributes().getPrefetch())) {
                        b(list.get(i2), linearLayout, i2);
                    } else if ("1".equalsIgnoreCase(this.Y.get(0).getAttributes().getPrefetch()) && list.get(i2).getMandatory()) {
                        b(list.get(i2), linearLayout, i2);
                    }
                }
            }
        }
        this.O.clear();
    }

    /* access modifiers changed from: protected */
    public final void f(String str) {
        this.V = w();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
        a2.getFlowName().setActionType(ACTION_TYPE.PRODUCT_DETAIL_WITH_PID.name());
        this.V.a("fetch_product_detail_by_pid", str, a2);
    }

    private List<CJRUtilityCheckboxItem> a(ArrayList<CJRCartProduct> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        List<CJRUtilityProductV2> list = this.Y;
        if (!(list == null || list.size() <= 0 || this.Y.get(0).getAttributes() == null)) {
            if (("1".equalsIgnoreCase(this.Y.get(0).getAttributes().getFeeTypeFlow()) || "1".equalsIgnoreCase(this.Y.get(0).getAttributes().getCheckboxFlowType())) && arrayList.get(0).getServiceOptions().getActions() != null && arrayList.get(0).getServiceOptions().getActions().size() > 0 && arrayList.get(0).getServiceOptions().getActions().get(0).getUpdatedValues() != null && arrayList.get(0).getServiceOptions().getActions().get(0).getUpdatedValues().size() > 0) {
                for (CJRUpdatedValue next : arrayList.get(0).getServiceOptions().getActions().get(0).getUpdatedValues()) {
                    for (CJRUtilityProductV2 next2 : this.Y) {
                        if (next2 != null && !TextUtils.isEmpty(next2.getFilterName()) && !next2.getFilterName().equalsIgnoreCase("N/A")) {
                            if (a(next2, next.getFeeTypes()) || a(next2, next.getChallanType())) {
                                CJRUtilityCheckboxItem cJRUtilityCheckboxItem = new CJRUtilityCheckboxItem();
                                if (TextUtils.isEmpty(next.getLabel())) {
                                    cJRUtilityCheckboxItem.setName(next2.getDisplayName());
                                } else {
                                    cJRUtilityCheckboxItem.setName(next.getLabel());
                                }
                                String feeTypeVisibility = next.getFeeTypeVisibility();
                                if (TextUtils.isEmpty(feeTypeVisibility) || "none".equalsIgnoreCase(feeTypeVisibility)) {
                                    feeTypeVisibility = next2.getAttributes().getFeeTypeVisibility();
                                }
                                cJRUtilityCheckboxItem.setId(next2.getId());
                                cJRUtilityCheckboxItem.setPrice(String.valueOf(next.getBillAmount()));
                                cJRUtilityCheckboxItem.setInputMode(feeTypeVisibility);
                                cJRUtilityCheckboxItem.setPriceEditable(next.getBillamountEditable());
                                cJRUtilityCheckboxItem.setDisplayValues(next.getDisplayValues());
                                if (next2.getAttributes() != null) {
                                    cJRUtilityCheckboxItem.setShowDisplayValues(next2.getAttributes().isShowDisplayValuesEnabled());
                                }
                                HashMap hashMap = new HashMap();
                                if (this.Z.getLastUtilityProductList() != null && !TextUtils.isEmpty(this.Z.getLastUtilityProductList().getGroupKeyWithTypeCheckbox())) {
                                    hashMap.put(this.Z.getLastUtilityProductList().getGroupKeyWithTypeCheckbox(), next2.getFilterName());
                                }
                                if (!TextUtils.isEmpty(next2.getFeeTypeKey())) {
                                    hashMap.put("fee_type_key", next2.getFeeTypeKey());
                                }
                                if (next.getDisplayValues() != null) {
                                    for (CJRDisplayValues next3 : next.getDisplayValues()) {
                                        if (!TextUtils.isEmpty(next3.getLabel()) && !TextUtils.isEmpty(next3.getValue())) {
                                            hashMap.put(next3.getLabel(), next3.getValue());
                                        }
                                    }
                                }
                                cJRUtilityCheckboxItem.setMetaData(hashMap);
                                arrayList2.add(cJRUtilityCheckboxItem);
                            }
                        }
                    }
                }
            } else {
                Iterator<CJRCartProduct> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRCartProduct next4 = it2.next();
                    for (CJRUtilityProductV2 next5 : this.Y) {
                        if (next5 != null && !TextUtils.isEmpty(next5.getFilterName()) && !next5.getFilterName().equalsIgnoreCase("N/A") && next5.getId() == Long.parseLong(next4.getProductId())) {
                            CJRUtilityCheckboxItem cJRUtilityCheckboxItem2 = new CJRUtilityCheckboxItem();
                            cJRUtilityCheckboxItem2.setName(next5.getDisplayName());
                            cJRUtilityCheckboxItem2.setId(next5.getId());
                            cJRUtilityCheckboxItem2.setPrice(next4.getServiceOptions().getActions().get(0).getBillAmount());
                            cJRUtilityCheckboxItem2.setInputMode(next5.getAttributes().getFeeTypeVisibility());
                            cJRUtilityCheckboxItem2.setPriceEditable(next4.getServiceOptions().getActions().get(0).isBillAmountEditable());
                            cJRUtilityCheckboxItem2.setDisplayValues(next4.getServiceOptions().getActions().get(0).getDisplayValues());
                            if (next5.getAttributes() != null) {
                                cJRUtilityCheckboxItem2.setShowDisplayValues(next5.getAttributes().isShowDisplayValuesEnabled());
                            }
                            HashMap hashMap2 = new HashMap();
                            CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
                            if (cJRUtilityProductListV2 != null && !TextUtils.isEmpty(cJRUtilityProductListV2.getLastUtilityProductList().getGroupKeyWithTypeCheckbox())) {
                                hashMap2.put(this.Z.getLastUtilityProductList().getGroupKeyWithTypeCheckbox(), next5.getFilterName());
                            }
                            if (!TextUtils.isEmpty(next5.getFeeTypeKey())) {
                                hashMap2.put("fee_type_key", next5.getFeeTypeKey());
                            }
                            if (next4.getServiceOptions().getActions().get(0).getDisplayValues() != null) {
                                Iterator<CJRDisplayValues> it3 = next4.getServiceOptions().getActions().get(0).getDisplayValues().iterator();
                                while (it3.hasNext()) {
                                    CJRDisplayValues next6 = it3.next();
                                    if (!TextUtils.isEmpty(next6.getLabel()) && !TextUtils.isEmpty(next6.getValue())) {
                                        hashMap2.put(next6.getLabel(), next6.getValue());
                                    }
                                }
                            }
                            cJRUtilityCheckboxItem2.setMetaData(hashMap2);
                            arrayList2.add(cJRUtilityCheckboxItem2);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public void y() {
        AutoCompleteTextView autoCompleteTextView = this.o;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setVisibility(8);
        }
        this.bR = null;
        this.ca = false;
        this.cb = false;
        TextView textView = this.v;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.bK = null;
        this.o = null;
        this.cv = null;
        List<CJRUtilityProductV2> list = this.Y;
        if (list != null) {
            list.clear();
        }
        Map<String, Boolean> map = this.cr;
        if (map != null) {
            map.clear();
        }
        List<CJRUtilityCheckboxItem> list2 = this.bF;
        if (list2 != null) {
            list2.clear();
        }
        if (this.C != null) {
            this.C = null;
        }
        ArrayList<CJRDisplayValues> arrayList = this.bH;
        if (arrayList != null && arrayList.size() > 0) {
            this.bH.clear();
        }
    }

    private static boolean a(CJRUtilityProductV2 cJRUtilityProductV2, String str) {
        if (cJRUtilityProductV2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(cJRUtilityProductV2.getFeeTypeKey())) {
            if (cJRUtilityProductV2.getFilterName().equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        } else if (cJRUtilityProductV2.getFeeTypeKey().equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }

    private int U() {
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
        if (cJRUtilityProductListV2 == null || cJRUtilityProductListV2.getLastUtilityProductList().getCurrentGroupList() == null) {
            return -1;
        }
        List<String> currentGroupList = this.Z.getLastUtilityProductList().getCurrentGroupList();
        for (int i2 = 0; i2 < currentGroupList.size(); i2++) {
            if (this.Z.getLastUtilityProductList().getGroupFieldV2(i2) != null && this.Z.getLastUtilityProductList().getGroupFieldV2(i2).getType() != null && this.Z.getLastUtilityProductList().getGroupFieldV2(i2).getType().equalsIgnoreCase("checkbox")) {
                return i2;
            }
        }
        return -1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        CJRRechargeUtilities.INSTANCE.dropBreadCrumb(this.bD, "");
        ((AJRRechargeUtilityActivity) getActivity()).getSupportActionBar().a((CharSequence) this.U.getName());
        return viewGroup;
    }

    /* access modifiers changed from: protected */
    public final void a(CJRUtilityAlertV2 cJRUtilityAlertV2) {
        if (ax.a(this.R.getApplicationContext()).b(this.af, false, true) || cJRUtilityAlertV2.getHeading() == null || getActivity() == null) {
            i(true);
        } else {
            e.a(true, cJRUtilityAlertV2, this.af).show(getChildFragmentManager(), e.f61160a);
        }
    }

    private void i(boolean z2) {
        TextView textView = this.az;
        if (textView == null || this.an != null) {
            List<CJRUtilityProductV2> list = this.Y;
            if (list == null || list.get(0) == null || this.Y.get(0).getInputFields() == null || this.Y.get(0).getInputFields().get(0) == null || this.Y.get(0).getInputFields().get(0).getConfigKey() == null || !this.Y.get(0).getInputFields().get(0).getConfigKey().equals("recharge_number") || !this.Y.get(0).getInputFields().get(0).getTitle().equalsIgnoreCase("Credit Card Number")) {
                a(v(), z2);
            } else {
                a(v(), z2, this.an);
            }
        } else {
            textView.performClick();
        }
    }

    private void V() {
        String str = this.bN;
        if (str != null) {
            String[] split = !TextUtils.isEmpty(str) ? this.bN.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) : null;
            this.ag = new ArrayList<>();
            if (split != null) {
                this.ag.addAll(Arrays.asList(split));
            }
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.add_amount_btn_container, (ViewGroup) null);
            inflate.setTag(Boolean.TRUE);
            this.A.addView(inflate);
            net.one97.paytm.recharge.common.a.a aVar = new net.one97.paytm.recharge.common.a.a(getContext(), this.ag, this);
            RecyclerView recyclerView = (RecyclerView) this.A.findViewById(R.id.add_amount_grid);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            recyclerView.setAdapter(aVar);
            this.bN = null;
        }
    }

    public final void a(String str) {
        this.o.setText(str);
        c("amount_capsule_selected", str);
    }

    private String W() {
        String b2;
        int id = this.Z.getId();
        if (getActivity() == null || (b2 = ax.a(getActivity().getApplicationContext()).b(String.valueOf(id), "", true)) == "") {
            return null;
        }
        return b2;
    }

    private void j(String str) {
        if (getActivity() != null) {
            int id = this.Z.getId();
            com.paytm.b.a.a a2 = ax.a(getActivity().getApplicationContext());
            String b2 = a2.b(String.valueOf(id), "", true);
            if (b2 == "" || !b2.equalsIgnoreCase(str)) {
                a2.a(String.valueOf(id), str, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String z() {
        String str = "";
        for (CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z; cJRUtilityProductListV2 != null; cJRUtilityProductListV2 = cJRUtilityProductListV2.getNextLevelProductList()) {
            ArrayList arrayList = new ArrayList(cJRUtilityProductListV2.getSelectedGroupItemHashMap().values());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (str.equals("")) {
                    str = ((CJRUtilitySelectedGroupItemV2) arrayList.get(i2)).getItemDisplayName();
                } else {
                    str = str + "/" + ((CJRUtilitySelectedGroupItemV2) arrayList.get(i2)).getItemDisplayName();
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String A() {
        List<CJRUtilityProductV2> list = this.Y;
        if (list == null || list.size() <= 0) {
            return "";
        }
        String str = "";
        for (int i2 = 0; i2 < this.Y.get(0).getInputFields().size(); i2++) {
            try {
                if (!this.Y.get(0).getInputFields().get(i2).getType().equals("amount")) {
                    if (str.equals("")) {
                        str = this.aa.get(this.Y.get(0).getInputFields().get(i2).getTitle()).toString();
                    } else {
                        str = str + "/" + this.aa.get(this.Y.get(0).getInputFields().get(i2).getTitle());
                    }
                }
            } catch (JSONException e2) {
                q.d(e2.getMessage());
            }
        }
        return str;
    }

    private CJRUtilityPrefetchV2 X() {
        CJRUtilityProductListV2 lastUtilityProductList;
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
        CJRUtilityPrefetchV2 cJRUtilityPrefetchV2 = null;
        if (cJRUtilityProductListV2 == null || (lastUtilityProductList = cJRUtilityProductListV2.getLastUtilityProductList()) == null) {
            return null;
        }
        List<CJRUtilityProductV2> list = this.Y;
        if (!(list == null || list.size() <= 0 || this.Y.get(0) == null || this.Y.get(0).getAttributes().getPrefetch() == null || this.Y.get(0).getAttributes().getPrefetch().equalsIgnoreCase("") || lastUtilityProductList == null || lastUtilityProductList.getButtonObj() == null || lastUtilityProductList.getButtonObj().getPrefetchMap() == null || !lastUtilityProductList.getButtonObj().getPrefetchMap().containsKey(this.Y.get(0).getAttributes().getPrefetch()))) {
            cJRUtilityPrefetchV2 = lastUtilityProductList.getButtonObj().getPrefetchMap().get(this.Y.get(0).getAttributes().getPrefetch());
        }
        if (cJRUtilityPrefetchV2 != null || lastUtilityProductList == null || lastUtilityProductList.getButtonObj() == null || lastUtilityProductList.getButtonObj().getPrefetchMap() == null) {
            return cJRUtilityPrefetchV2;
        }
        if (lastUtilityProductList.getButtonObj().getPrefetchMap().containsKey("0")) {
            return lastUtilityProductList.getButtonObj().getPrefetchMap().get("0");
        }
        return lastUtilityProductList.getButtonObj().getPrefetchMap().containsKey("1") ? lastUtilityProductList.getButtonObj().getPrefetchMap().get("1") : cJRUtilityPrefetchV2;
    }

    private String Y() {
        if (this.Y.size() <= 0) {
            return "";
        }
        if (this.Y.get(0).getInputFields() == null || this.Y.get(0).getInputFields().size() <= 0) {
            return "";
        }
        List<CJRUtilityInputFieldsV2> inputFields = this.Y.get(0).getInputFields();
        String str = "";
        for (int i2 = 0; i2 < inputFields.size(); i2++) {
            View findViewWithTag = this.A.findViewWithTag("InputField_".concat(String.valueOf(i2)));
            if (findViewWithTag != null && (findViewWithTag instanceof AutoCompleteTextView)) {
                String obj = ((AutoCompleteTextView) findViewWithTag).getText().toString();
                if (this.o != null && !obj.equalsIgnoreCase(D())) {
                    if (str.equals("")) {
                        str = obj;
                    } else {
                        str = str + "/" + obj;
                    }
                }
            }
        }
        return str;
    }

    private Map<String, Object> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_input_field_values", A());
        hashMap.put("recharge_utilities_group_field_values", z());
        hashMap.put("recharge_utilities_amount", str);
        hashMap.put("recharge_utilities_service_type", str2);
        hashMap.put("recharge_utilities_business_sub_vertical", this.U.getName());
        if (P()) {
            hashMap.put("recharge_utilities_ff_state", "checked");
        } else {
            hashMap.put("recharge_utilities_ff_state", "unchecked");
        }
        return hashMap;
    }

    private void Z() {
        List<CJRUtilityProductV2> list;
        if (this.o != null && (list = this.Y) != null && list.size() > 0 && this.Y.get(0).getAttributes() != null && !TextUtils.isEmpty(this.Y.get(0).getAttributes().getAmount()) && Integer.parseInt(this.Y.get(0).getAttributes().getAmount()) > 0) {
            this.o.setText(this.Y.get(0).getAttributes().getAmount());
            this.o.setEnabled(false);
        }
    }

    private void k(String str) {
        if (!this.at) {
            b bVar = this.aI;
            if (bVar != null) {
                bVar.a(str);
            }
            this.bP = true;
        }
    }

    private void aa() {
        b bVar = this.aI;
        if (bVar != null) {
            bVar.a((String) null);
        }
        this.bP = false;
        this.aL = null;
    }

    private void c(CJRUtilityProductListV2 cJRUtilityProductListV2) {
        Spanned spanned;
        ab();
        if (cJRUtilityProductListV2 == null || TextUtils.isEmpty(cJRUtilityProductListV2.getDisclaimer())) {
            TextView textView = this.l;
            if (textView != null && this.m != null) {
                textView.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.l;
        if (!(textView2 == null || this.m == null)) {
            textView2.setText(cJRUtilityProductListV2.getDisclaimer());
            String charSequence = this.l.getText().toString();
            if (charSequence.contains("g.co/playtermsin")) {
                int indexOf = charSequence.indexOf("g.co/playtermsin");
                this.l.setMovementMethod(LinkMovementMethod.getInstance());
                Spannable spannable = (Spannable) this.l.getText();
                int i2 = 16 + indexOf;
                spannable.setSpan(new ExpandedURLSpanNoUnderline("g.co/playtermsin"), indexOf, i2, 33);
                if (getContext() != null) {
                    spannable.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getContext(), R.color.paytm_blue)), indexOf, i2, 33);
                }
            }
            this.l.setMaxLines(2);
            this.l.setVisibility(0);
            this.l.postDelayed(new Runnable() {
                public final void run() {
                    if (FJRRechargeUtilityBaseV2.this.l.getLineCount() > 2) {
                        FJRRechargeUtilityBaseV2.this.m.setVisibility(0);
                        FJRRechargeUtilityBaseV2.this.m.setPaintFlags(8 | FJRRechargeUtilityBaseV2.this.m.getPaintFlags());
                        return;
                    }
                    FJRRechargeUtilityBaseV2.this.m.setVisibility(8);
                }
            }, 300);
        }
        if (!TextUtils.isEmpty(cJRUtilityProductListV2.getDisclaimer_html())) {
            if (Build.VERSION.SDK_INT >= 24) {
                spanned = Html.fromHtml(cJRUtilityProductListV2.getDisclaimer_html(), 319);
            } else {
                spanned = Html.fromHtml(cJRUtilityProductListV2.getDisclaimer_html());
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class);
            if (!(uRLSpanArr == null || getActivity() == null || getActivity().isFinishing())) {
                for (URLSpan a2 : uRLSpanArr) {
                    ba.a((Activity) getActivity(), spannableStringBuilder, a2);
                }
            }
            this.l.setText(spannableStringBuilder);
            this.l.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void ab() {
        CJRItem cJRItem;
        if (!this.bS && (cJRItem = this.U) != null && cJRItem.getCategoryId() != null && this.U.getCategoryId().equalsIgnoreCase("99932")) {
            this.R = getActivity();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String aX2 = net.one97.paytm.recharge.di.helper.c.aX();
            new JSONObject();
            new HashMap().put("Content-Type", "application/json");
            if (com.paytm.utility.b.c(this.R)) {
                this.R.getApplicationContext();
                net.one97.paytm.recharge.common.f.d.a();
                BannerData bannerData = new BannerData();
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("google_play_banner", aX2, (ai) this, (IJRPaytmDataModel) bannerData, (Map<String, String>) null, (Map<String, String>) null, (String) null, (Object) net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.GOOGLE_PLAY_BANNER, ERROR_TYPE.UNDEFINED)));
                return;
            }
            a.C0940a aVar = this.cx;
            if (aVar != null) {
                aVar.o();
            }
        }
    }

    private static boolean d(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        return cJRUtilityVariantV2 == null || cJRUtilityVariantV2.getAttributes() == null || cJRUtilityVariantV2.getAttributes().getGroupConfigKeyList() == null || cJRUtilityVariantV2.getAttributes().getGroupConfigKeyList().length <= 0;
    }

    private void ac() {
        LinearLayout linearLayout = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.recharge_utility_group_filed_drop_down, (ViewGroup) null);
        this.az = (TextView) linearLayout.findViewById(R.id.group_field_textview);
        this.cp = (TextInputLayout) linearLayout.findViewById(R.id.text_input_layout_utility);
        this.cp.setHint(getString(R.string.select_payment_mode));
        this.aB = (LinearLayout) linearLayout.findViewById(R.id.convenience_fee_lyt);
        this.az.setOnClickListener(this.cC);
        linearLayout.setTag(Boolean.TRUE);
        this.A.addView(linearLayout);
    }

    /* access modifiers changed from: private */
    public boolean f(CJRRechargeCart cJRRechargeCart) {
        List<CJRUtilityProductV2> list = this.Y;
        if (list == null || list.size() <= 0 || this.ca || !this.Y.get(0).isConvenienceFee() || cJRRechargeCart == null || cJRRechargeCart.getCart() == null || !TextUtils.isEmpty(cJRRechargeCart.getCart().getPaymentMethod()) || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0 || cJRRechargeCart.getCart().getCartItems().get(0) == null || cJRRechargeCart.getCart().getCartItems().get(0).getConvenienceFeeMap() == null || cJRRechargeCart.getCart().getCartItems().get(0).getConvenienceFeeMap().size() <= 0) {
            return false;
        }
        return true;
    }

    private void g(CJRRechargeCart cJRRechargeCart) {
        r();
        this.bL = cJRRechargeCart;
        HashMap<String, String> convenienceFeeMap = cJRRechargeCart.getCart().getCartItems().get(0).getConvenienceFeeMap();
        if (cJRRechargeCart.getCart().getCartItems().size() > 1) {
            convenienceFeeMap = new HashMap<>(cJRRechargeCart.getCart().getCartItems().get(0).getConvenienceFeeMap());
            for (int i2 = 1; i2 < cJRRechargeCart.getCart().getCartItems().size(); i2++) {
                if (!(cJRRechargeCart.getCart().getCartItems().get(i2) == null || cJRRechargeCart.getCart().getCartItems().get(i2).getConvenienceFeeMap() == null)) {
                    ArrayList arrayList = new ArrayList(cJRRechargeCart.getCart().getCartItems().get(i2).getConvenienceFeeMap().keySet());
                    ArrayList arrayList2 = new ArrayList(cJRRechargeCart.getCart().getCartItems().get(i2).getConvenienceFeeMap().values());
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (convenienceFeeMap.containsKey(arrayList.get(i3))) {
                            double parseDouble = Double.parseDouble(convenienceFeeMap.get(arrayList.get(i3))) + Double.parseDouble((String) arrayList2.get(i3));
                            convenienceFeeMap.remove(arrayList.get(i3));
                            convenienceFeeMap.put(arrayList.get(i3), String.valueOf(parseDouble));
                        }
                    }
                    if (convenienceFeeMap.size() > arrayList.size()) {
                        ArrayList arrayList3 = new ArrayList(convenienceFeeMap.keySet());
                        for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                            if (!arrayList.contains(arrayList3.get(i4))) {
                                convenienceFeeMap.remove(arrayList3.get(i4));
                            }
                        }
                    }
                }
            }
        }
        Intent intent = new Intent(getActivity(), AJRPaymentModeListActivity.class);
        ArrayList arrayList4 = new ArrayList();
        String charSequence = this.cp.getHint().toString();
        for (String next : this.Y.get(0).getPayTypeSupported().keySet()) {
            if (this.Y.get(0).getPayTypeSupported().get(next).intValue() == 1) {
                arrayList4.add(next.toLowerCase());
            }
        }
        intent.putExtra("payment_mode_list", arrayList4);
        intent.putExtra("title", charSequence);
        intent.putExtra("convenience_fee_map", convenienceFeeMap);
        getActivity().startActivityForResult(intent, 604);
    }

    public final void a(CJRCashWallet cJRCashWallet) {
        r();
        if (cJRCashWallet != null && cJRCashWallet.getResponse() != null && this.o != null && !TextUtils.isEmpty(D()) && this.ck != null) {
            if (cJRCashWallet.getResponse().getAmount() >= Double.parseDouble(D()) + Double.parseDouble(this.ck.getStringExtra("convenience_fee_selected"))) {
                a(this.ck);
                return;
            }
            az azVar = az.f61525a;
            az.a(getActivity(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, getResources().getString(R.string.insufficient_paytm_wallet_balance_error_title), getString(R.string.insufficient_wallet_balance_convenience_fee_error_message));
        }
    }

    public final void b(CJRCashWallet cJRCashWallet) {
        if (cJRCashWallet != null && cJRCashWallet.getResponse() != null) {
            int amount = (int) cJRCashWallet.getResponse().getAmount();
            int i2 = 0;
            try {
                i2 = (int) Float.parseFloat(this.bK.getCart().getFinalPrice());
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
            if (!P() || i2 > amount) {
                this.aJ.b();
                return;
            }
            az azVar = az.f61525a;
            az.a(this.bK);
            a((CJRRechargePayment) null);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(CJRFrequentOrder cJRFrequentOrder) {
        if (cJRFrequentOrder != null) {
            this.O.put(CLPConstants.PRODUCT_ID, cJRFrequentOrder.getProductID());
            this.O.putAll(cJRFrequentOrder.getFrequentOrderProduct().getAttributes());
            this.O.putAll(cJRFrequentOrder.getConfiguration());
        }
        try {
            if (cJRFrequentOrder.getFrequentOrderProduct() != null && !TextUtils.isEmpty(cJRFrequentOrder.getFrequentOrderProduct().getFrequentOrderBrand())) {
                this.O.put(StringSet.operator, cJRFrequentOrder.getFrequentOrderProduct().getFrequentOrderBrand());
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
        Q();
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z;
        if (cJRUtilityProductListV2 != null) {
            cJRUtilityProductListV2.setNextLevelProductList((CJRUtilityProductListV2) null);
            this.Z.setSelectedGroupItemHashMap(new HashMap());
            CJRUtilityProductListV2 cJRUtilityProductListV22 = this.Z;
            this.Z = null;
            if (cJRFrequentOrder.getProductAttributes() == null || !"merchant_loan_account".equalsIgnoreCase(cJRFrequentOrder.getProductAttributes().get("merchant_loan_account"))) {
                a(cJRUtilityProductListV22);
            } else {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                String bs2 = net.one97.paytm.recharge.di.helper.c.bs();
                this.O.put(CLPConstants.PRODUCT_ID, bs2);
                f(bs2);
            }
        } else {
            a((String) null, true, false);
        }
        NestedScrollView nestedScrollView = this.f62820c;
        if (nestedScrollView != null) {
            nestedScrollView.a(33);
        }
    }

    /* access modifiers changed from: private */
    public void ad() {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return FJRRechargeUtilityBaseV2.this.ak();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x ak() {
        HashMap hashMap = new HashMap();
        if (this.o != null) {
            hashMap.put("recharge_utilities_amount", D());
        }
        hashMap.put("recharge_utilities_group_field_values", z());
        hashMap.put("recharge_utilities_input_field_values", Y());
        hashMap.put("recharge_utilities_service_type", this.ai);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.U, (Map<String, Object>) hashMap, "recharge_utilities_recent_selected_inline", getActivity());
        return null;
    }

    private void ae() {
        if (this.aa == null) {
            this.aa = new JSONObject();
        }
        for (CJRUtilityProductListV2 cJRUtilityProductListV2 = this.Z; cJRUtilityProductListV2 != null; cJRUtilityProductListV2 = cJRUtilityProductListV2.getNextLevelProductList()) {
            ArrayList arrayList = new ArrayList(cJRUtilityProductListV2.getSelectedGroupItemHashMap().values());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    this.aa.put(((CJRUtilitySelectedGroupItemV2) arrayList.get(i2)).getGroupKey(), ((CJRUtilitySelectedGroupItemV2) arrayList.get(i2)).getItemDisplayName());
                } catch (JSONException e2) {
                    q.d(e2.getMessage());
                }
            }
        }
    }

    private CJRCartProduct l(String str) {
        CJRRechargeCart cJRRechargeCart;
        if (TextUtils.isEmpty(str) || (cJRRechargeCart = this.bK) == null || cJRRechargeCart.getCart() == null || this.bK.getCart().getCartItems() == null) {
            return null;
        }
        Iterator<CJRCartProduct> it2 = this.bK.getCart().getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next != null && str.equalsIgnoreCase(next.getProductId())) {
                return next;
            }
        }
        return null;
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        String str2;
        String str3;
        Object metaDataResponse;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        Object obj2 = obj;
        if (getActivity() == null || !getActivity().isFinishing()) {
            com.paytm.utility.b.j();
            if (iJRPaytmDataModel2 instanceof CJRRechargeCart) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel2;
                ACTION_TYPE action_type = ACTION_TYPE.UNDEFINED;
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                    if (cJRRechargeErrorModel.getFlowName() != null) {
                        action_type = ACTION_TYPE.Companion.getActionType(cJRRechargeErrorModel.getFlowName().getActionType(), action_type);
                    }
                }
                if (cJRRechargeCart.getCartStatus().getResult().equalsIgnoreCase("SUCCESS") && !a(cJRRechargeCart, action_type)) {
                    this.bK = cJRRechargeCart;
                    this.ca = az.c(getContext(), this.U.getCategoryId(), cJRRechargeCart);
                    this.cb = az.a(getContext(), this.U.getCategoryId(), cJRRechargeCart);
                    if (this.aR) {
                        this.aR = false;
                    }
                    if (this.ci) {
                        this.ci = false;
                    }
                    e(cJRRechargeCart);
                    CJRCart cart = cJRRechargeCart.getCart();
                    if (cart != null && cart.getCartItems() != null && cart.getCartItems().get(0) != null && cart.getCartItems().get(0).getPromoText() != null) {
                        cart.getCartItems().get(0).getPromoText().trim().length();
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRRechargePayment) {
                this.bs = false;
                d(false);
                this.bM = (CJRRechargePayment) iJRPaytmDataModel2;
                r();
                if (this.bM.getStatus() == null || !this.bM.getStatus().equalsIgnoreCase("SUCCESS")) {
                    r();
                    CJRRechargePayment cJRRechargePayment = this.bM;
                    if (cJRRechargePayment == null || !(cJRRechargePayment.getCode() == 401 || this.bM.getCode() == 410 || this.bM.getCode() == 403)) {
                        CJRRechargePayment cJRRechargePayment2 = this.bM;
                        if (cJRRechargePayment2 != null && cJRRechargePayment2.getError() != null) {
                            az azVar = az.f61525a;
                            az.a(getActivity(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, this.bM.getError().getTitle(), this.bM.getError().getMessage());
                            return;
                        }
                        return;
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                    if (!TextUtils.isEmpty(net.one97.paytm.recharge.di.helper.c.a((JSONObject) null))) {
                        net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                        networkCustomError.setUrl(net.one97.paytm.recharge.di.helper.c.a((JSONObject) null));
                        if (this.bM.getError() != null && !TextUtils.isEmpty(this.bM.getError().getMessage())) {
                            networkCustomError.setAlertMessage(this.bM.getError().getMessage());
                        }
                    }
                    CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(getActivity(), (String) null, (Bundle) null, networkCustomError);
                    return;
                }
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                    public final Object invoke() {
                        return FJRRechargeUtilityBaseV2.this.aj();
                    }
                });
                if (ab.a(this.bM)) {
                    ba.a((Context) getActivity(), this.bM, (FetchPayOptionsListener) this);
                    return;
                }
                r();
                a(this.bM);
            } else if (iJRPaytmDataModel2 instanceof CJRPGTokenList) {
                String pgToken = CJRRechargeUtilities.INSTANCE.getPgToken((CJRPGTokenList) iJRPaytmDataModel2);
                "wallet Sso Token ::".concat(String.valueOf(pgToken));
                com.paytm.utility.b.j();
                if (TextUtils.isEmpty(pgToken)) {
                    r();
                    CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(getActivity(), (String) null, (Bundle) null, new NetworkCustomError());
                } else if (!this.bs) {
                    CJRCart cart2 = this.bK.getCart();
                    CJRCartProduct cJRCartProduct = this.bK.getCart().getCartItems().get(0);
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    if (a2.getFlowName() != null) {
                        a2.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
                        a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    this.ce = new ArrayList<>();
                    Iterator<CJRCartProduct> it2 = this.bK.getCart().getCartItems().iterator();
                    while (it2.hasNext()) {
                        CJRCartProduct next = it2.next();
                        if (!cJRCartProduct.getVerticalLabel().equalsIgnoreCase("recharge")) {
                            String verticalLabel = cJRCartProduct.getVerticalLabel();
                            getActivity();
                            ba.f(verticalLabel);
                        }
                        CJRSelectedRecharge cJRSelectedRecharge = new CJRSelectedRecharge();
                        cJRSelectedRecharge.setProductId(next.getProductId());
                        cJRSelectedRecharge.setProductPrice(next.getDiscountedPrice());
                        this.cf = cJRSelectedRecharge;
                        cJRSelectedRecharge.setConfigList(cJRCartProduct.getConfigurationList());
                        this.ce.add(cJRSelectedRecharge);
                    }
                    try {
                        if (this.ce != null && this.ce.size() > 0) {
                            for (int i2 = 0; i2 < this.ce.size(); i2++) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(CLPConstants.PRODUCT_ID, this.ce.get(i2).getProductId());
                                jSONObject2.put("qty", 1);
                                Map<String, String> configList = this.ce.get(i2).getConfigList();
                                JSONObject jSONObject3 = new JSONObject();
                                Set<String> keySet = configList.keySet();
                                if (keySet != null) {
                                    for (String next2 : keySet) {
                                        jSONObject3.put(next2, configList.get(next2));
                                    }
                                }
                                if (!this.cf.equals(this.ce.get(i2))) {
                                    jSONObject3.put("upsell", 1);
                                }
                                CJRCartProduct l2 = l(this.ce.get(i2).getProductId());
                                if (!(l2 == null || (metaDataResponse = l2.getMetaDataResponse()) == null)) {
                                    String b2 = new f().b(metaDataResponse);
                                    if (!TextUtils.isEmpty(b2)) {
                                        jSONObject2.put("meta_data", new JSONObject(b2));
                                    }
                                }
                                jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("cart_items", jSONArray);
                        if (!TextUtils.isEmpty(this.an)) {
                            jSONObject.put("payment_method", this.an);
                        }
                        if (a2.getFlowName() != null) {
                            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            a2.getFlowName().setRequestBody(net.one97.paytm.recharge.widgets.c.d.a(jSONObject));
                        }
                    } catch (Exception e2) {
                        d(false);
                        q.d(e2.getMessage());
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("wallet_token", pgToken);
                    hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getActivity()));
                    net.one97.paytm.f.b.a().c();
                    net.one97.paytm.f.b.a().a(this.R, (String) null, (String) null, false, (String) null, com.paytm.utility.b.s((Context) getActivity()), com.paytm.utility.b.t((Context) getActivity()));
                    String d2 = net.one97.paytm.f.b.a().d();
                    if (!TextUtils.isEmpty(d2)) {
                        hashMap.put("risk_extended_info", d2);
                    }
                    net.one97.paytm.f.b.a().c();
                    net.one97.paytm.recharge.di.helper.c cVar3 = net.one97.paytm.recharge.di.helper.c.f62654a;
                    String a3 = net.one97.paytm.recharge.di.helper.c.a(jSONObject);
                    if (URLUtil.isValidUrl(a3)) {
                        String s2 = com.paytm.utility.b.s(getActivity(), a3);
                        String k2 = com.paytm.utility.b.k();
                        if (Uri.parse(s2).getQuery() != null) {
                            str2 = s2 + "&client_id=" + k2;
                        } else {
                            str2 = s2 + "?client_id=" + k2;
                        }
                        if (z.a(this.cj, cart2)) {
                            str3 = str2 + "&withdraw=1";
                        } else {
                            str3 = ab.b(str2);
                        }
                        String d3 = com.paytm.utility.b.d(str3, "POST");
                        if (com.paytm.utility.b.c((Context) getActivity())) {
                            this.bs = true;
                            getActivity();
                            net.one97.paytm.recharge.common.f.d.a();
                            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("post_checkout", d3, (ai) new ai() {
                                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                                    FJRRechargeUtilityBaseV2.this.a_(str, iJRPaytmDataModel, obj);
                                }

                                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                                    boolean unused = FJRRechargeUtilityBaseV2.this.bs = false;
                                    FJRRechargeUtilityBaseV2.this.d(false);
                                    if (FJRRechargeUtilityBaseV2.this.getActivity() == null || !FJRRechargeUtilityBaseV2.this.getActivity().isFinishing()) {
                                        FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2 = FJRRechargeUtilityBaseV2.this;
                                        fJRRechargeUtilityBaseV2.aR = false;
                                        fJRRechargeUtilityBaseV2.r();
                                        CJRRechargeUtilities.INSTANCE.handleError(str, FJRRechargeUtilityBaseV2.this.getActivity(), (Fragment) null, networkCustomError, true, 3, obj);
                                    }
                                }
                            }, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a2));
                            return;
                        }
                        d(false);
                        ba.a((net.one97.paytm.recharge.common.f.a) new net.one97.paytm.recharge.common.f.c("post_checkout", d3, (ai) this, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a2), getContext());
                        return;
                    }
                    d(false);
                    az azVar2 = az.f61525a;
                    az.a(getActivity(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, getResources().getString(R.string.error), getString(R.string.msg_invalid_url));
                }
            } else if (iJRPaytmDataModel2 instanceof BannerData) {
                BannerData bannerData = (BannerData) iJRPaytmDataModel2;
                this.bS = true;
                r();
                if (bannerData.bannerPage != null) {
                    ArrayList<BannerData.BannerPage> arrayList = bannerData.bannerPage;
                    this.X = (RecyclerView) this.k.findViewById(R.id.recyclerview1);
                    if (!(arrayList == null || arrayList.get(0).bannerViews == null || arrayList.get(0).bannerViews.get(0).items == null)) {
                        this.X.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                        this.X.setAdapter(new d(arrayList.get(0).bannerViews.get(0).items));
                    }
                    q.d("BannerResponse" + bannerData.bannerPage.size());
                    new StringBuilder("BannerResponse").append(bannerData.bannerPage.size());
                    com.paytm.utility.b.j();
                }
            } else if (iJRPaytmDataModel2 instanceof CJRGWDataModel) {
                CJRGWDataModel cJRGWDataModel = (CJRGWDataModel) iJRPaytmDataModel2;
                if (cJRGWDataModel.isStatus() && cJRGWDataModel.getGwDataId() != null) {
                    Map<String, String> b3 = b(this.bX, this.bY);
                    String str4 = this.bX;
                    String gwDataId = cJRGWDataModel.getGwDataId();
                    net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    a("post_token_verify", b3, str4, gwDataId, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x aj() {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.bK.getCart().getCartItems(), (Context) getActivity(), this.cg);
        return null;
    }

    private void a(CJRRechargePayment cJRRechargePayment) {
        h();
        if (getActivity() != null) {
            Map hashMap = new HashMap();
            if (D().length() > 0) {
                hashMap = b(D(), this.ai);
            }
            Map map = hashMap;
            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
            FragmentActivity activity = getActivity();
            String str = this.bz;
            CJRRechargeCart cJRRechargeCart = this.bK;
            Class b2 = b(cJRRechargeCart);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.common.utils.a.a(activity, str, cJRRechargeCart, cJRRechargePayment, map, b2, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null), false);
        }
    }

    private String af() {
        CJRUtilityProductV2 cJRUtilityProductV2;
        CJRUtilityAttributesV2 attributes;
        List<CJRUtilityProductV2> list = this.Y;
        if (list == null || list.size() <= 0 || (cJRUtilityProductV2 = this.Y.get(0)) == null || (attributes = cJRUtilityProductV2.getAttributes()) == null) {
            return null;
        }
        return attributes.getPostOrderViewType();
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        q.d("BannerResponsebannerError");
        if (getActivity() == null || !getActivity().isFinishing()) {
            if (ba.a((View) this.aX)) {
                ah();
            }
            if (!this.f62825h || this.bb) {
                d(false);
                this.aR = false;
                r();
                CJRRechargeUtilities.INSTANCE.handleError(str, getActivity(), (Fragment) null, networkCustomError, true, 3, obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String B() {
        if (this.D == null || this.E == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            if ("recharge_number".equalsIgnoreCase(this.D.get(i2)) && this.E.size() > i2) {
                return this.E.get(i2);
            }
        }
        return null;
    }

    public void onDetach() {
        super.onDetach();
    }

    private String ag() {
        try {
            if (this.Y == null || this.Y.size() <= 0) {
                return "account number";
            }
            for (CJRUtilityInputFieldsV2 next : this.Y.get(0).getInputFields()) {
                if ("recharge_number".equalsIgnoreCase(next.getConfigKey())) {
                    return next.getTitle();
                }
            }
            return "account number";
        } catch (NullPointerException unused) {
            q.c("npe in getRechargeNumberKey");
            return "account number";
        } catch (IndexOutOfBoundsException unused2) {
            q.c("ioobe in getRechargeNumberKey");
            return "account number";
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(Integer num, boolean z2) {
        this.bQ = Integer.valueOf(this.bQ.intValue() + (num.intValue() * (z2 ? 1 : -1)));
        this.o.setText(String.valueOf(this.bQ));
    }

    /* access modifiers changed from: package-private */
    public final void C() {
        if (isAdded()) {
            Intent intent = new Intent(getActivity(), AJRBrowsePlanActivity.class);
            intent.putExtra(AJRBrowsePlanActivity.f60738a, true);
            if (this.aC.getText() != null) {
                intent.putExtra("recharge_number", this.aC.getText().toString());
            }
            intent.putExtra(CLPConstants.PRODUCT_ID, this.Y.get(0).getId());
            intent.putExtra("ContentMap", this.av);
            intent.putExtra("category_id", l());
            intent.putExtra(SDKConstants.EVENT_KEY_SCREEN_NAME, this.P);
            intent.putExtra("browsePlanHeader", this.aw);
            intent.putExtra(StringSet.operator, this.Y.get(0).getFilterName());
            intent.putExtra(AppManagerUtil.EXTEND_TYPE, this.U.getURLType());
            getActivity().startActivityForResult(intent, 2);
        }
    }

    class ExpandedURLSpanNoUnderline extends URLSpan {
        public ExpandedURLSpanNoUnderline(String str) {
            super(str);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        public void onClick(View view) {
            if (!TextUtils.isEmpty(getURL())) {
                FJRRechargeUtilityBaseV2.q(FJRRechargeUtilityBaseV2.this);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public final void onClick(View view) {
            if (!FJRRechargeUtilityBaseV2.this.isDetached() && FJRRechargeUtilityBaseV2.this.getActivity() != null) {
                try {
                    AutoCompleteTextView unused = FJRRechargeUtilityBaseV2.this.bG = (AutoCompleteTextView) ((RelativeLayout) view.getParent()).findViewById(R.id.edit_no);
                    Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
                    intent.setType("vnd.android.cursor.dir/phone_v2");
                    FJRRechargeUtilityBaseV2.this.getActivity().startActivityForResult(intent, 100);
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
            }
        }
    }

    public void a(CJRFrequentOrder cJRFrequentOrder) {
        if (!this.f62818a) {
            this.f62818a = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    FJRRechargeUtilityBaseV2.this.f62818a = false;
                }
            }, 2000);
            this.aK = true;
            this.al = true;
            b(cJRFrequentOrder);
            ad();
            if (getContext() != null && this.bi != null && com.paytm.utility.e.z.equalsIgnoreCase(this.U.getCategoryId())) {
                net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(getContext());
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                dVar.a(c.a.a(this.bi.getFilterName()), "recent_item_selected", "", "smart_card_recharge", ab.f61496a, "", "");
            }
        }
    }

    public class d extends RecyclerView.a<a> {

        /* renamed from: b  reason: collision with root package name */
        private final List<? extends BannerData.PaytmBannerItems> f62890b;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            aVar.f62891a.setText(((BannerData.PaytmBannerItems) this.f62890b.get(i2)).name);
            if (!TextUtils.isEmpty(((BannerData.PaytmBannerItems) this.f62890b.get(i2)).imageUrl) && URLUtil.isValidUrl(((BannerData.PaytmBannerItems) this.f62890b.get(i2)).imageUrl)) {
                com.squareup.picasso.w.a().a(((BannerData.PaytmBannerItems) this.f62890b.get(i2)).imageUrl).a(aVar.f62892b, (com.squareup.picasso.e) null);
            }
            String str = ((BannerData.PaytmBannerItems) this.f62890b.get(i2)).urlType;
            if ("Video".equalsIgnoreCase(str)) {
                aVar.f62893c.setVisibility(0);
            }
            aVar.f62892b.setOnClickListener(new View.OnClickListener(str, i2) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FJRRechargeUtilityBaseV2.d.this.a(this.f$1, this.f$2, view);
                }
            });
        }

        public d(List<? extends BannerData.PaytmBannerItems> list) {
            this.f62890b = list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str, int i2, View view) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("Video".equalsIgnoreCase(str)) {
                FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2 = FJRRechargeUtilityBaseV2.this;
                String url = ((BannerData.PaytmBannerItems) this.f62890b.get(i2)).getURL();
                String str2 = null;
                try {
                    FragmentActivity activity = fJRRechargeUtilityBaseV2.getActivity();
                    net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                    Intent intent = new Intent(activity, net.one97.paytm.recharge.di.helper.a.f());
                    if (!TextUtils.isEmpty(url)) {
                        "URL ------".concat(String.valueOf(url));
                        com.paytm.utility.b.j();
                        CJRRechargeUtilities.INSTANCE.debugLog("URL ------".concat(String.valueOf(url)));
                        String e2 = com.paytm.utility.b.e(url);
                        str2 = e2 == null ? com.paytm.utility.b.f(url) : e2;
                        "VIDEO ID ------".concat(String.valueOf(str2));
                        com.paytm.utility.b.j();
                        CJRRechargeUtilities.INSTANCE.debugLog("VIDEO ID ------".concat(String.valueOf(str2)));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra(com.paytm.utility.e.aA, str2);
                        fJRRechargeUtilityBaseV2.startActivity(intent);
                    }
                } catch (Exception e3) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e3);
                }
            } else if ("Embed".equalsIgnoreCase(str)) {
                CJRRechargeUtilities.INSTANCE.loadPage(FJRRechargeUtilityBaseV2.this.getContext(), str, (IJRDataModel) this.f62890b.get(i2), (String) null, 0, (ArrayList<? extends CJRItem>) null, false, CLPConstants.GA_CHANNEL_NAME);
            }
        }

        public final int getItemCount() {
            return this.f62890b.size();
        }

        public class a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            public TextView f62891a;

            /* renamed from: b  reason: collision with root package name */
            public ImageView f62892b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f62893c;

            public a(View view) {
                super(view);
                this.f62891a = (TextView) view.findViewById(R.id.textViewUnderline);
                this.f62891a.setVisibility(8);
                this.f62892b = (ImageView) view.findViewById(R.id.imageViewBanner);
                this.f62893c = (ImageView) view.findViewById(R.id.play_button);
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banner_image, viewGroup, false));
        }
    }

    private Class a(ba.b bVar, CJRRechargeCart cJRRechargeCart) {
        return ba.a(getContext(), bVar, cJRRechargeCart);
    }

    public final Class a(CJRRechargeCart cJRRechargeCart) {
        Class a2 = a(ba.b.ORDER_SUMMARY, cJRRechargeCart);
        if (a2 != null) {
            return a2;
        }
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.a();
    }

    public final Class b(CJRRechargeCart cJRRechargeCart) {
        Class a2 = a(ba.b.RECHARGE_PAYMENT, cJRRechargeCart);
        if (a2 != null) {
            return a2;
        }
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.e();
    }

    private void ah() {
        if (ba.a((View) this.aX)) {
            ba.a(0, (View) this.n);
            ba.a(8, (View) this.aX);
            ba.b(this.aY);
            ba.a(8, (View) this.ba);
            if (getActivity() instanceof net.one97.paytm.recharge.common.e.y) {
                ((net.one97.paytm.recharge.common.e.y) getActivity()).k();
            }
        }
    }

    private void ai() {
        if (getActivity() != null) {
            if (this.aX != null) {
                this.n.setVisibility(8);
                ba.a(0, (View) this.aX);
                ba.a(this.aY);
                ba.a(0, (View) this.ba);
                return;
            }
            i();
        }
    }

    public final boolean k() {
        Button button = this.n;
        return button != null && button.isClickable();
    }

    public final String l() {
        String valueOf = String.valueOf(this.Z.getId());
        return TextUtils.isEmpty(valueOf) ? this.U.getCategoryId() : valueOf;
    }

    public final void a(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage) {
        TextView textView;
        if (cJRSuccessRateAlertMessage != null && !TextUtils.isEmpty(cJRSuccessRateAlertMessage.getMessage()) && (textView = this.v) != null) {
            textView.setVisibility(0);
            this.v.setText(cJRSuccessRateAlertMessage.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.getFlowName().setErrorType(ERROR_TYPE.INLINE_ERROR.name());
            a2.getFlowName().setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
            az azVar = az.f61525a;
            az.a(a2);
        }
    }

    public void onRequestStart() {
        ai();
    }

    public void onPaymentOptionsError() {
        a(this.bM);
        ah();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.UI_DESCRIPTION.name());
        a2.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
        CJRRechargeCart cJRRechargeCart = this.bK;
        if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || this.bK.getCart().getCartItems() == null || this.bK.getCart().getCartItems().isEmpty())) {
            a2.setProductId(this.bK.getCart().getCartItems().get(0).getProductId());
        }
        a2.getFlowName().setTag("fetchPaymentOptions");
        Context context = this.R;
        if (context != null) {
            a2.setErrorMsg(context.getString(R.string.error_message, new Object[]{"onPaymentOptionsError", net.one97.paytm.recharge.legacy.catalog.a.class.getSimpleName()}));
            az azVar = az.f61525a;
            az.a(a2);
        }
    }

    public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        a(this.bM);
        ah();
    }

    public final String D() {
        return m(this.o.getText().toString());
    }

    private static String m(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "") : str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x n(String str) {
        HashMap hashMap = new HashMap();
        if (this.bi != null) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            hashMap.put("event_category", c.a.h(this.bi.getFilterName()));
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, c.a.g(this.bi.getFilterName()));
        }
        hashMap.put("event_action", str);
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, getContext());
        return null;
    }

    /* access modifiers changed from: private */
    public void c(String str, String str2) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str, str2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return FJRRechargeUtilityBaseV2.this.d(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x d(String str, String str2) {
        HashMap hashMap = new HashMap();
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        hashMap.put("event_category", c.a.h(this.bi.getFilterName()));
        hashMap.put("event_action", str);
        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, c.a.g(this.bi.getFilterName()));
        hashMap.put("event_label", str2);
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, getContext());
        return null;
    }

    public final boolean n() {
        return this.f62818a;
    }

    public final void m() {
        if (this.f62825h) {
            final p pVar = new p();
            pVar.f63429e = new View.OnClickListener() {
                public final void onClick(View view) {
                    if (SystemClock.elapsedRealtime() - FJRRechargeUtilityBaseV2.this.bZ >= 2000) {
                        long unused = FJRRechargeUtilityBaseV2.this.bZ = SystemClock.elapsedRealtime();
                        if (com.paytm.utility.b.c((Context) FJRRechargeUtilityBaseV2.this.getActivity())) {
                            FJRRechargeUtilityBaseV2.this.getChildFragmentManager().a().a(pVar).b();
                            FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2 = FJRRechargeUtilityBaseV2.this;
                            fJRRechargeUtilityBaseV2.a(fJRRechargeUtilityBaseV2.U.getURL(), true, true);
                        }
                    }
                }
            };
            getChildFragmentManager();
            am.a(getChildFragmentManager().a().a(R.id.no_network_container, pVar, ""));
            return;
        }
        g.f43805b = this;
        if (getContext() != null) {
            az azVar = az.f61525a;
            az.a(getContext(), ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.UNDEFINED, getContext().getString(R.string.no_connection), getContext().getString(R.string.no_internet));
        }
    }

    public final void a(boolean z2) {
        TopLevelCategoryHeader topLevelCategoryHeader;
        if (z2 && (topLevelCategoryHeader = this.ao) != null && !TextUtils.isEmpty(topLevelCategoryHeader.description) && !TextUtils.isEmpty(topLevelCategoryHeader.title)) {
            this.as.setVisibility(0);
            this.aq.setText(topLevelCategoryHeader.title);
            this.ar.setText(topLevelCategoryHeader.description);
        }
    }

    static /* synthetic */ void a(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2) {
        try {
            if (fJRRechargeUtilityBaseV2.f62826i == null) {
                return;
            }
            if (fJRRechargeUtilityBaseV2.f62826i.isChecked()) {
                fJRRechargeUtilityBaseV2.g(true);
            } else {
                fJRRechargeUtilityBaseV2.g(false);
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    static /* synthetic */ void a(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2, int i2, int i3, RadioButton radioButton, CJRUtilityVariantV2 cJRUtilityVariantV2, CJRUtilityProductListV2 cJRUtilityProductListV2, int i4) {
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        c(i2, cJRUtilityProductListV2);
        fJRRechargeUtilityBaseV2.R();
        fJRRechargeUtilityBaseV2.a(i2, i4);
        fJRRechargeUtilityBaseV2.a(i2, i3, cJRUtilityVariantV2, cJRUtilityProductListV2);
        int i5 = i2 + 1;
        fJRRechargeUtilityBaseV2.y();
        if (cJRUtilityVariantV2.getVariants() != null && cJRUtilityVariantV2.getVariants().size() > 0) {
            fJRRechargeUtilityBaseV2.a(cJRUtilityVariantV2.getVariants(), i5, cJRUtilityVariantV2, cJRUtilityProductListV2);
        } else if (cJRUtilityVariantV2.getProduct() != null) {
            fJRRechargeUtilityBaseV2.c(cJRUtilityVariantV2);
        }
    }

    static /* synthetic */ void d(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2) {
        TextView textView = fJRRechargeUtilityBaseV2.az;
        if (textView != null) {
            textView.setText("");
        }
        LinearLayout linearLayout = fJRRechargeUtilityBaseV2.aB;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            fJRRechargeUtilityBaseV2.aB.setVisibility(4);
        }
        fJRRechargeUtilityBaseV2.bR = null;
        fJRRechargeUtilityBaseV2.an = null;
        fJRRechargeUtilityBaseV2.bL = null;
        fJRRechargeUtilityBaseV2.ca = false;
        fJRRechargeUtilityBaseV2.cb = false;
    }

    static /* synthetic */ void a(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2, CJRUtilityProductListV2 cJRUtilityProductListV2, String str, String str2, String str3) {
        net.one97.paytm.recharge.legacy.catalog.a aVar = fJRRechargeUtilityBaseV2.V;
        if (aVar != null) {
            aVar.a();
        }
        Intent intent = new Intent(fJRRechargeUtilityBaseV2.getActivity(), AJRUtilitySearchActivityV4.class);
        net.one97.paytm.recharge.legacy.catalog.b.a.a().f62801b = cJRUtilityProductListV2;
        if (!(cJRUtilityProductListV2 == null || cJRUtilityProductListV2.getVariantList() == null || cJRUtilityProductListV2.getVariantList().size() <= 0)) {
            List<CJRUtilityVariantV2> variantList = cJRUtilityProductListV2.getVariantList();
            List<CJRAggsItem> a2 = new m().a((List<? extends CJRUtilityVariantV2>) variantList);
            y yVar = y.f61814b;
            y.a(a2);
            y yVar2 = y.f61814b;
            y.b(variantList);
        }
        intent.putExtra("location_title", str);
        intent.putExtra("location_search_hint", str2);
        intent.putExtra("list_type", str3);
        fJRRechargeUtilityBaseV2.getActivity().startActivityForResult(intent, 602);
    }

    static /* synthetic */ void m(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2) {
        fJRRechargeUtilityBaseV2.s();
        CJRRechargeData cJRRechargeData = new CJRRechargeData();
        String filterName = fJRRechargeUtilityBaseV2.Y.get(0).getFilterName();
        fJRRechargeUtilityBaseV2.Y.get(0).getFilterName();
        cJRRechargeData.setOperator(filterName);
        cJRRechargeData.setCircle(StringSet.all);
        String uRLType = fJRRechargeUtilityBaseV2.U.getURLType();
        if (fJRRechargeUtilityBaseV2.getActivity() != null) {
            Intent intent = new Intent(fJRRechargeUtilityBaseV2.getActivity(), AJRBrowsePlanActivity.class);
            intent.putExtra(StringSet.operator, cJRRechargeData.getOperator());
            intent.putExtra("circle", cJRRechargeData.getCircle());
            intent.putExtra(SDKConstants.EVENT_KEY_SCREEN_NAME, fJRRechargeUtilityBaseV2.P);
            intent.putExtra("category_id", fJRRechargeUtilityBaseV2.l());
            if (!TextUtils.isEmpty(uRLType)) {
                intent.putExtra(AppManagerUtil.EXTEND_TYPE, uRLType);
            }
            fJRRechargeUtilityBaseV2.getActivity().startActivityForResult(intent, 2);
        }
    }

    static /* synthetic */ boolean d(List list) {
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        return !c.a.a() && list != null;
    }

    static /* synthetic */ void a(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2, CJRUtilityVariantV2 cJRUtilityVariantV2) {
        Spanned spanned;
        fJRRechargeUtilityBaseV2.ab();
        if (fJRRechargeUtilityBaseV2.l != null && fJRRechargeUtilityBaseV2.m != null) {
            if (cJRUtilityVariantV2 != null) {
                while (cJRUtilityVariantV2.getProduct() == null && cJRUtilityVariantV2.getVariants() != null && cJRUtilityVariantV2.getVariants().size() == 1) {
                    cJRUtilityVariantV2 = cJRUtilityVariantV2.getVariants().get(0);
                }
            }
            if (cJRUtilityVariantV2.getProduct() == null || cJRUtilityVariantV2.getProduct().getAttributes() == null) {
                CJRUtilityProductListV2 cJRUtilityProductListV2 = fJRRechargeUtilityBaseV2.Z;
                if (cJRUtilityProductListV2 != null) {
                    fJRRechargeUtilityBaseV2.c(cJRUtilityProductListV2.getLastUtilityProductList());
                    return;
                }
                return;
            }
            String disclaimer = cJRUtilityVariantV2.getProduct().getAttributes().getDisclaimer();
            if (!TextUtils.isEmpty(disclaimer)) {
                fJRRechargeUtilityBaseV2.l.setVisibility(0);
                fJRRechargeUtilityBaseV2.l.setText(disclaimer);
            }
            String disclaimerHtml = cJRUtilityVariantV2.getProduct().getAttributes().getDisclaimerHtml();
            if (!TextUtils.isEmpty(disclaimerHtml)) {
                fJRRechargeUtilityBaseV2.l.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 24) {
                    spanned = Html.fromHtml(disclaimerHtml, 319);
                } else {
                    spanned = Html.fromHtml(disclaimerHtml);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class);
                if (!(uRLSpanArr == null || fJRRechargeUtilityBaseV2.getActivity() == null || fJRRechargeUtilityBaseV2.getActivity().isFinishing())) {
                    for (URLSpan a2 : uRLSpanArr) {
                        ba.a((Activity) fJRRechargeUtilityBaseV2.getActivity(), spannableStringBuilder, a2);
                    }
                }
                fJRRechargeUtilityBaseV2.l.setText(spannableStringBuilder);
                fJRRechargeUtilityBaseV2.l.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (TextUtils.isEmpty(disclaimer) && TextUtils.isEmpty(disclaimerHtml)) {
                CJRUtilityProductListV2 cJRUtilityProductListV22 = fJRRechargeUtilityBaseV2.Z;
                if (cJRUtilityProductListV22 != null) {
                    fJRRechargeUtilityBaseV2.c(cJRUtilityProductListV22.getLastUtilityProductList());
                }
            } else if (!cJRUtilityVariantV2.getProduct().getAttributes().hideReadMore()) {
                fJRRechargeUtilityBaseV2.l.setMaxLines(2);
                fJRRechargeUtilityBaseV2.l.post(new Runnable() {
                    public final void run() {
                        if (FJRRechargeUtilityBaseV2.this.l.getLineCount() > 2) {
                            FJRRechargeUtilityBaseV2.this.m.setVisibility(0);
                            FJRRechargeUtilityBaseV2.this.m.setPaintFlags(8 | FJRRechargeUtilityBaseV2.this.m.getPaintFlags());
                            return;
                        }
                        FJRRechargeUtilityBaseV2.this.m.setVisibility(8);
                    }
                });
            } else {
                fJRRechargeUtilityBaseV2.m.performClick();
            }
        }
    }

    static /* synthetic */ void a(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2, boolean z2, AutoCompleteTextView autoCompleteTextView, CJRUtilityInputFieldsV2 cJRUtilityInputFieldsV2, RoboTextView roboTextView, View view) {
        if (z2) {
            if (!(fJRRechargeUtilityBaseV2.getActivity() == null || fJRRechargeUtilityBaseV2.getActivity().getWindow() == null)) {
                ((InputMethodManager) fJRRechargeUtilityBaseV2.getActivity().getSystemService("input_method")).showSoftInput(autoCompleteTextView, 2);
            }
            fJRRechargeUtilityBaseV2.aC = autoCompleteTextView;
            fJRRechargeUtilityBaseV2.aC.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2 = FJRRechargeUtilityBaseV2.this;
                    fJRRechargeUtilityBaseV2.av = null;
                    fJRRechargeUtilityBaseV2.aw = null;
                }
            });
            final CJRUtilityInputFieldsV2 cJRUtilityInputFieldsV22 = cJRUtilityInputFieldsV2;
            final AutoCompleteTextView autoCompleteTextView2 = autoCompleteTextView;
            final View view2 = view;
            final RoboTextView roboTextView2 = roboTextView;
            autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    if (FJRRechargeUtilityBaseV2.this.O != null && FJRRechargeUtilityBaseV2.this.O.containsKey(cJRUtilityInputFieldsV22.getConfigKey())) {
                        autoCompleteTextView2.setText(FJRRechargeUtilityBaseV2.this.O.get(cJRUtilityInputFieldsV22.getConfigKey()));
                    }
                    String obj = autoCompleteTextView2.getText().toString();
                    String title = cJRUtilityInputFieldsV22.getTitle();
                    FJRRechargeUtilityBaseV2.this.a(cJRUtilityInputFieldsV22, z, view2, roboTextView2, obj);
                    if (!z && !obj.equals("")) {
                        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(title, obj) {
                            private final /* synthetic */ String f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final Object invoke() {
                                return FJRRechargeUtilityBaseV2.AnonymousClass14.this.a(this.f$1, this.f$2);
                            }
                        });
                    }
                    if (z) {
                        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(title) {
                            private final /* synthetic */ String f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final Object invoke() {
                                return FJRRechargeUtilityBaseV2.this.p(this.f$1);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ x a(String str, String str2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("recharge_utilities_input_field", str);
                    hashMap.put("recharge_utilities_service_type", FJRRechargeUtilityBaseV2.this.ai);
                    hashMap.put("recharge_utilities_input_field_value", str2);
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(FJRRechargeUtilityBaseV2.this.U, (Map<String, Object>) hashMap, "recharge_utilities_input_field_entered", FJRRechargeUtilityBaseV2.this.getActivity());
                    return null;
                }
            });
            view.setBackgroundColor(androidx.core.content.b.c(fJRRechargeUtilityBaseV2.getContext(), R.color.paytm_blue));
            roboTextView.setTextColor(androidx.core.content.b.c(fJRRechargeUtilityBaseV2.getContext(), R.color.gray));
            return;
        }
        view.setBackgroundColor(androidx.core.content.b.c(fJRRechargeUtilityBaseV2.getContext(), R.color.bg_grid_grey));
    }

    static /* synthetic */ void q(FJRRechargeUtilityBaseV2 fJRRechargeUtilityBaseV2) {
        CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
        Context context = fJRRechargeUtilityBaseV2.getContext();
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        Intent intent = new Intent(context, net.one97.paytm.recharge.di.helper.a.c());
        intent.putExtra("url", "https://play.google.com/intl/ALL_in/about/card-terms.html");
        intent.putExtra("title", "Google Play");
        intent.putExtra(UpiConstants.FROM, "Auth");
        intent.putExtra("Close", true);
        intent.putExtra("frequent_orders", frequentOrderList);
        fJRRechargeUtilityBaseV2.startActivity(intent);
    }
}
