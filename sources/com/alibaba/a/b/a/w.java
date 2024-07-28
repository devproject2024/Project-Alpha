package com.alibaba.a.b.a;

import com.alibaba.a.a;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.b.g;
import com.alibaba.a.b.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class w implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final w f6213a = new w();

    public final int a() {
        return 12;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        T t;
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.a(16);
            return null;
        }
        Map<Object, Object> a2 = a(type);
        h d2 = bVar.d();
        try {
            bVar.a(d2, (Object) a2, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    t = a(bVar, (Map<String, Object>) a2, type3, obj);
                } else {
                    t = a(bVar, a2, type2, type3);
                }
            } else {
                t = bVar.a((Map) a2, obj);
            }
            return t;
        } finally {
            bVar.a(d2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r10 = r9.c().a((java.lang.reflect.Type) r2);
        r0.a(16);
        r9.f6223f = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0107, code lost:
        if (r1 == null) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010b, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        r9.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0110, code lost:
        r10 = (java.util.Map) r10.a(r9, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0116, code lost:
        r9.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0119, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map a(com.alibaba.a.b.b r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
            com.alibaba.a.b.d r0 = r9.g()
            int r1 = r0.a()
            r2 = 12
            if (r1 != r2) goto L_0x017a
            com.alibaba.a.b.h r1 = r9.d()
        L_0x0010:
            r0.c()     // Catch:{ all -> 0x0175 }
            char r2 = r0.e()     // Catch:{ all -> 0x0175 }
            com.alibaba.a.b.c r3 = com.alibaba.a.b.c.AllowArbitraryCommas     // Catch:{ all -> 0x0175 }
            boolean r3 = r9.a((com.alibaba.a.b.c) r3)     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x002e
        L_0x001f:
            r3 = 44
            if (r2 != r3) goto L_0x002e
            r0.f()     // Catch:{ all -> 0x0175 }
            r0.c()     // Catch:{ all -> 0x0175 }
            char r2 = r0.e()     // Catch:{ all -> 0x0175 }
            goto L_0x001f
        L_0x002e:
            java.lang.String r3 = "expect ':' at "
            r4 = 58
            r5 = 34
            r6 = 16
            if (r2 != r5) goto L_0x0061
            com.alibaba.a.b.j r2 = r9.b()     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = r0.a(r2, r5)     // Catch:{ all -> 0x0175 }
            r0.c()     // Catch:{ all -> 0x0175 }
            char r7 = r0.e()     // Catch:{ all -> 0x0175 }
            if (r7 != r4) goto L_0x004b
            goto L_0x00c8
        L_0x004b:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r11.<init>(r3)     // Catch:{ all -> 0x0175 }
            int r12 = r0.i()     // Catch:{ all -> 0x0175 }
            r11.append(r12)     // Catch:{ all -> 0x0175 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0175 }
            r10.<init>(r11)     // Catch:{ all -> 0x0175 }
            throw r10     // Catch:{ all -> 0x0175 }
        L_0x0061:
            r7 = 125(0x7d, float:1.75E-43)
            if (r2 != r7) goto L_0x0072
            r0.f()     // Catch:{ all -> 0x0175 }
            r0.g()     // Catch:{ all -> 0x0175 }
            r0.a((int) r6)     // Catch:{ all -> 0x0175 }
            r9.a((com.alibaba.a.b.h) r1)
            return r10
        L_0x0072:
            java.lang.String r7 = "syntax error"
            r8 = 39
            if (r2 != r8) goto L_0x00af
            com.alibaba.a.b.c r2 = com.alibaba.a.b.c.AllowSingleQuotes     // Catch:{ all -> 0x0175 }
            boolean r2 = r9.a((com.alibaba.a.b.c) r2)     // Catch:{ all -> 0x0175 }
            if (r2 == 0) goto L_0x00a9
            com.alibaba.a.b.j r2 = r9.b()     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = r0.a(r2, r8)     // Catch:{ all -> 0x0175 }
            r0.c()     // Catch:{ all -> 0x0175 }
            char r7 = r0.e()     // Catch:{ all -> 0x0175 }
            if (r7 != r4) goto L_0x0093
            goto L_0x00c8
        L_0x0093:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r11.<init>(r3)     // Catch:{ all -> 0x0175 }
            int r12 = r0.i()     // Catch:{ all -> 0x0175 }
            r11.append(r12)     // Catch:{ all -> 0x0175 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0175 }
            r10.<init>(r11)     // Catch:{ all -> 0x0175 }
            throw r10     // Catch:{ all -> 0x0175 }
        L_0x00a9:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0175 }
            r10.<init>(r7)     // Catch:{ all -> 0x0175 }
            throw r10     // Catch:{ all -> 0x0175 }
        L_0x00af:
            com.alibaba.a.b.c r2 = com.alibaba.a.b.c.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0175 }
            boolean r2 = r9.a((com.alibaba.a.b.c) r2)     // Catch:{ all -> 0x0175 }
            if (r2 == 0) goto L_0x016f
            com.alibaba.a.b.j r2 = r9.b()     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = r0.b((com.alibaba.a.b.j) r2)     // Catch:{ all -> 0x0175 }
            r0.c()     // Catch:{ all -> 0x0175 }
            char r7 = r0.e()     // Catch:{ all -> 0x0175 }
            if (r7 != r4) goto L_0x0151
        L_0x00c8:
            r0.f()     // Catch:{ all -> 0x0175 }
            r0.c()     // Catch:{ all -> 0x0175 }
            r0.g()     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = com.alibaba.a.a.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0175 }
            r4 = 13
            if (r2 != r3) goto L_0x011a
            com.alibaba.a.b.j r2 = r9.b()     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = r0.a(r2, r5)     // Catch:{ all -> 0x0175 }
            java.lang.Class r2 = com.alibaba.a.d.g.a((java.lang.String) r2)     // Catch:{ all -> 0x0175 }
            java.lang.Class r3 = r10.getClass()     // Catch:{ all -> 0x0175 }
            if (r2 != r3) goto L_0x00f9
            r0.a((int) r6)     // Catch:{ all -> 0x0175 }
            int r2 = r0.a()     // Catch:{ all -> 0x0175 }
            if (r2 != r4) goto L_0x0010
            r0.a((int) r6)     // Catch:{ all -> 0x0175 }
            r9.a((com.alibaba.a.b.h) r1)
            return r10
        L_0x00f9:
            com.alibaba.a.b.i r10 = r9.c()     // Catch:{ all -> 0x0175 }
            com.alibaba.a.b.a.z r10 = r10.a((java.lang.reflect.Type) r2)     // Catch:{ all -> 0x0175 }
            r0.a((int) r6)     // Catch:{ all -> 0x0175 }
            r11 = 2
            r9.f6223f = r11     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x0110
            boolean r11 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x0175 }
            if (r11 != 0) goto L_0x0110
            r9.f()     // Catch:{ all -> 0x0175 }
        L_0x0110:
            java.lang.Object r10 = r10.a(r9, r2, r12)     // Catch:{ all -> 0x0175 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ all -> 0x0175 }
            r9.a((com.alibaba.a.b.h) r1)
            return r10
        L_0x011a:
            r0.d()     // Catch:{ all -> 0x0175 }
            int r3 = r0.a()     // Catch:{ all -> 0x0175 }
            r5 = 8
            if (r3 != r5) goto L_0x012a
            r3 = 0
            r0.d()     // Catch:{ all -> 0x0175 }
            goto L_0x012e
        L_0x012a:
            java.lang.Object r3 = r9.a((java.lang.reflect.Type) r11)     // Catch:{ all -> 0x0175 }
        L_0x012e:
            r10.put(r2, r3)     // Catch:{ all -> 0x0175 }
            r9.a((java.util.Map) r10, (java.lang.String) r2)     // Catch:{ all -> 0x0175 }
            r9.a((com.alibaba.a.b.h) r1, (java.lang.Object) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x0175 }
            int r2 = r0.a()     // Catch:{ all -> 0x0175 }
            r3 = 20
            if (r2 == r3) goto L_0x014d
            r3 = 15
            if (r2 != r3) goto L_0x0144
            goto L_0x014d
        L_0x0144:
            if (r2 != r4) goto L_0x0010
            r0.d()     // Catch:{ all -> 0x0175 }
            r9.a((com.alibaba.a.b.h) r1)
            return r10
        L_0x014d:
            r9.a((com.alibaba.a.b.h) r1)
            return r10
        L_0x0151:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r11.<init>(r3)     // Catch:{ all -> 0x0175 }
            int r12 = r0.i()     // Catch:{ all -> 0x0175 }
            r11.append(r12)     // Catch:{ all -> 0x0175 }
            java.lang.String r12 = ", actual "
            r11.append(r12)     // Catch:{ all -> 0x0175 }
            r11.append(r7)     // Catch:{ all -> 0x0175 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0175 }
            r10.<init>(r11)     // Catch:{ all -> 0x0175 }
            throw r10     // Catch:{ all -> 0x0175 }
        L_0x016f:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0175 }
            r10.<init>(r7)     // Catch:{ all -> 0x0175 }
            throw r10     // Catch:{ all -> 0x0175 }
        L_0x0175:
            r10 = move-exception
            r9.a((com.alibaba.a.b.h) r1)
            throw r10
        L_0x017a:
            com.alibaba.a.d r9 = new com.alibaba.a.d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "syntax error, expect {, actual "
            r10.<init>(r11)
            int r11 = r0.a()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.w.a(com.alibaba.a.b.b, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    private static Object a(b bVar, Map<Object, Object> map, Type type, Type type2) {
        d g2 = bVar.g();
        if (g2.a() == 12 || g2.a() == 16) {
            z a2 = bVar.c().a(type);
            z a3 = bVar.c().a(type2);
            g2.a(a2.a());
            h d2 = bVar.d();
            while (g2.a() != 13) {
                try {
                    Object obj = null;
                    if (g2.a() != 4 || !g2.t()) {
                        if (map.size() == 0 && g2.a() == 4 && a.DEFAULT_TYPE_KEY.equals(g2.l())) {
                            g2.p();
                            g2.a(16);
                            if (g2.a() == 13) {
                                g2.d();
                                return map;
                            }
                            g2.a(a2.a());
                        }
                        Object a4 = a2.a(bVar, type, (Object) null);
                        if (g2.a() == 17) {
                            g2.a(a3.a());
                            map.put(a4, a3.a(bVar, type2, a4));
                            if (g2.a() == 16) {
                                g2.a(a2.a());
                            }
                        } else {
                            throw new com.alibaba.a.d("syntax error, expect :, actual " + g2.a());
                        }
                    } else {
                        g2.p();
                        if (g2.a() == 4) {
                            String l = g2.l();
                            if ("..".equals(l)) {
                                obj = d2.f6240b.f6239a;
                            } else if ("$".equals(l)) {
                                h hVar = d2;
                                while (hVar.f6240b != null) {
                                    hVar = hVar.f6240b;
                                }
                                obj = hVar.f6239a;
                            } else {
                                bVar.a(new b.a(d2, l));
                                bVar.f6223f = 1;
                            }
                            g2.a(13);
                            if (g2.a() == 13) {
                                g2.a(16);
                                bVar.a(d2);
                                return obj;
                            }
                            throw new com.alibaba.a.d("illegal ref");
                        }
                        throw new com.alibaba.a.d("illegal ref, " + g.a(g2.a()));
                    }
                } finally {
                    bVar.a(d2);
                }
            }
            g2.a(16);
            bVar.a(d2);
            return map;
        }
        throw new com.alibaba.a.d("syntax error, expect {, actual " + g2.b());
    }

    private static Map<Object, Object> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                Class cls = (Class) type;
                if (!cls.isInterface()) {
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e2) {
                        throw new com.alibaba.a.d("unsupport type ".concat(String.valueOf(type)), e2);
                    }
                } else {
                    throw new com.alibaba.a.d("unsupport type ".concat(String.valueOf(type)));
                }
            }
        }
        return new Properties();
    }
}
