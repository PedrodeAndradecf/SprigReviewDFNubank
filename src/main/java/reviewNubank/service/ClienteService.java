package reviewNubank.service;

import org.springframework.stereotype.Service;
import reviewNubank.dto.request.ClienteRequestDTO;
import reviewNubank.dto.response.ClienteResponseDTO;
import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.exception.ClienteNotFoundException;
import reviewNubank.mapper.ContatoMapper;
import reviewNubank.repository.ClienteRepository;
import reviewNubank.mapper.ClienteMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvarCliente(ClienteRequestDTO clienteReqDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteReqDto);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.toResponse(clienteSalvo);
    }


    public List<ClienteResponseDTO> listarTodos(){
        List<ClienteResponseDTO> clientes = clienteRepository.findAllComContatos().stream().map(ClienteMapper::toResponse)
                .collect(Collectors.toList());

        return clientes;
    }


    public List<ContatoResponseDTO> listarContatosPorCliente(Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com id: " + clienteId));

        return cliente.getContatos().stream()
                .map(ContatoMapper::toResponse)
                .collect(Collectors.toList());
    }


    /*List<ContatoResponseDTO> contatosDto = cliente.getContatos().stream()
            .map(ContatoMapper::toResponse)
            .collect(Collectors.toList());

        return contatosDto; */

}