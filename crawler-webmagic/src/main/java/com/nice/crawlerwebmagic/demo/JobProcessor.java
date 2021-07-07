package com.nice.crawlerwebmagic.demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.utils.CharsetUtils;

public class JobProcessor implements PageProcessor {
    Integer i=1;
    String url = "https://search.51job.com/list/000000,000000,0000,01%252c32,9,99,java,2,"+i+".html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=\n";
    @Override
    public void process(Page page) {
//        page.putField("div",page.getHtml().css("div.mt h3").all());
          //Xpath
//        page.putField("div2",page.getHtml().xpath("//div[@class=tabs]/ul/li").all());
//        page.putField("div2",page.getHtml().xpath("//div[@id=tab]/ul/li").all());
          //正则表达式
//        page.putField("div3", page.getHtml().css("div#tab li").regex(".*问题.*").all());
//        page.putField("div4", page.getHtml().css("div#tab li").regex(".*问题.*").get());
//        page.putField("div5", page.getHtml().css("div#tab li").regex(".*问题.*").toString());
        //获取链接
//        page.addTargetRequests(page.getHtml().css("ul.hot-topic-list li").links().regex(".*0.html$").all());
//        page.putField("url",page.getHtml().css("div.help-tit1").all());
        page.addTargetRequest("https://help.jd.com/user/issue/225-620.html");
        page.addTargetRequest("https://help.jd.com/user/issue/225-620.html");
        page.addTargetRequest("https://help.jd.com/user/issue/225-620.html");
    }

    private Site site = Site.me()
            .setCharset("utf8")
            .setTimeOut(10000)
            .setRetrySleepTime(3000)
            .setRetryTimes(3)
            .setSleepTime(1000);
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //https://search.51job.com/list/000000,000000,0000,01%252c32,9,99,java,2,2.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=
        Spider.create(new JobProcessor()).addUrl("https://help.jd.com/index.html")
                .addPipeline(new FilePipeline("E:\\dev\\pipeline"))
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000000)))
                .thread(5)
                .run();
    }
}
