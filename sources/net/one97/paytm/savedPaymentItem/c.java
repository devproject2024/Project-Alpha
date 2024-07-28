package net.one97.paytm.savedPaymentItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.paytm_finance.R;

public final class c extends com.google.android.material.bottomsheet.a implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    private TextView f65017g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f65018h;

    /* renamed from: i  reason: collision with root package name */
    private final String f65019i;
    private final a j;

    public interface a {
        void b(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, String str, a aVar) {
        super(context);
        k.c(context, "context");
        k.c(str, "cardId");
        k.c(aVar, "listener");
        this.f65019i = str;
        this.j = aVar;
        View inflate = View.inflate(getContext(), R.layout.dialog_delete_saved_card, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tvDeleteCardCancel);
        k.a((Object) findViewById, "view.findViewById(R.id.tvDeleteCardCancel)");
        this.f65017g = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tvDeleteCardProceed);
        k.a((Object) findViewById2, "view.findViewById(R.id.tvDeleteCardProceed)");
        this.f65018h = (TextView) findViewById2;
        setContentView(inflate);
        View.OnClickListener onClickListener = this;
        this.f65017g.setOnClickListener(onClickListener);
        this.f65018h.setOnClickListener(onClickListener);
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.tvDeleteCardCancel) {
                dismiss();
            } else if (id == R.id.tvDeleteCardProceed) {
                this.j.b(this.f65019i);
                dismiss();
            }
        }
    }
}
