package net.one97.paytm.nativesdk.bank_mandate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateSectionWrapper;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateListProviderItemBinding;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateSectionItemBinding;

public class AllBankMandateListAdapter extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    private int CHILD_VIEW_TYPE = 2;
    private int SECTION_VIEW_TYPE = 1;
    /* access modifiers changed from: private */
    public List<BankMandateSectionWrapper> filteredSectionWrappers = new ArrayList();
    private Context mContext;
    private ArrayList<Integer> mSectionPositions = new ArrayList<>();
    /* access modifiers changed from: private */
    public List<BankMandateSectionWrapper> sectionWrappers = new ArrayList();

    public int getSectionForPosition(int i2) {
        return 0;
    }

    public AllBankMandateListAdapter(Context context, List<BankMandateSectionWrapper> list) {
        this.filteredSectionWrappers.addAll(list);
        this.sectionWrappers.addAll(list);
        this.mContext = context;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.SECTION_VIEW_TYPE) {
            return new SectionViewHolder((NativesdkBankMandateSectionItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.nativesdk_bank_mandate_section_item, viewGroup, false));
        }
        return new AllBankMandateViewHolder((NativesdkBankMandateListProviderItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.nativesdk_bank_mandate_list_provider_item, viewGroup, false));
    }

    public class SectionViewHolder extends RecyclerView.v {
        private NativesdkBankMandateSectionItemBinding mBinding;

        public SectionViewHolder(NativesdkBankMandateSectionItemBinding nativesdkBankMandateSectionItemBinding) {
            super(nativesdkBankMandateSectionItemBinding.getRoot());
            this.mBinding = nativesdkBankMandateSectionItemBinding;
        }

        public void bind(BankMandateSectionWrapper bankMandateSectionWrapper) {
            this.mBinding.setSection(bankMandateSectionWrapper);
            this.mBinding.executePendingBindings();
        }
    }

    public class AllBankMandateViewHolder extends RecyclerView.v {
        private ImageView imageView;
        /* access modifiers changed from: private */
        public NativesdkBankMandateListProviderItemBinding mBinding;

        public AllBankMandateViewHolder(NativesdkBankMandateListProviderItemBinding nativesdkBankMandateListProviderItemBinding) {
            super(nativesdkBankMandateListProviderItemBinding.getRoot());
            this.mBinding = nativesdkBankMandateListProviderItemBinding;
        }

        public void bind(BankMandateSectionWrapper bankMandateSectionWrapper) {
            this.mBinding.setBankMandate(bankMandateSectionWrapper);
            this.mBinding.executePendingBindings();
        }
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof AllBankMandateViewHolder) {
            PayChannelOptions childSections = this.filteredSectionWrappers.get(i2).getChildSections();
            AllBankMandateViewHolder allBankMandateViewHolder = (AllBankMandateViewHolder) vVar;
            allBankMandateViewHolder.bind(this.filteredSectionWrappers.get(i2));
            if (childSections != null) {
                allBankMandateViewHolder.mBinding.tvBankName.setText(childSections.getChannelName());
                b.b(this.mContext).a(childSections.getIconUrl()).a(allBankMandateViewHolder.mBinding.ivBmBankIcon);
            }
        } else if (vVar instanceof SectionViewHolder) {
            ((SectionViewHolder) vVar).bind(this.filteredSectionWrappers.get(i2));
        }
    }

    public int getItemCount() {
        return this.filteredSectionWrappers.size();
    }

    public int getItemViewType(int i2) {
        return this.filteredSectionWrappers.get(i2).isSectionHeader() ? this.SECTION_VIEW_TYPE : this.CHILD_VIEW_TYPE;
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String lowerCase = charSequence.toString().toLowerCase();
                List arrayList = new ArrayList();
                if (lowerCase.isEmpty()) {
                    arrayList = AllBankMandateListAdapter.this.sectionWrappers;
                } else {
                    for (BankMandateSectionWrapper bankMandateSectionWrapper : AllBankMandateListAdapter.this.sectionWrappers) {
                        if (!bankMandateSectionWrapper.isSectionHeader() && bankMandateSectionWrapper.getChildSections().getChannelName().toLowerCase().contains(lowerCase)) {
                            arrayList.add(bankMandateSectionWrapper);
                        }
                    }
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = AllBankMandateListAdapter.this.filteredSectionWrappers = (ArrayList) filterResults.values;
                AllBankMandateListAdapter.this.notifyDataSetChanged();
            }
        };
    }

    public List<BankMandateSectionWrapper> getList() {
        return this.filteredSectionWrappers;
    }

    public Object[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        this.mSectionPositions = new ArrayList<>(26);
        int size = this.filteredSectionWrappers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.filteredSectionWrappers.get(i2).isSectionHeader()) {
                String upperCase = String.valueOf(this.filteredSectionWrappers.get(i2).getChildSections().getChannelName().charAt(0)).toUpperCase();
                if (!arrayList.contains(upperCase)) {
                    arrayList.add(upperCase);
                    this.mSectionPositions.add(Integer.valueOf(i2));
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public int getPositionForSection(int i2) {
        return this.mSectionPositions.get(i2).intValue();
    }
}
