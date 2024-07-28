package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.h;
import kotlin.g.b.k;

public final class a {
    public static final h a(Fragment fragment) {
        k.c(fragment, "receiver$0");
        h a2 = NavHostFragment.a(fragment);
        k.a((Object) a2, "NavHostFragment.findNavController(this)");
        return a2;
    }
}
