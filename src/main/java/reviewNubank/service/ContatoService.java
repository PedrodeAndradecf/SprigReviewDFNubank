package reviewNubank.service;


import org.springframework.stereotype.Service;
import reviewNubank.dto.request.ContatoRequestDTO;
import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.entities.Contato;
import reviewNubank.exception.ClienteNotFoundException;
import reviewNubank.mapper.ContatoMapper;
import reviewNubank.repository.ClienteRepository;
import reviewNubank.repository.ContatoRepository;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ClienteRepository clienteRepository;


    public ContatoService(ContatoRepository contatoRepository, ClienteRepository clienteRepository){
        this.contatoRepository = contatoRepository;
        this.clienteRepository = clienteRepository;
    }


    public ContatoResponseDTO salvarContato(ContatoRequestDTO dto){

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ClienteNotFoundException(("Cliente não encontrado com id: " + dto.clienteId()));


        Contato contato = ContatoMapper.toEntity(dto, cliente);
        Contato contatoSalvo = contatoRepository.save(contato);
        return ContatoMapper.toResponse(contatoSalvo);
    }
}
