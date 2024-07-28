package net.one97.paytm.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.gson.l;
import com.google.gson.o;
import com.squareup.picasso.w;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.contacts.entities.beans.ContactInfo;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.contacts.entities.beans.Meta;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.ab;
import net.one97.paytm.moneytransfer.c.an;
import net.one97.paytm.moneytransfer.c.ao;
import net.one97.paytm.moneytransfer.c.ap;
import net.one97.paytm.moneytransfer.c.h;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.search.SearchTitleModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CircularImageView;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    boolean f53138a;

    /* renamed from: b  reason: collision with root package name */
    int f53139b = -1;

    /* renamed from: c  reason: collision with root package name */
    String f53140c = "";

    /* renamed from: d  reason: collision with root package name */
    final Map<String, String> f53141d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    List<? extends Object> f53142e;

    /* renamed from: f  reason: collision with root package name */
    final e f53143f;

    public interface e {
        void a(BankAccountDetails.BankAccount bankAccount);

        void a(BankAccountDetails.BankAccount bankAccount, boolean z);

        void b(ContactsResponse contactsResponse, String str);

        void b(BankAccountDetails.BankAccount bankAccount);

        void i();
    }

    public c(List<? extends Object> list, e eVar) {
        k.c(list, "list");
        k.c(eVar, "listener");
        this.f53142e = list;
        this.f53143f = eVar;
    }

    public final int getItemViewType(int i2) {
        Object obj = this.f53142e.get(i2);
        if (obj instanceof SearchTitleModel) {
            return 0;
        }
        if (obj instanceof BankAccountDetails.BankAccount) {
            return 1;
        }
        if (obj instanceof b) {
            return 3;
        }
        if (obj instanceof ContactsResponse) {
            return 2;
        }
        if (obj instanceof a) {
            return 4;
        }
        throw new IllegalStateException("unknown model " + this.f53142e.get(i2));
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 0) {
            ap a2 = ap.a(from, viewGroup);
            k.a((Object) a2, "TransferToBankAccTitleIt…(inflater, parent, false)");
            return new d(a2);
        } else if (i2 == 1) {
            an a3 = an.a(from, viewGroup);
            k.a((Object) a3, "TransferToBankAccBankIte…(inflater, parent, false)");
            return new a(this, a3);
        } else if (i2 == 2) {
            ao a4 = ao.a(from, viewGroup);
            k.a((Object) a4, "TransferToBankAccBenefic…(inflater, parent, false)");
            return new b(this, a4);
        } else if (i2 == 3) {
            h a5 = h.a(from, viewGroup);
            k.a((Object) a5, "DummySelfAccountsViewBin…(inflater, parent, false)");
            return new C0951c(a5);
        } else if (i2 == 4) {
            ab a6 = ab.a(from, viewGroup);
            k.a((Object) a6, "MtV4BeneficiaryViewAllBi…(inflater, parent, false)");
            return new f(this, a6);
        } else {
            throw new IllegalStateException("unknown viewType ".concat(String.valueOf(i2)));
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        k.c(vVar, "holder");
        if (vVar instanceof d) {
            d dVar = (d) vVar;
            Object obj = this.f53142e.get(i2);
            if (obj != null) {
                SearchTitleModel searchTitleModel = (SearchTitleModel) obj;
                k.c(searchTitleModel, "title");
                TextView a2 = dVar.f53158a.a();
                k.a((Object) a2, "binding.root");
                a2.setText(searchTitleModel.getTitleText());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.search.SearchTitleModel");
        }
        String str2 = "";
        boolean z = false;
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            Object obj2 = this.f53142e.get(i2);
            if (obj2 != null) {
                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) obj2;
                k.c(bankAccount, "bankAccount");
                if (aVar.f53145b.f53139b == aVar.getAdapterPosition() && (!p.a(aVar.f53145b.f53140c))) {
                    Map<String, String> map = aVar.f53145b.f53141d;
                    String accRefId = bankAccount.getAccRefId();
                    k.a((Object) accRefId, "bankAccount.accRefId");
                    map.put(accRefId, aVar.f53145b.f53140c);
                    aVar.f53145b.f53140c = str2;
                    aVar.f53145b.f53139b = -1;
                }
                an anVar = aVar.f53144a;
                String maskedAccountNumber = bankAccount.getMaskedAccountNumber();
                k.a((Object) maskedAccountNumber, "bankAccount.maskedAccountNumber");
                int length = bankAccount.getMaskedAccountNumber().length() - 4;
                if (maskedAccountNumber != null) {
                    String substring = maskedAccountNumber.substring(length);
                    k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    TextView textView = anVar.f53694d;
                    k.a((Object) textView, "bankName");
                    textView.setText(bankAccount.getBankName() + " XX " + substring);
                    ImageView imageView = anVar.f53692b;
                    ConstraintLayout a3 = anVar.a();
                    k.a((Object) a3, "root");
                    UpiUtils.setBankIcon(imageView, bankAccount, a3.getContext());
                    if (!aVar.f53145b.f53138a || aVar.getAdapterPosition() != aVar.f53145b.f53139b) {
                        AnimationFactory.stopWalletLoader(anVar.f53697g);
                    } else {
                        AnimationFactory.startWalletLoader(anVar.f53697g);
                    }
                    TextView textView2 = anVar.f53695e;
                    View view = textView2;
                    if (bankAccount.isMpinSet() && aVar.f53145b.f53141d.get(bankAccount.getAccRefId()) == null) {
                        LottieAnimationView lottieAnimationView = anVar.f53697g;
                        k.a((Object) lottieAnimationView, "lottieLoader");
                        if (!net.one97.paytm.upi.f.d(lottieAnimationView)) {
                            z = true;
                        }
                    }
                    net.one97.paytm.upi.f.a(view, z);
                    textView2.setOnClickListener(new a.C0949a(anVar, aVar, bankAccount));
                    TextView textView3 = anVar.f53691a;
                    net.one97.paytm.upi.f.a((View) textView3, aVar.f53145b.f53141d.containsKey(bankAccount.getAccRefId()));
                    textView3.setText(aVar.f53145b.f53141d.get(bankAccount.getAccRefId()));
                    TextView textView4 = anVar.f53698h;
                    net.one97.paytm.upi.f.a((View) textView4, !bankAccount.isMpinSet());
                    textView4.setOnClickListener(new a.b(aVar, bankAccount));
                    anVar.f53696f.setOnClickListener(new a.C0950c(aVar, bankAccount));
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount");
        } else if (vVar instanceof b) {
            b bVar = (b) vVar;
            Object obj3 = this.f53142e.get(i2);
            if (obj3 != null) {
                ContactsResponse contactsResponse = (ContactsResponse) obj3;
                k.c(contactsResponse, "beneficiary");
                ao aoVar = bVar.f53153a;
                ContactInfo contactInfo = contactsResponse.getContactInfo();
                Meta meta = contactInfo != null ? contactInfo.getMeta() : null;
                if (!(meta instanceof Map)) {
                    meta = null;
                }
                Map map2 = (Map) meta;
                if (!(map2 == null || (str = (String) map2.get(H5ResourceHandlerUtil.IMAGE)) == null)) {
                    str2 = str;
                }
                HashSet<PaymentInstrument> paymentInstruments = contactsResponse.getPaymentInstruments();
                Collection collection = paymentInstruments;
                if (!(collection == null || collection.isEmpty())) {
                    if (paymentInstruments == null) {
                        try {
                            k.a();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    PaymentInstrument next = paymentInstruments.iterator().next();
                    k.a((Object) next, "paymentInstrument!!.iterator().next()");
                    PaymentInstrument paymentInstrument = next;
                    l a4 = new com.google.gson.f().a(paymentInstrument.getMeta());
                    k.a((Object) a4, "Gson().toJsonTree(instrument.meta)");
                    o h2 = a4.h();
                    if (paymentInstrument.getMeta() != null) {
                        Object a5 = new com.google.gson.f().a((l) h2, InstrumentMeta.class);
                        k.a(a5, "Gson().fromJson(\n       …                        )");
                        InstrumentMeta instrumentMeta = (InstrumentMeta) a5;
                        if (instrumentMeta.getName() != null) {
                            TextView textView5 = aoVar.f53704e;
                            k.a((Object) textView5, "beneficiaryName");
                            textView5.setText(net.one97.paytm.upi.f.a(instrumentMeta.getName()));
                        } else {
                            TextView textView6 = aoVar.f53704e;
                            k.a((Object) textView6, "beneficiaryName");
                            textView6.setText(net.one97.paytm.upi.f.a(contactsResponse.getName()));
                        }
                        if (p.a(paymentInstrument.getType(), "UPI", true)) {
                            TextView textView7 = aoVar.f53701b;
                            k.a((Object) textView7, "beneficiaryAccountDetails");
                            ConstraintLayout constraintLayout = aoVar.f53705f;
                            k.a((Object) constraintLayout, "root");
                            textView7.setText(constraintLayout.getContext().getString(R.string.money_transfer_upi_id_placeholder, new Object[]{instrumentMeta.getVpa()}));
                            TextView textView8 = aoVar.f53704e;
                            k.a((Object) textView8, "beneficiaryName");
                            String obj4 = textView8.getText().toString();
                            CircularImageView circularImageView = aoVar.f53702c;
                            k.a((Object) circularImageView, "beneficiaryIcon");
                            TextView textView9 = aoVar.f53703d;
                            k.a((Object) textView9, "beneficiaryInitials");
                            bVar.a(str2, obj4, circularImageView, textView9);
                            aoVar.f53700a.setImageResource(R.drawable.ic_bhim);
                        } else {
                            TextView textView10 = aoVar.f53701b;
                            k.a((Object) textView10, "beneficiaryAccountDetails");
                            ConstraintLayout constraintLayout2 = aoVar.f53705f;
                            k.a((Object) constraintLayout2, "root");
                            textView10.setText(UpiAppUtils.getAccountNoV4Format(constraintLayout2.getContext(), instrumentMeta.getBankName(), instrumentMeta.getAccountNo()));
                            TextView textView11 = aoVar.f53704e;
                            k.a((Object) textView11, "beneficiaryName");
                            String obj5 = textView11.getText().toString();
                            CircularImageView circularImageView2 = aoVar.f53702c;
                            k.a((Object) circularImageView2, "beneficiaryIcon");
                            TextView textView12 = aoVar.f53703d;
                            k.a((Object) textView12, "beneficiaryInitials");
                            bVar.a(str2, obj5, circularImageView2, textView12);
                            String ifsc = instrumentMeta.getIfsc();
                            if (ifsc != null) {
                                ImageView imageView2 = aoVar.f53700a;
                                ConstraintLayout constraintLayout3 = bVar.f53153a.f53705f;
                                k.a((Object) constraintLayout3, "binding.root");
                                m.a(imageView2, ifsc, constraintLayout3.getContext());
                            }
                        }
                        aoVar.f53705f.setOnClickListener(new b.a(instrumentMeta, bVar, contactsResponse));
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactsResponse");
        }
    }

    public final int getItemCount() {
        return this.f53142e.size();
    }

    public final void a(boolean z) {
        this.f53138a = z;
        int i2 = this.f53139b;
        notifyItemChanged(i2, Integer.valueOf(i2));
    }

    public static final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ap f53158a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ap apVar) {
            super(apVar.a());
            k.c(apVar, "binding");
            this.f53158a = apVar;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final an f53144a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f53145b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, an anVar) {
            super(anVar.a());
            k.c(anVar, "binding");
            this.f53145b = cVar;
            this.f53144a = anVar;
        }

        /* renamed from: net.one97.paytm.m.c$a$a  reason: collision with other inner class name */
        static final class C0949a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ an f53146a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f53147b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f53148c;

            C0949a(an anVar, a aVar, BankAccountDetails.BankAccount bankAccount) {
                this.f53146a = anVar;
                this.f53147b = aVar;
                this.f53148c = bankAccount;
            }

            public final void onClick(View view) {
                if (!this.f53147b.f53145b.f53138a) {
                    this.f53147b.f53145b.f53139b = this.f53147b.getAdapterPosition();
                    this.f53147b.f53145b.f53143f.a(this.f53148c);
                }
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f53149a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f53150b;

            b(a aVar, BankAccountDetails.BankAccount bankAccount) {
                this.f53149a = aVar;
                this.f53150b = bankAccount;
            }

            public final void onClick(View view) {
                this.f53149a.f53145b.f53143f.a(this.f53150b, false);
            }
        }

        /* renamed from: net.one97.paytm.m.c$a$c  reason: collision with other inner class name */
        static final class C0950c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f53151a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f53152b;

            C0950c(a aVar, BankAccountDetails.BankAccount bankAccount) {
                this.f53151a = aVar;
                this.f53152b = bankAccount;
            }

            public final void onClick(View view) {
                this.f53151a.f53145b.f53143f.b(this.f53152b);
            }
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ao f53153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f53154b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, ao aoVar) {
            super(aoVar.f53705f);
            k.c(aoVar, "binding");
            this.f53154b = cVar;
            this.f53153a = aoVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InstrumentMeta f53155a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f53156b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ContactsResponse f53157c;

            a(InstrumentMeta instrumentMeta, b bVar, ContactsResponse contactsResponse) {
                this.f53155a = instrumentMeta;
                this.f53156b = bVar;
                this.f53157c = contactsResponse;
            }

            public final void onClick(View view) {
                CharSequence mobileNo = this.f53155a.getMobileNo();
                if (mobileNo == null || mobileNo.length() == 0) {
                    this.f53156b.f53154b.f53143f.b(this.f53157c, (String) null);
                } else {
                    this.f53156b.f53154b.f53143f.b(this.f53157c, this.f53155a.getMobileNo());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, String str2, CircularImageView circularImageView, TextView textView) {
            if (str.length() == 0) {
                circularImageView.setImageResource(m.f54177a[getAdapterPosition() % 10]);
                textView.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(str2)));
                return;
            }
            w.a().a(str).a(R.drawable.profile_logout).a((ImageView) circularImageView);
        }
    }

    /* renamed from: net.one97.paytm.m.c$c  reason: collision with other inner class name */
    public static final class C0951c extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0951c(h hVar) {
            super(hVar.a());
            k.c(hVar, "binding");
        }
    }

    public final class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f53159a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c cVar, ab abVar) {
            super(abVar.a());
            k.c(abVar, "binding");
            this.f53159a = cVar;
            ConstraintLayout a2 = abVar.a();
            k.a((Object) a2, "binding.root");
            View view = a2;
            ConstraintLayout a3 = abVar.a();
            k.a((Object) a3, "binding.root");
            Integer valueOf = Integer.valueOf(a3.getResources().getDimensionPixelOffset(R.dimen.dimen_16dp));
            k.c(view, "$this$setMargins");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, valueOf != null ? valueOf.intValue() : marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.rightMargin);
                view.setLayoutParams(marginLayoutParams);
            }
            abVar.a().setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ f f53160a;

                {
                    this.f53160a = r1;
                }

                public final void onClick(View view) {
                    this.f53160a.f53159a.f53143f.i();
                }
            });
        }
    }
}
