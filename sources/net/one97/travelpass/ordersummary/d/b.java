package net.one97.travelpass.ordersummary.d;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.one97.travelpass.ordersummary.g.a;
import net.one97.travelpass.ordersummary.model.OrderSummary;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;
import net.one97.travelpass.ordersummary.model.OrderSummaryFiled;

public final class b {
    public static ArrayList<a> a(OrderSummaryBodyItem orderSummaryBodyItem) {
        List<OrderSummaryFiled> fields;
        ArrayList<a> arrayList = new ArrayList<>();
        if (!(orderSummaryBodyItem == null || (fields = orderSummaryBodyItem.getFields()) == null || fields.isEmpty())) {
            for (OrderSummaryFiled a2 : fields) {
                a aVar = new a();
                aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_DETAIL_ITEM);
                aVar.a((IJRPaytmDataModel) a2);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r5 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.IJRPaytmDataModel a(java.lang.String r4, net.one97.travelpass.ordersummary.model.OrderSummary r5) {
        /*
            java.lang.String r0 = "type"
            kotlin.g.b.k.c(r4, r0)
            r0 = 0
            if (r5 == 0) goto L_0x0013
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x0013
            java.util.List r5 = r5.getBody()
            goto L_0x0014
        L_0x0013:
            r5 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0034
            java.util.Iterator r5 = r5.iterator()
        L_0x001a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r5.next()
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r1 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r1
            java.lang.String r2 = r1.getType()
            r3 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x001a
            r0 = r1
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.d.b.a(java.lang.String, net.one97.travelpass.ordersummary.model.OrderSummary):com.paytm.network.model.IJRPaytmDataModel");
    }

    public static ArrayList<a> a(OrderSummary orderSummary) {
        int size;
        ArrayList<a> arrayList = new ArrayList<>();
        if (orderSummary != null) {
            List<OrderSummaryFiled> list = null;
            if (orderSummary != null) {
                IJRPaytmDataModel a2 = a("paymentDetails", orderSummary);
                if (!(a2 instanceof OrderSummaryBodyItem)) {
                    a2 = null;
                }
                OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
                if (orderSummaryBodyItem != null) {
                    list = orderSummaryBodyItem.getFields();
                }
            }
            Collection collection = list;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty()) && (size = list.size() - 1) >= 0) {
                while (true) {
                    OrderSummaryFiled orderSummaryFiled = list.get(i2);
                    a aVar = new a();
                    aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_PAYMENT_DETAIL_ITEM);
                    if (i2 == list.size() - 1) {
                        aVar.e();
                    }
                    aVar.a((IJRPaytmDataModel) orderSummaryFiled);
                    arrayList.add(aVar);
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<a> b(OrderSummary orderSummary) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (orderSummary != null) {
            List<OrderSummaryFiled> list = null;
            if (orderSummary != null) {
                IJRPaytmDataModel a2 = a("paymentBreakup", orderSummary);
                if (!(a2 instanceof OrderSummaryBodyItem)) {
                    a2 = null;
                }
                OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
                if (orderSummaryBodyItem != null) {
                    list = orderSummaryBodyItem.getFields();
                }
            }
            Collection collection = list;
            if (!(collection == null || collection.isEmpty())) {
                for (OrderSummaryFiled a3 : list) {
                    a aVar = new a();
                    aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_PAYMENT_BREAKUP_ITEM);
                    aVar.a((IJRPaytmDataModel) a3);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<a> c(OrderSummary orderSummary) {
        int size;
        ArrayList<a> arrayList = new ArrayList<>();
        if (orderSummary != null) {
            List<OrderSummaryFiled> list = null;
            if (orderSummary != null) {
                IJRPaytmDataModel a2 = a("refundCard1", orderSummary);
                if (!(a2 instanceof OrderSummaryBodyItem)) {
                    a2 = null;
                }
                OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
                if (orderSummaryBodyItem != null) {
                    list = orderSummaryBodyItem.getFields();
                }
            }
            Collection collection = list;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty()) && (size = list.size() - 1) >= 0) {
                while (true) {
                    a aVar = new a();
                    aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_REFUND_INFO_ITEM);
                    aVar.a((IJRPaytmDataModel) list.get(i2));
                    if (i2 == 0) {
                        aVar.h();
                    }
                    arrayList.add(aVar);
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<a> d(OrderSummary orderSummary) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (orderSummary != null) {
            List<OrderSummaryFiled> list = null;
            if (orderSummary != null) {
                IJRPaytmDataModel a2 = a("refundCard2", orderSummary);
                if (!(a2 instanceof OrderSummaryBodyItem)) {
                    a2 = null;
                }
                OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
                if (orderSummaryBodyItem != null) {
                    list = orderSummaryBodyItem.getFields();
                }
            }
            Collection collection = list;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty())) {
                OrderSummaryFiled orderSummaryFiled = new OrderSummaryFiled();
                int size = list.size() - 1;
                if (size >= 0) {
                    while (true) {
                        OrderSummaryFiled orderSummaryFiled2 = list.get(i2);
                        if (i2 == 0) {
                            orderSummaryFiled.setLabel(orderSummaryFiled2.getLabel());
                            orderSummaryFiled.setValue(orderSummaryFiled2.getValue());
                        } else {
                            orderSummaryFiled.setSubContent(orderSummaryFiled2.getLabel() + " " + orderSummaryFiled2.getValue());
                        }
                        if (i2 == size) {
                            break;
                        }
                        i2++;
                    }
                }
                a aVar = new a();
                aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_REFUND_DETAIL_ITEM);
                aVar.a((IJRPaytmDataModel) orderSummaryFiled);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static ArrayList<a> e(OrderSummary orderSummary) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (orderSummary != null) {
            List<OrderSummaryFiled> list = null;
            if (orderSummary != null) {
                IJRPaytmDataModel a2 = a("walletRefund", orderSummary);
                if (!(a2 instanceof OrderSummaryBodyItem)) {
                    a2 = null;
                }
                OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
                if (orderSummaryBodyItem != null) {
                    list = orderSummaryBodyItem.getFields();
                }
            }
            Collection collection = list;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty())) {
                OrderSummaryFiled orderSummaryFiled = new OrderSummaryFiled();
                int size = list.size() - 1;
                if (size >= 0) {
                    while (true) {
                        OrderSummaryFiled orderSummaryFiled2 = list.get(i2);
                        if (i2 == 0) {
                            orderSummaryFiled.setLabel(orderSummaryFiled2.getLabel());
                            orderSummaryFiled.setValue(orderSummaryFiled2.getValue());
                        } else if (i2 == list.size() - 1) {
                            orderSummaryFiled.setDeepLinkText(orderSummaryFiled2.getLabel());
                            orderSummaryFiled.setDeepLink(orderSummaryFiled2.getDeepLink());
                        } else {
                            orderSummaryFiled.setSubContent(orderSummaryFiled2.getLabel() + " " + orderSummaryFiled2.getValue());
                        }
                        if (i2 == size) {
                            break;
                        }
                        i2++;
                    }
                }
                a aVar = new a();
                aVar.a(net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_WALLET_REFUND_ITEM);
                aVar.a((IJRPaytmDataModel) orderSummaryFiled);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
