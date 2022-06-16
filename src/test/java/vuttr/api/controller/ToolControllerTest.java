package vuttr.api.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vuttr.api.controller.request.ToolRequest;
import vuttr.api.controller.response.ToolResponse;
import vuttr.api.service.ToolService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ToolControllerTest {

    @InjectMocks
    private ToolController toolController;

    @Mock
    private ToolService toolServiceMock;

    @Test
    void listAllSuccess() {
        //given, when, then
        var response = toolController.listAll();

        BDDMockito.when(toolServiceMock.listAll()).thenReturn(List.of(ToolResponse.builder().build()));

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @Disabled
    void listAllError() {
        //given, when, then
        var response = toolController.listAll();

        BDDMockito.when(toolServiceMock.listAll()).thenThrow(new RuntimeException());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findByTagSuccess() {
        var tag = "web";
        var response = toolController.findByTag(tag);

        BDDMockito.when(toolServiceMock.findByTag(ArgumentMatchers.anyString())).thenReturn(List.of(ToolResponse.builder().build()));

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void saveSuccess() {
        var toolRequest = new ToolRequest();
        var response = toolController.save(toolRequest);

        BDDMockito.when(toolServiceMock.save(ArgumentMatchers.any())).thenReturn(ToolResponse.builder().build());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void deleteSuccess() {
        var id = 1L;
        var response = toolController.delete(1L);

        BDDMockito.doNothing().when(toolServiceMock).delete(ArgumentMatchers.anyLong());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}