package com.google.firebase.crashlytics.a.g;

import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.c.c;
import com.google.firebase.crashlytics.a.c.o;
import com.google.firebase.crashlytics.a.e.v;
import com.google.firebase.crashlytics.a.e.w;
import com.google.firebase.crashlytics.a.k.e;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f38583b = Charset.forName(AppConstants.UTF_8);

    /* renamed from: c  reason: collision with root package name */
    private static final int f38584c = 15;

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.firebase.crashlytics.a.e.a.a f38585d = new com.google.firebase.crashlytics.a.e.a.a();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<? super File> f38586e = f.a();

    /* renamed from: f  reason: collision with root package name */
    private static final FilenameFilter f38587f = g.a();

    /* renamed from: a  reason: collision with root package name */
    public final File f38588a;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f38589g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private final File f38590h;

    /* renamed from: i  reason: collision with root package name */
    private final File f38591i;
    private final File j;
    private final e k;

    public a(File file, e eVar) {
        File file2 = new File(file, "report-persistence");
        this.f38590h = new File(file2, "sessions");
        this.f38591i = new File(file2, "priority-reports");
        this.j = new File(file2, "reports");
        this.f38588a = new File(file2, "native-reports");
        this.k = eVar;
    }

    public final void a(v.d.C0634d dVar, String str, boolean z) {
        int i2 = this.k.a().a().f38671a;
        File b2 = b(str);
        try {
            a(new File(b2, a(this.f38589g.getAndIncrement(), z)), com.google.firebase.crashlytics.a.e.a.a.a(dVar));
        } catch (IOException unused) {
            b a2 = b.a();
            "Could not persist event for session ".concat(String.valueOf(str));
            a2.a(3);
        }
        a(b2, i2);
    }

    public final void a() {
        for (File delete : d()) {
            delete.delete();
        }
    }

    public final void a(String str) {
        FilenameFilter a2 = b.a(str);
        for (File delete : b((List<File>[]) new List[]{a(this.f38591i, a2), a(this.f38588a, a2), a(this.j, a2)})) {
            delete.delete();
        }
    }

    public final void a(String str, long j2) {
        for (File next : e(str)) {
            a(next, j2);
            d(next);
        }
        c();
    }

    public final List<o> b() {
        List<File> d2 = d();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(d2.size());
        for (File next : d()) {
            try {
                arrayList.add(new c(com.google.firebase.crashlytics.a.e.a.a.a(c(next)), next.getName()));
            } catch (IOException unused) {
                b a2 = b.a();
                StringBuilder sb = new StringBuilder("Could not load report file ");
                sb.append(next);
                sb.append("; deleting");
                a2.a(3);
                next.delete();
            }
        }
        return arrayList;
    }

    private List<File> e(String str) {
        List<File> a2 = a(this.f38590h, c.a(str));
        Collections.sort(a2, f38586e);
        if (a2.size() <= 8) {
            return a2;
        }
        for (File d2 : a2.subList(8, a2.size())) {
            d(d2);
        }
        return a2.subList(0, 8);
    }

    static /* synthetic */ boolean a(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    private void c() {
        int i2 = this.k.a().a().f38672b;
        List<File> d2 = d();
        int size = d2.size();
        if (size > i2) {
            for (File delete : d2.subList(i2, size)) {
                delete.delete();
            }
        }
    }

    private List<File> d() {
        return a((List<File>[]) new List[]{b((List<File>[]) new List[]{a(this.f38591i, (FileFilter) null), a(this.f38588a, (FileFilter) null)}), a(this.j, (FileFilter) null)});
    }

    public final File b(String str) {
        return new File(this.f38590h, str);
    }

    private void a(File file, long j2) {
        boolean z;
        List<File> a2 = a(file, f38587f);
        if (!a2.isEmpty()) {
            Collections.sort(a2);
            ArrayList arrayList = new ArrayList();
            Iterator<File> it2 = a2.iterator();
            loop0:
            while (true) {
                z = false;
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    }
                    File next = it2.next();
                    try {
                        arrayList.add(com.google.firebase.crashlytics.a.e.a.a.b(c(next)));
                        if (z || f(next.getName())) {
                            z = true;
                        }
                    } catch (IOException unused) {
                        b a3 = b.a();
                        "Could not add event to report for ".concat(String.valueOf(next));
                        a3.a(3);
                    }
                }
            }
            String str = null;
            File file2 = new File(file, StringSet.user);
            if (file2.isFile()) {
                try {
                    str = c(file2);
                } catch (IOException unused2) {
                    b a4 = b.a();
                    new StringBuilder("Could not read user ID file in ").append(file.getName());
                    a4.a(3);
                }
            }
            a(new File(file, H5Param.MENU_REPORT), z ? this.f38591i : this.j, arrayList, j2, z, str);
        }
    }

    private static void a(File file, File file2, List<v.d.C0634d> list, long j2, boolean z, String str) {
        try {
            v a2 = com.google.firebase.crashlytics.a.e.a.a.a(c(file)).a(j2, z, str).a(w.a(list));
            v.d g2 = a2.g();
            if (g2 != null) {
                a(new File(a(file2), g2.b()), com.google.firebase.crashlytics.a.e.a.a.a(a2));
            }
        } catch (IOException unused) {
            b a3 = b.a();
            "Could not synthesize final report file for ".concat(String.valueOf(file));
            a3.a(3);
        }
    }

    private static List<File> a(List<File>... listArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            Collections.sort(listArr[i2], f38586e);
        }
        return b(listArr);
    }

    private static List<File> b(List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (List<File> size : listArr) {
            i2 += size.size();
        }
        arrayList.ensureCapacity(i2);
        for (List<File> addAll : listArr) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    private static boolean f(String str) {
        return str.startsWith(AppConstants.NOTIFICATION_DETAILS.EVENT) && str.endsWith("_");
    }

    private static String a(int i2, boolean z) {
        String format = String.format(Locale.US, "%010d", new Object[]{Integer.valueOf(i2)});
        String str = z ? "_" : "";
        return AppConstants.NOTIFICATION_DETAILS.EVENT + format + str;
    }

    private static int a(File file, int i2) {
        List<File> a2 = a(file, d.a());
        Collections.sort(a2, e.a());
        return a(a2, i2);
    }

    private static String g(String str) {
        return str.substring(0, f38584c);
    }

    private static List<File> a(File file, FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private static List<File> a(File file, FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    public static File a(File file) throws IOException {
        if (b(file)) {
            return file;
        }
        throw new IOException("Could not create directory ".concat(String.valueOf(file)));
    }

    private static boolean b(File file) {
        return file.exists() || file.mkdirs();
    }

    public static void a(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f38583b);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable unused) {
        }
        throw th;
    }

    private static String c(File file) throws IOException {
        byte[] bArr = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f38583b);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        throw th;
    }

    private static int a(List<File> list, int i2) {
        int size = list.size();
        for (File next : list) {
            if (size <= i2) {
                return size;
            }
            d(next);
            size--;
        }
        return size;
    }

    private static void d(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                for (File d2 : file.listFiles()) {
                    d(d2);
                }
            }
            file.delete();
        }
    }

    static /* synthetic */ boolean d(String str) {
        return str.startsWith(AppConstants.NOTIFICATION_DETAILS.EVENT) && !str.endsWith("_");
    }
}
