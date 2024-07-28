package net.one97.paytm.recharge.common.b;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import easypay.manager.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8;
import net.one97.paytm.recharge.common.widget.CJRRcRadioGroupV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.mobile.widget.CJRMobileInputFieldWidgetV8;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;
import net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRcRadioGroupV3;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public CJRProductsItem f60870a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60871b;

    /* renamed from: c  reason: collision with root package name */
    private final Stack<C1172a> f60872c = new Stack<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, View> f60873d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final CJRCategoryDataHelper f60874e;

    public a(CJRCategoryDataHelper cJRCategoryDataHelper) {
        k.c(cJRCategoryDataHelper, "categoryDataHelper");
        this.f60874e = cJRCategoryDataHelper;
    }

    public enum b {
        DROPDOWN("dropdown"),
        LIST("list"),
        OPTION_TICKETS("option_tickets"),
        RADIO_GROUP("radio"),
        GRID(CLPConstants.DEFAULT_GRID_VIEW_TYPE),
        MOBILE("mobile"),
        TEXT(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX),
        AMOUNT("amount"),
        INPUT_GROUPING("inputGrouping"),
        INPUT_RC("relatedCategories"),
        INPUT_PRODUCT_TYPE("productType");
        
        private final String type;

        private b(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.b.a$a  reason: collision with other inner class name */
    public static final class C1172a {

        /* renamed from: a  reason: collision with root package name */
        public final b f60875a;

        /* renamed from: b  reason: collision with root package name */
        final String f60876b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f60877c;

        public final int hashCode() {
            b bVar = this.f60875a;
            int i2 = 0;
            int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
            String str = this.f60876b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Object obj = this.f60877c;
            if (obj != null) {
                i2 = obj.hashCode();
            }
            return hashCode2 + i2;
        }

        public C1172a(b bVar, String str, Object obj) {
            k.c(bVar, "key");
            k.c(str, Constants.EASY_PAY_CONFIG_PREF_KEY);
            k.c(obj, "value");
            this.f60875a = bVar;
            this.f60876b = str;
            this.f60877c = obj;
        }

        public final String toString() {
            return this.f60876b;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof C1172a) && this.f60876b.equals(((C1172a) obj).f60876b);
        }
    }

    public final void a() {
        this.f60872c.clear();
        this.f60873d.clear();
        this.f60870a = null;
    }

    public final boolean b() {
        List<CJRInputFieldsItem> inputFields;
        CJRProductsItem cJRProductsItem;
        List<CJRInputFieldsItem> inputFields2;
        CJRNextGroupData nextGroupItemData;
        GroupAttributesItem groupAttributesItem;
        Collection aggs;
        List<CJRInputFieldsItem> categoryInputFields;
        Collection relatedCategories;
        if (this.f60873d.containsKey(b.INPUT_RC.getType()) || (relatedCategories = this.f60874e.getRelatedCategories()) == null || !(!relatedCategories.isEmpty())) {
            List<CJRInputFieldsItem> categoryInputFields2 = this.f60874e.getCategoryInputFields();
            if (!(categoryInputFields2 == null || categoryInputFields2.isEmpty() || (categoryInputFields = this.f60874e.getCategoryInputFields()) == null)) {
                for (CJRInputFieldsItem a2 : categoryInputFields) {
                    if (a(a2)) {
                        return true;
                    }
                }
            }
            if (!this.f60873d.containsKey(b.INPUT_PRODUCT_TYPE.getType()) && (nextGroupItemData = this.f60874e.getNextGroupItemData()) != null && (groupAttributesItem = nextGroupItemData.getGroupAttributesItem()) != null && groupAttributesItem.getShowAfterInputfield() && (aggs = nextGroupItemData.getAggs()) != null && (!aggs.isEmpty())) {
                List list = (List) aggs;
                if (list.size() > 1) {
                    Stack<C1172a> stack = this.f60872c;
                    b bVar = b.INPUT_PRODUCT_TYPE;
                    stack.push(new C1172a(bVar, bVar.getType(), list));
                    this.f60873d.put(b.INPUT_PRODUCT_TYPE.getType(), (Object) null);
                    return true;
                }
            }
            CJRProductsItem cJRProductsItem2 = this.f60870a;
            if (cJRProductsItem2 == null || (inputFields = cJRProductsItem2.getInputFields()) == null || inputFields.isEmpty() || (cJRProductsItem = this.f60870a) == null || (inputFields2 = cJRProductsItem.getInputFields()) == null) {
                return false;
            }
            for (CJRInputFieldsItem cJRInputFieldsItem : inputFields2) {
                if (cJRInputFieldsItem == null) {
                    k.a();
                }
                if (a(cJRInputFieldsItem)) {
                    return true;
                }
            }
            return false;
        }
        Stack<C1172a> stack2 = this.f60872c;
        b bVar2 = b.INPUT_RC;
        stack2.push(new C1172a(bVar2, bVar2.getType(), (List) relatedCategories));
        this.f60873d.put(b.INPUT_RC.getType(), (Object) null);
        return true;
    }

    private final boolean a(CJRInputFieldsItem cJRInputFieldsItem) {
        if (g.c(cJRInputFieldsItem.getConfigKey())) {
            Map map = this.f60873d;
            String configKey = cJRInputFieldsItem.getConfigKey();
            if (map == null) {
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            } else if (!map.containsKey(configKey) && b.AMOUNT.getType().equals(cJRInputFieldsItem.getType())) {
                Stack<C1172a> stack = this.f60872c;
                b bVar = b.AMOUNT;
                String configKey2 = cJRInputFieldsItem.getConfigKey();
                if (configKey2 == null) {
                    k.a();
                }
                stack.push(new C1172a(bVar, configKey2, cJRInputFieldsItem));
                this.f60873d.put(cJRInputFieldsItem.getConfigKey(), (Object) null);
                return true;
            }
        }
        if (!g.c(cJRInputFieldsItem.getConfigKey())) {
            return false;
        }
        Map map2 = this.f60873d;
        String configKey3 = cJRInputFieldsItem.getConfigKey();
        if (map2 == null) {
            throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        } else if (map2.containsKey(configKey3) || !b.MOBILE.getType().equals(cJRInputFieldsItem.getType())) {
            return false;
        } else {
            Stack<C1172a> stack2 = this.f60872c;
            b bVar2 = b.MOBILE;
            String configKey4 = cJRInputFieldsItem.getConfigKey();
            if (configKey4 == null) {
                k.a();
            }
            stack2.push(new C1172a(bVar2, configKey4, cJRInputFieldsItem));
            this.f60873d.put(cJRInputFieldsItem.getConfigKey(), (Object) null);
            return true;
        }
    }

    public final View a(Context context) {
        k.c(context, "context");
        C1172a peek = this.f60872c.peek();
        k.a((Object) peek, "nextInputStack.peek()");
        return a(context, peek, true);
    }

    public final View b(Context context) {
        k.c(context, "context");
        List<CJRInputFieldsItem> categoryInputFields = this.f60874e.getCategoryInputFields();
        if (categoryInputFields == null) {
            return null;
        }
        for (CJRInputFieldsItem cJRInputFieldsItem : categoryInputFields) {
            if (b.MOBILE.getType().equals(cJRInputFieldsItem.getType())) {
                b bVar = b.MOBILE;
                String configKey = cJRInputFieldsItem.getConfigKey();
                if (configKey == null) {
                    k.a();
                }
                return a(context, new C1172a(bVar, configKey, cJRInputFieldsItem), false);
            }
        }
        return null;
    }

    public static String a(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        String a2 = g.a(str);
        return a2.length() > 10 ? g.b(a2) : a2;
    }

    public final void c() {
        if (this.f60873d.containsKey(b.INPUT_PRODUCT_TYPE.getType())) {
            View view = this.f60873d.get(b.INPUT_PRODUCT_TYPE.getType());
            if (view == null) {
                k.a();
            }
            k.a((Object) view, "inputViewMappings[Type.INPUT_PRODUCT_TYPE.type]!!");
            Object tag = view.getTag();
            if (tag instanceof C1172a) {
                while (!this.f60872c.peek().equals(tag)) {
                    this.f60873d.remove(this.f60872c.pop().f60876b);
                }
                this.f60873d.remove(this.f60872c.pop().f60876b);
            }
        } else {
            d();
        }
        this.f60870a = null;
    }

    public final void d() {
        List<CJRInputFieldsItem> inputFields;
        CJRProductsItem cJRProductsItem;
        List<CJRInputFieldsItem> inputFields2;
        CJRProductsItem cJRProductsItem2 = this.f60870a;
        if (cJRProductsItem2 != null && (inputFields = cJRProductsItem2.getInputFields()) != null && !inputFields.isEmpty() && (cJRProductsItem = this.f60870a) != null && (inputFields2 = cJRProductsItem.getInputFields()) != null) {
            for (CJRInputFieldsItem cJRInputFieldsItem : inputFields2) {
                if (cJRInputFieldsItem == null) {
                    k.a();
                }
                if (g.c(cJRInputFieldsItem.getConfigKey())) {
                    Map map = this.f60873d;
                    String configKey = cJRInputFieldsItem.getConfigKey();
                    if (map == null) {
                        throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                    } else if (map.containsKey(configKey)) {
                        Object obj = this.f60873d.get(cJRInputFieldsItem.getConfigKey());
                        if (obj == null) {
                            k.a();
                        }
                        Object tag = ((View) obj).getTag();
                        if (tag instanceof C1172a) {
                            while (!this.f60872c.peek().equals(tag)) {
                                this.f60873d.remove(this.f60872c.pop().f60876b);
                            }
                            this.f60873d.remove(this.f60872c.pop().f60876b);
                        }
                    }
                }
            }
        }
    }

    public final void e() {
        List<CJRInputFieldsItem> categoryInputFields;
        if (this.f60873d.containsKey(b.INPUT_RC.getType())) {
            View view = this.f60873d.get(b.INPUT_RC.getType());
            if (view == null) {
                k.a();
            }
            k.a((Object) view, "inputViewMappings[Type.INPUT_RC.type]!!");
            Object tag = view.getTag();
            if (tag instanceof C1172a) {
                while (!this.f60872c.peek().equals(tag)) {
                    this.f60873d.remove(this.f60872c.pop().f60876b);
                }
            }
        } else {
            List<CJRInputFieldsItem> categoryInputFields2 = this.f60874e.getCategoryInputFields();
            if (!(categoryInputFields2 == null || categoryInputFields2.isEmpty() || (categoryInputFields = this.f60874e.getCategoryInputFields()) == null)) {
                for (CJRInputFieldsItem cJRInputFieldsItem : categoryInputFields) {
                    if (g.c(cJRInputFieldsItem.getConfigKey())) {
                        Map map = this.f60873d;
                        String configKey = cJRInputFieldsItem.getConfigKey();
                        if (map == null) {
                            throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                        } else if (map.containsKey(configKey)) {
                            Object obj = this.f60873d.get(cJRInputFieldsItem.getConfigKey());
                            if (obj == null) {
                                k.a();
                            }
                            Object tag2 = ((View) obj).getTag();
                            if (tag2 instanceof C1172a) {
                                while (!this.f60872c.peek().equals(tag2)) {
                                    this.f60873d.remove(this.f60872c.pop().f60876b);
                                }
                                this.f60873d.remove(this.f60872c.pop().f60876b);
                            }
                        }
                    }
                }
            }
        }
        this.f60870a = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.view.View r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.String r0 = "inputView"
            kotlin.g.b.k.c(r8, r0)
            java.lang.Object r0 = r8.getTag()
            boolean r1 = r0 instanceof net.one97.paytm.recharge.common.b.a.C1172a
            r2 = 0
            if (r1 == 0) goto L_0x0140
            net.one97.paytm.recharge.common.b.a$a r0 = (net.one97.paytm.recharge.common.b.a.C1172a) r0
            java.lang.Object r1 = r0.f60877c
            if (r1 == 0) goto L_0x0138
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1
            net.one97.paytm.recharge.common.b.a$b r0 = r0.f60875a
            int[] r3 = net.one97.paytm.recharge.common.b.b.f60888b
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 0
            java.lang.String r4 = "inputView.context"
            r5 = 1
            if (r0 == r5) goto L_0x009d
            r6 = 2
            if (r0 == r6) goto L_0x002b
            goto L_0x00d6
        L_0x002b:
            boolean r0 = r8 instanceof net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8
            if (r0 == 0) goto L_0x00d6
            r0 = r8
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = (net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r0
            android.content.Context r6 = r0.getContext()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            java.lang.String r6 = a((android.content.Context) r6, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1, (java.lang.String) r9)
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x004b
            boolean r7 = kotlin.m.p.a(r7)
            if (r7 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r7 = 0
            goto L_0x004c
        L_0x004b:
            r7 = 1
        L_0x004c:
            if (r7 == 0) goto L_0x0059
            android.content.Context r6 = r0.getContext()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            java.lang.String r6 = b(r6, r1, r9)
        L_0x0059:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0063
            return r5
        L_0x0063:
            if (r10 == 0) goto L_0x0098
            android.content.Context r10 = r0.getContext()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
            java.lang.String r4 = "et"
            kotlin.g.b.k.c(r8, r4)
            java.lang.String r4 = "context"
            kotlin.g.b.k.c(r10, r4)
            java.lang.String r4 = "input_method"
            java.lang.Object r10 = r10.getSystemService(r4)     // Catch:{ Exception -> 0x0090 }
            if (r10 == 0) goto L_0x0088
            android.view.inputmethod.InputMethodManager r10 = (android.view.inputmethod.InputMethodManager) r10     // Catch:{ Exception -> 0x0090 }
            android.os.IBinder r8 = r8.getWindowToken()     // Catch:{ Exception -> 0x0090 }
            r10.hideSoftInputFromWindow(r8, r2)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0098
        L_0x0088:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0090 }
            java.lang.String r10 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r8.<init>(r10)     // Catch:{ Exception -> 0x0090 }
            throw r8     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            com.paytm.utility.q.d(r8)
        L_0x0098:
            r0.b((java.lang.String) r6)
            r10 = r6
            goto L_0x00d7
        L_0x009d:
            boolean r10 = r8 instanceof net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8
            if (r10 == 0) goto L_0x00d6
            java.lang.String r10 = r1.getRegex()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x00b2
            java.lang.String r10 = "^([1-9][0-9]{9})"
            r1.setRegex(r10)
        L_0x00b2:
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r8 = (net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r8
            android.content.Context r10 = r8.getContext()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
            java.lang.String r10 = a((android.content.Context) r10, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1, (java.lang.String) r9)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x00c8
            return r5
        L_0x00c8:
            android.content.Context r10 = r8.getContext()
            int r0 = net.one97.paytm.recharge.R.string.mob_no_error
            java.lang.String r10 = r10.getString(r0)
            r8.b((java.lang.String) r10)
            goto L_0x00d7
        L_0x00d6:
            r10 = r3
        L_0x00d7:
            net.one97.paytm.recharge.widgets.c.d r8 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r8 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            r8.setErrorType(r0)
            r8.setErrorMsg(r10)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r10 = r8.getFlowName()
            if (r10 == 0) goto L_0x0114
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Input Config key - "
            r0.<init>(r3)
            java.lang.String r3 = r1.getConfigKey()
            r0.append(r3)
            java.lang.String r3 = " Input Type - "
            r0.append(r3)
            java.lang.String r1 = r1.getType()
            r0.append(r1)
            java.lang.String r1 = " Input text - "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.setOtherDetails(r9)
        L_0x0114:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r9 = r8.getFlowName()
            if (r9 == 0) goto L_0x0123
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r10 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            java.lang.String r10 = r10.name()
            r9.setErrorType(r10)
        L_0x0123:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r9 = r8.getFlowName()
            if (r9 == 0) goto L_0x0132
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r10 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r10 = r10.name()
            r9.setActionType(r10)
        L_0x0132:
            net.one97.paytm.recharge.common.utils.az r9 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8)
            goto L_0x0140
        L_0x0138:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRInputFieldsItem"
            r8.<init>(r9)
            throw r8
        L_0x0140:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.a.a(android.view.View, java.lang.String, boolean):boolean");
    }

    private static String b(Context context, CJRInputFieldsItem cJRInputFieldsItem, String str) {
        String str2;
        String string;
        Double max = cJRInputFieldsItem.getMax();
        double doubleValue = max != null ? max.doubleValue() : 1.0d;
        Double min = cJRInputFieldsItem.getMin();
        double doubleValue2 = min != null ? min.doubleValue() : 0.0d;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    k.a();
                }
                if (Double.parseDouble(str) < doubleValue2) {
                    str2 = context.getString(R.string.electricity_bill_amount_more_than, new Object[]{String.valueOf(doubleValue2)});
                    k.a((Object) str2, "context.getString(\n     …       minAmt.toString())");
                    if (doubleValue < doubleValue2) {
                        return str2;
                    }
                    try {
                        string = context.getString(R.string.electricity_bill_amount_not_in_range, new Object[]{String.valueOf(doubleValue2), String.valueOf(doubleValue)});
                        k.a((Object) string, "context.getString(\n     …ing(), maxAmt.toString())");
                        return string;
                    } catch (Exception e2) {
                        e = e2;
                        CJRRechargeUtilities.INSTANCE.debugLogExceptions(e);
                        return str2;
                    }
                }
            }
            if (doubleValue >= doubleValue2) {
                if (str == null) {
                    str = "";
                }
                if (Double.parseDouble(str) > doubleValue) {
                    string = context.getString(R.string.electricity_bill_amount_not_in_range, new Object[]{String.valueOf(doubleValue2), String.valueOf(doubleValue)});
                    k.a((Object) string, "context.getString(\n     …ing(), maxAmt.toString())");
                    return string;
                }
            }
            return "";
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e);
            return str2;
        }
    }

    public static String a(Context context, CJRInputFieldsItem cJRInputFieldsItem, String str) {
        k.c(context, "context");
        k.c(cJRInputFieldsItem, "inputField");
        String regex = cJRInputFieldsItem.getRegex();
        String title = cJRInputFieldsItem.getTitle();
        if (str != null) {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            String obj = charSequence.subSequence(i2, length + 1).toString();
            if (obj != null) {
                if (obj.length() == 0) {
                    String string = context.getString(R.string.electricity_empty_value_msg, new Object[]{title});
                    k.a((Object) string, "context.getString(R.stri…y_empty_value_msg, title)");
                    return string;
                }
            }
        }
        try {
            if (!TextUtils.isEmpty(regex) && str != null) {
                CharSequence charSequence2 = str;
                if (regex == null) {
                    k.a();
                }
                if (!new l(regex).matches(charSequence2)) {
                    String string2 = context.getString(R.string.electricity_empty_value_msg, new Object[]{title});
                    k.a((Object) string2, "context.getString(R.stri…y_empty_value_msg, title)");
                    return string2;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    static final class d implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final d f60886a = new d();

        d() {
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            CharSequence charSequence2 = charSequence;
            while (i2 < i3) {
                if (Character.isDigit(charSequence.charAt(i2)) || charSequence.charAt(i2) == ' ') {
                    i2++;
                } else {
                    k.a((Object) charSequence2, "result");
                    charSequence2 = p.a(charSequence2, i2, i2 + 1);
                    i3--;
                }
            }
            if (charSequence2 == null) {
                k.a();
            }
            return charSequence2;
        }
    }

    private static InputFilter[] b(String str) {
        return new InputFilter[]{new InputFilter.LengthFilter(11), new c(Pattern.compile(str))};
    }

    static final class c implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Pattern f60881a;

        c(Pattern pattern) {
            this.f60881a = pattern;
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            CharSequence charSequence2 = spanned;
            StringBuilder sb = new StringBuilder(charSequence2);
            sb.append(charSequence);
            StringBuilder sb2 = new StringBuilder(charSequence2);
            sb2.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            if (k.a((Object) sb.toString(), (Object) AppUtility.CENTER_DOT)) {
                return "";
            }
            if (!this.f60881a.matcher(ba.e(sb2.toString())).matches()) {
                return "";
            }
            return null;
        }
    }

    private final View a(Context context, C1172a aVar, boolean z) {
        CJRMobileRadioGroupV8 cJRMobileRadioGroupV8;
        CJRMobileInputFieldWidgetV8 cJRMobileInputFieldWidgetV8;
        CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8;
        int i2 = b.f60887a[aVar.f60875a.ordinal()];
        int i3 = 0;
        if (i2 == 1) {
            Object obj = aVar.f60877c;
            if (obj != null) {
                List list = (List) obj;
                if (!list.isEmpty()) {
                    if (this.f60871b) {
                        ba.a();
                    }
                    if (this.f60871b) {
                        cJRMobileRadioGroupV8 = new CJRRcRadioGroupV3(context, list, (byte) 0);
                    } else {
                        cJRMobileRadioGroupV8 = new CJRRcRadioGroupV8(context, list, (byte) 0);
                    }
                    cJRMobileRadioGroupV8.setTag(aVar);
                    if (z) {
                        this.f60873d.put(aVar.f60876b, cJRMobileRadioGroupV8);
                    }
                    return cJRMobileRadioGroupV8;
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
        } else if (i2 == 2) {
            Object obj2 = aVar.f60877c;
            if (obj2 != null) {
                CJRInputFieldsItem cJRInputFieldsItem = (CJRInputFieldsItem) obj2;
                if (this.f60871b) {
                    cJRMobileInputFieldWidgetV8 = new CJRMobileInputFieldWidgetV3(context);
                } else {
                    cJRMobileInputFieldWidgetV8 = new CJRMobileInputFieldWidgetV8(context);
                }
                cJRMobileInputFieldWidgetV8.f61892c = true;
                cJRMobileInputFieldWidgetV8.setInputHintText(cJRInputFieldsItem.getTitle());
                cJRMobileInputFieldWidgetV8.setInputType(524291);
                cJRMobileInputFieldWidgetV8.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11), d.f60886a});
                cJRMobileInputFieldWidgetV8.setTag(aVar);
                if (z) {
                    this.f60873d.put(aVar.f60876b, cJRMobileInputFieldWidgetV8);
                }
                return cJRMobileInputFieldWidgetV8;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRInputFieldsItem");
        } else if (i2 == 3) {
            Object obj3 = aVar.f60877c;
            if (obj3 != null) {
                CJRInputFieldsItem cJRInputFieldsItem2 = (CJRInputFieldsItem) obj3;
                if (this.f60871b) {
                    cJRAmountInputFieldWidgetV8 = new CJRAmountInputFieldWidgetV3(context);
                } else {
                    cJRAmountInputFieldWidgetV8 = new CJRAmountInputFieldWidgetV8(context);
                }
                cJRAmountInputFieldWidgetV8.f61892c = true;
                cJRAmountInputFieldWidgetV8.setInputHintText(cJRInputFieldsItem2.getTitle());
                cJRAmountInputFieldWidgetV8.setInputType(536578);
                cJRAmountInputFieldWidgetV8.setTag(aVar);
                if (g.c(cJRInputFieldsItem2.getRegex())) {
                    cJRAmountInputFieldWidgetV8.setFilters(b(cJRInputFieldsItem2.getRegex()));
                } else {
                    try {
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        Integer I = net.one97.paytm.recharge.di.helper.c.I();
                        if (I != null) {
                            i3 = I.intValue();
                        }
                    } catch (Exception e2) {
                        q.d(e2.getMessage());
                    }
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    cJRInputFieldsItem2.setRegex("(([1-9]{1})([0-9]{0," + (i3 - 1) + "}))");
                    cJRAmountInputFieldWidgetV8.setFilters(b(cJRInputFieldsItem2.getRegex()));
                }
                if (z) {
                    this.f60873d.put(aVar.f60876b, cJRAmountInputFieldWidgetV8);
                }
                return cJRAmountInputFieldWidgetV8;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRInputFieldsItem");
        } else if (i2 != 4) {
            return null;
        } else {
            Object obj4 = aVar.f60877c;
            if (obj4 != null) {
                List list2 = (List) obj4;
                if (!list2.isEmpty()) {
                    CJRMobileRadioGroupV8 cJRMobileRadioGroupV82 = new CJRMobileRadioGroupV8(context, list2, (byte) 0);
                    cJRMobileRadioGroupV82.setTag(aVar);
                    if (z) {
                        this.f60873d.put(aVar.f60876b, cJRMobileRadioGroupV82);
                    }
                    return cJRMobileRadioGroupV82;
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
        }
        return null;
    }
}
