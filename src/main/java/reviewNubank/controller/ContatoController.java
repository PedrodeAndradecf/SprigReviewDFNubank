package reviewNubank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reviewNubank.dto.request.ContatoRequestDTO;
import reviewNubank.dto.response.ContatoResponseDTO;
import reviewNubank.entities.Cliente;
import reviewNubank.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;


    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> cadastrarContato(ContatoRequestDTO dto, Cliente cliente){
        ContatoResponseDTO contatoSalvoDto = contatoService.salvarContato(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(contatoSalvoDto);
    }
}
