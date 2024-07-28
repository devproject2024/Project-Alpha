package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;

public abstract class bs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f33993a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f33994b;

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f33995c;

    protected bs(Object obj, View view, FrameLayout frameLayout, RecyclerView recyclerView, TabLayout tabLayout) {
        super(obj, view, 0);
        this.f33993a = frameLayout;
        this.f33994b = recyclerView;
        this.f33995c = tabLayout;
    }
}
