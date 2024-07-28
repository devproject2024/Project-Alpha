package net.one97.paytm.recharge.presentation.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;

public final class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final C1278a f64795a = new C1278a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f64796d = "title";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f64797e = "message";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f64798f = f64798f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f64799b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public BottomSheetBehavior.a f64800c;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64801g;

    /* renamed from: net.one97.paytm.recharge.presentation.c.a$a  reason: collision with other inner class name */
    public static final class C1278a {
        private C1278a() {
        }

        public /* synthetic */ C1278a(byte b2) {
            this();
        }

        public static com.google.android.material.bottomsheet.b a(Context context, String str, CharSequence charSequence, String str2, View.OnClickListener onClickListener) {
            k.c(context, "context");
            k.c(str, "title");
            k.c(charSequence, "message");
            k.c(str2, a.f64798f);
            return a(context, str, charSequence, str2, onClickListener, (BottomSheetBehavior.a) null);
        }

        public static com.google.android.material.bottomsheet.b a(Context context, String str, CharSequence charSequence, String str2, View.OnClickListener onClickListener, BottomSheetBehavior.a aVar) {
            k.c(context, "context");
            k.c(str, "title");
            k.c(charSequence, "message");
            k.c(str2, a.f64798f);
            Bundle bundle = new Bundle();
            bundle.putString(a.f64796d, str);
            bundle.putCharSequence(a.f64797e, charSequence);
            bundle.putString(a.f64798f, str2);
            Fragment instantiate = Fragment.instantiate(context, a.class.getName(), bundle);
            if (instantiate != null) {
                a aVar2 = (a) instantiate;
                aVar2.f64799b = onClickListener;
                aVar2.f64800c = aVar;
                return aVar2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.presentation.fragments.FJRAutomaticMessageBottomSheet");
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (this.f64799b == null && (context instanceof View.OnClickListener)) {
            this.f64799b = (View.OnClickListener) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        setCancelable(false);
        if (getArguments() == null) {
            throw new IllegalStateException();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new b(this, onCreateDialog));
        return onCreateDialog;
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64802a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Dialog f64803b;

        b(a aVar, Dialog dialog) {
            this.f64802a = aVar;
            this.f64803b = dialog;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                from.setState(3);
                from.setBottomSheetCallback(this.f64802a.f64800c);
                this.f64803b.setOnCancelListener(new DialogInterface.OnCancelListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f64804a;

                    {
                        this.f64804a = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        View findViewById;
                        View view = this.f64804a.f64802a.getView();
                        if (view != null && (findViewById = view.findViewById(R.id.close)) != null) {
                            findViewById.performClick();
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.saved_card_list_message_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.title);
        String str = null;
        if (textView != null) {
            Bundle arguments = getArguments();
            textView.setText(arguments != null ? arguments.getString(f64796d) : null);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.message);
        if (textView2 != null) {
            Bundle arguments2 = getArguments();
            textView2.setText(arguments2 != null ? arguments2.getCharSequence(f64797e) : null);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.action_button);
        if (textView3 != null) {
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str = arguments3.getString(f64798f);
            }
            textView3.setText(str);
        }
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        View findViewById = view.findViewById(R.id.close);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        k.c(view, "view");
        int id = view.getId();
        if (id == R.id.close || id == R.id.action_button) {
            dismiss();
            View.OnClickListener onClickListener = this.f64799b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64801g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
