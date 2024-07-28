package com.paytmmall.clpartifact.widgets.providers;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.PopupMenuListAdpater;
import com.paytmmall.clpartifact.widgets.component.SFPopupWindow;
import java.util.List;

public class MenuWidgetProvider extends BaseWidgetProvider {
    public int getWidgetType() {
        return 100;
    }

    MenuWidgetProvider(View view) {
        super(view);
    }

    private SFPopupWindow getWindowMenu(Activity activity, View view, IGAHandlerListener iGAHandlerListener) {
        try {
            if (!isValid()) {
                return null;
            }
            List<Item> items = view.getItems();
            android.view.View popupView = getPopupView(activity);
            if (popupView == null) {
                return null;
            }
            RecyclerView recyclerView = (RecyclerView) popupView.findViewById(R.id.home_menu_list);
            LinearLayout linearLayout = (LinearLayout) popupView.findViewById(R.id.menuList);
            if (linearLayout == null || recyclerView == null) {
                return null;
            }
            linearLayout.setVisibility(0);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            recyclerView.setAdapter(new PopupMenuListAdpater(items, iGAHandlerListener));
            return createPopup(popupView);
        } catch (Exception unused) {
            return null;
        }
    }

    private SFPopupWindow createPopup(android.view.View view) {
        SFPopupWindow sFPopupWindow = new SFPopupWindow(view);
        sFPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        sFPopupWindow.setOutsideTouchable(false);
        sFPopupWindow.setFocusable(true);
        sFPopupWindow.setTouchable(true);
        return sFPopupWindow;
    }

    private android.view.View getPopupView(Activity activity) {
        return ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.clp_header_menu, (ViewGroup) null);
    }

    public SFPopupWindow getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        return getWindowMenu(fragmentActivity, getView(), iGAHandlerListener);
    }

    public boolean isValid() {
        View view = getView();
        return view.getItems() != null && view.getItems().size() > 0;
    }
}
