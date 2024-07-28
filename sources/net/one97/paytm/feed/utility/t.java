package net.one97.paytm.feed.utility;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z;
import kotlin.g.b.k;

public final class t extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private int f35434a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final z f35435b;

    /* renamed from: c  reason: collision with root package name */
    private a f35436c;

    /* renamed from: d  reason: collision with root package name */
    private b f35437d;

    public enum a {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    public interface b {
        void a(int i2);
    }

    public t(z zVar, a aVar, b bVar) {
        k.c(zVar, "snapHelper");
        k.c(aVar, "behavior");
        k.c(bVar, "onSnapPositionChangeListener");
        this.f35435b = zVar;
        this.f35436c = aVar;
        this.f35437d = bVar;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        if (this.f35436c == a.NOTIFY_ON_SCROLL) {
            a(recyclerView);
        }
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        k.c(recyclerView, "recyclerView");
        if (this.f35436c == a.NOTIFY_ON_SCROLL_STATE_IDLE && i2 == 0) {
            a(recyclerView);
        }
    }

    private final void a(RecyclerView recyclerView) {
        int a2 = a(this.f35435b, recyclerView);
        if (this.f35434a != a2) {
            this.f35437d.a(a2);
            this.f35434a = a2;
        }
    }

    private static int a(z zVar, RecyclerView recyclerView) {
        k.c(zVar, "$this$getSnapPosition");
        k.c(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        k.a((Object) layoutManager, "recyclerView.layoutManag… RecyclerView.NO_POSITION");
        View findSnapView = zVar.findSnapView(layoutManager);
        if (findSnapView == null) {
            return -1;
        }
        k.a((Object) findSnapView, "findSnapView(layoutManag… RecyclerView.NO_POSITION");
        return layoutManager.getPosition(findSnapView);
    }
}
