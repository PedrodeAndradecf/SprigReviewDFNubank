package reviewNubank.dto.response;

import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String nome,
        List<ContatoResponseDTO> contatos
) {
}
