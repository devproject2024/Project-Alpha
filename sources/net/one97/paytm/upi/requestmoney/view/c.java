package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f69391a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ContactItemModel> f69392b;

    /* renamed from: c  reason: collision with root package name */
    C1405c f69393c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f69394d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: net.one97.paytm.upi.requestmoney.view.c$c  reason: collision with other inner class name */
    public interface C1405c {
        void onClick(String str, String str2);
    }

    public c(Context context, ArrayList<ContactItemModel> arrayList, C1405c cVar) {
        this.f69391a = context;
        this.f69392b = arrayList;
        this.f69393c = cVar;
    }

    public final void a(ArrayList<ContactItemModel> arrayList) {
        this.f69392b = arrayList;
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new b(LayoutInflater.from(this.f69391a).inflate(R.layout.rq_contact_item_view, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.f69391a).inflate(R.layout.rq_contact_item_header, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar == null || !(vVar instanceof a)) {
            b bVar = (b) vVar;
            bVar.f69398b.setBackgroundColor(Color.parseColor(c.this.f69394d.get(i2 % 10)));
            ContactItemModel contactItemModel = c.this.f69392b.get(i2);
            String photoUri = contactItemModel.getPhotoUri();
            String name = contactItemModel.getName();
            bVar.f69399c.setText(contactItemModel.getPhnNo());
            if (!TextUtils.isEmpty(name)) {
                bVar.f69397a.setText(name);
                bVar.f69398b.setText(UpiAppUtils.getInitialsSingle(name));
            } else {
                bVar.f69400d.setVisibility(0);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                bVar.f69400d.setVisibility(0);
                bVar.f69398b.setVisibility(8);
                w.a().a(photoUri).a(c.this.f69391a.getResources().getDrawable(R.drawable.profile_logout)).b(R.drawable.profile_logout).a(bVar.f69400d, (e) null);
            } else {
                bVar.f69400d.setVisibility(8);
                bVar.f69398b.setVisibility(0);
            }
            bVar.f69401e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (c.this.f69393c != null && c.this.f69392b != null) {
                        c.this.f69393c.onClick(c.this.f69392b.get(b.this.getAdapterPosition()).getPhnNo(), c.this.f69392b.get(b.this.getAdapterPosition()).getName());
                    }
                }
            });
            return;
        }
        a aVar = (a) vVar;
        aVar.f69395a.setText(c.this.f69392b.get(i2).getName());
    }

    public final int getItemCount() {
        ArrayList<ContactItemModel> arrayList = this.f69392b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final int getItemViewType(int i2) {
        ArrayList<ContactItemModel> arrayList = this.f69392b;
        return (arrayList == null || arrayList.get(i2).ismIsHeading()) ? 2 : 1;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f69395a;

        a(View view) {
            super(view);
            this.f69395a = (TextView) view.findViewById(R.id.headerTv);
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f69397a;

        /* renamed from: b  reason: collision with root package name */
        TextView f69398b;

        /* renamed from: c  reason: collision with root package name */
        TextView f69399c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f69400d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f69401e;

        /* renamed from: g  reason: collision with root package name */
        private View f69403g;

        b(View view) {
            super(view);
            this.f69398b = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.f69400d = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.f69397a = (TextView) view.findViewById(R.id.beneficiary_name);
            this.f69399c = (TextView) view.findViewById(R.id.beneficiary_number);
            this.f69401e = (RelativeLayout) view.findViewById(R.id.parent_layout);
            this.f69403g = view.findViewById(R.id.separator);
        }
    }
}
