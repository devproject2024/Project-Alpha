package net.one97.paytm.savedPaymentItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.paytm_finance.R;

public final class a extends com.google.android.material.bottomsheet.a implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    private TextView f64996g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f64997h;

    /* renamed from: i  reason: collision with root package name */
    private final C1284a f64998i;

    /* renamed from: net.one97.paytm.savedPaymentItem.a$a  reason: collision with other inner class name */
    public interface C1284a {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, C1284a aVar) {
        super(context);
        k.c(context, "context");
        k.c(aVar, "listener");
        this.f64998i = aVar;
        View inflate = View.inflate(getContext(), R.layout.dialog_add_saved_card, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tvAddCardProceed);
        k.a((Object) findViewById, "view.findViewById(R.id.tvAddCardProceed)");
        this.f64996g = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tvAddCardCancel);
        k.a((Object) findViewById2, "view.findViewById(R.id.tvAddCardCancel)");
        this.f64997h = (TextView) findViewById2;
        setContentView(inflate);
        View.OnClickListener onClickListener = this;
        this.f64997h.setOnClickListener(onClickListener);
        this.f64996g.setOnClickListener(onClickListener);
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.tvAddCardCancel) {
                dismiss();
            } else if (id == R.id.tvAddCardProceed) {
                this.f64998i.a();
                dismiss();
            }
        }
    }
}
