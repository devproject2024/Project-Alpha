package com.travel.train.viewholder;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.l;
import com.travel.train.model.trainticket.b;
import com.travel.train.model.trainticket.e;

public final class ad extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public EditText f27767a;

    /* renamed from: b  reason: collision with root package name */
    l f27768b;

    /* renamed from: c  reason: collision with root package name */
    e f27769c;

    /* renamed from: d  reason: collision with root package name */
    public b f27770d;

    public ad(Context context, View view, e eVar, l lVar) {
        super(view);
        int i2;
        this.f27767a = (EditText) view.findViewById(R.id.edit_text_edit_tag);
        this.f27769c = eVar;
        this.f27768b = lVar;
        this.itemView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ad.this.a(view, motionEvent);
            }
        });
        this.f27767a.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return ad.this.a(view, i2, keyEvent);
            }
        });
        this.f27767a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                ad.this.f27770d.setText(obj);
                ad.this.f27768b.a(ad.this.f27769c, obj);
            }
        });
        if (eVar == e.CONTACT) {
            i2 = 10;
            int dimension = (int) context.getResources().getDimension(R.dimen.dimen_5dp);
            this.f27767a.setPadding(0, (int) context.getResources().getDimension(R.dimen.dimen_10dp), dimension, dimension);
        } else {
            i2 = 50;
        }
        this.f27767a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.f27768b.a(this.f27769c);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 67 || !TextUtils.isEmpty(this.f27767a.getText().toString())) {
            return false;
        }
        this.f27768b.a();
        return false;
    }

    public final void a(String str) {
        this.f27767a.setText(str);
    }

    public final void a() {
        this.f27767a.requestFocus();
    }
}
