package net.one97.paytm.recharge.metro.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public final class h extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f63355a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Integer, String> f63356b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, String> f63357c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f63358d;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f63355a = arguments.getString(StringSet.operator);
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            Serializable serializable = arguments2.getSerializable("EXTRA_MAP_KEY");
            if (serializable != null) {
                this.f63356b = (HashMap) serializable;
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    k.a();
                }
                Serializable serializable2 = arguments3.getSerializable("EXTRA_MAP_VALUE");
                if (serializable2 != null) {
                    this.f63357c = (HashMap) serializable2;
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Int, kotlin.String> /* = java.util.HashMap<kotlin.Int, kotlin.String> */");
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Int, kotlin.String> /* = java.util.HashMap<kotlin.Int, kotlin.String> */");
        }
        throw new RuntimeException("Argument expected");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63363a;

        b(h hVar) {
            this.f63363a = hVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f63363a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.clearFlags(2);
        }
        new Handler().postDelayed(new b(this), 300);
        return layoutInflater.inflate(R.layout.bottom_sheet_mm_qr_ticket_detail, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        ((ImageView) view.findViewById(R.id.img_dialog_close)).setOnClickListener(this);
        View findViewById = view.findViewById(R.id.txt_type);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.txt_type)");
        TextView textView = (TextView) findViewById;
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.metro_details, new Object[]{this.f63355a});
        } else {
            str = null;
        }
        textView.setText(str);
        View findViewById2 = view.findViewById(R.id.recycler_view);
        if (findViewById2 != null) {
            RecyclerView recyclerView = (RecyclerView) findViewById2;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(new c(recyclerView, this));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public static final class c extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f63364a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f63365b;

        c(RecyclerView recyclerView, h hVar) {
            this.f63364a = recyclerView;
            this.f63365b = hVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            TextView textView = aVar.f63360b;
            HashMap a2 = this.f63365b.f63356b;
            if (a2 == null) {
                k.a();
            }
            textView.setText((CharSequence) a2.get(Integer.valueOf(i2)));
            TextView textView2 = aVar.f63359a;
            HashMap b2 = this.f63365b.f63357c;
            if (b2 == null) {
                k.a();
            }
            textView2.setText((CharSequence) b2.get(Integer.valueOf(i2)));
            HashMap a3 = this.f63365b.f63356b;
            if (a3 != null && i2 == a3.size() - 1) {
                aVar.f63361c.setVisibility(8);
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            h hVar = this.f63365b;
            View inflate = LayoutInflater.from(this.f63364a.getContext()).inflate(R.layout.content_mm_qr_detail, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…qr_detail, parent, false)");
            return new a(hVar, inflate);
        }

        public final int getItemCount() {
            HashMap a2 = this.f63365b.f63356b;
            if (a2 != null) {
                return a2.size();
            }
            return 0;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63359a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f63360b;

        /* renamed from: c  reason: collision with root package name */
        final View f63361c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f63362d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f63362d = hVar;
            View findViewById = view.findViewById(R.id.txt_value);
            if (findViewById != null) {
                this.f63359a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.txt_key);
                if (findViewById2 != null) {
                    this.f63360b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.row_divider);
                    if (findViewById3 != null) {
                        this.f63361c = findViewById3;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.img_dialog_close;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63358d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
