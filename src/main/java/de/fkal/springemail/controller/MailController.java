package de.fkal.springemail.controller;

import de.fkal.springemail.model.dto.MailObject;
import de.fkal.springemail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;


    public void sendMail(MailObject mailObject) {
        if (mailObject.getAbstractMailTemplate() == null || mailObject.getMailProperties() == null) return;
        mailService.sendMail(mailObject.getMailProperties(), mailObject.getAbstractMailTemplate());
    }
}
