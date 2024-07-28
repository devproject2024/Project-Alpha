package net.one97.paytm.passbook.genericPassbook.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.AAM_STATUS;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.beans.SubscriptionResponse;
import net.one97.paytm.passbook.beans.UserCheckSubscriptionStatus;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity;
import net.one97.paytm.passbook.genericPassbook.d.a.d;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivity;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class b extends h implements View.OnClickListener, d.a {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f57420a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f57421b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f57422c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f57423d;

    /* renamed from: e  reason: collision with root package name */
    private View f57424e;

    /* renamed from: f  reason: collision with root package name */
    private Context f57425f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f57426g;

    /* renamed from: h  reason: collision with root package name */
    private String f57427h;

    /* renamed from: i  reason: collision with root package name */
    private d f57428i;
    private CJRP2BStatus j;
    private UpiProfileDefaultBank k;
    private boolean l;
    private HashMap m;

    /* renamed from: net.one97.paytm.passbook.genericPassbook.d.a.b$b  reason: collision with other inner class name */
    static final class C1077b implements g {

        /* renamed from: a  reason: collision with root package name */
        public static final C1077b f57431a = new C1077b();

        C1077b() {
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }
    }

    static final class a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57429a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f57430b;

        a(b bVar, View view) {
            this.f57429a = bVar;
            this.f57430b = view;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof UserCheckSubscriptionStatus) {
                UserCheckSubscriptionStatus userCheckSubscriptionStatus = (UserCheckSubscriptionStatus) iJRDataModel;
                String statusCode = userCheckSubscriptionStatus.getStatusCode();
                SubscriptionResponse response = userCheckSubscriptionStatus.getResponse();
                if (statusCode != null && p.a(statusCode, "USD_1027", true)) {
                    q.b("New User");
                    b.a(this.f57429a, this.f57430b, AAM_STATUS.NEW);
                } else if (response != null) {
                    String statusOfSubscription = response.getStatusOfSubscription();
                    if (TextUtils.isEmpty(statusOfSubscription)) {
                        return;
                    }
                    if (p.a(statusOfSubscription, "ACTIVE", false) || p.a(statusOfSubscription, "IN_PROGRESS", false)) {
                        q.b("ACTIVE");
                        b.a(this.f57429a, this.f57430b, AAM_STATUS.ACTIVE);
                    } else if (p.a(statusOfSubscription, "INACTIVE", false) || p.a(statusOfSubscription, "DISABLED_BY_USER", false) || p.a(statusOfSubscription, "FAILED", false)) {
                        q.b("PAUSED");
                        b.a(this.f57429a, this.f57430b, AAM_STATUS.PAUSED);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0223, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x008d, code lost:
        r12 = r12.getIntent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e7, code lost:
        if (r12.c(r13) != false) goto L_0x0203;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r13 = "inflater"
            kotlin.g.b.k.c(r11, r13)
            int r13 = net.one97.paytm.passbook.R.layout.pass_sub_wallet_header
            r0 = 0
            android.view.View r11 = r11.inflate(r13, r12, r0)
            java.lang.String r12 = "view"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            android.content.Context r12 = r11.getContext()
            java.lang.String r13 = "view.context"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r10.f57425f = r12
            net.one97.paytm.passbook.genericPassbook.d.a.d r12 = new net.one97.paytm.passbook.genericPassbook.d.a.d
            android.content.Context r13 = r10.f57425f
            java.lang.String r1 = "mContext"
            if (r13 != 0) goto L_0x0027
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0027:
            r12.<init>(r13)
            r10.f57428i = r12
            int r12 = net.one97.paytm.passbook.R.id.rl_download_statement
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.rl_download_statement)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r10.f57420a = r12
            int r12 = net.one97.paytm.passbook.R.id.rl_send_money_layout
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.rl_send_money_layout)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r10.f57421b = r12
            int r12 = net.one97.paytm.passbook.R.id.rl_add_money_layout
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.rl_add_money_layout)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r10.f57422c = r12
            int r12 = net.one97.paytm.passbook.R.id.rl_view_spend_analytics
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.rl_view_spend_analytics)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r10.f57423d = r12
            int r12 = net.one97.paytm.passbook.R.id.view_SA_divider
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.view_SA_divider)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r10.f57424e = r12
            int r12 = net.one97.paytm.passbook.R.id.tv_download_statement
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.findViewById(R.id.tv_download_statement)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.f57426g = r12
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            java.lang.String r13 = "upi_data"
            r2 = 0
            if (r12 == 0) goto L_0x0098
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x0098
            java.io.Serializable r12 = r12.getSerializableExtra(r13)
            goto L_0x0099
        L_0x0098:
            r12 = r2
        L_0x0099:
            if (r12 == 0) goto L_0x00af
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            if (r12 == 0) goto L_0x00ab
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x00ab
            java.io.Serializable r2 = r12.getSerializableExtra(r13)
        L_0x00ab:
            net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank r2 = (net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank) r2
            r10.k = r2
        L_0x00af:
            android.widget.RelativeLayout r12 = r10.f57420a
            if (r12 != 0) goto L_0x00b8
            java.lang.String r13 = "rlDownloadStatement"
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x00b8:
            r13 = r10
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
            android.widget.RelativeLayout r12 = r10.f57421b
            if (r12 != 0) goto L_0x00c7
            java.lang.String r2 = "rlSendMoneyLayout"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00c7:
            r12.setOnClickListener(r13)
            android.widget.RelativeLayout r12 = r10.f57422c
            java.lang.String r2 = "rlAddMoneyLayout"
            if (r12 != 0) goto L_0x00d3
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00d3:
            r12.setOnClickListener(r13)
            int r12 = net.one97.paytm.passbook.R.id.rlAutomaticAddMoney
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r12.setOnClickListener(r13)
            android.widget.RelativeLayout r12 = r10.f57423d
            java.lang.String r3 = "rlViewSpendAnalytics"
            if (r12 != 0) goto L_0x00ea
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00ea:
            r12.setOnClickListener(r13)
            android.content.Context r12 = r10.f57425f
            if (r12 != 0) goto L_0x00f4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00f4:
            java.lang.String r12 = net.one97.paytm.passbook.mapping.c.v()
            net.one97.paytm.passbook.utility.d$a[] r13 = net.one97.paytm.passbook.utility.d.a.values()
            int r4 = r13.length
            java.lang.String r5 = ""
            r6 = r5
            r5 = 0
        L_0x0101:
            r7 = 1
            if (r5 >= r4) goto L_0x011e
            r8 = r13[r5]
            if (r12 == 0) goto L_0x011b
            java.lang.String r9 = r8.getWalletUserState()
            boolean r7 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r9, (boolean) r7)
            if (r7 == 0) goto L_0x011b
            java.lang.String r6 = r8.getv2UserState()
            java.lang.String r7 = "mapping.getv2UserState()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
        L_0x011b:
            int r5 = r5 + 1
            goto L_0x0101
        L_0x011e:
            r10.f57427h = r6
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            android.content.Context r13 = r10.f57425f
            if (r13 != 0) goto L_0x012b
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x012b:
            java.lang.String r12 = r12.k()
            boolean r13 = com.paytm.utility.v.a((java.lang.String) r12)
            java.lang.String r4 = "mSpendAnalyticsDividerView"
            r5 = 8
            if (r13 != 0) goto L_0x024c
            java.lang.String r13 = "addMoneyPassbookHideUsers"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            kotlin.m.l r13 = new kotlin.m.l
            java.lang.String r6 = ","
            r13.<init>((java.lang.String) r6)
            java.util.List r12 = r13.split(r12, r0)
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x017e
            int r13 = r12.size()
            java.util.ListIterator r13 = r12.listIterator(r13)
        L_0x0159:
            boolean r6 = r13.hasPrevious()
            if (r6 == 0) goto L_0x017e
            java.lang.Object r6 = r13.previous()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 != 0) goto L_0x016f
            r6 = 1
            goto L_0x0170
        L_0x016f:
            r6 = 0
        L_0x0170:
            if (r6 != 0) goto L_0x0159
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            int r13 = r13.nextIndex()
            int r13 = r13 + r7
            java.util.List r12 = kotlin.a.k.b(r12, (int) r13)
            goto L_0x0182
        L_0x017e:
            kotlin.a.w r12 = kotlin.a.w.INSTANCE
            java.util.List r12 = (java.util.List) r12
        L_0x0182:
            java.util.Collection r12 = (java.util.Collection) r12
            java.lang.String[] r13 = new java.lang.String[r0]
            java.lang.Object[] r12 = r12.toArray(r13)
            if (r12 == 0) goto L_0x0244
            java.lang.String[] r12 = (java.lang.String[]) r12
            int r13 = r12.length
            r6 = 0
        L_0x0190:
            if (r6 >= r13) goto L_0x0223
            r8 = r12[r6]
            java.lang.String r9 = "no_kyc"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x01bf
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            android.content.Context r9 = r10.f57425f
            if (r9 != 0) goto L_0x01a7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01a7:
            int r8 = r8.b((android.content.Context) r9)
            if (r8 != 0) goto L_0x021f
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            android.content.Context r9 = r10.f57425f
            if (r9 != 0) goto L_0x01b8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b8:
            boolean r8 = r8.c((android.content.Context) r9)
            if (r8 != 0) goto L_0x021f
            goto L_0x0203
        L_0x01bf:
            java.lang.String r9 = "min_kyc"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x01ea
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            android.content.Context r13 = r10.f57425f
            if (r13 != 0) goto L_0x01d2
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01d2:
            int r12 = r12.b((android.content.Context) r13)
            if (r12 != 0) goto L_0x0223
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            android.content.Context r13 = r10.f57425f
            if (r13 != 0) goto L_0x01e3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01e3:
            boolean r12 = r12.c((android.content.Context) r13)
            if (r12 == 0) goto L_0x0223
            goto L_0x0203
        L_0x01ea:
            java.lang.String r9 = "no_kyc_expired"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x0205
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            android.content.Context r9 = r10.f57425f
            if (r9 != 0) goto L_0x01fd
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01fd:
            int r8 = r8.d((android.content.Context) r9)
            if (r8 != r7) goto L_0x021f
        L_0x0203:
            r12 = 1
            goto L_0x0224
        L_0x0205:
            java.lang.String r9 = "full_kyc"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x021f
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            android.content.Context r9 = r10.f57425f
            if (r9 != 0) goto L_0x0218
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0218:
            int r8 = r8.b((android.content.Context) r9)
            if (r8 != r7) goto L_0x021f
            goto L_0x0203
        L_0x021f:
            int r6 = r6 + 1
            goto L_0x0190
        L_0x0223:
            r12 = 0
        L_0x0224:
            if (r12 == 0) goto L_0x024c
            android.widget.RelativeLayout r12 = r10.f57422c
            if (r12 != 0) goto L_0x022d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x022d:
            if (r12 == 0) goto L_0x024c
            android.widget.RelativeLayout r12 = r10.f57422c
            if (r12 != 0) goto L_0x0236
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0236:
            r12.setVisibility(r5)
            android.view.View r12 = r10.f57424e
            if (r12 != 0) goto L_0x0240
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0240:
            r12.setVisibility(r5)
            goto L_0x024c
        L_0x0244:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            r11.<init>(r12)
            throw r11
        L_0x024c:
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            java.lang.String r13 = "isSpendAnalyticsEnabledInPassbook8.6.5"
            boolean r12 = r12.a((java.lang.String) r13, (boolean) r7)
            if (r12 == 0) goto L_0x0263
            android.widget.RelativeLayout r12 = r10.f57423d
            if (r12 != 0) goto L_0x025f
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x025f:
            r12.setVisibility(r0)
            goto L_0x0277
        L_0x0263:
            android.view.View r12 = r10.f57424e
            if (r12 != 0) goto L_0x026a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x026a:
            r12.setVisibility(r5)
            android.widget.RelativeLayout r12 = r10.f57423d
            if (r12 != 0) goto L_0x0274
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0274:
            r12.setVisibility(r5)
        L_0x0277:
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r13 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r13 = net.one97.paytm.passbook.utility.k.a()
            boolean r12 = r12.a((java.lang.String) r13, (boolean) r7)
            if (r12 != 0) goto L_0x02a6
            int r12 = net.one97.paytm.passbook.R.id.rlAutomaticAddMoney
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            java.lang.String r13 = "view.rlAutomaticAddMoney"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r12.setVisibility(r5)
            int r12 = net.one97.paytm.passbook.R.id.viewAutoAddMoneyDivider
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r13 = "view.viewAutoAddMoneyDivider"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r12.setVisibility(r5)
            goto L_0x02ca
        L_0x02a6:
            net.one97.paytm.passbook.mapping.f r12 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r13 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r13 = net.one97.paytm.passbook.utility.k.c()
            boolean r12 = r12.a((java.lang.String) r13, (boolean) r7)
            if (r12 == 0) goto L_0x02ca
            net.one97.paytm.passbook.genericPassbook.d.a.e r12 = net.one97.paytm.passbook.genericPassbook.d.a.e.f57457a
            android.content.Context r12 = r10.getContext()
            net.one97.paytm.passbook.genericPassbook.d.a.b$a r13 = new net.one97.paytm.passbook.genericPassbook.d.a.b$a
            r13.<init>(r10, r11)
            net.one97.paytm.passbook.mapping.a.i$a r13 = (net.one97.paytm.passbook.mapping.a.i.a) r13
            net.one97.paytm.passbook.genericPassbook.d.a.b$b r0 = net.one97.paytm.passbook.genericPassbook.d.a.b.C1077b.f57431a
            net.one97.paytm.passbook.mapping.a.g r0 = (net.one97.paytm.passbook.mapping.a.g) r0
            net.one97.paytm.passbook.genericPassbook.d.a.e.b(r12, r13, r0)
        L_0x02ca:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.a.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onClick(View view) {
        Intent intent;
        List list;
        if (view != null) {
            RelativeLayout relativeLayout = this.f57420a;
            if (relativeLayout == null) {
                k.a("rlDownloadStatement");
            }
            if (k.a((Object) view, (Object) relativeLayout)) {
                f b2 = net.one97.paytm.passbook.d.b();
                Context context = this.f57425f;
                if (context == null) {
                    k.a("mContext");
                }
                b2.a(context, "passbook", "wallet_download_statement", (String) null, "", "/passbook/wallet", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                d dVar = this.f57428i;
                if (dVar == null) {
                    k.a("presenter");
                }
                dVar.a();
                if (this.f57428i == null) {
                    k.a("presenter");
                }
                d.b();
                Context context2 = this.f57425f;
                if (context2 == null) {
                    k.a("mContext");
                }
                Intent intent2 = new Intent(context2, StatementDownloadActivity.class);
                TextView textView = this.f57426g;
                if (textView == null) {
                    k.a("tvWalletDownloadStatement");
                }
                intent2.putExtra("header_title", textView.getText().toString());
                intent2.putExtra("CallingFragment", "PassbookWalletFragment");
                startActivityForResult(intent2, 131);
                net.one97.paytm.passbook.utility.q.a(getContext(), "uth_passbook", "paytm_wallet_item_clicked", "request_statement", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
                return;
            }
            RelativeLayout relativeLayout2 = this.f57421b;
            if (relativeLayout2 == null) {
                k.a("rlSendMoneyLayout");
            }
            if (k.a((Object) view, (Object) relativeLayout2)) {
                String str = null;
                if (net.one97.paytm.passbook.d.b().a("passSendMoneyToBankDeeplinkEnabled", true)) {
                    String a2 = net.one97.paytm.passbook.d.b().a("passSendMoneyToBankDeeplink");
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "paytmmp://cash_wallet?featuretype=send_money_bank&source=Passbook";
                    }
                    net.one97.paytm.passbook.d.b().a(a2, (Activity) getActivity());
                    this.l = true;
                } else {
                    f b3 = net.one97.paytm.passbook.d.b();
                    Context context3 = this.f57425f;
                    if (context3 == null) {
                        k.a("mContext");
                    }
                    b3.a(context3, "passbook", "send_money_wallet_to_bank", (String) null, "", "/passbook/wallet", "passbook");
                    Context context4 = this.f57425f;
                    if (context4 == null) {
                        k.a("mContext");
                    }
                    if (com.paytm.utility.b.c(context4)) {
                        f b4 = net.one97.paytm.passbook.d.b();
                        if (this.f57425f == null) {
                            k.a("mContext");
                        }
                        String l2 = b4.l();
                        CharSequence charSequence = l2;
                        if (!TextUtils.isEmpty(charSequence)) {
                            k.a((Object) l2, "p2bKycStatus");
                            list = p.a(charSequence, new String[]{AppConstants.COMMA});
                        } else {
                            list = null;
                        }
                        if (list == null || !kotlin.a.k.a(list, this.f57427h)) {
                            if (this.f57428i == null) {
                                k.a("presenter");
                            }
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                d.a((AppCompatActivity) activity, (d.a) this);
                                Context context5 = this.f57425f;
                                if (context5 == null) {
                                    k.a("mContext");
                                }
                                net.one97.paytm.passbook.utility.q.a(context5, "passbook_wallet", "passbook_wallet_send_money_clicked", (ArrayList<String>) null, "/passbook/wallet/");
                            } else {
                                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                            }
                        } else {
                            Context context6 = this.f57425f;
                            if (context6 == null) {
                                k.a("mContext");
                            }
                            f b5 = net.one97.paytm.passbook.d.b();
                            k.a((Object) b5, "PassbookHelper.getImplListener()");
                            startActivity(new Intent(context6, b5.d()));
                        }
                    } else {
                        c.g(getActivity());
                    }
                }
                FragmentActivity activity2 = getActivity();
                if (!(activity2 == null || (intent = activity2.getIntent()) == null)) {
                    int intExtra = intent.getIntExtra("extra_module_open_source", 0);
                    if (intExtra == 1) {
                        str = Constants.DEFAULT_BANK;
                    } else if (intExtra == 0) {
                        str = CLPConstants.CHANNEL_NAME;
                    }
                }
                net.one97.paytm.passbook.utility.q.a(getContext(), "uth_passbook", "paytm_wallet_item_clicked", "send_money_from_wallet_to_bank", str, "/uth_passbook/paytm_wallet", "PASSBOOK");
                return;
            }
            RelativeLayout relativeLayout3 = this.f57422c;
            if (relativeLayout3 == null) {
                k.a("rlAddMoneyLayout");
            }
            if (k.a((Object) view, (Object) relativeLayout3)) {
                f b6 = net.one97.paytm.passbook.d.b();
                Context context7 = this.f57425f;
                if (context7 == null) {
                    k.a("mContext");
                }
                b6.a(context7, "passbook", "add_money_to_wallet", (String) null, "", "/passbook/wallet", "passbook");
                net.one97.paytm.passbook.mapping.g.a();
                net.one97.paytm.passbook.mapping.g.a(getActivity(), "wallet");
                net.one97.paytm.passbook.utility.q.a(getContext(), "uth_passbook", "paytm_wallet_item_clicked", "add_money_to_wallet", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
                return;
            }
            RelativeLayout relativeLayout4 = this.f57423d;
            if (relativeLayout4 == null) {
                k.a("rlViewSpendAnalytics");
            }
            if (k.a((Object) view, (Object) relativeLayout4)) {
                f b7 = net.one97.paytm.passbook.d.b();
                Context context8 = this.f57425f;
                if (context8 == null) {
                    k.a("mContext");
                }
                b7.a(context8, "passbook", "wallet_view_spend_analytics", (String) null, "", "/passbook/wallet", "passbook");
                Context context9 = this.f57425f;
                if (context9 == null) {
                    k.a("mContext");
                }
                startActivity(new Intent(context9, SpendAnalyticsMainActivity.class));
                net.one97.paytm.passbook.utility.q.a(getContext(), "uth_passbook", "paytm_wallet_item_clicked", "view_spend_analytics", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
            } else if (k.a((Object) view, (Object) (RelativeLayout) view.findViewById(R.id.rlAutomaticAddMoney))) {
                net.one97.paytm.passbook.d.b().a("paytmmp://cash_wallet?featuretype=add_money&tab=automatic_add_money", (Activity) getActivity());
                net.one97.paytm.passbook.utility.q.a(getContext(), "Passbook", "AAM_clicked_L2", (String) null, (String) null, "Wallet Passbook", "PASSBOOK");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x009a A[Catch:{ Exception -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.beans.CJRP2BStatus r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.g.b.k.c(r7, r0)
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            if (r0 == 0) goto L_0x014f
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isFinishing()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x001c
        L_0x001b:
            r0 = r1
        L_0x001c:
            if (r0 != 0) goto L_0x0021
            kotlin.g.b.k.a()
        L_0x0021:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0029
            goto L_0x014f
        L_0x0029:
            r6.j = r7
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            if (r7 == 0) goto L_0x003a
            boolean r7 = r7.isFinishing()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x003b
        L_0x003a:
            r7 = r1
        L_0x003b:
            if (r7 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x014f
            net.one97.paytm.passbook.beans.CJRP2BStatus r7 = r6.j
            java.lang.String r0 = "mP2BStatus"
            if (r7 != 0) goto L_0x004f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x004f:
            r2 = 1
            java.lang.String r3 = "mContext"
            if (r7 == 0) goto L_0x00ef
            net.one97.paytm.passbook.beans.CJRP2BStatus r7 = r6.j
            if (r7 != 0) goto L_0x005b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x005b:
            net.one97.paytm.passbook.beans.CJRP2BStatusResponse r7 = r7.getResponse()
            if (r7 == 0) goto L_0x00ef
            net.one97.paytm.passbook.beans.CJRP2BStatus r7 = r6.j
            if (r7 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0068:
            net.one97.paytm.passbook.beans.CJRP2BStatusResponse r7 = r7.getResponse()
            java.lang.String r0 = "mP2BStatus.response"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            boolean r7 = r7.isValidForTxn()
            if (r7 == 0) goto L_0x00ef
            android.content.Context r7 = r6.f57425f
            if (r7 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x007e:
            boolean r7 = com.paytm.utility.b.c((android.content.Context) r7)
            if (r7 == 0) goto L_0x00d4
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "extra_home_data"
            if (r7 == 0) goto L_0x0097
            android.content.Intent r7 = r7.getIntent()     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x0097
            java.io.Serializable r7 = r7.getSerializableExtra(r0)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0098
        L_0x0097:
            r7 = r1
        L_0x0098:
            if (r7 == 0) goto L_0x00d0
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00aa
            android.content.Intent r7 = r7.getIntent()     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00aa
            java.io.Serializable r1 = r7.getSerializableExtra(r0)     // Catch:{ Exception -> 0x00d0 }
        L_0x00aa:
            java.lang.Class<net.one97.paytm.passbook.beans.CJRHomePageItem> r7 = net.one97.paytm.passbook.beans.CJRHomePageItem.class
            java.lang.Object r7 = net.one97.paytm.passbook.utility.q.a((java.lang.Object) r1, r7)     // Catch:{ Exception -> 0x00d0 }
            net.one97.paytm.passbook.beans.CJRHomePageItem r7 = (net.one97.paytm.passbook.beans.CJRHomePageItem) r7     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00d0
            java.lang.String r0 = "wallet_to_ppb"
            java.lang.String r1 = r7.getPushFeatureType()     // Catch:{ Exception -> 0x00d0 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x00d0 }
            if (r0 == 0) goto L_0x00c4
            r6.a()     // Catch:{ Exception -> 0x00d0 }
            return
        L_0x00c4:
            java.lang.String r0 = "cash_ledger"
            java.lang.String r7 = r7.getPushFeatureType()     // Catch:{ Exception -> 0x00d0 }
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00d0 }
            if (r7 != 0) goto L_0x00ee
        L_0x00d0:
            r6.a()
            return
        L_0x00d4:
            android.content.Context r7 = r6.f57425f
            if (r7 != 0) goto L_0x00db
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00db:
            android.content.res.Resources r0 = r6.getResources()
            int r1 = net.one97.paytm.passbook.R.string.err_nonetwork_msg
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r0, r2)
            r7.show()
        L_0x00ee:
            return
        L_0x00ef:
            net.one97.paytm.passbook.mapping.f r7 = net.one97.paytm.passbook.d.b()
            android.content.Context r0 = r6.f57425f
            if (r0 != 0) goto L_0x00fa
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00fa:
            java.lang.String r7 = r7.q()
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0109
            java.lang.String r7 = "0120 3888 388"
        L_0x0109:
            int r0 = net.one97.paytm.passbook.R.string.help_text_send_to_bnk_err
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "contactUsNumber"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r3 = 0
            java.lang.String r4 = " "
            java.lang.String r5 = ""
            java.lang.String r4 = kotlin.m.p.a(r7, r4, r5, r3)
            r1[r3] = r4
            r1[r2] = r7
            java.lang.String r7 = r6.getString(r0, r1)
            java.lang.String r0 = "getString(R.string.help_… \", \"\"), contactUsNumber)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            net.one97.paytm.passbook.genericPassbook.d.a.d r0 = r6.f57428i
            if (r0 != 0) goto L_0x0132
            java.lang.String r1 = "presenter"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0132:
            android.text.Spanned r7 = android.text.Html.fromHtml(r7)
            java.lang.String r1 = "Html.fromHtml(message)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            if (r1 == 0) goto L_0x0147
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            r0.a((android.text.Spanned) r7, (androidx.appcompat.app.AppCompatActivity) r1)
            goto L_0x014f
        L_0x0147:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            r7.<init>(r0)
            throw r7
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.a.b.a(net.one97.paytm.passbook.beans.CJRP2BStatus):void");
    }

    private final void a() {
        Intent intent;
        f b2 = net.one97.paytm.passbook.d.b();
        Activity activity = getActivity();
        CJRP2BStatus cJRP2BStatus = this.j;
        if (cJRP2BStatus == null) {
            k.a("mP2BStatus");
        }
        Intent a2 = b2.a(activity, cJRP2BStatus);
        FragmentActivity activity2 = getActivity();
        if (!(activity2 == null || (intent = activity2.getIntent()) == null)) {
            a2.putExtra("extra_module_open_source", intent.getIntExtra("extra_module_open_source", 0));
        }
        FragmentActivity activity3 = getActivity();
        Boolean valueOf = activity3 != null ? Boolean.valueOf(activity3.isFinishing()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (!valueOf.booleanValue()) {
            startActivityForResult(a2, 127);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "networkError");
        getClass().getName();
        j.a((Activity) getActivity(), (Throwable) networkCustomError);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 131 && intent != null && intent.getBooleanExtra("finish_activity", false) && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.l && net.one97.paytm.passbook.d.b().a("passSendMoneyToBankDeeplinkEnabled", true)) {
            this.l = false;
            if (getActivity() instanceof PassbookL2Activity) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    ((PassbookL2Activity) activity).a().a();
                    FragmentActivity activity2 = getActivity();
                    Fragment fragment = null;
                    Fragment c2 = activity2 != null ? activity2.getSupportFragmentManager().c(R.id.l2Fragment) : null;
                    if (c2 != null) {
                        ((PassbookL2Fragment) c2).b();
                        FragmentActivity activity3 = getActivity();
                        if (activity3 != null) {
                            fragment = activity3.getSupportFragmentManager().c(R.id.l2Fragment);
                        }
                        if (fragment != null) {
                            ((PassbookL2Fragment) fragment).a();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity");
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, View view, AAM_STATUS aam_status) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        ImageView imageView;
        if (aam_status != AAM_STATUS.NEW) {
            String str = null;
            if (aam_status == AAM_STATUS.ACTIVE) {
                if (!(view == null || (appCompatTextView8 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                    appCompatTextView8.setVisibility(0);
                }
                if (!(view == null || (appCompatTextView7 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                    Context context = bVar.getContext();
                    if (context != null) {
                        str = context.getString(R.string.pass_active);
                    }
                    appCompatTextView7.setText(str);
                }
                Context context2 = bVar.getContext();
                if (context2 != null) {
                    if (!(view == null || (appCompatTextView6 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                        appCompatTextView6.setTextColor(androidx.core.content.b.c(context2, R.color.pass_color_11bf80));
                    }
                    if (Build.VERSION.SDK_INT >= 21 && view != null && (appCompatTextView5 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) != null) {
                        appCompatTextView5.setBackgroundTintList(ColorStateList.valueOf(androidx.core.content.b.c(context2, R.color.pass_color_11bf80)));
                    }
                }
            } else if (aam_status == AAM_STATUS.PAUSED) {
                if (!(view == null || (appCompatTextView4 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                    appCompatTextView4.setVisibility(0);
                }
                if (!(view == null || (appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                    Context context3 = bVar.getContext();
                    if (context3 != null) {
                        str = context3.getString(R.string.pass_paused);
                    }
                    appCompatTextView3.setText(str);
                }
                Context context4 = bVar.getContext();
                if (context4 != null) {
                    if (!(view == null || (appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) == null)) {
                        appCompatTextView2.setTextColor(androidx.core.content.b.c(context4, R.color.pass_color_ff9d00));
                    }
                    if (Build.VERSION.SDK_INT >= 21 && view != null && (appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tvSubscriptionStatus)) != null) {
                        appCompatTextView.setBackgroundTintList(ColorStateList.valueOf(androidx.core.content.b.c(context4, R.color.pass_color_ff9d00)));
                    }
                }
            }
        } else if (view != null && (imageView = (ImageView) view.findViewById(R.id.ivAamNew)) != null) {
            imageView.setVisibility(0);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
