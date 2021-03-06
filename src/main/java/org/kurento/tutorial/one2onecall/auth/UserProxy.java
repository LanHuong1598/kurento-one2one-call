package org.kurento.tutorial.one2onecall.auth;

import feign.Feign;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.com.itechcorp.base.api.response.APIResponse;

import javax.validation.Valid;

@FeignClient(name = "userProxy", url = "${app.setting.core.remoteUrl}", configuration = UserProxy.UserProxyConfiguration.class)
public interface UserProxy {

    @PostMapping("/async/me/login")
    ResponseEntity<APIResponse<Object>> login(@Valid @RequestBody Credential credential);

    class UserProxyConfiguration {

        @Bean
        public Feign.Builder feignBuilder() {
            return Feign.builder()
                    .logLevel(Logger.Level.FULL)
                    .errorDecoder(new FeignErrorDecoder());
        }
    }
}
