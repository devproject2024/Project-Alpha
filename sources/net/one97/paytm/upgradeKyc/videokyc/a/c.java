package net.one97.paytm.upgradeKyc.videokyc.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.FulfillmentReq;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.b.g;

public final class c extends h {

    /* renamed from: c  reason: collision with root package name */
    public static final a f66356c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f66357a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.videokyc.b.d f66358b;

    /* renamed from: d  reason: collision with root package name */
    private g f66359d;

    /* renamed from: e  reason: collision with root package name */
    private final z<Boolean> f66360e = new f(this);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f66361f;

    public interface b {
        void i();

        void j();

        void k();

        net.one97.paytm.upgradeKyc.videokyc.b.d l();
    }

    static final class f<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66365a;

        f(c cVar) {
            this.f66365a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                b bVar = new b();
                FragmentActivity activity = this.f66365a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                bVar.show(activity.getSupportFragmentManager(), "ComeOnAppointmentTimeSheet");
                return;
            }
            this.f66365a.a().k();
        }
    }

    public final b a() {
        b bVar = this.f66357a;
        if (bVar == null) {
            k.a("mHost");
        }
        return bVar;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66357a = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement EarlyAppointmentVideoKycFragment.InteractionListener");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = androidx.databinding.f.a(layoutInflater, R.layout.fragment_early_appointment_video_kyc, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        this.f66359d = (g) a2;
        g gVar = this.f66359d;
        if (gVar == null) {
            k.a("binding");
        }
        return gVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        b bVar = this.f66357a;
        if (bVar == null) {
            k.a("mHost");
        }
        this.f66358b = bVar.l();
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66358b;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        dVar.t.observe(getViewLifecycleOwner(), this.f66360e);
        g gVar = this.f66359d;
        if (gVar == null) {
            k.a("binding");
        }
        gVar.f65596a.setOnClickListener(new C1332c(this));
        g gVar2 = this.f66359d;
        if (gVar2 == null) {
            k.a("binding");
        }
        gVar2.j.setOnClickListener(new d(this));
        g gVar3 = this.f66359d;
        if (gVar3 == null) {
            k.a("binding");
        }
        gVar3.l.setOnClickListener(new e(this));
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66358b;
        if (dVar2 == null) {
            k.a("sharedViewModel");
        }
        FulfillmentReq fulfillmentReq = dVar2.q;
        String str2 = null;
        if (fulfillmentReq == null || (str = fulfillmentReq.dateString) == null) {
            list = null;
        } else {
            list = p.a((CharSequence) str, new String[]{AppConstants.COMMA});
        }
        if (list != null && (!list.isEmpty())) {
            g gVar4 = this.f66359d;
            if (gVar4 == null) {
                k.a("binding");
            }
            TextView textView = gVar4.f65603h;
            k.a((Object) textView, "binding.tvAppointmentTime");
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            sb.append(AppConstants.COMMA);
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66358b;
            if (dVar3 == null) {
                k.a("sharedViewModel");
            }
            FulfillmentReq fulfillmentReq2 = dVar3.q;
            if (fulfillmentReq2 != null) {
                str2 = fulfillmentReq2.itemName;
            }
            sb.append(str2);
            textView.setText(sb.toString());
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.a.c$c  reason: collision with other inner class name */
    static final class C1332c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66362a;

        C1332c(c cVar) {
            this.f66362a = cVar;
        }

        public final void onClick(View view) {
            this.f66362a.a().i();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66363a;

        d(c cVar) {
            this.f66363a = cVar;
        }

        public final void onClick(View view) {
            if (this.f66363a.getContext() != null && (this.f66363a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66363a.getContext();
                if (context != null) {
                    ((UpgradeKycBaseActivity) context).b("try_later_click", "/kyc/video_kyc/appointment_early");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            this.f66363a.a().i();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66364a;

        e(c cVar) {
            this.f66364a = cVar;
        }

        public final void onClick(View view) {
            this.f66364a.a().j();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66361f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
