package net.one97.paytm.recharge.automatic.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.c.a.a;
import net.one97.paytm.recharge.automatic.c.a.b;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.widgets.c.d;

public final class c {
    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static List<CJRFrequentOrder> a(List<CJRFrequentOrder> list, List<CJRAutomaticSubscriptionItemModel> list2, Context context) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) it2.next();
            if (!cJRFrequentOrder.getFrequentOrderProduct().isSchedulable() || a(list2, cJRFrequentOrder)) {
                it2.remove();
                a(context, list2, cJRFrequentOrder);
                cJRFrequentOrder.getProductAttributes().put("isApplicable", Boolean.FALSE.toString());
            } else {
                cJRFrequentOrder.getProductAttributes().put("isApplicable", Boolean.TRUE.toString());
            }
        }
        return arrayList;
    }

    private static boolean a(List<CJRAutomaticSubscriptionItemModel> list, CJRFrequentOrder cJRFrequentOrder) {
        if (list == null) {
            return false;
        }
        for (CJRAutomaticSubscriptionItemModel next : list) {
            if (cJRFrequentOrder.getRechargeNumber().equalsIgnoreCase(next.getRechargeNumber()) && cJRFrequentOrder.getProductID().equalsIgnoreCase(String.valueOf(next.getProductId()))) {
                return true;
            }
        }
        return false;
    }

    public static List<CJRAutomaticSubscriptionItemModel> a(List<CJRFrequentOrder> list, List<CJRAutomaticSubscriptionItemModel> list2, String str) {
        ArrayList arrayList = new ArrayList();
        for (CJRFrequentOrder next : list) {
            Iterator<CJRAutomaticSubscriptionItemModel> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CJRAutomaticSubscriptionItemModel next2 = it2.next();
                if (next2.getProduct().getService().equalsIgnoreCase(str) || (next.getRechargeNumber().equalsIgnoreCase(next2.getRechargeNumber()) && next.getProductID().equalsIgnoreCase(String.valueOf(next2.getProductId())))) {
                    arrayList.add(next2);
                }
            }
            if (arrayList.size() != 0) {
                break;
            }
        }
        return arrayList;
    }

    public static List<CJRAutomaticSubscriptionItemModel> a(List<CJRAutomaticSubscriptionItemModel> list, String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CJRAutomaticSubscriptionItemModel next : list) {
            if (next.getProduct().getService().equalsIgnoreCase(str)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static void a(Context context, List<CJRAutomaticSubscriptionItemModel> list, CJRFrequentOrder cJRFrequentOrder) {
        if (list != null && cJRFrequentOrder != null && context != null && !TextUtils.isEmpty(cJRFrequentOrder.getRechargeNumber()) && !TextUtils.isEmpty(cJRFrequentOrder.getProductID())) {
            for (CJRAutomaticSubscriptionItemModel next : list) {
                if (next != null && cJRFrequentOrder.getRechargeNumber().equalsIgnoreCase(next.getRechargeNumber()) && cJRFrequentOrder.getProductID().equalsIgnoreCase(String.valueOf(next.getProductId()))) {
                    if (!TextUtils.isEmpty(next.getDueAmt()) && !TextUtils.isEmpty(next.getDueDate()) && !TextUtils.isEmpty(next.getPaymentDate())) {
                        d dVar = d.f64967a;
                        if (d.g(next.getDueAmt())) {
                            cJRFrequentOrder.setAutomaticScheduledText(context.getString(R.string.automatic_scheduled_text, new Object[]{next.getDueAmt()}));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void a(Fragment fragment, String str, String str2, CJRRechargePayment cJRRechargePayment, boolean z, String str3, String str4) {
        if (SDKConstants.DEBIT.equalsIgnoreCase(str3)) {
            str3 = SDKConstants.DEBIT;
        } else if (SDKConstants.CREDIT.equalsIgnoreCase(str3)) {
            str3 = SDKConstants.CREDIT;
        }
        String str5 = z ? "1" : "0";
        HashMap<String, String> hashMap = cJRRechargePayment.getmPGParams();
        String str6 = (hashMap == null || hashMap.size() <= 0) ? "" : hashMap.get("tag.get.ppbl.access.token");
        String str7 = cJRRechargePayment.getmTxnToken();
        String mid = cJRRechargePayment.getMID();
        String orderId = cJRRechargePayment.getOrderId();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("mid", mid);
        hashMap2.put("orderId", orderId);
        hashMap2.put("channelId", SDKConstants.WAP);
        hashMap2.put("txnToken", str7);
        hashMap2.put("paymentMode", str3);
        hashMap2.put(CJRPGTransactionRequestUtils.SUBSCRIPTION_ID, str4);
        if (!TextUtils.isEmpty(str6)) {
            hashMap2.put(PayUtility.MPIN, str6);
        } else {
            hashMap2.put(PayUtility.AUTH_MODE, str);
            hashMap2.put(PayUtility.CARD_INFO, str2);
            hashMap2.put(PayUtility.STORE_INSTRUMENT, str5);
            hashMap2.put("requestType", "NATIVE");
        }
        FragmentActivity activity = fragment.getActivity();
        a aVar = a.f60256a;
        Intent intent = new Intent(activity, a.c());
        cJRRechargePayment.setmPGParams(hashMap2);
        b bVar = b.f60258a;
        cJRRechargePayment.setmPGUrlToHit(b.a(cJRRechargePayment.getMID(), cJRRechargePayment.getmOrderId()));
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("price", cJRRechargePayment.getTxnAmount());
        intent.putExtra("orderid", cJRRechargePayment.getOrderId());
        intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
        intent.putExtra("mid", cJRRechargePayment.getmMID());
        intent.putExtra("auto_add_money", true);
        fragment.startActivityForResult(intent, IuserActions.ON_FLASHSALE_CLICK);
    }

    public static void a(Activity activity, int i2, String str, String str2, String str3, String str4, String str5, String str6, CJRRechargePayment cJRRechargePayment, String str7, String str8) {
        Activity activity2 = activity;
        CJRRechargePayment cJRRechargePayment2 = cJRRechargePayment;
        String j = com.paytm.utility.b.j((Context) activity);
        String str9 = cJRRechargePayment.getmTxnToken();
        String mid = cJRRechargePayment.getMID();
        String orderId = cJRRechargePayment.getOrderId();
        HashMap hashMap = new HashMap();
        hashMap.put("mid", mid);
        hashMap.put("orderId", orderId);
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("INDUSTRY_TYPE_ID", SDKConstants.KEY_RETAIL);
        hashMap.put("txnToken", str9);
        hashMap.put("paymentMode", str7);
        hashMap.put(CJRPGTransactionRequestUtils.SUBSCRIPTION_ID, str8);
        hashMap.put("WEBSITE", "retail");
        hashMap.put("ACCOUNT_TYPE", "ISA");
        hashMap.put("AUTH_MODE", "USRPWD");
        hashMap.put(PayUtility.STORE_INSTRUMENT, "0");
        hashMap.put("requestType", "NATIVE");
        String str10 = str;
        hashMap.put(PayUtility.ACCOUNT_NUMBER, str);
        String str11 = str3;
        hashMap.put("USER_NAME", str3);
        String str12 = str5;
        hashMap.put("mandateAuthMode", str5);
        hashMap.put("channelCode", str6);
        hashMap.put("USER_NAME", j);
        String str13 = str2;
        hashMap.put("bankIfsc", str2);
        String str14 = str4;
        hashMap.put(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, str4);
        a aVar = a.f60256a;
        Intent intent = new Intent(activity, a.c());
        cJRRechargePayment2.setmPGParams(hashMap);
        b bVar = b.f60258a;
        cJRRechargePayment2.setmPGUrlToHit(b.a(cJRRechargePayment.getMID(), cJRRechargePayment.getmOrderId()));
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment2);
        intent.putExtra("price", cJRRechargePayment.getTxnAmount());
        intent.putExtra("orderid", cJRRechargePayment.getOrderId());
        intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
        intent.putExtra("mid", cJRRechargePayment.getmMID());
        intent.putExtra("auto_add_money", true);
        int i3 = i2;
        activity.startActivityForResult(intent, i2);
    }
}
