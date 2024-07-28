package net.one97.paytm.nativesdk.emiSubvention.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiPlan;
import net.one97.paytm.nativesdk.emiSubvention.models.PlanDetail;
import net.one97.paytm.nativesdk.emiSubvention.views.EMIPlanActivity;
import net.one97.paytm.nativesdk.emiSubvention.views.ITenureClickHandler;

public class FetchEmiPlanAdapter extends RecyclerView.a<FetchEmiPlanViewHolder> {
    private EmiPlan emiPlanList;
    private ITenureClickHandler iBankDataProvider;
    /* access modifiers changed from: private */
    public int selectedItem;

    public FetchEmiPlanAdapter(EMIPlanActivity eMIPlanActivity, EmiPlan emiPlan, int i2) {
        this.emiPlanList = emiPlan;
        this.iBankDataProvider = eMIPlanActivity;
        this.selectedItem = i2;
    }

    public FetchEmiPlanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FetchEmiPlanViewHolder(LayoutInflater.from(this.iBankDataProvider.getContext()).inflate(R.layout.emirow_layout_recyclerview, viewGroup, false), this.iBankDataProvider);
    }

    public void onBindViewHolder(FetchEmiPlanViewHolder fetchEmiPlanViewHolder, int i2) {
        fetchEmiPlanViewHolder.bindView(this.iBankDataProvider.getContext(), this.emiPlanList, i2);
    }

    public int getItemCount() {
        EmiPlan emiPlan = this.emiPlanList;
        if (emiPlan != null) {
            return emiPlan.getDetails().size();
        }
        return 0;
    }

    class FetchEmiPlanViewHolder extends RecyclerView.v {
        private RadioButton emiplanRadio;
        private LinearLayout showOrderDetail;
        private View tenureView;
        private TextView txtEmiInterval;
        private TextView txvEmiPerMonth;
        private TextView txvEmiTotalCost;
        private TextView txvTotalCashback;

        FetchEmiPlanViewHolder(View view, final ITenureClickHandler iTenureClickHandler) {
            super(view);
            this.emiplanRadio = (RadioButton) view.findViewById(R.id.emiplanRadio);
            this.showOrderDetail = (LinearLayout) view.findViewById(R.id.openOrderDetail);
            this.txtEmiInterval = (TextView) view.findViewById(R.id.emiPlanInterval);
            this.txvEmiPerMonth = (TextView) view.findViewById(R.id.emiPerMonth);
            this.txvEmiTotalCost = (TextView) view.findViewById(R.id.emiTotalCost);
            this.txvTotalCashback = (TextView) view.findViewById(R.id.totalCashback);
            this.tenureView = view.findViewById(R.id.tenureView);
            ((LinearLayout) view.findViewById(R.id.tenurelistLayout)).setOnClickListener(new View.OnClickListener(FetchEmiPlanAdapter.this) {
                public void onClick(View view) {
                    int unused = FetchEmiPlanAdapter.this.selectedItem = FetchEmiPlanViewHolder.this.getAdapterPosition();
                    FetchEmiPlanAdapter.this.notifyDataSetChanged();
                    iTenureClickHandler.setSelectedPlan(FetchEmiPlanAdapter.this.selectedItem);
                }
            });
            this.emiplanRadio.setOnClickListener(new View.OnClickListener(FetchEmiPlanAdapter.this) {
                public void onClick(View view) {
                    int unused = FetchEmiPlanAdapter.this.selectedItem = FetchEmiPlanViewHolder.this.getAdapterPosition();
                    FetchEmiPlanAdapter.this.notifyDataSetChanged();
                    iTenureClickHandler.setSelectedPlan(FetchEmiPlanAdapter.this.selectedItem);
                }
            });
            this.showOrderDetail.setOnClickListener(new View.OnClickListener(FetchEmiPlanAdapter.this) {
                public void onClick(View view) {
                    ITenureClickHandler iTenureClickHandler = iTenureClickHandler;
                    iTenureClickHandler.showBottomSheet(iTenureClickHandler.getContext(), FetchEmiPlanViewHolder.this.getAdapterPosition());
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(Context context, EmiPlan emiPlan, int i2) {
            Double d2;
            Double d3;
            String str;
            List<PlanDetail> details = emiPlan != null ? emiPlan.getDetails() : null;
            PlanDetail planDetail = details != null ? details.get(i2) : null;
            if (planDetail != null) {
                str = getEmiValue(context, Double.valueOf(planDetail.getEmi()), planDetail.getRate());
                d3 = planDetail.getEffectivePrice();
                d2 = planDetail.getInterval();
                setGratification(planDetail.getGratificationCashBack());
            } else {
                str = null;
                d3 = null;
                d2 = null;
            }
            if (!TextUtils.isEmpty(String.valueOf(d2))) {
                this.txtEmiInterval.setText(new DecimalFormat("##,##,##0").format(d2) + " Months");
            }
            if (!TextUtils.isEmpty(str)) {
                this.txvEmiPerMonth.setText(str);
            }
            if (!TextUtils.isEmpty(String.valueOf(d3))) {
                this.txvEmiTotalCost.setText(setTotalcost(context, d3));
            }
            if (FetchEmiPlanAdapter.this.selectedItem == i2) {
                this.txtEmiInterval.setTypeface((Typeface) null, 1);
                this.txvEmiPerMonth.setTypeface((Typeface) null, 1);
                this.txvEmiTotalCost.setTypeface((Typeface) null, 1);
                this.emiplanRadio.setChecked(true);
            } else {
                this.emiplanRadio.setChecked(false);
                this.txtEmiInterval.setTypeface((Typeface) null, 0);
                this.txvEmiPerMonth.setTypeface((Typeface) null, 0);
                this.txvEmiTotalCost.setTypeface((Typeface) null, 0);
            }
            if (details == null || getAdapterPosition() != details.size() - 1) {
                this.tenureView.setVisibility(0);
            } else {
                this.tenureView.setVisibility(8);
            }
        }

        private void setGratification(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.txvTotalCashback.setText(str);
                this.txvTotalCashback.setVisibility(0);
                this.showOrderDetail.setVisibility(0);
                return;
            }
            hideGratificationLayout();
        }

        private String getEmiValue(Context context, Double d2, Double d3) {
            if (TextUtils.isEmpty(String.valueOf(d3)) || d2 == null) {
                return null;
            }
            return context.getString(R.string.txt_emi_per_month, new Object[]{String.valueOf(new DecimalFormat("##,##,##0").format(d2)), String.valueOf(d3)});
        }

        private String setTotalcost(Context context, Double d2) {
            return context.getString(R.string.rupee_symbol) + " " + new DecimalFormat("##,##,##0").format(d2);
        }

        private void hideGratificationLayout() {
            this.txvTotalCashback.setVisibility(8);
            this.showOrderDetail.setVisibility(8);
        }
    }
}
