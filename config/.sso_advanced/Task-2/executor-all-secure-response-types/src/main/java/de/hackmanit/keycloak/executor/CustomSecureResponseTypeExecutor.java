package de.hackmanit.keycloak.executor;

import org.jboss.logging.Logger;
import org.keycloak.OAuthErrorException;
import org.keycloak.models.KeycloakSession;
import org.keycloak.protocol.oidc.utils.OIDCResponseType;
import org.keycloak.representations.idm.ClientPolicyExecutorConfigurationRepresentation;
import org.keycloak.services.clientpolicy.ClientPolicyContext;
import org.keycloak.services.clientpolicy.ClientPolicyException;
import org.keycloak.services.clientpolicy.context.AuthorizationRequestContext;
import org.keycloak.services.clientpolicy.executor.ClientPolicyExecutorProvider;

/**
 * Based on org.keycloak.services.clientpolicy.executor.SecureResponseTypeExecutor by <a href="mailto:takashi.norimatsu.ws@hitachi.com">Takashi Norimatsu</a>
 */
public class CustomSecureResponseTypeExecutor implements ClientPolicyExecutorProvider<ClientPolicyExecutorConfigurationRepresentation> {

    private static final Logger logger = Logger.getLogger(CustomSecureResponseTypeExecutor.class);

    protected final KeycloakSession session;

    public CustomSecureResponseTypeExecutor(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public String getProviderId() {
        return CustomSecureResponseTypeExecutorFactory.PROVIDER_ID;
    }

    @Override
    public void executeOnEvent(ClientPolicyContext context) throws ClientPolicyException {
        switch (context.getEvent()) {
            case AUTHORIZATION_REQUEST:
                AuthorizationRequestContext authorizationRequestContext = (AuthorizationRequestContext)context;
                executeOnAuthorizationRequest(authorizationRequestContext.getparsedResponseType());
                break;
            default:
        }
        return;
    }

    // For object definition of OIDCResponseType see: https://www.keycloak.org/docs-api/26.1.4/javadocs/org/keycloak/protocol/oidc/utils/OIDCResponseType.html

    // on Authorization Endpoint access for authorization request
    public void executeOnAuthorizationRequest(OIDCResponseType parsedResponseType) throws ClientPolicyException {

        // Modify this simplified version of the built-in executor "secure-response-type" for your solution:
        if (parsedResponseType.hasResponseType(OIDCResponseType.CODE) && parsedResponseType.hasResponseType(OIDCResponseType.ID_TOKEN)) {
            if (parsedResponseType.hasResponseType(OIDCResponseType.TOKEN)) {
                logger.trace("Passed. response_type = code id_token token");
                return;
            } else {
                logger.trace("Passed. response_type = code id_token");
                return;
            }
        }

        logger.tracev("invalid response_type = {0}", parsedResponseType);
        throw new ClientPolicyException(OAuthErrorException.INVALID_REQUEST, "invalid response_type");
    }

}