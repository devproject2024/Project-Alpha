package com.google.android.gms.vision.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzae;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class e extends com.google.android.gms.vision.a<d> {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.gms.internal.vision.e f12539a;

    private e() {
        throw new IllegalStateException("Default constructor called");
    }

    private e(com.google.android.gms.internal.vision.e eVar) {
        this.f12539a = eVar;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f12540a;

        /* renamed from: b  reason: collision with root package name */
        private zzah f12541b = new zzah();

        public a(Context context) {
            this.f12540a = context;
        }

        public final e a() {
            return new e(new com.google.android.gms.internal.vision.e(this.f12540a, this.f12541b), (byte) 0);
        }
    }

    public final SparseArray<d> a(b bVar) {
        byte[] bArr;
        Bitmap decodeByteArray;
        Rect rect;
        int i2;
        b bVar2 = bVar;
        zzae zzae = new zzae(new Rect());
        if (bVar2 != null) {
            zzp a2 = zzp.a(bVar);
            if (bVar2.f12544c != null) {
                decodeByteArray = bVar2.f12544c;
            } else {
                b.C0164b bVar3 = bVar2.f12542a;
                ByteBuffer a3 = bVar.a();
                int i3 = bVar3.f12551f;
                int i4 = a2.f11302a;
                int i5 = a2.f11303b;
                if (!a3.hasArray() || a3.arrayOffset() != 0) {
                    byte[] bArr2 = new byte[a3.capacity()];
                    a3.get(bArr2);
                    bArr = bArr2;
                } else {
                    bArr = a3.array();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, i3, i4, i5, (int[]) null).compressToJpeg(new Rect(0, 0, i4, i5), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            Bitmap bitmap = decodeByteArray;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (a2.f11306e != 0) {
                Matrix matrix = new Matrix();
                int i6 = a2.f11306e;
                if (i6 == 0) {
                    i2 = 0;
                } else if (i6 == 1) {
                    i2 = 90;
                } else if (i6 == 2) {
                    i2 = AppConstants.READ_TIME_OUT;
                } else if (i6 == 3) {
                    i2 = 270;
                } else {
                    throw new IllegalArgumentException("Unsupported rotation degree.");
                }
                matrix.postRotate((float) i2);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            }
            if (a2.f11306e == 1 || a2.f11306e == 3) {
                a2.f11302a = height;
                a2.f11303b = width;
            }
            if (!zzae.f11292a.isEmpty()) {
                Rect rect2 = zzae.f11292a;
                int i7 = bVar2.f12542a.f12546a;
                int i8 = bVar2.f12542a.f12547b;
                int i9 = a2.f11306e;
                if (i9 == 1) {
                    rect = new Rect(i8 - rect2.bottom, rect2.left, i8 - rect2.top, rect2.right);
                } else if (i9 == 2) {
                    rect = new Rect(i7 - rect2.right, i8 - rect2.bottom, i7 - rect2.left, i8 - rect2.top);
                } else if (i9 != 3) {
                    rect = rect2;
                } else {
                    rect = new Rect(rect2.top, i7 - rect2.right, rect2.bottom, i7 - rect2.left);
                }
                zzae.f11292a.set(rect);
            }
            a2.f11306e = 0;
            zzac[] a4 = this.f12539a.a(bitmap, a2, zzae);
            SparseArray sparseArray = new SparseArray();
            for (zzac zzac : a4) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzac.f11288f);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(zzac.f11288f, sparseArray2);
                }
                sparseArray2.append(zzac.f11289g, zzac);
            }
            SparseArray<d> sparseArray3 = new SparseArray<>(sparseArray.size());
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                sparseArray3.append(sparseArray.keyAt(i10), new d((SparseArray) sparseArray.valueAt(i10)));
            }
            return sparseArray3;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean b() {
        return this.f12539a.b();
    }

    public final void a() {
        super.a();
        this.f12539a.c();
    }

    /* synthetic */ e(com.google.android.gms.internal.vision.e eVar, byte b2) {
        this(eVar);
    }
}
