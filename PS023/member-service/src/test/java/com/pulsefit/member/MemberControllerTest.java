package com.pulsefit.member;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test; import org.springframework.http.ResponseEntity;
class MemberControllerTest {
 @Test void getMissingMemberReturns404(){ MemberRepository repo=mock(MemberRepository.class); when(repo.findById(999L)).thenReturn(java.util.Optional.empty()); var response=new MemberController(repo).get(999L); assertEquals(404,response.getStatusCode().value()); }
}
