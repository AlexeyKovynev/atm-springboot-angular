package name.javalex.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import name.javalex.springboot.auth.TokenHandler;
import name.javalex.springboot.service.SecurityContextService;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenHandler tokenHandler;
    private final SecurityContextService securityContextService;

    @Autowired
    AuthController(AuthenticationManager authenticationManager,
                   TokenHandler tokenHandler,
                   SecurityContextService securityContextService) {
        this.authenticationManager = authenticationManager;
        this.tokenHandler = tokenHandler;
        this.securityContextService = securityContextService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AuthResponse auth(@RequestBody AuthParams params) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return securityContextService.currentUser().map(u -> {
            final String token = tokenHandler.createTokenForUser(u);
            return new AuthResponse(token);
        }).orElseThrow(new Supplier<RuntimeException>() {  // will not happen.
            @Override
            public RuntimeException get() {
                return new RuntimeException();
            }
        });
    }

    private static final class AuthParams {
        private String email;
        private String password;

        public AuthParams() {
        }

        public AuthParams(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        UsernamePasswordAuthenticationToken toAuthenticationToken() {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
    }

    private static final class AuthResponse {
        private String token;

        public AuthResponse() {
        }

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
