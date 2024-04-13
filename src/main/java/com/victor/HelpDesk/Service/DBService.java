package com.victor.HelpDesk.Service;
import com.victor.HelpDesk.Repositories.ChamadoRepository;
import com.victor.HelpDesk.Repositories.ClienteRepository;
import com.victor.HelpDesk.Repositories.PessoaRepository;
import com.victor.HelpDesk.Repositories.TecnicoRepository;
import com.victor.HelpDesk.domain.Chamado;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;
import com.victor.HelpDesk.domain.enums.Prioridade;
import com.victor.HelpDesk.domain.enums.Status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){
        Tecnico tecnico = new Tecnico(null,"Jonas Silveira", "13664666240", "jonas@gmail.com", encoder.encode("teste"));
        tecnico.addPerfil(Perfil.ADMIN);

        Cliente cliente = new Cliente(null, "Rubens Nascimento", "63185578147", "rubens@gmail.com", encoder.encode("teste"));

        Chamado c1 = new Chamado();
        c1.setCliente(cliente);
        c1.setTecnico(tecnico);
        c1.setPrioridade(Prioridade.MEDIA);
        c1.setTitulo("Ajustar Impressora");
        c1.setStatus(Status.ANDAMENTO);
        c1.setDataAbertura(LocalDate.now());
        c1.setObservacoes("Testar");

        tecnicoRepository.save(tecnico);
        clienteRepository.save(cliente);
        chamadoRepository.save(c1);
    }
}