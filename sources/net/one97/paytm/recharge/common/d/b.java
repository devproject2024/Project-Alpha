package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.v;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class b extends v.a {

    /* renamed from: a  reason: collision with root package name */
    final TextView f61004a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f61005b;

    /* renamed from: c  reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f61006c;

    /* renamed from: d  reason: collision with root package name */
    final Object f61007d;

    /* renamed from: e  reason: collision with root package name */
    final String f61008e;

    /* renamed from: f  reason: collision with root package name */
    private View f61009f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f61010g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, final w.b bVar, final List<? extends CJRBrowsePlanProductList> list, Object obj, String str) {
        super(view);
        k.c(view, "view");
        k.c(bVar, "mItemClickListner");
        k.c(list, "productList");
        k.c(obj, "eventCategory");
        this.f61007d = obj;
        this.f61008e = str;
        this.f61009f = view.findViewById(R.id.divider);
        this.f61010g = (TextView) view.findViewById(R.id.price_Text);
        this.f61004a = (TextView) view.findViewById(R.id.description);
        this.f61005b = (TextView) view.findViewById(R.id.readMoreTv);
        view.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f61011a;

            {
                this.f61011a = r1;
            }

            public final void onClick(View view) {
                if (this.f61011a.getAdapterPosition() >= 0) {
                    CJRBrowsePlanProductList cJRBrowsePlanProductList = (CJRBrowsePlanProductList) list.get(this.f61011a.getAdapterPosition());
                    cJRBrowsePlanProductList.setPlanCategoryDisplayName(this.f61011a.f61008e);
                    bVar.b(cJRBrowsePlanProductList);
                }
            }
        });
        this.f61005b.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f61014a;

            {
                this.f61014a = r1;
            }

            public final void onClick(View view) {
                TextView textView = this.f61014a.f61004a;
                k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView.setMaxLines(Integer.MAX_VALUE);
                TextView textView2 = this.f61014a.f61005b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(8);
                View view2 = this.f61014a.itemView;
                k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                k.a((Object) context, "itemView.context");
                d dVar = new d(context);
                Object obj = this.f61014a.f61007d;
                if (obj == null) {
                    obj = "";
                }
                d.a(dVar, obj, "plan_details_expanded", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        });
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "product");
        TextView textView = this.f61010g;
        if (textView != null) {
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            Resources resources = context.getResources();
            int i2 = R.string.v3_recharge_rs;
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            textView.setText(resources.getString(i2, new Object[]{net.one97.paytm.recharge.widgets.c.d.a(cJRBrowsePlanProductList.getPrice())}));
        }
        if (this.f61006c != null) {
            TextView textView2 = this.f61004a;
            k.a((Object) textView2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView2.getViewTreeObserver().removeOnPreDrawListener(this.f61006c);
        }
        if (cJRBrowsePlanProductList.getDescription() != null && !TextUtils.isEmpty(cJRBrowsePlanProductList.getDescription())) {
            this.f61006c = new a(this);
            TextView textView3 = this.f61004a;
            if (textView3 != null) {
                textView3.setText(cJRBrowsePlanProductList.getDescription());
            }
            TextView textView4 = this.f61004a;
            k.a((Object) textView4, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView4.getViewTreeObserver().addOnPreDrawListener(this.f61006c);
        }
    }

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61015a;

        a(b bVar) {
            this.f61015a = bVar;
        }

        public final boolean onPreDraw() {
            TextView textView = this.f61015a.f61004a;
            k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            if (textView.getLineCount() > 3) {
                TextView textView2 = this.f61015a.f61005b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f61015a.f61005b;
                k.a((Object) textView3, "readMoreTv");
                textView3.setVisibility(8);
            }
            TextView textView4 = this.f61015a.f61004a;
            k.a((Object) textView4, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView4.setMaxLines(3);
            if (this.f61015a.f61006c != null) {
                TextView textView5 = this.f61015a.f61004a;
                k.a((Object) textView5, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView5.getViewTreeObserver().removeOnPreDrawListener(this.f61015a.f61006c);
            }
            return false;
        }
    }
}
