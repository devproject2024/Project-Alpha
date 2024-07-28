package net.one97.paytm.wallet.newdesign.nearby.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;
import net.one97.paytm.wallet.newdesign.nearby.a.f;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.FetchCashPointRequestModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.a;
import net.one97.paytm.wallet.newdesign.nearby.helper.c;
import net.one97.paytm.wallet.newdesign.widget.c;
import org.json.JSONObject;

public class e extends h implements b, c {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f71088a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LinearLayoutManager f71089b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public NearByMainActivity f71090c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.widget.b f71091d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f71092e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f71093f = "";

    /* renamed from: g  reason: collision with root package name */
    private ScrollView f71094g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.nearby.a.c f71095h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f71096i = false;
    private Toast j;
    /* access modifiers changed from: private */
    public Toast k;
    private boolean l;
    /* access modifiers changed from: private */
    public LottieAnimationView m;
    private boolean n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f71093f = getArguments().getString(f.f71047c);
        if (activity instanceof NearByMainActivity) {
            this.f71090c = (NearByMainActivity) activity;
        }
        this.l = getArguments().getBoolean(f.f71051h);
        this.n = getArguments().getBoolean("isForFastTag", false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nb_fragment_nearby_base, (ViewGroup) null);
        this.m = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        this.f71088a = (RecyclerView) inflate.findViewById(R.id.nearby_recycler_list);
        this.f71092e = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
        this.f71094g = (ScrollView) inflate.findViewById(R.id.sv_error);
        this.f71089b = new LinearLayoutManager(getActivity());
        this.f71088a.setLayoutManager(this.f71089b);
        this.f71088a.setItemAnimator(new g());
        this.f71095h = new net.one97.paytm.wallet.newdesign.nearby.a.c(this, new ArrayList(), getActivity(), this.l);
        this.f71088a.setAdapter(this.f71095h);
        this.f71088a.addOnScrollListener(new a(this, (byte) 0));
        NearByMainActivity nearByMainActivity = this.f71090c;
        if (nearByMainActivity != null && (nearByMainActivity instanceof net.one97.paytm.wallet.newdesign.widget.b)) {
            this.f71091d = nearByMainActivity;
            this.f71091d.a(this);
        }
        net.one97.paytm.common.widgets.a.a(this.m);
        a(0);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        double[] dArr = this.f71090c.f70990a;
        if (dArr == null || Double.compare(dArr[0], 0.0d) != 0 || Double.compare(dArr[1], 0.0d) != 0) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                net.one97.paytm.common.widgets.a.b(this.m);
                b();
                return;
            }
            net.one97.paytm.common.widgets.a.a(this.m);
            a(a(dArr[0], dArr[1], "SERVICE", (this.n ? FetchCashPointRequestModal.FilterType.ISFASTAGISSUANCEPOINT : FetchCashPointRequestModal.FilterType.KYC_POINT).toString(), i2));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        NearByMainActivity nearByMainActivity;
        if (getActivity() != null && !getActivity().isFinishing()) {
            net.one97.paytm.common.widgets.a.b(this.m);
            if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
                PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                    this.f71090c.a(payTMPartnerListModal.response, this.f71093f);
                    this.f71095h.a(this.f71090c.a(this.f71093f));
                    if (this.f71088a.getAdapter() == null) {
                        this.f71088a.setAdapter(this.f71095h);
                    }
                    if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                        this.f71096i = true;
                    }
                } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                    payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                }
            }
            if (this.f71090c.a(this.f71093f).size() == 0 && (nearByMainActivity = this.f71090c) != null) {
                if (nearByMainActivity == null || !nearByMainActivity.isFinishing()) {
                    View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nb_error_no_nearby, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_comp_desc)).setText(getString(this.n ? R.string.unfortunately_there_are_no_fasTag_points_or_ : R.string.unfortunately_there_are_no_kyc_points_or_));
                    this.f71092e.removeAllViews();
                    this.f71092e.addView(inflate);
                    this.f71092e.setVisibility(0);
                    this.f71094g.setVisibility(0);
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            net.one97.paytm.common.widgets.a.b(this.m);
            b();
        }
    }

    class a extends RecyclerView.l {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                }
            } else if (!e.this.f71096i) {
                int childCount = e.this.f71089b.getChildCount();
                int itemCount = e.this.f71089b.getItemCount();
                int findFirstVisibleItemPosition = e.this.f71089b.findFirstVisibleItemPosition();
                if (e.this.m.getVisibility() != 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    e eVar = e.this;
                    eVar.a(eVar.f71090c.a(e.this.f71093f).size());
                }
            } else if (e.this.k != null) {
                e.this.k.cancel();
                e eVar2 = e.this;
                Toast unused = eVar2.k = Toast.makeText(eVar2.getActivity(), e.this.getResources().getString(R.string.no_nearby_data), 1);
                e.this.k.show();
            } else {
                e eVar3 = e.this;
                Toast unused2 = eVar3.k = Toast.makeText(eVar3.getActivity(), e.this.getResources().getString(R.string.no_nearby_data), 1);
                e.this.k.show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (this.f71090c == null) {
                return;
            }
            if (!this.f71090c.isFinishing()) {
                net.one97.paytm.common.widgets.a.a(this.m);
                String str = null;
                c.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                if (c.a.a() != null) {
                    c.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                    c.a.a();
                    str = net.one97.paytm.wallet.newdesign.nearby.helper.c.a(this.n ? "nearbyFastTagPoints" : "nearbyKycPoint");
                }
                if (str == null) {
                    return;
                }
                if (URLUtil.isValidUrl(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71090c));
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f71090c));
                    com.paytm.utility.b.j();
                    net.one97.paytm.wallet.newdesign.nearby.a.a();
                    JSONObject a2 = net.one97.paytm.wallet.newdesign.nearby.a.a(fetchCashPointRequestModal);
                    a.C1440a aVar3 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    com.paytm.network.b a3 = a.C1440a.a();
                    a3.f42877a = this.f71090c;
                    a3.f42879c = a.C0715a.POST;
                    a3.f42884h = a2.toString();
                    a3.f42882f = hashMap;
                    a3.f42885i = new PayTMPartnerListModal();
                    a3.f42880d = str;
                    a3.o = e.class.getName();
                    a3.n = a.b.USER_FACING;
                    a3.j = this;
                    com.paytm.network.a l2 = a3.l();
                    if (com.paytm.utility.b.c((Context) this.f71090c)) {
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

    private FetchCashPointRequestModal a(double d2, double d3, String str, String str2, int i2) {
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.getClass();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.n) {
            hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
        }
        fetchCashPointRequestModal.request.sortBy = hashMap;
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
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_error_retry, (ViewGroup) null);
        this.f71092e.removeAllViews();
        this.f71092e.addView(inflate);
        this.f71092e.setVisibility(0);
        this.f71092e.findViewById(R.id.tv_retry).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.a(view);
            }
        });
        this.f71094g.setVisibility(0);
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.nearby.a.c cVar = this.f71095h;
        if (cVar != null && cVar.getItemCount() == 0) {
            a(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.wallet.newdesign.widget.b bVar = this.f71091d;
        if (bVar != null) {
            bVar.b(this);
        }
        Toast toast = this.j;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.k;
        if (toast2 != null) {
            toast2.cancel();
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (z) {
            getActivity();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f71092e.setVisibility(8);
        this.f71094g.setVisibility(8);
        a(0);
    }
}
