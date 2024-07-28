package net.one97.paytm.moneytransferv4.b.a.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import kotlin.g.b.k;

public abstract class e<T extends RecyclerView.v> extends RecyclerView.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f55347a;

    public abstract int a();

    public abstract void a(T t, int i2);

    public abstract void a(d dVar);

    public void onBindViewHolder(T t, int i2) {
        k.c(t, "holder");
    }
}
