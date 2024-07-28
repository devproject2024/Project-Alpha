package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;

public final class ay {

    /* renamed from: a  reason: collision with root package name */
    public static final ay f61523a = new ay();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f61524b;

    private ay() {
    }

    public static final void a(boolean z) {
        f61524b = z;
    }

    public static String a(CJRRechargeCart cJRRechargeCart, Context context) {
        k.c(cJRRechargeCart, "rechargeCart");
        k.c(context, "context");
        CJRCart cart = cJRRechargeCart.getCart();
        k.a((Object) cart, "rechargeCart.cart");
        Iterator<CJRCartProduct> it2 = cart.getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            k.a((Object) next, "cartProduct");
            if (next.getError() != null) {
                if (TextUtils.isEmpty(next.getErrorCode()) || (!p.a("CT_CP_4001", next.getErrorCode(), true) && !p.a("CT_CP_4010", next.getErrorCode(), true))) {
                    String error = next.getError();
                    k.a((Object) error, "cartProduct.error");
                    return error;
                }
                String string = context.getResources().getString(R.string.error_msg_for_deals);
                k.a((Object) string, "context.resources.getStr…ring.error_msg_for_deals)");
                return string;
            }
        }
        CJRCart cart2 = cJRRechargeCart.getCart();
        if ((cart2 != null ? cart2.getError() : null) == null) {
            return "";
        }
        CJRCart cart3 = cJRRechargeCart.getCart();
        k.a((Object) cart3, "rechargeCart.cart");
        String error2 = cart3.getError();
        k.a((Object) error2, "rechargeCart.cart.error");
        return error2;
    }

    public static void a(ERROR_TYPE error_type, ACTION_TYPE action_type, CJRRechargeErrorModel cJRRechargeErrorModel) {
        ERROR_TYPE error_type2 = error_type;
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        k.c(error_type2, "errorType");
        k.c(action_type, "actionType");
        k.c(cJRRechargeErrorModel2, "hawkEyeModel");
        try {
            cJRRechargeErrorModel2.setErrorType(error_type2);
            CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
            }
            flowName.setErrorType(error_type.toString());
            flowName.setActionType(action_type.toString());
            cJRRechargeErrorModel2.setFlowName(flowName);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public static void a(CJRItem cJRItem, VERTICAL vertical) {
        k.c(vertical, "vertical");
        try {
            d dVar = d.f64967a;
            CJRRechargeErrorModel b2 = d.b();
            b2.setCategoryId(cJRItem != null ? cJRItem.getCategoryId() : null);
            b2.setProductId((String) null);
            b2.setUserFacing(a.b.USER_FACING);
            b2.setVerticalName(vertical);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public static void a(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        k.c(str2, "tag");
        if (obj2 instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
            CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
            }
            cJRRechargeErrorModel.setFlowName(flowName);
            CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
            if (flowName2 != null) {
                flowName2.setTag(str2);
            }
        }
    }

    public static void a(int i2) {
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.AUTH);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.AUTH.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setTag(String.valueOf(i2));
        }
        if (f61524b) {
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setActionType(ACTION_TYPE.LOGIN_FAILED_AFTER_AUTH_FAILED.name());
            }
        } else {
            CRUFlowModel flowName4 = a2.getFlowName();
            if (flowName4 != null) {
                flowName4.setActionType(ACTION_TYPE.LOGIN_FAILED.name());
            }
        }
        f61524b = false;
        az azVar = az.f61525a;
        az.a(a2);
    }
}
