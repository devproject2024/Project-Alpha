package com.paytmmall.clpartifact.view.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.view.adapter.CLPSortBottomSheetAdapter;
import java.util.ArrayList;
import net.one97.paytm.i.f;

public class CLPSortFilterFragment extends f {
    private static final String SORT_ARRAY = "sortData";
    private IGridResponseUpdateListener localGridUpdateListener = new IGridResponseUpdateListener() {
        public void onGridUpdate(String str, CJRGrid cJRGrid) {
        }

        public void onSortingSelected(CJRSortingKeys cJRSortingKeys) {
            CLPSortFilterFragment.this.mGridResponseUpdateListener.onSortingSelected(cJRSortingKeys);
            CLPSortFilterFragment.this.dismiss();
        }
    };
    private BottomSheetBehavior.a mBottomSheetBehaviorCallback = new BottomSheetBehavior.a() {
        public void onSlide(View view, float f2) {
        }

        public void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                CLPSortFilterFragment.this.dismiss();
            }
        }
    };
    /* access modifiers changed from: private */
    public IGridResponseUpdateListener mGridResponseUpdateListener;
    private ArrayList<CJRSortingKeys> mSortingKeys;

    public static Bundle getDataBundle(ArrayList<CJRSortingKeys> arrayList) {
        Bundle bundle = new Bundle();
        try {
            bundle.putSerializable(SORT_ARRAY, arrayList);
        } catch (Exception unused) {
        }
        return bundle;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSortingKeys = getArguments() != null ? (ArrayList) getArguments().getSerializable(SORT_ARRAY) : new ArrayList<>();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View inflate = View.inflate(getContext(), R.layout.item_sort_bottomsheet, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.closeButton);
        dialog.setContentView(inflate);
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) ((View) inflate.getParent()).getLayoutParams()).f2603a;
        if (behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(this.mBottomSheetBehaviorCallback);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CLPSortFilterFragment.this.lambda$setupDialog$0$CLPSortFilterFragment(view);
            }
        });
        setupData(inflate);
    }

    public /* synthetic */ void lambda$setupDialog$0$CLPSortFilterFragment(View view) {
        dismiss();
    }

    private void setupData(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.sortRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CLPSortBottomSheetAdapter(this.mSortingKeys, this.localGridUpdateListener));
    }

    public void setItemClickListener(IGridResponseUpdateListener iGridResponseUpdateListener) {
        this.mGridResponseUpdateListener = iGridResponseUpdateListener;
    }

    public int getTheme() {
        return R.style.orderclp;
    }
}
