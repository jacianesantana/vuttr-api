package vuttr.api.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vuttr.api.adapter.ToolAdapter;
import vuttr.api.controller.ToolController;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.model.Tool;
import vuttr.api.repository.ToolRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static vuttr.api.util.ToolBuilder.toolBuild;
import static vuttr.api.util.ToolBuilder.toolResponseBuild;

@ExtendWith(MockitoExtension.class)
class ToolServiceTest {

    @InjectMocks
    private ToolService toolService;

    @Mock
    private ToolRepository toolRepositoryMock;

    @Mock
    private ToolAdapter toolAdapterMock;


    @Test
    void listAllSuccess() {
        //given, when, then
        var response = toolService.listAll();

        BDDMockito.when(toolRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(toolAdapterMock.toToolResponse(ArgumentMatchers.any())).thenReturn(toolResponseBuild());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.get(0).getTitle()).isEqualTo("Google");
    }

    @Test
    void findByTag() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}