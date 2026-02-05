package com.educator.core.email;

import com.educator.core.exception.CodeSageRuntimeException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${app.email.from}")
    private String from;

    private final JavaMailSender javaMailSender;

    public void sendWelcomeMessage(String to) {
        if(to == null) {
            throw new CodeSageRuntimeException("String doesn't have value. Object is null");
        }
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.addTo(to);
            mimeMessageHelper.setSubject("Powitanie");
            mimeMessageHelper.setText(convertHtmlToString(), true);
            javaMailSender.send(mimeMessage);
        }
        catch(MessagingException ex) {
            throw new CodeSageRuntimeException("Mail is failed: " + ex.getMessage());
        }
    }

    private String convertHtmlToString() {
        File file = new File("src/main/resources/registration-welcome.html");
        try {
            Document document = Jsoup.parse(file);
            return document.html();
        }
        catch (IOException ex) {
            throw new CodeSageRuntimeException("Path is failed: " + ex.getMessage());
        }
    }

}
