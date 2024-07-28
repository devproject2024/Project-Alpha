package net.one97.paytm.moneytransferv4.accounts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.w;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.ak;
import net.one97.paytm.moneytransfer.c.p;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.q;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.AnimationFactory;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final q f54937a;

    /* renamed from: b  reason: collision with root package name */
    boolean f54938b;

    /* renamed from: c  reason: collision with root package name */
    int f54939c = -1;

    /* renamed from: d  reason: collision with root package name */
    String f54940d = "";

    /* renamed from: e  reason: collision with root package name */
    final Map<String, String> f54941e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    boolean f54942f;

    /* renamed from: g  reason: collision with root package name */
    List<? extends BankAccountDetails.BankAccount> f54943g;

    /* renamed from: h  reason: collision with root package name */
    final b f54944h;

    /* renamed from: i  reason: collision with root package name */
    private final int f54945i;
    private final int j = 1;
    private final int k = 2;

    public interface b {
        void a();

        void a(String str);

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(BankAccountDetails.BankAccount bankAccount, ImageView imageView);

        void a(BankAccountDetails.BankAccount bankAccount, boolean z);
    }

    public h(List<? extends BankAccountDetails.BankAccount> list, b bVar) {
        k.c(list, "list");
        k.c(bVar, "listener");
        this.f54943g = list;
        this.f54944h = bVar;
        q qVar = new q();
        qVar.a();
        this.f54937a = qVar;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f54943g.size()) {
            return this.j;
        }
        return this.f54945i;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f54945i) {
            ak a2 = ak.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            k.a((Object) a2, "MtV4SelfAccountItemViewB….context), parent, false)");
            return new c(this, a2);
        }
        p a3 = p.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a3, "MtAddMoreAccountBinding.….context), parent, false)");
        return new a(this, a3);
    }

    public final int getItemCount() {
        return this.f54943g.size() + 1;
    }

    public final void a(boolean z) {
        this.f54938b = z;
        int i2 = this.f54939c;
        notifyItemChanged(i2, Integer.valueOf(i2));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        boolean z = false;
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) this.f54943g.get(i2);
            k.c(bankAccount, "bankAccount");
            if (cVar.f54951b.f54939c == cVar.getAdapterPosition() && (!kotlin.m.p.a(cVar.f54951b.f54940d))) {
                Map<String, String> map = cVar.f54951b.f54941e;
                String accRefId = bankAccount.getAccRefId();
                k.a((Object) accRefId, "bankAccount.accRefId");
                map.put(accRefId, cVar.f54951b.f54940d);
                cVar.f54951b.f54940d = "";
                cVar.f54951b.f54939c = -1;
            }
            ak akVar = cVar.f54950a;
            cVar.f54951b.f54937a.a(akVar.k, String.valueOf(cVar.getAdapterPosition()));
            AppCompatRadioButton appCompatRadioButton = akVar.f53675h;
            k.a((Object) appCompatRadioButton, "selectBankRadio");
            appCompatRadioButton.setChecked(bankAccount.isSelected());
            String maskedAccountNumber = bankAccount.getMaskedAccountNumber();
            k.a((Object) maskedAccountNumber, "bankAccount.maskedAccountNumber");
            int length = bankAccount.getMaskedAccountNumber().length() - 4;
            if (maskedAccountNumber != null) {
                String substring = maskedAccountNumber.substring(length);
                k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                TextView textView = akVar.f53671d;
                k.a((Object) textView, "bankName");
                textView.setText(bankAccount.getBankName() + " XX " + substring);
                CharSequence bankLogoUrl = bankAccount.getBankLogoUrl();
                if ((bankLogoUrl == null || kotlin.m.p.a(bankLogoUrl)) || !URLUtil.isValidUrl(bankAccount.getBankLogoUrl())) {
                    ImageView imageView = akVar.f53669b;
                    String ifsc = bankAccount.getIfsc();
                    SwipeRevealLayout a2 = akVar.a();
                    k.a((Object) a2, "root");
                    m.a(imageView, ifsc, a2.getContext());
                } else {
                    w.a().a(bankAccount.getBankLogoUrl()).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(akVar.f53669b);
                }
                if (!cVar.f54951b.f54938b || cVar.getAdapterPosition() != cVar.f54951b.f54939c) {
                    AnimationFactory.stopWalletLoader(akVar.f53674g);
                } else {
                    AnimationFactory.startWalletLoader(akVar.f53674g);
                }
                TextView textView2 = akVar.f53672e;
                View view = textView2;
                if (bankAccount.isMpinSet() && cVar.f54951b.f54941e.get(bankAccount.getAccRefId()) == null) {
                    LottieAnimationView lottieAnimationView = akVar.f53674g;
                    k.a((Object) lottieAnimationView, "lottieLoader");
                    if (!f.d(lottieAnimationView)) {
                        z = true;
                    }
                }
                f.a(view, z);
                textView2.setOnClickListener(new c.a(akVar, cVar, bankAccount));
                TextView textView3 = akVar.f53668a;
                f.a((View) textView3, cVar.f54951b.f54941e.containsKey(bankAccount.getAccRefId()));
                textView3.setText(cVar.f54951b.f54941e.get(bankAccount.getAccRefId()));
                TextView textView4 = akVar.f53676i;
                f.a((View) textView4, !bankAccount.isMpinSet());
                textView4.setOnClickListener(new c.b(cVar, bankAccount));
                akVar.j.setOnClickListener(new c.C0993c(akVar, cVar, bankAccount));
                akVar.f53675h.setOnClickListener(new c.d(cVar, bankAccount));
                akVar.f53673f.setOnClickListener(new c.e(cVar, bankAccount));
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } else if (vVar instanceof a) {
            a aVar = (a) vVar;
            p pVar = aVar.f54946a;
            pVar.f53811a.setOnClickListener(new a.C0992a(aVar));
            pVar.a().setOnClickListener(new a.b(aVar));
            AppCompatRadioButton appCompatRadioButton2 = pVar.f53811a;
            k.a((Object) appCompatRadioButton2, "addBankRadio");
            appCompatRadioButton2.setChecked(aVar.f54947b.f54942f);
            TextView textView5 = pVar.f53812b;
            ConstraintLayout a3 = pVar.a();
            k.a((Object) a3, "root");
            Context context = a3.getContext();
            k.a((Object) context, "root.context");
            textView5.setTextSize(0, context.getResources().getDimension(R.dimen.text_size_14sp));
            TextView textView6 = pVar.f53812b;
            ConstraintLayout a4 = aVar.f54946a.a();
            k.a((Object) a4, "binding.root");
            textView6.setTextColor(androidx.core.content.b.c(a4.getContext(), R.color.color_1D2F54));
            TextView textView7 = pVar.f53812b;
            ConstraintLayout a5 = aVar.f54946a.a();
            k.a((Object) a5, "binding.root");
            textView7.setText(a5.getContext().getString(R.string.mt_v4_self_account_add_bank_account));
            AppCompatRadioButton appCompatRadioButton3 = pVar.f53811a;
            k.a((Object) appCompatRadioButton3, "addBankRadio");
            appCompatRadioButton3.setVisibility(0);
            ImageView imageView2 = pVar.f53815e;
            k.a((Object) imageView2, "plusIcon");
            imageView2.setVisibility(8);
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ak f54950a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f54951b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h hVar, ak akVar) {
            super(akVar.a());
            k.c(akVar, "binding");
            this.f54951b = hVar;
            this.f54950a = akVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ak f54952a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f54953b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54954c;

            a(ak akVar, c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54952a = akVar;
                this.f54953b = cVar;
                this.f54954c = bankAccount;
            }

            public final void onClick(View view) {
                if (!this.f54953b.f54951b.f54938b) {
                    this.f54953b.f54951b.f54939c = this.f54953b.getAdapterPosition();
                    this.f54953b.f54951b.f54944h.a(this.f54954c);
                }
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f54955a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54956b;

            b(c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54955a = cVar;
                this.f54956b = bankAccount;
            }

            public final void onClick(View view) {
                this.f54955a.f54951b.f54944h.a(this.f54956b, false);
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.h$c$c  reason: collision with other inner class name */
        static final class C0993c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ak f54957a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f54958b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54959c;

            C0993c(ak akVar, c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54957a = akVar;
                this.f54958b = cVar;
                this.f54959c = bankAccount;
            }

            public final void onClick(View view) {
                b bVar = this.f54958b.f54951b.f54944h;
                BankAccountDetails.BankAccount bankAccount = this.f54959c;
                ImageView imageView = this.f54957a.f53669b;
                k.a((Object) imageView, "bankImage");
                bVar.a(bankAccount, imageView);
                this.f54958b.f54951b.f54937a.a(String.valueOf(this.f54958b.getAdapterPosition()));
            }
        }

        static final class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f54960a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54961b;

            d(c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54960a = cVar;
                this.f54961b = bankAccount;
            }

            public final void onClick(View view) {
                b bVar = this.f54960a.f54951b.f54944h;
                String accRefId = this.f54961b.getAccRefId();
                k.a((Object) accRefId, "bankAccount.accRefId");
                bVar.a(accRefId);
            }
        }

        static final class e implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f54962a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54963b;

            e(c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54962a = cVar;
                this.f54963b = bankAccount;
            }

            public final void onClick(View view) {
                b bVar = this.f54962a.f54951b.f54944h;
                String accRefId = this.f54963b.getAccRefId();
                k.a((Object) accRefId, "bankAccount.accRefId");
                bVar.a(accRefId);
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final p f54946a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f54947b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, p pVar) {
            super(pVar.a());
            k.c(pVar, "binding");
            this.f54947b = hVar;
            this.f54946a = pVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.h$a$a  reason: collision with other inner class name */
        static final class C0992a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f54948a;

            C0992a(a aVar) {
                this.f54948a = aVar;
            }

            public final void onClick(View view) {
                this.f54948a.f54947b.f54944h.a();
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f54949a;

            b(a aVar) {
                this.f54949a = aVar;
            }

            public final void onClick(View view) {
                this.f54949a.f54947b.f54944h.a();
            }
        }
    }
}
