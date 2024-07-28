package net.one97.paytm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRNotificationItem;
import net.one97.paytm.common.entity.CJRNotificationSettings;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRNotificationSettingsWebview extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private Resources f51382a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f51383b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f51384c;

    /* renamed from: d  reason: collision with root package name */
    private String f51385d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f51386e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f51387f = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.order_details_layout, (ViewGroup) null));
        o();
        p();
        this.f51382a = getResources();
        setTitle(getResources().getString(R.string.notification_settings));
        this.f51385d = getResources().getString(R.string.notif_webview_push_notifications);
        this.f51386e = getResources().getString(R.string.notif_webview_sms);
        this.f51387f = getResources().getString(R.string.notif_webview_email);
        this.f51383b = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        r();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f51383b.setVisibility(8);
        if (iJRPaytmDataModel instanceof CJRNotificationSettings) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lyt_settings_container);
            linearLayout.removeAllViews();
            Iterator<CJRNotificationItem> it2 = ((CJRNotificationSettings) iJRPaytmDataModel).getNotificationItems().iterator();
            while (it2.hasNext()) {
                CJRNotificationItem next = it2.next();
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_notification_type, (ViewGroup) null, false);
                RoboTextView roboTextView = (RoboTextView) linearLayout2.findViewById(R.id.display_name);
                if (next.getDisplayName() != null && next.getDisplayName().trim().length() > 0) {
                    roboTextView.setText(next.getDisplayName());
                }
                RoboTextView roboTextView2 = (RoboTextView) linearLayout2.findViewById(R.id.description);
                if (next.getDescription1() != null && next.getDescription1().trim().length() > 0) {
                    roboTextView2.setText(next.getDescription1());
                }
                if (next.getSettings().containsKey(SDKConstants.PUSH_FROM_PUSH)) {
                    String str = this.f51385d;
                    if (b.d() > 11) {
                        a(next, linearLayout2, str);
                    } else {
                        b(next, linearLayout2, str);
                    }
                }
                if (next.getSettings().containsKey("sms")) {
                    String str2 = this.f51386e;
                    if (b.d() > 11) {
                        a(next, linearLayout2, str2);
                    } else {
                        b(next, linearLayout2, str2);
                    }
                }
                if (next.getSettings().containsKey(AppConstants.KEY_EMAIL)) {
                    String str3 = this.f51387f;
                    if (b.d() > 11) {
                        a(next, linearLayout2, str3);
                    } else {
                        b(next, linearLayout2, str3);
                    }
                }
                linearLayout.addView(linearLayout2);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            this.f51383b.setVisibility(8);
            if (this.f51384c) {
                this.f51384c = false;
                b();
            }
            if (networkCustomError == null) {
                return;
            }
            if (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401) {
                String name = getClass().getName();
                new NetworkCustomError();
                r.a((Activity) this, name, (Bundle) null);
            } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    return;
                }
                b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
            }
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        k();
        i();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    private void a(final CJRNotificationItem cJRNotificationItem, LinearLayout linearLayout, final String str) {
        LayoutInflater from = LayoutInflater.from(this);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.switch_container);
        String str2 = null;
        RelativeLayout relativeLayout = (RelativeLayout) from.inflate(R.layout.lyt_notifcation_switch, (ViewGroup) null, false);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_filter_title);
        b.a(textView);
        textView.setText(str);
        Switch switchR = (Switch) relativeLayout.findViewById(R.id.btn_toggle);
        if (str.equalsIgnoreCase(this.f51385d)) {
            str2 = SDKConstants.PUSH_FROM_PUSH;
        } else if (str.equalsIgnoreCase(this.f51386e)) {
            str2 = "sms";
        } else if (str.equalsIgnoreCase(this.f51387f)) {
            str2 = AppConstants.KEY_EMAIL;
        }
        switchR.setTextOn(getResources().getString(R.string.toggle_btn_on));
        switchR.setTextOff(getResources().getString(R.string.toggle_btn_off));
        if (str2 != null && str2.trim().length() > 0) {
            if (!cJRNotificationItem.getSettings().containsKey(str2) || !cJRNotificationItem.getSettings().get(str2).equalsIgnoreCase("1")) {
                switchR.setChecked(false);
            } else {
                switchR.setChecked(true);
            }
        }
        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AJRNotificationSettingsWebview.a(AJRNotificationSettingsWebview.this, z, str, cJRNotificationItem);
            }
        });
        linearLayout2.addView(relativeLayout);
    }

    private void b(final CJRNotificationItem cJRNotificationItem, LinearLayout linearLayout, final String str) {
        LayoutInflater from = LayoutInflater.from(this);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.switch_container);
        String str2 = null;
        RelativeLayout relativeLayout = (RelativeLayout) from.inflate(R.layout.layout_notification_checkbox, (ViewGroup) null, false);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_filter_title);
        b.a(textView);
        textView.setText(str);
        CheckBox checkBox = (CheckBox) relativeLayout.findViewById(R.id.btn_toggle);
        if (str.equalsIgnoreCase(this.f51385d)) {
            str2 = SDKConstants.PUSH_FROM_PUSH;
        } else if (str.equalsIgnoreCase(this.f51386e)) {
            str2 = "sms";
        } else if (str.equalsIgnoreCase(this.f51387f)) {
            str2 = AppConstants.KEY_EMAIL;
        }
        if (str2 != null && str2.trim().length() > 0) {
            if (!cJRNotificationItem.getSettings().containsKey(str2) || !cJRNotificationItem.getSettings().get(str2).equalsIgnoreCase("1")) {
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AJRNotificationSettingsWebview.a(AJRNotificationSettingsWebview.this, z, str, cJRNotificationItem);
            }
        });
        linearLayout2.addView(relativeLayout);
    }

    public final void a() {
        b();
    }

    private void b() {
        c.a();
        String a2 = c.a("pushNotificationSettingsNative", (String) null);
        a.c();
        if (URLUtil.isValidUrl(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a.q(this));
            com.paytm.network.a a3 = d.a(this, a2, this, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRNotificationSettings(), a.c.HOME, a.b.SILENT);
            if (com.paytm.utility.a.m(this)) {
                this.f51383b.setVisibility(0);
                a3.a();
                return;
            }
            r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    static /* synthetic */ void a(AJRNotificationSettingsWebview aJRNotificationSettingsWebview, boolean z, String str, CJRNotificationItem cJRNotificationItem) {
        aJRNotificationSettingsWebview.f51384c = true;
        c.a();
        String a2 = c.a("pushNotificationSettingsNative", (String) null);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        boolean equalsIgnoreCase = str.equalsIgnoreCase(aJRNotificationSettingsWebview.f51385d);
        String str2 = SDKConstants.PUSH_FROM_PUSH;
        if (!equalsIgnoreCase) {
            if (str.equalsIgnoreCase(aJRNotificationSettingsWebview.f51386e)) {
                str2 = "sms";
            } else if (str.equalsIgnoreCase(aJRNotificationSettingsWebview.f51387f)) {
                str2 = AppConstants.KEY_EMAIL;
            }
        }
        if (z) {
            try {
                jSONObject3.put(str2, 1);
            } catch (JSONException e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else {
            jSONObject3.put(str2, 0);
        }
        jSONObject2.put(cJRNotificationItem.getCategory(), jSONObject3);
        jSONObject.put("preferences", jSONObject2);
        com.paytm.utility.a.c();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(aJRNotificationSettingsWebview));
        com.paytm.network.a a3 = d.a(aJRNotificationSettingsWebview, a2, aJRNotificationSettingsWebview, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRNotificationSettings(), a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(aJRNotificationSettingsWebview)) {
            a3.a();
        } else {
            r.a(a3, (Context) aJRNotificationSettingsWebview, (DialogInterface.OnCancelListener) aJRNotificationSettingsWebview);
        }
    }
}
