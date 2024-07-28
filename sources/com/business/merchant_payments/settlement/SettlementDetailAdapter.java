package com.business.merchant_payments.settlement;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpBwSettlementDetailNewBinding;
import com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.image_target.MpP4bBankImageTarget;
import com.business.merchant_payments.settlement.model.AdditionalInfoModel;
import com.business.merchant_payments.settlement.model.AmountModel;
import com.business.merchant_payments.settlement.model.M2BModel;
import com.business.merchant_payments.settlement.model.M2BOrderListItemModel;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class SettlementDetailAdapter extends RecyclerView.a<RecyclerView.v> {
    public final Context mContext;
    public final ArrayList<M2BOrderListItemModel> mList;
    public final int settlementBankType;

    public SettlementDetailAdapter(Context context, ArrayList<M2BOrderListItemModel> arrayList, int i2) {
        k.d(context, "mContext");
        k.d(arrayList, "list");
        this.mContext = context;
        this.settlementBankType = i2;
        this.mList = new ArrayList<>(arrayList);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.d(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(this.mContext), R.layout.mp_bw_settlement_detail_new, viewGroup, false);
        k.b(a2, "DataBindingUtil.inflate(…etail_new, parent, false)");
        return new SettlementItemViewHolder(this, (MpBwSettlementDetailNewBinding) a2);
    }

    public final int getItemCount() {
        ArrayList<M2BOrderListItemModel> arrayList = this.mList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.d(vVar, "holder");
        if (vVar instanceof SettlementItemViewHolder) {
            View root = ((SettlementItemViewHolder) vVar).getMBinding().getRoot();
            k.b(root, "settlementItemViewHolder.mBinding.root");
            M2BOrderListItemModel m2BOrderListItemModel = this.mList.get(i2);
            k.b(m2BOrderListItemModel, "mList[position]");
            setM2BChildItem(root, m2BOrderListItemModel, this.settlementBankType);
        }
    }

    private final void setM2BChildItem(View view, M2BOrderListItemModel m2BOrderListItemModel, int i2) {
        TextView textView;
        TextView textView2;
        boolean z;
        String str;
        String str2;
        View view2 = view;
        ImageView imageView = (ImageView) view2.findViewById(R.id.bwSettlementDetailItemStatusIcon);
        TextView textView3 = (TextView) view2.findViewById(R.id.bwSettlementDetailItemStatusText);
        TextView textView4 = (TextView) view2.findViewById(R.id.bwSettlementUTRText);
        TextView textView5 = (TextView) view2.findViewById(R.id.bwSettlementUTRText2);
        TextView textView6 = (TextView) view2.findViewById(R.id.bwSettlementDetailAmountText);
        ImageView imageView2 = (ImageView) view2.findViewById(R.id.bwSettlementDetailBankLogoImage);
        TextView textView7 = (TextView) view2.findViewById(R.id.bwSettlementDetailBankNameText);
        TextView textView8 = (TextView) view2.findViewById(R.id.bwSettlementDetailAccountNumberText);
        View findViewById = view2.findViewById(R.id.bwDetailBankLogoAccNumberContainer);
        if (findViewById != null) {
            View findViewById2 = view2.findViewById(R.id.bwSettlementDetailBankNameContainer);
            if (findViewById2 != null) {
                TextView textView9 = (TextView) view2.findViewById(R.id.bwPipe);
                View[] viewArr = {findViewById, findViewById2};
                TextView textView10 = (TextView) view2.findViewById(R.id.view_all_pending_settlement_time);
                String str3 = "";
                if (i2 == 0) {
                    textView2 = textView6;
                    setM2BSCommonItemVisibility(viewArr, 0);
                    k.b(textView4, "utrText");
                    textView4.setVisibility(8);
                    textView = textView5;
                } else {
                    textView2 = textView6;
                    setM2BSCommonItemVisibility(viewArr, 8);
                    k.b(textView4, "utrText");
                    textView4.setVisibility(0);
                    if (p.a("SUCCESS", m2BOrderListItemModel.getOrderStatus(), true)) {
                        textView4.setVisibility(0);
                        PaymentsConfig instance = PaymentsConfig.getInstance();
                        k.b(instance, "PaymentsConfig.getInstance()");
                        Context appContext = instance.getAppContext();
                        int i3 = R.string.mp_lbl_utr_number;
                        textView = textView5;
                        Object[] objArr = new Object[1];
                        String reconId = m2BOrderListItemModel.getReconId();
                        if (reconId == null) {
                            reconId = str3;
                        }
                        objArr[0] = reconId;
                        textView4.setText(appContext.getString(i3, objArr));
                    } else {
                        textView = textView5;
                        textView4.setVisibility(8);
                    }
                }
                if (p.a("PENDING", m2BOrderListItemModel.getOrderStatus(), true)) {
                    k.b(textView10, "pendingSettlementTime");
                    textView10.setVisibility(0);
                    String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(m2BOrderListItemModel.getOrderCreatedTime());
                    k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…mp(data.orderCreatedTime)");
                    if (timeFromTimeStamp != null) {
                        String lowerCase = timeFromTimeStamp.toLowerCase();
                        k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                        textView10.setText(lowerCase);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                imageView.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.mContext, m2BOrderListItemModel.getOrderStatus()));
                k.b(textView3, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT);
                textView3.setText(P4BSettlementsDataHelperMP.INSTANCE.getBWSDetailStatusText(m2BOrderListItemModel.getOrderStatus(), 1, m2BOrderListItemModel.getOrderCreatedTime(), m2BOrderListItemModel.getOrderCompletedTime()));
                String str4 = null;
                if (i2 == 0) {
                    MpP4bBankImageTarget mpP4bBankImageTarget = new MpP4bBankImageTarget(new WeakReference(imageView2));
                    AdditionalInfoModel additionalInfo = m2BOrderListItemModel.getAdditionalInfo();
                    String bankIconUrl = additionalInfo != null ? additionalInfo.getBankIconUrl() : null;
                    if (!(bankIconUrl == null || bankIconUrl.length() == 0)) {
                        w a2 = w.a();
                        AdditionalInfoModel additionalInfo2 = m2BOrderListItemModel.getAdditionalInfo();
                        if (additionalInfo2 == null || (str2 = additionalInfo2.getBankIconUrl()) == null) {
                            str2 = str3;
                        }
                        a2.a(str2).a((af) mpP4bBankImageTarget);
                    }
                    k.b(textView7, "bankNameText");
                    AdditionalInfoModel additionalInfo3 = m2BOrderListItemModel.getAdditionalInfo();
                    textView7.setText(additionalInfo3 != null ? additionalInfo3.getReceiverBankName() : null);
                    k.b(textView8, "bankAccountNumberText");
                    AdditionalInfoModel additionalInfo4 = m2BOrderListItemModel.getAdditionalInfo();
                    if (additionalInfo4 == null || (str = additionalInfo4.getMaskedCardNo()) == null) {
                        str = str3;
                    }
                    textView8.setText(str);
                }
                if (p.a("SUCCESS", m2BOrderListItemModel.getOrderStatus(), true)) {
                    k.b(textView9, "pipe");
                    textView9.setText("|");
                    PaymentsConfig instance2 = PaymentsConfig.getInstance();
                    k.b(instance2, "PaymentsConfig.getInstance()");
                    Context appContext2 = instance2.getAppContext();
                    int i4 = R.string.mp_lbl_utr_number;
                    Object[] objArr2 = new Object[1];
                    String reconId2 = m2BOrderListItemModel.getReconId();
                    if (reconId2 != null) {
                        str3 = reconId2;
                    }
                    z = false;
                    objArr2[0] = str3;
                    str3 = appContext2.getString(i4, objArr2);
                } else {
                    z = false;
                    k.b(textView9, "pipe");
                    textView9.setText(str3);
                }
                TextView textView11 = textView;
                textView11.setText(str3);
                TextView textView12 = textView2;
                k.b(textView12, "amountText");
                LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                AmountModel payMoneyAmount = m2BOrderListItemModel.getPayMoneyAmount();
                if (payMoneyAmount != null) {
                    str4 = payMoneyAmount.getValue();
                }
                textView12.setText(labelPopulationHelperMP.parseAndGetAmountString(str4, true));
                k.b(textView11, "utrText2");
                CharSequence text = textView11.getText();
                if (text == null || p.a(text)) {
                    z = true;
                }
                if (z) {
                    k.b(textView7, "bankNameText");
                    textView7.setMaxWidth(Integer.MAX_VALUE);
                    return;
                }
                Resources resources = this.mContext.getResources();
                k.b(textView7, "bankNameText");
                textView7.setMaxWidth((int) (resources.getDimension(R.dimen.mp_bw_settlement_message_max_width) / resources.getDisplayMetrics().density));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public final void setM2BDetailResponse(SettlementBillListDetailModel settlementBillListDetailModel) {
        ArrayList<M2BOrderListItemModel> orderList;
        k.d(settlementBillListDetailModel, "settlementBillListDetailModel");
        M2BModel m2b = settlementBillListDetailModel.getM2b();
        if (!(m2b == null || (orderList = m2b.getOrderList()) == null)) {
            this.mList.addAll(orderList);
        }
        notifyDataSetChanged();
    }

    public final class SettlementItemViewHolder extends RecyclerView.v {
        public final MpBwSettlementDetailNewBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettlementItemViewHolder(SettlementDetailAdapter settlementDetailAdapter, MpBwSettlementDetailNewBinding mpBwSettlementDetailNewBinding) {
            super(mpBwSettlementDetailNewBinding.getRoot());
            k.d(mpBwSettlementDetailNewBinding, "mBinding");
            this.mBinding = mpBwSettlementDetailNewBinding;
        }

        public final MpBwSettlementDetailNewBinding getMBinding() {
            return this.mBinding;
        }
    }

    private final void setM2BSCommonItemVisibility(View[] viewArr, int i2) {
        ArrayList arrayList = new ArrayList(viewArr.length);
        for (View visibility : viewArr) {
            visibility.setVisibility(i2);
            arrayList.add(x.f47997a);
        }
    }
}
