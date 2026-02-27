package reviewNubank.service;

import org.springframework.stereotype.Service;
import reviewNubank.dto.request.ClienteRequestDTO;
import reviewNubank.dto.response.ClienteResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.repository.ClienteRepository;
import reviewNubank.mapper.ClienteMapper;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvarCliente(ClienteRequestDTO clienteReqDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteReqDto);
        clienteRepository.save(cliente);
        return ClienteMapper.toResponse(cliente);
    }
}