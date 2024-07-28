package net.one97.paytm.moneytransferv4.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.z;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends RecyclerView.a<C0983a> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends BeneficiaryEntity> f54833a = this.f54837e;

    /* renamed from: b  reason: collision with root package name */
    String f54834b = "";

    /* renamed from: c  reason: collision with root package name */
    String f54835c = "";

    /* renamed from: d  reason: collision with root package name */
    final b f54836d;

    /* renamed from: e  reason: collision with root package name */
    final List<BeneficiaryEntity> f54837e;

    public interface b {
        void a(BeneficiaryEntity beneficiaryEntity);
    }

    public a(b bVar, List<BeneficiaryEntity> list) {
        k.c(bVar, "onBeneficiaryClickListener");
        k.c(list, "list");
        this.f54836d = bVar;
        this.f54837e = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0983a aVar = (C0983a) vVar;
        k.c(aVar, "holder");
        BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) this.f54833a.get(i2);
        k.c(beneficiaryEntity, "beneficiary");
        z zVar = aVar.f54838a;
        boolean z = false;
        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
            BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity.instrumentPreferences.otherBank;
            String str = otherBank.accounts.get(0).accountDetail.logoUrl;
            k.a((Object) otherBank.accounts.get(0).uuid, (Object) "0");
            String a2 = f.a(otherBank.accounts.get(0).accountDetail.accountHolderName);
            String str2 = otherBank.accounts.get(0).accountDetail.ifscCode;
            TextView textView = zVar.f53891g;
            k.a((Object) textView, "beneficiaryName");
            textView.setText(a2);
            ImageView imageView = zVar.f53885a;
            k.a((Object) imageView, "bankImage");
            k.a((Object) str2, "ifsc");
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                z = true;
            }
            if (z) {
                m.a(imageView, str2, imageView.getContext());
            } else {
                w.a().a(str).a(R.drawable.mt_dummy_beneficiary_icon).b(R.drawable.ic_default_bank).a(imageView);
            }
        } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
            BeneficiaryEntity.UPI upi = beneficiaryEntity.instrumentPreferences.upi;
            TextView textView2 = zVar.f53891g;
            k.a((Object) textView2, "beneficiaryName");
            textView2.setText(f.a(upi.accounts.get(0).accountDetail.accountHolderName));
            zVar.f53887c.setBackgroundColor(m.c()[aVar.getAdapterPosition() % 10]);
            TextView textView3 = zVar.f53888d;
            k.a((Object) textView3, "beneficiaryInitials");
            TextView textView4 = zVar.f53891g;
            k.a((Object) textView4, "beneficiaryName");
            textView3.setText(UpiUtils.getNameInitials(f.a(textView4.getText().toString())));
        }
        zVar.f53890f.setOnClickListener(new C0983a.C0984a(aVar, beneficiaryEntity));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        z a2 = z.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_beneficiary_grid_item, viewGroup, false));
        k.a((Object) a2, "MtV4BeneficiaryGridItemBinding.bind(view)");
        return new C0983a(this, a2);
    }

    public final int getItemCount() {
        return this.f54833a.size();
    }

    public final void a(List<? extends BeneficiaryEntity> list) {
        k.c(list, "newList");
        int size = this.f54837e.size();
        this.f54837e.addAll(list);
        this.f54833a = this.f54837e;
        notifyItemRangeChanged(size, this.f54833a.size());
    }

    public static final class c extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54842a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f54843b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f54844c;

        c(a aVar, List list, List list2) {
            this.f54842a = aVar;
            this.f54843b = list;
            this.f54844c = list2;
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            return k.a((Object) this.f54842a.f54834b, (Object) this.f54842a.f54835c);
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return k.a((Object) ((BeneficiaryEntity) this.f54843b.get(i2)).beneficiaryId, (Object) ((BeneficiaryEntity) this.f54844c.get(i3)).beneficiaryId);
        }

        public final int getNewListSize() {
            return this.f54844c.size();
        }

        public final int getOldListSize() {
            return this.f54843b.size();
        }

        public final Object getChangePayload(int i2, int i3) {
            return this.f54842a.f54835c;
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.a.c.a$a  reason: collision with other inner class name */
    public final class C0983a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final z f54838a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f54839b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0983a(a aVar, z zVar) {
            super(zVar.a());
            k.c(zVar, "itemViewBinding");
            this.f54839b = aVar;
            this.f54838a = zVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.a.c.a$a$a  reason: collision with other inner class name */
        static final class C0984a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0983a f54840a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BeneficiaryEntity f54841b;

            C0984a(C0983a aVar, BeneficiaryEntity beneficiaryEntity) {
                this.f54840a = aVar;
                this.f54841b = beneficiaryEntity;
            }

            public final void onClick(View view) {
                this.f54840a.f54839b.f54836d.a(this.f54841b);
            }
        }
    }
}
