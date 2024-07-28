package com.alipay.mobile.nebulacore.appcenter.parse;

public class H5PackageParserRn {
    public static final String TAG = "H5PackageParserRn";

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0242, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int parseRNPackage(java.lang.String r17) {
        /*
            r1 = r17
            java.lang.Class<com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParserRn> r2 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParserRn.class
            monitor-enter(r2)
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.provider.H5ProviderManager r0 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()     // Catch:{ all -> 0x0244 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r5 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0244 }
            java.lang.Object r0 = r0.getProvider(r5)     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = (com.alipay.mobile.nebula.provider.H5AppProvider) r0     // Catch:{ all -> 0x0244 }
            r5 = 1
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "H5PackageParserRn"
            java.lang.String r1 = "nebulaAppProvider==null"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0244 }
            monitor-exit(r2)
            return r5
        L_0x0025:
            java.lang.String r6 = r0.getVersion(r1)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r0.getInstallPath(r1, r6)     // Catch:{ all -> 0x0244 }
            java.lang.String r6 = "file://"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r6.concat(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r6 = "/"
            boolean r6 = r0.endsWith(r6)     // Catch:{ all -> 0x0244 }
            if (r6 != 0) goto L_0x0050
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            r6.<init>()     // Catch:{ all -> 0x0244 }
            r6.append(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = "/"
            r6.append(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0244 }
        L_0x0050:
            java.lang.String r6 = "H5PackageParserRn"
            java.lang.String r7 = "offlineHost "
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)     // Catch:{ all -> 0x0244 }
            android.net.Uri r6 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r0)     // Catch:{ all -> 0x0244 }
            if (r6 == 0) goto L_0x0241
            java.lang.String r7 = r6.getPath()     // Catch:{ all -> 0x0244 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0244 }
            if (r7 == 0) goto L_0x0071
            goto L_0x0241
        L_0x0071:
            java.lang.String r6 = r6.getPath()     // Catch:{ all -> 0x0244 }
            boolean r7 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r6)     // Catch:{ all -> 0x0244 }
            r8 = 2
            if (r7 != 0) goto L_0x0096
            java.lang.String r0 = "H5PackageParserRn"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            java.lang.String r3 = "offlinePath "
            r1.<init>(r3)     // Catch:{ all -> 0x0244 }
            r1.append(r6)     // Catch:{ all -> 0x0244 }
            java.lang.String r3 = " not exists!"
            r1.append(r3)     // Catch:{ all -> 0x0244 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0244 }
            monitor-exit(r2)
            return r8
        L_0x0096:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            r7.<init>()     // Catch:{ all -> 0x0244 }
            r7.append(r6)     // Catch:{ all -> 0x0244 }
            java.lang.String r9 = "/CERT.json"
            r7.append(r9)     // Catch:{ all -> 0x0244 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0244 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            r9.<init>()     // Catch:{ all -> 0x0244 }
            r9.append(r6)     // Catch:{ all -> 0x0244 }
            java.lang.String r10 = "/SIGN.json"
            r9.append(r10)     // Catch:{ all -> 0x0244 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0244 }
            boolean r10 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r7)     // Catch:{ all -> 0x0244 }
            r11 = 0
            if (r10 != 0) goto L_0x00d2
            boolean r10 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r9)     // Catch:{ all -> 0x0244 }
            if (r10 != 0) goto L_0x00d2
            java.lang.String r3 = "H5PackageParserRn"
            java.lang.String r4 = "cert not exists!"
            com.alipay.mobile.nebula.util.H5Log.w(r3, r4)     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.notifyFail(r1, r0, r11)     // Catch:{ all -> 0x0244 }
            r0 = 4
            monitor-exit(r2)
            return r0
        L_0x00d2:
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0244 }
            r10.<init>(r6)     // Catch:{ all -> 0x0244 }
            java.io.File[] r10 = r10.listFiles()     // Catch:{ all -> 0x0244 }
            if (r10 == 0) goto L_0x0238
            int r12 = r10.length     // Catch:{ all -> 0x0244 }
            if (r12 != 0) goto L_0x00e2
            goto L_0x0238
        L_0x00e2:
            boolean r8 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r9)     // Catch:{ all -> 0x0244 }
            if (r8 == 0) goto L_0x00f0
            java.lang.String r13 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.TAR_PUBLIC_KEY     // Catch:{ all -> 0x0244 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0244 }
            if (r13 != 0) goto L_0x010e
        L_0x00f0:
            java.lang.String r13 = "H5PackageParserRn"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            java.lang.String r15 = "signPath is exist : "
            r14.<init>(r15)     // Catch:{ all -> 0x0244 }
            r14.append(r8)     // Catch:{ all -> 0x0244 }
            java.lang.String r8 = ", H5PackageParser.TAR_PUBLIC_KEY : "
            r14.append(r8)     // Catch:{ all -> 0x0244 }
            java.lang.String r8 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.TAR_PUBLIC_KEY     // Catch:{ all -> 0x0244 }
            r14.append(r8)     // Catch:{ all -> 0x0244 }
            java.lang.String r8 = r14.toString()     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.util.H5Log.d(r13, r8)     // Catch:{ all -> 0x0244 }
            r8 = 0
        L_0x010e:
            java.lang.String r13 = "H5PackageParserRn"
            java.lang.String r14 = "useNewSignKey : "
            java.lang.String r15 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0244 }
            java.lang.String r14 = r14.concat(r15)     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.util.H5Log.d(r13, r14)     // Catch:{ all -> 0x0244 }
            if (r8 == 0) goto L_0x0129
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.read(r9)     // Catch:{ all -> 0x0244 }
            com.alibaba.a.e r7 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r7)     // Catch:{ all -> 0x0244 }
            goto L_0x0131
        L_0x0129:
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.read(r7)     // Catch:{ all -> 0x0244 }
            com.alibaba.a.e r7 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r7)     // Catch:{ all -> 0x0244 }
        L_0x0131:
            if (r7 == 0) goto L_0x022e
            boolean r9 = r7.isEmpty()     // Catch:{ all -> 0x0244 }
            if (r9 == 0) goto L_0x013b
            goto L_0x022e
        L_0x013b:
            int r9 = r10.length     // Catch:{ Exception -> 0x0205 }
            r13 = 0
        L_0x013d:
            if (r13 >= r9) goto L_0x020b
            r14 = r10[r13]     // Catch:{ Exception -> 0x0205 }
            java.lang.String r14 = r14.getName()     // Catch:{ Exception -> 0x0205 }
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0205 }
            if (r15 != 0) goto L_0x01fa
            java.lang.String r15 = "CERT.json"
            boolean r15 = android.text.TextUtils.equals(r14, r15)     // Catch:{ Exception -> 0x0205 }
            if (r15 != 0) goto L_0x01fa
            java.lang.String r15 = "SIGN.json"
            boolean r15 = android.text.TextUtils.equals(r14, r15)     // Catch:{ Exception -> 0x0205 }
            if (r15 != 0) goto L_0x01fa
            java.lang.String r15 = "ios"
            boolean r15 = r14.contains(r15)     // Catch:{ Exception -> 0x0205 }
            if (r15 != 0) goto L_0x01fa
            java.lang.Object r15 = r7.get(r14)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0205 }
            if (r8 == 0) goto L_0x018a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0205 }
            r11.<init>()     // Catch:{ Exception -> 0x0205 }
            r11.append(r6)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = "/"
            r11.append(r12)     // Catch:{ Exception -> 0x0205 }
            r11.append(r14)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.getPublicKey(r5)     // Catch:{ Exception -> 0x0205 }
            boolean r11 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r11, r12, r15)     // Catch:{ Exception -> 0x0205 }
            goto L_0x01ca
        L_0x018a:
            java.lang.String r11 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.TAR_PUBLIC_KEY     // Catch:{ Exception -> 0x0205 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0205 }
            if (r11 != 0) goto L_0x01ad
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0205 }
            r11.<init>()     // Catch:{ Exception -> 0x0205 }
            r11.append(r6)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = "/"
            r11.append(r12)     // Catch:{ Exception -> 0x0205 }
            r11.append(r14)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.TAR_PUBLIC_KEY     // Catch:{ Exception -> 0x0205 }
            boolean r11 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r11, r12, r15)     // Catch:{ Exception -> 0x0205 }
            goto L_0x01ca
        L_0x01ad:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0205 }
            r11.<init>()     // Catch:{ Exception -> 0x0205 }
            r11.append(r6)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = "/"
            r11.append(r12)     // Catch:{ Exception -> 0x0205 }
            r11.append(r14)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0205 }
            r12 = 0
            java.lang.String r5 = com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.getPublicKey(r12)     // Catch:{ Exception -> 0x0205 }
            boolean r11 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r11, r5, r15)     // Catch:{ Exception -> 0x0205 }
        L_0x01ca:
            java.lang.String r5 = "H5PackageParserRn"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0205 }
            r16 = r6
            java.lang.String r6 = "signKey "
            r12.<init>(r6)     // Catch:{ Exception -> 0x0205 }
            r12.append(r14)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r6 = " signValue "
            r12.append(r6)     // Catch:{ Exception -> 0x0205 }
            r12.append(r15)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r6 = " result:"
            r12.append(r6)     // Catch:{ Exception -> 0x0205 }
            r12.append(r11)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r6 = r12.toString()     // Catch:{ Exception -> 0x0205 }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r6)     // Catch:{ Exception -> 0x0205 }
            if (r11 != 0) goto L_0x01f8
            r5 = 0
            com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.notifyFail(r1, r0, r5)     // Catch:{ Exception -> 0x0205 }
            r0 = 6
            monitor-exit(r2)
            return r0
        L_0x01f8:
            r5 = 0
            goto L_0x01fd
        L_0x01fa:
            r16 = r6
            r5 = r11
        L_0x01fd:
            int r13 = r13 + 1
            r11 = r5
            r6 = r16
            r5 = 1
            goto L_0x013d
        L_0x0205:
            r0 = move-exception
            java.lang.String r5 = "H5PackageParserRn"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0244 }
        L_0x020b:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0244 }
            long r5 = r5 - r3
            java.lang.String r0 = "H5PackageParserRn"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            java.lang.String r4 = "parse package elapse "
            r3.<init>(r4)     // Catch:{ all -> 0x0244 }
            r3.append(r5)     // Catch:{ all -> 0x0244 }
            java.lang.String r4 = " appId:"
            r3.append(r4)     // Catch:{ all -> 0x0244 }
            r3.append(r1)     // Catch:{ all -> 0x0244 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0244 }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ all -> 0x0244 }
            monitor-exit(r2)
            r1 = 0
            return r1
        L_0x022e:
            java.lang.String r0 = "H5PackageParserRn"
            java.lang.String r1 = "joCert is empty"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0244 }
            r0 = 5
            monitor-exit(r2)
            return r0
        L_0x0238:
            java.lang.String r0 = "H5PackageParserRn"
            java.lang.String r1 = "childrenFiles length == 0"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0244 }
            monitor-exit(r2)
            return r8
        L_0x0241:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0244:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParserRn.parseRNPackage(java.lang.String):int");
    }
}
