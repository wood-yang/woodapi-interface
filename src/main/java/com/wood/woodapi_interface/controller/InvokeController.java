package com.wood.woodapi_interface.controller;

import com.wood.woodapi_interface.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 名称 API
 */
@RestController
@RequestMapping
@Slf4j
public class InvokeController {
    /**
     * 2. 随机毒鸡汤
     *
     * @return
     */
    @GetMapping("/poisonousChickenSoup")
    public String getPoisonousChickenSoup() {
        String s = RequestUtils.get("https://api.btstu.cn/yan/api.php?charset=utf-8&encode=json");
        return s;// 真实的第三方接口地址
    }

    /**
     * 3. 随机壁纸
     *
     */
    @GetMapping("/bing")
    public String randomWallpaper() {
        return RequestUtils.get("https://api.vvhan.com/api/bing?type=json");
    }

    /**
     * 4. 随机土味情话
     *
     * @return
     */
    @GetMapping("/text/love")
    public String randomLoveTalk() {
        return RequestUtils.get("https://api.vvhan.com/api/text/love");
    }

    /**
     * 5. 每日一句励志英语
     *
     * @return
     */
    @GetMapping("/dailyEnglish")
    public String dailyEnglish() {
        return RequestUtils.get("https://api.vvhan.com/api/dailyEnglish");
    }

    /**
     * 6. 随机笑话
     *
     * @return
     */
    @GetMapping("/text/joke")
    public String randomJoke() {
        return RequestUtils.get("https://api.vvhan.com/api/text/joke");
    }

    /**
     * 6. 随机笑话
     *
     * @return
     */
    @GetMapping("/weather")
    public String weather() {
        return RequestUtils.get("https://api.vvhan.com/api/weather");
    }

//    @GetMapping("/test")
//    public String test() {
//        log.info("调通了");
//        return "调通了捏捏\n捏捏捏";
//    }
}
