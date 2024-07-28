package net.one97.paytm.upgradeKyc.videokyc.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
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
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;

public final class a extends h {

    /* renamed from: d  reason: collision with root package name */
    public static final C1331a f66343d = new C1331a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f66344f = "type";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static String f66345g = "appointment_type";

    /* renamed from: a  reason: collision with root package name */
    public b f66346a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.videokyc.b.d f66347b;

    /* renamed from: c  reason: collision with root package name */
    final String f66348c = "paytmmp://events?insiderH5Url=https://h5.insider.in/event/paytm-kyc-slot-booking/buy/shows";

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.b.c f66349e;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f66350h;

    public interface b {
        void i();

        net.one97.paytm.upgradeKyc.videokyc.b.d l();
    }

    public final b a() {
        b bVar = this.f66346a;
        if (bVar == null) {
            k.a("mHost");
        }
        return bVar;
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.a.a$a  reason: collision with other inner class name */
    public static final class C1331a {
        private C1331a() {
        }

        public /* synthetic */ C1331a(byte b2) {
            this();
        }

        public static a a(String str, String str2) {
            k.c(str, "type");
            k.c(str2, "appointmentType");
            a aVar = new a();
            Bundle bundle = new Bundle();
            C1331a aVar2 = a.f66343d;
            bundle.putString(a.f66344f, str);
            C1331a aVar3 = a.f66343d;
            bundle.putString(a.f66345g, str2);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66346a = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement AgentNABusyFragment.InteractionListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.fragment_agent_status, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        this.f66349e = (net.one97.paytm.upgradeKyc.b.c) a2;
        net.one97.paytm.upgradeKyc.b.c cVar = this.f66349e;
        if (cVar == null) {
            k.a("binding");
        }
        return cVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        String str;
        String string;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString(f66344f)) == null)) {
            int hashCode = string.hashCode();
            if (hashCode != 2483) {
                if (hashCode == 2050553 && string.equals("BUSY")) {
                    net.one97.paytm.upgradeKyc.b.c cVar = this.f66349e;
                    if (cVar == null) {
                        k.a("binding");
                    }
                    cVar.f65581d.setImageResource(R.drawable.kyc_agent_busy);
                    net.one97.paytm.upgradeKyc.b.c cVar2 = this.f66349e;
                    if (cVar2 == null) {
                        k.a("binding");
                    }
                    TextView textView = cVar2.m;
                    k.a((Object) textView, "binding.tvTitle");
                    textView.setText(getString(R.string.kyc_were_sorry));
                    net.one97.paytm.upgradeKyc.b.c cVar3 = this.f66349e;
                    if (cVar3 == null) {
                        k.a("binding");
                    }
                    TextView textView2 = cVar3.l;
                    k.a((Object) textView2, "binding.tvDesc");
                    textView2.setText(getString(R.string.kyc_our_executives_are_busy));
                }
            } else if (string.equals("NA")) {
                net.one97.paytm.upgradeKyc.b.c cVar4 = this.f66349e;
                if (cVar4 == null) {
                    k.a("binding");
                }
                cVar4.f65581d.setImageResource(R.drawable.kyc_agents_outtime);
                net.one97.paytm.upgradeKyc.b.c cVar5 = this.f66349e;
                if (cVar5 == null) {
                    k.a("binding");
                }
                TextView textView3 = cVar5.m;
                k.a((Object) textView3, "binding.tvTitle");
                textView3.setText(getString(R.string.kyc_oops));
                net.one97.paytm.upgradeKyc.b.c cVar6 = this.f66349e;
                if (cVar6 == null) {
                    k.a("binding");
                }
                TextView textView4 = cVar6.l;
                k.a((Object) textView4, "binding.tvDesc");
                textView4.setText(getString(R.string.kyc_our_kyc_executives_not_available));
            }
        }
        net.one97.paytm.upgradeKyc.b.c cVar7 = this.f66349e;
        if (cVar7 == null) {
            k.a("binding");
        }
        cVar7.f65579b.setOnClickListener(new c(this));
        net.one97.paytm.upgradeKyc.b.c cVar8 = this.f66349e;
        if (cVar8 == null) {
            k.a("binding");
        }
        cVar8.f65580c.setOnClickListener(new d(this));
        net.one97.paytm.upgradeKyc.b.c cVar9 = this.f66349e;
        if (cVar9 == null) {
            k.a("binding");
        }
        cVar9.f65578a.setOnClickListener(new e(this));
        b bVar = this.f66346a;
        if (bVar == null) {
            k.a("mHost");
        }
        this.f66347b = bVar.l();
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66347b;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        if (k.a((Object) dVar.p, (Object) "user_is_early_as_per_appointment_booked_time")) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66347b;
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
                net.one97.paytm.upgradeKyc.b.c cVar10 = this.f66349e;
                if (cVar10 == null) {
                    k.a("binding");
                }
                TextView textView5 = cVar10.o;
                k.a((Object) textView5, "binding.tvUpcomingAppointmentInfo");
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(0));
                sb.append(AppConstants.COMMA);
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66347b;
                if (dVar3 == null) {
                    k.a("sharedViewModel");
                }
                FulfillmentReq fulfillmentReq2 = dVar3.q;
                if (fulfillmentReq2 != null) {
                    str2 = fulfillmentReq2.itemName;
                }
                sb.append(str2);
                textView5.setText(sb.toString());
            }
            net.one97.paytm.upgradeKyc.b.c cVar11 = this.f66349e;
            if (cVar11 == null) {
                k.a("binding");
            }
            LinearLayout linearLayout = cVar11.p;
            k.a((Object) linearLayout, "binding.userEarlyView");
            linearLayout.setVisibility(0);
            net.one97.paytm.upgradeKyc.b.c cVar12 = this.f66349e;
            if (cVar12 == null) {
                k.a("binding");
            }
            TextView textView6 = cVar12.f65578a;
            k.a((Object) textView6, "binding.appointmentBookTv");
            textView6.setText(getString(R.string.kyc_i_will_try_appointment_on_time));
            net.one97.paytm.upgradeKyc.b.c cVar13 = this.f66349e;
            if (cVar13 == null) {
                k.a("binding");
            }
            TextView textView7 = cVar13.f65580c;
            k.a((Object) textView7, "binding.btnTryLater");
            textView7.setVisibility(8);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66351a;

        c(a aVar) {
            this.f66351a = aVar;
        }

        public final void onClick(View view) {
            if (this.f66351a.getContext() != null && (this.f66351a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66351a.getContext();
                if (context != null) {
                    ((UpgradeKycBaseActivity) context).b("go_back_clicked", "/kyc/video_kyc/agents_busy");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            this.f66351a.a().i();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66352a;

        d(a aVar) {
            this.f66352a = aVar;
        }

        public final void onClick(View view) {
            if (this.f66352a.getContext() != null && (this.f66352a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66352a.getContext();
                if (context != null) {
                    ((UpgradeKycBaseActivity) context).b("later_button_clicked", "/kyc/video_kyc/agents_busy");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            this.f66352a.a().i();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66353a;

        e(a aVar) {
            this.f66353a = aVar;
        }

        public final void onClick(View view) {
            if (this.f66353a.getContext() != null && (this.f66353a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66353a.getContext();
                if (context != null) {
                    ((UpgradeKycBaseActivity) context).b("appointment_button_clicked", "/kyc/video_kyc/agents_busy");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66353a.f66347b;
            if (dVar == null) {
                k.a("sharedViewModel");
            }
            if (k.a((Object) dVar.p, (Object) "user_is_early_as_per_appointment_booked_time")) {
                this.f66353a.a().i();
                return;
            }
            d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kycBookAppointmentDeepLink") : null;
            CharSequence charSequence = a2;
            if (charSequence == null || charSequence.length() == 0) {
                a2 = this.f66353a.f66348c;
            }
            if (this.f66353a.getContext() != null && (this.f66353a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context2 = this.f66353a.getContext();
                if (context2 != null) {
                    ((UpgradeKycBaseActivity) context2).b("insider_deeplink_invoked", "/kyc/video_kyc/agents_busy");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            e.a aVar2 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            net.one97.paytm.upgradeKyc.helper.f fVar = e.a.a().f66030a;
            if (fVar != null) {
                Context context3 = this.f66353a.getContext();
                if (context3 == null) {
                    k.a();
                }
                k.a((Object) context3, "context!!");
                fVar.a(context3, a2);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66350h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
