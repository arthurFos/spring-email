package de.fkal.springemail.model.dto;

import de.fkal.springemail.template.AbstractMailTemplate;
import lombok.Data;

@Data
public class MailObject {
    private MailProperties mailProperties;
    private AbstractMailTemplate abstractMailTemplate;
}
