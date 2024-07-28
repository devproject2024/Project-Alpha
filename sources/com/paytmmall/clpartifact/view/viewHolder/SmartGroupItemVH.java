package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSmartGrpGridBinding;
import com.paytmmall.clpartifact.listeners.IClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.utils.SFSColorUtils;
import com.paytmmall.clpartifact.utils.SmartGroupGridUtil;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewbindings.CommonViewBindings;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;

public class SmartGroupItemVH extends ClickableRVChildViewHolder {
    private final int VIEw_ID_POPULAR_SERVICES = 302614;
    private CustomAction customAction;
    private ItemSmartGrpGridBinding dataBinding;
    private IClickListener listener;
    private Context mContext;
    private View view;

    public SmartGroupItemVH(ItemSmartGrpGridBinding itemSmartGrpGridBinding, IGAHandlerListener iGAHandlerListener, IClickListener iClickListener, CustomAction customAction2) {
        super(itemSmartGrpGridBinding, iGAHandlerListener, customAction2);
        this.dataBinding = itemSmartGrpGridBinding;
        this.listener = iClickListener;
        this.mContext = itemSmartGrpGridBinding.getRoot().getContext();
        this.customAction = customAction2;
    }

    public void bindItem(Item item, View view2) {
        this.view = view2;
        setGAData(view2.getGaData());
        if (!item.isGaAdded()) {
            handleGAImpression(item, getAdapterPosition());
        }
        enableItemClick();
        this.dataBinding.setVariable(BR.item, item);
        this.dataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        setCircleViewColor(item);
        setDrawable(item);
        showHideTopLabel(this.dataBinding.tvLabel, item);
    }

    private void showHideTopLabel(TextView textView, Item item) {
        int i2 = 0;
        if (ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN.equalsIgnoreCase(this.view.getType())) {
            this.dataBinding.icRaises.setVisibility(8);
            if (item == null || item.getLayout() == null) {
                textView.setVisibility(4);
                return;
            }
            Item.LayoutData layout = item.getLayout();
            if (!TextUtils.isEmpty(layout.getmLabel())) {
                textView.setText(layout.getmLabel());
                textView.setVisibility(0);
                textView.setTextColor(SFSColorUtils.getParsedColor(layout.getLabelColor(), textView.getContext()));
                textView.setBackground(CommonViewBindings.getRoundedDrawable(SFSColorUtils.getParsedColor(layout.getLabelBgColor(), textView.getContext()), textView.getContext()));
                return;
            }
            return;
        }
        if (item == null || item.getLayout() == null || TextUtils.isEmpty(item.getLayout().getmLabel())) {
            i2 = 4;
        }
        textView.setVisibility(i2);
        this.dataBinding.icRaises.setVisibility(i2);
    }

    private void setCircleViewColor(Item item) {
        int i2;
        ImageView imageView = (ImageView) this.dataBinding.getRoot().findViewById(R.id.groupImageView);
        TextView textView = (TextView) this.dataBinding.getRoot().findViewById(R.id.textView);
        if (!TextUtils.isEmpty(item.getImageUrl()) || item.isMore()) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
            return;
        }
        String image_bg_color = !TextUtils.isEmpty(item.getImage_bg_color()) ? item.getImage_bg_color() : "";
        if (!TextUtils.isEmpty(image_bg_color)) {
            i2 = getParsedColor(image_bg_color);
        } else {
            i2 = this.mContext.getResources().getColor(R.color.color_DEF6FF);
        }
        textView.setBackground(SmartGroupGridUtil.setDrawableColor(i2, this.mContext));
        imageView.setVisibility(8);
        textView.setVisibility(0);
        textView.setText(!TextUtils.isEmpty(item.getName_intial()) ? item.getName_intial() : SmartGroupGridUtil.getFirstLetter(item));
    }

    private int getParsedColor(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return this.mContext.getResources().getColor(R.color.color_DEF6FF);
        }
    }

    public void handleClick(Item item, Integer num) {
        if (item == null) {
            return;
        }
        if (this.listener == null) {
            handleItemClick(item, num.intValue());
        } else if (item.isMore() && !item.isExpanded()) {
            this.listener.onMoreItemCliked(num, this.view);
        } else if (!item.isMore() || !item.isExpanded()) {
            handleItemClick(item, num.intValue());
        } else {
            this.listener.onLessItemCliked(num, this.view);
        }
    }

    private void handleItemClick(Item item, int i2) {
        if (item.isMore() && CLPConstants.URL_TYPE_EMBED.equalsIgnoreCase(item.getUrlType()) && !item.isGaAdded()) {
            GaHandler.getInstance().fireGroupGrid(item, i2);
        }
        handleDeepLink(item, i2);
    }

    public static void setlableText(TextView textView, Item item) {
        if (item != null) {
            try {
                if (item.getLayout() != null && !TextUtils.isEmpty(item.getLayout().getmLabel())) {
                    textView.setText(item.getLayout().getmLabel());
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        textView.setVisibility(8);
    }

    public void setDrawable(Item item) {
        ImageView imageView = (ImageView) this.dataBinding.getRoot().findViewById(R.id.groupImageView);
        if (imageView != null && item != null) {
            if (this.view.getId().longValue() == 302614) {
                setImage(imageView, item, getBundledIcon());
            } else {
                ImageUtility.getInstance().loadImageWithCustomPlaceHolder(imageView, item.getImageUrl(), false, R.drawable.sf_smart_grid_placeholder, CustomActionHelper.INSTANCE.getContext(this.mContext, this.customAction));
            }
        }
    }

    private void setImage(ImageView imageView, Item item, int i2) {
        ImageUtility.getInstance().loadImageWithCustomPlaceHolder(imageView, item.getImageUrl(), false, i2, getContext());
    }

    public int getBundledIcon() {
        return this.itemView.getContext().getResources().obtainTypedArray(R.array.icons).getResourceId(getAdapterPosition(), R.drawable.sfs_paytm_wallet);
    }
}
