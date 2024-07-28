package net.one97.paytm.recharge.creditcard.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.at;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.o;
import net.one97.paytm.recharge.common.utils.q;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel;
import net.one97.paytm.recharge.model.creditcard.CJRSavedCreditCardsModel;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends net.one97.paytm.recharge.common.h.g implements ai {
    public y<List<CJRCreditCardModelV8>> O = new y<>();
    public y<CJRTaggedObservable<Data<CJRCreditCardModelV8>>> P = new y<>();
    public y<Data<NetworkCustomError>> Q = new y<>();
    public CJRCategoryData R;
    boolean S;
    boolean T;
    public CJRCreditCardModelV8 U;
    public y<CJRRechargeCart> V = new y<>();
    public net.one97.paytm.recharge.creditcard.v4.a W;
    public int X = -1;
    public y<CJRPersonalInsurance> Y = new y<>();
    /* access modifiers changed from: private */
    public List<IJRDataModel> Z;
    private List<CJRCreditCardModelV8> aa;
    private boolean ab;
    private Map<IJRDataModel, CJRAggsItem> ac = new LinkedHashMap();
    private Map<IJRDataModel, String> ad = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final String ae = "credit_card";

    /* renamed from: net.one97.paytm.recharge.creditcard.c.a$a  reason: collision with other inner class name */
    static final class C1202a<T1, T2, R> implements io.reactivex.rxjava3.d.c<List<? extends CJRFrequentOrder>, CJRSavedCreditCardsModel, List<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62458a;

        C1202a(a aVar) {
            this.f62458a = aVar;
        }

        public final /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
            CJRSavedCreditCardsModel cJRSavedCreditCardsModel = (CJRSavedCreditCardsModel) obj2;
            kotlin.g.b.k.a((Object) cJRSavedCreditCardsModel, "t2");
            return a.a((List) obj, cJRSavedCreditCardsModel);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CJRItem cJRItem, net.one97.paytm.recharge.common.b.c cVar, w wVar, kotlin.k.e<x> eVar, net.one97.paytm.recharge.ordersummary.h.d dVar) {
        super(cJRItem, cVar, wVar, eVar, dVar);
        kotlin.g.b.k.c(cJRItem, "rechargeItem");
        kotlin.g.b.k.c(cVar, "rechargeRepo");
        kotlin.g.b.k.c(wVar, "rechargeProceedHelper");
        kotlin.g.b.k.c(eVar, "errorHandler");
        kotlin.g.b.k.c(dVar, "gtmEventHelper");
    }

    public final void b(CJRRechargeErrorModel cJRRechargeErrorModel) {
        String str;
        Long categoryId;
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        kotlin.g.b.k.c(cJRRechargeErrorModel2, "errorModel");
        CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
        }
        cJRRechargeErrorModel2.setVerticalName(VERTICAL.UTILITIES);
        cJRRechargeErrorModel2.setErrorType(ERROR_TYPE.UNDEFINED);
        CJRCategoryData categoryData = this.f61409b.getCategoryData();
        if (categoryData == null || (categoryId = categoryData.getCategoryId()) == null || (str = String.valueOf(categoryId.longValue())) == null) {
            str = this.r.getCategoryId();
        }
        cJRRechargeErrorModel2.setCategoryId(str);
        cJRRechargeErrorModel2.setProductId((String) null);
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = this.ae;
        }
        cJRRechargeErrorModel2.setScreenName(a2);
        cJRRechargeErrorModel2.setUserFacing(a.b.USER_FACING);
        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        cJRRechargeErrorModel2.setFlowName(flowName);
    }

    public final y<CJROffers> a(String str, String str2, net.one97.paytm.recharge.common.f.d dVar, boolean z, String str3, String str4, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, AppConstants.SSO_TOKEN);
        kotlin.g.b.k.c(dVar, "volleyRequest");
        kotlin.g.b.k.c(str3, "defaultParam");
        kotlin.g.b.k.c(str4, "categoryId");
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.v());
        sb.append(str4);
        net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.w());
        if (p.a((CharSequence) sb, (CharSequence) "?", false)) {
            String str5 = null;
            if (p.a((CharSequence) str3, (CharSequence) "?", false)) {
                str5 = p.a(str3, "?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, false);
            }
            if (str5 != null) {
                str3 = str5;
            }
            sb.append(str3);
        } else {
            sb.append(str3);
        }
        sb.append("&sortType=2");
        if (z) {
            sb.append("&isReseller=true");
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(AppConstants.SSO_TOKEN, str2);
        }
        String sb2 = sb.toString();
        kotlin.g.b.k.a((Object) sb2, "offerUrl.toString()");
        if (URLUtil.isValidUrl(sb2)) {
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, sb2, this, new CJROffers(), hashMap, obj));
        } else {
            a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new at(new ap()), obj);
        }
        return this.k;
    }

    public static String a(String str) {
        kotlin.g.b.k.c(str, "creditCardNumber");
        String replace = new kotlin.m.l("[^0-9X]").replace((CharSequence) str, "");
        CharSequence charSequence = replace;
        if (p.a(charSequence, '-', false)) {
            replace = new kotlin.m.l("-").replace(charSequence, "");
        } else if (p.a(charSequence, ' ', false)) {
            replace = new kotlin.m.l(" ").replace(charSequence, "");
        }
        if (replace != null) {
            String substring = replace.substring(0, 6);
            kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static String b(String str) {
        kotlin.g.b.k.c(str, "creditCardNumber");
        String substring = str.substring(str.length() - 4, str.length());
        kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = "XXXXXXXXXXXXXXXXXXXX".substring(0, str.length() - 4);
        kotlin.g.b.k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2 + substring;
    }

    public static final class g implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f62465a;

        public g(ai aiVar) {
            this.f62465a = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            this.f62465a.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            this.f62465a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public static final class k extends net.one97.paytm.recharge.common.e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROfferCode f62478b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62479c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f62480d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(a aVar, CJROfferCode cJROfferCode, String str, Object obj, ai aiVar, String str2, Object obj2) {
            super(aiVar, str2, obj2);
            this.f62477a = aVar;
            this.f62478b = cJROfferCode;
            this.f62479c = str;
            this.f62480d = obj;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String str2 = str;
            kotlin.g.b.k.c(str, "tag");
            try {
                net.one97.paytm.recharge.ordersummary.h.d dVar = this.f62477a.v;
                String a2 = this.f62477a.ae;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f62478b.getCode());
                sb.append("/");
                sb.append(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, "apply_promocode_failed", "", sb.toString(), (Object) null, (Object) null, (Object) null, 112);
            } catch (Exception unused) {
            }
            this.f62477a.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }
    }

    public static void a(Context context, String str, JSONObject jSONObject, ai aiVar, Object obj) {
        Context context2 = context;
        Object obj2 = obj;
        kotlin.g.b.k.c(context2, "context");
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(jSONObject, "jsonCart");
        kotlin.g.b.k.c(aiVar, "removePromoListener");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, context2);
        kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.addS…nHeader(headers, context)");
        az azVar = az.f61525a;
        String a3 = az.a(jSONObject);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String s = com.paytm.utility.b.s(context2, net.one97.paytm.recharge.di.helper.c.c(a3));
        if (com.paytm.utility.b.c(context)) {
            if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                cJRRechargeErrorModel.setScreenName("Credit cardPromo");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                String a4 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    flowName.setRequestBody(a4);
                }
            }
            net.one97.paytm.recharge.common.f.c cVar2 = r0;
            net.one97.paytm.recharge.common.f.c cVar3 = new net.one97.paytm.recharge.common.f.c(str, s, aiVar, new CJRRechargeCart(), (Map) null, a2, jSONObject.toString(), (a.C0715a) null, (a.c) null, a.b.USER_FACING, "Credit cardPromo", (String) null, obj, 5000, 0, 18816);
            String str2 = ba.f61539a;
            kotlin.g.b.k.a((Object) str2, "RechargeUtils.VOLLEY_REQ_TAG");
            net.one97.paytm.recharge.common.f.c cVar4 = cVar2;
            cVar4.a(str2);
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(cVar4);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0007: MOVE  (r2v2 java.util.Collection) = 
          (r2v1 java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void c(java.lang.String r2) {
        /*
            r1 = this;
            r0 = 0
            java.util.List r2 = b((java.lang.String) r2, (java.lang.String) r0)
            if (r2 == 0) goto L_0x0015
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0015
            boolean r2 = r2.isEmpty()
            r0 = 1
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0015
            r1.S = r0
        L_0x0015:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.c(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static List<CJRFrequentOrder> b(String str, String str2) {
        q qVar = q.f61722a;
        return q.a(str, str2);
    }

    public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, Map<String, ? extends View> map) {
        kotlin.g.b.k.c(cJRCreditCardModelV8, "cardModel");
        net.one97.paytm.recharge.creditcard.v4.a aVar = this.W;
        if ((aVar != null ? aVar.d() : null) == null || TextUtils.isEmpty(cJRCreditCardModelV8.getDisplayCardNumber())) {
            net.one97.paytm.recharge.creditcard.v4.a aVar2 = this.W;
            if (aVar2 != null) {
                aVar2.a(cJRCreditCardModelV8);
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
            flowName2.setActionType(ACTION_TYPE.PAYTM_FIRST_CARD.name());
        }
        HashMap hashMap = new HashMap();
        Map map2 = hashMap;
        map2.put("cardModel", cJRCreditCardModelV8);
        map2.put("isNewCardClicked", Boolean.valueOf(z));
        map2.put("sharedElementMap", map);
        a2.setExtraObj(hashMap);
        CJRCreditCardTokenizationModel cJRCreditCardTokenizationModel = new CJRCreditCardTokenizationModel();
        cJRCreditCardTokenizationModel.setBody(new CJRCreditCardBodyModel());
        CJRCreditCardBodyModel body = cJRCreditCardTokenizationModel.getBody();
        if (body != null) {
            body.setCardToken("");
        }
        CJRCreditCardBodyModel body2 = cJRCreditCardTokenizationModel.getBody();
        if (body2 != null) {
            body2.setMaskedCardNumber(cJRCreditCardModelV8.getDisplayCardNumber());
        }
        a(cJRCreditCardTokenizationModel, cJRCreditCardModelV8, (Map<?, ?>) map2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r20, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r21, java.util.Map<?, ?> r22) {
        /*
            r19 = this;
            r15 = r19
            r0 = r21
            r1 = 0
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L_0x0052
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r4 = r20.getBody()
            if (r4 == 0) goto L_0x0052
            java.lang.String r4 = r4.getMaskedCardNumber()
            if (r4 == 0) goto L_0x0052
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            if (r4 != r3) goto L_0x0052
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.creditcard.v4.a r1 = r15.W
            if (r1 == 0) goto L_0x002e
            android.content.Context r1 = r1.d()
            r3 = r1
            goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            r6 = 0
            net.one97.paytm.recharge.creditcard.v4.a r1 = r15.W
            if (r1 == 0) goto L_0x0044
            android.content.Context r1 = r1.d()
            if (r1 == 0) goto L_0x0044
            int r2 = net.one97.paytm.recharge.R.string.something_went_wrong
            java.lang.String r2 = r1.getString(r2)
        L_0x0044:
            r7 = r2
            r8 = 8
            net.one97.paytm.recharge.common.utils.az.a(r3, r4, r5, r6, r7, r8)
            net.one97.paytm.recharge.creditcard.v4.a r1 = r15.W
            if (r1 == 0) goto L_0x0051
            r1.a(r0)
        L_0x0051:
            return
        L_0x0052:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = r21.getSelectedDCVariant()
            if (r4 == 0) goto L_0x0072
            java.util.List r5 = r4.getProductList()
            if (r5 == 0) goto L_0x0072
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 != r3) goto L_0x0072
            java.util.List r4 = r4.getProductList()
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            goto L_0x0073
        L_0x0072:
            r4 = r2
        L_0x0073:
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r13.setErrorType(r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r13.getFlowName()
            if (r5 == 0) goto L_0x008d
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r5.setErrorType(r6)
        L_0x008d:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r13.getFlowName()
            if (r5 == 0) goto L_0x009c
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PAYTM_FIRST_CARD
            java.lang.String r6 = r6.name()
            r5.setActionType(r6)
        L_0x009c:
            r5 = r22
            r13.setExtraObj(r5)
            net.one97.paytm.recharge.creditcard.v4.a r5 = r15.W
            if (r5 == 0) goto L_0x00aa
            android.content.Context r5 = r5.d()
            goto L_0x00ab
        L_0x00aa:
            r5 = r2
        L_0x00ab:
            boolean r5 = com.paytm.utility.b.c((android.content.Context) r5)
            java.lang.String r6 = "get_pf_credit_card_verify"
            if (r5 == 0) goto L_0x01d4
            net.one97.paytm.recharge.creditcard.v4.a r5 = r15.W
            if (r5 == 0) goto L_0x00bc
            android.content.Context r5 = r5.d()
            goto L_0x00bd
        L_0x00bc:
            r5 = r2
        L_0x00bd:
            boolean r5 = com.paytm.utility.d.c(r5)
            if (r5 == 0) goto L_0x01c7
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x011c
            net.one97.paytm.common.entity.CJRItem r5 = r15.r
            java.lang.String r5 = r5.getCategoryId()
            com.google.gson.f r6 = new com.google.gson.f     // Catch:{ Exception -> 0x0117 }
            r6.<init>()     // Catch:{ Exception -> 0x0117 }
            net.one97.paytm.recharge.di.helper.c r7 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x0117 }
            java.lang.String r7 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x0117 }
            java.lang.Class<java.util.HashMap> r8 = java.util.HashMap.class
            java.lang.Object r6 = r6.a((java.lang.String) r7, r8)     // Catch:{ Exception -> 0x0117 }
            boolean r7 = r6 instanceof java.util.HashMap     // Catch:{ Exception -> 0x0117 }
            if (r7 != 0) goto L_0x00e7
            r6 = r2
        L_0x00e7:
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ Exception -> 0x0117 }
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x0117 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0117 }
            if (r7 != 0) goto L_0x0117
            if (r6 == 0) goto L_0x0117
            r7 = r6
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0117 }
            if (r7 == 0) goto L_0x010f
            boolean r7 = r7.containsKey(r5)     // Catch:{ Exception -> 0x0117 }
            if (r7 != r3) goto L_0x0117
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0117 }
            boolean r0 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r5, (android.content.Context) r0)     // Catch:{ Exception -> 0x0117 }
            if (r0 == 0) goto L_0x0117
            r0 = 1
            goto L_0x0118
        L_0x010f:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0117 }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r0.<init>(r5)     // Catch:{ Exception -> 0x0117 }
            throw r0     // Catch:{ Exception -> 0x0117 }
        L_0x0117:
            r0 = 0
        L_0x0118:
            if (r0 != r3) goto L_0x011c
            r12 = 1
            goto L_0x011d
        L_0x011c:
            r12 = 0
        L_0x011d:
            net.one97.paytm.recharge.creditcard.v4.a r0 = r15.W
            if (r0 == 0) goto L_0x0126
            android.content.Context r0 = r0.d()
            r2 = r0
        L_0x0126:
            if (r2 != 0) goto L_0x012b
            kotlin.g.b.k.a()
        L_0x012b:
            if (r4 == 0) goto L_0x0133
            java.lang.String r0 = r4.getMinAmount()
            if (r0 != 0) goto L_0x0135
        L_0x0133:
            java.lang.String r0 = "100"
        L_0x0135:
            java.lang.String r5 = ""
            if (r0 != 0) goto L_0x013b
            r6 = r5
            goto L_0x013c
        L_0x013b:
            r6 = r0
        L_0x013c:
            if (r4 == 0) goto L_0x0151
            java.lang.Long r0 = r4.getProductId()
            if (r0 == 0) goto L_0x0151
            long r7 = r0.longValue()
            java.lang.String r0 = java.lang.String.valueOf(r7)
            if (r0 != 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r7 = r0
            goto L_0x0152
        L_0x0151:
            r7 = r5
        L_0x0152:
            if (r20 == 0) goto L_0x0163
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = r20.getBody()
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = r0.getCardToken()
            if (r0 != 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r8 = r0
            goto L_0x0164
        L_0x0163:
            r8 = r5
        L_0x0164:
            if (r20 == 0) goto L_0x0175
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = r20.getBody()
            if (r0 == 0) goto L_0x0175
            java.lang.String r0 = r0.getMaskedCardNumber()
            if (r0 != 0) goto L_0x0173
            goto L_0x0175
        L_0x0173:
            r9 = r0
            goto L_0x0176
        L_0x0175:
            r9 = r5
        L_0x0176:
            if (r20 == 0) goto L_0x0187
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = r20.getBody()
            if (r0 == 0) goto L_0x0187
            java.lang.String r0 = r0.getMaskedCardNumber()
            if (r0 != 0) goto L_0x0185
            goto L_0x0187
        L_0x0185:
            r10 = r0
            goto L_0x0188
        L_0x0187:
            r10 = r5
        L_0x0188:
            if (r4 == 0) goto L_0x0193
            java.lang.String r0 = r4.getRequestType()
            if (r0 != 0) goto L_0x0191
            goto L_0x0193
        L_0x0191:
            r11 = r0
            goto L_0x0194
        L_0x0193:
            r11 = r5
        L_0x0194:
            if (r4 == 0) goto L_0x019e
            boolean r0 = r4.isVisaDirectEnabled()
            if (r0 != r3) goto L_0x019e
            r14 = 1
            goto L_0x019f
        L_0x019e:
            r14 = 0
        L_0x019f:
            if (r4 == 0) goto L_0x01aa
            boolean r0 = r4.isBillPaymentEnabled()
            if (r0 != r3) goto L_0x01aa
            r16 = 1
            goto L_0x01ac
        L_0x01aa:
            r16 = 0
        L_0x01ac:
            r17 = r15
            net.one97.paytm.recharge.common.e.ai r17 = (net.one97.paytm.recharge.common.e.ai) r17
            java.lang.String r1 = "get_pf_credit_card_verify"
            java.lang.String r18 = ""
            r0 = r19
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r11
            r9 = r14
            r10 = r16
            r11 = r18
            r14 = r17
            r0.a((java.lang.String) r1, (android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (boolean) r10, (java.lang.String) r11, (boolean) r12, (java.lang.Object) r13, (net.one97.paytm.recharge.common.e.ai) r14)
            return
        L_0x01c7:
            kotlin.k.e<kotlin.x> r1 = r15.u
            kotlin.g.a.q r1 = (kotlin.g.a.q) r1
            net.one97.paytm.recharge.common.utils.c r2 = new net.one97.paytm.recharge.common.utils.c
            r2.<init>()
            r1.invoke(r6, r2, r13)
            goto L_0x01e0
        L_0x01d4:
            kotlin.k.e<kotlin.x> r4 = r15.u
            kotlin.g.a.q r4 = (kotlin.g.a.q) r4
            net.one97.paytm.recharge.common.utils.as r5 = new net.one97.paytm.recharge.common.utils.as
            r5.<init>(r1, r3, r2)
            r4.invoke(r6, r5, r13)
        L_0x01e0:
            net.one97.paytm.recharge.creditcard.v4.a r1 = r15.W
            if (r1 == 0) goto L_0x01e7
            r1.a(r0)
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r3.equals("get_pf_credit_card_verify") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r3.equals("get_pf_credit_card_token") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if ((r7 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r4 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r4 == null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        r4 = r4.getExtraObj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        if ((r4 instanceof java.util.HashMap) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r4 = ((java.util.Map) r4).get("cardModel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r4 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r1 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007e, code lost:
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007f, code lost:
        ((kotlin.g.a.q) r2.u).invoke(r3, r6, r7);
        r3 = r2.W;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r3.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
        if (r6 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        if (kotlin.m.p.a("cart.paytm.com/v1/expresscart/verify", r6.getFullUrl(), false) == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
        r2.Q.postValue(new net.one97.paytm.recharge.model.v4.Data(net.one97.paytm.recharge.model.v4.DataState.ERROR, r6, (java.lang.String) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00aa, code lost:
        r2.T = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, int r4, com.paytm.network.model.IJRPaytmDataModel r5, com.paytm.network.model.NetworkCustomError r6, java.lang.Object r7) {
        /*
            r2 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r3, r0)
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1517120432: goto L_0x004c;
                case 262142210: goto L_0x0043;
                case 267720212: goto L_0x002f;
                case 892583754: goto L_0x001b;
                case 2128411252: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x008e
        L_0x000f:
            java.lang.String r0 = "getCategory"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x008e
            super.a((java.lang.String) r3, (int) r4, (com.paytm.network.model.IJRPaytmDataModel) r5, (com.paytm.network.model.NetworkCustomError) r6, (java.lang.Object) r7)
            return
        L_0x001b:
            java.lang.String r4 = "fetch_promo"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x008e
            boolean r3 = r7 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x00ad
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7)
            return
        L_0x002f:
            java.lang.String r4 = "fetch_insurance_data"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x008e
            boolean r3 = r7 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x00ad
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7)
            return
        L_0x0043:
            java.lang.String r4 = "get_pf_credit_card_verify"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x008e
            goto L_0x0054
        L_0x004c:
            java.lang.String r4 = "get_pf_credit_card_token"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x008e
        L_0x0054:
            boolean r4 = r7 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r4 == 0) goto L_0x005c
            r4 = r7
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r4
            goto L_0x005d
        L_0x005c:
            r4 = r1
        L_0x005d:
            if (r4 == 0) goto L_0x0064
            java.lang.Object r4 = r4.getExtraObj()
            goto L_0x0065
        L_0x0064:
            r4 = r1
        L_0x0065:
            boolean r5 = r4 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x007f
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r5 = "cardModel"
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L_0x0077
            r1 = r4
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r1
            goto L_0x007f
        L_0x0077:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8"
            r3.<init>(r4)
            throw r3
        L_0x007f:
            kotlin.k.e<kotlin.x> r4 = r2.u
            kotlin.g.a.q r4 = (kotlin.g.a.q) r4
            r4.invoke(r3, r6, r7)
            net.one97.paytm.recharge.creditcard.v4.a r3 = r2.W
            if (r3 == 0) goto L_0x008d
            r3.a(r1)
        L_0x008d:
            return
        L_0x008e:
            if (r6 == 0) goto L_0x00aa
            java.lang.String r3 = r6.getFullUrl()
            r4 = 0
            java.lang.String r5 = "cart.paytm.com/v1/expresscart/verify"
            boolean r3 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r4)
            if (r3 == 0) goto L_0x00aa
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<com.paytm.network.model.NetworkCustomError>> r3 = r2.Q
            net.one97.paytm.recharge.model.v4.Data r4 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r5 = net.one97.paytm.recharge.model.v4.DataState.ERROR
            r4.<init>(r5, r6, r1)
            r3.postValue(r4)
            return
        L_0x00aa:
            r3 = 1
            r2.T = r3
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(java.lang.String, int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8} */
    /* JADX WARNING: type inference failed for: r8v3, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r15, com.paytm.network.model.IJRPaytmDataModel r16, java.lang.Object r17) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r9 = r17
            java.lang.String r3 = "tag"
            kotlin.g.b.k.c(r15, r3)
            int r3 = r15.hashCode()
            r4 = -1517120432(0xffffffffa5929450, float:-2.5427463E-16)
            java.lang.String r5 = "null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8"
            java.lang.String r6 = "cardModel"
            r7 = 1
            r8 = 0
            if (r3 == r4) goto L_0x01ed
            r4 = 262142210(0xf9ff902, float:1.5774525E-29)
            if (r3 == r4) goto L_0x0021
            goto L_0x0249
        L_0x0021:
            java.lang.String r3 = "get_pf_credit_card_verify"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x0249
            boolean r3 = r9 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x0031
            r3 = r9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            goto L_0x0032
        L_0x0031:
            r3 = r8
        L_0x0032:
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r3.getExtraObj()
            goto L_0x003a
        L_0x0039:
            r3 = r8
        L_0x003a:
            boolean r4 = r3 instanceof java.util.HashMap
            if (r4 == 0) goto L_0x0052
            r10 = r3
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r6 = r10.get(r6)
            if (r6 == 0) goto L_0x004c
            r5 = r6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r5
            r10 = r5
            goto L_0x0053
        L_0x004c:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x0052:
            r10 = r8
        L_0x0053:
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r5 == 0) goto L_0x01e5
            net.one97.paytm.recharge.common.utils.az r5 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.creditcard.v4.a r5 = r0.W
            if (r5 == 0) goto L_0x0062
            android.content.Context r5 = r5.d()
            goto L_0x0063
        L_0x0062:
            r5 = r8
        L_0x0063:
            net.one97.paytm.common.entity.CJRRechargeCart r2 = (net.one97.paytm.common.entity.CJRRechargeCart) r2
            r6 = 4
            r11 = 0
            android.os.Bundle r5 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r5, (net.one97.paytm.common.entity.CJRRechargeCart) r2, (boolean) r11, (int) r6)
            java.lang.String r6 = "extra.has.error"
            boolean r6 = r5.getBoolean(r6)
            java.lang.String r12 = "extra.error.msg"
            java.lang.String r12 = r5.getString(r12)
            if (r6 == 0) goto L_0x00b6
            java.lang.String r2 = "extra.error.title"
            java.lang.String r3 = r5.getString(r2)
            java.lang.String r2 = "extra.error.action.btn.label"
            java.lang.String r6 = r5.getString(r2)
            java.lang.String r2 = "extra.error.action.btn"
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "extra.show.error.info.dialog"
            boolean r4 = r5.getBoolean(r4)
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r11 = r0.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog r13 = new net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog
            net.one97.paytm.recharge.model.v4.ErrorAction r7 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.String) r2)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            r2 = r13
            r4 = r12
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r11.setValue(r13)
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r2 = r0.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError r3 = new net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError
            r3.<init>(r12, r15, r9)
            r2.setValue(r3)
            goto L_0x01e5
        L_0x00b6:
            if (r4 == 0) goto L_0x01e5
            if (r10 == 0) goto L_0x01e5
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r1 = "isNewCardClicked"
            java.lang.Object r1 = r3.get(r1)
            if (r1 == 0) goto L_0x01dd
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r4 = "sharedElementMap"
            java.lang.Object r3 = r3.get(r4)
            boolean r4 = r3 instanceof java.util.Map
            if (r4 != 0) goto L_0x00d5
            r3 = r8
        L_0x00d5:
            r9 = r3
            java.util.Map r9 = (java.util.Map) r9
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r2.getCart()
            if (r3 == 0) goto L_0x01ce
            java.util.ArrayList r3 = r3.getCartItems()
            if (r3 == 0) goto L_0x01ce
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r7
            if (r3 != r7) goto L_0x01ce
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r2.getCart()
            java.lang.String r4 = "response.cart"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.util.ArrayList r3 = r3.getCartItems()
            if (r3 == 0) goto L_0x01ce
            java.lang.Object r3 = r3.get(r11)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r3 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r3
            if (r3 == 0) goto L_0x01ce
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r3 = r3.getServiceOptions()
            if (r3 == 0) goto L_0x01ce
            java.util.ArrayList r3 = r3.getActions()
            if (r3 == 0) goto L_0x01ce
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r7
            if (r3 != r7) goto L_0x01ce
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r2.getCart()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.util.ArrayList r3 = r3.getCartItems()
            if (r3 == 0) goto L_0x01ce
            java.lang.Object r3 = r3.get(r11)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r3 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r3
            if (r3 == 0) goto L_0x01ce
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r3 = r3.getServiceOptions()
            if (r3 == 0) goto L_0x01ce
            java.util.ArrayList r3 = r3.getActions()
            if (r3 == 0) goto L_0x01ce
            java.lang.Object r3 = r3.get(r11)
            net.one97.paytm.common.entity.shopping.CJRServiceActions r3 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r3
            if (r3 == 0) goto L_0x01ce
            java.util.ArrayList r3 = r3.getGroupDisplay()
            if (r3 == 0) goto L_0x01ce
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r7
            if (r3 != r7) goto L_0x01ce
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.util.ArrayList r2 = r2.getCartItems()
            if (r2 == 0) goto L_0x018c
            java.lang.Object r2 = r2.get(r11)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2
            if (r2 == 0) goto L_0x018c
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r2 = r2.getServiceOptions()
            if (r2 == 0) goto L_0x018c
            java.util.ArrayList r2 = r2.getActions()
            if (r2 == 0) goto L_0x018c
            java.lang.Object r2 = r2.get(r11)
            net.one97.paytm.common.entity.shopping.CJRServiceActions r2 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r2
            if (r2 == 0) goto L_0x018c
            java.util.ArrayList r2 = r2.getGroupDisplay()
            if (r2 == 0) goto L_0x018c
            java.lang.Object r2 = r2.get(r11)
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r2 = (net.one97.paytm.common.entity.shopping.CJRGroupDisplay) r2
            if (r2 == 0) goto L_0x018c
            java.util.List r8 = r2.getmBillDetails()
        L_0x018c:
            if (r8 == 0) goto L_0x01ce
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r7
            if (r2 != r7) goto L_0x01ce
            java.lang.Object r2 = r8.get(r11)
            java.lang.String r3 = "billsDetailsList[0]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            double r4 = r2.getMinDueAmount()
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r10.setMinDue(r2)
            java.lang.Object r2 = r8.get(r11)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            java.lang.Double r2 = r2.getAmount()
            r10.setTotalDue(r2)
            java.lang.Object r2 = r8.get(r11)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            java.lang.String r2 = r2.getDueDate()
            r10.setDueDate(r2)
        L_0x01ce:
            net.one97.paytm.recharge.creditcard.v4.a r6 = r0.W
            if (r6 == 0) goto L_0x01dc
            r2 = 1
            r11 = 0
            r12 = 16
            r7 = r10
            r8 = r1
            r10 = r2
            net.one97.paytm.recharge.creditcard.v4.a.C1204a.a(r6, r7, r8, r9, r10, r11, r12)
        L_0x01dc:
            return
        L_0x01dd:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Boolean"
            r1.<init>(r2)
            throw r1
        L_0x01e5:
            net.one97.paytm.recharge.creditcard.v4.a r1 = r0.W
            if (r1 == 0) goto L_0x01ec
            r1.a(r10)
        L_0x01ec:
            return
        L_0x01ed:
            java.lang.String r3 = "get_pf_credit_card_token"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x0249
            boolean r1 = r9 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x01fd
            r1 = r9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            goto L_0x01fe
        L_0x01fd:
            r1 = r8
        L_0x01fe:
            if (r1 == 0) goto L_0x0205
            java.lang.Object r1 = r1.getExtraObj()
            goto L_0x0206
        L_0x0205:
            r1 = r8
        L_0x0206:
            boolean r3 = r1 instanceof java.util.Map
            if (r3 != 0) goto L_0x020b
            r1 = r8
        L_0x020b:
            java.util.Map r1 = (java.util.Map) r1
            boolean r3 = r1 instanceof java.util.HashMap
            if (r3 == 0) goto L_0x0220
            java.lang.Object r3 = r1.get(r6)
            if (r3 == 0) goto L_0x021a
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r3 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r3
            goto L_0x0221
        L_0x021a:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x0220:
            r3 = r8
        L_0x0221:
            boolean r4 = r2 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel
            if (r4 == 0) goto L_0x0241
            if (r3 == 0) goto L_0x0241
            if (r1 == 0) goto L_0x0241
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r2 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel) r2
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r4 = r2.getBody()
            if (r4 == 0) goto L_0x0235
            java.lang.String r8 = r4.getCardToken()
        L_0x0235:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r4 = android.text.TextUtils.isEmpty(r8)
            if (r4 != 0) goto L_0x0241
            r14.a((net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel) r2, (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r3, (java.util.Map<?, ?>) r1)
            return
        L_0x0241:
            net.one97.paytm.recharge.creditcard.v4.a r1 = r0.W
            if (r1 == 0) goto L_0x0248
            r1.a(r3)
        L_0x0248:
            return
        L_0x0249:
            boolean r3 = r2 instanceof net.one97.paytm.recharge.model.CJRDeleteCard
            java.lang.String r4 = "tag.delete.saved.card"
            if (r3 == 0) goto L_0x0298
            if (r2 == 0) goto L_0x0379
            r1 = r2
            net.one97.paytm.recharge.model.CJRDeleteCard r1 = (net.one97.paytm.recharge.model.CJRDeleteCard) r1
            java.lang.String r2 = r1.getStatus()
            if (r2 == 0) goto L_0x0286
            java.lang.String r2 = r1.getStatus()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0286
            java.lang.String r1 = r1.getStatus()
            java.lang.String r2 = "success"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
            if (r1 == 0) goto L_0x0379
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r1 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r2 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r3 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r5 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.U
            r3.<init>(r5, r6, r8)
            r2.<init>(r4, r3)
            r1.postValue(r2)
            return
        L_0x0286:
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r1 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r2 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r3 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r5 = net.one97.paytm.recharge.model.v4.DataState.ERROR
            r3.<init>(r5, r8, r8)
            r2.<init>(r4, r3)
            r1.postValue(r2)
            return
        L_0x0298:
            boolean r3 = r2 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrderList
            if (r3 == 0) goto L_0x02b0
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r1 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r2 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r3 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r5 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.U
            r3.<init>(r5, r6, r8)
            r2.<init>(r4, r3)
            r1.postValue(r2)
            return
        L_0x02b0:
            boolean r3 = r2 instanceof net.one97.paytm.common.entity.shopping.CJROffers
            if (r3 == 0) goto L_0x02ba
            androidx.lifecycle.y<net.one97.paytm.common.entity.shopping.CJROffers> r1 = r0.k
            r1.setValue(r2)
            return
        L_0x02ba:
            boolean r3 = r2 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r3 == 0) goto L_0x02c4
            androidx.lifecycle.y<net.one97.paytm.common.entity.CJRRechargeCart> r1 = r0.V
            r1.setValue(r2)
            return
        L_0x02c4:
            boolean r3 = r2 instanceof net.one97.paytm.recharge.model.CJRPersonalInsurance
            if (r3 == 0) goto L_0x02ce
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPersonalInsurance> r1 = r0.Y
            r1.setValue(r2)
            return
        L_0x02ce:
            boolean r3 = r2 instanceof net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4
            if (r3 == 0) goto L_0x0376
            net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4 r2 = (net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4) r2
            java.lang.String r3 = r2.getStatus()
            if (r3 == 0) goto L_0x0347
            java.lang.String r3 = r2.getStatus()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0347
            net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4$a r3 = r2.getInfo()
            if (r3 == 0) goto L_0x02ef
            java.util.ArrayList<java.lang.Object> r3 = r3.f62625b
            goto L_0x02f0
        L_0x02ef:
            r3 = r8
        L_0x02f0:
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r3)
            if (r3 == 0) goto L_0x0347
            java.lang.String r3 = r2.getStatus()
            java.lang.String r4 = "00"
            boolean r3 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r3, (boolean) r7)
            if (r3 == 0) goto L_0x0318
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r2 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r3 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r4 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r5 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r0.U
            r4.<init>(r5, r6, r8)
            r3.<init>(r15, r4)
            r2.postValue(r3)
            return
        L_0x0318:
            boolean r3 = r9 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x0331
            r3 = r9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4$a r4 = r2.getInfo()
            if (r4 == 0) goto L_0x0328
            java.lang.String r4 = r4.f62624a
            goto L_0x0329
        L_0x0328:
            r4 = r8
        L_0x0329:
            r3.setErrorMsg(r4)
            net.one97.paytm.recharge.common.utils.az r4 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3)
        L_0x0331:
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r3 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r4 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r5 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r6 = net.one97.paytm.recharge.model.v4.DataState.ERROR
            java.lang.String r2 = r2.getMessage()
            r5.<init>(r6, r8, r2)
            r4.<init>(r15, r5)
            r3.postValue(r4)
            return
        L_0x0347:
            boolean r3 = r9 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x0360
            r3 = r9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4$a r4 = r2.getInfo()
            if (r4 == 0) goto L_0x0357
            java.lang.String r4 = r4.f62624a
            goto L_0x0358
        L_0x0357:
            r4 = r8
        L_0x0358:
            r3.setErrorMsg(r4)
            net.one97.paytm.recharge.common.utils.az r4 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3)
        L_0x0360:
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r3 = r0.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r4 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r5 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r6 = net.one97.paytm.recharge.model.v4.DataState.ERROR
            java.lang.String r2 = r2.getMessage()
            r5.<init>(r6, r8, r2)
            r4.<init>(r15, r5)
            r3.postValue(r4)
            return
        L_0x0376:
            super.a_(r15, r16, r17)
        L_0x0379:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0080, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.ab     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x007f
            boolean r0 = r7.S     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x007f
            boolean r0 = r7.T     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x000f
            goto L_0x007f
        L_0x000f:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r7.R     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x007d
            net.one97.paytm.recharge.model.v4.CJRGroupings r0 = r0.getGroupings()     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x007b
            java.util.List r0 = r0.getAggs()     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x007b
            r0 = 1
            r7.ab = r0     // Catch:{ all -> 0x0081 }
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r1 = r7.Z     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0079
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0081 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0081 }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0071
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0081 }
            r2.<init>()     // Catch:{ all -> 0x0081 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0081 }
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0081 }
            r4 = 0
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0081 }
        L_0x003f:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x005d
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0081 }
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x0050
            kotlin.a.k.a()     // Catch:{ all -> 0x0081 }
        L_0x0050:
            net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5     // Catch:{ all -> 0x0081 }
            boolean r4 = r7.a((net.one97.paytm.common.entity.IJRDataModel) r5)     // Catch:{ all -> 0x0081 }
            if (r4 != 0) goto L_0x005b
            r2.add(r5)     // Catch:{ all -> 0x0081 }
        L_0x005b:
            r4 = r6
            goto L_0x003f
        L_0x005d:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x0081 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0081 }
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x006c
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0081 }
            r1.removeAll(r2)     // Catch:{ all -> 0x0081 }
        L_0x006c:
            r7.a((java.util.List<net.one97.paytm.common.entity.IJRDataModel>) r1)     // Catch:{ all -> 0x0081 }
            monitor-exit(r7)
            return
        L_0x0071:
            androidx.lifecycle.y<java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>> r0 = r7.O     // Catch:{ all -> 0x0081 }
            r1 = 0
            r0.postValue(r1)     // Catch:{ all -> 0x0081 }
            monitor-exit(r7)
            return
        L_0x0079:
            monitor-exit(r7)
            return
        L_0x007b:
            monitor-exit(r7)
            return
        L_0x007d:
            monitor-exit(r7)
            return
        L_0x007f:
            monitor-exit(r7)
            return
        L_0x0081:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.c():void");
    }

    private final void a(List<IJRDataModel> list) {
        String str;
        String a2;
        this.aa = new ArrayList();
        if (list != null) {
            for (IJRDataModel next : list) {
                CJRCreditCardModelV8 cJRCreditCardModelV8 = new CJRCreditCardModelV8();
                boolean z = next instanceof CJRCardBaseModel;
                String str2 = null;
                CJRCardBaseModel cJRCardBaseModel = (CJRCardBaseModel) (!z ? null : next);
                cJRCreditCardModelV8.setOperaterCardTypeImage(cJRCardBaseModel != null ? cJRCardBaseModel.getOperaterCardTypeImageUrl() : null);
                CJRCardBaseModel cJRCardBaseModel2 = (CJRCardBaseModel) (!z ? null : next);
                cJRCreditCardModelV8.setOperaterImage(cJRCardBaseModel2 != null ? cJRCardBaseModel2.getOperatorIimageUrl() : null);
                boolean z2 = false;
                if (this.ac.containsKey(next)) {
                    cJRCreditCardModelV8.setSelectedDCVariant(this.ac.get(next));
                    CJRAggsItem selectedDCVariant = cJRCreditCardModelV8.getSelectedDCVariant();
                    cJRCreditCardModelV8.setCardType(selectedDCVariant != null ? selectedDCVariant.getValue() : null);
                    CJRAggsItem selectedDCVariant2 = cJRCreditCardModelV8.getSelectedDCVariant();
                    List<CJRProductsItem> productList = selectedDCVariant2 != null ? selectedDCVariant2.getProductList() : null;
                    if (productList == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRCreditCardModelV8.setDisclaimer(productList.get(0).getDisclaimer());
                    CJRAggsItem selectedDCVariant3 = cJRCreditCardModelV8.getSelectedDCVariant();
                    List<CJRProductsItem> productList2 = selectedDCVariant3 != null ? selectedDCVariant3.getProductList() : null;
                    if (productList2 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRCreditCardModelV8.setCreditCardLength(productList2.get(0).getCreditCardLength());
                }
                if (next instanceof CJRFrequentOrder) {
                    CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) next;
                    cJRCreditCardModelV8.setRechargeDate(cJRFrequentOrder.getPaidOn());
                    cJRCreditCardModelV8.setCreatedAT(cJRFrequentOrder.getmCreatedAt());
                    cJRCreditCardModelV8.setRechargeAmount(cJRFrequentOrder.getRechargeAmount());
                    cJRCreditCardModelV8.setCardNumber(cJRFrequentOrder.getRechargeNumber());
                    cJRCreditCardModelV8.setOperaterName(cJRFrequentOrder.getOperatorDisplayLabel());
                    cJRCreditCardModelV8.setOperaterLabel(cJRFrequentOrder.getOperatorLabel());
                    cJRCreditCardModelV8.setCardTypeId(cJRCreditCardModelV8.getRecentCardId());
                    cJRCreditCardModelV8.setCardId(cJRFrequentOrder.getCardId());
                    cJRCreditCardModelV8.setBillsDetails(cJRFrequentOrder.getCjrBillDetails());
                    cJRCreditCardModelV8.setFavOrderId(cJRFrequentOrder.getFavOrderId());
                    String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
                    kotlin.g.b.k.a((Object) rechargeNumber, "card.rechargeNumber");
                    cJRCreditCardModelV8.setDisplayCardNumber(az.a(p.a(p.a(rechargeNumber, " ", "", false), "-", "", false)));
                    cJRCreditCardModelV8.setCtaMap(cJRFrequentOrder.getCtaMap());
                    Map<String, Object> operatorDataNew = cJRFrequentOrder.getOperatorDataNew();
                    if (operatorDataNew != null && operatorDataNew.containsKey("cardId")) {
                        Map<String, Object> operatorDataNew2 = cJRFrequentOrder.getOperatorDataNew();
                        Object obj = operatorDataNew2 != null ? operatorDataNew2.get("cardId") : null;
                        if (obj instanceof String) {
                            str2 = obj;
                        }
                        cJRCreditCardModelV8.setCardId2(str2);
                    }
                    cJRCreditCardModelV8.setPaytmFirstCreditCard(cJRFrequentOrder.isPaytmFirst());
                } else if (next instanceof CJRCreditCardBodyModel) {
                    CJRCreditCardBodyModel cJRCreditCardBodyModel = (CJRCreditCardBodyModel) next;
                    cJRCreditCardModelV8.setCardNumber(cJRCreditCardBodyModel.getCardNumber());
                    cJRCreditCardModelV8.setOperaterName(cJRCreditCardBodyModel.getBank());
                    cJRCreditCardModelV8.setOperaterLabel(cJRCreditCardBodyModel.getBank());
                    cJRCreditCardModelV8.setCardTypeId(cJRCreditCardModelV8.getSavedCardId());
                    cJRCreditCardModelV8.setCardId(cJRCreditCardBodyModel.getCardId());
                    String cardNumber = cJRCreditCardBodyModel.getCardNumber();
                    if (cardNumber == null || (a2 = p.a(cardNumber, " ", "", false)) == null || (str = p.a(a2, "-", "", false)) == null) {
                        str = "";
                    }
                    cJRCreditCardModelV8.setDisplayCardNumber(az.a(str));
                    cJRCreditCardModelV8.setPaytmFirstCreditCard(cJRCreditCardBodyModel.isPaytmFirstCard());
                }
                if (this.ad.containsKey(next)) {
                    CharSequence charSequence = this.ad.get(next);
                    if (charSequence == null || charSequence.length() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        cJRCreditCardModelV8.setOperaterName(this.ad.get(next));
                    }
                }
                List<CJRCreditCardModelV8> list2 = this.aa;
                if (list2 != null) {
                    list2.add(cJRCreditCardModelV8);
                }
                this.O.postValue(this.aa);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024b, code lost:
        if (r1 == null) goto L_0x024d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(net.one97.paytm.common.entity.IJRDataModel r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0086
            r0 = r12
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r0
            java.lang.String r4 = r0.getBankCode()
            java.lang.String r5 = r0.getCardType()
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r6 = r0.getFrequentOrderProduct()
            if (r6 == 0) goto L_0x0058
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r6 = r0.getFrequentOrderProduct()
            java.lang.String r7 = "card.frequentOrderProduct"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.util.Map r6 = r6.getAttributes()
            if (r6 == 0) goto L_0x0058
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r6 = r0.getFrequentOrderProduct()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.util.Map r6 = r6.getAttributes()
            java.lang.String r8 = "is_paytm_first_card"
            boolean r6 = r6.containsKey(r8)
            if (r6 == 0) goto L_0x0058
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r6 = r0.getFrequentOrderProduct()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.util.Map r6 = r6.getAttributes()
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "1"
            boolean r6 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r6, (boolean) r3)
            if (r6 != 0) goto L_0x0059
            boolean r6 = r0.isPaytmFirst()
            goto L_0x0059
        L_0x0058:
            r6 = 0
        L_0x0059:
            if (r6 != 0) goto L_0x0081
            java.lang.String r7 = b((net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r0)
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0081
            net.one97.paytm.recharge.di.helper.c r8 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.ArrayList r8 = net.one97.paytm.recharge.di.helper.c.by()
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x0081
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.ArrayList r6 = net.one97.paytm.recharge.di.helper.c.by()
            boolean r6 = r6.contains(r7)
        L_0x0081:
            r0.setIsPaytmFirstCard(r6)
            r0 = r6
            goto L_0x009d
        L_0x0086:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel
            if (r0 == 0) goto L_0x009a
            r0 = r12
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel) r0
            java.lang.String r4 = r0.getBank()
            java.lang.String r5 = r0.getCardScheme()
            boolean r0 = r0.isPaytmFirstCard()
            goto L_0x009d
        L_0x009a:
            r4 = r1
            r5 = r4
            r0 = 0
        L_0x009d:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r6 = r11.R
            if (r6 == 0) goto L_0x00e9
            net.one97.paytm.recharge.model.v4.CJRGroupings r6 = r6.getGroupings()
            if (r6 == 0) goto L_0x00e9
            java.util.List r6 = r6.getAggs()
            if (r6 == 0) goto L_0x00e9
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
            r8 = 0
        L_0x00bb:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x00e5
            java.lang.Object r9 = r6.next()
            int r10 = r8 + 1
            if (r8 >= 0) goto L_0x00cc
            kotlin.a.k.a()
        L_0x00cc:
            r8 = r9
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            if (r4 == 0) goto L_0x00dd
            java.lang.String r8 = r8.getBankCode()
            boolean r8 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r8, (boolean) r3)
            if (r8 != r3) goto L_0x00dd
            r8 = 1
            goto L_0x00de
        L_0x00dd:
            r8 = 0
        L_0x00de:
            if (r8 == 0) goto L_0x00e3
            r7.add(r9)
        L_0x00e3:
            r8 = r10
            goto L_0x00bb
        L_0x00e5:
            r6 = r7
            java.util.List r6 = (java.util.List) r6
            goto L_0x00ea
        L_0x00e9:
            r6 = r1
        L_0x00ea:
            if (r6 == 0) goto L_0x015d
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x015d
            int r7 = r6.size()
            if (r7 <= r3) goto L_0x015d
            if (r0 == 0) goto L_0x0125
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L_0x010b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0122
            java.lang.Object r7 = r6.next()
            r8 = r7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            boolean r8 = r8.isPaytmFirst()
            if (r8 == 0) goto L_0x010b
            r0.add(r7)
            goto L_0x010b
        L_0x0122:
            java.util.List r0 = (java.util.List) r0
            goto L_0x014c
        L_0x0125:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L_0x0132:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x014a
            java.lang.Object r7 = r6.next()
            r8 = r7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            boolean r8 = r8.isPaytmFirst()
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x0132
            r0.add(r7)
            goto L_0x0132
        L_0x014a:
            java.util.List r0 = (java.util.List) r0
        L_0x014c:
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0170
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            goto L_0x0171
        L_0x015d:
            if (r6 == 0) goto L_0x0170
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0170
            java.lang.Object r0 = r6.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            goto L_0x0171
        L_0x0170:
            r0 = r1
        L_0x0171:
            if (r0 == 0) goto L_0x024d
            java.util.Map<net.one97.paytm.common.entity.IJRDataModel, java.lang.String> r6 = r11.ad
            java.lang.String r7 = r0.getDisplayValue()
            r6.put(r12, r7)
            boolean r6 = r12 instanceof net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel
            if (r6 == 0) goto L_0x018a
            r7 = r12
            net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel r7 = (net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel) r7
            java.lang.String r8 = r0.getImageUrl()
            r7.setOperatorIimageUrl(r8)
        L_0x018a:
            java.util.List r0 = r0.getAggs()
            if (r0 == 0) goto L_0x01cc
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r0 = r0.iterator()
            r8 = 0
        L_0x019e:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x01c8
            java.lang.Object r9 = r0.next()
            int r10 = r8 + 1
            if (r8 >= 0) goto L_0x01af
            kotlin.a.k.a()
        L_0x01af:
            r8 = r9
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            if (r5 == 0) goto L_0x01c0
            java.lang.String r8 = r8.getValue()
            boolean r8 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r3)
            if (r8 != r3) goto L_0x01c0
            r8 = 1
            goto L_0x01c1
        L_0x01c0:
            r8 = 0
        L_0x01c1:
            if (r8 == 0) goto L_0x01c6
            r7.add(r9)
        L_0x01c6:
            r8 = r10
            goto L_0x019e
        L_0x01c8:
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            goto L_0x01cd
        L_0x01cc:
            r0 = r1
        L_0x01cd:
            if (r0 == 0) goto L_0x024b
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0249
            java.util.Map<net.one97.paytm.common.entity.IJRDataModel, net.one97.paytm.recharge.model.v4.CJRAggsItem> r1 = r11.ac
            java.lang.Object r5 = r0.get(r2)
            r1.put(r12, r5)
            if (r6 == 0) goto L_0x020e
            java.lang.Object r1 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r1
            java.util.List r1 = r1.getProductList()
            if (r1 == 0) goto L_0x020e
            net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel r12 = (net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel) r12
            java.lang.Object r1 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r1
            java.util.List r1 = r1.getProductList()
            if (r1 != 0) goto L_0x0201
            kotlin.g.b.k.a()
        L_0x0201:
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            java.lang.String r1 = r1.getImage()
            r12.setOperaterCardTypeImageUrl(r1)
        L_0x020e:
            java.lang.Object r12 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r12
            java.util.List r12 = r12.getProductList()
            if (r12 == 0) goto L_0x0249
            java.lang.Object r12 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r12
            java.util.List r12 = r12.getProductList()
            if (r12 == 0) goto L_0x0249
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r3
            if (r12 != r3) goto L_0x0249
            java.lang.Object r12 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r12
            java.util.List r12 = r12.getProductList()
            if (r12 != 0) goto L_0x023e
            kotlin.g.b.k.a()
        L_0x023e:
            java.lang.Object r12 = r12.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r12
            boolean r12 = r12.isBillPaymentEnabled()
            return r12
        L_0x0249:
            kotlin.x r1 = kotlin.x.f47997a
        L_0x024b:
            if (r1 != 0) goto L_0x025c
        L_0x024d:
            r12 = r11
            net.one97.paytm.recharge.creditcard.c.a r12 = (net.one97.paytm.recharge.creditcard.c.a) r12
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r12 = r12.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$sendProductNotSelectedHawkEyeEvent r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$sendProductNotSelectedHawkEyeEvent
            r0.<init>(r4)
            r12.setValue(r0)
            kotlin.x r12 = kotlin.x.f47997a
        L_0x025c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(net.one97.paytm.common.entity.IJRDataModel):boolean");
    }

    private static String b(IJRDataModel iJRDataModel) {
        String a2;
        String a3;
        String str = null;
        if (iJRDataModel instanceof CJRFrequentOrder) {
            String rechargeNumber = ((CJRFrequentOrder) iJRDataModel).getRechargeNumber();
            if (!(rechargeNumber == null || (a3 = p.a(rechargeNumber, "-", "", false)) == null)) {
                str = p.a(a3, " ", "", false);
            }
            if (str != null) {
                int length = str.length() - 4;
                if (str != null) {
                    String substring = str.substring(length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    if (substring != null) {
                        return substring;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return "";
        } else if (!(iJRDataModel instanceof CJRCreditCardBodyModel)) {
            return "";
        } else {
            String cardNumber = ((CJRCreditCardBodyModel) iJRDataModel).getCardNumber();
            if (!(cardNumber == null || (a2 = p.a(cardNumber, "-", "", false)) == null)) {
                str = p.a(a2, " ", "", false);
            }
            if (str != null) {
                int length2 = str.length() - 4;
                if (str != null) {
                    String substring2 = str.substring(length2);
                    kotlin.g.b.k.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                    if (substring2 != null) {
                        return substring2;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return "";
        }
    }

    private static String b(CJRFrequentOrder cJRFrequentOrder) {
        String a2;
        kotlin.g.b.k.c(cJRFrequentOrder, BaseViewModel.PaymentType.CARD);
        try {
            String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
            if (!(rechargeNumber == null || (a2 = p.a(rechargeNumber, " ", "", false)) == null)) {
                if (a2 != null) {
                    String substring = a2.substring(0, 6);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        return substring;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62460a;

        public c(a aVar) {
            this.f62460a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62460a.P.postValue(new CJRTaggedObservable("tag.delete.saved.card", new Data(DataState.ERROR, null, (String) null)));
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62460a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        r12 = (r12 = r12.getProductList()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r16, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r17, android.content.Context r18, java.lang.Object r19) {
        /*
            r15 = this;
            r1 = r15
            r3 = r16
            r0 = r17
            r2 = r18
            java.lang.String r4 = ""
            java.lang.String r5 = "tag"
            kotlin.g.b.k.c(r3, r5)
            java.lang.String r5 = "context"
            kotlin.g.b.k.c(r2, r5)
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            r1.U = r0
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r5 = net.one97.paytm.recharge.di.helper.c.bQ()
            r6 = 1
            java.lang.String r7 = com.paytm.utility.c.a((android.content.Context) r2, (boolean) r6)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r9 = "Content-Type"
            java.lang.String r10 = "application/json"
            r8.put(r9, r10)
            kotlin.g.b.x$e r9 = new kotlin.g.b.x$e
            r9.<init>()
            r10 = 0
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ee }
            r11.<init>()     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r12 = "cin"
            java.lang.String r13 = r17.getCardId()     // Catch:{ JSONException -> 0x00ee }
            r11.put(r12, r13)     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r12 = "customer_id"
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r18)     // Catch:{ JSONException -> 0x00ee }
            r11.put(r12, r2)     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r2 = "recharge_number"
            java.lang.String r12 = r17.getDisplayCardNumber()     // Catch:{ JSONException -> 0x00ee }
            if (r12 != 0) goto L_0x0059
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x00ee }
        L_0x0059:
            java.lang.String r13 = " "
            r14 = 0
            java.lang.String r12 = kotlin.m.p.a(r12, r13, r4, r14)     // Catch:{ JSONException -> 0x00ee }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r12 = net.one97.paytm.recharge.common.utils.ba.d((java.lang.CharSequence) r12)     // Catch:{ JSONException -> 0x00ee }
            r11.put(r2, r12)     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r2 = "operator"
            java.lang.String r12 = r17.getOperaterLabel()     // Catch:{ JSONException -> 0x00ee }
            r11.put(r2, r12)     // Catch:{ JSONException -> 0x00ee }
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r17.getSelectedDCVariant()     // Catch:{ JSONException -> 0x00ee }
            if (r2 == 0) goto L_0x00c5
            java.util.List r2 = r2.getProductList()     // Catch:{ JSONException -> 0x00ee }
            if (r2 == 0) goto L_0x00c5
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ JSONException -> 0x00ee }
            boolean r2 = r2.isEmpty()     // Catch:{ JSONException -> 0x00ee }
            r2 = r2 ^ r6
            if (r2 != r6) goto L_0x00c5
            java.lang.String r2 = "service"
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r17.getSelectedDCVariant()     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00a2
            java.util.List r12 = r12.getProductList()     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00a2
            java.lang.Object r12 = r12.get(r14)     // Catch:{ JSONException -> 0x00ee }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r12     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00a2
            java.lang.String r12 = r12.getService()     // Catch:{ JSONException -> 0x00ee }
            goto L_0x00a3
        L_0x00a2:
            r12 = r10
        L_0x00a3:
            r11.put(r2, r12)     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r2 = "product_id"
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r17.getSelectedDCVariant()     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00c1
            java.util.List r12 = r12.getProductList()     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00c1
            java.lang.Object r12 = r12.get(r14)     // Catch:{ JSONException -> 0x00ee }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r12     // Catch:{ JSONException -> 0x00ee }
            if (r12 == 0) goto L_0x00c1
            java.lang.Long r12 = r12.getProductId()     // Catch:{ JSONException -> 0x00ee }
            goto L_0x00c2
        L_0x00c1:
            r12 = r10
        L_0x00c2:
            r11.put(r2, r12)     // Catch:{ JSONException -> 0x00ee }
        L_0x00c5:
            java.lang.String r2 = "category_id"
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r12 = r1.f61409b     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r12 = r12.getCategoryId()     // Catch:{ JSONException -> 0x00ee }
            r11.put(r2, r12)     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r2 = "delete_saved_card_api"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00ee }
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = "amount"
            java.lang.String r0 = r17.getRechargeAmount()     // Catch:{ JSONException -> 0x00ee }
            r11.put(r2, r0)     // Catch:{ JSONException -> 0x00ee }
        L_0x00e2:
            java.lang.String r0 = r11.toString()     // Catch:{ JSONException -> 0x00ee }
            java.lang.String r2 = "deleteItem.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x00ee }
            r9.element = r0     // Catch:{ JSONException -> 0x00ee }
            goto L_0x00f8
        L_0x00ee:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            r9.element = r4
        L_0x00f8:
            T r0 = r9.element
            java.lang.String r0 = (java.lang.String) r0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0155
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0155
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>>> r0 = r1.P
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r2 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            net.one97.paytm.recharge.model.v4.Data r4 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r6 = net.one97.paytm.recharge.model.v4.DataState.LOADING
            r4.<init>(r6, r10, r10)
            r2.<init>(r3, r4)
            r0.postValue(r2)
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.c r0 = new net.one97.paytm.recharge.common.f.c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r7)
            java.lang.String r4 = r2.toString()
            net.one97.paytm.recharge.creditcard.c.a$d r2 = new net.one97.paytm.recharge.creditcard.c.a$d
            r2.<init>(r15, r9)
            r5 = r2
            net.one97.paytm.recharge.common.e.ai r5 = (net.one97.paytm.recharge.common.e.ai) r5
            net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4 r2 = new net.one97.paytm.recharge.creditcard.v4.model.CJRDeleteCardV4
            r2.<init>()
            r6 = r2
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
            r7 = 0
            T r2 = r9.element
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            r2 = r0
            r3 = r16
            r10 = r19
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (net.one97.paytm.recharge.common.e.ai) r5, (com.paytm.network.model.IJRPaytmDataModel) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9, (java.lang.Object) r10)
            net.one97.paytm.recharge.common.f.a r0 = (net.one97.paytm.recharge.common.f.a) r0
            net.one97.paytm.recharge.common.f.d.b(r0)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(java.lang.String, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8, android.content.Context, java.lang.Object):void");
    }

    public static final class d implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62461a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f62462b;

        d(a aVar, x.e eVar) {
            this.f62461a = aVar;
            this.f62462b = eVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String str2;
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRDeleteCardV4) {
                if (obj instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    CJRDeleteCardV4.a info = ((CJRDeleteCardV4) iJRPaytmDataModel).getInfo();
                    if (info != null) {
                        str2 = info.f62624a;
                    } else {
                        str2 = null;
                    }
                    cJRRechargeErrorModel.setErrorMsg(str2);
                    CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                    if (flowName != null) {
                        flowName.setRequestBody((String) this.f62462b.element);
                    }
                    az azVar = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                }
                this.f62461a.P.postValue(new CJRTaggedObservable(str, new Data(DataState.ERROR, null, ((CJRDeleteCardV4) iJRPaytmDataModel).getMessage())));
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62461a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public static String d(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, str);
        } catch (JSONException e2) {
            com.paytm.utility.q.d(e2.getMessage());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("favLabelId", jSONArray);
            jSONObject.put("channel", "android");
            jSONObject.put("version", 2);
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "deleteItem.toString()");
            return jSONObject2;
        } catch (JSONException e3) {
            com.paytm.utility.q.d(e3.getMessage());
            return "";
        }
    }

    public static final class e implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62463a;

        public e(a aVar) {
            this.f62463a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62463a.P.postValue(new CJRTaggedObservable("tag.delete.saved.card", new Data(DataState.ERROR, null, (String) null)));
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62463a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public static final class f implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62464a;

        public f(a aVar) {
            this.f62464a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62464a.P.postValue(new CJRTaggedObservable("tag.delete.saved.card", new Data(DataState.ERROR, null, (String) null)));
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62464a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public static String a(String str, Context context) {
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String N = net.one97.paytm.recharge.di.helper.c.N();
        String sSOToken = CJRRechargeUtilities.INSTANCE.getSSOToken(context);
        try {
            return Uri.parse(N).buildUpon().appendQueryParameter("JsonData", "{\"SSOToken\":\"" + sSOToken + "\",\"SavedCardId\":\"" + str + "\"}").build().toString();
        } catch (Exception e2) {
            com.paytm.utility.q.d(e2.getMessage());
            return null;
        }
    }

    public final void a(net.one97.paytm.recharge.common.f.a aVar, Context context) {
        kotlin.g.b.k.c(aVar, "request");
        kotlin.g.b.k.c(context, "context");
        com.paytm.utility.h hVar = new com.paytm.utility.h(context);
        hVar.setTitle(context.getString(R.string.no_connection));
        hVar.a(context.getString(R.string.no_internet));
        hVar.a(-3, context.getString(R.string.network_retry_yes), new l(this, hVar, context, aVar));
        hVar.show();
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f62482b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f62483c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.f.a f62484d;

        l(a aVar, com.paytm.utility.h hVar, Context context, net.one97.paytm.recharge.common.f.a aVar2) {
            this.f62481a = aVar;
            this.f62482b = hVar;
            this.f62483c = context;
            this.f62484d = aVar2;
        }

        public final void onClick(View view) {
            this.f62482b.cancel();
            if (com.paytm.utility.b.c(this.f62483c)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(this.f62484d);
                return;
            }
            this.f62481a.a(this.f62484d, this.f62483c);
        }
    }

    static final class i<T> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f62467b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62468c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f62469d;

        i(a aVar, Context context, String str, Object obj) {
            this.f62466a = aVar;
            this.f62467b = context;
            this.f62468c = str;
            this.f62469d = obj;
        }

        public final void subscribe(final r<List<CJRFrequentOrder>> rVar) {
            kotlin.g.b.k.a((Object) rVar, "emitter");
            if (!rVar.isDisposed()) {
                List a2 = a.b("Financial Services", "Credit card");
                if (a2 == null || a2.isEmpty()) {
                    Context applicationContext = this.f62467b.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
                    net.one97.paytm.recharge.common.b.d.b(applicationContext).c(this.f62468c, new ai() {
                        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                            kotlin.g.b.k.c(str, "tag");
                            rVar.onNext(kotlin.a.w.INSTANCE);
                            if (obj instanceof CJRRechargeErrorModel) {
                                az azVar = az.f61525a;
                                az.a((CJRRechargeErrorModel) obj);
                            }
                        }

                        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                            kotlin.g.b.k.c(str, "tag");
                            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                            if (iJRPaytmDataModel != null) {
                                cJRRechargeUtilities.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
                                q qVar = q.f61722a;
                                List<CJRFrequentOrder> a2 = q.a("Financial Services", "Credit card");
                                if (a2 != null) {
                                    rVar.onNext(a2);
                                } else {
                                    rVar.onNext(kotlin.a.w.INSTANCE);
                                }
                                rVar.onComplete();
                                return;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrderList");
                        }
                    }, this.f62469d);
                    return;
                }
                rVar.onNext(a2);
                rVar.onComplete();
            }
        }
    }

    private io.reactivex.rxjava3.a.p<List<CJRFrequentOrder>> b(String str, Context context, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        io.reactivex.rxjava3.a.p<List<CJRFrequentOrder>> subscribeOn = io.reactivex.rxjava3.a.p.create(new i(this, context, str, obj)).subscribeOn(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) subscribeOn, "Observable.create<List<C…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    private final io.reactivex.rxjava3.a.p<CJRSavedCreditCardsModel> a(String str, String str2, Context context, Object obj) {
        io.reactivex.rxjava3.a.p<CJRSavedCreditCardsModel> subscribeOn = io.reactivex.rxjava3.a.p.create(new j(this, str2, str, obj, context)).subscribeOn(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) subscribeOn, "Observable.create<CJRSav…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    static final class j<T> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62471a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f62472b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f62473c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f62474d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f62475e;

        j(a aVar, String str, String str2, Object obj, Context context) {
            this.f62471a = aVar;
            this.f62472b = str;
            this.f62473c = str2;
            this.f62474d = obj;
            this.f62475e = context;
        }

        public final void subscribe(r<CJRSavedCreditCardsModel> rVar) {
            kotlin.g.b.k.a((Object) rVar, "emitter");
            if (!rVar.isDisposed()) {
                String a2 = new com.google.gsonhtcfix.f().a((Object) a.e(this.f62472b));
                String str = this.f62473c;
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, net.one97.paytm.recharge.di.helper.c.M(), (ai) new C1203a(rVar), (IJRPaytmDataModel) new CJRSavedCreditCardsModel(), (Map<String, String>) null, (Map<String, String>) null, a2, this.f62474d);
                if (com.paytm.utility.b.c(this.f62475e)) {
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(cVar2);
                }
            }
        }

        /* renamed from: net.one97.paytm.recharge.creditcard.c.a$j$a  reason: collision with other inner class name */
        public static final class C1203a implements ai {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ r f62476a;

            C1203a(r rVar) {
                this.f62476a = rVar;
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                kotlin.g.b.k.c(str, "tag");
                this.f62476a.onNext(new CJRSavedCreditCardsModel());
                this.f62476a.onComplete();
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
            }

            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                kotlin.g.b.k.c(str, "tag");
                r rVar = this.f62476a;
                if (iJRPaytmDataModel != null) {
                    rVar.onNext((CJRSavedCreditCardsModel) iJRPaytmDataModel);
                    this.f62476a.onComplete();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.creditcard.CJRSavedCreditCardsModel");
            }
        }
    }

    public final void b(String str, Context context) {
        kotlin.g.b.k.c(str, "ssoToken");
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.FETCH_RECENTS.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a3.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName3 = a3.getFlowName();
        if (flowName3 != null) {
            flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName4 = a3.getFlowName();
        if (flowName4 != null) {
            flowName4.setActionType(ACTION_TYPE.FETCH_SAVED_CARDS.name());
        }
        io.reactivex.rxjava3.a.p.zip(b("frequent_api", context, a2), a("saved_card_api", str, context, (Object) a3), new C1202a(this)).timeout(10000, TimeUnit.MILLISECONDS).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new b(this));
    }

    public static final class b implements io.reactivex.rxjava3.a.w<List<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62459a;

        public final void onComplete() {
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        b(a aVar) {
            this.f62459a = aVar;
        }

        public final /* synthetic */ void onNext(Object obj) {
            List list = (List) obj;
            kotlin.g.b.k.c(list, "t");
            a aVar = this.f62459a;
            aVar.S = true;
            aVar.T = true;
            aVar.Z = list;
            this.f62459a.c();
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            a aVar = this.f62459a;
            aVar.S = true;
            aVar.T = true;
            if (th instanceof TimeoutException) {
                aVar.O.postValue(null);
            } else {
                aVar.c();
            }
        }
    }

    public static final class h implements ai {
        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
        }

        h() {
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            if (iJRPaytmDataModel != null) {
                cJRRechargeUtilities.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrderList");
        }
    }

    public static void a(String str, Context context, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
        net.one97.paytm.recharge.common.b.d.b(applicationContext).c(str, new h(), obj);
    }

    public final void a(String str, Context context, String str2, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str2, "binNumber");
        kotlin.g.b.k.c(aiVar, "responseListener");
        CJRCreditCardBinModel cJRCreditCardBinModel = new CJRCreditCardBinModel(new CJRCreditCardHeadModel(), new CJRCreditCardBodyModel());
        CJRCreditCardHeadModel head = cJRCreditCardBinModel.getHead();
        if (head != null) {
            head.setClientId("IN");
        }
        CJRCreditCardHeadModel head2 = cJRCreditCardBinModel.getHead();
        if (head2 != null) {
            head2.setVersion("v1");
        }
        CJRCreditCardHeadModel head3 = cJRCreditCardBinModel.getHead();
        if (head3 != null) {
            head3.setRequestTimeStamp(String.valueOf(System.currentTimeMillis()));
        }
        CJRCreditCardHeadModel head4 = cJRCreditCardBinModel.getHead();
        if (head4 != null) {
            head4.setChannelId("APP");
        }
        CJRCreditCardHeadModel head5 = cJRCreditCardBinModel.getHead();
        if (head5 != null) {
            head5.setSignature("");
        }
        CJRCreditCardBodyModel body = cJRCreditCardBinModel.getBody();
        if (body != null) {
            body.setBinNumber(str2);
        }
        if (com.paytm.utility.b.c(context)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String Y2 = net.one97.paytm.recharge.di.helper.c.Y();
            if (Y2 != null) {
                this.s.a(context, str, Y2, (CJRCreditCardModel) cJRCreditCardBinModel, (CJRCreditCardModel) new CJRCreditCardBinModel(), aiVar, obj);
                return;
            }
            return;
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (kotlin.g.b.g) null), obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11, android.content.Context r12, java.lang.String r13, net.one97.paytm.recharge.common.e.ai r14, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r15, java.lang.Object r16) {
        /*
            r10 = this;
            r0 = r13
            java.lang.String r1 = "tag"
            r4 = r11
            kotlin.g.b.k.c(r11, r1)
            java.lang.String r1 = "context"
            r3 = r12
            kotlin.g.b.k.c(r12, r1)
            java.lang.String r1 = "cardNumber"
            kotlin.g.b.k.c(r13, r1)
            java.lang.String r1 = "responseListener"
            r8 = r14
            kotlin.g.b.k.c(r14, r1)
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r1 = new net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = new net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel
            r2.<init>()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r5 = new net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel
            r5.<init>()
            r1.<init>(r2, r5)
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = r1.getHead()
            java.lang.String r5 = "APP"
            if (r2 == 0) goto L_0x0032
            r2.setClientId(r5)
        L_0x0032:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = r1.getHead()
            if (r2 == 0) goto L_0x003e
            java.lang.String r6 = "v2"
            r2.setVersion(r6)
        L_0x003e:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = r1.getHead()
            if (r2 == 0) goto L_0x004f
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r2.setRequestTimeStamp(r6)
        L_0x004f:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = r1.getHead()
            if (r2 == 0) goto L_0x0058
            r2.setChannelId(r5)
        L_0x0058:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardHeadModel r2 = r1.getHead()
            if (r2 == 0) goto L_0x0063
            java.lang.String r5 = ""
            r2.setSignature(r5)
        L_0x0063:
            if (r15 == 0) goto L_0x00b2
            int r2 = r15.getCardTypeId()
            int r5 = r15.getRecentCardId()
            if (r2 != r5) goto L_0x0084
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.ab()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r2 = r1.getBody()
            if (r2 == 0) goto L_0x0082
            java.lang.String r5 = r15.getCardId()
            r2.setCreditCardId(r5)
        L_0x0082:
            r5 = r0
            goto L_0x00c2
        L_0x0084:
            int r2 = r15.getCardTypeId()
            int r5 = r15.getSavedCardId()
            if (r2 != r5) goto L_0x00a2
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.ac()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r2 = r1.getBody()
            if (r2 == 0) goto L_0x0082
            java.lang.String r5 = r15.getCardId()
            r2.setSavedCardId(r5)
            goto L_0x0082
        L_0x00a2:
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.aa()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r5 = r1.getBody()
            if (r5 == 0) goto L_0x00c1
            r5.setCardNumber(r13)
            goto L_0x00c1
        L_0x00b2:
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.aa()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r5 = r1.getBody()
            if (r5 == 0) goto L_0x00c1
            r5.setCardNumber(r13)
        L_0x00c1:
            r5 = r2
        L_0x00c2:
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r12)
            if (r0 == 0) goto L_0x00ef
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ed
            r0 = r10
            net.one97.paytm.recharge.common.b.c r2 = r0.s
            if (r5 != 0) goto L_0x00d9
            kotlin.g.b.k.a()
        L_0x00d9:
            r6 = r1
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel r6 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel) r6
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r1 = new net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel
            r1.<init>()
            r7 = r1
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel r7 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel) r7
            r3 = r12
            r4 = r11
            r8 = r14
            r9 = r16
            r2.a((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r5, (net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel) r6, (net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel) r7, (net.one97.paytm.recharge.common.e.ai) r8, (java.lang.Object) r9)
            return
        L_0x00ed:
            r0 = r10
            goto L_0x0105
        L_0x00ef:
            r0 = r10
            r1 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.as r2 = new net.one97.paytm.recharge.common.utils.as
            r3 = 0
            r6 = 1
            r7 = 0
            r2.<init>(r3, r6, r7)
            r6 = r2
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r2 = r14
            r3 = r11
            r4 = r1
            r7 = r16
            r2.a(r3, r4, r5, r6, r7)
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(java.lang.String, android.content.Context, java.lang.String, net.one97.paytm.recharge.common.e.ai, net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8, java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    public void a(String str, Context context, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, String str8, boolean z3, Object obj, ai aiVar) {
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str9, "amount");
        kotlin.g.b.k.c(str10, "productId");
        kotlin.g.b.k.c(str11, StringSet.token);
        kotlin.g.b.k.c(str12, "cr");
        kotlin.g.b.k.c(str13, "cr2");
        JSONObject jSONObject = new JSONObject();
        String a2 = a(str5);
        HashMap hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put(str10, str9);
        Map map = hashMap;
        map.put("recharge_number", str12);
        map.put("recharge_number_2", str13);
        map.put("token_id", str11);
        String str15 = ab.f61497b;
        kotlin.g.b.k.a((Object) str15, "CJRRechargeUtilityConstant.KEY_CATEGORY_ID");
        String categoryId = this.r.getCategoryId();
        kotlin.g.b.k.a((Object) categoryId, "rechargeItem.categoryId");
        map.put(str15, categoryId);
        jSONObject.put("bin_number", a2);
        if (str14 != null) {
            jSONObject.put("payment_request_type", str14);
        }
        if (z2) {
            jSONObject.put("enable_bill_payment", "1");
            map.put("recharge_number_2", str11);
            if (z) {
                jSONObject.put("enable_visa_direct", "1");
            }
        }
        jSONObject.put("id", com.paytm.utility.b.n(context));
        jSONObject.put("customer_mobile", com.paytm.utility.b.l(context));
        w wVar = this.t;
        if (wVar != null) {
            Map map2 = map;
            wVar.a(str, hashMap2, map2, jSONObject, str2, (String) null, true, false, this.f61411d, (List<CJRUtilityCheckboxItem>) null, z3, "Credit card", (List<CJRProductsItem>) null, obj, str7, str8, aiVar);
        }
    }

    public final void a(String str, Context context, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, String str8, boolean z3, CJRPersonalInsurance cJRPersonalInsurance, Object obj) {
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str9, "amount");
        kotlin.g.b.k.c(str10, "productId");
        kotlin.g.b.k.c(str11, StringSet.token);
        kotlin.g.b.k.c(str12, "cr");
        kotlin.g.b.k.c(str13, "cr2");
        JSONObject jSONObject = new JSONObject();
        String a2 = a(str5);
        HashMap hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put(str10, str9);
        Map map = hashMap;
        map.put("recharge_number", str12);
        map.put("recharge_number_2", str13);
        map.put("token_id", str11);
        String str15 = ab.f61497b;
        kotlin.g.b.k.a((Object) str15, "CJRRechargeUtilityConstant.KEY_CATEGORY_ID");
        String categoryId = this.r.getCategoryId();
        kotlin.g.b.k.a((Object) categoryId, "rechargeItem.categoryId");
        map.put(str15, categoryId);
        jSONObject.put("bin_number", a2);
        if (str14 != null) {
            jSONObject.put("payment_request_type", str14);
        }
        if (z2) {
            jSONObject.put("enable_bill_payment", "1");
            map.put("recharge_number_2", str11);
            if (z) {
                jSONObject.put("enable_visa_direct", "1");
            }
        }
        jSONObject.put("id", com.paytm.utility.b.n(context));
        jSONObject.put("customer_mobile", com.paytm.utility.b.l(context));
        w wVar = this.t;
        if (wVar != null) {
            wVar.a(str, (Map<String, String>) hashMap2, (Map<String, String>) map, jSONObject, str2, this.f61411d, z3, "Credit card", (List<CJRProductsItem>) null, obj, "", str8, cJRPersonalInsurance, (o) null, (ai) null);
        }
    }

    public final void a(String str, Context context, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, String str8, boolean z3, Object obj, ai aiVar, CJRPersonalInsurance cJRPersonalInsurance) {
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str9, "amount");
        kotlin.g.b.k.c(str10, "productId");
        kotlin.g.b.k.c(str11, StringSet.token);
        kotlin.g.b.k.c(str12, "cr");
        kotlin.g.b.k.c(str13, "cr2");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        JSONObject jSONObject = new JSONObject();
        String a2 = a(str5);
        HashMap hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put(str10, str9);
        Map map = hashMap;
        map.put("recharge_number", str12);
        map.put("recharge_number_2", str13);
        map.put("token_id", str11);
        String str15 = ab.f61497b;
        kotlin.g.b.k.a((Object) str15, "CJRRechargeUtilityConstant.KEY_CATEGORY_ID");
        String categoryId = this.r.getCategoryId();
        kotlin.g.b.k.a((Object) categoryId, "rechargeItem.categoryId");
        map.put(str15, categoryId);
        jSONObject.put("bin_number", a2);
        if (str14 != null) {
            jSONObject.put("payment_request_type", str14);
        }
        if (z2) {
            jSONObject.put("enable_bill_payment", "1");
            map.put("recharge_number_2", str11);
            if (z) {
                jSONObject.put("enable_visa_direct", "1");
            }
        }
        jSONObject.put("id", com.paytm.utility.b.n(context));
        jSONObject.put("customer_mobile", com.paytm.utility.b.l(context));
        w wVar = this.t;
        if (wVar != null) {
            wVar.a(str, (Map<String, String>) hashMap2, (Map<String, String>) map, jSONObject, str2, this.f61411d, z3, "Credit card", (List<CJRProductsItem>) null, obj, str7, str8, cJRPersonalInsurance, (o) null, aiVar);
        }
    }

    public final y<CJROffers> b() {
        return this.k;
    }

    public static final /* synthetic */ CJRSavedCreditCardsModel e(String str) {
        CJRSavedCreditCardsModel cJRSavedCreditCardsModel = new CJRSavedCreditCardsModel();
        CJRCreditCardHeadModel head = cJRSavedCreditCardsModel.getHead();
        if (head != null) {
            head.setClientId("IN");
        }
        CJRCreditCardHeadModel head2 = cJRSavedCreditCardsModel.getHead();
        if (head2 != null) {
            head2.setVersion("v1");
        }
        CJRCreditCardHeadModel head3 = cJRSavedCreditCardsModel.getHead();
        if (head3 != null) {
            head3.setRequestTimestamp(String.valueOf(System.currentTimeMillis()));
        }
        CJRCreditCardHeadModel head4 = cJRSavedCreditCardsModel.getHead();
        if (head4 != null) {
            head4.setChannelId("APP");
        }
        CJRCreditCardHeadModel head5 = cJRSavedCreditCardsModel.getHead();
        if (head5 != null) {
            head5.setSignature("");
        }
        CJRCreditCardBodyModel body = cJRSavedCreditCardsModel.getBody();
        if (body != null) {
            body.setCardType(Constants.EASYPAY_PAYTYPE_CREDIT_CARD);
        }
        CJRCreditCardBodyModel body2 = cJRSavedCreditCardsModel.getBody();
        if (body2 != null) {
            body2.setPaytmSsoToken(str);
        }
        return cJRSavedCreditCardsModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if ((!r3.isEmpty()) == false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        r10 = r10.getMSavedCardList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.util.List a(java.util.List r9, net.one97.paytm.recharge.model.creditcard.CJRSavedCreditCardsModel r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r2 = 1
            if (r9 == 0) goto L_0x0017
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x0049
        L_0x0017:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 == 0) goto L_0x0157
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            java.util.List r3 = r3.getMSavedCardList()
            if (r3 == 0) goto L_0x0157
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            java.util.List r3 = r3.getMSavedCardList()
            if (r3 != 0) goto L_0x003e
            kotlin.g.b.k.a()
        L_0x003e:
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 != 0) goto L_0x0049
            goto L_0x0157
        L_0x0049:
            r1 = 0
            if (r9 == 0) goto L_0x0141
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x0054
            goto L_0x0141
        L_0x0054:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 == 0) goto L_0x013a
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            java.util.List r3 = r3.getMSavedCardList()
            if (r3 == 0) goto L_0x013a
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r10.getBody()
            if (r3 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            java.util.List r3 = r3.getMSavedCardList()
            if (r3 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 != 0) goto L_0x0086
            goto L_0x013a
        L_0x0086:
            java.util.Iterator r9 = r9.iterator()
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r10 = r10.getBody()
            if (r10 == 0) goto L_0x009d
            java.util.List r10 = r10.getMSavedCardList()
            if (r10 == 0) goto L_0x009d
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.List r10 = kotlin.a.k.c(r10)
            goto L_0x009e
        L_0x009d:
            r10 = r1
        L_0x009e:
            if (r10 != 0) goto L_0x00a3
            kotlin.g.b.k.a()
        L_0x00a3:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r9.next()
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r3 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r3
            r4 = r3
            net.one97.paytm.common.entity.IJRDataModel r4 = (net.one97.paytm.common.entity.IJRDataModel) r4
            java.lang.String r4 = b((net.one97.paytm.common.entity.IJRDataModel) r4)
            r5 = 0
            java.util.Iterator r6 = r10.iterator()
        L_0x00bb:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0127
            java.lang.Object r7 = r6.next()
            net.one97.paytm.common.entity.IJRDataModel r7 = (net.one97.paytm.common.entity.IJRDataModel) r7
            java.lang.String r8 = b((net.one97.paytm.common.entity.IJRDataModel) r7)
            if (r4 == 0) goto L_0x00db
            if (r8 != 0) goto L_0x00d2
            kotlin.g.b.k.a()
        L_0x00d2:
            int r8 = r4.compareTo(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00dc
        L_0x00db:
            r8 = r1
        L_0x00dc:
            if (r8 != 0) goto L_0x00df
            goto L_0x00bb
        L_0x00df:
            int r8 = r8.intValue()
            if (r8 != 0) goto L_0x00bb
            boolean r4 = r7 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel
            if (r4 == 0) goto L_0x0126
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r7 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel) r7
            boolean r4 = r7.isPaytmFirstCard()
            r3.setIsPaytmFirstCard(r4)
            java.util.Map r4 = r3.getOperatorDataNew()
            java.lang.String r5 = "cardId"
            if (r4 == 0) goto L_0x010b
            java.util.Map r4 = r3.getOperatorDataNew()
            java.lang.String r8 = "card.operatorDataNew"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r7 = r7.getCardId()
            r4.put(r5, r7)
            goto L_0x0120
        L_0x010b:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r7 = r7.getCardId()
            if (r7 != 0) goto L_0x011a
            java.lang.String r7 = ""
        L_0x011a:
            r4.put(r5, r7)
            r3.setOperatorDataNew(r4)
        L_0x0120:
            r6.remove()
            r0.add(r3)
        L_0x0126:
            r5 = 1
        L_0x0127:
            if (r5 != 0) goto L_0x00a3
            r0.add(r3)
            goto L_0x00a3
        L_0x012e:
            int r9 = r10.size()
            if (r9 <= 0) goto L_0x0139
            java.util.Collection r10 = (java.util.Collection) r10
            r0.addAll(r10)
        L_0x0139:
            return r0
        L_0x013a:
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.List r9 = kotlin.a.k.c(r9)
            return r9
        L_0x0141:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r9 = r10.getBody()
            if (r9 == 0) goto L_0x014b
            java.util.List r1 = r9.getMSavedCardList()
        L_0x014b:
            if (r1 != 0) goto L_0x0150
            kotlin.g.b.k.a()
        L_0x0150:
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r9 = kotlin.a.k.c(r1)
            return r9
        L_0x0157:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.c.a.a(java.util.List, net.one97.paytm.recharge.model.creditcard.CJRSavedCreditCardsModel):java.util.List");
    }
}
