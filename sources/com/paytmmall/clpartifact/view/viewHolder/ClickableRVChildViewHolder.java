package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.ga.GaBuilder;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.DeeplLinkHandler;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickableRVChildViewHolder extends CLPBaseViewHolder {
    public static final String TAG = ClickableRVChildViewHolder.class.getSimpleName();
    private CustomAction customAction;
    private IGAHandlerListener gaListener;
    private ViewDataBinding mChildBinding;

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
    }

    public ClickableRVChildViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mChildBinding = viewDataBinding;
        this.gaListener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    public ClickableRVChildViewHolder(android.view.View view) {
        super(view);
    }

    public void enableItemClick() {
        this.mChildBinding.setVariable(BR.handler, this);
    }

    public void handleDeepLink(Item item, int i2) {
        DeeplLinkHandler.Companion.handleDeepLink(item, i2, this.gaListener, getGAData(), CustomActionHelper.INSTANCE.getHostActivity(this.mChildBinding.getRoot().getContext(), this.customAction));
    }

    public void handleStaticWidgetDeepLink(View view) {
        if (isClpImplementationAvailable() && view != null) {
            Item createItem = createItem(view.mItems.get(0));
            int adapterPosition = getAdapterPosition();
            createItem.setPosition(adapterPosition);
            if (view.getItems() != null && !view.getItems().isEmpty()) {
                List<Item> items = view.getItems();
                if (adapterPosition < items.size()) {
                    IGAHandlerListener iGAHandlerListener = this.gaListener;
                    if (iGAHandlerListener == null || !iGAHandlerListener.IsClickEnable()) {
                        GaHandler.getInstance().fireClickEvent(items.get(adapterPosition), adapterPosition);
                    } else {
                        this.gaListener.OnItemClick(items.get(adapterPosition), adapterPosition);
                    }
                }
            }
            createItem.setGaData(getGAData());
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mChildBinding.getRoot().getContext(), this.customAction), createItem);
        }
    }

    public void handleGridDeepLink(CJRGridProduct cJRGridProduct, int i2) {
        if (isClpImplementationAvailable() && cJRGridProduct != null) {
            Item item = new Item();
            item.setUrl(cJRGridProduct.getUrl());
            item.setUrlType(cJRGridProduct.getUrlType());
            item.setId(cJRGridProduct.getProductID() == null ? "0" : cJRGridProduct.getProductID());
            item.setPosition(i2);
            item.setName(cJRGridProduct.getName());
            Map gAData = getGAData();
            if (gAData == null) {
                gAData = new HashMap();
            }
            gAData.put(GAUtil.KEY_PREV_GA_KEY, GaBuilder.getDimension24ForInfiniteGrid(gAData));
            item.setGaData(gAData);
            cJRGridProduct.setGaData(gAData);
            GaHandler.getInstance().fireClickEvent(cJRGridProduct, i2, gAData);
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mChildBinding.getRoot().getContext(), this.customAction), item);
        }
    }

    private Item createItem(Item item) {
        if (item == null) {
            return new Item();
        }
        Item item2 = new Item();
        item2.setUrl(item.getUrl());
        item2.setUrlType(item.getUrlType());
        item2.setId(item.getId());
        item2.setName(item.getName());
        item2.setTitle(item.getTitle());
        return item2;
    }

    public static void setImageUrl(ImageView imageView, String str, int i2, boolean z, boolean z2, int i3, Context context) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                context = imageView.getContext();
            }
            Context context2 = context;
            if (z2) {
                ImageUtility.getInstance().loadImageWithOutPlaceHolder(imageView, str, z, context2);
            } else if (i3 != 0) {
                ImageUtility.getInstance().loadImageWithCustomPlaceHolder(imageView, str, z, i3, context2);
            } else if (i2 == 0) {
                ImageUtility.getInstance().loadImageWithOutCornerRadius(imageView, str, z, context2);
            } else if (i2 > 0) {
                ImageUtility.getInstance().loadImageWithPlaceHolder(imageView, str, i2, z, context2);
            }
        }
    }

    public static void setOnlyImageUrl(ImageView imageView, String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                context = imageView.getContext();
            }
            ImageUtility.getInstance().loadImageWithOutCornerRadius(imageView, str, false, context);
        }
    }

    public static void setDrawable(ImageView imageView, Item item, Context context) {
        if (item == null) {
            return;
        }
        if (item.isMore()) {
            imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.ic_sfs_down_arrow));
        } else if (!TextUtils.isEmpty(item.getImageUrl())) {
            if (context == null) {
                context = imageView.getContext();
            }
            ImageUtility.getInstance().loadImageWithOutCornerRadius(imageView, item.getImageUrl(), false, context);
        }
    }

    public static void setPromoText(TextView textView, CJRGridProduct cJRGridProduct) {
        ViewUtils.setPromoText(textView, cJRGridProduct);
    }

    public void fireGA(String str, Item item, int i2) {
        if (isClpImplementationAvailable()) {
            handleDeepLink(item, i2);
            CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents((Activity) this.mChildBinding.getRoot().getContext(), "brandstore_widget", "visit_store_clicked", str, (String) null, CLPConstants.GA_CHANNEL_NAME, "homescreen");
        }
    }

    public static void setImagePostMeasure(ImageView imageView, Item item, int i2, boolean z, Context context) {
        HomeUtils.d("setImagePostMeasure called", false);
        if (item != null) {
            if (context == null) {
                context = imageView.getContext();
            }
            final String imageUrl = item.getImageUrl();
            if (TextUtils.isEmpty(imageUrl)) {
                return;
            }
            if (item.getImageWidth() == -1) {
                final ImageView imageView2 = imageView;
                final Item item2 = item;
                final int i3 = i2;
                final boolean z2 = z;
                final Context context2 = context;
                imageView.post(new Runnable() {
                    public final void run() {
                        int measuredWidth = imageView2.getMeasuredWidth();
                        item2.setImageWidth(measuredWidth);
                        HomeUtils.d("setImagePostMeasure called view.measuredWidth = ".concat(String.valueOf(measuredWidth)), false);
                        ClickableRVChildViewHolder.loadImage(imageUrl, measuredWidth, i3, imageView2, z2, context2);
                    }
                });
                return;
            }
            HomeUtils.d("setImagePostMeasure >> showing image with saved width " + item.getImageWidth(), false);
            loadImage(imageUrl, item.getImageWidth(), i2, imageView, z, context);
        }
    }

    /* access modifiers changed from: private */
    public static void loadImage(String str, int i2, int i3, ImageView imageView, boolean z, Context context) {
        HomeUtils.d("loadImage called with viewMeasuredWidth = ".concat(String.valueOf(i2)), false);
        HomeUtils.d("loadImage called with url = ".concat(String.valueOf(str)), false);
        if (i2 > 0) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("imwidth", String.valueOf(i2));
            buildUpon.appendQueryParameter("impolicy", "hq");
            str = buildUpon.toString();
        }
        String str2 = str;
        if (i3 == 0) {
            ImageUtility.getInstance().loadImageWithOutCornerRadius(imageView, str2, z, context);
        } else if (i3 > 0) {
            ImageUtility.getInstance().loadImageWithPlaceHolder(imageView, str2, i3, z, context);
        }
    }

    public Context getContext() {
        CustomAction customAction2 = this.customAction;
        if (customAction2 == null || customAction2.getActivityListener() == null) {
            return this.mChildBinding.getRoot().getContext();
        }
        return this.customAction.getActivityListener().getHostActivity();
    }

    public PaytmAdView.a getAdClickListener(final Item item, final int i2) {
        return new PaytmAdView.a() {
            public void onAdClick(android.view.View view) {
                ClickableRVChildViewHolder.this.handleDeepLink(item, i2);
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
