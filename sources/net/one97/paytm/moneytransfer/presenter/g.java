package net.one97.paytm.moneytransfer.presenter;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.a.h;
import net.one97.paytm.moneytransfer.utils.i;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.MiniStatementV2Model;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.passbook.b.a.b;

public final class g implements h.a, a.C1379a {

    /* renamed from: a  reason: collision with root package name */
    private String f54117a = "UpiUserHistoryTag";

    /* renamed from: b  reason: collision with root package name */
    private int f54118b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f54119c;

    /* renamed from: d  reason: collision with root package name */
    private h.b f54120d;

    /* renamed from: e  reason: collision with root package name */
    private b f54121e;

    public g(h.b bVar, b bVar2) {
        this.f54120d = bVar;
        this.f54121e = bVar2;
    }

    public final void a(String str) {
        h.b bVar;
        k.c(str, "accNoOrVpa");
        if (!this.f54119c) {
            UpiTxnHistoryV2RequestBody.EntityInvolvedRequest entityInvolvedRequest = new UpiTxnHistoryV2RequestBody.EntityInvolvedRequest();
            if (com.paytm.utility.b.X(str)) {
                entityInvolvedRequest.setField(i.b.VPA.getType());
                String lowerCase = str.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                entityInvolvedRequest.setValue(lowerCase);
            } else {
                entityInvolvedRequest.setField(i.b.ACC_NO.getType());
                entityInvolvedRequest.setValue(str);
            }
            UpiTxnHistoryV2RequestBody.FilterRequest filterRequest = new UpiTxnHistoryV2RequestBody.FilterRequest();
            filterRequest.setEntityInvolved(entityInvolvedRequest);
            filterRequest.setStatus(i.a.SUCCESS.getType());
            UpiTxnHistoryV2RequestBody.SortRequest sortRequest = new UpiTxnHistoryV2RequestBody.SortRequest();
            sortRequest.setParam(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            sortRequest.setOrder("dsc");
            UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody = new UpiTxnHistoryV2RequestBody();
            upiTxnHistoryV2RequestBody.setPageNo(this.f54118b);
            upiTxnHistoryV2RequestBody.setPageSize(20);
            upiTxnHistoryV2RequestBody.setFilter(filterRequest);
            upiTxnHistoryV2RequestBody.setSort(sortRequest);
            if (this.f54118b == 0 && (bVar = this.f54120d) != null) {
                bVar.a(true);
            }
            b bVar2 = this.f54121e;
            if (bVar2 != null) {
                bVar2.a((a.C1379a) this, this.f54117a, upiTxnHistoryV2RequestBody);
            }
            this.f54119c = true;
        }
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        h.b bVar;
        if (upiBaseDataModel != null && (upiBaseDataModel instanceof MiniStatementV2Model)) {
            if (this.f54118b == 0 && (bVar = this.f54120d) != null) {
                bVar.a(false);
            }
            h.b bVar2 = this.f54120d;
            if (bVar2 != null) {
                bVar2.a(((MiniStatementV2Model) upiBaseDataModel).getTransactions());
            }
            this.f54118b++;
            this.f54119c = false;
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        h.b bVar = this.f54120d;
        if (bVar != null) {
            bVar.a(false);
        }
        h.b bVar2 = this.f54120d;
        if (bVar2 != null) {
            bVar2.a(upiCustomVolleyError);
        }
    }

    public final void a() {
        b bVar = this.f54121e;
        if (bVar != null) {
            bVar.a(this.f54117a);
        }
    }
}
