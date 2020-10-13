package de.fkal.springemail.service;

import de.fkal.springemail.template.AbstractMailTemplate;
import de.fkal.springemail.model.dto.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendMail(MailProperties mailProperties, AbstractMailTemplate mailTemplate) {
        String mailBody = mailTemplate.createHtmlMailBody(); // get content from velocity-templates help class
        MimeMessagePreparator mimeMessagePreparator = buildMessagePreparator(mailProperties, mailBody);
        javaMailSender.send(mimeMessagePreparator);
    }

    private MimeMessagePreparator buildMessagePreparator(MailProperties mailProperties, String mailBody) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(mailProperties.getFrom());
            messageHelper.setTo(mailProperties.getTo());
            messageHelper.setSubject(mailProperties.getSubject());
            messageHelper.setText(mailBody, true);
            if (Objects.nonNull(mailProperties.getAttachments())){
                mailProperties.getAttachments().forEach(attachment -> {
                    try {
                        messageHelper.addAttachment(attachment.getFilename(), attachment);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                });
            }

        };
    }
}
