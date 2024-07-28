package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public final class e implements AdapterView.OnItemClickListener, m {

    /* renamed from: a  reason: collision with root package name */
    Context f1318a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f1319b;

    /* renamed from: c  reason: collision with root package name */
    g f1320c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f1321d;

    /* renamed from: e  reason: collision with root package name */
    int f1322e;

    /* renamed from: f  reason: collision with root package name */
    int f1323f;

    /* renamed from: g  reason: collision with root package name */
    int f1324g;

    /* renamed from: h  reason: collision with root package name */
    public m.a f1325h;

    /* renamed from: i  reason: collision with root package name */
    a f1326i;
    private int j;

    public final boolean a() {
        return false;
    }

    public final boolean b(i iVar) {
        return false;
    }

    public final boolean c(i iVar) {
        return false;
    }

    public e(Context context, int i2) {
        this(i2);
        this.f1318a = context;
        this.f1319b = LayoutInflater.from(this.f1318a);
    }

    private e(int i2) {
        this.f1324g = i2;
        this.f1323f = 0;
    }

    public final void a(Context context, g gVar) {
        int i2 = this.f1323f;
        if (i2 != 0) {
            this.f1318a = new ContextThemeWrapper(context, i2);
            this.f1319b = LayoutInflater.from(this.f1318a);
        } else if (this.f1318a != null) {
            this.f1318a = context;
            if (this.f1319b == null) {
                this.f1319b = LayoutInflater.from(this.f1318a);
            }
        }
        this.f1320c = gVar;
        a aVar = this.f1326i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final n a(ViewGroup viewGroup) {
        if (this.f1321d == null) {
            this.f1321d = (ExpandedMenuView) this.f1319b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1326i == null) {
                this.f1326i = new a();
            }
            this.f1321d.setAdapter(this.f1326i);
            this.f1321d.setOnItemClickListener(this);
        }
        return this.f1321d;
    }

    public final ListAdapter c() {
        if (this.f1326i == null) {
            this.f1326i = new a();
        }
        return this.f1326i;
    }

    public final void a(boolean z) {
        a aVar = this.f1326i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final void a(m.a aVar) {
        this.f1325h = aVar;
    }

    public final boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        h hVar = new h(rVar);
        g gVar = hVar.f1344a;
        c.a aVar = new c.a(gVar.f1335a);
        hVar.f1346c = new e(aVar.f1095a.f1016a, R.layout.abc_list_menu_item_layout);
        hVar.f1346c.f1325h = hVar;
        hVar.f1344a.a((m) hVar.f1346c);
        aVar.a(hVar.f1346c.c(), (DialogInterface.OnClickListener) hVar);
        View view = gVar.f1342h;
        if (view != null) {
            aVar.f1095a.f1022g = view;
        } else {
            aVar.a(gVar.f1341g).a(gVar.f1340f);
        }
        aVar.f1095a.u = hVar;
        hVar.f1345b = aVar.a();
        hVar.f1345b.setOnDismissListener(hVar);
        WindowManager.LayoutParams attributes = hVar.f1345b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        hVar.f1345b.show();
        m.a aVar2 = this.f1325h;
        if (aVar2 == null) {
            return true;
        }
        aVar2.a(rVar);
        return true;
    }

    public final void a(g gVar, boolean z) {
        m.a aVar = this.f1325h;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f1320c.a((MenuItem) this.f1326i.getItem(i2), (m) this, 0);
    }

    public final int b() {
        return this.j;
    }

    public final Parcelable f() {
        if (this.f1321d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f1321d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void a(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1321d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f1328b = -1;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a() {
            a();
        }

        public final int getCount() {
            int size = e.this.f1320c.k().size() - e.this.f1322e;
            return this.f1328b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public final i getItem(int i2) {
            ArrayList<i> k = e.this.f1320c.k();
            int i3 = i2 + e.this.f1322e;
            int i4 = this.f1328b;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return k.get(i3);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = e.this.f1319b.inflate(e.this.f1324g, viewGroup, false);
            }
            ((n.a) view).a(getItem(i2));
            return view;
        }

        private void a() {
            i iVar = e.this.f1320c.j;
            if (iVar != null) {
                ArrayList<i> k = e.this.f1320c.k();
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (k.get(i2) == iVar) {
                        this.f1328b = i2;
                        return;
                    }
                }
            }
            this.f1328b = -1;
        }

        public final void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
