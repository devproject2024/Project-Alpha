package net.one97.paytm.wallet.rateMerchant;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.rateMerchant.entity.AnswerOption;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final List<AnswerOption> f71608a;

    /* renamed from: b  reason: collision with root package name */
    final C1454a f71609b;

    /* renamed from: net.one97.paytm.wallet.rateMerchant.a$a  reason: collision with other inner class name */
    public interface C1454a {
        void a(int i2);
    }

    public a(List<AnswerOption> list, C1454a aVar) {
        k.c(list, "optionsList");
        this.f71608a = list;
        this.f71609b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        if (i2 != -1) {
            AnswerOption answerOption = this.f71608a.get(i2);
            k.c(answerOption, "answerOption");
            TextView textView = bVar.f71615a;
            k.a((Object) textView, "optionTitle");
            textView.setText(answerOption.getOptionTitle());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ptxn_multi_choice_option_item, viewGroup, false);
        k.a((Object) inflate, "view");
        b bVar = new b(inflate);
        inflate.setOnClickListener(new c(this, bVar, inflate));
        return bVar;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f71616a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f71617b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f71618c;

        c(a aVar, b bVar, View view) {
            this.f71616a = aVar;
            this.f71617b = bVar;
            this.f71618c = view;
        }

        public final void onClick(View view) {
            int adapterPosition = this.f71617b.getAdapterPosition();
            if (adapterPosition != -1) {
                TextView textView = (TextView) this.f71618c.findViewById(R.id.optionTitle);
                k.a((Object) textView, "textView");
                textView.setActivated(!textView.isActivated());
                if (textView.isActivated()) {
                    textView.setTypeface((Typeface) null, 1);
                } else {
                    textView.setTypeface((Typeface) null, 0);
                }
                C1454a aVar = this.f71616a.f71609b;
                if (aVar != null) {
                    aVar.a(this.f71616a.f71608a.get(adapterPosition).getOptionId());
                }
            }
        }
    }

    public final int getItemCount() {
        return this.f71608a.size();
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f71615a = ((TextView) this.itemView.findViewById(R.id.optionTitle));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "view");
        }
    }
}
