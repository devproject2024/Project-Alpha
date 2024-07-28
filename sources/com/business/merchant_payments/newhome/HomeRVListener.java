package com.business.merchant_payments.newhome;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import java.util.LinkedHashMap;

public interface HomeRVListener {
    RecyclerView.v getInactivateMerchantViewHolder(ViewGroup viewGroup);

    boolean isInactiveMerchantData(Object obj);

    void onBWSettlementItemClick(boolean z, int i2, SettlementBillListItemModel settlementBillListItemModel);

    void onCTAClick(CustomCardUIModel customCardUIModel, int i2);

    void onCardClosed(CustomCardUIModel customCardUIModel, int i2);

    void onCarryForwardBalanceClick(LinkedHashMap<String, String> linkedHashMap);

    void onCustomCardClick(CustomCardUIModel customCardUIModel, int i2);

    void onDateRangeDownloadStatementClick();

    void onDateRangeHeaderBackPressed();

    void onDisabledSettleNowInfoClicked();

    void onExpandBWPendingSummaryCard(boolean z);

    void onExpandBusinessWalletSummaryCard(boolean z, int i2);

    void onMDRChangesClick();

    void onPaymentsTabClick();

    void onSettleNowClick(String str);

    void onSettlementTabClick();

    void onSettlmentDateRangeClick();

    void onShowMoreClick();

    void onToggleCompressState(boolean z, int i2);

    void onTransactionItemClick(OrderDetail orderDetail);

    void onViewPastPaymentsClick();

    void showInstantSettlementCoachmark(View view);
}
