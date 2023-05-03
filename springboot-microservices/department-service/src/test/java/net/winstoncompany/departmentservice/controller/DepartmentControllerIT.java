package net.winstoncompany.departmentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.winstoncompany.departmentservice.DepartmentServiceApplication;
import net.winstoncompany.departmentservice.dto.DepartmentDto;
import org.assertj.core.api.WithAssertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Winston Evans
 * @date 4/30/2023 12:42 PM
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DepartmentServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerIT implements WithAssertions {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testFindDepartmentByCode() throws JSONException, JsonProcessingException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<DepartmentDto> response = restTemplate.exchange(
                createURLWithPort("/api/departments/IT001"),
                HttpMethod.GET, entity, DepartmentDto.class);


        DepartmentDto expected = new DepartmentDto(1L,"IT","Information Technology", "IT001");
        assertThat(response.getBody())
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}