package androidx.databinding.a;

import android.widget.CompoundButton;

public final class a {
    public static void a(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }
}
