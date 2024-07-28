package com.zhihu.matisse.internal.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.utility.q;
import com.zhihu.matisse.internal.c.b;
import com.zhihu.matisse.internal.c.h;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import com.zhihu.matisse.internal.ui.a.e;
import com.zhihu.matisse.internal.ui.widget.PreviewViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectedPreviewActivity extends BasePreviewActivity implements b.a {
    static final /* synthetic */ boolean j = (!SelectedPreviewActivity.class.desiredAssertionStatus());
    private RecyclerView k;
    private e l;
    /* access modifiers changed from: private */
    public List<Item> m;
    /* access modifiers changed from: private */
    public EditText n;
    private b o;

    public void onCreate(Bundle bundle) {
        Class<SelectedPreviewActivity> cls = SelectedPreviewActivity.class;
        super.onCreate(bundle);
        if (!c.a.f45787a.q) {
            cls.getSimpleName();
            q.b("!!!SelectionSpec uninitialized");
            setResult(0);
            finish();
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra("extra_default_bundle");
        ArrayList parcelableArrayList = bundleExtra.getParcelableArrayList("state_selection");
        this.f45791d.f45825a.addAll(parcelableArrayList);
        this.f45791d.notifyDataSetChanged();
        int i2 = bundleExtra.getInt("CURRENT_POSITION");
        if (i2 > 0) {
            this.f45790c.setCurrentItem(i2, false);
        }
        this.f45795h = 0;
        cls.getSimpleName();
        q.a("selected.size() =" + parcelableArrayList.size());
        if (parcelableArrayList.size() <= 0) {
            cls.getSimpleName();
            q.a("selected.size() < 1");
            finish();
            return;
        }
        this.n = (EditText) findViewById(R.id.edittext_caption);
        this.n.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                ((Item) SelectedPreviewActivity.this.m.get(SelectedPreviewActivity.this.f45790c.getCurrentItem())).j = SelectedPreviewActivity.this.n.getText() != null ? SelectedPreviewActivity.this.n.getText().toString() : null;
            }
        });
        this.k = (RecyclerView) findViewById(R.id.layout_preview_thumbnail_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.k.setLayoutManager(linearLayoutManager);
        this.l = new e(this, parcelableArrayList, this.f45790c);
        this.k.setAdapter(this.l);
        this.k.addItemDecoration(new RecyclerView.h() {
            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                rect.left = 5;
                rect.right = 5;
            }
        });
        this.m = parcelableArrayList;
        a((Item) parcelableArrayList.get(0));
        this.o = b.a(this);
        this.o.f45737a = this;
        if (this.f45790c instanceof PreviewViewPager) {
            ((PreviewViewPager) this.f45790c).setLockHeight(true);
        }
        if (!getIntent().getBooleanExtra("extra_preview_only", false) || findViewById(R.id.bottom_layout) == null) {
            super.c();
        } else {
            findViewById(R.id.bottom_layout).setVisibility(8);
        }
        new h(this);
    }

    public final void a(boolean z, int i2) {
        int i3 = 0;
        String.format(Locale.getDefault(), "isShow %s, height=%d", new Object[]{String.valueOf(z), Integer.valueOf(i2)});
        RecyclerView recyclerView = this.k;
        if (z) {
            i3 = 8;
        }
        recyclerView.setVisibility(i3);
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.o;
        if (bVar != null && bVar.f45738b != null && Build.VERSION.SDK_INT >= 16) {
            bVar.f45738b.getViewTreeObserver().removeOnGlobalLayoutListener(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Item item) {
        List<Item> list;
        String str;
        super.a(item);
        if (this.l != null && (list = this.m) != null) {
            this.k.scrollToPosition(list.indexOf(item));
            if (item.j != null) {
                str = item.j;
            } else {
                str = "";
            }
            this.n.setText(str);
            this.n.setSelection(str.length());
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        q.a("The trigger");
        boolean z = false;
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && (currentFocus instanceof EditText)) {
            int[] iArr = {0, 0};
            currentFocus.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int height = currentFocus.getHeight() + i3;
            int width = currentFocus.getWidth() + i2;
            if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) height)) {
                z = true;
            }
        }
        if (z && ((InputMethodManager) getSystemService("input_method")) != null) {
            if (j || currentFocus != null) {
                hideKeyboard(currentFocus);
                EditText editText = this.n;
                if (editText != null) {
                    editText.clearFocus();
                }
            } else {
                throw new AssertionError();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (Build.VERSION.SDK_INT >= 3 && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void onStop() {
        super.onStop();
        Intent intent = new Intent();
        Bundle bundleExtra = getIntent().getBundleExtra("extra_default_bundle");
        if (bundleExtra != null) {
            intent.putExtra("extra_is_from_camera", bundleExtra.getBoolean("extra_is_from_camera", false));
        }
        setResult(-1, intent);
    }

    public final void b() {
        this.k.getAdapter().notifyDataSetChanged();
    }

    public final void c() {
        super.c();
    }
}
