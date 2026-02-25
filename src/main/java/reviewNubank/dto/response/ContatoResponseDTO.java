package reviewNubank.dto.response;

public record ContatoResponseDTO(
        Long id,
        String email,
        String telefone,
        Long clientId
) {
}
