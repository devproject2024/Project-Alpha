package net.one97.paytm.impsRefund.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.impsRefund.a.b;
import net.one97.paytm.impsRefund.b.b;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.CustomSnackbar;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;

public final class RefundHomePageActivity extends PaytmActivity implements b.C0916b {

    /* renamed from: a  reason: collision with root package name */
    b.a f50604a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f50605b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f50606c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f50607d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f50608e;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f50609f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f50610g;

    /* renamed from: h  reason: collision with root package name */
    private String f50611h;

    public static final /* synthetic */ b.a d(RefundHomePageActivity refundHomePageActivity) {
        b.a aVar = refundHomePageActivity.f50604a;
        if (aVar == null) {
            k.a("mPresenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_refund_home_page);
        Context context = this;
        int c2 = androidx.core.content.b.c(context, R.color.color_f3f7f8);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                k.a((Object) decorView, "window.decorView");
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(c2);
            }
        }
        this.f50611h = net.one97.paytm.common.b.d.b().a("bank_instant_refund_title");
        View findViewById = findViewById(R.id.tv_heading);
        k.a((Object) findViewById, "findViewById(R.id.tv_heading)");
        this.f50606c = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tv_sub_heading);
        k.a((Object) findViewById2, "findViewById(R.id.tv_sub_heading)");
        this.f50607d = (TextView) findViewById2;
        if (TextUtils.isEmpty(this.f50611h)) {
            TextView textView = this.f50607d;
            if (textView == null) {
                k.a("mTvDesc");
            }
            textView.setText(getString(R.string.refund_bank_refund_desc));
        } else {
            TextView textView2 = this.f50607d;
            if (textView2 == null) {
                k.a("mTvDesc");
            }
            textView2.setText(this.f50611h);
        }
        View findViewById3 = findViewById(R.id.tv_know_more);
        k.a((Object) findViewById3, "findViewById(R.id.tv_know_more)");
        this.f50608e = (TextView) findViewById3;
        TextView textView3 = this.f50608e;
        if (textView3 == null) {
            k.a("mTvKnowMore");
        }
        textView3.setOnClickListener(new a(this));
        b.a aVar = net.one97.paytm.impsRefund.b.b.f50588a;
        this.f50604a = new net.one97.paytm.impsRefund.c.c(this, b.a.a(context));
        b.a aVar2 = this.f50604a;
        if (aVar2 == null) {
            k.a("mPresenter");
        }
        aVar2.a();
        View findViewById4 = findViewById(R.id.iv_back_arrow);
        if (findViewById4 != null) {
            ((ImageView) findViewById4).setOnClickListener(new b(this));
            getSupportFragmentManager().a((j.c) new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RefundHomePageActivity f50612a;

        a(RefundHomePageActivity refundHomePageActivity) {
            this.f50612a = refundHomePageActivity;
        }

        public final void onClick(View view) {
            RefundHomePageActivity refundHomePageActivity = this.f50612a;
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(refundHomePageActivity);
            View inflate = refundHomePageActivity.getLayoutInflater().inflate(R.layout.layout_refund_know_more, (ViewGroup) null);
            aVar.setContentView(inflate);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new d(aVar));
            TextView textView = (TextView) inflate.findViewById(R.id.tv_know_more_1);
            k.a((Object) textView, "tvKnowMoreText1");
            textView.setText(refundHomePageActivity.getString(R.string.refund_know_more_text_1));
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_know_more_2);
            k.a((Object) textView2, "tvKnowMoreText2");
            textView2.setText(refundHomePageActivity.getString(R.string.refund_know_more_text_2));
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_know_more_3);
            k.a((Object) textView3, "tvKnowMoreText3");
            textView3.setText(refundHomePageActivity.getString(R.string.refund_know_more_text_3));
            aVar.show();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RefundHomePageActivity f50613a;

        b(RefundHomePageActivity refundHomePageActivity) {
            this.f50613a = refundHomePageActivity;
        }

        public final void onClick(View view) {
            this.f50613a.onBackPressed();
        }
    }

    static final class c implements j.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RefundHomePageActivity f50614a;

        c(RefundHomePageActivity refundHomePageActivity) {
            this.f50614a = refundHomePageActivity;
        }

        public final void a() {
            if (this.f50614a.f50605b) {
                int c2 = this.f50614a.f50610g;
                j supportFragmentManager = this.f50614a.getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "supportFragmentManager");
                if (c2 > supportFragmentManager.f()) {
                    this.f50614a.f50605b = false;
                    RefundHomePageActivity.d(this.f50614a).a();
                }
            }
            RefundHomePageActivity refundHomePageActivity = this.f50614a;
            j supportFragmentManager2 = refundHomePageActivity.getSupportFragmentManager();
            k.a((Object) supportFragmentManager2, "supportFragmentManager");
            refundHomePageActivity.f50610g = supportFragmentManager2.f();
            this.f50614a.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = r0.getRefundAccounts();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount r6) {
        /*
            r5 = this;
            java.lang.String r0 = "dataModel"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse r0 = r6.getBody()
            if (r0 == 0) goto L_0x00a9
            net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse r0 = r6.getBody()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            java.util.List r0 = r0.getRefundAccounts()
            if (r0 == 0) goto L_0x001d
            int r0 = r0.size()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 <= 0) goto L_0x00a5
            net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse r6 = r6.getBody()
            java.lang.String r0 = "dataModel.body"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            java.util.List r6 = r6.getRefundAccounts()
            if (r6 == 0) goto L_0x009d
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.String r0 = "dataList"
            kotlin.g.b.k.c(r6, r0)
            androidx.fragment.app.j r2 = r5.getSupportFragmentManager()
            java.lang.String r3 = "RefundBankListFragment"
            androidx.fragment.app.Fragment r2 = r2.c((java.lang.String) r3)
            if (r2 == 0) goto L_0x007a
            boolean r3 = r2 instanceof net.one97.paytm.impsRefund.view.c
            if (r3 == 0) goto L_0x007a
            net.one97.paytm.impsRefund.view.c r2 = (net.one97.paytm.impsRefund.view.c) r2
            kotlin.g.b.k.c(r6, r0)
            r2.f50651a = r6
            androidx.recyclerview.widget.RecyclerView r6 = r2.f50656f
            if (r6 != 0) goto L_0x0056
            java.lang.String r0 = "listRv"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0056:
            androidx.recyclerview.widget.RecyclerView$a r6 = r6.getAdapter()
            if (r6 == 0) goto L_0x0072
            net.one97.paytm.impsRefund.view.d r6 = (net.one97.paytm.impsRefund.view.d) r6
            if (r6 == 0) goto L_0x00ac
            java.util.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> r0 = r2.f50651a
            java.lang.String r1 = "bankList"
            if (r0 != 0) goto L_0x0069
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0069:
            kotlin.g.b.k.c(r0, r1)
            r6.f50671a = r0
            r6.notifyDataSetChanged()
            goto L_0x00ac
        L_0x0072:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundListAdapter"
            r6.<init>(r0)
            throw r6
        L_0x007a:
            androidx.fragment.app.j r2 = r5.getSupportFragmentManager()
            net.one97.paytm.impsRefund.view.c$a r3 = net.one97.paytm.impsRefund.view.c.f50650g
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.impsRefund.view.c r0 = new net.one97.paytm.impsRefund.view.c
            r0.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r4 = "bank_list"
            r3.putSerializable(r4, r6)
            r0.setArguments(r3)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            a(r2, r0, r1)
            goto L_0x00ac
        L_0x009d:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> /* = java.util.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> */"
            r6.<init>(r0)
            throw r6
        L_0x00a5:
            r5.c()
            goto L_0x00ac
        L_0x00a9:
            r5.c()
        L_0x00ac:
            r5.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.impsRefund.view.RefundHomePageActivity.a(net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount):void");
    }

    public final void a() {
        CustomSnackbar build = CustomSnackbar.Builder(this).layout(R.layout.layout_refund_snack_bar).duration(CustomSnackbar.LENGTH.SHORT).swipe(true).build(findViewById(R.id.main_content));
        build.show();
        k.a((Object) build, "snackbar");
        TextView textView = (TextView) build.getContentView().findViewById(R.id.tv_snack_bar_message);
        k.a((Object) textView, "message");
        textView.setText(getString(R.string.refund_bank_account_refund_added));
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, networkCustomError.getMessage(), true)) {
            r.a((Activity) this, (Exception) networkCustomError, RefundHomePageActivity.class.getName(), (Bundle) null);
        } else {
            com.paytm.utility.b.b((Context) this, "Error", networkCustomError.getAlertMessage());
        }
    }

    public final void a(String str) {
        k.c(str, "msg");
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.something_wrong_try_again);
            k.a((Object) str, "getString(R.string.something_wrong_try_again)");
        }
        com.paytm.utility.b.b((Context) this, getString(R.string.error), str);
    }

    private static Dialog a(Activity activity) {
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            Window window = dialog.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public final void a(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        if (z) {
            try {
                if (this.f50609f == null) {
                    this.f50609f = a((Activity) this);
                }
                if (this.f50609f != null) {
                    Dialog dialog3 = this.f50609f;
                    if (dialog3 == null) {
                        k.a();
                    }
                    if (!dialog3.isShowing() && (dialog2 = this.f50609f) != null) {
                        dialog2.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (this.f50609f != null) {
            Dialog dialog4 = this.f50609f;
            if (dialog4 == null) {
                k.a();
            }
            if (dialog4.isShowing() && (dialog = this.f50609f) != null) {
                dialog.dismiss();
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        b.a aVar = this.f50604a;
        if (aVar == null) {
            k.a("mPresenter");
        }
        aVar.b();
    }

    private void c() {
        getSupportFragmentManager().a().a((int) R.id.fragment_container, (Fragment) net.one97.paytm.upi.awareness.view.b.a()).c();
        this.f50605b = true;
    }

    public static void a(j jVar, Fragment fragment, boolean z) {
        k.c(fragment, "fragment");
        if (z) {
            if (jVar != null) {
                jVar.a().a(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).a((String) null).c();
            }
        } else if (jVar != null) {
            jVar.a().a(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).a((String) null).c();
        }
    }

    public final void onBackPressed() {
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() <= 1) {
            finish();
        }
        super.onBackPressed();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50615a;

        d(com.google.android.material.bottomsheet.a aVar) {
            this.f50615a = aVar;
        }

        public final void onClick(View view) {
            this.f50615a.dismiss();
        }
    }

    public final void b() {
        if (this.f50605b) {
            TextView textView = this.f50606c;
            if (textView == null) {
                k.a("mTvHeading");
            }
            textView.setText(getString(R.string.refund_upi_select_bank_title));
            return;
        }
        TextView textView2 = this.f50606c;
        if (textView2 == null) {
            k.a("mTvHeading");
        }
        textView2.setText(getString(R.string.refund_bank_refund));
    }
}
