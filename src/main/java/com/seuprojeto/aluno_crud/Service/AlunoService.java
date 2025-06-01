package com.seuprojeto.aluno_crud.Service;

import com.seuprojeto.aluno_crud.Interface.AlunoRepository;
import com.seuprojeto.aluno_crud.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository Repository;

    public AlunoService(AlunoRepository Repository){
        this.Repository = Repository;
    }

    public List<Aluno> ListarTodos(){
        return Repository.findAll();
    }
    public Aluno salvar(Aluno aluno){
        return Repository.save(aluno);
    }
    public void deletar(long id){
        Repository.deleteById(id);
    }
    public Aluno buscar(long id){
        return Repository.findById(id).orElse(null);
    }
}
