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

public class f extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f2310g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f2311h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f2312i = -1;
    /* access modifiers changed from: private */
    public float j = Float.NaN;
    /* access modifiers changed from: private */
    public float k = 0.0f;
    /* access modifiers changed from: private */
    public float l = Float.NaN;
    /* access modifiers changed from: private */
    public int m = -1;
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
    /* access modifiers changed from: private */
    public float x = Float.NaN;

    public f() {
        this.f2303e = 4;
        this.f2304f = new HashMap();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    public final void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.n)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.x)) {
            hashSet.add("translationZ");
        }
        if (this.f2304f.size() > 0) {
            for (String valueOf : this.f2304f.keySet()) {
                hashSet.add("CUSTOM,".concat(String.valueOf(valueOf)));
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        if (r1.equals("scaleY") != false) goto L_0x00e4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r12) {
        /*
            r11 = this;
            java.util.Set r0 = r12.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0138
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r3 = 7
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r1.substring(r3)
            java.util.HashMap r3 = r11.f2304f
            java.lang.Object r2 = r3.get(r2)
            r10 = r2
            androidx.constraintlayout.widget.a r10 = (androidx.constraintlayout.widget.a) r10
            if (r10 == 0) goto L_0x0008
            androidx.constraintlayout.widget.a$a r2 = r10.f2508b
            androidx.constraintlayout.widget.a$a r3 = androidx.constraintlayout.widget.a.C0034a.FLOAT_TYPE
            if (r2 != r3) goto L_0x0008
            java.lang.Object r1 = r12.get(r1)
            r3 = r1
            androidx.constraintlayout.motion.widget.g r3 = (androidx.constraintlayout.motion.widget.g) r3
            int r4 = r11.f2300b
            int r5 = r11.f2312i
            int r6 = r11.m
            float r7 = r11.j
            float r8 = r11.k
            float r9 = r10.b()
            r3.a(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0008
        L_0x004b:
            int r2 = r1.hashCode()
            r4 = -1
            switch(r2) {
                case -1249320806: goto L_0x00d9;
                case -1249320805: goto L_0x00cf;
                case -1225497657: goto L_0x00c3;
                case -1225497656: goto L_0x00b7;
                case -1225497655: goto L_0x00ab;
                case -1001078227: goto L_0x00a0;
                case -908189618: goto L_0x0096;
                case -908189617: goto L_0x008d;
                case -40300674: goto L_0x0083;
                case -4379043: goto L_0x0079;
                case 37232917: goto L_0x006d;
                case 92909918: goto L_0x0062;
                case 156108012: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x00e3
        L_0x0055:
            java.lang.String r2 = "waveOffset"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 11
            goto L_0x00e4
        L_0x0062:
            java.lang.String r2 = "alpha"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 0
            goto L_0x00e4
        L_0x006d:
            java.lang.String r2 = "transitionPathRotate"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 5
            goto L_0x00e4
        L_0x0079:
            java.lang.String r2 = "elevation"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 1
            goto L_0x00e4
        L_0x0083:
            java.lang.String r2 = "rotation"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 2
            goto L_0x00e4
        L_0x008d:
            java.lang.String r2 = "scaleY"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x0096:
            java.lang.String r2 = "scaleX"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 6
            goto L_0x00e4
        L_0x00a0:
            java.lang.String r2 = "progress"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 12
            goto L_0x00e4
        L_0x00ab:
            java.lang.String r2 = "translationZ"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 10
            goto L_0x00e4
        L_0x00b7:
            java.lang.String r2 = "translationY"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 9
            goto L_0x00e4
        L_0x00c3:
            java.lang.String r2 = "translationX"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 8
            goto L_0x00e4
        L_0x00cf:
            java.lang.String r2 = "rotationY"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 4
            goto L_0x00e4
        L_0x00d9:
            java.lang.String r2 = "rotationX"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00e3
            r3 = 3
            goto L_0x00e4
        L_0x00e3:
            r3 = -1
        L_0x00e4:
            switch(r3) {
                case 0: goto L_0x010e;
                case 1: goto L_0x010b;
                case 2: goto L_0x0108;
                case 3: goto L_0x0105;
                case 4: goto L_0x0102;
                case 5: goto L_0x00ff;
                case 6: goto L_0x00fc;
                case 7: goto L_0x00f9;
                case 8: goto L_0x00f6;
                case 9: goto L_0x00f3;
                case 10: goto L_0x00f0;
                case 11: goto L_0x00ed;
                case 12: goto L_0x00ea;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            r2 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0110
        L_0x00ea:
            float r2 = r11.l
            goto L_0x0110
        L_0x00ed:
            float r2 = r11.k
            goto L_0x0110
        L_0x00f0:
            float r2 = r11.x
            goto L_0x0110
        L_0x00f3:
            float r2 = r11.w
            goto L_0x0110
        L_0x00f6:
            float r2 = r11.v
            goto L_0x0110
        L_0x00f9:
            float r2 = r11.u
            goto L_0x0110
        L_0x00fc:
            float r2 = r11.t
            goto L_0x0110
        L_0x00ff:
            float r2 = r11.q
            goto L_0x0110
        L_0x0102:
            float r2 = r11.s
            goto L_0x0110
        L_0x0105:
            float r2 = r11.r
            goto L_0x0110
        L_0x0108:
            float r2 = r11.p
            goto L_0x0110
        L_0x010b:
            float r2 = r11.o
            goto L_0x0110
        L_0x010e:
            float r2 = r11.n
        L_0x0110:
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x0008
            java.lang.Object r1 = r12.get(r1)
            androidx.constraintlayout.motion.widget.g r1 = (androidx.constraintlayout.motion.widget.g) r1
            int r3 = r11.f2300b
            int r5 = r11.f2312i
            int r6 = r11.m
            float r7 = r11.j
            float r8 = r11.k
            java.util.ArrayList<androidx.constraintlayout.motion.widget.g$o> r9 = r1.f2318e
            androidx.constraintlayout.motion.widget.g$o r10 = new androidx.constraintlayout.motion.widget.g$o
            r10.<init>(r3, r7, r8, r2)
            r9.add(r10)
            if (r6 == r4) goto L_0x0134
            r1.f2317d = r6
        L_0x0134:
            r1.f2316c = r5
            goto L_0x0008
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.f.c(java.util.HashMap):void");
    }

    public final void a(HashMap<String, r> hashMap) {
        a.a("add " + hashMap.size() + " values");
        for (String next : hashMap.keySet()) {
            r rVar = hashMap.get(next);
            char c2 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals(H5Param.PROGRESS)) {
                        c2 = 12;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 156108012:
                    if (next.equals("waveOffset")) {
                        c2 = 11;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    rVar.a(this.f2300b, this.n);
                    break;
                case 1:
                    rVar.a(this.f2300b, this.o);
                    break;
                case 2:
                    rVar.a(this.f2300b, this.p);
                    break;
                case 3:
                    rVar.a(this.f2300b, this.r);
                    break;
                case 4:
                    rVar.a(this.f2300b, this.s);
                    break;
                case 5:
                    rVar.a(this.f2300b, this.q);
                    break;
                case 6:
                    rVar.a(this.f2300b, this.t);
                    break;
                case 7:
                    rVar.a(this.f2300b, this.u);
                    break;
                case 8:
                    rVar.a(this.f2300b, this.v);
                    break;
                case 9:
                    rVar.a(this.f2300b, this.w);
                    break;
                case 10:
                    rVar.a(this.f2300b, this.x);
                    break;
                case 11:
                    rVar.a(this.f2300b, this.k);
                    break;
                case 12:
                    rVar.a(this.f2300b, this.l);
                    break;
            }
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2313a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2313a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f2313a.append(R.styleable.KeyCycle_framePosition, 2);
            f2313a.append(R.styleable.KeyCycle_transitionEasing, 3);
            f2313a.append(R.styleable.KeyCycle_curveFit, 4);
            f2313a.append(R.styleable.KeyCycle_waveShape, 5);
            f2313a.append(R.styleable.KeyCycle_wavePeriod, 6);
            f2313a.append(R.styleable.KeyCycle_waveOffset, 7);
            f2313a.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f2313a.append(R.styleable.KeyCycle_android_alpha, 9);
            f2313a.append(R.styleable.KeyCycle_android_elevation, 10);
            f2313a.append(R.styleable.KeyCycle_android_rotation, 11);
            f2313a.append(R.styleable.KeyCycle_android_rotationX, 12);
            f2313a.append(R.styleable.KeyCycle_android_rotationY, 13);
            f2313a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f2313a.append(R.styleable.KeyCycle_android_scaleX, 15);
            f2313a.append(R.styleable.KeyCycle_android_scaleY, 16);
            f2313a.append(R.styleable.KeyCycle_android_translationX, 17);
            f2313a.append(R.styleable.KeyCycle_android_translationY, 18);
            f2313a.append(R.styleable.KeyCycle_android_translationZ, 19);
            f2313a.append(R.styleable.KeyCycle_motionProgress, 20);
        }

        static /* synthetic */ void a(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f2313a.get(index)) {
                    case 1:
                        if (!MotionLayout.f2249a) {
                            if (typedArray.peekValue(index).type != 3) {
                                fVar.f2301c = typedArray.getResourceId(index, fVar.f2301c);
                                break;
                            } else {
                                fVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        } else {
                            fVar.f2301c = typedArray.getResourceId(index, fVar.f2301c);
                            if (fVar.f2301c != -1) {
                                break;
                            } else {
                                fVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        fVar.f2300b = typedArray.getInt(index, fVar.f2300b);
                        break;
                    case 3:
                        String unused = fVar.f2310g = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = fVar.f2311h = typedArray.getInteger(index, fVar.f2311h);
                        break;
                    case 5:
                        int unused3 = fVar.f2312i = typedArray.getInt(index, fVar.f2312i);
                        break;
                    case 6:
                        float unused4 = fVar.j = typedArray.getFloat(index, fVar.j);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused5 = fVar.k = typedArray.getFloat(index, fVar.k);
                            break;
                        } else {
                            float unused6 = fVar.k = typedArray.getDimension(index, fVar.k);
                            break;
                        }
                    case 8:
                        int unused7 = fVar.m = typedArray.getInt(index, fVar.m);
                        break;
                    case 9:
                        float unused8 = fVar.n = typedArray.getFloat(index, fVar.n);
                        break;
                    case 10:
                        float unused9 = fVar.o = typedArray.getDimension(index, fVar.o);
                        break;
                    case 11:
                        float unused10 = fVar.p = typedArray.getFloat(index, fVar.p);
                        break;
                    case 12:
                        float unused11 = fVar.r = typedArray.getFloat(index, fVar.r);
                        break;
                    case 13:
                        float unused12 = fVar.s = typedArray.getFloat(index, fVar.s);
                        break;
                    case 14:
                        float unused13 = fVar.q = typedArray.getFloat(index, fVar.q);
                        break;
                    case 15:
                        float unused14 = fVar.t = typedArray.getFloat(index, fVar.t);
                        break;
                    case 16:
                        float unused15 = fVar.u = typedArray.getFloat(index, fVar.u);
                        break;
                    case 17:
                        float unused16 = fVar.v = typedArray.getDimension(index, fVar.v);
                        break;
                    case 18:
                        float unused17 = fVar.w = typedArray.getDimension(index, fVar.w);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused18 = fVar.x = typedArray.getDimension(index, fVar.x);
                            break;
                        }
                    case 20:
                        float unused19 = fVar.l = typedArray.getFloat(index, fVar.l);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(f2313a.get(index));
                        break;
                }
            }
        }
    }
}
