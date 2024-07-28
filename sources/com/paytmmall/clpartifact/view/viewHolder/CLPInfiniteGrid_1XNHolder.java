package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.databinding.ItemRowInfiniteGrid1xnBinding;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;

public class CLPInfiniteGrid_1XNHolder extends CLPInfiniteGridHolder implements View.OnClickListener {
    private View addItemBtn;
    private TextView addToCartLayout;
    private View cartContainer;
    private CustomAction customAction;
    private View editCartLayout;
    private TextView itemCountTV;
    ItemRowInfiniteGrid1xnBinding mBinder;
    private CJRGridProduct mItem;
    private View removeItemBtn;
    private TextView variantLayout;

    public CLPInfiniteGrid_1XNHolder(ItemRowInfiniteGrid1xnBinding itemRowInfiniteGrid1xnBinding, InfiniteGridRVAdapterListener infiniteGridRVAdapterListener, CustomAction customAction2) {
        super(itemRowInfiniteGrid1xnBinding, infiniteGridRVAdapterListener, customAction2);
        this.mBinder = itemRowInfiniteGrid1xnBinding;
        this.mBinder.actualPriceTV.setPaintFlags(this.mBinder.actualPriceTV.getPaintFlags() | 16);
        this.addToCartLayout = (TextView) itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.addToCartLayout);
        this.editCartLayout = itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.editCartLayout);
        this.addItemBtn = itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.addItemBtn);
        this.itemCountTV = (TextView) itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.itemCountTV);
        this.removeItemBtn = itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.removeItemBtn);
        this.variantLayout = (TextView) itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.variantLayout);
        this.cartContainer = itemRowInfiniteGrid1xnBinding.getRoot().findViewById(R.id.cart_container);
        this.variantLayout.setOnClickListener(this);
        this.customAction = customAction2;
    }

    public void bind(CJRGridProduct cJRGridProduct, int i2, boolean z) {
        super.bind(cJRGridProduct, i2, z);
        this.mItem = cJRGridProduct;
        setImageHeight();
        this.mBinder.offerPriceTV.setText(this.mItem.isInStock() ? getOfferSpanText() : getSoldOutText());
        int i3 = 8;
        this.mBinder.offerPriceTV.setVisibility(getListener().shouldShowProductPrice() ? 0 : 8);
        setCartDetails();
        this.addItemBtn.setOnClickListener(new View.OnClickListener(cJRGridProduct) {
            private final /* synthetic */ CJRGridProduct f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CLPInfiniteGrid_1XNHolder.this.lambda$bind$0$CLPInfiniteGrid_1XNHolder(this.f$1, view);
            }
        });
        this.removeItemBtn.setOnClickListener(new View.OnClickListener(cJRGridProduct) {
            private final /* synthetic */ CJRGridProduct f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CLPInfiniteGrid_1XNHolder.this.lambda$bind$1$CLPInfiniteGrid_1XNHolder(this.f$1, view);
            }
        });
        this.addToCartLayout.setOnClickListener(new View.OnClickListener(cJRGridProduct) {
            private final /* synthetic */ CJRGridProduct f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CLPInfiniteGrid_1XNHolder.this.lambda$bind$2$CLPInfiniteGrid_1XNHolder(this.f$1, view);
            }
        });
        this.addToCartLayout.setEnabled(cJRGridProduct.isInStock());
        TextView textView = this.addToCartLayout;
        textView.setText(textView.getContext().getResources().getString(cJRGridProduct.isInStock() ? R.string.clp_add_to_cart : R.string.sold_out));
        this.mBinder.actualPriceTV.setVisibility(cJRGridProduct.isDiscounted() ? 0 : 8);
        this.mBinder.discountPercentTV.setVisibility(cJRGridProduct.isDiscounted() ? 0 : 8);
        this.mBinder.badgeSeparator.setVisibility((!hasBadge() || !hasAverageRating()) ? 8 : 0);
        int i4 = 4;
        this.mBinder.badgeTV.setVisibility(hasBadge() ? 0 : 4);
        this.mBinder.badgeTV.setText(getFirstBadge());
        ViewUtils.loadImage(getFirstBadgeImageUrl(), this.mBinder.badgeIV, new ColorDrawable(-1), CustomActionHelper.INSTANCE.getContext(this.mBinder.badgeIV.getContext(), this.customAction));
        this.variantLayout.setText(getCapacity());
        TextView textView2 = this.variantLayout;
        if (supportVariant()) {
            i4 = 0;
        }
        textView2.setVisibility(i4);
        this.variantLayout.setEnabled(hasMoreVariant());
        TextView textView3 = this.variantLayout;
        textView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, textView3.isEnabled() ? R.drawable.clp_ic_down_arrow_blue : 0, 0);
        this.cartContainer.setVisibility(getListener().showAddToCart() ? 0 : 8);
        LinearLayout linearLayout = this.mBinder.priceLayout;
        if (getListener().shouldShowProductPrice()) {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
    }

    public /* synthetic */ void lambda$bind$0$CLPInfiniteGrid_1XNHolder(CJRGridProduct cJRGridProduct, View view) {
        onAddToCardClick(cJRGridProduct);
    }

    public /* synthetic */ void lambda$bind$1$CLPInfiniteGrid_1XNHolder(CJRGridProduct cJRGridProduct, View view) {
        onRemoveFromCartClick(cJRGridProduct);
    }

    public /* synthetic */ void lambda$bind$2$CLPInfiniteGrid_1XNHolder(CJRGridProduct cJRGridProduct, View view) {
        onAddToCardClick(cJRGridProduct);
    }

    private boolean hasAverageRating() {
        return !TextUtils.isEmpty(this.mItem.getmAvgRating());
    }

    private void setImageHeight() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBinder.productImage.getLayoutParams();
        layoutParams.height = getImageHeight();
        this.mBinder.productImage.setLayoutParams(layoutParams);
    }

    public int getImageHeight() {
        return (int) this.itemView.getResources().getDimension(ViewHolderFactory.isViewTypeLarge(getListener().getViewType()) ? R.dimen.large_list_img_height : R.dimen.list_image_height);
    }

    private boolean hasMoreVariant() {
        try {
            return this.mItem.getVariant().getDimensions().get(0).getCount() > 1;
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }

    private boolean supportVariant() {
        try {
            return this.mItem.getVariant().getDimensions().get(0).getCount() > 0;
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }

    private String getCapacity() {
        try {
            return this.mItem.getAttribute().getCapacity();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private boolean hasBadge() {
        CJRGridProduct cJRGridProduct = this.mItem;
        return (cJRGridProduct == null || cJRGridProduct.getmBadges() == null || this.mItem.getmBadges().isEmpty()) ? false : true;
    }

    private String getFirstBadge() {
        return hasBadge() ? this.mItem.getmBadges().get(0).getmText() : "";
    }

    private String getFirstBadgeImageUrl() {
        return hasBadge() ? this.mItem.getmBadges().get(0).getmImageUrl() : "";
    }

    private void setCartDetails() {
        CJRGridProduct cJRGridProduct = this.mItem;
        if (cJRGridProduct != null) {
            long parseLong = Long.parseLong(cJRGridProduct.getProductID());
            int i2 = 8;
            this.addToCartLayout.setVisibility((!CartUtils.hasItemWithId(parseLong) || !this.mItem.isInStock()) ? 0 : 8);
            View view = this.editCartLayout;
            if (this.addToCartLayout.getVisibility() != 0) {
                i2 = 0;
            }
            view.setVisibility(i2);
            this.addItemBtn.setEnabled(isAddItemButtonEnabled());
            this.itemCountTV.setText(String.valueOf(CartUtils.itemCountInCart(parseLong)));
        }
    }

    private boolean isAddItemButtonEnabled() {
        long parseLong = Long.parseLong(this.mItem.getProductID());
        CJRCartItem item = CartUtils.getItem(parseLong);
        return CartUtils.hasItemWithId(parseLong) && ((long) item.getQuantity()) < item.getMaximumPurchasableQty();
    }

    private CharSequence getOfferSpanText() {
        String offerV1Text = StringUtils.getOfferV1Text(this.mItem);
        String offerV1Subtext = StringUtils.getOfferV1Subtext(this.mItem);
        boolean isOfferV1SingleRedemptionType = StringUtils.isOfferV1SingleRedemptionType(this.mItem);
        String str = offerV1Text + " " + offerV1Subtext;
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(offerV1Text)) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.itemView.getResources().getColor(isOfferV1SingleRedemptionType ? R.color.clp_notification_view_color : R.color.green_text_color));
            int indexOf = str.indexOf(offerV1Text);
            spannableString.setSpan(foregroundColorSpan, indexOf, offerV1Text.length() + indexOf, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf, offerV1Text.length() + indexOf, 33);
        }
        if (!TextUtils.isEmpty(offerV1Subtext)) {
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.mBinder.offerPriceTV.getContext().getResources().getColor(R.color.clp_label1));
            int length = offerV1Text.length() + 1;
            spannableString.setSpan(foregroundColorSpan2, length, offerV1Subtext.length() + length, 33);
        }
        return spannableString;
    }

    private CharSequence getSoldOutText() {
        String string = this.itemView.getResources().getString(R.string.sold_out);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(this.itemView.getResources().getColor(R.color.clp_notification_view_color)), 0, string.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
        return spannableString;
    }

    private void onAddToCardClick(CJRGridProduct cJRGridProduct) {
        GaHandler.getInstance().fireAddToCartEvent(cJRGridProduct);
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        if (CartUtils.hasItemWithId(parseLong)) {
            new CLPRepository().updateCart(this.mBinder.offerPriceTV.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()), CartUtils.itemCountInCart(parseLong) + 1);
        } else {
            new CLPRepository().addItemToCart(this.mBinder.offerPriceTV.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()), 1);
        }
    }

    private void onRemoveFromCartClick(CJRGridProduct cJRGridProduct) {
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        if (CartUtils.itemCountInCart(parseLong) > 1) {
            new CLPRepository().updateCart(this.mBinder.offerPriceTV.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()), CartUtils.itemCountInCart(parseLong) - 1);
        } else {
            new CLPRepository().removeItemFromCart(this.mBinder.offerPriceTV.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()));
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.variantLayout && getListener() != null) {
            getListener().onVariantClick(this.mItem);
        }
    }
}
