package reviewNubank.dto.request;


import jakarta.validation.Valid;

import java.util.List;

public record ClienteRequestDTO(String nome, List<@Valid ContatoRequestDTO> contatos) {
}
