package net.one97.paytm.wallet.rateMerchant.c;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.base.e;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import net.one97.paytm.wallet.rateMerchant.entity.QnAModel;
import net.one97.paytm.wallet.rateMerchant.entity.QnARequestBody;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestion;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse;

public final class a extends e {

    /* renamed from: i  reason: collision with root package name */
    public static final C1460a f71678i = new C1460a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public final y<MerchantPPReviewData> f71679b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f71680c = true;

    /* renamed from: d  reason: collision with root package name */
    public float f71681d;

    /* renamed from: e  reason: collision with root package name */
    public MerchantPPReviewData f71682e;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<String>> f71683f;

    /* renamed from: g  reason: collision with root package name */
    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> f71684g;

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<ReviewQuestionResponse>> f71685h;
    private final y<net.one97.paytm.wallet.rateMerchant.entity.a> j = new y<>();
    private final y<o<Float, String>> k = new y<>();
    private y<QnARequestBody> l = new y<>();
    private final List<QnAModel> m = new ArrayList();
    /* access modifiers changed from: private */
    public final net.one97.paytm.wallet.rateMerchant.b.c n;

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f71686a;

        b(a aVar) {
            this.f71686a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.wallet.rateMerchant.entity.a aVar = (net.one97.paytm.wallet.rateMerchant.entity.a) obj;
            return this.f71686a.n.a(aVar.f71709a, aVar.f71710b, "channels/payment-success");
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f71687a;

        c(a aVar) {
            this.f71687a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            QnARequestBody qnARequestBody = (QnARequestBody) obj;
            net.one97.paytm.wallet.rateMerchant.b.c a2 = this.f71687a.n;
            k.a((Object) qnARequestBody, "it");
            return a2.a(qnARequestBody);
        }
    }

    static final class d<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f71688a;

        d(a aVar) {
            this.f71688a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            o oVar = (o) obj;
            net.one97.paytm.wallet.rateMerchant.b.c a2 = this.f71688a.n;
            String a3 = this.f71688a.a();
            if (a3 == null) {
                k.a();
            }
            String b2 = this.f71688a.e();
            if (b2 == null) {
                k.a();
            }
            String c2 = this.f71688a.d();
            if (c2 == null) {
                k.a();
            }
            return a2.a(a3, b2, c2, ((Number) oVar.getFirst()).floatValue(), (String) oVar.getSecond(), "channels/payment-success");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(net.one97.paytm.wallet.rateMerchant.b.c r3) {
        /*
            r2 = this;
            java.lang.String r0 = "channelsRepository"
            kotlin.g.b.k.c(r3, r0)
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r1 = "WalletCommManager.getWalletCommunicator()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.app.Application r0 = r0.getApplication()
            java.lang.String r1 = "WalletCommManager.getWal…ommunicator().application"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r2.<init>(r0)
            r2.n = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.j = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.f71679b = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.k = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.l = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            r2.m = r3
            r3 = 1
            r2.f71680c = r3
            net.one97.paytm.wallet.rateMerchant.b.c r3 = r2.n
            net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData r3 = r3.a()
            a((net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData) r3)
            androidx.lifecycle.y<net.one97.paytm.wallet.rateMerchant.entity.a> r3 = r2.j
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.a$b r0 = new net.one97.paytm.wallet.rateMerchant.c.a$b
            r0.<init>(r2)
            androidx.arch.core.c.a r0 = (androidx.arch.core.c.a) r0
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r0)
            java.lang.String r0 = "Transformations.switchMa…ME_PAYMENT_SUCCESS)\n    }"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.f71683f = r3
            androidx.lifecycle.y<kotlin.o<java.lang.Float, java.lang.String>> r3 = r2.k
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.a$d r1 = new net.one97.paytm.wallet.rateMerchant.c.a$d
            r1.<init>(r2)
            androidx.arch.core.c.a r1 = (androidx.arch.core.c.a) r1
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r1)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.f71684g = r3
            androidx.lifecycle.y<net.one97.paytm.wallet.rateMerchant.entity.QnARequestBody> r3 = r2.l
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.a$c r0 = new net.one97.paytm.wallet.rateMerchant.c.a$c
            r0.<init>(r2)
            androidx.arch.core.c.a r0 = (androidx.arch.core.c.a) r0
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r0)
            java.lang.String r0 = "Transformations.switchMa….getQnAResponse(it)\n    }"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.f71685h = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.rateMerchant.c.a.<init>(net.one97.paytm.wallet.rateMerchant.b.c):void");
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.c.a$a  reason: collision with other inner class name */
    public static final class C1460a {
        private C1460a() {
        }

        public /* synthetic */ C1460a(byte b2) {
            this();
        }
    }

    public static void a(MerchantPPReviewData merchantPPReviewData) {
        if (merchantPPReviewData != null) {
            try {
                TextUtils.isEmpty(merchantPPReviewData.getContractId());
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str, Object obj) {
        k.c(str, "eventName");
        switch (str.hashCode()) {
            case -1337339506:
                if (str.equals("toggle_follow_state")) {
                    c();
                    return;
                }
                return;
            case -252144087:
                if (str.equals("rate_experience")) {
                    g();
                    return;
                }
                return;
            case 385925951:
                if (!str.equals("multichoice_answer_submitted")) {
                    return;
                }
                break;
            case 796374687:
                if (str.equals("save_rating")) {
                    if (obj == null) {
                        k.a();
                    }
                    if (obj != null) {
                        float floatValue = ((Float) obj).floatValue();
                        if (floatValue != 0.0f) {
                            a(floatValue);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.Float");
                }
                return;
            case 916558672:
                if (!str.equals("singlechoice_answer_submitted")) {
                    return;
                }
                break;
            case 1726526815:
                if (str.equals("get_rating_question")) {
                    if (obj == null) {
                        k.a();
                    }
                    if (obj != null) {
                        float floatValue2 = ((Float) obj).floatValue();
                        if (floatValue2 != 0.0f) {
                            b(floatValue2);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.Float");
                }
                return;
            default:
                return;
        }
        if (!(obj instanceof QnAModel)) {
            obj = null;
        }
        a((QnAModel) obj);
    }

    private void c() {
        if (!TextUtils.isEmpty(a())) {
            this.f71680c = !this.f71680c;
            y<net.one97.paytm.wallet.rateMerchant.entity.a> yVar = this.j;
            String a2 = a();
            if (a2 == null) {
                k.a();
            }
            yVar.setValue(new net.one97.paytm.wallet.rateMerchant.entity.a(a2, this.f71680c));
        }
    }

    private final void a(float f2) {
        if (!TextUtils.isEmpty(a()) && !TextUtils.isEmpty(e()) && !TextUtils.isEmpty(d())) {
            this.f71681d = f2;
            this.k.setValue(new o(Float.valueOf(f2), f()));
        }
    }

    public final String a() {
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        if (merchantPPReviewData != null) {
            return merchantPPReviewData.getContractId();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final String d() {
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        if (merchantPPReviewData != null) {
            return merchantPPReviewData.getClientSecret();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final String e() {
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        if (merchantPPReviewData != null) {
            return merchantPPReviewData.getClientId();
        }
        return null;
    }

    public final List<String> b() {
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        if (merchantPPReviewData != null) {
            return merchantPPReviewData.getCategories();
        }
        return null;
    }

    private final String f() {
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        if (merchantPPReviewData != null) {
            return merchantPPReviewData.getReview();
        }
        return null;
    }

    private final void b(float f2) {
        this.f71681d = f2;
        MerchantPPReviewData merchantPPReviewData = this.f71682e;
        this.f71682e = merchantPPReviewData != null ? MerchantPPReviewData.copy$default(merchantPPReviewData, false, Float.valueOf(f2), (String) null, (String) null, (String) null, (List) null, (ReviewQuestion) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Integer) null, 8125, (Object) null) : null;
        this.f71679b.setValue(this.f71682e);
        this.l.setValue(new QnARequestBody((List<QnAModel>) null, a(), b(), String.valueOf(f2)));
    }

    private final void a(QnAModel qnAModel) {
        if (qnAModel != null) {
            this.m.add(0, qnAModel);
            this.l.setValue(new QnARequestBody(kotlin.a.k.e(this.m), a(), b(), (String) null, 8, (g) null));
        }
    }

    private final void g() {
        this.m.clear();
    }
}
