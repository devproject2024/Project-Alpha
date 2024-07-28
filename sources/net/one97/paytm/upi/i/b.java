package net.one97.paytm.upi.i;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UPIEnglishNumberToWords;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BankAccountDetails.BankAccount> f66989a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final a f66990b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        c cVar = (c) vVar;
        k.c(cVar, "holder");
        BankAccountDetails.BankAccount bankAccount = this.f66989a.get(i2);
        k.a((Object) bankAccount, "bankList[position]");
        BankAccountDetails.BankAccount bankAccount2 = bankAccount;
        k.c(bankAccount2, "bankAccount");
        cVar.f66992b = bankAccount2;
        TextView textView = cVar.f66991a.f66779f;
        k.a((Object) textView, "binding.bankName");
        textView.setText(bankAccount2.getBankName());
        if (bankAccount2.isSelected()) {
            cVar.f66991a.f66779f.setTypeface(Typeface.DEFAULT_BOLD, 0);
        } else {
            cVar.f66991a.f66779f.setTypeface(Typeface.SANS_SERIF, 0);
        }
        String accountType = bankAccount2.getAccountType();
        k.a((Object) accountType, "bankAccount.accountType");
        UpiConstants.BANK_ACCOUNT_TYPE valueOf = UpiConstants.BANK_ACCOUNT_TYPE.valueOf(accountType);
        TextView textView2 = cVar.f66991a.f66777d;
        k.a((Object) textView2, "binding.bankAccount");
        View view = cVar.itemView;
        k.a((Object) view, "itemView");
        textView2.setText(view.getContext().getString(valueOf.getAccDisplayStringId(), new Object[]{UpiAppUtils.getAccountNoV4Format(bankAccount2.getAccount())}));
        ImageView imageView = cVar.f66991a.f66778e;
        String ifsc = bankAccount2.getIfsc();
        View view2 = cVar.itemView;
        k.a((Object) view2, "itemView");
        UpiAppUtils.setBankIcon(imageView, ifsc, view2.getContext());
        if (bankAccount2.isMpinSet()) {
            TextView textView3 = cVar.f66991a.j;
            k.a((Object) textView3, "binding.mpin");
            View view3 = cVar.itemView;
            k.a((Object) view3, "itemView");
            textView3.setText(view3.getContext().getString(R.string.upi_setting_create_mpin));
        } else {
            TextView textView4 = cVar.f66991a.j;
            k.a((Object) textView4, "binding.mpin");
            View view4 = cVar.itemView;
            k.a((Object) view4, "itemView");
            textView4.setText(view4.getContext().getString(R.string.upi_setting_reset_mpin));
            TextView textView5 = cVar.f66991a.f66781h;
            k.a((Object) textView5, "binding.checkBalance");
            f.a((View) textView5);
        }
        if (bankAccount2.progress) {
            AnimationFactory.startWalletLoader(cVar.f66991a.k);
        } else {
            AnimationFactory.stopWalletLoader(cVar.f66991a.k);
        }
        if (TextUtils.isEmpty(bankAccount2.balanceAccountType) || TextUtils.isEmpty(bankAccount2.availableBalance)) {
            TextView textView6 = cVar.f66991a.f66781h;
            k.a((Object) textView6, "binding.checkBalance");
            textView6.setVisibility(0);
            TextView textView7 = cVar.f66991a.f66775b;
            k.a((Object) textView7, "binding.amountInWords");
            textView7.setVisibility(8);
            Group group = cVar.f66991a.f66776c;
            k.a((Object) group, "binding.balanceGroup");
            f.a((View) group);
        } else {
            String str = bankAccount2.balanceAccountType;
            if (str != null) {
                k.a((Object) str, "it");
                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str) != UpiConstants.BANK_ACCOUNT_TYPE.UOD) {
                    UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str);
                    UpiConstants.BANK_ACCOUNT_TYPE bank_account_type = UpiConstants.BANK_ACCOUNT_TYPE.SOD;
                }
            }
            TextView textView8 = cVar.f66991a.f66774a;
            k.a((Object) textView8, "binding.amount");
            View view5 = cVar.itemView;
            k.a((Object) view5, "itemView");
            textView8.setText(view5.getContext().getString(R.string.upi_setting_rupee, new Object[]{UpiAppUtils.priceToString(bankAccount2.availableBalance)}));
            CharSequence convert = UPIEnglishNumberToWords.convert(bankAccount2.availableBalance);
            if (convert == null || convert.length() == 0) {
                TextView textView9 = cVar.f66991a.f66775b;
                k.a((Object) textView9, "binding.amountInWords");
                textView9.setVisibility(8);
            } else {
                TextView textView10 = cVar.f66991a.f66775b;
                k.a((Object) textView10, "binding.amountInWords");
                textView10.setText(convert);
                TextView textView11 = cVar.f66991a.f66775b;
                k.a((Object) textView11, "binding.amountInWords");
                textView11.setVisibility(0);
            }
            TextView textView12 = cVar.f66991a.m;
            k.a((Object) textView12, "binding.timestamp");
            View view6 = cVar.itemView;
            k.a((Object) view6, "itemView");
            textView12.setText(view6.getContext().getString(R.string.upi_setting_avlbl_balance, new Object[]{bankAccount2.formattedTimeStamp}));
            TextView textView13 = cVar.f66991a.f66781h;
            k.a((Object) textView13, "binding.checkBalance");
            textView13.setVisibility(4);
            Group group2 = cVar.f66991a.f66776c;
            k.a((Object) group2, "binding.balanceGroup");
            f.b((View) group2);
        }
        AppCompatRadioButton appCompatRadioButton = cVar.f66991a.f66780g;
        k.a((Object) appCompatRadioButton, "binding.bankRadio");
        appCompatRadioButton.setChecked(bankAccount2.isSelected());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upi_settings_item_bank, viewGroup, false);
        k.a((Object) inflate, "view");
        return new c(inflate, this.f66990b);
    }

    public b(a aVar) {
        k.c(aVar, "listener");
        this.f66990b = aVar;
    }

    public final int getItemCount() {
        return this.f66989a.size();
    }

    public final void a(ArrayList<BankAccountDetails.BankAccount> arrayList) {
        k.c(arrayList, "bankAccountList");
        this.f66989a = arrayList;
        notifyDataSetChanged();
    }

    public final void a(int i2) {
        if (i2 >= 0) {
            this.f66989a.get(i2).progress = true;
            notifyItemChanged(i2);
        }
    }

    public final void b(int i2) {
        if (i2 >= 0) {
            try {
                this.f66989a.get(i2).progress = false;
                notifyItemChanged(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                Iterator<BankAccountDetails.BankAccount> it2 = this.f66989a.iterator();
                while (it2.hasNext()) {
                    it2.next().progress = false;
                }
                notifyDataSetChanged();
            }
        }
    }
}
