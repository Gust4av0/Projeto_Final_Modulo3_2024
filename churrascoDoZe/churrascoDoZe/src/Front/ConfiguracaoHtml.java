package Front;

import org.thymeleaf.Thymeleaf;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class ConfiguracaoHtml {
    public static ThymeleafTemplateEngine create(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("HTML/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        return new ThymeleafTemplateEngine(templateResolver);

    }
}
