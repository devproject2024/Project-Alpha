package com.travel.train.j;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import com.travel.train.R;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainFilterItem;
import com.travel.train.model.trainticket.CJRTrainQuickSRP;
import com.travel.train.model.trainticket.CJRTrainQuota;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.CJRTrainUserFavourite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static String f27578a = "CJRTrainSearchResultsUtil";

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

    public static int b(String str) {
        if (str == null) {
            return R.color.color_8c8c8c;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1955522002:
                if (str.equals("ORANGE")) {
                    c2 = 2;
                    break;
                }
                break;
            case 81009:
                if (str.equals("RED")) {
                    c2 = 0;
                    break;
                }
                break;
            case 63281119:
                if (str.equals("BLACK")) {
                    c2 = 4;
                    break;
                }
                break;
            case 68081379:
                if (str.equals("GREEN")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return R.color.color_waitlist;
        }
        if (c2 == 1) {
            return R.color.color_available;
        }
        if (c2 != 2) {
            return R.color.color_8c8c8c;
        }
        return R.color.color_rac;
    }

    public static int c(String str) {
        if (str == null) {
            return R.color.color_ffffff;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1955522002:
                if (str.equals("ORANGE")) {
                    c2 = 2;
                    break;
                }
                break;
            case 81009:
                if (str.equals("RED")) {
                    c2 = 0;
                    break;
                }
                break;
            case 63281119:
                if (str.equals("BLACK")) {
                    c2 = 4;
                    break;
                }
                break;
            case 68081379:
                if (str.equals("GREEN")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return R.color.color_fce8e6;
        }
        if (c2 == 1) {
            return R.color.color_ecfaf5;
        }
        if (c2 != 2) {
            return R.color.color_ffffff;
        }
        return R.color.color_fff6e5;
    }

    public static String a(int i2, Context context) {
        if (i2 == context.getResources().getColor(R.color.color_waitlist)) {
            return g.ab;
        }
        if (i2 == context.getResources().getColor(R.color.color_available)) {
            return g.ad;
        }
        if (i2 == context.getResources().getColor(R.color.color_rac)) {
            return g.ac;
        }
        return g.ad;
    }

    public static String a(Collection<String> collection) {
        if (collection.contains(g.Z) || collection.contains(g.aa)) {
            return g.ad;
        }
        if (collection.contains(g.Y)) {
            return g.ab;
        }
        return g.ac;
    }

    public static String a(String str, HashMap<String, Object> hashMap) {
        String str2 = str;
        for (Map.Entry next : hashMap.entrySet()) {
            if (((String) next.getKey()).equals(str)) {
                str2 = next.getValue().toString();
            }
        }
        return str2;
    }

    public static String b(String str, HashMap<String, Object> hashMap) {
        String str2 = "";
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                if (hashMap.get(next).equals(str)) {
                    str2 = next;
                }
            }
        }
        return str2;
    }

    public static String a(ArrayList<CJRTrainQuota> arrayList, boolean z) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).isIsSelected()) {
                    if (z) {
                        str = arrayList.get(i2).getQuotaCode();
                    } else {
                        str = arrayList.get(i2).getQuotaName();
                    }
                }
            }
        }
        return str;
    }

    public static ArrayList<String> a(List<CJRTrainSearchResultsTrain> list, HashMap<String, Object> hashMap, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String next : list.get(i2).getClasses()) {
            if (hashMap.containsKey(next)) {
                arrayList.add(hashMap.get(next).toString());
            }
        }
        return arrayList;
    }

    public static HashMap<String, String> a(CJRTrainSearchInput cJRTrainSearchInput) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("source", cJRTrainSearchInput.getmSourceCityCode());
        hashMap.put("destination", cJRTrainSearchInput.getmDestCityCode());
        hashMap.put("departureDate", i.b(cJRTrainSearchInput.getmDate(), "dd MMM yy", "yyyyMMdd"));
        if (!(g.f27551a == null || g.f27551a.getTestId() == null)) {
            hashMap.put("test_id", g.f27551a.getTestId().toString());
        }
        if (cJRTrainSearchInput.getmSourceKeyword() != null) {
            hashMap.put("source_keyword", cJRTrainSearchInput.getmSourceKeyword());
        }
        if (cJRTrainSearchInput.getmDestKeyword() != null) {
            hashMap.put("destination_keyword", cJRTrainSearchInput.getmDestKeyword());
        }
        if (cJRTrainSearchInput.getmSourceRankPosition() >= 0) {
            hashMap.put("source_position", String.valueOf(cJRTrainSearchInput.getmSourceRankPosition()));
        }
        if (cJRTrainSearchInput.getmDestRankPosition() >= 0) {
            hashMap.put("destination_position", String.valueOf(cJRTrainSearchInput.getmDestRankPosition()));
        }
        return hashMap;
    }

    public static HashMap<String, String> d(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pnr_number", str);
        if (!(g.f27551a == null || g.f27551a.getTestId() == null)) {
            hashMap.put("test_id", g.f27551a.getTestId().toString());
        }
        return hashMap;
    }

    public static HashMap<String, String> a(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mode", "metro");
        hashMap.put("lat", b.s(context));
        hashMap.put("long", b.t(context));
        return hashMap;
    }

    public static HashMap<String, String> b(CJRTrainSearchInput cJRTrainSearchInput) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("src_code", cJRTrainSearchInput.getmSourceCityCode());
        hashMap.put("dest_code", cJRTrainSearchInput.getmDestCityCode());
        hashMap.put("dep_date", i.b(cJRTrainSearchInput.getmDate(), "dd MMM yy", "yyyyMMdd"));
        return hashMap;
    }

    public static HashMap<String, String> a(String str, String str2, String str3, String str4, String str5) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("trainNumber", str);
        hashMap.put("source", str2);
        hashMap.put("destination", str3);
        if (str5 != null) {
            hashMap.put(Item.KEY_CLASS, str5);
        }
        if (str4 != null) {
            hashMap.put("departureDate", i.b(str4, "dd MMM yy", "yyyyMMdd"));
        }
        return hashMap;
    }

    public static HashMap<String, String> b(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
        return hashMap;
    }

    public static HashMap<String, String> c(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
        return hashMap;
    }

    public static HashMap<String, String> d(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
        hashMap.put(StringSet.show_empty, "true");
        com.travel.train.b.a();
        if (com.travel.train.b.a(context).equals(e.b.RESELLER.name())) {
            hashMap.put("reseller", "1");
        }
        return hashMap;
    }

    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
        hashMap.put("wallet_token", str);
        com.travel.train.b.a();
        if (com.travel.train.b.a(context).equals(e.b.RESELLER.name())) {
            hashMap.put("reseller", "1");
        }
        return hashMap;
    }

    public static HashMap<String, String> e(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
        if (b.r(context)) {
            hashMap.put("user_account_user_id", b.n(context));
        }
        return hashMap;
    }

    public static HashMap<String, String> a(String str, ArrayList<CJRTrainFilterItem> arrayList, CJRTrainSearchResults cJRTrainSearchResults) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CJRTrainFilterItem cJRTrainFilterItem = arrayList.get(i2);
            if (cJRTrainFilterItem != null) {
                for (int i3 = 0; i3 < cJRTrainFilterItem.getValues().size(); i3++) {
                    String str2 = cJRTrainFilterItem.getValues().get(i3);
                    String str3 = (String) cJRTrainSearchResults.getTrainClassesMap().get(cJRTrainFilterItem.getValues().get(i3));
                    if (str.equalsIgnoreCase(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FOR_ALL)) {
                        hashMap.put(str2, str3);
                    } else if (cJRTrainFilterItem.isSelectValue()) {
                        hashMap.put(str2, str3);
                    }
                }
            }
        }
        return hashMap;
    }

    public static boolean a(HashMap<String, String> hashMap, ArrayList<CJRTrainFilterItem> arrayList) {
        new HashMap();
        boolean z = true;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CJRTrainFilterItem cJRTrainFilterItem = arrayList.get(i2);
            if (cJRTrainFilterItem != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= cJRTrainFilterItem.getValues().size()) {
                        break;
                    } else if (!hashMap.containsKey(cJRTrainFilterItem.getValues().get(i3))) {
                        z = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    break;
                }
            }
        }
        return z;
    }

    public static Object a(Serializable serializable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(ArrayList<CJRTrainFilterItem> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJRTrainFilterItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRTrainFilterItem next = it2.next();
                if ("ac".equalsIgnoreCase(next.getId()) && !next.isSelectValue()) {
                    return false;
                }
                if (!"ac".equalsIgnoreCase(next.getId()) && next.isSelectValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, String str) {
        if (cJRTrainSearchResultsTrain == null || cJRTrainSearchResultsTrain.getMAvailability() == null) {
            return false;
        }
        Iterator<CJRTrainSearchResultsAvailibiltyObject> it2 = cJRTrainSearchResultsTrain.getMAvailability().iterator();
        while (it2.hasNext()) {
            CJRTrainSearchResultsAvailibiltyObject next = it2.next();
            if (next.getClassType().equalsIgnoreCase(str)) {
                return next.getColour().equalsIgnoreCase("RED");
            }
        }
        return false;
    }

    public static boolean a(CJRTrainUserFavourite cJRTrainUserFavourite, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainQuickSRP cJRTrainQuickSRP) {
        if (cJRTrainQuickSRP.getSourceStation() && !cJRTrainUserFavourite.getSourceStation().equalsIgnoreCase(cJRTrainSearchResultsTrain.getSource())) {
            return false;
        }
        if (!cJRTrainQuickSRP.getDestinationStation() || cJRTrainUserFavourite.getDestinationStation().equalsIgnoreCase(cJRTrainSearchResultsTrain.getDestination())) {
            return true;
        }
        return false;
    }

    public static String c(CJRTrainSearchInput cJRTrainSearchInput) {
        if (cJRTrainSearchInput == null || cJRTrainSearchInput.getmDate() == null) {
            return "";
        }
        String str = "dd MMM yy";
        if (!b.c(cJRTrainSearchInput.getmDate(), str)) {
            str = "dd MMM yy, EEE";
        }
        return b.d(cJRTrainSearchInput.getmDate(), str, "EEEE, dd MMMM");
    }

    public static Spannable f(Context context) {
        if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getHiddenNonAc())) {
            SpannableString spannableString = new SpannableString(context.getString(R.string.train_non_ac_classes_are_hidden));
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_33b5e5)), 30, 40, 33);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(g.f27551a.getHiddenNonAc());
        if (!g.f27551a.getHiddenNonAc().contains(context.getString(R.string.click_here_text))) {
            return spannableString2;
        }
        int indexOf = g.f27551a.getHiddenNonAc().indexOf(context.getString(R.string.click_here_text));
        spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_33b5e5)), indexOf, indexOf + 10, 33);
        return spannableString2;
    }

    public static Spannable g(Context context) {
        if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getHiddenAc())) {
            SpannableString spannableString = new SpannableString(context.getString(R.string.train_ac_classes_are_hidden));
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_33b5e5)), 30, 40, 33);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(g.f27551a.getHiddenAc());
        if (!g.f27551a.getHiddenAc().contains(context.getString(R.string.click_here_text))) {
            return spannableString2;
        }
        int indexOf = g.f27551a.getHiddenAc().indexOf(context.getString(R.string.click_here_text));
        spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_33b5e5)), indexOf, indexOf + 10, 33);
        return spannableString2;
    }

    public static String e(String str) {
        Uri.Builder builder;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        com.travel.train.b.a();
        String K = com.travel.train.b.b().K();
        if (!TextUtils.isEmpty(K)) {
            builder = Uri.parse(K).buildUpon();
        } else if (TextUtils.isEmpty(parse.getQueryParameter("url"))) {
            return "";
        } else {
            builder = Uri.parse(parse.getQueryParameter("url")).buildUpon();
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("source"))) {
            builder.appendQueryParameter("source", parse.getQueryParameter("source"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("destination"))) {
            builder.appendQueryParameter("destination", parse.getQueryParameter("destination"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("departureDate"))) {
            builder.appendQueryParameter("departureDate", parse.getQueryParameter("departureDate"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("source_name"))) {
            builder.appendQueryParameter("source_name", parse.getQueryParameter("source_name"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("destination_name"))) {
            builder.appendQueryParameter("destination_name", parse.getQueryParameter("destination_name"));
        }
        return builder.toString();
    }

    public static Integer a(CJRTrainSearchResults cJRTrainSearchResults) {
        if (cJRTrainSearchResults == null || cJRTrainSearchResults.getBody().getSort() == null) {
            return -1;
        }
        int intValue = cJRTrainSearchResults.getBody().getSort().getDefaultType().intValue();
        if (intValue == 0) {
            return 0;
        }
        if (intValue == 1) {
            return 1;
        }
        if (intValue != 2) {
            if (intValue != 3) {
                return -1;
            }
            if (cJRTrainSearchResults.getBody().getSort().getDefaultOrder().intValue() == 1) {
                return 4;
            }
            return 5;
        } else if (cJRTrainSearchResults.getBody().getSort().getDefaultOrder().intValue() == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    public static CJRTrainSearchInput b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        CJRTrainSearchInput cJRTrainSearchInput = new CJRTrainSearchInput();
        if (!TextUtils.isEmpty(parse.getQueryParameter("source"))) {
            cJRTrainSearchInput.setmSourceCityCode(parse.getQueryParameter("source"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("destination"))) {
            cJRTrainSearchInput.setmDestCityCode(parse.getQueryParameter("destination"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("departureDate"))) {
            cJRTrainSearchInput.setmDate(i.b(context, parse.getQueryParameter("departureDate")));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("source_name"))) {
            cJRTrainSearchInput.setmSourceCityName(parse.getQueryParameter("source_name"));
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("destination_name"))) {
            cJRTrainSearchInput.setmDestCityName(parse.getQueryParameter("destination_name"));
        }
        cJRTrainSearchInput.setmOrderBy(-1);
        cJRTrainSearchInput.setIsAllowed(false);
        return cJRTrainSearchInput;
    }

    public static void a(String str, String str2, String str3, String str4, Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("train_origin_city", str2);
            hashMap.put("train_destination_city", str3);
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("train_user_id", str4);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, context);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(String str, Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", b.n(context) != null ? b.n(context) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, context);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(String str, String str2, CJRTrainSearchInput cJRTrainSearchInput, Context context) {
        String n = b.n(context);
        HashMap hashMap = new HashMap();
        if (n != null && !TextUtils.isEmpty(n)) {
            hashMap.put(d.f49600g, n);
        }
        if (cJRTrainSearchInput != null) {
            hashMap.put(d.f49601h, cJRTrainSearchInput.getmSourceCityName());
            hashMap.put(d.f49602i, cJRTrainSearchInput.getmDestCityName());
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
        if (str2 != null) {
            hashMap.put(d.j, str2);
        }
        com.travel.train.b.a();
        com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, context);
    }

    public static void a(Context context, CJRTrainSearchInput cJRTrainSearchInput, int i2) {
        if (cJRTrainSearchInput != null) {
            String b2 = i.b(cJRTrainSearchInput.getmDate(), "dd MMM yy", "yyyyMMdd");
            if (!TextUtils.isEmpty(b2)) {
                String str = cJRTrainSearchInput.getmSourceCityName();
                String str2 = cJRTrainSearchInput.getmDestCityName();
                String n = b.n(context);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
                    hashMap.put("event_category", "train_search_results");
                    hashMap.put("event_action", "search_results_loaded");
                    hashMap.put(d.cv, "train");
                    hashMap.put("event_label", str);
                    hashMap.put("event_label2", str2);
                    hashMap.put("event_label3", b2);
                    hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Integer.valueOf(i2));
                    if (n == null) {
                        n = "";
                    }
                    hashMap.put("event_label5", n);
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
