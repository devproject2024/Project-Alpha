package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public final class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public g f1329a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1330b;

    /* renamed from: c  reason: collision with root package name */
    private int f1331c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1332d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f1333e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1334f;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f1332d = z;
        this.f1333e = layoutInflater;
        this.f1329a = gVar;
        this.f1334f = i2;
        a();
    }

    public final int getCount() {
        ArrayList<i> k = this.f1332d ? this.f1329a.k() : this.f1329a.i();
        if (this.f1331c < 0) {
            return k.size();
        }
        return k.size() - 1;
    }

    /* renamed from: a */
    public final i getItem(int i2) {
        ArrayList<i> k = this.f1332d ? this.f1329a.k() : this.f1329a.i();
        int i3 = this.f1331c;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return k.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.f1333e.inflate(this.f1334f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        int groupId2 = i3 >= 0 ? getItem(i3).getGroupId() : groupId;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f1329a.b() && groupId != groupId2) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        n.a aVar = (n.a) view;
        if (this.f1330b) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2));
        return view;
    }

    private void a() {
        i iVar = this.f1329a.j;
        if (iVar != null) {
            ArrayList<i> k = this.f1329a.k();
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (k.get(i2) == iVar) {
                    this.f1331c = i2;
                    return;
                }
            }
        }
        this.f1331c = -1;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
