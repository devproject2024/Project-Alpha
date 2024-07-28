package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.fragment.FJRBusTicketFragment;
import com.travel.utils.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRBusTicketsHomePAge extends CJRActionBarBaseActivity {
    private final String TAG_BUS_FRAGMENT = "bus_fragment";
    FJRBusTicketFragment musTicketFragment;

    public void attachBaseContext(Context context) {
        q.a(context);
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) this);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        CJRItem cJRItem;
        super.onCreate(bundle);
        sendHomePageLoadedGTMEvent();
        this.mFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        String str = null;
        this.mFrameLayout.addView(getLayoutInflater().inflate(R.layout.pre_b_bus_base, (ViewGroup) null));
        setActionbarView();
        Intent intent = getIntent();
        if (intent != null) {
            cJRItem = (CJRItem) intent.getSerializableExtra("extra_home_data");
            if (intent.hasExtra("origin")) {
                str = intent.getStringExtra("origin");
            }
            bundle2 = (!intent.hasExtra("from_bus_retry") || !getIntent().getBooleanExtra("from_bus_retry", false)) ? intent.getExtras() : getIntent().getExtras();
        } else {
            bundle2 = null;
            cJRItem = null;
        }
        this.musTicketFragment = new FJRBusTicketFragment();
        Bundle bundle3 = new Bundle();
        if (cJRItem != null) {
            bundle3.putSerializable("extra_home_data", cJRItem);
        }
        if (str != null) {
            bundle3.putSerializable("origin", str);
        }
        bundle3.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        if (bundle2 != null) {
            bundle3.putAll(bundle2);
        }
        this.musTicketFragment.setArguments(bundle3);
        getSupportFragmentManager().a().a(R.id.bus_fragment_container, this.musTicketFragment, "bus_fragment").b();
        com.travel.bus.a.a();
        if (b.a(getApplicationContext(), com.travel.bus.a.b().d())) {
            showWrongSettingsDialog();
        }
    }

    private void sendHomePageLoadedGTMEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void setActionbarView() {
        if (this.mActionBar == null) {
            this.mActionBar = getSupportActionBar();
        }
        this.mActionBar.a(false);
        this.mActionBar.b(false);
        this.mActionBar.a(1.0f);
        this.mActionBar.a(R.layout.pre_b_action_bar_text_center);
        ((TextView) findViewById(R.id.travel_title_text_view)).setText(getResources().getString(R.string.bus_title_text));
        ImageView imageView = (ImageView) findViewById(R.id.toolbar_btn_back);
        imageView.setImageResource(R.drawable.bus_back_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusTicketsHomePAge.this.lambda$setActionbarView$0$AJRBusTicketsHomePAge(view);
            }
        });
    }

    public /* synthetic */ void lambda$setActionbarView$0$AJRBusTicketsHomePAge(View view) {
        onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        FJRBusTicketFragment fJRBusTicketFragment;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && (fJRBusTicketFragment = (FJRBusTicketFragment) getSupportFragmentManager().c("bus_fragment")) != null) {
            fJRBusTicketFragment.onActivityResult(i2, intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        sendBusHomeBackClickedGTMEvent();
    }

    private void sendBusHomeBackClickedGTMEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_home");
        hashMap.put("event_action", "back_clicked");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void showWrongSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.wrong_setting));
        builder.setMessage(getResources().getString(R.string.dont_keep_activities_error_message));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRBusTicketsHomePAge.this.lambda$showWrongSettingsDialog$1$AJRBusTicketsHomePAge(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), $$Lambda$AJRBusTicketsHomePAge$Un88_9jfLMdjEA9pFY3myOI700o.INSTANCE);
        builder.show();
    }

    public /* synthetic */ void lambda$showWrongSettingsDialog$1$AJRBusTicketsHomePAge(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        showDeveloperOptionsScreen();
    }

    private void showDeveloperOptionsScreen() {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent.setFlags(1073741824);
        startActivity(intent);
    }
}
