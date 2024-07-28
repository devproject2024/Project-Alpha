package net.one97.paytm.addmoney.common.view.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.netbanking.view.b;
import net.one97.paytm.addmoney.common.a.a;
import net.one97.paytm.addmoney.common.model.AccountBalanceModel;
import net.one97.paytm.addmoney.common.model.SourceCardDataModel;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.utils.AddMoneyCardView;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends RecyclerView.a<C0850a> {

    /* renamed from: a  reason: collision with root package name */
    Context f48534a;

    /* renamed from: b  reason: collision with root package name */
    Fragment f48535b;

    /* renamed from: c  reason: collision with root package name */
    a.C0849a f48536c;

    /* renamed from: d  reason: collision with root package name */
    int f48537d;

    /* renamed from: e  reason: collision with root package name */
    boolean f48538e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f48536c.a(i2, (C0850a) vVar);
    }

    public a(Fragment fragment, a.C0849a aVar, int i2, boolean z) {
        this.f48534a = fragment.getActivity();
        this.f48535b = fragment;
        this.f48536c = aVar;
        this.f48537d = i2;
        this.f48538e = z;
    }

    public final int getItemCount() {
        return this.f48536c.c();
    }

    /* access modifiers changed from: package-private */
    public final double a() {
        try {
            if (this.f48535b == null || !this.f48535b.isAdded() || !(this.f48535b instanceof net.one97.paytm.addmoney.common.view.a)) {
                return 0.0d;
            }
            return ((net.one97.paytm.addmoney.common.view.a) this.f48535b).d();
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    /* renamed from: net.one97.paytm.addmoney.common.view.a.a$a  reason: collision with other inner class name */
    class C0850a extends RecyclerView.v implements a.b {
        public C0850a(View view) {
            super(view);
        }

        public final AddMoneyCardView a(SourceCardDataModel sourceCardDataModel) {
            SourceCardType type = sourceCardDataModel.getType();
            AddMoneyCardView addMoneyCardView = (AddMoneyCardView) this.itemView.findViewById(R.id.source_card);
            addMoneyCardView.setContentVisibility(0);
            addMoneyCardView.setId(b(sourceCardDataModel.getType()));
            addMoneyCardView.setRadioButtonCheck(sourceCardDataModel.isOpenInInnerContainer());
            if (type == SourceCardType.BHIM_UPI) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_bhim_upi_source_card_title));
                addMoneyCardView.setIcon(R.drawable.uam_upi_source_list_icon_addmoney);
                addMoneyCardView.setSubTitle((String) null);
                addMoneyCardView.b(false);
            } else if (type == SourceCardType.DEBIT_CARD) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_debit_card_source_card_title));
                addMoneyCardView.setIcon(R.drawable.uam_dc_source_list_icon);
                addMoneyCardView.setSubTitle(a.this.f48534a.getString(R.string.txt_wallet_amount_limit));
                addMoneyCardView.b(true);
            } else if (type == SourceCardType.CREDIT_CARD) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_credit_card_source_card_title));
                addMoneyCardView.setIcon(R.drawable.uam_dc_source_list_icon);
                addMoneyCardView.setSubTitle((String) null);
                addMoneyCardView.b(false);
            } else if (type == SourceCardType.FD) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.add_money_break_your_fixed_deposit));
                addMoneyCardView.setIcon(R.drawable.uam_upi_source_list_icon_addmoney);
                if (sourceCardDataModel.getDataModel() instanceof AccountBalanceModel) {
                    double slfdBalance = ((AccountBalanceModel) sourceCardDataModel.getDataModel()).getSlfdBalance();
                    if (slfdBalance != Double.MIN_NORMAL) {
                        addMoneyCardView.setSubTitle(String.format(a.this.f48534a.getString(R.string.uam_available_paytm_balance), new Object[]{AddMoneyUtils.d(String.valueOf(slfdBalance))}));
                    }
                } else {
                    addMoneyCardView.setSubTitle((String) null);
                    addMoneyCardView.b(false);
                }
            } else if (type == SourceCardType.NET_BANKING) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_source_netbanking));
                addMoneyCardView.setIcon(R.drawable.uam_nb_soure_list_icon);
                addMoneyCardView.setSubTitle((String) null);
                addMoneyCardView.b(false);
            } else if (type == SourceCardType.WALLET) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_wallet_source_card_title_new));
                addMoneyCardView.setIcon(R.drawable.uam_wallet_source_list_icon);
                double h2 = a.this.f48536c.h();
                if (Double.compare(h2, 0.0d) < 0) {
                    addMoneyCardView.setSubTitle(String.format(a.this.f48534a.getString(R.string.uam_available_paytm_balance), new Object[]{"--"}));
                } else {
                    addMoneyCardView.setSubTitle(String.format(a.this.f48534a.getString(R.string.uam_available_paytm_balance), new Object[]{Double.valueOf(h2)}));
                }
                addMoneyCardView.setInfoIconVisibility(8);
                addMoneyCardView.setInfoViewClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (Double.compare(a.this.f48536c.f(), 0.0d) >= 0) {
                            View inflate = LayoutInflater.from(a.this.f48534a).inflate(R.layout.uam_dialog_p2b_transaction_fee, (ViewGroup) null);
                            final AlertDialog create = new AlertDialog.Builder(a.this.f48534a).create();
                            create.setView(inflate);
                            inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    create.dismiss();
                                }
                            });
                            ((TextView) inflate.findViewById(R.id.tv_fee_desc)).setText(a.this.f48534a.getString(R.string.uam_dialog_fee_desc));
                            if (Double.compare(a.this.f48536c.g(), 0.0d) > 0) {
                                inflate.findViewById(R.id.ll_amount).setVisibility(0);
                                ((TextView) inflate.findViewById(R.id.tv_paytm_balance)).setText(String.format(a.this.f48534a.getString(R.string.uam_rs_amount), new Object[]{Double.valueOf(a.this.f48536c.f())}));
                                ((TextView) inflate.findViewById(R.id.tv_transaction_fee)).setText(String.format(a.this.f48534a.getString(R.string.uam_rs_amount), new Object[]{Double.valueOf(a.this.f48536c.i())}));
                                ((TextView) inflate.findViewById(R.id.tv_available_for_transfer)).setText(String.format(a.this.f48534a.getString(R.string.uam_rs_amount), new Object[]{Double.valueOf(a.this.f48536c.h())}));
                            } else {
                                inflate.findViewById(R.id.ll_amount).setVisibility(8);
                            }
                            create.show();
                        }
                    }
                });
            } else if (type == SourceCardType.GOLD) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_gold_source_card_title));
                addMoneyCardView.setIcon(R.drawable.bhim_upi_addmoney);
                addMoneyCardView.setSubTitle((String) null);
                addMoneyCardView.b(false);
            } else if (type == SourceCardType.OTHER_BANKS) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_ppb_src_another_bank));
                addMoneyCardView.setIcon(R.drawable.uam_ob_source_list_icon);
                addMoneyCardView.setSubTitle((String) null);
                addMoneyCardView.b(false);
            } else if (type == SourceCardType.PPB) {
                addMoneyCardView.setTitle(a.this.f48534a.getString(R.string.uam_source_ppb));
                addMoneyCardView.setIcon(R.drawable.uam_ppb_header_icon);
                String o = a.this.f48536c.o();
                if (TextUtils.isEmpty(o)) {
                    addMoneyCardView.setSubTitle((String) null);
                } else {
                    addMoneyCardView.setSubTitle(a.this.f48534a.getString(R.string.upi_ppb_account_number, new Object[]{o}));
                }
                if (addMoneyCardView.f48902i != null) {
                    addMoneyCardView.f48902i.setVisibility(8);
                }
            } else if (type == SourceCardType.PAYMENT_ITEM_TYPE_UPI || type == SourceCardType.PAYMENT_ITEM_TYPE_DC || type == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                addMoneyCardView.setContentVisibility(8);
            }
            return addMoneyCardView;
        }

        public final void a(final int i2) {
            this.itemView.setTag(Integer.valueOf(i2));
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    a aVar = a.this;
                    int i2 = i2;
                    Intent intent = new Intent("payment_item_selected");
                    intent.putExtra("payment_item_type", i2);
                    androidx.localbroadcastmanager.a.a.a(aVar.f48534a).a(intent);
                    a.this.f48536c.a(intValue);
                    a aVar2 = a.this;
                    int i3 = i2;
                    if (aVar2.f48535b != null && aVar2.f48535b.isAdded() && (aVar2.f48535b instanceof net.one97.paytm.addmoney.common.view.a)) {
                        ((net.one97.paytm.addmoney.common.view.a) aVar2.f48535b).d(i3);
                    }
                }
            });
        }

        public final void a(double d2) {
            ((AddMoneyCardView) this.itemView.findViewById(R.id.source_card)).setTransactionFee(d2);
        }

        public final void a(final SourceCardDataModel sourceCardDataModel, boolean z, final View view) {
            try {
                Fragment c2 = a.this.f48535b.getChildFragmentManager().c(a(sourceCardDataModel.getType()));
                if (z) {
                    if (c2 == null) {
                        new Handler().postDelayed(new Runnable() {
                            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0178, code lost:
                                r3 = net.one97.paytm.addmoney.utils.c.a().f48963f;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                    r14 = this;
                                    android.view.View r0 = r6
                                    if (r0 == 0) goto L_0x032d
                                    net.one97.paytm.addmoney.common.model.SourceCardDataModel r1 = r4
                                    net.one97.paytm.addmoney.common.model.SourceCardType r1 = r1.getType()
                                    int r1 = net.one97.paytm.addmoney.common.view.a.a.C0850a.b(r1)
                                    android.view.View r0 = r0.findViewById(r1)
                                    if (r0 == 0) goto L_0x032d
                                    int r0 = android.os.Build.VERSION.SDK_INT
                                    r1 = 19
                                    if (r0 < r1) goto L_0x0022
                                    android.view.View r0 = r6
                                    boolean r0 = r0.isAttachedToWindow()
                                    if (r0 == 0) goto L_0x032d
                                L_0x0022:
                                    net.one97.paytm.addmoney.common.view.a.a$a r1 = net.one97.paytm.addmoney.common.view.a.a.C0850a.this
                                    net.one97.paytm.addmoney.common.model.SourceCardDataModel r0 = r4
                                    net.one97.paytm.addmoney.common.model.SourceCardType r0 = r0.getType()
                                    java.lang.String r5 = net.one97.paytm.addmoney.common.view.a.a.C0850a.a((net.one97.paytm.addmoney.common.model.SourceCardType) r0)
                                    int r6 = net.one97.paytm.addmoney.common.view.a.a.C0850a.b(r0)
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.BHIM_UPI
                                    if (r0 != r2) goto L_0x008f
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    net.one97.paytm.addmoney.common.model.PaymentDestinationType r3 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_PAYTM_BANK
                                    int r3 = r3.getNumVal()
                                    if (r2 != r3) goto L_0x0075
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    java.lang.String r3 = r2.e()
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    net.one97.paytm.common.entity.paymentsbank.CustProductList r2 = r2.k()
                                    boolean r4 = android.text.TextUtils.isEmpty(r3)
                                    if (r4 != 0) goto L_0x006d
                                    if (r2 == 0) goto L_0x006d
                                    java.lang.String r4 = r2.getIsaAccNum()
                                    java.lang.String r7 = r2.getIsaIfsc()
                                    int r0 = r0.getNumVal()
                                    r2 = r4
                                    r4 = r7
                                    r7 = r0
                                    r1.a(r2, r3, r4, r5, r6, r7)
                                    return
                                L_0x006d:
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r0 = r0.f48536c
                                    r0.d()
                                    return
                                L_0x0075:
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    net.one97.paytm.addmoney.common.model.PaymentDestinationType r3 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_WALLET
                                    int r3 = r3.getNumVal()
                                    if (r2 != r3) goto L_0x032d
                                    int r7 = r0.getNumVal()
                                    java.lang.String r2 = ""
                                    java.lang.String r3 = ""
                                    java.lang.String r4 = ""
                                    r1.a(r2, r3, r4, r5, r6, r7)
                                    return
                                L_0x008f:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.DEBIT_CARD
                                    r3 = 1
                                    if (r0 != r2) goto L_0x009c
                                    int r0 = r0.getNumVal()
                                    r1.a(r3, r5, r6, r0)
                                    return
                                L_0x009c:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.CREDIT_CARD
                                    r4 = 0
                                    if (r0 != r2) goto L_0x00a9
                                    int r0 = r0.getNumVal()
                                    r1.a(r4, r5, r6, r0)
                                    return
                                L_0x00a9:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.WALLET
                                    java.lang.String r7 = "ppb_account_ifsc"
                                    java.lang.String r8 = "ppb_account_number"
                                    java.lang.String r9 = "amount"
                                    java.lang.String r10 = "destinationAddMoney"
                                    java.lang.String r11 = "destroy_self"
                                    if (r0 != r2) goto L_0x015a
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    java.lang.String r2 = r2.e()
                                    net.one97.paytm.addmoney.common.view.a.a r4 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r4 = r4.f48536c
                                    net.one97.paytm.common.entity.paymentsbank.CustProductList r4 = r4.k()
                                    boolean r12 = android.text.TextUtils.isEmpty(r2)
                                    if (r12 != 0) goto L_0x0152
                                    if (r4 == 0) goto L_0x0152
                                    java.lang.String r12 = r4.getIsaAccNum()
                                    java.lang.String r4 = r4.getIsaIfsc()
                                    r0.getNumVal()
                                    android.os.Bundle r0 = new android.os.Bundle
                                    r0.<init>()
                                    net.one97.paytm.addmoney.common.view.a.a r13 = net.one97.paytm.addmoney.common.view.a.a.this
                                    boolean r13 = r13.f48538e
                                    r0.putBoolean(r11, r13)
                                    net.one97.paytm.addmoney.common.view.a.a r11 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r11 = r11.f48537d
                                    r0.putInt(r10, r11)
                                    net.one97.paytm.addmoney.common.view.a.a r10 = net.one97.paytm.addmoney.common.view.a.a.this
                                    double r10 = r10.a()
                                    r0.putDouble(r9, r10)
                                    r0.putString(r8, r12)
                                    java.lang.String r8 = "ppb_account_name"
                                    r0.putString(r8, r2)
                                    r0.putString(r7, r4)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    double r7 = r2.f()
                                    java.lang.String r2 = "wallet_balance"
                                    r0.putDouble(r2, r7)
                                    java.lang.String r2 = "openConfirmationDirectly"
                                    r0.putBoolean(r2, r3)
                                    net.one97.paytm.addmoney.addmoneysource.e.d.a r2 = new net.one97.paytm.addmoney.addmoneysource.e.d.a
                                    r2.<init>()
                                    r2.setArguments(r0)
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    net.one97.paytm.addmoney.utils.e r0 = (net.one97.paytm.addmoney.utils.e) r0
                                    r2.f48298a = r0
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    if (r0 == 0) goto L_0x0151
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                    if (r0 == 0) goto L_0x0151
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    boolean r0 = r0.isAdded()
                                    if (r0 == 0) goto L_0x0151
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.j r0 = r0.getChildFragmentManager()
                                    androidx.fragment.app.q r0 = r0.a()
                                    androidx.fragment.app.q r0 = r0.b(r6, r2, r5)
                                    r0.c()
                                L_0x0151:
                                    return
                                L_0x0152:
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r0 = r0.f48536c
                                    r0.d()
                                    return
                                L_0x015a:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.OTHER_BANKS
                                    if (r0 != r2) goto L_0x01df
                                    r0.getNumVal()
                                    net.one97.paytm.addmoney.addmoneysource.b.d.a r0 = new net.one97.paytm.addmoney.addmoneysource.b.d.a
                                    r0.<init>()
                                    android.os.Bundle r2 = new android.os.Bundle
                                    r2.<init>()
                                    net.one97.paytm.addmoney.common.view.a.a r3 = net.one97.paytm.addmoney.common.view.a.a.this
                                    boolean r3 = r3.f48538e
                                    r2.putBoolean(r11, r3)
                                    net.one97.paytm.addmoney.utils.c r3 = net.one97.paytm.addmoney.utils.c.a()
                                    if (r3 == 0) goto L_0x0185
                                    net.one97.paytm.addmoney.utils.c r3 = net.one97.paytm.addmoney.utils.c.a()
                                    net.one97.paytm.common.entity.paymentsbank.CustProductList r3 = r3.f48963f
                                    if (r3 == 0) goto L_0x0185
                                    java.lang.String r3 = r3.getIsaAccNum()
                                    goto L_0x0187
                                L_0x0185:
                                    java.lang.String r3 = ""
                                L_0x0187:
                                    r2.putString(r8, r3)
                                    net.one97.paytm.addmoney.common.view.a.a r3 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r3 = r3.f48537d
                                    r2.putInt(r10, r3)
                                    net.one97.paytm.addmoney.utils.c r3 = net.one97.paytm.addmoney.utils.c.a()
                                    if (r3 == 0) goto L_0x01a6
                                    net.one97.paytm.addmoney.utils.c r3 = net.one97.paytm.addmoney.utils.c.a()
                                    net.one97.paytm.common.entity.paymentsbank.CustProductList r3 = r3.f48963f
                                    if (r3 == 0) goto L_0x01a6
                                    java.lang.String r3 = r3.getIsaIfsc()
                                    r2.putString(r7, r3)
                                L_0x01a6:
                                    r0.setArguments(r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r2 = r2.f48535b
                                    net.one97.paytm.addmoney.utils.e r2 = (net.one97.paytm.addmoney.utils.e) r2
                                    r0.f48196a = r2
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r2 = r2.f48535b
                                    if (r2 == 0) goto L_0x01de
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r2 = r2.f48535b
                                    androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                                    if (r2 == 0) goto L_0x01de
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r2 = r2.f48535b
                                    boolean r2 = r2.isAdded()
                                    if (r2 == 0) goto L_0x01de
                                    net.one97.paytm.addmoney.common.view.a.a r1 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r1 = r1.f48535b
                                    androidx.fragment.app.j r1 = r1.getChildFragmentManager()
                                    androidx.fragment.app.q r1 = r1.a()
                                    androidx.fragment.app.q r0 = r1.b(r6, r0, r5)
                                    r0.c()
                                L_0x01de:
                                    return
                                L_0x01df:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.NET_BANKING
                                    if (r0 != r2) goto L_0x024b
                                    r0.getNumVal()
                                    android.os.Bundle r0 = new android.os.Bundle
                                    r0.<init>()
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    boolean r2 = r2.f48538e
                                    r0.putBoolean(r11, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    r0.putInt(r10, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    double r2 = r2.a()
                                    r0.putDouble(r9, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    java.lang.String r2 = net.one97.paytm.addmoney.common.view.a.a.a(r2)
                                    java.lang.String r3 = "mid"
                                    r0.putString(r3, r2)
                                    net.one97.paytm.addmoney.addmoneysource.netbanking.view.b r2 = new net.one97.paytm.addmoney.addmoneysource.netbanking.view.b
                                    r2.<init>()
                                    r2.setArguments(r0)
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    net.one97.paytm.addmoney.utils.e r0 = (net.one97.paytm.addmoney.utils.e) r0
                                    r2.f48371a = r0
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    if (r0 == 0) goto L_0x024a
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                    if (r0 == 0) goto L_0x024a
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    boolean r0 = r0.isAdded()
                                    if (r0 == 0) goto L_0x024a
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.j r0 = r0.getChildFragmentManager()
                                    androidx.fragment.app.q r0 = r0.a()
                                    androidx.fragment.app.q r0 = r0.b(r6, r2, r5)
                                    r0.c()
                                L_0x024a:
                                    return
                                L_0x024b:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.PPB
                                    if (r0 != r2) goto L_0x02b9
                                    r0.getNumVal()
                                    android.os.Bundle r0 = new android.os.Bundle
                                    r0.<init>()
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    boolean r2 = r2.f48538e
                                    r0.putBoolean(r11, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    r0.putInt(r10, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    double r2 = r2.a()
                                    r0.putDouble(r9, r2)
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    java.lang.String r2 = r2.j()
                                    java.lang.String r3 = "ppb_account_balance"
                                    r0.putString(r3, r2)
                                    net.one97.paytm.addmoney.addmoneysource.c.d.a r2 = new net.one97.paytm.addmoney.addmoneysource.c.d.a
                                    r2.<init>()
                                    r2.setArguments(r0)
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    net.one97.paytm.addmoney.utils.e r0 = (net.one97.paytm.addmoney.utils.e) r0
                                    r2.f48224a = r0
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    if (r0 == 0) goto L_0x02b8
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                    if (r0 == 0) goto L_0x02b8
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    boolean r0 = r0.isAdded()
                                    if (r0 == 0) goto L_0x02b8
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    androidx.fragment.app.Fragment r0 = r0.f48535b
                                    androidx.fragment.app.j r0 = r0.getChildFragmentManager()
                                    androidx.fragment.app.q r0 = r0.a()
                                    androidx.fragment.app.q r0 = r0.b(r6, r2, r5)
                                    r0.c()
                                L_0x02b8:
                                    return
                                L_0x02b9:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_UPI
                                    if (r0 != r2) goto L_0x0316
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    net.one97.paytm.addmoney.common.model.PaymentDestinationType r3 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_PAYTM_BANK
                                    int r3 = r3.getNumVal()
                                    if (r2 != r3) goto L_0x02fc
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    java.lang.String r3 = r2.e()
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r2 = r2.f48536c
                                    net.one97.paytm.common.entity.paymentsbank.CustProductList r2 = r2.k()
                                    boolean r4 = android.text.TextUtils.isEmpty(r3)
                                    if (r4 != 0) goto L_0x02f4
                                    if (r2 == 0) goto L_0x02f4
                                    java.lang.String r4 = r2.getIsaAccNum()
                                    java.lang.String r7 = r2.getIsaIfsc()
                                    int r0 = r0.getNumVal()
                                    r2 = r4
                                    r4 = r7
                                    r7 = r0
                                    r1.a(r2, r3, r4, r5, r6, r7)
                                    return
                                L_0x02f4:
                                    net.one97.paytm.addmoney.common.view.a.a r0 = net.one97.paytm.addmoney.common.view.a.a.this
                                    net.one97.paytm.addmoney.common.a.a$a r0 = r0.f48536c
                                    r0.d()
                                    return
                                L_0x02fc:
                                    net.one97.paytm.addmoney.common.view.a.a r2 = net.one97.paytm.addmoney.common.view.a.a.this
                                    int r2 = r2.f48537d
                                    net.one97.paytm.addmoney.common.model.PaymentDestinationType r3 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_WALLET
                                    int r3 = r3.getNumVal()
                                    if (r2 != r3) goto L_0x032d
                                    int r7 = r0.getNumVal()
                                    java.lang.String r2 = ""
                                    java.lang.String r3 = ""
                                    java.lang.String r4 = ""
                                    r1.a(r2, r3, r4, r5, r6, r7)
                                    return
                                L_0x0316:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_DC
                                    if (r0 != r2) goto L_0x0322
                                    int r0 = r0.getNumVal()
                                    r1.a(r3, r5, r6, r0)
                                    return
                                L_0x0322:
                                    net.one97.paytm.addmoney.common.model.SourceCardType r2 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_CC
                                    if (r0 != r2) goto L_0x032d
                                    int r0 = r0.getNumVal()
                                    r1.a(r4, r5, r6, r0)
                                L_0x032d:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.common.view.a.a.C0850a.AnonymousClass3.run():void");
                            }
                        }, 500);
                    }
                } else if (c2 != null) {
                    a.this.f48535b.getChildFragmentManager().a().a(c2).c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        static String a(SourceCardType sourceCardType) {
            if (sourceCardType == SourceCardType.BHIM_UPI) {
                return net.one97.paytm.addmoney.addmoneysource.d.d.a.class.getSimpleName();
            }
            if (sourceCardType == SourceCardType.DEBIT_CARD) {
                return net.one97.paytm.addmoney.addmoneysource.a.d.a.class.getSimpleName() + sourceCardType.getNumVal();
            } else if (sourceCardType == SourceCardType.CREDIT_CARD) {
                return net.one97.paytm.addmoney.addmoneysource.a.d.a.class.getSimpleName() + sourceCardType.getNumVal();
            } else if (sourceCardType == SourceCardType.WALLET) {
                return net.one97.paytm.addmoney.addmoneysource.e.d.a.class.getSimpleName();
            } else {
                if (sourceCardType == SourceCardType.OTHER_BANKS) {
                    return net.one97.paytm.addmoney.addmoneysource.b.d.a.class.getSimpleName();
                }
                if (sourceCardType == SourceCardType.NET_BANKING) {
                    return b.class.getSimpleName();
                }
                if (sourceCardType == SourceCardType.PPB) {
                    return net.one97.paytm.addmoney.addmoneysource.c.d.a.class.getSimpleName();
                }
                if (sourceCardType == SourceCardType.PAYMENT_ITEM_TYPE_UPI) {
                    return net.one97.paytm.addmoney.addmoneysource.d.d.a.class.getSimpleName() + sourceCardType.getNumVal();
                } else if (sourceCardType == SourceCardType.PAYMENT_ITEM_TYPE_DC) {
                    return net.one97.paytm.addmoney.addmoneysource.a.d.a.class.getSimpleName() + sourceCardType.getNumVal();
                } else if (sourceCardType != SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                    return null;
                } else {
                    return net.one97.paytm.addmoney.addmoneysource.a.d.a.class.getSimpleName() + sourceCardType.getNumVal();
                }
            }
        }

        static int b(SourceCardType sourceCardType) {
            if (sourceCardType == SourceCardType.BHIM_UPI) {
                return R.id.bhim_upi;
            }
            if (sourceCardType == SourceCardType.DEBIT_CARD) {
                return R.id.debit_card;
            }
            if (sourceCardType == SourceCardType.CREDIT_CARD) {
                return R.id.credit_card;
            }
            if (sourceCardType == SourceCardType.WALLET) {
                return R.id.wallet;
            }
            if (sourceCardType == SourceCardType.OTHER_BANKS) {
                return R.id.other_banks;
            }
            if (sourceCardType == SourceCardType.NET_BANKING) {
                return R.id.net_banking;
            }
            if (sourceCardType == SourceCardType.PPB) {
                return R.id.ppb;
            }
            if (sourceCardType == SourceCardType.PAYMENT_ITEM_TYPE_UPI) {
                return R.id.payment_item_type_upi;
            }
            if (sourceCardType == SourceCardType.PAYMENT_ITEM_TYPE_DC) {
                return R.id.payment_item_type_dc;
            }
            if (sourceCardType == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                return R.id.payment_item_type_cc;
            }
            return R.id.no_card;
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, String str2, String str3, String str4, int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("destroy_self", a.this.f48538e);
            bundle.putInt("destinationAddMoney", a.this.f48537d);
            bundle.putDouble("amount", a.this.a());
            bundle.putString("ppb_account_number", str);
            bundle.putString("ppb_account_name", str2);
            bundle.putString("ppb_account_ifsc", str3);
            bundle.putInt("item_type", i3);
            net.one97.paytm.addmoney.addmoneysource.d.d.a aVar = new net.one97.paytm.addmoney.addmoneysource.d.d.a();
            aVar.setArguments(bundle);
            aVar.f48257a = (e) a.this.f48535b;
            try {
                if (a.this.f48535b != null && a.this.f48535b.isAdded() && (a.this.f48535b instanceof net.one97.paytm.addmoney.common.view.a) && ((net.one97.paytm.addmoney.common.view.a) a.this.f48535b).getView() != null && ((net.one97.paytm.addmoney.common.view.a) a.this.f48535b).getView().findViewById(i2) != null) {
                    a.this.f48535b.getChildFragmentManager().a().b(i2, aVar, str4).c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z, String str, int i2, int i3) {
            net.one97.paytm.addmoney.addmoneysource.a.d.a aVar = new net.one97.paytm.addmoney.addmoneysource.a.d.a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("destroy_self", a.this.f48538e);
            bundle.putDouble("amount", a.this.a());
            bundle.putInt("destinationAddMoney", a.this.f48537d);
            bundle.putString("paymentMode", z ? SDKConstants.DEBIT : SDKConstants.CREDIT);
            bundle.putString("mid", a.a(a.this));
            bundle.putInt("item_type", i3);
            aVar.setArguments(bundle);
            aVar.f48146e = (e) a.this.f48535b;
            if (a.this.f48535b != null && a.this.f48535b.getActivity() != null && a.this.f48535b.isAdded()) {
                a.this.f48535b.getChildFragmentManager().a().b(i2, aVar, str).c();
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0850a(((LayoutInflater) this.f48534a.getSystemService("layout_inflater")).inflate(R.layout.uam_source_card_item, (ViewGroup) null));
    }

    static /* synthetic */ String a(a aVar) {
        Fragment fragment = aVar.f48535b;
        if (fragment == null || !fragment.isAdded()) {
            return "";
        }
        Fragment fragment2 = aVar.f48535b;
        return fragment2 instanceof net.one97.paytm.addmoney.common.view.a ? ((net.one97.paytm.addmoney.common.view.a) fragment2).i() : "";
    }
}
