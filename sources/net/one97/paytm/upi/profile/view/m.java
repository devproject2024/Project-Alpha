package net.one97.paytm.upi.profile.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.b;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.a.i;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public class m extends h implements i.b {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f68310a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68311b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68312c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68313d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68314e;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f68315f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f68316g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public i.a f68317h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f68318i = false;
    private String j;
    private BankAccountDetails.BankAccount k;

    public final /* synthetic */ void a(Object obj) {
        this.f68317h = (i.a) obj;
        this.f68317h.e();
    }

    public static m a(UpiProfileDefaultBank upiProfileDefaultBank, boolean z) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.KEY_PROFILE_VPA_INFO, upiProfileDefaultBank);
        bundle.putBoolean(UpiConstants.UPI_IS_SHOW_SELECT_BANK_BOTTOM_SHEET_ON_LAUNCH, z);
        mVar.setArguments(bundle);
        return mVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_profile_qr, viewGroup, false);
        this.f68315f = (FrameLayout) inflate.findViewById(R.id.fl_qr_container);
        this.f68310a = (ImageView) inflate.findViewById(R.id.qr_image);
        this.f68311b = (TextView) inflate.findViewById(R.id.tv_qr_vpa);
        this.f68313d = (TextView) inflate.findViewById(R.id.tv_bank_account);
        this.f68314e = (TextView) inflate.findViewById(R.id.tv_primary_account);
        this.f68312c = (TextView) inflate.findViewById(R.id.tv_tap_enlarge);
        this.f68313d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (PaytmUpiPrefUtil.getPref(m.this.getContext().getApplicationContext()).b((String) UpiConstants.PREF_KEY_IS_UPI_PROFILE_TIP_CLICKED, false, true)) {
                    m.this.c();
                } else {
                    m.c(m.this);
                }
            }
        });
        inflate.findViewById(R.id.qr_layout).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.f68317h.b();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void c() {
        o.a(this.j, this.k).show(getChildFragmentManager(), "UpiSelectDefaultAccountFragment");
    }

    public final void b() {
        Intent intent = new Intent(getActivity(), UpiQrCodeActivity.class);
        intent.putExtra(UpiConstants.EXTRA_VPA_DATA, this.f68317h.a());
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().startActivity(intent, b.a(getActivity(), this.f68315f, "qr").a());
            return;
        }
        getActivity().startActivity(intent);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            getActivity();
            new net.one97.paytm.upi.profile.presenter.i(g.a(), this, (UpiProfileDefaultBank) getArguments().get(UpiConstants.KEY_PROFILE_VPA_INFO));
            this.f68318i = getArguments().getBoolean(UpiConstants.UPI_IS_SHOW_SELECT_BANK_BOTTOM_SHEET_ON_LAUNCH);
            if (this.f68318i) {
                this.f68318i = false;
                c();
            }
        }
    }

    public final void a(String str, BankAccountDetails.BankAccount bankAccount, String str2) {
        this.j = str;
        this.k = bankAccount;
        if (bankAccount == null) {
            this.f68312c.setVisibility(8);
        }
        try {
            this.f68310a.setImageBitmap(UpiAppUtils.generateQR(str2, getContext(), UpiAppUtils.convertDpToPixel(110.0f, getContext()), UpiAppUtils.convertDpToPixel(110.0f, getContext()), false));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f68311b.setText(str);
        if (this.k != null) {
            this.f68313d.setVisibility(0);
            TextView textView = this.f68313d;
            textView.setText(this.k.getBankName() + " XX " + this.k.getAccRefNumber().substring(this.k.getAccRefNumber().length() - 4));
            return;
        }
        this.f68313d.setVisibility(8);
    }

    public final void a() {
        String string = getString(R.string.please_add_a_bank_account);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string);
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    static /* synthetic */ void c(m mVar) {
        PopupWindow popupWindow = mVar.f68316g;
        if (popupWindow == null || !popupWindow.isShowing()) {
            View inflate = ((LayoutInflater) mVar.getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_upi_profile_tip, (ViewGroup) null);
            mVar.f68316g = new PopupWindow(inflate, -2, -2);
            if (Build.VERSION.SDK_INT >= 21) {
                mVar.f68316g.setElevation(5.0f);
            }
            inflate.findViewById(R.id.tv_upi_tip_ok).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (m.this.getContext() != null) {
                        PaytmUpiPrefUtil.getPref(m.this.getContext().getApplicationContext()).a(UpiConstants.PREF_KEY_IS_UPI_PROFILE_TIP_CLICKED, true, true);
                        m.this.c();
                        m.this.f68316g.dismiss();
                    }
                }
            });
            mVar.f68316g.setOutsideTouchable(true);
            mVar.f68316g.showAsDropDown(mVar.f68313d);
        }
    }
}
