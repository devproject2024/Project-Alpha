package net.one97.paytm.paymentsBank.slfd.tds.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.paymentsBank.R;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f19341a;

    /* renamed from: b  reason: collision with root package name */
    private a f19342b;

    public b(Context context, a aVar) {
        this.f19341a = context;
        this.f19342b = aVar;
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        if (this.f19342b.equals(a.INTEREST_CERTIFICATE)) {
            arrayList.add(this.f19341a.getString(R.string.pb_tds_select_financial_year));
            arrayList.add(this.f19341a.getString(R.string.pb_tds_email_id_to_recieve_certificate));
        } else if (this.f19342b.equals(a.TDS_CERTIFICATE)) {
            arrayList.add(this.f19341a.getString(R.string.pb_tds_select_financial_year));
            arrayList.add(this.f19341a.getString(R.string.pb_tds_select_financial_quarter));
            arrayList.add(this.f19341a.getString(R.string.pb_tds_email_id_to_recieve_certificate));
        }
        return arrayList;
    }

    public final String b() {
        if (this.f19342b.equals(a.INTEREST_CERTIFICATE)) {
            return this.f19341a.getString(R.string.pb_coi_page_title);
        }
        if (this.f19342b.equals(a.TDS_CERTIFICATE)) {
            return this.f19341a.getString(R.string.pb_tds_page_title);
        }
        return null;
    }
}
