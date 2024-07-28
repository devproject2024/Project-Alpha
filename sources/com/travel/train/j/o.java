package com.travel.train.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.activity.AJRTrainOrderSummaryNew;
import com.travel.train.model.d;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainSmartIcons;
import com.travel.train.model.trainticket.CJRTrainValue;
import com.travel.train.model.trainticket.c;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f27579a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f27580b = 9999;

    /* renamed from: c  reason: collision with root package name */
    public static int f27581c = 1800;

    /* renamed from: d  reason: collision with root package name */
    private static String f27582d = "Male";

    /* renamed from: e  reason: collision with root package name */
    private static String f27583e = "Female";

    /* renamed from: f  reason: collision with root package name */
    private static String f27584f = "Transgender";

    /* renamed from: g  reason: collision with root package name */
    private static String f27585g = "M";

    /* renamed from: h  reason: collision with root package name */
    private static String f27586h = "F";

    /* renamed from: i  reason: collision with root package name */
    private static String f27587i = "T";
    private static String j = "Non-Veg";
    private static String k = "Veg";
    private static String l = "No food";
    private static String m = "CJRTrainUtils";

    public static Intent a(Context context) {
        return new Intent(context, AJRTrainOrderSummaryNew.class);
    }

    public static String a(String str) {
        if (str.length() == 0) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    public static String a(Context context, String str) {
        if (str == null || !URLUtil.isValidUrl(str) || b(context) == null) {
            return str;
        }
        return v.a(str, AppConstants.AND_SIGN, com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, "=", b(context));
    }

    public static String b(Context context, String str) {
        if (str == null || !URLUtil.isValidUrl(str)) {
            return str;
        }
        if (b(context) != null) {
            str = v.a(str, AppConstants.AND_SIGN, "user_email", "=", b(context));
        }
        if (c(context) == null) {
            return str;
        }
        return v.a(str, AppConstants.AND_SIGN, "user_mobile", "=", c(context));
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean b(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NullPointerException | NumberFormatException unused) {
            return false;
        }
    }

    public static void a(View view) {
        int i2;
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i3 = layoutParams.height;
            if (i3 > 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, i2);
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public static <T> T a(Map<String, Object> map, String str, T t) {
        return map.containsKey(str) ? map.get(str) : t;
    }

    public static boolean c(String str) {
        String trim = str.trim();
        if (trim.length() != 10) {
            return false;
        }
        for (int i2 = 0; i2 < trim.length(); i2++) {
            if (!Character.isDigit(trim.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str) {
        return str.trim().matches(com.business.merchant_payments.common.utility.AppConstants.EMAIL_REG_EX);
    }

    public static a.C0715a e(String str) {
        if (str.equalsIgnoreCase("get")) {
            return a.C0715a.GET;
        }
        if (str.equalsIgnoreCase("post")) {
            return a.C0715a.POST;
        }
        if (str.equalsIgnoreCase("put")) {
            return a.C0715a.PUT;
        }
        if (str.equalsIgnoreCase("delete")) {
            return a.C0715a.DELETE;
        }
        return a.C0715a.GET;
    }

    public static void a(List<com.travel.train.model.trainticket.a> list, String[] strArr) {
        boolean z;
        for (String str : strArr) {
            Iterator<com.travel.train.model.trainticket.a> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().getContactNumber().equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                a aVar = a.f27481b;
                com.travel.train.model.trainticket.a aVar2 = new com.travel.train.model.trainticket.a("", str);
                aVar2.setColor(aVar.a());
                list.add(aVar2);
            }
        }
    }

    public static void b(List<c> list, String[] strArr) {
        boolean z;
        for (String str : strArr) {
            Iterator<c> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().getEmail().equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(new c("", str));
            }
        }
    }

    private static String b(Context context) {
        return w.a(context.getApplicationContext()).b(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, "", true);
    }

    private static String c(Context context) {
        return w.a(context.getApplicationContext()).b("mobile", "", true);
    }

    public static boolean a(int i2, int i3, int i4) {
        if (i4 <= f27580b && i4 >= f27581c && i3 > 0 && i3 <= 12 && i2 > 0 && i2 <= 31) {
            if (i3 != 2) {
                return !(i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) || i2 <= 30;
            }
            return (i4 % 4 == 0 && i4 % 100 != 0) || i4 % 400 == 0 ? i2 <= 29 : i2 <= 28;
        }
    }

    public static d b(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new d(displayMetrics.heightPixels, displayMetrics.widthPixels);
    }

    public static int a(Context context, String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Color.parseColor(str);
            } catch (Exception unused) {
            }
        }
        return androidx.core.content.b.c(context, i2);
    }

    public static void a(String str, String str2, String str3, String str4, Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str);
            hashMap.put("user_id", b.n(context));
            hashMap.put("event_action", str3);
            hashMap.put("event_label", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str4);
            hashMap.put(net.one97.paytm.common.utility.d.cv, "train");
            com.travel.train.b.a();
            com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
            com.travel.train.b.a();
            com.travel.train.b.a(GAUtil.CUSTOM_EVENT, str4, str, str3, com.travel.common.a.c.TRAIN, hashMap);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Context context, Map<String, Object> map) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str);
            hashMap.put("user_id", b.n(context));
            hashMap.put("event_action", str8);
            if (map != null) {
                hashMap.putAll(map);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("event_label", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("event_label2", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("event_label3", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                hashMap.put("event_label5", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("event_label5", str7);
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str9);
            hashMap.put(net.one97.paytm.common.utility.d.cv, "train");
            com.travel.train.b.a();
            com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
            com.travel.train.b.a();
            com.travel.train.b.a(GAUtil.CUSTOM_EVENT, str9, str, str8, com.travel.common.a.c.TRAIN, hashMap);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean f(String str) {
        return URLUtil.isValidUrl(str);
    }

    public static String a(List<CJRTrainValue> list) {
        String str = "";
        for (CJRTrainValue next : list) {
            if (next.isAmount()) {
                str = next.getText();
            }
        }
        return str;
    }

    public static String b(List<CJRTrainValue> list) {
        String str = "";
        for (CJRTrainValue next : list) {
            if (next.isAmount()) {
                str = next.getServerAmount();
            }
        }
        return str;
    }

    public static CJRTrainFareDetail a(int i2, CJRTrainConfirmation cJRTrainConfirmation) {
        if (cJRTrainConfirmation == null || cJRTrainConfirmation.getFareDetails() == null || cJRTrainConfirmation.getFareDetails().size() <= 0) {
            return null;
        }
        for (CJRTrainFareDetail next : cJRTrainConfirmation.getFareDetails()) {
            if (next.getKey() == i2) {
                return next;
            }
        }
        return null;
    }

    public static String a(Integer num, CJRTrainConfirmation cJRTrainConfirmation) {
        StringBuilder sb = new StringBuilder();
        List<CJRTrainFareDetail> fareDetails = cJRTrainConfirmation.getFareDetails();
        if (fareDetails != null) {
            for (int i2 = 0; i2 < fareDetails.size(); i2++) {
                CJRTrainFareDetail cJRTrainFareDetail = fareDetails.get(i2);
                if (cJRTrainFareDetail.getKey() == num.intValue()) {
                    for (CJRTrainValue text : cJRTrainFareDetail.getValue()) {
                        sb.append(text.getText());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equalsIgnoreCase(f27583e) || str.equalsIgnoreCase(f27586h) || str.equalsIgnoreCase(f27582d) || str.equalsIgnoreCase(f27585g) || str.equalsIgnoreCase(f27584f) || str.equalsIgnoreCase(f27587i)) {
            return true;
        }
        return false;
    }

    public static void a(String str, String str2, String str3, String str4, Map<String, Object> map, Context context) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e2) {
                q.c(e2.getMessage());
                return;
            }
        }
        new HashMap();
        map.put("train_origin_city", str2);
        map.put("train_destination_city", str3);
        if (str4 == null) {
            str4 = "";
        }
        map.put("train_user_id", str4);
        map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
        com.travel.train.b.a();
        com.travel.train.b.b().a(str, map, context);
    }

    public static String h(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -2094986048:
                    if (lowerCase.equals("No choice")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -1859875259:
                    if (lowerCase.equals("upper berth")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1646244616:
                    if (lowerCase.equals("middle berth")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1354573888:
                    if (lowerCase.equals("couple")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -390194149:
                    if (lowerCase.equals("side lower berth")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 94415849:
                    if (lowerCase.equals("cabin")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 187878652:
                    if (lowerCase.equals("side upper berth")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1479279742:
                    if (lowerCase.equals("side middle")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 1856563079:
                    if (lowerCase.equals("window side")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1857019236:
                    if (lowerCase.equals("lower berth")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return "LB";
                case 1:
                    return "UB";
                case 2:
                    return "MB";
                case 3:
                    return "SU";
                case 4:
                    return "SL";
                case 5:
                    return "WS";
                case 6:
                    return "CB";
                case 7:
                    return "CP";
                case 8:
                    return "SM";
                case 9:
                    return "NC";
            }
        }
        return "";
    }

    public static String i(String str) {
        if (str != null) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2143) {
                if (hashCode != 2157) {
                    if (hashCode != 2422) {
                        if (hashCode != 2453) {
                            if (hashCode != 2485) {
                                if (hashCode != 2658) {
                                    if (hashCode != 2701) {
                                        if (hashCode != 2780) {
                                            if (hashCode != 2649) {
                                                if (hashCode == 2650 && str.equals("SM")) {
                                                    c2 = 8;
                                                }
                                            } else if (str.equals("SL")) {
                                                c2 = 4;
                                            }
                                        } else if (str.equals("WS")) {
                                            c2 = 5;
                                        }
                                    } else if (str.equals("UB")) {
                                        c2 = 1;
                                    }
                                } else if (str.equals("SU")) {
                                    c2 = 3;
                                }
                            } else if (str.equals("NC")) {
                                c2 = 9;
                            }
                        } else if (str.equals("MB")) {
                            c2 = 2;
                        }
                    } else if (str.equals("LB")) {
                        c2 = 0;
                    }
                } else if (str.equals("CP")) {
                    c2 = 7;
                }
            } else if (str.equals("CB")) {
                c2 = 6;
            }
            switch (c2) {
                case 0:
                    return "lower berth";
                case 1:
                    return "upper berth";
                case 2:
                    return "middle berth";
                case 3:
                    return "side upper berth";
                case 4:
                    return "side lower berth";
                case 5:
                    return "window side";
                case 6:
                    return "cabin";
                case 7:
                    return "couple";
                case 8:
                    return "side middle";
                case 9:
                    return "No choice";
            }
        }
        return "";
    }

    public static String a(String str, Context context) {
        if (context == null) {
            return "";
        }
        if (str.equalsIgnoreCase(g.V)) {
            return "M";
        }
        if (str.equalsIgnoreCase(g.W)) {
            return AppConstants.FEED_SUB_TYPE;
        }
        if (str.equalsIgnoreCase(g.X)) {
            return "T";
        }
        return "";
    }

    public static String j(String str) {
        if (str == null || !str.equalsIgnoreCase(k)) {
            return (str == null || !str.equalsIgnoreCase(j)) ? UpiConstants.DEFAULT_ACCOUNT_CONSTANT : UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT;
        }
        return "V";
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String k(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 68
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x0027
            r1 = 78
            if (r0 == r1) goto L_0x001d
            r1 = 86
            if (r0 == r1) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            java.lang.String r0 = "V"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0031
            r4 = 1
            goto L_0x0032
        L_0x001d:
            java.lang.String r0 = "N"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0031
            r4 = 0
            goto L_0x0032
        L_0x0027:
            java.lang.String r0 = "D"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0031
            r4 = 2
            goto L_0x0032
        L_0x0031:
            r4 = -1
        L_0x0032:
            if (r4 == 0) goto L_0x0041
            if (r4 == r3) goto L_0x003e
            if (r4 == r2) goto L_0x003b
            java.lang.String r4 = ""
            goto L_0x0043
        L_0x003b:
            java.lang.String r4 = "No food"
            goto L_0x0043
        L_0x003e:
            java.lang.String r4 = "Veg"
            goto L_0x0043
        L_0x0041:
            java.lang.String r4 = "Non-Veg"
        L_0x0043:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.o.k(java.lang.String):java.lang.String");
    }

    public static String a(Double d2) {
        if (d2 != null) {
            return new DecimalFormat("00.00").format(d2);
        }
        return null;
    }

    public static ArrayList<CJRTrainSmartIcons> a() {
        ArrayList<CJRTrainSmartIcons> arrayList = new ArrayList<>();
        CJRTrainSmartIcons cJRTrainSmartIcons = new CJRTrainSmartIcons();
        cJRTrainSmartIcons.setName("BOOK TICKETS");
        cJRTrainSmartIcons.setUrlType("book_tickets");
        cJRTrainSmartIcons.setImageUrl("");
        cJRTrainSmartIcons.setUrl("paytmmp://trainticket?landing=book_tickets");
        CJRTrainSmartIcons cJRTrainSmartIcons2 = new CJRTrainSmartIcons();
        cJRTrainSmartIcons2.setName("PNR STATUS");
        cJRTrainSmartIcons2.setUrlType("pnr_status");
        cJRTrainSmartIcons2.setImageUrl("");
        cJRTrainSmartIcons2.setUrl("paytmmp://trainticket?landing=pnr_status");
        CJRTrainSmartIcons cJRTrainSmartIcons3 = new CJRTrainSmartIcons();
        cJRTrainSmartIcons3.setName("LIVE STATUS");
        cJRTrainSmartIcons3.setUrlType("live_train_status");
        cJRTrainSmartIcons3.setImageUrl("");
        cJRTrainSmartIcons3.setUrl("paytmmp://trainticket?landing=live_train_status");
        CJRTrainSmartIcons cJRTrainSmartIcons4 = new CJRTrainSmartIcons();
        cJRTrainSmartIcons4.setName("METRO");
        cJRTrainSmartIcons4.setUrlType("metro_rail");
        cJRTrainSmartIcons4.setImageUrl("");
        cJRTrainSmartIcons4.setUrl("paytmmp://trainticket?landing=metro_rail&modeid=dmrc");
        arrayList.add(cJRTrainSmartIcons);
        arrayList.add(cJRTrainSmartIcons2);
        arrayList.add(cJRTrainSmartIcons3);
        arrayList.add(cJRTrainSmartIcons4);
        return arrayList;
    }

    public static String a(int i2, String str) {
        if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                long time = simpleDateFormat.parse(str).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                return i.d(simpleDateFormat.format(new Date(time)), "yyyy-MM-dd", "EEE, dd MMM");
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    public static String c(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (IOException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }
}
