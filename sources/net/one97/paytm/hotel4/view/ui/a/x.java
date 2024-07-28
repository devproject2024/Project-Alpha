package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.h;
import com.paytm.utility.q;
import com.travel.utils.l;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.gi;

public final class x extends b {

    /* renamed from: a  reason: collision with root package name */
    public SRPHeaderViewModel f29025a;

    /* renamed from: b  reason: collision with root package name */
    public SRPViewModel f29026b;

    /* renamed from: c  reason: collision with root package name */
    public SharedViewModel f29027c;

    /* renamed from: d  reason: collision with root package name */
    LottieAnimationView f29028d;

    /* renamed from: e  reason: collision with root package name */
    private gi f29029e;

    static final class b<T> implements z<HotelSearchResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f29031a;

        b(x xVar) {
            this.f29031a = xVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f29031a.a().onSuccess("3", (HotelSearchResponse) obj);
        }
    }

    static final class c<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f29032a;

        c(x xVar) {
            this.f29032a = xVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f29032a.a().onError("3", (ErrorData) obj);
        }
    }

    static final class d<T> implements h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f29033a;

        d(x xVar) {
            this.f29033a = xVar;
        }

        public final /* synthetic */ void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            x xVar = this.f29033a;
            k.a((Object) th, "result");
            k.c(th, "result");
            q.b("urlAnimationError");
            if (xVar.f29028d != null) {
                LottieAnimationView lottieAnimationView = xVar.f29028d;
                if (lottieAnimationView != null) {
                    lottieAnimationView.cancelAnimation();
                }
                LottieAnimationView lottieAnimationView2 = xVar.f29028d;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(4);
                }
            }
        }
    }

    public final SRPViewModel a() {
        SRPViewModel sRPViewModel = this.f29026b;
        if (sRPViewModel == null) {
            k.a("srpViewModel");
        }
        return sRPViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        gi a2 = gi.a(layoutInflater, viewGroup);
        k.a((Object) a2, "Hotel4SrpLoaderBinding.i…flater, container, false)");
        this.f29029e = a2;
        gi giVar = this.f29029e;
        if (giVar == null) {
            k.a("dataBinding");
        }
        this.f29028d = (LottieAnimationView) giVar.getRoot().findViewById(R.id.lottieAnim);
        LottieAnimationView lottieAnimationView = this.f29028d;
        if (lottieAnimationView != null) {
            try {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setImageAssetsFolder("images/");
                lottieAnimationView.setAnimationFromUrl(f.b());
                lottieAnimationView.setFailureListener(new d(this));
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
            this.f29027c = (SharedViewModel) a3;
            SharedViewModel sharedViewModel = this.f29027c;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a4 = am.a(activity, viewModelFactory).a(SRPViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…SRPViewModel::class.java)");
            this.f29026b = (SRPViewModel) a4;
            ai a5 = am.a(activity, viewModelFactory).a(SRPHeaderViewModel.class);
            k.a((Object) a5, "ViewModelProviders.of(it…derViewModel::class.java)");
            this.f29025a = (SRPHeaderViewModel) a5;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f29025a;
        if (sRPHeaderViewModel == null) {
            k.a("srpHeaderViewModel");
        }
        sRPHeaderViewModel.updateData();
        gi giVar2 = this.f29029e;
        if (giVar2 == null) {
            k.a("dataBinding");
        }
        SRPHeaderViewModel sRPHeaderViewModel2 = this.f29025a;
        if (sRPHeaderViewModel2 == null) {
            k.a("srpHeaderViewModel");
        }
        giVar2.a(sRPHeaderViewModel2);
        gi giVar3 = this.f29029e;
        if (giVar3 == null) {
            k.a("dataBinding");
        }
        giVar3.setLifecycleOwner(this);
        try {
            new Handler().postDelayed(new a(this), 2000);
        } catch (Exception unused) {
        }
        gi giVar4 = this.f29029e;
        if (giVar4 == null) {
            k.a("dataBinding");
        }
        return giVar4.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            SRPViewModel sRPViewModel = this.f29026b;
            if (sRPViewModel == null) {
                k.a("srpViewModel");
            }
            l<HotelSearchResponse> apiCallSuccess = sRPViewModel.getApiCallSuccess();
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            k.a((Object) viewLifecycleOwner, "viewLifecycleOwner");
            apiCallSuccess.observe(viewLifecycleOwner, new b(this));
            SRPViewModel sRPViewModel2 = this.f29026b;
            if (sRPViewModel2 == null) {
                k.a("srpViewModel");
            }
            l<ErrorData> apiCallFailure = sRPViewModel2.getApiCallFailure();
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            k.a((Object) viewLifecycleOwner2, "viewLifecycleOwner");
            apiCallFailure.observe(viewLifecycleOwner2, new c(this));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f29030a;

        a(x xVar) {
            this.f29030a = xVar;
        }

        public final void run() {
            if (this.f29030a.getActivity() != null) {
                SRPViewModel a2 = this.f29030a.a();
                FragmentActivity activity = this.f29030a.getActivity();
                a2.initSrpRepository(new net.one97.paytm.hotel4.service.a.f(activity != null ? activity.getApplication() : null));
                SRPViewModel.fetchSearchData$default(this.f29030a.a(), 0, 1, (Object) null);
            }
        }
    }
}
