package net.one97.paytm.recharge.common.h;

import android.text.TextUtils;
import androidx.lifecycle.y;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.k.e;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ar;
import net.one97.paytm.recharge.common.utils.be;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRBrowsePlansHeader;
import net.one97.paytm.recharge.model.CJRDynamicBrowsePlans;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccounts;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRDeviceType;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRMetaInfo;
import net.one97.paytm.recharge.model.v4.CJRMyBillData;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItemMap;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public class g extends b {
    public String A = "";
    public CJRFrequentOrderList B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public HashMap<String, CJRCategoryDataHelper> G;
    public boolean H;
    public boolean I;
    public HashMap<Integer, CJRBrowsePlanDescriptions> J;
    public CJRBrowsePlansHeader K;
    boolean L = true;
    public CJRMerchantLoanAccounts M;
    public boolean N;
    private CJRNextGroupData O;
    private HashMap<String, String> P = new HashMap<>();
    public final y<Data<CJRProductList>> w = new y<>();
    public final y<Data<CJRCategoryData>> x = new y<>();
    public final be<CJRNextGroupData> y = new be<>();
    public y<Boolean> z = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(CJRItem cJRItem, c cVar, w wVar, e<x> eVar, d dVar) {
        super(cJRItem, cVar, wVar, eVar, dVar);
        k.c(cJRItem, "rechargeItem");
        k.c(cVar, "rechargeRepo");
        k.c(wVar, "rechargeProceedHelper");
        k.c(eVar, "errorHandler");
        k.c(dVar, "gtmEventHelper");
        String categoryId = cJRItem.getCategoryId();
        k.a((Object) categoryId, "rechargeItem.categoryId");
        this.A = categoryId;
    }

    public final CJRCategoryDataHelper g() {
        return new CJRCategoryDataHelper();
    }

    public final net.one97.paytm.recharge.common.utils.x h() {
        return new net.one97.paytm.recharge.common.utils.x();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        super.i();
    }

    private final void d(String str, Object obj) {
        this.z.setValue(Boolean.TRUE);
        this.s.a(str, (ai) this, this.f61409b.getFilterJSON(), this.A, this.F, obj);
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f61447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRCategoryData f61448b;

        b(g gVar, CJRCategoryData cJRCategoryData) {
            this.f61447a = gVar;
            this.f61448b = cJRCategoryData;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLog("MerchantLoanAccounts: Error in fetching: ".concat(String.valueOf(z.a(networkCustomError != null ? networkCustomError.networkResponse : null))));
            g gVar = this.f61447a;
            gVar.L = false;
            gVar.a_(str, this.f61448b, obj);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a_(java.lang.String r12, com.paytm.network.model.IJRPaytmDataModel r13, java.lang.Object r14) {
            /*
                r11 = this;
                java.lang.String r0 = "tag"
                kotlin.g.b.k.c(r12, r0)
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                net.one97.paytm.common.entity.recharge.CJRFrequentOrderList r0 = r0.getFrequentOrderList()
                net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r11.f61448b
                java.lang.String r1 = r1.getDisplayName()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r2 = 0
                if (r1 != 0) goto L_0x0033
                if (r0 == 0) goto L_0x0033
                java.util.List r1 = r0.getOrderList()
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0033
                net.one97.paytm.recharge.common.utils.q r1 = net.one97.paytm.recharge.common.utils.q.f61722a
                net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r11.f61448b
                java.lang.String r1 = r1.getDisplayName()
                java.util.List r0 = net.one97.paytm.recharge.common.utils.q.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrderList) r0, (java.lang.String) r1, (java.lang.String) r2)
                goto L_0x0034
            L_0x0033:
                r0 = r2
            L_0x0034:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                boolean r3 = r13 instanceof net.one97.paytm.recharge.model.CJRMerchantLoanAccounts
                r4 = 0
                if (r3 == 0) goto L_0x008f
                net.one97.paytm.recharge.common.h.g r3 = r11.f61447a
                net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r13 = (net.one97.paytm.recharge.model.CJRMerchantLoanAccounts) r13
                r3.M = r13
                if (r0 == 0) goto L_0x008f
                java.util.List r3 = r13.getAccounts()
                if (r3 == 0) goto L_0x008f
                java.util.Iterator r0 = r0.iterator()
                r3 = 0
            L_0x0051:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x0090
                java.lang.Object r5 = r0.next()
                net.one97.paytm.common.entity.recharge.CJRFrequentOrder r5 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r5
                java.util.List r6 = r13.getAccounts()
                if (r6 != 0) goto L_0x0066
                kotlin.g.b.k.a()
            L_0x0066:
                java.util.Iterator r6 = r6.iterator()
            L_0x006a:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L_0x0051
                java.lang.Object r7 = r6.next()
                net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem r7 = (net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem) r7
                java.lang.String r8 = r5.getRechargeNumber()
                java.lang.String r9 = r7.getAccountNumber()
                if (r9 != 0) goto L_0x0083
                kotlin.g.b.k.a()
            L_0x0083:
                r10 = 1
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r10)
                if (r8 == 0) goto L_0x006a
                r1.add(r7)
                r3 = 1
                goto L_0x006a
            L_0x008f:
                r3 = 0
            L_0x0090:
                if (r3 == 0) goto L_0x00d5
                int r13 = r1.size()
                if (r13 == 0) goto L_0x00d5
                net.one97.paytm.recharge.common.h.g r13 = r11.f61447a
                net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r13 = r13.M
                if (r13 != 0) goto L_0x00a1
                kotlin.g.b.k.a()
            L_0x00a1:
                java.util.List r13 = r13.getAccounts()
                if (r13 != 0) goto L_0x00aa
                kotlin.g.b.k.a()
            L_0x00aa:
                if (r13 == 0) goto L_0x00cd
                java.util.ArrayList r13 = (java.util.ArrayList) r13
                java.util.Collection r1 = (java.util.Collection) r1
                r13.removeAll(r1)
                net.one97.paytm.recharge.common.h.g r13 = r11.f61447a
                net.one97.paytm.recharge.model.CJRMerchantLoanAccounts r13 = r13.M
                if (r13 != 0) goto L_0x00bc
                kotlin.g.b.k.a()
            L_0x00bc:
                java.util.List r13 = r13.getAccounts()
                if (r13 != 0) goto L_0x00c5
                kotlin.g.b.k.a()
            L_0x00c5:
                int r13 = r13.size()
                if (r13 <= 0) goto L_0x00d5
                r3 = 0
                goto L_0x00d5
            L_0x00cd:
                kotlin.u r12 = new kotlin.u
                java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem>"
                r12.<init>(r13)
                throw r12
            L_0x00d5:
                if (r3 == 0) goto L_0x00e3
                net.one97.paytm.recharge.common.h.g r13 = r11.f61447a
                r13.M = r2
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.String r0 = "MerchantLoanAccounts: Has Account in both recents & account"
                r13.debugLog(r0)
                goto L_0x00ea
            L_0x00e3:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.String r0 = "MerchantLoanAccounts: Has no account detail in recents"
                r13.debugLog(r0)
            L_0x00ea:
                net.one97.paytm.recharge.common.h.g r13 = r11.f61447a
                r13.L = r4
                net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r11.f61448b
                com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
                r13.a_(r12, r0, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.g.b.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
        }
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        HashMap<String, String> productHashMap;
        boolean z2;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRCategoryData) {
            CJRCategoryData cJRCategoryData = (CJRCategoryData) iJRPaytmDataModel;
            k.c(str, "tag");
            k.c(cJRCategoryData, "categoryData");
            boolean z3 = true;
            if (!k.a((Object) this.A, (Object) "37217") || !this.L) {
                z2 = false;
            } else {
                this.s.d(str, new b(this, cJRCategoryData), obj);
                CJRRechargeUtilities.INSTANCE.debugLog("MerchantLoanAccounts: waiting for api response");
                z2 = true;
            }
            if (!z2) {
                if (this.H) {
                    this.H = false;
                    b(str, obj);
                    return;
                }
                CJRCategoryData lastGroupingData = this.f61409b.getLastGroupingData();
                if (iJRPaytmDataModel == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRCategoryData");
                } else if (lastGroupingData == null) {
                    CJRMetaInfo metaInfo = cJRCategoryData.getMetaInfo();
                    this.F = metaInfo != null ? metaInfo.getTrackingId() : null;
                    this.f61409b.setCategoryData(this.A, cJRCategoryData);
                    this.x.postValue(new Data(DataState.SUCCESS, cJRCategoryData, (String) null));
                } else {
                    List<GroupAttributesItem> attributes = lastGroupingData.getAttributes();
                    List<GroupAttributesItem> attributes2 = cJRCategoryData.getAttributes();
                    if (attributes != null && attributes2 != null && (!attributes.isEmpty()) && attributes.size() == attributes2.size()) {
                        int size = attributes.size() - 1;
                        int i2 = 0;
                        boolean z4 = true;
                        while (true) {
                            if (i2 >= size) {
                                z3 = z4;
                                break;
                            }
                            GroupAttributesItem groupAttributesItem = attributes.get(i2);
                            String name = groupAttributesItem != null ? groupAttributesItem.getName() : null;
                            GroupAttributesItem groupAttributesItem2 = attributes2.get(i2);
                            String name2 = groupAttributesItem2 != null ? groupAttributesItem2.getName() : null;
                            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(name2)) {
                                if (!p.a(name, name2, true)) {
                                    break;
                                }
                                z4 = false;
                            }
                            i2++;
                        }
                    }
                    if (z3) {
                        lastGroupingData.setNextGroupingData(cJRCategoryData);
                        a(obj);
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRProductList) {
            this.w.setValue(new Data(DataState.SUCCESS, iJRPaytmDataModel, (String) null));
            this.f61410c.f61812a = (CJRProductList) iJRPaytmDataModel;
        } else if (iJRPaytmDataModel instanceof CJRProductsItemMap) {
            CJRProductsItemMap cJRProductsItemMap = (CJRProductsItemMap) iJRPaytmDataModel;
            if (!(cJRProductsItemMap == null || (productHashMap = cJRProductsItemMap.getProductHashMap()) == null)) {
                if (productHashMap.containsKey("price")) {
                    productHashMap.remove("price");
                }
                this.m.putAll(productHashMap);
            }
            c(str, obj);
        } else if (iJRPaytmDataModel instanceof CJRDynamicBrowsePlans) {
            CJRDynamicBrowsePlans cJRDynamicBrowsePlans = (CJRDynamicBrowsePlans) iJRPaytmDataModel;
            this.J = ar.a(cJRDynamicBrowsePlans);
            this.K = ar.b(cJRDynamicBrowsePlans);
        } else if (iJRPaytmDataModel instanceof CJRMyBillData) {
            CJRMyBillData cJRMyBillData = (CJRMyBillData) iJRPaytmDataModel;
            if (!(cJRMyBillData.getError() == null || cJRMyBillData.getStatusCode() == null || !net.one97.paytm.recharge.common.utils.g.c(cJRMyBillData.getError().getError()))) {
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setAlertMessage(cJRMyBillData.getError().getError());
                networkCustomError.setmAlertTitle(cJRMyBillData.getError().getErrorTitle());
                a(str, cJRMyBillData.getStatusCode().intValue(), iJRPaytmDataModel, networkCustomError, obj);
            }
            this.z.setValue(Boolean.FALSE);
            this.f61408a.setValue(new CJRInstruct.showMyBill(cJRMyBillData));
        } else {
            super.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public void a(String str, boolean z2, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRCategoryData categoryData;
        List<CJRRelatedCategory> relatedCategories;
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        this.I = z2;
        if (!z2) {
            this.C = false;
            this.f61408a.setValue(new CJRInstruct.resetRadioButton());
            CJRCategoryData categoryData2 = this.f61409b.getCategoryData();
            if ((categoryData2 != null ? categoryData2.getRelatedCategories() : null) == null || (!((categoryData = this.f61409b.getCategoryData()) == null || (relatedCategories = categoryData.getRelatedCategories()) == null || !relatedCategories.isEmpty()) || this.f61411d)) {
                this.f61408a.setValue(new CJRInstruct.resetUI());
            }
            this.f61409b.setCategoryData((CJRCategoryData) null);
            a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        a_(str, iJRPaytmDataModel, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if ((r0 != null ? (net.one97.paytm.recharge.model.v4.CJRCategoryData) r0.getData() : null) == null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, int r6, com.paytm.network.model.IJRPaytmDataModel r7, com.paytm.network.model.NetworkCustomError r8, java.lang.Object r9) {
        /*
            r4 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "getCategory"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0037
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData>> r0 = r4.x
            java.lang.Object r0 = r0.getValue()
            r1 = 0
            if (r0 == 0) goto L_0x002a
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData>> r0 = r4.x
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.Data r0 = (net.one97.paytm.recharge.model.v4.Data) r0
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r0.getData()
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r0
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 != 0) goto L_0x0037
        L_0x002a:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData>> r0 = r4.x
            net.one97.paytm.recharge.model.v4.Data r2 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r3 = net.one97.paytm.recharge.model.v4.DataState.ERROR
            r2.<init>(r3, r1, r1)
            r0.setValue(r2)
            goto L_0x004b
        L_0x0037:
            boolean r0 = r8 instanceof net.one97.paytm.recharge.common.utils.ao
            if (r0 == 0) goto L_0x004b
            boolean r6 = r9 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r6 == 0) goto L_0x0047
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            r6 = r9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6)
        L_0x0047:
            r4.c(r5, r9)
            return
        L_0x004b:
            r0 = 0
            r4.I = r0
            r4.D = r0
            r4.E = r0
            androidx.lifecycle.y<java.lang.Boolean> r0 = r4.z
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.setValue(r1)
            super.a((java.lang.String) r5, (int) r6, (com.paytm.network.model.IJRPaytmDataModel) r7, (com.paytm.network.model.NetworkCustomError) r8, (java.lang.Object) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.g.a(java.lang.String, int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        r4 = (net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem) (r4 = (r4 = r4.getAggrAttrs()).get(0)).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "groupName"
            kotlin.g.b.k.c(r5, r0)
            boolean r0 = r3.N
            r1 = 0
            if (r0 != 0) goto L_0x0067
            boolean r0 = r3.C
            if (r0 != 0) goto L_0x0067
            if (r4 != 0) goto L_0x0067
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            r0 = 0
            if (r4 == 0) goto L_0x0034
            java.util.List r4 = r4.getAggrAttrs()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r4.get(r1)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem) r4
            if (r4 == 0) goto L_0x0034
            java.lang.String r4 = r4.getValue()
            goto L_0x0035
        L_0x0034:
            r4 = r0
        L_0x0035:
            r2 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r4, (boolean) r2)
            if (r4 == 0) goto L_0x0067
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderList r4 = r3.B
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r3.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = r5.getCategoryData()
            if (r5 == 0) goto L_0x004a
            java.lang.String r0 = r5.getDisplayName()
        L_0x004a:
            boolean r4 = net.one97.paytm.recharge.legacy.catalog.fragment.d.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrderList) r4, (java.lang.String) r0)
            if (r4 != 0) goto L_0x0067
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r3.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            if (r4 == 0) goto L_0x0063
            java.util.List r4 = r4.getRelatedCategories()
            if (r4 == 0) goto L_0x0063
            int r4 = r4.size()
            goto L_0x0064
        L_0x0063:
            r4 = 0
        L_0x0064:
            if (r4 > r2) goto L_0x0067
            return r2
        L_0x0067:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.g.a(int, java.lang.String):boolean");
    }

    public final void a(String str, boolean z2, Object obj) {
        if (z2) {
            this.z.setValue(Boolean.TRUE);
        }
        a(str, this.A, (ai) this, (net.one97.paytm.recharge.common.b.a.a) this, obj);
    }

    public static final class a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f61446a;

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
        }

        a(g gVar) {
            this.f61446a = gVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            NetworkResponse networkResponse;
            k.c(str, "tag");
            if (iJRPaytmDataModel != null && (networkResponse = iJRPaytmDataModel.getNetworkResponse()) != null && networkResponse.statusCode == 200) {
                this.f61446a.f61408a.setValue(new CJRInstruct.setIsBillConsentSetSuccessfully(false));
            }
        }
    }

    public final void b(String str, Object obj) {
        k.c(str, "tag");
        if (!this.m.containsKey(CLPConstants.PRODUCT_ID) || !net.one97.paytm.recharge.common.utils.g.c(this.m.get(CLPConstants.PRODUCT_ID))) {
            this.x.postValue(new Data(DataState.FULL_SCREEN_LOADING, null, (String) null));
            a(str, false, obj);
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
            flowName2.setActionType(ACTION_TYPE.DEEPLINK.name());
        }
        String str2 = this.m.get(CLPConstants.PRODUCT_ID);
        if (str2 != null) {
            k.a((Object) str2, "it");
            CJRRechargeErrorModel cJRRechargeErrorModel = a2;
            if (this.D) {
                cJRRechargeErrorModel = obj;
            }
            d("getProductFromDeeplink", str2, cJRRechargeErrorModel);
        }
    }

    public final void d(String str, String str2, Object obj) {
        k.c(str, "tag");
        k.c(str2, "productId");
        this.m.remove(CLPConstants.PRODUCT_ID);
        this.z.setValue(Boolean.TRUE);
        this.s.a(str, (ai) this, this.A, str2, this.F, obj);
    }

    public void c(String str, Object obj) {
        Map<String, CJRSelectedGroupItem> selectedGroupItemHashMap;
        k.c(str, "tag");
        this.f61408a.setValue(new CJRInstruct.resetUI());
        String str2 = null;
        if (this.f61409b.getCategoryData() != null) {
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            if (categoryData != null) {
                categoryData.setNextLevelGroupingData((CJRCategoryData) null);
            }
            CJRCategoryData categoryData2 = this.f61409b.getCategoryData();
            if (!(categoryData2 == null || (selectedGroupItemHashMap = categoryData2.getSelectedGroupItemHashMap()) == null)) {
                selectedGroupItemHashMap.clear();
            }
            this.x.postValue(new Data(DataState.AFTER_PRODUCT_DETAIL_LOADED, this.f61409b.getCategoryData(), (String) null));
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEEPLINK, ERROR_TYPE.UNDEFINED);
        if (obj instanceof CJRRechargeErrorModel) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
            String errorType = flowName != null ? flowName.getErrorType() : null;
            Object obj2 = ERROR_TYPE.UNDEFINED;
            if (!TextUtils.isEmpty(errorType)) {
                if (errorType == null) {
                    try {
                        k.a();
                    } catch (Exception unused) {
                    }
                }
                obj2 = ERROR_TYPE.valueOf(errorType);
            }
            ERROR_TYPE error_type = (ERROR_TYPE) obj2;
            net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
            if (flowName2 != null) {
                str2 = flowName2.getActionType();
            }
            Object obj3 = ACTION_TYPE.DEEPLINK;
            if (!TextUtils.isEmpty(str2)) {
                if (str2 == null) {
                    try {
                        k.a();
                    } catch (Exception unused2) {
                    }
                }
                obj3 = ACTION_TYPE.valueOf(str2);
            }
            ACTION_TYPE action_type = (ACTION_TYPE) obj3;
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setErrorType(error_type.name());
            }
            CRUFlowModel flowName4 = a2.getFlowName();
            if (flowName4 != null) {
                flowName4.setActionType(action_type.name());
            }
        }
        b("getCategory", a2);
    }

    public final void a(Object obj) {
        this.O = this.f61409b.getNextGroupItemData();
        CJRNextGroupData cJRNextGroupData = this.O;
        if (cJRNextGroupData != null) {
            this.y.setValue(cJRNextGroupData);
            return;
        }
        g gVar = this;
        if (gVar.f61409b.isGroupAPICallRequired()) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (net.one97.paytm.recharge.di.helper.c.aR() || !gVar.I) {
                gVar.e("grouping", obj);
                return;
            }
            return;
        }
        gVar.d("fetch_product_list", obj);
    }

    private final void e(String str, Object obj) {
        JSONObject nextGroupingPostBody = this.f61409b.getNextGroupingPostBody();
        this.z.setValue(Boolean.TRUE);
        this.s.b(str, this, nextGroupingPostBody, this.A, this.F, obj);
    }

    public final void a(int i2, String str, String str2) {
        String str3;
        String str4;
        CJRDeviceType type;
        String str5;
        String str6;
        CJRDeviceType type2;
        k.c(str, "groupName");
        k.c(str2, "serviceType");
        GroupAttributesItem groupAttributes = this.f61409b.getGroupAttributes(i2, str);
        CJRAggsItem aggItem = this.f61409b.getAggItem(i2, str);
        List<CJRAggsItem> groupItemList = this.f61409b.getGroupItemList(i2, str);
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(groupItemList);
        net.one97.paytm.recharge.common.utils.y yVar2 = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f61409b);
        CJRRechargeUtilities.INSTANCE.debugLog("fieldSelected: [groupLevel-" + i2 + "] [groupName-" + str + ']');
        String str7 = null;
        if (!p.a(groupAttributes != null ? groupAttributes.getName() : null, "state", false)) {
            if (groupAttributes != null) {
                str5 = groupAttributes.getName();
            } else {
                str5 = null;
            }
            if (!p.a(str5, "city", false)) {
                be<CJRInstruct> beVar = this.f61408a;
                if (aggItem == null || (str6 = aggItem.getLabel()) == null) {
                    str6 = groupAttributes != null ? groupAttributes.getDisplayName() : null;
                }
                if (str6 == null) {
                    str6 = "";
                }
                if (!(groupAttributes == null || (type2 = groupAttributes.getType()) == null)) {
                    str7 = type2.getAndroidType();
                }
                beVar.setValue(new CJRInstruct.startOperatorListActivity(str6, str7));
                String str8 = ab.f61496a;
                k.a((Object) str8, "CJRRechargeUtilityConstant.UTILITY");
                d.a(this.v, a(), str + "_dropdown_clicked", "", "", str8, (Object) null, (Object) null, 96);
            }
        }
        be<CJRInstruct> beVar2 = this.f61408a;
        if (aggItem == null || (str3 = aggItem.getLabel()) == null) {
            str3 = groupAttributes != null ? groupAttributes.getDisplayName() : null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (!(groupAttributes == null || (type = groupAttributes.getType()) == null)) {
            str7 = type.getAndroidType();
        }
        if (groupAttributes == null || (str4 = groupAttributes.getPlaceholder()) == null) {
            str4 = "";
        }
        beVar2.setValue(new CJRInstruct.startLocationActivity(str3, str7, str4, str));
        String str82 = ab.f61496a;
        k.a((Object) str82, "CJRRechargeUtilityConstant.UTILITY");
        d.a(this.v, a(), str + "_dropdown_clicked", "", "", str82, (Object) null, (Object) null, 96);
    }

    public final void a(int i2, String str, int i3, CJRAggsItem cJRAggsItem, String str2) {
        CJRAggsItem cJRAggsItem2;
        Object obj;
        k.c(str, "groupName");
        k.c(str2, "eventCategory");
        List<CJRAggsItem> groupItemList = this.f61409b.getGroupItemList(i2, str);
        String str3 = null;
        if (cJRAggsItem != null) {
            if (groupItemList != null) {
                Iterator it2 = groupItemList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (((CJRAggsItem) obj).equals(cJRAggsItem)) {
                        break;
                    }
                }
                cJRAggsItem2 = (CJRAggsItem) obj;
            } else {
                cJRAggsItem2 = null;
            }
            if (cJRAggsItem2 == null) {
                return;
            }
        } else {
            cJRAggsItem = this.f61409b.getGroupItem(i2, str, i3);
        }
        CJRAggsItem cJRAggsItem3 = cJRAggsItem;
        if (TextUtils.isEmpty(cJRAggsItem3 != null ? cJRAggsItem3.getBbpsLogoUrl() : null)) {
            CJRAggsItem aggItem = this.f61409b.getAggItem(i2, str);
            if (aggItem != null) {
                str3 = aggItem.getBbpsLogoUrl();
            }
            if (!TextUtils.isEmpty(str3) && cJRAggsItem3 != null) {
                cJRAggsItem3.setBbpsLogoUrl(str3);
            }
        }
        a(str, i3, cJRAggsItem3, i2, false);
    }

    public final void a(String str, int i2, CJRAggsItem cJRAggsItem, int i3, boolean z2) {
        String str2;
        String str3;
        List<List<CJRAggrAttrsItem>> aggrAttrs;
        List list;
        CJRAggrAttrsItem cJRAggrAttrsItem;
        CJRDeviceType type;
        String str4 = str;
        int i4 = i2;
        int i5 = i3;
        if (i4 != -1) {
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            String str5 = null;
            Integer showUpgrade = categoryData != null ? categoryData.getShowUpgrade() : null;
            if (showUpgrade != null && showUpgrade.intValue() == 1) {
                be<CJRInstruct> beVar = this.f61408a;
                if (cJRAggsItem != null) {
                    str5 = cJRAggsItem.getMinAndroidVersion();
                }
                beVar.setValue(new CJRInstruct.openUpdateAppVersionScreen(str5));
                return;
            }
            this.f61409b.removeSelectedGroupItem(i5, str);
            this.f61408a.setValue(new CJRInstruct.removeExtraFilteredGroup(i5, str));
            this.f61408a.setValue(new CJRInstruct.removeAllInputFields());
            this.f61408a.setValue(new CJRInstruct.clearProduct());
            GroupAttributesItem groupAttributes = this.f61409b.getGroupAttributes(i5, str);
            this.f61409b.addSelectedGroupItem(i5, new CJRSelectedGroupItem(groupAttributes != null ? groupAttributes.getName() : null, (groupAttributes == null || (type = groupAttributes.getType()) == null) ? null : type.getAndroid(), groupAttributes != null ? groupAttributes.getDisplayName() : null, cJRAggsItem != null ? cJRAggsItem.getValue() : null, i2));
            String displayValue = cJRAggsItem != null ? cJRAggsItem.getDisplayValue() : null;
            if (cJRAggsItem != null) {
                str2 = cJRAggsItem.getValue();
            } else {
                str2 = null;
            }
            if (i5 == 0) {
                CJRCategoryData categoryData2 = this.f61409b.getCategoryData();
                if (p.a(str, (categoryData2 == null || (aggrAttrs = categoryData2.getAggrAttrs()) == null || (list = aggrAttrs.get(0)) == null || (cJRAggrAttrsItem = (CJRAggrAttrsItem) list.get(0)) == null) ? null : cJRAggrAttrsItem.getValue(), true) && str2 != null) {
                    this.s.a(this.A, str2);
                }
            }
            if (displayValue != null) {
                this.f61408a.setValue(new CJRInstruct.setText(i5, str, displayValue));
            }
            CJRRechargeUtilities.INSTANCE.debugLog("handleFilterGroupItemSelected: [name-" + str + "] [index-" + i4 + "] [isAuto-true] [group-" + i5 + ']');
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FILTER_GROUP_SELECTED.name());
            }
            a((Object) a2);
            d dVar2 = this.v;
            String a3 = a();
            String str6 = str + "_dropdown_item_selected";
            if (cJRAggsItem == null || (str3 = cJRAggsItem.getValue()) == null) {
                str3 = "";
            }
            String str7 = str3;
            String str8 = ab.f61496a;
            k.a((Object) str8, "CJRRechargeUtilityConstant.UTILITY");
            d.a(dVar2, a3, str6, "", str7, str8, z2 ? "auto" : "manual", (Object) null, 64);
        }
    }

    public final String a() {
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

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r1 = (r1 = (r1 = (net.one97.paytm.recharge.model.v4.CJRProductList) r1.getData()).getProducts()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, org.json.JSONObject r18, java.util.Map<java.lang.String, java.lang.String> r19, java.util.Map<java.lang.String, java.lang.String> r20, java.lang.String r21, java.lang.String r22, boolean r23, boolean r24, boolean r25, java.util.List<net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem> r26, java.lang.String r27, java.lang.String r28, java.lang.Object r29) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r1 = r18
            r4 = r20
            java.lang.String r3 = "tag"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "mMetaData"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r3 = "productIdAmountMap"
            r5 = r19
            kotlin.g.b.k.c(r5, r3)
            java.lang.String r3 = "keyValueMap"
            kotlin.g.b.k.c(r4, r3)
            java.lang.String r3 = "totalAmount"
            r6 = r21
            kotlin.g.b.k.c(r6, r3)
            java.lang.String r3 = "inputFieldValues"
            r7 = r27
            kotlin.g.b.k.c(r7, r3)
            java.lang.String r3 = "serviceType"
            r7 = r28
            kotlin.g.b.k.c(r7, r3)
            r10 = r25
            r0.f61411d = r10
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r0.f61409b
            org.json.JSONObject r7 = r3.getSelectedGroupFieldMeta(r1)
            net.one97.paytm.recharge.common.b.c r1 = r0.s
            boolean r1 = r1.a()
            r3 = 0
            if (r1 == 0) goto L_0x016d
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r8 = "CJRRechargeUtilityConstant.KEY_CATEGORY_ID"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r0.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r8.getCategoryData()
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0067
            java.lang.Long r8 = r8.getCategoryId()
            if (r8 == 0) goto L_0x0067
            long r11 = r8.longValue()
            java.lang.String r8 = java.lang.String.valueOf(r11)
            if (r8 != 0) goto L_0x0068
        L_0x0067:
            r8 = r9
        L_0x0068:
            r4.put(r1, r8)
            net.one97.paytm.recharge.common.utils.w r1 = r0.t
            if (r1 == 0) goto L_0x0085
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r0.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r8.getCategoryData()
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = r8.getGAEventCategory()
            if (r8 != 0) goto L_0x007e
        L_0x007d:
            r8 = r9
        L_0x007e:
            java.lang.String r11 = "<set-?>"
            kotlin.g.b.k.c(r8, r11)
            r1.p = r8
        L_0x0085:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r1 = r0.w
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.v4.Data r1 = (net.one97.paytm.recharge.model.v4.Data) r1
            r8 = 1
            if (r1 == 0) goto L_0x00b8
            java.lang.Object r1 = r1.getData()
            net.one97.paytm.recharge.model.v4.CJRProductList r1 = (net.one97.paytm.recharge.model.v4.CJRProductList) r1
            if (r1 == 0) goto L_0x00b8
            java.util.List r1 = r1.getProducts()
            if (r1 == 0) goto L_0x00b8
            r11 = r1
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r8
            if (r11 == 0) goto L_0x00b8
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x00b8
            boolean r1 = r1.isProceedToPGEnabled()
            if (r1 != r8) goto L_0x00b8
            r1 = 1
            goto L_0x00b9
        L_0x00b8:
            r1 = 0
        L_0x00b9:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r11 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r11 = r11.getApplicationContext()
            if (r11 == 0) goto L_0x0124
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r13 = r0.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r13 = r13.getCategoryData()
            if (r13 == 0) goto L_0x00d8
            java.lang.Long r13 = r13.getCategoryId()
            if (r13 == 0) goto L_0x00d8
            long r13 = r13.longValue()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            goto L_0x00d9
        L_0x00d8:
            r13 = 0
        L_0x00d9:
            com.google.gson.f r14 = new com.google.gson.f     // Catch:{ Exception -> 0x011f }
            r14.<init>()     // Catch:{ Exception -> 0x011f }
            net.one97.paytm.recharge.di.helper.c r15 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x011f }
            java.lang.String r15 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x011f }
            java.lang.Class<java.util.HashMap> r12 = java.util.HashMap.class
            java.lang.Object r12 = r14.a((java.lang.String) r15, r12)     // Catch:{ Exception -> 0x011f }
            boolean r14 = r12 instanceof java.util.HashMap     // Catch:{ Exception -> 0x011f }
            if (r14 != 0) goto L_0x00ef
            r12 = 0
        L_0x00ef:
            java.util.HashMap r12 = (java.util.HashMap) r12     // Catch:{ Exception -> 0x011f }
            r14 = r13
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x011f }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x011f }
            if (r14 != 0) goto L_0x0120
            if (r12 == 0) goto L_0x0120
            r14 = r12
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x011f }
            if (r14 == 0) goto L_0x0117
            boolean r14 = r14.containsKey(r13)     // Catch:{ Exception -> 0x011f }
            if (r14 != r8) goto L_0x0120
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x011f }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ Exception -> 0x011f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x011f }
            boolean r11 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r12, (android.content.Context) r11)     // Catch:{ Exception -> 0x011f }
            if (r11 == 0) goto L_0x0120
            r3 = 1
            goto L_0x0120
        L_0x0117:
            kotlin.u r11 = new kotlin.u     // Catch:{ Exception -> 0x011f }
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r11.<init>(r12)     // Catch:{ Exception -> 0x011f }
            throw r11     // Catch:{ Exception -> 0x011f }
        L_0x011f:
        L_0x0120:
            if (r3 != r8) goto L_0x0124
            r12 = 1
            goto L_0x0125
        L_0x0124:
            r12 = r1
        L_0x0125:
            net.one97.paytm.recharge.common.utils.w r1 = r0.t
            if (r1 == 0) goto L_0x016c
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r0.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.getCategoryData()
            if (r3 == 0) goto L_0x013a
            java.lang.String r3 = r3.getDisplayName()
            if (r3 != 0) goto L_0x0138
            goto L_0x013a
        L_0x0138:
            r13 = r3
            goto L_0x013b
        L_0x013a:
            r13 = r9
        L_0x013b:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r3 = r0.w
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.Data r3 = (net.one97.paytm.recharge.model.v4.Data) r3
            if (r3 == 0) goto L_0x0153
            java.lang.Object r3 = r3.getData()
            net.one97.paytm.recharge.model.v4.CJRProductList r3 = (net.one97.paytm.recharge.model.v4.CJRProductList) r3
            if (r3 == 0) goto L_0x0153
            java.util.List r3 = r3.getProducts()
            r14 = r3
            goto L_0x0154
        L_0x0153:
            r14 = 0
        L_0x0154:
            r2 = r17
            r3 = r19
            r4 = r20
            r5 = r7
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r15 = r29
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, (java.lang.String) null, (java.lang.String) null, (net.one97.paytm.recharge.common.e.ai) null)
        L_0x016c:
            return
        L_0x016d:
            r0.D = r3
            r0.E = r3
            kotlin.k.e<kotlin.x> r1 = r0.u
            kotlin.g.a.q r1 = (kotlin.g.a.q) r1
            net.one97.paytm.recharge.common.utils.c r3 = new net.one97.paytm.recharge.common.utils.c
            r3.<init>()
            r4 = r29
            r1.invoke(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.g.a(java.lang.String, org.json.JSONObject, java.util.Map, java.util.Map, java.lang.String, java.lang.String, boolean, boolean, boolean, java.util.List, java.lang.String, java.lang.String, java.lang.Object):void");
    }

    public final void a(String str, String str2, ai aiVar, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        k.c(str, "tag");
        k.c(str2, "categoryId");
        k.c(aiVar, "onSuccessListener");
        this.s.a(str, aiVar, str2, this.F, aVar, obj);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        this.m.clear();
        this.C = true;
        if (cJRFrequentOrder != null) {
            Map map = this.m;
            String productID = cJRFrequentOrder.getProductID();
            if (productID == null) {
                productID = "";
            }
            map.put(CLPConstants.PRODUCT_ID, productID);
            HashMap<String, String> hashMap = this.m;
            CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
            k.a((Object) frequentOrderProduct, "frequentOrder.frequentOrderProduct");
            hashMap.putAll(frequentOrderProduct.getAttributes());
            this.m.putAll(cJRFrequentOrder.getConfiguration());
        }
        if (cJRFrequentOrder == null) {
            try {
                k.a();
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        if (cJRFrequentOrder.getFrequentOrderProduct() != null) {
            CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
            k.a((Object) frequentOrderProduct2, "frequentOrder.frequentOrderProduct");
            if (!TextUtils.isEmpty(frequentOrderProduct2.getFrequentOrderBrand())) {
                CJRFrequentOrderProduct frequentOrderProduct3 = cJRFrequentOrder.getFrequentOrderProduct();
                k.a((Object) frequentOrderProduct3, "frequentOrder.frequentOrderProduct");
                String frequentOrderBrand = frequentOrderProduct3.getFrequentOrderBrand();
                k.a((Object) frequentOrderBrand, "frequentOrder.frequentOr…roduct.frequentOrderBrand");
                this.m.put(StringSet.operator, frequentOrderBrand);
            }
        }
        if ((cJRFrequentOrder != null ? cJRFrequentOrder.getProductAttributes() : null) != null && p.a("merchant_loan_account", cJRFrequentOrder.getProductAttributes().get("merchant_loan_account"), true)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            this.m.put(CLPConstants.PRODUCT_ID, net.one97.paytm.recharge.di.helper.c.bs());
        }
        this.f61408a.setValue(new CJRInstruct.onRecentClickCheckRcChange());
    }

    public final void a(String str, HashMap<Object, Object> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(hashMap, "params");
        w wVar = this.t;
        if (wVar != null) {
            wVar.a(str, hashMap, obj);
        }
    }

    public final void b(String str, HashMap<Object, Object> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(hashMap, "params");
        w wVar = this.t;
        if (wVar != null) {
            wVar.b(str, hashMap, obj);
        }
    }

    public final void a(String str, String str2, HashMap<String, String> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(str2, "body");
        k.c(hashMap, H5Logger.HEADER);
        this.s.a(str, new a(this), str2, hashMap, obj);
    }
}
