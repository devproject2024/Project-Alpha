package net.one97.paytm.recharge.common.e;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;

public interface g<T extends RecyclerView.v> {
    T a(ViewGroup viewGroup);

    void a(T t, int i2);

    long c_(int i2);

    int getItemCount();
}
