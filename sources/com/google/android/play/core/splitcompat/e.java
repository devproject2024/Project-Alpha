package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f37501a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37502b;

    /* renamed from: c  reason: collision with root package name */
    private File f37503c;

    public e(Context context) throws PackageManager.NameNotFoundException {
        this.f37502b = context;
        this.f37501a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static File a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    static void b(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() == 0 ? new String("Unable to create directory: ") : "Unable to create directory: ".concat(valueOf));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    private static void c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c2 : listFiles) {
                c(c2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    public static String e(String str) {
        return String.valueOf(str).concat(".apk");
    }

    private final File g() throws IOException {
        if (this.f37503c == null) {
            Context context = this.f37502b;
            if (context != null) {
                this.f37503c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f37503c, "splitcompat");
        b(file);
        return file;
    }

    public final File a(String str) throws IOException {
        return a(c(), e(str));
    }

    public final void a() throws IOException {
        File g2 = g();
        String[] list = g2.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f37501a))) {
                    File file = new File(g2, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f37501a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    c(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(File file) throws IOException {
        r.a(file.getParentFile().getParentFile().equals(e()), (Object) "File to remove is not a native library");
        c(file);
    }

    public final File b() throws IOException {
        File file = new File(d(), "unverified-splits");
        b(file);
        return file;
    }

    /* access modifiers changed from: package-private */
    public final File b(String str) throws IOException {
        File a2 = a(e(), str);
        b(a2);
        return a2;
    }

    public final File c() throws IOException {
        File file = new File(d(), "verified-splits");
        b(file);
        return file;
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) throws IOException {
        c(b(str));
    }

    public final File d() throws IOException {
        File file = new File(g(), Long.toString(this.f37501a));
        b(file);
        return file;
    }

    /* access modifiers changed from: package-private */
    public final Set<File> d(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = b(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final File e() throws IOException {
        File file = new File(d(), "native-libraries");
        b(file);
        return file;
    }

    /* access modifiers changed from: package-private */
    public final Set<s> f() throws IOException {
        File c2 = c();
        HashSet hashSet = new HashSet();
        File[] listFiles = c2.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new c(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final void f(String str) throws IOException {
        c(a(str));
    }
}
