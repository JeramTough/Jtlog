import com.jeramtough.jtlog.annotation.JtLoggerConfig;
import com.jeramtough.jtlog.facade.L;
import com.jeramtough.jtlog.filter.TagLogFilter;
import com.jeramtough.jtlog.jtlogger.JtLogger;
import com.jeramtough.jtlog.jtlogger.JtLoggerManager;
import com.jeramtough.jtlog.level.LogLevel;
import com.jeramtough.jtlog.with.WithJtLogger;

@JtLoggerConfig(isUsedJtloggerApi = false, isEnabled = false,
        maxLengthOfRow = 0,contextName = "MyLogger",
        minVisibleLevel = LogLevel.VERBOSE)
public class TestMain implements WithJtLogger {
    public static void main(String[] args) {
        JtLogger jtLogger = JtLoggerManager.getJtLogger(TestMain.class);
        jtLogger.getLogContext().getLogConfig().setMaxLengthOfRow(0);
        jtLogger.getLogContext().getLogConfig().setEnabled(false);
        jtLogger.info("information");

        new TestMain();
    }

    public TestMain() {
        test();
        test1();
        test2();
        //		test3();
    }

    private void test() {
        JtLogger jtLogger = JtLoggerManager.getJtLogger(TestMain.class);

        TagLogFilter tagLogFilter = new TagLogFilter("aaa");
        jtLogger.getLogContext().getLogConfig().addLogFilter(tagLogFilter);

        jtLogger.arrive();
        jtLogger.info("11111");
        jtLogger.warn("22222");
        jtLogger.debug("tag", "3333");
        jtLogger.debug("44444");
        jtLogger.error("tag", "55555");
        jtLogger.verbose("tag", "66666");
        jtLogger.p("77777"); //不带任何格式输出
    }

    private void test1() {
        L.debug(null);
        L.info(88888.f);
        L.verbose("99999");
        L.debugs(null,111111,121212);
    }
    private void test2() {
        getJtLogger().debug("with.www");
        getJtLogger().debugs("Strinds",1,12.1f,false);
    }

}

