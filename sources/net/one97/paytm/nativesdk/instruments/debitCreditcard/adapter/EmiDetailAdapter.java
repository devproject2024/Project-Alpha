package net.one97.paytm.nativesdk.instruments.debitCreditcard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.SetOnEmiClickListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;

public class EmiDetailAdapter extends RecyclerView.a<ViewHolder> {
    /* access modifiers changed from: private */
    public DecimalFormat df2 = new DecimalFormat(".##", new DecimalFormatSymbols(Locale.US));
    private List<EmiChannelInfo> emiChannelInfosList;
    private String instantDiscount;
    /* access modifiers changed from: private */
    public SetOnEmiClickListener listener;
    private Context mContext;
    private int selectedPosition = -1;

    public EmiDetailAdapter(Context context, List<EmiChannelInfo> list, SetOnEmiClickListener setOnEmiClickListener) {
        this.mContext = context;
        this.emiChannelInfosList = list;
        this.listener = setOnEmiClickListener;
    }

    public void setSelectedPosition(int i2) {
        this.selectedPosition = i2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_emi_details, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i2) {
        if (i2 % 2 != 0) {
            viewHolder.itemView.setBackgroundColor(this.mContext.getResources().getColor(R.color.color_f9fafb));
        }
        final EmiChannelInfo emiChannelInfo = this.emiChannelInfosList.get(i2);
        viewHolder.txtMonths.setText(this.mContext.getResources().getString(R.string.native_duration, new Object[]{emiChannelInfo.getOfMonths()}));
        viewHolder.txtPercentage.setText(this.mContext.getResources().getString(R.string.native_interest_rate, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(emiChannelInfo.getInterestRate()).doubleValue())}));
        viewHolder.txtEmi.setText(this.mContext.getResources().getString(R.string.native_emi_per_month, new Object[]{emiChannelInfo.getEmiPerMonth()}));
        viewHolder.txtTotal.setText(this.mContext.getResources().getString(R.string.native_emi_per_month, new Object[]{this.df2.format(getTotalValue(emiChannelInfo))}));
        if (this.selectedPosition == i2) {
            viewHolder.rbEmi.setChecked(true);
        } else {
            viewHolder.rbEmi.setChecked(false);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmiDetailAdapter.this.listener.onClick(emiChannelInfo, viewHolder.getAdapterPosition(), EmiDetailAdapter.this.df2.format(EmiDetailAdapter.this.getTotalValue(emiChannelInfo)));
            }
        });
    }

    /* access modifiers changed from: private */
    public double getTotalValue(EmiChannelInfo emiChannelInfo) {
        try {
            return emiChannelInfo.getDoubleEmiPerMonth() * Double.valueOf(emiChannelInfo.getOfMonths()).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public int getItemCount() {
        return this.emiChannelInfosList.size();
    }

    public class ViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public RadioButton rbEmi = ((RadioButton) this.view.findViewById(R.id.rb_emi));
        /* access modifiers changed from: private */
        public TextView txtEmi = ((TextView) this.view.findViewById(R.id.txt_emi));
        /* access modifiers changed from: private */
        public TextView txtMonths = ((TextView) this.view.findViewById(R.id.txt_months));
        /* access modifiers changed from: private */
        public TextView txtPercentage = ((TextView) this.view.findViewById(R.id.txt_percentage));
        /* access modifiers changed from: private */
        public TextView txtTotal = ((TextView) this.view.findViewById(R.id.txt_total));
        private View view;

        public ViewHolder(View view2) {
            super(view2);
            this.view = view2;
        }
    }

    private double getEmiPerMonth(String str, String str2) {
        double effectAfterOfferAmount = SDKUtility.getEffectAfterOfferAmount(this.instantDiscount);
        return (effectAfterOfferAmount + (((((((double) Float.valueOf(str).floatValue()) * effectAfterOfferAmount) * ((double) (Float.valueOf(str2).floatValue() / 12.0f))) / 100.0d) / 12.0d) * ((double) Float.valueOf(str2).floatValue()))) / ((double) Float.valueOf(str2).floatValue());
    }

    public void setInstantDiscount(String str) {
        this.instantDiscount = str;
    }

    public String getInstantDiscount() {
        return this.instantDiscount;
    }
}
