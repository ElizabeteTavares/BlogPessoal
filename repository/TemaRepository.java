package com.blogPessoalItau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogPessoalItau.model.Tema;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    public List<Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
