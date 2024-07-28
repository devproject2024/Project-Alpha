package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.k;
import androidx.lifecycle.o;
import androidx.lifecycle.q;

class FragmentStateAdapter$5 implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f4971a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f4972b;

    public final void a(q qVar, k.a aVar) {
        if (aVar == k.a.ON_DESTROY) {
            this.f4971a.removeCallbacks(this.f4972b);
            qVar.getLifecycle().b(this);
        }
    }
}
