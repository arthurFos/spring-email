package de.fkal.springemail.template;

import de.fkal.springemail.model.dto.MailProperties;
import de.fkal.springemail.service.MailService;
import de.fkal.springemail.template.templateobjects.AccountActivationTemplateObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountActivationTemplateTest {
    @Autowired
    private MailService mailService;
    private MailProperties mailProperties;
    private AccountActivationTemplate accountActivationTemplate;

    @BeforeEach
    public void init() {
        mailProperties = new MailProperties();
        AccountActivationTemplateObject activationTemplateObject = AccountActivationTemplateObject.builder()
                .sex('M')
                .name("Foster")
                .link("www.google.com")
                .build();

        accountActivationTemplate = new AccountActivationTemplate(activationTemplateObject);
        mailProperties.setFrom("a_loic16@yahoo.fr");
        mailProperties.setTo("arthur_loic@yahoo.fr");
        mailProperties.setSubject("Account Activation");
    }

    @Test
    public void shouldSendEmail_whenMailObjectISCorrect() {
        mailService.sendMail(mailProperties, accountActivationTemplate);
    }
}
