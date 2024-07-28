package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.RoboTextView;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class h extends BaseAdapter implements Filterable {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UpiBaseDataModel> f69458a = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UpiBaseDataModel> f69459b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f69460c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f69461d;

    /* renamed from: e  reason: collision with root package name */
    private a f69462e;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public h(Context context, ArrayList<UpiBaseDataModel> arrayList) {
        Iterator<UpiBaseDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UpiBaseDataModel next = it2.next();
            if (next instanceof UpiDBTransactionModel) {
                UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) next;
                if (!this.f69460c.contains(upiDBTransactionModel.getTxn_mode())) {
                    this.f69460c.add(upiDBTransactionModel.getTxn_mode());
                    this.f69458a.add(next);
                }
            }
            if (next instanceof BeneficiaryEntity) {
                this.f69458a.add(next);
            }
        }
        this.f69461d = LayoutInflater.from(context);
        if (this.f69458a != null) {
            this.f69459b = new ArrayList<>();
            this.f69459b.addAll(this.f69458a);
        }
    }

    public final int getCount() {
        ArrayList<UpiBaseDataModel> arrayList = this.f69459b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final UpiBaseDataModel getItem(int i2) {
        return this.f69459b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        UpiBaseDataModel a2 = getItem(i2);
        if (view == null) {
            view = this.f69461d.inflate(R.layout.upi_request_money_drop_down_item, viewGroup, false);
            b bVar = new b();
            bVar.f69464a = (RoboTextView) view.findViewById(R.id.txt_account_name);
            bVar.f69465b = (RoboTextView) view.findViewById(R.id.txt_account_number);
            bVar.f69466c = (RoboTextView) view.findViewById(R.id.txt_bank_name);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        String str3 = "";
        if (a2 instanceof UpiDBTransactionModel) {
            UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) a2;
            str2 = upiDBTransactionModel.getBeneficiary_name() == null ? str3 : upiDBTransactionModel.getBeneficiary_name();
            String txn_mode = upiDBTransactionModel.getTxn_mode() == null ? str3 : upiDBTransactionModel.getTxn_mode();
            if (upiDBTransactionModel.getBank_name() != null) {
                str3 = upiDBTransactionModel.getBank_name();
            }
            str = txn_mode;
        } else {
            if (a2 instanceof BeneficiaryEntity) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a2;
                if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                    BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity.instrumentPreferences.otherBank;
                    String str4 = otherBank.accounts.get(0).accountDetail.accountHolderName;
                    String str5 = otherBank.accounts.get(0).accountDetail.bankName;
                    str = otherBank.accounts.get(0).accountDetail.accountNumber;
                    String str6 = str4;
                    str3 = str5;
                    str2 = str6;
                } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                    BeneficiaryEntity.UPI upi = beneficiaryEntity.instrumentPreferences.upi;
                    str2 = upi.accounts.get(0).accountDetail.accountHolderName;
                    str = upi.accounts.get(0).accountDetail.vpa;
                }
            }
            str = str3;
            str2 = str;
        }
        bVar2.f69464a.setText(str2);
        if (UpiAppUtils.checkIsVpa(str)) {
            bVar2.f69465b.setText(str);
        } else {
            bVar2.f69465b.setText(UpiAppUtils.insertSpaceAfterInterval(str, 4));
        }
        if (!TextUtils.isEmpty(str3)) {
            bVar2.f69466c.setVisibility(0);
            bVar2.f69466c.setText(str3);
        } else {
            bVar2.f69466c.setVisibility(8);
        }
        return view;
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f69464a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f69465b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f69466c;

        public b() {
        }
    }

    public class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.toString().trim().length() == 0) {
                filterResults.values = new ArrayList();
                filterResults.count = 0;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = h.this.f69458a.iterator();
                while (it2.hasNext()) {
                    UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) it2.next();
                    if (upiBaseDataModel instanceof UpiDBTransactionModel) {
                        UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) upiBaseDataModel;
                        if (!TextUtils.isEmpty(upiDBTransactionModel.getBeneficiary_name()) && upiDBTransactionModel.getTxn_mode().trim().startsWith(charSequence.toString().trim())) {
                            arrayList.add(upiBaseDataModel);
                        }
                    } else if (upiBaseDataModel instanceof BeneficiaryEntity) {
                        BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) upiBaseDataModel;
                        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                            if (beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber.trim().startsWith(charSequence.toString().trim())) {
                                arrayList.add(upiBaseDataModel);
                            }
                        } else if (beneficiaryEntity.instrumentPreferences.upi != null && beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa.trim().toLowerCase().startsWith(charSequence.toString().trim().toLowerCase())) {
                            arrayList.add(upiBaseDataModel);
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
            ArrayList unused = h.this.f69459b = (ArrayList) filterResults.values;
            h.this.notifyDataSetChanged();
        }
    }

    public final Filter getFilter() {
        if (this.f69462e == null) {
            this.f69462e = new a();
        }
        return this.f69462e;
    }
}
