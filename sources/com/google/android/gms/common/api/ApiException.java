package com.google.android.gms.common.api;

public class ApiException extends Exception {
    @Deprecated
    protected final Status mStatus;

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.f8360g;
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.f8361h;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(com.google.android.gms.common.api.Status r5) {
        /*
            r4 = this;
            int r0 = r5.f8360g
            java.lang.String r1 = r5.f8361h
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = r5.f8361h
            goto L_0x000b
        L_0x0009:
            java.lang.String r1 = ""
        L_0x000b:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = ": "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r4.<init>(r0)
            r4.mStatus = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }
}
