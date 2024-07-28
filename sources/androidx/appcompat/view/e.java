package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public final class e extends b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f1217a;

    /* renamed from: b  reason: collision with root package name */
    private ActionBarContextView f1218b;

    /* renamed from: e  reason: collision with root package name */
    private b.a f1219e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<View> f1220f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1221g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1222h;

    /* renamed from: i  reason: collision with root package name */
    private g f1223i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f1217a = context;
        this.f1218b = actionBarContextView;
        this.f1219e = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f1339e = 1;
        this.f1223i = gVar;
        this.f1223i.a((g.a) this);
        this.f1222h = z;
    }

    public final void b(CharSequence charSequence) {
        this.f1218b.setTitle(charSequence);
    }

    public final void a(CharSequence charSequence) {
        this.f1218b.setSubtitle(charSequence);
    }

    public final void a(int i2) {
        b((CharSequence) this.f1217a.getString(i2));
    }

    public final void b(int i2) {
        a((CharSequence) this.f1217a.getString(i2));
    }

    public final void a(boolean z) {
        super.a(z);
        this.f1218b.setTitleOptional(z);
    }

    public final boolean h() {
        return this.f1218b.f1401g;
    }

    public final void a(View view) {
        this.f1218b.setCustomView(view);
        this.f1220f = view != null ? new WeakReference<>(view) : null;
    }

    public final void d() {
        this.f1219e.b(this, this.f1223i);
    }

    public final void c() {
        if (!this.f1221g) {
            this.f1221g = true;
            this.f1218b.sendAccessibilityEvent(32);
            this.f1219e.a(this);
        }
    }

    public final Menu b() {
        return this.f1223i;
    }

    public final CharSequence f() {
        return this.f1218b.getTitle();
    }

    public final CharSequence g() {
        return this.f1218b.getSubtitle();
    }

    public final View i() {
        WeakReference<View> weakReference = this.f1220f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final MenuInflater a() {
        return new g(this.f1218b.getContext());
    }

    public final boolean a(g gVar, MenuItem menuItem) {
        return this.f1219e.a((b) this, menuItem);
    }

    public final void a(g gVar) {
        d();
        this.f1218b.a();
    }
}
