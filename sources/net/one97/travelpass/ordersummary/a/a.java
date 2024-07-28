package net.one97.travelpass.ordersummary.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f30488a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f30489b = new ArrayList<>();

    /* renamed from: net.one97.travelpass.ordersummary.a.a$a  reason: collision with other inner class name */
    public static final class C0515a {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f30490a;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, ArrayList<String> arrayList) {
        k.c(context, "mContext");
        k.c(arrayList, "mItems");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.f30488a = (LayoutInflater) systemService;
            this.f30489b = arrayList;
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final int getCount() {
        return this.f30489b.size();
    }

    public final Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C0515a aVar;
        k.c(viewGroup, "parent");
        if (view == null) {
            aVar = new C0515a();
            view2 = this.f30488a.inflate(R.layout.tp_ticked_text_item, (ViewGroup) null);
            aVar.f30490a = (CheckedTextView) view2.findViewById(R.id.singleItem);
            k.a((Object) view2, "view");
            view2.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                C0515a aVar2 = (C0515a) tag;
                view2 = view;
                aVar = aVar2;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.travelpass.ordersummary.adapter.TPCustomListAdapter.MainListHolder");
            }
        }
        CheckedTextView checkedTextView = aVar.f30490a;
        if (checkedTextView == null) {
            k.a();
        }
        checkedTextView.setText(this.f30489b.get(i2));
        return view2;
    }
}
