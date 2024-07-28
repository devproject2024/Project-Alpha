package com.travel.train.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.google.gsonhtcfix.f;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.travel.common.a.b;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.j.n;
import com.travel.train.j.w;
import com.travel.train.k.d;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRTrainBookingInformation;
import com.travel.train.model.trainticket.CJRTrainMessagingConfig;
import com.travel.train.model.trainticket.CJRTrainMsgResponse;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class FJRTrainHomeFragment extends am implements b {
    private String LOG_TAG = "FJRTrainHomeFragment";
    private FrameLayout frameContainer;
    private boolean isAllAPIsCalled = false;
    /* access modifiers changed from: private */
    public boolean isNotificationRead = false;
    private Boolean mAgentErrorBoolean = Boolean.FALSE;
    private s mTrainHomeErrorFragment;
    private t mTrainHomeV2Fragment;
    private d mViewModel;
    private SharedPreferences sharedPrefs;
    /* access modifiers changed from: private */
    public SharedPreferences sharedpreferences;
    /* access modifiers changed from: private */
    public Snackbar snackbar = null;
    private CJRHomePageItem travelTabItem;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.train_home_container_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        restoreHomePageResponse();
        getIntentData();
        initView(view);
        initMVVM();
        observeViewModel();
        changeHomeFragment();
        CJRHomePageItem cJRHomePageItem = this.travelTabItem;
        if (cJRHomePageItem != null && cJRHomePageItem.getURLType() != null && getUserVisibleHint() && (this.travelTabItem.getURLType().equalsIgnoreCase("trainticket") || this.travelTabItem.getURLType().equalsIgnoreCase("trainticketv2"))) {
            updateUIWithApiCall();
        }
        this.isNotificationRead = loadNotificationSharedPreference();
    }

    private void initMVVM() {
        if (getActivity() != null) {
            this.mViewModel = (d) am.a(getActivity(), (al.b) new g(new g.a(g.b.V2_HOME).a(a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity()))))).a(d.class);
        }
    }

    private void observeViewModel() {
        d dVar = this.mViewModel;
        if (dVar != null) {
            dVar.f27645g.observe(this, new z() {
                public final void onChanged(Object obj) {
                    FJRTrainHomeFragment.this.showSnackBar((CJRTrainBookingInformation) obj);
                }
            });
            this.mViewModel.f27642d.observe(this, new z() {
                public final void onChanged(Object obj) {
                    FJRTrainHomeFragment.this.saveHomeMsgObject((CJRTrainMsgResponse) obj);
                }
            });
            this.mViewModel.f27643e.observe(this, new z() {
                public final void onChanged(Object obj) {
                    FJRTrainHomeFragment.this.homeMsgRespoError((Boolean) obj);
                }
            });
            this.mViewModel.f27644f.observe(this, new z() {
                public final void onChanged(Object obj) {
                    FJRTrainHomeFragment.this.lambda$observeViewModel$0$FJRTrainHomeFragment((Boolean) obj);
                }
            });
            this.mViewModel.l.observe(this, new z() {
                public final void onChanged(Object obj) {
                    FJRTrainHomeFragment.this.lambda$observeViewModel$1$FJRTrainHomeFragment((Pair) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$observeViewModel$0$FJRTrainHomeFragment(Boolean bool) {
        this.mAgentErrorBoolean = bool;
    }

    public /* synthetic */ void lambda$observeViewModel$1$FJRTrainHomeFragment(Pair pair) {
        setErrorFragment((String) pair.first, (String) pair.second);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isAdded()) {
            updateUIWithApiCall();
        }
    }

    private void getIntentData() {
        try {
            if (getArguments() != null && getArguments().containsKey("bundle_extra_category_item") && (getArguments().getSerializable("bundle_extra_category_item") instanceof CJRHomePageItem)) {
                this.travelTabItem = (CJRHomePageItem) getArguments().getSerializable("bundle_extra_category_item");
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public void restoreHomePageResponse() {
        try {
            com.travel.train.j.g.f27551a = (CJRTrainMessagingConfig) new f().a(w.a(getActivity().getApplicationContext()).b("home_page_object", "", false), CJRTrainMessagingConfig.class);
        } catch (Exception e2) {
            q.b(e2.getLocalizedMessage());
        }
    }

    private void initView(View view) {
        this.frameContainer = (FrameLayout) view.findViewById(R.id.fragment_container);
        this.sharedpreferences = getActivity().getSharedPreferences("train_most_visited", 0);
    }

    private void changeHomeFragment() {
        setHomeIconsFragment();
    }

    public void onVisibleToUser(boolean z) {
        t tVar = this.mTrainHomeV2Fragment;
        if (tVar != null && (tVar instanceof b)) {
            tVar.onVisibleToUser(z);
        }
    }

    public void onVisibilityGone() {
        t tVar = this.mTrainHomeV2Fragment;
        if (tVar != null && (tVar instanceof b)) {
            tVar.onVisibilityGone();
        }
    }

    private void setHomeIconsFragment() {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        if (this.mTrainHomeV2Fragment == null) {
            this.mTrainHomeV2Fragment = t.a(getArguments());
        }
        a2.b(R.id.fragment_container, this.mTrainHomeV2Fragment, (String) null);
        a2.b();
    }

    private void setErrorFragment(String str, String str2) {
        if (this.mAgentErrorBoolean.booleanValue()) {
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            if (this.mTrainHomeErrorFragment == null) {
                Bundle arguments = getArguments();
                arguments.putBoolean("from_home_page", true);
                this.mTrainHomeErrorFragment = s.a(arguments);
            }
            a2.b(R.id.fragment_container, this.mTrainHomeErrorFragment, (String) null);
            a2.b();
            this.mTrainHomeErrorFragment.a(str, str2, false);
        }
    }

    public void updateUIWithApiCall() {
        if (!this.isAllAPIsCalled) {
            this.isAllAPIsCalled = true;
            if (this.mViewModel != null) {
                com.travel.train.b.a();
                Boolean valueOf = Boolean.valueOf(com.travel.train.b.a((Context) getActivity()).equals(e.b.RESELLER.name()));
                d dVar = this.mViewModel;
                HashMap<String, String> b2 = n.b(getContext());
                HashMap<String, String> a2 = n.a(getContext());
                boolean booleanValue = valueOf.booleanValue();
                k.c(b2, H5Logger.HEADER);
                k.c(a2, "urlParams");
                if (booleanValue) {
                    b2.put("reseller", "1");
                    com.paytm.network.listener.b bVar = dVar;
                    dVar.m.a(bVar, bVar, b2);
                } else {
                    com.paytm.network.listener.b bVar2 = dVar;
                    dVar.m.a(bVar2, bVar2, b2);
                }
                com.paytm.network.listener.b bVar3 = dVar;
                dVar.m.b(bVar3, bVar3, b2);
                dVar.m.c(bVar3, bVar3, b2);
                dVar.m.e(bVar3, bVar3, b2, a2);
                dVar.m.d(bVar3, bVar3, b2);
            }
            com.travel.train.b.a();
            com.travel.train.b.b().a("/trains", "Trains", (Context) getActivity());
        }
    }

    public void saveHomeMsgObject(CJRTrainMsgResponse cJRTrainMsgResponse) {
        if (cJRTrainMsgResponse != null && cJRTrainMsgResponse.getBody() != null && cJRTrainMsgResponse.getBody().getConfig() != null) {
            onHomePageApiRefreshed();
            w.a(getActivity().getApplicationContext()).a("home_page_object", new f().a((Object) cJRTrainMsgResponse.getBody().getConfig()), false);
        }
    }

    public void homeMsgRespoError(Boolean bool) {
        d dVar = this.mViewModel;
        HashMap<String, String> b2 = n.b(getContext());
        k.c(b2, H5Logger.HEADER);
        if (dVar.f27639a < dVar.f27640b) {
            dVar.f27639a++;
            new Handler().postDelayed(new d.a(dVar, b2), dVar.f27641c);
        }
    }

    public void onHomePageApiRefreshed() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            t tVar = this.mTrainHomeV2Fragment;
            tVar.a();
            tVar.b();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        d dVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 192) {
            this.mTrainHomeV2Fragment.onActivityResult(i2, i3, intent);
        } else if (intent != null && intent.hasExtra("trainFavoriteChange") && intent.getBooleanExtra("trainFavoriteChange", false) && (dVar = this.mViewModel) != null) {
            HashMap<String, String> b2 = n.b(getContext());
            k.c(b2, H5Logger.HEADER);
            a aVar = dVar.m;
            com.paytm.network.listener.b bVar = dVar;
            aVar.c(bVar, bVar, b2);
        }
    }

    /* access modifiers changed from: private */
    public void showSnackBar(CJRTrainBookingInformation cJRTrainBookingInformation) {
        if (cJRTrainBookingInformation != null && cJRTrainBookingInformation.getmTrainBookingStatus() != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification() != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification().size() > 0 && cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification().get(0) != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification().get(0).getmMessage() != null && !TextUtils.isEmpty(cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification().get(0).getmMessage())) {
            showSnackBarForBookingAndNotification(cJRTrainBookingInformation.getmTrainBookingStatus().getmHomeNotification().get(0).getmMessage());
        }
    }

    private void showSnackBarForBookingAndNotification(String str) {
        if (getActivity() != null) {
            int f2 = com.paytm.utility.b.f((Context) getActivity());
            this.snackbar = Snackbar.a((View) this.frameContainer, (CharSequence) str, -2).a((CharSequence) Payload.RESPONSE_OK, (View.OnClickListener) new View.OnClickListener() {
                public final void onClick(View view) {
                    SharedPreferences.Editor edit;
                    FJRTrainHomeFragment.this.snackbar.d();
                    boolean unused = FJRTrainHomeFragment.this.isNotificationRead = true;
                    if (FJRTrainHomeFragment.this.sharedpreferences != null && (edit = FJRTrainHomeFragment.this.sharedpreferences.edit()) != null) {
                        edit.putBoolean("notificationread", FJRTrainHomeFragment.this.isNotificationRead);
                        edit.apply();
                    }
                }
            }).d(getActivity().getResources().getColor(R.color.blue_dot));
            TextView textView = (TextView) this.snackbar.b().findViewById(com.google.android.material.R.id.snackbar_text);
            textView.setGravity(17);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.height = f2 * 4;
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(2);
            this.snackbar.c();
        }
    }

    private boolean loadNotificationSharedPreference() {
        if (getActivity() == null) {
            return false;
        }
        this.sharedPrefs = getActivity().getSharedPreferences("train_most_visited", 0);
        SharedPreferences sharedPreferences = this.sharedPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("notificationread", false);
        }
        return false;
    }
}
