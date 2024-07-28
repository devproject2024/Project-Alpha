package com.paytm.business.merchantprofile.common.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.c;
import com.business.common_module.utilities.LogUtility;
import com.paytm.business.merchantprofile.R;

public class DialogUtility {
    public static final String LOG_TAG = "DialogUtility";
    public static boolean isDialogShowing;

    public static ProgressDialog showProgressDialog(Context context, String str, boolean z) {
        if (context == null) {
            return null;
        }
        ProgressDialog progressDialog = new ProgressDialog(context);
        try {
            progressDialog.setProgressStyle(0);
            progressDialog.setMessage(str);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(z);
            progressDialog.show();
            return progressDialog;
        } catch (IllegalArgumentException e2) {
            LogUtility.e(LOG_TAG, "Error showing progress dialog");
            LogUtility.printStackTrace(e2);
            return null;
        } catch (Exception e3) {
            LogUtility.e(LOG_TAG, "Error showing progress dialog");
            LogUtility.printStackTrace(e3);
            return null;
        }
    }

    public static ProgressDialog showProgressDialog(Context context, String str) {
        return showProgressDialog(context, str, false);
    }

    public static void showDialog(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        try {
            c.a aVar = new c.a(context);
            if (str != null) {
                aVar.a((CharSequence) str);
            }
            if (str2 != null) {
                aVar.b((CharSequence) str2);
            }
            if (onClickListener != null) {
                aVar.a(false);
            }
            aVar.a((CharSequence) context.getString(R.string.pr_ok), onClickListener);
            aVar.b();
        } catch (Exception e2) {
            LogUtility.e(LOG_TAG, "error showing dialog");
            LogUtility.printStackTrace(e2);
        }
    }

    public static void showDialog(Context context, String str, String str2) {
        try {
            c.a aVar = new c.a(context);
            aVar.a((CharSequence) str);
            aVar.b((CharSequence) str2);
            aVar.a((CharSequence) context.getString(R.string.pr_ok), (DialogInterface.OnClickListener) null);
            aVar.b();
        } catch (Exception e2) {
            LogUtility.e(LOG_TAG, "error showing dialog");
            LogUtility.printStackTrace(e2);
        }
    }

    public static void showDialog(Context context, String str) {
        try {
            c.a aVar = new c.a(context);
            aVar.b((CharSequence) str);
            aVar.a((CharSequence) context.getString(R.string.pr_ok), (DialogInterface.OnClickListener) null);
            aVar.b();
        } catch (Exception e2) {
            LogUtility.e(LOG_TAG, "error showing dialog");
            LogUtility.printStackTrace(e2);
        }
    }

    public static void showAlert(Context context, String str, String str2) {
        if (!isDialogShowing && !((Activity) context).isFinishing()) {
            c.a aVar = new c.a(context);
            aVar.a((CharSequence) str).b((CharSequence) str2).a(false);
            aVar.a((CharSequence) context.getResources().getString(R.string.pr_ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    DialogUtility.isDialogShowing = false;
                }
            });
            aVar.b();
            isDialogShowing = true;
        }
    }

    public static class DialogDetail implements Parcelable {
        public static final Parcelable.Creator<DialogDetail> CREATOR = new Parcelable.Creator<DialogDetail>() {
            public final DialogDetail createFromParcel(Parcel parcel) {
                return new DialogDetail(parcel);
            }

            public final DialogDetail[] newArray(int i2) {
                return new DialogDetail[i2];
            }
        };
        public int failButtonCount;
        public String firstButtonText;
        public String message;
        public String secondButtonText;
        public boolean status;
        public int successButtonCount;
        public String title;

        public int describeContents() {
            return 0;
        }

        public DialogDetail(String str, String str2, String str3, String str4, boolean z, int i2, int i3) {
            this.title = str;
            this.message = str2;
            this.firstButtonText = str3;
            this.secondButtonText = str4;
            this.status = z;
            this.successButtonCount = i2;
            this.failButtonCount = i3;
        }

        public DialogDetail(Parcel parcel) {
            this.title = parcel.readString();
            this.message = parcel.readString();
            this.firstButtonText = parcel.readString();
            this.secondButtonText = parcel.readString();
            this.failButtonCount = parcel.readInt();
            this.successButtonCount = parcel.readInt();
            this.status = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.title);
            parcel.writeString(this.message);
            parcel.writeString(this.firstButtonText);
            parcel.writeString(this.secondButtonText);
            parcel.writeInt(this.failButtonCount);
            parcel.writeInt(this.successButtonCount);
            parcel.writeByte(this.status ? (byte) 1 : 0);
        }

        public String getTitle() {
            return this.title;
        }

        public String getMessage() {
            return this.message;
        }

        public boolean isStatus() {
            return this.status;
        }
    }
}
