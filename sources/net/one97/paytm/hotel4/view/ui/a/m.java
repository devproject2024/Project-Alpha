package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fq;

public final class m extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public SRPHeaderViewModel f28888a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28889b;

    /* renamed from: c  reason: collision with root package name */
    private fq f28890c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f28891d;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        fq a2 = fq.a(layoutInflater, viewGroup);
        k.a((Object) a2, "Hotel4LoaderBinding.infl…flater, container, false)");
        this.f28890c = a2;
        fq fqVar = this.f28890c;
        if (fqVar == null) {
            k.a("dataBinding");
        }
        this.f28891d = (LottieAnimationView) fqVar.getRoot().findViewById(R.id.lottieAnim);
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        fq fqVar2 = this.f28890c;
        if (fqVar2 == null) {
            k.a("dataBinding");
        }
        a.C0498a.a(fqVar2.f29746a, f.c("noroomsavailable"));
        LottieAnimationView lottieAnimationView = this.f28891d;
        if (lottieAnimationView != null) {
            try {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setImageAssetsFolder("images/");
                lottieAnimationView.setAnimationFromUrl(f.b());
                lottieAnimationView.playAnimation();
                lottieAnimationView.loop(true);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a3 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28889b = (SharedViewModel) a3;
            SharedViewModel sharedViewModel = this.f28889b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a4 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(SRPHeaderViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…derViewModel::class.java)");
            this.f28888a = (SRPHeaderViewModel) a4;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f28888a;
        if (sRPHeaderViewModel == null) {
            k.a("srpHeaderViewModel");
        }
        sRPHeaderViewModel.updateData();
        fq fqVar3 = this.f28890c;
        if (fqVar3 == null) {
            k.a("dataBinding");
        }
        SRPHeaderViewModel sRPHeaderViewModel2 = this.f28888a;
        if (sRPHeaderViewModel2 == null) {
            k.a("srpHeaderViewModel");
        }
        fqVar3.a(sRPHeaderViewModel2);
        fq fqVar4 = this.f28890c;
        if (fqVar4 == null) {
            k.a("dataBinding");
        }
        fqVar4.setLifecycleOwner(this);
        fq fqVar5 = this.f28890c;
        if (fqVar5 == null) {
            k.a("dataBinding");
        }
        fqVar5.f29747b.setOnClickListener(new a(this));
        fq fqVar6 = this.f28890c;
        if (fqVar6 == null) {
            k.a("dataBinding");
        }
        fqVar6.f29748c.setOnClickListener(new b(this));
        fq fqVar7 = this.f28890c;
        if (fqVar7 == null) {
            k.a("dataBinding");
        }
        fqVar7.f29749d.setOnClickListener(new c(this));
        fq fqVar8 = this.f28890c;
        if (fqVar8 == null) {
            k.a("dataBinding");
        }
        return fqVar8.getRoot();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f28892a;

        a(m mVar) {
            this.f28892a = mVar;
        }

        public final void onClick(View view) {
            this.f28892a.a();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f28893a;

        b(m mVar) {
            this.f28893a = mVar;
        }

        public final void onClick(View view) {
            this.f28893a.a();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f28894a;

        c(m mVar) {
            this.f28894a = mVar;
        }

        public final void onClick(View view) {
            this.f28894a.a();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        getActivity();
    }

    public final void a() {
        FragmentActivity activity;
        if (getActivity() != null && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
    }
}
