package com.paytmmall.clpartifact.view.viewHolder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPInfiniteGridFoodViewHolder extends ClickableRVChildViewHolder {
    private TextView actualPrice = ((TextView) this.itemView.findViewById(R.id.actual_price));
    private TextView addItemToCart = ((TextView) this.itemView.findViewById(R.id.addItemBtn));
    private TextView addToCart = ((TextView) this.itemView.findViewById(R.id.addToCartLayout));
    private View addToCartContainer = this.itemView.findViewById(R.id.add_to_cart_container);
    private CustomAction customAction;
    private TextView discountPercent = ((TextView) this.itemView.findViewById(R.id.discount_percent));
    private View editCartLayout = this.itemView.findViewById(R.id.editCartLayout);
    private View foodTag = this.itemView.findViewById(R.id.food_tag);
    private TextView itemCountInCart = ((TextView) this.itemView.findViewById(R.id.itemCountTV));
    private TextView itemDescription = ((TextView) this.itemView.findViewById(R.id.item_description));
    private TextView itemName = ((TextView) this.itemView.findViewById(R.id.item_name));
    private InfiniteGridRVAdapterListener mListener;
    private TextView offerPrice = ((TextView) this.itemView.findViewById(R.id.offer_price));
    private CJRGridProduct product;
    private TextView removeItem = ((TextView) this.itemView.findViewById(R.id.removeItemBtn));

    public CLPInfiniteGridFoodViewHolder(ViewDataBinding viewDataBinding, InfiniteGridRVAdapterListener infiniteGridRVAdapterListener, CustomAction customAction2) {
        super(viewDataBinding, (IGAHandlerListener) null, customAction2);
        this.mListener = infiniteGridRVAdapterListener;
        TextView textView = this.actualPrice;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.addToCart.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CLPInfiniteGridFoodViewHolder.this.lambda$new$0$CLPInfiniteGridFoodViewHolder(view);
            }
        });
        this.addItemToCart.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CLPInfiniteGridFoodViewHolder.this.lambda$new$1$CLPInfiniteGridFoodViewHolder(view);
            }
        });
        this.removeItem.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CLPInfiniteGridFoodViewHolder.this.lambda$new$2$CLPInfiniteGridFoodViewHolder(view);
            }
        });
        this.customAction = customAction2;
    }

    public /* synthetic */ void lambda$new$0$CLPInfiniteGridFoodViewHolder(View view) {
        onAddToCardClick(this.product);
    }

    public /* synthetic */ void lambda$new$1$CLPInfiniteGridFoodViewHolder(View view) {
        onAddToCardClick(this.product);
    }

    public /* synthetic */ void lambda$new$2$CLPInfiniteGridFoodViewHolder(View view) {
        onRemoveFromCartClick(this.product);
    }

    public void bind(CJRGridProduct cJRGridProduct) {
        setGAData(cJRGridProduct.getGaData());
        GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, getAdapterPosition());
        this.product = cJRGridProduct;
        this.itemName.setText(cJRGridProduct.getName());
        this.itemDescription.setText(getDescription());
        this.actualPrice.setText(cJRGridProduct.getActualPrice());
        int i2 = 8;
        this.actualPrice.setVisibility(cJRGridProduct.isDiscounted() ? 0 : 8);
        this.offerPrice.setText(cJRGridProduct.getDiscountedPrice());
        this.discountPercent.setText(cJRGridProduct.getDiscountPercent());
        this.discountPercent.setVisibility(this.actualPrice.getVisibility());
        this.addToCart.setText(this.itemView.getContext().getResources().getString(cJRGridProduct.isInStock() ? R.string.clp_add_to_cart : R.string.sold_out));
        this.addToCart.setEnabled(cJRGridProduct.isInStock());
        boolean z = !CartUtils.hasItemWithId(Long.parseLong(cJRGridProduct.getProductID())) || !cJRGridProduct.isInStock();
        this.addToCart.setVisibility(z ? 0 : 8);
        this.itemCountInCart.setText(String.valueOf(CartUtils.itemCountInCart(Long.parseLong(cJRGridProduct.getProductID()))));
        this.addItemToCart.setEnabled(isAddItemButtonEnabled());
        this.foodTag.setVisibility(hasFoodVariant() ? 0 : 8);
        this.foodTag.setEnabled(StringUtils.isNonVegFood(cJRGridProduct.getAttribute()));
        this.editCartLayout.setVisibility(!z ? 0 : 8);
        View view = this.addToCartContainer;
        if (cJRGridProduct.getAddToCart() == 1) {
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    private String getDescription() {
        try {
            return this.product.getAttribute().getDescription();
        } catch (NullPointerException unused) {
            return "";
        }
    }

    private boolean hasFoodVariant() {
        try {
            return !TextUtils.isEmpty(this.product.getAttribute().getVegNonveg());
        } catch (NullPointerException unused) {
            return false;
        }
    }

    private boolean isAddItemButtonEnabled() {
        long parseLong = Long.parseLong(this.product.getProductID());
        CJRCartItem item = CartUtils.getItem(parseLong);
        return CartUtils.hasItemWithId(parseLong) && ((long) item.getQuantity()) < item.getMaximumPurchasableQty();
    }

    private void onAddToCardClick(CJRGridProduct cJRGridProduct) {
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        if (CartUtils.hasItemWithId(parseLong)) {
            updateCart(cJRGridProduct.getProductID(), CartUtils.itemCountInCart(parseLong) + 1);
        } else {
            new CLPRepository().addItemToCart(this.itemView.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()), 1);
        }
    }

    private void updateCart(String str, int i2) {
        new CLPRepository().updateCart(this.itemView.getContext().getApplicationContext(), Long.parseLong(str), i2);
    }

    private void onRemoveFromCartClick(CJRGridProduct cJRGridProduct) {
        long parseLong = Long.parseLong(cJRGridProduct.getProductID());
        if (CartUtils.itemCountInCart(parseLong) > 1) {
            updateCart(cJRGridProduct.getProductID(), CartUtils.itemCountInCart(parseLong) - 1);
        } else {
            new CLPRepository().removeItemFromCart(this.itemView.getContext().getApplicationContext(), Long.parseLong(cJRGridProduct.getProductID()));
        }
    }
}
