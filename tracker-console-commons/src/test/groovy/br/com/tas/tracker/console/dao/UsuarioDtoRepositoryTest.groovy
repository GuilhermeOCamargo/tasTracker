package br.com.tas.tracker.console.dao


import spock.lang.Specification

class UsuarioDtoRepositoryTest extends Specification{

    def 'criação de mocks'(){
        given:
        //Criando um mock do UsuarioDao
        def repository = Mock(UsuarioDao)

        //definindo os comportamentos
        repository.findById(1) >> new UsuarioDto(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new PermissaoDto(1, 'Administrador'))
        repository.findById(2) >> new UsuarioDto(2, 'Ana', 'ana@tas.com',
                '1234', new PermissaoDto(2, 'Visualizador'))

        when:
        def usuario1 = repository.findById(1)

        then:
        usuario1.id == 1
        usuario1.email == 'guilherme@tas.com'

        when:
        def usuario2 = repository.findById(2)

        then:
        usuario2.id == 2
        usuario2.email == 'ana@tas.com'
    }
}
