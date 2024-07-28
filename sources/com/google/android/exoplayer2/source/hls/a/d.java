package com.google.android.exoplayer2.source.hls.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final d f33094a = new d("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: b  reason: collision with root package name */
    public final List<Uri> f33095b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f33096c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f33097d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f33098e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f33099f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f33100g;

    /* renamed from: h  reason: collision with root package name */
    public final Format f33101h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Format> f33102i;
    public final Map<String, String> j;
    public final List<DrmInitData> k;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f33107a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f33108b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33109c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33110d;

        /* renamed from: e  reason: collision with root package name */
        public final String f33111e;

        /* renamed from: f  reason: collision with root package name */
        public final String f33112f;

        public b(Uri uri, Format format, String str, String str2, String str3, String str4) {
            this.f33107a = uri;
            this.f33108b = format;
            this.f33109c = str;
            this.f33110d = str2;
            this.f33111e = str3;
            this.f33112f = str4;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f33103a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f33104b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33105c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33106d;

        public a(Uri uri, Format format, String str, String str2) {
            this.f33103a = uri;
            this.f33104b = format;
            this.f33105c = str;
            this.f33106d = str2;
        }
    }

    public d(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, Format format, List<Format> list7, boolean z, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Uri uri = list2.get(i2).f33107a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        a(list6, arrayList);
        this.f33095b = Collections.unmodifiableList(arrayList);
        this.f33096c = Collections.unmodifiableList(list2);
        this.f33097d = Collections.unmodifiableList(list3);
        this.f33098e = Collections.unmodifiableList(list4);
        this.f33099f = Collections.unmodifiableList(list5);
        this.f33100g = Collections.unmodifiableList(list6);
        this.f33101h = format;
        this.f33102i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.j = Collections.unmodifiableMap(map);
        this.k = Collections.unmodifiableList(list8);
    }

    public static d a(String str) {
        return new d((String) null, Collections.emptyList(), Collections.singletonList(new b(Uri.parse(str), Format.a("0", (String) null, "application/x-mpegURL", (String) null, (String) null, -1, 0, 0, (String) null), (String) null, (String) null, (String) null, (String) null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, (List<Format>) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static void a(List<a> list, List<Uri> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f33103a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> a(List<T> list, int i2, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            T t = list.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list2.size()) {
                    break;
                }
                StreamKey streamKey = list2.get(i4);
                if (streamKey.f32766b == i2 && streamKey.f32767c == i3) {
                    arrayList.add(t);
                    break;
                }
                i4++;
            }
        }
        return arrayList;
    }

    public final /* synthetic */ Object a(List list) {
        return new d(this.n, this.o, a(this.f33096c, 0, list), Collections.emptyList(), a(this.f33098e, 1, list), a(this.f33099f, 2, list), Collections.emptyList(), this.f33101h, this.f33102i, this.p, this.j, this.k);
    }
}
