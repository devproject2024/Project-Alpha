package net.one97.paytm.paymentsBank.createfd.b;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem;
import net.one97.paytm.paymentsBank.slfd.interestprojection.InterestProjectionActivity;

public final class e extends g {

    /* renamed from: a  reason: collision with root package name */
    BookingResponseListItem f18107a;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f18108h;

    public final View a(int i2) {
        if (this.f18108h == null) {
            this.f18108h = new HashMap();
        }
        View view = (View) this.f18108h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18108h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
        HashMap hashMap = this.f18108h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        e();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ImageView imageView;
        k.c(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater.inflate(R.layout.fd_post_transaction_success_bottom_layout_detail_view, onCreateView != null ? (ViewGroup) onCreateView.findViewById(R.id.middleLayout) : null, true);
        if (!(onCreateView == null || (imageView = (ImageView) onCreateView.findViewById(R.id.iv_back_arrow)) == null)) {
            imageView.setOnClickListener(new a(this));
        }
        return onCreateView;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18109a;

        a(e eVar) {
            this.f18109a = eVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f18109a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18110a;

        b(e eVar) {
            this.f18110a = eVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f18110a.getContext(), InterestProjectionActivity.class);
            BookingResponseListItem bookingResponseListItem = this.f18110a.f18107a;
            intent.putExtra("order_id", bookingResponseListItem != null ? bookingResponseListItem.getFdNumber() : null);
            this.f18110a.startActivity(intent);
            FragmentActivity activity = this.f18110a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18111a;

        c(e eVar) {
            this.f18111a = eVar;
        }

        public final void onClick(View view) {
            this.f18111a.a("", (View) null);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        d();
        List arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f18119f)) {
            this.f18120g = true;
            String string = getString(R.string.pb_fd_updated_deposit_amount);
            int i2 = R.drawable.ic_passbook_list;
            b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            arrayList.add(new OptionsModel(string, i2, Integer.valueOf(net.one97.paytm.paymentsBank.createfd.utils.b.y), this.f18119f));
        }
        String string2 = getString(R.string.option_help);
        int i3 = R.drawable.pb_contact_us_icon_new;
        b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        arrayList.add(new OptionsModel(string2, i3, Integer.valueOf(net.one97.paytm.paymentsBank.createfd.utils.b.x), (String) null, 8, (g) null));
        a((List<OptionsModel>) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r8 = (r8 = r8.getBookingResponse()).getBookingResponseList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r9 = "view"
            kotlin.g.b.k.c(r8, r9)
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r8 = r7.f18115b
            r9 = 0
            r0 = 0
            if (r8 == 0) goto L_0x001e
            net.one97.paytm.paymentsBank.model.slfd.BookingResponse r8 = r8.getBookingResponse()
            if (r8 == 0) goto L_0x001e
            java.util.List r8 = r8.getBookingResponseList()
            if (r8 == 0) goto L_0x001e
            java.lang.Object r8 = r8.get(r9)
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r8 = (net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem) r8
            goto L_0x001f
        L_0x001e:
            r8 = r0
        L_0x001f:
            r7.f18107a = r8
            r8 = 8
            r7.b((int) r8)
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r8 = r7.f18107a
            if (r8 == 0) goto L_0x002f
            java.lang.String r8 = r8.getTransactionId()
            goto L_0x0030
        L_0x002f:
            r8 = r0
        L_0x0030:
            int r1 = net.one97.paytm.paymentsBank.R.id.tv_transaction_detail
            android.view.View r1 = r7.a(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 1
            if (r1 == 0) goto L_0x0052
            android.content.Context r3 = r7.getContext()
            if (r3 == 0) goto L_0x004c
            int r4 = net.one97.paytm.paymentsBank.R.string.fd_transaction_id
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r9] = r8
            java.lang.String r8 = r3.getString(r4, r5)
            goto L_0x004d
        L_0x004c:
            r8 = r0
        L_0x004d:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x0052:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_datetime
            android.view.View r8 = r7.a(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.b((android.widget.TextView) r8)
            android.content.Context r8 = r7.getContext()
            java.lang.String r8 = net.one97.paytm.bankCommon.h.b.D(r8)
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x007c
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.Class<net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel> r3 = net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel.class
            java.lang.Object r8 = r1.a((java.lang.String) r8, r3)
            net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel r8 = (net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel) r8
            goto L_0x007d
        L_0x007c:
            r8 = r0
        L_0x007d:
            r3 = 0
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r1 = r7.f18107a
            if (r1 == 0) goto L_0x00a1
            java.lang.Double r1 = r1.getMaturityAmount()
            if (r1 == 0) goto L_0x00a1
            java.lang.Number r1 = (java.lang.Number) r1
            double r5 = r1.doubleValue()
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r1 = r7.f18107a
            if (r1 == 0) goto L_0x00a1
            java.lang.Double r1 = r1.getFdBookingAmount()
            if (r1 == 0) goto L_0x00a1
            java.lang.Number r1 = (java.lang.Number) r1
            double r3 = r1.doubleValue()
            double r3 = r5 - r3
        L_0x00a1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r5 = r7.f18107a
            if (r5 == 0) goto L_0x00af
            java.lang.Double r5 = r5.getRateOfInterestPa()
            goto L_0x00b0
        L_0x00af:
            r5 = r0
        L_0x00b0:
            r1.append(r5)
            java.lang.String r5 = "%"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "₹"
            r5.<init>(r6)
            java.lang.String r3 = net.one97.paytm.bankCommon.mapping.a.a((double) r3)
            r5.append(r3)
            java.lang.String r3 = " "
            r5.append(r3)
            int r4 = net.one97.paytm.paymentsBank.R.string.fd_calculator_interest_rate
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r9] = r1
            if (r8 == 0) goto L_0x00dc
            java.lang.Integer r0 = r8.getPeakTenureMonths()
        L_0x00dc:
            r6[r2] = r0
            java.lang.String r8 = r7.getString(r4, r6)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.<init>(r8)
            android.text.style.StyleSpan r8 = new android.text.style.StyleSpan
            r8.<init>(r2)
            int r1 = r0.length()
            r2 = 33
            r0.setSpan(r8, r9, r1, r2)
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>()
            int r9 = net.one97.paytm.paymentsBank.R.string.fd_projection_interest
            java.lang.String r9 = r7.getString(r9)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            android.text.SpannableStringBuilder r8 = r8.append(r9)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            android.text.SpannableStringBuilder r8 = r8.append(r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.text.SpannableStringBuilder r8 = r8.append(r0)
            int r9 = net.one97.paytm.paymentsBank.R.id.interest_detail
            android.view.View r9 = r7.a(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x012a
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9.setText(r8)
        L_0x012a:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_view_interest_detail
            android.view.View r8 = r7.a(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x013e
            net.one97.paytm.paymentsBank.createfd.b.e$b r9 = new net.one97.paytm.paymentsBank.createfd.b.e$b
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x013e:
            int r8 = net.one97.paytm.paymentsBank.R.id.share_icon
            android.view.View r8 = r7.a(r8)
            androidx.appcompat.widget.AppCompatImageView r8 = (androidx.appcompat.widget.AppCompatImageView) r8
            if (r8 == 0) goto L_0x0152
            net.one97.paytm.paymentsBank.createfd.b.e$c r9 = new net.one97.paytm.paymentsBank.createfd.b.e$c
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
