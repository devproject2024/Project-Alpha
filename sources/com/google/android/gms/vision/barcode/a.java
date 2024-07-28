package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.er;
import com.google.android.gms.internal.vision.zzf;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.b;

public final class a extends com.google.android.gms.vision.a<Barcode> {

    /* renamed from: a  reason: collision with root package name */
    public final er f12616a;

    private a() {
        throw new IllegalStateException("Default constructor called");
    }

    private a(er erVar) {
        this.f12616a = erVar;
    }

    /* renamed from: com.google.android.gms.vision.barcode.a$a  reason: collision with other inner class name */
    public static class C0165a {

        /* renamed from: a  reason: collision with root package name */
        private Context f12617a;

        /* renamed from: b  reason: collision with root package name */
        private zzf f12618b = new zzf();

        public C0165a(Context context) {
            this.f12617a = context;
        }

        public final C0165a a(int i2) {
            this.f12618b.f11300a = i2;
            return this;
        }

        public final a a() {
            return new a(new er(this.f12617a, this.f12618b), (byte) 0);
        }
    }

    public final void a() {
        super.a();
        this.f12616a.c();
    }

    public final SparseArray<Barcode> a(b bVar) {
        Barcode[] barcodeArr;
        if (bVar != null) {
            zzp a2 = zzp.a(bVar);
            if (bVar.f12544c != null) {
                barcodeArr = this.f12616a.a(bVar.f12544c, a2);
                if (barcodeArr == null) {
                    throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                }
            } else {
                barcodeArr = this.f12616a.a(bVar.a(), a2);
            }
            SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArr.length);
            for (Barcode barcode : barcodeArr) {
                sparseArray.append(barcode.f12553b.hashCode(), barcode);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean b() {
        return this.f12616a.b();
    }

    /* synthetic */ a(er erVar, byte b2) {
        this(erVar);
    }
}
