package com.google.zxing.b.b;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.android.chat.utils.KeyList;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f39893a = new a(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f39894b = new a(1033, TarConstants.EOF_BLOCK, 1);

    /* renamed from: c  reason: collision with root package name */
    public static final a f39895c = new a(67, 64, 1);

    /* renamed from: d  reason: collision with root package name */
    public static final a f39896d = new a(19, 16, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final a f39897e = new a(285, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final a f39898f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f39899g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f39900h = f39895c;

    /* renamed from: i  reason: collision with root package name */
    final int[] f39901i;
    final b j;
    final b k;
    final int l;
    final int m;
    private final int[] n;
    private final int o;

    static int b(int i2, int i3) {
        return i2 ^ i3;
    }

    static {
        a aVar = new a(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, 1);
        f39898f = aVar;
        f39899g = aVar;
    }

    private a(int i2, int i3, int i4) {
        this.o = i2;
        this.l = i3;
        this.m = i4;
        this.f39901i = new int[i3];
        this.n = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f39901i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.n[this.f39901i[i7]] = i7;
        }
        this.j = new b(this, new int[]{0});
        this.k = new b(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public final b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.j;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        if (i2 != 0) {
            return this.n[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        if (i2 != 0) {
            return this.f39901i[(this.l - this.n[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public final int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f39901i;
        int[] iArr2 = this.n;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.l - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.o) + ',' + this.l + ')';
    }
}
