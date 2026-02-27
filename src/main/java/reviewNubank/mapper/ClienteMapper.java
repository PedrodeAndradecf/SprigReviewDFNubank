package reviewNubank.mapper;

import reviewNubank.dto.request.ClienteRequestDTO;
import reviewNubank.dto.response.ClienteResponseDTO;
import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.entities.Contato;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    private ClienteMapper() {}


    public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());

        if (dto.contatos() != null && !dto.contatos().isEmpty()) {
            List<Contato> contatos = dto.contatos().stream()
                    .map(contatoDto -> ContatoMapper.toEntity(contatoDto, cliente))
                    .collect(Collectors.toList());
            cliente.setContatos(contatos);
        }

        return cliente;
    }


    public static ClienteResponseDTO toResponse(Cliente cliente) {
        List<ContatoResponseDTO> contatosDTO = cliente.getContatos() != null
                ? cliente.getContatos().stream()
                    .map(ContatoMapper::toResponse)
                    .collect(Collectors.toList())
                : Collections.emptyList();

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                contatosDTO
        );
    }
}
