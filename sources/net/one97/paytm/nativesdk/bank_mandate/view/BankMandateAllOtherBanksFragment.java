package net.one97.paytm.nativesdk.bank_mandate.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.adapter.AllBankMandateListAdapter;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateSectionWrapper;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.databinding.FragmentAllBankMandateListBinding;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.RecyclerItemClickListner;

public class BankMandateAllOtherBanksFragment extends h {
    private static final String ARG_LIST = "BM_LIST";
    /* access modifiers changed from: private */
    public AllBankMandateListAdapter allBankMandateListAdapter;
    private List<PayChannelOptions> bankList;
    /* access modifiers changed from: private */
    public FragmentAllBankMandateListBinding lytBankMandateListBinding;
    /* access modifiers changed from: private */
    public OtherBankSelectedListener mListener;
    private List<BankMandateSectionWrapper> sectionWrapper = new ArrayList();

    public interface OtherBankSelectedListener {
        void onSelected(PayChannelOptions payChannelOptions);
    }

    public void setListener(OtherBankSelectedListener otherBankSelectedListener) {
        this.mListener = otherBankSelectedListener;
    }

    public static BankMandateAllOtherBanksFragment getInstance() {
        return new BankMandateAllOtherBanksFragment();
    }

    public static BankMandateAllOtherBanksFragment newInstance(ArrayList<PayChannelOptions> arrayList) {
        BankMandateAllOtherBanksFragment bankMandateAllOtherBanksFragment = new BankMandateAllOtherBanksFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_LIST, arrayList);
        bankMandateAllOtherBanksFragment.setArguments(bundle);
        return bankMandateAllOtherBanksFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.bankList = (List) getArguments().getSerializable(ARG_LIST);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lytBankMandateListBinding = (FragmentAllBankMandateListBinding) f.a(getLayoutInflater(), R.layout.fragment_all_bank_mandate_list, (ViewGroup) null, false);
        initAdapter();
        initAdapterIndex();
        this.lytBankMandateListBinding.searchView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    BankMandateAllOtherBanksFragment.this.lytBankMandateListBinding.imgEdtCross.setVisibility(8);
                } else {
                    BankMandateAllOtherBanksFragment.this.lytBankMandateListBinding.imgEdtCross.setVisibility(0);
                }
                if (BankMandateAllOtherBanksFragment.this.allBankMandateListAdapter != null) {
                    BankMandateAllOtherBanksFragment.this.allBankMandateListAdapter.getFilter().filter(charSequence);
                }
            }
        });
        this.lytBankMandateListBinding.imgEdtCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateAllOtherBanksFragment.this.lytBankMandateListBinding.searchView.setText("");
            }
        });
        this.lytBankMandateListBinding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateAllOtherBanksFragment.this.onBackPressed();
            }
        });
        return this.lytBankMandateListBinding.getRoot();
    }

    private void initAdapter() {
        List<PayChannelOptions> list = this.bankList;
        if (list != null && list.size() > 0) {
            preparedata();
        }
        this.lytBankMandateListBinding.rvBankList.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.lytBankMandateListBinding.rvBankList.setItemAnimator(new g());
        if (this.sectionWrapper != null) {
            this.allBankMandateListAdapter = new AllBankMandateListAdapter(getActivity(), this.sectionWrapper);
        }
        this.lytBankMandateListBinding.rvBankList.setAdapter(this.allBankMandateListAdapter);
        registerOnItemClickOnRecyclerView();
    }

    private void initAdapterIndex() {
        this.lytBankMandateListBinding.rvBankList.setIndexTextSize(10);
        this.lytBankMandateListBinding.rvBankList.setIndexBarColor("#FFFFFF");
        this.lytBankMandateListBinding.rvBankList.setIndexBarCornerRadius(0);
        this.lytBankMandateListBinding.rvBankList.setTypeface(Typeface.SANS_SERIF);
        this.lytBankMandateListBinding.rvBankList.setIndexbarMargin(0.0f);
        this.lytBankMandateListBinding.rvBankList.setIndexbarWidth(40.0f);
        this.lytBankMandateListBinding.rvBankList.setPreviewPadding(0);
        this.lytBankMandateListBinding.rvBankList.setIndexBarTextColor("#999999");
        this.lytBankMandateListBinding.rvBankList.setIndexBarVisibility(true);
        this.lytBankMandateListBinding.rvBankList.setIndexBarHighLateTextVisibility(true);
    }

    private void preparedata() {
        this.sectionWrapper.clear();
        TreeMap treeMap = new TreeMap();
        for (PayChannelOptions next : this.bankList) {
            StringBuilder sb = new StringBuilder();
            sb.append(next.getChannelName().charAt(0));
            if (treeMap.containsKey(sb.toString())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.getChannelName().charAt(0));
                ((List) treeMap.get(sb2.toString())).add(next);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(next.getChannelName().charAt(0));
                treeMap.put(sb3.toString(), arrayList);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            this.sectionWrapper.add(new BankMandateSectionWrapper(true, (PayChannelOptions) null, (String) entry.getKey()));
            for (PayChannelOptions bankMandateSectionWrapper : (List) entry.getValue()) {
                this.sectionWrapper.add(new BankMandateSectionWrapper(false, bankMandateSectionWrapper, ""));
            }
        }
    }

    private void registerOnItemClickOnRecyclerView() {
        this.lytBankMandateListBinding.rvBankList.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), new RecyclerItemClickListner.OnItemClickListener() {
            public void onItemClick(View view, int i2) {
                if (i2 != -1) {
                    BankMandateSectionWrapper bankMandateSectionWrapper = BankMandateAllOtherBanksFragment.this.allBankMandateListAdapter.getList().get(i2);
                    if (!bankMandateSectionWrapper.isSectionHeader()) {
                        BankMandateAllOtherBanksFragment.this.mListener.onSelected(bankMandateSectionWrapper.getChildSections());
                        j supportFragmentManager = BankMandateAllOtherBanksFragment.this.getActivity().getSupportFragmentManager();
                        if (supportFragmentManager != null) {
                            supportFragmentManager.d();
                        }
                    }
                }
            }
        }));
    }

    public void onBackPressed() {
        j supportFragmentManager = getActivity().getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.d();
        }
    }
}
