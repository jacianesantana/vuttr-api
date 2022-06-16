package vuttr.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vuttr.api.adapter.ToolAdapter;
import vuttr.api.controller.request.ToolRequest;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.repository.ToolRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolService {

    private final ToolRepository toolRepository;
    private final ToolAdapter toolAdapter;

    public List<ToolResponse> listAll() {
        return toolRepository.findAll()
                .stream()
                .map(toolAdapter::toToolResponse)
                .collect(Collectors.toList());
    }

    public List<ToolResponse> findByTag(String tag) {
        var toolResponseList = listAll();
        return toolResponseList.stream()
                .filter(toolResponse -> toolResponse.getTags().stream().anyMatch(toolTag -> toolTag.equals(tag)))
                .collect(Collectors.toList());
    }

    public ToolResponse save(ToolRequest toolRequest) {
        var tool = toolAdapter.toTool(toolRequest);
        return toolAdapter.toToolResponse(toolRepository.save(tool));
    }

    public void delete(Long id) {
        var tool = toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encotrada"));
        toolRepository.delete(tool);
    }
}
