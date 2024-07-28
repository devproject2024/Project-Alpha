package net.one97.paytm.paymentsBank.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.paymentsBank.R;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    final d f19584a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Integer> f19585b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private PriorityQueue<Integer> f19586c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f19587d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f19588e;

    public r(Context context, ViewGroup viewGroup, d dVar) {
        k.c(context, "context");
        k.c(viewGroup, "parentLayout");
        k.c(dVar, "listener");
        this.f19587d = context;
        this.f19588e = viewGroup;
        this.f19584a = dVar;
        this.f19585b.add(3);
        this.f19585b.add(2);
        this.f19585b.add(1);
        this.f19586c = new PriorityQueue<>(this.f19585b.size(), Collections.reverseOrder());
    }

    public final void a(int i2) {
        if (this.f19588e.getChildCount() != 0) {
            View findViewById = this.f19588e.findViewById(R.id.rl_parent_container);
            k.a((Object) findViewById, "parentLayout.findViewByI…R.id.rl_parent_container)");
            Object tag = ((ViewGroup) findViewById).getTag();
            if (tag == null) {
                throw new u("null cannot be cast to non-null type kotlin.Int");
            } else if (((Integer) tag).intValue() == i2) {
                this.f19588e.removeAllViews();
                a();
            }
        }
    }

    private final void c(int i2) {
        PriorityQueue<Integer> priorityQueue = this.f19586c;
        if (priorityQueue == null) {
            k.a("currentDisplayQueue");
        }
        if (!priorityQueue.contains(Integer.valueOf(i2))) {
            PriorityQueue<Integer> priorityQueue2 = this.f19586c;
            if (priorityQueue2 == null) {
                k.a("currentDisplayQueue");
            }
            priorityQueue2.add(Integer.valueOf(i2));
        }
    }

    public final void b(int i2) {
        c(i2);
        a();
    }

    private final void a() {
        PriorityQueue<Integer> priorityQueue = this.f19586c;
        if (priorityQueue == null) {
            k.a("currentDisplayQueue");
        }
        Integer peek = priorityQueue.peek();
        if (this.f19588e.getChildCount() == 0) {
            a(this.f19587d, peek);
            PriorityQueue<Integer> priorityQueue2 = this.f19586c;
            if (priorityQueue2 == null) {
                k.a("currentDisplayQueue");
            }
            priorityQueue2.poll();
            return;
        }
        View findViewById = this.f19588e.findViewById(R.id.rl_parent_container);
        k.a((Object) findViewById, "parentLayout.findViewByI…R.id.rl_parent_container)");
        Object tag = ((ViewGroup) findViewById).getTag();
        if (tag != null) {
            int intValue = ((Integer) tag).intValue();
            if (peek == null || intValue != peek.intValue()) {
                k.a((Object) peek, "currentDisplayType");
                if (k.a(intValue, peek.intValue()) < 0) {
                    a(this.f19587d, peek);
                    PriorityQueue<Integer> priorityQueue3 = this.f19586c;
                    if (priorityQueue3 == null) {
                        k.a("currentDisplayQueue");
                    }
                    priorityQueue3.poll();
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Int");
    }

    private final void a(Context context, Integer num) {
        if (num != null) {
            if (num.intValue() == 1) {
                String string = context.getString(R.string.pb_bank_kyc_title);
                k.a((Object) string, "context.getString(R.string.pb_bank_kyc_title)");
                a(string, num.intValue());
            } else if (num.intValue() == 2) {
                String string2 = context.getString(R.string.pb_bank_add_nominee);
                k.a((Object) string2, "context.getString(R.string.pb_bank_add_nominee)");
                a(string2, num.intValue());
            } else if (num.intValue() == 3) {
                String string3 = context.getString(R.string.pb_dbt_yellow_strip_title);
                k.a((Object) string3, "context.getString(R.stri…b_dbt_yellow_strip_title)");
                a(string3, num.intValue());
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            android.view.ViewGroup r0 = r4.f19588e
            int r0 = r0.getChildCount()
            if (r0 != 0) goto L_0x0039
            android.content.Context r0 = r4.f19587d
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r1)
            if (r0 == 0) goto L_0x0031
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            int r1 = net.one97.paytm.paymentsBank.R.layout.bank_kyc_banner_layout
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = net.one97.paytm.paymentsBank.R.id.txt_horizontal_links_title
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.paymentsBank.R.id.rl_parent_container
            android.view.View r2 = r0.findViewById(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.ViewGroup r3 = r4.f19588e
            r3.addView(r0)
            goto L_0x004f
        L_0x0031:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type android.view.LayoutInflater"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            android.view.ViewGroup r0 = r4.f19588e
            int r1 = net.one97.paytm.paymentsBank.R.id.txt_horizontal_links_title
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.view.ViewGroup r0 = r4.f19588e
            int r2 = net.one97.paytm.paymentsBank.R.id.rl_parent_container
            android.view.View r0 = r0.findViewById(r2)
            r2 = r0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x004f:
            if (r1 == 0) goto L_0x0056
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x0056:
            if (r2 == 0) goto L_0x0062
            net.one97.paytm.paymentsBank.utils.r$a r5 = new net.one97.paytm.paymentsBank.utils.r$a
            r5.<init>(r4, r6)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r2.setOnClickListener(r5)
        L_0x0062:
            if (r2 == 0) goto L_0x006b
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r2.setTag(r5)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.utils.r.a(java.lang.String, int):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f19589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19590b;

        a(r rVar, int i2) {
            this.f19589a = rVar;
            this.f19590b = i2;
        }

        public final void onClick(View view) {
            this.f19589a.f19584a.onFragmentAction(this.f19590b, (Object) null);
        }
    }
}
