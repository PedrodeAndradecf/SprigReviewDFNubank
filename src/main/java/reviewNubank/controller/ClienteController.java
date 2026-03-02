package reviewNubank.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reviewNubank.dto.request.ClienteRequestDTO;
import reviewNubank.dto.response.ClienteResponseDTO;

import reviewNubank.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }



    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody ClienteRequestDTO dto){
        ClienteResponseDTO clienteSalvoDto = clienteService.salvarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvoDto);
    }
}
