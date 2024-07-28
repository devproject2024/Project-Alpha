package net.one97.paytm.recharge.common.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.v;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.widgets.c.d;

public final class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<CJRFrequentOrder> f60546a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60547b = true;

    /* renamed from: c  reason: collision with root package name */
    public List<CJRFrequentOrder> f60548c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f60549d;

    /* renamed from: e  reason: collision with root package name */
    private final int f60550e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f60551f;

    /* renamed from: g  reason: collision with root package name */
    private LayoutInflater f60552g;

    /* renamed from: h  reason: collision with root package name */
    private final String f60553h = "₹ 99999";

    /* renamed from: i  reason: collision with root package name */
    private final String f60554i = "XX888888888888";
    private String j;
    private boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public v m;
    private String n = getClass().getSimpleName();

    public enum a {
        POSTPAID,
        PREPAID
    }

    public j(Context context, v vVar, boolean z, String str, List<CJRFrequentOrder> list) {
        this.f60548c = list;
        this.f60551f = context;
        this.f60552g = LayoutInflater.from(context);
        this.f60550e = com.paytm.utility.b.f(this.f60551f);
        this.j = str;
        this.k = z;
        this.m = vVar;
    }

    public final int getCount() {
        if (!this.f60547b) {
            List<CJRFrequentOrder> list = this.f60548c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        List<CJRFrequentOrder> list2 = this.f60548c;
        if (list2 == null) {
            return 0;
        }
        if (list2.size() > 5) {
            return 5;
        }
        return this.f60548c.size();
    }

    /* renamed from: a */
    public final CJRFrequentOrder getItem(int i2) {
        return this.f60548c.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f60548c.get(i2).hashCode();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:48|49|50|51|74|(1:76)|77|(2:82|(5:87|88|89|(1:91)(2:92|(1:94))|100)(2:86|100))(2:81|100)) */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02c5, code lost:
        if ("prepaid".equalsIgnoreCase(r3.getPayType()) != false) goto L_0x02c7;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x024a */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0303 A[Catch:{ Exception -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x031a A[Catch:{ Exception -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0325 A[Catch:{ Exception -> 0x03ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(final int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            r11 = this;
            java.lang.String r0 = "postpaid"
            r1 = 0
            if (r13 != 0) goto L_0x008b
            android.view.LayoutInflater r13 = r11.f60552g
            int r2 = net.one97.paytm.recharge.R.layout.layout_favourite_list
            android.view.View r13 = r13.inflate(r2, r1)
            net.one97.paytm.recharge.common.a.j$b r2 = new net.one97.paytm.recharge.common.a.j$b
            r2.<init>()
            int r3 = net.one97.paytm.recharge.R.id.txt_user_name
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60562d = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_recharge_amount
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60564f = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_mobile_number
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60563e = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_operator
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60565g = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_service_provider
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60566h = r3
            int r3 = net.one97.paytm.recharge.R.id.operator_icon
            android.view.View r3 = r13.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.widget.ImageView unused = r2.f60567i = r3
            int r3 = net.one97.paytm.recharge.R.id.operator_icon_view
            android.view.View r3 = r13.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.widget.ImageView unused = r2.j = r3
            int r3 = net.one97.paytm.recharge.R.id.relative_fav_item
            android.view.View r3 = r13.findViewById(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            android.widget.RelativeLayout unused = r2.k = r3
            int r3 = net.one97.paytm.recharge.R.id.icon_txt_operator
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.l = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_automatic_bill_scheduled
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r2.f60559a = r3
            android.widget.TextView r3 = r2.f60559a
            r3.setOnClickListener(r2)
            r13.setTag(r2)
            goto L_0x0091
        L_0x008b:
            java.lang.Object r2 = r13.getTag()
            net.one97.paytm.recharge.common.a.j$b r2 = (net.one97.paytm.recharge.common.a.j.b) r2
        L_0x0091:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r3 = r11.getItem((int) r12)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder unused = r2.n = r3
            int unused = r2.f60560b = r12
            android.widget.ImageView r4 = r2.j
            net.one97.paytm.recharge.common.a.j$1 r5 = new net.one97.paytm.recharge.common.a.j$1
            r5.<init>(r3, r12)
            r4.setOnClickListener(r5)
            java.lang.Object r12 = r13.getTag()     // Catch:{ Exception -> 0x03ae }
            net.one97.paytm.recharge.common.a.j$b r12 = (net.one97.paytm.recharge.common.a.j.b) r12     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = r3.getRechargeNumber()     // Catch:{ Exception -> 0x03ae }
            net.one97.paytm.recharge.common.a.j.b.b((net.one97.paytm.recharge.common.a.j.b) r12, (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r3)     // Catch:{ Exception -> 0x03ae }
            r5 = 8
            r6 = 0
            if (r4 == 0) goto L_0x00e0
            android.widget.TextView r7 = r12.f60563e     // Catch:{ Exception -> 0x03ae }
            r7.setText(r4)     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = r3.getContactName()     // Catch:{ Exception -> 0x03ae }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x03ae }
            if (r7 == 0) goto L_0x00d2
            android.widget.TextView r4 = r12.f60562d     // Catch:{ Exception -> 0x03ae }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
            goto L_0x00e0
        L_0x00d2:
            android.widget.TextView r7 = r12.f60562d     // Catch:{ Exception -> 0x03ae }
            r7.setText(r4)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r4 = r12.f60562d     // Catch:{ Exception -> 0x03ae }
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x03ae }
        L_0x00e0:
            r4 = 1
            android.content.Context r7 = r11.f60551f     // Catch:{ Exception -> 0x019f }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x019f }
            int r8 = net.one97.paytm.recharge.R.string.last_recharge_on_str     // Catch:{ Exception -> 0x019f }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x019f }
            java.lang.String r10 = r3.getDate()     // Catch:{ Exception -> 0x019f }
            r9[r6] = r10     // Catch:{ Exception -> 0x019f }
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception -> 0x019f }
            java.lang.String r8 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x019f }
            if (r8 != 0) goto L_0x012f
            java.lang.String r8 = "Fee payment"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 != 0) goto L_0x012f
            java.lang.String r8 = "New Registration"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 != 0) goto L_0x012f
            java.lang.String r8 = "Insurance"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 != 0) goto L_0x012f
            java.lang.String r8 = "Loan"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 == 0) goto L_0x0143
        L_0x012f:
            android.content.Context r7 = r11.f60551f     // Catch:{ Exception -> 0x019f }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x019f }
            int r8 = net.one97.paytm.recharge.R.string.last_paid_on_str     // Catch:{ Exception -> 0x019f }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x019f }
            java.lang.String r10 = r3.getDate()     // Catch:{ Exception -> 0x019f }
            r9[r6] = r10     // Catch:{ Exception -> 0x019f }
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception -> 0x019f }
        L_0x0143:
            java.lang.String r8 = "Contribution"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 != 0) goto L_0x015b
            java.lang.String r8 = "Donation"
            java.lang.String r9 = r3.getPayType()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 == 0) goto L_0x016f
        L_0x015b:
            android.content.Context r7 = r11.f60551f     // Catch:{ Exception -> 0x019f }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x019f }
            int r8 = net.one97.paytm.recharge.R.string.last_contribute_on_str     // Catch:{ Exception -> 0x019f }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x019f }
            java.lang.String r10 = r3.getDate()     // Catch:{ Exception -> 0x019f }
            r9[r6] = r10     // Catch:{ Exception -> 0x019f }
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception -> 0x019f }
        L_0x016f:
            java.lang.String r8 = r3.getService()     // Catch:{ Exception -> 0x019f }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x019f }
            java.lang.String r9 = "Cylinder"
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x019f }
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x019f }
            if (r8 == 0) goto L_0x0197
            android.content.Context r7 = r11.f60551f     // Catch:{ Exception -> 0x019f }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x019f }
            int r8 = net.one97.paytm.recharge.R.string.last_booked_on_str     // Catch:{ Exception -> 0x019f }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x019f }
            java.lang.String r10 = r3.getDate()     // Catch:{ Exception -> 0x019f }
            r9[r6] = r10     // Catch:{ Exception -> 0x019f }
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception -> 0x019f }
        L_0x0197:
            android.widget.TextView r8 = r12.f60566h     // Catch:{ Exception -> 0x019f }
            r8.setText(r7)     // Catch:{ Exception -> 0x019f }
            goto L_0x01a7
        L_0x019f:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()     // Catch:{ Exception -> 0x03ae }
            com.paytm.utility.q.d(r7)     // Catch:{ Exception -> 0x03ae }
        L_0x01a7:
            boolean r7 = r3 instanceof net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder     // Catch:{ Exception -> 0x03ae }
            if (r7 == 0) goto L_0x01e2
            android.widget.TextView r7 = r12.f60563e     // Catch:{ Exception -> 0x03ae }
            r8 = r3
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r8 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r8     // Catch:{ Exception -> 0x03ae }
            java.lang.String r8 = r8.getProductLabel()     // Catch:{ Exception -> 0x03ae }
            r7.setText(r8)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r7 = r12.f60566h     // Catch:{ Exception -> 0x03ae }
            r8 = r3
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r8 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r8     // Catch:{ Exception -> 0x03ae }
            java.lang.String r8 = r8.getCreatedDescription()     // Catch:{ Exception -> 0x03ae }
            r7.setText(r8)     // Catch:{ Exception -> 0x03ae }
            r7 = r3
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r7 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r7     // Catch:{ Exception -> 0x03ae }
            java.lang.String r7 = r7.getJourneyStation()     // Catch:{ Exception -> 0x03ae }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x03ae }
            if (r8 != 0) goto L_0x01e2
            android.widget.TextView r8 = r12.f60565g     // Catch:{ Exception -> 0x03ae }
            r8.setText(r7)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r7 = r12.f60565g     // Catch:{ Exception -> 0x03ae }
            r7.setVisibility(r6)     // Catch:{ Exception -> 0x03ae }
        L_0x01e2:
            java.util.Map r7 = r3.getProductAttributes()     // Catch:{ Exception -> 0x03ae }
            java.lang.String r8 = "merchant_loan_account"
            if (r7 == 0) goto L_0x0253
            java.util.Map r9 = r3.getProductAttributes()     // Catch:{ Exception -> 0x03ae }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ Exception -> 0x03ae }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x03ae }
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x03ae }
            if (r9 == 0) goto L_0x0253
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x024a }
            java.lang.String r7 = "dd MMMM yyyy"
            r0.<init>(r7)     // Catch:{ Exception -> 0x024a }
            java.util.TimeZone r7 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x024a }
            r0.setTimeZone(r7)     // Catch:{ Exception -> 0x024a }
            java.util.Date r7 = new java.util.Date     // Catch:{ Exception -> 0x024a }
            java.lang.String r9 = r3.getmCreatedAt()     // Catch:{ Exception -> 0x024a }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x024a }
            long r9 = r9.longValue()     // Catch:{ Exception -> 0x024a }
            r7.<init>(r9)     // Catch:{ Exception -> 0x024a }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x024a }
            android.widget.TextView r7 = r12.f60566h     // Catch:{ Exception -> 0x024a }
            android.content.Context r14 = r14.getContext()     // Catch:{ Exception -> 0x024a }
            int r9 = net.one97.paytm.recharge.R.string.merchant_loan_disbursed_on     // Catch:{ Exception -> 0x024a }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x024a }
            r4[r6] = r0     // Catch:{ Exception -> 0x024a }
            java.lang.String r14 = r14.getString(r9, r4)     // Catch:{ Exception -> 0x024a }
            r7.setText(r14)     // Catch:{ Exception -> 0x024a }
            android.widget.TextView r14 = r12.f60566h     // Catch:{ Exception -> 0x024a }
            r14.setVisibility(r6)     // Catch:{ Exception -> 0x024a }
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r14 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x024a }
            java.lang.String r4 = "MerchantLoanAccounts: getmCreatedAt:"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x024a }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ Exception -> 0x024a }
            r14.debugLog(r0)     // Catch:{ Exception -> 0x024a }
            goto L_0x02fd
        L_0x024a:
            android.widget.TextView r14 = r12.f60566h     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
            goto L_0x02fd
        L_0x0253:
            java.lang.String r14 = r3.getAutomaticScheduledText()     // Catch:{ Exception -> 0x03ae }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x03ae }
            if (r14 != 0) goto L_0x0278
            android.widget.TextView r14 = r12.f60559a     // Catch:{ Exception -> 0x03ae }
            java.lang.String r0 = r3.getAutomaticScheduledText()     // Catch:{ Exception -> 0x03ae }
            r14.setText(r0)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r14 = r12.f60559a     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r6)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r14 = r12.f60566h     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
            goto L_0x02fd
        L_0x0278:
            if (r7 == 0) goto L_0x029d
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03ae }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = "isApplicable"
            java.lang.Object r4 = r7.get(r4)     // Catch:{ Exception -> 0x03ae }
            boolean r14 = r14.equals(r4)     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x029d
            android.widget.TextView r14 = r12.f60559a     // Catch:{ Exception -> 0x03ae }
            int r4 = net.one97.paytm.recharge.R.string.recent_action_setup_automatic     // Catch:{ Exception -> 0x03ae }
            r14.setText(r4)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r14 = r12.f60559a     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r6)     // Catch:{ Exception -> 0x03ae }
            goto L_0x02a4
        L_0x029d:
            android.widget.TextView r14 = r12.f60559a     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
        L_0x02a4:
            android.widget.TextView r14 = r12.f60566h     // Catch:{ Exception -> 0x03ae }
            r14.setVisibility(r6)     // Catch:{ Exception -> 0x03ae }
            net.one97.paytm.common.entity.recharge.CJRBillDetails r14 = r3.getCjrBillDetails()     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x02fd
            java.lang.String r4 = r3.getPayType()     // Catch:{ Exception -> 0x03ae }
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x03ae }
            java.lang.String r6 = "prepaid"
            if (r4 != 0) goto L_0x02c7
            java.lang.String r4 = r3.getPayType()     // Catch:{ Exception -> 0x03ae }
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x03ae }
            if (r4 == 0) goto L_0x02fd
        L_0x02c7:
            android.widget.TextView r4 = r12.f60562d     // Catch:{ Exception -> 0x03ae }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = r3.getPayType()     // Catch:{ Exception -> 0x03ae }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x03ae }
            if (r0 == 0) goto L_0x02e6
            android.widget.TextView r0 = r2.f60566h     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = r3.getPayTypeDisplayLabel()     // Catch:{ Exception -> 0x03ae }
            net.one97.paytm.recharge.common.a.j$a r6 = net.one97.paytm.recharge.common.a.j.a.POSTPAID     // Catch:{ Exception -> 0x03ae }
            r11.a(r0, r4, r14, r6)     // Catch:{ Exception -> 0x03ae }
            goto L_0x02fd
        L_0x02e6:
            java.lang.String r0 = r3.getPayType()     // Catch:{ Exception -> 0x03ae }
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x03ae }
            if (r0 == 0) goto L_0x02fd
            android.widget.TextView r0 = r2.f60566h     // Catch:{ Exception -> 0x03ae }
            java.lang.String r4 = r14.getPlan()     // Catch:{ Exception -> 0x03ae }
            net.one97.paytm.recharge.common.a.j$a r6 = net.one97.paytm.recharge.common.a.j.a.PREPAID     // Catch:{ Exception -> 0x03ae }
            r11.a(r0, r4, r14, r6)     // Catch:{ Exception -> 0x03ae }
        L_0x02fd:
            java.lang.String r14 = r3.getOperator()     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x030e
            android.widget.TextView r14 = r12.l     // Catch:{ Exception -> 0x03ae }
            java.lang.String r0 = r3.getOperator()     // Catch:{ Exception -> 0x03ae }
            r14.setText(r0)     // Catch:{ Exception -> 0x03ae }
        L_0x030e:
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r14 = r11.f60546a     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x0325
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r14 = r11.f60546a     // Catch:{ Exception -> 0x03ae }
            boolean r14 = r14.contains(r3)     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x0325
            android.widget.ImageView r12 = r2.j     // Catch:{ Exception -> 0x03ae }
            int r14 = net.one97.paytm.recharge.R.drawable.ic_clear_tick     // Catch:{ Exception -> 0x03ae }
            r12.setImageResource(r14)     // Catch:{ Exception -> 0x03ae }
            goto L_0x03b6
        L_0x0325:
            java.util.Map r14 = r3.getProductAttributes()     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x034c
            java.util.Map r14 = r3.getProductAttributes()     // Catch:{ Exception -> 0x03ae }
            java.lang.Object r14 = r14.get(r8)     // Catch:{ Exception -> 0x03ae }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x03ae }
            boolean r14 = r8.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x03ae }
            if (r14 == 0) goto L_0x034c
            android.widget.ImageView r14 = r2.j     // Catch:{ Exception -> 0x03ae }
            int r0 = net.one97.paytm.recharge.R.drawable.ic_merchant_account_paytm_loan_logo     // Catch:{ Exception -> 0x03ae }
            r14.setImageResource(r0)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView r12 = r12.l     // Catch:{ Exception -> 0x03ae }
            r12.setVisibility(r5)     // Catch:{ Exception -> 0x03ae }
            goto L_0x03b6
        L_0x034c:
            android.widget.ImageView r14 = r12.j     // Catch:{ Exception -> 0x03ae }
            r0 = 17170445(0x106000d, float:2.461195E-38)
            r14.setImageResource(r0)     // Catch:{ Exception -> 0x03ae }
            android.widget.TextView unused = r12.l     // Catch:{ Exception -> 0x03ae }
            android.widget.RelativeLayout unused = r12.m     // Catch:{ Exception -> 0x03ae }
            android.widget.ImageView r12 = r12.f60567i     // Catch:{ Exception -> 0x03ae }
            android.content.Context r14 = r11.f60551f     // Catch:{ Exception -> 0x03a5 }
            if (r14 != 0) goto L_0x0365
            goto L_0x03b6
        L_0x0365:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r0 = "Operator Image URL :"
            r14.<init>(r0)     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r0 = r3.getOperatorLogoURL()     // Catch:{ Exception -> 0x03a5 }
            r14.append(r0)     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x03a5 }
            com.paytm.utility.q.d(r14)     // Catch:{ Exception -> 0x03a5 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r0 = "operatorImgUrl :: "
            r14.<init>(r0)     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r0 = r3.getOperatorLogoURL()     // Catch:{ Exception -> 0x03a5 }
            r14.append(r0)     // Catch:{ Exception -> 0x03a5 }
            com.paytm.utility.b.j()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r14 = r3.getOperatorLogoURL()     // Catch:{ Exception -> 0x03a5 }
            boolean r14 = android.webkit.URLUtil.isValidUrl(r14)     // Catch:{ Exception -> 0x03a5 }
            if (r14 == 0) goto L_0x03b6
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r0 = r3.getOperatorLogoURL()     // Catch:{ Exception -> 0x03a5 }
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r0)     // Catch:{ Exception -> 0x03a5 }
            r14.a((android.widget.ImageView) r12, (com.squareup.picasso.e) r1)     // Catch:{ Exception -> 0x03a5 }
            goto L_0x03b6
        L_0x03a5:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x03ae }
            com.paytm.utility.q.d(r12)     // Catch:{ Exception -> 0x03ae }
            goto L_0x03b6
        L_0x03ae:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.d(r12)
        L_0x03b6:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.j.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private void a(TextView textView, String str, CJRBillDetails cJRBillDetails, a aVar) {
        String str2;
        if (textView != null) {
            int daysDiff = cJRBillDetails.getDaysDiff();
            if (TextUtils.isEmpty(str)) {
                str = this.f60551f.getResources().getString(R.string.bill_payment);
            }
            if (daysDiff >= 0) {
                try {
                    textView.setVisibility(0);
                    String str3 = "";
                    if (daysDiff == 0) {
                        int i2 = AnonymousClass2.f60558a[aVar.ordinal()];
                        if (i2 == 1) {
                            str3 = this.f60551f.getResources().getString(R.string.bill_reminder_text_2_, new Object[]{str, this.f60551f.getString(R.string.today_re)});
                        } else if (i2 == 2) {
                            str3 = this.f60551f.getResources().getString(R.string.bill_remainder_text_prepaid_2_, new Object[]{String.valueOf(cJRBillDetails.getAmount()), this.f60551f.getString(R.string.today_re)});
                        }
                        textView.setText(a(str3, this.f60551f.getString(R.string.today_re)));
                    } else if (daysDiff == 1) {
                        int i3 = AnonymousClass2.f60558a[aVar.ordinal()];
                        if (i3 == 1) {
                            str3 = this.f60551f.getResources().getString(R.string.bill_reminder_text_2_, new Object[]{str, this.f60551f.getString(R.string.tomorrow)});
                        } else if (i3 == 2) {
                            str3 = this.f60551f.getResources().getString(R.string.bill_remainder_text_prepaid_2_, new Object[]{String.valueOf(cJRBillDetails.getAmount()), this.f60551f.getString(R.string.tomorrow)});
                        }
                        textView.setText(a(str3, this.f60551f.getString(R.string.tomorrow)));
                    } else {
                        int i4 = AnonymousClass2.f60558a[aVar.ordinal()];
                        if (i4 == 1) {
                            str3 = a(cJRBillDetails.getDueDate());
                            str2 = this.f60551f.getResources().getString(R.string.bill_reminder_text_1_, new Object[]{str, str3});
                        } else if (i4 != 2) {
                            str2 = str3;
                        } else {
                            str3 = a(cJRBillDetails.getExpiry());
                            str2 = this.f60551f.getResources().getString(R.string.bill_remainder_text_prepaid_1_, new Object[]{String.valueOf(cJRBillDetails.getAmount()), str3});
                        }
                        textView.setText(a(str2, str3));
                    }
                } catch (Exception e2) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                }
            } else if (daysDiff < 0) {
                int i5 = AnonymousClass2.f60558a[aVar.ordinal()];
                if (i5 == 1) {
                    if (daysDiff == -1000) {
                        Resources resources = this.f60551f.getResources();
                        int i6 = R.string.bill_reminder_text_3_;
                        d dVar = d.f64967a;
                        textView.setText(a(resources.getString(i6, new Object[]{str, d.a(cJRBillDetails.getAmount().toString(), true, 2, true), this.f60551f.getString(R.string.bill_reminder_text_3_soon)}), this.f60551f.getString(R.string.bill_reminder_text_3_soon)));
                    } else {
                        Resources resources2 = this.f60551f.getResources();
                        int i7 = R.string.bill_reminder_text_4_;
                        d dVar2 = d.f64967a;
                        textView.setText(a(resources2.getString(i7, new Object[]{str, d.a(cJRBillDetails.getAmount().toString(), true, 2, true), this.f60551f.getString(R.string.bill_reminder_text_4_overdue)}), this.f60551f.getString(R.string.bill_reminder_text_4_overdue)));
                    }
                    textView.setVisibility(0);
                } else if (i5 == 2) {
                    textView.setText(this.f60551f.getResources().getString(R.string.bill_remainder_text_prepaid_0_, new Object[]{String.valueOf(cJRBillDetails.getAmount())}));
                    textView.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.a.j$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f60558a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.recharge.common.a.j$a[] r0 = net.one97.paytm.recharge.common.a.j.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60558a = r0
                int[] r0 = f60558a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.recharge.common.a.j$a r1 = net.one97.paytm.recharge.common.a.j.a.POSTPAID     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f60558a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.recharge.common.a.j$a r1 = net.one97.paytm.recharge.common.a.j.a.PREPAID     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.j.AnonymousClass2.<clinit>():void");
        }
    }

    private static String a(String str) {
        Date i2 = com.paytm.utility.b.i(str, "yyyy-MM-dd", (String) null);
        int a2 = com.paytm.utility.b.a(i2);
        return com.paytm.utility.v.a(String.valueOf(a2), com.paytm.utility.b.b(a2), " ", com.paytm.utility.b.a(i2, 2));
    }

    private SpannableString a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new SpannableString(str);
        }
        int length = str2.length() + indexOf;
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff4b55")), indexOf, length, 33);
            spannableString.setSpan(w.a(this.f60551f, "Roboto-Medium.ttf"), indexOf, length, 33);
        } catch (Exception unused) {
        }
        return spannableString;
    }

    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60559a;

        /* renamed from: b  reason: collision with root package name */
        public int f60560b = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f60562d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public TextView f60563e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public TextView f60564f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public TextView f60565g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public TextView f60566h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public ImageView f60567i;
        /* access modifiers changed from: private */
        public ImageView j;
        /* access modifiers changed from: private */
        public RelativeLayout k;
        /* access modifiers changed from: private */
        public TextView l;
        /* access modifiers changed from: private */
        public RelativeLayout m;
        /* access modifiers changed from: private */
        public CJRFrequentOrder n;

        public b() {
        }

        public final void onClick(View view) {
            Activity activity;
            if (view.getId() == R.id.txt_automatic_bill_scheduled && this.n != null && j.this.f60549d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_position", this.f60560b);
                Fragment fragment = null;
                if (j.this.f60549d instanceof Fragment) {
                    fragment = (Fragment) j.this.f60549d;
                    activity = null;
                } else {
                    activity = j.this.f60549d instanceof Activity ? (Activity) j.this.f60549d : null;
                }
                az azVar = az.f61525a;
                if (az.c(view.getContext())) {
                    az.g(view.getContext(), this.n.getRechargeNumber());
                    return;
                }
                net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                net.one97.paytm.recharge.common.utils.a.a(fragment, activity, this.n, bundle);
            }
        }

        static /* synthetic */ void b(b bVar, CJRFrequentOrder cJRFrequentOrder) {
            String rechargeAmount = cJRFrequentOrder.getRechargeAmount();
            if (cJRFrequentOrder.getProductAttributes() != null && "merchant_loan_account".equalsIgnoreCase(cJRFrequentOrder.getProductAttributes().get("merchant_loan_account"))) {
                try {
                    String a2 = ba.a(rechargeAmount, true);
                    CJRRechargeUtilities.INSTANCE.debugLog("MerchantLoanAccounts: rechargeAmount:".concat(String.valueOf(a2)));
                    if (TextUtils.isEmpty(a2) || a2.equals("0")) {
                        bVar.f60564f.setText(j.this.f60551f.getString(R.string.pay_now_camel_case));
                    } else {
                        bVar.f60564f.setText(j.this.f60551f.getResources().getString(R.string.recharge_rs, new Object[]{a2}));
                    }
                } catch (Exception unused) {
                    bVar.f60564f.setText(j.this.f60551f.getString(R.string.pay_now_camel_case));
                }
            } else if (!(cJRFrequentOrder instanceof CJRMetroQRFrequentOrder)) {
                if (BaseViewModel.PaymentType.POSTPAID.equalsIgnoreCase(cJRFrequentOrder.getPayType())) {
                    bVar.f60564f.setText(j.this.f60551f.getString(R.string.pay_bill_str));
                } else if (!"prepaid".equalsIgnoreCase(cJRFrequentOrder.getPayType()) || !"Mobile".equalsIgnoreCase(cJRFrequentOrder.getService())) {
                    if (!TextUtils.isEmpty(rechargeAmount) && TextUtils.isDigitsOnly(rechargeAmount)) {
                        rechargeAmount = j.this.f60551f.getResources().getString(R.string.recharge_rs, new Object[]{rechargeAmount});
                    }
                    bVar.f60564f.setText(rechargeAmount);
                } else {
                    bVar.f60564f.setText(j.this.f60551f.getString(R.string.recharge));
                }
                if ("Cylinder Booking".equalsIgnoreCase(cJRFrequentOrder.getService())) {
                    bVar.f60564f.setText(j.this.f60551f.getString(R.string.extra_option_book_again));
                }
            } else if (TextUtils.isEmpty(rechargeAmount) || rechargeAmount.equals("0")) {
                bVar.f60564f.setText("Buy");
            } else {
                bVar.f60564f.setText(j.this.f60551f.getResources().getString(R.string.recharge_rs, new Object[]{rechargeAmount}));
            }
            if (!TextUtils.isEmpty(cJRFrequentOrder.getAutomaticScheduledText())) {
                bVar.f60564f.setText(j.this.f60551f.getString(R.string.pay_now_camel_case));
                return;
            }
            CJRBillDetails cjrBillDetails = cJRFrequentOrder.getCjrBillDetails();
            if (cjrBillDetails == null) {
                return;
            }
            if (BaseViewModel.PaymentType.POSTPAID.equalsIgnoreCase(cJRFrequentOrder.getPayType()) || "prepaid".equalsIgnoreCase(cJRFrequentOrder.getPayType())) {
                bVar.f60564f.setText(j.this.f60551f.getString(R.string.pay_amount, new Object[]{String.valueOf(cjrBillDetails.getAmount())}));
            }
        }
    }

    public final void b(int i2) {
        List<CJRFrequentOrder> list = this.f60546a;
        boolean z = list != null && list.contains(this.f60548c.get(i2));
        List<CJRFrequentOrder> list2 = this.f60548c;
        CJRFrequentOrder cJRFrequentOrder = list2 != null ? list2.get(i2) : null;
        if (this.f60546a == null) {
            this.f60546a = new ArrayList();
        }
        if (!z) {
            this.f60546a.add(cJRFrequentOrder);
        } else {
            this.f60546a.remove(cJRFrequentOrder);
        }
        notifyDataSetChanged();
    }
}
