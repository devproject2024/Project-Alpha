package net.one97.paytm.newaddmoney.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.j;
import org.json.JSONObject;

public final class AddMoneyNewActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public View f55855a;

    /* renamed from: b  reason: collision with root package name */
    private String f55856b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.newaddmoney.c.a f55857c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f55858d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f55859e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f55860f;

    /* renamed from: g  reason: collision with root package name */
    private String f55861g;

    static final class a<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55862a;

        a(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55862a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            AddMoneyNewActivity addMoneyNewActivity = this.f55862a;
            k.a((Object) bool, "isShow");
            View view = null;
            if (bool.booleanValue()) {
                if (addMoneyNewActivity.f55855a != null) {
                    View a2 = addMoneyNewActivity.f55855a;
                    if ((a2 != null ? a2.findViewById(R.id.wallet_loader) : null) != null) {
                        View a3 = addMoneyNewActivity.f55855a;
                        if (a3 != null) {
                            view = a3.findViewById(R.id.wallet_loader);
                        }
                        if (view != null) {
                            net.one97.paytm.common.widgets.a.a((LottieAnimationView) view);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                    }
                }
            } else if (addMoneyNewActivity.f55855a != null) {
                View a4 = addMoneyNewActivity.f55855a;
                if ((a4 != null ? a4.findViewById(R.id.wallet_loader) : null) != null) {
                    View a5 = addMoneyNewActivity.f55855a;
                    if (a5 != null) {
                        view = a5.findViewById(R.id.wallet_loader);
                    }
                    if (view != null) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) view);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.autoaddmoney.a<? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55863a;

        b(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55863a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                NetworkCustomError networkCustomError = (NetworkCustomError) aVar.a();
                if (NetworkCustomError.ErrorType.NetworkError.equals(networkCustomError != null ? networkCustomError.getErrorType() : null)) {
                    this.f55863a.a((com.paytm.network.a) null);
                } else {
                    AddMoneyUtils.a(this.f55863a, networkCustomError, AddMoneyNewActivity.class.getCanonicalName(), Boolean.FALSE);
                }
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55864a;

        c(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55864a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((net.one97.paytm.autoaddmoney.b.f) ((net.one97.paytm.autoaddmoney.a) obj).a()) != null) {
                net.one97.paytm.helper.a.f50546a.a().a((Activity) this.f55864a, AddMoneyNewActivity.class.getCanonicalName(), (Bundle) null);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55865a;

        d(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55865a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55865a.a((com.paytm.network.a) ((net.one97.paytm.autoaddmoney.a) obj).a());
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55866a;

        e(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55866a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            androidx.databinding.i<String> iVar;
            androidx.databinding.i<String> iVar2;
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "isLimitAndBalanceFetched");
            if (bool.booleanValue()) {
                net.one97.paytm.newaddmoney.c.a b2 = this.f55866a.f55857c;
                if (!(b2 == null || (iVar2 = b2.f55835e) == null)) {
                    iVar2.set(this.f55866a.getString(R.string.your_avialbale_balance, new Object[]{com.paytm.utility.b.S(j.b((Context) this.f55866a))}));
                }
                net.one97.paytm.newaddmoney.c.a b3 = this.f55866a.f55857c;
                if (!(b3 == null || (iVar = b3.j) == null)) {
                    iVar.set(this.f55866a.getString(R.string.your_avialbale_balance, new Object[]{com.paytm.utility.b.S(j.c(this.f55866a))}));
                }
                AddMoneyNewActivity.c(this.f55866a);
            }
        }
    }

    static final class f<T> implements z<Double> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55867a;

        f(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55867a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            androidx.databinding.i<String> iVar;
            androidx.databinding.i<String> iVar2;
            Double d2 = (Double) obj;
            net.one97.paytm.newaddmoney.c.a b2 = this.f55867a.f55857c;
            if (!(b2 == null || (iVar2 = b2.f55836f) == null)) {
                iVar2.set(this.f55867a.getString(R.string.am_paytm_avialbale_balance, new Object[]{com.paytm.utility.b.S(String.valueOf(d2.doubleValue()))}));
            }
            net.one97.paytm.newaddmoney.c.a b3 = this.f55867a.f55857c;
            if (b3 != null && (iVar = b3.D) != null) {
                iVar.set(this.f55867a.getString(R.string.am_paytm_avialbale_balance, new Object[]{com.paytm.utility.b.S(String.valueOf(d2.doubleValue()))}));
            }
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55868a;

        g(AddMoneyNewActivity addMoneyNewActivity) {
            this.f55868a = addMoneyNewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f55868a.a();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r13) {
        /*
            r12 = this;
            androidx.lifecycle.al r0 = new androidx.lifecycle.al
            r1 = r12
            androidx.lifecycle.ao r1 = (androidx.lifecycle.ao) r1
            net.one97.paytm.newaddmoney.c.b$a r2 = net.one97.paytm.newaddmoney.c.b.f55842a
            android.app.Application r2 = r12.getApplication()
            r3 = 0
            net.one97.paytm.newaddmoney.c.b r2 = net.one97.paytm.newaddmoney.c.b.a.a(r2, r3)
            androidx.lifecycle.al$b r2 = (androidx.lifecycle.al.b) r2
            r0.<init>((androidx.lifecycle.ao) r1, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.newaddmoney.c.a> r1 = net.one97.paytm.newaddmoney.c.a.class
            androidx.lifecycle.ai r0 = r0.a(r1)
            net.one97.paytm.newaddmoney.c.a r0 = (net.one97.paytm.newaddmoney.c.a) r0
            r12.f55857c = r0
            net.one97.paytm.helper.a$a r0 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r0 = r0.a()
            java.lang.String r1 = "no_kyc_user_allowed"
            boolean r0 = r0.g((java.lang.String) r1)
            if (r0 != 0) goto L_0x0044
            boolean r0 = net.one97.paytm.newaddmoney.utils.e.a()
            if (r0 == 0) goto L_0x0044
            net.one97.paytm.helper.a$a r0 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r0 = r0.a()
            r1 = r12
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r2 = "paytmmp://min_kyc?featuretype=popup"
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            r12.finish()
        L_0x0044:
            r0 = r12
            android.app.Activity r0 = (android.app.Activity) r0
            com.paytm.utility.b.e((android.app.Activity) r0)
            android.content.Intent r1 = r12.getIntent()
            r2 = 0
            if (r1 == 0) goto L_0x0067
            android.content.Intent r1 = r12.getIntent()
            java.lang.String r4 = "isCallbackRequired"
            boolean r1 = r1.hasExtra(r4)
            if (r1 == 0) goto L_0x0067
            android.content.Intent r1 = r12.getIntent()
            boolean r1 = r1.getBooleanExtra(r4, r2)
            r12.f55860f = r1
        L_0x0067:
            android.content.Intent r1 = r12.getIntent()
            if (r1 == 0) goto L_0x0083
            android.content.Intent r1 = r12.getIntent()
            java.lang.String r4 = "done_button_text"
            boolean r1 = r1.hasExtra(r4)
            if (r1 == 0) goto L_0x0083
            android.content.Intent r1 = r12.getIntent()
            java.lang.String r1 = r1.getStringExtra(r4)
            r12.f55861g = r1
        L_0x0083:
            android.content.Intent r1 = r12.getIntent()
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x00bb
            net.one97.paytm.newaddmoney.c.a r5 = r12.f55857c
            if (r5 == 0) goto L_0x0097
            java.lang.String r6 = "isSessionTimeoutCallbackRequiredH5"
            boolean r6 = r1.getBooleanExtra(r6, r2)
            r5.B = r6
        L_0x0097:
            java.lang.String r5 = "source"
            boolean r6 = r1.hasExtra(r5)
            if (r6 == 0) goto L_0x00b0
            net.one97.paytm.newaddmoney.c.a r6 = r12.f55857c
            if (r6 == 0) goto L_0x00bb
            androidx.databinding.i<java.lang.String> r6 = r6.k
            if (r6 == 0) goto L_0x00bb
            java.lang.String r1 = r1.getStringExtra(r5)
            r6.set(r1)
            goto L_0x00bb
        L_0x00b0:
            net.one97.paytm.newaddmoney.c.a r1 = r12.f55857c
            if (r1 == 0) goto L_0x00bb
            androidx.databinding.i<java.lang.String> r1 = r1.k
            if (r1 == 0) goto L_0x00bb
            r1.set(r4)
        L_0x00bb:
            super.onCreate(r13)
            int r13 = net.one97.paytm.addmoney.R.layout.activity_new_addmoney
            r12.setContentView((int) r13)
            int r13 = net.one97.paytm.addmoney.R.id.lyt_wallet_loader
            android.view.View r13 = r12.findViewById(r13)
            r12.f55855a = r13
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x00e2
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.r
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x00e2
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$a r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$a
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x00e2:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x00f9
            androidx.lifecycle.y<net.one97.paytm.autoaddmoney.a<com.paytm.network.model.NetworkCustomError>> r13 = r13.f55832b
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x00f9
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$b r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$b
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x00f9:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x0110
            androidx.lifecycle.y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.f>> r13 = r13.v
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0110
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$c r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$c
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x0110:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x0127
            androidx.lifecycle.y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> r13 = r13.u
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0127
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$d r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$d
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x0127:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x013c
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.f55837g
            if (r13 == 0) goto L_0x013c
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$e r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$e
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x013c:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x0153
            androidx.lifecycle.y<java.lang.Double> r13 = r13.x
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x0153
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$f r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$f
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x0153:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x016a
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.w
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            if (r13 == 0) goto L_0x016a
            r1 = r12
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$g r5 = new net.one97.paytm.newaddmoney.view.AddMoneyNewActivity$g
            r5.<init>(r12)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r13.observe(r1, r5)
        L_0x016a:
            r6 = r12
            android.content.Context r6 = (android.content.Context) r6
            boolean r13 = com.paytm.utility.b.r((android.content.Context) r6)
            r1 = 1
            if (r13 != 0) goto L_0x01b1
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x017e
            boolean r13 = r13.B
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
        L_0x017e:
            if (r3 != 0) goto L_0x0183
            kotlin.g.b.k.a()
        L_0x0183:
            boolean r13 = r3.booleanValue()
            if (r13 == 0) goto L_0x018d
            r12.a()
            return
        L_0x018d:
            net.one97.paytm.helper.a$a r13 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r13 = r13.a()
            android.content.Intent r13 = r13.k(r6)
            java.lang.String r3 = "launchSignUp"
            r13.putExtra(r3, r2)
            java.lang.String r2 = "set_result_required"
            r13.putExtra(r2, r1)
            com.paytm.network.a$c r1 = com.paytm.network.a.c.ADDMONEY
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "VERTICAL_NAME"
            r13.putExtra(r2, r1)
            r1 = 301(0x12d, float:4.22E-43)
            r0.startActivityForResult(r13, r1)
            return
        L_0x01b1:
            boolean r13 = com.paytm.utility.b.c((android.content.Context) r6)
            if (r13 != 0) goto L_0x01bb
            r12.a((com.paytm.network.a) r3)
            goto L_0x01c2
        L_0x01bb:
            net.one97.paytm.newaddmoney.c.a r13 = r12.f55857c
            if (r13 == 0) goto L_0x01c2
            r13.c()
        L_0x01c2:
            r13 = 4
            java.lang.String[] r13 = new java.lang.String[r13]
            net.one97.paytm.helper.a$a r0 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r0 = r0.a()
            android.content.Context r0 = r0.j()
            java.lang.String r0 = net.one97.paytm.newaddmoney.utils.e.a(r0)
            r13[r2] = r0
            r13[r1] = r4
            r0 = 2
            r13[r0] = r4
            r0 = 3
            net.one97.paytm.newaddmoney.c.a r1 = r12.f55857c
            if (r1 == 0) goto L_0x01ea
            androidx.databinding.i<java.lang.String> r1 = r1.k
            if (r1 == 0) goto L_0x01ea
            java.lang.Object r1 = r1.get()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
        L_0x01ea:
            r13[r0] = r3
            java.util.ArrayList r10 = kotlin.a.k.d(r13)
            r11 = 0
            java.lang.String r7 = "add_money"
            java.lang.String r8 = "Add_money_clicked"
            java.lang.String r9 = "/add-money"
            net.one97.paytm.addmoney.utils.d.a((android.content.Context) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.util.ArrayList<java.lang.String>) r10, (java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.onCreate(android.os.Bundle):void");
    }

    public final void a() {
        Intent intent = new Intent();
        intent.putExtra(Payload.RESPONSE, b());
        setResult(0, intent);
        finish();
    }

    private static String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseDialogFragment.ERROR_MESSAGE, "session_timeout");
            jSONObject.put("error", 20);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public final void a(com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        if (aVar != null) {
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new h(this, aVar));
        } else {
            builder.setPositiveButton(getResources().getString(R.string.retry), new i(this, aVar));
        }
        builder.show();
    }

    static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f55870b;

        h(AddMoneyNewActivity addMoneyNewActivity, com.paytm.network.a aVar) {
            this.f55869a = addMoneyNewActivity;
            this.f55870b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f55869a)) {
                net.one97.paytm.newaddmoney.c.a b2 = this.f55869a.f55857c;
                if (b2 != null) {
                    b2.d();
                }
                this.f55870b.a();
                return;
            }
            this.f55869a.a(this.f55870b);
        }
    }

    static final class i implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyNewActivity f55871a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f55872b;

        i(AddMoneyNewActivity addMoneyNewActivity, com.paytm.network.a aVar) {
            this.f55871a = addMoneyNewActivity;
            this.f55872b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f55871a)) {
                net.one97.paytm.newaddmoney.c.a b2 = this.f55871a.f55857c;
                if (b2 != null) {
                    b2.c();
                    return;
                }
                return;
            }
            this.f55871a.a(this.f55872b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0107, code lost:
        r10 = r10.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            java.lang.String r0 = ""
            r1 = 3
            r2 = 301(0x12d, float:4.22E-43)
            r3 = 104(0x68, float:1.46E-43)
            r4 = 1
            r5 = 0
            r6 = -1
            if (r9 != r6) goto L_0x013c
            r9 = 0
            if (r8 == r2) goto L_0x00cc
            if (r8 != r1) goto L_0x0016
            goto L_0x00cc
        L_0x0016:
            if (r8 != r3) goto L_0x0067
            if (r10 == 0) goto L_0x0174
            java.lang.String r8 = "intent_extra_wallet_order_id"
            java.lang.String r8 = r10.getStringExtra(r8)
            java.lang.String r9 = "intent_extra_wallet_paytm_assist_gtmevents"
            boolean r0 = r10.hasExtra(r9)
            if (r0 == 0) goto L_0x0037
            java.io.Serializable r9 = r10.getSerializableExtra(r9)
            if (r9 == 0) goto L_0x002f
            goto L_0x0037
        L_0x002f:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.PaytmAssistGAEventsData"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            java.lang.String r9 = "intent_extra_wallet_is_payment_cancelled"
            boolean r9 = r10.getBooleanExtra(r9, r5)
            java.lang.String r0 = "pg_screen"
            java.lang.String r0 = r10.getStringExtra(r0)
            java.lang.String r1 = "is_for_Gift_voucher"
            boolean r1 = r10.getBooleanExtra(r1, r5)
            r7.f55858d = r1
            java.lang.String r1 = "is_bank_add_money"
            boolean r10 = r10.getBooleanExtra(r1, r5)
            r7.f55859e = r10
            if (r9 == 0) goto L_0x0061
            java.lang.String r10 = "2"
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r4)
            if (r10 == 0) goto L_0x0061
            r7.a((java.lang.String) r8)
            return
        L_0x0061:
            if (r9 != 0) goto L_0x0066
            r7.a((java.lang.String) r8)
        L_0x0066:
            return
        L_0x0067:
            r1 = 1004(0x3ec, float:1.407E-42)
            if (r8 != r1) goto L_0x00cb
            if (r10 == 0) goto L_0x0072
            java.lang.String r8 = "order_id"
            r10.getStringExtra(r8)
        L_0x0072:
            if (r10 == 0) goto L_0x007d
            java.lang.String r8 = "is_cancel"
            boolean r8 = r10.getBooleanExtra(r8, r5)
            java.lang.Boolean.valueOf(r8)
        L_0x007d:
            if (r10 == 0) goto L_0x0086
            java.lang.String r8 = "retry_allowed"
            java.lang.String r8 = r10.getStringExtra(r8)
            goto L_0x0087
        L_0x0086:
            r8 = r9
        L_0x0087:
            androidx.fragment.app.j r1 = r7.getSupportFragmentManager()
            int r2 = net.one97.paytm.addmoney.R.id.wallet_Fragment_container
            androidx.fragment.app.Fragment r1 = r1.c((int) r2)
            java.lang.String r2 = "true"
            boolean r8 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r4)
            if (r8 == 0) goto L_0x00cb
            if (r10 == 0) goto L_0x00a2
            java.lang.String r8 = "error_message"
            java.lang.String r9 = r10.getStringExtra(r8)
        L_0x00a2:
            r8 = r9
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x00b5
            android.content.res.Resources r8 = r7.getResources()
            int r9 = net.one97.paytm.addmoney.R.string.error
            java.lang.String r9 = r8.getString(r9)
        L_0x00b5:
            boolean r8 = r1 instanceof net.one97.paytm.newaddmoney.view.c
            if (r8 == 0) goto L_0x00c3
            net.one97.paytm.newaddmoney.view.c r1 = (net.one97.paytm.newaddmoney.view.c) r1
            net.one97.paytm.autoaddmoney.b.d r8 = new net.one97.paytm.autoaddmoney.b.d
            r8.<init>(r0, r5)
            r1.a((net.one97.paytm.autoaddmoney.b.d) r8)
        L_0x00c3:
            r8 = r7
            android.content.Context r8 = (android.content.Context) r8
            java.lang.String r10 = "Error"
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r10, (java.lang.String) r9)
        L_0x00cb:
            return
        L_0x00cc:
            android.content.Context r8 = r7.getApplicationContext()
            boolean r8 = com.paytm.utility.b.r((android.content.Context) r8)
            if (r8 == 0) goto L_0x0174
            android.content.Intent r8 = new android.content.Intent
            r0 = r7
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.newaddmoney.view.AddMoneyNewActivity> r1 = net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.class
            r8.<init>(r0, r1)
            if (r10 == 0) goto L_0x00f2
            java.lang.String r0 = "tab"
            boolean r1 = r10.hasExtra(r0)
            if (r1 != r4) goto L_0x00f2
            java.lang.String r1 = r10.getStringExtra(r0)
            r8.putExtra(r0, r1)
        L_0x00f2:
            if (r10 == 0) goto L_0x0103
            java.lang.String r0 = "amount"
            boolean r1 = r10.hasExtra(r0)
            if (r1 != r4) goto L_0x0103
            java.lang.String r10 = r10.getStringExtra(r0)
            r8.putExtra(r0, r10)
        L_0x0103:
            net.one97.paytm.newaddmoney.c.a r10 = r7.f55857c
            if (r10 == 0) goto L_0x0112
            androidx.databinding.i<java.lang.String> r10 = r10.k
            if (r10 == 0) goto L_0x0112
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0113
        L_0x0112:
            r10 = r9
        L_0x0113:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x011f
            int r10 = r10.length()
            if (r10 != 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r4 = 0
        L_0x011f:
            if (r4 != 0) goto L_0x0135
            net.one97.paytm.newaddmoney.c.a r10 = r7.f55857c
            if (r10 == 0) goto L_0x012f
            androidx.databinding.i<java.lang.String> r10 = r10.k
            if (r10 == 0) goto L_0x012f
            java.lang.Object r9 = r10.get()
            java.lang.String r9 = (java.lang.String) r9
        L_0x012f:
            java.lang.String r10 = "source"
            r8.putExtra(r10, r9)
        L_0x0135:
            r7.startActivity(r8)
            r7.finish()
            return
        L_0x013c:
            if (r8 != r3) goto L_0x0157
            net.one97.paytm.newaddmoney.c.a r9 = r7.f55857c
            if (r9 == 0) goto L_0x0157
            boolean r9 = r9.B
            if (r9 != r4) goto L_0x0157
            if (r10 == 0) goto L_0x0156
            java.lang.String r8 = "response"
            boolean r8 = r10.hasExtra(r8)
            if (r8 == 0) goto L_0x0156
            r7.setResult(r5, r10)
            r7.finish()
        L_0x0156:
            return
        L_0x0157:
            if (r8 == r1) goto L_0x0175
            if (r8 != r2) goto L_0x015c
            goto L_0x0175
        L_0x015c:
            androidx.fragment.app.j r8 = r7.getSupportFragmentManager()
            int r9 = net.one97.paytm.addmoney.R.id.wallet_Fragment_container
            androidx.fragment.app.Fragment r8 = r8.c((int) r9)
            boolean r9 = r8 instanceof net.one97.paytm.newaddmoney.view.c
            if (r9 == 0) goto L_0x0174
            net.one97.paytm.newaddmoney.view.c r8 = (net.one97.paytm.newaddmoney.view.c) r8
            net.one97.paytm.autoaddmoney.b.d r9 = new net.one97.paytm.autoaddmoney.b.d
            r9.<init>(r0, r5)
            r8.a((net.one97.paytm.autoaddmoney.b.d) r9)
        L_0x0174:
            return
        L_0x0175:
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onBackPressed() {
        finish();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        r4 = r4.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r4) {
        /*
            r3 = this;
            r3.f55856b = r4
            boolean r0 = r3.f55858d
            if (r0 == 0) goto L_0x0011
            android.content.Intent r0 = new android.content.Intent
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.addmoney.togv.view.AddMoneyToGvSelfStatusActivity> r2 = net.one97.paytm.addmoney.togv.view.AddMoneyToGvSelfStatusActivity.class
            r0.<init>(r1, r2)
            goto L_0x001b
        L_0x0011:
            android.content.Intent r0 = new android.content.Intent
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity> r2 = net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity.class
            r0.<init>(r1, r2)
        L_0x001b:
            boolean r1 = r3.f55860f
            if (r1 == 0) goto L_0x0030
            java.lang.String r2 = "isCallbackRequired"
            r0.putExtra(r2, r1)
            java.lang.String r1 = r3.f55861g
            java.lang.String r2 = "done_button_text"
            r0.putExtra(r2, r1)
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r0.addFlags(r1)
        L_0x0030:
            r1 = 1
            java.lang.String r2 = "do_check_order_status_by_polling"
            r0.putExtra(r2, r1)
            java.lang.String r2 = "order_id"
            r0.putExtra(r2, r4)
            net.one97.paytm.newaddmoney.c.a r4 = r3.f55857c
            r2 = 0
            if (r4 == 0) goto L_0x004b
            androidx.databinding.i<java.lang.String> r4 = r4.k
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x004c
        L_0x004b:
            r4 = r2
        L_0x004c:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0058
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            if (r1 != 0) goto L_0x006f
            net.one97.paytm.newaddmoney.c.a r4 = r3.f55857c
            if (r4 == 0) goto L_0x0069
            androidx.databinding.i<java.lang.String> r4 = r4.k
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r4.get()
            r2 = r4
            java.lang.String r2 = (java.lang.String) r2
        L_0x0069:
            java.lang.String r4 = "source"
            r0.putExtra(r4, r2)
        L_0x006f:
            r3.startActivity(r0)
            r3.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.a(java.lang.String):void");
    }

    public final void attachBaseContext(Context context) {
        if (context != null) {
            super.attachBaseContext(net.one97.paytm.helper.a.f50546a.a().a(context));
        }
    }

    public static final /* synthetic */ void c(AddMoneyNewActivity addMoneyNewActivity) {
        Bundle bundle = new Bundle();
        if (addMoneyNewActivity.getIntent().hasExtra("amount")) {
            bundle.putDouble("amount", addMoneyNewActivity.getIntent().getDoubleExtra("amount", 0.0d));
        }
        if (addMoneyNewActivity.getIntent().hasExtra("tab")) {
            bundle.putString("tab", addMoneyNewActivity.getIntent().getStringExtra("tab"));
        }
        c cVar = new c();
        cVar.setArguments(bundle);
        addMoneyNewActivity.getSupportFragmentManager().a().b(R.id.wallet_Fragment_container, cVar).a("AddMoneyWalletNewFragment").c();
    }
}
