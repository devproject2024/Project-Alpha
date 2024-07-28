package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Set;

public class UrlUtils {
    private static final String TAG = "UrlUtils";

    public static String appendPageCount(String str, int i2) {
        return str != null ? Uri.parse(str).buildUpon().appendQueryParameter("page_count", String.valueOf(i2)).toString() : str;
    }

    public static String appendQueryParameter(String str, String str2, String str3) {
        Set<String> queryParameterNames;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            try {
                Uri.Builder buildUpon = parse.buildUpon();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (queryParameterNames = parse.getQueryParameterNames()) != null && !queryParameterNames.contains(str2)) {
                    buildUpon.appendQueryParameter(str2, getEncodedString(str3));
                }
                return new URL(buildUpon.build().toString()).toString();
            } catch (UnsupportedEncodingException e2) {
                LogUtils.e(TAG, "appendQueryParameter: ", e2);
            } catch (MalformedURLException e3) {
                LogUtils.e(TAG, "appendQueryParameter: ", e3);
            }
        }
        return str;
    }

    public static String getUpdatedUrl(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames == null) {
            return str;
        }
        for (String next : queryParameterNames) {
            if (!next.equals(str2) || !TextUtils.isEmpty(str3)) {
                hashMap.put(next, parse.getQueryParameter(next));
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(str2, str3);
        }
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        for (String str4 : hashMap.keySet()) {
            clearQuery.appendQueryParameter(str4, (String) hashMap.get(str4));
        }
        return clearQuery.toString();
    }

    private static String getEncodedString(String str) throws UnsupportedEncodingException {
        LogUtils.d(TAG, "getEncodedString: ".concat(String.valueOf(str)));
        return TextUtils.isEmpty(str) ? str : URLEncoder.encode(str, AppConstants.UTF_8);
    }

    public static String appendGridQueryParameter(String str, String str2, int i2) {
        return str != null ? Uri.parse(str).buildUpon().appendQueryParameter(str2, String.valueOf(i2)).toString() : str;
    }

    public static String appendGridQueryParameter(String str, String str2, String str3) {
        return str != null ? Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).toString() : str;
    }

    public static String getQueryParameter(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Uri.parse(str).getQueryParameter(str2);
        } catch (Exception e2) {
            LogUtils.printStackTrace(e2);
            return str;
        }
    }

    public static String getAbsoluteUrl(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (CLPArtifact.getInstance().getCommunicationListener() == null) {
            return str;
        }
        String childSiteId = CLPArtifact.getInstance().getCommunicationListener().getChildSiteId();
        String siteId = CLPArtifact.getInstance().getCommunicationListener().getSiteId();
        StringBuilder sb = new StringBuilder(CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(context, str));
        if (z) {
            sb.append(String.format("&child_site_id=%1$s", new Object[]{childSiteId}));
            sb.append(String.format("&site_id=%1$s", new Object[]{siteId}));
        }
        return sb.toString();
    }

    public static String getCartUrl(Context context) {
        String cartId = CLPArtifact.getInstance().getCommunicationListener().getCartId();
        String url = CLPArtifact.getInstance().getCommunicationListener().getURL(CLPConstants.CONFIG_KEY_CART, CLPConstants.URL.CART);
        if (!TextUtils.isEmpty(cartId)) {
            url = url + "/" + cartId;
        }
        return getAbsoluteUrl(context, url, true);
    }

    public static String appendSiteIdToUrl(Context context, String str) {
        return CLPArtifact.getInstance().getCommunicationListener().appendDefaultParams(context, str);
    }

    public static String appendChildSiteId(String str) {
        String childSiteId = CLPArtifact.getInstance().getCommunicationListener().getChildSiteId();
        String siteId = CLPArtifact.getInstance().getCommunicationListener().getSiteId();
        String appVersion = CLPArtifact.getInstance().getCommunicationListener().getAppVersion();
        return appendQueryParameter(appendQueryParameter(appendGridQueryParameter(appendQueryParameter(str, com.business.merchant_payments.common.utility.AppConstants.TAG_SITE_ID, siteId), com.business.merchant_payments.common.utility.AppConstants.TAG_CHILD_SITE_ID, childSiteId), "version", appVersion), "client", CLPArtifact.getInstance().getCommunicationListener().getClient());
    }

    public static String constructNewUrl(Uri uri, HashMap<String, String> hashMap) {
        if (uri == null) {
            return "";
        }
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String next : hashMap.keySet()) {
            clearQuery.appendQueryParameter(next, hashMap.get(next));
        }
        return clearQuery.toString();
    }

    public static boolean isOfflineFlow(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(CLPConstants.DISCOVERABILITY);
        return !TextUtils.isEmpty(queryParameter) && queryParameter.equals(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT);
    }
}
