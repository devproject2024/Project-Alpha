package net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c;

public final class a extends RecyclerView.a<C0280a> {

    /* renamed from: a  reason: collision with root package name */
    int f17710a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f17711b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestCBActivity f17712c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0280a aVar = (C0280a) vVar;
        k.c(aVar, "holder");
        this.f17711b.a(aVar, i2);
        aVar.f17717e.setOnClickListener(new b(this, aVar));
        aVar.f17713a.setChecked(this.f17710a == i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return new C0280a(from != null ? from.inflate(R.layout.cb_item_horizontal_address, viewGroup, false) : null, this.f17711b);
    }

    public a(c.a aVar, RequestCBActivity requestCBActivity) {
        k.c(aVar, "presenter");
        k.c(requestCBActivity, "context");
        this.f17711b = aVar;
        this.f17712c = requestCBActivity;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17719a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0280a f17720b;

        b(a aVar, C0280a aVar2) {
            this.f17719a = aVar;
            this.f17720b = aVar2;
        }

        public final void onClick(View view) {
            this.f17719a.f17710a = this.f17720b.getAdapterPosition();
            this.f17719a.notifyDataSetChanged();
        }
    }

    public final int getItemCount() {
        return this.f17711b.f();
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.a$a  reason: collision with other inner class name */
    public static final class C0280a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RadioButton f17713a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f17714b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f17715c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f17716d;

        /* renamed from: e  reason: collision with root package name */
        final RelativeLayout f17717e;

        /* renamed from: f  reason: collision with root package name */
        private final c.a f17718f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0280a(View view, c.a aVar) {
            super(view);
            k.c(aVar, "mRequestCbPresenter");
            if (view == null) {
                k.a();
            }
            this.f17718f = aVar;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_address);
            if (radioButton != null) {
                this.f17713a = radioButton;
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    this.f17714b = textView;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_address);
                    if (textView2 != null) {
                        this.f17715c = textView2;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_contact);
                        if (textView3 != null) {
                            this.f17716d = textView3;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.row);
                            if (relativeLayout != null) {
                                this.f17717e = relativeLayout;
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.RadioButton");
        }
    }
}
