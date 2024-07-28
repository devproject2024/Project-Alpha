package net.one97.paytm.upi.requestmoney.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.VolleyError;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Random;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.passbook.b.a.b;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CircularImageView;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UpiWebViewActivity;

public class g extends h implements View.OnClickListener {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public UpiPendingRequestModel f69443a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<String> f69444b = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private TextView f69445c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f69446d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f69447e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f69448f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f69449g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f69450h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f69451i;
    /* access modifiers changed from: private */
    public Button j;
    private Button k;
    /* access modifiers changed from: private */
    public a l;
    /* access modifiers changed from: private */
    public Activity m;
    /* access modifiers changed from: private */
    public LottieAnimationView n;
    private CircularImageView o;
    /* access modifiers changed from: private */
    public String p = "UPIRequestMoneyPagerFragment";
    /* access modifiers changed from: private */
    public final String q = g.class.getSimpleName();
    private b r;

    public interface a {
        void a();

        void a(String str);
    }

    public static g a(UpiPendingRequestModel upiPendingRequestModel) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("upiPendingRequestModel", upiPendingRequestModel);
        gVar.setArguments(bundle);
        return gVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_request_money_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f69443a = (UpiPendingRequestModel) arguments.getSerializable("upiPendingRequestModel");
        }
        this.f69445c = (TextView) inflate.findViewById(R.id.upi_bank_name);
        this.f69446d = (TextView) inflate.findViewById(R.id.upi_bank_upiid);
        this.f69447e = (TextView) inflate.findViewById(R.id.tv_upi_amount);
        this.f69448f = (TextView) inflate.findViewById(R.id.upi_name_caption);
        this.f69449g = (TextView) inflate.findViewById(R.id.tv_order_details);
        this.k = (Button) inflate.findViewById(R.id.upi_pay);
        this.j = (Button) inflate.findViewById(R.id.upi_decline);
        this.n = (LottieAnimationView) inflate.findViewById(R.id.upi_progressBar);
        this.n.setVisibility(8);
        this.o = (CircularImageView) inflate.findViewById(R.id.imageView13);
        this.f69450h = (TextView) inflate.findViewById(R.id.upi_pay);
        this.f69448f.setBackgroundColor(Color.parseColor(this.f69444b.get(new Random().nextInt(9))));
        if (!UpiGTMLoader.getInstance().isOrderDetailsEnabled() || !"02".equalsIgnoreCase(this.f69443a.getRefCategory()) || TextUtils.isEmpty(this.f69443a.getRefUrl())) {
            this.f69449g.setVisibility(8);
        } else {
            this.f69449g.setVisibility(0);
        }
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.a(g.this);
                g.this.a(Events.Action.COLLECT_REQ_PAY_CLICKED);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.j.setVisibility(4);
                g.this.j.setEnabled(false);
                g.this.j.setClickable(false);
                g.this.n.setVisibility(8);
                g.this.getContext();
                net.one97.paytm.upi.g.b().a(new a.C1379a() {
                    public final void a(UpiBaseDataModel upiBaseDataModel) {
                    }

                    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                    }
                }, g.this.p, "", g.this.f69443a.getPayeeVa(), g.this.f69443a.getPayerVa(), g.this.f69443a.getAmount(), g.this.f69443a.getNote(), g.this.f69443a.getAmount(), g.this.f69443a.getTxnId(), "R", "A", g.this.q);
                g.this.j.setVisibility(0);
                g.this.j.setEnabled(true);
                g.this.j.setClickable(true);
                g.this.l.a();
                g.this.a(Events.Action.COLLECT_REQ_DECLINE_CLICKED);
            }
        });
        this.f69449g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiWebViewActivity.Companion.startActivity(g.this.getActivity(), g.this.f69443a.getRefUrl());
            }
        });
        this.f69451i = (TextView) inflate.findViewById(R.id.upi_mark_spam);
        this.f69451i.setOnClickListener(this);
        this.f69445c.setText(this.f69443a.getPayeeName());
        String str = getString(R.string.upi_rupee) + UpiAppUtils.priceToString(this.f69443a.getAmount());
        this.f69447e.setText(str);
        this.f69446d.setText(getString(R.string.request_money_upi_pending_dialog) + this.f69443a.getPayeeVa());
        this.f69450h.setText(getContext().getResources().getString(R.string.upi_pay) + " " + str);
        this.f69448f.setText(UpiUtils.getNameInitials(this.f69443a.getPayeeName().replace("  ", " ")).toUpperCase());
        if (!TextUtils.isEmpty(this.f69443a.getLogoUrl())) {
            this.f69448f.setVisibility(8);
            this.f69448f.setVisibility(8);
            this.o.setVisibility(0);
            w.a().a(this.f69443a.getLogoUrl()).a((ImageView) this.o, (e) null);
        } else {
            this.f69448f.setVisibility(0);
            this.f69448f.setVisibility(0);
            this.o.setVisibility(8);
        }
        return inflate;
    }

    public void onClick(View view) {
        b bVar;
        if (view.getId() == R.id.upi_mark_spam && (bVar = this.r) != null) {
            bVar.a(new a.b() {
                public final void a(VolleyError volleyError) {
                }

                public final void a(UpiBaseDataModel upiBaseDataModel) {
                }
            }, "", this.f69443a.getPayeeVa(), this.f69443a.getPayerVa(), "A", this.q);
            this.l.a(this.f69443a.getPayeeName());
            a(Events.Action.COLLECT_REQ_SPAM_CLICKED);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.m = (Activity) context;
            this.l = (a) this.m;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity();
        this.r = net.one97.paytm.upi.g.b();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (this.f69443a != null) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), Events.Category.COLLECT, str, Events.Label.HOMEPAGE_POPUP, this.f69443a.getRefCategory(), "", this.f69443a.getPayeeVa(), "", Events.Screen.PAYTM_HOMEPAGE, "");
        }
    }

    static /* synthetic */ void a(g gVar) {
        gVar.n.setVisibility(0);
        AnimationFactory.startWalletLoader(gVar.n);
        gVar.k.setEnabled(false);
        gVar.k.setVisibility(4);
        gVar.getActivity();
        net.one97.paytm.upi.g.c().a(new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                g.h(g.this);
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                        for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                            if (next.getDebitBank() != null && next.getDebitBank().getAccount() != null && next.getVirtualAddress().equalsIgnoreCase(g.this.f69443a.getPayerVa())) {
                                next.setVirtualAddress(g.this.f69443a.getPayerVa());
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                                bundle.putString("amount", g.this.f69443a.getAmount());
                                bundle.putString("payee_name", g.this.f69443a.getPayeeName());
                                bundle.putString("payee_vpa", g.this.f69443a.getPayeeVa());
                                bundle.putString(UpiConstants.EXTRA_PAYER_VPA, g.this.f69443a.getPayerVa());
                                bundle.putSerializable("user_upi_details", next);
                                bundle.putBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST, true);
                                bundle.putString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, g.this.f69443a.getTxnId());
                                bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, g.this.f69443a.getTxnId());
                                bundle.putBoolean(UpiConstants.UPI_IS_VERIFIED_MERCHANT, g.this.f69443a.isVerifiedMerchant());
                                bundle.putInt(UpiConstants.EXTRA_COLLECT_REQUEST_BANK_LIST_SIZE, upiProfileModel.getResponse().getProfileDetail().getBankAccountList().size());
                                i.a().m.a((Context) g.this.getActivity(), bundle);
                                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(g.this.getContext(), Events.Category.COLLECT, "screen_open", Events.Label.HOMEPAGE_POPUP, "", "", g.this.f69443a.getPayeeVa(), g.this.f69443a.getAmount(), Events.Screen.ENTER_AMOUNT, "wallet");
                                g.this.m.finish();
                                return;
                            }
                        }
                    }
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                g.h(g.this);
                g gVar = g.this;
                if (upiCustomVolleyError == null) {
                    return;
                }
                if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
                    k kVar = i.a().k;
                    FragmentActivity activity = gVar.getActivity();
                    new UpiCustomVolleyError();
                    kVar.e(activity);
                    return;
                }
                CustomDialog.showAlert(gVar.getActivity(), "Error", upiCustomVolleyError.getAlertMessage());
            }
        }, "", "");
    }

    static /* synthetic */ void h(g gVar) {
        gVar.n.setVisibility(8);
        AnimationFactory.stopWalletLoader(gVar.n);
        gVar.k.setEnabled(true);
        gVar.k.setVisibility(0);
    }
}
