package net.one97.paytm.wallet.newdesign.nearby.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;
import net.one97.paytm.wallet.newdesign.nearby.a.f;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.FetchCashPointRequestModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.a;
import net.one97.paytm.wallet.newdesign.nearby.helper.c;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;
import net.one97.paytm.wallet.newdesign.widget.c;
import org.json.JSONObject;

public class a extends h implements b, c {

    /* renamed from: a  reason: collision with root package name */
    boolean f71057a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f71058b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutManager f71059c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public NearByMainActivity f71060d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.widget.b f71061e;

    /* renamed from: f  reason: collision with root package name */
    private ScrollView f71062f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f71063g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f71064h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f71065i;
    private net.one97.paytm.wallet.newdesign.nearby.a.c j;
    /* access modifiers changed from: private */
    public boolean k = false;
    private Toast l;
    /* access modifiers changed from: private */
    public Toast m;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f71064h = getArguments().getString(f.f71047c);
        if (activity instanceof NearByMainActivity) {
            this.f71060d = (NearByMainActivity) activity;
        }
        this.f71057a = getArguments().getBoolean(f.f71051h);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nb_fragment_nearby_base, (ViewGroup) null);
        this.f71065i = (ProgressBar) inflate.findViewById(R.id.progress_nearbyLoader);
        this.f71058b = (RecyclerView) inflate.findViewById(R.id.nearby_recycler_list);
        this.f71063g = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
        this.f71062f = (ScrollView) inflate.findViewById(R.id.sv_error);
        this.f71059c = new LinearLayoutManager(getActivity());
        this.f71058b.setLayoutManager(this.f71059c);
        this.f71058b.setItemAnimator(new g());
        this.j = new net.one97.paytm.wallet.newdesign.nearby.a.c(this, new ArrayList(), getActivity(), this.f71057a);
        this.f71058b.setAdapter(this.j);
        this.f71058b.addOnScrollListener(new C1438a(this, (byte) 0));
        NearByMainActivity nearByMainActivity = this.f71060d;
        if (nearByMainActivity != null && (nearByMainActivity instanceof net.one97.paytm.wallet.newdesign.widget.b)) {
            this.f71061e = nearByMainActivity;
            this.f71061e.a(this);
        }
        a(0);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            Toast toast = this.l;
            if (toast == null) {
                this.l = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
                this.l.show();
                return;
            }
            toast.cancel();
            this.l = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
            this.l.show();
            return;
        }
        this.f71065i.setVisibility(0);
        double[] h2 = this.f71060d.h();
        if (h2 == null || Double.compare(h2[0], 0.0d) != 0 || Double.compare(h2[1], 0.0d) != 0) {
            a(a(h2[0], h2[1], "SERVICE", FetchCashPointRequestModal.FilterType.CASH_POINT.toString(), i2));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.f71065i.setVisibility(8);
            if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
                PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                    this.f71060d.a(payTMPartnerListModal.response, this.f71064h);
                    this.j.a(this.f71060d.a(this.f71064h));
                    if (this.f71058b.getAdapter() == null) {
                        this.f71058b.setAdapter(this.j);
                    }
                    if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                        this.k = true;
                    }
                } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                    payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                }
            }
            if (this.f71060d.a(this.f71064h).size() == 0) {
                b();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.f71065i.setVisibility(8);
            b();
            if (networkCustomError == null) {
                return;
            }
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && ((networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401)) && getContext() != null)) {
                a.C1440a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                a.C1440a.a(getContext(), networkCustomError);
            } else if (networkCustomError.getMessage() != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.network_error_message));
                    sb.append(" ");
                    sb.append(networkCustomError.getUrl());
                    getActivity().runOnUiThread(new Runnable(networkCustomError, i2) {
                        private final /* synthetic */ NetworkCustomError f$1;
                        private final /* synthetic */ int f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            a.this.a(this.f$1, this.f$2);
                        }
                    });
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NetworkCustomError networkCustomError, int i2) {
        if (networkCustomError == null) {
            return;
        }
        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            return;
        }
        com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), String.valueOf(i2));
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.nearby.b.a$a  reason: collision with other inner class name */
    class C1438a extends RecyclerView.l {
        private C1438a() {
        }

        /* synthetic */ C1438a(a aVar, byte b2) {
            this();
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                }
            } else if (!a.this.k) {
                int childCount = a.this.f71059c.getChildCount();
                int itemCount = a.this.f71059c.getItemCount();
                int findFirstVisibleItemPosition = a.this.f71059c.findFirstVisibleItemPosition();
                if (a.this.f71065i.getVisibility() != 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    a aVar = a.this;
                    aVar.a(aVar.f71060d.a(a.this.f71064h).size());
                }
            } else if (a.this.m != null) {
                a.this.m.cancel();
                a aVar2 = a.this;
                Toast unused = aVar2.m = Toast.makeText(aVar2.getActivity(), a.this.getResources().getString(R.string.no_nearby_data), 1);
                a.this.m.show();
            } else {
                a aVar3 = a.this;
                Toast unused2 = aVar3.m = Toast.makeText(aVar3.getActivity(), a.this.getResources().getString(R.string.no_nearby_data), 1);
                a.this.m.show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (this.f71060d == null) {
                return;
            }
            if (!this.f71060d.isFinishing()) {
                String str = null;
                c.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                if (c.a.a() != null) {
                    c.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                    c.a.a();
                    str = net.one97.paytm.wallet.newdesign.nearby.helper.c.a("nearbyKycPoint");
                }
                if (str == null) {
                    return;
                }
                if (URLUtil.isValidUrl(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71060d));
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f71060d));
                    com.paytm.utility.b.j();
                    net.one97.paytm.wallet.newdesign.nearby.a.a();
                    JSONObject a2 = net.one97.paytm.wallet.newdesign.nearby.a.a(fetchCashPointRequestModal);
                    a.C1440a aVar3 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    com.paytm.network.b a3 = a.C1440a.a();
                    a3.f42877a = this.f71060d;
                    a3.f42879c = a.C0715a.POST;
                    a3.f42884h = a2.toString();
                    a3.f42882f = hashMap;
                    a3.f42885i = new PayTMPartnerListModal();
                    a3.f42880d = str;
                    a3.o = a.class.getName();
                    a3.n = a.b.USER_FACING;
                    a3.j = this;
                    com.paytm.network.a l2 = a3.l();
                    if (com.paytm.utility.b.c((Context) this.f71060d)) {
                        l2.a();
                        return;
                    }
                    a.C1440a aVar4 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    a.C1440a.a(getContext(), l2);
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private static FetchCashPointRequestModal a(double d2, double d3, String str, String str2, int i2) {
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.getClass();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
        fetchCashPointRequestModal.request.sortBy = new HashMap<>();
        fetchCashPointRequestModal.request.startLimit = Integer.valueOf(i2);
        fetchCashPointRequestModal.request.endLimit = 20;
        fetchCashPointRequestModal.getClass();
        FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
        searchFilter.filterType = str;
        searchFilter.value = str2;
        fetchCashPointRequestModal.request.searchFilter.add(0, searchFilter);
        fetchCashPointRequestModal.request.latitude = String.valueOf(d2);
        fetchCashPointRequestModal.request.longitude = String.valueOf(d3);
        return fetchCashPointRequestModal;
    }

    private void b() {
        NearByMainActivity nearByMainActivity = this.f71060d;
        if ((nearByMainActivity == null || !nearByMainActivity.isFinishing() || !this.f71060d.isDestroyed()) && this.f71060d != null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nb_error_no_nearby, (ViewGroup) null);
            this.f71063g.removeAllViews();
            this.f71063g.addView(inflate);
            this.f71063g.setVisibility(0);
            this.f71062f.setVisibility(0);
        }
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.nearby.a.c cVar = this.j;
        if (cVar != null && cVar.getItemCount() == 0) {
            a(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f71061e != null) {
            this.f71060d.b((net.one97.paytm.wallet.newdesign.widget.c) this);
        }
        Toast toast = this.l;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.m;
        if (toast2 != null) {
            toast2.cancel();
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (z && getActivity() != null) {
            HashMap hashMap = new HashMap();
            d.a aVar = d.f71130b;
            d.a.b().a("wallet_nearby_add_cash_points_clicked", (HashMap<String, Object>) hashMap, getActivity().getApplicationContext());
        }
    }
}
