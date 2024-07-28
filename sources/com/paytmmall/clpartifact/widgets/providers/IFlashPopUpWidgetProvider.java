package com.paytmmall.clpartifact.widgets.providers;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.activity.FlashPopUpActivity;
import com.paytmmall.clpartifact.widgets.SFSFlashPopUpView;
import com.paytmmall.clpartifact.widgets.component.SFISView;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;

public class IFlashPopUpWidgetProvider extends ISWidgetProvider {
    IFlashPopUpWidgetProvider(View view) {
        super(view);
    }

    public SFISView getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        try {
            View view = getView();
            if (!SFWidgetFactory.TYPE_FLASH_POPUP.equalsIgnoreCase(view.getType()) || !isValid()) {
                return null;
            }
            Item item = view.getItems().get(0);
            return getFlashPopWidget(fragmentActivity, item.getImageUrl(), item.getMUrl(), item);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isValid() {
        return !f.a(getView().getItems());
    }

    private SFSFlashPopUpView getFlashPopWidget(FragmentActivity fragmentActivity, String str, String str2, Item item) {
        if (!isUniqueWidget(fragmentActivity, item.getId())) {
            return null;
        }
        SFSFlashPopUpView sFSFlashPopUpView = new SFSFlashPopUpView(fragmentActivity, FlashPopUpActivity.class);
        sFSFlashPopUpView.putExtra(CLPConstants.ISV_IMG_URL, str);
        sFSFlashPopUpView.putExtra(CLPConstants.ISV_CLICK_URL, str2);
        sFSFlashPopUpView.putExtra(CLPConstants.ISV_AD_ITEM, item);
        sFSFlashPopUpView.putExtra(CLPConstants.IS_BG_ACTIVE, Boolean.valueOf(getView().isBGActive()));
        return sFSFlashPopUpView;
    }
}
