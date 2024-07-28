package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.d.f;
import net.one97.paytm.bankOpen.ica.model.ICAStatusResponse;

public final class i extends net.one97.paytm.bankCommon.d.b {

    /* renamed from: b  reason: collision with root package name */
    private f f16546b;

    /* renamed from: c  reason: collision with root package name */
    private d f16547c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f16548d;

    private View a(int i2) {
        if (this.f16548d == null) {
            this.f16548d = new HashMap();
        }
        View view = (View) this.f16548d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16548d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16549a;

        a(i iVar) {
            this.f16549a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            this.f16549a.W_();
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar != null && cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                T t = cVar.f16217b;
                if (t != null) {
                    ICAStatusResponse iCAStatusResponse = (ICAStatusResponse) t;
                    CharSequence leadStatus = iCAStatusResponse.getLeadStatus();
                    if (leadStatus == null || p.a(leadStatus)) {
                        return;
                    }
                    if (iCAStatusResponse.getLeadStatus().equals("NOT_APPLIED")) {
                        i.c(this.f16549a).onFragmentAction(108, iCAStatusResponse.getLeadStatus());
                    } else if (iCAStatusResponse.getLeadStatus().equals("LEAD")) {
                        i.c(this.f16549a).onFragmentAction(108, iCAStatusResponse.getLeadStatus());
                    } else if (iCAStatusResponse.getLeadStatus().equals("NOT_ALLOWED")) {
                        i.c(this.f16549a).onFragmentAction(108, iCAStatusResponse.getLeadStatus());
                    } else if (iCAStatusResponse.getLeadStatus().equals("ACTIVE")) {
                        i.c(this.f16549a).onFragmentAction(108, iCAStatusResponse.getLeadStatus());
                    } else if (iCAStatusResponse.getLeadStatus().equals("TRACK")) {
                        i.c(this.f16549a).onFragmentAction(108, iCAStatusResponse.getLeadStatus());
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICAStatusResponse");
                }
            }
        }
    }

    public static final /* synthetic */ d c(i iVar) {
        d dVar = iVar.f16547c;
        if (dVar == null) {
            k.a("fragmentActionListener");
        }
        return dVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_open_acc_fragment, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(f.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ICAViewModel::class.java)");
        this.f16546b = (f) a2;
        ((ImageView) a(R.id.payments_bank_info_btn_close)).setOnClickListener(new b(this));
        ((AppCompatButton) a(R.id.btn_ca_open)).setOnClickListener(new c(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16550a;

        b(i iVar) {
            this.f16550a = iVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16550a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.onBackPressed();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16551a;

        c(i iVar) {
            this.f16551a = iVar;
        }

        public final void onClick(View view) {
            i.a(this.f16551a);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof d) {
            this.f16547c = (d) context;
        }
    }

    public static final /* synthetic */ void a(i iVar) {
        iVar.a(iVar.getContext(), iVar.getString(R.string.please_wait));
        if (iVar.f16546b == null) {
            k.a("viewModel");
        }
        f.a().observe(iVar, new a(iVar));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16548d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
