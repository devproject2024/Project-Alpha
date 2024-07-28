package com.google.zxing.client.a;

import com.business.merchant_payments.utility.StringUtility;
import com.google.zxing.r;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40003a = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40004b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f40005c = Pattern.compile("\r\n[ \t]");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f40006d = Pattern.compile("\\\\[nN]");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f40007e = Pattern.compile("\\\\([,;\\\\])");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f40008f = Pattern.compile("=");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f40009g = Pattern.compile(";");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f40010h = Pattern.compile("(?<!\\\\);+");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f40011i = Pattern.compile(AppConstants.COMMA);
    private static final Pattern j = Pattern.compile("[;,]");

    public final /* synthetic */ q a(r rVar) {
        return d(rVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.client.a.d d(com.google.zxing.r r24) {
        /*
            java.lang.String r0 = b((com.google.zxing.r) r24)
            java.util.regex.Pattern r1 = f40003a
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r2 = r1.find()
            r3 = 0
            if (r2 == 0) goto L_0x0150
            int r1 = r1.start()
            if (r1 == 0) goto L_0x0019
            goto L_0x0150
        L_0x0019:
            r1 = 1
            r2 = 0
            java.lang.String r4 = "FN"
            java.util.List r4 = a(r4, r0, r1, r2)
            r5 = 2
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = "N"
            java.util.List r4 = a(r4, r0, r1, r2)
            if (r4 == 0) goto L_0x0086
            java.util.Iterator r6 = r4.iterator()
        L_0x0030:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0086
            java.lang.Object r7 = r6.next()
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r7.get(r2)
            java.lang.String r8 = (java.lang.String) r8
            r9 = 5
            java.lang.String[] r9 = new java.lang.String[r9]
            r10 = 0
            r11 = 0
        L_0x0047:
            r12 = 4
            if (r10 >= r12) goto L_0x005d
            r13 = 59
            int r13 = r8.indexOf(r13, r11)
            if (r13 < 0) goto L_0x005d
            java.lang.String r11 = r8.substring(r11, r13)
            r9[r10] = r11
            int r10 = r10 + 1
            int r11 = r13 + 1
            goto L_0x0047
        L_0x005d:
            java.lang.String r8 = r8.substring(r11)
            r9[r10] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r10 = 100
            r8.<init>(r10)
            r10 = 3
            a((java.lang.String[]) r9, (int) r10, (java.lang.StringBuilder) r8)
            a((java.lang.String[]) r9, (int) r1, (java.lang.StringBuilder) r8)
            a((java.lang.String[]) r9, (int) r5, (java.lang.StringBuilder) r8)
            a((java.lang.String[]) r9, (int) r2, (java.lang.StringBuilder) r8)
            a((java.lang.String[]) r9, (int) r12, (java.lang.StringBuilder) r8)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.trim()
            r7.set(r2, r8)
            goto L_0x0030
        L_0x0086:
            java.lang.String r6 = "NICKNAME"
            java.util.List r6 = b(r6, r0, r1, r2)
            if (r6 != 0) goto L_0x0090
            r9 = r3
            goto L_0x009d
        L_0x0090:
            java.util.regex.Pattern r7 = f40011i
            java.lang.Object r6 = r6.get(r2)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String[] r6 = r7.split(r6)
            r9 = r6
        L_0x009d:
            java.lang.String r6 = "TEL"
            java.util.List r6 = a(r6, r0, r1, r2)
            java.lang.String r7 = "EMAIL"
            java.util.List r14 = a(r7, r0, r1, r2)
            java.lang.String r7 = "NOTE"
            java.util.List r16 = b(r7, r0, r2, r2)
            java.lang.String r7 = "ADR"
            java.util.List r18 = a(r7, r0, r1, r1)
            java.lang.String r7 = "ORG"
            java.util.List r19 = b(r7, r0, r1, r1)
            java.lang.String r7 = "BDAY"
            java.util.List r7 = b(r7, r0, r1, r2)
            if (r7 == 0) goto L_0x00e0
            java.lang.Object r8 = r7.get(r2)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00da
            java.util.regex.Pattern r10 = f40004b
            java.util.regex.Matcher r8 = r10.matcher(r8)
            boolean r8 = r8.matches()
            if (r8 == 0) goto L_0x00d8
            goto L_0x00da
        L_0x00d8:
            r8 = 0
            goto L_0x00db
        L_0x00da:
            r8 = 1
        L_0x00db:
            if (r8 != 0) goto L_0x00e0
            r20 = r3
            goto L_0x00e2
        L_0x00e0:
            r20 = r7
        L_0x00e2:
            java.lang.String r7 = "TITLE"
            java.util.List r21 = b(r7, r0, r1, r2)
            java.lang.String r7 = "URL"
            java.util.List r22 = a(r7, r0, r1, r2)
            java.lang.String r7 = "IMPP"
            java.util.List r15 = b(r7, r0, r1, r2)
            java.lang.String r7 = "GEO"
            java.util.List r0 = b(r7, r0, r1, r2)
            if (r0 != 0) goto L_0x00fe
            r0 = r3
            goto L_0x010a
        L_0x00fe:
            java.util.regex.Pattern r1 = j
            java.lang.Object r0 = r0.get(r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String[] r0 = r1.split(r0)
        L_0x010a:
            if (r0 == 0) goto L_0x0112
            int r1 = r0.length
            if (r1 == r5) goto L_0x0112
            r23 = r3
            goto L_0x0114
        L_0x0112:
            r23 = r0
        L_0x0114:
            com.google.zxing.client.a.d r0 = new com.google.zxing.client.a.d
            r7 = r0
            java.lang.String[] r8 = a((java.util.Collection<java.util.List<java.lang.String>>) r4)
            r10 = 0
            java.lang.String[] r11 = a((java.util.Collection<java.util.List<java.lang.String>>) r6)
            java.lang.String[] r12 = b(r6)
            java.lang.String[] r13 = a((java.util.Collection<java.util.List<java.lang.String>>) r14)
            java.lang.String[] r14 = b(r14)
            java.lang.String r15 = a((java.util.List<java.lang.String>) r15)
            java.lang.String r16 = a((java.util.List<java.lang.String>) r16)
            java.lang.String[] r17 = a((java.util.Collection<java.util.List<java.lang.String>>) r18)
            java.lang.String[] r18 = b(r18)
            java.lang.String r19 = a((java.util.List<java.lang.String>) r19)
            java.lang.String r20 = a((java.util.List<java.lang.String>) r20)
            java.lang.String r21 = a((java.util.List<java.lang.String>) r21)
            java.lang.String[] r22 = a((java.util.Collection<java.util.List<java.lang.String>>) r22)
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        L_0x0150:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.a.af.d(com.google.zxing.r):com.google.zxing.client.a.d");
    }

    static List<List<String>> a(CharSequence charSequence, String str, boolean z, boolean z2) {
        String str2;
        String str3;
        boolean z3;
        ArrayList arrayList;
        int indexOf;
        String str4;
        String str5 = str;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList2 = null;
        while (i3 < length) {
            int i4 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str5);
            if (i3 > 0) {
                i3--;
            }
            if (!matcher.find(i3)) {
                break;
            }
            int end = matcher.end(i2);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = f40009g.split(group);
                int length2 = split.length;
                int i5 = 0;
                arrayList = null;
                z3 = false;
                str3 = null;
                str2 = null;
                while (i5 < length2) {
                    String str6 = split[i5];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str6);
                    String[] split2 = f40008f.split(str6, i4);
                    if (split2.length > 1) {
                        String str7 = split2[0];
                        String str8 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str7) && "QUOTED-PRINTABLE".equalsIgnoreCase(str8)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str7)) {
                            str3 = str8;
                        } else if ("VALUE".equalsIgnoreCase(str7)) {
                            str2 = str8;
                        }
                    }
                    i5++;
                    i4 = 2;
                }
            } else {
                arrayList = null;
                z3 = false;
                str3 = null;
                str2 = null;
            }
            int i6 = end;
            while (true) {
                indexOf = str5.indexOf(10, i6);
                if (indexOf < 0) {
                    break;
                }
                if (indexOf < str.length() - 1) {
                    int i7 = indexOf + 1;
                    if (str5.charAt(i7) == ' ' || str5.charAt(i7) == 9) {
                        i6 = indexOf + 2;
                    }
                }
                if (!z3) {
                    break;
                }
                if (indexOf <= 0 || str5.charAt(indexOf - 1) != '=') {
                    if (indexOf >= 2) {
                        if (str5.charAt(indexOf - 2) != '=') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6 = indexOf + 1;
            }
            if (indexOf < 0) {
                i3 = length;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str5.charAt(indexOf - 1) == 13) {
                        indexOf--;
                    }
                    String substring = str5.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (z3) {
                        str4 = a(substring, str3);
                        if (z2) {
                            str4 = f40010h.matcher(str4).replaceAll(StringUtility.NEW_LINE).trim();
                        }
                    } else {
                        if (z2) {
                            substring = f40010h.matcher(substring).replaceAll(StringUtility.NEW_LINE).trim();
                        }
                        str4 = f40007e.matcher(f40006d.matcher(f40005c.matcher(substring).replaceAll("")).replaceAll(StringUtility.NEW_LINE)).replaceAll("$1");
                    }
                    if ("uri".equals(str2)) {
                        try {
                            str4 = URI.create(str4).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(str4);
                        arrayList2.add(arrayList3);
                    } else {
                        arrayList.add(0, str4);
                        arrayList2.add(arrayList);
                        i3 = indexOf + 1;
                    }
                }
                i3 = indexOf + 1;
            }
            i2 = 0;
        }
        return arrayList2;
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (!(i2 >= length - 2 || (charAt = charSequence.charAt(i2 + 1)) == 13 || charAt == 10)) {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int a2 = a(charAt);
                    int a3 = a(charAt3);
                    if (a2 >= 0 && a3 >= 0) {
                        byteArrayOutputStream.write((a2 << 4) + a3);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    static List<String> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> a2 = a(charSequence, str, z, z2);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = (String) list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] b(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            String str2 = (String) next.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= next.size()) {
                        str = null;
                        break;
                    }
                    String str3 = (String) next.get(i2);
                    int indexOf = str3.indexOf(61);
                    if (indexOf < 0) {
                        str = str3;
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str3.substring(0, indexOf))) {
                        str = str3.substring(indexOf + 1);
                        break;
                    } else {
                        i2++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] != null && !strArr[i2].isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(strArr[i2]);
        }
    }
}
