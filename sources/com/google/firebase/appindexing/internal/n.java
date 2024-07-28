package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.api.internal.t;

final class n extends t<h, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f38036a;

    n(l lVar) {
        this.f38036a = lVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.google.firebase.appindexing.internal.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.google.firebase.appindexing.internal.l} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void doExecute(com.google.android.gms.common.api.a.b r6, com.google.android.gms.tasks.f r7) throws android.os.RemoteException {
        /*
            r5 = this;
            com.google.firebase.appindexing.internal.h r6 = (com.google.firebase.appindexing.internal.h) r6
            android.os.IInterface r6 = r6.r()
            com.google.firebase.appindexing.internal.t r6 = (com.google.firebase.appindexing.internal.t) r6
            com.google.firebase.appindexing.internal.q r0 = new com.google.firebase.appindexing.internal.q
            r0.<init>(r5, r7)
            com.google.firebase.appindexing.internal.l r1 = r5.f38036a
            com.google.firebase.appindexing.internal.zzy r1 = r1.f38029a
            com.google.firebase.appindexing.internal.zzg r6 = r6.a(r0, r1)
            r0 = 2
            if (r6 != 0) goto L_0x001a
            r6 = 2
            goto L_0x001c
        L_0x001a:
            int r6 = r6.f38059a
        L_0x001c:
            r1 = 3
            r2 = 0
            r3 = 1
            r4 = 0
            if (r6 != r1) goto L_0x0063
            r6 = 4
            com.google.firebase.appindexing.internal.v.a((int) r6)
            boolean r6 = r7.b(r4)
            if (r6 == 0) goto L_0x00c3
            com.google.firebase.appindexing.internal.l r6 = r5.f38036a
            com.google.firebase.appindexing.internal.m r6 = r6.f38031c
            java.util.Queue r6 = r6.f38034c
            monitor-enter(r6)
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x0060 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x0060 }
            int r7 = r7.f38035d     // Catch:{ all -> 0x0060 }
            if (r7 != 0) goto L_0x0057
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x0060 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x0060 }
            java.util.Queue r7 = r7.f38034c     // Catch:{ all -> 0x0060 }
            java.lang.Object r7 = r7.peek()     // Catch:{ all -> 0x0060 }
            r4 = r7
            com.google.firebase.appindexing.internal.l r4 = (com.google.firebase.appindexing.internal.l) r4     // Catch:{ all -> 0x0060 }
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x0060 }
            if (r4 != r7) goto L_0x0053
            r2 = 1
        L_0x0053:
            com.google.android.gms.common.internal.s.a((boolean) r2)     // Catch:{ all -> 0x0060 }
            goto L_0x005e
        L_0x0057:
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x0060 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x0060 }
            int unused = r7.f38035d = r0     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x00c3
        L_0x0060:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            throw r7
        L_0x0063:
            if (r6 == r3) goto L_0x008c
            r0 = 41
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "API call failed. Status code: "
            r1.append(r0)
            r1.append(r6)
            r6 = 6
            com.google.firebase.appindexing.internal.v.a((int) r6)
            boolean r6 = r7.b(r4)
            if (r6 == 0) goto L_0x008c
            com.google.firebase.appindexing.internal.l r6 = r5.f38036a
            com.google.android.gms.tasks.f<java.lang.Void> r6 = r6.f38030b
            com.google.firebase.appindexing.c r7 = new com.google.firebase.appindexing.c
            java.lang.String r0 = "Indexing error."
            r7.<init>(r0)
            r6.a((java.lang.Exception) r7)
        L_0x008c:
            com.google.firebase.appindexing.internal.l r6 = r5.f38036a
            com.google.firebase.appindexing.internal.m r6 = r6.f38031c
            java.util.Queue r6 = r6.f38034c
            monitor-enter(r6)
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x00c9 }
            java.util.Queue r7 = r7.f38034c     // Catch:{ all -> 0x00c9 }
            java.lang.Object r7 = r7.poll()     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.l r7 = (com.google.firebase.appindexing.internal.l) r7     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.l r0 = r5.f38036a     // Catch:{ all -> 0x00c9 }
            if (r7 != r0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r3 = 0
        L_0x00a9:
            com.google.android.gms.common.internal.s.a((boolean) r3)     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x00c9 }
            java.util.Queue r7 = r7.f38034c     // Catch:{ all -> 0x00c9 }
            java.lang.Object r7 = r7.peek()     // Catch:{ all -> 0x00c9 }
            r4 = r7
            com.google.firebase.appindexing.internal.l r4 = (com.google.firebase.appindexing.internal.l) r4     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.l r7 = r5.f38036a     // Catch:{ all -> 0x00c9 }
            com.google.firebase.appindexing.internal.m r7 = r7.f38031c     // Catch:{ all -> 0x00c9 }
            int unused = r7.f38035d = r2     // Catch:{ all -> 0x00c9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00c9 }
        L_0x00c3:
            if (r4 == 0) goto L_0x00c8
            r4.a()
        L_0x00c8:
            return
        L_0x00c9:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00c9 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.appindexing.internal.n.doExecute(com.google.android.gms.common.api.a$b, com.google.android.gms.tasks.f):void");
    }
}
