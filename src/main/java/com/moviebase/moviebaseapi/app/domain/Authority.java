package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.BasicGeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authority extends BasicGeneralEntity implements GrantedAuthority {
    @Enumerated(EnumType.STRING)
    private AuthorityEnum authority;

    @Override
    public String getAuthority() {
        return authority.name();
    }
}
