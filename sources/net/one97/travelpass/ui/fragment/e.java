package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.f;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.b.s;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.ui.a.b;

public final class e extends f implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private BookingDetailsResponse f30716a;

    /* renamed from: b  reason: collision with root package name */
    private s f30717b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f30718c;

    public final void a() {
        HashMap hashMap = this.f30718c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f30717b = (s) f.a(layoutInflater, R.layout.redemption_view, viewGroup, false);
        s sVar = this.f30717b;
        if (sVar != null) {
            return sVar.getRoot();
        }
        return null;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f30719a;

        a(e eVar) {
            this.f30719a = eVar;
        }

        public final void onClick(View view) {
            this.f30719a.dismiss();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r0.equals("train") != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        if (r0.equals("hotel") != false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (r0.equals("buses") != false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r0.equals("bus") != false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (net.one97.travelpass.d.a() == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        r0 = net.one97.travelpass.d.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (r0 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r1 = r0.b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
        if (r0.equals("flights") != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r0.equals("trains") != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (net.one97.travelpass.d.a() == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        r0 = net.one97.travelpass.d.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (r0 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        r1 = r0.c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009d, code lost:
        if (r0.equals("hotels") != false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
        if (net.one97.travelpass.d.a() == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        r0 = net.one97.travelpass.d.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a9, code lost:
        if (r0 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ab, code lost:
        r1 = r0.e(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b6, code lost:
        if (r0.equals("flight") != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        if (net.one97.travelpass.d.a() == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00be, code lost:
        r0 = net.one97.travelpass.d.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c2, code lost:
        if (r0 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        r1 = r0.d(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.travelpass.model.BookingDetailsResponse.BookingItems r4) {
        /*
            r3 = this;
            java.lang.String r0 = "bookingItems"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r4 = r4.getOrderId()
            if (r4 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            net.one97.travelpass.model.BookingDetailsResponse r0 = r3.f30716a
            r1 = 0
            if (r0 == 0) goto L_0x0033
            net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getVertical()
            if (r0 == 0) goto L_0x0033
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x0034
        L_0x002b:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r0)
            throw r4
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 != 0) goto L_0x0038
            goto L_0x00c9
        L_0x0038:
            int r2 = r0.hashCode()
            switch(r2) {
                case -1271823248: goto L_0x00b0;
                case -1211468481: goto L_0x0097;
                case -865710229: goto L_0x007e;
                case -771814909: goto L_0x0075;
                case 97920: goto L_0x005c;
                case 94104366: goto L_0x0053;
                case 99467700: goto L_0x004a;
                case 110621192: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x00c9
        L_0x0041:
            java.lang.String r2 = "train"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
            goto L_0x0086
        L_0x004a:
            java.lang.String r2 = "hotel"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
            goto L_0x009f
        L_0x0053:
            java.lang.String r2 = "buses"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
            goto L_0x0064
        L_0x005c:
            java.lang.String r2 = "bus"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
        L_0x0064:
            net.one97.travelpass.d r0 = net.one97.travelpass.d.a()
            if (r0 == 0) goto L_0x00cb
            net.one97.travelpass.e r0 = net.one97.travelpass.d.b()
            if (r0 == 0) goto L_0x00cb
            java.lang.String r1 = r0.b((java.lang.String) r4)
            goto L_0x00cb
        L_0x0075:
            java.lang.String r2 = "flights"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
            goto L_0x00b8
        L_0x007e:
            java.lang.String r2 = "trains"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
        L_0x0086:
            net.one97.travelpass.d r0 = net.one97.travelpass.d.a()
            if (r0 == 0) goto L_0x00cb
            net.one97.travelpass.e r0 = net.one97.travelpass.d.b()
            if (r0 == 0) goto L_0x00cb
            java.lang.String r1 = r0.c(r4)
            goto L_0x00cb
        L_0x0097:
            java.lang.String r2 = "hotels"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
        L_0x009f:
            net.one97.travelpass.d r0 = net.one97.travelpass.d.a()
            if (r0 == 0) goto L_0x00cb
            net.one97.travelpass.e r0 = net.one97.travelpass.d.b()
            if (r0 == 0) goto L_0x00cb
            java.lang.String r1 = r0.e(r4)
            goto L_0x00cb
        L_0x00b0:
            java.lang.String r2 = "flight"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c9
        L_0x00b8:
            net.one97.travelpass.d r0 = net.one97.travelpass.d.a()
            if (r0 == 0) goto L_0x00cb
            net.one97.travelpass.e r0 = net.one97.travelpass.d.b()
            if (r0 == 0) goto L_0x00cb
            java.lang.String r1 = r0.d(r4)
            goto L_0x00cb
        L_0x00c9:
            java.lang.String r1 = ""
        L_0x00cb:
            if (r1 == 0) goto L_0x00e1
            net.one97.travelpass.d r4 = net.one97.travelpass.d.a()
            java.lang.String r0 = "TravelPassController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.travelpass.e r4 = net.one97.travelpass.d.b()
            android.content.Context r0 = r3.getContext()
            r4.a((android.content.Context) r0, (java.lang.String) r1)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.e.a(net.one97.travelpass.model.BookingDetailsResponse$BookingItems):void");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        BookingDetailsResponse.BookingDetails body;
        TextView textView;
        BookingDetailsResponse.BookingDetails body2;
        ImageView imageView;
        k.c(view, "view");
        Bundle arguments = getArguments();
        List<BookingDetailsResponse.BookingItems> list = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("body") : null;
        if (!(serializable instanceof BookingDetailsResponse)) {
            serializable = null;
        }
        this.f30716a = (BookingDetailsResponse) serializable;
        s sVar = this.f30717b;
        if (!(sVar == null || (imageView = sVar.f30281a) == null)) {
            imageView.setOnClickListener(new a(this));
        }
        s sVar2 = this.f30717b;
        if (!(sVar2 == null || (textView = sVar2.f30284d) == null)) {
            BookingDetailsResponse bookingDetailsResponse = this.f30716a;
            textView.setText((bookingDetailsResponse == null || (body2 = bookingDetailsResponse.getBody()) == null) ? null : body2.getTitle());
        }
        Context context = getContext();
        BookingDetailsResponse bookingDetailsResponse2 = this.f30716a;
        if (!(bookingDetailsResponse2 == null || (body = bookingDetailsResponse2.getBody()) == null)) {
            list = body.getBookingItems();
        }
        b bVar = new b(context, list, this);
        s sVar3 = this.f30717b;
        if (sVar3 != null) {
            sVar3.a(bVar);
        }
        super.onViewCreated(view, bundle);
    }
}
