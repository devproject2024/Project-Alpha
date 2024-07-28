package com.business.merchant_payments.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public class MpNotificationItemViewBindingImpl extends MpNotificationItemViewBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final RoboTextView mboundView6;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.barrier, 7);
    }

    public MpNotificationItemViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    public MpNotificationItemViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[7], objArr[5], objArr[1], objArr[4], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.btnToggleSettings.setTag((Object) null);
        this.imgAudioAlert.setTag((Object) null);
        this.languageText.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        RoboTextView roboTextView = objArr[6];
        this.mboundView6 = roboTextView;
        roboTextView.setTag((Object) null);
        this.tvAudioAlert.setTag((Object) null);
        this.tvLanguage.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.isChecked == i2) {
            setIsChecked((Boolean) obj);
        } else if (BR.subtitle == i2) {
            setSubtitle((String) obj);
        } else if (BR.icon == i2) {
            setIcon((Drawable) obj);
        } else if (BR.title == i2) {
            setTitle((String) obj);
        } else if (BR.audioAlertView == i2) {
            setAudioAlertView((Boolean) obj);
        } else if (BR.checkChangeListener == i2) {
            setCheckChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        } else if (BR.onClickAction != i2) {
            return false;
        } else {
            setOnClickAction((View.OnClickListener) obj);
        }
        return true;
    }

    public void setIsChecked(Boolean bool) {
        this.mIsChecked = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.isChecked);
        super.requestRebind();
    }

    public void setSubtitle(String str) {
        this.mSubtitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.subtitle);
        super.requestRebind();
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.icon);
        super.requestRebind();
    }

    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }

    public void setAudioAlertView(Boolean bool) {
        this.mAudioAlertView = bool;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.audioAlertView);
        super.requestRebind();
    }

    public void setCheckChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.checkChangeListener);
        super.requestRebind();
    }

    public void setOnClickAction(View.OnClickListener onClickListener) {
        this.mOnClickAction = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.onClickAction);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r33 = this;
            r1 = r33
            monitor-enter(r33)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x017b }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x017b }
            monitor-exit(r33)     // Catch:{ all -> 0x017b }
            r0 = 0
            r6 = 0
            java.lang.Boolean r7 = r1.mIsChecked
            java.lang.String r8 = r1.mSubtitle
            android.graphics.drawable.Drawable r9 = r1.mIcon
            java.lang.String r10 = r1.mTitle
            java.lang.Boolean r11 = r1.mAudioAlertView
            android.widget.CompoundButton$OnCheckedChangeListener r12 = r1.mCheckChangeListener
            android.view.View$OnClickListener r13 = r1.mOnClickAction
            r14 = 145(0x91, double:7.16E-322)
            long r16 = r2 & r14
            r18 = 1024(0x400, double:5.06E-321)
            r20 = 129(0x81, double:6.37E-322)
            r22 = 0
            int r23 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00a9
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            long r16 = r2 & r20
            int r23 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x004c
            if (r7 == 0) goto L_0x0040
            r16 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r16
            r16 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2 | r16
            r16 = 32768(0x8000, double:1.61895E-319)
            goto L_0x004a
        L_0x0040:
            r16 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r16
            r16 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r16
            r16 = 16384(0x4000, double:8.0948E-320)
        L_0x004a:
            long r2 = r2 | r16
        L_0x004c:
            long r16 = r2 & r14
            int r23 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x005b
            if (r7 == 0) goto L_0x0059
            r16 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r16
            goto L_0x005b
        L_0x0059:
            long r2 = r2 | r18
        L_0x005b:
            long r16 = r2 & r20
            int r23 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00aa
            if (r7 == 0) goto L_0x006c
            com.paytm.utility.RoboTextView r0 = r1.languageText
            android.content.res.Resources r0 = r0.getResources()
            int r6 = com.business.merchant_payments.R.string.mp_notification_settings_voice_language_enable_text
            goto L_0x0074
        L_0x006c:
            com.paytm.utility.RoboTextView r0 = r1.languageText
            android.content.res.Resources r0 = r0.getResources()
            int r6 = com.business.merchant_payments.R.string.mp_notification_settings_voice_language_disable_text
        L_0x0074:
            java.lang.String r0 = r0.getString(r6)
            if (r7 == 0) goto L_0x0083
            com.paytm.utility.RoboTextView r6 = r1.languageText
            android.content.res.Resources r6 = r6.getResources()
            int r14 = com.business.merchant_payments.R.dimen.dimen_5dp
            goto L_0x008b
        L_0x0083:
            com.paytm.utility.RoboTextView r6 = r1.languageText
            android.content.res.Resources r6 = r6.getResources()
            int r14 = com.business.merchant_payments.R.dimen.dimen_8dp
        L_0x008b:
            float r6 = r6.getDimension(r14)
            if (r7 == 0) goto L_0x0096
            com.paytm.utility.RoboTextView r14 = r1.tvLanguage
            int r15 = com.business.merchant_payments.R.color.color_00b9f5
            goto L_0x009a
        L_0x0096:
            com.paytm.utility.RoboTextView r14 = r1.tvLanguage
            int r15 = com.business.merchant_payments.R.color.mp_color_8ba6c1
        L_0x009a:
            int r14 = androidx.databinding.ViewDataBinding.getColorFromResource(r14, r15)
            r15 = r7 ^ 1
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            boolean r15 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r15)
            goto L_0x00ac
        L_0x00a9:
            r7 = 0
        L_0x00aa:
            r14 = 0
            r15 = 0
        L_0x00ac:
            r23 = 130(0x82, double:6.4E-322)
            long r23 = r2 & r23
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            r23 = 132(0x84, double:6.5E-322)
            long r23 = r2 & r23
            int r26 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            r23 = 136(0x88, double:6.7E-322)
            long r23 = r2 & r23
            int r27 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            r23 = 144(0x90, double:7.1E-322)
            long r23 = r2 & r23
            int r28 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x00cb
            boolean r23 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            goto L_0x00cd
        L_0x00cb:
            r23 = 0
        L_0x00cd:
            r29 = 160(0xa0, double:7.9E-322)
            long r29 = r2 & r29
            int r24 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            r29 = 192(0xc0, double:9.5E-322)
            long r29 = r2 & r29
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            long r18 = r2 & r18
            int r29 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x00ea
            boolean r23 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            r11 = r23 ^ 1
            r16 = r11
            r11 = r23
            goto L_0x00ee
        L_0x00ea:
            r11 = r23
            r16 = 0
        L_0x00ee:
            r17 = 145(0x91, double:7.16E-322)
            long r17 = r2 & r17
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0100
            if (r7 == 0) goto L_0x00fd
            r22 = 1
            r32 = 1
            goto L_0x0102
        L_0x00fd:
            r32 = r16
            goto L_0x0102
        L_0x0100:
            r32 = 0
        L_0x0102:
            long r2 = r2 & r20
            int r16 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0147
            androidx.appcompat.widget.SwitchCompat r2 = r1.btnToggleSettings
            androidx.databinding.a.a.a(r2, r7)
            com.paytm.utility.RoboTextView r2 = r1.languageText
            int r3 = androidx.databinding.a.e.a(r6)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r4 < r5) goto L_0x0129
            int r4 = r2.getPaddingTop()
            int r5 = r2.getPaddingEnd()
            int r6 = r2.getPaddingBottom()
            r2.setPaddingRelative(r3, r4, r5, r6)
            goto L_0x0138
        L_0x0129:
            int r4 = r2.getPaddingTop()
            int r5 = r2.getPaddingRight()
            int r6 = r2.getPaddingBottom()
            r2.setPadding(r3, r4, r5, r6)
        L_0x0138:
            com.paytm.utility.RoboTextView r2 = r1.languageText
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
            com.paytm.utility.RoboTextView r0 = r1.mboundView6
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r0, r15)
            com.paytm.utility.RoboTextView r0 = r1.tvLanguage
            r0.setTextColor(r14)
        L_0x0147:
            if (r24 == 0) goto L_0x014e
            androidx.appcompat.widget.SwitchCompat r0 = r1.btnToggleSettings
            r0.setOnCheckedChangeListener(r12)
        L_0x014e:
            if (r26 == 0) goto L_0x0155
            android.widget.ImageView r0 = r1.imgAudioAlert
            com.business.merchant_payments.common.utility.DataBindingUtility.bindSrcCompat((android.widget.ImageView) r0, (android.graphics.drawable.Drawable) r9)
        L_0x0155:
            if (r28 == 0) goto L_0x015c
            com.paytm.utility.RoboTextView r0 = r1.languageText
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r0, r11)
        L_0x015c:
            if (r31 == 0) goto L_0x0163
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.mboundView0
            r0.setOnClickListener(r13)
        L_0x0163:
            if (r27 == 0) goto L_0x016a
            com.paytm.utility.RoboTextView r0 = r1.tvAudioAlert
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x016a:
            if (r25 == 0) goto L_0x0171
            com.paytm.utility.RoboTextView r0 = r1.tvLanguage
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0171:
            if (r19 == 0) goto L_0x017a
            com.paytm.utility.RoboTextView r0 = r1.tvLanguage
            r2 = r32
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r0, r2)
        L_0x017a:
            return
        L_0x017b:
            r0 = move-exception
            monitor-exit(r33)     // Catch:{ all -> 0x017b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpNotificationItemViewBindingImpl.executeBindings():void");
    }
}
