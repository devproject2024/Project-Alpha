package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f37517a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f37518b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* renamed from: c  reason: collision with root package name */
    private final e f37519c;

    m(e eVar) throws IOException {
        this.f37519c = eVar;
    }

    static /* synthetic */ Set a(m mVar, Set set, s sVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        mVar.a(sVar, set, new i(hashSet, sVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1 A[SYNTHETIC, Splitter:B:31:0x00e1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.google.android.play.core.splitcompat.s r12, com.google.android.play.core.splitcompat.j r13) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00dd }
            java.io.File r1 = r12.a()     // Catch:{ IOException -> 0x00dd }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00dd }
            java.lang.String r12 = r12.b()     // Catch:{ IOException -> 0x00db }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00db }
            r1.<init>()     // Catch:{ IOException -> 0x00db }
            java.util.Enumeration r2 = r0.entries()     // Catch:{ IOException -> 0x00db }
        L_0x0016:
            boolean r3 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00db }
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.nextElement()     // Catch:{ IOException -> 0x00db }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00db }
            java.lang.String r7 = r3.getName()     // Catch:{ IOException -> 0x00db }
            java.util.regex.Pattern r8 = f37518b     // Catch:{ IOException -> 0x00db }
            java.util.regex.Matcher r7 = r8.matcher(r7)     // Catch:{ IOException -> 0x00db }
            boolean r8 = r7.matches()     // Catch:{ IOException -> 0x00db }
            if (r8 == 0) goto L_0x0016
            java.lang.String r8 = r7.group(r6)     // Catch:{ IOException -> 0x00db }
            java.lang.String r7 = r7.group(r4)     // Catch:{ IOException -> 0x00db }
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x00db }
            r9[r5] = r12     // Catch:{ IOException -> 0x00db }
            r9[r6] = r7     // Catch:{ IOException -> 0x00db }
            r9[r4] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r4 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.String.format(r4, r9)     // Catch:{ IOException -> 0x00db }
            java.lang.Object r4 = r1.get(r8)     // Catch:{ IOException -> 0x00db }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ IOException -> 0x00db }
            if (r4 != 0) goto L_0x005b
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ IOException -> 0x00db }
            r4.<init>()     // Catch:{ IOException -> 0x00db }
            r1.put(r8, r4)     // Catch:{ IOException -> 0x00db }
        L_0x005b:
            com.google.android.play.core.splitcompat.l r5 = new com.google.android.play.core.splitcompat.l     // Catch:{ IOException -> 0x00db }
            r5.<init>(r3, r7)     // Catch:{ IOException -> 0x00db }
            r4.add(r5)     // Catch:{ IOException -> 0x00db }
            goto L_0x0016
        L_0x0064:
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x00db }
            r12.<init>()     // Catch:{ IOException -> 0x00db }
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00db }
            int r3 = r2.length     // Catch:{ IOException -> 0x00db }
            r7 = 0
        L_0x006d:
            if (r7 < r3) goto L_0x007f
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x00db }
            java.util.Collection r12 = r12.values()     // Catch:{ IOException -> 0x00db }
            r1.<init>(r12)     // Catch:{ IOException -> 0x00db }
            r13.a(r0, r1)     // Catch:{ IOException -> 0x00db }
            r0.close()     // Catch:{ IOException -> 0x00db }
            return
        L_0x007f:
            r8 = r2[r7]     // Catch:{ IOException -> 0x00db }
            boolean r9 = r1.containsKey(r8)     // Catch:{ IOException -> 0x00db }
            if (r9 == 0) goto L_0x00cf
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00db }
            r9[r5] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.String.format(r10, r9)     // Catch:{ IOException -> 0x00db }
            java.lang.Object r9 = r1.get(r8)     // Catch:{ IOException -> 0x00db }
            java.util.Set r9 = (java.util.Set) r9     // Catch:{ IOException -> 0x00db }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x00db }
        L_0x009a:
            boolean r10 = r9.hasNext()     // Catch:{ IOException -> 0x00db }
            if (r10 == 0) goto L_0x00d8
            java.lang.Object r10 = r9.next()     // Catch:{ IOException -> 0x00db }
            com.google.android.play.core.splitcompat.l r10 = (com.google.android.play.core.splitcompat.l) r10     // Catch:{ IOException -> 0x00db }
            java.lang.String r11 = r10.f37515a     // Catch:{ IOException -> 0x00db }
            boolean r11 = r12.containsKey(r11)     // Catch:{ IOException -> 0x00db }
            if (r11 != 0) goto L_0x00c1
            java.lang.String r11 = r10.f37515a     // Catch:{ IOException -> 0x00db }
            r12.put(r11, r10)     // Catch:{ IOException -> 0x00db }
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = r10.f37515a     // Catch:{ IOException -> 0x00db }
            r11[r5] = r10     // Catch:{ IOException -> 0x00db }
            r11[r6] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x00db }
            goto L_0x009a
        L_0x00c1:
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = r10.f37515a     // Catch:{ IOException -> 0x00db }
            r11[r5] = r10     // Catch:{ IOException -> 0x00db }
            r11[r6] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r10 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x00db }
            goto L_0x009a
        L_0x00cf:
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00db }
            r9[r5] = r8     // Catch:{ IOException -> 0x00db }
            java.lang.String r8 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.String.format(r8, r9)     // Catch:{ IOException -> 0x00db }
        L_0x00d8:
            int r7 = r7 + 1
            goto L_0x006d
        L_0x00db:
            r12 = move-exception
            goto L_0x00df
        L_0x00dd:
            r12 = move-exception
            r0 = 0
        L_0x00df:
            if (r0 == 0) goto L_0x00e9
            r0.close()     // Catch:{ IOException -> 0x00e5 }
            goto L_0x00e9
        L_0x00e5:
            r13 = move-exception
            com.google.android.play.core.b.bg.a(r12, r13)
        L_0x00e9:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.m.a(com.google.android.play.core.splitcompat.s, com.google.android.play.core.splitcompat.j):void");
    }

    /* access modifiers changed from: package-private */
    public final Set<File> a() throws IOException {
        Set<s> f2 = this.f37519c.f();
        e eVar = this.f37519c;
        ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = eVar.e().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        for (String str : arrayList) {
            Iterator<s> it2 = f2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().b().equals(str)) {
                        break;
                    }
                } else {
                    String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{str});
                    this.f37519c.c(str);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (s next : f2) {
            HashSet hashSet2 = new HashSet();
            a(next, new h(this, hashSet2, next));
            for (File next2 : this.f37519c.d(next.b())) {
                if (!hashSet2.contains(next2)) {
                    String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{next2.getAbsolutePath(), next.b(), next.a().getAbsolutePath()});
                    this.f37519c.a(next2);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public final void a(s sVar, Set<l> set, k kVar) throws IOException {
        for (l next : set) {
            e eVar = this.f37519c;
            String b2 = sVar.b();
            File a2 = e.a(eVar.b(b2), next.f37515a);
            boolean z = false;
            if (a2.exists() && a2.length() == next.f37516b.getSize()) {
                z = true;
            }
            kVar.a(next, a2, z);
        }
    }
}
