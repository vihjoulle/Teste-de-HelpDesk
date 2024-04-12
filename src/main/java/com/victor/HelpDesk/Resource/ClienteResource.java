package com.victor.HelpDesk.Resource;

import com.victor.HelpDesk.Service.ClienteService;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.DTO.ClienteDTO;
import com.victor.HelpDesk.domain.DTO.TecnicoDTO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/** @noinspection Convert2MethodRef*/
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    //localhost:8080/tecnicos/1

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findbyId(@PathVariable Integer id) {
    Cliente obj = service.findById(id);
    return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {
    Cliente newObj = service.create(objDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
    return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO objDTO){
        Cliente Obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ClienteDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}