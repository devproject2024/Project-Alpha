package com.business.merchant_payments.requestmoney;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextInputLayout;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BaseViewHolder;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.databinding.MpDotProgressBarLytBinding;
import com.business.merchant_payments.databinding.MpRequestMoneyShimmerBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.requestpayment.PaymentLinkData;
import com.business.merchant_payments.requestmoney.RequestMoneyLinkAdapter;
import com.paytm.business.merchantprofile.common.utility.MerchantTypeToPPIMapperKt;
import com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork;
import com.paytm.utility.b;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RequestMoneyLinkAdapter extends RecyclerView.a<RecyclerView.v> {
    public static final int DOT_PROGRESS_LOADER = 4;
    public static final int LOADER = 2;
    public int VIEW_TYPE_HEADER = 1;
    public int VIEW_TYPE_ITEM = 3;
    public InputFilter amountFilter = new InputFilter(this) {
        public final int maxDigitsBeforeDecimalPoint = AppUtility.getRequestMoneyDigitCount();

        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            if (charSequence.toString().contentEquals("")) {
                return null;
            }
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder("(([1-9]{1})([0-9]{0,");
            sb3.append(this.maxDigitsBeforeDecimalPoint - 1);
            sb3.append("})?)(\\.[0-9]{0,2})?");
            if (sb2.matches(sb3.toString())) {
                return null;
            }
            if (charSequence.length() == 0) {
                return spanned.subSequence(i4, i5);
            }
            return "";
        }
    };
    public Context mContext;
    public List<Object> paymentReceivedList;
    public RequestMoneyLinkListner requestMoneyLinkListner;
    public boolean showDotProgress = false;

    public interface RequestMoneyLinkListner {
        void onCreateLinkClick(String str, String str2);

        void onLinkClicked(PaymentLinkData paymentLinkData);

        void onShareLinkClicked(PaymentLinkData paymentLinkData);
    }

    public RequestMoneyLinkAdapter(Context context, List<Object> list, RequestMoneyLinkListner requestMoneyLinkListner2) {
        this.paymentReceivedList = list;
        this.requestMoneyLinkListner = requestMoneyLinkListner2;
        this.mContext = context;
    }

    public void setPaymentReceivedList(List<PaymentLinkData> list) {
        if (this.paymentReceivedList.size() > 1) {
            List<Object> list2 = this.paymentReceivedList;
            list2.subList(1, list2.size()).clear();
        }
        this.paymentReceivedList.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemViewType(int i2) {
        Object obj = this.paymentReceivedList.get(i2);
        boolean z = obj instanceof String;
        if (z && ((String) obj).contentEquals("LOADER")) {
            return 4;
        }
        if (z && ((String) obj).contentEquals("SHIMMER")) {
            return 2;
        }
        if (z && ((String) obj).contentEquals("HEADER")) {
            return this.VIEW_TYPE_HEADER;
        }
        if (obj instanceof PaymentLinkData) {
            return this.VIEW_TYPE_ITEM;
        }
        return super.getItemViewType(i2);
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.VIEW_TYPE_HEADER) {
            return new RequestMoneyHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp_request_money_static, viewGroup, false));
        }
        if (i2 == 2 && this.showDotProgress) {
            return new LoadingViewHolder(this, (MpRequestMoneyShimmerBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.mp_request_money_shimmer, viewGroup, false));
        }
        if (i2 == 4) {
            return new DotLoadingViewHolder(this, (MpDotProgressBarLytBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.mp_dot_progress_bar_lyt, viewGroup, false));
        }
        if (i2 == this.VIEW_TYPE_ITEM) {
            return new RequestMoneyLinkViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp_request_money_list_item, viewGroup, false));
        }
        return null;
    }

    public void addMoreItems(List<PaymentLinkData> list) {
        int size = this.paymentReceivedList.size();
        this.paymentReceivedList.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof RequestMoneyLinkViewHolder) {
            RequestMoneyLinkViewHolder requestMoneyLinkViewHolder = (RequestMoneyLinkViewHolder) vVar;
            PaymentLinkData paymentLinkData = (PaymentLinkData) this.paymentReceivedList.get(i2);
            requestMoneyLinkViewHolder.description.setText(paymentLinkData.getLinkDescription());
            if (!TextUtils.isEmpty(paymentLinkData.getCreatedDate())) {
                String[] split = new SimpleDateFormat(AppConstants.PAYMENTLIN_DATE_FORMAT, new Locale(b.a(this.mContext))).format(new Date(new Timestamp(Long.parseLong(paymentLinkData.getCreatedDate())).getTime())).split("-");
                if (split != null && split.length > 2) {
                    split[0] = AppUtility.getDateWithSuffix(split[0]);
                    String str = split[0] + " " + split[1];
                    String str2 = split[2];
                    requestMoneyLinkViewHolder.date.setText(str);
                    requestMoneyLinkViewHolder.time.setText(str2);
                }
            }
            requestMoneyLinkViewHolder.amount.setText(AppUtility.formattedPrice(0.7f, this.mContext.getString(R.string.mp_rupee_symbol) + " " + paymentLinkData.getAmount(), androidx.core.content.b.c(this.mContext, R.color.new_text_color), true));
            if (PaymentsConfig.getInstance().getMerchantDataProvider().u()) {
                requestMoneyLinkViewHolder.shareLinkIV.setVisibility(0);
                requestMoneyLinkViewHolder.shareLinkIV.setOnClickListener(new View.OnClickListener(paymentLinkData) {
                    private final /* synthetic */ PaymentLinkData f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        RequestMoneyLinkAdapter.this.lambda$onBindViewHolder$0$RequestMoneyLinkAdapter(this.f$1, view);
                    }
                });
            }
            requestMoneyLinkViewHolder.layoutItem.setOnClickListener(new View.OnClickListener(paymentLinkData) {
                private final /* synthetic */ PaymentLinkData f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RequestMoneyLinkAdapter.this.lambda$onBindViewHolder$1$RequestMoneyLinkAdapter(this.f$1, view);
                }
            });
        } else if (vVar instanceof RequestMoneyHeaderViewHolder) {
            RequestMoneyHeaderViewHolder requestMoneyHeaderViewHolder = (RequestMoneyHeaderViewHolder) vVar;
            if (this.paymentReceivedList.size() == 1) {
                requestMoneyHeaderViewHolder.mRecyclerViewTitle.setVisibility(8);
            } else {
                requestMoneyHeaderViewHolder.mRecyclerViewTitle.setVisibility(0);
            }
        } else if (vVar instanceof LoadingViewHolder) {
            ((LoadingViewHolder) vVar).bindData((Object) null, i2);
        } else if (vVar instanceof DotLoadingViewHolder) {
            ((DotLoadingViewHolder) vVar).bindData((Object) null, i2);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$RequestMoneyLinkAdapter(PaymentLinkData paymentLinkData, View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "Accept Payment", "Request Money", "", "Payment_link_share");
        this.requestMoneyLinkListner.onShareLinkClicked(paymentLinkData);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$RequestMoneyLinkAdapter(PaymentLinkData paymentLinkData, View view) {
        this.requestMoneyLinkListner.onLinkClicked(paymentLinkData);
    }

    public int getItemCount() {
        return this.paymentReceivedList.size();
    }

    public void addLoadingFooter() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                RequestMoneyLinkAdapter.this.paymentReceivedList.add("LOADER");
                RequestMoneyLinkAdapter requestMoneyLinkAdapter = RequestMoneyLinkAdapter.this;
                requestMoneyLinkAdapter.notifyItemInserted(requestMoneyLinkAdapter.paymentReceivedList.size() - 1);
            }
        }, 50);
    }

    public void removeLoadingFooter() {
        int size = this.paymentReceivedList.size() - 1;
        if (getItem(size) != null) {
            this.paymentReceivedList.remove(size);
            notifyItemRemoved(size);
        }
    }

    public Object getItem(int i2) {
        List<Object> list = this.paymentReceivedList;
        if (list == null || i2 >= list.size() || i2 < 0) {
            return null;
        }
        return this.paymentReceivedList.get(i2);
    }

    public class LoadingViewHolder extends BaseViewHolder {
        public MpRequestMoneyShimmerBinding mBinding;

        public LoadingViewHolder(RequestMoneyLinkAdapter requestMoneyLinkAdapter, MpRequestMoneyShimmerBinding mpRequestMoneyShimmerBinding) {
            super(mpRequestMoneyShimmerBinding.getRoot());
            this.mBinding = mpRequestMoneyShimmerBinding;
        }

        public void bindData(Object obj, int i2) {
            this.mBinding.requestMoneyShimmer.startShimmer();
        }
    }

    public void onViewAttachedToWindow(RecyclerView.v vVar) {
        if (vVar instanceof LoadingViewHolder) {
            ((LoadingViewHolder) vVar).mBinding.requestMoneyShimmer.startShimmer();
        }
        super.onViewAttachedToWindow(vVar);
    }

    public void onViewDetachedFromWindow(RecyclerView.v vVar) {
        if (vVar instanceof LoadingViewHolder) {
            ((LoadingViewHolder) vVar).mBinding.requestMoneyShimmer.stopShimmer();
        }
        super.onViewDetachedFromWindow(vVar);
    }

    public class DotLoadingViewHolder extends BaseViewHolder {
        public String jsonFile = "blue_dotted_progress.json";
        public MpDotProgressBarLytBinding mBinding;

        public DotLoadingViewHolder(RequestMoneyLinkAdapter requestMoneyLinkAdapter, MpDotProgressBarLytBinding mpDotProgressBarLytBinding) {
            super(mpDotProgressBarLytBinding.getRoot());
            this.mBinding = mpDotProgressBarLytBinding;
        }

        public void bindData(Object obj, int i2) {
            this.mBinding.animationView.setAnimation(this.jsonFile);
            this.mBinding.animationView.loop(true);
            this.mBinding.animationView.playAnimation();
        }
    }

    public class RequestMoneyLinkViewHolder extends RecyclerView.v {
        public CustomTextView amount;
        public CustomTextView date;
        public CustomTextView description;
        public LinearLayout layoutItem;
        public ImageView shareLinkIV;
        public CustomTextView time;

        public RequestMoneyLinkViewHolder(RequestMoneyLinkAdapter requestMoneyLinkAdapter, View view) {
            super(view);
            this.amount = (CustomTextView) view.findViewById(R.id.payment_list_amount);
            this.description = (CustomTextView) view.findViewById(R.id.payment_list_description);
            this.date = (CustomTextView) view.findViewById(R.id.payment_list_date);
            this.time = (CustomTextView) view.findViewById(R.id.payment_list_time);
            this.layoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            this.shareLinkIV = (ImageView) view.findViewById(R.id.share_button_rv_item);
        }
    }

    public class RequestMoneyHeaderViewHolder extends RecyclerView.v {
        public TextWatcher editTextWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                LogUtility.d("", "");
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                LogUtility.d("", "");
            }

            public void afterTextChanged(Editable editable) {
                RequestMoneyHeaderViewHolder.this.removeError();
            }
        };
        public CustomTextInputEditText mAmountET;
        public CustomTextView mAmountError;
        public CustomTextInputLayout mAmountTIL;
        public CustomTextView mCreateLink;
        public CustomTextInputEditText mDescriptionET;
        public CustomTextView mDescriptionError;
        public CustomTextInputLayout mDescriptionTIL;
        public CustomTextView mMisuseMessage;
        public CustomTextView mRecyclerViewTitle;
        public CustomTextView mUpgradeAccount;

        public RequestMoneyHeaderViewHolder(View view) {
            super(view);
            this.mAmountTIL = (CustomTextInputLayout) view.findViewById(R.id.rm_amount_til);
            this.mAmountET = (CustomTextInputEditText) view.findViewById(R.id.rm_amount_et);
            this.mAmountError = (CustomTextView) view.findViewById(R.id.rm_amount_error);
            this.mDescriptionTIL = (CustomTextInputLayout) view.findViewById(R.id.rm_description_til);
            this.mDescriptionET = (CustomTextInputEditText) view.findViewById(R.id.rm_description_et);
            this.mDescriptionError = (CustomTextView) view.findViewById(R.id.rm_description_error);
            this.mRecyclerViewTitle = (CustomTextView) view.findViewById(R.id.recycler_view_title);
            this.mCreateLink = (CustomTextView) view.findViewById(R.id.rm_create_link);
            this.mAmountET.addTextChangedListener(this.editTextWatcher);
            this.mAmountET.setFilters(new InputFilter[]{RequestMoneyLinkAdapter.this.amountFilter});
            this.mAmountET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    RequestMoneyLinkAdapter.RequestMoneyHeaderViewHolder.this.lambda$new$0$RequestMoneyLinkAdapter$RequestMoneyHeaderViewHolder(view, z);
                }
            });
            this.mDescriptionET.addTextChangedListener(this.editTextWatcher);
            this.mCreateLink.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RequestMoneyLinkAdapter.RequestMoneyHeaderViewHolder.this.lambda$new$1$RequestMoneyLinkAdapter$RequestMoneyHeaderViewHolder(view);
                }
            });
            showTextIfRequired();
        }

        public /* synthetic */ void lambda$new$0$RequestMoneyLinkAdapter$RequestMoneyHeaderViewHolder(View view, boolean z) {
            if (!z) {
                CustomTextInputEditText customTextInputEditText = this.mAmountET;
                customTextInputEditText.setText(customTextInputEditText.getText().toString().replaceFirst("^0+(?!$)", ""));
            }
        }

        public /* synthetic */ void lambda$new$1$RequestMoneyLinkAdapter$RequestMoneyHeaderViewHolder(View view) {
            String obj = this.mAmountET.getText().toString();
            String obj2 = this.mDescriptionET.getText().toString();
            if (validDetails(obj, obj2)) {
                RequestMoneyLinkAdapter.this.requestMoneyLinkListner.onCreateLinkClick(obj, obj2);
            }
        }

        public void clearTextFields() {
            this.mAmountET.clearFocus();
            this.mAmountET.setText("");
            this.mDescriptionET.clearFocus();
            this.mDescriptionET.setText("");
        }

        private void showTextIfRequired() {
            if (GTMDataProviderImpl.Companion.getMInstance().shouldShowUpgradeButton() && PaymentsConfig.getInstance().getMerchantDataProvider().s() && !PaymentsConfig.getInstance().getMerchantDataProvider().x() && !MerchantTypeToPPIMapperKt.CONST_UNLIMITED_SD.equalsIgnoreCase(PaymentsConfig.getInstance().getMerchantDataProvider().t()) && !PaymentsConfig.getInstance().getMerchantDataProvider().y() && !MerchantTypeToPPIMapperKt.CONST_100K.equalsIgnoreCase(PaymentsConfig.getInstance().getMerchantDataProvider().t()) && !MerchantTypeToPPIMapperKt.CONST_500K.equalsIgnoreCase(PaymentsConfig.getInstance().getMerchantDataProvider().t())) {
                this.mMisuseMessage = (CustomTextView) this.itemView.findViewById(R.id.textView_misuse_message);
                this.mUpgradeAccount = (CustomTextView) this.itemView.findViewById(R.id.textView_upgrade_account);
                setSpannableStringForMisuseMessage();
                setSpannableStringUpgradeYourAccount();
                this.mMisuseMessage.setVisibility(0);
                this.mUpgradeAccount.setVisibility(0);
            }
        }

        private void setSpannableStringForMisuseMessage() {
            AnonymousClass1 r0 = new ClickableSpan() {
                public void onClick(View view) {
                    if (RequestMoneyLinkAdapter.this.requestMoneyLinkListner instanceof Fragment) {
                        CreateLinkBottomSheetFragment instance = CreateLinkBottomSheetFragment.Companion.getINSTANCE();
                        instance.setCancelable(true);
                        instance.show(((Fragment) RequestMoneyLinkAdapter.this.requestMoneyLinkListner).getActivity().getSupportFragmentManager(), "create_link_sheet");
                    }
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            };
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_misuse_message, new Object[]{RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_nonbrakable_space)}));
            String string = RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_message);
            if (spannableStringBuilder.toString().contains(string)) {
                int indexOf = spannableStringBuilder.toString().indexOf(string);
                int length = string.length() + indexOf;
                Drawable drawable = RequestMoneyLinkAdapter.this.mContext.getResources().getDrawable(R.drawable.i_boundary_blue);
                drawable.setBounds(0, 0, (int) (RequestMoneyLinkAdapter.this.mContext.getResources().getDisplayMetrics().scaledDensity * 14.0f), (int) (RequestMoneyLinkAdapter.this.mContext.getResources().getDisplayMetrics().scaledDensity * 14.0f));
                spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), length + 1, length + 2, 17);
                spannableStringBuilder.setSpan(r0, indexOf, length, 18);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(RequestMoneyLinkAdapter.this.mContext, R.color.color_00b9f5)), indexOf, length, 18);
            }
            this.mMisuseMessage.setMovementMethod(LinkMovementMethod.getInstance());
            this.mMisuseMessage.setText(spannableStringBuilder);
        }

        private void setSpannableStringUpgradeYourAccount() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = RequestMoneyLinkAdapter.this.mContext.getString(R.string.mp_to_remove_this_upgrade_account);
            String string2 = RequestMoneyLinkAdapter.this.mContext.getString(R.string.mp_upgrafe_your_account_label);
            spannableStringBuilder.append(string);
            if (spannableStringBuilder.toString().contains(string2)) {
                int indexOf = spannableStringBuilder.toString().indexOf(string2);
                int length = string2.length() + indexOf;
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public void onClick(View view) {
                        String str = "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().getLimitsAndChargesFlowUrl();
                        if (RequestMoneyLinkAdapter.this.mContext != null) {
                            PaymentsConfig.getInstance().getDeepLinkUtils().a(RequestMoneyLinkAdapter.this.mContext, str);
                        }
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setUnderlineText(false);
                    }
                }, indexOf, length, 18);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(RequestMoneyLinkAdapter.this.mContext, R.color.color_00b9f5)), indexOf, length, 18);
            }
            this.mUpgradeAccount.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            String upgradeLimitLeadStatus = APSharedPreferences.getInstance().getUpgradeLimitLeadStatus();
            if (!TextUtils.isEmpty(upgradeLimitLeadStatus) && !upgradeLimitLeadStatus.equalsIgnoreCase(ReactivationStatusNetwork.LEAD_NOT_PRESENT)) {
                this.mUpgradeAccount.setText(RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_view_upgrade_request_status));
                this.mUpgradeAccount.setTextColor(RequestMoneyLinkAdapter.this.mContext.getResources().getColor(R.color.color_00B9F5));
                this.mUpgradeAccount.setTypeface((Typeface) null, 1);
                this.mUpgradeAccount.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String str = "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().getLimitsAndChargesFlowUrl();
                        if (RequestMoneyLinkAdapter.this.mContext != null) {
                            PaymentsConfig.getInstance().getDeepLinkUtils().a(RequestMoneyLinkAdapter.this.mContext, str);
                        }
                    }
                });
            }
            this.mUpgradeAccount.setMovementMethod(LinkMovementMethod.getInstance());
        }

        /* access modifiers changed from: private */
        public void removeError() {
            this.mAmountTIL.setBackground(androidx.core.content.b.a(RequestMoneyLinkAdapter.this.mContext, R.drawable.mp_rectangle_rounded_corner));
            this.mDescriptionTIL.setBackground(androidx.core.content.b.a(RequestMoneyLinkAdapter.this.mContext, R.drawable.mp_rectangle_rounded_corner));
            this.mAmountError.setVisibility(8);
            this.mDescriptionError.setVisibility(8);
        }

        private boolean validDetails(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                this.mAmountError.setText(RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_rm_amount_empty));
                this.mAmountError.setVisibility(0);
                this.mAmountTIL.setBackground(androidx.core.content.b.a(RequestMoneyLinkAdapter.this.mContext, R.drawable.mp_error_round_bg));
                this.mAmountET.requestFocus();
                return false;
            } else if (Double.parseDouble(str) < 1.0d) {
                this.mAmountError.setText(RequestMoneyLinkAdapter.this.mContext.getResources().getString(R.string.mp_rm_err_amount_less_than_one));
                this.mAmountError.setVisibility(0);
                this.mAmountTIL.setBackground(androidx.core.content.b.a(RequestMoneyLinkAdapter.this.mContext, R.drawable.mp_error_round_bg));
                this.mAmountET.requestFocus();
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2.trim())) {
                return true;
            } else {
                this.mDescriptionError.setVisibility(0);
                this.mDescriptionTIL.setBackground(androidx.core.content.b.a(RequestMoneyLinkAdapter.this.mContext, R.drawable.mp_error_round_bg));
                this.mDescriptionET.requestFocus();
                return false;
            }
        }
    }

    public void setShowDotProgress(boolean z) {
        if (z) {
            this.paymentReceivedList.add("SHIMMER");
            this.paymentReceivedList.add("SHIMMER");
            this.paymentReceivedList.add("SHIMMER");
        } else {
            if (checkDelCondition(this.paymentReceivedList)) {
                List<Object> list = this.paymentReceivedList;
                list.remove(list.size() - 1);
            }
            if (checkDelCondition(this.paymentReceivedList)) {
                List<Object> list2 = this.paymentReceivedList;
                list2.remove(list2.size() - 1);
            }
            if (checkDelCondition(this.paymentReceivedList)) {
                List<Object> list3 = this.paymentReceivedList;
                list3.remove(list3.size() - 1);
            }
        }
        this.showDotProgress = z;
        notifyDataSetChanged();
    }

    private boolean checkDelCondition(List<Object> list) {
        int size = list.size() - 1;
        if (size < 0 || !(list.get(size) instanceof String) || !"SHIMMER".equalsIgnoreCase((String) list.get(size))) {
            return false;
        }
        return true;
    }
}
