package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.w;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.a.e;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class k extends h implements e.b {
    /* access modifiers changed from: private */
    public e.a A;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider B;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider C;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider D;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider E;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider F;
    /* access modifiers changed from: private */
    public AccountProviderBody.AccountProvider G;
    private AccountProviderBody.AccountProvider H;
    private AccountProviderBody.AccountProvider I;
    private boolean J;
    private boolean K;
    private String L;
    private String M;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f68922a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f68923b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f68924c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f68925d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f68926e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f68927f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f68928g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f68929h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f68930i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private RelativeLayout x;
    private ImageView y;
    private ProgressBar z;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.A = (e.a) obj;
    }

    public static k c() {
        return new k();
    }

    public static k c(String str) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putBoolean(UpiConstants.EXTRA_IS_FROM_REFUND, true);
        bundle.putString("vpa", str);
        bundle.putString(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.REFUND_TO_SOURCE);
        kVar.setArguments(bundle);
        return kVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.J = getArguments().getBoolean(UpiConstants.EXTRA_IS_FROM_SCHEDULER, false);
            this.K = getArguments().getBoolean(UpiConstants.EXTRA_IS_FROM_REFUND, false);
            this.L = getArguments().getString("vpa", (String) null);
            this.M = getArguments().getString(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, "");
        }
        getActivity();
        getActivity();
        this.A = new net.one97.paytm.upi.registration.presenter.e(g.a(a.a(g.d(), (a.C1347a) null)), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_registration_select_bank, viewGroup, false);
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo(UpiConstants.GTM_SCREEN_VIEW_LINK_BANK_DIALOG, "wallet", getActivity());
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_BANK_POPUP, "wallet");
        this.z = (ProgressBar) inflate.findViewById(R.id.pb_get_banks);
        this.y = (ImageView) inflate.findViewById(R.id.iv_close);
        this.f68922a = (LinearLayout) inflate.findViewById(R.id.ll_bank_1);
        this.f68923b = (LinearLayout) inflate.findViewById(R.id.ll_bank_2);
        this.f68924c = (LinearLayout) inflate.findViewById(R.id.ll_bank_3);
        this.f68925d = (LinearLayout) inflate.findViewById(R.id.ll_bank_4);
        this.f68926e = (LinearLayout) inflate.findViewById(R.id.ll_bank_5);
        this.f68927f = (LinearLayout) inflate.findViewById(R.id.ll_bank_6);
        this.f68928g = (ImageView) inflate.findViewById(R.id.iv_bank_1);
        this.f68929h = (ImageView) inflate.findViewById(R.id.iv_bank_2);
        this.f68930i = (ImageView) inflate.findViewById(R.id.iv_bank_3);
        this.j = (ImageView) inflate.findViewById(R.id.iv_bank_4);
        this.k = (ImageView) inflate.findViewById(R.id.iv_bank_5);
        this.l = (ImageView) inflate.findViewById(R.id.iv_bank_6);
        this.m = (TextView) inflate.findViewById(R.id.tv_bank_1);
        this.n = (TextView) inflate.findViewById(R.id.tv_bank_2);
        this.o = (TextView) inflate.findViewById(R.id.tv_bank_3);
        this.p = (TextView) inflate.findViewById(R.id.tv_bank_4);
        this.q = (TextView) inflate.findViewById(R.id.tv_bank_5);
        this.r = (TextView) inflate.findViewById(R.id.tv_bank_6);
        this.v = (TextView) inflate.findViewById(R.id.tv_select_bank_title);
        this.v.setText(getString(R.string.upi_select_your_bank, i.a().f66981b));
        this.s = (TextView) inflate.findViewById(R.id.tv_select_other_banks);
        this.x = (RelativeLayout) inflate.findViewById(R.id.rl_select_bank);
        this.t = (TextView) inflate.findViewById(R.id.tv_upi_offer);
        this.u = (TextView) inflate.findViewById(R.id.tv_personalise_paytm);
        this.w = (TextView) inflate.findViewById(R.id.tv_operator_note);
        try {
            if (!TextUtils.isEmpty(UpiGTMLoader.getInstance().getUpiOfferText())) {
                this.t.setVisibility(0);
                this.t.setMovementMethod(LinkMovementMethod.getInstance());
                String upiOfferText = UpiGTMLoader.getInstance().getUpiOfferText();
                final String substring = upiOfferText.substring(upiOfferText.indexOf("https"), upiOfferText.indexOf("'>"));
                if (Build.VERSION.SDK_INT >= 24) {
                    str = Html.fromHtml(upiOfferText, 0).toString();
                } else {
                    str = Html.fromHtml(upiOfferText).toString();
                }
                SpannableString spannableString = new SpannableString(str);
                AnonymousClass12 r2 = new ClickableSpan() {
                    public final void onClick(View view) {
                        i.a().m.a(k.this.getContext(), substring);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }
                };
                int indexOf = str.indexOf("Know More");
                spannableString.setSpan(r2, indexOf, indexOf + 9, 33);
                this.t.setText(spannableString);
                this.t.setHighlightColor(Color.parseColor("#00b9f5"));
            }
            if (!TextUtils.isEmpty(UpiGTMLoader.getInstance().getUpiSelectBankTitle())) {
                this.u.setText(UpiGTMLoader.getInstance().getUpiSelectBankTitle());
            }
        } catch (Exception unused) {
            if (!TextUtils.isEmpty(UpiGTMLoader.getInstance().getUpiSelectBankTitle())) {
                this.u.setText(UpiGTMLoader.getInstance().getUpiSelectBankTitle());
            } else {
                this.u.setText(getString(R.string.upi_personalise_paytm));
            }
            if (!TextUtils.isEmpty(UpiGTMLoader.getInstance().getUpiOfferText())) {
                this.t.setText(UpiGTMLoader.getInstance().getUpiOfferText());
            } else {
                this.t.setText(getString(R.string.upi_link_bank_money_transfer));
            }
        }
        this.y.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSendGTMTag.sendNewCustomGTMEvents(k.this.getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "close_cross_clicked", "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_BANK_POPUP, "wallet");
                if (k.this.getActivity() != null) {
                    k.this.getActivity().setResult(0);
                    k.this.getActivity().finish();
                }
            }
        });
        this.f68922a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.B, 1);
            }
        });
        this.f68923b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.C, 2);
            }
        });
        this.f68924c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.D, 3);
            }
        });
        this.f68925d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.E, 4);
            }
        });
        this.f68926e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.F, 5);
            }
        });
        this.f68927f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.A.a(k.this.G, 6);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.b();
                k.this.A.a();
            }
        });
        if (this.K) {
            this.u.setVisibility(8);
            this.t.setVisibility(8);
            this.v.setVisibility(8);
            this.y.setVisibility(8);
            this.w.setVisibility(8);
        } else {
            this.u.setVisibility(0);
            this.t.setVisibility(0);
            this.v.setVisibility(0);
            this.y.setVisibility(0);
            this.w.setVisibility(0);
        }
        this.A.e();
        return inflate;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            if (intent != null) {
                this.H = (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                this.A.a(i2, i3, intent);
            }
        } else if (i2 == 304) {
            if (this.K) {
                getActivity().getSupportFragmentManager().a((String) null, 0);
            }
        } else if (i2 == 272) {
            a(this.I);
        }
    }

    public final void b() {
        CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "bank_selected", "", "", "", UpiConstants.GTM_SCREEN_VIEW_LINK_BANK_DIALOG, "wallet");
    }

    private void d() {
        if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
            if (!UpiUtils.isSimAvailable(getActivity())) {
                upiRegistrationActivity.a(this.I, -1, UpiConstants.RegistrationErrorOrigin.NO_SIM_INSTALLED.ordinal(), "");
            } else if (UpiUtils.isMultiSimDevice(getActivity())) {
                upiRegistrationActivity.a(this.I, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal());
            } else {
                upiRegistrationActivity.b(this.I, -1);
            }
        } else if (getActivity() != null && (getActivity() instanceof UpiSelectBankActivity)) {
            ((UpiSelectBankActivity) getActivity()).a(this.I);
        } else if (!this.K || TextUtils.isEmpty(this.L)) {
            UpiRegistrationActivity.a((Activity) getActivity(), this.I, this.M, getArguments().getInt(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0));
        } else {
            BankVpaCreationActivity.a((Fragment) this, this.I, this.L, 304);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
    }

    public final void a(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4, int i6, AccountProviderBody.AccountProvider accountProvider5, int i7, AccountProviderBody.AccountProvider accountProvider6) {
        if (getActivity() != null) {
            this.B = accountProvider;
            this.C = accountProvider2;
            this.D = accountProvider3;
            this.E = accountProvider4;
            this.F = accountProvider5;
            this.G = accountProvider6;
            if (i2 == -1) {
                a(this.f68928g, this.B.getBankLogoUrl());
            } else {
                this.f68928g.setImageDrawable(b.a((Context) getActivity(), i2));
            }
            this.m.setText(this.B.getAccountProvider());
            if (i3 == -1) {
                a(this.f68929h, this.C.getBankLogoUrl());
            } else {
                this.f68929h.setImageDrawable(b.a((Context) getActivity(), i3));
            }
            this.n.setText(this.C.getAccountProvider());
            if (i4 == -1) {
                a(this.f68930i, this.D.getBankLogoUrl());
            } else {
                this.f68930i.setImageDrawable(b.a((Context) getActivity(), i4));
            }
            this.o.setText(this.D.getAccountProvider());
            if (i5 == -1) {
                a(this.j, this.E.getBankLogoUrl());
            } else {
                this.j.setImageDrawable(b.a((Context) getActivity(), i5));
            }
            this.p.setText(this.E.getAccountProvider());
            if (i6 == -1) {
                a(this.k, this.F.getBankLogoUrl());
            } else {
                this.k.setImageDrawable(b.a((Context) getActivity(), i6));
            }
            this.q.setText(this.F.getAccountProvider());
            if (i7 == -1) {
                a(this.l, this.G.getBankLogoUrl());
            } else {
                this.l.setImageDrawable(b.a((Context) getActivity(), i7));
            }
            this.r.setText(this.G.getAccountProvider());
        }
    }

    private static void a(ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            w.a().a(str).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(imageView, (com.squareup.picasso.e) null);
        } else {
            imageView.setImageResource(R.drawable.ic_paytm_payments_bank);
        }
    }

    public final void a() {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "more_banks_clicked", "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_BANK_POPUP, "wallet");
        if (!this.K || TextUtils.isEmpty(this.L)) {
            AccountProviderActivity.a((Activity) getActivity(), 1);
        } else {
            AccountProviderActivity.a((Fragment) this, 1);
        }
    }

    public final void a(String str) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            Toast.makeText(getActivity(), str, 0).show();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        if (accountProvider != null) {
            this.I = accountProvider;
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "bank_icon_clicked", accountProvider.getAccountProvider(), "", "", GAConstants.SCREEN_NAME.UPI_ADD_BANK_POPUP, "wallet");
            if (Build.VERSION.SDK_INT >= 23) {
                int a2 = b.a((Context) getActivity(), "android.permission.READ_PHONE_STATE");
                int a3 = b.a((Context) getActivity(), "android.permission.READ_SMS");
                if (!(a2 == 0 && a3 == 0)) {
                    requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_SMS"}, 16);
                    return;
                }
            }
            d();
        }
    }

    public final void b(String str) {
        CustomDialog.showAlert(getActivity(), "", str);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 16) {
            if (PermissionUtil.areAllPermissionsGranted(iArr)) {
                d();
            } else if (PermissionUtil.hasSelectedNeverShowThisAgain(getActivity(), "android.permission.READ_PHONE_STATE") || PermissionUtil.hasSelectedNeverShowThisAgain(getActivity(), "android.permission.READ_SMS")) {
                String string = getString(R.string.upi_mandatory_permission_denied);
                String string2 = getString(R.string.upi_read_phone_state_permission_text_new);
                final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(getActivity());
                customWalletAlertDialog.setTitle(string);
                customWalletAlertDialog.setMessage(string2);
                customWalletAlertDialog.setCancelable(true);
                customWalletAlertDialog.setButton(-2, getResources().getString(R.string.upi_cancel), new View.OnClickListener() {
                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        k.this.e();
                    }
                });
                customWalletAlertDialog.setButton(-1, getString(R.string.upi_go_to_settings), new View.OnClickListener() {

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ int f68939b = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE;

                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        Intent intent = new Intent();
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", k.this.getActivity().getApplicationContext().getPackageName(), (String) null));
                        k.this.startActivityForResult(intent, this.f68939b);
                    }
                });
                customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        k.this.e();
                    }
                });
                try {
                    if (getActivity() != null && !getActivity().isFinishing()) {
                        customWalletAlertDialog.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                UpiUtils.showReadPhoneStatePermissionDialog(getActivity(), Boolean.TRUE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        k.this.f();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        k.this.e();
                    }
                });
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        a(this.I);
    }

    /* access modifiers changed from: private */
    public void e() {
        this.s.setText(getString(R.string.upi_select_other_banks));
        this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
    }

    public final void a(int i2) {
        if (this.J) {
            try {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, CJRGTMConstants.GTM_EVENT_ACTION_UPI_BANK_SELECTED_DIALOG, (String) null, (String) null, "", "/", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            } catch (Exception unused) {
            }
        }
        this.s.setText(getString(R.string.upi_select_other_banks));
        if (i2 == -1) {
            this.s.setText(this.H.getAccountProvider());
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 1) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 2) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 3) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 4) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 5) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
        } else if (i2 == 6) {
            this.x.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68922a.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68923b.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68924c.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68925d.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68926e.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_select_bank));
            this.f68927f.setBackground(b.a((Context) getActivity(), R.drawable.bg_upi_selected_bank));
        }
    }
}
