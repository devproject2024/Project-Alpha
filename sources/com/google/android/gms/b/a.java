package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.b.c;
import com.google.android.gms.common.internal.e;
import java.util.LinkedList;

public abstract class a<T extends c> {

    /* renamed from: a  reason: collision with root package name */
    public T f8274a;

    /* renamed from: b  reason: collision with root package name */
    Bundle f8275b;

    /* renamed from: c  reason: collision with root package name */
    LinkedList<C0120a> f8276c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T> f8277d = new g(this);

    /* renamed from: com.google.android.gms.b.a$a  reason: collision with other inner class name */
    interface C0120a {
        int a();

        void b();
    }

    /* access modifiers changed from: protected */
    public abstract void a(e<T> eVar);

    private final void a(int i2) {
        while (!this.f8276c.isEmpty() && this.f8276c.getLast().a() >= i2) {
            this.f8276c.removeLast();
        }
    }

    private final void a(Bundle bundle, C0120a aVar) {
        if (this.f8274a != null) {
            aVar.b();
            return;
        }
        if (this.f8276c == null) {
            this.f8276c = new LinkedList<>();
        }
        this.f8276c.add(aVar);
        if (bundle != null) {
            Bundle bundle2 = this.f8275b;
            if (bundle2 == null) {
                this.f8275b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f8277d);
    }

    public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new i(this, activity, bundle, bundle2));
    }

    public final void a(Bundle bundle) {
        a(bundle, new h(this, bundle));
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new k(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f8274a == null) {
            com.google.android.gms.common.c a2 = com.google.android.gms.common.c.a();
            Context context = frameLayout.getContext();
            int a3 = a2.a(context);
            String c2 = e.c(context, a3);
            String e2 = e.e(context, a3);
            LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            frameLayout.addView(linearLayout);
            TextView textView = new TextView(frameLayout.getContext());
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            textView.setText(c2);
            linearLayout.addView(textView);
            Intent a4 = a2.a(context, a3, (String) null);
            if (a4 != null) {
                Button button = new Button(context);
                button.setId(16908313);
                button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                button.setText(e2);
                linearLayout.addView(button);
                button.setOnClickListener(new j(context, a4));
            }
        }
        return frameLayout;
    }

    public final void a() {
        a((Bundle) null, new m(this));
    }

    public final void b() {
        a((Bundle) null, new l(this));
    }

    public final void c() {
        T t = this.f8274a;
        if (t != null) {
            t.c();
        } else {
            a(5);
        }
    }

    public final void d() {
        T t = this.f8274a;
        if (t != null) {
            t.d();
        } else {
            a(4);
        }
    }

    public final void e() {
        T t = this.f8274a;
        if (t != null) {
            t.e();
        } else {
            a(2);
        }
    }

    public final void f() {
        T t = this.f8274a;
        if (t != null) {
            t.f();
        } else {
            a(1);
        }
    }

    public final void b(Bundle bundle) {
        T t = this.f8274a;
        if (t != null) {
            t.b(bundle);
            return;
        }
        Bundle bundle2 = this.f8275b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public final void g() {
        T t = this.f8274a;
        if (t != null) {
            t.g();
        }
    }
}
