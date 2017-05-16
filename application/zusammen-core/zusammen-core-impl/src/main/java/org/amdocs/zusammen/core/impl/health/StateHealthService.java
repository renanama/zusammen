package org.amdocs.zusammen.core.impl.health;

import org.amdocs.zusammen.commons.health.data.HealthInfo;
import org.amdocs.zusammen.commons.health.service.HealthCheckService;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.response.ZusammenException;

public class StateHealthService extends HealthCheckService<SessionContext>  implements HealthFactorySupplier {

    public StateHealthService() {
        super(StateHealthService.class.getSimpleName());
    }

    @Override
    protected HealthInfo checkHealth(SessionContext context) throws ZusammenException {
        return getHealthAdaptorFactory(context).getStateStatus(context);
    }
}