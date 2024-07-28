package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.i.f;

public class ab extends f {
    public int getTheme() {
        return R.style.H4BottomSheetDialogTheme;
    }

    public /* synthetic */ Dialog onCreateDialog(Bundle bundle) {
        return new a(requireContext(), getTheme());
    }
}
