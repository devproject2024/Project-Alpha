package net.one97.paytm.deeplink;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderItemProduct;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.common.utility.i;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upgradeKyc.activity.KYCAddNewAddress;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.utility.a;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f50365a = new q();

    private q() {
    }

    public static void a(Context context, DeepLinkData deepLinkData, Bundle bundle) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        b(context, deepLinkData, bundle);
    }

    public static void b(Context context, DeepLinkData deepLinkData, Bundle bundle) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.insurance.InsuranceInitActivity");
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra("EXTRA_DEEP_LINK_BUNDLE", bundle);
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra("EXTRA_DEEP_LINK_BUNDLE", bundle);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.insurance.InsuranceInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
        if (context != null) {
            context.startActivity(intent2);
        }
    }

    public static Intent a(Context context) {
        k.c(context, "context");
        return new Intent(context, KYCAddNewAddress.class);
    }

    public static Dialog a(Activity activity) {
        k.c(activity, "activity");
        Dialog b2 = a.b(activity);
        k.a((Object) b2, "CJRWalletUtility.getWall…eProgressDialog(activity)");
        return b2;
    }

    public static void a(Context context, Intent intent) {
        k.c(intent, "resultIntent");
        if (intent.hasExtra("insurance_paytmfirst_h5_flow")) {
            CJROrderItemProduct cJROrderItemProduct = new CJROrderItemProduct();
            cJROrderItemProduct.setmVerticalLabel(intent.getStringExtra("vertical_label"));
            ArrayList arrayList = new ArrayList();
            CJROrderItems cJROrderItems = new CJROrderItems();
            cJROrderItems.setProduct(cJROrderItemProduct);
            arrayList.add(cJROrderItems);
            CJROrderList cJROrderList = new CJROrderList();
            cJROrderList.setOrderItems(arrayList);
            k.a((Object) intent.putExtra("recharge.os.history.item", cJROrderList), "resultIntent.putExtra(CJ…_HISTORY_ITEM, orderList)");
        } else if (!intent.hasExtra("recharge.os.history.item")) {
            String str = null;
            if (intent.hasExtra("product_name")) {
                str = intent.getStringExtra("product_name").equals("broking") ? "insurance-retail" : "Insurance";
            }
            CJROrderItemProduct cJROrderItemProduct2 = new CJROrderItemProduct();
            cJROrderItemProduct2.setmVerticalLabel(str);
            ArrayList arrayList2 = new ArrayList();
            CJROrderItems cJROrderItems2 = new CJROrderItems();
            cJROrderItems2.setProduct(cJROrderItemProduct2);
            arrayList2.add(cJROrderItems2);
            CJROrderList cJROrderList2 = new CJROrderList();
            cJROrderList2.setOrderItems(arrayList2);
            intent.putExtra("recharge.os.history.item", cJROrderList2);
        }
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            if (context != null) {
                intent.setClassName(context, "net.one97.paytm.dynamic.module.insurance.InsuranceInitActivity");
                intent.putExtra("EXTRA_POST_PAYMENT_FLAG", true);
                context.startActivity(intent);
            }
        } else if (context != null) {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra("EXTRA_POST_PAYMENT_FLAG", true);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.insurance.InsuranceInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
            context.startActivity(intent);
        }
    }

    public static void a(Intent intent, CJRRechargePayment cJRRechargePayment) {
        k.c(intent, "intent");
        k.c(cJRRechargePayment, "rechargePayment");
        ab.a(cJRRechargePayment, intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x011a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(net.one97.paytm.deeplink.DeepLinkData r2) {
        /*
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r2 = r2.f50284b
            if (r2 != 0) goto L_0x000c
            kotlin.g.b.k.a()
        L_0x000c:
            r0 = 0
            int r1 = r2.hashCode()
            switch(r1) {
                case -1960656577: goto L_0x0111;
                case -1957904636: goto L_0x0108;
                case -1905437915: goto L_0x00ff;
                case -1731647246: goto L_0x00f5;
                case -1646056628: goto L_0x00ec;
                case -1615128392: goto L_0x00e3;
                case -1312451303: goto L_0x00da;
                case -951921574: goto L_0x00d1;
                case -740215129: goto L_0x00c8;
                case -604533432: goto L_0x00bf;
                case -297095233: goto L_0x00b6;
                case 29304850: goto L_0x00ac;
                case 31404711: goto L_0x00a2;
                case 104372930: goto L_0x0098;
                case 169523058: goto L_0x008e;
                case 180723048: goto L_0x0084;
                case 906777209: goto L_0x007a;
                case 940264988: goto L_0x0070;
                case 1307450035: goto L_0x0066;
                case 1341505643: goto L_0x005c;
                case 1377553737: goto L_0x0052;
                case 1518141199: goto L_0x0048;
                case 1570606907: goto L_0x003e;
                case 1617835444: goto L_0x0034;
                case 1797816555: goto L_0x002a;
                case 1837314404: goto L_0x0020;
                case 1992578977: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x011b
        L_0x0016:
            java.lang.String r1 = "insurance_buy"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0020:
            java.lang.String r1 = "brokinginsurance"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x002a:
            java.lang.String r1 = "insautopay"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0034:
            java.lang.String r1 = "reviewandbuyh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x003e:
            java.lang.String r1 = "groupinsurance"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0048:
            java.lang.String r1 = "myinsh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0052:
            java.lang.String r1 = "bundle_buy"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x005c:
            java.lang.String r1 = "healthreactins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0066:
            java.lang.String r1 = "fillnbuyins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0070:
            java.lang.String r1 = "fillandbuyins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x007a:
            java.lang.String r1 = "health1ins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0084:
            java.lang.String r1 = "fillnbuyh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x008e:
            java.lang.String r1 = "lifeins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0098:
            java.lang.String r1 = "myins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00a2:
            java.lang.String r1 = "posreviewbuyh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00ac:
            java.lang.String r1 = "healthins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00b6:
            java.lang.String r1 = "lifeinsh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00bf:
            java.lang.String r1 = "cycleins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00c8:
            java.lang.String r1 = "reviewandbuy"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00d1:
            java.lang.String r1 = "posreviewbuy"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00da:
            java.lang.String r1 = "fourwheelerinsh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00e3:
            java.lang.String r1 = "buypayinsurance"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00ec:
            java.lang.String r1 = "fourwheelerins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00f5:
            java.lang.String r1 = "twowheelerins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x00ff:
            java.lang.String r1 = "healthh5ins"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0108:
            java.lang.String r1 = "fillnbuyreact"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
            goto L_0x011a
        L_0x0111:
            java.lang.String r1 = "twowheelerinsh5"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x011b
        L_0x011a:
            r0 = 1
        L_0x011b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.q.a(net.one97.paytm.deeplink.DeepLinkData):boolean");
    }

    public static String b(Context context) {
        k.c(context, "context");
        String b2 = i.a(context.getApplicationContext()).b("aadhaar_number", "", false);
        k.a((Object) b2, "KycSharedPrefs.getAadhaarNumber(context)");
        return b2;
    }
}
