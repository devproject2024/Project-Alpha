package net.one97.paytm.recharge.mobile_v3.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.i;
import net.one97.paytm.recharge.common.e.g;
import net.one97.paytm.recharge.mobile_v3.c.h;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public class c extends f implements View.OnClickListener, g<h> {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.mobile_v3.d.a f63733a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnClickListener f63734b;

    /* renamed from: c  reason: collision with root package name */
    private DialogInterface.OnDismissListener f63735c;

    /* renamed from: d  reason: collision with root package name */
    private CJRProceedWidgetV8 f63736d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRAggsItem> f63737e;

    /* renamed from: f  reason: collision with root package name */
    private CJRBrowsePlanProductList f63738f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBrowsePlanProductList f63739g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRBrowsePlanProductList> f63740h;

    /* renamed from: i  reason: collision with root package name */
    private int f63741i = -1;
    private RecyclerView j;
    private boolean k;
    private boolean l;
    private HashMap m;

    public final long c_(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_content_item_product_type, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…duct_type, parent, false)");
        return new h(inflate);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        h hVar = (h) vVar;
        k.c(hVar, "holder");
        ArrayList<CJRAggsItem> arrayList = this.f63737e;
        if (arrayList == null) {
            k.a();
        }
        CJRAggsItem cJRAggsItem = arrayList.get(i2);
        k.a((Object) cJRAggsItem, "mProductTypes!![position]");
        CJRAggsItem cJRAggsItem2 = cJRAggsItem;
        if (cJRAggsItem2.isItemSelected()) {
            this.f63741i = i2;
        }
        List list = this.f63740h;
        View.OnClickListener onClickListener = this;
        k.c(cJRAggsItem2, "productType");
        k.c(onClickListener, "itemClickListener");
        hVar.itemView.setOnClickListener(onClickListener);
        View view = hVar.itemView;
        k.a((Object) view, "itemView");
        CJRBrowsePlanProductList cJRBrowsePlanProductList = null;
        view.setTag(new o(Integer.valueOf(hVar.getAdapterPosition()), null));
        if (cJRAggsItem2.isItemSelected()) {
            hVar.f63940a.setImageResource(R.drawable.ic_re_radio_button_selected);
            if (Build.VERSION.SDK_INT >= 23) {
                hVar.f63941b.setTextAppearance(R.style.radioButtonSelectedStyle);
            } else {
                TextView textView = hVar.f63941b;
                View view2 = hVar.itemView;
                k.a((Object) view2, "itemView");
                textView.setTextAppearance(view2.getContext(), R.style.radioButtonSelectedStyle);
            }
        } else {
            hVar.f63940a.setImageResource(R.drawable.ic_re_radio_button_unselected);
            if (Build.VERSION.SDK_INT >= 23) {
                hVar.f63941b.setTextAppearance(R.style.radioButtonUnselectedStyle);
            } else {
                TextView textView2 = hVar.f63941b;
                View view3 = hVar.itemView;
                k.a((Object) view3, "itemView");
                textView2.setTextAppearance(view3.getContext(), R.style.radioButtonUnselectedStyle);
            }
        }
        TextView textView3 = hVar.f63941b;
        k.a((Object) textView3, "txt_product_type_name");
        textView3.setText(cJRAggsItem2.getDisplayValue());
        List<CJRProductsItem> productList = cJRAggsItem2.getProductList();
        if (!(productList == null || !(!productList.isEmpty()) || list == null)) {
            Collection arrayList2 = new ArrayList();
            for (Object next : list) {
                CJRBrowsePlanProductList cJRBrowsePlanProductList2 = (CJRBrowsePlanProductList) next;
                String productType = cJRAggsItem2.getProductList().get(0).getProductType();
                if (productType != null && p.a(productType, cJRBrowsePlanProductList2.getProductType(), true)) {
                    arrayList2.add(next);
                }
            }
            cJRBrowsePlanProductList = (CJRBrowsePlanProductList) kotlin.a.k.e((List) arrayList2);
        }
        List<CJRProductsItem> productList2 = cJRAggsItem2.getProductList();
        if (productList2 == null || !(!productList2.isEmpty()) || cJRBrowsePlanProductList == null || TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDescription())) {
            TextView textView4 = hVar.f63942c;
            k.a((Object) textView4, "txt_product_type_description");
            textView4.setVisibility(8);
            return;
        }
        View view4 = hVar.itemView;
        k.a((Object) view4, "itemView");
        view4.setTag(new o(Integer.valueOf(hVar.getAdapterPosition()), cJRBrowsePlanProductList));
        TextView textView5 = hVar.f63942c;
        k.a((Object) textView5, "txt_product_type_description");
        textView5.setText(cJRBrowsePlanProductList.getParsedDescription());
        TextView textView6 = hVar.f63942c;
        k.a((Object) textView6, "txt_product_type_description");
        textView6.setVisibility(0);
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof DialogInterface.OnClickListener) {
            this.f63734b = (DialogInterface.OnClickListener) context;
        }
    }

    public void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() == null) {
            throw new IllegalStateException();
        }
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            View view = null;
            if ((dialog != null ? dialog.getWindow() : null) != null && Build.VERSION.SDK_INT >= 26) {
                Dialog dialog2 = getDialog();
                Window window = dialog2 != null ? dialog2.getWindow() : null;
                if (window != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    view.setSystemUiVisibility(view.getSystemUiVisibility() | 16);
                }
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f63742a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f63742a = new a();

        a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        if (this.k) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.clearFlags(2);
            }
            new Handler().postDelayed(new b(this), 300);
        }
        return layoutInflater.inflate(R.layout.v3_dialog_product_types, viewGroup, false);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63743a;

        b(c cVar) {
            this.f63743a = cVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f63743a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.title);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            Bundle arguments = getArguments();
            if (arguments == null || (str = arguments.getString("title")) == null) {
                str = "";
            }
            textView.setText(str);
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 != null ? arguments2.getSerializable("info.msg.1") : null;
            if (!(serializable instanceof CJRBrowsePlanProductList)) {
                serializable = null;
            }
            this.f63738f = (CJRBrowsePlanProductList) serializable;
            if (!isCancelable()) {
                View findViewById2 = view.findViewById(R.id.close_button);
                k.a((Object) findViewById2, "view.findViewById<ImageView>(R.id.close_button)");
                ((ImageView) findViewById2).setVisibility(8);
            }
            Bundle arguments3 = getArguments();
            Serializable serializable2 = arguments3 != null ? arguments3.getSerializable("info.msg.2") : null;
            if (!(serializable2 instanceof ArrayList)) {
                serializable2 = null;
            }
            this.f63740h = (ArrayList) serializable2;
            Bundle arguments4 = getArguments();
            Serializable serializable3 = arguments4 != null ? arguments4.getSerializable("list.data") : null;
            if (!(serializable3 instanceof ArrayList)) {
                serializable3 = null;
            }
            this.f63737e = (ArrayList) serializable3;
            View findViewById3 = view.findViewById(R.id.product_types);
            if (findViewById3 != null) {
                this.j = (RecyclerView) findViewById3;
                RecyclerView recyclerView = this.j;
                if (recyclerView == null) {
                    k.a();
                }
                ArrayList<CJRAggsItem> arrayList = this.f63737e;
                if (arrayList != null && (!arrayList.isEmpty())) {
                    recyclerView.setVisibility(0);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setAdapter(new i(this));
                }
                View.OnClickListener onClickListener = this;
                ((ImageView) view.findViewById(R.id.close_button)).setOnClickListener(onClickListener);
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) view.findViewById(R.id.btn_confirm_product_type);
                this.f63736d = cJRProceedWidgetV8;
                cJRProceedWidgetV8.setOnClickListener(onClickListener);
                cJRProceedWidgetV8.setProceedBtnText(getString(R.string.confirm));
                cJRProceedWidgetV8.setVisibility(0);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public int getItemCount() {
        ArrayList<CJRAggsItem> arrayList = this.f63737e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000c
            int r1 = r6.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = net.one97.paytm.recharge.R.id.positive_button
            r3 = -1
            if (r1 != 0) goto L_0x0013
            goto L_0x0028
        L_0x0013:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x0028
            android.content.DialogInterface$OnClickListener r6 = r5.f63734b
            if (r6 == 0) goto L_0x0110
            android.app.Dialog r0 = r5.getDialog()
            android.content.DialogInterface r0 = (android.content.DialogInterface) r0
            r6.onClick(r0, r3)
            goto L_0x0110
        L_0x0028:
            int r2 = net.one97.paytm.recharge.R.id.negative_button
            if (r1 != 0) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x0043
            android.content.DialogInterface$OnClickListener r6 = r5.f63734b
            if (r6 == 0) goto L_0x0110
            android.app.Dialog r0 = r5.getDialog()
            android.content.DialogInterface r0 = (android.content.DialogInterface) r0
            r1 = -2
            r6.onClick(r0, r1)
            goto L_0x0110
        L_0x0043:
            int r2 = net.one97.paytm.recharge.R.id.lyt_content_item_product_type
            if (r1 != 0) goto L_0x0049
            goto L_0x00c9
        L_0x0049:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x00c9
            java.lang.Object r6 = r6.getTag()
            boolean r1 = r6 instanceof kotlin.o
            if (r1 != 0) goto L_0x0058
            r6 = r0
        L_0x0058:
            kotlin.o r6 = (kotlin.o) r6
            if (r6 == 0) goto L_0x0062
            java.lang.Object r0 = r6.getSecond()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
        L_0x0062:
            r5.f63739g = r0
            if (r6 == 0) goto L_0x0072
            java.lang.Object r6 = r6.getFirst()
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x0072
            int r3 = r6.intValue()
        L_0x0072:
            int r6 = r5.f63741i
            if (r3 == r6) goto L_0x00c8
            if (r3 < 0) goto L_0x00c8
            java.util.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem> r6 = r5.f63737e
            if (r6 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            int r6 = r6.size()
            if (r3 >= r6) goto L_0x00c8
            java.util.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem> r6 = r5.f63737e
            if (r6 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            int r0 = r5.f63741i
            java.lang.Object r6 = r6.get(r0)
            java.lang.String r0 = "mProductTypes!![mLastSelectedPosition]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            r0 = 0
            r6.setItemSelected(r0)
            java.util.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem> r6 = r5.f63737e
            if (r6 != 0) goto L_0x00a4
            kotlin.g.b.k.a()
        L_0x00a4:
            java.lang.Object r6 = r6.get(r3)
            java.lang.String r0 = "mProductTypes!![itemPosition]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            r0 = 1
            r6.setItemSelected(r0)
            r5.f63741i = r3
            androidx.recyclerview.widget.RecyclerView r6 = r5.j
            if (r6 != 0) goto L_0x00bc
            kotlin.g.b.k.a()
        L_0x00bc:
            androidx.recyclerview.widget.RecyclerView$a r6 = r6.getAdapter()
            if (r6 != 0) goto L_0x00c5
            kotlin.g.b.k.a()
        L_0x00c5:
            r6.notifyDataSetChanged()
        L_0x00c8:
            return
        L_0x00c9:
            int r6 = net.one97.paytm.recharge.R.id.btn_confirm_product_type
            if (r1 != 0) goto L_0x00ce
            goto L_0x0110
        L_0x00ce:
            int r1 = r1.intValue()
            if (r1 != r6) goto L_0x0110
            android.content.Context r6 = r5.getContext()
            boolean r6 = com.paytm.utility.b.c((android.content.Context) r6)
            if (r6 == 0) goto L_0x00e2
            r5.b()
            return
        L_0x00e2:
            android.content.Context r6 = r5.getContext()
            android.content.Context r1 = r5.getContext()
            if (r1 == 0) goto L_0x00f9
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x00f9
            int r2 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r1 = r1.getString(r2)
            goto L_0x00fa
        L_0x00f9:
            r1 = r0
        L_0x00fa:
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x010c
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x010c
            int r0 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r0 = r2.getString(r0)
        L_0x010c:
            com.paytm.utility.g.c(r6, r1, r0)
            return
        L_0x0110:
            r5.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.a.c.onClick(android.view.View):void");
    }

    private final void b() {
        this.l = true;
        int i2 = this.f63741i;
        if (i2 >= 0) {
            ArrayList<CJRAggsItem> arrayList = this.f63737e;
            if (arrayList == null) {
                k.a();
            }
            if (i2 < arrayList.size()) {
                ArrayList<CJRAggsItem> arrayList2 = this.f63737e;
                if (arrayList2 == null) {
                    k.a();
                }
                CJRAggsItem cJRAggsItem = arrayList2.get(this.f63741i);
                k.a((Object) cJRAggsItem, "mProductTypes!![mLastSelectedPosition]");
                CJRAggsItem cJRAggsItem2 = cJRAggsItem;
                d dVar = d.f64967a;
                d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PRODUCT_TYPE_CHANGE_CONFIRM_CLICKED);
                net.one97.paytm.recharge.mobile_v3.d.a aVar = this.f63733a;
                if (aVar != null) {
                    aVar.a(cJRAggsItem2, true, this.f63739g);
                }
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63736d;
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.a();
                }
            }
        }
    }

    public final void a() {
        this.l = false;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63736d;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        if (this.l || isCancelable()) {
            super.onDismiss(dialogInterface);
            CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63736d;
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
            DialogInterface.OnDismissListener onDismissListener = this.f63735c;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
                return;
            }
            return;
        }
        if (this.f63741i == -1) {
            this.f63741i = 0;
        }
        b();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f63735c = null;
        this.f63734b = null;
        this.f63737e = null;
        this.f63738f = null;
        this.f63733a = null;
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
