package com.alibaba.a.b;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final a[] f6247a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f6248b;

    /* renamed from: c  reason: collision with root package name */
    private final char[][] f6249c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6250d;

    /* renamed from: e  reason: collision with root package name */
    private int f6251e;

    public j() {
        this((byte) 0);
        a("$ref", 0, 4, "$ref".hashCode());
        a(com.alibaba.a.a.DEFAULT_TYPE_KEY, 0, 5, com.alibaba.a.a.DEFAULT_TYPE_KEY.hashCode());
    }

    private j(byte b2) {
        this.f6251e = 0;
        this.f6250d = 511;
        this.f6247a = new a[512];
        this.f6248b = new String[512];
        this.f6249c = new char[512][];
    }

    public final String a(char[] cArr, int i2, int i3) {
        boolean z;
        boolean z2;
        int i4 = this.f6250d & i3;
        String str = this.f6248b[i4];
        if (str == null) {
            z = true;
        } else if (str.length() == i2) {
            char[] cArr2 = this.f6249c[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= i2) {
                    z = true;
                    break;
                } else if (cArr[i5 + 0] != cArr2[i5]) {
                    z = false;
                    break;
                } else {
                    i5++;
                }
            }
            if (z) {
                return str;
            }
        } else {
            z = false;
        }
        int i6 = 0;
        for (a aVar = this.f6247a[i4]; aVar != null; aVar = aVar.f6256e) {
            char[] cArr3 = aVar.f6254c;
            if (i2 == cArr3.length && i3 == aVar.f6253b) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i2) {
                        z2 = true;
                        break;
                    } else if (cArr[i7 + 0] != cArr3[i7]) {
                        z2 = false;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z2) {
                    return aVar.f6252a;
                }
                i6++;
            }
        }
        if (i6 >= 8) {
            return new String(cArr, 0, i2);
        }
        if (this.f6251e >= 4096) {
            return new String(cArr, 0, i2);
        }
        a aVar2 = new a(cArr, i2, i3, this.f6247a[i4]);
        this.f6247a[i4] = aVar2;
        if (z) {
            this.f6248b[i4] = aVar2.f6252a;
            this.f6249c[i4] = aVar2.f6254c;
        }
        this.f6251e++;
        return aVar2.f6252a;
    }

    public final String a(String str, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        int i5 = this.f6250d & i4;
        String str2 = this.f6248b[i5];
        if (str2 == null) {
            z = true;
        } else if (str2.length() == i3) {
            char[] cArr = this.f6249c[i5];
            int i6 = 0;
            while (true) {
                if (i6 >= i3) {
                    z = true;
                    break;
                } else if (str.charAt(i2 + i6) != cArr[i6]) {
                    z = false;
                    break;
                } else {
                    i6++;
                }
            }
            if (z) {
                return str2;
            }
        } else {
            z = false;
        }
        int i7 = 0;
        for (a aVar = this.f6247a[i5]; aVar != null; aVar = aVar.f6256e) {
            char[] cArr2 = aVar.f6254c;
            if (i3 == cArr2.length && i4 == aVar.f6253b) {
                int i8 = 0;
                while (true) {
                    if (i8 >= i3) {
                        z2 = true;
                        break;
                    } else if (str.charAt(i2 + i8) != cArr2[i8]) {
                        z2 = false;
                        break;
                    } else {
                        i8++;
                    }
                }
                if (z2) {
                    return aVar.f6252a;
                }
                i7++;
            }
        }
        if (i7 >= 8) {
            return b(str, i2, i3);
        }
        if (this.f6251e >= 4096) {
            return b(str, i2, i3);
        }
        a aVar2 = new a(str, i2, i3, i4, this.f6247a[i5]);
        this.f6247a[i5] = aVar2;
        if (z) {
            this.f6248b[i5] = aVar2.f6252a;
            this.f6249c[i5] = aVar2.f6254c;
        }
        this.f6251e++;
        return aVar2.f6252a;
    }

    /* access modifiers changed from: private */
    public static String b(String str, int i2, int i3) {
        char[] cArr = new char[i3];
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            cArr[i4 - i2] = str.charAt(i4);
        }
        return new String(cArr);
    }

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f6252a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6253b;

        /* renamed from: c  reason: collision with root package name */
        public final char[] f6254c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f6255d;

        /* renamed from: e  reason: collision with root package name */
        public a f6256e;

        public a(char[] cArr, int i2, int i3, a aVar) {
            this.f6254c = new char[i2];
            System.arraycopy(cArr, 0, this.f6254c, 0, i2);
            this.f6252a = new String(this.f6254c).intern();
            this.f6256e = aVar;
            this.f6253b = i3;
            this.f6255d = null;
        }

        public a(String str, int i2, int i3, int i4, a aVar) {
            this.f6252a = j.b(str, i2, i3).intern();
            this.f6254c = this.f6252a.toCharArray();
            this.f6256e = aVar;
            this.f6253b = i4;
            this.f6255d = null;
        }
    }
}
