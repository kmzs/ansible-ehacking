package de.hackmanit.keycloak.executor;

import java.util.List;

import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.services.clientpolicy.executor.ClientPolicyExecutorProvider;
import org.keycloak.services.clientpolicy.executor.ClientPolicyExecutorProviderFactory;

/**
 * Based on org.keycloak.services.clientpolicy.executor.SecureResponseTypeExecutorFactory by <a href="mailto:takashi.norimatsu.ws@hitachi.com">Takashi Norimatsu</a>
 */
public class CustomSecureResponseTypeExecutorFactory implements ClientPolicyExecutorProviderFactory {

    public static final String PROVIDER_ID = "all-secure-response-types";

    @Override
    public ClientPolicyExecutorProvider create(KeycloakSession session) {
        return new CustomSecureResponseTypeExecutor(session);
    }

    @Override
    public void init(Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getHelpText() {
        return "The executor checks whether the authorization request contains one of the secure response types: \"code\", \"id_token\", or \"code+id_token\"";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return null;
    }

}