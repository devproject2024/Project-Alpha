package com.travel.flight.flightticket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CustomNoMenuEditTextView extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25299a;

    public CustomNoMenuEditTextView(Context context) {
        super(context);
        this.f25299a = context;
        a();
    }

    public CustomNoMenuEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25299a = context;
        a();
    }

    public CustomNoMenuEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25299a = context;
        a();
    }

    private void a() {
        setCustomSelectionActionModeCallback(new a(this, (byte) 0));
        setLongClickable(false);
    }

    class a implements ActionMode.Callback {

        /* renamed from: b  reason: collision with root package name */
        private final String f25301b;

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        private a() {
            this.f25301b = CustomNoMenuEditTextView.class.getSimpleName();
        }

        /* synthetic */ a(CustomNoMenuEditTextView customNoMenuEditTextView, byte b2) {
            this();
        }
    }
}
