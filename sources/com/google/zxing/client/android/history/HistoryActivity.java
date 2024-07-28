package com.google.zxing.client.android.history;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.R;
import com.google.zxing.r;
import java.util.List;

public final class HistoryActivity extends ListActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40231a = HistoryActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f40232b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayAdapter<b> f40233c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f40234d;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40232b = new d(this);
        this.f40233c = new c(this);
        setListAdapter(this.f40233c);
        registerForContextMenu(getListView());
        this.f40234d = getTitle();
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        a();
    }

    private void a() {
        List<b> b2 = this.f40232b.b();
        this.f40233c.clear();
        for (b add : b2) {
            this.f40233c.add(add);
        }
        setTitle(this.f40234d + " (" + this.f40233c.getCount() + ')');
        if (this.f40233c.isEmpty()) {
            this.f40233c.add(new b((r) null, (String) null, (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public final void onListItemClick(ListView listView, View view, int i2, long j) {
        if (this.f40233c.getItem(i2).f40236a != null) {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.putExtra("ITEM_NUMBER", i2);
            setResult(-1, intent);
            finish();
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        int i2 = ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position;
        if (i2 >= this.f40233c.getCount() || this.f40233c.getItem(i2).f40236a != null) {
            contextMenu.add(0, i2, i2, R.string.history_clear_one_history_text);
        }
    }

    public final boolean onContextItemSelected(MenuItem menuItem) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        int itemId = menuItem.getItemId();
        try {
            sQLiteDatabase = new a(this.f40232b.f40245b).getWritableDatabase();
            try {
                cursor = sQLiteDatabase.query("history", d.f40240a, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            } catch (Throwable th) {
                th = th;
                cursor = null;
                d.a(cursor, sQLiteDatabase);
                throw th;
            }
            try {
                cursor.move(itemId + 1);
                sQLiteDatabase.delete("history", "id=" + cursor.getString(0), (String[]) null);
                d.a(cursor, sQLiteDatabase);
                a();
                return true;
            } catch (Throwable th2) {
                th = th2;
                d.a(cursor, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
            cursor = null;
            d.a(cursor, sQLiteDatabase);
            throw th;
        }
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        if (this.f40232b.a()) {
            getMenuInflater().inflate(R.menu.history, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_history_send) {
            Uri a2 = d.a(this.f40232b.d().toString());
            if (a2 == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.msg_unmount_usb);
                builder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null);
                builder.show();
            } else {
                Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
                intent.addFlags(524288);
                String string = getResources().getString(R.string.history_email_title);
                intent.putExtra("android.intent.extra.SUBJECT", string);
                intent.putExtra("android.intent.extra.TEXT", string);
                intent.putExtra("android.intent.extra.STREAM", a2);
                intent.setType("text/csv");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                }
            }
        } else if (menuItem.getItemId() != R.id.menu_history_clear_text) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setMessage(R.string.msg_sure);
            builder2.setCancelable(true);
            builder2.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SQLiteDatabase sQLiteDatabase;
                    try {
                        sQLiteDatabase = new a(HistoryActivity.this.f40232b.f40245b).getWritableDatabase();
                        try {
                            sQLiteDatabase.delete("history", (String) null, (String[]) null);
                            d.a((Cursor) null, sQLiteDatabase);
                            dialogInterface.dismiss();
                            HistoryActivity.this.finish();
                        } catch (Throwable th) {
                            th = th;
                            d.a((Cursor) null, sQLiteDatabase);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = null;
                        d.a((Cursor) null, sQLiteDatabase);
                        throw th;
                    }
                }
            });
            builder2.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
            builder2.show();
        }
        return true;
    }
}
