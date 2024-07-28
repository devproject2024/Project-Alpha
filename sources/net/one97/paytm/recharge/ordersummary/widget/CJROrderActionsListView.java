package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.widgets.c.e;

public class CJROrderActionsListView extends ConstraintLayout implements View.OnClickListener, o {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64443a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, View> f64444b;

    /* renamed from: c  reason: collision with root package name */
    private final CJROrderedCart f64445c;

    /* renamed from: d  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64446d;

    /* renamed from: e  reason: collision with root package name */
    private final List<CJROSActionItemV2> f64447e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.f.b f64448f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64449g;

    static final class c implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f64455a = new c();

        c() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    private View a(int i2) {
        if (this.f64449g == null) {
            this.f64449g = new HashMap();
        }
        View view = (View) this.f64449g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64449g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ CJROrderActionsListView(Context context, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, List list, net.one97.paytm.recharge.ordersummary.f.b bVar, byte b2) {
        this(context, cJROrderedCart, aVar, list, bVar);
    }

    public final CJROrderedCart getOrderedItem() {
        return this.f64445c;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64446d;
    }

    public final List<CJROSActionItemV2> getOrderActions() {
        return this.f64447e;
    }

    public final net.one97.paytm.recharge.ordersummary.f.b getActionsListener() {
        return this.f64448f;
    }

    private CJROrderActionsListView(Context context, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, List<CJROSActionItemV2> list, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        super(context);
        this.f64445c = cJROrderedCart;
        this.f64446d = aVar;
        this.f64447e = list;
        this.f64448f = bVar;
        this.f64444b = new HashMap<>(2);
        LayoutInflater.from(context).inflate(R.layout.content_os_order_actions, this, true);
        RecyclerView recyclerView = (RecyclerView) a(R.id.order_actions_recycler);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.order_actions_recycler);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        }
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.order_actions_recycler);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(new RecyclerView.a<b>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CJROrderActionsListView f64450a;

                {
                    this.f64450a = r1;
                }

                public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                    int i3;
                    b bVar = (b) vVar;
                    k.c(bVar, "holder");
                    CJROSActionItemV2 cJROSActionItemV2 = this.f64450a.getOrderActions().get(i2);
                    boolean z = true;
                    if (i2 != getItemCount() - 1) {
                        z = false;
                    }
                    k.c(bVar, "holder");
                    k.c(cJROSActionItemV2, "action");
                    View view = bVar.itemView;
                    k.a((Object) view, "holder.itemView");
                    view.setTag(new kotlin.o(cJROSActionItemV2.getmType(), cJROSActionItemV2));
                    TextView textView = bVar.f64452b;
                    k.a((Object) textView, "holder.txtView");
                    textView.setText(cJROSActionItemV2.getLabel());
                    String str = cJROSActionItemV2.getmType();
                    k.a((Object) str, "action.getmType()");
                    k.c(str, "type");
                    if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_REPEAT())) {
                        i3 = R.drawable.ic_os_action_recharge_another_no;
                    } else if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_HELP())) {
                        i3 = R.drawable.ic_os_action_24x7_help;
                    } else if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PAYMENT_DETAILS())) {
                        i3 = R.drawable.ic_os_action_payement_detail;
                    } else if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_DOWNLOAD_INVOICE())) {
                        i3 = R.drawable.ic_os_action_download;
                    } else {
                        i3 = R.drawable.invoice_re;
                    }
                    try {
                        w.a().a(cJROSActionItemV2.getmIconUrl()).a(i3).b(i3).a(bVar.f64451a);
                    } catch (Exception unused) {
                        bVar.f64451a.setImageResource(i3);
                    }
                    if (z) {
                        View view2 = bVar.f64453c;
                        k.a((Object) view2, "holder.dividerView");
                        view2.setVisibility(8);
                    }
                }

                public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                    k.c(viewGroup, "parent");
                    CJROrderActionsListView cJROrderActionsListView = this.f64450a;
                    k.c(viewGroup, "parent");
                    View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_order_actions_item, viewGroup, false);
                    k.a((Object) inflate, "LayoutInflater.from(pare…ions_item, parent, false)");
                    return new b(cJROrderActionsListView, inflate);
                }

                public final int getItemCount() {
                    return this.f64450a.getItemCount();
                }
            });
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static CJROrderActionsListView b(Context context, int i2, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, net.one97.paytm.recharge.ordersummary.f.b bVar, boolean z) {
            ArrayList<CJROrderSummaryAction> action;
            boolean z2;
            ArrayList arrayList = new ArrayList();
            if (!z) {
                Iterable iterable = aVar.k;
                boolean z3 = false;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((CJROrderedCart) it2.next()).getId() == cJROrderedCart.getId()) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                z3 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (((z3 && aVar.f64002f) || k.a((Object) cJROrderedCart.getItemStatus(), (Object) "7")) && (action = cJROrderedCart.getAction()) != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next : action) {
                        if (p.a(((CJROrderSummaryAction) next).getmType(), CJROSActionItemV2.Companion.getACTION_TYPE_DOWNLOAD_INVOICE(), true)) {
                            arrayList2.add(next);
                        }
                    }
                    for (CJROrderSummaryAction cJROrderSummaryAction : (List) arrayList2) {
                        try {
                            CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) new f().a(new f().a((Object) cJROrderSummaryAction), CJROSActionItemV2.class);
                            cJROSActionItemV2.setVisibilityMultiItem(2);
                            cJROSActionItemV2.setVisibility(i2);
                            k.a((Object) cJROSActionItemV2, "action");
                            cJROSActionItemV2.setLabel(context.getString(R.string.download_invoice));
                            cJROSActionItemV2.setmUiControl("button");
                            arrayList.add(cJROSActionItemV2);
                        } catch (Exception unused) {
                            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                            StringBuilder sb = new StringBuilder("Unable to add item-action ");
                            k.a((Object) cJROrderSummaryAction, "it");
                            String actionName = cJROrderSummaryAction.getActionName();
                            if (actionName == null) {
                                actionName = cJROrderSummaryAction.getLabel();
                            }
                            sb.append(actionName);
                            cJRRechargeUtilities.debugLog(sb.toString());
                        }
                    }
                }
            }
            CJROSActionItemV2 cJROSActionItemV22 = new CJROSActionItemV2();
            cJROSActionItemV22.setLabel(context.getString(R.string.v8_os_order_option_help));
            cJROSActionItemV22.setVisibility(i2);
            cJROSActionItemV22.setVisibilityMultiItem(2);
            cJROSActionItemV22.setVisibilityCategoryAction(2);
            cJROSActionItemV22.setmUiControl("button");
            cJROSActionItemV22.setmType(CJROSActionItemV2.Companion.getACTION_TYPE_HELP());
            arrayList.add(cJROSActionItemV22);
            return new CJROrderActionsListView(context, cJROrderedCart, aVar, arrayList, bVar, (byte) 0);
        }

        public static CJROrderActionsListView a(Context context, int i2, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, net.one97.paytm.recharge.ordersummary.f.b bVar, boolean z) {
            List list;
            CJROSActionResponseV2 orderLevelActions;
            List<CJROSActionItemV2> actions;
            boolean z2;
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = aVar;
            Context context2 = context;
            k.c(context, "context");
            k.c(cJROrderedCart, "orderedItem");
            k.c(aVar2, "viewModel");
            k.c(bVar, "actionsListener");
            CJROSActionResponseV2 cJROSActionResponseV2 = aVar2.m.get(Long.valueOf(cJROrderedCart.getId()));
            int i3 = 0;
            if (cJROSActionResponseV2 == null || (orderLevelActions = cJROSActionResponseV2.getOrderLevelActions()) == null || (actions = orderLevelActions.getActions()) == null) {
                int i4 = i2;
                boolean z3 = z;
                list = null;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : actions) {
                    CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) next;
                    boolean a2 = aVar2.a(cJROSActionItemV2, i2, z);
                    if (TextUtils.isEmpty(cJROSActionItemV2.getPayType())) {
                        z2 = a2;
                    } else {
                        if (a2) {
                            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
                            k.a((Object) productDetail, "orderedItem.productDetail");
                            CJRAttributes attributes = productDetail.getAttributes();
                            k.a((Object) attributes, "orderedItem.productDetail.attributes");
                            if (k.a((Object) attributes.getPaytype(), (Object) cJROSActionItemV2.getPayType())) {
                                z2 = true;
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(next);
                    }
                }
                int i5 = i2;
                boolean z4 = z;
                list = (List) arrayList;
            }
            if (list != null) {
                i3 = list.size();
            }
            if (i3 != 0) {
                return new CJROrderActionsListView(context, cJROrderedCart, aVar, list, bVar, (byte) 0);
            }
            if (cJROSActionResponseV2 == null) {
                return b(context, i2, cJROrderedCart, aVar, bVar, z);
            }
            return null;
        }
    }

    public final int getItemCount() {
        return this.f64447e.size();
    }

    public Map<String, View> getSharedElementMap() {
        return this.f64444b;
    }

    public void onClick(View view) {
        a(false, view);
    }

    public final void a(boolean z, View view) {
        if (view != null && !e.INSTANCE.validateIsAlreadyClicked(view, e.INSTANCE.getDELAY_1000_MILLI())) {
            Object tag = view.getTag();
            if (tag instanceof kotlin.o) {
                kotlin.o oVar = (kotlin.o) tag;
                if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_CANCEL_ORDER_ITEM()) || k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PRE_SHIP_CANCEL()) || k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_CANCEL())) {
                    net.one97.paytm.recharge.ordersummary.f.b bVar = this.f64448f;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        bVar.a((CJROrderSummaryAction) (CJROSActionItemV2) second, (DialogInterface.OnDismissListener) c.f64455a);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_REPEAT()) || k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_REPEAT_WITHOUT_AMOUNT()) || k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_REDIRECT_TO_CATEGORY())) {
                    if (this.f64446d.a(this.f64445c) || this.f64446d.b(this.f64445c)) {
                        this.f64446d.c("try_again_clicked", (String) null);
                    } else if (z) {
                        this.f64446d.c("pay_another_bill_clicked", "top_nav");
                    } else {
                        this.f64446d.c("pay_another_bill_clicked", "bottom_nav");
                    }
                    Object second2 = oVar.getSecond();
                    if (!(second2 instanceof CJROSActionItemV2)) {
                        second2 = null;
                    }
                    CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) second2;
                    if (cJROSActionItemV2 == null || TextUtils.isEmpty(cJROSActionItemV2.getSmartlink())) {
                        net.one97.paytm.recharge.ordersummary.f.b bVar2 = this.f64448f;
                        CJROrderedCart cJROrderedCart = this.f64445c;
                        Object first = oVar.getFirst();
                        if (first != null) {
                            bVar2.a(cJROrderedCart, (String) first);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                    net.one97.paytm.recharge.ordersummary.f.b bVar3 = this.f64448f;
                    String smartlink = cJROSActionItemV2.getSmartlink();
                    if (smartlink == null) {
                        k.a();
                    }
                    bVar3.a(smartlink);
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_VIEW_DETAILS())) {
                    this.f64446d.c("view_details_clicked", (String) null);
                    this.f64448f.a(this.f64444b);
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC())) {
                    this.f64446d.c("set_auto_pay_clicked", (String) null);
                    net.one97.paytm.recharge.ordersummary.f.b bVar4 = this.f64448f;
                    net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64446d;
                    CJROrderedCart cJROrderedCart2 = this.f64445c;
                    Object second3 = oVar.getSecond();
                    if (second3 != null) {
                        bVar4.setupAutoPay(aVar, cJROrderedCart2, (CJROSActionItemV2) second3);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT())) {
                    net.one97.paytm.recharge.ordersummary.f.b bVar5 = this.f64448f;
                    Object second4 = oVar.getSecond();
                    if (second4 != null) {
                        bVar5.setBillConsent((CJROSActionItemV2) second4);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_SHARE()) || k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_SHARE_VOUCHER_CODE())) {
                    net.one97.paytm.recharge.ordersummary.f.b bVar6 = this.f64448f;
                    Object first2 = oVar.getFirst();
                    if (first2 != null) {
                        bVar6.a((String) first2, (String) null);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.String");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_COPY_VOUCHER_CODE())) {
                    this.f64448f.a(this.f64446d, this.f64445c);
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_HELP())) {
                    this.f64446d.c("help_clicked", (String) null);
                    this.f64448f.f(this.f64445c);
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PAYMENT_DETAILS())) {
                    this.f64448f.a(this.f64446d, (DialogInterface.OnDismissListener) null);
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_DOWNLOAD_INVOICE())) {
                    this.f64446d.c("download_invoice_clicked", (String) null);
                    net.one97.paytm.recharge.ordersummary.f.b bVar7 = this.f64448f;
                    Object second5 = oVar.getSecond();
                    if (second5 != null) {
                        bVar7.a((CJROrderSummaryAction) (CJROSActionItemV2) second5);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PRO_SHARE())) {
                    Object second6 = oVar.getSecond();
                    if (second6 != null) {
                        CJROSActionItemV2 cJROSActionItemV22 = (CJROSActionItemV2) second6;
                        String message = cJROSActionItemV22.getMessage();
                        String smartlink2 = cJROSActionItemV22.getSmartlink();
                        if (TextUtils.isEmpty(smartlink2)) {
                            smartlink2 = getContext().getString(R.string.v8_os_pm_care_share_smartlink);
                        }
                        if (TextUtils.isEmpty(message)) {
                            message = getContext().getString(R.string.v8_os_pm_care_share_msg) + 10 + smartlink2;
                        }
                        this.f64448f.a(getContext().getString(R.string.v8_os_pm_care_share_title), message, cJROSActionItemV22.getImageUrlShare());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
                } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_HTML_BOTTOM_SHEET())) {
                    Object second7 = oVar.getSecond();
                    if (!(second7 instanceof CJROSActionItemV2)) {
                        second7 = null;
                    }
                    CJROSActionItemV2 cJROSActionItemV23 = (CJROSActionItemV2) second7;
                    if (cJROSActionItemV23 != null) {
                        this.f64448f.b(cJROSActionItemV23.getHtmlMessage());
                    }
                }
            }
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f64451a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f64452b;

        /* renamed from: c  reason: collision with root package name */
        final View f64453c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJROrderActionsListView f64454d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CJROrderActionsListView cJROrderActionsListView, View view) {
            super(view);
            k.c(view, "itemView");
            this.f64454d = cJROrderActionsListView;
            this.f64451a = (ImageView) view.findViewById(R.id.icon_order_optn);
            this.f64452b = (TextView) view.findViewById(R.id.txt_order_optn);
            this.f64453c = view.findViewById(R.id.divider_order_optn);
            view.setOnClickListener(cJROrderActionsListView);
        }
    }
}
