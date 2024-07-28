package com.alipay.mobile.nebulacore.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import com.alipay.mobile.nebulacore.R;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;

public class H5Dialog {
    private static final int BUTTON_BOTTOM = 9;
    /* access modifiers changed from: private */
    public AlertDialog mAlertDialog;
    /* access modifiers changed from: private */
    public Drawable mBackgroundDrawable;
    /* access modifiers changed from: private */
    public int mBackgroundResId;
    private Builder mBuilder;
    /* access modifiers changed from: private */
    public boolean mCancel;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mHasShow = false;
    /* access modifiers changed from: private */
    public LinearLayout.LayoutParams mLayoutParams;
    /* access modifiers changed from: private */
    public CharSequence mMessage;
    /* access modifiers changed from: private */
    public View mMessageContentView;
    /* access modifiers changed from: private */
    public int mMessageResId;
    /* access modifiers changed from: private */
    public Button mNegativeButton;
    /* access modifiers changed from: private */
    public DialogInterface.OnDismissListener mOnDismissListener;
    /* access modifiers changed from: private */
    public Button mPositiveButton;
    /* access modifiers changed from: private */
    public CharSequence mTitle;
    /* access modifiers changed from: private */
    public int mTitleResId;
    /* access modifiers changed from: private */
    public View mView;
    private EditText promptEdit;

    public H5Dialog(Context context) {
        this.mContext = context;
    }

    private static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                View view = adapter.getView(i3, (View) null, listView);
                view.measure(0, 0);
                i2 += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i2 + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }

    public void show() {
        if (!this.mHasShow) {
            this.mBuilder = new Builder();
        } else {
            this.mAlertDialog.show();
        }
        this.mHasShow = true;
    }

    public H5Dialog setView(View view) {
        this.mView = view;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setView(view);
        }
        return this;
    }

    public H5Dialog setContentView(View view) {
        this.mMessageContentView = view;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setContentView(this.mMessageContentView);
        }
        return this;
    }

    public H5Dialog setBackground(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setBackground(this.mBackgroundDrawable);
        }
        return this;
    }

    public H5Dialog setBackgroundResource(int i2) {
        this.mBackgroundResId = i2;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setBackgroundResource(this.mBackgroundResId);
        }
        return this;
    }

    public void dismiss() {
        this.mAlertDialog.dismiss();
    }

    public H5Dialog setTitle(int i2) {
        this.mTitleResId = i2;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    public H5Dialog setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setTitle(charSequence);
        }
        return this;
    }

    public H5Dialog setMessage(int i2) {
        this.mMessageResId = i2;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setMessage(i2);
        }
        return this;
    }

    public H5Dialog setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setMessage(charSequence);
        }
        return this;
    }

    public H5Dialog setPositiveButton(int i2, View.OnClickListener onClickListener) {
        this.mPositiveButton = new Button(this.mContext);
        this.mPositiveButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mPositiveButton.setBackgroundResource(R.drawable.h5_dialog_button);
        this.mPositiveButton.setTextColor(Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 35, Constants.ACTION_NB_NEXT_BTN_CLICKED, 242));
        this.mPositiveButton.setText(i2);
        this.mPositiveButton.setGravity(17);
        this.mPositiveButton.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(H5DimensionUtil.dip2px(this.mContext, 2.0f), 0, H5DimensionUtil.dip2px(this.mContext, 12.0f), H5DimensionUtil.dip2px(this.mContext, 9.0f));
        this.mPositiveButton.setLayoutParams(layoutParams);
        this.mPositiveButton.setOnClickListener(onClickListener);
        if (isLollipop()) {
            this.mPositiveButton.setBackgroundResource(17170445);
        }
        return this;
    }

    public H5Dialog setPositiveButton(String str, View.OnClickListener onClickListener) {
        this.mPositiveButton = new Button(this.mContext);
        this.mPositiveButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mPositiveButton.setBackgroundResource(R.drawable.h5_dialog_button);
        this.mPositiveButton.setTextColor(Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 35, Constants.ACTION_NB_NEXT_BTN_CLICKED, 242));
        this.mPositiveButton.setText(str);
        this.mPositiveButton.setGravity(17);
        this.mPositiveButton.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(H5DimensionUtil.dip2px(this.mContext, 2.0f), 0, H5DimensionUtil.dip2px(this.mContext, 12.0f), H5DimensionUtil.dip2px(this.mContext, 9.0f));
        this.mPositiveButton.setLayoutParams(layoutParams);
        this.mPositiveButton.setOnClickListener(onClickListener);
        if (isLollipop()) {
            this.mPositiveButton.setBackgroundResource(17170445);
        }
        return this;
    }

    public H5Dialog setNegativeButton(int i2, View.OnClickListener onClickListener) {
        this.mNegativeButton = new Button(this.mContext);
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mNegativeButton.setLayoutParams(this.mLayoutParams);
        this.mNegativeButton.setBackgroundResource(R.drawable.h5_dialog_button);
        this.mNegativeButton.setText(i2);
        this.mNegativeButton.setTextColor(Color.argb(Constants.EASY_PAY_MAXIMIZE_ASSIST, 0, 0, 0));
        this.mNegativeButton.setTextSize(14.0f);
        this.mNegativeButton.setGravity(17);
        this.mNegativeButton.setOnClickListener(onClickListener);
        if (isLollipop()) {
            this.mNegativeButton.setBackgroundResource(17170445);
        }
        return this;
    }

    public H5Dialog setPrompt(int i2, View.OnClickListener onClickListener) {
        this.promptEdit = new EditText(this.mContext);
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.promptEdit.setLayoutParams(this.mLayoutParams);
        this.promptEdit.setText(i2);
        this.promptEdit.setTextSize(14.0f);
        this.promptEdit.setGravity(17);
        this.promptEdit.setOnClickListener(onClickListener);
        if (isLollipop()) {
            this.promptEdit.setBackgroundResource(17170445);
        }
        return this;
    }

    public H5Dialog setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.mNegativeButton = new Button(this.mContext);
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mNegativeButton.setLayoutParams(this.mLayoutParams);
        this.mNegativeButton.setBackgroundResource(R.drawable.h5_dialog_button);
        this.mNegativeButton.setText(str);
        this.mNegativeButton.setTextColor(Color.argb(Constants.EASY_PAY_MAXIMIZE_ASSIST, 0, 0, 0));
        this.mNegativeButton.setTextSize(14.0f);
        this.mNegativeButton.setGravity(17);
        this.mNegativeButton.setOnClickListener(onClickListener);
        if (isLollipop()) {
            this.mNegativeButton.setBackgroundResource(17170445);
        }
        return this;
    }

    public H5Dialog setCanceledOnTouchOutside(boolean z) {
        this.mCancel = z;
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setCanceledOnTouchOutside(this.mCancel);
        }
        return this;
    }

    public H5Dialog setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    class Builder {
        /* access modifiers changed from: private */
        public Window mAlertDialogWindow;
        private LinearLayout mButtonLayout;
        private TextView mMessageView;
        private TextView mTitleView;

        private Builder() {
            AlertDialog unused = H5Dialog.this.mAlertDialog = new AlertDialog.Builder(H5Dialog.this.mContext).create();
            H5Dialog.this.mAlertDialog.show();
            H5Dialog.this.mAlertDialog.getWindow().clearFlags(131080);
            H5Dialog.this.mAlertDialog.getWindow().setSoftInputMode(4);
            this.mAlertDialogWindow = H5Dialog.this.mAlertDialog.getWindow();
            View inflate = LayoutInflater.from(H5Dialog.this.mContext).inflate(R.layout.h5_dialog, (ViewGroup) null);
            inflate.setFocusable(true);
            inflate.setFocusableInTouchMode(true);
            this.mAlertDialogWindow.setBackgroundDrawableResource(R.drawable.h5_dialog_window);
            this.mAlertDialogWindow.setContentView(inflate);
            this.mTitleView = (TextView) this.mAlertDialogWindow.findViewById(R.id.title);
            this.mMessageView = (TextView) this.mAlertDialogWindow.findViewById(R.id.h5_message);
            this.mMessageView.setMovementMethod(ScrollingMovementMethod.getInstance());
            this.mButtonLayout = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_buttonLayout);
            if (H5Dialog.this.mView != null) {
                LinearLayout linearLayout = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_contentView);
                linearLayout.removeAllViews();
                linearLayout.addView(H5Dialog.this.mView);
            }
            if (H5Dialog.this.mTitleResId != 0) {
                setTitle(H5Dialog.this.mTitleResId);
            }
            if (H5Dialog.this.mTitle != null) {
                setTitle(H5Dialog.this.mTitle);
            }
            if (H5Dialog.this.mTitle == null && H5Dialog.this.mTitleResId == 0) {
                this.mTitleView.setVisibility(8);
            }
            if (H5Dialog.this.mMessageResId != 0) {
                setMessage(H5Dialog.this.mMessageResId);
            }
            if (H5Dialog.this.mMessage != null) {
                setMessage(H5Dialog.this.mMessage);
            }
            if (H5Dialog.this.mPositiveButton != null) {
                this.mButtonLayout.addView(H5Dialog.this.mPositiveButton);
            }
            if (!(H5Dialog.this.mLayoutParams == null || H5Dialog.this.mNegativeButton == null)) {
                if (this.mButtonLayout.getChildCount() > 0) {
                    H5Dialog.this.mLayoutParams.setMargins(H5DimensionUtil.dip2px(H5Dialog.this.mContext, 12.0f), 0, 0, H5DimensionUtil.dip2px(H5Dialog.this.mContext, 9.0f));
                    H5Dialog.this.mNegativeButton.setLayoutParams(H5Dialog.this.mLayoutParams);
                    this.mButtonLayout.addView(H5Dialog.this.mNegativeButton, 1);
                } else {
                    H5Dialog.this.mNegativeButton.setLayoutParams(H5Dialog.this.mLayoutParams);
                    this.mButtonLayout.addView(H5Dialog.this.mNegativeButton);
                }
            }
            if (H5Dialog.this.mBackgroundResId != 0) {
                ((LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_material_background)).setBackgroundResource(H5Dialog.this.mBackgroundResId);
            }
            if (H5Dialog.this.mBackgroundDrawable != null) {
                LinearLayout linearLayout2 = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_material_background);
                if (Build.VERSION.SDK_INT >= 16) {
                    linearLayout2.setBackground(H5Dialog.this.mBackgroundDrawable);
                }
            }
            if (H5Dialog.this.mMessageContentView != null) {
                setContentView(H5Dialog.this.mMessageContentView);
            }
            H5Dialog.this.mAlertDialog.setCanceledOnTouchOutside(H5Dialog.this.mCancel);
            if (H5Dialog.this.mOnDismissListener != null) {
                H5Dialog.this.mAlertDialog.setOnDismissListener(H5Dialog.this.mOnDismissListener);
            }
        }

        public void setTitle(int i2) {
            this.mTitleView.setText(i2);
        }

        public void setTitle(CharSequence charSequence) {
            this.mTitleView.setText(charSequence);
        }

        public void setMessage(int i2) {
            this.mMessageView.setText(i2);
        }

        public void setMessage(CharSequence charSequence) {
            this.mMessageView.setText(charSequence);
        }

        public void setPositiveButton(String str, View.OnClickListener onClickListener) {
            Button button = new Button(H5Dialog.this.mContext);
            button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            button.setBackgroundResource(R.drawable.h5_dialog_card);
            button.setTextColor(Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 35, Constants.ACTION_NB_NEXT_BTN_CLICKED, 242));
            button.setText(str);
            button.setGravity(17);
            button.setTextSize(14.0f);
            button.setPadding(H5DimensionUtil.dip2px(H5Dialog.this.mContext, 12.0f), 0, H5DimensionUtil.dip2px(H5Dialog.this.mContext, 32.0f), H5DimensionUtil.dip2px(H5Dialog.this.mContext, 9.0f));
            button.setOnClickListener(onClickListener);
            this.mButtonLayout.addView(button);
        }

        public void setNegativeButton(String str, View.OnClickListener onClickListener) {
            Button button = new Button(H5Dialog.this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            button.setLayoutParams(layoutParams);
            button.setBackgroundResource(R.drawable.h5_dialog_card);
            button.setText(str);
            button.setTextColor(Color.argb(Constants.EASY_PAY_MAXIMIZE_ASSIST, 0, 0, 0));
            button.setTextSize(14.0f);
            button.setGravity(17);
            button.setPadding(0, 0, 0, H5DimensionUtil.dip2px(H5Dialog.this.mContext, 8.0f));
            button.setOnClickListener(onClickListener);
            if (this.mButtonLayout.getChildCount() > 0) {
                layoutParams.setMargins(20, 0, 10, H5DimensionUtil.dip2px(H5Dialog.this.mContext, 9.0f));
                button.setLayoutParams(layoutParams);
                this.mButtonLayout.addView(button, 1);
                return;
            }
            button.setLayoutParams(layoutParams);
            this.mButtonLayout.addView(button);
        }

        public void setView(View view) {
            LinearLayout linearLayout = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_contentView);
            linearLayout.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    Builder.this.mAlertDialogWindow.setSoftInputMode(5);
                    ((InputMethodManager) H5Dialog.this.mContext.getSystemService("input_method")).toggleSoftInput(2, 1);
                }
            });
            linearLayout.addView(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (viewGroup.getChildAt(i2) instanceof EditText) {
                        EditText editText = (EditText) viewGroup.getChildAt(i2);
                        editText.setFocusable(true);
                        editText.requestFocus();
                        editText.setFocusableInTouchMode(true);
                    }
                }
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    if (viewGroup.getChildAt(i3) instanceof AutoCompleteTextView) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewGroup.getChildAt(i3);
                        autoCompleteTextView.setFocusable(true);
                        autoCompleteTextView.requestFocus();
                        autoCompleteTextView.setFocusableInTouchMode(true);
                    }
                }
            }
        }

        public void setContentView(View view) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (view instanceof ListView) {
                H5Dialog.setListViewHeightBasedOnChildren((ListView) view);
            }
            LinearLayout linearLayout = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_message_content_view);
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(view);
            }
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                if (linearLayout.getChildAt(i2) instanceof AutoCompleteTextView) {
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) linearLayout.getChildAt(i2);
                    autoCompleteTextView.setFocusable(true);
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.setFocusableInTouchMode(true);
                }
            }
        }

        public void setBackground(Drawable drawable) {
            LinearLayout linearLayout = (LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_material_background);
            if (Build.VERSION.SDK_INT >= 16) {
                linearLayout.setBackground(drawable);
            }
        }

        public void setBackgroundResource(int i2) {
            ((LinearLayout) this.mAlertDialogWindow.findViewById(R.id.h5_material_background)).setBackgroundResource(i2);
        }

        public void setCanceledOnTouchOutside(boolean z) {
            H5Dialog.this.mAlertDialog.setCanceledOnTouchOutside(z);
        }
    }
}
