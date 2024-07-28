package com.google.zxing.client.android.share;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.business.merchant_payments.utility.StringUtility;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.b.a;
import com.google.zxing.client.android.d;

public final class ShareActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40276a = ShareActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private View f40277b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f40278c = new View.OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            intent.addFlags(524288);
            ShareActivity.this.startActivityForResult(intent, 1);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f40279d = new View.OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.addFlags(524288);
            intent.setClassName(ShareActivity.this, BookmarkPickerActivity.class.getName());
            ShareActivity.this.startActivityForResult(intent, 0);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final View.OnClickListener f40280e = new View.OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.addFlags(524288);
            intent.setClassName(ShareActivity.this, AppPickerActivity.class.getName());
            ShareActivity.this.startActivityForResult(intent, 2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f40281f = new View.OnClickListener() {
        public final void onClick(View view) {
            CharSequence a2 = a.a(ShareActivity.this);
            if (a2 != null) {
                ShareActivity.a(ShareActivity.this, a2.toString());
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final View.OnKeyListener f40282g = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 66 || keyEvent.getAction() != 0) {
                return false;
            }
            String charSequence = ((TextView) view).getText().toString();
            if (charSequence == null || charSequence.isEmpty()) {
                return true;
            }
            ShareActivity.a(ShareActivity.this, charSequence);
            return true;
        }
    };

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share);
        findViewById(R.id.share_contact_button).setOnClickListener(this.f40278c);
        findViewById(R.id.share_bookmark_button).setOnClickListener(this.f40279d);
        findViewById(R.id.share_app_button).setOnClickListener(this.f40280e);
        this.f40277b = findViewById(R.id.share_clipboard_button);
        this.f40277b.setOnClickListener(this.f40281f);
        findViewById(R.id.share_text_view).setOnKeyListener(this.f40282g);
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        this.f40277b.setEnabled(a.b(this));
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 != 0) {
                if (i2 == 1) {
                    a(intent.getData());
                    return;
                } else if (i2 != 2) {
                    return;
                }
            }
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra != null) {
                Intent intent2 = new Intent("com.google.zxing.client.android.ENCODE");
                intent2.addFlags(524288);
                intent2.putExtra("ENCODE_TYPE", "TEXT_TYPE");
                intent2.putExtra("ENCODE_DATA", stringExtra);
                intent2.putExtra("ENCODE_FORMAT", com.google.zxing.a.QR_CODE.toString());
                startActivity(intent2);
            }
        }
    }

    private void a(Uri uri) {
        String string;
        Cursor query;
        new StringBuilder("Showing contact URI as barcode: ").append(uri);
        if (uri != null) {
            ContentResolver contentResolver = getContentResolver();
            try {
                Cursor query2 = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
                if (query2 != null) {
                    try {
                        if (query2.moveToFirst()) {
                            String string2 = query2.getString(query2.getColumnIndex("_id"));
                            String string3 = query2.getString(query2.getColumnIndex("display_name"));
                            int i2 = 0;
                            boolean z = query2.getInt(query2.getColumnIndex("has_phone_number")) > 0;
                            query2.close();
                            Bundle bundle = new Bundle();
                            if (string3 != null && !string3.isEmpty()) {
                                bundle.putString("name", a(string3));
                            }
                            if (z && (query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, (String[]) null, "contact_id=".concat(String.valueOf(string2)), (String[]) null, (String) null)) != null) {
                                try {
                                    int columnIndex = query.getColumnIndex("data1");
                                    int columnIndex2 = query.getColumnIndex("data2");
                                    int i3 = 0;
                                    while (query.moveToNext() && i3 < d.f40189a.length) {
                                        String string4 = query.getString(columnIndex);
                                        if (string4 != null && !string4.isEmpty()) {
                                            bundle.putString(d.f40189a[i3], a(string4));
                                        }
                                        bundle.putInt(d.f40190b[i3], query.getInt(columnIndex2));
                                        i3++;
                                    }
                                } finally {
                                    query.close();
                                }
                            }
                            Cursor query3 = contentResolver.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, (String[]) null, "contact_id=".concat(String.valueOf(string2)), (String[]) null, (String) null);
                            if (query3 != null) {
                                try {
                                    if (query3.moveToNext() && (string = query3.getString(query3.getColumnIndex("data1"))) != null && !string.isEmpty()) {
                                        bundle.putString("postal", a(string));
                                    }
                                } finally {
                                    query3.close();
                                }
                            }
                            Cursor query4 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, (String[]) null, "contact_id=".concat(String.valueOf(string2)), (String[]) null, (String) null);
                            if (query4 != null) {
                                try {
                                    int columnIndex3 = query4.getColumnIndex("data1");
                                    while (query4.moveToNext() && i2 < d.f40191c.length) {
                                        String string5 = query4.getString(columnIndex3);
                                        if (string5 != null && !string5.isEmpty()) {
                                            bundle.putString(d.f40191c[i2], a(string5));
                                        }
                                        i2++;
                                    }
                                } finally {
                                    query4.close();
                                }
                            }
                            Intent intent = new Intent("com.google.zxing.client.android.ENCODE");
                            intent.addFlags(524288);
                            intent.putExtra("ENCODE_TYPE", "CONTACT_TYPE");
                            intent.putExtra("ENCODE_DATA", bundle);
                            intent.putExtra("ENCODE_FORMAT", com.google.zxing.a.QR_CODE.toString());
                            new StringBuilder("Sending bundle for encoding: ").append(bundle);
                            startActivity(intent);
                        }
                    } finally {
                        query2.close();
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private static String a(String str) {
        if (str.indexOf(10) >= 0) {
            str = str.replace(StringUtility.NEW_LINE, " ");
        }
        return str.indexOf(13) >= 0 ? str.replace("\r", " ") : str;
    }

    static /* synthetic */ void a(ShareActivity shareActivity, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.ENCODE");
        intent.addFlags(524288);
        intent.putExtra("ENCODE_TYPE", "TEXT_TYPE");
        intent.putExtra("ENCODE_DATA", str);
        intent.putExtra("ENCODE_FORMAT", com.google.zxing.a.QR_CODE.toString());
        shareActivity.startActivity(intent);
    }
}
