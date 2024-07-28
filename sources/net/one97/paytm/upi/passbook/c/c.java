package net.one97.paytm.upi.passbook.c;

import android.net.Uri;
import android.text.TextUtils;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.MiniStatementV2Model;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.passbook.a.b;
import net.one97.paytm.upi.passbook.b.a.a;

public final class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    b.C1378b f67704a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.passbook.b.a.b f67705b;

    /* renamed from: c  reason: collision with root package name */
    private String f67706c = "UpiPassbookTransactionDetailPresenter";

    /* renamed from: d  reason: collision with root package name */
    private String f67707d;

    public c(b.C1378b bVar, String str, net.one97.paytm.upi.passbook.b.a.b bVar2) {
        this.f67704a = bVar;
        this.f67704a.a(this);
        this.f67705b = bVar2;
        this.f67707d = str;
    }

    public final void e() {
        UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody;
        if (!TextUtils.isEmpty(this.f67707d)) {
            this.f67704a.a(true);
            net.one97.paytm.upi.passbook.b.a.b bVar = this.f67705b;
            AnonymousClass1 r1 = new a.C1379a() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    if (c.a(c.this)) {
                        c.this.f67704a.a(false);
                        if (upiBaseDataModel instanceof MiniStatementV2Model) {
                            MiniStatementV2Model miniStatementV2Model = (MiniStatementV2Model) upiBaseDataModel;
                            if (miniStatementV2Model.getTransactions() == null || miniStatementV2Model.getTransactions().isEmpty()) {
                                c.this.f67704a.b();
                                return;
                            }
                            c.this.f67704a.a(miniStatementV2Model.getTransactions().get(0));
                            c.this.f67704a.a();
                            return;
                        }
                        c.this.f67704a.b();
                    }
                }

                public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                    if (c.a(c.this)) {
                        c.this.f67704a.a(false);
                        c.this.f67704a.b();
                    }
                }
            };
            String str = this.f67706c;
            Uri parse = Uri.parse(this.f67707d);
            if (TextUtils.isEmpty(parse.getQueryParameter("txnId"))) {
                this.f67704a.b();
                upiTxnHistoryV2RequestBody = null;
            } else {
                UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody2 = new UpiTxnHistoryV2RequestBody();
                UpiTxnHistoryV2RequestBody.FilterRequest filterRequest = new UpiTxnHistoryV2RequestBody.FilterRequest();
                filterRequest.setTransactionId(parse.getQueryParameter("txnId"));
                upiTxnHistoryV2RequestBody2.setPageNo(0);
                upiTxnHistoryV2RequestBody2.setPageSize(20);
                upiTxnHistoryV2RequestBody2.setFilter(filterRequest);
                upiTxnHistoryV2RequestBody = upiTxnHistoryV2RequestBody2;
            }
            bVar.a((a.C1379a) r1, str, upiTxnHistoryV2RequestBody);
            return;
        }
        this.f67704a.a();
    }

    public final void f() {
        this.f67705b.a(this.f67706c);
        this.f67704a = null;
    }

    static /* synthetic */ boolean a(c cVar) {
        return cVar.f67704a != null;
    }
}
