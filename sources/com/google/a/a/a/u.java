package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import com.google.a.a.b.a.a.a.a.d;
import com.google.a.a.c.a.a;
import com.google.a.a.c.b;
import com.google.a.a.c.e;
import com.google.a.a.c.f;
import com.google.a.a.c.g;
import com.google.a.a.c.j;
import com.google.a.a.c.k;
import com.google.a.a.c.v;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7534a;

    static {
        i iVar = new i("application/x-www-form-urlencoded");
        Charset charset = e.f7564a;
        iVar.a("charset", charset == null ? null : charset.name());
        f7534a = iVar.a();
    }

    public static void a(String str, Object obj) {
        if (str != null) {
            try {
                a((Reader) new StringReader(str), obj);
            } catch (IOException e2) {
                Throwable th = (Throwable) c.a(e2);
                d.a(th, Error.class);
                d.a(th, RuntimeException.class);
                throw new RuntimeException(e2);
            }
        }
    }

    private static void a(Reader reader, Object obj) throws IOException {
        int read;
        Type type;
        Object obj2 = obj;
        Class<?> cls = obj.getClass();
        f a2 = f.a(cls);
        List asList = Arrays.asList(new Type[]{cls});
        k kVar = k.class.isAssignableFrom(cls) ? (k) obj2 : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj2 : null;
        b bVar = new b(obj2);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            StringWriter stringWriter3 = stringWriter2;
            StringWriter stringWriter4 = stringWriter;
            boolean z = true;
            while (true) {
                read = reader.read();
                if (read == -1 || read == 38) {
                    String b2 = a.b(stringWriter4.toString());
                } else if (read == 61) {
                    z = false;
                } else if (z) {
                    stringWriter4.write(read);
                } else {
                    stringWriter3.write(read);
                }
            }
            String b22 = a.b(stringWriter4.toString());
            if (b22.length() != 0) {
                String b3 = a.b(stringWriter3.toString());
                j a3 = a2.a(b22);
                if (a3 != null) {
                    Type a4 = g.a((List<Type>) asList, a3.f7597b.getGenericType());
                    if (v.a(a4)) {
                        Class<?> a5 = v.a((List<Type>) asList, v.b(a4));
                        bVar.a(a3.f7597b, a5, a(a5, asList, b3));
                    } else if (v.a(v.a((List<Type>) asList, a4), (Class<?>) Iterable.class)) {
                        Collection<Object> collection = (Collection) a3.a(obj2);
                        if (collection == null) {
                            collection = g.b(a4);
                            a3.a(obj2, (Object) collection);
                        }
                        if (a4 == Object.class) {
                            type = null;
                        } else {
                            type = v.a(a4, (Class<?>) Iterable.class);
                        }
                        collection.add(a(type, asList, b3));
                    } else {
                        a3.a(obj2, a(a4, asList, b3));
                    }
                } else if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(b22);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        if (kVar != null) {
                            kVar.a(b22, arrayList);
                        } else {
                            map.put(b22, arrayList);
                        }
                    }
                    arrayList.add(b3);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (read != -1);
        bVar.a();
    }

    private static Object a(Type type, List<Type> list, String str) {
        return g.a(g.a(list, type), str);
    }
}
