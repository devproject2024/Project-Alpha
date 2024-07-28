package net.one97.paytm.paymentsBank.chequebook.leaflist;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.landing.view.a;
import net.one97.paytm.paymentsBank.chequebook.model.CBHeading;
import net.one97.paytm.paymentsBank.chequebook.model.CBStopPaymentView;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.model.SectionDivider;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<IJRDataModel> f17575a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f17576b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17577c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final int f17578d = 2;

    /* renamed from: e  reason: collision with root package name */
    private final int f17579e = 3;

    /* renamed from: f  reason: collision with root package name */
    private final int f17580f = 4;

    /* renamed from: g  reason: collision with root package name */
    private final int f17581g = 5;

    /* renamed from: h  reason: collision with root package name */
    private final e f17582h;

    public interface e {
        void a(int i2, String str, View view, int i3);
    }

    public a(e eVar) {
        k.c(eVar, "clicklistener");
        this.f17582h = eVar;
    }

    public final void a(List<? extends IJRDataModel> list) {
        k.c(list, "itemList");
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.f17575a.clear();
            this.f17575a.addAll(collection);
            notifyItemRangeInserted(0, list.size());
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f17581g) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_stop_pymnt_view_type, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…view_type, parent, false)");
            return new d(inflate);
        } else if (i2 == this.f17580f) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_leaves_heading_view_item, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…view_item, parent, false)");
            return new b(inflate2);
        } else if (i2 == this.f17577c) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_cleared_chq_item, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…_chq_item, parent, false)");
            return new C0273a(inflate3);
        } else if (i2 == this.f17578d) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_other_chq_item, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(pare…_chq_item, parent, false)");
            return new c(inflate4, this.f17582h);
        } else if (i2 == this.f17579e) {
            View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_section_divider, viewGroup, false);
            k.a((Object) inflate5, "LayoutInflater.from(pare…n_divider, parent, false)");
            return new f(inflate5);
        } else {
            View inflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_list_loading_footer_item, viewGroup, false);
            k.a((Object) inflate6, "LayoutInflater.from(pare…oter_item, parent, false)");
            return new a.b(inflate6);
        }
    }

    public final int getItemCount() {
        return this.f17575a.size();
    }

    public final int getItemViewType(int i2) {
        IJRDataModel iJRDataModel = this.f17575a.get(i2);
        if (iJRDataModel instanceof CBStopPaymentView) {
            return this.f17581g;
        }
        if (iJRDataModel instanceof ChequeDetailsForInwardOutward) {
            return this.f17577c;
        }
        if (iJRDataModel instanceof CBHeading) {
            return this.f17580f;
        }
        if (iJRDataModel instanceof ChequeDetail) {
            return this.f17578d;
        }
        if (iJRDataModel instanceof SectionDivider) {
            return this.f17579e;
        }
        return this.f17576b;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        TextView textView;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String status;
        String str;
        k.c(vVar, "holder");
        if (vVar instanceof f) {
            IJRDataModel iJRDataModel = this.f17575a.get(i2);
            if (iJRDataModel instanceof SectionDivider) {
                SectionDivider sectionDivider = (SectionDivider) iJRDataModel;
                k.c(sectionDivider, "item");
                textView = ((f) vVar).f17601a;
                k.a((Object) textView, "title");
                charSequence = sectionDivider.getTitle();
            } else {
                return;
            }
        } else if (vVar instanceof c) {
            IJRDataModel iJRDataModel2 = this.f17575a.get(i2);
            if (iJRDataModel2 instanceof ChequeDetail) {
                c cVar = (c) vVar;
                ChequeDetail chequeDetail = (ChequeDetail) iJRDataModel2;
                k.c(chequeDetail, "otherDetail");
                TextView textView2 = (TextView) cVar.f17593b.getValue();
                k.a((Object) textView2, "serialNumTv");
                textView2.setText(chequeDetail.getChqNumber());
                String status2 = chequeDetail.getStatus();
                net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                if (p.a(status2, net.one97.paytm.paymentsBank.chequebook.utils.e.g(), false)) {
                    cVar.f17594c.setVisibility(0);
                    cVar.f17594c.setBackground(androidx.core.content.b.a(cVar.f17594c.getContext(), R.drawable.pb_cb_stopped_bg));
                    cVar.f17594c.setText(cVar.b().getString(R.string.cb_pymnt_stopd));
                    cVar.f17594c.setTextColor(Color.parseColor("#fd5c5c"));
                    cVar.f17595d.setAlpha(0.7f);
                    AppCompatImageView a2 = cVar.a();
                    k.a((Object) a2, "menuIv");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(a2);
                } else {
                    String status3 = chequeDetail.getStatus();
                    net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                    if (p.a(status3, net.one97.paytm.paymentsBank.chequebook.utils.e.Q(), false)) {
                        cVar.f17594c.setVisibility(0);
                        cVar.f17594c.setText(cVar.b().getString(R.string.cb_in_clearing));
                        cVar.f17595d.setAlpha(0.9f);
                        AppCompatImageView a3 = cVar.a();
                        k.a((Object) a3, "menuIv");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.a(a3);
                    } else {
                        String status4 = chequeDetail.getStatus();
                        net.one97.paytm.paymentsBank.chequebook.utils.e eVar3 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                        if (p.a(status4, net.one97.paytm.paymentsBank.chequebook.utils.e.V(), false)) {
                            net.one97.paytm.paymentsBank.chequebook.utils.b.a(cVar.f17594c);
                            cVar.f17594c.setText(cVar.b().getString(R.string.cb_returned));
                            cVar.f17594c.setTextColor(Color.parseColor("#fd5c5c"));
                            AppCompatImageView a4 = cVar.a();
                            k.a((Object) a4, "menuIv");
                            net.one97.paytm.paymentsBank.chequebook.utils.b.a(a4);
                        } else if (!TextUtils.isEmpty(chequeDetail.getStatus()) && (status = chequeDetail.getStatus()) != null) {
                            net.one97.paytm.paymentsBank.chequebook.utils.e eVar4 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                            if (!p.a(status, net.one97.paytm.paymentsBank.chequebook.utils.e.W(), true)) {
                                net.one97.paytm.paymentsBank.chequebook.utils.b.a(cVar.f17594c);
                                TextView textView3 = cVar.f17594c;
                                String status5 = chequeDetail.getStatus();
                                if (status5 == null) {
                                    str = null;
                                } else if (status5 != null) {
                                    str = status5.toLowerCase();
                                    k.a((Object) str, "(this as java.lang.String).toLowerCase()");
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                                textView3.setText(str);
                                AppCompatImageView a5 = cVar.a();
                                k.a((Object) a5, "menuIv");
                                net.one97.paytm.paymentsBank.chequebook.utils.b.a(a5);
                            }
                        }
                    }
                }
                cVar.a().setOnClickListener(new c.C0275a(cVar, chequeDetail));
                return;
            }
            return;
        } else if (vVar instanceof b) {
            IJRDataModel iJRDataModel3 = this.f17575a.get(i2);
            if (iJRDataModel3 instanceof CBHeading) {
                b bVar = (b) vVar;
                CBHeading cBHeading = (CBHeading) iJRDataModel3;
                k.c(cBHeading, "item");
                TextView textView4 = bVar.f17590a;
                k.a((Object) textView4, "heading");
                View view = bVar.itemView;
                k.a((Object) view, "itemView");
                textView4.setText(view.getContext().getString(R.string.cb_with_num, new Object[]{cBHeading.getCbNumber()}));
                if (!TextUtils.isEmpty(cBHeading.getLeavesTv())) {
                    TextView textView5 = bVar.f17591b;
                    k.a((Object) textView5, "leavesTv");
                    textView5.setVisibility(0);
                    TextView textView6 = bVar.f17591b;
                    k.a((Object) textView6, "leavesTv");
                    View view2 = bVar.itemView;
                    k.a((Object) view2, "itemView");
                    textView6.setText(view2.getContext().getString(R.string.cb_leaves_with_num, new Object[]{cBHeading.getLeavesTv()}));
                    return;
                }
                return;
            }
            return;
        } else if (vVar instanceof C0273a) {
            IJRDataModel iJRDataModel4 = this.f17575a.get(i2);
            if (iJRDataModel4 instanceof ChequeDetailsForInwardOutward) {
                C0273a aVar = (C0273a) vVar;
                ChequeDetailsForInwardOutward chequeDetailsForInwardOutward = (ChequeDetailsForInwardOutward) iJRDataModel4;
                k.c(chequeDetailsForInwardOutward, "chqDetails");
                TextView textView7 = (TextView) aVar.f17584b.getValue();
                k.a((Object) textView7, "toAcntTv");
                Context b2 = aVar.b();
                int i3 = R.string.cb_to_acnt_text;
                Object[] objArr = new Object[1];
                String payeeName = chequeDetailsForInwardOutward.getPayeeName();
                if (payeeName == null) {
                    payeeName = "";
                }
                objArr[0] = payeeName;
                textView7.setText(b2.getString(i3, objArr));
                TextView textView8 = (TextView) aVar.f17585c.getValue();
                k.a((Object) textView8, "amountTv");
                textView8.setText(aVar.b().getString(R.string.wallet_rs, new Object[]{chequeDetailsForInwardOutward.getAmount()}));
                TextView textView9 = (TextView) aVar.f17586d.getValue();
                k.a((Object) textView9, "bankNameNumTv");
                String presentingBankName = chequeDetailsForInwardOutward.getPresentingBankName();
                if (presentingBankName != null) {
                    charSequence2 = presentingBankName;
                } else {
                    charSequence2 = "";
                }
                textView9.setText(charSequence2);
                TextView textView10 = (TextView) aVar.f17587e.getValue();
                k.a((Object) textView10, "serialNumTv");
                String chqNumber = chequeDetailsForInwardOutward.getChqNumber();
                if (chqNumber != null) {
                    charSequence3 = chqNumber;
                } else {
                    charSequence3 = "";
                }
                textView10.setText(charSequence3);
                CharSequence h2 = com.paytm.utility.b.h(chequeDetailsForInwardOutward.getLatestTimeStamp(), "yyyy-MM-dd'T'hh:mm:ss", "dd MMMM''yy");
                if (!TextUtils.isEmpty(h2)) {
                    textView = aVar.a();
                    k.a((Object) textView, "clearedDateTv");
                    charSequence = h2;
                } else {
                    textView = aVar.a();
                    k.a((Object) textView, "clearedDateTv");
                    String latestTimeStamp = chequeDetailsForInwardOutward.getLatestTimeStamp();
                    if (latestTimeStamp != null) {
                        charSequence = latestTimeStamp;
                    } else {
                        charSequence = "";
                    }
                }
            } else {
                return;
            }
        } else {
            return;
        }
        textView.setText(charSequence);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2, List<Object> list) {
        k.c(vVar, "holder");
        k.c(list, "payloads");
        super.onBindViewHolder(vVar, i2, list);
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            if (k.a(obj, (Object) net.one97.paytm.paymentsBank.chequebook.utils.e.J()) && (vVar instanceof c)) {
                c cVar = (c) vVar;
                cVar.f17594c.setVisibility(0);
                cVar.f17594c.setBackground(androidx.core.content.b.a(cVar.f17594c.getContext(), R.drawable.pb_cb_stopped_bg));
                cVar.f17594c.setText(cVar.b().getString(R.string.cb_pymnt_stopd));
                cVar.f17594c.setTextColor(Color.parseColor("#fd5c5c"));
                cVar.f17595d.setAlpha(0.7f);
                AppCompatImageView a2 = cVar.a();
                k.a((Object) a2, "menuIv");
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(a2);
            }
        }
    }

    public static final class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17601a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17601a = (TextView) view.findViewById(R.id.tvRateMsg);
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a  reason: collision with other inner class name */
    public static final class C0273a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ i[] f17583a;

        /* renamed from: b  reason: collision with root package name */
        final g f17584b;

        /* renamed from: c  reason: collision with root package name */
        final g f17585c;

        /* renamed from: d  reason: collision with root package name */
        final g f17586d;

        /* renamed from: e  reason: collision with root package name */
        final g f17587e;

        /* renamed from: f  reason: collision with root package name */
        private final g f17588f;

        /* renamed from: g  reason: collision with root package name */
        private final g f17589g;

        static {
            Class<C0273a> cls = C0273a.class;
            f17583a = new i[]{y.a((v) new w(y.b(cls), "toAcntTv", "getToAcntTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "amountTv", "getAmountTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "bankNameNumTv", "getBankNameNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "serialNumTv", "getSerialNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "clearedDateTv", "getClearedDateTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "context", "getContext()Landroid/content/Context;"))};
        }

        public final TextView a() {
            return (TextView) this.f17588f.getValue();
        }

        public final Context b() {
            return (Context) this.f17589g.getValue();
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$f */
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
        public C0273a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17584b = h.a(new f(view));
            this.f17585c = h.a(new C0274a(view));
            this.f17586d = h.a(new b(view));
            this.f17587e = h.a(new e(view));
            this.f17588f = h.a(new c(view));
            this.f17589g = h.a(new d(view));
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$a  reason: collision with other inner class name */
        static final class C0274a extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0274a(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_cleared_amount_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$b */
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

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$e */
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

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$c */
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

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$a$d */
        static final class d extends l implements kotlin.g.a.a<Context> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(View view) {
                super(0);
                this.$itemView = view;
            }

            public final Context invoke() {
                return this.$itemView.getContext();
            }
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ i[] f17592a;

        /* renamed from: b  reason: collision with root package name */
        final g f17593b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f17594c;

        /* renamed from: d  reason: collision with root package name */
        final View f17595d;

        /* renamed from: e  reason: collision with root package name */
        final e f17596e;

        /* renamed from: f  reason: collision with root package name */
        private final g f17597f;

        /* renamed from: g  reason: collision with root package name */
        private final g f17598g;

        static {
            Class<c> cls = c.class;
            f17592a = new i[]{y.a((v) new w(y.b(cls), "serialNumTv", "getSerialNumTv()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "menuIv", "getMenuIv()Landroidx/appcompat/widget/AppCompatImageView;")), y.a((v) new w(y.b(cls), "context", "getContext()Landroid/content/Context;"))};
        }

        public final AppCompatImageView a() {
            return (AppCompatImageView) this.f17597f.getValue();
        }

        public final Context b() {
            return (Context) this.f17598g.getValue();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view, e eVar) {
            super(view);
            k.c(view, "itemView");
            k.c(eVar, "clicklistener");
            this.f17596e = eVar;
            this.f17593b = h.a(new d(view));
            this.f17597f = h.a(new C0276c(view));
            this.f17598g = h.a(new b(view));
            View findViewById = view.findViewById(R.id.cb_status_tv);
            if (findViewById != null) {
                this.f17594c = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.cb_other_chq_parent_lyt);
                if (findViewById2 != null) {
                    this.f17595d = findViewById2;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        static final class d extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                return (TextView) this.$itemView.findViewById(R.id.cb_other_serial_num_value_tv);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$c$c  reason: collision with other inner class name */
        static final class C0276c extends l implements kotlin.g.a.a<AppCompatImageView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0276c(View view) {
                super(0);
                this.$itemView = view;
            }

            public final AppCompatImageView invoke() {
                return (AppCompatImageView) this.$itemView.findViewById(R.id.cb_other_dotted_iv);
            }
        }

        static final class b extends l implements kotlin.g.a.a<Context> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(View view) {
                super(0);
                this.$itemView = view;
            }

            public final Context invoke() {
                return this.$itemView.getContext();
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.chequebook.leaflist.a$c$a  reason: collision with other inner class name */
        static final class C0275a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f17599a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ChequeDetail f17600b;

            C0275a(c cVar, ChequeDetail chequeDetail) {
                this.f17599a = cVar;
                this.f17600b = chequeDetail;
            }

            public final void onClick(View view) {
                e eVar = this.f17599a.f17596e;
                int id = this.f17600b.getId();
                String chqNumber = this.f17600b.getChqNumber();
                if (chqNumber == null) {
                    chqNumber = "";
                }
                View view2 = this.f17599a.itemView;
                k.a((Object) view2, "itemView");
                eVar.a(id, chqNumber, view2, this.f17599a.getAdapterPosition());
            }
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f17590a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f17591b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f17590a = (TextView) view.findViewById(R.id.tv_title);
            this.f17591b = (TextView) view.findViewById(R.id.tv_sub_title);
        }
    }

    public static final class d extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
