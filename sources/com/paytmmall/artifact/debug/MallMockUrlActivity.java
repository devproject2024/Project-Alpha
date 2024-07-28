package com.paytmmall.artifact.debug;

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
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.j;
import com.paytmmall.artifact.d.u;
import com.sendbird.android.constant.StringSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MallMockUrlActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15768a = MallMockUrlActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private View f15769b;

    /* renamed from: c  reason: collision with root package name */
    private View f15770c;

    /* renamed from: d  reason: collision with root package name */
    private View f15771d;

    /* renamed from: e  reason: collision with root package name */
    private View f15772e;

    /* renamed from: f  reason: collision with root package name */
    private View f15773f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ListView f15774g;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f15814a;

        /* renamed from: b  reason: collision with root package name */
        TextView f15815b;

        /* renamed from: c  reason: collision with root package name */
        TextView f15816c;

        /* renamed from: d  reason: collision with root package name */
        TextView f15817d;

        /* renamed from: e  reason: collision with root package name */
        TextView f15818e;

        /* renamed from: f  reason: collision with root package name */
        CheckBox f15819f;

        /* renamed from: g  reason: collision with root package name */
        Button f15820g;

        /* renamed from: h  reason: collision with root package name */
        Button f15821h;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_mall_debug);
        this.f15770c = findViewById(R.id.remove_all_rules);
        this.f15770c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = new JSONArray();
                MallMockUrlActivity.a(view.getContext(), jSONArray);
                MallMockUrlActivity.this.f15774g.setAdapter(new a(view.getContext(), jSONArray));
            }
        });
        this.f15771d = findViewById(R.id.set_default_rules);
        this.f15771d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray b2 = MallMockUrlActivity.c(view.getContext());
                MallMockUrlActivity.a(view.getContext(), b2);
                MallMockUrlActivity.this.f15774g.setAdapter(new a(view.getContext(), b2));
            }
        });
        this.f15772e = findViewById(R.id.mute_all_rules);
        this.f15772e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = ((a) MallMockUrlActivity.this.f15774g.getAdapter()).f15796a;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        jSONArray.getJSONObject(i2).put(StringSet.is_muted, true);
                    } catch (JSONException e2) {
                        String unused = MallMockUrlActivity.f15768a;
                        q.c(e2.getMessage());
                    }
                }
                MallMockUrlActivity.a(view.getContext(), jSONArray);
                ((a) MallMockUrlActivity.this.f15774g.getAdapter()).notifyDataSetChanged();
            }
        });
        this.f15773f = findViewById(R.id.unmute_all_rules);
        this.f15773f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                JSONArray jSONArray = ((a) MallMockUrlActivity.this.f15774g.getAdapter()).f15796a;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        jSONArray.getJSONObject(i2).put(StringSet.is_muted, false);
                    } catch (JSONException e2) {
                        String unused = MallMockUrlActivity.f15768a;
                        q.c(e2.getMessage());
                    }
                }
                MallMockUrlActivity.a(view.getContext(), jSONArray);
                ((a) MallMockUrlActivity.this.f15774g.getAdapter()).notifyDataSetChanged();
            }
        });
        this.f15769b = findViewById(R.id.add_rule);
        this.f15769b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                final Dialog dialog = new Dialog(MallMockUrlActivity.this);
                dialog.setContentView(R.layout.mall_debug_activity_add_rule_layout);
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
                        JSONArray a2 = MallMockUrlActivity.a(dialog2.getContext());
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("rule_type", radioButton.isChecked() ? "String Replacement" : "GTM Override");
                            jSONObject.put("search_pattern", obj);
                            jSONObject.put("replacement_pattern", obj2);
                            jSONObject.put("is_full_replacement", isChecked);
                            jSONObject.put(StringSet.is_muted, false);
                            a2.put(jSONObject);
                            MallMockUrlActivity.a(dialog2.getContext(), a2);
                            Toast.makeText(dialog2.getContext(), "Rule added successfully", 0).show();
                            MallMockUrlActivity.this.f15774g.setAdapter(new a(dialog2.getContext(), MallMockUrlActivity.a(dialog2.getContext())));
                            dialog2.dismiss();
                        } catch (JSONException e2) {
                            String unused = MallMockUrlActivity.f15768a;
                            e2.getMessage();
                            boolean z = c.f15691a;
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
        this.f15774g = (ListView) findViewById(R.id.rule_list);
        this.f15774g.setAdapter(new a(this, a((Context) this)));
    }

    public static JSONArray a(Context context) {
        String b2 = u.a(context.getApplicationContext()).b("key_added_rule", "", true);
        if (TextUtils.isEmpty(b2)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(b2);
        } catch (JSONException e2) {
            e2.getMessage();
            boolean z = c.f15691a;
            return new JSONArray();
        }
    }

    /* access modifiers changed from: private */
    public static JSONArray c(Context context) {
        try {
            return new JSONArray(d.e(context, "mall_default_debug_rule_set.json"));
        } catch (JSONException e2) {
            e2.getMessage();
            boolean z = c.f15691a;
            return null;
        }
    }

    class a extends BaseAdapter {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public JSONArray f15796a;

        /* renamed from: b  reason: collision with root package name */
        CompoundButton.OnCheckedChangeListener f15797b = new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                try {
                    a.this.f15796a.getJSONObject(((Integer) compoundButton.getTag()).intValue()).put(StringSet.is_muted, z);
                } catch (JSONException e2) {
                    String unused = MallMockUrlActivity.f15768a;
                    e2.getMessage();
                    boolean z2 = c.f15691a;
                }
                MallMockUrlActivity.a(a.this.f15801f, a.this.f15796a);
                a.this.notifyDataSetChanged();
            }
        };

        /* renamed from: c  reason: collision with root package name */
        View.OnClickListener f15798c = new View.OnClickListener() {
            public final void onClick(View view) {
                final int intValue = ((Integer) view.getTag()).intValue();
                if (Build.VERSION.SDK_INT >= 16) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = a.this.f15796a.getJSONObject(intValue);
                    } catch (JSONException e2) {
                        String unused = MallMockUrlActivity.f15768a;
                        e2.getMessage();
                        boolean z = c.f15691a;
                    }
                    final Dialog dialog = new Dialog(MallMockUrlActivity.this);
                    dialog.setContentView(R.layout.mall_debug_activity_add_rule_layout);
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
                        String unused2 = MallMockUrlActivity.f15768a;
                        q.c(e3.getMessage());
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
                                jSONObject = a.this.f15796a.getJSONObject(intValue);
                            } catch (JSONException e2) {
                                String unused = MallMockUrlActivity.f15768a;
                                e2.getMessage();
                                boolean z = c.f15691a;
                            }
                            try {
                                jSONObject.put("search_pattern", obj);
                                jSONObject.put("replacement_pattern", obj2);
                                jSONObject.put("is_full_replacement", isChecked);
                                MallMockUrlActivity.a(dialog2.getContext(), a.this.f15796a);
                                Toast.makeText(dialog2.getContext(), "Rule edited successfully", 0).show();
                                a.this.notifyDataSetChanged();
                                dialog2.dismiss();
                            } catch (JSONException e3) {
                                String unused2 = MallMockUrlActivity.f15768a;
                                e3.getMessage();
                                boolean z2 = c.f15691a;
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
        View.OnClickListener f15799d = new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f15796a.remove(((Integer) view.getTag()).intValue());
                MallMockUrlActivity.a(a.this.f15801f, a.this.f15796a);
                a.this.notifyDataSetChanged();
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Context f15801f;

        /* renamed from: g  reason: collision with root package name */
        private LayoutInflater f15802g;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context, JSONArray jSONArray) {
            this.f15801f = context;
            this.f15796a = jSONArray;
            this.f15802g = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final int getCount() {
            return this.f15796a.length();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject getItem(int i2) {
            try {
                return this.f15796a.getJSONObject(i2);
            } catch (JSONException e2) {
                String unused = MallMockUrlActivity.f15768a;
                e2.getMessage();
                boolean z = c.f15691a;
                return null;
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f15802g.inflate(R.layout.mall_rule_list_item_view, viewGroup, false);
                bVar.f15814a = (TextView) view2.findViewById(R.id.rule_id);
                bVar.f15815b = (TextView) view2.findViewById(R.id.rule_type);
                bVar.f15816c = (TextView) view2.findViewById(R.id.search_pattern);
                bVar.f15817d = (TextView) view2.findViewById(R.id.replacement_pattern);
                bVar.f15818e = (TextView) view2.findViewById(R.id.is_full_replacement);
                bVar.f15820g = (Button) view2.findViewById(R.id.delete_rule);
                bVar.f15821h = (Button) view2.findViewById(R.id.edit_rule);
                bVar.f15819f = (CheckBox) view2.findViewById(R.id.is_muted);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f15821h.setTag(Integer.valueOf(i2));
            bVar.f15819f.setTag(Integer.valueOf(i2));
            bVar.f15820g.setTag(Integer.valueOf(i2));
            JSONObject a2 = getItem(i2);
            TextView textView = bVar.f15814a;
            textView.setText("Rule Id : " + String.valueOf(i2 + 1));
            try {
                TextView textView2 = bVar.f15815b;
                textView2.setText("Rule Type : " + a2.get("rule_type"));
                TextView textView3 = bVar.f15816c;
                textView3.setText("Search Pattern : " + a2.getString("search_pattern"));
                TextView textView4 = bVar.f15817d;
                textView4.setText("Replacement Pattern : " + a2.getString("replacement_pattern"));
                TextView textView5 = bVar.f15818e;
                textView5.setText("Is full replacement required : " + a2.getString("is_full_replacement"));
                bVar.f15819f.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                bVar.f15819f.setChecked(a2.getBoolean(StringSet.is_muted));
            } catch (JSONException e2) {
                String unused = MallMockUrlActivity.f15768a;
                e2.getMessage();
                boolean z = c.f15691a;
            }
            bVar.f15819f.setOnCheckedChangeListener(this.f15797b);
            bVar.f15821h.setOnClickListener(this.f15798c);
            bVar.f15820g.setOnClickListener(this.f15799d);
            return view2;
        }
    }

    static /* synthetic */ void a(Context context, JSONArray jSONArray) {
        u.a(context.getApplicationContext()).a("key_added_rule", jSONArray.toString(), true);
        j.f15722a = jSONArray;
    }
}
