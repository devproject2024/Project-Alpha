package com.travel.train.b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.i.o;
import com.travel.train.model.trainticket.a;
import com.travel.train.viewholder.ao;
import java.util.List;

public final class aa extends RecyclerView.a<ao> {

    /* renamed from: a  reason: collision with root package name */
    private Context f26158a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f26159b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f26160c;

    /* renamed from: d  reason: collision with root package name */
    private o f26161d;

    public final int getItemViewType(int i2) {
        return i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ao aoVar = (ao) vVar;
        a aVar = this.f26159b.get(i2);
        Context context = this.f26158a;
        aoVar.f27835d = aVar;
        String contactName = aVar.getContactName();
        String contactNumber = aVar.getContactNumber();
        if (!TextUtils.isEmpty(contactName)) {
            aoVar.f27833b.setText(contactName);
        } else {
            aoVar.f27833b.setText(contactNumber);
        }
        String photoUri = aVar.getPhotoUri();
        if (TextUtils.isEmpty(photoUri)) {
            aoVar.f27832a.setVisibility(4);
            aoVar.f27834c.setVisibility(0);
            aoVar.f27834c.setText(aVar.getDisplayChar());
            ((GradientDrawable) aoVar.f27834c.getBackground()).setColor(aVar.getColor());
            return;
        }
        b.a.C0750a a2 = b.a(context);
        a2.f43753a = photoUri;
        b.a.C0750a.a(a2, aoVar.f27832a, (com.paytm.utility.b.b.b) null, 2);
        aoVar.f27832a.setVisibility(0);
        aoVar.f27834c.setVisibility(4);
    }

    public aa(Context context, List<a> list, o oVar) {
        this.f26158a = context;
        this.f26159b = list;
        this.f26160c = LayoutInflater.from(context);
        this.f26161d = oVar;
    }

    public final int getItemCount() {
        List<a> list = this.f26159b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ao(this.f26160c.inflate(R.layout.pre_t_list_item_train_contact_selected, viewGroup, false), this.f26161d);
    }
}
