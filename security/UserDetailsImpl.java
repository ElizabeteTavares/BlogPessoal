package com.blogPessoalItau.security;

import com.blogPessoalItau.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;


public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private  String userName;
    private String password;

    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(Usuario user) {
        this.userName = user.getUsuario();
        this.password = user.getSenha();
    }
    public UserDetailsImpl () {}


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }
    public boolean isCredentialsNonExpired(){
        return true;
    }
    public boolean isEnabled() {
        return true;
    }

}
