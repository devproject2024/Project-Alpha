package com.bumptech.glide.load.a;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.a.e;
import java.io.IOException;

public final class m implements e<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    public final b f6715a;

    public final void b() {
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f6715a = new b(parcelFileDescriptor);
    }

    public static final class a implements e.a<ParcelFileDescriptor> {
        public final /* synthetic */ e a(Object obj) {
            return new m((ParcelFileDescriptor) obj);
        }

        public final Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f6716a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f6716a = parcelFileDescriptor;
        }

        public final ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.f6716a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f6716a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object a() throws IOException {
        return this.f6715a.a();
    }
}
