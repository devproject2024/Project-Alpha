package androidx.palette.a;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.palette.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final Comparator<C0066a> f3966g = new Comparator<C0066a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C0066a) obj2).a() - ((C0066a) obj).a();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f3967a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f3968b;

    /* renamed from: c  reason: collision with root package name */
    final List<b.d> f3969c;

    /* renamed from: d  reason: collision with root package name */
    final TimingLogger f3970d = null;

    /* renamed from: e  reason: collision with root package name */
    final b.C0067b[] f3971e;

    /* renamed from: f  reason: collision with root package name */
    private final float[] f3972f = new float[3];

    static int a(int i2) {
        return (i2 >> 10) & 31;
    }

    static int b(int i2) {
        return (i2 >> 5) & 31;
    }

    private static int b(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    static int c(int i2) {
        return i2 & 31;
    }

    a(int[] iArr, int i2, b.C0067b[] bVarArr) {
        this.f3971e = bVarArr;
        int[] iArr2 = new int[32768];
        this.f3968b = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            int b2 = b(Color.blue(i4), 8, 5) | (b(Color.red(i4), 8, 5) << 10) | (b(Color.green(i4), 8, 5) << 5);
            iArr[i3] = b2;
            iArr2[b2] = iArr2[b2] + 1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                androidx.core.graphics.a.a(d(i6), this.f3972f);
                if (a(this.f3972f)) {
                    iArr2[i6] = 0;
                }
            }
            if (iArr2[i6] > 0) {
                i5++;
            }
        }
        int[] iArr3 = new int[i5];
        this.f3967a = iArr3;
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                iArr3[i7] = i8;
                i7++;
            }
        }
        if (i5 <= i2) {
            this.f3969c = new ArrayList();
            for (int i9 : iArr3) {
                this.f3969c.add(new b.d(d(i9), iArr2[i9]));
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i2, f3966g);
        priorityQueue.offer(new C0066a(0, this.f3967a.length - 1));
        a(priorityQueue, i2);
        this.f3969c = a((Collection<C0066a>) priorityQueue);
    }

    private static void a(PriorityQueue<C0066a> priorityQueue, int i2) {
        C0066a poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.b()) {
            if (poll.b()) {
                int d2 = poll.d();
                C0066a aVar = new C0066a(d2 + 1, poll.f3973a);
                poll.f3973a = d2;
                poll.c();
                priorityQueue.offer(aVar);
                priorityQueue.offer(poll);
            } else {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
        }
    }

    private List<b.d> a(Collection<C0066a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C0066a e2 : collection) {
            b.d e3 = e2.e();
            if (!a(e3.a())) {
                arrayList.add(e3);
            }
        }
        return arrayList;
    }

    /* renamed from: androidx.palette.a.a$a  reason: collision with other inner class name */
    class C0066a {

        /* renamed from: a  reason: collision with root package name */
        int f3973a;

        /* renamed from: c  reason: collision with root package name */
        private int f3975c;

        /* renamed from: d  reason: collision with root package name */
        private int f3976d;

        /* renamed from: e  reason: collision with root package name */
        private int f3977e;

        /* renamed from: f  reason: collision with root package name */
        private int f3978f;

        /* renamed from: g  reason: collision with root package name */
        private int f3979g;

        /* renamed from: h  reason: collision with root package name */
        private int f3980h;

        /* renamed from: i  reason: collision with root package name */
        private int f3981i;
        private int j;

        C0066a(int i2, int i3) {
            this.f3975c = i2;
            this.f3973a = i3;
            c();
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            return ((this.f3978f - this.f3977e) + 1) * ((this.f3980h - this.f3979g) + 1) * ((this.j - this.f3981i) + 1);
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return f() > 1;
        }

        private int f() {
            return (this.f3973a + 1) - this.f3975c;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            int[] iArr = a.this.f3967a;
            int[] iArr2 = a.this.f3968b;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.f3975c; i9 <= this.f3973a; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int a2 = a.a(i10);
                int b2 = a.b(i10);
                int c2 = a.c(i10);
                if (a2 > i3) {
                    i3 = a2;
                }
                if (a2 < i2) {
                    i2 = a2;
                }
                if (b2 > i5) {
                    i5 = b2;
                }
                if (b2 < i4) {
                    i4 = b2;
                }
                if (c2 > i7) {
                    i7 = c2;
                }
                if (c2 < i6) {
                    i6 = c2;
                }
            }
            this.f3977e = i2;
            this.f3978f = i3;
            this.f3979g = i4;
            this.f3980h = i5;
            this.f3981i = i6;
            this.j = i7;
            this.f3976d = i8;
        }

        /* access modifiers changed from: package-private */
        public final b.d e() {
            int[] iArr = a.this.f3967a;
            int[] iArr2 = a.this.f3968b;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = this.f3975c; i6 <= this.f3973a; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i7];
                i3 += i8;
                i2 += a.a(i7) * i8;
                i4 += a.b(i7) * i8;
                i5 += i8 * a.c(i7);
            }
            float f2 = (float) i3;
            return new b.d(a.a(Math.round(((float) i2) / f2), Math.round(((float) i4) / f2), Math.round(((float) i5) / f2)), i3);
        }

        /* access modifiers changed from: package-private */
        public final int d() {
            int i2 = this.f3978f - this.f3977e;
            int i3 = this.f3980h - this.f3979g;
            int i4 = this.j - this.f3981i;
            int i5 = (i2 < i3 || i2 < i4) ? (i3 < i2 || i3 < i4) ? -1 : -2 : -3;
            int[] iArr = a.this.f3967a;
            int[] iArr2 = a.this.f3968b;
            a.a(iArr, i5, this.f3975c, this.f3973a);
            Arrays.sort(iArr, this.f3975c, this.f3973a + 1);
            a.a(iArr, i5, this.f3975c, this.f3973a);
            int i6 = this.f3976d / 2;
            int i7 = this.f3975c;
            int i8 = 0;
            while (true) {
                int i9 = this.f3973a;
                if (i7 > i9) {
                    return this.f3975c;
                }
                i8 += iArr2[iArr[i7]];
                if (i8 >= i6) {
                    return Math.min(i9 - 1, i7);
                }
                i7++;
            }
        }
    }

    static void a(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -3) {
            return;
        }
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = (i5 & 31) | (((i5 >> 5) & 31) << 10) | (((i5 >> 10) & 31) << 5);
                i3++;
            }
        } else if (i2 == -1) {
            while (i3 <= i4) {
                int i6 = iArr[i3];
                iArr[i3] = ((i6 >> 10) & 31) | ((i6 & 31) << 10) | (((i6 >> 5) & 31) << 5);
                i3++;
            }
        }
    }

    private boolean a(float[] fArr) {
        b.C0067b[] bVarArr = this.f3971e;
        if (bVarArr != null && bVarArr.length > 0) {
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.f3971e[i2].a(fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int a(int i2, int i3, int i4) {
        return Color.rgb(b(i2, 5, 8), b(i3, 5, 8), b(i4, 5, 8));
    }

    private static int d(int i2) {
        return a((i2 >> 10) & 31, (i2 >> 5) & 31, i2 & 31);
    }
}
