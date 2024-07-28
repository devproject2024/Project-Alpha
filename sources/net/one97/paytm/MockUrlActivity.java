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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.b.k;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MockUrlActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f51885a = MockUrlActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private View f51886b;

    /* renamed from: c  reason: collision with root package name */
    private View f51887c;

    /* renamed from: d  reason: collision with root package name */
    private View f51888d;

    /* renamed from: e  reason: collision with root package name */
    private View f51889e;

    /* renamed from: f  reason: collision with root package name */
    private View f51890f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ListView f51891g;

    /* renamed from: h  reason: collision with root package name */
    private CheckBox f51892h;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f51893i;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f51936a;

        /* renamed from: b  reason: collision with root package name */
        TextView f51937b;

        /* renamed from: c  reason: collision with root package name */
        TextView f51938c;

        /* renamed from: d  reason: collision with root package name */
        TextView f51939d;

        /* renamed from: e  reason: collision with root package name */
        TextView f51940e;

        /* renamed from: f  reason: collision with root package name */
        CheckBox f51941f;

        /* renamed from: g  reason: collision with root package name */
        Button f51942g;

        /* renamed from: h  reason: collision with root package name */
        Button f51943h;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_debug);
        this.f51887c = findViewById(R.id.remove_all_rules);
        this.f51887c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = new JSONArray();
                MockUrlActivity.b(view.getContext(), jSONArray);
                MockUrlActivity.this.f51891g.setAdapter(new a(view.getContext(), jSONArray));
            }
        });
        this.f51888d = findViewById(R.id.set_default_rules);
        this.f51888d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray b2 = MockUrlActivity.c(view.getContext());
                MockUrlActivity.b(view.getContext(), b2);
                MockUrlActivity.this.f51891g.setAdapter(new a(view.getContext(), b2));
            }
        });
        this.f51889e = findViewById(R.id.mute_all_rules);
        this.f51889e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = ((a) MockUrlActivity.this.f51891g.getAdapter()).f51918a;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        jSONArray.getJSONObject(i2).put(StringSet.is_muted, true);
                    } catch (JSONException e2) {
                        q.b(e2.getMessage());
                    }
                }
                MockUrlActivity.b(view.getContext(), jSONArray);
                ((a) MockUrlActivity.this.f51891g.getAdapter()).notifyDataSetChanged();
            }
        });
        this.f51890f = findViewById(R.id.unmute_all_rules);
        this.f51890f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = ((a) MockUrlActivity.this.f51891g.getAdapter()).f51918a;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        jSONArray.getJSONObject(i2).put(StringSet.is_muted, false);
                    } catch (JSONException e2) {
                        q.b(e2.getMessage());
                    }
                }
                MockUrlActivity.b(view.getContext(), jSONArray);
                ((a) MockUrlActivity.this.f51891g.getAdapter()).notifyDataSetChanged();
            }
        });
        findViewById(R.id.set_recharge_utility_rules).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MockUrlActivity.this.a(view);
            }
        });
        findViewById(R.id.add_docker_rule).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("cart-staging.paytm.com", "staging-app.paytm.com/cart-staging");
                hashMap.put("oms-staging.paytm.com", "staging-app.paytm.com/oms-staging");
                hashMap.put("catalog-staging.paytm.com", "staging-app.paytm.com/catalog-staging");
                hashMap.put("digitalproxy-staging.paytm.com", "staging-app.paytm.com/digitalproxy-staging");
                JSONArray a2 = MockUrlActivity.a(view.getContext());
                try {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("rule_type", "String Replacement");
                        jSONObject.put("search_pattern", entry.getKey());
                        jSONObject.put("replacement_pattern", entry.getValue());
                        jSONObject.put("is_full_replacement", false);
                        jSONObject.put(StringSet.is_muted, false);
                        a2.put(jSONObject);
                    }
                    MockUrlActivity.b(view.getContext(), a2);
                    Toast.makeText(view.getContext(), "Docker Rule added successfully", 0).show();
                    MockUrlActivity.this.f51891g.setAdapter(new a(view.getContext(), MockUrlActivity.a(view.getContext())));
                } catch (JSONException e2) {
                    String unused = MockUrlActivity.f51885a;
                    e2.getMessage();
                }
            }
        });
        this.f51886b = findViewById(R.id.add_rule);
        this.f51886b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                final Dialog dialog = new Dialog(MockUrlActivity.this);
                dialog.setContentView(R.layout.debug_activity_add_rule_layout);
                dialog.setTitle("Add Rule");
                final EditText editText = (EditText) dialog.findViewById(R.id.search_string);
                final EditText editText2 = (EditText) dialog.findViewById(R.id.replacement_string);
                final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.full_replace_selection);
                final RadioButton radioButton = (RadioButton) dialog.findViewById(R.id.string_search_replacement);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            editText.setHint("Search String");
                            editText2.setHint("Replace With");
                            checkBox.setVisibility(0);
                        }
                    }
                });
                ((RadioButton) dialog.findViewById(R.id.gtm_value_override)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            editText.setHint("GTM Key");
                            editText2.setHint("Oveeride value with");
                            checkBox.setVisibility(4);
                        }
                    }
                });
                final Dialog dialog2 = dialog;
                ((Button) dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        String obj = editText.getText().toString();
                        String obj2 = editText2.getText().toString();
                        boolean isChecked = checkBox.isChecked();
                        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                            Toast.makeText(dialog2.getContext(), "Invalid Input", 0).show();
                            return;
                        }
                        JSONArray a2 = MockUrlActivity.a(dialog2.getContext());
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("rule_type", radioButton.isChecked() ? "String Replacement" : "GTM Override");
                            jSONObject.put("search_pattern", obj);
                            jSONObject.put("replacement_pattern", obj2);
                            jSONObject.put("is_full_replacement", isChecked);
                            jSONObject.put(StringSet.is_muted, false);
                            a2.put(jSONObject);
                            MockUrlActivity.b(dialog2.getContext(), a2);
                            Toast.makeText(dialog2.getContext(), "Rule added successfully", 0).show();
                            MockUrlActivity.this.f51891g.setAdapter(new a(dialog2.getContext(), MockUrlActivity.a(dialog2.getContext())));
                            dialog2.dismiss();
                        } catch (JSONException e2) {
                            String unused = MockUrlActivity.f51885a;
                            e2.getMessage();
                            Toast.makeText(dialog2.getContext(), "Something went wrong while adding rule. Check log", 0).show();
                        }
                    }
                });
                ((Button) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        this.f51892h = (CheckBox) findViewById(R.id.sslPinning);
        if (ag.a(getApplicationContext()).b("sslPinning", false, true)) {
            this.f51892h.setChecked(true);
        } else {
            this.f51892h.setChecked(false);
        }
        this.f51892h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.paytm.b.a.a a2 = ag.a(MockUrlActivity.this.getApplicationContext());
                if (z) {
                    a2.a("sslPinning", true, true);
                } else {
                    a2.a("sslPinning", false, true);
                }
            }
        });
        this.f51893i = (CheckBox) findViewById(R.id.prefCrash);
        this.f51893i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        this.f51891g = (ListView) findViewById(R.id.rule_list);
        this.f51891g.setAdapter(new a(this, a((Context) this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        try {
            JSONArray jSONArray = new JSONArray(com.paytm.utility.b.w(view.getContext(), "recharge_default_debug_rule_set.json"));
            b(view.getContext(), jSONArray);
            this.f51891g.setAdapter(new a(view.getContext(), jSONArray));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, JSONArray jSONArray) {
        ag.a(context.getApplicationContext()).a("key_added_rule", jSONArray.toString(), true);
        k.f42902c = jSONArray;
    }

    public static JSONArray a(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("key_added_rule", "", true);
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

    /* access modifiers changed from: private */
    public static JSONArray c(Context context) {
        try {
            return new JSONArray(com.paytm.utility.b.w(context, "default_debug_rule_set.json"));
        } catch (JSONException e2) {
            e2.getMessage();
            return null;
        }
    }

    class a extends BaseAdapter {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public JSONArray f51918a;

        /* renamed from: b  reason: collision with root package name */
        CompoundButton.OnCheckedChangeListener f51919b = new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                try {
                    a.this.f51918a.getJSONObject(((Integer) compoundButton.getTag()).intValue()).put(StringSet.is_muted, z);
                } catch (JSONException e2) {
                    String unused = MockUrlActivity.f51885a;
                    e2.getMessage();
                }
                MockUrlActivity.b(a.this.f51923f, a.this.f51918a);
                a.this.notifyDataSetChanged();
            }
        };

        /* renamed from: c  reason: collision with root package name */
        View.OnClickListener f51920c = new View.OnClickListener() {
            public final void onClick(View view) {
                final int intValue = ((Integer) view.getTag()).intValue();
                if (Build.VERSION.SDK_INT >= 16) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = a.this.f51918a.getJSONObject(intValue);
                    } catch (JSONException e2) {
                        String unused = MockUrlActivity.f51885a;
                        e2.getMessage();
                    }
                    final Dialog dialog = new Dialog(MockUrlActivity.this);
                    dialog.setContentView(R.layout.debug_activity_add_rule_layout);
                    dialog.setTitle("Add Rule");
                    final EditText editText = (EditText) dialog.findViewById(R.id.search_string);
                    final EditText editText2 = (EditText) dialog.findViewById(R.id.replacement_string);
                    final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.full_replace_selection);
                    RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.radio_group);
                    RadioButton radioButton = (RadioButton) dialog.findViewById(R.id.string_search_replacement);
                    RadioButton radioButton2 = (RadioButton) dialog.findViewById(R.id.gtm_value_override);
                    try {
                        if (jSONObject.getString("rule_type").equals("String Replacement")) {
                            editText.setHint("Search String");
                            editText2.setHint("Replace With");
                            checkBox.setVisibility(0);
                            radioButton.setChecked(true);
                            checkBox.setChecked(jSONObject.getBoolean("is_full_replacement"));
                        } else {
                            editText.setHint("GTM Key");
                            editText2.setHint("Oveeride value with");
                            checkBox.setVisibility(4);
                            radioButton2.setChecked(true);
                        }
                        radioGroup.setEnabled(false);
                        radioButton.setEnabled(false);
                        radioButton2.setEnabled(false);
                        editText.setText(jSONObject.getString("search_pattern"));
                        editText2.setText(jSONObject.getString("replacement_pattern"));
                    } catch (JSONException e3) {
                        q.b(e3.getMessage());
                    }
                    final Dialog dialog2 = dialog;
                    dialog.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            String obj = editText.getText().toString();
                            String obj2 = editText2.getText().toString();
                            boolean isChecked = checkBox.isChecked();
                            if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                                Toast.makeText(dialog2.getContext(), "Invalid Input", 0).show();
                                return;
                            }
                            JSONObject jSONObject = null;
                            try {
                                jSONObject = a.this.f51918a.getJSONObject(intValue);
                            } catch (JSONException e2) {
                                String unused = MockUrlActivity.f51885a;
                                e2.getMessage();
                            }
                            try {
                                jSONObject.put("search_pattern", obj);
                                jSONObject.put("replacement_pattern", obj2);
                                jSONObject.put("is_full_replacement", isChecked);
                                MockUrlActivity.b(dialog2.getContext(), a.this.f51918a);
                                Toast.makeText(dialog2.getContext(), "Rule edited successfully", 0).show();
                                a.this.notifyDataSetChanged();
                                dialog2.dismiss();
                            } catch (JSONException e3) {
                                String unused2 = MockUrlActivity.f51885a;
                                e3.getMessage();
                                Toast.makeText(dialog2.getContext(), "Something went wrong while adding rule. Check log", 0).show();
                            }
                        }
                    });
                    dialog.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        View.OnClickListener f51921d = new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f51918a.remove(((Integer) view.getTag()).intValue());
                MockUrlActivity.b(a.this.f51923f, a.this.f51918a);
                a.this.notifyDataSetChanged();
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Context f51923f;

        /* renamed from: g  reason: collision with root package name */
        private LayoutInflater f51924g;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context, JSONArray jSONArray) {
            this.f51923f = context;
            this.f51918a = jSONArray;
            this.f51924g = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final int getCount() {
            return this.f51918a.length();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject getItem(int i2) {
            try {
                return this.f51918a.getJSONObject(i2);
            } catch (JSONException e2) {
                String unused = MockUrlActivity.f51885a;
                e2.getMessage();
                return null;
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f51924g.inflate(R.layout.rule_list_item_view, viewGroup, false);
                bVar.f51936a = (TextView) view2.findViewById(R.id.rule_id);
                bVar.f51937b = (TextView) view2.findViewById(R.id.rule_type);
                bVar.f51938c = (TextView) view2.findViewById(R.id.search_pattern);
                bVar.f51939d = (TextView) view2.findViewById(R.id.replacement_pattern);
                bVar.f51940e = (TextView) view2.findViewById(R.id.is_full_replacement);
                bVar.f51942g = (Button) view2.findViewById(R.id.delete_rule);
                bVar.f51943h = (Button) view2.findViewById(R.id.edit_rule);
                bVar.f51941f = (CheckBox) view2.findViewById(R.id.is_muted);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f51943h.setTag(Integer.valueOf(i2));
            bVar.f51941f.setTag(Integer.valueOf(i2));
            bVar.f51942g.setTag(Integer.valueOf(i2));
            JSONObject a2 = getItem(i2);
            TextView textView = bVar.f51936a;
            textView.setText("Rule Id : " + String.valueOf(i2 + 1));
            try {
                TextView textView2 = bVar.f51937b;
                textView2.setText("Rule Type : " + a2.get("rule_type"));
                TextView textView3 = bVar.f51938c;
                textView3.setText("Search Pattern : " + a2.getString("search_pattern"));
                TextView textView4 = bVar.f51939d;
                textView4.setText("Replacement Pattern : " + a2.getString("replacement_pattern"));
                TextView textView5 = bVar.f51940e;
                textView5.setText("Is full replacement required : " + a2.getString("is_full_replacement"));
                bVar.f51941f.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                bVar.f51941f.setChecked(a2.getBoolean(StringSet.is_muted));
            } catch (JSONException e2) {
                String unused = MockUrlActivity.f51885a;
                e2.getMessage();
            }
            bVar.f51941f.setOnCheckedChangeListener(this.f51919b);
            bVar.f51943h.setOnClickListener(this.f51920c);
            bVar.f51942g.setOnClickListener(this.f51921d);
            return view2;
        }
    }
}
