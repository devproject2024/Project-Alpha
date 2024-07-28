package net.one97.paytm.moneytransferv4.b.a.a.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.gson.f;
import com.google.gson.internal.g;
import com.google.gson.l;
import com.google.gson.o;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.common.entity.MTBeneficiaryViewAll;
import net.one97.paytm.contacts.entities.beans.ContactInfo;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.contacts.entities.beans.Meta;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.aa;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.q;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends ContactsResponse> f55198a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    final q f55199b = new q();

    /* renamed from: c  reason: collision with root package name */
    final net.one97.paytm.moneytransferv4.b.a.a.d f55200c;

    /* renamed from: d  reason: collision with root package name */
    private final int f55201d = 4;

    public b(net.one97.paytm.moneytransferv4.b.a.a.d dVar) {
        this.f55200c = dVar;
        this.f55199b.a();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_beneficiary_list_item, viewGroup, false);
            k.a((Object) inflate, "view");
            return new a(this, inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_beneficiary_view_all, viewGroup, false);
        k.a((Object) inflate2, "view");
        RecyclerView.v bVar = new C1005b(this, inflate2);
        bVar.itemView.setOnClickListener(new d(this));
        return bVar;
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55215a;

        d(b bVar) {
            this.f55215a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55215a.f55200c;
            if (dVar != null) {
                dVar.d();
            }
        }
    }

    public static final class c extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f55213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f55214b;

        c(List list, List list2) {
            this.f55213a = list;
            this.f55214b = list2;
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return k.a((Object) ((ContactsResponse) this.f55213a.get(i2)).getContactId(), (Object) ((ContactsResponse) this.f55214b.get(i3)).getContactId());
        }

        public final int getOldListSize() {
            return this.f55213a.size();
        }

        public final int getNewListSize() {
            return this.f55214b.size();
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            return k.a((Object) ((ContactsResponse) this.f55213a.get(i2)).getContactId(), (Object) ((ContactsResponse) this.f55214b.get(i3)).getContactId());
        }

        public final Object getChangePayload(int i2, int i3) {
            return Integer.valueOf(i2);
        }
    }

    public final int getItemCount() {
        int size = this.f55198a.size();
        int i2 = this.f55201d;
        return size < i2 ? this.f55198a.size() : i2;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        k.c(vVar, "holder");
        ContactsResponse contactsResponse = (ContactsResponse) this.f55198a.get(i2);
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            k.c(contactsResponse, "beneficiary");
            aa aaVar = aVar.f55202a;
            aVar.f55203b.f55199b.a(aVar.f55202a.j, contactsResponse.getContactId());
            try {
                ContactInfo contactInfo = contactsResponse.getContactInfo();
                k.a((Object) contactInfo, "beneficiary.contactInfo");
                Meta meta = contactInfo.getMeta();
                if (meta != null) {
                    Object obj = ((g) meta).get(H5ResourceHandlerUtil.IMAGE);
                    if (obj == null) {
                        k.a();
                    }
                    str = (String) obj;
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
                        l a2 = new f().a(paymentInstrument.getMeta());
                        k.a((Object) a2, "Gson().toJsonTree(instrument.meta)");
                        o h2 = a2.h();
                        if (paymentInstrument.getMeta() != null) {
                            Object a3 = new f().a((l) h2, InstrumentMeta.class);
                            k.a(a3, "Gson().fromJson(\n       …                        )");
                            InstrumentMeta instrumentMeta = (InstrumentMeta) a3;
                            if (instrumentMeta.getName() != null) {
                                TextView textView = aaVar.f53603e;
                                k.a((Object) textView, "beneficiaryName");
                                textView.setText(net.one97.paytm.upi.f.a(instrumentMeta.getName()));
                            } else {
                                TextView textView2 = aaVar.f53603e;
                                k.a((Object) textView2, "beneficiaryName");
                                textView2.setText(net.one97.paytm.upi.f.a(contactsResponse.getName()));
                            }
                            if (p.a(paymentInstrument.getType(), "UPI", true)) {
                                TextView textView3 = aaVar.f53600b;
                                k.a((Object) textView3, "beneficiaryAccountDetails");
                                ConstraintLayout constraintLayout = aaVar.f53607i;
                                k.a((Object) constraintLayout, "root");
                                textView3.setText(constraintLayout.getContext().getString(R.string.money_transfer_upi_id_placeholder, new Object[]{instrumentMeta.getVpa()}));
                                TextView textView4 = aaVar.f53603e;
                                k.a((Object) textView4, "beneficiaryName");
                                String obj2 = textView4.getText().toString();
                                ImageView imageView = aaVar.f53601c;
                                k.a((Object) imageView, "beneficiaryIcon");
                                TextView textView5 = aaVar.f53602d;
                                k.a((Object) textView5, "beneficiaryInitials");
                                aVar.a(str, obj2, imageView, textView5);
                                aaVar.f53599a.setImageResource(R.drawable.ic_bhim);
                            } else {
                                TextView textView6 = aaVar.f53600b;
                                k.a((Object) textView6, "beneficiaryAccountDetails");
                                ConstraintLayout constraintLayout2 = aaVar.f53607i;
                                k.a((Object) constraintLayout2, "root");
                                textView6.setText(UpiAppUtils.getAccountNoV4Format(constraintLayout2.getContext(), instrumentMeta.getBankName(), instrumentMeta.getAccountNo()));
                                TextView textView7 = aaVar.f53603e;
                                k.a((Object) textView7, "beneficiaryName");
                                String obj3 = textView7.getText().toString();
                                ImageView imageView2 = aaVar.f53601c;
                                k.a((Object) imageView2, "beneficiaryIcon");
                                TextView textView8 = aaVar.f53602d;
                                k.a((Object) textView8, "beneficiaryInitials");
                                aVar.a(str, obj3, imageView2, textView8);
                                String ifsc = instrumentMeta.getIfsc();
                                if (ifsc != null) {
                                    ImageView imageView3 = aaVar.f53599a;
                                    ConstraintLayout constraintLayout3 = aVar.f55202a.f53607i;
                                    k.a((Object) constraintLayout3, "binding.root");
                                    m.a(imageView3, ifsc, constraintLayout3.getContext());
                                }
                            }
                            aaVar.f53607i.setOnClickListener(new a.C1003a(instrumentMeta, aVar, contactsResponse));
                            aaVar.f53606h.setOnClickListener(new a.C1004b(instrumentMeta, aVar, contactsResponse));
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.String>");
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final aa f55202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f55203b;

        /* renamed from: c  reason: collision with root package name */
        private final View f55204c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f55203b = bVar;
            this.f55204c = view;
            aa a2 = aa.a(this.f55204c);
            k.a((Object) a2, "MtV4BeneficiaryListItemBinding.bind(view)");
            this.f55202a = a2;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.c.b$a$a  reason: collision with other inner class name */
        static final class C1003a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InstrumentMeta f55205a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f55206b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ContactsResponse f55207c;

            C1003a(InstrumentMeta instrumentMeta, a aVar, ContactsResponse contactsResponse) {
                this.f55205a = instrumentMeta;
                this.f55206b = aVar;
                this.f55207c = contactsResponse;
            }

            public final void onClick(View view) {
                CharSequence mobileNo = this.f55205a.getMobileNo();
                if (mobileNo == null || mobileNo.length() == 0) {
                    net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55206b.f55203b.f55200c;
                    if (dVar != null) {
                        dVar.a(this.f55207c, (String) null);
                        return;
                    }
                    return;
                }
                net.one97.paytm.moneytransferv4.b.a.a.d dVar2 = this.f55206b.f55203b.f55200c;
                if (dVar2 != null) {
                    dVar2.a(this.f55207c, this.f55205a.getMobileNo());
                }
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.c.b$a$b  reason: collision with other inner class name */
        static final class C1004b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InstrumentMeta f55208a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f55209b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ContactsResponse f55210c;

            C1004b(InstrumentMeta instrumentMeta, a aVar, ContactsResponse contactsResponse) {
                this.f55208a = instrumentMeta;
                this.f55209b = aVar;
                this.f55210c = contactsResponse;
            }

            public final void onClick(View view) {
                this.f55209b.f55203b.f55199b.a(this.f55210c.getContactId());
                net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55209b.f55203b.f55200c;
                if (dVar != null) {
                    dVar.a(this.f55208a);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, String str2, ImageView imageView, TextView textView) {
            if (str.length() == 0) {
                imageView.setBackgroundColor(m.c()[getAdapterPosition() % 10]);
                textView.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(str2)));
                return;
            }
            w.a().a(str).a(R.drawable.profile_logout).a(imageView);
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.c.b$b  reason: collision with other inner class name */
    public final class C1005b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55211a;

        /* renamed from: b  reason: collision with root package name */
        private final View f55212b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1005b(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f55211a = bVar;
            this.f55212b = view;
        }
    }

    public final int getItemViewType(int i2) {
        return this.f55198a.get(i2) instanceof MTBeneficiaryViewAll ? 1 : 0;
    }
}
