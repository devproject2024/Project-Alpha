package net.one97.paytm.recharge.common.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.utils.ba;

public final class j extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f61261a;

    /* renamed from: b  reason: collision with root package name */
    HashMap f61262b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f61263c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f61264d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f61265e;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_lazy_loader, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.progress_view);
        if (findViewById != null) {
            this.f61261a = (RelativeLayout) findViewById;
            View findViewById2 = inflate.findViewById(R.id.loading_threedots);
            if (findViewById2 != null) {
                this.f61264d = (LottieAnimationView) findViewById2;
                ba.a(this.f61264d);
                ba.a(0, (View) this.f61261a);
                return inflate;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isResumed()) {
            onResume();
        }
    }

    public final void onResume() {
        Bundle arguments;
        if (!getUserVisibleHint()) {
            super.onResume();
            return;
        }
        if (!this.f61263c && (arguments = getArguments()) != null) {
            int i2 = arguments.getInt("fragment_position", 0);
            if (getActivity() instanceof y) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    Fragment b2 = ((y) activity).b(i2);
                    if (b2 != null) {
                        Handler handler = new Handler();
                        handler.postDelayed(new b(handler, b2, this), 300);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
        }
        super.onResume();
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f61267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f61268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f61269c;

        b(Handler handler, Fragment fragment, j jVar) {
            this.f61267a = handler;
            this.f61268b = fragment;
            this.f61269c = jVar;
        }

        public final void run() {
            View view;
            if (this.f61269c.getUserVisibleHint() && !this.f61269c.f61263c) {
                j jVar = this.f61269c;
                jVar.f61265e = jVar.f61265e + 1;
                if (this.f61269c.isAdded()) {
                    this.f61269c.f61263c = true;
                    Bundle arguments = this.f61268b.getArguments();
                    if (arguments != null) {
                        arguments.putBoolean("is_selected_in_tabs", true);
                    }
                    this.f61268b.setArguments(arguments);
                    q a2 = this.f61269c.getChildFragmentManager().a();
                    j jVar2 = this.f61269c;
                    int i2 = R.id.container_frame;
                    if (jVar2.f61262b == null) {
                        jVar2.f61262b = new HashMap();
                    }
                    View view2 = (View) jVar2.f61262b.get(Integer.valueOf(i2));
                    if (view2 == null) {
                        View view3 = jVar2.getView();
                        if (view3 == null) {
                            view = null;
                            FrameLayout frameLayout = (FrameLayout) view;
                            k.a((Object) frameLayout, "container_frame");
                            a2.a(frameLayout.getId(), this.f61268b).c();
                            new Handler().postDelayed(new a(this.f61269c), 10);
                        }
                        view2 = view3.findViewById(i2);
                        jVar2.f61262b.put(Integer.valueOf(i2), view2);
                    }
                    view = view2;
                    FrameLayout frameLayout2 = (FrameLayout) view;
                    k.a((Object) frameLayout2, "container_frame");
                    a2.a(frameLayout2.getId(), this.f61268b).c();
                    new Handler().postDelayed(new a(this.f61269c), 10);
                } else if (this.f61269c.f61265e < 3) {
                    this.f61267a.postDelayed(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f61270a;

                        {
                            this.f61270a = r1;
                        }

                        public final void run() {
                            this.f61270a.f61269c.onResume();
                        }
                    }, 1000);
                }
            }
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f61266a;

        a(j jVar) {
            this.f61266a = jVar;
        }

        public final void run() {
            ba.a(8, (View) this.f61266a.f61261a);
            ba.b(this.f61266a.f61264d);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61262b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
