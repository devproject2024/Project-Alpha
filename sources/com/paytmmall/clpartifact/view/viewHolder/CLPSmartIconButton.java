package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemRootRvNewBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPSmartIconButton extends CLPItemVHWithRV {
    private static final int DEFAULT_SPAN_SIZE = 2;
    /* access modifiers changed from: private */
    public int spanCount;

    public CLPSmartIconButton(ItemRootRvNewBinding itemRootRvNewBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemRootRvNewBinding, iGAHandlerListener, customAction);
        if (CLPUtils.isHomeClient(iGAHandlerListener)) {
            CLPUtils.setHomeMargins(itemRootRvNewBinding.clParent);
        }
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        this.spanCount = getSpanCount(view);
        super.doBinding(view);
    }

    private int getSpanCount(View view) {
        if (view == null || view.getItems() == null) {
            return 2;
        }
        return view.getItems().size();
    }

    public static void setColorbg(ViewGroup viewGroup, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                viewGroup.getBackground().setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTextColor(TextView textView, String str) {
        if (str != null) {
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager getLayoutManager(String str) {
        return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), this.spanCount);
    }

    public class MarginItemDecoration extends RecyclerView.h {
        int margin;
        int topMargin = 0;

        MarginItemDecoration(Context context) {
            this.margin = (int) context.getResources().getDimension(R.dimen.smart_button_padding);
        }

        public void getItemOffsets(Rect rect, android.view.View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            super.getItemOffsets(rect, view, recyclerView, sVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (CLPSmartIconButton.this.spanCount == 2) {
                if (childAdapterPosition % 2 == 0) {
                    rect.right = this.margin;
                } else {
                    rect.left = this.margin;
                }
            }
            rect.top = this.topMargin;
        }
    }

    /* access modifiers changed from: protected */
    public void addItemDecoration(RecyclerView recyclerView) {
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new MarginItemDecoration(recyclerView.getContext()));
        }
    }
}
