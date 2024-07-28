package com.paytm.android.chat.utils;

import com.paytm.android.chat.R;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.UserMessage;

public class MessageContentUtils {

    public static class MessageContentBean {
        public String content;
        public int res;
    }

    public static String getContent(BaseMessage baseMessage) {
        if (baseMessage == null) {
            return "";
        }
        String customType = baseMessage.getCustomType();
        if (baseMessage instanceof UserMessage) {
            return ((UserMessage) baseMessage).getMessage();
        }
        if (baseMessage instanceof FileMessage) {
            return customType;
        }
        return "";
    }

    public static int getMessageIcon(String str) {
        if (str == null) {
            str = "";
        }
        if (str.equals("contact")) {
            return R.drawable.chat_icon_chat_multi_item_contact2;
        }
        if (str.equals("Audio")) {
            return R.drawable.chat_icon_chat_multi_item_audio;
        }
        if (str.equals("Image")) {
            return R.drawable.chat_icon_chat_message_type_photo;
        }
        if (str.equals("File")) {
            return R.drawable.chat_icon_chat_multi_item_document;
        }
        return 0;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.android.chat.utils.MessageContentUtils.MessageContentBean getContentBean(com.sendbird.android.BaseMessage r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean r1 = new com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean
            r1.<init>()
            boolean r2 = r7 instanceof com.sendbird.android.UserMessage
            r3 = 0
            if (r2 == 0) goto L_0x01d2
            r0 = r7
            com.sendbird.android.UserMessage r0 = (com.sendbird.android.UserMessage) r0
            com.sendbird.android.Sender r2 = r0.getSender()
            java.lang.String r4 = r7.getCustomType()
            java.lang.String r5 = "TRANSFER"
            boolean r4 = r4.equals(r5)
            r5 = 1
            if (r4 == 0) goto L_0x00ac
            if (r2 == 0) goto L_0x028e
            com.sendbird.android.shadow.com.google.gson.Gson r0 = new com.sendbird.android.shadow.com.google.gson.Gson     // Catch:{ Exception -> 0x028e }
            r0.<init>()     // Catch:{ Exception -> 0x028e }
            java.lang.String r7 = r7.getData()     // Catch:{ Exception -> 0x028e }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r4 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r4)     // Catch:{ Exception -> 0x028e }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r7 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r7     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = r2.getUserId()     // Catch:{ Exception -> 0x028e }
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x028e }
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x028e }
            java.lang.String r2 = "Pending ₹%1$s"
            r4 = 2
            if (r0 == 0) goto L_0x0079
            int r0 = r7.getStatus()     // Catch:{ Exception -> 0x028e }
            if (r0 != r4) goto L_0x005d
            r1.res = r3     // Catch:{ Exception -> 0x028e }
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x028e }
            r0[r3] = r4     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = java.lang.String.format(r2, r0)     // Catch:{ Exception -> 0x028e }
            r1.content = r0     // Catch:{ Exception -> 0x028e }
            goto L_0x0071
        L_0x005d:
            int r0 = com.paytm.android.chat.R.drawable.chat_ic_payment_new     // Catch:{ Exception -> 0x028e }
            r1.res = r0     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = "Paid ₹%1$s"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x028e }
            r2[r3] = r4     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ Exception -> 0x028e }
            r1.content = r0     // Catch:{ Exception -> 0x028e }
        L_0x0071:
            java.lang.String r7 = r7.getSender_preview_text()     // Catch:{ Exception -> 0x028e }
            r1.content = r7     // Catch:{ Exception -> 0x028e }
            goto L_0x028e
        L_0x0079:
            int r0 = r7.getStatus()     // Catch:{ Exception -> 0x028e }
            if (r0 != r4) goto L_0x0090
            r1.res = r3     // Catch:{ Exception -> 0x028e }
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x028e }
            r0[r3] = r4     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = java.lang.String.format(r2, r0)     // Catch:{ Exception -> 0x028e }
            r1.content = r0     // Catch:{ Exception -> 0x028e }
            goto L_0x00a4
        L_0x0090:
            int r0 = com.paytm.android.chat.R.drawable.chat_ic_payment_new     // Catch:{ Exception -> 0x028e }
            r1.res = r0     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = "Received ₹%1$s"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x028e }
            r2[r3] = r4     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ Exception -> 0x028e }
            r1.content = r0     // Catch:{ Exception -> 0x028e }
        L_0x00a4:
            java.lang.String r7 = r7.getReceiver_preview_text()     // Catch:{ Exception -> 0x028e }
            r1.content = r7     // Catch:{ Exception -> 0x028e }
            goto L_0x028e
        L_0x00ac:
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r4 = "MINI_APP_BASIC_NOTIFICATION"
            boolean r2 = r2.equals(r4)
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x00ea
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r0 = new com.paytm.android.chat.data.models.messages.MiniAppNotificationBean
            r0.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r2 = new com.sendbird.android.shadow.com.google.gson.Gson
            r2.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.MiniAppNotificationData> r5 = com.paytm.android.chat.data.models.messages.MiniAppNotificationData.class
            java.lang.Object r7 = r2.fromJson((java.lang.String) r7, r5)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationData) r7
            r0.setNotifData(r7)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = r0.getNotifData()
            if (r7 == 0) goto L_0x00e4
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = r0.getNotifData()
            java.lang.String r7 = r7.getPreview_text()
            r1.content = r7
            goto L_0x00e6
        L_0x00e4:
            r1.content = r4
        L_0x00e6:
            r1.res = r3
            goto L_0x028e
        L_0x00ea:
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r6 = "GENERIC_NOTIF"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0126
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r0 = new com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel
            r0.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r2 = new com.sendbird.android.shadow.com.google.gson.Gson
            r2.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean> r5 = com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean.class
            java.lang.Object r7 = r2.fromJson((java.lang.String) r7, r5)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean) r7
            r0.setData(r7)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = r0.getData()
            if (r7 == 0) goto L_0x0120
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = r0.getData()
            java.lang.String r7 = r7.getPreview_text()
            r1.content = r7
            goto L_0x0122
        L_0x0120:
            r1.content = r4
        L_0x0122:
            r1.res = r3
            goto L_0x028e
        L_0x0126:
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r4 = "TRANSFER_FAIL"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x015f
            com.sendbird.android.shadow.com.google.gson.Gson r0 = new com.sendbird.android.shadow.com.google.gson.Gson
            r0.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r2 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r2)
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r7 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r7
            int r0 = com.paytm.android.chat.R.drawable.chat_icon_group_chat_message_state_fail
            r1.res = r0
            int r0 = com.paytm.android.chat.R.string.chat_list_transfer_fail
            java.lang.String r2 = "Transfer of %s Failed"
            java.lang.String r0 = com.paytm.android.chat.c.a(r0, r2)
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r7 = r7.getAmount()
            r2[r3] = r7
            java.lang.String r7 = java.lang.String.format(r0, r2)
            r1.content = r7
            goto L_0x028e
        L_0x015f:
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r3 = "contact"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0177
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_contact2
            r1.res = r7
            java.lang.String r7 = r0.getMessage()
            r1.content = r7
            goto L_0x028e
        L_0x0177:
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r3 = "UPI_REQUEST"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 != 0) goto L_0x0198
            java.lang.String r2 = r7.getCustomType()
            java.lang.String r3 = "UPI_RESPONSE"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0190
            goto L_0x0198
        L_0x0190:
            java.lang.String r7 = r0.getMessage()
            r1.content = r7
            goto L_0x028e
        L_0x0198:
            r0 = r7
            com.sendbird.android.UserMessage r0 = (com.sendbird.android.UserMessage) r0     // Catch:{ Exception -> 0x01ca }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x01ca }
            java.lang.String r3 = r0.getData()     // Catch:{ Exception -> 0x01ca }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01ca }
            java.lang.String r3 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x01ca }
            com.sendbird.android.Sender r0 = r0.getSender()     // Catch:{ Exception -> 0x01ca }
            java.lang.String r0 = r0.getUserId()     // Catch:{ Exception -> 0x01ca }
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01ca }
            if (r0 == 0) goto L_0x01c0
            java.lang.String r0 = "sender_preview_text"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x01ca }
            r1.content = r0     // Catch:{ Exception -> 0x01ca }
            goto L_0x028e
        L_0x01c0:
            java.lang.String r0 = "receiver_preview_text"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x01ca }
            r1.content = r0     // Catch:{ Exception -> 0x01ca }
            goto L_0x028e
        L_0x01ca:
            java.lang.String r7 = r7.getMessage()
            r1.content = r7
            goto L_0x028e
        L_0x01d2:
            boolean r2 = r7 instanceof com.sendbird.android.FileMessage
            if (r2 == 0) goto L_0x024e
            java.lang.String r2 = r7.getData()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01f1
            com.sendbird.android.shadow.com.google.gson.Gson r0 = new com.sendbird.android.shadow.com.google.gson.Gson
            r0.<init>()
            java.lang.String r2 = r7.getData()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r3 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r2, r3)
            com.paytm.android.chat.bean.jsonbean.FileDataBean r0 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r0
        L_0x01f1:
            com.sendbird.android.FileMessage r7 = (com.sendbird.android.FileMessage) r7
            java.lang.String r7 = r7.getType()
            java.lang.String r2 = r7.toLowerCase()
            java.lang.String r3 = "audio"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x0221
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_audio
            r1.res = r7
            if (r0 == 0) goto L_0x028e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r2 = "Audio"
            r7.<init>(r2)
            long r2 = r0.time
            java.lang.String r0 = com.paytm.android.chat.utils.DateUtils.getAudioTime(r2)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r1.content = r7
            goto L_0x028e
        L_0x0221:
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r2 = "image"
            boolean r7 = r7.startsWith(r2)
            if (r7 == 0) goto L_0x0245
            if (r0 == 0) goto L_0x023c
            java.lang.String r7 = r0.message
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x023c
            java.lang.String r7 = r0.message
            r1.content = r7
            goto L_0x0240
        L_0x023c:
            java.lang.String r7 = "Photo"
            r1.content = r7
        L_0x0240:
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo
            r1.res = r7
            goto L_0x028e
        L_0x0245:
            java.lang.String r7 = "Document"
            r1.content = r7
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_document
            r1.res = r7
            goto L_0x028e
        L_0x024e:
            boolean r0 = r7 instanceof com.sendbird.android.AdminMessage
            if (r0 == 0) goto L_0x028e
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r0 = com.paytm.android.chat.utils.AppUtilKt.getValidAdminMessage(r7)
            if (r0 == 0) goto L_0x028e
            java.lang.String r0 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{  }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{  }
            java.lang.String r7 = r7.getData()     // Catch:{  }
            r2.<init>(r7)     // Catch:{  }
        L_0x0265:
            int r7 = r2.length()     // Catch:{  }
            if (r3 >= r7) goto L_0x028e
            org.json.JSONObject r7 = r2.getJSONObject(r3)     // Catch:{  }
            java.lang.String r4 = "u_id"
            java.lang.String r4 = r7.optString(r4)     // Catch:{  }
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{  }
            if (r4 == 0) goto L_0x028b
            java.lang.String r0 = "d"
            org.json.JSONObject r7 = r7.optJSONObject(r0)     // Catch:{  }
            java.lang.String r0 = "preview_text"
            java.lang.String r7 = r7.getString(r0)     // Catch:{  }
            r1.content = r7     // Catch:{  }
            goto L_0x028e
        L_0x028b:
            int r3 = r3 + 1
            goto L_0x0265
        L_0x028e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.MessageContentUtils.getContentBean(com.sendbird.android.BaseMessage):com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.android.chat.utils.MessageContentUtils.MessageContentBean getReplyContentBean(com.sendbird.android.BaseMessage r7) {
        /*
            com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean r0 = new com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean
            r0.<init>()
            boolean r1 = r7 instanceof com.sendbird.android.UserMessage
            r2 = 0
            if (r1 == 0) goto L_0x016f
            r1 = r7
            com.sendbird.android.UserMessage r1 = (com.sendbird.android.UserMessage) r1
            com.sendbird.android.Sender r3 = r1.getSender()
            java.lang.String r4 = r7.getCustomType()
            java.lang.String r5 = "TRANSFER"
            boolean r4 = r4.equals(r5)
            r5 = 1
            if (r4 == 0) goto L_0x00a4
            if (r3 == 0) goto L_0x0239
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson     // Catch:{ Exception -> 0x0239 }
            r1.<init>()     // Catch:{ Exception -> 0x0239 }
            java.lang.String r7 = r7.getData()     // Catch:{ Exception -> 0x0239 }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r4 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r7 = r1.fromJson((java.lang.String) r7, r4)     // Catch:{ Exception -> 0x0239 }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r7 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r7     // Catch:{ Exception -> 0x0239 }
            java.lang.String r1 = r3.getUserId()     // Catch:{ Exception -> 0x0239 }
            java.lang.String r3 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x0239 }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0239 }
            java.lang.String r3 = "Pending ₹%1$s"
            r4 = 2
            if (r1 == 0) goto L_0x0073
            int r1 = r7.getStatus()     // Catch:{ Exception -> 0x0239 }
            if (r1 != r4) goto L_0x0057
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0239 }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x0239 }
            r1[r2] = r4     // Catch:{ Exception -> 0x0239 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ Exception -> 0x0239 }
            r0.content = r1     // Catch:{ Exception -> 0x0239 }
            goto L_0x0067
        L_0x0057:
            java.lang.String r1 = "Paid ₹%1$s"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0239 }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x0239 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0239 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0239 }
            r0.content = r1     // Catch:{ Exception -> 0x0239 }
        L_0x0067:
            java.lang.String r7 = r7.getSender_preview_text()     // Catch:{ Exception -> 0x0239 }
            r0.content = r7     // Catch:{ Exception -> 0x0239 }
            int r7 = com.paytm.android.chat.R.drawable.chat_ic_payment_new     // Catch:{ Exception -> 0x0239 }
            r0.res = r7     // Catch:{ Exception -> 0x0239 }
            goto L_0x0239
        L_0x0073:
            int r1 = r7.getStatus()     // Catch:{ Exception -> 0x0239 }
            if (r1 != r4) goto L_0x0088
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0239 }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x0239 }
            r1[r2] = r4     // Catch:{ Exception -> 0x0239 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ Exception -> 0x0239 }
            r0.content = r1     // Catch:{ Exception -> 0x0239 }
            goto L_0x0098
        L_0x0088:
            java.lang.String r1 = "Received ₹%1$s"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0239 }
            java.lang.String r4 = r7.getAmount()     // Catch:{ Exception -> 0x0239 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0239 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0239 }
            r0.content = r1     // Catch:{ Exception -> 0x0239 }
        L_0x0098:
            java.lang.String r7 = r7.getReceiver_preview_text()     // Catch:{ Exception -> 0x0239 }
            r0.content = r7     // Catch:{ Exception -> 0x0239 }
            int r7 = com.paytm.android.chat.R.drawable.chat_ic_payment_new     // Catch:{ Exception -> 0x0239 }
            r0.res = r7     // Catch:{ Exception -> 0x0239 }
            goto L_0x0239
        L_0x00a4:
            java.lang.String r3 = r7.getCustomType()
            java.lang.String r4 = "MINI_APP_BASIC_NOTIFICATION"
            boolean r3 = r3.equals(r4)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00e2
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r1 = new com.paytm.android.chat.data.models.messages.MiniAppNotificationBean
            r1.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r3 = new com.sendbird.android.shadow.com.google.gson.Gson
            r3.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.MiniAppNotificationData> r5 = com.paytm.android.chat.data.models.messages.MiniAppNotificationData.class
            java.lang.Object r7 = r3.fromJson((java.lang.String) r7, r5)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationData) r7
            r1.setNotifData(r7)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = r1.getNotifData()
            if (r7 == 0) goto L_0x00dc
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r7 = r1.getNotifData()
            java.lang.String r7 = r7.getPreview_text()
            r0.content = r7
            goto L_0x00de
        L_0x00dc:
            r0.content = r4
        L_0x00de:
            r0.res = r2
            goto L_0x0239
        L_0x00e2:
            java.lang.String r3 = r7.getCustomType()
            java.lang.String r6 = "GENERIC_NOTIF"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x011e
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r1 = new com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel
            r1.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r3 = new com.sendbird.android.shadow.com.google.gson.Gson
            r3.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean> r5 = com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean.class
            java.lang.Object r7 = r3.fromJson((java.lang.String) r7, r5)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean) r7
            r1.setData(r7)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = r1.getData()
            if (r7 == 0) goto L_0x0118
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r7 = r1.getData()
            java.lang.String r7 = r7.getPreview_text()
            r0.content = r7
            goto L_0x011a
        L_0x0118:
            r0.content = r4
        L_0x011a:
            r0.res = r2
            goto L_0x0239
        L_0x011e:
            java.lang.String r3 = r7.getCustomType()
            java.lang.String r4 = "TRANSFER_FAIL"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0157
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson
            r1.<init>()
            java.lang.String r7 = r7.getData()
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r3 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r7 = r1.fromJson((java.lang.String) r7, r3)
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r7 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r7
            int r1 = com.paytm.android.chat.R.drawable.chat_icon_group_chat_message_state_fail
            r0.res = r1
            int r1 = com.paytm.android.chat.R.string.chat_list_transfer_fail
            java.lang.String r3 = "Transfer of %s Failed"
            java.lang.String r1 = com.paytm.android.chat.c.a(r1, r3)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r7 = r7.getAmount()
            r3[r2] = r7
            java.lang.String r7 = java.lang.String.format(r1, r3)
            r0.content = r7
            goto L_0x0239
        L_0x0157:
            java.lang.String r7 = r7.getCustomType()
            java.lang.String r2 = "contact"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0167
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_contact2
            r0.res = r7
        L_0x0167:
            java.lang.String r7 = r1.getMessage()
            r0.content = r7
            goto L_0x0239
        L_0x016f:
            boolean r1 = r7 instanceof com.sendbird.android.FileMessage
            if (r1 == 0) goto L_0x01f9
            r1 = 0
            java.lang.String r2 = r7.getData()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x018f
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson
            r1.<init>()
            java.lang.String r2 = r7.getData()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r3 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r1 = r1.fromJson((java.lang.String) r2, r3)
            com.paytm.android.chat.bean.jsonbean.FileDataBean r1 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r1
        L_0x018f:
            com.sendbird.android.FileMessage r7 = (com.sendbird.android.FileMessage) r7
            java.lang.String r2 = r7.getType()
            java.lang.String r3 = r2.toLowerCase()
            java.lang.String r4 = "audio"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L_0x01ca
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_audio
            r0.res = r2
            java.lang.String r2 = r7.getName()
            r0.content = r2
            if (r1 == 0) goto L_0x0239
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = r7.getName()
            r2.append(r7)
            long r3 = r1.time
            java.lang.String r7 = com.paytm.android.chat.utils.DateUtils.getAudioTime(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.content = r7
            goto L_0x0239
        L_0x01ca:
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "image"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x01ee
            if (r1 == 0) goto L_0x01e5
            java.lang.String r7 = r1.message
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01e5
            java.lang.String r7 = r1.message
            r0.content = r7
            goto L_0x01e9
        L_0x01e5:
            java.lang.String r7 = "Photo"
            r0.content = r7
        L_0x01e9:
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo
            r0.res = r7
            goto L_0x0239
        L_0x01ee:
            java.lang.String r7 = r7.getName()
            r0.content = r7
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_document
            r0.res = r7
            goto L_0x0239
        L_0x01f9:
            boolean r1 = r7 instanceof com.sendbird.android.AdminMessage
            if (r1 == 0) goto L_0x0239
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r1 = com.paytm.android.chat.utils.AppUtilKt.getValidAdminMessage(r7)
            if (r1 == 0) goto L_0x0239
            java.lang.String r1 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{  }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{  }
            java.lang.String r7 = r7.getData()     // Catch:{  }
            r3.<init>(r7)     // Catch:{  }
        L_0x0210:
            int r7 = r3.length()     // Catch:{  }
            if (r2 >= r7) goto L_0x0239
            org.json.JSONObject r7 = r3.getJSONObject(r2)     // Catch:{  }
            java.lang.String r4 = "u_id"
            java.lang.String r4 = r7.optString(r4)     // Catch:{  }
            boolean r4 = r1.equalsIgnoreCase(r4)     // Catch:{  }
            if (r4 == 0) goto L_0x0236
            java.lang.String r1 = "d"
            org.json.JSONObject r7 = r7.optJSONObject(r1)     // Catch:{  }
            java.lang.String r1 = "preview_text"
            java.lang.String r7 = r7.getString(r1)     // Catch:{  }
            r0.content = r7     // Catch:{  }
            goto L_0x0239
        L_0x0236:
            int r2 = r2 + 1
            goto L_0x0210
        L_0x0239:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.MessageContentUtils.getReplyContentBean(com.sendbird.android.BaseMessage):com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean");
    }
}
