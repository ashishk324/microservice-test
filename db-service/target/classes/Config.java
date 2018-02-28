import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
