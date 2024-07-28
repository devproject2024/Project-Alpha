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

public class k extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f2343g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f2344h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f2345i = Float.NaN;
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
    public int u = 0;
    /* access modifiers changed from: private */
    public float v = Float.NaN;
    /* access modifiers changed from: private */
    public float w = 0.0f;

    public k() {
        this.f2303e = 3;
        this.f2304f = new HashMap();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    public final void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2345i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add(H5Param.PROGRESS);
        }
        if (this.f2304f.size() > 0) {
            for (String valueOf : this.f2304f.keySet()) {
                hashSet.add("CUSTOM,".concat(String.valueOf(valueOf)));
            }
        }
    }

    public final void b(HashMap<String, Integer> hashMap) {
        if (this.f2344h != -1) {
            if (!Float.isNaN(this.f2345i)) {
                hashMap.put("alpha", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.j)) {
                hashMap.put("elevation", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("rotation", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("rotationX", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("rotationY", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("translationX", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.r)) {
                hashMap.put("translationY", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.s)) {
                hashMap.put("translationZ", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("scaleX", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("scaleY", Integer.valueOf(this.f2344h));
            }
            if (!Float.isNaN(this.t)) {
                hashMap.put(H5Param.PROGRESS, Integer.valueOf(this.f2344h));
            }
            if (this.f2304f.size() > 0) {
                for (String valueOf : this.f2304f.keySet()) {
                    hashMap.put("CUSTOM,".concat(String.valueOf(valueOf)), Integer.valueOf(this.f2344h));
                }
            }
        }
    }

    public final void a(HashMap<String, r> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (r1.equals("scaleY") != false) goto L_0x00ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r11) {
        /*
            r10 = this;
            java.util.Set r0 = r11.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01f6
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r11.get(r1)
            r3 = r2
            androidx.constraintlayout.motion.widget.s r3 = (androidx.constraintlayout.motion.widget.s) r3
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r4 = 7
            if (r2 == 0) goto L_0x0042
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r2 = r10.f2304f
            java.lang.Object r1 = r2.get(r1)
            r6 = r1
            androidx.constraintlayout.widget.a r6 = (androidx.constraintlayout.widget.a) r6
            if (r6 == 0) goto L_0x0008
            r4 = r3
            androidx.constraintlayout.motion.widget.s$b r4 = (androidx.constraintlayout.motion.widget.s.b) r4
            int r5 = r10.f2300b
            float r7 = r10.v
            int r8 = r10.u
            float r9 = r10.w
            r4.a((int) r5, (androidx.constraintlayout.widget.a) r6, (float) r7, (int) r8, (float) r9)
            goto L_0x0008
        L_0x0042:
            r2 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00c3;
                case -1249320805: goto L_0x00b9;
                case -1225497657: goto L_0x00ad;
                case -1225497656: goto L_0x00a1;
                case -1225497655: goto L_0x0095;
                case -1001078227: goto L_0x008a;
                case -908189618: goto L_0x0080;
                case -908189617: goto L_0x0077;
                case -40300674: goto L_0x006d;
                case -4379043: goto L_0x0063;
                case 37232917: goto L_0x0057;
                case 92909918: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x00cd
        L_0x004c:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 0
            goto L_0x00ce
        L_0x0057:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 5
            goto L_0x00ce
        L_0x0063:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 1
            goto L_0x00ce
        L_0x006d:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 2
            goto L_0x00ce
        L_0x0077:
            java.lang.String r5 = "scaleY"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00cd
            goto L_0x00ce
        L_0x0080:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 6
            goto L_0x00ce
        L_0x008a:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 11
            goto L_0x00ce
        L_0x0095:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 10
            goto L_0x00ce
        L_0x00a1:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 9
            goto L_0x00ce
        L_0x00ad:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 8
            goto L_0x00ce
        L_0x00b9:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 4
            goto L_0x00ce
        L_0x00c3:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cd
            r4 = 3
            goto L_0x00ce
        L_0x00cd:
            r4 = -1
        L_0x00ce:
            switch(r4) {
                case 0: goto L_0x01df;
                case 1: goto L_0x01c8;
                case 2: goto L_0x01b1;
                case 3: goto L_0x019a;
                case 4: goto L_0x0183;
                case 5: goto L_0x016c;
                case 6: goto L_0x0155;
                case 7: goto L_0x013e;
                case 8: goto L_0x0127;
                case 9: goto L_0x0110;
                case 10: goto L_0x00f9;
                case 11: goto L_0x00e2;
                default: goto L_0x00d1;
            }
        L_0x00d1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            goto L_0x0008
        L_0x00e2:
            float r1 = r10.t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.t
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x00f9:
            float r1 = r10.s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.s
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0110:
            float r1 = r10.r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.r
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0127:
            float r1 = r10.q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.q
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x013e:
            float r1 = r10.p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.p
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0155:
            float r1 = r10.o
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.o
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x016c:
            float r1 = r10.n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.n
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0183:
            float r1 = r10.m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.m
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x019a:
            float r1 = r10.l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.l
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01b1:
            float r1 = r10.k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.k
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01c8:
            float r1 = r10.j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.j
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01df:
            float r1 = r10.f2345i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f2300b
            float r5 = r10.f2345i
            float r6 = r10.v
            int r7 = r10.u
            float r8 = r10.w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.c(java.util.HashMap):void");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2346a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2346a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f2346a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f2346a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f2346a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f2346a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f2346a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f2346a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f2346a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f2346a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f2346a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f2346a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f2346a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f2346a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f2346a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f2346a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f2346a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f2346a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f2346a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f2346a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(k kVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f2346a.get(index)) {
                    case 1:
                        float unused = kVar.f2345i = typedArray.getFloat(index, kVar.f2345i);
                        break;
                    case 2:
                        float unused2 = kVar.j = typedArray.getDimension(index, kVar.j);
                        break;
                    case 4:
                        float unused3 = kVar.k = typedArray.getFloat(index, kVar.k);
                        break;
                    case 5:
                        float unused4 = kVar.l = typedArray.getFloat(index, kVar.l);
                        break;
                    case 6:
                        float unused5 = kVar.m = typedArray.getFloat(index, kVar.m);
                        break;
                    case 7:
                        float unused6 = kVar.o = typedArray.getFloat(index, kVar.o);
                        break;
                    case 8:
                        float unused7 = kVar.n = typedArray.getFloat(index, kVar.n);
                        break;
                    case 9:
                        String unused8 = kVar.f2343g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.f2249a) {
                            if (typedArray.peekValue(index).type != 3) {
                                kVar.f2301c = typedArray.getResourceId(index, kVar.f2301c);
                                break;
                            } else {
                                kVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        } else {
                            kVar.f2301c = typedArray.getResourceId(index, kVar.f2301c);
                            if (kVar.f2301c != -1) {
                                break;
                            } else {
                                kVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        kVar.f2300b = typedArray.getInt(index, kVar.f2300b);
                        break;
                    case 13:
                        int unused9 = kVar.f2344h = typedArray.getInteger(index, kVar.f2344h);
                        break;
                    case 14:
                        float unused10 = kVar.p = typedArray.getFloat(index, kVar.p);
                        break;
                    case 15:
                        float unused11 = kVar.q = typedArray.getDimension(index, kVar.q);
                        break;
                    case 16:
                        float unused12 = kVar.r = typedArray.getDimension(index, kVar.r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = kVar.s = typedArray.getDimension(index, kVar.s);
                            break;
                        }
                    case 18:
                        float unused14 = kVar.t = typedArray.getFloat(index, kVar.t);
                        break;
                    case 19:
                        int unused15 = kVar.u = typedArray.getInt(index, kVar.u);
                        break;
                    case 20:
                        float unused16 = kVar.v = typedArray.getFloat(index, kVar.v);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused17 = kVar.w = typedArray.getFloat(index, kVar.w);
                            break;
                        } else {
                            float unused18 = kVar.w = typedArray.getDimension(index, kVar.w);
                            break;
                        }
                    default:
                        StringBuilder sb = new StringBuilder("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(f2346a.get(index));
                        break;
                }
            }
        }
    }
}
