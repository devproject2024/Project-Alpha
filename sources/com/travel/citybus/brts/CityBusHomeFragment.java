package com.travel.citybus.brts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.utility.t;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestRecentResponse;
import com.travel.citybus.best.model.BestRecentTickets;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.best.ui.a.f;
import com.travel.citybus.best.ui.activities.CityBusEPurseDetailsActivity;
import com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity;
import com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity;
import com.travel.citybus.brts.b.a;
import com.travel.citybus.brts.citybus.AJRCityBusSRPActivity;
import com.travel.citybus.brts.citybus.j;
import com.travel.citybus.brts.citybus.s;
import com.travel.citybus.brts.citybus.u;
import com.travel.citybus.brts.citybus.x;
import com.travel.citybus.brts.model.CJRAmountPax;
import com.travel.citybus.brts.model.CJRBCLLData;
import com.travel.citybus.brts.model.pojo.CJRCity;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import com.travel.citybus.brts.model.pojo.CJRCityResponseModel;
import com.travel.citybus.brts.utils.d;
import com.travel.citybus.brts.utils.e;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.d.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.brts.CJRBrtsDestination;
import net.one97.paytm.common.entity.brts.CJRBrtsRoute;
import net.one97.paytm.i.h;

public class CityBusHomeFragment extends h implements View.OnClickListener, x.a {
    private static String mSourceId;
    private Button btnRetryInternet;
    private s cityBottomSheet;
    private j cityBusHomeFragmentPresenter;
    private List<CJRCity> cityList = null;
    private ConstraintLayout clNoInternet;
    private b compositeDisposable;
    private ConstraintLayout constraintLayoutRecent;
    private String deepLinkUrl;
    private String destinationStationCode;
    ArrayList<CJRBrtsDestination> destinations;
    private AppCompatImageView ivBestLogo;
    private TextView labelRecent;
    private Animation mAnimMoveDown;
    private Animation mAnimMoveUp;
    private Animation mAnimationShake;
    private CJRAmountPax.CJRBCLLResponse mBCLLData;
    private BestEPurse mBestPurse;
    private List<BestRecentTickets> mBestRecent;
    private TextView mCityBusName;
    private TextView mCityChangeButton;
    private Context mContext;
    private TextView mDestinationName;
    private boolean mFirstTimeLaunch = true;
    private boolean mIsTabFragment = false;
    private boolean mIsVisibleToUser = false;
    private ImageView mLogo;
    private ImageView mLogoImg;
    private TextView mMerchantName;
    private Button mProceedButton;
    private Animation mRotateAnimation;
    private TextView mSourceName;
    private ProgressBar progressBar;
    private b recentTicketsAdapter;
    private RecyclerView recyclerViewRecent;
    private RelativeLayout rlActiveTicket;
    private RelativeLayout rlActiveToken;
    private RelativeLayout rlEPurseData;
    private RelativeLayout rlHowToBook;
    private CJRCity selectedCity;
    private String selectedCityBusImage;
    private CJRCityAutoSuggest selectedDestinationStop;
    private CJRCityAutoSuggest selectedSourceStop;
    private String sourceStationCode;
    private ScrollView svContainer;
    private AppCompatImageView toggleCity;
    private TextView tvCityBusName;
    private TextView tvEPurseBalance;
    private TextView tvEPurseLowBalance;
    private TextView tvTicketBusName;
    private TextView tvTicketCount;

    public void lottieLayoutGone() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.deepLinkUrl = arguments.getString("deeplink-data");
            this.mIsTabFragment = arguments.getBoolean("tab");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_city_bus_home_booking, viewGroup, false);
        initView(inflate);
        this.compositeDisposable = new b();
        this.cityBusHomeFragmentPresenter = new j(this);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        String str = this.deepLinkUrl;
        if (str == null) {
            initCityList();
        } else if (!TextUtils.isEmpty(j.a(str))) {
            mSourceId = j.b(this.deepLinkUrl);
            j jVar = this.cityBusHomeFragmentPresenter;
            FragmentActivity requireActivity = requireActivity();
            String str2 = this.deepLinkUrl;
            k.c(requireActivity, "context");
            k.c(str2, "deepLinkUri");
            String c2 = j.c(str2);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            a.a();
            a.a(requireActivity, c2, hashMap, new CJRBCLLData(), new j.a(jVar, requireActivity));
        }
        super.onActivityCreated(bundle);
    }

    private void initCityList() {
        if (this.cityList == null) {
            callCityList();
        }
        b bVar = this.compositeDisposable;
        e eVar = e.f23402a;
        bVar.a(e.a(com.travel.citybus.brts.citybus.k.class).subscribe(new g() {
            public final void accept(Object obj) {
                CityBusHomeFragment.this.lambda$initCityList$0$CityBusHomeFragment((com.travel.citybus.brts.citybus.k) obj);
            }
        }));
        b bVar2 = this.compositeDisposable;
        e eVar2 = e.f23402a;
        bVar2.a(e.a(CJRCity.class).subscribe(new g() {
            public final void accept(Object obj) {
                CityBusHomeFragment.this.lambda$initCityList$1$CityBusHomeFragment((CJRCity) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCitySelection */
    public void lambda$initCityList$1$CityBusHomeFragment(CJRCity cJRCity) {
        this.mCityBusName.setText(cJRCity.getName());
        this.mSourceName.setText("");
        this.mSourceName.setTypeface(Typeface.DEFAULT);
        this.mDestinationName.setText("");
        this.mDestinationName.setTypeface(Typeface.DEFAULT);
        this.sourceStationCode = "";
        this.destinationStationCode = "";
        this.selectedSourceStop = null;
        this.selectedDestinationStop = null;
        this.selectedCity = cJRCity;
        this.mCityBusName.setText(cJRCity.getName());
        if (this.mLogoImg.getVisibility() != 0) {
            this.mLogoImg.setVisibility(0);
        }
        this.selectedCityBusImage = cJRCity.getImageURL();
        t.a(false);
        getActivity();
        t.b(cJRCity.getImageURL(), this.mLogoImg);
        s sVar = this.cityBottomSheet;
        if (sVar != null && sVar.isVisible()) {
            this.cityBottomSheet.dismiss();
        }
        if (com.travel.citybus.best.a.a(cJRCity) && cJRCity.isEnabled()) {
            prefillToCity();
            prefillFromCity();
        }
        checkForEPurseData();
    }

    private void checkForEPurseData() {
        CJRCity cJRCity = this.selectedCity;
        if (cJRCity == null || !com.travel.citybus.best.a.a(cJRCity)) {
            hideBestCityViews();
            return;
        }
        j jVar = this.cityBusHomeFragmentPresenter;
        Context context = this.mContext;
        k.c(context, "context");
        com.travel.citybus.best.d.a aVar = com.travel.citybus.best.d.a.f23050a;
        com.travel.citybus.best.d.a.a(context, jVar);
        j jVar2 = this.cityBusHomeFragmentPresenter;
        Context context2 = this.mContext;
        k.c(context2, "context");
        com.travel.citybus.best.d.a aVar2 = com.travel.citybus.best.d.a.f23050a;
        com.travel.citybus.best.d.a.b(context2, new j.b(jVar2, context2));
    }

    private void callCityList() {
        if (com.paytm.utility.b.c((Context) requireActivity())) {
            j jVar = this.cityBusHomeFragmentPresenter;
            Context context = this.mContext;
            k.c(context, "context");
            k.a((Object) f.d(), "TransportBrtsController.getInstance()");
            String a2 = f.d().a("cityBusCitiesURL");
            if (TextUtils.isEmpty(a2)) {
                a2 = a.f23180h;
            }
            if (!TextUtils.isEmpty(a2)) {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("Content-Type", "application/json");
                d.a aVar = d.f23400a;
                hashMap.put("phone-number", d.a.a(context).b("mobile", "", true));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.TRANSPORT_BRTS;
                bVar.n = a.b.SILENT;
                bVar.o = CityBusHomeFragment.class.getSimpleName();
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = a2;
                bVar.f42882f = hashMap;
                bVar.f42885i = new CJRCityResponseModel();
                bVar.j = jVar;
                com.paytm.network.a l = bVar.l();
                l.f42859c = false;
                l.a();
                return;
            }
            return;
        }
        this.progressBar.setVisibility(8);
        showInternetIssue(true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        com.travel.citybus.a.a.a(context);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisibleToUser = z;
    }

    public void onResume() {
        com.travel.citybus.a.a.a(getActivity());
        super.onResume();
        if (this.mIsTabFragment) {
            if (this.mIsVisibleToUser && !this.mFirstTimeLaunch) {
                checkForEPurseData();
            }
            this.mFirstTimeLaunch = false;
            return;
        }
        checkForEPurseData();
    }

    private void setData(List<CJRCity> list) {
        this.progressBar.setVisibility(8);
        int i2 = 0;
        for (CJRCity isEnabled : list) {
            if (isEnabled.isEnabled()) {
                i2++;
            }
        }
        if (i2 == 0) {
            showErrorDialog(getActivity().getString(R.string.error_proceed), getActivity().getString(R.string.city_bus_best_no_active_cities), true);
            return;
        }
        if (i2 == 1) {
            this.mCityChangeButton.setVisibility(4);
        }
        this.svContainer.setVisibility(0);
        if (this.mBCLLData != null) {
            for (CJRCity next : this.cityList) {
                if (next.getName().equalsIgnoreCase(this.mBCLLData.getCity())) {
                    this.selectedCity = next;
                    t.a(false);
                    getActivity();
                    t.b(this.selectedCity.getImageURL(), this.mLogoImg);
                    this.mCityBusName.setText(next.getName());
                    if (this.mLogoImg.getVisibility() != 0) {
                        this.mLogoImg.setVisibility(0);
                    }
                }
            }
            if (this.mBCLLData.getSourceInfoList() != null) {
                CJRBrtsRoute cJRBrtsRoute = this.mBCLLData.getSourceInfoList().get(0);
                this.selectedSourceStop = new CJRCityAutoSuggest(cJRBrtsRoute.getSourceId(), cJRBrtsRoute.getSourceName(), mSourceId, 0, true);
                this.mSourceName.setText(this.selectedSourceStop.getName());
                this.mSourceName.setTypeface(Typeface.DEFAULT_BOLD);
                this.sourceStationCode = this.selectedSourceStop.getStationId();
                return;
            }
            return;
        }
        CJRCity cJRCity = null;
        CJRCity cJRCity2 = null;
        CJRCity cJRCity3 = null;
        for (CJRCity next2 : list) {
            if (next2.isEnabled()) {
                if (com.travel.citybus.best.a.a(next2.getMerchantName())) {
                    cJRCity = next2;
                } else if (com.travel.citybus.best.a.a(next2)) {
                    cJRCity2 = next2;
                } else {
                    cJRCity3 = next2;
                }
            }
        }
        if (cJRCity != null) {
            lambda$initCityList$1$CityBusHomeFragment(cJRCity);
        } else if (cJRCity2 != null) {
            lambda$initCityList$1$CityBusHomeFragment(cJRCity2);
        } else if (cJRCity3 != null) {
            lambda$initCityList$1$CityBusHomeFragment(cJRCity3);
        }
    }

    private void setRouteAutoComplete() {
        this.destinations = new ArrayList<>();
        HashSet hashSet = new HashSet();
        CJRAmountPax.CJRBCLLResponse cJRBCLLResponse = this.mBCLLData;
        if (cJRBCLLResponse != null) {
            Iterator<CJRBrtsRoute> it2 = cJRBCLLResponse.getSourceInfoList().iterator();
            while (it2.hasNext()) {
                hashSet.addAll(it2.next().getDestinations());
            }
        }
        this.destinations.addAll(hashSet);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.brts_proceed_btn) {
            onProceedButtonClick();
        } else if (id == R.id.txt_source_name) {
            CJRCity cJRCity = this.selectedCity;
            if (cJRCity != null) {
                launchSearchStationFragment(1, cJRCity.getProductId());
            }
        } else if (id == R.id.txt_destination_name) {
            CJRCity cJRCity2 = this.selectedCity;
            if (cJRCity2 != null) {
                launchSearchStationFragment(2, cJRCity2.getProductId());
            } else {
                showSourceCityMissingAlert();
            }
        } else if (id == R.id.change_city_textview) {
            List<CJRCity> list = this.cityList;
            if (list != null) {
                showBottomSheet(list);
            }
        } else if (id == R.id.rlActiveToken) {
            showValidationActivity();
        } else if (id == R.id.rlEPurseData) {
            showEWalletDetails();
        } else if (id == R.id.rlHowToBook) {
            showHowToBook();
        } else if (id == R.id.rlActiveTicket) {
            showOrderSummary();
        } else if (id == R.id.btn_retry) {
            reloadHomeFragment();
        }
    }

    private void showOrderSummary() {
        Intent intent = new Intent(getActivity(), CityBusOrderSummaryActivity.class);
        intent.putExtra("validation_success", this.mBestPurse);
        intent.putExtra("best_image_logo", this.selectedCityBusImage);
        intent.putExtra("is_active_ticket", true);
        startActivity(intent);
    }

    private void showValidationActivity() {
        Intent intent = new Intent(getActivity(), CityBusTokenValidationActivity.class);
        intent.putExtra("best_image_logo", this.selectedCityBusImage);
        intent.putExtra("best_e_purse_data", this.mBestPurse);
        startActivity(intent);
    }

    private void showEWalletDetails() {
        if (com.paytm.utility.b.r((Context) getActivity())) {
            Intent intent = new Intent(getActivity(), CityBusEPurseDetailsActivity.class);
            intent.putExtra("best_e_purse_data", this.mBestPurse);
            intent.putExtra("extra_city", this.selectedCity);
            startActivity(intent);
            return;
        }
        f.d();
        f.d().b(getActivity(), (Intent) null);
    }

    private void reloadHomeFragment() {
        if (getFragmentManager() != null) {
            q a2 = getFragmentManager().a();
            if (Build.VERSION.SDK_INT >= 26) {
                a2.s = false;
            }
            a2.d(this).f(this).b();
        }
    }

    private void showHowToBook() {
        new f().show(getChildFragmentManager(), f.class.getSimpleName());
    }

    public void showBottomSheet(List<CJRCity> list) {
        if (isAdded()) {
            this.cityBottomSheet = new s();
            Bundle bundle = new Bundle();
            bundle.putSerializable("city_list_key", (Serializable) list);
            this.cityBottomSheet.setArguments(bundle);
            this.cityBottomSheet.show(getChildFragmentManager(), CityBusHomeFragment.class.getSimpleName());
        }
    }

    public void launchSearchStationFragment(int i2, String str) {
        u uVar = new u();
        u.a(this.destinations);
        Bundle bundle = new Bundle();
        bundle.putInt("city_bus_key", i2);
        bundle.putParcelable("selected_source_stop", this.selectedSourceStop);
        bundle.putParcelable("selected_dest_stop", this.selectedDestinationStop);
        bundle.putString(a.f23173a, str);
        uVar.setArguments(bundle);
        uVar.show(getChildFragmentManager(), CityBusHomeFragment.class.getSimpleName());
    }

    private void onProceedButtonClick() {
        j jVar = this.cityBusHomeFragmentPresenter;
        String charSequence = this.mSourceName.getText().toString();
        String str = this.sourceStationCode;
        String charSequence2 = this.mDestinationName.getText().toString();
        String str2 = this.destinationStationCode;
        CJRCity cJRCity = this.selectedCity;
        if (charSequence != null && charSequence2 != null) {
            CharSequence charSequence3 = charSequence;
            boolean z = false;
            if ((charSequence3.length() == 0) || str == null) {
                if (charSequence2.length() == 0) {
                    z = true;
                }
                if (z || str2 == null) {
                    jVar.f23299b.showBothCityMissingAlert();
                    return;
                } else {
                    jVar.f23299b.showSourceCityMissingAlert();
                    return;
                }
            } else {
                if ((charSequence2.length() == 0) || str2 == null) {
                    if (charSequence3.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        jVar.f23299b.showBothCityMissingAlert();
                        return;
                    } else {
                        jVar.f23299b.showDestinationCityMissingAlert();
                        return;
                    }
                } else if (!p.a(str, str2, true)) {
                    if (!com.travel.citybus.best.a.a(cJRCity) || jVar.f23298a != null) {
                        x.a aVar = jVar.f23299b;
                        BestEPurseTokenResponse bestEPurseTokenResponse = jVar.f23298a;
                        aVar.launchCityBusRouteActivity(bestEPurseTokenResponse != null ? bestEPurseTokenResponse.getResponse() : null);
                        return;
                    }
                    jVar.f23299b.ePurseDetailsMissing();
                    return;
                }
            }
        } else if (charSequence == null && charSequence2 != null) {
            jVar.f23299b.showSourceCityMissingAlert();
            return;
        } else if (charSequence2 == null && charSequence != null) {
            jVar.f23299b.showDestinationCityMissingAlert();
            return;
        }
        jVar.f23299b.showBothCityMissingAlert();
    }

    private void hideBestCityViews() {
        this.rlActiveToken.setVisibility(8);
        this.rlEPurseData.setVisibility(8);
        this.rlHowToBook.setVisibility(8);
        this.rlActiveTicket.setVisibility(8);
        this.constraintLayoutRecent.setVisibility(8);
    }

    public void initView(View view) {
        this.mLogo = (ImageView) view.findViewById(R.id.brts_logo);
        setRouteAutoComplete();
        this.mMerchantName = (TextView) view.findViewById(R.id.brts_tag_txt);
        this.mSourceName = (TextView) view.findViewById(R.id.txt_source_name);
        this.mDestinationName = (TextView) view.findViewById(R.id.txt_destination_name);
        this.mProceedButton = (Button) view.findViewById(R.id.brts_proceed_btn);
        this.mCityChangeButton = (TextView) view.findViewById(R.id.change_city_textview);
        this.toggleCity = (AppCompatImageView) view.findViewById(R.id.sep_route);
        this.mLogoImg = (ImageView) view.findViewById(R.id.bmtc_logo_imageview);
        this.mCityBusName = (TextView) view.findViewById(R.id.citybus_city_name);
        this.rlActiveToken = (RelativeLayout) view.findViewById(R.id.rlActiveToken);
        this.tvCityBusName = (TextView) view.findViewById(R.id.tvCityBusName);
        this.rlEPurseData = (RelativeLayout) view.findViewById(R.id.rlEPurseData);
        this.tvEPurseBalance = (TextView) view.findViewById(R.id.tvEPurseBalance);
        this.tvEPurseLowBalance = (TextView) view.findViewById(R.id.tvEPurseLowBalance);
        this.rlActiveTicket = (RelativeLayout) view.findViewById(R.id.rlActiveTicket);
        this.ivBestLogo = (AppCompatImageView) view.findViewById(R.id.ivBestLogo);
        this.tvTicketCount = (TextView) view.findViewById(R.id.tvTicketCount);
        this.tvTicketBusName = (TextView) view.findViewById(R.id.tvTicketBusName);
        this.rlHowToBook = (RelativeLayout) view.findViewById(R.id.rlHowToBook);
        this.btnRetryInternet = (Button) view.findViewById(R.id.btn_retry);
        this.clNoInternet = (ConstraintLayout) view.findViewById(R.id.no_internet_found);
        this.svContainer = (ScrollView) view.findViewById(R.id.svContainer);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        this.mProceedButton.setOnClickListener(this);
        this.rlActiveToken.setOnClickListener(this);
        this.rlActiveTicket.setOnClickListener(this);
        this.mSourceName.setOnClickListener(this);
        this.mDestinationName.setOnClickListener(this);
        this.mCityChangeButton.setOnClickListener(this);
        this.rlEPurseData.setOnClickListener(this);
        this.rlHowToBook.setOnClickListener(this);
        this.btnRetryInternet.setOnClickListener(this);
        this.toggleCity.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CityBusHomeFragment.this.lambda$initView$2$CityBusHomeFragment(view);
            }
        });
        this.mAnimMoveUp = AnimationUtils.loadAnimation(getActivity(), R.anim.best_move_up);
        this.mAnimMoveDown = AnimationUtils.loadAnimation(getActivity(), R.anim.best_move_down);
        this.mRotateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.best_rotate360);
        this.mRotateAnimation.setRepeatCount(1);
        this.mAnimationShake = AnimationUtils.loadAnimation(getActivity(), R.anim.best_shake);
        this.recyclerViewRecent = (RecyclerView) view.findViewById(R.id.rv_recent_tickets);
        this.constraintLayoutRecent = (ConstraintLayout) view.findViewById(R.id.cl_recent_tickets);
        this.labelRecent = (TextView) view.findViewById(R.id.lbl_recent_tickets);
    }

    public /* synthetic */ void lambda$initView$2$CityBusHomeFragment(View view) {
        onExchangePressed();
    }

    private void prefillToCity() {
        d.a aVar = d.f23400a;
        String b2 = d.a.a(requireActivity()).b("citybus-prefill-to-data", "", false);
        CJRCityAutoSuggest cJRCityAutoSuggest = !TextUtils.isEmpty(b2) ? (CJRCityAutoSuggest) new com.google.gsonhtcfix.f().a(b2, new com.google.gson.b.a<CJRCityAutoSuggest>() {
        }.getType()) : null;
        if (com.travel.citybus.brts.utils.a.a(cJRCityAutoSuggest)) {
            this.mDestinationName.setText(cJRCityAutoSuggest.getName());
            this.selectedDestinationStop = cJRCityAutoSuggest;
            this.destinationStationCode = cJRCityAutoSuggest.getStationId();
        }
    }

    private void prefillFromCity() {
        d.a aVar = d.f23400a;
        String b2 = d.a.a(requireActivity()).b("citybus-prefill-from-data", "", false);
        CJRCityAutoSuggest cJRCityAutoSuggest = !TextUtils.isEmpty(b2) ? (CJRCityAutoSuggest) new com.google.gsonhtcfix.f().a(b2, new com.google.gson.b.a<CJRCityAutoSuggest>() {
        }.getType()) : null;
        if (com.travel.citybus.brts.utils.a.a(cJRCityAutoSuggest)) {
            this.mSourceName.setText(cJRCityAutoSuggest.getName());
            this.selectedSourceStop = cJRCityAutoSuggest;
            this.sourceStationCode = cJRCityAutoSuggest.getStationId();
        }
    }

    public void setCityListForBottomSheet(List<CJRCity> list) {
        this.cityList = list;
        setData(this.cityList);
    }

    public void showBothCityMissingAlert() {
        com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.error_proceed), getActivity().getString(R.string.unable_proceed_source_dest));
    }

    public void showSourceCityMissingAlert() {
        com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.error_proceed), getActivity().getString(R.string.unable_proceed_source));
    }

    public void showDestinationCityMissingAlert() {
        com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.error_proceed), getActivity().getString(R.string.unable_proceed_dest));
    }

    public void launchCityBusRouteActivity(BestEPurse bestEPurse) {
        Intent intent = new Intent(getActivity().getApplicationContext(), AJRCityBusSRPActivity.class);
        com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
        intent.putExtra(com.travel.citybus.brts.citybus.h.e(), this.selectedSourceStop);
        com.travel.citybus.brts.citybus.h hVar2 = com.travel.citybus.brts.citybus.h.f23284a;
        intent.putExtra(com.travel.citybus.brts.citybus.h.f(), this.selectedDestinationStop);
        com.travel.citybus.brts.citybus.h hVar3 = com.travel.citybus.brts.citybus.h.f23284a;
        intent.putExtra("extra_city", this.selectedCity);
        com.travel.citybus.brts.citybus.h hVar4 = com.travel.citybus.brts.citybus.h.f23284a;
        intent.putExtra("extra_e_purse", bestEPurse);
        startActivity(intent);
    }

    private void savePrefillFromData(CJRCityAutoSuggest cJRCityAutoSuggest) {
        if (cJRCityAutoSuggest != null) {
            String a2 = new com.google.gsonhtcfix.f().a((Object) cJRCityAutoSuggest);
            d.a aVar = d.f23400a;
            d.a.a(requireActivity()).a("citybus-prefill-from-data", a2, false);
        }
    }

    private void savePrefillToData(CJRCityAutoSuggest cJRCityAutoSuggest) {
        if (cJRCityAutoSuggest != null) {
            String a2 = new com.google.gsonhtcfix.f().a((Object) cJRCityAutoSuggest);
            d.a aVar = d.f23400a;
            d.a.a(requireActivity()).a("citybus-prefill-to-data", a2, false);
        }
    }

    public void showEPurseData(BestEPurse bestEPurse) {
        int i2;
        this.mBestPurse = bestEPurse;
        if (this.mBestPurse != null) {
            this.rlEPurseData.setVisibility(0);
            TextView textView = this.tvEPurseBalance;
            StringBuilder sb = new StringBuilder("₹ ");
            if (bestEPurse != null) {
                i2 = com.paytm.utility.b.a((double) bestEPurse.getAmountBalance());
            } else {
                i2 = 0;
            }
            sb.append(i2);
            textView.setText(sb.toString());
            this.tvEPurseLowBalance.setVisibility(bestEPurse.getAmountBalance() < bestEPurse.getMinBalance() ? 0 : 8);
            this.rlHowToBook.setVisibility(0);
            setTips();
        }
    }

    public void showRecentBookedTickets(BestRecentResponse bestRecentResponse) {
        this.mBestRecent = bestRecentResponse.getResponse();
        List<BestRecentTickets> list = this.mBestRecent;
        if (list != null) {
            if (list.size() > 0) {
                this.constraintLayoutRecent.setVisibility(0);
                this.recentTicketsAdapter = new b(this.mContext, this.mBestRecent);
                this.recyclerViewRecent.setLayoutManager(new LinearLayoutManager(this.mContext, 0, true));
                this.recyclerViewRecent.setAdapter(this.recentTicketsAdapter);
                return;
            }
            this.constraintLayoutRecent.setVisibility(8);
        }
    }

    public void showActiveToken(BestToken bestToken) {
        if (bestToken != null) {
            this.rlActiveToken.setVisibility(0);
            this.tvCityBusName.setText(bestToken.getRouteName());
            return;
        }
        this.rlActiveToken.setVisibility(8);
    }

    public void showActiveTicket(BestToken bestToken) {
        if (bestToken != null) {
            this.rlActiveTicket.setVisibility(0);
            t.a(false);
            getActivity();
            t.b(this.selectedCity.getImageURL(), this.ivBestLogo);
            this.tvTicketCount.setText(com.travel.citybus.best.a.a(bestToken.getPassengerCount().intValue()));
            this.tvTicketBusName.setText(bestToken.getRouteName());
            return;
        }
        this.rlActiveTicket.setVisibility(8);
    }

    public void showInternetIssue(boolean z) {
        if (z) {
            hideBestCityViews();
            this.clNoInternet.setVisibility(0);
            return;
        }
        this.clNoInternet.setVisibility(8);
    }

    private void setTips() {
        if (getActivity() != null && !getToolTipViewedStatus(getActivity()).booleanValue()) {
            com.travel.citybus.best.ui.a.e eVar = new com.travel.citybus.best.ui.a.e();
            eVar.show(getChildFragmentManager(), eVar.getTag());
        }
    }

    public void ePurseDetailsMissing() {
        com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.brts_error), getActivity().getString(R.string.citybus_epurse_missing));
    }

    public void setBCLLData(CJRAmountPax.CJRBCLLResponse cJRBCLLResponse) {
        this.mBCLLData = cJRBCLLResponse;
        initCityList();
    }

    public void showError(String str) {
        this.progressBar.setVisibility(8);
        showErrorDialog(getString(R.string.brts_error), str, true);
    }

    public void showMerchantName(String str) {
        if (str != null) {
            this.mMerchantName.setText(str);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.compositeDisposable.a();
        this.compositeDisposable.dispose();
    }

    private Boolean getToolTipViewedStatus(Context context) {
        d.a aVar = d.f23400a;
        return Boolean.valueOf(d.a.a(context).b("e_purse_tt", false, false));
    }

    private void showErrorDialog(String str, String str2, boolean z) {
        com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.brts_alert);
        }
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCancelable(false);
        hVar.a(-3, getResources().getString(R.string.brts_ok), new View.OnClickListener(hVar, z) {
            private final /* synthetic */ com.paytm.utility.h f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CityBusHomeFragment.this.lambda$showErrorDialog$3$CityBusHomeFragment(this.f$1, this.f$2, view);
            }
        });
        hVar.show();
    }

    public /* synthetic */ void lambda$showErrorDialog$3$CityBusHomeFragment(com.paytm.utility.h hVar, boolean z, View view) {
        hVar.cancel();
        if (!this.mIsTabFragment && z) {
            getActivity().finish();
        }
    }

    private void onExchangePressed() {
        String charSequence = this.mSourceName.getText().toString();
        String charSequence2 = this.mDestinationName.getText().toString();
        Object tag = this.mSourceName.getTag();
        Object tag2 = this.mDestinationName.getTag();
        if (!charSequence.isEmpty() && !charSequence.equalsIgnoreCase(getResources().getString(R.string.source_city_stop)) && !charSequence2.isEmpty() && !charSequence2.equalsIgnoreCase(getResources().getString(R.string.destination_city_stop))) {
            this.mSourceName.startAnimation(this.mAnimMoveDown);
            this.mDestinationName.startAnimation(this.mAnimMoveUp);
            this.mSourceName.setText(charSequence2);
            this.mDestinationName.setText(charSequence);
            this.mSourceName.setTag(tag2);
            this.mDestinationName.setTag(tag);
            CJRCityAutoSuggest cJRCityAutoSuggest = this.selectedSourceStop;
            this.selectedSourceStop = this.selectedDestinationStop;
            this.selectedDestinationStop = cJRCityAutoSuggest;
            String str = this.sourceStationCode;
            this.sourceStationCode = this.destinationStationCode;
            this.destinationStationCode = str;
            this.mSourceName.startAnimation(this.mAnimMoveUp);
            this.mDestinationName.startAnimation(this.mAnimMoveDown);
            this.mRotateAnimation.setFillAfter(true);
            if (com.travel.citybus.best.a.a(this.selectedCity) && this.selectedCity.isEnabled()) {
                savePrefillFromData(this.selectedSourceStop);
                savePrefillToData(this.selectedDestinationStop);
            }
        }
    }

    public /* synthetic */ void lambda$initCityList$0$CityBusHomeFragment(com.travel.citybus.brts.citybus.k kVar) throws Throwable {
        int i2 = kVar.f23304a;
        com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
        if (i2 == com.travel.citybus.brts.citybus.h.a()) {
            this.selectedSourceStop = kVar.f23305b;
            CJRCityAutoSuggest cJRCityAutoSuggest = this.selectedSourceStop;
            if (cJRCityAutoSuggest != null) {
                this.mSourceName.setText(cJRCityAutoSuggest.getName());
                this.sourceStationCode = this.selectedSourceStop.getStationId();
                if (this.selectedCity.getName() != null && com.travel.citybus.best.a.a(this.selectedCity) && this.selectedCity.isEnabled()) {
                    savePrefillFromData(this.selectedSourceStop);
                    return;
                }
                return;
            }
            return;
        }
        int i3 = kVar.f23304a;
        com.travel.citybus.brts.citybus.h hVar2 = com.travel.citybus.brts.citybus.h.f23284a;
        if (i3 == com.travel.citybus.brts.citybus.h.b()) {
            this.selectedDestinationStop = kVar.f23305b;
            CJRCityAutoSuggest cJRCityAutoSuggest2 = this.selectedDestinationStop;
            if (cJRCityAutoSuggest2 != null) {
                this.mDestinationName.setText(cJRCityAutoSuggest2.getName());
                this.destinationStationCode = this.selectedDestinationStop.getStationId();
                if (this.selectedCity.getName() != null && com.travel.citybus.best.a.a(this.selectedCity) && this.selectedCity.isEnabled()) {
                    savePrefillToData(this.selectedDestinationStop);
                }
            }
        }
    }
}
