package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiRegistrationDeviceBindModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.a.c;
import net.one97.paytm.upi.registration.view.h;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class i extends h implements c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c.a f68889a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68890b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68891c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68892d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68893e;

    /* renamed from: f  reason: collision with root package name */
    private String f68894f = "";

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f68895g;

    /* renamed from: h  reason: collision with root package name */
    private ConstraintLayout f68896h;

    /* renamed from: i  reason: collision with root package name */
    private View f68897i;
    private ImageView j;
    private FrameLayout k;
    private UpiRegistrationDeviceBindModel.Details l;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static i b(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        bundle.putInt(UpiConstants.EXTRA_SUBSCRIPTION_ID, i2);
        bundle.putInt(UpiConstants.EXTRA_REG_ERROR_CAUSE, i3);
        bundle.putString("message", str);
        iVar.setArguments(bundle);
        return iVar;
    }

    public static i a(AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        bundle.putString("vpa", str);
        bundle.putInt(UpiConstants.EXTRA_REG_ERROR_CAUSE, i2);
        iVar.setArguments(bundle);
        return iVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f68894f = getString(R.string.upi_bank);
        if (getArguments() != null) {
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) getArguments().getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
            this.l = (UpiRegistrationDeviceBindModel.Details) getArguments().getSerializable(UpiConstants.EXTRA_DEVICE_BIND_MODEL);
            if (accountProvider != null && !TextUtils.isEmpty(accountProvider.getAccountProvider())) {
                this.f68894f = accountProvider.getAccountProvider();
            }
            int i2 = getArguments().getInt(UpiConstants.EXTRA_REG_ERROR_CAUSE);
            int i3 = getArguments().getInt(UpiConstants.EXTRA_SUBSCRIPTION_ID);
            String string = getArguments().getString("message");
            getActivity();
            getActivity();
            this.f68889a = new net.one97.paytm.upi.registration.presenter.c(g.a(a.a(g.d(), (a.C1347a) null)), this, accountProvider, i3, i2, string, getArguments().getString("vpa", (String) null));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_registration_sms_error, viewGroup, false);
        this.k = (FrameLayout) inflate.findViewById(R.id.i_icon);
        this.f68890b = (TextView) inflate.findViewById(R.id.tv_error_title);
        this.f68891c = (TextView) inflate.findViewById(R.id.tv_error_desc);
        this.f68892d = (TextView) inflate.findViewById(R.id.tv_error_action);
        this.f68893e = (TextView) inflate.findViewById(R.id.tv_operator_charges_warning);
        this.f68892d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.f68889a.a();
            }
        });
        this.j = (ImageView) inflate.findViewById(R.id.iv_error_icon);
        this.f68895g = (LinearLayout) inflate.findViewById(R.id.ll_options);
        this.f68896h = (ConstraintLayout) inflate.findViewById(R.id.accountSwitch);
        this.f68897i = inflate.findViewById(R.id.rl_login);
        this.f68889a.e();
        return inflate;
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str) {
        boolean z;
        if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
            if (!(i3 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_SENT.ordinal() || i3 == UpiConstants.RegistrationErrorOrigin.MOBIlE_NOT_REGISTERED.ordinal() || i3 == UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal())) {
                if (i3 == UpiConstants.RegistrationErrorOrigin.NO_SIM_INSTALLED.ordinal()) {
                    if (UpiUtils.isSimAvailable(getActivity())) {
                        if (getActivity() != null) {
                            getActivity();
                            getActivity();
                            z = g.a(a.a(g.d(), (a.C1347a) null)).g();
                        } else {
                            z = false;
                        }
                        if (z) {
                            upiRegistrationActivity.b(accountProvider, -1);
                            return;
                        } else if (UpiUtils.isMultiSimDevice(getActivity())) {
                            upiRegistrationActivity.a(accountProvider, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal());
                            return;
                        } else {
                            upiRegistrationActivity.b(accountProvider, i2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(i3 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_RECEIVED.ordinal() || i3 == UpiConstants.RegistrationErrorOrigin.SMS_TOKEN_EXPIRED.ordinal())) {
                    if (i3 == UpiConstants.RegistrationErrorOrigin.NPCI_OR_TOKEN_ERROR.ordinal()) {
                        upiRegistrationActivity.finish();
                        return;
                    } else if (i3 == UpiConstants.RegistrationErrorOrigin.ADD_ACCOUNT_TECHNICAL_ERROR.ordinal()) {
                        upiRegistrationActivity.a(accountProvider, str);
                        return;
                    } else if (i3 == UpiConstants.RegistrationErrorOrigin.ADD_ACCOUNT_CONNECTION_ERROR.ordinal()) {
                        upiRegistrationActivity.a(accountProvider, str);
                        return;
                    } else if (i3 != UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal() && i3 == UpiConstants.RegistrationErrorOrigin.NON_COMPLIANT_APP_VERSION_FOR_DEVICE_BINDING.ordinal()) {
                        UpiUtils.openPlayStorePage(upiRegistrationActivity);
                        return;
                    }
                }
            }
            upiRegistrationActivity.b(accountProvider, i2);
        }
    }

    public final void a(int i2, String str) {
        this.f68892d.setVisibility(0);
        if (i2 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_SENT.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            if (!TextUtils.isEmpty(str)) {
                this.f68891c.setText(str);
            } else {
                this.f68891c.setText(getString(R.string.upi_error_sms_not_sent_desc_new));
            }
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.MOBIlE_NOT_REGISTERED.ordinal()) {
            this.f68891c.setText(getString(R.string.upi_new_error_mobile_not_registered_desc, UpiAppUtils.getMobile(getActivity())));
            ((TextView) this.f68897i.findViewById(R.id.accountChange)).setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
            this.f68897i.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    i.b(i.this);
                }
            });
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68892d.setText(getString(R.string.upi_error_retry));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
            this.f68895g.setVisibility(0);
            this.f68897i.setVisibility(0);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.NON_COMPLIANT_APP_VERSION_FOR_DEVICE_BINDING.ordinal()) {
            if (!TextUtils.isEmpty(str)) {
                this.f68891c.setText(str);
            } else {
                this.f68891c.setText(getString(R.string.upi_error_other_error_desc_new));
            }
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68892d.setText(getString(R.string.upi_update_app));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.NO_SIM_INSTALLED.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68891c.setText(getString(R.string.upi_new_error_no_sim_desc));
            this.f68892d.setText(getString(R.string.upi_error_retry_with_sim));
            this.j.setImageResource(R.drawable.ic_upi_no_sim);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_verify_mobile_number_title_new));
            this.f68890b.setTextColor(b.c(getActivity(), R.color.black));
            this.f68891c.setText(getString(R.string.upi_verify_mobile_number_desc_new));
            this.f68892d.setText(getString(R.string.upi_proceed_send_sms));
            this.f68893e.setVisibility(0);
            this.k.setBackground(b.a((Context) getActivity(), R.drawable.upi_bg_circle_light_blue));
            this.j.setImageResource(R.drawable.ic_upi_mobile);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_RECEIVED.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            if (!TextUtils.isEmpty(str)) {
                this.f68891c.setText(str);
            } else {
                this.f68891c.setText(getString(R.string.upi_error_sms_not_received_desc_new));
            }
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SMS_TOKEN_EXPIRED.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68891c.setText(getString(R.string.upi_error_sms_not_received_desc_new));
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.NPCI_OR_TOKEN_ERROR.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68891c.setText(getString(R.string.upi_error_npci_error_desc_new));
            this.f68892d.setText(getString(R.string.upi_error_retry));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.ADD_ACCOUNT_TECHNICAL_ERROR.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_add_account_title));
            this.f68891c.setText(getString(R.string.upi_error_add_account_desc_1));
            this.f68892d.setText(getString(R.string.upi_error_retry));
            this.j.setImageResource(R.drawable.ic_upi_bank_error);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.ADD_ACCOUNT_CONNECTION_ERROR.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_add_account_title));
            this.f68891c.setText(getString(R.string.upi_error_add_account_desc_2, this.f68894f));
            this.f68892d.setText(getString(R.string.upi_error_retry));
            this.j.setImageResource(R.drawable.ic_upi_bank_error);
            a();
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.NETWORK_CONNECTION_ERROR.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68891c.setText(getString(R.string.no_internet_new_message));
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
            this.f68892d.setText(getString(R.string.upi_error_retry));
            if (!TextUtils.isEmpty(str)) {
                this.f68891c.setText(str);
            } else {
                this.f68891c.setText(getString(R.string.upi_error_other_error_desc_new));
            }
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.UNIQUE_MOBILE_NUMBER_ALLOWED_LIMIT_AGAINST_DEVICE_ID_BREACHED.ordinal()) {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            if (!TextUtils.isEmpty(str)) {
                this.f68891c.setText(str);
            } else {
                this.f68891c.setText(getString(R.string.upi_error_other_error_desc_new));
            }
            this.f68892d.setVisibility(8);
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        } else {
            this.f68890b.setText(getString(R.string.upi_error_other_error_title));
            this.f68891c.setText(getString(R.string.upi_error_other_error_desc_new));
            this.f68892d.setText(getString(R.string.upi_error_resend_sms));
            this.j.setImageResource(R.drawable.ic_upi_mobile_error);
        }
    }

    private void a() {
        this.f68895g.setVisibility(0);
        this.f68896h.setVisibility(0);
        ((TextView) this.f68896h.findViewById(R.id.accountChange)).setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
        this.f68896h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (i.this.isAdded()) {
                    h.a aVar = h.f68882a;
                    h hVar = new h();
                    hVar.showNow(i.this.getChildFragmentManager(), hVar.getClass().getName());
                }
            }
        });
    }

    public void onDetach() {
        super.onDetach();
        this.f68889a.f();
    }

    static /* synthetic */ void b(i iVar) {
        h.a aVar = h.f68882a;
        new h().showNow(iVar.getChildFragmentManager(), h.class.getName());
    }
}
