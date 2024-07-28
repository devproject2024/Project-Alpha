package androidx.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.b;
import androidx.preference.DialogPreference;

public abstract class f extends b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private DialogPreference f30846a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f30847b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f30848c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f30849d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f30850e;

    /* renamed from: f  reason: collision with root package name */
    private int f30851f;

    /* renamed from: g  reason: collision with root package name */
    private BitmapDrawable f30852g;

    /* renamed from: h  reason: collision with root package name */
    private int f30853h;

    /* access modifiers changed from: protected */
    public void a(c.a aVar) {
    }

    public abstract void a(boolean z);

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.a) {
            DialogPreference.a aVar = (DialogPreference.a) targetFragment;
            getArguments().getString("key");
            if (bundle == null) {
                this.f30846a = (DialogPreference) aVar.a();
                this.f30847b = this.f30846a.f30763a;
                this.f30848c = this.f30846a.f30766d;
                this.f30849d = this.f30846a.f30767e;
                this.f30850e = this.f30846a.f30764b;
                this.f30851f = this.f30846a.f30768f;
                Drawable drawable = this.f30846a.f30765c;
                if (drawable == null || (drawable instanceof BitmapDrawable)) {
                    this.f30852g = (BitmapDrawable) drawable;
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                this.f30852g = new BitmapDrawable(getResources(), createBitmap);
                return;
            }
            this.f30847b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f30848c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f30849d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f30850e = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f30851f = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f30852g = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f30847b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f30848c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f30849d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f30850e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f30851f);
        BitmapDrawable bitmapDrawable = this.f30852g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f30853h = -2;
        c.a b2 = new c.a(activity).a(this.f30847b).a((Drawable) this.f30852g).a(this.f30848c, (DialogInterface.OnClickListener) this).b(this.f30849d, (DialogInterface.OnClickListener) this);
        int i2 = this.f30851f;
        View view = null;
        if (i2 != 0) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) null);
        }
        if (view != null) {
            a(view);
            b2.a(view);
        } else {
            b2.b(this.f30850e);
        }
        a(b2);
        c a2 = b2.a();
        if (a()) {
            a2.getWindow().setSoftInputMode(5);
        }
        return a2;
    }

    public final DialogPreference b() {
        if (this.f30846a == null) {
            getArguments().getString("key");
            this.f30846a = (DialogPreference) ((DialogPreference.a) getTargetFragment()).a();
        }
        return this.f30846a;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.f30850e;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (findViewById.getVisibility() != i2) {
                findViewById.setVisibility(i2);
            }
        }
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f30853h = i2;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a(this.f30853h == -1);
    }
}
