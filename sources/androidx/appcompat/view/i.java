package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f1257b;

    public i(Window.Callback callback) {
        if (callback != null) {
            this.f1257b = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1257b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1257b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f1257b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1257b.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1257b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1257b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i2) {
        return this.f1257b.onCreatePanelView(i2);
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f1257b.onCreatePanelMenu(i2, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f1257b.onPreparePanel(i2, view, menu);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f1257b.onMenuOpened(i2, menu);
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f1257b.onMenuItemSelected(i2, menuItem);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f1257b.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.f1257b.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.f1257b.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.f1257b.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f1257b.onDetachedFromWindow();
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f1257b.onPanelClosed(i2, menu);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f1257b.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.f1257b.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1257b.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f1257b.onWindowStartingActionMode(callback, i2);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1257b.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1257b.onActionModeFinished(actionMode);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.f1257b.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.f1257b.onPointerCaptureChanged(z);
    }
}
