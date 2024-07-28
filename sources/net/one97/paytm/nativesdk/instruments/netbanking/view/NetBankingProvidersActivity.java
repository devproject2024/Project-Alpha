package net.one97.paytm.nativesdk.instruments.netbanking.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.g;
import com.android.volley.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBinding;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.instruments.netbanking.adapter.AllNetBankingListAdaper;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingProviderListner;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.RecyclerItemClickListner;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;
import net.one97.paytm.nativesdk.instruments.netbanking.util.NetBankingChannelComparator;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel;

public class NetBankingProvidersActivity extends BaseActivity implements NetBankingProviderListner {
    /* access modifiers changed from: private */
    public AllNetBankingListAdaper allNetBankingListAdaper;
    /* access modifiers changed from: private */
    public AllNetBankingListViewModel allNetBankingListViewModel;
    private List<PayChannelOptions> enabledNBList;
    private boolean isFromEmi = false;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    /* access modifiers changed from: private */
    public NativeSdkNetbankingBankListBinding lytNetbankingBankListBinding;
    private NbPayOption nbPayOption;
    private List<SectionWrapper> sectionWrapper = new ArrayList();

    public void onNetworkUnavailable(Request request) {
    }

    public boolean shouldKillActivity() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra(SDKConstants.IS_CASHIER_SHEET, true);
        this.lytNetbankingBankListBinding = (NativeSdkNetbankingBankListBinding) f.a(this, R.layout.native_sdk_netbanking_bank_list);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        if (getIntent() != null && getIntent().getBooleanExtra("fromemi", false)) {
            this.isFromEmi = true;
        }
        this.allNetBankingListViewModel = new AllNetBankingListViewModel(this, this.isFromEmi, this, booleanExtra);
        this.lytNetbankingBankListBinding.setAllNetBankingViewModel(this.allNetBankingListViewModel);
        this.isLoggedIn = getIntent().getBooleanExtra("a", false);
    }

    public void onEmptyList() {
        this.lytNetbankingBankListBinding.listEmptyLayoutContainer.setVisibility(0);
        this.allNetBankingListViewModel.netbakingRecyclerVisiblity.set(8);
    }

    public void onNonEmptyList() {
        this.lytNetbankingBankListBinding.listEmptyLayoutContainer.setVisibility(8);
        this.allNetBankingListViewModel.netbakingRecyclerVisiblity.set(0);
    }

    public void onNetBankingListReceived(NbPayOption nbPayOption2) {
        if (nbPayOption2 == null) {
            onEmptyList();
            return;
        }
        onNonEmptyList();
        this.nbPayOption = nbPayOption2;
        this.allNetBankingListViewModel.setPayMode(nbPayOption2.getPaymentMode());
        initAdapter();
        initAdapterIndex();
        this.lytNetbankingBankListBinding.searchView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    NetBankingProvidersActivity.this.lytNetbankingBankListBinding.imgEdtCross.setVisibility(8);
                } else {
                    NetBankingProvidersActivity.this.lytNetbankingBankListBinding.imgEdtCross.setVisibility(0);
                }
                if (NetBankingProvidersActivity.this.allNetBankingListAdaper != null) {
                    NetBankingProvidersActivity.this.allNetBankingListAdaper.getFilter().filter(charSequence);
                }
            }
        });
        this.lytNetbankingBankListBinding.imgEdtCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NetBankingProvidersActivity.this.lytNetbankingBankListBinding.searchView.setText("");
            }
        });
    }

    private void preparedata() {
        TreeMap treeMap = new TreeMap();
        for (PayChannelOptions next : this.enabledNBList) {
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
            this.sectionWrapper.add(new SectionWrapper(true, (PayChannelOptions) null, (String) entry.getKey()));
            for (PayChannelOptions sectionWrapper2 : (List) entry.getValue()) {
                this.sectionWrapper.add(new SectionWrapper(false, sectionWrapper2, ""));
            }
        }
    }

    private boolean toShowEmiOption(PayChannelOptions payChannelOptions) {
        if (!(payChannelOptions == null || payChannelOptions.getMinAmount() == null || payChannelOptions.getMaxAmount() == null)) {
            double parseDouble = SDKUtility.parseDouble(payChannelOptions.getMinAmount().getValue());
            double parseDouble2 = SDKUtility.parseDouble(payChannelOptions.getMaxAmount().getValue());
            if (DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                if (SDKUtility.getDiffAmount() < parseDouble || SDKUtility.getDiffAmount() > parseDouble2) {
                    return false;
                }
                return true;
            } else if (SDKUtility.getDiffAmount() < parseDouble || SDKUtility.getDiffAmount() > parseDouble2) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private void initAdapter() {
        ArrayList<PayChannelOptions> payChannelOptions = this.nbPayOption.getPayChannelOptions();
        this.enabledNBList = new ArrayList();
        if (payChannelOptions != null) {
            if (this.isFromEmi) {
                for (PayChannelOptions next : payChannelOptions) {
                    if (next.getChannelName() != null && toShowEmiOption(next)) {
                        this.enabledNBList.add(next);
                    }
                }
            } else {
                for (PayChannelOptions next2 : payChannelOptions) {
                    if (next2.getChannelName() != null) {
                        this.enabledNBList.add(next2);
                    }
                }
            }
        }
        Collections.sort(this.enabledNBList, new NetBankingChannelComparator());
        preparedata();
        this.lytNetbankingBankListBinding.rvBankList.setLayoutManager(new LinearLayoutManager(this));
        this.lytNetbankingBankListBinding.rvBankList.setItemAnimator(new g());
        List<SectionWrapper> list = this.sectionWrapper;
        if (list != null) {
            tickAllreadySelected(list);
            this.allNetBankingListAdaper = new AllNetBankingListAdaper(this, this.sectionWrapper, this);
        }
        this.lytNetbankingBankListBinding.rvBankList.setAdapter(this.allNetBankingListAdaper);
        registerOnItemClickOnRecyclerView();
    }

    private void tickAllreadySelected(List<SectionWrapper> list) {
        try {
            for (SectionWrapper next : list) {
                if (next.getChildSections() != null && next.getChildSections().getChannelName() != null && next.getChildSections().getChannelName().equalsIgnoreCase(getIntent().getStringExtra(CJRPGTransactionRequestUtils.PAYER_BANK_NAME))) {
                    next.greenTickVisible.set(true);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    private void initAdapterIndex() {
        this.lytNetbankingBankListBinding.rvBankList.setIndexTextSize(10);
        this.lytNetbankingBankListBinding.rvBankList.setIndexBarColor("#FFFFFF");
        this.lytNetbankingBankListBinding.rvBankList.setIndexBarCornerRadius(0);
        this.lytNetbankingBankListBinding.rvBankList.setTypeface(Typeface.SANS_SERIF);
        this.lytNetbankingBankListBinding.rvBankList.setIndexbarMargin(0.0f);
        this.lytNetbankingBankListBinding.rvBankList.setIndexbarWidth(40.0f);
        this.lytNetbankingBankListBinding.rvBankList.setPreviewPadding(0);
        this.lytNetbankingBankListBinding.rvBankList.setIndexBarTextColor("#999999");
        this.lytNetbankingBankListBinding.rvBankList.setIndexBarVisibility(true);
        this.lytNetbankingBankListBinding.rvBankList.setIndexBarHighLateTextVisibility(true);
    }

    private void registerOnItemClickOnRecyclerView() {
        this.lytNetbankingBankListBinding.rvBankList.addOnItemTouchListener(new RecyclerItemClickListner(this, new RecyclerItemClickListner.OnItemClickListener() {
            public void onItemClick(View view, int i2) {
                if (i2 != -1) {
                    SectionWrapper sectionWrapper = NetBankingProvidersActivity.this.allNetBankingListAdaper.getList().get(i2);
                    sectionWrapper.greenTickVisible.set(true);
                    if (!sectionWrapper.isSectionHeader()) {
                        PayChannelOptions childSections = sectionWrapper.getChildSections();
                        if (childSections.getIsDisabled() == null || !childSections.getIsDisabled().getStatus()) {
                            sectionWrapper.disableMessage.set("");
                            sectionWrapper.disableMessageVisibility.set(8);
                            NetBankingProvidersActivity.this.allNetBankingListViewModel.setSelectedInstrument(childSections);
                            if (!NetBankingProvidersActivity.this.isLoggedIn) {
                                NetBankingProvidersActivity.this.allNetBankingListViewModel.completeTransaction(NetBankingProvidersActivity.this);
                            } else {
                                NetBankingProvidersActivity.this.sendBroadcastOfSelection(childSections);
                            }
                        } else {
                            sectionWrapper.disableMessage.set(NetBankingProvidersActivity.this.getString(R.string.disable_paymode_error_message));
                            sectionWrapper.disableMessageVisibility.set(0);
                            sectionWrapper.greenTickVisible.set(false);
                            NetBankingProvidersActivity.this.allNetBankingListViewModel.setSelectedInstrument(childSections);
                        }
                    }
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void sendBroadcastOfSelection(PayChannelOptions payChannelOptions) {
        Intent intent = new Intent();
        intent.setAction(SDKConstants.NET_BANKING_ACTION_FILTER);
        BankData bankData = new BankData();
        bankData.setBankCode(payChannelOptions.getChannelCode());
        bankData.setBankName(payChannelOptions.getChannelName());
        bankData.setCardType(payChannelOptions.getEmiType());
        if (!(DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null)) {
            bankData.setBankLogoUrl(DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getIconBaseUrl() + payChannelOptions.getIconUrl());
        }
        intent.putExtra(EMIConstants.SELECTED_BANK, bankData);
        a.a(getApplicationContext()).a(intent);
        setResult(-1, intent);
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == i3) {
            finish();
        }
    }

    public void onProccedClick(View view, PayChannelOptions payChannelOptions) {
        this.allNetBankingListViewModel.setSelectedInstrument(payChannelOptions);
        sendBroadcastOfSelection(payChannelOptions);
        if (!this.isLoggedIn) {
            this.allNetBankingListViewModel.bankSelectedProceedClicked(view);
            return;
        }
        setResult(-1);
        finish();
    }

    public String getChildClassName() {
        return getLocalClassName();
    }

    public void onArrowClicked() {
        finish();
        overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_down);
    }

    public void saveActivityFromFinish(String str) {
        if (!str.equalsIgnoreCase(getChildClassName())) {
            finish();
        }
    }
}
