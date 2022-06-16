package vuttr.api.adapter;

import org.springframework.stereotype.Component;
import vuttr.api.controller.request.ToolRequest;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.model.Tool;

@Component
public class ToolAdapter {

    public Tool toTool(ToolRequest toolRequest) {
        return Tool.builder()
                .title(toolRequest.getTitle())
                .link(toolRequest.getLink())
                .description(toolRequest.getDescription())
                .tags(toolRequest.getTags())
                .build();
    }

    public ToolResponse toToolResponse(Tool tool) {
        return ToolResponse.builder()
                .id(tool.getId())
                .title(tool.getTitle())
                .link(tool.getLink())
                .description(tool.getDescription())
                .tags(tool.getTags())
                .build();
    }

}
