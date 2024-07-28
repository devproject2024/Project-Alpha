package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.InputStream;

public final class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f7078a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f7079b;

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* bridge */ /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri a2 = a((Integer) obj);
        if (a2 == null) {
            return null;
        }
        return this.f7078a.a(a2, i2, i3, iVar);
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f7079b = resources;
        this.f7078a = nVar;
    }

    private Uri a(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f7079b.getResourcePackageName(num.intValue()) + '/' + this.f7079b.getResourceTypeName(num.intValue()) + '/' + this.f7079b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            new StringBuilder("Received invalid resource id: ").append(num);
            return null;
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f7082a;

        public c(Resources resources) {
            this.f7082a = resources;
        }

        public final n<Integer, InputStream> a(r rVar) {
            return new s(this.f7082a, rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f7081a;

        public b(Resources resources) {
            this.f7081a = resources;
        }

        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f7081a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f7080a;

        public a(Resources resources) {
            this.f7080a = resources;
        }

        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f7080a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f7083a;

        public d(Resources resources) {
            this.f7083a = resources;
        }

        public final n<Integer, Uri> a(r rVar) {
            return new s(this.f7083a, v.a());
        }
    }
}
