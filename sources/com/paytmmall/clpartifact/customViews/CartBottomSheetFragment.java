package com.paytmmall.clpartifact.customViews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.CartBottomSheetBinding;
import com.paytmmall.clpartifact.view.viewmodel.CartBottomSheetViewModel;
import net.one97.paytm.i.f;

public class CartBottomSheetFragment extends f {
    private CartBottomSheetBinding mBinder;
    private View.OnClickListener mListener;
    private CartBottomSheetViewModel mViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinder = (CartBottomSheetBinding) androidx.databinding.f.a(layoutInflater, R.layout.cart_bottom_sheet, viewGroup, false);
        return this.mBinder.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mViewModel = (CartBottomSheetViewModel) am.a((Fragment) this).a(CartBottomSheetViewModel.class);
        view.findViewById(R.id.crossIcon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartBottomSheetFragment.this.lambda$onViewCreated$0$CartBottomSheetFragment(view);
            }
        });
        view.findViewById(R.id.goToCartBtn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartBottomSheetFragment.this.lambda$onViewCreated$1$CartBottomSheetFragment(view);
            }
        });
        this.mBinder.setViewModel(this.mViewModel);
        this.mBinder.executePendingBindings();
        setBottomParams();
    }

    public /* synthetic */ void lambda$onViewCreated$0$CartBottomSheetFragment(View view) {
        dismissAllowingStateLoss();
    }

    public /* synthetic */ void lambda$onViewCreated$1$CartBottomSheetFragment(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismissAllowingStateLoss();
    }

    private void setBottomParams() {
        TextView textView = (TextView) this.mBinder.getRoot().findViewById(R.id.effective_price_tag);
        ((ImageView) this.mBinder.getRoot().findViewById(R.id.cartArrow)).setImageResource(R.drawable.clp_ic_arrow_down);
        this.mBinder.getRoot().findViewById(R.id.cart_details_container).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartBottomSheetFragment.this.lambda$setBottomParams$2$CartBottomSheetFragment(view);
            }
        });
        ((TextView) this.mBinder.getRoot().findViewById(R.id.priceValue)).setText(this.mViewModel.getFinalPrice());
        ((TextView) this.mBinder.getRoot().findViewById(R.id.itemLabel)).setText(this.mViewModel.getItemLabel());
        int i2 = 0;
        textView.setText(String.format(getResources().getString(R.string.effective_price_tag), new Object[]{this.mViewModel.getEffectivePrice()}));
        if (!this.mViewModel.showEffectivePrice()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public /* synthetic */ void lambda$setBottomParams$2$CartBottomSheetFragment(View view) {
        dismissAllowingStateLoss();
    }

    public void setOnViewClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }
}
