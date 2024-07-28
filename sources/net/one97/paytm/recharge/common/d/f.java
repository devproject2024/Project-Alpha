package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.v;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class f extends v.a {

    /* renamed from: a  reason: collision with root package name */
    final TextView f61045a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f61046b;

    /* renamed from: c  reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f61047c;

    /* renamed from: d  reason: collision with root package name */
    final List<CJRBrowsePlanProductList> f61048d;

    /* renamed from: e  reason: collision with root package name */
    final Object f61049e;

    /* renamed from: f  reason: collision with root package name */
    final String f61050f;

    /* renamed from: g  reason: collision with root package name */
    private View f61051g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f61052h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f61053i;
    private final TextView j;
    private final LinearLayout k;
    private final TextView l;
    private final LinearLayout m;
    private final ImageView n;
    private final TextView o;
    private final a p;

    public interface a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view, final w.b bVar, List<? extends CJRBrowsePlanProductList> list, a aVar, Object obj, String str) {
        super(view);
        k.c(view, "view");
        k.c(bVar, "mItemClickListner");
        k.c(list, "productList");
        k.c(obj, "eventCategory");
        this.f61048d = list;
        this.p = aVar;
        this.f61049e = obj;
        this.f61050f = str;
        this.f61051g = view.findViewById(R.id.divider);
        this.f61052h = (TextView) view.findViewById(R.id.price_Text);
        this.f61053i = (RelativeLayout) view.findViewById(R.id.descriptionRL);
        this.f61045a = (TextView) view.findViewById(R.id.description);
        this.j = (TextView) view.findViewById(R.id.daysTv);
        this.k = (LinearLayout) view.findViewById(R.id.validityLL);
        this.l = (TextView) view.findViewById(R.id.dataTv);
        this.m = (LinearLayout) view.findViewById(R.id.dataLL);
        this.n = (ImageView) view.findViewById(R.id.talkTimeRightIv);
        this.o = (TextView) view.findViewById(R.id.talkTimeTv);
        this.f61046b = (TextView) view.findViewById(R.id.readMoreTv);
        view.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f61054a;

            {
                this.f61054a = r1;
            }

            public final void onClick(View view) {
                if (this.f61054a.getAdapterPosition() >= 0) {
                    CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f61054a.f61048d.get(this.f61054a.getAdapterPosition());
                    cJRBrowsePlanProductList.setPlanCategoryDisplayName(this.f61054a.f61050f);
                    bVar.b(cJRBrowsePlanProductList);
                }
            }
        });
        this.f61046b.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f61056a;

            {
                this.f61056a = r1;
            }

            public final void onClick(View view) {
                TextView textView = this.f61056a.f61045a;
                k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView.setMaxLines(Integer.MAX_VALUE);
                TextView textView2 = this.f61056a.f61046b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(8);
                View view2 = this.f61056a.itemView;
                k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                k.a((Object) context, "itemView.context");
                d dVar = new d(context);
                Object obj = this.f61056a.f61049e;
                if (obj == null) {
                    obj = "";
                }
                d.a(dVar, obj, "plan_details_expanded", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        });
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "product");
        TextView textView = this.f61052h;
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
        TextView textView2 = this.f61045a;
        if (textView2 != null) {
            textView2.setMaxLines(Integer.MAX_VALUE);
        }
        boolean z = cJRBrowsePlanProductList.getData() == null || TextUtils.isEmpty(cJRBrowsePlanProductList.getData()) || p.a("NA", cJRBrowsePlanProductList.getData(), true);
        boolean z2 = cJRBrowsePlanProductList.getValidity() == null || TextUtils.isEmpty(cJRBrowsePlanProductList.getValidity()) || p.a("NA", cJRBrowsePlanProductList.getValidity(), true);
        String productType = cJRBrowsePlanProductList.getProductType();
        if ((productType == null || !p.a(productType, "topup", true)) && (!z || !z2)) {
            if (!z || !z2) {
                if (!z) {
                    LinearLayout linearLayout = this.m;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    TextView textView3 = this.l;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    TextView textView4 = this.l;
                    if (textView4 != null) {
                        textView4.setText(cJRBrowsePlanProductList.getData());
                    }
                } else {
                    LinearLayout linearLayout2 = this.m;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    TextView textView5 = this.l;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                }
                if (!z2) {
                    LinearLayout linearLayout3 = this.k;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    TextView textView6 = this.j;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                    }
                    TextView textView7 = this.j;
                    k.a((Object) textView7, "daysTv");
                    textView7.setText(cJRBrowsePlanProductList.getValidity());
                } else {
                    LinearLayout linearLayout4 = this.k;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                    TextView textView8 = this.j;
                    if (textView8 != null) {
                        textView8.setVisibility(8);
                    }
                }
            } else {
                TextView textView9 = this.l;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                LinearLayout linearLayout5 = this.m;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                TextView textView10 = this.f61052h;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
                TextView textView11 = this.j;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
                LinearLayout linearLayout6 = this.k;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
            }
            RelativeLayout relativeLayout = this.f61053i;
            k.a((Object) relativeLayout, "layout_only_description");
            relativeLayout.setVisibility(0);
        } else if (cJRBrowsePlanProductList.getTalktime() != null && !TextUtils.isEmpty(cJRBrowsePlanProductList.getTalktime())) {
            String talktime = cJRBrowsePlanProductList.getTalktime();
            k.a((Object) talktime, "product.talktime");
            if (talktime != null) {
                String upperCase = talktime.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                if (!upperCase.equals("NA")) {
                    View view2 = this.itemView;
                    k.a((Object) view2, "itemView");
                    Context context2 = view2.getContext();
                    k.a((Object) context2, "itemView.context");
                    if (!p.a(context2.getResources().getString(R.string.zero_text), cJRBrowsePlanProductList.getTalktime(), false)) {
                        TextView textView12 = this.o;
                        if (textView12 != null) {
                            textView12.setVisibility(0);
                        }
                        TextView textView13 = this.l;
                        if (textView13 != null) {
                            textView13.setVisibility(8);
                        }
                        LinearLayout linearLayout7 = this.m;
                        if (linearLayout7 != null) {
                            linearLayout7.setVisibility(8);
                        }
                        TextView textView14 = this.j;
                        if (textView14 != null) {
                            textView14.setVisibility(8);
                        }
                        LinearLayout linearLayout8 = this.k;
                        if (linearLayout8 != null) {
                            linearLayout8.setVisibility(8);
                        }
                        RelativeLayout relativeLayout2 = this.f61053i;
                        k.a((Object) relativeLayout2, "layout_only_description");
                        relativeLayout2.setVisibility(8);
                        ImageView imageView = this.n;
                        k.a((Object) imageView, "talktimeRightIv");
                        imageView.setVisibility(0);
                        TextView textView15 = this.o;
                        if (textView15 != null) {
                            View view3 = this.itemView;
                            k.a((Object) view3, "itemView");
                            Context context3 = view3.getContext();
                            k.a((Object) context3, "itemView.context");
                            textView15.setText(context3.getResources().getString(R.string.browse_plan_talktime_text, new Object[]{cJRBrowsePlanProductList.getTalktime()}));
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (this.f61047c != null) {
            TextView textView16 = this.f61045a;
            k.a((Object) textView16, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView16.getViewTreeObserver().removeOnPreDrawListener(this.f61047c);
        }
        if (cJRBrowsePlanProductList.getDescription() != null && !TextUtils.isEmpty(cJRBrowsePlanProductList.getDescription())) {
            TextView textView17 = this.f61045a;
            if (textView17 != null) {
                textView17.setText(cJRBrowsePlanProductList.getDescription());
            }
            this.f61047c = new b(this);
            TextView textView18 = this.f61045a;
            k.a((Object) textView18, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView18.getViewTreeObserver().addOnPreDrawListener(this.f61047c);
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f61057a;

        b(f fVar) {
            this.f61057a = fVar;
        }

        public final boolean onPreDraw() {
            TextView textView = this.f61057a.f61045a;
            k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            if (textView.getLineCount() > 3) {
                TextView textView2 = this.f61057a.f61046b;
                k.a((Object) textView2, "readMoreTv");
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f61057a.f61046b;
                k.a((Object) textView3, "readMoreTv");
                textView3.setVisibility(8);
            }
            TextView textView4 = this.f61057a.f61045a;
            k.a((Object) textView4, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            textView4.setMaxLines(3);
            if (this.f61057a.f61047c != null) {
                TextView textView5 = this.f61057a.f61045a;
                k.a((Object) textView5, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView5.getViewTreeObserver().removeOnPreDrawListener(this.f61057a.f61047c);
            }
            return false;
        }
    }
}
