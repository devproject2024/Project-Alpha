package com.travel.flight.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.google.gson.b.a;
import com.paytm.utility.b.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.m;
import com.travel.flight.pojo.f;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.b;
import com.travel.flight.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static String a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            for (Map.Entry next : hashMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(AppConstants.AND_SIGN);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), AppConstants.UTF_8));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), AppConstants.UTF_8));
            }
        } catch (UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i2) {
        if (!URLUtil.isValidUrl(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("requestId", str2);
        if (i2 == 1) {
            buildUpon.appendQueryParameter("is_manual_promocode", "true");
        }
        return buildUpon.build().toString();
    }

    public static String a(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("HH:mm").format(date);
        } catch (Exception unused2) {
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String b(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("HH:mm").format(date);
        } catch (Exception unused2) {
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String c(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("E, dd MMM yy").format(date);
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String d(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("dd MMM, E").format(date);
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String e(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("E, dd MMM").format(date);
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 12) {
            return str;
        }
        String substring = str.substring(0, 9);
        if (substring.trim().length() <= 0) {
            return substring;
        }
        return substring + AppConstants.DOTS;
    }

    public static boolean a(Context context, b bVar, b bVar2) {
        if (context == null) {
            return false;
        }
        try {
            ArrayList<b> c2 = c(context, "flight-recent-city-source");
            ArrayList<b> c3 = c(context, "flight-recent-city-destination");
            if (c2 == null) {
                c2 = new ArrayList<>(3);
            }
            if (c3 == null) {
                c3 = new ArrayList<>(3);
            }
            bVar.setItemType(1);
            int a2 = a(bVar.getShortCityName(), c2);
            if (a2 != -1 && a2 < 3) {
                c2.remove(a2);
            }
            if (c2.size() == 3) {
                c2.remove(c2.size() - 1);
            }
            c2.add(0, bVar);
            int a3 = a(bVar2.getShortCityName(), c3);
            if (a3 != -1 && a3 < 3) {
                c3.remove(a3);
            }
            if (c3.size() == 3) {
                c3.remove(c3.size() - 1);
            }
            c3.add(0, bVar2);
            a(context, "flight-recent-city-source", c2);
            a(context, "flight-recent-city-destination", c3);
            return true;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, f fVar) {
        if (context == null) {
            return false;
        }
        try {
            ArrayList<f> a2 = a(context, "flight_recent_search_details");
            if (a2 == null) {
                a2 = new ArrayList<>(5);
            }
            int a3 = a(fVar, a2);
            if (a3 != -1 && a3 < 5) {
                a2.remove(a3);
            }
            if (a2.size() == 5) {
                a2.remove(4);
            }
            a2.add(0, fVar);
            i.a(context.getApplicationContext()).a("flight_recent_search_details", new com.google.gsonhtcfix.f().a((Object) a2, new a<ArrayList<f>>() {
            }.getType()), false);
            return true;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    private static int a(String str, ArrayList<b> arrayList) {
        if (!(str == null || arrayList == null)) {
            Iterator<b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (next.getShortCityName().equalsIgnoreCase(str)) {
                    return arrayList.indexOf(next);
                }
            }
        }
        return -1;
    }

    private static int a(f fVar, ArrayList<f> arrayList) {
        if (!(fVar == null || arrayList == null)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f fVar2 = arrayList.get(i2);
                if (fVar2.getSourceShortCityName().equalsIgnoreCase(fVar.getSourceShortCityName()) && fVar2.getDestShortCityName().equalsIgnoreCase(fVar.getDestShortCityName()) && fVar.isRoundTrip() == fVar2.isRoundTrip()) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static ArrayList<f> a(Context context, String str) {
        Type type = new a<ArrayList<f>>() {
        }.getType();
        String b2 = i.a(context.getApplicationContext()).b(str, "", false);
        if (b2 != null && !b2.isEmpty()) {
            try {
                return (ArrayList) new com.google.gsonhtcfix.f().a(b2, type);
            } catch (Exception unused) {
                m mVar = new m("null check for getRecentSearchItemFromPref ", b2, "NA", "NA", "NA", "NA", "NA");
                j.a aVar = j.f25593a;
                j.a.a(mVar);
            }
        }
        return null;
    }

    private static ArrayList<b> c(Context context, String str) {
        Type type = new a<ArrayList<b>>() {
        }.getType();
        String b2 = i.a(context.getApplicationContext()).b(str, "", false);
        if (b2 != null) {
            return (ArrayList) new com.google.gsonhtcfix.f().a(b2, type);
        }
        return null;
    }

    public static boolean a(Context context, boolean z) {
        if (context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(i.a(context.getApplicationContext()).b(z ? "FLIGHT_NON_STOP_CHECK_ROUND_TRIP" : "FLIGHT_NON_STOP_CHECK_ONE_WAY", "", false))) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            return Boolean.parseBoolean(i.a(context.getApplicationContext()).b(z ? "FLIGHT_NON_STOP_CHECK_ROUND_TRIP" : "FLIGHT_NON_STOP_CHECK_ONE_WAY", "false", false));
        } catch (Exception unused) {
            return false;
        }
    }

    private static void a(Context context, String str, ArrayList<b> arrayList) {
        i.a(context.getApplicationContext()).a(str, new com.google.gsonhtcfix.f().a((Object) arrayList, new a<ArrayList<b>>() {
        }.getType()), false);
    }

    public static String g(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
        }
        return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(date);
    }

    public static String a(double d2) {
        try {
            return new DecimalFormat("##,##,##,##,##,##,###").format(d2);
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x001d
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "##,##,##,##,##,##,###"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0018 }
            double r1 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x0018 }
            int r1 = (int) r1     // Catch:{ Exception -> 0x0018 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r3 = r0.format(r1)     // Catch:{ Exception -> 0x0018 }
            return r3
        L_0x0018:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x001c }
        L_0x001c:
            return r3
        L_0x001d:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.utils.c.i(java.lang.String):java.lang.String");
    }

    public static String a(boolean z, String str, String str2) {
        String str3;
        String str4 = z ? "&combined_priceid=" : "&priceid=";
        if (str != null && str2 != null) {
            str3 = str4 + "{\"onward\":\"" + str + "\", \"return\":\"" + str2 + "\"}";
        } else if (str != null) {
            str3 = str4 + "{\"onward\":\"" + str + "\"}";
        } else if (str2 != null) {
            str3 = str4 + "{\"return\":\"" + str2 + "\"}";
        } else {
            str3 = "";
        }
        if (str3 == "") {
            return str3;
        }
        try {
            return URLEncoder.encode(str3, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
            return str3;
        }
    }

    public static String a(String str, Context context) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return context.getString(R.string.flight_msg_traveller_mobile_number);
        }
        return !Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str.trim()).matches() ? context.getString(R.string.msg_invalid_traveller_mobile_number) : "success";
    }

    public static String b(String str, Context context) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return context.getResources().getString(R.string.flight_msg_traveller_email_id);
        }
        return !Pattern.compile(com.business.merchant_payments.common.utility.AppConstants.EMAIL_REG_EX).matcher(str.trim()).matches() ? context.getString(R.string.msg_invalid_traveller_email_id) : "success";
    }

    public static String a(CJRDynamicValidation cJRDynamicValidation, Context context) {
        String str = cJRDynamicValidation.getmValue();
        boolean z = false;
        if (str == null || TextUtils.isEmpty(str.trim())) {
            if (cJRDynamicValidation.isOptional() != null && cJRDynamicValidation.isOptional().booleanValue()) {
                return "success";
            }
            return String.format(context.getString(R.string.flight_missing_field_txt), new Object[]{cJRDynamicValidation.getValue()});
        } else if (cJRDynamicValidation.getMinLength() == null || cJRDynamicValidation.getMaxLength() == null) {
            return "success";
        } else {
            if (cJRDynamicValidation.getRegex() == null || cJRDynamicValidation.getRegexErrorMessage() == null) {
                if (cJRDynamicValidation.getMinLength() == null || cJRDynamicValidation.getMaxLength() == null) {
                    return "success";
                }
                if (!(str.trim().length() > cJRDynamicValidation.getMaxLength().intValue()) && !(str.trim().length() < cJRDynamicValidation.getMinLength().intValue())) {
                    return "success";
                }
                return String.format(context.getString(R.string.flight_incorrect_field_txt), new Object[]{cJRDynamicValidation.getValue()});
            } else if (l(cJRDynamicValidation.getRegex())) {
                boolean z2 = (!str.trim().matches(cJRDynamicValidation.getRegex())) | (str.trim().length() < cJRDynamicValidation.getMinLength().intValue());
                if (str.trim().length() > cJRDynamicValidation.getMaxLength().intValue()) {
                    z = true;
                }
                if (z2 || z) {
                    return cJRDynamicValidation.getRegexErrorMessage();
                }
                return "success";
            } else {
                if (!(str.trim().length() > cJRDynamicValidation.getMaxLength().intValue()) && !(str.trim().length() < cJRDynamicValidation.getMinLength().intValue())) {
                    return "success";
                }
                return String.format(context.getString(R.string.flight_incorrect_field_txt), new Object[]{cJRDynamicValidation.getValue()});
            }
        }
    }

    private static boolean l(String str) {
        try {
            Pattern.compile(str);
            return true;
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String a(Context context) {
        return context.getResources().getString(R.string.flight_fare_for_one_adult_string);
    }

    public static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (ParseException e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.b(e3.getMessage());
            }
            return "";
        }
    }

    public static JSONObject a(Context context, CJRTpUserProfileContact cJRTpUserProfileContact) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(cJRTpUserProfileContact.getPerson_id())) {
                jSONObject.put("person_id", cJRTpUserProfileContact.getPerson_id());
            }
            jSONObject.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
            return jSONObject;
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String a(CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment.getmPGParams() == null || !cJRRechargePayment.getmPGParams().containsKey("TXN_AMOUNT")) {
            return cJRRechargePayment.getTxnAmount();
        }
        return String.valueOf(cJRRechargePayment.getmPGParams().get("TXN_AMOUNT"));
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int a(CJRFlightDetails cJRFlightDetails) {
        Double valueOf = Double.valueOf(0.0d);
        try {
            if (cJRFlightDetails.getmConvenienceFee() != null) {
                valueOf = Double.valueOf(cJRFlightDetails.getmConvenienceFee().getAdultDetail().getmConvFee());
            }
        } catch (Exception unused) {
        }
        return valueOf.intValue();
    }

    public static void a(String str, ImageView imageView) {
        com.travel.flight.b.a();
        String r = com.travel.flight.b.b().r();
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = r + str + ".png";
                if (URLUtil.isValidUrl(str2)) {
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
                    a2.f43753a = str2;
                    a2.a((Object) Integer.valueOf(R.drawable.pre_f_defaultcarrier)).b(Integer.valueOf(R.drawable.pre_f_defaultcarrier)).a(imageView);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String a(CJRFlightSearchInput cJRFlightSearchInput, Context context) {
        if (cJRFlightSearchInput == null || context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cJRFlightSearchInput.getmCount_adults());
        sb.append(" ");
        sb.append(context.getString(cJRFlightSearchInput.getmCount_adults() == 1 ? R.string.adult : R.string.adults));
        String sb2 = sb.toString();
        if (cJRFlightSearchInput.getmCount_childerns() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(", ");
            sb3.append(cJRFlightSearchInput.getmCount_childerns());
            sb3.append(" ");
            sb3.append(context.getString(cJRFlightSearchInput.getmCount_childerns() == 1 ? R.string.child : R.string.childrens));
            sb2 = sb3.toString();
        }
        if (cJRFlightSearchInput.getmCount_infants() <= 0) {
            return sb2;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append(", ");
        sb4.append(cJRFlightSearchInput.getmCount_infants());
        sb4.append(" ");
        sb4.append(context.getString(cJRFlightSearchInput.getmCount_infants() == 1 ? R.string.infant : R.string.infants));
        return sb4.toString();
    }

    public static String b(CJRFlightSearchInput cJRFlightSearchInput, Context context) {
        if (TextUtils.isEmpty(cJRFlightSearchInput.getClassType())) {
            return "";
        }
        if ("B".equals(cJRFlightSearchInput.getClassType())) {
            return context.getResources().getString(R.string.business);
        }
        if ("E".equals(cJRFlightSearchInput.getClassType())) {
            return context.getResources().getString(R.string.economy_flight);
        }
        if (AppConstants.FEED_COMMUNITY_POST.equals(cJRFlightSearchInput.getClassType())) {
            return context.getResources().getString(R.string.premium_economy);
        }
        return "";
    }

    public static String a(long j, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String a(long j, String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return simpleDateFormat.format(instance.getTime());
    }

    public static int j(String str) {
        int i2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i4 = 0;
        for (String str2 : str.split(" ")) {
            if (str2.endsWith("h") || str2.endsWith("H")) {
                try {
                    i3 = Integer.parseInt(str2.substring(0, str2.length() - 1));
                } catch (Exception unused) {
                    i3 = 0;
                }
                i2 = i3 * 60;
            } else if (str2.endsWith("m") || str2.endsWith("M")) {
                try {
                    i2 = Integer.parseInt(str2.substring(0, str2.length() - 1));
                } catch (Exception unused2) {
                    i2 = 0;
                }
            }
            i4 += i2;
        }
        return i4;
    }

    public static String a(int i2) {
        if (i2 < 0) {
            return "";
        }
        if (i2 < 60) {
            return i2 + "m";
        }
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        String str = i3 + "h";
        if (i4 <= 0) {
            return str;
        }
        return str + " " + i4 + "m";
    }

    public static String b(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, AppConstants.UTF_8);
        } catch (IOException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static void a(View view, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static JSONObject k(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    public static boolean a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        if (instance.get(1) <= instance2.get(1) && instance.get(2) <= instance2.get(2) && instance.get(5) < instance2.get(5)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable a(java.lang.String r5, java.lang.String r6, android.content.Context r7) {
        /*
            int r0 = com.travel.flight.R.drawable.flight_male_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r0)
            int r1 = r5.hashCode()
            r2 = -1184183706(0xffffffffb96aca66, float:-2.2391378E-4)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0030
            r2 = 92676538(0x58621ba, float:1.2613689E-35)
            if (r1 == r2) goto L_0x0026
            r2 = 94631196(0x5a3f51c, float:1.5418485E-35)
            if (r1 == r2) goto L_0x001c
            goto L_0x003a
        L_0x001c:
            java.lang.String r1 = "child"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x003a
            r5 = 2
            goto L_0x003b
        L_0x0026:
            java.lang.String r1 = "adult"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x003a
            r5 = 0
            goto L_0x003b
        L_0x0030:
            java.lang.String r1 = "infant"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x003a
            r5 = 1
            goto L_0x003b
        L_0x003a:
            r5 = -1
        L_0x003b:
            if (r5 == 0) goto L_0x005f
            if (r5 == r4) goto L_0x0058
            if (r5 == r3) goto L_0x0042
            goto L_0x0074
        L_0x0042:
            java.lang.String r5 = "Mstr"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x0051
            int r5 = com.travel.flight.R.drawable.flight_child_male_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r5)
            goto L_0x0074
        L_0x0051:
            int r5 = com.travel.flight.R.drawable.flight_child_female_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r5)
            goto L_0x0074
        L_0x0058:
            int r5 = com.travel.flight.R.drawable.flight_infant_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r5)
            goto L_0x0074
        L_0x005f:
            java.lang.String r5 = "Mr"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x006e
            int r5 = com.travel.flight.R.drawable.flight_male_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r5)
            goto L_0x0074
        L_0x006e:
            int r5 = com.travel.flight.R.drawable.flight_female_revamp_img
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r7, (int) r5)
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.utils.c.a(java.lang.String, java.lang.String, android.content.Context):android.graphics.drawable.Drawable");
    }
}
