package net.one97.paytm.feed.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.i.h;

public abstract class a<B extends ViewDataBinding, VM extends ai> extends h {

    /* renamed from: a  reason: collision with root package name */
    protected B f34868a;

    /* renamed from: b  reason: collision with root package name */
    protected VM f34869b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34870c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f34871d;

    public abstract int d();

    public abstract HashMap<Integer, Object> e();

    public abstract void f();

    public void i() {
        HashMap hashMap = this.f34871d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        i();
    }

    public final B b() {
        B b2 = this.f34868a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        return b2;
    }

    public final VM c() {
        VM vm = this.f34869b;
        if (vm == null) {
            k.a("viewModel");
        }
        return vm;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        this.f34870c = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context;
        k.c(layoutInflater, "inflater");
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        this.f34869b = net.one97.paytm.feed.c.a.a((Fragment) this);
        if (viewGroup != null) {
            try {
                context = viewGroup.getContext();
            } catch (Exception unused) {
            }
        } else {
            context = null;
        }
        com.google.android.play.core.splitcompat.a.a(context);
        B a2 = f.a(layoutInflater, d(), viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…utId(), container, false)");
        this.f34868a = a2;
        B b2 = this.f34868a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        int i2 = net.one97.paytm.feed.a.z;
        VM vm = this.f34869b;
        if (vm == null) {
            k.a("viewModel");
        }
        b2.setVariable(i2, vm);
        for (Map.Entry entry : e().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        setHasOptionsMenu(false);
        B b3 = this.f34868a;
        if (b3 == null) {
            k.a("dataBinding");
        }
        return b3.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Context context = this.f34870c;
        if (context == null) {
            k.a();
        }
        view.setBackgroundColor(b.c(context, R.color.feed_white));
        f();
    }

    public void onPause() {
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.g();
        super.onPause();
    }

    public final boolean g() {
        return this.f34868a != null;
    }

    public final boolean h() {
        return this.f34869b != null;
    }

    public void onResume() {
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.a(this.f34870c);
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }
}
