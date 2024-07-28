package net.one97.paytm.recharge.mobile_v3.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.g;

public class b extends f implements View.OnClickListener, g<net.one97.paytm.recharge.mobile_v3.c.g> {

    /* renamed from: a  reason: collision with root package name */
    public DialogInterface.OnDismissListener f63726a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnClickListener f63727b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f63728c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f63729d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f63730e;

    public final long c_(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_content_item_plan_detail, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…an_detail, parent, false)");
        return new net.one97.paytm.recharge.mobile_v3.c.g(inflate);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        net.one97.paytm.recharge.mobile_v3.c.g gVar = (net.one97.paytm.recharge.mobile_v3.c.g) vVar;
        k.c(gVar, "holder");
        ArrayList<String> arrayList = this.f63728c;
        if (arrayList == null) {
            k.a();
        }
        String str = arrayList.get(i2);
        k.a((Object) str, "highlightedPlans!![position]");
        String str2 = str;
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        TextView textView = gVar.f63939a;
        k.a((Object) textView, "txt_description");
        textView.setText(str2);
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof DialogInterface.OnClickListener) {
            this.f63727b = (DialogInterface.OnClickListener) context;
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
            aVar.setOnShowListener(a.f63731a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f63731a = new a();

        a() {
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        if (this.f63729d) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.clearFlags(2);
            }
            new Handler().postDelayed(new C1245b(this), 300);
        }
        return layoutInflater.inflate(R.layout.v3_dialog_plan_details, viewGroup, false);
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.a.b$b  reason: collision with other inner class name */
    static final class C1245b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63732a;

        C1245b(b bVar) {
            this.f63732a = bVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f63732a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r1 = r1.getString("title");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r6 = "view"
            kotlin.g.b.k.c(r5, r6)
            int r6 = net.one97.paytm.recharge.R.id.title
            android.view.View r6 = r5.findViewById(r6)
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
            if (r6 == 0) goto L_0x00d2
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.os.Bundle r1 = r4.getArguments()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0026
            java.lang.String r3 = "title"
            java.lang.String r1 = r1.getString(r3)
            if (r1 == 0) goto L_0x0026
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0029
        L_0x0026:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0029:
            r6.setText(r1)
            int r6 = net.one97.paytm.recharge.R.id.description
            android.view.View r6 = r5.findViewById(r6)
            if (r6 == 0) goto L_0x00cc
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.os.Bundle r0 = r4.getArguments()
            if (r0 == 0) goto L_0x0047
            java.lang.String r1 = "info.msg.1"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x0047
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x004a
        L_0x0047:
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x004a:
            r6.setText(r0)
            java.lang.CharSequence r0 = r6.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x005b
            r6.setVisibility(r1)
        L_0x005b:
            android.os.Bundle r6 = r4.getArguments()
            r0 = 0
            if (r6 == 0) goto L_0x0069
            java.lang.String r2 = "list.data"
            java.io.Serializable r6 = r6.getSerializable(r2)
            goto L_0x006a
        L_0x0069:
            r6 = r0
        L_0x006a:
            boolean r2 = r6 instanceof java.util.ArrayList
            if (r2 != 0) goto L_0x006f
            r6 = r0
        L_0x006f:
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r4.f63728c = r6
            int r6 = net.one97.paytm.recharge.R.id.plan_highlights
            android.view.View r6 = r5.findViewById(r6)
            if (r6 == 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            java.util.ArrayList<java.lang.String> r0 = r4.f63728c
            if (r0 == 0) goto L_0x00b5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x00b5
            r6.setVisibility(r1)
            androidx.recyclerview.widget.GridLayoutManager r0 = new androidx.recyclerview.widget.GridLayoutManager
            android.content.Context r1 = r5.getContext()
            java.util.ArrayList<java.lang.String> r3 = r4.f63728c
            if (r3 == 0) goto L_0x009f
            int r3 = r3.size()
            if (r3 != r2) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r2 = 2
        L_0x00a0:
            r0.<init>(r1, r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r6.setLayoutManager(r0)
            net.one97.paytm.recharge.common.a.i r0 = new net.one97.paytm.recharge.common.a.i
            r1 = r4
            net.one97.paytm.recharge.common.e.g r1 = (net.one97.paytm.recharge.common.e.g) r1
            r0.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r6.setAdapter(r0)
        L_0x00b5:
            int r6 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r5 = r5.findViewById(r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r6 = r4
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
            return
        L_0x00c4:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView"
            r5.<init>(r6)
            throw r5
        L_0x00cc:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        L_0x00d2:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.a.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public int getItemCount() {
        ArrayList<String> arrayList = this.f63728c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void onClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.positive_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            DialogInterface.OnClickListener onClickListener2 = this.f63727b;
            if (onClickListener2 != null) {
                onClickListener2.onClick(getDialog(), -1);
            }
        } else {
            int i3 = R.id.negative_button;
            if (!(valueOf == null || valueOf.intValue() != i3 || (onClickListener = this.f63727b) == null)) {
                onClickListener.onClick(getDialog(), -2);
            }
        }
        dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f63726a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f63726a = null;
        this.f63727b = null;
        this.f63728c = null;
        HashMap hashMap = this.f63730e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
