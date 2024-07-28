package com.google.android.exoplayer2.e.f;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import com.google.android.exoplayer2.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31553a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31554b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f31555c;

    /* renamed from: d  reason: collision with root package name */
    public final long f31556d;

    /* renamed from: e  reason: collision with root package name */
    public final long f31557e;

    /* renamed from: f  reason: collision with root package name */
    public final d f31558f;

    /* renamed from: g  reason: collision with root package name */
    public final String f31559g;

    /* renamed from: h  reason: collision with root package name */
    public final String f31560h;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f31561i;
    private final HashMap<String, Integer> j;
    private final HashMap<String, Integer> k;
    private List<b> l;

    b(String str, String str2, long j2, long j3, d dVar, String[] strArr, String str3, String str4) {
        this.f31553a = str;
        this.f31554b = str2;
        this.f31560h = str4;
        this.f31558f = dVar;
        this.f31561i = strArr;
        this.f31555c = str2 != null;
        this.f31556d = j2;
        this.f31557e = j3;
        this.f31559g = (String) a.a(str3);
        this.j = new HashMap<>();
        this.k = new HashMap<>();
    }

    private boolean a(long j2) {
        if (this.f31556d == -9223372036854775807L && this.f31557e == -9223372036854775807L) {
            return true;
        }
        if (this.f31556d <= j2 && this.f31557e == -9223372036854775807L) {
            return true;
        }
        if (this.f31556d != -9223372036854775807L || j2 >= this.f31557e) {
            return this.f31556d <= j2 && j2 < this.f31557e;
        }
        return true;
    }

    public final void a(b bVar) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        this.l.add(bVar);
    }

    private b a(int i2) {
        List<b> list = this.l;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    private int b() {
        List<b> list = this.l;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final long[] a() {
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        a((TreeSet<Long>) treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i2] = ((Long) it2.next()).longValue();
            i2++;
        }
        return jArr;
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f31553a);
        boolean equals2 = "div".equals(this.f31553a);
        if (z || equals || (equals2 && this.f31560h != null)) {
            long j2 = this.f31556d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f31557e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.l.get(i2).a(treeSet, z || equals);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, String str, List<Pair<String, String>> list) {
        String str2;
        if (!"".equals(this.f31559g)) {
            str = this.f31559g;
        }
        if (!a(j2) || !"div".equals(this.f31553a) || (str2 = this.f31560h) == null) {
            for (int i2 = 0; i2 < b(); i2++) {
                a(i2).a(j2, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.j.clear();
        this.k.clear();
        if (!"metadata".equals(this.f31553a)) {
            if (!"".equals(this.f31559g)) {
                str = this.f31559g;
            }
            if (this.f31555c && z) {
                a(str, map).append(this.f31554b);
            } else if ("br".equals(this.f31553a) && z) {
                a(str, map).append(10);
            } else if (a(j2)) {
                for (Map.Entry next : map.entrySet()) {
                    this.j.put(next.getKey(), Integer.valueOf(((SpannableStringBuilder) next.getValue()).length()));
                }
                boolean equals = "p".equals(this.f31553a);
                for (int i2 = 0; i2 < b(); i2++) {
                    a(i2).a(j2, z || equals, str, map);
                }
                if (equals) {
                    SpannableStringBuilder a2 = a(str, map);
                    int length = a2.length() - 1;
                    while (length >= 0 && a2.charAt(length) == ' ') {
                        length--;
                    }
                    if (length >= 0 && a2.charAt(length) != 10) {
                        a2.append(10);
                    }
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.k.put(next2.getKey(), Integer.valueOf(((SpannableStringBuilder) next2.getValue()).length()));
                }
            }
        }
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, Map<String, d> map, Map<String, SpannableStringBuilder> map2) {
        if (a(j2)) {
            Iterator<Map.Entry<String, Integer>> it2 = this.k.entrySet().iterator();
            while (true) {
                int i2 = 0;
                if (it2.hasNext()) {
                    Map.Entry next = it2.next();
                    String str = (String) next.getKey();
                    int intValue = this.j.containsKey(str) ? this.j.get(str).intValue() : 0;
                    int intValue2 = ((Integer) next.getValue()).intValue();
                    if (intValue != intValue2) {
                        SpannableStringBuilder spannableStringBuilder = map2.get(str);
                        d dVar = this.f31558f;
                        String[] strArr = this.f31561i;
                        if (dVar == null && strArr == null) {
                            dVar = null;
                        } else if (dVar == null && strArr.length == 1) {
                            dVar = map.get(strArr[0]);
                        } else if (dVar == null && strArr.length > 1) {
                            dVar = new d();
                            for (String str2 : strArr) {
                                dVar.a(map.get(str2));
                            }
                        } else if (dVar != null && strArr != null && strArr.length == 1) {
                            dVar = dVar.a(map.get(strArr[0]));
                        } else if (!(dVar == null || strArr == null || strArr.length <= 1)) {
                            for (String str3 : strArr) {
                                dVar.a(map.get(str3));
                            }
                        }
                        if (dVar == null) {
                            continue;
                        } else {
                            if (dVar.a() != -1) {
                                spannableStringBuilder.setSpan(new StyleSpan(dVar.a()), intValue, intValue2, 33);
                            }
                            if (dVar.f31576f == 1) {
                                spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                            }
                            if (dVar.f31577g == 1) {
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                            }
                            if (dVar.f31573c) {
                                if (dVar.f31573c) {
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.f31572b), intValue, intValue2, 33);
                                } else {
                                    throw new IllegalStateException("Font color has not been defined.");
                                }
                            }
                            if (dVar.f31575e) {
                                if (dVar.f31575e) {
                                    spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.f31574d), intValue, intValue2, 33);
                                } else {
                                    throw new IllegalStateException("Background color has not been defined.");
                                }
                            }
                            if (dVar.f31571a != null) {
                                spannableStringBuilder.setSpan(new TypefaceSpan(dVar.f31571a), intValue, intValue2, 33);
                            }
                            if (dVar.n != null) {
                                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.n), intValue, intValue2, 33);
                            }
                            int i3 = dVar.j;
                            if (i3 == 1) {
                                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.k, true), intValue, intValue2, 33);
                            } else if (i3 == 2) {
                                spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.k), intValue, intValue2, 33);
                            } else if (i3 == 3) {
                                spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.k / 100.0f), intValue, intValue2, 33);
                            }
                        }
                    }
                } else {
                    while (i2 < b()) {
                        a(i2).a(j2, map, map2);
                        i2++;
                    }
                    return;
                }
            }
        }
    }

    static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        int i3;
        int i4 = 0;
        int length = spannableStringBuilder.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (spannableStringBuilder.charAt(i5) == ' ') {
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                    i7++;
                }
                int i8 = i7 - i6;
                if (i8 > 0) {
                    spannableStringBuilder.delete(i5, i5 + i8);
                    length -= i8;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i9 = 0;
        while (true) {
            i2 = length - 1;
            if (i9 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i9) == 10) {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    spannableStringBuilder.delete(i10, i9 + 2);
                    length--;
                }
            }
            i9++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
            spannableStringBuilder.delete(i2, length);
            length--;
        }
        while (true) {
            i3 = length - 1;
            if (i4 >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i11 = i4 + 1;
                if (spannableStringBuilder.charAt(i11) == 10) {
                    spannableStringBuilder.delete(i4, i11);
                    length--;
                }
            }
            i4++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == 10) {
            spannableStringBuilder.delete(i3, length);
        }
        return spannableStringBuilder;
    }
}
