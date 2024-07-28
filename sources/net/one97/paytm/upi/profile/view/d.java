package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<BankAccountDetails.BankAccount> f68214a;

    /* renamed from: b  reason: collision with root package name */
    a f68215b;

    /* renamed from: c  reason: collision with root package name */
    Context f68216c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f68217d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f68218e;

    public interface a {
        void a(ArrayList<String> arrayList);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        BankAccountDetails.BankAccount bankAccount = this.f68214a.get(bVar.getAdapterPosition());
        bVar.f68222d.setChecked(true);
        d.this.f68217d.add(bankAccount.getTempAccRefId());
        d.this.f68215b.a(d.this.f68217d);
        TextView textView = bVar.f68219a;
        textView.setText(d.this.f68216c.getString(R.string.upi_acc_no_prefix) + UpiUtils.maskNumber(bankAccount.getMaskedAccountNumber()));
        bVar.f68220b.setText(bankAccount.getBranchAddress());
        bVar.f68221c.setText(UpiConstants.BANK_ACCOUNT_TYPE.valueOf(bankAccount.getAccountType()).getNameDisplayStringId());
        bVar.f68222d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(bankAccount) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f68225a;

            {
                this.f68225a = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    d.this.f68217d.add(this.f68225a.getTempAccRefId());
                    d.this.f68215b.a(d.this.f68217d);
                    return;
                }
                d.this.f68217d.remove(this.f68225a.getTempAccRefId());
                d.this.f68215b.a(d.this.f68217d);
            }
        });
        bVar.f68223e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f68222d.setChecked(!b.this.f68222d.isChecked());
            }
        });
    }

    public d(Context context, a aVar) {
        this.f68218e = LayoutInflater.from(context);
        this.f68216c = context;
        this.f68215b = aVar;
        this.f68214a = new ArrayList();
    }

    public final int getItemCount() {
        List<BankAccountDetails.BankAccount> list = this.f68214a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f68219a;

        /* renamed from: b  reason: collision with root package name */
        TextView f68220b;

        /* renamed from: c  reason: collision with root package name */
        TextView f68221c;

        /* renamed from: d  reason: collision with root package name */
        CheckBox f68222d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f68223e;

        public b(View view) {
            super(view);
            this.f68222d = (CheckBox) view.findViewById(R.id.ckb_bank_select);
            this.f68219a = (TextView) view.findViewById(R.id.tv_acc_no);
            this.f68221c = (TextView) view.findViewById(R.id.tv_account_type);
            this.f68220b = (TextView) view.findViewById(R.id.tv_branch_address);
            this.f68223e = (RelativeLayout) view.findViewById(R.id.rl_parent_container);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f68218e.inflate(R.layout.upi_bank_list_card, viewGroup, false));
    }
}
