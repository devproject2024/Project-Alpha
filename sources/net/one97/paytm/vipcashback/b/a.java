package net.one97.paytm.vipcashback.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.i.g;
import net.one97.paytm.vipcashback.R;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public kotlin.g.a.a<x> f20703a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f20704b;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.voucher_copy_dialog, (ViewGroup) null, false);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        String string = getString(R.string.voucher_copied_info);
        k.a((Object) string, "getString(R.string.voucher_copied_info)");
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.message);
        k.a((Object) roboTextView, "view.message");
        roboTextView.setText(string);
        ((RoboTextView) view.findViewById(R.id.ok)).setOnClickListener(new C0378a(this));
        ((RoboTextView) view.findViewById(R.id.cancel)).setOnClickListener(new b(this));
    }

    /* renamed from: net.one97.paytm.vipcashback.b.a$a  reason: collision with other inner class name */
    static final class C0378a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20705a;

        C0378a(a aVar) {
            this.f20705a = aVar;
        }

        public final void onClick(View view) {
            this.f20705a.dismiss();
            kotlin.g.a.a a2 = this.f20705a.f20703a;
            if (a2 != null) {
                a2.invoke();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20706a;

        b(a aVar) {
            this.f20706a = aVar;
        }

        public final void onClick(View view) {
            this.f20706a.dismiss();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        if (onCreateDialog != null) {
            try {
                onCreateDialog.getWindow().setLayout(-1, -1);
                onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            } catch (Exception unused) {
            }
        }
        return onCreateDialog;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20704b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
