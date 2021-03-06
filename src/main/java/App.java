import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
  
        setPort(port);

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
             
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/main", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/donor", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/donor.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

          get("/recepient", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/recepient.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

    }
}