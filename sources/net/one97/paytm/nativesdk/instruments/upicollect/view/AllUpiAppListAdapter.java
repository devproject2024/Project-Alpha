package net.one97.paytm.nativesdk.instruments.upicollect.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;

public class AllUpiAppListAdapter extends RecyclerView.a<UpiAppViewHolder> {
    /* access modifiers changed from: private */
    public BankAppItemClickListener bankAppItemClick;
    /* access modifiers changed from: private */
    public List<UpiOptionsModel> upiOptionsModels;

    public interface BankAppItemClickListener {
        void onClick(UpiOptionsModel upiOptionsModel);
    }

    public AllUpiAppListAdapter(List<UpiOptionsModel> list) {
        this.upiOptionsModels = list;
    }

    public void setBankAppItemClick(BankAppItemClickListener bankAppItemClickListener) {
        this.bankAppItemClick = bankAppItemClickListener;
    }

    /* access modifiers changed from: package-private */
    public void setUpiOptionsModels(List<UpiOptionsModel> list) {
        this.upiOptionsModels = list;
        notifyDataSetChanged();
    }

    public UpiAppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new UpiAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.native_item_all_upi_apps, viewGroup, false));
    }

    public void onBindViewHolder(final UpiAppViewHolder upiAppViewHolder, int i2) {
        upiAppViewHolder.tvAppName.setText(this.upiOptionsModels.get(i2).getAppName());
        upiAppViewHolder.ivAppIcon.setImageDrawable(this.upiOptionsModels.get(i2).getDrawable());
        if (this.bankAppItemClick != null) {
            upiAppViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AllUpiAppListAdapter.this.bankAppItemClick.onClick((UpiOptionsModel) AllUpiAppListAdapter.this.upiOptionsModels.get(upiAppViewHolder.getAdapterPosition()));
                }
            });
        }
    }

    public int getItemCount() {
        List<UpiOptionsModel> list = this.upiOptionsModels;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static class UpiAppViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public ImageView ivAppIcon;
        /* access modifiers changed from: private */
        public TextView tvAppName;

        public UpiAppViewHolder(View view) {
            super(view);
            this.ivAppIcon = (ImageView) view.findViewById(R.id.iv_appIcon);
            this.tvAppName = (TextView) view.findViewById(R.id.tv_appName);
        }
    }
}
