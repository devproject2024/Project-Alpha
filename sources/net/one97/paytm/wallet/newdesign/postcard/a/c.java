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
import net.one97.paytm.common.entity.CJRPostcardFetchInitiatorList;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.a;
import net.one97.paytm.wallet.newdesign.postcard.d;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRPostcardFetchInitiatorList> f71193a;

    /* renamed from: b  reason: collision with root package name */
    a.b f71194b;

    /* renamed from: c  reason: collision with root package name */
    private Context f71195c;

    /* renamed from: d  reason: collision with root package name */
    private d f71196d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f71197e = new ArrayList<String>() {
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
    private ArrayList<String> f71198f = new ArrayList<String>() {
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
    private String f71199g = "d4ac0e69-7852-11e7-83c6-1866da8588af";

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        int i3 = i2 % 10;
        String str = this.f71197e.get(i3);
        this.f71198f.get(i3);
        String lifafaName = this.f71193a.get(i2).getSentLifafaList().getLifafaName();
        if (a(i2) != null) {
            aVar.f71205d.setBackground(new BitmapDrawable(this.f71195c.getResources(), a(i2)));
        } else {
            aVar.f71205d.setBackgroundColor(Color.parseColor(str));
        }
        aVar.f71202a.setText(lifafaName);
        aVar.f71203b.setText(this.f71193a.get(i2).getSentLifafaList().getLifafaMessage());
        aVar.f71204c.setVisibility(0);
        if (this.f71195c != null) {
            TextView textView = aVar.f71204c;
            String string = this.f71195c.getString(R.string.postcard_proposed_amount);
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(this.f71193a.get(i2).getSentLifafaList().getProposedQuantity().doubleValue());
            if (!TextUtils.isEmpty(valueOf) && (valueOf.endsWith(".0") || valueOf.endsWith(".00"))) {
                String[] split = valueOf.split("\\.");
                if (split.length > 0) {
                    valueOf = split[0];
                }
            }
            objArr[0] = valueOf;
            textView.setText(String.format(string, objArr));
        }
        aVar.f71206e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f71194b.a(i2);
            }
        });
    }

    public c(ArrayList<CJRPostcardFetchInitiatorList> arrayList, a.b bVar, Context context) {
        this.f71193a = arrayList;
        this.f71194b = bVar;
        this.f71195c = context;
        this.f71196d = d.a(context);
    }

    public final int getItemCount() {
        ArrayList<CJRPostcardFetchInitiatorList> arrayList = this.f71193a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71202a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71203b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71204c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f71205d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71206e;

        /* renamed from: g  reason: collision with root package name */
        private TextView f71208g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f71209h;

        public a(View view) {
            super(view);
            this.f71205d = (ImageView) view.findViewById(R.id.postcard_img_user);
            this.f71202a = (TextView) view.findViewById(R.id.my_postcard_name);
            this.f71203b = (TextView) view.findViewById(R.id.my_postcard_comment);
            this.f71204c = (TextView) view.findViewById(R.id.my_postcard_proposed_amt);
            this.f71208g = (TextView) view.findViewById(R.id.my_postcard_type);
            this.f71209h = (TextView) view.findViewById(R.id.my_postcard_expire_type);
            this.f71206e = (RelativeLayout) view.findViewById(R.id.rl_main_row);
        }
    }

    private Bitmap a(int i2) {
        String a2 = this.f71196d.a(this.f71193a.get(i2).getSentLifafaList().getThemeGuid(), this.f71195c);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f71196d.a("d4ac0e69-7852-11e7-83c6-1866da8588af", this.f71195c);
        }
        return BitmapFactory.decodeFile(a2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mypostcard_list_item, viewGroup, false));
    }
}
