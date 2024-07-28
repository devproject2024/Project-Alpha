package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.b;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;

public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    a f14508a = new a();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public Bundle f14509b;

    /* renamed from: c  reason: collision with root package name */
    DialogInterface.OnClickListener f14510c;

    /* renamed from: d  reason: collision with root package name */
    private int f14511d;

    /* renamed from: e  reason: collision with root package name */
    private int f14512e;

    /* renamed from: f  reason: collision with root package name */
    private int f14513f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f14514g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f14515h;

    /* renamed from: i  reason: collision with root package name */
    private Context f14516i;
    /* access modifiers changed from: private */
    public boolean j = true;
    /* access modifiers changed from: private */
    public final DialogInterface.OnClickListener k = new DialogInterface.OnClickListener() {
        public final void onClick(final DialogInterface dialogInterface, int i2) {
            if (i2 == -2 && Build.VERSION.SDK_INT >= 21) {
                g.a(e.this.getActivity(), e.this.f14509b, (Runnable) new Runnable() {
                    public final void run() {
                        e.this.onCancel(dialogInterface);
                    }
                });
            }
        }
    };

    private static boolean a(int i2, int i3) {
        if (i2 == 0 && i3 == 1) {
            return false;
        }
        if (i2 == 1 && i3 == 2) {
            return true;
        }
        if (i2 == 2 && i3 == 1) {
            return true;
        }
        if (i2 != 1 || i3 == 3) {
        }
        return false;
    }

    static e a() {
        return new e();
    }

    final class a extends Handler {
        a() {
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    e.a(e.this, (CharSequence) message.obj);
                    return;
                case 2:
                    e.b(e.this, (CharSequence) message.obj);
                    return;
                case 3:
                    e.c(e.this, (CharSequence) message.obj);
                    return;
                case 4:
                    e.a(e.this);
                    return;
                case 5:
                    e.this.b();
                    return;
                case 6:
                    Context context = e.this.getContext();
                    boolean unused = e.this.j = context != null && g.a(context, Build.MODEL);
                    return;
                default:
                    return;
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        if (bundle != null && this.f14509b == null) {
            this.f14509b = bundle.getBundle("SavedBundle");
        }
        c.a aVar = new c.a(getContext());
        aVar.a(this.f14509b.getCharSequence("title"));
        View inflate = LayoutInflater.from(aVar.f1095a.f1016a).inflate(R.layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_subtitle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fingerprint_description);
        CharSequence charSequence2 = this.f14509b.getCharSequence("subtitle");
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
        CharSequence charSequence3 = this.f14509b.getCharSequence(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        if (TextUtils.isEmpty(charSequence3)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence3);
        }
        this.f14514g = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        this.f14515h = (TextView) inflate.findViewById(R.id.fingerprint_error);
        if (c()) {
            charSequence = getString(R.string.confirm_device_credential_password);
        } else {
            charSequence = this.f14509b.getCharSequence("negative_text");
        }
        aVar.b(charSequence, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (e.this.c()) {
                    e.this.k.onClick(dialogInterface, i2);
                } else if (e.this.f14510c != null) {
                    e.this.f14510c.onClick(dialogInterface, i2);
                }
            }
        });
        aVar.a(inflate);
        c a2 = aVar.a();
        a2.setCanceledOnTouchOutside(false);
        return a2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("SavedBundle", this.f14509b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14516i = getContext();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f14511d = a(16844099);
        } else {
            this.f14511d = androidx.core.content.b.c(this.f14516i, R.color.biometric_error_color);
        }
        this.f14512e = a(16842808);
    }

    public void onResume() {
        super.onResume();
        this.f14513f = 0;
        b(1);
    }

    public void onPause() {
        super.onPause();
        this.f14508a.removeCallbacksAndMessages((Object) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        f fVar = (f) getFragmentManager().c("FingerprintHelperFragment");
        if (fVar != null) {
            fVar.a(1);
        }
    }

    private int a(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f14516i.getTheme().resolveAttribute(i2, typedValue, true);
        TypedArray obtainStyledAttributes = getActivity().obtainStyledAttributes(typedValue.data, new int[]{i2});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (getFragmentManager() != null) {
            dismissAllowingStateLoss();
        }
    }

    static int a(Context context) {
        if (context == null || !g.a(context, Build.MODEL)) {
            return H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return this.f14509b.getBoolean("allow_device_credential");
    }

    private Drawable b(int i2, int i3) {
        int i4;
        if (i2 == 0 && i3 == 1) {
            i4 = R.drawable.fingerprint_dialog_fp_to_error;
        } else if (i2 == 1 && i3 == 2) {
            i4 = R.drawable.fingerprint_dialog_fp_to_error;
        } else if (i2 == 2 && i3 == 1) {
            i4 = R.drawable.fingerprint_dialog_error_to_fp;
        } else if (i2 != 1 || i3 != 3) {
            return null;
        } else {
            i4 = R.drawable.fingerprint_dialog_error_to_fp;
        }
        return this.f14516i.getDrawable(i4);
    }

    private void b(int i2) {
        Drawable b2;
        if (this.f14514g != null && Build.VERSION.SDK_INT >= 23 && (b2 = b(this.f14513f, i2)) != null) {
            AnimatedVectorDrawable animatedVectorDrawable = b2 instanceof AnimatedVectorDrawable ? (AnimatedVectorDrawable) b2 : null;
            this.f14514g.setImageDrawable(b2);
            if (animatedVectorDrawable != null && a(this.f14513f, i2)) {
                animatedVectorDrawable.start();
            }
            this.f14513f = i2;
        }
    }

    static /* synthetic */ void a(e eVar, CharSequence charSequence) {
        eVar.b(2);
        eVar.f14508a.removeMessages(4);
        TextView textView = eVar.f14515h;
        if (textView != null) {
            textView.setTextColor(eVar.f14511d);
            eVar.f14515h.setText(charSequence);
        }
        a aVar = eVar.f14508a;
        aVar.sendMessageDelayed(aVar.obtainMessage(4), 2000);
    }

    static /* synthetic */ void b(e eVar, CharSequence charSequence) {
        eVar.b(2);
        eVar.f14508a.removeMessages(4);
        TextView textView = eVar.f14515h;
        if (textView != null) {
            textView.setTextColor(eVar.f14511d);
            eVar.f14515h.setText(charSequence);
        }
        a aVar = eVar.f14508a;
        aVar.sendMessageDelayed(aVar.obtainMessage(3), (long) a(eVar.f14516i));
    }

    static /* synthetic */ void c(e eVar, CharSequence charSequence) {
        if (eVar.j) {
            eVar.b();
        } else {
            TextView textView = eVar.f14515h;
            if (textView != null) {
                textView.setTextColor(eVar.f14511d);
                if (charSequence != null) {
                    eVar.f14515h.setText(charSequence);
                } else {
                    eVar.f14515h.setText(R.string.fingerprint_error_lockout);
                }
            }
            eVar.f14508a.postDelayed(new Runnable() {
                public final void run() {
                    e.this.b();
                }
            }, (long) a(eVar.f14516i));
        }
        eVar.j = true;
    }

    static /* synthetic */ void a(e eVar) {
        eVar.b(1);
        TextView textView = eVar.f14515h;
        if (textView != null) {
            textView.setTextColor(eVar.f14512e);
            eVar.f14515h.setText(eVar.f14516i.getString(R.string.fingerprint_dialog_touch_sensor));
        }
    }
}
