package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.fragment.w;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRTrainOrderSummaryNew extends CJRTrainBaseActivity {
    private String LOG_TAG = "AJRTrainOrderSummaryNew";
    private TextView actionBarTitle;
    private j fragmentManager;
    private String mEntryPoint;
    private boolean mHomeLaunchCalled = false;
    private CJRItem mItem;
    private String mOrderNo;
    private w trainOrderSummary;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_action_bar_layout);
        getIntentData();
        setActionBar(this.mOrderNo);
        setFragment();
        b.a();
        b.b().a("/trains/order-summary", "Trains", (Context) this);
    }

    private void setActionBar(String str) {
        setSupportActionBar((Toolbar) findViewById(R.id.base_toolbar));
        getSupportActionBar().c(false);
        ImageView imageView = (ImageView) findViewById(R.id.train_toolbar_back_arrow);
        this.actionBarTitle = (TextView) findViewById(R.id.train_toolbar_title);
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.train_order_summary);
        }
        setActionBarTitle(str);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainOrderSummaryNew.this.lambda$setActionBar$0$AJRTrainOrderSummaryNew(view);
            }
        });
    }

    public /* synthetic */ void lambda$setActionBar$0$AJRTrainOrderSummaryNew(View view) {
        onBackPressed();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        getIntentData();
        if (this.trainOrderSummary != null) {
            Bundle bundle = new Bundle();
            bundle.putString("order_id", this.mOrderNo);
            bundle.putSerializable(UpiConstants.FROM, this.mEntryPoint);
            CJRItem cJRItem = this.mItem;
            if (cJRItem != null) {
                bundle.putSerializable("extra_home_data", cJRItem);
            }
            w wVar = this.trainOrderSummary;
            wVar.setArguments(bundle);
            wVar.a();
            wVar.b();
            return;
        }
        setFragment();
    }

    public void setActionBarTitle(String str) {
        TextView textView = this.actionBarTitle;
        textView.setText(getString(R.string.bookin_id) + " - " + str);
    }

    private void getIntentData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(UpiConstants.FROM)) {
                this.mEntryPoint = getIntent().getStringExtra(UpiConstants.FROM);
            }
            if (getIntent().hasExtra("order_id")) {
                this.mOrderNo = getIntent().getStringExtra("order_id");
            }
            if (getIntent().hasExtra("order_id")) {
                this.mOrderNo = getIntent().getStringExtra("order_id");
            }
            if (getIntent().hasExtra("extra_home_data")) {
                this.mItem = (CJRItem) getIntent().getExtras().getSerializable("extra_home_data");
            }
            if (!TextUtils.isEmpty(this.mEntryPoint) && this.mEntryPoint.equalsIgnoreCase("Payment")) {
                sendGTMEvent();
            }
        }
    }

    private void setFragment() {
        removeProgressDialog();
        this.fragmentManager = getSupportFragmentManager();
        q a2 = this.fragmentManager.a();
        this.trainOrderSummary = new w();
        Bundle bundle = new Bundle();
        bundle.putString("order_id", this.mOrderNo);
        bundle.putSerializable(UpiConstants.FROM, this.mEntryPoint);
        CJRItem cJRItem = this.mItem;
        if (cJRItem != null) {
            bundle.putSerializable("extra_home_data", cJRItem);
        }
        this.trainOrderSummary.setArguments(bundle);
        a2.b(R.id.content_frame, this.trainOrderSummary, (String) null);
        a2.b();
    }

    public void onBackPressed() {
        if (TextUtils.isEmpty(this.mEntryPoint) || !this.mEntryPoint.equalsIgnoreCase("Payment")) {
            w wVar = this.trainOrderSummary;
            if (wVar != null && wVar.f27189a) {
                Intent intent = new Intent();
                intent.putExtra("trainFavoriteChange", true);
                setResult(-1, intent);
            }
        } else if (!this.mHomeLaunchCalled) {
            this.mHomeLaunchCalled = true;
            launchHome();
        }
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        w wVar = this.trainOrderSummary;
        if (wVar != null) {
            wVar.onActivityResult(i2, i3, intent);
        }
    }

    private void launchHome() {
        new CJRHomePageItem().setUrl(com.travel.train.j.w.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        if (!TextUtils.isEmpty(this.mEntryPoint) && this.mEntryPoint.equalsIgnoreCase("Payment")) {
            intent.putExtra("Reset_fast_farward", true);
        }
        b.a();
        b.b().a((Context) this, intent);
        finish();
    }

    private void sendGTMEvent() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this) != null ? com.paytm.utility.b.n((Context) this) : "");
            hashMap.put("event_category", "train_order_summary");
            hashMap.put("event_action", "order_summary_screen_load");
            hashMap.put("event_label", this.mOrderNo);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/order-summary");
            hashMap.put(d.cv, "train");
            b.a();
            b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }
}
