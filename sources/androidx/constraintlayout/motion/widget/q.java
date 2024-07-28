package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.e;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.upi.util.UpiConstants;
import org.xmlpull.v1.XmlPullParser;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    final MotionLayout f2378a;

    /* renamed from: b  reason: collision with root package name */
    e f2379b = null;

    /* renamed from: c  reason: collision with root package name */
    a f2380c = null;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f2381d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    SparseArray<c> f2382e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    int f2383f = 400;

    /* renamed from: g  reason: collision with root package name */
    int f2384g = 0;

    /* renamed from: h  reason: collision with root package name */
    float f2385h;

    /* renamed from: i  reason: collision with root package name */
    float f2386i;
    private boolean j = false;
    private a k = null;
    private ArrayList<a> l = new ArrayList<>();
    private HashMap<String, Integer> m = new HashMap<>();
    private SparseIntArray n = new SparseIntArray();
    private boolean o = false;
    private MotionEvent p;
    private boolean q = false;
    private boolean r = false;
    private MotionLayout.d s;
    private boolean t;

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.e r0 = r6.f2379b
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.a(r7)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.e r2 = r6.f2379b
            int r2 = r2.a(r8)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r3 = r6.f2381d
            java.util.Iterator r3 = r3.iterator()
        L_0x001e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$a r4 = (androidx.constraintlayout.motion.widget.q.a) r4
            int r5 = r4.f2391c
            if (r5 != r2) goto L_0x0032
            int r5 = r4.f2392d
            if (r5 == r0) goto L_0x003a
        L_0x0032:
            int r5 = r4.f2391c
            if (r5 != r8) goto L_0x001e
            int r5 = r4.f2392d
            if (r5 != r7) goto L_0x001e
        L_0x003a:
            r6.f2380c = r4
            androidx.constraintlayout.motion.widget.q$a r7 = r6.f2380c
            if (r7 == 0) goto L_0x004d
            androidx.constraintlayout.motion.widget.t r7 = r7.l
            if (r7 == 0) goto L_0x004d
            androidx.constraintlayout.motion.widget.q$a r7 = r6.f2380c
            androidx.constraintlayout.motion.widget.t r7 = r7.l
            boolean r8 = r6.t
            r7.a((boolean) r8)
        L_0x004d:
            return
        L_0x004e:
            androidx.constraintlayout.motion.widget.q$a r7 = r6.k
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r3 = r6.l
            java.util.Iterator r3 = r3.iterator()
        L_0x0056:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$a r4 = (androidx.constraintlayout.motion.widget.q.a) r4
            int r5 = r4.f2391c
            if (r5 != r8) goto L_0x0056
            r7 = r4
            goto L_0x0056
        L_0x0068:
            androidx.constraintlayout.motion.widget.q$a r8 = new androidx.constraintlayout.motion.widget.q$a
            r8.<init>(r6, r7)
            r8.f2392d = r0
            r8.f2391c = r2
            if (r0 == r1) goto L_0x0078
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r7 = r6.f2381d
            r7.add(r8)
        L_0x0078:
            r6.f2380c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.a(int, int):void");
    }

    public final void a(a aVar) {
        this.f2380c = aVar;
        a aVar2 = this.f2380c;
        if (aVar2 != null && aVar2.l != null) {
            this.f2380c.l.a(this.t);
        }
    }

    public final void a(MotionLayout motionLayout, int i2) {
        Iterator<a> it2 = this.f2381d.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.m.size() > 0) {
                Iterator<a.C0033a> it3 = next.m.iterator();
                while (it3.hasNext()) {
                    it3.next().a(motionLayout);
                }
            }
        }
        Iterator<a> it4 = this.l.iterator();
        while (it4.hasNext()) {
            a next2 = it4.next();
            if (next2.m.size() > 0) {
                Iterator<a.C0033a> it5 = next2.m.iterator();
                while (it5.hasNext()) {
                    it5.next().a(motionLayout);
                }
            }
        }
        Iterator<a> it6 = this.f2381d.iterator();
        while (it6.hasNext()) {
            a next3 = it6.next();
            if (next3.m.size() > 0) {
                Iterator<a.C0033a> it7 = next3.m.iterator();
                while (it7.hasNext()) {
                    it7.next().a(motionLayout, i2, next3);
                }
            }
        }
        Iterator<a> it8 = this.l.iterator();
        while (it8.hasNext()) {
            a next4 = it8.next();
            if (next4.m.size() > 0) {
                Iterator<a.C0033a> it9 = next4.m.iterator();
                while (it9.hasNext()) {
                    it9.next().a(motionLayout, i2, next4);
                }
            }
        }
    }

    public final void a(boolean z) {
        this.t = z;
        a aVar = this.f2380c;
        if (aVar != null && aVar.l != null) {
            this.f2380c.l.a(this.t);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2389a = -1;

        /* renamed from: b  reason: collision with root package name */
        boolean f2390b = false;

        /* renamed from: c  reason: collision with root package name */
        int f2391c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f2392d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f2393e = 0;

        /* renamed from: f  reason: collision with root package name */
        String f2394f = null;

        /* renamed from: g  reason: collision with root package name */
        int f2395g = -1;

        /* renamed from: h  reason: collision with root package name */
        int f2396h = 400;

        /* renamed from: i  reason: collision with root package name */
        float f2397i = 0.0f;
        final q j;
        ArrayList<h> k = new ArrayList<>();
        t l = null;
        ArrayList<C0033a> m = new ArrayList<>();
        int n = 0;
        boolean o = false;
        int p = -1;
        int q = 0;
        int r = 0;

        public final boolean a() {
            return !this.o;
        }

        /* renamed from: androidx.constraintlayout.motion.widget.q$a$a  reason: collision with other inner class name */
        static class C0033a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            int f2398a = -1;

            /* renamed from: b  reason: collision with root package name */
            int f2399b = 17;

            /* renamed from: c  reason: collision with root package name */
            private final a f2400c;

            public C0033a(Context context, a aVar, XmlPullParser xmlPullParser) {
                this.f2400c = aVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f2398a = obtainStyledAttributes.getResourceId(index, this.f2398a);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f2399b = obtainStyledAttributes.getInt(index, this.f2399b);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public final void a(MotionLayout motionLayout, int i2, a aVar) {
                int i3 = this.f2398a;
                View view = motionLayout;
                if (i3 != -1) {
                    view = motionLayout.findViewById(i3);
                }
                if (view == null) {
                    new StringBuilder("OnClick could not find id ").append(this.f2398a);
                    return;
                }
                int i4 = aVar.f2392d;
                int i5 = aVar.f2391c;
                if (i4 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                boolean z = true;
                boolean z2 = ((this.f2399b & 1) != 0 && i2 == i4) | ((this.f2399b & 1) != 0 && i2 == i4) | ((this.f2399b & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 && i2 == i4) | ((this.f2399b & 16) != 0 && i2 == i5);
                if ((this.f2399b & 4096) == 0 || i2 != i5) {
                    z = false;
                }
                if (z2 || z) {
                    view.setOnClickListener(this);
                }
            }

            public final void a(MotionLayout motionLayout) {
                int i2 = this.f2398a;
                if (i2 != -1) {
                    View findViewById = motionLayout.findViewById(i2);
                    if (findViewById == null) {
                        new StringBuilder(" (*)  could not find id ").append(this.f2398a);
                    } else {
                        findViewById.setOnClickListener((View.OnClickListener) null);
                    }
                }
            }

            public final void onClick(View view) {
                MotionLayout motionLayout = this.f2400c.j.f2378a;
                if (motionLayout.f2254f) {
                    if (this.f2400c.f2392d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.a(this.f2400c.f2391c);
                            return;
                        }
                        a aVar = new a(this.f2400c.j, this.f2400c);
                        aVar.f2392d = currentState;
                        aVar.f2391c = this.f2400c.f2391c;
                        motionLayout.setTransition(aVar);
                        motionLayout.c();
                        return;
                    }
                    a aVar2 = this.f2400c.j.f2380c;
                    int i2 = this.f2399b;
                    boolean z = false;
                    boolean z2 = ((i2 & 1) == 0 && (i2 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) == 0) ? false : true;
                    int i3 = this.f2399b;
                    boolean z3 = ((i3 & 16) == 0 && (i3 & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        a aVar3 = this.f2400c.j.f2380c;
                        a aVar4 = this.f2400c;
                        if (aVar3 != aVar4) {
                            motionLayout.setTransition(aVar4);
                        }
                        if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                            z2 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    a aVar5 = this.f2400c;
                    if (aVar5 != aVar2) {
                        int i4 = aVar5.f2391c;
                        int i5 = this.f2400c.f2392d;
                        if (i5 != -1) {
                        }
                    }
                    z = true;
                    if (!z) {
                        return;
                    }
                    if (z2 && (this.f2399b & 1) != 0) {
                        motionLayout.setTransition(this.f2400c);
                        motionLayout.c();
                    } else if (z3 && (this.f2399b & 16) != 0) {
                        motionLayout.setTransition(this.f2400c);
                        motionLayout.b();
                    } else if (z2 && (this.f2399b & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0) {
                        motionLayout.setTransition(this.f2400c);
                        motionLayout.setProgress(1.0f);
                    } else if (z3 && (this.f2399b & 4096) != 0) {
                        motionLayout.setTransition(this.f2400c);
                        motionLayout.setProgress(0.0f);
                    }
                }
            }
        }

        a(q qVar, a aVar) {
            this.j = qVar;
            if (aVar != null) {
                this.p = aVar.p;
                this.f2393e = aVar.f2393e;
                this.f2394f = aVar.f2394f;
                this.f2395g = aVar.f2395g;
                this.f2396h = aVar.f2396h;
                this.k = aVar.k;
                this.f2397i = aVar.f2397i;
                this.q = aVar.q;
            }
        }

        a(q qVar, Context context, XmlPullParser xmlPullParser) {
            this.f2396h = qVar.f2383f;
            this.q = qVar.f2384g;
            this.j = qVar;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Transition);
            a(qVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        private void a(q qVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f2391c = typedArray.getResourceId(index, this.f2391c);
                    if (Item.KEY_LAYOUT.equals(context.getResources().getResourceTypeName(this.f2391c))) {
                        c cVar = new c();
                        cVar.b(context, this.f2391c);
                        qVar.f2382e.append(this.f2391c, cVar);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f2392d = typedArray.getResourceId(index, this.f2392d);
                    if (Item.KEY_LAYOUT.equals(context.getResources().getResourceTypeName(this.f2392d))) {
                        c cVar2 = new c();
                        cVar2.b(context, this.f2392d);
                        qVar.f2382e.append(this.f2392d, cVar2);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        this.f2395g = typedArray.getResourceId(index, -1);
                        if (this.f2395g != -1) {
                            this.f2393e = -2;
                        }
                    } else if (peekValue.type == 3) {
                        this.f2394f = typedArray.getString(index);
                        if (this.f2394f.indexOf("/") > 0) {
                            this.f2395g = typedArray.getResourceId(index, -1);
                            this.f2393e = -2;
                        } else {
                            this.f2393e = -1;
                        }
                    } else {
                        this.f2393e = typedArray.getInteger(index, this.f2393e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.f2396h = typedArray.getInt(index, this.f2396h);
                } else if (index == R.styleable.Transition_staggered) {
                    this.f2397i = typedArray.getFloat(index, this.f2397i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f2389a = typedArray.getResourceId(index, this.f2389a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f2392d == -1) {
                this.f2390b = true;
            }
        }
    }

    q(Context context, MotionLayout motionLayout, int i2) {
        this.f2378a = motionLayout;
        a(context, i2);
        this.f2382e.put(R.id.motion_base, new c());
        this.m.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            r1 = 0
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x000d:
            r3 = 1
            if (r2 == r3) goto L_0x0153
            if (r2 == 0) goto L_0x014a
            r4 = 2
            if (r2 == r4) goto L_0x0017
            goto L_0x014d
        L_0x0017:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            boolean r5 = r8.o     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r5 == 0) goto L_0x002e
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r6 = "parsing = "
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x002e:
            int r5 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r6 = -1
            r7 = 0
            switch(r5) {
                case -1349929691: goto L_0x0073;
                case -1239391468: goto L_0x0069;
                case 269306229: goto L_0x0060;
                case 312750793: goto L_0x0056;
                case 327855227: goto L_0x004c;
                case 793277014: goto L_0x0042;
                case 1382829617: goto L_0x0038;
                default: goto L_0x0037;
            }     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0037:
            goto L_0x007d
        L_0x0038:
            java.lang.String r3 = "StateSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 4
            goto L_0x007e
        L_0x0042:
            java.lang.String r3 = "MotionScene"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 0
            goto L_0x007e
        L_0x004c:
            java.lang.String r3 = "OnSwipe"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 2
            goto L_0x007e
        L_0x0056:
            java.lang.String r3 = "OnClick"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 3
            goto L_0x007e
        L_0x0060:
            java.lang.String r4 = "Transition"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            goto L_0x007e
        L_0x0069:
            java.lang.String r3 = "KeyFrameSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 6
            goto L_0x007e
        L_0x0073:
            java.lang.String r3 = "ConstraintSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r2 == 0) goto L_0x007d
            r3 = 5
            goto L_0x007e
        L_0x007d:
            r3 = -1
        L_0x007e:
            switch(r3) {
                case 0: goto L_0x0117;
                case 1: goto L_0x00d9;
                case 2: goto L_0x00a9;
                case 3: goto L_0x009d;
                case 4: goto L_0x0094;
                case 5: goto L_0x008f;
                case 6: goto L_0x0083;
                default: goto L_0x0081;
            }     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0081:
            goto L_0x014d
        L_0x0083:
            androidx.constraintlayout.motion.widget.h r2 = new androidx.constraintlayout.motion.widget.h     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.h> r3 = r1.k     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x008f:
            r8.a((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x0094:
            androidx.constraintlayout.widget.e r2 = new androidx.constraintlayout.widget.e     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r8.f2379b = r2     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x009d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a$a> r2 = r1.m     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.q$a$a r3 = new androidx.constraintlayout.motion.widget.q$a$a     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r3.<init>(r9, r1, r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r2.add(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x00a9:
            if (r1 != 0) goto L_0x00ce
            android.content.res.Resources r2 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r2 = r2.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r5 = " OnSwipe ("
            r4.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r2 = ".xml:"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            java.lang.String r2 = ")"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x00ce:
            androidx.constraintlayout.motion.widget.t r2 = new androidx.constraintlayout.motion.widget.t     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f2378a     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r2.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r1.l = r2     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x00d9:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.f2381d     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.q$a r2 = new androidx.constraintlayout.motion.widget.q$a     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f2380c     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 != 0) goto L_0x0100
            boolean r1 = r2.f2390b     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 != 0) goto L_0x0100
            r8.f2380c = r2     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f2380c     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 == 0) goto L_0x0100
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f2380c     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.t r1 = r1.l     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 == 0) goto L_0x0100
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f2380c     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            androidx.constraintlayout.motion.widget.t r1 = r1.l     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            boolean r3 = r8.t     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r1.a((boolean) r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0100:
            boolean r1 = r2.f2390b     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 == 0) goto L_0x0115
            int r1 = r2.f2391c     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r1 != r6) goto L_0x010b
            r8.k = r2     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x0110
        L_0x010b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.l     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0110:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.f2381d     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0115:
            r1 = r2
            goto L_0x014d
        L_0x0117:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            int[] r3 = androidx.constraintlayout.widget.R.styleable.MotionScene     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r2, r3)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            int r3 = r2.getIndexCount()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r4 = 0
        L_0x0126:
            if (r4 >= r3) goto L_0x0146
            int r5 = r2.getIndex(r4)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            int r6 = androidx.constraintlayout.widget.R.styleable.MotionScene_defaultDuration     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r5 != r6) goto L_0x0139
            int r6 = r8.f2383f     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            int r5 = r2.getInt(r5, r6)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r8.f2383f = r5     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x0143
        L_0x0139:
            int r6 = androidx.constraintlayout.widget.R.styleable.MotionScene_layoutDuringTransition     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            if (r5 != r6) goto L_0x0143
            int r5 = r2.getInteger(r5, r7)     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            r8.f2384g = r5     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x0143:
            int r4 = r4 + 1
            goto L_0x0126
        L_0x0146:
            r2.recycle()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x014d
        L_0x014a:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
        L_0x014d:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x0159, IOException -> 0x0154 }
            goto L_0x000d
        L_0x0153:
            return
        L_0x0154:
            r9 = move-exception
            r9.printStackTrace()
            return
        L_0x0159:
            r9 = move-exception
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.a(android.content.Context, int):void");
    }

    private int a(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.o) {
                System.out.println("id getMap res = ".concat(String.valueOf(i2)));
            }
        } else {
            i2 = -1;
        }
        return (i2 != -1 || str == null || str.length() <= 1) ? i2 : Integer.parseInt(str.substring(1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.c r0 = new androidx.constraintlayout.widget.c
            r0.<init>()
            r1 = 0
            r0.f2535b = r1
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x0010:
            r7 = 1
            if (r4 >= r2) goto L_0x007f
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.o
            if (r10 == 0) goto L_0x002e
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.String r11 = java.lang.String.valueOf(r9)
            java.lang.String r12 = "id string = "
            java.lang.String r11 = r12.concat(r11)
            r10.println(r11)
        L_0x002e:
            int r10 = r8.hashCode()
            r11 = -1496482599(0xffffffffa6cd7cd9, float:-1.4258573E-15)
            if (r10 == r11) goto L_0x0046
            r11 = 3355(0xd1b, float:4.701E-42)
            if (r10 == r11) goto L_0x003c
            goto L_0x0050
        L_0x003c:
            java.lang.String r10 = "id"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0050
            r8 = 0
            goto L_0x0051
        L_0x0046:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0050
            r8 = 1
            goto L_0x0051
        L_0x0050:
            r8 = -1
        L_0x0051:
            if (r8 == 0) goto L_0x005b
            if (r8 == r7) goto L_0x0056
            goto L_0x007c
        L_0x0056:
            int r6 = r13.a((android.content.Context) r14, (java.lang.String) r9)
            goto L_0x007c
        L_0x005b:
            int r5 = r13.a((android.content.Context) r14, (java.lang.String) r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.m
            if (r9 != 0) goto L_0x0066
            java.lang.String r9 = ""
            goto L_0x0075
        L_0x0066:
            r8 = 47
            int r8 = r9.indexOf(r8)
            if (r8 >= 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            int r8 = r8 + 1
            java.lang.String r9 = r9.substring(r8)
        L_0x0075:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r7.put(r9, r8)
        L_0x007c:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x007f:
            if (r5 == r3) goto L_0x0098
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.f2378a
            int r1 = r1.n
            if (r1 == 0) goto L_0x0089
            r0.f2534a = r7
        L_0x0089:
            r0.a((android.content.Context) r14, (org.xmlpull.v1.XmlPullParser) r15)
            if (r6 == r3) goto L_0x0093
            android.util.SparseIntArray r14 = r13.n
            r14.put(r5, r6)
        L_0x0093:
            android.util.SparseArray<androidx.constraintlayout.widget.c> r14 = r13.f2382e
            r14.put(r5, r0)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: package-private */
    public final c a(int i2) {
        int a2;
        if (this.o) {
            System.out.println("id ".concat(String.valueOf(i2)));
            PrintStream printStream = System.out;
            printStream.println("size " + this.f2382e.size());
        }
        e eVar = this.f2379b;
        if (!(eVar == null || (a2 = eVar.a(i2)) == -1)) {
            i2 = a2;
        }
        if (this.f2382e.get(i2) != null) {
            return this.f2382e.get(i2);
        }
        StringBuilder sb = new StringBuilder("Warning could not find ConstraintSet id/");
        sb.append(a.a(this.f2378a.getContext(), i2));
        sb.append(" In MotionScene");
        SparseArray<c> sparseArray = this.f2382e;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public final void a(n nVar) {
        a aVar = this.f2380c;
        if (aVar == null) {
            a aVar2 = this.k;
            if (aVar2 != null) {
                Iterator<h> it2 = aVar2.k.iterator();
                while (it2.hasNext()) {
                    it2.next().a(nVar);
                }
                return;
            }
            return;
        }
        Iterator<h> it3 = aVar.k.iterator();
        while (it3.hasNext()) {
            it3.next().a(nVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        Iterator<a> it2 = this.f2381d.iterator();
        while (it2.hasNext()) {
            if (it2.next().l != null) {
                return true;
            }
        }
        a aVar = this.f2380c;
        if (aVar == null || aVar.l == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.d dVar;
        float f2;
        float f3;
        RectF rectF;
        View findViewById;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int i3 = i2;
        MotionLayout motionLayout2 = motionLayout;
        RectF rectF2 = new RectF();
        if (this.s == null) {
            this.s = MotionLayout.a();
        }
        this.s.a(motionEvent3);
        if (i3 != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2385h = motionEvent.getRawX();
                this.f2386i = motionEvent.getRawY();
                this.p = motionEvent3;
                this.q = false;
                if (this.f2380c.l != null) {
                    t tVar = this.f2380c.l;
                    MotionLayout motionLayout3 = this.f2378a;
                    if (tVar.f2424d == -1 || (findViewById = motionLayout3.findViewById(tVar.f2424d)) == null) {
                        rectF = null;
                    } else {
                        rectF2.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
                        rectF = rectF2;
                    }
                    if (rectF == null || rectF.contains(this.p.getX(), this.p.getY())) {
                        RectF a2 = this.f2380c.l.a(this.f2378a, rectF2);
                        if (a2 == null || a2.contains(this.p.getX(), this.p.getY())) {
                            this.r = false;
                        } else {
                            this.r = true;
                        }
                        t tVar2 = this.f2380c.l;
                        float f4 = this.f2385h;
                        float f5 = this.f2386i;
                        tVar2.k = f4;
                        tVar2.l = f5;
                        return;
                    }
                    this.p = null;
                    this.q = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.q) {
                float rawY = motionEvent.getRawY() - this.f2386i;
                float rawX = motionEvent.getRawX() - this.f2385h;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.p) != null) {
                    a a3 = a(i3, rawX, rawY, motionEvent2);
                    if (a3 != null) {
                        motionLayout2.setTransition(a3);
                        RectF a4 = this.f2380c.l.a(this.f2378a, rectF2);
                        this.r = a4 != null && !a4.contains(this.p.getX(), this.p.getY());
                        t tVar3 = this.f2380c.l;
                        float f6 = this.f2385h;
                        float f7 = this.f2386i;
                        tVar3.k = f6;
                        tVar3.l = f7;
                        tVar3.f2429i = false;
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.q) {
            a aVar = this.f2380c;
            if (!(aVar == null || aVar.l == null || this.r)) {
                t tVar4 = this.f2380c.l;
                MotionLayout.d dVar2 = this.s;
                dVar2.a(motionEvent3);
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    tVar4.k = motionEvent.getRawX();
                    tVar4.l = motionEvent.getRawY();
                    tVar4.f2429i = false;
                } else if (action2 == 1) {
                    tVar4.f2429i = false;
                    dVar2.b();
                    float c2 = dVar2.c();
                    float d2 = dVar2.d();
                    float progress = tVar4.m.getProgress();
                    if (tVar4.f2422b != -1) {
                        tVar4.m.a(tVar4.f2422b, progress, tVar4.f2426f, tVar4.f2425e, tVar4.j);
                    } else {
                        float min = (float) Math.min(tVar4.m.getWidth(), tVar4.m.getHeight());
                        tVar4.j[1] = tVar4.f2428h * min;
                        tVar4.j[0] = min * tVar4.f2427g;
                    }
                    if (tVar4.f2427g != 0.0f) {
                        f2 = c2 / tVar4.j[0];
                    } else {
                        f2 = d2 / tVar4.j[1];
                    }
                    float f8 = !Float.isNaN(f2) ? (f2 / 3.0f) + progress : progress;
                    if (f8 != 0.0f && f8 != 1.0f && tVar4.f2421a != 3) {
                        tVar4.m.a(tVar4.f2421a, ((double) f8) < 0.5d ? 0.0f : 1.0f, f2);
                        if (0.0f >= progress || 1.0f <= progress) {
                            tVar4.m.setState(MotionLayout.h.FINISHED);
                        }
                    } else if (0.0f >= f8 || 1.0f <= f8) {
                        tVar4.m.setState(MotionLayout.h.FINISHED);
                    }
                } else if (action2 == 2) {
                    float rawY2 = motionEvent.getRawY() - tVar4.l;
                    float rawX2 = motionEvent.getRawX() - tVar4.k;
                    if (Math.abs((tVar4.f2427g * rawX2) + (tVar4.f2428h * rawY2)) > tVar4.s || tVar4.f2429i) {
                        float progress2 = tVar4.m.getProgress();
                        if (!tVar4.f2429i) {
                            tVar4.f2429i = true;
                            tVar4.m.setProgress(progress2);
                        }
                        if (tVar4.f2422b != -1) {
                            tVar4.m.a(tVar4.f2422b, progress2, tVar4.f2426f, tVar4.f2425e, tVar4.j);
                        } else {
                            float min2 = (float) Math.min(tVar4.m.getWidth(), tVar4.m.getHeight());
                            tVar4.j[1] = tVar4.f2428h * min2;
                            tVar4.j[0] = min2 * tVar4.f2427g;
                        }
                        if (((double) Math.abs(((tVar4.f2427g * tVar4.j[0]) + (tVar4.f2428h * tVar4.j[1])) * tVar4.q)) < 0.01d) {
                            tVar4.j[0] = 0.01f;
                            tVar4.j[1] = 0.01f;
                        }
                        if (tVar4.f2427g != 0.0f) {
                            f3 = rawX2 / tVar4.j[0];
                        } else {
                            f3 = rawY2 / tVar4.j[1];
                        }
                        float max = Math.max(Math.min(progress2 + f3, 1.0f), 0.0f);
                        if (max != tVar4.m.getProgress()) {
                            tVar4.m.setProgress(max);
                            dVar2.b();
                            tVar4.m.f2252d = tVar4.f2427g != 0.0f ? dVar2.c() / tVar4.j[0] : dVar2.d() / tVar4.j[1];
                        } else {
                            tVar4.m.f2252d = 0.0f;
                        }
                        tVar4.k = motionEvent.getRawX();
                        tVar4.l = motionEvent.getRawY();
                    }
                }
            }
            this.f2385h = motionEvent.getRawX();
            this.f2386i = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (dVar = this.s) != null) {
                dVar.a();
                this.s = null;
                if (motionLayout2.f2253e != -1) {
                    b(motionLayout2, motionLayout2.f2253e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        a aVar = this.f2380c;
        if (aVar == null) {
            return -1;
        }
        return aVar.f2392d;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        a aVar = this.f2380c;
        if (aVar == null) {
            return -1;
        }
        return aVar.f2391c;
    }

    public final Interpolator d() {
        switch (this.f2380c.f2393e) {
            case -2:
                return AnimationUtils.loadInterpolator(this.f2378a.getContext(), this.f2380c.f2395g);
            case -1:
                final androidx.constraintlayout.motion.a.c a2 = androidx.constraintlayout.motion.a.c.a(this.f2380c.f2394f);
                return new Interpolator() {
                    public final float getInterpolation(float f2) {
                        return (float) a2.a((double) f2);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new AnticipateInterpolator();
            case 5:
                return new BounceInterpolator();
            default:
                return null;
        }
    }

    public final int e() {
        a aVar = this.f2380c;
        if (aVar != null) {
            return aVar.f2396h;
        }
        return this.f2383f;
    }

    public final float f() {
        a aVar = this.f2380c;
        if (aVar != null) {
            return aVar.f2397i;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final float g() {
        a aVar = this.f2380c;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.f2380c.l.o;
    }

    /* access modifiers changed from: package-private */
    public final float h() {
        a aVar = this.f2380c;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.f2380c.l.n;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        a aVar = this.f2380c;
        if (aVar != null && aVar.l != null) {
            this.f2380c.l.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(MotionLayout motionLayout) {
        int i2 = 0;
        while (i2 < this.f2382e.size()) {
            int keyAt = this.f2382e.keyAt(i2);
            if (!b(keyAt)) {
                c(keyAt);
                i2++;
            } else {
                return;
            }
        }
        for (int i3 = 0; i3 < this.f2382e.size(); i3++) {
            this.f2382e.valueAt(i3).a((ConstraintLayout) motionLayout);
        }
    }

    private boolean b(int i2) {
        int i3 = this.n.get(i2);
        int size = this.n.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.n.get(i3);
            size = i4;
        }
        return false;
    }

    private void c(int i2) {
        int i3 = this.n.get(i2);
        if (i3 > 0) {
            c(this.n.get(i2));
            c cVar = this.f2382e.get(i2);
            c cVar2 = this.f2382e.get(i3);
            if (cVar2 == null) {
                new StringBuilder("ERROR! invalid deriveConstraintsFrom: @id/").append(a.a(this.f2378a.getContext(), i3));
                return;
            }
            cVar.a(cVar2);
            this.n.put(i2, -1);
        }
    }

    private a a(int i2, float f2, float f3, MotionEvent motionEvent) {
        int i3;
        RectF a2;
        if (i2 == -1) {
            return this.f2380c;
        }
        e eVar = this.f2379b;
        if (eVar == null || (i3 = eVar.a(i2)) == -1) {
            i3 = i2;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<a> it2 = this.f2381d.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.f2392d == i3 || next.f2391c == i3) {
                arrayList.add(next);
            }
        }
        float f4 = 0.0f;
        a aVar = null;
        RectF rectF = new RectF();
        for (a aVar2 : arrayList) {
            if (!aVar2.o && aVar2.l != null) {
                aVar2.l.a(this.t);
                RectF a3 = aVar2.l.a(this.f2378a, rectF);
                if ((a3 == null || motionEvent == null || a3.contains(motionEvent.getX(), motionEvent.getY())) && ((a2 = aVar2.l.a(this.f2378a, rectF)) == null || motionEvent == null || a2.contains(motionEvent.getX(), motionEvent.getY()))) {
                    t tVar = aVar2.l;
                    float f5 = ((tVar.f2427g * f2) + (tVar.f2428h * f3)) * (aVar2.f2391c == i2 ? -1.0f : 1.1f);
                    if (f5 > f4) {
                        aVar = aVar2;
                        f4 = f5;
                    }
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(MotionLayout motionLayout, int i2) {
        if ((this.s != null) || this.j) {
            return false;
        }
        Iterator<a> it2 = this.f2381d.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!(next.n == 0 || this.f2380c == next)) {
                if (i2 == next.f2392d && (next.n == 4 || next.n == 2)) {
                    motionLayout.setState(MotionLayout.h.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.n == 4) {
                        motionLayout.c();
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.a(true);
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                        motionLayout.setState(MotionLayout.h.FINISHED);
                        motionLayout.d();
                    }
                    return true;
                } else if (i2 == next.f2391c && (next.n == 3 || next.n == 1)) {
                    motionLayout.setState(MotionLayout.h.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.n == 3) {
                        motionLayout.b();
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.a(true);
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                        motionLayout.setState(MotionLayout.h.FINISHED);
                        motionLayout.d();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
