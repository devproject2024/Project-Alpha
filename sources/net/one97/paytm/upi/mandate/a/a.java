package net.one97.paytm.upi.mandate.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.e.p;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends RecyclerView.a<C1349a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<BankAccountDetails.BankAccount> f67016a;

    public a(List<? extends BankAccountDetails.BankAccount> list) {
        k.c(list, "list");
        this.f67016a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1349a aVar = (C1349a) vVar;
        k.c(aVar, "holder");
        BankAccountDetails.BankAccount bankAccount = this.f67016a.get(i2);
        k.c(bankAccount, "bankAccount");
        TextView textView = aVar.f67017a.f66867b;
        k.a((Object) textView, "binding.bankName");
        String bankName = bankAccount.getBankName();
        textView.setText(bankName + UpiUtils.getFormattedMaskedAcc(bankAccount.getAccount()));
        ImageView imageView = aVar.f67017a.f66866a;
        ConstraintLayout a2 = aVar.f67017a.a();
        k.a((Object) a2, "binding.root");
        UpiUtils.setBankIcon(imageView, bankAccount, a2.getContext());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        p a2 = p.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "CollectUnsupportedBankIt….context), parent, false)");
        return new C1349a(this, a2);
    }

    public final int getItemCount() {
        return this.f67016a.size();
    }

    /* renamed from: net.one97.paytm.upi.mandate.a.a$a  reason: collision with other inner class name */
    public final class C1349a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final p f67017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f67018b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1349a(a aVar, p pVar) {
            super(pVar.a());
            k.c(pVar, "binding");
            this.f67018b = aVar;
            this.f67017a = pVar;
        }
    }
}
