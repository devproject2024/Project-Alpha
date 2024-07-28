package net.one97.paytm.vipcashback.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.Facets;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.i.f;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.view.CustomFiltersList;
import net.one97.paytm.vipcashback.view.CustomRadioGroup;
import net.one97.paytm.vipcashback.view.VoucherRadioBox;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public Integer f20920a = 0;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Facets> f20921b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<VoucherFilterItem> f20922c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> f20923d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f20924e;

    public final View a(int i2) {
        if (this.f20924e == null) {
            this.f20924e = new HashMap();
        }
        View view = (View) this.f20924e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f20924e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.filter_bottom_sheet_fragment, (ViewGroup) null, false);
    }

    public final void a(ArrayList<Facets> arrayList) {
        k.c(arrayList, "items");
        this.f20921b = arrayList;
    }

    public final void a(m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> mVar) {
        k.c(mVar, "dismissListner");
        this.f20923d = mVar;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            if (aVar != null) {
                aVar.setOnShowListener(d.f20928a);
            }
            if (aVar != null) {
                aVar.setOnShowListener(new e(this, aVar));
            }
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f20928a = new d();

        d() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                Window window = ((com.google.android.material.bottomsheet.a) dialogInterface).getWindow();
                if (window != null) {
                    window.setBackgroundDrawableResource(17170445);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20929a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f20930b;

        e(b bVar, com.google.android.material.bottomsheet.a aVar) {
            this.f20929a = bVar;
            this.f20930b = aVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            com.google.android.material.bottomsheet.a aVar = this.f20930b;
            if (aVar != null) {
                FrameLayout frameLayout = (FrameLayout) aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                ViewParent parent = frameLayout.getParent();
                if (parent != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setPeekHeight(frameLayout.getHeight());
                    ((CoordinatorLayout) parent).getParent().requestLayout();
                    TextView textView = (TextView) this.f20929a.a(R.id.resetButton);
                    Drawable drawable = null;
                    Drawable background = textView != null ? textView.getBackground() : null;
                    if (background != null) {
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        TextView textView2 = (TextView) this.f20929a.a(R.id.resetButton);
                        if (textView2 != null) {
                            FragmentActivity activity = this.f20929a.getActivity();
                            if (activity == null) {
                                k.a();
                            }
                            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.color_00b9f5));
                        }
                        FragmentActivity activity2 = this.f20929a.getActivity();
                        if (activity2 == null) {
                            k.a();
                        }
                        gradientDrawable.setColor(androidx.core.content.b.c(activity2, R.color.white));
                        FragmentActivity activity3 = this.f20929a.getActivity();
                        if (activity3 == null) {
                            k.a();
                        }
                        gradientDrawable.setStroke(3, androidx.core.content.b.c(activity3, R.color.color_00b9f5));
                        TextView textView3 = (TextView) this.f20929a.a(R.id.submitButton);
                        if (textView3 != null) {
                            drawable = textView3.getBackground();
                        }
                        if (drawable != null) {
                            GradientDrawable gradientDrawable2 = (GradientDrawable) drawable;
                            TextView textView4 = (TextView) this.f20929a.a(R.id.submitButton);
                            if (textView4 != null) {
                                FragmentActivity activity4 = this.f20929a.getActivity();
                                if (activity4 == null) {
                                    k.a();
                                }
                                textView4.setTextColor(androidx.core.content.b.c(activity4, R.color.white));
                            }
                            FragmentActivity activity5 = this.f20929a.getActivity();
                            if (activity5 == null) {
                                k.a();
                            }
                            gradientDrawable2.setColor(androidx.core.content.b.c(activity5, R.color.color_00b9f5));
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
                throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r14) {
        /*
            r13 = this;
            super.onActivityCreated(r14)
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.Facets> r14 = r13.f20921b
            if (r14 == 0) goto L_0x02b3
            java.lang.Integer r0 = r13.f20920a
            net.one97.paytm.vipcashback.d.a$b$a r1 = net.one97.paytm.vipcashback.d.a.b.f20777a
            int r1 = net.one97.paytm.vipcashback.d.a.b.f20785i
            java.lang.String r2 = "categoryHeader"
            java.lang.String r3 = "divider"
            java.lang.String r4 = "status"
            java.lang.String r5 = "filterList"
            java.lang.String r6 = "category"
            java.lang.String r7 = "statusHeader"
            r8 = 0
            r9 = 0
            r10 = 8
            if (r0 != 0) goto L_0x0023
            goto L_0x01e4
        L_0x0023:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x01e4
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r14.iterator()
        L_0x0036:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0051
            java.lang.Object r11 = r1.next()
            r12 = r11
            net.one97.paytm.common.entity.vipcashback.Facets r12 = (net.one97.paytm.common.entity.vipcashback.Facets) r12
            java.lang.String r12 = r12.getField()
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r6)
            if (r12 == 0) goto L_0x0036
            r0.add(r11)
            goto L_0x0036
        L_0x0051:
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.common.entity.vipcashback.Facets r0 = (net.one97.paytm.common.entity.vipcashback.Facets) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r14 = r14.iterator()
        L_0x0064:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r14.next()
            r12 = r11
            net.one97.paytm.common.entity.vipcashback.Facets r12 = (net.one97.paytm.common.entity.vipcashback.Facets) r12
            java.lang.String r12 = r12.getField()
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r4)
            if (r12 == 0) goto L_0x0064
            r1.add(r11)
            goto L_0x0064
        L_0x007f:
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r14 = r1.get(r8)
            net.one97.paytm.common.entity.vipcashback.Facets r14 = (net.one97.paytm.common.entity.vipcashback.Facets) r14
            if (r0 == 0) goto L_0x008e
            java.util.ArrayList r1 = r0.getItems()
            goto L_0x008f
        L_0x008e:
            r1 = r9
        L_0x008f:
            if (r14 == 0) goto L_0x0096
            java.util.ArrayList r11 = r14.getItems()
            goto L_0x0097
        L_0x0096:
            r11 = r9
        L_0x0097:
            int r12 = r1.size()
            if (r12 <= 0) goto L_0x00e0
            int r3 = net.one97.paytm.vipcashback.R.id.categoryHeader
            android.view.View r3 = r13.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getDisplayName()
            goto L_0x00b0
        L_0x00af:
            r0 = r9
        L_0x00b0:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
            int r0 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.vipcashback.view.CustomFiltersList r0 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r8)
            int r0 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            r0.setVisibility(r8)
            int r0 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.vipcashback.view.CustomFiltersList r0 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r0
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r0.a(r1)
            goto L_0x0120
        L_0x00e0:
            int r0 = net.one97.paytm.vipcashback.R.id.categoryHeader
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            if (r14 == 0) goto L_0x00f2
            java.lang.String r1 = r14.getDisplayName()
            goto L_0x00f3
        L_0x00f2:
            r1 = r9
        L_0x00f3:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.vipcashback.view.CustomFiltersList r0 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r10)
            int r0 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            r0.setVisibility(r10)
            int r0 = net.one97.paytm.vipcashback.R.id.divider
            android.view.View r0 = r13.a((int) r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r10)
        L_0x0120:
            int r0 = r11.size()
            if (r0 <= 0) goto L_0x01c6
            int r0 = net.one97.paytm.vipcashback.R.id.status
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.vipcashback.view.CustomRadioGroup r0 = (net.one97.paytm.vipcashback.view.CustomRadioGroup) r0
            java.lang.String r1 = "items"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            r0.a((java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>) r11)
            r13.f20922c = r11
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r0 = r13.f20922c
            if (r0 == 0) goto L_0x0164
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0149:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0160
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.common.entity.vipcashback.VoucherFilterItem r3 = (net.one97.paytm.common.entity.vipcashback.VoucherFilterItem) r3
            boolean r3 = r3.isSelected()
            if (r3 == 0) goto L_0x0149
            r1.add(r2)
            goto L_0x0149
        L_0x0160:
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            goto L_0x0165
        L_0x0164:
            r0 = r9
        L_0x0165:
            if (r0 == 0) goto L_0x016c
            int r1 = r0.size()
            goto L_0x016d
        L_0x016c:
            r1 = 0
        L_0x016d:
            if (r1 <= 0) goto L_0x01a0
            int r1 = net.one97.paytm.vipcashback.R.id.status
            android.view.View r1 = r13.a((int) r1)
            net.one97.paytm.vipcashback.view.CustomRadioGroup r1 = (net.one97.paytm.vipcashback.view.CustomRadioGroup) r1
            if (r1 == 0) goto L_0x01ae
            if (r0 == 0) goto L_0x0192
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.common.entity.vipcashback.VoucherFilterItem r0 = (net.one97.paytm.common.entity.vipcashback.VoucherFilterItem) r0
            if (r0 == 0) goto L_0x0192
            java.lang.String r0 = r0.getId()
            if (r0 == 0) goto L_0x0192
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0193
        L_0x0192:
            r0 = r9
        L_0x0193:
            if (r0 != 0) goto L_0x0198
            kotlin.g.b.k.a()
        L_0x0198:
            int r0 = r0.intValue()
            r1.a((int) r0)
            goto L_0x01ae
        L_0x01a0:
            int r0 = net.one97.paytm.vipcashback.R.id.status
            android.view.View r0 = r13.a((int) r0)
            net.one97.paytm.vipcashback.view.CustomRadioGroup r0 = (net.one97.paytm.vipcashback.view.CustomRadioGroup) r0
            if (r0 == 0) goto L_0x01ae
            r1 = 1
            r0.a((int) r1)
        L_0x01ae:
            int r0 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            if (r14 == 0) goto L_0x01bf
            java.lang.String r9 = r14.getDisplayName()
        L_0x01bf:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            goto L_0x02b3
        L_0x01c6:
            int r14 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.status
            android.view.View r14 = r13.a((int) r14)
            net.one97.paytm.vipcashback.view.CustomRadioGroup r14 = (net.one97.paytm.vipcashback.view.CustomRadioGroup) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r10)
            goto L_0x02b3
        L_0x01e4:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r14 = r14.iterator()
        L_0x01f1:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x020c
            java.lang.Object r1 = r14.next()
            r11 = r1
            net.one97.paytm.common.entity.vipcashback.Facets r11 = (net.one97.paytm.common.entity.vipcashback.Facets) r11
            java.lang.String r11 = r11.getField()
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r6)
            if (r11 == 0) goto L_0x01f1
            r0.add(r1)
            goto L_0x01f1
        L_0x020c:
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r14 = r0.get(r8)
            net.one97.paytm.common.entity.vipcashback.Facets r14 = (net.one97.paytm.common.entity.vipcashback.Facets) r14
            if (r14 == 0) goto L_0x021b
            java.util.ArrayList r0 = r14.getItems()
            goto L_0x021c
        L_0x021b:
            r0 = r9
        L_0x021c:
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x026f
            int r1 = net.one97.paytm.vipcashback.R.id.categoryHeader
            android.view.View r1 = r13.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            if (r14 == 0) goto L_0x0233
            java.lang.String r9 = r14.getDisplayName()
        L_0x0233:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
            int r14 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r14 = r13.a((int) r14)
            net.one97.paytm.vipcashback.view.CustomFiltersList r14 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.vipcashback.R.id.divider
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r14 = r13.a((int) r14)
            net.one97.paytm.vipcashback.view.CustomFiltersList r14 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r14
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r14.a(r0)
            goto L_0x02b3
        L_0x026f:
            int r14 = net.one97.paytm.vipcashback.R.id.filterList
            android.view.View r14 = r13.a((int) r14)
            net.one97.paytm.vipcashback.view.CustomFiltersList r14 = (net.one97.paytm.vipcashback.view.CustomFiltersList) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.divider
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.statusHeader
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r14.setVisibility(r10)
            int r14 = net.one97.paytm.vipcashback.R.id.status
            android.view.View r14 = r13.a((int) r14)
            net.one97.paytm.vipcashback.view.CustomRadioGroup r14 = (net.one97.paytm.vipcashback.view.CustomRadioGroup) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r10)
        L_0x02b3:
            int r14 = net.one97.paytm.vipcashback.R.id.close
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            net.one97.paytm.vipcashback.fragment.b$a r0 = new net.one97.paytm.vipcashback.fragment.b$a
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
            int r14 = net.one97.paytm.vipcashback.R.id.resetButton
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02d9
            net.one97.paytm.vipcashback.fragment.b$b r0 = new net.one97.paytm.vipcashback.fragment.b$b
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
        L_0x02d9:
            int r14 = net.one97.paytm.vipcashback.R.id.submitButton
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            net.one97.paytm.vipcashback.fragment.b$c r0 = new net.one97.paytm.vipcashback.fragment.b$c
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.b.onActivityCreated(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20925a;

        a(b bVar) {
            this.f20925a = bVar;
        }

        public final void onClick(View view) {
            this.f20925a.dismissAllowingStateLoss();
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.fragment.b$b  reason: collision with other inner class name */
    static final class C0403b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20926a;

        C0403b(b bVar) {
            this.f20926a = bVar;
        }

        public final void onClick(View view) {
            Integer a2 = this.f20926a.f20920a;
            a.b.C0384a aVar = a.b.f20777a;
            int h2 = a.b.f20785i;
            if (a2 != null && a2.intValue() == h2) {
                ((CustomFiltersList) this.f20926a.a(R.id.filterList)).a();
                m b2 = this.f20926a.f20923d;
                if (b2 != null) {
                    b2.invoke(((CustomFiltersList) this.f20926a.a(R.id.filterList)).getSelectedFilter(), 1);
                }
                this.f20926a.dismissAllowingStateLoss();
                return;
            }
            ((CustomFiltersList) this.f20926a.a(R.id.filterList)).a();
            m b3 = this.f20926a.f20923d;
            if (b3 != null) {
                b3.invoke(((CustomFiltersList) this.f20926a.a(R.id.filterList)).getSelectedFilter(), -1);
            }
            this.f20926a.dismissAllowingStateLoss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20927a;

        c(b bVar) {
            this.f20927a = bVar;
        }

        public final void onClick(View view) {
            Integer a2 = this.f20927a.f20920a;
            a.b.C0384a aVar = a.b.f20777a;
            int h2 = a.b.f20785i;
            if (a2 != null && a2.intValue() == h2) {
                m b2 = this.f20927a.f20923d;
                if (b2 != null) {
                    ArrayList<VoucherFilterItem> selectedFilter = ((CustomFiltersList) this.f20927a.a(R.id.filterList)).getSelectedFilter();
                    CustomRadioGroup customRadioGroup = (CustomRadioGroup) this.f20927a.a(R.id.status);
                    View findViewById = customRadioGroup.findViewById(customRadioGroup.f21032a);
                    k.a((Object) findViewById, "findViewById<VoucherRadioBox>(selectedChildId)");
                    Object tag = ((VoucherRadioBox) findViewById).getTag();
                    if (tag != null) {
                        ((VoucherFilterItem) tag).setSelected(true);
                        b2.invoke(selectedFilter, Integer.valueOf(customRadioGroup.f21032a));
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.VoucherFilterItem");
                    }
                }
            } else {
                m b3 = this.f20927a.f20923d;
                if (b3 != null) {
                    b3.invoke(((CustomFiltersList) this.f20927a.a(R.id.filterList)).getSelectedFilter(), -1);
                }
            }
            this.f20927a.dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20924e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
