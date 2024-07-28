package net.one97.paytm.recharge.ordersummary.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public class r extends f implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f64226d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    private HashMap f64227a;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f64228c;

    public View a(int i2) {
        if (this.f64227a == null) {
            this.f64227a = new HashMap();
        }
        View view = (View) this.f64227a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64227a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void d() {
        HashMap hashMap = this.f64227a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static r a(String str, String str2, String str3, List<String> list, DialogInterface.OnClickListener onClickListener) {
            k.c(str, "title");
            k.c(list, StringSet.messages);
            r rVar = new r();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("posbtntxt", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("negbtntxt", str3);
            }
            bundle.putSerializable(StringSet.messages, (Serializable) list);
            bundle.putInt("bullet_color", R.color.color_b8c2cb);
            rVar.setArguments(bundle);
            rVar.f64228c = onClickListener;
            return rVar;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() == null) {
            throw new IllegalStateException();
        }
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            View view = null;
            if ((dialog != null ? dialog.getWindow() : null) != null && Build.VERSION.SDK_INT >= 26) {
                Dialog dialog2 = getDialog();
                Window window = dialog2 != null ? dialog2.getWindow() : null;
                if (window != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    view.setSystemUiVisibility(view.getSystemUiVisibility() | 16);
                }
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(b.f64229a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f64229a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof DialogInterface.OnClickListener) {
            this.f64228c = (DialogInterface.OnClickListener) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recharge_order_summary_bottom_sheet, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.title);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            Bundle arguments = getArguments();
            String str = null;
            textView.setText(arguments != null ? arguments.getString("title") : null);
            View findViewById2 = view.findViewById(R.id.positive_button);
            if (findViewById2 != null) {
                TextView textView2 = (TextView) findViewById2;
                Bundle arguments2 = getArguments();
                if (arguments2 == null || !arguments2.containsKey("posbtntxt")) {
                    textView2.setVisibility(8);
                } else {
                    Bundle arguments3 = getArguments();
                    textView2.setText(arguments3 != null ? arguments3.getString("posbtntxt") : null);
                    textView2.setOnClickListener(this);
                }
                View findViewById3 = view.findViewById(R.id.negative_button);
                if (findViewById3 != null) {
                    TextView textView3 = (TextView) findViewById3;
                    Bundle arguments4 = getArguments();
                    if (arguments4 == null || !arguments4.containsKey("negbtntxt")) {
                        textView3.setVisibility(8);
                    } else {
                        Bundle arguments5 = getArguments();
                        if (arguments5 != null) {
                            str = arguments5.getString("negbtntxt");
                        }
                        textView3.setText(str);
                        textView3.setOnClickListener(this);
                    }
                    a(view);
                    ((ImageView) view.findViewById(R.id.close_button)).setOnClickListener(this);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public void a(View view) {
        k.c(view, "view");
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(StringSet.messages) : null;
        if (obj != null) {
            List list = (List) obj;
            View findViewById = view.findViewById(R.id.messages);
            if (findViewById != null) {
                RecyclerView recyclerView = (RecyclerView) findViewById;
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                Bundle arguments2 = getArguments();
                recyclerView.setAdapter(new net.one97.paytm.recharge.ordersummary.a.a(context, list, arguments2 != null ? arguments2.getInt("bullet_color") : R.color.color_b8c2cb));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    public void onClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.positive_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            DialogInterface.OnClickListener onClickListener2 = this.f64228c;
            if (onClickListener2 != null) {
                onClickListener2.onClick(getDialog(), -1);
            }
        } else {
            int i3 = R.id.negative_button;
            if (!(valueOf == null || valueOf.intValue() != i3 || (onClickListener = this.f64228c) == null)) {
                onClickListener.onClick(getDialog(), -2);
            }
        }
        dismiss();
    }
}
