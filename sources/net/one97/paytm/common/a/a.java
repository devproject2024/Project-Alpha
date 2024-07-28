package net.one97.paytm.common.a;

public final class a {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.CJRError a(java.lang.String r7) {
        /*
            android.content.Context r0 = net.one97.paytm.app.CJRJarvisApplication.getAppContext()
            com.paytm.network.model.CJRError r1 = new com.paytm.network.model.CJRError
            r1.<init>()
            int r2 = r7.hashCode()
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1311914055: goto L_0x0035;
                case -617237321: goto L_0x002b;
                case 1700738474: goto L_0x0020;
                case 2038628819: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x003f
        L_0x0015:
            java.lang.String r2 = "unknown_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x003f
            r2 = 3
            goto L_0x0040
        L_0x0020:
            java.lang.String r2 = "timeout_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r2 = "network_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x003f
            r2 = 0
            goto L_0x0040
        L_0x0035:
            java.lang.String r2 = "parsing_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x003f
            r2 = 2
            goto L_0x0040
        L_0x003f:
            r2 = -1
        L_0x0040:
            if (r2 == 0) goto L_0x00bf
            if (r2 == r6) goto L_0x00bf
            if (r2 == r5) goto L_0x00b0
            r5 = 2131954848(0x7f130ca0, float:1.9546207E38)
            r6 = 2131954877(0x7f130cbd, float:1.9546266E38)
            if (r2 == r4) goto L_0x00a7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            int r3 = r7.intValue()     // Catch:{ NumberFormatException -> 0x0056 }
        L_0x0056:
            java.lang.String r7 = r0.getString(r6)
            r2 = 400(0x190, float:5.6E-43)
            if (r3 == r2) goto L_0x009f
            r2 = 404(0x194, float:5.66E-43)
            if (r3 == r2) goto L_0x0097
            r2 = 408(0x198, float:5.72E-43)
            if (r3 == r2) goto L_0x008f
            r2 = 429(0x1ad, float:6.01E-43)
            if (r3 == r2) goto L_0x0087
            r2 = 500(0x1f4, float:7.0E-43)
            if (r3 == r2) goto L_0x007f
            r2 = 503(0x1f7, float:7.05E-43)
            if (r3 == r2) goto L_0x0077
            java.lang.String r0 = r0.getString(r5)
            goto L_0x00cd
        L_0x0077:
            r2 = 2131954845(0x7f130c9d, float:1.95462E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x007f:
            r2 = 2131954844(0x7f130c9c, float:1.9546199E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x0087:
            r2 = 2131954843(0x7f130c9b, float:1.9546197E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x008f:
            r2 = 2131954842(0x7f130c9a, float:1.9546195E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x0097:
            r2 = 2131954841(0x7f130c99, float:1.9546193E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x009f:
            r2 = 2131954840(0x7f130c98, float:1.954619E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x00a7:
            java.lang.String r7 = r0.getString(r6)
            java.lang.String r0 = r0.getString(r5)
            goto L_0x00cd
        L_0x00b0:
            r7 = 2131954757(0x7f130c45, float:1.9546022E38)
            java.lang.String r7 = r0.getString(r7)
            r2 = 2131960436(0x7f132274, float:1.955754E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00cd
        L_0x00bf:
            r7 = 2131959561(0x7f131f09, float:1.9555766E38)
            java.lang.String r7 = r0.getString(r7)
            r2 = 2131959563(0x7f131f0b, float:1.955577E38)
            java.lang.String r0 = r0.getString(r2)
        L_0x00cd:
            r1.setTitle(r7)
            r1.setMessage(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.a.a.a(java.lang.String):com.paytm.network.model.CJRError");
    }
}
