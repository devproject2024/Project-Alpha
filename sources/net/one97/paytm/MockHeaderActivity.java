package net.one97.paytm;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.b.k;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.MockHeaderActivity;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MockHeaderActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f51873a = MockHeaderActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private a f51874b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f51879a;

        /* renamed from: b  reason: collision with root package name */
        TextView f51880b;

        /* renamed from: c  reason: collision with root package name */
        TextView f51881c;

        /* renamed from: d  reason: collision with root package name */
        CheckBox f51882d;

        /* renamed from: e  reason: collision with root package name */
        Button f51883e;

        /* renamed from: f  reason: collision with root package name */
        Button f51884f;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mock_header);
        findViewById(R.id.add_header).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MockHeaderActivity.this.a(view);
            }
        });
        this.f51874b = new a(this, a((Context) this));
        ((ListView) findViewById(R.id.header_list)).setAdapter(this.f51874b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(-1);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        boolean z;
        JSONObject jSONObject;
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.debug_headers_dialog);
        dialog.setTitle(i2 == -1 ? "Add Header" : "Edit Header");
        EditText editText = (EditText) dialog.findViewById(R.id.url_string);
        EditText editText2 = (EditText) dialog.findViewById(R.id.key_string);
        EditText editText3 = (EditText) dialog.findViewById(R.id.value_string);
        JSONArray a2 = a(dialog.getContext());
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = false;
        if (i2 != -1) {
            try {
                jSONObject2 = a2.getJSONObject(i2);
                z2 = jSONObject2.getBoolean("is_header_muted");
                editText.setText(jSONObject2.getString("url_added"));
                editText2.setText(jSONObject2.getString("key_added"));
                editText3.setText(jSONObject2.getString("value_added"));
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
            jSONObject = jSONObject2;
            z = z2;
        } else {
            jSONObject = jSONObject2;
            z = false;
        }
        ((Button) dialog.findViewById(R.id.ok_headers)).setOnClickListener(new View.OnClickListener(editText2, editText3, editText, dialog, jSONObject, z, i2, a2) {
            private final /* synthetic */ EditText f$1;
            private final /* synthetic */ EditText f$2;
            private final /* synthetic */ EditText f$3;
            private final /* synthetic */ Dialog f$4;
            private final /* synthetic */ JSONObject f$5;
            private final /* synthetic */ boolean f$6;
            private final /* synthetic */ int f$7;
            private final /* synthetic */ JSONArray f$8;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
                this.f$8 = r9;
            }

            public final void onClick(View view) {
                MockHeaderActivity.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, view);
            }
        });
        ((Button) dialog.findViewById(R.id.cancel_headers)).setOnClickListener(new View.OnClickListener(dialog) {
            private final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        dialog.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(EditText editText, EditText editText2, EditText editText3, Dialog dialog, JSONObject jSONObject, boolean z, int i2, JSONArray jSONArray, View view) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        String obj3 = editText3.getText().toString();
        HashMap hashMap = new HashMap();
        hashMap.put(obj, obj2);
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj3)) {
            Toast.makeText(dialog.getContext(), "Invalid Input", 0).show();
            return;
        }
        try {
            jSONObject.put("url_added", obj3);
            jSONObject.put("map_added", new JSONObject(hashMap));
            jSONObject.put("key_added", obj);
            jSONObject.put("value_added", obj2);
            jSONObject.put("is_header_muted", z);
            if (i2 == -1) {
                jSONArray.put(jSONObject);
            }
            b(dialog.getContext(), jSONArray);
            Toast.makeText(dialog.getContext(), "Header added successfully", 0).show();
            this.f51874b.a(a(dialog.getContext()));
            dialog.dismiss();
        } catch (JSONException e2) {
            e2.getMessage();
            Toast.makeText(dialog.getContext(), "Something went wrong while adding rule. Check log", 0).show();
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, JSONArray jSONArray) {
        ag.a(context.getApplicationContext()).a("header_added_rule", jSONArray.toString(), true);
        k.f42903d = jSONArray;
    }

    public static JSONArray a(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("header_added_rule", "", true);
        if (b2.equals("")) {
            return new JSONArray();
        }
        try {
            return new JSONArray(b2);
        } catch (JSONException e2) {
            e2.getMessage();
            return new JSONArray();
        }
    }

    class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final Context f51875a;

        /* renamed from: b  reason: collision with root package name */
        JSONArray f51876b;

        /* renamed from: c  reason: collision with root package name */
        final LayoutInflater f51877c;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context, JSONArray jSONArray) {
            this.f51875a = context;
            this.f51876b = jSONArray;
            this.f51877c = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final int getCount() {
            JSONArray jSONArray = this.f51876b;
            if (jSONArray == null) {
                return 0;
            }
            return jSONArray.length();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject getItem(int i2) {
            try {
                return this.f51876b.getJSONObject(i2);
            } catch (JSONException e2) {
                String unused = MockHeaderActivity.f51873a;
                e2.getMessage();
                return new JSONObject();
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f51877c.inflate(R.layout.header_list_item_view, viewGroup, false);
                bVar.f51880b = (TextView) view2.findViewById(R.id.url_id);
                bVar.f51879a = (TextView) view2.findViewById(R.id.header_id);
                bVar.f51881c = (TextView) view2.findViewById(R.id.value_id);
                bVar.f51883e = (Button) view2.findViewById(R.id.delete_header);
                bVar.f51884f = (Button) view2.findViewById(R.id.edit_header);
                bVar.f51882d = (CheckBox) view2.findViewById(R.id.is_header_muted);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            JSONObject a2 = getItem(i2);
            TextView textView = bVar.f51879a;
            textView.setText("Rule Id : " + String.valueOf(i2 + 1));
            try {
                TextView textView2 = bVar.f51880b;
                textView2.setText("URL : " + a2.getString("url_added"));
                TextView textView3 = bVar.f51881c;
                textView3.setText("Headers Map : " + a2.getString("map_added"));
                bVar.f51882d.setChecked(a2.getBoolean("is_header_muted"));
            } catch (JSONException e2) {
                String unused = MockHeaderActivity.f51873a;
                e2.getMessage();
            }
            bVar.f51883e.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    MockHeaderActivity.a.this.b(this.f$1, view);
                }
            });
            bVar.f51884f.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    MockHeaderActivity.a.this.a(this.f$1, view);
                }
            });
            bVar.f51882d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    MockHeaderActivity.a.this.a(this.f$1, compoundButton, z);
                }
            });
            return view2;
        }

        public final void a(JSONArray jSONArray) {
            this.f51876b = jSONArray;
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, CompoundButton compoundButton, boolean z) {
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    this.f51876b.getJSONObject(i2).put("is_header_muted", z);
                } catch (JSONException e2) {
                    String unused = MockHeaderActivity.f51873a;
                    e2.getMessage();
                }
                MockHeaderActivity.b(this.f51875a, this.f51876b);
                a(MockHeaderActivity.a(this.f51875a));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, View view) {
            MockHeaderActivity.this.a(i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, View view) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f51876b.remove(i2);
            }
            MockHeaderActivity.b(this.f51875a, this.f51876b);
            a(MockHeaderActivity.a(this.f51875a));
        }
    }
}
