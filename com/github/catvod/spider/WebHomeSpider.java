package com.github.catvod.spider;

import com.fongmi.core.spider.Spider;
import android.content.Context;

public class webhome extends Spider {
    private String webUrl;

    @Override
    public void init(Context context, String extend) {
        webUrl = extractHomePage(extend);
    }

    private String extractHomePage(String json) {
        if (json == null || json.isEmpty()) return "";
        try {
            int idx = json.indexOf("homePage");
            if (idx == -1) return "";
            idx = json.indexOf(':', idx);
            if (idx == -1) return "";
            idx = json.indexOf('"', idx);
            if (idx == -1) return "";
            int end = json.indexOf('"', idx + 1);
            if (end == -1) return "";
            return json.substring(idx + 1, end);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public String homeContent(boolean filter) {
        if (webUrl == null || webUrl.isEmpty()) {
            return "{}";
        }
        return "{\"webUrl\":\"" + webUrl + "\"}";
    }

    @Override
    public String categoryContent(String tid, boolean filter, String extend) {
        return "{}";
    }

    @Override
    public String detailContent(String[] ids) {
        return "{}";
    }

    @Override
    public String searchContent(String key, boolean quick, String extend) {
        return "{}";
    }

    @Override
    public String playerContent(String flag, String id, String[] vipFlags) {
        return "{}";
    }
}
