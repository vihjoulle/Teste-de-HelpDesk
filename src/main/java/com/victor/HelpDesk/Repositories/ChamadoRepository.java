package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
