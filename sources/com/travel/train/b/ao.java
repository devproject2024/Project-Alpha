package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.l;
import com.travel.train.model.trainticket.a;
import com.travel.train.model.trainticket.b;
import com.travel.train.model.trainticket.c;
import com.travel.train.model.trainticket.d;
import com.travel.train.model.trainticket.e;
import com.travel.train.model.trainticket.j;
import com.travel.train.viewholder.ad;
import com.travel.train.viewholder.ae;
import com.travel.train.viewholder.af;
import com.travel.train.viewholder.ag;
import java.util.List;

public final class ao extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<j> f26249a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f26250b;

    /* renamed from: c  reason: collision with root package name */
    private final e f26251c;

    /* renamed from: d  reason: collision with root package name */
    private l f26252d;

    /* renamed from: e  reason: collision with root package name */
    private Context f26253e;

    /* renamed from: f  reason: collision with root package name */
    private ad f26254f;

    /* renamed from: g  reason: collision with root package name */
    private b f26255g;

    public ao(Context context, List<j> list, e eVar, l lVar) {
        this.f26249a = list;
        this.f26250b = LayoutInflater.from(context);
        this.f26251c = eVar;
        this.f26252d = lVar;
        this.f26253e = context;
        int i2 = 0;
        for (j next : list) {
            if (next instanceof b) {
                this.f26255g = (b) next;
                i2++;
            }
        }
        if (i2 > 1) {
            throw new IllegalArgumentException("List cannot contain more that one edit_tag");
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new ae(this.f26250b.inflate(R.layout.pre_t_list_item_resend_ticket_contact_fixed_tag, viewGroup, false), this.f26252d);
        }
        if (i2 == 2) {
            return new af(this.f26250b.inflate(R.layout.pre_t_list_item_resend_ticket_email_fixed_tag, viewGroup, false), this.f26252d);
        }
        if (i2 == 3) {
            this.f26254f = new ad(this.f26253e, this.f26250b.inflate(R.layout.pre_t_list_item_resend_ticket_edit_tag, viewGroup, false), this.f26251c, this.f26252d);
            return this.f26254f;
        } else if (i2 == 4) {
            return new ag(this.f26250b.inflate(R.layout.pre_t_list_item_resend_ticket_generic_read_only_tag, viewGroup, false));
        } else {
            return null;
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int itemViewType = getItemViewType(i2);
        j jVar = this.f26249a.get(i2);
        if (itemViewType == 1) {
            ae aeVar = (ae) vVar;
            a aVar = (a) jVar;
            String contactName = aVar.getContactName();
            String contactNumber = aVar.getContactNumber();
            aeVar.f27772a.setVisibility(TextUtils.isEmpty(contactName) ? 8 : 0);
            aeVar.f27772a.setText(contactName);
            aeVar.f27773b.setText(contactNumber);
        } else if (itemViewType == 2) {
            ((af) vVar).f27776a.setText(((c) jVar).getEmail());
        } else if (itemViewType == 3) {
            ad adVar = (ad) vVar;
            b bVar = (b) jVar;
            adVar.f27770d = bVar;
            adVar.f27767a.setText(bVar.getText());
            adVar.f27767a.setHint(bVar.getHint());
        } else if (itemViewType == 4) {
            ((ag) vVar).f27779a.setText(((d) jVar).getText());
        }
    }

    public final int getItemCount() {
        return this.f26249a.size();
    }

    public final int getItemViewType(int i2) {
        return this.f26249a.get(i2).getType();
    }

    public final void a(String str) {
        ad adVar = this.f26254f;
        if (adVar != null) {
            adVar.a(str);
        }
    }

    public final void a() {
        ad adVar = this.f26254f;
        if (adVar != null) {
            adVar.a();
        }
    }
}
