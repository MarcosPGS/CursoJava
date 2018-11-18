package com.marcos.sc.Negocio;

import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;
import com.marcos.sc.Entity.Pessoa;
import com.marcos.sc.Repository.PessoaRepositoryQuery;
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

@Repository
public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

   @PersistenceContext
   private EntityManager manager;

   @Override
    public Pessoa buscaCpf(String cpf) {
       Pessoa pessoaEncontrada = null;

       try {


           CriteriaBuilder builder = manager.getCriteriaBuilder();// CriteriaBuilder - contrutor de comando (delete,insete,like)
           CriteriaQuery<Pessoa> pessoaCr = builder.createQuery(Pessoa.class);//CriteriaQuery - Repesentante da tabela

           Root<Pessoa> pessoaRoot = pessoaCr.from(Pessoa.class);//Root -repesentante da tabela que permite fazer um join

           Predicate[] predicates = criarRestricoes(cpf, builder, pessoaRoot);//Predicate são restrições (where,and, or, in)
           pessoaCr.where(predicates);

           TypedQuery<Pessoa> query = manager.createQuery(pessoaCr);//TypedQuery -valida as escritas do banco

           pessoaEncontrada = query.getSingleResult();//execulto o escripe posso usar Single ou Lis<>

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
}
