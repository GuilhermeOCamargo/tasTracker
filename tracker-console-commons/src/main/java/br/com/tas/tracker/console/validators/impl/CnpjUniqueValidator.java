package br.com.tas.tracker.console.validators.impl;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.services.EmpresaService;
import br.com.tas.tracker.console.validators.annotations.CnpjUniqueValid;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author guilherme.camargo
 * @since 11/10/2018
 * @version 1.0
 * */
public class CnpjUniqueValidator implements ConstraintValidator<CnpjUniqueValid, Object> {

    @Autowired
    private EmpresaService empresaService;
    private String cnpj, message, id;

    @Override
    public void initialize(CnpjUniqueValid constraintAnnotation) {
        this.cnpj = constraintAnnotation.cnpj();
        this.id = constraintAnnotation.id();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        try{
            final String cnpj = BeanUtils.getProperty(o, this.cnpj);
            final String id = BeanUtils.getProperty(o, this.id);
            Empresa empresa = empresaService.findByCnpj(cnpj.replace(".", "")
                    .replace("/", "").replace("-", ""));
            if(empresa != null){
                if(id != null || !id.isEmpty()){
                    if(!empresa.getId().equals(Long.parseLong(id))){
                        result = false;
                    }
                }
            }
        }catch (Exception e){
            result = false;
        }
        if(!result){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("cnpj").addConstraintViolation();
        }
        return result;
    }
}
