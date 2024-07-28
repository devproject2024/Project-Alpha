package com.business.merchant_payments.widget.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.business.common_module.e.b;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpRadioBankNameBinding;
import com.business.merchant_payments.widget.radio.RadioCheckable;
import java.util.ArrayList;

public class BaseCustomRadioButton extends RelativeLayout implements RadioCheckable {
    public Object data = null;
    public boolean mChecked;
    public ArrayList<RadioCheckable.OnCheckedChangeListener> mOnCheckedChangeListeners = new ArrayList<>();
    public View.OnClickListener mOnClickListener;
    public View.OnTouchListener mOnTouchListener;
    public MpRadioBankNameBinding radioBankNameBinding;

    public void bindView() {
    }

    public String getmDesValue() {
        return null;
    }

    public String getmTitleValue() {
        return null;
    }

    public boolean ismIsSelected() {
        return false;
    }

    public void setmDesValue(String str) {
    }

    public BaseCustomRadioButton(Context context) {
        super(context);
        setupView();
    }

    public BaseCustomRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(attributeSet);
        setupView();
    }

    public BaseCustomRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        parseAttributes(attributeSet);
        setupView();
    }

    public BaseCustomRadioButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        parseAttributes(attributeSet);
        setupView();
    }

    private void setupView() {
        inflateView();
        bindView();
        setCustomClickListener();
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MpBaseCustomRadioButton, 0, 0);
        getContext().getResources();
        obtainStyledAttributes.recycle();
    }

    public void inflateView() {
        this.radioBankNameBinding = MpRadioBankNameBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public void setCustomClickListener() {
        this.radioBankNameBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseCustomRadioButton.this.lambda$setCustomClickListener$0$BaseCustomRadioButton(view);
            }
        });
    }

    public /* synthetic */ void lambda$setCustomClickListener$0$BaseCustomRadioButton(View view) {
        setChecked(true);
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setmTitleValue(String str) {
        this.radioBankNameBinding.topText.setText(str);
    }

    public void setmIsSelected(boolean z) {
        setChecked(z);
    }

    public void addOnCheckChangeListener(RadioCheckable.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void removeOnCheckChangeListener(RadioCheckable.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            if (!this.mOnCheckedChangeListeners.isEmpty()) {
                for (int i2 = 0; i2 < this.mOnCheckedChangeListeners.size(); i2++) {
                    this.mOnCheckedChangeListeners.get(i2).onCheckedChanged(this, this.mChecked);
                }
            }
            if (this.mChecked) {
                setCheckedState();
            } else {
                setNormalState();
            }
        }
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }

    public void setCheckedState() {
        this.radioBankNameBinding.radio.setChecked(true);
    }

    public void setNormalState() {
        this.radioBankNameBinding.radio.setChecked(false);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(b bVar) {
        this.data = bVar;
        this.radioBankNameBinding.topText.setText(bVar.getName());
    }

    public void showDivider(boolean z) {
        this.radioBankNameBinding.divier.setVisibility(z ? 0 : 8);
    }
}
