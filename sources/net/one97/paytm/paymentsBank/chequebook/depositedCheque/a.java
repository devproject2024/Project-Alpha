package net.one97.paytm.paymentsBank.chequebook.depositedCheque;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.landing.view.a;
import net.one97.paytm.paymentsBank.chequebook.model.CBHeading;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.model.SectionDivider;
import net.one97.paytm.paymentsBank.chequebook.utils.e;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17496a;

    /* renamed from: b  reason: collision with root package name */
    public List<IJRDataModel> f17497b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final int f17498c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17499d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f17500e = 3;

    /* renamed from: f  reason: collision with root package name */
    private final int f17501f = 4;

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f17501f) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_leaves_heading_view_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…view_item, parent, false)");
            return new b(inflate);
        } else if (i2 == this.f17499d) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_deposited_cleared_chq_item, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…_chq_item, parent, false)");
            return new C0267a(inflate2);
        } else if (i2 == this.f17500e) {
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
        return this.f17497b.size();
    }

    public final int getItemViewType(int i2) {
        IJRDataModel iJRDataModel = this.f17497b.get(i2);
        if (iJRDataModel instanceof ChequeDetailsForInwardOutward) {
            return this.f17499d;
        }
        if (iJRDataModel instanceof CBHeading) {
            return this.f17501f;
        }
        if (iJRDataModel instanceof SectionDivider) {
            return this.f17500e;
        }
        return this.f17498c;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        k.c(vVar, "holder");
        if (vVar instanceof c) {
            IJRDataModel iJRDataModel = this.f17497b.get(i2);
            if (iJRDataModel instanceof SectionDivider) {
                SectionDivider sectionDivider = (SectionDivider) iJRDataModel;
                k.c(sectionDivider, "item");
                TextView textView = ((c) vVar).f17512a;
                k.a((Object) textView, "title");
                textView.setText(sectionDivider.getTitle());
            }
        } else if (vVar instanceof b) {
            IJRDataModel iJRDataModel2 = this.f17497b.get(i2);
            if (iJRDataModel2 instanceof CBHeading) {
                b bVar = (b) vVar;
                k.c((CBHeading) iJRDataModel2, "item");
                TextView textView2 = bVar.f17511a;
                k.a((Object) textView2, "heading");
                View view = bVar.itemView;
                k.a((Object) view, "itemView");
                textView2.setText(view.getContext().getString(R.string.cb_deposited_chq));
            }
        } else if (vVar instanceof C0267a) {
            IJRDataModel iJRDataModel3 = this.f17497b.get(i2);
            if (iJRDataModel3 instanceof ChequeDetailsForInwardOutward) {
                C0267a aVar = (C0267a) vVar;
                ChequeDetailsForInwardOutward chequeDetailsForInwardOutward = (ChequeDetailsForInwardOutward) iJRDataModel3;
                k.c(chequeDetailsForInwardOutward, "chqDetails");
                TextView textView3 = (TextView) aVar.f17503b.getValue();
                k.a((Object) textView3, "toAcntTv");
                Context d2 = aVar.d();
                int i3 = R.string.cb_from_acnt_text;
                Object[] objArr = new Object[1];
                String payerName = chequeDetailsForInwardOutward.getPayerName();
                if (payerName == null) {
                    payerName = "";
                }
                objArr[0] = payerName;
                textView3.setText(d2.getString(i3, objArr));
                TextView textView4 = (TextView) aVar.f17504c.getValue();
                k.a((Object) textView4, "amountTv");
                textView4.setText(aVar.d().getString(R.string.wallet_rs, new Object[]{chequeDetailsForInwardOutward.getAmount()}));
                TextView textView5 = (TextView) aVar.f17505d.getValue();
                k.a((Object) textView5, "bankNameNumTv");
                String draweeBnkName = chequeDetailsForInwardOutward.getDraweeBnkName();
                if (draweeBnkName != null) {
                    charSequence = draweeBnkName;
                } else {
                    charSequence = "";
                }
                textView5.setText(charSequence);
                TextView textView6 = (TextView) aVar.f17506e.getValue();
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
                    TextView a2 = aVar.a();
                    k.a((Object) a2, "clearedDateTv");
                    a2.setText(h2);
                } else {
                    TextView a3 = aVar.a();
                    k.a((Object) a3, "clearedDateTv");
                    a3.setText(chequeDetailsForInwardOutward.getLatestTimeStamp());
                }
                String status = chequeDetailsForInwardOutward.getStatus();
                if (status != null) {
                    e eVar = e.f17951a;
                    if (status.equals(e.Q())) {
                        TextView b2 = aVar.b();
                        k.a((Object) b2, "clearedDepositedOnTv");
                        View view2 = aVar.itemView;
                        k.a((Object) view2, "itemView");
                        b2.setText(view2.getContext().getString(R.string.cb_deposited_on));
                        TextView c2 = aVar.c();
                        k.a((Object) c2, "depositedStatusTv");
                        c2.setVisibility(0);
                        TextView c3 = aVar.c();
                        k.a((Object) c3, "depositedStatusTv");
                        View view3 = aVar.itemView;
                        k.a((Object) view3, "itemView");
                        c3.setText(view3.getContext().getString(R.string.cb_in_clearing_hyphen));
                        return;
                    }
                }
                TextView b3 = aVar.b();
                k.a((Object) b3, "clearedDepositedOnTv");
                View view4 = aVar.itemView;
                k.a((Object) view4, "itemView");
                b3.setText(view4.getContext().getString(R.string.cb_cleared_on));
                TextView c4 = aVar.c();
                k.a((Object) c4, "depositedStatusTv");
                c4.setVisibility(8);
            }
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17512a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17512a = (TextView) view.findViewById(R.id.tvRateMsg);
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a  reason: collision with other inner class name */
    public static final class C0267a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ i[] f17502a;

        /* renamed from: b  reason: collision with root package name */
        final kotlin.g f17503b;

        /* renamed from: c  reason: collision with root package name */
        final kotlin.g f17504c;

        /* renamed from: d  reason: collision with root package name */
        final kotlin.g f17505d;

        /* renamed from: e  reason: collision with root package name */
        final kotlin.g f17506e;

        /* renamed from: f  reason: collision with root package name */
        private final kotlin.g f17507f;

        /* renamed from: g  reason: collision with root package name */
        private final kotlin.g f17508g;

        /* renamed from: h  reason: collision with root package name */
        private final kotlin.g f17509h;

        /* renamed from: i  reason: collision with root package name */
        private final kotlin.g f17510i;

        static {
            Class<C0267a> cls = C0267a.class;
            f17502a = new i[]{y.a((v) new w(y.b(cls), "toAcntTv", "getToAcntTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "amountTv", "getAmountTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "bankNameNumTv", "getBankNameNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "serialNumTv", "getSerialNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "clearedDateTv", "getClearedDateTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "clearedDepositedOnTv", "getClearedDepositedOnTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "depositedStatusTv", "getDepositedStatusTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "context", "getContext()Landroid/content/Context;"))};
        }

        public final TextView a() {
            return (TextView) this.f17507f.getValue();
        }

        public final TextView b() {
            return (TextView) this.f17508g.getValue();
        }

        public final TextView c() {
            return (TextView) this.f17509h.getValue();
        }

        public final Context d() {
            return (Context) this.f17510i.getValue();
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$h */
        static final class h extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_to_name_tv);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0267a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17503b = kotlin.h.a(new h(view));
            this.f17504c = kotlin.h.a(new C0268a(view));
            this.f17505d = kotlin.h.a(new b(view));
            this.f17506e = kotlin.h.a(new g(view));
            this.f17507f = kotlin.h.a(new c(view));
            this.f17508g = kotlin.h.a(new d(view));
            this.f17509h = kotlin.h.a(new f(view));
            this.f17510i = kotlin.h.a(new e(view));
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$a  reason: collision with other inner class name */
        static final class C0268a extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0268a(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_amount_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$b */
        static final class b extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_bank_name_acnt_num_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$g */
        static final class g extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_serial_num_value_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$c */
        static final class c extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_date_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$d */
        static final class d extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_on_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$f */
        static final class f extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_deposited_status_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.a$a$e */
        static final class e extends l implements kotlin.g.a.a<Context> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(View view) {
                super(0);
                this.$itemView = view;
            }

            public final Context invoke() {
                return this.$itemView.getContext();
            }
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17511a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17511a = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
