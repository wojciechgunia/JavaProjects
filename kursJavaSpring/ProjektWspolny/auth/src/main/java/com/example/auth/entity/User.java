package com.example.auth.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@NoArgsConstructor
@Table
@Entity
public class User implements UserDetails
{
    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq",allocationSize = 1)
    private long id;
    private String uuid;
    private String login;
    private String email;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isLock;
    private boolean isEnabled;

    public User(long id, String uuid, String login, String email, String password, Role role, boolean isLock, boolean isEnabled)
    {
        this.id = id;
        this.uuid = uuid;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isLock = isLock;
        this.isEnabled = isEnabled;
        generateUuid();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return login;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return false;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return !isLock;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return false;
    }

    @Override
    public boolean isEnabled()
    {
        return isEnabled;
    }

    private void generateUuid()
    {
        if(uuid == null || uuid.equals(""))
        {
            setUuid(UUID.randomUUID().toString());
        }
    }
}
