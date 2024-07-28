package net.one97.paytm.upi.requestmoney.presenter;

import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.models.CJRAddBeneficiary;
import net.one97.paytm.upi.common.models.CJRKYCBeneficiaryBase;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.requestmoney.a.a;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.requestmoney.b.a.b;

public final class a implements a.C1399a {

    /* renamed from: a  reason: collision with root package name */
    a.b f69172a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<UpiDBTransactionModel> f69173b;

    /* renamed from: c  reason: collision with root package name */
    private final String f69174c = "RequestMoneyBeneficiaryPresenter";

    /* renamed from: d  reason: collision with root package name */
    private b f69175d;

    public final void f() {
    }

    public a(a.b bVar, b bVar2) {
        this.f69172a = bVar;
        this.f69175d = bVar2;
        this.f69172a.a(this);
    }

    public final void a(String str, String str2, boolean z) {
        this.f69172a.a(true);
        this.f69175d.a((a.C1402a) new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                a.this.f69172a.a(false);
                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) upiBaseDataModel;
                if (cJRAddBeneficiary.getError() != null) {
                    if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                        a.this.f69172a.a(cJRAddBeneficiary.getError().getErrorMsg());
                    } else {
                        a.this.f69172a.a((String) null);
                    }
                } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    a.this.f69172a.a();
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                a.this.f69172a.a(upiCustomVolleyError);
                a.this.f69172a.a(false);
            }
        }, str, str2, z);
    }

    public final void a(int i2, int i3) {
        this.f69175d.a((a.C1402a) new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                a.this.f69172a.b(false);
                try {
                    CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = (CJRKYCBeneficiaryBase) upiBaseDataModel;
                    if ((cJRKYCBeneficiaryBase.getError() == null || (!cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1002") && !cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1003"))) && cJRKYCBeneficiaryBase.getError() == null && cJRKYCBeneficiaryBase.getBeneficiariesList() != null && cJRKYCBeneficiaryBase.getBeneficiariesList().size() > 0) {
                        int totalCount = cJRKYCBeneficiaryBase.getTotalCount();
                        ArrayList arrayList = new ArrayList();
                        Iterator<BeneficiaryEntity> it2 = cJRKYCBeneficiaryBase.getBeneficiariesList().iterator();
                        while (it2.hasNext()) {
                            BeneficiaryEntity next = it2.next();
                            if (next.instrumentPreferences.upi != null) {
                                String str = next.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa;
                                if (a.this.f69173b == null || a.this.f69173b.isEmpty()) {
                                    arrayList.add(next);
                                } else {
                                    boolean z = false;
                                    for (int i2 = 0; i2 < a.this.f69173b.size(); i2++) {
                                        if (a.this.f69173b.get(i2).getTxn_mode().equalsIgnoreCase(str)) {
                                            z = true;
                                        }
                                    }
                                    if (!z) {
                                        arrayList.add(next);
                                    }
                                }
                            }
                        }
                        a.this.f69172a.a(arrayList, totalCount);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                a.this.f69172a.b(false);
            }
        }, (a.b) new a.b() {
            public final void a() {
                a.this.f69172a.b(false);
            }
        }, i2, i3);
    }

    public final void a(ArrayList<UpiDBTransactionModel> arrayList) {
        this.f69173b = arrayList;
    }

    public final void e() {
        this.f69172a.b(true);
        a(0, 25);
    }
}
