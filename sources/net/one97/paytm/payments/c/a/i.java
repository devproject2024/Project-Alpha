package net.one97.paytm.payments.c.a;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.appcompat.app.c;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.bankCommon.data.bankscope.a.a.a;
import net.one97.paytm.bankCommon.data.bankscope.a.b.a;
import net.one97.paytm.bankCommon.data.bankscope.b;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class i extends net.one97.paytm.phoenix.core.a {
    public i() {
        super("logout");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return false;
        }
        c.a aVar = new c.a(activity, R.style.AlertTheme);
        String string = activity.getString(R.string.pb_are_sure_logout_desc);
        k.a((Object) string, "activity.getString(R.str….pb_are_sure_logout_desc)");
        x.e eVar = new x.e();
        T application = activity.getApplication();
        if (application == null) {
            return false;
        }
        eVar.element = application;
        aVar.b((CharSequence) string);
        aVar.a(false);
        aVar.a(R.string.pb_home_logout_from_bank_btn_txt, (DialogInterface.OnClickListener) new a(eVar, activity, this, bVar, h5Event));
        aVar.b(R.string.pb_home_cancel_from_bank_btn_txt, (DialogInterface.OnClickListener) new b(this, bVar, h5Event));
        aVar.b();
        return true;
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f17230a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f17231b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f17232c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17233d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f17234e;

        a(x.e eVar, Activity activity, i iVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
            this.f17230a = eVar;
            this.f17231b = activity;
            this.f17232c = iVar;
            this.f17233d = bVar;
            this.f17234e = h5Event;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.paymentsBank.customView.a.a(net.one97.paytm.paymentsBank.customView.c.MASKED_CARD);
            net.one97.paytm.paymentsBank.customView.a.c();
            k.a((Object) d.b(), "PBGTMHelper.getInstance()");
            Boolean Q = d.Q();
            k.a((Object) Q, "PBGTMHelper.getInstance(…BankScopeTokenFlowEnabled");
            if (Q.booleanValue()) {
                final x.e eVar = new x.e();
                b.a aVar = net.one97.paytm.bankCommon.data.bankscope.b.f16256a;
                a.C0222a aVar2 = net.one97.paytm.bankCommon.data.bankscope.a.a.a.f16246a;
                a.C0223a aVar3 = net.one97.paytm.bankCommon.data.bankscope.a.b.a.f16249a;
                eVar.element = b.a.a(a.C0222a.a((Application) this.f17230a.element), a.C0223a.a((Application) this.f17230a.element));
                dialogInterface.dismiss();
                final x.e eVar2 = new x.e();
                eVar2.element = new ProgressDialog(this.f17231b);
                i.a(true, (ProgressDialog) eVar2.element, (Application) this.f17230a.element);
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ a this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        static final class b implements DialogInterface.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ i f17235a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ net.one97.paytm.phoenix.api.b f17236b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ H5Event f17237c;

                            b(i iVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
                                this.f17235a = iVar;
                                this.f17236b = bVar;
                                this.f17237c = h5Event;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                net.one97.paytm.phoenix.api.b bVar = this.f17236b;
                                if (bVar != null) {
                                    bVar.a(this.f17237c, i.a("false"));
                                }
                                dialogInterface.dismiss();
                            }
                        }

                        public static final /* synthetic */ void a(boolean z, ProgressDialog progressDialog, Application application) {
                            if (z) {
                                if (!progressDialog.isShowing()) {
                                    progressDialog.setTitle("");
                                    progressDialog.setMessage(application.getString(R.string.pb_please_wait_progress_msg));
                                    progressDialog.setIndeterminate(true);
                                    progressDialog.show();
                                }
                            } else if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        }

                        public static final /* synthetic */ JSONObject a(String str) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("logout", str);
                            return jSONObject;
                        }
                    }
