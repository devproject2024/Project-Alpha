package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class e<DataT> implements n<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6992a;

    /* renamed from: b  reason: collision with root package name */
    private final n<File, DataT> f6993b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f6994c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f6995d;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), new d(this.f6992a, this.f6993b, this.f6994c, uri, i2, i3, iVar, this.f6995d));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.a.a.b.a((Uri) obj);
    }

    e(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f6992a = context.getApplicationContext();
        this.f6993b = nVar;
        this.f6994c = nVar2;
        this.f6995d = cls;
    }

    static final class d<DataT> implements com.bumptech.glide.load.a.d<DataT> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f6998a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f6999b;

        /* renamed from: c  reason: collision with root package name */
        private final n<File, DataT> f7000c;

        /* renamed from: d  reason: collision with root package name */
        private final n<Uri, DataT> f7001d;

        /* renamed from: e  reason: collision with root package name */
        private final Uri f7002e;

        /* renamed from: f  reason: collision with root package name */
        private final int f7003f;

        /* renamed from: g  reason: collision with root package name */
        private final int f7004g;

        /* renamed from: h  reason: collision with root package name */
        private final i f7005h;

        /* renamed from: i  reason: collision with root package name */
        private final Class<DataT> f7006i;
        private volatile boolean j;
        private volatile com.bumptech.glide.load.a.d<DataT> k;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, i iVar, Class<DataT> cls) {
            this.f6999b = context.getApplicationContext();
            this.f7000c = nVar;
            this.f7001d = nVar2;
            this.f7002e = uri;
            this.f7003f = i2;
            this.f7004g = i3;
            this.f7005h = iVar;
            this.f7006i = cls;
        }

        public final void b() {
            com.bumptech.glide.load.a.d<DataT> dVar = this.k;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final void c() {
            this.j = true;
            com.bumptech.glide.load.a.d<DataT> dVar = this.k;
            if (dVar != null) {
                dVar.c();
            }
        }

        public final Class<DataT> a() {
            return this.f7006i;
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f6999b.getContentResolver().query(uri, f6998a, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: ".concat(String.valueOf(uri)));
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
                throw new FileNotFoundException("File path was empty in media store for: ".concat(String.valueOf(uri)));
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        public final void a(f fVar, d.a<? super DataT> aVar) {
            n.a<DataT> aVar2;
            com.bumptech.glide.load.a.d<Data> dVar;
            try {
                if (Environment.isExternalStorageLegacy()) {
                    aVar2 = this.f7000c.a(a(this.f7002e), this.f7003f, this.f7004g, this.f7005h);
                } else {
                    aVar2 = this.f7001d.a(this.f6999b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? MediaStore.setRequireOriginal(this.f7002e) : this.f7002e, this.f7003f, this.f7004g, this.f7005h);
                }
                if (aVar2 != null) {
                    dVar = aVar2.f7055c;
                } else {
                    dVar = null;
                }
                if (dVar == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f7002e));
                    return;
                }
                this.k = dVar;
                if (this.j) {
                    c();
                } else {
                    dVar.a(fVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }
    }

    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6996a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f6997b;

        a(Context context, Class<DataT> cls) {
            this.f6996a = context;
            this.f6997b = cls;
        }

        public final n<Uri, DataT> a(r rVar) {
            return new e(this.f6996a, rVar.a(File.class, this.f6997b), rVar.a(Uri.class, this.f6997b), this.f6997b);
        }
    }
}
