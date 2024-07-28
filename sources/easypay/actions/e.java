package easypay.actions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.utils.AssistLogs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f46091b;

    /* renamed from: a  reason: collision with root package name */
    boolean f46092a = false;

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f46093c;

    /* renamed from: d  reason: collision with root package name */
    private int f46094d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46095e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f46096f = 0;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f46091b == null) {
                e eVar2 = new e();
                f46091b = eVar2;
                eVar2.f46092a = false;
                f46091b.f46095e = false;
            }
            eVar = f46091b;
        }
        return eVar;
    }

    public final void c() {
        AssistLogs.printLog("OTP read flow started", this);
        this.f46096f = System.currentTimeMillis();
        if (easypay.utils.b.b()) {
            AssistLogs.printLog("SMS permission is given by user", this);
            easypay.utils.b.a((Activity) AssistMerchantDetails.getInstance().getActivity());
            e();
            return;
        }
        f();
    }

    private void e() {
        AssistLogs.printLog("Normal OTP read flow started", this);
        if (this.f46093c == null) {
            this.f46093c = new a();
        }
        if (!this.f46095e) {
            AssistLogs.printLog("SMS Broadcast Receiver registered", this);
            IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            a(this.f46093c, intentFilter);
        }
        a(AssistMerchantDetails.getInstance().getContext());
    }

    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            try {
                AssistLogs.printLog("Otp message received", this);
                if (intent != null && intent.getAction() != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") && Build.VERSION.SDK_INT >= 19) {
                    String str = "";
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                        str = str + smsMessage.getMessageBody();
                        AssistLogs.printLog("Calling checkSms from broadcast receiver", this);
                        e.this.a(str, displayOriginatingAddress, true);
                    }
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    public final void a(String str, String str2, boolean z) {
        this.f46094d++;
        AssistLogs.printLog("Check sms called: " + this.f46094d + " time From:" + str2, this);
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(0);
            AssistLogs.printLog("OTP found: ".concat(String.valueOf(group)), this);
            this.f46092a = true;
            if (AssistMerchantDetails.getInstance().getListener() != null) {
                AssistMerchantDetails.getInstance().getListener().smsReceivedCallback(group, true);
            }
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_SMS_DETECTED, "true");
            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_SMS_DETECTED, "true");
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SMS_READ, "true");
            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SMS_READ, "true");
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EXTRA_SENDER_INFO, str2);
            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EXTRA_SENDER_INFO, str2);
            if (!z) {
                d();
                f();
                return;
            }
            return;
        }
        this.f46092a = false;
        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SMS_READ, "false");
        AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SMS_READ, "false");
    }

    private void f() {
        AssistLogs.printLog("NO SMS permission, starting SMS Consent if block : isBroadcastRegistered:" + this.f46095e, this);
        if (AssistMerchantDetails.getInstance().isUseSmsConsent()) {
            AssistLogs.printLog("NO SMS permission, starting SMS Consent", this);
            IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
            intentFilter.setPriority(999);
            AssistLogs.printLog("starting SMS Consent:Activity Instance" + AssistMerchantDetails.getInstance().getActivity().toString(), this);
            com.google.android.gms.auth.api.phone.a.a(AssistMerchantDetails.getInstance().getActivity()).b().a(new C0774e()).a((OnFailureListener) new d()).a((com.google.android.gms.tasks.b) new c()).a(new b());
            if (this.f46093c == null) {
                this.f46093c = new f();
            }
            AssistLogs.printLog("Registering SMS Consent User API receiver", this);
            a(this.f46093c, intentFilter);
        }
    }

    /* renamed from: easypay.actions.e$e  reason: collision with other inner class name */
    class C0774e implements OnSuccessListener<Void> {
        C0774e() {
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            AssistLogs.printLog("Consent API Success".concat(String.valueOf((Void) obj)), this);
        }
    }

    class d implements OnFailureListener {
        d() {
        }

        public final void onFailure(Exception exc) {
            AssistLogs.printLog("Consent API :Failure" + exc.getMessage(), this);
        }
    }

    class c implements com.google.android.gms.tasks.b {
        c() {
        }

        public final void a() {
            AssistLogs.printLog("Consent API :cancelled ", this);
        }
    }

    class b implements com.google.android.gms.tasks.c<Void> {
        b() {
        }

        public final void a(Task<Void> task) {
            AssistLogs.printLog("Consent API :onComplete ", this);
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        public final void onReceive(Context context, Intent intent) {
            Status status;
            c cVar;
            if (intent != null && "com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
                Bundle extras = intent.getExtras();
                AssistLogs.printLog("Received message intent (NO SMS Permission)", this);
                if (extras != null && (status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) != null && status.f8360g == 0) {
                    AssistLogs.printLog("Show consent sheet to user", this);
                    Intent intent2 = (Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT");
                    try {
                        if (AssistMerchantDetails.getInstance().isEasyPayEnabled() && AssistMerchantDetails.getInstance().getFragment() != null) {
                            AssistMerchantDetails.getInstance().getFragment().startActivityForResult(intent2, 121);
                        } else if (AssistMerchantDetails.getInstance().isNativeOtpEnabled() && (cVar = (c) AssistMerchantDetails.getInstance().getActivity().getSupportFragmentManager().c("NativeHeadLessFragment")) != null) {
                            cVar.startActivityForResult(intent2, 121);
                        }
                    } catch (ActivityNotFoundException unused) {
                    }
                }
            }
        }
    }

    private void a(Context context) {
        if (context == null || !easypay.utils.b.c(context)) {
            AssistLogs.printLog("Context is null or No Read SMS permission", this);
            return;
        }
        try {
            AssistLogs.printLog("Reading existing messages.", this);
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = null;
            if (Build.VERSION.SDK_INT >= 19) {
                AssistLogs.printLog("Fetching cursor", this);
                try {
                    Uri uri = Telephony.Sms.Inbox.CONTENT_URI;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f46096f);
                    cursor = contentResolver.query(uri, (String[]) null, "date>=?", new String[]{sb.toString()}, (String) null);
                } catch (SecurityException e2) {
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
            if (cursor != null) {
                AssistLogs.printLog("Cursor non null and traversing it, OTP detected = " + this.f46092a, this);
                while (cursor.moveToNext() && !this.f46092a) {
                    a(cursor.getString(cursor.getColumnIndex("body")), cursor.getString(cursor.getColumnIndex(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS)), true);
                }
                cursor.close();
                return;
            }
            AssistLogs.printLog("cursor is null", this);
        } catch (NullPointerException e3) {
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    private void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver != null && AssistMerchantDetails.getInstance().getActivity() != null) {
            AssistMerchantDetails.getInstance().getActivity().registerReceiver(broadcastReceiver, intentFilter);
            this.f46095e = true;
        }
    }

    public final void d() {
        if (this.f46093c != null && this.f46095e && AssistMerchantDetails.getInstance().getActivity() != null) {
            try {
                AssistMerchantDetails.getInstance().getActivity().unregisterReceiver(this.f46093c);
                this.f46093c = null;
                this.f46095e = false;
            } catch (Exception unused) {
            }
        }
    }

    public static void b() {
        f46091b = null;
    }
}
