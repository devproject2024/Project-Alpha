package com.paytm.android.chat.c.b.a;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df A[Catch:{ Exception -> 0x010c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> a(java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> r14) {
        /*
            java.lang.String r0 = "1"
            java.lang.String r1 = "jsonData.get(ChatConstan…T_ARE_FILTERS_APPLICABLE)"
            java.lang.String r2 = "hasSiteIdFilter"
            java.lang.String r3 = "allChannelDataModelList"
            kotlin.g.b.k.c(r14, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.lang.String r4 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            java.util.Iterator r14 = r14.iterator()
        L_0x001a:
            boolean r5 = r14.hasNext()
            if (r5 == 0) goto L_0x0111
            java.lang.Object r5 = r14.next()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r5
            com.google.gsonhtcfix.f r6 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x010c }
            r6.<init>()     // Catch:{ Exception -> 0x010c }
            java.lang.String r7 = r5.getData()     // Catch:{ Exception -> 0x010c }
            java.lang.Class<com.google.gsonhtcfix.o> r8 = com.google.gsonhtcfix.o.class
            java.lang.Object r6 = r6.a((java.lang.String) r7, r8)     // Catch:{ Exception -> 0x010c }
            com.google.gsonhtcfix.o r6 = (com.google.gsonhtcfix.o) r6     // Catch:{ Exception -> 0x010c }
            com.google.gsonhtcfix.l r7 = r6.b(r2)     // Catch:{ Exception -> 0x010c }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ Exception -> 0x010c }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x010c }
            java.lang.String r8 = "0"
            if (r7 == 0) goto L_0x0057
            com.google.gsonhtcfix.l r7 = r6.b(r2)     // Catch:{ Exception -> 0x010c }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ Exception -> 0x010c }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x010c }
            java.lang.String r9 = "jsonData.get(ChatConstan…TERS_APPLICABLE).asString"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x0058
        L_0x0057:
            r7 = r8
        L_0x0058:
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r7 == 0) goto L_0x0106
            r10 = r7
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x010c }
            java.lang.CharSequence r10 = kotlin.m.p.b(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x010c }
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ Exception -> 0x010c }
            if (r10 == 0) goto L_0x00fb
            java.lang.String r10 = ""
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r11 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x010c }
            com.paytm.android.chat.utils.ChatConfigUtil r11 = r11.getInstance()     // Catch:{ Exception -> 0x010c }
            boolean r11 = r11.isChannelFilter()     // Catch:{ Exception -> 0x010c }
            java.lang.String r12 = "siteId:"
            if (r11 == 0) goto L_0x0097
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010c }
            r10.<init>(r12)     // Catch:{ Exception -> 0x010c }
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r11 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x010c }
            com.paytm.android.chat.utils.ChatConfigUtil r11 = r11.getInstance()     // Catch:{ Exception -> 0x010c }
            com.paytm.android.chat.b.b r11 = r11.getActiveChatFilterConfig()     // Catch:{ Exception -> 0x010c }
            java.lang.String r11 = r11.f41776b     // Catch:{ Exception -> 0x010c }
            r10.append(r11)     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x010c }
            goto L_0x00ab
        L_0x0097:
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r11 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x010c }
            com.paytm.android.chat.utils.ChatConfigUtil r11 = r11.getInstance()     // Catch:{ Exception -> 0x010c }
            boolean r11 = r11.isCustomerFilter()     // Catch:{ Exception -> 0x010c }
            if (r11 == 0) goto L_0x00ab
            java.lang.String r10 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = r12.concat(r10)     // Catch:{ Exception -> 0x010c }
        L_0x00ab:
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x010c }
            r12 = 0
            r13 = 1
            if (r11 == 0) goto L_0x00bb
            int r11 = r11.length()     // Catch:{ Exception -> 0x010c }
            if (r11 != 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r11 = 0
            goto L_0x00bc
        L_0x00bb:
            r11 = 1
        L_0x00bc:
            if (r11 != 0) goto L_0x00fb
            com.google.gsonhtcfix.l r11 = r6.b(r10)     // Catch:{ Exception -> 0x010c }
            if (r11 == 0) goto L_0x00fb
            com.google.gsonhtcfix.l r6 = r6.b(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.String r10 = "jsonData.get(filterKey)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r10)     // Catch:{ Exception -> 0x010c }
            java.lang.String r6 = r6.b()     // Catch:{ Exception -> 0x010c }
            r10 = r6
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x010c }
            if (r10 == 0) goto L_0x00dc
            int r10 = r10.length()     // Catch:{ Exception -> 0x010c }
            if (r10 != 0) goto L_0x00dd
        L_0x00dc:
            r12 = 1
        L_0x00dd:
            if (r12 != 0) goto L_0x00fb
            if (r6 == 0) goto L_0x00f5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x010c }
            java.lang.CharSequence r6 = kotlin.m.p.b(r6)     // Catch:{ Exception -> 0x010c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x010c }
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)     // Catch:{ Exception -> 0x010c }
            if (r6 == 0) goto L_0x00fb
            r3.add(r5)     // Catch:{ Exception -> 0x010c }
            goto L_0x00fb
        L_0x00f5:
            kotlin.u r6 = new kotlin.u     // Catch:{ Exception -> 0x010c }
            r6.<init>(r9)     // Catch:{ Exception -> 0x010c }
            throw r6     // Catch:{ Exception -> 0x010c }
        L_0x00fb:
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x010c }
            if (r6 == 0) goto L_0x001a
            r3.add(r5)     // Catch:{ Exception -> 0x010c }
            goto L_0x001a
        L_0x0106:
            kotlin.u r6 = new kotlin.u     // Catch:{ Exception -> 0x010c }
            r6.<init>(r9)     // Catch:{ Exception -> 0x010c }
            throw r6     // Catch:{ Exception -> 0x010c }
        L_0x010c:
            r3.add(r5)
            goto L_0x001a
        L_0x0111:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.c.b.a.a.a(java.util.List):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083 A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[Catch:{ Exception -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r8) {
        /*
            java.lang.String r0 = "1"
            java.lang.String r1 = "jsonData.get(ChatConstan…T_ARE_FILTERS_APPLICABLE)"
            java.lang.String r2 = "hasSiteIdFilter"
            r3 = 1
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00b7 }
            r4.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.Class<com.google.gsonhtcfix.o> r5 = com.google.gsonhtcfix.o.class
            java.lang.Object r8 = r4.a((java.lang.String) r8, r5)     // Catch:{ Exception -> 0x00b7 }
            com.google.gsonhtcfix.o r8 = (com.google.gsonhtcfix.o) r8     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x00b7 }
            com.google.gsonhtcfix.l r5 = r8.b(r2)     // Catch:{ Exception -> 0x00b7 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r5 = r5.b()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "0"
            if (r5 == 0) goto L_0x0038
            com.google.gsonhtcfix.l r2 = r8.b(r2)     // Catch:{ Exception -> 0x00b7 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r1 = r2.b()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = "jsonData.get(ChatConstan…TERS_APPLICABLE).asString"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0039
        L_0x0038:
            r1 = r6
        L_0x0039:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r1 == 0) goto L_0x00b1
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00b7 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b7 }
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ Exception -> 0x00b7 }
            r7 = 0
            if (r5 == 0) goto L_0x00a9
            java.lang.String r5 = "siteId:"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ Exception -> 0x00b7 }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00b7 }
            if (r5 == 0) goto L_0x0068
            int r5 = r5.length()     // Catch:{ Exception -> 0x00b7 }
            if (r5 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r5 = 0
            goto L_0x0069
        L_0x0068:
            r5 = 1
        L_0x0069:
            if (r5 != 0) goto L_0x00a9
            com.google.gsonhtcfix.l r5 = r8.b(r4)     // Catch:{ Exception -> 0x00b7 }
            if (r5 == 0) goto L_0x00a9
            com.google.gsonhtcfix.l r8 = r8.b(r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r1 = "jsonData.get(filterKey)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r8.b()     // Catch:{ Exception -> 0x00b7 }
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00b7 }
            if (r1 == 0) goto L_0x008c
            int r1 = r1.length()     // Catch:{ Exception -> 0x00b7 }
            if (r1 != 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r1 = 0
            goto L_0x008d
        L_0x008c:
            r1 = 1
        L_0x008d:
            if (r1 != 0) goto L_0x00a8
            if (r8 == 0) goto L_0x00a2
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00b7 }
            java.lang.CharSequence r8 = kotlin.m.p.b(r8)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b7 }
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ Exception -> 0x00b7 }
            if (r8 == 0) goto L_0x00a8
            return r3
        L_0x00a2:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x00b7 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            throw r8     // Catch:{ Exception -> 0x00b7 }
        L_0x00a8:
            return r7
        L_0x00a9:
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00b7 }
            if (r8 == 0) goto L_0x00b0
            return r3
        L_0x00b0:
            return r7
        L_0x00b1:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x00b7 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            throw r8     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.c.b.a.a.a(java.lang.String):boolean");
    }
}
