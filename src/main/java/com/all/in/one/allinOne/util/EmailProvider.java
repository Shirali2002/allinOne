package com.all.in.one.allinOne.util;

import com.all.in.one.allinOne.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
@RequiredArgsConstructor
public class EmailProvider {

    private final JavaMailSender mailSender;

    public void sendRegistrationOtp(User user) throws MessagingException, UnsupportedEncodingException {
        String content = "Dear [[name]],<br>"
                + "Your otp code to verify your registration:<br>"
                + "[[OTP]]<br>"
                + "Thank you,<br>"
                + "allinone organization.";
        String subject = "Please verify your registration";

        sendEmail(user, content, subject);
    }

    public void sendResetPasswordOtp(User user) throws MessagingException, UnsupportedEncodingException {
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Use the otp code below to change your password:</p>"
                + "<p>[[OTP]]</p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
        String subject = "Please verify your reset password request";

        sendEmail(user, content, subject);
    }

    private void sendEmail(User user, String content, String subject) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "todolistorganization@gmail.com";
        String senderName = "allinone organization";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getFullName());

        content = content.replace("[[OTP]]", String.valueOf(user.getOtpCode()));

        helper.setText(content, true);

        mailSender.send(message);
    }

}