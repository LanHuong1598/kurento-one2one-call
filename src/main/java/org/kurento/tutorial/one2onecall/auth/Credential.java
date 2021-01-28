package org.kurento.tutorial.one2onecall.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.repository.dto.Dto;

import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor
public class Credential extends Dto {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
