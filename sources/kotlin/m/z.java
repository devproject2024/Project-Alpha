package kotlin.m;

import com.business.merchant_payments.utility.StringUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.j.b;
import kotlin.j.d;
import kotlin.j.e;
import kotlin.l.g;
import kotlin.o;

public class z extends y {
    public static final d c(CharSequence charSequence) {
        k.d(charSequence, "$this$indices");
        return new d(0, charSequence.length() - 1);
    }

    public static final int d(CharSequence charSequence) {
        k.d(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String b(String str, String str2, String str3) {
        k.d(str, "$this$substringBefore");
        k.d(str2, "delimiter");
        k.d(str3, "missingDelimiterValue");
        int a2 = p.a((CharSequence) str, str2, 0, false, 6);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(0, a2);
        k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String c(String str, String str2, String str3) {
        k.d(str, "$this$substringAfter");
        k.d(str2, "delimiter");
        k.d(str3, "missingDelimiterValue");
        int a2 = p.a((CharSequence) str, str2, 0, false, 6);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(a2 + str2.length(), str.length());
        k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String b(String str, String str2) {
        k.d(str, "$this$substringAfterLast");
        k.d(str2, "missingDelimiterValue");
        int a2 = p.a((CharSequence) str, '.', p.d(str));
        if (a2 == -1) {
            return str2;
        }
        String substring = str.substring(a2 + 1, str.length());
        k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String d(String str, String str2, String str3) {
        k.d(str, "$this$substringAfterLast");
        k.d(str2, "delimiter");
        k.d(str3, "missingDelimiterValue");
        int a2 = p.a((CharSequence) str, str2, p.d(str));
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(a2 + str2.length(), str.length());
        k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence a(CharSequence charSequence, int i2, int i3, CharSequence charSequence2) {
        k.d(charSequence, "$this$replaceRange");
        k.d(charSequence2, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            k.b(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            k.b(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    public static final CharSequence a(CharSequence charSequence, int i2, int i3) {
        k.d(charSequence, "$this$removeRange");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        } else if (i3 == i2) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
            sb.append(charSequence, 0, i2);
            k.b(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence, i3, charSequence.length());
            k.b(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    public static final String a(String str, CharSequence charSequence) {
        k.d(str, "$this$removePrefix");
        k.d(charSequence, "prefix");
        if (!p.a((CharSequence) str, charSequence)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        k.b(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String b(String str, CharSequence charSequence) {
        boolean z;
        k.d(str, "$this$removeSuffix");
        k.d(charSequence, "suffix");
        CharSequence charSequence2 = str;
        k.d(charSequence2, "$this$endsWith");
        k.d(charSequence, "suffix");
        if (charSequence2 instanceof String) {
            z = p.c((String) charSequence2, (String) charSequence, false);
        } else {
            z = p.a(charSequence2, charSequence2.length() - charSequence.length(), charSequence, 0, charSequence.length(), false);
        }
        if (!z) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean a(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        k.d(charSequence, "$this$regionMatchesImpl");
        k.d(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!a.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2) {
        k.d(charSequence, "$this$startsWith");
        k.d(charSequence2, "prefix");
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return p.b((String) charSequence, (String) charSequence2, false);
        }
        return p.a(charSequence, 0, charSequence2, 0, charSequence2.length(), false);
    }

    /* access modifiers changed from: private */
    public static final int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        kotlin.j.b bVar;
        if (!z2) {
            bVar = new d(e.b(i2, 0), e.c(i3, charSequence.length()));
        } else {
            int c2 = e.c(i2, p.d(charSequence));
            int b2 = e.b(i3, 0);
            b.a aVar = kotlin.j.b.f47938d;
            bVar = b.a.a(c2, b2, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i4 = bVar.f47939a;
            int i5 = bVar.f47940b;
            int i6 = bVar.f47941c;
            if (i6 < 0 ? i4 >= i5 : i4 <= i5) {
                while (true) {
                    if (!p.a(charSequence2, 0, charSequence, i4, charSequence2.length(), z)) {
                        if (i4 == i5) {
                            break;
                        }
                        i4 += i6;
                    } else {
                        return i4;
                    }
                }
            }
        } else {
            int i7 = bVar.f47939a;
            int i8 = bVar.f47940b;
            int i9 = bVar.f47941c;
            if (i9 < 0 ? i7 >= i8 : i7 <= i8) {
                while (true) {
                    if (!p.a((String) charSequence2, 0, (String) charSequence, i7, charSequence2.length(), z)) {
                        if (i7 == i8) {
                            break;
                        }
                        i7 += i9;
                    } else {
                        return i7;
                    }
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return p.a(charSequence, c2, i2, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i2, boolean z) {
        boolean z2;
        k.d(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        char[] cArr = {c2};
        k.d(charSequence, "$this$indexOfAny");
        k.d(cArr, "chars");
        if (z || !(charSequence instanceof String)) {
            int b2 = e.b(i2, 0);
            int d2 = p.d(charSequence);
            if (b2 > d2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(b2);
                int i3 = 0;
                while (true) {
                    if (i3 > 0) {
                        z2 = false;
                        break;
                    } else if (a.a(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return b2;
                }
                if (b2 == d2) {
                    return -1;
                }
                b2++;
            }
        } else {
            return ((String) charSequence).indexOf(f.a(cArr), i2);
        }
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return p.a(charSequence, str, i2, z);
    }

    public static final int a(CharSequence charSequence, String str, int i2, boolean z) {
        k.d(charSequence, "$this$indexOf");
        k.d(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i2, charSequence.length(), z, false);
        }
        return ((String) charSequence).indexOf(str, i2);
    }

    public static final int a(CharSequence charSequence, char c2, int i2) {
        boolean z;
        k.d(charSequence, "$this$lastIndexOf");
        boolean z2 = charSequence instanceof String;
        if (z2) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        char[] cArr = {c2};
        k.d(charSequence, "$this$lastIndexOfAny");
        k.d(cArr, "chars");
        if (z2) {
            return ((String) charSequence).lastIndexOf(f.a(cArr), i2);
        }
        for (int c3 = e.c(i2, p.d(charSequence)); c3 >= 0; c3--) {
            char charAt = charSequence.charAt(c3);
            int i3 = 0;
            while (true) {
                if (i3 > 0) {
                    z = false;
                    break;
                } else if (a.a(cArr[i3], charAt, false)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                return c3;
            }
        }
        return -1;
    }

    public static final int a(CharSequence charSequence, String str, int i2) {
        k.d(charSequence, "$this$lastIndexOf");
        k.d(str, "string");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, 0, false, true);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        k.d(charSequence, "$this$contains");
        k.d(charSequence2, "other");
        return charSequence2 instanceof String ? p.a(charSequence, (String) charSequence2, 0, z, 2) >= 0 : a(charSequence, charSequence2, 0, charSequence.length(), z, false) >= 0;
    }

    public static final boolean a(CharSequence charSequence, char c2, boolean z) {
        k.d(charSequence, "$this$contains");
        return p.a(charSequence, c2, 0, z, 2) >= 0;
    }

    static final class a extends l implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((CharSequence) obj, ((Number) obj2).intValue());
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x0124  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x013b A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.o<java.lang.Integer, java.lang.Integer> invoke(java.lang.CharSequence r14, int r15) {
            /*
                r13 = this;
                java.lang.String r0 = "$receiver"
                kotlin.g.b.k.d(r14, r0)
                java.util.List r0 = r13.$delimitersList
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r7 = r13.$ignoreCase
                r1 = 0
                r8 = 0
                if (r7 != 0) goto L_0x0083
                int r2 = r0.size()
                r3 = 1
                if (r2 != r3) goto L_0x0083
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.lang.String r2 = "$this$single"
                kotlin.g.b.k.d(r0, r2)
                boolean r4 = r0 instanceof java.util.List
                if (r4 == 0) goto L_0x0047
                java.util.List r0 = (java.util.List) r0
                kotlin.g.b.k.d(r0, r2)
                int r2 = r0.size()
                if (r2 == 0) goto L_0x003d
                if (r2 != r3) goto L_0x0033
                java.lang.Object r0 = r0.get(r1)
                goto L_0x005c
            L_0x0033:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.String r15 = "List has more than one element."
                r14.<init>(r15)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x003d:
                java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
                java.lang.String r15 = "List is empty."
                r14.<init>(r15)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x0047:
                java.util.Iterator r0 = r0.iterator()
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0079
                java.lang.Object r2 = r0.next()
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L_0x006f
                r0 = r2
            L_0x005c:
                java.lang.String r0 = (java.lang.String) r0
                r2 = 4
                int r14 = kotlin.m.p.a((java.lang.CharSequence) r14, (java.lang.String) r0, (int) r15, (boolean) r1, (int) r2)
                if (r14 < 0) goto L_0x0121
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                kotlin.o r14 = kotlin.t.a(r14, r0)
                goto L_0x0122
            L_0x006f:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.String r15 = "Collection has more than one element."
                r14.<init>(r15)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x0079:
                java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
                java.lang.String r15 = "Collection is empty."
                r14.<init>(r15)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x0083:
                int r15 = kotlin.j.e.b(r15, r1)
                kotlin.j.d r1 = new kotlin.j.d
                int r2 = r14.length()
                r1.<init>(r15, r2)
                kotlin.j.b r1 = (kotlin.j.b) r1
                boolean r15 = r14 instanceof java.lang.String
                if (r15 == 0) goto L_0x00da
                int r15 = r1.f47939a
                int r9 = r1.f47940b
                int r10 = r1.f47941c
                if (r10 < 0) goto L_0x00a1
                if (r15 > r9) goto L_0x0121
                goto L_0x00a3
            L_0x00a1:
                if (r15 < r9) goto L_0x0121
            L_0x00a3:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r11 = r1.iterator()
            L_0x00aa:
                boolean r1 = r11.hasNext()
                if (r1 == 0) goto L_0x00c8
                java.lang.Object r12 = r11.next()
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                r2 = 0
                r3 = r14
                java.lang.String r3 = (java.lang.String) r3
                int r5 = r1.length()
                r4 = r15
                r6 = r7
                boolean r1 = kotlin.m.p.a(r1, r2, r3, r4, r5, r6)
                if (r1 == 0) goto L_0x00aa
                goto L_0x00c9
            L_0x00c8:
                r12 = r8
            L_0x00c9:
                java.lang.String r12 = (java.lang.String) r12
                if (r12 == 0) goto L_0x00d6
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                kotlin.o r14 = kotlin.t.a(r14, r12)
                goto L_0x0122
            L_0x00d6:
                if (r15 == r9) goto L_0x0121
                int r15 = r15 + r10
                goto L_0x00a3
            L_0x00da:
                int r15 = r1.f47939a
                int r9 = r1.f47940b
                int r10 = r1.f47941c
                if (r10 < 0) goto L_0x00e5
                if (r15 > r9) goto L_0x0121
                goto L_0x00e7
            L_0x00e5:
                if (r15 < r9) goto L_0x0121
            L_0x00e7:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r11 = r1.iterator()
            L_0x00ee:
                boolean r1 = r11.hasNext()
                if (r1 == 0) goto L_0x010f
                java.lang.Object r12 = r11.next()
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r3 = 0
                int r5 = r1.length()
                r1 = r2
                r2 = r3
                r3 = r14
                r4 = r15
                r6 = r7
                boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (int) r2, (java.lang.CharSequence) r3, (int) r4, (int) r5, (boolean) r6)
                if (r1 == 0) goto L_0x00ee
                goto L_0x0110
            L_0x010f:
                r12 = r8
            L_0x0110:
                java.lang.String r12 = (java.lang.String) r12
                if (r12 == 0) goto L_0x011d
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                kotlin.o r14 = kotlin.t.a(r14, r12)
                goto L_0x0122
            L_0x011d:
                if (r15 == r9) goto L_0x0121
                int r15 = r15 + r10
                goto L_0x00e7
            L_0x0121:
                r14 = r8
            L_0x0122:
                if (r14 == 0) goto L_0x013b
                java.lang.Object r15 = r14.getFirst()
                java.lang.Object r14 = r14.getSecond()
                java.lang.String r14 = (java.lang.String) r14
                int r14 = r14.length()
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                kotlin.o r14 = kotlin.t.a(r15, r14)
                return r14
            L_0x013b:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.m.z.a.invoke(java.lang.CharSequence, int):kotlin.o");
        }
    }

    static final class b extends l implements kotlin.g.a.b<d, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        public final String invoke(d dVar) {
            k.d(dVar, "it");
            return p.a(this.$this_splitToSequence, dVar);
        }
    }

    public static /* synthetic */ kotlin.l.d a(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return p.a(charSequence, strArr, z);
    }

    public static final kotlin.l.d<String> a(CharSequence charSequence, String[] strArr, boolean z) {
        k.d(charSequence, "$this$splitToSequence");
        k.d(strArr, "delimiters");
        return g.a(b(charSequence, strArr, z), new b(charSequence));
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr) {
        k.d(charSequence, "$this$split");
        k.d(strArr, "delimiters");
        boolean z = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z = false;
            }
            if (!z) {
                return b(charSequence, str);
            }
        }
        Iterable<d> b2 = g.b(b(charSequence, strArr, false));
        Collection arrayList = new ArrayList(kotlin.a.k.a(b2));
        for (d a2 : b2) {
            arrayList.add(p.a(charSequence, a2));
        }
        return (List) arrayList;
    }

    public static final List<String> b(CharSequence charSequence, String str) {
        int a2 = p.a(charSequence, str, 0, false);
        if (a2 == -1) {
            return kotlin.a.k.a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i2 = a2;
        int i3 = 0;
        do {
            arrayList.add(charSequence.subSequence(i3, i2).toString());
            i3 = str.length() + i2;
            i2 = p.a(charSequence, str, i3, false);
        } while (i2 != -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    public static final kotlin.l.d<String> f(CharSequence charSequence) {
        k.d(charSequence, "$this$lineSequence");
        return p.a(charSequence, new String[]{"\r\n", StringUtility.NEW_LINE, "\r"}, false, 6);
    }

    public static final List<String> g(CharSequence charSequence) {
        k.d(charSequence, "$this$lines");
        return g.a(p.f(charSequence));
    }

    public static final String a(String str, char... cArr) {
        k.d(str, "$this$trim");
        k.d(cArr, "chars");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean a2 = f.a(cArr, charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!a2) {
                    break;
                }
                length--;
            } else if (!a2) {
                z = true;
            } else {
                i2++;
            }
        }
        return charSequence.subSequence(i2, length + 1).toString();
    }

    public static final CharSequence b(CharSequence charSequence) {
        k.d(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean a2 = a.a(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!a2) {
                    break;
                }
                length--;
            } else if (!a2) {
                z = true;
            } else {
                i2++;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final String a(CharSequence charSequence, d dVar) {
        k.d(charSequence, "$this$substring");
        k.d(dVar, "range");
        return charSequence.subSequence(dVar.f47939a, dVar.f47940b + 1).toString();
    }

    private static /* synthetic */ kotlin.l.d b(CharSequence charSequence, String[] strArr, boolean z) {
        return new e(charSequence, new a(f.a(strArr), z));
    }
}
