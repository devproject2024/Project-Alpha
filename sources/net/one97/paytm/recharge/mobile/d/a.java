package net.one97.paytm.recharge.mobile.d;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.a.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;
import kotlin.g.a.s;
import kotlin.g.b.g;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.d;
import net.one97.paytm.recharge.common.utils.ac;
import net.one97.paytm.recharge.common.utils.aq;
import net.one97.paytm.recharge.common.utils.n;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.model.CJRMNPDataModel;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRGroupings;
import net.one97.paytm.recharge.model.v4.CJRMetaInfo;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRProtectionUrl;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import org.json.JSONObject;

public final class a extends net.one97.paytm.recharge.common.h.b implements d {
    public boolean A;
    public y<CJRFrequentOrder> B = new y<>();
    public ContactItemModel C;
    public final HashMap<String, ac> D = new HashMap<>();
    public boolean E;
    public final y<LinkedList<CJRSelectedGroupItem>> F = new y<>();
    public final y<CJRProductsItem> G = new y<>();
    public final y<Boolean> H = new y<>();
    public boolean I;
    public final y<CJRBrowsePlanProductList> J = new y<>();
    public final y<Boolean> K = new y<>();
    public String L;
    public String M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public CJRRechargeCart S;
    public y<CJRPersonalInsurance> T = new y<>();
    public final e<Object, HashMap<String, CJRBrowsePlanSearchModelV8>> U = new e<>(5);
    public final e<Object, WeakHashMap<String, CJRBrowsePlanResponseModelV8>> V = new e<>(5);
    public Integer W;
    public HashMap<String, Boolean> X;
    public HashMap<String, Boolean> Y;
    public HashMap<String, Boolean> Z;
    public final net.one97.paytm.recharge.mobile.b aa;
    private String ab;
    private boolean ac;
    private boolean ad;
    private ac ae;
    private net.one97.paytm.recharge.mobile.c.a af;
    private long ag = -1;
    private String ah = "";
    private String ai;
    private y<List<CJRBrowsePlanProductList>> aj = new y<>();
    private long ak = -1;
    private final e<Long, HashMap<String, CJRRechargeCart>> al = new e<>(2);
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.b.c am;
    public boolean w;
    public final net.one97.paytm.recharge.common.b.a x = new net.one97.paytm.recharge.common.b.a(this.f61409b);
    public final y<CJRRelatedCategory> y = new y<>();
    public final y<String> z = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CJRItem cJRItem, net.one97.paytm.recharge.mobile.b bVar, w wVar, kotlin.k.e<x> eVar, net.one97.paytm.recharge.ordersummary.h.d dVar) {
        super(cJRItem, bVar, wVar, eVar, dVar);
        k.c(cJRItem, "rechargeItem");
        k.c(bVar, "mobileRechargeRepo");
        k.c(eVar, "errorHandler");
        k.c(dVar, "gtmEventHelper");
        this.aa = bVar;
        this.f61409b.setCategoryId(cJRItem.getCategoryId());
        if (!this.m.containsKey("recharge_number") ? !this.m.containsKey("number") ? !this.m.containsKey(ContactColumn.PHONE_NUMBER) || TextUtils.isEmpty(this.m.get(ContactColumn.PHONE_NUMBER)) : TextUtils.isEmpty(this.m.get("number")) : TextUtils.isEmpty(this.m.get("recharge_number"))) {
            this.A = true;
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        c("check_subscription", (ai) null, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED));
        this.X = new HashMap<>();
        this.Y = new HashMap<>();
        this.Z = new HashMap<>();
    }

    public final CJRCategoryDataHelper g() {
        return new CJRCategoryDataHelper();
    }

    public final net.one97.paytm.recharge.common.utils.x h() {
        return new net.one97.paytm.recharge.common.utils.x();
    }

    public static LiveData<List<ContactItemModel>> a(androidx.loader.a.a aVar) {
        k.c(aVar, "loaderManager");
        return n.f61679a.a(aVar);
    }

    public final void a(String str) {
        k.c(str, "mobileNumber");
        this.z.setValue(str);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        this.B.setValue(cJRFrequentOrder);
        if (cJRFrequentOrder != null) {
            this.ac = false;
        }
    }

    public final CJRFrequentOrder j() {
        return this.B.getValue();
    }

    public final void k() {
        this.z.setValue(null);
    }

    public final void l() {
        this.ac = true;
        this.B.setValue(null);
    }

    public final void a(CJRRelatedCategory cJRRelatedCategory) {
        k.c(cJRRelatedCategory, "rcButton");
        this.y.setValue(cJRRelatedCategory);
    }

    public final void b(CJRRechargeErrorModel cJRRechargeErrorModel) {
        String str;
        Long categoryId;
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        k.c(cJRRechargeErrorModel2, "errorModel");
        CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
        }
        cJRRechargeErrorModel2.setVerticalName(VERTICAL.RECHARGES);
        cJRRechargeErrorModel2.setErrorType(ERROR_TYPE.UNDEFINED);
        CJRCategoryData categoryData = this.f61409b.getCategoryData();
        if (categoryData == null || (categoryId = categoryData.getCategoryId()) == null || (str = String.valueOf(categoryId.longValue())) == null) {
            str = this.r.getCategoryId();
        }
        cJRRechargeErrorModel2.setCategoryId(str);
        cJRRechargeErrorModel2.setProductId((String) null);
        cJRRechargeErrorModel2.setRechargeItemCategoryId(this.r.getCategoryId());
        cJRRechargeErrorModel2.setScreenName(e().toString());
        cJRRechargeErrorModel2.setUserFacing(a.b.USER_FACING);
        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        cJRRechargeErrorModel2.setFlowName(flowName);
    }

    public final void a(LinkedList<CJRSelectedGroupItem> linkedList) {
        this.F.setValue(linkedList);
    }

    public final void a(CJRProductsItem cJRProductsItem) {
        this.ah = null;
        this.G.setValue(cJRProductsItem);
        if (cJRProductsItem == null) {
            a((LinkedList<CJRSelectedGroupItem>) null);
            this.J.setValue(null);
        }
    }

    public final void m() {
        this.H.setValue(Boolean.TRUE);
    }

    public final boolean b() {
        return this.I;
    }

    public final void a(boolean z2) {
        this.K.setValue(Boolean.valueOf(z2));
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        this.J.setValue(cJRBrowsePlanProductList);
    }

    public final void n() {
        for (Map.Entry<String, Boolean> key : this.Z.entrySet()) {
            Object key2 = key.getKey();
            k.a(key2, "entry.key");
            this.Z.put(key2, Boolean.TRUE);
        }
    }

    public final void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        k.c(cJRRechargeErrorModel, "errorModel");
        cJRRechargeErrorModel.setVerticalName(VERTICAL.RECHARGES);
        cJRRechargeErrorModel.setUserFacing(a.b.USER_FACING);
        super.a(cJRRechargeErrorModel);
    }

    public final boolean a(String str, String str2, Object obj, ai aiVar, net.one97.paytm.recharge.common.b.a.a aVar) {
        k.c(str, "tag");
        k.c(str2, "url");
        String d2 = net.one97.paytm.recharge.common.utils.g.d(str2);
        try {
            CJRCategoryData relatedCategoryData = this.f61409b.getRelatedCategoryData(d2);
            if (relatedCategoryData != null) {
                if (!d2.equals(this.f61409b.getCategoryId())) {
                    relatedCategoryData.removeAllSelections();
                    this.f61409b.setCategoryData(d2, relatedCategoryData);
                    return true;
                }
                return false;
            }
            a(str, d2, aiVar, aVar, obj);
            return true;
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public final void a(String str, String str2, ai aiVar, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        k.c(str, "tag");
        if (net.one97.paytm.recharge.common.utils.g.c(str2)) {
            this.ab = str2;
            net.one97.paytm.recharge.common.b.c cVar = this.s;
            if (aiVar == null) {
                aiVar = this;
            }
            ai aiVar2 = aiVar;
            if (str2 == null) {
                k.a();
            }
            if (aVar == null) {
                aVar = this;
            }
            cVar.a(str, aiVar2, str2, (String) null, aVar, obj);
        }
    }

    private List<CJRProductsItem> a(CJRSelectedGroupItem cJRSelectedGroupItem) {
        List<CJRProductsItem> list;
        List<CJRAggsItem> aggs;
        List<CJRAggsItem> aggs2;
        boolean z2;
        k.c(cJRSelectedGroupItem, "lastSelectedGrouping");
        CJRAggsItem item = cJRSelectedGroupItem.getItem();
        Long l = null;
        if (item == null || (aggs = item.getAggs()) == null || aggs.isEmpty()) {
            CJRAggsItem item2 = cJRSelectedGroupItem.getItem();
            if (item2 == null) {
                return null;
            }
            list = item2.getProductList();
        } else {
            CJRAggsItem item3 = cJRSelectedGroupItem.getItem();
            if (item3 == null || (aggs2 = item3.getAggs()) == null) {
                return null;
            }
            CJRProductsItem cJRProductsItem = (CJRProductsItem) this.G.getValue();
            if (cJRProductsItem != null) {
                l = cJRProductsItem.getProductId();
            }
            Collection arrayList = new ArrayList();
            Iterator it2 = aggs2.iterator();
            while (true) {
                boolean z3 = false;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                List<CJRProductsItem> productList = ((CJRAggsItem) next).getProductList();
                if (productList != null) {
                    Iterable iterable = productList;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it3 = iterable.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (k.a((Object) ((CJRProductsItem) it3.next()).getProductId(), (Object) l)) {
                                    z2 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                        z3 = true;
                    }
                }
                if (z3) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            if (!list2.isEmpty()) {
                list = ((CJRAggsItem) list2.get(0)).getProductList();
            } else {
                list = aggs2.get(0).getProductList();
            }
        }
        return list;
    }

    /* renamed from: net.one97.paytm.recharge.mobile.d.a$a  reason: collision with other inner class name */
    public static final class C1242a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63701a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f63702b;

        /* renamed from: net.one97.paytm.recharge.mobile.d.a$a$a  reason: collision with other inner class name */
        static final /* synthetic */ class C1243a extends i implements s<String, Integer, IJRPaytmDataModel, NetworkCustomError, Object, x> {
            C1243a(a aVar) {
                super(5, aVar);
            }

            public final String getName() {
                return "handleErrorCode";
            }

            public final kotlin.k.d getOwner() {
                return kotlin.g.b.y.b(a.class);
            }

            public final String getSignature() {
                return "handleErrorCode(Ljava/lang/String;ILcom/paytm/network/model/IJRPaytmDataModel;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
            }

            public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                invoke((String) obj, ((Number) obj2).intValue(), (IJRPaytmDataModel) obj3, (NetworkCustomError) obj4, obj5);
                return x.f47997a;
            }

            public final void invoke(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                k.c(str, "p1");
                ((a) this.receiver).a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }

        public C1242a(a aVar, String str) {
            this.f63701a = aVar;
            this.f63702b = str;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            Boolean bool = (Boolean) this.f63701a.Z.get(this.f63702b);
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            if (!bool.booleanValue()) {
                Boolean bool2 = (Boolean) this.f63701a.Y.get(this.f63702b);
                if (bool2 == null) {
                    bool2 = Boolean.TRUE;
                }
                if (!bool2.booleanValue()) {
                    this.f63701a.Y.put(this.f63702b, Boolean.TRUE);
                    this.f63701a.z.setValue(this.f63702b);
                    new C1243a(this.f63701a).invoke(str, 0, null, new aq(networkCustomError, this.f63702b), obj);
                }
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            Boolean bool = (Boolean) this.f63701a.Z.get(this.f63702b);
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            if (!bool.booleanValue() && (iJRPaytmDataModel instanceof CJRMNPDataModel)) {
                this.f63701a.X.put(this.f63702b, Boolean.TRUE);
                ac data = ((CJRMNPDataModel) iJRPaytmDataModel).getData();
                if (data != null) {
                    this.f63701a.D.put(this.f63702b, data);
                    Boolean bool2 = (Boolean) this.f63701a.Y.get(this.f63702b);
                    if (bool2 == null) {
                        bool2 = Boolean.TRUE;
                    }
                    if (!bool2.booleanValue()) {
                        a.a(this.f63701a, this.f63702b, data, false, false, 12);
                    }
                }
            }
        }
    }

    public final void a(String str, boolean z2) {
        k.c(str, "mobileNumber");
        ac acVar = new ac();
        LinkedList<CJRSelectedGroupItem> value = this.F.getValue();
        if (value != null) {
            for (CJRSelectedGroupItem cJRSelectedGroupItem : value) {
                String groupName = cJRSelectedGroupItem.getGroupName();
                if (!TextUtils.isEmpty(groupName)) {
                    Map map = acVar;
                    if (groupName == null) {
                        k.a();
                    }
                    String value2 = cJRSelectedGroupItem.getValue();
                    if (value2 == null) {
                        value2 = "";
                    }
                    map.put(groupName, value2);
                }
            }
        }
        if (!acVar.isEmpty()) {
            a(this, str, acVar, z2, false, 8);
        } else {
            a(acVar, z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
        r1 = r1.getProductId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r34, net.one97.paytm.recharge.common.e.ai r35, java.lang.Object r36) {
        /*
            r33 = this;
            r0 = r33
            r2 = r34
            r7 = r36
            java.lang.String r1 = "tag"
            kotlin.g.b.k.c(r2, r1)
            java.lang.String r1 = "responseListener"
            r3 = r35
            kotlin.g.b.k.c(r3, r1)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r0.G
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            r4 = -1
            if (r1 == 0) goto L_0x0029
            java.lang.Long r1 = r1.getProductId()
            if (r1 == 0) goto L_0x0029
            long r8 = r1.longValue()
            goto L_0x002a
        L_0x0029:
            r8 = r4
        L_0x002a:
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x005d
            androidx.lifecycle.y<java.lang.String> r1 = r0.z
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = net.one97.paytm.recharge.common.utils.g.c(r1)
            if (r1 == 0) goto L_0x005d
            r0.ag = r8
            net.one97.paytm.recharge.mobile.b r1 = r0.aa
            androidx.lifecycle.y<java.lang.String> r4 = r0.z
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x004b
            kotlin.g.b.k.a()
        L_0x004b:
            java.lang.String r5 = "enteredMobileNumber.value!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = (java.lang.String) r4
            r2 = r34
            r3 = r35
            r5 = r8
            r7 = r36
            r1.a(r2, r3, r4, r5, r7)
            return
        L_0x005d:
            boolean r1 = r7 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x00cb
            r1 = r7
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r1.getFlowName()
            if (r4 != 0) goto L_0x0098
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r10 = r4
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
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
            r31 = 1048575(0xfffff, float:1.469367E-39)
            r32 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
        L_0x0098:
            r1.setFlowName(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r1.getFlowName()
            if (r4 == 0) goto L_0x00a4
            r4.setTag(r2)
        L_0x00a4:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r1.getFlowName()
            if (r1 == 0) goto L_0x00cb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "One2OneOffer Api Call - ProductId - "
            r4.<init>(r5)
            r4.append(r8)
            java.lang.String r5 = " MobileNumber - "
            r4.append(r5)
            androidx.lifecycle.y<java.lang.String> r5 = r0.z
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.setOtherDetails(r4)
        L_0x00cb:
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r35
            r2 = r34
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r36
            r1.a(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.b(java.lang.String, net.one97.paytm.recharge.common.e.ai, java.lang.Object):void");
    }

    private final List<Map<?, ?>> s() {
        if (TextUtils.isEmpty(this.ah)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("key", "customer_type");
        String str = this.ah;
        if (str == null) {
            str = "";
        }
        map.put("value", str);
        arrayList.add(hashMap);
        return arrayList;
    }

    public final void a(String str, ai aiVar, Object obj) {
        String str2;
        CJRExtensionAttributes extnAttrs;
        WeakHashMap weakHashMap;
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        if (obj != null) {
            String productId = ((CJRRechargeErrorModel) obj).getProductId();
            boolean z2 = false;
            if (!(productId == null || (weakHashMap = this.V.get(productId)) == null || !weakHashMap.containsKey(this.z.getValue()))) {
                z2 = true;
                aiVar.a_(str, (IJRPaytmDataModel) weakHashMap.get(this.z.getValue()), obj);
            }
            if (!z2) {
                this.ai = this.f61409b.getURLQueryParams();
                CJRCategoryData categoryData = this.f61409b.getCategoryData();
                if (categoryData == null || (extnAttrs = categoryData.getExtnAttrs()) == null || (str2 = extnAttrs.getBrowsePlansCategory()) == null) {
                    str2 = "";
                }
                String str3 = str2;
                if (!TextUtils.isEmpty(this.ai)) {
                    net.one97.paytm.recharge.mobile.b bVar = this.aa;
                    String str4 = this.ai;
                    if (str4 == null) {
                        k.a();
                    }
                    CJRProductsItem value = this.G.getValue();
                    bVar.a(str, aiVar, str3, str4, value != null ? value.getDynamicPlansGrouping() : null, s(), obj);
                    return;
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) null, obj);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f63703a;

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
        }

        b(ai aiVar) {
            this.f63703a = aiVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f63703a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final LiveData<List<CJRBrowsePlanProductList>> a(String str, String str2, String[] strArr, Object obj) {
        k.c(str, "tag");
        k.c(str2, "characterSearch");
        k.c(strArr, "searchKeys");
        b(str, this, str2, strArr, obj);
        return this.aj;
    }

    public final LiveData<List<CJRBrowsePlanProductList>> a(String str, ai aiVar, String str2, String[] strArr, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "characterSearch");
        k.c(strArr, "searchKeys");
        b(str, aiVar, str2, strArr, obj);
        return this.aj;
    }

    public final void b(String str, ai aiVar, String str2, String[] strArr, Object obj) {
        String str3;
        CJRExtensionAttributes extnAttrs;
        String browsePlansCategory;
        HashMap hashMap;
        String str4 = str;
        ai aiVar2 = aiVar;
        String str5 = str2;
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "characterSearch");
        k.c(strArr, "searchKeys");
        List<Map<?, ?>> list = null;
        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) (!(obj2 instanceof CJRRechargeErrorModel) ? null : obj2);
        String str6 = "";
        if (cJRRechargeErrorModel == null || cJRRechargeErrorModel.getProductId() == null) {
            str3 = str6;
        } else {
            str3 = cJRRechargeErrorModel.getProductId() + '-' + this.z.getValue();
        }
        boolean z2 = true;
        if (!(str3.length() > 0) || this.U.get(str3) == null || (hashMap = this.U.get(str3)) == null || !hashMap.containsKey(str2)) {
            z2 = false;
        } else {
            aiVar.a_(str, (IJRPaytmDataModel) hashMap.get(str2), obj2);
        }
        if (!z2) {
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            if (!(categoryData == null || (extnAttrs = categoryData.getExtnAttrs()) == null || (browsePlansCategory = extnAttrs.getBrowsePlansCategory()) == null)) {
                str6 = browsePlansCategory;
            }
            net.one97.paytm.recharge.mobile.b bVar = this.aa;
            JSONObject filterJSON = this.f61409b.getFilterJSON();
            CJRProductsItem value = this.G.getValue();
            if (value != null) {
                list = value.getDynamicPlansGrouping();
            }
            bVar.a(str, aiVar, str6, filterJSON, str2, strArr, list, s(), obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001c, code lost:
        r4 = r4.getProductId();
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r15, net.one97.paytm.recharge.common.e.i r16, java.lang.String r17, java.lang.Object r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r16
            r2 = r18
            java.lang.String r3 = "tag"
            r5 = r15
            kotlin.g.b.k.c(r15, r3)
            java.lang.String r3 = "statusListener"
            kotlin.g.b.k.c(r1, r3)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r0.G
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            r6 = -1
            if (r4 == 0) goto L_0x0027
            java.lang.Long r4 = r4.getProductId()
            if (r4 == 0) goto L_0x0027
            long r8 = r4.longValue()
            goto L_0x0028
        L_0x0027:
            r8 = r6
        L_0x0028:
            androidx.a.e<java.lang.Long, java.util.HashMap<java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart>> r4 = r0.al
            java.lang.Long r10 = java.lang.Long.valueOf(r8)
            java.lang.Object r4 = r4.get(r10)
            if (r4 == 0) goto L_0x007b
            androidx.a.e<java.lang.Long, java.util.HashMap<java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart>> r4 = r0.al
            java.lang.Long r10 = java.lang.Long.valueOf(r8)
            java.lang.Object r4 = r4.get(r10)
            if (r4 != 0) goto L_0x0043
            kotlin.g.b.k.a()
        L_0x0043:
            java.lang.String r10 = "productIdWithFetchBillResponseMap[productId]!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            java.util.HashMap r4 = (java.util.HashMap) r4
            androidx.lifecycle.y<java.lang.String> r10 = r0.z
            java.lang.Object r10 = r10.getValue()
            if (r10 != 0) goto L_0x0055
            kotlin.g.b.k.a()
        L_0x0055:
            boolean r10 = r4.containsKey(r10)
            if (r10 == 0) goto L_0x007b
            androidx.lifecycle.y<java.lang.String> r10 = r0.z
            java.lang.Object r10 = r10.getValue()
            if (r10 != 0) goto L_0x0066
            kotlin.g.b.k.a()
        L_0x0066:
            java.lang.Object r4 = r4.get(r10)
            if (r4 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            java.lang.String r10 = "resWithNumberMap[enteredMobileNumber.value!!]!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            net.one97.paytm.common.entity.CJRRechargeCart r4 = (net.one97.paytm.common.entity.CJRRechargeCart) r4
            r14.a((net.one97.paytm.common.entity.CJRRechargeCart) r4, (net.one97.paytm.recharge.common.e.i) r1, (java.lang.Object) r2)
            r4 = 0
            goto L_0x007c
        L_0x007b:
            r4 = 1
        L_0x007c:
            if (r4 == 0) goto L_0x00cd
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x00cd
            androidx.lifecycle.y<java.lang.String> r4 = r0.z
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = net.one97.paytm.recharge.common.utils.g.c(r4)
            if (r4 == 0) goto L_0x00cd
            r0.ak = r8
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r4 = r12
            java.util.Map r4 = (java.util.Map) r4
            r4.put(r3, r1)
            java.lang.String r1 = "hawkEyeModel"
            r4.put(r1, r2)
            net.one97.paytm.recharge.mobile.b r4 = r0.aa
            r6 = r0
            net.one97.paytm.recharge.common.e.ai r6 = (net.one97.paytm.recharge.common.e.ai) r6
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r0.f61409b
            java.lang.String r1 = r1.getCategoryId()
            if (r1 != 0) goto L_0x00b1
            java.lang.String r1 = ""
        L_0x00b1:
            r7 = r1
            androidx.lifecycle.y<java.lang.String> r1 = r0.z
            java.lang.Object r1 = r1.getValue()
            if (r1 != 0) goto L_0x00bd
            kotlin.g.b.k.a()
        L_0x00bd:
            java.lang.String r2 = "enteredMobileNumber.value!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            boolean r13 = r0.w
            r5 = r15
            r11 = r17
            r4.a(r5, r6, r7, r8, r10, r11, r12, r13)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(java.lang.String, net.one97.paytm.recharge.common.e.i, java.lang.String, java.lang.Object):void");
    }

    public final boolean o() {
        String value = this.z.getValue();
        return this.N && value != null && value.equals(this.M) && !this.O;
    }

    public static /* synthetic */ void a(a aVar, String str, ac acVar, boolean z2, boolean z3, int i2) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            z3 = false;
        }
        aVar.a(str, acVar, z2, z3);
    }

    private void a(String str, ac acVar, boolean z2, boolean z3) {
        CJRRelatedCategory cJRRelatedCategory;
        String str2;
        String value;
        String str3;
        String value2;
        String str4;
        String value3;
        k.c(str, "mobileNumber");
        k.c(acVar, "responseMap");
        this.z.setValue(str);
        k.c(acVar, "responseMap");
        CJRRelatedCategory value4 = this.y.getValue();
        List<CJRRelatedCategory> relatedCategories = this.f61409b.getRelatedCategories();
        if (relatedCategories != null) {
            cJRRelatedCategory = null;
            for (CJRRelatedCategory cJRRelatedCategory2 : relatedCategories) {
                if (!TextUtils.isEmpty(cJRRelatedCategory2.getValue()) && (!z3 || j() == null ? !(this.ac || (!p.a(BaseViewModel.PaymentType.POSTPAID, cJRRelatedCategory2.getValue(), true) || (str3 = (String) acVar.get((Object) BaseViewModel.PaymentType.POSTPAID)) == null || !p.a(str3, "true", true) ? !p.a("prepaid", cJRRelatedCategory2.getValue(), true) || (str2 = (String) acVar.get((Object) BaseViewModel.PaymentType.POSTPAID)) == null || !p.a(str2, "false", true) || value4 == null || (value = value4.getValue()) == null || p.a(value, cJRRelatedCategory2.getValue(), true) : value4 == null || (value2 = value4.getValue()) == null || p.a(value2, cJRRelatedCategory2.getValue(), true))) : !((str4 = (String) acVar.get((Object) "paytype")) == null || !p.a(str4, cJRRelatedCategory2.getValue(), true) || value4 == null || (value3 = value4.getValue()) == null || p.a(value3, cJRRelatedCategory2.getValue(), true)))) {
                    cJRRelatedCategory = cJRRelatedCategory2;
                }
            }
        } else {
            cJRRelatedCategory = null;
        }
        if (cJRRelatedCategory == null) {
            a(acVar, z2);
            return;
        }
        this.E = true;
        this.ae = acVar;
        a(cJRRelatedCategory);
        if (!TextUtils.isEmpty(cJRRelatedCategory.getUrl())) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.RC_AUTO_CHANGED.name());
            }
            String url = cJRRelatedCategory.getUrl();
            if (url == null) {
                k.a();
            }
            boolean unused = a("get.rc.category", url, (Object) a2, (ai) null, (net.one97.paytm.recharge.common.b.a.a) null);
        }
    }

    private void a(ac acVar, boolean z2) {
        net.one97.paytm.recharge.mobile.c.a aVar;
        k.c(acVar, "responseMap");
        this.E = false;
        net.one97.paytm.recharge.mobile.c.a aVar2 = this.af;
        if ((aVar2 != null ? aVar2.getStatus() : null) == AsyncTask.Status.RUNNING && (aVar = this.af) != null) {
            aVar.cancel(true);
        }
        this.af = new net.one97.paytm.recharge.mobile.c.a(this.f61409b, this.F, z2);
        net.one97.paytm.recharge.mobile.c.a aVar3 = this.af;
        if (aVar3 != null) {
            aVar3.execute(new ac[]{acVar});
        }
    }

    public final void p() {
        ac acVar;
        if (this.E && (acVar = this.ae) != null) {
            if (acVar == null) {
                k.a();
            }
            a(acVar, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x019a A[SYNTHETIC, Splitter:B:108:0x019a] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01e8 A[Catch:{ Exception -> 0x021d }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0215 A[SYNTHETIC, Splitter:B:134:0x0215] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.common.entity.CJRRechargeCart r13, net.one97.paytm.recharge.common.e.i r14, java.lang.Object r15) {
        /*
            r12 = this;
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r13.getCart()
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            r1 = 0
            r2 = 1
            r3 = 5
            android.os.Bundle r3 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r1, (net.one97.paytm.common.entity.CJRRechargeCart) r13, (boolean) r2, (int) r3)
            java.lang.String r4 = "extra.has.error"
            boolean r3 = r3.getBoolean(r4)
            java.lang.String r4 = "-"
            java.lang.String r5 = "0"
            r6 = 32
            java.lang.String r7 = ""
            r8 = 0
            if (r3 != 0) goto L_0x013f
            if (r0 == 0) goto L_0x002b
            java.util.ArrayList r15 = r0.getCartItems()
            if (r15 == 0) goto L_0x002b
            java.util.ArrayList r15 = r0.getCartItems()
            goto L_0x002c
        L_0x002b:
            r15 = r1
        L_0x002c:
            if (r15 == 0) goto L_0x003b
            int r0 = r15.size()
            if (r0 <= 0) goto L_0x003b
            java.lang.Object r15 = r15.get(r8)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r15 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r15
            goto L_0x003c
        L_0x003b:
            r15 = r1
        L_0x003c:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            if (r15 == 0) goto L_0x0045
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r0 = r15.getServiceOptions()
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            net.one97.paytm.common.entity.shopping.CJRServiceActions r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.common.entity.shopping.CJRServiceOptions) r0)
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r3 = net.one97.paytm.recharge.di.helper.c.bz()
            if (r3 == 0) goto L_0x0082
            if (r15 == 0) goto L_0x0083
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r0 = r15.getServiceOptions()
            if (r0 == 0) goto L_0x0083
            java.util.ArrayList r0 = r0.getActions()
            if (r0 == 0) goto L_0x0083
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0083
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r0 = r15.getServiceOptions()
            java.lang.String r1 = "cartProduct.serviceOptions"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.ArrayList r0 = r0.getActions()
            int r15 = r15.getDisplayArrayIndex()
            java.lang.Object r15 = r0.get(r15)
            r1 = r15
            net.one97.paytm.common.entity.shopping.CJRServiceActions r1 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r1
            goto L_0x0083
        L_0x0082:
            r1 = r0
        L_0x0083:
            if (r1 == 0) goto L_0x0138
            java.lang.String r15 = r1.getBillAmount()
            if (r15 == 0) goto L_0x00f5
            java.lang.String r15 = r1.getBillAmount()
            java.lang.String r0 = "customerInfoServiceAction.billAmount"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r0 = r15.length()
            int r0 = r0 - r2
            r3 = r0
            r0 = 0
            r9 = 0
        L_0x009e:
            if (r0 > r3) goto L_0x00bc
            if (r9 != 0) goto L_0x00a4
            r10 = r0
            goto L_0x00a5
        L_0x00a4:
            r10 = r3
        L_0x00a5:
            char r10 = r15.charAt(r10)
            if (r10 > r6) goto L_0x00ad
            r10 = 1
            goto L_0x00ae
        L_0x00ad:
            r10 = 0
        L_0x00ae:
            if (r9 != 0) goto L_0x00b7
            if (r10 != 0) goto L_0x00b4
            r9 = 1
            goto L_0x009e
        L_0x00b4:
            int r0 = r0 + 1
            goto L_0x009e
        L_0x00b7:
            if (r10 == 0) goto L_0x00bc
            int r3 = r3 + -1
            goto L_0x009e
        L_0x00bc:
            int r3 = r3 + r2
            java.lang.CharSequence r15 = r15.subSequence(r0, r3)
            java.lang.String r15 = r15.toString()
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r7, (boolean) r2)
            if (r15 != 0) goto L_0x00f5
            java.lang.String r15 = r1.getBillAmount()
            if (r15 == 0) goto L_0x00f1
            boolean r0 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r7, (boolean) r2)
            if (r0 != 0) goto L_0x00f1
            boolean r0 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r5, (boolean) r2)
            if (r0 != 0) goto L_0x00ed
            r0 = r15
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r4, (boolean) r8)
            if (r0 == 0) goto L_0x00e9
            goto L_0x00ed
        L_0x00e9:
            r12.a((net.one97.paytm.common.entity.CJRRechargeCart) r13, (net.one97.paytm.common.entity.shopping.CJRServiceActions) r1, (net.one97.paytm.recharge.common.e.i) r14, (java.lang.String) r15)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x0139
        L_0x00ed:
            r12.a((net.one97.paytm.common.entity.CJRRechargeCart) r13, (net.one97.paytm.common.entity.shopping.CJRServiceActions) r1, (net.one97.paytm.recharge.common.e.i) r14)
            goto L_0x0139
        L_0x00f1:
            r14.b(r1)
            goto L_0x0139
        L_0x00f5:
            java.lang.String r13 = r1.getMessage()
            if (r13 == 0) goto L_0x0138
            java.lang.String r13 = r1.getMessage()
            java.lang.String r15 = "customerInfoServiceAction.message"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r15)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            int r15 = r13.length()
            int r15 = r15 - r2
            r0 = r15
            r15 = 0
            r3 = 0
        L_0x010e:
            if (r15 > r0) goto L_0x012c
            if (r3 != 0) goto L_0x0114
            r4 = r15
            goto L_0x0115
        L_0x0114:
            r4 = r0
        L_0x0115:
            char r4 = r13.charAt(r4)
            if (r4 > r6) goto L_0x011d
            r4 = 1
            goto L_0x011e
        L_0x011d:
            r4 = 0
        L_0x011e:
            if (r3 != 0) goto L_0x0127
            if (r4 != 0) goto L_0x0124
            r3 = 1
            goto L_0x010e
        L_0x0124:
            int r15 = r15 + 1
            goto L_0x010e
        L_0x0127:
            if (r4 == 0) goto L_0x012c
            int r0 = r0 + -1
            goto L_0x010e
        L_0x012c:
            int r0 = r0 + r2
            java.lang.CharSequence r13 = r13.subSequence(r15, r0)
            java.lang.String r13 = r13.toString()
            kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r7, (boolean) r2)
        L_0x0138:
            r2 = 0
        L_0x0139:
            if (r2 != 0) goto L_0x027b
            r14.b(r1)
            return
        L_0x013f:
            boolean r3 = r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x014a
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15)
        L_0x014a:
            if (r0 == 0) goto L_0x0197
            java.lang.String r15 = r0.getError()
            if (r15 == 0) goto L_0x0197
            java.lang.String r15 = r0.getError()
            java.lang.String r3 = "cartObj.error"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r3 = r15.length()
            int r3 = r3 - r2
            r9 = r3
            r3 = 0
            r10 = 0
        L_0x0165:
            if (r3 > r9) goto L_0x0183
            if (r10 != 0) goto L_0x016b
            r11 = r3
            goto L_0x016c
        L_0x016b:
            r11 = r9
        L_0x016c:
            char r11 = r15.charAt(r11)
            if (r11 > r6) goto L_0x0174
            r11 = 1
            goto L_0x0175
        L_0x0174:
            r11 = 0
        L_0x0175:
            if (r10 != 0) goto L_0x017e
            if (r11 != 0) goto L_0x017b
            r10 = 1
            goto L_0x0165
        L_0x017b:
            int r3 = r3 + 1
            goto L_0x0165
        L_0x017e:
            if (r11 == 0) goto L_0x0183
            int r9 = r9 + -1
            goto L_0x0165
        L_0x0183:
            int r9 = r9 + r2
            java.lang.CharSequence r15 = r15.subSequence(r3, r9)
            java.lang.String r15 = r15.toString()
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r7, (boolean) r2)
            if (r15 != 0) goto L_0x0197
            java.lang.String r15 = r0.getError()
            goto L_0x0198
        L_0x0197:
            r15 = r1
        L_0x0198:
            if (r15 == 0) goto L_0x0278
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x021d }
            java.lang.String r0 = "Rs"
            kotlin.m.l r3 = new kotlin.m.l     // Catch:{ Exception -> 0x021d }
            r3.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x021d }
            java.util.List r15 = r3.split(r15, r8)     // Catch:{ Exception -> 0x021d }
            boolean r0 = r15.isEmpty()     // Catch:{ Exception -> 0x021d }
            if (r0 != 0) goto L_0x01da
            int r0 = r15.size()     // Catch:{ Exception -> 0x021d }
            java.util.ListIterator r0 = r15.listIterator(r0)     // Catch:{ Exception -> 0x021d }
        L_0x01b5:
            boolean r3 = r0.hasPrevious()     // Catch:{ Exception -> 0x021d }
            if (r3 == 0) goto L_0x01da
            java.lang.Object r3 = r0.previous()     // Catch:{ Exception -> 0x021d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x021d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x021d }
            int r3 = r3.length()     // Catch:{ Exception -> 0x021d }
            if (r3 != 0) goto L_0x01cb
            r3 = 1
            goto L_0x01cc
        L_0x01cb:
            r3 = 0
        L_0x01cc:
            if (r3 != 0) goto L_0x01b5
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ Exception -> 0x021d }
            int r0 = r0.nextIndex()     // Catch:{ Exception -> 0x021d }
            int r0 = r0 + r2
            java.util.List r15 = kotlin.a.k.b(r15, (int) r0)     // Catch:{ Exception -> 0x021d }
            goto L_0x01de
        L_0x01da:
            kotlin.a.w r15 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x021d }
            java.util.List r15 = (java.util.List) r15     // Catch:{ Exception -> 0x021d }
        L_0x01de:
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ Exception -> 0x021d }
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ Exception -> 0x021d }
            java.lang.Object[] r15 = r15.toArray(r0)     // Catch:{ Exception -> 0x021d }
            if (r15 == 0) goto L_0x0215
            java.lang.String[] r15 = (java.lang.String[]) r15     // Catch:{ Exception -> 0x021d }
            r15 = r15[r2]     // Catch:{ Exception -> 0x021d }
            int r0 = r15.length()     // Catch:{ Exception -> 0x021d }
            r9 = r7
            r3 = 0
        L_0x01f2:
            if (r3 >= r0) goto L_0x0221
            char r10 = r15.charAt(r3)     // Catch:{ Exception -> 0x021e }
            boolean r11 = java.lang.Character.isLetter(r10)     // Catch:{ Exception -> 0x021e }
            if (r11 != 0) goto L_0x0221
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021e }
            r11.<init>()     // Catch:{ Exception -> 0x021e }
            if (r9 != 0) goto L_0x0208
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x021e }
        L_0x0208:
            r11.append(r9)     // Catch:{ Exception -> 0x021e }
            r11.append(r10)     // Catch:{ Exception -> 0x021e }
            java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x021e }
            int r3 = r3 + 1
            goto L_0x01f2
        L_0x0215:
            kotlin.u r15 = new kotlin.u     // Catch:{ Exception -> 0x021d }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r15.<init>(r0)     // Catch:{ Exception -> 0x021d }
            throw r15     // Catch:{ Exception -> 0x021d }
        L_0x021d:
            r9 = r7
        L_0x021e:
            r14.b(r1)
        L_0x0221:
            if (r9 != 0) goto L_0x0226
            kotlin.g.b.k.a()
        L_0x0226:
            r15 = r9
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r0 = r15.length()
            int r0 = r0 - r2
            r3 = r0
            r0 = 0
            r10 = 0
        L_0x0231:
            if (r0 > r3) goto L_0x024f
            if (r10 != 0) goto L_0x0237
            r11 = r0
            goto L_0x0238
        L_0x0237:
            r11 = r3
        L_0x0238:
            char r11 = r15.charAt(r11)
            if (r11 > r6) goto L_0x0240
            r11 = 1
            goto L_0x0241
        L_0x0240:
            r11 = 0
        L_0x0241:
            if (r10 != 0) goto L_0x024a
            if (r11 != 0) goto L_0x0247
            r10 = 1
            goto L_0x0231
        L_0x0247:
            int r0 = r0 + 1
            goto L_0x0231
        L_0x024a:
            if (r11 == 0) goto L_0x024f
            int r3 = r3 + -1
            goto L_0x0231
        L_0x024f:
            int r3 = r3 + r2
            r15.subSequence(r0, r3)
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r7, (boolean) r2)
            if (r0 != 0) goto L_0x0274
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r5, (boolean) r2)
            if (r0 != 0) goto L_0x0270
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r15 = kotlin.m.p.a((java.lang.CharSequence) r15, (java.lang.CharSequence) r4, false)
            if (r15 == 0) goto L_0x0268
            goto L_0x0270
        L_0x0268:
            r12.a((net.one97.paytm.common.entity.CJRRechargeCart) r13, (net.one97.paytm.common.entity.shopping.CJRServiceActions) r1, (net.one97.paytm.recharge.common.e.i) r14, (java.lang.String) r9)     // Catch:{ Exception -> 0x026c }
            return
        L_0x026c:
            r14.b(r1)
            return
        L_0x0270:
            r12.a((net.one97.paytm.common.entity.CJRRechargeCart) r13, (net.one97.paytm.common.entity.shopping.CJRServiceActions) r1, (net.one97.paytm.recharge.common.e.i) r14)
            return
        L_0x0274:
            r14.b(r1)
            return
        L_0x0278:
            r14.b(r1)
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(net.one97.paytm.common.entity.CJRRechargeCart, net.one97.paytm.recharge.common.e.i, java.lang.Object):void");
    }

    private final void a(CJRRechargeCart cJRRechargeCart, CJRServiceActions cJRServiceActions, net.one97.paytm.recharge.common.e.i iVar) {
        a(cJRRechargeCart);
        iVar.a(cJRServiceActions);
    }

    private final void a(CJRRechargeCart cJRRechargeCart, CJRServiceActions cJRServiceActions, net.one97.paytm.recharge.common.e.i iVar, String str) {
        a(cJRRechargeCart);
        iVar.a(cJRServiceActions, str);
    }

    private final void a(CJRRechargeCart cJRRechargeCart) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String value = this.z.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "enteredMobileNumber.value!!");
        map.put(value, cJRRechargeCart);
        this.al.put(Long.valueOf(this.ak), hashMap);
    }

    public final boolean b(String str) {
        k.c(str, "mobileNumber");
        ac acVar = this.D.get(str);
        if (acVar != null) {
            return p.a("false", (String) acVar.get((Object) BaseViewModel.PaymentType.POSTPAID), true);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r3.equals("fetch_mobile_bill_in_bg") != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r3.equals("fetch_mobile_bill") != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if ((r5 instanceof java.util.HashMap) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r5 = (java.util.Map) r5;
        r3 = r5.get("statusListener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if ((r3 instanceof net.one97.paytm.recharge.common.e.i) != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        r3 = (net.one97.paytm.recharge.common.e.i) r3;
        r5 = r5.get("hawkEyeModel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if ((r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        if ((r4 instanceof net.one97.paytm.common.entity.CJRRechargeCart) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        a((net.one97.paytm.common.entity.CJRRechargeCart) r4, r3, (java.lang.Object) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (r3.equals("getCategory") != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r3.equals("offline.retry.get.category") != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r3.equals("get.rc.category") != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0144, code lost:
        super.a_(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        super.a_(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r3, com.paytm.network.model.IJRPaytmDataModel r4, java.lang.Object r5) {
        /*
            r2 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r3, r0)
            int r0 = r3.hashCode()
            switch(r0) {
                case -2042516569: goto L_0x012c;
                case -1721320982: goto L_0x0117;
                case -1673135277: goto L_0x00a2;
                case -1589246868: goto L_0x007f;
                case -1539539073: goto L_0x0047;
                case -1527767841: goto L_0x003e;
                case 267720212: goto L_0x002c;
                case 648019331: goto L_0x0020;
                case 2122454023: goto L_0x0017;
                case 2128411252: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0144
        L_0x000e:
            java.lang.String r0 = "getCategory"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            goto L_0x0028
        L_0x0017:
            java.lang.String r0 = "offline.retry.get.category"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            goto L_0x0028
        L_0x0020:
            java.lang.String r0 = "get.rc.category"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
        L_0x0028:
            super.a_(r3, r4, r5)
            return
        L_0x002c:
            java.lang.String r0 = "fetch_insurance_data"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.CJRPersonalInsurance
            if (r3 == 0) goto L_0x0147
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPersonalInsurance> r3 = r2.T
            r3.setValue(r4)
            return
        L_0x003e:
            java.lang.String r0 = "fetch_mobile_bill_in_bg"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            goto L_0x004f
        L_0x0047:
            java.lang.String r0 = "fetch_mobile_bill"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
        L_0x004f:
            boolean r3 = r5 instanceof java.util.HashMap
            r0 = 0
            if (r3 == 0) goto L_0x0072
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r3 = "statusListener"
            java.lang.Object r3 = r5.get(r3)
            boolean r1 = r3 instanceof net.one97.paytm.recharge.common.e.i
            if (r1 != 0) goto L_0x0061
            r3 = r0
        L_0x0061:
            net.one97.paytm.recharge.common.e.i r3 = (net.one97.paytm.recharge.common.e.i) r3
            java.lang.String r1 = "hawkEyeModel"
            java.lang.Object r5 = r5.get(r1)
            boolean r1 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 != 0) goto L_0x006e
            r5 = r0
        L_0x006e:
            r0 = r5
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            goto L_0x0073
        L_0x0072:
            r3 = r0
        L_0x0073:
            boolean r5 = r4 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r5 == 0) goto L_0x0147
            if (r3 == 0) goto L_0x0147
            net.one97.paytm.common.entity.CJRRechargeCart r4 = (net.one97.paytm.common.entity.CJRRechargeCart) r4
            r2.a((net.one97.paytm.common.entity.CJRRechargeCart) r4, (net.one97.paytm.recharge.common.e.i) r3, (java.lang.Object) r0)
            return
        L_0x007f:
            java.lang.String r0 = "get.rc.category.in.background"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            io.reactivex.rxjava3.b.c r3 = r2.am
            if (r3 == 0) goto L_0x008e
            r3.dispose()
        L_0x008e:
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.v4.CJRCategoryData
            if (r3 == 0) goto L_0x0147
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r2.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r4
            java.lang.Long r5 = r4.getCategoryId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3.addRelatedCategoryData(r5, r4)
            return
        L_0x00a2:
            java.lang.String r0 = "fetch_product_list"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.v4.CJRProductList
            if (r3 == 0) goto L_0x0147
            net.one97.paytm.recharge.model.v4.CJRProductList r4 = (net.one97.paytm.recharge.model.v4.CJRProductList) r4
            java.util.List r3 = r4.getProducts()
            r0 = 0
            if (r3 == 0) goto L_0x00ca
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00ca
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r2.G
            java.util.List r1 = r4.getProducts()
            java.lang.Object r1 = r1.get(r0)
            r3.setValue(r1)
        L_0x00ca:
            boolean r3 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 == 0) goto L_0x0147
            java.util.List r3 = r4.getProducts()
            if (r3 == 0) goto L_0x00fb
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r1 = 1
            r3 = r3 ^ r1
            if (r3 != r1) goto L_0x00fb
            r3 = r5
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            java.util.List r4 = r4.getProducts()
            java.lang.Object r4 = r4.get(r0)
            if (r4 != 0) goto L_0x00ee
            kotlin.g.b.k.a()
        L_0x00ee:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            java.lang.Long r4 = r4.getProductId()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.setProductId(r4)
        L_0x00fb:
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r5 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r5
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r5.setErrorType(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r5.getFlowName()
            if (r3 == 0) goto L_0x0111
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x0111:
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r5)
            return
        L_0x0117:
            java.lang.String r0 = "tag.get.one2one.plans"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse
            if (r3 == 0) goto L_0x0147
            net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse r4 = (net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse) r4
            java.lang.String r3 = r4.getCustomerType()
            r2.ah = r3
            return
        L_0x012c:
            java.lang.String r0 = "search_browse_plan"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0144
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8
            if (r3 == 0) goto L_0x0147
            androidx.lifecycle.y<java.util.List<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList>> r3 = r2.aj
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r4 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r4
            java.util.List r4 = r4.getProductList()
            r3.setValue(r4)
            return
        L_0x0144:
            super.a_(r3, r4, r5)
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r9.equals("get.rc.category") != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        super.a(r9, r10, r11, (com.paytm.network.model.NetworkCustomError) new net.one97.paytm.recharge.common.utils.an(r12), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        if (r9.equals("fetch_mobile_bill_in_bg") != false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r9.equals("fetch_mobile_bill") != false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        if ((r13 instanceof java.util.HashMap) == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r13 = (java.util.Map) r13;
        r13.get("statusListener");
        r13 = r13.get("hawkEyeModel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
        if ((r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (r9.equals("getCategory") != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        super.a(r9, r10, r11, r12, (java.lang.Object) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r9.equals("offline.retry.get.category") != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ff, code lost:
        super.a(r9, r10, r11, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, int r10, com.paytm.network.model.IJRPaytmDataModel r11, com.paytm.network.model.NetworkCustomError r12, java.lang.Object r13) {
        /*
            r8 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r9, r0)
            int r0 = r9.hashCode()
            r1 = 0
            switch(r0) {
                case -2042516569: goto L_0x00eb;
                case -2038674700: goto L_0x00d5;
                case -1673135277: goto L_0x00c9;
                case -1589246868: goto L_0x00b9;
                case -1539539073: goto L_0x008d;
                case -1527767841: goto L_0x0084;
                case 37091808: goto L_0x006c;
                case 267720212: goto L_0x0054;
                case 648019331: goto L_0x003b;
                case 1288791337: goto L_0x0021;
                case 2122454023: goto L_0x0018;
                case 2128411252: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x00ff
        L_0x000f:
            java.lang.String r0 = "getCategory"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            goto L_0x0043
        L_0x0018:
            java.lang.String r0 = "offline.retry.get.category"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            goto L_0x0043
        L_0x0021:
            java.lang.String r0 = "frequent_api"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            r8.Q = r1
            boolean r0 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0037
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r13
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0037:
            super.a((java.lang.String) r9, (int) r10, (com.paytm.network.model.IJRPaytmDataModel) r11, (com.paytm.network.model.NetworkCustomError) r12, (java.lang.Object) r13)
            return
        L_0x003b:
            java.lang.String r0 = "get.rc.category"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
        L_0x0043:
            net.one97.paytm.recharge.common.utils.an r0 = new net.one97.paytm.recharge.common.utils.an
            r0.<init>(r12)
            r5 = r0
            com.paytm.network.model.NetworkCustomError r5 = (com.paytm.network.model.NetworkCustomError) r5
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            super.a((java.lang.String) r2, (int) r3, (com.paytm.network.model.IJRPaytmDataModel) r4, (com.paytm.network.model.NetworkCustomError) r5, (java.lang.Object) r6)
            return
        L_0x0054:
            java.lang.String r0 = "fetch_insurance_data"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            boolean r9 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r9 == 0) goto L_0x0102
            boolean r9 = r12 instanceof net.one97.paytm.recharge.common.utils.as
            if (r9 != 0) goto L_0x0102
            net.one97.paytm.recharge.common.utils.az r9 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13)
            return
        L_0x006c:
            java.lang.String r0 = "requestMNP"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            boolean r0 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0080
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r13
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0080:
            super.a((java.lang.String) r9, (int) r10, (com.paytm.network.model.IJRPaytmDataModel) r11, (com.paytm.network.model.NetworkCustomError) r12, (java.lang.Object) r13)
            return
        L_0x0084:
            java.lang.String r0 = "fetch_mobile_bill_in_bg"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            goto L_0x0095
        L_0x008d:
            java.lang.String r0 = "fetch_mobile_bill"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
        L_0x0095:
            boolean r0 = r13 instanceof java.util.HashMap
            r1 = 0
            if (r0 == 0) goto L_0x00af
            java.util.Map r13 = (java.util.Map) r13
            java.lang.String r0 = "statusListener"
            r13.get(r0)
            java.lang.String r0 = "hawkEyeModel"
            java.lang.Object r13 = r13.get(r0)
            boolean r0 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 != 0) goto L_0x00ac
            r13 = r1
        L_0x00ac:
            r1 = r13
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
        L_0x00af:
            r7 = r1
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            super.a((java.lang.String) r3, (int) r4, (com.paytm.network.model.IJRPaytmDataModel) r5, (com.paytm.network.model.NetworkCustomError) r6, (java.lang.Object) r7)
            return
        L_0x00b9:
            java.lang.String r0 = "get.rc.category.in.background"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            io.reactivex.rxjava3.b.c r9 = r8.am
            if (r9 == 0) goto L_0x00c8
            r9.dispose()
        L_0x00c8:
            return
        L_0x00c9:
            java.lang.String r0 = "fetch_product_list"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            super.a((java.lang.String) r9, (int) r10, (com.paytm.network.model.IJRPaytmDataModel) r11, (com.paytm.network.model.NetworkCustomError) r12, (java.lang.Object) r13)
            return
        L_0x00d5:
            java.lang.String r0 = "check_subscription"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            r8.R = r1
            boolean r9 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r9 == 0) goto L_0x0102
            net.one97.paytm.recharge.common.utils.az r9 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13)
            return
        L_0x00eb:
            java.lang.String r0 = "search_browse_plan"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00ff
            boolean r9 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r9 == 0) goto L_0x0102
            net.one97.paytm.recharge.common.utils.az r9 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13)
            return
        L_0x00ff:
            super.a((java.lang.String) r9, (int) r10, (com.paytm.network.model.IJRPaytmDataModel) r11, (com.paytm.network.model.NetworkCustomError) r12, (java.lang.Object) r13)
        L_0x0102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(java.lang.String, int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        io.reactivex.rxjava3.b.c cVar;
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        switch (str.hashCode()) {
            case -1589246868:
                if (str.equals("get.rc.category.in.background") && (cVar = this.am) != null) {
                    cVar.dispose();
                    return;
                }
                return;
            case 648019331:
                if (!str.equals("get.rc.category")) {
                    return;
                }
                break;
            case 2122454023:
                if (!str.equals("offline.retry.get.category")) {
                    return;
                }
                break;
            case 2128411252:
                if (!str.equals("getCategory")) {
                    return;
                }
                break;
            default:
                return;
        }
        if (iJRPaytmDataModel instanceof CJRCategoryData) {
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            if (!k.a((Object) categoryData != null ? categoryData.getCategoryId() : null, (Object) ((CJRCategoryData) iJRPaytmDataModel).getCategoryId())) {
                a(str, false, iJRPaytmDataModel, obj);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4, boolean r5, com.paytm.network.model.IJRPaytmDataModel r6, java.lang.Object r7) {
        /*
            r3 = this;
            java.lang.String r5 = "tag"
            kotlin.g.b.k.c(r4, r5)
            java.lang.String r5 = "response"
            kotlin.g.b.k.c(r6, r5)
            int r5 = r4.hashCode()
            switch(r5) {
                case -1589246868: goto L_0x00d9;
                case 648019331: goto L_0x0025;
                case 2122454023: goto L_0x001c;
                case 2128411252: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00fb
        L_0x0013:
            java.lang.String r5 = "getCategory"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00fb
            goto L_0x002d
        L_0x001c:
            java.lang.String r5 = "offline.retry.get.category"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00fb
            goto L_0x002d
        L_0x0025:
            java.lang.String r5 = "get.rc.category"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00fb
        L_0x002d:
            boolean r4 = r6 instanceof net.one97.paytm.recharge.model.v4.CJRCategoryData
            if (r4 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            r5 = 0
            if (r4 == 0) goto L_0x003f
            java.lang.Long r4 = r4.getCategoryId()
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r6 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r6
            java.lang.Long r7 = r6.getCategoryId()
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
            r7 = 1
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            java.lang.String r0 = r3.ab
            if (r0 != 0) goto L_0x0057
            kotlin.g.b.k.a()
        L_0x0057:
            r4.setCategoryData(r0, r6)
            boolean r4 = r3.ad
            if (r4 != 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            java.util.List r4 = r4.getRelatedCategories()
            r6 = 0
            if (r4 == 0) goto L_0x00b3
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0074:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r0 = r4.next()
            r1 = r0
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r1 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r1
            java.lang.String r2 = r1.getUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00aa
            net.one97.paytm.common.entity.CJRItem r2 = r3.r
            java.lang.String r2 = r2.getCategoryId()
            if (r2 == 0) goto L_0x00aa
            java.lang.String r1 = r1.getUrl()
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.g.d(r1)
            boolean r1 = r2.equals(r1)
            if (r1 != r7) goto L_0x00aa
            r1 = 1
            goto L_0x00ab
        L_0x00aa:
            r1 = 0
        L_0x00ab:
            if (r1 == 0) goto L_0x0074
            r5.add(r0)
            goto L_0x0074
        L_0x00b1:
            java.util.List r5 = (java.util.List) r5
        L_0x00b3:
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x00d8
            boolean r4 = r5.isEmpty()
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x00d8
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r4 = r5.get(r6)
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r4 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r4
            java.lang.String r4 = r4.getValue()
            java.lang.String r5 = "postpaid"
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r4, (boolean) r7)
            r3.ad = r4
            boolean r4 = r3.ad
            if (r4 == 0) goto L_0x00d8
            r3.ac = r7
        L_0x00d8:
            return
        L_0x00d9:
            java.lang.String r5 = "get.rc.category.in.background"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00fb
            io.reactivex.rxjava3.b.c r4 = r3.am
            if (r4 == 0) goto L_0x00e8
            r4.dispose()
        L_0x00e8:
            boolean r4 = r6 instanceof net.one97.paytm.recharge.model.v4.CJRCategoryData
            if (r4 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r6 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r6
            java.lang.Long r5 = r6.getCategoryId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4.addRelatedCategoryData(r5, r6)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(java.lang.String, boolean, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, Context context, String str2, Object obj) {
        k.c(str, "tag");
        k.c(context, "context");
        k.c(str2, "categoryId");
        if (Build.VERSION.SDK_INT >= 23) {
            io.reactivex.rxjava3.b.c cVar = this.am;
            if (cVar != null) {
                if (cVar == null) {
                    k.a();
                }
                cVar.dispose();
            }
            this.am = io.reactivex.rxjava3.a.y.a(new c(this, obj, str2, context, str)).b(io.reactivex.rxjava3.i.a.d()).d();
        }
    }

    static final class c<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63704a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f63705b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f63706c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f63707d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f63708e;

        c(a aVar, Object obj, String str, Context context, String str2) {
            this.f63704a = aVar;
            this.f63705b = obj;
            this.f63706c = str;
            this.f63707d = context;
            this.f63708e = str2;
        }

        public final void subscribe(z<Object> zVar) {
            k.a((Object) zVar, "it");
            if (!zVar.isDisposed()) {
                try {
                    if (this.f63705b instanceof CJRRechargeErrorModel) {
                        ((CJRRechargeErrorModel) this.f63705b).setCategoryId(this.f63706c);
                    }
                    net.one97.paytm.recharge.common.b.a.a.a aVar = net.one97.paytm.recharge.common.b.a.a.a.f60878a;
                    Context applicationContext = this.f63707d.getApplicationContext();
                    k.a((Object) applicationContext, "context.applicationContext");
                    if (TextUtils.isEmpty(net.one97.paytm.recharge.common.b.a.a.a.a(applicationContext, this.f63706c))) {
                        IJRPaytmDataModel iJRPaytmDataModel = null;
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        String B = net.one97.paytm.recharge.di.helper.c.B();
                        if (URLUtil.isValidUrl(B)) {
                            iJRPaytmDataModel = net.one97.paytm.recharge.common.f.d.a(B + "/category/" + this.f63706c + "/getcategory", this.f63707d, new CJRCategoryData((List) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRProtectionUrl) null, (Object) null, (Integer) null, (CJRUtilityButtonObjectV4) null, (Integer) null, (Integer) null, (String) null, (TopLevelCategoryHeader) null, (String) null, (String) null, (String) null, (Long) null, (List) null, (Integer) null, (String) null, (Object) null, (String) null, (CJRMetaInfo) null, (Integer) null, (CJRGroupings) null, (String) null, (List) null, (String) null, (String) null, (CJRExtensionAttributes) null, (CJRCategoryData) null, (Map) null, 0, 0, (List) null, 0, 0, -1, 4095, (g) null));
                        }
                        if (iJRPaytmDataModel == null) {
                            this.f63704a.s.a(this.f63708e, (ai) this.f63704a, this.f63706c, (String) null, (net.one97.paytm.recharge.common.b.a.a) this.f63704a, this.f63705b);
                            return;
                        }
                        io.reactivex.rxjava3.b.c f2 = this.f63704a.am;
                        if (f2 != null) {
                            f2.dispose();
                        }
                        if (iJRPaytmDataModel instanceof CJRCategoryData) {
                            this.f63704a.f61409b.addRelatedCategoryData(this.f63706c, (CJRCategoryData) iJRPaytmDataModel);
                            return;
                        }
                        return;
                    }
                    io.reactivex.rxjava3.b.c f3 = this.f63704a.am;
                    if (f3 != null) {
                        f3.dispose();
                    }
                } catch (Exception unused) {
                    io.reactivex.rxjava3.b.c f4 = this.f63704a.am;
                    if (f4 != null) {
                        f4.dispose();
                    }
                }
            }
        }
    }

    public final String a() {
        CJRProductsItem value = this.G.getValue();
        if (value != null) {
            return value.getDynamicPlanCategoryLabel();
        }
        return null;
    }

    public final String c() {
        CJRProductsItem value = this.G.getValue();
        if (value != null) {
            return value.getOne2OneDisclaimerText();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.String, java.lang.String> q() {
        /*
            r14 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r1 = r14.F
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            r2 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.Object r1 = r1.getValue()
            java.util.LinkedList r1 = (java.util.LinkedList) r1
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            if (r1 == 0) goto L_0x01ca
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x01ca
            java.lang.Object r3 = r1.getLast()
            java.lang.String r4 = "selectedGroups.last"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r3 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r3
            java.util.List r3 = r14.a((net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r3)
            androidx.lifecycle.y<java.lang.String> r4 = r14.z
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            if (r4 == 0) goto L_0x0038
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0039
        L_0x0038:
            r4 = r2
        L_0x0039:
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r14.f61409b
            if (r5 == 0) goto L_0x0067
            java.util.List r5 = r5.getRelatedCategories()
            if (r5 == 0) goto L_0x0067
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0049:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005d
            java.lang.Object r6 = r5.next()
            r7 = r6
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r7 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r7
            boolean r7 = r7.isSelected()
            if (r7 == 0) goto L_0x0049
            goto L_0x005e
        L_0x005d:
            r6 = r2
        L_0x005e:
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r6 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r6
            if (r6 == 0) goto L_0x0067
            java.lang.String r5 = r6.getLabel()
            goto L_0x0068
        L_0x0067:
            r5 = r2
        L_0x0068:
            r6 = 1
            java.lang.String r7 = ""
            r8 = 0
            if (r3 == 0) goto L_0x0098
            r9 = r3
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r6
            if (r9 != r6) goto L_0x0098
            java.lang.Object r9 = r3.get(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r9 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r9
            java.lang.Long r9 = r9.getProductId()
            if (r9 == 0) goto L_0x008d
            long r9 = r9.longValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x008e
        L_0x008d:
            r9 = r2
        L_0x008e:
            java.lang.Object r10 = r3.get(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r10 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r10
            r14.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r10)
            goto L_0x009c
        L_0x0098:
            r14.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r2)
            r9 = r7
        L_0x009c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            boolean r11 = net.one97.paytm.recharge.common.utils.g.c(r5)
            if (r11 == 0) goto L_0x00af
            r10.append(r5)
            java.lang.String r5 = ","
            r10.append(r5)
        L_0x00af:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r5 = r2
        L_0x00b6:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0100
            java.lang.Object r11 = r1.next()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r11 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = " "
            r12.<init>(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r13 = r11.getItem()
            if (r13 == 0) goto L_0x00d5
            java.lang.String r13 = r13.getDisplayValue()
            if (r13 != 0) goto L_0x00d6
        L_0x00d5:
            r13 = r7
        L_0x00d6:
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r10.append(r12)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r11.getItem()
            if (r12 == 0) goto L_0x00eb
            java.lang.String r12 = r12.getImageUrl()
            goto L_0x00ec
        L_0x00eb:
            r12 = r2
        L_0x00ec:
            boolean r12 = net.one97.paytm.recharge.common.utils.g.c(r12)
            if (r12 == 0) goto L_0x00b6
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r11.getItem()
            if (r5 != 0) goto L_0x00fb
            kotlin.g.b.k.a()
        L_0x00fb:
            java.lang.String r5 = r5.getImageUrl()
            goto L_0x00b6
        L_0x0100:
            net.one97.paytm.recharge.model.ContactItemModel r1 = r14.C
            if (r1 == 0) goto L_0x011a
            java.lang.String r11 = r1.getName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0139
            java.lang.String r7 = r1.getName()
            java.lang.String r1 = "it.name"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            goto L_0x0139
        L_0x011a:
            r1 = r14
            net.one97.paytm.recharge.mobile.d.a r1 = (net.one97.paytm.recharge.mobile.d.a) r1
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r1.j()
            if (r1 == 0) goto L_0x0139
            java.lang.String r11 = r1.getContactName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0139
            java.lang.String r1 = r1.getContactName()
            java.lang.String r7 = "it.contactName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            r7 = r1
        L_0x0139:
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r11 = "recharge_number"
            r1.put(r11, r4)
            java.lang.String r4 = r10.toString()
            java.lang.String r10 = "operator_name"
            r1.put(r10, r4)
            java.lang.String r4 = "operator_logo"
            r1.put(r4, r5)
            java.lang.String r4 = "nick_name"
            r1.put(r4, r7)
            java.lang.String r4 = "product_id"
            r1.put(r4, r9)
            if (r3 == 0) goto L_0x01ca
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r6
            if (r4 == 0) goto L_0x01ca
            java.lang.Object r4 = r3.get(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            java.lang.String r4 = r4.getBankEMandateEnable()
            java.lang.String r5 = "is_bank_mandate_enabled"
            r1.put(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Object r5 = r3.get(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            java.lang.String r5 = r5.getService()
            java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
            if (r5 == 0) goto L_0x0199
            if (r5 == 0) goto L_0x0193
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            goto L_0x019a
        L_0x0193:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r6)
            throw r0
        L_0x0199:
            r5 = r2
        L_0x019a:
            r4.append(r5)
            java.lang.String r5 = "_"
            r4.append(r5)
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            java.lang.String r3 = r3.getPaytype()
            if (r3 == 0) goto L_0x01be
            if (r3 == 0) goto L_0x01b8
            java.lang.String r2 = r3.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            goto L_0x01be
        L_0x01b8:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r6)
            throw r0
        L_0x01be:
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "service_paytype"
            r1.put(r3, r2)
        L_0x01ca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.q():java.util.HashMap");
    }

    public final String d() {
        CJRProductsItem value = this.G.getValue();
        if (value != null) {
            return value.getDisclaimer();
        }
        return null;
    }

    public final Object e() {
        String gAEventCategory;
        if (this.f61411d) {
            StringBuilder sb = new StringBuilder();
            a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            sb.append(net.one97.paytm.recharge.automatic.b.a.a.f60240b);
            sb.append("_");
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            sb.append(categoryData != null ? categoryData.getGAEventCategory() : null);
            return sb.toString();
        }
        CJRCategoryData categoryData2 = this.f61409b.getCategoryData();
        return (categoryData2 == null || (gAEventCategory = categoryData2.getGAEventCategory()) == null) ? "" : gAEventCategory;
    }

    public final void i() {
        if (TextUtils.isEmpty(this.r.getURL()) && (this.r instanceof CJRHomePageItem)) {
            CJRItem cJRItem = this.r;
            String deeplink = ((CJRHomePageItem) this.r).getDeeplink();
            if (deeplink == null) {
                deeplink = "";
            }
            cJRItem.setUrl(deeplink);
        }
        super.i();
    }

    public final void b(String str, Object obj) {
        k.c(str, "tag");
        net.one97.paytm.recharge.common.b.c cVar = this.s;
        ai aiVar = this;
        JSONObject filterJSON = this.f61409b.getFilterJSON();
        String categoryId = this.f61409b.getCategoryId();
        if (categoryId == null) {
            categoryId = "";
        }
        cVar.a(str, aiVar, filterJSON, categoryId, (String) null, obj);
    }

    public final void a(String str, ai aiVar, int i2, String str2, Object obj) {
        String str3;
        CJRExtensionAttributes extnAttrs;
        ai aiVar2 = aiVar;
        k.c(str, "tag");
        k.c(aiVar2, "onSuccess");
        k.c(str2, "filterNo");
        CJRCategoryData categoryData = this.f61409b.getCategoryData();
        if (categoryData == null || (extnAttrs = categoryData.getExtnAttrs()) == null || (str3 = extnAttrs.getBrowsePlansCategory()) == null) {
            str3 = "";
        }
        String str4 = str3;
        net.one97.paytm.recharge.mobile.b bVar = this.aa;
        ai bVar2 = new b(aiVar2);
        String uRLQueryParams = this.f61409b.getURLQueryParams();
        CJRProductsItem value = this.G.getValue();
        bVar.a(str, bVar2, str4, uRLQueryParams, value != null ? value.getDynamicPlansGrouping() : null, s(), str2, i2, 20, true, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
        r3 = r3.getProductId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.Object r30, net.one97.paytm.recharge.model.CJRPersonalInsurance r31, java.lang.String r32, net.one97.paytm.recharge.common.utils.o r33) {
        /*
            r22 = this;
            r6 = r22
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.String r3 = "context"
            kotlin.g.b.k.c(r0, r3)
            java.lang.String r3 = "tag"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r3 = "enteredAmount"
            kotlin.g.b.k.c(r2, r3)
            net.one97.paytm.recharge.common.b.c r3 = r6.s
            boolean r3 = r3.a()
            r5 = 1
            if (r3 == 0) goto L_0x01fb
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r6.G
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            r7 = -1
            if (r3 == 0) goto L_0x0037
            java.lang.Long r3 = r3.getProductId()
            if (r3 == 0) goto L_0x0037
            long r3 = r3.longValue()
            goto L_0x0038
        L_0x0037:
            r3 = r7
        L_0x0038:
            androidx.lifecycle.y<java.lang.String> r9 = r6.z
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            boolean r10 = r22.o()
            r12 = 0
            int r13 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x01fa
            r7 = r9
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01fa
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01fa
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r13 = r7
            java.util.Map r13 = (java.util.Map) r13
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r13.put(r3, r2)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r3 = (java.util.Map) r3
            if (r9 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            java.lang.String r4 = "recharge_number"
            r3.put(r4, r9)
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r7 = "CJRRechargeUtilityConstant.KEY_CATEGORY_ID"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r7 = r6.f61409b
            java.lang.String r7 = r7.getCategoryId()
            java.lang.String r8 = ""
            if (r7 != 0) goto L_0x0092
            r7 = r8
        L_0x0092:
            r3.put(r4, r7)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r4 = r6.J
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r4 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r4
            if (r4 == 0) goto L_0x00fd
            java.lang.String r7 = r4.getValidity()
            if (r7 != 0) goto L_0x00a6
            r7 = r8
        L_0x00a6:
            java.lang.String r14 = "validity"
            r11.put(r14, r7)
            java.lang.String r7 = r4.getTalktime()
            if (r7 != 0) goto L_0x00b2
            r7 = r8
        L_0x00b2:
            java.lang.String r14 = "talktime"
            r11.put(r14, r7)
            java.lang.String r7 = r4.getDescription()
            if (r7 != 0) goto L_0x00be
            r7 = r8
        L_0x00be:
            java.lang.String r14 = "couponDescription"
            r11.put(r14, r7)
            java.lang.String r7 = r4.getData()
            if (r7 != 0) goto L_0x00ca
            r7 = r8
        L_0x00ca:
            java.lang.String r14 = "data"
            r11.put(r14, r7)
            java.lang.String r7 = r4.getSms()
            if (r7 != 0) goto L_0x00d6
            r7 = r8
        L_0x00d6:
            java.lang.String r14 = "sms"
            r11.put(r14, r7)
            java.lang.String r7 = r4.getSms()
            if (r7 != 0) goto L_0x00e2
            r7 = r8
        L_0x00e2:
            r11.put(r14, r7)
            java.lang.String r7 = "this"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            long r14 = r4.getProductId()
            r16 = 0
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x00fd
            long r14 = r4.getProductId()
            java.lang.String r4 = "plan_id"
            r11.put(r4, r14)
        L_0x00fd:
            if (r10 == 0) goto L_0x0117
            java.lang.String r4 = "phone"
            r11.put(r4, r9)
            java.lang.String r4 = "amount"
            r11.put(r4, r2)
            java.lang.String r4 = "subregion_id"
            r7 = r29
            r11.put(r4, r7)
            java.lang.String r4 = "ref_id"
            r7 = r28
            r11.put(r4, r7)
        L_0x0117:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r6.G
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x0135
            java.lang.String r7 = r4.getPostOrderViewType()
            java.lang.String r9 = "post_order_view_type"
            r11.put(r9, r7)
            if (r10 == 0) goto L_0x0135
            java.lang.String r4 = r4.getOperator()
            java.lang.String r7 = "operator_id"
            r11.put(r7, r4)
        L_0x0135:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r7 = r6.G
            java.lang.Object r7 = r7.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r7 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r7
            if (r7 == 0) goto L_0x0147
            r4.add(r7)
        L_0x0147:
            if (r27 == 0) goto L_0x014e
            java.lang.String r7 = "doNotBlockOnValidate"
            r11.put(r7, r5)
        L_0x014e:
            boolean r7 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r23)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r9 = r6.f61409b
            java.lang.String r9 = r9.getCategoryId()
            com.google.gson.f r10 = new com.google.gson.f     // Catch:{ Exception -> 0x019e }
            r10.<init>()     // Catch:{ Exception -> 0x019e }
            net.one97.paytm.recharge.di.helper.c r14 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x019e }
            java.lang.String r14 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x019e }
            java.lang.Class<java.util.HashMap> r15 = java.util.HashMap.class
            java.lang.Object r10 = r10.a((java.lang.String) r14, r15)     // Catch:{ Exception -> 0x019e }
            boolean r14 = r10 instanceof java.util.HashMap     // Catch:{ Exception -> 0x019e }
            if (r14 != 0) goto L_0x016e
            r10 = 0
        L_0x016e:
            java.util.HashMap r10 = (java.util.HashMap) r10     // Catch:{ Exception -> 0x019e }
            r14 = r9
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x019e }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x019e }
            if (r14 != 0) goto L_0x019f
            if (r10 == 0) goto L_0x019f
            r14 = r10
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x019e }
            if (r14 == 0) goto L_0x0196
            boolean r14 = r14.containsKey(r9)     // Catch:{ Exception -> 0x019e }
            if (r14 != r5) goto L_0x019f
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x019e }
            java.lang.Object r9 = r10.get(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x019e }
            boolean r0 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r9, (android.content.Context) r0)     // Catch:{ Exception -> 0x019e }
            if (r0 == 0) goto L_0x019f
            r12 = 1
            goto L_0x019f
        L_0x0196:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x019e }
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r0.<init>(r9)     // Catch:{ Exception -> 0x019e }
            throw r0     // Catch:{ Exception -> 0x019e }
        L_0x019e:
        L_0x019f:
            if (r12 == 0) goto L_0x01a3
            r15 = 1
            goto L_0x01a4
        L_0x01a3:
            r15 = r7
        L_0x01a4:
            net.one97.paytm.recharge.common.utils.w r0 = r6.t
            if (r0 == 0) goto L_0x01db
            net.one97.paytm.recharge.common.utils.w r7 = r6.t
            if (r7 == 0) goto L_0x01d9
            boolean r14 = r6.f61411d
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r6.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x01c0
            java.lang.String r0 = r0.getDisplayName()
            if (r0 != 0) goto L_0x01bd
            goto L_0x01c0
        L_0x01bd:
            r16 = r0
            goto L_0x01c2
        L_0x01c0:
            r16 = r8
        L_0x01c2:
            r17 = r4
            java.util.List r17 = (java.util.List) r17
            r8 = r24
            r9 = r13
            r10 = r3
            r12 = r25
            r13 = r26
            r18 = r30
            r19 = r32
            r20 = r31
            r21 = r33
            net.one97.paytm.recharge.common.utils.w.a((net.one97.paytm.recharge.common.utils.w) r7, (java.lang.String) r8, (java.util.Map) r9, (java.util.Map) r10, (org.json.JSONObject) r11, (java.lang.String) r12, (boolean) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (java.util.List) r17, (java.lang.Object) r18, (java.lang.String) r19, (net.one97.paytm.recharge.model.CJRPersonalInsurance) r20, (net.one97.paytm.recharge.common.utils.o) r21)
        L_0x01d9:
            r7 = 1
            goto L_0x01f9
        L_0x01db:
            r2 = -1
            r3 = 0
            boolean r0 = r6.f61412e
            if (r0 == 0) goto L_0x01e7
            net.one97.paytm.recharge.common.utils.au r0 = new net.one97.paytm.recharge.common.utils.au
            r0.<init>()
            goto L_0x01ec
        L_0x01e7:
            net.one97.paytm.recharge.common.utils.bi r0 = new net.one97.paytm.recharge.common.utils.bi
            r0.<init>()
        L_0x01ec:
            com.paytm.network.model.NetworkCustomError r0 = (com.paytm.network.model.NetworkCustomError) r0
            r4 = r0
            r0 = r22
            r1 = r24
            r7 = 1
            r5 = r30
            r0.a((java.lang.String) r1, (int) r2, (com.paytm.network.model.IJRPaytmDataModel) r3, (com.paytm.network.model.NetworkCustomError) r4, (java.lang.Object) r5)
        L_0x01f9:
            return r7
        L_0x01fa:
            return r12
        L_0x01fb:
            r7 = 1
            kotlin.k.e<kotlin.x> r0 = r6.u
            kotlin.g.a.q r0 = (kotlin.g.a.q) r0
            net.one97.paytm.recharge.common.utils.av r2 = new net.one97.paytm.recharge.common.utils.av
            r2.<init>(r7)
            r3 = r30
            r0.invoke(r1, r2, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.lang.Object, net.one97.paytm.recharge.model.CJRPersonalInsurance, java.lang.String, net.one97.paytm.recharge.common.utils.o):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002d, code lost:
        r5 = r5.getProductId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, net.one97.paytm.recharge.common.e.ai r21, java.lang.Object r22) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r1 = r18
            r10 = r21
            r11 = r22
            java.lang.String r3 = "tag"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r4 = "enteredAmount"
            kotlin.g.b.k.c(r1, r4)
            java.lang.String r4 = "onSuccess"
            kotlin.g.b.k.c(r10, r4)
            net.one97.paytm.recharge.common.b.c r5 = r0.s
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x01f7
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r5 = r0.G
            java.lang.Object r5 = r5.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            r6 = -1
            if (r5 == 0) goto L_0x0038
            java.lang.Long r5 = r5.getProductId()
            if (r5 == 0) goto L_0x0038
            long r8 = r5.longValue()
            goto L_0x0039
        L_0x0038:
            r8 = r6
        L_0x0039:
            androidx.lifecycle.y<java.lang.String> r5 = r0.z
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            boolean r13 = r16.o()
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 == 0) goto L_0x0204
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0204
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0204
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r7 = java.lang.String.valueOf(r8)
            r6.put(r7, r1)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.Map r7 = (java.util.Map) r7
            if (r5 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r8 = "recharge_number"
            r7.put(r8, r5)
            java.lang.String r8 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r9 = "CJRRechargeUtilityConstant.KEY_CATEGORY_ID"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r9 = r0.f61409b
            java.lang.String r9 = r9.getCategoryId()
            java.lang.String r14 = ""
            if (r9 != 0) goto L_0x0091
            r9 = r14
        L_0x0091:
            r7.put(r8, r9)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r8 = r0.J
            java.lang.Object r8 = r8.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r8 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r8
            if (r8 == 0) goto L_0x00ea
            java.lang.String r9 = r8.getValidity()
            if (r9 != 0) goto L_0x00a5
            r9 = r14
        L_0x00a5:
            java.lang.String r15 = "validity"
            r12.put(r15, r9)
            java.lang.String r9 = r8.getTalktime()
            if (r9 != 0) goto L_0x00b1
            r9 = r14
        L_0x00b1:
            java.lang.String r15 = "talktime"
            r12.put(r15, r9)
            java.lang.String r9 = r8.getDescription()
            if (r9 != 0) goto L_0x00bd
            r9 = r14
        L_0x00bd:
            java.lang.String r15 = "couponDescription"
            r12.put(r15, r9)
            java.lang.String r9 = r8.getData()
            if (r9 != 0) goto L_0x00c9
            r9 = r14
        L_0x00c9:
            java.lang.String r15 = "data"
            r12.put(r15, r9)
            java.lang.String r9 = r8.getSms()
            if (r9 != 0) goto L_0x00d5
            r9 = r14
        L_0x00d5:
            java.lang.String r15 = "sms"
            r12.put(r15, r9)
            if (r13 == 0) goto L_0x00ea
            java.lang.String r9 = "this"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            long r8 = r8.getProductId()
            java.lang.String r15 = "plan_id"
            r12.put(r15, r8)
        L_0x00ea:
            if (r13 == 0) goto L_0x0104
            java.lang.String r8 = "phone"
            r12.put(r8, r5)
            java.lang.String r5 = "amount"
            r12.put(r5, r1)
            java.lang.String r5 = "subregion_id"
            r8 = r20
            r12.put(r5, r8)
            java.lang.String r5 = "ref_id"
            r8 = r19
            r12.put(r5, r8)
        L_0x0104:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r5 = r0.G
            java.lang.Object r5 = r5.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x0122
            java.lang.String r8 = r5.getPostOrderViewType()
            java.lang.String r9 = "post_order_view_type"
            r12.put(r9, r8)
            if (r13 == 0) goto L_0x0122
            java.lang.String r5 = r5.getOperator()
            java.lang.String r8 = "operator_id"
            r12.put(r8, r5)
        L_0x0122:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r8 = r0.G
            java.lang.Object r8 = r8.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r8
            if (r8 == 0) goto L_0x0134
            r5.add(r8)
        L_0x0134:
            net.one97.paytm.recharge.common.utils.w r8 = r0.t
            if (r8 == 0) goto L_0x01d9
            net.one97.paytm.recharge.common.utils.w r13 = r0.t
            if (r13 == 0) goto L_0x01d8
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r0.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r8.getCategoryData()
            if (r8 == 0) goto L_0x014c
            java.lang.String r8 = r8.getDisplayName()
            if (r8 != 0) goto L_0x014b
            goto L_0x014c
        L_0x014b:
            r14 = r8
        L_0x014c:
            r8 = r5
            java.util.List r8 = (java.util.List) r8
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "productIdAmountMap"
            kotlin.g.b.k.c(r6, r3)
            java.lang.String r3 = "metaData"
            kotlin.g.b.k.c(r12, r3)
            java.lang.String r3 = "totalAmount"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r3 = "screenName"
            kotlin.g.b.k.c(r14, r3)
            kotlin.g.b.k.c(r10, r4)
            r9 = 0
            r15 = 1536(0x600, float:2.152E-42)
            r3 = r6
            r4 = r7
            r5 = r12
            r6 = r18
            r7 = r8
            r8 = r9
            r9 = r15
            org.json.JSONObject r4 = net.one97.paytm.recharge.common.utils.w.a(r3, r4, r5, r6, r7, r8, r9)
            if (r4 == 0) goto L_0x01ae
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.az.a((org.json.JSONObject) r4)
            r13.n = r1
            net.one97.paytm.recharge.common.utils.y r1 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((org.json.JSONObject) r4)
            boolean r1 = r11 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x019d
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.a((org.json.JSONObject) r4)
            r3 = r11
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r3.getFlowName()
            if (r3 == 0) goto L_0x019d
            r3.setRequestBody(r1)
        L_0x019d:
            net.one97.paytm.recharge.common.b.c r1 = r13.f61789i
            if (r1 == 0) goto L_0x01ad
            com.paytm.network.a$b r6 = com.paytm.network.a.b.USER_FACING
            r2 = r17
            r3 = r21
            r5 = r14
            r7 = r22
            r1.a(r2, r3, r4, r5, r6, r7, 0, true)
        L_0x01ad:
            return
        L_0x01ae:
            r3 = 0
            r4 = 0
            net.one97.paytm.recharge.common.utils.ae r1 = new net.one97.paytm.recharge.common.utils.ae
            android.content.Context r5 = r13.q
            r6 = 0
            if (r5 == 0) goto L_0x01be
            int r7 = net.one97.paytm.recharge.R.string.operator_unavailable_tittle
            java.lang.String r5 = r5.getString(r7)
            goto L_0x01bf
        L_0x01be:
            r5 = r6
        L_0x01bf:
            android.content.Context r7 = r13.q
            if (r7 == 0) goto L_0x01c9
            int r6 = net.one97.paytm.recharge.R.string.product_not_available
            java.lang.String r6 = r7.getString(r6)
        L_0x01c9:
            r1.<init>(r5, r6)
            r5 = r1
            com.paytm.network.model.NetworkCustomError r5 = (com.paytm.network.model.NetworkCustomError) r5
            r1 = r21
            r2 = r17
            r6 = r22
            r1.a(r2, r3, r4, r5, r6)
        L_0x01d8:
            return
        L_0x01d9:
            r3 = -1
            r4 = 0
            boolean r1 = r0.f61412e
            if (r1 == 0) goto L_0x01e5
            net.one97.paytm.recharge.common.utils.au r1 = new net.one97.paytm.recharge.common.utils.au
            r1.<init>()
            goto L_0x01ea
        L_0x01e5:
            net.one97.paytm.recharge.common.utils.bi r1 = new net.one97.paytm.recharge.common.utils.bi
            r1.<init>()
        L_0x01ea:
            com.paytm.network.model.NetworkCustomError r1 = (com.paytm.network.model.NetworkCustomError) r1
            r5 = r1
            r1 = r21
            r2 = r17
            r6 = r22
            r1.a(r2, r3, r4, r5, r6)
            return
        L_0x01f7:
            kotlin.k.e<kotlin.x> r1 = r0.u
            kotlin.g.a.q r1 = (kotlin.g.a.q) r1
            net.one97.paytm.recharge.common.utils.av r3 = new net.one97.paytm.recharge.common.utils.av
            r4 = 1
            r3.<init>(r4)
            r1.invoke(r2, r3, r11)
        L_0x0204:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.d.a.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.recharge.common.e.ai, java.lang.Object):void");
    }

    public final void r() {
        String str;
        if (this.s.a()) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            Long l = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setUserFacing(a.b.SILENT);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FETCH_INSURANCE_API.name());
            }
            net.one97.paytm.recharge.common.b.c cVar = this.s;
            ai aiVar = this;
            String protectionURL = this.f61409b.getProtectionURL();
            String str2 = protectionURL == null ? "" : protectionURL;
            String str3 = (String) this.z.getValue();
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            CJRProductsItem value = this.G.getValue();
            if (value != null) {
                l = value.getProductId();
            }
            cVar.a("fetch_insurance_data", aiVar, str2, str, (CJRRechargeCart) null, String.valueOf(l), "", (CJRCartProduct) null, a2);
        }
    }
}
