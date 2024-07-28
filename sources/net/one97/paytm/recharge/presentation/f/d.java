package net.one97.paytm.recharge.presentation.f;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRABCHLItems;
import net.one97.paytm.recharge.presentation.a.a;

public final class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f64851a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f64852b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, final a.C1273a aVar) {
        super(view);
        k.c(view, "itemView");
        View findViewById = view.findViewById(R.id.icon);
        if (findViewById != null) {
            this.f64851a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.category_name);
            if (findViewById2 != null) {
                this.f64852b = (TextView) findViewById2;
                view.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f64853a;

                    {
                        this.f64853a = r1;
                    }

                    public final void onClick(View view) {
                        a.C1273a aVar = aVar;
                        if (aVar != null) {
                            aVar.a(Integer.valueOf(this.f64853a.getAdapterPosition()));
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final <T> void a(T t) {
        if (t == null) {
            ImageView imageView = this.f64851a;
            if (imageView != null) {
                View view = this.itemView;
                k.a((Object) view, "itemView");
                imageView.setBackgroundColor(b.c(view.getContext(), R.color.dummy_items_background));
            }
            TextView textView = this.f64852b;
            if (textView != null) {
                View view2 = this.itemView;
                k.a((Object) view2, "itemView");
                textView.setBackgroundColor(b.c(view2.getContext(), R.color.dummy_items_background));
            }
        } else if (t instanceof CJRABCHLItems) {
            ImageView imageView2 = this.f64851a;
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.shape_recharge_replacement_icon_circle);
            }
            TextView textView2 = this.f64852b;
            if (textView2 != null) {
                View view3 = this.itemView;
                k.a((Object) view3, "itemView");
                textView2.setBackgroundColor(b.c(view3.getContext(), R.color.transparent));
            }
            TextView textView3 = this.f64852b;
            if (textView3 != null) {
                textView3.setText(((CJRABCHLItems) t).getName$recharge_automatic_release());
            }
            w.a().a(((CJRABCHLItems) t).getImageUrl$recharge_automatic_release()).a(this.f64851a);
        }
    }
}
