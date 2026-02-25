package reviewNubank.dto.request;


import jakarta.validation.Valid;

import java.util.List;

public record ClientesRequetDTO(String nome, List<@Valid ContatoRequestDTO> contatos) {
}
