package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import io.branch.referral.m;
import io.branch.referral.s;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONObject;

class ab {
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f46421b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static ab f46422c;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final List<s> f46423a;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences f46424d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences.Editor f46425e = this.f46424d.edit();

    public static ab a(Context context) {
        if (f46422c == null) {
            synchronized (ab.class) {
                if (f46422c == null) {
                    f46422c = new ab(context);
                }
            }
        }
        return f46422c;
    }

    private ab(Context context) {
        this.f46424d = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.f46423a = b(context);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        new Thread(new Runnable() {
            public final void run() {
                JSONObject g2;
                JSONArray jSONArray = new JSONArray();
                synchronized (ab.f46421b) {
                    for (s sVar : ab.this.f46423a) {
                        if (sVar.d() && (g2 = sVar.g()) != null) {
                            jSONArray.put(g2);
                        }
                    }
                }
                try {
                    ab.this.f46425e.putString("BNCServerRequestQueue", jSONArray.toString()).commit();
                } catch (Exception e2) {
                    String message = e2.getMessage();
                    StringBuilder sb = new StringBuilder("Failed to persist queue");
                    if (message == null) {
                        message = "";
                    }
                    sb.append(message);
                    q.h(sb.toString());
                }
            }
        }).start();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<io.branch.referral.s> b(android.content.Context r7) {
        /*
            r6 = this;
            android.content.SharedPreferences r0 = r6.f46424d
            java.lang.String r1 = "BNCServerRequestQueue"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.List r1 = java.util.Collections.synchronizedList(r1)
            java.lang.Object r2 = f46421b
            monitor-enter(r2)
            if (r0 == 0) goto L_0x0039
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0039 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0039 }
            r0 = 0
            int r4 = r3.length()     // Catch:{ JSONException -> 0x0039 }
            r5 = 25
            int r4 = java.lang.Math.min(r4, r5)     // Catch:{ JSONException -> 0x0039 }
        L_0x0027:
            if (r0 >= r4) goto L_0x0039
            org.json.JSONObject r5 = r3.getJSONObject(r0)     // Catch:{ JSONException -> 0x0039 }
            io.branch.referral.s r5 = io.branch.referral.s.a((org.json.JSONObject) r5, (android.content.Context) r7)     // Catch:{ JSONException -> 0x0039 }
            if (r5 == 0) goto L_0x0036
            r1.add(r5)     // Catch:{ JSONException -> 0x0039 }
        L_0x0036:
            int r0 = r0 + 1
            goto L_0x0027
        L_0x0039:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return r1
        L_0x003b:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ab.b(android.content.Context):java.util.List");
    }

    public final int b() {
        int size;
        synchronized (f46421b) {
            size = this.f46423a.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.branch.referral.s c() {
        /*
            r3 = this;
            java.lang.Object r0 = f46421b
            monitor-enter(r0)
            java.util.List<io.branch.referral.s> r1 = r3.f46423a     // Catch:{ IndexOutOfBoundsException | NoSuchElementException -> 0x0012 }
            r2 = 0
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ IndexOutOfBoundsException | NoSuchElementException -> 0x0012 }
            io.branch.referral.s r1 = (io.branch.referral.s) r1     // Catch:{ IndexOutOfBoundsException | NoSuchElementException -> 0x0012 }
            r3.a()     // Catch:{ IndexOutOfBoundsException | NoSuchElementException -> 0x0013 }
            goto L_0x0013
        L_0x0010:
            r1 = move-exception
            goto L_0x0015
        L_0x0012:
            r1 = 0
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return r1
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ab.c():io.branch.referral.s");
    }

    /* access modifiers changed from: package-private */
    public final s d() {
        s sVar;
        synchronized (f46421b) {
            try {
                sVar = this.f46423a.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                sVar = null;
            }
        }
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public final s a(int i2) {
        s sVar;
        synchronized (f46421b) {
            try {
                sVar = this.f46423a.get(i2);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                sVar = null;
            }
        }
        return sVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(io.branch.referral.s r3, int r4) {
        /*
            r2 = this;
            java.lang.Object r0 = f46421b
            monitor-enter(r0)
            java.util.List<io.branch.referral.s> r1 = r2.f46423a     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            int r1 = r1.size()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            if (r1 >= r4) goto L_0x0011
            java.util.List<io.branch.referral.s> r4 = r2.f46423a     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            int r4 = r4.size()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
        L_0x0011:
            java.util.List<io.branch.referral.s> r1 = r2.f46423a     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            r1.add(r4, r3)     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            r2.a()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            goto L_0x001e
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ab.a(io.branch.referral.s, int):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(io.branch.referral.s r3) {
        /*
            r2 = this;
            java.lang.Object r0 = f46421b
            monitor-enter(r0)
            java.util.List<io.branch.referral.s> r1 = r2.f46423a     // Catch:{ UnsupportedOperationException -> 0x000f }
            boolean r3 = r1.remove(r3)     // Catch:{ UnsupportedOperationException -> 0x000f }
            r2.a()     // Catch:{ UnsupportedOperationException -> 0x0010 }
            goto L_0x0010
        L_0x000d:
            r3 = move-exception
            goto L_0x0012
        L_0x000f:
            r3 = 0
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return r3
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ab.a(io.branch.referral.s):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r2 = this;
            java.lang.Object r0 = f46421b
            monitor-enter(r0)
            java.util.List<io.branch.referral.s> r1 = r2.f46423a     // Catch:{ UnsupportedOperationException -> 0x000e }
            r1.clear()     // Catch:{ UnsupportedOperationException -> 0x000e }
            r2.a()     // Catch:{ UnsupportedOperationException -> 0x000e }
            goto L_0x000e
        L_0x000c:
            r1 = move-exception
            goto L_0x0010
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ab.e():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        synchronized (f46421b) {
            for (s next : this.f46423a) {
                if (next != null && next.f46574c.equals(m.d.RegisterClose.getPath())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        synchronized (f46421b) {
            for (s sVar : this.f46423a) {
                if (sVar instanceof z) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(s.b bVar) {
        synchronized (f46421b) {
            for (s next : this.f46423a) {
                if (next != null) {
                    next.b(bVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        synchronized (f46421b) {
            for (s next : this.f46423a) {
                if (next != null && (next instanceof z)) {
                    next.a(s.b.STRONG_MATCH_PENDING_WAIT_LOCK);
                }
            }
        }
    }
}
