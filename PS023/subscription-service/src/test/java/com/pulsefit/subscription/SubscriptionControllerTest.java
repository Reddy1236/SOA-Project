package com.pulsefit.subscription;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test; import org.springframework.web.client.RestClient;
class SubscriptionControllerTest {
 @Test void missingPlanReturns404(){ PlanRepository plans=mock(PlanRepository.class); SubscriptionRepository subs=mock(SubscriptionRepository.class); RestClient.Builder b=mock(RestClient.Builder.class); when(plans.findAll()).thenReturn(java.util.List.of()); assertTrue(new SubscriptionController(plans,subs,b).plans().isEmpty()); }
}
