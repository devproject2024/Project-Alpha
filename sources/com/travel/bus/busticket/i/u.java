package com.travel.bus.busticket.i;

public final class u {
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0205 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0300 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0391 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0397 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0729 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0760 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x07ee A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x081e A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0831 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0847 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x085d A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0872 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x08d1 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x09b6 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f0 A[SYNTHETIC, Splitter:B:44:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014a A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018e A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a0 A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ea A[Catch:{ Exception -> 0x09c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01f5 A[Catch:{ Exception -> 0x09c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.shopping.CJRHomePageItem a(android.content.Context r19, java.lang.String r20) {
        /*
            r1 = r19
            r2 = r20
            java.lang.String r3 = "homepage_secondary"
            java.lang.String r4 = "smart_notification"
            java.lang.String r5 = "url"
            java.lang.String r6 = "cst_issue"
            java.lang.String r7 = "featuretype"
            r8 = 0
            if (r2 != 0) goto L_0x0014
            return r8
        L_0x0014:
            r9 = 36
            r10 = 38
            java.lang.String r9 = r2.replace(r9, r10)     // Catch:{ Exception -> 0x09c0 }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x09c0 }
            if (r9 != 0) goto L_0x0023
            return r8
        L_0x0023:
            java.lang.String r10 = "from"
            java.lang.String r10 = r9.getQueryParameter(r10)     // Catch:{ Exception -> 0x09c0 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r11 != 0) goto L_0x006d
            boolean r10 = r10.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r10 == 0) goto L_0x006d
            java.lang.String r10 = r9.getHost()     // Catch:{ Exception -> 0x09c0 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ Exception -> 0x09c0 }
            r11.<init>()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r12 = "user_id"
            java.lang.String r13 = com.paytm.utility.b.n((android.content.Context) r19)     // Catch:{ Exception -> 0x09c0 }
            if (r13 == 0) goto L_0x004c
            java.lang.String r13 = com.paytm.utility.b.n((android.content.Context) r19)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x004e
        L_0x004c:
            java.lang.String r13 = ""
        L_0x004e:
            r11.put(r12, r13)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r12 = "event_category"
            r11.put(r12, r4)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r12 = "event_action"
            java.lang.String r13 = "smart_notification_clicked"
            r11.put(r12, r13)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r12 = "event_label"
            r11.put(r12, r10)     // Catch:{ Exception -> 0x09c0 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x09c0 }
            com.travel.g.a r10 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x09c0 }
            r10.a((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r11, (android.content.Context) r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x006d:
            java.lang.String r4 = r9.getQueryParameter(r5)     // Catch:{ Exception -> 0x09c0 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x09c0 }
            com.travel.g.a r10 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x09c0 }
            java.util.List r10 = r10.B()     // Catch:{ Exception -> 0x09c0 }
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r11 != 0) goto L_0x0089
            boolean r10 = com.paytm.utility.b.a((java.util.List<java.lang.String>) r10, (java.lang.String) r4)     // Catch:{ Exception -> 0x09c0 }
            if (r10 != 0) goto L_0x0089
            return r8
        L_0x0089:
            java.lang.String r10 = r9.getHost()     // Catch:{ Exception -> 0x09c0 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r11 == 0) goto L_0x0094
            return r8
        L_0x0094:
            boolean r11 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09c0 }
            if (r11 != 0) goto L_0x00ae
            java.lang.String r11 = "homepage"
            boolean r11 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09c0 }
            if (r11 == 0) goto L_0x00a3
            goto L_0x00ae
        L_0x00a3:
            java.lang.String r11 = "deals"
            boolean r11 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x09c0 }
            if (r11 == 0) goto L_0x00af
            java.lang.String r10 = "deals"
            goto L_0x00af
        L_0x00ae:
            r10 = r3
        L_0x00af:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x09c0 }
            r11.<init>()     // Catch:{ Exception -> 0x09c0 }
            boolean r12 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r12 != 0) goto L_0x00bd
            r11.setUrl(r4)     // Catch:{ Exception -> 0x09c0 }
        L_0x00bd:
            r11.setDeeplink(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setUrlType(r10)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r12 = "isAppLink=true"
            boolean r2 = r2.contains(r12)     // Catch:{ Exception -> 0x09c0 }
            r12 = 0
            r13 = 1
            if (r2 == 0) goto L_0x00d1
            r11.setAppLink(r13)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x00d4
        L_0x00d1:
            r11.setAppLink(r12)     // Catch:{ Exception -> 0x09c0 }
        L_0x00d4:
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r14 = "utm"
            boolean r2 = r2.contains(r14)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r14 = "utm_campaign"
            java.lang.String r15 = "utm_content"
            java.lang.String r8 = "utm_term"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "utm_source"
            if (r2 == 0) goto L_0x014a
            net.one97.paytm.common.entity.shopping.CJRUrlUtmData r2 = new net.one97.paytm.common.entity.shopping.CJRUrlUtmData     // Catch:{ Exception -> 0x09c0 }
            r2.<init>()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r16 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09c0 }
            if (r16 == 0) goto L_0x0105
            r16 = r6
            java.lang.String r6 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09c0 }
            r2.addToUtmSource(r6)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x0107
        L_0x0105:
            r16 = r6
        L_0x0107:
            java.lang.String r6 = r9.getQueryParameter(r12)     // Catch:{ Exception -> 0x09c0 }
            if (r6 == 0) goto L_0x0114
            java.lang.String r6 = r9.getQueryParameter(r12)     // Catch:{ Exception -> 0x09c0 }
            r2.setUtmMedium(r6)     // Catch:{ Exception -> 0x09c0 }
        L_0x0114:
            java.lang.String r6 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09c0 }
            if (r6 == 0) goto L_0x0121
            java.lang.String r6 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09c0 }
            r2.setUtmTerm(r6)     // Catch:{ Exception -> 0x09c0 }
        L_0x0121:
            java.lang.String r6 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09c0 }
            if (r6 == 0) goto L_0x012e
            java.lang.String r6 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09c0 }
            r2.setUtmContent(r6)     // Catch:{ Exception -> 0x09c0 }
        L_0x012e:
            java.lang.String r6 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09c0 }
            if (r6 == 0) goto L_0x013b
            java.lang.String r6 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09c0 }
            r2.setUtmCampaign(r6)     // Catch:{ Exception -> 0x09c0 }
        L_0x013b:
            r6 = 1
            r2.setFromPush(r6)     // Catch:{ Exception -> 0x09c0 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x09c0 }
            com.travel.g.a r6 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x09c0 }
            r6.a((net.one97.paytm.common.entity.shopping.CJRUrlUtmData) r2)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x014c
        L_0x014a:
            r16 = r6
        L_0x014c:
            java.lang.String r2 = r9.getQueryParameter(r13)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushUtmSource(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "grid"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0181
            java.lang.String r2 = "smart_list"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0181
            java.lang.String r2 = "list"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0181
            boolean r2 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0181
            java.lang.String r2 = "embed"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "ae_embed"
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09c0 }
            r2 = r2 | r3
            if (r2 == 0) goto L_0x0197
        L_0x0181:
            java.lang.String r2 = "title"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r3 == 0) goto L_0x0194
            int r2 = com.travel.bus.R.string.offer_action_bar     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0194:
            r11.setName(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0197:
            java.lang.String r2 = "utility"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x01dd
            java.lang.String r2 = "utility_creditcard"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x01aa
            goto L_0x01dd
        L_0x01aa:
            java.lang.String r2 = "prepaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x01d7
            java.lang.String r2 = "postpaid"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x01bb
            goto L_0x01d7
        L_0x01bb:
            java.lang.String r2 = "dth"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x01c9
            java.lang.String r2 = "dth"
            r11.setName(r2)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x01ed
        L_0x01c9:
            java.lang.String r2 = "automatic"
            boolean r2 = r2.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x01ed
            java.lang.String r2 = "automatic"
            r11.setName(r2)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x01ed
        L_0x01d7:
            java.lang.String r2 = "Mobile"
            r11.setName(r2)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x01ed
        L_0x01dd:
            java.lang.String r2 = "title"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r3 != 0) goto L_0x01ed
            r11.setName(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x01ed:
            java.lang.String r2 = "checkout"
            boolean r2 = r2.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x01f9
            r2 = 2
            r11.setDeeplinkType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x01f9:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0300
            java.util.Set r2 = r9.getQueryParameterNames()     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x0300
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x09c0 }
        L_0x0209:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r6 = "&"
            java.lang.String r13 = "?"
            if (r3 == 0) goto L_0x027c
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x09c0 }
            boolean r17 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x09c0 }
            if (r17 != 0) goto L_0x0273
            r17 = r2
            java.lang.String r2 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r18 = r5
            java.lang.String r5 = "related_category"
            boolean r5 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x09c0 }
            if (r5 == 0) goto L_0x0236
            java.lang.String r5 = "utf-8"
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r5)     // Catch:{ Exception -> 0x09c0 }
        L_0x0236:
            boolean r5 = r4.contains(r13)     // Catch:{ Exception -> 0x09c0 }
            if (r5 != 0) goto L_0x0257
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09c0 }
            r5.<init>()     // Catch:{ Exception -> 0x09c0 }
            r5.append(r4)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r13)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "="
            r5.append(r3)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x09c0 }
            goto L_0x0277
        L_0x0257:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09c0 }
            r5.<init>()     // Catch:{ Exception -> 0x09c0 }
            r5.append(r4)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r6)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "="
            r5.append(r3)     // Catch:{ Exception -> 0x09c0 }
            r5.append(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x09c0 }
            r4 = r2
            goto L_0x0277
        L_0x0273:
            r17 = r2
            r18 = r5
        L_0x0277:
            r2 = r17
            r5 = r18
            goto L_0x0209
        L_0x027c:
            r18 = r5
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0294
            boolean r2 = r4.contains(r6)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x0294
            boolean r2 = r4.contains(r13)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0294
            java.lang.String r4 = r4.replaceFirst(r6, r13)     // Catch:{ Exception -> 0x09c0 }
        L_0x0294:
            int r2 = r4.length()     // Catch:{ Exception -> 0x09c0 }
            r3 = 1
            int r2 = r2 - r3
            char r2 = r4.charAt(r2)     // Catch:{ Exception -> 0x09c0 }
            r5 = 47
            if (r2 != r5) goto L_0x02ac
            int r2 = r4.length()     // Catch:{ Exception -> 0x09c0 }
            int r2 = r2 - r3
            r3 = 0
            java.lang.String r4 = r4.substring(r3, r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x02ac:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02fc
            java.lang.String r2 = "versionidentifier"
            boolean r2 = r4.contains(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02fc
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02fc
            java.lang.String r2 = "train_order_summary"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02fc
            java.lang.String r2 = "train_order_summary_v2"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02fc
            boolean r2 = r4.contains(r13)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x02eb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09c0 }
            r2.<init>()     // Catch:{ Exception -> 0x09c0 }
            r2.append(r4)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "?versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x09c0 }
            goto L_0x02fc
        L_0x02eb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09c0 }
            r2.<init>()     // Catch:{ Exception -> 0x09c0 }
            r2.append(r4)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "&versionidentifier=1"
            r2.append(r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x09c0 }
        L_0x02fc:
            r11.setUrl(r4)     // Catch:{ Exception -> 0x09c0 }
            goto L_0x0302
        L_0x0300:
            r18 = r5
        L_0x0302:
            java.lang.String r2 = "quantity"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushQuantity(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "promo_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushPromoCode(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "product_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushProductId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "amount"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCashAdd(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "wallet_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushWalletCode(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "recipient"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRecipient(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "comment"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushComment(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r12)     // Catch:{ Exception -> 0x09c0 }
            r11.setUtmMedium(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r8)     // Catch:{ Exception -> 0x09c0 }
            r11.setUtmTerm(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r15)     // Catch:{ Exception -> 0x09c0 }
            r11.setUtmContent(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r14)     // Catch:{ Exception -> 0x09c0 }
            r11.setUtmCampaign(r2)     // Catch:{ Exception -> 0x09c0 }
            r2 = 1
            r11.setDeepLinking(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "max_price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setMaxPrice(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "min_price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setMinPrice(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "showpopup"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r3 != 0) goto L_0x0397
            java.lang.String r3 = "true"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x0397
            r2 = 1
            r11.setPushShowPopup(r2)     // Catch:{ Exception -> 0x09c0 }
            r3 = 0
            goto L_0x039b
        L_0x0397:
            r3 = 0
            r11.setPushShowPopup(r3)     // Catch:{ Exception -> 0x09c0 }
        L_0x039b:
            java.lang.String r2 = "check_in_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCheckInDate(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "check_out_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCheckOutDate(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "city"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCity(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "city_value"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCityValue(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "rooms_details"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRoomDetailsJson(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "filter_params"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFilterJson(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "query_string"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setQueryString(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "qrid"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setQrid(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "hotel_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushHotelName(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "hotel_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushHotelId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "hotel_extras"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushHotelExtras(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "hotel_final_price_with_tax"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushHotelFinalPriceWithTax(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "source_city_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushSourceCityName(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "source_city_short_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushSourceCityShortName(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "destination_city_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushDestinationCityName(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "destination_city_short_name"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushDestinationCityShortName(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushDate(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "passenger_count"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushPassengerCount(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "recharge_number"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRechargeNumber(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "price"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRechargeAmount(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "promo"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRechargePromo(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "roaming"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushRechargeRoaming(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "type"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushType(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushCode(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "content_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setContentID(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "movie_code"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setMovieCode(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "flight_class"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFlightClass(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "flight_trip_type"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFlightTripType(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "flight_depart_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFlightDepartDate(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "flight_return_date"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFlightReturnDate(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "referrer"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x04b6 }
            com.paytm.utility.b.i((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x04b6 }
            goto L_0x04c3
        L_0x04b6:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x04c3
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x09c0 }
            com.paytm.utility.q.c(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x04c3:
            java.lang.String r1 = "deeplinking"
            r11.setOrigin(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ac     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setIfsc(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22436d     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setBankName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.u     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setVertical(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.w     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setDbtConsent(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "non_aadhaar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setNonAadhaar(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "open_screen"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setOpenScreen(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "aadhaar_otp"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setAadhaarOtp(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.v     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setForm60(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.t     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCallBackUrl(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.aa     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setBankAccountNumber(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22441i     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setAccount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.k     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMtReminderKey(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.j     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMtTitle(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22437e     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPayeeAddress(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22438f     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPayeeName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22439g     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMtComment(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.travel.bus.busticket.i.h.f22440h     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMtAmount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ab     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setBankUserName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ae     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setBankComment(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ad     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setBankAmount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "source"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrainSourceCityCode(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "destination"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrainDestinationCityCode(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "departureDate"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrainDepartureDate(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "source_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrainSourceCityName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "destination_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrainDestinationCityName(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r9 == 0) goto L_0x05c4
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r1 == 0) goto L_0x05c4
            java.lang.String r1 = "is_round_trip"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r12 = r1.booleanValue()     // Catch:{ Exception -> 0x09c0 }
            r3 = r12
        L_0x05c4:
            r11.setTrainRoundTrip(r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.af     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2pmobilenumber(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ag     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2pamount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ah     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2pcomment(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "events_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setEventName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "events_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmEventId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setEventCategory(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "sub_category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setEventSubCategory(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setEventProviderId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setEventCityName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "groupid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmGroupId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "park_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "park_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "category_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkCategory(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "provider_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkProviderId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "city_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkCityName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "cityLabel"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmParkcityLabel(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "cityValue"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setParkcityValue(r1)     // Catch:{ Exception -> 0x09c0 }
            r1 = r18
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setGiftCardUrl(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.aj     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setLanding_page(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ai     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMode(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ak     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setKyc_name(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.al     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setAadhar_number(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = com.paytm.utility.e.ap     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setOverlay(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "issueTicketNumber"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmTicketId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "referral"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmFlightReferral(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "cinema_movie_code"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCinemaMovieCode(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "movie_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMovieName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "post_order_fb_cinemaId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPostOrderCinemaId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "post_order_fb_providerId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPostOrderProviderId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2mamount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "recipient"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setMerchantMID(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "comment"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2mComment(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "commnet_editable"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2mIsCommentEnable(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "amount_editable"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setP2mIsAmountEnable(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "parent_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setContactUsIssueParentId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "vertical_label"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setContactUsIssueVerticalLabel(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "feature-type"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setFeatureType(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "lifafaId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setLifafaId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09c0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r1 != 0) goto L_0x0730
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09c0 }
            r11.setFeatureType(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x0730:
            java.lang.String r1 = "screen"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCashbackScreen(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "gameid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCashbackOfferId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "campaignid"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCashbackCampaignId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "offertag"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setCashbackOfferTag(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "insurance_4w"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r1 != 0) goto L_0x07b7
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x09c0 }
            r1.<init>()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "make"
            java.lang.String r3 = "make"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "model"
            java.lang.String r3 = "model"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "fuelType"
            java.lang.String r3 = "fuelType"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "variant"
            java.lang.String r3 = "variant"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "registrationYear"
            java.lang.String r3 = "registrationYear"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "paytmRtoId"
            java.lang.String r3 = "paytmRtoId"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "previousInsurer"
            java.lang.String r3 = "previousInsurer"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x09c0 }
            r11.setInsuranceParam(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x07b7:
            java.lang.String r1 = "link_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setLinkId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "link_name"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setLinkName(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r7)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09c0 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x09c0 }
            com.travel.g.a r1 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r1.C()     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPdcQrCodeId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r1 != 0) goto L_0x07f7
            java.lang.String r1 = "cst_adhar"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x07f7:
            java.lang.String r1 = "parentreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setParentreason(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "replacementreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setReplacementreson(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "childreason"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setChildreason(r1)     // Catch:{ Exception -> 0x09c0 }
            r1 = r16
            java.lang.String r2 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0825
            java.lang.String r2 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0825:
            java.lang.String r2 = "help_topic"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x083a
            java.lang.String r2 = "help_topic"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x083a:
            java.lang.String r2 = "vertical_detail"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0851
            java.lang.String r2 = "vertical_detail"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0851:
            java.lang.String r2 = "all_topics"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0866
            java.lang.String r2 = "all_topics"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0866:
            java.lang.String r2 = "all_videos"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x087b
            java.lang.String r2 = "all_videos"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x087b:
            java.lang.String r2 = "verticalid"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setVerticalid(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "l1"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setL1(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "l2"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setL2(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "trendingId"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setTrendingId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "verticalId"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setVerticalId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "templateId"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setTemplateId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "orderId"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setCstOrderId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "item_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setCstItemId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x08d8
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setPushFeatureType(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x08d8:
            java.lang.String r1 = "issueId"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setIssueId(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "issueText"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setIssueText(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "tab"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setTab(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setItemID(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "landing"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmLandingPage(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmType(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "amount"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmAmount(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "gram"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setmGram(r1)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r1 = "proceed"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x0953
            java.lang.String r2 = "fastpay"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x0953
            java.lang.String r2 = "id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r3 == 0) goto L_0x0950
            java.lang.String r3 = "="
            java.lang.String[] r3 = r10.split(r3)     // Catch:{ Exception -> 0x09c0 }
            if (r3 == 0) goto L_0x0950
            int r4 = r3.length     // Catch:{ Exception -> 0x09c0 }
            r5 = 1
            if (r4 <= r5) goto L_0x0950
            r2 = r3[r5]     // Catch:{ Exception -> 0x09c0 }
        L_0x0950:
            r11.setSsId(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x0953:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x097c
            java.lang.String r2 = "edc_receipt"
            boolean r2 = r10.contains(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r2 == 0) goto L_0x097c
            java.lang.String r2 = "mid"
            r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "tid"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r3 = "acquirementId"
            java.lang.String r3 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x09c0 }
            r11.setAcquirementId(r3)     // Catch:{ Exception -> 0x09c0 }
            r11.setMid(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setTxnId(r2)     // Catch:{ Exception -> 0x09c0 }
        L_0x097c:
            java.lang.String r2 = "category"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setmVibeCategory(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "article_id"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setmVibeArticleId(r2)     // Catch:{ Exception -> 0x09c0 }
            java.lang.String r2 = "locale"
            java.lang.String r2 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x09c0 }
            r11.setLocale(r2)     // Catch:{ Exception -> 0x09c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x09c0 }
            if (r2 != 0) goto L_0x09aa
            java.lang.String r2 = "true"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r1 == 0) goto L_0x09aa
            r1 = 1
            r11.setmProceed(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x09aa:
            java.lang.String r1 = "gamepind"
            java.lang.String r2 = r11.getURLType()     // Catch:{ Exception -> 0x09c0 }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x09c0 }
            if (r1 == 0) goto L_0x09bf
            java.lang.String r1 = "product_id"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x09c0 }
            r11.setContentID(r1)     // Catch:{ Exception -> 0x09c0 }
        L_0x09bf:
            return r11
        L_0x09c0:
            r0 = move-exception
            r1 = r0
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.c(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.u.a(android.content.Context, java.lang.String):net.one97.paytm.common.entity.shopping.CJRHomePageItem");
    }
}
