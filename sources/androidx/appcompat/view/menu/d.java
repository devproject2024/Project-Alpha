package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.s;
import androidx.core.h.e;
import androidx.core.h.u;
import java.util.ArrayList;
import java.util.List;

final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {

    /* renamed from: h  reason: collision with root package name */
    private static final int f1300h = R.layout.abc_cascading_menu_item_layout;
    private m.a A;
    private PopupWindow.OnDismissListener B;

    /* renamed from: a  reason: collision with root package name */
    final Handler f1301a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f1302b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1303c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            if (d.this.e() && d.this.f1302b.size() > 0 && !d.this.f1302b.get(0).f1315a.o) {
                View view = d.this.f1304d;
                if (view == null || !view.isShown()) {
                    d.this.d();
                    return;
                }
                for (a aVar : d.this.f1302b) {
                    aVar.f1315a.a_();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    View f1304d;

    /* renamed from: e  reason: collision with root package name */
    ViewTreeObserver f1305e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1306f;

    /* renamed from: i  reason: collision with root package name */
    private final Context f1307i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;
    private final List<g> n = new ArrayList();
    private final View.OnAttachStateChangeListener o = new View.OnAttachStateChangeListener() {
        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (d.this.f1305e != null) {
                if (!d.this.f1305e.isAlive()) {
                    d.this.f1305e = view.getViewTreeObserver();
                }
                d.this.f1305e.removeGlobalOnLayoutListener(d.this.f1303c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final s p = new s() {
        public final void a(g gVar, MenuItem menuItem) {
            d.this.f1301a.removeCallbacksAndMessages(gVar);
        }

        public final void b(final g gVar, final MenuItem menuItem) {
            final a aVar = null;
            d.this.f1301a.removeCallbacksAndMessages((Object) null);
            int size = d.this.f1302b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f1302b.get(i2).f1316b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f1302b.size()) {
                    aVar = d.this.f1302b.get(i3);
                }
                d.this.f1301a.postAtTime(new Runnable() {
                    public final void run() {
                        if (aVar != null) {
                            d.this.f1306f = true;
                            aVar.f1316b.a(false);
                            d.this.f1306f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            gVar.a(menuItem, (m) null, 4);
                        }
                    }
                }, gVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int q = 0;
    private int r = 0;
    private View s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public final void a(Parcelable parcelable) {
    }

    public final boolean a() {
        return false;
    }

    public final Parcelable f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        return false;
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        this.f1307i = context;
        this.s = view;
        this.k = i2;
        this.l = i3;
        this.m = z2;
        this.y = false;
        this.t = j();
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1301a = new Handler();
    }

    public final void b(boolean z2) {
        this.y = z2;
    }

    private MenuPopupWindow i() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1307i, this.k, this.l);
        menuPopupWindow.f1570a = this.p;
        menuPopupWindow.l = this;
        menuPopupWindow.a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.k = this.s;
        menuPopupWindow.f1560h = this.r;
        menuPopupWindow.i();
        menuPopupWindow.j();
        return menuPopupWindow;
    }

    public final void a_() {
        if (!e()) {
            for (g c2 : this.n) {
                c(c2);
            }
            this.n.clear();
            this.f1304d = this.s;
            if (this.f1304d != null) {
                boolean z2 = this.f1305e == null;
                this.f1305e = this.f1304d.getViewTreeObserver();
                if (z2) {
                    this.f1305e.addOnGlobalLayoutListener(this.f1303c);
                }
                this.f1304d.addOnAttachStateChangeListener(this.o);
            }
        }
    }

    public final void d() {
        int size = this.f1302b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f1302b.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f1315a.p.isShowing()) {
                    aVar.f1315a.d();
                }
            }
        }
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        d();
        return true;
    }

    private int j() {
        return u.j(this.s) == 1 ? 0 : 1;
    }

    private int d(int i2) {
        List<a> list = this.f1302b;
        DropDownListView dropDownListView = list.get(list.size() - 1).f1315a.f1557e;
        int[] iArr = new int[2];
        dropDownListView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1304d.getWindowVisibleDisplayFrame(rect);
        if (this.t == 1) {
            if (iArr[0] + dropDownListView.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public final void a(g gVar) {
        gVar.a((m) this, this.f1307i);
        if (e()) {
            c(gVar);
        } else {
            this.n.add(gVar);
        }
    }

    private void c(g gVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f1307i);
        f fVar = new f(gVar, from, this.m, f1300h);
        if (!e() && this.y) {
            fVar.f1330b = true;
        } else if (e()) {
            fVar.f1330b = k.b(gVar);
        }
        int a2 = a(fVar, (ViewGroup) null, this.f1307i, this.j);
        MenuPopupWindow i5 = i();
        i5.a((ListAdapter) fVar);
        i5.d(a2);
        i5.f1560h = this.r;
        if (this.f1302b.size() > 0) {
            List<a> list = this.f1302b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            i5.h();
            i5.a();
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.t = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                i5.k = view;
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.s.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.r & 7) == 5) {
                    iArr[0] = iArr[0] + this.s.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.r & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                i5.f1559g = i4;
                i5.n();
                i5.a(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                i5.f1559g = i4;
                i5.n();
                i5.a(i3);
            }
            i4 = i2 + a2;
            i5.f1559g = i4;
            i5.n();
            i5.a(i3);
        } else {
            if (this.u) {
                i5.f1559g = this.w;
            }
            if (this.v) {
                i5.a(this.x);
            }
            i5.a(this.f1369g);
        }
        this.f1302b.add(new a(i5, gVar, this.t));
        i5.a_();
        DropDownListView dropDownListView = i5.f1557e;
        dropDownListView.setOnKeyListener(this);
        if (aVar == null && this.z && gVar.f1340f != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, dropDownListView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.f1340f);
            dropDownListView.addHeaderView(frameLayout, (Object) null, false);
            i5.a_();
        }
    }

    private static MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private static View a(a aVar, g gVar) {
        int i2;
        f fVar;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f1316b, gVar);
        if (a2 == null) {
            return null;
        }
        DropDownListView dropDownListView = aVar.f1315a.f1557e;
        ListAdapter adapter = dropDownListView.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == fVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - dropDownListView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < dropDownListView.getChildCount()) {
            return dropDownListView.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final boolean e() {
        return this.f1302b.size() > 0 && this.f1302b.get(0).f1315a.p.isShowing();
    }

    public final void onDismiss() {
        a aVar;
        int size = this.f1302b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1302b.get(i2);
            if (!aVar.f1315a.p.isShowing()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f1316b.a(false);
        }
    }

    public final void a(boolean z2) {
        for (a aVar : this.f1302b) {
            a(aVar.f1315a.f1557e.getAdapter()).notifyDataSetChanged();
        }
    }

    public final void a(m.a aVar) {
        this.A = aVar;
    }

    public final boolean a(r rVar) {
        for (a next : this.f1302b) {
            if (rVar == next.f1316b) {
                next.f1315a.f1557e.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a((g) rVar);
        m.a aVar = this.A;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    public final void a(int i2) {
        if (this.q != i2) {
            this.q = i2;
            this.r = e.a(i2, u.j(this.s));
        }
    }

    public final void a(View view) {
        if (this.s != view) {
            this.s = view;
            this.r = e.a(this.q, u.j(this.s));
        }
    }

    public final void a(PopupWindow.OnDismissListener onDismissListener) {
        this.B = onDismissListener;
    }

    public final ListView g() {
        if (this.f1302b.isEmpty()) {
            return null;
        }
        List<a> list = this.f1302b;
        return list.get(list.size() - 1).f1315a.f1557e;
    }

    public final void b(int i2) {
        this.u = true;
        this.w = i2;
    }

    public final void c(int i2) {
        this.v = true;
        this.x = i2;
    }

    public final void c(boolean z2) {
        this.z = z2;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f1315a;

        /* renamed from: b  reason: collision with root package name */
        public final g f1316b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1317c;

        public a(MenuPopupWindow menuPopupWindow, g gVar, int i2) {
            this.f1315a = menuPopupWindow;
            this.f1316b = gVar;
            this.f1317c = i2;
        }
    }

    public final void a(g gVar, boolean z2) {
        int size = this.f1302b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (gVar == this.f1302b.get(i2).f1316b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < this.f1302b.size()) {
                this.f1302b.get(i3).f1316b.a(false);
            }
            a remove = this.f1302b.remove(i2);
            remove.f1316b.b((m) this);
            if (this.f1306f) {
                MenuPopupWindow menuPopupWindow = remove.f1315a;
                if (Build.VERSION.SDK_INT >= 23) {
                    menuPopupWindow.p.setExitTransition((Transition) null);
                }
                remove.f1315a.p.setAnimationStyle(0);
            }
            remove.f1315a.d();
            int size2 = this.f1302b.size();
            if (size2 > 0) {
                this.t = this.f1302b.get(size2 - 1).f1317c;
            } else {
                this.t = j();
            }
            if (size2 == 0) {
                d();
                m.a aVar = this.A;
                if (aVar != null) {
                    aVar.a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f1305e;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f1305e.removeGlobalOnLayoutListener(this.f1303c);
                    }
                    this.f1305e = null;
                }
                this.f1304d.removeOnAttachStateChangeListener(this.o);
                this.B.onDismiss();
            } else if (z2) {
                this.f1302b.get(0).f1316b.a(false);
            }
        }
    }
}
