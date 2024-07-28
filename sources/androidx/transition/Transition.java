package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.content.b.g;
import androidx.core.h.u;
import androidx.transition.a;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    private static ThreadLocal<androidx.a.a<Animator, a>> C = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4690a = {2, 1, 3, 4};
    private static final PathMotion o = new PathMotion() {
        public final Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private ArrayList<y> A;
    private ArrayList<y> B;
    private ViewGroup D = null;
    private int E = 0;
    private boolean F = false;
    private boolean G = false;
    private ArrayList<d> H = null;
    private ArrayList<Animator> I = new ArrayList<>();
    private androidx.a.a<String, String> J;

    /* renamed from: b  reason: collision with root package name */
    long f4691b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f4692c = -1;

    /* renamed from: d  reason: collision with root package name */
    TimeInterpolator f4693d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Integer> f4694e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<View> f4695f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<String> f4696g = null;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<Class<?>> f4697h = null;

    /* renamed from: i  reason: collision with root package name */
    TransitionSet f4698i = null;
    boolean j = false;
    ArrayList<Animator> k = new ArrayList<>();
    w l;
    c m;
    PathMotion n = o;
    private String p = getClass().getName();
    private ArrayList<Integer> q = null;
    private ArrayList<View> r = null;
    private ArrayList<Class<?>> s = null;
    private ArrayList<String> t = null;
    private ArrayList<Integer> u = null;
    private ArrayList<View> v = null;
    private ArrayList<Class<?>> w = null;
    private z x = new z();
    private z y = new z();
    private int[] z = f4690a;

    public static abstract class c {
        public abstract Rect a();
    }

    public interface d {
        void a();

        void a(Transition transition);

        void b();

        void b(Transition transition);

        void c();
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        return null;
    }

    public abstract void a(y yVar);

    public String[] a() {
        return null;
    }

    public abstract void b(y yVar);

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4827c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, AppConstants.DURATION, 1, -1);
        if (a2 >= 0) {
            a(a2);
        }
        long a3 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            b(a3);
        }
        int b2 = g.b(obtainStyledAttributes, xmlResourceParser, "interpolator", 0);
        if (b2 > 0) {
            a((TimeInterpolator) AnimationUtils.loadInterpolator(context, b2));
        }
        String c2 = g.c(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (c2 != null) {
            a(c(c2));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] c(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    public Transition a(long j2) {
        this.f4692c = j2;
        return this;
    }

    public Transition b(long j2) {
        this.f4691b = j2;
        return this;
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.f4693d = timeInterpolator;
        return this;
    }

    private void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.z = f4690a;
            return;
        }
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = iArr[i2];
            if (!(i3 > 0 && i3 <= 4)) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!a(iArr, i2)) {
                i2++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.z = (int[]) iArr.clone();
    }

    private static boolean a(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void a(z zVar, z zVar2) {
        y yVar;
        View view;
        View view2;
        View a2;
        z zVar3 = zVar;
        z zVar4 = zVar2;
        androidx.a.a aVar = new androidx.a.a((androidx.a.g) zVar3.f4853a);
        androidx.a.a aVar2 = new androidx.a.a((androidx.a.g) zVar4.f4853a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.z;
            if (i2 >= iArr.length) {
                break;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                for (int size = aVar.size() - 1; size >= 0; size--) {
                    View view3 = (View) aVar.b(size);
                    if (view3 != null && b(view3) && (yVar = (y) aVar2.remove(view3)) != null && b(yVar.f4851b)) {
                        this.A.add((y) aVar.d(size));
                        this.B.add(yVar);
                    }
                }
            } else if (i3 == 2) {
                androidx.a.a<String, View> aVar3 = zVar3.f4856d;
                androidx.a.a<String, View> aVar4 = zVar4.f4856d;
                int size2 = aVar3.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    View c2 = aVar3.c(i4);
                    if (c2 != null && b(c2) && (view = aVar4.get(aVar3.b(i4))) != null && b(view)) {
                        y yVar2 = (y) aVar.get(c2);
                        y yVar3 = (y) aVar2.get(view);
                        if (!(yVar2 == null || yVar3 == null)) {
                            this.A.add(yVar2);
                            this.B.add(yVar3);
                            aVar.remove(c2);
                            aVar2.remove(view);
                        }
                    }
                }
            } else if (i3 == 3) {
                SparseArray<View> sparseArray = zVar3.f4854b;
                SparseArray<View> sparseArray2 = zVar4.f4854b;
                int size3 = sparseArray.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    View valueAt = sparseArray.valueAt(i5);
                    if (valueAt != null && b(valueAt) && (view2 = sparseArray2.get(sparseArray.keyAt(i5))) != null && b(view2)) {
                        y yVar4 = (y) aVar.get(valueAt);
                        y yVar5 = (y) aVar2.get(view2);
                        if (!(yVar4 == null || yVar5 == null)) {
                            this.A.add(yVar4);
                            this.B.add(yVar5);
                            aVar.remove(valueAt);
                            aVar2.remove(view2);
                        }
                    }
                }
            } else if (i3 == 4) {
                androidx.a.d<View> dVar = zVar3.f4855c;
                androidx.a.d<View> dVar2 = zVar4.f4855c;
                int b2 = dVar.b();
                for (int i6 = 0; i6 < b2; i6++) {
                    View c3 = dVar.c(i6);
                    if (c3 != null && b(c3) && (a2 = dVar2.a(dVar.b(i6), null)) != null && b(a2)) {
                        y yVar6 = (y) aVar.get(c3);
                        y yVar7 = (y) aVar2.get(a2);
                        if (!(yVar6 == null || yVar7 == null)) {
                            this.A.add(yVar6);
                            this.B.add(yVar7);
                            aVar.remove(c3);
                            aVar2.remove(a2);
                        }
                    }
                }
            }
            i2++;
        }
        for (int i7 = 0; i7 < aVar.size(); i7++) {
            y yVar8 = (y) aVar.c(i7);
            if (b(yVar8.f4851b)) {
                this.A.add(yVar8);
                this.B.add((Object) null);
            }
        }
        for (int i8 = 0; i8 < aVar2.size(); i8++) {
            y yVar9 = (y) aVar2.c(i8);
            if (b(yVar9.f4851b)) {
                this.B.add(yVar9);
                this.A.add((Object) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        int i2;
        int i3;
        Animator a2;
        View view;
        Animator animator;
        y yVar;
        Animator animator2;
        y yVar2;
        ViewGroup viewGroup2 = viewGroup;
        androidx.a.a<Animator, a> h2 = h();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            y yVar3 = arrayList.get(i4);
            y yVar4 = arrayList2.get(i4);
            if (yVar3 != null && !yVar3.f4852c.contains(this)) {
                yVar3 = null;
            }
            if (yVar4 != null && !yVar4.f4852c.contains(this)) {
                yVar4 = null;
            }
            if (!(yVar3 == null && yVar4 == null)) {
                if ((yVar3 == null || yVar4 == null || a(yVar3, yVar4)) && (a2 = a(viewGroup2, yVar3, yVar4)) != null) {
                    if (yVar4 != null) {
                        view = yVar4.f4851b;
                        String[] a3 = a();
                        if (a3 != null && a3.length > 0) {
                            yVar2 = new y(view);
                            animator2 = a2;
                            i3 = size;
                            y yVar5 = zVar2.f4853a.get(view);
                            if (yVar5 != null) {
                                int i5 = 0;
                                while (i5 < a3.length) {
                                    yVar2.f4850a.put(a3[i5], yVar5.f4850a.get(a3[i5]));
                                    i5++;
                                    ArrayList<y> arrayList3 = arrayList2;
                                    i4 = i4;
                                    yVar5 = yVar5;
                                }
                            }
                            i2 = i4;
                            int size2 = h2.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    break;
                                }
                                a aVar = h2.get(h2.b(i6));
                                if (aVar.f4704c != null && aVar.f4702a == view && aVar.f4703b.equals(this.p) && aVar.f4704c.equals(yVar2)) {
                                    yVar = yVar2;
                                    animator = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            animator2 = a2;
                            i3 = size;
                            i2 = i4;
                            yVar2 = null;
                        }
                        yVar = yVar2;
                        animator = animator2;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = yVar3.f4851b;
                        animator = a2;
                        yVar = null;
                    }
                    if (animator != null) {
                        w wVar = this.l;
                        if (wVar != null) {
                            long a4 = wVar.a(viewGroup2, this, yVar3, yVar4);
                            sparseIntArray.put(this.I.size(), (int) a4);
                            j2 = Math.min(a4, j2);
                        }
                        h2.put(animator, new a(view, this.p, this, aj.b(viewGroup), yVar));
                        this.I.add(animator);
                        j2 = j2;
                    }
                    i4 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.I.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j2) + animator3.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.q;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.r;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.s;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.t != null && u.x(view) != null && this.t.contains(u.x(view))) {
            return false;
        }
        if ((this.f4694e.size() == 0 && this.f4695f.size() == 0 && (((arrayList = this.f4697h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4696g) == null || arrayList2.isEmpty()))) || this.f4694e.contains(Integer.valueOf(id)) || this.f4695f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f4696g;
        if (arrayList6 != null && arrayList6.contains(u.x(view))) {
            return true;
        }
        if (this.f4697h != null) {
            for (int i3 = 0; i3 < this.f4697h.size(); i3++) {
                if (this.f4697h.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static androidx.a.a<Animator, a> h() {
        androidx.a.a<Animator, a> aVar = C.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.a.a<Animator, a> aVar2 = new androidx.a.a<>();
        C.set(aVar2);
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void b() {
        c();
        final androidx.a.a<Animator, a> h2 = h();
        Iterator<Animator> it2 = this.I.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (h2.containsKey(next)) {
                c();
                if (next != null) {
                    next.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            Transition.this.k.add(animator);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            h2.remove(animator);
                            Transition.this.k.remove(animator);
                        }
                    });
                    if (next == null) {
                        d();
                    } else {
                        long j2 = this.f4692c;
                        if (j2 >= 0) {
                            next.setDuration(j2);
                        }
                        long j3 = this.f4691b;
                        if (j3 >= 0) {
                            next.setStartDelay(j3 + next.getStartDelay());
                        }
                        TimeInterpolator timeInterpolator = this.f4693d;
                        if (timeInterpolator != null) {
                            next.setInterpolator(timeInterpolator);
                        }
                        next.addListener(new AnimatorListenerAdapter() {
                            public final void onAnimationEnd(Animator animator) {
                                Transition.this.d();
                                animator.removeListener(this);
                            }
                        });
                        next.start();
                    }
                }
            }
        }
        this.I.clear();
        d();
    }

    public Transition c(View view) {
        this.f4695f.add(view);
        return this;
    }

    public Transition a(int i2) {
        if (i2 != 0) {
            this.f4694e.add(Integer.valueOf(i2));
        }
        return this;
    }

    public Transition a(String str) {
        if (this.f4696g == null) {
            this.f4696g = new ArrayList<>();
        }
        this.f4696g.add(str);
        return this;
    }

    public Transition a(Class<?> cls) {
        if (this.f4697h == null) {
            this.f4697h = new ArrayList<>();
        }
        this.f4697h.add(cls);
        return this;
    }

    public Transition d(View view) {
        this.f4695f.remove(view);
        return this;
    }

    public Transition a(View view, boolean z2) {
        ArrayList arrayList = this.r;
        if (view != null) {
            if (z2) {
                arrayList = b.a(arrayList, view);
            } else {
                arrayList = b.b(arrayList, view);
            }
        }
        this.r = arrayList;
        return this;
    }

    public Transition a(int i2, boolean z2) {
        ArrayList arrayList = this.q;
        if (i2 > 0) {
            arrayList = z2 ? b.a(arrayList, Integer.valueOf(i2)) : b.b(arrayList, Integer.valueOf(i2));
        }
        this.q = arrayList;
        return this;
    }

    public Transition a(String str, boolean z2) {
        ArrayList arrayList = this.t;
        if (str != null) {
            if (z2) {
                arrayList = b.a(arrayList, str);
            } else {
                arrayList = b.b(arrayList, str);
            }
        }
        this.t = arrayList;
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.transition.Transition a(java.lang.Class<?> r2, boolean r3) {
        /*
            r1 = this;
            java.util.ArrayList<java.lang.Class<?>> r0 = r1.s
            if (r2 == 0) goto L_0x000f
            if (r3 == 0) goto L_0x000b
            java.util.ArrayList r0 = androidx.transition.Transition.b.a(r0, r2)
            goto L_0x000f
        L_0x000b:
            java.util.ArrayList r0 = androidx.transition.Transition.b.b(r0, r2)
        L_0x000f:
            r1.s = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.a(java.lang.Class, boolean):androidx.transition.Transition");
    }

    /* access modifiers changed from: package-private */
    public final void a(ViewGroup viewGroup, boolean z2) {
        androidx.a.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        a(z2);
        if ((this.f4694e.size() > 0 || this.f4695f.size() > 0) && (((arrayList = this.f4696g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4697h) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f4694e.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f4694e.get(i2).intValue());
                if (findViewById != null) {
                    y yVar = new y(findViewById);
                    if (z2) {
                        a(yVar);
                    } else {
                        b(yVar);
                    }
                    yVar.f4852c.add(this);
                    c(yVar);
                    if (z2) {
                        a(this.x, findViewById, yVar);
                    } else {
                        a(this.y, findViewById, yVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f4695f.size(); i3++) {
                View view = this.f4695f.get(i3);
                y yVar2 = new y(view);
                if (z2) {
                    a(yVar2);
                } else {
                    b(yVar2);
                }
                yVar2.f4852c.add(this);
                c(yVar2);
                if (z2) {
                    a(this.x, view, yVar2);
                } else {
                    a(this.y, view, yVar2);
                }
            }
        } else {
            d(viewGroup, z2);
        }
        if (!z2 && (aVar = this.J) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.x.f4856d.remove(this.J.b(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.x.f4856d.put(this.J.c(i5), view2);
                }
            }
        }
    }

    private static void a(z zVar, View view, y yVar) {
        zVar.f4853a.put(view, yVar);
        int id = view.getId();
        if (id >= 0) {
            if (zVar.f4854b.indexOfKey(id) >= 0) {
                zVar.f4854b.put(id, (Object) null);
            } else {
                zVar.f4854b.put(id, view);
            }
        }
        String x2 = u.x(view);
        if (x2 != null) {
            if (zVar.f4856d.containsKey(x2)) {
                zVar.f4856d.put(x2, null);
            } else {
                zVar.f4856d.put(x2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (zVar.f4855c.a(itemIdAtPosition) >= 0) {
                    View a2 = zVar.f4855c.a(itemIdAtPosition, null);
                    if (a2 != null) {
                        u.a(a2, false);
                        zVar.f4855c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                u.a(view, true);
                zVar.f4855c.b(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        if (z2) {
            this.x.f4853a.clear();
            this.x.f4854b.clear();
            this.x.f4855c.d();
            return;
        }
        this.y.f4853a.clear();
        this.y.f4854b.clear();
        this.y.f4855c.d();
    }

    private void d(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.q;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.r;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.s;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.s.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        y yVar = new y(view);
                        if (z2) {
                            a(yVar);
                        } else {
                            b(yVar);
                        }
                        yVar.f4852c.add(this);
                        c(yVar);
                        if (z2) {
                            a(this.x, view, yVar);
                        } else {
                            a(this.y, view, yVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.u;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.v;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.w;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.w.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    d(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final y b(View view, boolean z2) {
        TransitionSet transitionSet = this;
        while (true) {
            TransitionSet transitionSet2 = transitionSet.f4698i;
            if (transitionSet2 == null) {
                break;
            }
            transitionSet = transitionSet2;
        }
        return (z2 ? transitionSet.x : transitionSet.y).f4853a.get(view);
    }

    /* access modifiers changed from: package-private */
    public final y c(View view, boolean z2) {
        TransitionSet transitionSet = this;
        while (true) {
            TransitionSet transitionSet2 = transitionSet.f4698i;
            if (transitionSet2 == null) {
                break;
            }
            transitionSet = transitionSet2;
        }
        ArrayList<y> arrayList = z2 ? transitionSet.A : transitionSet.B;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            y yVar = arrayList.get(i3);
            if (yVar == null) {
                return null;
            }
            if (yVar.f4851b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? transitionSet.B : transitionSet.A).get(i2);
    }

    public void e(View view) {
        int i2;
        if (!this.G) {
            androidx.a.a<Animator, a> h2 = h();
            int size = h2.size();
            at b2 = aj.b(view);
            int i3 = size - 1;
            while (true) {
                i2 = 0;
                if (i3 < 0) {
                    break;
                }
                a c2 = h2.c(i3);
                if (c2.f4702a != null && b2.equals(c2.f4705d)) {
                    Animator b3 = h2.b(i3);
                    if (Build.VERSION.SDK_INT >= 19) {
                        b3.pause();
                    } else {
                        ArrayList<Animator.AnimatorListener> listeners = b3.getListeners();
                        if (listeners != null) {
                            int size2 = listeners.size();
                            while (i2 < size2) {
                                Animator.AnimatorListener animatorListener = listeners.get(i2);
                                if (animatorListener instanceof a.C0074a) {
                                    ((a.C0074a) animatorListener).onAnimationPause(b3);
                                }
                                i2++;
                            }
                        }
                    }
                }
                i3--;
            }
            ArrayList<d> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size3 = arrayList2.size();
                while (i2 < size3) {
                    ((d) arrayList2.get(i2)).b();
                    i2++;
                }
            }
            this.F = true;
        }
    }

    public void f(View view) {
        if (this.F) {
            if (!this.G) {
                androidx.a.a<Animator, a> h2 = h();
                int size = h2.size();
                at b2 = aj.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = h2.c(i2);
                    if (c2.f4702a != null && b2.equals(c2.f4705d)) {
                        Animator b3 = h2.b(i2);
                        if (Build.VERSION.SDK_INT >= 19) {
                            b3.resume();
                        } else {
                            ArrayList<Animator.AnimatorListener> listeners = b3.getListeners();
                            if (listeners != null) {
                                int size2 = listeners.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    Animator.AnimatorListener animatorListener = listeners.get(i3);
                                    if (animatorListener instanceof a.C0074a) {
                                        ((a.C0074a) animatorListener).onAnimationResume(b3);
                                    }
                                }
                            }
                        }
                    }
                }
                ArrayList<d> arrayList = this.H;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.H.clone();
                    int size3 = arrayList2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        ((d) arrayList2.get(i4)).c();
                    }
                }
            }
            this.F = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ViewGroup viewGroup) {
        a aVar;
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        a(this.x, this.y);
        androidx.a.a<Animator, a> h2 = h();
        int size = h2.size();
        at b2 = aj.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b3 = h2.b(i2);
            if (!(b3 == null || (aVar = h2.get(b3)) == null || aVar.f4702a == null || !b2.equals(aVar.f4705d))) {
                y yVar = aVar.f4704c;
                View view = aVar.f4702a;
                y b4 = b(view, true);
                y c2 = c(view, true);
                if (b4 == null && c2 == null) {
                    c2 = this.y.f4853a.get(view);
                }
                if (!(b4 == null && c2 == null) && aVar.f4706e.a(yVar, c2)) {
                    if (b3.isRunning() || b3.isStarted()) {
                        b3.cancel();
                    } else {
                        h2.remove(b3);
                    }
                }
            }
        }
        a(viewGroup, this.x, this.y, this.A, this.B);
        b();
    }

    public boolean a(y yVar, y yVar2) {
        if (!(yVar == null || yVar2 == null)) {
            String[] a2 = a();
            if (a2 != null) {
                for (String a3 : a2) {
                    if (a(yVar, yVar2, a3)) {
                        return true;
                    }
                }
            } else {
                for (String a4 : yVar.f4850a.keySet()) {
                    if (a(yVar, yVar2, a4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean a(y yVar, y yVar2, String str) {
        Object obj = yVar.f4850a.get(str);
        Object obj2 = yVar2.f4850a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.E == 0) {
            ArrayList<d> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).b(this);
                }
            }
            this.G = false;
        }
        this.E++;
    }

    /* access modifiers changed from: protected */
    public final void d() {
        this.E--;
        if (this.E == 0) {
            ArrayList<d> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).a(this);
                }
            }
            for (int i3 = 0; i3 < this.x.f4855c.b(); i3++) {
                View c2 = this.x.f4855c.c(i3);
                if (c2 != null) {
                    u.a(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.y.f4855c.b(); i4++) {
                View c3 = this.y.f4855c.c(i4);
                if (c3 != null) {
                    u.a(c3, false);
                }
            }
            this.G = true;
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            this.k.get(size).cancel();
        }
        ArrayList<d> arrayList = this.H;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.H.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((d) arrayList2.get(i2)).a();
            }
        }
    }

    public Transition a(d dVar) {
        if (this.H == null) {
            this.H = new ArrayList<>();
        }
        this.H.add(dVar);
        return this;
    }

    public Transition b(d dVar) {
        ArrayList<d> arrayList = this.H;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.H.size() == 0) {
            this.H = null;
        }
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.n = o;
        } else {
            this.n = pathMotion;
        }
    }

    public void a(c cVar) {
        this.m = cVar;
    }

    public final Rect f() {
        c cVar = this.m;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    public void a(w wVar) {
        this.l = wVar;
    }

    /* access modifiers changed from: package-private */
    public void c(y yVar) {
        String[] a2;
        if (this.l != null && !yVar.f4850a.isEmpty() && (a2 = this.l.a()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z2 = true;
                    break;
                } else if (!yVar.f4850a.containsKey(a2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.l.a(yVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Transition b(ViewGroup viewGroup) {
        this.D = viewGroup;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.j = z2;
    }

    public String toString() {
        return b("");
    }

    /* renamed from: g */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.I = new ArrayList<>();
            transition.x = new z();
            transition.y = new z();
            transition.A = null;
            transition.B = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String b(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f4692c != -1) {
            str2 = str2 + "dur(" + this.f4692c + ") ";
        }
        if (this.f4691b != -1) {
            str2 = str2 + "dly(" + this.f4691b + ") ";
        }
        if (this.f4693d != null) {
            str2 = str2 + "interp(" + this.f4693d + ") ";
        }
        if (this.f4694e.size() <= 0 && this.f4695f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f4694e.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.f4694e.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f4694e.get(i2);
            }
            str3 = str4;
        }
        if (this.f4695f.size() > 0) {
            for (int i3 = 0; i3 < this.f4695f.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4695f.get(i3);
            }
        }
        return str3 + ")";
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        View f4702a;

        /* renamed from: b  reason: collision with root package name */
        String f4703b;

        /* renamed from: c  reason: collision with root package name */
        y f4704c;

        /* renamed from: d  reason: collision with root package name */
        at f4705d;

        /* renamed from: e  reason: collision with root package name */
        Transition f4706e;

        a(View view, String str, Transition transition, at atVar, y yVar) {
            this.f4702a = view;
            this.f4703b = str;
            this.f4704c = yVar;
            this.f4705d = atVar;
            this.f4706e = transition;
        }
    }

    static class b {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
