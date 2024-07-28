package androidx.palette.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final C0067b f3982a = new C0067b() {
        public final boolean a(float[] fArr) {
            if (!(fArr[2] >= 0.95f)) {
                if (!(fArr[2] <= 0.05f)) {
                    if (!(fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f)) {
                        return true;
                    }
                }
            }
            return false;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f3983b;

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f3984c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<c, d> f3985d = new androidx.a.a();

    /* renamed from: e  reason: collision with root package name */
    private final SparseBooleanArray f3986e = new SparseBooleanArray();

    /* renamed from: f  reason: collision with root package name */
    private final d f3987f = b();

    /* renamed from: androidx.palette.a.b$b  reason: collision with other inner class name */
    public interface C0067b {
        boolean a(float[] fArr);
    }

    public interface c {
        void onGenerated(b bVar);
    }

    public static a a(Bitmap bitmap) {
        return new a(bitmap);
    }

    b(List<d> list, List<c> list2) {
        this.f3983b = list;
        this.f3984c = list2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        int i2;
        int size = this.f3984c.size();
        char c2 = 0;
        int i3 = 0;
        while (i3 < size) {
            c cVar = this.f3984c.get(i3);
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (float f4 : cVar.f4015i) {
                if (f4 > 0.0f) {
                    f3 += f4;
                }
            }
            if (f3 != 0.0f) {
                int length = cVar.f4015i.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (cVar.f4015i[i4] > 0.0f) {
                        float[] fArr = cVar.f4015i;
                        fArr[i4] = fArr[i4] / f3;
                    }
                }
            }
            Map<c, d> map = this.f3985d;
            int size2 = this.f3983b.size();
            d dVar = null;
            int i5 = 0;
            float f5 = 0.0f;
            while (i5 < size2) {
                d dVar2 = this.f3983b.get(i5);
                float[] a2 = dVar2.a();
                if (a2[1] >= cVar.f4013g[c2] && a2[1] <= cVar.f4013g[2] && a2[2] >= cVar.f4014h[c2] && a2[2] <= cVar.f4014h[2] && !this.f3986e.get(dVar2.f3998a)) {
                    float[] a3 = dVar2.a();
                    d dVar3 = this.f3987f;
                    if (dVar3 != null) {
                        i2 = dVar3.f3999b;
                    } else {
                        i2 = 1;
                    }
                    float abs = (cVar.f4015i[c2] > f2 ? (1.0f - Math.abs(a3[1] - cVar.f4013g[1])) * cVar.f4015i[c2] : 0.0f) + (cVar.f4015i[1] > f2 ? cVar.f4015i[1] * (1.0f - Math.abs(a3[2] - cVar.f4014h[1])) : 0.0f) + (cVar.f4015i[2] > 0.0f ? cVar.f4015i[2] * (((float) dVar2.f3999b) / ((float) i2)) : 0.0f);
                    if (dVar == null || abs > f5) {
                        f5 = abs;
                        dVar = dVar2;
                    }
                }
                i5++;
                c2 = 0;
                f2 = 0.0f;
            }
            if (dVar != null && cVar.j) {
                this.f3986e.append(dVar.f3998a, true);
            }
            map.put(cVar, dVar);
            i3++;
            c2 = 0;
        }
        this.f3986e.clear();
    }

    private d b() {
        int size = this.f3983b.size();
        int i2 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar2 = this.f3983b.get(i3);
            if (dVar2.f3999b > i2) {
                i2 = dVar2.f3999b;
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final int f3998a;

        /* renamed from: b  reason: collision with root package name */
        final int f3999b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4000c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4001d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4002e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4003f;

        /* renamed from: g  reason: collision with root package name */
        private int f4004g;

        /* renamed from: h  reason: collision with root package name */
        private int f4005h;

        /* renamed from: i  reason: collision with root package name */
        private float[] f4006i;

        public d(int i2, int i3) {
            this.f4000c = Color.red(i2);
            this.f4001d = Color.green(i2);
            this.f4002e = Color.blue(i2);
            this.f3998a = i2;
            this.f3999b = i3;
        }

        public final float[] a() {
            if (this.f4006i == null) {
                this.f4006i = new float[3];
            }
            androidx.core.graphics.a.a(this.f4000c, this.f4001d, this.f4002e, this.f4006i);
            return this.f4006i;
        }

        private void b() {
            int i2;
            int i3;
            if (!this.f4003f) {
                int a2 = androidx.core.graphics.a.a(-1, this.f3998a, 4.5f);
                int a3 = androidx.core.graphics.a.a(-1, this.f3998a, 3.0f);
                if (a2 == -1 || a3 == -1) {
                    int a4 = androidx.core.graphics.a.a(-16777216, this.f3998a, 4.5f);
                    int a5 = androidx.core.graphics.a.a(-16777216, this.f3998a, 3.0f);
                    if (a4 == -1 || a5 == -1) {
                        if (a2 != -1) {
                            i2 = androidx.core.graphics.a.b(-1, a2);
                        } else {
                            i2 = androidx.core.graphics.a.b(-16777216, a4);
                        }
                        this.f4005h = i2;
                        if (a3 != -1) {
                            i3 = androidx.core.graphics.a.b(-1, a3);
                        } else {
                            i3 = androidx.core.graphics.a.b(-16777216, a5);
                        }
                        this.f4004g = i3;
                        this.f4003f = true;
                        return;
                    }
                    this.f4005h = androidx.core.graphics.a.b(-16777216, a4);
                    this.f4004g = androidx.core.graphics.a.b(-16777216, a5);
                    this.f4003f = true;
                    return;
                }
                this.f4005h = androidx.core.graphics.a.b(-1, a2);
                this.f4004g = androidx.core.graphics.a.b(-1, a3);
                this.f4003f = true;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(getClass().getSimpleName());
            sb.append(" [RGB: #");
            sb.append(Integer.toHexString(this.f3998a));
            sb.append(']');
            sb.append(" [HSL: ");
            sb.append(Arrays.toString(a()));
            sb.append(']');
            sb.append(" [Population: ");
            sb.append(this.f3999b);
            sb.append(']');
            sb.append(" [Title Text: #");
            b();
            sb.append(Integer.toHexString(this.f4004g));
            sb.append(']');
            sb.append(" [Body Text: #");
            b();
            sb.append(Integer.toHexString(this.f4005h));
            sb.append(']');
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                d dVar = (d) obj;
                return this.f3999b == dVar.f3999b && this.f3998a == dVar.f3998a;
            }
        }

        public final int hashCode() {
            return (this.f3998a * 31) + this.f3999b;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<d> f3988a;

        /* renamed from: b  reason: collision with root package name */
        final Bitmap f3989b;

        /* renamed from: c  reason: collision with root package name */
        final List<c> f3990c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        int f3991d = 16;

        /* renamed from: e  reason: collision with root package name */
        int f3992e = 12544;

        /* renamed from: f  reason: collision with root package name */
        int f3993f = -1;

        /* renamed from: g  reason: collision with root package name */
        final List<C0067b> f3994g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        Rect f3995h;

        public a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.f3994g.add(b.f3982a);
            this.f3989b = bitmap;
            this.f3988a = null;
            this.f3990c.add(c.f4007a);
            this.f3990c.add(c.f4008b);
            this.f3990c.add(c.f4009c);
            this.f3990c.add(c.f4010d);
            this.f3990c.add(c.f4011e);
            this.f3990c.add(c.f4012f);
        }

        public final AsyncTask<Bitmap, Void, b> a(final c cVar) {
            return new AsyncTask<Bitmap, Void, b>() {
                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return a();
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    cVar.onGenerated((b) obj);
                }

                private b a() {
                    List<d> list;
                    int max;
                    try {
                        a aVar = a.this;
                        if (aVar.f3989b != null) {
                            Bitmap bitmap = aVar.f3989b;
                            double d2 = -1.0d;
                            if (aVar.f3992e > 0) {
                                int width = bitmap.getWidth() * bitmap.getHeight();
                                if (width > aVar.f3992e) {
                                    d2 = Math.sqrt(((double) aVar.f3992e) / ((double) width));
                                }
                            } else if (aVar.f3993f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > aVar.f3993f) {
                                d2 = ((double) aVar.f3993f) / ((double) max);
                            }
                            if (d2 > 0.0d) {
                                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d2), (int) Math.ceil(((double) bitmap.getHeight()) * d2), false);
                            }
                            Rect rect = aVar.f3995h;
                            if (!(bitmap == aVar.f3989b || rect == null)) {
                                double width2 = ((double) bitmap.getWidth()) / ((double) aVar.f3989b.getWidth());
                                rect.left = (int) Math.floor(((double) rect.left) * width2);
                                rect.top = (int) Math.floor(((double) rect.top) * width2);
                                rect.right = Math.min((int) Math.ceil(((double) rect.right) * width2), bitmap.getWidth());
                                rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width2), bitmap.getHeight());
                            }
                            a aVar2 = new a(aVar.a(bitmap), aVar.f3991d, aVar.f3994g.isEmpty() ? null : (C0067b[]) aVar.f3994g.toArray(new C0067b[aVar.f3994g.size()]));
                            if (bitmap != aVar.f3989b) {
                                bitmap.recycle();
                            }
                            list = aVar2.f3969c;
                        } else if (aVar.f3988a != null) {
                            list = aVar.f3988a;
                        } else {
                            throw new AssertionError();
                        }
                        b bVar = new b(list, aVar.f3990c);
                        bVar.a();
                        return bVar;
                    } catch (Exception unused) {
                        return null;
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.f3989b});
        }

        /* access modifiers changed from: package-private */
        public final int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f3995h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f3995h.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i2 = 0; i2 < height2; i2++) {
                System.arraycopy(iArr, ((this.f3995h.top + i2) * width) + this.f3995h.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }
    }

    public final int a(c cVar, int i2) {
        d dVar = this.f3985d.get(cVar);
        return dVar != null ? dVar.f3998a : i2;
    }
}
