package net.one97.paytm.wallet.newdesign.nearby.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;
import net.one97.paytm.wallet.newdesign.nearby.NearbyBrowseCategoryActivity;
import net.one97.paytm.wallet.newdesign.nearby.a.c;
import net.one97.paytm.wallet.newdesign.nearby.a.e;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.FetchCashPointRequestModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.a;
import net.one97.paytm.wallet.newdesign.nearby.helper.c;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;
import org.json.JSONObject;

public class d extends b implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, b {

    /* renamed from: a  reason: collision with root package name */
    public String f71077a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f71078b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f71079c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f71080d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public NearByMainActivity f71081e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f71082f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f71083g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public c f71084h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f71085i = false;
    /* access modifiers changed from: private */
    public Toast j;
    private int k = 0;
    private Dialog l;
    private RadioGroup m;
    private RadioButton n;
    private RadioButton o;
    private RadioButton p;
    /* access modifiers changed from: private */
    public int q;
    private int r = -1;
    private e.b s = new e.b() {
        public final void a(int i2) {
            if (d.this.getActivity() != null && !d.this.getActivity().isFinishing() && (d.this.getActivity() instanceof NearByMainActivity)) {
                Bundle bundle = new Bundle();
                bundle.putInt("SELECTED_CATEGORY_INDEX", d.this.q);
                bundle.putInt("SELECTED_SUBCATEGORY_INDEX", i2);
                d dVar = new d();
                dVar.setArguments(bundle);
                ((NearByMainActivity) d.this.getActivity()).a((Fragment) dVar);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof NearByMainActivity) {
            this.f71081e = (NearByMainActivity) activity;
        }
        this.f71077a = getString(R.string.nearby_pay_with_paytm);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = arguments.getInt("SELECTED_CATEGORY_INDEX", 0);
            this.r = arguments.getInt("SELECTED_SUBCATEGORY_INDEX", -1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nb_fragment_search_with_filter, (ViewGroup) null);
        this.l = new Dialog(getActivity());
        this.l.requestWindowFeature(1);
        this.l.setContentView(R.layout.nb_dialog_select_paytm_filter);
        this.m = (RadioGroup) this.l.findViewById(R.id.rg_service_filter);
        this.m.setOnCheckedChangeListener(this);
        this.n = (RadioButton) this.l.findViewById(R.id.rb_pay_with_paytm);
        this.o = (RadioButton) this.l.findViewById(R.id.rb_add_cash);
        this.p = (RadioButton) this.l.findViewById(R.id.rb_upgrade_account);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_bottom_bar);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.d(view);
            }
        });
        this.f71079c = (TextView) inflate.findViewById(R.id.tv_refine);
        this.f71079c.setText(this.f71077a);
        LayoutInflater from = LayoutInflater.from(getActivity());
        if (this.f71082f == null) {
            this.f71082f = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
        }
        NearByMainActivity nearByMainActivity = this.f71081e;
        if (nearByMainActivity instanceof NearByMainActivity) {
            nearByMainActivity.f();
        }
        if (this.f71081e.f70992c != null && !(this.f71081e instanceof NearByMainActivity)) {
            net.one97.paytm.wallet.newdesign.nearby.b.a();
            if (!net.one97.paytm.wallet.newdesign.nearby.b.a(this.f71081e.f70992c)) {
                View inflate2 = from.inflate(R.layout.nb_error_location_off, (ViewGroup) null);
                inflate2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                inflate2.findViewById(R.id.error_toolbar).setVisibility(8);
                this.f71082f.removeAllViews();
                this.f71082f.addView(inflate2);
                this.f71082f.setVisibility(0);
                relativeLayout.setVisibility(8);
                return inflate;
            }
        }
        if (com.paytm.utility.b.c((Context) getActivity()) || (this.f71081e instanceof NearByMainActivity)) {
            this.f71082f.removeAllViews();
            this.f71082f.setVisibility(8);
            relativeLayout.setVisibility(0);
            ((ImageView) inflate.findViewById(R.id.iv_back_button)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.c(view);
                }
            });
            this.f71083g = (ProgressBar) inflate.findViewById(R.id.progress_nearbyLoader);
            this.f71078b = (RecyclerView) inflate.findViewById(R.id.nearby_recycler_list);
            this.f71082f = (LinearLayout) inflate.findViewById(R.id.nearbyfragment_error_layout_id);
            this.f71080d = new LinearLayoutManager(this.f71081e);
            this.f71078b.setLayoutManager(this.f71080d);
            this.f71078b.setItemAnimator(new g());
            this.f71084h = new c(this, new ArrayList(), this.f71081e);
            this.f71078b.setAdapter(this.f71084h);
            this.f71078b.addOnScrollListener(new a(this, (byte) 0));
            a(inflate);
            a(0, this.f71081e.h());
        } else {
            View inflate3 = from.inflate(R.layout.nb_error_network_off, (ViewGroup) null);
            this.f71082f.removeAllViews();
            this.f71082f.addView(inflate3);
            this.f71082f.setVisibility(0);
            relativeLayout.setVisibility(8);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        a();
        this.l.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void a(View view) {
        if (this.r == -1) {
            b(view);
            view.findViewById(R.id.iv_down_menu_button).setVisibility(0);
            view.findViewById(R.id.nearby_title_ll).setOnClickListener(this);
            return;
        }
        ((TextView) view.findViewById(R.id.tv_toolbar_title)).setText(((NearByMainActivity) getActivity()).f70993d.get(this.q).getSubCategoryDetails().get(this.r).getSubCategoryName());
    }

    private void b(View view) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.nearby_subcategory_recycler_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList = ((NearByMainActivity) getActivity()).f70993d;
            e eVar = new e(arrayList.get(this.q).getSubCategoryDetails());
            recyclerView.setAdapter(eVar);
            recyclerView.setVisibility(0);
            eVar.f71043a = this.s;
            ((TextView) view.findViewById(R.id.tv_toolbar_title)).setText(arrayList.get(this.q).getCategoryName());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, double[] dArr) {
        this.f71082f.setVisibility(8);
        String b2 = b();
        String c2 = c();
        ProgressBar progressBar = this.f71083g;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(b2)) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                Toast.makeText(getActivity(), getActivity().getString(R.string.no_internet), 1).show();
                return;
            }
            a(a(dArr[0], dArr[1], b2, c2, i2));
        }
    }

    private void a() {
        this.m.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
        if (this.f71077a.equals(getString(R.string.nearby_pay_with_paytm))) {
            this.n.setChecked(true);
            this.o.setChecked(false);
            this.p.setChecked(false);
            this.n.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.o.setTypeface(Typeface.create("sans-serif-light", 0));
            this.p.setTypeface(Typeface.create("sans-serif-light", 0));
        } else if (this.f71077a.equals(getString(R.string.nearby_add_cash))) {
            this.n.setChecked(false);
            this.o.setChecked(true);
            this.p.setChecked(false);
            this.n.setTypeface(Typeface.create("sans-serif-light", 0));
            this.o.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.p.setTypeface(Typeface.create("sans-serif-light", 0));
        } else if (this.f71077a.equals(getString(R.string.nearby_upgrade_account))) {
            this.n.setChecked(false);
            this.o.setChecked(false);
            this.p.setChecked(true);
            this.n.setTypeface(Typeface.create("sans-serif-light", 0));
            this.o.setTypeface(Typeface.create("sans-serif-light", 0));
            this.p.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
        this.m.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.rb_pay_with_paytm) {
            this.f71077a = getString(R.string.nearby_pay_with_paytm);
        } else if (i2 == R.id.rb_add_cash) {
            this.f71077a = getString(R.string.nearby_add_cash);
        } else if (i2 == R.id.rb_upgrade_account) {
            this.f71077a = getString(R.string.nearby_upgrade_account);
        }
        a();
        String str = this.f71077a;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "nearby");
            hashMap.put("new_wallet_nearby_tab_name", str);
            d.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.d.f71130b;
            d.a.b().a("new_wallet_nearby_tab_clicked", (HashMap<String, Object>) hashMap, (Context) getActivity());
        } catch (Exception unused) {
        }
        this.f71079c.setText(this.f71077a);
        a(0, this.f71081e.h());
        this.l.dismiss();
    }

    private String b() {
        return getActivity() instanceof NearByMainActivity ? ((NearByMainActivity) getActivity()).f70993d.get(this.q).getCategoryName() : "";
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        if (getActivity() instanceof NearByMainActivity) {
            List<NearbyCategorySubCategoryModal.SubCategoryDetail> subCategoryDetails = ((NearByMainActivity) getActivity()).f70993d.get(this.q).getSubCategoryDetails();
            int i2 = this.r;
            if (i2 == -1) {
                for (int i3 = 0; i3 < subCategoryDetails.size(); i3++) {
                    sb.append(subCategoryDetails.get(i3).getSubCategoryName());
                    if (i3 != subCategoryDetails.size() - 1) {
                        sb.append("|");
                    }
                }
            } else {
                sb.append(subCategoryDetails.get(i2).getSubCategoryName());
            }
        }
        return sb.toString();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.nearby_title_ll && (getActivity() instanceof NearByMainActivity)) {
            ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList = ((NearByMainActivity) getActivity()).f70993d;
            Intent intent = new Intent(getActivity(), NearbyBrowseCategoryActivity.class);
            intent.putExtra(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, this.q);
            intent.putExtra("category_list", arrayList);
            startActivityForResult(intent, 10);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 10 && i3 == -1 && this.f71081e != null) {
            this.q = intent.getIntExtra(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, this.q);
            this.f71084h.c();
            ProgressBar progressBar = this.f71083g;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            a(this.q, this.f71081e.h());
            a(getView());
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        c cVar;
        if (getActivity() != null && !getActivity().isFinishing()) {
            ProgressBar progressBar = this.f71083g;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
                PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                    c cVar2 = this.f71084h;
                    if (cVar2 != null) {
                        if (this.k == 0) {
                            cVar2.c();
                        }
                        c cVar3 = this.f71084h;
                        ArrayList<PayTMPartnerListModal.Response> arrayList = payTMPartnerListModal.response;
                        try {
                            cVar3.a();
                            if (cVar3.f71016b == null) {
                                cVar3.f71016b = new ArrayList<>();
                                cVar3.b();
                            }
                            if (arrayList != null) {
                                cVar3.f71016b.addAll(arrayList);
                                cVar3.a(arrayList.size());
                                cVar3.notifyDataSetChanged();
                            }
                        } catch (IllegalStateException e2) {
                            q.b(e2.getMessage());
                        } catch (Exception unused) {
                        }
                    }
                    RecyclerView recyclerView = this.f71078b;
                    if (!(recyclerView == null || recyclerView.getAdapter() != null || (cVar = this.f71084h) == null)) {
                        this.f71078b.setAdapter(cVar);
                    }
                    if (payTMPartnerListModal.response != null && payTMPartnerListModal.response.size() < 10) {
                        this.f71085i = true;
                    }
                    if (payTMPartnerListModal.response != null && this.f71084h.getItemCount() <= 0) {
                        d();
                    }
                } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                    payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ProgressBar progressBar;
        if (getActivity() != null && !getActivity().isFinishing() && (progressBar = this.f71083g) != null) {
            progressBar.setVisibility(8);
            d();
        }
    }

    class a extends RecyclerView.l {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                }
            } else if (!d.this.f71085i || recyclerView.canScrollVertically(1)) {
                int childCount = d.this.f71080d.getChildCount();
                int itemCount = d.this.f71080d.getItemCount();
                int findFirstVisibleItemPosition = d.this.f71080d.findFirstVisibleItemPosition();
                if (d.this.f71083g.getVisibility() != 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && d.this.f71084h != null) {
                    double[] h2 = d.this.f71081e.h();
                    if (h2 == null || h2[0] + h2[1] <= 0.0d) {
                        d dVar = d.this;
                        dVar.a(dVar.f71084h.getItemCount(), d.this.f71081e.h());
                        return;
                    }
                    d dVar2 = d.this;
                    dVar2.a(dVar2.f71084h.getItemCount(), h2);
                }
            } else if (d.this.j != null) {
                d.this.j.cancel();
                d dVar3 = d.this;
                Toast unused = dVar3.j = Toast.makeText(dVar3.getActivity(), d.this.getResources().getString(R.string.no_nearby_data), 1);
                d.this.j.show();
            } else {
                d dVar4 = d.this;
                Toast unused2 = dVar4.j = Toast.makeText(dVar4.getActivity(), d.this.getResources().getString(R.string.no_nearby_data), 1);
                d.this.j.show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (this.f71081e == null) {
                return;
            }
            if (!this.f71081e.isFinishing()) {
                if (this.f71083g != null) {
                    this.f71083g.setVisibility(0);
                }
                String str = null;
                c.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                if (c.a.a() != null) {
                    c.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                    c.a.a();
                    str = net.one97.paytm.wallet.newdesign.nearby.helper.c.a("nearbyMerchant");
                }
                if (str == null) {
                    return;
                }
                if (URLUtil.isValidUrl(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71081e));
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f71081e));
                    com.paytm.utility.b.j();
                    net.one97.paytm.wallet.newdesign.nearby.a.a();
                    JSONObject a2 = net.one97.paytm.wallet.newdesign.nearby.a.a(fetchCashPointRequestModal);
                    a.C1440a aVar3 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    com.paytm.network.b a3 = a.C1440a.a();
                    a3.f42877a = this.f71081e;
                    a3.f42879c = a.C0715a.POST;
                    a3.f42884h = a2.toString();
                    a3.f42882f = hashMap;
                    a3.f42885i = new PayTMPartnerListModal();
                    a3.f42880d = str;
                    a3.o = c.class.getName();
                    a3.n = a.b.USER_FACING;
                    a3.j = this;
                    com.paytm.network.a l2 = a3.l();
                    if (com.paytm.utility.b.c((Context) this.f71081e)) {
                        l2.a();
                        return;
                    }
                    a.C1440a aVar4 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                    a.C1440a.a(getContext(), l2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private FetchCashPointRequestModal a(double d2, double d3, String str, String str2, int i2) {
        this.k = i2;
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.getClass();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList();
        fetchCashPointRequestModal.request.sortBy = new HashMap<>();
        fetchCashPointRequestModal.request.startLimit = Integer.valueOf(i2);
        fetchCashPointRequestModal.request.endLimit = 20;
        fetchCashPointRequestModal.getClass();
        FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
        if (!TextUtils.isEmpty(str)) {
            String str3 = "PAYMENT_POINT";
            if (!this.f71077a.equals(getString(R.string.nearby_pay_with_paytm))) {
                if (this.f71077a.equals(getString(R.string.nearby_add_cash))) {
                    str3 = "CASH_POINT";
                } else if (this.f71077a.equals(getString(R.string.nearby_upgrade_account))) {
                    str3 = "KYC_POINT";
                }
            }
            searchFilter.filterType = "SERVICE";
            searchFilter.value = str3;
            fetchCashPointRequestModal.request.searchFilter.add(searchFilter);
        }
        if (!TextUtils.isEmpty(str)) {
            fetchCashPointRequestModal.getClass();
            FetchCashPointRequestModal.SearchFilter searchFilter2 = new FetchCashPointRequestModal.SearchFilter();
            searchFilter2.filterType = "CATEGORY";
            searchFilter2.value = str;
            fetchCashPointRequestModal.request.searchFilter.add(searchFilter2);
        }
        if (!TextUtils.isEmpty(str2)) {
            fetchCashPointRequestModal.getClass();
            FetchCashPointRequestModal.SearchFilter searchFilter3 = new FetchCashPointRequestModal.SearchFilter();
            searchFilter3.filterType = "SUBCATEGORY";
            searchFilter3.value = str2;
            fetchCashPointRequestModal.request.searchFilter.add(searchFilter3);
        }
        fetchCashPointRequestModal.request.latitude = String.valueOf(d2);
        fetchCashPointRequestModal.request.longitude = String.valueOf(d3);
        return fetchCashPointRequestModal;
    }

    private void d() {
        NearByMainActivity nearByMainActivity;
        NearByMainActivity nearByMainActivity2 = this.f71081e;
        if ((nearByMainActivity2 == null || !nearByMainActivity2.isFinishing() || !this.f71081e.isDestroyed()) && (nearByMainActivity = this.f71081e) != null) {
            View inflate = LayoutInflater.from(nearByMainActivity).inflate(R.layout.nb_error_no_nearby, (ViewGroup) null);
            this.f71082f.removeAllViews();
            this.f71082f.addView(inflate);
            this.f71082f.setVisibility(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
