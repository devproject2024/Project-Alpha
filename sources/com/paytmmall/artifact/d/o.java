package com.paytmmall.artifact.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static String f15733a = "DeepLinkBeanFactory";

    public static CJRHomePageItem a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = c.b(str) ? Uri.parse(str).getHost() : "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = a(str, str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return b(context, str, str2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (str.contains("/g/") || str.contains("bclpid") || str.contains("glpid") || str.contains("llpid") || str.contains("slpid")) {
            return CLPConstants.DEFAULT_GRID_VIEW_TYPE;
        }
        if (str.contains("/p/") || str.contains("-pdp")) {
            return "product";
        }
        if (str.contains("/h/") || str.contains("clpid") || str.contains("/search")) {
            return "homepage_secondary";
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if ((!android.text.TextUtils.isEmpty(r2) && com.paytmmall.artifact.d.t.e().isWhiteListedURL(r2, r4)) != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytmmall.artifact.common.entity.CJRHomePageItem a(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r0 = a((java.lang.String) r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r2 = a((android.net.Uri) r0)     // Catch:{ Exception -> 0x0040 }
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = ""
            goto L_0x0019
        L_0x0015:
            java.lang.String r0 = r0.getHost()     // Catch:{ Exception -> 0x0040 }
        L_0x0019:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x0034
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x0031
            com.paytmmall.artifact.common.a r3 = com.paytmmall.artifact.d.t.e()     // Catch:{ Exception -> 0x0040 }
            boolean r2 = r3.isWhiteListedURL(r2, r4)     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x0031
            r2 = 1
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            if (r2 == 0) goto L_0x003a
        L_0x0034:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x003b
        L_0x003a:
            return r1
        L_0x003b:
            com.paytmmall.artifact.common.entity.CJRHomePageItem r4 = b(r4, r5, r0)     // Catch:{ Exception -> 0x0040 }
            return r4
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.d.o.a(android.content.Context, java.lang.String):com.paytmmall.artifact.common.entity.CJRHomePageItem");
    }

    private static Uri a(String str) {
        Uri parse = Uri.parse(str.replace('$', '&'));
        if (parse == null) {
            return null;
        }
        return parse;
    }

    private static String a(Uri uri) {
        return uri == null ? "" : uri.getQueryParameter("url");
    }

    private static CJRHomePageItem b(Context context, String str, String str2) {
        Uri a2 = a(str);
        boolean z = false;
        if (str != null) {
            if (!(str.startsWith("paytmmp") || str.startsWith("paytmmall"))) {
                z = true;
            }
        }
        String a3 = z ? str : a(a2);
        if (str2.equalsIgnoreCase("homepage_secondary") || str2.equalsIgnoreCase(CLPConstants.GA_CHANNEL_NAME)) {
            str2 = "homepage_secondary";
        } else if ("deals".equals(str2)) {
            str2 = a(a3, str2);
        }
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        if (a3 == null) {
            cJRHomePageItem.setUrl(str);
        }
        if (!TextUtils.isEmpty(a3)) {
            cJRHomePageItem.setUrl(a3);
        }
        if (!z) {
            cJRHomePageItem.setDeeplink(str);
        }
        cJRHomePageItem.setUrlType(str2);
        if (a2 != null) {
            if ("utm".contains(a2.toString())) {
                t.e().setUTMData(a2);
            }
            cJRHomePageItem.setPushUtmSource(a2.getQueryParameter("utm_source"));
            if (new HashSet<String>() {
                {
                    add(CLPConstants.DEFAULT_GRID_VIEW_TYPE);
                    add("smart_list");
                    add("list");
                    add("homepage_secondary");
                    add(CLPConstants.URL_TYPE_EMBED);
                    add("ae_embed");
                }
            }.contains(str2)) {
                String queryParameter = a2.getQueryParameter("title");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = context.getString(R.string.offer_action_bar);
                }
                cJRHomePageItem.setName(queryParameter);
            }
            cJRHomePageItem.setPushQuantity(a2.getQueryParameter("quantity"));
            cJRHomePageItem.setPushPromoCode(a2.getQueryParameter(PayUtility.PROMO_CODE));
            cJRHomePageItem.setPushProductId(a2.getQueryParameter(CLPConstants.PRODUCT_ID));
            cJRHomePageItem.setPushCashAdd(a2.getQueryParameter("amount"));
            cJRHomePageItem.setPushFeatureType(a2.getQueryParameter("featuretype"));
            cJRHomePageItem.setPushWalletCode(a2.getQueryParameter("wallet_code"));
            cJRHomePageItem.setPushRecipient(a2.getQueryParameter("recipient"));
            cJRHomePageItem.setPushComment(a2.getQueryParameter(CJRQRScanResultModel.KEY_COMMENT_SMALL));
            cJRHomePageItem.setUtmMedium(a2.getQueryParameter("utm_medium"));
            cJRHomePageItem.setUtmTerm(a2.getQueryParameter("utm_term"));
            cJRHomePageItem.setUtmContent(a2.getQueryParameter("utm_content"));
            cJRHomePageItem.setUtmCampaign(a2.getQueryParameter("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            cJRHomePageItem.setPushShowPopup("true".equalsIgnoreCase(a2.getQueryParameter("showpopup")));
            try {
                d.f(context, a2.getQueryParameter(Payload.REFERRER));
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(a2.getQueryParameter("featuretype"))) {
                cJRHomePageItem.setFeatureType(a2.getQueryParameter("featuretype"));
            }
            cJRHomePageItem.setTab(a2.getQueryParameter("tab"));
            cJRHomePageItem.setItemID(a2.getQueryParameter("id"));
            cJRHomePageItem.setmVibeCategory(a2.getQueryParameter("category"));
            cJRHomePageItem.setmVibeArticleId(a2.getQueryParameter("article_id"));
        }
        if ("checkout".equalsIgnoreCase(str2)) {
            cJRHomePageItem.setDeeplinkType(2);
        }
        if (!z) {
            try {
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(str)) {
                    Uri parse = Uri.parse(str);
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    Uri.Builder buildUpon = Uri.parse(a3).buildUpon();
                    for (String next : queryParameterNames) {
                        String queryParameter2 = parse.getQueryParameter(next);
                        if (!"url".equals(next)) {
                            if ("related_category".equals(next)) {
                                buildUpon.appendQueryParameter(next, URLEncoder.encode(queryParameter2, "utf-8"));
                            } else {
                                buildUpon.appendQueryParameter(next, queryParameter2);
                            }
                        }
                    }
                    cJRHomePageItem.setUrl(buildUpon.build().toString());
                }
            } catch (UnsupportedEncodingException e2) {
                q.c(e2.getMessage());
            }
        }
        cJRHomePageItem.setOrigin("deeplinking");
        return cJRHomePageItem;
    }
}
