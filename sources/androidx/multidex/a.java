package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<File> f3846a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f3847b = a(System.getProperty("java.vm.version"));

    public static void a(Context context) {
        if (!f3847b) {
            if (Build.VERSION.SDK_INT >= 4) {
                try {
                    ApplicationInfo c2 = c(context);
                    if (c2 != null) {
                        a(context, new File(c2.sourceDir), new File(c2.dataDir), "secondary-dexes", "");
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
                }
            } else {
                throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[SYNTHETIC, Splitter:B:31:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r3, java.io.File r4, java.io.File r5, java.lang.String r6, java.lang.String r7) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = f3846a
            monitor-enter(r0)
            java.util.Set<java.io.File> r1 = f3846a     // Catch:{ all -> 0x006c }
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x000d:
            java.util.Set<java.io.File> r1 = f3846a     // Catch:{ all -> 0x006c }
            r1.add(r4)     // Catch:{ all -> 0x006c }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006c }
            r2 = 20
            if (r1 <= r2) goto L_0x0037
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "MultiDex is not guaranteed to work in SDK version "
            r1.<init>(r2)     // Catch:{ all -> 0x006c }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006c }
            r1.append(r2)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\""
            r1.append(r2)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ all -> 0x006c }
            r1.append(r2)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "\""
            r1.append(r2)     // Catch:{ all -> 0x006c }
        L_0x0037:
            java.lang.ClassLoader r1 = b(r3)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x003f
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x003f:
            d(r3)     // Catch:{ all -> 0x0042 }
        L_0x0042:
            java.io.File r5 = a((android.content.Context) r3, (java.io.File) r5, (java.lang.String) r6)     // Catch:{ all -> 0x006c }
            androidx.multidex.b r6 = new androidx.multidex.b     // Catch:{ all -> 0x006c }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x006c }
            r4 = 0
            r2 = 0
            java.util.List r2 = r6.a(r3, r7, r2)     // Catch:{ all -> 0x0067 }
            a((java.lang.ClassLoader) r1, (java.io.File) r5, (java.util.List<? extends java.io.File>) r2)     // Catch:{ IOException -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r2 = 1
            java.util.List r3 = r6.a(r3, r7, r2)     // Catch:{ all -> 0x0067 }
            a((java.lang.ClassLoader) r1, (java.io.File) r5, (java.util.List<? extends java.io.File>) r3)     // Catch:{ all -> 0x0067 }
        L_0x005d:
            r6.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r4 = move-exception
        L_0x0062:
            if (r4 != 0) goto L_0x0066
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x0066:
            throw r4     // Catch:{ all -> 0x006c }
        L_0x0067:
            r3 = move-exception
            r6.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            throw r3     // Catch:{ all -> 0x006c }
        L_0x006c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.a.a(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String):void");
    }

    private static ClassLoader b(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static ApplicationInfo c(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static boolean a(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, AppUtility.CENTER_DOT);
            String str2 = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str2 = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str2 == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            b.a(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            C0062a.a(classLoader, list);
        } else {
            c.a(classLoader, list);
        }
    }

    /* access modifiers changed from: private */
    public static Field b(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void d(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder("Clearing old secondary dex dir (");
            sb.append(file.getPath());
            sb.append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb2 = new StringBuilder("Failed to list secondary dex dir content (");
                sb2.append(file.getPath());
                sb2.append(").");
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb3 = new StringBuilder("Trying to delete old file ");
                sb3.append(file2.getPath());
                sb3.append(" of size ");
                sb3.append(file2.length());
                if (!file2.delete()) {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                }
            }
            if (!file.delete()) {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            }
        }
    }

    private static File a(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            a(file2);
        }
        File file3 = new File(file2, str);
        a(file3);
        return file3;
    }

    private static void a(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                StringBuilder sb = new StringBuilder("Failed to create dir ");
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
            } else {
                StringBuilder sb2 = new StringBuilder("Failed to create dir ");
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }

    static final class b {
        static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                Field a2 = a.b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) a.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* renamed from: androidx.multidex.a$a  reason: collision with other inner class name */
    static final class C0062a {

        /* renamed from: a  reason: collision with root package name */
        private static final int f3848a = 4;

        /* renamed from: b  reason: collision with root package name */
        private final C0063a f3849b;

        /* renamed from: androidx.multidex.a$a$a  reason: collision with other inner class name */
        interface C0063a {
            Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* renamed from: androidx.multidex.a$a$b */
        static class b implements C0063a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f3850a;

            b(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3850a = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.f3850a.setAccessible(true);
            }

            public final Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f3850a.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        /* renamed from: androidx.multidex.a$a$c */
        static class c implements C0063a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f3851a;

            c(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3851a = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.f3851a.setAccessible(true);
            }

            public final Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f3851a.newInstance(new Object[]{file, file, dexFile});
            }
        }

        /* renamed from: androidx.multidex.a$a$d */
        static class d implements C0063a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f3852a;

            d(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3852a = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.f3852a.setAccessible(true);
            }

            public final Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f3852a.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            C0062a aVar = new C0062a();
            Object[] objArr = new Object[list.size()];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                File file = (File) list.get(i2);
                C0063a aVar2 = aVar.f3849b;
                String path = file.getPath();
                File parentFile = file.getParentFile();
                String name = file.getName();
                objArr[i2] = aVar2.a(file, DexFile.loadDex(path, new File(parentFile, name.substring(0, name.length() - f3848a) + ".dex").getPath(), 0));
            }
            try {
                a.a(obj, "dexElements", objArr);
            } catch (NoSuchFieldException unused) {
                a.a(obj, "pathElements", objArr);
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C0062a() throws java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.NoSuchMethodException {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                androidx.multidex.a$a$b r1 = new androidx.multidex.a$a$b     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                androidx.multidex.a$a$c r1 = new androidx.multidex.a$a$c     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                androidx.multidex.a$a$d r1 = new androidx.multidex.a$a$d
                r1.<init>(r0)
            L_0x001a:
                r2.f3849b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.a.C0062a.<init>():void");
        }
    }

    static final class c {
        static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field a2 = a.b(classLoader, H5TabbarUtils.MATCH_TYPE_PATH);
            StringBuilder sb = new StringBuilder((String) a2.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            a2.set(classLoader, sb.toString());
            a.a((Object) classLoader, "mPaths", (Object[]) strArr);
            a.a((Object) classLoader, "mFiles", (Object[]) fileArr);
            a.a((Object) classLoader, "mZips", (Object[]) zipFileArr);
            a.a((Object) classLoader, "mDexs", (Object[]) dexFileArr);
        }
    }

    static /* synthetic */ void a(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b2.set(obj, objArr3);
    }
}
