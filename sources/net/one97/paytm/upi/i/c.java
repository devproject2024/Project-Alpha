package net.one97.paytm.upi.i;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.e.ai;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final ai f66991a;

    /* renamed from: b  reason: collision with root package name */
    public BankAccountDetails.BankAccount f66992b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, final a aVar) {
        super(view);
        k.c(view, "itemView");
        k.c(aVar, "listener");
        ai a2 = ai.a(view);
        k.a((Object) a2, "UpiSettingsItemBankBinding.bind(itemView)");
        this.f66991a = a2;
        this.f66991a.f66781h.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f66993a;

            {
                this.f66993a = r1;
            }

            public final void onClick(View view) {
                k.a((Object) view, "it");
                if (a.m(view.getContext())) {
                    aVar.c(this.f66993a.a(), this.f66993a.getAdapterPosition());
                    return;
                }
                a aVar = aVar;
                Context context = view.getContext();
                k.a((Object) context, "it.context");
                aVar.a(context);
            }
        });
        this.f66991a.l.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f66995a;

            {
                this.f66995a = r1;
            }

            public final void onClick(View view) {
                k.a((Object) view, "it");
                if (a.m(view.getContext())) {
                    aVar.b(this.f66995a.a(), this.f66995a.getAdapterPosition());
                    return;
                }
                a aVar = aVar;
                Context context = view.getContext();
                k.a((Object) context, "it.context");
                aVar.a(context);
            }
        });
        this.f66991a.j.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f66997a;

            {
                this.f66997a = r1;
            }

            public final void onClick(View view) {
                k.a((Object) view, "it");
                if (!a.m(view.getContext())) {
                    a aVar = aVar;
                    Context context = view.getContext();
                    k.a((Object) context, "it.context");
                    aVar.a(context);
                } else if (this.f66997a.a().isMpinSet()) {
                    a aVar2 = aVar;
                    BankAccountDetails.BankAccount a2 = this.f66997a.a();
                    this.f66997a.getAdapterPosition();
                    aVar2.a(a2);
                } else {
                    a aVar3 = aVar;
                    BankAccountDetails.BankAccount a3 = this.f66997a.a();
                    this.f66997a.getAdapterPosition();
                    aVar3.b(a3);
                }
            }
        });
        this.f66991a.f66780g.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f66999a;

            {
                this.f66999a = r1;
            }

            public final void onClick(View view) {
                k.a((Object) view, "it");
                if (!a.m(view.getContext())) {
                    a aVar = aVar;
                    Context context = view.getContext();
                    k.a((Object) context, "it.context");
                    aVar.a(context);
                    AppCompatRadioButton appCompatRadioButton = this.f66999a.f66991a.f66780g;
                    k.a((Object) appCompatRadioButton, "binding.bankRadio");
                    AppCompatRadioButton appCompatRadioButton2 = this.f66999a.f66991a.f66780g;
                    k.a((Object) appCompatRadioButton2, "binding.bankRadio");
                    appCompatRadioButton.setChecked(!appCompatRadioButton2.isChecked());
                } else if (!this.f66999a.a().isSelected()) {
                    aVar.a(this.f66999a.a(), this.f66999a.getAdapterPosition());
                }
            }
        });
        this.f66991a.a().setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f67001a;

            {
                this.f67001a = r1;
            }

            public final void onClick(View view) {
                k.a((Object) view, "it");
                if (a.m(view.getContext())) {
                    aVar.a(this.f67001a.a(), this.f67001a.getAdapterPosition());
                    return;
                }
                a aVar = aVar;
                Context context = view.getContext();
                k.a((Object) context, "it.context");
                aVar.a(context);
            }
        });
    }

    public final BankAccountDetails.BankAccount a() {
        BankAccountDetails.BankAccount bankAccount = this.f66992b;
        if (bankAccount == null) {
            k.a("bankAccount");
        }
        return bankAccount;
    }
}
