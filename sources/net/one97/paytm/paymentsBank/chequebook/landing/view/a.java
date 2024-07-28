package net.one97.paytm.paymentsBank.chequebook.landing.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.landing.a.a;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0272a f17566a = new C0272a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final a.C0270a f17567b;

    public a(a.C0270a aVar) {
        k.c(aVar, "presenter");
        this.f17567b = aVar;
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.landing.view.a$a  reason: collision with other inner class name */
    public static final class C0272a {
        private C0272a() {
        }

        public /* synthetic */ C0272a(byte b2) {
            this();
        }
    }

    public final int getItemCount() {
        if (this.f17567b.e() == 0) {
            return 1;
        }
        return this.f17567b.e();
    }

    public final int getItemViewType(int i2) {
        if (this.f17567b.e() != 0 && i2 == this.f17567b.e() - 1 && this.f17567b.c()) {
            return 0;
        }
        if (this.f17567b.e() == 0) {
            return 3;
        }
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof c) {
            this.f17567b.a(vVar, i2);
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2, List<Object> list) {
        k.c(vVar, "holder");
        k.c(list, "payloads");
        super.onBindViewHolder(vVar, i2, list);
        if ((!list.isEmpty()) && k.a(list.get(0), (Object) 2) && (vVar instanceof c)) {
            c cVar = (c) vVar;
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(cVar.f17571d);
            TextView textView = cVar.f17571d;
            View view = cVar.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            textView.setText(context != null ? context.getString(R.string.cb_pymnt_stopd) : null);
            cVar.f17571d.setBackground(androidx.core.content.b.a(cVar.f17571d.getContext(), R.drawable.pb_cb_stopped_bg));
            cVar.f17571d.setTextColor(Color.parseColor("#fd5c5c"));
            cVar.f17572e.setAlpha(0.7f);
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(cVar.f17573f);
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_list_loading_footer_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…oter_item, parent, false)");
            return new b(inflate);
        } else if (i2 == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_item_row_cb_details, (ViewGroup) null, false);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            k.a((Object) inflate2, "rootView");
            inflate2.setLayoutParams(layoutParams);
            return new c(inflate2);
        } else if (i2 != 3) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_item_row_cb_details, (ViewGroup) null, false);
            RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-1, -2);
            k.a((Object) inflate3, "rootView");
            inflate3.setLayoutParams(layoutParams2);
            return new c(inflate3);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cb_zero_delivered, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(pare…delivered, parent, false)");
            return new b(inflate4);
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17568a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f17569b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f17570c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f17571d;

        /* renamed from: e  reason: collision with root package name */
        public final ConstraintLayout f17572e;

        /* renamed from: f  reason: collision with root package name */
        public final ImageView f17573f;

        /* renamed from: g  reason: collision with root package name */
        public final View f17574g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.tv_pb_cb_name);
            if (textView != null) {
                this.f17568a = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_pb_cb_leaves_details);
                if (textView2 != null) {
                    this.f17569b = textView2;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_cb_issue_date);
                    if (textView3 != null) {
                        this.f17570c = textView3;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_pb_leaves_left);
                        if (textView4 != null) {
                            this.f17571d = textView4;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.row);
                            if (constraintLayout != null) {
                                this.f17572e = constraintLayout;
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_pb_cb_forword);
                                if (imageView != null) {
                                    this.f17573f = imageView;
                                    View findViewById = view.findViewById(R.id.transparent_view);
                                    if (findViewById != null) {
                                        this.f17574g = findViewById;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.view.View");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
