package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRPNRPAXInformation;
import com.travel.train.model.trainticket.CJRPNRStatusDetails;
import com.travel.train.model.trainticket.CJRPNRStatusMeta;
import com.travel.train.viewholder.ab;
import com.travel.train.viewholder.ac;
import com.travel.train.viewholder.r;
import java.util.ArrayList;

public final class k extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private String f26453a = "CNF";

    /* renamed from: b  reason: collision with root package name */
    private String f26454b = "CAN";

    /* renamed from: c  reason: collision with root package name */
    private String f26455c = "NOSB";

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRPNRPAXInformation> f26456d;

    /* renamed from: e  reason: collision with root package name */
    private Context f26457e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f26458f;

    /* renamed from: g  reason: collision with root package name */
    private CJRPNRStatusMeta f26459g;

    /* renamed from: h  reason: collision with root package name */
    private CJRPNRStatusDetails f26460h;

    enum a {
        CONFIRM_TICKET,
        WAITING_RAC_TICKET,
        CANCELLED_TICKET
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public k(Context context, CJRPNRStatusDetails cJRPNRStatusDetails, CJRPNRStatusMeta cJRPNRStatusMeta) {
        this.f26457e = context;
        this.f26460h = cJRPNRStatusDetails;
        this.f26456d = this.f26460h.getmPAXInfoList();
        this.f26458f = LayoutInflater.from(context);
        this.f26459g = cJRPNRStatusMeta;
    }

    public final int getCount() {
        return this.f26456d.size();
    }

    public final Object getItem(int i2) {
        return this.f26456d.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        CJRPNRPAXInformation cJRPNRPAXInformation = this.f26456d.get(i2);
        if (cJRPNRPAXInformation != null) {
            if (!TextUtils.isEmpty(cJRPNRPAXInformation.getmCurrentStatus()) && !TextUtils.isEmpty(cJRPNRPAXInformation.getmBookingStatus())) {
                if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26453a) && cJRPNRPAXInformation.getmBookingStatus().equalsIgnoreCase(this.f26453a)) {
                    bVar = a(viewGroup, a.CONFIRM_TICKET);
                    bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                } else if (!cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(cJRPNRPAXInformation.getmBookingStatus())) {
                    if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26453a)) {
                        bVar = a(viewGroup, a.CONFIRM_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    } else if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26454b)) {
                        bVar = a(viewGroup, a.CANCELLED_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    } else {
                        bVar = a(viewGroup, a.WAITING_RAC_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    }
                } else if (!cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26455c) || !cJRPNRPAXInformation.getmBookingStatus().equalsIgnoreCase(this.f26455c)) {
                    if (!cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(cJRPNRPAXInformation.getmBookingStatus())) {
                        bVar = a(viewGroup, a.WAITING_RAC_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    } else if (!cJRPNRPAXInformation.getmCurrentBerthNo().equalsIgnoreCase("0") || !cJRPNRPAXInformation.getmCurrentCoachId().isEmpty()) {
                        if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26453a) || cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26455c)) {
                            bVar = a(viewGroup, a.CONFIRM_TICKET);
                            bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                        } else if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26454b)) {
                            bVar = a(viewGroup, a.CANCELLED_TICKET);
                            bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                        } else {
                            bVar = a(viewGroup, a.WAITING_RAC_TICKET);
                            bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                        }
                    } else if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26453a) || cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26455c)) {
                        bVar = a(viewGroup, a.CONFIRM_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    } else if (cJRPNRPAXInformation.getmCurrentStatus().equalsIgnoreCase(this.f26454b)) {
                        bVar = a(viewGroup, a.CANCELLED_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    } else {
                        bVar = a(viewGroup, a.WAITING_RAC_TICKET);
                        bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
                    }
                }
            }
            bVar = a(viewGroup, a.WAITING_RAC_TICKET);
            bVar.a(this.f26457e, cJRPNRPAXInformation, i2);
        } else {
            bVar = null;
        }
        return ((RecyclerView.v) bVar).itemView;
    }

    /* renamed from: com.travel.train.b.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26461a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.travel.train.b.k$a[] r0 = com.travel.train.b.k.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26461a = r0
                int[] r0 = f26461a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.b.k$a r1 = com.travel.train.b.k.a.CONFIRM_TICKET     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f26461a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.b.k$a r1 = com.travel.train.b.k.a.WAITING_RAC_TICKET     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f26461a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.b.k$a r1 = com.travel.train.b.k.a.CANCELLED_TICKET     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.k.AnonymousClass1.<clinit>():void");
        }
    }

    private b a(ViewGroup viewGroup, a aVar) {
        int i2 = AnonymousClass1.f26461a[aVar.ordinal()];
        if (i2 == 1) {
            return new r(b(viewGroup, a.CONFIRM_TICKET), this.f26459g);
        }
        if (i2 == 2) {
            return new ac(b(viewGroup, a.WAITING_RAC_TICKET), this.f26459g, this.f26460h.getPNRPrediction());
        }
        if (i2 != 3) {
            return new ac(b(viewGroup, a.WAITING_RAC_TICKET), this.f26459g, this.f26460h.getPNRPrediction());
        }
        return new ab(b(viewGroup, a.CANCELLED_TICKET), this.f26459g);
    }

    private View b(ViewGroup viewGroup, a aVar) {
        int i2 = AnonymousClass1.f26461a[aVar.ordinal()];
        if (i2 == 1) {
            return this.f26458f.inflate(R.layout.pre_t_pnr_confirm_detail, viewGroup, false);
        }
        if (i2 == 2) {
            return this.f26458f.inflate(R.layout.pre_t_pnr_wl_rac_detail, viewGroup, false);
        }
        if (i2 != 3) {
            return this.f26458f.inflate(R.layout.pre_t_pnr_wl_rac_detail, viewGroup, false);
        }
        return this.f26458f.inflate(R.layout.pre_t_pnr_cancelled_detail, viewGroup, false);
    }
}
