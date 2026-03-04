package reviewNubank.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        List<@Valid ContatoRequestDTO> contatos
) {
}
