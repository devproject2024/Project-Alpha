package net.one97.paytm.recharge.metro.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.model.metro.CJRMetroRefundDescriptionModel;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f63142a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRMetroRefundDescriptionModel.CJRAmountDescription> f63143b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        TextView textView = aVar.f63144a;
        String label = this.f63143b.get(i2).getLabel();
        k.a((Object) label, "messages.get(position).label");
        textView.setText(a(label));
        aVar.f63145b.setText(String.valueOf(this.f63143b.get(i2).getAmount().doubleValue()));
        if (i2 == getItemCount() - 1) {
            aVar.f63146c.setVisibility(8);
            aVar.f63144a.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f63142a).inflate(R.layout.layout_qr_cancel_list_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…list_item, parent, false)");
        return new a(inflate);
    }

    public b(Context context, List<? extends CJRMetroRefundDescriptionModel.CJRAmountDescription> list) {
        k.c(context, "context");
        k.c(list, StringSet.messages);
        this.f63142a = context;
        this.f63143b = list;
    }

    public final int getItemCount() {
        return this.f63143b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63144a;

        /* renamed from: b  reason: collision with root package name */
        final CJRAmountView f63145b;

        /* renamed from: c  reason: collision with root package name */
        final View f63146c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.label);
            if (findViewById != null) {
                this.f63144a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.amount);
                if (findViewById2 != null) {
                    this.f63145b = (CJRAmountView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.divider);
                    if (findViewById3 != null) {
                        this.f63146c = findViewById3;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CJRAmountView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c9 A[Catch:{ Exception -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r8) {
        /*
            java.lang.String r0 = " "
            java.lang.String r1 = "_"
            r2 = 0
            java.lang.String r8 = kotlin.m.p.a(r8, r1, r0, r2)     // Catch:{ Exception -> 0x00d1 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00d1 }
            kotlin.m.l r1 = new kotlin.m.l     // Catch:{ Exception -> 0x00d1 }
            r1.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x00d1 }
            java.util.List r8 = r1.split(r8, r2)     // Catch:{ Exception -> 0x00d1 }
            boolean r1 = r8.isEmpty()     // Catch:{ Exception -> 0x00d1 }
            r3 = 1
            if (r1 != 0) goto L_0x0048
            int r1 = r8.size()     // Catch:{ Exception -> 0x00d1 }
            java.util.ListIterator r1 = r8.listIterator(r1)     // Catch:{ Exception -> 0x00d1 }
        L_0x0023:
            boolean r4 = r1.hasPrevious()     // Catch:{ Exception -> 0x00d1 }
            if (r4 == 0) goto L_0x0048
            java.lang.Object r4 = r1.previous()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00d1 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00d1 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x00d1 }
            if (r4 != 0) goto L_0x0039
            r4 = 1
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            if (r4 != 0) goto L_0x0023
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x00d1 }
            int r1 = r1.nextIndex()     // Catch:{ Exception -> 0x00d1 }
            int r1 = r1 + r3
            java.util.List r8 = kotlin.a.k.b(r8, (int) r1)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x004c
        L_0x0048:
            kotlin.a.w r8 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x00d1 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x00d1 }
        L_0x004c:
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ Exception -> 0x00d1 }
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00d1 }
            java.lang.Object[] r8 = r8.toArray(r1)     // Catch:{ Exception -> 0x00d1 }
            if (r8 == 0) goto L_0x00c9
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ Exception -> 0x00d1 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00d1 }
            r1.<init>()     // Catch:{ Exception -> 0x00d1 }
            int r4 = r8.length     // Catch:{ Exception -> 0x00d1 }
            r5 = 0
        L_0x005f:
            if (r5 >= r4) goto L_0x008c
            r6 = r8[r5]     // Catch:{ Exception -> 0x00d1 }
            char r6 = r6.charAt(r2)     // Catch:{ Exception -> 0x00d1 }
            char r6 = java.lang.Character.toUpperCase(r6)     // Catch:{ Exception -> 0x00d1 }
            r1.append(r6)     // Catch:{ Exception -> 0x00d1 }
            r6 = r8[r5]     // Catch:{ Exception -> 0x00d1 }
            if (r6 == 0) goto L_0x0084
            java.lang.String r6 = r6.substring(r3)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x00d1 }
            r1.append(r6)     // Catch:{ Exception -> 0x00d1 }
            r1.append(r0)     // Catch:{ Exception -> 0x00d1 }
            int r5 = r5 + 1
            goto L_0x005f
        L_0x0084:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r0)     // Catch:{ Exception -> 0x00d1 }
            throw r8     // Catch:{ Exception -> 0x00d1 }
        L_0x008c:
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r0 = "sb.toString()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d1 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00d1 }
            int r0 = r8.length()     // Catch:{ Exception -> 0x00d1 }
            int r0 = r0 - r3
            r1 = r0
            r0 = 0
            r4 = 0
        L_0x009f:
            if (r0 > r1) goto L_0x00bf
            if (r4 != 0) goto L_0x00a5
            r5 = r0
            goto L_0x00a6
        L_0x00a5:
            r5 = r1
        L_0x00a6:
            char r5 = r8.charAt(r5)     // Catch:{ Exception -> 0x00d1 }
            r6 = 32
            if (r5 > r6) goto L_0x00b0
            r5 = 1
            goto L_0x00b1
        L_0x00b0:
            r5 = 0
        L_0x00b1:
            if (r4 != 0) goto L_0x00ba
            if (r5 != 0) goto L_0x00b7
            r4 = 1
            goto L_0x009f
        L_0x00b7:
            int r0 = r0 + 1
            goto L_0x009f
        L_0x00ba:
            if (r5 == 0) goto L_0x00bf
            int r1 = r1 + -1
            goto L_0x009f
        L_0x00bf:
            int r1 = r1 + r3
            java.lang.CharSequence r8 = r8.subSequence(r0, r1)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00d1 }
            return r8
        L_0x00c9:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r0)     // Catch:{ Exception -> 0x00d1 }
            throw r8     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            r8 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r0.debugLogExceptions(r8)
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.a.b.a(java.lang.String):java.lang.String");
    }
}
