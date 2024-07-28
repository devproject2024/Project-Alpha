package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.o;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61493a = new a();

    private a() {
    }

    private static ArrayList<CJRCartProduct> a(CJRRechargeCart cJRRechargeCart) {
        CJRCart cart;
        if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null) {
            return null;
        }
        return cart.getCartItems();
    }

    private static String b(CJRRechargeCart cJRRechargeCart) {
        CJRCartProduct cJRCartProduct;
        ArrayList<CJRCartProduct> a2 = a(cJRRechargeCart);
        if (a2 == null || (cJRCartProduct = a2.get(0)) == null) {
            return null;
        }
        return cJRCartProduct.getVerticalLabel();
    }

    public static void a(Fragment fragment, Activity activity, CJRFrequentOrder cJRFrequentOrder, Bundle bundle) {
        Context context;
        String str;
        String str2;
        String str3;
        k.c(cJRFrequentOrder, "recent");
        if (fragment == null || (context = fragment.getContext()) == null) {
            context = activity;
        }
        CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
        if (context != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", b.n(context));
                Map map = hashMap;
                if (frequentOrderProduct == null || (str3 = frequentOrderProduct.getService()) == null) {
                    str3 = "";
                }
                map.put("recharge_utilities_service_type", str3);
                Map map2 = hashMap;
                Object obj = hashMap.get("recharge_utilities_service_type");
                if (obj == null) {
                    obj = "";
                }
                map2.put("service_type", obj);
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.a("automatic_payment_summary_screen_automatic_clicked", (HashMap<String, Object>) hashMap, context);
            } catch (Throwable unused) {
            }
            Intent intent = new Intent(context, AJRAutomaticSetupActivity.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("selected_recent", cJRFrequentOrder);
            if (frequentOrderProduct == null || (str = frequentOrderProduct.getService()) == null) {
                str = "";
            }
            intent.putExtra("service_type", str);
            intent.putExtra("from", "from_utility");
            StringBuilder sb = new StringBuilder();
            k.a((Object) frequentOrderProduct, "product");
            String service = frequentOrderProduct.getService();
            String str4 = null;
            if (service == null) {
                str2 = null;
            } else if (service != null) {
                str2 = service.toLowerCase();
                k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            sb.append(str2);
            sb.append("_");
            String paytype = frequentOrderProduct.getPaytype();
            if (paytype != null) {
                if (paytype != null) {
                    str4 = paytype.toLowerCase();
                    k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            sb.append(str4);
            intent.putExtra("service_paytype", sb.toString());
            boolean z = false;
            if (cJRFrequentOrder.getFrequentOrderProduct() != null) {
                CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
                k.a((Object) frequentOrderProduct2, "recent.frequentOrderProduct");
                if (frequentOrderProduct2.getAttributes() != null) {
                    CJRFrequentOrderProduct frequentOrderProduct3 = cJRFrequentOrder.getFrequentOrderProduct();
                    k.a((Object) frequentOrderProduct3, "recent.frequentOrderProduct");
                    if (frequentOrderProduct3.getAttributes().containsKey("is_bank_mandate_enabled")) {
                        CJRFrequentOrderProduct frequentOrderProduct4 = cJRFrequentOrder.getFrequentOrderProduct();
                        k.a((Object) frequentOrderProduct4, "recent.frequentOrderProduct");
                        z = p.a("1", frequentOrderProduct4.getAttributes().get("is_bank_mandate_enabled"), true);
                    }
                }
            }
            intent.putExtra("is_bank_mandate_enabled", z);
            if (fragment != null) {
                fragment.startActivityForResult(intent, 203);
            } else if (activity != null) {
                activity.startActivityForResult(intent, 203);
            }
        }
    }

    public static void a(Fragment fragment, FragmentActivity fragmentActivity, CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, Bundle bundle) {
        Context context;
        String str;
        k.c(cJRFrequentOrder, "recent");
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        if (fragment == null || (context = fragment.getContext()) == null) {
            context = fragmentActivity;
        }
        if (context != null) {
            Intent intent = new Intent(context, AJRAutomaticSubscriptionManageActivity.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
            intent.putExtra("selected_automatic_subscribed_item", cJRAutomaticSubscriptionItemModel);
            intent.putExtra("selected_recent", cJRFrequentOrder);
            StringBuilder sb = new StringBuilder();
            k.a((Object) frequentOrderProduct, "product");
            String service = frequentOrderProduct.getService();
            String str2 = null;
            if (service == null) {
                str = null;
            } else if (service != null) {
                str = service.toLowerCase();
                k.a((Object) str, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            sb.append(str);
            sb.append("_");
            String paytype = frequentOrderProduct.getPaytype();
            if (paytype != null) {
                if (paytype != null) {
                    str2 = paytype.toLowerCase();
                    k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            sb.append(str2);
            intent.putExtra("service_paytype", sb.toString());
            if (fragment != null) {
                fragment.startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE);
            } else if (fragmentActivity != null) {
                fragmentActivity.startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE);
            }
        }
    }

    public static void a(Activity activity, CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, Map<String, ? extends Object> map, Object obj) {
        ArrayList<CJRCartProduct> a2;
        CJRCartProduct cJRCartProduct;
        k.c(activity, "activity");
        if (cJRRechargePayment != null && cJRRechargeCart != null && cJRRechargePayment.getOrderId() != null) {
            Context context = activity;
            k.c(activity, "activity");
            Class<? extends Activity> a3 = ba.a(context, ba.b.ORDER_SUMMARY, cJRRechargeCart);
            if (a3 == null) {
                net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                a3 = net.one97.paytm.recharge.di.helper.a.a();
            }
            Intent intent = new Intent(context, a3);
            ba.a(intent, ba.b.ORDER_SUMMARY, cJRRechargeCart, context);
            intent.putExtra(UpiConstants.FROM, "Payment");
            intent.putExtra("order_id", cJRRechargePayment.getOrderId());
            CJRCart cart = cJRRechargeCart.getCart();
            k.a((Object) cart, "rechargeCart.cart");
            intent.putExtra("price", cart.getOrderTotal());
            CJRCart cart2 = cJRRechargeCart.getCart();
            String str = null;
            if (cart2 != null) {
                cart2.setPaymentInstruments((o) null);
            }
            CJRCart cart3 = cJRRechargeCart.getCart();
            if (cart3 != null) {
                cart3.setPaymentInfo((o) null);
            }
            intent.putExtra("recharge cart", cJRRechargeCart);
            intent.putExtra(AppConstants.IS_CANCEL, false);
            ba.a(intent, ba.b.ORDER_SUMMARY, cJRRechargeCart, context);
            if (map != null && !map.isEmpty()) {
                intent.putExtra("recharge_ga_data_for_summary", (Serializable) map);
            }
            activity.startActivity(intent);
            try {
                c cVar = c.f62654a;
                String X = c.X();
                if (a(cJRRechargeCart) != null && (a2 = a(cJRRechargeCart)) != null && (!a2.isEmpty())) {
                    String b2 = b(cJRRechargeCart);
                    ArrayList<CJRCartProduct> a4 = a(cJRRechargeCart);
                    if (!(a4 == null || (cJRCartProduct = a4.get(0)) == null)) {
                        str = cJRCartProduct.getLastItemInCategoryMap();
                    }
                    if (b2 != null) {
                        if (X != null) {
                            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                            net.one97.paytm.recharge.di.helper.b.b(b2, (Context) activity, X, str);
                        }
                    } else if (X != null) {
                        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                        net.one97.paytm.recharge.di.helper.b.b(SDKConstants.GA_KEY_DEFAULT, (Context) activity, X, str);
                    }
                }
            } catch (Throwable unused) {
            }
        } else if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0028, code lost:
        if (r9 == null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[Catch:{ all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[Catch:{ all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0160 A[SYNTHETIC, Splitter:B:91:0x0160] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r6, java.lang.String r7, net.one97.paytm.common.entity.CJRRechargeCart r8, net.one97.paytm.common.entity.recharge.CJRRechargePayment r9, java.util.Map<java.lang.String, ? extends java.lang.Object> r10, java.lang.Class<?> r11, java.lang.Object r12, boolean r13) {
        /*
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r1 = "categoryName"
            kotlin.g.b.k.c(r7, r1)
            com.paytm.utility.b.j()
            if (r8 == 0) goto L_0x002a
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            java.lang.String r2 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getFinalPrice()
            double r1 = net.one97.paytm.recharge.widgets.c.d.c(r1)
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0046
            if (r9 != 0) goto L_0x0046
        L_0x002a:
            boolean r1 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x0046
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r12 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r12
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r12.getFlowName()
            if (r1 == 0) goto L_0x0041
            java.lang.StringBuilder r1 = r1.getJourneyStackTrace()
            if (r1 == 0) goto L_0x0041
            java.lang.String r2 = " - In case of 100% discount Checkout response should not be null"
            r1.append(r2)
        L_0x0041:
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r12)
        L_0x0046:
            r12 = 0
            if (r13 == 0) goto L_0x0061
            if (r8 == 0) goto L_0x0078
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            if (r1 == 0) goto L_0x0078
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r8.getCart()
            if (r2 == 0) goto L_0x005c
            java.lang.String r2 = r2.getGrandTotalExcludingConvFee()
            goto L_0x005d
        L_0x005c:
            r2 = r12
        L_0x005d:
            r1.setOrderTotal(r2)
            goto L_0x0078
        L_0x0061:
            if (r8 == 0) goto L_0x0078
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            if (r1 == 0) goto L_0x0078
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r8.getCart()
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r2.getFinalPrice()
            goto L_0x0075
        L_0x0074:
            r2 = r12
        L_0x0075:
            r1.setOrderTotal(r2)
        L_0x0078:
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d
            r2 = r6
            android.content.Context r2 = (android.content.Context) r2
            r1.<init>(r2)
            net.one97.paytm.recharge.di.helper.b r3 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0098 }
            if (r8 == 0) goto L_0x008f
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r8.getCart()     // Catch:{ all -> 0x0098 }
            if (r3 == 0) goto L_0x008f
            java.util.ArrayList r3 = r3.getCartItems()     // Catch:{ all -> 0x0098 }
            goto L_0x0090
        L_0x008f:
            r3 = r12
        L_0x0090:
            android.content.Context r1 = r1.f64344b     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "Recharge/Electricity"
            net.one97.paytm.recharge.di.helper.b.a((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRCartProduct>) r3, (android.content.Context) r1, (java.lang.String) r4)     // Catch:{ all -> 0x0098 }
            goto L_0x0099
        L_0x0098:
        L_0x0099:
            if (r8 == 0) goto L_0x00a4
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            if (r1 == 0) goto L_0x00a4
            r1.setPaymentInstruments(r12)
        L_0x00a4:
            android.content.Intent r1 = new android.content.Intent
            if (r11 != 0) goto L_0x00b9
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.recharge.common.utils.ba$b r11 = net.one97.paytm.recharge.common.utils.ba.b.RECHARGE_PAYMENT
            java.lang.Class r11 = net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r2, (net.one97.paytm.recharge.common.utils.ba.b) r11, (net.one97.paytm.common.entity.CJRRechargeCart) r8)
            if (r11 != 0) goto L_0x00b9
            net.one97.paytm.recharge.di.helper.a r11 = net.one97.paytm.recharge.di.helper.a.f62650a
            java.lang.Class r11 = net.one97.paytm.recharge.di.helper.a.e()
        L_0x00b9:
            r1.<init>(r2, r11)
            r11 = 0
            r0 = 1
            if (r9 == 0) goto L_0x00c4
            net.one97.paytm.recharge.common.utils.ab.a((net.one97.paytm.common.entity.recharge.CJRRechargePayment) r9, (android.content.Intent) r1)
            goto L_0x00ee
        L_0x00c4:
            if (r8 == 0) goto L_0x00e2
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r8.getCart()
            if (r3 == 0) goto L_0x00e2
            com.google.gsonhtcfix.o r3 = r3.getPaymentInfo()
            if (r3 == 0) goto L_0x00e2
            java.lang.String r4 = "native_withdraw"
            com.google.gsonhtcfix.l r3 = r3.b(r4)
            if (r3 == 0) goto L_0x00e2
            int r3 = r3.e()
            if (r3 != r0) goto L_0x00e2
            r3 = 1
            goto L_0x00e3
        L_0x00e2:
            r3 = 0
        L_0x00e3:
            java.lang.String r4 = "nativeSdkEnabled"
            android.content.Intent r3 = r1.putExtra(r4, r3)
            java.lang.String r4 = "intent.putExtra(CJRCommo…E_WITHDRAWL)?.asInt == 1)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
        L_0x00ee:
            if (r8 == 0) goto L_0x0109
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r8.getCart()
            if (r3 == 0) goto L_0x0109
            com.google.gsonhtcfix.o r3 = r3.getPaymentInfo()
            if (r3 == 0) goto L_0x0109
            java.lang.String r4 = "mid"
            com.google.gsonhtcfix.l r3 = r3.b(r4)
            if (r3 == 0) goto L_0x0109
            java.lang.String r3 = r3.b()
            goto L_0x010a
        L_0x0109:
            r3 = r12
        L_0x010a:
            java.lang.String r4 = "merchant_id"
            r1.putExtra(r4, r3)
            if (r8 == 0) goto L_0x011a
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r8.getCart()
            if (r3 == 0) goto L_0x011a
            r3.setPaymentInfo(r12)
        L_0x011a:
            net.one97.paytm.recharge.common.utils.y r3 = net.one97.paytm.recharge.common.utils.y.f61814b
            org.json.JSONObject r3 = net.one97.paytm.recharge.common.utils.y.g()
            net.one97.paytm.recharge.common.utils.ba$b r4 = net.one97.paytm.recharge.common.utils.ba.b.ORDER_SUMMARY
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Intent) r1, (net.one97.paytm.recharge.common.utils.ba.b) r4, (net.one97.paytm.common.entity.CJRRechargeCart) r8, (android.content.Context) r2)
            if (r3 == 0) goto L_0x0130
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "verify"
            r1.putExtra(r4, r3)
        L_0x0130:
            if (r9 == 0) goto L_0x0139
            java.io.Serializable r9 = (java.io.Serializable) r9
            java.lang.String r3 = "Recharge_Payment_info"
            r1.putExtra(r3, r9)
        L_0x0139:
            if (r8 == 0) goto L_0x0143
            r9 = r8
            java.io.Serializable r9 = (java.io.Serializable) r9
            java.lang.String r3 = "recharge cart"
            r1.putExtra(r3, r9)
        L_0x0143:
            java.lang.String r9 = "IS_FROM_NEW_SCREEN"
            r1.putExtra(r9, r11)
            java.lang.String r9 = "started_activity_from_recharge"
            r1.putExtra(r9, r0)
            java.lang.String r9 = "vertical_name"
            r1.putExtra(r9, r7)
            if (r13 == 0) goto L_0x0159
            java.lang.String r7 = "isBankOffer"
            r1.putExtra(r7, r0)
        L_0x0159:
            net.one97.paytm.recharge.common.utils.ba$b r7 = net.one97.paytm.recharge.common.utils.ba.b.RECHARGE_PAYMENT
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Intent) r1, (net.one97.paytm.recharge.common.utils.ba.b) r7, (net.one97.paytm.common.entity.CJRRechargeCart) r8, (android.content.Context) r2)
            if (r8 == 0) goto L_0x01b9
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r8.getCart()     // Catch:{ Exception -> 0x01b1 }
            if (r7 == 0) goto L_0x01b9
            java.util.ArrayList r7 = r7.getCartItems()     // Catch:{ Exception -> 0x01b1 }
            if (r7 == 0) goto L_0x01b9
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x01b1 }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x01b1 }
            r7 = r7 ^ r0
            if (r7 != r0) goto L_0x01b9
            java.lang.String r7 = b(r8)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.common.entity.shopping.CJRCart r9 = r8.getCart()     // Catch:{ Exception -> 0x01b1 }
            if (r9 == 0) goto L_0x0184
            java.util.ArrayList r9 = r9.getCartItems()     // Catch:{ Exception -> 0x01b1 }
            goto L_0x0185
        L_0x0184:
            r9 = r12
        L_0x0185:
            if (r9 != 0) goto L_0x018a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01b1 }
        L_0x018a:
            java.lang.Object r9 = r9.get(r11)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r11 = "rechargeCart.cart?.cartItems!![0]"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r9 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r9     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = r9.getLastItemInCategoryMap()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r11 = "From"
            if (r7 == 0) goto L_0x01a1
            r1.putExtra(r11, r7)     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01a6
        L_0x01a1:
            java.lang.String r13 = "Default"
            r1.putExtra(r11, r13)     // Catch:{ Exception -> 0x01b1 }
        L_0x01a6:
            java.lang.String r11 = "verticalLabel"
            r1.putExtra(r11, r7)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = "vertical_id"
            r1.putExtra(r7, r9)     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r7 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r9 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r9.debugLogExceptions(r7)
        L_0x01b9:
            if (r8 == 0) goto L_0x01c5
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r8.getCart()
            if (r7 == 0) goto L_0x01c5
            java.lang.String r12 = r7.getOrderTotal()
        L_0x01c5:
            java.lang.String r7 = "price"
            r1.putExtra(r7, r12)
            if (r10 == 0) goto L_0x01d9
            boolean r7 = r10.isEmpty()
            if (r7 != 0) goto L_0x01d9
            java.io.Serializable r10 = (java.io.Serializable) r10
            java.lang.String r7 = "recharge_ga_data_for_summary"
            r1.putExtra(r7, r10)
        L_0x01d9:
            r6.startActivity(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.a.a(android.app.Activity, java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart, net.one97.paytm.common.entity.recharge.CJRRechargePayment, java.util.Map, java.lang.Class, java.lang.Object, boolean):void");
    }

    public static /* synthetic */ void a(Activity activity, String str, CJRRechargeCart cJRRechargeCart, Class cls, Boolean bool, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool2, Boolean bool3, int i2) {
        int i3 = i2;
        a(activity, str, cJRRechargeCart, (i3 & 8) != 0 ? null : cls, (i3 & 16) != 0 ? Boolean.FALSE : bool, (i3 & 32) != 0 ? null : str2, (String) null, (i3 & 128) != 0 ? null : str3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? null : str4, (i3 & 512) != 0 ? null : str5, (i3 & TarConstants.EOF_BLOCK) != 0 ? null : str6, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? null : str7, (JSONObject) null, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str8, (i3 & 16384) != 0 ? null : bool2, (i3 & 32768) != 0 ? Boolean.FALSE : bool3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014c A[SYNTHETIC, Splitter:B:59:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0173 A[Catch:{ Exception -> 0x016f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r14, java.lang.String r15, net.one97.paytm.common.entity.CJRRechargeCart r16, java.lang.Class<?> r17, java.lang.Boolean r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, org.json.JSONObject r26, java.lang.String r27, java.lang.Boolean r28, java.lang.Boolean r29) {
        /*
            r1 = r14
            r0 = r15
            r2 = r16
            r3 = r20
            r4 = r25
            r5 = r27
            java.lang.String r6 = "activity"
            kotlin.g.b.k.c(r14, r6)
            java.lang.String r7 = "categoryWiseVerticalName"
            kotlin.g.b.k.c(r15, r7)
            java.lang.String r7 = "mid"
            java.lang.String r8 = "rechargeCart.cart"
            r9 = 0
            if (r2 == 0) goto L_0x0055
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r16.getCart()
            if (r10 == 0) goto L_0x0055
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r16.getCart()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
            com.google.gsonhtcfix.o r10 = r10.getPaymentInfo()
            if (r10 == 0) goto L_0x0055
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r16.getCart()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
            com.google.gsonhtcfix.o r10 = r10.getPaymentInfo()
            boolean r10 = r10.a(r7)
            if (r10 == 0) goto L_0x0055
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r16.getCart()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
            com.google.gsonhtcfix.o r10 = r10.getPaymentInfo()
            com.google.gsonhtcfix.l r10 = r10.b(r7)
            if (r10 == 0) goto L_0x0055
            java.lang.String r10 = r10.b()
            goto L_0x0056
        L_0x0055:
            r10 = r9
        L_0x0056:
            if (r2 == 0) goto L_0x0061
            net.one97.paytm.common.entity.shopping.CJRCart r11 = r16.getCart()
            if (r11 == 0) goto L_0x0061
            r11.setPaymentInstruments(r9)
        L_0x0061:
            if (r2 == 0) goto L_0x006c
            net.one97.paytm.common.entity.shopping.CJRCart r11 = r16.getCart()
            if (r11 == 0) goto L_0x006c
            r11.setPaymentInfo(r9)
        L_0x006c:
            android.content.Intent r11 = new android.content.Intent
            r12 = r1
            android.content.Context r12 = (android.content.Context) r12
            if (r17 != 0) goto L_0x0081
            kotlin.g.b.k.c(r14, r6)
            net.one97.paytm.recharge.common.utils.ba$b r6 = net.one97.paytm.recharge.common.utils.ba.b.COUPONS
            java.lang.Class r6 = net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r12, (net.one97.paytm.recharge.common.utils.ba.b) r6, (net.one97.paytm.common.entity.CJRRechargeCart) r2)
            if (r6 != 0) goto L_0x0083
            java.lang.Class<net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8> r6 = net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.class
            goto L_0x0083
        L_0x0081:
            r6 = r17
        L_0x0083:
            r11.<init>(r12, r6)
            net.one97.paytm.recharge.common.utils.ba$b r6 = net.one97.paytm.recharge.common.utils.ba.b.COUPONS
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Intent) r11, (net.one97.paytm.recharge.common.utils.ba.b) r6, (net.one97.paytm.common.entity.CJRRechargeCart) r2, (android.content.Context) r12)
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = "post_order_view_type"
            r11.putExtra(r6, r3)
        L_0x0099:
            r3 = r2
            java.io.Serializable r3 = (java.io.Serializable) r3
            java.lang.String r6 = "recharge cart"
            r11.putExtra(r6, r3)
            r3 = 1
            java.lang.String r6 = "key_show_insurance"
            r11.putExtra(r6, r3)
            java.lang.String r6 = "insurance_url"
            r12 = r19
            r11.putExtra(r6, r12)
            java.lang.String r6 = "gtm_category"
            java.lang.String r12 = "Recharge/Electricity"
            r11.putExtra(r6, r12)
            java.lang.String r12 = "category_name"
            r13 = r21
            r11.putExtra(r12, r13)
            r12 = r18
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r13 = "dealsFastForward"
            r11.putExtra(r13, r12)
            java.lang.String r12 = com.paytm.utility.e.C
            r11.putExtra(r12, r3)
            java.lang.String r12 = "recharge_utilities_service_type"
            r13 = r22
            r11.putExtra(r12, r13)
            r12 = r29
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r13 = "is_applink_transaction"
            r11.putExtra(r13, r12)
            java.lang.String r12 = "payment_method"
            r13 = r23
            r11.putExtra(r12, r13)
            java.lang.String r12 = "bbps_logo_url"
            r13 = r24
            r11.putExtra(r12, r13)
            r11.putExtra(r7, r10)
            java.lang.String r7 = "vertical_name"
            r11.putExtra(r7, r15)
            if (r28 == 0) goto L_0x00fb
            boolean r0 = r28.booleanValue()
            java.lang.String r7 = "Add_to_paytm_cash"
            r11.putExtra(r7, r0)
        L_0x00fb:
            java.lang.String r0 = "vertical_id"
            if (r5 == 0) goto L_0x0102
            r11.putExtra(r0, r5)
        L_0x0102:
            r5 = 0
            if (r2 == 0) goto L_0x0131
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r16.getCart()
            if (r7 == 0) goto L_0x0131
            java.util.ArrayList r7 = r7.getCartItems()
            if (r7 == 0) goto L_0x0131
            int r10 = r7.size()
            if (r10 <= 0) goto L_0x0119
            r10 = 1
            goto L_0x011a
        L_0x0119:
            r10 = 0
        L_0x011a:
            if (r10 == 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r7 = r9
        L_0x011e:
            if (r7 == 0) goto L_0x0131
            java.lang.Object r7 = r7.get(r5)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r7
            if (r7 == 0) goto L_0x0131
            java.lang.String r7 = r7.getCategoryPathForGTM()
            if (r7 == 0) goto L_0x0131
            r11.putExtra(r6, r7)
        L_0x0131:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013f
            java.lang.String r6 = "intent_promo_code "
            r11.putExtra(r6, r4)
        L_0x013f:
            if (r26 == 0) goto L_0x014a
            java.lang.String r4 = r26.toString()
            java.lang.String r6 = "meta_data"
            r11.putExtra(r6, r4)
        L_0x014a:
            if (r2 == 0) goto L_0x0171
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r16.getCart()     // Catch:{ Exception -> 0x016f }
            if (r4 == 0) goto L_0x0171
            java.util.ArrayList r4 = r4.getCartItems()     // Catch:{ Exception -> 0x016f }
            if (r4 == 0) goto L_0x0171
            int r4 = r4.size()     // Catch:{ Exception -> 0x016f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x016f }
            r6 = r4
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ Exception -> 0x016f }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x016f }
            if (r6 <= 0) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            r3 = 0
        L_0x016b:
            if (r3 == 0) goto L_0x0171
            r9 = r4
            goto L_0x0171
        L_0x016f:
            r0 = move-exception
            goto L_0x0191
        L_0x0171:
            if (r9 == 0) goto L_0x0198
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r16.getCart()     // Catch:{ Exception -> 0x016f }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x016f }
            java.util.ArrayList r2 = r2.getCartItems()     // Catch:{ Exception -> 0x016f }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception -> 0x016f }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2     // Catch:{ Exception -> 0x016f }
            java.lang.String r3 = "item"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x016f }
            java.lang.String r2 = r2.getLastItemInCategoryMap()     // Catch:{ Exception -> 0x016f }
            r11.putExtra(r0, r2)     // Catch:{ Exception -> 0x016f }
            goto L_0x0198
        L_0x0191:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x0198:
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r11.setFlags(r0)
            r14.startActivity(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.a.a(android.app.Activity, java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart, java.lang.Class, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject, java.lang.String, java.lang.Boolean, java.lang.Boolean):void");
    }
}
