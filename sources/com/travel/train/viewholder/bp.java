package com.travel.train.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ae;

public final class bp {

    /* renamed from: com.travel.train.viewholder.bp$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28050a = new int[ae.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.travel.train.i.ae[] r0 = com.travel.train.i.ae.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28050a = r0
                int[] r0 = f28050a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.i.ae r1 = com.travel.train.i.ae.CANCELLATION_TYPE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f28050a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.i.ae r1 = com.travel.train.i.ae.ENTRY_TYPE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f28050a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.i.ae r1 = com.travel.train.i.ae.HEADER_TYPE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f28050a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.train.i.ae r1 = com.travel.train.i.ae.INS_TYPE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.viewholder.bp.AnonymousClass1.<clinit>():void");
        }
    }

    public static RecyclerView.v a(ViewGroup viewGroup, ae aeVar) {
        int i2 = AnonymousClass1.f28050a[aeVar.ordinal()];
        if (i2 == 1) {
            return new am(b(viewGroup, aeVar));
        }
        if (i2 == 2) {
            return new aj(b(viewGroup, aeVar));
        }
        if (i2 == 3) {
            return new ak(b(viewGroup, aeVar));
        }
        if (i2 != 4) {
            return new aj(b(viewGroup, aeVar));
        }
        return new al(b(viewGroup, aeVar));
    }

    private static View b(ViewGroup viewGroup, ae aeVar) {
        int i2 = AnonymousClass1.f28050a[aeVar.ordinal()];
        if (i2 == 1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cancellation_main_layout, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cancellation_entry_item_layout, viewGroup, false);
        }
        if (i2 == 3) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cancellation_header_item_layout, viewGroup, false);
        }
        if (i2 != 4) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cancellation_entry_item_layout, viewGroup, false);
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cancellation_ins_item_layout, viewGroup, false);
    }
}
