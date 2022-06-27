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
import vuttr.api.controller.request.ToolRequest;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.model.Tool;
import vuttr.api.repository.ToolRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
        //when, given, then
        BDDMockito.when(toolRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(toolAdapterMock.toToolResponse(any())).thenReturn(toolResponseBuild());

        var response = toolService.listAll();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.get(0).getTitle()).isEqualTo("Google");
    }

    @Test
    void findByTagSuccess() {
        BDDMockito.when(toolRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(toolAdapterMock.toToolResponse(any())).thenReturn(toolResponseBuild());

        var response = toolService.findByTag("web");

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.get(0).getTags()).contains("web");
    }

    @Test
    void findByTagEmpty() {
        BDDMockito.when(toolRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(toolAdapterMock.toToolResponse(any())).thenReturn(toolResponseBuild());

        var response = toolService.findByTag("dev");

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response).hasSize(0);
    }

    @Test
    void saveSuccess() {
        BDDMockito.when(toolAdapterMock.toTool(any(ToolRequest.class))).thenReturn(toolBuild());
        BDDMockito.when(toolAdapterMock.toToolResponse(any(Tool.class))).thenReturn(toolResponseBuild());
        BDDMockito.when(toolRepositoryMock.save(any(Tool.class))).thenReturn(toolBuild());

        var response = toolService.save(new ToolRequest());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getTitle()).isEqualTo("Google");
        Assertions.assertThat(response.getDescription()).isEqualTo("Ferramenta de pesquisa");
        Assertions.assertThat(response.getTags()).contains("navegador");
    }

    @Test
    void deleteSuccess() {
        BDDMockito.when(toolRepositoryMock.findById(anyLong())).thenReturn(Optional.of(toolBuild()));
        BDDMockito.doNothing().when(toolRepositoryMock).delete(ArgumentMatchers.any(Tool.class));

        Assertions.assertThatCode(() -> toolService.delete(1L)).doesNotThrowAnyException();
    }

    @Test
    void deleteThrowsException() {
        BDDMockito.when(toolRepositoryMock.findById(anyLong())).thenThrow(new RuntimeException());

        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> toolService.delete(1L));
    }

}