package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.a.a.b;
import com.travel.train.fragment.ae;
import com.travel.train.j.n;
import com.travel.train.k.c;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainBookingInformation;
import com.travel.train.model.trainticket.CJRTrainQuickBookFavourites;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class AJRTrainSearchActivity extends CJRTrainBaseActivity {
    private View containerView;
    /* access modifiers changed from: private */
    public boolean isNotificationRead = false;
    private int mStatusCode = 0;
    private CJRTrainBookingInformation mTrainNotification = null;
    private CJRTrainQuickBookFavourites mTrainQuickBook = null;
    private CJRTrainSearchInput mTrainSearchInput = null;
    private CJRTrainSearchResults mTrainSearchResult = null;
    private c mViewModel = null;
    /* access modifiers changed from: private */
    public SharedPreferences sharedPrefs = null;
    /* access modifiers changed from: private */
    public Snackbar snackbar = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ls_search_trains_layout);
        getIntentData();
        initView();
        initMVVM();
        setFragment();
        showSnackBarNotification();
    }

    private void initView() {
        this.containerView = findViewById(R.id.container_layout);
        this.isNotificationRead = loadNotificationSharedPreference();
    }

    private void getIntentData() {
        Bundle bundleExtra = (getIntent() == null || !getIntent().hasExtra("train_home_bundle")) ? null : getIntent().getBundleExtra("train_home_bundle");
        if (bundleExtra != null) {
            if (bundleExtra.containsKey("intent_extra_notification")) {
                this.mTrainNotification = (CJRTrainBookingInformation) bundleExtra.getSerializable("intent_extra_notification");
            }
            if (bundleExtra != null) {
                if (bundleExtra.containsKey("train_search_status_code")) {
                    this.mStatusCode = bundleExtra.getInt("train_search_status_code");
                }
                if (bundleExtra.containsKey("intent_extra_train_search_input") && bundleExtra.getSerializable("intent_extra_train_search_input") != null) {
                    this.mTrainSearchInput = (CJRTrainSearchInput) bundleExtra.getSerializable("intent_extra_train_search_input");
                }
                if (bundleExtra.containsKey("intent_extra_TRAIN_search_load_data") && bundleExtra.getSerializable("intent_extra_TRAIN_search_load_data") != null) {
                    this.mTrainSearchResult = (CJRTrainSearchResults) bundleExtra.getSerializable("intent_extra_TRAIN_search_load_data");
                }
                if (bundleExtra.containsKey("intent_extra_train_fav") && bundleExtra.getSerializable("intent_extra_train_fav") != null) {
                    this.mTrainQuickBook = (CJRTrainQuickBookFavourites) bundleExtra.getSerializable("intent_extra_train_fav");
                }
            }
        }
        if (getIntent() != null && getIntent().hasExtra("extra_home_data") && getIntent().getSerializableExtra("extra_home_data") != null) {
            CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
            if (TextUtils.isEmpty(cJRItem.getURL()) && (cJRItem instanceof CJRHomePageItem)) {
                String deeplink = ((CJRHomePageItem) cJRItem).getDeeplink();
                if (!TextUtils.isEmpty(deeplink)) {
                    cJRItem.setUrl(deeplink);
                }
            }
            this.mTrainSearchInput = n.b((Context) this, n.e(cJRItem.getURL()));
            if (this.mTrainSearchInput == null) {
                startHomePage();
            }
        }
    }

    private void initMVVM() {
        g.a a2 = new g.a(g.b.BOOKING).a(a.a((b) new com.travel.train.a.a.a(this)));
        a2.f27667b = true;
        this.mViewModel = (c) am.a((FragmentActivity) this, (al.b) new g(a2)).a(c.class);
        c cVar = this.mViewModel;
        CJRTrainQuickBookFavourites cJRTrainQuickBookFavourites = this.mTrainQuickBook;
        HashMap<String, String> b2 = n.b((Context) this);
        k.c(b2, "headers");
        if (cJRTrainQuickBookFavourites == null) {
            k.c(b2, "headers");
            a aVar = cVar.r;
            if (aVar != null) {
                com.paytm.network.listener.b bVar = cVar;
                aVar.c(bVar, bVar, b2);
            }
        } else {
            cVar.o.setValue(cJRTrainQuickBookFavourites);
        }
        this.mViewModel.a(this.mTrainSearchInput);
        this.mViewModel.a(this.mStatusCode);
        this.mViewModel.a(this.mTrainSearchResult);
    }

    private void setFragment() {
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.fragment_container, ae.a(getIntent().getExtras()), ae.class.getSimpleName());
        a2.c();
    }

    public void onBackPressed() {
        com.travel.train.fragment.am amVar = (com.travel.train.fragment.am) getSupportFragmentManager().c(ae.class.getSimpleName());
        if (!(amVar != null ? amVar.onBackPressed() : false)) {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment c2 = getSupportFragmentManager().c(ae.class.getSimpleName());
        if (c2 != null) {
            c2.onActivityResult(i2, i3, intent);
        }
    }

    private void startHomePage() {
        if (isTaskRoot()) {
            com.travel.train.b.a();
            com.travel.train.b.b().a((Context) this, "paytmmp://trainticketv2", new Bundle());
            return;
        }
        onBackPressed();
    }

    private void showSnackBarNotification() {
        if (!this.isNotificationRead) {
            showSnackBar(this.mTrainNotification);
        }
    }

    private boolean loadNotificationSharedPreference() {
        this.sharedPrefs = getSharedPreferences("train_search_notification_shared", 0);
        SharedPreferences sharedPreferences = this.sharedPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("train_search_notification_key", false);
        }
        return false;
    }

    private void showSnackBar(CJRTrainBookingInformation cJRTrainBookingInformation) {
        if (cJRTrainBookingInformation != null && cJRTrainBookingInformation.getmTrainBookingStatus() != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification() != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification().size() > 0 && cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification().get(0) != null && cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification().get(0).getmMessage() != null && !TextUtils.isEmpty(cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification().get(0).getmMessage())) {
            showSnackBarForBookingAndNotification(cJRTrainBookingInformation.getmTrainBookingStatus().getmSearchNotification().get(0).getmMessage());
        }
    }

    private void showSnackBarForBookingAndNotification(String str) {
        int f2 = com.paytm.utility.b.f((Context) this);
        this.snackbar = Snackbar.a(this.containerView, (CharSequence) str, -2).a((CharSequence) Payload.RESPONSE_OK, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                SharedPreferences.Editor edit;
                AJRTrainSearchActivity.this.snackbar.d();
                boolean unused = AJRTrainSearchActivity.this.isNotificationRead = true;
                if (AJRTrainSearchActivity.this.sharedPrefs != null && (edit = AJRTrainSearchActivity.this.sharedPrefs.edit()) != null) {
                    edit.putBoolean("train_search_notification_key", AJRTrainSearchActivity.this.isNotificationRead);
                    edit.apply();
                }
            }
        }).d(getResources().getColor(R.color.blue_dot));
        TextView textView = (TextView) this.snackbar.b().findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setGravity(17);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.height = f2 * 4;
        textView.setLayoutParams(layoutParams);
        textView.setMaxLines(2);
        this.snackbar.c();
    }
}
