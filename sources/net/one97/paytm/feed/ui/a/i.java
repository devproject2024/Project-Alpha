package net.one97.paytm.feed.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.i.f;

public abstract class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f34864a;

    /* renamed from: c  reason: collision with root package name */
    Context f34865c;

    public abstract int a();

    public abstract void a(View view);

    public void b() {
        HashMap hashMap = this.f34864a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f34865c = context;
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new a(requireContext(), getTheme());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(a(), viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        a(view);
    }
}
