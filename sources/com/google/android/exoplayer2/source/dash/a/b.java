package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class b implements a<b> {

    /* renamed from: a  reason: collision with root package name */
    public final long f32905a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32906b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32907c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f32908d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32909e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32910f;

    /* renamed from: g  reason: collision with root package name */
    public final long f32911g;

    /* renamed from: h  reason: collision with root package name */
    public final long f32912h;

    /* renamed from: i  reason: collision with root package name */
    public final m f32913i;
    public final Uri j;
    public final g k;
    private final List<f> l;

    public b(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, g gVar, m mVar, Uri uri, List<f> list) {
        this.f32905a = j2;
        this.f32906b = j3;
        this.f32907c = j4;
        this.f32908d = z;
        this.f32909e = j5;
        this.f32910f = j6;
        this.f32911g = j7;
        this.f32912h = j8;
        this.k = gVar;
        this.f32913i = mVar;
        this.j = uri;
        this.l = list;
    }

    public final int a() {
        return this.l.size();
    }

    public final f a(int i2) {
        return this.l.get(i2);
    }

    private long c(int i2) {
        long j2;
        long j3;
        if (i2 == this.l.size() - 1) {
            j2 = this.f32906b;
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j3 = this.l.get(i2).f32934b;
        } else {
            j2 = this.l.get(i2 + 1).f32934b;
            j3 = this.l.get(i2).f32934b;
        }
        return j2 - j3;
    }

    public final long b(int i2) {
        return c.b(c(i2));
    }

    private static ArrayList<a> a(List<a> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i2 = poll.f32765a;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i3 = poll.f32766b;
            a aVar = list.get(i3);
            List<i> list2 = aVar.f32902c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f32767c));
                poll = linkedList.poll();
                if (!(poll.f32765a == i2 && poll.f32766b == i3)) {
                    arrayList.add(new a(aVar.f32900a, aVar.f32901b, arrayList2, aVar.f32903d, aVar.f32904e));
                }
                arrayList2.add(list2.get(poll.f32767c));
                poll = linkedList.poll();
                break;
            } while (poll.f32766b == i3);
            arrayList.add(new a(aVar.f32900a, aVar.f32901b, arrayList2, aVar.f32903d, aVar.f32904e));
        } while (poll.f32765a == i2);
        linkedList.addFirst(poll);
        return arrayList;
    }

    public final /* synthetic */ Object a(List list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey());
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        for (int i2 = 0; i2 < a(); i2++) {
            if (((StreamKey) linkedList.peek()).f32765a != i2) {
                long c2 = c(i2);
                if (c2 != -9223372036854775807L) {
                    j2 += c2;
                }
            } else {
                f a2 = a(i2);
                arrayList.add(new f(a2.f32933a, a2.f32934b - j2, a(a2.f32935c, linkedList), a2.f32936d));
            }
        }
        long j3 = this.f32906b;
        return new b(this.f32905a, j3 != -9223372036854775807L ? j3 - j2 : -9223372036854775807L, this.f32907c, this.f32908d, this.f32909e, this.f32910f, this.f32911g, this.f32912h, this.k, this.f32913i, this.j, arrayList);
    }
}
