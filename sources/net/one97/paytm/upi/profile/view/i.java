package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import com.squareup.picasso.w;
import java.util.Iterator;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.e;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class i extends h implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private e.a f68262a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f68263b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68264c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68265d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68266e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68267f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68268g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68269h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f68270i;
    private View j;
    private TextView k;
    private TextView l;
    private ImageView m;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68262a = (e.a) obj;
    }

    public static i a() {
        return new i();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_post_registration, viewGroup, false);
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo(UpiConstants.GTM_SCREEN_VIEW_BANK_ACCOUNT_LINKED_SUCCESS, "wallet", getActivity());
        this.j = inflate.findViewById(R.id.divider);
        this.m = (ImageView) inflate.findViewById(R.id.iv_back_arrow);
        this.f68266e = (TextView) inflate.findViewById(R.id.tv_link_bank_prompt);
        this.f68267f = (TextView) inflate.findViewById(R.id.tv_link_bank_btn);
        this.k = (TextView) inflate.findViewById(R.id.tv_send_money);
        this.f68263b = (RelativeLayout) inflate.findViewById(R.id.rl_bank_info);
        this.f68264c = (TextView) this.f68263b.findViewById(R.id.tv_bank_name);
        this.f68265d = (TextView) this.f68263b.findViewById(R.id.tv_acc_no);
        this.f68268g = (TextView) this.f68263b.findViewById(R.id.tv_set_mpin);
        this.f68269h = (TextView) this.f68263b.findViewById(R.id.tv_upi_pin_msg);
        this.f68270i = (ImageView) this.f68263b.findViewById(R.id.iv_bank_icon);
        this.l = (TextView) this.f68263b.findViewById(R.id.tv_vpa_value);
        String string = getString(R.string.upi_post_registration_footer_msg);
        SpannableString spannableString = new SpannableString(string);
        AnonymousClass1 r0 = new ClickableSpan() {
            public final void onClick(View view) {
                i iVar = i.this;
                iVar.startActivity(new Intent(iVar.getActivity(), UPISettingsActivity.class));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        };
        String string2 = getString(R.string.my_profile);
        if (!TextUtils.isEmpty(string2)) {
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            if (indexOf > 0 && length > 0 && indexOf < length) {
                spannableString.setSpan(r0, indexOf, length, 33);
            }
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_upi_profile_msg);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.parseColor("#00b9f5"));
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.a(i.this);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (i.this.getActivity() != null) {
                    if ((i.this.getActivity() instanceof UpiPostRegistrationActivity) && ((UpiPostRegistrationActivity) i.this.getActivity()).a() == UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
                        Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
                        intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
                        a.a((Context) i.this.getActivity()).a(intent);
                    }
                    i.this.getActivity().finish();
                }
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68262a.e();
    }

    public final void a(final UserUpiDetails userUpiDetails) {
        String str;
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
        int i2 = 8;
        if (selectedBankAccount == null) {
            this.f68266e.setVisibility(0);
            this.f68267f.setVisibility(0);
            this.f68267f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AccountProviderActivity.a((Fragment) i.this, 22);
                }
            });
            this.j.setVisibility(8);
            this.f68263b.setVisibility(8);
            return;
        }
        this.f68263b.setVisibility(0);
        this.f68264c.setText(selectedBankAccount.getBankName());
        this.f68265d.setText(getString(R.string.upi_ppb_account_number, UpiUtils.maskNumber(selectedBankAccount.getAccRefNumber())));
        this.l.setText(getString(R.string.upi_address_value, userUpiDetails.getVpa()));
        w.a().a(selectedBankAccount.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.f68270i, (com.squareup.picasso.e) null);
        TextView textView = this.f68268g;
        if (!selectedBankAccount.isMpinSet()) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        this.f68268g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (userUpiDetails.getBankAccountList() != null) {
                    net.one97.paytm.upi.h hVar = net.one97.paytm.upi.i.a().m;
                    hVar.a("UpiPostRegistrationFragment", userUpiDetails.getBankAccountList().size() + "_" + userUpiDetails.getSelectedBankIdx());
                } else {
                    net.one97.paytm.upi.h hVar2 = net.one97.paytm.upi.i.a().m;
                    hVar2.a("UpiPostRegistrationFragment", "null_" + userUpiDetails.getSelectedBankIdx());
                }
                SetMPINActivity.a((Fragment) i.this, userUpiDetails);
            }
        });
        Iterator<BankAccountDetails.BankAccountCredentials> it2 = selectedBankAccount.getCredsAllowed().getChild().iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = "0";
                break;
            }
            BankAccountDetails.BankAccountCredentials next = it2.next();
            if ("MPIN".equals(next.getCredsAllowedSubType())) {
                str = next.getCredsAllowedDLength();
                break;
            }
        }
        if (selectedBankAccount.isMpinSet()) {
            this.f68269h.setText(String.format(getString(R.string.upi_pin_exists), new Object[]{str}));
            this.f68269h.setTextColor(b.c(getActivity(), R.color.upi_pin_green));
            return;
        }
        this.f68269h.setText(String.format(getString(R.string.upi_pin_set), new Object[]{str}));
        this.f68269h.setTextColor(b.c(getActivity(), R.color.upi_pin_red));
    }

    public final void b(UserUpiDetails userUpiDetails) {
        String str;
        this.f68268g.setVisibility(4);
        Iterator<BankAccountDetails.BankAccountCredentials> it2 = userUpiDetails.getSelectedBankAccount().getCredsAllowed().getChild().iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = "0";
                break;
            }
            BankAccountDetails.BankAccountCredentials next = it2.next();
            if ("MPIN".equals(next.getCredsAllowedSubType())) {
                str = next.getCredsAllowedDLength();
                break;
            }
        }
        this.f68269h.setText(String.format(getString(R.string.upi_pin_exists), new Object[]{str}));
        this.f68269h.setTextColor(b.c(getActivity(), R.color.upi_pin_green));
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a((Fragment) this, accountProvider, str, 21);
        getActivity().finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 20) {
            if (i3 == -1) {
                this.f68262a.a();
            }
        } else if (i2 == 22 && i3 == -1) {
            this.f68262a.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f68262a.f();
    }

    static /* synthetic */ void a(i iVar) {
        if (iVar.getActivity() == null || !(iVar.getActivity() instanceof UpiPostRegistrationActivity) || ((UpiPostRegistrationActivity) iVar.getActivity()).a() != UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
            net.one97.paytm.upi.i.a();
            Bundle bundle = new Bundle();
            bundle.putString(UpiConstants.MONEY_TRANSFER_HEADER, iVar.getResources().getString(R.string.send_money));
            net.one97.paytm.upi.i.a().m.a(iVar.getContext(), bundle);
            return;
        }
        Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
        intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
        a.a((Context) iVar.getActivity()).a(intent);
        iVar.getActivity().finish();
    }
}
