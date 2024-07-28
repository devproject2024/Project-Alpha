package net.one97.paytm.addmoney.landing.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.landing.a.a;
import net.one97.paytm.addmoney.landing.view.a;

public final class a extends RecyclerView.a<C0852a> {

    /* renamed from: a  reason: collision with root package name */
    Context f48613a;

    /* renamed from: b  reason: collision with root package name */
    a.b f48614b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f48614b.a(i2, (C0852a) vVar);
    }

    public a(Context context, a.b bVar) {
        this.f48613a = context;
        this.f48614b = bVar;
    }

    public final int getItemCount() {
        return this.f48614b.e();
    }

    /* renamed from: net.one97.paytm.addmoney.landing.view.a$a  reason: collision with other inner class name */
    public class C0852a extends RecyclerView.v {

        /* renamed from: b  reason: collision with root package name */
        private ImageView f48616b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f48617c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f48618d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f48619e;

        public C0852a(View view) {
            super(view);
            this.f48616b = (ImageView) view.findViewById(R.id.icon);
            this.f48617c = (TextView) view.findViewById(R.id.title);
            this.f48618d = (TextView) view.findViewById(R.id.description);
            this.f48619e = (TextView) view.findViewById(R.id.subTitle);
        }

        public final void a(int i2, String str, String str2, String str3, String str4) {
            this.f48617c.setText(str);
            this.f48618d.setText((CharSequence) null);
            this.f48618d.setVisibility(8);
            this.f48619e.setText(a.this.f48613a.getString(R.string.uam_ppb_account_number, new Object[]{str2}));
            this.f48619e.setVisibility(0);
            Drawable a2 = b.a(a.this.f48613a, R.drawable.ic_paytm_payments_bank);
            if (!TextUtils.isEmpty(str3)) {
                if (str3.toUpperCase().startsWith("ICIC")) {
                    a2 = b.a(a.this.f48613a, R.drawable.icici);
                } else if (str3.toUpperCase().startsWith("KOT")) {
                    a2 = b.a(a.this.f48613a, R.drawable.kotak);
                } else if (str3.toUpperCase().startsWith("UTI")) {
                    a2 = b.a(a.this.f48613a, R.drawable.axis);
                } else if (str3.toUpperCase().startsWith("HDF")) {
                    a2 = b.a(a.this.f48613a, R.drawable.hdfc);
                } else if (str3.toUpperCase().startsWith("SBI")) {
                    a2 = b.a(a.this.f48613a, R.drawable.sbi);
                } else if (str3.toUpperCase().startsWith("PNB")) {
                    a2 = b.a(a.this.f48613a, R.drawable.pnb);
                } else if (str3.toUpperCase().startsWith("UPI")) {
                    a2 = b.a(a.this.f48613a, R.drawable.ic_bhim);
                } else if (str3.toUpperCase().startsWith("PYT")) {
                    a2 = b.a(a.this.f48613a, R.drawable.paytm_logo_money_transfer);
                } else {
                    w.a().a(str4).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.f48616b, (e) null);
                    this.itemView.setOnClickListener(new View.OnClickListener(i2) {
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            a.C0852a.this.a(this.f$1, view);
                        }
                    });
                }
            }
            this.f48616b.setImageDrawable(a2);
            this.itemView.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    a.C0852a.this.a(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, View view) {
            a.this.f48614b.a(i2);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0852a(LayoutInflater.from(this.f48613a).inflate(R.layout.uam_card_view_wrapper, viewGroup, false));
    }
}
