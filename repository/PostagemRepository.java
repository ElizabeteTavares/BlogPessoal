package com.blogPessoalItau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogPessoalItau.model.Postagem;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

    public List<Postagem> findAllByTextoContainingIgnoreCase(@Param("texto") String texto);

}
