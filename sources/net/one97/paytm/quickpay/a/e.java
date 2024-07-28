package net.one97.paytm.quickpay.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;

public final class e extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRPaytmDataModel> f59894a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRPaytmDataModel> f59895b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f59896c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f59897d;

    /* renamed from: e  reason: collision with root package name */
    private a f59898e;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public e(Context context, ArrayList<IJRPaytmDataModel> arrayList) {
        Iterator<IJRPaytmDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IJRPaytmDataModel next = it2.next();
            if (next instanceof BeneficiaryEntity) {
                this.f59894a.add(next);
            }
        }
        this.f59897d = LayoutInflater.from(context);
        if (this.f59894a != null) {
            this.f59895b = new ArrayList<>();
            this.f59895b.addAll(this.f59894a);
        }
    }

    public final void a(ArrayList<IJRPaytmDataModel> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<IJRPaytmDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IJRPaytmDataModel next = it2.next();
            if (next instanceof BeneficiaryEntity) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) next;
                if (beneficiaryEntity.instrumentPreferences.otherBank != null && !TextUtils.isEmpty(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber) && !this.f59896c.contains(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber)) {
                    this.f59896c.add(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber);
                    arrayList2.add(next);
                }
            }
        }
        this.f59894a.addAll(arrayList2);
        this.f59895b.addAll(arrayList2);
        notifyDataSetChanged();
    }

    public final int getCount() {
        ArrayList<IJRPaytmDataModel> arrayList = this.f59895b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final IJRPaytmDataModel getItem(int i2) {
        return this.f59895b.get(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            com.paytm.network.model.IJRPaytmDataModel r6 = r5.getItem((int) r6)
            r0 = 0
            if (r7 != 0) goto L_0x0039
            android.view.LayoutInflater r7 = r5.f59897d
            r1 = 2131559826(0x7f0d0592, float:1.8745007E38)
            android.view.View r7 = r7.inflate(r1, r8, r0)
            net.one97.paytm.quickpay.a.e$b r8 = new net.one97.paytm.quickpay.a.e$b
            r8.<init>()
            r1 = 2131372714(0x7f0a2aaa, float:1.8365499E38)
            android.view.View r1 = r7.findViewById(r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            r8.f59900a = r1
            r1 = 2131372715(0x7f0a2aab, float:1.83655E38)
            android.view.View r1 = r7.findViewById(r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            r8.f59901b = r1
            r1 = 2131372737(0x7f0a2ac1, float:1.8365545E38)
            android.view.View r1 = r7.findViewById(r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            r8.f59902c = r1
            r7.setTag(r8)
        L_0x0039:
            java.lang.Object r8 = r7.getTag()
            net.one97.paytm.quickpay.a.e$b r8 = (net.one97.paytm.quickpay.a.e.b) r8
            boolean r1 = r6 instanceof net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x009c
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r6
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r6.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            if (r1 == 0) goto L_0x0076
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r6 = r6.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r6 = r6.otherBank
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r1 = r6.accounts
            java.lang.Object r1 = r1.get(r0)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r1 = r1.accountDetail
            java.lang.String r2 = r1.accountHolderName
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r1 = r6.accounts
            java.lang.Object r1 = r1.get(r0)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r1 = r1.accountDetail
            java.lang.String r1 = r1.bankName
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r6 = r6.accounts
            java.lang.Object r6 = r6.get(r0)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r6
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r6 = r6.accountDetail
            java.lang.String r6 = r6.accountNumber
            goto L_0x009e
        L_0x0076:
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r1 = r6.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r1 = r1.upi
            if (r1 == 0) goto L_0x009c
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r6 = r6.instrumentPreferences
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r6 = r6.upi
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r1 = r6.accounts
            java.lang.Object r1 = r1.get(r0)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r1 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r1
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r1 = r1.accountDetail
            java.lang.String r1 = r1.accountHolderName
            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r6 = r6.accounts
            java.lang.Object r6 = r6.get(r0)
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r6
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r6 = r6.accountDetail
            java.lang.String r6 = r6.vpa
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x009e
        L_0x009c:
            r6 = r2
            r1 = r6
        L_0x009e:
            com.paytm.utility.RoboTextView r3 = r8.f59900a
            r3.setText(r2)
            boolean r2 = net.one97.paytm.upi.util.UpiAppUtils.checkIsVpa(r6)
            if (r2 == 0) goto L_0x00af
            com.paytm.utility.RoboTextView r2 = r8.f59901b
            r2.setText(r6)
            goto L_0x00b9
        L_0x00af:
            com.paytm.utility.RoboTextView r2 = r8.f59901b
            r3 = 4
            java.lang.String r6 = net.one97.paytm.upi.util.UpiAppUtils.insertSpaceAfterInterval(r6, r3)
            r2.setText(r6)
        L_0x00b9:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x00ca
            com.paytm.utility.RoboTextView r6 = r8.f59902c
            r6.setVisibility(r0)
            com.paytm.utility.RoboTextView r6 = r8.f59902c
            r6.setText(r1)
            goto L_0x00d1
        L_0x00ca:
            com.paytm.utility.RoboTextView r6 = r8.f59902c
            r8 = 8
            r6.setVisibility(r8)
        L_0x00d1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.a.e.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final Filter getFilter() {
        if (this.f59898e == null) {
            this.f59898e = new a();
        }
        return this.f59898e;
    }

    public class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = e.this.f59894a;
                filterResults.count = e.this.f59894a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = e.this.f59894a.iterator();
                while (it2.hasNext()) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) it2.next();
                    if (iJRPaytmDataModel instanceof BeneficiaryEntity) {
                        BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) iJRPaytmDataModel;
                        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                            if (beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber.trim().startsWith(charSequence.toString().trim())) {
                                arrayList.add(iJRPaytmDataModel);
                            }
                        } else if (beneficiaryEntity.instrumentPreferences.upi != null && beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa.trim().toLowerCase().startsWith(charSequence.toString().trim().toLowerCase())) {
                            arrayList.add(iJRPaytmDataModel);
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList unused = e.this.f59895b = (ArrayList) filterResults.values;
            e.this.notifyDataSetChanged();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f59900a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f59901b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f59902c;

        public b() {
        }
    }
}
