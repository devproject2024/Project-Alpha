package net.one97.paytm.paymentsBank.si.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.BeneficiaryEntity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.swipe.SwipeRevealLayout;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.paymentsBank.utils.swipe.a f18767a = new net.one97.paytm.paymentsBank.utils.swipe.a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRPaytmDataModel> f18768b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Context f18769c;

    /* renamed from: d  reason: collision with root package name */
    C0322a f18770d;

    /* renamed from: e  reason: collision with root package name */
    private int f18771e = -1;

    /* renamed from: net.one97.paytm.paymentsBank.si.a.a$a  reason: collision with other inner class name */
    public interface C0322a {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        net.one97.paytm.paymentsBank.utils.swipe.a aVar = this.f18767a;
        SwipeRevealLayout swipeRevealLayout = bVar.f18772a;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.getAdapterPosition());
        aVar.a(swipeRevealLayout, sb.toString());
        net.one97.paytm.paymentsBank.utils.swipe.a aVar2 = this.f18767a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bVar.getAdapterPosition());
        aVar2.a(sb2.toString());
        if (bVar != null) {
            bVar.f18773b.setTag(Integer.valueOf(i2));
            bVar.a(i2);
        }
    }

    public a(Context context, ArrayList<IJRPaytmDataModel> arrayList, C0322a aVar) {
        this.f18769c = context;
        this.f18768b = arrayList;
        this.f18770d = aVar;
        this.f18767a.f19605c = true;
    }

    static String a(String str) {
        try {
            return a("dd/MM/yyyy HH:mm:ss", "dd MMM", str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public final int getItemCount() {
        ArrayList<IJRPaytmDataModel> arrayList = this.f18768b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a(this.f18769c, R.drawable.pb_ic_bhim));
        } else if (!TextUtils.isEmpty(str)) {
            w a2 = w.a();
            this.f18769c.getApplicationContext();
            a2.a(net.one97.paytm.paymentsBank.si.g.a.a(str)).a(androidx.core.content.b.a(this.f18769c, R.drawable.pb_mt_dummy_beneficiary_icon)).b(androidx.core.content.b.a(this.f18769c, R.drawable.pb_bank_ic_default_bank)).a(imageView, (e) null);
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        SwipeRevealLayout f18772a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f18773b;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18775d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18776e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18777f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18778g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18779h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18780i;
        private TextView j;
        private ImageView k;

        b(View view) {
            super(view);
            this.f18772a = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f18775d = (TextView) view.findViewById(R.id.beneficiary_name);
            this.f18778g = (TextView) view.findViewById(R.id.delete_tv);
            this.f18779h = (TextView) view.findViewById(R.id.set_reminder_tv);
            this.f18780i = (TextView) view.findViewById(R.id.beneficiary_number);
            this.f18776e = (TextView) view.findViewById(R.id.date_tv);
            this.f18777f = (TextView) view.findViewById(R.id.headerBankLogoName);
            this.j = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.f18773b = (RelativeLayout) view.findViewById(R.id.beneficiary_item);
            this.k = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            view.findViewById(R.id.selected_icon);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x010a  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x015a  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x018f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r10) {
            /*
                r9 = this;
                net.one97.paytm.paymentsBank.si.a.a r0 = net.one97.paytm.paymentsBank.si.a.a.this
                java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r0.f18768b
                java.lang.Object r0 = r0.get(r10)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r0
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBank r0 = r0.otherBank
                java.lang.String r1 = "0"
                r2 = 1
                java.lang.String r3 = ""
                r4 = 8
                r5 = 0
                if (r0 == 0) goto L_0x007e
                net.one97.paytm.paymentsBank.si.a.a r0 = net.one97.paytm.paymentsBank.si.a.a.this
                java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r0.f18768b
                java.lang.Object r10 = r0.get(r10)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity r10 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r10
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r10 = r10.instrumentPreferences
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBank r10 = r10.otherBank
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r0 = r10.accounts
                java.lang.Object r0 = r0.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r0
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccountDetail r0 = r0.accountDetail
                java.lang.String r3 = r0.accountHolderName
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r0 = r10.accounts
                java.lang.Object r0 = r0.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r0
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccountDetail r0 = r0.accountDetail
                java.lang.String r0 = r0.bankName
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r6 = r10.accounts
                java.lang.Object r6 = r6.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r6 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r6
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccountDetail r6 = r6.accountDetail
                java.lang.String r6 = r6.accountNumber
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r7 = r10.accounts
                java.lang.Object r7 = r7.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r7 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r7
                java.lang.String r7 = r7.creationTime
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r8 = r10.accounts
                java.lang.Object r8 = r8.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r8 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r8
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccountDetail r8 = r8.accountDetail
                java.lang.String r8 = r8.ifscCode
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r10 = r10.accounts
                java.lang.Object r10 = r10.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r10 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r10
                java.lang.String r10 = r10.uuid
                boolean r10 = r10.equalsIgnoreCase(r1)
                if (r10 == 0) goto L_0x0078
                android.widget.TextView r10 = r9.f18778g
                r10.setVisibility(r4)
                r10 = 1
                goto L_0x00e5
            L_0x0078:
                android.widget.TextView r10 = r9.f18778g
                r10.setVisibility(r5)
                goto L_0x00e4
            L_0x007e:
                net.one97.paytm.paymentsBank.si.a.a r0 = net.one97.paytm.paymentsBank.si.a.a.this
                java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r0.f18768b
                java.lang.Object r0 = r0.get(r10)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r0
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPI r0 = r0.upi
                if (r0 == 0) goto L_0x00e0
                net.one97.paytm.paymentsBank.si.a.a r0 = net.one97.paytm.paymentsBank.si.a.a.this
                java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r0.f18768b
                java.lang.Object r10 = r0.get(r10)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity r10 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r10
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r10 = r10.instrumentPreferences
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPI r10 = r10.upi
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount> r0 = r10.accounts
                java.lang.Object r0 = r0.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.UPIAccount) r0
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccountDetail r0 = r0.accountDetail
                java.lang.String r0 = r0.accountHolderName
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount> r6 = r10.accounts
                java.lang.Object r6 = r6.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount r6 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.UPIAccount) r6
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccountDetail r6 = r6.accountDetail
                java.lang.String r6 = r6.vpa
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount> r7 = r10.accounts
                java.lang.Object r7 = r7.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount r7 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.UPIAccount) r7
                java.lang.String r7 = r7.creationTime
                java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount> r10 = r10.accounts
                java.lang.Object r10 = r10.get(r5)
                net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount r10 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.UPIAccount) r10
                java.lang.String r10 = r10.uuid
                boolean r10 = r10.equalsIgnoreCase(r1)
                if (r10 == 0) goto L_0x00d6
                android.widget.TextView r10 = r9.f18778g
                r10.setVisibility(r4)
                r8 = r3
                r10 = 1
                goto L_0x00dd
            L_0x00d6:
                android.widget.TextView r10 = r9.f18778g
                r10.setVisibility(r5)
                r8 = r3
                r10 = 0
            L_0x00dd:
                r3 = r0
                r0 = r8
                goto L_0x00e5
            L_0x00e0:
                r0 = r3
                r6 = r0
                r7 = r6
                r8 = r7
            L_0x00e4:
                r10 = 0
            L_0x00e5:
                boolean r1 = android.text.TextUtils.isEmpty(r3)
                if (r1 != 0) goto L_0x00ff
                android.widget.TextView r1 = r9.f18780i
                if (r10 == 0) goto L_0x00f1
                r10 = r0
                goto L_0x00f2
            L_0x00f1:
                r10 = r3
            L_0x00f2:
                r1.setText(r10)
                android.widget.TextView r10 = r9.j
                java.lang.String r1 = net.one97.paytm.bankCommon.mapping.e.Z(r3)
                r10.setText(r1)
                goto L_0x0104
            L_0x00ff:
                android.widget.ImageView r10 = r9.k
                r10.setVisibility(r5)
            L_0x0104:
                boolean r10 = android.text.TextUtils.isEmpty(r6)
                if (r10 != 0) goto L_0x014f
                boolean r10 = net.one97.paytm.bankCommon.mapping.a.Z(r6)
                if (r10 == 0) goto L_0x012c
                android.widget.TextView r10 = r9.f18775d
                net.one97.paytm.paymentsBank.si.a.a r1 = net.one97.paytm.paymentsBank.si.a.a.this
                android.content.Context r1 = r1.f18769c
                int r3 = net.one97.paytm.paymentsBank.R.string.pb_money_transfer_upi_without_bold
                java.lang.String r1 = r1.getString(r3)
                java.lang.Object[] r3 = new java.lang.Object[r2]
                r3[r5] = r6
                java.lang.String r1 = java.lang.String.format(r1, r3)
                android.text.Spanned r1 = android.text.Html.fromHtml(r1)
                r10.setText(r1)
                goto L_0x014f
            L_0x012c:
                android.widget.TextView r10 = r9.f18775d
                net.one97.paytm.paymentsBank.si.a.a r1 = net.one97.paytm.paymentsBank.si.a.a.this
                android.content.Context r1 = r1.f18769c
                int r3 = net.one97.paytm.paymentsBank.R.string.pb_money_transfer_acc_no_with_placeholder_without_bold
                java.lang.String r1 = r1.getString(r3)
                java.lang.Object[] r3 = new java.lang.Object[r2]
                java.lang.String r6 = net.one97.paytm.bankCommon.mapping.e.aa(r6)
                java.lang.String r6 = net.one97.paytm.bankCommon.mapping.a.aa(r6)
                r3[r5] = r6
                java.lang.String r1 = java.lang.String.format(r1, r3)
                android.text.Spanned r1 = android.text.Html.fromHtml(r1)
                r10.setText(r1)
            L_0x014f:
                android.widget.TextView r10 = r9.f18777f
                r10.setVisibility(r4)
                boolean r10 = android.text.TextUtils.isEmpty(r8)
                if (r10 != 0) goto L_0x0171
                android.widget.TextView r10 = r9.j
                r10.setVisibility(r4)
                android.widget.ImageView r10 = r9.k
                r10.setVisibility(r5)
                android.widget.TextView r10 = r9.f18777f
                r10.setText(r0)
                net.one97.paytm.paymentsBank.si.a.a r10 = net.one97.paytm.paymentsBank.si.a.a.this
                android.widget.ImageView r0 = r9.k
                r10.a(r0, r8)
                goto L_0x0184
            L_0x0171:
                android.widget.TextView r10 = r9.j
                r10.setVisibility(r4)
                android.widget.ImageView r10 = r9.k
                r10.setVisibility(r5)
                net.one97.paytm.paymentsBank.si.a.a r10 = net.one97.paytm.paymentsBank.si.a.a.this
                android.widget.ImageView r0 = r9.k
                java.lang.String r1 = "UPI"
                r10.a(r0, r1)
            L_0x0184:
                android.widget.TextView r10 = r9.f18776e
                r10.setVisibility(r4)
                boolean r10 = android.text.TextUtils.isEmpty(r7)
                if (r10 != 0) goto L_0x01aa
                android.widget.TextView r10 = r9.f18776e
                net.one97.paytm.paymentsBank.si.a.a r0 = net.one97.paytm.paymentsBank.si.a.a.this
                android.content.Context r0 = r0.f18769c
                int r1 = net.one97.paytm.paymentsBank.R.string.pb_money_transfer_added_on
                java.lang.String r0 = r0.getString(r1)
                java.lang.Object[] r1 = new java.lang.Object[r2]
                java.lang.String r2 = net.one97.paytm.paymentsBank.si.a.a.a(r7)
                r1[r5] = r2
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r10.setText(r0)
            L_0x01aa:
                android.widget.RelativeLayout r10 = r9.f18773b
                net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$bQ5QL7UIrdwlylS3jjNAhOTuLYY r0 = new net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$bQ5QL7UIrdwlylS3jjNAhOTuLYY
                r0.<init>()
                r10.setOnClickListener(r0)
                android.widget.TextView r10 = r9.f18778g
                net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$ldEYgiY9R4vdnq8mJOT0fUQHAvU r0 = new net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$ldEYgiY9R4vdnq8mJOT0fUQHAvU
                r0.<init>()
                r10.setOnClickListener(r0)
                android.widget.TextView r10 = r9.f18779h
                net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$M1o_cogPYZx1yB8J80Z7OoXZavQ r0 = new net.one97.paytm.paymentsBank.si.a.-$$Lambda$a$b$M1o_cogPYZx1yB8J80Z7OoXZavQ
                r0.<init>()
                r10.setOnClickListener(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.a.a.b.a(int):void");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            if (a.this.f18769c instanceof d) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a.this.f18768b.get(getAdapterPosition());
                BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                HashMap hashMap = new HashMap();
                hashMap.put("holdername", otherBankAccountDetail.accountHolderName);
                hashMap.put("benifId", beneficiaryEntity.beneficiaryId);
                hashMap.put("acc_no", otherBankAccountDetail.accountNumber);
                hashMap.put("ifsc", otherBankAccountDetail.ifscCode);
                hashMap.put("bankname", otherBankAccountDetail.bankName);
                ((d) a.this.f18769c).onFragmentAction(105, hashMap);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            net.one97.paytm.paymentsBank.utils.swipe.a aVar = a.this.f18767a;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            aVar.a(sb.toString());
            a.this.f18770d.a(getAdapterPosition());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            net.one97.paytm.paymentsBank.utils.swipe.a aVar = a.this.f18767a;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            aVar.a(sb.toString());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f18769c).inflate(R.layout.si_benificiary_list_item, viewGroup, false));
    }
}
