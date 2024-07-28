package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.b;
import java.util.ArrayList;

final class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    private final SparseBooleanArray A = new SparseBooleanArray();
    private b B;

    /* renamed from: i  reason: collision with root package name */
    d f1418i;
    Drawable j;
    boolean k;
    boolean l;
    e m;
    a n;
    c o;
    final f p = new f();
    int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    public final void a(Context context, g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.s) {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT < 19 && ViewConfiguration.get(a2.f1209a).hasPermanentMenuKey()) {
                z2 = false;
            }
            this.r = z2;
        }
        if (!this.y) {
            this.t = a2.f1209a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.w) {
            this.v = a2.a();
        }
        int i2 = this.t;
        if (this.r) {
            if (this.f1418i == null) {
                this.f1418i = new d(this.f1288a);
                if (this.k) {
                    this.f1418i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1418i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f1418i.getMeasuredWidth();
        } else {
            this.f1418i = null;
        }
        this.u = i2;
        this.z = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public final void c() {
        if (!this.w) {
            this.v = androidx.appcompat.view.a.a(this.f1289b).a();
        }
        if (this.f1290c != null) {
            this.f1290c.b(true);
        }
    }

    public final void d() {
        this.r = true;
        this.s = true;
    }

    public final n a(ViewGroup viewGroup) {
        n nVar = this.f1294g;
        n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    public final View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public final void a(i iVar, n.a aVar) {
        aVar.a(iVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1294g);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    public final boolean a(i iVar) {
        return iVar.f();
    }

    public final void a(boolean z2) {
        super.a(z2);
        ((View) this.f1294g).requestLayout();
        boolean z3 = false;
        if (this.f1290c != null) {
            g gVar = this.f1290c;
            gVar.j();
            ArrayList<i> arrayList = gVar.f1338d;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.h.b bVar = arrayList.get(i2).f1352e;
                if (bVar != null) {
                    bVar.f3078d = this;
                }
            }
        }
        ArrayList<i> k2 = this.f1290c != null ? this.f1290c.k() : null;
        if (this.r && k2 != null) {
            int size2 = k2.size();
            if (size2 == 1) {
                z3 = !k2.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f1418i == null) {
                this.f1418i = new d(this.f1288a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1418i.getParent();
            if (viewGroup != this.f1294g) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1418i);
                }
                ((ActionMenuView) this.f1294g).addView(this.f1418i, ActionMenuView.a());
            }
        } else {
            d dVar = this.f1418i;
            if (dVar != null && dVar.getParent() == this.f1294g) {
                ((ViewGroup) this.f1294g).removeView(this.f1418i);
            }
        }
        ((ActionMenuView) this.f1294g).setOverflowReserved(this.r);
    }

    public final boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f1418i) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(androidx.appcompat.view.menu.r r8) {
        /*
            r7 = this;
            boolean r0 = r8.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = r8
        L_0x0009:
            androidx.appcompat.view.menu.g r2 = r0.l
            androidx.appcompat.view.menu.g r3 = r7.f1290c
            if (r2 == r3) goto L_0x0014
            androidx.appcompat.view.menu.g r0 = r0.l
            androidx.appcompat.view.menu.r r0 = (androidx.appcompat.view.menu.r) r0
            goto L_0x0009
        L_0x0014:
            android.view.MenuItem r0 = r0.getItem()
            androidx.appcompat.view.menu.n r2 = r7.f1294g
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 == 0) goto L_0x003a
            int r3 = r2.getChildCount()
            r4 = 0
        L_0x0023:
            if (r4 >= r3) goto L_0x003a
            android.view.View r5 = r2.getChildAt(r4)
            boolean r6 = r5 instanceof androidx.appcompat.view.menu.n.a
            if (r6 == 0) goto L_0x0037
            r6 = r5
            androidx.appcompat.view.menu.n$a r6 = (androidx.appcompat.view.menu.n.a) r6
            androidx.appcompat.view.menu.i r6 = r6.getItemData()
            if (r6 != r0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x003a:
            r5 = 0
        L_0x003b:
            if (r5 != 0) goto L_0x003e
            return r1
        L_0x003e:
            android.view.MenuItem r0 = r8.getItem()
            int r0 = r0.getItemId()
            r7.q = r0
            int r0 = r8.size()
            r2 = 0
        L_0x004d:
            r3 = 1
            if (r2 >= r0) goto L_0x0065
            android.view.MenuItem r4 = r8.getItem(r2)
            boolean r6 = r4.isVisible()
            if (r6 == 0) goto L_0x0062
            android.graphics.drawable.Drawable r4 = r4.getIcon()
            if (r4 == 0) goto L_0x0062
            r1 = 1
            goto L_0x0065
        L_0x0062:
            int r2 = r2 + 1
            goto L_0x004d
        L_0x0065:
            androidx.appcompat.widget.ActionMenuPresenter$a r0 = new androidx.appcompat.widget.ActionMenuPresenter$a
            android.content.Context r2 = r7.f1289b
            r0.<init>(r2, r8, r5)
            r7.n = r0
            androidx.appcompat.widget.ActionMenuPresenter$a r0 = r7.n
            r0.a((boolean) r1)
            androidx.appcompat.widget.ActionMenuPresenter$a r0 = r7.n
            r0.a()
            super.a((androidx.appcompat.view.menu.r) r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.a(androidx.appcompat.view.menu.r):boolean");
    }

    public final boolean e() {
        if (!this.r || j() || this.f1290c == null || this.f1294g == null || this.o != null || this.f1290c.k().isEmpty()) {
            return false;
        }
        this.o = new c(new e(this.f1289b, this.f1290c, this.f1418i));
        ((View) this.f1294g).post(this.o);
        return true;
    }

    public final boolean g() {
        if (this.o == null || this.f1294g == null) {
            e eVar = this.m;
            if (eVar == null) {
                return false;
            }
            eVar.d();
            return true;
        }
        ((View) this.f1294g).removeCallbacks(this.o);
        this.o = null;
        return true;
    }

    public final boolean h() {
        return g() | i();
    }

    public final boolean i() {
        a aVar = this.n;
        if (aVar == null) {
            return false;
        }
        aVar.d();
        return true;
    }

    public final boolean j() {
        e eVar = this.m;
        return eVar != null && eVar.f();
    }

    public final boolean a() {
        int i2;
        ArrayList<i> arrayList;
        int i3;
        int i4;
        int i5;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        int i6 = 0;
        if (actionMenuPresenter.f1290c != null) {
            arrayList = actionMenuPresenter.f1290c.i();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.v;
        int i8 = actionMenuPresenter.u;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1294g;
        int i9 = i7;
        boolean z2 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            i iVar = arrayList.get(i12);
            if (iVar.h()) {
                i10++;
            } else if (iVar.g()) {
                i11++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.l && iVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (actionMenuPresenter.r && (z2 || i11 + i10 > i9)) {
            i9--;
        }
        int i13 = i9 - i10;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.A;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.x) {
            int i14 = actionMenuPresenter.z;
            i3 = i8 / i14;
            i4 = i14 + ((i8 % i14) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i15 = i8;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i2) {
            i iVar2 = arrayList.get(i16);
            if (iVar2.h()) {
                View a2 = actionMenuPresenter.a(iVar2, view, viewGroup);
                if (actionMenuPresenter.x) {
                    i3 -= ActionMenuView.a(a2, i4, i3, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i17 != 0) {
                    measuredWidth = i17;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.c(true);
                i17 = measuredWidth;
                i5 = i2;
            } else if (iVar2.g()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i13 > 0 || z3) && i15 > 0 && (!actionMenuPresenter.x || i3 > 0);
                boolean z5 = z4;
                i5 = i2;
                if (z4) {
                    View a3 = actionMenuPresenter.a(iVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.x) {
                        int a4 = ActionMenuView.a(a3, i4, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        z5 = a4 == 0 ? false : z5;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z4 = z5 & (!actionMenuPresenter.x ? i15 + i17 > 0 : i15 >= 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i18 = 0;
                    while (i18 < i16) {
                        i iVar3 = arrayList.get(i18);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.f()) {
                                i13++;
                            }
                            iVar3.c(false);
                        }
                        i18++;
                    }
                }
                if (z4) {
                    i13--;
                }
                iVar2.c(z4);
            } else {
                i5 = i2;
                iVar2.c(false);
                i16++;
                actionMenuPresenter = this;
                i2 = i5;
                view = null;
                i6 = 0;
            }
            i16++;
            actionMenuPresenter = this;
            i2 = i5;
            view = null;
            i6 = 0;
        }
        return true;
    }

    public final void a(g gVar, boolean z2) {
        h();
        super.a(gVar, z2);
    }

    public final Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f1419a = this.q;
        return savedState;
    }

    public final void a(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f1419a > 0 && (findItem = this.f1290c.findItem(savedState.f1419a)) != null) {
                a((r) findItem.getSubMenu());
            }
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            super.a((r) null);
        } else if (this.f1290c != null) {
            this.f1290c.a(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.f1294g = actionMenuView;
        actionMenuView.f1429a = this.f1290c;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f1419a;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1419a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1419a);
        }
    }

    class d extends AppCompatImageView implements ActionMenuView.a {
        public final boolean c() {
            return false;
        }

        public final boolean d() {
            return false;
        }

        public d(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ae.a(this, getContentDescription());
            setOnTouchListener(new r(this, ActionMenuPresenter.this) {
                public final p a() {
                    if (ActionMenuPresenter.this.m == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.m.b();
                }

                public final boolean b() {
                    ActionMenuPresenter.this.e();
                    return true;
                }

                public final boolean c() {
                    if (ActionMenuPresenter.this.o != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        /* access modifiers changed from: protected */
        public final boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    class e extends l {
        public e(Context context, g gVar, View view) {
            super(context, gVar, view, true, R.attr.actionOverflowMenuStyle);
            this.f1371b = 8388613;
            a((m.a) ActionMenuPresenter.this.p);
        }

        public final void e() {
            if (ActionMenuPresenter.this.f1290c != null) {
                ActionMenuPresenter.this.f1290c.close();
            }
            ActionMenuPresenter.this.m = null;
            super.e();
        }
    }

    class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, R.attr.actionOverflowMenuStyle);
            View view2;
            if (!((i) rVar.getItem()).f()) {
                if (ActionMenuPresenter.this.f1418i == null) {
                    view2 = (View) ActionMenuPresenter.this.f1294g;
                } else {
                    view2 = ActionMenuPresenter.this.f1418i;
                }
                this.f1370a = view2;
            }
            a((m.a) ActionMenuPresenter.this.p);
        }

        public final void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.n = null;
            actionMenuPresenter.q = 0;
            super.e();
        }
    }

    class f implements m.a {
        f() {
        }

        public final boolean a(g gVar) {
            if (gVar == ActionMenuPresenter.this.f1290c) {
                return false;
            }
            ActionMenuPresenter.this.q = ((r) gVar).getItem().getItemId();
            m.a aVar = ActionMenuPresenter.this.f1293f;
            if (aVar != null) {
                return aVar.a(gVar);
            }
            return false;
        }

        public final void a(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.l().a(false);
            }
            m.a aVar = ActionMenuPresenter.this.f1293f;
            if (aVar != null) {
                aVar.a(gVar, z);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f1423b;

        public c(e eVar) {
            this.f1423b = eVar;
        }

        public final void run() {
            if (ActionMenuPresenter.this.f1290c != null) {
                g gVar = ActionMenuPresenter.this.f1290c;
                if (gVar.f1336b != null) {
                    gVar.f1336b.a(gVar);
                }
            }
            View view = (View) ActionMenuPresenter.this.f1294g;
            if (!(view == null || view.getWindowToken() == null || !this.f1423b.c())) {
                ActionMenuPresenter.this.m = this.f1423b;
            }
            ActionMenuPresenter.this.o = null;
        }
    }

    class b extends ActionMenuItemView.b {
        b() {
        }

        public final p a() {
            if (ActionMenuPresenter.this.n != null) {
                return ActionMenuPresenter.this.n.b();
            }
            return null;
        }
    }
}
