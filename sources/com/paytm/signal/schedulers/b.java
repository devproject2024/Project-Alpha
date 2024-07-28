package com.paytm.signal.schedulers;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43659a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f43660b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static int f43661c = 2;

    private b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0104, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0134, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        com.paytm.notification.b.e.f43014a.b(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        com.paytm.notification.b.e.f43014a.a("DoNotRetryException", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0153, code lost:
        throw new com.paytm.notification.schedulers.a.a(r7.getMessage());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x003e, B:66:0x00fa] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x013e A[ExcHandler: a (r7v1 'e' com.paytm.notification.schedulers.a.a A[CUSTOM_DECLARE]), Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.paytm.signal.models.Config r7, com.paytm.signal.data.a r8, com.paytm.signal.schedulers.a r9, boolean r10) throws com.paytm.notification.schedulers.a.a {
        /*
            java.lang.String r0 = "config"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "analyticsEventRepository"
            kotlin.g.b.k.c(r8, r0)
            java.lang.Object r0 = f43660b
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            if (r10 == 0) goto L_0x0016
            java.util.List r3 = r8.b()     // Catch:{  }
            goto L_0x001a
        L_0x0016:
            java.util.List r3 = r8.a()     // Catch:{  }
        L_0x001a:
            r4 = 2
            if (r3 == 0) goto L_0x00e2
            boolean r5 = r3.isEmpty()     // Catch:{  }
            if (r5 == 0) goto L_0x0025
            goto L_0x00e2
        L_0x0025:
            f43661c = r4     // Catch:{  }
        L_0x0027:
            r9 = r3
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{  }
            if (r9 == 0) goto L_0x0035
            boolean r9 = r9.isEmpty()     // Catch:{  }
            if (r9 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r9 = 0
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            if (r9 != 0) goto L_0x00d7
            com.paytm.pai.network.model.EventResponse r9 = a(r7, r3)     // Catch:{  }
            if (r9 != 0) goto L_0x0040
            monitor-exit(r0)     // Catch:{ a -> 0x013e, Exception -> 0x0134 }
            return r2
        L_0x0040:
            java.lang.Boolean r4 = r9.isDiscard()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 != 0) goto L_0x007b
            java.lang.Boolean r4 = r9.isSuccess()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 == 0) goto L_0x006d
            java.lang.Boolean r4 = r9.isDoNotRetry()     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{  }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0065
            goto L_0x006d
        L_0x0065:
            com.paytm.notification.schedulers.a.a r7 = new com.paytm.notification.schedulers.a.a     // Catch:{  }
            r7.<init>()     // Catch:{  }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{  }
            throw r7     // Catch:{  }
        L_0x006d:
            java.lang.Boolean r9 = r9.isSuccess()     // Catch:{  }
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{  }
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{  }
            if (r9 == 0) goto L_0x007b
            monitor-exit(r0)     // Catch:{ a -> 0x013e, Exception -> 0x0134 }
            return r2
        L_0x007b:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{  }
            r9.<init>()     // Catch:{  }
            java.util.List r9 = (java.util.List) r9     // Catch:{  }
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{  }
            int r4 = r4.size()     // Catch:{  }
            r5 = 0
        L_0x008a:
            if (r5 >= r4) goto L_0x00ad
            java.lang.Object r6 = r3.get(r5)     // Catch:{  }
            com.paytm.signal.models.SignalEvent r6 = (com.paytm.signal.models.SignalEvent) r6     // Catch:{  }
            java.lang.Long r6 = r6.getId$paytmnotification_paytmRelease()     // Catch:{  }
            if (r6 == 0) goto L_0x00aa
            java.lang.Object r6 = r3.get(r5)     // Catch:{  }
            com.paytm.signal.models.SignalEvent r6 = (com.paytm.signal.models.SignalEvent) r6     // Catch:{  }
            java.lang.Long r6 = r6.getId$paytmnotification_paytmRelease()     // Catch:{  }
            if (r6 != 0) goto L_0x00a7
            kotlin.g.b.k.a()     // Catch:{  }
        L_0x00a7:
            r9.add(r6)     // Catch:{  }
        L_0x00aa:
            int r5 = r5 + 1
            goto L_0x008a
        L_0x00ad:
            r8.a((java.util.List<java.lang.Long>) r9)     // Catch:{  }
            com.paytm.notification.b.e$b r9 = com.paytm.notification.b.e.f43014a     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r5 = "Upload successful count: "
            r4.<init>(r5)     // Catch:{  }
            int r3 = r3.size()     // Catch:{  }
            r4.append(r3)     // Catch:{  }
            java.lang.String r3 = r4.toString()     // Catch:{  }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{  }
            r9.a(r3, r4)     // Catch:{  }
            if (r10 == 0) goto L_0x00d0
            java.util.List r9 = r8.b()     // Catch:{  }
            goto L_0x00d4
        L_0x00d0:
            java.util.List r9 = r8.a()     // Catch:{  }
        L_0x00d4:
            r3 = r9
            goto L_0x0027
        L_0x00d7:
            com.paytm.notification.b.e$b r7 = com.paytm.notification.b.e.f43014a     // Catch:{  }
            java.lang.String r8 = "Upload complete successfully"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{  }
            r7.a(r8, r9)     // Catch:{  }
            monitor-exit(r0)     // Catch:{ a -> 0x013e, Exception -> 0x0134 }
            return r1
        L_0x00e2:
            int r7 = f43661c     // Catch:{  }
            if (r7 > 0) goto L_0x010b
            com.paytm.notification.b.e$b r7 = com.paytm.notification.b.e.f43014a     // Catch:{  }
            java.lang.String r8 = "Periodic event sync has no job left to do - cancelling work manager "
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{  }
            r7.a(r8, r10)     // Catch:{  }
            if (r9 == 0) goto L_0x0108
            java.lang.String r7 = "sync_periodic_events_tag"
            java.lang.String r8 = "tag"
            kotlin.g.b.k.c(r7, r8)     // Catch:{  }
            androidx.work.v r8 = r9.a()     // Catch:{ Exception -> 0x0104, a -> 0x013e }
            if (r8 == 0) goto L_0x0108
            r8.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0104, a -> 0x013e }
            goto L_0x0108
        L_0x0104:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{  }
        L_0x0108:
            f43661c = r4     // Catch:{  }
            goto L_0x0128
        L_0x010b:
            int r7 = f43661c     // Catch:{  }
            int r7 = r7 + -1
            f43661c = r7     // Catch:{  }
            com.paytm.notification.b.e$b r7 = com.paytm.notification.b.e.f43014a     // Catch:{  }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r9 = "Periodic event sync has no job left to do - periodicCounter: "
            r8.<init>(r9)     // Catch:{  }
            int r9 = f43661c     // Catch:{  }
            r8.append(r9)     // Catch:{  }
            java.lang.String r8 = r8.toString()     // Catch:{  }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{  }
            r7.a(r8, r9)     // Catch:{  }
        L_0x0128:
            com.paytm.notification.schedulers.a.a r7 = new com.paytm.notification.schedulers.a.a     // Catch:{  }
            java.lang.String r8 = "Periodic Counter 0 is reached - raising do no try exception, nothing to worry :)"
            r7.<init>(r8)     // Catch:{  }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{  }
            throw r7     // Catch:{  }
        L_0x0132:
            r7 = move-exception
            goto L_0x0154
        L_0x0134:
            r7 = move-exception
            com.paytm.notification.b.e$b r8 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0132 }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x0132 }
            r8.b(r7)     // Catch:{ all -> 0x0132 }
            monitor-exit(r0)
            return r1
        L_0x013e:
            r7 = move-exception
            com.paytm.notification.b.e$b r8 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = "DoNotRetryException"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x0132 }
            r8.a(r9, r10)     // Catch:{ all -> 0x0132 }
            com.paytm.notification.schedulers.a.a r8 = new com.paytm.notification.schedulers.a.a     // Catch:{ all -> 0x0132 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0132 }
            r8.<init>(r7)     // Catch:{ all -> 0x0132 }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x0132 }
            throw r8     // Catch:{ all -> 0x0132 }
        L_0x0154:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.schedulers.b.a(com.paytm.signal.models.Config, com.paytm.signal.data.a, com.paytm.signal.schedulers.a, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009f A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.paytm.pai.network.model.EventResponse<?> a(com.paytm.signal.models.Config r9, java.util.List<com.paytm.signal.models.SignalEvent> r10) throws com.paytm.notification.schedulers.a.a {
        /*
            r0 = 0
            com.paytm.signal.a.a r1 = com.paytm.signal.a.a.f43590a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = com.paytm.signal.a.a.a((java.util.List<com.paytm.signal.models.SignalEvent>) r10, (com.paytm.signal.models.Config) r9)     // Catch:{ Exception -> 0x00a9 }
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
            com.paytm.signal.c r10 = com.paytm.signal.c.f43614a     // Catch:{ Exception -> 0x00a9 }
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
            com.paytm.notification.schedulers.a.a r9 = new com.paytm.notification.schedulers.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.serverEndPoints is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x008b:
            com.paytm.notification.schedulers.a.a r9 = new com.paytm.notification.schedulers.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.secret is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x0095:
            com.paytm.notification.schedulers.a.a r9 = new com.paytm.notification.schedulers.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "config.clientName is null"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x009f:
            com.paytm.notification.schedulers.a.a r9 = new com.paytm.notification.schedulers.a.a     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "request body is empty"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x00a9 }
            throw r9     // Catch:{ Exception -> 0x00a9 }
        L_0x00a9:
            r9 = move-exception
            com.paytm.notification.b.e$b r10 = com.paytm.notification.b.e.f43014a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "Job sync event status unsuccessful"
            r10.b(r1, r0)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.schedulers.b.a(com.paytm.signal.models.Config, java.util.List):com.paytm.pai.network.model.EventResponse");
    }
}
