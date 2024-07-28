package net.one97.paytm.upi.requestmoney.presenter;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.common.MoneyTransferRecentListAdapter;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.requestmoney.a.e;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.requestmoney.b.a.b;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class e implements e.a, a.C1402a {

    /* renamed from: a  reason: collision with root package name */
    b f69204a;

    /* renamed from: b  reason: collision with root package name */
    e.b f69205b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<UpiDBTransactionModel> f69206c;

    /* renamed from: d  reason: collision with root package name */
    private List<UpiProfileDefaultBank> f69207d;

    /* renamed from: e  reason: collision with root package name */
    private String f69208e;

    /* renamed from: f  reason: collision with root package name */
    private final String f69209f = "UpiRequestMoneyPresenter";

    /* renamed from: g  reason: collision with root package name */
    private boolean f69210g;

    /* renamed from: h  reason: collision with root package name */
    private String f69211h;

    public e(b bVar, e.b bVar2) {
        this.f69204a = bVar;
        this.f69205b = bVar2;
        this.f69207d = new ArrayList();
        this.f69206c = new ArrayList<>();
        this.f69211h = bVar2.getClass().getSimpleName();
    }

    public final void e() {
        if (this.f69204a.a()) {
            this.f69205b.a(true);
            this.f69204a.a(this, "UpiRequestMoneyPresenter", this.f69211h);
            this.f69204a.a((net.one97.paytm.upi.e) new net.one97.paytm.upi.e() {
                public final void a(ArrayList<UpiDBTransactionModel> arrayList) {
                    e.this.f69206c.addAll(arrayList);
                    if (e.this.f69206c != null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(e.this.f69206c);
                        e.this.f69205b.a((ArrayList<UpiBaseDataModel>) arrayList2);
                    }
                }
            });
            return;
        }
        this.f69205b.b();
    }

    public final void f() {
        this.f69204a.a("UpiRequestMoneyPresenter");
    }

    public final void a() {
        this.f69205b.a();
    }

    public final void a(String str, String str2, boolean z) {
        if (!this.f69204a.a()) {
            this.f69205b.b();
            return;
        }
        this.f69205b.a(true);
        this.f69204a.a(this, "UpiRequestMoneyPresenter", str, str2, this.f69211h);
        this.f69210g = z;
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, String str, String str2, String str3, String str4, String str5) {
        if (!this.f69204a.a()) {
            this.f69205b.b();
        } else if (upiProfileDefaultBank != null) {
            this.f69205b.a(true);
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str5;
            this.f69204a.a(new a.C1402a() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    e.this.f69205b.a(false);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (baseUpiResponse.isSuccess() && ("92".equalsIgnoreCase(baseUpiResponse.getResponse()) || "0".equalsIgnoreCase(baseUpiResponse.getResponse()))) {
                        e.this.f69205b.b(true);
                        e.this.f69204a.a(new UpiDBTransactionModel("request", str6, str8, "", "", str7, String.valueOf(System.currentTimeMillis())));
                    }
                    e.this.f69205b.a(baseUpiResponse.isSuccess(), baseUpiResponse.getResponse(), baseUpiResponse.getMessage(), baseUpiResponse.getBankRRN(), baseUpiResponse.getUpiTranlogId(), baseUpiResponse.getSeqNo());
                }

                public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                    e.this.f69205b.a(false);
                    e.this.f69205b.b(false);
                }
            }, "UpiRequestMoneyPresenter", upiProfileDefaultBank.getCreditBank().getIfsc(), upiProfileDefaultBank.getCreditBank().getAccount(), upiProfileDefaultBank.getVirtualAddress().toLowerCase(), str.toLowerCase(), str2, str3, str4, str8, this.f69211h);
        }
    }

    public final void a(int i2) {
        UpiDBTransactionModel upiDBTransactionModel = this.f69206c.get(i2);
        e.b bVar = this.f69205b;
        String txn_mode = upiDBTransactionModel.getTxn_mode();
        upiDBTransactionModel.getBank_name();
        String beneficiary_name = upiDBTransactionModel.getBeneficiary_name();
        upiDBTransactionModel.getTxn_amount();
        bVar.a(txn_mode, beneficiary_name);
    }

    public final void a(int i2, MoneyTransferRecentListAdapter.BeneficiaryViewHolder beneficiaryViewHolder) {
        UpiDBTransactionModel upiDBTransactionModel = this.f69206c.get(i2);
        Double valueOf = Double.valueOf(0.0d);
        try {
            valueOf = Double.valueOf(Double.parseDouble(upiDBTransactionModel.getTxn_amount()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        beneficiaryViewHolder.setAmount("₹ " + UpiAppUtils.priceToString(valueOf));
        beneficiaryViewHolder.setRowIcon(upiDBTransactionModel.getIfsc());
        beneficiaryViewHolder.setAccountNumberOrVpa(upiDBTransactionModel.getTxn_mode());
        beneficiaryViewHolder.setBeneficiaryName(upiDBTransactionModel.getBeneficiary_name());
        beneficiaryViewHolder.setBankName(upiDBTransactionModel.getBank_name());
        beneficiaryViewHolder.setListRowClick(i2);
    }

    public final int b() {
        ArrayList<UpiDBTransactionModel> arrayList = this.f69206c;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f69206c.size();
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        this.f69205b.a(false);
        if (upiBaseDataModel instanceof UpiProfileModel) {
            UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
            if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                this.f69207d.clear();
                this.f69205b.b(this.f69207d);
                for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                    if (next.getCreditBank() != null && !TextUtils.isEmpty(next.getCreditBank().getAccount()) && !TextUtils.isEmpty(next.getCreditBank().getIfsc())) {
                        this.f69207d.add(next);
                    }
                }
            }
            this.f69205b.a(this.f69207d);
        } else if (upiBaseDataModel instanceof BaseUpiResponse) {
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
            if (!baseUpiResponse.isSuccess() || !"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                this.f69205b.a(false, baseUpiResponse.getResponse());
                return;
            }
            String str = (String) baseUpiResponse.getMobileAppData();
            if (str.toLowerCase().contains("success")) {
                this.f69208e = str.substring(str.indexOf("=") + 1);
            }
            if (!TextUtils.isEmpty(this.f69208e)) {
                this.f69205b.a(true, "");
                this.f69205b.a(this.f69208e);
            } else {
                this.f69205b.a(false, "");
            }
            if (this.f69210g) {
                this.f69205b.a();
            }
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        e.b bVar = this.f69205b;
        if (bVar != null) {
            bVar.a(false);
            this.f69205b.a(upiCustomVolleyError);
        }
    }
}
