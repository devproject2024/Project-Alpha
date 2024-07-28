package com.google.android.play.core.assetpacks;

import easypay.manager.Constants;

final class ak extends cl {

    /* renamed from: a  reason: collision with root package name */
    private final int f36974a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36975b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36976c;

    /* renamed from: d  reason: collision with root package name */
    private final long f36977d;

    /* renamed from: e  reason: collision with root package name */
    private final int f36978e;

    ak(int i2, String str, long j, long j2, int i3) {
        this.f36974a = i2;
        this.f36975b = str;
        this.f36976c = j;
        this.f36977d = j2;
        this.f36978e = i3;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f36974a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f36975b;
    }

    /* access modifiers changed from: package-private */
    public final long c() {
        return this.f36976c;
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        return this.f36977d;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.f36978e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r1 = r7.f36975b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 == r7) goto L_0x0046
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.cl
            r2 = 0
            if (r1 == 0) goto L_0x0045
            com.google.android.play.core.assetpacks.cl r8 = (com.google.android.play.core.assetpacks.cl) r8
            int r1 = r7.f36974a
            int r3 = r8.a()
            if (r1 != r3) goto L_0x0045
            java.lang.String r1 = r7.f36975b
            if (r1 == 0) goto L_0x0021
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0045
            goto L_0x0028
        L_0x0021:
            java.lang.String r1 = r8.b()
            if (r1 == 0) goto L_0x0028
            goto L_0x0045
        L_0x0028:
            long r3 = r7.f36976c
            long r5 = r8.c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0045
            long r3 = r7.f36977d
            long r5 = r8.d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0045
            int r1 = r7.f36978e
            int r8 = r8.e()
            if (r1 != r8) goto L_0x0045
            return r0
        L_0x0045:
            return r2
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.ak.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = (this.f36974a ^ 1000003) * 1000003;
        String str = this.f36975b;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.f36976c;
        long j2 = this.f36977d;
        return ((((((i2 ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f36978e;
    }

    public final String toString() {
        int i2 = this.f36974a;
        String str = this.f36975b;
        long j = this.f36976c;
        long j2 = this.f36977d;
        int i3 = this.f36978e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + Constants.ACTION_SAVE_CUST_ID);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i2);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
