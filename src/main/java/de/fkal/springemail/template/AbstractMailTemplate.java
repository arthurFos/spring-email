package de.fkal.springemail.template;

import de.fkal.springemail.template.templateobjects.AbstractTemplateObject;
import lombok.SneakyThrows;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public abstract class AbstractMailTemplate {
    private VelocityEngine velocityEngine;
    protected AbstractTemplateObject templateObject;
    private final String VELOCITY_TEMPLATES = "velocity-templates/";

    public AbstractMailTemplate(AbstractTemplateObject templateObject) {
        this.templateObject = templateObject;
        velocityEngine = new VelocityEngine();

        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    @SneakyThrows
    public String createHtmlMailBody() {

        String templatePath = VELOCITY_TEMPLATES + loadTemplate();
        System.out.println("Template name -> " + templatePath);
        Template t = velocityEngine.getTemplate(templatePath);
        VelocityContext context = buildContext();

        StringWriter stringWriter = new StringWriter();
        t.merge(context, stringWriter);

        return stringWriter.toString();
    }

    protected abstract VelocityContext buildContext();

    protected abstract String loadTemplate();
}
