package com.google.android.exoplayer2.source.dash.a;

import java.util.Locale;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f32971a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f32972b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f32973c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32974d;

    public static l a(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new l(strArr, iArr, strArr2, a(str, strArr, iArr, strArr2));
    }

    private l(String[] strArr, int[] iArr, String[] strArr2, int i2) {
        this.f32971a = strArr;
        this.f32972b = iArr;
        this.f32973c = strArr2;
        this.f32974d = i2;
    }

    public final String a(String str, long j, int i2, long j2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.f32974d;
            if (i3 < i4) {
                sb.append(this.f32971a[i3]);
                int[] iArr = this.f32972b;
                if (iArr[i3] == 1) {
                    sb.append(str);
                } else if (iArr[i3] == 2) {
                    sb.append(String.format(Locale.US, this.f32973c[i3], new Object[]{Long.valueOf(j)}));
                } else if (iArr[i3] == 3) {
                    sb.append(String.format(Locale.US, this.f32973c[i3], new Object[]{Integer.valueOf(i2)}));
                } else if (iArr[i3] == 4) {
                    sb.append(String.format(Locale.US, this.f32973c[i3], new Object[]{Long.valueOf(j2)}));
                }
                i3++;
            } else {
                sb.append(this.f32971a[i4]);
                return sb.toString();
            }
        }
    }

    private static int a(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            char c2 = 65535;
            if (indexOf == -1) {
                strArr[i3] = strArr[i3] + str.substring(i2);
                i2 = str.length();
            } else if (indexOf != i2) {
                strArr[i3] = strArr[i3] + str.substring(i2, indexOf);
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                strArr[i3] = strArr[i3] + "$";
                i2 += 2;
            } else {
                int i4 = i2 + 1;
                int indexOf2 = str.indexOf("$", i4);
                String substring = str.substring(i4, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i3] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    int hashCode = substring.hashCode();
                    if (hashCode != -1950496919) {
                        if (hashCode != 2606829) {
                            if (hashCode == 38199441 && substring.equals("Bandwidth")) {
                                c2 = 1;
                            }
                        } else if (substring.equals("Time")) {
                            c2 = 2;
                        }
                    } else if (substring.equals("Number")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        iArr[i3] = 2;
                    } else if (c2 == 1) {
                        iArr[i3] = 3;
                    } else if (c2 == 2) {
                        iArr[i3] = 4;
                    } else {
                        throw new IllegalArgumentException("Invalid template: ".concat(String.valueOf(str)));
                    }
                    strArr2[i3] = str2;
                }
                i3++;
                strArr[i3] = "";
                i2 = indexOf2 + 1;
            }
        }
        return i3;
    }
}
