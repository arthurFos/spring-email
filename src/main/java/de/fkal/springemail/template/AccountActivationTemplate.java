package de.fkal.springemail.template;

import de.fkal.springemail.template.templateobjects.AccountActivationTemplateObject;
import de.fkal.springemail.util.FileLoader;
import org.apache.velocity.VelocityContext;

import java.io.File;

public class AccountActivationTemplate extends AbstractMailTemplate {

    public AccountActivationTemplate(AccountActivationTemplateObject templateObject) {super(templateObject);}

    @Override
    protected VelocityContext buildContext() {
        VelocityContext context = new VelocityContext();
        AccountActivationTemplateObject activationTemplateObject = (AccountActivationTemplateObject) this.templateObject;

        context.put("sex", activationTemplateObject.getSex());
        context.put("name", activationTemplateObject.getName());
        context.put("link", activationTemplateObject.getLink());

        return context;
    }

    @Override
    protected String loadTemplate() {
        return "accountActivation.vm";
    }
}
