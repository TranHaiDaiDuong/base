package com.gst.base.remote.util;

import com.gst.util.remote.util.EmailSender;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EmailSenderTest {
    private static final String SUBJECT = "Sending mail with Gmail SMTP and Java Mail";
    private static final String BODY = "Bạn vừa yêu cầu đặt lại mật khẩu của dịch vụ Base, vui lòng chọn link "
            + "dưới đây và làm theo hướng dẫn để đặt lại mật khẩu cho tài khoản";

    @Test
    @Disabled("This actually send an email")
    void testSendMail_ValidInfo_ShouldSendSuccess() throws InterruptedException {
        EmailSender.getInstance().sendEmail(Arrays.asList("quangnguyenkma@gmail.com"), SUBJECT, BODY);
        Thread.sleep(3000L);
    }
}