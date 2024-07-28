package net.one97.paytm.upgradeKyc.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import androidx.appcompat.app.c;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.f.b;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.helper.f;
import net.one97.paytm.upgradeKyc.utils.l;

public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65701a;

    public final View a(int i2) {
        if (this.f65701a == null) {
            this.f65701a = new HashMap();
        }
        View view = (View) this.f65701a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65701a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_kyc_something_went_wrong, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((Button) a(R.id.fragment_request_visit_button_book)).setOnClickListener(new b(this));
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f65703a;

        b(j jVar) {
            this.f65703a = jVar;
        }

        public final void onClick(View view) {
            j.a(this.f65703a);
        }
    }

    public static final class a implements net.one97.paytm.upgradeKyc.f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f65702a;

        a(j jVar) {
            this.f65702a = jVar;
        }

        public final void a(String str) {
            e.a aVar = e.f66028b;
            f b2 = e.a.b();
            FragmentActivity activity = this.f65702a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context context = activity;
            if (str == null) {
                k.a();
            }
            b2.a(context, str);
        }

        public final void a(NetworkCustomError networkCustomError) {
            if (networkCustomError != null && this.f65702a.getActivity() != null) {
                l.a();
                FragmentActivity activity = this.f65702a.getActivity();
                if (activity == null) {
                    k.a();
                }
                if (!l.a((Context) activity, networkCustomError)) {
                    com.paytm.utility.b.b((Context) this.f65702a.getActivity(), this.f65702a.getResources().getString(R.string.error), this.f65702a.getResources().getString(R.string.msg_invalid_url));
                }
            }
        }

        public final void a() {
            j.b(this.f65702a);
        }

        public final void b() {
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65702a.a(R.id.wallet_loader));
        }

        public final void a(Intent intent) {
            k.c(intent, "intent");
            if (this.f65702a.isResumed()) {
                this.f65702a.startActivity(intent);
            }
        }

        public final void c() {
            FragmentActivity activity = this.f65702a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        public final void d() {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65702a.a(R.id.wallet_loader));
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f65704a;

        c(j jVar) {
            this.f65704a = jVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            FragmentActivity activity = this.f65704a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        Context context = jVar.getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        net.one97.paytm.upgradeKyc.f.b bVar = new net.one97.paytm.upgradeKyc.f.b(context, new a(jVar));
        bVar.f65967b = null;
        bVar.f65968c = null;
        d.a aVar = d.f66026a;
        bVar.f65970e = d.a.a() != null ? d.a("mwGetAppointmentV3Url") : null;
        if (!URLUtil.isValidUrl(bVar.f65970e)) {
            net.one97.paytm.upgradeKyc.f.a aVar2 = bVar.f65966a;
            if (aVar2 != null) {
                aVar2.a((NetworkCustomError) null);
                return;
            }
            return;
        }
        bVar.f65970e = com.paytm.utility.b.e(bVar.f65969d, bVar.f65970e);
        bVar.f65970e += "&userInterest=true&leadSource=App";
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(bVar.f65969d);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("session_token", a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l = a.C1317a.a().a(bVar.f65969d).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KycSavedUserData()).a(bVar.f65970e).a(false).c(net.one97.paytm.upgradeKyc.f.b.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new b.a(bVar)).l();
        if (com.paytm.utility.b.c(bVar.f65969d)) {
            net.one97.paytm.upgradeKyc.f.a aVar4 = bVar.f65966a;
            if (aVar4 != null) {
                aVar4.b();
            }
            l.a();
            return;
        }
        net.one97.paytm.upgradeKyc.f.a aVar5 = bVar.f65966a;
        if (aVar5 != null) {
            aVar5.d();
        }
        net.one97.paytm.upgradeKyc.f.a aVar6 = bVar.f65966a;
        if (aVar6 != null) {
            aVar6.a();
        }
    }

    public static final /* synthetic */ void b(j jVar) {
        FragmentActivity activity = jVar.getActivity();
        if (activity == null) {
            k.a();
        }
        c.a aVar = new c.a(activity);
        aVar.b((CharSequence) jVar.getString(net.one97.paytm.common.assets.R.string.no_internet));
        aVar.a(false);
        aVar.a((CharSequence) "Ok", (DialogInterface.OnClickListener) new c(jVar));
        aVar.b();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65701a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
