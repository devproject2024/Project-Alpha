package com.business.merchant_payments.payment.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.business.merchant_payments.BaseViewHolder;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.MPBaseAdapterDiffCallback;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpPaymentsHeaderLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsListEmptyLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsLoaderLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsShowMoreLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsSummaryLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsTransactionItemBinding;
import com.business.merchant_payments.databinding.MpPaymentssSummeryItemBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import com.business.merchant_payments.payment.model.PaymentsEmptyModel;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;
import com.business.merchant_payments.payment.model.PaymentsLoaderModel;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;

public final class PaymentsListRvAdapter extends RecyclerView.a<RecyclerView.v> {
    public final Context mContext;
    public final ArrayList<Object> mList;
    public final PaymentsRVListener mListener;

    public interface PaymentsRVListener {
        void onShowMoreClick(PaymentsShowMoreModel paymentsShowMoreModel);

        void onTransactionItemClick(OrderDetail orderDetail);

        void onViewPastPaymentsClick();
    }

    public PaymentsListRvAdapter(Context context, ArrayList<Object> arrayList, PaymentsRVListener paymentsRVListener) {
        k.d(context, "mContext");
        k.d(arrayList, "list");
        k.d(paymentsRVListener, "mListener");
        this.mContext = context;
        this.mListener = paymentsRVListener;
        this.mList = new ArrayList<>(arrayList);
    }

    public enum CardType {
        HEADER(0),
        SUMMARY(1),
        TRANSACTION_ITEM(2),
        SHOW_MORE(3),
        EMPTY_LAYOUT(4),
        LOADER(5),
        AGGREGATE_SUMMARY(6);
        
        public final int value;

        /* access modifiers changed from: public */
        CardType(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final int getItemViewType(int i2) {
        Object obj = this.mList.get(i2);
        if (obj instanceof PaymentsHeaderModel) {
            return CardType.HEADER.getValue();
        }
        if (obj instanceof PaymentsSummaryModel) {
            return CardType.SUMMARY.getValue();
        }
        if (obj instanceof PaymentsTransactionModel) {
            return CardType.TRANSACTION_ITEM.getValue();
        }
        if (obj instanceof PaymentsShowMoreModel) {
            return CardType.SHOW_MORE.getValue();
        }
        if (obj instanceof PaymentsEmptyModel) {
            return CardType.EMPTY_LAYOUT.getValue();
        }
        if (obj instanceof PaymentsLoaderModel) {
            return CardType.LOADER.getValue();
        }
        if (obj instanceof SummaryDateRangeViewData) {
            return CardType.AGGREGATE_SUMMARY.getValue();
        }
        return 0;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.d(viewGroup, "parent");
        if (i2 == CardType.HEADER.getValue()) {
            MpPaymentsHeaderLayoutBinding inflate = MpPaymentsHeaderLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate, "MpPaymentsHeaderLayoutBi…mContext), parent, false)");
            return new HeaderLayoutViewHolder(this, inflate);
        } else if (i2 == CardType.SUMMARY.getValue()) {
            MpPaymentsSummaryLayoutBinding inflate2 = MpPaymentsSummaryLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate2, "MpPaymentsSummaryLayoutB…mContext), parent, false)");
            return new SummaryLayoutViewHolder(this, inflate2);
        } else if (i2 == CardType.TRANSACTION_ITEM.getValue()) {
            MpPaymentsTransactionItemBinding inflate3 = MpPaymentsTransactionItemBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate3, "MpPaymentsTransactionIte…mContext), parent, false)");
            return new TransactionItemViewHolder(this, inflate3);
        } else if (i2 == CardType.EMPTY_LAYOUT.getValue()) {
            MpPaymentsListEmptyLayoutBinding inflate4 = MpPaymentsListEmptyLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate4, "MpPaymentsListEmptyLayou…mContext), parent, false)");
            return new PaymentsListEmptyViewHolder(this, inflate4);
        } else if (i2 == CardType.LOADER.getValue()) {
            MpPaymentsLoaderLayoutBinding inflate5 = MpPaymentsLoaderLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate5, "MpPaymentsLoaderLayoutBi…mContext), parent, false)");
            return new LoaderLayoutViewHolder(this, inflate5);
        } else if (i2 == CardType.AGGREGATE_SUMMARY.getValue()) {
            MpPaymentssSummeryItemBinding inflate6 = MpPaymentssSummeryItemBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate6, "MpPaymentssSummeryItemBi…mContext), parent, false)");
            return new SummeryLayoutViewHolder(this, inflate6);
        } else {
            MpPaymentsShowMoreLayoutBinding inflate7 = MpPaymentsShowMoreLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate7, "MpPaymentsShowMoreLayout…mContext), parent, false)");
            return new ShowMoreLayoutViewHolder(this, inflate7);
        }
    }

    public final int getItemCount() {
        return this.mList.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.d(vVar, "holder");
        if (vVar instanceof BaseViewHolder) {
            ((BaseViewHolder) vVar).bindData(this.mList.get(i2), i2);
        }
    }

    public final void updateRVAdapterList(ArrayList<Object> arrayList) {
        k.d(arrayList, "newList");
        h.b a2 = h.a(new MPBaseAdapterDiffCallback(this.mList, arrayList));
        k.b(a2, "DiffUtil.calculateDiff(diffCallback)");
        this.mList.clear();
        this.mList.addAll(arrayList);
        a2.a((RecyclerView.a) this);
    }

    public final class HeaderLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsHeaderLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderLayoutViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsHeaderLayoutBinding mpPaymentsHeaderLayoutBinding) {
            super(mpPaymentsHeaderLayoutBinding.getRoot());
            k.d(mpPaymentsHeaderLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsHeaderLayoutBinding;
        }

        public final MpPaymentsHeaderLayoutBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsHeaderModel) {
                this.mBinding.setModel((PaymentsHeaderModel) obj);
            }
        }
    }

    public final class SummaryLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsSummaryLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SummaryLayoutViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsSummaryLayoutBinding mpPaymentsSummaryLayoutBinding) {
            super(mpPaymentsSummaryLayoutBinding.getRoot());
            k.d(mpPaymentsSummaryLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsSummaryLayoutBinding;
        }

        public final MpPaymentsSummaryLayoutBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsSummaryModel) {
                this.mBinding.setModel((PaymentsSummaryModel) obj);
            }
        }
    }

    public final class TransactionItemViewHolder extends BaseViewHolder {
        public final MpPaymentsTransactionItemBinding mBinding;
        public final /* synthetic */ PaymentsListRvAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransactionItemViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsTransactionItemBinding mpPaymentsTransactionItemBinding) {
            super(mpPaymentsTransactionItemBinding.getRoot());
            k.d(mpPaymentsTransactionItemBinding, "mBinding");
            this.this$0 = paymentsListRvAdapter;
            this.mBinding = mpPaymentsTransactionItemBinding;
            mpPaymentsTransactionItemBinding.transactionRoot.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ TransactionItemViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    String str;
                    PaymentsTransactionModel model = this.this$0.getMBinding().getModel();
                    if (model != null) {
                        if (model.getOrderDetail().getMPayMode() != null) {
                            str = model.getOrderDetail().getMPayMode();
                            k.a((Object) str);
                        } else {
                            str = "";
                        }
                        String str2 = (model.getOrderDetail().getBizType() == null || !p.a(model.getOrderDetail().getBizType(), "REFUND", true)) ? "Not Refund" : "Refund";
                        String formattedDate = DateUtility.getFormattedDate(model.getOrderDetail().getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "dd MMMM yy");
                        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "Payment Date Range", "Payment Clicked", "", String.valueOf(model.getNo()) + ";" + str + ";;" + str2 + ";", "", model.getAmount() + ";" + str + ";" + formattedDate + String.valueOf(DateUtility.getDaysFromToday("dd MMMM yy", formattedDate)));
                        this.this$0.this$0.mListener.onTransactionItemClick(model.getOrderDetail());
                    }
                }
            });
        }

        public final MpPaymentsTransactionItemBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsTransactionModel) {
                this.mBinding.setModel((PaymentsTransactionModel) obj);
            }
        }
    }

    public final class ShowMoreLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsShowMoreLayoutBinding mBinding;
        public final /* synthetic */ PaymentsListRvAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowMoreLayoutViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsShowMoreLayoutBinding mpPaymentsShowMoreLayoutBinding) {
            super(mpPaymentsShowMoreLayoutBinding.getRoot());
            k.d(mpPaymentsShowMoreLayoutBinding, "mBinding");
            this.this$0 = paymentsListRvAdapter;
            this.mBinding = mpPaymentsShowMoreLayoutBinding;
            mpPaymentsShowMoreLayoutBinding.showMoreBtn.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ ShowMoreLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.mListener.onShowMoreClick(this.this$0.getMBinding().getModel());
                }
            });
            this.mBinding.showLessBtn.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ ShowMoreLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.mListener.onShowMoreClick(this.this$0.getMBinding().getModel());
                }
            });
        }

        public final MpPaymentsShowMoreLayoutBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsShowMoreModel) {
                this.mBinding.setModel((PaymentsShowMoreModel) obj);
            }
        }
    }

    public final class PaymentsListEmptyViewHolder extends RecyclerView.v {
        public final MpPaymentsListEmptyLayoutBinding mBinding;
        public final /* synthetic */ PaymentsListRvAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentsListEmptyViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsListEmptyLayoutBinding mpPaymentsListEmptyLayoutBinding) {
            super(mpPaymentsListEmptyLayoutBinding.getRoot());
            k.d(mpPaymentsListEmptyLayoutBinding, "mBinding");
            this.this$0 = paymentsListRvAdapter;
            this.mBinding = mpPaymentsListEmptyLayoutBinding;
            mpPaymentsListEmptyLayoutBinding.viewPastPayments.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PaymentsListEmptyViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.mListener.onViewPastPaymentsClick();
                }
            });
        }

        public final MpPaymentsListEmptyLayoutBinding getMBinding() {
            return this.mBinding;
        }
    }

    public final class SummeryLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentssSummeryItemBinding mBinding;
        public final /* synthetic */ PaymentsListRvAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SummeryLayoutViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentssSummeryItemBinding mpPaymentssSummeryItemBinding) {
            super(mpPaymentssSummeryItemBinding.getRoot());
            k.d(mpPaymentssSummeryItemBinding, "mBinding");
            this.this$0 = paymentsListRvAdapter;
            this.mBinding = mpPaymentssSummeryItemBinding;
        }

        public final MpPaymentssSummeryItemBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof SummaryDateRangeViewData) {
                SummaryDateRangeViewData summaryDateRangeViewData = (SummaryDateRangeViewData) obj;
                Double d2 = null;
                if (summaryDateRangeViewData.getTotalNoOfPayments() != null) {
                    TextView textView = this.mBinding.paymentsCount;
                    k.b(textView, "mBinding.paymentsCount");
                    String totalNoOfPayments = summaryDateRangeViewData.getTotalNoOfPayments();
                    textView.setText(String.valueOf(totalNoOfPayments != null ? Integer.valueOf(Integer.parseInt(totalNoOfPayments)) : null));
                } else {
                    TextView textView2 = this.mBinding.paymentsCount;
                    k.b(textView2, "mBinding.paymentsCount");
                    textView2.setText(" --");
                }
                if (summaryDateRangeViewData.getPaymentAmout() != null) {
                    String paymentAmout = summaryDateRangeViewData.getPaymentAmout();
                    if (paymentAmout != null) {
                        d2 = Double.valueOf(Double.parseDouble(paymentAmout));
                    }
                    k.a((Object) d2);
                    String formatNumber = AppUtility.formatNumber(String.valueOf(d2.doubleValue()), AppConstants.PRICE_PATTERN);
                    TextView textView3 = this.mBinding.paymentsAmount;
                    k.b(textView3, "mBinding.paymentsAmount");
                    textView3.setText(this.this$0.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.getFormattedPrice(formatNumber, this.this$0.mContext));
                    return;
                }
                TextView textView4 = this.mBinding.paymentsAmount;
                k.b(textView4, "mBinding.paymentsAmount");
                textView4.setText(" --");
            }
        }
    }

    public final class LoaderLayoutViewHolder extends RecyclerView.v {
        public final MpPaymentsLoaderLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoaderLayoutViewHolder(PaymentsListRvAdapter paymentsListRvAdapter, MpPaymentsLoaderLayoutBinding mpPaymentsLoaderLayoutBinding) {
            super(mpPaymentsLoaderLayoutBinding.getRoot());
            k.d(mpPaymentsLoaderLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsLoaderLayoutBinding;
        }

        public final MpPaymentsLoaderLayoutBinding getMBinding() {
            return this.mBinding;
        }
    }
}
