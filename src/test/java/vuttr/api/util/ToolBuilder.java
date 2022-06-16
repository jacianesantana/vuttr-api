package vuttr.api.util;

import vuttr.api.controller.response.ToolResponse;
import vuttr.api.model.Tool;

import java.util.List;

public class ToolBuilder {

    public static Tool toolBuild() {
        return Tool.builder()
                .id(1L)
                .title("Google")
                .link("www.google.com")
                .description("Ferramenta de pesquisa")
                .tags(List.of("web", "navegador"))
                .build();
    }

    public static ToolResponse toolResponseBuild() {
        return ToolResponse.builder()
                .id(1L)
                .title("Google")
                .link("www.google.com")
                .description("Ferramenta de pesquisa")
                .tags(List.of("web", "navegador"))
                .build();
    }
}
