package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;

final class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    g f1344a;

    /* renamed from: b  reason: collision with root package name */
    c f1345b;

    /* renamed from: c  reason: collision with root package name */
    e f1346c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f1347d;

    public h(g gVar) {
        this.f1344a = gVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1345b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1345b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1344a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1344a.performShortcut(i2, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f1346c.a(this.f1344a, true);
    }

    public final void a(g gVar, boolean z) {
        c cVar;
        if ((z || gVar == this.f1344a) && (cVar = this.f1345b) != null) {
            cVar.dismiss();
        }
        m.a aVar = this.f1347d;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public final boolean a(g gVar) {
        m.a aVar = this.f1347d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f1344a.a((MenuItem) (i) this.f1346c.c().getItem(i2), (m) null, 0);
    }
}
