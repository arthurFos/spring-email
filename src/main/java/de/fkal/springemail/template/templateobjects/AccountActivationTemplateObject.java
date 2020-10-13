package de.fkal.springemail.template.templateobjects;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountActivationTemplateObject extends AbstractTemplateObject {
    private char sex;
    private String name;
    private String link;
}
