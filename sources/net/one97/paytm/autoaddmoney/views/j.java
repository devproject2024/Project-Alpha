package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.autoaddmoney.c.b;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd;

public final class j extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.autoaddmoney.c.b f49463a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f49464b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f49465c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f49466d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f49467e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f49468f;

    static final class e<T> implements z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49474a;

        e(j jVar) {
            this.f49474a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            com.paytm.network.a aVar2 = aVar != null ? (com.paytm.network.a) aVar.f49111a : null;
            j jVar = this.f49474a;
            if (aVar2 == null) {
                k.a();
            }
            jVar.a(aVar2);
            j.a(this.f49474a, false);
        }
    }

    static final class f<T> implements z<net.one97.paytm.autoaddmoney.a<? extends CJRSubscribeDisableAutoAdd>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49475a;

        f(j jVar) {
            this.f49475a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            CJRSubscribeDisableAutoAdd cJRSubscribeDisableAutoAdd = aVar != null ? (CJRSubscribeDisableAutoAdd) aVar.f49111a : null;
            if (cJRSubscribeDisableAutoAdd == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd");
            } else if (p.a(cJRSubscribeDisableAutoAdd.getStatusMessage(), "SUCCESS", true)) {
                this.f49475a.dismiss();
            } else {
                com.paytm.utility.g.b(this.f49475a.getActivity(), this.f49475a.getString(R.string.alert), cJRSubscribeDisableAutoAdd.getStatusMessage());
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49476a;

        g(j jVar) {
            this.f49476a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            net.one97.paytm.autoaddmoney.b.d dVar = aVar != null ? (net.one97.paytm.autoaddmoney.b.d) aVar.a() : null;
            if (dVar != null) {
                j.a(this.f49476a, dVar.f49160b);
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.autoaddmoney.a<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49477a;

        h(j jVar) {
            this.f49477a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (this.f49477a.a()) {
                com.paytm.utility.b.b(this.f49477a.getActivity(), this.f49477a.getString(R.string.error), aVar != null ? (String) aVar.a() : null);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.autoaddmoney.c.b a(j jVar) {
        net.one97.paytm.autoaddmoney.c.b bVar = jVar.f49463a;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(net.one97.paytm.autoaddmoney.c.b.class);
            k.a((Object) a2, "ViewModelProviders.of(it…entViewModel::class.java)");
            this.f49463a = (net.one97.paytm.autoaddmoney.c.b) a2;
        }
        return layoutInflater.inflate(R.layout.layout_disable_am_bottomsheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.autoaddmoney.c.b bVar = this.f49463a;
        if (bVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        bVar.f49199f.observe(qVar, new e(this));
        net.one97.paytm.autoaddmoney.c.b bVar2 = this.f49463a;
        if (bVar2 == null) {
            k.a("viewModel");
        }
        bVar2.m.observe(qVar, new f(this));
        net.one97.paytm.autoaddmoney.c.b bVar3 = this.f49463a;
        if (bVar3 == null) {
            k.a("viewModel");
        }
        bVar3.f49194a.observe(qVar, new g(this));
        net.one97.paytm.autoaddmoney.c.b bVar4 = this.f49463a;
        if (bVar4 == null) {
            k.a("viewModel");
        }
        bVar4.j.observe(qVar, new h(this));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.change_layout);
        if (relativeLayout == null) {
            k.a();
        }
        this.f49464b = relativeLayout;
        TextView textView = (TextView) view.findViewById(R.id.tv_activate_am);
        if (textView == null) {
            k.a();
        }
        this.f49465c = textView;
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.loader_container);
        if (relativeLayout2 == null) {
            k.a();
        }
        this.f49466d = relativeLayout2;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.view_loader);
        if (lottieAnimationView == null) {
            k.a();
        }
        this.f49467e = lottieAnimationView;
        ((TextView) view.findViewById(R.id.cancel_action)).setOnClickListener(new b(this));
        ((TextView) view.findViewById(R.id.tv_activate_am)).setOnClickListener(new c(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49470a;

        b(j jVar) {
            this.f49470a = jVar;
        }

        public final void onClick(View view) {
            this.f49470a.dismiss();
            net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity = this.f49470a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context context = activity;
            Bundle arguments = this.f49470a.getArguments();
            if (arguments == null) {
                k.a();
            }
            a2.a(context, "Auto Add Money", "Cancel_subscription_declined", "", arguments.getString("source", ""), "", "", "");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49471a;

        c(j jVar) {
            this.f49471a = jVar;
        }

        public final void onClick(View view) {
            j.a(this.f49471a, true);
            net.one97.paytm.autoaddmoney.c.b a2 = j.a(this.f49471a);
            a2.s.a((a.b) new b.a(a2));
            net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity = this.f49471a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context context = activity;
            Bundle arguments = this.f49471a.getArguments();
            if (arguments == null) {
                k.a();
            }
            a3.a(context, "Auto Add Money", "Cancel_subscription_confirmed", "", arguments.getString("source", ""), "", "", "");
        }
    }

    /* access modifiers changed from: private */
    public final boolean a() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        return !activity.isFinishing();
    }

    public final void a(com.paytm.network.a aVar) {
        k.c(aVar, "request");
        if (a()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new d(this, aVar));
            builder.show();
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f49472a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f49473b;

        d(j jVar, com.paytm.network.a aVar) {
            this.f49472a = jVar;
            this.f49473b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f49472a.getActivity())) {
                j.a(this.f49472a, true);
                this.f49473b.a();
                return;
            }
            this.f49472a.a(this.f49473b);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f49469a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49469a = new a();

        a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        from.setState(3);
                        from.setPeekHeight(500);
                        from.setHideable(true);
                        from.setSkipCollapsed(false);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public static final /* synthetic */ void a(j jVar, boolean z) {
        if (z) {
            RelativeLayout relativeLayout = jVar.f49466d;
            if (relativeLayout == null) {
                k.a("mLoaderContainer");
            }
            relativeLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = jVar.f49467e;
            if (lottieAnimationView == null) {
                k.a("mLoaderView");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
            return;
        }
        com.paytm.utility.b.c((Activity) jVar.getActivity());
        RelativeLayout relativeLayout2 = jVar.f49466d;
        if (relativeLayout2 == null) {
            k.a("mLoaderContainer");
        }
        relativeLayout2.setVisibility(8);
        LottieAnimationView lottieAnimationView2 = jVar.f49467e;
        if (lottieAnimationView2 == null) {
            k.a("mLoaderView");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView2);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49468f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
