package net.one97.paytm.dynamic.module.mall.emiSubvention.fragment;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.b;
import com.paytmmall.artifact.cart.entity.CJRCart;
import com.paytmmall.artifact.cart.entity.CJRCartProduct;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.e.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.one97.paytm.dynamic.module.mall.emiSubvention.adapter.EMIOrderReviewAdapter;
import net.one97.paytm.paytm_finance.R;

public class EMIOrderReviewFragment extends b {
    private static final String CART_DATA = "CART_DATA";
    private static final String PLAN_ID = "PLAN_ID";
    private static final String PLAN_INTERVAL = "PLAN_INTERVAL";
    private String cartResponse;
    private Double interval;
    private LinearLayout layout;
    private BottomSheetBehavior.a mBottomSheetBehaviorCallback = new BottomSheetBehavior.a() {
        public void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                EMIOrderReviewFragment.this.dismiss();
            }
            if (i2 == 3) {
                EMIOrderReviewFragment.this.setElevation();
            }
            if (i2 == 4) {
                EMIOrderReviewFragment.this.setElevationOff();
            }
        }

        public void onSlide(View view, float f2) {
            EMIOrderReviewFragment.this.setElevationOff();
        }
    };
    private String planId;

    public int getTheme() {
        return R.style.order;
    }

    public static Bundle getDataBundle(String str, String str2, Double d2) {
        Bundle bundle = new Bundle();
        bundle.putString(CART_DATA, str);
        bundle.putString(PLAN_ID, str2);
        bundle.putDouble(PLAN_INTERVAL, d2.doubleValue());
        return bundle;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "";
        this.cartResponse = getArguments() != null ? getArguments().getString(CART_DATA) : str;
        if (getArguments() != null) {
            str = getArguments().getString(PLAN_ID);
        }
        this.planId = str;
        this.interval = Double.valueOf(getArguments() != null ? getArguments().getDouble(PLAN_INTERVAL) : 0.0d);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.custom_order_detail, (ViewGroup) null);
        this.layout = (LinearLayout) inflate.findViewById(R.id.emiOrderHeader);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.close_Bottom_sheet);
        dialog.setContentView(inflate);
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) ((View) inflate.getParent()).getLayoutParams()).f2603a;
        if (behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(this.mBottomSheetBehaviorCallback);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EMIOrderReviewFragment.this.lambda$setupDialog$0$EMIOrderReviewFragment(view);
            }
        });
        setupData(inflate);
    }

    public /* synthetic */ void lambda$setupDialog$0$EMIOrderReviewFragment(View view) {
        dismiss();
    }

    private void setupData(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.orderReviewRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((TextView) view.findViewById(R.id.planTxt)).setText(new DecimalFormat("##,##,##0").format(this.interval) + " Months EMI Plan");
        recyclerView.setAdapter(new EMIOrderReviewAdapter(getActivity(), getDataList(this.cartResponse), this.planId));
    }

    /* access modifiers changed from: private */
    public void setElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.layout.setElevation(8.0f);
        }
    }

    /* access modifiers changed from: private */
    public void setElevationOff() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.layout.setElevation(0.0f);
        }
    }

    private ArrayList<CJRCartProduct> getDataList(String str) {
        CJRCart cart;
        CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) a.a(str, CJRShoppingCart.class);
        if (cJRShoppingCart == null || (cart = cJRShoppingCart.getCart()) == null) {
            return new ArrayList<>();
        }
        return cart.getCartItems();
    }
}
