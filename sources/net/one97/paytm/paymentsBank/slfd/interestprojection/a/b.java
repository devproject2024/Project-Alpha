package net.one97.paytm.paymentsBank.slfd.interestprojection.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.interestprojection.a.b;
import net.one97.paytm.paymentsBank.slfd.interestprojection.c.d;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19159a;

    /* renamed from: b  reason: collision with root package name */
    private List<FDPostTransactionModel.b> f19160b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f19161c = new boolean[1000];

    /* renamed from: d  reason: collision with root package name */
    private int f19162d;

    /* renamed from: e  reason: collision with root package name */
    private d f19163e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        if (this.f19160b.size() <= 0) {
            return;
        }
        if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(this.f19160b.get(i2).f19219d)) {
            FDPostTransactionModel.b bVar = this.f19160b.get(i2);
            aVar.f19164a.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_ic_failed));
            aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_failed_transfer_of, new Object[]{this.f19159a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar.f19217b))})}));
            aVar.f19167d.setVisibility(8);
            aVar.f19165b.setTextColor(this.f19159a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_fd5c5c));
            aVar.f19166c.setText(this.f19159a.getString(R.string.pb_fd_fd_number, new Object[]{bVar.f19216a}));
            aVar.f19168e.setVisibility(8);
            aVar.j.setVisibility(8);
            aVar.f19172i.setVisibility(8);
        } else if ("success".equalsIgnoreCase(this.f19160b.get(i2).f19219d)) {
            FDPostTransactionModel.b bVar2 = this.f19160b.get(i2);
            aVar.f19164a.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_ic_success));
            aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_transferred_from_your_fd, new Object[]{this.f19159a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar2.f19217b))})}));
            aVar.f19165b.setTextColor(this.f19159a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_21c17a));
            aVar.f19167d.setVisibility(0);
            aVar.f19168e.setVisibility(8);
            aVar.f19167d.setOnClickListener(new View.OnClickListener(i2, aVar) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ b.a f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    b.this.a(this.f$1, this.f$2, view);
                }
            });
            aVar.f19166c.setText(this.f19159a.getString(R.string.pb_fd_fd_number, new Object[]{bVar2.f19216a}));
            aVar.f19169f.setText(this.f19159a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar2.f19217b))}));
            aVar.f19170g.setText(this.f19159a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar2.f19222g))}));
            TextView textView = aVar.f19171h;
            Context context = this.f19159a;
            int i3 = R.string.pb_fd_interest_earned_at_rate;
            textView.setText(context.getString(i3, new Object[]{bVar2.f19218c.toString() + "%"}));
            aVar.j.setVisibility(0);
            aVar.f19172i.setVisibility(0);
            if (bVar2.f19221f == 0.0d) {
                aVar.j.setVisibility(8);
                aVar.f19172i.setVisibility(8);
                return;
            }
            aVar.j.setVisibility(0);
            aVar.f19172i.setVisibility(0);
            aVar.f19172i.setText(this.f19159a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar2.f19221f))}));
        } else if (SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING.equalsIgnoreCase(this.f19160b.get(i2).f19219d) && this.f19162d == net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING.getCode()) {
            FDPostTransactionModel.b bVar3 = this.f19160b.get(i2);
            aVar.f19164a.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_ic_pending));
            if (d.FINISHED.equals(this.f19163e)) {
                aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_pending_transfer_of, new Object[]{this.f19159a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar3.f19217b))})}));
            } else {
                aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_processing_transfer_of, new Object[]{this.f19159a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar3.f19217b))})}));
            }
            aVar.f19165b.setTextColor(this.f19159a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_ffa400));
            aVar.f19167d.setVisibility(8);
            aVar.f19166c.setText(this.f19159a.getString(R.string.pb_fd_fd_number, new Object[]{bVar3.f19216a}));
            aVar.f19168e.setVisibility(8);
            aVar.j.setVisibility(8);
            aVar.f19172i.setVisibility(8);
        } else if (SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING.equalsIgnoreCase(this.f19160b.get(i2).f19219d) && this.f19162d == net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_PENDING.getCode()) {
            FDPostTransactionModel.b bVar4 = this.f19160b.get(i2);
            aVar.f19164a.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_ic_pending));
            if (d.FINISHED.equals(this.f19163e)) {
                aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_pending_transfer_of, new Object[]{this.f19159a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar4.f19217b))})}));
            } else {
                aVar.f19165b.setText(this.f19159a.getString(R.string.pb_fd_processing_transfer_of, new Object[]{this.f19159a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(bVar4.f19217b))})}));
            }
            aVar.f19167d.setVisibility(8);
            aVar.f19165b.setTextColor(this.f19159a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_ffa400));
            aVar.f19166c.setText(this.f19159a.getString(R.string.pb_fd_fd_number, new Object[]{bVar4.f19216a}));
            aVar.f19168e.setVisibility(8);
            aVar.j.setVisibility(8);
            aVar.f19172i.setVisibility(8);
        }
    }

    public b(Context context, List<FDPostTransactionModel.b> list, int i2) {
        this.f19159a = context;
        this.f19160b.addAll(list);
        this.f19162d = i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, a aVar, View view) {
        if (this.f19161c[i2]) {
            aVar.f19168e.setVisibility(8);
            aVar.f19167d.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_down_arrow));
            this.f19161c[i2] = false;
            return;
        }
        aVar.f19168e.setVisibility(0);
        aVar.f19167d.setImageDrawable(this.f19159a.getResources().getDrawable(R.drawable.pb_fd_up_arrow));
        this.f19161c[i2] = true;
    }

    public final int getItemCount() {
        return this.f19160b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f19164a;

        /* renamed from: b  reason: collision with root package name */
        TextView f19165b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19166c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f19167d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f19168e;

        /* renamed from: f  reason: collision with root package name */
        TextView f19169f;

        /* renamed from: g  reason: collision with root package name */
        TextView f19170g;

        /* renamed from: h  reason: collision with root package name */
        TextView f19171h;

        /* renamed from: i  reason: collision with root package name */
        TextView f19172i;
        TextView j;

        public a(View view) {
            super(view);
            this.f19164a = (ImageView) view.findViewById(R.id.iv_fd_trans_status);
            this.f19165b = (TextView) view.findViewById(R.id.tv_trans_status);
            this.f19166c = (TextView) view.findViewById(R.id.tv_fd_no);
            this.f19167d = (ImageView) view.findViewById(R.id.iv_open_arrow);
            this.f19168e = (RelativeLayout) view.findViewById(R.id.rl_fd_interest_detail);
            this.f19169f = (TextView) view.findViewById(R.id.tv_requested_amount_value);
            this.f19170g = (TextView) view.findViewById(R.id.tv_interest_earned_value);
            this.f19171h = (TextView) view.findViewById(R.id.tv_interest_earned);
            this.f19172i = (TextView) view.findViewById(R.id.tv_tax_deducted_value);
            this.j = (TextView) view.findViewById(R.id.tv_tax_deducted);
        }
    }

    public final void a(d dVar) {
        this.f19163e = dVar;
        notifyDataSetChanged();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_fd_transaction_detail, viewGroup, false));
    }
}
