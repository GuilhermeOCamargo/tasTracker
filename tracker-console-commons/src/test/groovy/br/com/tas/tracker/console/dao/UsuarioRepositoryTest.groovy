package br.com.tas.tracker.console.dao

import br.com.tas.tracker.console.model.Permissao
import br.com.tas.tracker.console.model.Usuario
import spock.lang.Specification

class UsuarioRepositoryTest extends Specification{

    def 'criação de mocks'(){
        given:
        //Criando um mock do UsuarioDao
        def repository = Mock(UsuarioDao)

        //definindo os comportamentos
        repository.findById(1) >> new Usuario(1, 'Guilherme', 'guilherme@tas.com',
                '1234', new Permissao(1, 'Administrador'))
        repository.findById(2) >> new Usuario(2, 'Ana', 'ana@tas.com',
                '1234', new Permissao(2, 'Visualizador'))

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
