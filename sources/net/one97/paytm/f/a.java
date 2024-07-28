package net.one97.paytm.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;

public final class a {

    /* renamed from: g  reason: collision with root package name */
    private static a f50393g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f50394a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f50395b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50396c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f50397d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<DeviceAccount> f50398e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Boolean> f50399f = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f50400h = new ConcurrentHashMap<>();

    public static a a() {
        if (f50393g == null) {
            f50393g = new a();
        }
        return f50393g;
    }

    public final void a(String str, boolean z, boolean z2) {
        if (this.f50400h == null) {
            this.f50400h = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str) && !this.f50400h.containsKey(str)) {
            a(this.f50400h.size(), str, Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r0.<init>()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r4.f50394a = r0     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r0.<init>()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r4.f50399f = r0     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = r4.f50400h     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            if (r0 == 0) goto L_0x003c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = r4.f50400h     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
        L_0x001d:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.ArrayList<java.lang.String> r2 = r4.f50394a     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.lang.Object r3 = r1.getKey()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r2.add(r3)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.util.ArrayList<java.lang.Boolean> r2 = r4.f50399f     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r2.add(r1)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            goto L_0x001d
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0041:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.f.a.b():void");
    }

    private void a(int i2, String str, Boolean bool, Boolean bool2) {
        if (i2 >= 0 && i2 <= this.f50400h.size()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i2 == 0) {
                linkedHashMap.put(str, bool);
                linkedHashMap.putAll(this.f50400h);
            } else {
                if (!bool2.booleanValue()) {
                    linkedHashMap.put(str, bool);
                }
                if (this.f50400h.size() >= 3) {
                    int i3 = 0;
                    for (Map.Entry next : this.f50400h.entrySet()) {
                        if (i3 < 2) {
                            linkedHashMap.put(next.getKey(), next.getValue());
                        }
                        i3++;
                    }
                } else {
                    linkedHashMap.putAll(this.f50400h);
                }
                if (bool2.booleanValue()) {
                    linkedHashMap.put(str, bool);
                }
            }
            this.f50400h.clear();
            this.f50400h.putAll(linkedHashMap);
            linkedHashMap.clear();
        }
    }
}
