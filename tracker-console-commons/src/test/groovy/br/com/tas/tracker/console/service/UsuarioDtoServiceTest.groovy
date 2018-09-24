package br.com.tas.tracker.console.service

import br.com.tas.tracker.console.exceptions.UserEmailCharsException
import br.com.tas.tracker.console.exceptions.UserEmailNullException
import br.com.tas.tracker.console.exceptions.UserNomeLimitCharsException
import br.com.tas.tracker.console.exceptions.UserNomeNullException
import br.com.tas.tracker.console.exceptions.UserPermissaoNullException
import br.com.tas.tracker.console.exceptions.UserSenhaCharsException
import br.com.tas.tracker.console.exceptions.UserSenhaNullException

import br.com.tas.tracker.console.services.UsuarioService
import spock.lang.Specification

class UsuarioDtoServiceTest extends Specification{

    def 'deve testar o método validateFields'(){
        given:
        UsuarioDto userNomeNulo = new UsuarioDto(1, null, 'guilherme@tas.com',
                '12345678', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userNomeChars= new UsuarioDto(1, '111111111111111111111111111111111111111111111111111' +
                '11111111111111111111111111111111111111111111111111111111', 'guilherme@tas.com',
                '1234567890', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userEmailNulo = new UsuarioDto(1, 'Guilherme', null,
                '1234567890', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userEmailChars = new UsuarioDto(1, 'Guilherme', '11111111111111111111111111111111111111111111' +
                '11111111111111111111111111111111111111111111111111111111',
                '1234567890', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userEmailUnique = new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '1234567890', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userSenhaNull = new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                null, new PermissaoDto(1, 'Administrador'))
        UsuarioDto userSenhaCharsMenor = new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userSenhaCharsMaior = new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '1234567890123456', new PermissaoDto(1, 'Administrador'))
        UsuarioDto userPermissaoNull = new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '12345678', null)
        /*INSTANCIANDO O SERVICE*/
        def service = new UsuarioService()
        /*CRIANDO MOCK DO DAO*//*
        UsuarioDao dao = Mock()
        //definindo os comportamentos
        dao.findByEmail('guilherme@tas.com') >> new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new PermissaoDto(1, 'Administrador'))
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
