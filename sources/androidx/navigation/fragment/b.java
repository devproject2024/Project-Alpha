package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.j;
import androidx.navigation.k;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;

@s.b(a = "fragment")
public final class b extends s<a> {

    /* renamed from: b  reason: collision with root package name */
    final j f3887b;

    /* renamed from: c  reason: collision with root package name */
    ArrayDeque<Integer> f3888c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f3889d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Context f3890e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3891f;

    /* renamed from: g  reason: collision with root package name */
    private final j.c f3892g = new j.c() {
        public final void a() {
            if (b.this.f3889d) {
                b bVar = b.this;
                bVar.f3889d = !bVar.f();
                return;
            }
            int f2 = b.this.f3887b.f() + 1;
            if (f2 < b.this.f3888c.size()) {
                while (b.this.f3888c.size() > f2) {
                    b.this.f3888c.removeLast();
                }
                b bVar2 = b.this;
                Iterator<s.c> it2 = bVar2.f3963a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(bVar2);
                }
            }
        }
    };

    /* renamed from: androidx.navigation.fragment.b$b  reason: collision with other inner class name */
    public static final class C0065b implements s.a {

        /* renamed from: a  reason: collision with root package name */
        final LinkedHashMap<View, String> f3895a;
    }

    public b(Context context, j jVar, int i2) {
        this.f3890e = context;
        this.f3887b = jVar;
        this.f3891f = i2;
    }

    public final void d() {
        this.f3887b.a(this.f3892g);
    }

    public final void e() {
        j jVar = this.f3887b;
        j.c cVar = this.f3892g;
        if (jVar.f3430g != null) {
            jVar.f3430g.remove(cVar);
        }
    }

    public final boolean a() {
        if (this.f3888c.isEmpty() || this.f3887b.i()) {
            return false;
        }
        if (this.f3887b.f() > 0) {
            this.f3887b.a(a(this.f3888c.size(), this.f3888c.peekLast().intValue()));
            this.f3889d = true;
        }
        this.f3888c.removeLast();
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0126 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.k a(androidx.navigation.fragment.b.a r9, android.os.Bundle r10, androidx.navigation.p r11, androidx.navigation.s.a r12) {
        /*
            r8 = this;
            androidx.fragment.app.j r0 = r8.f3887b
            boolean r0 = r0.i()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = r9.f3894a
            if (r0 == 0) goto L_0x0127
            java.lang.String r0 = r9.f3894a
            r2 = 0
            char r3 = r0.charAt(r2)
            r4 = 46
            if (r3 != r4) goto L_0x002e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r8.f3890e
            java.lang.String r4 = r4.getPackageName()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x002e:
            android.content.Context r3 = r8.f3890e
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r3, r0, r10)
            r0.setArguments(r10)
            androidx.fragment.app.j r10 = r8.f3887b
            androidx.fragment.app.q r10 = r10.a()
            r3 = -1
            if (r11 == 0) goto L_0x0043
            int r4 = r11.f3943d
            goto L_0x0044
        L_0x0043:
            r4 = -1
        L_0x0044:
            if (r11 == 0) goto L_0x0049
            int r5 = r11.f3944e
            goto L_0x004a
        L_0x0049:
            r5 = -1
        L_0x004a:
            if (r11 == 0) goto L_0x004f
            int r6 = r11.f3945f
            goto L_0x0050
        L_0x004f:
            r6 = -1
        L_0x0050:
            if (r11 == 0) goto L_0x0055
            int r7 = r11.f3946g
            goto L_0x0056
        L_0x0055:
            r7 = -1
        L_0x0056:
            if (r4 != r3) goto L_0x005e
            if (r5 != r3) goto L_0x005e
            if (r6 != r3) goto L_0x005e
            if (r7 == r3) goto L_0x0071
        L_0x005e:
            if (r4 == r3) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            if (r5 == r3) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r5 = 0
        L_0x0066:
            if (r6 == r3) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            if (r7 == r3) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r7 = 0
        L_0x006e:
            r10.a((int) r4, (int) r5, (int) r6, (int) r7)
        L_0x0071:
            int r3 = r8.f3891f
            r10.b(r3, r0, r1)
            r10.e(r0)
            int r0 = r9.f3921e
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.f3888c
            boolean r3 = r3.isEmpty()
            r4 = 1
            if (r11 == 0) goto L_0x009a
            if (r3 != 0) goto L_0x009a
            boolean r11 = r11.f3940a
            if (r11 == 0) goto L_0x009a
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3888c
            java.lang.Object r11 = r11.peekLast()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r11 != r0) goto L_0x009a
            r11 = 1
            goto L_0x009b
        L_0x009a:
            r11 = 0
        L_0x009b:
            if (r3 == 0) goto L_0x009f
        L_0x009d:
            r2 = 1
            goto L_0x00e5
        L_0x009f:
            if (r11 == 0) goto L_0x00d4
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3888c
            int r11 = r11.size()
            if (r11 <= r4) goto L_0x00e5
            androidx.fragment.app.j r11 = r8.f3887b
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.f3888c
            int r3 = r3.size()
            java.util.ArrayDeque<java.lang.Integer> r5 = r8.f3888c
            java.lang.Object r5 = r5.peekLast()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r3 = a(r3, r5)
            r11.a((java.lang.String) r3)
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3888c
            int r11 = r11.size()
            java.lang.String r11 = a(r11, r0)
            r10.a((java.lang.String) r11)
            r8.f3889d = r4
            goto L_0x00e5
        L_0x00d4:
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3888c
            int r11 = r11.size()
            int r11 = r11 + r4
            java.lang.String r11 = a(r11, r0)
            r10.a((java.lang.String) r11)
            r8.f3889d = r4
            goto L_0x009d
        L_0x00e5:
            boolean r11 = r12 instanceof androidx.navigation.fragment.b.C0065b
            if (r11 == 0) goto L_0x0115
            androidx.navigation.fragment.b$b r12 = (androidx.navigation.fragment.b.C0065b) r12
            java.util.LinkedHashMap<android.view.View, java.lang.String> r11 = r12.f3895a
            java.util.Map r11 = java.util.Collections.unmodifiableMap(r11)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00f9:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0115
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r3 = r12.getKey()
            android.view.View r3 = (android.view.View) r3
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            r10.a((android.view.View) r3, (java.lang.String) r12)
            goto L_0x00f9
        L_0x0115:
            r10.s = r4
            r10.b()
            if (r2 == 0) goto L_0x0126
            java.util.ArrayDeque<java.lang.Integer> r10 = r8.f3888c
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            r10.add(r11)
            return r9
        L_0x0126:
            return r1
        L_0x0127:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Fragment class was not set"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.b.a(androidx.navigation.fragment.b$a, android.os.Bundle, androidx.navigation.p, androidx.navigation.s$a):androidx.navigation.k");
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f3888c.size()];
        Iterator<Integer> it2 = this.f3888c.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr[i2] = it2.next().intValue();
            i2++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    public final void a(Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) != null) {
            this.f3888c.clear();
            for (int valueOf : intArray) {
                this.f3888c.add(Integer.valueOf(valueOf));
            }
        }
    }

    private static String a(int i2, int i3) {
        return i2 + "-" + i3;
    }

    private static int a(String str) {
        String[] split = str != null ? str.split("-") : new String[0];
        if (split.length == 2) {
            try {
                Integer.parseInt(split[0]);
                return Integer.parseInt(split[1]);
            } catch (NumberFormatException unused) {
                throw new IllegalStateException("Invalid back stack entry on the NavHostFragment's back stack - use getChildFragmentManager() if you need to do custom FragmentTransactions from within Fragments created via your navigation graph.");
            }
        } else {
            throw new IllegalStateException("Invalid back stack entry on the NavHostFragment's back stack - use getChildFragmentManager() if you need to do custom FragmentTransactions from within Fragments created via your navigation graph.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        int f2 = this.f3887b.f();
        if (this.f3888c.size() != f2 + 1) {
            return false;
        }
        Iterator<Integer> descendingIterator = this.f3888c.descendingIterator();
        int i2 = f2 - 1;
        while (descendingIterator.hasNext() && i2 >= 0) {
            try {
                int i3 = i2 - 1;
                if (descendingIterator.next().intValue() != a(this.f3887b.b(i2).g())) {
                    return false;
                }
                i2 = i3;
            } catch (NumberFormatException unused) {
                throw new IllegalStateException("Invalid back stack entry on the NavHostFragment's back stack - use getChildFragmentManager() if you need to do custom FragmentTransactions from within Fragments created via your navigation graph.");
            }
        }
        return true;
    }

    public static class a extends k {

        /* renamed from: a  reason: collision with root package name */
        String f3894a;

        public a(s<? extends a> sVar) {
            super((s<? extends k>) sVar);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            super.a(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.f3894a = string;
            }
            obtainAttributes.recycle();
        }
    }

    public final /* synthetic */ k b() {
        return new a(this);
    }
}
