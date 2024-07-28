package net.one97.paytm.upi.requestmoney.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class j extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final RequestMoneyV2SelectBankActivity f69474a;

    /* renamed from: b  reason: collision with root package name */
    List<UpiProfileDefaultBank> f69475b;

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f69476c = ((LayoutInflater) this.f69474a.getSystemService("layout_inflater"));

    public j(RequestMoneyV2SelectBankActivity requestMoneyV2SelectBankActivity, List<UpiProfileDefaultBank> list) {
        this.f69474a = requestMoneyV2SelectBankActivity;
        this.f69475b = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f69476c.inflate(R.layout.rq_universal_list_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        if (vVar instanceof a) {
            final a aVar = (a) vVar;
            aVar.f69488e.setVisibility(8);
            if (i2 < this.f69475b.size()) {
                aVar.f69485b.setText(this.f69474a.getString(R.string.check_balance));
                aVar.f69485b.setTextColor(b.c(this.f69474a, R.color.color_00b9f5));
                aVar.f69485b.setVisibility(8);
                if (!(this.f69475b.get(i2).getCreditBank() == null || this.f69475b.get(i2).getCreditBank().getAccount() == null || this.f69475b.get(i2).getCreditBank().getBankName() == null)) {
                    aVar.f69484a.setText(this.f69475b.get(i2).getCreditBank().getBankName());
                    aVar.f69486c.setText(String.format(this.f69474a.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold), new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(this.f69475b.get(i2).getCreditBank().getAccount()), 4)}));
                }
                if (i2 == this.f69474a.f69240b) {
                    aVar.f69489f.setChecked(true);
                } else {
                    aVar.f69489f.setChecked(false);
                }
            }
            try {
                aVar.f69489f.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        j.this.f69474a.a(i2);
                    }
                });
                aVar.f69487d.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        j.this.f69474a.a(i2);
                    }
                });
                aVar.f69485b.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        try {
                            if (!UpiAppUtils.isNetworkAvailable(j.this.f69474a)) {
                                Toast.makeText(j.this.f69474a, j.this.f69474a.getResources().getString(R.string.no_internet), 0).show();
                            } else if (aVar.f69485b.getText().toString().equalsIgnoreCase(j.this.f69474a.getString(R.string.check_balance)) && (j.this.f69474a instanceof RequestMoneyV2SelectBankActivity) && i2 < j.this.f69474a.f69239a.size()) {
                                aVar.f69485b.setTag(aVar);
                                j.this.f69474a.a(j.this.f69474a.f69239a.get(i2), aVar.f69485b);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final int getItemCount() {
        List<UpiProfileDefaultBank> list = this.f69475b;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f69475b.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f69484a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f69485b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f69486c;

        /* renamed from: d  reason: collision with root package name */
        final View f69487d;

        /* renamed from: e  reason: collision with root package name */
        final View f69488e;

        /* renamed from: f  reason: collision with root package name */
        final RadioButton f69489f;

        a(View view) {
            super(view);
            this.f69489f = (RadioButton) view.findViewById(R.id.radio_button);
            this.f69487d = view.findViewById(R.id.item_rl_root);
            this.f69484a = (TextView) view.findViewById(R.id.source_name);
            this.f69485b = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f69486c = (TextView) view.findViewById(R.id.source_balance);
            this.f69488e = view.findViewById(R.id.wallet_loader);
        }
    }
}
