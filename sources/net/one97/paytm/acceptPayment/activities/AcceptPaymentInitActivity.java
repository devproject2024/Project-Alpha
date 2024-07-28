package net.one97.paytm.acceptPayment.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.h;
import net.one97.paytm.acceptPayment.utils.c;
import net.one97.paytm.acceptPayment.viewModel.ForceUpdateProvider;
import net.one97.paytm.acceptPayment.viewModel.e;
import net.one97.paytm.acceptPayment.viewModel.f;
import net.one97.paytm.acceptPayment.viewModel.j;
import net.one97.paytm.acceptPayment.viewModel.l;
import net.one97.paytm.acceptPayment.viewModel.m;
import net.one97.paytm.acceptPayment.viewModel.n;

public final class AcceptPaymentInitActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.acceptPayment.a.a f52018a;

    /* renamed from: b  reason: collision with root package name */
    public ForceUpdateProvider f52019b;

    /* renamed from: e  reason: collision with root package name */
    private final g f52020e = h.a(new a(this));
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f52021f;

    public final net.one97.paytm.acceptPayment.viewModel.b a() {
        return (net.one97.paytm.acceptPayment.viewModel.b) this.f52020e.getValue();
    }

    static final class b<T> implements z<n> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentInitActivity f52022a;

        b(AcceptPaymentInitActivity acceptPaymentInitActivity) {
            this.f52022a = acceptPaymentInitActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            n nVar = (n) obj;
            if (nVar instanceof m) {
                m mVar = (m) nVar;
                AcceptPaymentInitActivity.a(this.f52022a, mVar.f52205a, mVar.f52206b);
            } else if (nVar instanceof l) {
                AcceptPaymentInitActivity.a(this.f52022a, true);
            } else if (nVar instanceof net.one97.paytm.acceptPayment.viewModel.h) {
                AcceptPaymentInitActivity.a(this.f52022a, false);
            } else if (nVar instanceof j) {
                com.paytm.network.a aVar = ((j) nVar).f52202a;
                if (aVar != null) {
                    net.one97.paytm.acceptPayment.configs.a a2 = net.one97.paytm.acceptPayment.configs.a.a();
                    k.b(a2, "AcceptPaymentsConfig.getInstance()");
                    a2.b().a(aVar, (Context) this.f52022a);
                }
            } else if (nVar instanceof net.one97.paytm.acceptPayment.viewModel.g) {
                net.one97.paytm.acceptPayment.viewModel.b a3 = this.f52022a.a();
                l lVar = l.f52204a;
                k.d(lVar, "newState");
                a3.f52189i.postValue(lVar);
                net.one97.paytm.acceptPayment.configs.a a4 = net.one97.paytm.acceptPayment.configs.a.a();
                k.b(a4, "AcceptPaymentsConfig.getInstance()");
                a4.b().a((Context) this.f52022a, ((net.one97.paytm.acceptPayment.viewModel.g) nVar).f52199a);
            } else if (nVar instanceof f) {
                AcceptPaymentInitActivity.a(this.f52022a, false);
                f fVar = (f) nVar;
                NetworkCustomError networkCustomError = fVar.f52198b;
                if (networkCustomError != null) {
                    c cVar = c.f52162a;
                    c.a(this.f52022a, fVar.f52197a, networkCustomError);
                }
            } else if (nVar instanceof net.one97.paytm.acceptPayment.viewModel.k) {
                this.f52022a.f52021f = true;
                ForceUpdateProvider forceUpdateProvider = this.f52022a.f52019b;
                if (forceUpdateProvider == null) {
                    k.a("forceUpdateProvider");
                }
                net.one97.paytm.acceptPayment.viewModel.k kVar = (net.one97.paytm.acceptPayment.viewModel.k) nVar;
                String heading = kVar.f52203a.getHeading();
                String subHeading = kVar.f52203a.getSubHeading();
                String cta = kVar.f52203a.getCta();
                AcceptPaymentInitActivity acceptPaymentInitActivity = this.f52022a;
                k.d(heading, "heading");
                k.d(subHeading, "message");
                k.d(cta, Item.KEY_CTA);
                k.d(acceptPaymentInitActivity, "activity");
                AlertDialog.Builder builder = new AlertDialog.Builder(acceptPaymentInitActivity);
                builder.setMessage(subHeading).setTitle(heading).setPositiveButton(cta, ForceUpdateProvider.a.f52169a).setOnKeyListener(new ForceUpdateProvider.b(acceptPaymentInitActivity));
                AlertDialog create = builder.create();
                forceUpdateProvider.f52167a = create;
                if (create != null) {
                    create.setCanceledOnTouchOutside(false);
                }
                AlertDialog alertDialog = forceUpdateProvider.f52167a;
                if (alertDialog != null) {
                    alertDialog.show();
                }
            } else if (nVar instanceof e) {
                AcceptPaymentInitActivity.a(this.f52022a, false);
                this.f52022a.finish();
            }
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<net.one97.paytm.acceptPayment.viewModel.b> {
        final /* synthetic */ AcceptPaymentInitActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AcceptPaymentInitActivity acceptPaymentInitActivity) {
            super(0);
            this.this$0 = acceptPaymentInitActivity;
        }

        public final net.one97.paytm.acceptPayment.viewModel.b invoke() {
            ai a2 = am.a((FragmentActivity) this.this$0).a(net.one97.paytm.acceptPayment.viewModel.b.class);
            k.b(a2, "ViewModelProviders.of(th…nitViewmodel::class.java)");
            return (net.one97.paytm.acceptPayment.viewModel.b) a2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a8, code lost:
        if ((((int) (java.lang.System.currentTimeMillis() - net.one97.paytm.acceptPayment.utils.b.b(r7.f52171a))) / 21600000) < 6) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            net.one97.paytm.acceptPayment.viewModel.b r7 = r6.a()
            java.lang.Class<net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity> r0 = net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "AcceptPaymentInitActivity::class.java.simpleName"
            kotlin.g.b.k.b(r0, r1)
            r7.a((java.lang.String) r0)
            int r7 = net.one97.paytm.acceptPayment.R.layout.accept_payment_init
            androidx.databinding.ViewDataBinding r7 = androidx.databinding.f.a(r6, r7)
            java.lang.String r0 = "DataBindingUtil.setConte…yout.accept_payment_init)"
            kotlin.g.b.k.b(r7, r0)
            net.one97.paytm.acceptPayment.a.a r7 = (net.one97.paytm.acceptPayment.a.a) r7
            r6.f52018a = r7
            net.one97.paytm.acceptPayment.viewModel.ForceUpdateProvider r7 = new net.one97.paytm.acceptPayment.viewModel.ForceUpdateProvider
            androidx.lifecycle.k r0 = r6.getLifecycle()
            java.lang.String r1 = "lifecycle"
            kotlin.g.b.k.b(r0, r1)
            r7.<init>(r0)
            r6.f52019b = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "deeplinkdata"
            android.os.Parcelable r7 = r7.getParcelableExtra(r0)
            net.one97.paytm.deeplink.DeepLinkData r7 = (net.one97.paytm.deeplink.DeepLinkData) r7
            net.one97.paytm.acceptPayment.viewModel.b r0 = r6.a()
            r0.f52172b = r7
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            com.business.common_module.b.j r7 = r7.appSharedPreference
            java.lang.String r0 = com.paytm.utility.d.a(r6)
            java.lang.String r1 = "user_token"
            r7.a((android.content.Context) r6, (java.lang.String) r1, (java.lang.String) r0)
            net.one97.paytm.acceptPayment.viewModel.b r7 = r6.a()
            androidx.lifecycle.w<net.one97.paytm.acceptPayment.viewModel.n> r7 = r7.f52189i
            net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity$b r0 = new net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity$b
            r0.<init>(r6)
            r7.observe(r6, r0)
            net.one97.paytm.acceptPayment.viewModel.b r7 = r6.a()
            net.one97.paytm.deeplink.DeepLinkData r0 = r7.f52172b
            if (r0 == 0) goto L_0x0076
            android.net.Uri r0 = r0.f50289g
            if (r0 == 0) goto L_0x0076
            java.lang.String r1 = "pageId"
            java.lang.String r0 = r0.getQueryParameter(r1)
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            java.lang.String r1 = "onboarding"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            r7.f52174d = r0
            if (r0 != 0) goto L_0x00cd
            net.one97.paytm.acceptPayment.viewModel.d$a r0 = r7.f52175e
            boolean r0 = r0.a()
            r1 = 0
            if (r0 == 0) goto L_0x008b
            goto L_0x00ac
        L_0x008b:
            net.one97.paytm.acceptPayment.d.a r0 = net.one97.paytm.acceptPayment.d.a.f52050a
            java.lang.String r0 = r0.D()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ab
            android.content.Context r0 = r7.f52171a
            long r2 = net.one97.paytm.acceptPayment.utils.b.b((android.content.Context) r0)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r0 = (int) r4
            r2 = 21600000(0x1499700, float:3.7026207E-38)
            int r0 = r0 / r2
            r2 = 6
            if (r0 >= r2) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r1 = 1
        L_0x00ac:
            if (r1 == 0) goto L_0x00b4
            net.one97.paytm.acceptPayment.viewModel.d$a r7 = r7.f52175e
            r7.b()
            return
        L_0x00b4:
            net.one97.paytm.acceptPayment.b.b r0 = net.one97.paytm.acceptPayment.b.b.a()
            java.lang.String r1 = "GTMHelper.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            boolean r0 = net.one97.paytm.acceptPayment.b.b.h()
            if (r0 == 0) goto L_0x00c9
            net.one97.paytm.acceptPayment.viewModel.d$a r7 = r7.f52176f
            r7.b()
            return
        L_0x00c9:
            r7.a()
            return
        L_0x00cd:
            r7.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity.onCreate(android.os.Bundle):void");
    }

    public final void onResume() {
        AlertDialog alertDialog;
        super.onResume();
        if (this.f52021f) {
            ForceUpdateProvider forceUpdateProvider = this.f52019b;
            if (forceUpdateProvider == null) {
                k.a("forceUpdateProvider");
            }
            AlertDialog alertDialog2 = forceUpdateProvider.f52167a;
            if (alertDialog2 != null && !alertDialog2.isShowing() && (alertDialog = forceUpdateProvider.f52167a) != null) {
                alertDialog.show();
            }
        }
    }

    public static final /* synthetic */ void a(AcceptPaymentInitActivity acceptPaymentInitActivity, Class cls, Map map) {
        Intent intent = new Intent(acceptPaymentInitActivity, cls);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                intent.putExtra((String) entry.getKey(), (String) entry.getValue());
            }
        }
        intent.setFlags(67108864);
        acceptPaymentInitActivity.startActivity(intent);
        acceptPaymentInitActivity.overridePendingTransition(0, 0);
        acceptPaymentInitActivity.finish();
    }

    public static final /* synthetic */ void a(AcceptPaymentInitActivity acceptPaymentInitActivity, boolean z) {
        if (z) {
            net.one97.paytm.acceptPayment.a.a aVar = acceptPaymentInitActivity.f52018a;
            if (aVar == null) {
                k.a("mBinding");
            }
            LottieAnimationView lottieAnimationView = aVar.f51966a;
            k.b(lottieAnimationView, "mBinding.loader");
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.acceptPayment.a.a aVar2 = acceptPaymentInitActivity.f52018a;
            if (aVar2 == null) {
                k.a("mBinding");
            }
            net.one97.paytm.common.widgets.a.a(aVar2.f51966a);
            return;
        }
        net.one97.paytm.acceptPayment.a.a aVar3 = acceptPaymentInitActivity.f52018a;
        if (aVar3 == null) {
            k.a("mBinding");
        }
        net.one97.paytm.common.widgets.a.b(aVar3.f51966a);
        net.one97.paytm.acceptPayment.a.a aVar4 = acceptPaymentInitActivity.f52018a;
        if (aVar4 == null) {
            k.a("mBinding");
        }
        LottieAnimationView lottieAnimationView2 = aVar4.f51966a;
        k.b(lottieAnimationView2, "mBinding.loader");
        lottieAnimationView2.setVisibility(8);
    }
}
