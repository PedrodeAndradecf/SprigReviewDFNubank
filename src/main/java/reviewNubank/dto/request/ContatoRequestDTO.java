package reviewNubank.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContatoRequestDTO(
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,
        Long clienteId
) {
}
