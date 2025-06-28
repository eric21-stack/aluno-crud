package com.seuprojeto.aluno_crud.Controller;

import com.seuprojeto.aluno_crud.Model.Aluno;
import com.seuprojeto.aluno_crud.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")

public class AlunoController {

    private AlunoService Service;

    public AlunoController(AlunoService Service) {
        this.Service = Service;
    }
    @GetMapping
    public List<Aluno> Listar(){
        return Service.ListarTodos();
    }
    @PostMapping
    public Aluno criar(@RequestBody Aluno Aluno){
        return Service.salvar(Aluno);
    }
    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id){
        return Service.buscar(id);
    }
    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno){
        Aluno alunoExistente = Service.buscar(id);
        if (alunoExistente == null)return null;

        alunoExistente.setNome(novoAluno.getNome());
        alunoExistente.setEmail(novoAluno.getEmail());
        alunoExistente.setTelefone(novoAluno.getTelefone());
        return Service.salvar(alunoExistente);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        Service.deletar(id);

    }
}
