package net.one97.paytm.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.concurrent.Future;
import kotlin.g.b.k;
import kotlin.o;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Future<?>> f49512a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<o<LiveData<Object>, z<Object>>> f49513b = new ArrayList<>();

    public final void a(Future<?> future) {
        k.c(future, "future");
        this.f49512a.add(future);
    }
}
