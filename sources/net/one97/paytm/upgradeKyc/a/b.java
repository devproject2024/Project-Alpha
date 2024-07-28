package net.one97.paytm.upgradeKyc.a;

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
import net.one97.paytm.upgradeKyc.R;

public final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f65198a = -1;

    /* renamed from: b  reason: collision with root package name */
    public a f65199b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f65200c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f65201d;

    public interface a {
        void b(int i2);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(Context context, ArrayList<String> arrayList) {
        k.c(context, "context");
        k.c(arrayList, "optionsList");
        this.f65201d = context;
        this.f65200c = arrayList;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C1291b bVar;
        boolean z = false;
        if (view != null) {
            Object tag = view.getTag();
            if (tag != null) {
                bVar = (C1291b) tag;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.adapter.RadioButtonListAdapter.RadioButtonListViewHolder");
            }
        } else {
            view = LayoutInflater.from(this.f65201d).inflate(R.layout.kyc_radio_button_item, viewGroup, false);
            k.a((Object) view, "layoutView");
            bVar = new C1291b(this, view);
            view.setTag(bVar);
        }
        bVar.f65202a.setText(this.f65200c.get(i2));
        bVar.f65202a.setOnClickListener(new c(this, i2));
        RadioButton radioButton = bVar.f65203b;
        if (i2 == this.f65198a) {
            z = true;
        }
        radioButton.setChecked(z);
        bVar.f65203b.setOnClickListener(new d(this, i2));
        return view;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f65206b;

        c(b bVar, int i2) {
            this.f65205a = bVar;
            this.f65206b = i2;
        }

        public final void onClick(View view) {
            b.a(this.f65205a, this.f65206b);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f65208b;

        d(b bVar, int i2) {
            this.f65207a = bVar;
            this.f65208b = i2;
        }

        public final void onClick(View view) {
            b.a(this.f65207a, this.f65208b);
        }
    }

    public final int getCount() {
        return this.f65200c.size();
    }

    /* renamed from: net.one97.paytm.upgradeKyc.a.b$b  reason: collision with other inner class name */
    public final class C1291b {

        /* renamed from: a  reason: collision with root package name */
        TextView f65202a;

        /* renamed from: b  reason: collision with root package name */
        RadioButton f65203b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f65204c;

        public C1291b(b bVar, View view) {
            k.c(view, "view");
            this.f65204c = bVar;
            View findViewById = view.findViewById(R.id.optionTV);
            k.a((Object) findViewById, "view.findViewById(R.id.optionTV)");
            this.f65202a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.optionRB);
            k.a((Object) findViewById2, "view.findViewById(R.id.optionRB)");
            this.f65203b = (RadioButton) findViewById2;
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        String str = this.f65200c.get(i2);
        k.a((Object) str, "optionsList[position]");
        return str;
    }

    public static final /* synthetic */ void a(b bVar, int i2) {
        if (i2 != -1) {
            bVar.f65198a = i2;
            bVar.notifyDataSetChanged();
            a aVar = bVar.f65199b;
            if (aVar == null) {
                k.a("itemClickListener");
            }
            aVar.b(i2);
        }
    }
}
