package androidx.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5092a = new a().a();

    /* renamed from: c  reason: collision with root package name */
    private static final String f5093c = l.a("Data");

    /* renamed from: b  reason: collision with root package name */
    Map<String, Object> f5094b;

    e() {
    }

    public e(e eVar) {
        this.f5094b = new HashMap(eVar.f5094b);
    }

    e(Map<String, ?> map) {
        this.f5094b = new HashMap(map);
    }

    public final String a(String str) {
        Object obj = this.f5094b.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:22|23|(0)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|20|24|25|(2:27|28)|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:7|5)|8|9|10|11|13|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[SYNTHETIC, Splitter:B:27:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(androidx.work.e r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x005f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x005f }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r4.f5094b     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            int r1 = r1.size()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.f5094b     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
        L_0x001e:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            goto L_0x001e
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r0.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            int r4 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r4 > r1) goto L_0x0050
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r4.<init>(r0)
            throw r4
        L_0x0058:
            r4 = move-exception
            goto L_0x006c
        L_0x005a:
            r1 = r2
            goto L_0x005f
        L_0x005c:
            r4 = move-exception
            r2 = r1
            goto L_0x006c
        L_0x005f:
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            r0.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            return r4
        L_0x006c:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            r0.close()     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.e.a(androidx.work.e):byte[]");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[SYNTHETIC, Splitter:B:28:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.e a(byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x004d
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x0040, all -> 0x0034 }
            r2.<init>(r1)     // Catch:{ IOException | ClassNotFoundException -> 0x0040, all -> 0x0034 }
            int r5 = r2.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
        L_0x0019:
            if (r5 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            r0.put(r3, r4)     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            int r5 = r5 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0047
        L_0x0030:
            r5 = move-exception
            goto L_0x0037
        L_0x0032:
            r5 = r2
            goto L_0x0041
        L_0x0034:
            r0 = move-exception
            r2 = r5
            r5 = r0
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            throw r5
        L_0x0040:
        L_0x0041:
            if (r5 == 0) goto L_0x002c
            r5.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x002c
        L_0x0047:
            androidx.work.e r5 = new androidx.work.e
            r5.<init>((java.util.Map<java.lang.String, ?>) r0)
            return r5
        L_0x004d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.e.a(byte[]):androidx.work.e");
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        Set<String> keySet = this.f5094b.keySet();
        if (!keySet.equals(eVar.f5094b.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.f5094b.get(next);
            Object obj3 = eVar.f5094b.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f5094b.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f5094b.isEmpty()) {
            for (String next : this.f5094b.keySet()) {
                sb.append(next);
                sb.append(" : ");
                Object obj = this.f5094b.get(next);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    static Integer[] a(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    static Long[] a(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    static Float[] a(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    static Double[] a(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f5095a = new HashMap();

        public final a a(String str, String str2) {
            this.f5095a.put(str, str2);
            return this;
        }

        public final a a(e eVar) {
            a(eVar.f5094b);
            return this;
        }

        public final a a(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                a((String) next.getKey(), next.getValue());
            }
            return this;
        }

        private a a(String str, Object obj) {
            if (obj == null) {
                this.f5095a.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f5095a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f5095a.put(str, e.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f5095a.put(str, e.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f5095a.put(str, e.a((int[]) obj));
                } else if (cls == long[].class) {
                    this.f5095a.put(str, e.a((long[]) obj));
                } else if (cls == float[].class) {
                    this.f5095a.put(str, e.a((float[]) obj));
                } else if (cls == double[].class) {
                    this.f5095a.put(str, e.a((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        public final e a() {
            e eVar = new e((Map<String, ?>) this.f5095a);
            e.a(eVar);
            return eVar;
        }
    }
}
