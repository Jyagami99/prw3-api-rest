package br.edu.ifsp.prw3.p3.controller;


import br.edu.ifsp.prw3.p3.user.Usuario;
import br.edu.ifsp.prw3.p3.user.dadosAuthentication;
import br.edu.ifsp.prw3.p3.utils.security.DadosTokenJWT;
import br.edu.ifsp.prw3.p3.utils.security.PW3TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PW3TokenService pw3TokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid dadosAuthentication dados) {

        var token = new UsernamePasswordAuthenticationToken( dados.login(),
                dados.senha() );

        var authentication = authenticationManager.authenticate(token);

        var tokenJWT = pw3TokenService.gerarToken( (Usuario) authentication.getPrincipal() );

        return ResponseEntity.ok( new DadosTokenJWT(tokenJWT) );
    }
}
