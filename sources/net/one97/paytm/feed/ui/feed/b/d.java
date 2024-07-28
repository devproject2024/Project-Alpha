package net.one97.paytm.feed.ui.feed.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.Stack;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.o;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;
import net.one97.paytm.feed.ui.feed.c;
import net.one97.paytm.feed.utility.t;

public final class d extends b<o, NestedFeed, Object> implements e, c.a, t.b {

    /* renamed from: b  reason: collision with root package name */
    boolean f35001b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f35002c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f35003d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35004e;

    /* renamed from: f  reason: collision with root package name */
    boolean f35005f = true;

    /* renamed from: g  reason: collision with root package name */
    public Stack<Integer> f35006g = new Stack<>();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f35007h = ((RecyclerView) this.j.findViewById(R.id.feed_coverage_recyclerview));

    /* renamed from: i  reason: collision with root package name */
    public a f35008i;
    public final View j;
    private boolean k;
    private LinearLayoutManager l;
    private t m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        k.c(view, "view");
        this.j = view;
        View findViewById = this.j.findViewById(R.id.progressLayout);
        k.a((Object) findViewById, "view.findViewById(R.id.progressLayout)");
        this.f35002c = (LinearLayout) findViewById;
        v vVar = new v();
        RecyclerView recyclerView = this.f35007h;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.l = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.l);
            vVar.attachToRecyclerView(recyclerView);
            recyclerView.setHasFixedSize(true);
        }
        this.f35008i = new a(this);
        RecyclerView recyclerView2 = this.f35007h;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f35008i);
        }
        this.m = new t(vVar, t.a.NOTIFY_ON_SCROLL, this);
        RecyclerView recyclerView3 = this.f35007h;
        if (recyclerView3 == null) {
            k.a();
        }
        t tVar = this.m;
        if (tVar == null) {
            k.a();
        }
        recyclerView3.addOnScrollListener(tVar);
    }

    public final void a() {
        this.k = true;
        ObjectAnimator objectAnimator = this.f35003d;
        if (objectAnimator != null) {
            objectAnimator.pause();
        }
    }

    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f35009a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35010b;

        public final void onAnimationCancel(Animator animator) {
            k.c(animator, "animator");
        }

        public final void onAnimationRepeat(Animator animator) {
            k.c(animator, "animator");
        }

        public final void onAnimationStart(Animator animator) {
            k.c(animator, "animator");
        }

        a(d dVar, int i2) {
            this.f35009a = dVar;
            this.f35010b = i2;
        }

        public final void onAnimationEnd(Animator animator) {
            k.c(animator, "animator");
            d dVar = this.f35009a;
            dVar.f35005f = true;
            if (!dVar.f35001b) {
                try {
                    RecyclerView recyclerView = this.f35009a.f35007h;
                    if (recyclerView != null) {
                        recyclerView.smoothScrollToPosition(this.f35010b + 1);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a(int i2) {
        if (this.f35005f) {
            this.f35005f = false;
        } else {
            this.f35001b = true;
        }
        if (!this.f35006g.contains(Integer.valueOf(i2))) {
            new StringBuilder("New item is visited ").append(this.f35006g);
            if (!this.f35006g.empty()) {
                ObjectAnimator objectAnimator = this.f35003d;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                if (this.f35001b && this.f35002c.getChildAt(i2) != null) {
                    View childAt = this.f35002c.getChildAt(i2);
                    if (childAt != null) {
                        ((ProgressBar) childAt).setProgress(100);
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
                    }
                }
                LinearLayout linearLayout = this.f35002c;
                Integer peek = this.f35006g.peek();
                k.a((Object) peek, "postionStack.peek()");
                if (linearLayout.getChildAt(peek.intValue()) != null) {
                    LinearLayout linearLayout2 = this.f35002c;
                    Integer peek2 = this.f35006g.peek();
                    k.a((Object) peek2, "postionStack.peek()");
                    View childAt2 = linearLayout2.getChildAt(peek2.intValue());
                    if (childAt2 != null) {
                        ((ProgressBar) childAt2).setProgress(100);
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
                    }
                }
            }
            this.f35006g.push(Integer.valueOf(i2));
            if (!this.f35001b) {
                this.f35003d = ObjectAnimator.ofInt(this.f35002c.getChildAt(i2), H5Param.PROGRESS, new int[]{0, 100});
                ObjectAnimator objectAnimator2 = this.f35003d;
                if (objectAnimator2 == null) {
                    k.a();
                }
                objectAnimator2.setDuration(7000);
                ObjectAnimator objectAnimator3 = this.f35003d;
                if (objectAnimator3 == null) {
                    k.a();
                }
                objectAnimator3.setInterpolator(new DecelerateInterpolator());
                ObjectAnimator objectAnimator4 = this.f35003d;
                if (objectAnimator4 == null) {
                    k.a();
                }
                objectAnimator4.addListener(new a(this, i2));
                ObjectAnimator objectAnimator5 = this.f35003d;
                if (objectAnimator5 == null) {
                    k.a();
                }
                objectAnimator5.start();
            }
        } else if (k.a(this.f35006g.peek().intValue(), i2) > 0) {
            new StringBuilder("Old item is visited ").append(this.f35006g.peek());
            ObjectAnimator objectAnimator6 = this.f35003d;
            if (objectAnimator6 != null) {
                objectAnimator6.cancel();
            }
            Integer pop = this.f35006g.pop();
            LinearLayout linearLayout3 = this.f35002c;
            k.a((Object) pop, "pos");
            if (linearLayout3.getChildAt(pop.intValue()) != null) {
                View childAt3 = this.f35002c.getChildAt(pop.intValue());
                if (childAt3 != null) {
                    ((ProgressBar) childAt3).setProgress(0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
            }
        }
    }
}
