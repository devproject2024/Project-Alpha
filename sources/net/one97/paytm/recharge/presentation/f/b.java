package net.one97.paytm.recharge.presentation.f;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f64843a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f64844b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f64845c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, final AdapterView.OnItemClickListener onItemClickListener) {
        super(view);
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.title);
        if (findViewById != null) {
            this.f64843a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.description);
            if (findViewById2 != null) {
                this.f64844b = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.icon);
                if (findViewById3 != null) {
                    this.f64845c = (ImageView) findViewById3;
                    this.itemView.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f64846a;

                        {
                            this.f64846a = r1;
                        }

                        public final void onClick(View view) {
                            AdapterView.OnItemClickListener onItemClickListener = onItemClickListener;
                            if (onItemClickListener != null) {
                                onItemClickListener.onItemClick((AdapterView) null, (View) null, this.f64846a.getAdapterPosition(), 0);
                            }
                        }
                    });
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }
}
