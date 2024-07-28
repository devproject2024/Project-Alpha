package net.one97.paytm.nativesdk.instruments.upicollect.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;

public class UpiAppListAdapter extends RecyclerView.a<UpiAppItemHolder> {
    /* access modifiers changed from: private */
    public List<UpiOptionsModel> appList;
    /* access modifiers changed from: private */
    public OnClickUpiApp onClickUpiApp;
    /* access modifiers changed from: private */
    public int selectedPosition = 0;

    public interface OnClickUpiApp {
        void onClick(UpiOptionsModel upiOptionsModel, boolean z);
    }

    public UpiAppListAdapter(List<UpiOptionsModel> list, OnClickUpiApp onClickUpiApp2) {
        this.appList = list;
        this.onClickUpiApp = onClickUpiApp2;
    }

    public void setSelectedPosition(int i2) {
        this.selectedPosition = i2;
        notifyDataSetChanged();
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public UpiAppItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new UpiAppItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_upi_app, viewGroup, false));
    }

    public void onBindViewHolder(UpiAppItemHolder upiAppItemHolder, final int i2) {
        if (i2 != 4 || this.appList.size() <= 5) {
            upiAppItemHolder.appIcon.setImageDrawable(this.appList.get(i2).getDrawable());
            upiAppItemHolder.tvAppName.setText(this.appList.get(i2).getAppName());
            upiAppItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SDKUtility.isUpiIntentEnabled()) {
                        UpiAppListAdapter.this.onClickUpiApp.onClick((UpiOptionsModel) UpiAppListAdapter.this.appList.get(i2), false);
                        int unused = UpiAppListAdapter.this.selectedPosition = i2;
                        UpiAppListAdapter.this.notifyDataSetChanged();
                    }
                }
            });
            if (i2 != this.selectedPosition) {
                upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_bg);
                upiAppItemHolder.ivSelected.setVisibility(8);
            } else if (SDKUtility.isUpiIntentEnabled()) {
                upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_shadow);
                upiAppItemHolder.ivSelected.setVisibility(0);
            } else {
                upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_bg);
                upiAppItemHolder.ivSelected.setVisibility(8);
            }
        } else if (this.selectedPosition <= 3) {
            upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_bg);
            upiAppItemHolder.appIcon.setImageResource(R.drawable.ic_group_apps);
            upiAppItemHolder.tvAppName.setText("Others");
            upiAppItemHolder.ivSelected.setVisibility(8);
            upiAppItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SDKUtility.isUpiIntentEnabled()) {
                        UpiAppListAdapter.this.onClickUpiApp.onClick((UpiOptionsModel) UpiAppListAdapter.this.appList.get(i2), true);
                        UpiAppListAdapter.this.notifyDataSetChanged();
                    }
                }
            });
        } else if (SDKUtility.isUpiIntentEnabled()) {
            upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_shadow);
            upiAppItemHolder.ivSelected.setVisibility(0);
            upiAppItemHolder.appIcon.setImageDrawable(this.appList.get(this.selectedPosition).getDrawable());
            upiAppItemHolder.tvAppName.setText(this.appList.get(this.selectedPosition).getAppName());
        } else {
            upiAppItemHolder.frameBg.setBackgroundResource(R.drawable.native_circle_bg);
            upiAppItemHolder.ivSelected.setVisibility(8);
            upiAppItemHolder.appIcon.setImageDrawable(this.appList.get(this.selectedPosition).getDrawable());
            upiAppItemHolder.tvAppName.setText(this.appList.get(this.selectedPosition).getAppName());
        }
    }

    public int getItemCount() {
        if (this.appList.size() > 4) {
            return 5;
        }
        return this.appList.size();
    }

    public static class UpiAppItemHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public ImageView appIcon;
        /* access modifiers changed from: private */
        public FrameLayout frameBg;
        /* access modifiers changed from: private */
        public ImageView ivSelected;
        /* access modifiers changed from: private */
        public TextView tvAppName;

        public UpiAppItemHolder(View view) {
            super(view);
            this.appIcon = (ImageView) view.findViewById(R.id.iv_appIcon);
            this.tvAppName = (TextView) view.findViewById(R.id.tv_appName);
            this.ivSelected = (ImageView) view.findViewById(R.id.iv_selected);
            this.frameBg = (FrameLayout) view.findViewById(R.id.fl_bgView);
        }
    }

    public void clearSelected() {
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }
}
