package com.nice.crawlerwebmagic.demo;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class MyJobProcessor implements PageProcessor {
    Integer i=1;
    String url = "https://search.51job.com/list/000000,000000,0000,01%252c32,9,99,java,2,"+i+".html?" +
            "lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";

    @Override
    public void process(Page page) {
         //解析页面，获取招聘信息详情的url地址
    }


    @Override
    public Site getSite() {
        Site site = Site.me()
                .setCharset("gbk")
                .setTimeOut(10*1000)
                .setRetryTimes(3)
                .setRetrySleepTime(3000)
                .setSleepTime(100);
        return site;
    }
}
