package com.example.myapplication.bean;

import java.util.List;

/**
 * @autor duan
 * create on 2020/4/8
 * creta at 23:10
 */
public class WangYiBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"content":"我们就没有在一起过，我给他发过很多信息，但是他都没有回我，我们最多的交集就是对视几眼，我真的不清楚他对我的感觉。终于到现在，我打算放下了，虽然我知道这很难","source":"小鹿乱撞"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        @Override
        public String toString() {
            return "NewslistBean{" +
                    "content='" + content + '\'' +
                    ", source='" + source + '\'' +
                    '}';
        }

        /**
         * content : 我们就没有在一起过，我给他发过很多信息，但是他都没有回我，我们最多的交集就是对视几眼，我真的不清楚他对我的感觉。终于到现在，我打算放下了，虽然我知道这很难
         * source : 小鹿乱撞
         */

        private String content;
        private String source;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
