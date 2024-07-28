package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.c.d;
import com.airbnb.lottie.c.i;
import com.airbnb.lottie.f;
import com.airbnb.lottie.q;
import com.business.merchant_payments.utility.StringUtility;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends a {
    private a<Float, Float> A;

    /* renamed from: h  reason: collision with root package name */
    private final StringBuilder f5953h = new StringBuilder(2);

    /* renamed from: i  reason: collision with root package name */
    private final RectF f5954i = new RectF();
    private final Matrix j = new Matrix();
    private final Paint k = new Paint() {
        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final Paint l = new Paint() {
        {
            setStyle(Paint.Style.STROKE);
        }
    };
    private final Map<d, List<com.airbnb.lottie.a.a.d>> m = new HashMap();
    private final androidx.a.d<String> n = new androidx.a.d<>();
    private final n o;
    private final f p;
    private final com.airbnb.lottie.d q;
    private a<Integer, Integer> r;
    private a<Integer, Integer> s;
    private a<Integer, Integer> t;
    private a<Integer, Integer> u;
    private a<Float, Float> v;
    private a<Float, Float> w;
    private a<Float, Float> x;
    private a<Float, Float> y;
    private a<Float, Float> z;

    h(f fVar, d dVar) {
        super(fVar, dVar);
        this.p = fVar;
        this.q = dVar.f5942b;
        this.o = dVar.q.a();
        this.o.a((a.C0083a) this);
        a((a<?, ?>) this.o);
        k kVar = dVar.r;
        if (!(kVar == null || kVar.f5813a == null)) {
            this.r = kVar.f5813a.a();
            this.r.a((a.C0083a) this);
            a((a<?, ?>) this.r);
        }
        if (!(kVar == null || kVar.f5814b == null)) {
            this.t = kVar.f5814b.a();
            this.t.a((a.C0083a) this);
            a((a<?, ?>) this.t);
        }
        if (!(kVar == null || kVar.f5815c == null)) {
            this.v = kVar.f5815c.a();
            this.v.a((a.C0083a) this);
            a((a<?, ?>) this.v);
        }
        if (kVar != null && kVar.f5816d != null) {
            this.x = kVar.f5816d.a();
            this.x.a((a.C0083a) this);
            a((a<?, ?>) this.x);
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, (float) this.q.f5982i.width(), (float) this.q.f5982i.height());
    }

    /* access modifiers changed from: package-private */
    public final void b(Canvas canvas, Matrix matrix, int i2) {
        float f2;
        String str;
        int i3;
        List list;
        float floatValue;
        float f3;
        String str2;
        int i4;
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        canvas.save();
        if (!this.p.f()) {
            canvas.setMatrix(matrix);
        }
        b bVar = (b) this.o.f();
        c cVar = this.q.f5977d.get(bVar.f5828b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        a<Integer, Integer> aVar = this.s;
        if (aVar != null) {
            this.k.setColor(aVar.f().intValue());
        } else {
            a<Integer, Integer> aVar2 = this.r;
            if (aVar2 != null) {
                this.k.setColor(aVar2.f().intValue());
            } else {
                this.k.setColor(bVar.f5834h);
            }
        }
        a<Integer, Integer> aVar3 = this.u;
        if (aVar3 != null) {
            this.l.setColor(aVar3.f().intValue());
        } else {
            a<Integer, Integer> aVar4 = this.t;
            if (aVar4 != null) {
                this.l.setColor(aVar4.f().intValue());
            } else {
                this.l.setColor(bVar.f5835i);
            }
        }
        int intValue = ((this.f5930g.f5783e == null ? 100 : this.f5930g.f5783e.f().intValue()) * PriceRangeSeekBar.INVALID_POINTER_ID) / 100;
        this.k.setAlpha(intValue);
        this.l.setAlpha(intValue);
        a<Float, Float> aVar5 = this.w;
        if (aVar5 != null) {
            this.l.setStrokeWidth(aVar5.f().floatValue());
        } else {
            a<Float, Float> aVar6 = this.v;
            if (aVar6 != null) {
                this.l.setStrokeWidth(aVar6.f().floatValue());
            } else {
                this.l.setStrokeWidth(bVar.j * com.airbnb.lottie.f.h.a() * com.airbnb.lottie.f.h.a(matrix));
            }
        }
        if (this.p.f()) {
            a<Float, Float> aVar7 = this.A;
            if (aVar7 != null) {
                f2 = aVar7.f().floatValue();
            } else {
                a<Float, Float> aVar8 = this.z;
                if (aVar8 != null) {
                    f2 = aVar8.f().floatValue();
                } else {
                    f2 = bVar.f5829c;
                }
            }
            float f4 = f2 / 100.0f;
            float a2 = com.airbnb.lottie.f.h.a(matrix);
            String str3 = bVar.f5827a;
            float a3 = bVar.f5832f * com.airbnb.lottie.f.h.a();
            List<String> a4 = a(str3);
            int size = a4.size();
            int i5 = 0;
            while (i5 < size) {
                String str4 = a4.get(i5);
                int i6 = 0;
                float f5 = 0.0f;
                while (i6 < str4.length()) {
                    List<String> list2 = a4;
                    d a5 = this.q.f5979f.a(d.a(str4.charAt(i6), cVar.f5920a, cVar.f5922c), null);
                    if (a5 != null) {
                        str2 = str4;
                        i4 = i5;
                        f3 = a3;
                        f5 = (float) (((double) f5) + (a5.f5959b * ((double) f4) * ((double) com.airbnb.lottie.f.h.a()) * ((double) a2)));
                    } else {
                        f3 = a3;
                        i4 = i5;
                        str2 = str4;
                    }
                    i6++;
                    a4 = list2;
                    i5 = i4;
                    str4 = str2;
                    a3 = f3;
                }
                List<String> list3 = a4;
                float f6 = a3;
                String str5 = str4;
                canvas.save();
                a(bVar.f5830d, canvas2, f5);
                int i7 = i5;
                canvas2.translate(0.0f, (((float) i7) * f6) - ((((float) (size - 1)) * f6) / 2.0f));
                int i8 = 0;
                while (i8 < str5.length()) {
                    String str6 = str5;
                    d a6 = this.q.f5979f.a(d.a(str6.charAt(i8), cVar.f5920a, cVar.f5922c), null);
                    if (a6 != null) {
                        if (this.m.containsKey(a6)) {
                            i3 = size;
                            list = this.m.get(a6);
                            str = str6;
                        } else {
                            List<com.airbnb.lottie.c.b.n> list4 = a6.f5958a;
                            int size2 = list4.size();
                            list = new ArrayList(size2);
                            int i9 = 0;
                            while (i9 < size2) {
                                list.add(new com.airbnb.lottie.a.a.d(this.p, this, list4.get(i9)));
                                i9++;
                                list4 = list4;
                                size = size;
                                str6 = str6;
                            }
                            i3 = size;
                            str = str6;
                            this.m.put(a6, list);
                        }
                        for (int i10 = 0; i10 < list.size(); i10++) {
                            Path e2 = ((com.airbnb.lottie.a.a.d) list.get(i10)).e();
                            e2.computeBounds(this.f5954i, false);
                            this.j.set(matrix2);
                            this.j.preTranslate(0.0f, (-bVar.f5833g) * com.airbnb.lottie.f.h.a());
                            this.j.preScale(f4, f4);
                            e2.transform(this.j);
                            if (bVar.k) {
                                a(e2, this.k, canvas2);
                                a(e2, this.l, canvas2);
                            } else {
                                a(e2, this.l, canvas2);
                                a(e2, this.k, canvas2);
                            }
                        }
                        float a7 = ((float) a6.f5959b) * f4 * com.airbnb.lottie.f.h.a() * a2;
                        float f7 = ((float) bVar.f5831e) / 10.0f;
                        a<Float, Float> aVar9 = this.y;
                        if (aVar9 != null) {
                            floatValue = aVar9.f().floatValue();
                        } else {
                            a<Float, Float> aVar10 = this.x;
                            if (aVar10 != null) {
                                floatValue = aVar10.f().floatValue();
                            }
                            canvas2.translate(a7 + (f7 * a2), 0.0f);
                        }
                        f7 += floatValue;
                        canvas2.translate(a7 + (f7 * a2), 0.0f);
                    } else {
                        i3 = size;
                        str = str6;
                    }
                    i8++;
                    size = i3;
                    str5 = str;
                }
                int i11 = size;
                canvas.restore();
                i5 = i7 + 1;
                a4 = list3;
                a3 = f6;
            }
        } else {
            a(bVar, cVar, matrix2, canvas2);
        }
        canvas.restore();
    }

    private void a(b bVar, c cVar, Matrix matrix, Canvas canvas) {
        com.airbnb.lottie.b.a aVar;
        float f2;
        float a2 = com.airbnb.lottie.f.h.a(matrix);
        f fVar = this.p;
        T t2 = cVar.f5920a;
        T t3 = cVar.f5922c;
        Typeface typeface = null;
        if (fVar.getCallback() == null) {
            aVar = null;
        } else {
            if (fVar.l == null) {
                fVar.l = new com.airbnb.lottie.b.a(fVar.getCallback(), fVar.m);
            }
            aVar = fVar.l;
        }
        if (aVar != null) {
            i<String> iVar = aVar.f5790a;
            iVar.f5972a = t2;
            iVar.f5973b = t3;
            typeface = aVar.f5791b.get(aVar.f5790a);
            if (typeface == null) {
                typeface = aVar.f5792c.get(t2);
                if (typeface == null) {
                    typeface = Typeface.createFromAsset(aVar.f5793d, "fonts/" + t2 + aVar.f5795f);
                    aVar.f5792c.put(t2, typeface);
                }
                boolean contains = t3.contains("Italic");
                boolean contains2 = t3.contains("Bold");
                int i2 = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
                if (typeface.getStyle() != i2) {
                    typeface = Typeface.create(typeface, i2);
                }
                aVar.f5791b.put(aVar.f5790a, typeface);
            }
        }
        if (typeface != null) {
            String str = bVar.f5827a;
            q qVar = this.p.n;
            if (qVar != null) {
                if (qVar.f6179b && qVar.f6178a.containsKey(str)) {
                    str = qVar.f6178a.get(str);
                } else if (qVar.f6179b) {
                    qVar.f6178a.put(str, str);
                }
            }
            this.k.setTypeface(typeface);
            a<Float, Float> aVar2 = this.A;
            if (aVar2 != null) {
                f2 = aVar2.f().floatValue();
            } else {
                a<Float, Float> aVar3 = this.z;
                if (aVar3 != null) {
                    f2 = aVar3.f().floatValue();
                } else {
                    f2 = bVar.f5829c;
                }
            }
            this.k.setTextSize(f2 * com.airbnb.lottie.f.h.a());
            this.l.setTypeface(this.k.getTypeface());
            this.l.setTextSize(this.k.getTextSize());
            float a3 = bVar.f5832f * com.airbnb.lottie.f.h.a();
            List<String> a4 = a(str);
            int size = a4.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str2 = a4.get(i3);
                a(bVar.f5830d, canvas, this.l.measureText(str2));
                canvas.translate(0.0f, (((float) i3) * a3) - ((((float) (size - 1)) * a3) / 2.0f));
                a(str2, bVar, canvas, a2);
                canvas.setMatrix(matrix);
            }
        }
    }

    private static List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll(StringUtility.NEW_LINE, "\r").split("\r"));
    }

    private void a(String str, b bVar, Canvas canvas, float f2) {
        String str2;
        float floatValue;
        int i2 = 0;
        while (i2 < str.length()) {
            int codePointAt = str.codePointAt(i2);
            int charCount = Character.charCount(codePointAt) + i2;
            while (charCount < str.length()) {
                int codePointAt2 = str.codePointAt(charCount);
                if (!(Character.getType(codePointAt2) == 16 || Character.getType(codePointAt2) == 27 || Character.getType(codePointAt2) == 6 || Character.getType(codePointAt2) == 28 || Character.getType(codePointAt2) == 19)) {
                    break;
                }
                charCount += Character.charCount(codePointAt2);
                codePointAt = (codePointAt * 31) + codePointAt2;
            }
            long j2 = (long) codePointAt;
            if (this.n.a(j2) >= 0) {
                str2 = this.n.a(j2, null);
            } else {
                this.f5953h.setLength(0);
                int i3 = i2;
                while (i3 < charCount) {
                    int codePointAt3 = str.codePointAt(i3);
                    this.f5953h.appendCodePoint(codePointAt3);
                    i3 += Character.charCount(codePointAt3);
                }
                str2 = this.f5953h.toString();
                this.n.b(j2, str2);
            }
            i2 += str2.length();
            if (bVar.k) {
                a(str2, this.k, canvas);
                a(str2, this.l, canvas);
            } else {
                a(str2, this.l, canvas);
                a(str2, this.k, canvas);
            }
            float measureText = this.k.measureText(str2, 0, 1);
            float f3 = ((float) bVar.f5831e) / 10.0f;
            a<Float, Float> aVar = this.y;
            if (aVar != null) {
                floatValue = aVar.f().floatValue();
            } else {
                a<Float, Float> aVar2 = this.x;
                if (aVar2 != null) {
                    floatValue = aVar2.f().floatValue();
                } else {
                    canvas.translate(measureText + (f3 * f2), 0.0f);
                }
            }
            f3 += floatValue;
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.h$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5957a = new int[b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airbnb.lottie.c.b$a[] r0 = com.airbnb.lottie.c.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5957a = r0
                int[] r0 = f5957a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5957a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5957a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.CENTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.h.AnonymousClass3.<clinit>():void");
        }
    }

    private static void a(b.a aVar, Canvas canvas, float f2) {
        int i2 = AnonymousClass3.f5957a[aVar.ordinal()];
        if (i2 == 1) {
            return;
        }
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 == 3) {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private static void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private static void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    public final <T> void a(T t2, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == com.airbnb.lottie.k.f6155a) {
            a<Integer, Integer> aVar = this.s;
            if (aVar != null) {
                b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            this.s = new p(cVar);
            this.s.a((a.C0083a) this);
            a((a<?, ?>) this.s);
        } else if (t2 == com.airbnb.lottie.k.f6156b) {
            a<Integer, Integer> aVar2 = this.u;
            if (aVar2 != null) {
                b((a<?, ?>) aVar2);
            }
            if (cVar == null) {
                this.u = null;
                return;
            }
            this.u = new p(cVar);
            this.u.a((a.C0083a) this);
            a((a<?, ?>) this.u);
        } else if (t2 == com.airbnb.lottie.k.o) {
            a<Float, Float> aVar3 = this.w;
            if (aVar3 != null) {
                b((a<?, ?>) aVar3);
            }
            if (cVar == null) {
                this.w = null;
                return;
            }
            this.w = new p(cVar);
            this.w.a((a.C0083a) this);
            a((a<?, ?>) this.w);
        } else if (t2 == com.airbnb.lottie.k.p) {
            a<Float, Float> aVar4 = this.y;
            if (aVar4 != null) {
                b((a<?, ?>) aVar4);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            this.y = new p(cVar);
            this.y.a((a.C0083a) this);
            a((a<?, ?>) this.y);
        } else if (t2 == com.airbnb.lottie.k.B) {
            a<Float, Float> aVar5 = this.A;
            if (aVar5 != null) {
                b((a<?, ?>) aVar5);
            }
            if (cVar == null) {
                this.A = null;
                return;
            }
            this.A = new p(cVar);
            this.A.a((a.C0083a) this);
            a((a<?, ?>) this.A);
        }
    }
}
