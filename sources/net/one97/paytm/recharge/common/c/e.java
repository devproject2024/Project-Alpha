package net.one97.paytm.recharge.common.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class e extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60986a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final String f60987c;

    /* renamed from: d  reason: collision with root package name */
    private static b f60988d;

    /* renamed from: b  reason: collision with root package name */
    private CJRSelectOperatorViewV8.b f60989b;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f60990e;

    public interface b {
        void a();
    }

    private View a(int i2) {
        if (this.f60990e == null) {
            this.f60990e = new HashMap();
        }
        View view = (View) this.f60990e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f60990e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    private e() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = e.class.getSimpleName();
        k.a((Object) simpleName, "CJRSelectOperatorBottomS…og::class.java.simpleName");
        f60987c = simpleName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(CJRSelectOperatorViewV8.b bVar) {
        this();
        k.c(bVar, "option");
        this.f60989b = bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.SelectOperatorBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_dialog_select_operator, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        TextView textView = (TextView) a(R.id.title);
        k.a((Object) textView, "title");
        CJRSelectOperatorViewV8.b bVar = this.f60989b;
        if (bVar == null) {
            k.a("options");
        }
        String str = bVar.f61963a;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        CJRSelectOperatorViewV8.b bVar2 = this.f60989b;
        if (bVar2 == null) {
            k.a("options");
        }
        bVar2.j = true;
        ((ImageView) a(R.id.close_button)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) a(R.id.operator_container);
        Context context = getContext();
        CJRSelectOperatorViewV8.b bVar3 = this.f60989b;
        if (bVar3 == null) {
            k.a("options");
        }
        linearLayout.addView(new CJRSelectOperatorViewV8(context, bVar3));
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.close_button);
        k.a((Object) imageView, "close_button");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            dismiss();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            d dVar = new d(context);
            StringBuilder sb = new StringBuilder();
            String upperCase = "dth".toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            sb.append(" (new)");
            d.a(dVar, sb.toString(), "operator_cross_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            b bVar = f60988d;
            if (bVar != null && bVar != null) {
                bVar.a();
            }
        }
    }

    public static void a(b bVar) {
        k.c(bVar, "listener");
        f60988d = bVar;
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager?.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f60990e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
