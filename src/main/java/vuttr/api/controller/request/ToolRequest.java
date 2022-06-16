package vuttr.api.controller.request;

import lombok.Data;
import java.util.List;

@Data
public class ToolRequest {

    private String title;
    private String link;
    private String description;
    private List<String> tags;

}
