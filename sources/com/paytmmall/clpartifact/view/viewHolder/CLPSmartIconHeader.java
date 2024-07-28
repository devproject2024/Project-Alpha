package com.paytmmall.clpartifact.view.viewHolder;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.databinding.ItemSmartHeaderRootBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.DotsIndicatorDecoration;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CLPSmartIconHeader extends CLPItemVHWithRV {
    private final int ITEM_COUNT = 3;
    private ItemSmartHeaderRootBinding binding;
    private CustomAction customAction;

    /* access modifiers changed from: protected */
    public boolean shouldRemoveFling() {
        return false;
    }

    public CLPSmartIconHeader(ItemSmartHeaderRootBinding itemSmartHeaderRootBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemSmartHeaderRootBinding, iGAHandlerListener, customAction2);
        this.binding = itemSmartHeaderRootBinding;
        this.customAction = customAction2;
        if (CLPUtils.isHomeClient(iGAHandlerListener)) {
            if (!ImageUtility.isActivityDestroyed(getContext())) {
                ImageUtility.loadDrawableAsync(itemSmartHeaderRootBinding.backgroundImage, getContext(), R.drawable.smart_icon_bg_rec);
            }
            CLPUtils.setHomeMargins(itemSmartHeaderRootBinding.clParent);
        }
        itemSmartHeaderRootBinding.rvThinBanner.setNestedScrollingEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(modifyView(view));
        ImageView imageView = (ImageView) this.mViewDataBinding.getRoot().findViewById(R.id.img_bg);
        boolean z = false;
        if (imageView != null && !TextUtils.isEmpty(view.getImageUrl()) && !ImageUtility.isActivityDestroyed(getContext())) {
            imageView.setVisibility(0);
            ImageUtility.loadBackgroundDrawableAsync((android.view.View) imageView, getContext(), view.getImageUrl());
            z = true;
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        setHomeMargins(this.binding.clParent, z);
    }

    /* access modifiers changed from: protected */
    public CLPItemRVAdapter getAdapter(View view) {
        view.setGaData(getGAData());
        return new CLPItemRVAdapter(view, getItems(view), getIgaHandlerListener(), view.getId(), this.customAction);
    }

    /* access modifiers changed from: protected */
    public List<Item> getItems(View view) {
        TreeMap<Integer, List<Item>> smartItems = view.getSmartItems();
        ArrayList arrayList = new ArrayList();
        if (smartItems != null) {
            for (int i2 = 0; i2 < smartItems.size(); i2++) {
                Item item = new Item();
                try {
                    item.setmId(CLPArtifact.getInstance().getCommunicationListener().getClientRequestID() + i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    item.setmId(String.valueOf(i2));
                }
                item.setItems(smartItems.get(Integer.valueOf(i2)));
                item.setParentType(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER);
                arrayList.add(item);
            }
        }
        return arrayList;
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

    public static void setText(TextView textView, Item item) {
        if (item != null) {
            try {
                if (!TextUtils.isEmpty(item.getName())) {
                    textView.setText(item.getName());
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        textView.setVisibility(8);
    }

    public static void labelVisibility(android.view.View view, List<Item> list, int i2) {
        int i3 = 4;
        try {
            if (!TextUtils.isEmpty(list.get(i2).getLayout().getmLabel())) {
                i3 = 0;
            }
        } catch (Exception unused) {
        }
        view.setVisibility(i3);
    }

    public static void setTextnew(TextView textView, List<Item> list, int i2) {
        if (list != null) {
            try {
                if (list.get(i2) != null) {
                    textView.setText(list.get(i2).getName());
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        textView.setVisibility(8);
    }

    private View modifyView(View view) {
        view.setSmartItems(setWalletStripMapData(view.getItems()));
        return view;
    }

    private TreeMap<Integer, List<Item>> setWalletStripMapData(List<Item> list) {
        TreeMap<Integer, List<Item>> treeMap = new TreeMap<>();
        if (list != null && !list.isEmpty()) {
            treeMap.clear();
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size()) {
                int i4 = i2 + 3;
                ArrayList arrayList = new ArrayList();
                while (i2 < list.size() && i2 < i4) {
                    arrayList.add(list.get(i2));
                    i2++;
                }
                treeMap.put(Integer.valueOf(i3), arrayList);
                i3++;
                i2 = i4;
            }
        }
        return treeMap;
    }

    /* access modifiers changed from: protected */
    public DotsIndicatorDecoration getDotIndicator() {
        int dimensionPixelSize = this.mViewDataBinding.getRoot().getContext().getResources().getDimensionPixelSize(R.dimen.radius);
        return new DotsIndicatorDecoration(dimensionPixelSize, dimensionPixelSize * 4, ViewUtils.convertDpToPixel(4.0f, this.itemView.getContext()), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.filter_gray_color), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.white));
    }

    /* access modifiers changed from: protected */
    public void addItemDecoration(RecyclerView recyclerView) {
        try {
            ((ConstraintLayout.LayoutParams) recyclerView.getLayoutParams()).topMargin = (int) recyclerView.getContext().getResources().getDimension(R.dimen.dimen_10dp);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void setHomeMargins(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            int a2 = a.a(15);
            if (!z) {
                a2 = a.a(3);
            }
            marginLayoutParams.bottomMargin = a2;
            marginLayoutParams.topMargin = a.a(0);
        }
    }
}
