package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.decoration.ItemMarginDecoration;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmall.clpartifact.widgets.component.adapter.FloatingNavigationAdapter;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH;
import java.util.HashMap;
import java.util.List;

public class FloatingNavigationView implements IStaticWidget {
    private final int MAX_SIZE = 5;
    private final int POSITION_NOT_FOUND = -1;
    private Activity activity;
    private IGAHandlerListener listener;
    private View mView;
    private android.view.View navView;

    public void setOnDismissListener(SFWidget.DismissListener dismissListener) {
    }

    public FloatingNavigationView(FragmentActivity fragmentActivity, View view, IGAHandlerListener iGAHandlerListener) {
        this.activity = fragmentActivity;
        this.mView = view;
        View view2 = this.mView;
        if (!(view2 == null || view2.getItems() == null || this.mView.getItems().size() <= 5)) {
            View view3 = this.mView;
            view3.setItems(view3.getItems().subList(0, 5));
        }
        this.listener = iGAHandlerListener;
        getNavView();
    }

    private void getNavView() {
        this.navView = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.floating_nav_rv, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) this.navView.findViewById(R.id.nav_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        int itemMargin = getItemMargin(this.mView);
        if (itemMargin > 0) {
            recyclerView.addItemDecoration(new ItemMarginDecoration(a.a(itemMargin)));
        }
        int rVPadding = getRVPadding(this.mView);
        if (rVPadding > 0) {
            recyclerView.setPadding(a.a(rVPadding), 0, a.a(rVPadding), 0);
        }
        View view = this.mView;
        FloatingNavigationAdapter floatingNavigationAdapter = new FloatingNavigationAdapter(view, this.listener, view.mItems);
        recyclerView.setBackground(getRVDrawable(recyclerView.getContext(), this.mView));
        recyclerView.setAdapter(floatingNavigationAdapter);
    }

    private int getRVPadding(View view) {
        int size = (view == null || view.getItems() == null) ? 0 : view.getItems().size();
        if (size <= 1) {
            return 0;
        }
        if (size == 2 || size == 3) {
            return 18;
        }
        return size != 4 ? 0 : 8;
    }

    private int getItemMargin(View view) {
        int size = (view == null || view.getItems() == null) ? 0 : view.getItems().size();
        if (size > 1) {
            if (size == 2 || size == 3) {
                return 6;
            }
            return size != 4 ? 0 : 2;
        }
    }

    private Drawable getRVDrawable(Context context, View view) {
        if (view == null) {
            return null;
        }
        int radius = getRadius(view.getItems());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(b.c(context, R.color.sf_home_popup_ticker_bg));
        gradientDrawable.setCornerRadius((float) a.a(radius));
        return gradientDrawable;
    }

    private int getRadius(List<Item> list) {
        int size;
        if (list == null || list.size() <= 0 || list.size() >= 6 || (size = list.size()) == 1) {
            return 30;
        }
        if (size == 2) {
            return 25;
        }
        if (size == 3) {
            return 20;
        }
        if (size == 4) {
            return 15;
        }
        if (size != 5) {
            return 30;
        }
        return 10;
    }

    public void showWidget(HashMap<String, Object> hashMap) {
        this.navView.setVisibility(8);
    }

    public void dismissWidget() {
        this.navView.setVisibility(8);
    }

    public android.view.View getView() {
        return this.navView;
    }

    public Point getViewPoint(String str) {
        int findAnimationView = findAnimationView(str);
        if (findAnimationView != -1) {
            RecyclerView.v findViewHolderForAdapterPosition = ((RecyclerView) this.navView.findViewById(R.id.nav_rv)).findViewHolderForAdapterPosition(findAnimationView);
            if (findViewHolderForAdapterPosition instanceof FabBaseVH) {
                return getViewPoint(((FabBaseVH) findViewHolderForAdapterPosition).getAnimationView());
            }
        }
        return new Point(-1, -1);
    }

    private int findAnimationView(String str) {
        View view;
        if (str == null || (view = this.mView) == null) {
            return -1;
        }
        List<Item> items = view.getItems();
        for (int i2 = 0; i2 < items.size(); i2++) {
            if (str.equalsIgnoreCase(items.get(i2).getTag()) || str.equalsIgnoreCase(items.get(i2).getName())) {
                return i2;
            }
        }
        return -1;
    }

    private Point getViewPoint(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public void AnimateView(String str) {
        final int findAnimationView = findAnimationView(str);
        if (findAnimationView != -1) {
            final RecyclerView recyclerView = (RecyclerView) this.navView.findViewById(R.id.nav_rv);
            RecyclerView.v findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findAnimationView);
            if (findViewHolderForAdapterPosition instanceof FabBaseVH) {
                ((FabBaseVH) findViewHolderForAdapterPosition).playAnimation(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        FloatingNavigationView.this.showDot(recyclerView, findAnimationView);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void showDot(RecyclerView recyclerView, int i2) {
        Item item = (this.mView.getItems() == null || this.mView.getItems().size() <= i2) ? null : this.mView.getItems().get(i2);
        if (item != null && recyclerView != null && recyclerView.getAdapter() != null) {
            item.setNotificationActive(true);
            recyclerView.getAdapter().notifyItemChanged(i2);
        }
    }
}
