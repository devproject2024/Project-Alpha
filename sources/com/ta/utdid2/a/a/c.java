package com.ta.utdid2.a.a;

import net.one97.paytm.upi.util.UpiConstants;

public final class c {
    public static byte[] a(int i2) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i2 % UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        int i3 = i2 >> 8;
        bArr[2] = (byte) (i3 % UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        int i4 = i3 >> 8;
        bArr[1] = (byte) (i4 % UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        bArr[0] = (byte) ((i4 >> 8) % UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        return bArr;
    }
}
