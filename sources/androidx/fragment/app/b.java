package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.j;

public class b extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId = -1;
    private boolean mCancelable = true;
    private boolean mCreatingDialog;
    /* access modifiers changed from: private */
    public Dialog mDialog;
    private Runnable mDismissRunnable = new Runnable() {
        public final void run() {
            b.this.mOnDismissListener.onDismiss(b.this.mDialog);
        }
    };
    private boolean mDismissed;
    private Handler mHandler;
    private DialogInterface.OnCancelListener mOnCancelListener = new DialogInterface.OnCancelListener() {
        public final void onCancel(DialogInterface dialogInterface) {
            if (b.this.mDialog != null) {
                b bVar = b.this;
                bVar.onCancel(bVar.mDialog);
            }
        }
    };
    /* access modifiers changed from: private */
    public DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() {
        public final void onDismiss(DialogInterface dialogInterface) {
            if (b.this.mDialog != null) {
                b bVar = b.this;
                bVar.onDismiss(bVar.mDialog);
            }
        }
    };
    private boolean mShownByMe;
    private boolean mShowsDialog = true;
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mViewDestroyed;

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void setStyle(int i2, int i3) {
        this.mStyle = i2;
        int i4 = this.mStyle;
        if (i4 == 2 || i4 == 3) {
            this.mTheme = 16973913;
        }
        if (i3 != 0) {
            this.mTheme = i3;
        }
    }

    public void show(j jVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.b();
    }

    public int show(q qVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        qVar.a((Fragment) this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = qVar.b();
        return this.mBackStackId;
    }

    public void showNow(j jVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.d();
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.mDialog.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                j parentFragmentManager = getParentFragmentManager();
                int i2 = this.mBackStackId;
                if (i2 >= 0) {
                    parentFragmentManager.a((j.d) new j.e((String) null, i2, 1), false);
                    this.mBackStackId = -1;
                    return;
                }
                throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i2)));
            }
            q a2 = getParentFragmentManager().a();
            a2.a((Fragment) this);
            if (z) {
                a2.c();
            } else {
                a2.b();
            }
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    /* JADX INFO: finally extract failed */
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.mShowsDialog || this.mCreatingDialog) {
            return onGetLayoutInflater;
        }
        try {
            this.mCreatingDialog = true;
            this.mDialog = onCreateDialog(bundle);
            setupDialog(this.mDialog, this.mStyle);
            this.mCreatingDialog = false;
            return onGetLayoutInflater.cloneInContext(requireDialog().getContext());
        } catch (Throwable th) {
            this.mCreatingDialog = false;
            throw th;
        }
    }

    public void setupDialog(Dialog dialog, int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            dismissInternal(true, true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.mShowsDialog) {
            View view = getView();
            if (this.mDialog != null) {
                if (view != null) {
                    if (view.getParent() == null) {
                        this.mDialog.setContentView(view);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    this.mDialog.setOwnerActivity(activity);
                }
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnCancelListener(this.mOnCancelListener);
                this.mDialog.setOnDismissListener(this.mOnDismissListener);
                if (bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
                    this.mDialog.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, dialog.onSaveInstanceState());
        }
        int i2 = this.mStyle;
        if (i2 != 0) {
            bundle.putInt(SAVED_STYLE, i2);
        }
        int i3 = this.mTheme;
        if (i3 != 0) {
            bundle.putInt(SAVED_THEME, i3);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i4 = this.mBackStackId;
        if (i4 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i4);
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
        }
    }
}
