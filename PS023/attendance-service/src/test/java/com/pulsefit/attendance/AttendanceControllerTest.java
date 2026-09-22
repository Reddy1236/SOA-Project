package com.pulsefit.attendance;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test; import org.springframework.web.client.RestClient;
class AttendanceControllerTest {
 @Test void allStartsEmpty(){ AttendanceRepository repo=mock(AttendanceRepository.class); RestClient.Builder b=mock(RestClient.Builder.class); when(repo.findAll()).thenReturn(java.util.List.of()); assertTrue(new AttendanceController(repo,b).all().isEmpty()); }
}
