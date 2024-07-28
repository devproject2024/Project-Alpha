package net.one97.paytm.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.analytics.b;
import com.paytm.analytics.models.SignalEvent;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.b.k;
import com.paytm.utility.b;
import com.paytm.utility.f;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.entity.shopping.CJRTrackingInfo;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;
import net.one97.paytm.y;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<HashMap<String, Object>> f50681a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static HandlerThread f50682b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f50683c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f50684d = 8;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f50685e = "vertical_name";

    private a() {
    }

    public static void a() {
        try {
            if (f50682b == null) {
                synchronized (a.class) {
                    if (f50682b == null) {
                        HandlerThread handlerThread = new HandlerThread("GTMHandlerThread");
                        f50682b = handlerThread;
                        handlerThread.start();
                        f50683c = new Handler(f50682b.getLooper());
                    }
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void b() {
        try {
            if (f50683c != null && f50683c.getLooper() != null) {
                f50683c.getLooper().quit();
                f50682b = null;
                f50683c = null;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void a(Map<String, Object> map, Context context) {
        if (map != null) {
            try {
                map.put("Device_Brand", com.paytm.utility.a.e());
                map.put("Device_Name", com.paytm.utility.a.f());
                a(context, map);
                String a2 = a(context);
                if (a2 != null) {
                    map.put("IMEI", Base64.encodeToString(a2.getBytes(), 0));
                }
                String d2 = com.paytm.utility.a.d(context);
                if (d2 != null) {
                    map.put("Custom_Device_ID", Base64.encodeToString(d2.getBytes(), 0));
                }
                if (com.paytm.utility.a.q(context) != null) {
                    if (!TextUtils.isEmpty(com.paytm.utility.a.a(context))) {
                        map.put("Customer_Id", com.paytm.utility.a.a(context));
                    }
                    String b2 = com.paytm.utility.a.b(context);
                    if (b2 != null) {
                        map.put("Contact_Number", Base64.encodeToString(b2.getBytes(), 0));
                    }
                    String c2 = com.paytm.utility.a.c(context);
                    if (c2 != null) {
                        map.put("user_email", Base64.encodeToString(c2.getBytes(), 0));
                    }
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    static String a(Context context) {
        if (context == null) {
            return null;
        }
        context.getSystemService(ContactColumn.PHONE_NUMBER);
        return com.paytm.utility.a.f(context);
    }

    public static HashMap<String, CJRTrackingInfo> a(CJRParcelTrackingInfo cJRParcelTrackingInfo) {
        HashMap<String, CJRTrackingInfo> hashMap = new HashMap<>();
        if (cJRParcelTrackingInfo != null) {
            Iterator<CJRCartProduct> it2 = cJRParcelTrackingInfo.getCartItemsForTrackingInfo().iterator();
            while (it2.hasNext()) {
                CJRCartProduct next = it2.next();
                String productId = next.getProductId();
                if (hashMap.get(productId) == null) {
                    hashMap.put(productId, next.getTrackingInfo());
                }
            }
        }
        return hashMap;
    }

    public static void a(final Context context, final CJROrderSummary cJROrderSummary) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (cJROrderSummary != null) {
                            CJROrderSummaryProductDetail productDetail = cJROrderSummary.getOrderedCartList().get(0).getProductDetail();
                            Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "order_pg_cd", "dimension2", cJROrderSummary.getPaymentMethodForGA());
                            if (productDetail.getProductType().equalsIgnoreCase("Marketplace") && !productDetail.getVertical().equalsIgnoreCase("Tickets") && !productDetail.getVertical().equalsIgnoreCase("Wallet")) {
                                a2.put("dimension3", cJROrderSummary.getShippingAndBillingAddressForGA());
                            }
                            a2.put("app_language", n.a(context, n.a()));
                            a.b(a2, "order_summary");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    private static Map<String, Object> b(CJRGridProduct cJRGridProduct, String str, String str2, int i2, String str3) {
        if (!(cJRGridProduct == null || cJRGridProduct.getSource() == null || cJRGridProduct.getSource().isEmpty())) {
            str = str + "/" + cJRGridProduct.getSource();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", cJRGridProduct.getProductID());
        hashMap.put("name", cJRGridProduct.getName());
        hashMap.put("list", str);
        hashMap.put("category", str2);
        hashMap.put(CLPConstants.BRAND_PARAMS, cJRGridProduct.getBrand());
        hashMap.put("price", String.valueOf(cJRGridProduct.getDiscountedPrice()));
        hashMap.put("quantity", 1);
        hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, String.valueOf(i2));
        hashMap.put("dimension24", str);
        hashMap.put("dimension25", String.valueOf(i2));
        hashMap.put("dimension43", cJRGridProduct.getAncestorID());
        hashMap.put("dimension41", "");
        hashMap.put("dimension40", str3);
        try {
            hashMap.put("dimension31", cJRGridProduct.getParentID());
            hashMap.put("dimension38", cJRGridProduct.getListId());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return hashMap;
    }

    static Map<String, Object> a(HashMap<String, Object> hashMap, CJRHomePageItem cJRHomePageItem, String str, int i2, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (hashMap != null) {
            str7 = (String) hashMap.get("search_type");
            str6 = (String) hashMap.get("search_category");
            str5 = (String) hashMap.get("search_term");
            str4 = (String) hashMap.get("search_result_type");
        } else {
            str4 = null;
            str6 = null;
            str5 = null;
        }
        HashMap hashMap2 = new HashMap();
        if (!TextUtils.isEmpty(cJRHomePageItem.getmContainerInstanceID())) {
            hashMap2.put("dimension40", cJRHomePageItem.getmContainerInstanceID());
        }
        hashMap2.put("id", cJRHomePageItem.getItemID());
        hashMap2.put("name", cJRHomePageItem.getName());
        hashMap2.put(CLPConstants.BRAND_PARAMS, cJRHomePageItem.getBrand());
        hashMap2.put("price", Float.toString(cJRHomePageItem.getOfferPrice()));
        hashMap2.put("dimension24", str);
        hashMap2.put("dimension25", Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder();
        sb.append(cJRHomePageItem.getWidgetPosition() + 1);
        hashMap2.put("dimension70", sb.toString());
        hashMap2.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
        if (str7 != null) {
            hashMap2.put("dimension26", str7);
        }
        if (str6 != null) {
            hashMap2.put("dimension27", str6);
        }
        if (str5 != null) {
            hashMap2.put("dimension28", str5);
        }
        if (str4 != null) {
            hashMap2.put("dimension29", str4);
        }
        hashMap2.put("dimension31", cJRHomePageItem.getParentId());
        hashMap2.put("dimension38", cJRHomePageItem.getListId());
        if (cJRHomePageItem.getLayoutType() != null) {
            hashMap2.put("dimension67", cJRHomePageItem.getLayoutType());
        }
        if (!str2.isEmpty()) {
            hashMap2.put("dimension39", str2);
        }
        if (!str3.isEmpty()) {
            hashMap2.put("dimension24", str3);
        }
        return hashMap2;
    }

    public static void a(final String str, final String str2, final String str3, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(str2, str3);
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "customEvent", str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(String str, String str2, String str3, String str4, Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, str5, SDKConstants.EVENT_KEY_SCREEN_NAME, str6, str7, str8);
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, str5);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final String str2, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, str, SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
                        a2.put("Customer_Id", a.b(context));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "screen_name");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final Map<String, Object> map, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if ("productClick".endsWith(str)) {
                            map.put("Customer_Id", a.b(context));
                            map.put("app_language", n.a(context, n.a()));
                            a.b(map, "productClick");
                            return;
                        }
                        map.put("Customer_Id", a.b(context));
                        map.put("app_language", n.a(context, n.a()));
                        a.a(map, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static void b(final String str, final Map<String, Object> map, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if ("productClick".endsWith(str)) {
                            map.put("Customer_Id", a.b(context));
                            map.put("app_language", n.a(context, n.a()));
                            a.b(map, "productClick");
                            return;
                        }
                        map.put("Customer_Id", a.b(context));
                        map.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) map, "customEvent", str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final Map<String, Object> map) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        a.b(map, str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Map<String, Object> map) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        a.b(map, "customEvent");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, str);
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
                        a.b(hashMap, str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(String str, String str2, String str3, String str4, Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str5 = str2;
            final String str6 = str3;
            final String str7 = str4;
            final Context context2 = context;
            final String str8 = str;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(str5, str6, SDKConstants.EVENT_KEY_SCREEN_NAME, str7);
                        a2.put("app_language", n.a(context2, n.a()));
                        a.a(a2, "customEvent", str8);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, str);
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    static String a(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + -1) != '-') ? str : str.substring(0, str.length() - 1);
    }

    public static void a(final CJRHomePageItem cJRHomePageItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = "slot" + (i2 + 1);
                        String str2 = str;
                        if (!TextUtils.isEmpty(cJRHomePageItem.getParentItem())) {
                            str2 = str2 + cJRHomePageItem.getParentItem();
                        }
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", cJRHomePageItem.getURL(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", cJRHomePageItem.getmContainerInstanceID(), "id", cJRHomePageItem.getItemID(), "name", str2, "creative", cJRHomePageItem.getName(), CLPConstants.ARGUMENT_KEY_POSITION, str)))));
                        Map<String, Object> sourceInfo = cJRHomePageItem.getSourceInfo();
                        if (sourceInfo != null) {
                            a2.put("promo_container_id", sourceInfo.get("source_container_id"));
                            a2.put("promo_container_instance_id", sourceInfo.get("source_container_instance_id"));
                        }
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final CJRHomePageItem cJRHomePageItem, final Context context, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        String str2 = "";
                        if (str.equalsIgnoreCase("promotionImpression")) {
                            str = "promoView";
                        } else {
                            str = str.equalsIgnoreCase("promotionClick") ? "promoClick" : str2;
                        }
                        Object[] objArr = new Object[12];
                        objArr[0] = AppConstants.NOTIFICATION_DETAILS.EVENT;
                        objArr[1] = str;
                        objArr[2] = SDKConstants.EVENT_KEY_SCREEN_NAME;
                        objArr[3] = "/";
                        objArr[4] = "destinationURL";
                        objArr[5] = cJRHomePageItem.getURL();
                        objArr[6] = "Customer_Id";
                        objArr[7] = a.b(context);
                        objArr[8] = "vertical_name";
                        objArr[9] = str2;
                        objArr[10] = "ecommerce";
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = str;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = "promotions";
                        Object[] objArr4 = new Object[1];
                        Object[] objArr5 = new Object[10];
                        objArr5[0] = "Container Instance ID";
                        if (cJRHomePageItem.getmContainerInstanceID() != null) {
                            str2 = cJRHomePageItem.getmContainerInstanceID();
                        }
                        objArr5[1] = str2;
                        objArr5[2] = "id";
                        objArr5[3] = cJRHomePageItem.getItemID();
                        objArr5[4] = "name";
                        objArr5[5] = "/-interstitial";
                        objArr5[6] = "creative";
                        objArr5[7] = cJRHomePageItem.getName();
                        objArr5[8] = CLPConstants.ARGUMENT_KEY_POSITION;
                        objArr5[9] = "0";
                        objArr4[0] = b.a(objArr5);
                        objArr3[1] = b.b(objArr4);
                        objArr2[1] = b.a(objArr3);
                        objArr[11] = b.a(objArr2);
                        Map<String, Object> a2 = b.a(objArr);
                        Map<String, Object> sourceInfo = cJRHomePageItem.getSourceInfo();
                        if (sourceInfo != null) {
                            a2.put("promo_container_id", sourceInfo.get("source_container_id"));
                            a2.put("promo_container_instance_id", sourceInfo.get("source_container_instance_id"));
                        }
                        a2.put("app_language", n.a(context, n.a()));
                        if (str.equalsIgnoreCase("promotionClick")) {
                            a.b(a2, "promotion_click");
                        } else {
                            a.b(a2, "promotionImpression");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final CJRHomePageItem cJRHomePageItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", cJRHomePageItem.getImageUrl(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", null, "id", cJRHomePageItem.getItemID(), "name", "/-flyout-banner", "creative", r.a(cJRHomePageItem), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, int i2, String str, String str2, String str3, String str4) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable(i2, str, context, str3, str2, str4) {
                private final /* synthetic */ int f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Context f$2;
                private final /* synthetic */ String f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ String f$5;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void run() {
                    a.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i2, String str, Context context, String str2, String str3, String str4) {
        String str5 = str;
        String str6 = "";
        try {
            String str7 = "slot" + (i2 + 1);
            Object[] objArr = new Object[12];
            objArr[0] = AppConstants.NOTIFICATION_DETAILS.EVENT;
            objArr[1] = "promotionClick";
            objArr[2] = SDKConstants.EVENT_KEY_SCREEN_NAME;
            objArr[3] = str5;
            objArr[4] = "destinationURL";
            objArr[5] = str6;
            objArr[6] = "Customer_Id";
            objArr[7] = b(context);
            objArr[8] = "vertical_name";
            objArr[9] = str6;
            objArr[10] = "ecommerce";
            Object[] objArr2 = new Object[2];
            objArr2[0] = "promoClick";
            Object[] objArr3 = new Object[2];
            objArr3[0] = "promotions";
            Object[] objArr4 = new Object[1];
            Object[] objArr5 = new Object[10];
            objArr5[0] = "dimension40";
            objArr5[1] = str6;
            objArr5[2] = "id";
            objArr5[3] = str2;
            objArr5[4] = "name";
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            if (!TextUtils.isEmpty(str3)) {
                str6 = "-".concat(String.valueOf(str3));
            }
            sb.append(str6);
            objArr5[5] = sb.toString();
            objArr5[6] = "creative";
            objArr5[7] = str4;
            objArr5[8] = CLPConstants.ARGUMENT_KEY_POSITION;
            objArr5[9] = str7;
            objArr4[0] = b.a(objArr5);
            objArr3[1] = b.b(objArr4);
            objArr2[1] = b.a(objArr3);
            objArr[11] = b.a(objArr2);
            Map<String, Object> a2 = b.a(objArr);
            a2.put("app_language", n.a(context, n.a()));
            b(a2, "promotion_click");
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void b(Context context, int i2, String str, String str2, String str3, String str4) {
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final String str5 = str;
            final Context context2 = context;
            final String str6 = str4;
            final String str7 = str2;
            final String str8 = str3;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        a.b(b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, str5, "destinationURL", "", "Customer_Id", a.b(context2), "vertical_name", str6, "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", "", "id", str7, "name", "", "creative", str8, CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i3 + 1)))))), "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final CJRItem cJRItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String a2 = v.a(str, "-", "C1");
                        a.a(str);
                        Map<String, Object> a3 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionClick", SDKConstants.EVENT_KEY_SCREEN_NAME, str, "destinationURL", "", "Customer_Id", "", "vertical_name", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("dimension40", "", "id", cJRItem.getItemID(), "name", a2, "creative", cJRItem.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a3.put("app_language", n.a(context, n.a()));
                        a.b(a3, "promotion_click");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final CJRItem cJRItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String a2 = v.a(str, "-", "C1");
                        a.a(str);
                        Map<String, Object> a3 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, str, "destinationURL", "", "Customer_Id", "", "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", "", "id", cJRItem.getItemID(), "name", a2, "creative", cJRItem.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a3.put("app_language", n.a(context, n.a()));
                        a.b(a3, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, str5, "hotels");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str7 = str;
            final String str8 = str2;
            final String str9 = str3;
            final String str10 = str4;
            final Context context2 = context;
            final String str11 = str5;
            final String str12 = str6;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str7)) {
                            hashMap.put("event_category", str7);
                        } else {
                            hashMap.put("event_category", "");
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            hashMap.put("event_action", str8);
                        } else {
                            hashMap.put("event_action", "");
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            hashMap.put("event_label", str9);
                        } else {
                            hashMap.put("event_label", "");
                        }
                        if (!TextUtils.isEmpty(str10)) {
                            hashMap.put("event_value", str10);
                        } else {
                            hashMap.put("event_value", 0);
                        }
                        if (!TextUtils.isEmpty(a.b(context2))) {
                            hashMap.put("user_id", a.b(context2));
                            hashMap.put("Customer_Id", a.b(context2));
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str11);
                        }
                        if (!TextUtils.isEmpty(str12)) {
                            hashMap.put("VERTICAL_NAME".toLowerCase(), str12);
                        }
                        if (str7.equalsIgnoreCase("left_nav")) {
                            c.a();
                            c.a("is_homebannerclick_enabled", false);
                        }
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str9 = str;
            final String str10 = str2;
            final String str11 = str3;
            final String str12 = str4;
            final String str13 = str5;
            final String str14 = str6;
            final Context context2 = context;
            final String str15 = str7;
            final String str16 = str8;
            handler.post(new Runnable() {

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ String f50710g = null;

                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str9)) {
                            hashMap.put("event_category", str9);
                        } else {
                            hashMap.put("event_category", "");
                        }
                        if (!TextUtils.isEmpty(str10)) {
                            hashMap.put("event_action", str10);
                        } else {
                            hashMap.put("event_action", "");
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            hashMap.put("event_label", str11);
                        } else {
                            hashMap.put("event_label", "");
                        }
                        if (!TextUtils.isEmpty(str12)) {
                            hashMap.put("event_label2", str12);
                        } else {
                            hashMap.put("event_label2", "");
                        }
                        if (!TextUtils.isEmpty(str13)) {
                            hashMap.put("event_label3", str13);
                        } else {
                            hashMap.put("event_label3", "");
                        }
                        if (!TextUtils.isEmpty(str14)) {
                            hashMap.put(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, str14);
                        } else {
                            hashMap.put(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, "");
                        }
                        if (!TextUtils.isEmpty(this.f50710g)) {
                            hashMap.put("event_value", this.f50710g);
                        } else {
                            hashMap.put("event_value", 0);
                        }
                        if (!TextUtils.isEmpty(a.b(context2))) {
                            hashMap.put("user_id", a.b(context2));
                            hashMap.put("Customer_Id", a.b(context2));
                        }
                        if (!TextUtils.isEmpty(str15)) {
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str15);
                        }
                        if (!TextUtils.isEmpty(str16)) {
                            hashMap.put("VERTICAL_NAME".toLowerCase(), str16);
                        }
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a(hashMap, "customEvent");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str8 = str;
            final String str9 = str2;
            final String str10 = str3;
            final String str11 = str4;
            final String str12 = str5;
            final Context context2 = context;
            final String str13 = str6;
            final String str14 = str7;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str8)) {
                            hashMap.put("event_category", str8);
                        } else {
                            hashMap.put("event_category", "");
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            hashMap.put("event_action", str9);
                        } else {
                            hashMap.put("event_action", "");
                        }
                        if (!TextUtils.isEmpty(str10)) {
                            hashMap.put("event_label", str10);
                        } else {
                            hashMap.put("event_label", "");
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            hashMap.put("event_label2", str11);
                        } else {
                            hashMap.put("event_label2", "");
                        }
                        if (!TextUtils.isEmpty(str12)) {
                            hashMap.put("event_value", str12);
                        } else {
                            hashMap.put("event_value", 0);
                        }
                        if (!TextUtils.isEmpty(a.b(context2))) {
                            hashMap.put("user_id", a.b(context2));
                            hashMap.put("Customer_Id", a.b(context2));
                        }
                        if (!TextUtils.isEmpty(str13)) {
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str13);
                        }
                        if (!TextUtils.isEmpty(str14)) {
                            hashMap.put("VERTICAL_NAME".toLowerCase(), str14);
                        }
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str7 = str;
            final String str8 = str2;
            final String str9 = str3;
            final String str10 = str4;
            final Context context2 = context;
            final String str11 = str5;
            final String str12 = str6;
            handler.post(new Runnable() {

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ String f50725e = null;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ String f50726f = null;

                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str7)) {
                            hashMap.put("event_category", str7);
                        } else {
                            hashMap.put("event_category", "");
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            hashMap.put("event_action", str8);
                        } else {
                            hashMap.put("event_action", "");
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            hashMap.put(d.cw, str9);
                        } else {
                            hashMap.put(d.cw, "");
                        }
                        if (!TextUtils.isEmpty(str10)) {
                            hashMap.put("event_label", str10);
                        } else {
                            hashMap.put("event_label", "");
                        }
                        if (!TextUtils.isEmpty(this.f50725e)) {
                            hashMap.put("event_label2", this.f50725e);
                        } else {
                            hashMap.put("event_label2", "");
                        }
                        if (!TextUtils.isEmpty(this.f50726f)) {
                            hashMap.put("event_value", this.f50726f);
                        } else {
                            hashMap.put("event_value", 0);
                        }
                        if (!TextUtils.isEmpty(a.b(context2))) {
                            hashMap.put("user_id", a.b(context2));
                            hashMap.put("Customer_Id", a.b(context2));
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str11);
                        }
                        if (!TextUtils.isEmpty(str12)) {
                            hashMap.put("VERTICAL_NAME".toLowerCase(), str12);
                        }
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final HashMap hashMap, final List<HashMap<String, String>> list, final String str, final Activity activity) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen", SDKConstants.EVENT_KEY_SCREEN_NAME, str, "Customer_Id", a.b((Context) activity), "vertical_name", "", "ecommerce", b.a("purchase", b.a("actionField", a.b((HashMap<String, String>) hashMap), "products", b.b(a.a(list)))));
                        a2.put("app_language", n.a(activity.getApplicationContext(), n.a()));
                        a.b(a2, "openScreen");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> b(HashMap<String, String> hashMap) {
        String[] strArr = new String[(hashMap.size() * 2)];
        int i2 = 0;
        for (String next : hashMap.keySet()) {
            strArr[i2] = next;
            int i3 = i2 + 1;
            strArr[i3] = hashMap.get(next);
            i2 = i3 + 1;
        }
        return b.a(strArr);
    }

    public static String b(Context context) {
        return com.paytm.utility.a.q(context) != null ? com.paytm.utility.a.a(context) : "";
    }

    public static void a(String str, String str2, boolean z, String str3, String str4, final Context context, final ArrayList<CJROrderedCart> arrayList, String str5) {
        try {
            final HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            hashMap.put("gdr_chkout_amount", str3);
            hashMap.put("gdr_referrer", str4);
            hashMap.put("app_language", n.a(context, n.a()));
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    b("/summary", str, context);
                }
            } else if (str != null && str.equalsIgnoreCase("Paytm Hotel")) {
                b("hotel_order_summary", "Hotel", context);
                b("screen_loaded_order_summary", (Map<String, Object>) hashMap, context);
                b(hashMap, "screen_loaded_order_summary");
            } else if (str.equalsIgnoreCase("Tickets")) {
                b("/summary", "BusTicket", context);
            } else if (str.equalsIgnoreCase("Flights")) {
                b("/summary", "Flights", context);
                b("flt_ordersmmry_loaded", (Map<String, Object>) hashMap, context);
                b(hashMap, "order_summary_for_flights");
            } else if (str.equalsIgnoreCase("Movie Tickets")) {
                b("/summary", "Movies", context);
            } else if (str.equalsIgnoreCase("Trains")) {
                b("/summary", "Trains", context);
            } else if (str.equalsIgnoreCase("Wallet")) {
                b("/summary", "Wallet", context);
                b("wallet_screen_loaded_summary", (Map<String, Object>) hashMap, context);
                b(hashMap, "order_summary_for_wallets");
            } else if (c(str5, str)) {
                String b2 = b(str5, Long.parseLong(str2), str);
                if (b2 == null || TextUtils.isEmpty(b2)) {
                    b("/summary", "Recharge", context);
                    b("recharge_screen_loaded_summary", (Map<String, Object>) hashMap, context);
                    b(hashMap, "order_summary_for_recharge");
                    return;
                }
                b("/summary", b2, context);
            } else {
                b("/summary", GAUtil.MARKET_PLACE, context);
                b("marketplace_screen_loaded_summary", (Map<String, Object>) hashMap, context);
                b(hashMap, "marketplace_screen_loaded_summary");
                if (f50683c != null) {
                    f50683c.post(new Runnable() {
                        public final void run() {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            String c2 = a.c(context);
                            if (!TextUtils.isEmpty(c2)) {
                                hashMap.put("gdr_user_id", c2);
                            }
                            int i2 = 0;
                            try {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    CJROrderSummaryProductDetail productDetail = ((CJROrderedCart) it2.next()).getProductDetail();
                                    String name = productDetail.getName();
                                    String l = Long.toString(productDetail.getId());
                                    String gAkey = productDetail.getGAkey();
                                    String l2 = Long.toString(productDetail.getCategoryId());
                                    arrayList.add(name);
                                    arrayList3.add(l);
                                    arrayList2.add(gAkey);
                                    arrayList4.add(l2);
                                    i2 += (int) productDetail.getPrice();
                                }
                            } catch (NumberFormatException e2) {
                                if (b.v) {
                                    q.b(e2.getMessage());
                                }
                            }
                            hashMap.put("gdr_prod_name", arrayList);
                            hashMap.put("gdr_prod_id", arrayList3);
                            hashMap.put("gdr_prod_cat_name", arrayList2);
                            hashMap.put("gdr_prod_cat_id", arrayList4);
                            hashMap.put("gdr_total_value", Integer.valueOf(i2));
                            a.b("gdr_marketplace_screen_loaded_summary", (Map<String, Object>) hashMap, context);
                        }
                    });
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(String str, boolean z, Context context, String str2, String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            final boolean z2 = z;
            final String str4 = str;
            final Context context2 = context;
            final String str5 = str2;
            final String str6 = str3;
            handler.post(new Runnable() {
                public final void run() {
                    if (z2) {
                        a.b("/order-detail", str4, context2);
                        a.a("screen_loaded_order_details_" + str4, "/order-detail", context2);
                    } else if (str4.equalsIgnoreCase("Tickets")) {
                        a.b("/order-detail", "BusTicket", context2);
                        a.a("screen_loaded_order_details_bus", "/order-detail", context2);
                    } else if (str4.equalsIgnoreCase("Wallet")) {
                        a.b("/order-detail", "Wallet", context2);
                        a.a("screen_loaded_order_details_wallet", "/order-detail", context2);
                    } else if (a.c(str5, str4)) {
                        String str = null;
                        try {
                            if (str6 != null) {
                                str = a.b(str5, Long.parseLong(str6), str4);
                            }
                            if (str != null) {
                                if (!TextUtils.isEmpty(str)) {
                                    a.b("/order-detail", "Recharge", context2);
                                    a.a("screen_loaded_order_details_".concat(String.valueOf(str)), "/order-detail", context2);
                                    return;
                                }
                            }
                            a.b("/order-detail", "Recharge", context2);
                            a.a("screen_loaded_order_details", "/order-detail", "VERTICAL_NAME", "recharge", context2);
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    } else if (str4.equalsIgnoreCase("Paytm Hotel")) {
                        a.b("/order-detail", "Hotel", context2);
                        a.a("screen_loaded_order_details_hotels", "/order-detail", context2);
                    }
                }
            });
        }
    }

    public static void b(final String str, final String str2, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    if (context != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
                            hashMap.put("vertical_name", str2);
                            hashMap.put("Device_Brand", com.paytm.utility.a.e());
                            hashMap.put("Device_Name", com.paytm.utility.a.f());
                            a.a(context, (Map<String, Object>) hashMap);
                            String a2 = a.a(context);
                            boolean z = false;
                            if (a2 != null) {
                                hashMap.put("IMEI", Base64.encodeToString(a2.getBytes(), 0));
                            }
                            String d2 = com.paytm.utility.a.d(context);
                            if (d2 != null) {
                                hashMap.put("Custom_Device_ID", Base64.encodeToString(d2.getBytes(), 0));
                            }
                            if (com.paytm.utility.a.q(context) != null) {
                                if (!TextUtils.isEmpty(com.paytm.utility.a.a(context))) {
                                    hashMap.put("Customer_Id", com.paytm.utility.a.a(context));
                                }
                                hashMap.put("login_status", "loggedin");
                                String b2 = com.paytm.utility.a.b(context);
                                if (b2 != null) {
                                    hashMap.put("Contact_Number", Base64.encodeToString(b2.getBytes(), 0));
                                }
                                String c2 = com.paytm.utility.a.c(context);
                                if (c2 != null) {
                                    hashMap.put("user_email", Base64.encodeToString(c2.getBytes(), 0));
                                }
                                if (net.one97.paytm.upi.registration.b.a.a.a.a(context).e()) {
                                    hashMap.put("upi_status", Boolean.TRUE);
                                } else {
                                    hashMap.put("upi_status", Boolean.FALSE);
                                }
                                if (j.b(context) == 1) {
                                    z = true;
                                }
                                if (z) {
                                    hashMap.put("kyc_status", Boolean.TRUE);
                                } else {
                                    hashMap.put("kyc_status", Boolean.FALSE);
                                }
                            } else {
                                hashMap.put("login_status", "loggedOut");
                            }
                            String a3 = n.a(context, n.a());
                            if (a3 != null) {
                                hashMap.put("app_language", a3);
                            }
                            hashMap.put("app_language", n.a(context, n.a()));
                            a.b(hashMap, "openScreenDeviceInfo");
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    static String c(Context context) {
        try {
            String a2 = com.paytm.utility.a.p(context) ? com.paytm.utility.a.a(context) : null;
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2)) {
                    MessageDigest instance = MessageDigest.getInstance("SHA-256");
                    instance.update(a2.getBytes());
                    return Base64.encodeToString(instance.digest(), 11);
                }
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return null;
    }

    public static void a(final String str, final CJRHomePageItem cJRHomePageItem, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    CJRHomePageItem cJRHomePageItem;
                    if (context != null && (cJRHomePageItem = cJRHomePageItem) != null) {
                        try {
                            String utmCampaign = cJRHomePageItem.getUtmCampaign();
                            String utmMedium = cJRHomePageItem.getUtmMedium();
                            String utmSource = cJRHomePageItem.getUtmSource();
                            String utmTerm = cJRHomePageItem.getUtmTerm();
                            String utmContent = cJRHomePageItem.getUtmContent();
                            if (!cJRHomePageItem.isDeepLinking()) {
                                return;
                            }
                            if (utmCampaign != null || utmMedium != null || utmSource != null || utmTerm != null || utmContent != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "deepLinkOpen");
                                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
                                if (utmCampaign != null) {
                                    hashMap.put("utm_campaign", utmCampaign);
                                }
                                if (utmMedium != null) {
                                    hashMap.put("utm_medium", utmMedium);
                                }
                                if (utmSource != null) {
                                    hashMap.put("utm_source", utmSource);
                                }
                                if (utmTerm != null) {
                                    hashMap.put("utm_term", utmTerm);
                                }
                                if (utmContent != null) {
                                    hashMap.put("utm_content", utmContent);
                                }
                                hashMap.put("app_language", n.a(context, n.a()));
                                a.b(hashMap, "deepLinkOpen");
                            }
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    public static void a(Context context, Map<String, Object> map) {
        String b2 = ag.a(context.getApplicationContext()).b("ADVERTISING_ID", "", true);
        if (!b2.equals("")) {
            map.put("Advertising_ID", b2);
        }
    }

    public static void a(Context context, boolean z, CJROrderSummary cJROrderSummary, String str, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final CJROrderSummary cJROrderSummary2 = cJROrderSummary;
            final boolean z2 = z;
            final String str3 = str;
            final String str4 = str2;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        if (cJROrderSummary2 != null) {
                            if (z2) {
                                str = "ty_screen_" + str3;
                            } else {
                                long categoryId = cJROrderSummary2.getOrderedCartList().get(0).getProductDetail().getCategoryId();
                                Long.toString(categoryId);
                                if (str3.equalsIgnoreCase("Tickets")) {
                                    str = "ty_screen_bus";
                                } else if (str3.equalsIgnoreCase("Wallet")) {
                                    str = "ty_screen_wall";
                                } else if (a.c(str4, str3)) {
                                    String a2 = a.b(str4, categoryId, str3);
                                    str = !TextUtils.isEmpty(a2) ? "ty_screen_".concat(String.valueOf(a2)) : "ty_screen_rech";
                                } else {
                                    str = "ty_screen_mp";
                                }
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
                                Map<String, Object> a3 = b.a("transaction_revenue", String.valueOf(cJROrderSummary2.getGrandTotal()), UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, cJROrderSummary2.getId());
                                a3.put("app_language", n.a(context2, n.a()));
                                a.b(a3, str);
                            }
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final String str2, final String str3, final String str4) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        a.b(b.a(str2, str3, SDKConstants.EVENT_KEY_SCREEN_NAME, str4), str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void c(final String str, final Map<String, Object> map, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    if (context != null) {
                        try {
                            a.b(map, str);
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str, long j, String str2) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (!jSONObject2.has(str2.toLowerCase()) || (jSONObject = jSONObject2.getJSONObject(str2.toLowerCase())) == null || !jSONObject.has(String.valueOf(j))) {
                return "";
            }
            return jSONObject.getJSONObject(String.valueOf(j)).getString("n");
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static boolean c(String str, String str2) {
        try {
            return new JSONObject(str).has(str2.toLowerCase());
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static void c(final CJRHomePageItem cJRHomePageItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = str;
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", cJRHomePageItem.getURL(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", cJRHomePageItem.getmContainerInstanceID(), "id", cJRHomePageItem.getItemID(), "name", str, "creative", cJRHomePageItem.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void d(final CJRHomePageItem cJRHomePageItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = str;
                        Map<String, Object> a2 = b.a(SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", cJRHomePageItem.getURL(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("dimension40", cJRHomePageItem.getmContainerInstanceID(), "id", cJRHomePageItem.getItemID(), "name", str, "creative", cJRHomePageItem.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "promotion_click", "promotionClick");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void a(CJRHomePageItem cJRHomePageItem, String str, Context context, String str2, String str3, String str4, String str5) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str6 = str2;
            final String str7 = str4;
            final String str8 = str;
            final Context context2 = context;
            final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            final String str9 = str5;
            final String str10 = str3;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        StringBuilder sb = new StringBuilder(str6);
                        sb.append("-strip-");
                        sb.append(str7);
                        String a2 = a.a(str6);
                        Object[] objArr = new Object[10];
                        objArr[0] = SDKConstants.EVENT_KEY_SCREEN_NAME;
                        objArr[1] = a2;
                        objArr[2] = "destinationURL";
                        objArr[3] = str8;
                        objArr[4] = "Customer_Id";
                        objArr[5] = a.b(context2);
                        objArr[6] = "vertical_name";
                        objArr[7] = str7;
                        objArr[8] = "ecommerce";
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = "promoClick";
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = "promotions";
                        Object[] objArr4 = new Object[1];
                        Object[] objArr5 = new Object[12];
                        objArr5[0] = "dimension40";
                        objArr5[1] = cJRHomePageItem2.getmContainerInstanceID();
                        objArr5[2] = "id";
                        objArr5[3] = cJRHomePageItem2.getItemID();
                        objArr5[4] = "name";
                        objArr5[5] = str9;
                        objArr5[6] = "tag";
                        objArr5[7] = cJRHomePageItem2.getLayoutParam() != null ? cJRHomePageItem2.getLayoutParam().getLabel() : "";
                        objArr5[8] = "creative";
                        objArr5[9] = r.a(cJRHomePageItem2);
                        objArr5[10] = CLPConstants.ARGUMENT_KEY_POSITION;
                        objArr5[11] = str10;
                        objArr4[0] = b.a(objArr5);
                        objArr3[1] = b.b(objArr4);
                        objArr2[1] = b.a(objArr3);
                        objArr[9] = b.a(objArr2);
                        Map<String, Object> a3 = b.a(objArr);
                        a3.put("app_language", n.a(context2, n.a()));
                        if (!TextUtils.isEmpty(str9)) {
                            if (str9.contains("category")) {
                                a.a(a3, "promotion_click", "promotionClick");
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(str9) || !str9.contains("wallet")) {
                            a.a(a3, "promotion_click", "promotionClick");
                            return;
                        }
                        a3.put("vertical_name", "blue_strip");
                        a.a(a3, "promotion_click", "promotionClick");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final CJRItem cJRItem, final Map<String, Object> map, final String str, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        map.put("recharge_utilities_business_sub_vertical", cJRItem.getName());
                        map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/" + cJRItem.getName().toLowerCase());
                        if (!TextUtils.isEmpty(a.b(context))) {
                            map.put("user_id", a.b(context));
                        }
                        a.b(str, (Map<String, Object>) map, context);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final Map<String, Object> map, final String str2, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        map.put("recharge_utilities_business_sub_vertical", str);
                        map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/" + str.toLowerCase());
                        if (!TextUtils.isEmpty(a.b(context))) {
                            map.put("user_id", a.b(context));
                        }
                        a.b(str2, (Map<String, Object>) map, context);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final NearbyOffersBannerModal.Item item, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null && item != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = str;
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", item.getURL(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", item.getmContainerInstanceID(), "id", item.getItemID(), "name", str, "creative", item.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final NearbyOffersBannerModal.Item item, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null && item != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = str;
                        Map<String, Object> a2 = b.a(SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", item.getURL(), "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("dimension40", item.getmContainerInstanceID(), "id", item.getItemID(), "name", str, "creative", item.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "promotion_click", "promotionClick");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void a(Context context, Intent intent) {
        Uri uri;
        String stringExtra;
        Bundle bundle = null;
        if (intent != null) {
            try {
                uri = intent.getData();
                if (uri == null && (stringExtra = intent.getStringExtra("url")) != null) {
                    uri = Uri.parse(stringExtra);
                }
            } catch (Exception unused) {
                return;
            }
        } else {
            uri = null;
        }
        if (uri != null) {
            uri = Uri.parse(uri.toString().replace("$", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN));
        }
        if (!(intent == null || intent.getExtras() == null)) {
            bundle = intent.getExtras().getBundle("notificationBundle");
        }
        a(context, uri, bundle);
    }

    public static void b(Context context, Intent intent) {
        Bundle bundle;
        try {
            Uri uri = null;
            if (intent.getExtras() != null) {
                bundle = intent.getExtras().getBundle("notificationBundle");
                if (bundle != null) {
                    String replace = Uri.parse(bundle.getString("url")).toString().replace("$", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                    int indexOf = replace.indexOf("?") + 1;
                    uri = Uri.parse(replace.substring(0, indexOf) + replace.substring(indexOf, replace.length()).replace("?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN));
                }
            } else {
                bundle = null;
            }
            a(context, uri, bundle);
        } catch (Exception unused) {
        }
    }

    private static void a(Context context, Uri uri, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (uri != null) {
            str5 = uri.getQueryParameter("gclid") != null ? String.valueOf(uri.getQueryParameter("gclid")) : null;
            str4 = uri.getQueryParameter("utm_source") != null ? String.valueOf(uri.getQueryParameter("utm_source")) : null;
            str3 = uri.getQueryParameter("utm_medium") != null ? String.valueOf(uri.getQueryParameter("utm_medium")) : null;
            str2 = uri.getQueryParameter("utm_campaign") != null ? String.valueOf(uri.getQueryParameter("utm_campaign")) : null;
            str = uri.getQueryParameter("utm_content") != null ? String.valueOf(uri.getQueryParameter("utm_content")) : null;
            if (uri.getQueryParameter("utm_term") != null) {
                str7 = String.valueOf(uri.getQueryParameter("utm_term"));
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (bundle != null) {
            if (bundle.getString("gclid") != null) {
                str5 = String.valueOf(bundle.getString("gclid"));
            }
            if (bundle.getString("utm_source") != null) {
                str4 = String.valueOf(bundle.getString("utm_source"));
            }
            if (bundle.getString("utm_medium") != null) {
                str3 = String.valueOf(bundle.getString("utm_medium"));
            }
            if (bundle.getString("utm_campaign") != null) {
                str2 = String.valueOf(bundle.getString("utm_campaign"));
            }
            if (bundle.getString("utm_content") != null) {
                str = String.valueOf(bundle.getString("utm_content"));
            }
            if (bundle.getString("utm_term") != null) {
                str7 = String.valueOf(bundle.getString("utm_term"));
            }
        }
        HashMap hashMap = new HashMap();
        if (str5 != null) {
            hashMap.put("gclid", str5);
        }
        if (str4 != null) {
            hashMap.put("utm_source", str4);
        }
        if (str3 != null) {
            hashMap.put("utm_medium", str3);
        }
        if (str2 != null) {
            hashMap.put("utm_campaign", str2);
        }
        if (str != null) {
            hashMap.put("utm_content", str);
        }
        if (str7 != null) {
            hashMap.put("utm_term", str7);
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Splash");
        hashMap.put("app_language", n.a(context, n.a()));
        if (uri != null) {
            hashMap.put("deeplink_full", String.valueOf(uri));
            hashMap.put("deeplink_without_utm", k.a(String.valueOf(uri), "utm_source", "utm_medium", "utm_campaign", "utm_content", "utm_term", "gclid"));
            str6 = "openScreenWithParameters";
        } else {
            str6 = "openScreen";
        }
        a((Map<String, Object>) hashMap, "openScreen", str6);
    }

    private static void a(Map<String, Object> map, Map<String, Object> map2) {
        if (map2 != null) {
            map.put("dimension61", map2.get("source_container_instance_id"));
            map.put("dimension63", map2.get("source_container_id"));
            map.put("dimension64", map2.get("source_id"));
            map.put("dimension65", map2.get("source_position"));
        }
    }

    public static void a(Context context, List<CJRGridProduct> list, String str, String str2, String str3, int i2, String str4, String str5, Map<String, Object> map) {
        Handler handler = f50683c;
        if (handler != null) {
            final Context context2 = context;
            final List<CJRGridProduct> list2 = list;
            final String str6 = str;
            final String str7 = str2;
            final int i3 = i2;
            final String str8 = str4;
            final String str9 = str5;
            final Map<String, Object> map2 = map;
            final String str10 = str3;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (context2 == null) {
                            return;
                        }
                        if (list2 != null) {
                            Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "productImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, str10, "VERTICAL_NAME", GAUtil.MARKET_PLACE, "Customer_Id", a.b(context2), "ecommerce", b.a("currencyCode", "INR", "impressions", a.a(list2, str6, str7, i3, str9, map2)));
                            a2.put("app_language", n.a(context2, n.a()));
                            a.b(a2, "productImpression");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(CJRHomePageItem cJRHomePageItem, int i2, Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !String.valueOf(str.charAt(str.length() - 1)).equals("-")) {
            str = str + "-";
        }
        final String str3 = str;
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            final String str4 = str2;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        String str = str3 + cJRHomePageItem2.getParentItem();
                        String a2 = a.a(str3);
                        StringBuilder sb = new StringBuilder();
                        sb.append(cJRHomePageItem2.getWidgetPosition() + 1);
                        Map<String, Object> a3 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a2, "promo_layout_type", str4, "destinationURL", cJRHomePageItem2.getURL(), "Customer_Id", a.b(context2), "vertical_name", "", "promo_widget_position", sb.toString(), "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", cJRHomePageItem2.getmContainerInstanceID(), "id", cJRHomePageItem2.getItemID(), "name", str, "creative", cJRHomePageItem2.getName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i3 + 1))))));
                        a3.put("app_language", n.a(context2, n.a()));
                        a.b(a3, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(boolean z, boolean z2, String str, Context context, String str2, String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            final boolean z3 = z;
            final boolean z4 = z2;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    String str = "general";
                    String str2 = "popup";
                    try {
                        if (z3) {
                            str = "operator_specific";
                        }
                        if (!z4) {
                            str2 = "non_popup";
                        }
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "recharge_utilities_message_displayed", "recharge_utilities_message_type", str, "recharge_utilities_display_type", str2, "recharge_utilities_business_sub_vertical", str4, "recharge_utilities_service_type", str5, "recharge_utilities_message_text", str6);
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, "recharge_utilities_message_displayed");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(CJROrderSummary cJROrderSummary, y yVar, Context context) {
        if (yVar != null) {
            try {
                String paymentStatus = cJROrderSummary.getPaymentStatus();
                String str = "";
                if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                    HashMap hashMap = new HashMap();
                    if (cJROrderSummary.getId() != null) {
                        str = cJROrderSummary.getId();
                    }
                    hashMap.put("paytm_assist_order_id", str);
                    hashMap.put("paytm_assist_order_status", "successful");
                    b("paytm_assist_transaction", (Map<String, Object>) hashMap, context);
                    yVar.setPaytmAssistOrderStatus("successful");
                } else if (paymentStatus.equalsIgnoreCase("FAILED")) {
                    HashMap hashMap2 = new HashMap();
                    if (cJROrderSummary.getId() != null) {
                        str = cJROrderSummary.getId();
                    }
                    hashMap2.put("paytm_assist_order_id", str);
                    hashMap2.put("paytm_assist_order_status", "failed");
                    hashMap2.put("paytm_assist_transaction_failure_reason", a(cJROrderSummary));
                    b("paytm_assist_transaction", (Map<String, Object>) hashMap2, context);
                    yVar.setPaytmAssistOrderStatus("failed");
                } else {
                    HashMap hashMap3 = new HashMap();
                    if (cJROrderSummary.getId() != null) {
                        str = cJROrderSummary.getId();
                    }
                    hashMap3.put("paytm_assist_order_id", str);
                    hashMap3.put("paytm_assist_order_status", "processing");
                    b("paytm_assist_transaction", (Map<String, Object>) hashMap3, context);
                    yVar.setPaytmAssistOrderStatus("processing");
                }
                boolean b2 = ag.a(context, f.a.PREFERENCE_FILE_KEY).b("enableEasyPay", false, false);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("paytm_assist_order_id", yVar.getPaytmAssistOrderId());
                hashMap4.put("account_paytm_assist_toggle_state", b2 ? "on" : StringSet.off);
                hashMap4.put("paytm_assist_open_yes_or_no", yVar.getPaytmAssistOpenYesNo());
                hashMap4.put("paytm_assist_otp_read_yes_or_no", yVar.getPaytmAssistOtpReadYesNo());
                hashMap4.put("paytm_assist_otp_submit_yes_or_no", yVar.getPaytmAssistOtpSubmitYesNo());
                hashMap4.put("paytm_assist_otp_digits", yVar.getPaytmAssistOtpDigits());
                hashMap4.put("paytm_assist_order_status", yVar.getPaytmAssistOrderStatus());
                hashMap4.put("paytm_assist_popup_url", yVar.getPaytmAssistPopupUrl());
                hashMap4.put("paytm_assist_last_url", yVar.getPaytmAssistLastUrl());
                hashMap4.put("paytm_assist_final_url_key", yVar.getPaytmAssistFinalUrlKey());
                hashMap4.put("paytm_assist_password_helper_opened_yes_or_no", yVar.getPaytmAssistPasswordHelperOpenYesNo());
                hashMap4.put("paytm_assist_password_helper_url", yVar.getPaytmAssistPasswordHelperUrl());
                hashMap4.put("paytm_assist_radio_helper_opened_yes_or_no", yVar.getPaytmAssistRadioHelperOpenYesNo());
                hashMap4.put("paytm_assist_radio_helper_url", yVar.getPaytmAssistRadioHelperUrl());
                hashMap4.put("paytm_assist_proceed_helper_opened_yes_or_no", yVar.getPaytmAssistProceedHelperOpenYesNo());
                hashMap4.put("paytm_assist_proceed_helper_url", yVar.getPaytmAssistProceedHelperUrl());
                b("paytm_assist_final_summary", (Map<String, Object>) hashMap4, context);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private static String a(CJROrderSummary cJROrderSummary) {
        try {
            return cJROrderSummary.getPaymentText().contains(DirectFormItemType.CANCEL) ? DirectFormItemType.CANCEL : cJROrderSummary.getPaymentText().contains(H5Param.DEFAULT_LONG_BACK_BEHAVIOR) ? H5Param.DEFAULT_LONG_BACK_BEHAVIOR : "other";
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "other";
        }
    }

    public static void a(final CJRDetailProduct cJRDetailProduct, final Context context, final CJRItem cJRItem) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    CJRDetailProduct cJRDetailProduct = cJRDetailProduct;
                    if (cJRDetailProduct != null && context != null) {
                        try {
                            String gAKey = cJRDetailProduct.getGAKey();
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, gAKey);
                            hashMap.put("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                            a.a((Map<String, Object>) hashMap, context);
                            hashMap.put("ecommerce", a.a(cJRDetailProduct, cJRItem));
                            hashMap.put("app_language", n.a(context, n.a()));
                            a.b(hashMap, "openScreen");
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    private static HashMap<String, Object> a(CJRItem cJRItem, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i2;
        String str10;
        String str11 = null;
        int i3 = 0;
        if (cJRItem != null) {
            str10 = cJRItem.getListName();
            i2 = cJRItem.getListPosition();
            str9 = cJRItem.getSearchType();
            str8 = cJRItem.getSearchCategory();
            str7 = cJRItem.getSearchTerm();
            str6 = cJRItem.getSearchResultType();
            str5 = cJRItem.getListId();
            str4 = cJRItem.getmContainerInstanceID();
            str3 = cJRItem.getSearchABValue();
            str2 = cJRItem.getSource();
            if (cJRItem instanceof CJRHomePageItem) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) cJRItem;
                i3 = cJRHomePageItem.getWidgetPosition();
                str11 = cJRHomePageItem.getLayoutType();
            }
        } else {
            str10 = "";
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            i2 = -1;
        }
        if (str2 != null && !str2.isEmpty()) {
            str10 = str10 + "/" + str2;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str10)) {
            hashMap.put("dimension24", str10);
        }
        if (i2 != -1) {
            hashMap.put("dimension25", String.valueOf(i2 + 1));
        }
        if (!TextUtils.isEmpty(str9)) {
            hashMap.put("dimension26", str9);
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("dimension27", str8);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("dimension28", str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("dimension29", str6);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("dimension31", str);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("dimension40", str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("dimension53", str3);
        }
        if (!TextUtils.isEmpty(str11)) {
            hashMap.put("dimension67", str11);
        }
        if (i3 != 0) {
            hashMap.put("dimension70", Integer.valueOf(i3));
        }
        hashMap.put("dimension38", str5);
        return hashMap;
    }

    public static void a(final CJRCartProduct cJRCartProduct, final Context context, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (cJRCartProduct != null) {
                            Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", "eventName", "addToCart", SDKConstants.EVENT_KEY_SCREEN_NAME, str, "ecommerce", b.a("currencyCode", "INR", "add", a.a(cJRCartProduct, cJRCartProduct.getCategoryPathForGTM())));
                            a2.put("app_language", n.a(context, n.a()));
                            a.b(a2, "addToCart");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, boolean z, String str2, String str3, long j) {
        Handler handler = f50683c;
        if (handler != null) {
            final CJROrderSummary cJROrderSummary2 = cJROrderSummary;
            final boolean z2 = z;
            final String str4 = str2;
            final String str5 = str3;
            final long j2 = j;
            final Context context2 = context;
            final CJRParcelTrackingInfo cJRParcelTrackingInfo2 = cJRParcelTrackingInfo;
            final String str6 = str;
            handler.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        if (cJROrderSummary2 != null) {
                            if (z2) {
                                str = str4;
                            } else {
                                str = a.a(str4, str5, j2);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
                            hashMap.put("vertical_name", str);
                            a.a((Map<String, Object>) hashMap, context2);
                            hashMap.put("ecommerce", a.a(cJROrderSummary2, cJRParcelTrackingInfo2, str6));
                            hashMap.put("app_language", n.a(context2, n.a()));
                            a.b(hashMap, "openScreen");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    private static List<Object> a(CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap<String, CJRTrackingInfo> a2 = a(cJRParcelTrackingInfo);
        ArrayList arrayList2 = new ArrayList();
        Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                String valueOf = String.valueOf(productDetail.getId());
                productDetail.setDiscountedPrice(next.getDiscountedPrice());
                arrayList2.add(String.valueOf(next.getMerchantId()));
                ArrayList arrayList3 = (ArrayList) hashMap.get(valueOf);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    hashMap.put(valueOf, arrayList3);
                }
                arrayList3.add(productDetail);
            }
        }
        int i2 = 0;
        for (String str5 : hashMap.keySet()) {
            ArrayList arrayList4 = (ArrayList) hashMap.get(str5);
            CJRTrackingInfo cJRTrackingInfo = a2.get(str5);
            CJROrderSummaryProductDetail cJROrderSummaryProductDetail = (CJROrderSummaryProductDetail) arrayList4.get(0);
            if (cJROrderSummaryProductDetail.getCategoryMapPath().trim().length() > 0) {
                str = cJROrderSummaryProductDetail.getCategoryMapPath();
            } else {
                str = cJROrderSummaryProductDetail.getVertical();
            }
            if (cJROrderSummaryProductDetail.getCategoryIdMapPath().trim().length() > 0) {
                str2 = cJROrderSummaryProductDetail.getCategoryIdMapPath();
            } else {
                str2 = String.valueOf(cJROrderSummaryProductDetail.getVerticalId());
            }
            String brandName = cJROrderSummaryProductDetail.getBrandName();
            String name = cJROrderSummaryProductDetail.getName();
            if (i2 >= arrayList2.size() || arrayList2.get(i2) == null) {
                str3 = "";
            } else {
                str3 = (String) arrayList2.get(i2);
                i2++;
            }
            if (TextUtils.isEmpty(cJROrderSummary.getPromoCode())) {
                str4 = "";
            } else {
                str4 = cJROrderSummary.getPromoCode();
            }
            double discountedPrice = cJROrderSummaryProductDetail.getDiscountedPrice();
            Object[] objArr = new Object[18];
            objArr[0] = "id";
            objArr[1] = str5;
            objArr[2] = "name";
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            objArr[3] = name;
            objArr[4] = "category";
            objArr[5] = str;
            objArr[6] = CLPConstants.BRAND_PARAMS;
            objArr[7] = brandName;
            objArr[8] = "variant";
            objArr[9] = "";
            objArr[10] = "price";
            objArr[11] = String.valueOf(discountedPrice);
            objArr[12] = "quantity";
            objArr[13] = Integer.valueOf(arrayList4.size());
            objArr[14] = "dimension41";
            objArr[15] = str3;
            objArr[16] = "dimension43";
            objArr[17] = str2;
            Map<String, Object> a3 = b.a(objArr);
            if (cJRTrackingInfo != null) {
                String listName = cJRTrackingInfo.getListName();
                StringBuilder sb = new StringBuilder();
                sb.append(cJRTrackingInfo.getListPosition() + 1);
                String sb2 = sb.toString();
                String searchType = cJRTrackingInfo.getSearchType();
                String searchCategory = cJRTrackingInfo.getSearchCategory();
                String searchTerm = cJRTrackingInfo.getSearchTerm();
                String searchResultType = cJRTrackingInfo.getSearchResultType();
                cJRTrackingInfo.getSearchABValue();
                a3.put("dimension24", listName);
                a3.put("dimension25", sb2);
                a3.put(CLPConstants.ARGUMENT_KEY_POSITION, sb2);
                if (!TextUtils.isEmpty(searchType)) {
                    a3.put("dimension26", searchType);
                }
                if (!TextUtils.isEmpty(searchCategory)) {
                    a3.put("dimension27", searchCategory);
                }
                if (!TextUtils.isEmpty(searchTerm)) {
                    a3.put("dimension28", searchTerm);
                }
                if (!TextUtils.isEmpty(searchResultType)) {
                    a3.put("dimension29", searchResultType);
                }
                if (!TextUtils.isEmpty(cJRTrackingInfo.getListId())) {
                    a3.put("dimension38", cJRTrackingInfo.getListId());
                }
                if (!TextUtils.isEmpty(cJRTrackingInfo.getSearchABValue())) {
                    a3.put("dimension53", cJRTrackingInfo.getSearchABValue());
                }
                if (!TextUtils.isEmpty(cJRTrackingInfo.getContainerID())) {
                    a3.put("dimension40", cJRTrackingInfo.getContainerID());
                }
                a3.put("dimension31", cJRTrackingInfo.getParentId());
                a3.put("dimension61", cJRTrackingInfo.getmSourceContainerInstanceId());
                a3.put("dimension63", cJRTrackingInfo.getmSourceContainerId());
                a3.put("dimension64", cJRTrackingInfo.getmSourceId());
                a3.put("dimension65", cJRTrackingInfo.getmSourcePosition());
            }
            if (!TextUtils.isEmpty(str4)) {
                a3.put("coupon", str4);
            }
            arrayList.add(a3);
        }
        return arrayList;
    }

    public static void a(final Context context, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    if (context != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
                            hashMap.put("vertical_name", "Recharge");
                            a.a((Map<String, Object>) hashMap, context);
                            hashMap.put("app_language", n.a(context, n.a()));
                            a.b(hashMap, "openScreen");
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    public static void a(Context context, CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, HashMap<String, Object> hashMap) {
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final String str3 = str;
            final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            final String str4 = str2;
            final Context context2 = context;
            final HashMap<String, Object> hashMap2 = hashMap;
            handler.post(new Runnable() {
                public final void run() {
                    String str = "Similar Products";
                    try {
                        int i2 = i3 + 1;
                        String str2 = str3;
                        if (!cJRHomePageItem2.getParentItem().contains(str) || !str4.equalsIgnoreCase("PDP")) {
                            if (cJRHomePageItem2.getSource() != null) {
                                str = str2 + "-" + cJRHomePageItem2.getParentItem() + "/" + cJRHomePageItem2.getSource();
                            } else {
                                str = str2 + "-" + cJRHomePageItem2.getParentItem();
                            }
                        }
                        String str3 = str;
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", SDKConstants.EVENT_KEY_SCREEN_NAME, str4, "eventName", "productClick", "vertical_name", "", "Customer_Id", a.b(context2), "ecommerce", b.a("currencyCode", "INR", "click", b.a("actionField", b.a("list", str3), "products", b.b(a.a((HashMap<String, Object>) hashMap2, cJRHomePageItem2, str3, i2, "", "")))));
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, "productClick");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Context context, final CJRHomePageItem cJRHomePageItem, final String str, final CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", "eventName", "productClick", SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary", "VERTICAL_NAME", "", "Customer_Id", a.b(context), "ecommerce", b.a("currencyCode", "INR", "click", b.a("actionField", b.a("list", str), "products", b.b(a.a(cJRHomePageItem, cJROrderSummaryProductDetail)))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "productClick");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(ArrayList<CJRCartProduct> arrayList, Context context, int i2, String str, boolean z) {
        Handler handler = f50683c;
        if (handler != null) {
            final ArrayList<CJRCartProduct> arrayList2 = arrayList;
            final int i3 = i2;
            final String str2 = str;
            final boolean z2 = z;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (arrayList2 == null) {
                            return;
                        }
                        if (arrayList2.size() != 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "click");
                            hashMap.put("eventName", "checkout");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "cart");
                            hashMap.put("ecommerce", a.a(arrayList2, i3));
                            hashMap.put("app_language", n.a(context2, n.a()));
                            a.b(hashMap, "checkout");
                        }
                    } catch (Exception e2) {
                        if (b.v) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    private static List<Object> a(ArrayList<CJRCartProduct> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<CJRCartProduct> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            String categoryPathForGTM = next.getCategoryPathForGTM();
            String categoryIdForGTM = next.getCategoryIdForGTM();
            if (TextUtils.isEmpty(categoryPathForGTM)) {
                categoryPathForGTM = next.getVerticalLabel();
                categoryIdForGTM = next.getVerticalId();
            }
            String promoCode = TextUtils.isEmpty(next.getPromoCode()) ? "" : next.getPromoCode();
            HashMap hashMap = new HashMap();
            hashMap.put("id", next.getProductId());
            hashMap.put("name", next.getName());
            hashMap.put("category", categoryPathForGTM);
            hashMap.put(CLPConstants.BRAND_PARAMS, next.getBrand());
            hashMap.put("variant", "");
            hashMap.put("price", next.getSellingPrice());
            hashMap.put("quantity", next.getQuantity());
            hashMap.put("dimension43", categoryIdForGTM);
            hashMap.put("dimension41", next.getMerchantId());
            if (next.getTrackingInfo() != null) {
                CJRTrackingInfo trackingInfo = next.getTrackingInfo();
                if (!TextUtils.isEmpty(trackingInfo.getListName())) {
                    hashMap.put("dimension24", trackingInfo.getListName());
                }
                if (trackingInfo.getListPosition() != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(trackingInfo.getListPosition() + 1);
                    hashMap.put("dimension25", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(trackingInfo.getListPosition() + 1);
                    hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, sb2.toString());
                }
                if (!TextUtils.isEmpty(trackingInfo.getSearchType())) {
                    hashMap.put("dimension26", trackingInfo.getSearchType());
                }
                if (!TextUtils.isEmpty(trackingInfo.getSearchType())) {
                    hashMap.put("dimension27", trackingInfo.getSearchCategory());
                }
                if (!TextUtils.isEmpty(trackingInfo.getSearchType())) {
                    hashMap.put("dimension28", trackingInfo.getSearchTerm());
                }
                if (!TextUtils.isEmpty(trackingInfo.getSearchType())) {
                    hashMap.put("dimension29", trackingInfo.getSearchResultType());
                }
                if (!TextUtils.isEmpty(trackingInfo.getListId())) {
                    hashMap.put("dimension38", trackingInfo.getListId());
                }
                if (!TextUtils.isEmpty(trackingInfo.getContainerID())) {
                    hashMap.put("dimension40", trackingInfo.getContainerID());
                }
                if (!TextUtils.isEmpty(trackingInfo.getSearchABValue())) {
                    hashMap.put("dimension53", trackingInfo.getSearchABValue());
                }
                hashMap.put("dimension31", trackingInfo.getParentId());
                if (!TextUtils.isEmpty(trackingInfo.getmSourceContainerId())) {
                    hashMap.put("dimension63", trackingInfo.getmSourceContainerId());
                }
                if (!TextUtils.isEmpty(trackingInfo.getmSourceContainerInstanceId())) {
                    hashMap.put("dimension61", trackingInfo.getmSourceContainerInstanceId());
                }
                if (!TextUtils.isEmpty(trackingInfo.getmSourceId())) {
                    hashMap.put("dimension64", trackingInfo.getmSourceId());
                }
                if (!TextUtils.isEmpty(trackingInfo.getmSourcePosition())) {
                    hashMap.put("dimension65", trackingInfo.getmSourcePosition());
                }
            } else {
                hashMap.put("dimension31", next.getParentID());
            }
            if (!TextUtils.isEmpty(promoCode)) {
                hashMap.put("coupon", promoCode);
            }
            arrayList2.add(hashMap);
        }
        return arrayList2;
    }

    public static void e(final CJRHomePageItem cJRHomePageItem, final Context context, final int i2, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:23:0x0164 A[Catch:{ Exception -> 0x018e }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r18 = this;
                        r0 = r18
                        java.lang.String r1 = "_"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = "slot_"
                        r2.<init>(r3)     // Catch:{ Exception -> 0x018e }
                        int r3 = r4     // Catch:{ Exception -> 0x018e }
                        r4 = 1
                        int r3 = r3 + r4
                        r2.append(r3)     // Catch:{ Exception -> 0x018e }
                        r2.append(r1)     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r2     // Catch:{ Exception -> 0x018e }
                        int r3 = r3.getWidgetPosition()     // Catch:{ Exception -> 0x018e }
                        int r3 = r3 + r4
                        r2.append(r3)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = r3.getParentItem()     // Catch:{ Exception -> 0x018e }
                        if (r3 == 0) goto L_0x0069
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
                        r3.<init>()     // Catch:{ Exception -> 0x018e }
                        java.lang.String r5 = r5     // Catch:{ Exception -> 0x018e }
                        r3.append(r5)     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r5 = r5.getParentItem()     // Catch:{ Exception -> 0x018e }
                        r3.append(r5)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r5 = r5.getLayoutType()     // Catch:{ Exception -> 0x018e }
                        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x018e }
                        if (r5 == 0) goto L_0x0050
                        goto L_0x0091
                    L_0x0050:
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
                        r5.<init>()     // Catch:{ Exception -> 0x018e }
                        r5.append(r3)     // Catch:{ Exception -> 0x018e }
                        r5.append(r1)     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r1 = r1.getLayoutType()     // Catch:{ Exception -> 0x018e }
                        r5.append(r1)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x018e }
                        goto L_0x0091
                    L_0x0069:
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r1 = r1.getLayoutType()     // Catch:{ Exception -> 0x018e }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x018e }
                        if (r1 == 0) goto L_0x0079
                        java.lang.String r1 = r5     // Catch:{ Exception -> 0x018e }
                    L_0x0077:
                        r3 = r1
                        goto L_0x0091
                    L_0x0079:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
                        r1.<init>()     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = r5     // Catch:{ Exception -> 0x018e }
                        r1.append(r3)     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = r3.getLayoutType()     // Catch:{ Exception -> 0x018e }
                        r1.append(r3)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x018e }
                        goto L_0x0077
                    L_0x0091:
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = r2     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem$Displaymetadata r1 = r1.getDisplaymetadata()     // Catch:{ Exception -> 0x018e }
                        java.lang.String r5 = ""
                        if (r1 == 0) goto L_0x00aa
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = r2     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem$Displaymetadata r1 = r1.getDisplaymetadata()     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2$Displaymetadata$Metadata r1 = r1.getMmetadata()     // Catch:{ Exception -> 0x018e }
                        if (r1 == 0) goto L_0x00aa
                        java.lang.String r1 = "ads"
                        goto L_0x00ab
                    L_0x00aa:
                        r1 = r5
                    L_0x00ab:
                        java.lang.String r6 = r5     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = net.one97.paytm.j.a.a((java.lang.String) r6)     // Catch:{ Exception -> 0x018e }
                        r7 = 12
                        java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x018e }
                        java.lang.String r9 = "dimension40"
                        r10 = 0
                        r8[r10] = r9     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r9 = r9.getmContainerInstanceID()     // Catch:{ Exception -> 0x018e }
                        r8[r4] = r9     // Catch:{ Exception -> 0x018e }
                        java.lang.String r9 = "id"
                        r11 = 2
                        r8[r11] = r9     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r9 = r9.getItemID()     // Catch:{ Exception -> 0x018e }
                        r12 = 3
                        r8[r12] = r9     // Catch:{ Exception -> 0x018e }
                        java.lang.String r9 = "name"
                        r13 = 4
                        r8[r13] = r9     // Catch:{ Exception -> 0x018e }
                        r9 = 5
                        r8[r9] = r3     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = "creative"
                        r14 = 6
                        r8[r14] = r3     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = net.one97.paytm.utils.r.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r3)     // Catch:{ Exception -> 0x018e }
                        r15 = 7
                        r8[r15] = r3     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = "position"
                        r16 = 8
                        r8[r16] = r3     // Catch:{ Exception -> 0x018e }
                        r3 = 9
                        r8[r3] = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r2 = "type"
                        r17 = 10
                        r8[r17] = r2     // Catch:{ Exception -> 0x018e }
                        r2 = 11
                        r8[r2] = r1     // Catch:{ Exception -> 0x018e }
                        java.util.Map r1 = net.one97.paytm.j.b.a(r8)     // Catch:{ Exception -> 0x018e }
                        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x018e }
                        java.lang.String r8 = "screenName"
                        r7[r10] = r8     // Catch:{ Exception -> 0x018e }
                        r7[r4] = r6     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = "promo_layout_type"
                        r7[r11] = r6     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r6 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = r6.getLayoutType()     // Catch:{ Exception -> 0x018e }
                        r7[r12] = r6     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = "destinationURL"
                        r7[r13] = r6     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r6 = r2     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = r6.getURL()     // Catch:{ Exception -> 0x018e }
                        r7[r9] = r6     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = "Customer_Id"
                        r7[r14] = r6     // Catch:{ Exception -> 0x018e }
                        android.content.Context r6 = r3     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = net.one97.paytm.j.a.b((android.content.Context) r6)     // Catch:{ Exception -> 0x018e }
                        r7[r15] = r6     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = "vertical_name"
                        r7[r16] = r6     // Catch:{ Exception -> 0x018e }
                        r7[r3] = r5     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = "ecommerce"
                        r7[r17] = r3     // Catch:{ Exception -> 0x018e }
                        java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x018e }
                        java.lang.String r5 = "promoClick"
                        r3[r10] = r5     // Catch:{ Exception -> 0x018e }
                        java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x018e }
                        java.lang.String r6 = "promotions"
                        r5[r10] = r6     // Catch:{ Exception -> 0x018e }
                        java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x018e }
                        r6[r10] = r1     // Catch:{ Exception -> 0x018e }
                        java.util.List r1 = net.one97.paytm.j.b.b(r6)     // Catch:{ Exception -> 0x018e }
                        r5[r4] = r1     // Catch:{ Exception -> 0x018e }
                        java.util.Map r1 = net.one97.paytm.j.b.a(r5)     // Catch:{ Exception -> 0x018e }
                        r3[r4] = r1     // Catch:{ Exception -> 0x018e }
                        java.util.Map r1 = net.one97.paytm.j.b.a(r3)     // Catch:{ Exception -> 0x018e }
                        r7[r2] = r1     // Catch:{ Exception -> 0x018e }
                        java.util.Map r1 = net.one97.paytm.j.b.a(r7)     // Catch:{ Exception -> 0x018e }
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2     // Catch:{ Exception -> 0x018e }
                        java.util.Map r2 = r2.getSourceInfo()     // Catch:{ Exception -> 0x018e }
                        if (r2 == 0) goto L_0x017c
                        java.lang.String r3 = "promo_container_id"
                        java.lang.String r4 = "source_container_id"
                        java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x018e }
                        r1.put(r3, r4)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = "promo_container_instance_id"
                        java.lang.String r4 = "source_container_instance_id"
                        java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x018e }
                        r1.put(r3, r2)     // Catch:{ Exception -> 0x018e }
                    L_0x017c:
                        java.lang.String r2 = "app_language"
                        android.content.Context r3 = r3     // Catch:{ Exception -> 0x018e }
                        java.lang.String r3 = com.paytm.utility.n.a((android.content.Context) r3, com.paytm.utility.n.a())     // Catch:{ Exception -> 0x018e }
                        r1.put(r2, r3)     // Catch:{ Exception -> 0x018e }
                        java.lang.String r2 = "promotion_click"
                        java.lang.String r3 = "promotionClick"
                        net.one97.paytm.j.a.a((java.util.Map<java.lang.String, java.lang.Object>) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x018e }
                    L_0x018e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.j.a.AnonymousClass43.run():void");
                }
            });
        }
    }

    public static void a(Context context, CJRGridProduct cJRGridProduct, int i2, String str, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final CJRGridProduct cJRGridProduct2 = cJRGridProduct;
            final String str3 = str2;
            final Context context2 = context;
            final String str4 = str;
            handler.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        int i2 = i3 + 1;
                        if (cJRGridProduct2.getSource() != null) {
                            str = "" + "/" + cJRGridProduct2.getSource();
                        } else {
                            str = "";
                        }
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", SDKConstants.EVENT_KEY_SCREEN_NAME, str3, "eventName", "productClick", "Customer_Id", a.b(context2), "vertical_name", "", "ecommerce", b.a("currencyCode", "INR", "click", b.a("actionField", b.a("list", str), "products", b.b(a.a(cJRGridProduct2, str, str4, i2, cJRGridProduct2.getAncestorID())))));
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, "productClick");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(CJRGridProduct cJRGridProduct, int i2, Context context, String str, CJRItem cJRItem, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final CJRGridProduct cJRGridProduct2 = cJRGridProduct;
            final String str3 = str;
            final Context context2 = context;
            final int i3 = i2;
            final CJRItem cJRItem2 = cJRItem;
            final String str4 = str2;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (cJRGridProduct2 != null) {
                            a.b(b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", "eventName", "addToCart", SDKConstants.EVENT_KEY_SCREEN_NAME, str3, "Customer_Id", a.b(context2), "vertical_name", "", "ecommerce", b.a("currencyCode", "INR", "add", a.a(cJRGridProduct2, i3, cJRItem2, str4))), "addToCart");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(CJRGridProduct cJRGridProduct, int i2, String str, CJRItem cJRItem, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final CJRGridProduct cJRGridProduct2 = cJRGridProduct;
            final String str3 = str;
            final int i3 = i2;
            final CJRItem cJRItem2 = cJRItem;
            final String str4 = str2;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (cJRGridProduct2 != null) {
                            a.b(b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "click", "eventName", "removeFromCart", SDKConstants.EVENT_KEY_SCREEN_NAME, str3, "ecommerce", b.a("currencyCode", "INR", "remove", a.a(cJRGridProduct2, i3, cJRItem2, str4))), "removeFromCart");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final String str3 = str;
            final Context context2 = context;
            final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            final String str4 = str2;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, str3, "Customer_Id", a.b(context2), "vertical_name", a.f50685e, "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("id", "", "name", cJRHomePageItem2.getName(), "creative", str4, CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i3 + 1))))));
                        Map<String, Object> sourceInfo = cJRHomePageItem2.getSourceInfo();
                        if (sourceInfo != null) {
                            a2.put("promo_container_id", sourceInfo.get("source_container_id"));
                            a2.put("promo_container_instance_id", sourceInfo.get("source_container_instance_id"));
                        }
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            final int i3 = i2;
            final String str3 = str;
            final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            final Context context2 = context;
            final String str4 = str2;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionClick", SDKConstants.EVENT_KEY_SCREEN_NAME, str3, "destinationURL", cJRHomePageItem2.getURL(), "Customer_Id", a.b(context2), "vertical_name", a.f50685e, "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("name", cJRHomePageItem2.getName(), "creative", str4, CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i3 + 1))))));
                        Map<String, Object> sourceInfo = cJRHomePageItem2.getSourceInfo();
                        if (sourceInfo != null) {
                            a2.put("promo_container_id", sourceInfo.get("source_container_id"));
                            a2.put("promo_container_instance_id", sourceInfo.get("source_container_instance_id"));
                        }
                        a2.put("app_language", n.a(context2, n.a()));
                        a.b(a2, "promotion_click");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final Context context, final Map<String, Object> map) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        map.put("VERTICAL_NAME".toLowerCase(), GAUtil.MARKET_PLACE);
                        map.put("user_id", b.k());
                        map.put("Customer_Id", a.b(context));
                        map.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) map, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    static synchronized void a(Map<String, Object> map, String str, String str2) {
        synchronized (a.class) {
            if (str2 != null) {
                try {
                    HashMap hashMap = new HashMap(map);
                    hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, str2);
                    a(hashMap, str);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            } else {
                a(map, str);
            }
        }
    }

    public static synchronized <T> void a(T t, String str) {
        Class<a> cls = a.class;
        synchronized (cls) {
            try {
                c.a();
                boolean z = true;
                if (!c.a("paytm_ga_enabled", true)) {
                    c.a();
                    if (!c.a("paytm_ga_mall_enabled", false)) {
                        z = false;
                    }
                }
                if (!z) {
                    b.C0683b bVar = com.paytm.analytics.b.f40911e;
                    b.C0683b.c();
                    cls.getCanonicalName();
                } else if (!(t instanceof Map) || !((Map) t).isEmpty()) {
                    b.C0683b bVar2 = com.paytm.analytics.b.f40911e;
                    b.C0683b.a(new SignalEvent(str, t, 0));
                } else {
                    cls.getCanonicalName();
                }
            } catch (Exception e2) {
                cls.getCanonicalName();
                q.b(e2.getMessage());
            }
        }
    }

    public static void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str6 = str;
            final String str7 = str2;
            final ArrayList<String> arrayList2 = arrayList;
            final String str8 = str3;
            final Context context2 = context;
            final String str9 = str4;
            final String str10 = str5;
            handler.post(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:31:0x0072 A[SYNTHETIC, Splitter:B:31:0x0072] */
                /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[Catch:{ Exception -> 0x00d7 }] */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[Catch:{ Exception -> 0x00d7 }] */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa A[Catch:{ Exception -> 0x00d7 }] */
                /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[Catch:{ Exception -> 0x00d7 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r8 = this;
                        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00d7 }
                        r0.<init>()     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r1 = r2     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = "event_category"
                        java.lang.String r3 = ""
                        if (r1 != 0) goto L_0x0017
                        java.lang.String r1 = r2     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r2, r1)     // Catch:{ Exception -> 0x00d7 }
                        goto L_0x001a
                    L_0x0017:
                        r0.put(r2, r3)     // Catch:{ Exception -> 0x00d7 }
                    L_0x001a:
                        java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = "event_action"
                        if (r1 != 0) goto L_0x002a
                        java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r2, r1)     // Catch:{ Exception -> 0x00d7 }
                        goto L_0x002d
                    L_0x002a:
                        r0.put(r2, r3)     // Catch:{ Exception -> 0x00d7 }
                    L_0x002d:
                        java.util.ArrayList r1 = r4     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = "event_label"
                        if (r1 == 0) goto L_0x0065
                        java.util.ArrayList r1 = r4     // Catch:{ Exception -> 0x00d7 }
                        int r1 = r1.size()     // Catch:{ Exception -> 0x00d7 }
                        if (r1 <= 0) goto L_0x0065
                        java.util.ArrayList r1 = r4     // Catch:{ Exception -> 0x00d7 }
                        java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00d7 }
                        r4 = 1
                        r5 = 1
                    L_0x0043:
                        boolean r6 = r1.hasNext()     // Catch:{ Exception -> 0x00d7 }
                        if (r6 == 0) goto L_0x0068
                        java.lang.Object r6 = r1.next()     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00d7 }
                        if (r5 != r4) goto L_0x0053
                        r7 = r3
                        goto L_0x0057
                    L_0x0053:
                        java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
                    L_0x0057:
                        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r7 = r2.concat(r7)     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r7, r6)     // Catch:{ Exception -> 0x00d7 }
                        int r5 = r5 + 1
                        goto L_0x0043
                    L_0x0065:
                        r0.put(r2, r3)     // Catch:{ Exception -> 0x00d7 }
                    L_0x0068:
                        java.lang.String r1 = r5     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = "event_value"
                        if (r1 != 0) goto L_0x0078
                        java.lang.String r1 = r5     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r2, r1)     // Catch:{ Exception -> 0x00d7 }
                        goto L_0x0080
                    L_0x0078:
                        r1 = 0
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r2, r1)     // Catch:{ Exception -> 0x00d7 }
                    L_0x0080:
                        android.content.Context r1 = r6     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r1 = net.one97.paytm.j.a.b((android.content.Context) r1)     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        if (r1 != 0) goto L_0x00a2
                        java.lang.String r1 = "user_id"
                        android.content.Context r2 = r6     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = net.one97.paytm.j.a.b((android.content.Context) r2)     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r1 = "Customer_Id"
                        android.content.Context r2 = r6     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = net.one97.paytm.j.a.b((android.content.Context) r2)     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                    L_0x00a2:
                        java.lang.String r1 = r7     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        if (r1 != 0) goto L_0x00b1
                        java.lang.String r1 = "screenName"
                        java.lang.String r2 = r7     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                    L_0x00b1:
                        java.lang.String r1 = r8     // Catch:{ Exception -> 0x00d7 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
                        if (r1 != 0) goto L_0x00c4
                        java.lang.String r1 = "VERTICAL_NAME"
                        java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = r8     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                    L_0x00c4:
                        java.lang.String r1 = "app_language"
                        android.content.Context r2 = r6     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r2 = com.paytm.utility.n.a((android.content.Context) r2, com.paytm.utility.n.a())     // Catch:{ Exception -> 0x00d7 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                        java.lang.String r1 = "customEvent"
                        java.lang.String r2 = "custom_event"
                        net.one97.paytm.j.a.a((java.util.Map<java.lang.String, java.lang.Object>) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x00d7 }
                        return
                    L_0x00d7:
                        r0 = move-exception
                        java.lang.String r0 = r0.getMessage()
                        com.paytm.utility.q.b(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.j.a.AnonymousClass51.run():void");
                }
            });
        }
    }

    public static synchronized <T> void b(T t, String str) {
        synchronized (a.class) {
            a(t, str);
        }
    }

    public static void a(final Context context, final List<Map<String, String>> list, final String str, final String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (list != null && !list.isEmpty() && !((Map) list.get(0)).isEmpty() && ((Map) list.get(0)).containsKey("name")) {
                            String str = (String) ((Map) list.get(0)).get("name");
                            if (!TextUtils.isEmpty(str) && !str.contains("/-")) {
                                ((Map) list.get(0)).put("name", "/-".concat(String.valueOf(str)));
                            }
                        }
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, str, "Customer_Id", a.b(context), "ecommerce", b.a("promoView", b.a("promotions", list)));
                        a2.put("app_language", n.a(context, n.a()));
                        if (!TextUtils.isEmpty(str2)) {
                            a2.put("vertical_name", str2);
                        }
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Context context, final String str, final String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("event_category", "credit_card");
                        hashMap.put("recharge_utilities_business_sub_vertical", "credit_card");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("event_action", str);
                        }
                        String a2 = com.paytm.utility.a.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context));
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put("event_label", str2);
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "credit card");
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("event_category", str);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put("event_action", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            hashMap.put("event_label", str3);
                        }
                        String a2 = com.paytm.utility.a.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context));
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "recharges_utilities");
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("event_category", "credit_card");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("event_action", str);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put("event_label", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            hashMap.put("event_label2", str3);
                        }
                        String a2 = com.paytm.utility.a.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context));
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "credit card");
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final Context context2 = context;
            final String str8 = str4;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(str5)) {
                            hashMap.put("event_category", str5);
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            hashMap.put("event_action", str6);
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str7);
                        }
                        String a2 = com.paytm.utility.a.a(context2);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context2));
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            hashMap.put("event_label", str8);
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "recharges_utilities");
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void c(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("event_category", str + " (new)");
                        hashMap.put("recharge_utilities_business_sub_vertical", str + " (new)");
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put("event_action", str2);
                        }
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
                        String a2 = com.paytm.utility.a.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context));
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "recharges_utilities");
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final Context context, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "openScreen", "openScreen");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void d(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("event_category", "devotion");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("event_action", str);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put("event_label", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            hashMap.put("event_label2", str3);
                        }
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/devotion");
                        String a2 = com.paytm.utility.a.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put("user_id", a2);
                            hashMap.put("Customer_Id", a.b(context));
                        }
                        hashMap.put("VERTICAL_NAME".toLowerCase(), "wallet");
                        hashMap.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final CJRUtilityVariantV2 cJRUtilityVariantV2, final Context context, final int i2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(SDKConstants.EVENT_KEY_SCREEN_NAME, a.a("/devotion"), "promo_layout_type", "", "destinationURL", "", "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("name", "/devotion", "creative", cJRUtilityVariantV2.getFilterName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1))))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "promotion_click", "promotionClick");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void b(final CJRUtilityVariantV2 cJRUtilityVariantV2, final Context context, final int i2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        a.b(b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a("/devotion"), "promo_layout_type", "", "destinationURL", "", "Customer_Id", a.b(context), "vertical_name", "", "promo_widget_position", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("name", "/devotion", "creative", cJRUtilityVariantV2.getFilterName(), CLPConstants.ARGUMENT_KEY_POSITION, "slot" + (i2 + 1)))))), "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(final Map<String, Object> map, final Context context) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        map.put("Customer_Id", a.b(context));
                        map.put("app_language", n.a(context, n.a()));
                        a.a((Map<String, Object>) map, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str8 = str;
            final String str9 = str2;
            final String str10 = str3;
            final String str11 = str4;
            final Context context2 = context;
            final String str12 = str5;
            final String str13 = str6;
            final String str14 = str7;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map a2 = a.a(str8, str9, str10, str11, context2, str12, str13);
                        a2.put("app_language", n.a(context2, n.a()));
                        if (StringSet.all.equalsIgnoreCase(str14) || "signal".equalsIgnoreCase(str14)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, a2);
                            net.one97.paytm.notification.a.a();
                            net.one97.paytm.notification.a.a("customEvent", hashMap, str14);
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final Map<String, Object> map, final Context context, final String str2) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        if (map.containsKey("vertical_name") && map.get("vertical_name") != null) {
                            String.valueOf(map.get("vertical_name"));
                        }
                        map.put("app_language", n.a(context, n.a()));
                        if ("productClick".endsWith(str)) {
                            if (StringSet.all.equalsIgnoreCase(str2) || "signal".equalsIgnoreCase(str2)) {
                                net.one97.paytm.notification.a.a();
                                net.one97.paytm.notification.a.a("productClick", map, str2);
                            }
                        } else if (StringSet.all.equalsIgnoreCase(str2) || "signal".equalsIgnoreCase(str2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, map);
                            net.one97.paytm.notification.a.a();
                            net.one97.paytm.notification.a.a("customEvent", hashMap, str2);
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Handler handler = f50683c;
        if (handler != null) {
            final String str9 = str;
            final String str10 = str2;
            final String str11 = str3;
            final String str12 = str5;
            final Context context2 = context;
            final String str13 = str6;
            final String str14 = str7;
            final String str15 = str4;
            final String str16 = str8;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map a2 = a.a(str9, str10, str11, str12, context2, str13, str14);
                        a2.put("app_language", n.a(context2, n.a()));
                        if (!TextUtils.isEmpty(str15)) {
                            a2.put("event_label2", str15);
                        } else {
                            a2.put("event_label2", "");
                        }
                        if (StringSet.all.equalsIgnoreCase(str16) || "signal".equalsIgnoreCase(str16)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, a2);
                            net.one97.paytm.notification.a.a();
                            net.one97.paytm.notification.a.a("customEvent", hashMap, str16);
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final String str, final String str2, final Context context, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    if (context != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            a.a(hashMap, str, str2, context);
                            hashMap.put("app_language", n.a(context, n.a()));
                            if (StringSet.all.equalsIgnoreCase(str3) || "signal".equalsIgnoreCase(str3)) {
                                net.one97.paytm.notification.a.a();
                                net.one97.paytm.notification.a.a("openScreenDeviceInfo", hashMap, str3);
                            }
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            });
        }
    }

    public static void a(String str, String str2, String str3, Map<String, Object> map, Context context, String str4) {
        Handler handler = f50683c;
        if (handler != null) {
            final Map<String, Object> map2 = map;
            final String str5 = str3;
            final String str6 = str2;
            final String str7 = str;
            final String str8 = str4;
            final Context context2 = context;
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("vertical_name", "mini_app");
                        if (map2 != null) {
                            hashMap.putAll(map2);
                        }
                        hashMap.put("event_category", str5 != null ? str5 : str6);
                        Object obj = hashMap.get("mid");
                        if (obj != null) {
                            hashMap.put("event_action", "Mini App PG Tracking");
                            hashMap.put("event_label", obj.toString());
                        } else {
                            hashMap.put("event_action", "Bridge Analytics");
                            hashMap.put("event_label", str7);
                        }
                        hashMap.put("event_label2", "2.1.40-MB-07");
                        hashMap.put("event_label3", str8 != null ? str8 : str6);
                        hashMap.put("Customer_Id", a.b(context2));
                        hashMap.put("app_language", n.a(context2, n.a()));
                        a.a((Map<String, Object>) hashMap, "customEvent", GAUtil.CUSTOM_EVENT);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Map<String, Object> map, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("vertical_name", "mini_app");
                        if (map != null) {
                            hashMap.putAll(map);
                        }
                        a.a((Map<String, Object>) hashMap, "customEvent", str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static void a(final Context context, final String str, final String str2, final Map<String, Object> map) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("vertical_name", "mini_app");
                        if (map != null) {
                            hashMap.putAll(map);
                        }
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
                        hashMap.put("Customer_Id", a.b(context));
                        hashMap.put("app_language", n.a(context, n.a()));
                        String str = str;
                        String str2 = str;
                        str.equalsIgnoreCase(GAUtil.CUSTOM_EVENT);
                        a.a((Map<String, Object>) hashMap, str, str2);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Context context, final Map<String, Object> map, final String str) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ boolean f50995d = true;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ boolean f50996e = true;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ boolean f50997f = false;

                public final void run() {
                    try {
                        map.put("app_language", n.a(context, n.a()));
                        a.a(map, str);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, String str5, boolean z) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable(str, str2, hashMap, context, str3, str4, str5, z) {
                private final /* synthetic */ String f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ HashMap f$2;
                private final /* synthetic */ Context f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ String f$5;
                private final /* synthetic */ String f$6;
                private final /* synthetic */ boolean f$7;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                }

                public final void run() {
                    a.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
                }
            });
        }
    }

    public static void e(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "promo_layout_type", null, "destinationURL", null, "Customer_Id", a.b(context), "vertical_name", "", "promo_widget_position", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("dimension40", null, "id", null, "name", str2, "creative", str3, CLPConstants.ARGUMENT_KEY_POSITION, null)))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "promotion_click", "promotionClick");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void f(final Context context, final String str, final String str2, final String str3) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(AppConstants.NOTIFICATION_DETAILS.EVENT, "promotionImpression", SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "destinationURL", "", "Customer_Id", a.b(context), "vertical_name", "", "ecommerce", b.a("promoView", b.a("promotions", b.b(b.a("dimension40", "", "id", "", "name", str2, "creative", str3, CLPConstants.ARGUMENT_KEY_POSITION, "")))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.b(a2, "promotionImpression");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(final Context context, final String str, final Map<String, String> map) {
        Handler handler = f50683c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        Map<String, Object> a2 = b.a(SDKConstants.EVENT_KEY_SCREEN_NAME, a.a(str), "promo_layout_type", null, "destinationURL", null, "Customer_Id", a.b(context), "vertical_name", "", "promo_widget_position", "", "ecommerce", b.a("promoClick", b.a("promotions", b.b(b.a("dimension40", null, "id", null, "name", map.get("name"), "creative", map.get("creative"), Payload.RESPONSE, map.get(Payload.RESPONSE), CLPConstants.ARGUMENT_KEY_POSITION, null)))));
                        a2.put("app_language", n.a(context, n.a()));
                        a.a(a2, "promotion_click", "promotionClick");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, HashMap hashMap, Context context, String str3, String str4, String str5, boolean z) {
        try {
            HashMap hashMap2 = new HashMap();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            hashMap2.put("event_category", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            hashMap2.put("event_action", str2);
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            if (!TextUtils.isEmpty(b(context))) {
                hashMap2.put("user_id", b(context));
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap2.put("VERTICAL_NAME".toLowerCase(), str4);
            }
            hashMap2.put("Customer_Id", b(context));
            if (!StringSet.all.equalsIgnoreCase(str5) && !"signal".equalsIgnoreCase(str5)) {
                return;
            }
            if (z) {
                hashMap2.put(AppConstants.NOTIFICATION_DETAILS.EVENT, GAUtil.CUSTOM_EVENT);
                net.one97.paytm.notification.a.a();
                net.one97.paytm.notification.a.a(GAUtil.CUSTOM_EVENT, hashMap2, str5);
                return;
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put(AppConstants.NOTIFICATION_DETAILS.EVENT, hashMap2);
            net.one97.paytm.notification.a.a();
            net.one97.paytm.notification.a.a("customEvent", hashMap3, str5);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    static /* synthetic */ Map[] a(List list) {
        Map[] mapArr = new Map[list.size()];
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            mapArr[i2] = b((HashMap<String, String>) (HashMap) list.get(i2));
        }
        return mapArr;
    }

    static /* synthetic */ ArrayList a(List list, String str, String str2, int i2, String str3, Map map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            Map<String, Object> b2 = b((CJRGridProduct) list.get(i3), str, str2, i2 + i3 + 1, str3);
            if (map != null) {
                a(b2, (Map<String, Object>) map);
            }
            arrayList.add(b2);
        }
        return arrayList;
    }

    static /* synthetic */ Map a(CJRDetailProduct cJRDetailProduct, CJRItem cJRItem) {
        String str;
        String str2;
        if (cJRItem != null) {
            str2 = cJRItem.getListName();
            str = cJRItem.getSource();
        } else {
            str2 = "";
            str = str2;
        }
        if (str != null && !str.isEmpty()) {
            str2 = str2 + "/" + str;
        } else if (!(cJRDetailProduct == null || cJRDetailProduct.getmSource() == null || cJRDetailProduct.getmSource().isEmpty())) {
            str2 = str2 + "/" + cJRDetailProduct.getmSource();
        }
        Object[] objArr = new Object[2];
        objArr[0] = "detail";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "actionField";
        objArr2[1] = b.a("list", str2);
        objArr2[2] = "products";
        String allAncestors = cJRDetailProduct.getAllAncestors();
        HashMap<String, Object> a2 = a(cJRItem, cJRDetailProduct.getparentID());
        if (!(a2.get("dimension24") != "" || cJRDetailProduct == null || cJRDetailProduct.getmSource() == null)) {
            a2.put("dimension24", "/" + cJRDetailProduct.getmSource());
        }
        a2.put("id", cJRDetailProduct.getmProductID());
        a2.put("name", cJRDetailProduct.getName());
        a2.put("category", allAncestors);
        a2.put(CLPConstants.BRAND_PARAMS, cJRDetailProduct.getBrand());
        a2.put("price", cJRDetailProduct.getmDiscountedPrice());
        a2.put("quantity", Integer.valueOf(cJRDetailProduct.getmQuantity()));
        a2.put("dimension43", cJRDetailProduct.getAllAncestorsId());
        a2.put("dimension41", cJRDetailProduct.getmMerchant().getMerchantID());
        if (cJRItem != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cJRItem.getListPosition() + 1);
            a2.put(CLPConstants.ARGUMENT_KEY_POSITION, sb.toString());
        }
        Map<String, Object> map = null;
        boolean z = cJRItem instanceof CJRHomePageItem;
        if (z && (map = ((CJRHomePageItem) cJRItem).getSourceInfo()) != null) {
            a((Map<String, Object>) a2, map);
        }
        if (cJRItem instanceof CJRGridProduct) {
            map = ((CJRGridProduct) cJRItem).getSourceInfo();
        } else if (z) {
            map = ((CJRHomePageItem) cJRItem).getSourceInfo();
        }
        if (map != null) {
            a((Map<String, Object>) a2, map);
        }
        objArr2[3] = b.b(a2);
        objArr[1] = b.a(objArr2);
        return b.a(objArr);
    }

    static /* synthetic */ Map a(CJRCartProduct cJRCartProduct, String str) {
        if (TextUtils.isEmpty(str)) {
            str = cJRCartProduct.getVerticalLabel();
        }
        return b.a("products", b.b(b.a("id", cJRCartProduct.getProductId(), "name", cJRCartProduct.getName(), "category", str, CLPConstants.BRAND_PARAMS, cJRCartProduct.getBrand(), "variant", "", "price", cJRCartProduct.getDiscountedPrice(), "quantity", 1)));
    }

    static /* synthetic */ String a(String str, String str2, long j) {
        if (str.equalsIgnoreCase("Tickets")) {
            return "BusTicket";
        }
        if (str.equalsIgnoreCase("Wallet")) {
            return "Wallet";
        }
        if (!c(str2, str)) {
            return str.equalsIgnoreCase("Paytm Hotel") ? "Hotel" : GAUtil.MARKET_PLACE;
        }
        String b2 = b(str2, j, str);
        return !TextUtils.isEmpty(b2) ? b2 : "Recharge";
    }

    static /* synthetic */ Map a(CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str) {
        CJRCartProduct cJRCartProduct;
        CJRTrackingInfo trackingInfo;
        CJRTrackingInfo trackingInfo2;
        Object[] objArr = new Object[2];
        objArr[0] = "purchase";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "actionField";
        if (TextUtils.isEmpty(str) || str.trim().length() <= 0) {
            str = "Paytm Store - Android";
        }
        String promoCode = TextUtils.isEmpty(cJROrderSummary.getPromoCode()) ? "" : cJROrderSummary.getPromoCode();
        HashMap hashMap = new HashMap();
        hashMap.put("id", cJROrderSummary.getId());
        hashMap.put("affiliation", str);
        hashMap.put("revenue", String.valueOf(cJROrderSummary.getGrandTotal()));
        hashMap.put("tax", "0");
        hashMap.put("shipping", String.valueOf(cJROrderSummary.getShippingAmount()));
        if (cJRParcelTrackingInfo != null) {
            if (cJRParcelTrackingInfo.getCartItemsForTrackingInfo() != null && cJRParcelTrackingInfo.getCartItemsForTrackingInfo().size() == 1) {
                CJRCartProduct cJRCartProduct2 = cJRParcelTrackingInfo.getCartItemsForTrackingInfo().get(0);
                if (!(cJRCartProduct2 == null || (trackingInfo2 = cJRCartProduct2.getTrackingInfo()) == null || trackingInfo2.getListName() == null)) {
                    hashMap.put("list", String.valueOf(trackingInfo2.getListName()));
                }
            } else if (!(cJRParcelTrackingInfo.getCartItemsForTrackingInfo() == null || (cJRCartProduct = cJRParcelTrackingInfo.getCartItemsForTrackingInfo().get(cJRParcelTrackingInfo.getCartItemsForTrackingInfo().size() - 1)) == null || (trackingInfo = cJRCartProduct.getTrackingInfo()) == null || trackingInfo.getListName() == null)) {
                hashMap.put("list", String.valueOf(trackingInfo.getListName()));
            }
        }
        if (!TextUtils.isEmpty(promoCode)) {
            hashMap.put("coupon", promoCode);
        }
        objArr2[1] = hashMap;
        objArr2[2] = "products";
        objArr2[3] = a(cJROrderSummary, cJRParcelTrackingInfo);
        objArr[1] = b.a(objArr2);
        return b.a(objArr);
    }

    static /* synthetic */ Map a(CJRHomePageItem cJRHomePageItem, CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (cJRHomePageItem != null) {
            String searchType = cJRHomePageItem.getSearchType();
            String searchCategory = cJRHomePageItem.getSearchCategory();
            String searchTerm = cJRHomePageItem.getSearchTerm();
            String searchResultType = cJRHomePageItem.getSearchResultType();
            String listName = cJRHomePageItem.getListName();
            i2 = cJRHomePageItem.getListPosition() + 1;
            String str6 = searchCategory;
            str4 = searchType;
            str5 = listName;
            str = searchResultType;
            str2 = searchTerm;
            str3 = str6;
        } else {
            i2 = 0;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(cJRHomePageItem.getmContainerInstanceID())) {
            hashMap.put("dimension40", cJRHomePageItem.getmContainerInstanceID());
        }
        hashMap.put("id", String.valueOf(cJROrderSummaryProductDetail.getId()));
        hashMap.put("name", cJROrderSummaryProductDetail.getName());
        hashMap.put(CLPConstants.BRAND_PARAMS, cJROrderSummaryProductDetail.getBrandName());
        hashMap.put("price", Double.valueOf(cJROrderSummaryProductDetail.getDiscountedPrice()));
        hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, String.valueOf(i2));
        if (str5 != null) {
            hashMap.put("dimension24", str5);
        }
        hashMap.put("dimension25", String.valueOf(i2));
        hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
        if (str4 != null) {
            hashMap.put("dimension26", str4);
        }
        if (str3 != null) {
            hashMap.put("dimension27", str3);
        }
        if (str2 != null) {
            hashMap.put("dimension28", str2);
        }
        if (str != null) {
            hashMap.put("dimension29", str);
        }
        hashMap.put("dimension31", cJROrderSummaryProductDetail.getParentId());
        hashMap.put("dimension38", cJRHomePageItem.getListId());
        return hashMap;
    }

    static /* synthetic */ Map a(ArrayList arrayList, int i2) {
        Object[] objArr = new Object[2];
        objArr[0] = "checkout";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "actionField";
        HashMap hashMap = new HashMap();
        hashMap.put("step", Integer.valueOf(i2));
        if (arrayList.size() == 1 && ((CJRCartProduct) arrayList.get(0)).getTrackingInfo() != null && ((CJRCartProduct) arrayList.get(0)).getTrackingInfo().getListName() != null) {
            hashMap.put("list", ((CJRCartProduct) arrayList.get(0)).getTrackingInfo().getListName());
        } else if (((CJRCartProduct) arrayList.get(0)).getVerticalLabel().equalsIgnoreCase("recharge") && ((CJRCartProduct) arrayList.get(arrayList.size() - 1)).getTrackingInfo() != null) {
            hashMap.put("list", ((CJRCartProduct) arrayList.get(arrayList.size() - 1)).getTrackingInfo().getListName());
        }
        objArr2[1] = hashMap;
        objArr2[2] = "products";
        objArr2[3] = a((ArrayList<CJRCartProduct>) arrayList);
        objArr[1] = b.a(objArr2);
        return b.a(objArr);
    }

    static /* synthetic */ Map a(CJRGridProduct cJRGridProduct, String str, String str2, int i2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(cJRGridProduct.getmContainerInstanceID())) {
            hashMap.put("dimension40", cJRGridProduct.getmContainerInstanceID());
        }
        hashMap.put("id", cJRGridProduct.getProductID());
        hashMap.put("name", cJRGridProduct.getName());
        hashMap.put(CLPConstants.BRAND_PARAMS, cJRGridProduct.getBrand());
        hashMap.put("variant", "");
        hashMap.put("category", str2);
        hashMap.put("price", cJRGridProduct.getDiscountedPrice());
        hashMap.put("dimension24", str);
        hashMap.put("dimension25", Integer.valueOf(i2));
        hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
        hashMap.put("dimension31", cJRGridProduct.getParentID());
        hashMap.put("dimension38", cJRGridProduct.getListId());
        hashMap.put("dimension43", str3);
        a((Map<String, Object>) hashMap, cJRGridProduct.getSourceInfo());
        return hashMap;
    }

    static /* synthetic */ Map a(CJRGridProduct cJRGridProduct, int i2, CJRItem cJRItem, String str) {
        String listName;
        HashMap hashMap = new HashMap();
        if (!(cJRItem == null || (listName = cJRItem.getListName()) == null || listName.isEmpty())) {
            String source = cJRItem.getSource();
            if (source != null && !source.isEmpty()) {
                listName = listName + "/" + source;
            }
            hashMap.put("list", listName);
        }
        if (!hashMap.containsKey("list") && cJRGridProduct != null && cJRGridProduct.getSource() != null && !cJRGridProduct.getSource().isEmpty()) {
            hashMap.put("list", "/" + cJRGridProduct.getSource());
        }
        Object[] objArr = new Object[4];
        objArr[0] = "actionField";
        objArr[1] = hashMap;
        objArr[2] = "products";
        Object[] objArr2 = new Object[1];
        HashMap<String, Object> a2 = a(cJRItem, cJRGridProduct.getParentID());
        if (!a2.containsKey("dimension24") && cJRGridProduct != null && cJRGridProduct.getSource() != null && !cJRGridProduct.getSource().isEmpty()) {
            a2.put("dimension24", "/" + cJRGridProduct.getSource());
        }
        a2.put("id", cJRGridProduct.getProductID());
        a2.put("name", cJRGridProduct.getName());
        a2.put("category", str);
        a2.put(CLPConstants.BRAND_PARAMS, cJRGridProduct.getBrand());
        a2.put("price", cJRGridProduct.getDiscountedPrice());
        a2.put("quantity", Integer.valueOf(i2));
        a2.put("dimension43", cJRGridProduct.getAncestorID());
        if (cJRItem != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cJRItem.getListPosition() + 1);
            a2.put(CLPConstants.ARGUMENT_KEY_POSITION, sb.toString());
        }
        objArr2[0] = a2;
        objArr[3] = b.b(objArr2);
        return b.a(objArr);
    }

    static /* synthetic */ Map a(String str, String str2, String str3, String str4, Context context, String str5, String str6) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_category", str);
        } else {
            hashMap.put("event_category", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        } else {
            hashMap.put("event_action", "");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        } else {
            hashMap.put("event_label", "");
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_value", str4);
        } else {
            hashMap.put("event_value", 0);
        }
        if (!TextUtils.isEmpty(b(context))) {
            hashMap.put("user_id", b(context));
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("VERTICAL_NAME".toLowerCase(), str6);
        }
        return hashMap;
    }

    static /* synthetic */ void a(HashMap hashMap, String str, String str2, Context context) {
        hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("vertical_name", str2);
        hashMap.put("Device_Brand", com.paytm.utility.a.e());
        hashMap.put("Device_Name", com.paytm.utility.a.f());
        a(context, (Map<String, Object>) hashMap);
        String a2 = a(context);
        if (a2 != null) {
            hashMap.put("IMEI", Base64.encodeToString(a2.getBytes(), 0));
        }
        String d2 = com.paytm.utility.a.d(context);
        if (d2 != null) {
            hashMap.put("Custom_Device_ID", Base64.encodeToString(d2.getBytes(), 0));
        }
        if (com.paytm.utility.a.q(context) != null) {
            if (!TextUtils.isEmpty(com.paytm.utility.a.a(context))) {
                hashMap.put("Customer_Id", com.paytm.utility.a.a(context));
            }
            String b2 = com.paytm.utility.a.b(context);
            if (b2 != null) {
                hashMap.put("Contact_Number", Base64.encodeToString(b2.getBytes(), 0));
            }
            String c2 = com.paytm.utility.a.c(context);
            if (c2 != null) {
                hashMap.put("user_email", Base64.encodeToString(c2.getBytes(), 0));
            }
        }
    }
}
