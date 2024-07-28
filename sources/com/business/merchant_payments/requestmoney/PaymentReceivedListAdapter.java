package com.business.merchant_payments.requestmoney;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.a;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BaseViewHolder;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.databinding.MpDotProgressBarLytBinding;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.payment.view.OnlineTxnDetailsActivity;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;

public class PaymentReceivedListAdapter extends RecyclerView.a<BaseViewHolder> {
    public final int ITEM = 1;
    public final int LOADER = 2;
    public boolean isLoadingAdded = false;
    public Context mContext;
    public ArrayList<Object> paymentReceivedList;

    public PaymentReceivedListAdapter(Context context, ArrayList<Object> arrayList) {
        this.paymentReceivedList = arrayList;
        this.mContext = context;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 1) {
            return new PaymentReceivedViewHolder(from.inflate(R.layout.mp_payment_received_item, viewGroup, false));
        }
        if (i2 != 2) {
            return null;
        }
        return new LoadingViewHolder(this, (MpDotProgressBarLytBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.mp_dot_progress_bar_lyt, viewGroup, false));
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        int itemViewType = getItemViewType(i2);
        Object obj = this.paymentReceivedList.get(i2);
        if (itemViewType == 1) {
            baseViewHolder.bindData(obj, i2);
        } else if (itemViewType == 2) {
            baseViewHolder.bindData(obj, i2);
        }
    }

    public int getItemCount() {
        return this.paymentReceivedList.size();
    }

    public void addLoadingFooter() {
        this.isLoadingAdded = true;
        this.paymentReceivedList.add("LOADER");
        notifyItemInserted(this.paymentReceivedList.size() - 1);
    }

    public void removeLoadingFooter() {
        this.isLoadingAdded = false;
        int size = this.paymentReceivedList.size() - 1;
        if (getItem(size) != null) {
            this.paymentReceivedList.remove(size);
            notifyItemRemoved(size);
        }
    }

    public int getItemViewType(int i2) {
        Object obj = this.paymentReceivedList.get(i2);
        if (obj instanceof OrderDetailV2Model) {
            return 1;
        }
        if (!(obj instanceof String) || !((String) obj).contentEquals("LOADER")) {
            return super.getItemViewType(i2);
        }
        return 2;
    }

    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.paymentReceivedList;
        if (arrayList == null || i2 >= arrayList.size() || i2 < 0) {
            return null;
        }
        return this.paymentReceivedList.get(i2);
    }

    public class PaymentReceivedViewHolder extends BaseViewHolder {
        public CustomTextView amount;
        public CustomTextView colonSeparator;
        public CustomTextView date;
        public CustomTextView mobile;
        public CustomTextView payMethod;
        public AppCompatImageView payMethodIcon;
        public View root;
        public CustomTextView time;

        public PaymentReceivedViewHolder(View view) {
            super(view);
            this.root = view;
            this.amount = (CustomTextView) view.findViewById(R.id.payment_list_amount);
            this.mobile = (CustomTextView) view.findViewById(R.id.payment_list_mobile);
            this.colonSeparator = (CustomTextView) view.findViewById(R.id.colon_separator);
            this.payMethod = (CustomTextView) view.findViewById(R.id.tv_pay_method);
            this.payMethodIcon = (AppCompatImageView) view.findViewById(R.id.iv_pay_method);
            this.date = (CustomTextView) view.findViewById(R.id.payment_list_date);
            this.time = (CustomTextView) view.findViewById(R.id.payment_list_time);
        }

        public Spannable getAmount(String str) {
            return AppUtility.formattedPrice(0.7f, str, b.c(PaymentReceivedListAdapter.this.mContext, R.color.new_text_color), true);
        }

        public void bindData(Object obj, int i2) {
            final OrderDetailV2Model orderDetailV2Model = (OrderDetailV2Model) PaymentReceivedListAdapter.this.paymentReceivedList.get(i2);
            this.root.setOnClickListener(new a() {
                public void executeOnClick(View view) {
                    Intent intent = new Intent(PaymentReceivedListAdapter.this.mContext, OnlineTxnDetailsActivity.class);
                    intent.putExtra(AppConstants.TRANSACTION_OBJECT_V2, orderDetailV2Model);
                    intent.putExtra(AppConstants.SCREEN_NAME, AppConstants.PAYMENTS_LINK_RECV_SCREEN);
                    Context context = PaymentReceivedListAdapter.this.mContext;
                    if (context != null) {
                        context.startActivity(intent);
                    }
                }
            });
            if (orderDetailV2Model.getPayMoneyAmount() != null) {
                this.amount.setVisibility(0);
                this.amount.setText(getAmount(AppUtility.formatDecimalIntegerNumber(Double.valueOf(Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue()) / 100.0d).doubleValue(), AppConstants.PRICE_PATTERN)));
            } else {
                this.amount.setVisibility(8);
            }
            if (!(orderDetailV2Model.getAdditionalInfo() == null || orderDetailV2Model.getAdditionalInfo().getPayMethodIconUrl() == null)) {
                this.payMethod.setText(orderDetailV2Model.getAdditionalInfo().getPayMethod());
                w.a().a(orderDetailV2Model.getAdditionalInfo().getPayMethodIconUrl()).a((ImageView) this.payMethodIcon, (e) null);
            }
            if (orderDetailV2Model.getAdditionalInfo() != null && orderDetailV2Model.getAdditionalInfo().getPayMethod() != null && orderDetailV2Model.getAdditionalInfo().getPayMethod().equals("UPI")) {
                this.colonSeparator.setVisibility(0);
                this.mobile.setText(orderDetailV2Model.getAdditionalInfo().getVirtualPaymentAddr());
            } else if (!TextUtils.isEmpty(orderDetailV2Model.getOppositePhone())) {
                this.colonSeparator.setVisibility(0);
                this.mobile.setText(AppUtility.getMaskedMobileNumber(orderDetailV2Model.getOppositePhone()));
            } else {
                this.colonSeparator.setVisibility(8);
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getOrderCompletedTime())) {
                try {
                    String[] split = AppUtility.dateFormatter("yyyy-MM-dd'T'HH:mm:ss", AppConstants.PAYMENTLIN_DATE_FORMAT, orderDetailV2Model.getOrderCreatedTime()).split("-");
                    if (split != null && split.length > 2) {
                        String str = split[0] + "th " + split[1];
                        String str2 = split[2];
                        this.date.setText(str);
                        this.time.setText(str2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class LoadingViewHolder extends BaseViewHolder {
        public String jsonFile = "blue_dotted_progress.json";
        public MpDotProgressBarLytBinding mBinding;

        public LoadingViewHolder(PaymentReceivedListAdapter paymentReceivedListAdapter, MpDotProgressBarLytBinding mpDotProgressBarLytBinding) {
            super(mpDotProgressBarLytBinding.getRoot());
            this.mBinding = mpDotProgressBarLytBinding;
        }

        public void bindData(Object obj, int i2) {
            this.mBinding.animationView.setAnimation(this.jsonFile);
            this.mBinding.animationView.loop(true);
            this.mBinding.animationView.playAnimation();
        }
    }

    public void addMoreItems(ArrayList<Object> arrayList) {
        int size = this.paymentReceivedList.size();
        this.paymentReceivedList.addAll(arrayList);
        notifyItemRangeInserted(size, arrayList.size());
    }
}
