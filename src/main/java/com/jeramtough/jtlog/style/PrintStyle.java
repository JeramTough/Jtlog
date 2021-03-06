package com.jeramtough.jtlog.style;

import com.jeramtough.jtlog.bean.LogInformation;
import com.jeramtough.jtlog.context.LogContext;

/**
 * 负责输出样式，以什么样的风格输出,有些可能每条输入中间隔的空行都不一样，日志时间格式也不一样
 *
 * @author 11718
 */
public interface PrintStyle {
    /**
     * 格式化日志信息成为String
     *
     * @param logContext     {@link LogContext}
     * @param logInformation 日志信息类
     * @return 风格化后的日志信息
     */
    String stylize(LogContext logContext, LogInformation logInformation);
}
