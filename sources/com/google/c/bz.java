package com.google.c;

public final class bz {

    /* renamed from: a  reason: collision with root package name */
    static final int f37827a = 11;

    /* renamed from: b  reason: collision with root package name */
    static final int f37828b = 12;

    /* renamed from: c  reason: collision with root package name */
    static final int f37829c = 16;

    /* renamed from: d  reason: collision with root package name */
    static final int f37830d = 26;

    public static int a(int i2) {
        return i2 & 7;
    }

    static int a(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static int b(int i2) {
        return i2 >>> 3;
    }

    public enum b {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(j.EMPTY),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        private b(Object obj) {
            this.defaultDefault = obj;
        }

        /* access modifiers changed from: package-private */
        public final Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public enum a {
        DOUBLE(b.DOUBLE, 1),
        FLOAT(b.FLOAT, 5),
        INT64(b.LONG, 0),
        UINT64(b.LONG, 0),
        INT32(b.INT, 0),
        FIXED64(b.LONG, 1),
        FIXED32(b.INT, 5),
        BOOL(b.BOOLEAN, 0),
        STRING(b.STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        GROUP(b.MESSAGE, 3) {
            public final boolean isPackable() {
                return false;
            }
        },
        MESSAGE(b.MESSAGE, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        BYTES(b.BYTE_STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        UINT32(b.INT, 0),
        ENUM(b.ENUM, 0),
        SFIXED32(b.INT, 5),
        SFIXED64(b.LONG, 1),
        SINT32(b.INT, 0),
        SINT64(b.LONG, 0);
        
        private final b javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        private a(b bVar, int i2) {
            this.javaType = bVar;
            this.wireType = i2;
        }

        public b getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }
    }

    /* renamed from: com.google.c.bz$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37831a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.c.bz$a[] r0 = com.google.c.bz.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37831a = r0
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.c.bz$a r1 = com.google.c.bz.a.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.c.bz$a r1 = com.google.c.bz.a.FLOAT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.c.bz$a r1 = com.google.c.bz.a.INT64     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.c.bz$a r1 = com.google.c.bz.a.UINT64     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.c.bz$a r1 = com.google.c.bz.a.INT32     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.c.bz$a r1 = com.google.c.bz.a.FIXED64     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.c.bz$a r1 = com.google.c.bz.a.FIXED32     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.c.bz$a r1 = com.google.c.bz.a.BOOL     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.c.bz$a r1 = com.google.c.bz.a.BYTES     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.c.bz$a r1 = com.google.c.bz.a.UINT32     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.google.c.bz$a r1 = com.google.c.bz.a.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.google.c.bz$a r1 = com.google.c.bz.a.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.google.c.bz$a r1 = com.google.c.bz.a.SINT32     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.google.c.bz$a r1 = com.google.c.bz.a.SINT64     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.google.c.bz$a r1 = com.google.c.bz.a.STRING     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.google.c.bz$a r1 = com.google.c.bz.a.GROUP     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.google.c.bz$a r1 = com.google.c.bz.a.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = f37831a     // Catch:{ NoSuchFieldError -> 0x00da }
                com.google.c.bz$a r1 = com.google.c.bz.a.ENUM     // Catch:{ NoSuchFieldError -> 0x00da }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.bz.AnonymousClass1.<clinit>():void");
        }
    }
}
