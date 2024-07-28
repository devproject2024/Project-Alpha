package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

final class ai {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f38801a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Pair<String, String>, Task<w>> f38802b = new androidx.a.a();

    interface a {
        Task<w> a();
    }

    ai(Executor executor) {
        this.f38801a = executor;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.tasks.Task<com.google.firebase.iid.w> a(java.lang.String r3, java.lang.String r4, com.google.firebase.iid.ai.a r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x006f }
            r0.<init>(r3, r4)     // Catch:{ all -> 0x006f }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, com.google.android.gms.tasks.Task<com.google.firebase.iid.w>> r3 = r2.f38802b     // Catch:{ all -> 0x006f }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.tasks.Task r3 = (com.google.android.gms.tasks.Task) r3     // Catch:{ all -> 0x006f }
            r4 = 3
            if (r3 == 0) goto L_0x0036
            java.lang.String r5 = "FirebaseInstanceId"
            boolean r4 = android.util.Log.isLoggable(r5, r4)     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0034
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006f }
            int r5 = r5.length()     // Catch:{ all -> 0x006f }
            int r5 = r5 + 29
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r0.<init>(r5)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Joining ongoing request for: "
            r0.append(r5)     // Catch:{ all -> 0x006f }
            r0.append(r4)     // Catch:{ all -> 0x006f }
        L_0x0034:
            monitor-exit(r2)
            return r3
        L_0x0036:
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r4)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0059
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x006f }
            int r4 = r4.length()     // Catch:{ all -> 0x006f }
            int r4 = r4 + 24
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r1.<init>(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Making new request for: "
            r1.append(r4)     // Catch:{ all -> 0x006f }
            r1.append(r3)     // Catch:{ all -> 0x006f }
        L_0x0059:
            com.google.android.gms.tasks.Task r3 = r5.a()     // Catch:{ all -> 0x006f }
            java.util.concurrent.Executor r4 = r2.f38801a     // Catch:{ all -> 0x006f }
            com.google.firebase.iid.aj r5 = new com.google.firebase.iid.aj     // Catch:{ all -> 0x006f }
            r5.<init>(r2, r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.tasks.Task r3 = r3.b(r4, r5)     // Catch:{ all -> 0x006f }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, com.google.android.gms.tasks.Task<com.google.firebase.iid.w>> r4 = r2.f38802b     // Catch:{ all -> 0x006f }
            r4.put(r0, r3)     // Catch:{ all -> 0x006f }
            monitor-exit(r2)
            return r3
        L_0x006f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ai.a(java.lang.String, java.lang.String, com.google.firebase.iid.ai$a):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f38802b.remove(pair);
        }
        return task;
    }
}
