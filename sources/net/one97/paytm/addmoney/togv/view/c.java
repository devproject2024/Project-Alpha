package net.one97.paytm.addmoney.togv.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.addmoney.togv.b.a;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;

public class c extends f implements a.b {

    /* renamed from: a  reason: collision with root package name */
    a f48801a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f48802b;

    /* renamed from: c  reason: collision with root package name */
    private String f48803c;

    /* renamed from: d  reason: collision with root package name */
    private String f48804d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f48805e;

    /* renamed from: f  reason: collision with root package name */
    private String f48806f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f48807g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f48808h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f48809i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private boolean o = false;
    /* access modifiers changed from: private */
    public a.C0856a p;
    private CustomWalletLoaderDialog q;
    private BottomSheetBehavior.a r = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                c.this.dismiss();
            }
        }
    };

    public interface a {
    }

    public final void a(NetworkCustomError networkCustomError) {
    }

    public c() {
    }

    public c(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.f48803c = str;
        this.f48804d = str2;
        this.f48805e = str3;
        this.f48806f = str4;
        this.f48807g = str5;
        this.f48808h = bool;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(false);
        if (i3 == -1 && i2 != 1007 && i2 == 1006) {
            if (this.f48808h.booleanValue()) {
                intent.setClass(getActivity().getApplicationContext(), AddMoneyToGvSelfStatusActivity.class);
            } else {
                intent.setClass(getActivity().getApplicationContext(), AddMoneyToGVStatusActivity.class);
            }
            intent.putExtra("do_check_order_status_by_polling", true);
            startActivity(intent);
            getActivity().finish();
        }
    }

    public final double c() {
        return Double.parseDouble(this.f48805e.replace(AppConstants.COMMA, ""));
    }

    public final String d() {
        return this.f48807g;
    }

    public final String e() {
        return this.f48804d;
    }

    public final void a(String str) {
        this.o = false;
        String string = getString(net.one97.paytm.addmoney.R.string.uam_error);
        String string2 = getString(net.one97.paytm.addmoney.R.string.uam_gv_sent_error);
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        d.a(getContext(), "gift_voucher", "gv_phonenumber_edit_error ", "/gift-voucher", (String) null, (String) null);
        final h hVar = new h(getContext());
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-3, getString(net.one97.paytm.addmoney.R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f48804d = str;
        }
        this.o = true;
    }

    public final void a(String str, String str2) {
        String string = getString(net.one97.paytm.addmoney.R.string.uam_error);
        if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
            string = getString(net.one97.paytm.addmoney.R.string.session_time_out);
        }
        String string2 = getString(net.one97.paytm.addmoney.R.string.uam_error_random);
        if (!TextUtils.isEmpty(str2)) {
            string2 = str2;
        }
        final h hVar = new h(getContext());
        hVar.setTitle(string);
        hVar.a(string2);
        hVar.a(-3, getString(net.one97.paytm.addmoney.R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public final void f() {
        a.C0856a aVar = this.p;
        if (aVar != null) {
            aVar.a(this.f48808h.booleanValue());
        }
    }

    public final void a(final CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
            a(false);
            if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError();
                String f2 = net.one97.paytm.helper.a.b().f("cartCheckout");
                if (!TextUtils.isEmpty(f2)) {
                    networkCustomVolleyError.setUrl(f2);
                    if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                        networkCustomVolleyError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                    }
                }
                net.one97.paytm.helper.a.b().a((Activity) getActivity(), (String) null, (Bundle) null);
            } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                b.a(getContext(), cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
            }
        } else if ("1".equals(cJRRechargePayment.isNativeEnabled())) {
            net.one97.paytm.helper.a.b().a(getActivity().getApplicationContext(), cJRRechargePayment, (net.one97.paytm.addmoney.togv.b.c) new net.one97.paytm.addmoney.togv.b.c() {
                public final void a() {
                    c.this.a(true);
                }

                public final void b() {
                    c.this.b(cJRRechargePayment);
                }

                public final void c() {
                    c.this.a(false);
                    c.this.b(cJRRechargePayment);
                }
            });
        } else {
            a(false);
            b(cJRRechargePayment);
        }
    }

    /* access modifiers changed from: private */
    public void b(CJRRechargePayment cJRRechargePayment) {
        Intent f2 = net.one97.paytm.helper.a.b().f((Activity) getActivity());
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("add_money_to_gv", true);
        net.one97.paytm.helper.a.b().a(cJRRechargePayment, f2);
        startActivityForResult(f2, 1006);
        a(false);
    }

    public final void b(final String str, String str2) {
        String string = getString(net.one97.paytm.addmoney.R.string.uam_error);
        if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
            string = getString(net.one97.paytm.addmoney.R.string.session_time_out);
        }
        String string2 = getString(net.one97.paytm.addmoney.R.string.uam_error_random);
        if (TextUtils.isEmpty(str2)) {
            str2 = string2;
        }
        final h hVar = new h(getContext());
        hVar.setTitle(string);
        hVar.a(str2);
        hVar.a(-3, getString(net.one97.paytm.addmoney.R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
                    c.a(c.this);
                }
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public final void g() {
        final h hVar = new h(getContext());
        hVar.setTitle(getResources().getString(net.one97.paytm.addmoney.R.string.session_time_out));
        hVar.a(getResources().getString(net.one97.paytm.addmoney.R.string.uam_session_timed_out_msg));
        hVar.a(-3, getString(net.one97.paytm.addmoney.R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
                c.a(c.this);
            }
        });
        hVar.show();
    }

    public final void a(boolean z) {
        try {
            if (this.q == null) {
                this.q = new CustomWalletLoaderDialog(getContext());
            }
            if (z) {
                if (this.q != null) {
                    this.q.setTitle(getString(net.one97.paytm.addmoney.R.string.uam_processing_request));
                    this.q.showLoader();
                }
            } else if (this.q != null) {
                this.q.dismissLoader();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.addmoney.R.layout.gift_voucher_preview, (ViewGroup) null);
        dialog.setContentView(inflate);
        this.f48802b = (ImageView) dialog.findViewById(net.one97.paytm.addmoney.R.id.iv_close);
        this.f48809i = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.tv_gv_recipient_name);
        if (TextUtils.isEmpty(this.f48804d)) {
            this.f48809i.setText(this.f48807g);
        } else {
            this.f48809i.setText(this.f48804d);
        }
        this.j = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.tv_gv_sender_name);
        TextView textView = this.j;
        textView.setText("From: " + this.f48803c);
        this.k = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.tv_gv_card_amount);
        TextView textView2 = this.k;
        textView2.setText(getString(net.one97.paytm.addmoney.R.string.rupees) + " " + this.f48805e);
        this.l = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.expiry_date);
        TextView textView3 = this.l;
        textView3.setText("Expiry: " + this.f48806f);
        this.n = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.tv_gv_card_gift_message);
        this.n.setText("Hey! Hope you like this gift voucher");
        this.m = (TextView) dialog.findViewById(net.one97.paytm.addmoney.R.id.btn_proceed);
        this.p = new net.one97.paytm.addmoney.togv.d.a(this, j.a(getActivity().getApplicationContext(), (Activity) getActivity()));
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!b.c((Context) c.this.getActivity())) {
                    c.f(c.this);
                } else if (!TextUtils.isEmpty(c.this.f48805e)) {
                    c.this.p.a(Double.parseDouble(c.this.f48805e.replace(AppConstants.COMMA, "")), c.this.f48807g, c.this.f48808h.booleanValue());
                } else {
                    Toast.makeText(c.this.getContext(), c.this.getString(net.one97.paytm.addmoney.R.string.some_went_wrong), 0).show();
                }
            }
        });
        this.f48802b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        try {
            ((View) inflate.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(c cVar) {
        net.one97.paytm.helper.a.b().h((Activity) cVar.getActivity());
        Intent a2 = net.one97.paytm.helper.a.b().a(cVar.getActivity());
        a2.addFlags(67108864);
        a2.addFlags(268435456);
        cVar.startActivity(a2);
        cVar.getActivity().finish();
    }

    static /* synthetic */ void f(c cVar) {
        final h hVar = new h(cVar.getActivity());
        hVar.setTitle(cVar.getResources().getString(net.one97.paytm.addmoney.R.string.no_connection));
        hVar.a(cVar.getResources().getString(net.one97.paytm.addmoney.R.string.no_internet));
        hVar.a(-3, cVar.getString(net.one97.paytm.addmoney.R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }
}
