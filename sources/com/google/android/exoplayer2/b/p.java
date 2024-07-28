package com.google.android.exoplayer2.b;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.q;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f31250a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f31251b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f31252c = {64, 112, 128, 192, Constants.EASY_PAY_INVISIBLE_ASSIST, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, 384, 448, 512, 640, 768, 896, TarConstants.EOF_BLOCK, 1152, 1280, 1536, 1920, EmiUtil.EMI_PLAN_REQUEST_CODE, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static boolean a(int i2) {
        return i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368;
    }

    public static int a(byte[] bArr) {
        int i2;
        byte b2;
        byte b3;
        int i3;
        byte b4;
        byte b5 = bArr[0];
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (bArr[4] & 7) << 4;
                b4 = bArr[7];
            } else if (b5 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i3 = (bArr[5] & 7) << 4;
                b4 = bArr[6];
            }
            b3 = b4 & 60;
            return (((b3 >> 2) | i3) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        b3 = b2 & 252;
        return (((b3 >> 2) | i3) + 1) * 32;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        byte b3;
        int i3;
        byte b4;
        int position = byteBuffer.position();
        byte b5 = byteBuffer.get(position);
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (byteBuffer.get(position + 4) & 7) << 4;
                b4 = byteBuffer.get(position + 7);
            } else if (b5 != 31) {
                i2 = (byteBuffer.get(position + 4) & 1) << 6;
                b2 = byteBuffer.get(position + 5);
            } else {
                i3 = (byteBuffer.get(position + 5) & 7) << 4;
                b4 = byteBuffer.get(position + 6);
            }
            b3 = b4 & 60;
            return (((b3 >> 2) | i3) + 1) * 32;
        }
        i2 = (byteBuffer.get(position + 5) & 1) << 6;
        b2 = byteBuffer.get(position + 4);
        b3 = b2 & 252;
        return (((b3 >> 2) | i3) + 1) * 32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            byte r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L_0x004f
            r2 = -1
            if (r1 == r2) goto L_0x0037
            r2 = 31
            if (r1 == r2) goto L_0x0026
            r1 = 5
            byte r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r3]
        L_0x0020:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L_0x005e
        L_0x0026:
            byte r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            byte r7 = r7[r1]
            goto L_0x0047
        L_0x0037:
            byte r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            byte r7 = r7[r1]
        L_0x0047:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L_0x005e
        L_0x004f:
            byte r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r4]
            goto L_0x0020
        L_0x005e:
            if (r0 == 0) goto L_0x0064
            int r7 = r7 * 16
            int r7 = r7 / 14
        L_0x0064:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.p.b(byte[]):int");
    }

    public static Format a(byte[] bArr, String str, String str2) {
        q qVar;
        byte[] bArr2 = bArr;
        if (bArr2[0] == Byte.MAX_VALUE) {
            qVar = new q(bArr2);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr2, bArr2.length);
            if (copyOf[0] == -2 || copyOf[0] == -1) {
                for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                    byte b2 = copyOf[i2];
                    int i3 = i2 + 1;
                    copyOf[i2] = copyOf[i3];
                    copyOf[i3] = b2;
                }
            }
            qVar = new q(copyOf);
            if (copyOf[0] == 31) {
                q qVar2 = new q(copyOf);
                while (qVar2.a() >= 16) {
                    qVar2.b(2);
                    int c2 = qVar2.c(14) & 16383;
                    int min = Math.min(8 - qVar.f32564c, 14);
                    int i4 = (8 - qVar.f32564c) - min;
                    qVar.f32562a[qVar.f32563b] = (byte) (qVar.f32562a[qVar.f32563b] & ((PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK >> qVar.f32564c) | ((1 << i4) - 1)));
                    int i5 = 14 - min;
                    qVar.f32562a[qVar.f32563b] = (byte) (((c2 >>> i5) << i4) | qVar.f32562a[qVar.f32563b]);
                    int i6 = qVar.f32563b + 1;
                    while (i5 > 8) {
                        qVar.f32562a[i6] = (byte) (c2 >>> (i5 - 8));
                        i5 -= 8;
                        i6++;
                    }
                    int i7 = 8 - i5;
                    byte[] bArr3 = qVar.f32562a;
                    bArr3[i6] = (byte) (bArr3[i6] & ((1 << i7) - 1));
                    int i8 = ((1 << i5) - 1) & c2;
                    byte[] bArr4 = qVar.f32562a;
                    bArr4[i6] = (byte) ((i8 << i7) | bArr4[i6]);
                    qVar.b(14);
                    qVar.g();
                }
            }
            qVar.a(copyOf, copyOf.length);
        }
        qVar.b(60);
        int i9 = f31250a[qVar.c(6)];
        int i10 = f31251b[qVar.c(4)];
        int c3 = qVar.c(5);
        int[] iArr = f31252c;
        int i11 = c3 >= iArr.length ? -1 : (iArr[c3] * 1000) / 2;
        qVar.b(10);
        return Format.a(str, "audio/vnd.dts", i11, -1, i9 + (qVar.c(2) > 0 ? 1 : 0), i10, (List<byte[]>) null, (DrmInitData) null, str2);
    }
}
