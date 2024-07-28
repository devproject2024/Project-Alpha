package net.one97.paytm.bankOpen.ica.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.b.d;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.d.e;
import net.one97.paytm.bankOpen.ica.model.ICATrackLeadResponse;

public final class m extends e {

    /* renamed from: b  reason: collision with root package name */
    ArrayList<net.one97.paytm.bankOpen.ica.model.a> f16571b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ICATrackLeadResponse f16572c;

    /* renamed from: d  reason: collision with root package name */
    private e f16573d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f16574e;

    public final View a(int i2) {
        if (this.f16574e == null) {
            this.f16574e = new HashMap();
        }
        View view = (View) this.f16574e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16574e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        HashMap hashMap = this.f16574e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    static final class a<T> implements z<c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f16575a;

        a(m mVar) {
            this.f16575a = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c cVar = (c) obj;
            this.f16575a.e();
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar != null) {
                if (cVar.f16216a == d.SUCCESS) {
                    m mVar = this.f16575a;
                    T t = cVar.f16217b;
                    if (t != null) {
                        mVar.f16572c = (ICATrackLeadResponse) t;
                        m.a(this.f16575a);
                        RecyclerView recyclerView = (RecyclerView) this.f16575a.a(R.id.trackRv);
                        k.a((Object) recyclerView, "trackRv");
                        this.f16575a.getContext();
                        recyclerView.setAdapter(new net.one97.paytm.bankOpen.ica.a.a(this.f16575a.f16571b));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICATrackLeadResponse");
                }
            } else if (cVar.f16216a == d.ERROR) {
                Throwable th = cVar.f16218c;
                if (th != null) {
                    NetworkCustomError networkCustomError = (NetworkCustomError) th;
                    f.a(this.f16575a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_track_acc_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(e.class);
        k.a((Object) a2, "ViewModelProviders.of(th…estViewModel::class.java)");
        this.f16573d = (e) a2;
        View findViewById = view.findViewById(R.id.payments_bank_info_btn_close);
        if (findViewById != null) {
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(this));
            }
            RecyclerView recyclerView = (RecyclerView) a(R.id.trackRv);
            k.a((Object) recyclerView, "trackRv");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            d();
            if (this.f16573d == null) {
                k.a("viewModel");
            }
            e.a().observe(this, new a(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f16576a;

        b(m mVar) {
            this.f16576a = mVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16576a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public static final /* synthetic */ void a(m mVar) {
        mVar.f16571b.clear();
        ICATrackLeadResponse iCATrackLeadResponse = mVar.f16572c;
        String str = null;
        Boolean valueOf = iCATrackLeadResponse != null ? Boolean.valueOf(iCATrackLeadResponse.getPasscodeStatus()) : null;
        if (valueOf == null) {
            k.a();
        }
        boolean booleanValue = valueOf.booleanValue();
        ICATrackLeadResponse iCATrackLeadResponse2 = mVar.f16572c;
        Boolean valueOf2 = iCATrackLeadResponse2 != null ? Boolean.valueOf(iCATrackLeadResponse2.getKycStatus()) : null;
        if (valueOf2 == null) {
            k.a();
        }
        boolean booleanValue2 = valueOf2.booleanValue();
        ICATrackLeadResponse iCATrackLeadResponse3 = mVar.f16572c;
        Boolean valueOf3 = iCATrackLeadResponse3 != null ? Boolean.valueOf(iCATrackLeadResponse3.getNomineeStatus()) : null;
        if (valueOf3 == null) {
            k.a();
        }
        boolean booleanValue3 = valueOf3.booleanValue();
        ICATrackLeadResponse iCATrackLeadResponse4 = mVar.f16572c;
        boolean equals = "ACCEPTED".equals(iCATrackLeadResponse4 != null ? iCATrackLeadResponse4.getNocStatus() : null);
        if (booleanValue) {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.paytm_passcode_set), "", "", 104, booleanValue3 ? 100 : 103, 104));
        } else {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_passcode_not_set), "", "", 104, booleanValue3 ? 100 : 103, 102));
        }
        if (booleanValue3) {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_nominee_added), "", "", 100, booleanValue2 ? 100 : 103, 104));
        } else {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_nominee_notadd), "", "", 103, booleanValue2 ? 100 : 103, 102));
        }
        if (booleanValue2) {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_kyc_done), "", "", 100, equals ? 100 : 103, 104));
        } else {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_kyc_pending), mVar.getString(R.string.pb_ca_kyc_subtitle), "", 103, equals ? 100 : 103, 102));
        }
        if (equals) {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_noc_done), "", "", 100, 104, 104));
            return;
        }
        ICATrackLeadResponse iCATrackLeadResponse5 = mVar.f16572c;
        if (iCATrackLeadResponse5 != null) {
            str = iCATrackLeadResponse5.getNocStatus();
        }
        if ("REJECTED".equals(str)) {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_noc_rejected), "", "", 102, 104, 101));
        } else {
            mVar.f16571b.add(new net.one97.paytm.bankOpen.ica.model.a(mVar.getString(R.string.pb_ca_noc_pending), "", "", 103, 104, 102));
        }
    }
}
