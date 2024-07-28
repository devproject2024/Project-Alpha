package net.one97.paytm.p2b.view.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.d.k;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<BeneficiaryEntity> f12884a;

    /* renamed from: b  reason: collision with root package name */
    final C0172a f12885b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentActivity f12886c;

    /* renamed from: net.one97.paytm.p2b.view.a.a$a  reason: collision with other inner class name */
    public interface C0172a {
        void a(BeneficiaryEntity beneficiaryEntity);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        if (a.this.f12884a.get(i2).instrumentPreferences.otherBank != null) {
            BeneficiaryEntity.OtherBank otherBank = a.this.f12884a.get(i2).instrumentPreferences.otherBank;
            String str = otherBank.accounts.get(0).accountDetail.accountHolderName;
            String str2 = otherBank.accounts.get(0).accountDetail.accountNumber;
            String str3 = otherBank.accounts.get(0).accountDetail.ifscCode;
            String b2 = k.b(str);
            if (!TextUtils.isEmpty(b2)) {
                bVar.f12887a.setText(b2);
            }
            if (!TextUtils.isEmpty(str2)) {
                bVar.f12888b.setText(bVar.f12888b.getContext().getString(R.string.p2b_acc_number_initial, new Object[]{k.a(str2, 4)}));
            }
            ImageView imageView = bVar.f12889c;
            k.a(imageView.getContext(), imageView, str3);
            if (i2 == a.this.f12884a.size() - 1) {
                bVar.f12890d.setVisibility(8);
            } else {
                bVar.f12890d.setVisibility(0);
            }
        }
    }

    public a(FragmentActivity fragmentActivity, ArrayList<BeneficiaryEntity> arrayList, C0172a aVar) {
        this.f12886c = fragmentActivity;
        this.f12884a = arrayList;
        this.f12885b = aVar;
    }

    public final int getItemCount() {
        return this.f12884a.size();
    }

    public class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f12887a;

        /* renamed from: b  reason: collision with root package name */
        TextView f12888b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f12889c;

        /* renamed from: d  reason: collision with root package name */
        View f12890d;

        /* renamed from: f  reason: collision with root package name */
        private final ConstraintLayout f12892f;

        public b(View view) {
            super(view);
            this.f12887a = (TextView) view.findViewById(R.id.beneficiary_bank_name);
            this.f12888b = (TextView) view.findViewById(R.id.beneficiary_account_number);
            this.f12889c = (ImageView) view.findViewById(R.id.beneficiary_circle);
            this.f12892f = (ConstraintLayout) view.findViewById(R.id.beneficiary_item);
            this.f12892f.setOnClickListener(this);
            this.f12890d = view.findViewById(R.id.divider);
        }

        public final void onClick(View view) {
            if (a.this.f12885b != null) {
                a.this.f12885b.a(a.this.f12884a.get(getAdapterPosition()));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p2b_beneficiary_item, viewGroup, false));
    }
}
