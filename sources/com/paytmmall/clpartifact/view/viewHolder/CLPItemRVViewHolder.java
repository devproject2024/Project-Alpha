package com.paytmmall.clpartifact.view.viewHolder;

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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;

public class CLPItemRVViewHolder extends ClickableRVChildViewHolder {
    private CustomAction customAction;
    private ViewDataBinding mChildBinding;
    /* access modifiers changed from: private */
    public ImageView wishListIcon;

    public CLPItemRVViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mChildBinding = viewDataBinding;
        this.wishListIcon = (ImageView) viewDataBinding.getRoot().findViewById(R.id.wishlistIcon);
        this.customAction = customAction2;
    }

    public CLPItemRVViewHolder(View view) {
        super(view);
    }

    public void bindItem(Item item, int i2) {
        if (item != null) {
            enableItemClick();
            setGAData(item.getGaData());
            this.mChildBinding.setVariable(BR.item, item);
            this.mChildBinding.setVariable(BR.handler, this);
            if (this.wishListIcon != null) {
                this.mChildBinding.setVariable(BR.isWishListed, Boolean.valueOf(isWishListed(item)));
            }
            this.mChildBinding.setVariable(BR.position, Integer.valueOf(i2));
            this.mChildBinding.executePendingBindings();
        }
    }

    public int getPromoTextColor(Item item) {
        return this.itemView.getResources().getColor(isItemSingleRedemptionType(item) ? R.color.clp_notification_view_color : R.color.green_text_color);
    }

    public String getBadgeUrl(Item item) {
        try {
            return item.getBadges().get(0).getmImageUrl();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public String getBadgeText(Item item) {
        try {
            return item.getBadges().get(0).getmText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public boolean hasBadge(Item item) {
        return !TextUtils.isEmpty(getBadgeText(item));
    }

    public boolean hasOfferText(Item item) {
        return !TextUtils.isEmpty(getOfferText(item));
    }

    public boolean hasSubOfferText(Item item) {
        return !TextUtils.isEmpty(getOfferSubText(item));
    }

    public boolean isItemSingleRedemptionType(Item item) {
        try {
            return item.getOfferData().get(0).getOfferV1().getmType().equalsIgnoreCase(CLPConstants.SINGLE_REDEMPTION);
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }

    public String getOfferText(Item item) {
        try {
            return item.getOfferData().get(0).getOfferV1().getmText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public String getOfferSubText(Item item) {
        try {
            return item.getOfferData().get(0).getOfferV1().getmSubtext();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public void handleWishListClick(Item item) {
        if (isWishListed(item)) {
            removeFromWishList(item);
        } else if (!isClpImplementationAvailable() || !TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(this.mChildBinding.getRoot().getContext()))) {
            addInWishList(item);
        } else {
            CLPArtifact.getInstance().getCommunicationListener().openLoginScreen(this.mChildBinding.getRoot().getContext());
        }
    }

    private boolean isWishListed(Item item) {
        if (item == null || !isClpImplementationAvailable()) {
            return false;
        }
        return CLPArtifact.getInstance().getCommunicationListener().isProductAlreadyInWishList(CLPArtifact.getInstance().getContext(), String.valueOf(item.getItemId()));
    }

    private void removeFromWishList(Item item) {
        if (isClpImplementationAvailable()) {
            CLPArtifact.getInstance().getCommunicationListener().removeFromWishList(CLPArtifact.getInstance().getContext(), new CLPNetworkService.Callback<WishList>() {
                public void onError() {
                }

                public void onSuccess() {
                    CLPItemRVViewHolder.this.wishListIcon.setImageResource(R.drawable.clp_heart_button);
                }
            }, String.valueOf(item.getItemId()));
        }
    }

    private void addInWishList(Item item) {
        if (isClpImplementationAvailable()) {
            CLPArtifact.getInstance().getCommunicationListener().addToWishList(CLPArtifact.getInstance().getContext(), new CLPNetworkService.Callback<WishList>() {
                public void onSuccess() {
                    CLPItemRVViewHolder.this.wishListIcon.setImageResource(R.drawable.clp_wishlist_selected);
                    if (Build.VERSION.SDK_INT >= 23) {
                        CLPItemRVViewHolder.this.showPopupWindow(true);
                    } else {
                        CLPItemRVViewHolder.this.showCustomToast(true);
                    }
                }

                public void onError() {
                    if (Build.VERSION.SDK_INT >= 23) {
                        CLPItemRVViewHolder.this.showPopupWindow(false);
                    } else {
                        CLPItemRVViewHolder.this.showCustomToast(false);
                    }
                }
            }, item.getSource(), String.valueOf(item.getItemId()), String.valueOf(item.getItemId()));
        }
    }

    /* access modifiers changed from: private */
    public void showPopupWindow(boolean z) {
        View inflate = LayoutInflater.from(this.mChildBinding.getRoot().getContext()).inflate(R.layout.custom_wishlist_toast, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.customToast);
        TextView textView = (TextView) inflate.findViewById(R.id.wishlist_txt);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.wishlist_iv);
        if (z) {
            textView.setText(getWishlistSuccessSpan("Added to", inflate), TextView.BufferType.SPANNABLE);
            imageView.setVisibility(8);
        } else {
            textView.setText(getWishlistErrorSpan("Cannot add more products to your", inflate), TextView.BufferType.SPANNABLE);
            imageView.setVisibility(0);
        }
        PopupWindow popupWindow = new PopupWindow(this.itemView.getContext());
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-1);
        popupWindow.showAtLocation(inflate, 17, 0, 0);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        linearLayout.setOnClickListener(new View.OnClickListener(popupWindow) {
            private final /* synthetic */ PopupWindow f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CLPItemRVViewHolder.this.lambda$showPopupWindow$0$CLPItemRVViewHolder(this.f$1, view);
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

    public /* synthetic */ void lambda$showPopupWindow$0$CLPItemRVViewHolder(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
        handleToastClick();
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

    /* access modifiers changed from: private */
    public void showCustomToast(boolean z) {
        View inflate = LayoutInflater.from(this.mChildBinding.getRoot().getContext()).inflate(R.layout.custom_wishlist_toast, (ViewGroup) null);
        Toast toast = new Toast(this.mChildBinding.getRoot().getContext());
        TextView textView = (TextView) inflate.findViewById(R.id.wishlist_txt);
        if (z) {
            textView.setText("Cannot add more products to your");
        } else {
            textView.setText("Can not add ");
        }
        toast.setView(inflate);
        toast.setDuration(1);
        toast.show();
    }

    private void handleToastClick() {
        if (isClpImplementationAvailable()) {
            Item item = new Item();
            item.setUrlType(CLPConstants.WISHLIST);
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mChildBinding.getRoot().getContext(), this.customAction), item);
        }
    }

    public PaytmAdView.a getAdClickListener(final Item item, final int i2) {
        return new PaytmAdView.a() {
            public void onAdClick(View view) {
                CLPItemRVViewHolder.this.handleDeepLink(item, i2);
            }
        };
    }

    public String getRequestId() {
        if (getIgaHandlerListener() != null) {
            return getIgaHandlerListener().getClientRequestID();
        }
        return CLPArtifact.isCLPListenerAvailable() ? CLPArtifact.getInstance().getCommunicationListener().getClientRequestID() : "";
    }
}
