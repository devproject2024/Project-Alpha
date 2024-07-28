package net.one97.paytm.o2o.movies.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.a.e;
import net.one97.paytm.o2o.movies.d.d;
import net.one97.paytm.o2o.movies.entity.CJRCPSelectionItem;
import net.one97.paytm.o2o.movies.entity.CJRCPUpgrade;
import net.one97.paytm.o2o.movies.utils.n;

public final class ao extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final int f74436a = n.b(17);

    /* renamed from: b  reason: collision with root package name */
    final List<CJRCPSelectionItem> f74437b;

    /* renamed from: c  reason: collision with root package name */
    final d f74438c;

    /* renamed from: d  reason: collision with root package name */
    private final String f74439d;

    public ao(CJRCPUpgrade cJRCPUpgrade, d dVar) {
        List<CJRCPSelectionItem> list;
        String str;
        k.c(cJRCPUpgrade, "cjrcpUpgrade");
        k.c(dVar, "listener");
        this.f74438c = dVar;
        this.f74437b = cJRCPUpgrade.getOptions();
        this.f74439d = cJRCPUpgrade.getDefault();
        List<CJRCPSelectionItem> list2 = this.f74437b;
        boolean z = false;
        if (list2 != null) {
            for (CJRCPSelectionItem userSelected : list2) {
                if (userSelected.getUserSelected()) {
                    z = true;
                }
            }
        }
        if (!z && (list = this.f74437b) != null) {
            for (CJRCPSelectionItem cJRCPSelectionItem : list) {
                String type = cJRCPSelectionItem.getType();
                String str2 = null;
                if (type == null) {
                    str = null;
                } else if (type != null) {
                    str = p.b(type).toString();
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String str3 = this.f74439d;
                if (str3 != null) {
                    if (str3 != null) {
                        str2 = p.b(str3).toString();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                if (p.a(str, str2, true)) {
                    cJRCPSelectionItem.setSelected(true);
                    this.f74438c.a(cJRCPSelectionItem);
                }
            }
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        List<CJRCPSelectionItem> list = this.f74437b;
        if (list != null) {
            CJRCPSelectionItem cJRCPSelectionItem = list.get(i2);
            RoboTextView roboTextView = aVar.f74440a;
            k.a((Object) roboTextView, "holder.title");
            roboTextView.setText(cJRCPSelectionItem.getTitle());
            RoboTextView roboTextView2 = aVar.f74441b;
            k.a((Object) roboTextView2, "holder.subtitle");
            roboTextView2.setText(cJRCPSelectionItem.getDescription());
            Integer num = null;
            if (cJRCPSelectionItem.getSelected()) {
                ConstraintLayout constraintLayout = aVar.f74445f;
                k.a((Object) constraintLayout, "holder.selectorBG");
                constraintLayout.setSelected(true);
                ConstraintLayout constraintLayout2 = aVar.f74445f;
                int i3 = this.f74436a;
                constraintLayout2.setPadding(i3, i3, i3, i3);
                RoboTextView roboTextView3 = aVar.f74443d;
                k.a((Object) roboTextView3, "holder.ctaTxt");
                e.a(roboTextView3, false);
                RoboTextView roboTextView4 = aVar.f74442c;
                k.a((Object) roboTextView4, "holder.price");
                e.a(roboTextView4, false);
                StringBuilder sb = new StringBuilder("₹ ");
                String price = cJRCPSelectionItem.getPrice();
                if (price != null) {
                    num = Integer.valueOf(kotlin.h.a.a(Double.parseDouble(price)));
                }
                sb.append(num);
                String sb2 = sb.toString();
                RoboTextView roboTextView5 = aVar.f74442c;
                k.a((Object) roboTextView5, "holder.price");
                CharSequence charSequence = sb2;
                roboTextView5.setText(charSequence);
                RoboTextView roboTextView6 = aVar.f74444e;
                k.a((Object) roboTextView6, "holder.selectedTxt");
                roboTextView6.setText(charSequence);
                RoboTextView roboTextView7 = aVar.f74444e;
                k.a((Object) roboTextView7, "holder.selectedTxt");
                e.b(roboTextView7, false);
                return;
            }
            ConstraintLayout constraintLayout3 = aVar.f74445f;
            k.a((Object) constraintLayout3, "holder.selectorBG");
            constraintLayout3.setSelected(false);
            aVar.f74445f.setPadding(0, 0, 0, 0);
            RoboTextView roboTextView8 = aVar.f74443d;
            k.a((Object) roboTextView8, "holder.ctaTxt");
            roboTextView8.setText(cJRCPSelectionItem.getCtaText());
            RoboTextView roboTextView9 = aVar.f74444e;
            k.a((Object) roboTextView9, "holder.selectedTxt");
            e.b(roboTextView9, true);
            RoboTextView roboTextView10 = aVar.f74443d;
            k.a((Object) roboTextView10, "holder.ctaTxt");
            e.a(roboTextView10, !TextUtils.isEmpty(cJRCPSelectionItem.getCtaText()));
            RoboTextView roboTextView11 = aVar.f74442c;
            k.a((Object) roboTextView11, "holder.price");
            e.a(roboTextView11, true);
            RoboTextView roboTextView12 = aVar.f74442c;
            k.a((Object) roboTextView12, "holder.price");
            roboTextView12.setSelected(true);
            String price2 = cJRCPSelectionItem.getPrice();
            if (price2 == null) {
                str = null;
            } else if (price2 != null) {
                str = p.b(price2).toString();
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (p.a(str, "0", false)) {
                RoboTextView roboTextView13 = aVar.f74442c;
                k.a((Object) roboTextView13, "holder.price");
                roboTextView13.setText("Free");
                RoboTextView roboTextView14 = aVar.f74444e;
                k.a((Object) roboTextView14, "holder.selectedTxt");
                roboTextView14.setText("Free");
                return;
            }
            RoboTextView roboTextView15 = aVar.f74444e;
            k.a((Object) roboTextView15, "holder.selectedTxt");
            e.b(roboTextView15, true);
            StringBuilder sb3 = new StringBuilder("₹ ");
            String price3 = cJRCPSelectionItem.getPrice();
            if (price3 != null) {
                num = Integer.valueOf(kotlin.h.a.a(Double.parseDouble(price3)));
            }
            sb3.append(num);
            String sb4 = sb3.toString();
            RoboTextView roboTextView16 = aVar.f74442c;
            k.a((Object) roboTextView16, "holder.price");
            CharSequence charSequence2 = sb4;
            roboTextView16.setText(charSequence2);
            RoboTextView roboTextView17 = aVar.f74444e;
            k.a((Object) roboTextView17, "holder.selectedTxt");
            roboTextView17.setText(charSequence2);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_cp_selection_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…tion_item, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        List<CJRCPSelectionItem> list = this.f74437b;
        if (list == null) {
            k.a();
        }
        return list.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f74440a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f74441b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f74442c;

        /* renamed from: d  reason: collision with root package name */
        final RoboTextView f74443d;

        /* renamed from: e  reason: collision with root package name */
        final RoboTextView f74444e;

        /* renamed from: f  reason: collision with root package name */
        final ConstraintLayout f74445f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ao f74446g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ao aoVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74446g = aoVar;
            this.f74440a = (RoboTextView) view.findViewById(R.id.txt_title);
            this.f74441b = (RoboTextView) view.findViewById(R.id.txt_subtitle);
            this.f74442c = (RoboTextView) view.findViewById(R.id.txt_price);
            this.f74443d = (RoboTextView) view.findViewById(R.id.txt_cta);
            this.f74444e = (RoboTextView) view.findViewById(R.id.txt_selected);
            this.f74445f = (ConstraintLayout) view.findViewById(R.id.layout_selector);
            view.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f74447a;

                {
                    this.f74447a = r1;
                }

                public final void onClick(View view) {
                    CJRCPSelectionItem cJRCPSelectionItem;
                    List<CJRCPSelectionItem> list = this.f74447a.f74446g.f74437b;
                    if (list != null) {
                        for (CJRCPSelectionItem cJRCPSelectionItem2 : list) {
                            cJRCPSelectionItem2.setSelected(false);
                            cJRCPSelectionItem2.setUserSelected(false);
                        }
                    }
                    List<CJRCPSelectionItem> list2 = this.f74447a.f74446g.f74437b;
                    if (list2 != null && (cJRCPSelectionItem = (CJRCPSelectionItem) kotlin.a.k.a(list2, this.f74447a.getAdapterPosition())) != null) {
                        this.f74447a.f74446g.f74438c.a(cJRCPSelectionItem);
                        cJRCPSelectionItem.setSelected(true);
                        cJRCPSelectionItem.setUserSelected(true);
                        this.f74447a.f74445f.setPadding(this.f74447a.f74446g.f74436a, this.f74447a.f74446g.f74436a, this.f74447a.f74446g.f74436a, this.f74447a.f74446g.f74436a);
                        RoboTextView roboTextView = this.f74447a.f74443d;
                        k.a((Object) roboTextView, "this.ctaTxt");
                        e.a(roboTextView, false);
                        RoboTextView roboTextView2 = this.f74447a.f74442c;
                        k.a((Object) roboTextView2, "this.price");
                        e.a(roboTextView2, false);
                        RoboTextView roboTextView3 = this.f74447a.f74444e;
                        k.a((Object) roboTextView3, "this.selectedTxt");
                        e.b(roboTextView3, false);
                        this.f74447a.f74446g.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
