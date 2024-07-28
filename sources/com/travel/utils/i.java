package com.travel.utils;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f28528a = "DeepLinkUtility";

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f6 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0262 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x026d A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0298 A[SYNTHETIC, Splitter:B:142:0x0298] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x031e A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0355 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0367 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x040d A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0413 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x07a3 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0805 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0835 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0848 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x085e A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0874 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0889 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x08e8 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x09cd A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f0 A[SYNTHETIC, Splitter:B:44:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0150 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0194 A[Catch:{ Exception -> 0x09d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01eb A[Catch:{ Exception -> 0x09d7 }] */
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
            java.lang.String r8 = "featuretype"
            r9 = 0
            if (r2 != 0) goto L_0x0017
            return r9
        L_0x0017:
            r10 = 36
            r11 = 38
            java.lang.String r10 = r2.replace(r10, r11)     // Catch:{ Exception -> 0x09d7 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x09d7 }
            if (r10 != 0) goto L_0x0026
            return r9
        L_0x0026:
            java.lang.String r11 = "from"
            java.lang.String r11 = r10.getQueryParameter(r11)     // Catch:{ Exception -> 0x09d7 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r12 != 0) goto L_0x0070
            boolean r11 = r11.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r11 == 0) goto L_0x0070
            java.lang.String r11 = r10.getHost()     // Catch:{ Exception -> 0x09d7 }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x09d7 }
            r12.<init>()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r13 = "user_id"
            java.lang.String r14 = com.paytm.utility.b.n((android.content.Context) r17)     // Catch:{ Exception -> 0x09d7 }
            if (r14 == 0) goto L_0x004f
            java.lang.String r14 = com.paytm.utility.b.n((android.content.Context) r17)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x0051
        L_0x004f:
            java.lang.String r14 = ""
        L_0x0051:
            r12.put(r13, r14)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r13 = "event_category"
            r12.put(r13, r5)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r13 = "event_action"
            java.lang.String r14 = "smart_notification_clicked"
            r12.put(r13, r14)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r13 = "event_label"
            r12.put(r13, r11)     // Catch:{ Exception -> 0x09d7 }
            com.travel.d.a()     // Catch:{ Exception -> 0x09d7 }
            com.travel.common.b r11 = com.travel.d.b()     // Catch:{ Exception -> 0x09d7 }
            r11.a((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r12, (android.content.Context) r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x0070:
            java.lang.String r5 = r10.getQueryParameter(r6)     // Catch:{ Exception -> 0x09d7 }
            com.travel.d.a()     // Catch:{ Exception -> 0x09d7 }
            com.travel.common.b r11 = com.travel.d.b()     // Catch:{ Exception -> 0x09d7 }
            java.util.List r11 = r11.a()     // Catch:{ Exception -> 0x09d7 }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r12 != 0) goto L_0x008c
            boolean r11 = com.paytm.utility.b.a((java.util.List<java.lang.String>) r11, (java.lang.String) r5)     // Catch:{ Exception -> 0x09d7 }
            if (r11 != 0) goto L_0x008c
            return r9
        L_0x008c:
            java.lang.String r11 = r10.getHost()     // Catch:{ Exception -> 0x09d7 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r12 == 0) goto L_0x0097
            return r9
        L_0x0097:
            boolean r12 = r11.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09d7 }
            if (r12 != 0) goto L_0x00b1
            java.lang.String r12 = "homepage"
            boolean r12 = r11.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x09d7 }
            if (r12 == 0) goto L_0x00a6
            goto L_0x00b1
        L_0x00a6:
            java.lang.String r12 = "deals"
            boolean r12 = r11.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x09d7 }
            if (r12 == 0) goto L_0x00b2
            java.lang.String r11 = "deals"
            goto L_0x00b2
        L_0x00b1:
            r11 = r4
        L_0x00b2:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r12 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x09d7 }
            r12.<init>()     // Catch:{ Exception -> 0x09d7 }
            boolean r13 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r13 != 0) goto L_0x00c0
            r12.setUrl(r5)     // Catch:{ Exception -> 0x09d7 }
        L_0x00c0:
            r12.setDeeplink(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setUrlType(r11)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r13 = "isAppLink=true"
            boolean r2 = r2.contains(r13)     // Catch:{ Exception -> 0x09d7 }
            r13 = 0
            r14 = 1
            if (r2 == 0) goto L_0x00d4
            r12.setAppLink(r14)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x00d7
        L_0x00d4:
            r12.setAppLink(r13)     // Catch:{ Exception -> 0x09d7 }
        L_0x00d7:
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r15 = "utm"
            boolean r2 = r2.contains(r15)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r15 = "utm_content"
            java.lang.String r9 = "utm_term"
            java.lang.String r13 = "utm_medium"
            java.lang.String r14 = "utm_source"
            if (r2 == 0) goto L_0x0150
            net.one97.paytm.common.entity.shopping.CJRUrlUtmData r2 = new net.one97.paytm.common.entity.shopping.CJRUrlUtmData     // Catch:{ Exception -> 0x09d7 }
            r2.<init>()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r16 = r10.getQueryParameter(r14)     // Catch:{ Exception -> 0x09d7 }
            if (r16 == 0) goto L_0x0105
            r16 = r7
            java.lang.String r7 = r10.getQueryParameter(r14)     // Catch:{ Exception -> 0x09d7 }
            r2.addToUtmSource(r7)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x0107
        L_0x0105:
            r16 = r7
        L_0x0107:
            java.lang.String r7 = r10.getQueryParameter(r13)     // Catch:{ Exception -> 0x09d7 }
            if (r7 == 0) goto L_0x0114
            java.lang.String r7 = r10.getQueryParameter(r13)     // Catch:{ Exception -> 0x09d7 }
            r2.setUtmMedium(r7)     // Catch:{ Exception -> 0x09d7 }
        L_0x0114:
            java.lang.String r7 = r10.getQueryParameter(r9)     // Catch:{ Exception -> 0x09d7 }
            if (r7 == 0) goto L_0x0121
            java.lang.String r7 = r10.getQueryParameter(r9)     // Catch:{ Exception -> 0x09d7 }
            r2.setUtmTerm(r7)     // Catch:{ Exception -> 0x09d7 }
        L_0x0121:
            java.lang.String r7 = r10.getQueryParameter(r15)     // Catch:{ Exception -> 0x09d7 }
            if (r7 == 0) goto L_0x012e
            java.lang.String r7 = r10.getQueryParameter(r15)     // Catch:{ Exception -> 0x09d7 }
            r2.setUtmContent(r7)     // Catch:{ Exception -> 0x09d7 }
        L_0x012e:
            java.lang.String r7 = "utm_campaign"
            java.lang.String r7 = r10.getQueryParameter(r7)     // Catch:{ Exception -> 0x09d7 }
            if (r7 == 0) goto L_0x0141
            java.lang.String r7 = "utm_campaign"
            java.lang.String r7 = r10.getQueryParameter(r7)     // Catch:{ Exception -> 0x09d7 }
            r2.setUtmCampaign(r7)     // Catch:{ Exception -> 0x09d7 }
        L_0x0141:
            r7 = 1
            r2.setFromPush(r7)     // Catch:{ Exception -> 0x09d7 }
            com.travel.d.a()     // Catch:{ Exception -> 0x09d7 }
            com.travel.common.b r7 = com.travel.d.b()     // Catch:{ Exception -> 0x09d7 }
            r7.a((net.one97.paytm.common.entity.shopping.CJRUrlUtmData) r2)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x0152
        L_0x0150:
            r16 = r7
        L_0x0152:
            java.lang.String r2 = r10.getQueryParameter(r14)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushUtmSource(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "grid"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0187
            java.lang.String r2 = "smart_list"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0187
            java.lang.String r2 = "list"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0187
            boolean r2 = r11.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0187
            java.lang.String r2 = "embed"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r4 = "ae_embed"
            boolean r4 = r11.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09d7 }
            r2 = r2 | r4
            if (r2 == 0) goto L_0x019d
        L_0x0187:
            java.lang.String r2 = "title"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r4 == 0) goto L_0x019a
            int r2 = com.travel.R.string.offer_action_bar     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x019a:
            r12.setName(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x019d:
            boolean r2 = r11.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r4 = "automatic"
            if (r2 != 0) goto L_0x01de
            java.lang.String r2 = "utility_creditcard"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x01af
            goto L_0x01de
        L_0x01af:
            java.lang.String r2 = "prepaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x01d8
            java.lang.String r2 = "postpaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x01c0
            goto L_0x01d8
        L_0x01c0:
            java.lang.String r2 = "dth"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x01ce
            java.lang.String r2 = "dth"
            r12.setName(r2)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x01ee
        L_0x01ce:
            boolean r2 = r4.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x01ee
            r12.setName(r4)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x01ee
        L_0x01d8:
            java.lang.String r2 = "Mobile"
            r12.setName(r2)     // Catch:{ Exception -> 0x09d7 }
            goto L_0x01ee
        L_0x01de:
            java.lang.String r2 = "title"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r7 != 0) goto L_0x01ee
            r12.setName(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x01ee:
            java.lang.String r2 = "checkout"
            boolean r2 = r2.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x01fa
            r2 = 2
            r12.setDeeplinkType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x01fa:
            java.lang.String r2 = "prepaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0227
            java.lang.String r2 = "postpaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0227
            boolean r2 = r11.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0227
            java.lang.String r2 = "dth"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0227
            java.lang.String r2 = "utility_creditcard"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0227
            boolean r2 = r4.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0235
        L_0x0227:
            com.travel.d.a()     // Catch:{ Exception -> 0x09d7 }
            com.travel.common.b r2 = com.travel.d.b()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r2.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r12)     // Catch:{ Exception -> 0x09d7 }
            r12.setCategoryId(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0235:
            java.lang.String r2 = "prepaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x025a
            java.lang.String r2 = "postpaid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x025a
            boolean r2 = r11.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x025a
            java.lang.String r2 = "utility_creditcard"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x025a
            boolean r2 = r4.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0280
        L_0x025a:
            java.lang.String r2 = "label"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0265
            r12.setLabel(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0265:
            java.lang.String r2 = "related_category"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0280
            java.lang.String r2 = "related_category"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            java.util.ArrayList r3 = com.travel.utils.a.a(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r3 == 0) goto L_0x0280
            java.util.ArrayList r2 = com.travel.utils.a.a(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setRelatedCategories(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0280:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x037b
            java.util.Set r2 = r10.getQueryParameterNames()     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x037b
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x09d7 }
        L_0x0290:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r4 = "?"
            if (r3 == 0) goto L_0x02f6
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x09d7 }
            boolean r7 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x09d7 }
            if (r7 != 0) goto L_0x0290
            java.lang.String r7 = r10.getQueryParameter(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r14 = "related_category"
            boolean r14 = r3.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x09d7 }
            if (r14 == 0) goto L_0x02b7
            java.lang.String r14 = "utf-8"
            java.lang.String r7 = java.net.URLEncoder.encode(r7, r14)     // Catch:{ Exception -> 0x09d7 }
        L_0x02b7:
            boolean r14 = r5.contains(r4)     // Catch:{ Exception -> 0x09d7 }
            if (r14 != 0) goto L_0x02d8
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09d7 }
            r14.<init>()     // Catch:{ Exception -> 0x09d7 }
            r14.append(r5)     // Catch:{ Exception -> 0x09d7 }
            r14.append(r4)     // Catch:{ Exception -> 0x09d7 }
            r14.append(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = "="
            r14.append(r3)     // Catch:{ Exception -> 0x09d7 }
            r14.append(r7)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r5 = r14.toString()     // Catch:{ Exception -> 0x09d7 }
            goto L_0x0290
        L_0x02d8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09d7 }
            r4.<init>()     // Catch:{ Exception -> 0x09d7 }
            r4.append(r5)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r5 = "&"
            r4.append(r5)     // Catch:{ Exception -> 0x09d7 }
            r4.append(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = "="
            r4.append(r3)     // Catch:{ Exception -> 0x09d7 }
            r4.append(r7)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x09d7 }
            r5 = r3
            goto L_0x0290
        L_0x02f6:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0310
            java.lang.String r2 = "&"
            boolean r2 = r5.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0310
            boolean r2 = r5.contains(r4)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0310
            java.lang.String r2 = "&"
            java.lang.String r5 = r5.replaceFirst(r2, r4)     // Catch:{ Exception -> 0x09d7 }
        L_0x0310:
            int r2 = r5.length()     // Catch:{ Exception -> 0x09d7 }
            r3 = 1
            int r2 = r2 - r3
            char r2 = r5.charAt(r2)     // Catch:{ Exception -> 0x09d7 }
            r7 = 47
            if (r2 != r7) goto L_0x0328
            int r2 = r5.length()     // Catch:{ Exception -> 0x09d7 }
            int r2 = r2 - r3
            r3 = 0
            java.lang.String r5 = r5.substring(r3, r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0328:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0378
            java.lang.String r2 = "versionidentifier"
            boolean r2 = r5.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0378
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0378
            java.lang.String r2 = "train_order_summary"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0378
            java.lang.String r2 = "train_order_summary_v2"
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0378
            boolean r2 = r5.contains(r4)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0367
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09d7 }
            r2.<init>()     // Catch:{ Exception -> 0x09d7 }
            r2.append(r5)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = "?versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x09d7 }
            goto L_0x0378
        L_0x0367:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09d7 }
            r2.<init>()     // Catch:{ Exception -> 0x09d7 }
            r2.append(r5)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = "&versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x09d7 }
        L_0x0378:
            r12.setUrl(r5)     // Catch:{ Exception -> 0x09d7 }
        L_0x037b:
            java.lang.String r2 = "quantity"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushQuantity(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "promo_code"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushPromoCode(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "product_id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushProductId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "amount"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCashAdd(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r10.getQueryParameter(r8)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "wallet_code"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushWalletCode(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "recipient"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRecipient(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "comment"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushComment(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r10.getQueryParameter(r13)     // Catch:{ Exception -> 0x09d7 }
            r12.setUtmMedium(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r10.getQueryParameter(r9)     // Catch:{ Exception -> 0x09d7 }
            r12.setUtmTerm(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r10.getQueryParameter(r15)     // Catch:{ Exception -> 0x09d7 }
            r12.setUtmContent(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "utm_campaign"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setUtmCampaign(r2)     // Catch:{ Exception -> 0x09d7 }
            r2 = 1
            r12.setDeepLinking(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "max_price"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setMaxPrice(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "min_price"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setMinPrice(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "showpopup"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r3 != 0) goto L_0x0413
            java.lang.String r3 = "true"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0413
            r2 = 1
            r12.setPushShowPopup(r2)     // Catch:{ Exception -> 0x09d7 }
            r3 = 0
            goto L_0x0417
        L_0x0413:
            r3 = 0
            r12.setPushShowPopup(r3)     // Catch:{ Exception -> 0x09d7 }
        L_0x0417:
            java.lang.String r2 = "check_in_date"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCheckInDate(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "check_out_date"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCheckOutDate(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "city"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCity(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "city_value"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCityValue(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "rooms_details"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRoomDetailsJson(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "filter_params"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFilterJson(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "query_string"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setQueryString(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "qrid"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setQrid(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "hotel_name"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushHotelName(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "hotel_id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushHotelId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "hotel_extras"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushHotelExtras(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "hotel_final_price_with_tax"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushHotelFinalPriceWithTax(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "source_city_name"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushSourceCityName(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "source_city_short_name"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushSourceCityShortName(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "destination_city_name"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushDestinationCityName(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "destination_city_short_name"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushDestinationCityShortName(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "date"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushDate(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "passenger_count"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushPassengerCount(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "recharge_number"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRechargeNumber(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "price"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRechargeAmount(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "promo"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRechargePromo(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "roaming"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushRechargeRoaming(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "type"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushType(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "code"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushCode(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "content_id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setContentID(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "movie_code"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setMovieCode(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "flight_class"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFlightClass(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "flight_trip_type"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFlightTripType(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "flight_depart_date"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFlightDepartDate(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "flight_return_date"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFlightReturnDate(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "referrer"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x0532 }
            com.paytm.utility.b.i((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0532 }
            goto L_0x053f
        L_0x0532:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x053f
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x09d7 }
            com.paytm.utility.q.c(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x053f:
            java.lang.String r1 = "deeplinking"
            r12.setOrigin(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.E     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setIfsc(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.F     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setBankName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.f21444h     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setVertical(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.j     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setDbtConsent(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "non_aadhaar"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setNonAadhaar(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "open_screen"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setOpenScreen(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "aadhaar_otp"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setAadhaarOtp(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.f21445i     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setForm60(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.f21443g     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCallBackUrl(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.C     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setBankAccountNumber(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.P     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setAccount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.R     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMtReminderKey(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.Q     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMtTitle(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.L     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPayeeAddress(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.M     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPayeeName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.N     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMtComment(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.O     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMtAmount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.D     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setBankUserName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.H     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setBankComment(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.G     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setBankAmount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "source"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrainSourceCityCode(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "destination"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrainDestinationCityCode(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "departureDate"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrainDepartureDate(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "source_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrainSourceCityName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "destination_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrainDestinationCityName(r1)     // Catch:{ Exception -> 0x09d7 }
            if (r10 == 0) goto L_0x0640
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            if (r1 == 0) goto L_0x0640
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x09d7 }
            boolean r13 = r1.booleanValue()     // Catch:{ Exception -> 0x09d7 }
            r3 = r13
        L_0x0640:
            r12.setTrainRoundTrip(r3)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.I     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2pmobilenumber(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.J     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2pamount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.K     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2pcomment(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "events_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setEventName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "events_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmEventId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setEventCategory(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "sub_category_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setEventSubCategory(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setEventProviderId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setEventCityName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "groupid"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmGroupId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "park_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "park_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkCategory(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkProviderId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkCityName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "cityLabel"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmParkcityLabel(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "cityValue"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setParkcityValue(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r6)     // Catch:{ Exception -> 0x09d7 }
            r12.setGiftCardUrl(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.T     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setLanding_page(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.S     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMode(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.U     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setKyc_name(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.V     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setAadhar_number(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = com.travel.b.W     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setOverlay(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "issueTicketNumber"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmTicketId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "referral"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmFlightReferral(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "cinema_movie_code"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCinemaMovieCode(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "movie_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMovieName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "post_order_fb_cinemaId"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPostOrderCinemaId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "post_order_fb_providerId"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPostOrderProviderId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2mamount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "recipient"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setMerchantMID(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "comment"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2mComment(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "commnet_editable"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2mIsCommentEnable(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "amount_editable"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setP2mIsAmountEnable(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "parent_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setContactUsIssueParentId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "vertical_label"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setContactUsIssueVerticalLabel(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "feature-type"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setFeatureType(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "lifafaId"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setLifafaId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r8)     // Catch:{ Exception -> 0x09d7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09d7 }
            if (r1 != 0) goto L_0x07aa
            java.lang.String r1 = r10.getQueryParameter(r8)     // Catch:{ Exception -> 0x09d7 }
            r12.setFeatureType(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x07aa:
            java.lang.String r1 = "screen"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCashbackScreen(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "gameid"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCashbackOfferId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "campaignid"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCashbackCampaignId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "offertag"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setCashbackOfferTag(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "link_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setLinkId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "link_name"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setLinkName(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r8)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09d7 }
            com.travel.d.a()     // Catch:{ Exception -> 0x09d7 }
            com.travel.common.b r1 = com.travel.d.b()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPdcQrCodeId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09d7 }
            if (r1 != 0) goto L_0x080e
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x080e:
            java.lang.String r1 = "parentreason"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setParentreason(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "replacementreason"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setReplacementreson(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "childreason"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setChildreason(r1)     // Catch:{ Exception -> 0x09d7 }
            r1 = r16
            java.lang.String r2 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x083c
            java.lang.String r2 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x083c:
            java.lang.String r2 = "help_topic"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0851
            java.lang.String r2 = "help_topic"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0851:
            java.lang.String r2 = "vertical_detail"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0868
            java.lang.String r2 = "vertical_detail"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0868:
            java.lang.String r2 = "all_topics"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x087d
            java.lang.String r2 = "all_topics"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x087d:
            java.lang.String r2 = "all_videos"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0892
            java.lang.String r2 = "all_videos"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0892:
            java.lang.String r2 = "verticalid"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setVerticalid(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "l1"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setL1(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "l2"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setL2(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "trendingId"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setTrendingId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "verticalId"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setVerticalId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "templateId"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setTemplateId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "orderId"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setCstOrderId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "item_id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setCstItemId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x08ef
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x08ef:
            java.lang.String r1 = "issueId"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setIssueId(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "issueText"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setIssueText(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "tab"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setTab(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setItemID(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "landing"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmLandingPage(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmType(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmAmount(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "gram"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setmGram(r1)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r1 = "proceed"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x096a
            java.lang.String r2 = "fastpay"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x096a
            java.lang.String r2 = "id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r3 == 0) goto L_0x0967
            java.lang.String r3 = "="
            java.lang.String[] r3 = r11.split(r3)     // Catch:{ Exception -> 0x09d7 }
            if (r3 == 0) goto L_0x0967
            int r4 = r3.length     // Catch:{ Exception -> 0x09d7 }
            r5 = 1
            if (r4 <= r5) goto L_0x0967
            r2 = r3[r5]     // Catch:{ Exception -> 0x09d7 }
        L_0x0967:
            r12.setSsId(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x096a:
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x0993
            java.lang.String r2 = "edc_receipt"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r2 == 0) goto L_0x0993
            java.lang.String r2 = "mid"
            r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "tid"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r3 = "acquirementId"
            java.lang.String r3 = r10.getQueryParameter(r3)     // Catch:{ Exception -> 0x09d7 }
            r12.setAcquirementId(r3)     // Catch:{ Exception -> 0x09d7 }
            r12.setMid(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setTxnId(r2)     // Catch:{ Exception -> 0x09d7 }
        L_0x0993:
            java.lang.String r2 = "category"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setmVibeCategory(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "article_id"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setmVibeArticleId(r2)     // Catch:{ Exception -> 0x09d7 }
            java.lang.String r2 = "locale"
            java.lang.String r2 = r10.getQueryParameter(r2)     // Catch:{ Exception -> 0x09d7 }
            r12.setLocale(r2)     // Catch:{ Exception -> 0x09d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09d7 }
            if (r2 != 0) goto L_0x09c1
            java.lang.String r2 = "true"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r1 == 0) goto L_0x09c1
            r1 = 1
            r12.setmProceed(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x09c1:
            java.lang.String r1 = "gamepind"
            java.lang.String r2 = r12.getURLType()     // Catch:{ Exception -> 0x09d7 }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09d7 }
            if (r1 == 0) goto L_0x09d6
            java.lang.String r1 = "product_id"
            java.lang.String r1 = r10.getQueryParameter(r1)     // Catch:{ Exception -> 0x09d7 }
            r12.setContentID(r1)     // Catch:{ Exception -> 0x09d7 }
        L_0x09d6:
            return r12
        L_0x09d7:
            r0 = move-exception
            r1 = r0
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.c(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.utils.i.a(android.content.Context, java.lang.String):net.one97.paytm.common.entity.shopping.CJRHomePageItem");
    }
}
