package net.one97.paytm.passbook.subWallet.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.toll_kotlin.imported.PassageHistoryDetail;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollWalletPsgHistoryModel;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.passbook.toll_kotlin.imported.a.a f58806a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        String str;
        a aVar = (a) vVar;
        if (i2 >= 0 && i2 < this.f58806a.b()) {
            TollWalletPsgHistoryModel a2 = this.f58806a.a(i2);
            String str2 = this.f58806a.f58942a.getamountFormattedString(a2.getTxnAmount(), a2.getTxnTypeApp());
            String dateFormattedString = this.f58806a.f58942a.getDateFormattedString(a2.getReaderTS());
            String str3 = this.f58806a.f58942a.getformattedRegNum(a2.getVehicleRegNo());
            int sendReceiveDrawable = this.f58806a.f58942a.getSendReceiveDrawable(a2.getTxnTypeApp());
            if (!TextUtils.isEmpty(a2.getPlazaName())) {
                str = a2.getPlazaName();
            } else if (!TextUtils.isEmpty(a2.getPlazaId())) {
                String plazaId = a2.getPlazaId();
                net.one97.paytm.passbook.toll_kotlin.imported.a.a aVar2 = this.f58806a;
                str = !TextUtils.isEmpty(plazaId) ? aVar2.f58942a.getFormattedPlazaName(plazaId) : aVar2.f58942a.getFormattedPlazaName(aVar2.f58942a.getTollString());
            } else {
                str = this.f58806a.f58942a.getTollString();
            }
            aVar.f58810b.setText(a2.getNarration());
            aVar.f58813e.setText(dateFormattedString);
            if (sendReceiveDrawable != 0) {
                aVar.f58811c.setCompoundDrawablesWithIntrinsicBounds(sendReceiveDrawable, 0, 0, 0);
            }
            aVar.f58811c.setText(str);
            if (URLUtil.isValidUrl(a2.getImageUrl())) {
                net.one97.paytm.passbook.toll_kotlin.imported.a.a.c().a(a2.getImageUrl()).a(this.f58806a.d(), this.f58806a.d()).a(R.drawable.pass_car).b(R.drawable.pass_car).a((ImageView) aVar.f58809a, (e) null);
            } else {
                aVar.f58809a.setImageBitmap(this.f58806a.f58942a.getCircularImageBmp());
            }
            aVar.f58814f.setText(str2);
            aVar.f58812d.setText(str3);
            aVar.f58815g.setText("NON_FIN".equalsIgnoreCase(a2.getTxnTypeApp()) ? a2.getTxnTypeDesc() : "PENDING".equalsIgnoreCase(a2.getTxnStatus()) ? a2.getTxnStatus() : "");
            aVar.f58816h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b bVar = b.this;
                    int i2 = i2;
                    net.one97.paytm.passbook.toll_kotlin.imported.a.a aVar = bVar.f58806a;
                    Intent intent = new Intent(aVar.f58942a.getContext(), PassageHistoryDetail.class);
                    intent.putExtra("passageHistoryModel", aVar.f58944c.get(i2));
                    aVar.f58942a.getContext().startActivity(intent);
                }
            });
        }
    }

    public b(net.one97.paytm.passbook.toll_kotlin.imported.a.a aVar) {
        this.f58806a = aVar;
    }

    public final int getItemCount() {
        return this.f58806a.b();
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CircularImageView f58809a;

        /* renamed from: b  reason: collision with root package name */
        TextView f58810b;

        /* renamed from: c  reason: collision with root package name */
        TextView f58811c;

        /* renamed from: d  reason: collision with root package name */
        TextView f58812d;

        /* renamed from: e  reason: collision with root package name */
        TextView f58813e;

        /* renamed from: f  reason: collision with root package name */
        TextView f58814f;

        /* renamed from: g  reason: collision with root package name */
        TextView f58815g;

        /* renamed from: h  reason: collision with root package name */
        View f58816h;

        public a(View view) {
            super(view);
            this.f58809a = (CircularImageView) view.findViewById(R.id.toll_vehicle_icons_bg_iv);
            this.f58810b = (TextView) view.findViewById(R.id.toll_entry_heading1);
            this.f58811c = (TextView) view.findViewById(R.id.toll_entry_text1);
            this.f58812d = (TextView) view.findViewById(R.id.toll_entry_text2);
            this.f58813e = (TextView) view.findViewById(R.id.toll_entry_text3);
            this.f58814f = (TextView) view.findViewById(R.id.toll_amount_tv);
            this.f58815g = (TextView) view.findViewById(R.id.toll_txn_status);
            this.f58816h = view.findViewById(R.id.passagehistory_row);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_toll_passbook_entry_row, viewGroup, false));
    }
}
