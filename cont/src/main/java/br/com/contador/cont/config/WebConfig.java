package br.com.contador.cont.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // <--- ESSA ANOTAÇÃO É OBRIGATÓRIA
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Detecta se está no Windows ou Docker (Linux) para não quebrar o caminho
        String path = System.getProperty("user.dir") + "/upload-dir/";

        // Se o caminho não começar com /, adicionamos (ajuste para Windows)
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        registry.addResourceHandler("/imagens/**")
                .addResourceLocations("file:" + path);
    }
}