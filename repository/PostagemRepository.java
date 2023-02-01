package com.blogPessoalItau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogPessoalItau.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}
