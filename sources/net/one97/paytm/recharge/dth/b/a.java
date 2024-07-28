package net.one97.paytm.recharge.dth.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.bj;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.c.e;

public final class a extends p.d {

    /* renamed from: c  reason: collision with root package name */
    private TextView f62738c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f62739d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f62740e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f62741f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f62742g;

    /* renamed from: h  reason: collision with root package name */
    private SwipeLayoutHelperV8 f62743h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f62744i;
    private CJRFrequentOrder j;

    public static final /* synthetic */ CJRFrequentOrder a(a aVar) {
        CJRFrequentOrder cJRFrequentOrder = aVar.j;
        if (cJRFrequentOrder == null) {
            k.a("clickedFrequentOrder");
        }
        return cJRFrequentOrder;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, final CJRRecentOrderV8.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(aVar, "option");
        this.f62740e = (ImageView) view.findViewById(R.id.operator_image);
        this.f62741f = (TextView) view.findViewById(R.id.last_recharge);
        View findViewById = view.findViewById(R.id.lyt_recent);
        if (findViewById != null) {
            this.f62744i = (RelativeLayout) findViewById;
            this.f62742g = (TextView) view.findViewById(R.id.delete_tv);
            this.f62743h = (SwipeLayoutHelperV8) view.findViewById(R.id.parent_layout);
            TextView textView = this.f62742g;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f62745a;

                    {
                        this.f62745a = r1;
                    }

                    public final void onClick(View view) {
                        p.a aVar;
                        e eVar = e.INSTANCE;
                        k.a((Object) view, "it");
                        Context context = view.getContext();
                        k.a((Object) context, "it.context");
                        if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (aVar = aVar.f61927e) != null) {
                            aVar.a(a.a(this.f62745a), this.f62745a.getAdapterPosition());
                        }
                    }
                });
            }
            this.f62744i.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f62747a;

                {
                    this.f62747a = r1;
                }

                public final void onClick(View view) {
                    p.a aVar;
                    e eVar = e.INSTANCE;
                    k.a((Object) view, "view");
                    Context context = view.getContext();
                    k.a((Object) context, "view.context");
                    if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && !kotlin.m.p.a("shimmer", a.a(this.f62747a).viewType, true) && (aVar = aVar.f61927e) != null) {
                        aVar.c(a.a(this.f62747a), this.f62747a.getAdapterPosition());
                    }
                }
            });
            SwipeLayoutHelperV8 swipeLayoutHelperV8 = this.f62743h;
            if (swipeLayoutHelperV8 != null) {
                if (swipeLayoutHelperV8 == null) {
                    k.a();
                }
                a(swipeLayoutHelperV8);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        k.c(cJRFrequentOrder, "recent");
        this.j = cJRFrequentOrder;
        if (!kotlin.m.p.a("shimmer", cJRFrequentOrder.viewType, true)) {
            if (!this.f60653b.q || cJRFrequentOrder.getDisplayValue() == null || cJRFrequentOrder.getDisplayValue().length() <= 0) {
                this.f62738c = (TextView) this.itemView.findViewById(R.id.operator_id);
                this.f62739d = (TextView) this.itemView.findViewById(R.id.operator);
                if (cJRFrequentOrder.getRechargeNumber() != null) {
                    TextView textView = this.f62738c;
                    if (textView != null) {
                        textView.setText(cJRFrequentOrder.getRechargeNumber());
                    }
                    TextView textView2 = this.f62738c;
                    if (textView2 != null) {
                        ai.a(textView2);
                    }
                }
                if (cJRFrequentOrder.getOperator() != null) {
                    TextView textView3 = this.f62739d;
                    if (textView3 != null) {
                        textView3.setText(cJRFrequentOrder.getOperatorDisplayLabel());
                    }
                    TextView textView4 = this.f62739d;
                    if (textView4 != null) {
                        ai.a(textView4);
                    }
                }
            } else {
                this.f62738c = (TextView) this.itemView.findViewById(R.id.text_item_1);
                this.f62739d = (TextView) this.itemView.findViewById(R.id.text_item_2);
                if (cJRFrequentOrder.getDisplayValue() != null && ((cJRFrequentOrder.getDisplayValue().length() == 1 || cJRFrequentOrder.getDisplayValue().length() > 1) && cJRFrequentOrder.getDisplayValueMap().size() > 0 && cJRFrequentOrder.getDisplayValueKeys().size() > 0)) {
                    TextView textView5 = this.f62738c;
                    if (textView5 != null) {
                        textView5.setText(cJRFrequentOrder.getDisplayValueMap().get(cJRFrequentOrder.getDisplayValueKeys().get(0)));
                    }
                    TextView textView6 = this.f62738c;
                    if (textView6 != null) {
                        ai.a(textView6);
                    }
                }
                if (cJRFrequentOrder.getOperator() != null) {
                    if (cJRFrequentOrder.getDisplayValue().length() <= 1) {
                        TextView textView7 = this.f62739d;
                        if (textView7 != null) {
                            textView7.setText(cJRFrequentOrder.getOperatorDisplayLabel());
                        }
                    } else if (cJRFrequentOrder.getDisplayValueMap().size() <= 1 || cJRFrequentOrder.getDisplayValueKeys().size() <= 1) {
                        TextView textView8 = this.f62739d;
                        if (textView8 != null) {
                            textView8.setText(cJRFrequentOrder.getOperatorDisplayLabel());
                        }
                    } else {
                        TextView textView9 = this.f62739d;
                        if (textView9 != null) {
                            textView9.setText(cJRFrequentOrder.getOperatorDisplayLabel() + " (" + cJRFrequentOrder.getDisplayValueKeys().get(1) + " " + cJRFrequentOrder.getDisplayValueMap().get(cJRFrequentOrder.getDisplayValueKeys().get(1)) + ")");
                        }
                    }
                    TextView textView10 = this.f62739d;
                    if (textView10 != null) {
                        ai.a(textView10);
                    }
                }
            }
            SwipeLayoutHelperV8 swipeLayoutHelperV8 = this.f62743h;
            if (swipeLayoutHelperV8 != null) {
                swipeLayoutHelperV8.b(false);
            }
            bj bjVar = this.f60653b.k;
            bj bjVar2 = this.f60653b.k;
            if (bjVar2 != null) {
                SwipeLayoutHelperV8 swipeLayoutHelperV82 = this.f62743h;
                StringBuilder sb = new StringBuilder();
                sb.append(getAdapterPosition());
                bjVar2.a(swipeLayoutHelperV82, sb.toString());
            }
            if (cJRFrequentOrder.getOperatorLogoURL() != null) {
                w.a().a(cJRFrequentOrder.getOperatorLogoURL()).a(this.f62740e);
                ImageView imageView = this.f62740e;
                k.a((Object) imageView, "operatorImage");
                ai.a(imageView);
            }
            CharSequence b2 = b(cJRFrequentOrder);
            if (TextUtils.isEmpty(b2)) {
                View view = this.itemView;
                k.a((Object) view, "itemView");
                Context context = view.getContext();
                int i3 = R.string.v8_recent_last_recharge_on;
                d dVar = d.f64967a;
                String rechargeAmount = cJRFrequentOrder.getRechargeAmount();
                k.a((Object) rechargeAmount, "recent.rechargeAmount");
                String string = context.getString(i3, new Object[]{a(cJRFrequentOrder), d.a(rechargeAmount, false, 2, false, 10), ab.a(cJRFrequentOrder.getPaidOn(), "dd MMM, yyyy")});
                k.a((Object) string, "itemView.context.getStri…LAY_PAID_ON_DATE_FORMAT))");
                TextView textView11 = this.f62741f;
                k.a((Object) textView11, "lastRechargeTextView");
                textView11.setTextColor(b.c(textView11.getContext(), R.color.color_8f969c));
                TextView textView12 = this.f62741f;
                k.a((Object) textView12, "lastRechargeTextView");
                textView12.setText(string);
                TextView textView13 = this.f62741f;
                k.a((Object) textView13, "lastRechargeTextView");
                ai.a(textView13);
                return;
            }
            TextView textView14 = this.f62741f;
            k.a((Object) textView14, "lastRechargeTextView");
            textView14.setTextColor(b.c(textView14.getContext(), R.color.color_f6a108));
            TextView textView15 = this.f62741f;
            k.a((Object) textView15, "lastRechargeTextView");
            textView15.setText(b2);
            TextView textView16 = this.f62741f;
            k.a((Object) textView16, "lastRechargeTextView");
            ai.a(textView16);
        }
    }
}
