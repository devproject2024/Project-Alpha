package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class p extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    int f69006a;

    /* renamed from: b  reason: collision with root package name */
    a f69007b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<BankAccountDetails.BankAccount> f69008c;

    /* renamed from: d  reason: collision with root package name */
    private Context f69009d;

    public interface a {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        if (this.f69008c != null) {
            TextView textView = bVar.f69010a;
            ArrayList<BankAccountDetails.BankAccount> arrayList = this.f69008c;
            if (arrayList == null) {
                k.a();
            }
            BankAccountDetails.BankAccount bankAccount = arrayList.get(i2);
            k.a((Object) bankAccount, "bankList!![position]");
            String bankName = bankAccount.getBankName();
            ArrayList<BankAccountDetails.BankAccount> arrayList2 = this.f69008c;
            if (arrayList2 == null) {
                k.a();
            }
            BankAccountDetails.BankAccount bankAccount2 = arrayList2.get(i2);
            k.a((Object) bankAccount2, "bankList!![position]");
            textView.setText(UpiUtils.getAccountNoFormat(bankName, bankAccount2.getMaskedAccountNumber()));
            ArrayList<BankAccountDetails.BankAccount> arrayList3 = this.f69008c;
            if (arrayList3 == null) {
                k.a();
            }
            BankAccountDetails.BankAccount bankAccount3 = arrayList3.get(i2);
            k.a((Object) bankAccount3, "bankList!![position]");
            String bankLogoUrl = bankAccount3.getBankLogoUrl();
            ImageView imageView = bVar.f69012c;
            ArrayList<BankAccountDetails.BankAccount> arrayList4 = this.f69008c;
            if (arrayList4 == null) {
                k.a();
            }
            BankAccountDetails.BankAccount bankAccount4 = arrayList4.get(i2);
            k.a((Object) bankAccount4, "bankList!![position]");
            String ifsc = bankAccount4.getIfsc();
            k.a((Object) ifsc, "bankList!![position].ifsc");
            if (URLUtil.isValidUrl(bankLogoUrl)) {
                w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
            } else if (!TextUtils.isEmpty(ifsc)) {
                w a2 = w.a();
                Context context = this.f69009d;
                a2.a(UpiRequestBuilder.getBankIconUrl(context != null ? context.getApplicationContext() : null, ifsc)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
            }
            bVar.f69011b.setOnClickListener(new c(this, bVar));
            bVar.f69011b.setOnCheckedChangeListener(new d(this, bVar));
            bVar.f69013d.setOnClickListener(new e(this, bVar));
        }
        if (i2 == a()) {
            bVar.f69011b.setChecked(true);
        } else {
            bVar.f69011b.setChecked(false);
        }
        ArrayList<BankAccountDetails.BankAccount> arrayList5 = this.f69008c;
        if (arrayList5 != null && arrayList5.size() == 1) {
            f.a((View) bVar.f69011b);
            f.a(bVar.f69014e);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_signup_set_mpin, viewGroup, false));
    }

    public p(ArrayList<BankAccountDetails.BankAccount> arrayList, Context context, a aVar) {
        this.f69008c = arrayList;
        this.f69009d = context;
        this.f69007b = aVar;
    }

    public final int a() {
        int i2 = this.f69006a;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public final int getItemCount() {
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f69008c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f69015a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f69016b;

        c(p pVar, b bVar) {
            this.f69015a = pVar;
            this.f69016b = bVar;
        }

        public final void onClick(View view) {
            this.f69015a.f69006a = this.f69016b.getAdapterPosition();
            this.f69015a.notifyDataSetChanged();
        }
    }

    static final class d implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f69017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f69018b;

        d(p pVar, b bVar) {
            this.f69017a = pVar;
            this.f69018b = bVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                a aVar = this.f69017a.f69007b;
                if (aVar != null) {
                    aVar.a(this.f69018b.getAdapterPosition());
                }
                this.f69017a.f69006a = this.f69018b.getAdapterPosition();
                this.f69018b.f69010a.setTypeface(Typeface.create("sans-serif-medium", 0));
                return;
            }
            this.f69018b.f69010a.setTypeface(Typeface.create("sans-serif", 0));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f69019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f69020b;

        e(p pVar, b bVar) {
            this.f69019a = pVar;
            this.f69020b = bVar;
        }

        public final void onClick(View view) {
            this.f69019a.f69006a = this.f69020b.getAdapterPosition();
            this.f69019a.notifyDataSetChanged();
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f69010a;

        /* renamed from: b  reason: collision with root package name */
        final RadioButton f69011b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f69012c;

        /* renamed from: d  reason: collision with root package name */
        final ConstraintLayout f69013d;

        /* renamed from: e  reason: collision with root package name */
        final View f69014e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            View findViewById = view.findViewById(R.id.tv_bank_name);
            k.a((Object) findViewById, "itemView!!.findViewById(R.id.tv_bank_name)");
            this.f69010a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.rb_bank);
            k.a((Object) findViewById2, "itemView!!.findViewById(R.id.rb_bank)");
            this.f69011b = (RadioButton) findViewById2;
            View findViewById3 = view.findViewById(R.id.iv_bank_logo);
            k.a((Object) findViewById3, "itemView!!.findViewById(R.id.iv_bank_logo)");
            this.f69012c = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.root_layout);
            k.a((Object) findViewById4, "itemView!!.findViewById(R.id.root_layout)");
            this.f69013d = (ConstraintLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.v_divider);
            k.a((Object) findViewById5, "itemView!!.findViewById(R.id.v_divider)");
            this.f69014e = findViewById5;
        }
    }
}
