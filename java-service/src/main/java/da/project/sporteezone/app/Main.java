package da.project.sporteezone.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * if executed as .jar:
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplicationBuilder()
            .sources(Main.class)
            .build();
        app.run(args);
    }

    /**
     * if executed as .war:
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Main.class);
    }

    @EventListener
    public void onAppEvent(ServletWebServerInitializedEvent evt) {
        int port = evt.getApplicationContext().getWebServer().getPort();
        logger.info("Your web app address: http://localhost:" + port +
            evt.getApplicationContext().getServletContext().getContextPath());
    }

}
