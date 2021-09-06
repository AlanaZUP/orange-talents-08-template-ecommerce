package com.orangetalents.mercadolivre.comms.anotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String nomeCampo;
    private Class<?> classe;

    @Override
    public void initialize(CampoUnico constraintAnnotation) {
        nomeCampo = constraintAnnotation.nomeCampo();
        classe = constraintAnnotation.classe();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+ classe.getName() +" t where t."+ nomeCampo +"=:value");
        query.setParameter("value", value);
        if (query.getResultList().size() > 0){
            return false;
        }
        return true;
    }
}
