package net.one97.paytm.moneytransfer.view.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;

public final class b extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRDataModel> f54220a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f54221b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f54222c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f54223d;

    /* renamed from: e  reason: collision with root package name */
    private a f54224e;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(Context context, List<IJRDataModel> list) {
        for (IJRDataModel next : list) {
            if (next instanceof UpiDBTransactionModel) {
                UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) next;
                if (!this.f54222c.contains(upiDBTransactionModel.getTxn_mode())) {
                    this.f54222c.add(upiDBTransactionModel.getTxn_mode());
                    this.f54220a.add(next);
                }
            }
            if (next instanceof BeneficiaryEntity) {
                this.f54220a.add(next);
            }
        }
        this.f54223d = LayoutInflater.from(context);
        if (this.f54220a != null) {
            this.f54221b = new ArrayList<>();
            this.f54221b.addAll(this.f54220a);
        }
    }

    public final int getCount() {
        ArrayList<IJRDataModel> arrayList = this.f54221b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final IJRDataModel getItem(int i2) {
        return this.f54221b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        IJRDataModel a2 = getItem(i2);
        if (view == null) {
            view = this.f54223d.inflate(R.layout.money_transfer_drop_down_item, viewGroup, false);
            C0971b bVar = new C0971b();
            bVar.f54226a = (RoboTextView) view.findViewById(R.id.txt_account_name);
            bVar.f54227b = (RoboTextView) view.findViewById(R.id.txt_account_number);
            bVar.f54228c = (RoboTextView) view.findViewById(R.id.txt_bank_name);
            view.setTag(bVar);
        }
        C0971b bVar2 = (C0971b) view.getTag();
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
                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                    String str4 = otherBankAccountDetail.accountHolderName;
                    String str5 = otherBankAccountDetail.bankName;
                    str = otherBankAccountDetail.accountNumber;
                    String str6 = str4;
                    str3 = str5;
                    str2 = str6;
                } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                    BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                    str2 = uPIAccountDetail.accountHolderName;
                    str = uPIAccountDetail.vpa;
                }
            }
            str = str3;
            str2 = str;
        }
        bVar2.f54226a.setText(str2);
        if (com.paytm.utility.b.X(str)) {
            bVar2.f54227b.setText(str);
        } else {
            bVar2.f54227b.setText(com.paytm.utility.b.R(str));
        }
        if (!TextUtils.isEmpty(str3)) {
            bVar2.f54228c.setVisibility(0);
            bVar2.f54228c.setText(str3);
        } else {
            bVar2.f54228c.setVisibility(8);
        }
        return view;
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.a.b$b  reason: collision with other inner class name */
    public class C0971b {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f54226a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f54227b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f54228c;

        public C0971b() {
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
                Iterator it2 = b.this.f54220a.iterator();
                while (it2.hasNext()) {
                    IJRDataModel iJRDataModel = (IJRDataModel) it2.next();
                    if (iJRDataModel instanceof UpiDBTransactionModel) {
                        UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) iJRDataModel;
                        if (!TextUtils.isEmpty(upiDBTransactionModel.getBeneficiary_name()) && upiDBTransactionModel.getTxn_mode().trim().startsWith(charSequence.toString().trim())) {
                            arrayList.add(iJRDataModel);
                        }
                    } else if (iJRDataModel instanceof BeneficiaryEntity) {
                        BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) iJRDataModel;
                        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                            if (beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber.trim().startsWith(charSequence.toString().trim())) {
                                arrayList.add(iJRDataModel);
                            }
                        } else if (beneficiaryEntity.instrumentPreferences.upi != null && beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa.trim().toLowerCase().startsWith(charSequence.toString().trim().toLowerCase())) {
                            arrayList.add(iJRDataModel);
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
            ArrayList unused = b.this.f54221b = (ArrayList) filterResults.values;
            b.this.notifyDataSetChanged();
        }
    }

    public final Filter getFilter() {
        if (this.f54224e == null) {
            this.f54224e = new a();
        }
        return this.f54224e;
    }
}
