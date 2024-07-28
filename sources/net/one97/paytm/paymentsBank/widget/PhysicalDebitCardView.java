package net.one97.paytm.paymentsBank.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.paymentsBank.R;

public class PhysicalDebitCardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f19632a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19633b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19634c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19635d;

    /* renamed from: e  reason: collision with root package name */
    private String f19636e;

    /* renamed from: f  reason: collision with root package name */
    private String f19637f;

    /* renamed from: g  reason: collision with root package name */
    private String f19638g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f19639h;

    /* renamed from: i  reason: collision with root package name */
    private CircularImageView f19640i;
    private boolean j;

    public PhysicalDebitCardView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public PhysicalDebitCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public PhysicalDebitCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public PhysicalDebitCardView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(AttributeSet attributeSet) {
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhysicalDebitCardView);
        try {
            int i2 = 0;
            int integer = obtainStyledAttributes.getInteger(R.styleable.PhysicalDebitCardView_layoutId, 0);
            this.f19635d = obtainStyledAttributes.getBoolean(R.styleable.PhysicalDebitCardView_cardMasking, false);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.PhysicalDebitCardView_showProfileImage, false);
            if (obtainStyledAttributes.hasValue(R.styleable.PhysicalDebitCardView_cardNumber)) {
                this.f19636e = obtainStyledAttributes.getString(R.styleable.PhysicalDebitCardView_cardNumber);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.PhysicalDebitCardView_cardName)) {
                this.f19638g = obtainStyledAttributes.getString(R.styleable.PhysicalDebitCardView_cardName);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.PhysicalDebitCardView_expiryDate)) {
                this.f19637f = obtainStyledAttributes.getString(R.styleable.PhysicalDebitCardView_expiryDate);
            }
            obtainStyledAttributes.recycle();
            if (integer != 0) {
                view = layoutInflater.inflate(integer, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.item_physical_debit_card, (ViewGroup) null);
            }
            removeAllViews();
            addView(view);
            this.f19639h = (ViewGroup) view.findViewById(R.id.profileImageLayout);
            this.f19640i = (CircularImageView) view.findViewById(R.id.profilePic);
            this.f19632a = (TextView) view.findViewById(R.id.tv_card_number);
            this.f19634c = (TextView) view.findViewById(R.id.tv_card_holder_name);
            this.f19633b = (TextView) view.findViewById(R.id.validUptoTv);
            ViewGroup viewGroup = this.f19639h;
            if (viewGroup != null) {
                if (!this.j) {
                    i2 = 8;
                }
                viewGroup.setVisibility(i2);
            }
            setCardNumber(this.f19636e);
            setCardName(this.f19638g);
            setExpiryDate(this.f19637f);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public TextView getCardNumberTv() {
        return this.f19632a;
    }

    public void setCardNumberTv(TextView textView) {
        this.f19632a = textView;
    }

    public TextView getExpiryDateTv() {
        return this.f19633b;
    }

    public void setExpiryDateTv(TextView textView) {
        this.f19633b = textView;
    }

    public TextView getCardNameTv() {
        return this.f19634c;
    }

    public void setCardNameTv(TextView textView) {
        this.f19634c = textView;
    }

    public void setCardMasking(boolean z) {
        if (!this.f19635d || !z) {
            this.f19635d = z;
            if (this.f19635d) {
                this.f19632a.setText(this.f19636e);
                this.f19633b.setText("XX/XX");
                return;
            }
            this.f19632a.setText(this.f19636e);
        }
    }

    public String getCardNumber() {
        return this.f19636e;
    }

    public void setCardNumber(String str) {
        this.f19636e = str;
        if (TextUtils.isEmpty(str)) {
            this.f19632a.setText("");
        } else if (this.f19635d) {
            this.f19632a.setText(str);
        } else {
            this.f19632a.setText(b.i("  ", str));
        }
    }

    public String getExpiryDate() {
        return this.f19637f;
    }

    public void setExpiryDate(String str) {
        this.f19637f = str;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f19633b.setText(str);
    }

    public String getCardName() {
        return this.f19638g;
    }

    public void setCardName(String str) {
        this.f19638g = str;
        TextView textView = this.f19634c;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        textView.setText(str);
    }

    public void setProfileImage(Bitmap bitmap) {
        if (bitmap != null && this.j && this.f19640i != null) {
            this.f19640i.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        }
    }

    public CircularImageView getImageView() {
        return this.f19640i;
    }
}
