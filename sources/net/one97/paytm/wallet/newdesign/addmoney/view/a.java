package net.one97.paytm.wallet.newdesign.addmoney.view;

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
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.m;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.newdesign.addmoney.c.d;
import net.one97.paytm.wallet.newdesign.addmoney.c.g;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals.FetchCashPointRequestModal;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals.PayTMPartnerListModal;
import org.json.JSONObject;

public class a extends h implements b, g {

    /* renamed from: a  reason: collision with root package name */
    boolean f70700a;

    /* renamed from: b  reason: collision with root package name */
    boolean f70701b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f70702c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f70703d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public NearByAddMoneyActivity f70704e;

    /* renamed from: f  reason: collision with root package name */
    private d f70705f;

    /* renamed from: g  reason: collision with root package name */
    private ScrollView f70706g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f70707h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f70708i = "ADD_CASH";
    /* access modifiers changed from: private */
    public ProgressBar j;
    private net.one97.paytm.wallet.newdesign.addmoney.a.b k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private Toast m;
    /* access modifiers changed from: private */
    public Toast n;
    private int o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.o = getArguments().getInt("nearby_points", m.NEARBY_CASH_POINT.getIdentifier());
        if (activity instanceof NearByAddMoneyActivity) {
            this.f70704e = (NearByAddMoneyActivity) activity;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_nearby_addmoney, (ViewGroup) null);
        this.j = (ProgressBar) inflate.findViewById(R.id.progress_nearbyLoader);
        this.f70702c = (RecyclerView) inflate.findViewById(R.id.nearby_recycler_list);
        this.f70707h = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
        this.f70706g = (ScrollView) inflate.findViewById(R.id.sv_error);
        this.f70703d = new LinearLayoutManager(getActivity());
        this.f70702c.setLayoutManager(this.f70703d);
        this.f70702c.setItemAnimator(new androidx.recyclerview.widget.g());
        this.k = new net.one97.paytm.wallet.newdesign.addmoney.a.b(this, new ArrayList(), getActivity(), this.f70700a);
        this.f70702c.setAdapter(this.k);
        this.f70702c.addOnScrollListener(new C1427a(this, (byte) 0));
        NearByAddMoneyActivity nearByAddMoneyActivity = this.f70704e;
        if (nearByAddMoneyActivity != null && (nearByAddMoneyActivity instanceof d)) {
            this.f70705f = nearByAddMoneyActivity;
            this.f70705f.a(this);
        }
        this.f70701b = true;
        a(0);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            Toast toast = this.m;
            if (toast == null) {
                this.m = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
                this.m.show();
                return;
            }
            toast.cancel();
            this.m = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1);
            this.m.show();
            return;
        }
        this.j.setVisibility(0);
        double[] b2 = this.f70704e.b();
        if (b2 == null || Double.compare(b2[0], 0.0d) != 0 || Double.compare(b2[1], 0.0d) != 0) {
            String filterType = FetchCashPointRequestModal.FilterType.CASH_POINT.toString();
            if (this.o == m.NEARBY_BANKING_POINT.getIdentifier()) {
                filterType = FetchCashPointRequestModal.FilterType.KYC_POINT.toString();
            }
            a(a(b2[0], b2[1], "SERVICE", filterType, i2));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.j.setVisibility(8);
            this.f70701b = false;
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof PayTMPartnerListModal)) {
                PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                    NearByAddMoneyActivity nearByAddMoneyActivity = this.f70704e;
                    ArrayList<PayTMPartnerListModal.Response> arrayList = payTMPartnerListModal.response;
                    String str = this.f70708i;
                    if (!(arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(str))) {
                        if (nearByAddMoneyActivity.f70689a == null) {
                            nearByAddMoneyActivity.f70689a = new HashMap<>();
                        }
                        ArrayList<PayTMPartnerListModal.Response> a2 = nearByAddMoneyActivity.a(str);
                        a2.addAll(arrayList);
                        nearByAddMoneyActivity.f70689a.put(str, a2);
                    }
                    net.one97.paytm.wallet.newdesign.addmoney.a.b bVar = this.k;
                    bVar.f70665b = new ArrayList<>(this.f70704e.a(this.f70708i));
                    bVar.a();
                    bVar.notifyDataSetChanged();
                    if (this.f70702c.getAdapter() == null) {
                        this.f70702c.setAdapter(this.k);
                    }
                    if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                        this.l = true;
                    }
                } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                    payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                }
            }
            String str2 = this.f70708i;
            if (str2 != null && this.f70704e.a(str2).size() == 0) {
                b();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, final NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.j.setVisibility(8);
            this.f70701b = false;
            b();
            if (networkCustomError == null) {
                return;
            }
            if (networkCustomError.getNetworkResponse() != null && (networkCustomError.getNetworkResponse().statusCode == 410 || networkCustomError.getNetworkResponse().statusCode == 401)) {
                AddMoneyUtils.a(getActivity(), networkCustomError, (String) null, Boolean.FALSE);
            } else if (networkCustomError.getMessage() != null && !net.one97.paytm.helper.a.b().a((Context) getActivity(), networkCustomError)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.network_error_message));
                    sb.append(" ");
                    sb.append(networkCustomError.getUrl());
                    getActivity().runOnUiThread(new Runnable() {
                        public final void run() {
                            NetworkCustomError networkCustomError = networkCustomError;
                            if (networkCustomError == null) {
                                return;
                            }
                            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                com.paytm.utility.b.b((Context) a.this.getActivity(), a.this.getResources().getString(R.string.network_error_heading), a.this.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                return;
                            }
                            com.paytm.utility.b.d((Context) a.this.getActivity(), networkCustomError.getUrl(), String.valueOf(networkCustomError.getNetworkResponse().statusCode));
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.addmoney.view.a$a  reason: collision with other inner class name */
    class C1427a extends RecyclerView.l {
        private C1427a() {
        }

        /* synthetic */ C1427a(a aVar, byte b2) {
            this();
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                }
            } else if (!a.this.l) {
                int childCount = a.this.f70703d.getChildCount();
                int itemCount = a.this.f70703d.getItemCount();
                int findFirstVisibleItemPosition = a.this.f70703d.findFirstVisibleItemPosition();
                if (a.this.j.getVisibility() != 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    a aVar = a.this;
                    aVar.a(aVar.f70704e.a(a.this.f70708i).size());
                }
            } else if (a.this.n != null) {
                a.this.n.cancel();
                a aVar2 = a.this;
                Toast unused = aVar2.n = Toast.makeText(aVar2.getActivity(), a.this.getResources().getString(R.string.no_nearby_data), 1);
                a.this.n.show();
            } else {
                a aVar3 = a.this;
                Toast unused2 = aVar3.n = Toast.makeText(aVar3.getActivity(), a.this.getResources().getString(R.string.no_nearby_data), 1);
                a.this.n.show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (this.f70704e == null) {
                return;
            }
            if (!this.f70704e.isFinishing()) {
                String f2 = net.one97.paytm.helper.a.b().f("nearByAddMoneyPoint");
                if (this.o == m.NEARBY_BANKING_POINT.getIdentifier()) {
                    f2 = net.one97.paytm.helper.a.b().f("nearbyBankingPoint");
                }
                q.d(f2);
                if (f2 == null) {
                    return;
                }
                if (URLUtil.isValidUrl(f2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70704e));
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70704e));
                    com.paytm.utility.b.j();
                    net.one97.paytm.wallet.newdesign.addmoney.nearby.a.a();
                    JSONObject a2 = net.one97.paytm.wallet.newdesign.addmoney.nearby.a.a(fetchCashPointRequestModal);
                    if (com.paytm.utility.b.c(this.f70704e.getApplicationContext())) {
                        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                        b2.f42885i = new PayTMPartnerListModal();
                        b2.f42880d = com.paytm.utility.b.e(getContext(), f2);
                        b2.j = this;
                        b2.f42884h = a2.toString();
                        b2.f42877a = getActivity();
                        b2.f42882f = hashMap;
                        b2.l().a();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
        NearByAddMoneyActivity nearByAddMoneyActivity = this.f70704e;
        if ((nearByAddMoneyActivity == null || !nearByAddMoneyActivity.isFinishing() || !this.f70704e.isDestroyed()) && this.f70704e != null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.error_no_nearby_addmoney, (ViewGroup) null);
            this.f70707h.removeAllViews();
            this.f70707h.addView(inflate);
            this.f70707h.setVisibility(0);
            this.f70706g.setVisibility(0);
        }
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.addmoney.a.b bVar = this.k;
        if (bVar.f70665b != null) {
            bVar.f70665b.clear();
            bVar.a();
            bVar.notifyDataSetChanged();
        }
        a(0);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f70705f != null) {
            this.f70704e.f70691c.remove(this);
        }
        Toast toast = this.m;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.n;
        if (toast2 != null) {
            toast2.cancel();
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (z && getActivity() != null) {
            net.one97.paytm.helper.a.b().a("wallet_nearby_add_cash_points_clicked", (Map<String, Object>) new HashMap(), getActivity().getApplicationContext());
        }
    }
}
