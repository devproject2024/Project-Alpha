package net.one97.paytm.upi.passbook.c;

import android.text.TextUtils;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.passbook.a.a;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class b implements a.C1377a, a.C1379a {

    /* renamed from: a  reason: collision with root package name */
    protected a.b f67691a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<UpiTransactionModelV2> f67692b;

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<UpiPendingRequestModel> f67693c;

    /* renamed from: d  reason: collision with root package name */
    protected int f67694d;

    /* renamed from: e  reason: collision with root package name */
    protected int f67695e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f67696f;

    /* renamed from: g  reason: collision with root package name */
    UpiPendingRequestModel f67697g = null;

    /* renamed from: h  reason: collision with root package name */
    private final String f67698h = "UpiPassbookTabPresenter";

    /* renamed from: i  reason: collision with root package name */
    private final int f67699i = 20;
    private final String j = "dsc";
    private final String k = CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR;
    private final String l = "SUCCESS";
    private final String m = "PENDING";
    private final String n = "FAILURE";
    private net.one97.paytm.upi.passbook.b.a.b o;
    private ArrayList<UpiPendingRequestModel> p;
    private ArrayList<UpiPendingRequestModel> q;
    private HashMap<String, Integer> r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private String w;
    private UpiTxnHistoryV2RequestBody x;

    public b(net.one97.paytm.upi.passbook.b.a.b bVar, a.b bVar2, int i2, boolean z) {
        this.o = bVar;
        this.f67691a = bVar2;
        this.w = bVar2.getClass().getSimpleName();
        this.f67694d = i2;
        this.f67695e = 0;
        this.s = true;
        this.t = false;
        this.u = false;
        this.f67696f = false;
        this.f67692b = new ArrayList<>();
        this.f67693c = new ArrayList<>();
        this.p = new ArrayList<>();
        this.r = new HashMap<>();
        this.q = new ArrayList<>();
        this.v = z;
        this.x = new UpiTxnHistoryV2RequestBody();
        UpiTxnHistoryV2RequestBody.SortRequest sortRequest = new UpiTxnHistoryV2RequestBody.SortRequest();
        sortRequest.setParam(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        sortRequest.setOrder("dsc");
        this.x.setSort(sortRequest);
        this.f67691a.a(this);
    }

    public final void e() {
        if (this.f67694d == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            b();
        } else if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            c();
        } else if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            d();
        } else {
            l();
        }
    }

    public final void f() {
        this.o.a("UpiPassbookTabPresenter");
    }

    public int a() {
        if (this.f67694d == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            return this.f67692b.size();
        }
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            return this.f67693c.size();
        }
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            return this.p.size();
        }
        if (this.f67694d == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            return this.q.size();
        }
        return 0;
    }

    public final void g() {
        boolean z = false;
        if (this.f67694d == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            if (this.f67692b.size() > 0) {
                this.f67691a.c(false);
            } else {
                this.f67691a.c(true);
            }
        } else if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            if (this.f67693c.size() > 0) {
                this.f67691a.c(false);
            } else {
                this.f67691a.c(true);
            }
            a.b bVar = this.f67691a;
            if (this.f67693c.size() > 0) {
                z = true;
            }
            bVar.a(z, this.f67696f);
        } else if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            if (this.p.size() > 0) {
                this.f67691a.c(false);
            } else {
                this.f67691a.c(true);
            }
        } else if (this.f67694d != UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
        } else {
            if (this.q.size() > 0) {
                this.f67691a.c(false);
            } else {
                this.f67691a.c(true);
            }
        }
    }

    public final void b() {
        if (!this.f67691a.d()) {
            this.f67691a.e();
        } else if (!this.t && !this.u) {
            if (this.f67692b.size() == 0) {
                this.f67691a.a(true);
            } else {
                this.f67691a.b(true);
            }
            this.u = true;
            this.x.setPageNo(this.f67695e);
            this.x.setPageSize(20);
            this.o.a((a.C1379a) this, "UpiPassbookTabPresenter", this.x);
        }
    }

    public final void j() {
        this.f67695e = 0;
        this.s = true;
        this.t = false;
        int size = this.f67692b.size();
        this.f67692b.clear();
        this.f67691a.b(size);
        b();
    }

    public final void c() {
        if (!this.t && !this.u) {
            if (this.f67693c.size() == 0) {
                this.f67691a.a(true);
            }
            this.u = true;
            this.o.a((a.C1379a) this, "UpiPassbookTabPresenter", this.f67695e, this.w);
        }
    }

    public final void h() {
        this.f67695e = 0;
        this.s = true;
        this.t = false;
        int size = this.f67693c.size();
        this.f67693c.clear();
        this.f67691a.a(size);
        c();
    }

    public final void d() {
        if (!this.t && !this.u) {
            if (this.p.size() == 0) {
                this.f67691a.a(true);
            }
            this.u = true;
            this.o.a((a.C1379a) this, "UpiPassbookTabPresenter", this.f67695e, this.w);
        }
    }

    public final void i() {
        this.f67695e = 0;
        this.s = true;
        this.t = false;
        int size = this.p.size();
        this.p.clear();
        this.f67691a.a(size);
        c();
    }

    private void l() {
        if (!this.t && !this.u) {
            if (this.q.size() == 0) {
                this.f67691a.a(true);
            }
            this.u = true;
            this.o.b((a.C1379a) this, "UpiPassbookTabPresenter", this.f67695e, this.w);
        }
    }

    public final void k() {
        this.f67695e = 0;
        this.s = true;
        this.t = false;
        int size = this.q.size();
        this.q.clear();
        this.f67691a.a(size);
        l();
    }

    public final String a(int i2) {
        if (this.f67694d == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            return this.f67692b.get(i2).getDate();
        }
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            return this.f67693c.get(i2).getDate();
        }
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            return this.p.get(i2).getDate();
        }
        return this.f67694d == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal() ? this.q.get(i2).getDate() : "";
    }

    public final void d(int i2) {
        UpiPendingRequestModel upiPendingRequestModel = (this.f67694d != UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal() || this.f67693c.size() <= i2) ? null : this.f67693c.get(i2);
        if (upiPendingRequestModel != null && upiPendingRequestModel.getMandateDetails() != null) {
            this.f67691a.a(upiPendingRequestModel);
        } else if (upiPendingRequestModel != null) {
            this.f67691a.a(i2, upiPendingRequestModel.getAmount(), upiPendingRequestModel.getPayeeName(), upiPendingRequestModel.getPayeeVa());
        }
    }

    public final void b(int i2) {
        this.f67697g = null;
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal() && this.f67693c.size() > i2) {
            this.f67697g = this.f67693c.get(i2);
        } else if (this.f67694d == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal() && this.q.size() > i2) {
            this.f67697g = this.q.get(i2);
        }
        if (this.f67697g != null) {
            this.f67691a.a(true);
            this.o.a(this, "UpiPassbookTabPresenter", "", this.f67697g.getPayeeVa(), this.f67697g.getPayerVa(), this.f67697g.getAmount(), this.f67697g.getNote(), this.f67697g.getAmount(), this.f67697g.getUpiTranlogId(), "R", "A", this.w);
        }
    }

    public final void a(int i2, final boolean z) {
        this.f67697g = null;
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            this.f67697g = this.f67693c.get(i2);
        } else if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            this.f67697g = this.p.get(i2);
        } else if (this.f67694d == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            this.f67697g = this.q.get(i2);
        }
        this.f67691a.a(true);
        this.o.a(new a.b() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                b.this.f67691a.a(false);
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess()) {
                        b.this.f67691a.a(false, z, b.this.f67697g);
                    } else if ("0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        b.this.f67691a.a(true, z, b.this.f67697g);
                    } else {
                        b.this.f67691a.a(false, z, b.this.f67697g);
                    }
                    if ("1006".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        b.this.f67691a.a();
                    }
                }
            }

            public final void a(VolleyError volleyError) {
                b.this.f67691a.a(false);
                b.this.f67691a.a(false, z, b.this.f67697g);
            }
        }, "UpiPassbookTabPresenter", this.f67697g.getPayeeVa(), this.f67697g.getPayerVa(), z ? "A" : "R", this.w);
    }

    public final void c(int i2) {
        if (this.f67693c.size() > i2) {
            UpiPendingRequestModel upiPendingRequestModel = this.f67693c.get(i2);
            if (upiPendingRequestModel.getMandateDetails() != null) {
                this.f67691a.a(upiPendingRequestModel);
            } else {
                this.f67691a.a(i2, upiPendingRequestModel);
            }
        }
    }

    public final void a(int i2, ImageView imageView) {
        UpiPendingRequestModel upiPendingRequestModel = this.f67693c.get(i2);
        a.b bVar = this.f67691a;
        String refCategory = upiPendingRequestModel.getRefCategory();
        upiPendingRequestModel.getRefUrl();
        bVar.a(i2, refCategory, imageView);
    }

    public final void e(int i2) {
        UpiPendingRequestModel upiPendingRequestModel = this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal() ? this.f67693c.get(i2) : null;
        if (upiPendingRequestModel != null) {
            this.f67691a.a(i2, upiPendingRequestModel.getPayeeName(), upiPendingRequestModel.getPayeeVa());
        }
    }

    public final void f(int i2) {
        UpiPendingRequestModel upiPendingRequestModel = this.f67694d == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal() ? this.q.get(i2) : null;
        if (upiPendingRequestModel != null) {
            this.f67691a.a(i2, upiPendingRequestModel.getPayeeVa());
        }
    }

    public final void g(int i2) {
        if (this.f67691a != null) {
            UpiPendingRequestModel upiPendingRequestModel = null;
            if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                upiPendingRequestModel = this.f67693c.get(i2);
            }
            if (upiPendingRequestModel != null) {
                this.f67691a.b(upiPendingRequestModel.getRefUrl());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ff, code lost:
        if (r6.s == false) goto L_0x0101;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.upi.common.UpiBaseDataModel r7) {
        /*
            r6 = this;
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            r1 = 0
            r0.a((boolean) r1)
            boolean r0 = r7 instanceof net.one97.paytm.upi.common.upi.MiniStatementV2Model
            r2 = 1
            if (r0 == 0) goto L_0x0076
            boolean r0 = r6.s
            if (r0 == 0) goto L_0x0011
            r6.s = r1
        L_0x0011:
            int r0 = r6.f67695e
            int r0 = r0 + r2
            r6.f67695e = r0
            net.one97.paytm.upi.common.upi.MiniStatementV2Model r7 = (net.one97.paytm.upi.common.upi.MiniStatementV2Model) r7
            if (r7 == 0) goto L_0x0073
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            r0.b((boolean) r1)
            java.util.ArrayList r7 = r7.getTransactions()
            if (r7 == 0) goto L_0x0071
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x005b
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r0 = r6.f67692b
            int r0 = r0.size()
            boolean r2 = r6.v
            if (r2 == 0) goto L_0x004c
            int r2 = r7.size()
            r3 = 3
            if (r2 <= r3) goto L_0x0046
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r2 = r6.f67692b
            java.util.List r3 = r7.subList(r1, r3)
            r2.addAll(r3)
            goto L_0x0051
        L_0x0046:
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r2 = r6.f67692b
            r2.addAll(r7)
            goto L_0x0051
        L_0x004c:
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r2 = r6.f67692b
            r2.addAll(r7)
        L_0x0051:
            net.one97.paytm.upi.passbook.a.a$b r2 = r6.f67691a
            int r7 = r7.size()
            r2.a((int) r0, (int) r7)
            goto L_0x0073
        L_0x005b:
            boolean r0 = r6.s
            if (r0 != 0) goto L_0x0061
            r6.t = r2
        L_0x0061:
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r2 = r6.f67692b
            int r2 = r2.size()
            int r7 = r7.size()
            r0.a((int) r2, (int) r7)
            goto L_0x0073
        L_0x0071:
            r6.t = r2
        L_0x0073:
            r6.u = r1
            return
        L_0x0076:
            boolean r0 = r7 instanceof net.one97.paytm.upi.common.upi.PendingRequestsModel.PendingRequests
            if (r0 == 0) goto L_0x0106
            boolean r0 = r6.s
            if (r0 == 0) goto L_0x0080
            r6.s = r1
        L_0x0080:
            int r0 = r6.f67695e
            int r0 = r0 + r2
            r6.f67695e = r0
            net.one97.paytm.upi.common.upi.PendingRequestsModel$PendingRequests r7 = (net.one97.paytm.upi.common.upi.PendingRequestsModel.PendingRequests) r7
            if (r7 == 0) goto L_0x0103
            java.util.ArrayList r7 = r7.getPendingRequests()
            if (r7 == 0) goto L_0x0101
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x00fd
            int r0 = r6.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r2 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x00a3
            r6.a((java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel>) r7)
            goto L_0x0103
        L_0x00a3:
            int r0 = r6.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r2 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_SENT
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x00de
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r0 = r6.p
            int r0 = r0.size()
            java.util.Iterator r7 = r7.iterator()
            r2 = 0
        L_0x00b8:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x00d8
            java.lang.Object r3 = r7.next()
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r3 = (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r3
            java.lang.String r4 = r3.getDirection()
            java.lang.String r5 = "RECEIVED"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x00b8
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r4 = r6.p
            r4.add(r3)
            int r2 = r2 + 1
            goto L_0x00b8
        L_0x00d8:
            net.one97.paytm.upi.passbook.a.a$b r7 = r6.f67691a
            r7.a((int) r0, (int) r2)
            goto L_0x0103
        L_0x00de:
            int r0 = r6.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r2 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.SPAM_REQUESTS
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x0103
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r0 = r6.q
            int r0 = r0.size()
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r2 = r6.q
            r2.addAll(r7)
            net.one97.paytm.upi.passbook.a.a$b r2 = r6.f67691a
            int r7 = r7.size()
            r2.a((int) r0, (int) r7)
            goto L_0x0103
        L_0x00fd:
            boolean r7 = r6.s
            if (r7 != 0) goto L_0x0103
        L_0x0101:
            r6.t = r2
        L_0x0103:
            r6.u = r1
            return
        L_0x0106:
            boolean r0 = r7 instanceof net.one97.paytm.upi.common.upi.BaseUpiResponse
            if (r0 == 0) goto L_0x014f
            net.one97.paytm.upi.common.upi.BaseUpiResponse r7 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r7
            boolean r0 = r7.isSuccess()
            if (r0 == 0) goto L_0x0137
            java.lang.String r0 = r7.getResponse()
            java.lang.String r3 = "0"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 != 0) goto L_0x012f
            java.lang.String r3 = "ZA"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0127
            goto L_0x012f
        L_0x0127:
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r2 = r6.f67697g
            r0.a((boolean) r1, (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r2)
            goto L_0x013e
        L_0x012f:
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r1 = r6.f67697g
            r0.a((boolean) r2, (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r1)
            goto L_0x013e
        L_0x0137:
            net.one97.paytm.upi.passbook.a.a$b r0 = r6.f67691a
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r2 = r6.f67697g
            r0.a((boolean) r1, (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r2)
        L_0x013e:
            java.lang.String r7 = r7.getResponse()
            java.lang.String r0 = "1006"
            boolean r7 = r0.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x014f
            net.one97.paytm.upi.passbook.a.a$b r7 = r6.f67691a
            r7.a()
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.passbook.c.b.a(net.one97.paytm.upi.common.UpiBaseDataModel):void");
    }

    /* access modifiers changed from: protected */
    public void a(ArrayList<UpiPendingRequestModel> arrayList) {
        int size = this.f67693c.size();
        Iterator<UpiPendingRequestModel> it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            UpiPendingRequestModel next = it2.next();
            if ("RECEIVED".equalsIgnoreCase(next.getDirection())) {
                this.f67693c.add(next);
                i2++;
            } else {
                this.f67696f = true;
            }
        }
        this.f67691a.a(size, i2, this.f67693c);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        this.f67691a.a(false);
        if (!this.f67691a.c() || upiCustomVolleyError == null || !UpiConstants.NETWORK_ERROR_CODE.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
            String fullUrl = upiCustomVolleyError.getFullUrl();
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                this.f67691a.b();
            } else if (TextUtils.isEmpty(fullUrl)) {
            } else {
                if (fullUrl.contains("mini-stmt")) {
                    this.f67691a.a(this.f67692b.size(), 0);
                    if (this.s) {
                        this.s = false;
                    }
                    if ("90".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                        this.t = true;
                    }
                    this.u = false;
                } else if (fullUrl.contains("get-pending-request")) {
                    this.f67691a.a(this.f67693c.size(), 0);
                    if (this.s) {
                        this.s = false;
                    }
                    if ("90".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                        this.t = true;
                    }
                    this.u = false;
                } else if (fullUrl.contains("collect-auth")) {
                    this.f67691a.a(false, this.f67697g);
                } else if (fullUrl.contains("spam")) {
                    this.f67691a.a(this.q.size(), 0);
                    if (this.s) {
                        this.s = false;
                    }
                    if ("90".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                        this.t = true;
                    }
                    if ("JSONSyntax Exception".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                        this.f67691a.c(true);
                    }
                    this.u = false;
                }
            }
        } else {
            this.f67691a.d(true);
            this.u = false;
        }
    }

    public final UpiPendingRequestModel h(int i2) {
        ArrayList<UpiPendingRequestModel> arrayList = this.f67693c;
        if (arrayList == null || arrayList.size() <= i2) {
            return null;
        }
        return this.f67693c.get(i2);
    }

    public final UpiPendingRequestModel i(int i2) {
        ArrayList<UpiPendingRequestModel> arrayList = this.q;
        if (arrayList == null || arrayList.size() <= i2) {
            return null;
        }
        return this.q.get(i2);
    }

    public final void a(String str) {
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            for (int i2 = 0; i2 < this.f67693c.size(); i2++) {
                if (str.equalsIgnoreCase(this.f67693c.get(i2).getUpiTranlogId())) {
                    this.f67693c.remove(i2);
                    this.f67691a.c(i2);
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00fc, code lost:
        r1 = net.one97.paytm.upi.i.a().l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, net.one97.paytm.upi.passbook.view.c.a r12) {
        /*
            r10 = this;
            net.one97.paytm.upi.passbook.view.c r0 = net.one97.paytm.upi.passbook.view.c.this
            int r0 = r0.f67748b
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.TRANSACTIONS
            int r1 = r1.ordinal()
            r2 = 0
            r3 = 8
            if (r0 != r1) goto L_0x003e
            android.widget.TextView r0 = r12.f67787i
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.f67784f
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.j
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.f67786h
            r0.setVisibility(r3)
            android.view.View r0 = r12.k
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.l
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.m
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67779a
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67780b
            r0.setVisibility(r3)
            goto L_0x00c8
        L_0x003e:
            net.one97.paytm.upi.passbook.view.c r0 = net.one97.paytm.upi.passbook.view.c.this
            int r0 = r0.f67748b
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x0069
            android.widget.TextView r0 = r12.f67787i
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.j
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.f67785g
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.l
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67779a
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67780b
            r0.setVisibility(r2)
            goto L_0x00c8
        L_0x0069:
            net.one97.paytm.upi.passbook.view.c r0 = net.one97.paytm.upi.passbook.view.c.this
            int r0 = r0.f67748b
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_SENT
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x009e
            android.widget.TextView r0 = r12.f67787i
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.j
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.f67785g
            r0.setVisibility(r3)
            android.view.View r0 = r12.k
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.m
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.l
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67779a
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67780b
            r0.setVisibility(r3)
            goto L_0x00c8
        L_0x009e:
            net.one97.paytm.upi.passbook.view.c r0 = net.one97.paytm.upi.passbook.view.c.this
            int r0 = r0.f67748b
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.SPAM_REQUESTS
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x00c8
            android.widget.TextView r0 = r12.f67787i
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.j
            r0.setVisibility(r3)
            android.widget.TextView r0 = r12.f67785g
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r12.m
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67779a
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r12.f67780b
            r0.setVisibility(r3)
        L_0x00c8:
            int r0 = r10.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.TRANSACTIONS
            int r1 = r1.ordinal()
            java.lang.String r4 = ""
            if (r0 != r1) goto L_0x0526
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiTransactionModelV2> r0 = r10.f67692b
            java.lang.Object r0 = r0.get(r11)
            net.one97.paytm.upi.common.upi.UpiTransactionModelV2 r0 = (net.one97.paytm.upi.common.upi.UpiTransactionModelV2) r0
            if (r11 != 0) goto L_0x00e7
            net.one97.paytm.upi.passbook.a.a$b r11 = r10.f67691a
            java.lang.String r1 = r0.getDate()
            r11.a((java.lang.String) r1)
        L_0x00e7:
            java.lang.String r11 = r0.getAmount()
            r12.d(r11)
            r12.a()
            java.lang.String r11 = r0.getThemeId()
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            r5 = 0
            if (r1 != 0) goto L_0x010f
            net.one97.paytm.upi.i r1 = net.one97.paytm.upi.i.a()
            net.one97.paytm.upi.f.a r1 = r1.l
            if (r1 == 0) goto L_0x010f
            android.view.View r6 = r12.itemView
            android.content.Context r6 = r6.getContext()
            net.one97.paytm.p2p.theme.ThemeData r11 = r1.a(r6, r11)
            goto L_0x0110
        L_0x010f:
            r11 = r5
        L_0x0110:
            java.lang.String r1 = r0.getTxnType()
            java.lang.String r6 = "CREDIT"
            boolean r1 = r6.equalsIgnoreCase(r1)
            java.lang.String r6 = "SUCCESS"
            java.lang.String r7 = " "
            if (r1 == 0) goto L_0x018b
            java.lang.String r1 = "+"
            r12.c(r1)
            java.lang.String r1 = r0.getTxnType()
            java.lang.String r4 = r0.getStatus()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r0.getNarration()
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = r0.getNarrationDirection()
            r8.append(r9)
            r8.append(r7)
            net.one97.paytm.upi.common.upi.UpiTransactionBankDetailsV2 r7 = r0.getPayer()
            java.lang.String r7 = r7.getmName()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r12.a(r1, r4, r7)
            if (r11 == 0) goto L_0x016d
            java.lang.String r1 = r0.getStatus()
            boolean r1 = r6.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x016d
            java.lang.String r11 = r11.getImagerURL()
            r12.b(r11)
            goto L_0x01f2
        L_0x016d:
            java.lang.String r11 = r0.getLogoUrl()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x017f
            java.lang.String r11 = r0.getLogoUrl()
            r12.a((java.lang.String) r11)
            goto L_0x01f2
        L_0x017f:
            java.lang.String r11 = r0.getTxnType()
            java.lang.String r1 = r0.getCategory()
            r12.a((java.lang.String) r11, (java.lang.String) r1)
            goto L_0x01f2
        L_0x018b:
            r12.c(r4)
            java.lang.String r1 = r0.getTxnType()
            java.lang.String r4 = r0.getStatus()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r0.getNarration()
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = r0.getNarrationDirection()
            r8.append(r9)
            r8.append(r7)
            net.one97.paytm.upi.common.upi.UpiTransactionBankDetailsV2 r7 = r0.getPayee()
            java.lang.String r7 = r7.getmName()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r12.a(r1, r4, r7)
            if (r11 == 0) goto L_0x01d5
            java.lang.String r1 = r0.getStatus()
            boolean r1 = r6.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x01d5
            java.lang.String r11 = r11.getImagerURL()
            r12.b(r11)
            goto L_0x01f2
        L_0x01d5:
            java.lang.String r11 = r0.getLogoUrl()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x01e7
            java.lang.String r11 = r0.getLogoUrl()
            r12.a((java.lang.String) r11)
            goto L_0x01f2
        L_0x01e7:
            java.lang.String r11 = r0.getTxnType()
            java.lang.String r1 = r0.getCategory()
            r12.a((java.lang.String) r11, (java.lang.String) r1)
        L_0x01f2:
            java.lang.String r11 = r0.getBusinessType()
            java.lang.String r1 = "MANDATE"
            boolean r11 = r1.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x050b
            net.one97.paytm.upi.common.upi.MandateDetails r11 = r0.getMandateDetails()
            java.lang.String r1 = "#FFAD00"
            if (r11 == 0) goto L_0x044a
            java.lang.String r4 = r11.getType()
            java.lang.String r7 = "ONETIME"
            boolean r4 = r7.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x044a
            if (r11 == 0) goto L_0x050e
            android.widget.ImageView r4 = r12.o
            r4.setVisibility(r2)
            android.widget.TextView r4 = r12.n
            r4.setVisibility(r2)
            android.widget.TextView r4 = r12.n
            net.one97.paytm.upi.passbook.view.c r6 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r6 = r6.f67747a
            int r7 = net.one97.paytm.upi.R.string.upi_recurring
            java.lang.String r6 = r6.getString(r7)
            r4.setText(r6)
            android.widget.TextView r4 = r12.n
            int r1 = android.graphics.Color.parseColor(r1)
            r4.setTextColor(r1)
            android.widget.ImageView r1 = r12.o
            int r4 = net.one97.paytm.upi.R.drawable.upi_ic_recurring
            r1.setImageResource(r4)
            java.lang.String r11 = r11.getMandateState()
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.PENDING_CANCELLATION
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.PENDING_DECLINE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.PENDING_CREATE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.PENDING_UPDATE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.ACTIVE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.SUCCESS_UPDATE_ACTIVE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.FAILED_UPDATE_ACTIVE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.FAILED_EXECUTION_ACTIVE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x040d
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.FAILED_REVOKE_ACTIVE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x02af
            goto L_0x040d
        L_0x02af:
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.PENDING_EXECUTE
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x03bd
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.DEEMED
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x02c9
            goto L_0x03bd
        L_0x02c9:
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.EXPIRED
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x0380
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.FAILED_EXECUTION_EXPIRED
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x02e3
            goto L_0x0380
        L_0x02e3:
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.CANCELLED
            java.lang.String r1 = r1.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x032f
            android.widget.TextView r11 = r12.f67787i
            android.content.Context r11 = r11.getContext()
            int r1 = net.one97.paytm.upi.R.color.color_b8c2cb
            int r11 = androidx.core.content.b.c(r11, r1)
            android.widget.TextView r1 = r12.f67787i
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67783e
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67782d
            r1.setTextColor(r11)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r4 = net.one97.paytm.upi.R.string.cancelled
            java.lang.String r1 = r1.getString(r4)
            r11.setText(r1)
            android.widget.TextView r11 = r12.f67787i
            r11.setPadding(r2, r2, r2, r2)
            android.widget.TextView r11 = r12.f67787i
            r11.setBackground(r5)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r3)
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r2)
            goto L_0x050e
        L_0x032f:
            net.one97.paytm.upi.mandate.utils.l r1 = net.one97.paytm.upi.mandate.utils.l.DECLINED
            java.lang.String r1 = r1.getStatus()
            boolean r11 = r1.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x037b
            android.widget.TextView r11 = r12.f67787i
            android.content.Context r11 = r11.getContext()
            int r1 = net.one97.paytm.upi.R.color.color_b8c2cb
            int r11 = androidx.core.content.b.c(r11, r1)
            android.widget.TextView r1 = r12.f67787i
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67783e
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67782d
            r1.setTextColor(r11)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r4 = net.one97.paytm.upi.R.string.declined
            java.lang.String r1 = r1.getString(r4)
            r11.setText(r1)
            android.widget.TextView r11 = r12.f67787i
            r11.setPadding(r2, r2, r2, r2)
            android.widget.TextView r11 = r12.f67787i
            r11.setBackground(r5)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r3)
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r2)
            goto L_0x050e
        L_0x037b:
            r12.a()
            goto L_0x050e
        L_0x0380:
            android.widget.TextView r11 = r12.f67787i
            android.widget.TextView r1 = r12.f67787i
            android.content.Context r1 = r1.getContext()
            int r3 = net.one97.paytm.upi.R.color.color_ff4b55
            int r1 = androidx.core.content.b.c(r1, r3)
            r11.setTextColor(r1)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r3 = net.one97.paytm.upi.R.string.expired
            java.lang.String r1 = r1.getString(r3)
            r11.setText(r1)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r2)
            android.widget.ImageView r11 = r12.f67781c
            int r1 = net.one97.paytm.upi.R.drawable.ic_status_failed
            r11.setImageResource(r1)
            android.widget.TextView r11 = r12.f67787i
            r11.setPadding(r2, r2, r2, r2)
            android.widget.TextView r11 = r12.f67787i
            r11.setBackground(r5)
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r2)
            goto L_0x050e
        L_0x03bd:
            android.widget.TextView r11 = r12.f67787i
            android.widget.TextView r1 = r12.f67787i
            android.content.Context r1 = r1.getContext()
            int r3 = net.one97.paytm.upi.R.color.color_ffa400
            int r1 = androidx.core.content.b.c(r1, r3)
            r11.setTextColor(r1)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r3 = net.one97.paytm.upi.R.string.upi_money_transfer_pending_status
            java.lang.String r1 = r1.getString(r3)
            r11.setText(r1)
            r11 = 1090519040(0x41000000, float:8.0)
            android.widget.TextView r1 = r12.f67787i
            android.content.Context r1 = r1.getContext()
            int r11 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r11, r1)
            r1 = 1082130432(0x40800000, float:4.0)
            android.widget.TextView r3 = r12.f67787i
            android.content.Context r3 = r3.getContext()
            int r1 = net.one97.paytm.upi.util.UpiAppUtils.convertDpToPixel(r1, r3)
            android.widget.TextView r3 = r12.f67787i
            r3.setPadding(r11, r1, r11, r1)
            android.widget.ImageView r11 = r12.f67781c
            int r1 = net.one97.paytm.upi.R.drawable.ic_upi_status_pending
            r11.setImageResource(r1)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r2)
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r2)
            goto L_0x050e
        L_0x040d:
            android.widget.TextView r11 = r12.f67787i
            android.content.Context r11 = r11.getContext()
            int r1 = net.one97.paytm.upi.R.color.color_b8c2cb
            int r11 = androidx.core.content.b.c(r11, r1)
            android.widget.TextView r1 = r12.f67787i
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67783e
            r1.setTextColor(r11)
            android.widget.TextView r1 = r12.f67782d
            r1.setTextColor(r11)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r3 = net.one97.paytm.upi.R.string.upi_money_on_hold
            java.lang.String r1 = r1.getString(r3)
            r11.setText(r1)
            android.widget.ImageView r11 = r12.f67781c
            int r1 = net.one97.paytm.upi.R.drawable.ic_money_on_hold
            r11.setImageResource(r1)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r2)
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r2)
            goto L_0x050e
        L_0x044a:
            java.lang.String r11 = r0.getStatus()
            android.widget.ImageView r4 = r12.o
            r4.setVisibility(r2)
            android.widget.TextView r4 = r12.n
            r4.setVisibility(r2)
            android.widget.TextView r4 = r12.n
            net.one97.paytm.upi.passbook.view.c r5 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r5 = r5.f67747a
            int r7 = net.one97.paytm.upi.R.string.upi_recurring
            java.lang.String r5 = r5.getString(r7)
            r4.setText(r5)
            android.widget.TextView r4 = r12.n
            int r1 = android.graphics.Color.parseColor(r1)
            r4.setTextColor(r1)
            android.widget.ImageView r1 = r12.o
            int r4 = net.one97.paytm.upi.R.drawable.upi_ic_recurring
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r12.f67781c
            r1.setVisibility(r2)
            android.widget.TextView r1 = r12.f67787i
            r1.setVisibility(r2)
            boolean r1 = r11.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0499
            android.widget.TextView r11 = r12.f67787i
            r11.setVisibility(r3)
            android.widget.ImageView r11 = r12.f67781c
            r11.setVisibility(r3)
            android.widget.TextView r11 = r12.f67783e
            android.graphics.Typeface r1 = android.graphics.Typeface.SANS_SERIF
            r11.setTypeface(r1, r2)
            goto L_0x050e
        L_0x0499:
            java.lang.String r1 = "PENDING"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x04d0
            android.widget.ImageView r11 = r12.f67781c
            int r1 = net.one97.paytm.upi.R.drawable.ic_upi_status_pending
            r11.setImageResource(r1)
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r3 = net.one97.paytm.upi.R.string.pending
            java.lang.String r1 = r1.getString(r3)
            r11.setText(r1)
            android.widget.TextView r11 = r12.f67787i
            android.widget.TextView r1 = r12.f67787i
            android.content.Context r1 = r1.getContext()
            int r3 = net.one97.paytm.upi.R.color.color_ffa400
            int r1 = androidx.core.content.b.c(r1, r3)
            r11.setTextColor(r1)
            android.widget.TextView r11 = r12.f67783e
            android.graphics.Typeface r1 = android.graphics.Typeface.SANS_SERIF
            r11.setTypeface(r1, r2)
            goto L_0x050e
        L_0x04d0:
            java.lang.String r1 = "FAILURE"
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L_0x050e
            android.widget.TextView r11 = r12.f67787i
            net.one97.paytm.upi.passbook.view.c r1 = net.one97.paytm.upi.passbook.view.c.this
            android.content.Context r1 = r1.f67747a
            int r3 = net.one97.paytm.upi.R.string.failed
            java.lang.String r1 = r1.getString(r3)
            r11.setText(r1)
            android.widget.TextView r11 = r12.f67787i
            android.widget.TextView r1 = r12.f67787i
            android.content.Context r1 = r1.getContext()
            int r3 = net.one97.paytm.upi.R.color.color_ff4b55
            int r1 = androidx.core.content.b.c(r1, r3)
            r11.setTextColor(r1)
            android.widget.ImageView r11 = r12.f67781c
            int r1 = net.one97.paytm.upi.R.drawable.ic_status_failed
            r11.setImageResource(r1)
            android.widget.TextView r11 = r12.f67783e
            java.lang.String r1 = "sans-serif-light"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r2)
            r11.setTypeface(r1, r2)
            goto L_0x050e
        L_0x050b:
            r12.a()
        L_0x050e:
            java.lang.String r11 = r0.getDate()
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.formatUpiDateTime(r11)
            android.widget.TextView r1 = r12.f67785g
            r1.setText(r11)
            android.view.View r11 = r12.itemView
            net.one97.paytm.upi.passbook.c.b$1 r12 = new net.one97.paytm.upi.passbook.c.b$1
            r12.<init>(r0)
            r11.setOnClickListener(r12)
            return
        L_0x0526:
            int r0 = r10.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED
            int r1 = r1.ordinal()
            java.lang.String r2 = "RECEIVED"
            if (r0 != r1) goto L_0x0575
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r0 = r10.f67693c
            java.lang.Object r0 = r0.get(r11)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r0 = (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r0
            java.lang.String r1 = r0.getAmount()
            r12.d(r1)
            java.lang.String r1 = r0.getDirection()
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0566
            java.lang.String r1 = r0.getPayeeName()
            r12.a(r4, r4, r1)
            java.lang.String r1 = r0.getPayeeVa()
            r12.e(r1)
            r0.getPayeeName()
            r12.a((int) r11)
            java.lang.String r1 = r0.getPayeeName()
            r12.a((java.lang.String) r1, (int) r11)
        L_0x0566:
            r12.c(r4)
            java.lang.String r11 = r0.getExpireAfter()
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.formatUpiDateTime(r11)
            r12.f(r11)
            return
        L_0x0575:
            int r0 = r10.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.PENDING_REQUESTS_SENT
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x05ca
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r0 = r10.p
            java.lang.Object r0 = r0.get(r11)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r0 = (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r0
            if (r11 != 0) goto L_0x0592
            net.one97.paytm.upi.passbook.a.a$b r1 = r10.f67691a
            java.lang.String r3 = r0.getDate()
            r1.a((java.lang.String) r3)
        L_0x0592:
            java.lang.String r1 = r0.getAmount()
            r12.d(r1)
            java.lang.String r1 = r0.getDirection()
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x05bb
            java.lang.String r1 = r0.getPayerName()
            r12.a(r4, r4, r1)
            java.lang.String r1 = r0.getPayerVa()
            r12.e(r1)
            r12.a((int) r11)
            java.lang.String r1 = r0.getPayerName()
            r12.a((java.lang.String) r1, (int) r11)
        L_0x05bb:
            r12.c(r4)
            java.lang.String r11 = r0.getExpireAfter()
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.formatUpiDateTime(r11)
            r12.f(r11)
            return
        L_0x05ca:
            int r0 = r10.f67694d
            net.one97.paytm.upi.util.UpiConstants$UpiItemType r1 = net.one97.paytm.upi.util.UpiConstants.UpiItemType.SPAM_REQUESTS
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x0614
            java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel> r0 = r10.q
            java.lang.Object r0 = r0.get(r11)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r0 = (net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r0
            if (r11 != 0) goto L_0x05e7
            net.one97.paytm.upi.passbook.a.a$b r1 = r10.f67691a
            java.lang.String r2 = r0.getDate()
            r1.a((java.lang.String) r2)
        L_0x05e7:
            java.lang.String r1 = r0.getAmount()
            r12.d(r1)
            java.lang.String r1 = r0.getPayeeName()
            r12.a(r4, r4, r1)
            java.lang.String r1 = r0.getPayeeVa()
            r12.e(r1)
            r12.a((int) r11)
            java.lang.String r1 = r0.getPayeeName()
            r12.a((java.lang.String) r1, (int) r11)
            r12.c(r4)
            java.lang.String r11 = r0.getExpireAfter()
            java.lang.String r11 = net.one97.paytm.upi.util.UpiUtils.formatUpiDateTime(r11)
            r12.f(r11)
        L_0x0614:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.passbook.c.b.a(int, net.one97.paytm.upi.passbook.view.c$a):void");
    }
}
