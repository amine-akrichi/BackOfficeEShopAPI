package org.example.backofficeeshop.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.example.backofficeeshop.model.Permession.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,

                    LOGISTIQUE_READ,
                    LOGISTIQUE_CREATE,
                    LOGISTIQUE_UPDATE,
                    LOGISTIQUE_DELETE,

                    MARKETING_READ,
                    MARKETING_CREATE,
                    MARKETING_UPDATE,
                    MARKETING_DELETE



            )

    ),
    MARKETING(
            Set.of(
                    MARKETING_READ,
                    MARKETING_CREATE,
                    MARKETING_UPDATE,
                    MARKETING_DELETE
                    )

    ),
    LOGISTIQUE(
            Set.of(
                    LOGISTIQUE_READ,
                    LOGISTIQUE_CREATE,
                    LOGISTIQUE_UPDATE,
                    LOGISTIQUE_DELETE
            )

    )
    ;


    @Getter
    private final Set<Permession> permessions;


    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities=getPermessions()
                .stream()
                .map(permession -> new SimpleGrantedAuthority(permession.getPermession()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
