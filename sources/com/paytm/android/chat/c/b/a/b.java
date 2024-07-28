package com.paytm.android.chat.c.b.a;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101 A[Catch:{ Exception -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010b A[Catch:{ Exception -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x006e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> a(java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> r11) {
        /*
            java.lang.String r0 = "jsonData.get(ChatConstan…T_ARE_FILTERS_APPLICABLE)"
            java.lang.String r1 = "hasSiteIdFilter"
            java.lang.String r2 = "allChannelDataModelList"
            kotlin.g.b.k.c(r11, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r11 = r11.iterator()
        L_0x0014:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0133
            java.lang.Object r3 = r11.next()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r3 = (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r3
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0130 }
            r4.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r3.getData()     // Catch:{ Exception -> 0x0130 }
            java.lang.Class<com.google.gsonhtcfix.o> r6 = com.google.gsonhtcfix.o.class
            java.lang.Object r4 = r4.a((java.lang.String) r5, r6)     // Catch:{ Exception -> 0x0130 }
            com.google.gsonhtcfix.o r4 = (com.google.gsonhtcfix.o) r4     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = "0"
            com.google.gsonhtcfix.l r6 = r4.b(r1)     // Catch:{ Exception -> 0x0130 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = r6.b()     // Catch:{ Exception -> 0x0130 }
            if (r6 == 0) goto L_0x0050
            com.google.gsonhtcfix.l r5 = r4.b(r1)     // Catch:{ Exception -> 0x0130 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r5.b()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = "jsonData.get(ChatConstan…TERS_APPLICABLE).asString"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0130 }
        L_0x0050:
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r5 == 0) goto L_0x012a
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0130 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = "1"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0130 }
            if (r5 == 0) goto L_0x0014
            java.util.List r5 = r3.getMembers()     // Catch:{ Exception -> 0x0130 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0130 }
        L_0x006e:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x0014
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.data.models.users.ChatUserDataModel r7 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r7     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.getSendbirdUserId()     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r8 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil r8 = r8.getInstance()     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.b.b r8 = r8.getActiveChatFilterConfig()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = r8.f41776b     // Catch:{ Exception -> 0x0130 }
            r9 = 1
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x006e
            java.lang.String r7 = ""
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r8 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil r8 = r8.getInstance()     // Catch:{ Exception -> 0x0130 }
            boolean r8 = r8.isChannelFilter()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r10 = "siteId:"
            if (r8 == 0) goto L_0x00bb
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r8 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil r8 = r8.getInstance()     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.b.b r8 = r8.getActiveChatFilterConfig()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = r8.f41776b     // Catch:{ Exception -> 0x0130 }
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0130 }
            goto L_0x00d7
        L_0x00bb:
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r8 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x0130 }
            com.paytm.android.chat.utils.ChatConfigUtil r8 = r8.getInstance()     // Catch:{ Exception -> 0x0130 }
            boolean r8 = r8.isCustomerFilter()     // Catch:{ Exception -> 0x0130 }
            if (r8 == 0) goto L_0x00d7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x0130 }
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0130 }
        L_0x00d7:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0130 }
            r10 = 0
            if (r8 == 0) goto L_0x00e6
            int r8 = r8.length()     // Catch:{ Exception -> 0x0130 }
            if (r8 != 0) goto L_0x00e4
            goto L_0x00e6
        L_0x00e4:
            r8 = 0
            goto L_0x00e7
        L_0x00e6:
            r8 = 1
        L_0x00e7:
            if (r8 != 0) goto L_0x006e
            com.google.gsonhtcfix.l r8 = r4.b(r7)     // Catch:{ Exception -> 0x0130 }
            if (r8 == 0) goto L_0x006e
            com.google.gsonhtcfix.l r7 = r4.b(r7)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "jsonData.get(filterKey)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x0130 }
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0130 }
            if (r8 == 0) goto L_0x0109
            int r8 = r8.length()     // Catch:{ Exception -> 0x0130 }
            if (r8 != 0) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r9 = 0
        L_0x0109:
            if (r9 != 0) goto L_0x006e
            if (r7 == 0) goto L_0x0124
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x0130 }
            java.lang.CharSequence r7 = kotlin.m.p.b(r7)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "4"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x006e
            r2.add(r3)     // Catch:{ Exception -> 0x0130 }
            goto L_0x006e
        L_0x0124:
            kotlin.u r3 = new kotlin.u     // Catch:{ Exception -> 0x0130 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0130 }
            throw r3     // Catch:{ Exception -> 0x0130 }
        L_0x012a:
            kotlin.u r3 = new kotlin.u     // Catch:{ Exception -> 0x0130 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0130 }
            throw r3     // Catch:{ Exception -> 0x0130 }
        L_0x0130:
            goto L_0x0014
        L_0x0133:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.c.b.a.b.a(java.util.List):java.util.List");
    }
}
