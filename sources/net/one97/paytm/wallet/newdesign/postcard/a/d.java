package net.one97.paytm.wallet.newdesign.postcard.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.common.entity.lifafa.enums.LifafaStatus;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.b;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRPostcardFetchRecipientList> f71210a;

    /* renamed from: b  reason: collision with root package name */
    b.C1446b f71211b;

    /* renamed from: c  reason: collision with root package name */
    private Context f71212c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.postcard.d f71213d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f71214e = new ArrayList<String>() {
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

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f71215f = new ArrayList<String>() {
        {
            add("#802cce86");
            add("#806c7cff");
            add("#80ffa400");
            add("#80b069ec");
            add("#8040cdd8");
            add("#80fd5c7f");
            add("#80f2c110");
            add("#80f36bb4");
            add("#803ab6f4");
            add("#80a6b7be");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private String f71216g = "d4ac0e69-7852-11e7-83c6-1866da8588af";

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        int i3 = i2 % 10;
        String str = this.f71214e.get(i3);
        this.f71215f.get(i3);
        if (b(i2) != null) {
            aVar.f71224f.setBackground(new BitmapDrawable(this.f71212c.getResources(), b(i2)));
        } else {
            aVar.f71224f.setBackgroundColor(Color.parseColor(str));
        }
        String name = a(i2).getRecievedLifafaDetails().getLifafaDetail().getCreatorInfo().getName();
        if (a(i2).getRecievedLifafaDetails().getLifafaDetail().getCreatorInfo().getName() == null || a(i2).getRecievedLifafaDetails().getLifafaDetail().getCreatorInfo().getName().isEmpty()) {
            name = a(i2).getRecievedLifafaDetails().getLifafaDetail().getCreatorInfo().getPhoneNo();
        }
        if (a(i2).getRecievedLifafaDetails().getRecipientDetail().getActualQuantity() == null || ((a(i2).getRecievedLifafaDetails().getRecipientDetail().getRecipientStatus() != null && a(i2).getRecievedLifafaDetails().getRecipientDetail().getRecipientStatus().equalsIgnoreCase(LifafaStatus.PENDING.name())) || a(i2).getRecievedLifafaDetails().getRecipientDetail().getRecipientStatus().equalsIgnoreCase(LifafaStatus.ACTIVATED.name()))) {
            aVar.f71222d.setVisibility(0);
            aVar.f71223e.setVisibility(8);
            aVar.f71221c.setVisibility(8);
        } else if (!a(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.EXPIRED.name()) && !a(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.CANCELLED.name()) && a(i2).getRecievedLifafaDetails().getRecipientDetail().getActualQuantity() != null) {
            aVar.f71222d.setVisibility(8);
            aVar.f71223e.setVisibility(8);
            aVar.f71221c.setVisibility(0);
            TextView textView = aVar.f71221c;
            String string = this.f71212c.getString(R.string.postcard_proposed_amount);
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(a(i2).getRecievedLifafaDetails().getRecipientDetail().getActualQuantity().doubleValue());
            if (!TextUtils.isEmpty(valueOf) && (valueOf.endsWith(".0") || valueOf.endsWith(".00"))) {
                String[] split = valueOf.split("\\.");
                if (split.length > 0) {
                    valueOf = split[0];
                }
            }
            objArr[0] = valueOf;
            textView.setText(String.format(string, objArr));
        } else if (a(i2).getRecievedLifafaDetails().getLifafaDetail() != null && (a(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.EXPIRED.name()) || a(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.CANCELLED.name()))) {
            aVar.f71222d.setVisibility(8);
            aVar.f71221c.setVisibility(8);
            aVar.f71223e.setVisibility(0);
            aVar.f71219a.setTextColor(Color.parseColor("#80222222"));
            aVar.f71220b.setTextColor(Color.parseColor("#80999999"));
        }
        String str2 = a(i2).getRecievedLifafaDetails().getLifafaDetail().getCreatorInfo().getPhoneNo();
        if (!TextUtils.isEmpty(name)) {
            aVar.f71219a.setText(name);
        } else {
            aVar.f71219a.setText(str2);
        }
        aVar.f71220b.setText(a(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaMessage());
        aVar.f71225g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.f71211b.a(i2);
            }
        });
    }

    public d(ArrayList<CJRPostcardFetchRecipientList> arrayList, b.C1446b bVar, Context context) {
        this.f71210a = arrayList;
        this.f71211b = bVar;
        this.f71212c = context;
        this.f71213d = net.one97.paytm.wallet.newdesign.postcard.d.a(context);
    }

    private CJRPostcardFetchRecipientList a(int i2) {
        ArrayList<CJRPostcardFetchRecipientList> arrayList = this.f71210a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i2);
    }

    public final int getItemCount() {
        ArrayList<CJRPostcardFetchRecipientList> arrayList = this.f71210a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71219a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71220b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71221c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71222d;

        /* renamed from: e  reason: collision with root package name */
        TextView f71223e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f71224f;

        /* renamed from: g  reason: collision with root package name */
        RelativeLayout f71225g;

        public a(View view) {
            super(view);
            this.f71224f = (ImageView) view.findViewById(R.id.postcard_img_user);
            this.f71219a = (TextView) view.findViewById(R.id.my_postcard_name);
            this.f71220b = (TextView) view.findViewById(R.id.my_postcard_comment);
            this.f71221c = (TextView) view.findViewById(R.id.my_postcard_proposed_amt);
            this.f71222d = (TextView) view.findViewById(R.id.my_postcard_type);
            this.f71223e = (TextView) view.findViewById(R.id.my_postcard_expire_type);
            this.f71225g = (RelativeLayout) view.findViewById(R.id.rl_main_row);
        }
    }

    private Bitmap b(int i2) {
        String a2 = this.f71213d.a(this.f71210a.get(i2).getRecievedLifafaDetails().getLifafaDetail().getThemeGuid(), this.f71212c);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f71213d.a("d4ac0e69-7852-11e7-83c6-1866da8588af", this.f71212c);
        }
        return BitmapFactory.decodeFile(a2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mypostcard_list_item, viewGroup, false));
    }
}
