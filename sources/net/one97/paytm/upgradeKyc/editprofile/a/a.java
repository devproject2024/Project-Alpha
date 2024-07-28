package net.one97.paytm.upgradeKyc.editprofile.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.landingpage.R;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public C1306a f65803a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f65804b;

    /* renamed from: c  reason: collision with root package name */
    private int f65805c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final Context f65806d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f65807e;

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.a.a$a  reason: collision with other inner class name */
    public interface C1306a {
        void a();
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, ArrayList<String> arrayList) {
        k.c(context, "context");
        k.c(arrayList, "optionsList");
        this.f65806d = context;
        this.f65807e = arrayList;
        LayoutInflater from = LayoutInflater.from(this.f65806d);
        k.a((Object) from, "LayoutInflater.from(context)");
        this.f65804b = from;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = false;
        if (view != null) {
            Object tag = view.getTag();
            if (tag != null) {
                bVar = (b) tag;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.editprofile.adapters.RadioButtonListAdapter.RadioButtonListViewHolder");
            }
        } else {
            view = this.f65804b.inflate(R.layout.kyc_radio_button_item, viewGroup, false);
            k.a((Object) view, "layoutView");
            bVar = new b(this, view);
            view.setTag(bVar);
        }
        bVar.f65808a.setText(this.f65807e.get(i2));
        bVar.f65808a.setOnClickListener(new c(this, i2));
        RadioButton radioButton = bVar.f65809b;
        if (i2 == this.f65805c) {
            z = true;
        }
        radioButton.setChecked(z);
        bVar.f65809b.setOnClickListener(new d(this, i2));
        return view;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65811a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f65812b;

        c(a aVar, int i2) {
            this.f65811a = aVar;
            this.f65812b = i2;
        }

        public final void onClick(View view) {
            a.a(this.f65811a, this.f65812b);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f65814b;

        d(a aVar, int i2) {
            this.f65813a = aVar;
            this.f65814b = i2;
        }

        public final void onClick(View view) {
            a.a(this.f65813a, this.f65814b);
        }
    }

    public final int getCount() {
        return this.f65807e.size();
    }

    public final String a() {
        String str = this.f65807e.get(this.f65805c);
        k.a((Object) str, "optionsList[selectedPos]");
        return str;
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f65808a;

        /* renamed from: b  reason: collision with root package name */
        RadioButton f65809b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f65810c;

        public b(a aVar, View view) {
            k.c(view, "view");
            this.f65810c = aVar;
            View findViewById = view.findViewById(R.id.optionTV);
            k.a((Object) findViewById, "view.findViewById(R.id.optionTV)");
            this.f65808a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.optionRB);
            k.a((Object) findViewById2, "view.findViewById(R.id.optionRB)");
            this.f65809b = (RadioButton) findViewById2;
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        String str = this.f65807e.get(i2);
        k.a((Object) str, "optionsList[position]");
        return str;
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        aVar.f65805c = i2;
        aVar.notifyDataSetChanged();
        C1306a aVar2 = aVar.f65803a;
        if (aVar2 == null) {
            k.a("itemClickListner");
        }
        aVar2.a();
    }
}
