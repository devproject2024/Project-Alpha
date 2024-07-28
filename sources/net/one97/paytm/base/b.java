package net.one97.paytm.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import java.util.HashMap;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.base.a;
import net.one97.paytm.base.d;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.R;

public class b extends h implements a, d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f49495a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private Context f49496b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Runnable> f49497c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private BaseFragment$reloginReceiver$1 f49498e = new BaseFragment$reloginReceiver$1(this);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f49499f;

    public View a(int i2) {
        if (this.f49499f == null) {
            this.f49499f = new HashMap();
        }
        View view = (View) this.f49499f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f49499f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a(String str) {
    }

    public void c() {
        HashMap hashMap = this.f49499f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void c(String str, Runnable runnable) {
        k.c(str, "permission");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "loader");
        d.b.a(lottieAnimationView);
    }

    public static void a(String str, String str2, String str3, String str4, Context context, String str5) {
        k.c(str, "eventCategory");
        k.c(str2, "event_action");
        k.c(str3, "event_label");
        k.c(str4, "event_value");
        k.c(context, "context");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        a.C0880a.a(str, str2, str3, str4, context, str5);
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "loader");
        d.b.b(lottieAnimationView);
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        this.f49496b = context;
        super.onAttach(context);
    }

    public Context getContext() {
        Context context = this.f49496b;
        return context == null ? super.getContext() : context;
    }

    public final Context b() {
        Context context = this.f49496b;
        if (context == null) {
            context = super.getContext();
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public final void a(String str, Runnable runnable) {
        k.c(str, "permission");
        if (b(str)) {
            runnable.run();
        } else if (isAdded()) {
            this.f49497c.put(str, runnable);
            requestPermissions(new String[]{str}, this.f49495a);
        }
    }

    private final boolean b(String str) {
        if (!s.a()) {
            return true;
        }
        Context context = getContext();
        if (context == null || androidx.core.content.b.a(context, str) != 0) {
            return false;
        }
        return true;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 == this.f49495a) {
            int length = strArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                String str = strArr[i3];
                int i5 = i4 + 1;
                if (this.f49497c.containsKey(str)) {
                    if (iArr[i4] == 0) {
                        Runnable runnable = this.f49497c.get(str);
                        if (runnable != null) {
                            runnable.run();
                        }
                        this.f49497c.remove(str);
                    } else {
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            k.a((Object) activity, "it");
                            if (!activity.isFinishing()) {
                                if (androidx.core.app.a.a((Activity) activity, str)) {
                                    c(str, this.f49497c.get(str));
                                } else {
                                    b(str, this.f49497c.get(str));
                                }
                            }
                        }
                    }
                }
                i3++;
                i4 = i5;
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void b(String str, Runnable runnable) {
        String str2;
        k.c(str, "permission");
        Context context = getContext();
        if (context != null) {
            String string = context.getString(R.string.need_permissions);
            int i2 = R.string.msg_permission;
            Object[] objArr = new Object[1];
            if (p.a(str, "android.permission.CAMERA", true)) {
                str2 = context.getString(R.string.camera);
                k.a((Object) str2, "context.getString(R.string.camera)");
            } else if (p.a(str, "android.permission.READ_EXTERNAL_STORAGE", true)) {
                str2 = context.getString(R.string.external_storage);
                k.a((Object) str2, "context.getString(R.string.external_storage)");
            } else {
                str2 = context.getString(R.string.msg_this);
                k.a((Object) str2, "context.getString(R.string.msg_this)");
            }
            objArr[0] = str2;
            k.c(context, "context");
            d.b.a(context, string, context.getString(i2, objArr), context.getString(R.string.go_to_settings), new a(this, str));
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f49501b;

        a(b bVar, String str) {
            this.f49500a = bVar;
            this.f49501b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f49500a.isAdded()) {
                b bVar = this.f49500a;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                FragmentActivity activity = this.f49500a.getActivity();
                intent.setData(Uri.fromParts("package", activity != null ? activity.getPackageName() : null, (String) null));
                bVar.startActivityForResult(intent, this.f49500a.f49495a);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != this.f49495a) {
            super.onActivityResult(i2, i3, intent);
            return;
        }
        Set<String> keySet = this.f49497c.keySet();
        k.a((Object) keySet, "permissionMap.keys");
        for (String str : keySet) {
            k.a((Object) str, "permission");
            if (b(str)) {
                Runnable runnable = this.f49497c.get(str);
                if (runnable != null) {
                    runnable.run();
                }
                this.f49497c.remove(str);
            }
        }
    }

    public final boolean a(int i2, NetworkCustomError networkCustomError, Bundle bundle, String str) {
        k.c(networkCustomError, "networkCustomError");
        if (getActivity() == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue() || !isAdded()) {
            return false;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("key_is_from_fragment", true);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        k.a((Object) activity2, "activity!!");
        Activity activity3 = activity2;
        k.c(activity3, "activity");
        k.c(networkCustomError, "networkCustomError");
        return a.C0880a.a(activity3, i2, networkCustomError, bundle, str);
    }

    public void onStart() {
        Context context = getContext();
        if (context != null) {
            androidx.localbroadcastmanager.a.a.a(context).a(this.f49498e, new IntentFilter("action_relogin_broadcast"));
        }
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        Context context = getContext();
        if (context != null) {
            androidx.localbroadcastmanager.a.a.a(context).a((BroadcastReceiver) this.f49498e);
        }
    }

    public final void a(kotlin.g.a.b<? super Activity, x> bVar) {
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            if (!activity.isFinishing() && !activity.isDestroyed() && isAdded()) {
                bVar.invoke(activity);
            }
        }
    }
}
