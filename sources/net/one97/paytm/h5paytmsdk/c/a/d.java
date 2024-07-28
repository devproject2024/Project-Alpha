package net.one97.paytm.h5paytmsdk.c.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.a.c;
import net.one97.paytm.phoenix.provider.download.FileDownloadErrorCodesKt;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17080a = new a((byte) 0);

    public interface b {
        void a(String str, a aVar);
    }

    public interface c {
        void a(String str, String str2, String str3, a aVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: net.one97.paytm.h5paytmsdk.c.a.d$d  reason: collision with other inner class name */
    public static final class C0258d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f17082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17083c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17084d;

        public C0258d(String str, c cVar, String str2, String str3) {
            this.f17081a = str;
            this.f17082b = cVar;
            this.f17083c = str2;
            this.f17084d = str3;
        }

        public final void a(b bVar) {
            k.c(bVar, "result");
            this.f17082b.a(this.f17083c, this.f17084d, bVar.f17074a ? this.f17081a : null, bVar.f17075b);
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f17085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17086b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17087c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f17088d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f17089e;

        public e(d dVar, Context context, String str, boolean z, b bVar) {
            this.f17085a = dVar;
            this.f17086b = context;
            this.f17087c = str;
            this.f17088d = z;
            this.f17089e = bVar;
        }

        public final void run() {
            d.a(this.f17086b, this.f17087c, this.f17088d, this.f17089e);
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public static boolean a() {
        return k.a((Object) Environment.getExternalStorageState(), (Object) "mounted");
    }

    public static a b() {
        return new a(4, FileDownloadErrorCodesKt.EXTERNAL_STORAGE_NO_PERMISSIONS_ERR_MSG);
    }

    public static a c() {
        return new a(5, FileDownloadErrorCodesKt.EXTERNAL_STORAGE_NOT_MOUNTED_ERR_MSG);
    }

    public static File a(Context context, boolean z, String str) {
        File file;
        if (z) {
            StringBuilder sb = new StringBuilder();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            k.a((Object) externalStorageDirectory, "Environment.getExternalStorageDirectory()");
            sb.append(externalStorageDirectory.getAbsolutePath());
            sb.append("/H5DOWNLOADS");
            file = new File(sb.toString());
        } else {
            file = new File(context.getFilesDir(), "H5DOWNLOADS");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, str);
    }

    public static final /* synthetic */ void a(Context context, String str, boolean z, b bVar) {
        if (z && !a(context)) {
            bVar.a(str, b());
        } else if (!z || a()) {
            File a2 = a(context, z, str);
            if (!a2.exists()) {
                bVar.a(str, new a(6, FileDownloadErrorCodesKt.FILE_NOT_FOUND_ERR_MSG));
            } else if (a2.delete()) {
                bVar.a(str, (a) null);
            } else {
                bVar.a(str, new a(7, FileDownloadErrorCodesKt.FILE_NOT_DELETED_ERR_MSG));
            }
        } else {
            bVar.a(str, c());
        }
    }
}
