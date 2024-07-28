package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.b;

public class g extends b {
    public Dialog onCreateDialog(Bundle bundle) {
        return new f(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i2) {
        if (dialog instanceof f) {
            f fVar = (f) dialog;
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            fVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i2);
    }
}
