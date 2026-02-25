package reviewNubank.service;

import org.springframework.stereotype.Service;
import reviewNubank.mapper.ContatoMapper;
import reviewNubank.dto.response.ClienteResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.entities.Contato;
import reviewNubank.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    public Cliente salvarCliente(ClienteResponseDTO clienteRespDto){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRespDto.nome());

        if(clienteRespDto.contatos() != null && !clienteRespDto.contatos().isEmpty()){
            List<Contato> contatos = clienteRespDto.contatos().stream().map(dto ->
                    ContatoMapper.toEntity(dto, cliente))
                            .collect(Collectors.toList());
            cliente.setContatos(contatos);
        }

        return clienteRepository.save(cliente);
    }


//    private Contato contatoMapper(ContatoResponseDTO dto, Cliente cliente){
//        Contato contato = new Contato();
//        contato.setEmail(dto.email());
//        contato.setTelefone(dto.telefone());
//        contato.setCliente(cliente);
//
//        return contato;
//
//    }



}
