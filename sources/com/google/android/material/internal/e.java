package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.core.h.a.c;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;
import com.google.android.material.R;
import java.util.ArrayList;

public final class e implements m {

    /* renamed from: a  reason: collision with root package name */
    public NavigationMenuView f36445a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f36446b;

    /* renamed from: c  reason: collision with root package name */
    androidx.appcompat.view.menu.g f36447c;

    /* renamed from: d  reason: collision with root package name */
    public int f36448d;

    /* renamed from: e  reason: collision with root package name */
    public b f36449e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f36450f;

    /* renamed from: g  reason: collision with root package name */
    int f36451g;

    /* renamed from: h  reason: collision with root package name */
    boolean f36452h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f36453i;
    public ColorStateList j;
    public Drawable k;
    public int l;
    public int m;
    int n;
    boolean o;
    public boolean p = true;
    public int q;
    public int r;
    int s;
    public int t = -1;
    final View.OnClickListener u = new View.OnClickListener() {
        public final void onClick(View view) {
            boolean z = true;
            e.this.b(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            boolean a2 = e.this.f36447c.a((MenuItem) itemData, (m) e.this, 0);
            if (itemData == null || !itemData.isCheckable() || !a2) {
                z = false;
            } else {
                e.this.f36449e.a(itemData);
            }
            e.this.b(false);
            if (z) {
                e.this.a(false);
            }
        }
    };
    private m.a v;

    interface d {
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(r rVar) {
        return false;
    }

    public final boolean b(androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public final boolean c(androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public final void a(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f36450f = LayoutInflater.from(context);
        this.f36447c = gVar;
        this.s = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public final void a(boolean z) {
        b bVar = this.f36449e;
        if (bVar != null) {
            bVar.a();
            bVar.notifyDataSetChanged();
        }
    }

    public final void a(m.a aVar) {
        this.v = aVar;
    }

    public final void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        m.a aVar = this.v;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public final int b() {
        return this.f36448d;
    }

    public final Parcelable f() {
        Bundle bundle = new Bundle();
        if (this.f36445a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f36445a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f36449e;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.b());
        }
        if (this.f36446b != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f36446b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public final void a(Parcelable parcelable) {
        androidx.appcompat.view.menu.i iVar;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        androidx.appcompat.view.menu.i iVar2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f36445a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                b bVar = this.f36449e;
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    bVar.f36457c = true;
                    int size = bVar.f36455a.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        d dVar = bVar.f36455a.get(i3);
                        if ((dVar instanceof f) && (iVar2 = ((f) dVar).f36461a) != null && iVar2.getItemId() == i2) {
                            bVar.a(iVar2);
                            break;
                        }
                        i3++;
                    }
                    bVar.f36457c = false;
                    bVar.a();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = bVar.f36455a.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        d dVar2 = bVar.f36455a.get(i4);
                        if (!(!(dVar2 instanceof f) || (iVar = ((f) dVar2).f36461a) == null || (actionView = iVar.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(iVar.getItemId())) == null)) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f36446b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    public final void a(androidx.appcompat.view.menu.i iVar) {
        this.f36449e.a(iVar);
    }

    public final void a(ColorStateList colorStateList) {
        this.j = colorStateList;
        a(false);
    }

    public final void b(ColorStateList colorStateList) {
        this.f36453i = colorStateList;
        a(false);
    }

    public final void a(int i2) {
        this.f36451g = i2;
        this.f36452h = true;
        a(false);
    }

    public final void a(Drawable drawable) {
        this.k = drawable;
        a(false);
    }

    public final void b(int i2) {
        this.l = i2;
        a(false);
    }

    public final void c(int i2) {
        this.m = i2;
        a(false);
    }

    public final void d(int i2) {
        this.q = i2;
        a(false);
    }

    public final void e(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = true;
            a(false);
        }
    }

    public final void b(boolean z) {
        b bVar = this.f36449e;
        if (bVar != null) {
            bVar.f36457c = z;
        }
    }

    public final void c() {
        int i2 = (this.f36446b.getChildCount() != 0 || !this.p) ? 0 : this.r;
        NavigationMenuView navigationMenuView = this.f36445a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public final void f(int i2) {
        this.t = i2;
        NavigationMenuView navigationMenuView = this.f36445a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    static abstract class k extends RecyclerView.v {
        public k(View view) {
            super(view);
        }
    }

    static class h extends k {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    static class j extends k {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    static class i extends k {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    static class a extends k {
        public a(View view) {
            super(view);
        }
    }

    public class b extends RecyclerView.a<k> {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<d> f36455a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public androidx.appcompat.view.menu.i f36456b;

        /* renamed from: c  reason: collision with root package name */
        boolean f36457c;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            k kVar = (k) vVar;
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) kVar.itemView;
                navigationMenuItemView.setIconTintList(e.this.j);
                if (e.this.f36452h) {
                    navigationMenuItemView.setTextAppearance(e.this.f36451g);
                }
                if (e.this.f36453i != null) {
                    navigationMenuItemView.setTextColor(e.this.f36453i);
                }
                u.a((View) navigationMenuItemView, e.this.k != null ? e.this.k.getConstantState().newDrawable() : null);
                f fVar = (f) this.f36455a.get(i2);
                navigationMenuItemView.setNeedsEmptyIcon(fVar.f36462b);
                navigationMenuItemView.setHorizontalPadding(e.this.l);
                navigationMenuItemView.setIconPadding(e.this.m);
                if (e.this.o) {
                    navigationMenuItemView.setIconSize(e.this.n);
                }
                navigationMenuItemView.setMaxLines(e.this.q);
                navigationMenuItemView.a(fVar.f36461a);
            } else if (itemViewType == 1) {
                ((TextView) kVar.itemView).setText(((f) this.f36455a.get(i2)).f36461a.getTitle());
            } else if (itemViewType == 2) {
                C0608e eVar = (C0608e) this.f36455a.get(i2);
                kVar.itemView.setPadding(0, eVar.f36459a, 0, eVar.f36460b);
            }
        }

        public final /* synthetic */ void onViewRecycled(RecyclerView.v vVar) {
            k kVar = (k) vVar;
            if (kVar instanceof h) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) kVar.itemView;
                if (navigationMenuItemView.f36420e != null) {
                    navigationMenuItemView.f36420e.removeAllViews();
                }
                navigationMenuItemView.f36419d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        public b() {
            a();
        }

        public final int getItemCount() {
            return this.f36455a.size();
        }

        public final int getItemViewType(int i2) {
            d dVar = this.f36455a.get(i2);
            if (dVar instanceof C0608e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).f36461a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (!this.f36457c) {
                this.f36457c = true;
                this.f36455a.clear();
                this.f36455a.add(new c());
                int size = e.this.f36447c.i().size();
                int i2 = -1;
                boolean z = false;
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    androidx.appcompat.view.menu.i iVar = e.this.f36447c.i().get(i4);
                    if (iVar.isChecked()) {
                        a(iVar);
                    }
                    if (iVar.isCheckable()) {
                        iVar.a(false);
                    }
                    if (iVar.hasSubMenu()) {
                        SubMenu subMenu = iVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i4 != 0) {
                                this.f36455a.add(new C0608e(e.this.s, 0));
                            }
                            this.f36455a.add(new f(iVar));
                            int size2 = this.f36455a.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i5 = 0; i5 < size3; i5++) {
                                androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i5);
                                if (iVar2.isVisible()) {
                                    if (!z2 && iVar2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (iVar2.isCheckable()) {
                                        iVar2.a(false);
                                    }
                                    if (iVar.isChecked()) {
                                        a(iVar);
                                    }
                                    this.f36455a.add(new f(iVar2));
                                }
                            }
                            if (z2) {
                                a(size2, this.f36455a.size());
                            }
                        }
                    } else {
                        int groupId = iVar.getGroupId();
                        if (groupId != i2) {
                            i3 = this.f36455a.size();
                            boolean z3 = iVar.getIcon() != null;
                            if (i4 != 0) {
                                i3++;
                                this.f36455a.add(new C0608e(e.this.s, e.this.s));
                            }
                            z = z3;
                        } else if (!z && iVar.getIcon() != null) {
                            a(i3, this.f36455a.size());
                            z = true;
                        }
                        f fVar = new f(iVar);
                        fVar.f36462b = z;
                        this.f36455a.add(fVar);
                        i2 = groupId;
                    }
                }
                this.f36457c = false;
            }
        }

        private void a(int i2, int i3) {
            while (i2 < i3) {
                ((f) this.f36455a.get(i2)).f36462b = true;
                i2++;
            }
        }

        public final void a(androidx.appcompat.view.menu.i iVar) {
            if (this.f36456b != iVar && iVar.isCheckable()) {
                androidx.appcompat.view.menu.i iVar2 = this.f36456b;
                if (iVar2 != null) {
                    iVar2.setChecked(false);
                }
                this.f36456b = iVar;
                iVar.setChecked(true);
            }
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.f36456b;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f36455a.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.f36455a.get(i2);
                if (dVar instanceof f) {
                    androidx.appcompat.view.menu.i iVar2 = ((f) dVar).f36461a;
                    View actionView = iVar2 != null ? iVar2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(iVar2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new h(e.this.f36450f, viewGroup, e.this.u);
            }
            if (i2 == 1) {
                return new j(e.this.f36450f, viewGroup);
            }
            if (i2 == 2) {
                return new i(e.this.f36450f, viewGroup);
            }
            if (i2 != 3) {
                return null;
            }
            return new a(e.this.f36446b);
        }
    }

    static class f implements d {

        /* renamed from: a  reason: collision with root package name */
        final androidx.appcompat.view.menu.i f36461a;

        /* renamed from: b  reason: collision with root package name */
        boolean f36462b;

        f(androidx.appcompat.view.menu.i iVar) {
            this.f36461a = iVar;
        }
    }

    /* renamed from: com.google.android.material.internal.e$e  reason: collision with other inner class name */
    static class C0608e implements d {

        /* renamed from: a  reason: collision with root package name */
        final int f36459a;

        /* renamed from: b  reason: collision with root package name */
        final int f36460b;

        public C0608e(int i2, int i3) {
            this.f36459a = i2;
            this.f36460b = i3;
        }
    }

    static class c implements d {
        c() {
        }
    }

    public class g extends w {
        public g(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            c.b bVar;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            b bVar2 = e.this.f36449e;
            int i2 = e.this.f36446b.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < e.this.f36449e.getItemCount(); i3++) {
                if (e.this.f36449e.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                bVar = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, 0, false));
            } else {
                bVar = new c.b((Object) null);
            }
            cVar.a((Object) bVar);
        }
    }
}
