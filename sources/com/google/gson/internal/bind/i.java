package com.google.gson.internal.bind;

import com.business.merchant_payments.utility.MPConstants;
import com.google.gson.a.c;
import com.google.gson.internal.f;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class i {
    public static final w<String> A = new w<String>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((String) obj);
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }
    };
    public static final w<BigDecimal> B = new w<BigDecimal>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) (BigDecimal) obj);
        }

        private static BigDecimal a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };
    public static final w<BigInteger> C = new w<BigInteger>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) (BigInteger) obj);
        }

        private static BigInteger a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };
    public static final x D = a(String.class, A);
    public static final w<StringBuilder> E = new w<StringBuilder>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuilder sb = (StringBuilder) obj;
            jsonWriter.value(sb == null ? null : sb.toString());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final x F = a(StringBuilder.class, E);
    public static final w<StringBuffer> G = new w<StringBuffer>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuffer stringBuffer = (StringBuffer) obj;
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final x H = a(StringBuffer.class, G);
    public static final w<URL> I = new w<URL>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            URL url = (URL) obj;
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }
    };
    public static final x J = a(URL.class, I);
    public static final w<URI> K = new w<URI>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            URI uri = (URI) obj;
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }

        private static URI a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e2) {
                throw new m((Throwable) e2);
            }
        }
    };
    public static final x L = a(URI.class, K);
    public static final w<InetAddress> M = new w<InetAddress>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            InetAddress inetAddress = (InetAddress) obj;
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final x N = b(InetAddress.class, M);
    public static final w<UUID> O = new w<UUID>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            UUID uuid = (UUID) obj;
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final x P = a(UUID.class, O);
    public static final w<Currency> Q = new w<Currency>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value(((Currency) obj).getCurrencyCode());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.nextString());
        }
    }.nullSafe();
    public static final x R = a(Currency.class, Q);
    public static final x S = new TypeAdapters$26();
    public static final w<Calendar> T = new w<Calendar>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value((long) calendar.get(1));
            jsonWriter.name(MPConstants.PaymentSummaryRange.MONTH);
            jsonWriter.value((long) calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value((long) calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value((long) calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value((long) calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value((long) calendar.get(13));
            jsonWriter.endObject();
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i2 = nextInt;
                } else if (MPConstants.PaymentSummaryRange.MONTH.equals(nextName)) {
                    i3 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i5 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i6 = nextInt;
                } else if ("second".equals(nextName)) {
                    i7 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }
    };
    public static final x U = new TypeAdapters$34(Calendar.class, GregorianCalendar.class, T);
    public static final w<Locale> V = new w<Locale>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Locale locale = (Locale) obj;
            jsonWriter.value(locale == null ? null : locale.toString());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
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
    public static final x W = a(Locale.class, V);
    public static final w<l> X = new w<l>() {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public l read(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass23.f39582a[jsonReader.peek().ordinal()]) {
                case 1:
                    return new r((Number) new f(jsonReader.nextString()));
                case 2:
                    return new r(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new r(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return n.f39635a;
                case 5:
                    com.google.gson.i iVar = new com.google.gson.i();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        iVar.a(read(jsonReader));
                    }
                    jsonReader.endArray();
                    return iVar;
                case 6:
                    o oVar = new o();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        oVar.a(jsonReader.nextName(), read(jsonReader));
                    }
                    jsonReader.endObject();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, l lVar) throws IOException {
            if (lVar == null || (lVar instanceof n)) {
                jsonWriter.nullValue();
            } else if (lVar instanceof r) {
                r j = lVar.j();
                if (j.f39637a instanceof Number) {
                    jsonWriter.value(j.b());
                } else if (j.f39637a instanceof Boolean) {
                    jsonWriter.value(j.g());
                } else {
                    jsonWriter.value(j.c());
                }
            } else if (lVar instanceof com.google.gson.i) {
                jsonWriter.beginArray();
                Iterator<l> it2 = lVar.i().iterator();
                while (it2.hasNext()) {
                    write(jsonWriter, it2.next());
                }
                jsonWriter.endArray();
            } else if (lVar instanceof o) {
                jsonWriter.beginObject();
                for (Map.Entry next : lVar.h().f39636a.entrySet()) {
                    jsonWriter.name((String) next.getKey());
                    write(jsonWriter, (l) next.getValue());
                }
                jsonWriter.endObject();
            } else {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
        }
    };
    public static final x Y = b(l.class, X);
    public static final x Z = new TypeAdapters$30();

    /* renamed from: a  reason: collision with root package name */
    public static final w<Class> f39573a = new w<Class>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.nullSafe();

    /* renamed from: b  reason: collision with root package name */
    public static final x f39574b = a(Class.class, f39573a);

    /* renamed from: c  reason: collision with root package name */
    public static final w<BitSet> f39575c = new w<BitSet>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                jsonWriter.value(bitSet.get(i2) ? 1 : 0);
            }
            jsonWriter.endArray();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
            if (r7.nextInt() != 0) goto L_0x005b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0060 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.util.BitSet a(com.google.gson.stream.JsonReader r7) throws java.io.IOException {
            /*
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.beginArray()
                com.google.gson.stream.JsonToken r1 = r7.peek()
                r2 = 0
                r3 = 0
            L_0x000e:
                com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L_0x0067
                int[] r4 = com.google.gson.internal.bind.i.AnonymousClass23.f39582a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L_0x0055
                r6 = 2
                if (r4 == r6) goto L_0x0050
                r6 = 3
                if (r4 != r6) goto L_0x0040
                java.lang.String r1 = r7.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                goto L_0x005b
            L_0x002e:
                r5 = 0
                goto L_0x005b
            L_0x0030:
                com.google.gson.u r7 = new com.google.gson.u
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.String r1 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r0 = r1.concat(r0)
                r7.<init>((java.lang.String) r0)
                throw r7
            L_0x0040:
                com.google.gson.u r7 = new com.google.gson.u
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.String r1 = "Invalid bitset value type: "
                java.lang.String r0 = r1.concat(r0)
                r7.<init>((java.lang.String) r0)
                throw r7
            L_0x0050:
                boolean r5 = r7.nextBoolean()
                goto L_0x005b
            L_0x0055:
                int r1 = r7.nextInt()
                if (r1 == 0) goto L_0x002e
            L_0x005b:
                if (r5 == 0) goto L_0x0060
                r0.set(r3)
            L_0x0060:
                int r3 = r3 + 1
                com.google.gson.stream.JsonToken r1 = r7.peek()
                goto L_0x000e
            L_0x0067:
                r7.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.i.AnonymousClass12.a(com.google.gson.stream.JsonReader):java.util.BitSet");
        }
    }.nullSafe();

    /* renamed from: d  reason: collision with root package name */
    public static final x f39576d = a(BitSet.class, f39575c);

    /* renamed from: e  reason: collision with root package name */
    public static final w<Boolean> f39577e = new w<Boolean>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Boolean) obj);
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final w<Boolean> f39578f = new w<Boolean>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final x f39579g = a(Boolean.TYPE, Boolean.class, f39577e);

    /* renamed from: h  reason: collision with root package name */
    public static final w<Number> f39580h = new w<Number>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        private static Number a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final x f39581i = a(Byte.TYPE, Byte.class, f39580h);
    public static final w<Number> j = new w<Number>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        private static Number a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };
    public static final x k = a(Short.TYPE, Short.class, j);
    public static final w<Number> l = new w<Number>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        private static Number a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };
    public static final x m = a(Integer.TYPE, Integer.class, l);
    public static final w<AtomicInteger> n = new w<AtomicInteger>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((long) ((AtomicInteger) obj).get());
        }

        private static AtomicInteger a(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    }.nullSafe();
    public static final x o = a(AtomicInteger.class, n);
    public static final w<AtomicBoolean> p = new w<AtomicBoolean>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value(((AtomicBoolean) obj).get());
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }
    }.nullSafe();
    public static final x q = a(AtomicBoolean.class, p);
    public static final w<AtomicIntegerArray> r = new w<AtomicIntegerArray>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                jsonWriter.value((long) atomicIntegerArray.get(i2));
            }
            jsonWriter.endArray();
        }

        private static AtomicIntegerArray a(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e2) {
                    throw new u((Throwable) e2);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }
    }.nullSafe();
    public static final x s = a(AtomicIntegerArray.class, r);
    public static final w<Number> t = new w<Number>() {
        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        private static Number a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }
    };
    public static final w<Number> u = new w<Number>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final w<Number> v = new w<Number>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }
    };
    public static final w<Number> w = new w<Number>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value((Number) obj);
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            int i2 = AnonymousClass23.f39582a[peek.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new f(jsonReader.nextString());
            }
            if (i2 == 4) {
                jsonReader.nextNull();
                return null;
            }
            throw new u("Expecting number, got: ".concat(String.valueOf(peek)));
        }
    };
    public static final x x = a(Number.class, w);
    public static final w<Character> y = new w<Character>() {
        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Character ch = (Character) obj;
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new u("Expecting character, got: ".concat(String.valueOf(nextString)));
        }
    };
    public static final x z = a(Character.TYPE, Character.class, y);

    /* renamed from: com.google.gson.internal.bind.i$23  reason: invalid class name */
    static /* synthetic */ class AnonymousClass23 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f39582a = new int[JsonToken.values().length];

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
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39582a = r0
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f39582a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.i.AnonymousClass23.<clinit>():void");
        }
    }

    static final class a<T extends Enum<T>> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f39583a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f39584b = new HashMap();

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            jsonWriter.value(enumR == null ? null : this.f39584b.get(enumR));
        }

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (String put : cVar.b()) {
                            this.f39583a.put(put, enumR);
                        }
                    }
                    this.f39583a.put(name, enumR);
                    this.f39584b.put(enumR, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return (Enum) this.f39583a.get(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }
    }

    public static <TT> x a(com.google.gson.b.a<TT> aVar, w<TT> wVar) {
        return new TypeAdapters$31(aVar, wVar);
    }

    public static <TT> x a(Class<TT> cls, w<TT> wVar) {
        return new TypeAdapters$32(cls, wVar);
    }

    public static <TT> x a(Class<TT> cls, Class<TT> cls2, w<? super TT> wVar) {
        return new TypeAdapters$33(cls, cls2, wVar);
    }

    private static <T1> x b(Class<T1> cls, w<T1> wVar) {
        return new TypeAdapters$35(cls, wVar);
    }
}
