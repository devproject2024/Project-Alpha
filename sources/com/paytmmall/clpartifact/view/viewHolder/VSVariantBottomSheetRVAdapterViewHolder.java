package com.paytmmall.clpartifact.view.viewHolder;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.listeners.VSVariantBottomSheetRVAdapterListener;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;

public class VSVariantBottomSheetRVAdapterViewHolder extends RecyclerView.v {
    private TextView actualPriceTV;
    private View addItemBtn;
    private TextView addToCartLayout;
    private TextView capacityTV;
    private TextView discountPercTV;
    private View editCartLayout;
    private ImageView iconIV;
    private TextView itemCountTV;
    private VSVariantBottomSheetRVAdapterListener mListener;
    private TextView offerPriceTV;
    private TextView offerTagTV;

    public VSVariantBottomSheetRVAdapterViewHolder(View view, VSVariantBottomSheetRVAdapterListener vSVariantBottomSheetRVAdapterListener) {
        super(view);
        this.mListener = vSVariantBottomSheetRVAdapterListener;
        this.offerPriceTV = (TextView) view.findViewById(R.id.offerPriceTV);
        this.addToCartLayout = (TextView) view.findViewById(R.id.addToCartLayout);
        this.addToCartLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VSVariantBottomSheetRVAdapterViewHolder.this.lambda$new$0$VSVariantBottomSheetRVAdapterViewHolder(view);
            }
        });
        this.itemCountTV = (TextView) view.findViewById(R.id.itemCountTV);
        this.actualPriceTV = (TextView) view.findViewById(R.id.actualPriceTV);
        TextView textView = this.actualPriceTV;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.discountPercTV = (TextView) view.findViewById(R.id.discountPercentTV);
        this.editCartLayout = view.findViewById(R.id.editCartLayout);
        this.addItemBtn = view.findViewById(R.id.addItemBtn);
        this.addItemBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VSVariantBottomSheetRVAdapterViewHolder.this.lambda$new$1$VSVariantBottomSheetRVAdapterViewHolder(view);
            }
        });
        view.findViewById(R.id.removeItemBtn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VSVariantBottomSheetRVAdapterViewHolder.this.lambda$new$2$VSVariantBottomSheetRVAdapterViewHolder(view);
            }
        });
        this.offerTagTV = (TextView) view.findViewById(R.id.offerTagTV);
        this.iconIV = (ImageView) view.findViewById(R.id.iconIV);
        this.capacityTV = (TextView) view.findViewById(R.id.capacityTV);
    }

    public /* synthetic */ void lambda$new$0$VSVariantBottomSheetRVAdapterViewHolder(View view) {
        this.mListener.onAddToCartClick(getAdapterPosition());
    }

    public /* synthetic */ void lambda$new$1$VSVariantBottomSheetRVAdapterViewHolder(View view) {
        this.mListener.onAddToCartClick(getAdapterPosition());
    }

    public /* synthetic */ void lambda$new$2$VSVariantBottomSheetRVAdapterViewHolder(View view) {
        this.mListener.onRemoveFromCartClick(getAdapterPosition());
    }

    public void bind() {
        CJRGridProduct cJRGridProduct = this.mListener.getProducts().get(getAdapterPosition());
        this.addToCartLayout.setEnabled(this.mListener.isItemInStock());
        TextView textView = this.addToCartLayout;
        textView.setText(textView.getContext().getResources().getString(this.mListener.isItemInStock() ? R.string.clp_add_to_cart : R.string.sold_out));
        setCartDetails(cJRGridProduct);
        int i2 = 0;
        this.actualPriceTV.setVisibility(cJRGridProduct.isDiscounted() ? 0 : 8);
        TextView textView2 = this.discountPercTV;
        if (!cJRGridProduct.isDiscounted()) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        ViewUtils.loadImage(getIconUrl(cJRGridProduct), this.iconIV, R.drawable.picasso_default_placeholder);
        this.offerTagTV.setText(getPromoText(cJRGridProduct));
        TextView textView3 = this.offerTagTV;
        textView3.setTextColor(textView3.getContext().getResources().getColor(isSingleRedemptionType(cJRGridProduct) ? R.color.green_text_color : R.color.clp_red));
        this.capacityTV.setText(getCapacity(cJRGridProduct));
        this.actualPriceTV.setText(StringUtils.getRupeesFormat(cJRGridProduct.getActualPrice()));
        this.offerPriceTV.setText(StringUtils.getRupeesFormat(cJRGridProduct.getDiscountedPrice()));
        this.discountPercTV.setText(StringUtils.getDiscountPerc(cJRGridProduct.getDiscountPercent()));
    }

    private String getCapacity(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getAttribute().getCapacity();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private String getIconUrl(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getPromoData().get(0).getOffer().getIcon();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private String getPromoText(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getPromoData().get(0).getOffer().getText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private boolean isSingleRedemptionType(CJRGridProduct cJRGridProduct) {
        try {
            return CLPConstants.SINGLE_REDEMPTION.equalsIgnoreCase(cJRGridProduct.getPromoData().get(0).getOffer().getType());
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return true;
        }
    }

    private void setCartDetails(CJRGridProduct cJRGridProduct) {
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        int i2 = 8;
        this.addToCartLayout.setVisibility((!CartUtils.hasItemWithId(parseLong) || !this.mListener.isItemInStock()) ? 0 : 8);
        View view = this.editCartLayout;
        if (this.addToCartLayout.getVisibility() != 0) {
            i2 = 0;
        }
        view.setVisibility(i2);
        this.addItemBtn.setEnabled(isAddItemButtonEnabled(cJRGridProduct));
        this.itemCountTV.setText(String.valueOf(CartUtils.itemCountInCart(parseLong)));
    }

    private boolean isAddItemButtonEnabled(CJRGridProduct cJRGridProduct) {
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        CJRCartItem item = CartUtils.getItem(parseLong);
        return CartUtils.hasItemWithId(parseLong) && ((long) item.getQuantity()) < item.getMaximumPurchasableQty();
    }

    private void setOfferText(CJRGridProduct cJRGridProduct) {
        String offerV1Text = StringUtils.getOfferV1Text(cJRGridProduct);
        String offerV1Subtext = StringUtils.getOfferV1Subtext(cJRGridProduct);
        boolean isOfferV1SingleRedemptionType = StringUtils.isOfferV1SingleRedemptionType(cJRGridProduct);
        String str = offerV1Text + " " + offerV1Subtext;
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(offerV1Text)) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(isOfferV1SingleRedemptionType ? -65536 : -16711936);
            int indexOf = str.indexOf(offerV1Text);
            spannableString.setSpan(foregroundColorSpan, indexOf, offerV1Text.length() + indexOf, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf, offerV1Text.length() + indexOf, 33);
        }
        if (!TextUtils.isEmpty(offerV1Subtext)) {
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.offerPriceTV.getContext().getResources().getColor(R.color.clp_label1));
            int length = offerV1Text.length() + 1;
            spannableString.setSpan(foregroundColorSpan2, length, offerV1Subtext.length() + length, 33);
        }
        this.offerPriceTV.setText(spannableString);
    }
}
