package com.paytm.analytics.schedulers;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f40976a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f40977b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static int f40978c = 2;

    private b() {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0166 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC, Splitter:B:34:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[SYNTHETIC, Splitter:B:37:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.paytm.analytics.models.Config r9, com.paytm.analytics.data.a r10, com.paytm.analytics.schedulers.a r11, boolean r12) throws com.paytm.a.a {
        /*
            java.lang.String r0 = "config"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "analyticsEventRepository"
            kotlin.g.b.k.c(r10, r0)
            java.lang.Object r0 = f40977b
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            if (r12 == 0) goto L_0x0016
            java.util.List r3 = r10.b()     // Catch:{  }
            goto L_0x001a
        L_0x0016:
            java.util.List r3 = r10.a()     // Catch:{  }
        L_0x001a:
            r4 = 2
            if (r3 == 0) goto L_0x0171
            boolean r5 = r3.isEmpty()     // Catch:{  }
            if (r5 == 0) goto L_0x0025
            goto L_0x0171
        L_0x0025:
            f40978c = r4     // Catch:{  }
        L_0x0027:
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{  }
            if (r11 == 0) goto L_0x0035
            boolean r11 = r11.isEmpty()     // Catch:{  }
            if (r11 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r11 = 0
            goto L_0x0036
        L_0x0035:
            r11 = 1
        L_0x0036:
            if (r11 != 0) goto L_0x0166
            com.paytm.a.a.b$b r11 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r5 = "SignalSDKLog - PaytmAnalytics Trying to upload events: "
            r4.<init>(r5)     // Catch:{  }
            int r5 = r3.size()     // Catch:{  }
            r4.append(r5)     // Catch:{  }
            java.lang.String r4 = r4.toString()     // Catch:{  }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{  }
            r11.a(r4, r5)     // Catch:{  }
            com.paytm.pai.network.model.EventResponse r11 = a(r9, r3)     // Catch:{  }
            com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r6 = "SignalSDKLog - PaytmAnalytics Result of upload is: "
            r5.<init>(r6)     // Catch:{  }
            if (r11 == 0) goto L_0x0065
            java.lang.Integer r6 = r11.getResponseCode()     // Catch:{  }
            goto L_0x0066
        L_0x0065:
            r6 = 0
        L_0x0066:
            r7 = 202(0xca, float:2.83E-43)
            if (r6 != 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            int r6 = r6.intValue()     // Catch:{  }
            if (r6 != r7) goto L_0x0073
            r6 = 1
            goto L_0x0074
        L_0x0073:
            r6 = 0
        L_0x0074:
            r5.append(r6)     // Catch:{  }
            java.lang.String r5 = r5.toString()     // Catch:{  }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{  }
            r4.a(r5, r6)     // Catch:{  }
            if (r11 != 0) goto L_0x0084
            monitor-exit(r0)     // Catch:{ a -> 0x01bc, Exception -> 0x01b2 }
            return r2
        L_0x0084:
            java.lang.Boolean r4 = r11.isDiscard()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 != 0) goto L_0x00bf
            java.lang.Boolean r4 = r11.isSuccess()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 == 0) goto L_0x00b1
            java.lang.Boolean r4 = r11.isDoNotRetry()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 != 0) goto L_0x00a9
            goto L_0x00b1
        L_0x00a9:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{  }
            r9.<init>()     // Catch:{  }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x00b1:
            java.lang.Boolean r4 = r11.isSuccess()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 == 0) goto L_0x00bf
            monitor-exit(r0)     // Catch:{ a -> 0x01bc, Exception -> 0x01b2 }
            return r2
        L_0x00bf:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{  }
            r4.<init>()     // Catch:{  }
            java.util.List r4 = (java.util.List) r4     // Catch:{  }
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{  }
            int r5 = r5.size()     // Catch:{  }
            r6 = 0
        L_0x00ce:
            if (r6 >= r5) goto L_0x00f1
            java.lang.Object r8 = r3.get(r6)     // Catch:{  }
            com.paytm.analytics.models.SignalEvent r8 = (com.paytm.analytics.models.SignalEvent) r8     // Catch:{  }
            java.lang.Long r8 = r8.getId$paytmanalytics_release()     // Catch:{  }
            if (r8 == 0) goto L_0x00ee
            java.lang.Object r8 = r3.get(r6)     // Catch:{  }
            com.paytm.analytics.models.SignalEvent r8 = (com.paytm.analytics.models.SignalEvent) r8     // Catch:{  }
            java.lang.Long r8 = r8.getId$paytmanalytics_release()     // Catch:{  }
            if (r8 != 0) goto L_0x00eb
            kotlin.g.b.k.a()     // Catch:{  }
        L_0x00eb:
            r4.add(r8)     // Catch:{  }
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x00ce
        L_0x00f1:
            r10.a((java.util.List<java.lang.Long>) r4)     // Catch:{  }
            com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r6 = "Upload successful count: "
            r5.<init>(r6)     // Catch:{  }
            int r6 = r3.size()     // Catch:{  }
            r5.append(r6)     // Catch:{  }
            java.lang.String r5 = r5.toString()     // Catch:{  }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{  }
            r4.a(r5, r6)     // Catch:{  }
            java.lang.Integer r11 = r11.getResponseCode()     // Catch:{  }
            if (r11 != 0) goto L_0x0114
            goto L_0x0158
        L_0x0114:
            int r11 = r11.intValue()     // Catch:{  }
            if (r11 != r7) goto L_0x0158
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{  }
            int r11 = r11.size()     // Catch:{  }
            r4 = 0
        L_0x0122:
            if (r4 >= r11) goto L_0x0158
            com.paytm.a.a.b$b r5 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r7 = "SignalSDKLog - PaytmAnalytics Event uploaded "
            r6.<init>(r7)     // Catch:{  }
            java.lang.Object r7 = r3.get(r4)     // Catch:{  }
            com.paytm.analytics.models.SignalEvent r7 = (com.paytm.analytics.models.SignalEvent) r7     // Catch:{  }
            java.lang.Object r7 = r7.getPayload()     // Catch:{  }
            r6.append(r7)     // Catch:{  }
            java.lang.String r7 = " type:"
            r6.append(r7)     // Catch:{  }
            java.lang.Object r7 = r3.get(r4)     // Catch:{  }
            com.paytm.analytics.models.SignalEvent r7 = (com.paytm.analytics.models.SignalEvent) r7     // Catch:{  }
            java.lang.String r7 = r7.getEventType()     // Catch:{  }
            r6.append(r7)     // Catch:{  }
            java.lang.String r6 = r6.toString()     // Catch:{  }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{  }
            r5.a(r6, r7)     // Catch:{  }
            int r4 = r4 + 1
            goto L_0x0122
        L_0x0158:
            if (r12 == 0) goto L_0x015f
            java.util.List r11 = r10.b()     // Catch:{  }
            goto L_0x0163
        L_0x015f:
            java.util.List r11 = r10.a()     // Catch:{  }
        L_0x0163:
            r3 = r11
            goto L_0x0027
        L_0x0166:
            com.paytm.a.a.b$b r9 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.String r10 = "Upload complete successfully"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{  }
            r9.a(r10, r11)     // Catch:{  }
            monitor-exit(r0)     // Catch:{ a -> 0x01bc, Exception -> 0x01b2 }
            return r1
        L_0x0171:
            int r9 = f40978c     // Catch:{  }
            if (r9 > 0) goto L_0x0189
            com.paytm.a.a.b$b r9 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.String r10 = "Periodic event sync has no job left to do - cancelling work manager "
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{  }
            r9.a(r10, r12)     // Catch:{  }
            if (r11 == 0) goto L_0x0186
            java.lang.String r9 = "sync_periodic_events_tag"
            r11.a((java.lang.String) r9)     // Catch:{  }
        L_0x0186:
            f40978c = r4     // Catch:{  }
            goto L_0x01a6
        L_0x0189:
            int r9 = f40978c     // Catch:{  }
            int r9 = r9 + -1
            f40978c = r9     // Catch:{  }
            com.paytm.a.a.b$b r9 = com.paytm.a.a.b.f40832a     // Catch:{  }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r11 = "Periodic event sync has no job left to do - periodicCounter: "
            r10.<init>(r11)     // Catch:{  }
            int r11 = f40978c     // Catch:{  }
            r10.append(r11)     // Catch:{  }
            java.lang.String r10 = r10.toString()     // Catch:{  }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{  }
            r9.a(r10, r11)     // Catch:{  }
        L_0x01a6:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{  }
            java.lang.String r10 = "Periodic Counter 0 is reached - raising do no try exception, nothing to worry :)"
            r9.<init>(r10)     // Catch:{  }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x01b0:
            r9 = move-exception
            goto L_0x01d2
        L_0x01b2:
            r9 = move-exception
            com.paytm.a.a.b$b r10 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x01b0 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x01b0 }
            r10.b(r9)     // Catch:{ all -> 0x01b0 }
            monitor-exit(r0)
            return r1
        L_0x01bc:
            r9 = move-exception
            com.paytm.a.a.b$b r10 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x01b0 }
            java.lang.String r11 = "DoNotRetryException"
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ all -> 0x01b0 }
            r10.a(r11, r12)     // Catch:{ all -> 0x01b0 }
            com.paytm.a.a r10 = new com.paytm.a.a     // Catch:{ all -> 0x01b0 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x01b0 }
            r10.<init>(r9)     // Catch:{ all -> 0x01b0 }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x01b0 }
            throw r10     // Catch:{ all -> 0x01b0 }
        L_0x01d2:
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.schedulers.b.a(com.paytm.analytics.models.Config, com.paytm.analytics.data.a, com.paytm.analytics.schedulers.a, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009f A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.paytm.pai.network.model.EventResponse<?> a(com.paytm.analytics.models.Config r9, java.util.List<com.paytm.analytics.models.SignalEvent> r10) throws com.paytm.a.a {
        /*
            r0 = 0
            com.paytm.analytics.a.a r1 = com.paytm.analytics.a.a.f40907a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = com.paytm.analytics.a.a.a((java.util.List<com.paytm.analytics.models.SignalEvent>) r10, (com.paytm.analytics.models.Config) r9)     // Catch:{ Exception -> 0x00a9 }
            r10 = r5
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00a9 }
            r1 = 1
            if (r10 == 0) goto L_0x0016
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r10 = 0
            goto L_0x0017
        L_0x0016:
            r10 = 1
        L_0x0017:
            if (r10 != 0) goto L_0x009f
            java.lang.String r4 = "/v2/api/signals/batch"
            java.lang.String r10 = r9.getServerEndPoints()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r3 = kotlin.g.b.k.a((java.lang.String) r10, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = r9.getSecretRequesterID()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = r9.getClientName()     // Catch:{ Exception -> 0x00a9 }
        L_0x002d:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00a9 }
            if (r10 == 0) goto L_0x003a
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r10 = 0
            goto L_0x003b
        L_0x003a:
            r10 = 1
        L_0x003b:
            if (r10 != 0) goto L_0x0095
            java.lang.String r10 = r9.getSecret()     // Catch:{ Exception -> 0x00a9 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00a9 }
            if (r10 == 0) goto L_0x004e
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r10 = 0
            goto L_0x004f
        L_0x004e:
            r10 = 1
        L_0x004f:
            if (r10 != 0) goto L_0x008b
            java.lang.String r10 = r9.getServerEndPoints()     // Catch:{ Exception -> 0x00a9 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00a9 }
            if (r10 == 0) goto L_0x0061
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            if (r1 != 0) goto L_0x0081
            com.paytm.analytics.c r10 = com.paytm.analytics.c.f40931a     // Catch:{ Exception -> 0x00a9 }
            com.paytm.pai.network.d r2 = r10.a()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r6 = r9.getClientName()     // Catch:{ Exception -> 0x00a9 }
            if (r6 != 0) goto L_0x0072
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00a9 }
        L_0x0072:
            java.lang.String r7 = r9.getSecret()     // Catch:{ Exception -> 0x00a9 }
            if (r7 != 0) goto L_0x007b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00a9 }
        L_0x007b:
            r8 = 1
            com.paytm.pai.network.model.EventResponse r9 = r2.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a9 }
            return r9
        L_0x0081:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.serverEndPoints is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x008b:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.secret is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x0095:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.clientName is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x009f:
            com.paytm.a.a r9 = new com.paytm.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "request body is empty"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x00a9:
            r9 = move-exception
            com.paytm.a.a.b$b r10 = com.paytm.a.a.b.f40832a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "Job sync event status unsuccessful"
            r10.b(r1, r0)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.schedulers.b.a(com.paytm.analytics.models.Config, java.util.List):com.paytm.pai.network.model.EventResponse");
    }
}
