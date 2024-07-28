package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;

@Deprecated
public final class am {
    @Deprecated
    public static al a(Fragment fragment) {
        return new al(fragment);
    }

    @Deprecated
    public static al a(FragmentActivity fragmentActivity) {
        return new al(fragmentActivity);
    }

    @Deprecated
    public static al a(Fragment fragment, al.b bVar) {
        if (bVar == null) {
            bVar = fragment.getDefaultViewModelProviderFactory();
        }
        return new al(fragment.getViewModelStore(), bVar);
    }

    @Deprecated
    public static al a(FragmentActivity fragmentActivity, al.b bVar) {
        if (bVar == null) {
            bVar = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new al(fragmentActivity.getViewModelStore(), bVar);
    }
}
