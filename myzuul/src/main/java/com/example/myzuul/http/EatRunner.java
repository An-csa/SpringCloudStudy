package com.example.myzuul.http;

import com.example.myzuul.fifter.EatuulFilter;
import com.example.myzuul.fifter.RequestWrapperFilter;
import com.example.myzuul.fifter.RoutingFilter;
import com.example.myzuul.fifter.SendResponseFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EatRunner {
    //静态写死过滤器
    private ConcurrentHashMap<String, List<EatuulFilter>> hashFiltersByType = new ConcurrentHashMap<>() {{
        put("pre", new ArrayList<>() {{
            add(new RequestWrapperFilter());
        }});
        put("route", new ArrayList<>() {{
            add(new RoutingFilter());
        }});
        put("post", new ArrayList<>() {{
            add(new SendResponseFilter());
        }});
    }};

    void init(HttpServletRequest req, HttpServletResponse resp) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setRequest(req);
        ctx.setResponse(resp);
    }

    void preRoute() {
        runFilters("pre");
    }

    void route() {
        runFilters("route");
    }

    void postRoute() {
        runFilters("post");
    }


    private void runFilters(String sType) {
        List<EatuulFilter> list = this.hashFiltersByType.get(sType);
        if (list != null) {
            for (EatuulFilter zuulFilter : list) {
                zuulFilter.run();
            }
        }
    }
}