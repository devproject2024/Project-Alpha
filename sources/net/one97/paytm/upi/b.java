package net.one97.paytm.upi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import kotlin.g.b.k;
import kotlin.x;

public abstract class b<T extends RecyclerView.v> extends RecyclerView.a<T> {

    /* renamed from: b  reason: collision with root package name */
    protected Context f66587b;

    /* renamed from: c  reason: collision with root package name */
    public kotlin.g.a.b<? super x, x> f66588c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66589d;

    public final Context a() {
        Context context = this.f66587b;
        if (context == null) {
            k.a("context");
        }
        return context;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        k.a((Object) context, "recyclerView.context");
        this.f66587b = context;
        recyclerView.addOnScrollListener(new C1343b(this));
    }

    /* renamed from: net.one97.paytm.upi.b$b  reason: collision with other inner class name */
    public static final class C1343b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66592a;

        C1343b(b bVar) {
            this.f66592a = bVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.a.b<? super x, x> bVar;
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                k.a((Object) layoutManager, "recyclerView.layoutManager ?: return");
                if (layoutManager instanceof LinearLayoutManager) {
                    b bVar2 = this.f66592a;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    boolean z = true;
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() != linearLayoutManager.getItemCount() - 1) {
                        z = false;
                    }
                    if (z && bVar2.f66589d && (bVar = bVar2.f66588c) != null) {
                        bVar.invoke(x.f47997a);
                    }
                }
            }
        }
    }

    public final String a(int i2) {
        Context context = this.f66587b;
        if (context == null) {
            k.a("context");
        }
        String string = context.getString(i2);
        k.a((Object) string, "context.getString(id)");
        return string;
    }

    /* access modifiers changed from: protected */
    public final View a(int i2, ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        Context context = this.f66587b;
        if (context == null) {
            k.a("context");
        }
        View inflate = LayoutInflater.from(context).inflate(i2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…ate(resId, parent, false)");
        return inflate;
    }

    public static final class a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
