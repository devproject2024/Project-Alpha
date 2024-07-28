package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import java.util.HashSet;

public class d extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f2305g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f2306h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2307i = false;
    /* access modifiers changed from: private */
    public float j = Float.NaN;
    /* access modifiers changed from: private */
    public float k = Float.NaN;
    /* access modifiers changed from: private */
    public float l = Float.NaN;
    /* access modifiers changed from: private */
    public float m = Float.NaN;
    /* access modifiers changed from: private */
    public float n = Float.NaN;
    /* access modifiers changed from: private */
    public float o = Float.NaN;
    /* access modifiers changed from: private */
    public float p = Float.NaN;
    /* access modifiers changed from: private */
    public float q = Float.NaN;
    /* access modifiers changed from: private */
    public float r = Float.NaN;
    /* access modifiers changed from: private */
    public float s = Float.NaN;
    /* access modifiers changed from: private */
    public float t = Float.NaN;
    /* access modifiers changed from: private */
    public float u = Float.NaN;
    /* access modifiers changed from: private */
    public float v = Float.NaN;
    /* access modifiers changed from: private */
    public float w = Float.NaN;

    public d() {
        this.f2303e = 1;
        this.f2304f = new HashMap();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    public final void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add(H5Param.PROGRESS);
        }
        if (this.f2304f.size() > 0) {
            for (String valueOf : this.f2304f.keySet()) {
                hashSet.add("CUSTOM,".concat(String.valueOf(valueOf)));
            }
        }
    }

    public final void b(HashMap<String, Integer> hashMap) {
        if (this.f2306h != -1) {
            if (!Float.isNaN(this.j)) {
                hashMap.put("alpha", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("elevation", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("rotation", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("rotationX", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("rotationY", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.p)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.t)) {
                hashMap.put("translationX", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.u)) {
                hashMap.put("translationY", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.v)) {
                hashMap.put("translationZ", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.r)) {
                hashMap.put("scaleX", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.s)) {
                hashMap.put("scaleY", Integer.valueOf(this.f2306h));
            }
            if (!Float.isNaN(this.w)) {
                hashMap.put(H5Param.PROGRESS, Integer.valueOf(this.f2306h));
            }
            if (this.f2304f.size() > 0) {
                for (String valueOf : this.f2304f.keySet()) {
                    hashMap.put("CUSTOM,".concat(String.valueOf(valueOf)), Integer.valueOf(this.f2306h));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (r1.equals("transitionPathRotate") != false) goto L_0x00df;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01e1
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            androidx.constraintlayout.motion.widget.r r2 = (androidx.constraintlayout.motion.widget.r) r2
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x0039
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r3 = r6.f2304f
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.a r1 = (androidx.constraintlayout.widget.a) r1
            if (r1 == 0) goto L_0x0008
            androidx.constraintlayout.motion.widget.r$b r2 = (androidx.constraintlayout.motion.widget.r.b) r2
            int r3 = r6.f2300b
            r2.a((int) r3, (androidx.constraintlayout.widget.a) r1)
            goto L_0x0008
        L_0x0039:
            r3 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00d4;
                case -1249320805: goto L_0x00ca;
                case -1225497657: goto L_0x00be;
                case -1225497656: goto L_0x00b2;
                case -1225497655: goto L_0x00a6;
                case -1001078227: goto L_0x009b;
                case -908189618: goto L_0x0090;
                case -908189617: goto L_0x0085;
                case -760884510: goto L_0x007a;
                case -760884509: goto L_0x006f;
                case -40300674: goto L_0x0064;
                case -4379043: goto L_0x0059;
                case 37232917: goto L_0x004e;
                case 92909918: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x00de
        L_0x0043:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 0
            goto L_0x00df
        L_0x004e:
            java.lang.String r5 = "transitionPathRotate"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00de
            goto L_0x00df
        L_0x0059:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 1
            goto L_0x00df
        L_0x0064:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 2
            goto L_0x00df
        L_0x006f:
            java.lang.String r4 = "transformPivotY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 6
            goto L_0x00df
        L_0x007a:
            java.lang.String r4 = "transformPivotX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 5
            goto L_0x00df
        L_0x0085:
            java.lang.String r4 = "scaleY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 9
            goto L_0x00df
        L_0x0090:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 8
            goto L_0x00df
        L_0x009b:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 13
            goto L_0x00df
        L_0x00a6:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 12
            goto L_0x00df
        L_0x00b2:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 11
            goto L_0x00df
        L_0x00be:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 10
            goto L_0x00df
        L_0x00ca:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 4
            goto L_0x00df
        L_0x00d4:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00de
            r4 = 3
            goto L_0x00df
        L_0x00de:
            r4 = -1
        L_0x00df:
            switch(r4) {
                case 0: goto L_0x01d0;
                case 1: goto L_0x01bf;
                case 2: goto L_0x01ae;
                case 3: goto L_0x019d;
                case 4: goto L_0x018c;
                case 5: goto L_0x017b;
                case 6: goto L_0x016a;
                case 7: goto L_0x0159;
                case 8: goto L_0x0148;
                case 9: goto L_0x0137;
                case 10: goto L_0x0126;
                case 11: goto L_0x0115;
                case 12: goto L_0x0104;
                case 13: goto L_0x00f3;
                default: goto L_0x00e2;
            }
        L_0x00e2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            goto L_0x0008
        L_0x00f3:
            float r1 = r6.w
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.w
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0104:
            float r1 = r6.v
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.v
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0115:
            float r1 = r6.u
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.u
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0126:
            float r1 = r6.t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.t
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0137:
            float r1 = r6.s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.s
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0148:
            float r1 = r6.r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.r
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x0159:
            float r1 = r6.q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.q
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x016a:
            float r1 = r6.n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.p
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x017b:
            float r1 = r6.m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.o
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x018c:
            float r1 = r6.n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.n
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x019d:
            float r1 = r6.m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.m
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x01ae:
            float r1 = r6.l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.l
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x01bf:
            float r1 = r6.k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.k
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x01d0:
            float r1 = r6.j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f2300b
            float r3 = r6.j
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.d.a(java.util.HashMap):void");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2308a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2308a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f2308a.append(R.styleable.KeyAttribute_android_elevation, 2);
            f2308a.append(R.styleable.KeyAttribute_android_rotation, 4);
            f2308a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f2308a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f2308a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f2308a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f2308a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f2308a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f2308a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f2308a.append(R.styleable.KeyAttribute_motionTarget, 10);
            f2308a.append(R.styleable.KeyAttribute_framePosition, 12);
            f2308a.append(R.styleable.KeyAttribute_curveFit, 13);
            f2308a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f2308a.append(R.styleable.KeyAttribute_android_translationX, 15);
            f2308a.append(R.styleable.KeyAttribute_android_translationY, 16);
            f2308a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f2308a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(d dVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f2308a.get(index)) {
                    case 1:
                        float unused = dVar.j = typedArray.getFloat(index, dVar.j);
                        break;
                    case 2:
                        float unused2 = dVar.k = typedArray.getDimension(index, dVar.k);
                        break;
                    case 4:
                        float unused3 = dVar.l = typedArray.getFloat(index, dVar.l);
                        break;
                    case 5:
                        float unused4 = dVar.m = typedArray.getFloat(index, dVar.m);
                        break;
                    case 6:
                        float unused5 = dVar.n = typedArray.getFloat(index, dVar.n);
                        break;
                    case 7:
                        float unused6 = dVar.r = typedArray.getFloat(index, dVar.r);
                        break;
                    case 8:
                        float unused7 = dVar.q = typedArray.getFloat(index, dVar.q);
                        break;
                    case 9:
                        String unused8 = dVar.f2305g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.f2249a) {
                            if (typedArray.peekValue(index).type != 3) {
                                dVar.f2301c = typedArray.getResourceId(index, dVar.f2301c);
                                break;
                            } else {
                                dVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        } else {
                            dVar.f2301c = typedArray.getResourceId(index, dVar.f2301c);
                            if (dVar.f2301c != -1) {
                                break;
                            } else {
                                dVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        dVar.f2300b = typedArray.getInt(index, dVar.f2300b);
                        break;
                    case 13:
                        int unused9 = dVar.f2306h = typedArray.getInteger(index, dVar.f2306h);
                        break;
                    case 14:
                        float unused10 = dVar.s = typedArray.getFloat(index, dVar.s);
                        break;
                    case 15:
                        float unused11 = dVar.t = typedArray.getDimension(index, dVar.t);
                        break;
                    case 16:
                        float unused12 = dVar.u = typedArray.getDimension(index, dVar.u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = dVar.v = typedArray.getDimension(index, dVar.v);
                            break;
                        }
                    case 18:
                        float unused14 = dVar.w = typedArray.getFloat(index, dVar.w);
                        break;
                    case 19:
                        float unused15 = dVar.o = typedArray.getDimension(index, dVar.o);
                        break;
                    case 20:
                        float unused16 = dVar.p = typedArray.getDimension(index, dVar.p);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(f2308a.get(index));
                        break;
                }
            }
        }
    }
}
