package br.com.zupacademy.alana.casadocodigo.validators.AnotacoesPersonalizadas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistIdValidator implements ConstraintValidator<ExistisId, Object> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> classe;

    @Override
    public void initialize(ExistisId constraintAnnotation) {
        classe = constraintAnnotation.classe();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+ classe.getSimpleName() +" t where t.id=:value");
        query.setParameter("value", value);
        return query.getResultList().size() > 0;
    }
}
