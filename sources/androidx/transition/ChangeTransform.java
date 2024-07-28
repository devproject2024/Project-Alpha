package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b.g;
import androidx.core.h.u;
import androidx.transition.Transition;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String[] o = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<b, float[]> p = new Property<b, float[]>(float[].class, "nonTranslations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            b bVar = (b) obj;
            float[] fArr = (float[]) obj2;
            System.arraycopy(fArr, 0, bVar.f4671b, 0, fArr.length);
            bVar.a();
        }
    };
    private static final Property<b, PointF> q = new Property<b, PointF>(PointF.class, "translations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            b bVar = (b) obj;
            PointF pointF = (PointF) obj2;
            bVar.f4672c = pointF.x;
            bVar.f4673d = pointF.y;
            bVar.a();
        }
    };
    private static final boolean r = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: a  reason: collision with root package name */
    boolean f4659a = true;
    private boolean s = true;
    private Matrix t = new Matrix();

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4831g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f4659a = g.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.s = g.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    public final String[] a() {
        return o;
    }

    private void d(y yVar) {
        View view = yVar.f4851b;
        if (view.getVisibility() != 8) {
            yVar.f4850a.put("android:changeTransform:parent", view.getParent());
            yVar.f4850a.put("android:changeTransform:transforms", new c(view));
            Matrix matrix = view.getMatrix();
            yVar.f4850a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.s) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                aj.a((View) viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                yVar.f4850a.put("android:changeTransform:parentMatrix", matrix2);
                yVar.f4850a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                yVar.f4850a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    public final void a(y yVar) {
        d(yVar);
        if (!r) {
            ((ViewGroup) yVar.f4851b.getParent()).startViewTransition(yVar.f4851b);
        }
    }

    public final void b(y yVar) {
        d(yVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator a(android.view.ViewGroup r18, androidx.transition.y r19, androidx.transition.y r20) {
        /*
            r17 = this;
            r7 = r17
            r8 = r19
            r9 = r20
            r0 = 0
            if (r8 == 0) goto L_0x0159
            if (r9 == 0) goto L_0x0159
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.String r2 = "android:changeTransform:parent"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x0159
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f4850a
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x001f
            goto L_0x0159
        L_0x001f:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.Object r1 = r1.get(r2)
            r10 = r1
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f4850a
            java.lang.Object r1 = r1.get(r2)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            boolean r2 = r7.s
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            boolean r2 = r7.b((android.view.View) r10)
            if (r2 == 0) goto L_0x0051
            boolean r2 = r7.b((android.view.View) r1)
            if (r2 != 0) goto L_0x0043
            goto L_0x0051
        L_0x0043:
            androidx.transition.y r2 = r7.c(r10, r3)
            if (r2 == 0) goto L_0x004f
            android.view.View r2 = r2.f4851b
            if (r1 != r2) goto L_0x004f
        L_0x004d:
            r1 = 1
            goto L_0x0054
        L_0x004f:
            r1 = 0
            goto L_0x0054
        L_0x0051:
            if (r10 != r1) goto L_0x004f
            goto L_0x004d
        L_0x0054:
            if (r1 != 0) goto L_0x0058
            r11 = 1
            goto L_0x0059
        L_0x0058:
            r11 = 0
        L_0x0059:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.String r2 = "android:changeTransform:intermediateMatrix"
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.lang.String r2 = "android:changeTransform:matrix"
            if (r1 == 0) goto L_0x006c
            java.util.Map<java.lang.String, java.lang.Object> r5 = r8.f4850a
            r5.put(r2, r1)
        L_0x006c:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.String r5 = "android:changeTransform:intermediateParentMatrix"
            java.lang.Object r1 = r1.get(r5)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.lang.String r5 = "android:changeTransform:parentMatrix"
            if (r1 == 0) goto L_0x007f
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4850a
            r6.put(r5, r1)
        L_0x007f:
            if (r11 == 0) goto L_0x00ba
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f4850a
            java.lang.Object r1 = r1.get(r5)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            android.view.View r6 = r9.f4851b
            int r12 = androidx.transition.R.id.parent_matrix
            r6.setTag(r12, r1)
            android.graphics.Matrix r6 = r7.t
            r6.reset()
            r1.invert(r6)
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            if (r1 != 0) goto L_0x00ac
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r12 = r8.f4850a
            r12.put(r2, r1)
        L_0x00ac:
            java.util.Map<java.lang.String, java.lang.Object> r12 = r8.f4850a
            java.lang.Object r5 = r12.get(r5)
            android.graphics.Matrix r5 = (android.graphics.Matrix) r5
            r1.postConcat(r5)
            r1.postConcat(r6)
        L_0x00ba:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f4850a
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.util.Map<java.lang.String, java.lang.Object> r5 = r9.f4850a
            java.lang.Object r2 = r5.get(r2)
            android.graphics.Matrix r2 = (android.graphics.Matrix) r2
            if (r1 != 0) goto L_0x00ce
            android.graphics.Matrix r1 = androidx.transition.k.f4809a
        L_0x00ce:
            if (r2 != 0) goto L_0x00d2
            android.graphics.Matrix r2 = androidx.transition.k.f4809a
        L_0x00d2:
            r5 = r2
            boolean r2 = r1.equals(r5)
            if (r2 == 0) goto L_0x00da
            goto L_0x0144
        L_0x00da:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.f4850a
            java.lang.String r2 = "android:changeTransform:transforms"
            java.lang.Object r0 = r0.get(r2)
            r6 = r0
            androidx.transition.ChangeTransform$c r6 = (androidx.transition.ChangeTransform.c) r6
            android.view.View r12 = r9.f4851b
            a((android.view.View) r12)
            r0 = 9
            float[] r2 = new float[r0]
            r1.getValues(r2)
            float[] r1 = new float[r0]
            r5.getValues(r1)
            androidx.transition.ChangeTransform$b r13 = new androidx.transition.ChangeTransform$b
            r13.<init>(r12, r2)
            android.util.Property<androidx.transition.ChangeTransform$b, float[]> r14 = p
            androidx.transition.d r15 = new androidx.transition.d
            float[] r0 = new float[r0]
            r15.<init>(r0)
            r0 = 2
            float[][] r9 = new float[r0][]
            r9[r4] = r2
            r9[r3] = r1
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofObject(r14, r15, r9)
            androidx.transition.PathMotion r14 = r7.n
            r15 = r2[r0]
            r16 = 5
            r2 = r2[r16]
            r3 = r1[r0]
            r1 = r1[r16]
            android.graphics.Path r1 = r14.a(r15, r2, r3, r1)
            android.util.Property<androidx.transition.ChangeTransform$b, android.graphics.PointF> r2 = q
            android.animation.PropertyValuesHolder r1 = androidx.transition.n.a(r2, r1)
            android.animation.PropertyValuesHolder[] r0 = new android.animation.PropertyValuesHolder[r0]
            r0[r4] = r9
            r2 = 1
            r0[r2] = r1
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r13, r0)
            androidx.transition.ChangeTransform$3 r14 = new androidx.transition.ChangeTransform$3
            r0 = r14
            r1 = r17
            r2 = r11
            r3 = r5
            r4 = r12
            r5 = r6
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)
            r9.addListener(r14)
            androidx.transition.a.a(r9, r14)
            r0 = r9
        L_0x0144:
            if (r11 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x0150
            boolean r1 = r7.f4659a
            if (r1 == 0) goto L_0x0150
            r17.b(r18, r19, r20)
            goto L_0x0159
        L_0x0150:
            boolean r1 = r
            if (r1 != 0) goto L_0x0159
            android.view.View r1 = r8.f4851b
            r10.endViewTransition(r1)
        L_0x0159:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.a(android.view.ViewGroup, androidx.transition.y, androidx.transition.y):android.animation.Animator");
    }

    private void b(ViewGroup viewGroup, y yVar, y yVar2) {
        f fVar;
        View view = yVar2.f4851b;
        Matrix matrix = new Matrix((Matrix) yVar2.f4850a.get("android:changeTransform:parentMatrix"));
        aj.b(viewGroup, matrix);
        if (Build.VERSION.SDK_INT == 28) {
            fVar = h.a(view, viewGroup, matrix);
        } else {
            fVar = i.a(view, viewGroup, matrix);
        }
        if (fVar != null) {
            fVar.a((ViewGroup) yVar.f4850a.get("android:changeTransform:parent"), yVar.f4851b);
            Transition transition = this;
            while (transition.f4698i != null) {
                transition = transition.f4698i;
            }
            transition.a((Transition.d) new a(view, fVar));
            if (r) {
                if (yVar.f4851b != yVar2.f4851b) {
                    aj.a(yVar.f4851b, 0.0f);
                }
                aj.a(view, 1.0f);
            }
        }
    }

    static void a(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        u.h(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final float f4675a;

        /* renamed from: b  reason: collision with root package name */
        final float f4676b;

        /* renamed from: c  reason: collision with root package name */
        final float f4677c;

        /* renamed from: d  reason: collision with root package name */
        final float f4678d;

        /* renamed from: e  reason: collision with root package name */
        final float f4679e;

        /* renamed from: f  reason: collision with root package name */
        final float f4680f;

        /* renamed from: g  reason: collision with root package name */
        final float f4681g;

        /* renamed from: h  reason: collision with root package name */
        final float f4682h;

        c(View view) {
            this.f4675a = view.getTranslationX();
            this.f4676b = view.getTranslationY();
            this.f4677c = u.w(view);
            this.f4678d = view.getScaleX();
            this.f4679e = view.getScaleY();
            this.f4680f = view.getRotationX();
            this.f4681g = view.getRotationY();
            this.f4682h = view.getRotation();
        }

        public final void a(View view) {
            ChangeTransform.a(view, this.f4675a, this.f4676b, this.f4677c, this.f4678d, this.f4679e, this.f4680f, this.f4681g, this.f4682h);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.f4675a == this.f4675a && cVar.f4676b == this.f4676b && cVar.f4677c == this.f4677c && cVar.f4678d == this.f4678d && cVar.f4679e == this.f4679e && cVar.f4680f == this.f4680f && cVar.f4681g == this.f4681g && cVar.f4682h == this.f4682h) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            float f2 = this.f4675a;
            int i2 = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f4676b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f4677c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f4678d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f4679e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f4680f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f4681g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f4682h;
            if (f9 != 0.0f) {
                i2 = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i2;
        }
    }

    static class a extends u {

        /* renamed from: a  reason: collision with root package name */
        private View f4668a;

        /* renamed from: b  reason: collision with root package name */
        private f f4669b;

        a(View view, f fVar) {
            this.f4668a = view;
            this.f4669b = fVar;
        }

        public final void a(Transition transition) {
            transition.b((Transition.d) this);
            View view = this.f4668a;
            if (Build.VERSION.SDK_INT == 28) {
                if (!h.f4794c) {
                    try {
                        h.a();
                        Method declaredMethod = h.f4792a.getDeclaredMethod("removeGhost", new Class[]{View.class});
                        h.f4793b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    h.f4794c = true;
                }
                if (h.f4793b != null) {
                    try {
                        h.f4793b.invoke((Object) null, new Object[]{view});
                    } catch (IllegalAccessException unused2) {
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2.getCause());
                    }
                }
            } else {
                i.a(view);
            }
            this.f4668a.setTag(R.id.transition_transform, (Object) null);
            this.f4668a.setTag(R.id.parent_matrix, (Object) null);
        }

        public final void b() {
            this.f4669b.setVisibility(4);
        }

        public final void c() {
            this.f4669b.setVisibility(0);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f4670a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        final float[] f4671b;

        /* renamed from: c  reason: collision with root package name */
        float f4672c;

        /* renamed from: d  reason: collision with root package name */
        float f4673d;

        /* renamed from: e  reason: collision with root package name */
        private final View f4674e;

        b(View view, float[] fArr) {
            this.f4674e = view;
            this.f4671b = (float[]) fArr.clone();
            float[] fArr2 = this.f4671b;
            this.f4672c = fArr2[2];
            this.f4673d = fArr2[5];
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            float[] fArr = this.f4671b;
            fArr[2] = this.f4672c;
            fArr[5] = this.f4673d;
            this.f4670a.setValues(fArr);
            aj.c(this.f4674e, this.f4670a);
        }
    }
}
