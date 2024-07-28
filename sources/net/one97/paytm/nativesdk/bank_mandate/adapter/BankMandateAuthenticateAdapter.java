package net.one97.paytm.nativesdk.bank_mandate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.listeners.BankMandateAuthListener;
import net.one97.paytm.nativesdk.databinding.BankEMandateAuthItemBinding;

public class BankMandateAuthenticateAdapter extends RecyclerView.a<AuthenticateViewHolder> {
    /* access modifiers changed from: private */
    public boolean isDefaultSet = true;
    private Context mContext;
    /* access modifiers changed from: private */
    public List<String> mList;
    /* access modifiers changed from: private */
    public BankMandateAuthListener mListener;
    /* access modifiers changed from: private */
    public int selectedPosition = -1;

    public BankMandateAuthenticateAdapter(Context context, List<String> list, BankMandateAuthListener bankMandateAuthListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = bankMandateAuthListener;
    }

    public AuthenticateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new AuthenticateViewHolder((BankEMandateAuthItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.bank_e_mandate_auth_item, viewGroup, false));
    }

    public void onBindViewHolder(final AuthenticateViewHolder authenticateViewHolder, final int i2) {
        String str = this.mList.get(i2);
        authenticateViewHolder.bankEMandateAuthItemBinding.rbAuthUsing.setText(getMappedAuthMode(str));
        if (this.selectedPosition == i2) {
            authenticateViewHolder.bankEMandateAuthItemBinding.rbAuthUsing.setChecked(true);
        } else {
            authenticateViewHolder.bankEMandateAuthItemBinding.rbAuthUsing.setChecked(false);
        }
        authenticateViewHolder.bankEMandateAuthItemBinding.rbAuthUsing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    BankMandateAuthenticateAdapter.this.mListener.onAuthTypeSelected((String) BankMandateAuthenticateAdapter.this.mList.get(i2));
                    int unused = BankMandateAuthenticateAdapter.this.selectedPosition = authenticateViewHolder.getAdapterPosition();
                    if (BankMandateAuthenticateAdapter.this.isDefaultSet) {
                        boolean unused2 = BankMandateAuthenticateAdapter.this.isDefaultSet = false;
                    } else {
                        BankMandateAuthenticateAdapter.this.notifyDataSetChanged();
                    }
                }
            }
        });
        if (this.selectedPosition == -1 && str.equalsIgnoreCase("NET_BANKING")) {
            authenticateViewHolder.bankEMandateAuthItemBinding.rbAuthUsing.setChecked(true);
        }
    }

    public int getItemCount() {
        List<String> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    class AuthenticateViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public BankEMandateAuthItemBinding bankEMandateAuthItemBinding;

        public AuthenticateViewHolder(BankEMandateAuthItemBinding bankEMandateAuthItemBinding2) {
            super(bankEMandateAuthItemBinding2.getRoot());
            this.bankEMandateAuthItemBinding = bankEMandateAuthItemBinding2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getMappedAuthMode(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1280945827(0x4c59aea3, float:5.7064076E7)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 2134027076(0x7f32ab44, float:2.3749185E38)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "NET_BANKING"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "DEBIT_CARD"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x002f
            if (r4 == r2) goto L_0x002c
            java.lang.String r4 = ""
            return r4
        L_0x002c:
            java.lang.String r4 = "Debit Card"
            return r4
        L_0x002f:
            java.lang.String r4 = "Netbanking"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.bank_mandate.adapter.BankMandateAuthenticateAdapter.getMappedAuthMode(java.lang.String):java.lang.String");
    }
}
