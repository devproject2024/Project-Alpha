package d.a.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f45927a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f45928b;

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i2 = f45927a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void a(Activity activity, Bundle bundle) {
        Class<?> cls = f45928b;
        if (cls != null) {
            try {
                d.f45929a.f45926a.a().c(cls.newInstance());
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        }
        if (bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
            activity.finish();
        }
    }

    public static class a extends b implements DialogInterface.OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return c.a(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            c.a(getActivity(), getArguments());
        }
    }
}
