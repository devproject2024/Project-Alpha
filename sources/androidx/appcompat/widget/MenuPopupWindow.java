package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import java.lang.reflect.Method;

public final class MenuPopupWindow extends ListPopupWindow implements s {

    /* renamed from: b  reason: collision with root package name */
    private static Method f1569b;

    /* renamed from: a  reason: collision with root package name */
    public s f1570a;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1569b = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public MenuPopupWindow(Context context, int i2, int i3) {
        super(context, (AttributeSet) null, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final DropDownListView a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.p.setEnterTransition((Transition) null);
        }
    }

    public final void h() {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1569b;
            if (method != null) {
                try {
                    method.invoke(this.p, new Object[]{Boolean.FALSE});
                } catch (Exception unused) {
                }
            }
        } else {
            this.p.setTouchModal(false);
        }
    }

    public final void b(g gVar, MenuItem menuItem) {
        s sVar = this.f1570a;
        if (sVar != null) {
            sVar.b(gVar, menuItem);
        }
    }

    public final void a(g gVar, MenuItem menuItem) {
        s sVar = this.f1570a;
        if (sVar != null) {
            sVar.a(gVar, menuItem);
        }
    }

    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: b  reason: collision with root package name */
        final int f1571b;

        /* renamed from: c  reason: collision with root package name */
        final int f1572c;

        /* renamed from: d  reason: collision with root package name */
        private s f1573d;

        /* renamed from: e  reason: collision with root package name */
        private MenuItem f1574e;

        public final /* bridge */ /* synthetic */ int a(int i2, int i3, int i4, int i5, int i6) {
            return super.a(i2, i3, i4, i5, i6);
        }

        public final /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i2) {
            return super.a(motionEvent, i2);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1571b = 22;
                this.f1572c = 21;
                return;
            }
            this.f1571b = 21;
            this.f1572c = 22;
        }

        public void setHoverListener(s sVar) {
            this.f1573d = sVar;
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f1571b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.f1572c) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((f) getAdapter()).f1329a.a(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            f fVar;
            int pointToPosition;
            int i3;
            if (this.f1573d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    fVar = (f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    fVar = (f) adapter;
                }
                i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < fVar.getCount()) {
                    iVar = fVar.getItem(i3);
                }
                MenuItem menuItem = this.f1574e;
                if (menuItem != iVar) {
                    g gVar = fVar.f1329a;
                    if (menuItem != null) {
                        this.f1573d.a(gVar, menuItem);
                    }
                    this.f1574e = iVar;
                    if (iVar != null) {
                        this.f1573d.b(gVar, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
