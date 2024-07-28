package net.one97.paytm.nativesdk.bank_mandate.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateStateItemBinding;

public class BankMandateStateCityBrAdapter extends RecyclerView.a<StateCityBrViewHolder> implements Filterable {
    /* access modifiers changed from: private */
    public ArrayList<String> mFilteredBankList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<String> mList;
    private ListFilter mListFilter;

    public long getItemId(int i2) {
        return (long) i2;
    }

    public BankMandateStateCityBrAdapter(Context context, ArrayList<String> arrayList) {
        this.mList = arrayList;
        ArrayList<String> arrayList2 = this.mList;
        if (arrayList2 != null) {
            this.mFilteredBankList.addAll(arrayList2);
        }
    }

    public StateCityBrViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new StateCityBrViewHolder((NativesdkBankMandateStateItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.nativesdk_bank_mandate_state_item, viewGroup, false));
    }

    public void onBindViewHolder(StateCityBrViewHolder stateCityBrViewHolder, int i2) {
        stateCityBrViewHolder.bankMandateStateItemBinding.tvStateItem.setText(this.mFilteredBankList.get(i2));
    }

    public int getItemCount() {
        ArrayList<String> arrayList = this.mFilteredBankList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Filter getFilter() {
        if (this.mListFilter == null) {
            this.mListFilter = new ListFilter();
        }
        return this.mListFilter;
    }

    class ListFilter extends Filter {
        private ListFilter() {
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = BankMandateStateCityBrAdapter.this.mList;
                filterResults.count = BankMandateStateCityBrAdapter.this.mList.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = BankMandateStateCityBrAdapter.this.mList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!TextUtils.isEmpty(str) && str.toUpperCase().trim().contains(charSequence.toString().toUpperCase().trim())) {
                        arrayList.add(str);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList unused = BankMandateStateCityBrAdapter.this.mFilteredBankList = (ArrayList) filterResults.values;
            BankMandateStateCityBrAdapter.this.notifyDataSetChanged();
        }
    }

    class StateCityBrViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public NativesdkBankMandateStateItemBinding bankMandateStateItemBinding;

        public StateCityBrViewHolder(NativesdkBankMandateStateItemBinding nativesdkBankMandateStateItemBinding) {
            super(nativesdkBankMandateStateItemBinding.getRoot());
            this.bankMandateStateItemBinding = nativesdkBankMandateStateItemBinding;
        }
    }

    public List<String> getList() {
        return this.mFilteredBankList;
    }
}
