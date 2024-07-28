package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class g implements Parcelable.Creator<ExperimentTokens> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ExperimentTokens[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    bArr = a.q(parcel, readInt);
                    break;
                case 4:
                    bArr2 = a.r(parcel, readInt);
                    break;
                case 5:
                    bArr3 = a.r(parcel, readInt);
                    break;
                case 6:
                    bArr4 = a.r(parcel, readInt);
                    break;
                case 7:
                    bArr5 = a.r(parcel, readInt);
                    break;
                case 8:
                    iArr = a.s(parcel, readInt);
                    break;
                case 9:
                    bArr6 = a.r(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new ExperimentTokens(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }
}
