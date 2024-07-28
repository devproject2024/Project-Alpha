package net.one97.paytm.nativesdk.instruments.netbanking.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.h;
import com.bumptech.glide.i;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.databinding.NativesdkItemBankProviderListBinding;
import net.one97.paytm.nativesdk.databinding.NativesdkItemBankSectionBinding;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingProviderListner;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class AllNetBankingListAdaper extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    private int CHILD_VIEW_TYPE = 2;
    private int SECTION_VIEW_TYPE = 1;
    /* access modifiers changed from: private */
    public List<SectionWrapper> filteredSectionWrappers = new ArrayList();
    private Context mContext;
    private ArrayList<Integer> mSectionPositions = new ArrayList<>();
    /* access modifiers changed from: private */
    public NetBankingProviderListner netBankingProviderListner;
    /* access modifiers changed from: private */
    public List<SectionWrapper> sectionWrappers = new ArrayList();

    public int getSectionForPosition(int i2) {
        return 0;
    }

    public AllNetBankingListAdaper(Context context, List<SectionWrapper> list, NetBankingProviderListner netBankingProviderListner2) {
        this.filteredSectionWrappers.addAll(list);
        this.sectionWrappers.addAll(list);
        this.mContext = context;
        this.netBankingProviderListner = netBankingProviderListner2;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.SECTION_VIEW_TYPE) {
            return new SectionViewHolder((NativesdkItemBankSectionBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.nativesdk_item_bank_section, viewGroup, false));
        }
        return new NetBankingViewHolder((NativesdkItemBankProviderListBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.nativesdk_item_bank_provider_list, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        if (vVar instanceof NetBankingViewHolder) {
            PayChannelOptions childSections = this.filteredSectionWrappers.get(i2).getChildSections();
            if (DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null || TextUtils.isEmpty(DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getIconBaseUrl())) {
                ((NetBankingViewHolder) vVar).imageView.setImageResource(R.drawable.ic_paytm_payments_bank);
            } else {
                i b2 = b.b(this.mContext);
                b2.a(DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getIconBaseUrl() + this.filteredSectionWrappers.get(i2).getChildSections().getIconUrl()).b((a<?>) ((h) new h().a(R.drawable.ic_paytm_payments_bank)).c(R.drawable.ic_paytm_payments_bank)).a(((NetBankingViewHolder) vVar).imageView);
            }
            NetBankingViewHolder netBankingViewHolder = (NetBankingViewHolder) vVar;
            netBankingViewHolder.bind(this.filteredSectionWrappers.get(i2));
            if (TextUtils.isEmpty(childSections.getEmiType())) {
                netBankingViewHolder.mBinding.tvBankName.setText(childSections.getChannelName());
            } else {
                if (childSections.getEmiType().equalsIgnoreCase(SDKConstants.CREDIT)) {
                    RoboTextView roboTextView = netBankingViewHolder.mBinding.tvBankName;
                    roboTextView.setText(childSections.getChannelName() + " Credit Card");
                } else if (childSections.getEmiType().equalsIgnoreCase(SDKConstants.DEBIT)) {
                    RoboTextView roboTextView2 = netBankingViewHolder.mBinding.tvBankName;
                    roboTextView2.setText(childSections.getChannelName() + " Debit Card");
                } else if (childSections.getEmiType().equalsIgnoreCase("NBFC")) {
                    RoboTextView roboTextView3 = netBankingViewHolder.mBinding.tvBankName;
                    roboTextView3.setText(childSections.getChannelName() + " NBFC");
                }
                if (SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(childSections.getChannelCode())) {
                    netBankingViewHolder.mBinding.tvBankName.setText(childSections.getChannelName());
                }
            }
            if (childSections.getIsDisabled() == null || !childSections.getIsDisabled().getStatus()) {
                netBankingViewHolder.mBinding.tvDisableErrorMessage.setVisibility(8);
                netBankingViewHolder.mBinding.tvDisableErrorMessage.setText("");
                netBankingViewHolder.mBinding.tvBankName.setAlpha(1.0f);
                netBankingViewHolder.mBinding.ivBankIcon.setAlpha(1.0f);
            } else {
                netBankingViewHolder.mBinding.tvBankName.setAlpha(0.4f);
                netBankingViewHolder.mBinding.ivBankIcon.setAlpha(0.4f);
                netBankingViewHolder.mBinding.tvDisableErrorMessage.setVisibility(0);
                netBankingViewHolder.mBinding.tvDisableErrorMessage.setText(this.mContext.getString(R.string.disable_paymode_error_message));
            }
            if (childSections.getHasLowSuccess() != null) {
                TextView textView = netBankingViewHolder.mBinding.txtSuccessrate;
                if (childSections.getHasLowSuccess().getMsg() == null) {
                    charSequence = Html.fromHtml(this.mContext.getString(R.string.low_success_rate_msg, new Object[]{childSections.getChannelName()}));
                } else {
                    charSequence = childSections.getHasLowSuccess().getMsg();
                }
                textView.setText(charSequence);
            }
            if (childSections != null && childSections.getHasLowSuccess() != null && childSections.getHasLowSuccess().getStatus()) {
                netBankingViewHolder.mBinding.rlBankInfo.setVisibility(0);
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

    public class SectionViewHolder extends RecyclerView.v {
        private NativesdkItemBankSectionBinding mBinding;

        public SectionViewHolder(NativesdkItemBankSectionBinding nativesdkItemBankSectionBinding) {
            super(nativesdkItemBankSectionBinding.getRoot());
            this.mBinding = nativesdkItemBankSectionBinding;
        }

        public void bind(SectionWrapper sectionWrapper) {
            this.mBinding.setSection(sectionWrapper);
            this.mBinding.executePendingBindings();
        }
    }

    public class NetBankingViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public ImageView imageView;
        /* access modifiers changed from: private */
        public NativesdkItemBankProviderListBinding mBinding;

        public NetBankingViewHolder(NativesdkItemBankProviderListBinding nativesdkItemBankProviderListBinding) {
            super(nativesdkItemBankProviderListBinding.getRoot());
            this.mBinding = nativesdkItemBankProviderListBinding;
            this.imageView = nativesdkItemBankProviderListBinding.ivBankIcon;
        }

        public void bind(SectionWrapper sectionWrapper) {
            this.mBinding.setNetbanking(sectionWrapper);
            this.mBinding.executePendingBindings();
        }
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

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String lowerCase = charSequence.toString().toLowerCase();
                List arrayList = new ArrayList();
                if (lowerCase.isEmpty()) {
                    arrayList = AllNetBankingListAdaper.this.sectionWrappers;
                } else {
                    for (SectionWrapper sectionWrapper : AllNetBankingListAdaper.this.sectionWrappers) {
                        if (!sectionWrapper.isSectionHeader() && sectionWrapper.getChildSections().getChannelName().toLowerCase().contains(lowerCase)) {
                            arrayList.add(sectionWrapper);
                        }
                    }
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = AllNetBankingListAdaper.this.filteredSectionWrappers = (ArrayList) filterResults.values;
                if (AllNetBankingListAdaper.this.filteredSectionWrappers.size() <= 0) {
                    AllNetBankingListAdaper.this.netBankingProviderListner.onEmptyList();
                } else {
                    AllNetBankingListAdaper.this.netBankingProviderListner.onNonEmptyList();
                }
                AllNetBankingListAdaper.this.notifyDataSetChanged();
            }
        };
    }

    public List<SectionWrapper> getList() {
        return this.filteredSectionWrappers;
    }
}
