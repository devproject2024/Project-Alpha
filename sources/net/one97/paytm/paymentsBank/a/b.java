package net.one97.paytm.paymentsBank.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.widget.CirclePagerIndicatorDecoration;

public final class b extends RecyclerView.a<RecyclerView.v> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f17287a;

    /* renamed from: b  reason: collision with root package name */
    public int f17288b;

    /* renamed from: c  reason: collision with root package name */
    public CirclePagerIndicatorDecoration f17289c;

    /* renamed from: d  reason: collision with root package name */
    private a f17290d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17291e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeMap<Integer, List<Integer>> f17292f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f17293g;

    /* renamed from: h  reason: collision with root package name */
    private Context f17294h;

    public interface a {
        void a(int i2);
    }

    private b(Context context, a aVar) {
        k.c(context, "mContext");
        k.c(aVar, "itemSelectListner");
        this.f17294h = context;
        this.f17287a = new ArrayList<>();
        this.f17290d = aVar;
        this.f17292f = new TreeMap<>();
        net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        this.f17287a = net.one97.paytm.paymentsBank.utils.a.j();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(Context context, a aVar, ViewGroup viewGroup) {
        this(context, aVar);
        k.c(context, "context");
        k.c(aVar, "itemSelectListner");
        k.c(viewGroup, "indicaterLayout");
        this.f17294h = context;
        this.f17290d = aVar;
        this.f17293g = viewGroup;
        ArrayList<Integer> arrayList = this.f17287a;
        if (arrayList != null && (!arrayList.isEmpty())) {
            this.f17292f.clear();
            int i2 = 0;
            int i3 = 0;
            while (i2 < arrayList.size()) {
                int i4 = i2 + 4;
                ArrayList arrayList2 = new ArrayList();
                while (i2 < arrayList.size() && i2 < i4) {
                    arrayList2.add(arrayList.get(i2));
                    i2++;
                }
                Integer valueOf = Integer.valueOf(i3);
                i3++;
                this.f17292f.put(valueOf, arrayList2);
                i2 = i4;
            }
        }
        this.f17288b = this.f17292f.size();
        if (this.f17288b == 1) {
            this.f17288b = 0;
        }
        this.f17289c = new CirclePagerIndicatorDecoration(this.f17294h, this.f17288b);
        ViewGroup viewGroup2 = this.f17293g;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        ViewGroup viewGroup3 = this.f17293g;
        if (viewGroup3 != null) {
            viewGroup3.addView(this.f17289c);
        }
    }

    public final int getItemCount() {
        return this.f17292f.size();
    }

    public final void onClick(View view) {
        a aVar = this.f17290d;
        if (aVar != null) {
            Object tag = view != null ? view.getTag() : null;
            if (tag != null) {
                aVar.a(((Integer) tag).intValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        List list = this.f17292f.get(Integer.valueOf(i2));
        if (list == null) {
            k.a();
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            int i3 = 0;
            for (Object next : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.k.a();
                }
                int intValue = ((Number) next).intValue();
                if (vVar instanceof C0261b) {
                    if (intValue == 10) {
                        C0261b bVar = (C0261b) vVar;
                        View view = bVar.f17295a[i3];
                        if (view == null) {
                            k.a();
                        }
                        view.setVisibility(0);
                        TextView textView = bVar.f17296b[i3];
                        if (textView == null) {
                            k.a();
                        }
                        textView.setText(R.string.linked_fd_acc);
                        ImageView imageView = bVar.f17297c[i3];
                        if (imageView == null) {
                            k.a();
                        }
                        imageView.setImageResource(R.drawable.pb_top_ic_fixed_deposit_icon);
                        ViewGroup viewGroup = bVar.f17298d[i3];
                        if (viewGroup == null) {
                            k.a();
                        }
                        viewGroup.setVisibility(4);
                    } else if (intValue != 10000) {
                        switch (intValue) {
                            case 1:
                                C0261b bVar2 = (C0261b) vVar;
                                View view2 = bVar2.f17295a[i3];
                                if (view2 == null) {
                                    k.a();
                                }
                                view2.setVisibility(0);
                                TextView textView2 = bVar2.f17296b[i3];
                                if (textView2 == null) {
                                    k.a();
                                }
                                textView2.setText(R.string.top_menu_pay);
                                ImageView imageView2 = bVar2.f17297c[i3];
                                if (imageView2 == null) {
                                    k.a();
                                }
                                imageView2.setImageResource(R.drawable.pb_top_bar_pay_icon);
                                ViewGroup viewGroup2 = bVar2.f17298d[i3];
                                if (viewGroup2 == null) {
                                    k.a();
                                }
                                viewGroup2.setVisibility(4);
                                break;
                            case 2:
                                C0261b bVar3 = (C0261b) vVar;
                                View view3 = bVar3.f17295a[i3];
                                if (view3 == null) {
                                    k.a();
                                }
                                view3.setVisibility(0);
                                TextView textView3 = bVar3.f17296b[i3];
                                if (textView3 == null) {
                                    k.a();
                                }
                                textView3.setText(R.string.money_transfer);
                                ImageView imageView3 = bVar3.f17297c[i3];
                                if (imageView3 == null) {
                                    k.a();
                                }
                                imageView3.setImageResource(R.drawable.money_transfer_home_icon_new);
                                ViewGroup viewGroup3 = bVar3.f17298d[i3];
                                if (viewGroup3 == null) {
                                    k.a();
                                }
                                viewGroup3.setVisibility(4);
                                break;
                            case 3:
                                C0261b bVar4 = (C0261b) vVar;
                                View view4 = bVar4.f17295a[i3];
                                if (view4 == null) {
                                    k.a();
                                }
                                view4.setVisibility(0);
                                TextView textView4 = bVar4.f17296b[i3];
                                if (textView4 == null) {
                                    k.a();
                                }
                                textView4.setText(R.string.add_money);
                                ImageView imageView4 = bVar4.f17297c[i3];
                                if (imageView4 == null) {
                                    k.a();
                                }
                                imageView4.setImageResource(R.drawable.pb_top_bar_add_money_icon);
                                ViewGroup viewGroup4 = bVar4.f17298d[i3];
                                if (viewGroup4 == null) {
                                    k.a();
                                }
                                viewGroup4.setVisibility(4);
                                break;
                            case 4:
                                C0261b bVar5 = (C0261b) vVar;
                                View view5 = bVar5.f17295a[i3];
                                if (view5 == null) {
                                    k.a();
                                }
                                view5.setVisibility(0);
                                TextView textView5 = bVar5.f17296b[i3];
                                if (textView5 == null) {
                                    k.a();
                                }
                                textView5.setText(R.string.upi);
                                ImageView imageView5 = bVar5.f17297c[i3];
                                if (imageView5 == null) {
                                    k.a();
                                }
                                imageView5.setImageResource(R.drawable.pb_bhim_upi);
                                ViewGroup viewGroup5 = bVar5.f17298d[i3];
                                if (viewGroup5 == null) {
                                    k.a();
                                }
                                viewGroup5.setVisibility(4);
                                break;
                            case 5:
                                C0261b bVar6 = (C0261b) vVar;
                                View view6 = bVar6.f17295a[i3];
                                if (view6 == null) {
                                    k.a();
                                }
                                view6.setVisibility(0);
                                TextView textView6 = bVar6.f17296b[i3];
                                if (textView6 == null) {
                                    k.a();
                                }
                                textView6.setText(R.string.passbook);
                                ImageView imageView6 = bVar6.f17297c[i3];
                                if (imageView6 == null) {
                                    k.a();
                                }
                                imageView6.setImageResource(R.drawable.pb_passbook_bank);
                                ViewGroup viewGroup6 = bVar6.f17298d[i3];
                                if (viewGroup6 == null) {
                                    k.a();
                                }
                                viewGroup6.setVisibility(4);
                                break;
                            case 6:
                                if (this.f17291e) {
                                    C0261b bVar7 = (C0261b) vVar;
                                    View view7 = bVar7.f17295a[i3];
                                    if (view7 == null) {
                                        k.a();
                                    }
                                    view7.setVisibility(0);
                                    TextView textView7 = bVar7.f17296b[i3];
                                    if (textView7 == null) {
                                        k.a();
                                    }
                                    textView7.setText(R.string.pb_nach_payment_request);
                                    ImageView imageView7 = bVar7.f17297c[i3];
                                    if (imageView7 == null) {
                                        k.a();
                                    }
                                    imageView7.setImageResource(R.drawable.pb_ic_pending_req_svg);
                                    k.a((Object) g.a(), "GTMLoader.getInstance(mContext)");
                                    if (!d.v()) {
                                        ViewGroup viewGroup7 = bVar7.f17298d[i3];
                                        if (viewGroup7 == null) {
                                            k.a();
                                        }
                                        viewGroup7.setVisibility(4);
                                        break;
                                    } else {
                                        ViewGroup viewGroup8 = bVar7.f17298d[i3];
                                        if (viewGroup8 == null) {
                                            k.a();
                                        }
                                        viewGroup8.setVisibility(0);
                                        break;
                                    }
                                } else {
                                    return;
                                }
                            case 7:
                                C0261b bVar8 = (C0261b) vVar;
                                View view8 = bVar8.f17295a[i3];
                                if (view8 == null) {
                                    k.a();
                                }
                                view8.setVisibility(0);
                                TextView textView8 = bVar8.f17296b[i3];
                                if (textView8 == null) {
                                    k.a();
                                }
                                textView8.setText(R.string.si_recur_payment);
                                ImageView imageView8 = bVar8.f17297c[i3];
                                if (imageView8 == null) {
                                    k.a();
                                }
                                imageView8.setImageDrawable(androidx.core.content.b.a(this.f17294h, R.drawable.pb_recurring_top_bar_icon));
                                ViewGroup viewGroup9 = bVar8.f17298d[i3];
                                if (viewGroup9 == null) {
                                    k.a();
                                }
                                viewGroup9.setVisibility(4);
                                break;
                        }
                    } else {
                        C0261b bVar9 = (C0261b) vVar;
                        View view9 = bVar9.f17295a[i3];
                        if (view9 == null) {
                            k.a();
                        }
                        view9.setVisibility(0);
                        TextView textView9 = bVar9.f17296b[i3];
                        if (textView9 == null) {
                            k.a();
                        }
                        textView9.setText(R.string.pb_withdraw_cash);
                        ImageView imageView9 = bVar9.f17297c[i3];
                        if (imageView9 == null) {
                            k.a();
                        }
                        imageView9.setImageResource(R.drawable.pb_ic_withdraw_cash);
                        ViewGroup viewGroup10 = bVar9.f17298d[i3];
                        if (viewGroup10 == null) {
                            k.a();
                        }
                        viewGroup10.setVisibility(4);
                    }
                    C0261b bVar10 = (C0261b) vVar;
                    View view10 = bVar10.f17295a[i3];
                    if (view10 != null && view10.getVisibility() == 0) {
                        View view11 = bVar10.f17295a[i3];
                        if (view11 != null) {
                            view11.setTag(Integer.valueOf(intValue));
                        }
                        View view12 = bVar10.f17295a[i3];
                        if (view12 != null) {
                            view12.setOnClickListener(this);
                        }
                    }
                }
                i3 = i4;
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17294h).inflate(R.layout.bank_strip_recycler_row, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…ycler_row, parent, false)");
        return new C0261b(this, inflate);
    }

    /* renamed from: net.one97.paytm.paymentsBank.a.b$b  reason: collision with other inner class name */
    public final class C0261b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        View[] f17295a = new View[4];

        /* renamed from: b  reason: collision with root package name */
        TextView[] f17296b = new TextView[4];

        /* renamed from: c  reason: collision with root package name */
        ImageView[] f17297c = new ImageView[4];

        /* renamed from: d  reason: collision with root package name */
        ViewGroup[] f17298d = new ViewGroup[4];

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f17299e;

        /* JADX WARNING: type inference failed for: r3v11, types: [android.view.View] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0261b(net.one97.paytm.paymentsBank.a.b r7, android.view.View r8) {
            /*
                r6 = this;
                java.lang.String r0 = "view"
                kotlin.g.b.k.c(r8, r0)
                r6.f17299e = r7
                r6.<init>(r8)
                r7 = 4
                android.view.View[] r0 = new android.view.View[r7]
                r6.f17295a = r0
                android.widget.TextView[] r0 = new android.widget.TextView[r7]
                r6.f17296b = r0
                android.widget.ImageView[] r0 = new android.widget.ImageView[r7]
                r6.f17297c = r0
                android.view.ViewGroup[] r7 = new android.view.ViewGroup[r7]
                r6.f17298d = r7
                int r7 = net.one97.paytm.paymentsBank.R.id.controller_layout
                android.view.View r7 = r8.findViewById(r7)
                android.view.ViewGroup r7 = (android.view.ViewGroup) r7
                java.lang.String r0 = "controllerLayout"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                int r0 = r7.getChildCount()
                r1 = 0
            L_0x002d:
                if (r1 >= r0) goto L_0x0083
                android.view.View[] r2 = r6.f17295a
                android.view.View r3 = r7.getChildAt(r1)
                java.lang.String r4 = "controllerLayout.getChildAt(i)"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                int r3 = r3.getId()
                android.view.View r3 = r8.findViewById(r3)
                r2[r1] = r3
                android.widget.TextView[] r2 = r6.f17296b
                android.view.View[] r3 = r6.f17295a
                r3 = r3[r1]
                r4 = 0
                if (r3 == 0) goto L_0x0056
                int r5 = net.one97.paytm.paymentsBank.R.id.item_name
                android.view.View r3 = r3.findViewById(r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                goto L_0x0057
            L_0x0056:
                r3 = r4
            L_0x0057:
                r2[r1] = r3
                android.widget.ImageView[] r2 = r6.f17297c
                android.view.View[] r3 = r6.f17295a
                r3 = r3[r1]
                if (r3 == 0) goto L_0x006a
                int r5 = net.one97.paytm.paymentsBank.R.id.item_image
                android.view.View r3 = r3.findViewById(r5)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                goto L_0x006b
            L_0x006a:
                r3 = r4
            L_0x006b:
                r2[r1] = r3
                android.view.ViewGroup[] r2 = r6.f17298d
                android.view.View[] r3 = r6.f17295a
                r3 = r3[r1]
                if (r3 == 0) goto L_0x007e
                int r4 = net.one97.paytm.paymentsBank.R.id.newIconLayout
                android.view.View r3 = r3.findViewById(r4)
                r4 = r3
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            L_0x007e:
                r2[r1] = r4
                int r1 = r1 + 1
                goto L_0x002d
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.a.b.C0261b.<init>(net.one97.paytm.paymentsBank.a.b, android.view.View):void");
        }
    }
}
