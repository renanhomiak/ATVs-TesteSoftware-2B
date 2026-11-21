package br.edu.exemplo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc @Transactional
class ProdutoControllerIntegrationTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    private static final String JSON_MOUSE = "{\"nome\":\"Mouse\",\"preco\":80.0}";

    // CT04
    @Test void deveCadastrarProdutoPelaApi() throws Exception {
        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON_MOUSE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0));
    }

    // CT05
    @Test void deveBuscarProdutoPelaApi() throws Exception {
        MvcResult resultado = mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON_MOUSE))
                .andExpect(status().isOk())
                .andReturn();

        long id = objectMapper
                .readTree(resultado.getResponse().getContentAsString())
                .get("id")
                .asLong();

        mockMvc.perform(get("/produtos/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0));
    }
}