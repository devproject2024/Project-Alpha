package net.one97.paytm.payments.visascp.nonce;

import java.security.SecureRandom;

public class NonceGenerator {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f612 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f613;

    public static byte[] generateNonce() {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        int i2 = f613;
        int i3 = i2 & 21;
        int i4 = -(-((i2 ^ 21) | i3));
        int i5 = (i3 & i4) + (i4 | i3);
        f612 = i5 % 128;
        int i6 = i5 % 2;
        return bArr;
    }
}
