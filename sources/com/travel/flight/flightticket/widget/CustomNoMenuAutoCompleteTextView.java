package com.travel.flight.flightticket.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class CustomNoMenuAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25296a;

    public CustomNoMenuAutoCompleteTextView(Context context) {
        super(context);
        this.f25296a = context;
        a();
    }

    public CustomNoMenuAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25296a = context;
        a();
    }

    public CustomNoMenuAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25296a = context;
        a();
    }

    private void a() {
        setCustomSelectionActionModeCallback(new a(this, (byte) 0));
        setLongClickable(false);
    }

    class a implements ActionMode.Callback {

        /* renamed from: b  reason: collision with root package name */
        private final String f25298b;

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
            this.f25298b = CustomNoMenuAutoCompleteTextView.class.getSimpleName();
        }

        /* synthetic */ a(CustomNoMenuAutoCompleteTextView customNoMenuAutoCompleteTextView, byte b2) {
            this();
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        setBackground((Drawable) null);
    }

    public void setError(CharSequence charSequence) {
        super.setError(charSequence);
        setBackground((Drawable) null);
    }
}
