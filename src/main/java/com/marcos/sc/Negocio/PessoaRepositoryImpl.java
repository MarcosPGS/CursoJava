package com.marcos.sc.negocio;

import org.springframework.stereotype.Repository;
import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.repository.PessoaRepositoryQuery;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository // essa anotação @Repository serve para dizer que minha classe é uma repository
public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

   @PersistenceContext
   private EntityManager manager;//gerenciador do banco de dados
   // EntityManager - é o recurso responsável por realizar as operações de sincronismo com o banco de dados
   //(inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
    //===========================================BUSCA POR CPF=============================================
   @Override  // essa anotação @Override serve para sobreescrever um metodo
    public Pessoa buscaCpf(String cpf) {
      Pessoa pessoaEncontrada = null;

       try {


           CriteriaBuilder builder = manager.getCriteriaBuilder();// CriteriaBuilder - construtor de comando (delete,insete,like)
           CriteriaQuery<Pessoa> pessoaCr = builder.createQuery(Pessoa.class);//CriteriaQuery - Repesentante da tabela

           Root<Pessoa> pessoaRoot = pessoaCr.from(Pessoa.class);//Root -repesentante da tabela que permite fazer um join

           Predicate[] predicates = criarRestricoes(cpf, builder, pessoaRoot);//Predicate são Construtor de restrições (where,and, or, in)
           pessoaCr.where(predicates);

           TypedQuery<Pessoa> query = manager.createQuery(pessoaCr);//TypedQuery -valida as escritas do banco

           pessoaEncontrada = query.getSingleResult();//execulto o escripiti, posso usar Single ou Lis<>

           return pessoaEncontrada;


       } catch (Exception e) {
           return pessoaEncontrada ;
       }
   }



    private Predicate[] criarRestricoes(String cpf, CriteriaBuilder builder, Root<Pessoa> pessoaRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(!StringUtils.isEmpty(cpf)){
            predicates.add(builder.equal(pessoaRoot.get("cpf"),cpf));

        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }


//===========================================BUSCA PESSOA ATIVA=============================================
    @Override
    public List<Pessoa> buscarAtivos(String ativo){

       List<Pessoa> pessoaEncontradaAtiva = null;

       try{
           CriteriaBuilder builder = manager.getCriteriaBuilder();
           CriteriaQuery<Pessoa> pessoaCr = builder.createQuery(Pessoa.class);

           Root<Pessoa> pessoaRoot = pessoaCr.from(Pessoa.class);

           Predicate[] predicates = RestricoesAtivos(ativo,builder, pessoaRoot);
           pessoaCr.where(predicates);


           TypedQuery<Pessoa> query = manager.createQuery(pessoaCr);

           pessoaEncontradaAtiva = (List<Pessoa>) query.getResultList();
           return (List<Pessoa>) pessoaEncontradaAtiva;

       }catch (Exception e){
           return (List<Pessoa>) pessoaEncontradaAtiva;

       }

    }

    private Predicate[] RestricoesAtivos(String ativo, CriteriaBuilder builder, Root<Pessoa> pessoaRoot) {
       List<Predicate> predicates = new ArrayList<>();
       if ((!StringUtils.isEmpty(ativo)) && ((ativo).equals("s"))){
           predicates.add(builder.equal(pessoaRoot.get("ativo"),ativo));
       }
       return predicates.toArray(new Predicate[predicates.size()]);
    }
}
