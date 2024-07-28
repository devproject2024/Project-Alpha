package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarActivity;
import androidx.core.h.u;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.lang.Thread;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetCredential extends ActionBarActivity {
    /* access modifiers changed from: private */
    public static final String TAG = GetCredential.class.getSimpleName();
    private c clContext;
    private JSONObject configuration = null;
    /* access modifiers changed from: private */
    public final Context context = this;
    private JSONObject controls = null;
    private JSONArray credAllowed = null;
    /* access modifiers changed from: private */
    public ae currentFragment = null;
    private Thread.UncaughtExceptionHandler defaultHandler = null;
    /* access modifiers changed from: private */
    public boolean doubleBackToExitPressedOnce = false;
    private v inputAnalyzer;
    private String languagePref = CLConstants.DEFAULT_LANGUAGE_PREFERENCE;
    private int mActivityHeight;
    private ImageView mTransactionBarArrow;
    /* access modifiers changed from: private */
    public View mTransactionDetailScroller;
    /* access modifiers changed from: private */
    public View mTransactionDetailSpace;
    /* access modifiers changed from: private */
    public TransitionDrawable mTransitionDrawable;
    /* access modifiers changed from: private */
    public int numDigitsOfOTP = 0;
    private JSONArray payInfoArray = new JSONArray();
    private JSONObject salt = null;
    private u smsReceiver;

    private void appInit() {
        this.inputAnalyzer = new v();
        try {
            this.clContext = new c(getApplicationContext(), this.inputAnalyzer, this);
            this.inputAnalyzer.a(getIntent().getExtras(), this);
        } catch (d e2) {
            e2.a();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void goBack() {
        Bundle bundle = new Bundle();
        bundle.putString("error", "USER_ABORTED");
        getCLContext().d().send(0, bundle);
        finish();
    }

    private boolean isATMPinFlow() {
        String[] strArr = {"ATMPIN", "SMS|EMAIL|HOTP|TOTP", "MPIN"};
        String[] strArr2 = new String[3];
        JSONArray jSONArray = this.credAllowed;
        if (jSONArray != null && jSONArray.length() == 3) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 < this.credAllowed.length(); i2++) {
                try {
                    strArr2[i2] = ((JSONObject) this.credAllowed.get(i2)).optString(CLConstants.FIELD_SUBTYPE, "");
                    if (strArr2[i2].matches(strArr[0])) {
                        z = true;
                    }
                    if (strArr2[i2].matches(strArr[1])) {
                        z2 = true;
                    }
                    if (strArr2[i2].matches(strArr[2])) {
                        z3 = true;
                    }
                } catch (Exception e2) {
                    ad.a(TAG, e2);
                }
            }
            return z && z2 && z3;
        }
    }

    /* access modifiers changed from: private */
    public boolean isTransactionDetailsExpanded() {
        return this.mTransactionDetailScroller.getVisibility() == 0;
    }

    private int pix(float f2) {
        return (int) (f2 * ((float) (getResources().getDisplayMetrics().densityDpi / 160)));
    }

    private void readArguments() {
        String string;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                String string2 = extras.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                if (string2 != null) {
                    this.configuration = new JSONObject(string2);
                }
                String string3 = extras.getString(CLConstants.INPUT_KEY_CONTROLS);
                if (string3 != null) {
                    this.controls = new JSONObject(string3);
                    if (!(this.controls == null || (string = this.controls.getString(CLConstants.FIELD_CRED_ALLOWED)) == null)) {
                        this.credAllowed = new JSONArray(string);
                    }
                }
                String string4 = extras.getString(CLConstants.INPUT_KEY_SALT);
                if (string4 != null) {
                    this.salt = new JSONObject(string4);
                }
                String string5 = extras.getString(CLConstants.INPUT_KEY_PAY_INFO);
                if (string5 != null) {
                    this.payInfoArray = new JSONArray(string5);
                }
                String string6 = extras.getString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE);
                if (string6 != null) {
                    this.languagePref = string6;
                    String[] split = this.languagePref.split("_");
                    Locale locale = new Locale(this.languagePref);
                    if (split.length == 2) {
                        locale = new Locale(split[0], split[1]);
                    }
                    Locale.setDefault(locale);
                    Configuration configuration2 = new Configuration();
                    configuration2.locale = locale;
                    getBaseContext().getResources().updateConfiguration(configuration2, getBaseContext().getResources().getDisplayMetrics());
                }
            } catch (Exception e2) {
                ad.a(TAG, e2);
            }
        }
    }

    private void registerSMSReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        try {
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            registerReceiver(this.smsReceiver, intentFilter);
        } catch (Throwable unused) {
            ad.a(TAG, "Failed to register SMS broadcast receiver (Ignoring)");
        }
    }

    private void setupKeyboard() {
        Keypad keypad = (Keypad) findViewById(R.id.fragmentTelKeyboard);
        if (keypad != null) {
            keypad.setOnKeyPressCallback(new o(this));
        }
    }

    /* access modifiers changed from: private */
    public void toggleTransactionDetails(boolean z) {
        float f2 = 0.0f;
        ImageView imageView = this.mTransactionBarArrow;
        if (z) {
            rotateView(0.0f, 180.0f, 300, imageView);
        } else {
            rotateView(180.0f, 0.0f, 300, imageView);
        }
        if (Build.VERSION.SDK_INT > 14) {
            int height = this.mTransactionDetailScroller.getHeight();
            if (height == 0) {
                height = this.mActivityHeight;
            }
            this.mTransactionDetailScroller.clearAnimation();
            ViewPropertyAnimator y = this.mTransactionDetailScroller.animate().y(z ? 0.0f : -1.0f * ((float) height));
            if (z) {
                f2 = 1.0f;
            }
            y.alpha(f2).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new t(this, z, height));
            return;
        }
        this.mTransactionDetailScroller.setVisibility(z ? 0 : 8);
    }

    private void unregisterSMSReceiver() {
        try {
            if (this.smsReceiver != null) {
                unregisterReceiver(this.smsReceiver);
                this.smsReceiver = null;
            }
        } catch (Throwable unused) {
            ad.a(TAG, "Failed to unregister SMS receiver (Ignoring)");
        }
    }

    public boolean checkSMSReadPermission() {
        return checkCallingOrSelfPermission("android.permission.READ_SMS") == 0;
    }

    public boolean checkSMSReceivePermission() {
        return checkCallingOrSelfPermission("android.permission.RECEIVE_SMS") == 0;
    }

    public c getCLContext() {
        return this.clContext;
    }

    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            Bundle bundle = new Bundle();
            bundle.putString("error", "USER_ABORTED");
            getCLContext().d().send(0, bundle);
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.back_button_exit_message), 0).show();
        new Handler().postDelayed(new n(this), 2000);
    }

    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.defaultHandler = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new k());
        readArguments();
        setContentView(R.layout.activity_pin_activity_component);
        setupKeyboard();
        appInit();
        renderTransactionBar();
        renderTransactionDetails();
        loadFragment(isATMPinFlow() ? new a() : new ao(), getIntent().getExtras(), false);
        TextView textView = (TextView) findViewById(R.id.go_back);
        if (textView != null) {
            textView.setOnClickListener(new m(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Thread.currentThread().setUncaughtExceptionHandler(this.defaultHandler);
    }

    public void onPause() {
        super.onPause();
        unregisterSMSReceiver();
    }

    public void onResume() {
        super.onResume();
        if (checkSMSReceivePermission()) {
            this.smsReceiver = new u(this, (m) null);
            registerSMSReceiver();
        }
    }

    /* access modifiers changed from: package-private */
    public void renderTransactionBar() {
        String str;
        int i2;
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.configuration;
        String optString = jSONObject2 != null ? jSONObject2.optString(CLConstants.FIELD_PAYER_BANK_NAME) : "";
        JSONObject jSONObject3 = this.salt;
        if (jSONObject3 == null) {
            new d(this, "l12", CLConstants.ERROR_MSG_SALT_MISSING);
            return;
        }
        String optString2 = jSONObject3.optString("txnAmount");
        int i3 = 0;
        while (i3 < this.payInfoArray.length()) {
            try {
                String str2 = "value";
                if (((JSONObject) this.payInfoArray.get(i3)).optString("name", "").equals("payeeName")) {
                    jSONObject = (JSONObject) this.payInfoArray.get(i3);
                } else if (((JSONObject) this.payInfoArray.get(i3)).optString("name", "").equals("account")) {
                    jSONObject = (JSONObject) this.payInfoArray.get(i3);
                } else if (((JSONObject) this.payInfoArray.get(i3)).optString("name", "").equals("mobileNumber")) {
                    jSONObject = (JSONObject) this.payInfoArray.get(i3);
                    str2 = CLConstants.LABEL_MOBILE_NUMBER;
                } else {
                    i3++;
                }
                str = jSONObject.optString(str2, "");
                break;
            } catch (Exception e2) {
                ad.a(TAG, e2);
            }
        }
        str = "";
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.transaction_bar_root);
        TextView textView = (TextView) findViewById(R.id.tv_acc_or_payee);
        TextView textView2 = (TextView) findViewById(R.id.transaction_bar_info);
        this.mTransactionBarArrow = (ImageView) findViewById(R.id.transaction_bar_arrow);
        ((TextView) findViewById(R.id.transaction_bar_title)).setText(str);
        if (!optString.equals("")) {
            textView.setText(optString);
        }
        if (!optString2.equals("")) {
            textView2.setText("₹ ".concat(String.valueOf(optString2)));
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
            i2 = point.y;
        } else {
            i2 = defaultDisplay.getHeight();
        }
        this.mActivityHeight = i2;
        linearLayout.setOnClickListener(new p(this));
        this.mTransactionDetailScroller = findViewById(R.id.transaction_details_scroller);
        this.mTransactionDetailSpace = findViewById(R.id.transaction_details_expanded_space);
        this.mTransactionDetailScroller.setOnTouchListener(new q(this));
        View view = this.mTransactionDetailSpace;
        if (view != null) {
            view.setOnTouchListener(new s(this));
        }
        this.mTransitionDrawable = (TransitionDrawable) findViewById(R.id.transaction_info_root).getBackground();
        this.mTransitionDrawable.setCrossFadeEnabled(true);
    }

    /* access modifiers changed from: package-private */
    public void renderTransactionDetails() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.transaction_details_root);
        for (int i2 = 0; i2 < this.payInfoArray.length(); i2++) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.layout_transaction_details_item, linearLayout, false);
            JSONObject optJSONObject = this.payInfoArray.optJSONObject(i2);
            ((TextView) viewGroup.findViewById(R.id.transaction_details_item_name)).setText(optJSONObject.optString("name").toUpperCase());
            ((TextView) viewGroup.findViewById(R.id.transaction_details_item_value)).setText(optJSONObject.optString("value"));
            linearLayout.addView(viewGroup);
        }
        View view = new View(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, pix(3.0f)));
        view.setBackgroundColor(-16777216);
        u.c(view, 0.33f);
        linearLayout.addView(view);
    }

    public void rotateView(float f2, float f3, int i2, View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(f2, f3, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration((long) i2);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    public void setCurrentFragment(ae aeVar) {
        this.currentFragment = aeVar;
    }

    public void setNumDigitsOfOTP(int i2) {
        this.numDigitsOfOTP = i2;
    }

    public void loadFragment(ae aeVar, Bundle bundle, boolean z) {
        try {
            j supportFragmentManager = getSupportFragmentManager();
            if (bundle != null) {
                aeVar.setArguments(bundle);
            }
            q a2 = supportFragmentManager.a();
            a2.b(R.id.main_inner_layout, aeVar, (String) null);
            if (z) {
                a2.a(aeVar.getClass().getSimpleName());
            }
            a2.c();
            setCurrentFragment(aeVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
