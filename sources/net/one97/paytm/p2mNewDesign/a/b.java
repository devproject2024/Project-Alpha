package net.one97.paytm.p2mNewDesign.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.d;
import net.one97.paytm.wallet.R;
import org.json.JSONObject;

public final class b extends RecyclerView.a<RecyclerView.v> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<InstrumentInfo> f13119a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<InstrumentInfo> f13120b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f13121c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f13122d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f13123e;

    /* renamed from: f  reason: collision with root package name */
    private String f13124f;

    /* renamed from: g  reason: collision with root package name */
    private int f13125g;

    /* renamed from: h  reason: collision with root package name */
    private int f13126h;

    public b(Context context, List<InstrumentInfo> list, d dVar) {
        this.f13119a = new ArrayList();
        this.f13120b = new ArrayList();
        this.f13122d = new ArrayList<>();
        this.f13125g = 1;
        this.f13126h = 2;
        this.f13119a = new ArrayList();
        try {
            for (InstrumentInfo clone : list) {
                this.f13119a.add((InstrumentInfo) clone.clone());
            }
        } catch (Exception unused) {
        }
        this.f13120b = new ArrayList();
        this.f13120b.addAll(list);
        this.f13121c = context;
        this.f13123e = dVar;
        this.f13124f = null;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bank_provider_list, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            final a aVar = (a) vVar;
            final InstrumentInfo instrumentInfo = this.f13119a.get(i2);
            String str = "";
            if (!instrumentInfo.getBankCode().equalsIgnoreCase("bajajfn") && !instrumentInfo.getBankCode().equalsIgnoreCase("bajaj") && !instrumentInfo.getBankCode().equalsIgnoreCase("BAJAJ FINSERV EMI CARD")) {
                if (SDKConstants.DEBIT.equalsIgnoreCase(instrumentInfo.getCardType())) {
                    str = " Debit Card";
                } else if (SDKConstants.CREDIT.equalsIgnoreCase(instrumentInfo.getCardType())) {
                    str = " Credit Card";
                }
            }
            TextView textView = aVar.f13137c;
            textView.setText(instrumentInfo.getDisplaySecondaryInfo() + str);
            if (instrumentInfo.getDisplaySecondaryInfo().equalsIgnoreCase(this.f13124f)) {
                aVar.f13137c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                aVar.f13140f.setVisibility(0);
            } else {
                aVar.f13137c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                aVar.f13140f.setVisibility(8);
            }
            JSONObject jSONObject = instrumentInfo.getmAdditionalParams();
            String optString = jSONObject != null ? jSONObject.optString(AppConstants.ICON_URL) : null;
            if (!TextUtils.isEmpty(optString)) {
                w.a().a(optString).a(R.drawable.net_banking_icon).b(R.drawable.net_banking_icon).a(aVar.f13135a, (e) null);
            } else {
                aVar.f13135a.setImageDrawable(androidx.core.content.b.a(this.f13121c, R.drawable.net_banking_icon));
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (instrumentInfo.getmIsDisabled() != null && instrumentInfo.getmIsDisabled().getStatus().booleanValue()) {
                        b bVar = b.this;
                        b.a(bVar, Html.fromHtml(bVar.f13121c.getString(R.string.nb_error_title, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString(), Html.fromHtml(b.this.f13121c.getString(R.string.nb_error_desc, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString(), b.this.f13121c);
                    } else if (instrumentInfo.getmLowSuccess() == null || !instrumentInfo.getmLowSuccess().getStatus().booleanValue()) {
                        aVar.f13138d.setVisibility(8);
                        b.this.f13123e.a(instrumentInfo);
                    } else {
                        aVar.f13138d.setVisibility(0);
                        aVar.f13136b.setText(Html.fromHtml(b.this.f13121c.getString(R.string.low_success_rate_msg, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})));
                    }
                }
            });
            aVar.f13139e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.f13123e.a(instrumentInfo);
                }
            });
        }
    }

    public final int getItemCount() {
        List<InstrumentInfo> list = this.f13119a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return this.f13126h;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f13135a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13136b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13137c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f13138d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f13139e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f13140f;

        public a(View view) {
            super(view);
            this.f13135a = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.f13136b = (TextView) view.findViewById(R.id.txt_successrate);
            this.f13138d = (RelativeLayout) view.findViewById(R.id.rl_low_success_bank);
            this.f13139e = (LinearLayout) view.findViewById(R.id.ll_proceed);
            this.f13137c = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f13140f = (ImageView) view.findViewById(R.id.btn_select);
        }
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    b bVar = b.this;
                    List unused = bVar.f13119a = bVar.f13120b;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (InstrumentInfo instrumentInfo : b.this.f13120b) {
                        if (instrumentInfo.getDisplaySecondaryInfo().toLowerCase().contains(charSequence2)) {
                            arrayList.add(instrumentInfo);
                        }
                    }
                    List unused2 = b.this.f13119a = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = b.this.f13119a;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = b.this.f13119a = (ArrayList) filterResults.values;
                if (b.this.f13119a.size() <= 0) {
                    b.this.f13123e.c();
                } else {
                    b.this.f13123e.d();
                }
                b.this.notifyDataSetChanged();
            }
        };
    }

    static /* synthetic */ void a(b bVar, String str, String str2, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_lyt_error_instrument);
        ((TextView) dialog.findViewById(R.id.txt_title)).setText(str);
        ((TextView) dialog.findViewById(R.id.txt_desc)).setText(str2);
        dialog.findViewById(R.id.btn_okey).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
