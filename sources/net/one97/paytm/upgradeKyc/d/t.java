package net.one97.paytm.upgradeKyc.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.upgradeKyc.FetchCashPointRequestModal;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.widgets.EndlessScrollView;
import net.one97.paytm.common.widgets.a.c;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.a.a;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONObject;

public class t extends h implements c {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f65765a;

    /* renamed from: b  reason: collision with root package name */
    private Toast f65766b;

    /* renamed from: c  reason: collision with root package name */
    private Toast f65767c;

    /* renamed from: d  reason: collision with root package name */
    private a f65768d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<PayTMPartnerListModal.Response> f65769e;

    /* renamed from: f  reason: collision with root package name */
    private double[] f65770f = new double[2];

    /* renamed from: g  reason: collision with root package name */
    private String f65771g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f65772h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f65773i = false;
    private boolean j;
    private String k;
    private String l;

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString("doc_number");
            this.f65771g = arguments.getString("tab");
            this.f65769e = (ArrayList) arguments.getSerializable("kyc_center_list");
            this.l = arguments.getString("doc_type");
        }
        if (getActivity().getIntent() != null) {
            this.k = getActivity().getIntent().getStringExtra("vertical");
        }
        if (!(!TextUtils.isEmpty(this.k) || getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getExtras() == null || (extras = getActivity().getIntent().getExtras()) == null)) {
            this.k = extras.getString("vertical");
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "kyc";
        }
        this.j = this.f65771g.equalsIgnoreCase("Static");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.a aVar = e.f66028b;
        e.a.b().a("/kyc-wallet-upgrade/in-person/neraby-points", "kyc", (Context) getActivity());
        return layoutInflater.inflate(R.layout.fragment_visit_kyc_centre, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_static_kyc_centres);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_dynamic_kyc_centres);
        if (this.j) {
            linearLayout.setVisibility(0);
            relativeLayout.setVisibility(8);
            String[] stringArray = getActivity().getResources().getStringArray(R.array.kyc_centres_spoc);
            String[] stringArray2 = getActivity().getResources().getStringArray(R.array.kyc_centres_address);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_kyc_center, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.kyc_center_heading)).setText(stringArray[i2]);
                ((TextView) inflate.findViewById(R.id.kyc_center_details)).setText(stringArray2[i2]);
                linearLayout.addView(inflate);
            }
        } else {
            linearLayout.setVisibility(8);
            relativeLayout.setVisibility(0);
            this.f65769e.add((Object) null);
            if (this.f65769e.size() == 1) {
                a(0);
            }
            ((EndlessScrollView) view.findViewById(R.id.sv_endless_scroller)).setScrollViewListener(this);
            this.f65765a = (LinearLayout) view.findViewById(R.id.ll_nearby_error);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_kyc_center);
            recyclerView.setItemAnimator(new g());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f65768d = new a(this.f65769e, getActivity());
            recyclerView.setAdapter(this.f65768d);
        }
        TextView textView = (TextView) view.findViewById(R.id.aadhar_no);
        if (this.l != null) {
            textView.setText(getString(R.string.kyc_centre_aadhaar_original, this.l));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Toast toast = this.f65767c;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.f65766b;
        if (toast2 != null) {
            toast2.cancel();
        }
    }

    private void a(int i2) {
        if (!b.c((Context) getActivity())) {
            Toast toast = this.f65767c;
            if (toast == null) {
                this.f65767c = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 0);
                this.f65767c.show();
                return;
            }
            toast.cancel();
            this.f65767c = Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 0);
            this.f65767c.show();
            return;
        }
        double[] dArr = this.f65770f;
        a(a(dArr[0], dArr[1], "SERVICE", FetchCashPointRequestModal.FilterType.KYC_POINT.toString(), i2));
    }

    private static FetchCashPointRequestModal a(double d2, double d3, String str, String str2, int i2) {
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.getClass();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
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

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!getActivity().isFinishing()) {
                String str = null;
                d.a aVar = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar2 = d.f66026a;
                    d.a.a();
                    str = d.a("nearbyMerchant");
                }
                if (str == null) {
                    return;
                }
                if (URLUtil.isValidUrl(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
                    new StringBuilder("SSO Token :: ").append((String) hashMap.get("ssotoken"));
                    b.j();
                    JSONObject createNearByRequestBody = NearbyRequestCreator.getNearbyRequestCreatorInstance().createNearByRequestBody(fetchCashPointRequestModal);
                    a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a2 = a.C1317a.a();
                    a2.f42877a = getActivity();
                    a2.f42879c = a.C0715a.POST;
                    a2.f42882f = hashMap;
                    a2.f42885i = new PayTMPartnerListModal();
                    a2.f42884h = createNearByRequestBody.toString();
                    a2.f42880d = str;
                    a2.o = t.class.getName();
                    a2.n = a.b.USER_FACING;
                    a2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            t.a(t.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            if (t.this.getActivity() != null) {
                                l.a();
                                l.a((Context) t.this.getActivity(), networkCustomError);
                            }
                        }
                    };
                    com.paytm.network.a l2 = a2.l();
                    if (b.c((Context) getActivity())) {
                        this.f65773i = true;
                        l2.a();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(EndlessScrollView endlessScrollView) {
        if (endlessScrollView.getChildAt(endlessScrollView.getChildCount() - 1).getBottom() - (endlessScrollView.getHeight() + endlessScrollView.getScrollY()) != 0) {
            return;
        }
        if (this.f65772h) {
            Toast toast = this.f65766b;
            if (toast != null) {
                toast.cancel();
            }
            this.f65766b = Toast.makeText(getActivity(), getResources().getString(R.string.no_nearby_data), 0);
            this.f65766b.show();
        } else if (!this.f65773i) {
            this.f65769e.add((Object) null);
            this.f65768d.notifyItemInserted(this.f65769e.size());
            a(this.f65769e.size() - 1);
        }
    }

    static /* synthetic */ void a(t tVar, IJRPaytmDataModel iJRPaytmDataModel) {
        tVar.f65773i = false;
        if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
            PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                if (tVar.f65769e.size() > 0) {
                    ArrayList<PayTMPartnerListModal.Response> arrayList = tVar.f65769e;
                    arrayList.remove(arrayList.size() - 1);
                    tVar.f65768d.notifyItemRemoved(tVar.f65769e.size() - 1);
                    tVar.f65769e.addAll(payTMPartnerListModal.response);
                    tVar.f65768d.notifyItemRangeInserted(tVar.f65769e.size() - 1, payTMPartnerListModal.response.size());
                }
                if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                    tVar.f65772h = true;
                }
            } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            }
        }
        net.one97.paytm.upgradeKyc.a.a aVar = tVar.f65768d;
        if (aVar != null && aVar.getItemCount() == 0) {
            if ((tVar.getActivity() == null || !tVar.getActivity().isFinishing() || !tVar.getActivity().isDestroyed()) && tVar.getActivity() != null) {
                View inflate = LayoutInflater.from(tVar.getActivity()).inflate(R.layout.error_no_nearby, (ViewGroup) null);
                tVar.f65765a.removeAllViews();
                tVar.f65765a.addView(inflate);
                tVar.f65765a.setVisibility(0);
            }
        }
    }
}
