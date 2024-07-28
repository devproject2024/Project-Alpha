package net.one97.paytm.nativesdk.bank_mandate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.databinding.BankEMandateBankItemBinding;

public class BankMandateBankSelectAdapter extends RecyclerView.a<BankSelectViewHolder> {
    private final int limit = 6;
    private Context mContext;
    private List<PayChannelOptions> mList;

    public BankMandateBankSelectAdapter(Context context, List<PayChannelOptions> list) {
        this.mContext = context;
        this.mList = list;
    }

    public BankSelectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new BankSelectViewHolder((BankEMandateBankItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.bank_e_mandate_bank_item, viewGroup, false));
    }

    public void onBindViewHolder(BankSelectViewHolder bankSelectViewHolder, int i2) {
        PayChannelOptions payChannelOptions = this.mList.get(i2);
        if (payChannelOptions != null) {
            bankSelectViewHolder.bankEMandateBankItemBinding.tvBankMandateBankItem.setText(payChannelOptions.getChannelName());
            b.b(this.mContext).a(payChannelOptions.getIconUrl()).a(bankSelectViewHolder.bankEMandateBankItemBinding.ivBankMandateBankItem);
        }
    }

    public int getItemCount() {
        List<PayChannelOptions> list = this.mList;
        if (list == null) {
            return 0;
        }
        if (list.size() > 6) {
            return 6;
        }
        return this.mList.size();
    }

    class BankSelectViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public BankEMandateBankItemBinding bankEMandateBankItemBinding;

        public BankSelectViewHolder(BankEMandateBankItemBinding bankEMandateBankItemBinding2) {
            super(bankEMandateBankItemBinding2.getRoot());
            this.bankEMandateBankItemBinding = bankEMandateBankItemBinding2;
        }
    }
}
