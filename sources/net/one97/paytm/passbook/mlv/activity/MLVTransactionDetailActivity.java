package net.one97.paytm.passbook.mlv.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.paytm.utility.s;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo;
import net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.mlv.d.a;
import net.one97.paytm.passbook.utility.q;

public final class MLVTransactionDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private MLVUserCardDetail f58036a;

    /* renamed from: b  reason: collision with root package name */
    private UserMLVTemplateDetail f58037b;

    /* renamed from: c  reason: collision with root package name */
    private MLVAccountTransactionInfo f58038c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f58039d;

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58044a = new e();

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public final View a(int i2) {
        if (this.f58039d == null) {
            this.f58039d = new HashMap();
        }
        View view = (View) this.f58039d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f58039d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        r15 = r15.getChangeAmount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0547, code lost:
        if (r15.equals("REDEEM") != false) goto L_0x0549;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0549, code lost:
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.status_tv);
        kotlin.g.b.k.a((java.lang.Object) r15, "status_tv");
        r1 = net.one97.paytm.passbook.R.string.loyality_cashback_paid;
        r9 = new java.lang.Object[1];
        r13 = net.one97.paytm.passbook.mlv.d.a.f58098a;
        r13 = r14.f58037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x055c, code lost:
        if (r13 == null) goto L_0x0563;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x055e, code lost:
        r13 = r13.getMlvCardTemplate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0563, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0564, code lost:
        r9[0] = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r13);
        r15.setText(getString(r1, r9));
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.title1_tv);
        kotlin.g.b.k.a((java.lang.Object) r15, "title1_tv");
        r15.setText(getString(net.one97.paytm.passbook.R.string.to));
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.title2_tv);
        kotlin.g.b.k.a((java.lang.Object) r15, "title2_tv");
        r15.setText(getText(net.one97.paytm.passbook.R.string.from_your));
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt1);
        kotlin.g.b.k.a((java.lang.Object) r15, "txt1");
        r1 = net.one97.paytm.passbook.mlv.d.a.f58098a;
        r1 = r14.f58037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x05ac, code lost:
        if (r1 == null) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x05ae, code lost:
        r1 = r1.getMlvCardTemplate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x05b3, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x05b4, code lost:
        r15.setText(net.one97.paytm.passbook.mlv.d.a.C1111a.a(r1));
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt4);
        kotlin.g.b.k.a((java.lang.Object) r15, "txt4");
        r1 = net.one97.paytm.passbook.R.string.loyality_cashback_balance_template;
        r5 = new java.lang.Object[1];
        r6 = net.one97.paytm.passbook.mlv.d.a.f58098a;
        r6 = r14.f58037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x05d0, code lost:
        if (r6 == null) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x05d2, code lost:
        r6 = r6.getMlvCardTemplate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x05d7, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x05d8, code lost:
        r5[0] = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r6);
        r15.setText(getString(r1, r5));
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt5);
        kotlin.g.b.k.a((java.lang.Object) r15, "txt5");
        r1 = net.one97.paytm.passbook.R.string.loyalty_cash_id;
        r5 = new java.lang.Object[1];
        r6 = r14.f58036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x05f8, code lost:
        if (r6 == null) goto L_0x05ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x05fa, code lost:
        r6 = r6.getCardNo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x05ff, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0600, code lost:
        r5[0] = r6;
        r15.setText(getString(r1, r5));
        r15 = (net.one97.paytm.passbook.customview.CircularImageView) a(net.one97.paytm.passbook.R.id.imv1);
        kotlin.g.b.k.a((java.lang.Object) r15, "imv1");
        r15 = r15;
        r1 = r14.f58037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x061a, code lost:
        if (r1 == null) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x061c, code lost:
        r1 = r1.getMlvCardTemplate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0620, code lost:
        if (r1 == null) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0622, code lost:
        r1 = r1.getMerchantLogoInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0626, code lost:
        if (r1 == null) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0628, code lost:
        r0 = r1.getMerchantImageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x062c, code lost:
        a(r15, r0);
        r15 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt5);
        kotlin.g.b.k.a((java.lang.Object) r15, "txt5");
        r15.setVisibility(8);
        r15 = r14.f58037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x063f, code lost:
        if (r15 == null) goto L_0x067d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0641, code lost:
        r15 = r15.getMlvCardTemplate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0645, code lost:
        if (r15 == null) goto L_0x067d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0647, code lost:
        r15 = r15.getDescription();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x064b, code lost:
        if (r15 == null) goto L_0x067d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x064d, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0653, code lost:
        if (r15.length() <= 0) goto L_0x0656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0656, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0657, code lost:
        if (r2 == false) goto L_0x067b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0659, code lost:
        r0 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt2);
        kotlin.g.b.k.a((java.lang.Object) r0, "txt2");
        r0.setVisibility(8);
        r0 = (android.widget.TextView) a(net.one97.paytm.passbook.R.id.txt2);
        kotlin.g.b.k.a((java.lang.Object) r0, "txt2");
        r0.setText(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x067b, code lost:
        r15 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x067d, code lost:
        r15 = (net.one97.paytm.passbook.customview.CircularImageView) a(net.one97.paytm.passbook.R.id.imv2);
        kotlin.g.b.k.a((java.lang.Object) r15, "imv2");
        r15.setVisibility(8);
        r15 = (android.widget.ImageView) a(net.one97.paytm.passbook.R.id.imv2_cash);
        kotlin.g.b.k.a((java.lang.Object) r15, "imv2_cash");
        r15.setVisibility(0);
        ((android.widget.ImageView) a(net.one97.paytm.passbook.R.id.imv2_cash)).setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_loyalty);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02eb, code lost:
        if (r15.equals("PAY") != false) goto L_0x0549;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            super.onCreate(r15)
            int r15 = net.one97.paytm.passbook.R.layout.activity_mlv_transaction_detail
            r14.setContentView((int) r15)
            android.content.Intent r15 = r14.getIntent()
            java.lang.String r0 = "mglUserCardDetail"
            boolean r15 = r15.hasExtra(r0)
            if (r15 == 0) goto L_0x0020
            android.content.Intent r15 = r14.getIntent()
            java.io.Serializable r15 = r15.getSerializableExtra(r0)
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r15 = (net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail) r15
            r14.f58036a = r15
        L_0x0020:
            android.content.Intent r15 = r14.getIntent()
            java.lang.String r0 = "userTemplateDetail"
            boolean r15 = r15.hasExtra(r0)
            if (r15 == 0) goto L_0x0039
            android.content.Intent r15 = r14.getIntent()
            java.io.Serializable r15 = r15.getSerializableExtra(r0)
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r15 = (net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail) r15
            r14.f58037b = r15
        L_0x0039:
            android.content.Intent r15 = r14.getIntent()
            java.lang.String r0 = "data"
            boolean r15 = r15.hasExtra(r0)
            if (r15 == 0) goto L_0x0051
            android.content.Intent r15 = r14.getIntent()
            java.io.Serializable r15 = r15.getSerializableExtra(r0)
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r15 = (net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo) r15
            r14.f58038c = r15
        L_0x0051:
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r15 = r14.f58038c
            r0 = 0
            if (r15 == 0) goto L_0x0061
            net.one97.paytm.passbook.beans.mgv.MGVAmount r15 = r15.getChangeAmount()
            if (r15 == 0) goto L_0x0061
            java.lang.String r15 = r15.getAmount()
            goto L_0x0062
        L_0x0061:
            r15 = r0
        L_0x0062:
            java.lang.String r15 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r15)
            int r1 = net.one97.paytm.passbook.R.string.rs_balance
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r15
            java.lang.String r15 = r14.getString(r1, r3)
            int r1 = net.one97.paytm.passbook.R.id.amount_tv
            android.view.View r1 = r14.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = "amount_tv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r1.setText(r15)
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r15 = r14.f58038c     // Catch:{ ParseException -> 0x00b0 }
            if (r15 == 0) goto L_0x008e
            java.lang.String r15 = r15.getAccountingTimestamp()     // Catch:{ ParseException -> 0x00b0 }
            if (r15 != 0) goto L_0x0090
        L_0x008e:
            java.lang.String r15 = ""
        L_0x0090:
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            long r5 = net.one97.paytm.passbook.mapping.a.j(r15, r1)     // Catch:{ ParseException -> 0x00b0 }
            java.lang.String r15 = "dd MMM yyyy, hh:mm a"
            java.lang.String r15 = net.one97.paytm.passbook.mapping.a.a(r5, r15)     // Catch:{ ParseException -> 0x00b0 }
            int r1 = net.one97.paytm.passbook.R.id.date_time_tv     // Catch:{ ParseException -> 0x00b0 }
            android.view.View r1 = r14.a((int) r1)     // Catch:{ ParseException -> 0x00b0 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ ParseException -> 0x00b0 }
            java.lang.String r3 = "date_time_tv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ ParseException -> 0x00b0 }
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ ParseException -> 0x00b0 }
            r1.setText(r15)     // Catch:{ ParseException -> 0x00b0 }
            goto L_0x00b1
        L_0x00b0:
        L_0x00b1:
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r15 = r14.f58038c
            if (r15 == 0) goto L_0x00ba
            java.lang.String r15 = r15.getTransactionType()
            goto L_0x00bb
        L_0x00ba:
            r15 = r0
        L_0x00bb:
            if (r15 == 0) goto L_0x06aa
            int r1 = net.one97.paytm.passbook.R.id.transactionIdTv
            android.view.View r1 = r14.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = "transactionIdTv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            int r3 = net.one97.paytm.passbook.R.string.gv_wallet_tran_id
            java.lang.Object[] r5 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r6 = r14.f58038c
            if (r6 == 0) goto L_0x00d8
            java.lang.String r6 = r6.getBizOrderId()
            goto L_0x00d9
        L_0x00d8:
            r6 = r0
        L_0x00d9:
            r5[r4] = r6
            java.lang.String r3 = r14.getString(r3, r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            int r1 = r15.hashCode()
            java.lang.String r3 = "imv1"
            java.lang.String r5 = "txt1"
            java.lang.String r6 = "title1_tv"
            java.lang.String r7 = "imv2"
            java.lang.String r8 = "txt4"
            java.lang.String r9 = "status_tv"
            java.lang.String r10 = "title2_tv"
            java.lang.String r11 = "txt5"
            r12 = 8
            switch(r1) {
                case -1881559652: goto L_0x0541;
                case -1881484424: goto L_0x0418;
                case -1880997073: goto L_0x02ef;
                case 78984: goto L_0x02e5;
                case 1817829058: goto L_0x020b;
                case 2059137311: goto L_0x0105;
                default: goto L_0x0103;
            }
        L_0x0103:
            goto L_0x06a8
        L_0x0105:
            java.lang.String r1 = "EXPIRE"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
            int r15 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_expired
            java.lang.Object[] r3 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r5 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r5 = r14.f58037b
            if (r5 == 0) goto L_0x0127
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r5 = r5.getMlvCardTemplate()
            goto L_0x0128
        L_0x0127:
            r5 = r0
        L_0x0128:
            java.lang.String r5 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r5)
            r3[r4] = r5
            java.lang.String r1 = r14.getString(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.reciever_one_layout
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            java.lang.String r1 = "reciever_one_layout"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cash_details
            java.lang.CharSequence r1 = r14.getText(r1)
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            int r1 = net.one97.paytm.passbook.R.string.loyalty_cash_id
            java.lang.Object[] r3 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r5 = r14.f58036a
            if (r5 == 0) goto L_0x0172
            java.lang.String r0 = r5.getCardNo()
        L_0x0172:
            r3[r4] = r0
            java.lang.String r0 = r14.getString(r1, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r15 = r14.f58036a     // Catch:{ ParseException -> 0x06a8 }
            if (r15 == 0) goto L_0x0187
            java.lang.String r15 = r15.getCreateTime()     // Catch:{ ParseException -> 0x06a8 }
            if (r15 != 0) goto L_0x0189
        L_0x0187:
            java.lang.String r15 = ""
        L_0x0189:
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            long r0 = net.one97.paytm.passbook.mapping.a.j(r15, r0)     // Catch:{ ParseException -> 0x06a8 }
            java.lang.String r15 = "dd MMM yyyy, hh:mm a"
            java.lang.String r15 = net.one97.paytm.passbook.mapping.a.a(r0, r15)     // Catch:{ ParseException -> 0x06a8 }
            int r0 = net.one97.paytm.passbook.R.id.date_time_tv     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r0 = r14.a((int) r0)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ ParseException -> 0x06a8 }
            java.lang.String r1 = "date_time_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ ParseException -> 0x06a8 }
            r1 = r15
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ ParseException -> 0x06a8 }
            r0.setText(r1)     // Catch:{ ParseException -> 0x06a8 }
            int r0 = net.one97.paytm.passbook.R.id.txt5     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r0 = r14.a((int) r0)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ ParseException -> 0x06a8 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)     // Catch:{ ParseException -> 0x06a8 }
            int r1 = net.one97.paytm.passbook.R.string.earned_text     // Catch:{ ParseException -> 0x06a8 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ ParseException -> 0x06a8 }
            r2[r4] = r15     // Catch:{ ParseException -> 0x06a8 }
            java.lang.String r15 = r14.getString(r1, r2)     // Catch:{ ParseException -> 0x06a8 }
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ ParseException -> 0x06a8 }
            r0.setText(r15)     // Catch:{ ParseException -> 0x06a8 }
            int r15 = net.one97.paytm.passbook.R.id.imv2     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r15 = r14.a((int) r15)     // Catch:{ ParseException -> 0x06a8 }
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15     // Catch:{ ParseException -> 0x06a8 }
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)     // Catch:{ ParseException -> 0x06a8 }
            r15.setVisibility(r12)     // Catch:{ ParseException -> 0x06a8 }
            int r15 = net.one97.paytm.passbook.R.id.imv2_cash     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r15 = r14.a((int) r15)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.ImageView r15 = (android.widget.ImageView) r15     // Catch:{ ParseException -> 0x06a8 }
            java.lang.String r0 = "imv2_cash"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)     // Catch:{ ParseException -> 0x06a8 }
            r15.setVisibility(r4)     // Catch:{ ParseException -> 0x06a8 }
            int r15 = net.one97.paytm.passbook.R.id.imv2_cash     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r15 = r14.a((int) r15)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.ImageView r15 = (android.widget.ImageView) r15     // Catch:{ ParseException -> 0x06a8 }
            int r0 = net.one97.paytm.passbook.R.drawable.pass_ic_loyalty     // Catch:{ ParseException -> 0x06a8 }
            r15.setImageResource(r0)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.RelativeLayout$LayoutParams r15 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ ParseException -> 0x06a8 }
            r0 = -2
            r1 = -2
            r15.<init>(r0, r1)     // Catch:{ ParseException -> 0x06a8 }
            r0 = 40
            r15.topMargin = r0     // Catch:{ ParseException -> 0x06a8 }
            int r0 = net.one97.paytm.passbook.R.id.title2_tv     // Catch:{ ParseException -> 0x06a8 }
            android.view.View r0 = r14.a((int) r0)     // Catch:{ ParseException -> 0x06a8 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ ParseException -> 0x06a8 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)     // Catch:{ ParseException -> 0x06a8 }
            android.view.ViewGroup$LayoutParams r15 = (android.view.ViewGroup.LayoutParams) r15     // Catch:{ ParseException -> 0x06a8 }
            r0.setLayoutParams(r15)     // Catch:{ ParseException -> 0x06a8 }
            goto L_0x06a8
        L_0x020b:
            java.lang.String r1 = "REVERSE"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
            int r15 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_reversed
            java.lang.Object[] r3 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r5 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r5 = r14.f58037b
            if (r5 == 0) goto L_0x022d
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r5 = r5.getMlvCardTemplate()
            goto L_0x022e
        L_0x022d:
            r5 = r0
        L_0x022e:
            java.lang.String r5 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r5)
            r3[r4] = r5
            java.lang.String r1 = r14.getString(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            int r1 = net.one97.paytm.passbook.R.string.from_your
            java.lang.String r1 = r14.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.reciever_one_layout
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            java.lang.String r1 = "reciever_one_layout"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_balance_template
            java.lang.Object[] r3 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r5 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r5 = r14.f58037b
            if (r5 == 0) goto L_0x027d
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r5 = r5.getMlvCardTemplate()
            goto L_0x027e
        L_0x027d:
            r5 = r0
        L_0x027e:
            java.lang.String r5 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r5)
            r3[r4] = r5
            java.lang.String r1 = r14.getString(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r1 = net.one97.paytm.passbook.R.string.pass_ml_order_id
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r3 = r14.f58036a
            if (r3 == 0) goto L_0x02a5
            java.lang.String r3 = r3.getCardNo()
            goto L_0x02a6
        L_0x02a5:
            r3 = r0
        L_0x02a6:
            r2[r4] = r3
            java.lang.String r1 = r14.getString(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x02e0
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            if (r1 == 0) goto L_0x02e0
            net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r1 = r1.getMerchantLogoInfo()
            if (r1 == 0) goto L_0x02e0
            java.lang.String r0 = r1.getMerchantImageName()
        L_0x02e0:
            a(r15, r0)
            goto L_0x06a8
        L_0x02e5:
            java.lang.String r1 = "PAY"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
            goto L_0x0549
        L_0x02ef:
            java.lang.String r1 = "REWARD"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
            int r15 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_earned_unformatted
            java.lang.Object[] r9 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r13 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r13 = r14.f58037b
            if (r13 == 0) goto L_0x0311
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r13 = r13.getMlvCardTemplate()
            goto L_0x0312
        L_0x0311:
            r13 = r0
        L_0x0312:
            java.lang.String r13 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r13)
            r9[r4] = r13
            java.lang.String r1 = r14.getString(r1, r9)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title1_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            int r1 = net.one97.paytm.passbook.R.string.in_your
            java.lang.String r1 = r14.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            int r1 = net.one97.paytm.passbook.R.string.from
            java.lang.CharSequence r1 = r14.getText(r1)
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            net.one97.paytm.passbook.mlv.d.a$a r1 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x0361
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            goto L_0x0362
        L_0x0361:
            r1 = r0
        L_0x0362:
            java.lang.String r1 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt1
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cash_balance_template
            java.lang.Object[] r5 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r6 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r6 = r14.f58037b
            if (r6 == 0) goto L_0x0385
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r6 = r6.getMlvCardTemplate()
            goto L_0x0386
        L_0x0385:
            r6 = r0
        L_0x0386:
            java.lang.String r6 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r6)
            r5[r4] = r6
            java.lang.String r1 = r14.getString(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r1 = net.one97.paytm.passbook.R.string.pass_ml_order_id
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r5 = r14.f58036a
            if (r5 == 0) goto L_0x03ad
            java.lang.String r5 = r5.getCardNo()
            goto L_0x03ae
        L_0x03ad:
            r5 = r0
        L_0x03ae:
            r2[r4] = r5
            java.lang.String r1 = r14.getString(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x03e8
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            if (r1 == 0) goto L_0x03e8
            net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r1 = r1.getMerchantLogoInfo()
            if (r1 == 0) goto L_0x03e8
            java.lang.String r0 = r1.getMerchantImageName()
        L_0x03e8:
            a(r15, r0)
            int r15 = net.one97.paytm.passbook.R.id.imv1
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv1_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r0 = "imv1_cash"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r15.setVisibility(r4)
            int r15 = net.one97.paytm.passbook.R.id.imv1_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            int r0 = net.one97.paytm.passbook.R.drawable.pass_ic_loyalty
            r15.setImageResource(r0)
            goto L_0x06a8
        L_0x0418:
            java.lang.String r1 = "REFUND"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
            int r15 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_refunded
            java.lang.Object[] r9 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r13 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r13 = r14.f58037b
            if (r13 == 0) goto L_0x043a
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r13 = r13.getMlvCardTemplate()
            goto L_0x043b
        L_0x043a:
            r13 = r0
        L_0x043b:
            java.lang.String r13 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r13)
            r9[r4] = r13
            java.lang.String r1 = r14.getString(r1, r9)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title1_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            int r1 = net.one97.paytm.passbook.R.string.in_your
            java.lang.String r1 = r14.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            int r1 = net.one97.paytm.passbook.R.string.from
            java.lang.CharSequence r1 = r14.getText(r1)
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            net.one97.paytm.passbook.mlv.d.a$a r1 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x048a
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            goto L_0x048b
        L_0x048a:
            r1 = r0
        L_0x048b:
            java.lang.String r1 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt1
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cash_balance_template
            java.lang.Object[] r5 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r6 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r6 = r14.f58037b
            if (r6 == 0) goto L_0x04ae
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r6 = r6.getMlvCardTemplate()
            goto L_0x04af
        L_0x04ae:
            r6 = r0
        L_0x04af:
            java.lang.String r6 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r6)
            r5[r4] = r6
            java.lang.String r1 = r14.getString(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r1 = net.one97.paytm.passbook.R.string.pass_ml_order_id
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r5 = r14.f58036a
            if (r5 == 0) goto L_0x04d6
            java.lang.String r5 = r5.getCardNo()
            goto L_0x04d7
        L_0x04d6:
            r5 = r0
        L_0x04d7:
            r2[r4] = r5
            java.lang.String r1 = r14.getString(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x0511
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            if (r1 == 0) goto L_0x0511
            net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r1 = r1.getMerchantLogoInfo()
            if (r1 == 0) goto L_0x0511
            java.lang.String r0 = r1.getMerchantImageName()
        L_0x0511:
            a(r15, r0)
            int r15 = net.one97.paytm.passbook.R.id.imv1
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv1_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r0 = "imv1_cash"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r15.setVisibility(r4)
            int r15 = net.one97.paytm.passbook.R.id.imv1_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            int r0 = net.one97.paytm.passbook.R.drawable.pass_ic_loyalty
            r15.setImageResource(r0)
            goto L_0x06a8
        L_0x0541:
            java.lang.String r1 = "REDEEM"
            boolean r15 = r15.equals(r1)
            if (r15 == 0) goto L_0x06a8
        L_0x0549:
            int r15 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_paid
            java.lang.Object[] r9 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r13 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r13 = r14.f58037b
            if (r13 == 0) goto L_0x0563
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r13 = r13.getMlvCardTemplate()
            goto L_0x0564
        L_0x0563:
            r13 = r0
        L_0x0564:
            java.lang.String r13 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r13)
            r9[r4] = r13
            java.lang.String r1 = r14.getString(r1, r9)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title1_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            int r1 = net.one97.paytm.passbook.R.string.to
            java.lang.String r1 = r14.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            int r1 = net.one97.paytm.passbook.R.string.from_your
            java.lang.CharSequence r1 = r14.getText(r1)
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt1
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            net.one97.paytm.passbook.mlv.d.a$a r1 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x05b3
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            goto L_0x05b4
        L_0x05b3:
            r1 = r0
        L_0x05b4:
            java.lang.String r1 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            int r1 = net.one97.paytm.passbook.R.string.loyality_cashback_balance_template
            java.lang.Object[] r5 = new java.lang.Object[r2]
            net.one97.paytm.passbook.mlv.d.a$a r6 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r6 = r14.f58037b
            if (r6 == 0) goto L_0x05d7
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r6 = r6.getMlvCardTemplate()
            goto L_0x05d8
        L_0x05d7:
            r6 = r0
        L_0x05d8:
            java.lang.String r6 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r6)
            r5[r4] = r6
            java.lang.String r1 = r14.getString(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r1 = net.one97.paytm.passbook.R.string.loyalty_cash_id
            java.lang.Object[] r5 = new java.lang.Object[r2]
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r6 = r14.f58036a
            if (r6 == 0) goto L_0x05ff
            java.lang.String r6 = r6.getCardNo()
            goto L_0x0600
        L_0x05ff:
            r6 = r0
        L_0x0600:
            r5[r4] = r6
            java.lang.String r1 = r14.getString(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15.setText(r1)
            int r15 = net.one97.paytm.passbook.R.id.imv1
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r1 = r14.f58037b
            if (r1 == 0) goto L_0x062c
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r1 = r1.getMlvCardTemplate()
            if (r1 == 0) goto L_0x062c
            net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r1 = r1.getMerchantLogoInfo()
            if (r1 == 0) goto L_0x062c
            java.lang.String r0 = r1.getMerchantImageName()
        L_0x062c:
            a(r15, r0)
            int r15 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r12)
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r15 = r14.f58037b
            if (r15 == 0) goto L_0x067d
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r15 = r15.getMlvCardTemplate()
            if (r15 == 0) goto L_0x067d
            java.lang.String r15 = r15.getDescription()
            if (r15 == 0) goto L_0x067d
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r0 = r15.length()
            if (r0 <= 0) goto L_0x0656
            goto L_0x0657
        L_0x0656:
            r2 = 0
        L_0x0657:
            if (r2 == 0) goto L_0x067b
            int r0 = net.one97.paytm.passbook.R.id.txt2
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "txt2"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r12)
            int r0 = net.one97.paytm.passbook.R.id.txt2
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "txt2"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setText(r15)
        L_0x067b:
            kotlin.x r15 = kotlin.x.f47997a
        L_0x067d:
            int r15 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r15 = r14.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r12)
            int r15 = net.one97.paytm.passbook.R.id.imv2_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r0 = "imv2_cash"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r15.setVisibility(r4)
            int r15 = net.one97.paytm.passbook.R.id.imv2_cash
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            int r0 = net.one97.paytm.passbook.R.drawable.pass_ic_loyalty
            r15.setImageResource(r0)
        L_0x06a8:
            kotlin.x r15 = kotlin.x.f47997a
        L_0x06aa:
            int r15 = net.one97.paytm.passbook.R.id.needHelpRl
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$a r0 = new net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$a
            r0.<init>(r14)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            int r15 = net.one97.paytm.passbook.R.id.shareImv
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$b r0 = new net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$b
            r0.<init>(r14)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            int r15 = net.one97.paytm.passbook.R.id.back_arrow_imv
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$c r0 = new net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity$c
            r0.<init>(r14)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity.onCreate(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MLVTransactionDetailActivity f58040a;

        a(MLVTransactionDetailActivity mLVTransactionDetailActivity) {
            this.f58040a = mLVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a("paytmmp://contactus", (Activity) this.f58040a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MLVTransactionDetailActivity f58041a;

        b(MLVTransactionDetailActivity mLVTransactionDetailActivity) {
            this.f58041a = mLVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            MLVTransactionDetailActivity.b(this.f58041a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MLVTransactionDetailActivity f58042a;

        c(MLVTransactionDetailActivity mLVTransactionDetailActivity) {
            this.f58042a = mLVTransactionDetailActivity;
        }

        public final void onClick(View view) {
            this.f58042a.onBackPressed();
        }
    }

    private static void a(ImageView imageView, String str) {
        try {
            w.a().a(str).a(R.drawable.pass_merchant_icon_xxhdpi).a(imageView);
        } catch (Exception unused) {
            imageView.setImageResource(R.drawable.pass_merchant_icon_xxhdpi);
        }
    }

    private final void a() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.from1));
            sb.append(" ");
            a.C1111a aVar = net.one97.paytm.passbook.mlv.d.a.f58098a;
            UserMLVTemplateDetail userMLVTemplateDetail = this.f58037b;
            sb.append(a.C1111a.a(userMLVTemplateDetail != null ? userMLVTemplateDetail.getMlvCardTemplate() : null));
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.toolbar);
            k.a((Object) relativeLayout, "toolbar");
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.needHelpRl);
            k.a((Object) relativeLayout2, "needHelpRl");
            relativeLayout2.setVisibility(8);
            View a2 = a(R.id.separator);
            k.a((Object) a2, "separator");
            a2.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) a(R.id.rootLayout);
            k.a((Object) linearLayout, "rootLayout");
            int width = linearLayout.getWidth();
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.rootLayout);
            k.a((Object) linearLayout2, "rootLayout");
            Bitmap createBitmap = Bitmap.createBitmap(width, linearLayout2.getHeight(), Bitmap.Config.ARGB_8888);
            ((LinearLayout) a(R.id.rootLayout)).draw(new Canvas(createBitmap));
            RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.toolbar);
            k.a((Object) relativeLayout3, "toolbar");
            relativeLayout3.setVisibility(0);
            RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.needHelpRl);
            k.a((Object) relativeLayout4, "needHelpRl");
            relativeLayout4.setVisibility(0);
            View a3 = a(R.id.separator);
            k.a((Object) a3, "separator");
            a3.setVisibility(0);
            k.a((Object) createBitmap, "bitmap");
            if (createBitmap != null) {
                intent.putExtra("android.intent.extra.STREAM", q.a((Context) this, createBitmap));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                a();
            } else if (androidx.core.app.a.a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText(this, "Storage permission is required to share the screen.", 0).show();
            } else {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new d(this));
                    builder.setNegativeButton(getResources().getString(R.string.cancel), e.f58044a);
                    builder.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MLVTransactionDetailActivity f58043a;

        d(MLVTransactionDetailActivity mLVTransactionDetailActivity) {
            this.f58043a = mLVTransactionDetailActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b((Context) this.f58043a);
        }
    }

    public static final /* synthetic */ void b(MLVTransactionDetailActivity mLVTransactionDetailActivity) {
        if (s.a()) {
            Activity activity = mLVTransactionDetailActivity;
            if (!s.c(activity)) {
                s.b(activity);
                return;
            }
        }
        mLVTransactionDetailActivity.a();
    }
}
