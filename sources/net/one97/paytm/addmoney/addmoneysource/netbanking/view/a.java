package net.one97.paytm.addmoney.addmoneysource.netbanking.view;

import android.app.Dialog;
import android.content.Context;
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
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.SectionWrapper;
import net.one97.paytm.wallet.newdesign.addmoney.c.f;

public final class a extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<SectionWrapper> f48348a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<SectionWrapper> f48349b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f48350c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f48351d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public f f48352e;

    /* renamed from: f  reason: collision with root package name */
    private int f48353f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f48354g = 2;

    public final int getSectionForPosition(int i2) {
        return 0;
    }

    public a(Context context, List<SectionWrapper> list, f fVar) {
        this.f48348a.addAll(list);
        this.f48349b.addAll(list);
        this.f48350c = context;
        this.f48352e = fVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f48353f) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uam_item_bank_section, viewGroup, false));
        }
        return new C0845a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uam_item_bank_provider_list, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof C0845a) {
            final C0845a aVar = (C0845a) vVar;
            final net.one97.paytm.addmoney.common.b childSections = this.f48348a.get(i2).getChildSections();
            aVar.f48365c.setText(childSections.f48420b);
            String str = childSections.f48425g;
            if (!TextUtils.isEmpty(str)) {
                w.a().a(str).a(R.drawable.net_banking_icon_addmoney).b(R.drawable.net_banking_icon_addmoney).a(aVar.f48363a, (e) null);
            } else {
                aVar.f48363a.setImageDrawable(androidx.core.content.b.a(this.f48350c, R.drawable.net_banking_icon_addmoney));
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (childSections.f48426h != null && childSections.f48426h.getStatus()) {
                        a aVar = a.this;
                        a.a(aVar, Html.fromHtml(aVar.f48350c.getString(R.string.nb_error_title, new Object[]{childSections.f48420b})).toString(), Html.fromHtml(a.this.f48350c.getString(R.string.nb_error_desc, new Object[]{childSections.f48420b})).toString(), a.this.f48350c);
                    } else if (childSections.f48427i.getStatus()) {
                        aVar.f48366d.setVisibility(0);
                        aVar.f48364b.setText(Html.fromHtml(a.this.f48350c.getString(R.string.low_success_rate_msg, new Object[]{childSections.f48420b})));
                    } else {
                        aVar.f48366d.setVisibility(8);
                        a.this.f48352e.a(childSections);
                    }
                }
            });
            aVar.f48367e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f48352e.a(childSections);
                }
            });
        } else if (vVar instanceof b) {
            ((b) vVar).f48369a.setText(this.f48348a.get(i2).getParentSection());
        }
    }

    public final int getItemCount() {
        List<SectionWrapper> list = this.f48348a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return this.f48348a.get(i2).isSectionHeader() ? this.f48353f : this.f48354g;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f48369a;

        public b(View view) {
            super(view);
            this.f48369a = (TextView) view.findViewById(R.id.tv_section_label);
        }
    }

    /* renamed from: net.one97.paytm.addmoney.addmoneysource.netbanking.view.a$a  reason: collision with other inner class name */
    public class C0845a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f48363a;

        /* renamed from: b  reason: collision with root package name */
        TextView f48364b;

        /* renamed from: c  reason: collision with root package name */
        TextView f48365c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f48366d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f48367e;

        public C0845a(View view) {
            super(view);
            this.f48363a = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.f48364b = (TextView) view.findViewById(R.id.txt_successrate);
            this.f48366d = (RelativeLayout) view.findViewById(R.id.rl_low_success_bank);
            this.f48367e = (LinearLayout) view.findViewById(R.id.ll_proceed);
            this.f48365c = (TextView) view.findViewById(R.id.tv_bank_name);
        }
    }

    public final Object[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        this.f48351d = new ArrayList<>(26);
        int size = this.f48348a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f48348a.get(i2).isSectionHeader()) {
                String upperCase = String.valueOf(this.f48348a.get(i2).getChildSections().f48420b.charAt(0)).toUpperCase();
                if (!arrayList.contains(upperCase)) {
                    arrayList.add(upperCase);
                    this.f48351d.add(Integer.valueOf(i2));
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public final int getPositionForSection(int i2) {
        return this.f48351d.get(i2).intValue();
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    a aVar = a.this;
                    List unused = aVar.f48348a = aVar.f48349b;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (SectionWrapper sectionWrapper : a.this.f48349b) {
                        if (!sectionWrapper.isSectionHeader() && sectionWrapper.getChildSections().f48420b.toLowerCase().contains(charSequence2)) {
                            arrayList.add(sectionWrapper);
                        }
                    }
                    List unused2 = a.this.f48348a = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a.this.f48348a;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = a.this.f48348a = (ArrayList) filterResults.values;
                if (a.this.f48348a.size() <= 0) {
                    a.this.f48352e.a();
                } else {
                    a.this.f48352e.b();
                }
                a.this.notifyDataSetChanged();
            }
        };
    }

    static /* synthetic */ void a(a aVar, String str, String str2, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout_error_instrument);
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
