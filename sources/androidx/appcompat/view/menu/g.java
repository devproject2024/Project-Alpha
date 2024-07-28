package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.h.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements androidx.core.b.a.a {
    private static final int[] l = {1, 4, 5, 3, 2, 0};
    private boolean A = false;

    /* renamed from: a  reason: collision with root package name */
    protected final Context f1335a;

    /* renamed from: b  reason: collision with root package name */
    public a f1336b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<i> f1337c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<i> f1338d;

    /* renamed from: e  reason: collision with root package name */
    public int f1339e = 0;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f1340f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f1341g;

    /* renamed from: h  reason: collision with root package name */
    View f1342h;

    /* renamed from: i  reason: collision with root package name */
    boolean f1343i = false;
    i j;
    public boolean k;
    private final Resources m;
    private boolean n;
    private boolean o;
    private ArrayList<i> p;
    private boolean q;
    private ArrayList<i> r;
    private boolean s;
    private ContextMenu.ContextMenuInfo t;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private ArrayList<i> y = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<m>> z = new CopyOnWriteArrayList<>();

    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(i iVar);
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "android:menu:actionviewstates";
    }

    public g l() {
        return this;
    }

    public g(Context context) {
        this.f1335a = context;
        this.m = context.getResources();
        this.f1337c = new ArrayList<>();
        this.p = new ArrayList<>();
        boolean z2 = true;
        this.q = true;
        this.f1338d = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = true;
        this.o = (this.m.getConfiguration().keyboard == 1 || !v.c(ViewConfiguration.get(this.f1335a), this.f1335a)) ? false : z2;
    }

    public final void a(m mVar) {
        a(mVar, this.f1335a);
    }

    public final void a(m mVar, Context context) {
        this.z.add(new WeakReference(mVar));
        mVar.a(context, this);
        this.s = true;
    }

    public final void b(m mVar) {
        Iterator<WeakReference<m>> it2 = this.z.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.z.remove(next);
            }
        }
    }

    private boolean a(r rVar, m mVar) {
        boolean z2 = false;
        if (this.z.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z2 = mVar.a(rVar);
        }
        Iterator<WeakReference<m>> it2 = this.z.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null) {
                this.z.remove(next);
            } else if (!z2) {
                z2 = mVar2.a(rVar);
            }
        }
        return z2;
    }

    public final void c(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public final void d(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).d(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void a(a aVar) {
        this.f1336b = aVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.m.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.m.getString(i5));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.m.getString(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f1335a, this, iVar);
        iVar.a(rVar);
        return rVar;
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.m.getString(i5));
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.A = z2;
    }

    public boolean b() {
        return this.A;
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1335a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    private void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f1337c.size()) {
            this.f1337c.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    public void clear() {
        i iVar = this.j;
        if (iVar != null) {
            b(iVar);
        }
        this.f1337c.clear();
        b(true);
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f1337c.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f1337c.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.a(z3);
                iVar.setCheckable(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f1337c.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f1337c.get(i3);
            if (iVar.getGroupId() == i2 && iVar.b(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f1337c.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f1337c.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.setEnabled(z2);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.k) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1337c.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f1337c.get(i3);
            if (iVar.getItemId() == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int size() {
        return this.f1337c.size();
    }

    public MenuItem getItem(int i2) {
        return this.f1337c.get(i2);
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public void setQwertyMode(boolean z2) {
        this.n = z2;
        b(false);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.n;
    }

    public boolean d() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.f1336b;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    private static int a(ArrayList<i> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f1348a <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        boolean z2;
        i a2 = a(i2, keyEvent);
        if (a2 != null) {
            z2 = a((MenuItem) a2, (m) null, i3);
        } else {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            a(true);
        }
        return z2;
    }

    private void a(List<i> list, int i2, KeyEvent keyEvent) {
        boolean c2 = c();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f1337c.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.f1337c.get(i3);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = c2 ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((c2 ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (c2 && alphabeticShortcut == 8 && i2 == 67)) && iVar.isEnabled())) {
                    list.add(iVar);
                }
            }
        }
    }

    private i a(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<i> arrayList = this.y;
        arrayList.clear();
        a((List<i>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean c3 = c();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            if (c3) {
                c2 = iVar.getAlphabeticShortcut();
            } else {
                c2 = iVar.getNumericShortcut();
            }
            if ((c2 == keyData.meta[0] && (metaState & 2) == 0) || ((c2 == keyData.meta[2] && (metaState & 2) != 0) || (c3 && c2 == 8 && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), (m) null, i3);
    }

    public final boolean a(MenuItem menuItem, m mVar, int i2) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean b2 = iVar.b();
        androidx.core.h.b bVar = iVar.f1352e;
        boolean z2 = bVar != null && bVar.c();
        if (iVar.j()) {
            b2 |= iVar.expandActionView();
            if (b2) {
                a(true);
            }
        } else if (iVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.a(new r(this.f1335a, this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z2) {
                bVar.a((SubMenu) rVar);
            }
            b2 |= a(rVar, mVar);
            if (!b2) {
                a(true);
            }
        } else if ((i2 & 1) == 0) {
            a(true);
        }
        return b2;
    }

    public final void a(boolean z2) {
        if (!this.x) {
            this.x = true;
            Iterator<WeakReference<m>> it2 = this.z.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.z.remove(next);
                } else {
                    mVar.a(this, z2);
                }
            }
            this.x = false;
        }
    }

    public void close() {
        a(true);
    }

    public void b(boolean z2) {
        if (!this.u) {
            if (z2) {
                this.q = true;
                this.s = true;
            }
            if (!this.z.isEmpty()) {
                e();
                Iterator<WeakReference<m>> it2 = this.z.iterator();
                while (it2.hasNext()) {
                    WeakReference next = it2.next();
                    m mVar = (m) next.get();
                    if (mVar == null) {
                        this.z.remove(next);
                    } else {
                        mVar.a(z2);
                    }
                }
                f();
                return;
            }
            return;
        }
        this.v = true;
        if (z2) {
            this.w = true;
        }
    }

    public final void e() {
        if (!this.u) {
            this.u = true;
            this.v = false;
            this.w = false;
        }
    }

    public final void f() {
        this.u = false;
        if (this.v) {
            this.v = false;
            b(this.w);
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.q = true;
        b(true);
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        this.s = true;
        b(true);
    }

    public final ArrayList<i> i() {
        if (!this.q) {
            return this.p;
        }
        this.p.clear();
        int size = this.f1337c.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f1337c.get(i2);
            if (iVar.isVisible()) {
                this.p.add(iVar);
            }
        }
        this.q = false;
        this.s = true;
        return this.p;
    }

    public final void j() {
        ArrayList<i> i2 = i();
        if (this.s) {
            Iterator<WeakReference<m>> it2 = this.z.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.z.remove(next);
                } else {
                    z2 |= mVar.a();
                }
            }
            if (z2) {
                this.f1338d.clear();
                this.r.clear();
                int size = i2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = i2.get(i3);
                    if (iVar.f()) {
                        this.f1338d.add(iVar);
                    } else {
                        this.r.add(iVar);
                    }
                }
            } else {
                this.f1338d.clear();
                this.r.clear();
                this.r.addAll(i());
            }
            this.s = false;
        }
    }

    public final ArrayList<i> k() {
        j();
        return this.r;
    }

    public void clearHeader() {
        this.f1341g = null;
        this.f1340f = null;
        this.f1342h = null;
        b(false);
    }

    public boolean a(i iVar) {
        boolean z2 = false;
        if (this.z.isEmpty()) {
            return false;
        }
        e();
        Iterator<WeakReference<m>> it2 = this.z.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar = (m) next.get();
            if (mVar == null) {
                this.z.remove(next);
            } else {
                z2 = mVar.b(iVar);
                if (z2) {
                    break;
                }
            }
        }
        f();
        if (z2) {
            this.j = iVar;
        }
        return z2;
    }

    public boolean b(i iVar) {
        boolean z2 = false;
        if (!this.z.isEmpty() && this.j == iVar) {
            e();
            Iterator<WeakReference<m>> it2 = this.z.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.z.remove(next);
                } else {
                    z2 = mVar.c(iVar);
                    if (z2) {
                        break;
                    }
                }
            }
            f();
            if (z2) {
                this.j = null;
            }
        }
        return z2;
    }

    public final void a(Bundle bundle) {
        Parcelable f2;
        if (!this.z.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<m>> it2 = this.z.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.z.remove(next);
                } else {
                    int b2 = mVar.b();
                    if (b2 > 0 && (f2 = mVar.f()) != null) {
                        sparseArray.put(b2, f2);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void b(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.z.isEmpty()) {
            Iterator<WeakReference<m>> it2 = this.z.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.z.remove(next);
                } else {
                    int b2 = mVar.b();
                    if (b2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(b2)) != null) {
                        mVar.a(parcelable);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = (-65536 & i4) >> 16;
        if (i5 >= 0) {
            int[] iArr = l;
            if (i5 < iArr.length) {
                int i6 = (iArr[i5] << 16) | (65535 & i4);
                i iVar = new i(this, i2, i3, i4, i6, charSequence, this.f1339e);
                ContextMenu.ContextMenuInfo contextMenuInfo = this.t;
                if (contextMenuInfo != null) {
                    iVar.f1353f = contextMenuInfo;
                }
                ArrayList<i> arrayList = this.f1337c;
                arrayList.add(a(arrayList, i6), iVar);
                b(true);
                return iVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void removeItem(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f1337c.get(i3).getItemId() == i2) {
                break;
            } else {
                i3++;
            }
        }
        a(i3, true);
    }

    public void removeGroup(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f1337c.get(i3).getGroupId() == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.f1337c.size() - i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size2 || this.f1337c.get(i3).getGroupId() != i2) {
                    b(true);
                } else {
                    a(i3, false);
                    i4 = i5;
                }
            }
            b(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.m;
        if (view != null) {
            this.f1342h = view;
            this.f1340f = null;
            this.f1341g = null;
        } else {
            if (i2 > 0) {
                this.f1340f = resources.getText(i2);
            } else if (charSequence != null) {
                this.f1340f = charSequence;
            }
            if (i3 > 0) {
                this.f1341g = androidx.core.content.b.a(this.f1335a, i3);
            } else if (drawable != null) {
                this.f1341g = drawable;
            }
            this.f1342h = null;
        }
        b(false);
    }
}
