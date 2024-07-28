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
import org.json.JSONObject;

public class c extends h implements com.paytm.network.listener.b, net.one97.paytm.wallet.newdesign.widget.c {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f71067a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LinearLayoutManager f71068b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public NearByMainActivity f71069c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.widget.b f71070d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f71071e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f71072f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f71073g;

    /* renamed from: h  reason: collision with root package name */
    private ScrollView f71074h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.nearby.a.c f71075i;
    /* access modifiers changed from: private */
    public boolean j = false;
    private Toast k;
    /* access modifiers changed from: private */
    public Toast l;
    private boolean m;

    public interface b {
        void b(String str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f71072f = getArguments().getString(f.f71047c);
        if (activity instanceof NearByMainActivity) {
            this.f71069c = (NearByMainActivity) activity;
        }
        this.m = getArguments().getBoolean(f.f71051h);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nb_fragment_nearby_base, (ViewGroup) null);
        this.f71073g = (ProgressBar) inflate.findViewById(R.id.progress_nearbyLoader);
        this.f71067a = (RecyclerView) inflate.findViewById(R.id.nearby_recycler_list);
        this.f71071e = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
        this.f71074h = (ScrollView) inflate.findViewById(R.id.sv_error);
        this.f71068b = new LinearLayoutManager(getActivity());
        this.f71067a.setLayoutManager(this.f71068b);
        this.f71067a.setItemAnimator(new g());
        this.f71075i = new net.one97.paytm.wallet.newdesign.nearby.a.c(this, new ArrayList(), getActivity(), this.m);
        this.f71067a.setAdapter(this.f71075i);
        this.f71067a.addOnScrollListener(new a(this, (byte) 0));
        NearByMainActivity nearByMainActivity = this.f71069c;
        if (nearByMainActivity != null && (nearByMainActivity instanceof net.one97.paytm.wallet.newdesign.widget.b)) {
            this.f71070d = nearByMainActivity;
            this.f71070d.a(this);
        }
        a(0);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            Toast toast = this.k;
            if (toast == null) {
                this.k = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
                this.k.show();
                return;
            }
            toast.cancel();
            this.k = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
            this.k.show();
            return;
        }
        this.f71073g.setVisibility(0);
        double[] h2 = this.f71069c.h();
        if (h2 == null || Double.compare(h2[0], 0.0d) != 0 || Double.compare(h2[1], 0.0d) != 0) {
            a(a(h2[0], h2[1], "SERVICE", FetchCashPointRequestModal.FilterType.PAYMENT_POINT.toString(), i2));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
                PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                    this.f71069c.a(payTMPartnerListModal.response, this.f71072f);
                    this.f71075i.a(this.f71069c.a(this.f71072f));
                    if (getActivity() != null && (getActivity() instanceof b)) {
                        ArrayList<PayTMPartnerListModal.Response> arrayList = payTMPartnerListModal.response;
                        int size = arrayList.size();
                        String str = "";
                        if (size > 0) {
                            HashMap hashMap = new HashMap();
                            if (size > 5) {
                                size = 5;
                            }
                            for (int i2 = 0; i2 < size; i2++) {
                                String str2 = arrayList.get(i2).cashPointsDetail.city;
                                if (!TextUtils.isEmpty(str2)) {
                                    if (hashMap.containsKey(str2)) {
                                        hashMap.put(str2, Integer.valueOf(((Integer) hashMap.get(str2)).intValue() + 1));
                                    } else {
                                        hashMap.put(str2, 1);
                                    }
                                }
                            }
                            int i3 = 0;
                            for (String str3 : hashMap.keySet()) {
                                int intValue = ((Integer) hashMap.get(str3)).intValue();
                                if (intValue > i3) {
                                    str = str3;
                                    i3 = intValue;
                                }
                            }
                        }
                        ((b) getActivity()).b(str);
                    }
                    if (this.f71067a.getAdapter() == null) {
                        this.f71067a.setAdapter(this.f71075i);
                    }
                    if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                        this.j = true;
                    }
                } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                    payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                }
            }
            if (this.f71069c.a(this.f71072f).size() <= 0) {
                try {
                    if (getActivity() == null) {
                        return;
                    }
                    if (!getActivity().isFinishing()) {
                        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nb_error_no_nearby, (ViewGroup) null);
                        if (this.f71071e != null) {
                            this.f71071e.removeAllViews();
                            this.f71071e.addView(inflate);
                            this.f71071e.setVisibility(0);
                            this.f71074h.setVisibility(0);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            this.f71073g.setVisibility(8);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.f71073g.setVisibility(8);
            NearByMainActivity nearByMainActivity = this.f71069c;
            if ((nearByMainActivity == null || !nearByMainActivity.isFinishing() || !this.f71069c.isDestroyed()) && this.f71069c != null) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nb_error_no_nearby, (ViewGroup) null);
                this.f71071e.removeAllViews();
                this.f71071e.addView(inflate);
                this.f71071e.setVisibility(0);
                this.f71074h.setVisibility(0);
            }
            if (networkCustomError == null) {
                return;
            }
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                a.C1440a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                a.C1440a.a(getContext(), networkCustomError);
            } else if (networkCustomError.getMessage() != null) {
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
                        c.this.a(this.f$1, this.f$2);
                    }
                });
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

    class a extends RecyclerView.l {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                }
            } else if (!c.this.j || recyclerView.canScrollVertically(1)) {
                int childCount = c.this.f71068b.getChildCount();
                int itemCount = c.this.f71068b.getItemCount();
                int findFirstVisibleItemPosition = c.this.f71068b.findFirstVisibleItemPosition();
                if (c.this.f71073g.getVisibility() != 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    c cVar = c.this;
                    cVar.a(cVar.f71069c.a(c.this.f71072f).size());
                }
            } else if (c.this.l != null) {
                c.this.l.cancel();
                c cVar2 = c.this;
                Toast unused = cVar2.l = Toast.makeText(cVar2.getActivity(), c.this.getResources().getString(R.string.no_nearby_data), 1);
                c.this.l.show();
            } else {
                c cVar3 = c.this;
                Toast unused2 = cVar3.l = Toast.makeText(cVar3.getActivity(), c.this.getResources().getString(R.string.no_nearby_data), 1);
                c.this.l.show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (this.f71069c == null) {
                return;
            }
            if (!this.f71069c.isFinishing()) {
                this.f71073g.setVisibility(0);
                String str = null;
                c.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                if (c.a.a() != null) {
                    c.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                    c.a.a();
                    str = net.one97.paytm.wallet.newdesign.nearby.helper.c.a("nearByAddMoneyPoint");
                }
                if (str == null) {
                    return;
                }
                if (URLUtil.isValidUrl(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71069c));
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f71069c));
                    com.paytm.utility.b.j();
                    net.one97.paytm.wallet.newdesign.nearby.a.a();
                    JSONObject a2 = net.one97.paytm.wallet.newdesign.nearby.a.a(fetchCashPointRequestModal);
                    a.C1440a aVar3 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    com.paytm.network.b a3 = a.C1440a.a();
                    a3.f42877a = this.f71069c;
                    a3.f42879c = a.C0715a.POST;
                    a3.f42884h = a2.toString();
                    a3.f42882f = hashMap;
                    a3.f42885i = new PayTMPartnerListModal();
                    a3.f42880d = str;
                    a3.o = c.class.getName();
                    a3.n = a.b.USER_FACING;
                    a3.j = this;
                    com.paytm.network.a l2 = a3.l();
                    if (com.paytm.utility.b.c((Context) this.f71069c)) {
                        l2.a();
                    }
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

    public final void a() {
        net.one97.paytm.wallet.newdesign.nearby.a.c cVar = this.f71075i;
        if (cVar != null && cVar.getItemCount() == 0) {
            a(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f71070d != null) {
            this.f71069c.b((net.one97.paytm.wallet.newdesign.widget.c) this);
        }
        Toast toast = this.k;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.l;
        if (toast2 != null) {
            toast2.cancel();
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (z && getActivity() != null) {
            HashMap hashMap = new HashMap();
            d.a aVar = d.f71130b;
            d.a.b().a("wallet_nearby_payment_points_screen_loaded", (HashMap<String, Object>) hashMap, getActivity().getApplicationContext());
        }
    }
}
