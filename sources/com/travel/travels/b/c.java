package com.travel.travels.b;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.a;
import com.travel.R;
import java.util.HashMap;
import net.one97.paytm.i.f;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f28483a;

    public void a() {
        HashMap hashMap = this.f28483a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public int getTheme() {
        return R.style.BottomSheetDialogThemeNew;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new a(requireContext(), getTheme());
    }
}
