package net.one97.paytm.recharge.common.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRPaymentOptions;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.common.entity.shopping.CJRServiceOptions;
import net.one97.paytm.common.entity.shopping.CJRUpdatedValue;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.a;
import net.one97.paytm.recharge.common.a.k;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ak;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout;
import net.one97.paytm.recharge.common.widget.CustomGroupDisplayView;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.model.CJRRechargeData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRMyBillData;
import net.one97.paytm.recharge.model.v4.CJRMyBillDetails;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRRechargeAlertItemMapper;
import net.one97.paytm.recharge.model.v4.Help;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomInputLinearLayout extends LinearLayout implements CustomGroupDisplayView.c {
    private List<CJRDisplayValues> A;
    private HashMap<String, String> B;
    private CJRProductList C;
    private List<CJRUtilityCheckboxItem> D;
    private boolean E;
    private ConvenienceFeeInputLayout.b F;
    private List<? extends CJRPaymentOptions> G;
    private a H;
    private ArrayList<String> I;
    private b J;
    /* access modifiers changed from: private */
    public String K;
    private final String L;
    private boolean M;
    private EditText N;
    private String O;
    private String P;
    private String Q;
    private boolean R;
    private int S;
    private HashMap<String, String> T;
    private boolean U;
    private boolean V;
    private int W;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRItem f62009a;
    private TextView aa;
    private boolean ab;
    private View ac;
    private String ad;
    private boolean ae;
    private boolean af;
    private CustomGroupDisplayView.a ag;
    private int ah;
    private final TextWatcher ai;
    private TextWatcher aj;
    private final s ak;
    private final View.OnClickListener al;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f62010b;

    /* renamed from: c  reason: collision with root package name */
    public CJRCategoryDataHelper f62011c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f62012d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62013e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62014f;

    /* renamed from: g  reason: collision with root package name */
    public View f62015g;

    /* renamed from: h  reason: collision with root package name */
    public CJRPaymentOptions f62016h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62017i;
    public boolean j;
    public CJRMyBillData k;
    boolean l;
    boolean m;
    private HashMap<String, String> n;
    /* access modifiers changed from: private */
    public ConvenienceFeeInputLayout o;
    private List<CJRInputFieldsItem> p;
    private boolean q;
    private CJRProductsItem r;
    private boolean s;
    private JSONObject t;
    private final Map<String, String> u;
    private String v;
    private String w;
    private Integer x;
    private String y;
    private LinearLayout z;

    public interface a {
        void G();

        void K();

        void M();

        void N();

        void O();

        void P();

        void Q();

        void a(View view, CJRInputFieldsItem cJRInputFieldsItem, String str);

        void a(androidx.fragment.app.b bVar);

        void a(String str, long j);

        void a(String str, long j, String str2);

        void a(List<? extends CJRPaymentOptions> list, CJRPaymentOptions cJRPaymentOptions);

        void a(ak akVar);

        void a(CJRRechargeData cJRRechargeData, String str, boolean z, String str2);

        void a(JSONObject jSONObject);

        void b(String str);

        void c(String str);

        void c(boolean z);

        void d(String str);

        void d(boolean z);

        void e(String str);

        boolean g(String str);

        void h(String str);
    }

    public interface b {
        void C();
    }

    public void a(boolean z2) {
    }

    public void d() {
    }

    public final EditText getMBillAmountEdt() {
        return this.f62012d;
    }

    public final void setMBillAmountEdt(EditText editText) {
        this.f62012d = editText;
    }

    public final CJRProductList getProductList() {
        return this.C;
    }

    public final void setProductList(CJRProductList cJRProductList) {
        this.C = cJRProductList;
    }

    public final List<CJRUtilityCheckboxItem> getMultipleCheckedItemList() {
        return this.D;
    }

    public final void setMultipleCheckedItemList(List<CJRUtilityCheckboxItem> list) {
        this.D = list;
    }

    /* access modifiers changed from: protected */
    public final a getMCustomInputLayoutListner() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public final void setMCustomInputLayoutListner(a aVar) {
        this.H = aVar;
    }

    public final void setOtc(boolean z2) {
        this.f62017i = z2;
    }

    public final String getPlanGuiId() {
        return this.O;
    }

    public final void setPlanGuiId(String str) {
        this.O = str;
    }

    public final String getCurrentPlanName() {
        return this.P;
    }

    public final void setCurrentPlanName(String str) {
        this.P = str;
    }

    public final String getPreviousPlanName() {
        return this.Q;
    }

    public final void setPreviousPlanName(String str) {
        this.Q = str;
    }

    public final boolean getPlanChangeFlag() {
        return this.R;
    }

    public final void setPlanChangeFlag(boolean z2) {
        this.R = z2;
    }

    public final int getOtcBit() {
        return this.S;
    }

    public final void setOtcBit(int i2) {
        this.S = i2;
    }

    public final HashMap<String, String> getHashMapDynamicOperatorData() {
        return this.T;
    }

    public final void setHashMapDynamicOperatorData(HashMap<String, String> hashMap) {
        this.T = hashMap;
    }

    public final void setDynamicPlanBasedOperator(boolean z2) {
        this.j = z2;
    }

    public final void setDeferredConvenience(boolean z2) {
        this.U = z2;
    }

    public final void setInTabs(boolean z2) {
        this.V = z2;
    }

    public final int getVendingCharges() {
        return this.W;
    }

    public final void setVendingCharges(int i2) {
        this.W = i2;
    }

    public final TextView getViewMyBill() {
        return this.aa;
    }

    public final void setViewMyBill(TextView textView) {
        this.aa = textView;
    }

    public final boolean getMyBillDownloaded() {
        return this.ab;
    }

    public final void setMyBillDownloaded(boolean z2) {
        this.ab = z2;
    }

    public final CJRMyBillData getMyBillData() {
        return this.k;
    }

    public final void setMyBillData(CJRMyBillData cJRMyBillData) {
        this.k = cJRMyBillData;
    }

    public final void setFetchAmountMessageShown(boolean z2) {
        this.l = z2;
    }

    public final View getAmountInfoView() {
        return this.ac;
    }

    public final void setAmountInfoView(View view) {
        this.ac = view;
    }

    public final String getAmountFetchedFromServer() {
        return this.ad;
    }

    public final void setAmountFetchedFromServer(String str) {
        this.ad = str;
    }

    public final void setSampleBillPresent(boolean z2) {
        this.ae = z2;
    }

    public final void setAmountTouched(boolean z2) {
        this.af = z2;
    }

    public final CustomGroupDisplayView.a getSelectedGroupDisplayItemMapper() {
        return this.ag;
    }

    public final void setSelectedGroupDisplayItemMapper(CustomGroupDisplayView.a aVar) {
        this.ag = aVar;
    }

    public final void setBrowsePlanSelected(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: protected */
    public final int getAmountIndex() {
        return this.ah;
    }

    /* access modifiers changed from: protected */
    public final void setAmountIndex(int i2) {
        this.ah = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomInputLinearLayout(Context context) {
        this(context, (AttributeSet) null);
        kotlin.g.b.k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomInputLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.k.c(context, "context");
        this.t = new JSONObject();
        this.u = new LinkedHashMap();
        this.A = new ArrayList();
        this.B = new HashMap<>();
        this.D = new ArrayList();
        this.I = new ArrayList<>();
        this.L = "N/A";
        this.ah = -1;
        this.ai = new w(this);
        this.aj = new y();
        this.ak = new s(this);
        this.al = new x(this);
    }

    public void a() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setVisibility(8);
        setLayoutTransition(new LayoutTransition());
    }

    public final void a(CJRProductList cJRProductList, CJRItem cJRItem, View.OnClickListener onClickListener, CJRCategoryDataHelper cJRCategoryDataHelper, HashMap<String, String> hashMap, ConvenienceFeeInputLayout.b bVar, a aVar, b bVar2) {
        List<CJRProductsItem> products;
        CJRExtensionAttributes extnAttrs;
        kotlin.g.b.k.c(onClickListener, "contactClickListner");
        kotlin.g.b.k.c(cJRCategoryDataHelper, "categoryDataHelper");
        kotlin.g.b.k.c(hashMap, "deeplinkParams");
        kotlin.g.b.k.c(bVar, "convFeeActionListener");
        kotlin.g.b.k.c(bVar2, "onViewUpdateListener");
        this.H = aVar;
        this.C = cJRProductList;
        this.B = hashMap;
        this.f62009a = cJRItem;
        this.f62010b = onClickListener;
        this.f62011c = cJRCategoryDataHelper;
        this.F = bVar;
        this.J = bVar2;
        String str = null;
        this.aa = null;
        this.k = null;
        this.ab = false;
        this.l = false;
        this.ae = false;
        this.ag = null;
        e();
        this.m = false;
        if (!(cJRProductList == null || (products = cJRProductList.getProducts()) == null || products.size() <= 0)) {
            CJRProductsItem cJRProductsItem = cJRProductList.getProducts().get(0);
            this.p = cJRProductsItem != null ? cJRProductsItem.getInputFields() : null;
            CJRProductsItem cJRProductsItem2 = cJRProductList.getProducts().get(0);
            this.q = cJRProductsItem2 != null ? cJRProductsItem2.isPrefetch() : false;
            CJRProductsItem cJRProductsItem3 = cJRProductList.getProducts().get(0);
            this.f62013e = (cJRProductsItem3 == null || (extnAttrs = cJRProductsItem3.getExtnAttrs()) == null) ? false : extnAttrs.isConvenienceFeeApplicable();
            this.r = cJRProductList.getProducts().get(0);
            removeAllViews();
            a(this.p, Boolean.valueOf(this.q), this.q);
            CJRProductsItem cJRProductsItem4 = cJRProductList.getProducts().get(0);
            this.x = cJRProductsItem4 != null ? cJRProductsItem4.getCatalogProductId() : null;
            CJRProductsItem cJRProductsItem5 = cJRProductList.getProducts().get(0);
            this.y = cJRProductsItem5 != null ? cJRProductsItem5.getMinAmount() : null;
            CJRProductsItem cJRProductsItem6 = cJRProductList.getProducts().get(0);
            if (cJRProductsItem6 != null) {
                str = cJRProductsItem6.getErrorImage();
            }
            this.K = str;
        }
        if (this.q) {
            if (this.B.size() > 0) {
                this.f62014f = true;
            }
            this.B.clear();
        }
    }

    public final void setImputFields(List<CJRInputFieldsItem> list) {
        kotlin.g.b.k.c(list, "pInputFields");
        this.p = list;
    }

    public final void setDeepLinkParams(HashMap<String, String> hashMap) {
        kotlin.g.b.k.c(hashMap, "pDeepLinkParams");
        this.B = hashMap;
    }

    public final void setRechargeItem(CJRItem cJRItem) {
        kotlin.g.b.k.c(cJRItem, "pRechargeItem");
        this.f62009a = cJRItem;
    }

    public final void setDTHProductList(CJRProductList cJRProductList) {
        kotlin.g.b.k.c(cJRProductList, "pProductList");
        this.C = cJRProductList;
    }

    static final class v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62086a;

        v(CustomInputLinearLayout customInputLinearLayout) {
            this.f62086a = customInputLinearLayout;
        }

        public final void onClick(View view) {
            List<CJRProductsItem> products;
            List<CJRProductsItem> products2;
            CJRProductsItem cJRProductsItem;
            if (net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked("view_my_bill_button")) {
                return;
            }
            if (this.f62086a.getMyBillData() == null) {
                CJRProductList productList = this.f62086a.getProductList();
                if (productList != null && (products = productList.getProducts()) != null && (!products.isEmpty())) {
                    CJRProductList productList2 = this.f62086a.getProductList();
                    if (productList2 == null || (products2 = productList2.getProducts()) == null || (cJRProductsItem = products2.get(0)) == null || !cJRProductsItem.isShowViewMyBillWithMobileVerfication()) {
                        a mCustomInputLayoutListner = this.f62086a.getMCustomInputLayoutListner();
                        if (mCustomInputLayoutListner != null) {
                            mCustomInputLayoutListner.a(this.f62086a.getJSONObjectForViewMyBillRequest());
                            return;
                        }
                        return;
                    }
                    CustomInputLinearLayout.a(this.f62086a);
                    return;
                }
                return;
            }
            CustomInputLinearLayout customInputLinearLayout = this.f62086a;
            CJRMyBillData myBillData = customInputLinearLayout.getMyBillData();
            if (myBillData == null) {
                kotlin.g.b.k.a();
            }
            customInputLinearLayout.a(myBillData);
        }
    }

    public final void a(CustomGroupDisplayView.a aVar) {
        if (aVar != null) {
            this.ag = aVar;
            String c2 = net.one97.paytm.recharge.common.utils.z.c(String.valueOf(aVar.f61996b));
            kotlin.g.b.k.a((Object) c2, "CJRRechargeUtil.getAmoun…ring(it.price.toString())");
            setAmountOnAmountField(c2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x038c A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0471 A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x049c A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04fe A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0507 A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0512 A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053d A[Catch:{ Exception -> 0x0555 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0549 A[Catch:{ Exception -> 0x0555 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.CJRRechargeCart r21, kotlin.k.e<kotlin.x> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "rechargeCart.cart.cartItems[0].serviceOptions"
            java.lang.String r4 = "displayValues[index]"
            java.lang.String r5 = "rechargeCart.cart.cartItems[0]"
            java.lang.String r6 = "rechargeCart.cart"
            java.lang.String r7 = "rechargeCart"
            kotlin.g.b.k.c(r0, r7)
            java.lang.String r7 = "proceedButtonState"
            kotlin.g.b.k.c(r2, r7)
            r7 = 0
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0599
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0599
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x0555 }
            if (r8 <= 0) goto L_0x0599
            net.one97.paytm.common.entity.CJRItem r8 = r1.f62009a     // Catch:{ Exception -> 0x0555 }
            r9 = 0
            if (r8 == 0) goto L_0x0056
            java.lang.String r8 = r8.getCategoryId()     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0056
            android.content.Context r10 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r11 = "context"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x0555 }
            boolean r8 = net.one97.paytm.recharge.common.utils.az.c(r10, r8, r0)     // Catch:{ Exception -> 0x0555 }
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r1.U = r8     // Catch:{ Exception -> 0x0555 }
            boolean r8 = r1.E     // Catch:{ Exception -> 0x0555 }
            if (r8 != 0) goto L_0x0599
            net.one97.paytm.recharge.widgets.c.d r8 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r8 = r8.getServiceOptions()     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRServiceActions r8 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.common.entity.shopping.CJRServiceOptions) r8)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.di.helper.c r10 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x0555 }
            boolean r10 = net.one97.paytm.recharge.di.helper.c.bz()     // Catch:{ Exception -> 0x0555 }
            r11 = 1
            if (r10 == 0) goto L_0x0131
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r8 = r8.getServiceOptions()     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0118
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r8 = r8.getServiceOptions()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getActions()     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0107
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ Exception -> 0x0555 }
            boolean r8 = r8.isEmpty()     // Catch:{ Exception -> 0x0555 }
            r8 = r8 ^ r11
            if (r8 != r11) goto L_0x0107
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r8 = r8.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8     // Catch:{ Exception -> 0x0555 }
            int r8 = r8.getDisplayArrayIndex()     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r10 = r10.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r10 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r10     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r5 = r10.getServiceOptions()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r3 = r5.getActions()     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x0555 }
            r8 = r3
            net.one97.paytm.common.entity.shopping.CJRServiceActions r8 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r8     // Catch:{ Exception -> 0x0555 }
            goto L_0x0131
        L_0x0107:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x0555 }
            android.content.Context r2 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.VERIFY_CALL     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.common.entity.CJRRechargeCart) r0)     // Catch:{ Exception -> 0x0555 }
            r20.f()     // Catch:{ Exception -> 0x0555 }
            return
        L_0x0118:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x0555 }
            android.content.Context r2 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.VERIFY_CALL     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.common.entity.CJRRechargeCart) r0)     // Catch:{ Exception -> 0x0555 }
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x012e
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x012e:
            r1.f62012d = r7     // Catch:{ Exception -> 0x0555 }
            return
        L_0x0131:
            if (r8 == 0) goto L_0x016c
            java.lang.String r3 = "description"
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r3 = r1.f((java.lang.String) r3)     // Catch:{ Exception -> 0x0555 }
            if (r3 == 0) goto L_0x013e
            r1.a((net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r3)     // Catch:{ Exception -> 0x0555 }
        L_0x013e:
            java.lang.String r3 = "groupDisplay"
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r3 = r1.f((java.lang.String) r3)     // Catch:{ Exception -> 0x0555 }
            if (r3 == 0) goto L_0x016c
            java.util.ArrayList r5 = r8.getGroupDisplay()     // Catch:{ Exception -> 0x0555 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x0555 }
            boolean r5 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r5)     // Catch:{ Exception -> 0x0555 }
            if (r5 == 0) goto L_0x016c
            java.util.ArrayList r5 = r8.getGroupDisplay()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r10 = "customerInfoServiceAction.groupDisplay"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.widget.CustomGroupDisplayView r10 = new net.one97.paytm.recharge.common.widget.CustomGroupDisplayView     // Catch:{ Exception -> 0x0555 }
            android.content.Context r12 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            r13 = r1
            net.one97.paytm.recharge.common.widget.CustomGroupDisplayView$c r13 = (net.one97.paytm.recharge.common.widget.CustomGroupDisplayView.c) r13     // Catch:{ Exception -> 0x0555 }
            r10.<init>(r12, r3, r5, r13)     // Catch:{ Exception -> 0x0555 }
            android.view.View r10 = (android.view.View) r10     // Catch:{ Exception -> 0x0555 }
            r1.addView(r10)     // Catch:{ Exception -> 0x0555 }
        L_0x016c:
            boolean r3 = r1.E     // Catch:{ Exception -> 0x0555 }
            if (r3 != 0) goto L_0x017d
            r1.E = r11     // Catch:{ Exception -> 0x0555 }
            java.util.List<net.one97.paytm.recharge.model.v4.CJRInputFieldsItem> r3 = r1.p     // Catch:{ Exception -> 0x0555 }
            boolean r5 = r1.q     // Catch:{ Exception -> 0x0555 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0555 }
            r1.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRInputFieldsItem>) r3, (java.lang.Boolean) r5, (boolean) r9)     // Catch:{ Exception -> 0x0555 }
        L_0x017d:
            if (r8 == 0) goto L_0x0185
            java.lang.String r3 = r8.getBillAmountMax()     // Catch:{ Exception -> 0x0555 }
            if (r3 != 0) goto L_0x0187
        L_0x0185:
            java.lang.String r3 = r1.v     // Catch:{ Exception -> 0x0555 }
        L_0x0187:
            r1.v = r3     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x0191
            java.lang.String r3 = r8.getBillAmountMin()     // Catch:{ Exception -> 0x0555 }
            if (r3 != 0) goto L_0x0193
        L_0x0191:
            java.lang.String r3 = r1.w     // Catch:{ Exception -> 0x0555 }
        L_0x0193:
            r1.w = r3     // Catch:{ Exception -> 0x0555 }
            if (r8 == 0) goto L_0x01b5
            boolean r3 = r8.isCustomerBillDownload()     // Catch:{ Exception -> 0x0555 }
            if (r3 != r11) goto L_0x01b5
            android.widget.TextView r3 = r1.aa     // Catch:{ Exception -> 0x0555 }
            if (r3 == 0) goto L_0x01b5
            r3.setVisibility(r9)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r5 = "View My Bill"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0555 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$v r5 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$v     // Catch:{ Exception -> 0x0555 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0555 }
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5     // Catch:{ Exception -> 0x0555 }
            r3.setOnClickListener(r5)     // Catch:{ Exception -> 0x0555 }
        L_0x01b5:
            if (r8 == 0) goto L_0x04a2
            java.util.ArrayList r3 = r8.getDisplayValues()     // Catch:{ Exception -> 0x0555 }
            r5 = r3
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0555 }
            r1.A = r5     // Catch:{ Exception -> 0x0555 }
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.LinearLayout"
            java.lang.String r10 = "null cannot be cast to non-null type android.widget.TextView"
            if (r3 == 0) goto L_0x0363
            int r12 = r3.size()     // Catch:{ Exception -> 0x0555 }
            if (r12 <= 0) goto L_0x0363
            android.widget.LinearLayout r12 = r1.z     // Catch:{ Exception -> 0x0555 }
            if (r12 == 0) goto L_0x01d3
            r12.setVisibility(r9)     // Catch:{ Exception -> 0x0555 }
        L_0x01d3:
            java.lang.String r12 = r8.getBillAmount()     // Catch:{ Exception -> 0x0555 }
            boolean r13 = d((java.lang.String) r12)     // Catch:{ Exception -> 0x0555 }
            if (r13 == 0) goto L_0x0201
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0555 }
            double r12 = java.lang.Math.abs(r12)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.recharge.CJRDisplayValues r14 = new net.one97.paytm.common.entity.recharge.CJRDisplayValues     // Catch:{ Exception -> 0x0555 }
            r14.<init>()     // Catch:{ Exception -> 0x0555 }
            android.content.res.Resources r15 = r20.getResources()     // Catch:{ Exception -> 0x0555 }
            int r11 = net.one97.paytm.recharge.R.string.advance_amount     // Catch:{ Exception -> 0x0555 }
            java.lang.String r11 = r15.getString(r11)     // Catch:{ Exception -> 0x0555 }
            r14.setmLabel(r11)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0555 }
            r14.setmValue(r11)     // Catch:{ Exception -> 0x0555 }
            r3.add(r14)     // Catch:{ Exception -> 0x0555 }
        L_0x0201:
            android.content.Context r11 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            com.paytm.utility.b.f((android.content.Context) r11)     // Catch:{ Exception -> 0x0555 }
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0555 }
            int r11 = r11.size()     // Catch:{ Exception -> 0x0555 }
            r12 = 0
        L_0x0210:
            if (r12 >= r11) goto L_0x037b
            android.content.Context r13 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            if (r13 == 0) goto L_0x0351
            android.content.Context r13 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            android.view.LayoutInflater r13 = android.view.LayoutInflater.from(r13)     // Catch:{ Exception -> 0x0555 }
            int r14 = net.one97.paytm.recharge.R.layout.recharge_util_description_layout     // Catch:{ Exception -> 0x0555 }
            android.view.View r13 = r13.inflate(r14, r7)     // Catch:{ Exception -> 0x0555 }
            if (r13 == 0) goto L_0x034b
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13     // Catch:{ Exception -> 0x0555 }
            int r14 = net.one97.paytm.recharge.R.id.firsttext     // Catch:{ Exception -> 0x0555 }
            android.view.View r14 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0555 }
            if (r14 == 0) goto L_0x0345
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x0555 }
            int r15 = net.one97.paytm.recharge.R.id.secondtext     // Catch:{ Exception -> 0x0555 }
            android.view.View r15 = r13.findViewById(r15)     // Catch:{ Exception -> 0x0555 }
            if (r15 == 0) goto L_0x033f
            android.widget.TextView r15 = (android.widget.TextView) r15     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r7 = r3.get(r12)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.recharge.CJRDisplayValues r7 = (net.one97.paytm.common.entity.recharge.CJRDisplayValues) r7     // Catch:{ Exception -> 0x0555 }
            java.lang.String r7 = r7.getLabel()     // Catch:{ Exception -> 0x0555 }
            boolean r7 = net.one97.paytm.recharge.common.utils.g.c(r7)     // Catch:{ Exception -> 0x0555 }
            if (r7 == 0) goto L_0x0351
            java.lang.Object r7 = r3.get(r12)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.recharge.CJRDisplayValues r7 = (net.one97.paytm.common.entity.recharge.CJRDisplayValues) r7     // Catch:{ Exception -> 0x0555 }
            java.lang.String r7 = r7.getValue()     // Catch:{ Exception -> 0x0555 }
            boolean r7 = net.one97.paytm.recharge.common.utils.g.c(r7)     // Catch:{ Exception -> 0x0555 }
            if (r7 == 0) goto L_0x0351
            r14.setVisibility(r9)     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r7 = r3.get(r12)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.recharge.CJRDisplayValues r7 = (net.one97.paytm.common.entity.recharge.CJRDisplayValues) r7     // Catch:{ Exception -> 0x0555 }
            java.lang.String r7 = r7.getLabel()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r9 = "displayValues[index].label"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)     // Catch:{ Exception -> 0x0555 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x0555 }
            int r9 = r7.length()     // Catch:{ Exception -> 0x0555 }
            r16 = 1
            int r9 = r9 + -1
            r0 = r9
            r18 = r11
            r9 = 0
            r17 = 0
        L_0x0289:
            if (r9 > r0) goto L_0x02ae
            if (r17 != 0) goto L_0x028f
            r11 = r9
            goto L_0x0290
        L_0x028f:
            r11 = r0
        L_0x0290:
            char r11 = r7.charAt(r11)     // Catch:{ Exception -> 0x0555 }
            r2 = 32
            if (r11 > r2) goto L_0x029a
            r2 = 1
            goto L_0x029b
        L_0x029a:
            r2 = 0
        L_0x029b:
            if (r17 != 0) goto L_0x02a7
            if (r2 != 0) goto L_0x02a4
            r2 = r22
            r17 = 1
            goto L_0x0289
        L_0x02a4:
            int r9 = r9 + 1
            goto L_0x02ab
        L_0x02a7:
            if (r2 == 0) goto L_0x02ae
            int r0 = r0 + -1
        L_0x02ab:
            r2 = r22
            goto L_0x0289
        L_0x02ae:
            int r0 = r0 + 1
            java.lang.CharSequence r0 = r7.subSequence(r9, r0)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0555 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0555 }
            r14.setText(r0)     // Catch:{ Exception -> 0x0555 }
            r0 = 10
            r2 = 0
            r14.setPadding(r2, r2, r2, r0)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r7 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
            r15.setVisibility(r2)     // Catch:{ Exception -> 0x0555 }
            java.lang.Object r2 = r3.get(r12)     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.recharge.CJRDisplayValues r2 = (net.one97.paytm.common.entity.recharge.CJRDisplayValues) r2     // Catch:{ Exception -> 0x0555 }
            java.lang.String r2 = r2.getValue()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r7 = "displayValues[index].value"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x0555 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0555 }
            int r7 = r2.length()     // Catch:{ Exception -> 0x0555 }
            r9 = 1
            int r7 = r7 - r9
            r9 = 0
            r11 = 0
        L_0x02e4:
            if (r9 > r7) goto L_0x030e
            if (r11 != 0) goto L_0x02ea
            r0 = r9
            goto L_0x02eb
        L_0x02ea:
            r0 = r7
        L_0x02eb:
            char r0 = r2.charAt(r0)     // Catch:{ Exception -> 0x0555 }
            r19 = r3
            r3 = 32
            if (r0 > r3) goto L_0x02f7
            r0 = 1
            goto L_0x02f8
        L_0x02f7:
            r0 = 0
        L_0x02f8:
            if (r11 != 0) goto L_0x0305
            if (r0 != 0) goto L_0x0302
            r3 = r19
            r0 = 10
            r11 = 1
            goto L_0x02e4
        L_0x0302:
            int r9 = r9 + 1
            goto L_0x0309
        L_0x0305:
            if (r0 == 0) goto L_0x0310
            int r7 = r7 + -1
        L_0x0309:
            r3 = r19
            r0 = 10
            goto L_0x02e4
        L_0x030e:
            r19 = r3
        L_0x0310:
            int r7 = r7 + 1
            java.lang.CharSequence r0 = r2.subSequence(r9, r7)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0555 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0555 }
            r15.setText(r0)     // Catch:{ Exception -> 0x0555 }
            r0 = 10
            r2 = 0
            r15.setPadding(r2, r2, r2, r0)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
            r20.getContext()     // Catch:{ Exception -> 0x0555 }
            com.paytm.utility.b.a((android.widget.TextView) r14)     // Catch:{ Exception -> 0x0555 }
            r20.getContext()     // Catch:{ Exception -> 0x0555 }
            com.paytm.utility.b.a((android.widget.TextView) r15)     // Catch:{ Exception -> 0x0555 }
            android.widget.LinearLayout r0 = r1.z     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0355
            android.view.View r13 = (android.view.View) r13     // Catch:{ Exception -> 0x0555 }
            r0.addView(r13)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
            goto L_0x0355
        L_0x033f:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x0345:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x034b:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x0351:
            r19 = r3
            r18 = r11
        L_0x0355:
            int r12 = r12 + 1
            r0 = r21
            r2 = r22
            r11 = r18
            r3 = r19
            r7 = 0
            r9 = 0
            goto L_0x0210
        L_0x0363:
            android.widget.LinearLayout r0 = r1.z     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x036e
            int r2 = net.one97.paytm.recharge.R.id.description_title     // Catch:{ Exception -> 0x0555 }
            android.view.View r7 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0555 }
            goto L_0x036f
        L_0x036e:
            r7 = 0
        L_0x036f:
            boolean r0 = r7 instanceof android.view.View     // Catch:{ Exception -> 0x0555 }
            if (r0 != 0) goto L_0x0374
            r7 = 0
        L_0x0374:
            if (r7 == 0) goto L_0x037b
            net.one97.paytm.recharge.common.utils.ai.b(r7)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x037b:
            android.content.Context r0 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ Exception -> 0x0555 }
            int r2 = net.one97.paytm.recharge.R.layout.education_checkbox_layout     // Catch:{ Exception -> 0x0555 }
            r3 = 0
            android.view.View r0 = r0.inflate(r2, r3)     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x049c
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x0555 }
            int r2 = net.one97.paytm.recharge.R.id.check_box_label     // Catch:{ Exception -> 0x0555 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0555 }
            if (r2 == 0) goto L_0x0496
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r21.getCart()     // Catch:{ Exception -> 0x0555 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x0555 }
            java.util.ArrayList r3 = r3.getCartItems()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r4 = "rechargeCart.cart.cartItems"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0555 }
            java.util.List r11 = r1.a((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRCartProduct>) r3)     // Catch:{ Exception -> 0x0555 }
            r3 = r11
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x0555 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0555 }
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0469
            int r3 = net.one97.paytm.recharge.R.id.education_checkbox_view     // Catch:{ Exception -> 0x0555 }
            android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x0555 }
            if (r3 == 0) goto L_0x0461
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3     // Catch:{ Exception -> 0x0555 }
            r3.setHasFixedSize(r4)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.model.v4.CJRProductList r4 = r1.C     // Catch:{ Exception -> 0x0555 }
            if (r4 == 0) goto L_0x0469
            java.util.List r4 = r4.getProducts()     // Catch:{ Exception -> 0x0555 }
            if (r4 == 0) goto L_0x0469
            int r4 = r4.size()     // Catch:{ Exception -> 0x0555 }
            if (r4 <= 0) goto L_0x0469
            net.one97.paytm.recharge.model.v4.CJRProductList r4 = r1.C     // Catch:{ Exception -> 0x0555 }
            if (r4 != 0) goto L_0x03db
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0555 }
        L_0x03db:
            java.util.List r4 = r4.getProducts()     // Catch:{ Exception -> 0x0555 }
            if (r4 != 0) goto L_0x03e4
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0555 }
        L_0x03e4:
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4     // Catch:{ Exception -> 0x0555 }
            if (r4 == 0) goto L_0x0469
            java.lang.String r6 = r4.getCheckboxScreenTitle()     // Catch:{ Exception -> 0x0555 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0555 }
            r2.setText(r6)     // Catch:{ Exception -> 0x0555 }
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r2 = "list"
            java.lang.String r5 = r4.getCheckboxDisplayType()     // Catch:{ Exception -> 0x0555 }
            r6 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r6)     // Catch:{ Exception -> 0x0555 }
            if (r2 == 0) goto L_0x0415
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x0555 }
            android.content.Context r5 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0555 }
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2     // Catch:{ Exception -> 0x0555 }
            r3.setLayoutManager(r2)     // Catch:{ Exception -> 0x0555 }
            goto L_0x0424
        L_0x0415:
            androidx.recyclerview.widget.GridLayoutManager r2 = new androidx.recyclerview.widget.GridLayoutManager     // Catch:{ Exception -> 0x0555 }
            android.content.Context r5 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            r6 = 2
            r2.<init>(r5, r6)     // Catch:{ Exception -> 0x0555 }
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2     // Catch:{ Exception -> 0x0555 }
            r3.setLayoutManager(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x0424:
            net.one97.paytm.recharge.common.a.k r2 = new net.one97.paytm.recharge.common.a.k     // Catch:{ Exception -> 0x0555 }
            android.content.Context r10 = r20.getContext()     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$s r5 = r1.ak     // Catch:{ Exception -> 0x0555 }
            r12 = r5
            net.one97.paytm.recharge.common.a.k$a r12 = (net.one97.paytm.recharge.common.a.k.a) r12     // Catch:{ Exception -> 0x0555 }
            java.lang.String r13 = r4.getCheckboxDisplayType()     // Catch:{ Exception -> 0x0555 }
            r14 = 0
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0555 }
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2     // Catch:{ Exception -> 0x0555 }
            r3.setAdapter(r2)     // Catch:{ Exception -> 0x0555 }
            android.widget.LinearLayout r2 = r1.z     // Catch:{ Exception -> 0x0555 }
            if (r2 == 0) goto L_0x0445
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0555 }
        L_0x0445:
            android.widget.LinearLayout r2 = r1.z     // Catch:{ Exception -> 0x0555 }
            if (r2 == 0) goto L_0x044e
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x0555 }
            r2.addView(r0)     // Catch:{ Exception -> 0x0555 }
        L_0x044e:
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0457
            r2 = 0
            r0.setLongClickable(r2)     // Catch:{ Exception -> 0x0555 }
            goto L_0x0458
        L_0x0457:
            r2 = 0
        L_0x0458:
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x045f
            r0.setFocusable(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x045f:
            r0 = 1
            goto L_0x046f
        L_0x0461:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            java.lang.String r2 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x0469:
            android.view.View r2 = (android.view.View) r2     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.utils.ai.b(r2)     // Catch:{ Exception -> 0x0555 }
            r0 = 0
        L_0x046f:
            if (r0 != 0) goto L_0x0474
            r1.setSingleProductAmount(r8)     // Catch:{ Exception -> 0x0555 }
        L_0x0474:
            java.lang.String r0 = r8.getBillAmount()     // Catch:{ Exception -> 0x0555 }
            boolean r2 = d((java.lang.String) r0)     // Catch:{ Exception -> 0x0555 }
            if (r2 != 0) goto L_0x04a2
            java.lang.String r2 = "0"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0555 }
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x04a2
            if (r0 == 0) goto L_0x04a2
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r0 = r1.H     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x04a2
            java.lang.String r2 = "bill due"
            r0.h(r2)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
            goto L_0x04a2
        L_0x0496:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x049c:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0555 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0555 }
            throw r0     // Catch:{ Exception -> 0x0555 }
        L_0x04a2:
            if (r8 == 0) goto L_0x04a9
            java.util.List r7 = r8.getPaymentOptions()     // Catch:{ Exception -> 0x0555 }
            goto L_0x04aa
        L_0x04a9:
            r7 = 0
        L_0x04aa:
            r1.G = r7     // Catch:{ Exception -> 0x0555 }
            java.lang.String r0 = r20.getAmount()     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x04f1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0555 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x0555 }
            if (r0 <= 0) goto L_0x04bc
            r0 = 1
            goto L_0x04bd
        L_0x04bc:
            r0 = 0
        L_0x04bd:
            r2 = 1
            if (r0 != r2) goto L_0x04f1
            java.lang.String r0 = r20.getAmount()     // Catch:{ ParseException -> 0x04e7 }
            if (r0 != 0) goto L_0x04c9
            kotlin.g.b.k.a()     // Catch:{ ParseException -> 0x04e7 }
        L_0x04c9:
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ ParseException -> 0x04e7 }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x04dd
            r0 = r22
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0     // Catch:{ ParseException -> 0x04e7 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ ParseException -> 0x04e7 }
            r0.invoke(r2)     // Catch:{ ParseException -> 0x04e7 }
            goto L_0x04fa
        L_0x04dd:
            r0 = r22
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0     // Catch:{ ParseException -> 0x04e7 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ ParseException -> 0x04e7 }
            r0.invoke(r2)     // Catch:{ ParseException -> 0x04e7 }
            goto L_0x04fa
        L_0x04e7:
            r0 = r22
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0     // Catch:{ Exception -> 0x0555 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0555 }
            r0.invoke(r2)     // Catch:{ Exception -> 0x0555 }
            goto L_0x04fa
        L_0x04f1:
            r0 = r22
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0     // Catch:{ Exception -> 0x0555 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0555 }
            r0.invoke(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x04fa:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r0 = r1.H     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0503
            r0.G()     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x0503:
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x050e
            android.view.View$OnClickListener r2 = r1.al     // Catch:{ Exception -> 0x0555 }
            r0.setOnClickListener(r2)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x050e:
            java.util.List<? extends net.one97.paytm.common.entity.shopping.CJRPaymentOptions> r0 = r1.G     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0535
            int r0 = r0.size()     // Catch:{ Exception -> 0x0555 }
            if (r0 <= 0) goto L_0x0533
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0520
            r2 = 1
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x0520:
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0528
            r2 = 0
            r0.setFocusable(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x0528:
            android.widget.EditText r0 = r1.f62012d     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0530
            r2 = 1
            r0.setClickable(r2)     // Catch:{ Exception -> 0x0555 }
        L_0x0530:
            r20.r()     // Catch:{ Exception -> 0x0555 }
        L_0x0533:
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x0535:
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$a r0 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.f61976h     // Catch:{ Exception -> 0x0555 }
            boolean r0 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.a.a(r21)     // Catch:{ Exception -> 0x0555 }
            if (r0 != 0) goto L_0x0549
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r0 = r1.o     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0548
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.utils.ai.b(r0)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x0548:
            return
        L_0x0549:
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r0 = r1.o     // Catch:{ Exception -> 0x0555 }
            if (r0 == 0) goto L_0x0554
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x0555 }
            net.one97.paytm.recharge.common.utils.ai.a(r0)     // Catch:{ Exception -> 0x0555 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0555 }
        L_0x0554:
            return
        L_0x0555:
            r0 = move-exception
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r3 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            r2.setErrorType(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x0571
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x0571:
            android.content.Context r3 = r20.getContext()
            int r4 = net.one97.paytm.recharge.R.string.no_description_error
            java.lang.String r3 = r3.getString(r4)
            r2.setErrorMsg(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x058d
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.VERIFY_CALL
            java.lang.String r4 = r4.name()
            r3.setActionType(r4)
        L_0x058d:
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2)
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x0599:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a(net.one97.paytm.common.entity.CJRRechargeCart, kotlin.k.e):void");
    }

    private static boolean d(String str) {
        CharSequence charSequence = str;
        return !TextUtils.isEmpty(charSequence) && str != null && new kotlin.m.l("-\\d+(\\.\\d+)?").matches(charSequence);
    }

    public final void a(List<CJRInputFieldsItem> list, Boolean bool, boolean z2) {
        CJRInputFieldsItem cJRInputFieldsItem;
        CJRInputFieldsItem cJRInputFieldsItem2;
        setVisibility(0);
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRInputFieldsItem cJRInputFieldsItem3 = list.get(i2);
                String str = null;
                if (!kotlin.m.p.a("groupDisplay", cJRInputFieldsItem3 != null ? cJRInputFieldsItem3.getType() : null, true)) {
                    CJRInputFieldsItem cJRInputFieldsItem4 = list.get(i2);
                    if (cJRInputFieldsItem4 != null) {
                        str = cJRInputFieldsItem4.getType();
                    }
                    if (!kotlin.m.p.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, str, true) && (((cJRInputFieldsItem = list.get(i2)) == null || !cJRInputFieldsItem.isHideInputField()) && (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE) || ((cJRInputFieldsItem2 = list.get(i2)) != null && cJRInputFieldsItem2.isMandatory() == z2)))) {
                        a(list.get(i2), i2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x0008
            java.lang.String r1 = r14.getType()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r2 = 1
            java.lang.String r3 = "amount"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x0016
            r13.c()
            return
        L_0x0016:
            if (r14 == 0) goto L_0x001d
            java.lang.String r1 = r14.getType()
            goto L_0x001e
        L_0x001d:
            r1 = r0
        L_0x001e:
            java.lang.String r3 = "description"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x002a
            r13.a((net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r14)
            return
        L_0x002a:
            android.content.Context r1 = r13.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r3 = net.one97.paytm.recharge.R.layout.input_field_digital_catalog
            r4 = r13
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r5 = 0
            android.view.View r1 = r1.inflate(r3, r4, r5)
            java.lang.String r3 = "layoutInflater.inflate(R…tal_catalog, this, false)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r1.setTag(r3)
            boolean r3 = r13.V
            if (r3 == 0) goto L_0x0050
            r1.setFocusable(r5)
            r1.setFocusableInTouchMode(r2)
        L_0x0050:
            int r3 = net.one97.paytm.recharge.R.id.location_layout
            android.view.View r3 = r1.findViewById(r3)
            if (r3 == 0) goto L_0x02aa
            if (r14 == 0) goto L_0x005f
            java.lang.String r4 = r14.getConfigKey()
            goto L_0x0060
        L_0x005f:
            r4 = r0
        L_0x0060:
            r3.setTag(r4)
            int r3 = net.one97.paytm.recharge.R.id.edit_no
            android.view.View r3 = r1.findViewById(r3)
            if (r3 == 0) goto L_0x02a2
            android.widget.EditText r3 = (android.widget.EditText) r3
            com.paytm.utility.RoboTextView r8 = r13.d((android.view.View) r1)
            java.lang.String r4 = java.lang.String.valueOf(r15)
            java.lang.String r6 = "InputField_Message_"
            java.lang.String r4 = r6.concat(r4)
            r8.setTag(r4)
            net.one97.paytm.common.entity.CJRItem r4 = r13.f62009a
            if (r4 == 0) goto L_0x0087
            java.lang.String r4 = r4.getCategoryId()
            goto L_0x0088
        L_0x0087:
            r4 = r0
        L_0x0088:
            if (r4 == 0) goto L_0x0092
            java.lang.String r6 = "99932"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x009d
        L_0x0092:
            if (r14 == 0) goto L_0x0099
            java.lang.String r4 = r14.getTitle()
            goto L_0x009a
        L_0x0099:
            r4 = r0
        L_0x009a:
            r13.setHint(r1, r4)
        L_0x009d:
            java.lang.String r4 = "null cannot be cast to non-null type android.widget.ImageView"
            if (r14 == 0) goto L_0x00c8
            java.util.List r6 = r14.getHelp()
            if (r6 == 0) goto L_0x00c8
            int r7 = net.one97.paytm.recharge.R.id.info
            android.view.View r7 = r1.findViewById(r7)
            if (r7 == 0) goto L_0x00c2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r9 = r7
            android.view.View r9 = (android.view.View) r9
            net.one97.paytm.recharge.common.utils.ai.a(r9)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$k r9 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$k
            r9.<init>(r6, r13, r1)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r7.setOnClickListener(r9)
            goto L_0x00c8
        L_0x00c2:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r4)
            throw r14
        L_0x00c8:
            if (r14 == 0) goto L_0x00cf
            java.lang.String r6 = r14.getConfigKey()
            goto L_0x00d0
        L_0x00cf:
            r6 = r0
        L_0x00d0:
            java.lang.String r7 = "recharge_number"
            boolean r6 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r6, (boolean) r2)
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.TextView"
            if (r6 == 0) goto L_0x00ed
            int r6 = net.one97.paytm.recharge.R.id.sample_bill
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x00e7
            android.widget.TextView r6 = (android.widget.TextView) r6
            r13.aa = r6
            goto L_0x00ed
        L_0x00e7:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r9)
            throw r14
        L_0x00ed:
            if (r14 == 0) goto L_0x00f4
            java.lang.String r6 = r14.getSampleBill()
            goto L_0x00f5
        L_0x00f4:
            r6 = r0
        L_0x00f5:
            if (r6 == 0) goto L_0x011e
            int r6 = net.one97.paytm.recharge.R.id.sample_bill
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x0118
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r9 = r14.getSampleBill()
            r6.setTag(r9)
            r6.setVisibility(r5)
            r13.ae = r2
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$l r9 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$l
            r9.<init>(r13, r14)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r6.setOnClickListener(r9)
            goto L_0x011e
        L_0x0118:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r9)
            throw r14
        L_0x011e:
            int r6 = net.one97.paytm.recharge.R.id.contact_picker
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x029c
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            int r4 = net.one97.paytm.recharge.R.id.number_sep_1
            android.view.View r11 = r1.findViewById(r4)
            java.lang.String r4 = "separatorView"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            java.lang.String r4 = java.lang.String.valueOf(r15)
            java.lang.String r9 = "InputField_Separator_"
            java.lang.String r4 = r9.concat(r4)
            r11.setTag(r4)
            if (r14 == 0) goto L_0x0150
            boolean r4 = r14.isShowPhoneBook()
            if (r4 != r2) goto L_0x0150
            r6.setVisibility(r5)
            android.view.View$OnClickListener r4 = r13.f62010b
            r6.setOnClickListener(r4)
        L_0x0150:
            if (r14 == 0) goto L_0x0155
            a((android.widget.EditText) r3, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r14)
        L_0x0155:
            if (r14 == 0) goto L_0x015c
            java.lang.String r4 = r14.getType()
            goto L_0x015d
        L_0x015c:
            r4 = r0
        L_0x015d:
            java.lang.String r12 = "inputGrouping"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r12, (boolean) r2)
            if (r4 == 0) goto L_0x0183
            if (r14 == 0) goto L_0x016c
            java.lang.String r4 = r14.getGroupingCategoryId()
            goto L_0x016d
        L_0x016c:
            r4 = r0
        L_0x016d:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0183
            r3.setFocusable(r5)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$m r4 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$m
            r4.<init>(r13, r15, r14, r3)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
            goto L_0x018d
        L_0x0183:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$n r4 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$n
            r4.<init>(r13, r11, r8, r14)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
        L_0x018d:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$o r4 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$o
            r4.<init>(r13, r14)
            android.view.View$OnTouchListener r4 = (android.view.View.OnTouchListener) r4
            r3.setOnTouchListener(r4)
            if (r14 == 0) goto L_0x019e
            java.lang.String r4 = r14.getConfigKey()
            goto L_0x019f
        L_0x019e:
            r4 = r0
        L_0x019f:
            boolean r4 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r2)
            if (r4 == 0) goto L_0x01b5
            r13.N = r3
            android.widget.EditText r4 = r13.N
            if (r4 == 0) goto L_0x01b5
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$p r6 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$p
            r6.<init>(r13)
            android.text.TextWatcher r6 = (android.text.TextWatcher) r6
            r4.addTextChangedListener(r6)
        L_0x01b5:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$q r4 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$q
            r6 = r4
            r7 = r13
            r9 = r14
            r10 = r3
            r6.<init>(r7, r8, r9, r10, r11)
            android.view.View$OnFocusChangeListener r4 = (android.view.View.OnFocusChangeListener) r4
            r3.setOnFocusChangeListener(r4)
            java.lang.String r4 = java.lang.String.valueOf(r15)
            java.lang.String r6 = "InputField_"
            java.lang.String r4 = r6.concat(r4)
            r3.setTag(r4)
            r3.setFocusable(r5)
            if (r14 == 0) goto L_0x01da
            java.lang.String r4 = r14.getType()
            goto L_0x01db
        L_0x01da:
            r4 = r0
        L_0x01db:
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r12, (boolean) r2)
            if (r4 == 0) goto L_0x01f5
            if (r14 == 0) goto L_0x01e8
            java.lang.String r4 = r14.getGroupingCategoryId()
            goto L_0x01e9
        L_0x01e8:
            r4 = r0
        L_0x01e9:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01f5
            r3.setFocusableInTouchMode(r5)
            goto L_0x01f8
        L_0x01f5:
            r3.setFocusableInTouchMode(r2)
        L_0x01f8:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$r r4 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$r
            r4.<init>(r13, r14)
            android.text.TextWatcher r4 = (android.text.TextWatcher) r4
            r3.addTextChangedListener(r4)
            java.lang.String r4 = "autoCompleteTextView"
            kotlin.g.b.k.c(r3, r4)
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r13.B
            if (r4 == 0) goto L_0x023b
            java.util.Map r4 = (java.util.Map) r4
            if (r14 == 0) goto L_0x0214
            java.lang.String r6 = r14.getConfigKey()
            goto L_0x0215
        L_0x0214:
            r6 = r0
        L_0x0215:
            if (r4 == 0) goto L_0x0233
            boolean r4 = r4.containsKey(r6)
            if (r4 == 0) goto L_0x023b
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r13.B
            java.util.Map r4 = (java.util.Map) r4
            if (r14 == 0) goto L_0x0228
            java.lang.String r6 = r14.getConfigKey()
            goto L_0x0229
        L_0x0228:
            r6 = r0
        L_0x0229:
            java.lang.Object r4 = r4.get(r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x0252
        L_0x0233:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r14.<init>(r15)
            throw r14
        L_0x023b:
            java.util.ArrayList<java.lang.String> r4 = r13.I
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            if (r14 == 0) goto L_0x0246
            java.lang.String r6 = r14.getConfigKey()
            goto L_0x0247
        L_0x0246:
            r6 = r0
        L_0x0247:
            boolean r4 = kotlin.a.k.a(r4, r6)
            if (r4 != 0) goto L_0x0252
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r13.B
            r4.clear()
        L_0x0252:
            if (r14 == 0) goto L_0x0259
            java.lang.String r4 = r14.getType()
            goto L_0x025a
        L_0x0259:
            r4 = r0
        L_0x025a:
            java.lang.String r6 = "text"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x0270
            boolean r4 = r14.getAlphanumeric()
            if (r4 == 0) goto L_0x026c
            r3.setInputType(r2)
            goto L_0x0270
        L_0x026c:
            r4 = 2
            r3.setInputType(r4)
        L_0x0270:
            int r3 = r13.getChildCount()
            if (r3 < r15) goto L_0x027a
            r13.addView(r1, r15)
            goto L_0x027d
        L_0x027a:
            r13.addView(r1)
        L_0x027d:
            java.util.ArrayList<java.lang.String> r15 = r13.I
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            if (r14 == 0) goto L_0x0288
            java.lang.String r1 = r14.getConfigKey()
            goto L_0x0289
        L_0x0288:
            r1 = r0
        L_0x0289:
            boolean r15 = kotlin.a.k.a(r15, r1)
            if (r15 == 0) goto L_0x0298
            if (r14 == 0) goto L_0x0295
            java.lang.String r0 = r14.getConfigKey()
        L_0x0295:
            r13.a((java.lang.String) r0, (boolean) r2)
        L_0x0298:
            r13.setVisibility(r5)
            return
        L_0x029c:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r4)
            throw r14
        L_0x02a2:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.EditText"
            r14.<init>(r15)
            throw r14
        L_0x02aa:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.view.View"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem, int):void");
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f62060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62061b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f62062c;

        k(List list, CustomInputLinearLayout customInputLinearLayout, View view) {
            this.f62060a = list;
            this.f62061b = customInputLinearLayout;
            this.f62062c = view;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.common.fragment.c cVar = new net.one97.paytm.recharge.common.fragment.c(new CJRRechargeAlertItemMapper().mapFrom((List<Help>) this.f62060a), true, (String) null, (net.one97.paytm.recharge.common.fragment.u) null, 12);
            a mCustomInputLayoutListner = this.f62061b.getMCustomInputLayoutListner();
            if (mCustomInputLayoutListner != null) {
                mCustomInputLayoutListner.a((androidx.fragment.app.b) cVar);
            }
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62063a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62064b;

        l(CustomInputLinearLayout customInputLinearLayout, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62063a = customInputLinearLayout;
            this.f62064b = cJRInputFieldsItem;
        }

        public final void onClick(View view) {
            if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked("view_my_bill")) {
                a mCustomInputLayoutListner = this.f62063a.getMCustomInputLayoutListner();
                if (mCustomInputLayoutListner != null) {
                    mCustomInputLayoutListner.O();
                }
                a mCustomInputLayoutListner2 = this.f62063a.getMCustomInputLayoutListner();
                if (mCustomInputLayoutListner2 != null) {
                    mCustomInputLayoutListner2.P();
                }
                CustomInputLinearLayout customInputLinearLayout = this.f62063a;
                String sampleBill = this.f62064b.getSampleBill();
                String string = this.f62063a.getContext().getString(R.string.sample_bill);
                kotlin.g.b.k.a((Object) string, "context.getString(R.string.sample_bill)");
                CustomInputLinearLayout.a(customInputLinearLayout, sampleBill, string);
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62065a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f62066b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62067c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f62068d;

        m(CustomInputLinearLayout customInputLinearLayout, int i2, CJRInputFieldsItem cJRInputFieldsItem, EditText editText) {
            this.f62065a = customInputLinearLayout;
            this.f62066b = i2;
            this.f62067c = cJRInputFieldsItem;
            this.f62068d = editText;
        }

        public final void onClick(View view) {
            if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked("inputGrouping")) {
                kotlin.g.b.k.a((Object) view, "v");
                view.setEnabled(false);
                a mCustomInputLayoutListner = this.f62065a.getMCustomInputLayoutListner();
                if (mCustomInputLayoutListner != null) {
                    CJRInputFieldsItem cJRInputFieldsItem = this.f62067c;
                    if (cJRInputFieldsItem == null) {
                        kotlin.g.b.k.a();
                    }
                    mCustomInputLayoutListner.a(view, cJRInputFieldsItem, this.f62065a.K);
                }
                View.OnFocusChangeListener onFocusChangeListener = this.f62068d.getOnFocusChangeListener();
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, true);
                }
            }
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62069a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f62070b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RoboTextView f62071c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62072d;

        n(CustomInputLinearLayout customInputLinearLayout, View view, RoboTextView roboTextView, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62069a = customInputLinearLayout;
            this.f62070b = view;
            this.f62071c = roboTextView;
            this.f62072d = cJRInputFieldsItem;
        }

        public final void onClick(View view) {
            View view2 = this.f62070b;
            if (view2 != null) {
                view2.setBackgroundColor(androidx.core.content.b.c(this.f62069a.getContext(), R.color.bg_grid_grey));
            }
            this.f62071c.setTextColor(androidx.core.content.b.c(this.f62069a.getContext(), R.color.gray));
            CustomInputLinearLayout customInputLinearLayout = this.f62069a;
            TextView textView = this.f62071c;
            CJRInputFieldsItem cJRInputFieldsItem = this.f62072d;
            CustomInputLinearLayout.setInputFieldMessage$default(customInputLinearLayout, textView, cJRInputFieldsItem != null ? cJRInputFieldsItem.getMessage() : null, (Boolean) null, 4, (Object) null);
        }
    }

    static final class o implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62073a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62074b;

        o(CustomInputLinearLayout customInputLinearLayout, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62073a = customInputLinearLayout;
            this.f62074b = cJRInputFieldsItem;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            a mCustomInputLayoutListner;
            kotlin.g.b.k.a((Object) motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (motionEvent.getAction() != 1 || (mCustomInputLayoutListner = this.f62073a.getMCustomInputLayoutListner()) == null) {
                return false;
            }
            CJRInputFieldsItem cJRInputFieldsItem = this.f62074b;
            mCustomInputLayoutListner.d(cJRInputFieldsItem != null ? cJRInputFieldsItem.getTitle() : null);
            return false;
        }
    }

    public static final class p implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62075a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        p(CustomInputLinearLayout customInputLinearLayout) {
            this.f62075a = customInputLinearLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            a mCustomInputLayoutListner = this.f62075a.getMCustomInputLayoutListner();
            if (mCustomInputLayoutListner != null) {
                mCustomInputLayoutListner.K();
            }
        }
    }

    static final class q implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62076a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RoboTextView f62077b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62078c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f62079d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f62080e;

        q(CustomInputLinearLayout customInputLinearLayout, RoboTextView roboTextView, CJRInputFieldsItem cJRInputFieldsItem, EditText editText, View view) {
            this.f62076a = customInputLinearLayout;
            this.f62077b = roboTextView;
            this.f62078c = cJRInputFieldsItem;
            this.f62079d = editText;
            this.f62080e = view;
        }

        public final void onFocusChange(View view, boolean z) {
            CustomInputLinearLayout customInputLinearLayout = this.f62076a;
            TextView textView = this.f62077b;
            CJRInputFieldsItem cJRInputFieldsItem = this.f62078c;
            CustomInputLinearLayout.setInputFieldMessage$default(customInputLinearLayout, textView, cJRInputFieldsItem != null ? cJRInputFieldsItem.getMessage() : null, (Boolean) null, 4, (Object) null);
            String obj = this.f62079d.getText().toString();
            CJRInputFieldsItem cJRInputFieldsItem2 = this.f62078c;
            if (cJRInputFieldsItem2 != null) {
                cJRInputFieldsItem2.getTitle();
            }
            this.f62076a.a(this.f62078c, z, this.f62080e, this.f62077b, obj);
            if (!z) {
                this.f62076a.d();
            }
        }
    }

    public static final class r implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62082b;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
        }

        r(CustomInputLinearLayout customInputLinearLayout, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62081a = customInputLinearLayout;
            this.f62082b = cJRInputFieldsItem;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            this.f62081a.f();
        }

        public final void afterTextChanged(Editable editable) {
            String hideFieldCondition;
            kotlin.g.b.k.c(editable, "editable");
            CJRInputFieldsItem cJRInputFieldsItem = this.f62082b;
            if (cJRInputFieldsItem != null && (hideFieldCondition = cJRInputFieldsItem.getHideFieldCondition()) != null) {
                if (new kotlin.m.l(hideFieldCondition).matches(editable.toString())) {
                    List<String> hideConfigKeyList = this.f62082b.getHideConfigKeyList();
                    if (hideConfigKeyList != null) {
                        for (String a2 : hideConfigKeyList) {
                            this.f62081a.a(a2, true);
                        }
                        return;
                    }
                    return;
                }
                List<String> hideConfigKeyList2 = this.f62082b.getHideConfigKeyList();
                if (hideConfigKeyList2 != null) {
                    for (String a3 : hideConfigKeyList2) {
                        this.f62081a.a(a3, false);
                    }
                }
            }
        }
    }

    private void a(int i2) {
        CJRProductsItem cJRProductsItem;
        List<String> amountButtonList;
        CJRProductList cJRProductList = this.C;
        List<CJRProductsItem> products = cJRProductList != null ? cJRProductList.getProducts() : null;
        if (products != null && (!products.isEmpty()) && (cJRProductsItem = products.get(0)) != null && (amountButtonList = cJRProductsItem.getAmountButtonList()) != null && (!amountButtonList.isEmpty())) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.add_amount_btn_container, (ViewGroup) null);
            kotlin.g.b.k.a((Object) inflate, "view");
            inflate.setTag(Boolean.TRUE);
            if (i2 != -1) {
                addView(inflate, i2);
            } else {
                addView(inflate);
            }
            net.one97.paytm.recharge.common.a.a aVar = new net.one97.paytm.recharge.common.a.a(getContext(), amountButtonList, new z(this, i2));
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.add_amount_grid);
            kotlin.g.b.k.a((Object) recyclerView, "amountGrid");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(aVar);
        }
    }

    static final class z implements a.C1168a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62089a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f62090b;

        z(CustomInputLinearLayout customInputLinearLayout, int i2) {
            this.f62089a = customInputLinearLayout;
            this.f62090b = i2;
        }

        public final void a(String str) {
            EditText mBillAmountEdt = this.f62089a.getMBillAmountEdt();
            if (mBillAmountEdt != null) {
                mBillAmountEdt.setText(net.one97.paytm.recharge.common.utils.z.c(str));
            }
        }
    }

    public RoboTextView d(View view) {
        kotlin.g.b.k.c(view, "customAutoCompleteTextViewContainer");
        View findViewById = view.findViewById(R.id.message_input_field);
        if (findViewById != null) {
            return (RoboTextView) findViewById;
        }
        throw new kotlin.u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
    }

    public void setHint(View view, String str) {
        kotlin.g.b.k.c(view, "container");
        View findViewById = view.findViewById(R.id.text_input_layout_utility_amount);
        if (findViewById != null) {
            ((TextInputLayout) findViewById).setHint(str);
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
    }

    public final View a(String str) {
        View findViewWithTag;
        ViewParent parent;
        if (str == null || (findViewWithTag = findViewWithTag(str)) == null || (parent = findViewWithTag.getParent()) == null || !(parent instanceof View)) {
            return null;
        }
        return ((View) parent).findViewById(R.id.edit_no);
    }

    /* access modifiers changed from: private */
    public final void a(String str, boolean z2) {
        if (str != null) {
            View findViewWithTag = findViewWithTag(str);
            if (z2) {
                if (!this.I.contains(str)) {
                    this.I.add(str);
                }
                if (findViewWithTag != null && (findViewWithTag.getParent() instanceof View)) {
                    ViewParent parent = findViewWithTag.getParent();
                    if (parent != null) {
                        ((View) parent).setVisibility(8);
                        TextView e2 = e(findViewWithTag);
                        if (e2 != null) {
                            e2.setText("");
                            return;
                        }
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.view.View");
                }
                return;
            }
            this.I.remove(str);
            if (findViewWithTag != null && (findViewWithTag.getParent() instanceof View)) {
                ViewParent parent2 = findViewWithTag.getParent();
                if (parent2 != null) {
                    ((View) parent2).setVisibility(0);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.view.View");
            }
        }
    }

    private static TextView e(View view) {
        try {
            if (view instanceof RelativeLayout) {
                int childCount = ((RelativeLayout) view).getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (((RelativeLayout) view).getChildAt(i2) instanceof TextInputLayout) {
                        View childAt = ((RelativeLayout) view).getChildAt(i2);
                        if (childAt != null) {
                            return ((TextInputLayout) childAt).getEditText();
                        }
                        throw new kotlin.u("null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void a(CJRInputFieldsItem cJRInputFieldsItem) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.linear_description_layout, this, false);
        if (inflate != null) {
            this.z = (LinearLayout) inflate;
            int f2 = com.paytm.utility.b.f(getContext());
            LinearLayout linearLayout = this.z;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.z;
            String str = null;
            TextView textView = linearLayout2 != null ? (TextView) linearLayout2.findViewById(R.id.description_title) : null;
            if (textView != null) {
                textView.setTextAppearance(getContext(), R.style.descripTitleStyle);
                if (cJRInputFieldsItem != null) {
                    str = cJRInputFieldsItem.getTitle();
                }
                textView.setText(str);
                int i2 = f2 / 2;
                textView.setPadding(i2, 0, 0, f2 / 4);
                LinearLayout linearLayout3 = this.z;
                if (linearLayout3 != null) {
                    int i3 = (int) (((double) f2) * 0.8d);
                    linearLayout3.setPadding(i2, i3, 0, i3);
                }
                LinearLayout linearLayout4 = this.z;
                if (linearLayout4 != null) {
                    linearLayout4.setTag(Boolean.TRUE);
                }
                addView(this.z);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new kotlin.u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    /* access modifiers changed from: protected */
    public final CJRInputFieldsItem getAmountInputfieldObject() {
        List<CJRInputFieldsItem> list = this.p;
        if (list != null) {
            for (CJRInputFieldsItem cJRInputFieldsItem : list) {
                if (kotlin.m.p.a(cJRInputFieldsItem != null ? cJRInputFieldsItem.getType() : null, "amount", true)) {
                    return cJRInputFieldsItem;
                }
            }
        }
        return null;
    }

    private final int getAmountInputfieldObjectIndex() {
        List<CJRInputFieldsItem> list = this.p;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRInputFieldsItem cJRInputFieldsItem = list.get(i2);
            if (kotlin.m.p.a(cJRInputFieldsItem != null ? cJRInputFieldsItem.getType() : null, "amount", true)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX WARNING: type inference failed for: r12v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0442  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r21 = this;
            r10 = r21
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r11 = r21.getAmountInputfieldObject()
            int r12 = r21.getAmountInputfieldObjectIndex()
            r10.ah = r12
            if (r11 == 0) goto L_0x0509
            if (r12 >= 0) goto L_0x0012
            goto L_0x0509
        L_0x0012:
            android.view.View r13 = r21.getAmountContainerView()
            if (r13 == 0) goto L_0x001d
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r13.setTag(r0)
        L_0x001d:
            r10.f62015g = r13
            android.widget.EditText r14 = r10.a((android.view.View) r13)
            if (r13 == 0) goto L_0x002f
            int r0 = net.one97.paytm.recharge.R.id.text_input_layout_utility_amount
            android.view.View r0 = r13.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r9 = r0
            goto L_0x0030
        L_0x002f:
            r9 = 0
        L_0x0030:
            android.widget.TextView r8 = r10.b((android.view.View) r13)
            if (r8 == 0) goto L_0x0043
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "InputField_Message_"
            java.lang.String r0 = r1.concat(r0)
            r8.setTag(r0)
        L_0x0043:
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            r7 = 0
            if (r0 == 0) goto L_0x005e
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x005e
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x005e
            int r0 = r0.getVendingChargeInInteger()
            r10.W = r0
            kotlin.x r0 = kotlin.x.f47997a
        L_0x005e:
            int r0 = r10.W
            r6 = 1
            if (r0 <= 0) goto L_0x0083
            android.content.Context r0 = r21.getContext()
            int r1 = net.one97.paytm.recharge.R.string.vending_charges_message
            java.lang.Object[] r2 = new java.lang.Object[r6]
            int r3 = r10.W
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2[r7] = r3
            java.lang.String r3 = r0.getString(r1, r2)
            r4 = 0
            r5 = 4
            r0 = 0
            r1 = r21
            r2 = r8
            r15 = 1
            r6 = r0
            setInputFieldMessage$default(r1, r2, r3, r4, r5, r6)
            goto L_0x0091
        L_0x0083:
            r15 = 1
            java.lang.String r3 = r11.getMessage()
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r21
            r2 = r8
            setInputFieldMessage$default(r1, r2, r3, r4, r5, r6)
        L_0x0091:
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x00d5
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x00d5
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x00d5
            java.util.List r0 = r0.getDthHelp()
            if (r0 == 0) goto L_0x00d5
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b4
            goto L_0x00b6
        L_0x00b4:
            r0 = 0
            goto L_0x00b7
        L_0x00b6:
            r0 = 1
        L_0x00b7:
            if (r0 != 0) goto L_0x00d5
            if (r13 == 0) goto L_0x00c2
            int r0 = net.one97.paytm.recharge.R.id.info
            android.view.View r0 = r13.findViewById(r0)
            goto L_0x00c3
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            r10.ac = r0
            android.view.View r0 = r10.ac
            if (r0 == 0) goto L_0x00d5
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$c r1 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$c
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00d5:
            net.one97.paytm.common.entity.CJRItem r0 = r10.f62009a
            if (r0 == 0) goto L_0x00de
            java.lang.String r0 = r0.getCategoryId()
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            if (r0 == 0) goto L_0x00e9
            java.lang.String r1 = "99932"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x00f4
        L_0x00e9:
            if (r9 == 0) goto L_0x00f4
            java.lang.String r0 = r11.getTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setHint(r0)
        L_0x00f4:
            java.lang.String r0 = r11.getSampleBill()
            if (r0 == 0) goto L_0x0119
            if (r13 == 0) goto L_0x0103
            int r0 = net.one97.paytm.recharge.R.id.sample_bill
            android.view.View r0 = r13.findViewById(r0)
            goto L_0x0104
        L_0x0103:
            r0 = 0
        L_0x0104:
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x010b
            r0.setVisibility(r7)
        L_0x010b:
            if (r0 == 0) goto L_0x0119
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$h r1 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$h
            r1.<init>(r10, r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0119:
            android.view.View r6 = r10.c((android.view.View) r13)
            if (r6 == 0) goto L_0x012c
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "InputField_Separator_"
            java.lang.String r0 = r1.concat(r0)
            r6.setTag(r0)
        L_0x012c:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r10.B
            if (r0 == 0) goto L_0x0160
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = r11.getConfigKey()
            if (r0 == 0) goto L_0x0158
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0160
            if (r14 == 0) goto L_0x0160
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r10.B
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = r11.getConfigKey()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0160
        L_0x0158:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r0.<init>(r1)
            throw r0
        L_0x0160:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r10.B
            r0.clear()
            if (r14 == 0) goto L_0x017d
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$i r0 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$i
            r1 = r0
            r2 = r21
            r3 = r14
            r4 = r11
            r5 = r6
            r16 = r6
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x017f
        L_0x017d:
            r16 = r6
        L_0x017f:
            if (r14 == 0) goto L_0x0193
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$j r0 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$j
            r1 = r0
            r2 = r21
            r3 = r8
            r4 = r11
            r5 = r14
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            android.view.View$OnFocusChangeListener r0 = (android.view.View.OnFocusChangeListener) r0
            r14.setOnFocusChangeListener(r0)
        L_0x0193:
            if (r14 == 0) goto L_0x01a2
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "InputField_"
            java.lang.String r0 = r1.concat(r0)
            r14.setTag(r0)
        L_0x01a2:
            if (r14 == 0) goto L_0x01a7
            r14.setFocusable(r15)
        L_0x01a7:
            r10.j = r7
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x0448
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x0448
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0380
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x02bc
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x02bc
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x02bc
            boolean r0 = r0.getShowBrowsePlan()
            if (r0 != r15) goto L_0x02bc
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x02bc
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x02bc
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x02bc
            boolean r0 = r0.getShowDynamicPlan()
            if (r0 != r15) goto L_0x02bc
            android.widget.EditText r0 = r10.N
            if (r0 == 0) goto L_0x0380
            r10.j = r15
            if (r13 == 0) goto L_0x01fb
            int r1 = net.one97.paytm.recharge.R.id.extra_link_textview
            android.view.View r1 = r13.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6 = r1
            goto L_0x01fc
        L_0x01fb:
            r6 = 0
        L_0x01fc:
            if (r6 == 0) goto L_0x0201
            r6.setVisibility(r7)
        L_0x0201:
            net.one97.paytm.recharge.model.v4.CJRProductList r1 = r10.C
            if (r1 == 0) goto L_0x020a
            java.util.List r1 = r1.getProducts()
            goto L_0x020b
        L_0x020a:
            r1 = 0
        L_0x020b:
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0218
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0216
            goto L_0x0218
        L_0x0216:
            r1 = 0
            goto L_0x0219
        L_0x0218:
            r1 = 1
        L_0x0219:
            if (r1 != 0) goto L_0x0235
            net.one97.paytm.recharge.model.v4.CJRProductList r1 = r10.C
            if (r1 == 0) goto L_0x0235
            java.util.List r1 = r1.getProducts()
            if (r1 == 0) goto L_0x0235
            java.lang.Object r1 = r1.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x0235
            boolean r1 = r1.isOffersForYouEnabled()
            if (r1 != r15) goto L_0x0235
            r1 = 1
            goto L_0x0236
        L_0x0235:
            r1 = 0
        L_0x0236:
            if (r1 == 0) goto L_0x024a
            if (r6 == 0) goto L_0x025b
            android.content.Context r1 = r21.getContext()
            int r2 = net.one97.paytm.recharge.R.string.offers_and_plans_text
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
            goto L_0x025b
        L_0x024a:
            if (r6 == 0) goto L_0x025b
            android.content.Context r1 = r21.getContext()
            int r2 = net.one97.paytm.recharge.R.string.browse_plans_txt
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
        L_0x025b:
            if (r6 == 0) goto L_0x0281
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$d r17 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$d
            r1 = r17
            r2 = r0
            r3 = r21
            r4 = r13
            r5 = r14
            r15 = r6
            r6 = r9
            r18 = r12
            r12 = 0
            r7 = r11
            r19 = r8
            r8 = r16
            r20 = r9
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r17
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r15.setOnClickListener(r1)
            kotlin.x r1 = kotlin.x.f47997a
            goto L_0x0288
        L_0x0281:
            r19 = r8
            r20 = r9
            r18 = r12
            r12 = 0
        L_0x0288:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r1 = r10.H
            if (r1 == 0) goto L_0x0387
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            net.one97.paytm.recharge.model.v4.CJRProductList r2 = r10.C
            if (r2 == 0) goto L_0x02ab
            java.util.List r2 = r2.getProducts()
            if (r2 == 0) goto L_0x02ab
            java.lang.Object r2 = r2.get(r12)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x02ab
            java.lang.Long r15 = r2.getProductId()
            goto L_0x02ac
        L_0x02ab:
            r15 = 0
        L_0x02ac:
            if (r15 != 0) goto L_0x02b1
            kotlin.g.b.k.a()
        L_0x02b1:
            long r2 = r15.longValue()
            r1.a((java.lang.String) r0, (long) r2)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0387
        L_0x02bc:
            r19 = r8
            r20 = r9
            r18 = r12
            r12 = 0
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x0387
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x0387
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0387
            boolean r0 = r0.getShowBrowsePlan()
            r1 = 1
            if (r0 != r1) goto L_0x0387
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x0387
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x0387
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0387
            boolean r0 = r0.getShowDynamicPlan()
            if (r0 != 0) goto L_0x0387
            if (r13 == 0) goto L_0x02fd
            int r0 = net.one97.paytm.recharge.R.id.browse_plan
            android.view.View r15 = r13.findViewById(r0)
            goto L_0x02fe
        L_0x02fd:
            r15 = 0
        L_0x02fe:
            boolean r0 = r15 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0303
            r15 = 0
        L_0x0303:
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x030a
            r15.setVisibility(r12)
        L_0x030a:
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x0313
            java.util.List r0 = r0.getProducts()
            goto L_0x0314
        L_0x0313:
            r0 = 0
        L_0x0314:
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0321
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x031f
            goto L_0x0321
        L_0x031f:
            r0 = 0
            goto L_0x0322
        L_0x0321:
            r0 = 1
        L_0x0322:
            if (r0 != 0) goto L_0x033f
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r10.C
            if (r0 == 0) goto L_0x033f
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x033f
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x033f
            boolean r0 = r0.isOffersForYouEnabled()
            r1 = 1
            if (r0 != r1) goto L_0x033f
            r0 = 1
            goto L_0x0340
        L_0x033f:
            r0 = 0
        L_0x0340:
            if (r0 == 0) goto L_0x0354
            if (r15 == 0) goto L_0x0365
            android.content.Context r0 = r21.getContext()
            int r1 = net.one97.paytm.recharge.R.string.offers_and_plans_text
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
            goto L_0x0365
        L_0x0354:
            if (r15 == 0) goto L_0x0365
            android.content.Context r0 = r21.getContext()
            int r1 = net.one97.paytm.recharge.R.string.browse_plans_txt
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
        L_0x0365:
            if (r15 == 0) goto L_0x0387
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$e r0 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$e
            r1 = r0
            r2 = r21
            r3 = r13
            r4 = r14
            r5 = r20
            r6 = r11
            r7 = r16
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0387
        L_0x0380:
            r19 = r8
            r20 = r9
            r18 = r12
            r12 = 0
        L_0x0387:
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.Z()
            r1 = 6
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03a9
            if (r0 != 0) goto L_0x039c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a1 }
        L_0x039c:
            int r1 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a9
        L_0x03a1:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x03a9:
            net.one97.paytm.recharge.common.widget.e r0 = new net.one97.paytm.recharge.common.widget.e
            r0.<init>(r1)
            r1 = 1
            r0.f62154a = r1
            net.one97.paytm.recharge.common.widget.e[] r2 = new net.one97.paytm.recharge.common.widget.e[r1]
            r2[r12] = r0
            if (r14 == 0) goto L_0x03bc
            android.text.InputFilter[] r2 = (android.text.InputFilter[]) r2
            r14.setFilters(r2)
        L_0x03bc:
            if (r14 == 0) goto L_0x03c3
            r10.setAmountTextChangeListener(r14)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x03c3:
            if (r14 == 0) goto L_0x03c9
            r0 = 2
            r14.setInputType(r0)
        L_0x03c9:
            r15 = r20
            if (r15 == 0) goto L_0x03e5
            android.content.Context r0 = r21.getContext()
            int r1 = net.one97.paytm.recharge.R.string.utility_amount_hint_text
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r2 = r11.getTitle()
            r3[r12] = r2
            java.lang.String r0 = r0.getString(r1, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setHint(r0)
        L_0x03e5:
            if (r13 == 0) goto L_0x03ec
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r13.setTag(r0)
        L_0x03ec:
            android.widget.EditText r0 = r10.f62012d
            if (r0 == 0) goto L_0x03f5
            r1 = 8
            r0.setVisibility(r1)
        L_0x03f5:
            r10.f62012d = r14
            android.widget.EditText r0 = r10.f62012d
            if (r0 == 0) goto L_0x0412
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$f r9 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$f
            r1 = r9
            r2 = r21
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r11
            r7 = r16
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            android.view.View$OnTouchListener r9 = (android.view.View.OnTouchListener) r9
            r0.setOnTouchListener(r9)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0412:
            android.widget.EditText r0 = r10.f62012d
            if (r0 == 0) goto L_0x042b
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$g r9 = new net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$g
            r1 = r9
            r2 = r21
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r11
            r7 = r16
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            android.view.View$OnFocusChangeListener r9 = (android.view.View.OnFocusChangeListener) r9
            r0.setOnFocusChangeListener(r9)
        L_0x042b:
            boolean r0 = r11.isReadOnly()
            if (r0 == 0) goto L_0x0442
            r10.s = r12
            android.widget.EditText r0 = r10.f62012d
            if (r0 == 0) goto L_0x043a
            r0.setFocusable(r12)
        L_0x043a:
            android.widget.EditText r0 = r10.f62012d
            if (r0 == 0) goto L_0x0445
            r0.setLongClickable(r12)
            goto L_0x0445
        L_0x0442:
            r1 = 1
            r10.s = r1
        L_0x0445:
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x044b
        L_0x0448:
            r18 = r12
            r12 = 0
        L_0x044b:
            if (r13 == 0) goto L_0x0452
            android.view.ViewParent r15 = r13.getParent()
            goto L_0x0453
        L_0x0452:
            r15 = 0
        L_0x0453:
            java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup"
            if (r15 == 0) goto L_0x046d
            if (r13 == 0) goto L_0x045e
            android.view.ViewParent r15 = r13.getParent()
            goto L_0x045f
        L_0x045e:
            r15 = 0
        L_0x045f:
            if (r15 == 0) goto L_0x0467
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15
            r15.removeView(r13)
            goto L_0x046d
        L_0x0467:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r0)
            throw r1
        L_0x046d:
            int r1 = r21.getChildCount()
            r2 = r18
            if (r1 < r2) goto L_0x047e
            r10.addView(r13, r2)
            r1 = 1
            int r2 = r2 + r1
            r10.a((int) r2)
            goto L_0x0485
        L_0x047e:
            r10.addView(r13)
            r1 = -1
            r10.a((int) r1)
        L_0x0485:
            r10.setVisibility(r12)
            boolean r1 = r10.f62013e
            if (r1 == 0) goto L_0x0509
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r1 = r10.o
            if (r1 != 0) goto L_0x0509
            boolean r1 = r10.U
            if (r1 != 0) goto L_0x0509
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem$Builder r1 = new net.one97.paytm.recharge.model.v4.CJRInputFieldsItem$Builder
            r1.<init>()
            r2 = 1
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem$Builder r1 = r1.setIsReadyOnly(r2)
            android.content.Context r3 = r21.getContext()
            int r4 = net.one97.paytm.recharge.R.string.select_payment_mode
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.string.select_payment_mode)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem$Builder r1 = r1.setTitle(r3)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem$Builder r1 = r1.setMandatory(r2)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r1.build()
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r2 = new net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout
            android.content.Context r3 = r21.getContext()
            java.lang.String r4 = "context"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r2.<init>(r3, r1)
            r10.o = r2
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$a r1 = net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.f61976h
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = r10.r
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.l = r1
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r1 = r10.o
            if (r1 == 0) goto L_0x04da
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$b r2 = r10.F
            r1.f61977a = r2
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04da:
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r1 = r10.o
            if (r1 == 0) goto L_0x04e3
            android.view.ViewParent r15 = r1.getParent()
            goto L_0x04e4
        L_0x04e3:
            r15 = 0
        L_0x04e4:
            if (r15 == 0) goto L_0x0502
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r1 = r10.o
            if (r1 == 0) goto L_0x04ef
            android.view.ViewParent r15 = r1.getParent()
            goto L_0x04f0
        L_0x04ef:
            r15 = 0
        L_0x04f0:
            if (r15 == 0) goto L_0x04fc
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r0 = r10.o
            android.view.View r0 = (android.view.View) r0
            r15.removeView(r0)
            goto L_0x0502
        L_0x04fc:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r0)
            throw r1
        L_0x0502:
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout r0 = r10.o
            android.view.View r0 = (android.view.View) r0
            r10.addView(r0)
        L_0x0509:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.c():void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62018a;

        c(CustomInputLinearLayout customInputLinearLayout) {
            this.f62018a = customInputLinearLayout;
        }

        public final void onClick(View view) {
            CJRRechargeAlertItemMapper cJRRechargeAlertItemMapper = new CJRRechargeAlertItemMapper();
            CJRProductList productList = this.f62018a.getProductList();
            if (productList == null) {
                kotlin.g.b.k.a();
            }
            List<CJRProductsItem> products = productList.getProducts();
            if (products == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = products.get(0);
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            List<Help> dthHelp = cJRProductsItem.getDthHelp();
            if (dthHelp == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.common.fragment.c cVar = new net.one97.paytm.recharge.common.fragment.c(cJRRechargeAlertItemMapper.mapFrom(dthHelp), true, (String) null, (net.one97.paytm.recharge.common.fragment.u) null, 12);
            a mCustomInputLayoutListner = this.f62018a.getMCustomInputLayoutListner();
            if (mCustomInputLayoutListner != null) {
                mCustomInputLayoutListner.a((androidx.fragment.app.b) cVar);
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62048a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62049b;

        h(CustomInputLinearLayout customInputLinearLayout, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62048a = customInputLinearLayout;
            this.f62049b = cJRInputFieldsItem;
        }

        public final void onClick(View view) {
            if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked("view_my_bill")) {
                try {
                    HashMap hashMap = new HashMap();
                    Map map = hashMap;
                    CJRItem d2 = this.f62048a.f62009a;
                    map.put("recharge_utilities_service_type", d2 != null ? d2.getName() : null);
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(this.f62048a.f62009a, (Map<String, Object>) hashMap, "recharge_utilities_view_sample_bill_clicked", this.f62048a.getContext());
                } catch (Throwable unused) {
                }
                Context context = this.f62048a.getContext();
                net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                Intent intent = new Intent(context, net.one97.paytm.recharge.di.helper.a.c());
                intent.putExtra("url", this.f62049b.getSampleBill());
                intent.putExtra("title", this.f62048a.getContext().getString(R.string.sample_bill));
                intent.putExtra(UpiConstants.FROM, "electricity");
                this.f62048a.getContext().startActivity(intent);
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62050a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f62051b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62052c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f62053d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f62054e;

        i(CustomInputLinearLayout customInputLinearLayout, EditText editText, CJRInputFieldsItem cJRInputFieldsItem, View view, TextView textView) {
            this.f62050a = customInputLinearLayout;
            this.f62051b = editText;
            this.f62052c = cJRInputFieldsItem;
            this.f62053d = view;
            this.f62054e = textView;
        }

        public final void onClick(View view) {
            EditText editText = this.f62051b;
            String obj = (editText != null ? editText.getText() : null).toString();
            if (!this.f62050a.l) {
                this.f62050a.a(this.f62052c, true, this.f62053d, this.f62054e, obj);
            }
        }
    }

    static final class j implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62055a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f62056b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62057c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f62058d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f62059e;

        j(CustomInputLinearLayout customInputLinearLayout, TextView textView, CJRInputFieldsItem cJRInputFieldsItem, EditText editText, View view) {
            this.f62055a = customInputLinearLayout;
            this.f62056b = textView;
            this.f62057c = cJRInputFieldsItem;
            this.f62058d = editText;
            this.f62059e = view;
        }

        public final void onFocusChange(View view, boolean z) {
            if (!this.f62055a.l) {
                CustomInputLinearLayout.setInputFieldMessage$default(this.f62055a, this.f62056b, this.f62057c.getMessage(), (Boolean) null, 4, (Object) null);
            }
            EditText editText = this.f62058d;
            String valueOf = String.valueOf(editText != null ? editText.getText() : null);
            this.f62057c.getTitle();
            this.f62055a.a(this.f62057c, z, this.f62059e, this.f62056b, valueOf);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f62019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62020b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f62021c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f62022d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f62023e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62024f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ View f62025g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextView f62026h;

        d(EditText editText, CustomInputLinearLayout customInputLinearLayout, View view, EditText editText2, TextInputLayout textInputLayout, CJRInputFieldsItem cJRInputFieldsItem, View view2, TextView textView) {
            this.f62019a = editText;
            this.f62020b = customInputLinearLayout;
            this.f62021c = view;
            this.f62022d = editText2;
            this.f62023e = textInputLayout;
            this.f62024f = cJRInputFieldsItem;
            this.f62025g = view2;
            this.f62026h = textView;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
            r0 = (r3 = r3.getProducts()).get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r6 = r5.f62020b
                net.one97.paytm.recharge.model.v4.CJRProductList r6 = r6.getProductList()
                if (r6 == 0) goto L_0x0057
                java.util.List r6 = r6.getProducts()
                if (r6 == 0) goto L_0x0057
                r0 = 0
                java.lang.Object r6 = r6.get(r0)
                net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
                if (r6 == 0) goto L_0x0057
                java.lang.String r6 = r6.getOperator()
                if (r6 == 0) goto L_0x0057
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r5.f62020b
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r1 = r1.getMCustomInputLayoutListner()
                if (r1 == 0) goto L_0x0057
                android.widget.EditText r2 = r5.f62019a
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r5.f62020b
                net.one97.paytm.recharge.model.v4.CJRProductList r3 = r3.getProductList()
                if (r3 == 0) goto L_0x004a
                java.util.List r3 = r3.getProducts()
                if (r3 == 0) goto L_0x004a
                java.lang.Object r0 = r3.get(r0)
                net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
                if (r0 == 0) goto L_0x004a
                java.lang.Long r0 = r0.getProductId()
                goto L_0x004b
            L_0x004a:
                r0 = 0
            L_0x004b:
                if (r0 != 0) goto L_0x0050
                kotlin.g.b.k.a()
            L_0x0050:
                long r3 = r0.longValue()
                r1.a((java.lang.String) r2, (long) r3, (java.lang.String) r6)
            L_0x0057:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.d.onClick(android.view.View):void");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62027a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f62028b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f62029c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f62030d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62031e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f62032f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextView f62033g;

        e(CustomInputLinearLayout customInputLinearLayout, View view, EditText editText, TextInputLayout textInputLayout, CJRInputFieldsItem cJRInputFieldsItem, View view2, TextView textView) {
            this.f62027a = customInputLinearLayout;
            this.f62028b = view;
            this.f62029c = editText;
            this.f62030d = textInputLayout;
            this.f62031e = cJRInputFieldsItem;
            this.f62032f = view2;
            this.f62033g = textView;
        }

        public final void onClick(View view) {
            CJRRechargeData cJRRechargeData = new CJRRechargeData();
            CJRProductList productList = this.f62027a.getProductList();
            List<CJRProductsItem> products = productList != null ? productList.getProducts() : null;
            if (products == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = products.get(0);
            cJRRechargeData.setOperator(cJRProductsItem != null ? cJRProductsItem.getOperatorLabel() : null);
            CJRProductList productList2 = this.f62027a.getProductList();
            List<CJRProductsItem> products2 = productList2 != null ? productList2.getProducts() : null;
            if (products2 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem2 = products2.get(0);
            cJRRechargeData.setOperatorDisplay(cJRProductsItem2 != null ? cJRProductsItem2.getOperatorDisplayLabel() : null);
            cJRRechargeData.setCircle(StringSet.all);
            CJRItem d2 = this.f62027a.f62009a;
            String uRLType = d2 != null ? d2.getURLType() : null;
            a mCustomInputLayoutListner = this.f62027a.getMCustomInputLayoutListner();
            if (mCustomInputLayoutListner != null) {
                if (uRLType == null) {
                    uRLType = "";
                }
                mCustomInputLayoutListner.a(cJRRechargeData, uRLType, false, (String) null);
            }
        }
    }

    static final class f implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f62035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f62036c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f62037d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62038e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f62039f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextView f62040g;

        f(CustomInputLinearLayout customInputLinearLayout, View view, EditText editText, TextInputLayout textInputLayout, CJRInputFieldsItem cJRInputFieldsItem, View view2, TextView textView) {
            this.f62034a = customInputLinearLayout;
            this.f62035b = view;
            this.f62036c = editText;
            this.f62037d = textInputLayout;
            this.f62038e = cJRInputFieldsItem;
            this.f62039f = view2;
            this.f62040g = textView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            a mCustomInputLayoutListner;
            if (net.one97.paytm.recharge.common.utils.g.c(this.f62034a.getAmountFetchedFromServer())) {
                CustomInputLinearLayout customInputLinearLayout = this.f62034a;
                String amountFetchedFromServer = customInputLinearLayout.getAmountFetchedFromServer();
                if (amountFetchedFromServer == null) {
                    kotlin.g.b.k.a();
                }
                customInputLinearLayout.setAmountFetchMessage(amountFetchedFromServer);
            }
            kotlin.g.b.k.a((Object) motionEvent, "motionEvent");
            if (motionEvent.getAction() == 1 && (mCustomInputLayoutListner = this.f62034a.getMCustomInputLayoutListner()) != null) {
                mCustomInputLayoutListner.d(this.f62038e.getTitle());
            }
            this.f62034a.a(true);
            return false;
        }
    }

    static final class g implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f62042b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f62043c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f62044d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62045e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f62046f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextView f62047g;

        g(CustomInputLinearLayout customInputLinearLayout, View view, EditText editText, TextInputLayout textInputLayout, CJRInputFieldsItem cJRInputFieldsItem, View view2, TextView textView) {
            this.f62041a = customInputLinearLayout;
            this.f62042b = view;
            this.f62043c = editText;
            this.f62044d = textInputLayout;
            this.f62045e = cJRInputFieldsItem;
            this.f62046f = view2;
            this.f62047g = textView;
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                View view2 = this.f62046f;
                if (view2 != null) {
                    view2.setBackgroundColor(androidx.core.content.b.c(this.f62041a.getContext(), R.color.bg_grid_grey));
                }
            } else {
                if (net.one97.paytm.recharge.common.utils.g.c(this.f62041a.getAmountFetchedFromServer())) {
                    CustomInputLinearLayout customInputLinearLayout = this.f62041a;
                    String amountFetchedFromServer = customInputLinearLayout.getAmountFetchedFromServer();
                    if (amountFetchedFromServer == null) {
                        kotlin.g.b.k.a();
                    }
                    customInputLinearLayout.setAmountFetchMessage(amountFetchedFromServer);
                }
                View view3 = this.f62046f;
                if (view3 != null) {
                    view3.setBackgroundColor(androidx.core.content.b.c(this.f62041a.getContext(), R.color.paytm_blue));
                }
                TextView textView = this.f62047g;
                if (textView != null) {
                    textView.setTextColor(androidx.core.content.b.c(this.f62041a.getContext(), R.color.gray));
                }
            }
            this.f62041a.a(z);
        }
    }

    public void setAmountTextChangeListener(EditText editText) {
        kotlin.g.b.k.c(editText, "autoCompleteTextView");
        editText.addTextChangedListener(this.ai);
    }

    public View c(View view) {
        if (view != null) {
            return view.findViewById(R.id.number_sep_1);
        }
        return null;
    }

    public TextView b(View view) {
        if (view != null) {
            return (TextView) view.findViewById(R.id.message_input_field);
        }
        return null;
    }

    public View getAmountContainerView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.amount_input_field_digital_catalog, this, false);
    }

    public EditText a(View view) {
        if (view != null) {
            return (EditText) view.findViewById(R.id.edit_no);
        }
        return null;
    }

    private final String getGTMAmountType() {
        String name = d.a.non_prefetch.name();
        if (!this.q) {
            return name;
        }
        if (this.s) {
            return d.a.prefetch_editable.name();
        }
        return d.a.prefetch_non_editable.name();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getInputFieldValues() {
        /*
            r8 = this;
            java.util.List<net.one97.paytm.recharge.model.v4.CJRInputFieldsItem> r0 = r8.p
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0065
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x000d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r0.next()
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r3 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r3
            r4 = 0
            if (r3 == 0) goto L_0x0021
            java.lang.String r5 = r3.getType()
            goto L_0x0022
        L_0x0021:
            r5 = r4
        L_0x0022:
            r6 = 1
            java.lang.String r7 = "amount"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r7, (boolean) r6)
            if (r5 != 0) goto L_0x000d
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0049
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r8.n
            if (r2 == 0) goto L_0x0044
            java.util.Map r2 = (java.util.Map) r2
            if (r3 == 0) goto L_0x003d
            java.lang.String r4 = r3.getTitle()
        L_0x003d:
            java.lang.Object r2 = r2.get(r4)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
        L_0x0044:
            java.lang.String r2 = java.lang.String.valueOf(r4)
            goto L_0x000d
        L_0x0049:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = "/"
            r5.append(r2)
            if (r3 == 0) goto L_0x005c
            java.lang.String r4 = r3.getTitle()
        L_0x005c:
            r5.append(r4)
            java.lang.String r2 = r5.toString()
            goto L_0x000d
        L_0x0064:
            r1 = r2
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.getInputFieldValues():java.lang.String");
    }

    public static final class w implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62087a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "editable");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "charSequence");
        }

        w(CustomInputLinearLayout customInputLinearLayout) {
            this.f62087a = customInputLinearLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            String amount = this.f62087a.getAmount();
            if (amount != null) {
                CharSequence charSequence2 = amount;
                int length = charSequence2.length() - 1;
                int i5 = 0;
                boolean z = false;
                while (i5 <= length) {
                    boolean z2 = charSequence2.charAt(!z ? i5 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i5++;
                    }
                }
                if (charSequence2.subSequence(i5, length + 1).toString().length() > 0) {
                    try {
                        if (Double.parseDouble(amount) > 0.0d) {
                            a mCustomInputLayoutListner = this.f62087a.getMCustomInputLayoutListner();
                            if (mCustomInputLayoutListner != null) {
                                mCustomInputLayoutListner.c(true);
                            }
                        } else {
                            a mCustomInputLayoutListner2 = this.f62087a.getMCustomInputLayoutListner();
                            if (mCustomInputLayoutListner2 != null) {
                                mCustomInputLayoutListner2.c(false);
                            }
                        }
                        ConvenienceFeeInputLayout e2 = this.f62087a.o;
                        if (e2 != null) {
                            kotlin.g.b.k.c(amount, "value");
                            View view = e2.f61982f;
                            if (view != null) {
                                view.setVisibility(8);
                            }
                            TextView textView = e2.f61983g;
                            if (textView != null) {
                                textView.setText("");
                            }
                            AutoCompleteTextView autoCompleteTextView = e2.f61978b;
                            if (autoCompleteTextView != null) {
                                autoCompleteTextView.setText("");
                            }
                            e2.f61979c = null;
                            e2.f61980d = null;
                            e2.f61981e = null;
                            ConvenienceFeeInputLayout.b bVar = e2.f61977a;
                            if (bVar != null) {
                                bVar.a(e2.f61979c, e2.f61981e);
                            }
                        }
                    } catch (NumberFormatException e3) {
                        com.paytm.utility.q.d(e3.getMessage());
                    }
                } else {
                    a mCustomInputLayoutListner3 = this.f62087a.getMCustomInputLayoutListner();
                    if (mCustomInputLayoutListner3 != null) {
                        mCustomInputLayoutListner3.c(false);
                    }
                    if (this.f62087a.m) {
                        a mCustomInputLayoutListner4 = this.f62087a.getMCustomInputLayoutListner();
                        if (mCustomInputLayoutListner4 != null) {
                            mCustomInputLayoutListner4.Q();
                        }
                        this.f62087a.setBrowsePlanSelected(false);
                    }
                }
                a mCustomInputLayoutListner5 = this.f62087a.getMCustomInputLayoutListner();
                if (mCustomInputLayoutListner5 != null) {
                    mCustomInputLayoutListner5.G();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final TextWatcher getMAmountTextWatcher() {
        return this.ai;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r16, boolean r17, android.view.View r18, android.widget.TextView r19, java.lang.String r20) {
        /*
            r15 = this;
            r0 = r18
            r1 = r19
            r2 = 0
            if (r16 == 0) goto L_0x000c
            java.lang.String r3 = r16.getRegex()
            goto L_0x000d
        L_0x000c:
            r3 = r2
        L_0x000d:
            android.content.Context r4 = r15.getContext()
            java.lang.String r5 = "context"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.content.res.Resources r4 = r4.getResources()
            if (r16 == 0) goto L_0x0021
            java.lang.String r5 = r16.getTitle()
            goto L_0x0022
        L_0x0021:
            r5 = r2
        L_0x0022:
            r6 = 1
            if (r17 != 0) goto L_0x010b
            if (r16 == 0) goto L_0x002c
            java.lang.String r7 = r16.getType()
            goto L_0x002d
        L_0x002c:
            r7 = r2
        L_0x002d:
            java.lang.String r8 = "amount"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            r7 = r7 ^ r6
            if (r7 == 0) goto L_0x00ba
            r7 = r20
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r9 = r7.length()
            int r9 = r9 - r6
            r10 = 0
            r11 = r9
            r9 = 0
            r12 = 0
        L_0x0043:
            if (r9 > r11) goto L_0x0063
            if (r12 != 0) goto L_0x0049
            r13 = r9
            goto L_0x004a
        L_0x0049:
            r13 = r11
        L_0x004a:
            char r13 = r7.charAt(r13)
            r14 = 32
            if (r13 > r14) goto L_0x0054
            r13 = 1
            goto L_0x0055
        L_0x0054:
            r13 = 0
        L_0x0055:
            if (r12 != 0) goto L_0x005e
            if (r13 != 0) goto L_0x005b
            r12 = 1
            goto L_0x0043
        L_0x005b:
            int r9 = r9 + 1
            goto L_0x0043
        L_0x005e:
            if (r13 == 0) goto L_0x0063
            int r11 = r11 + -1
            goto L_0x0043
        L_0x0063:
            int r11 = r11 + r6
            java.lang.CharSequence r7 = r7.subSequence(r9, r11)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0076
            r7 = 1
            goto L_0x0077
        L_0x0076:
            r7 = 0
        L_0x0077:
            if (r7 == 0) goto L_0x0091
            if (r16 == 0) goto L_0x0091
            boolean r7 = r16.isOptional()
            if (r7 != 0) goto L_0x0091
            int r7 = net.one97.paytm.recharge.R.string.utility_input_error_msg
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r9[r10] = r5
            java.lang.String r4 = r4.getString(r7, r9)
            java.lang.String r7 = "resources\n              …                   title)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = ""
        L_0x0093:
            if (r3 == 0) goto L_0x00b8
            r7 = r20
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x00b8 }
            kotlin.m.l r9 = new kotlin.m.l     // Catch:{ Exception -> 0x00b8 }
            r9.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x00b8 }
            boolean r3 = r9.matches(r7)     // Catch:{ Exception -> 0x00b8 }
            if (r3 != 0) goto L_0x00b8
            android.content.Context r3 = r15.getContext()     // Catch:{ Exception -> 0x00b8 }
            int r7 = net.one97.paytm.recharge.R.string.utility_input_error_msg     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00b8 }
            r6[r10] = r5     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r3 = r3.getString(r7, r6)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r5 = "context.getString(R.stri…y_input_error_msg, title)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r3 = r4
            goto L_0x00bc
        L_0x00ba:
            r3 = r20
        L_0x00bc:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00f9
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r15.getContext()
            int r5 = net.one97.paytm.recharge.R.color.error_color
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setBackgroundColor(r4)
        L_0x00d4:
            if (r1 == 0) goto L_0x00e3
            android.content.Context r0 = r15.getContext()
            int r4 = net.one97.paytm.recharge.R.color.error_color
            int r0 = androidx.core.content.b.c(r0, r4)
            r1.setTextColor(r0)
        L_0x00e3:
            if (r16 == 0) goto L_0x00e9
            java.lang.String r2 = r16.getType()
        L_0x00e9:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x00f2
            r15.p()
        L_0x00f2:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r7 = r15
            r15.setInputFieldMessage(r1, r3, r0)
            return
        L_0x00f9:
            r7 = r15
            if (r0 == 0) goto L_0x0109
            android.content.Context r2 = r15.getContext()
            int r4 = net.one97.paytm.recharge.R.color.bg_grid_grey
            int r2 = androidx.core.content.b.c(r2, r4)
            r0.setBackgroundColor(r2)
        L_0x0109:
            r2 = r3
            goto L_0x0161
        L_0x010b:
            r7 = r15
            if (r16 == 0) goto L_0x0113
            java.lang.String r3 = r16.getType()
            goto L_0x0114
        L_0x0113:
            r3 = r2
        L_0x0114:
            java.lang.String r4 = "inputGrouping"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r6)
            if (r3 == 0) goto L_0x013c
            if (r16 == 0) goto L_0x0123
            java.lang.String r3 = r16.getGroupingCategoryId()
            goto L_0x0124
        L_0x0123:
            r3 = r2
        L_0x0124:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x013c
            if (r0 == 0) goto L_0x014b
            android.content.Context r3 = r15.getContext()
            int r4 = net.one97.paytm.recharge.R.color.bg_grid_grey
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setBackgroundColor(r3)
            goto L_0x014b
        L_0x013c:
            if (r0 == 0) goto L_0x014b
            android.content.Context r3 = r15.getContext()
            int r4 = net.one97.paytm.recharge.R.color.paytm_blue
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setBackgroundColor(r3)
        L_0x014b:
            if (r1 == 0) goto L_0x015a
            android.content.Context r0 = r15.getContext()
            int r3 = net.one97.paytm.recharge.R.color.gray
            int r0 = androidx.core.content.b.c(r0, r3)
            r1.setTextColor(r0)
        L_0x015a:
            if (r16 == 0) goto L_0x0161
            java.lang.String r0 = r16.getMessage()
            r2 = r0
        L_0x0161:
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r15
            r1 = r19
            setInputFieldMessage$default(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem, boolean, android.view.View, android.widget.TextView, java.lang.String):void");
    }

    public static /* synthetic */ void setInputFieldMessage$default(CustomInputLinearLayout customInputLinearLayout, TextView textView, String str, Boolean bool, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                bool = Boolean.FALSE;
            }
            customInputLinearLayout.setInputFieldMessage(textView, str, bool);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInputFieldMessage");
    }

    public void setInputFieldMessage(TextView textView, String str, Boolean bool) {
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorMsg(str);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.INLINE_ERROR.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.CLP_PROCEED.name());
            }
            az azVar = az.f61525a;
            az.a(a2);
        }
        if (textView != null) {
            if (str != null) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    textView.setText(charSequence);
                    a aVar = this.H;
                    if (aVar != null) {
                        aVar.e(str);
                    }
                    textView.setVisibility(0);
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    public static final class y implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        y() {
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
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
    }

    public final boolean h() {
        LinearLayout linearLayout;
        CJRInputFieldsItem cJRInputFieldsItem;
        List<CJRInputFieldsItem> list = this.p;
        this.u.clear();
        this.t = new JSONObject();
        if (this.t == null) {
            this.t = new JSONObject();
        }
        CJRPaymentOptions cJRPaymentOptions = this.f62016h;
        if (cJRPaymentOptions != null) {
            try {
                String str = null;
                this.t.put("invoiceNumber", cJRPaymentOptions != null ? cJRPaymentOptions.getInvoiceNumber() : null);
                JSONObject jSONObject = this.t;
                CJRPaymentOptions cJRPaymentOptions2 = this.f62016h;
                jSONObject.put("stbNumber", cJRPaymentOptions2 != null ? cJRPaymentOptions2.getStbNumber() : null);
                JSONObject jSONObject2 = this.t;
                CJRPaymentOptions cJRPaymentOptions3 = this.f62016h;
                if (cJRPaymentOptions3 != null) {
                    str = cJRPaymentOptions3.getAmount();
                }
                jSONObject2.put("amount", str);
            } catch (JSONException e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!a(list.get(i2), (LinearLayout) this, i2, true) && ((cJRInputFieldsItem = list.get(i2)) == null || !cJRInputFieldsItem.isHideInputField())) {
                    return false;
                }
            }
        }
        try {
            if (!(this.z == null || (linearLayout = this.z) == null || linearLayout.getVisibility() != 0 || this.A == null)) {
                List<CJRDisplayValues> list2 = this.A;
                if (list2 == null) {
                    kotlin.g.b.k.a();
                }
                if (list2.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    List<CJRDisplayValues> list3 = this.A;
                    if (list3 == null) {
                        kotlin.g.b.k.a();
                    }
                    int size2 = list3.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        List<CJRDisplayValues> list4 = this.A;
                        if (list4 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!TextUtils.isEmpty(list4.get(i3).getLabel())) {
                            List<CJRDisplayValues> list5 = this.A;
                            if (list5 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (!TextUtils.isEmpty(list5.get(i3).getValue())) {
                                List<CJRDisplayValues> list6 = this.A;
                                if (list6 == null) {
                                    kotlin.g.b.k.a();
                                }
                                String label = list6.get(i3).getLabel();
                                List<CJRDisplayValues> list7 = this.A;
                                if (list7 == null) {
                                    kotlin.g.b.k.a();
                                }
                                jSONObject3.put(label, list7.get(i3).getValue());
                            }
                        }
                    }
                    if (jSONObject3.length() > 0) {
                        this.t.put("displayValues", jSONObject3);
                    }
                }
            }
        } catch (Exception e3) {
            com.paytm.utility.q.d(e3.getMessage());
        }
        List<CJRUtilityCheckboxItem> list8 = this.D;
        if (list8 != null) {
            if (list8 == null) {
                kotlin.g.b.k.a();
            }
            for (CJRUtilityCheckboxItem next : list8) {
                if (TextUtils.isEmpty(next.getPrice())) {
                    String string = getResources().getString(R.string.utility_input_error_msg, new Object[]{next.getName()});
                    kotlin.g.b.k.a((Object) string, "resources\n              …       checkboxItem.name)");
                    az azVar = az.f61525a;
                    az.a(getContext(), ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, (String) null, string, 12);
                    a aVar = this.H;
                    if (aVar != null) {
                        aVar.c(string);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:230:0x044c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x044d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r41, android.widget.LinearLayout r42, int r43, boolean r44) {
        /*
            r40 = this;
            r7 = r40
            r2 = r41
            r0 = r42
            java.lang.String r1 = "inputLayout"
            kotlin.g.b.k.c(r0, r1)
            android.content.res.Resources r1 = r40.getResources()
            android.content.Context r3 = r40.getContext()
            int r4 = net.one97.paytm.recharge.R.string.invalid_amount
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.string.invalid_amount)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = r40.getAmount()
            r5 = 1
            if (r2 == 0) goto L_0x0590
            java.lang.String r6 = r41.getType()
            java.lang.String r8 = "description"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r8, (boolean) r5)
            if (r6 != 0) goto L_0x0590
            java.lang.String r6 = r41.getType()
            java.lang.String r8 = "amount"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            java.lang.String r8 = "context.getString(R.stri…or_msg, inputField.title)"
            java.lang.String r9 = "resources\n              …        inputField.title)"
            r10 = 32
            java.lang.String r12 = ""
            r13 = 0
            if (r6 == 0) goto L_0x02cb
            int r0 = r7.W
            if (r0 <= 0) goto L_0x0053
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r6 = "vending_charge"
            r7.a((java.lang.String) r6, (java.lang.String) r0)
        L_0x0053:
            android.widget.EditText r0 = r7.f62012d
            if (r0 == 0) goto L_0x0590
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0590
            java.lang.String r6 = r40.getAmount()
            if (r6 == 0) goto L_0x00c3
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r14 = r0.length()
            int r14 = r14 - r5
            r15 = r14
            r14 = 0
            r16 = 0
        L_0x006f:
            if (r14 > r15) goto L_0x008e
            if (r16 != 0) goto L_0x0075
            r11 = r14
            goto L_0x0076
        L_0x0075:
            r11 = r15
        L_0x0076:
            char r11 = r0.charAt(r11)
            if (r11 > r10) goto L_0x007e
            r11 = 1
            goto L_0x007f
        L_0x007e:
            r11 = 0
        L_0x007f:
            if (r16 != 0) goto L_0x0089
            if (r11 != 0) goto L_0x0086
            r16 = 1
            goto L_0x006f
        L_0x0086:
            int r14 = r14 + 1
            goto L_0x006f
        L_0x0089:
            if (r11 == 0) goto L_0x008e
            int r15 = r15 + -1
            goto L_0x006f
        L_0x008e:
            int r15 = r15 + r5
            java.lang.CharSequence r0 = r0.subSequence(r14, r15)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x00c3
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00c3
            int r0 = net.one97.paytm.recharge.R.string.utility_input_error_msg
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r4 = r41.getTitle()
            r3[r13] = r4
            java.lang.String r0 = r1.getString(r0, r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            android.content.Context r1 = r40.getContext()
            java.lang.String r3 = "utility_hide_title"
            r7.a((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r0, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r1 = r7.H
            if (r1 == 0) goto L_0x00c2
            r1.c((java.lang.String) r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00c2:
            return r13
        L_0x00c3:
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double r9 = java.lang.Double.valueOf(r14)
            r14 = 0
            java.lang.Double r11 = java.lang.Double.valueOf(r14)
            java.lang.String r0 = r7.v     // Catch:{ Exception -> 0x0103 }
            if (r0 != 0) goto L_0x00d9
            java.lang.Double r0 = r41.getMax()     // Catch:{ Exception -> 0x0103 }
        L_0x00d7:
            r9 = r0
            goto L_0x00e9
        L_0x00d9:
            java.lang.String r0 = r7.v     // Catch:{ Exception -> 0x0103 }
            if (r0 != 0) goto L_0x00e0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0103 }
        L_0x00e0:
            double r17 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0103 }
            java.lang.Double r0 = java.lang.Double.valueOf(r17)     // Catch:{ Exception -> 0x0103 }
            goto L_0x00d7
        L_0x00e9:
            java.lang.String r0 = r7.w     // Catch:{ Exception -> 0x0103 }
            if (r0 == 0) goto L_0x00fd
            java.lang.String r0 = r7.w     // Catch:{ Exception -> 0x0103 }
            if (r0 != 0) goto L_0x00f4
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0103 }
        L_0x00f4:
            double r17 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0103 }
            java.lang.Double r0 = java.lang.Double.valueOf(r17)     // Catch:{ Exception -> 0x0103 }
            goto L_0x0101
        L_0x00fd:
            java.lang.Double r0 = r41.getMin()     // Catch:{ Exception -> 0x0103 }
        L_0x0101:
            r11 = r0
            goto L_0x010b
        L_0x0103:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x010b:
            if (r9 != 0) goto L_0x0111
            java.lang.Double r9 = java.lang.Double.valueOf(r14)
        L_0x0111:
            if (r11 != 0) goto L_0x011c
            r14 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            java.lang.Double r11 = java.lang.Double.valueOf(r14)
        L_0x011c:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x027b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x027b }
            java.lang.String r14 = "resources.getString(\n   …          minAmt, maxAmt)"
            if (r0 != 0) goto L_0x017e
            if (r6 != 0) goto L_0x012c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x027b }
        L_0x012c:
            double r15 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x027b }
            double r17 = r11.doubleValue()     // Catch:{ Exception -> 0x027b }
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x017e
            int r0 = net.one97.paytm.recharge.R.string.electricity_bill_amount_more_than     // Catch:{ Exception -> 0x027b }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x027b }
            double r15 = r11.doubleValue()     // Catch:{ Exception -> 0x027b }
            java.lang.String r6 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x027b }
            r4[r13] = r6     // Catch:{ Exception -> 0x027b }
            java.lang.String r0 = r1.getString(r0, r4)     // Catch:{ Exception -> 0x027b }
            java.lang.String r4 = "resources.getString(\n   …       minAmt.toString())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x027b }
            double r15 = r9.doubleValue()     // Catch:{ Exception -> 0x027b }
            double r17 = r11.doubleValue()     // Catch:{ Exception -> 0x027b }
            int r4 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r4 < 0) goto L_0x016b
            int r0 = net.one97.paytm.recharge.R.string.utility_bill_amount_not_in_range     // Catch:{ Exception -> 0x027b }
            r4 = 2
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x027b }
            r6[r13] = r11     // Catch:{ Exception -> 0x027b }
            r6[r5] = r9     // Catch:{ Exception -> 0x027b }
            java.lang.String r0 = r1.getString(r0, r6)     // Catch:{ Exception -> 0x027b }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)     // Catch:{ Exception -> 0x027b }
        L_0x016b:
            if (r44 == 0) goto L_0x017d
            android.content.Context r4 = r40.getContext()     // Catch:{ Exception -> 0x027b }
            r7.a((android.content.Context) r4, (java.lang.String) r3, (java.lang.String) r0, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2)     // Catch:{ Exception -> 0x027b }
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r4 = r7.H     // Catch:{ Exception -> 0x027b }
            if (r4 == 0) goto L_0x017d
            r4.c((java.lang.String) r0)     // Catch:{ Exception -> 0x027b }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x027b }
        L_0x017d:
            return r13
        L_0x017e:
            double r15 = r9.doubleValue()     // Catch:{ Exception -> 0x027b }
            double r17 = r11.doubleValue()     // Catch:{ Exception -> 0x027b }
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 < 0) goto L_0x01c7
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x027b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x027b }
            if (r0 != 0) goto L_0x01c7
            if (r6 != 0) goto L_0x0198
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x027b }
        L_0x0198:
            double r15 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x027b }
            double r17 = r9.doubleValue()     // Catch:{ Exception -> 0x027b }
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c7
            int r0 = net.one97.paytm.recharge.R.string.utility_bill_amount_not_in_range     // Catch:{ Exception -> 0x027b }
            r4 = 2
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x027b }
            r6[r13] = r11     // Catch:{ Exception -> 0x027b }
            r6[r5] = r9     // Catch:{ Exception -> 0x027b }
            java.lang.String r0 = r1.getString(r0, r6)     // Catch:{ Exception -> 0x027b }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)     // Catch:{ Exception -> 0x027b }
            if (r44 == 0) goto L_0x01c6
            android.content.Context r4 = r40.getContext()     // Catch:{ Exception -> 0x027b }
            r7.a((android.content.Context) r4, (java.lang.String) r3, (java.lang.String) r0, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2)     // Catch:{ Exception -> 0x027b }
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r4 = r7.H     // Catch:{ Exception -> 0x027b }
            if (r4 == 0) goto L_0x01c6
            r4.c((java.lang.String) r0)     // Catch:{ Exception -> 0x027b }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x027b }
        L_0x01c6:
            return r13
        L_0x01c7:
            java.lang.String r0 = r41.getRegex()
            if (r0 == 0) goto L_0x021d
            java.lang.String r0 = r41.getRegex()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r5)
            if (r0 != 0) goto L_0x021d
            if (r6 == 0) goto L_0x021d
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r0 = r41.getRegex()
            if (r0 != 0) goto L_0x01e4
            kotlin.g.b.k.a()
        L_0x01e4:
            kotlin.m.l r1 = new kotlin.m.l
            r1.<init>((java.lang.String) r0)
            boolean r0 = r1.matches(r6)
            if (r0 != 0) goto L_0x021d
            android.content.Context r0 = r40.getContext()
            int r1 = net.one97.paytm.recharge.R.string.utility_input_error_msg
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r2 = r41.getTitle()
            r4[r13] = r2
            java.lang.String r0 = r0.getString(r1, r4)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            if (r44 == 0) goto L_0x021c
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r1 = r40.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INPUT_VALIDATION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.common.utils.az.a(r1, r2, r4, r3, r0)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r1 = r7.H
            if (r1 == 0) goto L_0x021c
            r1.c((java.lang.String) r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x021c:
            return r13
        L_0x021d:
            if (r4 == 0) goto L_0x0590
            java.lang.String r0 = r41.getConfigKey()
            if (r0 == 0) goto L_0x0590
            java.lang.String r0 = r41.getConfigKey()
            r7.b((java.lang.String) r0, (java.lang.String) r4)
            java.lang.String r0 = r41.getTitle()     // Catch:{ Exception -> 0x0271 }
            if (r0 == 0) goto L_0x0590
            java.lang.String r0 = r41.getTitle()     // Catch:{ Exception -> 0x0271 }
            if (r0 != 0) goto L_0x023b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0271 }
        L_0x023b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0271 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x0271 }
            int r1 = r1 - r5
            r2 = r1
            r1 = 0
            r3 = 0
        L_0x0245:
            if (r1 > r2) goto L_0x0263
            if (r3 != 0) goto L_0x024b
            r6 = r1
            goto L_0x024c
        L_0x024b:
            r6 = r2
        L_0x024c:
            char r6 = r0.charAt(r6)     // Catch:{ Exception -> 0x0271 }
            if (r6 > r10) goto L_0x0254
            r6 = 1
            goto L_0x0255
        L_0x0254:
            r6 = 0
        L_0x0255:
            if (r3 != 0) goto L_0x025e
            if (r6 != 0) goto L_0x025b
            r3 = 1
            goto L_0x0245
        L_0x025b:
            int r1 = r1 + 1
            goto L_0x0245
        L_0x025e:
            if (r6 == 0) goto L_0x0263
            int r2 = r2 + -1
            goto L_0x0245
        L_0x0263:
            int r2 = r2 + r5
            java.lang.CharSequence r0 = r0.subSequence(r1, r2)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0271 }
            r7.a((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x0271 }
            goto L_0x0590
        L_0x0271:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            goto L_0x0590
        L_0x027b:
            r0 = move-exception
            int r4 = net.one97.paytm.recharge.R.string.electricity_bill_amount_more_than
            java.lang.Object[] r6 = new java.lang.Object[r5]
            double r14 = r11.doubleValue()
            java.lang.String r8 = java.lang.String.valueOf(r14)
            r6[r13] = r8
            java.lang.String r4 = r1.getString(r4, r6)
            java.lang.String r6 = "resources.getString(\n   …_than, minAmt.toString())"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            double r14 = r9.doubleValue()
            double r17 = r11.doubleValue()
            int r6 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r6 < 0) goto L_0x02b1
            int r4 = net.one97.paytm.recharge.R.string.utility_bill_amount_not_in_range
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r13] = r11
            r6[r5] = r9
            java.lang.String r4 = r1.getString(r4, r6)
            java.lang.String r1 = "resources.getString(\n   …                  maxAmt)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
        L_0x02b1:
            if (r44 == 0) goto L_0x02c3
            android.content.Context r1 = r40.getContext()
            r7.a((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r4, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r1 = r7.H
            if (r1 == 0) goto L_0x02c3
            r1.c((java.lang.String) r4)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x02c3:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            return r13
        L_0x02cb:
            java.lang.String r3 = r41.getType()
            java.lang.String r4 = "groupDisplay"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r5)
            if (r3 == 0) goto L_0x02ee
            java.lang.String r0 = r41.getConfigKey()
            if (r0 == 0) goto L_0x0590
            net.one97.paytm.recharge.common.widget.CustomGroupDisplayView$a r1 = r7.ag
            if (r1 == 0) goto L_0x02e7
            java.lang.String r1 = r1.f61997c
            if (r1 != 0) goto L_0x02e6
            goto L_0x02e7
        L_0x02e6:
            r12 = r1
        L_0x02e7:
            r7.b((java.lang.String) r0, (java.lang.String) r12)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0590
        L_0x02ee:
            java.lang.String r3 = java.lang.String.valueOf(r43)
            java.lang.String r4 = "InputField_"
            java.lang.String r3 = r4.concat(r3)
            android.view.View r3 = r0.findViewWithTag(r3)
            r4 = 0
            if (r3 != 0) goto L_0x03e7
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r4)
            net.one97.paytm.recharge.model.v4.CJRProductList r11 = r7.C
            if (r11 == 0) goto L_0x030e
            java.util.List r11 = r11.getProducts()
            goto L_0x030f
        L_0x030e:
            r11 = r4
        L_0x030f:
            if (r11 == 0) goto L_0x034e
            net.one97.paytm.recharge.model.v4.CJRProductList r11 = r7.C
            if (r11 == 0) goto L_0x034e
            java.util.List r11 = r11.getProducts()
            if (r11 == 0) goto L_0x034e
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r5
            if (r11 != r5) goto L_0x034e
            net.one97.paytm.recharge.model.v4.CJRProductList r11 = r7.C
            if (r11 == 0) goto L_0x032d
            java.util.List r11 = r11.getProducts()
            goto L_0x032e
        L_0x032d:
            r11 = r4
        L_0x032e:
            if (r11 != 0) goto L_0x0333
            kotlin.g.b.k.a()
        L_0x0333:
            java.lang.Object r11 = r11.get(r13)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r11
            if (r11 == 0) goto L_0x034a
            java.lang.Long r11 = r11.getProductId()
            if (r11 == 0) goto L_0x034a
            long r14 = r11.longValue()
            java.lang.String r11 = java.lang.String.valueOf(r14)
            goto L_0x034b
        L_0x034a:
            r11 = r4
        L_0x034b:
            r6.setProductId(r11)
        L_0x034e:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r11 = r7.f62011c
            if (r11 == 0) goto L_0x0358
            java.lang.String r11 = r11.getCategoryId()
            if (r11 != 0) goto L_0x0359
        L_0x0358:
            r11 = r12
        L_0x0359:
            r6.setCategoryId(r11)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 != 0) goto L_0x0396
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r17 = r11
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 1048575(0xfffff, float:1.469367E-39)
            r39 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
        L_0x0396:
            r6.setFlowName(r11)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 == 0) goto L_0x03a8
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r14 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r14 = r14.name()
            r11.setActionType(r14)
        L_0x03a8:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 == 0) goto L_0x03b7
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r14 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r14 = r14.name()
            r11.setErrorType(r14)
        L_0x03b7:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 == 0) goto L_0x03c6
            net.one97.paytm.recharge.widgets.model.ALERT_TYPE r14 = net.one97.paytm.recharge.widgets.model.ALERT_TYPE.PRE_VERIFY_PROCEED
            java.lang.String r14 = r14.name()
            r11.setAlertType(r14)
        L_0x03c6:
            android.content.Context r11 = r40.getContext()
            int r14 = net.one97.paytm.recharge.R.string.pre_verify_proceed_validate_view_null
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]
            java.lang.Class<net.one97.paytm.recharge.common.widget.CustomInputLinearLayout> r16 = net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.class
            java.lang.String r16 = r16.getSimpleName()
            r15[r13] = r16
            java.lang.String r16 = "validateInputFields"
            r15[r5] = r16
            java.lang.String r11 = r11.getString(r14, r15)
            r6.setErrorMsg(r11)
            net.one97.paytm.recharge.common.utils.az r11 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6)
        L_0x03e7:
            java.util.ArrayList<java.lang.String> r6 = r7.I
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.lang.String r11 = r41.getConfigKey()
            boolean r6 = kotlin.a.k.a(r6, r11)
            if (r6 == 0) goto L_0x03f6
            return r5
        L_0x03f6:
            if (r3 == 0) goto L_0x03fd
            java.lang.String r6 = net.one97.paytm.recharge.common.utils.ai.c(r3)
            goto L_0x03fe
        L_0x03fd:
            r6 = r4
        L_0x03fe:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x040b
            boolean r6 = kotlin.m.p.a(r6)
            if (r6 == 0) goto L_0x0409
            goto L_0x040b
        L_0x0409:
            r6 = 0
            goto L_0x040c
        L_0x040b:
            r6 = 1
        L_0x040c:
            if (r6 == r5) goto L_0x041d
            java.lang.String r6 = "view"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.String r3 = net.one97.paytm.recharge.common.utils.ai.c(r3)
            if (r3 != 0) goto L_0x042b
            kotlin.g.b.k.a()
            goto L_0x042b
        L_0x041d:
            boolean r6 = r3 instanceof android.widget.EditText
            if (r6 == 0) goto L_0x042d
            android.widget.EditText r3 = (android.widget.EditText) r3
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
        L_0x042b:
            r6 = r3
            goto L_0x043d
        L_0x042d:
            boolean r6 = r3 instanceof net.one97.paytm.common.widgets.CustomEditText
            if (r6 == 0) goto L_0x043c
            net.one97.paytm.common.widgets.CustomEditText r3 = (net.one97.paytm.common.widgets.CustomEditText) r3
            java.lang.String r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            goto L_0x042b
        L_0x043c:
            r6 = r12
        L_0x043d:
            boolean r3 = r41.isOptional()
            if (r3 == 0) goto L_0x044d
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x044d
            return r5
        L_0x044d:
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r11 = r3.length()
            if (r11 != 0) goto L_0x0458
            r11 = 1
            goto L_0x0459
        L_0x0458:
            r11 = 0
        L_0x0459:
            java.lang.String r12 = "null cannot be cast to non-null type com.paytm.utility.RoboTextView"
            java.lang.String r14 = "InputField_Separator_"
            java.lang.String r15 = "InputField_Message_"
            if (r11 == 0) goto L_0x04c4
            boolean r11 = r41.isOptional()
            if (r11 != 0) goto L_0x04c4
            if (r44 == 0) goto L_0x04c3
            int r3 = net.one97.paytm.recharge.R.string.utility_input_error_msg
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r8 = r41.getTitle()
            r5[r13] = r8
            java.lang.String r1 = r1.getString(r3, r5)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r3 = r7.H
            if (r3 == 0) goto L_0x0483
            r3.c((java.lang.String) r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0483:
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r15.concat(r1)
            android.view.View r1 = r0.findViewWithTag(r1)
            boolean r1 = r1 instanceof com.paytm.utility.RoboTextView
            if (r1 == 0) goto L_0x04ab
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r15.concat(r1)
            android.view.View r1 = r0.findViewWithTag(r1)
            if (r1 == 0) goto L_0x04a5
            r4 = r1
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            goto L_0x04ab
        L_0x04a5:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x04ab:
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r14.concat(r1)
            android.view.View r0 = r0.findViewWithTag(r1)
            r3 = 0
            r5 = r4
            android.widget.TextView r5 = (android.widget.TextView) r5
            r1 = r40
            r2 = r41
            r4 = r0
            r1.a(r2, r3, r4, r5, r6)
        L_0x04c3:
            return r13
        L_0x04c4:
            java.lang.String r1 = r41.getRegex()
            if (r1 == 0) goto L_0x0540
            java.lang.String r1 = r41.getRegex()
            if (r1 != 0) goto L_0x04d3
            kotlin.g.b.k.a()
        L_0x04d3:
            kotlin.m.l r9 = new kotlin.m.l
            r9.<init>((java.lang.String) r1)
            boolean r1 = r9.matches(r3)
            if (r1 == 0) goto L_0x04df
            goto L_0x0540
        L_0x04df:
            if (r44 == 0) goto L_0x053f
            android.content.Context r1 = r40.getContext()
            int r3 = net.one97.paytm.recharge.R.string.utility_input_error_msg
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r9 = r41.getTitle()
            r5[r13] = r9
            java.lang.String r1 = r1.getString(r3, r5)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r3 = r7.H
            if (r3 == 0) goto L_0x04ff
            r3.c((java.lang.String) r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04ff:
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r15.concat(r1)
            android.view.View r1 = r0.findViewWithTag(r1)
            boolean r1 = r1 instanceof com.paytm.utility.RoboTextView
            if (r1 == 0) goto L_0x0527
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r15.concat(r1)
            android.view.View r1 = r0.findViewWithTag(r1)
            if (r1 == 0) goto L_0x0521
            r4 = r1
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            goto L_0x0527
        L_0x0521:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0527:
            java.lang.String r1 = java.lang.String.valueOf(r43)
            java.lang.String r1 = r14.concat(r1)
            android.view.View r0 = r0.findViewWithTag(r1)
            r3 = 0
            r5 = r4
            android.widget.TextView r5 = (android.widget.TextView) r5
            r1 = r40
            r2 = r41
            r4 = r0
            r1.a(r2, r3, r4, r5, r6)
        L_0x053f:
            return r13
        L_0x0540:
            java.lang.String r0 = r41.getConfigKey()
            if (r0 == 0) goto L_0x054b
            r7.b((java.lang.String) r0, (java.lang.String) r6)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x054b:
            java.lang.String r0 = r41.getTitle()     // Catch:{ Exception -> 0x0588 }
            if (r0 == 0) goto L_0x0590
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0588 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x0588 }
            int r1 = r1 - r5
            r2 = r1
            r1 = 0
            r3 = 0
        L_0x055b:
            if (r1 > r2) goto L_0x0579
            if (r3 != 0) goto L_0x0561
            r4 = r1
            goto L_0x0562
        L_0x0561:
            r4 = r2
        L_0x0562:
            char r4 = r0.charAt(r4)     // Catch:{ Exception -> 0x0588 }
            if (r4 > r10) goto L_0x056a
            r4 = 1
            goto L_0x056b
        L_0x056a:
            r4 = 0
        L_0x056b:
            if (r3 != 0) goto L_0x0574
            if (r4 != 0) goto L_0x0571
            r3 = 1
            goto L_0x055b
        L_0x0571:
            int r1 = r1 + 1
            goto L_0x055b
        L_0x0574:
            if (r4 == 0) goto L_0x0579
            int r2 = r2 + -1
            goto L_0x055b
        L_0x0579:
            int r2 = r2 + r5
            java.lang.CharSequence r0 = r0.subSequence(r1, r2)     // Catch:{ Exception -> 0x0588 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0588 }
            r7.a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0588 }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x0588 }
            goto L_0x0590
        L_0x0588:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x0590:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a(net.one97.paytm.recharge.model.v4.CJRInputFieldsItem, android.widget.LinearLayout, int, boolean):boolean");
    }

    private final void a(Context context, String str, String str2, CJRInputFieldsItem cJRInputFieldsItem) {
        if (this.M) {
            a(cJRInputFieldsItem, false, c((View) null), b((View) null), str2);
            az azVar = az.f61525a;
            String str3 = str2;
            az.a(str3, VERTICAL.UTILITIES, ERROR_TYPE.INLINE_ERROR);
        } else if (context != null) {
            az azVar2 = az.f61525a;
            az.a(context, ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, str, str2, 4);
        }
    }

    private final void a(String str, String str2) {
        try {
            this.t.put(str, str2);
        } catch (Exception e2) {
            com.paytm.utility.q.d(e2.getMessage());
        }
    }

    private final void b(String str, String str2) {
        try {
            this.u.put(str, str2);
        } catch (Exception e2) {
            com.paytm.utility.q.d(e2.getMessage());
        }
    }

    public final String getRechargeNumberFromKeyList() {
        return this.u.get("recharge_number");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getRechargeNumberKey() {
        /*
            r7 = this;
            java.util.List<net.one97.paytm.recharge.model.v4.CJRInputFieldsItem> r0 = r7.p
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x0013:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r0.next()
            r5 = r4
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r5 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r5
            if (r5 == 0) goto L_0x0027
            java.lang.String r5 = r5.getConfigKey()
            goto L_0x0028
        L_0x0027:
            r5 = r1
        L_0x0028:
            java.lang.String r6 = "recharge_number"
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r2)
            if (r5 == 0) goto L_0x0013
            r3.add(r4)
            goto L_0x0013
        L_0x0034:
            r1 = r3
            java.util.List r1 = (java.util.List) r1
        L_0x0037:
            if (r1 == 0) goto L_0x0054
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0054
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            if (r0 != 0) goto L_0x004d
            kotlin.g.b.k.a()
        L_0x004d:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r0
            java.lang.String r0 = r0.getTitle()
            return r0
        L_0x0054:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.getRechargeNumberKey():java.lang.String");
    }

    public final Map<String, String> a(boolean z2, boolean z3) {
        List<CJRProductsItem> products;
        Long productId;
        String b2 = b(z3);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        CJRProductList cJRProductList = this.C;
        if (!(cJRProductList == null || (products = cJRProductList.getProducts()) == null)) {
            for (CJRProductsItem cJRProductsItem : products) {
                List<CJRUtilityCheckboxItem> list = this.D;
                boolean z4 = false;
                Double d2 = null;
                if (list != null && list.size() > 0) {
                    List<CJRUtilityCheckboxItem> list2 = this.D;
                    if (list2 != null) {
                        for (CJRUtilityCheckboxItem cJRUtilityCheckboxItem : list2) {
                            long id = cJRUtilityCheckboxItem.getId();
                            Long productId2 = cJRProductsItem != null ? cJRProductsItem.getProductId() : null;
                            if (productId2 != null && id == productId2.longValue()) {
                                linkedHashMap.put(String.valueOf(cJRUtilityCheckboxItem.getId()), cJRUtilityCheckboxItem.getPrice());
                            }
                        }
                    }
                } else if (!(cJRProductsItem == null || (productId = cJRProductsItem.getProductId()) == null)) {
                    long longValue = productId.longValue();
                    if (kotlin.m.p.a("1", cJRProductsItem.getCheckboxFlowType(), true)) {
                        linkedHashMap.clear();
                        linkedHashMap.put(String.valueOf(longValue), b2);
                        return linkedHashMap;
                    } else if (z2) {
                        linkedHashMap.clear();
                        linkedHashMap.put(String.valueOf(longValue), b2);
                        return linkedHashMap;
                    } else {
                        CharSequence charSequence = b2;
                        if (charSequence == null || kotlin.m.p.a(charSequence)) {
                            z4 = true;
                        }
                        if (z4) {
                            CJRInputFieldsItem amountInputfieldObject = getAmountInputfieldObject();
                            if (amountInputfieldObject != null) {
                                d2 = amountInputfieldObject.getMin();
                            }
                            String valueOf = String.valueOf(d2);
                            String valueOf2 = String.valueOf(longValue);
                            if (!net.one97.paytm.recharge.common.utils.g.c(valueOf)) {
                                valueOf = "10.0";
                            }
                            linkedHashMap.put(valueOf2, valueOf);
                        } else {
                            linkedHashMap.put(String.valueOf(longValue), b2);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final JSONObject getMetaData() {
        return this.t;
    }

    public final Map<String, String> getKeyValueMap() {
        return this.u;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAmount() {
        /*
            r4 = this;
            android.widget.EditText r0 = r4.f62012d
            if (r0 == 0) goto L_0x000f
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.toString()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            boolean r1 = r4.j()
            if (r1 == 0) goto L_0x0031
            int r1 = r4.W
            if (r1 <= 0) goto L_0x0031
            boolean r1 = net.one97.paytm.recharge.common.utils.g.c(r0)
            if (r1 == 0) goto L_0x0031
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            double r0 = java.lang.Double.parseDouble(r0)
            int r2 = r4.W
            double r2 = (double) r2
            double r0 = r0 + r2
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0031:
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.e((java.lang.String) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.getAmount():java.lang.String");
    }

    public final String b(boolean z2) {
        Double min;
        Double min2;
        if (z2) {
            CJRInputFieldsItem amountInputfieldObject = getAmountInputfieldObject();
            if (amountInputfieldObject == null || (min2 = amountInputfieldObject.getMin()) == null) {
                return "10.0";
            }
            return String.valueOf(kotlin.j.e.a(min2.doubleValue()));
        } else if (!this.q) {
            return getAmount();
        } else {
            EditText editText = this.f62012d;
            if (editText != null && editText.getVisibility() == 0) {
                return getAmount();
            }
            CJRInputFieldsItem amountInputfieldObject2 = getAmountInputfieldObject();
            if (amountInputfieldObject2 == null || (min = amountInputfieldObject2.getMin()) == null) {
                return "10.0";
            }
            return String.valueOf(kotlin.j.e.a(min.doubleValue()));
        }
    }

    public final String getConvFeePaymentMethod() {
        ConvenienceFeeInputLayout convenienceFeeInputLayout = this.o;
        if (convenienceFeeInputLayout != null) {
            return convenienceFeeInputLayout.getSelectedPaymentMethod();
        }
        return null;
    }

    public final boolean i() {
        EditText editText = this.f62012d;
        return editText != null && editText.getVisibility() == 0;
    }

    private void b() {
        EditText editText = this.f62012d;
        if (editText != null) {
            ai.b(editText);
        }
    }

    private void e() {
        this.S = 0;
        this.R = false;
        this.P = null;
        this.Q = null;
    }

    public final CJRUtilityAlertV2 getAlertObject() {
        List<CJRProductsItem> products;
        CJRProductList cJRProductList = this.C;
        if (!(cJRProductList == null || (products = cJRProductList.getProducts()) == null || !(!products.isEmpty()))) {
            CJRProductList cJRProductList2 = this.C;
            List<CJRProductsItem> products2 = cJRProductList2 != null ? cJRProductList2.getProducts() : null;
            if (products2 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = products2.get(0);
            if (cJRProductsItem != null) {
                return cJRProductsItem.getAlertObject();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void f() {
        EditText editText = this.f62012d;
        if (editText != null && this.q) {
            if (editText == null) {
                kotlin.g.b.k.a();
            }
            if (editText.getVisibility() == 0) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    kotlin.g.b.k.a((Object) childAt, "getChildAt(i)");
                    if (childAt.getTag() != null) {
                        View childAt2 = getChildAt(i2);
                        kotlin.g.b.k.a((Object) childAt2, "getChildAt(i)");
                        if (childAt2.getTag() instanceof Boolean) {
                            View childAt3 = getChildAt(i2);
                            kotlin.g.b.k.a((Object) childAt3, "getChildAt(i)");
                            Object tag = childAt3.getTag();
                            if (tag == null) {
                                throw new kotlin.u("null cannot be cast to non-null type kotlin.Boolean");
                            } else if (!((Boolean) tag).booleanValue()) {
                            }
                        } else {
                            continue;
                        }
                        i2++;
                    }
                    View childAt4 = getChildAt(i2);
                    kotlin.g.b.k.a((Object) childAt4, "getChildAt(i)");
                    childAt4.setVisibility(8);
                    removeViewAt(i2);
                    i2--;
                    i2++;
                }
                this.o = null;
                this.f62012d = null;
                this.z = null;
                b bVar = this.J;
                if (bVar != null) {
                    bVar.C();
                }
                this.E = false;
                e();
                this.U = false;
                this.k = null;
                this.ab = false;
                g();
                a aVar = this.H;
                if (aVar != null) {
                    aVar.N();
                }
                a aVar2 = this.H;
                if (aVar2 != null) {
                    aVar2.G();
                }
            }
        }
        a aVar3 = this.H;
        if (aVar3 != null) {
            aVar3.M();
        }
    }

    private final void g() {
        if (this.ae) {
            TextView textView = this.aa;
            if (textView != null) {
                Context context = getContext();
                kotlin.g.b.k.a((Object) context, "context");
                textView.setText(context.getResources().getString(R.string.view_sample_bill));
            }
            TextView textView2 = this.aa;
            if (textView2 != null) {
                textView2.setOnClickListener(new u(this));
                return;
            }
            return;
        }
        TextView textView3 = this.aa;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    static final class u implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62085a;

        u(CustomInputLinearLayout customInputLinearLayout) {
            this.f62085a = customInputLinearLayout;
        }

        public final void onClick(View view) {
            if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked("view_my_bill")) {
                kotlin.g.b.k.a((Object) view, "it");
                if (view.getTag() instanceof String) {
                    Object tag = view.getTag();
                    if (tag != null) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            a mCustomInputLayoutListner = this.f62085a.getMCustomInputLayoutListner();
                            if (mCustomInputLayoutListner != null) {
                                mCustomInputLayoutListner.O();
                            }
                            a mCustomInputLayoutListner2 = this.f62085a.getMCustomInputLayoutListner();
                            if (mCustomInputLayoutListner2 != null) {
                                mCustomInputLayoutListner2.P();
                            }
                            CustomInputLinearLayout customInputLinearLayout = this.f62085a;
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            String string = this.f62085a.getContext().getString(R.string.sample_bill);
                            kotlin.g.b.k.a((Object) string, "context.getString(R.string.sample_bill)");
                            CustomInputLinearLayout.a(customInputLinearLayout, str, string);
                            return;
                        }
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
    }

    public static final class s implements k.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62083a;

        s(CustomInputLinearLayout customInputLinearLayout) {
            this.f62083a = customInputLinearLayout;
        }

        public final void b(List<CJRUtilityCheckboxItem> list) {
            CustomInputLinearLayout.a(this.f62083a, (List) list);
            this.f62083a.setMultipleProductAmount(list);
        }

        public final void c(List<CJRUtilityCheckboxItem> list) {
            CustomInputLinearLayout.a(this.f62083a, (List) list);
            this.f62083a.setMultipleProductAmount(list);
        }
    }

    public final void k() {
        this.v = null;
        this.w = null;
        this.k = null;
        this.ab = false;
        this.aa = null;
        this.W = 0;
        this.p = null;
        b();
        EditText editText = this.f62012d;
        if (editText != null) {
            editText.setVisibility(8);
        }
        this.f62012d = null;
        this.C = null;
        this.o = null;
        this.f62014f = false;
        List<CJRUtilityCheckboxItem> list = this.D;
        if (list != null) {
            list.clear();
        }
        List<CJRDisplayValues> list2 = this.A;
        if (list2 != null) {
            list2.clear();
        }
        this.E = false;
        this.f62014f = false;
        this.U = false;
        this.ag = null;
        this.I.clear();
        this.m = false;
    }

    /* access modifiers changed from: private */
    public final void setMultipleProductAmount(List<? extends CJRUtilityCheckboxItem> list) {
        double d2;
        if (list != null) {
            d2 = 0.0d;
            for (CJRUtilityCheckboxItem cJRUtilityCheckboxItem : list) {
                if (cJRUtilityCheckboxItem.isChecked() && !TextUtils.isEmpty(cJRUtilityCheckboxItem.getPrice())) {
                    try {
                        d2 += Double.parseDouble(cJRUtilityCheckboxItem.getPrice());
                    } catch (NumberFormatException e2) {
                        com.paytm.utility.q.d(e2.getMessage());
                    }
                }
            }
        } else {
            d2 = 0.0d;
        }
        if (d2 == 0.0d) {
            a aVar = this.H;
            if (aVar != null) {
                aVar.c(false);
            }
        } else {
            a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.c(true);
            }
        }
        double b2 = com.paytm.utility.b.b(d2);
        EditText editText = this.f62012d;
        if (editText != null) {
            editText.setText(net.one97.paytm.recharge.common.utils.z.a(b2));
        }
        EditText editText2 = this.f62012d;
        if (editText2 != null) {
            editText2.setFocusable(false);
        }
        EditText editText3 = this.f62012d;
        if (editText3 != null) {
            editText3.setEnabled(false);
        }
        EditText editText4 = this.f62012d;
        if (editText4 != null) {
            editText4.setFocusable(true);
        }
        a aVar3 = this.H;
        if (aVar3 != null) {
            aVar3.G();
        }
    }

    private final List<CJRUtilityCheckboxItem> a(ArrayList<CJRCartProduct> arrayList) {
        List<CJRUpdatedValue> updatedValues;
        String checkBoxKey;
        ArrayList arrayList2 = new ArrayList();
        if (this.C != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRCartProduct cJRCartProduct = arrayList.get(0);
            kotlin.g.b.k.a((Object) cJRCartProduct, "cartItems[0]");
            CJRServiceActions a2 = net.one97.paytm.recharge.widgets.c.d.a(cJRCartProduct.getServiceOptions());
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (net.one97.paytm.recharge.di.helper.c.bz()) {
                CJRCartProduct cJRCartProduct2 = arrayList.get(0);
                kotlin.g.b.k.a((Object) cJRCartProduct2, "cartItems[0]");
                CJRServiceOptions serviceOptions = cJRCartProduct2.getServiceOptions();
                kotlin.g.b.k.a((Object) serviceOptions, "cartItems[0].serviceOptions");
                if (serviceOptions.getActions() != null) {
                    CJRCartProduct cJRCartProduct3 = arrayList.get(0);
                    kotlin.g.b.k.a((Object) cJRCartProduct3, "cartItems[0]");
                    CJRServiceOptions serviceOptions2 = cJRCartProduct3.getServiceOptions();
                    kotlin.g.b.k.a((Object) serviceOptions2, "cartItems[0].serviceOptions");
                    if (serviceOptions2.getActions().size() > 0) {
                        CJRCartProduct cJRCartProduct4 = arrayList.get(0);
                        kotlin.g.b.k.a((Object) cJRCartProduct4, "cartItems[0]");
                        CJRServiceOptions serviceOptions3 = cJRCartProduct4.getServiceOptions();
                        kotlin.g.b.k.a((Object) serviceOptions3, "cartItems[0].serviceOptions");
                        a2 = serviceOptions3.getActions().get(0);
                    }
                }
                a2 = null;
            }
            if (!(a2 == null || a2.getUpdatedValues() == null || a2.getUpdatedValues().size() <= 0 || (updatedValues = a2.getUpdatedValues()) == null)) {
                for (CJRUpdatedValue cJRUpdatedValue : updatedValues) {
                    CJRProductList cJRProductList = this.C;
                    if (cJRProductList == null) {
                        kotlin.g.b.k.a();
                    }
                    List<CJRProductsItem> products = cJRProductList.getProducts();
                    if (products != null) {
                        for (CJRProductsItem cJRProductsItem : products) {
                            if (!(cJRProductsItem == null || (checkBoxKey = cJRProductsItem.getCheckBoxKey()) == null)) {
                                boolean z2 = true;
                                if (!kotlin.m.p.a(checkBoxKey, "N/A", true)) {
                                    kotlin.g.b.k.a((Object) cJRUpdatedValue, "updatedValue");
                                    if (a(cJRProductsItem, cJRUpdatedValue.getFeeTypes()) || a(cJRProductsItem, cJRUpdatedValue.getChallanType())) {
                                        CJRUtilityCheckboxItem cJRUtilityCheckboxItem = new CJRUtilityCheckboxItem();
                                        if (TextUtils.isEmpty(cJRUpdatedValue.getLabel())) {
                                            cJRUtilityCheckboxItem.setName(cJRProductsItem.getDisplayName());
                                        } else {
                                            cJRUtilityCheckboxItem.setName(cJRUpdatedValue.getLabel());
                                        }
                                        String feeTypeVisibility = cJRUpdatedValue.getFeeTypeVisibility();
                                        if (TextUtils.isEmpty(feeTypeVisibility) || kotlin.m.p.a("none", feeTypeVisibility, true)) {
                                            feeTypeVisibility = cJRProductsItem.getFeeTypeVisibility();
                                        }
                                        try {
                                            Long productId = cJRProductsItem.getProductId();
                                            if (productId != null) {
                                                cJRUtilityCheckboxItem.setId(productId.longValue());
                                            }
                                        } catch (Exception unused) {
                                        }
                                        cJRUtilityCheckboxItem.setPrice(String.valueOf(cJRUpdatedValue.getBillAmount()));
                                        cJRUtilityCheckboxItem.setInputMode(feeTypeVisibility);
                                        cJRUtilityCheckboxItem.setPriceEditable(cJRUpdatedValue.getBillamountEditable());
                                        cJRUtilityCheckboxItem.setDisplayValues(cJRUpdatedValue.getDisplayValues());
                                        cJRUtilityCheckboxItem.setShowDisplayValues(cJRProductsItem.isShowDisplayValuesEnabled());
                                        HashMap hashMap = new HashMap();
                                        CharSequence checkBoxKey2 = cJRProductsItem.getCheckBoxKey();
                                        if (checkBoxKey2 != null && !kotlin.m.p.a(checkBoxKey2)) {
                                            z2 = false;
                                        }
                                        if (!z2) {
                                            hashMap.put("checkBoxKey", cJRProductsItem.getCheckBoxKey());
                                        }
                                        if (cJRUpdatedValue.getDisplayValues() != null) {
                                            for (CJRDisplayValues next : cJRUpdatedValue.getDisplayValues()) {
                                                kotlin.g.b.k.a((Object) next, "displayValue");
                                                if (!TextUtils.isEmpty(next.getLabel()) && !TextUtils.isEmpty(next.getValue())) {
                                                    String label = next.getLabel();
                                                    kotlin.g.b.k.a((Object) label, "displayValue.label");
                                                    String value = next.getValue();
                                                    kotlin.g.b.k.a((Object) value, "displayValue.value");
                                                    hashMap.put(label, value);
                                                }
                                            }
                                        }
                                        cJRUtilityCheckboxItem.setMetaData(hashMap);
                                        arrayList2.add(cJRUtilityCheckboxItem);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    private static boolean a(CJRProductsItem cJRProductsItem, String str) {
        if (cJRProductsItem != null) {
            CharSequence checkBoxKey = cJRProductsItem.getCheckBoxKey();
            return !(checkBoxKey == null || checkBoxKey.length() == 0) && kotlin.m.p.a(cJRProductsItem.getCheckBoxKey(), str, true);
        }
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62088a;

        x(CustomInputLinearLayout customInputLinearLayout) {
            this.f62088a = customInputLinearLayout;
        }

        public final void onClick(View view) {
            this.f62088a.r();
        }
    }

    /* access modifiers changed from: private */
    public final void r() {
        EditText editText;
        List<? extends CJRPaymentOptions> list = this.G;
        if (list != null && list.size() > 0) {
            if (this.f62016h == null && (editText = this.f62012d) != null) {
                editText.setText("");
            }
            a aVar = this.H;
            if (aVar != null) {
                aVar.a(this.G, this.f62016h);
            }
            this.s = false;
            EditText editText2 = this.f62012d;
            if (editText2 != null) {
                editText2.setFocusable(false);
            }
            EditText editText3 = this.f62012d;
            if (editText3 != null) {
                editText3.setLongClickable(false);
            }
        }
    }

    public final boolean l() {
        EditText editText = this.f62012d;
        return editText != null && editText.isFocusable();
    }

    private final void setSingleProductAmount(CJRServiceActions cJRServiceActions) {
        EditText editText;
        a aVar = this.H;
        boolean z2 = true;
        if (aVar != null) {
            aVar.d(true);
        }
        String billAmount = cJRServiceActions.getBillAmount();
        EditText editText2 = this.f62012d;
        if (editText2 != null) {
            editText2.setLongClickable(false);
        }
        if (!d(billAmount) && (editText = this.f62012d) != null) {
            editText.setText(net.one97.paytm.recharge.common.utils.z.c(billAmount));
        }
        if (cJRServiceActions.isBillAmountEditable()) {
            EditText editText3 = this.f62012d;
            if (editText3 != null) {
                editText3.setEnabled(true);
            }
            EditText editText4 = this.f62012d;
            if (editText4 != null) {
                editText4.setFocusable(true);
            }
            EditText editText5 = this.f62012d;
            if (editText5 != null) {
                editText5.requestFocus();
                return;
            }
            return;
        }
        EditText editText6 = this.f62012d;
        if (editText6 != null) {
            editText6.setFocusable(false);
        }
        EditText editText7 = this.f62012d;
        CharSequence text = editText7 != null ? editText7.getText() : null;
        if (!(text == null || text.length() == 0)) {
            z2 = false;
        }
        if (z2) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UI_DISTORT);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.VERIFY_CALL.name());
            }
            a2.setErrorMsg(getContext().getString(R.string.hawkeye_amount_diabled_with_zero_amount));
            az azVar = az.f61525a;
            az.a(a2);
        }
        if (kotlin.g.b.k.a((Object) billAmount, (Object) "0")) {
            a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.c(false);
            }
            a aVar3 = this.H;
            if (aVar3 != null) {
                String string = getContext().getString(R.string.no_outstanding);
                kotlin.g.b.k.a((Object) string, "context.getString(R.string.no_outstanding)");
                aVar3.b(string);
            }
            a aVar4 = this.H;
            if (aVar4 != null) {
                aVar4.d(false);
            }
        }
        if (d(billAmount)) {
            a aVar5 = this.H;
            if (aVar5 != null) {
                aVar5.c(false);
            }
            a aVar6 = this.H;
            if (aVar6 != null) {
                aVar6.d(false);
            }
        }
    }

    public final ConvenienceFeeInputLayout getConvenienceFeeLayout() {
        return this.o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getGroupFieldValuesForGA();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getGroupFieldInputValue() {
        /*
            r1 = this;
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r1.f62011c
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getGroupFieldValuesForGA()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.getGroupFieldInputValue():java.lang.String");
    }

    public final boolean m() {
        return i() && !TextUtils.isEmpty(getAmount());
    }

    private static void a(EditText editText, CJRInputFieldsItem cJRInputFieldsItem) {
        String maxFieldLength = cJRInputFieldsItem.getMaxFieldLength();
        if (!TextUtils.isEmpty(maxFieldLength)) {
            if (maxFieldLength == null) {
                try {
                    kotlin.g.b.k.a();
                } catch (Exception e2) {
                    com.paytm.utility.q.d(e2.getMessage());
                    return;
                }
            }
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.parseInt(maxFieldLength))});
        }
    }

    public final void setAmountFieldInlineMessage() {
        this.M = true;
    }

    public void setAmountOnAmountField(String str) {
        kotlin.g.b.k.c(str, "amount");
        EditText editText = this.f62012d;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setAmountFromBrowsePlan(String str) {
        kotlin.g.b.k.c(str, "amount");
        setAmountOnAmountField(str);
    }

    public final void setLayoutClickListener(a aVar) {
        this.H = aVar;
    }

    public final String getNextValidConfigKey() {
        do {
        } while (e("recharge_number" + "_2"));
        return "recharge_number" + "_2";
    }

    private boolean e(String str) {
        kotlin.g.b.k.c(str, "configKey");
        List<CJRInputFieldsItem> list = this.p;
        if (list != null && (!list.isEmpty())) {
            List<CJRInputFieldsItem> list2 = this.p;
            if (list2 == null) {
                kotlin.g.b.k.a();
            }
            for (CJRInputFieldsItem cJRInputFieldsItem : list2) {
                if (kotlin.m.p.a(str, cJRInputFieldsItem != null ? cJRInputFieldsItem.getConfigKey() : null, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final CJRInputFieldsItem b(String str) {
        kotlin.g.b.k.c(str, "configKey");
        List<CJRInputFieldsItem> list = this.p;
        if (list != null) {
            for (CJRInputFieldsItem cJRInputFieldsItem : list) {
                if (kotlin.m.p.a(str, cJRInputFieldsItem != null ? cJRInputFieldsItem.getConfigKey() : null, false)) {
                    return cJRInputFieldsItem;
                }
            }
        }
        return null;
    }

    private CJRInputFieldsItem f(String str) {
        kotlin.g.b.k.c(str, "type");
        List<CJRInputFieldsItem> list = this.p;
        if (list != null) {
            for (CJRInputFieldsItem cJRInputFieldsItem : list) {
                if (kotlin.m.p.a(str, cJRInputFieldsItem != null ? cJRInputFieldsItem.getType() : null, false)) {
                    return cJRInputFieldsItem;
                }
            }
        }
        return null;
    }

    public final int c(String str) {
        kotlin.g.b.k.c(str, "configKey");
        List<CJRInputFieldsItem> list = this.p;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRInputFieldsItem cJRInputFieldsItem = list.get(i2);
            if (kotlin.m.p.a(str, cJRInputFieldsItem != null ? cJRInputFieldsItem.getConfigKey() : null, false)) {
                return i2;
            }
        }
        return -1;
    }

    public final JSONObject getJSONObjectForViewMyBillRequest() {
        List<CJRProductsItem> products;
        JSONObject jSONObject = new JSONObject();
        CJRProductList cJRProductList = this.C;
        if (!(cJRProductList == null || (products = cJRProductList.getProducts()) == null || !(!products.isEmpty()))) {
            CJRProductList cJRProductList2 = this.C;
            if (cJRProductList2 == null) {
                kotlin.g.b.k.a();
            }
            List<CJRProductsItem> products2 = cJRProductList2.getProducts();
            if (products2 == null) {
                kotlin.g.b.k.a();
            }
            CJRProductsItem cJRProductsItem = products2.get(0);
            jSONObject.put(CLPConstants.PRODUCT_ID, cJRProductsItem != null ? cJRProductsItem.getProductId() : null);
        }
        Map<String, String> map = this.u;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    public final void a(CJRMyBillData cJRMyBillData) {
        kotlin.g.b.k.c(cJRMyBillData, "myBillData");
        CJRMyBillDetails billDetails = cJRMyBillData.getBillDetails();
        ArrayList<String> arrayList = null;
        if (net.one97.paytm.recharge.common.utils.g.c(billDetails != null ? billDetails.getPdfUrl() : null)) {
            CJRMyBillDetails billDetails2 = cJRMyBillData.getBillDetails();
            if (billDetails2 != null) {
                arrayList = billDetails2.getImageUrls();
            }
            Collection collection = arrayList;
            if (!(collection == null || collection.isEmpty())) {
                this.k = cJRMyBillData;
                Context context = getContext();
                CJRMyBillDetails billDetails3 = cJRMyBillData.getBillDetails();
                if (billDetails3 == null) {
                    kotlin.g.b.k.a();
                }
                String pdfUrl = billDetails3.getPdfUrl();
                if (pdfUrl == null) {
                    kotlin.g.b.k.a();
                }
                String c2 = com.paytm.utility.b.c(context, pdfUrl);
                if (!this.ab) {
                    CJRMyBillDetails billDetails4 = cJRMyBillData.getBillDetails();
                    if (billDetails4 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!billDetails4.isWebView()) {
                        a aVar = this.H;
                        if (aVar != null) {
                            if (aVar == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) c2, "pdfUrl");
                            this.ab = aVar.g(c2);
                            if (!this.ab) {
                                return;
                            }
                        } else {
                            n();
                            return;
                        }
                    }
                }
                n();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getBillDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r5 = this;
            net.one97.paytm.recharge.model.v4.CJRMyBillData r0 = r5.k
            if (r0 == 0) goto L_0x000f
            net.one97.paytm.recharge.model.v4.CJRMyBillDetails r0 = r0.getBillDetails()
            if (r0 == 0) goto L_0x000f
            java.util.ArrayList r0 = r0.getImageUrls()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r0 != 0) goto L_0x008e
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r5.getContext()
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRViewPageWebViewActivity> r4 = net.one97.paytm.recharge.common.activity.AJRViewPageWebViewActivity.class
            r0.<init>(r3, r4)
            net.one97.paytm.recharge.model.v4.CJRMyBillData r3 = r5.k
            if (r3 == 0) goto L_0x0067
            net.one97.paytm.recharge.model.v4.CJRMyBillDetails r3 = r3.getBillDetails()
            if (r3 == 0) goto L_0x0067
            boolean r3 = r3.isWebView()
            if (r3 != r2) goto L_0x0067
            java.lang.String r3 = "open_single_webpage"
            r0.putExtra(r3, r2)
            net.one97.paytm.recharge.model.v4.CJRMyBillData r2 = r5.k
            if (r2 != 0) goto L_0x0049
            kotlin.g.b.k.a()
        L_0x0049:
            net.one97.paytm.recharge.model.v4.CJRMyBillDetails r2 = r2.getBillDetails()
            if (r2 != 0) goto L_0x0052
            kotlin.g.b.k.a()
        L_0x0052:
            java.util.ArrayList r2 = r2.getImageUrls()
            if (r2 != 0) goto L_0x005b
            kotlin.g.b.k.a()
        L_0x005b:
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "web_page_url"
            r0.putExtra(r2, r1)
            goto L_0x0080
        L_0x0067:
            net.one97.paytm.recharge.model.v4.CJRMyBillData r1 = r5.k
            if (r1 != 0) goto L_0x006e
            kotlin.g.b.k.a()
        L_0x006e:
            net.one97.paytm.recharge.model.v4.CJRMyBillDetails r1 = r1.getBillDetails()
            if (r1 != 0) goto L_0x0077
            kotlin.g.b.k.a()
        L_0x0077:
            java.util.ArrayList r1 = r1.getImageUrls()
            java.lang.String r2 = "list_of_urls"
            r0.putStringArrayListExtra(r2, r1)
        L_0x0080:
            java.lang.String r1 = "title"
            java.lang.String r2 = "My Bill"
            r0.putExtra(r1, r2)
            android.content.Context r1 = r5.getContext()
            r1.startActivity(r0)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.n():void");
    }

    public final void setAmountFieldMessage(String str) {
        View view = this.f62015g;
        if (view != null) {
            setInputFieldMessage$default(this, b(view), str, (Boolean) null, 4, (Object) null);
        }
    }

    public void setAmountFetchMessage(String str) {
        kotlin.g.b.k.c(str, "amount");
        this.ad = str;
        View view = this.ac;
        if (view != null) {
            view.setVisibility(0);
        }
        this.l = true;
        setAmountFieldMessage(getContext().getString(R.string.amount_autofetch_message, new Object[]{str}));
    }

    public final void o() {
        this.ad = null;
        p();
        this.l = false;
        setAmountFieldMessage((String) null);
    }

    static final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomInputLinearLayout f62084a;

        t(CustomInputLinearLayout customInputLinearLayout) {
            this.f62084a = customInputLinearLayout;
        }

        public final void run() {
            View amountInfoView = this.f62084a.getAmountInfoView();
            if (amountInfoView != null) {
                amountInfoView.setVisibility(8);
            }
        }
    }

    public final void p() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.postDelayed(new t(this), 200);
        }
    }

    public final void q() {
        EditText editText = this.f62012d;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    public final boolean j() {
        if (this.f62013e && !this.U) {
            return i() && !TextUtils.isEmpty(getConvFeePaymentMethod());
        }
        if (this.S == 1) {
            return false;
        }
        return i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r9) {
        /*
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r9.C
            if (r0 == 0) goto L_0x00a9
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x00a9
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x00a9
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r9.C
            if (r0 != 0) goto L_0x001b
            kotlin.g.b.k.a()
        L_0x001b:
            java.util.List r0 = r0.getProducts()
            if (r0 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x00a9
            net.one97.paytm.recharge.common.utils.ak$b r2 = net.one97.paytm.recharge.common.utils.ak.f61510a
            java.lang.String r2 = r0.getOperator()
            java.lang.String r3 = "recharge_number"
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r4 = r9.b((java.lang.String) r3)
            r5 = 0
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r4.getTitle()
            goto L_0x0042
        L_0x0041:
            r4 = r5
        L_0x0042:
            java.lang.String r6 = "configKey"
            kotlin.g.b.k.c(r3, r6)
            java.util.Map<java.lang.String, java.lang.String> r6 = r9.u
            boolean r6 = r6.containsKey(r3)
            if (r6 == 0) goto L_0x0061
            java.util.Map<java.lang.String, java.lang.String> r6 = r9.u
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r3 = r5
        L_0x0062:
            java.lang.String r0 = r0.getImageUrl()
            org.json.JSONObject r5 = r9.getJSONObjectForViewMyBillRequest()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = r9.getNextValidConfigKey()
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r8 = "bottom_sheet_type"
            r7.putInt(r8, r1)
            java.lang.String r1 = "operator"
            r7.putString(r1, r2)
            java.lang.String r1 = "input_field_title"
            r7.putString(r1, r4)
            java.lang.String r1 = "input_field_value"
            r7.putString(r1, r3)
            java.lang.String r1 = "operator_icon_url"
            r7.putString(r1, r0)
            java.lang.String r0 = "request_body_json_string"
            r7.putString(r0, r5)
            java.lang.String r0 = "mobile_number_config_key"
            r7.putString(r0, r6)
            net.one97.paytm.recharge.common.utils.ak r0 = new net.one97.paytm.recharge.common.utils.ak
            r0.<init>()
            r0.setArguments(r7)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r9 = r9.H
            if (r9 == 0) goto L_0x00a9
            r9.a((net.one97.paytm.recharge.common.utils.ak) r0)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a(net.one97.paytm.recharge.common.widget.CustomInputLinearLayout):void");
    }

    public static final /* synthetic */ void a(CustomInputLinearLayout customInputLinearLayout, String str, String str2) {
        Context context = customInputLinearLayout.getContext();
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        Intent intent = new Intent(context, net.one97.paytm.recharge.di.helper.a.c());
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra(UpiConstants.FROM, "electricity");
        customInputLinearLayout.getContext().startActivity(intent);
    }

    public static final /* synthetic */ void a(CustomInputLinearLayout customInputLinearLayout, List list) {
        List<CJRUtilityCheckboxItem> list2;
        List<CJRUtilityCheckboxItem> list3 = customInputLinearLayout.D;
        if (list3 != null) {
            list3.clear();
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CJRUtilityCheckboxItem cJRUtilityCheckboxItem = (CJRUtilityCheckboxItem) it2.next();
                if (cJRUtilityCheckboxItem.isChecked() && (list2 = customInputLinearLayout.D) != null) {
                    list2.add(cJRUtilityCheckboxItem);
                }
            }
        }
    }
}
