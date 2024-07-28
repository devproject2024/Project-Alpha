package net.one97.paytm.moneytransfer.view.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.airbnb.lottie.LottieAnimationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;
import net.one97.paytm.moneytransfer.utils.q;
import net.one97.paytm.moneytransfer.view.fragments.l;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;

public final class a extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    public final q f54198a = new q();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f54199b;

    /* renamed from: c  reason: collision with root package name */
    Context f54200c;

    /* renamed from: d  reason: collision with root package name */
    C0970a f54201d;

    /* renamed from: e  reason: collision with root package name */
    public int f54202e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54203f = false;

    /* renamed from: g  reason: collision with root package name */
    String f54204g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54205h = false;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<String> f54206i = new ArrayList<String>() {
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

    /* renamed from: net.one97.paytm.moneytransfer.view.a.a$a  reason: collision with other inner class name */
    public interface C0970a {
        void a(int i2);

        void a(int i2, TextView textView);

        void b(int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r14, int r15) {
        /*
            r13 = this;
            net.one97.paytm.moneytransfer.view.a.a$c r14 = (net.one97.paytm.moneytransfer.view.a.a.c) r14
            net.one97.paytm.moneytransfer.utils.q r0 = r13.f54198a
            net.one97.paytm.moneytransfer.utils.SwipeRevealLayout r1 = r14.m
            java.lang.String r2 = java.lang.String.valueOf(r15)
            r0.a((net.one97.paytm.moneytransfer.utils.SwipeRevealLayout) r1, (java.lang.String) r2)
            if (r14 == 0) goto L_0x02f4
            android.widget.RelativeLayout r0 = r14.n
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            r0.setTag(r1)
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f54199b
            java.lang.Object r0 = r0.get(r15)
            net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r0 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r0
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r0.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            java.lang.String r2 = "0"
            r3 = 1
            java.lang.String r4 = ""
            r5 = 8
            r6 = 0
            if (r1 == 0) goto L_0x00c6
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r0 = r0.otherBank
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r1 = r0.accounts
            java.lang.Object r1 = r1.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r1 = r1.accountDetail
            java.lang.String r4 = r1.accountHolderName
            java.lang.String r7 = r1.bankName
            java.lang.String r8 = r1.logoUrl
            java.lang.String r9 = r1.accountNumber
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r10 = r0.accounts
            java.lang.Object r10 = r10.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r10 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r10
            java.lang.String r10 = r10.creationTime
            java.lang.String r11 = r1.ifscCode
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r0 = r0.accounts
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r0 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r0
            java.lang.String r0 = r0.uuid
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x00c0
            android.widget.TextView r0 = r14.f54214d
            r0.setVisibility(r5)
            android.widget.TextView r0 = r14.f54211a
            r0.setVisibility(r5)
            android.widget.TextView r0 = r14.f54215e
            net.one97.paytm.moneytransfer.view.a.a r2 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r2 = r2.f54200c
            int r12 = net.one97.paytm.moneytransfer.R.string.mt_settings
            java.lang.String r2 = r2.getString(r12)
            r0.setText(r2)
            android.widget.TextView r0 = r14.f54215e
            net.one97.paytm.moneytransfer.view.a.a r2 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r2 = r2.f54200c
            int r12 = net.one97.paytm.moneytransfer.R.color.mt_swipe_settings
            int r2 = androidx.core.content.b.c(r2, r12)
            r0.setBackgroundColor(r2)
            boolean r0 = r1.isMpinSet
            if (r0 != 0) goto L_0x00ae
            java.lang.String r0 = r1.ifscCode
            java.lang.String r1 = "PYTM0123456"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x00ae
            android.widget.TextView r0 = r14.f54217g
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r1 = r1.f54200c
            int r2 = net.one97.paytm.moneytransfer.R.string.mt_set_upi_pin
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            goto L_0x00bd
        L_0x00ae:
            android.widget.TextView r0 = r14.f54217g
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r1 = r1.f54200c
            int r2 = net.one97.paytm.moneytransfer.R.string.check_balance
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
        L_0x00bd:
            r0 = 1
            goto L_0x011f
        L_0x00c0:
            android.widget.TextView r0 = r14.f54214d
            r0.setVisibility(r6)
            goto L_0x011e
        L_0x00c6:
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r0.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r1 = r1.upi
            if (r1 == 0) goto L_0x0119
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r0 = r0.upi
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r1 = r0.accounts
            java.lang.Object r1 = r1.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r1 = r1.accountDetail
            java.lang.String r1 = r1.accountHolderName
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r7 = r0.accounts
            java.lang.Object r7 = r7.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r7 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r7
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r7 = r7.accountDetail
            java.lang.String r7 = r7.vpa
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r8 = r0.accounts
            java.lang.Object r8 = r8.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r8 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r8
            java.lang.String r8 = r8.creationTime
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r0 = r0.accounts
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r0 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r0
            java.lang.String r0 = r0.uuid
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x010c
            android.widget.TextView r0 = r14.f54214d
            r0.setVisibility(r5)
            r11 = r4
            r9 = r7
            r10 = r8
            r0 = 1
            goto L_0x0115
        L_0x010c:
            android.widget.TextView r0 = r14.f54214d
            r0.setVisibility(r6)
            r11 = r4
            r9 = r7
            r10 = r8
            r0 = 0
        L_0x0115:
            r4 = r1
            r7 = r11
            r8 = r7
            goto L_0x011f
        L_0x0119:
            r7 = r4
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x011e:
            r0 = 0
        L_0x011f:
            java.lang.String r1 = net.one97.paytm.moneytransfer.utils.m.f((java.lang.String) r4)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0140
            android.widget.TextView r2 = r14.f54216f
            if (r0 == 0) goto L_0x0132
            java.lang.String r4 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r7, (java.lang.String) r9)
            goto L_0x0133
        L_0x0132:
            r4 = r1
        L_0x0133:
            r2.setText(r4)
            android.widget.TextView r2 = r14.f54218h
            java.lang.String r1 = net.one97.paytm.moneytransfer.utils.m.a((java.lang.String) r1)
            r2.setText(r1)
            goto L_0x0145
        L_0x0140:
            android.widget.ImageView r1 = r14.f54219i
            r1.setVisibility(r6)
        L_0x0145:
            if (r0 == 0) goto L_0x01bb
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            int r0 = r0.f54202e
            r1 = -1
            if (r0 == r1) goto L_0x01b5
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            int r0 = r0.f54202e
            if (r15 != r0) goto L_0x0165
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            boolean r0 = r0.f54203f
            if (r0 == 0) goto L_0x0165
            android.widget.TextView r0 = r14.f54217g
            r0.setVisibility(r5)
            com.airbnb.lottie.LottieAnimationView r0 = r14.k
            net.one97.paytm.common.widgets.a.a(r0)
            goto L_0x01c0
        L_0x0165:
            com.airbnb.lottie.LottieAnimationView r0 = r14.k
            net.one97.paytm.common.widgets.a.b(r0)
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            java.lang.String r0 = r0.f54204g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0195
            android.widget.TextView r0 = r14.f54217g
            android.widget.TextView r1 = r14.f54217g
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.moneytransfer.R.color.excl_color_00b9f5
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r14.f54217g
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r1 = r1.f54200c
            int r2 = net.one97.paytm.moneytransfer.R.string.check_balance
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            goto L_0x01af
        L_0x0195:
            android.widget.TextView r0 = r14.f54217g
            android.widget.TextView r1 = r14.f54217g
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.moneytransfer.R.color.color_222222
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r14.f54217g
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            java.lang.String r1 = r1.f54204g
            r0.setText(r1)
        L_0x01af:
            android.widget.TextView r0 = r14.f54217g
            r0.setVisibility(r6)
            goto L_0x01c0
        L_0x01b5:
            android.widget.TextView r0 = r14.f54217g
            r0.setVisibility(r6)
            goto L_0x01c0
        L_0x01bb:
            android.widget.TextView r0 = r14.f54217g
            r0.setVisibility(r5)
        L_0x01c0:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0207
            boolean r0 = net.one97.paytm.upi.util.UpiAppUtils.checkIsVpa(r9)
            if (r0 == 0) goto L_0x01e8
            android.widget.TextView r0 = r14.f54211a
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r1 = r1.f54200c
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_without_bold
            java.lang.String r1 = r1.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r6] = r9
            java.lang.String r1 = java.lang.String.format(r1, r2)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r0.setText(r1)
            goto L_0x0207
        L_0x01e8:
            android.widget.TextView r0 = r14.f54211a
            net.one97.paytm.moneytransfer.view.a.a r1 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r1 = r1.f54200c
            int r2 = net.one97.paytm.moneytransfer.R.string.money_transfer_acc_no_with_placeholder_without_bold
            java.lang.String r1 = r1.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r4 = net.one97.paytm.upi.util.UpiUtils.maskAccNumberWithSpace(r9)
            r2[r6] = r4
            java.lang.String r1 = java.lang.String.format(r1, r2)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r0.setText(r1)
        L_0x0207:
            android.widget.TextView r0 = r14.f54213c
            r0.setVisibility(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x02af
            android.widget.TextView r15 = r14.f54218h
            r15.setVisibility(r5)
            android.widget.ImageView r15 = r14.f54219i
            r15.setVisibility(r6)
            android.widget.RelativeLayout r15 = r14.j
            r15.setVisibility(r5)
            android.widget.TextView r15 = r14.f54213c
            r15.setText(r7)
            boolean r15 = android.text.TextUtils.isEmpty(r8)
            r0 = 0
            if (r15 != 0) goto L_0x024f
            boolean r15 = android.webkit.URLUtil.isValidUrl(r8)
            if (r15 != 0) goto L_0x0234
            goto L_0x024f
        L_0x0234:
            com.squareup.picasso.w r15 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r15 = r15.a((java.lang.String) r8)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.mt_dummy_beneficiary_icon
            com.squareup.picasso.aa r15 = r15.a((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r15 = r15.b((int) r1)
            android.widget.ImageView r1 = r14.f54219i
            r15.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r0)
            goto L_0x02ce
        L_0x024f:
            net.one97.paytm.moneytransfer.view.a.a r15 = net.one97.paytm.moneytransfer.view.a.a.this
            android.widget.ImageView r1 = r14.f54219i
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 != 0) goto L_0x026d
            java.lang.String r2 = "ICIC"
            boolean r2 = r11.contains(r2)
            if (r2 == 0) goto L_0x026d
            android.content.Context r15 = r15.f54200c
            int r0 = net.one97.paytm.moneytransfer.R.drawable.icici_bank_logo
            android.graphics.drawable.Drawable r15 = androidx.core.content.b.a((android.content.Context) r15, (int) r0)
            r1.setImageDrawable(r15)
            goto L_0x02ce
        L_0x026d:
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 != 0) goto L_0x0287
            java.lang.String r2 = "UPI"
            boolean r2 = r11.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0287
            android.content.Context r15 = r15.f54200c
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_bhim
            android.graphics.drawable.Drawable r15 = androidx.core.content.b.a((android.content.Context) r15, (int) r0)
            r1.setImageDrawable(r15)
            goto L_0x02ce
        L_0x0287:
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 != 0) goto L_0x02ce
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            android.content.Context r15 = r15.f54200c
            android.content.Context r15 = r15.getApplicationContext()
            java.lang.String r15 = net.one97.paytm.upi.util.UpiRequestBuilder.getBankIconUrl(r15, r11)
            com.squareup.picasso.aa r15 = r2.a((java.lang.String) r15)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.mt_dummy_beneficiary_icon
            com.squareup.picasso.aa r15 = r15.a((int) r2)
            int r2 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r15 = r15.b((int) r2)
            r15.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r0)
            goto L_0x02ce
        L_0x02af:
            android.widget.RelativeLayout r0 = r14.j
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.f54218h
            r0.setVisibility(r6)
            int r15 = r15 % 10
            net.one97.paytm.moneytransfer.view.a.a r0 = net.one97.paytm.moneytransfer.view.a.a.this
            java.util.ArrayList<java.lang.String> r0 = r0.f54206i
            java.lang.Object r15 = r0.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            android.widget.TextView r0 = r14.f54218h
            int r15 = android.graphics.Color.parseColor(r15)
            r0.setBackgroundColor(r15)
        L_0x02ce:
            android.widget.TextView r15 = r14.f54212b
            r15.setVisibility(r5)
            boolean r15 = android.text.TextUtils.isEmpty(r10)
            if (r15 != 0) goto L_0x02f4
            android.widget.TextView r15 = r14.f54212b
            net.one97.paytm.moneytransfer.view.a.a r14 = net.one97.paytm.moneytransfer.view.a.a.this
            android.content.Context r14 = r14.f54200c
            int r0 = net.one97.paytm.moneytransfer.R.string.money_transfer_added_on
            java.lang.String r14 = r14.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = b(r10)
            r0[r6] = r1
            java.lang.String r14 = java.lang.String.format(r14, r0)
            r15.setText(r14)
        L_0x02f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public a(Context context, C0970a aVar) {
        this.f54200c = context;
        this.f54201d = aVar;
        this.f54198a.f54192c = true;
    }

    public final void a(ArrayList<IJRDataModel> arrayList) {
        ArrayList<IJRDataModel> arrayList2 = this.f54199b;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            this.f54199b = arrayList;
            notifyItemRangeInserted(0, arrayList.size());
            return;
        }
        this.f54204g = "";
        h.b a2 = h.a(new b(this.f54199b, arrayList));
        this.f54199b = arrayList;
        a2.a((RecyclerView.a) this);
    }

    public final void a(String str) {
        int i2 = this.f54202e;
        if (i2 != -1) {
            this.f54203f = false;
            this.f54204g = str;
            notifyItemChanged(i2);
        }
    }

    private static String b(String str) {
        try {
            return a("dd/MM/yyyy HH:mm:ss", "dd MMM", str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final int getItemCount() {
        ArrayList<IJRDataModel> arrayList = this.f54199b;
        if (arrayList == null) {
            return 0;
        }
        if (this.f54205h) {
            return arrayList.size();
        }
        return Math.min(arrayList.size(), l.f54507a);
    }

    public class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f54211a;

        /* renamed from: b  reason: collision with root package name */
        TextView f54212b;

        /* renamed from: c  reason: collision with root package name */
        TextView f54213c;

        /* renamed from: d  reason: collision with root package name */
        TextView f54214d;

        /* renamed from: e  reason: collision with root package name */
        TextView f54215e;

        /* renamed from: f  reason: collision with root package name */
        TextView f54216f;

        /* renamed from: g  reason: collision with root package name */
        TextView f54217g;

        /* renamed from: h  reason: collision with root package name */
        TextView f54218h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f54219i;
        RelativeLayout j;
        LottieAnimationView k;
        /* access modifiers changed from: private */
        public SwipeRevealLayout m;
        /* access modifiers changed from: private */
        public RelativeLayout n;
        private ImageView o;

        c(View view) {
            super(view);
            this.m = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f54211a = (TextView) view.findViewById(R.id.beneficiary_name);
            this.f54214d = (TextView) view.findViewById(R.id.delete_tv);
            this.f54215e = (TextView) view.findViewById(R.id.history_tv);
            this.f54216f = (TextView) view.findViewById(R.id.beneficiary_number);
            this.f54212b = (TextView) view.findViewById(R.id.date_tv);
            this.f54217g = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f54213c = (TextView) view.findViewById(R.id.headerBankLogoName);
            this.f54218h = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.n = (RelativeLayout) view.findViewById(R.id.beneficiary_item);
            this.f54219i = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.o = (ImageView) view.findViewById(R.id.selected_icon);
            this.j = (RelativeLayout) view.findViewById(R.id.layer_contact_list_backgrnd);
            this.k = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
            this.f54214d.setOnClickListener(this);
            this.f54215e.setOnClickListener(this);
            this.f54217g.setOnClickListener(this);
            this.n.setOnClickListener(this);
        }

        public final void onClick(View view) {
            if (view.getId() == R.id.delete_tv) {
                q qVar = a.this.f54198a;
                StringBuilder sb = new StringBuilder();
                sb.append(getAdapterPosition());
                qVar.a(sb.toString());
                a.this.f54201d.a(getAdapterPosition());
            } else if (view.getId() == R.id.history_tv) {
                q qVar2 = a.this.f54198a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getAdapterPosition());
                qVar2.a(sb2.toString());
                a.this.f54201d.b(getAdapterPosition());
            } else if (view.getId() == R.id.check_balance_tv) {
                String charSequence = this.f54217g.getText().toString();
                if (charSequence.equalsIgnoreCase(a.this.f54200c.getString(R.string.check_balance))) {
                    a aVar = a.this;
                    aVar.f54203f = true;
                    aVar.f54202e = getAdapterPosition();
                    a aVar2 = a.this;
                    aVar2.notifyItemChanged(aVar2.f54202e);
                    a.this.f54201d.a(getAdapterPosition(), this.f54217g);
                } else if (charSequence.equalsIgnoreCase(a.this.f54200c.getString(R.string.mt_set_upi_pin))) {
                    a.this.f54201d.a(getAdapterPosition(), this.f54217g);
                }
            } else if (view.getId() == R.id.beneficiary_item) {
                try {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition < a.this.f54199b.size()) {
                        BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a.this.f54199b.get(adapterPosition);
                        UpiDBTransactionModel upiDBTransactionModel = null;
                        String str = "";
                        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                            BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity.instrumentPreferences.otherBank;
                            BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = otherBank.accounts.get(0).accountDetail;
                            String str2 = otherBankAccountDetail.accountNumber;
                            if (otherBank != null) {
                                boolean equalsIgnoreCase = otherBank.accounts.get(0).uuid.equalsIgnoreCase("0");
                                String str3 = otherBankAccountDetail.accountHolderName;
                                if (!TextUtils.isEmpty(otherBankAccountDetail.bankName)) {
                                    str = otherBankAccountDetail.bankName;
                                }
                                upiDBTransactionModel = new UpiDBTransactionModel("", str2, str3, str, otherBankAccountDetail.ifscCode, "", "");
                                upiDBTransactionModel.setSelf(equalsIgnoreCase);
                            }
                        } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                            BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                            String str4 = uPIAccountDetail.vpa;
                            String str5 = uPIAccountDetail.accountHolderName;
                            if (!TextUtils.isEmpty(uPIAccountDetail.bankName)) {
                                str = uPIAccountDetail.bankName;
                            }
                            upiDBTransactionModel = new UpiDBTransactionModel("", str4, str5, str, uPIAccountDetail.ifscCode, "", "");
                        }
                        d.a.a.c.a().c(upiDBTransactionModel);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    class b extends h.a {

        /* renamed from: b  reason: collision with root package name */
        private List<IJRDataModel> f54209b;

        /* renamed from: c  reason: collision with root package name */
        private List<IJRDataModel> f54210c;

        public b(List<IJRDataModel> list, List<IJRDataModel> list2) {
            this.f54209b = list;
            this.f54210c = list2;
        }

        public final int getOldListSize() {
            return this.f54209b.size();
        }

        public final int getNewListSize() {
            return this.f54210c.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) this.f54209b.get(i2);
            BeneficiaryEntity beneficiaryEntity2 = (BeneficiaryEntity) this.f54210c.get(i3);
            if (beneficiaryEntity.instrumentPreferences.otherBank == null || beneficiaryEntity2.instrumentPreferences.otherBank == null || !beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber.equalsIgnoreCase(beneficiaryEntity2.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber)) {
                return false;
            }
            return true;
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) this.f54209b.get(i2);
            BeneficiaryEntity beneficiaryEntity2 = (BeneficiaryEntity) this.f54210c.get(i3);
            if (beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName == null || beneficiaryEntity2.instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName == null) {
                return false;
            }
            return beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName.equalsIgnoreCase(beneficiaryEntity2.instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new c(LayoutInflater.from(this.f54200c).inflate(R.layout.mt_beneficiary_swipe_item, viewGroup, false));
    }
}
