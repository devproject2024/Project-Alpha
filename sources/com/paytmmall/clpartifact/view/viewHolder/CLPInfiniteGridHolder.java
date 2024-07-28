package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.modal.grid.CJROfferV1;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;

public class CLPInfiniteGridHolder extends ClickableRVChildViewHolder {
    private CustomAction customAction;
    private InfiniteGridRVAdapterListener mListener;
    private ViewDataBinding mViewDataBinding;
    private ImageView productIV = ((ImageView) this.mViewDataBinding.getRoot().findViewById(R.id.item_image1));
    /* access modifiers changed from: private */
    public ImageView wishListIcon;

    public CLPInfiniteGridHolder(ViewDataBinding viewDataBinding, InfiniteGridRVAdapterListener infiniteGridRVAdapterListener, CustomAction customAction2) {
        super(viewDataBinding, (IGAHandlerListener) null, customAction2);
        this.mListener = infiniteGridRVAdapterListener;
        this.customAction = customAction2;
        this.mViewDataBinding = viewDataBinding;
    }

    public int getImageHeight() {
        return (int) this.itemView.getResources().getDimension(ViewHolderFactory.isViewTypeLarge(this.mListener.getViewType()) ? R.dimen.large_grid_img_height : R.dimen.grid_img_height);
    }

    public InfiniteGridRVAdapterListener getListener() {
        return this.mListener;
    }

    private void handleGAProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        InfiniteGridRVAdapterListener infiniteGridRVAdapterListener = this.mListener;
        if (infiniteGridRVAdapterListener != null) {
            infiniteGridRVAdapterListener.fireGridProductImpression(cJRGridProduct, i2);
        } else {
            GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, i2);
        }
    }

    public void bind(CJRGridProduct cJRGridProduct, int i2, boolean z) {
        this.wishListIcon = (ImageView) this.mViewDataBinding.getRoot().findViewById(R.id.item_heart);
        enableItemClick();
        handWishListUpdate(cJRGridProduct);
        setGAData(cJRGridProduct.getGaData());
        handleGAProductImpression(cJRGridProduct, i2);
        this.mViewDataBinding.setVariable(BR.item, cJRGridProduct);
        this.mViewDataBinding.setVariable(BR.offerTag, Boolean.valueOf(!TextUtils.isEmpty(cJRGridProduct.getOfferTag())));
        this.mViewDataBinding.setVariable(BR.showRating, showRating(cJRGridProduct));
        this.mViewDataBinding.setVariable(BR.cashback, getCashBack(cJRGridProduct));
        this.mViewDataBinding.setVariable(BR.subCashback, getSubCashBack(cJRGridProduct));
        this.mViewDataBinding.setVariable(BR.isWishListed, Boolean.valueOf(isWishListed(cJRGridProduct)));
        this.mViewDataBinding.setVariable(BR.showWishListIcon, Boolean.valueOf(!z));
        this.mViewDataBinding.setVariable(BR.badgeText, getBadgeText(cJRGridProduct));
        this.mViewDataBinding.setVariable(BR.badgeImageUrl, getBadgeImageUrl(cJRGridProduct));
        this.mViewDataBinding.setVariable(BR.showSeparation, Boolean.valueOf(getShowView(cJRGridProduct)));
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(i2));
        this.mViewDataBinding.setVariable(BR.showPrice, Boolean.valueOf(getListener().shouldShowProductPrice()));
        this.mViewDataBinding.executePendingBindings();
        setImageheight();
    }

    private void setImageheight() {
        ImageView imageView = this.productIV;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = getImageHeight();
            this.productIV.setLayoutParams(layoutParams);
        }
    }

    private void handWishListUpdate(CJRGridProduct cJRGridProduct) {
        if (isWishListed(cJRGridProduct)) {
            this.wishListIcon.setImageResource(R.drawable.clp_wishlist_selected);
        } else {
            this.wishListIcon.setImageResource(R.drawable.clp_heart_button);
        }
    }

    private boolean getShowView(CJRGridProduct cJRGridProduct) {
        return (TextUtils.isEmpty(getBadgeImageUrl(cJRGridProduct)) && TextUtils.isEmpty(getBadgeText(cJRGridProduct))) || !showRating(cJRGridProduct).booleanValue();
    }

    private String getBadgeImageUrl(CJRGridProduct cJRGridProduct) {
        if (cJRGridProduct == null) {
            return null;
        }
        try {
            if (cJRGridProduct.getmBadges().isEmpty() || cJRGridProduct.getmBadges().size() <= 0) {
                return null;
            }
            if (cJRGridProduct.getmBadges().get(0).getmImageUrl() != null) {
                return cJRGridProduct.getmBadges().get(0).getmImageUrl();
            }
            return "";
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private String getBadgeText(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getmBadges().get(0).getmText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private String getSubCashBack(CJRGridProduct cJRGridProduct) {
        String str;
        try {
            CJROfferV1 offerV1 = getOfferV1(cJRGridProduct);
            if (offerV1 != null) {
                if (!TextUtils.isEmpty(offerV1.getmSubtext())) {
                    str = cJRGridProduct.getPromoData().get(0).getOffer_v1().getmSubtext();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    ((TextView) this.mViewDataBinding.getRoot().findViewById(R.id.product1_cashback_text)).setTextColor(this.mViewDataBinding.getRoot().getContext().getResources().getColor(R.color.green_text_color));
                }
                return str;
            }
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
        return "";
    }

    private String getCashBack(CJRGridProduct cJRGridProduct) {
        try {
            CJROfferV1 offerV1 = getOfferV1(cJRGridProduct);
            if (offerV1 != null && !TextUtils.isEmpty(offerV1.getmText())) {
                return cJRGridProduct.getPromoData().get(0).getOffer_v1().getmText();
            }
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
        return "";
    }

    private CJROfferV1 getOfferV1(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getPromoData().get(0).getOffer_v1();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return null;
        }
    }

    private Boolean showRating(CJRGridProduct cJRGridProduct) {
        return Boolean.valueOf(cJRGridProduct != null && !TextUtils.isEmpty(cJRGridProduct.getmAvgRating()) && !TextUtils.isEmpty(cJRGridProduct.getmTotalrating()));
    }

    public void handleWishListClick(CJRGridProduct cJRGridProduct) {
        if (isWishListed(cJRGridProduct)) {
            removeFromWishList(cJRGridProduct);
        } else if (TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(this.mViewDataBinding.getRoot().getContext()))) {
            CLPArtifact.getInstance().getCommunicationListener().openLoginScreen(this.mViewDataBinding.getRoot().getContext());
        } else {
            addInWishList(cJRGridProduct);
        }
    }

    public int getVariantLabelVisibility(CJRGridProduct cJRGridProduct) {
        return hasMoreVariant(cJRGridProduct) ? 0 : 8;
    }

    public String getVariantLabel(CJRGridProduct cJRGridProduct) {
        try {
            CJRGridProduct.Dimension dimension = cJRGridProduct.getVariant().getDimensions().get(0);
            return dimension.getCount() + " " + dimension.getLabel();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private boolean hasMoreVariant(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getVariant().getDimensions().get(0).getCount() > 1;
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }

    public void handleVariantClick(CJRGridProduct cJRGridProduct) {
        this.mListener.onVariantClick(cJRGridProduct);
    }

    private void addInWishList(CJRGridProduct cJRGridProduct) {
        CLPArtifact.getInstance().getCommunicationListener().addToWishList(CLPArtifact.getInstance().getContext(), new CLPNetworkService.Callback<WishList>() {
            public void onSuccess() {
                CLPInfiniteGridHolder.this.wishListIcon.setImageResource(R.drawable.clp_wishlist_selected);
                if (Build.VERSION.SDK_INT >= 23) {
                    CLPInfiniteGridHolder.this.showPopupWindow(true);
                } else {
                    CLPInfiniteGridHolder.this.showCustomToast(true);
                }
            }

            public void onError() {
                if (Build.VERSION.SDK_INT >= 23) {
                    CLPInfiniteGridHolder.this.showPopupWindow(false);
                } else {
                    CLPInfiniteGridHolder.this.showCustomToast(false);
                }
            }
        }, cJRGridProduct.getSource(), cJRGridProduct.getProductID(), cJRGridProduct.getProductID());
    }

    private void removeFromWishList(CJRGridProduct cJRGridProduct) {
        CLPArtifact.getInstance().getCommunicationListener().removeFromWishList(CLPArtifact.getInstance().getContext(), new CLPNetworkService.Callback<WishList>() {
            public void onError() {
            }

            public void onSuccess() {
                CLPInfiniteGridHolder.this.wishListIcon.setImageResource(R.drawable.clp_heart_button);
            }
        }, cJRGridProduct.getProductID());
    }

    /* access modifiers changed from: private */
    public void showCustomToast(boolean z) {
        View inflate = LayoutInflater.from(this.mViewDataBinding.getRoot().getContext()).inflate(R.layout.custom_wishlist_toast, (ViewGroup) null);
        Toast toast = new Toast(this.mViewDataBinding.getRoot().getContext());
        TextView textView = (TextView) inflate.findViewById(R.id.wishlist_txt);
        if (z) {
            textView.setText("Items Added in");
        } else {
            textView.setText("Cannot add more products");
        }
        toast.setView(inflate);
        toast.setDuration(1);
        toast.show();
    }

    /* access modifiers changed from: private */
    public void showPopupWindow(boolean z) {
        View inflate = LayoutInflater.from(this.mViewDataBinding.getRoot().getContext()).inflate(R.layout.custom_wishlist_toast, (ViewGroup) null);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.customToast);
        TextView textView = (TextView) inflate.findViewById(R.id.wishlist_txt);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.wishlist_iv);
        if (z) {
            textView.setText(getWishlistSuccessSpan("Added to", inflate), TextView.BufferType.SPANNABLE);
            imageView.setVisibility(8);
        } else {
            textView.setText(getWishlistErrorSpan("Cannot add more products to your", inflate), TextView.BufferType.SPANNABLE);
            imageView.setVisibility(0);
        }
        final PopupWindow popupWindow = new PopupWindow(inflate, convertDpToPixel(350.0f, inflate.getContext()), -2, true);
        popupWindow.showAtLocation(inflate, 80, 0, 200);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(inflate);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                popupWindow.dismiss();
                CLPInfiniteGridHolder.this.handleToastClick();
            }
        });
        Handler handler = new Handler();
        popupWindow.getClass();
        handler.postDelayed(new Runnable(popupWindow) {
            private final /* synthetic */ PopupWindow f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.dismiss();
            }
        }, 5000);
    }

    private Spannable getWishlistSuccessSpan(String str, View view) {
        String string = view.getContext().getString(R.string.wishlist);
        int c2 = b.c(view.getContext(), R.color.clp_color_2222222);
        int c3 = b.c(view.getContext(), R.color.primaryBlue);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c2), 0, str.length(), 0);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c3), str.length() + 1, spannableStringBuilder.length(), 0);
        return spannableStringBuilder;
    }

    private Spannable getWishlistErrorSpan(String str, View view) {
        String string = view.getContext().getString(R.string.wishlist);
        int c2 = b.c(view.getContext(), R.color.clp_red);
        int c3 = b.c(view.getContext(), R.color.clp_red);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c2), 0, str.length(), 0);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c3), str.length() + 1, spannableStringBuilder.length(), 0);
        return spannableStringBuilder;
    }

    private int convertDpToPixel(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private boolean isWishListed(CJRGridProduct cJRGridProduct) {
        if (cJRGridProduct != null) {
            return CLPArtifact.getInstance().getCommunicationListener().isProductAlreadyInWishList(CLPArtifact.getInstance().getContext(), cJRGridProduct.getProductID());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void handleToastClick() {
        Item item = new Item();
        item.setUrlType(CLPConstants.WISHLIST);
        CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mViewDataBinding.getRoot().getContext(), this.customAction), item);
    }
}
