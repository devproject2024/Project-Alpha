package androidx.vectordrawable.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.b.g;
import androidx.core.graphics.c;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {
    private static boolean a(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i2);
            Animator a2 = a(context, resources, theme, animation, Xml.asAttributeSet(animation), (AnimatorSet) null, 0, 1.0f);
            if (animation != null) {
                animation.close();
            }
            return a2;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    static class a implements TypeEvaluator<c.b[]> {

        /* renamed from: a  reason: collision with root package name */
        private c.b[] f4879a;

        public final /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
            c.b[] bVarArr = (c.b[]) obj;
            c.b[] bVarArr2 = (c.b[]) obj2;
            if (c.a(bVarArr, bVarArr2)) {
                if (!c.a(this.f4879a, bVarArr)) {
                    this.f4879a = c.a(bVarArr);
                }
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    this.f4879a[i2].a(bVarArr[i2], bVarArr2[i2], f2);
                }
                return this.f4879a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        a() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder a(android.content.res.TypedArray r11, int r12, int r13, int r14, java.lang.String r15) {
        /*
            android.util.TypedValue r0 = r11.peekValue(r13)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000a
            r3 = 1
            goto L_0x000b
        L_0x000a:
            r3 = 0
        L_0x000b:
            if (r3 == 0) goto L_0x0010
            int r0 = r0.type
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            android.util.TypedValue r4 = r11.peekValue(r14)
            if (r4 == 0) goto L_0x0019
            r5 = 1
            goto L_0x001a
        L_0x0019:
            r5 = 0
        L_0x001a:
            if (r5 == 0) goto L_0x001f
            int r4 = r4.type
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r6 = 4
            r7 = 3
            if (r12 != r6) goto L_0x0037
            if (r3 == 0) goto L_0x002c
            boolean r12 = a(r0)
            if (r12 != 0) goto L_0x0034
        L_0x002c:
            if (r5 == 0) goto L_0x0036
            boolean r12 = a(r4)
            if (r12 == 0) goto L_0x0036
        L_0x0034:
            r12 = 3
            goto L_0x0037
        L_0x0036:
            r12 = 0
        L_0x0037:
            if (r12 != 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r8 = 0
            r9 = 2
            if (r12 != r9) goto L_0x00a7
            java.lang.String r12 = r11.getString(r13)
            java.lang.String r11 = r11.getString(r14)
            androidx.core.graphics.c$b[] r13 = androidx.core.graphics.c.b(r12)
            androidx.core.graphics.c$b[] r14 = androidx.core.graphics.c.b(r11)
            if (r13 != 0) goto L_0x0054
            if (r14 == 0) goto L_0x00a4
        L_0x0054:
            if (r13 == 0) goto L_0x0095
            androidx.vectordrawable.a.a.e$a r0 = new androidx.vectordrawable.a.a.e$a
            r0.<init>()
            if (r14 == 0) goto L_0x008b
            boolean r3 = androidx.core.graphics.c.a((androidx.core.graphics.c.b[]) r13, (androidx.core.graphics.c.b[]) r14)
            if (r3 == 0) goto L_0x006f
            java.lang.Object[] r11 = new java.lang.Object[r9]
            r11[r2] = r13
            r11[r1] = r14
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            goto L_0x0167
        L_0x006f:
            android.view.InflateException r13 = new android.view.InflateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = " Can't morph from "
            r14.<init>(r15)
            r14.append(r12)
            java.lang.String r12 = " to "
            r14.append(r12)
            r14.append(r11)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        L_0x008b:
            java.lang.Object[] r11 = new java.lang.Object[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            goto L_0x0167
        L_0x0095:
            if (r14 == 0) goto L_0x00a4
            androidx.vectordrawable.a.a.e$a r11 = new androidx.vectordrawable.a.a.e$a
            r11.<init>()
            java.lang.Object[] r12 = new java.lang.Object[r1]
            r12[r2] = r14
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofObject(r15, r11, r12)
        L_0x00a4:
            r11 = r8
            goto L_0x0167
        L_0x00a7:
            if (r12 != r7) goto L_0x00ae
            androidx.vectordrawable.a.a.f r12 = androidx.vectordrawable.a.a.f.a()
            goto L_0x00af
        L_0x00ae:
            r12 = r8
        L_0x00af:
            r7 = 5
            r10 = 0
            if (r6 == 0) goto L_0x00f8
            if (r3 == 0) goto L_0x00e3
            if (r0 != r7) goto L_0x00bc
            float r13 = r11.getDimension(r13, r10)
            goto L_0x00c0
        L_0x00bc:
            float r13 = r11.getFloat(r13, r10)
        L_0x00c0:
            if (r5 == 0) goto L_0x00d9
            if (r4 != r7) goto L_0x00c9
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00cd
        L_0x00c9:
            float r11 = r11.getFloat(r14, r10)
        L_0x00cd:
            float[] r14 = new float[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r14)
            goto L_0x015f
        L_0x00d9:
            float[] r11 = new float[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r11)
            goto L_0x015f
        L_0x00e3:
            if (r4 != r7) goto L_0x00ea
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00ee
        L_0x00ea:
            float r11 = r11.getFloat(r14, r10)
        L_0x00ee:
            float[] r13 = new float[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r13)
            goto L_0x015f
        L_0x00f8:
            if (r3 == 0) goto L_0x013e
            if (r0 != r7) goto L_0x0102
            float r13 = r11.getDimension(r13, r10)
            int r13 = (int) r13
            goto L_0x0111
        L_0x0102:
            boolean r0 = a(r0)
            if (r0 == 0) goto L_0x010d
            int r13 = r11.getColor(r13, r2)
            goto L_0x0111
        L_0x010d:
            int r13 = r11.getInt(r13, r2)
        L_0x0111:
            if (r5 == 0) goto L_0x0135
            if (r4 != r7) goto L_0x011b
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x012a
        L_0x011b:
            boolean r0 = a(r4)
            if (r0 == 0) goto L_0x0126
            int r11 = r11.getColor(r14, r2)
            goto L_0x012a
        L_0x0126:
            int r11 = r11.getInt(r14, r2)
        L_0x012a:
            int[] r14 = new int[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r14)
            goto L_0x015f
        L_0x0135:
            int[] r11 = new int[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
            goto L_0x015f
        L_0x013e:
            if (r5 == 0) goto L_0x015f
            if (r4 != r7) goto L_0x0148
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0157
        L_0x0148:
            boolean r13 = a(r4)
            if (r13 == 0) goto L_0x0153
            int r11 = r11.getColor(r14, r2)
            goto L_0x0157
        L_0x0153:
            int r11 = r11.getInt(r14, r2)
        L_0x0157:
            int[] r13 = new int[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r13)
        L_0x015f:
            r11 = r8
            if (r11 == 0) goto L_0x0167
            if (r12 == 0) goto L_0x0167
            r11.setEvaluator(r12)
        L_0x0167:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.e.a(android.content.res.TypedArray, int, int, int, java.lang.String):android.animation.PropertyValuesHolder");
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2 = valueAnimator;
        TypedArray typedArray3 = typedArray;
        TypedArray typedArray4 = typedArray2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long a2 = (long) g.a(typedArray3, xmlPullParser2, AppConstants.DURATION, 1, 300);
        long a3 = (long) g.a(typedArray3, xmlPullParser2, "startOffset", 2, 0);
        int a4 = g.a(typedArray3, xmlPullParser2, "valueType", 7, 4);
        if (g.a(xmlPullParser2, "valueFrom") && g.a(xmlPullParser2, "valueTo")) {
            if (a4 == 4) {
                TypedValue peekValue = typedArray3.peekValue(5);
                boolean z = peekValue != null;
                int i2 = z ? peekValue.type : 0;
                TypedValue peekValue2 = typedArray3.peekValue(6);
                boolean z2 = peekValue2 != null;
                a4 = ((!z || !a(i2)) && (!z2 || !a(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder a5 = a(typedArray3, a4, 5, 6, "");
            if (a5 != null) {
                valueAnimator2.setValues(new PropertyValuesHolder[]{a5});
            }
        }
        valueAnimator2.setDuration(a2);
        valueAnimator2.setStartDelay(a3);
        valueAnimator2.setRepeatCount(g.a(typedArray3, xmlPullParser2, "repeatCount", 3, 0));
        valueAnimator2.setRepeatMode(g.a(typedArray3, xmlPullParser2, "repeatMode", 4, 1));
        if (typedArray4 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator2;
            String c2 = g.c(typedArray4, xmlPullParser2, "pathData", 1);
            if (c2 != null) {
                String c3 = g.c(typedArray4, xmlPullParser2, "propertyXName", 2);
                String c4 = g.c(typedArray4, xmlPullParser2, "propertyYName", 3);
                if (c3 == null && c4 == null) {
                    throw new InflateException(typedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                a(c.a(c2), objectAnimator, 0.5f * f2, c3, c4);
                return;
            }
            objectAnimator.setPropertyName(g.c(typedArray4, xmlPullParser2, "propertyName", 0));
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f3 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / ((float) (min - 1));
        int i2 = 0;
        float f5 = 0.0f;
        int i3 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i3)).floatValue(), fArr3, (float[]) null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f5 += f4;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f5 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else if (propertyValuesHolder == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, propertyValuesHolder});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.Animator a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r23
            int r12 = r21.getDepth()
            r0 = 0
            r13 = r0
        L_0x000e:
            int r1 = r21.next()
            r2 = 3
            r14 = 0
            if (r1 != r2) goto L_0x001c
            int r2 = r21.getDepth()
            if (r2 <= r12) goto L_0x00e0
        L_0x001c:
            r2 = 1
            if (r1 == r2) goto L_0x00e0
            r3 = 2
            if (r1 != r3) goto L_0x00dc
            java.lang.String r1 = r21.getName()
            java.lang.String r3 = "objectAnimator"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0042
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r22
            r4 = r25
            r5 = r21
            android.animation.ObjectAnimator r0 = a(r0, r1, r2, r3, r4, r5)
        L_0x003e:
            r3 = r18
            goto L_0x00b4
        L_0x0042:
            java.lang.String r3 = "animator"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x005c
            r4 = 0
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r22
            r5 = r25
            r6 = r21
            android.animation.ValueAnimator r0 = a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x003e
        L_0x005c:
            java.lang.String r3 = "set"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0095
            android.animation.AnimatorSet r15 = new android.animation.AnimatorSet
            r15.<init>()
            int[] r0 = androidx.vectordrawable.a.a.a.f4864h
            r7 = r22
            android.content.res.TypedArray r6 = androidx.core.content.b.g.a((android.content.res.Resources) r8, (android.content.res.Resources.Theme) r9, (android.util.AttributeSet) r7, (int[]) r0)
            java.lang.String r0 = "ordering"
            int r16 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r10, (java.lang.String) r0, (int) r14, (int) r14)
            r5 = r15
            android.animation.AnimatorSet r5 = (android.animation.AnimatorSet) r5
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r17 = r6
            r6 = r16
            r7 = r25
            a(r0, r1, r2, r3, r4, r5, r6, r7)
            r17.recycle()
            r3 = r18
            r0 = r15
            goto L_0x00b4
        L_0x0095:
            java.lang.String r3 = "propertyValuesHolder"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c4
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r21)
            r3 = r18
            android.animation.PropertyValuesHolder[] r1 = a((android.content.Context) r3, (android.content.res.Resources) r8, (android.content.res.Resources.Theme) r9, (org.xmlpull.v1.XmlPullParser) r10, (android.util.AttributeSet) r1)
            if (r1 == 0) goto L_0x00b3
            boolean r4 = r0 instanceof android.animation.ValueAnimator
            if (r4 == 0) goto L_0x00b3
            r4 = r0
            android.animation.ValueAnimator r4 = (android.animation.ValueAnimator) r4
            r4.setValues(r1)
        L_0x00b3:
            r14 = 1
        L_0x00b4:
            if (r11 == 0) goto L_0x000e
            if (r14 != 0) goto L_0x000e
            if (r13 != 0) goto L_0x00bf
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x00bf:
            r13.add(r0)
            goto L_0x000e
        L_0x00c4:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown animator name: "
            r1.<init>(r2)
            java.lang.String r2 = r21.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00dc:
            r3 = r18
            goto L_0x000e
        L_0x00e0:
            if (r11 == 0) goto L_0x0109
            if (r13 == 0) goto L_0x0109
            int r1 = r13.size()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            java.util.Iterator r2 = r13.iterator()
        L_0x00ee:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0100
            java.lang.Object r3 = r2.next()
            android.animation.Animator r3 = (android.animation.Animator) r3
            int r4 = r14 + 1
            r1[r14] = r3
            r14 = r4
            goto L_0x00ee
        L_0x0100:
            if (r24 != 0) goto L_0x0106
            r11.playTogether(r1)
            goto L_0x0109
        L_0x0106:
            r11.playSequentially(r1)
        L_0x0109:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        PropertyValuesHolder propertyValuesHolder;
        int size;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3) {
                break;
            }
            int i2 = 1;
            if (eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray a2 = g.a(resources2, theme2, attributeSet, a.f4865i);
                    String c2 = g.c(a2, xmlPullParser2, "propertyName", 3);
                    int i3 = 4;
                    int a3 = g.a(a2, xmlPullParser2, "valueType", 2, 4);
                    int i4 = a3;
                    ArrayList arrayList2 = null;
                    while (true) {
                        int next = xmlPullParser.next();
                        if (next == 3 || next == i2) {
                            Context context2 = context;
                        } else {
                            if (xmlPullParser.getName().equals("keyframe")) {
                                if (i4 == i3) {
                                    TypedArray a4 = g.a(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.j);
                                    TypedValue a5 = g.a(a4, xmlPullParser2, "value");
                                    int i5 = (!(a5 != null) || !a(a5.type)) ? 0 : 3;
                                    a4.recycle();
                                    i4 = i5;
                                }
                                TypedArray a6 = g.a(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.j);
                                float a7 = g.a(a6, xmlPullParser2, "fraction", 3, -1.0f);
                                TypedValue a8 = g.a(a6, xmlPullParser2, "value");
                                boolean z = a8 != null;
                                int i6 = i4 == i3 ? (!z || !a(a8.type)) ? 0 : 3 : i4;
                                if (z) {
                                    if (i6 == 0) {
                                        keyframe = Keyframe.ofFloat(a7, g.a(a6, xmlPullParser2, "value", 0, 0.0f));
                                    } else if (i6 == 1 || i6 == 3) {
                                        keyframe = Keyframe.ofInt(a7, g.a(a6, xmlPullParser2, "value", 0, 0));
                                    } else {
                                        keyframe = null;
                                    }
                                } else if (i6 == 0) {
                                    keyframe = Keyframe.ofFloat(a7);
                                } else {
                                    keyframe = Keyframe.ofInt(a7);
                                }
                                int b2 = g.b(a6, xmlPullParser2, "interpolator", 1);
                                Context context3 = context;
                                if (b2 > 0) {
                                    keyframe.setInterpolator(d.a(context3, b2));
                                }
                                a6.recycle();
                                if (keyframe != null) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(keyframe);
                                }
                                xmlPullParser.next();
                            } else {
                                Context context4 = context;
                            }
                            i2 = 1;
                            i3 = 4;
                        }
                    }
                    Context context22 = context;
                    if (arrayList2 == null || (size = arrayList2.size()) <= 0) {
                        propertyValuesHolder = null;
                    } else {
                        Keyframe keyframe2 = (Keyframe) arrayList2.get(0);
                        Keyframe keyframe3 = (Keyframe) arrayList2.get(size - 1);
                        float fraction = keyframe3.getFraction();
                        if (fraction < 1.0f) {
                            if (fraction < 0.0f) {
                                keyframe3.setFraction(1.0f);
                            } else {
                                arrayList2.add(arrayList2.size(), a(keyframe3, 1.0f));
                                size++;
                            }
                        }
                        float fraction2 = keyframe2.getFraction();
                        if (fraction2 != 0.0f) {
                            if (fraction2 < 0.0f) {
                                keyframe2.setFraction(0.0f);
                            } else {
                                arrayList2.add(0, a(keyframe2, 0.0f));
                                size++;
                            }
                        }
                        Keyframe[] keyframeArr = new Keyframe[size];
                        arrayList2.toArray(keyframeArr);
                        for (int i7 = 0; i7 < size; i7++) {
                            Keyframe keyframe4 = keyframeArr[i7];
                            if (keyframe4.getFraction() < 0.0f) {
                                if (i7 == 0) {
                                    keyframe4.setFraction(0.0f);
                                } else {
                                    int i8 = size - 1;
                                    if (i7 == i8) {
                                        keyframe4.setFraction(1.0f);
                                    } else {
                                        int i9 = i7 + 1;
                                        int i10 = i7;
                                        while (true) {
                                            if (i9 < i8) {
                                                if (keyframeArr[i9].getFraction() >= 0.0f) {
                                                    break;
                                                }
                                                i10 = i9;
                                                i9++;
                                            } else {
                                                break;
                                            }
                                        }
                                        a(keyframeArr, keyframeArr[i10 + 1].getFraction() - keyframeArr[i7 - 1].getFraction(), i7, i10);
                                    }
                                }
                            }
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(c2, keyframeArr);
                        if (i4 == 3) {
                            propertyValuesHolder.setEvaluator(f.a());
                        }
                    }
                    if (propertyValuesHolder == null) {
                        propertyValuesHolder = a(a2, a3, 0, 1, c2);
                    }
                    if (propertyValuesHolder != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolder);
                    }
                    a2.recycle();
                } else {
                    Context context5 = context;
                    AttributeSet attributeSet2 = attributeSet;
                }
                xmlPullParser.next();
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size2 = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            propertyValuesHolderArr[i11] = (PropertyValuesHolder) arrayList.get(i11);
        }
        return propertyValuesHolderArr;
    }

    private static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    private static void a(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((float) ((i3 - i2) + 2));
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.f4863g);
        TypedArray a3 = g.a(resources, theme, attributeSet, a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a2, a3, f2, xmlPullParser);
        int b2 = g.b(a2, xmlPullParser, "interpolator", 0);
        if (b2 > 0) {
            valueAnimator.setInterpolator(d.a(context, b2));
        }
        a2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator;
    }
}
