package vuttr.api.controller.response;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ToolResponse {

    private Long id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;

}
