package net.one97.paytm.feed.ui.base;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.feed.c.a;

public abstract class FeedBaseActivity<B extends ViewDataBinding, VM extends ai> extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    protected B f34866a;

    /* renamed from: b  reason: collision with root package name */
    protected VM f34867b;

    public abstract int c();

    public abstract HashMap<Integer, Object> d();

    public abstract void e();

    public final B a() {
        B b2 = this.f34866a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        return b2;
    }

    public final VM b() {
        VM vm = this.f34867b;
        if (vm == null) {
            k.a("viewModel");
        }
        return vm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = a.f34255a;
        this.f34867b = a.a((AppCompatActivity) this);
        B a2 = f.a(this, c());
        k.a((Object) a2, "DataBindingUtil.setConte…View(this, getLayoutId())");
        this.f34866a = a2;
        B b2 = this.f34866a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        int i2 = net.one97.paytm.feed.a.z;
        VM vm = this.f34867b;
        if (vm == null) {
            k.a("viewModel");
        }
        b2.setVariable(i2, vm);
        for (Map.Entry entry : d().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        e();
    }

    public void onPause() {
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.g();
        net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.i();
        super.onPause();
    }

    public void onResume() {
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        Context context = this;
        net.one97.paytm.feed.events.f.a(context);
        net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.h();
        super.onResume();
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }
}
