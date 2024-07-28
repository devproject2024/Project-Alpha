package net.one97.paytm.paymentsBank.chequebook.returnedCheque;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.landing.view.a;
import net.one97.paytm.paymentsBank.chequebook.model.CBHeading;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.model.SectionDivider;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17721a;

    /* renamed from: b  reason: collision with root package name */
    public List<IJRDataModel> f17722b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final int f17723c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17724d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f17725e = 3;

    /* renamed from: f  reason: collision with root package name */
    private final int f17726f = 4;

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f17726f) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_leaves_heading_view_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…view_item, parent, false)");
            return new C0281a(inflate);
        } else if (i2 == this.f17724d) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_returned_chq_item, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…_chq_item, parent, false)");
            return new b(inflate2);
        } else if (i2 == this.f17725e) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_section_divider, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…n_divider, parent, false)");
            return new c(inflate3);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_list_loading_footer_item, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(pare…oter_item, parent, false)");
            return new a.b(inflate4);
        }
    }

    public final int getItemCount() {
        return this.f17722b.size();
    }

    public final int getItemViewType(int i2) {
        IJRDataModel iJRDataModel = this.f17722b.get(i2);
        if (iJRDataModel instanceof ChequeDetailsForInwardOutward) {
            return this.f17724d;
        }
        if (iJRDataModel instanceof CBHeading) {
            return this.f17726f;
        }
        if (iJRDataModel instanceof SectionDivider) {
            return this.f17725e;
        }
        return this.f17723c;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        k.c(vVar, "holder");
        if (vVar instanceof c) {
            IJRDataModel iJRDataModel = this.f17722b.get(i2);
            if (iJRDataModel instanceof SectionDivider) {
                SectionDivider sectionDivider = (SectionDivider) iJRDataModel;
                k.c(sectionDivider, "item");
                TextView textView = ((c) vVar).f17735a;
                k.a((Object) textView, "title");
                textView.setText(sectionDivider.getTitle());
            }
        } else if (vVar instanceof C0281a) {
            IJRDataModel iJRDataModel2 = this.f17722b.get(i2);
            if (iJRDataModel2 instanceof CBHeading) {
                C0281a aVar = (C0281a) vVar;
                k.c((CBHeading) iJRDataModel2, "item");
                TextView textView2 = aVar.f17727a;
                k.a((Object) textView2, "heading");
                View view = aVar.itemView;
                k.a((Object) view, "itemView");
                textView2.setText(view.getContext().getString(R.string.cb_returned_chq));
            }
        } else if (vVar instanceof b) {
            IJRDataModel iJRDataModel3 = this.f17722b.get(i2);
            if (iJRDataModel3 instanceof ChequeDetailsForInwardOutward) {
                b bVar = (b) vVar;
                ChequeDetailsForInwardOutward chequeDetailsForInwardOutward = (ChequeDetailsForInwardOutward) iJRDataModel3;
                k.c(chequeDetailsForInwardOutward, "chqDetails");
                TextView textView3 = (TextView) bVar.f17729b.getValue();
                k.a((Object) textView3, "toAcntTv");
                Context a2 = bVar.a();
                int i3 = R.string.cb_from_acnt_text;
                Object[] objArr = new Object[1];
                String payerName = chequeDetailsForInwardOutward.getPayerName();
                if (payerName == null) {
                    payerName = "";
                }
                objArr[0] = payerName;
                textView3.setText(a2.getString(i3, objArr));
                TextView textView4 = (TextView) bVar.f17730c.getValue();
                k.a((Object) textView4, "amountTv");
                textView4.setText(bVar.a().getString(R.string.wallet_rs, new Object[]{chequeDetailsForInwardOutward.getAmount()}));
                TextView textView5 = (TextView) bVar.f17731d.getValue();
                k.a((Object) textView5, "bankNameNumTv");
                String draweeBnkName = chequeDetailsForInwardOutward.getDraweeBnkName();
                if (draweeBnkName != null) {
                    charSequence = draweeBnkName;
                } else {
                    charSequence = "";
                }
                textView5.setText(charSequence);
                TextView textView6 = (TextView) bVar.f17732e.getValue();
                k.a((Object) textView6, "serialNumTv");
                String chqNumber = chequeDetailsForInwardOutward.getChqNumber();
                if (chqNumber != null) {
                    charSequence2 = chqNumber;
                } else {
                    charSequence2 = "";
                }
                textView6.setText(charSequence2);
                CharSequence h2 = com.paytm.utility.b.h(chequeDetailsForInwardOutward.getLatestTimeStamp(), "yyyy-MM-dd'T'hh:mm:ss", "dd MMMM''yy");
                if (!TextUtils.isEmpty(h2)) {
                    TextView textView7 = (TextView) bVar.f17733f.getValue();
                    k.a((Object) textView7, "returnedDateTv");
                    textView7.setText(h2);
                }
            }
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17735a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17735a = (TextView) view.findViewById(R.id.tvRateMsg);
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ i[] f17728a;

        /* renamed from: b  reason: collision with root package name */
        final g f17729b;

        /* renamed from: c  reason: collision with root package name */
        final g f17730c;

        /* renamed from: d  reason: collision with root package name */
        final g f17731d;

        /* renamed from: e  reason: collision with root package name */
        final g f17732e;

        /* renamed from: f  reason: collision with root package name */
        final g f17733f;

        /* renamed from: g  reason: collision with root package name */
        private final g f17734g;

        static {
            Class<b> cls = b.class;
            f17728a = new i[]{y.a((v) new w(y.b(cls), "toAcntTv", "getToAcntTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "amountTv", "getAmountTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "bankNameNumTv", "getBankNameNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "serialNumTv", "getSerialNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "returnedDateTv", "getReturnedDateTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "context", "getContext()Landroid/content/Context;"))};
        }

        public final Context a() {
            return (Context) this.f17734g.getValue();
        }

        static final class f extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_to_name_tv);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17729b = h.a(new f(view));
            this.f17730c = h.a(new C0282a(view));
            this.f17731d = h.a(new C0283b(view));
            this.f17732e = h.a(new e(view));
            this.f17733f = h.a(new d(view));
            this.f17734g = h.a(new c(view));
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.returnedCheque.a$b$a  reason: collision with other inner class name */
        static final class C0282a extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0282a(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_amount_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.returnedCheque.a$b$b  reason: collision with other inner class name */
        static final class C0283b extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0283b(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_bank_name_acnt_num_tv);
            }
        }

        static final class e extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_serial_num_value_tv);
            }
        }

        static final class d extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_returned_date_tv);
            }
        }

        static final class c extends l implements kotlin.g.a.a<Context> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(View view) {
                super(0);
                this.$itemView = view;
            }

            public final Context invoke() {
                return this.$itemView.getContext();
            }
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.returnedCheque.a$a  reason: collision with other inner class name */
    public static final class C0281a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17727a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0281a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17727a = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
