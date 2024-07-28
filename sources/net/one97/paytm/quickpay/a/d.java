package net.one97.paytm.quickpay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.activity.PaymentReminderCreationActivity;
import net.one97.paytm.quickpay.utilities.SwipeRevealLayout;
import net.one97.paytm.quickpay.utilities.j;

public final class d extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<IJRDataModel> f59864a;

    /* renamed from: b  reason: collision with root package name */
    Context f59865b;

    /* renamed from: c  reason: collision with root package name */
    c f59866c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f59867d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public final j f59868e = new j();

    /* renamed from: f  reason: collision with root package name */
    b f59869f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<String> f59870g;

    /* renamed from: h  reason: collision with root package name */
    private final int f59871h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final int f59872i = 2;

    public interface b {
        void a(IJRDataModel iJRDataModel, int i2, String str);
    }

    public interface c {
        void a(int i2);

        void a(CJRFrequentOrder cJRFrequentOrder);

        void b(CJRFrequentOrder cJRFrequentOrder);

        void c(int i2);

        void d(int i2);

        void e(int i2);
    }

    /* renamed from: net.one97.paytm.quickpay.a.d$d  reason: collision with other inner class name */
    enum C1155d {
        DUE(0),
        DUE_TOMOROW(1),
        OVERDUE(2),
        NONE(3);
        
        int status;

        private C1155d(int i2) {
            this.status = i2;
        }

        public final int getStatus() {
            return this.status;
        }
    }

    public d(Context context, List<IJRDataModel> list, c cVar, b bVar) {
        this.f59865b = context;
        this.f59864a = list;
        this.f59866c = cVar;
        this.f59869f = bVar;
        this.f59868e.f60140d = true;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new e(LayoutInflater.from(this.f59865b).inflate(R.layout.layout_quick_pay_item_row, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.f59865b).inflate(R.layout.quick_pay_add_layout, viewGroup, false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:201:0x08a8 A[Catch:{ Exception -> 0x099b }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x08dc A[Catch:{ Exception -> 0x099b }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x098a A[Catch:{ Exception -> 0x099b }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x098b A[Catch:{ Exception -> 0x099b }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x09b7  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x09b9  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bc  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x09e5  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x09f3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02b0 A[Catch:{ Exception -> 0x0400 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x042c A[Catch:{ Exception -> 0x099b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r24, int r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            boolean r0 = r2 instanceof net.one97.paytm.quickpay.a.d.e
            if (r0 == 0) goto L_0x0a1c
            r3 = r2
            net.one97.paytm.quickpay.a.d$e r3 = (net.one97.paytm.quickpay.a.d.e) r3
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r1.f59864a
            r4 = r25
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            int r4 = r3.getAdapterPosition()
            int r4 = r4 % 10
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this
            java.util.ArrayList<java.lang.String> r5 = r5.f59867d
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r6 = 2
            r7 = 1
            r8 = 0
            boolean r9 = r0 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder     // Catch:{ Exception -> 0x099b }
            java.lang.String r13 = " "
            r5 = 2131960743(0x7f1323a7, float:1.9558163E38)
            java.lang.String r16 = ""
            r10 = 8
            if (r9 == 0) goto L_0x0488
            android.widget.TextView r9 = r3.j     // Catch:{ Exception -> 0x099b }
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r9 = r3.o     // Catch:{ Exception -> 0x099b }
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r9 = r3.p     // Catch:{ Exception -> 0x099b }
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x099b }
            r9 = r0
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r9 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r9     // Catch:{ Exception -> 0x099b }
            if (r9 == 0) goto L_0x0413
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r0 = r9.getFrequentOrderProduct()     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x00b1
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct r0 = r9.getFrequentOrderProduct()     // Catch:{ Exception -> 0x099b }
            boolean r0 = r0.isSchedulable()     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x00b1
            net.one97.paytm.quickpay.a.d r0 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            java.util.ArrayList<java.lang.String> r0 = r0.f59870g     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x00a2
            net.one97.paytm.quickpay.a.d r0 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            java.util.ArrayList<java.lang.String> r0 = r0.f59870g     // Catch:{ Exception -> 0x099b }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x099b }
            if (r0 != 0) goto L_0x00a2
            java.lang.String r0 = r9.getRechargeNumber()     // Catch:{ Exception -> 0x099b }
            boolean r18 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x099b }
            if (r18 != 0) goto L_0x0090
            net.one97.paytm.quickpay.a.d r14 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            java.util.ArrayList<java.lang.String> r14 = r14.f59870g     // Catch:{ Exception -> 0x099b }
            boolean r0 = r14.contains(r0)     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x0090
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x099b }
            android.view.View r14 = r3.itemView     // Catch:{ Exception -> 0x099b }
            android.content.Context r14 = r14.getContext()     // Catch:{ Exception -> 0x099b }
            r10 = 2131962155(0x7f13292b, float:1.9561027E38)
            java.lang.String r10 = r14.getString(r10)     // Catch:{ Exception -> 0x099b }
            r0.setText(r10)     // Catch:{ Exception -> 0x099b }
            goto L_0x00a2
        L_0x0090:
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x099b }
            android.view.View r10 = r3.itemView     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x099b }
            r14 = 2131962157(0x7f13292d, float:1.9561031E38)
            java.lang.String r10 = r10.getString(r14)     // Catch:{ Exception -> 0x099b }
            r0.setText(r10)     // Catch:{ Exception -> 0x099b }
        L_0x00a2:
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x099b }
            r0.setTag(r9)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x099b }
            r0.setOnClickListener(r3)     // Catch:{ Exception -> 0x099b }
        L_0x00b1:
            java.lang.String r10 = r9.getOperatorLogoURL()     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.common.b.e r0 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r14 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r14 = r14.f59865b     // Catch:{ Exception -> 0x099b }
            java.lang.String r0 = r0.a((android.content.Context) r14, (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r9)     // Catch:{ Exception -> 0x099b }
            java.lang.String r0 = net.one97.paytm.quickpay.utilities.g.a(r0)     // Catch:{ Exception -> 0x099b }
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x099b }
            if (r14 != 0) goto L_0x00cd
        L_0x00cb:
            r14 = r0
            goto L_0x00da
        L_0x00cd:
            java.util.Map r0 = r9.getConfiguration()     // Catch:{ Exception -> 0x099b }
            java.lang.String r14 = "recharge_number"
            java.lang.Object r0 = r0.get(r14)     // Catch:{ Exception -> 0x099b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x099b }
            goto L_0x00cb
        L_0x00da:
            java.lang.String r0 = r9.getOperatorLabel()     // Catch:{ Exception -> 0x099b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x00e9
            java.lang.String r0 = r9.getOperator()     // Catch:{ Exception -> 0x099b }
            goto L_0x00ed
        L_0x00e9:
            java.lang.String r0 = r9.getOperatorLabel()     // Catch:{ Exception -> 0x099b }
        L_0x00ed:
            r19 = r0
            net.one97.paytm.quickpay.a.d r0 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r0 = r0.f59865b     // Catch:{ Exception -> 0x099b }
            java.lang.String r20 = r0.getString(r5)     // Catch:{ Exception -> 0x099b }
            java.lang.String r0 = r9.getPaidOn()     // Catch:{ Exception -> 0x0400 }
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0400 }
            java.lang.String r15 = "yyyy-MM-dd'T'HH:mm:ss"
            r12.<init>(r15)     // Catch:{ Exception -> 0x0400 }
            java.util.Date r0 = r12.parse(r0)     // Catch:{ Exception -> 0x0400 }
            java.util.Calendar r12 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0400 }
            r12.setTime(r0)     // Catch:{ Exception -> 0x0400 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r0 = r12.getDisplayName(r6, r7, r0)     // Catch:{ Exception -> 0x0400 }
            int r15 = r12.get(r7)     // Catch:{ Exception -> 0x0400 }
            r6 = 5
            int r6 = r12.get(r6)     // Catch:{ Exception -> 0x0400 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0400 }
            r12.<init>()     // Catch:{ Exception -> 0x0400 }
            r12.append(r6)     // Catch:{ Exception -> 0x0400 }
            r12.append(r13)     // Catch:{ Exception -> 0x0400 }
            r12.append(r0)     // Catch:{ Exception -> 0x0400 }
            r12.append(r13)     // Catch:{ Exception -> 0x0400 }
            r12.append(r15)     // Catch:{ Exception -> 0x0400 }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r12 = 2131956954(0x7f1314da, float:1.9550478E38)
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0400 }
            r13[r8] = r0     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = r6.getString(r12, r13)     // Catch:{ Exception -> 0x0400 }
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "postpaid"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 != 0) goto L_0x0186
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "Fee payment"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 != 0) goto L_0x0186
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "New Registration"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 != 0) goto L_0x0186
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "Insurance"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 != 0) goto L_0x0186
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "Loan"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 == 0) goto L_0x0199
        L_0x0186:
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r12 = 2131956952(0x7f1314d8, float:1.9550474E38)
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0400 }
            r13[r8] = r0     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = r6.getString(r12, r13)     // Catch:{ Exception -> 0x0400 }
        L_0x0199:
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r13 = "Donation"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 == 0) goto L_0x01b8
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r12 = 2131956941(0x7f1314cd, float:1.9550452E38)
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0400 }
            r13[r8] = r0     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = r6.getString(r12, r13)     // Catch:{ Exception -> 0x0400 }
        L_0x01b8:
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getCjrBillDetails()     // Catch:{ Exception -> 0x0400 }
            if (r0 == 0) goto L_0x03e7
            java.lang.String r12 = "postpaid"
            java.lang.String r13 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0400 }
            if (r12 == 0) goto L_0x0234
            java.lang.String r6 = r0.getDueDate()     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r12 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r12 = r12.f59865b     // Catch:{ Exception -> 0x0400 }
            r13 = 2131952472(0x7f130358, float:1.9541388E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r13 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r13 = r13.f59865b     // Catch:{ Exception -> 0x0400 }
            r15 = 2131959361(0x7f131e41, float:1.955536E38)
            java.lang.String r13 = r13.getString(r15)     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = com.paytm.utility.b.g(r6, r12, r13)     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r12 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r12 = r12.f59865b     // Catch:{ Exception -> 0x0400 }
            r13 = 2131954406(0x7f130ae6, float:1.954531E38)
            java.lang.Object[] r15 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0400 }
            r15[r8] = r6     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = r12.getString(r13, r15)     // Catch:{ Exception -> 0x0400 }
            java.lang.Double r12 = r0.getAmount()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0400 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0230 }
            r13.<init>()     // Catch:{ Exception -> 0x0230 }
            net.one97.paytm.quickpay.a.d r15 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0230 }
            android.content.Context r15 = r15.f59865b     // Catch:{ Exception -> 0x0230 }
            java.lang.String r15 = r15.getString(r5)     // Catch:{ Exception -> 0x0230 }
            r13.append(r15)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r15 = " ₹ "
            r13.append(r15)     // Catch:{ Exception -> 0x0230 }
            net.one97.paytm.common.b.e r15 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x0230 }
            java.lang.Double r11 = r0.getAmount()     // Catch:{ Exception -> 0x0230 }
            java.lang.String r11 = r15.a((java.lang.Double) r11)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r11 = com.paytm.utility.b.L((java.lang.String) r11)     // Catch:{ Exception -> 0x0230 }
            r13.append(r11)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r11 = r13.toString()     // Catch:{ Exception -> 0x0230 }
            r20 = r11
            r11 = r12
            goto L_0x02a6
        L_0x0230:
            r11 = r12
        L_0x0231:
            r20 = 0
            goto L_0x02a6
        L_0x0234:
            java.lang.String r11 = "prepaid"
            java.lang.String r12 = r9.getPayType()     // Catch:{ Exception -> 0x0400 }
            boolean r11 = r11.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0400 }
            if (r11 == 0) goto L_0x02a4
            java.lang.String r6 = r0.getExpiry()     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r11 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r11 = r11.f59865b     // Catch:{ Exception -> 0x0400 }
            r12 = 2131952472(0x7f130358, float:1.9541388E38)
            java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r12 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r12 = r12.f59865b     // Catch:{ Exception -> 0x0400 }
            r13 = 2131959361(0x7f131e41, float:1.955536E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x0400 }
            com.paytm.utility.b.g(r6, r11, r12)     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.common.b.e r6 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r11 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r11 = r11.f59865b     // Catch:{ Exception -> 0x0400 }
            java.lang.String r12 = r9.getPayLabel()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r6 = r6.a((android.content.Context) r11, (java.lang.String) r12, (net.one97.paytm.common.entity.recharge.CJRBillDetails) r0)     // Catch:{ Exception -> 0x0400 }
            java.lang.Double r11 = r0.getAmount()     // Catch:{ Exception -> 0x0400 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0400 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0231 }
            r12.<init>()     // Catch:{ Exception -> 0x0231 }
            net.one97.paytm.quickpay.a.d r13 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0231 }
            android.content.Context r13 = r13.f59865b     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = r13.getString(r5)     // Catch:{ Exception -> 0x0231 }
            r12.append(r13)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = " ₹ "
            r12.append(r13)     // Catch:{ Exception -> 0x0231 }
            net.one97.paytm.common.b.e r13 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x0231 }
            java.lang.Double r15 = r0.getAmount()     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = r13.a((java.lang.Double) r15)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = com.paytm.utility.b.L((java.lang.String) r13)     // Catch:{ Exception -> 0x0231 }
            r12.append(r13)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0231 }
            r20 = r12
            goto L_0x02a6
        L_0x02a4:
            r11 = r16
        L_0x02a6:
            int r0 = r0.getDaysDiff()     // Catch:{ Exception -> 0x0400 }
            boolean r12 = r9.isFirstLoad()     // Catch:{ Exception -> 0x0400 }
            if (r12 == 0) goto L_0x0408
            android.widget.RelativeLayout r12 = r3.f59880b     // Catch:{ Exception -> 0x0400 }
            r12.setVisibility(r8)     // Catch:{ Exception -> 0x0400 }
            r9.setMarkAsPaidShown(r7)     // Catch:{ Exception -> 0x0400 }
            android.widget.RelativeLayout r12 = r3.f59880b     // Catch:{ Exception -> 0x0400 }
            r12.setTag(r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.RelativeLayout r11 = r3.f59880b     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d$e$1 r12 = new net.one97.paytm.quickpay.a.d$e$1     // Catch:{ Exception -> 0x0400 }
            r12.<init>(r9)     // Catch:{ Exception -> 0x0400 }
            r11.setOnClickListener(r12)     // Catch:{ Exception -> 0x0400 }
            if (r0 != 0) goto L_0x0311
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131954408(0x7f130ae8, float:1.9545314E38)
            java.lang.String r6 = r6.getString(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setText(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131233716(0x7f080bb4, float:1.8083577E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setBackground(r6)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            r6 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ Exception -> 0x0400 }
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            r11 = 0
            a((android.widget.TextView) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.LinearLayout r0 = r3.q     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            goto L_0x0408
        L_0x0311:
            if (r0 != r7) goto L_0x035b
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131954409(0x7f130ae9, float:1.9545316E38)
            java.lang.String r6 = r6.getString(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setText(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131233716(0x7f080bb4, float:1.8083577E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setBackground(r6)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            r6 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ Exception -> 0x0400 }
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            r11 = 0
            a((android.widget.TextView) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.LinearLayout r0 = r3.q     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            goto L_0x0408
        L_0x035b:
            if (r0 >= 0) goto L_0x03a4
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131960167(0x7f132167, float:1.9556995E38)
            java.lang.String r6 = r6.getString(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setText(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r6 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r6 = r6.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0400 }
            r11 = 2131233717(0x7f080bb5, float:1.808358E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setBackground(r6)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            r6 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ Exception -> 0x0400 }
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            r11 = 0
            a((android.widget.TextView) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.LinearLayout r0 = r3.q     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0400 }
            goto L_0x0408
        L_0x03a4:
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            r11 = 8
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r11 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r11 = r11.f59865b     // Catch:{ Exception -> 0x0400 }
            r12 = 2131099980(0x7f06014c, float:1.7812329E38)
            int r11 = androidx.core.content.b.c(r11, r12)     // Catch:{ Exception -> 0x0400 }
            r0.setTextColor(r11)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            r11 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r11)     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r0.findViewById(r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x0400 }
            net.one97.paytm.quickpay.a.d r11 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x0400 }
            android.content.Context r11 = r11.f59865b     // Catch:{ Exception -> 0x0400 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0400 }
            r12 = 2131233938(0x7f080c92, float:1.8084028E38)
            android.graphics.drawable.Drawable r11 = r11.getDrawable(r12)     // Catch:{ Exception -> 0x0400 }
            r0.setImageDrawable(r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            a((android.widget.TextView) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0400 }
            goto L_0x0408
        L_0x03e7:
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x0400 }
            r11 = 8
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x0400 }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x0400 }
            r12 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r12)     // Catch:{ Exception -> 0x0400 }
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x0400 }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x0400 }
            a((android.widget.TextView) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0400 }
            goto L_0x0408
        L_0x0400:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x099b }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x099b }
        L_0x0408:
            android.widget.LinearLayout r0 = r3.r     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$e$2 r6 = new net.one97.paytm.quickpay.a.d$e$2     // Catch:{ Exception -> 0x099b }
            r6.<init>(r9)     // Catch:{ Exception -> 0x099b }
            r0.setOnClickListener(r6)     // Catch:{ Exception -> 0x099b }
            goto L_0x041a
        L_0x0413:
            r10 = r16
            r14 = r10
            r19 = r14
            r20 = r19
        L_0x041a:
            android.widget.TextView r0 = r3.f59886h     // Catch:{ Exception -> 0x099b }
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59887i     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            boolean r0 = r9.isFirstLoad()     // Catch:{ Exception -> 0x099b }
            if (r0 != 0) goto L_0x0476
            boolean r0 = r9.isMarkAsPaidShown()     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x0441
            android.widget.RelativeLayout r0 = r3.f59880b     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.l     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            a(r8, r0, r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0476
        L_0x0441:
            android.widget.RelativeLayout r0 = r3.f59880b     // Catch:{ Exception -> 0x099b }
            r6 = 0
            r0.setOnClickListener(r6)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r0 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r0 = r0.f59865b     // Catch:{ Exception -> 0x099b }
            java.lang.String r20 = r0.getString(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.l     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            a(r7, r0, r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r6 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            r6 = 0
            a((android.widget.TextView) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x099b }
            android.widget.LinearLayout r0 = r3.q     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
        L_0x0476:
            r0 = r20
            android.widget.TextView r5 = r3.f59885g     // Catch:{ Exception -> 0x099b }
            a((android.widget.TextView) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.k     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            r0 = r19
            goto L_0x08a2
        L_0x0488:
            boolean r6 = r0 instanceof net.one97.paytm.common.entity.quick_pay.StandingInstructionList     // Catch:{ Exception -> 0x099b }
            if (r6 == 0) goto L_0x089e
            net.one97.paytm.common.entity.quick_pay.StandingInstructionList r0 = (net.one97.paytm.common.entity.quick_pay.StandingInstructionList) r0     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r6 = r3.j     // Catch:{ Exception -> 0x099b }
            r6.setVisibility(r8)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r6 = r3.m     // Catch:{ Exception -> 0x099b }
            r9 = 8
            r6.setVisibility(r9)     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x074e
            java.lang.String r6 = r0.getReminderDisplayName()     // Catch:{ Exception -> 0x099b }
            r0.setReminderDisplayName(r6)     // Catch:{ Exception -> 0x099b }
            java.lang.String r6 = r0.getReminderDisplayName()     // Catch:{ Exception -> 0x099b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x099b }
            if (r6 != 0) goto L_0x04b2
            java.lang.String r6 = r0.getReminderDisplayName()     // Catch:{ Exception -> 0x099b }
            goto L_0x04c3
        L_0x04b2:
            net.one97.paytm.common.entity.quick_pay.SupportingData r6 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            if (r6 == 0) goto L_0x04c1
            net.one97.paytm.common.entity.quick_pay.SupportingData r6 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r6 = r6.getTagName()     // Catch:{ Exception -> 0x099b }
            goto L_0x04c3
        L_0x04c1:
            r6 = r16
        L_0x04c3:
            java.lang.String r6 = net.one97.paytm.quickpay.utilities.g.a(r6)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.common.entity.quick_pay.SupportingData r9 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.getTagName()     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r0.getReminderDisplayName()     // Catch:{ Exception -> 0x099b }
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x099b }
            if (r9 != 0) goto L_0x04e3
            net.one97.paytm.common.entity.quick_pay.SupportingData r9 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.getTagName()     // Catch:{ Exception -> 0x099b }
            goto L_0x0578
        L_0x04e3:
            net.one97.paytm.common.entity.quick_pay.SupportingData r9 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.getBeneficiaryAccountNumber()     // Catch:{ Exception -> 0x099b }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x099b }
            if (r9 != 0) goto L_0x0514
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            r9.<init>()     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            r11 = 2131951807(0x7f1300bf, float:1.9540039E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.common.entity.quick_pay.SupportingData r10 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r10.getBeneficiaryAccountNumber()     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x099b }
            goto L_0x0578
        L_0x0514:
            net.one97.paytm.common.entity.quick_pay.SupportingData r9 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.getBeneficiaryUpiAddress()     // Catch:{ Exception -> 0x099b }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x099b }
            if (r9 != 0) goto L_0x0545
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            r9.<init>()     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            r11 = 2131952681(0x7f130429, float:1.9541812E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.common.entity.quick_pay.SupportingData r10 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r10.getBeneficiaryUpiAddress()     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x099b }
            goto L_0x0578
        L_0x0545:
            net.one97.paytm.common.entity.quick_pay.SupportingData r9 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.getBeneficiaryMobileNumber()     // Catch:{ Exception -> 0x099b }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x099b }
            if (r9 != 0) goto L_0x0576
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            r9.<init>()     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            r11 = 2131957929(0x7f1318a9, float:1.9552456E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.common.entity.quick_pay.SupportingData r10 = r0.getSupportingData()     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r10.getBeneficiaryMobileNumber()     // Catch:{ Exception -> 0x099b }
            r9.append(r10)     // Catch:{ Exception -> 0x099b }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x099b }
            goto L_0x0578
        L_0x0576:
            r9 = r16
        L_0x0578:
            java.lang.String r10 = r0.getAmount()     // Catch:{ Exception -> 0x099b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x099b }
            if (r10 != 0) goto L_0x0595
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = "Pay ₹"
            r5.<init>(r10)     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r0.getAmount()     // Catch:{ Exception -> 0x099b }
            r5.append(r10)     // Catch:{ Exception -> 0x099b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x099b }
            goto L_0x059d
        L_0x0595:
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            java.lang.String r5 = r10.getString(r5)     // Catch:{ Exception -> 0x099b }
        L_0x059d:
            java.lang.String r10 = r0.getNextReminderDate()     // Catch:{ Exception -> 0x099b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x099b }
            if (r10 != 0) goto L_0x0630
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            java.lang.String r11 = r0.getNextReminderDate()     // Catch:{ Exception -> 0x099b }
            java.lang.String r12 = r0.getReminderFrequency()     // Catch:{ Exception -> 0x099b }
            int r10 = r10.a((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x099b }
            if (r10 != 0) goto L_0x05ca
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x099b }
            r11 = 2131954408(0x7f130ae8, float:1.9545314E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$d r11 = net.one97.paytm.quickpay.a.d.C1155d.DUE     // Catch:{ Exception -> 0x099b }
        L_0x05c8:
            r14 = r11
            goto L_0x0634
        L_0x05ca:
            if (r10 != r7) goto L_0x05de
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x099b }
            r11 = 2131954409(0x7f130ae9, float:1.9545316E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$d r11 = net.one97.paytm.quickpay.a.d.C1155d.DUE_TOMOROW     // Catch:{ Exception -> 0x099b }
            goto L_0x05c8
        L_0x05de:
            r11 = -1
            if (r10 != r11) goto L_0x05f3
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x099b }
            r11 = 2131960167(0x7f132167, float:1.9556995E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$d r11 = net.one97.paytm.quickpay.a.d.C1155d.OVERDUE     // Catch:{ Exception -> 0x099b }
            goto L_0x05c8
        L_0x05f3:
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x060f }
            java.lang.String r11 = "yyyy-MM-dd"
            r10.<init>(r11)     // Catch:{ Exception -> 0x060f }
            java.lang.String r11 = r0.getNextReminderDate()     // Catch:{ Exception -> 0x060f }
            java.util.Date r10 = r10.parse(r11)     // Catch:{ Exception -> 0x060f }
            java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x060f }
            java.lang.String r12 = "dd MMM yyyy"
            r11.<init>(r12)     // Catch:{ Exception -> 0x060f }
            java.lang.String r14 = r11.format(r10)     // Catch:{ Exception -> 0x060f }
            goto L_0x0610
        L_0x060f:
            r14 = 0
        L_0x0610:
            net.one97.paytm.quickpay.a.d r10 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r10 = r10.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x099b }
            r11 = 2131962445(0x7f132a4d, float:1.9561615E38)
            java.lang.Object[] r12 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x099b }
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x099b }
            if (r15 == 0) goto L_0x0627
            java.lang.String r14 = r0.getNextReminderDate()     // Catch:{ Exception -> 0x099b }
        L_0x0627:
            r12[r8] = r14     // Catch:{ Exception -> 0x099b }
            java.lang.String r10 = r10.getString(r11, r12)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$d r11 = net.one97.paytm.quickpay.a.d.C1155d.NONE     // Catch:{ Exception -> 0x099b }
            goto L_0x05c8
        L_0x0630:
            net.one97.paytm.quickpay.a.d$d r10 = net.one97.paytm.quickpay.a.d.C1155d.NONE     // Catch:{ Exception -> 0x099b }
            r14 = r10
            r10 = 0
        L_0x0634:
            net.one97.paytm.quickpay.a.d r11 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r12 = r3.f59886h     // Catch:{ Exception -> 0x099b }
            java.lang.String r15 = r0.getAmount()     // Catch:{ Exception -> 0x099b }
            java.lang.String r17 = r0.getLastPaid()     // Catch:{ Exception -> 0x099b }
            boolean r19 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x099b }
            if (r19 != 0) goto L_0x0684
            boolean r19 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x099b }
            if (r19 != 0) goto L_0x0684
            r12.setVisibility(r8)     // Catch:{ Exception -> 0x099b }
            android.content.Context r7 = r11.f59865b     // Catch:{ Exception -> 0x099b }
            r21 = r6
            r8 = 2
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x099b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            r8.<init>()     // Catch:{ Exception -> 0x099b }
            android.content.Context r11 = r11.f59865b     // Catch:{ Exception -> 0x099b }
            r22 = r9
            r9 = 2131962665(0x7f132b29, float:1.9562062E38)
            java.lang.String r9 = r11.getString(r9)     // Catch:{ Exception -> 0x099b }
            r8.append(r9)     // Catch:{ Exception -> 0x099b }
            r8.append(r13)     // Catch:{ Exception -> 0x099b }
            r8.append(r15)     // Catch:{ Exception -> 0x099b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x099b }
            r9 = 0
            r6[r9] = r8     // Catch:{ Exception -> 0x099b }
            r8 = 1
            r6[r8] = r17     // Catch:{ Exception -> 0x099b }
            r8 = 2131956950(0x7f1314d6, float:1.955047E38)
            java.lang.String r6 = r7.getString(r8, r6)     // Catch:{ Exception -> 0x099b }
            r12.setText(r6)     // Catch:{ Exception -> 0x099b }
            goto L_0x06af
        L_0x0684:
            r21 = r6
            r22 = r9
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x099b }
            if (r6 == 0) goto L_0x06aa
            boolean r6 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x099b }
            if (r6 != 0) goto L_0x06aa
            r6 = 0
            r12.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            android.content.Context r7 = r11.f59865b     // Catch:{ Exception -> 0x099b }
            r8 = 2131956951(0x7f1314d7, float:1.9550472E38)
            r9 = 1
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x099b }
            r11[r6] = r17     // Catch:{ Exception -> 0x099b }
            java.lang.String r6 = r7.getString(r8, r11)     // Catch:{ Exception -> 0x099b }
            r12.setText(r6)     // Catch:{ Exception -> 0x099b }
            goto L_0x06af
        L_0x06aa:
            r6 = 8
            r12.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
        L_0x06af:
            android.widget.TextView r6 = r3.f59885g     // Catch:{ Exception -> 0x099b }
            a((android.widget.TextView) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x099b }
            boolean r6 = r0.isMarkedAsPaid()     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r7 = r3.k     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r8 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r8 = r8.f59865b     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r9 = r3.f59885g     // Catch:{ Exception -> 0x099b }
            boolean r11 = r0.getEnablePaymentsReminder()     // Catch:{ Exception -> 0x099b }
            android.widget.LinearLayout r12 = r3.r     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r13 = r3.p     // Catch:{ Exception -> 0x099b }
            if (r6 == 0) goto L_0x0704
            if (r11 == 0) goto L_0x0704
            if (r9 == 0) goto L_0x06e6
            r5 = 2131099980(0x7f06014c, float:1.7812329E38)
            int r6 = androidx.core.content.b.c(r8, r5)     // Catch:{ Exception -> 0x099b }
            r9.setTextColor(r6)     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r8.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131962022(0x7f1328a6, float:1.9560757E38)
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x099b }
            r9.setText(r5)     // Catch:{ Exception -> 0x099b }
        L_0x06e6:
            if (r12 == 0) goto L_0x06f6
            android.content.res.Resources r5 = r8.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233922(0x7f080c82, float:1.8083995E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            r12.setBackground(r5)     // Catch:{ Exception -> 0x099b }
        L_0x06f6:
            if (r7 == 0) goto L_0x06fd
            r5 = 8
            r7.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
        L_0x06fd:
            if (r13 == 0) goto L_0x0761
            r5 = 0
            r13.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0761
        L_0x0704:
            if (r7 == 0) goto L_0x0727
            if (r11 == 0) goto L_0x070a
            r6 = 0
            goto L_0x070c
        L_0x070a:
            r6 = 8
        L_0x070c:
            r7.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r6 = r8.getResources()     // Catch:{ Exception -> 0x099b }
            r11 = 2131962016(0x7f1328a0, float:1.9560745E38)
            java.lang.String r6 = r6.getString(r11)     // Catch:{ Exception -> 0x099b }
            r7.setText(r6)     // Catch:{ Exception -> 0x099b }
            r6 = 2131100063(0x7f06019f, float:1.7812497E38)
            int r6 = androidx.core.content.b.c(r8, r6)     // Catch:{ Exception -> 0x099b }
            r7.setTextColor(r6)     // Catch:{ Exception -> 0x099b }
        L_0x0727:
            if (r12 == 0) goto L_0x0737
            android.content.res.Resources r6 = r8.getResources()     // Catch:{ Exception -> 0x099b }
            r7 = 2131233920(0x7f080c80, float:1.8083991E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)     // Catch:{ Exception -> 0x099b }
            r12.setBackground(r6)     // Catch:{ Exception -> 0x099b }
        L_0x0737:
            if (r9 == 0) goto L_0x0746
            r6 = 2131099940(0x7f060124, float:1.7812247E38)
            int r6 = androidx.core.content.b.c(r8, r6)     // Catch:{ Exception -> 0x099b }
            r9.setTextColor(r6)     // Catch:{ Exception -> 0x099b }
            r9.setText(r5)     // Catch:{ Exception -> 0x099b }
        L_0x0746:
            if (r13 == 0) goto L_0x0761
            r5 = 8
            r13.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0761
        L_0x074e:
            android.widget.TextView r5 = r3.k     // Catch:{ Exception -> 0x099b }
            r6 = 8
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r5 = r3.f59886h     // Catch:{ Exception -> 0x099b }
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
            r10 = r16
            r21 = r10
            r22 = r21
            r14 = 0
        L_0x0761:
            android.widget.TextView r5 = r3.f59885g     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d$e$3 r6 = new net.one97.paytm.quickpay.a.d$e$3     // Catch:{ Exception -> 0x099b }
            r6.<init>(r0)     // Catch:{ Exception -> 0x099b }
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x099b }
            boolean r0 = r0.isMarkedAsPaid()     // Catch:{ Exception -> 0x099b }
            if (r0 != 0) goto L_0x087e
            int[] r0 = net.one97.paytm.quickpay.a.d.AnonymousClass4.f59876a     // Catch:{ Exception -> 0x099b }
            int r5 = r14.ordinal()     // Catch:{ Exception -> 0x099b }
            r0 = r0[r5]     // Catch:{ Exception -> 0x099b }
            r5 = 1
            if (r0 == r5) goto L_0x0850
            r5 = 2
            if (r0 == r5) goto L_0x07e5
            r5 = 3
            if (r0 == r5) goto L_0x07b6
            r5 = 4
            if (r0 == r5) goto L_0x0787
            goto L_0x0897
        L_0x0787:
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r0.setText(r10)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233716(0x7f080bb4, float:1.8083577E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            r0.setBackground(r5)     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            r5 = 0
            a((android.widget.TextView) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0897
        L_0x07b6:
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r0.setText(r10)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233717(0x7f080bb5, float:1.808358E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            r0.setBackground(r5)     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            r5 = 0
            a((android.widget.TextView) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0897
        L_0x07e5:
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            r6 = 2131099980(0x7f06014c, float:1.7812329E38)
            int r5 = androidx.core.content.b.c(r5, r6)     // Catch:{ Exception -> 0x099b }
            r0.setTextColor(r5)     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 0
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x099b }
            if (r0 == 0) goto L_0x0821
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r6 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            goto L_0x0830
        L_0x0821:
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x099b }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x099b }
        L_0x0830:
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233938(0x7f080c92, float:1.8084028E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            r0.setImageDrawable(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            a((android.widget.TextView) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x099b }
            goto L_0x0897
        L_0x0850:
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r0.setText(r10)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233716(0x7f080bb4, float:1.8083577E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            r0.setBackground(r5)     // Catch:{ Exception -> 0x099b }
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            r5 = 0
            a((android.widget.TextView) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0897
        L_0x087e:
            android.view.View r0 = r3.itemView     // Catch:{ Exception -> 0x099b }
            r5 = 2131365821(0x7f0a0fbd, float:1.8351518E38)
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.f59884f     // Catch:{ Exception -> 0x099b }
            r6 = 0
            a((android.widget.TextView) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r0 = r3.j     // Catch:{ Exception -> 0x099b }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
        L_0x0897:
            r10 = r16
            r14 = r21
            r0 = r22
            goto L_0x08a2
        L_0x089e:
            r0 = r16
            r10 = r0
            r14 = r10
        L_0x08a2:
            boolean r5 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x099b }
            if (r5 != 0) goto L_0x08dc
            android.widget.ImageView r4 = r3.n     // Catch:{ Exception -> 0x099b }
            r5 = 0
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            android.widget.RelativeLayout r4 = r3.f59879a     // Catch:{ Exception -> 0x099b }
            r5 = 8
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r4 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r4 = r4.f59865b     // Catch:{ Exception -> 0x099b }
            com.paytm.utility.b.b$a$a r4 = com.paytm.utility.b.b.a(r4)     // Catch:{ Exception -> 0x099b }
            r4.f43753a = r10     // Catch:{ Exception -> 0x099b }
            r5 = 1
            r4.n = r5     // Catch:{ Exception -> 0x099b }
            net.one97.paytm.quickpay.a.d r5 = net.one97.paytm.quickpay.a.d.this     // Catch:{ Exception -> 0x099b }
            android.content.Context r5 = r5.f59865b     // Catch:{ Exception -> 0x099b }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x099b }
            r6 = 2131233863(0x7f080c47, float:1.8083876E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)     // Catch:{ Exception -> 0x099b }
            com.paytm.utility.b.b$a$a r4 = r4.a((java.lang.Object) r5)     // Catch:{ Exception -> 0x099b }
            android.widget.ImageView r5 = r3.n     // Catch:{ Exception -> 0x099b }
            r4.a((android.widget.ImageView) r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x0990
        L_0x08dc:
            boolean r5 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x099b }
            if (r5 != 0) goto L_0x08ea
            boolean r5 = android.text.TextUtils.isDigitsOnly(r14)     // Catch:{ Exception -> 0x099b }
            if (r5 != 0) goto L_0x08ea
            r5 = r14
            goto L_0x08eb
        L_0x08ea:
            r5 = r0
        L_0x08eb:
            boolean r6 = android.text.TextUtils.isDigitsOnly(r5)     // Catch:{ Exception -> 0x099b }
            if (r6 != 0) goto L_0x096a
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x099b }
            if (r6 != 0) goto L_0x096a
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x099b }
            java.lang.String r6 = "\\s+"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ Exception -> 0x099b }
            int r6 = r5.length     // Catch:{ Exception -> 0x099b }
            r7 = 1
            if (r6 != r7) goto L_0x0919
            r7 = 0
            r8 = r5[r7]     // Catch:{ Exception -> 0x099b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x099b }
            if (r8 != 0) goto L_0x0919
            r5 = r5[r7]     // Catch:{ Exception -> 0x099b }
            char r5 = r5.charAt(r7)     // Catch:{ Exception -> 0x099b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x099b }
            goto L_0x096c
        L_0x0919:
            r7 = 2
            if (r6 < r7) goto L_0x096a
            r6 = 0
            r7 = r5[r6]     // Catch:{ Exception -> 0x099b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x099b }
            if (r7 != 0) goto L_0x0930
            r7 = r5[r6]     // Catch:{ Exception -> 0x099b }
            char r7 = r7.charAt(r6)     // Catch:{ Exception -> 0x099b }
            java.lang.String r6 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x099b }
            goto L_0x0932
        L_0x0930:
            r6 = r16
        L_0x0932:
            r7 = 1
            r8 = r5[r7]     // Catch:{ Exception -> 0x099b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x099b }
            if (r8 != 0) goto L_0x0968
            java.lang.String r8 = "[^A-Za-z0-9]"
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)     // Catch:{ Exception -> 0x099b }
            r9 = r5[r7]     // Catch:{ Exception -> 0x099b }
            java.util.regex.Matcher r8 = r8.matcher(r9)     // Catch:{ Exception -> 0x099b }
            boolean r8 = r8.find()     // Catch:{ Exception -> 0x099b }
            if (r8 != 0) goto L_0x0968
            r5 = r5[r7]     // Catch:{ Exception -> 0x099b }
            r7 = 0
            char r5 = r5.charAt(r7)     // Catch:{ Exception -> 0x099b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x099b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x099b }
            r7.<init>()     // Catch:{ Exception -> 0x099b }
            r7.append(r6)     // Catch:{ Exception -> 0x099b }
            r7.append(r5)     // Catch:{ Exception -> 0x099b }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x099b }
            goto L_0x096c
        L_0x0968:
            r5 = r6
            goto L_0x096c
        L_0x096a:
            r5 = r16
        L_0x096c:
            android.widget.ImageView r6 = r3.n     // Catch:{ Exception -> 0x099b }
            r7 = 8
            r6.setVisibility(r7)     // Catch:{ Exception -> 0x099b }
            android.widget.RelativeLayout r6 = r3.f59879a     // Catch:{ Exception -> 0x099b }
            r7 = 0
            r6.setVisibility(r7)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r6 = r3.f59881c     // Catch:{ Exception -> 0x099b }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x099b }
            r6.setBackgroundColor(r4)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r4 = r3.f59881c     // Catch:{ Exception -> 0x099b }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x099b }
            if (r6 != 0) goto L_0x098b
            goto L_0x098d
        L_0x098b:
            r5 = r16
        L_0x098d:
            r4.setText(r5)     // Catch:{ Exception -> 0x099b }
        L_0x0990:
            android.widget.TextView r4 = r3.f59882d     // Catch:{ Exception -> 0x099b }
            a((android.widget.TextView) r4, (java.lang.String) r14)     // Catch:{ Exception -> 0x099b }
            android.widget.TextView r4 = r3.f59883e     // Catch:{ Exception -> 0x099b }
            a((android.widget.TextView) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x099b }
            goto L_0x099c
        L_0x099b:
        L_0x099c:
            net.one97.paytm.quickpay.utilities.j r0 = r1.f59868e
            net.one97.paytm.quickpay.utilities.SwipeRevealLayout r3 = r3.v
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r24.getAdapterPosition()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r5 = r3.f60104c
            r6 = 2
            if (r5 >= r6) goto L_0x09b9
            r5 = 1
            goto L_0x09ba
        L_0x09b9:
            r5 = 0
        L_0x09ba:
            if (r5 == 0) goto L_0x09bf
            r3.requestLayout()
        L_0x09bf:
            java.util.Map<java.lang.String, net.one97.paytm.quickpay.utilities.SwipeRevealLayout> r5 = r0.f60138b
            java.util.Collection r5 = r5.values()
            r5.remove(r3)
            java.util.Map<java.lang.String, net.one97.paytm.quickpay.utilities.SwipeRevealLayout> r5 = r0.f60138b
            r5.put(r4, r3)
            r5 = 1
            r3.f60102a = r5
            androidx.customview.a.c r5 = r3.f60103b
            r5.e()
            net.one97.paytm.quickpay.utilities.j$1 r5 = new net.one97.paytm.quickpay.utilities.j$1
            r5.<init>(r4, r3)
            r3.setDragStateChangeListener(r5)
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r0.f60137a
            boolean r5 = r5.containsKey(r4)
            if (r5 != 0) goto L_0x09f3
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r0.f60137a
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5.put(r4, r7)
            r3.b((boolean) r6)
            goto L_0x0a10
        L_0x09f3:
            r6 = 0
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r0.f60137a
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 == 0) goto L_0x0a0d
            r7 = 1
            if (r5 == r7) goto L_0x0a0d
            r7 = 4
            if (r5 != r7) goto L_0x0a09
            goto L_0x0a0d
        L_0x0a09:
            r3.a((boolean) r6)
            goto L_0x0a10
        L_0x0a0d:
            r3.b((boolean) r6)
        L_0x0a10:
            java.util.Set<java.lang.String> r0 = r0.f60139c
            boolean r0 = r0.contains(r4)
            r3.setLockDrag(r0)
            r2.setIsRecyclable(r6)
        L_0x0a1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.a.d.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        return this.f59864a.get(i2) != null ? 1 : 2;
    }

    public final int getItemCount() {
        List<IJRDataModel> list = this.f59864a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class e extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f59879a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f59880b;

        /* renamed from: c  reason: collision with root package name */
        TextView f59881c;

        /* renamed from: d  reason: collision with root package name */
        TextView f59882d;

        /* renamed from: e  reason: collision with root package name */
        TextView f59883e;

        /* renamed from: f  reason: collision with root package name */
        TextView f59884f;

        /* renamed from: g  reason: collision with root package name */
        TextView f59885g;

        /* renamed from: h  reason: collision with root package name */
        TextView f59886h;

        /* renamed from: i  reason: collision with root package name */
        TextView f59887i;
        TextView j;
        TextView k;
        TextView l;
        TextView m;
        ImageView n;
        ImageView o;
        ImageView p;
        LinearLayout q;
        LinearLayout r;
        private RelativeLayout t;
        private TextView u;
        /* access modifiers changed from: private */
        public SwipeRevealLayout v;

        public e(View view) {
            super(view);
            this.f59879a = (RelativeLayout) view.findViewById(R.id.qp_initial_name_rl);
            this.f59881c = (TextView) view.findViewById(R.id.qp_initial_name_tv);
            this.f59882d = (TextView) view.findViewById(R.id.tvPrimaryIdentifier);
            this.f59883e = (TextView) view.findViewById(R.id.tvSecondaryIdentifier);
            this.f59884f = (TextView) view.findViewById(R.id.tvDueDate);
            this.f59885g = (TextView) view.findViewById(R.id.tvAmount);
            this.n = (ImageView) view.findViewById(R.id.p2p_profile_iv);
            this.f59886h = (TextView) view.findViewById(R.id.last_paid_txt);
            this.v = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.t = (RelativeLayout) view.findViewById(R.id.rl_qp_container);
            this.f59887i = (TextView) view.findViewById(R.id.more_qp_tv);
            this.u = (TextView) view.findViewById(R.id.delete_tv);
            this.t.setOnClickListener(this);
            view.findViewById(R.id.delete_tv).setOnClickListener(this);
            view.findViewById(R.id.more_qp_tv).setOnClickListener(this);
            this.j = (TextView) view.findViewById(R.id.qp_reminder_tv);
            this.k = (TextView) view.findViewById(R.id.mark_as_paid_txt);
            this.k.setOnClickListener(this);
            this.f59880b = (RelativeLayout) view.findViewById(R.id.mark_as_paid_lyt);
            this.l = (TextView) view.findViewById(R.id.mark_as_paid_view);
            this.q = (LinearLayout) view.findViewById(R.id.ll_due_date);
            this.o = (ImageView) view.findViewById(R.id.paid_icon);
            this.r = (LinearLayout) view.findViewById(R.id.ll_pay_container);
            this.p = (ImageView) view.findViewById(R.id.img_qp_tick);
            this.m = (TextView) view.findViewById(R.id.recent_automatic_tv);
        }

        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.rl_qp_container) {
                d.this.f59866c.a(getAdapterPosition());
            } else if (id == R.id.more_qp_tv) {
                d.this.f59866c.c(getAdapterPosition());
            } else if (id == R.id.delete_tv) {
                j jVar = d.this.f59868e;
                StringBuilder sb = new StringBuilder();
                sb.append(getAdapterPosition());
                jVar.a(sb.toString());
                d.this.f59866c.d(getAdapterPosition());
            } else if (id == R.id.mark_as_paid_txt) {
                d.this.f59866c.e(getAdapterPosition());
            } else if (id != R.id.recent_automatic_tv) {
            } else {
                if (this.itemView.getContext().getString(R.string.recent_action_setup_automatic).equalsIgnoreCase(this.m.getText().toString())) {
                    if (view.getTag() != null) {
                        d.this.f59866c.a((CJRFrequentOrder) view.getTag());
                    }
                } else if (this.itemView.getContext().getString(R.string.recent_action_manage_automatic).equalsIgnoreCase(this.m.getText().toString()) && view.getTag() != null) {
                    d.this.f59866c.b((CJRFrequentOrder) view.getTag());
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.quickpay.a.d$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f59876a = new int[C1155d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.quickpay.a.d$d[] r0 = net.one97.paytm.quickpay.a.d.C1155d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f59876a = r0
                int[] r0 = f59876a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.quickpay.a.d$d r1 = net.one97.paytm.quickpay.a.d.C1155d.DUE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f59876a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.quickpay.a.d$d r1 = net.one97.paytm.quickpay.a.d.C1155d.NONE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f59876a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.quickpay.a.d$d r1 = net.one97.paytm.quickpay.a.d.C1155d.OVERDUE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f59876a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.quickpay.a.d$d r1 = net.one97.paytm.quickpay.a.d.C1155d.DUE_TOMOROW     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.a.d.AnonymousClass4.<clinit>():void");
        }
    }

    public class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private CardView f59878b;

        public a(View view) {
            super(view);
            this.f59878b = (CardView) view.findViewById(R.id.addNew);
            this.f59878b.setOnClickListener(this);
        }

        public final void onClick(View view) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    ((Activity) d.this.f59865b).runOnUiThread(new Runnable() {
                        public final void run() {
                            if (com.paytm.utility.a.p(d.this.f59865b)) {
                                Intent intent = new Intent(d.this.f59865b, PaymentReminderCreationActivity.class);
                                intent.setFlags(536870912);
                                d.this.f59865b.startActivity(intent);
                                return;
                            }
                            d dVar = d.this;
                            String name = PaymentReminderCreationActivity.class.getName();
                            String string = d.this.f59865b.getString(R.string.hello_sign_in);
                            Intent e2 = net.one97.paytm.common.b.d.a().e(dVar.f59865b);
                            if (name != null) {
                                e2.putExtra("resultant activity", name);
                                com.paytm.utility.a.c();
                            }
                            e2.putExtra("sign_in_sign_up_with_step_2", true);
                            if (!TextUtils.isEmpty(string)) {
                                e2.putExtra("sign_in_title", string);
                            }
                            if (!TextUtils.isEmpty((CharSequence) null)) {
                                e2.putExtra("sign_up_title", (String) null);
                            }
                            e2.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                            ((Activity) dVar.f59865b).startActivityForResult(e2, 111);
                        }
                    });
                }
            }, 400);
        }
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
            return;
        }
        textView.setVisibility(8);
    }

    static String a(boolean z, String str, String str2, String str3, String str4, String str5) {
        if (z) {
            String str6 = "paytmmp://cash_wallet?featuretype=money_transfer&account=" + str + "&pn=" + str2 + "&ifsc=" + str3;
            if (!TextUtils.isEmpty(str4)) {
                str6 = str6 + "&bank_name=" + str4;
            }
            if (TextUtils.isEmpty(str5)) {
                return str6;
            }
            return str6 + "&am=" + str5;
        }
        String str7 = "paytmmp://cash_wallet?featuretype=money_transfer&pa=" + str + "&pn=" + str2;
        if (TextUtils.isEmpty(str5)) {
            return str7;
        }
        return str7 + "&am=" + str5;
    }

    private int a(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.setTime(parse);
            Calendar instance2 = Calendar.getInstance(TimeZone.getDefault());
            instance2.get(1);
            if (this.f59865b.getString(R.string.monthly).equalsIgnoreCase(str2)) {
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) + 1 && instance.get(5) == instance2.get(5)) {
                    return 0;
                }
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2)) {
                    return instance.get(5) - instance2.get(5);
                }
                return -1;
            } else if (!this.f59865b.getString(R.string.weekly).equalsIgnoreCase(str2) || instance.get(7) != instance2.get(7)) {
                return -1;
            } else {
                return 0;
            }
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            return -1;
        }
    }

    public final void a(List<IJRDataModel> list) {
        this.f59864a = list;
        notifyDataSetChanged();
    }

    private static void a(boolean z, TextView textView, Context context) {
        if (z) {
            textView.setText(context.getResources().getString(R.string.qp_paid));
            textView.setTextColor(androidx.core.content.b.c(context, R.color.color_21c17a));
            return;
        }
        textView.setText(context.getResources().getString(R.string.qp_mark_as_paid));
        textView.setTextColor(androidx.core.content.b.c(context, R.color.color_8f969c));
    }

    public final void a(ArrayList<String> arrayList) {
        this.f59870g = arrayList;
        notifyDataSetChanged();
    }
}
