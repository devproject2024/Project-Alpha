package jp.wasabeef.glide.transformations.a;

import android.graphics.Bitmap;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.Array;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {
    public static Bitmap a(Bitmap bitmap, int i2) {
        int[] iArr;
        int i3 = i2;
        if (i3 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, new int[]{i7, 3});
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = -i3;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i3) {
                int i26 = i6;
                int i27 = height;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i16, 0))];
                int[] iArr9 = iArr8[i16 + i3];
                iArr9[0] = (i28 & 16711680) >> 16;
                iArr9[1] = (i28 & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i28 & PriceRangeSeekBar.INVALID_POINTER_ID;
                int abs = i12 - Math.abs(i16);
                i17 += iArr9[0] * abs;
                i18 += iArr9[1] * abs;
                i19 += iArr9[2] * abs;
                if (i16 > 0) {
                    i23 += iArr9[0];
                    i24 += iArr9[1];
                    i25 += iArr9[2];
                } else {
                    i20 += iArr9[0];
                    i21 += iArr9[1];
                    i22 += iArr9[2];
                }
                i16++;
                height = i27;
                i6 = i26;
            }
            int i29 = i6;
            int i30 = height;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i17];
                iArr4[i14] = iArr7[i18];
                iArr5[i14] = iArr7[i19];
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int i35 = i19 - i22;
                int[] iArr10 = iArr8[((i31 - i3) + i7) % i7];
                int i36 = i20 - iArr10[0];
                int i37 = i21 - iArr10[1];
                int i38 = i22 - iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr6[i32]];
                iArr10[0] = (i39 & 16711680) >> 16;
                iArr10[1] = (i39 & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i39 & PriceRangeSeekBar.INVALID_POINTER_ID;
                int i40 = i23 + iArr10[0];
                int i41 = i24 + iArr10[1];
                int i42 = i25 + iArr10[2];
                i17 = i33 + i40;
                i18 = i34 + i41;
                i19 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr11 = iArr8[i31 % i7];
                i20 = i36 + iArr11[0];
                i21 = i37 + iArr11[1];
                i22 = i38 + iArr11[2];
                i23 = i40 - iArr11[0];
                i24 = i41 - iArr11[1];
                i25 = i42 - iArr11[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            int[] iArr12 = iArr7;
            i15 += width;
            i13++;
            height = i30;
            i6 = i29;
        }
        int i43 = i6;
        int i44 = height;
        int[] iArr13 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i46 * width;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            while (i46 <= i3) {
                int[] iArr14 = iArr6;
                int max = Math.max(0, i47) + i45;
                int[] iArr15 = iArr8[i46 + i3];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i46);
                i48 += iArr3[max] * abs2;
                i49 += iArr4[max] * abs2;
                i50 += iArr5[max] * abs2;
                if (i46 > 0) {
                    i54 += iArr15[0];
                    i55 += iArr15[1];
                    i56 += iArr15[2];
                } else {
                    i51 += iArr15[0];
                    i52 += iArr15[1];
                    i53 += iArr15[2];
                }
                int i57 = i43;
                if (i46 < i57) {
                    i47 += width;
                }
                i46++;
                i43 = i57;
                iArr6 = iArr14;
            }
            int[] iArr16 = iArr6;
            int i58 = i43;
            int i59 = i54;
            int i60 = i55;
            int i61 = i44;
            int i62 = 0;
            int i63 = i3;
            int i64 = i53;
            int i65 = i52;
            int i66 = i51;
            int i67 = i50;
            int i68 = i49;
            int i69 = i48;
            int i70 = i45;
            while (i62 < i61) {
                iArr2[i70] = (iArr2[i70] & -16777216) | (iArr13[i69] << 16) | (iArr13[i68] << 8) | iArr13[i67];
                int i71 = i69 - i66;
                int i72 = i68 - i65;
                int i73 = i67 - i64;
                int[] iArr17 = iArr8[((i63 - i3) + i7) % i7];
                int i74 = i66 - iArr17[0];
                int i75 = i65 - iArr17[1];
                int i76 = i64 - iArr17[2];
                if (i45 == 0) {
                    iArr16[i62] = Math.min(i62 + i12, i58) * width;
                }
                int i77 = iArr16[i62] + i45;
                iArr17[0] = iArr3[i77];
                iArr17[1] = iArr4[i77];
                iArr17[2] = iArr5[i77];
                int i78 = i59 + iArr17[0];
                int i79 = i60 + iArr17[1];
                int i80 = i56 + iArr17[2];
                i69 = i71 + i78;
                i68 = i72 + i79;
                i67 = i73 + i80;
                i63 = (i63 + 1) % i7;
                int[] iArr18 = iArr8[i63];
                i66 = i74 + iArr18[0];
                i65 = i75 + iArr18[1];
                i64 = i76 + iArr18[2];
                i59 = i78 - iArr18[0];
                i60 = i79 - iArr18[1];
                i56 = i80 - iArr18[2];
                i70 += width;
                i62++;
                i3 = i2;
            }
            i45++;
            i3 = i2;
            i43 = i58;
            i44 = i61;
            iArr6 = iArr16;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i44);
        return bitmap;
    }
}
