package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

final class t {

    /* renamed from: a  reason: collision with root package name */
    final Runtime f39231a;

    /* renamed from: b  reason: collision with root package name */
    final ActivityManager f39232b;

    /* renamed from: c  reason: collision with root package name */
    final ActivityManager.MemoryInfo f39233c;

    /* renamed from: d  reason: collision with root package name */
    final String f39234d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f39235e;

    t(Context context) {
        this(Runtime.getRuntime(), context);
    }

    private t(Runtime runtime, Context context) {
        String str;
        this.f39231a = runtime;
        this.f39235e = context;
        this.f39232b = (ActivityManager) context.getSystemService("activity");
        this.f39233c = new ActivityManager.MemoryInfo();
        this.f39232b.getMemoryInfo(this.f39233c);
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.f39232b.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
            this.f39234d = str;
        }
        str = this.f39235e.getPackageName();
        this.f39234d = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(java.lang.String r5) {
        /*
            java.lang.String r0 = "' file: "
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            r3.<init>(r5)     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0042 }
        L_0x0011:
            if (r3 == 0) goto L_0x003e
            java.lang.String r4 = "MemTotal"
            boolean r4 = r3.startsWith(r4)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = "\\d+"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ all -> 0x0042 }
            java.util.regex.Matcher r3 = r4.matcher(r3)     // Catch:{ all -> 0x0042 }
            boolean r4 = r3.find()     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0034
            java.lang.String r3 = r3.group()     // Catch:{ all -> 0x0042 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0042 }
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            return r3
        L_0x0039:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0042 }
            goto L_0x0011
        L_0x003e:
            r2.close()     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
            goto L_0x00a5
        L_0x0042:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r2 = move-exception
            com.google.android.gms.internal.p001firebaseperf.j.a(r3, r2)     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
        L_0x004d:
            throw r4     // Catch:{ IOException -> 0x007a, NumberFormatException -> 0x004e }
        L_0x004e:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r5)
            int r3 = r3.length()
            int r3 = r3 + 25
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unable to parse '"
            r4.append(r3)
            r4.append(r5)
            r4.append(r0)
            r4.append(r2)
            goto L_0x00a5
        L_0x007a:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r5)
            int r3 = r3.length()
            int r3 = r3 + 24
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unable to read '"
            r4.append(r3)
            r4.append(r5)
            r4.append(r0)
            r4.append(r2)
        L_0x00a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.t.a(java.lang.String):int");
    }
}
