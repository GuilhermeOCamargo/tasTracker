package br.com.tas.tracker.console.service

import br.com.tas.tracker.console.dao.UsuarioDao
import br.com.tas.tracker.console.exceptions.UserEmailCharsException
import br.com.tas.tracker.console.exceptions.UserEmailNullException
import br.com.tas.tracker.console.exceptions.UserEmailUniqueException
import br.com.tas.tracker.console.exceptions.UserNomeLimitCharsException
import br.com.tas.tracker.console.exceptions.UserNomeNullException
import br.com.tas.tracker.console.exceptions.UserPermissaoNullException
import br.com.tas.tracker.console.exceptions.UserSenhaCharsException
import br.com.tas.tracker.console.exceptions.UserSenhaNullException
import br.com.tas.tracker.console.model.Permissao
import br.com.tas.tracker.console.model.Usuario
import br.com.tas.tracker.console.services.UsuarioService
import spock.lang.Specification

class UsuarioServiceTest extends Specification{

    def 'deve testar o método validateFields'(){
        given:
        Usuario userNomeNulo = new Usuario(1, null, 'guilherme@tas.com',
                '12345678', new Permissao(1, 'Administrador'))
        Usuario userNomeChars= new Usuario(1, '111111111111111111111111111111111111111111111111111' +
                '11111111111111111111111111111111111111111111111111111111', 'guilherme@tas.com',
                '1234567890', new Permissao(1, 'Administrador'))
        Usuario userEmailNulo = new Usuario(1, 'Guilherme', null,
                '1234567890', new Permissao(1, 'Administrador'))
        Usuario userEmailChars = new Usuario(1, 'Guilherme', '11111111111111111111111111111111111111111111' +
                '11111111111111111111111111111111111111111111111111111111',
                '1234567890', new Permissao(1, 'Administrador'))
        Usuario userEmailUnique = new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '1234567890', new Permissao(1, 'Administrador'))
        Usuario userSenhaNull = new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                null, new Permissao(1, 'Administrador'))
        Usuario userSenhaCharsMenor = new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new Permissao(1, 'Administrador'))
        Usuario userSenhaCharsMaior = new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '1234567890123456', new Permissao(1, 'Administrador'))
        Usuario userPermissaoNull = new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '12345678', null)
        /*INSTANCIANDO O SERVICE*/
        def service = new UsuarioService()
        /*CRIANDO MOCK DO DAO*//*
        UsuarioDao dao = Mock()
        //definindo os comportamentos
        dao.findByEmail('guilherme@tas.com') >> new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new Permissao(1, 'Administrador'))
        *//*ATRIBUINDO O MOCK AO SERVICE*//*
        service.userDao = dao*/

        when:
        service.validateFields(userNomeNulo)

        then:
        thrown(UserNomeNullException)

        when:
        service.validateFields(userNomeChars)

        then:
        thrown(UserNomeLimitCharsException)

        when:
        service.validateFields(userEmailNulo)

        then:
        thrown(UserEmailNullException)

        when:
        service.validateFields(userEmailChars)

        then:
        thrown(UserEmailCharsException)

        /*when:
        service.validateFields(userEmailUnique)

        then:
        thrown(UserEmailUniqueException)*/

        when:
        service.validateFields(userSenhaNull)

        then:
        thrown(UserSenhaNullException)

        when:
        service.validateFields(userSenhaCharsMenor)

        then:
        thrown(UserSenhaCharsException)

        when:
        service.validateFields(userSenhaCharsMaior)

        then:
        thrown(UserSenhaCharsException)

        when:
        service.validateFields(userPermissaoNull)

        then:
        thrown(UserPermissaoNullException)
    }
}
