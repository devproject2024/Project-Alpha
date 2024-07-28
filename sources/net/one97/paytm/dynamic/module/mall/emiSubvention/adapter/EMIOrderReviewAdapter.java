package net.one97.paytm.dynamic.module.mall.emiSubvention.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.artifact.cart.entity.CJRCartProduct;
import com.paytmmall.artifact.cart.entity.Gratifications;
import com.paytmmall.artifact.d.a.c;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.paytm_finance.R;

public class EMIOrderReviewAdapter extends RecyclerView.a<EMIOrderReviewHolder> {
    private ArrayList<CJRCartProduct> dataList;
    private Context mContext;
    private String planId;

    public EMIOrderReviewAdapter(Context context, ArrayList<CJRCartProduct> arrayList, String str) {
        this.mContext = context;
        this.dataList = arrayList;
        this.planId = str;
    }

    public EMIOrderReviewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new EMIOrderReviewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.order_detail_row, viewGroup, false));
    }

    public void onBindViewHolder(EMIOrderReviewHolder eMIOrderReviewHolder, int i2) {
        eMIOrderReviewHolder.bindView(this.mContext, this.dataList.get(i2), i2);
    }

    public int getItemCount() {
        ArrayList<CJRCartProduct> arrayList = this.dataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    class EMIOrderReviewHolder extends RecyclerView.v {
        private TextView cashbackString;
        private TextView effectivePrice;
        private TextView emiType;
        private TextView interesttxtTitle;
        private View llCashBack;
        private View llTotalInterest;
        private ImageView productImage;
        private TextView productPrice;
        private TextView productQuantity;
        private TextView productTitle;
        private TextView totalCashBack;
        private TextView totalInterest;

        EMIOrderReviewHolder(View view) {
            super(view);
            this.productImage = (ImageView) view.findViewById(R.id.productImage);
            this.productTitle = (TextView) view.findViewById(R.id.productTitle);
            this.productQuantity = (TextView) view.findViewById(R.id.productQuantity);
            this.effectivePrice = (TextView) view.findViewById(R.id.effectivePricetxt);
            this.totalCashBack = (TextView) view.findViewById(R.id.totalCashbackTxt);
            this.productPrice = (TextView) view.findViewById(R.id.productPriceValue);
            this.totalInterest = (TextView) view.findViewById(R.id.totalInterestxt);
            this.llCashBack = view.findViewById(R.id.emi_cashback_root);
            this.llTotalInterest = view.findViewById(R.id.ll_total_interest);
            this.cashbackString = (TextView) view.findViewById(R.id.cashbackString);
            this.emiType = (TextView) view.findViewById(R.id.EMICashbackType);
            this.interesttxtTitle = (TextView) view.findViewById(R.id.interestTitle);
        }

        /* access modifiers changed from: package-private */
        public void bindView(Context context, CJRCartProduct cJRCartProduct, int i2) {
            if (getAdapterPosition() == 0) {
                this.interesttxtTitle.setVisibility(0);
            } else {
                this.interesttxtTitle.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cJRCartProduct.getImageUrl())) {
                c.a(cJRCartProduct.getImageUrl(), this.productImage);
            }
            if (!TextUtils.isEmpty(cJRCartProduct.getName())) {
                this.productTitle.setText(cJRCartProduct.getName());
            }
            if (!TextUtils.isEmpty(cJRCartProduct.getQuantity())) {
                TextView textView = this.productQuantity;
                textView.setText(Html.fromHtml(" Qty : " + "<b>" + cJRCartProduct.getQuantity() + "</b>"));
            } else {
                this.productQuantity.setVisibility(4);
            }
            if (!TextUtils.isEmpty(cJRCartProduct.getPrice())) {
                this.productPrice.setText(EMIOrderReviewAdapter.this.getTotalPrice(cJRCartProduct));
            } else {
                this.productPrice.setVisibility(4);
            }
            String access$100 = EMIOrderReviewAdapter.this.getTotalInterest(cJRCartProduct);
            if (!TextUtils.isEmpty(access$100)) {
                this.totalInterest.setText(access$100);
            } else {
                this.llTotalInterest.setVisibility(8);
            }
            String access$200 = EMIOrderReviewAdapter.this.getCashbackType(cJRCartProduct);
            if (!TextUtils.isEmpty(access$200)) {
                this.emiType.setText(access$200);
            }
            String access$300 = EMIOrderReviewAdapter.this.getTotalCashBack(cJRCartProduct);
            if (!TextUtils.isEmpty(access$300)) {
                this.totalCashBack.setText(access$300);
            } else {
                this.llCashBack.setVisibility(8);
                this.cashbackString.setVisibility(8);
            }
            String access$400 = EMIOrderReviewAdapter.this.getEffectivePrice(cJRCartProduct);
            if (!TextUtils.isEmpty(access$400)) {
                this.effectivePrice.setText(access$400);
            } else {
                this.effectivePrice.setVisibility(4);
            }
        }
    }

    /* access modifiers changed from: private */
    public String getCashbackType(CJRCartProduct cJRCartProduct) {
        StringBuilder sb = new StringBuilder();
        if (!(cJRCartProduct == null || cJRCartProduct.getEmiOffers() == null)) {
            List<Gratifications> gratifications = (cJRCartProduct.getEmiOffers().get(this.planId) == null || cJRCartProduct.getEmiOffers().get(this.planId) == null) ? null : cJRCartProduct.getEmiOffers().get(this.planId).getGratifications();
            if (gratifications != null && gratifications.size() > 0) {
                for (int i2 = 0; i2 < gratifications.size(); i2++) {
                    if (gratifications.get(i2) != null) {
                        sb.append(gratifications.get(i2).getLabel());
                    }
                    if (i2 != gratifications.size() - 1 && !TextUtils.isEmpty(sb)) {
                        sb.append("+");
                    }
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public String getTotalPrice(CJRCartProduct cJRCartProduct) {
        if (cJRCartProduct == null || TextUtils.isEmpty(cJRCartProduct.getPrice()) || TextUtils.isEmpty(cJRCartProduct.getQuantity())) {
            return " ";
        }
        int parseInt = Integer.parseInt(cJRCartProduct.getPrice()) * Integer.parseInt(cJRCartProduct.getQuantity());
        return this.mContext.getString(R.string.rupee_symbol) + new DecimalFormat("##,##,##0").format((long) parseInt);
    }

    /* access modifiers changed from: private */
    public String getEffectivePrice(CJRCartProduct cJRCartProduct) {
        Double valueOf = Double.valueOf((cJRCartProduct.getEmiOffers() == null || cJRCartProduct.getEmiOffers().get(this.planId) == null) ? 0.0d : cJRCartProduct.getEmiOffers().get(this.planId).getEffectivePrice().doubleValue());
        return this.mContext.getString(R.string.rupee_symbol) + new DecimalFormat("##,##,##0").format(valueOf);
    }

    /* access modifiers changed from: private */
    public String getTotalInterest(CJRCartProduct cJRCartProduct) {
        int intValue = (cJRCartProduct.getEmiOffers() == null || cJRCartProduct.getEmiOffers().get(this.planId) == null) ? 0 : cJRCartProduct.getEmiOffers().get(this.planId).getInterest().intValue();
        return "+ " + this.mContext.getString(R.string.rupee_symbol) + new DecimalFormat("##,##,##0").format((long) intValue);
    }

    /* access modifiers changed from: private */
    public String getTotalCashBack(CJRCartProduct cJRCartProduct) {
        List<Gratifications> gratifications = cJRCartProduct.getEmiOffers() != null ? cJRCartProduct.getEmiOffers().get(this.planId).getGratifications() : null;
        if (gratifications == null || gratifications.size() <= 0) {
            return "";
        }
        int i2 = 0;
        for (int i3 = 0; i3 < gratifications.size(); i3++) {
            i2 += gratifications.get(i3) != null ? gratifications.get(i3).getValue().intValue() : 0;
        }
        return "- " + this.mContext.getString(R.string.rupee_symbol) + new DecimalFormat("##,##,##0").format((long) i2);
    }
}
