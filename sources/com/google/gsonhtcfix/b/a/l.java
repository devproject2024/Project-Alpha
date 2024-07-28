package com.google.gsonhtcfix.b.a;

import com.business.merchant_payments.utility.MPConstants;
import com.google.gsonhtcfix.d.b;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.i;
import com.google.gsonhtcfix.m;
import com.google.gsonhtcfix.n;
import com.google.gsonhtcfix.o;
import com.google.gsonhtcfix.s;
import com.google.gsonhtcfix.v;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

public final class l {
    public static final y<StringBuffer> A = new y<StringBuffer>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            StringBuffer stringBuffer = (StringBuffer) obj;
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuffer(aVar.i());
            }
            aVar.k();
            return null;
        }
    };
    public static final z B = a(StringBuffer.class, A);
    public static final y<URL> C = new y<URL>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            URL url = (URL) obj;
            cVar.b(url == null ? null : url.toExternalForm());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            String i2 = aVar.i();
            if ("null".equals(i2)) {
                return null;
            }
            return new URL(i2);
        }
    };
    public static final z D = a(URL.class, C);
    public static final y<URI> E = new y<URI>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            URI uri = (URI) obj;
            cVar.b(uri == null ? null : uri.toASCIIString());
        }

        private static URI b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                String i2 = aVar.i();
                if ("null".equals(i2)) {
                    return null;
                }
                return new URI(i2);
            } catch (URISyntaxException e2) {
                throw new m((Throwable) e2);
            }
        }
    };
    public static final z F = a(URI.class, E);
    public static final y<InetAddress> G = new y<InetAddress>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            InetAddress inetAddress = (InetAddress) obj;
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return InetAddress.getByName(aVar.i());
            }
            aVar.k();
            return null;
        }
    };
    public static final z H = b(InetAddress.class, G);
    public static final y<UUID> I = new y<UUID>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            UUID uuid = (UUID) obj;
            cVar.b(uuid == null ? null : uuid.toString());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return UUID.fromString(aVar.i());
            }
            aVar.k();
            return null;
        }
    };
    public static final z J = a(UUID.class, I);
    public static final z K = new z() {
        public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            final y<Date> a2 = fVar.a(Date.class);
            return new y<Timestamp>() {
                public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                    a2.a(cVar, (Timestamp) obj);
                }

                public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
                    Date date = (Date) a2.a(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final y<Calendar> L = new y<Calendar>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                cVar.e();
                return;
            }
            cVar.c();
            cVar.a("year");
            cVar.a((long) calendar.get(1));
            cVar.a(MPConstants.PaymentSummaryRange.MONTH);
            cVar.a((long) calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a((long) calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a((long) calendar.get(11));
            cVar.a("minute");
            cVar.a((long) calendar.get(12));
            cVar.a("second");
            cVar.a((long) calendar.get(13));
            cVar.d();
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.f() != b.END_OBJECT) {
                String h2 = aVar.h();
                int n = aVar.n();
                if ("year".equals(h2)) {
                    i2 = n;
                } else if (MPConstants.PaymentSummaryRange.MONTH.equals(h2)) {
                    i3 = n;
                } else if ("dayOfMonth".equals(h2)) {
                    i4 = n;
                } else if ("hourOfDay".equals(h2)) {
                    i5 = n;
                } else if ("minute".equals(h2)) {
                    i6 = n;
                } else if ("second".equals(h2)) {
                    i7 = n;
                }
            }
            aVar.d();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }
    };
    public static final z M;
    public static final y<Locale> N = new y<Locale>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Locale locale = (Locale) obj;
            cVar.b(locale == null ? null : locale.toString());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            String str = null;
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.i(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            if (nextToken2 == null && str == null) {
                return new Locale(nextToken);
            }
            if (str == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, str);
        }
    };
    public static final z O = a(Locale.class, N);
    public static final y<com.google.gsonhtcfix.l> P = new y<com.google.gsonhtcfix.l>() {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public com.google.gsonhtcfix.l a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            switch (AnonymousClass25.f39712a[aVar.f().ordinal()]) {
                case 1:
                    return new s((Number) new com.google.gsonhtcfix.b.f(aVar.i()));
                case 2:
                    return new s(Boolean.valueOf(aVar.j()));
                case 3:
                    return new s(aVar.i());
                case 4:
                    aVar.k();
                    return n.f39822a;
                case 5:
                    i iVar = new i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(a(aVar));
                    }
                    aVar.b();
                    return iVar;
                case 6:
                    o oVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        oVar.a(aVar.h(), a(aVar));
                    }
                    aVar.d();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* access modifiers changed from: private */
        public void a(c cVar, com.google.gsonhtcfix.l lVar) throws IOException {
            if (lVar == null || (lVar instanceof n)) {
                cVar.e();
            } else if (lVar instanceof s) {
                s h2 = lVar.h();
                if (h2.f39825a instanceof Number) {
                    cVar.a(h2.a());
                } else if (h2.f39825a instanceof Boolean) {
                    cVar.a(h2.f());
                } else {
                    cVar.b(h2.b());
                }
            } else {
                boolean z = lVar instanceof i;
                if (z) {
                    cVar.a();
                    if (z) {
                        Iterator<com.google.gsonhtcfix.l> it2 = ((i) lVar).iterator();
                        while (it2.hasNext()) {
                            a(cVar, it2.next());
                        }
                        cVar.b();
                        return;
                    }
                    throw new IllegalStateException("This is not a JSON Array.");
                } else if (lVar instanceof o) {
                    cVar.c();
                    for (Map.Entry next : lVar.g().f39823a.entrySet()) {
                        cVar.a((String) next.getKey());
                        a(cVar, (com.google.gsonhtcfix.l) next.getValue());
                    }
                    cVar.d();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                }
            }
        }
    };
    public static final z Q = b(com.google.gsonhtcfix.l.class, P);
    public static final z R = new z() {
        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.gsonhtcfix.c.a<T>, com.google.gsonhtcfix.c.a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> com.google.gsonhtcfix.y<T> a(com.google.gsonhtcfix.f r1, com.google.gsonhtcfix.c.a<T> r2) {
            /*
                r0 = this;
                java.lang.Class r1 = r2.getRawType()
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                boolean r2 = r2.isAssignableFrom(r1)
                if (r2 == 0) goto L_0x0021
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                if (r1 != r2) goto L_0x0011
                goto L_0x0021
            L_0x0011:
                boolean r2 = r1.isEnum()
                if (r2 != 0) goto L_0x001b
                java.lang.Class r1 = r1.getSuperclass()
            L_0x001b:
                com.google.gsonhtcfix.b.a.l$a r2 = new com.google.gsonhtcfix.b.a.l$a
                r2.<init>(r1)
                return r2
            L_0x0021:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.b.a.l.AnonymousClass19.a(com.google.gsonhtcfix.f, com.google.gsonhtcfix.c.a):com.google.gsonhtcfix.y");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final y<Class> f39691a = new y<Class>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Class cls = (Class) obj;
            if (cls == null) {
                cVar.e();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final z f39692b = a(Class.class, f39691a);

    /* renamed from: c  reason: collision with root package name */
    public static final y<BitSet> f39693c = new y<BitSet>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            if (bitSet == null) {
                cVar.e();
                return;
            }
            cVar.a();
            for (int i2 = 0; i2 < bitSet.length(); i2++) {
                cVar.a(bitSet.get(i2) ? 1 : 0);
            }
            cVar.b();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
            if (r7.n() != 0) goto L_0x0068;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.util.BitSet b(com.google.gsonhtcfix.d.a r7) throws java.io.IOException {
            /*
                com.google.gsonhtcfix.d.b r0 = r7.f()
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.NULL
                if (r0 != r1) goto L_0x000d
                r7.k()
                r7 = 0
                return r7
            L_0x000d:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.a()
                com.google.gsonhtcfix.d.b r1 = r7.f()
                r2 = 0
                r3 = 0
            L_0x001b:
                com.google.gsonhtcfix.d.b r4 = com.google.gsonhtcfix.d.b.END_ARRAY
                if (r1 == r4) goto L_0x0074
                int[] r4 = com.google.gsonhtcfix.b.a.l.AnonymousClass25.f39712a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L_0x0062
                r6 = 2
                if (r4 == r6) goto L_0x005d
                r6 = 3
                if (r4 != r6) goto L_0x004d
                java.lang.String r1 = r7.i()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x003d }
                if (r1 == 0) goto L_0x003b
                goto L_0x0068
            L_0x003b:
                r5 = 0
                goto L_0x0068
            L_0x003d:
                com.google.gsonhtcfix.v r7 = new com.google.gsonhtcfix.v
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.String r1 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r0 = r1.concat(r0)
                r7.<init>((java.lang.String) r0)
                throw r7
            L_0x004d:
                com.google.gsonhtcfix.v r7 = new com.google.gsonhtcfix.v
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.String r1 = "Invalid bitset value type: "
                java.lang.String r0 = r1.concat(r0)
                r7.<init>((java.lang.String) r0)
                throw r7
            L_0x005d:
                boolean r5 = r7.j()
                goto L_0x0068
            L_0x0062:
                int r1 = r7.n()
                if (r1 == 0) goto L_0x003b
            L_0x0068:
                if (r5 == 0) goto L_0x006d
                r0.set(r3)
            L_0x006d:
                int r3 = r3 + 1
                com.google.gsonhtcfix.d.b r1 = r7.f()
                goto L_0x001b
            L_0x0074:
                r7.b()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.b.a.l.AnonymousClass12.b(com.google.gsonhtcfix.d.a):java.util.BitSet");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final z f39694d = a(BitSet.class, f39693c);

    /* renamed from: e  reason: collision with root package name */
    public static final y<Boolean> f39695e = new y<Boolean>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                cVar.e();
            } else {
                cVar.a(bool.booleanValue());
            }
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            } else if (aVar.f() == b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.i()));
            } else {
                return Boolean.valueOf(aVar.j());
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final y<Boolean> f39696f = new y<Boolean>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            cVar.b(bool == null ? "null" : bool.toString());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.i());
            }
            aVar.k();
            return null;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final z f39697g = a(Boolean.TYPE, Boolean.class, f39695e);

    /* renamed from: h  reason: collision with root package name */
    public static final y<Number> f39698h = new y<Number>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        private static Number b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.n());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final z f39699i = a(Byte.TYPE, Byte.class, f39698h);
    public static final y<Number> j = new y<Number>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        private static Number b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.n());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };
    public static final z k = a(Short.TYPE, Short.class, j);
    public static final y<Number> l = new y<Number>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        private static Number b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Integer.valueOf(aVar.n());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };
    public static final z m = a(Integer.TYPE, Integer.class, l);
    public static final y<Number> n = new y<Number>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        private static Number b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Long.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };
    public static final y<Number> o = new y<Number>() {
        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.l());
            }
            aVar.k();
            return null;
        }
    };
    public static final y<Number> p = new y<Number>() {
        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.l());
            }
            aVar.k();
            return null;
        }
    };
    public static final y<Number> q = new y<Number>() {
        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            b f2 = aVar.f();
            int i2 = AnonymousClass25.f39712a[f2.ordinal()];
            if (i2 == 1) {
                return new com.google.gsonhtcfix.b.f(aVar.i());
            }
            if (i2 == 4) {
                aVar.k();
                return null;
            }
            throw new v("Expecting number, got: ".concat(String.valueOf(f2)));
        }
    };
    public static final z r = a(Number.class, q);
    public static final y<Character> s = new y<Character>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Character ch = (Character) obj;
            cVar.b(ch == null ? null : String.valueOf(ch));
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            String i2 = aVar.i();
            if (i2.length() == 1) {
                return Character.valueOf(i2.charAt(0));
            }
            throw new v("Expecting character, got: ".concat(String.valueOf(i2)));
        }
    };
    public static final z t = a(Character.TYPE, Character.class, s);
    public static final y<String> u = new y<String>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.b((String) obj);
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            b f2 = aVar.f();
            if (f2 == b.NULL) {
                aVar.k();
                return null;
            } else if (f2 == b.BOOLEAN) {
                return Boolean.toString(aVar.j());
            } else {
                return aVar.i();
            }
        }
    };
    public static final y<BigDecimal> v = new y<BigDecimal>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigDecimal) obj);
        }

        private static BigDecimal b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigDecimal(aVar.i());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };
    public static final y<BigInteger> w = new y<BigInteger>() {
        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigInteger) obj);
        }

        private static BigInteger b(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigInteger(aVar.i());
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }
    };
    public static final z x = a(String.class, u);
    public static final y<StringBuilder> y = new y<StringBuilder>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            StringBuilder sb = (StringBuilder) obj;
            cVar.b(sb == null ? null : sb.toString());
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuilder(aVar.i());
            }
            aVar.k();
            return null;
        }
    };
    public static final z z = a(StringBuilder.class, y);

    static {
        final Class<Calendar> cls = Calendar.class;
        final Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        final y<Calendar> yVar = L;
        M = new z() {
            public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return yVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + yVar + "]";
            }
        };
    }

    /* renamed from: com.google.gsonhtcfix.b.a.l$25  reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f39712a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.gsonhtcfix.d.b[] r0 = com.google.gsonhtcfix.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39712a = r0
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.NAME     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f39712a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.gsonhtcfix.d.b r1 = com.google.gsonhtcfix.d.b.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.b.a.l.AnonymousClass25.<clinit>():void");
        }
    }

    static final class a<T extends Enum<T>> extends y<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f39713a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f39714b = new HashMap();

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            cVar.b(enumR == null ? null : this.f39714b.get(enumR));
        }

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    com.google.gsonhtcfix.a.b bVar = (com.google.gsonhtcfix.a.b) cls.getField(name).getAnnotation(com.google.gsonhtcfix.a.b.class);
                    name = bVar != null ? bVar.a() : name;
                    this.f39713a.put(name, enumR);
                    this.f39714b.put(enumR, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return (Enum) this.f39713a.get(aVar.i());
            }
            aVar.k();
            return null;
        }
    }

    public static <TT> z a(final Class<TT> cls, final y<TT> yVar) {
        return new z() {
            public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return yVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + yVar + "]";
            }
        };
    }

    public static <TT> z a(final Class<TT> cls, final Class<TT> cls2, final y<? super TT> yVar) {
        return new z() {
            public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return yVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + yVar + "]";
            }
        };
    }

    private static <TT> z b(final Class<TT> cls, final y<TT> yVar) {
        return new z() {
            public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
                if (cls.isAssignableFrom(aVar.getRawType())) {
                    return yVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + yVar + "]";
            }
        };
    }
}
