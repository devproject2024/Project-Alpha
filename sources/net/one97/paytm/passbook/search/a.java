package net.one97.paytm.passbook.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<f> f58339a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f58340b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f58341c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f58342d;

    /* renamed from: e  reason: collision with root package name */
    private final int f58343e;

    /* renamed from: f  reason: collision with root package name */
    private final int f58344f = (this.f58343e / 4);

    /* renamed from: net.one97.paytm.passbook.search.a$a  reason: collision with other inner class name */
    public static class C1124a {

        /* renamed from: a  reason: collision with root package name */
        TextView f58347a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f58348b;
    }

    public a(Context context, ArrayList<f> arrayList, b bVar) {
        this.f58339a = arrayList;
        this.f58340b = LayoutInflater.from(context);
        this.f58341c = context;
        this.f58342d = bVar;
        this.f58343e = b.f(context);
    }

    public final int getCount() {
        return this.f58339a.size();
    }

    public final Object getItem(int i2) {
        return this.f58339a.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f58339a.get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        final f fVar = this.f58339a.get(i2);
        if (view == null) {
            view = this.f58340b.inflate(R.layout.pass_item_filter_type_passbook, (ViewGroup) null);
            int i3 = this.f58344f;
            view.setPadding(i3, 0, i3, 0);
            C1124a aVar = new C1124a();
            aVar.f58347a = (TextView) view.findViewById(R.id.title);
            aVar.f58348b = (ImageView) view.findViewById(R.id.remove);
            view.setTag(aVar);
        }
        C1124a aVar2 = (C1124a) view.getTag();
        aVar2.f58347a.setText("");
        TextView textView = aVar2.f58347a;
        textView.setText(fVar.f58472a + " ");
        aVar2.f58348b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f58342d.a(fVar);
            }
        });
        return view;
    }

    public final void a(ArrayList<f> arrayList) {
        this.f58339a = arrayList;
        notifyDataSetChanged();
    }
}
