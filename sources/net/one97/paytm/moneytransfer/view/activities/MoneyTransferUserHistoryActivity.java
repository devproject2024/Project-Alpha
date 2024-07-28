package net.one97.paytm.moneytransfer.view.activities;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.UpiConstants;

public final class MoneyTransferUserHistoryActivity extends MoneyTransferBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f54353a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.g f54354b = h.a(new b(this));

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.g f54355c = h.a(new a(this));

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.g f54356d = h.a(new g(this));

    /* renamed from: e  reason: collision with root package name */
    private boolean f54357e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f54358f;

    static {
        Class<MoneyTransferUserHistoryActivity> cls = MoneyTransferUserHistoryActivity.class;
        f54353a = new i[]{y.a((v) new w(y.b(cls), "coordinatorLayout", "getCoordinatorLayout()Landroidx/coordinatorlayout/widget/CoordinatorLayout;")), y.a((v) new w(y.b(cls), "appBarLayout", "getAppBarLayout()Lcom/google/android/material/appbar/AppBarLayout;")), y.a((v) new w(y.b(cls), "toolbarTitle", "getToolbarTitle()Landroidx/appcompat/widget/AppCompatTextView;"))};
    }

    public final View a(int i2) {
        if (this.f54358f == null) {
            this.f54358f = new HashMap();
        }
        View view = (View) this.f54358f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f54358f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final AppCompatTextView a() {
        return (AppCompatTextView) this.f54356d.getValue();
    }

    static final class b extends l implements kotlin.g.a.a<CoordinatorLayout> {
        final /* synthetic */ MoneyTransferUserHistoryActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            super(0);
            this.this$0 = moneyTransferUserHistoryActivity;
        }

        public final CoordinatorLayout invoke() {
            View findViewById = this.this$0.findViewById(R.id.parent_coordinator_view);
            if (findViewById != null) {
                return (CoordinatorLayout) findViewById;
            }
            throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        }
    }

    static final class a extends l implements kotlin.g.a.a<AppBarLayout> {
        final /* synthetic */ MoneyTransferUserHistoryActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            super(0);
            this.this$0 = moneyTransferUserHistoryActivity;
        }

        public final AppBarLayout invoke() {
            View findViewById = this.this$0.findViewById(R.id.appbar);
            if (findViewById != null) {
                return (AppBarLayout) findViewById;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
        }
    }

    static final class g extends l implements kotlin.g.a.a<AppCompatTextView> {
        final /* synthetic */ MoneyTransferUserHistoryActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            super(0);
            this.this$0 = moneyTransferUserHistoryActivity;
        }

        public final AppCompatTextView invoke() {
            View findViewById = this.this$0.findViewById(R.id.toolbar_title);
            if (findViewById != null) {
                return (AppCompatTextView) findViewById;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r1 = r17
            super.onCreate(r18)
            int r0 = net.one97.paytm.moneytransfer.R.layout.activity_money_transfer_user_history
            r1.setContentView((int) r0)
            r2 = r1
            android.content.Context r2 = (android.content.Context) r2
            int r0 = net.one97.paytm.moneytransfer.R.color.white
            int r0 = androidx.core.content.b.c(r2, r0)
            android.view.Window r3 = r17.getWindow()
            if (r3 == 0) goto L_0x003d
            r4 = 16
            r3.setSoftInputMode(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r4 < r5) goto L_0x003d
            android.view.View r4 = r3.getDecorView()
            java.lang.String r5 = "window.decorView"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlags(r5)
            if (r4 == 0) goto L_0x003a
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.setSystemUiVisibility(r5)
        L_0x003a:
            r3.setStatusBarColor(r0)
        L_0x003d:
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r3 = "ifsc_code"
            java.lang.String r4 = "bank_name"
            java.lang.String r5 = "account_holder_name"
            r6 = 1
            java.lang.String r7 = "accountNumber"
            r8 = 0
            if (r0 == 0) goto L_0x00dc
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r9 = "EXTRA_DEEP_LINK_FLAG"
            boolean r0 = r0.getBooleanExtra(r9, r8)
            if (r0 == 0) goto L_0x00dc
            r1.f54357e = r6
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r9 = "EXTRA_DEEP_LINK_DATA"
            android.os.Parcelable r0 = r0.getParcelableExtra(r9)
            net.one97.paytm.deeplink.DeepLinkData r0 = (net.one97.paytm.deeplink.DeepLinkData) r0
            if (r0 == 0) goto L_0x00dc
            java.lang.String r9 = "money_transfer_history"
            java.lang.String r10 = r0.f50288f     // Catch:{ Exception -> 0x00d4 }
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r6)     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x00dc
            java.lang.String r0 = r0.f50283a     // Catch:{ Exception -> 0x00d4 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x00d4 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x00d4 }
            android.net.Uri r0 = r0.build()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = "payeeAccNoOrVpa"
            java.lang.String r9 = r0.getQueryParameter(r9)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = "payeeName"
            java.lang.String r10 = r0.getQueryParameter(r10)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = "ifsc"
            java.lang.String r11 = r0.getQueryParameter(r11)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r12 = "bankName"
            java.lang.String r0 = r0.getQueryParameter(r12)     // Catch:{ Exception -> 0x00d4 }
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x00d4 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00d4 }
            if (r12 != 0) goto L_0x00dc
            boolean r12 = net.one97.paytm.upi.util.UpiAppUtils.checkIsVpa(r9)     // Catch:{ Exception -> 0x00d4 }
            if (r12 == 0) goto L_0x00b7
            android.content.Intent r0 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r0.putExtra(r7, r9)     // Catch:{ Exception -> 0x00d4 }
            android.content.Intent r0 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r0.putExtra(r5, r10)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00dc
        L_0x00b7:
            android.content.Intent r12 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r12.putExtra(r7, r9)     // Catch:{ Exception -> 0x00d4 }
            android.content.Intent r9 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r9.putExtra(r5, r10)     // Catch:{ Exception -> 0x00d4 }
            android.content.Intent r9 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r9.putExtra(r4, r0)     // Catch:{ Exception -> 0x00d4 }
            android.content.Intent r0 = r17.getIntent()     // Catch:{ Exception -> 0x00d4 }
            r0.putExtra(r3, r11)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00dc
        L_0x00d4:
            r0 = move-exception
            boolean r9 = com.paytm.utility.b.v
            if (r9 == 0) goto L_0x00dc
            r0.printStackTrace()
        L_0x00dc:
            android.content.Intent r0 = r17.getIntent()
            int r9 = net.one97.paytm.moneytransfer.R.id.tv_your_txns
            android.view.View r9 = r1.findViewById(r9)
            java.lang.String r10 = "null cannot be cast to non-null type android.widget.TextView"
            if (r9 == 0) goto L_0x0395
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r11 = net.one97.paytm.moneytransfer.R.string.money_transfer_your_txns
            java.lang.Object[] r12 = new java.lang.Object[r6]
            java.lang.String r13 = ""
            if (r0 == 0) goto L_0x00fa
            java.lang.String r14 = r0.getStringExtra(r5)
            if (r14 != 0) goto L_0x00fb
        L_0x00fa:
            r14 = r13
        L_0x00fb:
            java.lang.String r14 = b(r14)
            r12[r8] = r14
            java.lang.String r11 = r1.getString(r11, r12)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r9.setText(r11)
            int r9 = net.one97.paytm.moneytransfer.R.id.tv_name
            android.view.View r9 = r1.findViewById(r9)
            if (r9 == 0) goto L_0x038f
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r0 == 0) goto L_0x011b
            java.lang.String r5 = r0.getStringExtra(r5)
            goto L_0x011c
        L_0x011b:
            r5 = 0
        L_0x011c:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r9.setText(r5)
            if (r0 == 0) goto L_0x0128
            java.lang.String r5 = r0.getStringExtra(r7)
            goto L_0x0129
        L_0x0128:
            r5 = 0
        L_0x0129:
            int r9 = net.one97.paytm.moneytransfer.R.id.bankImageView
            android.view.View r9 = r1.findViewById(r9)
            java.lang.String r12 = "findViewById(R.id.bankImageView)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            boolean r5 = com.paytm.utility.b.X((java.lang.String) r5)
            java.lang.String r12 = "java.lang.String.format(format, *args)"
            java.lang.String r14 = "null cannot be cast to non-null type android.view.View"
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.ImageView"
            r11 = 8
            if (r5 == 0) goto L_0x019d
            int r3 = net.one97.paytm.moneytransfer.R.drawable.ic_bhim
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r9.setImageDrawable(r2)
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_bank_name
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0197
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setVisibility(r11)
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_acc_no
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0191
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold
            java.lang.Object[] r4 = new java.lang.Object[r6]
            if (r0 == 0) goto L_0x0171
            java.lang.String r0 = r0.getStringExtra(r7)
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            r4[r8] = r0
            java.lang.String r0 = r1.getString(r3, r4)
            java.lang.String r3 = "getString(R.string.money…ramConstants.ACC_NUMBER))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r8)
            java.lang.String r0 = java.lang.String.format(r0, r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            goto L_0x027b
        L_0x0191:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0197:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x019d:
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_request_money
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0389
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setVisibility(r11)
            int r2 = net.one97.paytm.moneytransfer.R.id.separator
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0383
            r2.setVisibility(r11)
            int r2 = net.one97.paytm.moneytransfer.R.id.request_money_iv
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x037d
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r2.setVisibility(r11)
            if (r0 == 0) goto L_0x01c9
            java.lang.String r2 = r0.getStringExtra(r4)
            goto L_0x01ca
        L_0x01c9:
            r2 = 0
        L_0x01ca:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0200
            if (r0 == 0) goto L_0x01d9
            java.lang.String r2 = r0.getStringExtra(r4)
            goto L_0x01da
        L_0x01d9:
            r2 = 0
        L_0x01da:
            java.lang.String r5 = "null"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x0200
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_bank_name
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x01fa
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r0 == 0) goto L_0x01f3
            java.lang.String r4 = r0.getStringExtra(r4)
            goto L_0x01f4
        L_0x01f3:
            r4 = 0
        L_0x01f4:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x020d
        L_0x01fa:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0200:
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_bank_name
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0377
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setVisibility(r11)
        L_0x020d:
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_acc_no
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0371
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a
            int r4 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold
            java.lang.Object[] r5 = new java.lang.Object[r6]
            if (r0 == 0) goto L_0x0224
            java.lang.String r16 = r0.getStringExtra(r7)
            goto L_0x0226
        L_0x0224:
            r16 = 0
        L_0x0226:
            java.lang.String r16 = net.one97.paytm.upi.util.UpiUtils.maskNumber(r16)
            java.lang.String r16 = com.paytm.utility.b.R((java.lang.String) r16)
            r5[r8] = r16
            java.lang.String r4 = r1.getString(r4, r5)
            java.lang.String r5 = "getString(R.string.money…nstants.ACC_NUMBER)), 4))"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r8)
            java.lang.String r4 = java.lang.String.format(r4, r5)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r12)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            if (r0 == 0) goto L_0x0252
            java.lang.String r0 = r0.getStringExtra(r3)
            goto L_0x0253
        L_0x0252:
            r0 = 0
        L_0x0253:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x027b
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            android.content.Context r3 = r17.getApplicationContext()
            java.lang.String r0 = net.one97.paytm.upi.util.UpiRequestBuilder.getBankIconUrl(r3, r0)
            com.squareup.picasso.aa r0 = r2.a((java.lang.String) r0)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r0 = r0.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r0 = r0.b((int) r2)
            r0.a((android.widget.ImageView) r9)
        L_0x027b:
            android.content.Intent r0 = r17.getIntent()
            androidx.fragment.app.j r2 = r17.getSupportFragmentManager()
            if (r2 == 0) goto L_0x02c1
            androidx.fragment.app.q r2 = r2.a()
            int r3 = net.one97.paytm.moneytransfer.R.id.transactions_fragment_container
            net.one97.paytm.moneytransfer.view.fragments.r$a r4 = net.one97.paytm.moneytransfer.view.fragments.r.f54620a
            if (r0 == 0) goto L_0x0295
            java.lang.String r0 = r0.getStringExtra(r7)
            if (r0 != 0) goto L_0x0296
        L_0x0295:
            r0 = r13
        L_0x0296:
            java.lang.String r4 = "accNoOrVpa"
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.moneytransfer.view.fragments.r r4 = new net.one97.paytm.moneytransfer.view.fragments.r
            r4.<init>()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putString(r7, r0)
            r4.setArguments(r5)
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            net.one97.paytm.moneytransfer.view.fragments.r r0 = new net.one97.paytm.moneytransfer.view.fragments.r
            r0.<init>()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            androidx.fragment.app.q r0 = r2.a(r3, r4, r0)
            r0.c()
        L_0x02c1:
            net.one97.paytm.moneytransfer.utils.l$a r0 = net.one97.paytm.moneytransfer.utils.l.f54175a
            android.content.Context r0 = r17.getApplicationContext()
            java.lang.String r2 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.paytm.b.a.a r0 = net.one97.paytm.moneytransfer.utils.l.a.a(r0)
            java.lang.String r2 = "is_upi_user"
            boolean r0 = r0.b((java.lang.String) r2, (boolean) r8, (boolean) r6)
            if (r0 != 0) goto L_0x0310
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_request_money
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x030a
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r11)
            int r0 = net.one97.paytm.moneytransfer.R.id.request_money_iv
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x0304
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r11)
            int r0 = net.one97.paytm.moneytransfer.R.id.separator
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x02fe
            r0.setVisibility(r11)
            goto L_0x0324
        L_0x02fe:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r14)
            throw r0
        L_0x0304:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r15)
            throw r0
        L_0x030a:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0310:
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_request_money
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x036b
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$c r2 = new net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$c
            r2.<init>(r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
        L_0x0324:
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_money_transfer
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x0365
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$d r2 = new net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$d
            r2.<init>(r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.iv_back_button
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x035f
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$e r2 = new net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$e
            r2.<init>(r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            kotlin.g r0 = r1.f54355c
            java.lang.Object r0 = r0.getValue()
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$f r2 = new net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity$f
            r2.<init>(r1)
            com.google.android.material.appbar.AppBarLayout$b r2 = (com.google.android.material.appbar.AppBarLayout.b) r2
            r0.a((com.google.android.material.appbar.AppBarLayout.b) r2)
            return
        L_0x035f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r15)
            throw r0
        L_0x0365:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x036b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0371:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0377:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x037d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r15)
            throw r0
        L_0x0383:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r14)
            throw r0
        L_0x0389:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x038f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        L_0x0395:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity.onCreate(android.os.Bundle):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferUserHistoryActivity f54359a;

        c(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            this.f54359a = moneyTransferUserHistoryActivity;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f54359a, RequestMoneyV2Activity.class);
            Intent intent2 = this.f54359a.getIntent();
            intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, intent2 != null ? intent2.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER) : null);
            this.f54359a.startActivity(intent);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferUserHistoryActivity f54360a;

        d(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            this.f54360a = moneyTransferUserHistoryActivity;
        }

        public final void onClick(View view) {
            MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity = this.f54360a;
            MoneyTransferUserHistoryActivity.a(moneyTransferUserHistoryActivity, moneyTransferUserHistoryActivity.getIntent());
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferUserHistoryActivity f54361a;

        e(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            this.f54361a = moneyTransferUserHistoryActivity;
        }

        public final void onClick(View view) {
            this.f54361a.finish();
        }
    }

    static final class f implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferUserHistoryActivity f54362a;

        f(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity) {
            this.f54362a = moneyTransferUserHistoryActivity;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            String str;
            int abs = Math.abs(i2);
            k.a((Object) appBarLayout, "appBarLayout");
            if (abs >= appBarLayout.getTotalScrollRange() - 50) {
                this.f54362a.a().setVisibility(0);
                AppCompatTextView a2 = this.f54362a.a();
                MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity = this.f54362a;
                int i3 = R.string.money_transfer_your_txns;
                Object[] objArr = new Object[1];
                Intent intent = this.f54362a.getIntent();
                if (intent == null || (str = intent.getStringExtra("account_holder_name")) == null) {
                    str = "";
                }
                objArr[0] = MoneyTransferUserHistoryActivity.b(str);
                a2.setText(moneyTransferUserHistoryActivity.getString(i3, objArr));
                return;
            }
            this.f54362a.a().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        CharSequence charSequence = str;
        if (p.a(charSequence, ' ', 0, false, 6) <= 0) {
            return str;
        }
        int a2 = p.a(charSequence, ' ', 0, false, 6);
        if (str != null) {
            String substring = str.substring(0, a2);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final /* synthetic */ void a(MoneyTransferUserHistoryActivity moneyTransferUserHistoryActivity, Intent intent) {
        String str;
        String str2 = null;
        String stringExtra = intent != null ? intent.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER) : null;
        if (com.paytm.utility.b.X(stringExtra)) {
            StringBuilder sb = new StringBuilder();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb.append("&pa=");
            sb.append(stringExtra);
            sb.append("&pn=");
            if (intent != null) {
                str2 = intent.getStringExtra("account_holder_name");
            }
            sb.append(str2);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb2.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb2.append("&account=");
            sb2.append(stringExtra);
            sb2.append("&pn=");
            sb2.append(intent != null ? intent.getStringExtra("account_holder_name") : null);
            sb2.append("&ifsc=");
            sb2.append(intent != null ? intent.getStringExtra("ifsc_code") : null);
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(intent != null ? intent.getStringExtra(PayUtility.BANK_NAME) : null)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb3);
                sb4.append("&bank_name=");
                if (intent != null) {
                    str2 = intent.getStringExtra(PayUtility.BANK_NAME);
                }
                sb4.append(str2);
                str = sb4.toString();
            } else {
                str = sb3;
            }
        }
        d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Context) moneyTransferUserHistoryActivity, str);
    }
}
