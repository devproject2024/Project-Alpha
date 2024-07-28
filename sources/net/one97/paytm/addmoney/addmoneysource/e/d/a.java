package net.one97.paytm.addmoney.addmoneysource.e.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.e.a.a;
import net.one97.paytm.addmoney.addmoneysource.e.b.a.b;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.addmoney.utils.o;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusTxnWiseResponse;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList;
import net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject;
import net.one97.paytm.i.h;

public class a extends h implements a.b, net.one97.paytm.wallet.f.h {
    private TextView A;
    private TextView B;
    private TextView C;
    private LinearLayout D;
    private TextView E;
    private TextView F;
    private View G;
    private double H;
    /* access modifiers changed from: private */
    public CJRP2BStatus I;

    /* renamed from: a  reason: collision with root package name */
    public e f48298a;

    /* renamed from: b  reason: collision with root package name */
    private Button f48299b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f48300c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f48301d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f48302e;

    /* renamed from: f  reason: collision with root package name */
    private a.C0843a f48303f;

    /* renamed from: g  reason: collision with root package name */
    private int f48304g;

    /* renamed from: h  reason: collision with root package name */
    private double f48305h;

    /* renamed from: i  reason: collision with root package name */
    private String f48306i;
    private String j;
    private String k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public double n;
    /* access modifiers changed from: private */
    public double o;
    private double p;
    private double q;
    /* access modifiers changed from: private */
    public double r;
    private double s;
    private boolean t;
    private boolean u;
    private TextView v;
    private TextView w;
    private TextView x;
    private RelativeLayout y;
    private TextView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f48304g = arguments.getInt("destinationAddMoney", PaymentDestinationType.NO_CARD.getNumVal());
            this.f48305h = arguments.getDouble("amount");
            this.f48306i = arguments.getString("ppb_account_number");
            this.j = arguments.getString("ppb_account_name");
            this.k = arguments.getString("ppb_account_ifsc");
            this.l = arguments.getString("ppb_account_balance");
            this.s = arguments.getDouble("wallet_balance");
            this.t = arguments.getBoolean("openConfirmationDirectly");
            this.u = arguments.getBoolean("destroy_self", false);
        }
        this.n = 100.0d;
        this.o = 5000.0d;
        this.m = "NA";
        Context context = getContext();
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        this.f48303f = new net.one97.paytm.addmoney.addmoneysource.e.c.a(this, b.a(net.one97.paytm.addmoney.addmoneysource.e.b.a.a.a.a(context), net.one97.paytm.addmoney.addmoneysource.e.b.a.b.a.a(context)), this.f48304g);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_source_wallet, viewGroup, false);
        this.f48300c = (TextView) inflate.findViewById(R.id.tv_commission_header);
        this.f48301d = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f48302e = (LinearLayout) inflate.findViewById(R.id.ll_pay);
        this.f48299b = (Button) inflate.findViewById(R.id.btn_pay);
        this.f48299b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!j.a(Double.toString(a.this.r), a.this.n, a.this.o)) {
                    FragmentActivity activity = a.this.getActivity();
                    Toast.makeText(activity, "Net Payable amount should be between " + a.this.n + " - " + a.this.o, 0).show();
                } else if (a.this.I != null) {
                    a aVar = a.this;
                    aVar.b(aVar.I);
                }
            }
        });
        this.f48303f.a();
        return inflate;
    }

    public final void a() {
        a.C0843a aVar = this.f48303f;
        String str = this.k;
        String str2 = this.f48306i;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48305h);
        aVar.a(str, str2, sb.toString());
    }

    public final void a(CJRP2BStatus cJRP2BStatus) {
        this.I = cJRP2BStatus;
        if (!(cJRP2BStatus == null || cJRP2BStatus.getResponse() == null || cJRP2BStatus.getResponse().getStatusTxnWiseResponse() == null)) {
            CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = cJRP2BStatus.getResponse().getStatusTxnWiseResponse();
            try {
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getMinTxnAmount())) {
                    this.n = Double.parseDouble(statusTxnWiseResponse.getMinTxnAmount());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getMaxTxnAmount())) {
                    this.o = Double.parseDouble(statusTxnWiseResponse.getMaxTxnAmount());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getFixedCommission())) {
                    this.p = Double.parseDouble(statusTxnWiseResponse.getFixedCommission());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getFloatCommission())) {
                    this.q = Double.parseDouble(statusTxnWiseResponse.getFloatCommission());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int i2 = R.string.uam_pay_by_wallet;
        if (Double.compare(this.r, this.f48305h) < 0) {
            i2 = R.string.uam_add_to_source;
        }
        if (this.t && cJRP2BStatus != null) {
            b(cJRP2BStatus);
            this.f48299b.setText(String.format(getString(i2), new Object[]{Double.valueOf(this.r)}));
        }
    }

    public final void b(CJRP2BStatus cJRP2BStatus) {
        P2BCommissionMetaObject p2BCommissionMetaObject;
        String str = this.j;
        String str2 = this.f48306i;
        View inflate = getLayoutInflater().inflate(R.layout.uam_layout_p2b_confirmation_v2, (ViewGroup) null);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getActivity());
        aVar.setContentView(inflate);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                BottomSheetBehavior.this.setState(4);
            }
        });
        from.setState(2);
        from.setPeekHeight(com.paytm.utility.b.b((Activity) getActivity()) - com.paytm.utility.b.a(100.0f, (Context) getActivity()));
        aVar.show();
        this.v = (TextView) inflate.findViewById(R.id.know_more);
        this.w = (TextView) inflate.findViewById(R.id.terms_text);
        this.x = (TextView) inflate.findViewById(R.id.user_slab_text);
        this.y = (RelativeLayout) inflate.findViewById(R.id.user_slab_query_layout);
        this.z = (TextView) inflate.findViewById(R.id.tv_fee);
        this.A = (TextView) inflate.findViewById(R.id.tv_fee_label);
        this.B = (TextView) inflate.findViewById(R.id.tv_account_number);
        this.C = (TextView) inflate.findViewById(R.id.tv_account_holder_name);
        this.E = (TextView) inflate.findViewById(R.id.tv_amount_to_sent);
        this.F = (TextView) inflate.findViewById(R.id.tv_net_payable);
        this.D = (LinearLayout) inflate.findViewById(R.id.slab_layout);
        this.G = inflate.findViewById(R.id.include_summary);
        if (this.I != null) {
            CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = cJRP2BStatus.getResponse().getStatusTxnWiseResponse();
            p2BCommissionMetaObject = cJRP2BStatus.getResponse().getP2BCommissionMetaObject();
            if (p2BCommissionMetaObject != null) {
                this.H = p2BCommissionMetaObject.getCommissionAmount().doubleValue();
                this.r = p2BCommissionMetaObject.getTotalPayableAmount().doubleValue();
                this.q = Double.valueOf(statusTxnWiseResponse.getFloatCommission()).doubleValue();
            }
        } else {
            p2BCommissionMetaObject = null;
        }
        a(this.B, AddMoneyUtils.b("Paytm Payments Bank", str2));
        a(this.C, str);
        a(p2BCommissionMetaObject);
        inflate.findViewById(R.id.btn_proceed).setOnClickListener(new View.OnClickListener(aVar, str2, str) {
            private final /* synthetic */ com.google.android.material.bottomsheet.a f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                a.this.a(this.f$1, this.f$2, this.f$3, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.google.android.material.bottomsheet.a aVar, String str, String str2, View view) {
        aVar.cancel();
        String replace = str.replace("\\n", "").replace("\\r", "");
        String d2 = Double.toString(this.r);
        if (Double.compare(this.r, this.f48305h) < 0) {
            d2 = Double.toString(this.f48305h);
        }
        String str3 = d2;
        if (isAdded()) {
            String str4 = this.k;
            String l2 = com.paytm.utility.b.l((Context) getActivity());
            String str5 = this.m;
            StringBuilder sb = new StringBuilder();
            sb.append(this.H);
            String sb2 = sb.toString();
            String replace2 = replace.replace("\\n", "").replace("\\r", "");
            net.one97.paytm.helper.a.b().a((Context) getActivity(), str2, l2, o.P2B.getValue());
            if (isAdded()) {
                net.one97.paytm.helper.a.b().a(getActivity(), "P2B_TRANSFER", this, str2, str2, "Paytm Payments Bank", str4, replace2, l2, str3, str5, sb2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private void a(P2BCommissionMetaObject p2BCommissionMetaObject) {
        this.G.setVisibility(0);
        TextView textView = this.E;
        int i2 = R.string.uam_rs_amount_without_space;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48305h);
        textView.setText(getString(i2, com.paytm.utility.b.S(sb.toString())));
        TextView textView2 = this.F;
        int i3 = R.string.uam_rs_amount_without_space;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.r);
        textView2.setText(getString(i3, com.paytm.utility.b.S(sb2.toString())));
        b(p2BCommissionMetaObject);
    }

    private void b(P2BCommissionMetaObject p2BCommissionMetaObject) {
        List<FeeDetailsBreakupList> feeDetailsBreakupList = p2BCommissionMetaObject.getFeeDetailsBreakupList();
        LinearLayout linearLayout = this.D;
        if (linearLayout != null && feeDetailsBreakupList != null) {
            int size = feeDetailsBreakupList.size();
            int size2 = feeDetailsBreakupList.size();
            if (net.one97.paytm.helper.a.b().g("showTwoDifferentCharges") && size2 > 1) {
                this.w.setVisibility(0);
                String f2 = net.one97.paytm.helper.a.b().f("knowMoreTwoDifferentChargeLink");
                this.x.setText(getString(R.string.slab_text, Integer.valueOf(size2)));
                this.y.setVisibility(0);
                this.v.setOnClickListener(new View.OnClickListener(f2) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        a.this.a(this.f$1, view);
                    }
                });
            }
            for (int i2 = 0; i2 < feeDetailsBreakupList.size(); i2++) {
                FeeDetailsBreakupList feeDetailsBreakupList2 = feeDetailsBreakupList.get(i2);
                View inflate = LinearLayout.inflate(getContext(), R.layout.p2b_amount_row, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_fee_item_label_item);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_info_icon_item);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_fee_item);
                if (i2 != 0 || feeDetailsBreakupList2.getSlabFeePercentage().compareTo(Double.valueOf(0.0d)) == 0) {
                    imageView.setVisibility(8);
                }
                imageView.setOnClickListener(new View.OnClickListener(feeDetailsBreakupList2, feeDetailsBreakupList) {
                    private final /* synthetic */ FeeDetailsBreakupList f$1;
                    private final /* synthetic */ List f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        a.this.a(this.f$1, this.f$2, view);
                    }
                });
                if (size > 1) {
                    textView.setText(getString(R.string.p2b_fee_with_interest_slab, feeDetailsBreakupList2.getSlabTxnAmount().toString(), feeDetailsBreakupList2.getSlabFeePercentage().toString()));
                } else {
                    textView.setText(getString(R.string.p2b_fee_with_interest_new, feeDetailsBreakupList2.getSlabFeePercentage().toString()));
                }
                int i3 = R.string.uam_rs_amount_without_space;
                StringBuilder sb = new StringBuilder();
                sb.append(feeDetailsBreakupList2.getSlabFeeAmount());
                textView2.setText(getString(i3, com.paytm.utility.b.S(sb.toString())));
                linearLayout.addView(inflate);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(FeeDetailsBreakupList feeDetailsBreakupList, List list, View view) {
        double doubleValue = feeDetailsBreakupList.getSlabFeePercentage().doubleValue();
        View inflate = getLayoutInflater().inflate(R.layout.p2b_informatory_popup, (ViewGroup) null);
        if (getContext() != null && getActivity() != null && !getActivity().isFinishing()) {
            final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getContext(), R.style.p2bAppBottomSheetDialogTheme);
            aVar.setContentView(inflate);
            final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                }
            });
            from.setBottomSheetCallback(new BottomSheetBehavior.a() {
                public final void onStateChanged(View view, int i2) {
                }

                public final void onSlide(View view, float f2) {
                    aVar.cancel();
                }
            });
            from.setState(2);
            from.setPeekHeight(com.paytm.utility.b.b((Activity) getActivity()));
            aVar.getWindow().setSoftInputMode(16);
            aVar.show();
            inflate.findViewById(R.id.iv_cross).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.cancel();
                }
            });
            inflate.findViewById(R.id.tv_i_understand).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.cancel();
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_info_via_money_transfer);
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_pop_up_text);
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_rbi_guideline);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_transfer_flow);
            if (list == null || list.size() <= 1) {
                textView.setText(getString(R.string.p2b_interest_charge, String.valueOf(doubleValue)));
                textView4.setText(getString(R.string.p2b_rbi_guideline, String.valueOf(doubleValue)));
            } else {
                textView.setText(getString(R.string.p2b_slab_heading));
                textView4.setText(AddMoneyUtils.a((Context) getActivity(), (List<FeeDetailsBreakupList>) list));
            }
            textView3.setVisibility(8);
            textView4.setVisibility(0);
            textView2.setVisibility(0);
            imageView.setVisibility(0);
            try {
                String string = getString(R.string.p2b_recommend_via_money_transfer);
                SpannableString spannableString = new SpannableString(string);
                int indexOf = string.indexOf(getString(R.string.p2b_money_transfer));
                if (indexOf > 0) {
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            a.this.startActivity(net.one97.paytm.helper.a.b().c((Activity) a.this.getActivity()));
                            a.this.getActivity().finish();
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(a.this.getResources().getColor(R.color.blue));
                            textPaint.setUnderlineText(false);
                        }
                    }, indexOf, getString(R.string.p2b_recommend_via_money_transfer).length(), 33);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                }
                textView2.setText(spannableString);
            } catch (Exception unused) {
            }
        }
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f48303f.b();
    }

    public final void a(boolean z2) {
        if (z2) {
            this.f48302e.setVisibility(8);
            AddMoneyUtils.a(this.f48301d);
            return;
        }
        this.f48302e.setVisibility(0);
        AddMoneyUtils.b(this.f48301d);
    }

    public final void a(IJRDataModel iJRDataModel) {
        if (isAdded()) {
            if (this.u) {
                getActivity().setResult(-1);
            } else if (iJRDataModel instanceof CJRSendMoney) {
                Intent intent = new Intent(getActivity(), AddMoneyStatusActivity.class);
                intent.putExtra("sourceAddMoney", SourceCardType.WALLET.getNumVal());
                intent.putExtra("destinationAddMoney", this.f48304g);
                intent.putExtra("account_no", this.f48306i);
                intent.putExtra("available_balance", this.l);
                intent.putExtra("Amount", this.f48305h);
                intent.putExtra("sourceName", getString(R.string.uam_wallet_open_layout_header_title));
                intent.putExtra("sourceImage", "");
                intent.putExtra("payment_response_object", iJRDataModel);
                startActivity(intent);
            } else if (iJRDataModel instanceof CJRValidateTransaction) {
                Intent intent2 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                intent2.putExtra("sourceAddMoney", SourceCardType.WALLET.getNumVal());
                intent2.putExtra("destinationAddMoney", this.f48304g);
                intent2.putExtra("account_no", this.f48306i);
                intent2.putExtra("available_balance", this.l);
                intent2.putExtra("Amount", this.f48305h);
                intent2.putExtra("sourceName", getString(R.string.uam_wallet_open_layout_header_title));
                intent2.putExtra("sourceImage", "");
                intent2.putExtra("payment_response_object", iJRDataModel);
                startActivity(intent2);
            }
            getActivity().finish();
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }
}
