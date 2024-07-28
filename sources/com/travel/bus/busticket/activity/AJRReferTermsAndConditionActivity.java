package com.travel.bus.busticket.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRReferTermsAndConditionActivity extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public ActionBar f21960a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21961b;

    public void onCreate(Bundle bundle) {
        String[] split;
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_refer_ters_and_condition);
        String stringExtra = getIntent().getStringExtra("termsConditionText");
        this.f21961b = (TextView) findViewById(R.id.terms_condition_text);
        this.f21960a = getSupportActionBar();
        this.f21960a.a(false);
        setTitle(getResources().getString(R.string.hotel_t_n_c_right_part));
        setBackButtonEnabled(true);
        if (stringExtra != null && (split = stringExtra.split("<br>")) != null && split.length > 0) {
            List<String> asList = Arrays.asList(split);
            StringBuilder sb = new StringBuilder();
            for (String str : asList) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                    if (str.contains("<br>")) {
                        str = str.replaceAll("<br>", "");
                    }
                    sb.append(str);
                    sb.append("\n\n");
                }
            }
            this.f21961b.setText(sb.toString());
        }
    }

    public void onBackPressed() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "travel_referral");
        hashMap.put("event_label", "referrer_tnc_screen");
        hashMap.put("event_action", "back_button_clicked");
        hashMap.put("user_id", b.n((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Referrer Terms & conditions");
        hashMap.put("vertical_name", "travel");
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        super.onBackPressed();
    }
}
