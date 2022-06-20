package vuttr.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vuttr.api.controller.request.ToolRequest;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.service.ToolService;
import java.util.List;

@RestController
@RequestMapping("tools")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    @GetMapping
    public ResponseEntity<List<ToolResponse>> listAll() {
        return ResponseEntity.ok(toolService.listAll());
    }

    @GetMapping(path = "/tag")
    public ResponseEntity<List<ToolResponse>> findByTag(@RequestParam String tag) {
        return ResponseEntity.ok(toolService.findByTag(tag));
    }

    @PostMapping
    public ResponseEntity<ToolResponse> save(@RequestBody ToolRequest toolRequest) {
        return new ResponseEntity<>(toolService.save(toolRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toolService.delete(id);
        return ResponseEntity.ok().build();
    }

}
