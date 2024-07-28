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
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.d;
import net.one97.paytm.wallet.R;
import org.json.JSONObject;

public final class a extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<net.one97.paytm.p2mNewDesign.entity.b> f13094a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<net.one97.paytm.p2mNewDesign.entity.b> f13095b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f13096c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f13097d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f13098e;

    /* renamed from: f  reason: collision with root package name */
    private String f13099f;

    /* renamed from: g  reason: collision with root package name */
    private int f13100g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f13101h = 2;

    public final int getSectionForPosition(int i2) {
        return 0;
    }

    public a(Context context, List<net.one97.paytm.p2mNewDesign.entity.b> list, d dVar, String str) {
        this.f13094a.addAll(list);
        this.f13095b.addAll(list);
        this.f13096c = context;
        this.f13098e = dVar;
        this.f13099f = str;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f13100g) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bank_section, viewGroup, false));
        }
        return new C0176a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bank_provider_list, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof C0176a) {
            final C0176a aVar = (C0176a) vVar;
            final InstrumentInfo instrumentInfo = this.f13094a.get(i2).f13362b;
            aVar.f13112c.setText(instrumentInfo.getDisplaySecondaryInfo());
            if (instrumentInfo.getDisplaySecondaryInfo().equalsIgnoreCase(this.f13099f)) {
                aVar.f13112c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                aVar.f13115f.setVisibility(0);
            } else {
                aVar.f13112c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                aVar.f13115f.setVisibility(8);
            }
            JSONObject jSONObject = instrumentInfo.getmAdditionalParams();
            String optString = jSONObject != null ? jSONObject.optString(AppConstants.ICON_URL) : null;
            if (!TextUtils.isEmpty(optString)) {
                w.a().a(optString).a(R.drawable.net_banking_icon).b(R.drawable.net_banking_icon).a(aVar.f13110a, (e) null);
            } else {
                aVar.f13110a.setImageDrawable(androidx.core.content.b.a(this.f13096c, R.drawable.net_banking_icon));
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (instrumentInfo.getmIsDisabled() != null && instrumentInfo.getmIsDisabled().getStatus().booleanValue()) {
                        a aVar = a.this;
                        a.a(aVar, Html.fromHtml(aVar.f13096c.getString(R.string.nb_error_title, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString(), Html.fromHtml(a.this.f13096c.getString(R.string.nb_error_desc, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})).toString(), a.this.f13096c);
                    } else if (instrumentInfo.getmLowSuccess() == null || !instrumentInfo.getmLowSuccess().getStatus().booleanValue()) {
                        aVar.f13113d.setVisibility(8);
                        a.this.f13098e.a(instrumentInfo);
                    } else {
                        aVar.f13113d.setVisibility(0);
                        aVar.f13111b.setText(Html.fromHtml(a.this.f13096c.getString(R.string.low_success_rate_msg, new Object[]{instrumentInfo.getDisplaySecondaryInfo()})));
                    }
                }
            });
            aVar.f13114e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f13098e.a(instrumentInfo);
                }
            });
        } else if (vVar instanceof b) {
            ((b) vVar).f13117a.setText(this.f13094a.get(i2).f13363c);
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.p2mNewDesign.entity.b> list = this.f13094a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return this.f13094a.get(i2).f13361a ? this.f13100g : this.f13101h;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f13117a;

        public b(View view) {
            super(view);
            this.f13117a = (TextView) view.findViewById(R.id.tv_section_label);
        }
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.a.a$a  reason: collision with other inner class name */
    public class C0176a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f13110a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13111b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13112c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f13113d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f13114e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f13115f;

        public C0176a(View view) {
            super(view);
            this.f13110a = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.f13111b = (TextView) view.findViewById(R.id.txt_successrate);
            this.f13113d = (RelativeLayout) view.findViewById(R.id.rl_low_success_bank);
            this.f13114e = (LinearLayout) view.findViewById(R.id.ll_proceed);
            this.f13112c = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f13115f = (ImageView) view.findViewById(R.id.btn_select);
        }
    }

    public final Object[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        this.f13097d = new ArrayList<>(26);
        int size = this.f13094a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f13094a.get(i2).f13361a) {
                String upperCase = String.valueOf(this.f13094a.get(i2).f13362b.getDisplaySecondaryInfo().charAt(0)).toUpperCase();
                if (!arrayList.contains(upperCase)) {
                    arrayList.add(upperCase);
                    this.f13097d.add(Integer.valueOf(i2));
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public final int getPositionForSection(int i2) {
        return this.f13097d.get(i2).intValue();
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    a aVar = a.this;
                    List unused = aVar.f13094a = aVar.f13095b;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (net.one97.paytm.p2mNewDesign.entity.b bVar : a.this.f13095b) {
                        if (!bVar.f13361a && bVar.f13362b.getDisplaySecondaryInfo().toLowerCase().contains(charSequence2)) {
                            arrayList.add(bVar);
                        }
                    }
                    List unused2 = a.this.f13094a = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a.this.f13094a;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = a.this.f13094a = (ArrayList) filterResults.values;
                if (a.this.f13094a.size() <= 0) {
                    a.this.f13098e.c();
                } else {
                    a.this.f13098e.d();
                }
                a.this.notifyDataSetChanged();
            }
        };
    }

    static /* synthetic */ void a(a aVar, String str, String str2, Context context) {
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
