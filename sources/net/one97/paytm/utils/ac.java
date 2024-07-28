package net.one97.paytm.utils;

import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.deeplink.h;

public final class ac {
    /* JADX WARNING: Removed duplicated region for block: B:125:0x022c A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0237 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0262 A[SYNTHETIC, Splitter:B:139:0x0262] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02e7 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x031b A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x032d A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03d1 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03d6 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x05ef A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x05fe A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0750 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0780 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x07b9 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x07ce A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x07fc A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x080f A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0824 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0839 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x084e A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x08a9 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x092f A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0960 A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x099b A[Catch:{ Exception -> 0x09df }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x09b6 A[Catch:{ Exception -> 0x09d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x09d0 A[Catch:{ Exception -> 0x09d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cd A[Catch:{ Exception -> 0x09df }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.shopping.CJRHomePageItem a(android.content.Context r17, java.lang.String r18) {
        /*
            r1 = r17
            r2 = r18
            java.lang.String r3 = "utility"
            java.lang.String r4 = "homepage_secondary"
            java.lang.String r5 = "smart_notification"
            java.lang.String r6 = "url"
            java.lang.String r7 = "cst_issue"
            r8 = 0
            if (r2 != 0) goto L_0x0012
            return r8
        L_0x0012:
            r9 = 36
            r10 = 38
            java.lang.String r9 = r2.replace(r9, r10)     // Catch:{ Exception -> 0x09df }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x09df }
            if (r9 != 0) goto L_0x0021
            return r8
        L_0x0021:
            java.lang.String r10 = "from"
            java.lang.String r10 = r9.getQueryParameter(r10)     // Catch:{ Exception -> 0x09df }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r11 != 0) goto L_0x0062
            boolean r10 = r10.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x09df }
            if (r10 == 0) goto L_0x0062
            java.lang.String r10 = r9.getHost()     // Catch:{ Exception -> 0x09df }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ Exception -> 0x09df }
            r11.<init>()     // Catch:{ Exception -> 0x09df }
            java.lang.String r12 = "user_id"
            java.lang.String r13 = com.paytm.utility.a.a((android.content.Context) r17)     // Catch:{ Exception -> 0x09df }
            if (r13 == 0) goto L_0x0049
            java.lang.String r13 = com.paytm.utility.a.a((android.content.Context) r17)     // Catch:{ Exception -> 0x09df }
            goto L_0x004b
        L_0x0049:
            java.lang.String r13 = ""
        L_0x004b:
            r11.put(r12, r13)     // Catch:{ Exception -> 0x09df }
            java.lang.String r12 = "event_category"
            r11.put(r12, r5)     // Catch:{ Exception -> 0x09df }
            java.lang.String r12 = "event_action"
            java.lang.String r13 = "smart_notification_clicked"
            r11.put(r12, r13)     // Catch:{ Exception -> 0x09df }
            java.lang.String r12 = "event_label"
            r11.put(r12, r10)     // Catch:{ Exception -> 0x09df }
            net.one97.paytm.j.a.b((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r11, (android.content.Context) r1)     // Catch:{ Exception -> 0x09df }
        L_0x0062:
            java.lang.String r5 = r9.getQueryParameter(r6)     // Catch:{ Exception -> 0x09df }
            java.lang.String r10 = r9.getHost()     // Catch:{ Exception -> 0x09df }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x09df }
            java.util.List r11 = net.one97.paytm.j.c.F()     // Catch:{ Exception -> 0x09df }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r12 != 0) goto L_0x008c
            java.lang.String r12 = "external"
            boolean r12 = r12.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09df }
            if (r12 != 0) goto L_0x008c
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09df }
            if (r12 != 0) goto L_0x008c
            boolean r11 = com.paytm.utility.b.a((java.util.List<java.lang.String>) r11, (java.lang.String) r5)     // Catch:{ Exception -> 0x09df }
            if (r11 != 0) goto L_0x008c
            return r8
        L_0x008c:
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r11 == 0) goto L_0x0093
            return r8
        L_0x0093:
            boolean r11 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            if (r11 != 0) goto L_0x00a1
            java.lang.String r11 = "homepage"
            boolean r11 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09df }
            if (r11 == 0) goto L_0x00a2
        L_0x00a1:
            r10 = r4
        L_0x00a2:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x09df }
            r11.<init>()     // Catch:{ Exception -> 0x09df }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09df }
            if (r12 != 0) goto L_0x00b0
            r11.setUrl(r5)     // Catch:{ Exception -> 0x09df }
        L_0x00b0:
            r11.setDeeplink(r2)     // Catch:{ Exception -> 0x09df }
            r11.setUrlType(r10)     // Catch:{ Exception -> 0x09df }
            java.lang.String r12 = "isAppLink=true"
            boolean r12 = r2.contains(r12)     // Catch:{ Exception -> 0x09df }
            r13 = 0
            r14 = 1
            if (r12 == 0) goto L_0x00c4
            r11.setAppLink(r14)     // Catch:{ Exception -> 0x09df }
            goto L_0x00c7
        L_0x00c4:
            r11.setAppLink(r13)     // Catch:{ Exception -> 0x09df }
        L_0x00c7:
            java.lang.String r12 = r9.toString()     // Catch:{ Exception -> 0x09df }
            java.lang.String r15 = "utm"
            boolean r12 = r12.contains(r15)     // Catch:{ Exception -> 0x09df }
            java.lang.String r15 = "utm_content"
            java.lang.String r8 = "utm_term"
            java.lang.String r13 = "utm_medium"
            java.lang.String r14 = "utm_source"
            if (r12 == 0) goto L_0x012c
            net.one97.paytm.common.entity.shopping.CJRUrlUtmData r12 = new net.one97.paytm.common.entity.shopping.CJRUrlUtmData     // Catch:{ Exception -> 0x09df }
            r12.<init>()     // Catch:{ Exception -> 0x09df }
            java.lang.String r16 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09df }
            if (r16 == 0) goto L_0x00ed
            java.lang.String r2 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09df }
            r12.addToUtmSource(r2)     // Catch:{ Exception -> 0x09df }
        L_0x00ed:
            java.lang.String r2 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x00fa
            java.lang.String r2 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09df }
            r12.setUtmMedium(r2)     // Catch:{ Exception -> 0x09df }
        L_0x00fa:
            java.lang.String r2 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0107
            java.lang.String r2 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09df }
            r12.setUtmTerm(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0107:
            java.lang.String r2 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0114
            java.lang.String r2 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09df }
            r12.setUtmContent(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0114:
            java.lang.String r2 = "utm_campaign"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0125
            java.lang.String r2 = "utm_campaign"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r12.setUtmCampaign(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0125:
            r2 = 1
            r12.setFromPush(r2)     // Catch:{ Exception -> 0x09df }
            net.one97.paytm.app.CJRJarvisApplication.a((net.one97.paytm.common.entity.shopping.CJRUrlUtmData) r12)     // Catch:{ Exception -> 0x09df }
        L_0x012c:
            java.lang.String r2 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09df }
            r11.setPushUtmSource(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "grid"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0160
            java.lang.String r2 = "smart_list"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0160
            java.lang.String r2 = "list"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0160
            boolean r2 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0160
            java.lang.String r2 = "embed"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r4 = "ae_embed"
            boolean r4 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            r2 = r2 | r4
            if (r2 == 0) goto L_0x0176
        L_0x0160:
            java.lang.String r2 = "title"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09df }
            if (r4 == 0) goto L_0x0173
            r2 = 2131959909(0x7f132065, float:1.9556472E38)
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0173:
            r11.setName(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0176:
            boolean r2 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r4 = "utility_creditcard"
            java.lang.String r12 = "automatic"
            if (r2 != 0) goto L_0x01b6
            boolean r2 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0187
            goto L_0x01b6
        L_0x0187:
            java.lang.String r2 = "prepaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01b0
            java.lang.String r2 = "postpaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0198
            goto L_0x01b0
        L_0x0198:
            java.lang.String r2 = "dth"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x01a6
            java.lang.String r2 = "dth"
            r11.setName(r2)     // Catch:{ Exception -> 0x09df }
            goto L_0x01c5
        L_0x01a6:
            boolean r2 = r12.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x01c5
            r11.setName(r12)     // Catch:{ Exception -> 0x09df }
            goto L_0x01c5
        L_0x01b0:
            java.lang.String r2 = "Mobile"
            r11.setName(r2)     // Catch:{ Exception -> 0x09df }
            goto L_0x01c5
        L_0x01b6:
            java.lang.String r2 = "title"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            boolean r14 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09df }
            if (r14 != 0) goto L_0x01c5
            r11.setName(r2)     // Catch:{ Exception -> 0x09df }
        L_0x01c5:
            java.lang.String r2 = "checkout"
            boolean r2 = r2.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x01d1
            r2 = 2
            r11.setDeeplinkType(r2)     // Catch:{ Exception -> 0x09df }
        L_0x01d1:
            java.lang.String r2 = "prepaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01fb
            java.lang.String r2 = "postpaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01fb
            boolean r2 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01fb
            java.lang.String r2 = "dth"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01fb
            boolean r2 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x01fb
            boolean r2 = r12.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0202
        L_0x01fb:
            java.lang.String r2 = net.one97.paytm.utils.l.a((net.one97.paytm.common.entity.CJRItem) r11)     // Catch:{ Exception -> 0x09df }
            r11.setCategoryId(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0202:
            java.lang.String r2 = "prepaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0224
            java.lang.String r2 = "postpaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0224
            boolean r2 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0224
            boolean r2 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0224
            boolean r2 = r12.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x024a
        L_0x0224:
            java.lang.String r2 = "label"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x022f
            r11.setLabel(r2)     // Catch:{ Exception -> 0x09df }
        L_0x022f:
            java.lang.String r2 = "related_category"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x024a
            java.lang.String r2 = "related_category"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            java.util.ArrayList r3 = net.one97.paytm.utils.i.a(r2)     // Catch:{ Exception -> 0x09df }
            if (r3 == 0) goto L_0x024a
            java.util.ArrayList r2 = net.one97.paytm.utils.i.a(r2)     // Catch:{ Exception -> 0x09df }
            r11.setRelatedCategories(r2)     // Catch:{ Exception -> 0x09df }
        L_0x024a:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0341
            java.util.Set r2 = r9.getQueryParameterNames()     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0341
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x09df }
        L_0x025a:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x09df }
            java.lang.String r4 = "?"
            if (r3 == 0) goto L_0x02bf
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x09df }
            boolean r12 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x09df }
            if (r12 != 0) goto L_0x025a
            java.lang.String r12 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r14 = "related_category"
            boolean r14 = r3.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x09df }
            if (r14 == 0) goto L_0x0280
            java.lang.String r14 = "utf-8"
            java.lang.String r12 = java.net.URLEncoder.encode(r12, r14)     // Catch:{ Exception -> 0x09df }
        L_0x0280:
            boolean r14 = r5.contains(r4)     // Catch:{ Exception -> 0x09df }
            if (r14 != 0) goto L_0x02a1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09df }
            r14.<init>()     // Catch:{ Exception -> 0x09df }
            r14.append(r5)     // Catch:{ Exception -> 0x09df }
            r14.append(r4)     // Catch:{ Exception -> 0x09df }
            r14.append(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = "="
            r14.append(r3)     // Catch:{ Exception -> 0x09df }
            r14.append(r12)     // Catch:{ Exception -> 0x09df }
            java.lang.String r5 = r14.toString()     // Catch:{ Exception -> 0x09df }
            goto L_0x025a
        L_0x02a1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09df }
            r4.<init>()     // Catch:{ Exception -> 0x09df }
            r4.append(r5)     // Catch:{ Exception -> 0x09df }
            java.lang.String r5 = "&"
            r4.append(r5)     // Catch:{ Exception -> 0x09df }
            r4.append(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = "="
            r4.append(r3)     // Catch:{ Exception -> 0x09df }
            r4.append(r12)     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x09df }
            r5 = r3
            goto L_0x025a
        L_0x02bf:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x02d9
            java.lang.String r2 = "&"
            boolean r2 = r5.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x02d9
            boolean r2 = r5.contains(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x02d9
            java.lang.String r2 = "&"
            java.lang.String r5 = r5.replaceFirst(r2, r4)     // Catch:{ Exception -> 0x09df }
        L_0x02d9:
            int r2 = r5.length()     // Catch:{ Exception -> 0x09df }
            r3 = 1
            int r2 = r2 - r3
            char r2 = r5.charAt(r2)     // Catch:{ Exception -> 0x09df }
            r12 = 47
            if (r2 != r12) goto L_0x02f1
            int r2 = r5.length()     // Catch:{ Exception -> 0x09df }
            int r2 = r2 - r3
            r3 = 0
            java.lang.String r5 = r5.substring(r3, r2)     // Catch:{ Exception -> 0x09df }
        L_0x02f1:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x033e
            java.lang.String r2 = "versionidentifier"
            boolean r2 = r5.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x033e
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x033e
            java.lang.String r2 = "train_order_summary"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x033e
            java.lang.String r2 = "train_order_summary_v2"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x033e
            boolean r2 = r5.contains(r4)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x032d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09df }
            r2.<init>()     // Catch:{ Exception -> 0x09df }
            r2.append(r5)     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = "?versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x09df }
            goto L_0x033e
        L_0x032d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09df }
            r2.<init>()     // Catch:{ Exception -> 0x09df }
            r2.append(r5)     // Catch:{ Exception -> 0x09df }
            java.lang.String r3 = "&versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09df }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x09df }
        L_0x033e:
            r11.setUrl(r5)     // Catch:{ Exception -> 0x09df }
        L_0x0341:
            java.lang.String r2 = "quantity"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushQuantity(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "promo_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushPromoCode(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "product_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushProductId(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "amount"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCashAdd(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "featuretype"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "wallet_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushWalletCode(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "recipient"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRecipient(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "comment"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushComment(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09df }
            r11.setUtmMedium(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09df }
            r11.setUtmTerm(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09df }
            r11.setUtmContent(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "utm_campaign"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setUtmCampaign(r2)     // Catch:{ Exception -> 0x09df }
            r2 = 1
            r11.setDeepLinking(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "max_price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setMaxPrice(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "min_price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setMinPrice(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "showpopup"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09df }
            if (r3 != 0) goto L_0x03d6
            java.lang.String r3 = "true"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x03d6
            r2 = 1
            r11.setPushShowPopup(r2)     // Catch:{ Exception -> 0x09df }
            goto L_0x03da
        L_0x03d6:
            r2 = 0
            r11.setPushShowPopup(r2)     // Catch:{ Exception -> 0x09df }
        L_0x03da:
            java.lang.String r2 = "check_in_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCheckInDate(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "check_out_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCheckOutDate(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "city"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCity(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "city_value"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCityValue(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "rooms_details"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRoomDetailsJson(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "filter_params"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFilterJson(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "query_string"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setQueryString(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "qrid"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setQrid(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "hotel_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushHotelName(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "hotel_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushHotelId(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "hotel_extras"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushHotelExtras(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "hotel_final_price_with_tax"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushHotelFinalPriceWithTax(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "source_city_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushSourceCityName(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "source_city_short_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushSourceCityShortName(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "destination_city_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushDestinationCityName(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "destination_city_short_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushDestinationCityShortName(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushDate(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "passenger_count"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushPassengerCount(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "recharge_number"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRechargeNumber(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRechargeAmount(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "promo"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRechargePromo(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "roaming"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushRechargeRoaming(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "type"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushType(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushCode(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "content_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setContentID(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "movie_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setMovieCode(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "flight_class"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFlightClass(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "flight_trip_type"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFlightTripType(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "flight_depart_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFlightDepartDate(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "flight_return_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setPushFlightReturnDate(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "referrer"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.b.i((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04ff
        L_0x04f2:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x04ff
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x09df }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x09df }
        L_0x04ff:
            java.lang.String r1 = "deeplinking"
            r11.setOrigin(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ac     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setIfsc(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bI     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setBankName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.u     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setVertical(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.w     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setDbtConsent(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "non_aadhaar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setNonAadhaar(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "open_screen"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setOpenScreen(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "aadhaar_otp"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setAadhaarOtp(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.v     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setForm60(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.t     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setCallBackUrl(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.aa     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setBankAccountNumber(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bj     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setAccount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bl     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMtReminderKey(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bk     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMtTitle(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bf     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPayeeAddress(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bg     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPayeeName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bh     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMtComment(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.bi     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMtAmount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ab     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setBankUserName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ae     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setBankComment(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ad     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setBankAmount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "source"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrainSourceCityCode(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "destination"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrainDestinationCityCode(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "departureDate"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrainDepartureDate(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "source_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrainSourceCityName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "destination_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrainDestinationCityName(r1)     // Catch:{ Exception -> 0x09df }
            if (r9 == 0) goto L_0x05fe
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 == 0) goto L_0x05fe
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x09df }
            boolean r13 = r1.booleanValue()     // Catch:{ Exception -> 0x09df }
            goto L_0x05ff
        L_0x05fe:
            r13 = 0
        L_0x05ff:
            r11.setTrainRoundTrip(r13)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.af     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2pmobilenumber(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ag     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2pamount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ah     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2pcomment(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "events_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setEventName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "events_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmEventId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setEventCategory(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "sub_category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setEventSubCategory(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setEventProviderId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setEventCityName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "groupid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmGroupId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "park_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "park_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkCategory(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkProviderId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkCityName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "cityLabel"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmParkcityLabel(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "cityValue"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setParkcityValue(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r6)     // Catch:{ Exception -> 0x09df }
            r11.setGiftCardUrl(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.aj     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setLanding_page(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ai     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMode(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ak     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setKyc_name(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.al     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setAadhar_number(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = net.one97.paytm.common.utility.b.ap     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setOverlay(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "issueTicketNumber"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmTicketId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "referral"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmFlightReferral(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "cinema_movie_code"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setCinemaMovieCode(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "movie_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMovieName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "post_order_fb_cinemaId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPostOrderCinemaId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "post_order_fb_providerId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPostOrderProviderId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2mamount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "recipient"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setMerchantMID(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "comment"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2mComment(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "commnet_editable"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2mIsCommentEnable(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "amount_editable"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setP2mIsAmountEnable(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "parent_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setContactUsIssueParentId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "vertical_label"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setContactUsIssueVerticalLabel(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "feature-type"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0759
            java.lang.String r1 = "feature-type"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0759:
            java.lang.String r1 = "lifafaId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setLifafaId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "cid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setChannelsMerchantId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "m"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setChannelMerchantType(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "featuretype"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0789
            java.lang.String r1 = "featuretype"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0789:
            java.lang.String r1 = "link_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setLinkId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "link_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setLinkName(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "ssid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmWifiHotspotSSID(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "pdc_qrcode_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPdcQrCodeId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "ssid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x07c2
            java.lang.String r1 = "ssid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmWifiHotspotSSID(r1)     // Catch:{ Exception -> 0x09df }
        L_0x07c2:
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x07d7
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x07d7:
            java.lang.String r1 = "parentreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setParentreason(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "replacementreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setReplacementreson(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "childreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setChildreason(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0803
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0803:
            java.lang.String r1 = "help_topic"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0818
            java.lang.String r1 = "help_topic"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0818:
            java.lang.String r1 = "vertical_detail"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x082d
            java.lang.String r1 = "vertical_detail"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x082d:
            java.lang.String r1 = "all_topics"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0842
            java.lang.String r1 = "all_topics"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0842:
            java.lang.String r1 = "all_videos"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x0857
            java.lang.String r1 = "all_videos"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x0857:
            java.lang.String r1 = "verticalid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setVerticalid(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "l1"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setL1(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "l2"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setL2(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "trendingId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTrendingId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "verticalId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setVerticalId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "templateId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTemplateId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "orderId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setCstOrderId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "item_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setCstItemId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09df }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r1 != 0) goto L_0x08b0
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09df }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09df }
        L_0x08b0:
            java.lang.String r1 = "issueId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setIssueId(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "issueText"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setIssueText(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "tab"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setTab(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setItemID(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "landing"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmLandingPage(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "type"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmType(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmAmount(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "gram"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setmGram(r1)     // Catch:{ Exception -> 0x09df }
            java.lang.String r1 = "proceed"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0929
            java.lang.String r2 = "fastpay"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0929
            java.lang.String r2 = "id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09df }
            if (r3 == 0) goto L_0x0926
            java.lang.String r3 = "="
            java.lang.String[] r3 = r10.split(r3)     // Catch:{ Exception -> 0x09df }
            if (r3 == 0) goto L_0x0926
            int r4 = r3.length     // Catch:{ Exception -> 0x09df }
            r5 = 1
            if (r4 <= r5) goto L_0x0926
            r2 = r3[r5]     // Catch:{ Exception -> 0x09df }
        L_0x0926:
            r11.setSsId(r2)     // Catch:{ Exception -> 0x09df }
        L_0x0929:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0960
            java.lang.String r2 = "edc_receipt"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x0942
            java.lang.String r2 = "edcpos"
            r3 = r18
            boolean r2 = r3.contains(r2)     // Catch:{ Exception -> 0x09df }
            if (r2 == 0) goto L_0x0962
            goto L_0x0944
        L_0x0942:
            r3 = r18
        L_0x0944:
            java.lang.String r2 = "mid"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r4 = "tid"
            java.lang.String r4 = r9.getQueryParameter(r4)     // Catch:{ Exception -> 0x09df }
            java.lang.String r5 = "acquirementId"
            java.lang.String r5 = r9.getQueryParameter(r5)     // Catch:{ Exception -> 0x09df }
            r11.setAcquirementId(r5)     // Catch:{ Exception -> 0x09df }
            r11.setMid(r2)     // Catch:{ Exception -> 0x09df }
            r11.setTxnId(r4)     // Catch:{ Exception -> 0x09df }
            goto L_0x0962
        L_0x0960:
            r3 = r18
        L_0x0962:
            java.lang.String r2 = "category"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setmVibeCategory(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "article_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setmVibeArticleId(r2)     // Catch:{ Exception -> 0x09df }
            java.lang.String r2 = "locale"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09df }
            r11.setLocale(r2)     // Catch:{ Exception -> 0x09df }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09df }
            if (r2 != 0) goto L_0x098f
            java.lang.String r2 = "true"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r1 == 0) goto L_0x098f
            r1 = 1
            r11.setmProceed(r1)     // Catch:{ Exception -> 0x09df }
        L_0x098f:
            java.lang.String r1 = "gamepind"
            java.lang.String r2 = r11.getURLType()     // Catch:{ Exception -> 0x09df }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09df }
            if (r1 == 0) goto L_0x09a4
            java.lang.String r1 = "product_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09df }
            r11.setContentID(r1)     // Catch:{ Exception -> 0x09df }
        L_0x09a4:
            if (r10 == 0) goto L_0x09de
            boolean r1 = net.one97.paytm.marketplace.a.a((java.lang.String) r10)     // Catch:{ Exception -> 0x09df }
            if (r1 == 0) goto L_0x09de
            java.lang.String r1 = "url="
            java.lang.String[] r1 = r3.split(r1)     // Catch:{ Exception -> 0x09d5 }
            int r2 = r1.length     // Catch:{ Exception -> 0x09d5 }
            r4 = 2
            if (r2 != r4) goto L_0x09d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09d5 }
            r2.<init>()     // Catch:{ Exception -> 0x09d5 }
            r3 = 0
            r1 = r1[r3]     // Catch:{ Exception -> 0x09d5 }
            r2.append(r1)     // Catch:{ Exception -> 0x09d5 }
            java.lang.String r1 = "url="
            r2.append(r1)     // Catch:{ Exception -> 0x09d5 }
            java.lang.String r1 = r11.mUrl     // Catch:{ Exception -> 0x09d5 }
            r2.append(r1)     // Catch:{ Exception -> 0x09d5 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x09d5 }
            goto L_0x09d1
        L_0x09d0:
            r1 = r3
        L_0x09d1:
            r11.setDeeplink(r1)     // Catch:{ Exception -> 0x09d5 }
            goto L_0x09de
        L_0x09d5:
            r0 = move-exception
            r1 = r0
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x09df }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x09df }
        L_0x09de:
            return r11
        L_0x09df:
            r0 = move-exception
            r1 = r0
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.ac.a(android.content.Context, java.lang.String):net.one97.paytm.common.entity.shopping.CJRHomePageItem");
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            h.a aVar = h.f50349a;
            return h.a.a(context, str, (Bundle) null);
        } catch (Exception unused) {
        }
    }
}
