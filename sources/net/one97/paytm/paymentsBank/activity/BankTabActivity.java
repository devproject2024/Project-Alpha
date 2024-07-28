package net.one97.paytm.paymentsBank.activity;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.paytm.utility.n;
import kotlin.d.d;
import kotlin.m.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.location.a;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.BankTabPasscodeFragment;
import net.one97.paytm.paymentsBank.i.a;
import net.one97.paytm.paymentsBank.permission.a;
import net.one97.paytm.paymentsBank.utils.k;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class BankTabActivity extends PaytmActivity implements net.one97.paytm.bankCommon.location.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.i.a f17380a;

    /* renamed from: b  reason: collision with root package name */
    public String f17381b;

    static final class a<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankTabActivity f17382a;

        a(BankTabActivity bankTabActivity) {
            this.f17382a = bankTabActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.bankCommon.b.c r4 = (net.one97.paytm.bankCommon.b.c) r4
                if (r4 == 0) goto L_0x008b
                net.one97.paytm.bankCommon.b.d r0 = r4.f16216a
                net.one97.paytm.bankCommon.b.d r1 = net.one97.paytm.bankCommon.b.d.SUCCESS
                r2 = 0
                if (r0 != r1) goto L_0x0053
                T r4 = r4.f16217b
                if (r4 == 0) goto L_0x004b
                net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse r4 = (net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse) r4
                if (r4 == 0) goto L_0x0017
                java.lang.Integer r2 = r4.getResponseCode()
            L_0x0017:
                if (r2 == 0) goto L_0x0027
                int r0 = r2.intValue()
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 != r1) goto L_0x0027
                net.one97.paytm.paymentsBank.activity.BankTabActivity r4 = r3.f17382a
                r4.finish()
                return
            L_0x0027:
                if (r4 == 0) goto L_0x002f
                java.lang.String r4 = r4.getMessage()
                if (r4 != 0) goto L_0x003c
            L_0x002f:
                net.one97.paytm.paymentsBank.activity.BankTabActivity r4 = r3.f17382a
                int r0 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
                java.lang.String r4 = r4.getString(r0)
                java.lang.String r0 = "getString(R.string.some_went_wrong)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            L_0x003c:
                net.one97.paytm.paymentsBank.activity.BankTabActivity r0 = r3.f17382a
                r1 = r0
                android.content.Context r1 = (android.content.Context) r1
                int r2 = net.one97.paytm.paymentsBank.R.string.error
                java.lang.String r0 = r0.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4)
                return
            L_0x004b:
                kotlin.u r4 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse"
                r4.<init>(r0)
                throw r4
            L_0x0053:
                net.one97.paytm.bankCommon.b.d r0 = r4.f16216a
                net.one97.paytm.bankCommon.b.d r1 = net.one97.paytm.bankCommon.b.d.ERROR
                if (r0 != r1) goto L_0x008b
                net.one97.paytm.paymentsBank.activity.BankTabActivity r0 = r3.f17382a
                int r1 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
                java.lang.String r0 = r0.getString(r1)
                java.lang.Throwable r1 = r4.f16218c
                boolean r1 = r1 instanceof com.paytm.network.model.NetworkCustomError
                if (r1 == 0) goto L_0x007d
                java.lang.Throwable r4 = r4.f16218c
                if (r4 == 0) goto L_0x0075
                com.paytm.network.model.NetworkCustomError r4 = (com.paytm.network.model.NetworkCustomError) r4
                if (r4 == 0) goto L_0x0073
                java.lang.String r2 = r4.getAlertMessage()
            L_0x0073:
                r0 = r2
                goto L_0x007d
            L_0x0075:
                kotlin.u r4 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError"
                r4.<init>(r0)
                throw r4
            L_0x007d:
                net.one97.paytm.paymentsBank.activity.BankTabActivity r4 = r3.f17382a
                r1 = r4
                android.content.Context r1 = (android.content.Context) r1
                int r2 = net.one97.paytm.paymentsBank.R.string.error
                java.lang.String r4 = r4.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r4, (java.lang.String) r0)
            L_0x008b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.activity.BankTabActivity.a.onChanged(java.lang.Object):void");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_tab_acticity);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        V_();
        k.a aVar = k.f19520a;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "application");
        ai a2 = new al((ao) this, (al.b) k.a.a(application)).a(net.one97.paytm.paymentsBank.i.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProvider(this,P…odeViewModel::class.java)");
        this.f17380a = (net.one97.paytm.paymentsBank.i.a) a2;
        net.one97.paytm.paymentsBank.i.a aVar2 = this.f17380a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("bankTabPassCodeViewModel");
        }
        aVar2.f18548b.observe(this, new a(this));
        net.one97.paytm.paymentsBank.h.a a3 = o.a();
        kotlin.g.b.k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
        String a4 = n.a(a3.getApplicationContext());
        kotlin.g.b.k.a((Object) a4, "LocaleHelper.getLanguage…ner().applicationContext)");
        this.f17381b = a4;
    }

    public final void V_() {
        Context context = this;
        String s = com.paytm.utility.b.s(context);
        String t = com.paytm.utility.b.t(context);
        if (!TextUtils.isEmpty(s) || !TextUtils.isEmpty(t)) {
            BankTabPasscodeFragment bankTabPasscodeFragment = new BankTabPasscodeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("redirectTo", 100);
            bankTabPasscodeFragment.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.container, bankTabPasscodeFragment).c();
            return;
        }
        a.C0226a aVar = net.one97.paytm.bankCommon.location.a.f16282b;
        net.one97.paytm.bankCommon.location.a aVar2 = new net.one97.paytm.bankCommon.location.a();
        a.C0321a aVar3 = net.one97.paytm.paymentsBank.permission.a.f18753b;
        getSupportFragmentManager().a().b(R.id.container, aVar2, net.one97.paytm.paymentsBank.permission.a.j).c();
    }

    public final void attachBaseContext(Context context) {
        if (f.d()) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(f.a().getBaseContext(context));
        }
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(R.id.container);
        if (c2 != null && (c2 instanceof BankTabPasscodeFragment)) {
            View view = ((BankTabPasscodeFragment) c2).getView();
            ScrollView scrollView = view != null ? (ScrollView) view.findViewById(R.id.fragment_enter_passcode_lyt) : null;
            if (scrollView == null || scrollView.getVisibility() != 0) {
                b();
            } else {
                finish();
            }
        } else if (c2 == null || !(c2 instanceof net.one97.paytm.bankCommon.location.a)) {
            b();
        } else {
            finish();
        }
    }

    private final void b() {
        c.a aVar = new c.a(this);
        aVar.b((CharSequence) getString(R.string.pb_are_sure_logout_desc));
        aVar.a(true);
        aVar.a(R.string.pb_home_logout_from_bank_btn_txt, (DialogInterface.OnClickListener) new b(this));
        aVar.b(R.string.pb_home_cancel_from_bank_btn_txt, (DialogInterface.OnClickListener) c.f17384a);
        aVar.b();
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankTabActivity f17383a;

        b(BankTabActivity bankTabActivity) {
            this.f17383a = bankTabActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.paymentsBank.i.a aVar = this.f17383a.f17380a;
            if (aVar == null) {
                kotlin.g.b.k.a("bankTabPassCodeViewModel");
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(aVar), (kotlin.d.f) null, (CoroutineStart) null, new a.C0318a(aVar, (d) null), 3, (Object) null);
            dialogInterface.dismiss();
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f17384a = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.bankCommon.utils.b a2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 112) {
            if (i3 == -1) {
                net.one97.paytm.paymentsBank.h.a a3 = o.a();
                kotlin.g.b.k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
                String a4 = n.a(a3.getApplicationContext());
                kotlin.g.b.k.a((Object) a4, "LocaleHelper.getLanguage…ner().applicationContext)");
                String str = this.f17381b;
                if (str == null) {
                    kotlin.g.b.k.a("currentLanguage");
                }
                CharSequence charSequence = str;
                boolean z = false;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    CharSequence charSequence2 = a4;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        String str2 = this.f17381b;
                        if (str2 == null) {
                            kotlin.g.b.k.a("currentLanguage");
                        }
                        if (p.a(a4, str2, true)) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                net.one97.paytm.paymentsBank.h.a a5 = o.a();
                kotlin.g.b.k.a((Object) a5, "PaymentsBankHelper.getImplListener()");
                Intent intent2 = new Intent(this, a5.getMainActivityClass());
                intent2.setFlags(268468224);
                startActivity(intent2);
                finish();
            }
        } else if (i2 == 1) {
            j supportFragmentManager = getSupportFragmentManager();
            a.C0321a aVar = net.one97.paytm.paymentsBank.permission.a.f18753b;
            Fragment c2 = supportFragmentManager.c(net.one97.paytm.paymentsBank.permission.a.j);
            if (!(c2 instanceof net.one97.paytm.bankCommon.location.a)) {
                c2 = null;
            }
            net.one97.paytm.bankCommon.location.a aVar2 = (net.one97.paytm.bankCommon.location.a) c2;
            if (aVar2 != null && (a2 = aVar2.a()) != null) {
                a2.a(i3);
            }
        }
    }
}
