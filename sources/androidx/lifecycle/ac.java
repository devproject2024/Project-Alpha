package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.k;

public final class ac extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    a f3614a;

    interface a {
        void a();

        void b();
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(new b());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ac(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    static void a(Activity activity, k.a aVar) {
        if (activity instanceof u) {
            ((u) activity).a().a(aVar);
        } else if (activity instanceof q) {
            k lifecycle = ((q) activity).getLifecycle();
            if (lifecycle instanceof t) {
                ((t) lifecycle).a(aVar);
            }
        }
    }

    static ac b(Activity activity) {
        return (ac) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(k.a.ON_CREATE);
    }

    public final void onStart() {
        super.onStart();
        a aVar = this.f3614a;
        if (aVar != null) {
            aVar.a();
        }
        a(k.a.ON_START);
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.f3614a;
        if (aVar != null) {
            aVar.b();
        }
        a(k.a.ON_RESUME);
    }

    public final void onPause() {
        super.onPause();
        a(k.a.ON_PAUSE);
    }

    public final void onStop() {
        super.onStop();
        a(k.a.ON_STOP);
    }

    public final void onDestroy() {
        super.onDestroy();
        a(k.a.ON_DESTROY);
        this.f3614a = null;
    }

    private void a(k.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }

    static class b implements Application.ActivityLifecycleCallbacks {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        b() {
        }

        public final void onActivityPostCreated(Activity activity, Bundle bundle) {
            ac.a(activity, k.a.ON_CREATE);
        }

        public final void onActivityPostStarted(Activity activity) {
            ac.a(activity, k.a.ON_START);
        }

        public final void onActivityPostResumed(Activity activity) {
            ac.a(activity, k.a.ON_RESUME);
        }

        public final void onActivityPrePaused(Activity activity) {
            ac.a(activity, k.a.ON_PAUSE);
        }

        public final void onActivityPreStopped(Activity activity) {
            ac.a(activity, k.a.ON_STOP);
        }

        public final void onActivityPreDestroyed(Activity activity) {
            ac.a(activity, k.a.ON_DESTROY);
        }
    }
}
