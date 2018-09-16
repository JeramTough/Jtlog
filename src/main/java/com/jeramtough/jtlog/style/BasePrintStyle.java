package com.jeramtough.jtlog.style;

import com.jeramtough.jtlog.facade.L;
import com.jeramtough.jtlog.log.LogInformation;
import com.jeramtough.jtlog.util.MyStringUtil;

/**
 * Created by 11718
 * on 2017  October 14 Saturday 17:44.
 *
 * @author 11718
 */

public abstract class BasePrintStyle implements PrintStyle {


    protected String getHead(LogInformation logInformation) {

        String context, tag;
        if (logInformation.getLogContext().getContextName().equals(L.class.getSimpleName())) {
            context = "";
        } else {
            context = " , {context}=" + logInformation.getLogContext().getContextName();
        }
        if (logInformation.getTag() == null) {
            tag = "";
        } else {
            tag = " , {tag}=" + logInformation.getTag();

        }
        String head = logInformation.getLogLevel().getFlag() + ":{time}=" +
                logInformation.getTime() + " , " + "{thread}=" + logInformation.getThreadName() + context + tag;

        return head;
    }

    protected String getMessage(LogInformation logInformation) {
        int limitNumber = logInformation.getLogContext().getLogConfig().getMaxLengthOfRow();
        String message;
        if (limitNumber > 0) {
            message = "\n" + MyStringUtil.splitTextByCounterOfRow(
                    logInformation.getMessage(),
                    limitNumber) + "\n";
        } else {
            message = logInformation.getMessage();
        }
        return message;
    }


    protected String getPosition(LogInformation logInformation) {
        return " , {location}=" + logInformation.getClassName() + "." +
                logInformation.getMethodName() + "()" + "." + logInformation.getLine();
    }

    protected String getCaller(LogInformation logInformation) {
        return " , {caller}=(" + logInformation.getFileName() + ":" +
                logInformation.getLine() + ")";
    }

}