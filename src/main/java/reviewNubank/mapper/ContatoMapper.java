package reviewNubank.mapper;

import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.entities.Contato;

public class ContatoMapper {
    //final Cliente cliente;



    public ContatoMapper(){}


    public static Contato toEntity(ContatoResponseDTO dto, Cliente cliente){
        Contato contato = new Contato();
        contato.setEmail(dto.email());
        contato.setTelefone(dto.telefone());
        contato.setCliente(cliente);

        return contato;
    }



//    public ContatoMapper(Cliente cliente){
//        this.cliente = cliente;
//    }


//    public Contato decoderDtoToEntity(ContatoResponseDTO dto){
//        Contato contato = new Contato();
//        contato.setEmail(dto.email());
//        contato.setTelefone(dto.telefone());
//        contato.setCliente(this.cliente);
//        return contato;
//
//    }



}
