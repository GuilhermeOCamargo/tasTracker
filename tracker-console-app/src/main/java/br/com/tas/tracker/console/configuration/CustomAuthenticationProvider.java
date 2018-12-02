package br.com.tas.tracker.console.configuration;

import java.util.ArrayList;
import java.util.Collection;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.services.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
/**
 * @author guilherme.camargo
 * @since 16/10/2018
 * @version 1.0
 * */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UsuarioService usuarioService;

    private static final Logger log = Logger.getLogger(CustomAuthenticationProvider.class);

    public Authentication authenticate(Authentication authentication) throws AuthenticationException, UsernameNotFoundException {

        String email = authentication.getName().toLowerCase();
        String password = authentication.getCredentials().toString();
        log.info("validando usuario: " + email);

        Usuario usuario = usuarioService.authenticate(email, password);
        if(usuario == null){
            log.error("Autenticação falhou");
            return null;
        }


        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        auths.add(new SimpleGrantedAuthority("ROLE_" + usuario.getPermissao().getNome().toUpperCase()));

        return new UsernamePasswordAuthenticationToken(email, password, auths);

    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

    }

}
