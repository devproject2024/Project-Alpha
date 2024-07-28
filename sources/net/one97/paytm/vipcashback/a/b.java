package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.vipcashback.R;

public abstract class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.l f20548a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20549b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f20550c = 5;

    /* renamed from: d  reason: collision with root package name */
    int f20551d;

    /* renamed from: e  reason: collision with root package name */
    int f20552e;

    /* renamed from: f  reason: collision with root package name */
    boolean f20553f;

    /* renamed from: g  reason: collision with root package name */
    kotlin.g.a.a<x> f20554g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20555h;

    /* renamed from: i  reason: collision with root package name */
    private final RecyclerView f20556i;

    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(int i2);

    public abstract RecyclerView.v a(ViewGroup viewGroup, int i2);

    public abstract void a(RecyclerView.v vVar, int i2);

    public b(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        this.f20556i = recyclerView;
        if (this.f20556i.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = this.f20556i.getLayoutManager();
            if (layoutManager != null) {
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                this.f20548a = new RecyclerView.l(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f20557a;

                    {
                        this.f20557a = r1;
                    }

                    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                        k.c(recyclerView, "recyclerView");
                        super.onScrolled(recyclerView, i2, i3);
                        if (i2 > 0 || i3 > 0) {
                            this.f20557a.f20552e = linearLayoutManager.getItemCount();
                            this.f20557a.f20551d = linearLayoutManager.findLastVisibleItemPosition();
                            if (!this.f20557a.f20553f && this.f20557a.f20552e <= this.f20557a.f20551d + this.f20557a.f20550c) {
                                b bVar = this.f20557a;
                                bVar.f20553f = true;
                                kotlin.g.a.a<x> aVar = bVar.f20554g;
                                if (aVar != null) {
                                    aVar.invoke();
                                }
                            }
                        }
                    }
                };
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public final void a(kotlin.g.a.a<x> aVar) {
        this.f20554g = aVar;
        if (aVar == null) {
            RecyclerView.l lVar = this.f20548a;
            if (lVar != null) {
                this.f20556i.removeOnScrollListener(lVar);
                return;
            }
            return;
        }
        RecyclerView.l lVar2 = this.f20548a;
        if (lVar2 != null) {
            this.f20556i.addOnScrollListener(lVar2);
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        LottieAnimationView f20559a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f20560b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f20560b = bVar;
            View findViewById = view.findViewById(R.id.loader);
            k.a((Object) findViewById, "v.findViewById<LottieAnimationView>(R.id.loader)");
            this.f20559a = (LottieAnimationView) findViewById;
        }
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof a) {
            net.one97.paytm.common.widgets.a.a(((a) vVar).f20559a);
        } else {
            a(vVar, i2);
        }
    }

    public final void b() {
        this.f20555h = true;
        notifyItemInserted(getItemCount() + 1);
    }

    public final int getItemCount() {
        if (!this.f20555h) {
            return a();
        }
        return a() + 1;
    }

    public final int getItemViewType(int i2) {
        if (a() == i2) {
            return this.f20549b;
        }
        return a(i2);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        if (i2 != this.f20549b) {
            return a(viewGroup, i2);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progressbar_item, viewGroup, false);
        k.a((Object) inflate, "progressView");
        Context context = inflate.getContext();
        k.a((Object) context, "progressView.context");
        ((RelativeLayout) inflate.findViewById(R.id.main_content)).setBackgroundColor(context.getResources().getColor(net.one97.paytm.common.assets.R.color.white));
        if (this.f20556i.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = this.f20556i.getLayoutManager();
            if (layoutManager == null) {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            } else if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.loader);
                ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.addRule(13, -1);
                    lottieAnimationView.setLayoutParams(layoutParams2);
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
        }
        return new a(this, inflate);
    }

    public static /* synthetic */ void a(b bVar) {
        bVar.f20555h = false;
        bVar.f20553f = false;
        bVar.notifyItemRemoved(bVar.getItemCount());
    }
}
