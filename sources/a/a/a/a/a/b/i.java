package a.a.a.a.a.b;

import a.a.a.a.a.c.d;
import a.a.a.a.a.c.e;
import a.a.a.a.a.f.a;
import a.a.a.a.a.g.b;
import a.a.a.a.a.g.c;
import a.a.a.a.a.h.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class i extends b {

    /* renamed from: a  reason: collision with root package name */
    public final c f701a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f702b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.g.a f703c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f704d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f705e;

    /* renamed from: f  reason: collision with root package name */
    boolean f706f;

    /* renamed from: g  reason: collision with root package name */
    private final d f707g;

    /* renamed from: h  reason: collision with root package name */
    private a f708h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f709i = false;

    private void b(View view) {
        this.f708h = new a(view);
    }

    public final String c() {
        return this.f705e;
    }

    public final View d() {
        return (View) this.f708h.get();
    }

    public final boolean e() {
        return this.f709i && !this.f704d;
    }

    i(c cVar, d dVar) {
        this.f701a = cVar;
        this.f707g = dVar;
        this.f705e = UUID.randomUUID().toString();
        b((View) null);
        if (dVar.f686f == e.HTML) {
            this.f703c = new b(dVar.f682b);
        } else {
            this.f703c = new c(Collections.unmodifiableList(dVar.f683c), dVar.f684d);
        }
        this.f703c.a();
        a.a.a.a.a.c.a.a().f711a.add(this);
        a.a.a.a.a.g.a aVar = this.f703c;
        d.a();
        WebView c2 = aVar.c();
        JSONObject jSONObject = new JSONObject();
        a.a.a.a.a.e.b.a(jSONObject, "impressionOwner", cVar.f678a);
        a.a.a.a.a.e.b.a(jSONObject, "videoEventsOwner", cVar.f679b);
        a.a.a.a.a.e.b.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(cVar.f680c));
        d.a(c2, "init", jSONObject);
    }

    public final void a() {
        if (!this.f709i) {
            this.f709i = true;
            a.a.a.a.a.c.a.a().a(this);
            this.f703c.a(e.a().f726a);
            this.f703c.a(this, this.f707g);
        }
    }

    public final void a(View view) {
        if (!this.f704d) {
            a.a.a.a.a.e.c.a((Object) view, "AdView is null");
            if (d() != view) {
                b(view);
                this.f703c.d();
                Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(a.a.a.a.a.c.a.a().f711a);
                if (unmodifiableCollection != null && unmodifiableCollection.size() > 0) {
                    for (T t : unmodifiableCollection) {
                        if (t != this && t.d() == view) {
                            t.f708h.clear();
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        BroadcastReceiver broadcastReceiver;
        if (!this.f704d) {
            this.f708h.clear();
            if (!this.f704d) {
                this.f702b.clear();
            }
            this.f704d = true;
            a.a.a.a.a.g.a aVar = this.f703c;
            d.a();
            d.a(aVar.c(), "finishSession", new Object[0]);
            a.a.a.a.a.c.a a2 = a.a.a.a.a.c.a.a();
            boolean b2 = a2.b();
            a2.f711a.remove(this);
            a2.f712b.remove(this);
            if (b2 && !a2.b()) {
                e a3 = e.a();
                a.a.a.a.a.h.a a4 = a.a.a.a.a.h.a.a();
                a.a.a.a.a.h.a.c();
                a4.f757b.clear();
                a.a.a.a.a.h.a.f752a.post(new a.C0003a());
                a.a.a.a.a.c.b a5 = a.a.a.a.a.c.b.a();
                Context context = a5.f714a;
                if (!(context == null || (broadcastReceiver = a5.f715b) == null)) {
                    context.unregisterReceiver(broadcastReceiver);
                    a5.f715b = null;
                }
                a5.f716c = false;
                a5.f717d = false;
                a5.f718e = null;
                a.a.a.a.a.a.d dVar = a3.f727b;
                dVar.f671a.getContentResolver().unregisterContentObserver(dVar);
            }
            this.f703c.b();
            this.f703c = null;
        }
    }
}
