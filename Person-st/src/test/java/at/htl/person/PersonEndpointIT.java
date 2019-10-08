package at.htl.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PersonEndpointIT {
    private Client client;
    private WebTarget target;

    @BeforeEach
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = this.client.target("http://localhost:8080/api/person");
    }

    @Test
    public void get(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();

        int status = response.getStatus();
        System.out.println(status);
        assertThat(status, is(200));

        JsonArray payload = response.readEntity(JsonArray.class);
        assertThat(payload.size(), is(3));
    }
}
