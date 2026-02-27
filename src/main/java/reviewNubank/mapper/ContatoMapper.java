package reviewNubank.mapper;

import reviewNubank.dto.request.ContatoRequestDTO;
import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.entities.Contato;

public class ContatoMapper {

    private ContatoMapper() {}


    public static Contato toEntity(ContatoRequestDTO dto, Cliente cliente) {
        Contato contato = new Contato();
        contato.setEmail(dto.email());
        contato.setTelefone(dto.telefone());
        contato.setCliente(cliente);
        return contato;
    }

    
    public static ContatoResponseDTO toResponse(Contato contato) {
        return new ContatoResponseDTO(
                contato.getId(),
                contato.getEmail(),
                contato.getTelefone(),
                contato.getCliente().getId()
        );
    }
}
