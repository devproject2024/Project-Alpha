package net.one97.paytm.recharge.common.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.common.entity.shopping.CJROrdersNew;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.an;
import net.one97.paytm.recharge.common.utils.ag;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.v;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;
import net.one97.paytm.upi.util.UpiConstants;

public final class AJRMyPaymentsHistoryActivity extends CJRBasePaymentsHistoryActivity implements v.a {

    /* renamed from: a  reason: collision with root package name */
    String f60755a;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJROrderList> f60756e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRFrequentOrder f60757f;

    /* renamed from: g  reason: collision with root package name */
    private String f60758g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f60759h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f60760i;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public v l;
    private HashMap m;

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = r0.getConfiguration();
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02c9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0344 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0455  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r13 = this;
            com.paytm.network.model.IJRPaytmDataModel r0 = r13.f60852b
            boolean r0 = r0 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
            if (r0 == 0) goto L_0x0524
            com.paytm.network.model.IJRPaytmDataModel r0 = r13.f60852b
            if (r0 == 0) goto L_0x051c
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r0
            r13.f60757f = r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            java.lang.String r1 = "recharge_number"
            r2 = 0
            if (r0 == 0) goto L_0x0022
            java.util.Map r0 = r0.getConfiguration()
            if (r0 == 0) goto L_0x0022
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            r13.f60758g = r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getProductID()
            goto L_0x002f
        L_0x002e:
            r0 = r2
        L_0x002f:
            r13.f60759h = r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = r0.getPayTypeDisplayLabel()
            goto L_0x003b
        L_0x003a:
            r0 = r2
        L_0x003b:
            r13.k = r0
            net.one97.paytm.recharge.common.utils.v r0 = new net.one97.paytm.recharge.common.utils.v
            r3 = r13
            android.content.Context r3 = (android.content.Context) r3
            r4 = r13
            net.one97.paytm.recharge.common.utils.v$a r4 = (net.one97.paytm.recharge.common.utils.v.a) r4
            r0.<init>(r3, r4)
            r13.l = r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = r0.getPaidOn()
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L_0x00c6
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r7 = "yyyy-MM-dd'T'HH:mm:ss"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x00b8 }
            r4.<init>(r7, r8)     // Catch:{ Exception -> 0x00b8 }
            java.util.Date r0 = r4.parse(r0)     // Catch:{ Exception -> 0x00b8 }
            java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r7 = "cal"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x00b8 }
            r4.setTime(r0)     // Catch:{ Exception -> 0x00b8 }
            r0 = 2
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = r4.getDisplayName(r0, r6, r7)     // Catch:{ Exception -> 0x00b8 }
            int r7 = r4.get(r6)     // Catch:{ Exception -> 0x00b8 }
            r8 = 5
            int r4 = r4.get(r8)     // Catch:{ Exception -> 0x00b8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8 }
            r8.<init>()     // Catch:{ Exception -> 0x00b8 }
            r8.append(r4)     // Catch:{ Exception -> 0x00b8 }
            r4 = 32
            r8.append(r4)     // Catch:{ Exception -> 0x00b8 }
            r8.append(r0)     // Catch:{ Exception -> 0x00b8 }
            r8.append(r4)     // Catch:{ Exception -> 0x00b8 }
            r8.append(r7)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x00b8 }
            android.content.res.Resources r4 = r13.getResources()     // Catch:{ Exception -> 0x00b8 }
            int r7 = net.one97.paytm.recharge.R.string.last_paid_on_str     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00b8 }
            r8[r5] = r0     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = r4.getString(r7, r8)     // Catch:{ Exception -> 0x00b8 }
            r13.j = r0     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00d2
        L_0x00b8:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x00c2
            java.lang.String r0 = r0.getmCreatedAt()
            goto L_0x00c3
        L_0x00c2:
            r0 = r2
        L_0x00c3:
            r13.j = r0
            goto L_0x00d2
        L_0x00c6:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = r0.getmCreatedAt()
            goto L_0x00d0
        L_0x00cf:
            r0 = r2
        L_0x00d0:
            r13.j = r0
        L_0x00d2:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r13.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r13.setSupportActionBar(r0)
            androidx.appcompat.app.ActionBar r0 = r13.getSupportActionBar()
            if (r0 != 0) goto L_0x00e6
            kotlin.g.b.k.a()
        L_0x00e6:
            r0.b((boolean) r6)
            androidx.appcompat.app.ActionBar r0 = r13.getSupportActionBar()
            if (r0 != 0) goto L_0x00f2
            kotlin.g.b.k.a()
        L_0x00f2:
            r0.c((boolean) r5)
            int r0 = net.one97.paytm.recharge.R.id.app_bar_layout
            android.view.View r0 = r13.a((int) r0)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            r4 = r13
            com.google.android.material.appbar.AppBarLayout$b r4 = (com.google.android.material.appbar.AppBarLayout.b) r4
            r0.a((com.google.android.material.appbar.AppBarLayout.b) r4)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r13.f60757f
            if (r0 == 0) goto L_0x010c
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r0.getCjrBillDetails()
            goto L_0x010d
        L_0x010c:
            r0 = r2
        L_0x010d:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r13.f60757f
            if (r4 == 0) goto L_0x0116
            java.lang.String r4 = r4.getOperatorDisplayLabel()
            goto L_0x0117
        L_0x0116:
            r4 = r2
        L_0x0117:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0124
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r4 = 0
            goto L_0x0125
        L_0x0124:
            r4 = 1
        L_0x0125:
            java.lang.String r7 = "toolbar_recharge_operator"
            java.lang.String r8 = "recharge_operator"
            if (r4 == 0) goto L_0x0161
            int r4 = net.one97.paytm.recharge.R.id.recharge_operator
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r8 = r13.f60757f
            if (r8 == 0) goto L_0x0140
            java.lang.String r8 = r8.getOperator()
            goto L_0x0141
        L_0x0140:
            r8 = r2
        L_0x0141:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            int r4 = net.one97.paytm.recharge.R.id.toolbar_recharge_operator
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r7 = r13.f60757f
            if (r7 == 0) goto L_0x015a
            java.lang.String r7 = r7.getOperator()
            goto L_0x015b
        L_0x015a:
            r7 = r2
        L_0x015b:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
            goto L_0x0195
        L_0x0161:
            int r4 = net.one97.paytm.recharge.R.id.recharge_operator
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r8 = r13.f60757f
            if (r8 == 0) goto L_0x0175
            java.lang.String r8 = r8.getOperatorDisplayLabel()
            goto L_0x0176
        L_0x0175:
            r8 = r2
        L_0x0176:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            int r4 = net.one97.paytm.recharge.R.id.toolbar_recharge_operator
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r7 = r13.f60757f
            if (r7 == 0) goto L_0x018f
            java.lang.String r7 = r7.getOperatorDisplayLabel()
            goto L_0x0190
        L_0x018f:
            r7 = r2
        L_0x0190:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
        L_0x0195:
            int r4 = net.one97.paytm.recharge.R.id.recharge_number
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            java.lang.String r1 = r13.f60758g
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            int r1 = net.one97.paytm.recharge.R.id.toolbar_recharge_number
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r4 = "toolbar_recharge_number"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = r13.f60758g
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r13.f60757f
            if (r4 == 0) goto L_0x01c9
            java.lang.String r4 = r4.getOperatorLogoURL()
            goto L_0x01ca
        L_0x01c9:
            r4 = r2
        L_0x01ca:
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r4)
            int r4 = net.one97.paytm.recharge.R.id.vendor_logo
            android.view.View r4 = r13.a((int) r4)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r4 = (net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8) r4
            r1.a((android.widget.ImageView) r4)
            java.lang.String r1 = r13.k
            if (r1 == 0) goto L_0x01fc
            int r1 = net.one97.paytm.recharge.R.id.txt_title
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r4 = "txt_title"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            int r4 = net.one97.paytm.recharge.R.string.payment_type
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r8 = r13.k
            r7[r5] = r8
            java.lang.String r4 = r13.getString(r4, r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x01fc:
            int r1 = net.one97.paytm.recharge.R.id.btn_pay
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$b r4 = new net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$b
            r4.<init>(r13)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x0239
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r1 = r1.getFrequentOrderProduct()
            if (r1 == 0) goto L_0x0239
            boolean r1 = r1.isSchedulable()
            if (r1 != r6) goto L_0x0239
            net.one97.paytm.recharge.common.utils.v r1 = r13.l
            if (r1 == 0) goto L_0x0239
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r13.f60757f
            if (r4 == 0) goto L_0x022b
            java.lang.String r4 = r4.getRechargeNumber()
            goto L_0x022c
        L_0x022b:
            r4 = r2
        L_0x022c:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r7 = r13.f60757f
            if (r7 == 0) goto L_0x0235
            java.lang.String r7 = r7.getService()
            goto L_0x0236
        L_0x0235:
            r7 = r2
        L_0x0236:
            r1.a((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r7)
        L_0x0239:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x0242
            java.lang.String r1 = r1.getRechargeAmount()
            goto L_0x0243
        L_0x0242:
            r1 = r2
        L_0x0243:
            if (r1 == 0) goto L_0x0270
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x024e
            java.lang.String r1 = r1.getRechargeAmount()
            goto L_0x024f
        L_0x024e:
            r1 = r2
        L_0x024f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isDigitsOnly(r1)
            if (r1 == 0) goto L_0x0270
            android.content.res.Resources r1 = r13.getResources()
            int r4 = net.one97.paytm.recharge.R.string.recharge_rs
            java.lang.Object[] r7 = new java.lang.Object[r6]
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r8 = r13.f60757f
            if (r8 == 0) goto L_0x0268
            java.lang.String r8 = r8.getRechargeAmount()
            goto L_0x0269
        L_0x0268:
            r8 = r2
        L_0x0269:
            r7[r5] = r8
            java.lang.String r1 = r1.getString(r4, r7)
            goto L_0x027a
        L_0x0270:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x0279
            java.lang.String r1 = r1.getRechargeAmount()
            goto L_0x027a
        L_0x0279:
            r1 = r2
        L_0x027a:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r13.f60757f
            if (r4 == 0) goto L_0x0291
            if (r4 == 0) goto L_0x0285
            java.lang.String r4 = r4.getPayType()
            goto L_0x0286
        L_0x0285:
            r4 = r2
        L_0x0286:
            if (r4 == 0) goto L_0x0291
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r13.f60757f
            if (r4 == 0) goto L_0x0291
            java.lang.String r4 = r4.getPayType()
            goto L_0x0292
        L_0x0291:
            r4 = r2
        L_0x0292:
            java.lang.String r7 = "postpaid"
            boolean r4 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r6)
            if (r4 == 0) goto L_0x02a0
            int r1 = net.one97.paytm.recharge.R.string.pay_bill_str
            java.lang.String r1 = r13.getString(r1)
        L_0x02a0:
            int r4 = net.one97.paytm.recharge.R.id.btn_pay
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r8 = "btn_pay"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x02bb
            java.lang.String r1 = r1.getPayType()
            goto L_0x02bc
        L_0x02bb:
            r1 = r2
        L_0x02bc:
            boolean r1 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r1, (boolean) r6)
            java.lang.String r4 = "billPayment.amount"
            java.lang.String r7 = " ₹"
            java.lang.String r9 = "txt_last_bill_date"
            if (r1 == 0) goto L_0x0332
            if (r0 == 0) goto L_0x0332
            java.lang.String r1 = r0.getDueDate()
            int r10 = net.one97.paytm.recharge.R.string.automatic_payment_history_due_date_sql_format
            java.lang.String r10 = r13.getString(r10)
            int r11 = net.one97.paytm.recharge.R.string.my_payments_display_format
            java.lang.String r11 = r13.getString(r11)
            java.lang.String r1 = com.paytm.utility.b.g(r1, r10, r11)
            int r10 = net.one97.paytm.recharge.R.id.txt_last_bill_date
            android.view.View r10 = r13.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            int r9 = net.one97.paytm.recharge.R.string.due_date_holder
            java.lang.Object[] r11 = new java.lang.Object[r6]
            r11[r5] = r1
            java.lang.String r1 = r13.getString(r9, r11)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r10.setText(r1)
            int r1 = net.one97.paytm.recharge.R.id.btn_pay
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = net.one97.paytm.recharge.R.string.pay
            java.lang.String r9 = r13.getString(r9)
            r8.append(r9)
            r8.append(r7)
            java.lang.Double r0 = r0.getAmount()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            double r9 = r0.doubleValue()
            java.lang.String r0 = com.paytm.utility.b.c((double) r9)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x03be
        L_0x0332:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r13.f60757f
            if (r1 == 0) goto L_0x033b
            java.lang.String r1 = r1.getPayType()
            goto L_0x033c
        L_0x033b:
            r1 = r2
        L_0x033c:
            java.lang.String r10 = "prepaid"
            boolean r1 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r1, (boolean) r6)
            if (r1 == 0) goto L_0x03ac
            if (r0 == 0) goto L_0x03ac
            java.lang.String r1 = r0.getExpiry()
            int r10 = net.one97.paytm.recharge.R.string.automatic_payment_history_due_date_sql_format
            java.lang.String r10 = r13.getString(r10)
            int r11 = net.one97.paytm.recharge.R.string.my_payments_display_format
            java.lang.String r11 = r13.getString(r11)
            java.lang.String r1 = com.paytm.utility.b.g(r1, r10, r11)
            int r10 = net.one97.paytm.recharge.R.id.txt_last_bill_date
            android.view.View r10 = r13.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            int r9 = net.one97.paytm.recharge.R.string.expiry_holder
            java.lang.Object[] r11 = new java.lang.Object[r6]
            r11[r5] = r1
            java.lang.String r1 = r13.getString(r9, r11)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r10.setText(r1)
            int r1 = net.one97.paytm.recharge.R.id.btn_pay
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = net.one97.paytm.recharge.R.string.pay
            java.lang.String r9 = r13.getString(r9)
            r8.append(r9)
            r8.append(r7)
            java.lang.Double r0 = r0.getAmount()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            double r9 = r0.doubleValue()
            java.lang.String r0 = com.paytm.utility.b.c((double) r9)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x03be
        L_0x03ac:
            int r0 = net.one97.paytm.recharge.R.id.txt_last_bill_date
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            java.lang.String r1 = r13.j
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x03be:
            java.util.TreeMap r0 = new java.util.TreeMap
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a
            java.lang.String r4 = "$this$CASE_INSENSITIVE_ORDER"
            kotlin.g.b.k.d(r1, r4)
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            java.lang.String r4 = "java.lang.String.CASE_INSENSITIVE_ORDER"
            kotlin.g.b.k.b(r1, r4)
            r0.<init>(r1)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r4 = "#fd5c5c"
            int r7 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Failure"
            r1.put(r8, r7)
            int r7 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Failed"
            r1.put(r8, r7)
            int r4 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "Payment Failure"
            r1.put(r7, r4)
            java.lang.String r4 = "#ffa400"
            int r7 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Pending"
            r1.put(r8, r7)
            int r7 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Processing"
            r1.put(r8, r7)
            int r4 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "In Process"
            r1.put(r7, r4)
            java.lang.String r4 = "#21c17a"
            int r7 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Success"
            r1.put(r8, r7)
            int r4 = android.graphics.Color.parseColor(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "Successful"
            r1.put(r7, r4)
            int r1 = net.one97.paytm.recharge.R.id.transaction_list
            android.view.View r1 = r13.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r13.f60760i = r1
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            r1.<init>(r3)
            androidx.recyclerview.widget.RecyclerView r4 = r13.f60760i
            if (r4 == 0) goto L_0x045b
            r7 = r1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r7
            r4.setLayoutManager(r7)
        L_0x045b:
            androidx.recyclerview.widget.RecyclerView r4 = r13.f60760i
            if (r4 == 0) goto L_0x0469
            net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$c r7 = new net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$c
            r7.<init>(r13, r0)
            androidx.recyclerview.widget.RecyclerView$a r7 = (androidx.recyclerview.widget.RecyclerView.a) r7
            r4.setAdapter(r7)
        L_0x0469:
            androidx.recyclerview.widget.RecyclerView r0 = r13.f60760i
            if (r0 == 0) goto L_0x0477
            androidx.recyclerview.widget.i r4 = new androidx.recyclerview.widget.i
            r4.<init>(r3, r6)
            androidx.recyclerview.widget.RecyclerView$h r4 = (androidx.recyclerview.widget.RecyclerView.h) r4
            r0.addItemDecoration(r4)
        L_0x0477:
            androidx.recyclerview.widget.RecyclerView r0 = r13.f60760i
            if (r0 == 0) goto L_0x0485
            net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$d r4 = new net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity$d
            r4.<init>(r13, r1, r1)
            androidx.recyclerview.widget.RecyclerView$l r4 = (androidx.recyclerview.widget.RecyclerView.l) r4
            r0.addOnScrollListener(r4)
        L_0x0485:
            java.lang.String r7 = "fetch_payment_history"
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r12 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.aS()
            if (r0 == 0) goto L_0x0524
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = com.paytm.utility.c.a((java.lang.String) r0, (android.content.Context) r3)
            r1.<init>(r0)
            java.lang.String r0 = "/search?&recharge_number="
            r1.append(r0)
            java.lang.String r0 = r13.f60758g
            r1.append(r0)
            java.lang.String r0 = "&product_id="
            r1.append(r0)
            java.lang.String r0 = r13.f60759h
            r1.append(r0)
            java.lang.String r0 = "&pagesize=10"
            r1.append(r0)
            java.lang.String r8 = r1.toString()
            java.lang.String r0 = "StringBuilder(getDefault…              .toString()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r0 = com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r3)
            java.lang.String r1 = "CJRAppCommonUtility.addS…enInHeader(headers, this)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.common.f.b r1 = new net.one97.paytm.recharge.common.f.b
            r9 = r13
            net.one97.paytm.recharge.common.e.ai r9 = (net.one97.paytm.recharge.common.e.ai) r9
            net.one97.paytm.common.entity.shopping.CJROrdersNew r4 = new net.one97.paytm.common.entity.shopping.CJROrdersNew
            r4.<init>()
            r10 = r4
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10
            r11 = r0
            java.util.Map r11 = (java.util.Map) r11
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12)
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r0 == 0) goto L_0x0513
            int r0 = net.one97.paytm.recharge.R.id.loading_threedots_lav
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView r0 = (net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView) r0
            net.one97.paytm.recharge.common.utils.ba.a((com.airbnb.lottie.LottieAnimationView) r0)
            int r0 = net.one97.paytm.recharge.R.id.txt_processing_title
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "txt_processing_title"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r5)
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.a r1 = (net.one97.paytm.recharge.common.f.a) r1
            net.one97.paytm.recharge.common.f.d.b(r1)
            return
        L_0x0513:
            net.one97.paytm.recharge.common.f.a r1 = (net.one97.paytm.recharge.common.f.a) r1
            r0 = r13
            android.content.DialogInterface$OnCancelListener r0 = (android.content.DialogInterface.OnCancelListener) r0
            net.one97.paytm.recharge.common.utils.ba.a((net.one97.paytm.recharge.common.f.a) r1, (android.content.Context) r3, (android.content.DialogInterface.OnCancelListener) r0, (net.one97.paytm.recharge.common.e.aa) r2)
            return
        L_0x051c:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrder"
            r0.<init>(r1)
            throw r0
        L_0x0524:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity.b():void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMyPaymentsHistoryActivity f60765a;

        b(AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity) {
            this.f60765a = aJRMyPaymentsHistoryActivity;
        }

        public final void onClick(View view) {
            ba.a(this.f60765a.f60757f, (Context) this.f60765a);
        }
    }

    public static final class c extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMyPaymentsHistoryActivity f60766a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TreeMap f60767b;

        c(AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity, TreeMap treeMap) {
            this.f60766a = aJRMyPaymentsHistoryActivity;
            this.f60767b = treeMap;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            Integer num;
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            Object obj = this.f60766a.f60756e.get(i2);
            k.a(obj, "mOrderOriginalList[position]");
            CJROrderList cJROrderList = (CJROrderList) obj;
            String str = null;
            CJROrderItems a2 = this.f60766a.l != null ? v.a((List<CJROrderItems>) cJROrderList.getOrderItems(), this.f60766a.f60759h) : null;
            TextView textView = aVar.f60762b;
            AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity = this.f60766a;
            int i3 = R.string.currency_holder_re;
            Object[] objArr = new Object[1];
            objArr[0] = com.paytm.utility.b.L(a2 != null ? a2.getPrice() : null);
            textView.setText(aJRMyPaymentsHistoryActivity.getString(i3, objArr));
            aVar.f60761a.setText(com.paytm.utility.b.g(cJROrderList.getDate(), this.f60766a.getString(R.string.automatic_payment_history_due_date_sql_format), this.f60766a.getString(R.string.payment_date_format)));
            TextView textView2 = aVar.f60763c;
            if (a2 != null) {
                str = a2.getStatus();
            }
            textView2.setText(str);
            if (!(a2 == null || a2.getStatus() == null || (num = (Integer) this.f60767b.get(a2.getStatus())) == null)) {
                TextView textView3 = aVar.f60763c;
                k.a((Object) num, "it");
                textView3.setTextColor(num.intValue());
            }
            aVar.f60764d.setOnClickListener(new a(this, cJROrderList));
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f60766a.getBaseContext()).inflate(R.layout.content_recharge_my_payment_history_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(base…tory_item, parent, false)");
            return new a(inflate);
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f60768a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJROrderList f60769b;

            a(c cVar, CJROrderList cJROrderList) {
                this.f60768a = cVar;
                this.f60769b = cJROrderList;
            }

            public final void onClick(View view) {
                AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity = this.f60768a.f60766a;
                Context baseContext = this.f60768a.f60766a.getBaseContext();
                net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                aJRMyPaymentsHistoryActivity.startActivity(new Intent(baseContext, net.one97.paytm.recharge.di.helper.a.a()).setFlags(603979776).putExtra("order_id", this.f60769b.getOrderID()).putExtra(UpiConstants.FROM, "Order_history"));
            }
        }

        public final int getItemCount() {
            return this.f60766a.f60756e.size();
        }
    }

    public static final class d extends ag {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMyPaymentsHistoryActivity f60770a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f60771b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity, LinearLayoutManager linearLayoutManager, LinearLayoutManager linearLayoutManager2) {
            super(linearLayoutManager2);
            this.f60770a = aJRMyPaymentsHistoryActivity;
            this.f60771b = linearLayoutManager;
        }

        public final void a(int i2) {
            AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity = this.f60770a;
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            k.c("fetch_payment_next_page_history", "tag");
            CharSequence charSequence = aJRMyPaymentsHistoryActivity.f60755a;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Context context = aJRMyPaymentsHistoryActivity;
                HashMap<String, String> a3 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), context);
                k.a((Object) a3, "CJRAppCommonUtility.addS…enInHeader(headers, this)");
                net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b("fetch_payment_next_page_history", aJRMyPaymentsHistoryActivity.f60755a, aJRMyPaymentsHistoryActivity, new CJROrdersNew(), a3, a2);
                if (com.paytm.utility.b.c(context)) {
                    ProgressBar progressBar = (ProgressBar) aJRMyPaymentsHistoryActivity.a(R.id.progress_bar);
                    k.a((Object) progressBar, "progress_bar");
                    progressBar.setVisibility(0);
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(bVar);
                }
            }
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60761a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f60762b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f60763c;

        /* renamed from: d  reason: collision with root package name */
        final ConstraintLayout f60764d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.date);
            if (findViewById != null) {
                this.f60761a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.amount);
                if (findViewById2 != null) {
                    this.f60762b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.status);
                    if (findViewById3 != null) {
                        this.f60763c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.payment_item);
                        if (findViewById4 != null) {
                            this.f60764d = (ConstraintLayout) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        String str2;
        String remindable;
        k.c(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
        } else if (itemId == R.id.delete) {
            if (this.l == null) {
                this.l = new v(this, this);
            }
            StringBuilder sb = new StringBuilder();
            TextView textView = (TextView) a(R.id.txt_title);
            k.a((Object) textView, "txt_title");
            CharSequence text = textView.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            sb.append(str);
            sb.append(" ");
            TextView textView2 = (TextView) a(R.id.recharge_number);
            k.a((Object) textView2, "recharge_number");
            CharSequence text2 = textView2.getText();
            if (text2 == null || (str2 = text2.toString()) == null) {
                str2 = "";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            CJRFrequentOrder cJRFrequentOrder = this.f60757f;
            CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder != null ? cJRFrequentOrder.getFrequentOrderProduct() : null;
            x.a aVar = new x.a();
            aVar.element = false;
            if (!(frequentOrderProduct == null || (remindable = frequentOrderProduct.getRemindable()) == null || !p.a(remindable, "2", false))) {
                aVar.element = true;
            }
            net.one97.paytm.recharge.common.widget.a.a(new e(this, aVar), sb2).show(getSupportFragmentManager().a(), (String) null);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public static final class e implements an {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMyPaymentsHistoryActivity f60772a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f60773b;

        e(AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity, x.a aVar) {
            this.f60772a = aJRMyPaymentsHistoryActivity;
            this.f60773b = aVar;
        }

        public final void a() {
            AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity = this.f60772a;
            aJRMyPaymentsHistoryActivity.a(aJRMyPaymentsHistoryActivity.getString(R.string.please_wait_progress_msg_re));
            if (this.f60773b.element) {
                v c2 = this.f60772a.l;
                if (c2 != null) {
                    c2.b(this.f60772a.getBaseContext(), this.f60772a.f60757f);
                    return;
                }
                return;
            }
            v c3 = this.f60772a.l;
            if (c3 != null) {
                c3.a(this.f60772a.getBaseContext(), this.f60772a.f60757f);
            }
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e();
        d();
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        RecyclerView.a adapter;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJROrdersNew) {
            d();
            e();
            CJROrdersNew cJROrdersNew = (CJROrdersNew) iJRPaytmDataModel;
            this.f60755a = cJROrdersNew.getNextUrl();
            ArrayList<CJROrderList> orders = cJROrdersNew.getOrders();
            Integer valueOf = orders != null ? Integer.valueOf(orders.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                ViewFlipper viewFlipper = (ViewFlipper) a(R.id.view_flipper_payment_history);
                k.a((Object) viewFlipper, "view_flipper_payment_history");
                viewFlipper.setDisplayedChild(2);
            }
            this.f60756e.addAll(cJROrdersNew.getOrders());
            RecyclerView recyclerView = this.f60760i;
            if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        k.c(networkCustomError, "error");
        d();
        e();
        super.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
    }

    public final void a() {
        c();
        e();
    }

    public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        k.c(cJRFrequentOrder, "mOrderToBeDeleted");
        if (1007 == i2) {
            CJRRechargeUtilities.INSTANCE.updateRecentHistory();
            finish();
        }
        if (1001 == i2) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.automatic_view);
            k.a((Object) relativeLayout, "automatic_view");
            relativeLayout.setVisibility(0);
            ((TextView) a(R.id.make_automatic)).setOnClickListener(new f(this));
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMyPaymentsHistoryActivity f60774a;

        f(AJRMyPaymentsHistoryActivity aJRMyPaymentsHistoryActivity) {
            this.f60774a = aJRMyPaymentsHistoryActivity;
        }

        public final void onClick(View view) {
            AJRMyPaymentsHistoryActivity.e(this.f60774a);
        }
    }

    private void d() {
        ProgressBar progressBar = (ProgressBar) a(R.id.progress_bar);
        k.a((Object) progressBar, "progress_bar");
        progressBar.setVisibility(8);
    }

    private void e() {
        ba.b((LottieAnimationView) (CJRRechargeLottieAnimationView) a(R.id.loading_threedots_lav));
        TextView textView = (TextView) a(R.id.txt_processing_title);
        k.a((Object) textView, "txt_processing_title");
        textView.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r1 = r1.getFrequentOrderProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity r3) {
        /*
            android.content.Intent r0 = new android.content.Intent
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity> r2 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity.class
            r0.<init>(r1, r2)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r3.f60757f
            if (r1 == 0) goto L_0x0019
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r1 = r1.getFrequentOrderProduct()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r1.getService()
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            java.lang.String r2 = "service_type"
            r0.putExtra(r2, r1)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r3.f60757f
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "selected_recent"
            r0.putExtra(r2, r1)
            r3.startActivity(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity.e(net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity):void");
    }
}
