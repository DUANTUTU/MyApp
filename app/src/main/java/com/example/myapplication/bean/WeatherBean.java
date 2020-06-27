package com.example.myapplication.bean;

import java.util.List;

/**
 * @autor duan
 * create on 2020/5/21
 * creta at 0:09
 */
public class WeatherBean {

    @Override
    public String toString() {
        return "WeatherBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }

    /**
     * code : 200
     * msg : success
     * newslist : [{"area":"保定","date":"2020-05-20","week":"星期四","weather":"阴转多云","weatherimg":"yun.png","real":"15℃","lowest":"15℃","highest":"29℃","wind":"东北风","winddeg":"40","windspeed":"4","windsc":"1-2级","sunrise":"05:00","sunset":"19:29","moonrise":"03:53","moondown":"17:02","pcpn":"0.0","pop":"2","uv_index":"8","vis":"24","humidity":"61","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"},{"area":"保定","date":"2020-05-21","week":"星期五","weather":"雷阵雨转多云","weatherimg":"yun.png","real":"14℃","lowest":"14℃","highest":"24℃","wind":"西北风","winddeg":"334","windspeed":"9","windsc":"1-2级","sunrise":"04:59","sunset":"19:30","moonrise":"04:19","moondown":"18:01","pcpn":"0.0","pop":"1","uv_index":"0","vis":"24","humidity":"43","tips":"天气暖和，适宜着单层棉麻面料的短套装、T恤衫、薄牛仔衫裤、休闲服、职业套装等春秋过渡装。年老体弱者请适当增减衣服。"},{"area":"保定","date":"2020-05-22","week":"星期六","weather":"多云转雷阵雨","weatherimg":"lei.png","real":"15℃","lowest":"15℃","highest":"30℃","wind":"南风","winddeg":"189","windspeed":"9","windsc":"1-2级","sunrise":"04:59","sunset":"19:31","moonrise":"04:48","moondown":"19:01","pcpn":"1.0","pop":"55","uv_index":"11","vis":"25","humidity":"43","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"},{"area":"保定","date":"2020-05-23","week":"星期日","weather":"多云","weatherimg":"yun.png","real":"13℃","lowest":"13℃","highest":"26℃","wind":"西北风","winddeg":"289","windspeed":"4","windsc":"1-2级","sunrise":"04:58","sunset":"19:31","moonrise":"05:21","moondown":"20:02","pcpn":"0.0","pop":"3","uv_index":"6","vis":"24","humidity":"62","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"},{"area":"保定","date":"2020-05-24","week":"星期一","weather":"多云转晴","weatherimg":"qing.png","real":"14℃","lowest":"14℃","highest":"27℃","wind":"西北风","winddeg":"324","windspeed":"7","windsc":"1-2级","sunrise":"04:57","sunset":"19:32","moonrise":"05:59","moondown":"21:03","pcpn":"0.0","pop":"3","uv_index":"11","vis":"23","humidity":"39","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"},{"area":"保定","date":"2020-05-25","week":"星期二","weather":"晴转多云","weatherimg":"yun.png","real":"16℃","lowest":"16℃","highest":"28℃","wind":"北风","winddeg":"356","windspeed":"3","windsc":"1-2级","sunrise":"04:57","sunset":"19:33","moonrise":"06:43","moondown":"22:01","pcpn":"1.0","pop":"55","uv_index":"8","vis":"25","humidity":"54","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"},{"area":"保定","date":"2020-05-26","week":"星期三","weather":"多云转晴","weatherimg":"qing.png","real":"14℃","lowest":"14℃","highest":"31℃","wind":"北风","winddeg":"357","windspeed":"6","windsc":"1-2级","sunrise":"04:56","sunset":"19:34","moonrise":"07:36","moondown":"22:55","pcpn":"0.0","pop":"0","uv_index":"11","vis":"25","humidity":"24","tips":"天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。"}]
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
                    "area='" + area + '\'' +
                    ", date='" + date + '\'' +
                    ", week='" + week + '\'' +
                    ", weather='" + weather + '\'' +
                    ", weatherimg='" + weatherimg + '\'' +
                    ", real='" + real + '\'' +
                    ", lowest='" + lowest + '\'' +
                    ", highest='" + highest + '\'' +
                    ", wind='" + wind + '\'' +
                    ", winddeg='" + winddeg + '\'' +
                    ", windspeed='" + windspeed + '\'' +
                    ", windsc='" + windsc + '\'' +
                    ", sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", moonrise='" + moonrise + '\'' +
                    ", moondown='" + moondown + '\'' +
                    ", pcpn='" + pcpn + '\'' +
                    ", pop='" + pop + '\'' +
                    ", uv_index='" + uv_index + '\'' +
                    ", vis='" + vis + '\'' +
                    ", humidity='" + humidity + '\'' +
                    ", tips='" + tips + '\'' +
                    '}';
        }

        /**
         * area : 保定
         * date : 2020-05-20
         * week : 星期四
         * weather : 阴转多云
         * weatherimg : yun.png
         * real : 15℃
         * lowest : 15℃
         * highest : 29℃
         * wind : 东北风
         * winddeg : 40
         * windspeed : 4
         * windsc : 1-2级
         * sunrise : 05:00
         * sunset : 19:29
         * moonrise : 03:53
         * moondown : 17:02
         * pcpn : 0.0
         * pop : 2
         * uv_index : 8
         * vis : 24
         * humidity : 61
         * tips : 天气炎热，适宜着短衫、短裙、短裤、薄型T恤衫、敞领短袖棉衫等夏季服装。
         */

        private String area;
        private String date;
        private String week;
        private String weather;
        private String weatherimg;
        private String real;
        private String lowest;
        private String highest;
        private String wind;
        private String winddeg;
        private String windspeed;
        private String windsc;
        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moondown;
        private String pcpn;
        private String pop;
        private String uv_index;
        private String vis;
        private String humidity;
        private String tips;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeatherimg() {
            return weatherimg;
        }

        public void setWeatherimg(String weatherimg) {
            this.weatherimg = weatherimg;
        }

        public String getReal() {
            return real;
        }

        public void setReal(String real) {
            this.real = real;
        }

        public String getLowest() {
            return lowest;
        }

        public void setLowest(String lowest) {
            this.lowest = lowest;
        }

        public String getHighest() {
            return highest;
        }

        public void setHighest(String highest) {
            this.highest = highest;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getWinddeg() {
            return winddeg;
        }

        public void setWinddeg(String winddeg) {
            this.winddeg = winddeg;
        }

        public String getWindspeed() {
            return windspeed;
        }

        public void setWindspeed(String windspeed) {
            this.windspeed = windspeed;
        }

        public String getWindsc() {
            return windsc;
        }

        public void setWindsc(String windsc) {
            this.windsc = windsc;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoondown() {
            return moondown;
        }

        public void setMoondown(String moondown) {
            this.moondown = moondown;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getUv_index() {
            return uv_index;
        }

        public void setUv_index(String uv_index) {
            this.uv_index = uv_index;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }
    }
}
