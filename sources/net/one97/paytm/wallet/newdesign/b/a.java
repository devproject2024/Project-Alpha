package net.one97.paytm.wallet.newdesign.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.c.d;

public final class a extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public d f70712a;

    /* renamed from: b  reason: collision with root package name */
    private View f70713b;

    /* renamed from: c  reason: collision with root package name */
    private String f70714c;

    /* renamed from: d  reason: collision with root package name */
    private String f70715d;

    /* renamed from: e  reason: collision with root package name */
    private String f70716e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70717f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70718g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70719h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f70720i;
    private ImageView j;
    private Context k;
    private Button l;
    private View m;
    private HashMap n;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f70713b = layoutInflater.inflate(R.layout.lyt_new_number_fraud_sheet, viewGroup, false);
        Bundle arguments = getArguments();
        View view = null;
        this.f70714c = arguments != null ? arguments.getString("uni_p2p_btm_sheet_mobile_number", "") : null;
        Bundle arguments2 = getArguments();
        this.f70715d = arguments2 != null ? arguments2.getString("uni_p2p_btm_sheet_amount", "") : null;
        Bundle arguments3 = getArguments();
        this.f70716e = arguments3 != null ? arguments3.getString("uni_p2p_btm_sheet_name", "") : null;
        View view2 = this.f70713b;
        this.f70717f = view2 != null ? (TextView) view2.findViewById(R.id.tv_amount) : null;
        TextView textView = this.f70717f;
        if (textView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.rupee);
            k.a((Object) string, "getString(R.string.rupee)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f70715d}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
        View view3 = this.f70713b;
        this.f70718g = view3 != null ? (TextView) view3.findViewById(R.id.tv_number) : null;
        TextView textView2 = this.f70718g;
        if (textView2 != null) {
            textView2.setText(this.f70714c);
        }
        View view4 = this.f70713b;
        this.f70719h = view4 != null ? (TextView) view4.findViewById(R.id.tv_name) : null;
        TextView textView3 = this.f70719h;
        if (textView3 != null) {
            textView3.setText(this.f70716e);
        }
        View view5 = this.f70713b;
        this.f70720i = view5 != null ? (RelativeLayout) view5.findViewById(R.id.rl_send_money_other_mobile_no) : null;
        View view6 = this.f70713b;
        this.j = view6 != null ? (ImageView) view6.findViewById(R.id.iv_close_icon) : null;
        View view7 = this.f70713b;
        this.l = view7 != null ? (Button) view7.findViewById(R.id.tv_confirm) : null;
        View view8 = this.f70713b;
        if (view8 != null) {
            view = view8.findViewById(R.id.separator2);
        }
        this.m = view;
        Button button = this.l;
        if (button != null) {
            button.setOnClickListener(new b(this));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        return this.f70713b;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.k = context;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        x.e eVar = new x.e();
        eVar.element = super.onCreateDialog(bundle);
        Dialog dialog = (Dialog) eVar.element;
        if (dialog != null) {
            dialog.setOnShowListener(new C1428a(eVar));
        }
        Dialog dialog2 = (Dialog) eVar.element;
        if (dialog2 == null) {
            k.a();
        }
        return dialog2;
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.b.a$a  reason: collision with other inner class name */
    static final class C1428a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f70721a;

        C1428a(x.e eVar) {
            this.f70721a = eVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (((Dialog) this.f70721a.element) != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) ((Dialog) this.f70721a.element)).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from<FrameLayout>(it)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70722a;

        b(a aVar) {
            this.f70722a = aVar;
        }

        public final void onClick(View view) {
            this.f70722a.dismissAllowingStateLoss();
            d a2 = this.f70722a.f70712a;
            if (a2 != null) {
                a2.c();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70723a;

        c(a aVar) {
            this.f70723a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            if (this.f70723a.isAdded() && (activity = this.f70723a.getActivity()) != null && !activity.isFinishing()) {
                this.f70723a.dismissAllowingStateLoss();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
