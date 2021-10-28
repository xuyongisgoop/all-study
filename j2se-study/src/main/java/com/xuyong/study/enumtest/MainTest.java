package com.xuyong.study.enumtest;

/**
 * Created by xuyong on 2019-07-03
 */
public class MainTest {

    public static void main(String[] args) {
        ExceptionProcessService exceptionProcessService = new FeedbackService();
        exceptionProcessService.createFeedback("PROCESS_FEEDBACK_CUSTOMER_UNACCESSIBLE", "0", 0l);
    }
}
