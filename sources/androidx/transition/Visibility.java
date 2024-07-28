package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b.g;
import androidx.transition.Transition;
import androidx.transition.a;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {
    private static final String[] o = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: a  reason: collision with root package name */
    int f4711a = 3;

    public Animator a(ViewGroup viewGroup, View view, y yVar) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        return null;
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f4722a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4723b;

        /* renamed from: c  reason: collision with root package name */
        int f4724c;

        /* renamed from: d  reason: collision with root package name */
        int f4725d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f4726e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f4727f;

        b() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4829e);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a2 != 0) {
            b(a2);
        }
    }

    public final void b(int i2) {
        if ((i2 & -4) == 0) {
            this.f4711a = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final String[] a() {
        return o;
    }

    private static void d(y yVar) {
        yVar.f4850a.put("android:visibility:visibility", Integer.valueOf(yVar.f4851b.getVisibility()));
        yVar.f4850a.put("android:visibility:parent", yVar.f4851b.getParent());
        int[] iArr = new int[2];
        yVar.f4851b.getLocationOnScreen(iArr);
        yVar.f4850a.put("android:visibility:screenLocation", iArr);
    }

    public void a(y yVar) {
        d(yVar);
    }

    public void b(y yVar) {
        d(yVar);
    }

    private static b b(y yVar, y yVar2) {
        b bVar = new b();
        bVar.f4722a = false;
        bVar.f4723b = false;
        if (yVar == null || !yVar.f4850a.containsKey("android:visibility:visibility")) {
            bVar.f4724c = -1;
            bVar.f4726e = null;
        } else {
            bVar.f4724c = ((Integer) yVar.f4850a.get("android:visibility:visibility")).intValue();
            bVar.f4726e = (ViewGroup) yVar.f4850a.get("android:visibility:parent");
        }
        if (yVar2 == null || !yVar2.f4850a.containsKey("android:visibility:visibility")) {
            bVar.f4725d = -1;
            bVar.f4727f = null;
        } else {
            bVar.f4725d = ((Integer) yVar2.f4850a.get("android:visibility:visibility")).intValue();
            bVar.f4727f = (ViewGroup) yVar2.f4850a.get("android:visibility:parent");
        }
        if (yVar == null || yVar2 == null) {
            if (yVar == null && bVar.f4725d == 0) {
                bVar.f4723b = true;
                bVar.f4722a = true;
            } else if (yVar2 == null && bVar.f4724c == 0) {
                bVar.f4723b = false;
                bVar.f4722a = true;
            }
        } else if (bVar.f4724c == bVar.f4725d && bVar.f4726e == bVar.f4727f) {
            return bVar;
        } else {
            if (bVar.f4724c != bVar.f4725d) {
                if (bVar.f4724c == 0) {
                    bVar.f4723b = false;
                    bVar.f4722a = true;
                } else if (bVar.f4725d == 0) {
                    bVar.f4723b = true;
                    bVar.f4722a = true;
                }
            } else if (bVar.f4727f == null) {
                bVar.f4723b = false;
                bVar.f4722a = true;
            } else if (bVar.f4726e == null) {
                bVar.f4723b = true;
                bVar.f4722a = true;
            }
        }
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bf, code lost:
        if (r10.j != false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator a(final android.view.ViewGroup r11, androidx.transition.y r12, androidx.transition.y r13) {
        /*
            r10 = this;
            androidx.transition.Visibility$b r0 = b(r12, r13)
            boolean r1 = r0.f4722a
            r2 = 0
            if (r1 == 0) goto L_0x0139
            android.view.ViewGroup r1 = r0.f4726e
            if (r1 != 0) goto L_0x0011
            android.view.ViewGroup r1 = r0.f4727f
            if (r1 == 0) goto L_0x0139
        L_0x0011:
            boolean r1 = r0.f4723b
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0042
            int r0 = r10.f4711a
            r0 = r0 & r4
            if (r0 != r4) goto L_0x0041
            if (r13 != 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            if (r12 != 0) goto L_0x003a
            android.view.View r0 = r13.f4851b
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r0 = (android.view.View) r0
            androidx.transition.y r1 = r10.c(r0, r3)
            androidx.transition.y r0 = r10.b(r0, r3)
            androidx.transition.Visibility$b r0 = b(r1, r0)
            boolean r0 = r0.f4722a
            if (r0 == 0) goto L_0x003a
            return r2
        L_0x003a:
            android.view.View r0 = r13.f4851b
            android.animation.Animator r11 = r10.a(r11, r0, r12, r13)
            return r11
        L_0x0041:
            return r2
        L_0x0042:
            int r0 = r0.f4725d
            int r1 = r10.f4711a
            r5 = 2
            r1 = r1 & r5
            if (r1 != r5) goto L_0x0139
            if (r12 == 0) goto L_0x0139
            android.view.View r1 = r12.f4851b
            if (r13 == 0) goto L_0x0053
            android.view.View r13 = r13.f4851b
            goto L_0x0054
        L_0x0053:
            r13 = r2
        L_0x0054:
            int r6 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r6 = r1.getTag(r6)
            android.view.View r6 = (android.view.View) r6
            if (r6 == 0) goto L_0x0062
            r7 = r2
            r13 = 1
            goto L_0x00c3
        L_0x0062:
            if (r13 == 0) goto L_0x0074
            android.view.ViewParent r6 = r13.getParent()
            if (r6 != 0) goto L_0x006b
            goto L_0x0074
        L_0x006b:
            r6 = 4
            if (r0 != r6) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            if (r1 != r13) goto L_0x007a
        L_0x0071:
            r7 = r13
            r6 = r2
            goto L_0x0078
        L_0x0074:
            if (r13 == 0) goto L_0x007a
            r6 = r13
            r7 = r2
        L_0x0078:
            r13 = 0
            goto L_0x007d
        L_0x007a:
            r6 = r2
            r7 = r6
            r13 = 1
        L_0x007d:
            if (r13 == 0) goto L_0x00c2
            android.view.ViewParent r13 = r1.getParent()
            if (r13 != 0) goto L_0x0086
            goto L_0x00c1
        L_0x0086:
            android.view.ViewParent r13 = r1.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x00c2
            android.view.ViewParent r13 = r1.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.y r8 = r10.b(r13, r4)
            androidx.transition.y r9 = r10.c(r13, r4)
            androidx.transition.Visibility$b r8 = b(r8, r9)
            boolean r8 = r8.f4722a
            if (r8 != 0) goto L_0x00aa
            android.view.View r13 = androidx.transition.x.a(r11, r1, r13)
            r6 = r13
            goto L_0x00c2
        L_0x00aa:
            int r8 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x00c2
            r13 = -1
            if (r8 == r13) goto L_0x00c2
            android.view.View r13 = r11.findViewById(r8)
            if (r13 == 0) goto L_0x00c2
            boolean r13 = r10.j
            if (r13 == 0) goto L_0x00c2
        L_0x00c1:
            r6 = r1
        L_0x00c2:
            r13 = 0
        L_0x00c3:
            if (r6 == 0) goto L_0x0117
            if (r13 != 0) goto L_0x00f9
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f4850a
            java.lang.String r2 = "android:visibility:screenLocation"
            java.lang.Object r0 = r0.get(r2)
            int[] r0 = (int[]) r0
            int[] r0 = (int[]) r0
            r2 = r0[r3]
            r0 = r0[r4]
            int[] r5 = new int[r5]
            r11.getLocationOnScreen(r5)
            r3 = r5[r3]
            int r2 = r2 - r3
            int r3 = r6.getLeft()
            int r2 = r2 - r3
            r6.offsetLeftAndRight(r2)
            r2 = r5[r4]
            int r0 = r0 - r2
            int r2 = r6.getTop()
            int r0 = r0 - r2
            r6.offsetTopAndBottom(r0)
            androidx.transition.ad r0 = androidx.transition.ae.a(r11)
            r0.a(r6)
        L_0x00f9:
            android.animation.Animator r12 = r10.a((android.view.ViewGroup) r11, (android.view.View) r6, (androidx.transition.y) r12)
            if (r13 != 0) goto L_0x0116
            if (r12 != 0) goto L_0x0109
            androidx.transition.ad r11 = androidx.transition.ae.a(r11)
            r11.b(r6)
            goto L_0x0116
        L_0x0109:
            int r13 = androidx.transition.R.id.save_overlay_view
            r1.setTag(r13, r6)
            androidx.transition.Visibility$1 r13 = new androidx.transition.Visibility$1
            r13.<init>(r11, r6, r1)
            r10.a((androidx.transition.Transition.d) r13)
        L_0x0116:
            return r12
        L_0x0117:
            if (r7 == 0) goto L_0x0139
            int r13 = r7.getVisibility()
            androidx.transition.aj.a((android.view.View) r7, (int) r3)
            android.animation.Animator r11 = r10.a((android.view.ViewGroup) r11, (android.view.View) r7, (androidx.transition.y) r12)
            if (r11 == 0) goto L_0x0135
            androidx.transition.Visibility$a r12 = new androidx.transition.Visibility$a
            r12.<init>(r7, r0)
            r11.addListener(r12)
            androidx.transition.a.a(r11, r12)
            r10.a((androidx.transition.Transition.d) r12)
            goto L_0x0138
        L_0x0135:
            androidx.transition.aj.a((android.view.View) r7, (int) r13)
        L_0x0138:
            return r11
        L_0x0139:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.a(android.view.ViewGroup, androidx.transition.y, androidx.transition.y):android.animation.Animator");
    }

    public final boolean a(y yVar, y yVar2) {
        if (yVar == null && yVar2 == null) {
            return false;
        }
        if (yVar != null && yVar2 != null && yVar2.f4850a.containsKey("android:visibility:visibility") != yVar.f4850a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(yVar, yVar2);
        if (!b2.f4722a || (b2.f4724c != 0 && b2.f4725d != 0)) {
            return false;
        }
        return true;
    }

    static class a extends AnimatorListenerAdapter implements Transition.d, a.C0074a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4716a = false;

        /* renamed from: b  reason: collision with root package name */
        private final View f4717b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4718c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f4719d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f4720e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4721f;

        public final void a() {
        }

        public final void b(Transition transition) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        a(View view, int i2) {
            this.f4717b = view;
            this.f4718c = i2;
            this.f4719d = (ViewGroup) view.getParent();
            this.f4720e = true;
            a(true);
        }

        public final void onAnimationPause(Animator animator) {
            if (!this.f4716a) {
                aj.a(this.f4717b, this.f4718c);
            }
        }

        public final void onAnimationResume(Animator animator) {
            if (!this.f4716a) {
                aj.a(this.f4717b, 0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f4716a = true;
        }

        public final void onAnimationEnd(Animator animator) {
            d();
        }

        public final void a(Transition transition) {
            d();
            transition.b((Transition.d) this);
        }

        public final void b() {
            a(false);
        }

        public final void c() {
            a(true);
        }

        private void d() {
            if (!this.f4716a) {
                aj.a(this.f4717b, this.f4718c);
                ViewGroup viewGroup = this.f4719d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (this.f4720e && this.f4721f != z && (viewGroup = this.f4719d) != null) {
                this.f4721f = z;
                ae.a(viewGroup, z);
            }
        }
    }
}
