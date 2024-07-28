package net.one97.paytm.p2mNewDesign.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.p2mNewDesign.f.h;
import net.one97.paytm.wallet.R;
import org.json.JSONObject;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f13156a;

    /* renamed from: b  reason: collision with root package name */
    public List<InstrumentInfo> f13157b;

    /* renamed from: c  reason: collision with root package name */
    Context f13158c;

    /* renamed from: d  reason: collision with root package name */
    g f13159d;

    /* renamed from: e  reason: collision with root package name */
    h f13160e;

    /* renamed from: f  reason: collision with root package name */
    private int f13161f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13162g;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        final InstrumentInfo instrumentInfo = this.f13157b.get(i2);
        aVar.f13168a.setText(instrumentInfo.getDisplaySecondaryInfo());
        JSONObject jSONObject = instrumentInfo.getmAdditionalParams();
        String optString = jSONObject != null ? jSONObject.optString(AppConstants.ICON_URL) : null;
        if (instrumentInfo.isMore()) {
            aVar.f13170c.setImageDrawable(this.f13158c.getResources().getDrawable(R.drawable.ic_more_wallet));
        } else if (!TextUtils.isEmpty(optString)) {
            w.a().a(optString).a(R.drawable.net_banking_icon).b(R.drawable.net_banking_icon).a(aVar.f13170c, (e) null);
        } else {
            aVar.f13170c.setImageDrawable(b.a(this.f13158c, R.drawable.net_banking_icon));
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (instrumentInfo.isMore()) {
                    d.this.f13160e.h();
                    return;
                }
                d.this.f13156a = instrumentInfo.getDisplaySecondaryInfo();
                if (instrumentInfo.getmIsDisabled() == null || !instrumentInfo.getmIsDisabled().getStatus().booleanValue()) {
                    aVar.f13168a.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    aVar.f13169b.setVisibility(0);
                    d.this.notifyDataSetChanged();
                    d.this.f13159d.a(instrumentInfo, "updateSelection");
                    return;
                }
                d dVar = d.this;
                String obj = Html.fromHtml(dVar.f13158c.getString(R.string.nb_error_title, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString();
                String obj2 = Html.fromHtml(d.this.f13158c.getString(R.string.nb_error_desc, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString();
                Dialog dialog = new Dialog(d.this.f13158c);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_lyt_error_instrument);
                ((TextView) dialog.findViewById(R.id.txt_title)).setText(obj);
                ((TextView) dialog.findViewById(R.id.txt_desc)).setText(obj2);
                dialog.findViewById(R.id.btn_okey).setOnClickListener(new View.OnClickListener(dialog) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ Dialog f13166a;

                    {
                        this.f13166a = r2;
                    }

                    public final void onClick(View view) {
                        this.f13166a.dismiss();
                    }
                });
                dialog.show();
            }
        });
        if (instrumentInfo.getDisplaySecondaryInfo().equalsIgnoreCase(this.f13156a)) {
            aVar.f13168a.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            aVar.f13169b.setVisibility(0);
            aVar.f13171d.setBackground(this.f13158c.getResources().getDrawable(R.drawable.selected_nb_circle));
            return;
        }
        aVar.f13168a.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        aVar.f13169b.setVisibility(8);
        aVar.f13171d.setBackground(this.f13158c.getResources().getDrawable(R.drawable.gray_nb_circle));
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f13168a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f13169b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f13170c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f13171d;

        public a(View view) {
            super(view);
            this.f13168a = (TextView) view.findViewById(R.id.bank_name);
            this.f13169b = (ImageView) view.findViewById(R.id.ic_tick);
            this.f13170c = (ImageView) view.findViewById(R.id.bank_icon);
            this.f13171d = (RelativeLayout) view.findViewById(R.id.container);
        }
    }

    public d(Context context, g gVar, boolean z, String str, h hVar) {
        this.f13158c = context;
        this.f13159d = gVar;
        this.f13162g = z;
        this.f13156a = str;
        this.f13157b = new ArrayList();
        this.f13157b.addAll(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(z) != null ? net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(z) : new ArrayList());
        InstrumentInfo instrumentInfo = new InstrumentInfo();
        instrumentInfo.setDisplayPrimaryInfo(context.getString(R.string.net_banking));
        instrumentInfo.setDisplaySecondaryInfo("Other Banks");
        instrumentInfo.setPayMode("NET_BANKING");
        instrumentInfo.setPaymentTypeId("NB");
        instrumentInfo.setMore(true);
        this.f13157b.add(instrumentInfo);
        this.f13160e = hVar;
    }

    public final int getItemCount() {
        List<InstrumentInfo> list = this.f13157b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_grid_nb_v2, viewGroup, false);
        this.f13158c.getResources().getDimension(R.dimen.dimen_85dp);
        return new a(inflate);
    }
}
