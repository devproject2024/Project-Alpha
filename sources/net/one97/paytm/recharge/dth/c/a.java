package net.one97.paytm.recharge.dth.c;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.k.e;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.common.entity.shopping.CJRServiceOptions;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.h.g;
import net.one97.paytm.recharge.common.utils.be;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRMetaInfo;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.ordersummary.h.d;
import org.json.JSONObject;

public final class a extends g {
    public CJRCategoryData O;
    public CJRSelectedGroupItem P;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CJRItem cJRItem, c cVar, w wVar, e<x> eVar, d dVar) {
        super(cJRItem, cVar, wVar, eVar, dVar);
        k.c(cJRItem, "rechargeItem");
        k.c(cVar, "rechargeRepo");
        k.c(wVar, "rechargeProceedHelper");
        k.c(eVar, "errorHandler");
        k.c(dVar, "gtmEventHelper");
    }

    public final void b(e<x> eVar) {
        k.c(eVar, "errorHandler");
        a(eVar);
        w wVar = this.t;
        if (wVar != null) {
            wVar.f61788h = eVar;
        }
    }

    public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        CJRCategoryData cJRCategoryData = (CJRCategoryData) iJRPaytmDataModel;
        CJRMetaInfo metaInfo = cJRCategoryData.getMetaInfo();
        this.F = metaInfo != null ? metaInfo.getTrackingId() : null;
        this.f61409b.setCategoryData(this.A, cJRCategoryData);
        this.x.postValue(new Data(DataState.SUCCESS, cJRCategoryData, (String) null));
    }

    public final void a(CJRInstruct cJRInstruct) {
        k.c(cJRInstruct, "cjrInstruct");
        if (cJRInstruct instanceof CJRInstruct.errorInFetchAmountField) {
            this.f61408a.setValue(new CJRInstruct.errorInFetchAmountField());
        } else {
            super.a(cJRInstruct);
        }
    }

    /* renamed from: net.one97.paytm.recharge.dth.c.a$a  reason: collision with other inner class name */
    public static final class C1216a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62749a;

        C1216a(a aVar) {
            this.f62749a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String str2;
            k.c(str, "tag");
            this.f62749a.f61408a.setValue(new CJRInstruct.errorInFetchAmountField());
            this.f62749a.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            be<CJRInstruct> beVar = this.f62749a.f61408a;
            if (networkCustomError == null || (str2 = networkCustomError.getMessage()) == null) {
                str2 = "";
            }
            beVar.setValue(new CJRInstruct.sendBillFetchFailEvent(str2));
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            ArrayList<CJRCartProduct> cartItems;
            CJRServiceOptions serviceOptions;
            ArrayList<CJRServiceActions> actions;
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                CJRCart cart = cJRRechargeCart.getCart();
                if (!(cart == null || (cartItems = cart.getCartItems()) == null)) {
                    Collection collection = cartItems;
                    boolean z = true;
                    if (!(collection == null || collection.isEmpty())) {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRCart cart2 = cJRRechargeCart.getCart();
                        String str2 = null;
                        ArrayList<CJRCartProduct> cartItems2 = cart2 != null ? cart2.getCartItems() : null;
                        if (cartItems2 == null) {
                            k.a();
                        }
                        CJRCartProduct cJRCartProduct = cartItems2.get(0);
                        CJRServiceActions a2 = net.one97.paytm.recharge.widgets.c.d.a(cJRCartProduct != null ? cJRCartProduct.getServiceOptions() : null);
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        if (net.one97.paytm.recharge.di.helper.c.bz()) {
                            CJRCart cart3 = cJRRechargeCart.getCart();
                            k.a((Object) cart3, "it.cart");
                            CJRCartProduct cJRCartProduct2 = cart3.getCartItems().get(0);
                            if (!(cJRCartProduct2 == null || (serviceOptions = cJRCartProduct2.getServiceOptions()) == null || (actions = serviceOptions.getActions()) == null)) {
                                Collection collection2 = actions;
                                if (collection2 != null && !collection2.isEmpty()) {
                                    z = false;
                                }
                                if (!z) {
                                    CJRCart cart4 = cJRRechargeCart.getCart();
                                    k.a((Object) cart4, "it.cart");
                                    CJRCartProduct cJRCartProduct3 = cart4.getCartItems().get(0);
                                    k.a((Object) cJRCartProduct3, "it.cart.cartItems[0]");
                                    CJRServiceOptions serviceOptions2 = cJRCartProduct3.getServiceOptions();
                                    k.a((Object) serviceOptions2, "it.cart.cartItems[0].serviceOptions");
                                    CJRServiceActions cJRServiceActions = serviceOptions2.getActions().get(0);
                                    k.a((Object) cJRServiceActions, "it.cart.cartItems[0].serviceOptions.actions[0]");
                                    if (net.one97.paytm.recharge.common.utils.g.c(cJRServiceActions.getBillAmount())) {
                                        CJRCart cart5 = cJRRechargeCart.getCart();
                                        k.a((Object) cart5, "it.cart");
                                        CJRCartProduct cJRCartProduct4 = cart5.getCartItems().get(0);
                                        k.a((Object) cJRCartProduct4, "it.cart.cartItems[0]");
                                        CJRServiceOptions serviceOptions3 = cJRCartProduct4.getServiceOptions();
                                        k.a((Object) serviceOptions3, "it.cart.cartItems[0].serviceOptions");
                                        a2 = serviceOptions3.getActions().get(0);
                                    }
                                }
                            }
                            a2 = null;
                        }
                        if (a2 != null) {
                            str2 = a2.getBillAmount();
                        }
                        if (net.one97.paytm.recharge.common.utils.g.c(str2)) {
                            be<CJRInstruct> beVar = this.f62749a.f61408a;
                            if (a2 == null) {
                                k.a();
                            }
                            String billAmount = a2.getBillAmount();
                            k.a((Object) billAmount, "customerInfoServiceAction!!.billAmount");
                            beVar.setValue(new CJRInstruct.updateAmountField(billAmount, cJRRechargeCart));
                        }
                        this.f62749a.f61408a.setValue(new CJRInstruct.sendBillFetchSuccessfullEvent("bill due"));
                        return;
                    }
                }
                this.f62749a.f61408a.setValue(new CJRInstruct.sendBillFetchFailEvent(""));
                return;
            }
            this.f62749a.f61408a.setValue(new CJRInstruct.sendBillFetchFailEvent(""));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getGAEventCategory();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b() {
        /*
            r1 = this;
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r1.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getGAEventCategory()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.c.a.b():java.lang.Object");
    }

    public final void d(String str, Object obj) {
        String str2;
        k.c(str, "tag");
        if (this.m.containsKey(CLPConstants.PRODUCT_ID) && (str2 = this.m.get(CLPConstants.PRODUCT_ID)) != null) {
            k.a((Object) str2, "it");
            d(str, str2, obj);
        }
    }

    public final void c(String str, Object obj) {
        k.c(str, "tag");
        if (this.f61409b.getCategoryData() != null) {
            this.f61408a.setValue(new CJRInstruct.updateProductResponseOnDTH());
        } else {
            b(str, obj);
        }
    }

    public final void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, Object obj) {
        String str2;
        k.c(str, "tag");
        k.c(map, "productIdAmountMap");
        k.c(jSONObject, "metaData");
        w wVar = this.t;
        if (wVar != null) {
            ai aVar = new C1216a(this);
            CJRCategoryData categoryData = this.f61409b.getCategoryData();
            if (categoryData == null || (str2 = categoryData.getDisplayName()) == null) {
                str2 = "";
            }
            wVar.a(str, map, map2, jSONObject, aVar, str2, this.A, obj);
        }
    }

    public final void a(Context context, String str, JSONObject jSONObject, ai aiVar, Object obj) {
        k.c(context, "context");
        k.c(str, "tag");
        k.c(jSONObject, "jsonCart");
        k.c(aiVar, "removePromoListener");
        c cVar = this.s;
        String simpleName = context.getClass().getSimpleName();
        k.a((Object) simpleName, "context.javaClass.simpleName");
        cVar.a(str, aiVar, jSONObject, simpleName, a.b.USER_FACING, obj, 0, true);
    }
}
