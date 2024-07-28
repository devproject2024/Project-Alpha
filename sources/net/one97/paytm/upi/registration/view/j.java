package net.one97.paytm.upi.registration.view;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.registration.a.d;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class j extends h implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private TextView f68901a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68902b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68903c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f68904d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d.b f68905e;

    /* renamed from: f  reason: collision with root package name */
    private int f68906f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f68907g;

    /* renamed from: h  reason: collision with root package name */
    private String f68908h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f68909i;
    /* access modifiers changed from: private */
    public String j;
    private ArrayList<String> k = new ArrayList<>();
    private FrameLayout l;
    private ProgressBar m;
    private ImageView n;
    private final b o = new b();
    /* access modifiers changed from: private */
    public long p = ((long) UpiGTMLoader.getInstance().getUpiDeviceBindingPollingTime());
    private long q;
    private RelativeLayout r;
    private BroadcastReceiver s = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            int resultCode = getResultCode();
            int i2 = -1;
            String str = ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE;
            if (resultCode == -1) {
                j.this.f68905e.a();
                if (j.this.f68907g) {
                    j.this.f68905e.b();
                }
                str = "success";
            } else if (resultCode == 1) {
                j.this.f68905e.c();
                i2 = 1;
            } else if (resultCode == 2) {
                j.this.f68905e.c();
                i2 = 2;
            } else if (resultCode == 3) {
                j.this.f68905e.c();
                i2 = 3;
            } else if (resultCode == 4) {
                j.this.f68905e.c();
                i2 = 4;
            } else if (resultCode == 5) {
                j.this.f68905e.c();
                i2 = 5;
            } else if (resultCode == 7) {
                j.this.f68905e.c();
                i2 = 7;
            } else if (resultCode == 8) {
                j.this.f68905e.c();
                i2 = 8;
            }
            Context context2 = j.this.getContext();
            String concat = "device_binding_sms_os_response_".concat(str);
            String concat2 = "errorCode=".concat(String.valueOf(i2));
            CJRSendGTMTag.sendNewCustomGTMEvents(context2, GAConstants.CATEGORY.UPI_ONB_V1, concat, concat2, "sms_operator=" + j.this.j + ";vmn=" + j.this.f68909i, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        }
    };
    private BroadcastReceiver t = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            getResultCode();
        }
    };

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static j a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        bundle.putInt(UpiConstants.EXTRA_SUBSCRIPTION_ID, i2);
        bundle.putInt(UpiConstants.EXTRA_FLAG_REDIRECT, i3);
        jVar.setArguments(bundle);
        return jVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            int i2 = getArguments().getInt(UpiConstants.EXTRA_SUBSCRIPTION_ID);
            int i3 = getArguments().getInt(UpiConstants.EXTRA_FLAG_REDIRECT);
            this.j = UpiUtils.getCarrierName(getContext(), i2);
            getActivity();
            getActivity();
            net.one97.paytm.upi.registration.b.a.b a2 = g.a(a.a(g.d(), (a.C1347a) null));
            getActivity();
            this.f68905e = new net.one97.paytm.upi.registration.presenter.d(a2, a.a(g.d(), (a.C1347a) null), this, (AccountProviderBody.AccountProvider) getArguments().getSerializable(UpiConstants.EXTRA_SELECTED_BANK), i2, this.j, i3);
        }
        if (getActivity() != null) {
            getActivity().registerReceiver(this.s, new IntentFilter("SMS_SENT"));
            getActivity().registerReceiver(this.t, new IntentFilter("SMS_DELIVERED"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_registration_polling_progress, viewGroup, false);
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo(UpiConstants.GTM_SCREEN_VIEW_SENDING_SMS, "wallet", getActivity());
        Context context = getContext();
        String mobileNumbersFromSim = UpiUtils.getMobileNumbersFromSim(getContext());
        CJRSendGTMTag.sendNewCustomGTMEvents(context, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "mobile_number_capture", mobileNumbersFromSim, Build.MANUFACTURER + "-" + Build.MODEL, "", "", "wallet");
        Context context2 = getContext();
        String mobileNumbersFromSim2 = UpiUtils.getMobileNumbersFromSim(getContext());
        CJRSendGTMTag.sendNewCustomGTMEvents(context2, GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", mobileNumbersFromSim2, Build.MANUFACTURER + "-" + Build.MODEL, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        this.f68901a = (TextView) inflate.findViewById(R.id.tv_bank_name);
        this.f68902b = (TextView) inflate.findViewById(R.id.tv_registration_status);
        this.f68903c = (TextView) inflate.findViewById(R.id.tv_mobile_number);
        this.r = (RelativeLayout) inflate.findViewById(R.id.rl_alert_layout);
        this.l = (FrameLayout) inflate.findViewById(R.id.pb_progress);
        this.f68904d = (TextView) this.l.findViewById(R.id.polling_timer);
        this.n = (ImageView) this.l.findViewById(R.id.iv_bank_icon);
        this.m = (ProgressBar) this.l.findViewById(R.id.progress);
        if (Build.VERSION.SDK_INT < 21) {
            Drawable f2 = androidx.core.graphics.drawable.a.f(this.m.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(getContext(), R.color.upi_pin_green));
            this.m.setIndeterminateDrawable(androidx.core.graphics.drawable.a.g(f2));
        } else {
            this.m.getIndeterminateDrawable().setColorFilter(androidx.core.content.b.c(getContext(), R.color.upi_pin_green), PorterDuff.Mode.SRC_IN);
        }
        this.r.setVisibility(0);
        this.f68905e.e();
        return inflate;
    }

    public void onStop() {
        super.onStop();
        if (UpiGTMLoader.getInstance().doCallExpireToken()) {
            this.f68905e.g();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f68905e.g();
        this.f68905e.f();
        i();
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.s);
            getActivity().unregisterReceiver(this.t);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        if (accountProvider != null) {
            this.f68901a.setText(getString(R.string.upi_progress_verify_with_bank));
            this.f68902b.setText(String.format(getString(R.string.upi_progress_confirming_account_bank_new), new Object[]{accountProvider.getAccountProvider(), i.a().f66981b}));
            w.a().a(accountProvider.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.n, (e) null);
        } else {
            this.f68901a.setText(getString(R.string.upi_progress_verify_your_number));
            this.n.setImageResource(R.drawable.ic_upi_send_sms);
        }
        this.f68903c.setVisibility(8);
    }

    public final void a(int i2, String str) {
        this.f68906f = i2;
        this.f68908h = str;
        if (Build.VERSION.SDK_INT >= 23) {
            if (getActivity() != null && isAdded()) {
                if (androidx.core.content.b.a((Context) getActivity(), "android.permission.SEND_SMS") != 0) {
                    requestPermissions(new String[]{"android.permission.SEND_SMS"}, 32);
                    return;
                }
            } else {
                return;
            }
        }
        if (isAdded()) {
            h();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2, String str) {
        if (getActivity() != null && getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            ((UpiRegistrationActivity) getActivity()).a(accountProvider, -1, i2, str);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str) {
        if (getActivity() != null) {
            if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) getActivity(), "android.permission.READ_PHONE_STATE") == 0) {
                if (this.f68907g) {
                    long j2 = this.q;
                    if (j2 == 0) {
                        this.q = j2 + 1;
                        return;
                    }
                }
                if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
                    if (((UpiRegistrationActivity) getActivity()).b() == UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
                        CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_failed_onboarding", String.valueOf(i3), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    }
                    UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
                    if (!UpiUtils.isMultiSimDevice(getActivity())) {
                        upiRegistrationActivity.a(accountProvider, i2, i3, str);
                    } else if (i3 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_SENT.ordinal() || i3 == UpiConstants.RegistrationErrorOrigin.NPCI_OR_TOKEN_ERROR.ordinal()) {
                        upiRegistrationActivity.a(accountProvider, i2, i3, str);
                    } else {
                        upiRegistrationActivity.a(accountProvider, i3);
                    }
                }
            } else {
                requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 16);
            }
        }
    }

    public final void a() {
        this.f68905e.a(this.f68908h, this.f68909i);
        this.f68902b.setText(getString(R.string.upi_progress_device_binding_desc, i.a().f66981b));
    }

    public final boolean d() {
        if (getActivity() instanceof UpiRegistrationActivity) {
            return ((UpiRegistrationActivity) getActivity()).f68774f;
        }
        return false;
    }

    public final boolean f() {
        if (!(getActivity() instanceof UpiRegistrationActivity) || ((UpiRegistrationActivity) getActivity()).b() != UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
            return false;
        }
        return true;
    }

    public final void b() {
        if (getActivity() != null) {
            if (((UpiRegistrationActivity) getActivity()).f68771c != -1) {
                getActivity().setResult(-1);
                getActivity().finish();
            } else {
                this.f68905e.d();
            }
            Context context = getContext();
            CJRSendGTMTag.sendNewCustomGTMEvents(context, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "sim_selection_status", "success", "vmn=" + this.f68909i, "", "", "wallet");
        }
    }

    public final void b(AccountProviderBody.AccountProvider accountProvider) {
        if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
            upiRegistrationActivity.c();
            upiRegistrationActivity.f68770b.setVisibility(UpiUtils.isPaytmFirstApp() ? 8 : 0);
            net.one97.paytm.upi.profile.view.b bVar = (net.one97.paytm.upi.profile.view.b) upiRegistrationActivity.getSupportFragmentManager().c(net.one97.paytm.upi.profile.view.b.class.getSimpleName());
            if (bVar == null) {
                bVar = net.one97.paytm.upi.profile.view.b.a(accountProvider, "", UpiConstants.PROFILE_STATE.CHECK_VPA);
            }
            UpiUtils.replaceFragmentToActivity(upiRegistrationActivity.getSupportFragmentManager(), bVar, R.id.fl_container);
        }
    }

    private void h() {
        if (!this.f68907g) {
            j();
        }
        if (!this.f68907g) {
            this.f68901a.setText(getString(R.string.upi_progress_sms_sending_start_header_new));
            this.f68902b.setText(getString(R.string.upi_progress_sms_sending_start_desc_new));
            TextView textView = this.f68903c;
            textView.setText("+91 " + i.a().f66981b);
            this.f68903c.setVisibility(0);
            this.n.setImageResource(R.drawable.ic_upi_send_sms);
        }
        if (!this.f68905e.i().isEmpty()) {
            this.k = this.f68905e.i();
        } else {
            this.k = ((UpiRegistrationActivity) getActivity()).d();
        }
        this.f68909i = this.k.toString();
        this.f68905e.a(this.k.size());
        String str = SDKConstants.KEY_STAGING_API.equalsIgnoreCase(i.a().f66988i) ? "UPIUAT " : "UPI ";
        PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 0, new Intent("SMS_SENT"), 0);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(getActivity(), 0, new Intent("SMS_DELIVERED"), 0);
        SmsManager smsManager = SmsManager.getDefault();
        if (this.f68906f != -1 && Build.VERSION.SDK_INT >= 22) {
            smsManager = SmsManager.getSmsManagerForSubscriptionId(this.f68906f);
        }
        try {
            ListIterator<String> listIterator = this.k.listIterator();
            while (listIterator.hasNext()) {
                String next = listIterator.next();
                smsManager.sendTextMessage(next, (String) null, str + this.f68908h, broadcast, broadcast2);
                Context context = getContext();
                CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_os_request_initiated", "", "sms_operator=" + this.j + ";vmn=" + next, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f68905e.c();
        }
    }

    public final void g() {
        if (UpiGTMLoader.getInstance().doSendUpiSmsFromBothSim() && UpiUtils.isMultiSimDevice(getActivity())) {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                this.f68906f = 3 - this.f68906f;
                if (this.f68906f != -1 && Build.VERSION.SDK_INT >= 22) {
                    smsManager = SmsManager.getSmsManagerForSubscriptionId(this.f68906f);
                }
                SmsManager smsManager2 = smsManager;
                String str = SDKConstants.KEY_STAGING_API.equalsIgnoreCase(i.a().f66988i) ? "UPIUAT " : "UPI ";
                this.j = UpiUtils.getCarrierName(getContext(), this.f68906f);
                String str2 = this.f68909i;
                smsManager2.sendTextMessage(str2, (String) null, str + this.f68908h, (PendingIntent) null, (PendingIntent) null);
                Context context = getContext();
                CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_os_request_initiated", "", "sms_operator=" + this.j + ";vmn=" + this.f68909i, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 32) {
            if (iArr.length > 0 && iArr[0] == 0) {
                h();
            } else if (PermissionUtil.hasSelectedNeverShowThisAgain(getActivity(), "android.permission.READ_SMS")) {
                a(getString(R.string.upi_send_sms_permission_title), getString(R.string.upi_send_sms_permission_text), (int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            } else {
                UpiUtils.showReadPhoneStatePermissionDialog(getActivity(), Boolean.TRUE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        j.this.o();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        j.this.n();
                    }
                });
            }
        } else if (i2 == 16) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f68905e.c();
            } else if (PermissionUtil.hasSelectedNeverShowThisAgain(getActivity(), "android.permission.READ_PHONE_STATE")) {
                a(getString(R.string.upi_mandatory_permission_denied), getString(R.string.upi_read_phone_state_permission_text_new), (int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE);
            } else {
                UpiUtils.showReadPhoneStatePermissionDialog(getActivity(), Boolean.TRUE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        j.this.m();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        j.this.l();
                    }
                });
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f68905e.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        a(this.f68906f, this.f68908h);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f68905e.c();
    }

    private void a(String str, String str2, final int i2) {
        final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(getActivity());
        customWalletAlertDialog.setTitle(str);
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setCancelable(true);
        customWalletAlertDialog.setButton(-2, getResources().getString(R.string.upi_cancel), new View.OnClickListener() {
            public final void onClick(View view) {
                customWalletAlertDialog.dismiss();
                if (i2 == 256) {
                    j.this.f68905e.c();
                } else {
                    j.this.getActivity().finish();
                }
            }
        });
        customWalletAlertDialog.setButton(-1, getString(R.string.upi_go_to_settings), new View.OnClickListener() {
            public final void onClick(View view) {
                customWalletAlertDialog.dismiss();
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", j.this.getActivity().getApplicationContext().getPackageName(), (String) null));
                j.this.startActivityForResult(intent, i2);
            }
        });
        customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
        try {
            if (!getActivity().isFinishing()) {
                customWalletAlertDialog.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 256) {
            a(this.f68906f, this.f68908h);
        } else if (i2 == 272) {
            this.f68905e.c();
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getCanonicalName();
            kVar.e(activity);
        }
    }

    public final void a(boolean z) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "sim_selection_status", z ? "success" : "mismatch", "", "", "", "wallet");
    }

    public final void b(boolean z) {
        if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            ((UpiRegistrationActivity) getActivity()).f68773e = z;
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        this.o.a();
        this.f68907g = false;
    }

    private void j() {
        this.o.a((c) p.interval(1, TimeUnit.SECONDS).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).takeWhile(new q<Long>() {
            public final /* synthetic */ boolean test(Object obj) throws Throwable {
                return ((Long) obj).longValue() <= j.this.p;
            }
        }).subscribeWith(k()));
        this.o.a(p.timer(15, TimeUnit.SECONDS).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new io.reactivex.rxjava3.d.g<Long>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                if (j.this.f68905e != null) {
                    j.this.f68905e.a(j.this.f(), j.this.j, "");
                    boolean unused = j.this.f68907g = true;
                }
            }
        }));
    }

    private io.reactivex.rxjava3.g.c<Long> k() {
        return new io.reactivex.rxjava3.g.c<Long>() {
            public final void onError(Throwable th) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                j.this.f68904d.setVisibility(0);
                long e2 = j.this.p - ((Long) obj).longValue();
                if (e2 >= 10) {
                    j.this.f68904d.setText(String.valueOf(e2));
                } else {
                    j.this.f68904d.setText("0".concat(String.valueOf(e2)));
                }
            }

            public final void onComplete() {
                j.this.f68904d.setVisibility(8);
                j.this.i();
            }
        };
    }

    public final void c() {
        this.f68907g = false;
    }

    public final void e() {
        if (isAdded()) {
            i();
            this.f68904d.setVisibility(8);
            this.f68901a.setText(getString(R.string.upi_progress_getting_accounts));
            this.f68902b.setText(getString(R.string.upi_progress_confirming_your_account));
            TextView textView = this.f68903c;
            textView.setText("+91 " + i.a().f66981b);
            this.f68903c.setVisibility(0);
            this.n.setImageResource(R.drawable.ic_paytm_payments_bank);
            this.f68905e.h();
            CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_success_onboarding", "", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        }
    }

    public final void a(String str, UpiProfileModel.ProfileDetails profileDetails) {
        if (getActivity() != null) {
            ArrayList<BankAccountDetails.BankAccount> arrayList = null;
            if (profileDetails != null) {
                arrayList = profileDetails.getBankAccountList();
            }
            Intent intent = new Intent();
            intent.putExtra(UpiConstants.ARG_BANK_LIST, arrayList);
            intent.putExtra("vpa", str);
            intent.putExtra(UpiConstants.ARG_IS_PROFILE_CREATED, true);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public final void a(String str, String str2) {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra(UpiConstants.ARG_RES_CODE, str);
            intent.putExtra(UpiConstants.ARG_RES_MSG, str2);
            intent.putExtra(UpiConstants.ARG_IS_PROFILE_CREATED, false);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }
}
