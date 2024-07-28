package androidx.room;

import android.content.Context;
import androidx.room.j;
import androidx.sqlite.db.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.C0072c f4373a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f4374b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4375c;

    /* renamed from: d  reason: collision with root package name */
    public final j.d f4376d;

    /* renamed from: e  reason: collision with root package name */
    public final List<j.b> f4377e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4378f;

    /* renamed from: g  reason: collision with root package name */
    public final j.c f4379g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f4380h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f4381i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final File n;
    private final Set<Integer> o;

    public a(Context context, String str, c.C0072c cVar, j.d dVar, List<j.b> list, boolean z, j.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.f4373a = cVar;
        this.f4374b = context;
        this.f4375c = str;
        this.f4376d = dVar;
        this.f4377e = list;
        this.f4378f = z;
        this.f4379g = cVar2;
        this.f4380h = executor;
        this.f4381i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.o = set;
        this.m = str2;
        this.n = file;
    }

    public final boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.l) && this.k && ((set = this.o) == null || !set.contains(Integer.valueOf(i2)));
    }
}
