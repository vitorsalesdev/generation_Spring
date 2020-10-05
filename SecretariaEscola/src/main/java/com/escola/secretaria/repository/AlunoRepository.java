package com.escola.secretaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escola.secretaria.model.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
}
