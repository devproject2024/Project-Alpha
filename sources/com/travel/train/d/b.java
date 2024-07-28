package com.travel.train.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sendbird.android.constant.StringSet;
import com.travel.train.R;
import com.travel.train.j.k;
import com.travel.utils.q;
import easypay.manager.Constants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiContract;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class b extends h {
    private LinearLayout A;
    private InputMethodManager B;
    private String C = "EasypayTravelBrowserFragment";

    /* renamed from: a  reason: collision with root package name */
    public WebView f26596a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f26597b;

    /* renamed from: c  reason: collision with root package name */
    public a f26598c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<Map<String, String>> f26599d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Map<String, String>> f26600e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences.Editor f26601f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public View f26602g;

    /* renamed from: h  reason: collision with root package name */
    TextView f26603h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f26604i;
    RoboButton j;
    RoboButton k;
    LinearLayout l;
    boolean m;
    /* access modifiers changed from: package-private */
    public String n;
    boolean o = false;
    public d p;
    BroadcastReceiver q = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            b.this.e();
            a.a();
        }
    };
    /* access modifiers changed from: private */
    public String r = "";
    /* access modifiers changed from: private */
    public SharedPreferences s;
    private SharedPreferences t;
    private SharedPreferences.Editor u;
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public String w;
    private int x = 0;
    private RoboButton y;
    private TextView z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z2) {
    }

    public b(boolean z2) {
        this.o = z2;
    }

    public b() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        q.a(context);
    }

    public void onResume() {
        super.onResume();
        q.a(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.a(getActivity());
        View inflate = layoutInflater.inflate(R.layout.pre_t_easypay_travel_browser_fragment, viewGroup, false);
        if (this.o) {
            inflate = layoutInflater.inflate(R.layout.pre_t_easypay_travel_browser_fragment_new, viewGroup, false);
        }
        this.f26597b = getActivity();
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Activity activity = this.f26597b;
        if (activity != null && !activity.isFinishing()) {
            if (getArguments() != null) {
                this.m = getArguments().getBoolean("enable-travel-helper", false);
            }
            this.f26596a = (WebView) this.f26597b.findViewById(R.id.webView1);
            this.l = (LinearLayout) this.f26597b.findViewById(R.id.travelHelper_upper_view);
            this.f26603h = (TextView) this.f26597b.findViewById(R.id.leftTravelHelperView);
            this.f26604i = (TextView) this.f26597b.findViewById(R.id.centerTravelHelperView);
            this.f26602g = this.f26597b.findViewById(R.id.overlay_webview);
            if (this.o) {
                this.y = (RoboButton) this.f26597b.findViewById(R.id.rightTravelHelperView);
                this.A = (LinearLayout) this.f26597b.findViewById(R.id.travelHelper_lower_view);
                this.j = (RoboButton) this.f26597b.findViewById(R.id.submit_btn_view);
                this.k = (RoboButton) this.f26597b.findViewById(R.id.submit_btn_view2);
                this.j.setSelected(true);
                this.k.setSelected(true);
                this.j.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        b.this.f26596a.loadUrl("javascript:document.getElementById('loginbuttonw').click()");
                    }
                });
                this.k.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        b.this.f26596a.loadUrl("javascript:document.getElementById('loginbuttonw').click()");
                    }
                });
                this.y.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) b.this.f26597b);
                        Intent intent = new Intent();
                        intent.setAction("reset-password-action");
                        a2.a(intent);
                    }
                });
            } else {
                this.z = (TextView) this.f26597b.findViewById(R.id.rightTravelHelperView);
                this.z.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) b.this.f26597b);
                        Intent intent = new Intent();
                        intent.setAction("reset-password-action");
                        a2.a(intent);
                    }
                });
            }
            if (this.m) {
                this.l.setVisibility(0);
                if (this.o) {
                    this.A.setVisibility(0);
                }
            }
            if (this.o) {
                this.B = (InputMethodManager) this.f26597b.getSystemService("input_method");
                k.a($$Lambda$b$g8FkhCYR9vTQJEsLYBVUhvQtM.INSTANCE);
                k.a(this.f26597b, new k.a() {
                    public final void onToggleSoftKeyboard(boolean z) {
                        b.this.a(z);
                    }
                });
            }
            this.f26604i.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (TextUtils.isEmpty(b.this.n) || !b.this.n.equalsIgnoreCase(b.this.getString(R.string.password_text))) {
                        String charSequence = b.this.f26604i.getText().toString();
                        if (TextUtils.isEmpty(charSequence)) {
                            return;
                        }
                        if (charSequence.equalsIgnoreCase(b.this.getString(R.string.easypay_show_password))) {
                            b.this.b();
                            b.this.f26604i.setText(R.string.easypay_hide_password);
                        } else if (charSequence.equalsIgnoreCase(b.this.getString(R.string.easypay_hide_password))) {
                            b.this.c();
                            b.this.f26604i.setText(R.string.easypay_show_password);
                        }
                    }
                }
            });
            this.f26602g.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.f26602g.setVisibility(8);
                    return false;
                }
            });
            this.f26596a.addJavascriptInterface(this, StringSet.Android);
            this.s = this.f26597b.getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0);
            this.f26601f = this.s.edit();
            this.t = this.f26597b.getSharedPreferences("com.paytm.easypay.EVENTS_FILE", 0);
            this.u = this.t.edit();
            e();
            this.f26597b.registerReceiver(this.q, new IntentFilter("com.drc.paytm_example.EASYPAY_CONFIG_DOWNLOADED"));
            this.v = Settings.Secure.getString(this.f26597b.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            this.w = Build.MANUFACTURER + "-" + Build.MODEL + "-" + Build.VERSION.RELEASE;
            a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2) {
        if (this.m) {
            if (z2) {
                this.k.setVisibility(8);
                this.y.setVisibility(8);
                this.l.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
            this.k.setVisibility(0);
            this.y.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public final void a() {
        InputMethodManager inputMethodManager = this.B;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 2);
            if (this.f26597b.getCurrentFocus() != null) {
                this.B.hideSoftInputFromWindow(this.f26597b.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        TextView textView = this.f26603h;
        if (textView == null) {
            return;
        }
        if (!TextUtils.isEmpty(textView.getText().toString())) {
            this.f26603h.setText(this.n);
        } else {
            this.f26603h.setHint("Password");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        TextView textView = this.f26603h;
        if (textView != null) {
            this.n = textView.getText().toString();
            if (!TextUtils.isEmpty(this.n)) {
                int length = this.n.length();
                String str = "";
                while (true) {
                    int i2 = length - 1;
                    if (length > 0) {
                        str = str + "*";
                        length = i2;
                    } else {
                        this.f26603h.setText(str);
                        return;
                    }
                }
            } else {
                this.f26603h.setHint("Password");
            }
        }
    }

    public final void a(int i2, final String str) {
        final int i3;
        View findViewById = this.f26597b.findViewById(i2);
        if (findViewById != null && (findViewById instanceof TextView) && i2 == R.id.leftTravelHelperView) {
            if (!TextUtils.isEmpty(str)) {
                if (this.o) {
                    i3 = R.color.color_updated_506d85;
                } else {
                    i3 = R.color.white;
                }
                this.f26597b.runOnUiThread(new Runnable() {
                    public final void run() {
                        b bVar = b.this;
                        int i2 = i3;
                        String str = str;
                        bVar.f26603h.setTextColor(androidx.core.content.b.c(bVar.f26597b, i2));
                        bVar.f26603h.setText(str);
                        if (!TextUtils.isEmpty(str) && bVar.o) {
                            bVar.j.setSelected(true);
                            bVar.k.setSelected(true);
                        }
                        String charSequence = bVar.f26604i.getText().toString();
                        boolean z = false;
                        if (!TextUtils.isEmpty(charSequence)) {
                            if (charSequence.equalsIgnoreCase(bVar.getString(R.string.easypay_show_password))) {
                                z = true;
                            } else {
                                boolean equalsIgnoreCase = charSequence.equalsIgnoreCase(bVar.getString(R.string.easypay_hide_password));
                            }
                        }
                        if (z) {
                            bVar.c();
                            return;
                        }
                        bVar.n = str;
                        bVar.b();
                    }
                });
                return;
            }
            this.f26597b.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.d();
                }
            });
        }
    }

    public final void d() {
        if (this.o) {
            this.f26603h.setHint(getResources().getString(R.string.password_text));
            this.f26603h.setText("");
            this.f26604i.setText(getString(R.string.easypay_show_password));
        } else {
            this.f26603h.setText(getResources().getString(R.string.password_text));
            this.f26603h.setTextColor(androidx.core.content.b.c(getActivity(), R.color.black));
            this.f26604i.setText(getString(R.string.easypay_hide_password));
        }
        this.n = "";
    }

    public class a extends AlertDialog {
        public final void show() {
            super.show();
            setContentView(R.layout.progress_dialog);
        }
    }

    public final void e() {
        try {
            this.f26599d = a("rules");
            this.f26600e = a("features");
            Long valueOf = Long.valueOf(Long.parseLong((String) a(Constants.EASY_PAY_CONFIG_PREF_KEY).get(0).get("ttl")));
            SharedPreferences.Editor edit = this.f26597b.getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0).edit();
            edit.putLong("easypay_configuration_ttl", valueOf.longValue());
            edit.apply();
        } catch (Exception e2) {
            a.a();
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        Toast.makeText(this.f26597b, str, 0).show();
    }

    @JavascriptInterface
    public void showLog(String str) {
        "logged - ".concat(String.valueOf(str));
        a.a();
    }

    @JavascriptInterface
    public void logError(String str) {
        "found Error in rule id - ".concat(String.valueOf(str));
        a.a();
        this.r = str;
        String str2 = "rule_" + str + "error_date";
        int date = Calendar.getInstance().getTime().getDate();
        if (this.s.getInt(str2, 0) != date) {
            this.f26601f.putInt(str2, date);
            this.f26601f.apply();
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        String string = b.this.s.getString("merchant_mid", "");
                        new OkHttpClient().newCall(new Request.Builder().url(b.this.getString(R.string.easypay_error_endpoint) + "?user=" + b.this.v + "&mid=" + string + "&device=" + b.this.w + "&ruleid=" + b.this.r).build()).execute();
                    } catch (Exception unused) {
                    }
                }
            }).start();
        }
    }

    @JavascriptInterface
    public void logEvent(String str, String str2) {
        StringBuilder sb = new StringBuilder("logging event - ");
        sb.append(str);
        sb.append(" rule id - ");
        sb.append(str2);
        a.a();
        String str3 = str2 + "_" + str;
        this.u.putInt(str3, this.t.getInt(str3, 0) + 1);
        this.u.commit();
    }

    @JavascriptInterface
    public void logData(String str, String str2) {
        this.f26601f.putString(str, str2);
        this.f26601f.apply();
        StringBuilder sb = new StringBuilder("logging data - ");
        sb.append(str);
        sb.append(" - ");
        sb.append(str2);
        a.a();
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.easypay.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.f26597b.sendBroadcast(intent);
    }

    @JavascriptInterface
    public void logTempData(String str) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.b(str);
        }
    }

    public final void a(int i2, Boolean bool) {
        View findViewById = this.f26597b.findViewById(i2);
        int i3 = bool.booleanValue() ? 0 : 8;
        if (findViewById.getVisibility() != i3) {
            if (bool.booleanValue()) {
                this.f26602g.setVisibility(0);
                findViewById.setVisibility(i3);
            }
            new DecelerateInterpolator();
            bool.booleanValue();
            int i4 = 1;
            if (!bool.booleanValue() && this.x > 1) {
                findViewById.setVisibility(i3);
            }
            int i5 = this.x;
            if (!bool.booleanValue()) {
                i4 = -1;
            }
            this.x = i5 + i4;
            if (this.x < 0) {
                this.x = 0;
            }
        }
    }

    private ArrayList<Map<String, String>> a(String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(getActivity().getApplicationContext().getAssets().open("bank_ids")));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(str)) {
                    return a(jsonReader);
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            ArrayList<Map<String, String>> a2 = a(jsonReader);
            jsonReader.close();
            return a2;
        } finally {
            jsonReader.close();
        }
    }

    private static ArrayList<Map<String, String>> a(JsonReader jsonReader) throws IOException {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(b(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static Map<String, String> b(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            hashMap.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        return hashMap;
    }

    public void onDestroy() {
        BroadcastReceiver broadcastReceiver;
        d dVar = this.p;
        if (dVar != null) {
            try {
                if (!(dVar.f26625a == null || dVar.f26632h == null)) {
                    dVar.f26625a.unregisterReceiver(dVar.f26632h);
                }
            } catch (Exception e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
        Activity activity = this.f26597b;
        if (!(activity == null || (broadcastReceiver = this.q) == null)) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        q.a(getActivity());
    }
}
