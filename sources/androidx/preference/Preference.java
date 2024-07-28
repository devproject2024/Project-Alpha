package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.content.b.g;
import androidx.preference.i;
import java.util.ArrayList;
import java.util.List;

public class Preference implements Comparable<Preference> {
    e A;
    private Object B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private List<Preference> K;
    private boolean L;
    private d M;
    private final View.OnClickListener N;

    /* renamed from: a  reason: collision with root package name */
    private e f30783a;

    /* renamed from: b  reason: collision with root package name */
    private long f30784b;

    /* renamed from: c  reason: collision with root package name */
    private b f30785c;

    /* renamed from: d  reason: collision with root package name */
    private int f30786d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f30787e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f30788f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f30789g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30790h;

    /* renamed from: i  reason: collision with root package name */
    private String f30791i;
    Context j;
    i k;
    c l;
    int m;
    CharSequence n;
    int o;
    String p;
    Intent q;
    String r;
    boolean s;
    boolean t;
    boolean u;
    int v;
    int w;
    a x;
    PreferenceGroup y;
    boolean z;

    interface a {
        void a();

        void a(Preference preference);
    }

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a();
    }

    public interface e<T extends Preference> {
        CharSequence a(T t);
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    @Deprecated
    public void a(androidx.core.h.a.c cVar) {
    }

    public /* synthetic */ int compareTo(Object obj) {
        Preference preference = (Preference) obj;
        int i2 = this.m;
        int i3 = preference.m;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.n;
        CharSequence charSequence2 = preference.n;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.n.toString());
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this.m = Integer.MAX_VALUE;
        this.f30786d = 0;
        this.f30789g = true;
        this.f30790h = true;
        this.s = true;
        this.C = true;
        this.D = true;
        this.t = true;
        this.E = true;
        this.F = true;
        this.H = true;
        this.J = true;
        this.v = R.layout.preference;
        this.N = new View.OnClickListener() {
            public final void onClick(View view) {
                Preference.this.a(view);
            }
        };
        this.j = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, 0);
        this.o = g.a(obtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.p = g.b(obtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.n = g.c(obtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.f30787e = g.c(obtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.m = g.a(obtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order);
        this.r = g.b(obtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.v = g.a(obtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, R.layout.preference);
        this.w = g.a(obtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.f30789g = g.a(obtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.f30790h = g.a(obtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.s = g.a(obtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.f30791i = g.b(obtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        int i3 = R.styleable.Preference_allowDividerAbove;
        this.E = g.a(obtainStyledAttributes, i3, i3, this.f30790h);
        int i4 = R.styleable.Preference_allowDividerBelow;
        this.F = g.a(obtainStyledAttributes, i4, i4, this.f30790h);
        if (obtainStyledAttributes.hasValue(R.styleable.Preference_defaultValue)) {
            this.B = a(obtainStyledAttributes, R.styleable.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(R.styleable.Preference_android_defaultValue)) {
            this.B = a(obtainStyledAttributes, R.styleable.Preference_android_defaultValue);
        }
        this.J = g.a(obtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        this.G = obtainStyledAttributes.hasValue(R.styleable.Preference_singleLineTitle);
        if (this.G) {
            this.H = g.a(obtainStyledAttributes, R.styleable.Preference_singleLineTitle, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.I = g.a(obtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        int i5 = R.styleable.Preference_isPreferenceVisible;
        this.t = g.a(obtainStyledAttributes, i5, i5, true);
        int i6 = R.styleable.Preference_enableCopying;
        this.u = g.a(obtainStyledAttributes, i6, i6, false);
        obtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public final e h() {
        e eVar = this.f30783a;
        if (eVar != null) {
            return eVar;
        }
        i iVar = this.k;
        if (iVar != null) {
            return iVar.f30885a;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.k r9) {
        /*
            r8 = this;
            android.view.View r0 = r9.itemView
            android.view.View$OnClickListener r1 = r8.N
            r0.setOnClickListener(r1)
            int r1 = r8.f30786d
            r0.setId(r1)
            r1 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r1 = r9.a(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            r3 = 0
            r4 = 8
            if (r1 == 0) goto L_0x0037
            java.lang.CharSequence r5 = r8.f()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0034
            r1.setText(r5)
            r1.setVisibility(r3)
            int r1 = r1.getCurrentTextColor()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0038
        L_0x0034:
            r1.setVisibility(r4)
        L_0x0037:
            r1 = r2
        L_0x0038:
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r9.a(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0071
            java.lang.CharSequence r6 = r8.n
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x006e
            r5.setText(r6)
            r5.setVisibility(r3)
            boolean r6 = r8.G
            if (r6 == 0) goto L_0x005a
            boolean r6 = r8.H
            r5.setSingleLine(r6)
        L_0x005a:
            boolean r6 = r8.f30790h
            if (r6 != 0) goto L_0x0071
            boolean r6 = r8.i()
            if (r6 == 0) goto L_0x0071
            if (r1 == 0) goto L_0x0071
            int r1 = r1.intValue()
            r5.setTextColor(r1)
            goto L_0x0071
        L_0x006e:
            r5.setVisibility(r4)
        L_0x0071:
            r1 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r1 = r9.a(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r5 = 4
            if (r1 == 0) goto L_0x00ab
            int r6 = r8.o
            if (r6 != 0) goto L_0x0085
            android.graphics.drawable.Drawable r6 = r8.f30788f
            if (r6 == 0) goto L_0x009a
        L_0x0085:
            android.graphics.drawable.Drawable r6 = r8.f30788f
            if (r6 != 0) goto L_0x0093
            android.content.Context r6 = r8.j
            int r7 = r8.o
            android.graphics.drawable.Drawable r6 = androidx.appcompat.a.a.a.b(r6, r7)
            r8.f30788f = r6
        L_0x0093:
            android.graphics.drawable.Drawable r6 = r8.f30788f
            if (r6 == 0) goto L_0x009a
            r1.setImageDrawable(r6)
        L_0x009a:
            android.graphics.drawable.Drawable r6 = r8.f30788f
            if (r6 == 0) goto L_0x00a0
            r6 = 0
            goto L_0x00a8
        L_0x00a0:
            boolean r6 = r8.I
            if (r6 == 0) goto L_0x00a6
            r6 = 4
            goto L_0x00a8
        L_0x00a6:
            r6 = 8
        L_0x00a8:
            r1.setVisibility(r6)
        L_0x00ab:
            int r1 = androidx.preference.R.id.icon_frame
            android.view.View r1 = r9.a(r1)
            if (r1 != 0) goto L_0x00ba
            r1 = 16908350(0x102003e, float:2.3877403E-38)
            android.view.View r1 = r9.a(r1)
        L_0x00ba:
            if (r1 == 0) goto L_0x00cc
            android.graphics.drawable.Drawable r6 = r8.f30788f
            if (r6 == 0) goto L_0x00c1
            goto L_0x00c9
        L_0x00c1:
            boolean r3 = r8.I
            if (r3 == 0) goto L_0x00c7
            r3 = 4
            goto L_0x00c9
        L_0x00c7:
            r3 = 8
        L_0x00c9:
            r1.setVisibility(r3)
        L_0x00cc:
            boolean r1 = r8.J
            if (r1 == 0) goto L_0x00d8
            boolean r1 = r8.i()
            r8.a((android.view.View) r0, (boolean) r1)
            goto L_0x00dc
        L_0x00d8:
            r1 = 1
            r8.a((android.view.View) r0, (boolean) r1)
        L_0x00dc:
            boolean r1 = r8.f30790h
            r0.setFocusable(r1)
            r0.setClickable(r1)
            boolean r3 = r8.E
            r9.f30900a = r3
            boolean r3 = r8.F
            r9.f30901b = r3
            boolean r9 = r8.u
            if (r9 == 0) goto L_0x00fb
            androidx.preference.Preference$d r3 = r8.M
            if (r3 != 0) goto L_0x00fb
            androidx.preference.Preference$d r3 = new androidx.preference.Preference$d
            r3.<init>(r8)
            r8.M = r3
        L_0x00fb:
            if (r9 == 0) goto L_0x0100
            androidx.preference.Preference$d r3 = r8.M
            goto L_0x0101
        L_0x0100:
            r3 = r2
        L_0x0101:
            r0.setOnCreateContextMenuListener(r3)
            r0.setLongClickable(r9)
            if (r9 == 0) goto L_0x010e
            if (r1 != 0) goto L_0x010e
            androidx.core.h.u.a((android.view.View) r0, (android.graphics.drawable.Drawable) r2)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.a(androidx.preference.k):void");
    }

    private void a(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                a(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    public final void b(CharSequence charSequence) {
        if ((charSequence == null && this.n != null) || (charSequence != null && !charSequence.equals(this.n))) {
            this.n = charSequence;
            b();
        }
    }

    public final void a(Drawable drawable) {
        if (this.f30788f != drawable) {
            this.f30788f = drawable;
            this.o = 0;
            b();
        }
    }

    public boolean i() {
        return this.f30789g && this.C && this.D;
    }

    /* access modifiers changed from: package-private */
    public long e() {
        return this.f30784b;
    }

    public final boolean j() {
        return !TextUtils.isEmpty(this.p);
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.k != null && this.s && j();
    }

    public final void a(e eVar) {
        this.A = eVar;
        b();
    }

    public final boolean l() {
        b bVar = this.f30785c;
        return bVar == null || bVar.a();
    }

    /* access modifiers changed from: protected */
    public void b() {
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private <T extends Preference> T a(String str) {
        i iVar = this.k;
        if (iVar == null) {
            return null;
        }
        return iVar.a(str);
    }

    public void a(boolean z2) {
        List<Preference> list = this.K;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).d(z2);
            }
        }
    }

    private void d(boolean z2) {
        if (this.C == z2) {
            this.C = !z2;
            a(c());
            b();
        }
    }

    public final void b(boolean z2) {
        if (this.D == z2) {
            this.D = !z2;
            a(c());
            b();
        }
    }

    public boolean c() {
        return !i();
    }

    /* access modifiers changed from: package-private */
    public final void a(SharedPreferences.Editor editor) {
        if (!this.k.f30886b) {
            editor.apply();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean c(String str) {
        if (!k()) {
            return false;
        }
        String str2 = null;
        if (k() && h() == null) {
            str2 = this.k.a().getString(this.p, (String) null);
        }
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        if (h() == null) {
            SharedPreferences.Editor b2 = this.k.b();
            b2.putString(this.p, str);
            a(b2);
            return true;
        }
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    /* access modifiers changed from: protected */
    public final boolean c(boolean z2) {
        if (!k()) {
            return false;
        }
        boolean z3 = !z2;
        if (k() && h() == null) {
            z3 = this.k.a().getBoolean(this.p, z3);
        }
        if (z2 == z3) {
            return true;
        }
        if (h() == null) {
            SharedPreferences.Editor b2 = this.k.b();
            b2.putBoolean(this.p, z2);
            a(b2);
            return true;
        }
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        if (j()) {
            this.L = false;
            Parcelable d2 = d();
            if (!this.L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (d2 != null) {
                bundle.putParcelable(this.p, d2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable d() {
        this.L = true;
        return BaseSavedState.EMPTY_STATE;
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        Parcelable parcelable;
        if (j() && (parcelable = bundle.getParcelable(this.p)) != null) {
            this.L = false;
            a(parcelable);
            if (!this.L) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Parcelable parcelable) {
        this.L = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new BaseSavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static class d implements MenuItem.OnMenuItemClickListener, View.OnCreateContextMenuListener {

        /* renamed from: a  reason: collision with root package name */
        private final Preference f30793a;

        d(Preference preference) {
            this.f30793a = preference;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence f2 = this.f30793a.f();
            if (this.f30793a.u && !TextUtils.isEmpty(f2)) {
                contextMenu.setHeaderTitle(f2);
                contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            CharSequence f2 = this.f30793a.f();
            ((ClipboardManager) this.f30793a.j.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", f2));
            Toast.makeText(this.f30793a.j, this.f30793a.j.getString(R.string.preference_copied, new Object[]{f2}), 0).show();
            return true;
        }
    }

    public CharSequence f() {
        e eVar = this.A;
        if (eVar != null) {
            return eVar.a(this);
        }
        return this.f30787e;
    }

    public void a(CharSequence charSequence) {
        if (this.A != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.f30787e, charSequence)) {
            this.f30787e = charSequence;
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        Intent intent;
        i.c cVar;
        if (i() && this.f30790h) {
            a();
            c cVar2 = this.l;
            if (cVar2 != null) {
                cVar2.a();
                return;
            }
            i iVar = this.k;
            if ((iVar == null || (cVar = iVar.f30889e) == null || !cVar.d_()) && (intent = this.q) != null) {
                this.j.startActivity(intent);
            }
        }
    }

    public void m() {
        if (!TextUtils.isEmpty(this.f30791i)) {
            Preference a2 = a(this.f30791i);
            if (a2 != null) {
                if (a2.K == null) {
                    a2.K = new ArrayList();
                }
                a2.K.add(this);
                d(a2.c());
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.f30791i + "\" not found for preference \"" + this.p + "\" (title: \"" + this.n + "\"");
        }
    }

    public void n() {
        Preference a2;
        List<Preference> list;
        String str = this.f30791i;
        if (!(str == null || (a2 = a(str)) == null || (list = a2.K) == null)) {
            list.remove(this);
        }
        this.z = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.n;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence f2 = f();
        if (!TextUtils.isEmpty(f2)) {
            sb.append(f2);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
