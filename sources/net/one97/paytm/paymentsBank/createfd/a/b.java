package net.one97.paytm.paymentsBank.createfd.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class b extends RecyclerView.a<C0300b> {

    /* renamed from: a  reason: collision with root package name */
    private List<OptionsModel> f18067a;

    /* renamed from: b  reason: collision with root package name */
    private Context f18068b;

    /* renamed from: c  reason: collision with root package name */
    private a f18069c;

    public interface a {
        void a();
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0300b bVar = (C0300b) vVar;
        k.c(bVar, "holder");
        OptionsModel optionsModel = this.f18067a.get(i2);
        Context context = this.f18068b;
        a aVar = this.f18069c;
        k.c(optionsModel, "option");
        k.c(context, "context");
        k.c(aVar, "listener");
        if (!TextUtils.isEmpty(optionsModel.getAmt())) {
            TextView textView = bVar.f18072c;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = bVar.f18072c;
            if (textView2 != null) {
                textView2.setText(optionsModel.getAmt());
            }
        } else {
            TextView textView3 = bVar.f18072c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = bVar.f18071b;
        if (textView4 != null) {
            textView4.setText(optionsModel.getTitle());
        }
        ImageView imageView = bVar.f18070a;
        if (imageView != null) {
            imageView.setImageResource(optionsModel.getIconId());
        }
        bVar.itemView.setOnClickListener(new C0300b.a(optionsModel, context, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(this.f18068b);
        View inflate = from != null ? from.inflate(R.layout.fd_post_transaction_options_view, viewGroup, false) : null;
        if (inflate == null) {
            k.a();
        }
        return new C0300b(inflate);
    }

    public b(List<OptionsModel> list, Context context, a aVar) {
        k.c(list, "optionList");
        k.c(context, "context");
        k.c(aVar, "listener");
        this.f18067a = list;
        this.f18068b = context;
        this.f18069c = aVar;
    }

    public final int getItemCount() {
        return this.f18067a.size();
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.a.b$b  reason: collision with other inner class name */
    public static final class C0300b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f18070a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18071b;

        /* renamed from: c  reason: collision with root package name */
        TextView f18072c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0300b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f18070a = (ImageView) view.findViewById(R.id.img_option_id);
            this.f18071b = (TextView) view.findViewById(R.id.tv_option_id);
            this.f18072c = (TextView) view.findViewById(R.id.tv_option_amt);
        }

        /* renamed from: net.one97.paytm.paymentsBank.createfd.a.b$b$a */
        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OptionsModel f18073a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f18074b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f18075c;

            a(OptionsModel optionsModel, Context context, a aVar) {
                this.f18073a = optionsModel;
                this.f18074b = context;
                this.f18075c = aVar;
            }

            public final void onClick(View view) {
                Integer tag = this.f18073a.getTag();
                b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                int s = net.one97.paytm.paymentsBank.createfd.utils.b.x;
                if (tag != null && tag.intValue() == s) {
                    o.a().checkDeepLinking(this.f18074b, n.q());
                    return;
                }
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                int t = net.one97.paytm.paymentsBank.createfd.utils.b.y;
                if (tag != null && tag.intValue() == t) {
                    this.f18075c.a();
                }
            }
        }
    }
}
