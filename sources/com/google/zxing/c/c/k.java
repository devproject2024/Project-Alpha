package com.google.zxing.c.c;

import com.google.zxing.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import easypay.manager.Constants;
import net.one97.paytm.upi.util.UpiConstants;

public class k {

    /* renamed from: a  reason: collision with root package name */
    static final k[] f39987a;

    /* renamed from: g  reason: collision with root package name */
    private static k[] f39988g;

    /* renamed from: b  reason: collision with root package name */
    final int f39989b;

    /* renamed from: c  reason: collision with root package name */
    final int f39990c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39991d;

    /* renamed from: e  reason: collision with root package name */
    public final int f39992e;

    /* renamed from: f  reason: collision with root package name */
    final int f39993f;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f39994h;

    /* renamed from: i  reason: collision with root package name */
    private final int f39995i;
    private final int j;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, Constants.EASY_PAY_INVISIBLE_ASSIST, 20, 20, 16, 144, 56), new k(false, 696, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f39987a = kVarArr;
        f39988g = kVarArr;
    }

    private k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f39994h = z;
        this.f39989b = i2;
        this.f39990c = i3;
        this.f39991d = i4;
        this.f39992e = i5;
        this.f39995i = i6;
        this.j = i7;
        this.f39993f = i8;
    }

    public static k a(int i2, l lVar, f fVar, f fVar2) {
        for (k kVar : f39988g) {
            if ((lVar != l.FORCE_SQUARE || !kVar.f39994h) && ((lVar != l.FORCE_RECTANGLE || kVar.f39994h) && ((fVar == null || (kVar.d() >= fVar.f40410a && kVar.e() >= fVar.f40411b)) && ((fVar2 == null || (kVar.d() <= fVar2.f40410a && kVar.e() <= fVar2.f40411b)) && i2 <= kVar.f39989b)))) {
                return kVar;
            }
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
    }

    private int f() {
        int i2 = this.f39995i;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (!(i2 == 2 || i2 == 4)) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    private int g() {
        int i2 = this.f39995i;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int b() {
        return f() * this.f39991d;
    }

    public final int c() {
        return g() * this.f39992e;
    }

    public final int d() {
        return b() + (f() << 1);
    }

    public final int e() {
        return c() + (g() << 1);
    }

    public int a() {
        return this.f39989b / this.j;
    }

    public int a(int i2) {
        return this.j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39994h ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f39991d);
        sb.append('x');
        sb.append(this.f39992e);
        sb.append(", symbol size ");
        sb.append(d());
        sb.append('x');
        sb.append(e());
        sb.append(", symbol data size ");
        sb.append(b());
        sb.append('x');
        sb.append(c());
        sb.append(", codewords ");
        sb.append(this.f39989b);
        sb.append('+');
        sb.append(this.f39990c);
        return sb.toString();
    }
}
