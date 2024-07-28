package com.paytm.business.merchantprofile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.utilities.e;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.adapter.EDCBottomSheetAdapter;
import com.paytm.business.merchantprofile.listener.EDCSheetListener;
import com.paytm.business.merchantprofile.view.EDCBottomSheetActivity;

public class EDCBottomSheetAdapter extends RecyclerView.a<e> {
    public final EDCSheetListener mListener;
    public final String[] mPlans;

    public EDCBottomSheetAdapter(String[] strArr, EDCSheetListener eDCSheetListener) {
        this.mPlans = strArr;
        this.mListener = eDCSheetListener;
    }

    public e onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ItemViewHolder(LayoutInflater.from((EDCBottomSheetActivity) this.mListener).inflate(R.layout.pr_bottom_sheet_element, viewGroup, false));
    }

    public void onBindViewHolder(e eVar, int i2) {
        eVar.bindData(this.mPlans[i2], i2);
    }

    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public int getItemCount() {
        return this.mPlans.length;
    }

    public class ItemViewHolder extends e {
        public View view;

        public ItemViewHolder(View view2) {
            super(view2);
            this.view = view2;
        }

        public void bindData(Object obj, int i2) {
            if (obj instanceof String) {
                ((AppCompatTextView) this.view.findViewById(R.id.tv_name)).setText((String) obj);
                this.view.setOnClickListener(new View.OnClickListener(i2) {
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        EDCBottomSheetAdapter.ItemViewHolder.this.lambda$bindData$0$EDCBottomSheetAdapter$ItemViewHolder(this.f$1, view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$bindData$0$EDCBottomSheetAdapter$ItemViewHolder(int i2, View view2) {
            EDCBottomSheetAdapter.this.mListener.onBottomSheetElementClick(i2);
        }
    }
}
