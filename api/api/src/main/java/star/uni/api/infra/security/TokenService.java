package star.uni.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import star.uni.api.domain.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
//HMAC256 é tipo de algoritmo que gera o token e "12345678" é a senha que o gera
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    //a api do token
                    .withIssuer("API uni.star")
                    //o alvo do token
                    .withSubject(usuario.getLogin())
                    //quando o token expira
                    .withExpiresAt(dataExpiracao())
                    //o tipo de algoritimo de geração + a senha
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }

    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API uni.star")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }}


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }



}