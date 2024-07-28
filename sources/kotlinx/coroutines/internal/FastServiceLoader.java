package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.k;
import kotlin.a.y;
import kotlin.m.p;
import kotlin.u;

public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();

    private FastServiceLoader() {
    }

    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        MainDispatcherFactory mainDispatcherFactory;
        MainDispatcherFactory mainDispatcherFactory2;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return load(cls, cls.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            try {
                mainDispatcherFactory = cls.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = cls.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
                mainDispatcherFactory2 = null;
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (Throwable unused3) {
            return load(cls, cls.getClassLoader());
        }
    }

    private final <S> List<S> load(Class<S> cls, ClassLoader classLoader) {
        try {
            return loadProviders$kotlinx_coroutines_core(cls, classLoader);
        } catch (Throwable unused) {
            return k.e(ServiceLoader.load(cls, classLoader));
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> cls, ClassLoader classLoader) {
        Set set;
        ArrayList<T> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.g.b.k.a((Object) list, "java.util.Collections.list(this)");
        Collection arrayList = new ArrayList();
        for (T parse : list) {
            k.a(arrayList, INSTANCE.parse(parse));
        }
        Iterable iterable = (List) arrayList;
        kotlin.g.b.k.d(iterable, "$this$toSet");
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size != 0) {
            set = size != 1 ? (Set) k.b(iterable, new LinkedHashSet(ae.a(collection.size()))) : ak.a(((List) iterable).get(0));
        } else {
            set = y.INSTANCE;
        }
        if (!set.isEmpty()) {
            Iterable<String> iterable2 = set;
            Collection arrayList2 = new ArrayList(k.a(iterable2));
            for (String providerInstance : iterable2) {
                arrayList2.add(INSTANCE.getProviderInstance(providerInstance, classLoader, cls));
            }
            return (List) arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S getProviderInstance(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.f.a.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
        kotlin.a.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a0, code lost:
        kotlin.f.a.a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> parse(java.net.URL r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.toString()
            r1 = 0
            java.lang.String r2 = "jar"
            boolean r2 = kotlin.m.p.b(r0, r2, r1)
            r3 = 0
            if (r2 == 0) goto L_0x007e
            java.lang.String r7 = "jar:file:"
            java.lang.String r7 = kotlin.m.p.c(r0, r7, r0)
            java.lang.String r2 = "$this$substringBefore"
            kotlin.g.b.k.d(r7, r2)
            java.lang.String r2 = "missingDelimiterValue"
            kotlin.g.b.k.d(r7, r2)
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 33
            r5 = 6
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (char) r4, (int) r1, (boolean) r1, (int) r5)
            r4 = -1
            if (r2 != r4) goto L_0x002c
            goto L_0x0035
        L_0x002c:
            java.lang.String r7 = r7.substring(r1, r2)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.b(r7, r2)
        L_0x0035:
            java.lang.String r2 = "!/"
            java.lang.String r0 = kotlin.m.p.c(r0, r2, r0)
            java.util.jar.JarFile r2 = new java.util.jar.JarFile
            r2.<init>(r7, r1)
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0072 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0072 }
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0072 }
            r4.<init>(r0)     // Catch:{ all -> 0x0072 }
            java.io.InputStream r0 = r2.getInputStream(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r0, r4)     // Catch:{ all -> 0x0072 }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ all -> 0x0072 }
            r7.<init>(r1)     // Catch:{ all -> 0x0072 }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x0072 }
            r0 = r7
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x006b }
            kotlinx.coroutines.internal.FastServiceLoader r1 = INSTANCE     // Catch:{ all -> 0x006b }
            java.util.List r0 = r1.parseFile(r0)     // Catch:{ all -> 0x006b }
            kotlin.f.a.a(r7, r3)     // Catch:{ all -> 0x0072 }
            r2.close()     // Catch:{ all -> 0x0069 }
            return r0
        L_0x0069:
            r7 = move-exception
            throw r7
        L_0x006b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x006d }
        L_0x006d:
            r1 = move-exception
            kotlin.f.a.a(r7, r0)     // Catch:{ all -> 0x0072 }
            throw r1     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x0079 }
            throw r0
        L_0x0079:
            r0 = move-exception
            kotlin.a.a(r7, r0)
            throw r7
        L_0x007e:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r7)
            r1.<init>(r7)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r7 = r0
            java.io.BufferedReader r7 = (java.io.BufferedReader) r7     // Catch:{ all -> 0x009d }
            kotlinx.coroutines.internal.FastServiceLoader r1 = INSTANCE     // Catch:{ all -> 0x009d }
            java.util.List r7 = r1.parseFile(r7)     // Catch:{ all -> 0x009d }
            kotlin.f.a.a(r0, r3)
            return r7
        L_0x009d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x009f }
        L_0x009f:
            r1 = move-exception
            kotlin.f.a.a(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.parse(java.net.URL):java.util.List");
    }

    private final List<String> parseFile(BufferedReader bufferedReader) {
        boolean z;
        Set linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return k.e(linkedHashSet);
            }
            String b2 = p.b(readLine, "#", readLine);
            if (b2 != null) {
                String obj = p.b(b2).toString();
                CharSequence charSequence = obj;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= charSequence.length()) {
                        z = true;
                        break;
                    }
                    char charAt = charSequence.charAt(i2);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    if (charSequence.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException("Illegal service provider class name: ".concat(String.valueOf(obj)).toString());
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }
}
